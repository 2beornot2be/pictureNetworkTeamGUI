package gui.pictureNetwork.boot.tools;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ServiceLocator {

	private static ServiceLocator myInstance;
	private Context ctx;
	private Map<String, Object> proxiesCache;

	private ServiceLocator() {

		try {

			ctx = new InitialContext();

		} catch (NamingException e) {

			e.printStackTrace();
		}

		proxiesCache = Collections
				.synchronizedMap(new HashMap<String, Object>());
	}

	public static ServiceLocator getInstance() {

		if (null == myInstance)
			myInstance = new ServiceLocator();

		return myInstance;
	}

	public Object lookupProxy(String JNDIName) {

		Object proxy = null;

		if (proxiesCache.containsKey(JNDIName)) {
			proxy = proxiesCache.get(JNDIName);

		} else {

			try {
				proxy = ctx.lookup(JNDIName);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			proxiesCache.put(JNDIName, proxy);
		}

		return proxy;

	}
}
