package com.domain;

public class Item {
	
	private int idx;
	private String c_aes256;
	private String c_base64;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getC_aes256() {
		return c_aes256;
	}
	public void setC_aes256(String c_aes256) {
		this.c_aes256 = c_aes256;
	}
	public String getC_base64() {
		return c_base64;
	}
	public void setC_base64(String c_base64) {
		this.c_base64 = c_base64;
	}
	@Override
	public String toString() {
		return "Item [idx=" + idx + ", c_aes256=" + c_aes256 + ", c_base64=" + c_base64 + "]";
	}
	
	
}
