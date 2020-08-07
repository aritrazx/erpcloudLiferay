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

import com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterException;
import com.liferay.famocom.erpcloud.model.TaskMaster;
import com.liferay.famocom.erpcloud.model.impl.TaskMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.TaskMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TaskMasterPersistence;

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
 * The persistence implementation for the task master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TaskMasterUtil
 * @generated
 */
@ProviderType
public class TaskMasterPersistenceImpl extends BasePersistenceImpl<TaskMaster>
	implements TaskMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskMasterUtil} to access the task master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterModelImpl.FINDER_CACHE_ENABLED, TaskMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterModelImpl.FINDER_CACHE_ENABLED, TaskMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaskMasterPersistenceImpl() {
		setModelClass(TaskMaster.class);
	}

	/**
	 * Caches the task master in the entity cache if it is enabled.
	 *
	 * @param taskMaster the task master
	 */
	@Override
	public void cacheResult(TaskMaster taskMaster) {
		entityCache.putResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterImpl.class, taskMaster.getPrimaryKey(), taskMaster);

		taskMaster.resetOriginalValues();
	}

	/**
	 * Caches the task masters in the entity cache if it is enabled.
	 *
	 * @param taskMasters the task masters
	 */
	@Override
	public void cacheResult(List<TaskMaster> taskMasters) {
		for (TaskMaster taskMaster : taskMasters) {
			if (entityCache.getResult(
						TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
						TaskMasterImpl.class, taskMaster.getPrimaryKey()) == null) {
				cacheResult(taskMaster);
			}
			else {
				taskMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskMaster taskMaster) {
		entityCache.removeResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterImpl.class, taskMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskMaster> taskMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskMaster taskMaster : taskMasters) {
			entityCache.removeResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
				TaskMasterImpl.class, taskMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task master with the primary key. Does not add the task master to the database.
	 *
	 * @param taskId the primary key for the new task master
	 * @return the new task master
	 */
	@Override
	public TaskMaster create(long taskId) {
		TaskMaster taskMaster = new TaskMasterImpl();

		taskMaster.setNew(true);
		taskMaster.setPrimaryKey(taskId);

		return taskMaster;
	}

	/**
	 * Removes the task master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task master
	 * @return the task master that was removed
	 * @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	 */
	@Override
	public TaskMaster remove(long taskId) throws NoSuchTaskMasterException {
		return remove((Serializable)taskId);
	}

	/**
	 * Removes the task master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task master
	 * @return the task master that was removed
	 * @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	 */
	@Override
	public TaskMaster remove(Serializable primaryKey)
		throws NoSuchTaskMasterException {
		Session session = null;

		try {
			session = openSession();

			TaskMaster taskMaster = (TaskMaster)session.get(TaskMasterImpl.class,
					primaryKey);

			if (taskMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskMaster);
		}
		catch (NoSuchTaskMasterException nsee) {
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
	protected TaskMaster removeImpl(TaskMaster taskMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskMaster)) {
				taskMaster = (TaskMaster)session.get(TaskMasterImpl.class,
						taskMaster.getPrimaryKeyObj());
			}

			if (taskMaster != null) {
				session.delete(taskMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskMaster != null) {
			clearCache(taskMaster);
		}

		return taskMaster;
	}

	@Override
	public TaskMaster updateImpl(TaskMaster taskMaster) {
		boolean isNew = taskMaster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taskMaster.isNew()) {
				session.save(taskMaster);

				taskMaster.setNew(false);
			}
			else {
				taskMaster = (TaskMaster)session.merge(taskMaster);
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

		entityCache.putResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterImpl.class, taskMaster.getPrimaryKey(), taskMaster, false);

		taskMaster.resetOriginalValues();

		return taskMaster;
	}

	/**
	 * Returns the task master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task master
	 * @return the task master
	 * @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	 */
	@Override
	public TaskMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskMasterException {
		TaskMaster taskMaster = fetchByPrimaryKey(primaryKey);

		if (taskMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskMaster;
	}

	/**
	 * Returns the task master with the primary key or throws a {@link NoSuchTaskMasterException} if it could not be found.
	 *
	 * @param taskId the primary key of the task master
	 * @return the task master
	 * @throws NoSuchTaskMasterException if a task master with the primary key could not be found
	 */
	@Override
	public TaskMaster findByPrimaryKey(long taskId)
		throws NoSuchTaskMasterException {
		return findByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns the task master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task master
	 * @return the task master, or <code>null</code> if a task master with the primary key could not be found
	 */
	@Override
	public TaskMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
				TaskMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaskMaster taskMaster = (TaskMaster)serializable;

		if (taskMaster == null) {
			Session session = null;

			try {
				session = openSession();

				taskMaster = (TaskMaster)session.get(TaskMasterImpl.class,
						primaryKey);

				if (taskMaster != null) {
					cacheResult(taskMaster);
				}
				else {
					entityCache.putResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
						TaskMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
					TaskMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskMaster;
	}

	/**
	 * Returns the task master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task master
	 * @return the task master, or <code>null</code> if a task master with the primary key could not be found
	 */
	@Override
	public TaskMaster fetchByPrimaryKey(long taskId) {
		return fetchByPrimaryKey((Serializable)taskId);
	}

	@Override
	public Map<Serializable, TaskMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaskMaster> map = new HashMap<Serializable, TaskMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaskMaster taskMaster = fetchByPrimaryKey(primaryKey);

			if (taskMaster != null) {
				map.put(primaryKey, taskMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
					TaskMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaskMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TASKMASTER_WHERE_PKS_IN);

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

			for (TaskMaster taskMaster : (List<TaskMaster>)q.list()) {
				map.put(taskMaster.getPrimaryKeyObj(), taskMaster);

				cacheResult(taskMaster);

				uncachedPrimaryKeys.remove(taskMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaskMasterModelImpl.ENTITY_CACHE_ENABLED,
					TaskMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the task masters.
	 *
	 * @return the task masters
	 */
	@Override
	public List<TaskMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task masters
	 * @param end the upper bound of the range of task masters (not inclusive)
	 * @return the range of task masters
	 */
	@Override
	public List<TaskMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task masters
	 * @param end the upper bound of the range of task masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task masters
	 */
	@Override
	public List<TaskMaster> findAll(int start, int end,
		OrderByComparator<TaskMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task masters
	 * @param end the upper bound of the range of task masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of task masters
	 */
	@Override
	public List<TaskMaster> findAll(int start, int end,
		OrderByComparator<TaskMaster> orderByComparator,
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

		List<TaskMaster> list = null;

		if (retrieveFromCache) {
			list = (List<TaskMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TASKMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKMASTER;

				if (pagination) {
					sql = sql.concat(TaskMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the task masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskMaster taskMaster : findAll()) {
			remove(taskMaster);
		}
	}

	/**
	 * Returns the number of task masters.
	 *
	 * @return the number of task masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKMASTER);

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
		return TaskMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaskMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TASKMASTER = "SELECT taskMaster FROM TaskMaster taskMaster";
	private static final String _SQL_SELECT_TASKMASTER_WHERE_PKS_IN = "SELECT taskMaster FROM TaskMaster taskMaster WHERE taskId IN (";
	private static final String _SQL_COUNT_TASKMASTER = "SELECT COUNT(taskMaster) FROM TaskMaster taskMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TaskMasterPersistenceImpl.class);
}