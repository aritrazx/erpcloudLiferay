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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for LeaveApplyDtl. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Samaresh
 * @see LeaveApplyDtlLocalServiceUtil
 * @see com.liferay.famocom.erpcloud.service.base.LeaveApplyDtlLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.LeaveApplyDtlLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LeaveApplyDtlLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaveApplyDtlLocalServiceUtil} to access the leave apply dtl local service. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.LeaveApplyDtlLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the leave apply dtl to the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyDtl the leave apply dtl
	* @return the leave apply dtl that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LeaveApplyDtl addLeaveApplyDtl(LeaveApplyDtl leaveApplyDtl);

	/**
	* Creates a new leave apply dtl with the primary key. Does not add the leave apply dtl to the database.
	*
	* @param leaveApplyDtlId the primary key for the new leave apply dtl
	* @return the new leave apply dtl
	*/
	@Transactional(enabled = false)
	public LeaveApplyDtl createLeaveApplyDtl(long leaveApplyDtlId);

	/**
	* Deletes the leave apply dtl from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyDtl the leave apply dtl
	* @return the leave apply dtl that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public LeaveApplyDtl deleteLeaveApplyDtl(LeaveApplyDtl leaveApplyDtl);

	/**
	* Deletes the leave apply dtl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl that was removed
	* @throws PortalException if a leave apply dtl with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public LeaveApplyDtl deleteLeaveApplyDtl(long leaveApplyDtlId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LeaveApplyDtl fetchLeaveApplyDtl(long leaveApplyDtlId);

	public LeaveApplyDtl findByempIdAndAttDate(long employeeId, Date leaveDate,
		int isApprove) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the leave apply dtl with the primary key.
	*
	* @param leaveApplyDtlId the primary key of the leave apply dtl
	* @return the leave apply dtl
	* @throws PortalException if a leave apply dtl with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LeaveApplyDtl getLeaveApplyDtl(long leaveApplyDtlId)
		throws PortalException;

	/**
	* Returns a range of all the leave apply dtls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.LeaveApplyDtlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leave apply dtls
	* @param end the upper bound of the range of leave apply dtls (not inclusive)
	* @return the range of leave apply dtls
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LeaveApplyDtl> getLeaveApplyDtls(int start, int end);

	/**
	* Returns the number of leave apply dtls.
	*
	* @return the number of leave apply dtls
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLeaveApplyDtlsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasOverlappedLeaves(Date fromDate, Date toDate,
		long employeeId);

	/**
	* Updates the leave apply dtl in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaveApplyDtl the leave apply dtl
	* @return the leave apply dtl that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LeaveApplyDtl updateLeaveApplyDtl(LeaveApplyDtl leaveApplyDtl);
}