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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the NotificationMasterManage service. Represents a row in the &quot;notificationMasterManage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageImpl}.
 * </p>
 *
 * @author Samaresh
 * @see NotificationMasterManage
 * @see com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageImpl
 * @see com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageModelImpl
 * @generated
 */
@ProviderType
public interface NotificationMasterManageModel extends BaseModel<NotificationMasterManage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notification master manage model instance should use the {@link NotificationMasterManage} interface instead.
	 */

	/**
	 * Returns the primary key of this notification master manage.
	 *
	 * @return the primary key of this notification master manage
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notification master manage.
	 *
	 * @param primaryKey the primary key of this notification master manage
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the notify ID of this notification master manage.
	 *
	 * @return the notify ID of this notification master manage
	 */
	public long getNotifyId();

	/**
	 * Sets the notify ID of this notification master manage.
	 *
	 * @param notifyId the notify ID of this notification master manage
	 */
	public void setNotifyId(long notifyId);

	/**
	 * Returns the subject of this notification master manage.
	 *
	 * @return the subject of this notification master manage
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this notification master manage.
	 *
	 * @param subject the subject of this notification master manage
	 */
	public void setSubject(String subject);

	/**
	 * Returns the body of this notification master manage.
	 *
	 * @return the body of this notification master manage
	 */
	@AutoEscape
	public String getBody();

	/**
	 * Sets the body of this notification master manage.
	 *
	 * @param body the body of this notification master manage
	 */
	public void setBody(String body);

	/**
	 * Returns the created by of this notification master manage.
	 *
	 * @return the created by of this notification master manage
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this notification master manage.
	 *
	 * @param createdBy the created by of this notification master manage
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the created date of this notification master manage.
	 *
	 * @return the created date of this notification master manage
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this notification master manage.
	 *
	 * @param createdDate the created date of this notification master manage
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this notification master manage.
	 *
	 * @return the modified date of this notification master manage
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this notification master manage.
	 *
	 * @param modifiedDate the modified date of this notification master manage
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the document ID of this notification master manage.
	 *
	 * @return the document ID of this notification master manage
	 */
	public long getDocumentId();

	/**
	 * Sets the document ID of this notification master manage.
	 *
	 * @param documentId the document ID of this notification master manage
	 */
	public void setDocumentId(long documentId);

	/**
	 * Returns the document url of this notification master manage.
	 *
	 * @return the document url of this notification master manage
	 */
	@AutoEscape
	public String getDocumentUrl();

	/**
	 * Sets the document url of this notification master manage.
	 *
	 * @param documentUrl the document url of this notification master manage
	 */
	public void setDocumentUrl(String documentUrl);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(NotificationMasterManage notificationMasterManage);

	@Override
	public int hashCode();

	@Override
	public CacheModel<NotificationMasterManage> toCacheModel();

	@Override
	public NotificationMasterManage toEscapedModel();

	@Override
	public NotificationMasterManage toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}