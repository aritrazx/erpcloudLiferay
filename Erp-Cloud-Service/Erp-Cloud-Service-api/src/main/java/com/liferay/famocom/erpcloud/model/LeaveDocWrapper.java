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
 * This class is a wrapper for {@link LeaveDoc}.
 * </p>
 *
 * @author Samaresh
 * @see LeaveDoc
 * @generated
 */
@ProviderType
public class LeaveDocWrapper implements LeaveDoc, ModelWrapper<LeaveDoc> {
	public LeaveDocWrapper(LeaveDoc leaveDoc) {
		_leaveDoc = leaveDoc;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaveDoc.class;
	}

	@Override
	public String getModelClassName() {
		return LeaveDoc.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("leaveDocId", getLeaveDocId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("leaveApplyId", getLeaveApplyId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("filePath", getFilePath());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long leaveDocId = (Long)attributes.get("leaveDocId");

		if (leaveDocId != null) {
			setLeaveDocId(leaveDocId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long leaveApplyId = (Long)attributes.get("leaveApplyId");

		if (leaveApplyId != null) {
			setLeaveApplyId(leaveApplyId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String filePath = (String)attributes.get("filePath");

		if (filePath != null) {
			setFilePath(filePath);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new LeaveDocWrapper((LeaveDoc)_leaveDoc.clone());
	}

	@Override
	public int compareTo(LeaveDoc leaveDoc) {
		return _leaveDoc.compareTo(leaveDoc);
	}

	/**
	* Returns the added date of this leave doc.
	*
	* @return the added date of this leave doc
	*/
	@Override
	public Date getAddedDate() {
		return _leaveDoc.getAddedDate();
	}

	/**
	* Returns the company ID of this leave doc.
	*
	* @return the company ID of this leave doc
	*/
	@Override
	public long getCompanyId() {
		return _leaveDoc.getCompanyId();
	}

	/**
	* Returns the employee ID of this leave doc.
	*
	* @return the employee ID of this leave doc
	*/
	@Override
	public long getEmployeeId() {
		return _leaveDoc.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _leaveDoc.getExpandoBridge();
	}

	/**
	* Returns the file entry ID of this leave doc.
	*
	* @return the file entry ID of this leave doc
	*/
	@Override
	public long getFileEntryId() {
		return _leaveDoc.getFileEntryId();
	}

	/**
	* Returns the file path of this leave doc.
	*
	* @return the file path of this leave doc
	*/
	@Override
	public String getFilePath() {
		return _leaveDoc.getFilePath();
	}

	/**
	* Returns the leave apply ID of this leave doc.
	*
	* @return the leave apply ID of this leave doc
	*/
	@Override
	public long getLeaveApplyId() {
		return _leaveDoc.getLeaveApplyId();
	}

	/**
	* Returns the leave doc ID of this leave doc.
	*
	* @return the leave doc ID of this leave doc
	*/
	@Override
	public long getLeaveDocId() {
		return _leaveDoc.getLeaveDocId();
	}

	/**
	* Returns the primary key of this leave doc.
	*
	* @return the primary key of this leave doc
	*/
	@Override
	public long getPrimaryKey() {
		return _leaveDoc.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _leaveDoc.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _leaveDoc.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _leaveDoc.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _leaveDoc.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _leaveDoc.isNew();
	}

	@Override
	public void persist() {
		_leaveDoc.persist();
	}

	/**
	* Sets the added date of this leave doc.
	*
	* @param addedDate the added date of this leave doc
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_leaveDoc.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaveDoc.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this leave doc.
	*
	* @param companyId the company ID of this leave doc
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaveDoc.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this leave doc.
	*
	* @param employeeId the employee ID of this leave doc
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_leaveDoc.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_leaveDoc.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_leaveDoc.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_leaveDoc.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this leave doc.
	*
	* @param fileEntryId the file entry ID of this leave doc
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_leaveDoc.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the file path of this leave doc.
	*
	* @param filePath the file path of this leave doc
	*/
	@Override
	public void setFilePath(String filePath) {
		_leaveDoc.setFilePath(filePath);
	}

	/**
	* Sets the leave apply ID of this leave doc.
	*
	* @param leaveApplyId the leave apply ID of this leave doc
	*/
	@Override
	public void setLeaveApplyId(long leaveApplyId) {
		_leaveDoc.setLeaveApplyId(leaveApplyId);
	}

	/**
	* Sets the leave doc ID of this leave doc.
	*
	* @param leaveDocId the leave doc ID of this leave doc
	*/
	@Override
	public void setLeaveDocId(long leaveDocId) {
		_leaveDoc.setLeaveDocId(leaveDocId);
	}

	@Override
	public void setNew(boolean n) {
		_leaveDoc.setNew(n);
	}

	/**
	* Sets the primary key of this leave doc.
	*
	* @param primaryKey the primary key of this leave doc
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leaveDoc.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_leaveDoc.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LeaveDoc> toCacheModel() {
		return _leaveDoc.toCacheModel();
	}

	@Override
	public LeaveDoc toEscapedModel() {
		return new LeaveDocWrapper(_leaveDoc.toEscapedModel());
	}

	@Override
	public String toString() {
		return _leaveDoc.toString();
	}

	@Override
	public LeaveDoc toUnescapedModel() {
		return new LeaveDocWrapper(_leaveDoc.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _leaveDoc.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaveDocWrapper)) {
			return false;
		}

		LeaveDocWrapper leaveDocWrapper = (LeaveDocWrapper)obj;

		if (Objects.equals(_leaveDoc, leaveDocWrapper._leaveDoc)) {
			return true;
		}

		return false;
	}

	@Override
	public LeaveDoc getWrappedModel() {
		return _leaveDoc;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _leaveDoc.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _leaveDoc.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_leaveDoc.resetOriginalValues();
	}

	private final LeaveDoc _leaveDoc;
}