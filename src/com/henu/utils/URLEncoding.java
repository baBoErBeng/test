package com.henu.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoding {

	public static String testEncode(String key) {
			String urlEncodee = null;
			try {
				urlEncodee = URLEncoder.encode(key,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return urlEncodee;
	    }
}
