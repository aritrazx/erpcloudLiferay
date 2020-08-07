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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.EmployeeServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.EmployeeServiceSoap
 * @generated
 */
@ProviderType
public class EmployeeSoap implements Serializable {
	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeCode(model.getEmployeeCode());
		soapModel.setDateOfJoing(model.getDateOfJoing());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setDesignation(model.getDesignation());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setGender(model.getGender());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setNoOfChild(model.getNoOfChild());
		soapModel.setNote(model.getNote());
		soapModel.setAddress(model.getAddress());
		soapModel.setState(model.getState());
		soapModel.setPostCode(model.getPostCode());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobileNumber(model.getMobileNumber());
		soapModel.setEmaiAddress(model.getEmaiAddress());
		soapModel.setAnniversary(model.getAnniversary());
		soapModel.setEmployeePhoto(model.getEmployeePhoto());
		soapModel.setEmployeeStatus(model.getEmployeeStatus());
		soapModel.setTotalPay(model.getTotalPay());
		soapModel.setBasicPay(model.getBasicPay());
		soapModel.setDa(model.getDa());
		soapModel.setHra(model.getHra());
		soapModel.setMedical(model.getMedical());
		soapModel.setTa(model.getTa());
		soapModel.setConveyance(model.getConveyance());
		soapModel.setInternet(model.getInternet());
		soapModel.setMobile(model.getMobile());
		soapModel.setFare(model.getFare());
		soapModel.setAreas(model.getAreas());
		soapModel.setBouns(model.getBouns());
		soapModel.setInsurance(model.getInsurance());
		soapModel.setOtherAllowance(model.getOtherAllowance());
		soapModel.setProvidentFund(model.getProvidentFund());
		soapModel.setProfessionTax(model.getProfessionTax());
		soapModel.setIncomeTax(model.getIncomeTax());
		soapModel.setLoan(model.getLoan());
		soapModel.setOtherDeduction(model.getOtherDeduction());
		soapModel.setBankId(model.getBankId());
		soapModel.setBranchAddress(model.getBranchAddress());
		soapModel.setAccountNo(model.getAccountNo());
		soapModel.setPfNo(model.getPfNo());
		soapModel.setAadhaarNo(model.getAadhaarNo());
		soapModel.setEmployeetypeId(model.getEmployeetypeId());
		soapModel.setIspfdeduct(model.getIspfdeduct());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setPhotoId(model.getPhotoId());
		soapModel.setUserId(model.getUserId());
		soapModel.setBranchId(model.getBranchId());
		soapModel.setPanNo(model.getPanNo());
		soapModel.setPesonalEmaiAddress(model.getPesonalEmaiAddress());
		soapModel.setPayPerMonth(model.getPayPerMonth());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _employeeId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeId(pk);
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

	public long getEmployeeCode() {
		return _employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		_employeeCode = employeeCode;
	}

	public Date getDateOfJoing() {
		return _dateOfJoing;
	}

