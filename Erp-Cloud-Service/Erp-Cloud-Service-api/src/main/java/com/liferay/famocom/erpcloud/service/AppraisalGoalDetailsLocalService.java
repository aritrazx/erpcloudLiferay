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

import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;

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

import java.util.List;

/**
 * Provides the local service interface for AppraisalGoalDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Samaresh
 * @see AppraisalGoalDetailsLocalServiceUtil
 * @see com.liferay.famocom.erpcloud.service.base.AppraisalGoalDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.AppraisalGoalDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AppraisalGoalDetailsLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppraisalGoalDetailsLocalServiceUtil} to access the appraisal goal details local service. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.AppraisalGoalDetailsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the appraisal goal details to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetails the appraisal goal details
	* @return the appraisal goal details that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalGoalDetails addAppraisalGoalDetails(
		AppraisalGoalDetails appraisalGoalDetails);

	/**
	* Creates a new appraisal goal details with the primary key. Does not add the appraisal goal details to the database.
	*
	* @param appraisalGoalDetailsId the primary key for the new appraisal goal details
	* @return the new appraisal goal details
	*/
	@Transactional(enabled = false)
	public AppraisalGoalDetails createAppraisalGoalDetails(
		long appraisalGoalDetailsId);

	/**
	* Deletes the appraisal goal details from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetails the appraisal goal details
	* @return the appraisal goal details that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public AppraisalGoalDetails deleteAppraisalGoalDetails(
		AppraisalGoalDetails appraisalGoalDetails);

	/**
	* Deletes the appraisal goal details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details that was removed
	* @throws PortalException if a appraisal goal details with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public AppraisalGoalDetails deleteAppraisalGoalDetails(
		long appraisalGoalDetailsId) throws PortalException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public AppraisalGoalDetails fetchAppraisalGoalDetails(
		long appraisalGoalDetailsId);

	public AppraisalGoalDetails findByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the appraisal goal details with the primary key.
	*
	* @param appraisalGoalDetailsId the primary key of the appraisal goal details
	* @return the appraisal goal details
	* @throws PortalException if a appraisal goal details with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AppraisalGoalDetails getAppraisalGoalDetails(
		long appraisalGoalDetailsId) throws PortalException;

	/**
	* Returns a range of all the appraisal goal detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal detailses
	* @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	* @return the range of appraisal goal detailses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AppraisalGoalDetails> getAppraisalGoalDetailses(int start,
		int end);

	/**
	* Returns the number of appraisal goal detailses.
	*
	* @return the number of appraisal goal detailses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAppraisalGoalDetailsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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

	/**
	* Updates the appraisal goal details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalDetails the appraisal goal details
	* @return the appraisal goal details that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AppraisalGoalDetails updateAppraisalGoalDetails(
		AppraisalGoalDetails appraisalGoalDetails);
}