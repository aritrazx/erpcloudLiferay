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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ExpenseServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ExpenseServiceSoap
 * @generated
 */
@ProviderType
public class ExpenseSoap implements Serializable {
	public static ExpenseSoap toSoapModel(Expense model) {
		ExpenseSoap soapModel = new ExpenseSoap();

		soapModel.setExpenseId(model.getExpenseId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setCatId(model.getCatId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setExpDate(model.getExpDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setStatus(model.getStatus());
		soapModel.setManEmployeeId(model.getManEmployeeId());
		soapModel.setManCommnets(model.getManCommnets());
		soapModel.setManApprovedDate(model.getManApprovedDate());
		soapModel.setAccComments(model.getAccComments());
		soapModel.setAccApprovedDate(model.getAccApprovedDate());
		soapModel.setMonthYear(model.getMonthYear());

		return soapModel;
	}

	public static ExpenseSoap[] toSoapModels(Expense[] models) {
		ExpenseSoap[] soapModels = new ExpenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpenseSoap[][] toSoapModels(Expense[][] models) {
		ExpenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpenseSoap[] toSoapModels(List<Expense> models) {
		List<ExpenseSoap> soapModels = new ArrayList<ExpenseSoap>(models.size());

		for (Expense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpenseSoap[soapModels.size()]);
	}

	public ExpenseSoap() {
	}

	public long getPrimaryKey() {
		return _expenseId;
	}

	public void setPrimaryKey(long pk) {
		setExpenseId(pk);
	}

	public long getExpenseId() {
		return _expenseId;
	}

	public void setExpenseId(long expenseId) {
		_expenseId = expenseId;
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

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getCatId() {
		return _catId;
	}

	public void setCatId(long catId) {
		_catId = catId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getExpDate() {
		return _expDate;
	}

	public void setExpDate(Date expDate) {
		_expDate = expDate;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
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

	public String getManCommnets() {
		return _manCommnets;
	}

	public void setManCommnets(String manCommnets) {
		_manCommnets = manCommnets;
	}

	public Date getManApprovedDate() {
		return _manApprovedDate;
	}

	public void setManApprovedDate(Date manApprovedDate) {
		_manApprovedDate = manApprovedDate;
	}

	public String getAccComments() {
		return _accComments;
	}

	public void setAccComments(String accComments) {
		_accComments = accComments;
	}

	public Date getAccApprovedDate() {
		return _accApprovedDate;
	}

	public void setAccApprovedDate(Date accApprovedDate) {
		_accApprovedDate = accApprovedDate;
	}

	public long getMonthYear() {
		return _monthYear;
	}

	public void setMonthYear(long monthYear) {
		_monthYear = monthYear;
	}

	private long _expenseId;
	private long _employeeId;
	private long _companyId;
	private long _projectId;
	private long _catId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private Date _expDate;
	private double _amount;
	private int _status;
	private long _manEmployeeId;
	private String _manCommnets;
	private Date _manApprovedDate;
	private String _accComments;
	private Date _accApprovedDate;
	private long _monthYear;
}