	public void setDateOfJoing(Date dateOfJoing) {
		_dateOfJoing = dateOfJoing;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getDesignation() {
		return _designation;
	}

	public void setDesignation(String designation) {
		_designation = designation;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public long getNoOfChild() {
		return _noOfChild;
	}

	public void setNoOfChild(long noOfChild) {
		_noOfChild = noOfChild;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getPostCode() {
		return _postCode;
	}

	public void setPostCode(String postCode) {
		_postCode = postCode;
	}

	public int getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(int homePhone) {
		_homePhone = homePhone;
	}

	public int getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public String getEmaiAddress() {
		return _emaiAddress;
	}

	public void setEmaiAddress(String emaiAddress) {
		_emaiAddress = emaiAddress;
	}

	public Date getAnniversary() {
		return _anniversary;
	}

	public void setAnniversary(Date anniversary) {
		_anniversary = anniversary;
	}

	public Blob getEmployeePhoto() {
		return _employeePhoto;
	}

	public void setEmployeePhoto(Blob employeePhoto) {
		_employeePhoto = employeePhoto;
	}

	public int getEmployeeStatus() {
		return _employeeStatus;
	}

	public void setEmployeeStatus(int employeeStatus) {
		_employeeStatus = employeeStatus;
	}

	public double getTotalPay() {
		return _totalPay;
	}

	public void setTotalPay(double totalPay) {
		_totalPay = totalPay;
	}

	public double getBasicPay() {
		return _basicPay;
	}

	public void setBasicPay(double basicPay) {
		_basicPay = basicPay;
	}

	public double getDa() {
		return _da;
	}

	public void setDa(double da) {
		_da = da;
	}

	public double getHra() {
		return _hra;
	}

	public void setHra(double hra) {
		_hra = hra;
	}

	public double getMedical() {
		return _medical;
	}

	public void setMedical(double medical) {
		_medical = medical;
	}

	public double getTa() {
		return _ta;
	}

	public void setTa(double ta) {
		_ta = ta;
	}

	public double getConveyance() {
		return _conveyance;
	}

	public void setConveyance(double conveyance) {
		_conveyance = conveyance;
	}

	public double getInternet() {
		return _internet;
	}

	public void setInternet(double internet) {
		_internet = internet;
	}

	public double getMobile() {
		return _mobile;
	}

	public void setMobile(double mobile) {
		_mobile = mobile;
	}

	public double getFare() {
		return _fare;
	}

	public void setFare(double fare) {
		_fare = fare;
	}

	public double getAreas() {
		return _areas;
	}

	public void setAreas(double areas) {
		_areas = areas;
	}

	public double getBouns() {
		return _bouns;
	}

	public void setBouns(double bouns) {
		_bouns = bouns;
	}

	public double getInsurance() {
		return _insurance;
	}

	public void setInsurance(double insurance) {
		_insurance = insurance;
	}

	public double getOtherAllowance() {
		return _otherAllowance;
	}

	public void setOtherAllowance(double otherAllowance) {
		_otherAllowance = otherAllowance;
	}

	public double getProvidentFund() {
		return _providentFund;
	}

	public void setProvidentFund(double providentFund) {
		_providentFund = providentFund;
	}

	public double getProfessionTax() {
		return _professionTax;
	}

	public void setProfessionTax(double professionTax) {
		_professionTax = professionTax;
	}

	public double getIncomeTax() {
		return _incomeTax;
	}

	public void setIncomeTax(double incomeTax) {
		_incomeTax = incomeTax;
	}

	public double getLoan() {
		return _loan;
	}

	public void setLoan(double loan) {
		_loan = loan;
	}

	public double getOtherDeduction() {
		return _otherDeduction;
	}

	public void setOtherDeduction(double otherDeduction) {
		_otherDeduction = otherDeduction;
	}

	public long getBankId() {
		return _bankId;
	}

	public void setBankId(long bankId) {
		_bankId = bankId;
	}

	public String getBranchAddress() {
		return _branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		_branchAddress = branchAddress;
	}

	public String getAccountNo() {
		return _accountNo;
	}

	public void setAccountNo(String accountNo) {
		_accountNo = accountNo;
	}

	public String getPfNo() {
		return _pfNo;
	}

	public void setPfNo(String pfNo) {
		_pfNo = pfNo;
	}

	public String getAadhaarNo() {
		return _aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		_aadhaarNo = aadhaarNo;
	}

	public int getEmployeetypeId() {
		return _employeetypeId;
	}

	public void setEmployeetypeId(int employeetypeId) {
		_employeetypeId = employeetypeId;
	}

	public int getIspfdeduct() {
		return _ispfdeduct;
	}

	public void setIspfdeduct(int ispfdeduct) {
		_ispfdeduct = ispfdeduct;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	public long getPhotoId() {
		return _photoId;
	}

	public void setPhotoId(long photoId) {
		_photoId = photoId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getBranchId() {
		return _branchId;
	}

	public void setBranchId(long branchId) {
		_branchId = branchId;
	}

	public String getPanNo() {
		return _panNo;
	}

	public void setPanNo(String panNo) {
		_panNo = panNo;
	}

	public String getPesonalEmaiAddress() {
		return _pesonalEmaiAddress;
	}

	public void setPesonalEmaiAddress(String pesonalEmaiAddress) {
		_pesonalEmaiAddress = pesonalEmaiAddress;
	}

	public double getPayPerMonth() {
		return _payPerMonth;
	}

	public void setPayPerMonth(double payPerMonth) {
		_payPerMonth = payPerMonth;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _employeeId;
	private long _companyId;
	private long _employeeCode;
	private Date _dateOfJoing;
	private String _firstName;
	private String _lastName;
	private String _designation;
	private Date _dateOfBirth;
	private String _gender;
	private String _maritalStatus;
	private long _noOfChild;
	private String _note;
	private String _address;
	private String _state;
	private String _postCode;
	private int _homePhone;
	private int _mobileNumber;
	private String _emaiAddress;
	private Date _anniversary;
	private Blob _employeePhoto;
	private int _employeeStatus;
	private double _totalPay;
	private double _basicPay;
	private double _da;
	private double _hra;
	private double _medical;
	private double _ta;
	private double _conveyance;
	private double _internet;
	private double _mobile;
	private double _fare;
	private double _areas;
	private double _bouns;
	private double _insurance;
	private double _otherAllowance;
	private double _providentFund;
	private double _professionTax;
	private double _incomeTax;
	private double _loan;
	private double _otherDeduction;
	private long _bankId;
	private String _branchAddress;
	private String _accountNo;
	private String _pfNo;
	private String _aadhaarNo;
	private int _employeetypeId;
	private int _ispfdeduct;
	private int _roleId;
	private Date _addedDate;
	private long _photoId;
	private long _userId;
	private long _branchId;
	private String _panNo;
	private String _pesonalEmaiAddress;
	private double _payPerMonth;
	private long _groupId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
}