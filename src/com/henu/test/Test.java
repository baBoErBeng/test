package com.henu.test;

import com.henu.utils.Proxy;
import com.henu.utils.*;
public class Test {
	/**
	 * 爬取西刺代理的高匿IP
	 */
	public void getProxyIP() {
		String url = "https://www.xicidaili.com/nn/";
		int i = 1;
		/*
		 * TreeMap<String,Integer> a = new TreeMap<String,Integer>();
		 * a.put("42.62.180.0",22); Test.checkProxyIp(a);
		 */
		while (true) {
			Proxy.getip(url + String.valueOf(i));
			System.out.println("**********开始检测第" + i + "页ip*****************");
			Proxy.checkProxyIp(Proxy.proxyIpMap);
			System.out.println("**********检测结束*****************");
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread Error!!!");
			}
		}

	}
	/**
	 * 天眼查爬虫
	 * @param param
	 */
	public void getTYC(String param,String base) {
		ExcelWrite ew = new ExcelWrite();
		ew.outExcel(param,base);
	}

	public static void main(String[] args) {
		
	}

}
