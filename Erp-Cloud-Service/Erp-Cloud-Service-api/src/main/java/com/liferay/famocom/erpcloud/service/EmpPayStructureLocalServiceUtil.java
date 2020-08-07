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
 * Provides the local service utility for EmpPayStructure. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.EmpPayStructureLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Samaresh
 * @see EmpPayStructureLocalService
 * @see com.liferay.famocom.erpcloud.service.base.EmpPayStructureLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.EmpPayStructureLocalServiceImpl
 * @generated
 */
@ProviderType
public class EmpPayStructureLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.EmpPayStructureLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the emp pay structure to the database. Also notifies the appropriate model listeners.
	*
	* @param empPayStructure the emp pay structure
	* @return the emp pay structure that was added
	*/
	public static com.liferay.famocom.erpcloud.model.EmpPayStructure addEmpPayStructure(
		com.liferay.famocom.erpcloud.model.EmpPayStructure empPayStructure) {
		return getService().addEmpPayStructure(empPayStructure);
	}

	/**
	* Creates a new emp pay structure with the primary key. Does not add the emp pay structure to the database.
	*
	* @param empPayStructureId the primary key for the new emp pay structure
	* @return the new emp pay structure
	*/
	public static com.liferay.famocom.erpcloud.model.EmpPayStructure createEmpPayStructure(
		long empPayStructureId) {
		return getService().createEmpPayStructure(empPayStructureId);
	}

	/**
	* Deletes the emp pay structure from the database. Also notifies the appropriate model listeners.
	*
	* @param empPayStructure the emp pay structure
	* @return the emp pay structure that was removed
	*/
	public static com.liferay.famocom.erpcloud.model.EmpPayStructure deleteEmpPayStructure(
		com.liferay.famocom.erpcloud.model.EmpPayStructure empPayStructure) {
		return getService().deleteEmpPayStructure(empPayStructure);
	}

	/**
	* Deletes the emp pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure that was removed
	* @throws PortalException if a emp pay structure with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.EmpPayStructure deleteEmpPayStructure(
		long empPayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmpPayStructure(empPayStructureId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.famocom.erpcloud.model.EmpPayStructure fetchEmpPayStructure(
		long empPayStructureId) {
		return getService().fetchEmpPayStructure(empPayStructureId);
	}

	public static com.liferay.famocom.erpcloud.model.EmpPayStructure findByemployeeIdPayComponentId(
		long employeeId, long payComponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByemployeeIdPayComponentId(employeeId, payComponentId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.EmpPayStructure> findEmpPayStructureByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findEmpPayStructureByEmployeeId(employeeId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.EmpPayStructure> findEmpPayStructureByPayComponentId(
		long paycomponentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findEmpPayStructureByPayComponentId(paycomponentId);
	}

	public static com.liferay.famocom.erpcloud.model.EmpPayStructure findEmpPayStructureByPayComponentIdAndEmployeeId(
		long paycomponentId, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException {
		return getService()
				   .findEmpPayStructureByPayComponentIdAndEmployeeId(paycomponentId,
			employeeId);
	}

	public static java.util.List<com.liferay.famocom.erpcloud.model.EmpPayStructure> findEmpPayStructureByPayComponentIdsAndEmployeeId(
		long[] paycomponentIds, long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findEmpPayStructureByPayComponentIdsAndEmployeeId(paycomponentIds,
			employeeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<Long> getEmployeeIdFromEmpPayStructure() {
		return getService().getEmployeeIdFromEmpPayStructure();
	}

	/**
	* Returns the emp pay structure with the primary key.
	*
	* @param empPayStructureId the primary key of the emp pay structure
	* @return the emp pay structure
	* @throws PortalException if a emp pay structure with the primary key could not be found
	*/
	public static com.liferay.famocom.erpcloud.model.EmpPayStructure getEmpPayStructure(
		long empPayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmpPayStructure(empPayStructureId);
	}

	/**
	* Returns a range of all the emp pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp pay structures
	* @param end the upper bound of the range of emp pay structures (not inclusive)
	* @return the range of emp pay structures
	*/
	public static java.util.List<com.liferay.famocom.erpcloud.model.EmpPayStructure> getEmpPayStructures(
		int start, int end) {
		return getService().getEmpPayStructures(start, end);
	}

	/**
	* Returns the number of emp pay structures.
	*
	* @return the number of emp pay structures
	*/
	public static int getEmpPayStructuresCount() {
		return getService().getEmpPayStructuresCount();
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
	* Updates the emp pay structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empPayStructure the emp pay structure
	* @return the emp pay structure that was updated
	*/
	public static com.liferay.famocom.erpcloud.model.EmpPayStructure updateEmpPayStructure(
		com.liferay.famocom.erpcloud.model.EmpPayStructure empPayStructure) {
		return getService().updateEmpPayStructure(empPayStructure);
	}

	public static EmpPayStructureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmpPayStructureLocalService, EmpPayStructureLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmpPayStructureLocalService.class);

		ServiceTracker<EmpPayStructureLocalService, EmpPayStructureLocalService> serviceTracker =
			new ServiceTracker<EmpPayStructureLocalService, EmpPayStructureLocalService>(bundle.getBundleContext(),
				EmpPayStructureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}