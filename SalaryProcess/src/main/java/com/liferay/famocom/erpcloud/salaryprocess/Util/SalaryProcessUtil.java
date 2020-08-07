package com.liferay.famocom.erpcloud.salaryprocess.Util;

import java.text.DecimalFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException;
import com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException;
import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.FinSalary;
import com.liferay.famocom.erpcloud.model.IncomeTaxSlab;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.model.TaxDeclaration;
import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;
import com.liferay.famocom.erpcloud.model.TaxSetting;
import com.liferay.famocom.erpcloud.model.YearSetting;
import com.liferay.famocom.erpcloud.salaryprocess.constants.SalaryProcessPortletKeys;
import com.liferay.famocom.erpcloud.salaryprocess.dto.SalaryProcessDTO;
import com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.FinSalaryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaxDeclarationLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaxSettingLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.YearSettingLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public  class SalaryProcessUtil {
	private static DecimalFormat df2 = new DecimalFormat("0.00");
	public static void incomeTaxCalcualtion(long employeeId,long providentfundCurrentMonth,String month,String year,Boolean finalProcess,List<String> PayearningList) throws ParseException, PortalException{
		long taxableEarningDefinition = 0;
		long taxableEarningPreviousMonth = 0;		
		List<PayComponent> componentList = PayComponentLocalServiceUtil.findPayComponentByTaxStatusAndPayType(1, "E");
		Calendar cal = Calendar.getInstance();
		long taxableEarningCurrentMonth = 0;
		long totalPay = 0;
		long grossAnnualIncome = 0;
		
		
		
		
		//String startDate = "31/03/2019";
		String startDate = StringPool.BLANK;
		String endDate = "1/"+month+"/"+year+"";
		//String financialStartDateStr = "1/04/2018";
		String financialStartDateStr = StringPool.BLANK;
		//Date financialStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(financialStartDateStr);
		//Date financialEnd = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
		Date financialStartDate = new Date();
		Date financialEnd = new Date();
		Date salaryMonthDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
		//get financial year
		YearSetting setting = null;
			try{
				setting = YearSettingLocalServiceUtil.findYearSettingByisActive(1);
			}catch (Exception e) {
				System.out.println("No active financial year in  YearSetting");
			}
			if(Validator.isNotNull(setting)){
				financialStartDate = setting.getFinancialYearStartDate();
				financialEnd = setting.getFinancialYearEndDate();
			}
		
		String monthYear = month + year;
		long pTaxCurrentMonth = 0;	
		long pTaxPreviousMonth = 0;
		double tdsDuePerMonth = 0.0;
		
	
		//====================================
		// check whether  final salary process 
		FinSalary fnSalary = null;
		try {
			fnSalary = FinSalaryLocalServiceUtil.findFinSalaryByMonthYear(Integer.valueOf(monthYear));
		} catch (NoSuchFinSalaryException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		
		
		List<String> monthYearlistStr = getEarningPriviousMonthYear(financialStartDate, salaryMonthDate);

		long[] monthYears = new long[monthYearlistStr.size()];

		int i = 0;
		for (String s : monthYearlistStr) {
			monthYears[i] = Long.valueOf(s);
			i++;
		}
		try {
			pTaxCurrentMonth = getProfessionsTaxCurrentMonth(monthYear, employeeId, PayearningList);
			if (monthYears.length > 0) {
				pTaxPreviousMonth = getpTaxPreviousMonth(monthYears, employeeId, PayearningList);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("componentList...."+componentList);
		if (componentList.size() > 0) {
			for (PayComponent component : componentList) {
				List<SalDetails> detailList = SalDetailsLocalServiceUtil
						.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), employeeId);
				if (detailList.size() > 0) {
					for (SalDetails sal : detailList) {
						if (component.getComponentId() == sal.getComponentId()) {
							taxableEarningDefinition += sal.getValue();
							taxableEarningCurrentMonth += sal.getValue();
						}
					}
				}
				// TaxableEarningPreviousMonth calculation
				if (monthYears.length > 0) {
					detailList = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndMonthYears(employeeId,
							monthYears);
					if (detailList.size() > 0) {
						for (SalDetails sal : detailList) {
							if (component.getComponentId() == sal.getComponentId()) {
								taxableEarningPreviousMonth += sal.getValue();
							}
						}
					}
				}

			}
		}
		int numberOfDueMonth = getmonthCount(salaryMonthDate, financialEnd);
		// ------------------------------------------------------
		long taxableEarningDue = taxableEarningDefinition * (numberOfDueMonth - 1);
		long pTaxDue = pTaxCurrentMonth * (numberOfDueMonth-1);
		// ------------------------------------------------------------------------
		// long providentfundDue = providentFund * (numberOfDueMonth);
		long totalPtax = pTaxPreviousMonth + pTaxCurrentMonth + pTaxDue;
		// ---------------------------------------------------------------------
		// long totalProvidentFund = providentfundPreviousMonth +
		// providentfundCurrentMonth + providentfundDue;
		// ---------------------------------------------------------------------
		 totalPay = taxableEarningPreviousMonth + taxableEarningCurrentMonth + taxableEarningDue;
		System.out.println("totalPay   "+totalPay);
		TaxDeclaration declaration = null;
		long totalNonTaxablePriviousMonth = 0;
		double totalTDSDeducted = 0;
		double totalPf = 0.00;
		// long grossAnnualIncome = totalPay-totalPtax; // total gross annual
		// income

		// ==================================================
		// calculate non taxable income from
		if (monthYears.length > 0) {
			totalNonTaxablePriviousMonth = getTotalNonTaxablePriviousMonth(employeeId, monthYears);
		}
		long totalNonTaxableCurrentMonth = getTotalNonTaxableCurrentMonth(employeeId, monthYear);
		long totalNonTaxableDue = totalNonTaxableCurrentMonth * (numberOfDueMonth - 1);
		long totalNonTaxableAmount = totalNonTaxablePriviousMonth + totalNonTaxableCurrentMonth + totalNonTaxableDue;
		
		//deducted pf and ptax and also notaxable deducation amoount
		grossAnnualIncome = totalPay - totalNonTaxableAmount;
		
		try{
			 declaration = TaxDeclarationLocalServiceUtil.getTaxDeclarationByEmployeeId(employeeId);
		}catch(Exception e){
			//e.printStackTrace();
		}

		// ===========================================================
		// calculate PF 
		double previousPF = 0.00;
		double currentMonthPf = 0.00;
		List<PayComponent>  component = PayComponentLocalServiceUtil.getPayComponents(-1,-1);
		long pfId = 0;
		for (PayComponent payComponent : component) {
			if(payComponent.getAbbreviation().equalsIgnoreCase("PF")){
				pfId = payComponent.getComponentId();
			}
		}
		if(monthYears.length>0){
		List<SalDetails> detailList = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(employeeId, pfId, monthYears);
		
		for (SalDetails salDetails : detailList) {
			previousPF += salDetails.getValue();
		}
		}
		SalDetails details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(employeeId, pfId, Long.valueOf(monthYear));
		if(Validator.isNotNull(details)){
			currentMonthPf = details.getValue();
		}
		//String totalPfDueStr = df2.format(currentMonthPf * (numberOfDueMonth - 1));
		//double totalPfDue = Double.valueOf(totalPfDueStr);
		double totalPfDue = Math.round(currentMonthPf * (numberOfDueMonth - 1));
		//String totalPfStr = df2.format(previousPF + currentMonthPf + totalPfDue);
		//totalPf = Double.valueOf(totalPfStr);
		totalPf = Math.round(previousPF + currentMonthPf + totalPfDue);
		System.out.println("total Pf "+totalPf);
		
		if (Validator.isNotNull(declaration)) {
		// ==================================================
		// Calculate HRA-------------------------------------
		double salaryAfterExempt = 0;
		// pf is part of sectioncExempt so only ptax is deducation 
		double grossAnnualIncomeExemptPtax =  totalPay - totalPtax;
		double hraExemptAmount = getHRA(grossAnnualIncome, employeeId, monthYears, monthYear, numberOfDueMonth);
		// ==================================================
		// --------------Salary after HRA Exempt------------
		salaryAfterExempt = grossAnnualIncomeExemptPtax - hraExemptAmount;
		
		
		// ======================================================
		// --Section B - Chapter VI A - Deductions from Total Income
		
			double medicalIndividual = declaration.getMedicalIndividual();
			double medicalParents = declaration.getMedicalParents();
			double medicalParentsSenier = declaration.getMedicalParentsSenior();
			double SectionBTotalExempt = 0.00;
			double sectionCTotalExempt = 0.00;
			if (medicalIndividual > 25000) {
				medicalIndividual = 25000;
			}
			if (medicalParents > 25000) {
				medicalParents = 25000;
			}
			if (medicalParentsSenier > 30000) {
				medicalParentsSenier = 30000;
			}

			SectionBTotalExempt = medicalIndividual + medicalParents + medicalParentsSenier
					+ declaration.getMedicalHandiGater80() + declaration.getMedicalHandiLess80()
					+ declaration.getMedicalGater60Less80() + declaration.getMedicalGater80()
					+ declaration.getEducationLoan() + declaration.getPhysicalDisability()
					+ declaration.getPhysicalDisabilitySevere() + declaration.getEquitySavings()
					+ declaration.getInterestOnDeposit() + declaration.getNationalPension();

			salaryAfterExempt = salaryAfterExempt - SectionBTotalExempt;

			// ==================================================================
			// ---Section C - Chapter VIA Sec 80C(Maximum Limit INR 150,000)

			sectionCTotalExempt = declaration.getLic() + declaration.getPpf() + declaration.getNsc()
					+ declaration.getInfraBonds() + declaration.getTuitionFees() + declaration.getMutualFunds()
					+ declaration.getSukanya() + declaration.getUlip() + declaration.getTimeDeposit()
					+ declaration.getHousingLoan() + declaration.getFixedDeposit() + declaration.getNscInterest()
					+ totalPf;

			// -------------------------------------------------------------------
			// ==================================================================
			if (sectionCTotalExempt > 150000) {
				sectionCTotalExempt = 150000;
			}

			// ----------------Salary after Section C
			// Exempt---------------------
			salaryAfterExempt = salaryAfterExempt - sectionCTotalExempt;

			double houseLoanInterest = 0;
			// ==================Loss from House
			// Property========================
			if (declaration.getHousingLoanInterest() > 200000) {
				houseLoanInterest = 200000;
			} else {
				houseLoanInterest = declaration.getHousingLoanInterest();
			}
			// ------------------------------------------------------------------
			// ----------------Salary after Section D
			// Exempt---------------------
			double sectionDTotalExempt = houseLoanInterest;
			salaryAfterExempt = salaryAfterExempt - houseLoanInterest;

			// ----------------Calculate TDS on Salary
			// --------------------------

			// ------------If TAX Declaration Form not submit-----------
			if (salaryAfterExempt == 0) {
				salaryAfterExempt = grossAnnualIncome;
			}

			double tdsOnSalary = getTDSOnSalary(salaryAfterExempt);

			double grossTds = tdsOnSalary;
			// ---------------------------------------------------------------
			double educationCess = 0;
			if (tdsOnSalary > 0) {
				//String educationCessStr = df2.format((tdsOnSalary * 3) / 100);
				//educationCess = Double.valueOf(educationCessStr);
				educationCess = Math.round((tdsOnSalary * 3) / 100);
				// String tdsOnSalaryStr = df2.format(tdsOnSalary + educationCess);
				// tdsOnSalary = Double.valueOf(tdsOnSalaryStr);
				tdsOnSalary = Math.round(tdsOnSalary + educationCess);
			}
			
			if(monthYears.length>0){
				totalTDSDeducted = getTotalTDSDeductedPreviousMonths(employeeId,monthYears);
			}/*else{*/
				tdsDuePerMonth = getTdsDeductedPerMonth(tdsOnSalary,numberOfDueMonth,totalTDSDeducted);
				if(finalProcess){
					totalTDSDeducted += tdsDuePerMonth;					
				}
		
			
			
			/*double tdsDuePerMonth = getTdsDeductedPerMonth(tdsOnSalary,numberOfDueMonth,monthYears,employeeId);

			if(monthYears.length>0){
				totalTDSDeducted = getTotalTDSDeductedPreviousMonths(employeeId,monthYears,finalProcess,tdsDuePerMonth);
			}else{
				if(finalProcess){
					totalTDSDeducted = tdsDuePerMonth;
				}
			}*/
			// ==================================================================
			// ----------------Calculate previous TDS on Salary --------------

			//if (Validator.isNotNull(declaration)) {
				TaxDeclarationMonthly declarationMonthly = null;
				boolean isTaxDeclaration = false;
				try{
					declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(employeeId,Long.valueOf(monthYear));
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				if(Validator.isNull(declarationMonthly)){
					long taxDeclarationMonthlyId = CounterLocalServiceUtil.increment(TaxDeclarationMonthly.class.getName());
					declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.createTaxDeclarationMonthly(taxDeclarationMonthlyId);
					isTaxDeclaration = true;
				}	
				declarationMonthly.setAddedDate(new Date());
				// declarationMonthly.setCompanyId(the);
				declarationMonthly.setEducationCess(educationCess);
				declarationMonthly.setEmployeeId(employeeId);
				declarationMonthly.setEquitySavings(declaration.getEquitySavings());
				declarationMonthly.setFinalSubmission(declaration.getFinalSubmission());
				declarationMonthly.setFinancialYear(declaration.getFinancialYear());
				declarationMonthly.setFixedDeposit(declaration.getFixedDeposit());

				declarationMonthly.setGrossTds(grossTds);
				declarationMonthly.setHousingAddress(declaration.getHousingAddress());
				declarationMonthly.setHousingLoan(declaration.getHousingLoan());
				declarationMonthly.setHousingLoanInterest(declaration.getHousingLoanInterest());

				declarationMonthly.setHraCity(declaration.getHraCity());
				declarationMonthly.setHraExempt(hraExemptAmount);
				declarationMonthly.setHraFromDate(declaration.getHraFromDate());
				declarationMonthly.setHraIsmetro(declaration.getHraIsmetro());
				declarationMonthly.setHraLandlordPan(declaration.getHraLandlordPan());
				declarationMonthly.setHraRent(declaration.getHraRent());
				declarationMonthly.setHraToDate(declaration.getHraToDate());

				declarationMonthly.setInfraBonds(declaration.getInfraBonds());
				declarationMonthly.setInterestOnDeposit(declaration.getInterestOnDeposit());
				declarationMonthly.setIslock(declaration.getIslock());

				declarationMonthly.setLic(declaration.getLic());

				declarationMonthly.setMedicalGater60Less80(declaration.getMedicalGater60Less80());
				declarationMonthly.setMedicalGater80(declaration.getMedicalGater80());
				declarationMonthly.setMedicalHandiGater80(declaration.getMedicalHandiGater80());
				declarationMonthly.setMedicalHandiLess80(declaration.getMedicalGater60Less80());
				declarationMonthly.setMedicalIndividual(declaration.getMedicalIndividual());
				declarationMonthly.setMedicalParents(declaration.getMedicalParents());
				declarationMonthly.setMedicalParentsSenior(declaration.getMedicalParentsSenior());
				declarationMonthly.setMonthYear(Long.valueOf(monthYear));
				declarationMonthly.setMutualFunds(declaration.getMutualFunds());

				declarationMonthly.setNationalPension(declaration.getNationalPension());
				declarationMonthly.setNsc(declaration.getNsc());
				declarationMonthly.setNscInterest(declaration.getNscInterest());

				declarationMonthly.setPhysicalDisability(declaration.getPhysicalDisability());
				declarationMonthly.setPhysicalDisabilitySevere(declaration.getPhysicalDisabilitySevere());
				declarationMonthly.setPpf(declaration.getPpf());
				declarationMonthly.setPreviousIncome(declaration.getPreviousIncome());
				declarationMonthly.setPreviousPf(declaration.getPreviousPf());
				declarationMonthly.setPreviousPt(declaration.getPreviousPt());
				declarationMonthly.setPreviousTds(declaration.getPreviousTds());
				declarationMonthly.setUlip(declaration.getUlip());
				declarationMonthly.setSalaryAfterExempt(salaryAfterExempt);
				declarationMonthly.setSalaryBeforeExempt(totalPay);
				declarationMonthly.setSectionBExempt(SectionBTotalExempt);
				declarationMonthly.setSectionCExempt(sectionCTotalExempt);
				declarationMonthly.setSectionDExempt(sectionDTotalExempt);
				declarationMonthly.setSukanya(declaration.getSukanya());

				declarationMonthly.setTaxDeclarationId(declaration.getTaxDeclarationId());
				declarationMonthly.setTaxRate(declaration.getTaxRate());
				declarationMonthly.setTdsDeducted(totalTDSDeducted);
				declarationMonthly.setTdsDuePerMonth(tdsDuePerMonth);
				declarationMonthly.setTimeDeposit(declaration.getTimeDeposit());
				
				//declarationMonthly.setSalaryBeforeExempt(totalPay);
				
				// declarationMonthly.setTotalConveyance(totalConveyance);
				declarationMonthly.setTotalProvidentFund(totalPf);
				//declarationMonthly.setSectionEExempt();
				declarationMonthly.setTotalPtax(totalPtax);
				declarationMonthly.setTotalTds(tdsOnSalary);
				declarationMonthly.setGrossTds(grossTds);
				if(finalProcess){
					declarationMonthly.setCurrentMonthTax(tdsDuePerMonth);
				}				
				declarationMonthly.setTuitionFees(declaration.getTuitionFees());
				if(Validator.isNull(fnSalary)){
					//if(finalProcess){				
						if (isTaxDeclaration) {
							TaxDeclarationMonthlyLocalServiceUtil.addTaxDeclarationMonthly(declarationMonthly);
						}else{							
							TaxDeclarationMonthlyLocalServiceUtil.updateTaxDeclarationMonthly(declarationMonthly);							
						}
					/*}else{
						if (isTaxDeclaration) {
							TaxDeclarationMonthlyLocalServiceUtil.addTaxDeclarationMonthly(declarationMonthly);
						}else{							
							TaxDeclarationMonthlyLocalServiceUtil.updateTaxDeclarationMonthly(declarationMonthly);							
						}
					}*/
				}
			
		}else{
			
			double tdsOnSalary = getTDSOnSalary(grossAnnualIncome);
			tdsDuePerMonth =0;
			totalTDSDeducted =0;
			double grossTds = tdsOnSalary;
			// ---------------------------------------------------------------
			double educationCess = 0;
			boolean isTaxDeclaration = false;
			if (tdsOnSalary > 0) {
				//String educationCessStr = df2.format((tdsOnSalary * 3) / 100);
				//educationCess = Double.valueOf(educationCessStr);
				educationCess = Math.round((tdsOnSalary * 3) / 100);
				// String tdsOnSalaryStr = df2.format(tdsOnSalary + educationCess);
				// tdsOnSalary = Double.valueOf(tdsOnSalaryStr);
				tdsOnSalary = Math.round(tdsOnSalary + educationCess);
			}
			
			TaxDeclarationMonthly declarationMonthly = null;
			/*double tdsDuePerMonth = getTdsDeductedPerMonth(tdsOnSalary,numberOfDueMonth,monthYears,employeeId);
			if(monthYears.length>0){
				totalTDSDeducted = getTotalTDSDeductedPreviousMonths(employeeId,monthYears,finalProcess,tdsDuePerMonth);
				}else{
					if(finalProcess){
						totalTDSDeducted = tdsDuePerMonth;
					}
				}*/
			if(monthYears.length>0){
				totalTDSDeducted = getTotalTDSDeductedPreviousMonths(employeeId,monthYears);
			}/*else{*/
				tdsDuePerMonth = getTdsDeductedPerMonth(tdsOnSalary,numberOfDueMonth,totalTDSDeducted);
				if(finalProcess){
					totalTDSDeducted += tdsDuePerMonth;					
				}
		
			try{
				declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(employeeId,Long.valueOf(monthYear));
			}catch (Exception e) {
				// TODO: handle exception
			}

			if(Validator.isNull(declarationMonthly)){
				long taxDeclarationMonthlyId = CounterLocalServiceUtil.increment(TaxDeclarationMonthly.class.getName());
				declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.createTaxDeclarationMonthly(taxDeclarationMonthlyId);
				isTaxDeclaration = true;
			}
			//declarationMonthly.setTaxRate(declaration.getTaxRate());
			declarationMonthly.setSectionCExempt(totalPf); // no tex declaration pf will be add in sectioncExempt
			double salaryAfterExempt = (totalPay - (totalPtax+totalPf));
			declarationMonthly.setMonthYear(Long.valueOf(monthYear));
			declarationMonthly.setEmployeeId(employeeId);
			declarationMonthly.setTdsDeducted(totalTDSDeducted);
			declarationMonthly.setTdsDuePerMonth(tdsDuePerMonth);
			if(finalProcess){
				declarationMonthly.setCurrentMonthTax(tdsDuePerMonth);
			}	
			//declarationMonthly.setTimeDeposit(declaration.getTimeDeposit());
			// declarationMonthly.setTotalConveyance(totalConveyance);
			//declarationMonthly.setHraExempt(declaration.getHraExempt());
			declarationMonthly.setTotalProvidentFund(totalPf);
			declarationMonthly.setSalaryBeforeExempt(totalPay);
			declarationMonthly.setSalaryAfterExempt(salaryAfterExempt);
			declarationMonthly.setTotalPtax(totalPtax);
			declarationMonthly.setTotalTds(tdsOnSalary);
			declarationMonthly.setGrossTds(grossTds);
			declarationMonthly.setEducationCess(educationCess);
			//System.out.println("declarationMonthly..................."+declarationMonthly);
			if(Validator.isNull(fnSalary)){
				//if(finalProcess){				
					if (isTaxDeclaration) {
						TaxDeclarationMonthlyLocalServiceUtil.addTaxDeclarationMonthly(declarationMonthly);
					}else{							
						TaxDeclarationMonthlyLocalServiceUtil.updateTaxDeclarationMonthly(declarationMonthly);							
					}
				/*}else{
					if (isTaxDeclaration) {
						TaxDeclarationMonthlyLocalServiceUtil.addTaxDeclarationMonthly(declarationMonthly);
					}else{							
						TaxDeclarationMonthlyLocalServiceUtil.updateTaxDeclarationMonthly(declarationMonthly);							
					}
				}*/
			}
		}
	}
	
	
	
	
	
	private static double getTdsDeductedPerMonth(double tdsOnSalary, int numberOfDueMonth,long[] monthYears,long employeeId) {
		// TODO Auto-generated method stub
		double tdsDeductedPerMonth = 0.00;
		//totalTDSDeducted = getTotalTDSDeductedPreviousMonths(employeeId,monthYears,finalProcess,tdsDuePerMonth);
		//double dueTds = tdsOnSalary
		double tdsDeducted = 0.00;
		List<TaxDeclarationMonthly>  declarationMonthly = new ArrayList<>();
		try{
			if(monthYears.length>0){
				declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByEmployeeIdAndMonthYears(employeeId, monthYears);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

		if(declarationMonthly.size()>0){
			for (TaxDeclarationMonthly taxDeclarationMonthly : declarationMonthly) {
				tdsDeducted += taxDeclarationMonthly.getCurrentMonthTax();
			}
			//String tdsDeductedStr = df2.format(tdsDeducted);
			//tdsDeducted = Double.valueOf(tdsDeductedStr);
			tdsDeducted = Math.round(tdsDeducted);
		}	
		double dueTds = tdsOnSalary-tdsDeducted;
		//String tdsDeductedPerMonthStr = df2.format(dueTds/numberOfDueMonth);
		//tdsDeductedPerMonth = Double.valueOf(tdsDeductedPerMonthStr);
		tdsDeductedPerMonth = Math.round(dueTds/numberOfDueMonth);
		return tdsDeductedPerMonth;
	}
	private static double getTotalTDSDeductedPreviousMonths(long employeeId, long[] monthYears ,boolean finalProcess,double tdsDuePerMonth) {
		// TODO Auto-generated method stub
		
	double tdsDeducted = 0.00;
	List<TaxDeclarationMonthly>  declarationMonthly = new ArrayList<>();
	try{
		if(monthYears.length>0){
			declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByEmployeeIdAndMonthYears(employeeId, monthYears);
		}
	}catch (Exception e) {
		// TODO: handle exception
	}

	if(declarationMonthly.size()>0){
		for (TaxDeclarationMonthly taxDeclarationMonthly : declarationMonthly) {
			tdsDeducted += taxDeclarationMonthly.getCurrentMonthTax();
		}
		//String tdsDeductedStr = df2.format(tdsDeducted);
		//tdsDeducted = Double.valueOf(tdsDeductedStr);
		tdsDeducted = Math.round(tdsDeducted);
		
	}	
	/*if(finalProcess){
		tdsDeducted =tdsDeducted+ tdsDuePerMonth;
	}*/
	return tdsDeducted;
	}

	private static double getTDSOnSalary(double salaryAfterExempt) {
		// TODO Auto-generated method stub
		double tdsOnSalary = 0;
		List<IncomeTaxSlab> incomeTaxSlabList = IncomeTaxSlabLocalServiceUtil.getIncomeTaxSlabs(-1, -1);
		if(incomeTaxSlabList.size()>0){
			for (IncomeTaxSlab incomeTaxSlab : incomeTaxSlabList) {
				double taxRate = incomeTaxSlab.getTaxRate();
				double incomeFrom = incomeTaxSlab.getIncomeFrom();
				double incomeTo = incomeTaxSlab.getIncomeTo();
				double diff = incomeTo - incomeFrom;
				if(salaryAfterExempt<diff){
					diff = salaryAfterExempt;
				}
				salaryAfterExempt -= diff;
				tdsOnSalary += diff * taxRate/100;
				
			}
			//String tdsOnSalaryStr = df2.format(tdsOnSalary);
			//tdsOnSalary = Double.valueOf(tdsOnSalaryStr);
			tdsOnSalary = Math.round(tdsOnSalary);
		}
		return tdsOnSalary;
	}





	private static double getSalaryAfterHouseLoanInterest(long employeeId, double salaryAfterExempt) throws NoSuchTaxDeclarationException {
		// TODO Auto-generated method stub
		TaxDeclaration declaration = TaxDeclarationLocalServiceUtil.getTaxDeclarationByEmployeeId(employeeId);		
		if(Validator.isNotNull(declaration)){
			double houseLoanInterest = 0;
			//==================Loss from House Property========================
	        if(declaration.getHousingLoanInterest()>200000){
	        	houseLoanInterest = 200000;
	        }else{
	        	houseLoanInterest = declaration.getHousingLoanInterest();
	        }
	  //------------------------------------------------------------------
	  //----------------Salary after Section B Exempt---------------------
	        salaryAfterExempt = salaryAfterExempt - houseLoanInterest;
		}
		return salaryAfterExempt;
	}





	private static double getSalaryAfterSectionCExempt(long employeeId,double salaryAfterExempt) throws NoSuchTaxDeclarationException {
		// TODO Auto-generated method stub
		TaxDeclaration declaration = TaxDeclarationLocalServiceUtil.getTaxDeclarationByEmployeeId(employeeId);		
		if(Validator.isNotNull(declaration)){

		  //==================================================================
		  //---Section C - Chapter VIA Sec 80C(Maximum Limit INR 150,000) 
			double sectionCTotalExempt=declaration.getLic() +declaration.getPpf() +declaration.getNsc() + declaration.getInfraBonds()+  declaration.getTuitionFees() + declaration.getMutualFunds()+ declaration.getSukanya() + declaration.getUlip()+ declaration.getTimeDeposit()+ declaration.getHousingLoan()+ declaration.getFixedDeposit() + declaration.getNscInterest()+ declaration.getTotalProvidentFund();      
		  //-------------------------------------------------------------------
		  //==================================================================
		    if(sectionCTotalExempt>150000){
		    	sectionCTotalExempt = 150000;
		    }
		
		  //----------------Salary after Section C Exempt---------------------
		    salaryAfterExempt = salaryAfterExempt - sectionCTotalExempt;
		} 
		  //------------------------------------------------------------------
		  //==================================================================
		return salaryAfterExempt;
	}





	private static double getSalaryAfterMedicalExempt(long employeeId,double salaryAfterExempt) throws NoSuchTaxDeclarationException {
		// TODO Auto-generated method stub
		
		TaxDeclaration declaration = TaxDeclarationLocalServiceUtil.getTaxDeclarationByEmployeeId(employeeId);		
		if(Validator.isNotNull(declaration)){
			double medicalIndividual = declaration.getMedicalIndividual();
			double medicalParents = declaration.getMedicalParents();
			double medicalParentsSenier = declaration.getMedicalParentsSenior();
			
			if(medicalIndividual>25000){
				medicalIndividual = 25000;
			}
			if(medicalParents>25000){
				medicalParents = 25000;
			}
			if(medicalParentsSenier>30000){
				medicalParentsSenier = 30000;
			}
			double SectionBTotalExempt = medicalIndividual+medicalParents+medicalParentsSenier+declaration.getMedicalHandiGater80()+declaration.getMedicalHandiLess80()+declaration.getMedicalGater60Less80()+declaration.getMedicalGater80()+declaration.getEducationLoan()+declaration.getPhysicalDisability()+declaration.getPhysicalDisabilitySevere()+declaration.getEquitySavings()+declaration.getInterestOnDeposit()+declaration.getNationalPension();
			
			salaryAfterExempt = salaryAfterExempt - SectionBTotalExempt;
		}
		return salaryAfterExempt;
	}





	private static double getHRA(long grossAnnualIncome,long employeeId ,long[] monthYears,String monthYear,int numberOfDueMonth) throws PortalException {
		// TODO Auto-generated method stub
		
		// calculate basic 
		
		List<TaxSetting> setting = TaxSettingLocalServiceUtil.getTaxSettings(-1, -1);
		HashMap<Long, Double>  hashMap = new HashMap<>();
		double previousAmount = 0.00;
		for (TaxSetting taxSetting : setting) {
			if(monthYears.length>0){
				previousAmount =  getPreviousMonthsAmount(employeeId, monthYears, taxSetting);
			}
			double amount = getCurrentMonthAmount(employeeId,monthYear,taxSetting.getComponentId());
			//String amountStr = df2.format(previousAmount + (amount * numberOfDueMonth));
			//amount = Double.valueOf(amountStr);
			amount = Math.round(previousAmount + (amount * numberOfDueMonth));
			hashMap.put(taxSetting.getComponentId(), amount);
		} 
		int i=0;
		double annualHRAReceived = 0;
		double annualBasicPay = 0;
		double basicSalary10Per = 0;
		for(Map.Entry<Long, Double>  entry: hashMap.entrySet()){			
			if(i==0){
				annualBasicPay = entry.getValue();
				//String basicSalary10PerStr = df2.format((annualBasicPay * 10)/100);
				//basicSalary10Per = Double.valueOf(basicSalary10PerStr);
				basicSalary10Per = Math.round((annualBasicPay * 10)/100);
			} else if(i==1){
				annualHRAReceived = entry.getValue();
				
			}
			i++;
		}
		TaxDeclaration declaration = null;
		try{
			declaration = TaxDeclarationLocalServiceUtil.getTaxDeclarationByEmployeeId(employeeId);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		double hraExemptAmount = 0;
		if(Validator.isNotNull(declaration)){
			//String annualActualRentPaidStr = df2.format(declaration.getHraRent()*12);
			//double annualActualRentPaid = Double.valueOf(annualActualRentPaidStr);
			double annualActualRentPaid = Math.round(declaration.getHraRent()*12);
			double salary4050Per = 0;		
			
			//Excess of rent paid over 10% of salary
			annualActualRentPaid = annualActualRentPaid - basicSalary10Per;

	          if(annualActualRentPaid<0){     
	        	  annualActualRentPaid = 0;
	          }

	             
			if(declaration.getHraIsmetro().equalsIgnoreCase("NO")){
				//String salary4050PerStr = df2.format((grossAnnualIncome * 40)/100);
				//salary4050Per = Double.valueOf(salary4050PerStr);
				salary4050Per = Math.round((grossAnnualIncome * 40)/100);
			}else{
				salary4050Per = Math.round((grossAnnualIncome * 50)/100);
				//String salary4050PerStr = df2.format((grossAnnualIncome * 50)/100);
				//salary4050Per = Double.valueOf(salary4050PerStr);
			}
			 //The least of the above three is exempt
			 if(salary4050Per>annualHRAReceived){
				 hraExemptAmount = annualHRAReceived;
			 }else{
				 hraExemptAmount = salary4050Per;
			 }
			
			 if(hraExemptAmount > annualActualRentPaid){
				 hraExemptAmount = annualActualRentPaid;
			 }
		}
		 return hraExemptAmount;
	}





	private static double getCurrentMonthAmount(long employeeId, String monthYear, long componentId) throws NoSuchSalDetailsException, NumberFormatException {
		// TODO Auto-generated method stub
		SalDetails details = null;
		try{
			details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(employeeId, componentId, Long.valueOf(monthYear));
		}catch (Exception e) {
			// TODO: handle exception
		}
		double amount = 0;
		if(Validator.isNotNull(details)){
			amount = details.getValue();
		}
		return amount;
	}





	private static double getPreviousMonthsAmount(long employeeId, long[] monthYears, TaxSetting taxSetting) {
		
		List<SalDetails> details = new ArrayList<>();
		try{
			if(monthYears.length>0){
			details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndComponentIdAndmonthYears(employeeId, taxSetting.getComponentId(), monthYears);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}		
		double amount = 0;
		if(details.size()>0){
			for (SalDetails salDetails : details) {
				 amount = amount + salDetails.getValue();
			}
		}
		return amount;
	}

	private static long getTotalNonTaxablePriviousMonth(long employeeId, long[] monthYears) {
		// TODO Auto-generated method stub
		long totalNonTaxableAmount = 0;
		List<PayComponent> payComponentList = new ArrayList<>();
		List<SalDetails> details = new ArrayList<>();
		try{
			payComponentList = PayComponentLocalServiceUtil.findPayComponentByTaxStatusAndPayType(0, "D");;
		}catch (Exception e) {
			// TODO: handle exception
		}
		long[] payComponentIds = new long[payComponentList.size()];
        
		int i=0;
		for(PayComponent pay : payComponentList){
			payComponentIds[i] = pay.getComponentId();
			i++;		
		}
		try{
			if(monthYears.length>0){
				details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndComponentIdsAndmonthYears(employeeId, payComponentIds, monthYears);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(details.size()>0){
			for (SalDetails salDetails : details) {
				totalNonTaxableAmount += salDetails.getValue();
			}
		}
		return totalNonTaxableAmount;
	}

	private static long getTotalNonTaxableCurrentMonth(long employeeId, String monthYear) {
		// TODO Auto-generated method stub
		long totalNonTaxableAmount = 0;
		List<PayComponent> payComponentList = new ArrayList<>();
		List<SalDetails> details = new ArrayList<>();
		try{
			payComponentList = PayComponentLocalServiceUtil.findPayComponentByTaxStatusAndPayType(0, "D");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		long[] payComponentIds = new long[payComponentList.size()];
        
		int i=0;
		for(PayComponent pay : payComponentList){
			payComponentIds[i] = pay.getComponentId();
			i++;		
		}
		try{
			details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndMonthYearAndComponentIds(employeeId, Long.valueOf(monthYear), payComponentIds);
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(details.size()>0){
			for (SalDetails salDetails : details) {
				totalNonTaxableAmount += salDetails.getValue();
			}
		}	
		return totalNonTaxableAmount;
	}

	public static int getmonthCount(Date startDate, Date endDate){
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(startDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		return diffMonth+1;
	}
	public static List<String> getEarningPriviousMonthYear(Date startDate, Date endDate){
		List<String> months = new ArrayList<>();
		 Calendar startCalendar = new GregorianCalendar();
         /*String strDate = "1/04/2018";
         String enrDate = "24/03/2019";
         Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);   
         Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(enrDate);	*/	
         startCalendar.setTime(startDate);
         int startmonth = startCalendar.get(Calendar.MONTH)+1;
         int startYear = startCalendar.get(Calendar.YEAR);
		 Calendar endCalendar = new GregorianCalendar();
		 endCalendar.setTime(endDate);
         int endYear = endCalendar.get(Calendar.YEAR);
         int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
         int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
         
         if(diffMonth!=0){
        	 months.add(String.valueOf(startmonth)+String.valueOf(startYear));
        }
         int j=1;
		 for(int i=1;i<=diffMonth-1;i++){
			 if(startmonth+i>12){
				
				 months.add(String.valueOf(j++)+String.valueOf(endYear));	 
			 }else{
				 months.add(String.valueOf(startmonth+i)+String.valueOf(startYear));
			 }
			
		 }
        System.out.println("months List...."+months);
        return months;
		}
	public static long getProfessionsTaxCurrentMonth(String monthYear,long employeeId,List<String> PayearningList) throws PortalException{
	  
		 long  totalEarning = 0;
		 List<SalDetails> salDetailsList = new ArrayList<>();
		 try{
			 salDetailsList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), employeeId);
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 if(salDetailsList.size()>0){
			 for(SalDetails details:salDetailsList){
				PayComponent component = PayComponentLocalServiceUtil.getPayComponent(details.getComponentId());
				if (PayearningList.contains(component.getPayType())) {
					  totalEarning += details.getValue();
				}
			 }	
		 }
		 return getProfessionsTaxByTotalEarning(totalEarning);
	}
	public static long getpTaxPreviousMonth(long[] monthYears,long employeeId,List<String> PayearningList) throws PortalException{
		  
		 long  totalEarning = 0;
		 long totalPTax  =0;
		 List<SalDetails> salDetailsList = new ArrayList<>();
		 try{
			 int i = 0;	
			 if(monthYears.length>0){
				 for (Long s : monthYears) {
						//monthYears[i] = Long.valueOf(s);
					  try{
						salDetailsList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(s), employeeId);
					  }catch (Exception e) {
						// TODO: handle exception
					}
						//i++;
					  totalEarning = 0;
						if(salDetailsList.size()>0){
							for(SalDetails details:salDetailsList){
								PayComponent component = null;
								 try{
								 component = PayComponentLocalServiceUtil.getPayComponent(details.getComponentId());
								 }catch (Exception e) {
									// TODO: handle exception
								}
								if(Validator.isNotNull(component)){
									if (PayearningList.contains(component.getPayType())) {
										  totalEarning += details.getValue();
									}
								 }
							 }	
							totalPTax += getProfessionsTaxByTotalEarning(totalEarning);
						}
					}
				 //salDetailsList = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndMonthYears(employeeId, monthYears);
			 }
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 return  totalPTax;
	}
	public static long getProfessionsTaxByTotalEarning(long totalEarning){
		long professionTax = 0;
		if(totalEarning > 8500 && totalEarning <= 10000)
        {
			professionTax = 90;

        }else if(totalEarning > 10000 && totalEarning <= 15000)
        {
        	professionTax = 110;

        }else if(totalEarning > 15000 && totalEarning <= 25000)
        {
        	professionTax = 130;
        }else if(totalEarning > 25000 && totalEarning <= 40000)
        {
        	professionTax = 150;
        }
        else if(totalEarning > 40000)
        {
        	professionTax = 200;
        }
        //profession_tax     = profession_tax + adj_profession_tax;
		return professionTax;
	}
	private static double getTdsDeductedPerMonth(double tdsOnSalary, int numberOfDueMonth,double totalTDSDeducted) {
		// TODO Auto-generated method stub
		double tdsDeductedPerMonth = 0.00;
		double dueTds = tdsOnSalary-totalTDSDeducted;
		//String tdsDeductedPerMonthStr = df2.format(dueTds/numberOfDueMonth);
		//tdsDeductedPerMonth = Double.valueOf(tdsDeductedPerMonthStr);
		tdsDeductedPerMonth = Math.round(dueTds/numberOfDueMonth);
		return tdsDeductedPerMonth;
	}
	private static double getTotalTDSDeductedPreviousMonths(long employeeId, long[] monthYears) {
		// TODO Auto-generated method stub
		
	double tdsDeducted = 0.00;
	List<TaxDeclarationMonthly>  declarationMonthly = new ArrayList<>();
	try{
		if(monthYears.length>0){
			declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByEmployeeIdAndMonthYears(employeeId, monthYears);
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	if(declarationMonthly.size()>0){
		for (TaxDeclarationMonthly taxDeclarationMonthly : declarationMonthly) {
			tdsDeducted += taxDeclarationMonthly.getCurrentMonthTax();
		}
		//String tdsDeductedStr = df2.format(tdsDeducted);
		//tdsDeducted = Double.valueOf(tdsDeductedStr);
		tdsDeducted = Math.round(tdsDeducted);
	}	
	return tdsDeducted;
	}
	
public static List<SalaryProcessDTO> getSalaryRegister(String month,String year) throws PortalException{
		
		List<SalaryProcessDTO> dtos = new ArrayList<>();
		List<SalDetails>  detailsEmployeeList = new ArrayList<>();
		List<Employee>  employees = new ArrayList<>();
		String monthYear = month + year;
		System.out.println("monthYear.... "+monthYear);
		 String[] months = {"January", "February", "March","April", "May", "June", "July", "August","September", "October", "November", "December"};
		 String monthYr=months[Integer.valueOf(month)-1]+" "+year;
		 
		if(Validator.isNotNull(monthYear)){
			List<StopPay>  stopPaylist = new ArrayList<StopPay>();
			stopPaylist = StopPayLocalServiceUtil.findStopPayByMonthYear(Long.valueOf(monthYear));	
			long[] empIds = new long[stopPaylist.size()];
			int i=0;
			for(StopPay pay:stopPaylist){
				empIds[i] = pay.getEmployeeId();
				i++;
			}
			//	long[] empIds = {1,101};
			employees = EmployeeLocalServiceUtil.findEmployeeByStatusAndEmployeeIdNotIn(0, empIds);
			if(employees.size()>0){
				for(Employee emp:employees){
					SalaryProcessDTO  dto = new SalaryProcessDTO();					
					detailsEmployeeList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), emp.getEmployeeId());
					HashMap<Long, String> hashMap = new HashMap<>();
					for(SalDetails details:detailsEmployeeList){						
						hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
						//dto.setPayComponentId();
						//dto.setPayComponentName(payComponentName);
						//dto.setPayComponentValue();
					}
					
					dto.setEmployeeName(emp.getFirstName()+" "+emp.getLastName());
					dto.setEmployeeCode(emp.getEmployeeCode());
					dto.setAccountNumber(emp.getAccountNo());
					dto.setEmployeeId(emp.getEmployeeId());
					dto.setMonthYear(monthYr);					
					dtos.add(dto);
				}
				
			}
		}
		
		return dtos;
		
	}

public static HashMap<Long, String> getEmployeeEarningComponentWithMonthlyAdjustmentbyMonthYearAndEmployeeId(String monthYear,long empId) throws PortalException{
	
	HashMap<Long, String> hashMap = new HashMap<>();
	List<String> earningList = new ArrayList<String>();
	earningList.add(SalaryProcessPortletKeys.Earning);
	earningList.add(SalaryProcessPortletKeys.Overtime);
	earningList.add(SalaryProcessPortletKeys.Reimbursement);
	earningList.add(SalaryProcessPortletKeys.StatutoryComponent);
	List<MonthlyAdjustment> adjustmentList  = new ArrayList<>();
	if(Validator.isNotNull(monthYear)){	
		List<PayComponent>  components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		hashMap = new HashMap<>();
		for (PayComponent payComponent : components) {
			 List<EmpPayStructure>  empPayStructureList = null;
		
			 try{
				 empPayStructureList = EmpPayStructureLocalServiceUtil.findEmpPayStructureByEmployeeId(empId);
			 }catch (Exception e) {
				// TODO: handle exception
			}			 
			 try{
					adjustmentList = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByMonthYearAndEmployeeId(Long.valueOf(monthYear), empId);
				}catch (Exception e) {
		    		 System.out.println("There is no data in monthly adjustment...!");
				}
			 if(empPayStructureList.size()>0){
					for(EmpPayStructure empPayStructure:empPayStructureList){	
						boolean isMonthlyAdjustment = false;
						if(adjustmentList.size()>0){
							for(MonthlyAdjustment adjustment:adjustmentList){
								if(empPayStructure.getPayComponentId()==adjustment.getPayComponentId()){
									if (earningList.contains(payComponent.getPayType())) {
									hashMap.put(empPayStructure.getPayComponentId(), String.valueOf(empPayStructure.getComponentValue()+adjustment.getAmount()));
									isMonthlyAdjustment = true;
									}
								}
							}								
						}
						if(isMonthlyAdjustment==false){
							if (earningList.contains(payComponent.getPayType())) {
								hashMap.put(empPayStructure.getPayComponentId(), String.valueOf(empPayStructure.getComponentValue()));
							}
						}
				   }
			 }
		}
	}		
	return hashMap;		
}
public static HashMap<Long, String> getEmployeeDeductionComponentWithMonthlyAdjustmentbyMonthYearAndEmployeeId(String monthYear,long empId) throws PortalException{
	
	HashMap<Long, String> hashMap = new HashMap<>();
	List<MonthlyAdjustment> adjustmentList  = new ArrayList<>();
	if(Validator.isNotNull(monthYear)){	
		List<PayComponent>  components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		hashMap = new HashMap<>();
		for (PayComponent payComponent : components) {
			 List<EmpPayStructure>  empPayStructureList = null;
		
			 try{
				 empPayStructureList = EmpPayStructureLocalServiceUtil.findEmpPayStructureByEmployeeId(empId);
			 }catch (Exception e) {
				// TODO: handle exception
			}			 
			 try{
					adjustmentList = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByMonthYearAndEmployeeId(Long.valueOf(monthYear), empId);
				}catch (Exception e) {
		    		 System.out.println("There is no data in monthly adjustment...!");
				}
			 if(empPayStructureList.size()>0){
					for(EmpPayStructure empPayStructure:empPayStructureList){	
						boolean isMonthlyAdjustment = false;
						if(adjustmentList.size()>0){
							for(MonthlyAdjustment adjustment:adjustmentList){
								if(empPayStructure.getPayComponentId()==adjustment.getPayComponentId()){
									if (payComponent.getPayType().equalsIgnoreCase(SalaryProcessPortletKeys.Deduction)) {
									hashMap.put(empPayStructure.getPayComponentId(), String.valueOf(empPayStructure.getComponentValue()+adjustment.getAmount()));
									isMonthlyAdjustment = true;
									}
								}
							}								
						}
						if(isMonthlyAdjustment==false){
							if (payComponent.getPayType().equalsIgnoreCase(SalaryProcessPortletKeys.Deduction)) {
								hashMap.put(empPayStructure.getPayComponentId(), String.valueOf(empPayStructure.getComponentValue()));
							}
						}
					}
			 }
		}
	}		
	return hashMap;
	
	}


}
