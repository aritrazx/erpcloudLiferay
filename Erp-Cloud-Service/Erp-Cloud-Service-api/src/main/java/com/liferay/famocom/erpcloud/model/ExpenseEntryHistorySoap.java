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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ExpenseEntryHistoryServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ExpenseEntryHistoryServiceSoap
 * @generated
 */
@ProviderType
public class ExpenseEntryHistorySoap implements Serializable {
	public static ExpenseEntryHistorySoap toSoapModel(ExpenseEntryHistory model) {
		ExpenseEntryHistorySoap soapModel = new ExpenseEntryHistorySoap();

		soapModel.setExpenseHistoryId(model.getExpenseHistoryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setExpenseId(model.getExpenseId());
		soapModel.setStatus(model.getStatus());
		soapModel.setManEmployeeId(model.getManEmployeeId());
		soapModel.setManComments(model.getManComments());
		soapModel.setAddeddate(model.getAddeddate());

		return soapModel;
	}

	public static ExpenseEntryHistorySoap[] toSoapModels(
		ExpenseEntryHistory[] models) {
		ExpenseEntryHistorySoap[] soapModels = new ExpenseEntryHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpenseEntryHistorySoap[][] toSoapModels(
		ExpenseEntryHistory[][] models) {
		ExpenseEntryHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpenseEntryHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpenseEntryHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpenseEntryHistorySoap[] toSoapModels(
		List<ExpenseEntryHistory> models) {
		List<ExpenseEntryHistorySoap> soapModels = new ArrayList<ExpenseEntryHistorySoap>(models.size());

		for (ExpenseEntryHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpenseEntryHistorySoap[soapModels.size()]);
	}

	public ExpenseEntryHistorySoap() {
	}

	public long getPrimaryKey() {
		return _expenseHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setExpenseHistoryId(pk);
	}

	public long getExpenseHistoryId() {
		return _expenseHistoryId;
	}

	public void setExpenseHistoryId(long expenseHistoryId) {
		_expenseHistoryId = expenseHistoryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getExpenseId() {
		return _expenseId;
	}

	public void setExpenseId(long expenseId) {
		_expenseId = expenseId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getManEmployeeId() {
		return _manEmployeeId;
	}

	public void setManEmployeeId(long manEmployeeId) {
		_manEmployeeId = manEmployeeId;
	}

	public String getManComments() {
		return _manComments;
	}

	public void setManComments(String manComments) {
		_manComments = manComments;
	}

	public Date getAddeddate() {
		return _addeddate;
	}

	public void setAddeddate(Date addeddate) {
		_addeddate = addeddate;
	}

	private long _expenseHistoryId;
	private long _companyId;
	private long _expenseId;
	private int _status;
	private long _manEmployeeId;
	private String _manComments;
	private Date _addeddate;
}