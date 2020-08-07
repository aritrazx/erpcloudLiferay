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

import com.liferay.famocom.erpcloud.exception.NoSuchWorkFromHomeException;
import com.liferay.famocom.erpcloud.model.WorkFromHome;
import com.liferay.famocom.erpcloud.model.impl.WorkFromHomeImpl;
import com.liferay.famocom.erpcloud.model.impl.WorkFromHomeModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.WorkFromHomePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the work from home service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see WorkFromHomePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.WorkFromHomeUtil
 * @generated
 */
@ProviderType
public class WorkFromHomePersistenceImpl extends BasePersistenceImpl<WorkFromHome>
	implements WorkFromHomePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkFromHomeUtil} to access the work from home persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkFromHomeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
			WorkFromHomeModelImpl.FINDER_CACHE_ENABLED, WorkFromHomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
			WorkFromHomeModelImpl.FINDER_CACHE_ENABLED, WorkFromHomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
			WorkFromHomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WorkFromHomePersistenceImpl() {
		setModelClass(WorkFromHome.class);
	}

	/**
	 * Caches the work from home in the entity cache if it is enabled.
	 *
	 * @param workFromHome the work from home
	 */
	@Override
	public void cacheResult(WorkFromHome workFromHome) {
		entityCache.putResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
			WorkFromHomeImpl.class, workFromHome.getPrimaryKey(), workFromHome);

		workFromHome.resetOriginalValues();
	}

	/**
	 * Caches the work from homes in the entity cache if it is enabled.
	 *
	 * @param workFromHomes the work from homes
	 */
	@Override
	public void cacheResult(List<WorkFromHome> workFromHomes) {
		for (WorkFromHome workFromHome : workFromHomes) {
			if (entityCache.getResult(
						WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
						WorkFromHomeImpl.class, workFromHome.getPrimaryKey()) == null) {
				cacheResult(workFromHome);
			}
			else {
				workFromHome.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all work from homes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkFromHomeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work from home.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkFromHome workFromHome) {
		entityCache.removeResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
			WorkFromHomeImpl.class, workFromHome.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkFromHome> workFromHomes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkFromHome workFromHome : workFromHomes) {
			entityCache.removeResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
				WorkFromHomeImpl.class, workFromHome.getPrimaryKey());
		}
	}

	/**
	 * Creates a new work from home with the primary key. Does not add the work from home to the database.
	 *
	 * @param workFromHomeId the primary key for the new work from home
	 * @return the new work from home
	 */
	@Override
	public WorkFromHome create(long workFromHomeId) {
		WorkFromHome workFromHome = new WorkFromHomeImpl();

		workFromHome.setNew(true);
		workFromHome.setPrimaryKey(workFromHomeId);

		workFromHome.setCompanyId(companyProvider.getCompanyId());

		return workFromHome;
	}

	/**
	 * Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workFromHomeId the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome remove(long workFromHomeId)
		throws NoSuchWorkFromHomeException {
		return remove((Serializable)workFromHomeId);
	}

	/**
	 * Removes the work from home with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work from home
	 * @return the work from home that was removed
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome remove(Serializable primaryKey)
		throws NoSuchWorkFromHomeException {
		Session session = null;

		try {
			session = openSession();

			WorkFromHome workFromHome = (WorkFromHome)session.get(WorkFromHomeImpl.class,
					primaryKey);

			if (workFromHome == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkFromHomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workFromHome);
		}
		catch (NoSuchWorkFromHomeException nsee) {
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
	protected WorkFromHome removeImpl(WorkFromHome workFromHome) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workFromHome)) {
				workFromHome = (WorkFromHome)session.get(WorkFromHomeImpl.class,
						workFromHome.getPrimaryKeyObj());
			}

			if (workFromHome != null) {
				session.delete(workFromHome);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workFromHome != null) {
			clearCache(workFromHome);
		}

		return workFromHome;
	}

	@Override
	public WorkFromHome updateImpl(WorkFromHome workFromHome) {
		boolean isNew = workFromHome.isNew();

		if (!(workFromHome instanceof WorkFromHomeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workFromHome.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(workFromHome);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workFromHome proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkFromHome implementation " +
				workFromHome.getClass());
		}

		WorkFromHomeModelImpl workFromHomeModelImpl = (WorkFromHomeModelImpl)workFromHome;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (workFromHome.getCreateDate() == null)) {
			if (serviceContext == null) {
				workFromHome.setCreateDate(now);
			}
			else {
				workFromHome.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!workFromHomeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				workFromHome.setModifiedDate(now);
			}
			else {
				workFromHome.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (workFromHome.isNew()) {
				session.save(workFromHome);

				workFromHome.setNew(false);
			}
			else {
				workFromHome = (WorkFromHome)session.merge(workFromHome);
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

		entityCache.putResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
			WorkFromHomeImpl.class, workFromHome.getPrimaryKey(), workFromHome,
			false);

		workFromHome.resetOriginalValues();

		return workFromHome;
	}

	/**
	 * Returns the work from home with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the work from home
	 * @return the work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkFromHomeException {
		WorkFromHome workFromHome = fetchByPrimaryKey(primaryKey);

		if (workFromHome == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkFromHomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workFromHome;
	}

	/**
	 * Returns the work from home with the primary key or throws a {@link NoSuchWorkFromHomeException} if it could not be found.
	 *
	 * @param workFromHomeId the primary key of the work from home
	 * @return the work from home
	 * @throws NoSuchWorkFromHomeException if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome findByPrimaryKey(long workFromHomeId)
		throws NoSuchWorkFromHomeException {
		return findByPrimaryKey((Serializable)workFromHomeId);
	}

	/**
	 * Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work from home
	 * @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
				WorkFromHomeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WorkFromHome workFromHome = (WorkFromHome)serializable;

		if (workFromHome == null) {
			Session session = null;

			try {
				session = openSession();

				workFromHome = (WorkFromHome)session.get(WorkFromHomeImpl.class,
						primaryKey);

				if (workFromHome != null) {
					cacheResult(workFromHome);
				}
				else {
					entityCache.putResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
						WorkFromHomeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
					WorkFromHomeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workFromHome;
	}

	/**
	 * Returns the work from home with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workFromHomeId the primary key of the work from home
	 * @return the work from home, or <code>null</code> if a work from home with the primary key could not be found
	 */
	@Override
	public WorkFromHome fetchByPrimaryKey(long workFromHomeId) {
		return fetchByPrimaryKey((Serializable)workFromHomeId);
	}

	@Override
	public Map<Serializable, WorkFromHome> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WorkFromHome> map = new HashMap<Serializable, WorkFromHome>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WorkFromHome workFromHome = fetchByPrimaryKey(primaryKey);

			if (workFromHome != null) {
				map.put(primaryKey, workFromHome);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
					WorkFromHomeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WorkFromHome)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORKFROMHOME_WHERE_PKS_IN);

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

			for (WorkFromHome workFromHome : (List<WorkFromHome>)q.list()) {
				map.put(workFromHome.getPrimaryKeyObj(), workFromHome);

				cacheResult(workFromHome);

				uncachedPrimaryKeys.remove(workFromHome.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WorkFromHomeModelImpl.ENTITY_CACHE_ENABLED,
					WorkFromHomeImpl.class, primaryKey, nullModel);
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
	 * Returns all the work from homes.
	 *
	 * @return the work from homes
	 */
	@Override
	public List<WorkFromHome> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @return the range of work from homes
	 */
	@Override
	public List<WorkFromHome> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work from homes
	 */
	@Override
	public List<WorkFromHome> findAll(int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work from homes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkFromHomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work from homes
	 * @param end the upper bound of the range of work from homes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of work from homes
	 */
	@Override
	public List<WorkFromHome> findAll(int start, int end,
		OrderByComparator<WorkFromHome> orderByComparator,
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

		List<WorkFromHome> list = null;

		if (retrieveFromCache) {
			list = (List<WorkFromHome>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORKFROMHOME);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFROMHOME;

				if (pagination) {
					sql = sql.concat(WorkFromHomeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkFromHome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkFromHome>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the work from homes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkFromHome workFromHome : findAll()) {
			remove(workFromHome);
		}
	}

	/**
	 * Returns the number of work from homes.
	 *
	 * @return the number of work from homes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKFROMHOME);

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
		return WorkFromHomeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work from home persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WorkFromHomeImpl.class.getName());
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
	private static final String _SQL_SELECT_WORKFROMHOME = "SELECT workFromHome FROM WorkFromHome workFromHome";
	private static final String _SQL_SELECT_WORKFROMHOME_WHERE_PKS_IN = "SELECT workFromHome FROM WorkFromHome workFromHome WHERE workFromHomeId IN (";
	private static final String _SQL_COUNT_WORKFROMHOME = "SELECT COUNT(workFromHome) FROM WorkFromHome workFromHome";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workFromHome.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkFromHome exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WorkFromHomePersistenceImpl.class);
}