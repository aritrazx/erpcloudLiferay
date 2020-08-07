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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.SchedulesMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.SchedulesMasterServiceSoap
 * @generated
 */
@ProviderType
public class SchedulesMasterSoap implements Serializable {
	public static SchedulesMasterSoap toSoapModel(SchedulesMaster model) {
		SchedulesMasterSoap soapModel = new SchedulesMasterSoap();

		soapModel.setSchedulesId(model.getSchedulesId());
		soapModel.setSchedulesName(model.getSchedulesName());
		soapModel.setSchedulesDescription(model.getSchedulesDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SchedulesMasterSoap[] toSoapModels(SchedulesMaster[] models) {
		SchedulesMasterSoap[] soapModels = new SchedulesMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SchedulesMasterSoap[][] toSoapModels(
		SchedulesMaster[][] models) {
		SchedulesMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SchedulesMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SchedulesMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SchedulesMasterSoap[] toSoapModels(
		List<SchedulesMaster> models) {
		List<SchedulesMasterSoap> soapModels = new ArrayList<SchedulesMasterSoap>(models.size());

		for (SchedulesMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SchedulesMasterSoap[soapModels.size()]);
	}

	public SchedulesMasterSoap() {
	}

	public long getPrimaryKey() {
		return _schedulesId;
	}

	public void setPrimaryKey(long pk) {
		setSchedulesId(pk);
	}

	public long getSchedulesId() {
		return _schedulesId;
	}

	public void setSchedulesId(long schedulesId) {
		_schedulesId = schedulesId;
	}

	public String getSchedulesName() {
		return _schedulesName;
	}

	public void setSchedulesName(String schedulesName) {
		_schedulesName = schedulesName;
	}

	public String getSchedulesDescription() {
		return _schedulesDescription;
	}

	public void setSchedulesDescription(String schedulesDescription) {
		_schedulesDescription = schedulesDescription;
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

	private long _schedulesId;
	private String _schedulesName;
	private String _schedulesDescription;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
}