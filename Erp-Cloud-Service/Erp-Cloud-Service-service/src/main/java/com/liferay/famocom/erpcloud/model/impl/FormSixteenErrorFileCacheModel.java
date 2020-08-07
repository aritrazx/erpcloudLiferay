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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.FormSixteenErrorFile;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FormSixteenErrorFile in entity cache.
 *
 * @author Samaresh
 * @see FormSixteenErrorFile
 * @generated
 */
@ProviderType
public class FormSixteenErrorFileCacheModel implements CacheModel<FormSixteenErrorFile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormSixteenErrorFileCacheModel)) {
			return false;
		}

		FormSixteenErrorFileCacheModel formSixteenErrorFileCacheModel = (FormSixteenErrorFileCacheModel)obj;

		if (errorId == formSixteenErrorFileCacheModel.errorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, errorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{errorId=");
		sb.append(errorId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", errorMsg=");
		sb.append(errorMsg);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FormSixteenErrorFile toEntityModel() {
		FormSixteenErrorFileImpl formSixteenErrorFileImpl = new FormSixteenErrorFileImpl();

		formSixteenErrorFileImpl.setErrorId(errorId);

		if (fileName == null) {
			formSixteenErrorFileImpl.setFileName("");
		}
		else {
			formSixteenErrorFileImpl.setFileName(fileName);
		}

		if (errorMsg == null) {
			formSixteenErrorFileImpl.setErrorMsg("");
		}
		else {
			formSixteenErrorFileImpl.setErrorMsg(errorMsg);
		}

		formSixteenErrorFileImpl.resetOriginalValues();

		return formSixteenErrorFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		errorId = objectInput.readLong();
		fileName = objectInput.readUTF();
		errorMsg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(errorId);

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (errorMsg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errorMsg);
		}
	}

	public long errorId;
	public String fileName;
	public String errorMsg;
}