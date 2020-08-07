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
 * This class is a wrapper for {@link Expense}.
 * </p>
 *
 * @author Samaresh
 * @see Expense
 * @generated
 */
@ProviderType
public class ExpenseWrapper implements Expense, ModelWrapper<Expense> {
	public ExpenseWrapper(Expense expense) {
		_expense = expense;
	}

	@Override
	public Class<?> getModelClass() {
		return Expense.class;
	}

	@Override
	public String getModelClassName() {
		return Expense.class.getName();
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
	}

	@Override
	public Object clone() {
		return new ExpenseWrapper((Expense)_expense.clone());
	}

	@Override
	public int compareTo(Expense expense) {
		return _expense.compareTo(expense);
	}

	/**
	* Returns the acc approved date of this expense.
	*
	* @return the acc approved date of this expense
	*/
	@Override
	public Date getAccApprovedDate() {
		return _expense.getAccApprovedDate();
	}

	/**
	* Returns the acc comments of this expense.
	*
	* @return the acc comments of this expense
	*/
	@Override
	public String getAccComments() {
		return _expense.getAccComments();
	}

	/**
	* Returns the amount of this expense.
	*
	* @return the amount of this expense
	*/
	@Override
	public double getAmount() {
		return _expense.getAmount();
	}

	/**
	* Returns the cat ID of this expense.
	*
	* @return the cat ID of this expense
	*/
	@Override
	public long getCatId() {
		return _expense.getCatId();
	}

	/**
	* Returns the company ID of this expense.
	*
	* @return the company ID of this expense
	*/
	@Override
	public long getCompanyId() {
		return _expense.getCompanyId();
	}

	/**
	* Returns the create date of this expense.
	*
	* @return the create date of this expense
	*/
	@Override
	public Date getCreateDate() {
		return _expense.getCreateDate();
	}

	/**
	* Returns the description of this expense.
	*
	* @return the description of this expense
	*/
	@Override
	public String getDescription() {
		return _expense.getDescription();
	}

	/**
	* Returns the employee ID of this expense.
	*
	* @return the employee ID of this expense
	*/
	@Override
	public long getEmployeeId() {
		return _expense.getEmployeeId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expense.getExpandoBridge();
	}

	/**
	* Returns the exp date of this expense.
	*
	* @return the exp date of this expense
	*/
	@Override
	public Date getExpDate() {
		return _expense.getExpDate();
	}

	/**
	* Returns the expense ID of this expense.
	*
	* @return the expense ID of this expense
	*/
	@Override
	public long getExpenseId() {
		return _expense.getExpenseId();
	}

	/**
	* Returns the group ID of this expense.
	*
	* @return the group ID of this expense
	*/
	@Override
	public long getGroupId() {
		return _expense.getGroupId();
	}

	/**
	* Returns the man approved date of this expense.
	*
	* @return the man approved date of this expense
	*/
	@Override
	public Date getManApprovedDate() {
		return _expense.getManApprovedDate();
	}

	/**
	* Returns the man commnets of this expense.
	*
	* @return the man commnets of this expense
	*/
	@Override
	public String getManCommnets() {
		return _expense.getManCommnets();
	}

	/**
	* Returns the man employee ID of this expense.
	*
	* @return the man employee ID of this expense
	*/
	@Override
	public long getManEmployeeId() {
		return _expense.getManEmployeeId();
	}

	/**
	* Returns the modified date of this expense.
	*
	* @return the modified date of this expense
	*/
	@Override
	public Date getModifiedDate() {
		return _expense.getModifiedDate();
	}

	/**
	* Returns the month year of this expense.
	*
	* @return the month year of this expense
	*/
	@Override
	public long getMonthYear() {
		return _expense.getMonthYear();
	}

	/**
	* Returns the primary key of this expense.
	*
	* @return the primary key of this expense
	*/
	@Override
	public long getPrimaryKey() {
		return _expense.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expense.getPrimaryKeyObj();
	}

	/**
	* Returns the project ID of this expense.
	*
	* @return the project ID of this expense
	*/
	@Override
	public long getProjectId() {
		return _expense.getProjectId();
	}

	/**
	* Returns the status of this expense.
	*
	* @return the status of this expense
	*/
	@Override
	public int getStatus() {
		return _expense.getStatus();
	}

	/**
	* Returns the title of this expense.
	*
	* @return the title of this expense
	*/
	@Override
	public String getTitle() {
		return _expense.getTitle();
	}

	/**
	* Returns the user ID of this expense.
	*
	* @return the user ID of this expense
	*/
	@Override
	public long getUserId() {
		return _expense.getUserId();
	}

	/**
	* Returns the user name of this expense.
	*
	* @return the user name of this expense
	*/
	@Override
	public String getUserName() {
		return _expense.getUserName();
	}

	/**
	* Returns the user uuid of this expense.
	*
	* @return the user uuid of this expense
	*/
	@Override
	public String getUserUuid() {
		return _expense.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _expense.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _expense.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _expense.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _expense.isNew();
	}

	@Override
	public void persist() {
		_expense.persist();
	}

