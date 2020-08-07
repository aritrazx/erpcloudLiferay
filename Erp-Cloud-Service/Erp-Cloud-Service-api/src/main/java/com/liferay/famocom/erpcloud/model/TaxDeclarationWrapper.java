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
 * This class is a wrapper for {@link TaxDeclaration}.
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclaration
 * @generated
 */
@ProviderType
public class TaxDeclarationWrapper implements TaxDeclaration,
	ModelWrapper<TaxDeclaration> {
	public TaxDeclarationWrapper(TaxDeclaration taxDeclaration) {
		_taxDeclaration = taxDeclaration;
	}

	@Override
	public Class<?> getModelClass() {
		return TaxDeclaration.class;
	}

	@Override
	public String getModelClassName() {
		return TaxDeclaration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxDeclarationId", getTaxDeclarationId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("monthYear", getMonthYear());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
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
		attributes.put("totalPtax", getTotalPtax());
		attributes.put("totalProvidentFund", getTotalProvidentFund());
		attributes.put("totalTds", getTotalTds());
		attributes.put("tdsDeducted", getTdsDeducted());
		attributes.put("tdsDuePerMonth", getTdsDuePerMonth());
		attributes.put("annualIncome", getAnnualIncome());
		attributes.put("educationcess", getEducationcess());
		attributes.put("addeddate", getAddeddate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taxDeclarationId = (Long)attributes.get("taxDeclarationId");

		if (taxDeclarationId != null) {
			setTaxDeclarationId(taxDeclarationId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Integer monthYear = (Integer)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Double totalPtax = (Double)attributes.get("totalPtax");

		if (totalPtax != null) {
			setTotalPtax(totalPtax);
		}

		Double totalProvidentFund = (Double)attributes.get("totalProvidentFund");

		if (totalProvidentFund != null) {
			setTotalProvidentFund(totalProvidentFund);
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

		Double annualIncome = (Double)attributes.get("annualIncome");

		if (annualIncome != null) {
			setAnnualIncome(annualIncome);
		}

		Double educationcess = (Double)attributes.get("educationcess");

		if (educationcess != null) {
			setEducationcess(educationcess);
		}

		Date addeddate = (Date)attributes.get("addeddate");

		if (addeddate != null) {
			setAddeddate(addeddate);
		}
	}

	@Override
	public Object clone() {
		return new TaxDeclarationWrapper((TaxDeclaration)_taxDeclaration.clone());
	}

	@Override
	public int compareTo(TaxDeclaration taxDeclaration) {
		return _taxDeclaration.compareTo(taxDeclaration);
	}

	/**
	* Returns the addeddate of this tax declaration.
	*
	* @return the addeddate of this tax declaration
	*/
	@Override
	public Date getAddeddate() {
		return _taxDeclaration.getAddeddate();
	}

	/**
	* Returns the annual income of this tax declaration.
	*
	* @return the annual income of this tax declaration
	*/
	@Override
	public double getAnnualIncome() {
		return _taxDeclaration.getAnnualIncome();
	}

	/**
	* Returns the company ID of this tax declaration.
	*
	* @return the company ID of this tax declaration
	*/
	@Override
	public long getCompanyId() {
		return _taxDeclaration.getCompanyId();
	}

	/**
	* Returns the educationcess of this tax declaration.
	*
	* @return the educationcess of this tax declaration
	*/
	@Override
	public double getEducationcess() {
		return _taxDeclaration.getEducationcess();
	}

	/**
	* Returns the education loan of this tax declaration.
	*
	* @return the education loan of this tax declaration
	*/
	@Override
	public double getEducationLoan() {
		return _taxDeclaration.getEducationLoan();
	}

	/**
	* Returns the employee ID of this tax declaration.
	*
	* @return the employee ID of this tax declaration
	*/
	@Override
	public long getEmployeeId() {
		return _taxDeclaration.getEmployeeId();
	}

	/**
	* Returns the equity savings of this tax declaration.
	*
	* @return the equity savings of this tax declaration
	*/
	@Override
	public double getEquitySavings() {
		return _taxDeclaration.getEquitySavings();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taxDeclaration.getExpandoBridge();
	}

	/**
	* Returns the final submission of this tax declaration.
	*
	* @return the final submission of this tax declaration
	*/
	@Override
	public boolean getFinalSubmission() {
		return _taxDeclaration.getFinalSubmission();
	}

	/**
	* Returns the financial year of this tax declaration.
	*
	* @return the financial year of this tax declaration
	*/
	@Override
	public String getFinancialYear() {
		return _taxDeclaration.getFinancialYear();
	}

	/**
	* Returns the fixed deposit of this tax declaration.
	*
	* @return the fixed deposit of this tax declaration
	*/
	@Override
	public double getFixedDeposit() {
		return _taxDeclaration.getFixedDeposit();
	}

	/**
	* Returns the gross tds of this tax declaration.
	*
	* @return the gross tds of this tax declaration
	*/
	@Override
	public double getGrossTds() {
		return _taxDeclaration.getGrossTds();
	}

	/**
	* Returns the housing address of this tax declaration.
	*
	* @return the housing address of this tax declaration
	*/
	@Override
	public String getHousingAddress() {
		return _taxDeclaration.getHousingAddress();
	}

	/**
	* Returns the housing loan of this tax declaration.
	*
	* @return the housing loan of this tax declaration
	*/
	@Override
	public double getHousingLoan() {
		return _taxDeclaration.getHousingLoan();
	}

	/**
	* Returns the housing loan interest of this tax declaration.
	*
	* @return the housing loan interest of this tax declaration
	*/
	@Override
	public double getHousingLoanInterest() {
		return _taxDeclaration.getHousingLoanInterest();
	}

	/**
	* Returns the hra city of this tax declaration.
	*
	* @return the hra city of this tax declaration
	*/
	@Override
	public String getHraCity() {
		return _taxDeclaration.getHraCity();
	}

	/**
	* Returns the hra exempt of this tax declaration.
	*
	* @return the hra exempt of this tax declaration
	*/
	@Override
	public double getHraExempt() {
		return _taxDeclaration.getHraExempt();
	}

	/**
	* Returns the hra from date of this tax declaration.
	*
	* @return the hra from date of this tax declaration
	*/
	@Override
	public String getHraFromDate() {
		return _taxDeclaration.getHraFromDate();
	}

	/**
	* Returns the hra ismetro of this tax declaration.
	*
	* @return the hra ismetro of this tax declaration
	*/
	@Override
	public String getHraIsmetro() {
		return _taxDeclaration.getHraIsmetro();
	}

	/**
	* Returns the hra landlord pan of this tax declaration.
	*
	* @return the hra landlord pan of this tax declaration
	*/
	@Override
	public String getHraLandlordPan() {
		return _taxDeclaration.getHraLandlordPan();
	}

	/**
	* Returns the hra rent of this tax declaration.
	*
	* @return the hra rent of this tax declaration
	*/
	@Override
	public double getHraRent() {
		return _taxDeclaration.getHraRent();
	}

	/**
	* Returns the hra to date of this tax declaration.
	*
	* @return the hra to date of this tax declaration
	*/
	@Override
	public String getHraToDate() {
		return _taxDeclaration.getHraToDate();
	}

	/**
	* Returns the infra bonds of this tax declaration.
	*
	* @return the infra bonds of this tax declaration
	*/
	@Override
	public double getInfraBonds() {
		return _taxDeclaration.getInfraBonds();
	}

	/**
	* Returns the interest on deposit of this tax declaration.
	*
	* @return the interest on deposit of this tax declaration
	*/
	@Override
	public double getInterestOnDeposit() {
		return _taxDeclaration.getInterestOnDeposit();
	}

	/**
	* Returns the islock of this tax declaration.
	*
	* @return the islock of this tax declaration
	*/
	@Override
	public boolean getIslock() {
		return _taxDeclaration.getIslock();
	}

	/**
	* Returns the lic of this tax declaration.
	*
	* @return the lic of this tax declaration
	*/
	@Override
	public double getLic() {
		return _taxDeclaration.getLic();
	}

	/**
	* Returns the medical gater60 less80 of this tax declaration.
	*
	* @return the medical gater60 less80 of this tax declaration
	*/
	@Override
	public double getMedicalGater60Less80() {
		return _taxDeclaration.getMedicalGater60Less80();
	}

	/**
	* Returns the medical gater80 of this tax declaration.
	*
	* @return the medical gater80 of this tax declaration
	*/
	@Override
	public double getMedicalGater80() {
		return _taxDeclaration.getMedicalGater80();
	}

	/**
	* Returns the medical handi gater80 of this tax declaration.
	*
	* @return the medical handi gater80 of this tax declaration
	*/
	@Override
	public double getMedicalHandiGater80() {
		return _taxDeclaration.getMedicalHandiGater80();
	}

	/**
	* Returns the medical handi less80 of this tax declaration.
	*
	* @return the medical handi less80 of this tax declaration
	*/
	@Override
	public double getMedicalHandiLess80() {
		return _taxDeclaration.getMedicalHandiLess80();
	}

	/**
	* Returns the medical individual of this tax declaration.
	*
	* @return the medical individual of this tax declaration
	*/
	@Override
	public double getMedicalIndividual() {
		return _taxDeclaration.getMedicalIndividual();
	}

	/**
	* Returns the medical parents of this tax declaration.
	*
	* @return the medical parents of this tax declaration
	*/
	@Override
	public double getMedicalParents() {
		return _taxDeclaration.getMedicalParents();
	}

	/**
	* Returns the medical parents senior of this tax declaration.
	*
	* @return the medical parents senior of this tax declaration
	*/
	@Override
	public double getMedicalParentsSenior() {
		return _taxDeclaration.getMedicalParentsSenior();
	}

	/**
	* Returns the month year of this tax declaration.
	*
	* @return the month year of this tax declaration
	*/
	@Override
	public int getMonthYear() {
		return _taxDeclaration.getMonthYear();
	}

	/**
	* Returns the mutual funds of this tax declaration.
	*
	* @return the mutual funds of this tax declaration
	*/
	@Override
	public double getMutualFunds() {
		return _taxDeclaration.getMutualFunds();
	}

	/**
	* Returns the national pension of this tax declaration.
	*
	* @return the national pension of this tax declaration
	*/
	@Override
	public double getNationalPension() {
		return _taxDeclaration.getNationalPension();
	}

	/**
	* Returns the nsc of this tax declaration.
	*
	* @return the nsc of this tax declaration
	*/
	@Override
	public double getNsc() {
		return _taxDeclaration.getNsc();
	}

	/**
	* Returns the nsc interest of this tax declaration.
	*
	* @return the nsc interest of this tax declaration
	*/
	@Override
	public double getNscInterest() {
		return _taxDeclaration.getNscInterest();
	}

	/**
	* Returns the physical disability of this tax declaration.
	*
	* @return the physical disability of this tax declaration
	*/
	@Override
	public double getPhysicalDisability() {
		return _taxDeclaration.getPhysicalDisability();
	}

	/**
	* Returns the physical disability severe of this tax declaration.
	*
	* @return the physical disability severe of this tax declaration
	*/
	@Override
	public double getPhysicalDisabilitySevere() {
		return _taxDeclaration.getPhysicalDisabilitySevere();
	}

	/**
	* Returns the ppf of this tax declaration.
	*
	* @return the ppf of this tax declaration
	*/
	@Override
	public double getPpf() {
		return _taxDeclaration.getPpf();
	}

	/**
	* Returns the previous income of this tax declaration.
	*
	* @return the previous income of this tax declaration
	*/
	@Override
	public double getPreviousIncome() {
		return _taxDeclaration.getPreviousIncome();
	}

	/**
	* Returns the previous pf of this tax declaration.
	*
	* @return the previous pf of this tax declaration
	*/
	@Override
	public double getPreviousPf() {
		return _taxDeclaration.getPreviousPf();
	}

	/**
	* Returns the previous pt of this tax declaration.
	*
	* @return the previous pt of this tax declaration
	*/
	@Override
	public double getPreviousPt() {
		return _taxDeclaration.getPreviousPt();
	}

	/**
	* Returns the previous tds of this tax declaration.
	*
	* @return the previous tds of this tax declaration
	*/
	@Override
	public double getPreviousTds() {
		return _taxDeclaration.getPreviousTds();
	}

	/**
	* Returns the primary key of this tax declaration.
	*
	* @return the primary key of this tax declaration
	*/
	@Override
	public long getPrimaryKey() {
		return _taxDeclaration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taxDeclaration.getPrimaryKeyObj();
	}

	/**
	* Returns the salary after exempt of this tax declaration.
	*
	* @return the salary after exempt of this tax declaration
	*/
	@Override
	public double getSalaryAfterExempt() {
		return _taxDeclaration.getSalaryAfterExempt();
	}

	/**
	* Returns the salary before exempt of this tax declaration.
	*
	* @return the salary before exempt of this tax declaration
	*/
	@Override
	public double getSalaryBeforeExempt() {
		return _taxDeclaration.getSalaryBeforeExempt();
	}

	/**
	* Returns the section b exempt of this tax declaration.
	*
	* @return the section b exempt of this tax declaration
	*/
	@Override
	public double getSectionBExempt() {
		return _taxDeclaration.getSectionBExempt();
	}

	/**
	* Returns the section c exempt of this tax declaration.
	*
	* @return the section c exempt of this tax declaration
	*/
	@Override
	public double getSectionCExempt() {
		return _taxDeclaration.getSectionCExempt();
	}

	/**
	* Returns the section d exempt of this tax declaration.
	*
	* @return the section d exempt of this tax declaration
	*/
	@Override
	public double getSectionDExempt() {
		return _taxDeclaration.getSectionDExempt();
	}

	/**
	* Returns the sukanya of this tax declaration.
	*
	* @return the sukanya of this tax declaration
	*/
	@Override
	public double getSukanya() {
		return _taxDeclaration.getSukanya();
	}

	/**
	* Returns the tax declaration ID of this tax declaration.
	*
	* @return the tax declaration ID of this tax declaration
	*/
	@Override
	public long getTaxDeclarationId() {
		return _taxDeclaration.getTaxDeclarationId();
	}

	/**
	* Returns the tax rate of this tax declaration.
	*
	* @return the tax rate of this tax declaration
	*/
	@Override
	public double getTaxRate() {
		return _taxDeclaration.getTaxRate();
	}

	/**
	* Returns the tds deducted of this tax declaration.
	*
	* @return the tds deducted of this tax declaration
	*/
	@Override
	public double getTdsDeducted() {
		return _taxDeclaration.getTdsDeducted();
	}

	/**
	* Returns the tds due per month of this tax declaration.
	*
	* @return the tds due per month of this tax declaration
	*/
	@Override
	public double getTdsDuePerMonth() {
		return _taxDeclaration.getTdsDuePerMonth();
	}

	/**
	* Returns the time deposit of this tax declaration.
	*
	* @return the time deposit of this tax declaration
	*/
	@Override
	public double getTimeDeposit() {
		return _taxDeclaration.getTimeDeposit();
	}

	/**
	* Returns the total provident fund of this tax declaration.
	*
	* @return the total provident fund of this tax declaration
	*/
	@Override
	public double getTotalProvidentFund() {
		return _taxDeclaration.getTotalProvidentFund();
	}

	/**
	* Returns the total ptax of this tax declaration.
	*
	* @return the total ptax of this tax declaration
	*/
	@Override
	public double getTotalPtax() {
		return _taxDeclaration.getTotalPtax();
	}

	/**
	* Returns the total tds of this tax declaration.
	*
	* @return the total tds of this tax declaration
	*/
	@Override
	public double getTotalTds() {
		return _taxDeclaration.getTotalTds();
	}

	/**
	* Returns the tuition fees of this tax declaration.
	*
	* @return the tuition fees of this tax declaration
	*/
	@Override
	public double getTuitionFees() {
		return _taxDeclaration.getTuitionFees();
	}

	/**
	* Returns the ulip of this tax declaration.
	*
	* @return the ulip of this tax declaration
	*/
	@Override
	public double getUlip() {
		return _taxDeclaration.getUlip();
	}

	@Override
	public int hashCode() {
		return _taxDeclaration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taxDeclaration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taxDeclaration.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this tax declaration is final submission.
	*
	* @return <code>true</code> if this tax declaration is final submission; <code>false</code> otherwise
	*/
	@Override
	public boolean isFinalSubmission() {
		return _taxDeclaration.isFinalSubmission();
	}

	/**
	* Returns <code>true</code> if this tax declaration is islock.
	*
	* @return <code>true</code> if this tax declaration is islock; <code>false</code> otherwise
	*/
	@Override
	public boolean isIslock() {
		return _taxDeclaration.isIslock();
	}

	@Override
	public boolean isNew() {
		return _taxDeclaration.isNew();
	}

	@Override
	public void persist() {
		_taxDeclaration.persist();
	}

	/**
	* Sets the addeddate of this tax declaration.
	*
	* @param addeddate the addeddate of this tax declaration
	*/
	@Override
	public void setAddeddate(Date addeddate) {
		_taxDeclaration.setAddeddate(addeddate);
	}

	/**
	* Sets the annual income of this tax declaration.
	*
	* @param annualIncome the annual income of this tax declaration
	*/
	@Override
	public void setAnnualIncome(double annualIncome) {
		_taxDeclaration.setAnnualIncome(annualIncome);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxDeclaration.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this tax declaration.
	*
	* @param companyId the company ID of this tax declaration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_taxDeclaration.setCompanyId(companyId);
	}

	/**
	* Sets the educationcess of this tax declaration.
	*
	* @param educationcess the educationcess of this tax declaration
	*/
	@Override
	public void setEducationcess(double educationcess) {
		_taxDeclaration.setEducationcess(educationcess);
	}

	/**
	* Sets the education loan of this tax declaration.
	*
	* @param educationLoan the education loan of this tax declaration
	*/
	@Override
	public void setEducationLoan(double educationLoan) {
		_taxDeclaration.setEducationLoan(educationLoan);
	}

	/**
	* Sets the employee ID of this tax declaration.
	*
	* @param employeeId the employee ID of this tax declaration
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_taxDeclaration.setEmployeeId(employeeId);
	}

	/**
	* Sets the equity savings of this tax declaration.
	*
	* @param equitySavings the equity savings of this tax declaration
	*/
	@Override
	public void setEquitySavings(double equitySavings) {
		_taxDeclaration.setEquitySavings(equitySavings);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taxDeclaration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taxDeclaration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taxDeclaration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this tax declaration is final submission.
	*
	* @param finalSubmission the final submission of this tax declaration
	*/
	@Override
	public void setFinalSubmission(boolean finalSubmission) {
		_taxDeclaration.setFinalSubmission(finalSubmission);
	}

	/**
	* Sets the financial year of this tax declaration.
	*
	* @param financialYear the financial year of this tax declaration
	*/
	@Override
	public void setFinancialYear(String financialYear) {
		_taxDeclaration.setFinancialYear(financialYear);
	}

	/**
	* Sets the fixed deposit of this tax declaration.
	*
	* @param fixedDeposit the fixed deposit of this tax declaration
	*/
	@Override
	public void setFixedDeposit(double fixedDeposit) {
		_taxDeclaration.setFixedDeposit(fixedDeposit);
	}

	/**
	* Sets the gross tds of this tax declaration.
	*
	* @param grossTds the gross tds of this tax declaration
	*/
	@Override
	public void setGrossTds(double grossTds) {
		_taxDeclaration.setGrossTds(grossTds);
	}

	/**
	* Sets the housing address of this tax declaration.
	*
	* @param housingAddress the housing address of this tax declaration
	*/
	@Override
	public void setHousingAddress(String housingAddress) {
		_taxDeclaration.setHousingAddress(housingAddress);
	}

	/**
	* Sets the housing loan of this tax declaration.
	*
	* @param housingLoan the housing loan of this tax declaration
	*/
	@Override
	public void setHousingLoan(double housingLoan) {
		_taxDeclaration.setHousingLoan(housingLoan);
	}

	/**
	* Sets the housing loan interest of this tax declaration.
	*
	* @param housingLoanInterest the housing loan interest of this tax declaration
	*/
	@Override
	public void setHousingLoanInterest(double housingLoanInterest) {
		_taxDeclaration.setHousingLoanInterest(housingLoanInterest);
	}

	/**
	* Sets the hra city of this tax declaration.
	*
	* @param hraCity the hra city of this tax declaration
	*/
	@Override
	public void setHraCity(String hraCity) {
		_taxDeclaration.setHraCity(hraCity);
	}

	/**
	* Sets the hra exempt of this tax declaration.
	*
	* @param hraExempt the hra exempt of this tax declaration
	*/
	@Override
	public void setHraExempt(double hraExempt) {
		_taxDeclaration.setHraExempt(hraExempt);
	}

	/**
	* Sets the hra from date of this tax declaration.
	*
	* @param hraFromDate the hra from date of this tax declaration
	*/
	@Override
	public void setHraFromDate(String hraFromDate) {
		_taxDeclaration.setHraFromDate(hraFromDate);
	}

	/**
	* Sets the hra ismetro of this tax declaration.
	*
	* @param hraIsmetro the hra ismetro of this tax declaration
	*/
	@Override
	public void setHraIsmetro(String hraIsmetro) {
		_taxDeclaration.setHraIsmetro(hraIsmetro);
	}

	/**
	* Sets the hra landlord pan of this tax declaration.
	*
	* @param hraLandlordPan the hra landlord pan of this tax declaration
	*/
	@Override
	public void setHraLandlordPan(String hraLandlordPan) {
		_taxDeclaration.setHraLandlordPan(hraLandlordPan);
	}

	/**
	* Sets the hra rent of this tax declaration.
	*
	* @param hraRent the hra rent of this tax declaration
	*/
	@Override
	public void setHraRent(double hraRent) {
		_taxDeclaration.setHraRent(hraRent);
	}

	/**
	* Sets the hra to date of this tax declaration.
	*
	* @param hraToDate the hra to date of this tax declaration
	*/
	@Override
	public void setHraToDate(String hraToDate) {
		_taxDeclaration.setHraToDate(hraToDate);
	}

	/**
	* Sets the infra bonds of this tax declaration.
	*
	* @param infraBonds the infra bonds of this tax declaration
	*/
	@Override
	public void setInfraBonds(double infraBonds) {
		_taxDeclaration.setInfraBonds(infraBonds);
	}

	/**
	* Sets the interest on deposit of this tax declaration.
	*
	* @param interestOnDeposit the interest on deposit of this tax declaration
	*/
	@Override
	public void setInterestOnDeposit(double interestOnDeposit) {
		_taxDeclaration.setInterestOnDeposit(interestOnDeposit);
	}

	/**
	* Sets whether this tax declaration is islock.
	*
	* @param islock the islock of this tax declaration
	*/
	@Override
	public void setIslock(boolean islock) {
		_taxDeclaration.setIslock(islock);
	}

	/**
	* Sets the lic of this tax declaration.
	*
	* @param lic the lic of this tax declaration
	*/
	@Override
	public void setLic(double lic) {
		_taxDeclaration.setLic(lic);
	}

	/**
	* Sets the medical gater60 less80 of this tax declaration.
	*
	* @param medicalGater60Less80 the medical gater60 less80 of this tax declaration
	*/
	@Override
	public void setMedicalGater60Less80(double medicalGater60Less80) {
		_taxDeclaration.setMedicalGater60Less80(medicalGater60Less80);
	}

	/**
	* Sets the medical gater80 of this tax declaration.
	*
	* @param medicalGater80 the medical gater80 of this tax declaration
	*/
	@Override
	public void setMedicalGater80(double medicalGater80) {
		_taxDeclaration.setMedicalGater80(medicalGater80);
	}

	/**
	* Sets the medical handi gater80 of this tax declaration.
	*
	* @param medicalHandiGater80 the medical handi gater80 of this tax declaration
	*/
	@Override
	public void setMedicalHandiGater80(double medicalHandiGater80) {
		_taxDeclaration.setMedicalHandiGater80(medicalHandiGater80);
	}

	/**
	* Sets the medical handi less80 of this tax declaration.
	*
	* @param medicalHandiLess80 the medical handi less80 of this tax declaration
	*/
	@Override
	public void setMedicalHandiLess80(double medicalHandiLess80) {
		_taxDeclaration.setMedicalHandiLess80(medicalHandiLess80);
	}

	/**
	* Sets the medical individual of this tax declaration.
	*
	* @param medicalIndividual the medical individual of this tax declaration
	*/
	@Override
	public void setMedicalIndividual(double medicalIndividual) {
		_taxDeclaration.setMedicalIndividual(medicalIndividual);
	}

	/**
	* Sets the medical parents of this tax declaration.
	*
	* @param medicalParents the medical parents of this tax declaration
	*/
	@Override
	public void setMedicalParents(double medicalParents) {
		_taxDeclaration.setMedicalParents(medicalParents);
	}

	/**
	* Sets the medical parents senior of this tax declaration.
	*
	* @param medicalParentsSenior the medical parents senior of this tax declaration
	*/
	@Override
	public void setMedicalParentsSenior(double medicalParentsSenior) {
		_taxDeclaration.setMedicalParentsSenior(medicalParentsSenior);
	}

	/**
	* Sets the month year of this tax declaration.
	*
	* @param monthYear the month year of this tax declaration
	*/
	@Override
	public void setMonthYear(int monthYear) {
		_taxDeclaration.setMonthYear(monthYear);
	}

	/**
	* Sets the mutual funds of this tax declaration.
	*
	* @param mutualFunds the mutual funds of this tax declaration
	*/
	@Override
	public void setMutualFunds(double mutualFunds) {
		_taxDeclaration.setMutualFunds(mutualFunds);
	}

	/**
	* Sets the national pension of this tax declaration.
	*
	* @param nationalPension the national pension of this tax declaration
	*/
	@Override
	public void setNationalPension(double nationalPension) {
		_taxDeclaration.setNationalPension(nationalPension);
	}

	@Override
	public void setNew(boolean n) {
		_taxDeclaration.setNew(n);
	}

	/**
	* Sets the nsc of this tax declaration.
	*
	* @param nsc the nsc of this tax declaration
	*/
	@Override
	public void setNsc(double nsc) {
		_taxDeclaration.setNsc(nsc);
	}

	/**
	* Sets the nsc interest of this tax declaration.
	*
	* @param nscInterest the nsc interest of this tax declaration
	*/
	@Override
	public void setNscInterest(double nscInterest) {
		_taxDeclaration.setNscInterest(nscInterest);
	}

	/**
	* Sets the physical disability of this tax declaration.
	*
	* @param physicalDisability the physical disability of this tax declaration
	*/
	@Override
	public void setPhysicalDisability(double physicalDisability) {
		_taxDeclaration.setPhysicalDisability(physicalDisability);
	}

	/**
	* Sets the physical disability severe of this tax declaration.
	*
	* @param physicalDisabilitySevere the physical disability severe of this tax declaration
	*/
	@Override
	public void setPhysicalDisabilitySevere(double physicalDisabilitySevere) {
		_taxDeclaration.setPhysicalDisabilitySevere(physicalDisabilitySevere);
	}

	/**
	* Sets the ppf of this tax declaration.
	*
	* @param ppf the ppf of this tax declaration
	*/
	@Override
	public void setPpf(double ppf) {
		_taxDeclaration.setPpf(ppf);
	}

	/**
	* Sets the previous income of this tax declaration.
	*
	* @param previousIncome the previous income of this tax declaration
	*/
	@Override
	public void setPreviousIncome(double previousIncome) {
		_taxDeclaration.setPreviousIncome(previousIncome);
	}

	/**
	* Sets the previous pf of this tax declaration.
	*
	* @param previousPf the previous pf of this tax declaration
	*/
	@Override
	public void setPreviousPf(double previousPf) {
		_taxDeclaration.setPreviousPf(previousPf);
	}

	/**
	* Sets the previous pt of this tax declaration.
	*
	* @param previousPt the previous pt of this tax declaration
	*/
	@Override
	public void setPreviousPt(double previousPt) {
		_taxDeclaration.setPreviousPt(previousPt);
	}

	/**
	* Sets the previous tds of this tax declaration.
	*
	* @param previousTds the previous tds of this tax declaration
	*/
	@Override
	public void setPreviousTds(double previousTds) {
		_taxDeclaration.setPreviousTds(previousTds);
	}

	/**
	* Sets the primary key of this tax declaration.
	*
	* @param primaryKey the primary key of this tax declaration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taxDeclaration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taxDeclaration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the salary after exempt of this tax declaration.
	*
	* @param salaryAfterExempt the salary after exempt of this tax declaration
	*/
	@Override
	public void setSalaryAfterExempt(double salaryAfterExempt) {
		_taxDeclaration.setSalaryAfterExempt(salaryAfterExempt);
	}

	/**
	* Sets the salary before exempt of this tax declaration.
	*
	* @param salaryBeforeExempt the salary before exempt of this tax declaration
	*/
	@Override
	public void setSalaryBeforeExempt(double salaryBeforeExempt) {
		_taxDeclaration.setSalaryBeforeExempt(salaryBeforeExempt);
	}

	/**
	* Sets the section b exempt of this tax declaration.
	*
	* @param sectionBExempt the section b exempt of this tax declaration
	*/
	@Override
	public void setSectionBExempt(double sectionBExempt) {
		_taxDeclaration.setSectionBExempt(sectionBExempt);
	}

	/**
	* Sets the section c exempt of this tax declaration.
	*
	* @param sectionCExempt the section c exempt of this tax declaration
	*/
	@Override
	public void setSectionCExempt(double sectionCExempt) {
		_taxDeclaration.setSectionCExempt(sectionCExempt);
	}

	/**
	* Sets the section d exempt of this tax declaration.
	*
	* @param sectionDExempt the section d exempt of this tax declaration
	*/
	@Override
	public void setSectionDExempt(double sectionDExempt) {
		_taxDeclaration.setSectionDExempt(sectionDExempt);
	}

	/**
	* Sets the sukanya of this tax declaration.
	*
	* @param sukanya the sukanya of this tax declaration
	*/
	@Override
	public void setSukanya(double sukanya) {
		_taxDeclaration.setSukanya(sukanya);
	}

	/**
	* Sets the tax declaration ID of this tax declaration.
	*
	* @param taxDeclarationId the tax declaration ID of this tax declaration
	*/
	@Override
	public void setTaxDeclarationId(long taxDeclarationId) {
		_taxDeclaration.setTaxDeclarationId(taxDeclarationId);
	}

	/**
	* Sets the tax rate of this tax declaration.
	*
	* @param taxRate the tax rate of this tax declaration
	*/
	@Override
	public void setTaxRate(double taxRate) {
		_taxDeclaration.setTaxRate(taxRate);
	}

	/**
	* Sets the tds deducted of this tax declaration.
	*
	* @param tdsDeducted the tds deducted of this tax declaration
	*/
	@Override
	public void setTdsDeducted(double tdsDeducted) {
		_taxDeclaration.setTdsDeducted(tdsDeducted);
	}

	/**
	* Sets the tds due per month of this tax declaration.
	*
	* @param tdsDuePerMonth the tds due per month of this tax declaration
	*/
	@Override
	public void setTdsDuePerMonth(double tdsDuePerMonth) {
		_taxDeclaration.setTdsDuePerMonth(tdsDuePerMonth);
	}

	/**
	* Sets the time deposit of this tax declaration.
	*
	* @param timeDeposit the time deposit of this tax declaration
	*/
	@Override
	public void setTimeDeposit(double timeDeposit) {
		_taxDeclaration.setTimeDeposit(timeDeposit);
	}

	/**
	* Sets the total provident fund of this tax declaration.
	*
	* @param totalProvidentFund the total provident fund of this tax declaration
	*/
	@Override
	public void setTotalProvidentFund(double totalProvidentFund) {
		_taxDeclaration.setTotalProvidentFund(totalProvidentFund);
	}

	/**
	* Sets the total ptax of this tax declaration.
	*
	* @param totalPtax the total ptax of this tax declaration
	*/
	@Override
	public void setTotalPtax(double totalPtax) {
		_taxDeclaration.setTotalPtax(totalPtax);
	}

	/**
	* Sets the total tds of this tax declaration.
	*
	* @param totalTds the total tds of this tax declaration
	*/
	@Override
	public void setTotalTds(double totalTds) {
		_taxDeclaration.setTotalTds(totalTds);
	}

	/**
	* Sets the tuition fees of this tax declaration.
	*
	* @param tuitionFees the tuition fees of this tax declaration
	*/
	@Override
	public void setTuitionFees(double tuitionFees) {
		_taxDeclaration.setTuitionFees(tuitionFees);
	}

	/**
	* Sets the ulip of this tax declaration.
	*
	* @param ulip the ulip of this tax declaration
	*/
	@Override
	public void setUlip(double ulip) {
		_taxDeclaration.setUlip(ulip);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaxDeclaration> toCacheModel() {
		return _taxDeclaration.toCacheModel();
	}

	@Override
	public TaxDeclaration toEscapedModel() {
		return new TaxDeclarationWrapper(_taxDeclaration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taxDeclaration.toString();
	}

	@Override
	public TaxDeclaration toUnescapedModel() {
		return new TaxDeclarationWrapper(_taxDeclaration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taxDeclaration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxDeclarationWrapper)) {
			return false;
		}

		TaxDeclarationWrapper taxDeclarationWrapper = (TaxDeclarationWrapper)obj;

		if (Objects.equals(_taxDeclaration,
					taxDeclarationWrapper._taxDeclaration)) {
			return true;
		}

		return false;
	}

	@Override
	public TaxDeclaration getWrappedModel() {
		return _taxDeclaration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taxDeclaration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taxDeclaration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taxDeclaration.resetOriginalValues();
	}

	private final TaxDeclaration _taxDeclaration;
}