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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Branch service. Represents a row in the &quot;branch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.BranchModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.BranchImpl}.
 * </p>
 *
 * @author Samaresh
 * @see Branch
 * @see com.liferay.famocom.erpcloud.model.impl.BranchImpl
 * @see com.liferay.famocom.erpcloud.model.impl.BranchModelImpl
 * @generated
 */
@ProviderType
public interface BranchModel extends BaseModel<Branch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a branch model instance should use the {@link Branch} interface instead.
	 */

	/**
	 * Returns the primary key of this branch.
	 *
	 * @return the primary key of this branch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this branch.
	 *
	 * @param primaryKey the primary key of this branch
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the branch ID of this branch.
	 *
	 * @return the branch ID of this branch
	 */
	public long getBranchId();

	/**
	 * Sets the branch ID of this branch.
	 *
	 * @param branchId the branch ID of this branch
	 */
	public void setBranchId(long branchId);

	/**
	 * Returns the branch name of this branch.
	 *
	 * @return the branch name of this branch
	 */
	@AutoEscape
	public String getBranchName();

	/**
	 * Sets the branch name of this branch.
	 *
	 * @param branchName the branch name of this branch
	 */
	public void setBranchName(String branchName);

	/**
	 * Returns the branch address of this branch.
	 *
	 * @return the branch address of this branch
	 */
	@AutoEscape
	public String getBranchAddress();

	/**
	 * Sets the branch address of this branch.
	 *
	 * @param branchAddress the branch address of this branch
	 */
	public void setBranchAddress(String branchAddress);

	/**
	 * Returns the status of this branch.
	 *
	 * @return the status of this branch
	 */
	public int getStatus();

	/**
	 * Sets the status of this branch.
	 *
	 * @param status the status of this branch
	 */
	public void setStatus(int status);

	/**
	 * Returns the modified date of this branch.
	 *
	 * @return the modified date of this branch
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this branch.
	 *
	 * @param modifiedDate the modified date of this branch
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the create date of this branch.
	 *
	 * @return the create date of this branch
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this branch.
	 *
	 * @param createDate the create date of this branch
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by ID of this branch.
	 *
	 * @return the created by ID of this branch
	 */
	public long getCreatedById();

	/**
	 * Sets the created by ID of this branch.
	 *
	 * @param createdById the created by ID of this branch
	 */
	public void setCreatedById(long createdById);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Branch branch);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Branch> toCacheModel();

	@Override
	public Branch toEscapedModel();

	@Override
	public Branch toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}