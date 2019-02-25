package com.henu.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnUtil {
	public static String getPageContent(String url){
		StringBuffer sb = new StringBuffer();
		URL u;
		try {
			u = new URL(url);
	        HttpURLConnection httpUrlConn = (HttpURLConnection) u.openConnection();
	        httpUrlConn.setDoInput(true);
	        httpUrlConn.setRequestMethod("GET");
	        String[] sessionId = new String[3];
	        sessionId[0] = "TYCID=5e3d9e3022f111e998c8cd06e3f95385; undefined=5e3d9e3022f111e998c8cd06e3f95385; ssuid=27685865; RTYCID=2caa81c7eb854c13ac1e88719afd337c; _ga=GA1.2.412184661.1548675580; _gid=GA1.2.231526760.1548675580; CT_TYCID=2c2a3ba76c6c4081aa394df4ebc2314f; aliyungf_tc=AQAAAIEUgis4xAUA8JiePfBr42oBd0s6; csrfToken=v-LgJa4PMPmiza2ARQ7A9FLb; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1548694723,1548694948,1548695979,1548706313; __insp_wid=677961980; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly93d3cudGlhbnlhbmNoYS5jb20v; __insp_targlpt=5aSp55y85p_lLeWVhuS4muWuieWFqOW3peWFt1%2FkvIHkuJrkv6Hmga%2Fmn6Xor6Jf5YWs5Y_45p_l6K_iX_W3peWVhuafpeivol%2FkvIHkuJrkv6HnlKjkv6Hmga%2Fns7vnu58%3D; __insp_norec_howoften=true; __insp_norec_sess=true; token=f8be5fe71b1444c1bc0b52d195fc0233; _utm=1ffcb4b7dbb6426da0631e342c448a7c; tyc-user-info=%257B%2522claimEditPoint%2522%253A%25220%2522%252C%2522myAnswerCount%2522%253A%25220%2522%252C%2522myQuestionCount%2522%253A%25220%2522%252C%2522explainPoint%2522%253A%25220%2522%252C%2522privateMessagePointWeb%2522%253A%25220%2522%252C%2522nickname%2522%253A%2522%25E5%258F%25B6%25E4%25BA%258C%25E5%25A8%2598%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522privateMessagePoint%2522%253A%25220%2522%252C%2522state%2522%253A%25220%2522%252C%2522announcementPoint%2522%253A%25220%2522%252C%2522isClaim%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522discussCommendCount%2522%253A%25220%2522%252C%2522monitorUnreadCount%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522new%2522%253A%25221%2522%252C%2522claimPoint%2522%253A%25220%2522%252C%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTYzNzgzMDg3OSIsImlhdCI6MTU0ODcwNjM4OSwiZXhwIjoxNTY0MjU4Mzg5fQ.-iqu8f7qq-vM-l2LhrQtiAQ3M0HLiZgfGiZ7aKRVYh0WDUVDR_yP_DBAb1Z8pdCfuNYj3UZ27yiAEmLCadFRBg%2522%252C%2522pleaseAnswerCount%2522%253A%25220%2522%252C%2522redPoint%2522%253A%25220%2522%252C%2522bizCardUnread%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252215637830879%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTYzNzgzMDg3OSIsImlhdCI6MTU0ODcwNjM4OSwiZXhwIjoxNTY0MjU4Mzg5fQ.-iqu8f7qq-vM-l2LhrQtiAQ3M0HLiZgfGiZ7aKRVYh0WDUVDR_yP_DBAb1Z8pdCfuNYj3UZ27yiAEmLCadFRBg; __insp_slim=1548706389067; _gat_gtag_UA_123487620_1=1; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1548706389";
			sessionId[1] = "TYCID=2f714c00ff7911e8bc60e74fc93163ba; undefined=2f714c00ff7911e8bc60e74fc93163ba; ssuid=6396549696; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1548719452; _ga=GA1.2.1584936254.1544775677; aliyungf_tc=AQAAAMKzmCI7uwUAElA0e62SYCGR0h2q; csrfToken=oOiG4UEfsqzhmr3ZjlTn6aJj; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1548719488; __insp_wid=677961980; __insp_slim=1548719488264; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly93d3cudGlhbnlhbmNoYS5jb20v; __insp_targlpt=5aSp55y85p_lLeWVhuS4muWuieWFqOW3peWFt1%2FkvIHkuJrkv6Hmga%2Fmn6Xor6Jf5YWs5Y_45p_l6K_iX_W3peWVhuafpeivol%2FkvIHkuJrkv6HnlKjkv6Hmga%2Fns7vnu58%3D; __insp_norec_sess=true; _gid=GA1.2.111755380.1548719454; _gat_gtag_UA_123487620_1=1; token=2d68fd8b26dc4dd0a759f0d5fad29ccc; _utm=e852e7732ba34bf2a1f39dbfd821835a; tyc-user-info=%257B%2522claimEditPoint%2522%253A%25220%2522%252C%2522myAnswerCount%2522%253A%25220%2522%252C%2522myQuestionCount%2522%253A%25220%2522%252C%2522explainPoint%2522%253A%25220%2522%252C%2522privateMessagePointWeb%2522%253A%25220%2522%252C%2522nickname%2522%253A%2522%25E9%25AB%2598%25E8%2580%2580%25E5%25A4%25AA%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522privateMessagePoint%2522%253A%25220%2522%252C%2522state%2522%253A%25220%2522%252C%2522announcementPoint%2522%253A%25220%2522%252C%2522isClaim%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522discussCommendCount%2522%253A%25221%2522%252C%2522monitorUnreadCount%2522%253A%252217%2522%252C%2522onum%2522%253A%25220%2522%252C%2522claimPoint%2522%253A%25220%2522%252C%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODIzOTU5MDg1MCIsImlhdCI6MTU0ODcxOTQ4OSwiZXhwIjoxNTY0MjcxNDg5fQ.ZAq1PVGlTVIs7WHZvJIWGyqy1y3DiEG66pM9FaoiU8PTMxTZmSchvRqG6NzX81lqN0wgTMn3zaMHeZnHuK_Heg%2522%252C%2522pleaseAnswerCount%2522%253A%25221%2522%252C%2522redPoint%2522%253A%25220%2522%252C%2522bizCardUnread%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252218239590850%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxODIzOTU5MDg1MCIsImlhdCI6MTU0ODcxOTQ4OSwiZXhwIjoxNTY0MjcxNDg5fQ.ZAq1PVGlTVIs7WHZvJIWGyqy1y3DiEG66pM9FaoiU8PTMxTZmSchvRqG6NzX81lqN0wgTMn3zaMHeZnHuK_Heg";
			sessionId[2] = "TYCID=6f6bb620239511e98decef6fd182f510; undefined=6f6bb620239511e98decef6fd182f510; ssuid=7375778967; _ga=GA1.2.1552872845.1548746032; _gid=GA1.2.1635911278.1548746032; tyc-user-info=%257B%2522claimEditPoint%2522%253A%25220%2522%252C%2522myAnswerCount%2522%253A%25220%2522%252C%2522myQuestionCount%2522%253A%25220%2522%252C%2522explainPoint%2522%253A%25220%2522%252C%2522privateMessagePointWeb%2522%253A%25220%2522%252C%2522nickname%2522%253A%2522%25E5%258F%25B6%25E4%25BA%258C%25E5%25A8%2598%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522privateMessagePoint%2522%253A%25220%2522%252C%2522state%2522%253A%25220%2522%252C%2522announcementPoint%2522%253A%25220%2522%252C%2522isClaim%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522discussCommendCount%2522%253A%25220%2522%252C%2522monitorUnreadCount%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522claimPoint%2522%253A%25220%2522%252C%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTYzNzgzMDg3OSIsImlhdCI6MTU0ODc0NzAxMSwiZXhwIjoxNTY0Mjk5MDExfQ.m31mkSuC7xhLmzRCPOYdEqJKWnF-IJvxLmTLwW-hZO6fSx_NE3YF0-kj0PKTiMhrRNdQ0oxDWLLPvJzSAgSaug%2522%252C%2522pleaseAnswerCount%2522%253A%25220%2522%252C%2522redPoint%2522%253A%25220%2522%252C%2522bizCardUnread%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252215637830879%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTYzNzgzMDg3OSIsImlhdCI6MTU0ODc0NzAxMSwiZXhwIjoxNTY0Mjk5MDExfQ.m31mkSuC7xhLmzRCPOYdEqJKWnF-IJvxLmTLwW-hZO6fSx_NE3YF0-kj0PKTiMhrRNdQ0oxDWLLPvJzSAgSaug; RTYCID=bc0672e6739e4617bc13daf14ec6fe1d; CT_TYCID=8e3c9b84f1da4a478ce84d55dddf9b2f; aliyungf_tc=AQAAAJ4q1gpJMwEAN5iePUBCYGPkeP0y; csrfToken=8YYIati1jyTNo0BFylNcdXv3; __insp_wid=677961980; __insp_nv=true; __insp_targlpu=aHR0cHM6Ly93d3cudGlhbnlhbmNoYS5jb20v; __insp_targlpt=5aSp55y85p_lLeWVhuS4muWuieWFqOW3peWFt1%2FkvIHkuJrkv6Hmga%2Fmn6Xor6Jf5YWs5Y_45p_l6K_iX_W3peWVhuafpeivol%2FkvIHkuJrkv6HnlKjkv6Hmga%2Fns7vnu58%3D; __insp_norec_sess=true; _gat_gtag_UA_123487620_1=1; cloud_token=522a6e5694d74875b41aa942dc05fbdd; cloud_utm=3711cdef8b46439392ec828e7f0ce4c8; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1548831025,1548834211,1548842985,1548843149; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1548843149; __insp_slim=1548843149273";
			//int rd = Math.random()>0.5?0:1;
			httpUrlConn.setRequestProperty("Cookie",""); //当用天眼查爬虫时，第二个参数装入sessionId
			httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
			InputStream is = httpUrlConn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String data = null;
            while ((data = br.readLine()) != null) {
                sb.append(data);
               //System.out.println(data);
            }
            br.close();
            isr.close();
            is.close();
            httpUrlConn.disconnect();
		}  catch (Exception e ) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
