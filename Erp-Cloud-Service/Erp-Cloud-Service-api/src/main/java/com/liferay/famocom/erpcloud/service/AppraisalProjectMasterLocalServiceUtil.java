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
 * Provides the local service utility for AppraisalProjectMaster. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.AppraisalProjectMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see AppraisalProjectMasterLocalService
 * @see com.liferay.famocom.erpcloud.service.base.AppraisalProjectMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.AppraisalProjectMasterLocalServiceImpl
 * @generated
 */
@ProviderType
public class AppraisalProjectMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.AppraisalProjectMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the appraisal project master to the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalProjectMaster the appraisal project master
	* @return the appraisal project master that was added
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster addAppraisalProjectMaster(
		com.liferay.famocom.erpcloud.model.AppraisalProjectMaster appraisalProjectMaster) {
		return getService().addAppraisalProjectMaster(appraisalProjectMaster);
	}

	/**
	* Creates a new appraisal project master with the primary key. Does not add the appraisal project master to the database.
	*
	* @param appraisalProjectId the primary key for the new appraisal project master
	* @return the new appraisal project master
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster createAppraisalProjectMaster(
		long appraisalProjectId) {
		return getService().createAppraisalProjectMaster(appraisalProjectId);
	}

	/**
	* Deletes the appraisal project master from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalProjectMaster the appraisal project master
	* @return the appraisal project master that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster deleteAppraisalProjectMaster(
		com.liferay.famocom.erpcloud.model.AppraisalProjectMaster appraisalProjectMaster) {
		return getService().deleteAppraisalProjectMaster(appraisalProjectMaster);
	}

	/**
	* Deletes the appraisal project master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master that was removed
	* @throws PortalException if a appraisal project master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster deleteAppraisalProjectMaster(
		long appraisalProjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAppraisalProjectMaster(appraisalProjectId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster fetchAppraisalProjectMaster(
		long appraisalProjectId) {
		return getService().fetchAppraisalProjectMaster(appraisalProjectId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.AppraisalProjectMaster> findByAppraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByAppraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.AppraisalProjectMaster> findByEmployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByEmployeeListFromManager(appraisalSettingId,
			projectId, submitStep);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.AppraisalProjectMaster> findBySettingIdAndEmployeeIdApprasialIdList(
		long appraisalSettingId, long employeeId, long appraisalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findBySettingIdAndEmployeeIdApprasialIdList(appraisalSettingId,
			employeeId, appraisalId);
	}

	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster findBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the appraisal project master with the primary key.
	*
	* @param appraisalProjectId the primary key of the appraisal project master
	* @return the appraisal project master
	* @throws PortalException if a appraisal project master with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster getAppraisalProjectMaster(
		long appraisalProjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAppraisalProjectMaster(appraisalProjectId);
	}

	/**
	* Returns a range of all the appraisal project masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of appraisal project masters
	* @param end the upper bound of the range of appraisal project masters (not inclusive)
	* @return the range of appraisal project masters
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.AppraisalProjectMaster> getAppraisalProjectMasters(
		int start, int end) {
		return getService().getAppraisalProjectMasters(start, end);
	}

	/**
	* Returns the number of appraisal project masters.
	*
	* @return the number of appraisal project masters
	*/
	public static int getAppraisalProjectMastersCount() {
		return getService().getAppraisalProjectMastersCount();
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
	* Updates the appraisal project master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param appraisalProjectMaster the appraisal project master
	* @return the appraisal project master that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.AppraisalProjectMaster updateAppraisalProjectMaster(
		com.liferay.famocom.erpcloud.model.AppraisalProjectMaster appraisalProjectMaster) {
		return getService().updateAppraisalProjectMaster(appraisalProjectMaster);
	}

	public static AppraisalProjectMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppraisalProjectMasterLocalService, AppraisalProjectMasterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppraisalProjectMasterLocalService.class);

		ServiceTracker<AppraisalProjectMasterLocalService, AppraisalProjectMasterLocalService> serviceTracker =
			new ServiceTracker<AppraisalProjectMasterLocalService, AppraisalProjectMasterLocalService>(bundle.getBundleContext(),
				AppraisalProjectMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}