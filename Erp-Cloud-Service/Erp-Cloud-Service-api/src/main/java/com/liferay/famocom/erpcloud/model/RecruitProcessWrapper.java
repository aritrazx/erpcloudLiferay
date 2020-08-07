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
 * This class is a wrapper for {@link RecruitProcess}.
 * </p>
 *
 * @author Samaresh
 * @see RecruitProcess
 * @generated
 */
@ProviderType
public class RecruitProcessWrapper implements RecruitProcess,
	ModelWrapper<RecruitProcess> {
	public RecruitProcessWrapper(RecruitProcess recruitProcess) {
		_recruitProcess = recruitProcess;
	}

	@Override
	public Class<?> getModelClass() {
		return RecruitProcess.class;
	}

	@Override
	public String getModelClassName() {
		return RecruitProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitProcessId", getRecruitProcessId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("interviewDate", getInterviewDate());
		attributes.put("interviewTime", getInterviewTime());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileUrl", getFileUrl());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("interviewerRemarks", getInterviewerRemarks());
		attributes.put("hrRemarks", getHrRemarks());
		attributes.put("isSelected", getIsSelected());
		attributes.put("status", getStatus());
		attributes.put("DOB", getDOB());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("skillset", getSkillset());
		attributes.put("experience", getExperience());
		attributes.put("noticePeriod", getNoticePeriod());
		attributes.put("currentCTC", getCurrentCTC());
		attributes.put("expextedCTC", getExpextedCTC());
		attributes.put("projectRoleId", getProjectRoleId());
		attributes.put("reference", getReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recruitProcessId = (Long)attributes.get("recruitProcessId");

		if (recruitProcessId != null) {
			setRecruitProcessId(recruitProcessId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date interviewDate = (Date)attributes.get("interviewDate");

		if (interviewDate != null) {
			setInterviewDate(interviewDate);
		}

		String interviewTime = (String)attributes.get("interviewTime");

		if (interviewTime != null) {
			setInterviewTime(interviewTime);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String fileUrl = (String)attributes.get("fileUrl");

		if (fileUrl != null) {
			setFileUrl(fileUrl);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String interviewerRemarks = (String)attributes.get("interviewerRemarks");

		if (interviewerRemarks != null) {
			setInterviewerRemarks(interviewerRemarks);
		}

		String hrRemarks = (String)attributes.get("hrRemarks");

		if (hrRemarks != null) {
			setHrRemarks(hrRemarks);
		}

		Integer isSelected = (Integer)attributes.get("isSelected");

		if (isSelected != null) {
			setIsSelected(isSelected);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date DOB = (Date)attributes.get("DOB");

		if (DOB != null) {
			setDOB(DOB);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long phoneNumber = (Long)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String skillset = (String)attributes.get("skillset");

		if (skillset != null) {
			setSkillset(skillset);
		}

		Double experience = (Double)attributes.get("experience");

		if (experience != null) {
			setExperience(experience);
		}

		Integer noticePeriod = (Integer)attributes.get("noticePeriod");

		if (noticePeriod != null) {
			setNoticePeriod(noticePeriod);
		}

		Double currentCTC = (Double)attributes.get("currentCTC");

		if (currentCTC != null) {
			setCurrentCTC(currentCTC);
		}

		Double expextedCTC = (Double)attributes.get("expextedCTC");

		if (expextedCTC != null) {
			setExpextedCTC(expextedCTC);
		}

		Long projectRoleId = (Long)attributes.get("projectRoleId");

		if (projectRoleId != null) {
			setProjectRoleId(projectRoleId);
		}

		Long reference = (Long)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}
	}

	@Override
	public Object clone() {
		return new RecruitProcessWrapper((RecruitProcess)_recruitProcess.clone());
	}

	@Override
	public int compareTo(RecruitProcess recruitProcess) {
		return _recruitProcess.compareTo(recruitProcess);
	}

	/**
	* Returns the create date of this recruit process.
	*
	* @return the create date of this recruit process
	*/
	@Override
	public Date getCreateDate() {
		return _recruitProcess.getCreateDate();
	}

	/**
	* Returns the current ctc of this recruit process.
	*
	* @return the current ctc of this recruit process
	*/
	@Override
	public double getCurrentCTC() {
		return _recruitProcess.getCurrentCTC();
	}

	/**
	* Returns the dob of this recruit process.
	*
	* @return the dob of this recruit process
	*/
	@Override
	public Date getDOB() {
		return _recruitProcess.getDOB();
	}

	/**
	* Returns the email of this recruit process.
	*
	* @return the email of this recruit process
	*/
	@Override
	public String getEmail() {
		return _recruitProcess.getEmail();
	}

	/**
	* Returns the employee ID of this recruit process.
	*
	* @return the employee ID of this recruit process
	*/
	@Override
	public long getEmployeeId() {
		return _recruitProcess.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _recruitProcess.getExpandoBridge();
	}

	/**
	* Returns the experience of this recruit process.
	*
	* @return the experience of this recruit process
	*/
	@Override
	public double getExperience() {
		return _recruitProcess.getExperience();
	}

	/**
	* Returns the expexted ctc of this recruit process.
	*
	* @return the expexted ctc of this recruit process
	*/
	@Override
	public double getExpextedCTC() {
		return _recruitProcess.getExpextedCTC();
	}

	/**
	* Returns the file entry ID of this recruit process.
	*
	* @return the file entry ID of this recruit process
	*/
	@Override
	public long getFileEntryId() {
		return _recruitProcess.getFileEntryId();
	}

	/**
	* Returns the file url of this recruit process.
	*
	* @return the file url of this recruit process
	*/
	@Override
	public String getFileUrl() {
		return _recruitProcess.getFileUrl();
	}

	/**
	* Returns the first name of this recruit process.
	*
	* @return the first name of this recruit process
	*/
	@Override
	public String getFirstName() {
		return _recruitProcess.getFirstName();
	}

	/**
	* Returns the hr remarks of this recruit process.
	*
	* @return the hr remarks of this recruit process
	*/
	@Override
	public String getHrRemarks() {
		return _recruitProcess.getHrRemarks();
	}

	/**
	* Returns the interview date of this recruit process.
	*
	* @return the interview date of this recruit process
	*/
	@Override
	public Date getInterviewDate() {
		return _recruitProcess.getInterviewDate();
	}

	/**
	* Returns the interviewer remarks of this recruit process.
	*
	* @return the interviewer remarks of this recruit process
	*/
	@Override
	public String getInterviewerRemarks() {
		return _recruitProcess.getInterviewerRemarks();
	}

	/**
	* Returns the interview time of this recruit process.
	*
	* @return the interview time of this recruit process
	*/
	@Override
	public String getInterviewTime() {
		return _recruitProcess.getInterviewTime();
	}

	/**
	* Returns the is selected of this recruit process.
	*
	* @return the is selected of this recruit process
	*/
	@Override
	public int getIsSelected() {
		return _recruitProcess.getIsSelected();
	}

	/**
	* Returns the last name of this recruit process.
	*
	* @return the last name of this recruit process
	*/
	@Override
	public String getLastName() {
		return _recruitProcess.getLastName();
	}

	/**
	* Returns the modified date of this recruit process.
	*
	* @return the modified date of this recruit process
	*/
	@Override
	public Date getModifiedDate() {
		return _recruitProcess.getModifiedDate();
	}

	/**
	* Returns the notice period of this recruit process.
	*
	* @return the notice period of this recruit process
	*/
	@Override
	public int getNoticePeriod() {
		return _recruitProcess.getNoticePeriod();
	}

	/**
	* Returns the phone number of this recruit process.
	*
	* @return the phone number of this recruit process
	*/
	@Override
	public long getPhoneNumber() {
		return _recruitProcess.getPhoneNumber();
	}

	/**
	* Returns the primary key of this recruit process.
	*
	* @return the primary key of this recruit process
	*/
	@Override
	public long getPrimaryKey() {
		return _recruitProcess.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recruitProcess.getPrimaryKeyObj();
	}

	/**
	* Returns the project role ID of this recruit process.
	*
	* @return the project role ID of this recruit process
	*/
	@Override
	public long getProjectRoleId() {
		return _recruitProcess.getProjectRoleId();
	}

	/**
	* Returns the recruit process ID of this recruit process.
	*
	* @return the recruit process ID of this recruit process
	*/
	@Override
	public long getRecruitProcessId() {
		return _recruitProcess.getRecruitProcessId();
	}

	/**
	* Returns the reference of this recruit process.
	*
	* @return the reference of this recruit process
	*/
	@Override
	public long getReference() {
		return _recruitProcess.getReference();
	}

	/**
	* Returns the skillset of this recruit process.
	*
	* @return the skillset of this recruit process
	*/
	@Override
	public String getSkillset() {
		return _recruitProcess.getSkillset();
	}

	/**
	* Returns the status of this recruit process.
	*
	* @return the status of this recruit process
	*/
	@Override
	public long getStatus() {
		return _recruitProcess.getStatus();
	}

	@Override
	public int hashCode() {
		return _recruitProcess.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _recruitProcess.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _recruitProcess.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _recruitProcess.isNew();
	}

	@Override
	public void persist() {
		_recruitProcess.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_recruitProcess.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this recruit process.
	*
	* @param createDate the create date of this recruit process
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_recruitProcess.setCreateDate(createDate);
	}

	/**
	* Sets the current ctc of this recruit process.
	*
	* @param currentCTC the current ctc of this recruit process
	*/
	@Override
	public void setCurrentCTC(double currentCTC) {
		_recruitProcess.setCurrentCTC(currentCTC);
	}

	/**
	* Sets the dob of this recruit process.
	*
	* @param DOB the dob of this recruit process
	*/
	@Override
	public void setDOB(Date DOB) {
		_recruitProcess.setDOB(DOB);
	}

	/**
	* Sets the email of this recruit process.
	*
	* @param email the email of this recruit process
	*/
	@Override
	public void setEmail(String email) {
		_recruitProcess.setEmail(email);
	}

	/**
	* Sets the employee ID of this recruit process.
	*
	* @param employeeId the employee ID of this recruit process
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_recruitProcess.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_recruitProcess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_recruitProcess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_recruitProcess.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the experience of this recruit process.
	*
	* @param experience the experience of this recruit process
	*/
	@Override
	public void setExperience(double experience) {
		_recruitProcess.setExperience(experience);
	}

	/**
	* Sets the expexted ctc of this recruit process.
	*
	* @param expextedCTC the expexted ctc of this recruit process
	*/
	@Override
	public void setExpextedCTC(double expextedCTC) {
		_recruitProcess.setExpextedCTC(expextedCTC);
	}

	/**
	* Sets the file entry ID of this recruit process.
	*
	* @param fileEntryId the file entry ID of this recruit process
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_recruitProcess.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the file url of this recruit process.
	*
	* @param fileUrl the file url of this recruit process
	*/
	@Override
	public void setFileUrl(String fileUrl) {
		_recruitProcess.setFileUrl(fileUrl);
	}

	/**
	* Sets the first name of this recruit process.
	*
	* @param firstName the first name of this recruit process
	*/
	@Override
	public void setFirstName(String firstName) {
		_recruitProcess.setFirstName(firstName);
	}

	/**
	* Sets the hr remarks of this recruit process.
	*
	* @param hrRemarks the hr remarks of this recruit process
	*/
	@Override
	public void setHrRemarks(String hrRemarks) {
		_recruitProcess.setHrRemarks(hrRemarks);
	}

	/**
	* Sets the interview date of this recruit process.
	*
	* @param interviewDate the interview date of this recruit process
	*/
	@Override
	public void setInterviewDate(Date interviewDate) {
		_recruitProcess.setInterviewDate(interviewDate);
	}

	/**
	* Sets the interviewer remarks of this recruit process.
	*
	* @param interviewerRemarks the interviewer remarks of this recruit process
	*/
	@Override
	public void setInterviewerRemarks(String interviewerRemarks) {
		_recruitProcess.setInterviewerRemarks(interviewerRemarks);
	}

	/**
	* Sets the interview time of this recruit process.
	*
	* @param interviewTime the interview time of this recruit process
	*/
	@Override
	public void setInterviewTime(String interviewTime) {
		_recruitProcess.setInterviewTime(interviewTime);
	}

	/**
	* Sets the is selected of this recruit process.
	*
	* @param isSelected the is selected of this recruit process
	*/
	@Override
	public void setIsSelected(int isSelected) {
		_recruitProcess.setIsSelected(isSelected);
	}

	/**
	* Sets the last name of this recruit process.
	*
	* @param lastName the last name of this recruit process
	*/
	@Override
	public void setLastName(String lastName) {
		_recruitProcess.setLastName(lastName);
	}

	/**
	* Sets the modified date of this recruit process.
	*
	* @param modifiedDate the modified date of this recruit process
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_recruitProcess.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_recruitProcess.setNew(n);
	}

	/**
	* Sets the notice period of this recruit process.
	*
	* @param noticePeriod the notice period of this recruit process
	*/
	@Override
	public void setNoticePeriod(int noticePeriod) {
		_recruitProcess.setNoticePeriod(noticePeriod);
	}

	/**
	* Sets the phone number of this recruit process.
	*
	* @param phoneNumber the phone number of this recruit process
	*/
	@Override
	public void setPhoneNumber(long phoneNumber) {
		_recruitProcess.setPhoneNumber(phoneNumber);
	}

	/**
	* Sets the primary key of this recruit process.
	*
	* @param primaryKey the primary key of this recruit process
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_recruitProcess.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_recruitProcess.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project role ID of this recruit process.
	*
	* @param projectRoleId the project role ID of this recruit process
	*/
	@Override
	public void setProjectRoleId(long projectRoleId) {
		_recruitProcess.setProjectRoleId(projectRoleId);
	}

	/**
	* Sets the recruit process ID of this recruit process.
	*
	* @param recruitProcessId the recruit process ID of this recruit process
	*/
	@Override
	public void setRecruitProcessId(long recruitProcessId) {
		_recruitProcess.setRecruitProcessId(recruitProcessId);
	}

	/**
	* Sets the reference of this recruit process.
	*
	* @param reference the reference of this recruit process
	*/
	@Override
	public void setReference(long reference) {
		_recruitProcess.setReference(reference);
	}

	/**
	* Sets the skillset of this recruit process.
	*
	* @param skillset the skillset of this recruit process
	*/
	@Override
	public void setSkillset(String skillset) {
		_recruitProcess.setSkillset(skillset);
	}

	/**
	* Sets the status of this recruit process.
	*
	* @param status the status of this recruit process
	*/
	@Override
	public void setStatus(long status) {
		_recruitProcess.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RecruitProcess> toCacheModel() {
		return _recruitProcess.toCacheModel();
	}

	@Override
	public RecruitProcess toEscapedModel() {
		return new RecruitProcessWrapper(_recruitProcess.toEscapedModel());
	}

	@Override
	public String toString() {
		return _recruitProcess.toString();
	}

	@Override
	public RecruitProcess toUnescapedModel() {
		return new RecruitProcessWrapper(_recruitProcess.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _recruitProcess.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecruitProcessWrapper)) {
			return false;
		}

		RecruitProcessWrapper recruitProcessWrapper = (RecruitProcessWrapper)obj;

		if (Objects.equals(_recruitProcess,
					recruitProcessWrapper._recruitProcess)) {
			return true;
		}

		return false;
	}

	@Override
	public RecruitProcess getWrappedModel() {
		return _recruitProcess;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _recruitProcess.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _recruitProcess.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_recruitProcess.resetOriginalValues();
	}

	private final RecruitProcess _recruitProcess;
}