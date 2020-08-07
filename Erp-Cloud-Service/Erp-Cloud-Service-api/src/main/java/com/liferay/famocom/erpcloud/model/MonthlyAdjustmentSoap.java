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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.MonthlyAdjustmentServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.MonthlyAdjustmentServiceSoap
 * @generated
 */
@ProviderType
public class MonthlyAdjustmentSoap implements Serializable {
	public static MonthlyAdjustmentSoap toSoapModel(MonthlyAdjustment model) {
		MonthlyAdjustmentSoap soapModel = new MonthlyAdjustmentSoap();

		soapModel.setMonthlyAdjustmentId(model.getMonthlyAdjustmentId());
		soapModel.setPayComponentId(model.getPayComponentId());
		soapModel.setAmount(model.getAmount());
		soapModel.setMonthYear(model.getMonthYear());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static MonthlyAdjustmentSoap[] toSoapModels(
		MonthlyAdjustment[] models) {
		MonthlyAdjustmentSoap[] soapModels = new MonthlyAdjustmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MonthlyAdjustmentSoap[][] toSoapModels(
		MonthlyAdjustment[][] models) {
		MonthlyAdjustmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MonthlyAdjustmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MonthlyAdjustmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MonthlyAdjustmentSoap[] toSoapModels(
		List<MonthlyAdjustment> models) {
		List<MonthlyAdjustmentSoap> soapModels = new ArrayList<MonthlyAdjustmentSoap>(models.size());

		for (MonthlyAdjustment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MonthlyAdjustmentSoap[soapModels.size()]);
	}

	public MonthlyAdjustmentSoap() {
	}

	public long getPrimaryKey() {
		return _monthlyAdjustmentId;
	}

	public void setPrimaryKey(long pk) {
		setMonthlyAdjustmentId(pk);
	}

	public long getMonthlyAdjustmentId() {
		return _monthlyAdjustmentId;
	}

	public void setMonthlyAdjustmentId(long monthlyAdjustmentId) {
		_monthlyAdjustmentId = monthlyAdjustmentId;
	}

	public long getPayComponentId() {
		return _payComponentId;
	}

	public void setPayComponentId(long payComponentId) {
		_payComponentId = payComponentId;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getMonthYear() {
		return _monthYear;
	}

	public void setMonthYear(long monthYear) {
		_monthYear = monthYear;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private long _monthlyAdjustmentId;
	private long _payComponentId;
	private double _amount;
	private long _monthYear;
	private long _employeeId;
}