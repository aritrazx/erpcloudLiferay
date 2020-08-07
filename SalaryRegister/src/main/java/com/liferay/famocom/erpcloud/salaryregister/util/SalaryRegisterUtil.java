package com.liferay.famocom.erpcloud.salaryregister.util;

import java.io.IOException;
import java.text.DateFormat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.liferay.famocom.erpcloud.model.BankMaster;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;
import com.liferay.famocom.erpcloud.model.YearSetting;
import com.liferay.famocom.erpcloud.salaryregister.dao.SalaryRegisterDAO;
import com.liferay.famocom.erpcloud.salaryregister.dto.SalarySlipDTO;
import com.liferay.famocom.erpcloud.service.BankMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.YearSettingLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

public  class SalaryRegisterUtil {
	private static DecimalFormat df2 = new DecimalFormat("0.00");
	private static String localrupeesUrl = "/documents/20143/0/rupee-indian-16px.png/4b1c5da4-04ca-530c-2c81-935aff92068d?t=1534226092573";
	private static String serverrupeesUrl ="/documents/20143/0/rupee.png/c5b22d8b-c3f2-48ff-f2c9-109a060b0981?t=1534505797415";
	public static Map<String, String>  getMappingValueOfTaxDeclarationForPDF(long empIdStr, ThemeDisplay themeDisplay,String monthYear,String month,String year) throws PortalException{
		Map<String, String> tdsMap = new HashMap<>();
		Employee employee = null;
		YearSetting setting = null;
		String rupeesLogoUrl = StringPool.BLANK;
		try {
			setting = YearSettingLocalServiceUtil.findYearSettingByisActive(1);
		} catch (Exception e) {
			System.out.println("No active financial year in  YearSetting");
		}
		Date financialStartDate = new Date();
		Date financialEnd = new Date();
		String financialStartYear = StringPool.BLANK;
		String financialEndYear = StringPool.BLANK;
		if (Validator.isNotNull(setting)) {
			financialStartDate = setting.getFinancialYearStartDate();
			financialEnd = setting.getFinancialYearEndDate();
			if(Validator.isNotNull(financialStartDate)){
				financialStartYear = String.valueOf(1900+financialStartDate.getYear());
			}
			if(Validator.isNotNull(financialEnd)){
				financialEndYear = String.valueOf(1900+financialEnd.getYear());
			}
		}
		System.out.println("month...."+month);
		 String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		 String per_month = "TDS Per month(" + months[Integer.valueOf(month)] +" " +financialStartYear +" to "
					+ months[Integer.valueOf(2)] + " "+financialEndYear+")";
		 long monthToNo = 3;
		 long currentMonth = Long.valueOf(month);
		 //per_month = months[month]' To '.$todate;
		 if(monthToNo-currentMonth==0){
		 	per_month="-";
		 }else if(monthToNo-currentMonth==1){
			per_month = months[Integer.valueOf(2)] + " "+financialEndYear;
		 }
		 String fromdate = months[Integer.valueOf(month)-1]+" "+year.subSequence(2, 4); 
		TaxDeclarationMonthly declarationMonthly = null;
		if(Validator.isNotNull(empIdStr)){
			if(Validator.isNotNull(monthYear)){
				try{
					employee = EmployeeLocalServiceUtil.getEmployee(empIdStr);
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(empIdStr, Long.valueOf(monthYear));
				}catch(Exception exception){
					exception.printStackTrace();
				}
					
			}
			
		}
		if(Validator.isNotNull(employee)){
			tdsMap.put("employeeId", String.valueOf(employee.getEmployeeCode()));
			tdsMap.put("financialYear", financialStartYear+"-"+financialEndYear);
			String employeeName = employee.getFirstName()+" "+employee.getLastName();
			tdsMap.put("employeeName", employeeName);
			tdsMap.put("employeePanNo", employee.getPanNo());
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
			String dateOfJoining = StringPool.BLANK;
			if(Validator.isNotNull(employee.getDateOfJoing())){
				dateOfJoining = dateFormat.format(employee.getDateOfJoing());
			}
			tdsMap.put("dateOfJoining", dateOfJoining);
			tdsMap.put("employeeGender", employee.getGender());
	   }
		Company company = themeDisplay.getCompany();
		User user = themeDisplay.getUser();
		Phone phone = null;
		String add = StringPool.BLANK;
		Address address = null;
		String phoneNumber = StringPool.BLANK;
		if(Validator.isNotNull(user)){
			try{
			address = AddressLocalServiceUtil.getAddressByUuidAndCompanyId(user.getUuid(), company.getCompanyId());
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
				phone = PhoneLocalServiceUtil.getPhoneByUuidAndCompanyId(user.getUuid(), company.getCompanyId());
				if(Validator.isNotNull(phone)){
					phoneNumber = phone.getNumber();
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		if(Validator.isNotNull(address)){
			add = address.getStreet1()+" "+address.getStreet2() +" "+ address.getStreet3() +" "+ address.getCity();	
		}
		rupeesLogoUrl = themeDisplay.getURLPortal() +serverrupeesUrl;
		tdsMap.put("rupeesLogoUrl",rupeesLogoUrl);
		tdsMap.put("fromdate", fromdate);
		tdsMap.put("logo_str", themeDisplay.getURLPortal()+themeDisplay.getCompanyLogo());
		tdsMap.put("companyName", company.getName());
		tdsMap.put("companyAddress",add );
		tdsMap.put("companyPhone",phoneNumber );
		tdsMap.put("companyEmail", company.getEmailAddress());
		tdsMap.put("companywebsite", company.getWebId());
		
		if(Validator.isNotNull(declarationMonthly)){
		tdsMap.put("hraRent", df2.format(declarationMonthly.getHraRent()));
		tdsMap.put("hraExempt", df2.format(declarationMonthly.getHraExempt()));
		
		tdsMap.put("medicalIndividual", df2.format(declarationMonthly.getMedicalIndividual()));	
		tdsMap.put("medicalParents", df2.format(declarationMonthly.getMedicalParents()));
		tdsMap.put("medicalParentsSenior", df2.format(declarationMonthly.getMedicalParentsSenior()));	
		tdsMap.put("medicalHandiLess80", df2.format(declarationMonthly.getMedicalHandiLess80()));	
		tdsMap.put("medicalHandiGater80", df2.format(declarationMonthly.getMedicalHandiGater80()));	
		tdsMap.put("medicalGater60Less80", df2.format(declarationMonthly.getMedicalGater60Less80()));	
		tdsMap.put("medicalGater80", df2.format(declarationMonthly.getMedicalGater80()));		
		tdsMap.put("educationLoan", df2.format(declarationMonthly.getEducationLoan()));	
		tdsMap.put("physicalDisability", df2.format(declarationMonthly.getPhysicalDisability()));		
		tdsMap.put("physicalDisabilitySevere", df2.format(declarationMonthly.getPhysicalDisabilitySevere()));	
		tdsMap.put("equitySavings", df2.format(declarationMonthly.getEquitySavings()));	
		tdsMap.put("interestOnDeposit", df2.format(declarationMonthly.getInterestOnDeposit()));	
		tdsMap.put("nationalPension", df2.format(declarationMonthly.getNationalPension()));
		
		double sectionBTotal = declarationMonthly.getMedicalIndividual() + declarationMonthly.getMedicalParents() + declarationMonthly.getMedicalParentsSenior() + declarationMonthly.getMedicalHandiLess80();
        sectionBTotal += declarationMonthly.getMedicalHandiGater80() + declarationMonthly.getMedicalGater60Less80() + declarationMonthly.getMedicalGater80() + declarationMonthly.getEducationLoan() ;
        sectionBTotal += declarationMonthly.getPhysicalDisability() +  declarationMonthly.getPhysicalDisabilitySevere() + declarationMonthly.getEquitySavings() + declarationMonthly.getInterestOnDeposit() + declarationMonthly.getNationalPension();
        tdsMap.put("sectionBTotal",  df2.format(sectionBTotal));	
		tdsMap.put("sectionBExempt",  df2.format(declarationMonthly.getSectionBExempt()));
		
		tdsMap.put("lic", df2.format(declarationMonthly.getLic()));		
		tdsMap.put("ppf", df2.format(declarationMonthly.getPpf()));	
		tdsMap.put("nsc", df2.format(declarationMonthly.getNsc()));	
		tdsMap.put("infraBonds", df2.format(declarationMonthly.getInfraBonds()));	
		tdsMap.put("tuitionFees", df2.format(declarationMonthly.getTuitionFees()));	
		tdsMap.put("mutualFunds", df2.format(declarationMonthly.getMutualFunds()));
		tdsMap.put("sukanya", df2.format(declarationMonthly.getSukanya()));	
		tdsMap.put("ulip", df2.format(declarationMonthly.getUlip()));		
		tdsMap.put("timeDeposit", df2.format(declarationMonthly.getTimeDeposit()));	
		tdsMap.put("housingLoan", df2.format(declarationMonthly.getHousingLoan()));	
		tdsMap.put("fixedDeposit", df2.format(declarationMonthly.getFixedDeposit()));	
		tdsMap.put("totalProvidentFund", df2.format(declarationMonthly.getTotalProvidentFund()));	
		tdsMap.put("nscInterest", df2.format(declarationMonthly.getNscInterest()));
		tdsMap.put("sectionCExempt", df2.format(declarationMonthly.getSectionCExempt()));
		
        double sectionCTotal = declarationMonthly.getLic() + declarationMonthly.getPpf()  + declarationMonthly.getNsc() + declarationMonthly.getInfraBonds() + declarationMonthly.getTuitionFees();
        sectionCTotal += declarationMonthly.getMutualFunds() + declarationMonthly.getSukanya() + declarationMonthly.getUlip() + declarationMonthly.getTimeDeposit() + declarationMonthly.getHousingLoan() ;
        sectionCTotal +=  declarationMonthly.getFixedDeposit() + declarationMonthly.getTotalProvidentFund() + declarationMonthly.getNscInterest();
        
        tdsMap.put("sectionCTotal", df2.format(Math.round(sectionCTotal)));
		tdsMap.put("housingLoanInterest", df2.format(declarationMonthly.getHousingLoanInterest()));		
		tdsMap.put("sectionDExempt", df2.format(declarationMonthly.getSectionDExempt()));	
		
		tdsMap.put("previousIncome", df2.format(declarationMonthly.getPreviousIncome()));		
		tdsMap.put("previousPf", df2.format(declarationMonthly.getPreviousPf()));	
		tdsMap.put("previousPt", df2.format(declarationMonthly.getPreviousPt()));		
		tdsMap.put("previousTds", df2.format(declarationMonthly.getPreviousTds()));	
		double sectionETotal = declarationMonthly.getPreviousIncome() + declarationMonthly.getPreviousPf() +  declarationMonthly.getPreviousPt() + declarationMonthly.getPreviousTds();
		tdsMap.put("sectionETotal", df2.format(Math.round(sectionETotal)));
		tdsMap.put("salaryBeforeExempt", df2.format(declarationMonthly.getSalaryBeforeExempt()));
		String lessExempt =  df2.format(declarationMonthly.getHraExempt() +declarationMonthly.getSectionBExempt()  + declarationMonthly.getSectionCExempt() + declarationMonthly.getSectionDExempt() + declarationMonthly.getPreviousTds());
		tdsMap.put("lessExempt", lessExempt);	
		tdsMap.put("totalPtax", df2.format(declarationMonthly.getTotalPtax()));	
		tdsMap.put("salaryAfterExempt", df2.format(declarationMonthly.getSalaryAfterExempt()));	
		tdsMap.put("grossTds", df2.format(declarationMonthly.getGrossTds()));	
		tdsMap.put("educationCess", df2.format(declarationMonthly.getEducationCess()));	
		tdsMap.put("totalTds", df2.format(declarationMonthly.getTotalTds()));	
		tdsMap.put("tdsDeducted", df2.format(declarationMonthly.getTdsDeducted()));	
		
		String  tdsDue = df2.format(declarationMonthly.getTotalTds()- declarationMonthly.getTdsDeducted());
		tdsMap.put("tdsDue", tdsDue);
		tdsMap.put("perMonth", per_month);
		tdsMap.put("tdsDuePerMonth", df2.format(declarationMonthly.getTdsDuePerMonth()));
		
	}
		return tdsMap;
 }
	public static Map<String, String> getMappingValueOfPaySlipForPDF(String contextPath, ThemeDisplay themeDisplay,long employeeId, int monthYear, String month) throws PortalException {
		// TODO Auto-generated method stub
		
		Map<String, String> paySlipmap = new HashMap<>();
		String employeeName  = StringPool.BLANK;
		String dateOfjoining = StringPool.BLANK;
		String deductionComponentsWithValue = StringPool.BLANK;	
		String earningComponentsWithValue = StringPool.BLANK;
		String employeePan = StringPool.BLANK;
		String employeeDesignation = StringPool.BLANK;
		String employeePFNumber = StringPool.BLANK;
		String accountNumber  = StringPool.BLANK;
		String bankName = StringPool.BLANK;
		double monthlyTax = 0.0 ;
		String employeeCode = StringPool.BLANK;
		String ruImages = StringPool.BLANK;
		String rupeesLogoUrl = StringPool.BLANK;
		/*String url = "http://localhost:8081/documents/20143/32502/Rupee_Foradian.ttf/38894f7d-0a7a-3540-e576-48d6f1445df5";
		System.out.println(",,,,,,, ruImages "+url);*/
		/*BaseFont bf;
		try {
			bf = BaseFont.createFont(url,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 12);
			Chunk chunkRupee = new Chunk(" \u20B9 5410", font); 
			ruImages = chunkRupee.getContent();
			System.out.println(",,,,,,, ruImages font "+chunkRupee.getFont());
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
			
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		//get pay component value 
		
		 DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PayComponent.class);
		   dynamicQuery.addOrder(OrderFactoryUtil.asc("payComponentOrder"));
		   List<SalarySlipDTO> list = new ArrayList<>();  
		   List<PayComponent> componentList = PayComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(componentList.size()>0){	
				HashMap<Long,String> hashmap = SalaryRegisterDAO.getEarningComponentbyMonthYearAndEmployeeId(String.valueOf(monthYear), employeeId);				
				if(hashmap.size()>0){					
					for(PayComponent component:componentList){
						
					 		for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
						    	if(component.getComponentId()==entry.getKey()){
										String earnAmount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
										earningComponentsWithValue += "<tr><td  style='border-bottom:1px solid #595959; border-right:1px solid #595959; padding: 5px 10px;'>"+component.getName()+"</td>"
												+"<td style='border-bottom:1px solid #595959; border-right:1px solid #595959;  padding: 5px 10px; text-align:right;'>"+earnAmount+"</td></tr>";
					
						    	}
					 		}
					 		
			 	}
				hashmap = SalaryRegisterDAO.getEmployeeDeductionComponentbyMonthYearAndEmployeeId(String.valueOf(monthYear), employeeId);
			  	if(hashmap.size()>0){
			  		for(PayComponent component:componentList){
			  		
						  	for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
								if(component.getComponentId()==entry.getKey()){
										String dedAmount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
										deductionComponentsWithValue += "<tr><td style='border-bottom:1px solid #595959; border-right:1px solid #595959; padding: 5px 10px;'>"+component.getName()+"</td>"
												+"<td style='border-bottom:1px solid #595959; border-right:0px solid #595959;  padding: 5px 10px; text-align:right;'>"+dedAmount+"</td></tr>";
								}
						  	}
					  	}
			  		//monthly tax in payslip
			  		TaxDeclarationMonthly declarationMonthly = null;			  		
			  		try{
			  			declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(employeeId, Long.valueOf(monthYear));
			  			if(Validator.isNotNull(declarationMonthly)){
			  				String taxStr = df2.format(declarationMonthly.getTdsDuePerMonth());
			  				monthlyTax = Double.valueOf(taxStr);
			  				deductionComponentsWithValue += "<tr><td style='border-bottom:1px solid #595959; border-right:1px solid #595959; padding: 5px 10px;'>Income Tax</td>"
									+"<td style='border-bottom:1px solid #595959; border-right:0px solid #595959;  padding: 5px 10px; text-align:right;'>"+monthlyTax+"</td></tr>";
			  				
								
			  			}
			  		}catch(Exception e){
			  			
			  		}
			  		
					 }
				}
			}
		
		Company company = themeDisplay.getCompany();
		User user = themeDisplay.getUser();
		Phone phone = null;
		String add = StringPool.BLANK;
		Address address = null;
		String phoneNumber = StringPool.BLANK;
		if(Validator.isNotNull(user)){
			try{
			address = AddressLocalServiceUtil.getAddressByUuidAndCompanyId(user.getUuid(), company.getCompanyId());
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
				phone = PhoneLocalServiceUtil.getPhoneByUuidAndCompanyId(user.getUuid(), company.getCompanyId());
				if(Validator.isNotNull(phone)){
					phoneNumber = phone.getNumber();
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		if(Validator.isNotNull(address)){
			add = address.getStreet1()+" "+address.getStreet2() +" "+ address.getStreet3() +" "+ address.getCity();	
		}
		System.out.println(",,,,,,, context path "+themeDisplay.getURLPortal()+themeDisplay.getCompanyLogo());
		rupeesLogoUrl = themeDisplay.getURLPortal() +serverrupeesUrl;
		System.out.println("rupeesLogoUrl   "+rupeesLogoUrl);
		paySlipmap.put("rupeesLogoUrl",rupeesLogoUrl);
		paySlipmap.put("logo_str", themeDisplay.getURLPortal()+themeDisplay.getCompanyLogo());
		paySlipmap.put("companyName", company.getName());
		paySlipmap.put("companyAddress",add );
		paySlipmap.put("companyPhone",phoneNumber );
		paySlipmap.put("companyEmail", company.getEmailAddress());
		paySlipmap.put("companywebsite", company.getWebId());
		System.out.println(",,,,,,, ruImages "+ruImages);
		
		paySlipmap.put("ruImages", ruImages);
		
		Employee employee = null;
		if(employeeId!=0){
			if(Validator.isNotNull(monthYear)){
				try{
					employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
				}catch(Exception e){
					
				}
			}
		}
		if(Validator.isNotNull(employee)){
			employeeName = employee.getFirstName() + " "+ employee.getLastName();
			employeeCode = String.valueOf(employee.getEmployeeCode());
			employeePan = employee.getPanNo();
			employeeDesignation = employee.getDesignation();
			employeePFNumber = employee.getPfNo();
			BankMaster bankMaster = null;
			try {
				bankMaster = BankMasterLocalServiceUtil.getBankMaster(employee.getBankId());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(Validator.isNotNull(bankMaster)){
				bankName = bankMaster.getBankName();
			}
			
			//employee.getBankName();
			accountNumber = employee.getAccountNo();
			if(Validator.isNotNull(employee.getDateOfJoing())){
				dateOfjoining = dateFormat.format(employee.getDateOfJoing());
			}
		}

		
		paySlipmap.put("employeeCode", employeeCode);
		paySlipmap.put("dateOfJoining", dateOfjoining);
		paySlipmap.put("employeeName", employeeName);
		paySlipmap.put("employeePan", employeePan);
		paySlipmap.put("employeeDesignation", employeeDesignation);
		paySlipmap.put("employeePFNumber", employeePFNumber);
		paySlipmap.put("accountNumber", accountNumber);
		String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		String fromdate = months[Integer.valueOf(month)-1];	
		String salaryforMonth= "PAYSLIP FOR THE MONTH OF "+ fromdate +" 2018";
		paySlipmap.put("salaryMonth", salaryforMonth);
		
		paySlipmap.put("earningComponentsWithValue", earningComponentsWithValue);
		paySlipmap.put("deductionComponentsWithValue", deductionComponentsWithValue);
		double totalEarning = SalaryRegisterDAO.getTotalEarningByMonthYearAndEmployeeId(String.valueOf(monthYear), employeeId);
		double totalDeduction = SalaryRegisterDAO.getTotalDeductionByMonthYearAndEmployeeId(String.valueOf(monthYear), employeeId);
		totalDeduction += monthlyTax;
		double netPay = totalEarning - totalDeduction;
		paySlipmap.put("totalEarning", df2.format(totalEarning));
		paySlipmap.put("totalDeduction", df2.format(totalDeduction));
		paySlipmap.put("netPay",  df2.format(netPay));
		paySlipmap.put("bankName",  bankName);
		String netPayInRupees = NumberToWords.convert(netPay);
		paySlipmap.put("netPayInRupees",  "(Rupees "+netPayInRupees+" only)");
		
		
		return paySlipmap;
	}
}
