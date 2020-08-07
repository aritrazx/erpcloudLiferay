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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the employeePhoto column in Employee.
 *
 * @author Samaresh
 * @see Employee
 * @generated
 */
@ProviderType
public class EmployeeEmployeePhotoBlobModel {
	public EmployeeEmployeePhotoBlobModel() {
	}

	public EmployeeEmployeePhotoBlobModel(long employeeId) {
		_employeeId = employeeId;
	}

	public EmployeeEmployeePhotoBlobModel(long employeeId,
		Blob employeePhotoBlob) {
		_employeeId = employeeId;
		_employeePhotoBlob = employeePhotoBlob;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Blob getEmployeePhotoBlob() {
		return _employeePhotoBlob;
	}

	public void setEmployeePhotoBlob(Blob employeePhotoBlob) {
		_employeePhotoBlob = employeePhotoBlob;
	}

	private long _employeeId;
	private Blob _employeePhotoBlob;
}