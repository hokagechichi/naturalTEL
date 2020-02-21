package com.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import com.dao.JsonDao;
import com.domain.Item;

import test.method.AESOperator;

public class JsonService {
	
	static JsonDao jsonDao = null;

	static {
		jsonDao = new JsonDao();
	}
	
	public List<Item> getBase64() throws SQLException {		
		return jsonDao.getbase64();		
	}
	
	public int addBase64(String jsonString) {

		int count = 0;
		try {
			count =  jsonDao.addBase(jsonString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public List<Item> getAES256() {
		List<Item> list = null;
		try {
			list = jsonDao.getAES256();
			
			for(Item item:list) {
				try {
					String decryptJsonStr = AESOperator.getInstance().decrypt(item.getC_aes256());
					System.out.println("decryptJsonStr = "+decryptJsonStr);
					item.setC_aes256(decryptJsonStr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int addBase64AndAES256(String jsonString) {
		int count = 0;
		try {
			count = jsonDao.addBase64AndAES256(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
