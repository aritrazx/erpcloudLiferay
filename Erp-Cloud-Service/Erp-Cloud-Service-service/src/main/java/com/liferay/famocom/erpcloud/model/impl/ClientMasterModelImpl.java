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

import com.liferay.famocom.erpcloud.model.ClientMaster;
import com.liferay.famocom.erpcloud.model.ClientMasterModel;
import com.liferay.famocom.erpcloud.model.ClientMasterSoap;

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
 * The base model implementation for the ClientMaster service. Represents a row in the &quot;clientMaster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ClientMasterModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ClientMasterImpl}.
 * </p>
 *
 * @author Samaresh
 * @see ClientMasterImpl
 * @see ClientMaster
 * @see ClientMasterModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ClientMasterModelImpl extends BaseModelImpl<ClientMaster>
	implements ClientMasterModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a client master model instance should use the {@link ClientMaster} interface instead.
	 */
	public static final String TABLE_NAME = "clientMaster";
	public static final Object[][] TABLE_COLUMNS = {
			{ "clientId", Types.BIGINT },
			{ "clientName", Types.VARCHAR },
			{ "officeAddress", Types.VARCHAR },
			{ "billingAddress", Types.VARCHAR },
			{ "contactNumber", Types.INTEGER },
			{ "emailId", Types.VARCHAR },
			{ "contactPerson", Types.VARCHAR },
			{ "skypeId", Types.VARCHAR },
			{ "gstNo", Types.BIGINT },
			{ "panNo", Types.VARCHAR },
			{ "bankName", Types.VARCHAR },
			{ "branchName", Types.VARCHAR },
			{ "bankAccountNumber", Types.BIGINT },
			{ "bankAccountType", Types.VARCHAR },
			{ "ifscCode", Types.VARCHAR },
			{ "addedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("clientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("clientName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officeAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("billingAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("emailId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPerson", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("skypeId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gstNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("panNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bankName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("branchName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bankAccountNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("bankAccountType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ifscCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table clientMaster (clientId LONG not null primary key,clientName VARCHAR(75) null,officeAddress VARCHAR(75) null,billingAddress VARCHAR(75) null,contactNumber INTEGER,emailId VARCHAR(75) null,contactPerson VARCHAR(75) null,skypeId VARCHAR(75) null,gstNo LONG,panNo VARCHAR(75) null,bankName VARCHAR(75) null,branchName VARCHAR(75) null,bankAccountNumber LONG,bankAccountType VARCHAR(75) null,ifscCode VARCHAR(75) null,addedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table clientMaster";
	public static final String ORDER_BY_JPQL = " ORDER BY clientMaster.clientId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY clientMaster.clientId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.ClientMaster"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.ClientMaster"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ClientMaster toModel(ClientMasterSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ClientMaster model = new ClientMasterImpl();

		model.setClientId(soapModel.getClientId());
		model.setClientName(soapModel.getClientName());
		model.setOfficeAddress(soapModel.getOfficeAddress());
		model.setBillingAddress(soapModel.getBillingAddress());
		model.setContactNumber(soapModel.getContactNumber());
		model.setEmailId(soapModel.getEmailId());
		model.setContactPerson(soapModel.getContactPerson());
		model.setSkypeId(soapModel.getSkypeId());
		model.setGstNo(soapModel.getGstNo());
		model.setPanNo(soapModel.getPanNo());
		model.setBankName(soapModel.getBankName());
		model.setBranchName(soapModel.getBranchName());
		model.setBankAccountNumber(soapModel.getBankAccountNumber());
		model.setBankAccountType(soapModel.getBankAccountType());
		model.setIfscCode(soapModel.getIfscCode());
		model.setAddedDate(soapModel.getAddedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ClientMaster> toModels(ClientMasterSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ClientMaster> models = new ArrayList<ClientMaster>(soapModels.length);

		for (ClientMasterSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.ClientMaster"));

	public ClientMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _clientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _clientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ClientMaster.class;
	}

	@Override
	public String getModelClassName() {
		return ClientMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientId", getClientId());
		attributes.put("clientName", getClientName());
		attributes.put("officeAddress", getOfficeAddress());
		attributes.put("billingAddress", getBillingAddress());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("emailId", getEmailId());
		attributes.put("contactPerson", getContactPerson());
		attributes.put("skypeId", getSkypeId());
		attributes.put("gstNo", getGstNo());
		attributes.put("panNo", getPanNo());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
		attributes.put("bankAccountNumber", getBankAccountNumber());
		attributes.put("bankAccountType", getBankAccountType());
		attributes.put("ifscCode", getIfscCode());
		attributes.put("addedDate", getAddedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String officeAddress = (String)attributes.get("officeAddress");

		if (officeAddress != null) {
			setOfficeAddress(officeAddress);
		}

		String billingAddress = (String)attributes.get("billingAddress");

		if (billingAddress != null) {
			setBillingAddress(billingAddress);
		}

		Integer contactNumber = (Integer)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String contactPerson = (String)attributes.get("contactPerson");

		if (contactPerson != null) {
			setContactPerson(contactPerson);
		}

		String skypeId = (String)attributes.get("skypeId");

		if (skypeId != null) {
			setSkypeId(skypeId);
		}

		Long gstNo = (Long)attributes.get("gstNo");

		if (gstNo != null) {
			setGstNo(gstNo);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		Long bankAccountNumber = (Long)attributes.get("bankAccountNumber");

		if (bankAccountNumber != null) {
			setBankAccountNumber(bankAccountNumber);
		}

		String bankAccountType = (String)attributes.get("bankAccountType");

		if (bankAccountType != null) {
			setBankAccountType(bankAccountType);
		}

		String ifscCode = (String)attributes.get("ifscCode");

		if (ifscCode != null) {
			setIfscCode(ifscCode);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@JSON
	@Override
	public long getClientId() {
		return _clientId;
	}

	@Override
	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	@JSON
	@Override
	public String getClientName() {
		if (_clientName == null) {
			return "";
		}
		else {
			return _clientName;
		}
	}

	@Override
	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	@JSON
	@Override
	public String getOfficeAddress() {
		if (_officeAddress == null) {
			return "";
		}
		else {
			return _officeAddress;
		}
	}

	@Override
	public void setOfficeAddress(String officeAddress) {
		_officeAddress = officeAddress;
	}

	@JSON
	@Override
	public String getBillingAddress() {
		if (_billingAddress == null) {
			return "";
		}
		else {
			return _billingAddress;
		}
	}

	@Override
	public void setBillingAddress(String billingAddress) {
		_billingAddress = billingAddress;
	}

	@JSON
	@Override
	public int getContactNumber() {
		return _contactNumber;
	}

	@Override
	public void setContactNumber(int contactNumber) {
		_contactNumber = contactNumber;
	}

	@JSON
	@Override
	public String getEmailId() {
		if (_emailId == null) {
			return "";
		}
		else {
			return _emailId;
		}
	}

	@Override
	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	@JSON
	@Override
	public String getContactPerson() {
		if (_contactPerson == null) {
			return "";
		}
		else {
			return _contactPerson;
		}
	}

	@Override
	public void setContactPerson(String contactPerson) {
		_contactPerson = contactPerson;
	}

	@JSON
	@Override
	public String getSkypeId() {
		if (_skypeId == null) {
			return "";
		}
		else {
			return _skypeId;
		}
	}

	@Override
	public void setSkypeId(String skypeId) {
		_skypeId = skypeId;
	}

	@JSON
	@Override
	public long getGstNo() {
		return _gstNo;
	}

	@Override
	public void setGstNo(long gstNo) {
		_gstNo = gstNo;
	}

	@JSON
	@Override
	public String getPanNo() {
		if (_panNo == null) {
			return "";
		}
		else {
			return _panNo;
		}
	}

	@Override
	public void setPanNo(String panNo) {
		_panNo = panNo;
	}

	@JSON
	@Override
	public String getBankName() {
		if (_bankName == null) {
			return "";
		}
		else {
			return _bankName;
		}
	}

	@Override
	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	@JSON
	@Override
	public String getBranchName() {
		if (_branchName == null) {
			return "";
		}
		else {
			return _branchName;
		}
	}

	@Override
	public void setBranchName(String branchName) {
		_branchName = branchName;
	}

	@JSON
	@Override
	public long getBankAccountNumber() {
		return _bankAccountNumber;
	}

	@Override
	public void setBankAccountNumber(long bankAccountNumber) {
		_bankAccountNumber = bankAccountNumber;
	}

	@JSON
	@Override
	public String getBankAccountType() {
		if (_bankAccountType == null) {
			return "";
		}
		else {
			return _bankAccountType;
		}
	}

	@Override
	public void setBankAccountType(String bankAccountType) {
		_bankAccountType = bankAccountType;
	}

	@JSON
	@Override
	public String getIfscCode() {
		if (_ifscCode == null) {
			return "";
		}
		else {
			return _ifscCode;
		}
	}

	@Override
	public void setIfscCode(String ifscCode) {
		_ifscCode = ifscCode;
	}

	@JSON
	@Override
	public Date getAddedDate() {
		return _addedDate;
	}

	@Override
	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ClientMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ClientMaster toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ClientMaster)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ClientMasterImpl clientMasterImpl = new ClientMasterImpl();

		clientMasterImpl.setClientId(getClientId());
		clientMasterImpl.setClientName(getClientName());
		clientMasterImpl.setOfficeAddress(getOfficeAddress());
		clientMasterImpl.setBillingAddress(getBillingAddress());
		clientMasterImpl.setContactNumber(getContactNumber());
		clientMasterImpl.setEmailId(getEmailId());
		clientMasterImpl.setContactPerson(getContactPerson());
		clientMasterImpl.setSkypeId(getSkypeId());
		clientMasterImpl.setGstNo(getGstNo());
		clientMasterImpl.setPanNo(getPanNo());
		clientMasterImpl.setBankName(getBankName());
		clientMasterImpl.setBranchName(getBranchName());
		clientMasterImpl.setBankAccountNumber(getBankAccountNumber());
		clientMasterImpl.setBankAccountType(getBankAccountType());
		clientMasterImpl.setIfscCode(getIfscCode());
		clientMasterImpl.setAddedDate(getAddedDate());

		clientMasterImpl.resetOriginalValues();

		return clientMasterImpl;
	}

	@Override
	public int compareTo(ClientMaster clientMaster) {
		long primaryKey = clientMaster.getPrimaryKey();

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

		if (!(obj instanceof ClientMaster)) {
			return false;
		}

		ClientMaster clientMaster = (ClientMaster)obj;

		long primaryKey = clientMaster.getPrimaryKey();

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
	public CacheModel<ClientMaster> toCacheModel() {
		ClientMasterCacheModel clientMasterCacheModel = new ClientMasterCacheModel();

		clientMasterCacheModel.clientId = getClientId();

		clientMasterCacheModel.clientName = getClientName();

		String clientName = clientMasterCacheModel.clientName;

		if ((clientName != null) && (clientName.length() == 0)) {
			clientMasterCacheModel.clientName = null;
		}

		clientMasterCacheModel.officeAddress = getOfficeAddress();

		String officeAddress = clientMasterCacheModel.officeAddress;

		if ((officeAddress != null) && (officeAddress.length() == 0)) {
			clientMasterCacheModel.officeAddress = null;
		}

		clientMasterCacheModel.billingAddress = getBillingAddress();

		String billingAddress = clientMasterCacheModel.billingAddress;

		if ((billingAddress != null) && (billingAddress.length() == 0)) {
			clientMasterCacheModel.billingAddress = null;
		}

		clientMasterCacheModel.contactNumber = getContactNumber();

		clientMasterCacheModel.emailId = getEmailId();

		String emailId = clientMasterCacheModel.emailId;

		if ((emailId != null) && (emailId.length() == 0)) {
			clientMasterCacheModel.emailId = null;
		}

		clientMasterCacheModel.contactPerson = getContactPerson();

		String contactPerson = clientMasterCacheModel.contactPerson;

		if ((contactPerson != null) && (contactPerson.length() == 0)) {
			clientMasterCacheModel.contactPerson = null;
		}

		clientMasterCacheModel.skypeId = getSkypeId();

		String skypeId = clientMasterCacheModel.skypeId;

		if ((skypeId != null) && (skypeId.length() == 0)) {
			clientMasterCacheModel.skypeId = null;
		}

		clientMasterCacheModel.gstNo = getGstNo();

		clientMasterCacheModel.panNo = getPanNo();

		String panNo = clientMasterCacheModel.panNo;

		if ((panNo != null) && (panNo.length() == 0)) {
			clientMasterCacheModel.panNo = null;
		}

		clientMasterCacheModel.bankName = getBankName();

		String bankName = clientMasterCacheModel.bankName;

		if ((bankName != null) && (bankName.length() == 0)) {
			clientMasterCacheModel.bankName = null;
		}

		clientMasterCacheModel.branchName = getBranchName();

		String branchName = clientMasterCacheModel.branchName;

		if ((branchName != null) && (branchName.length() == 0)) {
			clientMasterCacheModel.branchName = null;
		}

		clientMasterCacheModel.bankAccountNumber = getBankAccountNumber();

		clientMasterCacheModel.bankAccountType = getBankAccountType();

		String bankAccountType = clientMasterCacheModel.bankAccountType;

		if ((bankAccountType != null) && (bankAccountType.length() == 0)) {
			clientMasterCacheModel.bankAccountType = null;
		}

		clientMasterCacheModel.ifscCode = getIfscCode();

		String ifscCode = clientMasterCacheModel.ifscCode;

		if ((ifscCode != null) && (ifscCode.length() == 0)) {
			clientMasterCacheModel.ifscCode = null;
		}

		Date addedDate = getAddedDate();

		if (addedDate != null) {
			clientMasterCacheModel.addedDate = addedDate.getTime();
		}
		else {
			clientMasterCacheModel.addedDate = Long.MIN_VALUE;
		}

		return clientMasterCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{clientId=");
		sb.append(getClientId());
		sb.append(", clientName=");
		sb.append(getClientName());
		sb.append(", officeAddress=");
		sb.append(getOfficeAddress());
		sb.append(", billingAddress=");
		sb.append(getBillingAddress());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", emailId=");
		sb.append(getEmailId());
		sb.append(", contactPerson=");
		sb.append(getContactPerson());
		sb.append(", skypeId=");
		sb.append(getSkypeId());
		sb.append(", gstNo=");
		sb.append(getGstNo());
		sb.append(", panNo=");
		sb.append(getPanNo());
		sb.append(", bankName=");
		sb.append(getBankName());
		sb.append(", branchName=");
		sb.append(getBranchName());
		sb.append(", bankAccountNumber=");
		sb.append(getBankAccountNumber());
		sb.append(", bankAccountType=");
		sb.append(getBankAccountType());
		sb.append(", ifscCode=");
		sb.append(getIfscCode());
		sb.append(", addedDate=");
		sb.append(getAddedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.ClientMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>clientId</column-name><column-value><![CDATA[");
		sb.append(getClientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientName</column-name><column-value><![CDATA[");
		sb.append(getClientName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeAddress</column-name><column-value><![CDATA[");
		sb.append(getOfficeAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingAddress</column-name><column-value><![CDATA[");
		sb.append(getBillingAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailId</column-name><column-value><![CDATA[");
		sb.append(getEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPerson</column-name><column-value><![CDATA[");
		sb.append(getContactPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skypeId</column-name><column-value><![CDATA[");
		sb.append(getSkypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gstNo</column-name><column-value><![CDATA[");
		sb.append(getGstNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>panNo</column-name><column-value><![CDATA[");
		sb.append(getPanNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankName</column-name><column-value><![CDATA[");
		sb.append(getBankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>branchName</column-name><column-value><![CDATA[");
		sb.append(getBranchName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankAccountNumber</column-name><column-value><![CDATA[");
		sb.append(getBankAccountNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankAccountType</column-name><column-value><![CDATA[");
		sb.append(getBankAccountType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ifscCode</column-name><column-value><![CDATA[");
		sb.append(getIfscCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addedDate</column-name><column-value><![CDATA[");
		sb.append(getAddedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ClientMaster.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ClientMaster.class, ModelWrapper.class
		};
	private long _clientId;
	private String _clientName;
	private String _officeAddress;
	private String _billingAddress;
	private int _contactNumber;
	private String _emailId;
	private String _contactPerson;
	private String _skypeId;
	private long _gstNo;
	private String _panNo;
	private String _bankName;
	private String _branchName;
	private long _bankAccountNumber;
	private String _bankAccountType;
	private String _ifscCode;
	private Date _addedDate;
	private ClientMaster _escapedModel;
}