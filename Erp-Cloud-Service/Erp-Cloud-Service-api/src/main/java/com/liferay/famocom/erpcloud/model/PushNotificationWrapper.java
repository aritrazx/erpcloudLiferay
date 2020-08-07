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
 * This class is a wrapper for {@link PushNotification}.
 * </p>
 *
 * @author Samaresh
 * @see PushNotification
 * @generated
 */
@ProviderType
public class PushNotificationWrapper implements PushNotification,
	ModelWrapper<PushNotification> {
	public PushNotificationWrapper(PushNotification pushNotification) {
		_pushNotification = pushNotification;
	}

	@Override
	public Class<?> getModelClass() {
		return PushNotification.class;
	}

	@Override
	public String getModelClassName() {
		return PushNotification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pushNotificationId", getPushNotificationId());
		attributes.put("subject", getSubject());
		attributes.put("message", getMessage());
		attributes.put("fileId", getFileId());
		attributes.put("fileUrl", getFileUrl());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pushNotificationId = (Long)attributes.get("pushNotificationId");

		if (pushNotificationId != null) {
			setPushNotificationId(pushNotificationId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
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
	}

	@Override
	public Object clone() {
		return new PushNotificationWrapper((PushNotification)_pushNotification.clone());
	}

	@Override
	public int compareTo(PushNotification pushNotification) {
		return _pushNotification.compareTo(pushNotification);
	}

	/**
	* Returns the create date of this push notification.
	*
	* @return the create date of this push notification
	*/
	@Override
	public Date getCreateDate() {
		return _pushNotification.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pushNotification.getExpandoBridge();
	}

	/**
	* Returns the file ID of this push notification.
	*
	* @return the file ID of this push notification
	*/
	@Override
	public long getFileId() {
		return _pushNotification.getFileId();
	}

	/**
	* Returns the file url of this push notification.
	*
	* @return the file url of this push notification
	*/
	@Override
	public String getFileUrl() {
		return _pushNotification.getFileUrl();
	}

	/**
	* Returns the message of this push notification.
	*
	* @return the message of this push notification
	*/
	@Override
	public String getMessage() {
		return _pushNotification.getMessage();
	}

	/**
	* Returns the modified date of this push notification.
	*
	* @return the modified date of this push notification
	*/
	@Override
	public Date getModifiedDate() {
		return _pushNotification.getModifiedDate();
	}

	/**
	* Returns the primary key of this push notification.
	*
	* @return the primary key of this push notification
	*/
	@Override
	public long getPrimaryKey() {
		return _pushNotification.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pushNotification.getPrimaryKeyObj();
	}

	/**
	* Returns the push notification ID of this push notification.
	*
	* @return the push notification ID of this push notification
	*/
	@Override
	public long getPushNotificationId() {
		return _pushNotification.getPushNotificationId();
	}

	/**
	* Returns the subject of this push notification.
	*
	* @return the subject of this push notification
	*/
	@Override
	public String getSubject() {
		return _pushNotification.getSubject();
	}

	@Override
	public int hashCode() {
		return _pushNotification.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _pushNotification.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pushNotification.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pushNotification.isNew();
	}

	@Override
	public void persist() {
		_pushNotification.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pushNotification.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this push notification.
	*
	* @param createDate the create date of this push notification
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_pushNotification.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pushNotification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pushNotification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pushNotification.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file ID of this push notification.
	*
	* @param fileId the file ID of this push notification
	*/
	@Override
	public void setFileId(long fileId) {
		_pushNotification.setFileId(fileId);
	}

	/**
	* Sets the file url of this push notification.
	*
	* @param fileUrl the file url of this push notification
	*/
	@Override
	public void setFileUrl(String fileUrl) {
		_pushNotification.setFileUrl(fileUrl);
	}

	/**
	* Sets the message of this push notification.
	*
	* @param message the message of this push notification
	*/
	@Override
	public void setMessage(String message) {
		_pushNotification.setMessage(message);
	}

	/**
	* Sets the modified date of this push notification.
	*
	* @param modifiedDate the modified date of this push notification
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_pushNotification.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_pushNotification.setNew(n);
	}

	/**
	* Sets the primary key of this push notification.
	*
	* @param primaryKey the primary key of this push notification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pushNotification.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pushNotification.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the push notification ID of this push notification.
	*
	* @param pushNotificationId the push notification ID of this push notification
	*/
	@Override
	public void setPushNotificationId(long pushNotificationId) {
		_pushNotification.setPushNotificationId(pushNotificationId);
	}

	/**
	* Sets the subject of this push notification.
	*
	* @param subject the subject of this push notification
	*/
	@Override
	public void setSubject(String subject) {
		_pushNotification.setSubject(subject);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PushNotification> toCacheModel() {
		return _pushNotification.toCacheModel();
	}

	@Override
	public PushNotification toEscapedModel() {
		return new PushNotificationWrapper(_pushNotification.toEscapedModel());
	}

	@Override
	public String toString() {
		return _pushNotification.toString();
	}

	@Override
	public PushNotification toUnescapedModel() {
		return new PushNotificationWrapper(_pushNotification.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _pushNotification.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PushNotificationWrapper)) {
			return false;
		}

		PushNotificationWrapper pushNotificationWrapper = (PushNotificationWrapper)obj;

		if (Objects.equals(_pushNotification,
					pushNotificationWrapper._pushNotification)) {
			return true;
		}

		return false;
	}

	@Override
	public PushNotification getWrappedModel() {
		return _pushNotification;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pushNotification.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pushNotification.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pushNotification.resetOriginalValues();
	}

	private final PushNotification _pushNotification;
}