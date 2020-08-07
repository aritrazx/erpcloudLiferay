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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Branch}.
 * </p>
 *
 * @author Samaresh
 * @see Branch
 * @generated
 */
@ProviderType
public class BranchWrapper implements Branch, ModelWrapper<Branch> {
	public BranchWrapper(Branch branch) {
		_branch = branch;
	}

	@Override
	public Class<?> getModelClass() {
		return Branch.class;
	}

	@Override
	public String getModelClassName() {
		return Branch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("branchId", getBranchId());
		attributes.put("branchName", getBranchName());
		attributes.put("branchAddress", getBranchAddress());
		attributes.put("status", getStatus());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdById", getCreatedById());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long branchId = (Long)attributes.get("branchId");

		if (branchId != null) {
			setBranchId(branchId);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		String branchAddress = (String)attributes.get("branchAddress");

		if (branchAddress != null) {
			setBranchAddress(branchAddress);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdById = (Long)attributes.get("createdById");

		if (createdById != null) {
			setCreatedById(createdById);
		}
	}

	@Override
	public Object clone() {
		return new BranchWrapper((Branch)_branch.clone());
	}

	@Override
	public int compareTo(Branch branch) {
		return _branch.compareTo(branch);
	}

	/**
	* Returns the branch address of this branch.
	*
	* @return the branch address of this branch
	*/
	@Override
	public String getBranchAddress() {
		return _branch.getBranchAddress();
	}

	/**
	* Returns the branch ID of this branch.
	*
	* @return the branch ID of this branch
	*/
	@Override
	public long getBranchId() {
		return _branch.getBranchId();
	}

	/**
	* Returns the branch name of this branch.
	*
	* @return the branch name of this branch
	*/
	@Override
	public String getBranchName() {
		return _branch.getBranchName();
	}

	/**
	* Returns the create date of this branch.
	*
	* @return the create date of this branch
	*/
	@Override
	public Date getCreateDate() {
		return _branch.getCreateDate();
	}

	/**
	* Returns the created by ID of this branch.
	*
	* @return the created by ID of this branch
	*/
	@Override
	public long getCreatedById() {
		return _branch.getCreatedById();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _branch.getExpandoBridge();
	}

	/**
	* Returns the modified date of this branch.
	*
	* @return the modified date of this branch
	*/
	@Override
	public Date getModifiedDate() {
		return _branch.getModifiedDate();
	}

	/**
	* Returns the primary key of this branch.
	*
	* @return the primary key of this branch
	*/
	@Override
	public long getPrimaryKey() {
		return _branch.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _branch.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this branch.
	*
	* @return the status of this branch
	*/
	@Override
	public int getStatus() {
		return _branch.getStatus();
	}

	@Override
	public int hashCode() {
		return _branch.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _branch.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _branch.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _branch.isNew();
	}

	@Override
	public void persist() {
		_branch.persist();
	}

	/**
	* Sets the branch address of this branch.
	*
	* @param branchAddress the branch address of this branch
	*/
	@Override
	public void setBranchAddress(String branchAddress) {
		_branch.setBranchAddress(branchAddress);
	}

	/**
	* Sets the branch ID of this branch.
	*
	* @param branchId the branch ID of this branch
	*/
	@Override
	public void setBranchId(long branchId) {
		_branch.setBranchId(branchId);
	}

	/**
	* Sets the branch name of this branch.
	*
	* @param branchName the branch name of this branch
	*/
	@Override
	public void setBranchName(String branchName) {
		_branch.setBranchName(branchName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_branch.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this branch.
	*
	* @param createDate the create date of this branch
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_branch.setCreateDate(createDate);
	}

	/**
	* Sets the created by ID of this branch.
	*
	* @param createdById the created by ID of this branch
	*/
	@Override
	public void setCreatedById(long createdById) {
		_branch.setCreatedById(createdById);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_branch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_branch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_branch.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this branch.
	*
	* @param modifiedDate the modified date of this branch
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_branch.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_branch.setNew(n);
	}

	/**
	* Sets the primary key of this branch.
	*
	* @param primaryKey the primary key of this branch
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_branch.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_branch.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this branch.
	*
	* @param status the status of this branch
	*/
	@Override
	public void setStatus(int status) {
		_branch.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Branch> toCacheModel() {
		return _branch.toCacheModel();
	}

	@Override
	public Branch toEscapedModel() {
		return new BranchWrapper(_branch.toEscapedModel());
	}

	@Override
	public String toString() {
		return _branch.toString();
	}

	@Override
	public Branch toUnescapedModel() {
		return new BranchWrapper(_branch.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _branch.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BranchWrapper)) {
			return false;
		}

		BranchWrapper branchWrapper = (BranchWrapper)obj;

		if (Objects.equals(_branch, branchWrapper._branch)) {
			return true;
		}

		return false;
	}

	@Override
	public Branch getWrappedModel() {
		return _branch;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _branch.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _branch.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_branch.resetOriginalValues();
	}

	private final Branch _branch;
}