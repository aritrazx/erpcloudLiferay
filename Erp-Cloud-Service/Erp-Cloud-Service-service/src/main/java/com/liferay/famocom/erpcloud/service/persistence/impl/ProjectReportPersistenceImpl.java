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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectReportException;
import com.liferay.famocom.erpcloud.model.ProjectReport;
import com.liferay.famocom.erpcloud.model.impl.ProjectReportImpl;
import com.liferay.famocom.erpcloud.model.impl.ProjectReportModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ProjectReportPersistence;

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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the project report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectReportPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ProjectReportUtil
 * @generated
 */
@ProviderType
public class ProjectReportPersistenceImpl extends BasePersistenceImpl<ProjectReport>
	implements ProjectReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectReportUtil} to access the project report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
			ProjectReportModelImpl.FINDER_CACHE_ENABLED,
			ProjectReportImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
			ProjectReportModelImpl.FINDER_CACHE_ENABLED,
			ProjectReportImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
			ProjectReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectReportPersistenceImpl() {
		setModelClass(ProjectReport.class);
	}

	/**
	 * Caches the project report in the entity cache if it is enabled.
	 *
	 * @param projectReport the project report
	 */
	@Override
	public void cacheResult(ProjectReport projectReport) {
		entityCache.putResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
			ProjectReportImpl.class, projectReport.getPrimaryKey(),
			projectReport);

		projectReport.resetOriginalValues();
	}

	/**
	 * Caches the project reports in the entity cache if it is enabled.
	 *
	 * @param projectReports the project reports
	 */
	@Override
	public void cacheResult(List<ProjectReport> projectReports) {
		for (ProjectReport projectReport : projectReports) {
			if (entityCache.getResult(
						ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
						ProjectReportImpl.class, projectReport.getPrimaryKey()) == null) {
				cacheResult(projectReport);
			}
			else {
				projectReport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project reports.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectReportImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project report.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectReport projectReport) {
		entityCache.removeResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
			ProjectReportImpl.class, projectReport.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectReport> projectReports) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectReport projectReport : projectReports) {
			entityCache.removeResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
				ProjectReportImpl.class, projectReport.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project report with the primary key. Does not add the project report to the database.
	 *
	 * @param reportTemplateId the primary key for the new project report
	 * @return the new project report
	 */
	@Override
	public ProjectReport create(long reportTemplateId) {
		ProjectReport projectReport = new ProjectReportImpl();

		projectReport.setNew(true);
		projectReport.setPrimaryKey(reportTemplateId);

		return projectReport;
	}

	/**
	 * Removes the project report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportTemplateId the primary key of the project report
	 * @return the project report that was removed
	 * @throws NoSuchProjectReportException if a project report with the primary key could not be found
	 */
	@Override
	public ProjectReport remove(long reportTemplateId)
		throws NoSuchProjectReportException {
		return remove((Serializable)reportTemplateId);
	}

	/**
	 * Removes the project report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project report
	 * @return the project report that was removed
	 * @throws NoSuchProjectReportException if a project report with the primary key could not be found
	 */
	@Override
	public ProjectReport remove(Serializable primaryKey)
		throws NoSuchProjectReportException {
		Session session = null;

		try {
			session = openSession();

			ProjectReport projectReport = (ProjectReport)session.get(ProjectReportImpl.class,
					primaryKey);

			if (projectReport == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectReport);
		}
		catch (NoSuchProjectReportException nsee) {
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
	protected ProjectReport removeImpl(ProjectReport projectReport) {
		projectReport = toUnwrappedModel(projectReport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectReport)) {
				projectReport = (ProjectReport)session.get(ProjectReportImpl.class,
						projectReport.getPrimaryKeyObj());
			}

			if (projectReport != null) {
				session.delete(projectReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectReport != null) {
			clearCache(projectReport);
		}

		return projectReport;
	}

	@Override
	public ProjectReport updateImpl(ProjectReport projectReport) {
		projectReport = toUnwrappedModel(projectReport);

		boolean isNew = projectReport.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectReport.isNew()) {
				session.save(projectReport);

				projectReport.setNew(false);
			}
			else {
				projectReport = (ProjectReport)session.merge(projectReport);
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

		entityCache.putResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
			ProjectReportImpl.class, projectReport.getPrimaryKey(),
			projectReport, false);

		projectReport.resetOriginalValues();

		return projectReport;
	}

	protected ProjectReport toUnwrappedModel(ProjectReport projectReport) {
		if (projectReport instanceof ProjectReportImpl) {
			return projectReport;
		}

		ProjectReportImpl projectReportImpl = new ProjectReportImpl();

		projectReportImpl.setNew(projectReport.isNew());
		projectReportImpl.setPrimaryKey(projectReport.getPrimaryKey());

		projectReportImpl.setReportTemplateId(projectReport.getReportTemplateId());
		projectReportImpl.setProjectId(projectReport.getProjectId());
		projectReportImpl.setEmployeeId(projectReport.getEmployeeId());
		projectReportImpl.setTimesheetId(projectReport.getTimesheetId());
		projectReportImpl.setProjectTaskId(projectReport.getProjectTaskId());
		projectReportImpl.setFromDate(projectReport.getFromDate());
		projectReportImpl.setToDate(projectReport.getToDate());
		projectReportImpl.setTemplateNm(projectReport.getTemplateNm());
		projectReportImpl.setAddedDate(projectReport.getAddedDate());

		return projectReportImpl;
	}

	/**
	 * Returns the project report with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project report
	 * @return the project report
	 * @throws NoSuchProjectReportException if a project report with the primary key could not be found
	 */
	@Override
	public ProjectReport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectReportException {
		ProjectReport projectReport = fetchByPrimaryKey(primaryKey);

		if (projectReport == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectReport;
	}

	/**
	 * Returns the project report with the primary key or throws a {@link NoSuchProjectReportException} if it could not be found.
	 *
	 * @param reportTemplateId the primary key of the project report
	 * @return the project report
	 * @throws NoSuchProjectReportException if a project report with the primary key could not be found
	 */
	@Override
	public ProjectReport findByPrimaryKey(long reportTemplateId)
		throws NoSuchProjectReportException {
		return findByPrimaryKey((Serializable)reportTemplateId);
	}

	/**
	 * Returns the project report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project report
	 * @return the project report, or <code>null</code> if a project report with the primary key could not be found
	 */
	@Override
	public ProjectReport fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
				ProjectReportImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectReport projectReport = (ProjectReport)serializable;

		if (projectReport == null) {
			Session session = null;

			try {
				session = openSession();

				projectReport = (ProjectReport)session.get(ProjectReportImpl.class,
						primaryKey);

				if (projectReport != null) {
					cacheResult(projectReport);
				}
				else {
					entityCache.putResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
						ProjectReportImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
					ProjectReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectReport;
	}

	/**
	 * Returns the project report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportTemplateId the primary key of the project report
	 * @return the project report, or <code>null</code> if a project report with the primary key could not be found
	 */
	@Override
	public ProjectReport fetchByPrimaryKey(long reportTemplateId) {
		return fetchByPrimaryKey((Serializable)reportTemplateId);
	}

	@Override
	public Map<Serializable, ProjectReport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectReport> map = new HashMap<Serializable, ProjectReport>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectReport projectReport = fetchByPrimaryKey(primaryKey);

			if (projectReport != null) {
				map.put(primaryKey, projectReport);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
					ProjectReportImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectReport)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTREPORT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ProjectReport projectReport : (List<ProjectReport>)q.list()) {
				map.put(projectReport.getPrimaryKeyObj(), projectReport);

				cacheResult(projectReport);

				uncachedPrimaryKeys.remove(projectReport.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectReportModelImpl.ENTITY_CACHE_ENABLED,
					ProjectReportImpl.class, primaryKey, nullModel);
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
	 * Returns all the project reports.
	 *
	 * @return the project reports
	 */
	@Override
	public List<ProjectReport> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project reports
	 * @param end the upper bound of the range of project reports (not inclusive)
	 * @return the range of project reports
	 */
	@Override
	public List<ProjectReport> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project reports
	 * @param end the upper bound of the range of project reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project reports
	 */
	@Override
	public List<ProjectReport> findAll(int start, int end,
		OrderByComparator<ProjectReport> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project reports
	 * @param end the upper bound of the range of project reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project reports
	 */
	@Override
	public List<ProjectReport> findAll(int start, int end,
		OrderByComparator<ProjectReport> orderByComparator,
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

		List<ProjectReport> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectReport>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTREPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTREPORT;

				if (pagination) {
					sql = sql.concat(ProjectReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectReport>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the project reports from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectReport projectReport : findAll()) {
			remove(projectReport);
		}
	}

	/**
	 * Returns the number of project reports.
	 *
	 * @return the number of project reports
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTREPORT);

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
		return ProjectReportModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project report persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectReportImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTREPORT = "SELECT projectReport FROM ProjectReport projectReport";
	private static final String _SQL_SELECT_PROJECTREPORT_WHERE_PKS_IN = "SELECT projectReport FROM ProjectReport projectReport WHERE reportTemplateId IN (";
	private static final String _SQL_COUNT_PROJECTREPORT = "SELECT COUNT(projectReport) FROM ProjectReport projectReport";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectReport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectReport exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ProjectReportPersistenceImpl.class);
}