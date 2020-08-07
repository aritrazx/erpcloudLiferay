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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.EmpPayStructureServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.EmpPayStructureServiceSoap
 * @generated
 */
@ProviderType
public class EmpPayStructureSoap implements Serializable {
	public static EmpPayStructureSoap toSoapModel(EmpPayStructure model) {
		EmpPayStructureSoap soapModel = new EmpPayStructureSoap();

		soapModel.setEmpPayStructureId(model.getEmpPayStructureId());
		soapModel.setPayComponentId(model.getPayComponentId());
		soapModel.setComponentValue(model.getComponentValue());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static EmpPayStructureSoap[] toSoapModels(EmpPayStructure[] models) {
		EmpPayStructureSoap[] soapModels = new EmpPayStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpPayStructureSoap[][] toSoapModels(
		EmpPayStructure[][] models) {
		EmpPayStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpPayStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpPayStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpPayStructureSoap[] toSoapModels(
		List<EmpPayStructure> models) {
		List<EmpPayStructureSoap> soapModels = new ArrayList<EmpPayStructureSoap>(models.size());

		for (EmpPayStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpPayStructureSoap[soapModels.size()]);
	}

	public EmpPayStructureSoap() {
	}

	public long getPrimaryKey() {
		return _empPayStructureId;
	}

	public void setPrimaryKey(long pk) {
		setEmpPayStructureId(pk);
	}

	public long getEmpPayStructureId() {
		return _empPayStructureId;
	}

	public void setEmpPayStructureId(long empPayStructureId) {
		_empPayStructureId = empPayStructureId;
	}

	public long getPayComponentId() {
		return _payComponentId;
	}

	public void setPayComponentId(long payComponentId) {
		_payComponentId = payComponentId;
	}

	public double getComponentValue() {
		return _componentValue;
	}

	public void setComponentValue(double componentValue) {
		_componentValue = componentValue;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private long _empPayStructureId;
	private long _payComponentId;
	private double _componentValue;
	private long _employeeId;
}