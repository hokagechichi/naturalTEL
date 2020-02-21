package test.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

/**
 * name : 員工轉json字串測試
 */
public class EmployeeTest {

	public static void main(String[] arg) {
		// 單筆
		Employee employee01 = new Employee("bryan", 30000);
		Employee employee02 = new Employee("joe", 31000);
		employee02.setSex("N");
		Gson gson = new Gson();
		String jsonStr1 = gson.toJson(employee01);
		String jsonStr2 = gson.toJson(employee01, Employee.class);
		System.out.println("jsonStr1:" + jsonStr1);
		System.out.println("jsonStr2:" + jsonStr2);

		// 多筆
		List list = new ArrayList();
		list.add(employee01);
		list.add(employee02);
		String jsonStr3 = gson.toJson(list);
		System.out.println("jsonStr3:" + jsonStr3);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(jsonStr1, map.getClass());
		System.out.println("map = " + map);

	}
	
	
	@Test
	public void jsonToObj() {
		Gson gson = new Gson();
        String employ_json = "{\"name\":\"bryan\",\"age\":0,\"salary\":30000.0}" ;
        Employee employee01 =  gson.fromJson(employ_json, Employee.class) ;
        System.out.println(employee01.toString());
	}
	
	
	@Test
	public void jsonToMap() {
		Gson gson = new Gson(); 
		String json = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(json, map.getClass());
		System.out.println(map);
	}
	
}