	/**
	* Sets the acc approved date of this expense.
	*
	* @param accApprovedDate the acc approved date of this expense
	*/
	@Override
	public void setAccApprovedDate(Date accApprovedDate) {
		_expense.setAccApprovedDate(accApprovedDate);
	}

	/**
	* Sets the acc comments of this expense.
	*
	* @param accComments the acc comments of this expense
	*/
	@Override
	public void setAccComments(String accComments) {
		_expense.setAccComments(accComments);
	}

	/**
	* Sets the amount of this expense.
	*
	* @param amount the amount of this expense
	*/
	@Override
	public void setAmount(double amount) {
		_expense.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expense.setCachedModel(cachedModel);
	}

	/**
	* Sets the cat ID of this expense.
	*
	* @param catId the cat ID of this expense
	*/
	@Override
	public void setCatId(long catId) {
		_expense.setCatId(catId);
	}

	/**
	* Sets the company ID of this expense.
	*
	* @param companyId the company ID of this expense
	*/
	@Override
	public void setCompanyId(long companyId) {
		_expense.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this expense.
	*
	* @param createDate the create date of this expense
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_expense.setCreateDate(createDate);
	}

	/**
	* Sets the description of this expense.
	*
	* @param description the description of this expense
	*/
	@Override
	public void setDescription(String description) {
		_expense.setDescription(description);
	}

	/**
	* Sets the employee ID of this expense.
	*
	* @param employeeId the employee ID of this expense
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_expense.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_expense.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expense.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expense.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the exp date of this expense.
	*
	* @param expDate the exp date of this expense
	*/
	@Override
	public void setExpDate(Date expDate) {
		_expense.setExpDate(expDate);
	}

	/**
	* Sets the expense ID of this expense.
	*
	* @param expenseId the expense ID of this expense
	*/
	@Override
	public void setExpenseId(long expenseId) {
		_expense.setExpenseId(expenseId);
	}

	/**
	* Sets the group ID of this expense.
	*
	* @param groupId the group ID of this expense
	*/
	@Override
	public void setGroupId(long groupId) {
		_expense.setGroupId(groupId);
	}

	/**
	* Sets the man approved date of this expense.
	*
	* @param manApprovedDate the man approved date of this expense
	*/
	@Override
	public void setManApprovedDate(Date manApprovedDate) {
		_expense.setManApprovedDate(manApprovedDate);
	}

	/**
	* Sets the man commnets of this expense.
	*
	* @param manCommnets the man commnets of this expense
	*/
	@Override
	public void setManCommnets(String manCommnets) {
		_expense.setManCommnets(manCommnets);
	}

	/**
	* Sets the man employee ID of this expense.
	*
	* @param manEmployeeId the man employee ID of this expense
	*/
	@Override
	public void setManEmployeeId(long manEmployeeId) {
		_expense.setManEmployeeId(manEmployeeId);
	}

	/**
	* Sets the modified date of this expense.
	*
	* @param modifiedDate the modified date of this expense
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_expense.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the month year of this expense.
	*
	* @param monthYear the month year of this expense
	*/
	@Override
	public void setMonthYear(long monthYear) {
		_expense.setMonthYear(monthYear);
	}

	@Override
	public void setNew(boolean n) {
		_expense.setNew(n);
	}

	/**
	* Sets the primary key of this expense.
	*
	* @param primaryKey the primary key of this expense
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expense.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expense.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this expense.
	*
	* @param projectId the project ID of this expense
	*/
	@Override
	public void setProjectId(long projectId) {
		_expense.setProjectId(projectId);
	}

	/**
	* Sets the status of this expense.
	*
	* @param status the status of this expense
	*/
	@Override
	public void setStatus(int status) {
		_expense.setStatus(status);
	}

	/**
	* Sets the title of this expense.
	*
	* @param title the title of this expense
	*/
	@Override
	public void setTitle(String title) {
		_expense.setTitle(title);
	}

	/**
	* Sets the user ID of this expense.
	*
	* @param userId the user ID of this expense
	*/
	@Override
	public void setUserId(long userId) {
		_expense.setUserId(userId);
	}

	/**
	* Sets the user name of this expense.
	*
	* @param userName the user name of this expense
	*/
	@Override
	public void setUserName(String userName) {
		_expense.setUserName(userName);
	}

	/**
	* Sets the user uuid of this expense.
	*
	* @param userUuid the user uuid of this expense
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_expense.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Expense> toCacheModel() {
		return _expense.toCacheModel();
	}

	@Override
	public Expense toEscapedModel() {
		return new ExpenseWrapper(_expense.toEscapedModel());
	}

	@Override
	public String toString() {
		return _expense.toString();
	}

	@Override
	public Expense toUnescapedModel() {
		return new ExpenseWrapper(_expense.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _expense.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseWrapper)) {
			return false;
		}

		ExpenseWrapper expenseWrapper = (ExpenseWrapper)obj;

		if (Objects.equals(_expense, expenseWrapper._expense)) {
			return true;
		}

		return false;
	}

	@Override
	public Expense getWrappedModel() {
		return _expense;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expense.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expense.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_expense.resetOriginalValues();
	}

	private final Expense _expense;
}