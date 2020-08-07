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
 * Provides the local service utility for ExpProofFiles. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.ExpProofFilesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see ExpProofFilesLocalService
 * @see com.liferay.famocom.erpcloud.service.base.ExpProofFilesLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.ExpProofFilesLocalServiceImpl
 * @generated
 */
@ProviderType
public class ExpProofFilesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.ExpProofFilesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the exp proof files to the database. Also notifies the appropriate model listeners.
	*
	* @param expProofFiles the exp proof files
	* @return the exp proof files that was added
	*/
	public static com.liferay.famocom.erpcloud.model.ExpProofFiles addExpProofFiles(
		com.liferay.famocom.erpcloud.model.ExpProofFiles expProofFiles) {
		return getService().addExpProofFiles(expProofFiles);
	}

	/**
	* Creates a new exp proof files with the primary key. Does not add the exp proof files to the database.
	*
	* @param fileId the primary key for the new exp proof files
	* @return the new exp proof files
	*/
	public static com.liferay.famocom.erpcloud.model.ExpProofFiles createExpProofFiles(
		long fileId) {
		return getService().createExpProofFiles(fileId);
	}

	/**
	* Deletes the exp proof files from the database. Also notifies the appropriate model listeners.
	*
	* @param expProofFiles the exp proof files
	* @return the exp proof files that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.ExpProofFiles deleteExpProofFiles(
		com.liferay.famocom.erpcloud.model.ExpProofFiles expProofFiles) {
		return getService().deleteExpProofFiles(expProofFiles);
	}

	/**
	* Deletes the exp proof files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files that was removed
	* @throws PortalException if a exp proof files with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.ExpProofFiles deleteExpProofFiles(
		long fileId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteExpProofFiles(fileId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.ExpProofFiles fetchExpProofFiles(
		long fileId) {
		return getService().fetchExpProofFiles(fileId);
	}

	public static com.liferay.famocom.erpcloud.model.ExpProofFiles findByExpenceId(
		long expenceId) {
		return getService().findByExpenceId(expenceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the exp proof files with the primary key.
	*
	* @param fileId the primary key of the exp proof files
	* @return the exp proof files
	* @throws PortalException if a exp proof files with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.ExpProofFiles getExpProofFiles(
		long fileId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getExpProofFiles(fileId);
	}

	/**
	* Returns a range of all the exp proof fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of exp proof fileses
	* @param end the upper bound of the range of exp proof fileses (not inclusive)
	* @return the range of exp proof fileses
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.ExpProofFiles> getExpProofFileses(
		int start, int end) {
		return getService().getExpProofFileses(start, end);
	}

	/**
	* Returns the number of exp proof fileses.
	*
	* @return the number of exp proof fileses
	*/
	public static int getExpProofFilesesCount() {
		return getService().getExpProofFilesesCount();
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
	* Updates the exp proof files in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expProofFiles the exp proof files
	* @return the exp proof files that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.ExpProofFiles updateExpProofFiles(
		com.liferay.famocom.erpcloud.model.ExpProofFiles expProofFiles) {
		return getService().updateExpProofFiles(expProofFiles);
	}

	public static ExpProofFilesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpProofFilesLocalService, ExpProofFilesLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpProofFilesLocalService.class);

		ServiceTracker<ExpProofFilesLocalService, ExpProofFilesLocalService> serviceTracker =
			new ServiceTracker<ExpProofFilesLocalService, ExpProofFilesLocalService>(bundle.getBundleContext(),
				ExpProofFilesLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}