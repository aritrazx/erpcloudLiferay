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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.YearSettingServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.YearSettingServiceSoap
 * @generated
 */
@ProviderType
public class YearSettingSoap implements Serializable {
	public static YearSettingSoap toSoapModel(YearSetting model) {
		YearSettingSoap soapModel = new YearSettingSoap();

		soapModel.setYearSettingId(model.getYearSettingId());
		soapModel.setFinancialYearStartDate(model.getFinancialYearStartDate());
		soapModel.setFinancialYearEndDate(model.getFinancialYearEndDate());
		soapModel.setCalendarStartDate(model.getCalendarStartDate());
		soapModel.setCalendarEndDate(model.getCalendarEndDate());
		soapModel.setIsActive(model.getIsActive());

		return soapModel;
	}

	public static YearSettingSoap[] toSoapModels(YearSetting[] models) {
		YearSettingSoap[] soapModels = new YearSettingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YearSettingSoap[][] toSoapModels(YearSetting[][] models) {
		YearSettingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YearSettingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YearSettingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YearSettingSoap[] toSoapModels(List<YearSetting> models) {
		List<YearSettingSoap> soapModels = new ArrayList<YearSettingSoap>(models.size());

		for (YearSetting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YearSettingSoap[soapModels.size()]);
	}

	public YearSettingSoap() {
	}

	public long getPrimaryKey() {
		return _yearSettingId;
	}

	public void setPrimaryKey(long pk) {
		setYearSettingId(pk);
	}

	public long getYearSettingId() {
		return _yearSettingId;
	}

	public void setYearSettingId(long yearSettingId) {
		_yearSettingId = yearSettingId;
	}

	public Date getFinancialYearStartDate() {
		return _financialYearStartDate;
	}

	public void setFinancialYearStartDate(Date financialYearStartDate) {
		_financialYearStartDate = financialYearStartDate;
	}

	public Date getFinancialYearEndDate() {
		return _financialYearEndDate;
	}

	public void setFinancialYearEndDate(Date financialYearEndDate) {
		_financialYearEndDate = financialYearEndDate;
	}

	public Date getCalendarStartDate() {
		return _calendarStartDate;
	}

	public void setCalendarStartDate(Date calendarStartDate) {
		_calendarStartDate = calendarStartDate;
	}

	public Date getCalendarEndDate() {
		return _calendarEndDate;
	}

	public void setCalendarEndDate(Date calendarEndDate) {
		_calendarEndDate = calendarEndDate;
	}

	public int getIsActive() {
		return _isActive;
	}

	public void setIsActive(int isActive) {
		_isActive = isActive;
	}

	private long _yearSettingId;
	private Date _financialYearStartDate;
	private Date _financialYearEndDate;
	private Date _calendarStartDate;
	private Date _calendarEndDate;
	private int _isActive;
}