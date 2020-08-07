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

import com.liferay.famocom.erpcloud.model.SkillSet;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SkillSet in entity cache.
 *
 * @author Samaresh
 * @see SkillSet
 * @generated
 */
@ProviderType
public class SkillSetCacheModel implements CacheModel<SkillSet>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkillSetCacheModel)) {
			return false;
		}

		SkillSetCacheModel skillSetCacheModel = (SkillSetCacheModel)obj;

		if (SkillId == skillSetCacheModel.SkillId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, SkillId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{SkillId=");
		sb.append(SkillId);
		sb.append(", SkillName=");
		sb.append(SkillName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SkillSet toEntityModel() {
		SkillSetImpl skillSetImpl = new SkillSetImpl();

		skillSetImpl.setSkillId(SkillId);

		if (SkillName == null) {
			skillSetImpl.setSkillName("");
		}
		else {
			skillSetImpl.setSkillName(SkillName);
		}

		skillSetImpl.resetOriginalValues();

		return skillSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SkillId = objectInput.readLong();
		SkillName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(SkillId);

		if (SkillName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SkillName);
		}
	}

	public long SkillId;
	public String SkillName;
}