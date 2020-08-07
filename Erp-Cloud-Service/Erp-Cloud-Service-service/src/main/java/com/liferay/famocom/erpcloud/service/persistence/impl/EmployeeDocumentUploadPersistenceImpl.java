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

package com.liferay.famocom.erpcloud.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.exception.NoSuchEmployeeDocumentUploadException;
import com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload;
import com.liferay.famocom.erpcloud.model.impl.EmployeeDocumentUploadImpl;
import com.liferay.famocom.erpcloud.model.impl.EmployeeDocumentUploadModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeDocumentUploadPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the employee document upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmployeeDocumentUploadPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.EmployeeDocumentUploadUtil
 * @generated
 */
@ProviderType
public class EmployeeDocumentUploadPersistenceImpl extends BasePersistenceImpl<EmployeeDocumentUpload>
	implements EmployeeDocumentUploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeDocumentUploadUtil} to access the employee document upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeDocumentUploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDocumentUploadModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDocumentUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDocumentUploadModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDocumentUploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDocumentUploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmployeeDocumentUploadPersistenceImpl() {
		setModelClass(EmployeeDocumentUpload.class);
	}

	/**
	 * Caches the employee document upload in the entity cache if it is enabled.
	 *
	 * @param employeeDocumentUpload the employee document upload
	 */
	@Override
	public void cacheResult(EmployeeDocumentUpload employeeDocumentUpload) {
		entityCache.putResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDocumentUploadImpl.class,
			employeeDocumentUpload.getPrimaryKey(), employeeDocumentUpload);

		employeeDocumentUpload.resetOriginalValues();
	}

	/**
	 * Caches the employee document uploads in the entity cache if it is enabled.
	 *
	 * @param employeeDocumentUploads the employee document uploads
	 */
	@Override
	public void cacheResult(
		List<EmployeeDocumentUpload> employeeDocumentUploads) {
		for (EmployeeDocumentUpload employeeDocumentUpload : employeeDocumentUploads) {
			if (entityCache.getResult(
						EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeDocumentUploadImpl.class,
						employeeDocumentUpload.getPrimaryKey()) == null) {
				cacheResult(employeeDocumentUpload);
			}
			else {
				employeeDocumentUpload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee document uploads.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDocumentUploadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee document upload.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDocumentUpload employeeDocumentUpload) {
		entityCache.removeResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDocumentUploadImpl.class,
			employeeDocumentUpload.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmployeeDocumentUpload> employeeDocumentUploads) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeDocumentUpload employeeDocumentUpload : employeeDocumentUploads) {
			entityCache.removeResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeDocumentUploadImpl.class,
				employeeDocumentUpload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee document upload with the primary key. Does not add the employee document upload to the database.
	 *
	 * @param empDocumentId the primary key for the new employee document upload
	 * @return the new employee document upload
	 */
	@Override
	public EmployeeDocumentUpload create(long empDocumentId) {
		EmployeeDocumentUpload employeeDocumentUpload = new EmployeeDocumentUploadImpl();

		employeeDocumentUpload.setNew(true);
		employeeDocumentUpload.setPrimaryKey(empDocumentId);

		employeeDocumentUpload.setCompanyId(companyProvider.getCompanyId());

		return employeeDocumentUpload;
	}

	/**
	 * Removes the employee document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empDocumentId the primary key of the employee document upload
	 * @return the employee document upload that was removed
	 * @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	 */
	@Override
	public EmployeeDocumentUpload remove(long empDocumentId)
		throws NoSuchEmployeeDocumentUploadException {
		return remove((Serializable)empDocumentId);
	}

	/**
	 * Removes the employee document upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee document upload
	 * @return the employee document upload that was removed
	 * @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	 */
	@Override
	public EmployeeDocumentUpload remove(Serializable primaryKey)
		throws NoSuchEmployeeDocumentUploadException {
		Session session = null;

		try {
			session = openSession();

			EmployeeDocumentUpload employeeDocumentUpload = (EmployeeDocumentUpload)session.get(EmployeeDocumentUploadImpl.class,
					primaryKey);

			if (employeeDocumentUpload == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDocumentUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeDocumentUpload);
		}
		catch (NoSuchEmployeeDocumentUploadException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmployeeDocumentUpload removeImpl(
		EmployeeDocumentUpload employeeDocumentUpload) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDocumentUpload)) {
				employeeDocumentUpload = (EmployeeDocumentUpload)session.get(EmployeeDocumentUploadImpl.class,
						employeeDocumentUpload.getPrimaryKeyObj());
			}

			if (employeeDocumentUpload != null) {
				session.delete(employeeDocumentUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeDocumentUpload != null) {
			clearCache(employeeDocumentUpload);
		}

		return employeeDocumentUpload;
	}

	@Override
	public EmployeeDocumentUpload updateImpl(
		EmployeeDocumentUpload employeeDocumentUpload) {
		boolean isNew = employeeDocumentUpload.isNew();

		Session session = null;

		try {
			session = openSession();

			if (employeeDocumentUpload.isNew()) {
				session.save(employeeDocumentUpload);

				employeeDocumentUpload.setNew(false);
			}
			else {
				employeeDocumentUpload = (EmployeeDocumentUpload)session.merge(employeeDocumentUpload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDocumentUploadImpl.class,
			employeeDocumentUpload.getPrimaryKey(), employeeDocumentUpload,
			false);

		employeeDocumentUpload.resetOriginalValues();

		return employeeDocumentUpload;
	}

	/**
	 * Returns the employee document upload with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee document upload
	 * @return the employee document upload
	 * @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	 */
	@Override
	public EmployeeDocumentUpload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDocumentUploadException {
		EmployeeDocumentUpload employeeDocumentUpload = fetchByPrimaryKey(primaryKey);

		if (employeeDocumentUpload == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDocumentUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeDocumentUpload;
	}

	/**
	 * Returns the employee document upload with the primary key or throws a {@link NoSuchEmployeeDocumentUploadException} if it could not be found.
	 *
	 * @param empDocumentId the primary key of the employee document upload
	 * @return the employee document upload
	 * @throws NoSuchEmployeeDocumentUploadException if a employee document upload with the primary key could not be found
	 */
	@Override
	public EmployeeDocumentUpload findByPrimaryKey(long empDocumentId)
		throws NoSuchEmployeeDocumentUploadException {
		return findByPrimaryKey((Serializable)empDocumentId);
	}

	/**
	 * Returns the employee document upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee document upload
	 * @return the employee document upload, or <code>null</code> if a employee document upload with the primary key could not be found
	 */
	@Override
	public EmployeeDocumentUpload fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeDocumentUploadImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmployeeDocumentUpload employeeDocumentUpload = (EmployeeDocumentUpload)serializable;

		if (employeeDocumentUpload == null) {
			Session session = null;

			try {
				session = openSession();

				employeeDocumentUpload = (EmployeeDocumentUpload)session.get(EmployeeDocumentUploadImpl.class,
						primaryKey);

				if (employeeDocumentUpload != null) {
					cacheResult(employeeDocumentUpload);
				}
				else {
					entityCache.putResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeDocumentUploadImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDocumentUploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeDocumentUpload;
	}

	/**
	 * Returns the employee document upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empDocumentId the primary key of the employee document upload
	 * @return the employee document upload, or <code>null</code> if a employee document upload with the primary key could not be found
	 */
	@Override
	public EmployeeDocumentUpload fetchByPrimaryKey(long empDocumentId) {
		return fetchByPrimaryKey((Serializable)empDocumentId);
	}

	@Override
	public Map<Serializable, EmployeeDocumentUpload> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmployeeDocumentUpload> map = new HashMap<Serializable, EmployeeDocumentUpload>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmployeeDocumentUpload employeeDocumentUpload = fetchByPrimaryKey(primaryKey);

			if (employeeDocumentUpload != null) {
				map.put(primaryKey, employeeDocumentUpload);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDocumentUploadImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmployeeDocumentUpload)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMPLOYEEDOCUMENTUPLOAD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (EmployeeDocumentUpload employeeDocumentUpload : (List<EmployeeDocumentUpload>)q.list()) {
				map.put(employeeDocumentUpload.getPrimaryKeyObj(),
					employeeDocumentUpload);

				cacheResult(employeeDocumentUpload);

				uncachedPrimaryKeys.remove(employeeDocumentUpload.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmployeeDocumentUploadModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDocumentUploadImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the employee document uploads.
	 *
	 * @return the employee document uploads
	 */
	@Override
	public List<EmployeeDocumentUpload> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee document uploads
	 * @param end the upper bound of the range of employee document uploads (not inclusive)
	 * @return the range of employee document uploads
	 */
	@Override
	public List<EmployeeDocumentUpload> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee document uploads
	 * @param end the upper bound of the range of employee document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee document uploads
	 */
	@Override
	public List<EmployeeDocumentUpload> findAll(int start, int end,
		OrderByComparator<EmployeeDocumentUpload> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee document uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDocumentUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee document uploads
	 * @param end the upper bound of the range of employee document uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of employee document uploads
	 */
	@Override
	public List<EmployeeDocumentUpload> findAll(int start, int end,
		OrderByComparator<EmployeeDocumentUpload> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EmployeeDocumentUpload> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeDocumentUpload>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMPLOYEEDOCUMENTUPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDOCUMENTUPLOAD;

				if (pagination) {
					sql = sql.concat(EmployeeDocumentUploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeDocumentUpload>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeDocumentUpload>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employee document uploads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDocumentUpload employeeDocumentUpload : findAll()) {
			remove(employeeDocumentUpload);
		}
	}

	/**
	 * Returns the number of employee document uploads.
	 *
	 * @return the number of employee document uploads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEEDOCUMENTUPLOAD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDocumentUploadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee document upload persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmployeeDocumentUploadImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMPLOYEEDOCUMENTUPLOAD = "SELECT employeeDocumentUpload FROM EmployeeDocumentUpload employeeDocumentUpload";
	private static final String _SQL_SELECT_EMPLOYEEDOCUMENTUPLOAD_WHERE_PKS_IN = "SELECT employeeDocumentUpload FROM EmployeeDocumentUpload employeeDocumentUpload WHERE empDocumentId IN (";
	private static final String _SQL_COUNT_EMPLOYEEDOCUMENTUPLOAD = "SELECT COUNT(employeeDocumentUpload) FROM EmployeeDocumentUpload employeeDocumentUpload";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDocumentUpload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeDocumentUpload exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(EmployeeDocumentUploadPersistenceImpl.class);
}