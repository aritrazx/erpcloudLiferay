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

import com.liferay.famocom.erpcloud.model.BillDocumentUploadFile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the bill document upload file service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.BillDocumentUploadFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BillDocumentUploadFilePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.BillDocumentUploadFilePersistenceImpl
 * @generated
 */
@ProviderType
public class BillDocumentUploadFileUtil {
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
	public static void clearCache(BillDocumentUploadFile billDocumentUploadFile) {
		getPersistence().clearCache(billDocumentUploadFile);
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
	public static List<BillDocumentUploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BillDocumentUploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BillDocumentUploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BillDocumentUploadFile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BillDocumentUploadFile update(
		BillDocumentUploadFile billDocumentUploadFile) {
		return getPersistence().update(billDocumentUploadFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BillDocumentUploadFile update(
		BillDocumentUploadFile billDocumentUploadFile,
		ServiceContext serviceContext) {
		return getPersistence().update(billDocumentUploadFile, serviceContext);
	}

	/**
	* Caches the bill document upload file in the entity cache if it is enabled.
	*
	* @param billDocumentUploadFile the bill document upload file
	*/
	public static void cacheResult(
		BillDocumentUploadFile billDocumentUploadFile) {
		getPersistence().cacheResult(billDocumentUploadFile);
	}

	/**
	* Caches the bill document upload files in the entity cache if it is enabled.
	*
	* @param billDocumentUploadFiles the bill document upload files
	*/
	public static void cacheResult(
		List<BillDocumentUploadFile> billDocumentUploadFiles) {
		getPersistence().cacheResult(billDocumentUploadFiles);
	}

	/**
	* Creates a new bill document upload file with the primary key. Does not add the bill document upload file to the database.
	*
	* @param documentId the primary key for the new bill document upload file
	* @return the new bill document upload file
	*/
	public static BillDocumentUploadFile create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	* Removes the bill document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param documentId the primary key of the bill document upload file
	* @return the bill document upload file that was removed
	* @throws NoSuchBillDocumentUploadFileException if a bill document upload file with the primary key could not be found
	*/
	public static BillDocumentUploadFile remove(long documentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBillDocumentUploadFileException {
		return getPersistence().remove(documentId);
	}

	public static BillDocumentUploadFile updateImpl(
		BillDocumentUploadFile billDocumentUploadFile) {
		return getPersistence().updateImpl(billDocumentUploadFile);
	}

	/**
	* Returns the bill document upload file with the primary key or throws a {@link NoSuchBillDocumentUploadFileException} if it could not be found.
	*
	* @param documentId the primary key of the bill document upload file
	* @return the bill document upload file
	* @throws NoSuchBillDocumentUploadFileException if a bill document upload file with the primary key could not be found
	*/
	public static BillDocumentUploadFile findByPrimaryKey(long documentId)
		throws com.liferay.famocom.erpcloud.exception.NoSuchBillDocumentUploadFileException {
		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	* Returns the bill document upload file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param documentId the primary key of the bill document upload file
	* @return the bill document upload file, or <code>null</code> if a bill document upload file with the primary key could not be found
	*/
	public static BillDocumentUploadFile fetchByPrimaryKey(long documentId) {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	public static java.util.Map<java.io.Serializable, BillDocumentUploadFile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the bill document upload files.
	*
	* @return the bill document upload files
	*/
	public static List<BillDocumentUploadFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bill document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillDocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bill document upload files
	* @param end the upper bound of the range of bill document upload files (not inclusive)
	* @return the range of bill document upload files
	*/
	public static List<BillDocumentUploadFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bill document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillDocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bill document upload files
	* @param end the upper bound of the range of bill document upload files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bill document upload files
	*/
	public static List<BillDocumentUploadFile> findAll(int start, int end,
		OrderByComparator<BillDocumentUploadFile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bill document upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillDocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bill document upload files
	* @param end the upper bound of the range of bill document upload files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bill document upload files
	*/
	public static List<BillDocumentUploadFile> findAll(int start, int end,
		OrderByComparator<BillDocumentUploadFile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the bill document upload files from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bill document upload files.
	*
	* @return the number of bill document upload files
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BillDocumentUploadFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BillDocumentUploadFilePersistence, BillDocumentUploadFilePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BillDocumentUploadFilePersistence.class);

		ServiceTracker<BillDocumentUploadFilePersistence, BillDocumentUploadFilePersistence> serviceTracker =
			new ServiceTracker<BillDocumentUploadFilePersistence, BillDocumentUploadFilePersistence>(bundle.getBundleContext(),
				BillDocumentUploadFilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}