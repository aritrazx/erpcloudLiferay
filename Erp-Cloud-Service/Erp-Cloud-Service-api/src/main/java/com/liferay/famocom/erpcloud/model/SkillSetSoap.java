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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.SkillSetServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.SkillSetServiceSoap
 * @generated
 */
@ProviderType
public class SkillSetSoap implements Serializable {
	public static SkillSetSoap toSoapModel(SkillSet model) {
		SkillSetSoap soapModel = new SkillSetSoap();

		soapModel.setSkillId(model.getSkillId());
		soapModel.setSkillName(model.getSkillName());

		return soapModel;
	}

	public static SkillSetSoap[] toSoapModels(SkillSet[] models) {
		SkillSetSoap[] soapModels = new SkillSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkillSetSoap[][] toSoapModels(SkillSet[][] models) {
		SkillSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkillSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkillSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkillSetSoap[] toSoapModels(List<SkillSet> models) {
		List<SkillSetSoap> soapModels = new ArrayList<SkillSetSoap>(models.size());

		for (SkillSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkillSetSoap[soapModels.size()]);
	}

	public SkillSetSoap() {
	}

	public long getPrimaryKey() {
		return _SkillId;
	}

	public void setPrimaryKey(long pk) {
		setSkillId(pk);
	}

	public long getSkillId() {
		return _SkillId;
	}

	public void setSkillId(long SkillId) {
		_SkillId = SkillId;
	}

	public String getSkillName() {
		return _SkillName;
	}

	public void setSkillName(String SkillName) {
		_SkillName = SkillName;
	}

	private long _SkillId;
	private String _SkillName;
}