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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.CandidateApplyServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.CandidateApplyServiceSoap
 * @generated
 */
@ProviderType
public class CandidateApplySoap implements Serializable {
	public static CandidateApplySoap toSoapModel(CandidateApply model) {
		CandidateApplySoap soapModel = new CandidateApplySoap();

		soapModel.setApplyCandidateId(model.getApplyCandidateId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setYearOfExp(model.getYearOfExp());
		soapModel.setMonthOfExp(model.getMonthOfExp());
		soapModel.setCurrentCTC(model.getCurrentCTC());
		soapModel.setExpectedCTC(model.getExpectedCTC());
		soapModel.setCurrentCompany(model.getCurrentCompany());
		soapModel.setNoticePeriod(model.getNoticePeriod());
		soapModel.setReferenceEmployeeId(model.getReferenceEmployeeId());
		soapModel.setCvFileId(model.getCvFileId());
		soapModel.setJobOpeningId(model.getJobOpeningId());
		soapModel.setSkillset(model.getSkillset());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CandidateApplySoap[] toSoapModels(CandidateApply[] models) {
		CandidateApplySoap[] soapModels = new CandidateApplySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateApplySoap[][] toSoapModels(CandidateApply[][] models) {
		CandidateApplySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateApplySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateApplySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateApplySoap[] toSoapModels(List<CandidateApply> models) {
		List<CandidateApplySoap> soapModels = new ArrayList<CandidateApplySoap>(models.size());

		for (CandidateApply model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateApplySoap[soapModels.size()]);
	}

	public CandidateApplySoap() {
	}

	public long getPrimaryKey() {
		return _applyCandidateId;
	}

	public void setPrimaryKey(long pk) {
		setApplyCandidateId(pk);
	}

	public long getApplyCandidateId() {
		return _applyCandidateId;
	}

	public void setApplyCandidateId(long applyCandidateId) {
		_applyCandidateId = applyCandidateId;
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

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public int getYearOfExp() {
		return _yearOfExp;
	}

	public void setYearOfExp(int yearOfExp) {
		_yearOfExp = yearOfExp;
	}

	public int getMonthOfExp() {
		return _monthOfExp;
	}

	public void setMonthOfExp(int monthOfExp) {
		_monthOfExp = monthOfExp;
	}

	public int getCurrentCTC() {
		return _currentCTC;
	}

	public void setCurrentCTC(int currentCTC) {
		_currentCTC = currentCTC;
	}

	public int getExpectedCTC() {
		return _expectedCTC;
	}

	public void setExpectedCTC(int expectedCTC) {
		_expectedCTC = expectedCTC;
	}

	public String getCurrentCompany() {
		return _currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		_currentCompany = currentCompany;
	}

	public int getNoticePeriod() {
		return _noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		_noticePeriod = noticePeriod;
	}

	public long getReferenceEmployeeId() {
		return _referenceEmployeeId;
	}

	public void setReferenceEmployeeId(long referenceEmployeeId) {
		_referenceEmployeeId = referenceEmployeeId;
	}

	public long getCvFileId() {
		return _cvFileId;
	}

	public void setCvFileId(long cvFileId) {
		_cvFileId = cvFileId;
	}

	public long getJobOpeningId() {
		return _jobOpeningId;
	}

	public void setJobOpeningId(long jobOpeningId) {
		_jobOpeningId = jobOpeningId;
	}

	public String getSkillset() {
		return _skillset;
	}

	public void setSkillset(String skillset) {
		_skillset = skillset;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _applyCandidateId;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private String _phoneNumber;
	private int _yearOfExp;
	private int _monthOfExp;
	private int _currentCTC;
	private int _expectedCTC;
	private String _currentCompany;
	private int _noticePeriod;
	private long _referenceEmployeeId;
	private long _cvFileId;
	private long _jobOpeningId;
	private String _skillset;
	private int _status;
}