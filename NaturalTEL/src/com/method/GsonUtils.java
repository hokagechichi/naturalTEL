package com.method;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class GsonUtils {
	
	@Test
	public void jsonToMap() {
		Gson gson = new Gson(); 
		String json = null;
		// String json = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		// String json = "{\"text\":\"自然互動科技股份有限公司\"}";
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(json, map.getClass());
		System.out.println(map);
	}
	
	
	public static Map<String,String> jsonToMap(String json) {
		Gson gson = new Gson(); 		
		Map<String,Object> map = new HashMap<String,Object>();
		return (Map<String,String>) gson.fromJson(json, map.getClass());		
	}
	

	
}
