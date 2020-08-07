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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.FinSalaryServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.FinSalaryServiceSoap
 * @generated
 */
@ProviderType
public class FinSalarySoap implements Serializable {
	public static FinSalarySoap toSoapModel(FinSalary model) {
		FinSalarySoap soapModel = new FinSalarySoap();

		soapModel.setFinSalaryId(model.getFinSalaryId());
		soapModel.setMonthYear(model.getMonthYear());
		soapModel.setTotalEarning(model.getTotalEarning());
		soapModel.setTotalDeduction(model.getTotalDeduction());
		soapModel.setTotalAmount(model.getTotalAmount());
		soapModel.setIsLock(model.getIsLock());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static FinSalarySoap[] toSoapModels(FinSalary[] models) {
		FinSalarySoap[] soapModels = new FinSalarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FinSalarySoap[][] toSoapModels(FinSalary[][] models) {
		FinSalarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FinSalarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FinSalarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FinSalarySoap[] toSoapModels(List<FinSalary> models) {
		List<FinSalarySoap> soapModels = new ArrayList<FinSalarySoap>(models.size());

		for (FinSalary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FinSalarySoap[soapModels.size()]);
	}

	public FinSalarySoap() {
	}

	public long getPrimaryKey() {
		return _finSalaryId;
	}

	public void setPrimaryKey(long pk) {
		setFinSalaryId(pk);
	}

	public long getFinSalaryId() {
		return _finSalaryId;
	}

	public void setFinSalaryId(long finSalaryId) {
		_finSalaryId = finSalaryId;
	}

	public long getMonthYear() {
		return _monthYear;
	}

	public void setMonthYear(long monthYear) {
		_monthYear = monthYear;
	}

	public double getTotalEarning() {
		return _totalEarning;
	}

	public void setTotalEarning(double totalEarning) {
		_totalEarning = totalEarning;
	}

	public double getTotalDeduction() {
		return _totalDeduction;
	}

	public void setTotalDeduction(double totalDeduction) {
		_totalDeduction = totalDeduction;
	}

	public double getTotalAmount() {
		return _totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		_totalAmount = totalAmount;
	}

	public long getIsLock() {
		return _isLock;
	}

	public void setIsLock(long isLock) {
		_isLock = isLock;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _finSalaryId;
	private long _monthYear;
	private double _totalEarning;
	private double _totalDeduction;
	private double _totalAmount;
	private long _isLock;
	private long _createdBy;
	private Date _createdDate;
}