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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.EmployeeTypeServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.EmployeeTypeServiceSoap
 * @generated
 */
@ProviderType
public class EmployeeTypeSoap implements Serializable {
	public static EmployeeTypeSoap toSoapModel(EmployeeType model) {
		EmployeeTypeSoap soapModel = new EmployeeTypeSoap();

		soapModel.setEmployeetypeId(model.getEmployeetypeId());
		soapModel.setTypeName(model.getTypeName());
		soapModel.setPfDeduct(model.getPfDeduct());
		soapModel.setStatus(model.getStatus());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAddeddate(model.getAddeddate());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static EmployeeTypeSoap[] toSoapModels(EmployeeType[] models) {
		EmployeeTypeSoap[] soapModels = new EmployeeTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTypeSoap[][] toSoapModels(EmployeeType[][] models) {
		EmployeeTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTypeSoap[] toSoapModels(List<EmployeeType> models) {
		List<EmployeeTypeSoap> soapModels = new ArrayList<EmployeeTypeSoap>(models.size());

		for (EmployeeType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeTypeSoap[soapModels.size()]);
	}

	public EmployeeTypeSoap() {
	}

	public long getPrimaryKey() {
		return _employeetypeId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeetypeId(pk);
	}

	public long getEmployeetypeId() {
		return _employeetypeId;
	}

	public void setEmployeetypeId(long employeetypeId) {
		_employeetypeId = employeetypeId;
	}

	public String getTypeName() {
		return _typeName;
	}

	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	public long getPfDeduct() {
		return _pfDeduct;
	}

	public void setPfDeduct(long pfDeduct) {
		_pfDeduct = pfDeduct;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getAddeddate() {
		return _addeddate;
	}

	public void setAddeddate(Date addeddate) {
		_addeddate = addeddate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _employeetypeId;
	private String _typeName;
	private long _pfDeduct;
	private int _status;
	private long _companyId;
	private Date _addeddate;
	private String _description;
}