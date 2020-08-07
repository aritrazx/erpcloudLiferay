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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.FormSixteenErrorFileServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.FormSixteenErrorFileServiceSoap
 * @generated
 */
@ProviderType
public class FormSixteenErrorFileSoap implements Serializable {
	public static FormSixteenErrorFileSoap toSoapModel(
		FormSixteenErrorFile model) {
		FormSixteenErrorFileSoap soapModel = new FormSixteenErrorFileSoap();

		soapModel.setErrorId(model.getErrorId());
		soapModel.setFileName(model.getFileName());
		soapModel.setErrorMsg(model.getErrorMsg());

		return soapModel;
	}

	public static FormSixteenErrorFileSoap[] toSoapModels(
		FormSixteenErrorFile[] models) {
		FormSixteenErrorFileSoap[] soapModels = new FormSixteenErrorFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormSixteenErrorFileSoap[][] toSoapModels(
		FormSixteenErrorFile[][] models) {
		FormSixteenErrorFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormSixteenErrorFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormSixteenErrorFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormSixteenErrorFileSoap[] toSoapModels(
		List<FormSixteenErrorFile> models) {
		List<FormSixteenErrorFileSoap> soapModels = new ArrayList<FormSixteenErrorFileSoap>(models.size());

		for (FormSixteenErrorFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormSixteenErrorFileSoap[soapModels.size()]);
	}

	public FormSixteenErrorFileSoap() {
	}

	public long getPrimaryKey() {
		return _errorId;
	}

	public void setPrimaryKey(long pk) {
		setErrorId(pk);
	}

	public long getErrorId() {
		return _errorId;
	}

	public void setErrorId(long errorId) {
		_errorId = errorId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getErrorMsg() {
		return _errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		_errorMsg = errorMsg;
	}

	private long _errorId;
	private String _fileName;
	private String _errorMsg;
}