package com.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.domain.Item;

import test.jdbc.JdbcUtils;
import test.method.AESOperator;

public class JsonDao {
	
	
	public List<Item> getbase64() throws SQLException {
		
		List<Item> list = new ArrayList<>();
		Connection con = JdbcUtils.getConnection();
		// System.out.println("connection = "+con);
		
		// String sql =" SELECT idx,c_base64 FROM M2.Table1 ";	
		String sql =" select idx,c_base64 from Table1 ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			Item item = new Item();
			item.setIdx(rs.getInt(1));
			item.setC_base64(rs.getString(2));
			list.add(item);
		}
		
		
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();
		if(con != null)con.close();
		
		return list;
	}

	public int addBase(String jsonString) throws SQLException, UnsupportedEncodingException {
		int count = 0;
	
		Connection con = JdbcUtils.getConnection();
		String sql =" insert into Table1(c_aes256,c_base64) values(null,?) ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		final Base64.Encoder encoder = Base64.getEncoder();
		final byte[] textByte = jsonString.getBytes("UTF-8");
		//編碼
		final String encodedText = encoder.encodeToString(textByte);
		
		pstmt.setString(1, encodedText);
		
		count = pstmt.executeUpdate();
		
		return count;
	}

	public List<Item> getAES256() throws SQLException {
		List<Item> list = new ArrayList<>();
		Connection con = JdbcUtils.getConnection();
		// System.out.println("connection = "+con);
		
		// String sql =" SELECT idx,c_base64 FROM M2.Table1 ";	
		String sql =" select idx,c_aes256 from Table1 ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			Item item = new Item();
			item.setIdx(rs.getInt(1));
			item.setC_aes256(rs.getString(2));
			list.add(item);
			System.out.println(rs.getInt(1) + rs.getString(2));
		}
		
		
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();
		if(con != null)con.close();
		
		return list;
	}

	public int addBase64AndAES256(String jsonString) throws Exception {
		int count = 0;
		
		Connection con = JdbcUtils.getConnection();
		String sql =" insert into Table1(c_aes256,c_base64) values(?,?) ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		String aesEncode = AESOperator.getInstance().encrypt(jsonString);
		
		final Base64.Encoder encoder = Base64.getEncoder();
		final byte[] textByte = jsonString.getBytes("UTF-8");
		final String base64Encoded = encoder.encodeToString(textByte);
		
		pstmt.setString(1, aesEncode);
		pstmt.setString(2, base64Encoded);
		
		count = pstmt.executeUpdate();
		
		return count;
		
	}
}
