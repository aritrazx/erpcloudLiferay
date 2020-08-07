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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.LeaveObServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.LeaveObServiceSoap
 * @generated
 */
@ProviderType
public class LeaveObSoap implements Serializable {
	public static LeaveObSoap toSoapModel(LeaveOb model) {
		LeaveObSoap soapModel = new LeaveObSoap();

		soapModel.setLeaveobId(model.getLeaveobId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setObVal(model.getObVal());
		soapModel.setIsApprove(model.isIsApprove());

		return soapModel;
	}

	public static LeaveObSoap[] toSoapModels(LeaveOb[] models) {
		LeaveObSoap[] soapModels = new LeaveObSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveObSoap[][] toSoapModels(LeaveOb[][] models) {
		LeaveObSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveObSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveObSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveObSoap[] toSoapModels(List<LeaveOb> models) {
		List<LeaveObSoap> soapModels = new ArrayList<LeaveObSoap>(models.size());

		for (LeaveOb model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveObSoap[soapModels.size()]);
	}

	public LeaveObSoap() {
	}

	public long getPrimaryKey() {
		return _leaveobId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveobId(pk);
	}

	public long getLeaveobId() {
		return _leaveobId;
	}

	public void setLeaveobId(long leaveobId) {
		_leaveobId = leaveobId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
	}

	public int getObVal() {
		return _obVal;
	}

	public void setObVal(int obVal) {
		_obVal = obVal;
	}

	public boolean getIsApprove() {
		return _isApprove;
	}

	public boolean isIsApprove() {
		return _isApprove;
	}

	public void setIsApprove(boolean isApprove) {
		_isApprove = isApprove;
	}

	private long _leaveobId;
	private long _employeeId;
	private long _leaveTypeId;
	private int _obVal;
	private boolean _isApprove;
}