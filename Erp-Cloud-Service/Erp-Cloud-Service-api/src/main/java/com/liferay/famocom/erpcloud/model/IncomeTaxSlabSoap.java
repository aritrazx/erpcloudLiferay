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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Samaresh
 * @generated
 */
@ProviderType
public class IncomeTaxSlabSoap implements Serializable {
	public static IncomeTaxSlabSoap toSoapModel(IncomeTaxSlab model) {
		IncomeTaxSlabSoap soapModel = new IncomeTaxSlabSoap();

		soapModel.setIncomeTaxSlabId(model.getIncomeTaxSlabId());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setIncomeFrom(model.getIncomeFrom());
		soapModel.setIncomeTo(model.getIncomeTo());
		soapModel.setTaxRate(model.getTaxRate());

		return soapModel;
	}

	public static IncomeTaxSlabSoap[] toSoapModels(IncomeTaxSlab[] models) {
		IncomeTaxSlabSoap[] soapModels = new IncomeTaxSlabSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IncomeTaxSlabSoap[][] toSoapModels(IncomeTaxSlab[][] models) {
		IncomeTaxSlabSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IncomeTaxSlabSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IncomeTaxSlabSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IncomeTaxSlabSoap[] toSoapModels(List<IncomeTaxSlab> models) {
		List<IncomeTaxSlabSoap> soapModels = new ArrayList<IncomeTaxSlabSoap>(models.size());

		for (IncomeTaxSlab model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IncomeTaxSlabSoap[soapModels.size()]);
	}

	public IncomeTaxSlabSoap() {
	}

	public long getPrimaryKey() {
		return _incomeTaxSlabId;
	}

	public void setPrimaryKey(long pk) {
		setIncomeTaxSlabId(pk);
	}

	public long getIncomeTaxSlabId() {
		return _incomeTaxSlabId;
	}

	public void setIncomeTaxSlabId(long incomeTaxSlabId) {
		_incomeTaxSlabId = incomeTaxSlabId;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public int getIncomeFrom() {
		return _incomeFrom;
	}

	public void setIncomeFrom(int incomeFrom) {
		_incomeFrom = incomeFrom;
	}

	public int getIncomeTo() {
		return _incomeTo;
	}

	public void setIncomeTo(int incomeTo) {
		_incomeTo = incomeTo;
	}

	public double getTaxRate() {
		return _taxRate;
	}

	public void setTaxRate(double taxRate) {
		_taxRate = taxRate;
	}

	private long _incomeTaxSlabId;
	private String _financialYear;
	private long _companyId;
	private int _incomeFrom;
	private int _incomeTo;
	private double _taxRate;
}