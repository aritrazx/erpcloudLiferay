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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.TaxDeclaration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaxDeclaration in entity cache.
 *
 * @author Samaresh
 * @see TaxDeclaration
 * @generated
 */
@ProviderType
public class TaxDeclarationCacheModel implements CacheModel<TaxDeclaration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxDeclarationCacheModel)) {
			return false;
		}

		TaxDeclarationCacheModel taxDeclarationCacheModel = (TaxDeclarationCacheModel)obj;

		if (taxDeclarationId == taxDeclarationCacheModel.taxDeclarationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taxDeclarationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(121);

		sb.append("{taxDeclarationId=");
		sb.append(taxDeclarationId);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", monthYear=");
		sb.append(monthYear);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", hraFromDate=");
		sb.append(hraFromDate);
		sb.append(", hraToDate=");
		sb.append(hraToDate);
		sb.append(", hraCity=");
		sb.append(hraCity);
		sb.append(", hraIsmetro=");
		sb.append(hraIsmetro);
		sb.append(", hraLandlordPan=");
		sb.append(hraLandlordPan);
		sb.append(", hraRent=");
		sb.append(hraRent);
		sb.append(", medicalIndividual=");
		sb.append(medicalIndividual);
		sb.append(", medicalParents=");
		sb.append(medicalParents);
		sb.append(", medicalParentsSenior=");
		sb.append(medicalParentsSenior);
		sb.append(", medicalHandiLess80=");
		sb.append(medicalHandiLess80);
		sb.append(", medicalHandiGater80=");
		sb.append(medicalHandiGater80);
		sb.append(", medicalGater60Less80=");
		sb.append(medicalGater60Less80);
		sb.append(", medicalGater80=");
		sb.append(medicalGater80);
		sb.append(", educationLoan=");
		sb.append(educationLoan);
		sb.append(", physicalDisability=");
		sb.append(physicalDisability);
		sb.append(", physicalDisabilitySevere=");
		sb.append(physicalDisabilitySevere);
		sb.append(", equitySavings=");
		sb.append(equitySavings);
		sb.append(", interestOnDeposit=");
		sb.append(interestOnDeposit);
		sb.append(", nationalPension=");
		sb.append(nationalPension);
		sb.append(", lic=");
		sb.append(lic);
		sb.append(", ppf=");
		sb.append(ppf);
		sb.append(", nsc=");
		sb.append(nsc);
		sb.append(", infraBonds=");
		sb.append(infraBonds);
		sb.append(", tuitionFees=");
		sb.append(tuitionFees);
		sb.append(", mutualFunds=");
		sb.append(mutualFunds);
		sb.append(", sukanya=");
		sb.append(sukanya);
		sb.append(", ulip=");
		sb.append(ulip);
		sb.append(", timeDeposit=");
		sb.append(timeDeposit);
		sb.append(", housingLoan=");
		sb.append(housingLoan);
		sb.append(", fixedDeposit=");
		sb.append(fixedDeposit);
		sb.append(", nscInterest=");
		sb.append(nscInterest);
		sb.append(", housingLoanInterest=");
		sb.append(housingLoanInterest);
		sb.append(", housingAddress=");
		sb.append(housingAddress);
		sb.append(", previousIncome=");
		sb.append(previousIncome);
		sb.append(", previousPf=");
		sb.append(previousPf);
		sb.append(", previousPt=");
		sb.append(previousPt);
		sb.append(", previousTds=");
		sb.append(previousTds);
		sb.append(", islock=");
		sb.append(islock);
		sb.append(", finalSubmission=");
		sb.append(finalSubmission);
		sb.append(", hraExempt=");
		sb.append(hraExempt);
		sb.append(", sectionBExempt=");
		sb.append(sectionBExempt);
		sb.append(", sectionCExempt=");
		sb.append(sectionCExempt);
		sb.append(", sectionDExempt=");
		sb.append(sectionDExempt);
		sb.append(", salaryAfterExempt=");
		sb.append(salaryAfterExempt);
		sb.append(", salaryBeforeExempt=");
		sb.append(salaryBeforeExempt);
		sb.append(", taxRate=");
		sb.append(taxRate);
		sb.append(", grossTds=");
		sb.append(grossTds);
		sb.append(", totalPtax=");
		sb.append(totalPtax);
		sb.append(", totalProvidentFund=");
		sb.append(totalProvidentFund);
		sb.append(", totalTds=");
		sb.append(totalTds);
		sb.append(", tdsDeducted=");
		sb.append(tdsDeducted);
		sb.append(", tdsDuePerMonth=");
		sb.append(tdsDuePerMonth);
		sb.append(", annualIncome=");
		sb.append(annualIncome);
		sb.append(", educationcess=");
		sb.append(educationcess);
		sb.append(", addeddate=");
		sb.append(addeddate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaxDeclaration toEntityModel() {
		TaxDeclarationImpl taxDeclarationImpl = new TaxDeclarationImpl();

		taxDeclarationImpl.setTaxDeclarationId(taxDeclarationId);

		if (financialYear == null) {
			taxDeclarationImpl.setFinancialYear("");
		}
		else {
			taxDeclarationImpl.setFinancialYear(financialYear);
		}

		taxDeclarationImpl.setMonthYear(monthYear);
		taxDeclarationImpl.setEmployeeId(employeeId);
		taxDeclarationImpl.setCompanyId(companyId);

		if (hraFromDate == null) {
			taxDeclarationImpl.setHraFromDate("");
		}
		else {
			taxDeclarationImpl.setHraFromDate(hraFromDate);
		}

		if (hraToDate == null) {
			taxDeclarationImpl.setHraToDate("");
		}
		else {
			taxDeclarationImpl.setHraToDate(hraToDate);
		}

		if (hraCity == null) {
			taxDeclarationImpl.setHraCity("");
		}
		else {
			taxDeclarationImpl.setHraCity(hraCity);
		}

		if (hraIsmetro == null) {
			taxDeclarationImpl.setHraIsmetro("");
		}
		else {
			taxDeclarationImpl.setHraIsmetro(hraIsmetro);
		}

		if (hraLandlordPan == null) {
			taxDeclarationImpl.setHraLandlordPan("");
		}
		else {
			taxDeclarationImpl.setHraLandlordPan(hraLandlordPan);
		}

		taxDeclarationImpl.setHraRent(hraRent);
		taxDeclarationImpl.setMedicalIndividual(medicalIndividual);
		taxDeclarationImpl.setMedicalParents(medicalParents);
		taxDeclarationImpl.setMedicalParentsSenior(medicalParentsSenior);
		taxDeclarationImpl.setMedicalHandiLess80(medicalHandiLess80);
		taxDeclarationImpl.setMedicalHandiGater80(medicalHandiGater80);
		taxDeclarationImpl.setMedicalGater60Less80(medicalGater60Less80);
		taxDeclarationImpl.setMedicalGater80(medicalGater80);
		taxDeclarationImpl.setEducationLoan(educationLoan);
		taxDeclarationImpl.setPhysicalDisability(physicalDisability);
		taxDeclarationImpl.setPhysicalDisabilitySevere(physicalDisabilitySevere);
		taxDeclarationImpl.setEquitySavings(equitySavings);
		taxDeclarationImpl.setInterestOnDeposit(interestOnDeposit);
		taxDeclarationImpl.setNationalPension(nationalPension);
		taxDeclarationImpl.setLic(lic);
		taxDeclarationImpl.setPpf(ppf);
		taxDeclarationImpl.setNsc(nsc);
		taxDeclarationImpl.setInfraBonds(infraBonds);
		taxDeclarationImpl.setTuitionFees(tuitionFees);
		taxDeclarationImpl.setMutualFunds(mutualFunds);
		taxDeclarationImpl.setSukanya(sukanya);
		taxDeclarationImpl.setUlip(ulip);
		taxDeclarationImpl.setTimeDeposit(timeDeposit);
		taxDeclarationImpl.setHousingLoan(housingLoan);
		taxDeclarationImpl.setFixedDeposit(fixedDeposit);
		taxDeclarationImpl.setNscInterest(nscInterest);
		taxDeclarationImpl.setHousingLoanInterest(housingLoanInterest);

		if (housingAddress == null) {
			taxDeclarationImpl.setHousingAddress("");
		}
		else {
			taxDeclarationImpl.setHousingAddress(housingAddress);
		}

		taxDeclarationImpl.setPreviousIncome(previousIncome);
		taxDeclarationImpl.setPreviousPf(previousPf);
		taxDeclarationImpl.setPreviousPt(previousPt);
		taxDeclarationImpl.setPreviousTds(previousTds);
		taxDeclarationImpl.setIslock(islock);
		taxDeclarationImpl.setFinalSubmission(finalSubmission);
		taxDeclarationImpl.setHraExempt(hraExempt);
		taxDeclarationImpl.setSectionBExempt(sectionBExempt);
		taxDeclarationImpl.setSectionCExempt(sectionCExempt);
		taxDeclarationImpl.setSectionDExempt(sectionDExempt);
		taxDeclarationImpl.setSalaryAfterExempt(salaryAfterExempt);
		taxDeclarationImpl.setSalaryBeforeExempt(salaryBeforeExempt);
		taxDeclarationImpl.setTaxRate(taxRate);
		taxDeclarationImpl.setGrossTds(grossTds);
		taxDeclarationImpl.setTotalPtax(totalPtax);
		taxDeclarationImpl.setTotalProvidentFund(totalProvidentFund);
		taxDeclarationImpl.setTotalTds(totalTds);
		taxDeclarationImpl.setTdsDeducted(tdsDeducted);
		taxDeclarationImpl.setTdsDuePerMonth(tdsDuePerMonth);
		taxDeclarationImpl.setAnnualIncome(annualIncome);
		taxDeclarationImpl.setEducationcess(educationcess);

		if (addeddate == Long.MIN_VALUE) {
			taxDeclarationImpl.setAddeddate(null);
		}
		else {
			taxDeclarationImpl.setAddeddate(new Date(addeddate));
		}

		taxDeclarationImpl.resetOriginalValues();

		return taxDeclarationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taxDeclarationId = objectInput.readLong();
		financialYear = objectInput.readUTF();

		monthYear = objectInput.readInt();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();
		hraFromDate = objectInput.readUTF();
		hraToDate = objectInput.readUTF();
		hraCity = objectInput.readUTF();
		hraIsmetro = objectInput.readUTF();
		hraLandlordPan = objectInput.readUTF();

		hraRent = objectInput.readDouble();

		medicalIndividual = objectInput.readDouble();

		medicalParents = objectInput.readDouble();

		medicalParentsSenior = objectInput.readDouble();

		medicalHandiLess80 = objectInput.readDouble();

		medicalHandiGater80 = objectInput.readDouble();

		medicalGater60Less80 = objectInput.readDouble();

		medicalGater80 = objectInput.readDouble();

		educationLoan = objectInput.readDouble();

		physicalDisability = objectInput.readDouble();

		physicalDisabilitySevere = objectInput.readDouble();

		equitySavings = objectInput.readDouble();

		interestOnDeposit = objectInput.readDouble();

		nationalPension = objectInput.readDouble();

		lic = objectInput.readDouble();

		ppf = objectInput.readDouble();

		nsc = objectInput.readDouble();

		infraBonds = objectInput.readDouble();

		tuitionFees = objectInput.readDouble();

		mutualFunds = objectInput.readDouble();

		sukanya = objectInput.readDouble();

		ulip = objectInput.readDouble();

		timeDeposit = objectInput.readDouble();

		housingLoan = objectInput.readDouble();

		fixedDeposit = objectInput.readDouble();

		nscInterest = objectInput.readDouble();

		housingLoanInterest = objectInput.readDouble();
		housingAddress = objectInput.readUTF();

		previousIncome = objectInput.readDouble();

		previousPf = objectInput.readDouble();

		previousPt = objectInput.readDouble();

		previousTds = objectInput.readDouble();

		islock = objectInput.readBoolean();

		finalSubmission = objectInput.readBoolean();

		hraExempt = objectInput.readDouble();

		sectionBExempt = objectInput.readDouble();

		sectionCExempt = objectInput.readDouble();

		sectionDExempt = objectInput.readDouble();

		salaryAfterExempt = objectInput.readDouble();

		salaryBeforeExempt = objectInput.readDouble();

		taxRate = objectInput.readDouble();

		grossTds = objectInput.readDouble();

		totalPtax = objectInput.readDouble();

		totalProvidentFund = objectInput.readDouble();

		totalTds = objectInput.readDouble();

		tdsDeducted = objectInput.readDouble();

		tdsDuePerMonth = objectInput.readDouble();

		annualIncome = objectInput.readDouble();

		educationcess = objectInput.readDouble();
		addeddate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taxDeclarationId);

		if (financialYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeInt(monthYear);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		if (hraFromDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hraFromDate);
		}

		if (hraToDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hraToDate);
		}

		if (hraCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hraCity);
		}

		if (hraIsmetro == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hraIsmetro);
		}

		if (hraLandlordPan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hraLandlordPan);
		}

		objectOutput.writeDouble(hraRent);

		objectOutput.writeDouble(medicalIndividual);

		objectOutput.writeDouble(medicalParents);

		objectOutput.writeDouble(medicalParentsSenior);

		objectOutput.writeDouble(medicalHandiLess80);

		objectOutput.writeDouble(medicalHandiGater80);

		objectOutput.writeDouble(medicalGater60Less80);

		objectOutput.writeDouble(medicalGater80);

		objectOutput.writeDouble(educationLoan);

		objectOutput.writeDouble(physicalDisability);

		objectOutput.writeDouble(physicalDisabilitySevere);

		objectOutput.writeDouble(equitySavings);

		objectOutput.writeDouble(interestOnDeposit);

		objectOutput.writeDouble(nationalPension);

		objectOutput.writeDouble(lic);

		objectOutput.writeDouble(ppf);

		objectOutput.writeDouble(nsc);

		objectOutput.writeDouble(infraBonds);

		objectOutput.writeDouble(tuitionFees);

		objectOutput.writeDouble(mutualFunds);

		objectOutput.writeDouble(sukanya);

		objectOutput.writeDouble(ulip);

		objectOutput.writeDouble(timeDeposit);

		objectOutput.writeDouble(housingLoan);

		objectOutput.writeDouble(fixedDeposit);

		objectOutput.writeDouble(nscInterest);

		objectOutput.writeDouble(housingLoanInterest);

		if (housingAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(housingAddress);
		}

		objectOutput.writeDouble(previousIncome);

		objectOutput.writeDouble(previousPf);

		objectOutput.writeDouble(previousPt);

		objectOutput.writeDouble(previousTds);

		objectOutput.writeBoolean(islock);

		objectOutput.writeBoolean(finalSubmission);

		objectOutput.writeDouble(hraExempt);

		objectOutput.writeDouble(sectionBExempt);

		objectOutput.writeDouble(sectionCExempt);

		objectOutput.writeDouble(sectionDExempt);

		objectOutput.writeDouble(salaryAfterExempt);

		objectOutput.writeDouble(salaryBeforeExempt);

		objectOutput.writeDouble(taxRate);

		objectOutput.writeDouble(grossTds);

		objectOutput.writeDouble(totalPtax);

		objectOutput.writeDouble(totalProvidentFund);

		objectOutput.writeDouble(totalTds);

		objectOutput.writeDouble(tdsDeducted);

		objectOutput.writeDouble(tdsDuePerMonth);

		objectOutput.writeDouble(annualIncome);

		objectOutput.writeDouble(educationcess);
		objectOutput.writeLong(addeddate);
	}

	public long taxDeclarationId;
	public String financialYear;
	public int monthYear;
	public long employeeId;
	public long companyId;
	public String hraFromDate;
	public String hraToDate;
	public String hraCity;
	public String hraIsmetro;
	public String hraLandlordPan;
	public double hraRent;
	public double medicalIndividual;
	public double medicalParents;
	public double medicalParentsSenior;
	public double medicalHandiLess80;
	public double medicalHandiGater80;
	public double medicalGater60Less80;
	public double medicalGater80;
	public double educationLoan;
	public double physicalDisability;
	public double physicalDisabilitySevere;
	public double equitySavings;
	public double interestOnDeposit;
	public double nationalPension;
	public double lic;
	public double ppf;
	public double nsc;
	public double infraBonds;
	public double tuitionFees;
	public double mutualFunds;
	public double sukanya;
	public double ulip;
	public double timeDeposit;
	public double housingLoan;
	public double fixedDeposit;
	public double nscInterest;
	public double housingLoanInterest;
	public String housingAddress;
	public double previousIncome;
	public double previousPf;
	public double previousPt;
	public double previousTds;
	public boolean islock;
	public boolean finalSubmission;
	public double hraExempt;
	public double sectionBExempt;
	public double sectionCExempt;
	public double sectionDExempt;
	public double salaryAfterExempt;
	public double salaryBeforeExempt;
	public double taxRate;
	public double grossTds;
	public double totalPtax;
	public double totalProvidentFund;
	public double totalTds;
	public double tdsDeducted;
	public double tdsDuePerMonth;
	public double annualIncome;
	public double educationcess;
	public long addeddate;
}