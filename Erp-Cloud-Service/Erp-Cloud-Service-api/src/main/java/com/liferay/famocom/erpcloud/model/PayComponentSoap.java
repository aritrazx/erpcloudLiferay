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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.PayComponentServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.PayComponentServiceSoap
 * @generated
 */
@ProviderType
public class PayComponentSoap implements Serializable {
	public static PayComponentSoap toSoapModel(PayComponent model) {
		PayComponentSoap soapModel = new PayComponentSoap();

		soapModel.setComponentId(model.getComponentId());
		soapModel.setEmployeeTypeId(model.getEmployeeTypeId());
		soapModel.setName(model.getName());
		soapModel.setAbbreviation(model.getAbbreviation());
		soapModel.setTaxStatus(model.getTaxStatus());
		soapModel.setPayType(model.getPayType());
		soapModel.setComponentType(model.getComponentType());
		soapModel.setComponentValueFormula(model.getComponentValueFormula());
		soapModel.setPartOfCtc(model.getPartOfCtc());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setIslock(model.getIslock());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setPayComponentOrder(model.getPayComponentOrder());
		soapModel.setAutoAddPayStructure(model.getAutoAddPayStructure());

		return soapModel;
	}

	public static PayComponentSoap[] toSoapModels(PayComponent[] models) {
		PayComponentSoap[] soapModels = new PayComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayComponentSoap[][] toSoapModels(PayComponent[][] models) {
		PayComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayComponentSoap[] toSoapModels(List<PayComponent> models) {
		List<PayComponentSoap> soapModels = new ArrayList<PayComponentSoap>(models.size());

		for (PayComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayComponentSoap[soapModels.size()]);
	}

	public PayComponentSoap() {
	}

	public long getPrimaryKey() {
		return _componentId;
	}

	public void setPrimaryKey(long pk) {
		setComponentId(pk);
	}

	public long getComponentId() {
		return _componentId;
	}

	public void setComponentId(long componentId) {
		_componentId = componentId;
	}

	public long getEmployeeTypeId() {
		return _employeeTypeId;
	}

	public void setEmployeeTypeId(long employeeTypeId) {
		_employeeTypeId = employeeTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public int getTaxStatus() {
		return _taxStatus;
	}

	public void setTaxStatus(int taxStatus) {
		_taxStatus = taxStatus;
	}

	public String getPayType() {
		return _payType;
	}

	public void setPayType(String payType) {
		_payType = payType;
	}

	public int getComponentType() {
		return _componentType;
	}

	public void setComponentType(int componentType) {
		_componentType = componentType;
	}

	public String getComponentValueFormula() {
		return _componentValueFormula;
	}

	public void setComponentValueFormula(String componentValueFormula) {
		_componentValueFormula = componentValueFormula;
	}

	public int getPartOfCtc() {
		return _partOfCtc;
	}

	public void setPartOfCtc(int partOfCtc) {
		_partOfCtc = partOfCtc;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public long getIslock() {
		return _islock;
	}

	public void setIslock(long islock) {
		_islock = islock;
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

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getPayComponentOrder() {
		return _payComponentOrder;
	}

	public void setPayComponentOrder(long payComponentOrder) {
		_payComponentOrder = payComponentOrder;
	}

	public int getAutoAddPayStructure() {
		return _autoAddPayStructure;
	}

	public void setAutoAddPayStructure(int autoAddPayStructure) {
		_autoAddPayStructure = autoAddPayStructure;
	}

	private long _componentId;
	private long _employeeTypeId;
	private String _name;
	private String _abbreviation;
	private int _taxStatus;
	private String _payType;
	private int _componentType;
	private String _componentValueFormula;
	private int _partOfCtc;
	private Date _effectiveDate;
	private long _islock;
	private Date _createDate;
	private Date _modifiedDate;
	private double _amount;
	private long _payComponentOrder;
	private int _autoAddPayStructure;
}