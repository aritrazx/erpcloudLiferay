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
 * This class is a wrapper for {@link RatingMaster}.
 * </p>
 *
 * @author Samaresh
 * @see RatingMaster
 * @generated
 */
@ProviderType
public class RatingMasterWrapper implements RatingMaster,
	ModelWrapper<RatingMaster> {
	public RatingMasterWrapper(RatingMaster ratingMaster) {
		_ratingMaster = ratingMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return RatingMaster.class;
	}

	@Override
	public String getModelClassName() {
		return RatingMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ratingId", getRatingId());
		attributes.put("ratingNum", getRatingNum());
		attributes.put("ratingKey", getRatingKey());
		attributes.put("ratingDescription", getRatingDescription());
		attributes.put("salaryPercentage", getSalaryPercentage());
		attributes.put("companyId", getCompanyId());
		attributes.put("addedDate", getAddedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ratingId = (Long)attributes.get("ratingId");

		if (ratingId != null) {
			setRatingId(ratingId);
		}

		String ratingNum = (String)attributes.get("ratingNum");

		if (ratingNum != null) {
			setRatingNum(ratingNum);
		}

		String ratingKey = (String)attributes.get("ratingKey");

		if (ratingKey != null) {
			setRatingKey(ratingKey);
		}

		String ratingDescription = (String)attributes.get("ratingDescription");

		if (ratingDescription != null) {
			setRatingDescription(ratingDescription);
		}

		Long salaryPercentage = (Long)attributes.get("salaryPercentage");

		if (salaryPercentage != null) {
			setSalaryPercentage(salaryPercentage);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date addedDate = (Date)attributes.get("addedDate");

		if (addedDate != null) {
			setAddedDate(addedDate);
		}
	}

	@Override
	public Object clone() {
		return new RatingMasterWrapper((RatingMaster)_ratingMaster.clone());
	}

	@Override
	public int compareTo(RatingMaster ratingMaster) {
		return _ratingMaster.compareTo(ratingMaster);
	}

	/**
	* Returns the added date of this rating master.
	*
	* @return the added date of this rating master
	*/
	@Override
	public Date getAddedDate() {
		return _ratingMaster.getAddedDate();
	}

	/**
	* Returns the company ID of this rating master.
	*
	* @return the company ID of this rating master
	*/
	@Override
	public long getCompanyId() {
		return _ratingMaster.getCompanyId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ratingMaster.getExpandoBridge();
	}

	/**
	* Returns the primary key of this rating master.
	*
	* @return the primary key of this rating master
	*/
	@Override
	public long getPrimaryKey() {
		return _ratingMaster.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ratingMaster.getPrimaryKeyObj();
	}

	/**
	* Returns the rating description of this rating master.
	*
	* @return the rating description of this rating master
	*/
	@Override
	public String getRatingDescription() {
		return _ratingMaster.getRatingDescription();
	}

	/**
	* Returns the rating ID of this rating master.
	*
	* @return the rating ID of this rating master
	*/
	@Override
	public long getRatingId() {
		return _ratingMaster.getRatingId();
	}

	/**
	* Returns the rating key of this rating master.
	*
	* @return the rating key of this rating master
	*/
	@Override
	public String getRatingKey() {
		return _ratingMaster.getRatingKey();
	}

	/**
	* Returns the rating num of this rating master.
	*
	* @return the rating num of this rating master
	*/
	@Override
	public String getRatingNum() {
		return _ratingMaster.getRatingNum();
	}

	/**
	* Returns the salary percentage of this rating master.
	*
	* @return the salary percentage of this rating master
	*/
	@Override
	public long getSalaryPercentage() {
		return _ratingMaster.getSalaryPercentage();
	}

	@Override
	public int hashCode() {
		return _ratingMaster.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ratingMaster.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ratingMaster.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ratingMaster.isNew();
	}

	@Override
	public void persist() {
		_ratingMaster.persist();
	}

	/**
	* Sets the added date of this rating master.
	*
	* @param addedDate the added date of this rating master
	*/
	@Override
	public void setAddedDate(Date addedDate) {
		_ratingMaster.setAddedDate(addedDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ratingMaster.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this rating master.
	*
	* @param companyId the company ID of this rating master
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ratingMaster.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ratingMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ratingMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ratingMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_ratingMaster.setNew(n);
	}

	/**
	* Sets the primary key of this rating master.
	*
	* @param primaryKey the primary key of this rating master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ratingMaster.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ratingMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rating description of this rating master.
	*
	* @param ratingDescription the rating description of this rating master
	*/
	@Override
	public void setRatingDescription(String ratingDescription) {
		_ratingMaster.setRatingDescription(ratingDescription);
	}

	/**
	* Sets the rating ID of this rating master.
	*
	* @param ratingId the rating ID of this rating master
	*/
	@Override
	public void setRatingId(long ratingId) {
		_ratingMaster.setRatingId(ratingId);
	}

	/**
	* Sets the rating key of this rating master.
	*
	* @param ratingKey the rating key of this rating master
	*/
	@Override
	public void setRatingKey(String ratingKey) {
		_ratingMaster.setRatingKey(ratingKey);
	}

	/**
	* Sets the rating num of this rating master.
	*
	* @param ratingNum the rating num of this rating master
	*/
	@Override
	public void setRatingNum(String ratingNum) {
		_ratingMaster.setRatingNum(ratingNum);
	}

	/**
	* Sets the salary percentage of this rating master.
	*
	* @param salaryPercentage the salary percentage of this rating master
	*/
	@Override
	public void setSalaryPercentage(long salaryPercentage) {
		_ratingMaster.setSalaryPercentage(salaryPercentage);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RatingMaster> toCacheModel() {
		return _ratingMaster.toCacheModel();
	}

	@Override
	public RatingMaster toEscapedModel() {
		return new RatingMasterWrapper(_ratingMaster.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ratingMaster.toString();
	}

	@Override
	public RatingMaster toUnescapedModel() {
		return new RatingMasterWrapper(_ratingMaster.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ratingMaster.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RatingMasterWrapper)) {
			return false;
		}

		RatingMasterWrapper ratingMasterWrapper = (RatingMasterWrapper)obj;

		if (Objects.equals(_ratingMaster, ratingMasterWrapper._ratingMaster)) {
			return true;
		}

		return false;
	}

	@Override
	public RatingMaster getWrappedModel() {
		return _ratingMaster;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ratingMaster.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ratingMaster.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ratingMaster.resetOriginalValues();
	}

	private final RatingMaster _ratingMaster;
}