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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.SchedulesDetailsServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.SchedulesDetailsServiceSoap
 * @generated
 */
@ProviderType
public class SchedulesDetailsSoap implements Serializable {
	public static SchedulesDetailsSoap toSoapModel(SchedulesDetails model) {
		SchedulesDetailsSoap soapModel = new SchedulesDetailsSoap();

		soapModel.setSchedulesDetailsId(model.getSchedulesDetailsId());
		soapModel.setSchedulesDate(model.getSchedulesDate());
		soapModel.setWorksSchedulesId(model.getWorksSchedulesId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static SchedulesDetailsSoap[] toSoapModels(SchedulesDetails[] models) {
		SchedulesDetailsSoap[] soapModels = new SchedulesDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SchedulesDetailsSoap[][] toSoapModels(
		SchedulesDetails[][] models) {
		SchedulesDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SchedulesDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SchedulesDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SchedulesDetailsSoap[] toSoapModels(
		List<SchedulesDetails> models) {
		List<SchedulesDetailsSoap> soapModels = new ArrayList<SchedulesDetailsSoap>(models.size());

		for (SchedulesDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SchedulesDetailsSoap[soapModels.size()]);
	}

	public SchedulesDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _schedulesDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setSchedulesDetailsId(pk);
	}

	public long getSchedulesDetailsId() {
		return _schedulesDetailsId;
	}

	public void setSchedulesDetailsId(long schedulesDetailsId) {
		_schedulesDetailsId = schedulesDetailsId;
	}

	public Date getSchedulesDate() {
		return _schedulesDate;
	}

	public void setSchedulesDate(Date schedulesDate) {
		_schedulesDate = schedulesDate;
	}

	public long getWorksSchedulesId() {
		return _worksSchedulesId;
	}

	public void setWorksSchedulesId(long worksSchedulesId) {
		_worksSchedulesId = worksSchedulesId;
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

	private long _schedulesDetailsId;
	private Date _schedulesDate;
	private long _worksSchedulesId;
	private long _employeeId;
	private long _companyId;
}