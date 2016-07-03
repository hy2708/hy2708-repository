package org.hy.commons.web.mime;

import java.util.HashMap;
import java.util.Map;

public class MimeTypes extends jodd.util.MimeTypes{
	static{
		HashMap<String, String> map = MimeType.getStreamType();
		registerMimeType(map);
	}
	public static void registerMimeType(Map<String, String> map) {
		for ( String key : map.keySet()) {			
			registerMimeType(key, map.get(key));
		}
	}

}
