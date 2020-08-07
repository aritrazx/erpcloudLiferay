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

import com.liferay.famocom.erpcloud.exception.NoSuchPerformanceMasterException;
import com.liferay.famocom.erpcloud.model.PerformanceMaster;
import com.liferay.famocom.erpcloud.model.impl.PerformanceMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.PerformanceMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.PerformanceMasterPersistence;

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
 * The persistence implementation for the performance master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PerformanceMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.PerformanceMasterUtil
 * @generated
 */
@ProviderType
public class PerformanceMasterPersistenceImpl extends BasePersistenceImpl<PerformanceMaster>
	implements PerformanceMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PerformanceMasterUtil} to access the performance master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PerformanceMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceMasterModelImpl.FINDER_CACHE_ENABLED,
			PerformanceMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceMasterModelImpl.FINDER_CACHE_ENABLED,
			PerformanceMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PerformanceMasterPersistenceImpl() {
		setModelClass(PerformanceMaster.class);
	}

	/**
	 * Caches the performance master in the entity cache if it is enabled.
	 *
	 * @param performanceMaster the performance master
	 */
	@Override
	public void cacheResult(PerformanceMaster performanceMaster) {
		entityCache.putResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceMasterImpl.class, performanceMaster.getPrimaryKey(),
			performanceMaster);

		performanceMaster.resetOriginalValues();
	}

	/**
	 * Caches the performance masters in the entity cache if it is enabled.
	 *
	 * @param performanceMasters the performance masters
	 */
	@Override
	public void cacheResult(List<PerformanceMaster> performanceMasters) {
		for (PerformanceMaster performanceMaster : performanceMasters) {
			if (entityCache.getResult(
						PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
						PerformanceMasterImpl.class,
						performanceMaster.getPrimaryKey()) == null) {
				cacheResult(performanceMaster);
			}
			else {
				performanceMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all performance masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PerformanceMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the performance master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PerformanceMaster performanceMaster) {
		entityCache.removeResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceMasterImpl.class, performanceMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PerformanceMaster> performanceMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PerformanceMaster performanceMaster : performanceMasters) {
			entityCache.removeResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
				PerformanceMasterImpl.class, performanceMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new performance master with the primary key. Does not add the performance master to the database.
	 *
	 * @param performanceId the primary key for the new performance master
	 * @return the new performance master
	 */
	@Override
	public PerformanceMaster create(long performanceId) {
		PerformanceMaster performanceMaster = new PerformanceMasterImpl();

		performanceMaster.setNew(true);
		performanceMaster.setPrimaryKey(performanceId);

		performanceMaster.setCompanyId(companyProvider.getCompanyId());

		return performanceMaster;
	}

	/**
	 * Removes the performance master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param performanceId the primary key of the performance master
	 * @return the performance master that was removed
	 * @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	 */
	@Override
	public PerformanceMaster remove(long performanceId)
		throws NoSuchPerformanceMasterException {
		return remove((Serializable)performanceId);
	}

	/**
	 * Removes the performance master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the performance master
	 * @return the performance master that was removed
	 * @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	 */
	@Override
	public PerformanceMaster remove(Serializable primaryKey)
		throws NoSuchPerformanceMasterException {
		Session session = null;

		try {
			session = openSession();

			PerformanceMaster performanceMaster = (PerformanceMaster)session.get(PerformanceMasterImpl.class,
					primaryKey);

			if (performanceMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPerformanceMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(performanceMaster);
		}
		catch (NoSuchPerformanceMasterException nsee) {
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
	protected PerformanceMaster removeImpl(PerformanceMaster performanceMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(performanceMaster)) {
				performanceMaster = (PerformanceMaster)session.get(PerformanceMasterImpl.class,
						performanceMaster.getPrimaryKeyObj());
			}

			if (performanceMaster != null) {
				session.delete(performanceMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (performanceMaster != null) {
			clearCache(performanceMaster);
		}

		return performanceMaster;
	}

	@Override
	public PerformanceMaster updateImpl(PerformanceMaster performanceMaster) {
		boolean isNew = performanceMaster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (performanceMaster.isNew()) {
				session.save(performanceMaster);

				performanceMaster.setNew(false);
			}
			else {
				performanceMaster = (PerformanceMaster)session.merge(performanceMaster);
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

		entityCache.putResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
			PerformanceMasterImpl.class, performanceMaster.getPrimaryKey(),
			performanceMaster, false);

		performanceMaster.resetOriginalValues();

		return performanceMaster;
	}

	/**
	 * Returns the performance master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the performance master
	 * @return the performance master
	 * @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	 */
	@Override
	public PerformanceMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPerformanceMasterException {
		PerformanceMaster performanceMaster = fetchByPrimaryKey(primaryKey);

		if (performanceMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPerformanceMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return performanceMaster;
	}

	/**
	 * Returns the performance master with the primary key or throws a {@link NoSuchPerformanceMasterException} if it could not be found.
	 *
	 * @param performanceId the primary key of the performance master
	 * @return the performance master
	 * @throws NoSuchPerformanceMasterException if a performance master with the primary key could not be found
	 */
	@Override
	public PerformanceMaster findByPrimaryKey(long performanceId)
		throws NoSuchPerformanceMasterException {
		return findByPrimaryKey((Serializable)performanceId);
	}

	/**
	 * Returns the performance master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the performance master
	 * @return the performance master, or <code>null</code> if a performance master with the primary key could not be found
	 */
	@Override
	public PerformanceMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
				PerformanceMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PerformanceMaster performanceMaster = (PerformanceMaster)serializable;

		if (performanceMaster == null) {
			Session session = null;

			try {
				session = openSession();

				performanceMaster = (PerformanceMaster)session.get(PerformanceMasterImpl.class,
						primaryKey);

				if (performanceMaster != null) {
					cacheResult(performanceMaster);
				}
				else {
					entityCache.putResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
						PerformanceMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
					PerformanceMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return performanceMaster;
	}

	/**
	 * Returns the performance master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param performanceId the primary key of the performance master
	 * @return the performance master, or <code>null</code> if a performance master with the primary key could not be found
	 */
	@Override
	public PerformanceMaster fetchByPrimaryKey(long performanceId) {
		return fetchByPrimaryKey((Serializable)performanceId);
	}

	@Override
	public Map<Serializable, PerformanceMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PerformanceMaster> map = new HashMap<Serializable, PerformanceMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PerformanceMaster performanceMaster = fetchByPrimaryKey(primaryKey);

			if (performanceMaster != null) {
				map.put(primaryKey, performanceMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
					PerformanceMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PerformanceMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PERFORMANCEMASTER_WHERE_PKS_IN);

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

			for (PerformanceMaster performanceMaster : (List<PerformanceMaster>)q.list()) {
				map.put(performanceMaster.getPrimaryKeyObj(), performanceMaster);

				cacheResult(performanceMaster);

				uncachedPrimaryKeys.remove(performanceMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PerformanceMasterModelImpl.ENTITY_CACHE_ENABLED,
					PerformanceMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the performance masters.
	 *
	 * @return the performance masters
	 */
	@Override
	public List<PerformanceMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the performance masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance masters
	 * @param end the upper bound of the range of performance masters (not inclusive)
	 * @return the range of performance masters
	 */
	@Override
	public List<PerformanceMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the performance masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance masters
	 * @param end the upper bound of the range of performance masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of performance masters
	 */
	@Override
	public List<PerformanceMaster> findAll(int start, int end,
		OrderByComparator<PerformanceMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the performance masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PerformanceMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance masters
	 * @param end the upper bound of the range of performance masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of performance masters
	 */
	@Override
	public List<PerformanceMaster> findAll(int start, int end,
		OrderByComparator<PerformanceMaster> orderByComparator,
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

		List<PerformanceMaster> list = null;

		if (retrieveFromCache) {
			list = (List<PerformanceMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERFORMANCEMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERFORMANCEMASTER;

				if (pagination) {
					sql = sql.concat(PerformanceMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PerformanceMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PerformanceMaster>)QueryUtil.list(q,
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
	 * Removes all the performance masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PerformanceMaster performanceMaster : findAll()) {
			remove(performanceMaster);
		}
	}

	/**
	 * Returns the number of performance masters.
	 *
	 * @return the number of performance masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERFORMANCEMASTER);

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
		return PerformanceMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the performance master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PerformanceMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_PERFORMANCEMASTER = "SELECT performanceMaster FROM PerformanceMaster performanceMaster";
	private static final String _SQL_SELECT_PERFORMANCEMASTER_WHERE_PKS_IN = "SELECT performanceMaster FROM PerformanceMaster performanceMaster WHERE performanceId IN (";
	private static final String _SQL_COUNT_PERFORMANCEMASTER = "SELECT COUNT(performanceMaster) FROM PerformanceMaster performanceMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "performanceMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PerformanceMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PerformanceMasterPersistenceImpl.class);
}