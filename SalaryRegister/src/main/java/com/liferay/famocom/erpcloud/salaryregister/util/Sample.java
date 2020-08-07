package com.liferay.famocom.erpcloud.salaryregister.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.DocumentException;

public class Sample {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		Map<String, String> tdsFormValue = new HashMap<String, String>();
		/*System.out.println("pk---java" + employeeId);
		tdsFormValue = SalaryRegisterUtil.getMappingValueOfTaxDeclarationForPDF(employeeId, monthYear);	*/		
		String filePath = "/salary.pdf"; 
		HtmlToPdf  htmlToPdf = new HtmlToPdf();
		//htmlToPdf.createPDFfromHTML(tdsFormValue, "pdf-salary.html", filePath);
		List<String> yearList = new ArrayList<String>();
		int currentYear = 2018;
		for(int i=4;i>-1;i--){
			String yearOne = String.valueOf(currentYear-i-1);
			String yearTwo = String.valueOf(currentYear-i);
			yearList.add(yearOne+"-"+yearTwo);
		}
		for(int j=0;j<=5;j++){
			String yearOne = String.valueOf(currentYear+j);
			String yearTwo = String.valueOf(currentYear+j+1);
			yearList.add(yearOne+"-"+yearTwo);
		}
		 	 Iterator<String> it= yearList.iterator();
		 while(it.hasNext()){
		 Object yr = it.next();

		 }
		 String str = "101|1";
			List<String> list =  Arrays.asList(str.split("\\|"));
			System.out.println("list..."+list);
	}
	


}
