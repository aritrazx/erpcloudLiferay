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
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LeaveDoc service. Represents a row in the &quot;LeaveDoc&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.LeaveDocModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.LeaveDocImpl}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveDoc
 * @see com.liferay.famocom.erpcloud.model.impl.LeaveDocImpl
 * @see com.liferay.famocom.erpcloud.model.impl.LeaveDocModelImpl
 * @generated
 */
@ProviderType
public interface LeaveDocModel extends BaseModel<LeaveDoc>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a leave doc model instance should use the {@link LeaveDoc} interface instead.
	 */

	/**
	 * Returns the primary key of this leave doc.
	 *
	 * @return the primary key of this leave doc
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this leave doc.
	 *
	 * @param primaryKey the primary key of this leave doc
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the leave doc ID of this leave doc.
	 *
	 * @return the leave doc ID of this leave doc
	 */
	public long getLeaveDocId();

	/**
	 * Sets the leave doc ID of this leave doc.
	 *
	 * @param leaveDocId the leave doc ID of this leave doc
	 */
	public void setLeaveDocId(long leaveDocId);

	/**
	 * Returns the employee ID of this leave doc.
	 *
	 * @return the employee ID of this leave doc
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this leave doc.
	 *
	 * @param employeeId the employee ID of this leave doc
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the company ID of this leave doc.
	 *
	 * @return the company ID of this leave doc
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this leave doc.
	 *
	 * @param companyId the company ID of this leave doc
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the leave apply ID of this leave doc.
	 *
	 * @return the leave apply ID of this leave doc
	 */
	public long getLeaveApplyId();

	/**
	 * Sets the leave apply ID of this leave doc.
	 *
	 * @param leaveApplyId the leave apply ID of this leave doc
	 */
	public void setLeaveApplyId(long leaveApplyId);

	/**
	 * Returns the file entry ID of this leave doc.
	 *
	 * @return the file entry ID of this leave doc
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this leave doc.
	 *
	 * @param fileEntryId the file entry ID of this leave doc
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the file path of this leave doc.
	 *
	 * @return the file path of this leave doc
	 */
	@AutoEscape
	public String getFilePath();

	/**
	 * Sets the file path of this leave doc.
	 *
	 * @param filePath the file path of this leave doc
	 */
	public void setFilePath(String filePath);

	/**
	 * Returns the added date of this leave doc.
	 *
	 * @return the added date of this leave doc
	 */
	public Date getAddedDate();

	/**
	 * Sets the added date of this leave doc.
	 *
	 * @param addedDate the added date of this leave doc
	 */
	public void setAddedDate(Date addedDate);

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
	public int compareTo(LeaveDoc leaveDoc);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LeaveDoc> toCacheModel();

	@Override
	public LeaveDoc toEscapedModel();

	@Override
	public LeaveDoc toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}