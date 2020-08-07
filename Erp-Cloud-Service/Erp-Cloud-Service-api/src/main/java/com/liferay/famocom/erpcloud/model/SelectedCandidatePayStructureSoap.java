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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.SelectedCandidatePayStructureServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.SelectedCandidatePayStructureServiceSoap
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureSoap implements Serializable {
	public static SelectedCandidatePayStructureSoap toSoapModel(
		SelectedCandidatePayStructure model) {
		SelectedCandidatePayStructureSoap soapModel = new SelectedCandidatePayStructureSoap();

		soapModel.setCandidatePayStructureId(model.getCandidatePayStructureId());
		soapModel.setPayComponentId(model.getPayComponentId());
		soapModel.setComponentValue(model.getComponentValue());
		soapModel.setRecruitmentProcessId(model.getRecruitmentProcessId());
		soapModel.setPayStatus(model.getPayStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SelectedCandidatePayStructureSoap[] toSoapModels(
		SelectedCandidatePayStructure[] models) {
		SelectedCandidatePayStructureSoap[] soapModels = new SelectedCandidatePayStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SelectedCandidatePayStructureSoap[][] toSoapModels(
		SelectedCandidatePayStructure[][] models) {
		SelectedCandidatePayStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SelectedCandidatePayStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SelectedCandidatePayStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SelectedCandidatePayStructureSoap[] toSoapModels(
		List<SelectedCandidatePayStructure> models) {
		List<SelectedCandidatePayStructureSoap> soapModels = new ArrayList<SelectedCandidatePayStructureSoap>(models.size());

		for (SelectedCandidatePayStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SelectedCandidatePayStructureSoap[soapModels.size()]);
	}

	public SelectedCandidatePayStructureSoap() {
	}

	public long getPrimaryKey() {
		return _candidatePayStructureId;
	}

	public void setPrimaryKey(long pk) {
		setCandidatePayStructureId(pk);
	}

	public long getCandidatePayStructureId() {
		return _candidatePayStructureId;
	}

	public void setCandidatePayStructureId(long candidatePayStructureId) {
		_candidatePayStructureId = candidatePayStructureId;
	}

	public long getPayComponentId() {
		return _payComponentId;
	}

	public void setPayComponentId(long payComponentId) {
		_payComponentId = payComponentId;
	}

	public double getComponentValue() {
		return _componentValue;
	}

	public void setComponentValue(double componentValue) {
		_componentValue = componentValue;
	}

	public long getRecruitmentProcessId() {
		return _recruitmentProcessId;
	}

	public void setRecruitmentProcessId(long recruitmentProcessId) {
		_recruitmentProcessId = recruitmentProcessId;
	}

	public int getPayStatus() {
		return _payStatus;
	}

	public void setPayStatus(int payStatus) {
		_payStatus = payStatus;
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

	private long _candidatePayStructureId;
	private long _payComponentId;
	private double _componentValue;
	private long _recruitmentProcessId;
	private int _payStatus;
	private Date _createDate;
	private Date _modifiedDate;
}