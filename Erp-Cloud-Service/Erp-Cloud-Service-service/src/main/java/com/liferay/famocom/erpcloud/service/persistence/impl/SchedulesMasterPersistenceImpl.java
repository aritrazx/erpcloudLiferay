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

import com.liferay.famocom.erpcloud.exception.NoSuchSchedulesMasterException;
import com.liferay.famocom.erpcloud.model.SchedulesMaster;
import com.liferay.famocom.erpcloud.model.impl.SchedulesMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.SchedulesMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.SchedulesMasterPersistence;

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
 * The persistence implementation for the schedules master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SchedulesMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.SchedulesMasterUtil
 * @generated
 */
@ProviderType
public class SchedulesMasterPersistenceImpl extends BasePersistenceImpl<SchedulesMaster>
	implements SchedulesMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SchedulesMasterUtil} to access the schedules master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SchedulesMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesMasterModelImpl.FINDER_CACHE_ENABLED,
			SchedulesMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesMasterModelImpl.FINDER_CACHE_ENABLED,
			SchedulesMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SchedulesMasterPersistenceImpl() {
		setModelClass(SchedulesMaster.class);
	}

	/**
	 * Caches the schedules master in the entity cache if it is enabled.
	 *
	 * @param schedulesMaster the schedules master
	 */
	@Override
	public void cacheResult(SchedulesMaster schedulesMaster) {
		entityCache.putResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesMasterImpl.class, schedulesMaster.getPrimaryKey(),
			schedulesMaster);

		schedulesMaster.resetOriginalValues();
	}

	/**
	 * Caches the schedules masters in the entity cache if it is enabled.
	 *
	 * @param schedulesMasters the schedules masters
	 */
	@Override
	public void cacheResult(List<SchedulesMaster> schedulesMasters) {
		for (SchedulesMaster schedulesMaster : schedulesMasters) {
			if (entityCache.getResult(
						SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
						SchedulesMasterImpl.class,
						schedulesMaster.getPrimaryKey()) == null) {
				cacheResult(schedulesMaster);
			}
			else {
				schedulesMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all schedules masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SchedulesMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the schedules master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SchedulesMaster schedulesMaster) {
		entityCache.removeResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesMasterImpl.class, schedulesMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SchedulesMaster> schedulesMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SchedulesMaster schedulesMaster : schedulesMasters) {
			entityCache.removeResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
				SchedulesMasterImpl.class, schedulesMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new schedules master with the primary key. Does not add the schedules master to the database.
	 *
	 * @param schedulesId the primary key for the new schedules master
	 * @return the new schedules master
	 */
	@Override
	public SchedulesMaster create(long schedulesId) {
		SchedulesMaster schedulesMaster = new SchedulesMasterImpl();

		schedulesMaster.setNew(true);
		schedulesMaster.setPrimaryKey(schedulesId);

		return schedulesMaster;
	}

	/**
	 * Removes the schedules master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param schedulesId the primary key of the schedules master
	 * @return the schedules master that was removed
	 * @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	 */
	@Override
	public SchedulesMaster remove(long schedulesId)
		throws NoSuchSchedulesMasterException {
		return remove((Serializable)schedulesId);
	}

	/**
	 * Removes the schedules master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the schedules master
	 * @return the schedules master that was removed
	 * @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	 */
	@Override
	public SchedulesMaster remove(Serializable primaryKey)
		throws NoSuchSchedulesMasterException {
		Session session = null;

		try {
			session = openSession();

			SchedulesMaster schedulesMaster = (SchedulesMaster)session.get(SchedulesMasterImpl.class,
					primaryKey);

			if (schedulesMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSchedulesMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(schedulesMaster);
		}
		catch (NoSuchSchedulesMasterException nsee) {
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
	protected SchedulesMaster removeImpl(SchedulesMaster schedulesMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(schedulesMaster)) {
				schedulesMaster = (SchedulesMaster)session.get(SchedulesMasterImpl.class,
						schedulesMaster.getPrimaryKeyObj());
			}

			if (schedulesMaster != null) {
				session.delete(schedulesMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (schedulesMaster != null) {
			clearCache(schedulesMaster);
		}

		return schedulesMaster;
	}

	@Override
	public SchedulesMaster updateImpl(SchedulesMaster schedulesMaster) {
		boolean isNew = schedulesMaster.isNew();

		if (!(schedulesMaster instanceof SchedulesMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(schedulesMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(schedulesMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in schedulesMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SchedulesMaster implementation " +
				schedulesMaster.getClass());
		}

		SchedulesMasterModelImpl schedulesMasterModelImpl = (SchedulesMasterModelImpl)schedulesMaster;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (schedulesMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				schedulesMaster.setCreateDate(now);
			}
			else {
				schedulesMaster.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!schedulesMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				schedulesMaster.setModifiedDate(now);
			}
			else {
				schedulesMaster.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (schedulesMaster.isNew()) {
				session.save(schedulesMaster);

				schedulesMaster.setNew(false);
			}
			else {
				schedulesMaster = (SchedulesMaster)session.merge(schedulesMaster);
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

		entityCache.putResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
			SchedulesMasterImpl.class, schedulesMaster.getPrimaryKey(),
			schedulesMaster, false);

		schedulesMaster.resetOriginalValues();

		return schedulesMaster;
	}

	/**
	 * Returns the schedules master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedules master
	 * @return the schedules master
	 * @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	 */
	@Override
	public SchedulesMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSchedulesMasterException {
		SchedulesMaster schedulesMaster = fetchByPrimaryKey(primaryKey);

		if (schedulesMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSchedulesMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return schedulesMaster;
	}

	/**
	 * Returns the schedules master with the primary key or throws a {@link NoSuchSchedulesMasterException} if it could not be found.
	 *
	 * @param schedulesId the primary key of the schedules master
	 * @return the schedules master
	 * @throws NoSuchSchedulesMasterException if a schedules master with the primary key could not be found
	 */
	@Override
	public SchedulesMaster findByPrimaryKey(long schedulesId)
		throws NoSuchSchedulesMasterException {
		return findByPrimaryKey((Serializable)schedulesId);
	}

	/**
	 * Returns the schedules master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedules master
	 * @return the schedules master, or <code>null</code> if a schedules master with the primary key could not be found
	 */
	@Override
	public SchedulesMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
				SchedulesMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SchedulesMaster schedulesMaster = (SchedulesMaster)serializable;

		if (schedulesMaster == null) {
			Session session = null;

			try {
				session = openSession();

				schedulesMaster = (SchedulesMaster)session.get(SchedulesMasterImpl.class,
						primaryKey);

				if (schedulesMaster != null) {
					cacheResult(schedulesMaster);
				}
				else {
					entityCache.putResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
						SchedulesMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
					SchedulesMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return schedulesMaster;
	}

	/**
	 * Returns the schedules master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param schedulesId the primary key of the schedules master
	 * @return the schedules master, or <code>null</code> if a schedules master with the primary key could not be found
	 */
	@Override
	public SchedulesMaster fetchByPrimaryKey(long schedulesId) {
		return fetchByPrimaryKey((Serializable)schedulesId);
	}

	@Override
	public Map<Serializable, SchedulesMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SchedulesMaster> map = new HashMap<Serializable, SchedulesMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SchedulesMaster schedulesMaster = fetchByPrimaryKey(primaryKey);

			if (schedulesMaster != null) {
				map.put(primaryKey, schedulesMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
					SchedulesMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SchedulesMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SCHEDULESMASTER_WHERE_PKS_IN);

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

			for (SchedulesMaster schedulesMaster : (List<SchedulesMaster>)q.list()) {
				map.put(schedulesMaster.getPrimaryKeyObj(), schedulesMaster);

				cacheResult(schedulesMaster);

				uncachedPrimaryKeys.remove(schedulesMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SchedulesMasterModelImpl.ENTITY_CACHE_ENABLED,
					SchedulesMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the schedules masters.
	 *
	 * @return the schedules masters
	 */
	@Override
	public List<SchedulesMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules masters
	 * @param end the upper bound of the range of schedules masters (not inclusive)
	 * @return the range of schedules masters
	 */
	@Override
	public List<SchedulesMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules masters
	 * @param end the upper bound of the range of schedules masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of schedules masters
	 */
	@Override
	public List<SchedulesMaster> findAll(int start, int end,
		OrderByComparator<SchedulesMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedules masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchedulesMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules masters
	 * @param end the upper bound of the range of schedules masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of schedules masters
	 */
	@Override
	public List<SchedulesMaster> findAll(int start, int end,
		OrderByComparator<SchedulesMaster> orderByComparator,
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

		List<SchedulesMaster> list = null;

		if (retrieveFromCache) {
			list = (List<SchedulesMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SCHEDULESMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULESMASTER;

				if (pagination) {
					sql = sql.concat(SchedulesMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SchedulesMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SchedulesMaster>)QueryUtil.list(q,
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
	 * Removes all the schedules masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SchedulesMaster schedulesMaster : findAll()) {
			remove(schedulesMaster);
		}
	}

	/**
	 * Returns the number of schedules masters.
	 *
	 * @return the number of schedules masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCHEDULESMASTER);

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
		return SchedulesMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the schedules master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SchedulesMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SCHEDULESMASTER = "SELECT schedulesMaster FROM SchedulesMaster schedulesMaster";
	private static final String _SQL_SELECT_SCHEDULESMASTER_WHERE_PKS_IN = "SELECT schedulesMaster FROM SchedulesMaster schedulesMaster WHERE schedulesId IN (";
	private static final String _SQL_COUNT_SCHEDULESMASTER = "SELECT COUNT(schedulesMaster) FROM SchedulesMaster schedulesMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "schedulesMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SchedulesMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SchedulesMasterPersistenceImpl.class);
}