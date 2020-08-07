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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the selected candidate pay structure service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.SelectedCandidatePayStructurePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructurePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.SelectedCandidatePayStructurePersistenceImpl
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		getPersistence().clearCache(selectedCandidatePayStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SelectedCandidatePayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SelectedCandidatePayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SelectedCandidatePayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SelectedCandidatePayStructure update(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		return getPersistence().update(selectedCandidatePayStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SelectedCandidatePayStructure update(
		SelectedCandidatePayStructure selectedCandidatePayStructure,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(selectedCandidatePayStructure, serviceContext);
	}

	/**
	* Returns all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @return the matching selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus);
	}

	/**
	* Returns a range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @return the range of matching selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus, start, end);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a matching selected candidate pay structure could not be found
	*/
	public static SelectedCandidatePayStructure findByrecruitmentProcessIdAndPayStatus_First(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus_First(recruitmentProcessId,
			payStatus, orderByComparator);
	}

	/**
	* Returns the first selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching selected candidate pay structure, or <code>null</code> if a matching selected candidate pay structure could not be found
	*/
	public static SelectedCandidatePayStructure fetchByrecruitmentProcessIdAndPayStatus_First(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitmentProcessIdAndPayStatus_First(recruitmentProcessId,
			payStatus, orderByComparator);
	}

	/**
	* Returns the last selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a matching selected candidate pay structure could not be found
	*/
	public static SelectedCandidatePayStructure findByrecruitmentProcessIdAndPayStatus_Last(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus_Last(recruitmentProcessId,
			payStatus, orderByComparator);
	}

	/**
	* Returns the last selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching selected candidate pay structure, or <code>null</code> if a matching selected candidate pay structure could not be found
	*/
	public static SelectedCandidatePayStructure fetchByrecruitmentProcessIdAndPayStatus_Last(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return getPersistence()
				   .fetchByrecruitmentProcessIdAndPayStatus_Last(recruitmentProcessId,
			payStatus, orderByComparator);
	}

	/**
	* Returns the selected candidate pay structures before and after the current selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param candidatePayStructureId the primary key of the current selected candidate pay structure
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	*/
	public static SelectedCandidatePayStructure[] findByrecruitmentProcessIdAndPayStatus_PrevAndNext(
		long candidatePayStructureId, long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException {
		return getPersistence()
				   .findByrecruitmentProcessIdAndPayStatus_PrevAndNext(candidatePayStructureId,
			recruitmentProcessId, payStatus, orderByComparator);
	}

	/**
	* Removes all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63; from the database.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	*/
	public static void removeByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		getPersistence()
			.removeByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus);
	}

	/**
	* Returns the number of selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	*
	* @param recruitmentProcessId the recruitment process ID
	* @param payStatus the pay status
	* @return the number of matching selected candidate pay structures
	*/
	public static int countByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		return getPersistence()
				   .countByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus);
	}

	/**
	* Caches the selected candidate pay structure in the entity cache if it is enabled.
	*
	* @param selectedCandidatePayStructure the selected candidate pay structure
	*/
	public static void cacheResult(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		getPersistence().cacheResult(selectedCandidatePayStructure);
	}

	/**
	* Caches the selected candidate pay structures in the entity cache if it is enabled.
	*
	* @param selectedCandidatePayStructures the selected candidate pay structures
	*/
	public static void cacheResult(
		List<SelectedCandidatePayStructure> selectedCandidatePayStructures) {
		getPersistence().cacheResult(selectedCandidatePayStructures);
	}

	/**
	* Creates a new selected candidate pay structure with the primary key. Does not add the selected candidate pay structure to the database.
	*
	* @param candidatePayStructureId the primary key for the new selected candidate pay structure
	* @return the new selected candidate pay structure
	*/
	public static SelectedCandidatePayStructure create(
		long candidatePayStructureId) {
		return getPersistence().create(candidatePayStructureId);
	}

	/**
	* Removes the selected candidate pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure that was removed
	* @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	*/
	public static SelectedCandidatePayStructure remove(
		long candidatePayStructureId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException {
		return getPersistence().remove(candidatePayStructureId);
	}

	public static SelectedCandidatePayStructure updateImpl(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		return getPersistence().updateImpl(selectedCandidatePayStructure);
	}

	/**
	* Returns the selected candidate pay structure with the primary key or throws a {@link NoSuchSelectedCandidatePayStructureException} if it could not be found.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure
	* @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	*/
	public static SelectedCandidatePayStructure findByPrimaryKey(
		long candidatePayStructureId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException {
		return getPersistence().findByPrimaryKey(candidatePayStructureId);
	}

	/**
	* Returns the selected candidate pay structure with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidatePayStructureId the primary key of the selected candidate pay structure
	* @return the selected candidate pay structure, or <code>null</code> if a selected candidate pay structure with the primary key could not be found
	*/
	public static SelectedCandidatePayStructure fetchByPrimaryKey(
		long candidatePayStructureId) {
		return getPersistence().fetchByPrimaryKey(candidatePayStructureId);
	}

	public static java.util.Map<java.io.Serializable, SelectedCandidatePayStructure> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the selected candidate pay structures.
	*
	* @return the selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @return the range of selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findAll(int start,
		int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the selected candidate pay structures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of selected candidate pay structures
	* @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of selected candidate pay structures
	*/
	public static List<SelectedCandidatePayStructure> findAll(int start,
		int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the selected candidate pay structures from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of selected candidate pay structures.
	*
	* @return the number of selected candidate pay structures
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SelectedCandidatePayStructurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SelectedCandidatePayStructurePersistence, SelectedCandidatePayStructurePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SelectedCandidatePayStructurePersistence.class);

		ServiceTracker<SelectedCandidatePayStructurePersistence, SelectedCandidatePayStructurePersistence> serviceTracker =
			new ServiceTracker<SelectedCandidatePayStructurePersistence, SelectedCandidatePayStructurePersistence>(bundle.getBundleContext(),
				SelectedCandidatePayStructurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}