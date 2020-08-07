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

import com.liferay.famocom.erpcloud.exception.NoSuchGoalMasterException;
import com.liferay.famocom.erpcloud.model.GoalMaster;
import com.liferay.famocom.erpcloud.model.impl.GoalMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.GoalMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.GoalMasterPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
 * The persistence implementation for the goal master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see GoalMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.GoalMasterUtil
 * @generated
 */
@ProviderType
public class GoalMasterPersistenceImpl extends BasePersistenceImpl<GoalMaster>
	implements GoalMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GoalMasterUtil} to access the goal master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GoalMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			GoalMasterModelImpl.FINDER_CACHE_ENABLED, GoalMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			GoalMasterModelImpl.FINDER_CACHE_ENABLED, GoalMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			GoalMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GoalMasterPersistenceImpl() {
		setModelClass(GoalMaster.class);
	}

	/**
	 * Caches the goal master in the entity cache if it is enabled.
	 *
	 * @param goalMaster the goal master
	 */
	@Override
	public void cacheResult(GoalMaster goalMaster) {
		entityCache.putResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			GoalMasterImpl.class, goalMaster.getPrimaryKey(), goalMaster);

		goalMaster.resetOriginalValues();
	}

	/**
	 * Caches the goal masters in the entity cache if it is enabled.
	 *
	 * @param goalMasters the goal masters
	 */
	@Override
	public void cacheResult(List<GoalMaster> goalMasters) {
		for (GoalMaster goalMaster : goalMasters) {
			if (entityCache.getResult(
						GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
						GoalMasterImpl.class, goalMaster.getPrimaryKey()) == null) {
				cacheResult(goalMaster);
			}
			else {
				goalMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all goal masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GoalMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the goal master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GoalMaster goalMaster) {
		entityCache.removeResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			GoalMasterImpl.class, goalMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GoalMaster> goalMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GoalMaster goalMaster : goalMasters) {
			entityCache.removeResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
				GoalMasterImpl.class, goalMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new goal master with the primary key. Does not add the goal master to the database.
	 *
	 * @param goalId the primary key for the new goal master
	 * @return the new goal master
	 */
	@Override
	public GoalMaster create(long goalId) {
		GoalMaster goalMaster = new GoalMasterImpl();

		goalMaster.setNew(true);
		goalMaster.setPrimaryKey(goalId);

		return goalMaster;
	}

	/**
	 * Removes the goal master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param goalId the primary key of the goal master
	 * @return the goal master that was removed
	 * @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	 */
	@Override
	public GoalMaster remove(long goalId) throws NoSuchGoalMasterException {
		return remove((Serializable)goalId);
	}

	/**
	 * Removes the goal master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the goal master
	 * @return the goal master that was removed
	 * @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	 */
	@Override
	public GoalMaster remove(Serializable primaryKey)
		throws NoSuchGoalMasterException {
		Session session = null;

		try {
			session = openSession();

			GoalMaster goalMaster = (GoalMaster)session.get(GoalMasterImpl.class,
					primaryKey);

			if (goalMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGoalMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(goalMaster);
		}
		catch (NoSuchGoalMasterException nsee) {
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
	protected GoalMaster removeImpl(GoalMaster goalMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(goalMaster)) {
				goalMaster = (GoalMaster)session.get(GoalMasterImpl.class,
						goalMaster.getPrimaryKeyObj());
			}

			if (goalMaster != null) {
				session.delete(goalMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (goalMaster != null) {
			clearCache(goalMaster);
		}

		return goalMaster;
	}

	@Override
	public GoalMaster updateImpl(GoalMaster goalMaster) {
		boolean isNew = goalMaster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (goalMaster.isNew()) {
				session.save(goalMaster);

				goalMaster.setNew(false);
			}
			else {
				goalMaster = (GoalMaster)session.merge(goalMaster);
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

		entityCache.putResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			GoalMasterImpl.class, goalMaster.getPrimaryKey(), goalMaster, false);

		goalMaster.resetOriginalValues();

		return goalMaster;
	}

	/**
	 * Returns the goal master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the goal master
	 * @return the goal master
	 * @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	 */
	@Override
	public GoalMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGoalMasterException {
		GoalMaster goalMaster = fetchByPrimaryKey(primaryKey);

		if (goalMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGoalMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return goalMaster;
	}

	/**
	 * Returns the goal master with the primary key or throws a {@link NoSuchGoalMasterException} if it could not be found.
	 *
	 * @param goalId the primary key of the goal master
	 * @return the goal master
	 * @throws NoSuchGoalMasterException if a goal master with the primary key could not be found
	 */
	@Override
	public GoalMaster findByPrimaryKey(long goalId)
		throws NoSuchGoalMasterException {
		return findByPrimaryKey((Serializable)goalId);
	}

	/**
	 * Returns the goal master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the goal master
	 * @return the goal master, or <code>null</code> if a goal master with the primary key could not be found
	 */
	@Override
	public GoalMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
				GoalMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		GoalMaster goalMaster = (GoalMaster)serializable;

		if (goalMaster == null) {
			Session session = null;

			try {
				session = openSession();

				goalMaster = (GoalMaster)session.get(GoalMasterImpl.class,
						primaryKey);

				if (goalMaster != null) {
					cacheResult(goalMaster);
				}
				else {
					entityCache.putResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
						GoalMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
					GoalMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return goalMaster;
	}

	/**
	 * Returns the goal master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param goalId the primary key of the goal master
	 * @return the goal master, or <code>null</code> if a goal master with the primary key could not be found
	 */
	@Override
	public GoalMaster fetchByPrimaryKey(long goalId) {
		return fetchByPrimaryKey((Serializable)goalId);
	}

	@Override
	public Map<Serializable, GoalMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GoalMaster> map = new HashMap<Serializable, GoalMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GoalMaster goalMaster = fetchByPrimaryKey(primaryKey);

			if (goalMaster != null) {
				map.put(primaryKey, goalMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
					GoalMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (GoalMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GOALMASTER_WHERE_PKS_IN);

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

			for (GoalMaster goalMaster : (List<GoalMaster>)q.list()) {
				map.put(goalMaster.getPrimaryKeyObj(), goalMaster);

				cacheResult(goalMaster);

				uncachedPrimaryKeys.remove(goalMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GoalMasterModelImpl.ENTITY_CACHE_ENABLED,
					GoalMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the goal masters.
	 *
	 * @return the goal masters
	 */
	@Override
	public List<GoalMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the goal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of goal masters
	 * @param end the upper bound of the range of goal masters (not inclusive)
	 * @return the range of goal masters
	 */
	@Override
	public List<GoalMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the goal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of goal masters
	 * @param end the upper bound of the range of goal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of goal masters
	 */
	@Override
	public List<GoalMaster> findAll(int start, int end,
		OrderByComparator<GoalMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the goal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of goal masters
	 * @param end the upper bound of the range of goal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of goal masters
	 */
	@Override
	public List<GoalMaster> findAll(int start, int end,
		OrderByComparator<GoalMaster> orderByComparator,
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

		List<GoalMaster> list = null;

		if (retrieveFromCache) {
			list = (List<GoalMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GOALMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GOALMASTER;

				if (pagination) {
					sql = sql.concat(GoalMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GoalMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GoalMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the goal masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GoalMaster goalMaster : findAll()) {
			remove(goalMaster);
		}
	}

	/**
	 * Returns the number of goal masters.
	 *
	 * @return the number of goal masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GOALMASTER);

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
		return GoalMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the goal master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GoalMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GOALMASTER = "SELECT goalMaster FROM GoalMaster goalMaster";
	private static final String _SQL_SELECT_GOALMASTER_WHERE_PKS_IN = "SELECT goalMaster FROM GoalMaster goalMaster WHERE goalId IN (";
	private static final String _SQL_COUNT_GOALMASTER = "SELECT COUNT(goalMaster) FROM GoalMaster goalMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "goalMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GoalMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(GoalMasterPersistenceImpl.class);
}