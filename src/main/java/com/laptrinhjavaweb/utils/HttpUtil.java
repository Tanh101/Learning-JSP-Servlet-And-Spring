package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil extends HttpServlet {
	
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public<T> T toModel(Class<T> tClass){
		
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static HttpUtil of (BufferedReader reader) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return new HttpUtil(sb.toString());
	}
}
