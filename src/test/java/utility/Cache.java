package utility;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	private static Map<String, Object> cache;
	
	public static Object getData(String key) {
		if(cache!=null) {
			return cache.get(key);
		}
		return null;
	}
	public static Object setData(String key,Object value) {
		if(cache==null) {
			cache=new HashMap<String, Object>();
			
			}
		return cache.put(key, value);
		
	}
	
	public static void mapentries() {
	
		for (Map.Entry entry : cache.entrySet()) {
			System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());		}
	}
	

}
