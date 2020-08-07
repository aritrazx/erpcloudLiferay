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
 * This class is a wrapper for {@link BankMaster}.
 * </p>
 *
 * @author Samaresh
 * @see BankMaster
 * @generated
 */
@ProviderType
public class BankMasterWrapper implements BankMaster, ModelWrapper<BankMaster> {
	public BankMasterWrapper(BankMaster bankMaster) {
		_bankMaster = bankMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return BankMaster.class;
	}

	@Override
	public String getModelClassName() {
		return BankMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bankId", getBankId());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
		attributes.put("address", getAddress());
		attributes.put("ifscCode", getIfscCode());
		attributes.put("status", getStatus());
		attributes.put("bankType", getBankType());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bankId = (Long)attributes.get("bankId");

		if (bankId != null) {
			setBankId(bankId);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String ifscCode = (String)attributes.get("ifscCode");

		if (ifscCode != null) {
			setIfscCode(ifscCode);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer bankType = (Integer)attributes.get("bankType");

		if (bankType != null) {
			setBankType(bankType);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new BankMasterWrapper((BankMaster)_bankMaster.clone());
	}

	@Override
	public int compareTo(BankMaster bankMaster) {
		return _bankMaster.compareTo(bankMaster);
	}

	/**
	* Returns the address of this bank master.
	*
	* @return the address of this bank master
	*/
	@Override
	public String getAddress() {
		return _bankMaster.getAddress();
	}

	/**
	* Returns the bank ID of this bank master.
	*
	* @return the bank ID of this bank master
	*/
	@Override
	public long getBankId() {
		return _bankMaster.getBankId();
	}

	/**
	* Returns the bank name of this bank master.
	*
	* @return the bank name of this bank master
	*/
	@Override
	public String getBankName() {
		return _bankMaster.getBankName();
	}

	/**
	* Returns the bank type of this bank master.
	*
	* @return the bank type of this bank master
	*/
	@Override
	public int getBankType() {
		return _bankMaster.getBankType();
	}

	/**
	* Returns the branch name of this bank master.
	*
	* @return the branch name of this bank master
	*/
	@Override
	public String getBranchName() {
		return _bankMaster.getBranchName();
	}

	/**
	* Returns the create date of this bank master.
	*
	* @return the create date of this bank master
	*/
	@Override
	public Date getCreateDate() {
		return _bankMaster.getCreateDate();
	}

	/**
	* Returns the created by of this bank master.
	*
	* @return the created by of this bank master
	*/
	@Override
	public long getCreatedBy() {
		return _bankMaster.getCreatedBy();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bankMaster.getExpandoBridge();
	}

	/**
	* Returns the ifsc code of this bank master.
	*
	* @return the ifsc code of this bank master
	*/
	@Override
	public String getIfscCode() {
		return _bankMaster.getIfscCode();
	}

	/**
	* Returns the modified date of this bank master.
	*
	* @return the modified date of this bank master
	*/
	@Override
	public Date getModifiedDate() {
		return _bankMaster.getModifiedDate();
	}

	/**
	* Returns the primary key of this bank master.
	*
	* @return the primary key of this bank master
	*/
	@Override
	public long getPrimaryKey() {
		return _bankMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bankMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this bank master.
	*
	* @return the status of this bank master
	*/
	@Override
	public int getStatus() {
		return _bankMaster.getStatus();
	}

	@Override
	public int hashCode() {
		return _bankMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bankMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bankMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bankMaster.isNew();
	}

	@Override
	public void persist() {
		_bankMaster.persist();
	}

	/**
	* Sets the address of this bank master.
	*
	* @param address the address of this bank master
	*/
	@Override
	public void setAddress(String address) {
		_bankMaster.setAddress(address);
	}

	/**
	* Sets the bank ID of this bank master.
	*
	* @param bankId the bank ID of this bank master
	*/
	@Override
	public void setBankId(long bankId) {
		_bankMaster.setBankId(bankId);
	}

	/**
	* Sets the bank name of this bank master.
	*
	* @param bankName the bank name of this bank master
	*/
	@Override
	public void setBankName(String bankName) {
		_bankMaster.setBankName(bankName);
	}

	/**
	* Sets the bank type of this bank master.
	*
	* @param bankType the bank type of this bank master
	*/
	@Override
	public void setBankType(int bankType) {
		_bankMaster.setBankType(bankType);
	}

	/**
	* Sets the branch name of this bank master.
	*
	* @param branchName the branch name of this bank master
	*/
	@Override
	public void setBranchName(String branchName) {
		_bankMaster.setBranchName(branchName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bankMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this bank master.
	*
	* @param createDate the create date of this bank master
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_bankMaster.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this bank master.
	*
	* @param createdBy the created by of this bank master
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_bankMaster.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_bankMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bankMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bankMaster.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ifsc code of this bank master.
	*
	* @param ifscCode the ifsc code of this bank master
	*/
	@Override
	public void setIfscCode(String ifscCode) {
		_bankMaster.setIfscCode(ifscCode);
	}

	/**
	* Sets the modified date of this bank master.
	*
	* @param modifiedDate the modified date of this bank master
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_bankMaster.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_bankMaster.setNew(n);
	}

	/**
	* Sets the primary key of this bank master.
	*
	* @param primaryKey the primary key of this bank master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bankMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bankMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this bank master.
	*
	* @param status the status of this bank master
	*/
	@Override
	public void setStatus(int status) {
		_bankMaster.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BankMaster> toCacheModel() {
		return _bankMaster.toCacheModel();
	}

	@Override
	public BankMaster toEscapedModel() {
		return new BankMasterWrapper(_bankMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bankMaster.toString();
	}

	@Override
	public BankMaster toUnescapedModel() {
		return new BankMasterWrapper(_bankMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bankMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BankMasterWrapper)) {
			return false;
		}

		BankMasterWrapper bankMasterWrapper = (BankMasterWrapper)obj;

		if (Objects.equals(_bankMaster, bankMasterWrapper._bankMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public BankMaster getWrappedModel() {
		return _bankMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bankMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bankMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bankMaster.resetOriginalValues();
	}

	private final BankMaster _bankMaster;
}