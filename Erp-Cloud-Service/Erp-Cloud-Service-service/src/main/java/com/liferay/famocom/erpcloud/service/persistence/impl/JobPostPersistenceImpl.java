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

import com.liferay.famocom.erpcloud.exception.NoSuchJobPostException;
import com.liferay.famocom.erpcloud.model.JobPost;
import com.liferay.famocom.erpcloud.model.impl.JobPostImpl;
import com.liferay.famocom.erpcloud.model.impl.JobPostModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.JobPostPersistence;

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
 * The persistence implementation for the job post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see JobPostPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.JobPostUtil
 * @generated
 */
@ProviderType
public class JobPostPersistenceImpl extends BasePersistenceImpl<JobPost>
	implements JobPostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobPostUtil} to access the job post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobPostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobPostModelImpl.ENTITY_CACHE_ENABLED,
			JobPostModelImpl.FINDER_CACHE_ENABLED, JobPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobPostModelImpl.ENTITY_CACHE_ENABLED,
			JobPostModelImpl.FINDER_CACHE_ENABLED, JobPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobPostModelImpl.ENTITY_CACHE_ENABLED,
			JobPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public JobPostPersistenceImpl() {
		setModelClass(JobPost.class);
	}

	/**
	 * Caches the job post in the entity cache if it is enabled.
	 *
	 * @param jobPost the job post
	 */
	@Override
	public void cacheResult(JobPost jobPost) {
		entityCache.putResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
			JobPostImpl.class, jobPost.getPrimaryKey(), jobPost);

		jobPost.resetOriginalValues();
	}

	/**
	 * Caches the job posts in the entity cache if it is enabled.
	 *
	 * @param jobPosts the job posts
	 */
	@Override
	public void cacheResult(List<JobPost> jobPosts) {
		for (JobPost jobPost : jobPosts) {
			if (entityCache.getResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
						JobPostImpl.class, jobPost.getPrimaryKey()) == null) {
				cacheResult(jobPost);
			}
			else {
				jobPost.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job posts.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobPostImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job post.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobPost jobPost) {
		entityCache.removeResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
			JobPostImpl.class, jobPost.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobPost> jobPosts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobPost jobPost : jobPosts) {
			entityCache.removeResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
				JobPostImpl.class, jobPost.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job post with the primary key. Does not add the job post to the database.
	 *
	 * @param jobPostId the primary key for the new job post
	 * @return the new job post
	 */
	@Override
	public JobPost create(long jobPostId) {
		JobPost jobPost = new JobPostImpl();

		jobPost.setNew(true);
		jobPost.setPrimaryKey(jobPostId);

		return jobPost;
	}

	/**
	 * Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post that was removed
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost remove(long jobPostId) throws NoSuchJobPostException {
		return remove((Serializable)jobPostId);
	}

	/**
	 * Removes the job post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job post
	 * @return the job post that was removed
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost remove(Serializable primaryKey)
		throws NoSuchJobPostException {
		Session session = null;

		try {
			session = openSession();

			JobPost jobPost = (JobPost)session.get(JobPostImpl.class, primaryKey);

			if (jobPost == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobPost);
		}
		catch (NoSuchJobPostException nsee) {
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
	protected JobPost removeImpl(JobPost jobPost) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobPost)) {
				jobPost = (JobPost)session.get(JobPostImpl.class,
						jobPost.getPrimaryKeyObj());
			}

			if (jobPost != null) {
				session.delete(jobPost);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobPost != null) {
			clearCache(jobPost);
		}

		return jobPost;
	}

	@Override
	public JobPost updateImpl(JobPost jobPost) {
		boolean isNew = jobPost.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jobPost.isNew()) {
				session.save(jobPost);

				jobPost.setNew(false);
			}
			else {
				jobPost = (JobPost)session.merge(jobPost);
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

		entityCache.putResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
			JobPostImpl.class, jobPost.getPrimaryKey(), jobPost, false);

		jobPost.resetOriginalValues();

		return jobPost;
	}

	/**
	 * Returns the job post with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job post
	 * @return the job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobPostException {
		JobPost jobPost = fetchByPrimaryKey(primaryKey);

		if (jobPost == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobPost;
	}

	/**
	 * Returns the job post with the primary key or throws a {@link NoSuchJobPostException} if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post
	 * @throws NoSuchJobPostException if a job post with the primary key could not be found
	 */
	@Override
	public JobPost findByPrimaryKey(long jobPostId)
		throws NoSuchJobPostException {
		return findByPrimaryKey((Serializable)jobPostId);
	}

	/**
	 * Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job post
	 * @return the job post, or <code>null</code> if a job post with the primary key could not be found
	 */
	@Override
	public JobPost fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
				JobPostImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		JobPost jobPost = (JobPost)serializable;

		if (jobPost == null) {
			Session session = null;

			try {
				session = openSession();

				jobPost = (JobPost)session.get(JobPostImpl.class, primaryKey);

				if (jobPost != null) {
					cacheResult(jobPost);
				}
				else {
					entityCache.putResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
						JobPostImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
					JobPostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobPost;
	}

	/**
	 * Returns the job post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPostId the primary key of the job post
	 * @return the job post, or <code>null</code> if a job post with the primary key could not be found
	 */
	@Override
	public JobPost fetchByPrimaryKey(long jobPostId) {
		return fetchByPrimaryKey((Serializable)jobPostId);
	}

	@Override
	public Map<Serializable, JobPost> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, JobPost> map = new HashMap<Serializable, JobPost>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			JobPost jobPost = fetchByPrimaryKey(primaryKey);

			if (jobPost != null) {
				map.put(primaryKey, jobPost);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
					JobPostImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (JobPost)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_JOBPOST_WHERE_PKS_IN);

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

			for (JobPost jobPost : (List<JobPost>)q.list()) {
				map.put(jobPost.getPrimaryKeyObj(), jobPost);

				cacheResult(jobPost);

				uncachedPrimaryKeys.remove(jobPost.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(JobPostModelImpl.ENTITY_CACHE_ENABLED,
					JobPostImpl.class, primaryKey, nullModel);
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
	 * Returns all the job posts.
	 *
	 * @return the job posts
	 */
	@Override
	public List<JobPost> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @return the range of job posts
	 */
	@Override
	public List<JobPost> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job posts
	 */
	@Override
	public List<JobPost> findAll(int start, int end,
		OrderByComparator<JobPost> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job posts
	 * @param end the upper bound of the range of job posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of job posts
	 */
	@Override
	public List<JobPost> findAll(int start, int end,
		OrderByComparator<JobPost> orderByComparator, boolean retrieveFromCache) {
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

		List<JobPost> list = null;

		if (retrieveFromCache) {
			list = (List<JobPost>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JOBPOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBPOST;

				if (pagination) {
					sql = sql.concat(JobPostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobPost>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<JobPost>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job posts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobPost jobPost : findAll()) {
			remove(jobPost);
		}
	}

	/**
	 * Returns the number of job posts.
	 *
	 * @return the number of job posts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOBPOST);

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
		return JobPostModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job post persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(JobPostImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_JOBPOST = "SELECT jobPost FROM JobPost jobPost";
	private static final String _SQL_SELECT_JOBPOST_WHERE_PKS_IN = "SELECT jobPost FROM JobPost jobPost WHERE jobPostId IN (";
	private static final String _SQL_COUNT_JOBPOST = "SELECT COUNT(jobPost) FROM JobPost jobPost";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobPost.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobPost exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(JobPostPersistenceImpl.class);
}