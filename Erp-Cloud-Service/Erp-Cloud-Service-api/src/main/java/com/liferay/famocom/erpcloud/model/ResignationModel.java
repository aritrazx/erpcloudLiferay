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
 * The base model interface for the Resignation service. Represents a row in the &quot;Resignation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.famocom.erpcloud.model.impl.ResignationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.famocom.erpcloud.model.impl.ResignationImpl}.
 * </p>
 *
 * @author Samaresh
 * @see Resignation
 * @see com.liferay.famocom.erpcloud.model.impl.ResignationImpl
 * @see com.liferay.famocom.erpcloud.model.impl.ResignationModelImpl
 * @generated
 */
@ProviderType
public interface ResignationModel extends BaseModel<Resignation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a resignation model instance should use the {@link Resignation} interface instead.
	 */

	/**
	 * Returns the primary key of this resignation.
	 *
	 * @return the primary key of this resignation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this resignation.
	 *
	 * @param primaryKey the primary key of this resignation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the resignation ID of this resignation.
	 *
	 * @return the resignation ID of this resignation
	 */
	public long getResignationId();

	/**
	 * Sets the resignation ID of this resignation.
	 *
	 * @param ResignationId the resignation ID of this resignation
	 */
	public void setResignationId(long ResignationId);

	/**
	 * Returns the employee ID of this resignation.
	 *
	 * @return the employee ID of this resignation
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this resignation.
	 *
	 * @param employeeId the employee ID of this resignation
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the resignation date of this resignation.
	 *
	 * @return the resignation date of this resignation
	 */
	public Date getResignationDate();

	/**
	 * Sets the resignation date of this resignation.
	 *
	 * @param resignationDate the resignation date of this resignation
	 */
	public void setResignationDate(Date resignationDate);

	/**
	 * Returns the resignation sub date of this resignation.
	 *
	 * @return the resignation sub date of this resignation
	 */
	public Date getResignationSubDate();

	/**
	 * Sets the resignation sub date of this resignation.
	 *
	 * @param resignationSubDate the resignation sub date of this resignation
	 */
	public void setResignationSubDate(Date resignationSubDate);

	/**
	 * Returns the description of this resignation.
	 *
	 * @return the description of this resignation
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this resignation.
	 *
	 * @param Description the description of this resignation
	 */
	public void setDescription(String Description);

	/**
	 * Returns the manager ID of this resignation.
	 *
	 * @return the manager ID of this resignation
	 */
	public long getManagerId();

	/**
	 * Sets the manager ID of this resignation.
	 *
	 * @param managerId the manager ID of this resignation
	 */
	public void setManagerId(long managerId);

	/**
	 * Returns the mancomment of this resignation.
	 *
	 * @return the mancomment of this resignation
	 */
	@AutoEscape
	public String getMancomment();

	/**
	 * Sets the mancomment of this resignation.
	 *
	 * @param mancomment the mancomment of this resignation
	 */
	public void setMancomment(String mancomment);

	/**
	 * Returns the mancommentdate of this resignation.
	 *
	 * @return the mancommentdate of this resignation
	 */
	public Date getMancommentdate();

	/**
	 * Sets the mancommentdate of this resignation.
	 *
	 * @param mancommentdate the mancommentdate of this resignation
	 */
	public void setMancommentdate(Date mancommentdate);

	/**
	 * Returns the status of this resignation.
	 *
	 * @return the status of this resignation
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this resignation is status.
	 *
	 * @return <code>true</code> if this resignation is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this resignation is status.
	 *
	 * @param status the status of this resignation
	 */
	public void setStatus(boolean status);

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
	public int compareTo(Resignation resignation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Resignation> toCacheModel();

	@Override
	public Resignation toEscapedModel();

	@Override
	public Resignation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}