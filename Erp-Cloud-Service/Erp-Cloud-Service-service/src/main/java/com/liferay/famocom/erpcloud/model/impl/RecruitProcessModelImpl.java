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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.model.RecruitProcessModel;
import com.liferay.famocom.erpcloud.model.RecruitProcessSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the RecruitProcess service. Represents a row in the &quot;RecruitProcess&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RecruitProcessModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RecruitProcessImpl}.
 * </p>
 *
 * @author Samaresh
 * @see RecruitProcessImpl
 * @see RecruitProcess
 * @see RecruitProcessModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RecruitProcessModelImpl extends BaseModelImpl<RecruitProcess>
	implements RecruitProcessModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a recruit process model instance should use the {@link RecruitProcess} interface instead.
	 */
	public static final String TABLE_NAME = "RecruitProcess";
	public static final Object[][] TABLE_COLUMNS = {
			{ "recruitProcessId", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "employeeId", Types.BIGINT },
			{ "interviewDate", Types.TIMESTAMP },
			{ "interviewTime", Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT },
			{ "fileUrl", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "interviewerRemarks", Types.VARCHAR },
			{ "hrRemarks", Types.VARCHAR },
			{ "isSelected", Types.INTEGER },
			{ "status", Types.BIGINT },
			{ "DOB", Types.TIMESTAMP },
			{ "email", Types.VARCHAR },
			{ "phoneNumber", Types.BIGINT },
			{ "skillset", Types.VARCHAR },
			{ "experience", Types.DOUBLE },
			{ "noticePeriod", Types.INTEGER },
			{ "currentCTC", Types.DOUBLE },
			{ "expextedCTC", Types.DOUBLE },
			{ "projectRoleId", Types.BIGINT },
			{ "reference", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("recruitProcessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("interviewDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("interviewTime", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("interviewerRemarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("hrRemarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isSelected", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("status", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DOB", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("skillset", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("experience", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("noticePeriod", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("currentCTC", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("expextedCTC", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("projectRoleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reference", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table RecruitProcess (recruitProcessId LONG not null primary key,firstName VARCHAR(75) null,lastName VARCHAR(75) null,employeeId LONG,interviewDate DATE null,interviewTime VARCHAR(75) null,fileEntryId LONG,fileUrl VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,interviewerRemarks VARCHAR(75) null,hrRemarks VARCHAR(75) null,isSelected INTEGER,status LONG,DOB DATE null,email VARCHAR(75) null,phoneNumber LONG,skillset VARCHAR(75) null,experience DOUBLE,noticePeriod INTEGER,currentCTC DOUBLE,expextedCTC DOUBLE,projectRoleId LONG,reference LONG)";
	public static final String TABLE_SQL_DROP = "drop table RecruitProcess";
	public static final String ORDER_BY_JPQL = " ORDER BY recruitProcess.recruitProcessId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY RecruitProcess.recruitProcessId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.RecruitProcess"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.RecruitProcess"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.RecruitProcess"),
			true);
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;
	public static final long RECRUITPROCESSID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RecruitProcess toModel(RecruitProcessSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RecruitProcess model = new RecruitProcessImpl();

		model.setRecruitProcessId(soapModel.getRecruitProcessId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setInterviewDate(soapModel.getInterviewDate());
		model.setInterviewTime(soapModel.getInterviewTime());
		model.setFileEntryId(soapModel.getFileEntryId());
		model.setFileUrl(soapModel.getFileUrl());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setInterviewerRemarks(soapModel.getInterviewerRemarks());
		model.setHrRemarks(soapModel.getHrRemarks());
		model.setIsSelected(soapModel.getIsSelected());
		model.setStatus(soapModel.getStatus());
		model.setDOB(soapModel.getDOB());
		model.setEmail(soapModel.getEmail());
		model.setPhoneNumber(soapModel.getPhoneNumber());
		model.setSkillset(soapModel.getSkillset());
		model.setExperience(soapModel.getExperience());
		model.setNoticePeriod(soapModel.getNoticePeriod());
		model.setCurrentCTC(soapModel.getCurrentCTC());
		model.setExpextedCTC(soapModel.getExpextedCTC());
		model.setProjectRoleId(soapModel.getProjectRoleId());
		model.setReference(soapModel.getReference());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RecruitProcess> toModels(RecruitProcessSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RecruitProcess> models = new ArrayList<RecruitProcess>(soapModels.length);

		for (RecruitProcessSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.RecruitProcess"));

	public RecruitProcessModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _recruitProcessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecruitProcessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recruitProcessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getRecruitProcessId() {
		return _recruitProcessId;
	}

	@Override
	public void setRecruitProcessId(long recruitProcessId) {
		_recruitProcessId = recruitProcessId;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _employeeId;
		}

		_employeeId = employeeId;
	}

	public long getOriginalEmployeeId() {
		return _originalEmployeeId;
	}

	@JSON
	@Override
	public Date getInterviewDate() {
		return _interviewDate;
	}

	@Override
	public void setInterviewDate(Date interviewDate) {
		_interviewDate = interviewDate;
	}

	@JSON
	@Override
	public String getInterviewTime() {
		if (_interviewTime == null) {
			return "";
		}
		else {
			return _interviewTime;
		}
	}

	@Override
	public void setInterviewTime(String interviewTime) {
		_interviewTime = interviewTime;
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@JSON
	@Override
	public String getFileUrl() {
		if (_fileUrl == null) {
			return "";
		}
		else {
			return _fileUrl;
		}
	}

	@Override
	public void setFileUrl(String fileUrl) {
		_fileUrl = fileUrl;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getInterviewerRemarks() {
		if (_interviewerRemarks == null) {
			return "";
		}
		else {
			return _interviewerRemarks;
		}
	}

	@Override
	public void setInterviewerRemarks(String interviewerRemarks) {
		_interviewerRemarks = interviewerRemarks;
	}

	@JSON
	@Override
	public String getHrRemarks() {
		if (_hrRemarks == null) {
			return "";
		}
		else {
			return _hrRemarks;
		}
	}

	@Override
	public void setHrRemarks(String hrRemarks) {
		_hrRemarks = hrRemarks;
	}

	@JSON
	@Override
	public int getIsSelected() {
		return _isSelected;
	}

	@Override
	public void setIsSelected(int isSelected) {
		_isSelected = isSelected;
	}

	@JSON
	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		_status = status;
	}

	@JSON
	@Override
	public Date getDOB() {
		return _DOB;
	}

	@Override
	public void setDOB(Date DOB) {
		_DOB = DOB;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public long getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public void setPhoneNumber(long phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@JSON
	@Override
	public String getSkillset() {
		if (_skillset == null) {
			return "";
		}
		else {
			return _skillset;
		}
	}

	@Override
	public void setSkillset(String skillset) {
		_skillset = skillset;
	}

	@JSON
	@Override
	public double getExperience() {
		return _experience;
	}

	@Override
	public void setExperience(double experience) {
		_experience = experience;
	}

	@JSON
	@Override
	public int getNoticePeriod() {
		return _noticePeriod;
	}

	@Override
	public void setNoticePeriod(int noticePeriod) {
		_noticePeriod = noticePeriod;
	}

	@JSON
	@Override
	public double getCurrentCTC() {
		return _currentCTC;
	}

	@Override
	public void setCurrentCTC(double currentCTC) {
		_currentCTC = currentCTC;
	}

	@JSON
	@Override
	public double getExpextedCTC() {
		return _expextedCTC;
	}

	@Override
	public void setExpextedCTC(double expextedCTC) {
		_expextedCTC = expextedCTC;
	}

	@JSON
	@Override
	public long getProjectRoleId() {
		return _projectRoleId;
	}

	@Override
	public void setProjectRoleId(long projectRoleId) {
		_projectRoleId = projectRoleId;
	}

	@JSON
	@Override
	public long getReference() {
		return _reference;
	}

	@Override
	public void setReference(long reference) {
		_reference = reference;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			RecruitProcess.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RecruitProcess toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RecruitProcess)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RecruitProcessImpl recruitProcessImpl = new RecruitProcessImpl();

		recruitProcessImpl.setRecruitProcessId(getRecruitProcessId());
		recruitProcessImpl.setFirstName(getFirstName());
		recruitProcessImpl.setLastName(getLastName());
		recruitProcessImpl.setEmployeeId(getEmployeeId());
		recruitProcessImpl.setInterviewDate(getInterviewDate());
		recruitProcessImpl.setInterviewTime(getInterviewTime());
		recruitProcessImpl.setFileEntryId(getFileEntryId());
		recruitProcessImpl.setFileUrl(getFileUrl());
		recruitProcessImpl.setCreateDate(getCreateDate());
		recruitProcessImpl.setModifiedDate(getModifiedDate());
		recruitProcessImpl.setInterviewerRemarks(getInterviewerRemarks());
		recruitProcessImpl.setHrRemarks(getHrRemarks());
		recruitProcessImpl.setIsSelected(getIsSelected());
		recruitProcessImpl.setStatus(getStatus());
		recruitProcessImpl.setDOB(getDOB());
		recruitProcessImpl.setEmail(getEmail());
		recruitProcessImpl.setPhoneNumber(getPhoneNumber());
		recruitProcessImpl.setSkillset(getSkillset());
		recruitProcessImpl.setExperience(getExperience());
		recruitProcessImpl.setNoticePeriod(getNoticePeriod());
		recruitProcessImpl.setCurrentCTC(getCurrentCTC());
		recruitProcessImpl.setExpextedCTC(getExpextedCTC());
		recruitProcessImpl.setProjectRoleId(getProjectRoleId());
		recruitProcessImpl.setReference(getReference());

		recruitProcessImpl.resetOriginalValues();

		return recruitProcessImpl;
	}

	@Override
	public int compareTo(RecruitProcess recruitProcess) {
		long primaryKey = recruitProcess.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecruitProcess)) {
			return false;
		}

		RecruitProcess recruitProcess = (RecruitProcess)obj;

		long primaryKey = recruitProcess.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		RecruitProcessModelImpl recruitProcessModelImpl = this;

		recruitProcessModelImpl._originalEmployeeId = recruitProcessModelImpl._employeeId;

		recruitProcessModelImpl._setOriginalEmployeeId = false;

		recruitProcessModelImpl._setModifiedDate = false;

		recruitProcessModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RecruitProcess> toCacheModel() {
		RecruitProcessCacheModel recruitProcessCacheModel = new RecruitProcessCacheModel();

		recruitProcessCacheModel.recruitProcessId = getRecruitProcessId();

		recruitProcessCacheModel.firstName = getFirstName();

		String firstName = recruitProcessCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			recruitProcessCacheModel.firstName = null;
		}

		recruitProcessCacheModel.lastName = getLastName();

		String lastName = recruitProcessCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			recruitProcessCacheModel.lastName = null;
		}

		recruitProcessCacheModel.employeeId = getEmployeeId();

		Date interviewDate = getInterviewDate();

		if (interviewDate != null) {
			recruitProcessCacheModel.interviewDate = interviewDate.getTime();
		}
		else {
			recruitProcessCacheModel.interviewDate = Long.MIN_VALUE;
		}

		recruitProcessCacheModel.interviewTime = getInterviewTime();

		String interviewTime = recruitProcessCacheModel.interviewTime;

		if ((interviewTime != null) && (interviewTime.length() == 0)) {
			recruitProcessCacheModel.interviewTime = null;
		}

		recruitProcessCacheModel.fileEntryId = getFileEntryId();

		recruitProcessCacheModel.fileUrl = getFileUrl();

		String fileUrl = recruitProcessCacheModel.fileUrl;

		if ((fileUrl != null) && (fileUrl.length() == 0)) {
			recruitProcessCacheModel.fileUrl = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			recruitProcessCacheModel.createDate = createDate.getTime();
		}
		else {
			recruitProcessCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			recruitProcessCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			recruitProcessCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		recruitProcessCacheModel.interviewerRemarks = getInterviewerRemarks();

		String interviewerRemarks = recruitProcessCacheModel.interviewerRemarks;

		if ((interviewerRemarks != null) && (interviewerRemarks.length() == 0)) {
			recruitProcessCacheModel.interviewerRemarks = null;
		}

		recruitProcessCacheModel.hrRemarks = getHrRemarks();

		String hrRemarks = recruitProcessCacheModel.hrRemarks;

		if ((hrRemarks != null) && (hrRemarks.length() == 0)) {
			recruitProcessCacheModel.hrRemarks = null;
		}

		recruitProcessCacheModel.isSelected = getIsSelected();

		recruitProcessCacheModel.status = getStatus();

		Date DOB = getDOB();

		if (DOB != null) {
			recruitProcessCacheModel.DOB = DOB.getTime();
		}
		else {
			recruitProcessCacheModel.DOB = Long.MIN_VALUE;
		}

		recruitProcessCacheModel.email = getEmail();

		String email = recruitProcessCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			recruitProcessCacheModel.email = null;
		}

		recruitProcessCacheModel.phoneNumber = getPhoneNumber();

		recruitProcessCacheModel.skillset = getSkillset();

		String skillset = recruitProcessCacheModel.skillset;

		if ((skillset != null) && (skillset.length() == 0)) {
			recruitProcessCacheModel.skillset = null;
		}

		recruitProcessCacheModel.experience = getExperience();

		recruitProcessCacheModel.noticePeriod = getNoticePeriod();

		recruitProcessCacheModel.currentCTC = getCurrentCTC();

		recruitProcessCacheModel.expextedCTC = getExpextedCTC();

		recruitProcessCacheModel.projectRoleId = getProjectRoleId();

		recruitProcessCacheModel.reference = getReference();

		return recruitProcessCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{recruitProcessId=");
		sb.append(getRecruitProcessId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", interviewDate=");
		sb.append(getInterviewDate());
		sb.append(", interviewTime=");
		sb.append(getInterviewTime());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", fileUrl=");
		sb.append(getFileUrl());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", interviewerRemarks=");
		sb.append(getInterviewerRemarks());
		sb.append(", hrRemarks=");
		sb.append(getHrRemarks());
		sb.append(", isSelected=");
		sb.append(getIsSelected());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", DOB=");
		sb.append(getDOB());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", skillset=");
		sb.append(getSkillset());
		sb.append(", experience=");
		sb.append(getExperience());
		sb.append(", noticePeriod=");
		sb.append(getNoticePeriod());
		sb.append(", currentCTC=");
		sb.append(getCurrentCTC());
		sb.append(", expextedCTC=");
		sb.append(getExpextedCTC());
		sb.append(", projectRoleId=");
		sb.append(getProjectRoleId());
		sb.append(", reference=");
		sb.append(getReference());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.RecruitProcess");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitProcessId</column-name><column-value><![CDATA[");
		sb.append(getRecruitProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewDate</column-name><column-value><![CDATA[");
		sb.append(getInterviewDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewTime</column-name><column-value><![CDATA[");
		sb.append(getInterviewTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileUrl</column-name><column-value><![CDATA[");
		sb.append(getFileUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewerRemarks</column-name><column-value><![CDATA[");
		sb.append(getInterviewerRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrRemarks</column-name><column-value><![CDATA[");
		sb.append(getHrRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSelected</column-name><column-value><![CDATA[");
		sb.append(getIsSelected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DOB</column-name><column-value><![CDATA[");
		sb.append(getDOB());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skillset</column-name><column-value><![CDATA[");
		sb.append(getSkillset());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>experience</column-name><column-value><![CDATA[");
		sb.append(getExperience());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noticePeriod</column-name><column-value><![CDATA[");
		sb.append(getNoticePeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCTC</column-name><column-value><![CDATA[");
		sb.append(getCurrentCTC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expextedCTC</column-name><column-value><![CDATA[");
		sb.append(getExpextedCTC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectRoleId</column-name><column-value><![CDATA[");
		sb.append(getProjectRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reference</column-name><column-value><![CDATA[");
		sb.append(getReference());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = RecruitProcess.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			RecruitProcess.class, ModelWrapper.class
		};
	private long _recruitProcessId;
	private String _firstName;
	private String _lastName;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private Date _interviewDate;
	private String _interviewTime;
	private long _fileEntryId;
	private String _fileUrl;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
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
	private long _columnBitmask;
	private RecruitProcess _escapedModel;
}