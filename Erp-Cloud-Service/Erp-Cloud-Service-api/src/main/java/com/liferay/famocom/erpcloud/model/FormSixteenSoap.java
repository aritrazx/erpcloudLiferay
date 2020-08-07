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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.FormSixteenServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.FormSixteenServiceSoap
 * @generated
 */
@ProviderType
public class FormSixteenSoap implements Serializable {
	public static FormSixteenSoap toSoapModel(FormSixteen model) {
		FormSixteenSoap soapModel = new FormSixteenSoap();

		soapModel.setId(model.getId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setFileEnteryId(model.getFileEnteryId());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static FormSixteenSoap[] toSoapModels(FormSixteen[] models) {
		FormSixteenSoap[] soapModels = new FormSixteenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormSixteenSoap[][] toSoapModels(FormSixteen[][] models) {
		FormSixteenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormSixteenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormSixteenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormSixteenSoap[] toSoapModels(List<FormSixteen> models) {
		List<FormSixteenSoap> soapModels = new ArrayList<FormSixteenSoap>(models.size());

		for (FormSixteen model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormSixteenSoap[soapModels.size()]);
	}

	public FormSixteenSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	public long getFileEnteryId() {
		return _fileEnteryId;
	}

	public void setFileEnteryId(long fileEnteryId) {
		_fileEnteryId = fileEnteryId;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _id;
	private long _employeeId;
	private String _financialYear;
	private long _fileEnteryId;
	private Date _addedDate;
}