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
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AppraisalPerformance service. Represents a row in the &quot;appraisalPerformance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceImpl}.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalPerformance
 * @see com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceImpl
 * @see com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl
 * @generated
 */
@ProviderType
public interface AppraisalPerformanceModel extends BaseModel<AppraisalPerformance>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a appraisal performance model instance should use the {@link AppraisalPerformance} interface instead.
	 */

	/**
	 * Returns the primary key of this appraisal performance.
	 *
	 * @return the primary key of this appraisal performance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this appraisal performance.
	 *
	 * @param primaryKey the primary key of this appraisal performance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the appraisal performance ID of this appraisal performance.
	 *
	 * @return the appraisal performance ID of this appraisal performance
	 */
	public long getAppraisalPerformanceId();

	/**
	 * Sets the appraisal performance ID of this appraisal performance.
	 *
	 * @param appraisalPerformanceId the appraisal performance ID of this appraisal performance
	 */
	public void setAppraisalPerformanceId(long appraisalPerformanceId);

	/**
	 * Returns the company ID of this appraisal performance.
	 *
	 * @return the company ID of this appraisal performance
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this appraisal performance.
	 *
	 * @param companyId the company ID of this appraisal performance
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the appraisal ID of this appraisal performance.
	 *
	 * @return the appraisal ID of this appraisal performance
	 */
	public long getAppraisalId();

	/**
	 * Sets the appraisal ID of this appraisal performance.
	 *
	 * @param appraisalId the appraisal ID of this appraisal performance
	 */
	public void setAppraisalId(long appraisalId);

	/**
	 * Returns the employee ID of this appraisal performance.
	 *
	 * @return the employee ID of this appraisal performance
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this appraisal performance.
	 *
	 * @param employeeId the employee ID of this appraisal performance
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the appraisal setting ID of this appraisal performance.
	 *
	 * @return the appraisal setting ID of this appraisal performance
	 */
	public long getAppraisalSettingId();

	/**
	 * Sets the appraisal setting ID of this appraisal performance.
	 *
	 * @param appraisalSettingId the appraisal setting ID of this appraisal performance
	 */
	public void setAppraisalSettingId(long appraisalSettingId);

	/**
	 * Returns the performance ID of this appraisal performance.
	 *
	 * @return the performance ID of this appraisal performance
	 */
	public long getPerformanceId();

	/**
	 * Sets the performance ID of this appraisal performance.
	 *
	 * @param performanceId the performance ID of this appraisal performance
	 */
	public void setPerformanceId(long performanceId);

	/**
	 * Returns the performance comm of this appraisal performance.
	 *
	 * @return the performance comm of this appraisal performance
	 */
	@AutoEscape
	public String getPerformanceComm();

	/**
	 * Sets the performance comm of this appraisal performance.
	 *
	 * @param performanceComm the performance comm of this appraisal performance
	 */
	public void setPerformanceComm(String performanceComm);

	/**
	 * Returns the rating ID emp of this appraisal performance.
	 *
	 * @return the rating ID emp of this appraisal performance
	 */
	public long getRatingIdEmp();

	/**
	 * Sets the rating ID emp of this appraisal performance.
	 *
	 * @param ratingIdEmp the rating ID emp of this appraisal performance
	 */
	public void setRatingIdEmp(long ratingIdEmp);

	/**
	 * Returns the rating ID man of this appraisal performance.
	 *
	 * @return the rating ID man of this appraisal performance
	 */
	public long getRatingIdMan();

	/**
	 * Sets the rating ID man of this appraisal performance.
	 *
	 * @param ratingIdMan the rating ID man of this appraisal performance
	 */
	public void setRatingIdMan(long ratingIdMan);

	/**
	 * Returns the created date of this appraisal performance.
	 *
	 * @return the created date of this appraisal performance
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this appraisal performance.
	 *
	 * @param createdDate the created date of this appraisal performance
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the created by of this appraisal performance.
	 *
	 * @return the created by of this appraisal performance
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this appraisal performance.
	 *
	 * @param createdBy the created by of this appraisal performance
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this appraisal performance.
	 *
	 * @return the modified date of this appraisal performance
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this appraisal performance.
	 *
	 * @param modifiedDate the modified date of this appraisal performance
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this appraisal performance.
	 *
	 * @return the modified by of this appraisal performance
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this appraisal performance.
	 *
	 * @param modifiedBy the modified by of this appraisal performance
	 */
	public void setModifiedBy(long modifiedBy);

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
	public int compareTo(AppraisalPerformance appraisalPerformance);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AppraisalPerformance> toCacheModel();

	@Override
	public AppraisalPerformance toEscapedModel();

	@Override
	public AppraisalPerformance toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}