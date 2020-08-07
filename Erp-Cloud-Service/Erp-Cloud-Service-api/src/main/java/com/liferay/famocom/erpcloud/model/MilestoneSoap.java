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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.MilestoneServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.MilestoneServiceSoap
 * @generated
 */
@ProviderType
public class MilestoneSoap implements Serializable {
	public static MilestoneSoap toSoapModel(Milestone model) {
		MilestoneSoap soapModel = new MilestoneSoap();

		soapModel.setMilestoneId(model.getMilestoneId());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setClientId(model.getClientId());
		soapModel.setMilestoneName(model.getMilestoneName());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setCheckGST(model.getCheckGST());
		soapModel.setAmount(model.getAmount());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static MilestoneSoap[] toSoapModels(Milestone[] models) {
		MilestoneSoap[] soapModels = new MilestoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MilestoneSoap[][] toSoapModels(Milestone[][] models) {
		MilestoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MilestoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MilestoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MilestoneSoap[] toSoapModels(List<Milestone> models) {
		List<MilestoneSoap> soapModels = new ArrayList<MilestoneSoap>(models.size());

		for (Milestone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MilestoneSoap[soapModels.size()]);
	}

	public MilestoneSoap() {
	}

	public long getPrimaryKey() {
		return _milestoneId;
	}

	public void setPrimaryKey(long pk) {
		setMilestoneId(pk);
	}

	public long getMilestoneId() {
		return _milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		_milestoneId = milestoneId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _milestoneId;
	private long _projectId;
	private long _clientId;
	private String _milestoneName;
	private Date _dueDate;
	private int _checkGST;
	private double _amount;
	private int _status;
}