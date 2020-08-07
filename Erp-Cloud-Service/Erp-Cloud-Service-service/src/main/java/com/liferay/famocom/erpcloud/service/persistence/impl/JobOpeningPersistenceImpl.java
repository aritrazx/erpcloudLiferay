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

import com.liferay.famocom.erpcloud.exception.NoSuchJobOpeningException;
import com.liferay.famocom.erpcloud.model.JobOpening;
import com.liferay.famocom.erpcloud.model.impl.JobOpeningImpl;
import com.liferay.famocom.erpcloud.model.impl.JobOpeningModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.JobOpeningPersistence;

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
 * The persistence implementation for the job opening service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see JobOpeningPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.JobOpeningUtil
 * @generated
 */
@ProviderType
public class JobOpeningPersistenceImpl extends BasePersistenceImpl<JobOpening>
	implements JobOpeningPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobOpeningUtil} to access the job opening persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobOpeningImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
			JobOpeningModelImpl.FINDER_CACHE_ENABLED, JobOpeningImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
			JobOpeningModelImpl.FINDER_CACHE_ENABLED, JobOpeningImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
			JobOpeningModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public JobOpeningPersistenceImpl() {
		setModelClass(JobOpening.class);
	}

	/**
	 * Caches the job opening in the entity cache if it is enabled.
	 *
	 * @param jobOpening the job opening
	 */
	@Override
	public void cacheResult(JobOpening jobOpening) {
		entityCache.putResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
			JobOpeningImpl.class, jobOpening.getPrimaryKey(), jobOpening);

		jobOpening.resetOriginalValues();
	}

	/**
	 * Caches the job openings in the entity cache if it is enabled.
	 *
	 * @param jobOpenings the job openings
	 */
	@Override
	public void cacheResult(List<JobOpening> jobOpenings) {
		for (JobOpening jobOpening : jobOpenings) {
			if (entityCache.getResult(
						JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
						JobOpeningImpl.class, jobOpening.getPrimaryKey()) == null) {
				cacheResult(jobOpening);
			}
			else {
				jobOpening.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job openings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobOpeningImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job opening.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobOpening jobOpening) {
		entityCache.removeResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
			JobOpeningImpl.class, jobOpening.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobOpening> jobOpenings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobOpening jobOpening : jobOpenings) {
			entityCache.removeResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
				JobOpeningImpl.class, jobOpening.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job opening with the primary key. Does not add the job opening to the database.
	 *
	 * @param jobOpeningId the primary key for the new job opening
	 * @return the new job opening
	 */
	@Override
	public JobOpening create(long jobOpeningId) {
		JobOpening jobOpening = new JobOpeningImpl();

		jobOpening.setNew(true);
		jobOpening.setPrimaryKey(jobOpeningId);

		return jobOpening;
	}

	/**
	 * Removes the job opening with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobOpeningId the primary key of the job opening
	 * @return the job opening that was removed
	 * @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	 */
	@Override
	public JobOpening remove(long jobOpeningId)
		throws NoSuchJobOpeningException {
		return remove((Serializable)jobOpeningId);
	}

	/**
	 * Removes the job opening with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job opening
	 * @return the job opening that was removed
	 * @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	 */
	@Override
	public JobOpening remove(Serializable primaryKey)
		throws NoSuchJobOpeningException {
		Session session = null;

		try {
			session = openSession();

			JobOpening jobOpening = (JobOpening)session.get(JobOpeningImpl.class,
					primaryKey);

			if (jobOpening == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobOpeningException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobOpening);
		}
		catch (NoSuchJobOpeningException nsee) {
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
	protected JobOpening removeImpl(JobOpening jobOpening) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobOpening)) {
				jobOpening = (JobOpening)session.get(JobOpeningImpl.class,
						jobOpening.getPrimaryKeyObj());
			}

			if (jobOpening != null) {
				session.delete(jobOpening);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobOpening != null) {
			clearCache(jobOpening);
		}

		return jobOpening;
	}

	@Override
	public JobOpening updateImpl(JobOpening jobOpening) {
		boolean isNew = jobOpening.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jobOpening.isNew()) {
				session.save(jobOpening);

				jobOpening.setNew(false);
			}
			else {
				jobOpening = (JobOpening)session.merge(jobOpening);
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

		entityCache.putResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
			JobOpeningImpl.class, jobOpening.getPrimaryKey(), jobOpening, false);

		jobOpening.resetOriginalValues();

		return jobOpening;
	}

	/**
	 * Returns the job opening with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job opening
	 * @return the job opening
	 * @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	 */
	@Override
	public JobOpening findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobOpeningException {
		JobOpening jobOpening = fetchByPrimaryKey(primaryKey);

		if (jobOpening == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobOpeningException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobOpening;
	}

	/**
	 * Returns the job opening with the primary key or throws a {@link NoSuchJobOpeningException} if it could not be found.
	 *
	 * @param jobOpeningId the primary key of the job opening
	 * @return the job opening
	 * @throws NoSuchJobOpeningException if a job opening with the primary key could not be found
	 */
	@Override
	public JobOpening findByPrimaryKey(long jobOpeningId)
		throws NoSuchJobOpeningException {
		return findByPrimaryKey((Serializable)jobOpeningId);
	}

	/**
	 * Returns the job opening with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job opening
	 * @return the job opening, or <code>null</code> if a job opening with the primary key could not be found
	 */
	@Override
	public JobOpening fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
				JobOpeningImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		JobOpening jobOpening = (JobOpening)serializable;

		if (jobOpening == null) {
			Session session = null;

			try {
				session = openSession();

				jobOpening = (JobOpening)session.get(JobOpeningImpl.class,
						primaryKey);

				if (jobOpening != null) {
					cacheResult(jobOpening);
				}
				else {
					entityCache.putResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
						JobOpeningImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
					JobOpeningImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobOpening;
	}

	/**
	 * Returns the job opening with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobOpeningId the primary key of the job opening
	 * @return the job opening, or <code>null</code> if a job opening with the primary key could not be found
	 */
	@Override
	public JobOpening fetchByPrimaryKey(long jobOpeningId) {
		return fetchByPrimaryKey((Serializable)jobOpeningId);
	}

	@Override
	public Map<Serializable, JobOpening> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, JobOpening> map = new HashMap<Serializable, JobOpening>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			JobOpening jobOpening = fetchByPrimaryKey(primaryKey);

			if (jobOpening != null) {
				map.put(primaryKey, jobOpening);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
					JobOpeningImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (JobOpening)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_JOBOPENING_WHERE_PKS_IN);

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

			for (JobOpening jobOpening : (List<JobOpening>)q.list()) {
				map.put(jobOpening.getPrimaryKeyObj(), jobOpening);

				cacheResult(jobOpening);

				uncachedPrimaryKeys.remove(jobOpening.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(JobOpeningModelImpl.ENTITY_CACHE_ENABLED,
					JobOpeningImpl.class, primaryKey, nullModel);
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
	 * Returns all the job openings.
	 *
	 * @return the job openings
	 */
	@Override
	public List<JobOpening> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job openings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job openings
	 * @param end the upper bound of the range of job openings (not inclusive)
	 * @return the range of job openings
	 */
	@Override
	public List<JobOpening> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job openings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job openings
	 * @param end the upper bound of the range of job openings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job openings
	 */
	@Override
	public List<JobOpening> findAll(int start, int end,
		OrderByComparator<JobOpening> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job openings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobOpeningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job openings
	 * @param end the upper bound of the range of job openings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of job openings
	 */
	@Override
	public List<JobOpening> findAll(int start, int end,
		OrderByComparator<JobOpening> orderByComparator,
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

		List<JobOpening> list = null;

		if (retrieveFromCache) {
			list = (List<JobOpening>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JOBOPENING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBOPENING;

				if (pagination) {
					sql = sql.concat(JobOpeningModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobOpening>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<JobOpening>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job openings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobOpening jobOpening : findAll()) {
			remove(jobOpening);
		}
	}

	/**
	 * Returns the number of job openings.
	 *
	 * @return the number of job openings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOBOPENING);

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
		return JobOpeningModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job opening persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(JobOpeningImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_JOBOPENING = "SELECT jobOpening FROM JobOpening jobOpening";
	private static final String _SQL_SELECT_JOBOPENING_WHERE_PKS_IN = "SELECT jobOpening FROM JobOpening jobOpening WHERE jobOpeningId IN (";
	private static final String _SQL_COUNT_JOBOPENING = "SELECT COUNT(jobOpening) FROM JobOpening jobOpening";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobOpening.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobOpening exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(JobOpeningPersistenceImpl.class);
}