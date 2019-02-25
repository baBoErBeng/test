package com.henu.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


public class Proxy {
	public static Map<String, Integer> proxyIpMap = new HashMap<String, Integer>();

	public static void saveip(String ip, int port) {
		File file = new File("c:\\proxyip.txt");// 读取文件
		try {
			FileWriter fw = new FileWriter(file, true);// 参数为true，表示追加内容
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(ip + ":" + String.valueOf(port));
			bw.newLine();// 换行
			System.out.println("保存ip:" + ip + ":" + port + "成功!!!");
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.print("保存ip失败");
		} catch (IOException e) {
			System.out.print("保存ip失败");
		}
	}

	public static void getip(String url) {
		// 链接西刺代理
		String web = ConnUtil.getPageContent(url);
		// 获取代理ip
		Pattern Patternip = Pattern.compile(
				"\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
		Pattern Patternport = Pattern.compile("<td>([0-9]{2,5})</td>");
		// Pattern Patternip = Pattern.compile("<td
		// data-title=\"IP\">.*?</td>");
		// 获取ip端口
		// Pattern Patternport = Pattern.compile("<td
		// data-title=\"PORT\">.*?</td>");
		Matcher matcherip = Patternip.matcher(web);
		Matcher matcherport = Patternport.matcher(web);
		// System.out.print(web);
		while (matcherip.find()) {
			matcherport.find();
			String groupip = matcherip.group();
			String groupport = matcherport.group();
			// String ip = groupip.substring(groupip.indexOf("<td") + 20,
			// groupip.indexOf("</td>"));
			// String port = groupport.substring(groupport.indexOf("<td") + 23,
			// groupport.indexOf("</td>"));
			String ip = groupip;
			String port = groupport.substring(groupport.indexOf("<td>") + 4, groupport.indexOf("</td>"));
			// System.out.print("ip:"+ip);
			// System.out.println("port:"+port);
			// System.out.println(port);
			// 把代理ip装入ip池
			proxyIpMap.put(ip, Integer.valueOf(port));

		}
	}

	public static void checkProxyIp(Map<String, Integer> proxyIpMap) {

		for (String proxyHost : proxyIpMap.keySet()) {
			Integer proxyPort = proxyIpMap.get(proxyHost);
			SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(false).setSoLinger(1)
					.setSoReuseAddress(true).setSoTimeout(5000).setTcpNoDelay(true).build();
			// CloseableHttpClient httpClient = HttpClients.createDefault();//
			//  创建httpClient实例
			HttpGet httpGet = new HttpGet("https://www.taobao.com/"); //  创建httpget实例
			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).setSocketTimeout(5000)
					.setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();
			CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultSocketConfig(socketConfig)
					.setDefaultRequestConfig(requestConfig).build();
			httpGet.setConfig(requestConfig);
			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
			CloseableHttpResponse response = null;
			try {
				System.out.print(proxyHost + ":");
				System.out.print(proxyPort);
				response = httpClient.execute(httpGet);
				//  执行http get请求
				response.getEntity();// 获取返回实体
				int status = response.getStatusLine().getStatusCode();
				// System.out.println("Response content: " +
				// EntityUtils.toString(entity, "UTF-8")); // 获取网页内容
				if (status == 200) {
					System.out.println("    SUCCESS     status: " + status);
					String realip = InetAddress.getLocalHost().getHostAddress();
					System.out.print("真实IP地址:" + realip + " ; ");
					String virtualip = httpGet.getConfig().getProxy().toHostString();
					System.out.println("代理IP地址:" + virtualip);
					Proxy.saveip(proxyHost, proxyPort);
				} else {
					System.out.println("    fail     status: " + status);
				}
				response.close();//  response关闭
				httpClient.close(); //  httpClient关闭
			} catch (IOException e) {
				System.out.println("    fail");
			}
		}
	}
}
