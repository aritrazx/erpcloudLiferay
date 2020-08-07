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
 * This class is a wrapper for {@link TravelDeskDetails}.
 * </p>
 *
 * @author Samaresh
 * @see TravelDeskDetails
 * @generated
 */
@ProviderType
public class TravelDeskDetailsWrapper implements TravelDeskDetails,
	ModelWrapper<TravelDeskDetails> {
	public TravelDeskDetailsWrapper(TravelDeskDetails travelDeskDetails) {
		_travelDeskDetails = travelDeskDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return TravelDeskDetails.class;
	}

	@Override
	public String getModelClassName() {
		return TravelDeskDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("travelDetailsId", getTravelDetailsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("projectId", getProjectId());
		attributes.put("projectTeamsId", getProjectTeamsId());
		attributes.put("ticketType", getTicketType());
		attributes.put("hotel", isHotel());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("fromTime", getFromTime());
		attributes.put("toTime", getToTime());
		attributes.put("location", getLocation());
		attributes.put("purpose", getPurpose());
		attributes.put("specialInstraction", getSpecialInstraction());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("managerComment", getManagerComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long travelDetailsId = (Long)attributes.get("travelDetailsId");

		if (travelDetailsId != null) {
			setTravelDetailsId(travelDetailsId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long projectTeamsId = (Long)attributes.get("projectTeamsId");

		if (projectTeamsId != null) {
			setProjectTeamsId(projectTeamsId);
		}

		String ticketType = (String)attributes.get("ticketType");

		if (ticketType != null) {
			setTicketType(ticketType);
		}

		Boolean hotel = (Boolean)attributes.get("hotel");

		if (hotel != null) {
			setHotel(hotel);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String fromTime = (String)attributes.get("fromTime");

		if (fromTime != null) {
			setFromTime(fromTime);
		}

		String toTime = (String)attributes.get("toTime");

		if (toTime != null) {
			setToTime(toTime);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String purpose = (String)attributes.get("purpose");

		if (purpose != null) {
			setPurpose(purpose);
		}

		String specialInstraction = (String)attributes.get("specialInstraction");

		if (specialInstraction != null) {
			setSpecialInstraction(specialInstraction);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String managerComment = (String)attributes.get("managerComment");

		if (managerComment != null) {
			setManagerComment(managerComment);
		}
	}

	@Override
	public Object clone() {
		return new TravelDeskDetailsWrapper((TravelDeskDetails)_travelDeskDetails.clone());
	}

	@Override
	public int compareTo(TravelDeskDetails travelDeskDetails) {
		return _travelDeskDetails.compareTo(travelDeskDetails);
	}

	/**
	* Returns the company ID of this travel desk details.
	*
	* @return the company ID of this travel desk details
	*/
	@Override
	public long getCompanyId() {
		return _travelDeskDetails.getCompanyId();
	}

	/**
	* Returns the create date of this travel desk details.
	*
	* @return the create date of this travel desk details
	*/
	@Override
	public Date getCreateDate() {
		return _travelDeskDetails.getCreateDate();
	}

	/**
	* Returns the employee ID of this travel desk details.
	*
	* @return the employee ID of this travel desk details
	*/
	@Override
	public long getEmployeeId() {
		return _travelDeskDetails.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _travelDeskDetails.getExpandoBridge();
	}

	/**
	* Returns the from date of this travel desk details.
	*
	* @return the from date of this travel desk details
	*/
	@Override
	public Date getFromDate() {
		return _travelDeskDetails.getFromDate();
	}

	/**
	* Returns the from time of this travel desk details.
	*
	* @return the from time of this travel desk details
	*/
	@Override
	public String getFromTime() {
		return _travelDeskDetails.getFromTime();
	}

	/**
	* Returns the hotel of this travel desk details.
	*
	* @return the hotel of this travel desk details
	*/
	@Override
	public boolean getHotel() {
		return _travelDeskDetails.getHotel();
	}

	/**
	* Returns the location of this travel desk details.
	*
	* @return the location of this travel desk details
	*/
	@Override
	public String getLocation() {
		return _travelDeskDetails.getLocation();
	}

	/**
	* Returns the manager comment of this travel desk details.
	*
	* @return the manager comment of this travel desk details
	*/
	@Override
	public String getManagerComment() {
		return _travelDeskDetails.getManagerComment();
	}

	/**
	* Returns the modified date of this travel desk details.
	*
	* @return the modified date of this travel desk details
	*/
	@Override
	public Date getModifiedDate() {
		return _travelDeskDetails.getModifiedDate();
	}

	/**
	* Returns the primary key of this travel desk details.
	*
	* @return the primary key of this travel desk details
	*/
	@Override
	public long getPrimaryKey() {
		return _travelDeskDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _travelDeskDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this travel desk details.
	*
	* @return the project ID of this travel desk details
	*/
	@Override
	public long getProjectId() {
		return _travelDeskDetails.getProjectId();
	}

	/**
	* Returns the project teams ID of this travel desk details.
	*
	* @return the project teams ID of this travel desk details
	*/
	@Override
	public long getProjectTeamsId() {
		return _travelDeskDetails.getProjectTeamsId();
	}

	/**
	* Returns the purpose of this travel desk details.
	*
	* @return the purpose of this travel desk details
	*/
	@Override
	public String getPurpose() {
		return _travelDeskDetails.getPurpose();
	}

	/**
	* Returns the special instraction of this travel desk details.
	*
	* @return the special instraction of this travel desk details
	*/
	@Override
	public String getSpecialInstraction() {
		return _travelDeskDetails.getSpecialInstraction();
	}

	/**
	* Returns the status of this travel desk details.
	*
	* @return the status of this travel desk details
	*/
	@Override
	public int getStatus() {
		return _travelDeskDetails.getStatus();
	}

	/**
	* Returns the ticket type of this travel desk details.
	*
	* @return the ticket type of this travel desk details
	*/
	@Override
	public String getTicketType() {
		return _travelDeskDetails.getTicketType();
	}

	/**
	* Returns the to date of this travel desk details.
	*
	* @return the to date of this travel desk details
	*/
	@Override
	public Date getToDate() {
		return _travelDeskDetails.getToDate();
	}

	/**
	* Returns the to time of this travel desk details.
	*
	* @return the to time of this travel desk details
	*/
	@Override
	public String getToTime() {
		return _travelDeskDetails.getToTime();
	}

	/**
	* Returns the travel details ID of this travel desk details.
	*
	* @return the travel details ID of this travel desk details
	*/
	@Override
	public long getTravelDetailsId() {
		return _travelDeskDetails.getTravelDetailsId();
	}

	/**
	* Returns the user ID of this travel desk details.
	*
	* @return the user ID of this travel desk details
	*/
	@Override
	public long getUserId() {
		return _travelDeskDetails.getUserId();
	}

	/**
	* Returns the user uuid of this travel desk details.
	*
	* @return the user uuid of this travel desk details
	*/
	@Override
	public String getUserUuid() {
		return _travelDeskDetails.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _travelDeskDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _travelDeskDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _travelDeskDetails.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this travel desk details is hotel.
	*
	* @return <code>true</code> if this travel desk details is hotel; <code>false</code> otherwise
	*/
	@Override
	public boolean isHotel() {
		return _travelDeskDetails.isHotel();
	}

	@Override
	public boolean isNew() {
		return _travelDeskDetails.isNew();
	}

	@Override
	public void persist() {
		_travelDeskDetails.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_travelDeskDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this travel desk details.
	*
	* @param companyId the company ID of this travel desk details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_travelDeskDetails.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this travel desk details.
	*
	* @param createDate the create date of this travel desk details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_travelDeskDetails.setCreateDate(createDate);
	}

	/**
	* Sets the employee ID of this travel desk details.
	*
	* @param employeeId the employee ID of this travel desk details
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_travelDeskDetails.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_travelDeskDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_travelDeskDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_travelDeskDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the from date of this travel desk details.
	*
	* @param fromDate the from date of this travel desk details
	*/
	@Override
	public void setFromDate(Date fromDate) {
		_travelDeskDetails.setFromDate(fromDate);
	}

	/**
	* Sets the from time of this travel desk details.
	*
	* @param fromTime the from time of this travel desk details
	*/
	@Override
	public void setFromTime(String fromTime) {
		_travelDeskDetails.setFromTime(fromTime);
	}

	/**
	* Sets whether this travel desk details is hotel.
	*
	* @param hotel the hotel of this travel desk details
	*/
	@Override
	public void setHotel(boolean hotel) {
		_travelDeskDetails.setHotel(hotel);
	}

	/**
	* Sets the location of this travel desk details.
	*
	* @param location the location of this travel desk details
	*/
	@Override
	public void setLocation(String location) {
		_travelDeskDetails.setLocation(location);
	}

	/**
	* Sets the manager comment of this travel desk details.
	*
	* @param managerComment the manager comment of this travel desk details
	*/
	@Override
	public void setManagerComment(String managerComment) {
		_travelDeskDetails.setManagerComment(managerComment);
	}

	/**
	* Sets the modified date of this travel desk details.
	*
	* @param modifiedDate the modified date of this travel desk details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_travelDeskDetails.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_travelDeskDetails.setNew(n);
	}

	/**
	* Sets the primary key of this travel desk details.
	*
	* @param primaryKey the primary key of this travel desk details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_travelDeskDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_travelDeskDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this travel desk details.
	*
	* @param projectId the project ID of this travel desk details
	*/
	@Override
	public void setProjectId(long projectId) {
		_travelDeskDetails.setProjectId(projectId);
	}

	/**
	* Sets the project teams ID of this travel desk details.
	*
	* @param projectTeamsId the project teams ID of this travel desk details
	*/
	@Override
	public void setProjectTeamsId(long projectTeamsId) {
		_travelDeskDetails.setProjectTeamsId(projectTeamsId);
	}

	/**
	* Sets the purpose of this travel desk details.
	*
	* @param purpose the purpose of this travel desk details
	*/
	@Override
	public void setPurpose(String purpose) {
		_travelDeskDetails.setPurpose(purpose);
	}

	/**
	* Sets the special instraction of this travel desk details.
	*
	* @param specialInstraction the special instraction of this travel desk details
	*/
	@Override
	public void setSpecialInstraction(String specialInstraction) {
		_travelDeskDetails.setSpecialInstraction(specialInstraction);
	}

	/**
	* Sets the status of this travel desk details.
	*
	* @param status the status of this travel desk details
	*/
	@Override
	public void setStatus(int status) {
		_travelDeskDetails.setStatus(status);
	}

	/**
	* Sets the ticket type of this travel desk details.
	*
	* @param ticketType the ticket type of this travel desk details
	*/
	@Override
	public void setTicketType(String ticketType) {
		_travelDeskDetails.setTicketType(ticketType);
	}

	/**
	* Sets the to date of this travel desk details.
	*
	* @param toDate the to date of this travel desk details
	*/
	@Override
	public void setToDate(Date toDate) {
		_travelDeskDetails.setToDate(toDate);
	}

	/**
	* Sets the to time of this travel desk details.
	*
	* @param toTime the to time of this travel desk details
	*/
	@Override
	public void setToTime(String toTime) {
		_travelDeskDetails.setToTime(toTime);
	}

	/**
	* Sets the travel details ID of this travel desk details.
	*
	* @param travelDetailsId the travel details ID of this travel desk details
	*/
	@Override
	public void setTravelDetailsId(long travelDetailsId) {
		_travelDeskDetails.setTravelDetailsId(travelDetailsId);
	}

	/**
	* Sets the user ID of this travel desk details.
	*
	* @param userId the user ID of this travel desk details
	*/
	@Override
	public void setUserId(long userId) {
		_travelDeskDetails.setUserId(userId);
	}

	/**
	* Sets the user uuid of this travel desk details.
	*
	* @param userUuid the user uuid of this travel desk details
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_travelDeskDetails.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TravelDeskDetails> toCacheModel() {
		return _travelDeskDetails.toCacheModel();
	}

	@Override
	public TravelDeskDetails toEscapedModel() {
		return new TravelDeskDetailsWrapper(_travelDeskDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _travelDeskDetails.toString();
	}

	@Override
	public TravelDeskDetails toUnescapedModel() {
		return new TravelDeskDetailsWrapper(_travelDeskDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _travelDeskDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TravelDeskDetailsWrapper)) {
			return false;
		}

		TravelDeskDetailsWrapper travelDeskDetailsWrapper = (TravelDeskDetailsWrapper)obj;

		if (Objects.equals(_travelDeskDetails,
					travelDeskDetailsWrapper._travelDeskDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public TravelDeskDetails getWrappedModel() {
		return _travelDeskDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _travelDeskDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _travelDeskDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_travelDeskDetails.resetOriginalValues();
	}

	private final TravelDeskDetails _travelDeskDetails;
}