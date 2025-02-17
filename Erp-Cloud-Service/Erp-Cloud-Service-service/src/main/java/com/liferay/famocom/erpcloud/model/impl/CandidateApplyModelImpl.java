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

import com.liferay.famocom.erpcloud.model.CandidateApply;
import com.liferay.famocom.erpcloud.model.CandidateApplyModel;
import com.liferay.famocom.erpcloud.model.CandidateApplySoap;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CandidateApply service. Represents a row in the &quot;CandidateApply&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CandidateApplyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateApplyImpl}.
 * </p>
 *
 * @author Samaresh
 * @see CandidateApplyImpl
 * @see CandidateApply
 * @see CandidateApplyModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CandidateApplyModelImpl extends BaseModelImpl<CandidateApply>
	implements CandidateApplyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate apply model instance should use the {@link CandidateApply} interface instead.
	 */
	public static final String TABLE_NAME = "CandidateApply";
	public static final Object[][] TABLE_COLUMNS = {
			{ "applyCandidateId", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "emailAddress", Types.VARCHAR },
			{ "phoneNumber", Types.VARCHAR },
			{ "yearOfExp", Types.INTEGER },
			{ "monthOfExp", Types.INTEGER },
			{ "currentCTC", Types.INTEGER },
			{ "expectedCTC", Types.INTEGER },
			{ "currentCompany", Types.VARCHAR },
			{ "noticePeriod", Types.INTEGER },
			{ "referenceEmployeeId", Types.BIGINT },
			{ "cvFileId", Types.BIGINT },
			{ "jobOpeningId", Types.BIGINT },
			{ "skillset", Types.VARCHAR },
			{ "status", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("applyCandidateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("emailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("yearOfExp", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("monthOfExp", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("currentCTC", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("expectedCTC", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("currentCompany", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("noticePeriod", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("referenceEmployeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cvFileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("jobOpeningId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("skillset", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table CandidateApply (applyCandidateId LONG not null primary key,firstName VARCHAR(75) null,lastName VARCHAR(75) null,emailAddress VARCHAR(75) null,phoneNumber VARCHAR(75) null,yearOfExp INTEGER,monthOfExp INTEGER,currentCTC INTEGER,expectedCTC INTEGER,currentCompany VARCHAR(75) null,noticePeriod INTEGER,referenceEmployeeId LONG,cvFileId LONG,jobOpeningId LONG,skillset VARCHAR(75) null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table CandidateApply";
	public static final String ORDER_BY_JPQL = " ORDER BY candidateApply.applyCandidateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CandidateApply.applyCandidateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.CandidateApply"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.CandidateApply"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CandidateApply toModel(CandidateApplySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CandidateApply model = new CandidateApplyImpl();

		model.setApplyCandidateId(soapModel.getApplyCandidateId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setPhoneNumber(soapModel.getPhoneNumber());
		model.setYearOfExp(soapModel.getYearOfExp());
		model.setMonthOfExp(soapModel.getMonthOfExp());
		model.setCurrentCTC(soapModel.getCurrentCTC());
		model.setExpectedCTC(soapModel.getExpectedCTC());
		model.setCurrentCompany(soapModel.getCurrentCompany());
		model.setNoticePeriod(soapModel.getNoticePeriod());
		model.setReferenceEmployeeId(soapModel.getReferenceEmployeeId());
		model.setCvFileId(soapModel.getCvFileId());
		model.setJobOpeningId(soapModel.getJobOpeningId());
		model.setSkillset(soapModel.getSkillset());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CandidateApply> toModels(CandidateApplySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CandidateApply> models = new ArrayList<CandidateApply>(soapModels.length);

		for (CandidateApplySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.CandidateApply"));

	public CandidateApplyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _applyCandidateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplyCandidateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applyCandidateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getApplyCandidateId() {
		return _applyCandidateId;
	}

	@Override
	public void setApplyCandidateId(long applyCandidateId) {
		_applyCandidateId = applyCandidateId;
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
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return "";
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@JSON
	@Override
	public String getPhoneNumber() {
		if (_phoneNumber == null) {
			return "";
		}
		else {
			return _phoneNumber;
		}
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@JSON
	@Override
	public int getYearOfExp() {
		return _yearOfExp;
	}

	@Override
	public void setYearOfExp(int yearOfExp) {
		_yearOfExp = yearOfExp;
	}

	@JSON
	@Override
	public int getMonthOfExp() {
		return _monthOfExp;
	}

	@Override
	public void setMonthOfExp(int monthOfExp) {
		_monthOfExp = monthOfExp;
	}

	@JSON
	@Override
	public int getCurrentCTC() {
		return _currentCTC;
	}

	@Override
	public void setCurrentCTC(int currentCTC) {
		_currentCTC = currentCTC;
	}

	@JSON
	@Override
	public int getExpectedCTC() {
		return _expectedCTC;
	}

	@Override
	public void setExpectedCTC(int expectedCTC) {
		_expectedCTC = expectedCTC;
	}

	@JSON
	@Override
	public String getCurrentCompany() {
		if (_currentCompany == null) {
			return "";
		}
		else {
			return _currentCompany;
		}
	}

	@Override
	public void setCurrentCompany(String currentCompany) {
		_currentCompany = currentCompany;
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
	public long getReferenceEmployeeId() {
		return _referenceEmployeeId;
	}

	@Override
	public void setReferenceEmployeeId(long referenceEmployeeId) {
		_referenceEmployeeId = referenceEmployeeId;
	}

	@JSON
	@Override
	public long getCvFileId() {
		return _cvFileId;
	}

	@Override
	public void setCvFileId(long cvFileId) {
		_cvFileId = cvFileId;
	}

	@JSON
	@Override
	public long getJobOpeningId() {
		return _jobOpeningId;
	}

	@Override
	public void setJobOpeningId(long jobOpeningId) {
		_jobOpeningId = jobOpeningId;
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
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CandidateApply.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CandidateApply toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CandidateApply)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CandidateApplyImpl candidateApplyImpl = new CandidateApplyImpl();

		candidateApplyImpl.setApplyCandidateId(getApplyCandidateId());
		candidateApplyImpl.setFirstName(getFirstName());
		candidateApplyImpl.setLastName(getLastName());
		candidateApplyImpl.setEmailAddress(getEmailAddress());
		candidateApplyImpl.setPhoneNumber(getPhoneNumber());
		candidateApplyImpl.setYearOfExp(getYearOfExp());
		candidateApplyImpl.setMonthOfExp(getMonthOfExp());
		candidateApplyImpl.setCurrentCTC(getCurrentCTC());
		candidateApplyImpl.setExpectedCTC(getExpectedCTC());
		candidateApplyImpl.setCurrentCompany(getCurrentCompany());
		candidateApplyImpl.setNoticePeriod(getNoticePeriod());
		candidateApplyImpl.setReferenceEmployeeId(getReferenceEmployeeId());
		candidateApplyImpl.setCvFileId(getCvFileId());
		candidateApplyImpl.setJobOpeningId(getJobOpeningId());
		candidateApplyImpl.setSkillset(getSkillset());
		candidateApplyImpl.setStatus(getStatus());

		candidateApplyImpl.resetOriginalValues();

		return candidateApplyImpl;
	}

	@Override
	public int compareTo(CandidateApply candidateApply) {
		long primaryKey = candidateApply.getPrimaryKey();

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

		if (!(obj instanceof CandidateApply)) {
			return false;
		}

		CandidateApply candidateApply = (CandidateApply)obj;

		long primaryKey = candidateApply.getPrimaryKey();

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
	}

	@Override
	public CacheModel<CandidateApply> toCacheModel() {
		CandidateApplyCacheModel candidateApplyCacheModel = new CandidateApplyCacheModel();

		candidateApplyCacheModel.applyCandidateId = getApplyCandidateId();

		candidateApplyCacheModel.firstName = getFirstName();

		String firstName = candidateApplyCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			candidateApplyCacheModel.firstName = null;
		}

		candidateApplyCacheModel.lastName = getLastName();

		String lastName = candidateApplyCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			candidateApplyCacheModel.lastName = null;
		}

		candidateApplyCacheModel.emailAddress = getEmailAddress();

		String emailAddress = candidateApplyCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			candidateApplyCacheModel.emailAddress = null;
		}

		candidateApplyCacheModel.phoneNumber = getPhoneNumber();

		String phoneNumber = candidateApplyCacheModel.phoneNumber;

		if ((phoneNumber != null) && (phoneNumber.length() == 0)) {
			candidateApplyCacheModel.phoneNumber = null;
		}

		candidateApplyCacheModel.yearOfExp = getYearOfExp();

		candidateApplyCacheModel.monthOfExp = getMonthOfExp();

		candidateApplyCacheModel.currentCTC = getCurrentCTC();

		candidateApplyCacheModel.expectedCTC = getExpectedCTC();

		candidateApplyCacheModel.currentCompany = getCurrentCompany();

		String currentCompany = candidateApplyCacheModel.currentCompany;

		if ((currentCompany != null) && (currentCompany.length() == 0)) {
			candidateApplyCacheModel.currentCompany = null;
		}

		candidateApplyCacheModel.noticePeriod = getNoticePeriod();

		candidateApplyCacheModel.referenceEmployeeId = getReferenceEmployeeId();

		candidateApplyCacheModel.cvFileId = getCvFileId();

		candidateApplyCacheModel.jobOpeningId = getJobOpeningId();

		candidateApplyCacheModel.skillset = getSkillset();

		String skillset = candidateApplyCacheModel.skillset;

		if ((skillset != null) && (skillset.length() == 0)) {
			candidateApplyCacheModel.skillset = null;
		}

		candidateApplyCacheModel.status = getStatus();

		return candidateApplyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{applyCandidateId=");
		sb.append(getApplyCandidateId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", yearOfExp=");
		sb.append(getYearOfExp());
		sb.append(", monthOfExp=");
		sb.append(getMonthOfExp());
		sb.append(", currentCTC=");
		sb.append(getCurrentCTC());
		sb.append(", expectedCTC=");
		sb.append(getExpectedCTC());
		sb.append(", currentCompany=");
		sb.append(getCurrentCompany());
		sb.append(", noticePeriod=");
		sb.append(getNoticePeriod());
		sb.append(", referenceEmployeeId=");
		sb.append(getReferenceEmployeeId());
		sb.append(", cvFileId=");
		sb.append(getCvFileId());
		sb.append(", jobOpeningId=");
		sb.append(getJobOpeningId());
		sb.append(", skillset=");
		sb.append(getSkillset());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.CandidateApply");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applyCandidateId</column-name><column-value><![CDATA[");
		sb.append(getApplyCandidateId());
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
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearOfExp</column-name><column-value><![CDATA[");
		sb.append(getYearOfExp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthOfExp</column-name><column-value><![CDATA[");
		sb.append(getMonthOfExp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCTC</column-name><column-value><![CDATA[");
		sb.append(getCurrentCTC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedCTC</column-name><column-value><![CDATA[");
		sb.append(getExpectedCTC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentCompany</column-name><column-value><![CDATA[");
		sb.append(getCurrentCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noticePeriod</column-name><column-value><![CDATA[");
		sb.append(getNoticePeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceEmployeeId</column-name><column-value><![CDATA[");
		sb.append(getReferenceEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cvFileId</column-name><column-value><![CDATA[");
		sb.append(getCvFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobOpeningId</column-name><column-value><![CDATA[");
		sb.append(getJobOpeningId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skillset</column-name><column-value><![CDATA[");
		sb.append(getSkillset());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CandidateApply.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CandidateApply.class, ModelWrapper.class
		};
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
	private CandidateApply _escapedModel;
}