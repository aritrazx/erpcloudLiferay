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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.BillingTableServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.BillingTableServiceSoap
 * @generated
 */
@ProviderType
public class BillingTableSoap implements Serializable {
	public static BillingTableSoap toSoapModel(BillingTable model) {
		BillingTableSoap soapModel = new BillingTableSoap();

		soapModel.setBillingId(model.getBillingId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setClientId(model.getClientId());
		soapModel.setMilestoneName(model.getMilestoneName());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setCheckGST(model.getCheckGST());
		soapModel.setAmount(model.getAmount());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileName(model.getFileName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static BillingTableSoap[] toSoapModels(BillingTable[] models) {
		BillingTableSoap[] soapModels = new BillingTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BillingTableSoap[][] toSoapModels(BillingTable[][] models) {
		BillingTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BillingTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BillingTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BillingTableSoap[] toSoapModels(List<BillingTable> models) {
		List<BillingTableSoap> soapModels = new ArrayList<BillingTableSoap>(models.size());

		for (BillingTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BillingTableSoap[soapModels.size()]);
	}

	public BillingTableSoap() {
	}

	public long getPrimaryKey() {
		return _billingId;
	}

	public void setPrimaryKey(long pk) {
		setBillingId(pk);
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getMilestoneName() {
		return _milestoneName;
	}

	public void setMilestoneName(String milestoneName) {
		_milestoneName = milestoneName;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public int getCheckGST() {
		return _checkGST;
	}

	public void setCheckGST(int checkGST) {
		_checkGST = checkGST;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _billingId;
	private long _projectId;
	private long _clientId;
	private String _milestoneName;
	private Date _dueDate;
	private int _checkGST;
	private double _amount;
	private long _fileId;
	private String _fileName;
	private int _status;
}