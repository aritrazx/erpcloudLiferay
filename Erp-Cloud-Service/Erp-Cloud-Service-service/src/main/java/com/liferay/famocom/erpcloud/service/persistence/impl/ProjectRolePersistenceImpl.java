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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectRoleException;
import com.liferay.famocom.erpcloud.model.ProjectRole;
import com.liferay.famocom.erpcloud.model.impl.ProjectRoleImpl;
import com.liferay.famocom.erpcloud.model.impl.ProjectRoleModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ProjectRolePersistence;

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
 * The persistence implementation for the project role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectRolePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ProjectRoleUtil
 * @generated
 */
@ProviderType
public class ProjectRolePersistenceImpl extends BasePersistenceImpl<ProjectRole>
	implements ProjectRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectRoleUtil} to access the project role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRoleModelImpl.FINDER_CACHE_ENABLED, ProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRoleModelImpl.FINDER_CACHE_ENABLED, ProjectRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectRolePersistenceImpl() {
		setModelClass(ProjectRole.class);
	}

	/**
	 * Caches the project role in the entity cache if it is enabled.
	 *
	 * @param projectRole the project role
	 */
	@Override
	public void cacheResult(ProjectRole projectRole) {
		entityCache.putResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRoleImpl.class, projectRole.getPrimaryKey(), projectRole);

		projectRole.resetOriginalValues();
	}

	/**
	 * Caches the project roles in the entity cache if it is enabled.
	 *
	 * @param projectRoles the project roles
	 */
	@Override
	public void cacheResult(List<ProjectRole> projectRoles) {
		for (ProjectRole projectRole : projectRoles) {
			if (entityCache.getResult(
						ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
						ProjectRoleImpl.class, projectRole.getPrimaryKey()) == null) {
				cacheResult(projectRole);
			}
			else {
				projectRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project roles.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project role.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectRole projectRole) {
		entityCache.removeResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRoleImpl.class, projectRole.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectRole> projectRoles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectRole projectRole : projectRoles) {
			entityCache.removeResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
				ProjectRoleImpl.class, projectRole.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project role with the primary key. Does not add the project role to the database.
	 *
	 * @param roleId the primary key for the new project role
	 * @return the new project role
	 */
	@Override
	public ProjectRole create(long roleId) {
		ProjectRole projectRole = new ProjectRoleImpl();

		projectRole.setNew(true);
		projectRole.setPrimaryKey(roleId);

		return projectRole;
	}

	/**
	 * Removes the project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the project role
	 * @return the project role that was removed
	 * @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	 */
	@Override
	public ProjectRole remove(long roleId) throws NoSuchProjectRoleException {
		return remove((Serializable)roleId);
	}

	/**
	 * Removes the project role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project role
	 * @return the project role that was removed
	 * @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	 */
	@Override
	public ProjectRole remove(Serializable primaryKey)
		throws NoSuchProjectRoleException {
		Session session = null;

		try {
			session = openSession();

			ProjectRole projectRole = (ProjectRole)session.get(ProjectRoleImpl.class,
					primaryKey);

			if (projectRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectRole);
		}
		catch (NoSuchProjectRoleException nsee) {
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
	protected ProjectRole removeImpl(ProjectRole projectRole) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectRole)) {
				projectRole = (ProjectRole)session.get(ProjectRoleImpl.class,
						projectRole.getPrimaryKeyObj());
			}

			if (projectRole != null) {
				session.delete(projectRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectRole != null) {
			clearCache(projectRole);
		}

		return projectRole;
	}

	@Override
	public ProjectRole updateImpl(ProjectRole projectRole) {
		boolean isNew = projectRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectRole.isNew()) {
				session.save(projectRole);

				projectRole.setNew(false);
			}
			else {
				projectRole = (ProjectRole)session.merge(projectRole);
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

		entityCache.putResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRoleImpl.class, projectRole.getPrimaryKey(), projectRole,
			false);

		projectRole.resetOriginalValues();

		return projectRole;
	}

	/**
	 * Returns the project role with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project role
	 * @return the project role
	 * @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	 */
	@Override
	public ProjectRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectRoleException {
		ProjectRole projectRole = fetchByPrimaryKey(primaryKey);

		if (projectRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectRole;
	}

	/**
	 * Returns the project role with the primary key or throws a {@link NoSuchProjectRoleException} if it could not be found.
	 *
	 * @param roleId the primary key of the project role
	 * @return the project role
	 * @throws NoSuchProjectRoleException if a project role with the primary key could not be found
	 */
	@Override
	public ProjectRole findByPrimaryKey(long roleId)
		throws NoSuchProjectRoleException {
		return findByPrimaryKey((Serializable)roleId);
	}

	/**
	 * Returns the project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project role
	 * @return the project role, or <code>null</code> if a project role with the primary key could not be found
	 */
	@Override
	public ProjectRole fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
				ProjectRoleImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectRole projectRole = (ProjectRole)serializable;

		if (projectRole == null) {
			Session session = null;

			try {
				session = openSession();

				projectRole = (ProjectRole)session.get(ProjectRoleImpl.class,
						primaryKey);

				if (projectRole != null) {
					cacheResult(projectRole);
				}
				else {
					entityCache.putResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
						ProjectRoleImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
					ProjectRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectRole;
	}

	/**
	 * Returns the project role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the project role
	 * @return the project role, or <code>null</code> if a project role with the primary key could not be found
	 */
	@Override
	public ProjectRole fetchByPrimaryKey(long roleId) {
		return fetchByPrimaryKey((Serializable)roleId);
	}

	@Override
	public Map<Serializable, ProjectRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectRole> map = new HashMap<Serializable, ProjectRole>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectRole projectRole = fetchByPrimaryKey(primaryKey);

			if (projectRole != null) {
				map.put(primaryKey, projectRole);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
					ProjectRoleImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectRole)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTROLE_WHERE_PKS_IN);

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

			for (ProjectRole projectRole : (List<ProjectRole>)q.list()) {
				map.put(projectRole.getPrimaryKeyObj(), projectRole);

				cacheResult(projectRole);

				uncachedPrimaryKeys.remove(projectRole.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectRoleModelImpl.ENTITY_CACHE_ENABLED,
					ProjectRoleImpl.class, primaryKey, nullModel);
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
	 * Returns all the project roles.
	 *
	 * @return the project roles
	 */
	@Override
	public List<ProjectRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project roles
	 * @param end the upper bound of the range of project roles (not inclusive)
	 * @return the range of project roles
	 */
	@Override
	public List<ProjectRole> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project roles
	 * @param end the upper bound of the range of project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project roles
	 */
	@Override
	public List<ProjectRole> findAll(int start, int end,
		OrderByComparator<ProjectRole> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project roles
	 * @param end the upper bound of the range of project roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project roles
	 */
	@Override
	public List<ProjectRole> findAll(int start, int end,
		OrderByComparator<ProjectRole> orderByComparator,
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

		List<ProjectRole> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRole>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTROLE;

				if (pagination) {
					sql = sql.concat(ProjectRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the project roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectRole projectRole : findAll()) {
			remove(projectRole);
		}
	}

	/**
	 * Returns the number of project roles.
	 *
	 * @return the number of project roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTROLE);

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
		return ProjectRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project role persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectRoleImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTROLE = "SELECT projectRole FROM ProjectRole projectRole";
	private static final String _SQL_SELECT_PROJECTROLE_WHERE_PKS_IN = "SELECT projectRole FROM ProjectRole projectRole WHERE roleId IN (";
	private static final String _SQL_COUNT_PROJECTROLE = "SELECT COUNT(projectRole) FROM ProjectRole projectRole";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectRole exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ProjectRolePersistenceImpl.class);
}