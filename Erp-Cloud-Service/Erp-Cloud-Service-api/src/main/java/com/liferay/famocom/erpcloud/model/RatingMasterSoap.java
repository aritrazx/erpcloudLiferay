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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.RatingMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.RatingMasterServiceSoap
 * @generated
 */
@ProviderType
public class RatingMasterSoap implements Serializable {
	public static RatingMasterSoap toSoapModel(RatingMaster model) {
		RatingMasterSoap soapModel = new RatingMasterSoap();

		soapModel.setRatingId(model.getRatingId());
		soapModel.setRatingNum(model.getRatingNum());
		soapModel.setRatingKey(model.getRatingKey());
		soapModel.setRatingDescription(model.getRatingDescription());
		soapModel.setSalaryPercentage(model.getSalaryPercentage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static RatingMasterSoap[] toSoapModels(RatingMaster[] models) {
		RatingMasterSoap[] soapModels = new RatingMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RatingMasterSoap[][] toSoapModels(RatingMaster[][] models) {
		RatingMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RatingMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RatingMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RatingMasterSoap[] toSoapModels(List<RatingMaster> models) {
		List<RatingMasterSoap> soapModels = new ArrayList<RatingMasterSoap>(models.size());

		for (RatingMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RatingMasterSoap[soapModels.size()]);
	}

	public RatingMasterSoap() {
	}

	public long getPrimaryKey() {
		return _ratingId;
	}

	public void setPrimaryKey(long pk) {
		setRatingId(pk);
	}

	public long getRatingId() {
		return _ratingId;
	}

	public void setRatingId(long ratingId) {
		_ratingId = ratingId;
	}

	public String getRatingNum() {
		return _ratingNum;
	}

	public void setRatingNum(String ratingNum) {
		_ratingNum = ratingNum;
	}

	public String getRatingKey() {
		return _ratingKey;
	}

	public void setRatingKey(String ratingKey) {
		_ratingKey = ratingKey;
	}

	public String getRatingDescription() {
		return _ratingDescription;
	}

	public void setRatingDescription(String ratingDescription) {
		_ratingDescription = ratingDescription;
	}

	public long getSalaryPercentage() {
		return _salaryPercentage;
	}

	public void setSalaryPercentage(long salaryPercentage) {
		_salaryPercentage = salaryPercentage;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _ratingId;
	private String _ratingNum;
	private String _ratingKey;
	private String _ratingDescription;
	private long _salaryPercentage;
	private long _companyId;
	private Date _addedDate;
}