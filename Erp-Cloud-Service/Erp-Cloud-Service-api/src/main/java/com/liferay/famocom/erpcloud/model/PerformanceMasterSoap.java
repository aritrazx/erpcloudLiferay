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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.PerformanceMasterServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.PerformanceMasterServiceSoap
 * @generated
 */
@ProviderType
public class PerformanceMasterSoap implements Serializable {
	public static PerformanceMasterSoap toSoapModel(PerformanceMaster model) {
		PerformanceMasterSoap soapModel = new PerformanceMasterSoap();

		soapModel.setPerformanceId(model.getPerformanceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPerformanceHeading(model.getPerformanceHeading());
		soapModel.setPerformanceDescription(model.getPerformanceDescription());
		soapModel.setAddedDate(model.getAddedDate());

		return soapModel;
	}

	public static PerformanceMasterSoap[] toSoapModels(
		PerformanceMaster[] models) {
		PerformanceMasterSoap[] soapModels = new PerformanceMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PerformanceMasterSoap[][] toSoapModels(
		PerformanceMaster[][] models) {
		PerformanceMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PerformanceMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PerformanceMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PerformanceMasterSoap[] toSoapModels(
		List<PerformanceMaster> models) {
		List<PerformanceMasterSoap> soapModels = new ArrayList<PerformanceMasterSoap>(models.size());

		for (PerformanceMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PerformanceMasterSoap[soapModels.size()]);
	}

	public PerformanceMasterSoap() {
	}

	public long getPrimaryKey() {
		return _performanceId;
	}

	public void setPrimaryKey(long pk) {
		setPerformanceId(pk);
	}

	public long getPerformanceId() {
		return _performanceId;
	}

	public void setPerformanceId(long performanceId) {
		_performanceId = performanceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getPerformanceHeading() {
		return _performanceHeading;
	}

	public void setPerformanceHeading(String performanceHeading) {
		_performanceHeading = performanceHeading;
	}

	public String getPerformanceDescription() {
		return _performanceDescription;
	}

	public void setPerformanceDescription(String performanceDescription) {
		_performanceDescription = performanceDescription;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	private long _performanceId;
	private long _companyId;
	private String _performanceHeading;
	private String _performanceDescription;
	private Date _addedDate;
}