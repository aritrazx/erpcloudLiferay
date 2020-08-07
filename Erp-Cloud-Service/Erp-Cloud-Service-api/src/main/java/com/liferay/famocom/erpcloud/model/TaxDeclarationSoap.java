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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Samaresh
 * @generated
 */
@ProviderType
public class TaxDeclarationSoap implements Serializable {
	public static TaxDeclarationSoap toSoapModel(TaxDeclaration model) {
		TaxDeclarationSoap soapModel = new TaxDeclarationSoap();

		soapModel.setTaxDeclarationId(model.getTaxDeclarationId());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setMonthYear(model.getMonthYear());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setHraFromDate(model.getHraFromDate());
		soapModel.setHraToDate(model.getHraToDate());
		soapModel.setHraCity(model.getHraCity());
		soapModel.setHraIsmetro(model.getHraIsmetro());
		soapModel.setHraLandlordPan(model.getHraLandlordPan());
		soapModel.setHraRent(model.getHraRent());
		soapModel.setMedicalIndividual(model.getMedicalIndividual());
		soapModel.setMedicalParents(model.getMedicalParents());
		soapModel.setMedicalParentsSenior(model.getMedicalParentsSenior());
		soapModel.setMedicalHandiLess80(model.getMedicalHandiLess80());
		soapModel.setMedicalHandiGater80(model.getMedicalHandiGater80());
		soapModel.setMedicalGater60Less80(model.getMedicalGater60Less80());
		soapModel.setMedicalGater80(model.getMedicalGater80());
		soapModel.setEducationLoan(model.getEducationLoan());
		soapModel.setPhysicalDisability(model.getPhysicalDisability());
		soapModel.setPhysicalDisabilitySevere(model.getPhysicalDisabilitySevere());
		soapModel.setEquitySavings(model.getEquitySavings());
		soapModel.setInterestOnDeposit(model.getInterestOnDeposit());
		soapModel.setNationalPension(model.getNationalPension());
		soapModel.setLic(model.getLic());
		soapModel.setPpf(model.getPpf());
		soapModel.setNsc(model.getNsc());
		soapModel.setInfraBonds(model.getInfraBonds());
		soapModel.setTuitionFees(model.getTuitionFees());
		soapModel.setMutualFunds(model.getMutualFunds());
		soapModel.setSukanya(model.getSukanya());
		soapModel.setUlip(model.getUlip());
		soapModel.setTimeDeposit(model.getTimeDeposit());
		soapModel.setHousingLoan(model.getHousingLoan());
		soapModel.setFixedDeposit(model.getFixedDeposit());
		soapModel.setNscInterest(model.getNscInterest());
		soapModel.setHousingLoanInterest(model.getHousingLoanInterest());
		soapModel.setHousingAddress(model.getHousingAddress());
		soapModel.setPreviousIncome(model.getPreviousIncome());
		soapModel.setPreviousPf(model.getPreviousPf());
		soapModel.setPreviousPt(model.getPreviousPt());
		soapModel.setPreviousTds(model.getPreviousTds());
		soapModel.setIslock(model.isIslock());
		soapModel.setFinalSubmission(model.isFinalSubmission());
		soapModel.setHraExempt(model.getHraExempt());
		soapModel.setSectionBExempt(model.getSectionBExempt());
		soapModel.setSectionCExempt(model.getSectionCExempt());
		soapModel.setSectionDExempt(model.getSectionDExempt());
		soapModel.setSalaryAfterExempt(model.getSalaryAfterExempt());
		soapModel.setSalaryBeforeExempt(model.getSalaryBeforeExempt());
		soapModel.setTaxRate(model.getTaxRate());
		soapModel.setGrossTds(model.getGrossTds());
		soapModel.setTotalPtax(model.getTotalPtax());
		soapModel.setTotalProvidentFund(model.getTotalProvidentFund());
		soapModel.setTotalTds(model.getTotalTds());
		soapModel.setTdsDeducted(model.getTdsDeducted());
		soapModel.setTdsDuePerMonth(model.getTdsDuePerMonth());
		soapModel.setAnnualIncome(model.getAnnualIncome());
		soapModel.setEducationcess(model.getEducationcess());
		soapModel.setAddeddate(model.getAddeddate());

		return soapModel;
	}

