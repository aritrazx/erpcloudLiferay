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
 * This class is a wrapper for {@link NotificationSendManage}.
 * </p>
 *
 * @author Samaresh
 * @see NotificationSendManage
 * @generated
 */
@ProviderType
public class NotificationSendManageWrapper implements NotificationSendManage,
	ModelWrapper<NotificationSendManage> {
	public NotificationSendManageWrapper(
		NotificationSendManage notificationSendManage) {
		_notificationSendManage = notificationSendManage;
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

	@Override
	public Object clone() {
		return new NotificationSendManageWrapper((NotificationSendManage)_notificationSendManage.clone());
	}

	@Override
	public int compareTo(NotificationSendManage notificationSendManage) {
		return _notificationSendManage.compareTo(notificationSendManage);
	}

	/**
	* Returns the branch ID of this notification send manage.
	*
	* @return the branch ID of this notification send manage
	*/
	@Override
	public long getBranchId() {
		return _notificationSendManage.getBranchId();
	}

	/**
	* Returns the comment of this notification send manage.
	*
	* @return the comment of this notification send manage
	*/
	@Override
	public String getComment() {
		return _notificationSendManage.getComment();
	}

	/**
	* Returns the document ID of this notification send manage.
	*
	* @return the document ID of this notification send manage
	*/
	@Override
	public long getDocumentId() {
		return _notificationSendManage.getDocumentId();
	}

	/**
	* Returns the document url of this notification send manage.
	*
	* @return the document url of this notification send manage
	*/
	@Override
	public String getDocumentUrl() {
		return _notificationSendManage.getDocumentUrl();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _notificationSendManage.getExpandoBridge();
	}

	/**
	* Returns the is approved of this notification send manage.
	*
	* @return the is approved of this notification send manage
	*/
	@Override
	public int getIsApproved() {
		return _notificationSendManage.getIsApproved();
	}

	/**
	* Returns the is open of this notification send manage.
	*
	* @return the is open of this notification send manage
	*/
	@Override
	public boolean getIsOpen() {
		return _notificationSendManage.getIsOpen();
	}

	/**
	* Returns the notification ID of this notification send manage.
	*
	* @return the notification ID of this notification send manage
	*/
	@Override
	public long getNotificationId() {
		return _notificationSendManage.getNotificationId();
	}

	/**
	* Returns the notify ID send ID of this notification send manage.
	*
	* @return the notify ID send ID of this notification send manage
	*/
	@Override
	public long getNotifyIdSendId() {
		return _notificationSendManage.getNotifyIdSendId();
	}

	/**
	* Returns the open by of this notification send manage.
	*
	* @return the open by of this notification send manage
	*/
	@Override
	public String getOpenBy() {
		return _notificationSendManage.getOpenBy();
	}

	/**
	* Returns the primary key of this notification send manage.
	*
	* @return the primary key of this notification send manage
	*/
	@Override
	public long getPrimaryKey() {
		return _notificationSendManage.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationSendManage.getPrimaryKeyObj();
	}

	/**
	* Returns the send by of this notification send manage.
	*
	* @return the send by of this notification send manage
	*/
	@Override
	public String getSendBy() {
		return _notificationSendManage.getSendBy();
	}

	/**
	* Returns the sending date of this notification send manage.
	*
	* @return the sending date of this notification send manage
	*/
	@Override
	public Date getSendingDate() {
		return _notificationSendManage.getSendingDate();
	}

	@Override
	public int hashCode() {
		return _notificationSendManage.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _notificationSendManage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _notificationSendManage.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this notification send manage is is open.
	*
	* @return <code>true</code> if this notification send manage is is open; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsOpen() {
		return _notificationSendManage.isIsOpen();
	}

	@Override
	public boolean isNew() {
		return _notificationSendManage.isNew();
	}

	@Override
	public void persist() {
		_notificationSendManage.persist();
	}

	/**
	* Sets the branch ID of this notification send manage.
	*
	* @param branchId the branch ID of this notification send manage
	*/
	@Override
	public void setBranchId(long branchId) {
		_notificationSendManage.setBranchId(branchId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notificationSendManage.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this notification send manage.
	*
	* @param comment the comment of this notification send manage
	*/
	@Override
	public void setComment(String comment) {
		_notificationSendManage.setComment(comment);
	}

	/**
	* Sets the document ID of this notification send manage.
	*
	* @param documentId the document ID of this notification send manage
	*/
	@Override
	public void setDocumentId(long documentId) {
		_notificationSendManage.setDocumentId(documentId);
	}

	/**
	* Sets the document url of this notification send manage.
	*
	* @param documentUrl the document url of this notification send manage
	*/
	@Override
	public void setDocumentUrl(String documentUrl) {
		_notificationSendManage.setDocumentUrl(documentUrl);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_notificationSendManage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_notificationSendManage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_notificationSendManage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the is approved of this notification send manage.
	*
	* @param isApproved the is approved of this notification send manage
	*/
	@Override
	public void setIsApproved(int isApproved) {
		_notificationSendManage.setIsApproved(isApproved);
	}

	/**
	* Sets whether this notification send manage is is open.
	*
	* @param isOpen the is open of this notification send manage
	*/
	@Override
	public void setIsOpen(boolean isOpen) {
		_notificationSendManage.setIsOpen(isOpen);
	}

	@Override
	public void setNew(boolean n) {
		_notificationSendManage.setNew(n);
	}

	/**
	* Sets the notification ID of this notification send manage.
	*
	* @param notificationId the notification ID of this notification send manage
	*/
	@Override
	public void setNotificationId(long notificationId) {
		_notificationSendManage.setNotificationId(notificationId);
	}

	/**
	* Sets the notify ID send ID of this notification send manage.
	*
	* @param notifyIdSendId the notify ID send ID of this notification send manage
	*/
	@Override
	public void setNotifyIdSendId(long notifyIdSendId) {
		_notificationSendManage.setNotifyIdSendId(notifyIdSendId);
	}

	/**
	* Sets the open by of this notification send manage.
	*
	* @param openBy the open by of this notification send manage
	*/
	@Override
	public void setOpenBy(String openBy) {
		_notificationSendManage.setOpenBy(openBy);
	}

	/**
	* Sets the primary key of this notification send manage.
	*
	* @param primaryKey the primary key of this notification send manage
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notificationSendManage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_notificationSendManage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the send by of this notification send manage.
	*
	* @param sendBy the send by of this notification send manage
	*/
	@Override
	public void setSendBy(String sendBy) {
		_notificationSendManage.setSendBy(sendBy);
	}

	/**
	* Sets the sending date of this notification send manage.
	*
	* @param sendingDate the sending date of this notification send manage
	*/
	@Override
	public void setSendingDate(Date sendingDate) {
		_notificationSendManage.setSendingDate(sendingDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<NotificationSendManage> toCacheModel() {
		return _notificationSendManage.toCacheModel();
	}

	@Override
	public NotificationSendManage toEscapedModel() {
		return new NotificationSendManageWrapper(_notificationSendManage.toEscapedModel());
	}

	@Override
	public String toString() {
		return _notificationSendManage.toString();
	}

	@Override
	public NotificationSendManage toUnescapedModel() {
		return new NotificationSendManageWrapper(_notificationSendManage.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _notificationSendManage.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationSendManageWrapper)) {
			return false;
		}

		NotificationSendManageWrapper notificationSendManageWrapper = (NotificationSendManageWrapper)obj;

		if (Objects.equals(_notificationSendManage,
					notificationSendManageWrapper._notificationSendManage)) {
			return true;
		}

		return false;
	}

	@Override
	public NotificationSendManage getWrappedModel() {
		return _notificationSendManage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _notificationSendManage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _notificationSendManage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_notificationSendManage.resetOriginalValues();
	}

	private final NotificationSendManage _notificationSendManage;
}