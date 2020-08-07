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

import com.liferay.famocom.erpcloud.model.Employee;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Samaresh
 * @see Employee
 * @generated
 */
@ProviderType
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)obj;

		if (employeeId == employeeCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(123);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", employeeCode=");
		sb.append(employeeCode);
		sb.append(", dateOfJoing=");
		sb.append(dateOfJoing);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", noOfChild=");
		sb.append(noOfChild);
		sb.append(", note=");
		sb.append(note);
		sb.append(", address=");
		sb.append(address);
		sb.append(", state=");
		sb.append(state);
		sb.append(", postCode=");
		sb.append(postCode);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", emaiAddress=");
		sb.append(emaiAddress);
		sb.append(", anniversary=");
		sb.append(anniversary);
		sb.append(", employeeStatus=");
		sb.append(employeeStatus);
		sb.append(", totalPay=");
		sb.append(totalPay);
		sb.append(", basicPay=");
		sb.append(basicPay);
		sb.append(", da=");
		sb.append(da);
		sb.append(", hra=");
		sb.append(hra);
		sb.append(", medical=");
		sb.append(medical);
		sb.append(", ta=");
		sb.append(ta);
		sb.append(", conveyance=");
		sb.append(conveyance);
		sb.append(", internet=");
		sb.append(internet);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", fare=");
		sb.append(fare);
		sb.append(", areas=");
		sb.append(areas);
		sb.append(", bouns=");
		sb.append(bouns);
		sb.append(", insurance=");
		sb.append(insurance);
		sb.append(", otherAllowance=");
		sb.append(otherAllowance);
		sb.append(", providentFund=");
		sb.append(providentFund);
		sb.append(", professionTax=");
		sb.append(professionTax);
		sb.append(", incomeTax=");
		sb.append(incomeTax);
		sb.append(", loan=");
		sb.append(loan);
		sb.append(", otherDeduction=");
		sb.append(otherDeduction);
		sb.append(", bankId=");
		sb.append(bankId);
		sb.append(", branchAddress=");
		sb.append(branchAddress);
		sb.append(", accountNo=");
		sb.append(accountNo);
		sb.append(", pfNo=");
		sb.append(pfNo);
		sb.append(", aadhaarNo=");
		sb.append(aadhaarNo);
		sb.append(", employeetypeId=");
		sb.append(employeetypeId);
		sb.append(", ispfdeduct=");
		sb.append(ispfdeduct);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", addedDate=");
		sb.append(addedDate);
		sb.append(", photoId=");
		sb.append(photoId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", branchId=");
		sb.append(branchId);
		sb.append(", panNo=");
		sb.append(panNo);
		sb.append(", pesonalEmaiAddress=");
		sb.append(pesonalEmaiAddress);
		sb.append(", payPerMonth=");
		sb.append(payPerMonth);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmployeeId(employeeId);
		employeeImpl.setCompanyId(companyId);
		employeeImpl.setEmployeeCode(employeeCode);

		if (dateOfJoing == Long.MIN_VALUE) {
			employeeImpl.setDateOfJoing(null);
		}
		else {
			employeeImpl.setDateOfJoing(new Date(dateOfJoing));
		}

		if (firstName == null) {
			employeeImpl.setFirstName("");
		}
		else {
			employeeImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			employeeImpl.setLastName("");
		}
		else {
			employeeImpl.setLastName(lastName);
		}

		if (designation == null) {
			employeeImpl.setDesignation("");
		}
		else {
			employeeImpl.setDesignation(designation);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			employeeImpl.setDateOfBirth(null);
		}
		else {
			employeeImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (gender == null) {
			employeeImpl.setGender("");
		}
		else {
			employeeImpl.setGender(gender);
		}

		if (maritalStatus == null) {
			employeeImpl.setMaritalStatus("");
		}
		else {
			employeeImpl.setMaritalStatus(maritalStatus);
		}

		employeeImpl.setNoOfChild(noOfChild);

		if (note == null) {
			employeeImpl.setNote("");
		}
		else {
			employeeImpl.setNote(note);
		}

		if (address == null) {
			employeeImpl.setAddress("");
		}
		else {
			employeeImpl.setAddress(address);
		}

		if (state == null) {
			employeeImpl.setState("");
		}
		else {
			employeeImpl.setState(state);
		}

		if (postCode == null) {
			employeeImpl.setPostCode("");
		}
		else {
			employeeImpl.setPostCode(postCode);
		}

		employeeImpl.setHomePhone(homePhone);
		employeeImpl.setMobileNumber(mobileNumber);

		if (emaiAddress == null) {
			employeeImpl.setEmaiAddress("");
		}
		else {
			employeeImpl.setEmaiAddress(emaiAddress);
		}

		if (anniversary == Long.MIN_VALUE) {
			employeeImpl.setAnniversary(null);
		}
		else {
			employeeImpl.setAnniversary(new Date(anniversary));
		}

		employeeImpl.setEmployeeStatus(employeeStatus);
		employeeImpl.setTotalPay(totalPay);
		employeeImpl.setBasicPay(basicPay);
		employeeImpl.setDa(da);
		employeeImpl.setHra(hra);
		employeeImpl.setMedical(medical);
		employeeImpl.setTa(ta);
		employeeImpl.setConveyance(conveyance);
		employeeImpl.setInternet(internet);
		employeeImpl.setMobile(mobile);
		employeeImpl.setFare(fare);
		employeeImpl.setAreas(areas);
		employeeImpl.setBouns(bouns);
		employeeImpl.setInsurance(insurance);
		employeeImpl.setOtherAllowance(otherAllowance);
		employeeImpl.setProvidentFund(providentFund);
		employeeImpl.setProfessionTax(professionTax);
		employeeImpl.setIncomeTax(incomeTax);
		employeeImpl.setLoan(loan);
		employeeImpl.setOtherDeduction(otherDeduction);
		employeeImpl.setBankId(bankId);

		if (branchAddress == null) {
			employeeImpl.setBranchAddress("");
		}
		else {
			employeeImpl.setBranchAddress(branchAddress);
		}

		if (accountNo == null) {
			employeeImpl.setAccountNo("");
		}
		else {
			employeeImpl.setAccountNo(accountNo);
		}

		if (pfNo == null) {
			employeeImpl.setPfNo("");
		}
		else {
			employeeImpl.setPfNo(pfNo);
		}

		if (aadhaarNo == null) {
			employeeImpl.setAadhaarNo("");
		}
		else {
			employeeImpl.setAadhaarNo(aadhaarNo);
		}

		employeeImpl.setEmployeetypeId(employeetypeId);
		employeeImpl.setIspfdeduct(ispfdeduct);
		employeeImpl.setRoleId(roleId);

		if (addedDate == Long.MIN_VALUE) {
			employeeImpl.setAddedDate(null);
		}
		else {
			employeeImpl.setAddedDate(new Date(addedDate));
		}

		employeeImpl.setPhotoId(photoId);
		employeeImpl.setUserId(userId);
		employeeImpl.setBranchId(branchId);

		if (panNo == null) {
			employeeImpl.setPanNo("");
		}
		else {
			employeeImpl.setPanNo(panNo);
		}

		if (pesonalEmaiAddress == null) {
			employeeImpl.setPesonalEmaiAddress("");
		}
		else {
			employeeImpl.setPesonalEmaiAddress(pesonalEmaiAddress);
		}

		employeeImpl.setPayPerMonth(payPerMonth);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setStatus(status);
		employeeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			employeeImpl.setStatusByUserName("");
		}
		else {
			employeeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			employeeImpl.setStatusDate(null);
		}
		else {
			employeeImpl.setStatusDate(new Date(statusDate));
		}

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeImpl.setModifiedDate(null);
		}
		else {
			employeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();

		employeeCode = objectInput.readLong();
		dateOfJoing = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		designation = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		gender = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();

		noOfChild = objectInput.readLong();
		note = objectInput.readUTF();
		address = objectInput.readUTF();
		state = objectInput.readUTF();
		postCode = objectInput.readUTF();

		homePhone = objectInput.readInt();

		mobileNumber = objectInput.readInt();
		emaiAddress = objectInput.readUTF();
		anniversary = objectInput.readLong();

		employeeStatus = objectInput.readInt();

		totalPay = objectInput.readDouble();

		basicPay = objectInput.readDouble();

		da = objectInput.readDouble();

		hra = objectInput.readDouble();

		medical = objectInput.readDouble();

		ta = objectInput.readDouble();

		conveyance = objectInput.readDouble();

		internet = objectInput.readDouble();

		mobile = objectInput.readDouble();

		fare = objectInput.readDouble();

		areas = objectInput.readDouble();

		bouns = objectInput.readDouble();

		insurance = objectInput.readDouble();

		otherAllowance = objectInput.readDouble();

		providentFund = objectInput.readDouble();

		professionTax = objectInput.readDouble();

		incomeTax = objectInput.readDouble();

		loan = objectInput.readDouble();

		otherDeduction = objectInput.readDouble();

		bankId = objectInput.readLong();
		branchAddress = objectInput.readUTF();
		accountNo = objectInput.readUTF();
		pfNo = objectInput.readUTF();
		aadhaarNo = objectInput.readUTF();

		employeetypeId = objectInput.readInt();

		ispfdeduct = objectInput.readInt();

		roleId = objectInput.readInt();
		addedDate = objectInput.readLong();

		photoId = objectInput.readLong();

		userId = objectInput.readLong();

		branchId = objectInput.readLong();
		panNo = objectInput.readUTF();
		pesonalEmaiAddress = objectInput.readUTF();

		payPerMonth = objectInput.readDouble();

		groupId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(employeeCode);
		objectOutput.writeLong(dateOfJoing);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		objectOutput.writeLong(dateOfBirth);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		objectOutput.writeLong(noOfChild);

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (postCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postCode);
		}

		objectOutput.writeInt(homePhone);

		objectOutput.writeInt(mobileNumber);

		if (emaiAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emaiAddress);
		}

		objectOutput.writeLong(anniversary);

		objectOutput.writeInt(employeeStatus);

		objectOutput.writeDouble(totalPay);

		objectOutput.writeDouble(basicPay);

		objectOutput.writeDouble(da);

		objectOutput.writeDouble(hra);

		objectOutput.writeDouble(medical);

		objectOutput.writeDouble(ta);

		objectOutput.writeDouble(conveyance);

		objectOutput.writeDouble(internet);

		objectOutput.writeDouble(mobile);

		objectOutput.writeDouble(fare);

		objectOutput.writeDouble(areas);

		objectOutput.writeDouble(bouns);

		objectOutput.writeDouble(insurance);

		objectOutput.writeDouble(otherAllowance);

		objectOutput.writeDouble(providentFund);

		objectOutput.writeDouble(professionTax);

		objectOutput.writeDouble(incomeTax);

		objectOutput.writeDouble(loan);

		objectOutput.writeDouble(otherDeduction);

		objectOutput.writeLong(bankId);

		if (branchAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchAddress);
		}

		if (accountNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountNo);
		}

		if (pfNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pfNo);
		}

		if (aadhaarNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadhaarNo);
		}

		objectOutput.writeInt(employeetypeId);

		objectOutput.writeInt(ispfdeduct);

		objectOutput.writeInt(roleId);
		objectOutput.writeLong(addedDate);

		objectOutput.writeLong(photoId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(branchId);

		if (panNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNo);
		}

		if (pesonalEmaiAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pesonalEmaiAddress);
		}

		objectOutput.writeDouble(payPerMonth);

		objectOutput.writeLong(groupId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long employeeId;
	public long companyId;
	public long employeeCode;
	public long dateOfJoing;
	public String firstName;
	public String lastName;
	public String designation;
	public long dateOfBirth;
	public String gender;
	public String maritalStatus;
	public long noOfChild;
	public String note;
	public String address;
	public String state;
	public String postCode;
	public int homePhone;
	public int mobileNumber;
	public String emaiAddress;
	public long anniversary;
	public int employeeStatus;
	public double totalPay;
	public double basicPay;
	public double da;
	public double hra;
	public double medical;
	public double ta;
	public double conveyance;
	public double internet;
	public double mobile;
	public double fare;
	public double areas;
	public double bouns;
	public double insurance;
	public double otherAllowance;
	public double providentFund;
	public double professionTax;
	public double incomeTax;
	public double loan;
	public double otherDeduction;
	public long bankId;
	public String branchAddress;
	public String accountNo;
	public String pfNo;
	public String aadhaarNo;
	public int employeetypeId;
	public int ispfdeduct;
	public int roleId;
	public long addedDate;
	public long photoId;
	public long userId;
	public long branchId;
	public String panNo;
	public String pesonalEmaiAddress;
	public double payPerMonth;
	public long groupId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long createDate;
	public long modifiedDate;
}