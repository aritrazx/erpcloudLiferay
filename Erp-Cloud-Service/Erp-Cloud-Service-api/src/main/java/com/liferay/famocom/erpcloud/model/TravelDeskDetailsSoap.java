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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.TravelDeskDetailsServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.TravelDeskDetailsServiceSoap
 * @generated
 */
@ProviderType
public class TravelDeskDetailsSoap implements Serializable {
	public static TravelDeskDetailsSoap toSoapModel(TravelDeskDetails model) {
		TravelDeskDetailsSoap soapModel = new TravelDeskDetailsSoap();

		soapModel.setTravelDetailsId(model.getTravelDetailsId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setProjectTeamsId(model.getProjectTeamsId());
		soapModel.setTicketType(model.getTicketType());
		soapModel.setHotel(model.isHotel());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setFromTime(model.getFromTime());
		soapModel.setToTime(model.getToTime());
		soapModel.setLocation(model.getLocation());
		soapModel.setPurpose(model.getPurpose());
		soapModel.setSpecialInstraction(model.getSpecialInstraction());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setManagerComment(model.getManagerComment());

		return soapModel;
	}

	public static TravelDeskDetailsSoap[] toSoapModels(
		TravelDeskDetails[] models) {
		TravelDeskDetailsSoap[] soapModels = new TravelDeskDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TravelDeskDetailsSoap[][] toSoapModels(
		TravelDeskDetails[][] models) {
		TravelDeskDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TravelDeskDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TravelDeskDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TravelDeskDetailsSoap[] toSoapModels(
		List<TravelDeskDetails> models) {
		List<TravelDeskDetailsSoap> soapModels = new ArrayList<TravelDeskDetailsSoap>(models.size());

		for (TravelDeskDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TravelDeskDetailsSoap[soapModels.size()]);
	}

	public TravelDeskDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _travelDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setTravelDetailsId(pk);
	}

	public long getTravelDetailsId() {
		return _travelDetailsId;
	}

	public void setTravelDetailsId(long travelDetailsId) {
		_travelDetailsId = travelDetailsId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getProjectTeamsId() {
		return _projectTeamsId;
	}

	public void setProjectTeamsId(long projectTeamsId) {
		_projectTeamsId = projectTeamsId;
	}

	public String getTicketType() {
		return _ticketType;
	}

	public void setTicketType(String ticketType) {
		_ticketType = ticketType;
	}

	public boolean getHotel() {
		return _hotel;
	}

	public boolean isHotel() {
		return _hotel;
	}

	public void setHotel(boolean hotel) {
		_hotel = hotel;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getFromTime() {
		return _fromTime;
	}

	public void setFromTime(String fromTime) {
		_fromTime = fromTime;
	}

	public String getToTime() {
		return _toTime;
	}

	public void setToTime(String toTime) {
		_toTime = toTime;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getPurpose() {
		return _purpose;
	}

	public void setPurpose(String purpose) {
		_purpose = purpose;
	}

	public String getSpecialInstraction() {
		return _specialInstraction;
	}

	public void setSpecialInstraction(String specialInstraction) {
		_specialInstraction = specialInstraction;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getManagerComment() {
		return _managerComment;
	}

	public void setManagerComment(String managerComment) {
		_managerComment = managerComment;
	}

	private long _travelDetailsId;
	private long _employeeId;
	private long _companyId;
	private long _userId;
	private long _projectId;
	private long _projectTeamsId;
	private String _ticketType;
	private boolean _hotel;
	private Date _fromDate;
	private Date _toDate;
	private String _fromTime;
	private String _toTime;
	private String _location;
	private String _purpose;
	private String _specialInstraction;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private String _managerComment;
}