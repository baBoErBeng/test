package com.henu.utils;

import org.json.JSONException;
import org.json.JSONObject;

import com.henu.vo.Company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerCompanyUtil {
	public  ArrayList<Company> findList(String inputkey,String inputbase) throws JSONException {
		String key = URLEncoding.testEncode(inputkey);
		String base = inputbase;
		int time = 5000;// 间隔时间
		String p[] = { "", "/p2", "/p3", "/p4", "/p5" }; //免费用户，最高只能爬取5页，所以值设为5
		int i = 0;
		ArrayList<Company> rs=new ArrayList<Company>();
		while (i < 5) {
			String web = ConnUtil.getPageContent("https://www.tianyancha.com/search" + p[i] + "?key=" + key+"&base="+base);
			Pattern companyInfo = Pattern.compile("<span class=\"tt hidden\">.*?</span>");
			Matcher matcher = companyInfo.matcher(web);
			while (matcher.find()) {
				String group = matcher.group();
				String eachGroup = group.substring(group.indexOf("<span class=\"tt hidden\">") + 24,
						group.indexOf("</span>"));
				JSONObject json = new JSONObject(eachGroup);
				// 获取公司名
				String companyName = json.get("name").toString().replaceAll("<.*?>","");
				// 获取法人
				String legalperson = json.get("legalPersonName").toString();
				// ע���ʱ�
				String registeredfund = json.get("regCapital").toString();
				// ע��ʱ��
				String registeredtime = json.get("estiblishTime").toString();
				String phone = json.get("phoneList").toString();
				// �����б�
				String email = json.get("emailList").toString();
				// ע���ַ
				String address = json.get("regLocation").toString();
				String qita = "��Ӫ����" + json.get("businessScope") + "\n" + json.get("matchField");
				Company c = new Company();
				c.setCompanyName(companyName);
				c.setLegalperson(legalperson);
				c.setRegisteredfund(registeredfund);
				c.setRegisteredtime(registeredtime);
				c.setPhone(phone);
				c.setEmail(email);
				c.setAddress(address);
				c.setQita(qita);
				rs.add(c);
				
				System.out.println("公司名称" + c.getCompanyName());
				System.out.println("注册地址" + c.getAddress());
				System.out.println("法人" + c.getLegalperson());
				System.out.println("手机号" +c.getPhone());
				System.out.println(
						"-------------------------------------------------------------------------------------------------------");
			}
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			System.out.println("********************************************��" + i
					+ "ҳ**********************************************************");
		}
		
		return rs;
	}

}