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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.BranchServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.BranchServiceSoap
 * @generated
 */
@ProviderType
public class BranchSoap implements Serializable {
	public static BranchSoap toSoapModel(Branch model) {
		BranchSoap soapModel = new BranchSoap();

		soapModel.setBranchId(model.getBranchId());
		soapModel.setBranchName(model.getBranchName());
		soapModel.setBranchAddress(model.getBranchAddress());
		soapModel.setStatus(model.getStatus());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedById(model.getCreatedById());

		return soapModel;
	}

	public static BranchSoap[] toSoapModels(Branch[] models) {
		BranchSoap[] soapModels = new BranchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BranchSoap[][] toSoapModels(Branch[][] models) {
		BranchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BranchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BranchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BranchSoap[] toSoapModels(List<Branch> models) {
		List<BranchSoap> soapModels = new ArrayList<BranchSoap>(models.size());

		for (Branch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BranchSoap[soapModels.size()]);
	}

	public BranchSoap() {
	}

	public long getPrimaryKey() {
		return _branchId;
	}

	public void setPrimaryKey(long pk) {
		setBranchId(pk);
	}

	public long getBranchId() {
		return _branchId;
	}

	public void setBranchId(long branchId) {
		_branchId = branchId;
	}

	public String getBranchName() {
		return _branchName;
	}

	public void setBranchName(String branchName) {
		_branchName = branchName;
	}

	public String getBranchAddress() {
		return _branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		_branchAddress = branchAddress;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedById() {
		return _createdById;
	}

	public void setCreatedById(long createdById) {
		_createdById = createdById;
	}

	private long _branchId;
	private String _branchName;
	private String _branchAddress;
	private int _status;
	private Date _modifiedDate;
	private Date _createDate;
	private long _createdById;
}