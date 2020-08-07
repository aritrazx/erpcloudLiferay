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
 * This class is a wrapper for {@link BillingTable}.
 * </p>
 *
 * @author Samaresh
 * @see BillingTable
 * @generated
 */
@ProviderType
public class BillingTableWrapper implements BillingTable,
	ModelWrapper<BillingTable> {
	public BillingTableWrapper(BillingTable billingTable) {
		_billingTable = billingTable;
	}

	@Override
	public Class<?> getModelClass() {
		return BillingTable.class;
	}

	@Override
	public String getModelClassName() {
		return BillingTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("billingId", getBillingId());
		attributes.put("projectId", getProjectId());
		attributes.put("clientId", getClientId());
		attributes.put("milestoneName", getMilestoneName());
		attributes.put("dueDate", getDueDate());
		attributes.put("checkGST", getCheckGST());
		attributes.put("amount", getAmount());
		attributes.put("fileId", getFileId());
		attributes.put("fileName", getFileName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String milestoneName = (String)attributes.get("milestoneName");

		if (milestoneName != null) {
			setMilestoneName(milestoneName);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Integer checkGST = (Integer)attributes.get("checkGST");

		if (checkGST != null) {
			setCheckGST(checkGST);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public BillingTable toEscapedModel() {
		return new BillingTableWrapper(_billingTable.toEscapedModel());
	}

	@Override
	public BillingTable toUnescapedModel() {
		return new BillingTableWrapper(_billingTable.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _billingTable.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _billingTable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _billingTable.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _billingTable.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BillingTable> toCacheModel() {
		return _billingTable.toCacheModel();
	}

	/**
	* Returns the amount of this billing table.
	*
	* @return the amount of this billing table
	*/
	@Override
	public double getAmount() {
		return _billingTable.getAmount();
	}

	@Override
	public int compareTo(BillingTable billingTable) {
		return _billingTable.compareTo(billingTable);
	}

	/**
	* Returns the check gst of this billing table.
	*
	* @return the check gst of this billing table
	*/
	@Override
	public int getCheckGST() {
		return _billingTable.getCheckGST();
	}

	/**
	* Returns the status of this billing table.
	*
	* @return the status of this billing table
	*/
	@Override
	public int getStatus() {
		return _billingTable.getStatus();
	}

	@Override
	public int hashCode() {
		return _billingTable.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _billingTable.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BillingTableWrapper((BillingTable)_billingTable.clone());
	}

	/**
	* Returns the file name of this billing table.
	*
	* @return the file name of this billing table
	*/
	@Override
	public java.lang.String getFileName() {
		return _billingTable.getFileName();
	}

	/**
	* Returns the milestone name of this billing table.
	*
	* @return the milestone name of this billing table
	*/
	@Override
	public java.lang.String getMilestoneName() {
		return _billingTable.getMilestoneName();
	}

	@Override
	public java.lang.String toString() {
		return _billingTable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _billingTable.toXmlString();
	}

	/**
	* Returns the due date of this billing table.
	*
	* @return the due date of this billing table
	*/
	@Override
	public Date getDueDate() {
		return _billingTable.getDueDate();
	}

	/**
	* Returns the billing ID of this billing table.
	*
	* @return the billing ID of this billing table
	*/
	@Override
	public long getBillingId() {
		return _billingTable.getBillingId();
	}

	/**
	* Returns the client ID of this billing table.
	*
	* @return the client ID of this billing table
	*/
	@Override
	public long getClientId() {
		return _billingTable.getClientId();
	}

	/**
	* Returns the file ID of this billing table.
	*
	* @return the file ID of this billing table
	*/
	@Override
	public long getFileId() {
		return _billingTable.getFileId();
	}

	/**
	* Returns the primary key of this billing table.
	*
	* @return the primary key of this billing table
	*/
	@Override
	public long getPrimaryKey() {
		return _billingTable.getPrimaryKey();
	}

	/**
	* Returns the project ID of this billing table.
	*
	* @return the project ID of this billing table
	*/
	@Override
	public long getProjectId() {
		return _billingTable.getProjectId();
	}

	@Override
	public void persist() {
		_billingTable.persist();
	}

	/**
	* Sets the amount of this billing table.
	*
	* @param amount the amount of this billing table
	*/
	@Override
	public void setAmount(double amount) {
		_billingTable.setAmount(amount);
	}

	/**
	* Sets the billing ID of this billing table.
	*
	* @param billingId the billing ID of this billing table
	*/
	@Override
	public void setBillingId(long billingId) {
		_billingTable.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_billingTable.setCachedModel(cachedModel);
	}

	/**
	* Sets the check gst of this billing table.
	*
	* @param checkGST the check gst of this billing table
	*/
	@Override
	public void setCheckGST(int checkGST) {
		_billingTable.setCheckGST(checkGST);
	}

	/**
	* Sets the client ID of this billing table.
	*
	* @param clientId the client ID of this billing table
	*/
	@Override
	public void setClientId(long clientId) {
		_billingTable.setClientId(clientId);
	}

	/**
	* Sets the due date of this billing table.
	*
	* @param dueDate the due date of this billing table
	*/
	@Override
	public void setDueDate(Date dueDate) {
		_billingTable.setDueDate(dueDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_billingTable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_billingTable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_billingTable.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file ID of this billing table.
	*
	* @param fileId the file ID of this billing table
	*/
	@Override
	public void setFileId(long fileId) {
		_billingTable.setFileId(fileId);
	}

	/**
	* Sets the file name of this billing table.
	*
	* @param fileName the file name of this billing table
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_billingTable.setFileName(fileName);
	}

	/**
	* Sets the milestone name of this billing table.
	*
	* @param milestoneName the milestone name of this billing table
	*/
	@Override
	public void setMilestoneName(java.lang.String milestoneName) {
		_billingTable.setMilestoneName(milestoneName);
	}

	@Override
	public void setNew(boolean n) {
		_billingTable.setNew(n);
	}

	/**
	* Sets the primary key of this billing table.
	*
	* @param primaryKey the primary key of this billing table
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_billingTable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_billingTable.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this billing table.
	*
	* @param projectId the project ID of this billing table
	*/
	@Override
	public void setProjectId(long projectId) {
		_billingTable.setProjectId(projectId);
	}

	/**
	* Sets the status of this billing table.
	*
	* @param status the status of this billing table
	*/
	@Override
	public void setStatus(int status) {
		_billingTable.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillingTableWrapper)) {
			return false;
		}

		BillingTableWrapper billingTableWrapper = (BillingTableWrapper)obj;

		if (Objects.equals(_billingTable, billingTableWrapper._billingTable)) {
			return true;
		}

		return false;
	}

	@Override
	public BillingTable getWrappedModel() {
		return _billingTable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _billingTable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _billingTable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_billingTable.resetOriginalValues();
	}

	private final BillingTable _billingTable;
}