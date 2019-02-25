package com.henu.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;

import com.henu.vo.Company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jxl.CellView;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelWrite {
	public void createExcel(OutputStream os, ArrayList<Company> arryList) throws WriteException, IOException {

		// ����������
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// �����µ�һҳ
		WritableSheet sheet = workbook.createSheet("First Sheet", 0);
		CellView navCellView = new CellView();
		navCellView.setAutosize(true); 
		
		Label companyName = new Label(0, 0, "公司名称");
		sheet.addCell(companyName);
		Label address = new Label(1, 0, "地址");
		sheet.addCell(address);
		Label legalperson = new Label(2, 0, "法人");
		sheet.addCell(legalperson);
		Label phone = new Label(3, 0, "手机号");
		sheet.addCell(phone);
		int len = arryList.size();
		Label[] a = new Label[len];
		Label[] b = new Label[len];
		Label[] c = new Label[len];
		Label[] d = new Label[len];
		int row = 1;
		int col = 0;
		for (Company company : arryList) {
			a[col] = new Label(0, row, company.getCompanyName());
			sheet.addCell(a[col]);
			b[col] = new Label(1, row, company.getAddress());
			sheet.addCell(b[col]);
			c[col] = new Label(2, row, company.getLegalperson());
			sheet.addCell(c[col]);
			d[col] = new Label(3, row, company.getPhone());
			sheet.addCell(d[col]);
			row++;
			col++;
		}
		
		workbook.write();
		workbook.close();
		os.close();
	}

	public void createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// �ж�Ŀ¼�Ƿ����
			System.out.println("����Ŀ¼ʧ�ܣ�Ŀ��Ŀ¼�Ѵ��ڣ�");
		}
		if (!destDirName.endsWith(File.separator)) {// ��β�Ƿ���"/"����
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// ����Ŀ��Ŀ¼
			System.out.println("����Ŀ¼�ɹ���" + destDirName);
		} else {
			System.out.println("����Ŀ¼ʧ�ܣ�");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean outExcel(String key, String base) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");// �������ڸ�ʽ
		String name = key+"_"+base+df.format(new Date());
		String mokDir = "C:/TianYanChaSpider";
		ExcelWrite ew = new ExcelWrite();
		ew.createDir(mokDir);
		File file = new File(mokDir + "/" + name + ".xls");
		CrawlerCompanyUtil crawlerCompanyUtil = new CrawlerCompanyUtil();
		try {
			ArrayList com = crawlerCompanyUtil.findList(key,base);
			if (file.exists()) {
				System.out.println("���ļ��Ѵ���");
				return false;
			}
			OutputStream os = new FileOutputStream(file);
			ew.createExcel(os, com);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean isLive(String name){
		File file = new File("C:/TianYanChaSpider/" + name + ".xls");
		if (file.exists()) {
			System.out.println("���ļ��Ѵ���");
			return false;
		}else{
			return true;
		}
	}
}
