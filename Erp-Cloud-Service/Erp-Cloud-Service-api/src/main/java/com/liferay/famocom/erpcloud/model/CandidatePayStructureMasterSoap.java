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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.CandidatePayStructureMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.CandidatePayStructureMasterServiceSoap
 * @generated
 */
@ProviderType
public class CandidatePayStructureMasterSoap implements Serializable {
	public static CandidatePayStructureMasterSoap toSoapModel(
		CandidatePayStructureMaster model) {
		CandidatePayStructureMasterSoap soapModel = new CandidatePayStructureMasterSoap();

		soapModel.setCandidatePayStructureMasterId(model.getCandidatePayStructureMasterId());
		soapModel.setRecruitmentProcessId(model.getRecruitmentProcessId());
		soapModel.setTotalAmount(model.getTotalAmount());
		soapModel.setTotalBonus(model.getTotalBonus());
		soapModel.setPayMasterStatus(model.getPayMasterStatus());
		soapModel.setJoiningDate(model.getJoiningDate());
		soapModel.setCandidateBond(model.getCandidateBond());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CandidatePayStructureMasterSoap[] toSoapModels(
		CandidatePayStructureMaster[] models) {
		CandidatePayStructureMasterSoap[] soapModels = new CandidatePayStructureMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidatePayStructureMasterSoap[][] toSoapModels(
		CandidatePayStructureMaster[][] models) {
		CandidatePayStructureMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidatePayStructureMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidatePayStructureMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidatePayStructureMasterSoap[] toSoapModels(
		List<CandidatePayStructureMaster> models) {
		List<CandidatePayStructureMasterSoap> soapModels = new ArrayList<CandidatePayStructureMasterSoap>(models.size());

		for (CandidatePayStructureMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidatePayStructureMasterSoap[soapModels.size()]);
	}

	public CandidatePayStructureMasterSoap() {
	}

	public long getPrimaryKey() {
		return _candidatePayStructureMasterId;
	}

	public void setPrimaryKey(long pk) {
		setCandidatePayStructureMasterId(pk);
	}

	public long getCandidatePayStructureMasterId() {
		return _candidatePayStructureMasterId;
	}

	public void setCandidatePayStructureMasterId(
		long candidatePayStructureMasterId) {
		_candidatePayStructureMasterId = candidatePayStructureMasterId;
	}

	public long getRecruitmentProcessId() {
		return _recruitmentProcessId;
	}

	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_recruitmentProcessId = recruitmentProcessId;
	}

	public double getTotalAmount() {
		return _totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		_totalAmount = totalAmount;
	}

	public double getTotalBonus() {
		return _totalBonus;
	}

	public void setTotalBonus(double totalBonus) {
		_totalBonus = totalBonus;
	}

	public int getPayMasterStatus() {
		return _payMasterStatus;
	}

	public void setPayMasterStatus(int payMasterStatus) {
		_payMasterStatus = payMasterStatus;
	}

	public Date getJoiningDate() {
		return _joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		_joiningDate = joiningDate;
	}

	public String getCandidateBond() {
		return _candidateBond;
	}

	public void setCandidateBond(String candidateBond) {
		_candidateBond = candidateBond;
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

	private long _candidatePayStructureMasterId;
	private long _recruitmentProcessId;
	private double _totalAmount;
	private double _totalBonus;
	private int _payMasterStatus;
	private Date _joiningDate;
	private String _candidateBond;
	private Date _createDate;
	private Date _modifiedDate;
}