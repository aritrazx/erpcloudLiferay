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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CandidateApply}.
 * </p>
 *
 * @author Samaresh
 * @see CandidateApply
 * @generated
 */
@ProviderType
public class CandidateApplyWrapper implements CandidateApply,
	ModelWrapper<CandidateApply> {
	public CandidateApplyWrapper(CandidateApply candidateApply) {
		_candidateApply = candidateApply;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateApply.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateApply.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applyCandidateId", getApplyCandidateId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("yearOfExp", getYearOfExp());
		attributes.put("monthOfExp", getMonthOfExp());
		attributes.put("currentCTC", getCurrentCTC());
		attributes.put("expectedCTC", getExpectedCTC());
		attributes.put("currentCompany", getCurrentCompany());
		attributes.put("noticePeriod", getNoticePeriod());
		attributes.put("referenceEmployeeId", getReferenceEmployeeId());
		attributes.put("cvFileId", getCvFileId());
		attributes.put("jobOpeningId", getJobOpeningId());
		attributes.put("skillset", getSkillset());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applyCandidateId = (Long)attributes.get("applyCandidateId");

		if (applyCandidateId != null) {
			setApplyCandidateId(applyCandidateId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		Integer yearOfExp = (Integer)attributes.get("yearOfExp");

		if (yearOfExp != null) {
			setYearOfExp(yearOfExp);
		}

		Integer monthOfExp = (Integer)attributes.get("monthOfExp");

		if (monthOfExp != null) {
			setMonthOfExp(monthOfExp);
		}

		Integer currentCTC = (Integer)attributes.get("currentCTC");

		if (currentCTC != null) {
			setCurrentCTC(currentCTC);
		}

		Integer expectedCTC = (Integer)attributes.get("expectedCTC");

		if (expectedCTC != null) {
			setExpectedCTC(expectedCTC);
		}

		String currentCompany = (String)attributes.get("currentCompany");

		if (currentCompany != null) {
			setCurrentCompany(currentCompany);
		}

		Integer noticePeriod = (Integer)attributes.get("noticePeriod");

		if (noticePeriod != null) {
			setNoticePeriod(noticePeriod);
		}

		Long referenceEmployeeId = (Long)attributes.get("referenceEmployeeId");

		if (referenceEmployeeId != null) {
			setReferenceEmployeeId(referenceEmployeeId);
		}

		Long cvFileId = (Long)attributes.get("cvFileId");

		if (cvFileId != null) {
			setCvFileId(cvFileId);
		}

		Long jobOpeningId = (Long)attributes.get("jobOpeningId");

		if (jobOpeningId != null) {
			setJobOpeningId(jobOpeningId);
		}

		String skillset = (String)attributes.get("skillset");

		if (skillset != null) {
			setSkillset(skillset);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new CandidateApplyWrapper((CandidateApply)_candidateApply.clone());
	}

	@Override
	public int compareTo(CandidateApply candidateApply) {
		return _candidateApply.compareTo(candidateApply);
	}

	/**
	* Returns the apply candidate ID of this candidate apply.
	*
	* @return the apply candidate ID of this candidate apply
	*/
	@Override
	public long getApplyCandidateId() {
		return _candidateApply.getApplyCandidateId();
	}

	/**
	* Returns the current company of this candidate apply.
	*
	* @return the current company of this candidate apply
	*/
	@Override
	public String getCurrentCompany() {
		return _candidateApply.getCurrentCompany();
	}

	/**
	* Returns the current ctc of this candidate apply.
	*
	* @return the current ctc of this candidate apply
	*/
	@Override
	public int getCurrentCTC() {
		return _candidateApply.getCurrentCTC();
	}

	/**
	* Returns the cv file ID of this candidate apply.
	*
	* @return the cv file ID of this candidate apply
	*/
	@Override
	public long getCvFileId() {
		return _candidateApply.getCvFileId();
	}

	/**
	* Returns the email address of this candidate apply.
	*
	* @return the email address of this candidate apply
	*/
	@Override
	public String getEmailAddress() {
		return _candidateApply.getEmailAddress();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _candidateApply.getExpandoBridge();
	}

	/**
	* Returns the expected ctc of this candidate apply.
	*
	* @return the expected ctc of this candidate apply
	*/
	@Override
	public int getExpectedCTC() {
		return _candidateApply.getExpectedCTC();
	}

	/**
	* Returns the first name of this candidate apply.
	*
	* @return the first name of this candidate apply
	*/
	@Override
	public String getFirstName() {
		return _candidateApply.getFirstName();
	}

	/**
	* Returns the job opening ID of this candidate apply.
	*
	* @return the job opening ID of this candidate apply
	*/
	@Override
	public long getJobOpeningId() {
		return _candidateApply.getJobOpeningId();
	}

	/**
	* Returns the last name of this candidate apply.
	*
	* @return the last name of this candidate apply
	*/
	@Override
	public String getLastName() {
		return _candidateApply.getLastName();
	}

	/**
	* Returns the month of exp of this candidate apply.
	*
	* @return the month of exp of this candidate apply
	*/
	@Override
	public int getMonthOfExp() {
		return _candidateApply.getMonthOfExp();
	}

	/**
	* Returns the notice period of this candidate apply.
	*
	* @return the notice period of this candidate apply
	*/
	@Override
	public int getNoticePeriod() {
		return _candidateApply.getNoticePeriod();
	}

	/**
	* Returns the phone number of this candidate apply.
	*
	* @return the phone number of this candidate apply
	*/
	@Override
	public String getPhoneNumber() {
		return _candidateApply.getPhoneNumber();
	}

	/**
	* Returns the primary key of this candidate apply.
	*
	* @return the primary key of this candidate apply
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateApply.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateApply.getPrimaryKeyObj();
	}

	/**
	* Returns the reference employee ID of this candidate apply.
	*
	* @return the reference employee ID of this candidate apply
	*/
	@Override
	public long getReferenceEmployeeId() {
		return _candidateApply.getReferenceEmployeeId();
	}

	/**
	* Returns the skillset of this candidate apply.
	*
	* @return the skillset of this candidate apply
	*/
	@Override
	public String getSkillset() {
		return _candidateApply.getSkillset();
	}

	/**
	* Returns the status of this candidate apply.
	*
	* @return the status of this candidate apply
	*/
	@Override
	public int getStatus() {
		return _candidateApply.getStatus();
	}

	/**
	* Returns the year of exp of this candidate apply.
	*
	* @return the year of exp of this candidate apply
	*/
	@Override
	public int getYearOfExp() {
		return _candidateApply.getYearOfExp();
	}

	@Override
	public int hashCode() {
		return _candidateApply.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _candidateApply.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateApply.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _candidateApply.isNew();
	}

	@Override
	public void persist() {
		_candidateApply.persist();
	}

	/**
	* Sets the apply candidate ID of this candidate apply.
	*
	* @param applyCandidateId the apply candidate ID of this candidate apply
	*/
	@Override
	public void setApplyCandidateId(long applyCandidateId) {
		_candidateApply.setApplyCandidateId(applyCandidateId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateApply.setCachedModel(cachedModel);
	}

	/**
	* Sets the current company of this candidate apply.
	*
	* @param currentCompany the current company of this candidate apply
	*/
	@Override
	public void setCurrentCompany(String currentCompany) {
		_candidateApply.setCurrentCompany(currentCompany);
	}

	/**
	* Sets the current ctc of this candidate apply.
	*
	* @param currentCTC the current ctc of this candidate apply
	*/
	@Override
	public void setCurrentCTC(int currentCTC) {
		_candidateApply.setCurrentCTC(currentCTC);
	}

	/**
	* Sets the cv file ID of this candidate apply.
	*
	* @param cvFileId the cv file ID of this candidate apply
	*/
	@Override
	public void setCvFileId(long cvFileId) {
		_candidateApply.setCvFileId(cvFileId);
	}

	/**
	* Sets the email address of this candidate apply.
	*
	* @param emailAddress the email address of this candidate apply
	*/
	@Override
	public void setEmailAddress(String emailAddress) {
		_candidateApply.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_candidateApply.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_candidateApply.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_candidateApply.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expected ctc of this candidate apply.
	*
	* @param expectedCTC the expected ctc of this candidate apply
	*/
	@Override
	public void setExpectedCTC(int expectedCTC) {
		_candidateApply.setExpectedCTC(expectedCTC);
	}

	/**
	* Sets the first name of this candidate apply.
	*
	* @param firstName the first name of this candidate apply
	*/
	@Override
	public void setFirstName(String firstName) {
		_candidateApply.setFirstName(firstName);
	}

	/**
	* Sets the job opening ID of this candidate apply.
	*
	* @param jobOpeningId the job opening ID of this candidate apply
	*/
	@Override
	public void setJobOpeningId(long jobOpeningId) {
		_candidateApply.setJobOpeningId(jobOpeningId);
	}

	/**
	* Sets the last name of this candidate apply.
	*
	* @param lastName the last name of this candidate apply
	*/
	@Override
	public void setLastName(String lastName) {
		_candidateApply.setLastName(lastName);
	}

	/**
	* Sets the month of exp of this candidate apply.
	*
	* @param monthOfExp the month of exp of this candidate apply
	*/
	@Override
	public void setMonthOfExp(int monthOfExp) {
		_candidateApply.setMonthOfExp(monthOfExp);
	}

	@Override
	public void setNew(boolean n) {
		_candidateApply.setNew(n);
	}

	/**
	* Sets the notice period of this candidate apply.
	*
	* @param noticePeriod the notice period of this candidate apply
	*/
	@Override
	public void setNoticePeriod(int noticePeriod) {
		_candidateApply.setNoticePeriod(noticePeriod);
	}

	/**
	* Sets the phone number of this candidate apply.
	*
	* @param phoneNumber the phone number of this candidate apply
	*/
	@Override
	public void setPhoneNumber(String phoneNumber) {
		_candidateApply.setPhoneNumber(phoneNumber);
	}

	/**
	* Sets the primary key of this candidate apply.
	*
	* @param primaryKey the primary key of this candidate apply
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateApply.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_candidateApply.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reference employee ID of this candidate apply.
	*
	* @param referenceEmployeeId the reference employee ID of this candidate apply
	*/
	@Override
	public void setReferenceEmployeeId(long referenceEmployeeId) {
		_candidateApply.setReferenceEmployeeId(referenceEmployeeId);
	}

	/**
	* Sets the skillset of this candidate apply.
	*
	* @param skillset the skillset of this candidate apply
	*/
	@Override
	public void setSkillset(String skillset) {
		_candidateApply.setSkillset(skillset);
	}

	/**
	* Sets the status of this candidate apply.
	*
	* @param status the status of this candidate apply
	*/
	@Override
	public void setStatus(int status) {
		_candidateApply.setStatus(status);
	}

	/**
	* Sets the year of exp of this candidate apply.
	*
	* @param yearOfExp the year of exp of this candidate apply
	*/
	@Override
	public void setYearOfExp(int yearOfExp) {
		_candidateApply.setYearOfExp(yearOfExp);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CandidateApply> toCacheModel() {
		return _candidateApply.toCacheModel();
	}

	@Override
	public CandidateApply toEscapedModel() {
		return new CandidateApplyWrapper(_candidateApply.toEscapedModel());
	}

	@Override
	public String toString() {
		return _candidateApply.toString();
	}

	@Override
	public CandidateApply toUnescapedModel() {
		return new CandidateApplyWrapper(_candidateApply.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _candidateApply.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateApplyWrapper)) {
			return false;
		}

		CandidateApplyWrapper candidateApplyWrapper = (CandidateApplyWrapper)obj;

		if (Objects.equals(_candidateApply,
					candidateApplyWrapper._candidateApply)) {
			return true;
		}

		return false;
	}

	@Override
	public CandidateApply getWrappedModel() {
		return _candidateApply;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _candidateApply.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _candidateApply.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_candidateApply.resetOriginalValues();
	}

	private final CandidateApply _candidateApply;
}