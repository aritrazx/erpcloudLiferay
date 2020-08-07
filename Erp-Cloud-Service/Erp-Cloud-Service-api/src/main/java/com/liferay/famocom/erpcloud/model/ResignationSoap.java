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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ResignationServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ResignationServiceSoap
 * @generated
 */
@ProviderType
public class ResignationSoap implements Serializable {
	public static ResignationSoap toSoapModel(Resignation model) {
		ResignationSoap soapModel = new ResignationSoap();

		soapModel.setResignationId(model.getResignationId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setResignationDate(model.getResignationDate());
		soapModel.setResignationSubDate(model.getResignationSubDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setManagerId(model.getManagerId());
		soapModel.setMancomment(model.getMancomment());
		soapModel.setMancommentdate(model.getMancommentdate());
		soapModel.setStatus(model.isStatus());

		return soapModel;
	}

	public static ResignationSoap[] toSoapModels(Resignation[] models) {
		ResignationSoap[] soapModels = new ResignationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResignationSoap[][] toSoapModels(Resignation[][] models) {
		ResignationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResignationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResignationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResignationSoap[] toSoapModels(List<Resignation> models) {
		List<ResignationSoap> soapModels = new ArrayList<ResignationSoap>(models.size());

		for (Resignation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResignationSoap[soapModels.size()]);
	}

	public ResignationSoap() {
	}

	public long getPrimaryKey() {
		return _ResignationId;
	}

	public void setPrimaryKey(long pk) {
		setResignationId(pk);
	}

	public long getResignationId() {
		return _ResignationId;
	}

	public void setResignationId(long ResignationId) {
		_ResignationId = ResignationId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Date getResignationDate() {
		return _resignationDate;
	}

	public void setResignationDate(Date resignationDate) {
		_resignationDate = resignationDate;
	}

	public Date getResignationSubDate() {
		return _resignationSubDate;
	}

	public void setResignationSubDate(Date resignationSubDate) {
		_resignationSubDate = resignationSubDate;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public long getManagerId() {
		return _managerId;
	}

	public void setManagerId(long managerId) {
		_managerId = managerId;
	}

	public String getMancomment() {
		return _mancomment;
	}

	public void setMancomment(String mancomment) {
		_mancomment = mancomment;
	}

	public Date getMancommentdate() {
		return _mancommentdate;
	}

	public void setMancommentdate(Date mancommentdate) {
		_mancommentdate = mancommentdate;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	private long _ResignationId;
	private long _employeeId;
	private Date _resignationDate;
	private Date _resignationSubDate;
	private String _Description;
	private long _managerId;
	private String _mancomment;
	private Date _mancommentdate;
	private boolean _status;
}