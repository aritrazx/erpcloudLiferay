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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.SalDetailsServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.SalDetailsServiceSoap
 * @generated
 */
@ProviderType
public class SalDetailsSoap implements Serializable {
	public static SalDetailsSoap toSoapModel(SalDetails model) {
		SalDetailsSoap soapModel = new SalDetailsSoap();

		soapModel.setSalDetailsId(model.getSalDetailsId());
		soapModel.setMonthYear(model.getMonthYear());
		soapModel.setComponentId(model.getComponentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static SalDetailsSoap[] toSoapModels(SalDetails[] models) {
		SalDetailsSoap[] soapModels = new SalDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SalDetailsSoap[][] toSoapModels(SalDetails[][] models) {
		SalDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SalDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SalDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SalDetailsSoap[] toSoapModels(List<SalDetails> models) {
		List<SalDetailsSoap> soapModels = new ArrayList<SalDetailsSoap>(models.size());

		for (SalDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SalDetailsSoap[soapModels.size()]);
	}

	public SalDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _SalDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setSalDetailsId(pk);
	}

	public long getSalDetailsId() {
		return _SalDetailsId;
	}

	public void setSalDetailsId(long SalDetailsId) {
		_SalDetailsId = SalDetailsId;
	}

	public long getMonthYear() {
		return _monthYear;
	}

	public void setMonthYear(long monthYear) {
		_monthYear = monthYear;
	}

	public long getComponentId() {
		return _componentId;
	}

	public void setComponentId(long componentId) {
		_componentId = componentId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	private long _SalDetailsId;
	private long _monthYear;
	private long _componentId;
	private long _employeeId;
	private double _value;
}