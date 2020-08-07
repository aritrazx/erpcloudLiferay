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
 * This class is used by SOAP remote services.
 *
 * @author Samaresh
 * @generated
 */
@ProviderType
public class TaxSettingSoap implements Serializable {
	public static TaxSettingSoap toSoapModel(TaxSetting model) {
		TaxSettingSoap soapModel = new TaxSettingSoap();

		soapModel.setTaxSettingId(model.getTaxSettingId());
		soapModel.setComponentId(model.getComponentId());
		soapModel.setComponentName(model.getComponentName());
		soapModel.setTaxFormulla(model.getTaxFormulla());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TaxSettingSoap[] toSoapModels(TaxSetting[] models) {
		TaxSettingSoap[] soapModels = new TaxSettingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaxSettingSoap[][] toSoapModels(TaxSetting[][] models) {
		TaxSettingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaxSettingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaxSettingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaxSettingSoap[] toSoapModels(List<TaxSetting> models) {
		List<TaxSettingSoap> soapModels = new ArrayList<TaxSettingSoap>(models.size());

		for (TaxSetting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaxSettingSoap[soapModels.size()]);
	}

	public TaxSettingSoap() {
	}

	public long getPrimaryKey() {
		return _taxSettingId;
	}

	public void setPrimaryKey(long pk) {
		setTaxSettingId(pk);
	}

	public long getTaxSettingId() {
		return _taxSettingId;
	}

	public void setTaxSettingId(long taxSettingId) {
		_taxSettingId = taxSettingId;
	}

	public long getComponentId() {
		return _componentId;
	}

	public void setComponentId(long componentId) {
		_componentId = componentId;
	}

	public String getComponentName() {
		return _componentName;
	}

	public void setComponentName(String componentName) {
		_componentName = componentName;
	}

	public String getTaxFormulla() {
		return _taxFormulla;
	}

	public void setTaxFormulla(String taxFormulla) {
		_taxFormulla = taxFormulla;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _taxSettingId;
	private long _componentId;
	private String _componentName;
	private String _taxFormulla;
	private long _createdBy;
	private Date _createdDate;
	private Date _modifiedDate;
}