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

import com.liferay.famocom.erpcloud.exception.NoSuchPerformanceException;
import com.liferay.famocom.erpcloud.model.Performance;
import com.liferay.famocom.erpcloud.model.impl.PerformanceImpl;
import com.liferay.famocom.erpcloud.model.impl.PerformanceModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.PerformancePersistence;

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
 * The persistence implementation for the performance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PerformancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.PerformanceUtil
 * @generated
 */
@ProviderType
public class PerformancePersistenceImpl extends BasePersistenceImpl<Performance>
	implements PerformancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PerformanceUtil} to access the performance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PerformanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceModelImpl.FINDER_CACHE_ENABLED, PerformanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceModelImpl.FINDER_CACHE_ENABLED, PerformanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PerformancePersistenceImpl() {
		setModelClass(Performance.class);
	}

	/**
	 * Caches the performance in the entity cache if it is enabled.
	 *
	 * @param performance the performance
	 */
	@Override
	public void cacheResult(Performance performance) {
		entityCache.putResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceImpl.class, performance.getPrimaryKey(), performance);

		performance.resetOriginalValues();
	}

	/**
	 * Caches the performances in the entity cache if it is enabled.
	 *
	 * @param performances the performances
	 */
	@Override
	public void cacheResult(List<Performance> performances) {
		for (Performance performance : performances) {
			if (entityCache.getResult(
						PerformanceModelImpl.ENTITY_CACHE_ENABLED,
						PerformanceImpl.class, performance.getPrimaryKey()) == null) {
				cacheResult(performance);
			}
			else {
				performance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all performances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PerformanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the performance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Performance performance) {
		entityCache.removeResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceImpl.class, performance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Performance> performances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Performance performance : performances) {
			entityCache.removeResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
				PerformanceImpl.class, performance.getPrimaryKey());
		}
	}

	/**
	 * Creates a new performance with the primary key. Does not add the performance to the database.
	 *
	 * @param performanceId the primary key for the new performance
	 * @return the new performance
	 */
	@Override
	public Performance create(long performanceId) {
		Performance performance = new PerformanceImpl();

		performance.setNew(true);
		performance.setPrimaryKey(performanceId);

		performance.setCompanyId(companyProvider.getCompanyId());

		return performance;
	}

	/**
	 * Removes the performance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param performanceId the primary key of the performance
	 * @return the performance that was removed
	 * @throws NoSuchPerformanceException if a performance with the primary key could not be found
	 */
	@Override
	public Performance remove(long performanceId)
		throws NoSuchPerformanceException {
		return remove((Serializable)performanceId);
	}

	/**
	 * Removes the performance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the performance
	 * @return the performance that was removed
	 * @throws NoSuchPerformanceException if a performance with the primary key could not be found
	 */
	@Override
	public Performance remove(Serializable primaryKey)
		throws NoSuchPerformanceException {
		Session session = null;

		try {
			session = openSession();

			Performance performance = (Performance)session.get(PerformanceImpl.class,
					primaryKey);

			if (performance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPerformanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(performance);
		}
		catch (NoSuchPerformanceException nsee) {
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
	protected Performance removeImpl(Performance performance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(performance)) {
				performance = (Performance)session.get(PerformanceImpl.class,
						performance.getPrimaryKeyObj());
			}

			if (performance != null) {
				session.delete(performance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (performance != null) {
			clearCache(performance);
		}

		return performance;
	}

	@Override
	public Performance updateImpl(Performance performance) {
		boolean isNew = performance.isNew();

		Session session = null;

		try {
			session = openSession();

			if (performance.isNew()) {
				session.save(performance);

				performance.setNew(false);
			}
			else {
				performance = (Performance)session.merge(performance);
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

		entityCache.putResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceImpl.class, performance.getPrimaryKey(), performance,
			false);

		performance.resetOriginalValues();

		return performance;
	}

	/**
	 * Returns the performance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the performance
	 * @return the performance
	 * @throws NoSuchPerformanceException if a performance with the primary key could not be found
	 */
	@Override
	public Performance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPerformanceException {
		Performance performance = fetchByPrimaryKey(primaryKey);

		if (performance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPerformanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return performance;
	}

	/**
	 * Returns the performance with the primary key or throws a {@link NoSuchPerformanceException} if it could not be found.
	 *
	 * @param performanceId the primary key of the performance
	 * @return the performance
	 * @throws NoSuchPerformanceException if a performance with the primary key could not be found
	 */
	@Override
	public Performance findByPrimaryKey(long performanceId)
		throws NoSuchPerformanceException {
		return findByPrimaryKey((Serializable)performanceId);
	}

	/**
	 * Returns the performance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the performance
	 * @return the performance, or <code>null</code> if a performance with the primary key could not be found
	 */
	@Override
	public Performance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
				PerformanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Performance performance = (Performance)serializable;

		if (performance == null) {
			Session session = null;

			try {
				session = openSession();

				performance = (Performance)session.get(PerformanceImpl.class,
						primaryKey);

				if (performance != null) {
					cacheResult(performance);
				}
				else {
					entityCache.putResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
						PerformanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
					PerformanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return performance;
	}

	/**
	 * Returns the performance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param performanceId the primary key of the performance
	 * @return the performance, or <code>null</code> if a performance with the primary key could not be found
	 */
	@Override
	public Performance fetchByPrimaryKey(long performanceId) {
		return fetchByPrimaryKey((Serializable)performanceId);
	}

	@Override
	public Map<Serializable, Performance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Performance> map = new HashMap<Serializable, Performance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Performance performance = fetchByPrimaryKey(primaryKey);

			if (performance != null) {
				map.put(primaryKey, performance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
					PerformanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Performance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PERFORMANCE_WHERE_PKS_IN);

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

			for (Performance performance : (List<Performance>)q.list()) {
				map.put(performance.getPrimaryKeyObj(), performance);

				cacheResult(performance);

				uncachedPrimaryKeys.remove(performance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PerformanceModelImpl.ENTITY_CACHE_ENABLED,
					PerformanceImpl.class, primaryKey, nullModel);
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
	 * Returns all the performances.
	 *
	 * @return the performances
	 */
	@Override
	public List<Performance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of performances
	 * @param end the upper bound of the range of performances (not inclusive)
	 * @return the range of performances
	 */
	@Override
	public List<Performance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of performances
	 * @param end the upper bound of the range of performances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of performances
	 */
	@Override
	public List<Performance> findAll(int start, int end,
		OrderByComparator<Performance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of performances
	 * @param end the upper bound of the range of performances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of performances
	 */
	@Override
	public List<Performance> findAll(int start, int end,
		OrderByComparator<Performance> orderByComparator,
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

		List<Performance> list = null;

		if (retrieveFromCache) {
			list = (List<Performance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERFORMANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERFORMANCE;

				if (pagination) {
					sql = sql.concat(PerformanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Performance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Performance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the performances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Performance performance : findAll()) {
			remove(performance);
		}
	}

	/**
	 * Returns the number of performances.
	 *
	 * @return the number of performances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERFORMANCE);

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
		return PerformanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the performance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PerformanceImpl.class.getName());
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
	private static final String _SQL_SELECT_PERFORMANCE = "SELECT performance FROM Performance performance";
	private static final String _SQL_SELECT_PERFORMANCE_WHERE_PKS_IN = "SELECT performance FROM Performance performance WHERE performanceId IN (";
	private static final String _SQL_COUNT_PERFORMANCE = "SELECT COUNT(performance) FROM Performance performance";
	private static final String _ORDER_BY_ENTITY_ALIAS = "performance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Performance exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PerformancePersistenceImpl.class);
}