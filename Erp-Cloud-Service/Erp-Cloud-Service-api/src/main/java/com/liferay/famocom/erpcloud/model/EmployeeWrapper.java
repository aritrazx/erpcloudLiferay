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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Samaresh
 * @see Employee
 * @generated
 */
@ProviderType
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeCode", getEmployeeCode());
		attributes.put("dateOfJoing", getDateOfJoing());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("designation", getDesignation());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("gender", getGender());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("noOfChild", getNoOfChild());
		attributes.put("note", getNote());
		attributes.put("address", getAddress());
		attributes.put("state", getState());
		attributes.put("postCode", getPostCode());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("emaiAddress", getEmaiAddress());
		attributes.put("anniversary", getAnniversary());
		attributes.put("employeePhoto", getEmployeePhoto());
		attributes.put("employeeStatus", getEmployeeStatus());
		attributes.put("totalPay", getTotalPay());
		attributes.put("basicPay", getBasicPay());
		attributes.put("da", getDa());
		attributes.put("hra", getHra());
		attributes.put("medical", getMedical());
		attributes.put("ta", getTa());
		attributes.put("conveyance", getConveyance());
		attributes.put("internet", getInternet());
		attributes.put("mobile", getMobile());
		attributes.put("fare", getFare());
		attributes.put("areas", getAreas());
		attributes.put("bouns", getBouns());
		attributes.put("insurance", getInsurance());
		attributes.put("otherAllowance", getOtherAllowance());
		attributes.put("providentFund", getProvidentFund());
		attributes.put("professionTax", getProfessionTax());
		attributes.put("incomeTax", getIncomeTax());
		attributes.put("loan", getLoan());
		attributes.put("otherDeduction", getOtherDeduction());
		attributes.put("bankId", getBankId());
		attributes.put("branchAddress", getBranchAddress());
		attributes.put("accountNo", getAccountNo());
		attributes.put("pfNo", getPfNo());
		attributes.put("aadhaarNo", getAadhaarNo());
		attributes.put("employeetypeId", getEmployeetypeId());
		attributes.put("ispfdeduct", getIspfdeduct());
		attributes.put("roleId", getRoleId());
		attributes.put("addedDate", getAddedDate());
		attributes.put("photoId", getPhotoId());
		attributes.put("userId", getUserId());
		attributes.put("branchId", getBranchId());
		attributes.put("panNo", getPanNo());
		attributes.put("pesonalEmaiAddress", getPesonalEmaiAddress());
		attributes.put("payPerMonth", getPayPerMonth());
		attributes.put("groupId", getGroupId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeCode = (Long)attributes.get("employeeCode");

		if (employeeCode != null) {
			setEmployeeCode(employeeCode);
		}

		Date dateOfJoing = (Date)attributes.get("dateOfJoing");

		if (dateOfJoing != null) {
			setDateOfJoing(dateOfJoing);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Long noOfChild = (Long)attributes.get("noOfChild");

		if (noOfChild != null) {
			setNoOfChild(noOfChild);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String postCode = (String)attributes.get("postCode");

		if (postCode != null) {
			setPostCode(postCode);
		}

		Integer homePhone = (Integer)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		Integer mobileNumber = (Integer)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String emaiAddress = (String)attributes.get("emaiAddress");

		if (emaiAddress != null) {
			setEmaiAddress(emaiAddress);
		}

		Date anniversary = (Date)attributes.get("anniversary");

		if (anniversary != null) {
			setAnniversary(anniversary);
		}

		Blob employeePhoto = (Blob)attributes.get("employeePhoto");

		if (employeePhoto != null) {
			setEmployeePhoto(employeePhoto);
		}

		Integer employeeStatus = (Integer)attributes.get("employeeStatus");

		if (employeeStatus != null) {
			setEmployeeStatus(employeeStatus);
		}

		Double totalPay = (Double)attributes.get("totalPay");

		if (totalPay != null) {
			setTotalPay(totalPay);
		}

		Double basicPay = (Double)attributes.get("basicPay");

		if (basicPay != null) {
			setBasicPay(basicPay);
		}

		Double da = (Double)attributes.get("da");

		if (da != null) {
			setDa(da);
		}

		Double hra = (Double)attributes.get("hra");

		if (hra != null) {
			setHra(hra);
		}

		Double medical = (Double)attributes.get("medical");

		if (medical != null) {
			setMedical(medical);
		}

		Double ta = (Double)attributes.get("ta");

		if (ta != null) {
			setTa(ta);
		}

		Double conveyance = (Double)attributes.get("conveyance");

		if (conveyance != null) {
			setConveyance(conveyance);
		}

		Double internet = (Double)attributes.get("internet");

		if (internet != null) {
			setInternet(internet);
		}

		Double mobile = (Double)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		Double fare = (Double)attributes.get("fare");

		if (fare != null) {
			setFare(fare);
		}

		Double areas = (Double)attributes.get("areas");

		if (areas != null) {
			setAreas(areas);
		}

		Double bouns = (Double)attributes.get("bouns");

		if (bouns != null) {
			setBouns(bouns);
		}

		Double insurance = (Double)attributes.get("insurance");

		if (insurance != null) {
			setInsurance(insurance);
		}

		Double otherAllowance = (Double)attributes.get("otherAllowance");

		if (otherAllowance != null) {
			setOtherAllowance(otherAllowance);
		}

		Double providentFund = (Double)attributes.get("providentFund");

		if (providentFund != null) {
			setProvidentFund(providentFund);
		}

		Double professionTax = (Double)attributes.get("professionTax");

		if (professionTax != null) {
			setProfessionTax(professionTax);
		}

		Double incomeTax = (Double)attributes.get("incomeTax");

		if (incomeTax != null) {
			setIncomeTax(incomeTax);
		}

		Double loan = (Double)attributes.get("loan");

		if (loan != null) {
			setLoan(loan);
		}

		Double otherDeduction = (Double)attributes.get("otherDeduction");

		if (otherDeduction != null) {
			setOtherDeduction(otherDeduction);
		}

		Long bankId = (Long)attributes.get("bankId");

		if (bankId != null) {
			setBankId(bankId);
		}

		String branchAddress = (String)attributes.get("branchAddress");

		if (branchAddress != null) {
			setBranchAddress(branchAddress);
		}

		String accountNo = (String)attributes.get("accountNo");

		if (accountNo != null) {
			setAccountNo(accountNo);
		}

		String pfNo = (String)attributes.get("pfNo");

		if (pfNo != null) {
			setPfNo(pfNo);
		}

		String aadhaarNo = (String)attributes.get("aadhaarNo");

		if (aadhaarNo != null) {
			setAadhaarNo(aadhaarNo);
		}

		Integer employeetypeId = (Integer)attributes.get("employeetypeId");

		if (employeetypeId != null) {
			setEmployeetypeId(employeetypeId);
		}

		Integer ispfdeduct = (Integer)attributes.get("ispfdeduct");

		if (ispfdeduct != null) {
			setIspfdeduct(ispfdeduct);
		}

		Integer roleId = (Integer)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}

		Long photoId = (Long)attributes.get("photoId");

		if (photoId != null) {
			setPhotoId(photoId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long branchId = (Long)attributes.get("branchId");

		if (branchId != null) {
			setBranchId(branchId);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String pesonalEmaiAddress = (String)attributes.get("pesonalEmaiAddress");

		if (pesonalEmaiAddress != null) {
			setPesonalEmaiAddress(pesonalEmaiAddress);
		}

		Double payPerMonth = (Double)attributes.get("payPerMonth");

		if (payPerMonth != null) {
			setPayPerMonth(payPerMonth);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(Employee employee) {
		return _employee.compareTo(employee);
	}

	/**
	* Returns the aadhaar no of this employee.
	*
	* @return the aadhaar no of this employee
	*/
	@Override
	public String getAadhaarNo() {
		return _employee.getAadhaarNo();
	}

	/**
	* Returns the account no of this employee.
	*
	* @return the account no of this employee
	*/
	@Override
	public String getAccountNo() {
		return _employee.getAccountNo();
	}

	/**
	* Returns the added date of this employee.
	*
	* @return the added date of this employee
	*/
	@Override
	public Date getAddedDate() {
		return _employee.getAddedDate();
	}

	/**
	* Returns the address of this employee.
	*
	* @return the address of this employee
	*/
	@Override
	public String getAddress() {
		return _employee.getAddress();
	}

	/**
	* Returns the anniversary of this employee.
	*
	* @return the anniversary of this employee
	*/
	@Override
	public Date getAnniversary() {
		return _employee.getAnniversary();
	}

	/**
	* Returns the areas of this employee.
	*
	* @return the areas of this employee
	*/
	@Override
	public double getAreas() {
		return _employee.getAreas();
	}

	/**
	* Returns the bank ID of this employee.
	*
	* @return the bank ID of this employee
	*/
	@Override
	public long getBankId() {
		return _employee.getBankId();
	}

	/**
	* Returns the basic pay of this employee.
	*
	* @return the basic pay of this employee
	*/
	@Override
	public double getBasicPay() {
		return _employee.getBasicPay();
	}

	/**
	* Returns the bouns of this employee.
	*
	* @return the bouns of this employee
	*/
	@Override
	public double getBouns() {
		return _employee.getBouns();
	}

	/**
	* Returns the branch address of this employee.
	*
	* @return the branch address of this employee
	*/
	@Override
	public String getBranchAddress() {
		return _employee.getBranchAddress();
	}

	/**
	* Returns the branch ID of this employee.
	*
	* @return the branch ID of this employee
	*/
	@Override
	public long getBranchId() {
		return _employee.getBranchId();
	}

	/**
	* Returns the company ID of this employee.
	*
	* @return the company ID of this employee
	*/
	@Override
	public long getCompanyId() {
		return _employee.getCompanyId();
	}

	/**
	* Returns the conveyance of this employee.
	*
	* @return the conveyance of this employee
	*/
	@Override
	public double getConveyance() {
		return _employee.getConveyance();
	}

	/**
	* Returns the create date of this employee.
	*
	* @return the create date of this employee
	*/
	@Override
	public Date getCreateDate() {
		return _employee.getCreateDate();
	}

	/**
	* Returns the da of this employee.
	*
	* @return the da of this employee
	*/
	@Override
	public double getDa() {
		return _employee.getDa();
	}

	/**
	* Returns the date of birth of this employee.
	*
	* @return the date of birth of this employee
	*/
	@Override
	public Date getDateOfBirth() {
		return _employee.getDateOfBirth();
	}

	/**
	* Returns the date of joing of this employee.
	*
	* @return the date of joing of this employee
	*/
	@Override
	public Date getDateOfJoing() {
		return _employee.getDateOfJoing();
	}

	/**
	* Returns the designation of this employee.
	*
	* @return the designation of this employee
	*/
	@Override
	public String getDesignation() {
		return _employee.getDesignation();
	}

	/**
	* Returns the emai address of this employee.
	*
	* @return the emai address of this employee
	*/
	@Override
	public String getEmaiAddress() {
		return _employee.getEmaiAddress();
	}

	/**
	* Returns the employee code of this employee.
	*
	* @return the employee code of this employee
	*/
	@Override
	public long getEmployeeCode() {
		return _employee.getEmployeeCode();
	}

	/**
	* Returns the employee ID of this employee.
	*
	* @return the employee ID of this employee
	*/
	@Override
	public long getEmployeeId() {
		return _employee.getEmployeeId();
	}

	/**
	* Returns the employee photo of this employee.
	*
	* @return the employee photo of this employee
	*/
	@Override
	public Blob getEmployeePhoto() {
		return _employee.getEmployeePhoto();
	}

	/**
	* Returns the employee status of this employee.
	*
	* @return the employee status of this employee
	*/
	@Override
	public int getEmployeeStatus() {
		return _employee.getEmployeeStatus();
	}

	/**
	* Returns the employeetype ID of this employee.
	*
	* @return the employeetype ID of this employee
	*/
	@Override
	public int getEmployeetypeId() {
		return _employee.getEmployeetypeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	/**
	* Returns the fare of this employee.
	*
	* @return the fare of this employee
	*/
	@Override
	public double getFare() {
		return _employee.getFare();
	}

	/**
	* Returns the first name of this employee.
	*
	* @return the first name of this employee
	*/
	@Override
	public String getFirstName() {
		return _employee.getFirstName();
	}

	/**
	* Returns the gender of this employee.
	*
	* @return the gender of this employee
	*/
	@Override
	public String getGender() {
		return _employee.getGender();
	}

	/**
	* Returns the group ID of this employee.
	*
	* @return the group ID of this employee
	*/
	@Override
	public long getGroupId() {
		return _employee.getGroupId();
	}

	/**
	* Returns the home phone of this employee.
	*
	* @return the home phone of this employee
	*/
	@Override
	public int getHomePhone() {
		return _employee.getHomePhone();
	}

	/**
	* Returns the hra of this employee.
	*
	* @return the hra of this employee
	*/
	@Override
	public double getHra() {
		return _employee.getHra();
	}

	/**
	* Returns the income tax of this employee.
	*
	* @return the income tax of this employee
	*/
	@Override
	public double getIncomeTax() {
		return _employee.getIncomeTax();
	}

	/**
	* Returns the insurance of this employee.
	*
	* @return the insurance of this employee
	*/
	@Override
	public double getInsurance() {
		return _employee.getInsurance();
	}

	/**
	* Returns the internet of this employee.
	*
	* @return the internet of this employee
	*/
	@Override
	public double getInternet() {
		return _employee.getInternet();
	}

	/**
	* Returns the ispfdeduct of this employee.
	*
	* @return the ispfdeduct of this employee
	*/
	@Override
	public int getIspfdeduct() {
		return _employee.getIspfdeduct();
	}

	/**
	* Returns the last name of this employee.
	*
	* @return the last name of this employee
	*/
	@Override
	public String getLastName() {
		return _employee.getLastName();
	}

	/**
	* Returns the loan of this employee.
	*
	* @return the loan of this employee
	*/
	@Override
	public double getLoan() {
		return _employee.getLoan();
	}

	/**
	* Returns the marital status of this employee.
	*
	* @return the marital status of this employee
	*/
	@Override
	public String getMaritalStatus() {
		return _employee.getMaritalStatus();
	}

	/**
	* Returns the medical of this employee.
	*
	* @return the medical of this employee
	*/
	@Override
	public double getMedical() {
		return _employee.getMedical();
	}

	/**
	* Returns the mobile of this employee.
	*
	* @return the mobile of this employee
	*/
	@Override
	public double getMobile() {
		return _employee.getMobile();
	}

	/**
	* Returns the mobile number of this employee.
	*
	* @return the mobile number of this employee
	*/
	@Override
	public int getMobileNumber() {
		return _employee.getMobileNumber();
	}

	/**
	* Returns the modified date of this employee.
	*
	* @return the modified date of this employee
	*/
	@Override
	public Date getModifiedDate() {
		return _employee.getModifiedDate();
	}

	/**
	* Returns the no of child of this employee.
	*
	* @return the no of child of this employee
	*/
	@Override
	public long getNoOfChild() {
		return _employee.getNoOfChild();
	}

	/**
	* Returns the note of this employee.
	*
	* @return the note of this employee
	*/
	@Override
	public String getNote() {
		return _employee.getNote();
	}

	/**
	* Returns the other allowance of this employee.
	*
	* @return the other allowance of this employee
	*/
	@Override
	public double getOtherAllowance() {
		return _employee.getOtherAllowance();
	}

	/**
	* Returns the other deduction of this employee.
	*
	* @return the other deduction of this employee
	*/
	@Override
	public double getOtherDeduction() {
		return _employee.getOtherDeduction();
	}

	/**
	* Returns the pan no of this employee.
	*
	* @return the pan no of this employee
	*/
	@Override
	public String getPanNo() {
		return _employee.getPanNo();
	}

	/**
	* Returns the pay per month of this employee.
	*
	* @return the pay per month of this employee
	*/
	@Override
	public double getPayPerMonth() {
		return _employee.getPayPerMonth();
	}

	/**
	* Returns the pesonal emai address of this employee.
	*
	* @return the pesonal emai address of this employee
	*/
	@Override
	public String getPesonalEmaiAddress() {
		return _employee.getPesonalEmaiAddress();
	}

	/**
	* Returns the pf no of this employee.
	*
	* @return the pf no of this employee
	*/
	@Override
	public String getPfNo() {
		return _employee.getPfNo();
	}

	/**
	* Returns the photo ID of this employee.
	*
	* @return the photo ID of this employee
	*/
	@Override
	public long getPhotoId() {
		return _employee.getPhotoId();
	}

	/**
	* Returns the post code of this employee.
	*
	* @return the post code of this employee
	*/
	@Override
	public String getPostCode() {
		return _employee.getPostCode();
	}

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	@Override
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	/**
	* Returns the profession tax of this employee.
	*
	* @return the profession tax of this employee
	*/
	@Override
	public double getProfessionTax() {
		return _employee.getProfessionTax();
	}

	/**
	* Returns the provident fund of this employee.
	*
	* @return the provident fund of this employee
	*/
	@Override
	public double getProvidentFund() {
		return _employee.getProvidentFund();
	}

	/**
	* Returns the role ID of this employee.
	*
	* @return the role ID of this employee
	*/
	@Override
	public int getRoleId() {
		return _employee.getRoleId();
	}

	/**
	* Returns the state of this employee.
	*
	* @return the state of this employee
	*/
	@Override
	public String getState() {
		return _employee.getState();
	}

	/**
	* Returns the status of this employee.
	*
	* @return the status of this employee
	*/
	@Override
	public int getStatus() {
		return _employee.getStatus();
	}

	/**
	* Returns the status by user ID of this employee.
	*
	* @return the status by user ID of this employee
	*/
	@Override
	public long getStatusByUserId() {
		return _employee.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this employee.
	*
	* @return the status by user name of this employee
	*/
	@Override
	public String getStatusByUserName() {
		return _employee.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this employee.
	*
	* @return the status by user uuid of this employee
	*/
	@Override
	public String getStatusByUserUuid() {
		return _employee.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this employee.
	*
	* @return the status date of this employee
	*/
	@Override
	public Date getStatusDate() {
		return _employee.getStatusDate();
	}

	/**
	* Returns the ta of this employee.
	*
	* @return the ta of this employee
	*/
	@Override
	public double getTa() {
		return _employee.getTa();
	}

	/**
	* Returns the total pay of this employee.
	*
	* @return the total pay of this employee
	*/
	@Override
	public double getTotalPay() {
		return _employee.getTotalPay();
	}

	/**
	* Returns the user ID of this employee.
	*
	* @return the user ID of this employee
	*/
	@Override
	public long getUserId() {
		return _employee.getUserId();
	}

	/**
	* Returns the user uuid of this employee.
	*
	* @return the user uuid of this employee
	*/
	@Override
	public String getUserUuid() {
		return _employee.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	/**
	* Returns <code>true</code> if this employee is approved.
	*
	* @return <code>true</code> if this employee is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _employee.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this employee is denied.
	*
	* @return <code>true</code> if this employee is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _employee.isDenied();
	}

	/**
	* Returns <code>true</code> if this employee is a draft.
	*
	* @return <code>true</code> if this employee is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _employee.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this employee is expired.
	*
	* @return <code>true</code> if this employee is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _employee.isExpired();
	}

	/**
	* Returns <code>true</code> if this employee is inactive.
	*
	* @return <code>true</code> if this employee is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _employee.isInactive();
	}

	/**
	* Returns <code>true</code> if this employee is incomplete.
	*
	* @return <code>true</code> if this employee is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _employee.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	/**
	* Returns <code>true</code> if this employee is pending.
	*
	* @return <code>true</code> if this employee is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _employee.isPending();
	}

	/**
	* Returns <code>true</code> if this employee is scheduled.
	*
	* @return <code>true</code> if this employee is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _employee.isScheduled();
	}

	@Override
	public void persist() {
		_employee.persist();
	}

	/**
	* Sets the aadhaar no of this employee.
	*
	* @param aadhaarNo the aadhaar no of this employee
	*/
	@Override
	public void setAadhaarNo(String aadhaarNo) {
		_employee.setAadhaarNo(aadhaarNo);
	}

	/**
	* Sets the account no of this employee.
	*
	* @param accountNo the account no of this employee
	*/
	@Override
	public void setAccountNo(String accountNo) {
		_employee.setAccountNo(accountNo);
	}

	/**
	* Sets the added date of this employee.
	*
	* @param addedDate the added date of this employee
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_employee.setAddedDate(addedDate);
	}

	/**
	* Sets the address of this employee.
	*
	* @param address the address of this employee
	*/
	@Override
	public void setAddress(String address) {
		_employee.setAddress(address);
	}

	/**
	* Sets the anniversary of this employee.
	*
	* @param anniversary the anniversary of this employee
	*/
	@Override
	public void setAnniversary(Date anniversary) {
		_employee.setAnniversary(anniversary);
	}

	/**
	* Sets the areas of this employee.
	*
	* @param areas the areas of this employee
	*/
	@Override
	public void setAreas(double areas) {
		_employee.setAreas(areas);
	}

	/**
	* Sets the bank ID of this employee.
	*
	* @param bankId the bank ID of this employee
	*/
	@Override
	public void setBankId(long bankId) {
		_employee.setBankId(bankId);
	}

	/**
	* Sets the basic pay of this employee.
	*
	* @param basicPay the basic pay of this employee
	*/
	@Override
	public void setBasicPay(double basicPay) {
		_employee.setBasicPay(basicPay);
	}

	/**
	* Sets the bouns of this employee.
	*
	* @param bouns the bouns of this employee
	*/
	@Override
	public void setBouns(double bouns) {
		_employee.setBouns(bouns);
	}

	/**
	* Sets the branch address of this employee.
	*
	* @param branchAddress the branch address of this employee
	*/
	@Override
	public void setBranchAddress(String branchAddress) {
		_employee.setBranchAddress(branchAddress);
	}

	/**
	* Sets the branch ID of this employee.
	*
	* @param branchId the branch ID of this employee
	*/
	@Override
	public void setBranchId(long branchId) {
		_employee.setBranchId(branchId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this employee.
	*
	* @param companyId the company ID of this employee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employee.setCompanyId(companyId);
	}

	/**
	* Sets the conveyance of this employee.
	*
	* @param conveyance the conveyance of this employee
	*/
	@Override
	public void setConveyance(double conveyance) {
		_employee.setConveyance(conveyance);
	}

	/**
	* Sets the create date of this employee.
	*
	* @param createDate the create date of this employee
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_employee.setCreateDate(createDate);
	}

	/**
	* Sets the da of this employee.
	*
	* @param da the da of this employee
	*/
	@Override
	public void setDa(double da) {
		_employee.setDa(da);
	}

	/**
	* Sets the date of birth of this employee.
	*
	* @param dateOfBirth the date of birth of this employee
	*/
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		_employee.setDateOfBirth(dateOfBirth);
	}

	/**
	* Sets the date of joing of this employee.
	*
	* @param dateOfJoing the date of joing of this employee
	*/
	@Override
	public void setDateOfJoing(Date dateOfJoing) {
		_employee.setDateOfJoing(dateOfJoing);
	}

	/**
	* Sets the designation of this employee.
	*
	* @param designation the designation of this employee
	*/
	@Override
	public void setDesignation(String designation) {
		_employee.setDesignation(designation);
	}

	/**
	* Sets the emai address of this employee.
	*
	* @param emaiAddress the emai address of this employee
	*/
	@Override
	public void setEmaiAddress(String emaiAddress) {
		_employee.setEmaiAddress(emaiAddress);
	}

	/**
	* Sets the employee code of this employee.
	*
	* @param employeeCode the employee code of this employee
	*/
	@Override
	public void setEmployeeCode(long employeeCode) {
		_employee.setEmployeeCode(employeeCode);
	}

	/**
	* Sets the employee ID of this employee.
	*
	* @param employeeId the employee ID of this employee
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employee.setEmployeeId(employeeId);
	}

	/**
	* Sets the employee photo of this employee.
	*
	* @param employeePhoto the employee photo of this employee
	*/
	@Override
	public void setEmployeePhoto(Blob employeePhoto) {
		_employee.setEmployeePhoto(employeePhoto);
	}

	/**
	* Sets the employee status of this employee.
	*
	* @param employeeStatus the employee status of this employee
	*/
	@Override
	public void setEmployeeStatus(int employeeStatus) {
		_employee.setEmployeeStatus(employeeStatus);
	}

	/**
	* Sets the employeetype ID of this employee.
	*
	* @param employeetypeId the employeetype ID of this employee
	*/
	@Override
	public void setEmployeetypeId(int employeetypeId) {
		_employee.setEmployeetypeId(employeetypeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fare of this employee.
	*
	* @param fare the fare of this employee
	*/
	@Override
	public void setFare(double fare) {
		_employee.setFare(fare);
	}

	/**
	* Sets the first name of this employee.
	*
	* @param firstName the first name of this employee
	*/
	@Override
	public void setFirstName(String firstName) {
		_employee.setFirstName(firstName);
	}

	/**
	* Sets the gender of this employee.
	*
	* @param gender the gender of this employee
	*/
	@Override
	public void setGender(String gender) {
		_employee.setGender(gender);
	}

	/**
	* Sets the group ID of this employee.
	*
	* @param groupId the group ID of this employee
	*/
	@Override
	public void setGroupId(long groupId) {
		_employee.setGroupId(groupId);
	}

	/**
	* Sets the home phone of this employee.
	*
	* @param homePhone the home phone of this employee
	*/
	@Override
	public void setHomePhone(int homePhone) {
		_employee.setHomePhone(homePhone);
	}

	/**
	* Sets the hra of this employee.
	*
	* @param hra the hra of this employee
	*/
	@Override
	public void setHra(double hra) {
		_employee.setHra(hra);
	}

	/**
	* Sets the income tax of this employee.
	*
	* @param incomeTax the income tax of this employee
	*/
	@Override
	public void setIncomeTax(double incomeTax) {
		_employee.setIncomeTax(incomeTax);
	}

	/**
	* Sets the insurance of this employee.
	*
	* @param insurance the insurance of this employee
	*/
	@Override
	public void setInsurance(double insurance) {
		_employee.setInsurance(insurance);
	}

	/**
	* Sets the internet of this employee.
	*
	* @param internet the internet of this employee
	*/
	@Override
	public void setInternet(double internet) {
		_employee.setInternet(internet);
	}

	/**
	* Sets the ispfdeduct of this employee.
	*
	* @param ispfdeduct the ispfdeduct of this employee
	*/
	@Override
	public void setIspfdeduct(int ispfdeduct) {
		_employee.setIspfdeduct(ispfdeduct);
	}

	/**
	* Sets the last name of this employee.
	*
	* @param lastName the last name of this employee
	*/
	@Override
	public void setLastName(String lastName) {
		_employee.setLastName(lastName);
	}

	/**
	* Sets the loan of this employee.
	*
	* @param loan the loan of this employee
	*/
	@Override
	public void setLoan(double loan) {
		_employee.setLoan(loan);
	}

	/**
	* Sets the marital status of this employee.
	*
	* @param maritalStatus the marital status of this employee
	*/
	@Override
	public void setMaritalStatus(String maritalStatus) {
		_employee.setMaritalStatus(maritalStatus);
	}

	/**
	* Sets the medical of this employee.
	*
	* @param medical the medical of this employee
	*/
	@Override
	public void setMedical(double medical) {
		_employee.setMedical(medical);
	}

	/**
	* Sets the mobile of this employee.
	*
	* @param mobile the mobile of this employee
	*/
	@Override
	public void setMobile(double mobile) {
		_employee.setMobile(mobile);
	}

	/**
	* Sets the mobile number of this employee.
	*
	* @param mobileNumber the mobile number of this employee
	*/
	@Override
	public void setMobileNumber(int mobileNumber) {
		_employee.setMobileNumber(mobileNumber);
	}

	/**
	* Sets the modified date of this employee.
	*
	* @param modifiedDate the modified date of this employee
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_employee.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	/**
	* Sets the no of child of this employee.
	*
	* @param noOfChild the no of child of this employee
	*/
	@Override
	public void setNoOfChild(long noOfChild) {
		_employee.setNoOfChild(noOfChild);
	}

	/**
	* Sets the note of this employee.
	*
	* @param note the note of this employee
	*/
	@Override
	public void setNote(String note) {
		_employee.setNote(note);
	}

	/**
	* Sets the other allowance of this employee.
	*
	* @param otherAllowance the other allowance of this employee
	*/
	@Override
	public void setOtherAllowance(double otherAllowance) {
		_employee.setOtherAllowance(otherAllowance);
	}

	/**
	* Sets the other deduction of this employee.
	*
	* @param otherDeduction the other deduction of this employee
	*/
	@Override
	public void setOtherDeduction(double otherDeduction) {
		_employee.setOtherDeduction(otherDeduction);
	}

	/**
	* Sets the pan no of this employee.
	*
	* @param panNo the pan no of this employee
	*/
	@Override
	public void setPanNo(String panNo) {
		_employee.setPanNo(panNo);
	}

	/**
	* Sets the pay per month of this employee.
	*
	* @param payPerMonth the pay per month of this employee
	*/
	@Override
	public void setPayPerMonth(double payPerMonth) {
		_employee.setPayPerMonth(payPerMonth);
	}

	/**
	* Sets the pesonal emai address of this employee.
	*
	* @param pesonalEmaiAddress the pesonal emai address of this employee
	*/
	@Override
	public void setPesonalEmaiAddress(String pesonalEmaiAddress) {
		_employee.setPesonalEmaiAddress(pesonalEmaiAddress);
	}

	/**
	* Sets the pf no of this employee.
	*
	* @param pfNo the pf no of this employee
	*/
	@Override
	public void setPfNo(String pfNo) {
		_employee.setPfNo(pfNo);
	}

	/**
	* Sets the photo ID of this employee.
	*
	* @param photoId the photo ID of this employee
	*/
	@Override
	public void setPhotoId(long photoId) {
		_employee.setPhotoId(photoId);
	}

	/**
	* Sets the post code of this employee.
	*
	* @param postCode the post code of this employee
	*/
	@Override
	public void setPostCode(String postCode) {
		_employee.setPostCode(postCode);
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the profession tax of this employee.
	*
	* @param professionTax the profession tax of this employee
	*/
	@Override
	public void setProfessionTax(double professionTax) {
		_employee.setProfessionTax(professionTax);
	}

	/**
	* Sets the provident fund of this employee.
	*
	* @param providentFund the provident fund of this employee
	*/
	@Override
	public void setProvidentFund(double providentFund) {
		_employee.setProvidentFund(providentFund);
	}

	/**
	* Sets the role ID of this employee.
	*
	* @param roleId the role ID of this employee
	*/
	@Override
	public void setRoleId(int roleId) {
		_employee.setRoleId(roleId);
	}

	/**
	* Sets the state of this employee.
	*
	* @param state the state of this employee
	*/
	@Override
	public void setState(String state) {
		_employee.setState(state);
	}

	/**
	* Sets the status of this employee.
	*
	* @param status the status of this employee
	*/
	@Override
	public void setStatus(int status) {
		_employee.setStatus(status);
	}

	/**
	* Sets the status by user ID of this employee.
	*
	* @param statusByUserId the status by user ID of this employee
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_employee.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this employee.
	*
	* @param statusByUserName the status by user name of this employee
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_employee.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this employee.
	*
	* @param statusByUserUuid the status by user uuid of this employee
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_employee.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this employee.
	*
	* @param statusDate the status date of this employee
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_employee.setStatusDate(statusDate);
	}

	/**
	* Sets the ta of this employee.
	*
	* @param ta the ta of this employee
	*/
	@Override
	public void setTa(double ta) {
		_employee.setTa(ta);
	}

	/**
	* Sets the total pay of this employee.
	*
	* @param totalPay the total pay of this employee
	*/
	@Override
	public void setTotalPay(double totalPay) {
		_employee.setTotalPay(totalPay);
	}

	/**
	* Sets the user ID of this employee.
	*
	* @param userId the user ID of this employee
	*/
	@Override
	public void setUserId(long userId) {
		_employee.setUserId(userId);
	}

	/**
	* Sets the user uuid of this employee.
	*
	* @param userUuid the user uuid of this employee
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_employee.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public String toString() {
		return _employee.toString();
	}

	@Override
	public Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Objects.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employee.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employee.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private final Employee _employee;
}