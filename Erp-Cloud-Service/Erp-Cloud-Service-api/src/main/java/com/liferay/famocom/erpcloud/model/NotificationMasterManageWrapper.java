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
 * This class is a wrapper for {@link NotificationMasterManage}.
 * </p>
 *
 * @author Samaresh
 * @see NotificationMasterManage
 * @generated
 */
@ProviderType
public class NotificationMasterManageWrapper implements NotificationMasterManage,
	ModelWrapper<NotificationMasterManage> {
	public NotificationMasterManageWrapper(
		NotificationMasterManage notificationMasterManage) {
		_notificationMasterManage = notificationMasterManage;
	}

	@Override
	public Class<?> getModelClass() {
		return NotificationMasterManage.class;
	}

	@Override
	public String getModelClassName() {
		return NotificationMasterManage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notifyId", getNotifyId());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("documentId", getDocumentId());
		attributes.put("documentUrl", getDocumentUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notifyId = (Long)attributes.get("notifyId");

		if (notifyId != null) {
			setNotifyId(notifyId);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String documentUrl = (String)attributes.get("documentUrl");

		if (documentUrl != null) {
			setDocumentUrl(documentUrl);
		}
	}

	@Override
	public Object clone() {
		return new NotificationMasterManageWrapper((NotificationMasterManage)_notificationMasterManage.clone());
	}

	@Override
	public int compareTo(NotificationMasterManage notificationMasterManage) {
		return _notificationMasterManage.compareTo(notificationMasterManage);
	}

	/**
	* Returns the body of this notification master manage.
	*
	* @return the body of this notification master manage
	*/
	@Override
	public String getBody() {
		return _notificationMasterManage.getBody();
	}

	/**
	* Returns the created by of this notification master manage.
	*
	* @return the created by of this notification master manage
	*/
	@Override
	public String getCreatedBy() {
		return _notificationMasterManage.getCreatedBy();
	}

	/**
	* Returns the created date of this notification master manage.
	*
	* @return the created date of this notification master manage
	*/
	@Override
	public Date getCreatedDate() {
		return _notificationMasterManage.getCreatedDate();
	}

	/**
	* Returns the document ID of this notification master manage.
	*
	* @return the document ID of this notification master manage
	*/
	@Override
	public long getDocumentId() {
		return _notificationMasterManage.getDocumentId();
	}

	/**
	* Returns the document url of this notification master manage.
	*
	* @return the document url of this notification master manage
	*/
	@Override
	public String getDocumentUrl() {
		return _notificationMasterManage.getDocumentUrl();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _notificationMasterManage.getExpandoBridge();
	}

	/**
	* Returns the modified date of this notification master manage.
	*
	* @return the modified date of this notification master manage
	*/
	@Override
	public Date getModifiedDate() {
		return _notificationMasterManage.getModifiedDate();
	}

	/**
	* Returns the notify ID of this notification master manage.
	*
	* @return the notify ID of this notification master manage
	*/
	@Override
	public long getNotifyId() {
		return _notificationMasterManage.getNotifyId();
	}

	/**
	* Returns the primary key of this notification master manage.
	*
	* @return the primary key of this notification master manage
	*/
	@Override
	public long getPrimaryKey() {
		return _notificationMasterManage.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationMasterManage.getPrimaryKeyObj();
	}

	/**
	* Returns the subject of this notification master manage.
	*
	* @return the subject of this notification master manage
	*/
	@Override
	public String getSubject() {
		return _notificationMasterManage.getSubject();
	}

	@Override
	public int hashCode() {
		return _notificationMasterManage.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _notificationMasterManage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _notificationMasterManage.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _notificationMasterManage.isNew();
	}

	@Override
	public void persist() {
		_notificationMasterManage.persist();
	}

	/**
	* Sets the body of this notification master manage.
	*
	* @param body the body of this notification master manage
	*/
	@Override
	public void setBody(String body) {
		_notificationMasterManage.setBody(body);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notificationMasterManage.setCachedModel(cachedModel);
	}

	/**
	* Sets the created by of this notification master manage.
	*
	* @param createdBy the created by of this notification master manage
	*/
	@Override
	public void setCreatedBy(String createdBy) {
		_notificationMasterManage.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this notification master manage.
	*
	* @param createdDate the created date of this notification master manage
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_notificationMasterManage.setCreatedDate(createdDate);
	}

	/**
	* Sets the document ID of this notification master manage.
	*
	* @param documentId the document ID of this notification master manage
	*/
	@Override
	public void setDocumentId(long documentId) {
		_notificationMasterManage.setDocumentId(documentId);
	}

	/**
	* Sets the document url of this notification master manage.
	*
	* @param documentUrl the document url of this notification master manage
	*/
	@Override
	public void setDocumentUrl(String documentUrl) {
		_notificationMasterManage.setDocumentUrl(documentUrl);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_notificationMasterManage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_notificationMasterManage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_notificationMasterManage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this notification master manage.
	*
	* @param modifiedDate the modified date of this notification master manage
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_notificationMasterManage.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_notificationMasterManage.setNew(n);
	}

	/**
	* Sets the notify ID of this notification master manage.
	*
	* @param notifyId the notify ID of this notification master manage
	*/
	@Override
	public void setNotifyId(long notifyId) {
		_notificationMasterManage.setNotifyId(notifyId);
	}

	/**
	* Sets the primary key of this notification master manage.
	*
	* @param primaryKey the primary key of this notification master manage
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notificationMasterManage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_notificationMasterManage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the subject of this notification master manage.
	*
	* @param subject the subject of this notification master manage
	*/
	@Override
	public void setSubject(String subject) {
		_notificationMasterManage.setSubject(subject);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<NotificationMasterManage> toCacheModel() {
		return _notificationMasterManage.toCacheModel();
	}

	@Override
	public NotificationMasterManage toEscapedModel() {
		return new NotificationMasterManageWrapper(_notificationMasterManage.toEscapedModel());
	}

	@Override
	public String toString() {
		return _notificationMasterManage.toString();
	}

	@Override
	public NotificationMasterManage toUnescapedModel() {
		return new NotificationMasterManageWrapper(_notificationMasterManage.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _notificationMasterManage.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationMasterManageWrapper)) {
			return false;
		}

		NotificationMasterManageWrapper notificationMasterManageWrapper = (NotificationMasterManageWrapper)obj;

		if (Objects.equals(_notificationMasterManage,
					notificationMasterManageWrapper._notificationMasterManage)) {
			return true;
		}

		return false;
	}

	@Override
	public NotificationMasterManage getWrappedModel() {
		return _notificationMasterManage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _notificationMasterManage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _notificationMasterManage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_notificationMasterManage.resetOriginalValues();
	}

	private final NotificationMasterManage _notificationMasterManage;
}