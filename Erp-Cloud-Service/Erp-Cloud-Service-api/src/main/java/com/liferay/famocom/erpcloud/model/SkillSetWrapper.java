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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SkillSet}.
 * </p>
 *
 * @author Samaresh
 * @see SkillSet
 * @generated
 */
@ProviderType
public class SkillSetWrapper implements SkillSet, ModelWrapper<SkillSet> {
	public SkillSetWrapper(SkillSet skillSet) {
		_skillSet = skillSet;
	}

	@Override
	public Class<?> getModelClass() {
		return SkillSet.class;
	}

	@Override
	public String getModelClassName() {
		return SkillSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SkillId", getSkillId());
		attributes.put("SkillName", getSkillName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SkillId = (Long)attributes.get("SkillId");

		if (SkillId != null) {
			setSkillId(SkillId);
		}

		String SkillName = (String)attributes.get("SkillName");

		if (SkillName != null) {
			setSkillName(SkillName);
		}
	}

	@Override
	public Object clone() {
		return new SkillSetWrapper((SkillSet)_skillSet.clone());
	}

	@Override
	public int compareTo(SkillSet skillSet) {
		return _skillSet.compareTo(skillSet);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _skillSet.getExpandoBridge();
	}

	/**
	* Returns the primary key of this skill set.
	*
	* @return the primary key of this skill set
	*/
	@Override
	public long getPrimaryKey() {
		return _skillSet.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _skillSet.getPrimaryKeyObj();
	}

	/**
	* Returns the skill ID of this skill set.
	*
	* @return the skill ID of this skill set
	*/
	@Override
	public long getSkillId() {
		return _skillSet.getSkillId();
	}

	/**
	* Returns the skill name of this skill set.
	*
	* @return the skill name of this skill set
	*/
	@Override
	public String getSkillName() {
		return _skillSet.getSkillName();
	}

	@Override
	public int hashCode() {
		return _skillSet.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _skillSet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _skillSet.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _skillSet.isNew();
	}

	@Override
	public void persist() {
		_skillSet.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skillSet.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_skillSet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_skillSet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_skillSet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_skillSet.setNew(n);
	}

	/**
	* Sets the primary key of this skill set.
	*
	* @param primaryKey the primary key of this skill set
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skillSet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_skillSet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the skill ID of this skill set.
	*
	* @param SkillId the skill ID of this skill set
	*/
	@Override
	public void setSkillId(long SkillId) {
		_skillSet.setSkillId(SkillId);
	}

	/**
	* Sets the skill name of this skill set.
	*
	* @param SkillName the skill name of this skill set
	*/
	@Override
	public void setSkillName(String SkillName) {
		_skillSet.setSkillName(SkillName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SkillSet> toCacheModel() {
		return _skillSet.toCacheModel();
	}

	@Override
	public SkillSet toEscapedModel() {
		return new SkillSetWrapper(_skillSet.toEscapedModel());
	}

	@Override
	public String toString() {
		return _skillSet.toString();
	}

	@Override
	public SkillSet toUnescapedModel() {
		return new SkillSetWrapper(_skillSet.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _skillSet.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkillSetWrapper)) {
			return false;
		}

		SkillSetWrapper skillSetWrapper = (SkillSetWrapper)obj;

		if (Objects.equals(_skillSet, skillSetWrapper._skillSet)) {
			return true;
		}

		return false;
	}

	@Override
	public SkillSet getWrappedModel() {
		return _skillSet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _skillSet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _skillSet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_skillSet.resetOriginalValues();
	}

	private final SkillSet _skillSet;
}