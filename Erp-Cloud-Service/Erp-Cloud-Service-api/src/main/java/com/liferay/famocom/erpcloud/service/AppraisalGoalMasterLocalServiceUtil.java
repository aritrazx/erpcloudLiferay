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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AppraisalGoalMaster. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.AppraisalGoalMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see AppraisalGoalMasterLocalService
 * @see com.liferay.famocom.erpcloud.service.base.AppraisalGoalMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.AppraisalGoalMasterLocalServiceImpl
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.AppraisalGoalMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the appraisal goal master to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMaster the appraisal goal master
	* @return the appraisal goal master that was added
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster addAppraisalGoalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalGoalMaster appraisalGoalMaster) {
		return getService().addAppraisalGoalMaster(appraisalGoalMaster);
	}

	/**
	* Creates a new appraisal goal master with the primary key. Does not add the appraisal goal master to the database.
	*
	* @param appraisalGoalMasterId the primary key for the new appraisal goal master
	* @return the new appraisal goal master
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster createAppraisalGoalMaster(
		long appraisalGoalMasterId) {
		return getService().createAppraisalGoalMaster(appraisalGoalMasterId);
	}

	/**
	* Deletes the appraisal goal master from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMaster the appraisal goal master
	* @return the appraisal goal master that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster deleteAppraisalGoalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalGoalMaster appraisalGoalMaster) {
		return getService().deleteAppraisalGoalMaster(appraisalGoalMaster);
	}

	/**
	* Deletes the appraisal goal master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master that was removed
	* @throws PortalException if a appraisal goal master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster deleteAppraisalGoalMaster(
		long appraisalGoalMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAppraisalGoalMaster(appraisalGoalMasterId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster fetchAppraisalGoalMaster(
		long appraisalGoalMasterId) {
		return getService().fetchAppraisalGoalMaster(appraisalGoalMasterId);
	}

	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster findByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId) {
		return getService()
				   .findByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal goal master with the primary key.
	*
	* @param appraisalGoalMasterId the primary key of the appraisal goal master
	* @return the appraisal goal master
	* @throws PortalException if a appraisal goal master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster getAppraisalGoalMaster(
		long appraisalGoalMasterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAppraisalGoalMaster(appraisalGoalMasterId);
	}

	/**
	* Returns a range of all the appraisal goal masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal goal masters
	* @param end the upper bound of the range of appraisal goal masters (not inclusive)
	* @return the range of appraisal goal masters
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.AppraisalGoalMaster> getAppraisalGoalMasters(
		int start, int end) {
		return getService().getAppraisalGoalMasters(start, end);
	}

	/**
	* Returns the number of appraisal goal masters.
	*
	* @return the number of appraisal goal masters
	*/
	public static int getAppraisalGoalMastersCount() {
		return getService().getAppraisalGoalMastersCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the appraisal goal master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalGoalMaster the appraisal goal master
	* @return the appraisal goal master that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalGoalMaster updateAppraisalGoalMaster(
		com.liferay.famocom.erpcloud.model.AppraisalGoalMaster appraisalGoalMaster) {
		return getService().updateAppraisalGoalMaster(appraisalGoalMaster);
	}

	public static AppraisalGoalMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalGoalMasterLocalService, AppraisalGoalMasterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalGoalMasterLocalService.class);

		ServiceTracker<AppraisalGoalMasterLocalService, AppraisalGoalMasterLocalService> serviceTracker =
			new ServiceTracker<AppraisalGoalMasterLocalService, AppraisalGoalMasterLocalService>(bundle.getBundleContext(),
				AppraisalGoalMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}