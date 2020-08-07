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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.BillingServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.BillingServiceSoap
 * @generated
 */
@ProviderType
public class BillingSoap implements Serializable {
	public static BillingSoap toSoapModel(Billing model) {
		BillingSoap soapModel = new BillingSoap();

		soapModel.setBillingId(model.getBillingId());
		soapModel.setMilestoneId(model.getMilestoneId());
		soapModel.setBillingNumber(model.getBillingNumber());
		soapModel.setBillingDate(model.getBillingDate());

		return soapModel;
	}

	public static BillingSoap[] toSoapModels(Billing[] models) {
		BillingSoap[] soapModels = new BillingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BillingSoap[][] toSoapModels(Billing[][] models) {
		BillingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BillingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BillingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BillingSoap[] toSoapModels(List<Billing> models) {
		List<BillingSoap> soapModels = new ArrayList<BillingSoap>(models.size());

		for (Billing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BillingSoap[soapModels.size()]);
	}

	public BillingSoap() {
	}

	public long getPrimaryKey() {
		return _billingId;
	}

	public void setPrimaryKey(long pk) {
		setBillingId(pk);
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
	}

	public long getMilestoneId() {
		return _milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		_milestoneId = milestoneId;
	}

	public String getBillingNumber() {
		return _billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		_billingNumber = billingNumber;
	}

	public String getBillingDate() {
		return _billingDate;
	}

	public void setBillingDate(String billingDate) {
		_billingDate = billingDate;
	}

	private long _billingId;
	private long _milestoneId;
	private String _billingNumber;
	private String _billingDate;
}