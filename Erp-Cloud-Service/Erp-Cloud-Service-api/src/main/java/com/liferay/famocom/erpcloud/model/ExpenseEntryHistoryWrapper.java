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
 * This class is a wrapper for {@link ExpenseEntryHistory}.
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntryHistory
 * @generated
 */
@ProviderType
public class ExpenseEntryHistoryWrapper implements ExpenseEntryHistory,
	ModelWrapper<ExpenseEntryHistory> {
	public ExpenseEntryHistoryWrapper(ExpenseEntryHistory expenseEntryHistory) {
		_expenseEntryHistory = expenseEntryHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return ExpenseEntryHistory.class;
	}

	@Override
	public String getModelClassName() {
		return ExpenseEntryHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expenseHistoryId", getExpenseHistoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("expenseId", getExpenseId());
		attributes.put("status", getStatus());
		attributes.put("manEmployeeId", getManEmployeeId());
		attributes.put("manComments", getManComments());
		attributes.put("addeddate", getAddeddate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expenseHistoryId = (Long)attributes.get("expenseHistoryId");

		if (expenseHistoryId != null) {
			setExpenseHistoryId(expenseHistoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long expenseId = (Long)attributes.get("expenseId");

		if (expenseId != null) {
			setExpenseId(expenseId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long manEmployeeId = (Long)attributes.get("manEmployeeId");

		if (manEmployeeId != null) {
			setManEmployeeId(manEmployeeId);
		}

		String manComments = (String)attributes.get("manComments");

		if (manComments != null) {
			setManComments(manComments);
		}

		Date addeddate = (Date)attributes.get("addeddate");

		if (addeddate != null) {
			setAddeddate(addeddate);
		}
	}

	@Override
	public Object clone() {
		return new ExpenseEntryHistoryWrapper((ExpenseEntryHistory)_expenseEntryHistory.clone());
	}

	@Override
	public int compareTo(ExpenseEntryHistory expenseEntryHistory) {
		return _expenseEntryHistory.compareTo(expenseEntryHistory);
	}

	/**
	* Returns the addeddate of this expense entry history.
	*
	* @return the addeddate of this expense entry history
	*/
	@Override
	public Date getAddeddate() {
		return _expenseEntryHistory.getAddeddate();
	}

	/**
	* Returns the company ID of this expense entry history.
	*
	* @return the company ID of this expense entry history
	*/
	@Override
	public long getCompanyId() {
		return _expenseEntryHistory.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expenseEntryHistory.getExpandoBridge();
	}

	/**
	* Returns the expense history ID of this expense entry history.
	*
	* @return the expense history ID of this expense entry history
	*/
	@Override
	public long getExpenseHistoryId() {
		return _expenseEntryHistory.getExpenseHistoryId();
	}

	/**
	* Returns the expense ID of this expense entry history.
	*
	* @return the expense ID of this expense entry history
	*/
	@Override
	public long getExpenseId() {
		return _expenseEntryHistory.getExpenseId();
	}

	/**
	* Returns the man comments of this expense entry history.
	*
	* @return the man comments of this expense entry history
	*/
	@Override
	public String getManComments() {
		return _expenseEntryHistory.getManComments();
	}

	/**
	* Returns the man employee ID of this expense entry history.
	*
	* @return the man employee ID of this expense entry history
	*/
	@Override
	public long getManEmployeeId() {
		return _expenseEntryHistory.getManEmployeeId();
	}

	/**
	* Returns the primary key of this expense entry history.
	*
	* @return the primary key of this expense entry history
	*/
	@Override
	public long getPrimaryKey() {
		return _expenseEntryHistory.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expenseEntryHistory.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this expense entry history.
	*
	* @return the status of this expense entry history
	*/
	@Override
	public int getStatus() {
		return _expenseEntryHistory.getStatus();
	}

	@Override
	public int hashCode() {
		return _expenseEntryHistory.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _expenseEntryHistory.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _expenseEntryHistory.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _expenseEntryHistory.isNew();
	}

	@Override
	public void persist() {
		_expenseEntryHistory.persist();
	}

	/**
	* Sets the addeddate of this expense entry history.
	*
	* @param addeddate the addeddate of this expense entry history
	*/
	@Override
	public void setAddeddate(Date addeddate) {
		_expenseEntryHistory.setAddeddate(addeddate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expenseEntryHistory.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this expense entry history.
	*
	* @param companyId the company ID of this expense entry history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expenseEntryHistory.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_expenseEntryHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expenseEntryHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expenseEntryHistory.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expense history ID of this expense entry history.
	*
	* @param expenseHistoryId the expense history ID of this expense entry history
	*/
	@Override
	public void setExpenseHistoryId(long expenseHistoryId) {
		_expenseEntryHistory.setExpenseHistoryId(expenseHistoryId);
	}

	/**
	* Sets the expense ID of this expense entry history.
	*
	* @param expenseId the expense ID of this expense entry history
	*/
	@Override
	public void setExpenseId(long expenseId) {
		_expenseEntryHistory.setExpenseId(expenseId);
	}

	/**
	* Sets the man comments of this expense entry history.
	*
	* @param manComments the man comments of this expense entry history
	*/
	@Override
	public void setManComments(String manComments) {
		_expenseEntryHistory.setManComments(manComments);
	}

	/**
	* Sets the man employee ID of this expense entry history.
	*
	* @param manEmployeeId the man employee ID of this expense entry history
	*/
	@Override
	public void setManEmployeeId(long manEmployeeId) {
		_expenseEntryHistory.setManEmployeeId(manEmployeeId);
	}

	@Override
	public void setNew(boolean n) {
		_expenseEntryHistory.setNew(n);
	}

	/**
	* Sets the primary key of this expense entry history.
	*
	* @param primaryKey the primary key of this expense entry history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expenseEntryHistory.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expenseEntryHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this expense entry history.
	*
	* @param status the status of this expense entry history
	*/
	@Override
	public void setStatus(int status) {
		_expenseEntryHistory.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExpenseEntryHistory> toCacheModel() {
		return _expenseEntryHistory.toCacheModel();
	}

	@Override
	public ExpenseEntryHistory toEscapedModel() {
		return new ExpenseEntryHistoryWrapper(_expenseEntryHistory.toEscapedModel());
	}

	@Override
	public String toString() {
		return _expenseEntryHistory.toString();
	}

	@Override
	public ExpenseEntryHistory toUnescapedModel() {
		return new ExpenseEntryHistoryWrapper(_expenseEntryHistory.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _expenseEntryHistory.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseEntryHistoryWrapper)) {
			return false;
		}

		ExpenseEntryHistoryWrapper expenseEntryHistoryWrapper = (ExpenseEntryHistoryWrapper)obj;

		if (Objects.equals(_expenseEntryHistory,
					expenseEntryHistoryWrapper._expenseEntryHistory)) {
			return true;
		}

		return false;
	}

	@Override
	public ExpenseEntryHistory getWrappedModel() {
		return _expenseEntryHistory;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expenseEntryHistory.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expenseEntryHistory.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_expenseEntryHistory.resetOriginalValues();
	}

	private final ExpenseEntryHistory _expenseEntryHistory;
}