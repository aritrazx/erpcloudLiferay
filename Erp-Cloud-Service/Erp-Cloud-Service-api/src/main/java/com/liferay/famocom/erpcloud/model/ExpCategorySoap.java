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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.ExpCategoryServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.ExpCategoryServiceSoap
 * @generated
 */
@ProviderType
public class ExpCategorySoap implements Serializable {
	public static ExpCategorySoap toSoapModel(ExpCategory model) {
		ExpCategorySoap soapModel = new ExpCategorySoap();

		soapModel.setCatId(model.getCatId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setFrequency(model.getFrequency());
		soapModel.setSalaryHead(model.getSalaryHead());
		soapModel.setFinalApprovalRoleId(model.getFinalApprovalRoleId());
		soapModel.setAttachment(model.isAttachment());
		soapModel.setComponentId(model.getComponentId());

		return soapModel;
	}

	public static ExpCategorySoap[] toSoapModels(ExpCategory[] models) {
		ExpCategorySoap[] soapModels = new ExpCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpCategorySoap[][] toSoapModels(ExpCategory[][] models) {
		ExpCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpCategorySoap[] toSoapModels(List<ExpCategory> models) {
		List<ExpCategorySoap> soapModels = new ArrayList<ExpCategorySoap>(models.size());

		for (ExpCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpCategorySoap[soapModels.size()]);
	}

	public ExpCategorySoap() {
	}

	public long getPrimaryKey() {
		return _catId;
	}

	public void setPrimaryKey(long pk) {
		setCatId(pk);
	}

	public long getCatId() {
		return _catId;
	}

	public void setCatId(long catId) {
		_catId = catId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public String getFrequency() {
		return _frequency;
	}

	public void setFrequency(String frequency) {
		_frequency = frequency;
	}

	public long getSalaryHead() {
		return _salaryHead;
	}

	public void setSalaryHead(long salaryHead) {
		_salaryHead = salaryHead;
	}

	public long getFinalApprovalRoleId() {
		return _finalApprovalRoleId;
	}

	public void setFinalApprovalRoleId(long finalApprovalRoleId) {
		_finalApprovalRoleId = finalApprovalRoleId;
	}

	public boolean getAttachment() {
		return _attachment;
	}

	public boolean isAttachment() {
		return _attachment;
	}

	public void setAttachment(boolean attachment) {
		_attachment = attachment;
	}

	public long getComponentId() {
		return _componentId;
	}

	public void setComponentId(long componentId) {
		_componentId = componentId;
	}

	private long _catId;
	private long _companyId;
	private String _categoryName;
	private String _frequency;
	private long _salaryHead;
	private long _finalApprovalRoleId;
	private boolean _attachment;
	private long _componentId;
}