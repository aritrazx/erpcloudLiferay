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

import com.liferay.famocom.erpcloud.exception.NoSuchTaskMasterMappingException;
import com.liferay.famocom.erpcloud.model.TaskMasterMapping;
import com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingImpl;
import com.liferay.famocom.erpcloud.model.impl.TaskMasterMappingModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TaskMasterMappingPersistence;

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
 * The persistence implementation for the task master mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaskMasterMappingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TaskMasterMappingUtil
 * @generated
 */
@ProviderType
public class TaskMasterMappingPersistenceImpl extends BasePersistenceImpl<TaskMasterMapping>
	implements TaskMasterMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskMasterMappingUtil} to access the task master mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskMasterMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterMappingModelImpl.FINDER_CACHE_ENABLED,
			TaskMasterMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterMappingModelImpl.FINDER_CACHE_ENABLED,
			TaskMasterMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaskMasterMappingPersistenceImpl() {
		setModelClass(TaskMasterMapping.class);
	}

	/**
	 * Caches the task master mapping in the entity cache if it is enabled.
	 *
	 * @param taskMasterMapping the task master mapping
	 */
	@Override
	public void cacheResult(TaskMasterMapping taskMasterMapping) {
		entityCache.putResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterMappingImpl.class, taskMasterMapping.getPrimaryKey(),
			taskMasterMapping);

		taskMasterMapping.resetOriginalValues();
	}

	/**
	 * Caches the task master mappings in the entity cache if it is enabled.
	 *
	 * @param taskMasterMappings the task master mappings
	 */
	@Override
	public void cacheResult(List<TaskMasterMapping> taskMasterMappings) {
		for (TaskMasterMapping taskMasterMapping : taskMasterMappings) {
			if (entityCache.getResult(
						TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
						TaskMasterMappingImpl.class,
						taskMasterMapping.getPrimaryKey()) == null) {
				cacheResult(taskMasterMapping);
			}
			else {
				taskMasterMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task master mappings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskMasterMappingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task master mapping.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskMasterMapping taskMasterMapping) {
		entityCache.removeResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterMappingImpl.class, taskMasterMapping.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskMasterMapping> taskMasterMappings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskMasterMapping taskMasterMapping : taskMasterMappings) {
			entityCache.removeResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
				TaskMasterMappingImpl.class, taskMasterMapping.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task master mapping with the primary key. Does not add the task master mapping to the database.
	 *
	 * @param taskMappingId the primary key for the new task master mapping
	 * @return the new task master mapping
	 */
	@Override
	public TaskMasterMapping create(long taskMappingId) {
		TaskMasterMapping taskMasterMapping = new TaskMasterMappingImpl();

		taskMasterMapping.setNew(true);
		taskMasterMapping.setPrimaryKey(taskMappingId);

		return taskMasterMapping;
	}

	/**
	 * Removes the task master mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskMappingId the primary key of the task master mapping
	 * @return the task master mapping that was removed
	 * @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	 */
	@Override
	public TaskMasterMapping remove(long taskMappingId)
		throws NoSuchTaskMasterMappingException {
		return remove((Serializable)taskMappingId);
	}

	/**
	 * Removes the task master mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task master mapping
	 * @return the task master mapping that was removed
	 * @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	 */
	@Override
	public TaskMasterMapping remove(Serializable primaryKey)
		throws NoSuchTaskMasterMappingException {
		Session session = null;

		try {
			session = openSession();

			TaskMasterMapping taskMasterMapping = (TaskMasterMapping)session.get(TaskMasterMappingImpl.class,
					primaryKey);

			if (taskMasterMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskMasterMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskMasterMapping);
		}
		catch (NoSuchTaskMasterMappingException nsee) {
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
	protected TaskMasterMapping removeImpl(TaskMasterMapping taskMasterMapping) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskMasterMapping)) {
				taskMasterMapping = (TaskMasterMapping)session.get(TaskMasterMappingImpl.class,
						taskMasterMapping.getPrimaryKeyObj());
			}

			if (taskMasterMapping != null) {
				session.delete(taskMasterMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskMasterMapping != null) {
			clearCache(taskMasterMapping);
		}

		return taskMasterMapping;
	}

	@Override
	public TaskMasterMapping updateImpl(TaskMasterMapping taskMasterMapping) {
		boolean isNew = taskMasterMapping.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taskMasterMapping.isNew()) {
				session.save(taskMasterMapping);

				taskMasterMapping.setNew(false);
			}
			else {
				taskMasterMapping = (TaskMasterMapping)session.merge(taskMasterMapping);
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

		entityCache.putResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
			TaskMasterMappingImpl.class, taskMasterMapping.getPrimaryKey(),
			taskMasterMapping, false);

		taskMasterMapping.resetOriginalValues();

		return taskMasterMapping;
	}

	/**
	 * Returns the task master mapping with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task master mapping
	 * @return the task master mapping
	 * @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	 */
	@Override
	public TaskMasterMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskMasterMappingException {
		TaskMasterMapping taskMasterMapping = fetchByPrimaryKey(primaryKey);

		if (taskMasterMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskMasterMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskMasterMapping;
	}

	/**
	 * Returns the task master mapping with the primary key or throws a {@link NoSuchTaskMasterMappingException} if it could not be found.
	 *
	 * @param taskMappingId the primary key of the task master mapping
	 * @return the task master mapping
	 * @throws NoSuchTaskMasterMappingException if a task master mapping with the primary key could not be found
	 */
	@Override
	public TaskMasterMapping findByPrimaryKey(long taskMappingId)
		throws NoSuchTaskMasterMappingException {
		return findByPrimaryKey((Serializable)taskMappingId);
	}

	/**
	 * Returns the task master mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task master mapping
	 * @return the task master mapping, or <code>null</code> if a task master mapping with the primary key could not be found
	 */
	@Override
	public TaskMasterMapping fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
				TaskMasterMappingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaskMasterMapping taskMasterMapping = (TaskMasterMapping)serializable;

		if (taskMasterMapping == null) {
			Session session = null;

			try {
				session = openSession();

				taskMasterMapping = (TaskMasterMapping)session.get(TaskMasterMappingImpl.class,
						primaryKey);

				if (taskMasterMapping != null) {
					cacheResult(taskMasterMapping);
				}
				else {
					entityCache.putResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
						TaskMasterMappingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
					TaskMasterMappingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskMasterMapping;
	}

	/**
	 * Returns the task master mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskMappingId the primary key of the task master mapping
	 * @return the task master mapping, or <code>null</code> if a task master mapping with the primary key could not be found
	 */
	@Override
	public TaskMasterMapping fetchByPrimaryKey(long taskMappingId) {
		return fetchByPrimaryKey((Serializable)taskMappingId);
	}

	@Override
	public Map<Serializable, TaskMasterMapping> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaskMasterMapping> map = new HashMap<Serializable, TaskMasterMapping>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaskMasterMapping taskMasterMapping = fetchByPrimaryKey(primaryKey);

			if (taskMasterMapping != null) {
				map.put(primaryKey, taskMasterMapping);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
					TaskMasterMappingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaskMasterMapping)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TASKMASTERMAPPING_WHERE_PKS_IN);

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

			for (TaskMasterMapping taskMasterMapping : (List<TaskMasterMapping>)q.list()) {
				map.put(taskMasterMapping.getPrimaryKeyObj(), taskMasterMapping);

				cacheResult(taskMasterMapping);

				uncachedPrimaryKeys.remove(taskMasterMapping.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaskMasterMappingModelImpl.ENTITY_CACHE_ENABLED,
					TaskMasterMappingImpl.class, primaryKey, nullModel);
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
	 * Returns all the task master mappings.
	 *
	 * @return the task master mappings
	 */
	@Override
	public List<TaskMasterMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task master mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task master mappings
	 * @param end the upper bound of the range of task master mappings (not inclusive)
	 * @return the range of task master mappings
	 */
	@Override
	public List<TaskMasterMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task master mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task master mappings
	 * @param end the upper bound of the range of task master mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task master mappings
	 */
	@Override
	public List<TaskMasterMapping> findAll(int start, int end,
		OrderByComparator<TaskMasterMapping> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the task master mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskMasterMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task master mappings
	 * @param end the upper bound of the range of task master mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of task master mappings
	 */
	@Override
	public List<TaskMasterMapping> findAll(int start, int end,
		OrderByComparator<TaskMasterMapping> orderByComparator,
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

		List<TaskMasterMapping> list = null;

		if (retrieveFromCache) {
			list = (List<TaskMasterMapping>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TASKMASTERMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKMASTERMAPPING;

				if (pagination) {
					sql = sql.concat(TaskMasterMappingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskMasterMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskMasterMapping>)QueryUtil.list(q,
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
	 * Removes all the task master mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskMasterMapping taskMasterMapping : findAll()) {
			remove(taskMasterMapping);
		}
	}

	/**
	 * Returns the number of task master mappings.
	 *
	 * @return the number of task master mappings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKMASTERMAPPING);

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
		return TaskMasterMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task master mapping persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaskMasterMappingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TASKMASTERMAPPING = "SELECT taskMasterMapping FROM TaskMasterMapping taskMasterMapping";
	private static final String _SQL_SELECT_TASKMASTERMAPPING_WHERE_PKS_IN = "SELECT taskMasterMapping FROM TaskMasterMapping taskMasterMapping WHERE taskMappingId IN (";
	private static final String _SQL_COUNT_TASKMASTERMAPPING = "SELECT COUNT(taskMasterMapping) FROM TaskMasterMapping taskMasterMapping";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskMasterMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskMasterMapping exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TaskMasterMappingPersistenceImpl.class);
}