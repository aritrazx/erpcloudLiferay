/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TaxDeclarationMonthly}.
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationMonthly
 * @generated
 */
@ProviderType
public class TaxDeclarationMonthlyWrapper implements TaxDeclarationMonthly,
	ModelWrapper<TaxDeclarationMonthly> {
	public TaxDeclarationMonthlyWrapper(
		TaxDeclarationMonthly taxDeclarationMonthly) {
		_taxDeclarationMonthly = taxDeclarationMonthly;
	}

	@Override
	public Class<?> getModelClass() {
		return TaxDeclarationMonthly.class;
	}

	@Override
	public String getModelClassName() {
		return TaxDeclarationMonthly.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxDeclarationMonthlyId", getTaxDeclarationMonthlyId());
		attributes.put("taxDeclarationId", getTaxDeclarationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("monthYear", getMonthYear());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("hraFromDate", getHraFromDate());
		attributes.put("hraToDate", getHraToDate());
		attributes.put("hraCity", getHraCity());
		attributes.put("hraIsmetro", getHraIsmetro());
		attributes.put("hraLandlordPan", getHraLandlordPan());
		attributes.put("hraRent", getHraRent());
		attributes.put("medicalIndividual", getMedicalIndividual());
		attributes.put("medicalParents", getMedicalParents());
		attributes.put("medicalParentsSenior", getMedicalParentsSenior());
		attributes.put("medicalHandiLess80", getMedicalHandiLess80());
		attributes.put("medicalHandiGater80", getMedicalHandiGater80());
		attributes.put("medicalGater60Less80", getMedicalGater60Less80());
		attributes.put("medicalGater80", getMedicalGater80());
		attributes.put("educationLoan", getEducationLoan());
		attributes.put("physicalDisability", getPhysicalDisability());
		attributes.put("physicalDisabilitySevere", getPhysicalDisabilitySevere());
		attributes.put("equitySavings", getEquitySavings());
		attributes.put("interestOnDeposit", getInterestOnDeposit());
		attributes.put("nationalPension", getNationalPension());
		attributes.put("lic", getLic());
		attributes.put("ppf", getPpf());
		attributes.put("nsc", getNsc());
		attributes.put("infraBonds", getInfraBonds());
		attributes.put("tuitionFees", getTuitionFees());
		attributes.put("mutualFunds", getMutualFunds());
		attributes.put("sukanya", getSukanya());
		attributes.put("ulip", getUlip());
		attributes.put("timeDeposit", getTimeDeposit());
		attributes.put("housingLoan", getHousingLoan());
		attributes.put("fixedDeposit", getFixedDeposit());
		attributes.put("nscInterest", getNscInterest());
		attributes.put("housingLoanInterest", getHousingLoanInterest());
		attributes.put("housingAddress", getHousingAddress());
		attributes.put("previousIncome", getPreviousIncome());
		attributes.put("previousPf", getPreviousPf());
		attributes.put("previousPt", getPreviousPt());
		attributes.put("previousTds", getPreviousTds());
		attributes.put("islock", isIslock());
		attributes.put("finalSubmission", isFinalSubmission());
		attributes.put("hraExempt", getHraExempt());
		attributes.put("sectionBExempt", getSectionBExempt());
		attributes.put("sectionCExempt", getSectionCExempt());
		attributes.put("sectionDExempt", getSectionDExempt());
		attributes.put("salaryAfterExempt", getSalaryAfterExempt());
		attributes.put("salaryBeforeExempt", getSalaryBeforeExempt());
		attributes.put("taxRate", getTaxRate());
		attributes.put("grossTds", getGrossTds());
		attributes.put("totalTds", getTotalTds());
		attributes.put("tdsDeducted", getTdsDeducted());
		attributes.put("tdsDuePerMonth", getTdsDuePerMonth());
		attributes.put("educationCess", getEducationCess());
		attributes.put("totalPtax", getTotalPtax());
		attributes.put("totalProvidentFund", getTotalProvidentFund());
		attributes.put("totalConveyance", getTotalConveyance());
		attributes.put("addedDate", getAddedDate());
		attributes.put("currentMonthTax", getCurrentMonthTax());
		attributes.put("sectionEExempt", getSectionEExempt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taxDeclarationMonthlyId = (Long)attributes.get(
				"taxDeclarationMonthlyId");

		if (taxDeclarationMonthlyId != null) {
			setTaxDeclarationMonthlyId(taxDeclarationMonthlyId);
		}

		Long taxDeclarationId = (Long)attributes.get("taxDeclarationId");

		if (taxDeclarationId != null) {
			setTaxDeclarationId(taxDeclarationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String hraFromDate = (String)attributes.get("hraFromDate");

		if (hraFromDate != null) {
			setHraFromDate(hraFromDate);
		}

		String hraToDate = (String)attributes.get("hraToDate");

		if (hraToDate != null) {
			setHraToDate(hraToDate);
		}

		String hraCity = (String)attributes.get("hraCity");

		if (hraCity != null) {
			setHraCity(hraCity);
		}

		String hraIsmetro = (String)attributes.get("hraIsmetro");

		if (hraIsmetro != null) {
			setHraIsmetro(hraIsmetro);
		}

		String hraLandlordPan = (String)attributes.get("hraLandlordPan");

		if (hraLandlordPan != null) {
			setHraLandlordPan(hraLandlordPan);
		}

		Double hraRent = (Double)attributes.get("hraRent");

		if (hraRent != null) {
			setHraRent(hraRent);
		}

		Double medicalIndividual = (Double)attributes.get("medicalIndividual");

		if (medicalIndividual != null) {
			setMedicalIndividual(medicalIndividual);
		}

		Double medicalParents = (Double)attributes.get("medicalParents");

		if (medicalParents != null) {
			setMedicalParents(medicalParents);
		}

		Double medicalParentsSenior = (Double)attributes.get(
				"medicalParentsSenior");

		if (medicalParentsSenior != null) {
			setMedicalParentsSenior(medicalParentsSenior);
		}

		Double medicalHandiLess80 = (Double)attributes.get("medicalHandiLess80");

		if (medicalHandiLess80 != null) {
			setMedicalHandiLess80(medicalHandiLess80);
		}

		Double medicalHandiGater80 = (Double)attributes.get(
				"medicalHandiGater80");

		if (medicalHandiGater80 != null) {
			setMedicalHandiGater80(medicalHandiGater80);
		}

		Double medicalGater60Less80 = (Double)attributes.get(
				"medicalGater60Less80");

		if (medicalGater60Less80 != null) {
			setMedicalGater60Less80(medicalGater60Less80);
		}

		Double medicalGater80 = (Double)attributes.get("medicalGater80");

		if (medicalGater80 != null) {
			setMedicalGater80(medicalGater80);
		}

		Double educationLoan = (Double)attributes.get("educationLoan");

		if (educationLoan != null) {
			setEducationLoan(educationLoan);
		}

		Double physicalDisability = (Double)attributes.get("physicalDisability");

		if (physicalDisability != null) {
			setPhysicalDisability(physicalDisability);
		}

		Double physicalDisabilitySevere = (Double)attributes.get(
				"physicalDisabilitySevere");

		if (physicalDisabilitySevere != null) {
			setPhysicalDisabilitySevere(physicalDisabilitySevere);
		}

		Double equitySavings = (Double)attributes.get("equitySavings");

		if (equitySavings != null) {
			setEquitySavings(equitySavings);
		}

		Double interestOnDeposit = (Double)attributes.get("interestOnDeposit");

		if (interestOnDeposit != null) {
			setInterestOnDeposit(interestOnDeposit);
		}

		Double nationalPension = (Double)attributes.get("nationalPension");

		if (nationalPension != null) {
			setNationalPension(nationalPension);
		}

		Double lic = (Double)attributes.get("lic");

		if (lic != null) {
			setLic(lic);
		}

		Double ppf = (Double)attributes.get("ppf");

		if (ppf != null) {
			setPpf(ppf);
		}

		Double nsc = (Double)attributes.get("nsc");

		if (nsc != null) {
			setNsc(nsc);
		}

		Double infraBonds = (Double)attributes.get("infraBonds");

		if (infraBonds != null) {
			setInfraBonds(infraBonds);
		}

		Double tuitionFees = (Double)attributes.get("tuitionFees");

		if (tuitionFees != null) {
			setTuitionFees(tuitionFees);
		}

		Double mutualFunds = (Double)attributes.get("mutualFunds");

		if (mutualFunds != null) {
			setMutualFunds(mutualFunds);
		}

		Double sukanya = (Double)attributes.get("sukanya");

		if (sukanya != null) {
			setSukanya(sukanya);
		}

		Double ulip = (Double)attributes.get("ulip");

		if (ulip != null) {
			setUlip(ulip);
		}

		Double timeDeposit = (Double)attributes.get("timeDeposit");

		if (timeDeposit != null) {
			setTimeDeposit(timeDeposit);
		}

		Double housingLoan = (Double)attributes.get("housingLoan");

		if (housingLoan != null) {
			setHousingLoan(housingLoan);
		}

		Double fixedDeposit = (Double)attributes.get("fixedDeposit");

		if (fixedDeposit != null) {
			setFixedDeposit(fixedDeposit);
		}

		Double nscInterest = (Double)attributes.get("nscInterest");

		if (nscInterest != null) {
			setNscInterest(nscInterest);
		}

		Double housingLoanInterest = (Double)attributes.get(
				"housingLoanInterest");

		if (housingLoanInterest != null) {
			setHousingLoanInterest(housingLoanInterest);
		}

		String housingAddress = (String)attributes.get("housingAddress");

		if (housingAddress != null) {
			setHousingAddress(housingAddress);
		}

		Double previousIncome = (Double)attributes.get("previousIncome");

		if (previousIncome != null) {
			setPreviousIncome(previousIncome);
		}

		Double previousPf = (Double)attributes.get("previousPf");

		if (previousPf != null) {
			setPreviousPf(previousPf);
		}

		Double previousPt = (Double)attributes.get("previousPt");

		if (previousPt != null) {
			setPreviousPt(previousPt);
		}

		Double previousTds = (Double)attributes.get("previousTds");

		if (previousTds != null) {
			setPreviousTds(previousTds);
		}

		Boolean islock = (Boolean)attributes.get("islock");

		if (islock != null) {
			setIslock(islock);
		}

		Boolean finalSubmission = (Boolean)attributes.get("finalSubmission");

		if (finalSubmission != null) {
			setFinalSubmission(finalSubmission);
		}

		Double hraExempt = (Double)attributes.get("hraExempt");

		if (hraExempt != null) {
			setHraExempt(hraExempt);
		}

		Double sectionBExempt = (Double)attributes.get("sectionBExempt");

		if (sectionBExempt != null) {
			setSectionBExempt(sectionBExempt);
		}

		Double sectionCExempt = (Double)attributes.get("sectionCExempt");

		if (sectionCExempt != null) {
			setSectionCExempt(sectionCExempt);
		}

		Double sectionDExempt = (Double)attributes.get("sectionDExempt");

		if (sectionDExempt != null) {
			setSectionDExempt(sectionDExempt);
		}

		Double salaryAfterExempt = (Double)attributes.get("salaryAfterExempt");

		if (salaryAfterExempt != null) {
			setSalaryAfterExempt(salaryAfterExempt);
		}

		Double salaryBeforeExempt = (Double)attributes.get("salaryBeforeExempt");

		if (salaryBeforeExempt != null) {
			setSalaryBeforeExempt(salaryBeforeExempt);
		}

		Double taxRate = (Double)attributes.get("taxRate");

		if (taxRate != null) {
			setTaxRate(taxRate);
		}

		Double grossTds = (Double)attributes.get("grossTds");

		if (grossTds != null) {
			setGrossTds(grossTds);
		}

		Double totalTds = (Double)attributes.get("totalTds");

		if (totalTds != null) {
			setTotalTds(totalTds);
		}

		Double tdsDeducted = (Double)attributes.get("tdsDeducted");

		if (tdsDeducted != null) {
			setTdsDeducted(tdsDeducted);
		}

		Double tdsDuePerMonth = (Double)attributes.get("tdsDuePerMonth");

		if (tdsDuePerMonth != null) {
			setTdsDuePerMonth(tdsDuePerMonth);
		}

		Double educationCess = (Double)attributes.get("educationCess");

		if (educationCess != null) {
			setEducationCess(educationCess);
		}

		Double totalPtax = (Double)attributes.get("totalPtax");

		if (totalPtax != null) {
			setTotalPtax(totalPtax);
		}

		Double totalProvidentFund = (Double)attributes.get("totalProvidentFund");

		if (totalProvidentFund != null) {
			setTotalProvidentFund(totalProvidentFund);
		}

		Double totalConveyance = (Double)attributes.get("totalConveyance");

		if (totalConveyance != null) {
			setTotalConveyance(totalConveyance);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Double currentMonthTax = (Double)attributes.get("currentMonthTax");

		if (currentMonthTax != null) {
			setCurrentMonthTax(currentMonthTax);
		}

		Double sectionEExempt = (Double)attributes.get("sectionEExempt");

		if (sectionEExempt != null) {
			setSectionEExempt(sectionEExempt);
		}
	}

	@Override
	public Object clone() {
		return new TaxDeclarationMonthlyWrapper((TaxDeclarationMonthly)_taxDeclarationMonthly.clone());
	}

	@Override
	public int compareTo(TaxDeclarationMonthly taxDeclarationMonthly) {
		return _taxDeclarationMonthly.compareTo(taxDeclarationMonthly);
	}

	/**
	* Returns the added date of this tax declaration monthly.
	*
	* @return the added date of this tax declaration monthly
	*/
	@Override
	public Date getAddedDate() {
		return _taxDeclarationMonthly.getAddedDate();
	}

	/**
	* Returns the company ID of this tax declaration monthly.
	*
	* @return the company ID of this tax declaration monthly
	*/
	@Override
	public long getCompanyId() {
		return _taxDeclarationMonthly.getCompanyId();
	}

	/**
	* Returns the current month tax of this tax declaration monthly.
	*
	* @return the current month tax of this tax declaration monthly
	*/
	@Override
	public double getCurrentMonthTax() {
		return _taxDeclarationMonthly.getCurrentMonthTax();
	}

	/**
	* Returns the education cess of this tax declaration monthly.
	*
	* @return the education cess of this tax declaration monthly
	*/
	@Override
	public double getEducationCess() {
		return _taxDeclarationMonthly.getEducationCess();
	}

	/**
	* Returns the education loan of this tax declaration monthly.
	*
	* @return the education loan of this tax declaration monthly
	*/
	@Override
	public double getEducationLoan() {
		return _taxDeclarationMonthly.getEducationLoan();
	}

	/**
	* Returns the employee ID of this tax declaration monthly.
	*
	* @return the employee ID of this tax declaration monthly
	*/
	@Override
	public long getEmployeeId() {
		return _taxDeclarationMonthly.getEmployeeId();
	}

	/**
	* Returns the equity savings of this tax declaration monthly.
	*
	* @return the equity savings of this tax declaration monthly
	*/
	@Override
	public double getEquitySavings() {
		return _taxDeclarationMonthly.getEquitySavings();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taxDeclarationMonthly.getExpandoBridge();
	}

	/**
	* Returns the final submission of this tax declaration monthly.
	*
	* @return the final submission of this tax declaration monthly
	*/
	@Override
	public boolean getFinalSubmission() {
		return _taxDeclarationMonthly.getFinalSubmission();
	}

	/**
	* Returns the financial year of this tax declaration monthly.
	*
	* @return the financial year of this tax declaration monthly
	*/
	@Override
	public String getFinancialYear() {
		return _taxDeclarationMonthly.getFinancialYear();
	}

	/**
	* Returns the fixed deposit of this tax declaration monthly.
	*
	* @return the fixed deposit of this tax declaration monthly
	*/
	@Override
	public double getFixedDeposit() {
		return _taxDeclarationMonthly.getFixedDeposit();
	}

	/**
	* Returns the gross tds of this tax declaration monthly.
	*
	* @return the gross tds of this tax declaration monthly
	*/
	@Override
	public double getGrossTds() {
		return _taxDeclarationMonthly.getGrossTds();
	}

	/**
	* Returns the housing address of this tax declaration monthly.
	*
	* @return the housing address of this tax declaration monthly
	*/
	@Override
	public String getHousingAddress() {
		return _taxDeclarationMonthly.getHousingAddress();
	}

	/**
	* Returns the housing loan of this tax declaration monthly.
	*
	* @return the housing loan of this tax declaration monthly
	*/
	@Override
	public double getHousingLoan() {
		return _taxDeclarationMonthly.getHousingLoan();
	}

	/**
	* Returns the housing loan interest of this tax declaration monthly.
	*
	* @return the housing loan interest of this tax declaration monthly
	*/
	@Override
	public double getHousingLoanInterest() {
		return _taxDeclarationMonthly.getHousingLoanInterest();
	}

	/**
	* Returns the hra city of this tax declaration monthly.
	*
	* @return the hra city of this tax declaration monthly
	*/
	@Override
	public String getHraCity() {
		return _taxDeclarationMonthly.getHraCity();
	}

	/**
	* Returns the hra exempt of this tax declaration monthly.
	*
	* @return the hra exempt of this tax declaration monthly
	*/
	@Override
	public double getHraExempt() {
		return _taxDeclarationMonthly.getHraExempt();
	}

	/**
	* Returns the hra from date of this tax declaration monthly.
	*
	* @return the hra from date of this tax declaration monthly
	*/
	@Override
	public String getHraFromDate() {
		return _taxDeclarationMonthly.getHraFromDate();
	}

	/**
	* Returns the hra ismetro of this tax declaration monthly.
	*
	* @return the hra ismetro of this tax declaration monthly
	*/
	@Override
	public String getHraIsmetro() {
		return _taxDeclarationMonthly.getHraIsmetro();
	}

	/**
	* Returns the hra landlord pan of this tax declaration monthly.
	*
	* @return the hra landlord pan of this tax declaration monthly
	*/
	@Override
	public String getHraLandlordPan() {
		return _taxDeclarationMonthly.getHraLandlordPan();
	}

	/**
	* Returns the hra rent of this tax declaration monthly.
	*
	* @return the hra rent of this tax declaration monthly
	*/
	@Override
	public double getHraRent() {
		return _taxDeclarationMonthly.getHraRent();
	}

	/**
	* Returns the hra to date of this tax declaration monthly.
	*
	* @return the hra to date of this tax declaration monthly
	*/
	@Override
	public String getHraToDate() {
		return _taxDeclarationMonthly.getHraToDate();
	}

	/**
	* Returns the infra bonds of this tax declaration monthly.
	*
	* @return the infra bonds of this tax declaration monthly
	*/
	@Override
	public double getInfraBonds() {
		return _taxDeclarationMonthly.getInfraBonds();
	}

	/**
	* Returns the interest on deposit of this tax declaration monthly.
	*
	* @return the interest on deposit of this tax declaration monthly
	*/
	@Override
	public double getInterestOnDeposit() {
		return _taxDeclarationMonthly.getInterestOnDeposit();
	}

	/**
	* Returns the islock of this tax declaration monthly.
	*
	* @return the islock of this tax declaration monthly
	*/
	@Override
	public boolean getIslock() {
		return _taxDeclarationMonthly.getIslock();
	}

	/**
	* Returns the lic of this tax declaration monthly.
	*
	* @return the lic of this tax declaration monthly
	*/
	@Override
	public double getLic() {
		return _taxDeclarationMonthly.getLic();
	}

	/**
	* Returns the medical gater60 less80 of this tax declaration monthly.
	*
	* @return the medical gater60 less80 of this tax declaration monthly
	*/
	@Override
	public double getMedicalGater60Less80() {
		return _taxDeclarationMonthly.getMedicalGater60Less80();
	}

	/**
	* Returns the medical gater80 of this tax declaration monthly.
	*
	* @return the medical gater80 of this tax declaration monthly
	*/
	@Override
	public double getMedicalGater80() {
		return _taxDeclarationMonthly.getMedicalGater80();
	}

	/**
	* Returns the medical handi gater80 of this tax declaration monthly.
	*
	* @return the medical handi gater80 of this tax declaration monthly
	*/
	@Override
	public double getMedicalHandiGater80() {
		return _taxDeclarationMonthly.getMedicalHandiGater80();
	}

	/**
	* Returns the medical handi less80 of this tax declaration monthly.
	*
	* @return the medical handi less80 of this tax declaration monthly
	*/
	@Override
	public double getMedicalHandiLess80() {
		return _taxDeclarationMonthly.getMedicalHandiLess80();
	}

	/**
	* Returns the medical individual of this tax declaration monthly.
	*
	* @return the medical individual of this tax declaration monthly
	*/
	@Override
	public double getMedicalIndividual() {
		return _taxDeclarationMonthly.getMedicalIndividual();
	}

	/**
	* Returns the medical parents of this tax declaration monthly.
	*
	* @return the medical parents of this tax declaration monthly
	*/
	@Override
	public double getMedicalParents() {
		return _taxDeclarationMonthly.getMedicalParents();
	}

	/**
	* Returns the medical parents senior of this tax declaration monthly.
	*
	* @return the medical parents senior of this tax declaration monthly
	*/
	@Override
	public double getMedicalParentsSenior() {
		return _taxDeclarationMonthly.getMedicalParentsSenior();
	}

	/**
	* Returns the month year of this tax declaration monthly.
	*
	* @return the month year of this tax declaration monthly
	*/
	@Override
	public long getMonthYear() {
		return _taxDeclarationMonthly.getMonthYear();
	}

	/**
	* Returns the mutual funds of this tax declaration monthly.
	*
	* @return the mutual funds of this tax declaration monthly
	*/
	@Override
	public double getMutualFunds() {
		return _taxDeclarationMonthly.getMutualFunds();
	}

	/**
	* Returns the national pension of this tax declaration monthly.
	*
	* @return the national pension of this tax declaration monthly
	*/
	@Override
	public double getNationalPension() {
		return _taxDeclarationMonthly.getNationalPension();
	}

	/**
	* Returns the nsc of this tax declaration monthly.
	*
	* @return the nsc of this tax declaration monthly
	*/
	@Override
	public double getNsc() {
		return _taxDeclarationMonthly.getNsc();
	}

	/**
	* Returns the nsc interest of this tax declaration monthly.
	*
	* @return the nsc interest of this tax declaration monthly
	*/
	@Override
	public double getNscInterest() {
		return _taxDeclarationMonthly.getNscInterest();
	}

	/**
	* Returns the physical disability of this tax declaration monthly.
	*
	* @return the physical disability of this tax declaration monthly
	*/
	@Override
	public double getPhysicalDisability() {
		return _taxDeclarationMonthly.getPhysicalDisability();
	}

	/**
	* Returns the physical disability severe of this tax declaration monthly.
	*
	* @return the physical disability severe of this tax declaration monthly
	*/
	@Override
	public double getPhysicalDisabilitySevere() {
		return _taxDeclarationMonthly.getPhysicalDisabilitySevere();
	}

	/**
	* Returns the ppf of this tax declaration monthly.
	*
	* @return the ppf of this tax declaration monthly
	*/
	@Override
	public double getPpf() {
		return _taxDeclarationMonthly.getPpf();
	}

	/**
	* Returns the previous income of this tax declaration monthly.
	*
	* @return the previous income of this tax declaration monthly
	*/
	@Override
	public double getPreviousIncome() {
		return _taxDeclarationMonthly.getPreviousIncome();
	}

	/**
	* Returns the previous pf of this tax declaration monthly.
	*
	* @return the previous pf of this tax declaration monthly
	*/
	@Override
	public double getPreviousPf() {
		return _taxDeclarationMonthly.getPreviousPf();
	}

	/**
	* Returns the previous pt of this tax declaration monthly.
	*
	* @return the previous pt of this tax declaration monthly
	*/
	@Override
	public double getPreviousPt() {
		return _taxDeclarationMonthly.getPreviousPt();
	}

	/**
	* Returns the previous tds of this tax declaration monthly.
	*
	* @return the previous tds of this tax declaration monthly
	*/
	@Override
	public double getPreviousTds() {
		return _taxDeclarationMonthly.getPreviousTds();
	}

	/**
	* Returns the primary key of this tax declaration monthly.
	*
	* @return the primary key of this tax declaration monthly
	*/
	@Override
	public long getPrimaryKey() {
		return _taxDeclarationMonthly.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taxDeclarationMonthly.getPrimaryKeyObj();
	}

	/**
	* Returns the salary after exempt of this tax declaration monthly.
	*
	* @return the salary after exempt of this tax declaration monthly
	*/
	@Override
	public double getSalaryAfterExempt() {
		return _taxDeclarationMonthly.getSalaryAfterExempt();
	}

	/**
	* Returns the salary before exempt of this tax declaration monthly.
	*
	* @return the salary before exempt of this tax declaration monthly
	*/
	@Override
	public double getSalaryBeforeExempt() {
		return _taxDeclarationMonthly.getSalaryBeforeExempt();
	}

	/**
	* Returns the section b exempt of this tax declaration monthly.
	*
	* @return the section b exempt of this tax declaration monthly
	*/
	@Override
	public double getSectionBExempt() {
		return _taxDeclarationMonthly.getSectionBExempt();
	}

	/**
	* Returns the section c exempt of this tax declaration monthly.
	*
	* @return the section c exempt of this tax declaration monthly
	*/
	@Override
	public double getSectionCExempt() {
		return _taxDeclarationMonthly.getSectionCExempt();
	}

	/**
	* Returns the section d exempt of this tax declaration monthly.
	*
	* @return the section d exempt of this tax declaration monthly
	*/
	@Override
	public double getSectionDExempt() {
		return _taxDeclarationMonthly.getSectionDExempt();
	}

	/**
	* Returns the section e exempt of this tax declaration monthly.
	*
	* @return the section e exempt of this tax declaration monthly
	*/
	@Override
	public double getSectionEExempt() {
		return _taxDeclarationMonthly.getSectionEExempt();
	}

	/**
	* Returns the sukanya of this tax declaration monthly.
	*
	* @return the sukanya of this tax declaration monthly
	*/
	@Override
	public double getSukanya() {
		return _taxDeclarationMonthly.getSukanya();
	}

	/**
	* Returns the tax declaration ID of this tax declaration monthly.
	*
	* @return the tax declaration ID of this tax declaration monthly
	*/
	@Override
	public long getTaxDeclarationId() {
		return _taxDeclarationMonthly.getTaxDeclarationId();
	}

	/**
	* Returns the tax declaration monthly ID of this tax declaration monthly.
	*
	* @return the tax declaration monthly ID of this tax declaration monthly
	*/
	@Override
	public long getTaxDeclarationMonthlyId() {
		return _taxDeclarationMonthly.getTaxDeclarationMonthlyId();
	}

	/**
	* Returns the tax rate of this tax declaration monthly.
	*
	* @return the tax rate of this tax declaration monthly
	*/
	@Override
	public double getTaxRate() {
		return _taxDeclarationMonthly.getTaxRate();
	}

	/**
	* Returns the tds deducted of this tax declaration monthly.
	*
	* @return the tds deducted of this tax declaration monthly
	*/
	@Override
	public double getTdsDeducted() {
		return _taxDeclarationMonthly.getTdsDeducted();
	}

	/**
	* Returns the tds due per month of this tax declaration monthly.
	*
	* @return the tds due per month of this tax declaration monthly
	*/
	@Override
	public double getTdsDuePerMonth() {
		return _taxDeclarationMonthly.getTdsDuePerMonth();
	}

	/**
	* Returns the time deposit of this tax declaration monthly.
	*
	* @return the time deposit of this tax declaration monthly
	*/
	@Override
	public double getTimeDeposit() {
		return _taxDeclarationMonthly.getTimeDeposit();
	}

	/**
	* Returns the total conveyance of this tax declaration monthly.
	*
	* @return the total conveyance of this tax declaration monthly
	*/
	@Override
	public double getTotalConveyance() {
		return _taxDeclarationMonthly.getTotalConveyance();
	}

	/**
	* Returns the total provident fund of this tax declaration monthly.
	*
	* @return the total provident fund of this tax declaration monthly
	*/
	@Override
	public double getTotalProvidentFund() {
		return _taxDeclarationMonthly.getTotalProvidentFund();
	}

	/**
	* Returns the total ptax of this tax declaration monthly.
	*
	* @return the total ptax of this tax declaration monthly
	*/
	@Override
	public double getTotalPtax() {
		return _taxDeclarationMonthly.getTotalPtax();
	}

	/**
	* Returns the total tds of this tax declaration monthly.
	*
	* @return the total tds of this tax declaration monthly
	*/
	@Override
	public double getTotalTds() {
		return _taxDeclarationMonthly.getTotalTds();
	}

	/**
	* Returns the tuition fees of this tax declaration monthly.
	*
	* @return the tuition fees of this tax declaration monthly
	*/
	@Override
	public double getTuitionFees() {
		return _taxDeclarationMonthly.getTuitionFees();
	}

	/**
	* Returns the ulip of this tax declaration monthly.
	*
	* @return the ulip of this tax declaration monthly
	*/
	@Override
	public double getUlip() {
		return _taxDeclarationMonthly.getUlip();
	}

	@Override
	public int hashCode() {
		return _taxDeclarationMonthly.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taxDeclarationMonthly.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taxDeclarationMonthly.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this tax declaration monthly is final submission.
	*
	* @return <code>true</code> if this tax declaration monthly is final submission; <code>false</code> otherwise
	*/
	@Override
	public boolean isFinalSubmission() {
		return _taxDeclarationMonthly.isFinalSubmission();
	}

	/**
	* Returns <code>true</code> if this tax declaration monthly is islock.
	*
	* @return <code>true</code> if this tax declaration monthly is islock; <code>false</code> otherwise
	*/
	@Override
	public boolean isIslock() {
		return _taxDeclarationMonthly.isIslock();
	}

	@Override
	public boolean isNew() {
		return _taxDeclarationMonthly.isNew();
	}

	@Override
	public void persist() {
		_taxDeclarationMonthly.persist();
	}

	/**
	* Sets the added date of this tax declaration monthly.
	*
	* @param addedDate the added date of this tax declaration monthly
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_taxDeclarationMonthly.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxDeclarationMonthly.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this tax declaration monthly.
	*
	* @param companyId the company ID of this tax declaration monthly
	*/
	@Override
	public void setCompanyId(long companyId) {
		_taxDeclarationMonthly.setCompanyId(companyId);
	}

	/**
	* Sets the current month tax of this tax declaration monthly.
	*
	* @param currentMonthTax the current month tax of this tax declaration monthly
	*/
	@Override
	public void setCurrentMonthTax(double currentMonthTax) {
		_taxDeclarationMonthly.setCurrentMonthTax(currentMonthTax);
	}

	/**
	* Sets the education cess of this tax declaration monthly.
	*
	* @param educationCess the education cess of this tax declaration monthly
	*/
	@Override
	public void setEducationCess(double educationCess) {
		_taxDeclarationMonthly.setEducationCess(educationCess);
	}

	/**
	* Sets the education loan of this tax declaration monthly.
	*
	* @param educationLoan the education loan of this tax declaration monthly
	*/
	@Override
	public void setEducationLoan(double educationLoan) {
		_taxDeclarationMonthly.setEducationLoan(educationLoan);
	}

	/**
	* Sets the employee ID of this tax declaration monthly.
	*
	* @param employeeId the employee ID of this tax declaration monthly
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_taxDeclarationMonthly.setEmployeeId(employeeId);
	}

	/**
	* Sets the equity savings of this tax declaration monthly.
	*
	* @param equitySavings the equity savings of this tax declaration monthly
	*/
	@Override
	public void setEquitySavings(double equitySavings) {
		_taxDeclarationMonthly.setEquitySavings(equitySavings);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taxDeclarationMonthly.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taxDeclarationMonthly.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taxDeclarationMonthly.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this tax declaration monthly is final submission.
	*
	* @param finalSubmission the final submission of this tax declaration monthly
	*/
	@Override
	public void setFinalSubmission(boolean finalSubmission) {
		_taxDeclarationMonthly.setFinalSubmission(finalSubmission);
	}

	/**
	* Sets the financial year of this tax declaration monthly.
	*
	* @param financialYear the financial year of this tax declaration monthly
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_taxDeclarationMonthly.setFinancialYear(financialYear);
	}

	/**
	* Sets the fixed deposit of this tax declaration monthly.
	*
	* @param fixedDeposit the fixed deposit of this tax declaration monthly
	*/
	@Override
	public void setFixedDeposit(double fixedDeposit) {
		_taxDeclarationMonthly.setFixedDeposit(fixedDeposit);
	}

	/**
	* Sets the gross tds of this tax declaration monthly.
	*
	* @param grossTds the gross tds of this tax declaration monthly
	*/
	@Override
	public void setGrossTds(double grossTds) {
		_taxDeclarationMonthly.setGrossTds(grossTds);
	}

	/**
	* Sets the housing address of this tax declaration monthly.
	*
	* @param housingAddress the housing address of this tax declaration monthly
	*/
	@Override
	public void setHousingAddress(String housingAddress) {
		_taxDeclarationMonthly.setHousingAddress(housingAddress);
	}

	/**
	* Sets the housing loan of this tax declaration monthly.
	*
	* @param housingLoan the housing loan of this tax declaration monthly
	*/
	@Override
	public void setHousingLoan(double housingLoan) {
		_taxDeclarationMonthly.setHousingLoan(housingLoan);
	}

	/**
	* Sets the housing loan interest of this tax declaration monthly.
	*
	* @param housingLoanInterest the housing loan interest of this tax declaration monthly
	*/
	@Override
	public void setHousingLoanInterest(double housingLoanInterest) {
		_taxDeclarationMonthly.setHousingLoanInterest(housingLoanInterest);
	}

	/**
	* Sets the hra city of this tax declaration monthly.
	*
	* @param hraCity the hra city of this tax declaration monthly
	*/
	@Override
	public void setHraCity(String hraCity) {
		_taxDeclarationMonthly.setHraCity(hraCity);
	}

	/**
	* Sets the hra exempt of this tax declaration monthly.
	*
	* @param hraExempt the hra exempt of this tax declaration monthly
	*/
	@Override
	public void setHraExempt(double hraExempt) {
		_taxDeclarationMonthly.setHraExempt(hraExempt);
	}

	/**
	* Sets the hra from date of this tax declaration monthly.
	*
	* @param hraFromDate the hra from date of this tax declaration monthly
	*/
	@Override
	public void setHraFromDate(String hraFromDate) {
		_taxDeclarationMonthly.setHraFromDate(hraFromDate);
	}

	/**
	* Sets the hra ismetro of this tax declaration monthly.
	*
	* @param hraIsmetro the hra ismetro of this tax declaration monthly
	*/
	@Override
	public void setHraIsmetro(String hraIsmetro) {
		_taxDeclarationMonthly.setHraIsmetro(hraIsmetro);
	}

	/**
	* Sets the hra landlord pan of this tax declaration monthly.
	*
	* @param hraLandlordPan the hra landlord pan of this tax declaration monthly
	*/
	@Override
	public void setHraLandlordPan(String hraLandlordPan) {
		_taxDeclarationMonthly.setHraLandlordPan(hraLandlordPan);
	}

	/**
	* Sets the hra rent of this tax declaration monthly.
	*
	* @param hraRent the hra rent of this tax declaration monthly
	*/
	@Override
	public void setHraRent(double hraRent) {
		_taxDeclarationMonthly.setHraRent(hraRent);
	}

	/**
	* Sets the hra to date of this tax declaration monthly.
	*
	* @param hraToDate the hra to date of this tax declaration monthly
	*/
	@Override
	public void setHraToDate(String hraToDate) {
		_taxDeclarationMonthly.setHraToDate(hraToDate);
	}

	/**
	* Sets the infra bonds of this tax declaration monthly.
	*
	* @param infraBonds the infra bonds of this tax declaration monthly
	*/
	@Override
	public void setInfraBonds(double infraBonds) {
		_taxDeclarationMonthly.setInfraBonds(infraBonds);
	}

	/**
	* Sets the interest on deposit of this tax declaration monthly.
	*
	* @param interestOnDeposit the interest on deposit of this tax declaration monthly
	*/
	@Override
	public void setInterestOnDeposit(double interestOnDeposit) {
		_taxDeclarationMonthly.setInterestOnDeposit(interestOnDeposit);
	}

	/**
	* Sets whether this tax declaration monthly is islock.
	*
	* @param islock the islock of this tax declaration monthly
	*/
	@Override
	public void setIslock(boolean islock) {
		_taxDeclarationMonthly.setIslock(islock);
	}

	/**
	* Sets the lic of this tax declaration monthly.
	*
	* @param lic the lic of this tax declaration monthly
	*/
	@Override
	public void setLic(double lic) {
		_taxDeclarationMonthly.setLic(lic);
	}

	/**
	* Sets the medical gater60 less80 of this tax declaration monthly.
	*
	* @param medicalGater60Less80 the medical gater60 less80 of this tax declaration monthly
	*/
	@Override
	public void setMedicalGater60Less80(double medicalGater60Less80) {
		_taxDeclarationMonthly.setMedicalGater60Less80(medicalGater60Less80);
	}

	/**
	* Sets the medical gater80 of this tax declaration monthly.
	*
	* @param medicalGater80 the medical gater80 of this tax declaration monthly
	*/
	@Override
	public void setMedicalGater80(double medicalGater80) {
		_taxDeclarationMonthly.setMedicalGater80(medicalGater80);
	}

	/**
	* Sets the medical handi gater80 of this tax declaration monthly.
	*
	* @param medicalHandiGater80 the medical handi gater80 of this tax declaration monthly
	*/
	@Override
	public void setMedicalHandiGater80(double medicalHandiGater80) {
		_taxDeclarationMonthly.setMedicalHandiGater80(medicalHandiGater80);
	}

	/**
	* Sets the medical handi less80 of this tax declaration monthly.
	*
	* @param medicalHandiLess80 the medical handi less80 of this tax declaration monthly
	*/
	@Override
	public void setMedicalHandiLess80(double medicalHandiLess80) {
		_taxDeclarationMonthly.setMedicalHandiLess80(medicalHandiLess80);
	}

	/**
	* Sets the medical individual of this tax declaration monthly.
	*
	* @param medicalIndividual the medical individual of this tax declaration monthly
	*/
	@Override
	public void setMedicalIndividual(double medicalIndividual) {
		_taxDeclarationMonthly.setMedicalIndividual(medicalIndividual);
	}

	/**
	* Sets the medical parents of this tax declaration monthly.
	*
	* @param medicalParents the medical parents of this tax declaration monthly
	*/
	@Override
	public void setMedicalParents(double medicalParents) {
		_taxDeclarationMonthly.setMedicalParents(medicalParents);
	}

	/**
	* Sets the medical parents senior of this tax declaration monthly.
	*
	* @param medicalParentsSenior the medical parents senior of this tax declaration monthly
	*/
	@Override
	public void setMedicalParentsSenior(double medicalParentsSenior) {
		_taxDeclarationMonthly.setMedicalParentsSenior(medicalParentsSenior);
	}

	/**
	* Sets the month year of this tax declaration monthly.
	*
	* @param monthYear the month year of this tax declaration monthly
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_taxDeclarationMonthly.setMonthYear(monthYear);
	}

	/**
	* Sets the mutual funds of this tax declaration monthly.
	*
	* @param mutualFunds the mutual funds of this tax declaration monthly
	*/
	@Override
	public void setMutualFunds(double mutualFunds) {
		_taxDeclarationMonthly.setMutualFunds(mutualFunds);
	}

	/**
	* Sets the national pension of this tax declaration monthly.
	*
	* @param nationalPension the national pension of this tax declaration monthly
	*/
	@Override
	public void setNationalPension(double nationalPension) {
		_taxDeclarationMonthly.setNationalPension(nationalPension);
	}

	@Override
	public void setNew(boolean n) {
		_taxDeclarationMonthly.setNew(n);
	}

	/**
	* Sets the nsc of this tax declaration monthly.
	*
	* @param nsc the nsc of this tax declaration monthly
	*/
	@Override
	public void setNsc(double nsc) {
		_taxDeclarationMonthly.setNsc(nsc);
	}

	/**
	* Sets the nsc interest of this tax declaration monthly.
	*
	* @param nscInterest the nsc interest of this tax declaration monthly
	*/
	@Override
	public void setNscInterest(double nscInterest) {
		_taxDeclarationMonthly.setNscInterest(nscInterest);
	}

	/**
	* Sets the physical disability of this tax declaration monthly.
	*
	* @param physicalDisability the physical disability of this tax declaration monthly
	*/
	@Override
	public void setPhysicalDisability(double physicalDisability) {
		_taxDeclarationMonthly.setPhysicalDisability(physicalDisability);
	}

	/**
	* Sets the physical disability severe of this tax declaration monthly.
	*
	* @param physicalDisabilitySevere the physical disability severe of this tax declaration monthly
	*/
	@Override
	public void setPhysicalDisabilitySevere(double physicalDisabilitySevere) {
		_taxDeclarationMonthly.setPhysicalDisabilitySevere(physicalDisabilitySevere);
	}

	/**
	* Sets the ppf of this tax declaration monthly.
	*
	* @param ppf the ppf of this tax declaration monthly
	*/
	@Override
	public void setPpf(double ppf) {
		_taxDeclarationMonthly.setPpf(ppf);
	}

	/**
	* Sets the previous income of this tax declaration monthly.
	*
	* @param previousIncome the previous income of this tax declaration monthly
	*/
	@Override
	public void setPreviousIncome(double previousIncome) {
		_taxDeclarationMonthly.setPreviousIncome(previousIncome);
	}

	/**
	* Sets the previous pf of this tax declaration monthly.
	*
	* @param previousPf the previous pf of this tax declaration monthly
	*/
	@Override
	public void setPreviousPf(double previousPf) {
		_taxDeclarationMonthly.setPreviousPf(previousPf);
	}

	/**
	* Sets the previous pt of this tax declaration monthly.
	*
	* @param previousPt the previous pt of this tax declaration monthly
	*/
	@Override
	public void setPreviousPt(double previousPt) {
		_taxDeclarationMonthly.setPreviousPt(previousPt);
	}

	/**
	* Sets the previous tds of this tax declaration monthly.
	*
	* @param previousTds the previous tds of this tax declaration monthly
	*/
	@Override
	public void setPreviousTds(double previousTds) {
		_taxDeclarationMonthly.setPreviousTds(previousTds);
	}

	/**
	* Sets the primary key of this tax declaration monthly.
	*
	* @param primaryKey the primary key of this tax declaration monthly
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taxDeclarationMonthly.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taxDeclarationMonthly.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the salary after exempt of this tax declaration monthly.
	*
	* @param salaryAfterExempt the salary after exempt of this tax declaration monthly
	*/
	@Override
	public void setSalaryAfterExempt(double salaryAfterExempt) {
		_taxDeclarationMonthly.setSalaryAfterExempt(salaryAfterExempt);
	}

	/**
	* Sets the salary before exempt of this tax declaration monthly.
	*
	* @param salaryBeforeExempt the salary before exempt of this tax declaration monthly
	*/
	@Override
	public void setSalaryBeforeExempt(double salaryBeforeExempt) {
		_taxDeclarationMonthly.setSalaryBeforeExempt(salaryBeforeExempt);
	}

	/**
	* Sets the section b exempt of this tax declaration monthly.
	*
	* @param sectionBExempt the section b exempt of this tax declaration monthly
	*/
	@Override
	public void setSectionBExempt(double sectionBExempt) {
		_taxDeclarationMonthly.setSectionBExempt(sectionBExempt);
	}

	/**
	* Sets the section c exempt of this tax declaration monthly.
	*
	* @param sectionCExempt the section c exempt of this tax declaration monthly
	*/
	@Override
	public void setSectionCExempt(double sectionCExempt) {
		_taxDeclarationMonthly.setSectionCExempt(sectionCExempt);
	}

	/**
	* Sets the section d exempt of this tax declaration monthly.
	*
	* @param sectionDExempt the section d exempt of this tax declaration monthly
	*/
	@Override
	public void setSectionDExempt(double sectionDExempt) {
		_taxDeclarationMonthly.setSectionDExempt(sectionDExempt);
	}

	/**
	* Sets the section e exempt of this tax declaration monthly.
	*
	* @param sectionEExempt the section e exempt of this tax declaration monthly
	*/
	@Override
	public void setSectionEExempt(double sectionEExempt) {
		_taxDeclarationMonthly.setSectionEExempt(sectionEExempt);
	}

	/**
	* Sets the sukanya of this tax declaration monthly.
	*
	* @param sukanya the sukanya of this tax declaration monthly
	*/
	@Override
	public void setSukanya(double sukanya) {
		_taxDeclarationMonthly.setSukanya(sukanya);
	}

	/**
	* Sets the tax declaration ID of this tax declaration monthly.
	*
	* @param taxDeclarationId the tax declaration ID of this tax declaration monthly
	*/
	@Override
	public void setTaxDeclarationId(long taxDeclarationId) {
		_taxDeclarationMonthly.setTaxDeclarationId(taxDeclarationId);
	}

	/**
	* Sets the tax declaration monthly ID of this tax declaration monthly.
	*
	* @param taxDeclarationMonthlyId the tax declaration monthly ID of this tax declaration monthly
	*/
	@Override
	public void setTaxDeclarationMonthlyId(long taxDeclarationMonthlyId) {
		_taxDeclarationMonthly.setTaxDeclarationMonthlyId(taxDeclarationMonthlyId);
	}

	/**
	* Sets the tax rate of this tax declaration monthly.
	*
	* @param taxRate the tax rate of this tax declaration monthly
	*/
	@Override
	public void setTaxRate(double taxRate) {
		_taxDeclarationMonthly.setTaxRate(taxRate);
	}

	/**
	* Sets the tds deducted of this tax declaration monthly.
	*
	* @param tdsDeducted the tds deducted of this tax declaration monthly
	*/
	@Override
	public void setTdsDeducted(double tdsDeducted) {
		_taxDeclarationMonthly.setTdsDeducted(tdsDeducted);
	}

	/**
	* Sets the tds due per month of this tax declaration monthly.
	*
	* @param tdsDuePerMonth the tds due per month of this tax declaration monthly
	*/
	@Override
	public void setTdsDuePerMonth(double tdsDuePerMonth) {
		_taxDeclarationMonthly.setTdsDuePerMonth(tdsDuePerMonth);
	}

	/**
	* Sets the time deposit of this tax declaration monthly.
	*
	* @param timeDeposit the time deposit of this tax declaration monthly
	*/
	@Override
	public void setTimeDeposit(double timeDeposit) {
		_taxDeclarationMonthly.setTimeDeposit(timeDeposit);
	}

	/**
	* Sets the total conveyance of this tax declaration monthly.
	*
	* @param totalConveyance the total conveyance of this tax declaration monthly
	*/
	@Override
	public void setTotalConveyance(double totalConveyance) {
		_taxDeclarationMonthly.setTotalConveyance(totalConveyance);
	}

	/**
	* Sets the total provident fund of this tax declaration monthly.
	*
	* @param totalProvidentFund the total provident fund of this tax declaration monthly
	*/
	@Override
	public void setTotalProvidentFund(double totalProvidentFund) {
		_taxDeclarationMonthly.setTotalProvidentFund(totalProvidentFund);
	}

	/**
	* Sets the total ptax of this tax declaration monthly.
	*
	* @param totalPtax the total ptax of this tax declaration monthly
	*/
	@Override
	public void setTotalPtax(double totalPtax) {
		_taxDeclarationMonthly.setTotalPtax(totalPtax);
	}

	/**
	* Sets the total tds of this tax declaration monthly.
	*
	* @param totalTds the total tds of this tax declaration monthly
	*/
	@Override
	public void setTotalTds(double totalTds) {
		_taxDeclarationMonthly.setTotalTds(totalTds);
	}

	/**
	* Sets the tuition fees of this tax declaration monthly.
	*
	* @param tuitionFees the tuition fees of this tax declaration monthly
	*/
	@Override
	public void setTuitionFees(double tuitionFees) {
		_taxDeclarationMonthly.setTuitionFees(tuitionFees);
	}

	/**
	* Sets the ulip of this tax declaration monthly.
	*
	* @param ulip the ulip of this tax declaration monthly
	*/
	@Override
	public void setUlip(double ulip) {
		_taxDeclarationMonthly.setUlip(ulip);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaxDeclarationMonthly> toCacheModel() {
		return _taxDeclarationMonthly.toCacheModel();
	}

	@Override
	public TaxDeclarationMonthly toEscapedModel() {
		return new TaxDeclarationMonthlyWrapper(_taxDeclarationMonthly.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taxDeclarationMonthly.toString();
	}

	@Override
	public TaxDeclarationMonthly toUnescapedModel() {
		return new TaxDeclarationMonthlyWrapper(_taxDeclarationMonthly.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taxDeclarationMonthly.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxDeclarationMonthlyWrapper)) {
			return false;
		}

		TaxDeclarationMonthlyWrapper taxDeclarationMonthlyWrapper = (TaxDeclarationMonthlyWrapper)obj;

		if (Objects.equals(_taxDeclarationMonthly,
					taxDeclarationMonthlyWrapper._taxDeclarationMonthly)) {
			return true;
		}

		return false;
	}

	@Override
	public TaxDeclarationMonthly getWrappedModel() {
		return _taxDeclarationMonthly;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taxDeclarationMonthly.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taxDeclarationMonthly.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taxDeclarationMonthly.resetOriginalValues();
	}

	private final TaxDeclarationMonthly _taxDeclarationMonthly;
}