	public static TaxDeclarationSoap[] toSoapModels(TaxDeclaration[] models) {
		TaxDeclarationSoap[] soapModels = new TaxDeclarationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaxDeclarationSoap[][] toSoapModels(TaxDeclaration[][] models) {
		TaxDeclarationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaxDeclarationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaxDeclarationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaxDeclarationSoap[] toSoapModels(List<TaxDeclaration> models) {
		List<TaxDeclarationSoap> soapModels = new ArrayList<TaxDeclarationSoap>(models.size());

		for (TaxDeclaration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaxDeclarationSoap[soapModels.size()]);
	}

	public TaxDeclarationSoap() {
	}

	public long getPrimaryKey() {
		return _taxDeclarationId;
	}

	public void setPrimaryKey(long pk) {
		setTaxDeclarationId(pk);
	}

	public long getTaxDeclarationId() {
		return _taxDeclarationId;
	}

	public void setTaxDeclarationId(long taxDeclarationId) {
		_taxDeclarationId = taxDeclarationId;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	public int getMonthYear() {
		return _monthYear;
	}

	public void setMonthYear(int monthYear) {
		_monthYear = monthYear;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getHraFromDate() {
		return _hraFromDate;
	}

	public void setHraFromDate(String hraFromDate) {
		_hraFromDate = hraFromDate;
	}

	public String getHraToDate() {
		return _hraToDate;
	}

	public void setHraToDate(String hraToDate) {
		_hraToDate = hraToDate;
	}

	public String getHraCity() {
		return _hraCity;
	}

	public void setHraCity(String hraCity) {
		_hraCity = hraCity;
	}

	public String getHraIsmetro() {
		return _hraIsmetro;
	}

	public void setHraIsmetro(String hraIsmetro) {
		_hraIsmetro = hraIsmetro;
	}

	public String getHraLandlordPan() {
		return _hraLandlordPan;
	}

	public void setHraLandlordPan(String hraLandlordPan) {
		_hraLandlordPan = hraLandlordPan;
	}

	public double getHraRent() {
		return _hraRent;
	}

	public void setHraRent(double hraRent) {
		_hraRent = hraRent;
	}

	public double getMedicalIndividual() {
		return _medicalIndividual;
	}

	public void setMedicalIndividual(double medicalIndividual) {
		_medicalIndividual = medicalIndividual;
	}

	public double getMedicalParents() {
		return _medicalParents;
	}

	public void setMedicalParents(double medicalParents) {
		_medicalParents = medicalParents;
	}

	public double getMedicalParentsSenior() {
		return _medicalParentsSenior;
	}

	public void setMedicalParentsSenior(double medicalParentsSenior) {
		_medicalParentsSenior = medicalParentsSenior;
	}

	public double getMedicalHandiLess80() {
		return _medicalHandiLess80;
	}

	public void setMedicalHandiLess80(double medicalHandiLess80) {
		_medicalHandiLess80 = medicalHandiLess80;
	}

	public double getMedicalHandiGater80() {
		return _medicalHandiGater80;
	}

	public void setMedicalHandiGater80(double medicalHandiGater80) {
		_medicalHandiGater80 = medicalHandiGater80;
	}

	public double getMedicalGater60Less80() {
		return _medicalGater60Less80;
	}

	public void setMedicalGater60Less80(double medicalGater60Less80) {
		_medicalGater60Less80 = medicalGater60Less80;
	}

	public double getMedicalGater80() {
		return _medicalGater80;
	}

	public void setMedicalGater80(double medicalGater80) {
		_medicalGater80 = medicalGater80;
	}

	public double getEducationLoan() {
		return _educationLoan;
	}

	public void setEducationLoan(double educationLoan) {
		_educationLoan = educationLoan;
	}

	public double getPhysicalDisability() {
		return _physicalDisability;
	}

	public void setPhysicalDisability(double physicalDisability) {
		_physicalDisability = physicalDisability;
	}

	public double getPhysicalDisabilitySevere() {
		return _physicalDisabilitySevere;
	}

	public void setPhysicalDisabilitySevere(double physicalDisabilitySevere) {
		_physicalDisabilitySevere = physicalDisabilitySevere;
	}

	public double getEquitySavings() {
		return _equitySavings;
	}

	public void setEquitySavings(double equitySavings) {
		_equitySavings = equitySavings;
	}

	public double getInterestOnDeposit() {
		return _interestOnDeposit;
	}

	public void setInterestOnDeposit(double interestOnDeposit) {
		_interestOnDeposit = interestOnDeposit;
	}

	public double getNationalPension() {
		return _nationalPension;
	}

	public void setNationalPension(double nationalPension) {
		_nationalPension = nationalPension;
	}

	public double getLic() {
		return _lic;
	}

	public void setLic(double lic) {
		_lic = lic;
	}

	public double getPpf() {
		return _ppf;
	}

	public void setPpf(double ppf) {
		_ppf = ppf;
	}

	public double getNsc() {
		return _nsc;
	}

	public void setNsc(double nsc) {
		_nsc = nsc;
	}

	public double getInfraBonds() {
		return _infraBonds;
	}

	public void setInfraBonds(double infraBonds) {
		_infraBonds = infraBonds;
	}

	public double getTuitionFees() {
		return _tuitionFees;
	}

	public void setTuitionFees(double tuitionFees) {
		_tuitionFees = tuitionFees;
	}

	public double getMutualFunds() {
		return _mutualFunds;
	}

	public void setMutualFunds(double mutualFunds) {
		_mutualFunds = mutualFunds;
	}

	public double getSukanya() {
		return _sukanya;
	}

	public void setSukanya(double sukanya) {
		_sukanya = sukanya;
	}

	public double getUlip() {
		return _ulip;
	}

	public void setUlip(double ulip) {
		_ulip = ulip;
	}

	public double getTimeDeposit() {
		return _timeDeposit;
	}

	public void setTimeDeposit(double timeDeposit) {
		_timeDeposit = timeDeposit;
	}

	public double getHousingLoan() {
		return _housingLoan;
	}

	public void setHousingLoan(double housingLoan) {
		_housingLoan = housingLoan;
	}

	public double getFixedDeposit() {
		return _fixedDeposit;
	}

	public void setFixedDeposit(double fixedDeposit) {
		_fixedDeposit = fixedDeposit;
	}

	public double getNscInterest() {
		return _nscInterest;
	}

	public void setNscInterest(double nscInterest) {
		_nscInterest = nscInterest;
	}

	public double getHousingLoanInterest() {
		return _housingLoanInterest;
	}

	public void setHousingLoanInterest(double housingLoanInterest) {
		_housingLoanInterest = housingLoanInterest;
	}

	public String getHousingAddress() {
		return _housingAddress;
	}

	public void setHousingAddress(String housingAddress) {
		_housingAddress = housingAddress;
	}

	public double getPreviousIncome() {
		return _previousIncome;
	}

	public void setPreviousIncome(double previousIncome) {
		_previousIncome = previousIncome;
	}

	public double getPreviousPf() {
		return _previousPf;
	}

	public void setPreviousPf(double previousPf) {
		_previousPf = previousPf;
	}

	public double getPreviousPt() {
		return _previousPt;
	}

	public void setPreviousPt(double previousPt) {
		_previousPt = previousPt;
	}

	public double getPreviousTds() {
		return _previousTds;
	}

	public void setPreviousTds(double previousTds) {
		_previousTds = previousTds;
	}

	public boolean getIslock() {
		return _islock;
	}

	public boolean isIslock() {
		return _islock;
	}

	public void setIslock(boolean islock) {
		_islock = islock;
	}

	public boolean getFinalSubmission() {
		return _finalSubmission;
	}

	public boolean isFinalSubmission() {
		return _finalSubmission;
	}

	public void setFinalSubmission(boolean finalSubmission) {
		_finalSubmission = finalSubmission;
	}

	public double getHraExempt() {
		return _hraExempt;
	}

	public void setHraExempt(double hraExempt) {
		_hraExempt = hraExempt;
	}

	public double getSectionBExempt() {
		return _sectionBExempt;
	}

	public void setSectionBExempt(double sectionBExempt) {
		_sectionBExempt = sectionBExempt;
	}

	public double getSectionCExempt() {
		return _sectionCExempt;
	}

	public void setSectionCExempt(double sectionCExempt) {
		_sectionCExempt = sectionCExempt;
	}

	public double getSectionDExempt() {
		return _sectionDExempt;
	}

	public void setSectionDExempt(double sectionDExempt) {
		_sectionDExempt = sectionDExempt;
	}

	public double getSalaryAfterExempt() {
		return _salaryAfterExempt;
	}

	public void setSalaryAfterExempt(double salaryAfterExempt) {
		_salaryAfterExempt = salaryAfterExempt;
	}

	public double getSalaryBeforeExempt() {
		return _salaryBeforeExempt;
	}

	public void setSalaryBeforeExempt(double salaryBeforeExempt) {
		_salaryBeforeExempt = salaryBeforeExempt;
	}

	public double getTaxRate() {
		return _taxRate;
	}

	public void setTaxRate(double taxRate) {
		_taxRate = taxRate;
	}

	public double getGrossTds() {
		return _grossTds;
	}

	public void setGrossTds(double grossTds) {
		_grossTds = grossTds;
	}

	public double getTotalPtax() {
		return _totalPtax;
	}

	public void setTotalPtax(double totalPtax) {
		_totalPtax = totalPtax;
	}

	public double getTotalProvidentFund() {
		return _totalProvidentFund;
	}

	public void setTotalProvidentFund(double totalProvidentFund) {
		_totalProvidentFund = totalProvidentFund;
	}

	public double getTotalTds() {
		return _totalTds;
	}

	public void setTotalTds(double totalTds) {
		_totalTds = totalTds;
	}

	public double getTdsDeducted() {
		return _tdsDeducted;
	}

	public void setTdsDeducted(double tdsDeducted) {
		_tdsDeducted = tdsDeducted;
	}

	public double getTdsDuePerMonth() {
		return _tdsDuePerMonth;
	}

	public void setTdsDuePerMonth(double tdsDuePerMonth) {
		_tdsDuePerMonth = tdsDuePerMonth;
	}

	public double getAnnualIncome() {
		return _annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		_annualIncome = annualIncome;
	}

	public double getEducationcess() {
		return _educationcess;
	}

	public void setEducationcess(double educationcess) {
		_educationcess = educationcess;
	}

	public Date getAddeddate() {
		return _addeddate;
	}

	public void setAddeddate(Date addeddate) {
		_addeddate = addeddate;
	}

	private long _taxDeclarationId;
	private String _financialYear;
	private int _monthYear;
	private long _employeeId;
	private long _companyId;
	private String _hraFromDate;
	private String _hraToDate;
	private String _hraCity;
	private String _hraIsmetro;
	private String _hraLandlordPan;
	private double _hraRent;
	private double _medicalIndividual;
	private double _medicalParents;
	private double _medicalParentsSenior;
	private double _medicalHandiLess80;
	private double _medicalHandiGater80;
	private double _medicalGater60Less80;
	private double _medicalGater80;
	private double _educationLoan;
	private double _physicalDisability;
	private double _physicalDisabilitySevere;
	private double _equitySavings;
	private double _interestOnDeposit;
	private double _nationalPension;
	private double _lic;
	private double _ppf;
	private double _nsc;
	private double _infraBonds;
	private double _tuitionFees;
	private double _mutualFunds;
	private double _sukanya;
	private double _ulip;
	private double _timeDeposit;
	private double _housingLoan;
	private double _fixedDeposit;
	private double _nscInterest;
	private double _housingLoanInterest;
	private String _housingAddress;
	private double _previousIncome;
	private double _previousPf;
	private double _previousPt;
	private double _previousTds;
	private boolean _islock;
	private boolean _finalSubmission;
	private double _hraExempt;
	private double _sectionBExempt;
	private double _sectionCExempt;
	private double _sectionDExempt;
	private double _salaryAfterExempt;
	private double _salaryBeforeExempt;
	private double _taxRate;
	private double _grossTds;
	private double _totalPtax;
	private double _totalProvidentFund;
	private double _totalTds;
	private double _tdsDeducted;
	private double _tdsDuePerMonth;
	private double _annualIncome;
	private double _educationcess;
	private Date _addeddate;
}