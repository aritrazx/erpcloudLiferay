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
 * This class is a wrapper for {@link AttendanceBio}.
 * </p>
 *
 * @author Samaresh
 * @see AttendanceBio
 * @generated
 */
@ProviderType
public class AttendanceBioWrapper implements AttendanceBio,
	ModelWrapper<AttendanceBio> {
	public AttendanceBioWrapper(AttendanceBio attendanceBio) {
		_attendanceBio = attendanceBio;
	}

	@Override
	public Class<?> getModelClass() {
		return AttendanceBio.class;
	}

	@Override
	public String getModelClassName() {
		return AttendanceBio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attendanceBioId", getAttendanceBioId());
		attributes.put("companyId", getCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("attDate", getAttDate());
		attributes.put("attTime", getAttTime());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attendanceBioId = (Long)attributes.get("attendanceBioId");

		if (attendanceBioId != null) {
			setAttendanceBioId(attendanceBioId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date attDate = (Date)attributes.get("attDate");

		if (attDate != null) {
			setAttDate(attDate);
		}

		String attTime = (String)attributes.get("attTime");

		if (attTime != null) {
			setAttTime(attTime);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new AttendanceBioWrapper((AttendanceBio)_attendanceBio.clone());
	}

	@Override
	public int compareTo(AttendanceBio attendanceBio) {
		return _attendanceBio.compareTo(attendanceBio);
	}

	/**
	* Returns the att date of this attendance bio.
	*
	* @return the att date of this attendance bio
	*/
	@Override
	public Date getAttDate() {
		return _attendanceBio.getAttDate();
	}

	/**
	* Returns the attendance bio ID of this attendance bio.
	*
	* @return the attendance bio ID of this attendance bio
	*/
	@Override
	public long getAttendanceBioId() {
		return _attendanceBio.getAttendanceBioId();
	}

	/**
	* Returns the att time of this attendance bio.
	*
	* @return the att time of this attendance bio
	*/
	@Override
	public String getAttTime() {
		return _attendanceBio.getAttTime();
	}

	/**
	* Returns the company ID of this attendance bio.
	*
	* @return the company ID of this attendance bio
	*/
	@Override
	public long getCompanyId() {
		return _attendanceBio.getCompanyId();
	}

	/**
	* Returns the employee ID of this attendance bio.
	*
	* @return the employee ID of this attendance bio
	*/
	@Override
	public long getEmployeeId() {
		return _attendanceBio.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _attendanceBio.getExpandoBridge();
	}

	/**
	* Returns the primary key of this attendance bio.
	*
	* @return the primary key of this attendance bio
	*/
	@Override
	public long getPrimaryKey() {
		return _attendanceBio.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attendanceBio.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this attendance bio.
	*
	* @return the status of this attendance bio
	*/
	@Override
	public int getStatus() {
		return _attendanceBio.getStatus();
	}

	/**
	* Returns the upload date of this attendance bio.
	*
	* @return the upload date of this attendance bio
	*/
	@Override
	public Date getUploadDate() {
		return _attendanceBio.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _attendanceBio.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _attendanceBio.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _attendanceBio.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _attendanceBio.isNew();
	}

	@Override
	public void persist() {
		_attendanceBio.persist();
	}

	/**
	* Sets the att date of this attendance bio.
	*
	* @param attDate the att date of this attendance bio
	*/
	@Override
	public void setAttDate(Date attDate) {
		_attendanceBio.setAttDate(attDate);
	}

	/**
	* Sets the attendance bio ID of this attendance bio.
	*
	* @param attendanceBioId the attendance bio ID of this attendance bio
	*/
	@Override
	public void setAttendanceBioId(long attendanceBioId) {
		_attendanceBio.setAttendanceBioId(attendanceBioId);
	}

	/**
	* Sets the att time of this attendance bio.
	*
	* @param attTime the att time of this attendance bio
	*/
	@Override
	public void setAttTime(String attTime) {
		_attendanceBio.setAttTime(attTime);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attendanceBio.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this attendance bio.
	*
	* @param companyId the company ID of this attendance bio
	*/
	@Override
	public void setCompanyId(long companyId) {
		_attendanceBio.setCompanyId(companyId);
	}

	/**
	* Sets the employee ID of this attendance bio.
	*
	* @param employeeId the employee ID of this attendance bio
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_attendanceBio.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_attendanceBio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_attendanceBio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_attendanceBio.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_attendanceBio.setNew(n);
	}

	/**
	* Sets the primary key of this attendance bio.
	*
	* @param primaryKey the primary key of this attendance bio
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attendanceBio.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_attendanceBio.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this attendance bio.
	*
	* @param status the status of this attendance bio
	*/
	@Override
	public void setStatus(int status) {
		_attendanceBio.setStatus(status);
	}

	/**
	* Sets the upload date of this attendance bio.
	*
	* @param uploadDate the upload date of this attendance bio
	*/
	@Override
	public void setUploadDate(Date uploadDate) {
		_attendanceBio.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AttendanceBio> toCacheModel() {
		return _attendanceBio.toCacheModel();
	}

	@Override
	public AttendanceBio toEscapedModel() {
		return new AttendanceBioWrapper(_attendanceBio.toEscapedModel());
	}

	@Override
	public String toString() {
		return _attendanceBio.toString();
	}

	@Override
	public AttendanceBio toUnescapedModel() {
		return new AttendanceBioWrapper(_attendanceBio.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _attendanceBio.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttendanceBioWrapper)) {
			return false;
		}

		AttendanceBioWrapper attendanceBioWrapper = (AttendanceBioWrapper)obj;

		if (Objects.equals(_attendanceBio, attendanceBioWrapper._attendanceBio)) {
			return true;
		}

		return false;
	}

	@Override
	public AttendanceBio getWrappedModel() {
		return _attendanceBio;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _attendanceBio.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _attendanceBio.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_attendanceBio.resetOriginalValues();
	}

	private final AttendanceBio _attendanceBio;
}