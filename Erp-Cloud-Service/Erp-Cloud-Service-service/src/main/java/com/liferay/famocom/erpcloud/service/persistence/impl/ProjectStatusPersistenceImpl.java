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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectStatusException;
import com.liferay.famocom.erpcloud.model.ProjectStatus;
import com.liferay.famocom.erpcloud.model.impl.ProjectStatusImpl;
import com.liferay.famocom.erpcloud.model.impl.ProjectStatusModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ProjectStatusPersistence;

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
 * The persistence implementation for the project status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectStatusPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ProjectStatusUtil
 * @generated
 */
@ProviderType
public class ProjectStatusPersistenceImpl extends BasePersistenceImpl<ProjectStatus>
	implements ProjectStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectStatusUtil} to access the project status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStatusModelImpl.FINDER_CACHE_ENABLED,
			ProjectStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStatusModelImpl.FINDER_CACHE_ENABLED,
			ProjectStatusImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectStatusPersistenceImpl() {
		setModelClass(ProjectStatus.class);
	}

	/**
	 * Caches the project status in the entity cache if it is enabled.
	 *
	 * @param projectStatus the project status
	 */
	@Override
	public void cacheResult(ProjectStatus projectStatus) {
		entityCache.putResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStatusImpl.class, projectStatus.getPrimaryKey(),
			projectStatus);

		projectStatus.resetOriginalValues();
	}

	/**
	 * Caches the project statuses in the entity cache if it is enabled.
	 *
	 * @param projectStatuses the project statuses
	 */
	@Override
	public void cacheResult(List<ProjectStatus> projectStatuses) {
		for (ProjectStatus projectStatus : projectStatuses) {
			if (entityCache.getResult(
						ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
						ProjectStatusImpl.class, projectStatus.getPrimaryKey()) == null) {
				cacheResult(projectStatus);
			}
			else {
				projectStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project statuses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectStatusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project status.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectStatus projectStatus) {
		entityCache.removeResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStatusImpl.class, projectStatus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectStatus> projectStatuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectStatus projectStatus : projectStatuses) {
			entityCache.removeResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
				ProjectStatusImpl.class, projectStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project status with the primary key. Does not add the project status to the database.
	 *
	 * @param projectStatusId the primary key for the new project status
	 * @return the new project status
	 */
	@Override
	public ProjectStatus create(long projectStatusId) {
		ProjectStatus projectStatus = new ProjectStatusImpl();

		projectStatus.setNew(true);
		projectStatus.setPrimaryKey(projectStatusId);

		projectStatus.setCompanyId(companyProvider.getCompanyId());

		return projectStatus;
	}

	/**
	 * Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status that was removed
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus remove(long projectStatusId)
		throws NoSuchProjectStatusException {
		return remove((Serializable)projectStatusId);
	}

	/**
	 * Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project status
	 * @return the project status that was removed
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus remove(Serializable primaryKey)
		throws NoSuchProjectStatusException {
		Session session = null;

		try {
			session = openSession();

			ProjectStatus projectStatus = (ProjectStatus)session.get(ProjectStatusImpl.class,
					primaryKey);

			if (projectStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectStatus);
		}
		catch (NoSuchProjectStatusException nsee) {
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
	protected ProjectStatus removeImpl(ProjectStatus projectStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectStatus)) {
				projectStatus = (ProjectStatus)session.get(ProjectStatusImpl.class,
						projectStatus.getPrimaryKeyObj());
			}

			if (projectStatus != null) {
				session.delete(projectStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectStatus != null) {
			clearCache(projectStatus);
		}

		return projectStatus;
	}

	@Override
	public ProjectStatus updateImpl(ProjectStatus projectStatus) {
		boolean isNew = projectStatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectStatus.isNew()) {
				session.save(projectStatus);

				projectStatus.setNew(false);
			}
			else {
				projectStatus = (ProjectStatus)session.merge(projectStatus);
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

		entityCache.putResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStatusImpl.class, projectStatus.getPrimaryKey(),
			projectStatus, false);

		projectStatus.resetOriginalValues();

		return projectStatus;
	}

	/**
	 * Returns the project status with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project status
	 * @return the project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectStatusException {
		ProjectStatus projectStatus = fetchByPrimaryKey(primaryKey);

		if (projectStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectStatus;
	}

	/**
	 * Returns the project status with the primary key or throws a {@link NoSuchProjectStatusException} if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus findByPrimaryKey(long projectStatusId)
		throws NoSuchProjectStatusException {
		return findByPrimaryKey((Serializable)projectStatusId);
	}

	/**
	 * Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project status
	 * @return the project status, or <code>null</code> if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
				ProjectStatusImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectStatus projectStatus = (ProjectStatus)serializable;

		if (projectStatus == null) {
			Session session = null;

			try {
				session = openSession();

				projectStatus = (ProjectStatus)session.get(ProjectStatusImpl.class,
						primaryKey);

				if (projectStatus != null) {
					cacheResult(projectStatus);
				}
				else {
					entityCache.putResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
						ProjectStatusImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
					ProjectStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectStatus;
	}

	/**
	 * Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status, or <code>null</code> if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus fetchByPrimaryKey(long projectStatusId) {
		return fetchByPrimaryKey((Serializable)projectStatusId);
	}

	@Override
	public Map<Serializable, ProjectStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectStatus> map = new HashMap<Serializable, ProjectStatus>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectStatus projectStatus = fetchByPrimaryKey(primaryKey);

			if (projectStatus != null) {
				map.put(primaryKey, projectStatus);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
					ProjectStatusImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectStatus)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTSTATUS_WHERE_PKS_IN);

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

			for (ProjectStatus projectStatus : (List<ProjectStatus>)q.list()) {
				map.put(projectStatus.getPrimaryKeyObj(), projectStatus);

				cacheResult(projectStatus);

				uncachedPrimaryKeys.remove(projectStatus.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectStatusModelImpl.ENTITY_CACHE_ENABLED,
					ProjectStatusImpl.class, primaryKey, nullModel);
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
	 * Returns all the project statuses.
	 *
	 * @return the project statuses
	 */
	@Override
	public List<ProjectStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @return the range of project statuses
	 */
	@Override
	public List<ProjectStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project statuses
	 */
	@Override
	public List<ProjectStatus> findAll(int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project statuses
	 */
	@Override
	public List<ProjectStatus> findAll(int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator,
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

		List<ProjectStatus> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectStatus>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTSTATUS;

				if (pagination) {
					sql = sql.concat(ProjectStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectStatus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectStatus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the project statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectStatus projectStatus : findAll()) {
			remove(projectStatus);
		}
	}

	/**
	 * Returns the number of project statuses.
	 *
	 * @return the number of project statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTSTATUS);

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
		return ProjectStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project status persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectStatusImpl.class.getName());
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
	private static final String _SQL_SELECT_PROJECTSTATUS = "SELECT projectStatus FROM ProjectStatus projectStatus";
	private static final String _SQL_SELECT_PROJECTSTATUS_WHERE_PKS_IN = "SELECT projectStatus FROM ProjectStatus projectStatus WHERE projectStatusId IN (";
	private static final String _SQL_COUNT_PROJECTSTATUS = "SELECT COUNT(projectStatus) FROM ProjectStatus projectStatus";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectStatus exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ProjectStatusPersistenceImpl.class);
}