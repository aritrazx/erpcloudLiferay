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

import com.liferay.famocom.erpcloud.model.NotificationSendManage;
import com.liferay.famocom.erpcloud.model.NotificationSendManageModel;
import com.liferay.famocom.erpcloud.model.NotificationSendManageSoap;

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
 * The base model implementation for the NotificationSendManage service. Represents a row in the &quot;notificationSendManage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link NotificationSendManageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NotificationSendManageImpl}.
 * </p>
 *
 * @author Samaresh
 * @see NotificationSendManageImpl
 * @see NotificationSendManage
 * @see NotificationSendManageModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class NotificationSendManageModelImpl extends BaseModelImpl<NotificationSendManage>
	implements NotificationSendManageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notification send manage model instance should use the {@link NotificationSendManage} interface instead.
	 */
	public static final String TABLE_NAME = "notificationSendManage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "notifyIdSendId", Types.BIGINT },
			{ "notificationId", Types.BIGINT },
			{ "branchId", Types.BIGINT },
			{ "sendingDate", Types.TIMESTAMP },
			{ "sendBy", Types.VARCHAR },
			{ "isOpen", Types.BOOLEAN },
			{ "openBy", Types.VARCHAR },
			{ "documentId", Types.BIGINT },
			{ "isApproved", Types.INTEGER },
			{ "comment_", Types.VARCHAR },
			{ "documentUrl", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("notifyIdSendId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("notificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("branchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sendingDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("sendBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isOpen", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("openBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("documentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("isApproved", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("comment_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("documentUrl", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table notificationSendManage (notifyIdSendId LONG not null primary key,notificationId LONG,branchId LONG,sendingDate DATE null,sendBy VARCHAR(75) null,isOpen BOOLEAN,openBy VARCHAR(75) null,documentId LONG,isApproved INTEGER,comment_ VARCHAR(75) null,documentUrl VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table notificationSendManage";
	public static final String ORDER_BY_JPQL = " ORDER BY notificationSendManage.notifyIdSendId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY notificationSendManage.notifyIdSendId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.NotificationSendManage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.NotificationSendManage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.famocom.erpcloud.model.NotificationSendManage"),
			true);
	public static final long BRANCHID_COLUMN_BITMASK = 1L;
	public static final long NOTIFICATIONID_COLUMN_BITMASK = 2L;
	public static final long NOTIFYIDSENDID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static NotificationSendManage toModel(
		NotificationSendManageSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		NotificationSendManage model = new NotificationSendManageImpl();

		model.setNotifyIdSendId(soapModel.getNotifyIdSendId());
		model.setNotificationId(soapModel.getNotificationId());
		model.setBranchId(soapModel.getBranchId());
		model.setSendingDate(soapModel.getSendingDate());
		model.setSendBy(soapModel.getSendBy());
		model.setIsOpen(soapModel.isIsOpen());
		model.setOpenBy(soapModel.getOpenBy());
		model.setDocumentId(soapModel.getDocumentId());
		model.setIsApproved(soapModel.getIsApproved());
		model.setComment(soapModel.getComment());
		model.setDocumentUrl(soapModel.getDocumentUrl());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<NotificationSendManage> toModels(
		NotificationSendManageSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<NotificationSendManage> models = new ArrayList<NotificationSendManage>(soapModels.length);

		for (NotificationSendManageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.NotificationSendManage"));

	public NotificationSendManageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _notifyIdSendId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotifyIdSendId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notifyIdSendId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NotificationSendManage.class;
	}

	@Override
	public String getModelClassName() {
		return NotificationSendManage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notifyIdSendId", getNotifyIdSendId());
		attributes.put("notificationId", getNotificationId());
		attributes.put("branchId", getBranchId());
		attributes.put("sendingDate", getSendingDate());
		attributes.put("sendBy", getSendBy());
		attributes.put("isOpen", isIsOpen());
		attributes.put("openBy", getOpenBy());
		attributes.put("documentId", getDocumentId());
		attributes.put("isApproved", getIsApproved());
		attributes.put("comment", getComment());
		attributes.put("documentUrl", getDocumentUrl());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notifyIdSendId = (Long)attributes.get("notifyIdSendId");

		if (notifyIdSendId != null) {
			setNotifyIdSendId(notifyIdSendId);
		}

		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		Long branchId = (Long)attributes.get("branchId");

		if (branchId != null) {
			setBranchId(branchId);
		}

		Date sendingDate = (Date)attributes.get("sendingDate");

		if (sendingDate != null) {
			setSendingDate(sendingDate);
		}

		String sendBy = (String)attributes.get("sendBy");

		if (sendBy != null) {
			setSendBy(sendBy);
		}

		Boolean isOpen = (Boolean)attributes.get("isOpen");

		if (isOpen != null) {
			setIsOpen(isOpen);
		}

		String openBy = (String)attributes.get("openBy");

		if (openBy != null) {
			setOpenBy(openBy);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Integer isApproved = (Integer)attributes.get("isApproved");

		if (isApproved != null) {
			setIsApproved(isApproved);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String documentUrl = (String)attributes.get("documentUrl");

		if (documentUrl != null) {
			setDocumentUrl(documentUrl);
		}
	}

	@JSON
	@Override
	public long getNotifyIdSendId() {
		return _notifyIdSendId;
	}

	@Override
	public void setNotifyIdSendId(long notifyIdSendId) {
		_notifyIdSendId = notifyIdSendId;
	}

	@JSON
	@Override
	public long getNotificationId() {
		return _notificationId;
	}

	@Override
	public void setNotificationId(long notificationId) {
		_columnBitmask |= NOTIFICATIONID_COLUMN_BITMASK;

		if (!_setOriginalNotificationId) {
			_setOriginalNotificationId = true;

			_originalNotificationId = _notificationId;
		}

		_notificationId = notificationId;
	}

	public long getOriginalNotificationId() {
		return _originalNotificationId;
	}

	@JSON
	@Override
	public long getBranchId() {
		return _branchId;
	}

	@Override
	public void setBranchId(long branchId) {
		_columnBitmask |= BRANCHID_COLUMN_BITMASK;

		if (!_setOriginalBranchId) {
			_setOriginalBranchId = true;

			_originalBranchId = _branchId;
		}

		_branchId = branchId;
	}

	public long getOriginalBranchId() {
		return _originalBranchId;
	}

	@JSON
	@Override
	public Date getSendingDate() {
		return _sendingDate;
	}

	@Override
	public void setSendingDate(Date sendingDate) {
		_sendingDate = sendingDate;
	}

	@JSON
	@Override
	public String getSendBy() {
		if (_sendBy == null) {
			return "";
		}
		else {
			return _sendBy;
		}
	}

	@Override
	public void setSendBy(String sendBy) {
		_sendBy = sendBy;
	}

	@JSON
	@Override
	public boolean getIsOpen() {
		return _isOpen;
	}

	@JSON
	@Override
	public boolean isIsOpen() {
		return _isOpen;
	}

	@Override
	public void setIsOpen(boolean isOpen) {
		_isOpen = isOpen;
	}

	@JSON
	@Override
	public String getOpenBy() {
		if (_openBy == null) {
			return "";
		}
		else {
			return _openBy;
		}
	}

	@Override
	public void setOpenBy(String openBy) {
		_openBy = openBy;
	}

	@JSON
	@Override
	public long getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	@JSON
	@Override
	public int getIsApproved() {
		return _isApproved;
	}

	@Override
	public void setIsApproved(int isApproved) {
		_isApproved = isApproved;
	}

	@JSON
	@Override
	public String getComment() {
		if (_comment == null) {
			return "";
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;
	}

	@JSON
	@Override
	public String getDocumentUrl() {
		if (_documentUrl == null) {
			return "";
		}
		else {
			return _documentUrl;
		}
	}

	@Override
	public void setDocumentUrl(String documentUrl) {
		_documentUrl = documentUrl;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NotificationSendManage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NotificationSendManage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NotificationSendManage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NotificationSendManageImpl notificationSendManageImpl = new NotificationSendManageImpl();

		notificationSendManageImpl.setNotifyIdSendId(getNotifyIdSendId());
		notificationSendManageImpl.setNotificationId(getNotificationId());
		notificationSendManageImpl.setBranchId(getBranchId());
		notificationSendManageImpl.setSendingDate(getSendingDate());
		notificationSendManageImpl.setSendBy(getSendBy());
		notificationSendManageImpl.setIsOpen(isIsOpen());
		notificationSendManageImpl.setOpenBy(getOpenBy());
		notificationSendManageImpl.setDocumentId(getDocumentId());
		notificationSendManageImpl.setIsApproved(getIsApproved());
		notificationSendManageImpl.setComment(getComment());
		notificationSendManageImpl.setDocumentUrl(getDocumentUrl());

		notificationSendManageImpl.resetOriginalValues();

		return notificationSendManageImpl;
	}

	@Override
	public int compareTo(NotificationSendManage notificationSendManage) {
		long primaryKey = notificationSendManage.getPrimaryKey();

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

		if (!(obj instanceof NotificationSendManage)) {
			return false;
		}

		NotificationSendManage notificationSendManage = (NotificationSendManage)obj;

		long primaryKey = notificationSendManage.getPrimaryKey();

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
		NotificationSendManageModelImpl notificationSendManageModelImpl = this;

		notificationSendManageModelImpl._originalNotificationId = notificationSendManageModelImpl._notificationId;

		notificationSendManageModelImpl._setOriginalNotificationId = false;

		notificationSendManageModelImpl._originalBranchId = notificationSendManageModelImpl._branchId;

		notificationSendManageModelImpl._setOriginalBranchId = false;

		notificationSendManageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<NotificationSendManage> toCacheModel() {
		NotificationSendManageCacheModel notificationSendManageCacheModel = new NotificationSendManageCacheModel();

		notificationSendManageCacheModel.notifyIdSendId = getNotifyIdSendId();

		notificationSendManageCacheModel.notificationId = getNotificationId();

		notificationSendManageCacheModel.branchId = getBranchId();

		Date sendingDate = getSendingDate();

		if (sendingDate != null) {
			notificationSendManageCacheModel.sendingDate = sendingDate.getTime();
		}
		else {
			notificationSendManageCacheModel.sendingDate = Long.MIN_VALUE;
		}

		notificationSendManageCacheModel.sendBy = getSendBy();

		String sendBy = notificationSendManageCacheModel.sendBy;

		if ((sendBy != null) && (sendBy.length() == 0)) {
			notificationSendManageCacheModel.sendBy = null;
		}

		notificationSendManageCacheModel.isOpen = isIsOpen();

		notificationSendManageCacheModel.openBy = getOpenBy();

		String openBy = notificationSendManageCacheModel.openBy;

		if ((openBy != null) && (openBy.length() == 0)) {
			notificationSendManageCacheModel.openBy = null;
		}

		notificationSendManageCacheModel.documentId = getDocumentId();

		notificationSendManageCacheModel.isApproved = getIsApproved();

		notificationSendManageCacheModel.comment = getComment();

		String comment = notificationSendManageCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			notificationSendManageCacheModel.comment = null;
		}

		notificationSendManageCacheModel.documentUrl = getDocumentUrl();

		String documentUrl = notificationSendManageCacheModel.documentUrl;

		if ((documentUrl != null) && (documentUrl.length() == 0)) {
			notificationSendManageCacheModel.documentUrl = null;
		}

		return notificationSendManageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{notifyIdSendId=");
		sb.append(getNotifyIdSendId());
		sb.append(", notificationId=");
		sb.append(getNotificationId());
		sb.append(", branchId=");
		sb.append(getBranchId());
		sb.append(", sendingDate=");
		sb.append(getSendingDate());
		sb.append(", sendBy=");
		sb.append(getSendBy());
		sb.append(", isOpen=");
		sb.append(isIsOpen());
		sb.append(", openBy=");
		sb.append(getOpenBy());
		sb.append(", documentId=");
		sb.append(getDocumentId());
		sb.append(", isApproved=");
		sb.append(getIsApproved());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", documentUrl=");
		sb.append(getDocumentUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.NotificationSendManage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notifyIdSendId</column-name><column-value><![CDATA[");
		sb.append(getNotifyIdSendId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationId</column-name><column-value><![CDATA[");
		sb.append(getNotificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>branchId</column-name><column-value><![CDATA[");
		sb.append(getBranchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendingDate</column-name><column-value><![CDATA[");
		sb.append(getSendingDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendBy</column-name><column-value><![CDATA[");
		sb.append(getSendBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isOpen</column-name><column-value><![CDATA[");
		sb.append(isIsOpen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openBy</column-name><column-value><![CDATA[");
		sb.append(getOpenBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproved</column-name><column-value><![CDATA[");
		sb.append(getIsApproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentUrl</column-name><column-value><![CDATA[");
		sb.append(getDocumentUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = NotificationSendManage.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			NotificationSendManage.class, ModelWrapper.class
		};
	private long _notifyIdSendId;
	private long _notificationId;
	private long _originalNotificationId;
	private boolean _setOriginalNotificationId;
	private long _branchId;
	private long _originalBranchId;
	private boolean _setOriginalBranchId;
	private Date _sendingDate;
	private String _sendBy;
	private boolean _isOpen;
	private String _openBy;
	private long _documentId;
	private int _isApproved;
	private String _comment;
	private String _documentUrl;
	private long _columnBitmask;
	private NotificationSendManage _escapedModel;
}