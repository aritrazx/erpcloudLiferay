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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.RecruitProcessServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.RecruitProcessServiceSoap
 * @generated
 */
@ProviderType
public class RecruitProcessSoap implements Serializable {
	public static RecruitProcessSoap toSoapModel(RecruitProcess model) {
		RecruitProcessSoap soapModel = new RecruitProcessSoap();

		soapModel.setRecruitProcessId(model.getRecruitProcessId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setInterviewDate(model.getInterviewDate());
		soapModel.setInterviewTime(model.getInterviewTime());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileUrl(model.getFileUrl());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setInterviewerRemarks(model.getInterviewerRemarks());
		soapModel.setHrRemarks(model.getHrRemarks());
		soapModel.setIsSelected(model.getIsSelected());
		soapModel.setStatus(model.getStatus());
		soapModel.setDOB(model.getDOB());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setSkillset(model.getSkillset());
		soapModel.setExperience(model.getExperience());
		soapModel.setNoticePeriod(model.getNoticePeriod());
		soapModel.setCurrentCTC(model.getCurrentCTC());
		soapModel.setExpextedCTC(model.getExpextedCTC());
		soapModel.setProjectRoleId(model.getProjectRoleId());
		soapModel.setReference(model.getReference());

		return soapModel;
	}

	public static RecruitProcessSoap[] toSoapModels(RecruitProcess[] models) {
		RecruitProcessSoap[] soapModels = new RecruitProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitProcessSoap[][] toSoapModels(RecruitProcess[][] models) {
		RecruitProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitProcessSoap[] toSoapModels(List<RecruitProcess> models) {
		List<RecruitProcessSoap> soapModels = new ArrayList<RecruitProcessSoap>(models.size());

		for (RecruitProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitProcessSoap[soapModels.size()]);
	}

	public RecruitProcessSoap() {
	}

	public long getPrimaryKey() {
		return _recruitProcessId;
	}

	public void setPrimaryKey(long pk) {
		setRecruitProcessId(pk);
	}

	public long getRecruitProcessId() {
		return _recruitProcessId;
	}

	public void setRecruitProcessId(long recruitProcessId) {
		_recruitProcessId = recruitProcessId;
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

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Date getInterviewDate() {
		return _interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		_interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return _interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		_interviewTime = interviewTime;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getFileUrl() {
		return _fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		_fileUrl = fileUrl;
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

	public String getInterviewerRemarks() {
		return _interviewerRemarks;
	}

	public void setInterviewerRemarks(String interviewerRemarks) {
		_interviewerRemarks = interviewerRemarks;
	}

	public String getHrRemarks() {
		return _hrRemarks;
	}

	public void setHrRemarks(String hrRemarks) {
		_hrRemarks = hrRemarks;
	}

	public int getIsSelected() {
		return _isSelected;
	}

	public void setIsSelected(int isSelected) {
		_isSelected = isSelected;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public Date getDOB() {
		return _DOB;
	}

	public void setDOB(Date DOB) {
		_DOB = DOB;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getSkillset() {
		return _skillset;
	}

	public void setSkillset(String skillset) {
		_skillset = skillset;
	}

	public double getExperience() {
		return _experience;
	}

	public void setExperience(double experience) {
		_experience = experience;
	}

	public int getNoticePeriod() {
		return _noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		_noticePeriod = noticePeriod;
	}

	public double getCurrentCTC() {
		return _currentCTC;
	}

	public void setCurrentCTC(double currentCTC) {
		_currentCTC = currentCTC;
	}

	public double getExpextedCTC() {
		return _expextedCTC;
	}

	public void setExpextedCTC(double expextedCTC) {
		_expextedCTC = expextedCTC;
	}

	public long getProjectRoleId() {
		return _projectRoleId;
	}

	public void setProjectRoleId(long projectRoleId) {
		_projectRoleId = projectRoleId;
	}

	public long getReference() {
		return _reference;
	}

	public void setReference(long reference) {
		_reference = reference;
	}

	private long _recruitProcessId;
	private String _firstName;
	private String _lastName;
	private long _employeeId;
	private Date _interviewDate;
	private String _interviewTime;
	private long _fileEntryId;
	private String _fileUrl;
	private Date _createDate;
	private Date _modifiedDate;
	private String _interviewerRemarks;
	private String _hrRemarks;
	private int _isSelected;
	private long _status;
	private Date _DOB;
	private String _email;
	private long _phoneNumber;
	private String _skillset;
	private double _experience;
	private int _noticePeriod;
	private double _currentCTC;
	private double _expextedCTC;
	private long _projectRoleId;
	private long _reference;
}