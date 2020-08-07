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
 * This class is a wrapper for {@link ExpenseEntry}.
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntry
 * @generated
 */
@ProviderType
public class ExpenseEntryWrapper implements ExpenseEntry,
	ModelWrapper<ExpenseEntry> {
	public ExpenseEntryWrapper(ExpenseEntry expenseEntry) {
		_expenseEntry = expenseEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return ExpenseEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ExpenseEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expenseId", getExpenseId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectId", getProjectId());
		attributes.put("catId", getCatId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("expDate", getExpDate());
		attributes.put("amount", getAmount());
		attributes.put("status", getStatus());
		attributes.put("manEmployeeId", getManEmployeeId());
		attributes.put("manCommnets", getManCommnets());
		attributes.put("manApprovedDate", getManApprovedDate());
		attributes.put("accComments", getAccComments());
		attributes.put("accApprovedDate", getAccApprovedDate());
		attributes.put("monthYear", getMonthYear());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expenseId = (Long)attributes.get("expenseId");

		if (expenseId != null) {
			setExpenseId(expenseId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long catId = (Long)attributes.get("catId");

		if (catId != null) {
			setCatId(catId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date expDate = (Date)attributes.get("expDate");

		if (expDate != null) {
			setExpDate(expDate);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long manEmployeeId = (Long)attributes.get("manEmployeeId");

		if (manEmployeeId != null) {
			setManEmployeeId(manEmployeeId);
		}

		String manCommnets = (String)attributes.get("manCommnets");

		if (manCommnets != null) {
			setManCommnets(manCommnets);
		}

		Date manApprovedDate = (Date)attributes.get("manApprovedDate");

		if (manApprovedDate != null) {
			setManApprovedDate(manApprovedDate);
		}

		String accComments = (String)attributes.get("accComments");

		if (accComments != null) {
			setAccComments(accComments);
		}

		Date accApprovedDate = (Date)attributes.get("accApprovedDate");

		if (accApprovedDate != null) {
			setAccApprovedDate(accApprovedDate);
		}

		Long monthYear = (Long)attributes.get("monthYear");

		if (monthYear != null) {
			setMonthYear(monthYear);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public Object clone() {
		return new ExpenseEntryWrapper((ExpenseEntry)_expenseEntry.clone());
	}

	@Override
	public int compareTo(ExpenseEntry expenseEntry) {
		return _expenseEntry.compareTo(expenseEntry);
	}

	/**
	* Returns the acc approved date of this expense entry.
	*
	* @return the acc approved date of this expense entry
	*/
	@Override
	public Date getAccApprovedDate() {
		return _expenseEntry.getAccApprovedDate();
	}

	/**
	* Returns the acc comments of this expense entry.
	*
	* @return the acc comments of this expense entry
	*/
	@Override
	public String getAccComments() {
		return _expenseEntry.getAccComments();
	}

	/**
	* Returns the amount of this expense entry.
	*
	* @return the amount of this expense entry
	*/
	@Override
	public double getAmount() {
		return _expenseEntry.getAmount();
	}

	/**
	* Returns the cat ID of this expense entry.
	*
	* @return the cat ID of this expense entry
	*/
	@Override
	public long getCatId() {
		return _expenseEntry.getCatId();
	}

	/**
	* Returns the company ID of this expense entry.
	*
	* @return the company ID of this expense entry
	*/
	@Override
	public long getCompanyId() {
		return _expenseEntry.getCompanyId();
	}

	/**
	* Returns the create date of this expense entry.
	*
	* @return the create date of this expense entry
	*/
	@Override
	public Date getCreateDate() {
		return _expenseEntry.getCreateDate();
	}

	/**
	* Returns the description of this expense entry.
	*
	* @return the description of this expense entry
	*/
	@Override
	public String getDescription() {
		return _expenseEntry.getDescription();
	}

	/**
	* Returns the employee ID of this expense entry.
	*
	* @return the employee ID of this expense entry
	*/
	@Override
	public long getEmployeeId() {
		return _expenseEntry.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expenseEntry.getExpandoBridge();
	}

	/**
	* Returns the exp date of this expense entry.
	*
	* @return the exp date of this expense entry
	*/
	@Override
	public Date getExpDate() {
		return _expenseEntry.getExpDate();
	}

	/**
	* Returns the expense ID of this expense entry.
	*
	* @return the expense ID of this expense entry
	*/
	@Override
	public long getExpenseId() {
		return _expenseEntry.getExpenseId();
	}

	/**
	* Returns the group ID of this expense entry.
	*
	* @return the group ID of this expense entry
	*/
	@Override
	public long getGroupId() {
		return _expenseEntry.getGroupId();
	}

	/**
	* Returns the man approved date of this expense entry.
	*
	* @return the man approved date of this expense entry
	*/
	@Override
	public Date getManApprovedDate() {
		return _expenseEntry.getManApprovedDate();
	}

	/**
	* Returns the man commnets of this expense entry.
	*
	* @return the man commnets of this expense entry
	*/
	@Override
	public String getManCommnets() {
		return _expenseEntry.getManCommnets();
	}

	/**
	* Returns the man employee ID of this expense entry.
	*
	* @return the man employee ID of this expense entry
	*/
	@Override
	public long getManEmployeeId() {
		return _expenseEntry.getManEmployeeId();
	}

	/**
	* Returns the modified date of this expense entry.
	*
	* @return the modified date of this expense entry
	*/
	@Override
	public Date getModifiedDate() {
		return _expenseEntry.getModifiedDate();
	}

	/**
	* Returns the month year of this expense entry.
	*
	* @return the month year of this expense entry
	*/
	@Override
	public long getMonthYear() {
		return _expenseEntry.getMonthYear();
	}

	/**
	* Returns the primary key of this expense entry.
	*
	* @return the primary key of this expense entry
	*/
	@Override
	public long getPrimaryKey() {
		return _expenseEntry.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expenseEntry.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this expense entry.
	*
	* @return the project ID of this expense entry
	*/
	@Override
	public long getProjectId() {
		return _expenseEntry.getProjectId();
	}

	/**
	* Returns the status of this expense entry.
	*
	* @return the status of this expense entry
	*/
	@Override
	public int getStatus() {
		return _expenseEntry.getStatus();
	}

	/**
	* Returns the status by user ID of this expense entry.
	*
	* @return the status by user ID of this expense entry
	*/
	@Override
	public long getStatusByUserId() {
		return _expenseEntry.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this expense entry.
	*
	* @return the status by user name of this expense entry
	*/
	@Override
	public String getStatusByUserName() {
		return _expenseEntry.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this expense entry.
	*
	* @return the status by user uuid of this expense entry
	*/
	@Override
	public String getStatusByUserUuid() {
		return _expenseEntry.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this expense entry.
	*
	* @return the status date of this expense entry
	*/
	@Override
	public Date getStatusDate() {
		return _expenseEntry.getStatusDate();
	}

	/**
	* Returns the title of this expense entry.
	*
	* @return the title of this expense entry
	*/
	@Override
	public String getTitle() {
		return _expenseEntry.getTitle();
	}

	/**
	* Returns the user ID of this expense entry.
	*
	* @return the user ID of this expense entry
	*/
	@Override
	public long getUserId() {
		return _expenseEntry.getUserId();
	}

	/**
	* Returns the user name of this expense entry.
	*
	* @return the user name of this expense entry
	*/
	@Override
	public String getUserName() {
		return _expenseEntry.getUserName();
	}

	/**
	* Returns the user uuid of this expense entry.
	*
	* @return the user uuid of this expense entry
	*/
	@Override
	public String getUserUuid() {
		return _expenseEntry.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _expenseEntry.hashCode();
	}

	/**
	* Returns <code>true</code> if this expense entry is approved.
	*
	* @return <code>true</code> if this expense entry is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _expenseEntry.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _expenseEntry.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this expense entry is denied.
	*
	* @return <code>true</code> if this expense entry is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _expenseEntry.isDenied();
	}

	/**
	* Returns <code>true</code> if this expense entry is a draft.
	*
	* @return <code>true</code> if this expense entry is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _expenseEntry.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _expenseEntry.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this expense entry is expired.
	*
	* @return <code>true</code> if this expense entry is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _expenseEntry.isExpired();
	}

	/**
	* Returns <code>true</code> if this expense entry is inactive.
	*
	* @return <code>true</code> if this expense entry is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _expenseEntry.isInactive();
	}

	/**
	* Returns <code>true</code> if this expense entry is incomplete.
	*
	* @return <code>true</code> if this expense entry is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _expenseEntry.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _expenseEntry.isNew();
	}

	/**
	* Returns <code>true</code> if this expense entry is pending.
	*
	* @return <code>true</code> if this expense entry is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _expenseEntry.isPending();
	}

	/**
	* Returns <code>true</code> if this expense entry is scheduled.
	*
	* @return <code>true</code> if this expense entry is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _expenseEntry.isScheduled();
	}

	@Override
	public void persist() {
		_expenseEntry.persist();
	}

	/**
	* Sets the acc approved date of this expense entry.
	*
	* @param accApprovedDate the acc approved date of this expense entry
	*/
	@Override
	public void setAccApprovedDate(Date accApprovedDate) {
		_expenseEntry.setAccApprovedDate(accApprovedDate);
	}

	/**
	* Sets the acc comments of this expense entry.
	*
	* @param accComments the acc comments of this expense entry
	*/
	@Override
	public void setAccComments(String accComments) {
		_expenseEntry.setAccComments(accComments);
	}

	/**
	* Sets the amount of this expense entry.
	*
	* @param amount the amount of this expense entry
	*/
	@Override
	public void setAmount(double amount) {
		_expenseEntry.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expenseEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the cat ID of this expense entry.
	*
	* @param catId the cat ID of this expense entry
	*/
	@Override
	public void setCatId(long catId) {
		_expenseEntry.setCatId(catId);
	}

	/**
	* Sets the company ID of this expense entry.
	*
	* @param companyId the company ID of this expense entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expenseEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this expense entry.
	*
	* @param createDate the create date of this expense entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_expenseEntry.setCreateDate(createDate);
	}

	/**
	* Sets the description of this expense entry.
	*
	* @param description the description of this expense entry
	*/
	@Override
	public void setDescription(String description) {
		_expenseEntry.setDescription(description);
	}

	/**
	* Sets the employee ID of this expense entry.
	*
	* @param employeeId the employee ID of this expense entry
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_expenseEntry.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_expenseEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expenseEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expenseEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the exp date of this expense entry.
	*
	* @param expDate the exp date of this expense entry
	*/
	@Override
	public void setExpDate(Date expDate) {
		_expenseEntry.setExpDate(expDate);
	}

	/**
	* Sets the expense ID of this expense entry.
	*
	* @param expenseId the expense ID of this expense entry
	*/
	@Override
	public void setExpenseId(long expenseId) {
		_expenseEntry.setExpenseId(expenseId);
	}

	/**
	* Sets the group ID of this expense entry.
	*
	* @param groupId the group ID of this expense entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_expenseEntry.setGroupId(groupId);
	}

	/**
	* Sets the man approved date of this expense entry.
	*
	* @param manApprovedDate the man approved date of this expense entry
	*/
	@Override
	public void setManApprovedDate(Date manApprovedDate) {
		_expenseEntry.setManApprovedDate(manApprovedDate);
	}

	/**
	* Sets the man commnets of this expense entry.
	*
	* @param manCommnets the man commnets of this expense entry
	*/
	@Override
	public void setManCommnets(String manCommnets) {
		_expenseEntry.setManCommnets(manCommnets);
	}

	/**
	* Sets the man employee ID of this expense entry.
	*
	* @param manEmployeeId the man employee ID of this expense entry
	*/
	@Override
	public void setManEmployeeId(long manEmployeeId) {
		_expenseEntry.setManEmployeeId(manEmployeeId);
	}

	/**
	* Sets the modified date of this expense entry.
	*
	* @param modifiedDate the modified date of this expense entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_expenseEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the month year of this expense entry.
	*
	* @param monthYear the month year of this expense entry
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_expenseEntry.setMonthYear(monthYear);
	}

	@Override
	public void setNew(boolean n) {
		_expenseEntry.setNew(n);
	}

	/**
	* Sets the primary key of this expense entry.
	*
	* @param primaryKey the primary key of this expense entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expenseEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expenseEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this expense entry.
	*
	* @param projectId the project ID of this expense entry
	*/
	@Override
	public void setProjectId(long projectId) {
		_expenseEntry.setProjectId(projectId);
	}

	/**
	* Sets the status of this expense entry.
	*
	* @param status the status of this expense entry
	*/
	@Override
	public void setStatus(int status) {
		_expenseEntry.setStatus(status);
	}

	/**
	* Sets the status by user ID of this expense entry.
	*
	* @param statusByUserId the status by user ID of this expense entry
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_expenseEntry.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this expense entry.
	*
	* @param statusByUserName the status by user name of this expense entry
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_expenseEntry.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this expense entry.
	*
	* @param statusByUserUuid the status by user uuid of this expense entry
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_expenseEntry.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this expense entry.
	*
	* @param statusDate the status date of this expense entry
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_expenseEntry.setStatusDate(statusDate);
	}

	/**
	* Sets the title of this expense entry.
	*
	* @param title the title of this expense entry
	*/
	@Override
	public void setTitle(String title) {
		_expenseEntry.setTitle(title);
	}

	/**
	* Sets the user ID of this expense entry.
	*
	* @param userId the user ID of this expense entry
	*/
	@Override
	public void setUserId(long userId) {
		_expenseEntry.setUserId(userId);
	}

	/**
	* Sets the user name of this expense entry.
	*
	* @param userName the user name of this expense entry
	*/
	@Override
	public void setUserName(String userName) {
		_expenseEntry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this expense entry.
	*
	* @param userUuid the user uuid of this expense entry
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_expenseEntry.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExpenseEntry> toCacheModel() {
		return _expenseEntry.toCacheModel();
	}

	@Override
	public ExpenseEntry toEscapedModel() {
		return new ExpenseEntryWrapper(_expenseEntry.toEscapedModel());
	}

	@Override
	public String toString() {
		return _expenseEntry.toString();
	}

	@Override
	public ExpenseEntry toUnescapedModel() {
		return new ExpenseEntryWrapper(_expenseEntry.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _expenseEntry.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseEntryWrapper)) {
			return false;
		}

		ExpenseEntryWrapper expenseEntryWrapper = (ExpenseEntryWrapper)obj;

		if (Objects.equals(_expenseEntry, expenseEntryWrapper._expenseEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public ExpenseEntry getWrappedModel() {
		return _expenseEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expenseEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expenseEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_expenseEntry.resetOriginalValues();
	}

	private final ExpenseEntry _expenseEntry;
}