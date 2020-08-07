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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.HolidayCalenderManagementServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.HolidayCalenderManagementServiceSoap
 * @generated
 */
@ProviderType
public class HolidayCalenderManagementSoap implements Serializable {
	public static HolidayCalenderManagementSoap toSoapModel(
		HolidayCalenderManagement model) {
		HolidayCalenderManagementSoap soapModel = new HolidayCalenderManagementSoap();

		soapModel.setHolidayId(model.getHolidayId());
		soapModel.setHolidayDate(model.getHolidayDate());
		soapModel.setHolidayName(model.getHolidayName());
		soapModel.setHolidayStartDate(model.getHolidayStartDate());
		soapModel.setHolidayEndDate(model.getHolidayEndDate());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static HolidayCalenderManagementSoap[] toSoapModels(
		HolidayCalenderManagement[] models) {
		HolidayCalenderManagementSoap[] soapModels = new HolidayCalenderManagementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HolidayCalenderManagementSoap[][] toSoapModels(
		HolidayCalenderManagement[][] models) {
		HolidayCalenderManagementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HolidayCalenderManagementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HolidayCalenderManagementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HolidayCalenderManagementSoap[] toSoapModels(
		List<HolidayCalenderManagement> models) {
		List<HolidayCalenderManagementSoap> soapModels = new ArrayList<HolidayCalenderManagementSoap>(models.size());

		for (HolidayCalenderManagement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HolidayCalenderManagementSoap[soapModels.size()]);
	}

	public HolidayCalenderManagementSoap() {
	}

	public long getPrimaryKey() {
		return _holidayId;
	}

	public void setPrimaryKey(long pk) {
		setHolidayId(pk);
	}

	public long getHolidayId() {
		return _holidayId;
	}

	public void setHolidayId(long holidayId) {
		_holidayId = holidayId;
	}

	public Date getHolidayDate() {
		return _holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		_holidayDate = holidayDate;
	}

	public String getHolidayName() {
		return _holidayName;
	}

	public void setHolidayName(String holidayName) {
		_holidayName = holidayName;
	}

	public Date getHolidayStartDate() {
		return _holidayStartDate;
	}

	public void setHolidayStartDate(Date holidayStartDate) {
		_holidayStartDate = holidayStartDate;
	}

	public Date getHolidayEndDate() {
		return _holidayEndDate;
	}

	public void setHolidayEndDate(Date holidayEndDate) {
		_holidayEndDate = holidayEndDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private long _holidayId;
	private Date _holidayDate;
	private String _holidayName;
	private Date _holidayStartDate;
	private Date _holidayEndDate;
	private long _companyId;
}