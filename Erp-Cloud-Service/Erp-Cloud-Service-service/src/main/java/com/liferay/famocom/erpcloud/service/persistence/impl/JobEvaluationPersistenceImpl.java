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

import com.liferay.famocom.erpcloud.exception.NoSuchJobEvaluationException;
import com.liferay.famocom.erpcloud.model.JobEvaluation;
import com.liferay.famocom.erpcloud.model.impl.JobEvaluationImpl;
import com.liferay.famocom.erpcloud.model.impl.JobEvaluationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.JobEvaluationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the job evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see JobEvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.JobEvaluationUtil
 * @generated
 */
@ProviderType
public class JobEvaluationPersistenceImpl extends BasePersistenceImpl<JobEvaluation>
	implements JobEvaluationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobEvaluationUtil} to access the job evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobEvaluationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationModelImpl.FINDER_CACHE_ENABLED,
			JobEvaluationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationModelImpl.FINDER_CACHE_ENABLED,
			JobEvaluationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBEVALUATION =
		new FinderPath(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationModelImpl.FINDER_CACHE_ENABLED,
			JobEvaluationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByjobEvaluation",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBEVALUATION =
		new FinderPath(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationModelImpl.FINDER_CACHE_ENABLED,
			JobEvaluationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByjobEvaluation", new String[] { Long.class.getName() },
			JobEvaluationModelImpl.JOBPOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBEVALUATION = new FinderPath(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByjobEvaluation",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the job evaluations where jobPostId = &#63;.
	 *
	 * @param jobPostId the job post ID
	 * @return the matching job evaluations
	 */
	@Override
	public List<JobEvaluation> findByjobEvaluation(long jobPostId) {
		return findByjobEvaluation(jobPostId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job evaluations where jobPostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobPostId the job post ID
	 * @param start the lower bound of the range of job evaluations
	 * @param end the upper bound of the range of job evaluations (not inclusive)
	 * @return the range of matching job evaluations
	 */
	@Override
	public List<JobEvaluation> findByjobEvaluation(long jobPostId, int start,
		int end) {
		return findByjobEvaluation(jobPostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job evaluations where jobPostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobPostId the job post ID
	 * @param start the lower bound of the range of job evaluations
	 * @param end the upper bound of the range of job evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job evaluations
	 */
	@Override
	public List<JobEvaluation> findByjobEvaluation(long jobPostId, int start,
		int end, OrderByComparator<JobEvaluation> orderByComparator) {
		return findByjobEvaluation(jobPostId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the job evaluations where jobPostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobPostId the job post ID
	 * @param start the lower bound of the range of job evaluations
	 * @param end the upper bound of the range of job evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching job evaluations
	 */
	@Override
	public List<JobEvaluation> findByjobEvaluation(long jobPostId, int start,
		int end, OrderByComparator<JobEvaluation> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBEVALUATION;
			finderArgs = new Object[] { jobPostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBEVALUATION;
			finderArgs = new Object[] { jobPostId, start, end, orderByComparator };
		}

		List<JobEvaluation> list = null;

		if (retrieveFromCache) {
			list = (List<JobEvaluation>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (JobEvaluation jobEvaluation : list) {
					if ((jobPostId != jobEvaluation.getJobPostId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_JOBEVALUATION_WHERE);

			query.append(_FINDER_COLUMN_JOBEVALUATION_JOBPOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobEvaluationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobPostId);

				if (!pagination) {
					list = (List<JobEvaluation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<JobEvaluation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job evaluation in the ordered set where jobPostId = &#63;.
	 *
	 * @param jobPostId the job post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job evaluation
	 * @throws NoSuchJobEvaluationException if a matching job evaluation could not be found
	 */
	@Override
	public JobEvaluation findByjobEvaluation_First(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator)
		throws NoSuchJobEvaluationException {
		JobEvaluation jobEvaluation = fetchByjobEvaluation_First(jobPostId,
				orderByComparator);

		if (jobEvaluation != null) {
			return jobEvaluation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobPostId=");
		msg.append(jobPostId);

		msg.append("}");

		throw new NoSuchJobEvaluationException(msg.toString());
	}

	/**
	 * Returns the first job evaluation in the ordered set where jobPostId = &#63;.
	 *
	 * @param jobPostId the job post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job evaluation, or <code>null</code> if a matching job evaluation could not be found
	 */
	@Override
	public JobEvaluation fetchByjobEvaluation_First(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator) {
		List<JobEvaluation> list = findByjobEvaluation(jobPostId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job evaluation in the ordered set where jobPostId = &#63;.
	 *
	 * @param jobPostId the job post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job evaluation
	 * @throws NoSuchJobEvaluationException if a matching job evaluation could not be found
	 */
	@Override
	public JobEvaluation findByjobEvaluation_Last(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator)
		throws NoSuchJobEvaluationException {
		JobEvaluation jobEvaluation = fetchByjobEvaluation_Last(jobPostId,
				orderByComparator);

		if (jobEvaluation != null) {
			return jobEvaluation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobPostId=");
		msg.append(jobPostId);

		msg.append("}");

		throw new NoSuchJobEvaluationException(msg.toString());
	}

	/**
	 * Returns the last job evaluation in the ordered set where jobPostId = &#63;.
	 *
	 * @param jobPostId the job post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job evaluation, or <code>null</code> if a matching job evaluation could not be found
	 */
	@Override
	public JobEvaluation fetchByjobEvaluation_Last(long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator) {
		int count = countByjobEvaluation(jobPostId);

		if (count == 0) {
			return null;
		}

		List<JobEvaluation> list = findByjobEvaluation(jobPostId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job evaluations before and after the current job evaluation in the ordered set where jobPostId = &#63;.
	 *
	 * @param postEvaluationId the primary key of the current job evaluation
	 * @param jobPostId the job post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job evaluation
	 * @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation[] findByjobEvaluation_PrevAndNext(
		long postEvaluationId, long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator)
		throws NoSuchJobEvaluationException {
		JobEvaluation jobEvaluation = findByPrimaryKey(postEvaluationId);

		Session session = null;

		try {
			session = openSession();

			JobEvaluation[] array = new JobEvaluationImpl[3];

			array[0] = getByjobEvaluation_PrevAndNext(session, jobEvaluation,
					jobPostId, orderByComparator, true);

			array[1] = jobEvaluation;

			array[2] = getByjobEvaluation_PrevAndNext(session, jobEvaluation,
					jobPostId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobEvaluation getByjobEvaluation_PrevAndNext(Session session,
		JobEvaluation jobEvaluation, long jobPostId,
		OrderByComparator<JobEvaluation> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBEVALUATION_WHERE);

		query.append(_FINDER_COLUMN_JOBEVALUATION_JOBPOSTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(JobEvaluationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jobPostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobEvaluation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobEvaluation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job evaluations where jobPostId = &#63; from the database.
	 *
	 * @param jobPostId the job post ID
	 */
	@Override
	public void removeByjobEvaluation(long jobPostId) {
		for (JobEvaluation jobEvaluation : findByjobEvaluation(jobPostId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobEvaluation);
		}
	}

	/**
	 * Returns the number of job evaluations where jobPostId = &#63;.
	 *
	 * @param jobPostId the job post ID
	 * @return the number of matching job evaluations
	 */
	@Override
	public int countByjobEvaluation(long jobPostId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBEVALUATION;

		Object[] finderArgs = new Object[] { jobPostId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBEVALUATION_WHERE);

			query.append(_FINDER_COLUMN_JOBEVALUATION_JOBPOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobPostId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_JOBEVALUATION_JOBPOSTID_2 = "jobEvaluation.jobPostId = ?";

	public JobEvaluationPersistenceImpl() {
		setModelClass(JobEvaluation.class);
	}

	/**
	 * Caches the job evaluation in the entity cache if it is enabled.
	 *
	 * @param jobEvaluation the job evaluation
	 */
	@Override
	public void cacheResult(JobEvaluation jobEvaluation) {
		entityCache.putResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationImpl.class, jobEvaluation.getPrimaryKey(),
			jobEvaluation);

		jobEvaluation.resetOriginalValues();
	}

	/**
	 * Caches the job evaluations in the entity cache if it is enabled.
	 *
	 * @param jobEvaluations the job evaluations
	 */
	@Override
	public void cacheResult(List<JobEvaluation> jobEvaluations) {
		for (JobEvaluation jobEvaluation : jobEvaluations) {
			if (entityCache.getResult(
						JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						JobEvaluationImpl.class, jobEvaluation.getPrimaryKey()) == null) {
				cacheResult(jobEvaluation);
			}
			else {
				jobEvaluation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job evaluations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobEvaluationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job evaluation.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobEvaluation jobEvaluation) {
		entityCache.removeResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationImpl.class, jobEvaluation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobEvaluation> jobEvaluations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobEvaluation jobEvaluation : jobEvaluations) {
			entityCache.removeResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				JobEvaluationImpl.class, jobEvaluation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job evaluation with the primary key. Does not add the job evaluation to the database.
	 *
	 * @param postEvaluationId the primary key for the new job evaluation
	 * @return the new job evaluation
	 */
	@Override
	public JobEvaluation create(long postEvaluationId) {
		JobEvaluation jobEvaluation = new JobEvaluationImpl();

		jobEvaluation.setNew(true);
		jobEvaluation.setPrimaryKey(postEvaluationId);

		return jobEvaluation;
	}

	/**
	 * Removes the job evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postEvaluationId the primary key of the job evaluation
	 * @return the job evaluation that was removed
	 * @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation remove(long postEvaluationId)
		throws NoSuchJobEvaluationException {
		return remove((Serializable)postEvaluationId);
	}

	/**
	 * Removes the job evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job evaluation
	 * @return the job evaluation that was removed
	 * @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation remove(Serializable primaryKey)
		throws NoSuchJobEvaluationException {
		Session session = null;

		try {
			session = openSession();

			JobEvaluation jobEvaluation = (JobEvaluation)session.get(JobEvaluationImpl.class,
					primaryKey);

			if (jobEvaluation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobEvaluation);
		}
		catch (NoSuchJobEvaluationException nsee) {
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
	protected JobEvaluation removeImpl(JobEvaluation jobEvaluation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobEvaluation)) {
				jobEvaluation = (JobEvaluation)session.get(JobEvaluationImpl.class,
						jobEvaluation.getPrimaryKeyObj());
			}

			if (jobEvaluation != null) {
				session.delete(jobEvaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobEvaluation != null) {
			clearCache(jobEvaluation);
		}

		return jobEvaluation;
	}

	@Override
	public JobEvaluation updateImpl(JobEvaluation jobEvaluation) {
		boolean isNew = jobEvaluation.isNew();

		if (!(jobEvaluation instanceof JobEvaluationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(jobEvaluation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(jobEvaluation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in jobEvaluation proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JobEvaluation implementation " +
				jobEvaluation.getClass());
		}

		JobEvaluationModelImpl jobEvaluationModelImpl = (JobEvaluationModelImpl)jobEvaluation;

		Session session = null;

		try {
			session = openSession();

			if (jobEvaluation.isNew()) {
				session.save(jobEvaluation);

				jobEvaluation.setNew(false);
			}
			else {
				jobEvaluation = (JobEvaluation)session.merge(jobEvaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!JobEvaluationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { jobEvaluationModelImpl.getJobPostId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_JOBEVALUATION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBEVALUATION,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((jobEvaluationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBEVALUATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobEvaluationModelImpl.getOriginalJobPostId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_JOBEVALUATION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBEVALUATION,
					args);

				args = new Object[] { jobEvaluationModelImpl.getJobPostId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_JOBEVALUATION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBEVALUATION,
					args);
			}
		}

		entityCache.putResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			JobEvaluationImpl.class, jobEvaluation.getPrimaryKey(),
			jobEvaluation, false);

		jobEvaluation.resetOriginalValues();

		return jobEvaluation;
	}

	/**
	 * Returns the job evaluation with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job evaluation
	 * @return the job evaluation
	 * @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobEvaluationException {
		JobEvaluation jobEvaluation = fetchByPrimaryKey(primaryKey);

		if (jobEvaluation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobEvaluation;
	}

	/**
	 * Returns the job evaluation with the primary key or throws a {@link NoSuchJobEvaluationException} if it could not be found.
	 *
	 * @param postEvaluationId the primary key of the job evaluation
	 * @return the job evaluation
	 * @throws NoSuchJobEvaluationException if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation findByPrimaryKey(long postEvaluationId)
		throws NoSuchJobEvaluationException {
		return findByPrimaryKey((Serializable)postEvaluationId);
	}

	/**
	 * Returns the job evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job evaluation
	 * @return the job evaluation, or <code>null</code> if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				JobEvaluationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		JobEvaluation jobEvaluation = (JobEvaluation)serializable;

		if (jobEvaluation == null) {
			Session session = null;

			try {
				session = openSession();

				jobEvaluation = (JobEvaluation)session.get(JobEvaluationImpl.class,
						primaryKey);

				if (jobEvaluation != null) {
					cacheResult(jobEvaluation);
				}
				else {
					entityCache.putResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						JobEvaluationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					JobEvaluationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobEvaluation;
	}

	/**
	 * Returns the job evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postEvaluationId the primary key of the job evaluation
	 * @return the job evaluation, or <code>null</code> if a job evaluation with the primary key could not be found
	 */
	@Override
	public JobEvaluation fetchByPrimaryKey(long postEvaluationId) {
		return fetchByPrimaryKey((Serializable)postEvaluationId);
	}

	@Override
	public Map<Serializable, JobEvaluation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, JobEvaluation> map = new HashMap<Serializable, JobEvaluation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			JobEvaluation jobEvaluation = fetchByPrimaryKey(primaryKey);

			if (jobEvaluation != null) {
				map.put(primaryKey, jobEvaluation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					JobEvaluationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (JobEvaluation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_JOBEVALUATION_WHERE_PKS_IN);

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

			for (JobEvaluation jobEvaluation : (List<JobEvaluation>)q.list()) {
				map.put(jobEvaluation.getPrimaryKeyObj(), jobEvaluation);

				cacheResult(jobEvaluation);

				uncachedPrimaryKeys.remove(jobEvaluation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(JobEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					JobEvaluationImpl.class, primaryKey, nullModel);
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
	 * Returns all the job evaluations.
	 *
	 * @return the job evaluations
	 */
	@Override
	public List<JobEvaluation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job evaluations
	 * @param end the upper bound of the range of job evaluations (not inclusive)
	 * @return the range of job evaluations
	 */
	@Override
	public List<JobEvaluation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job evaluations
	 * @param end the upper bound of the range of job evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job evaluations
	 */
	@Override
	public List<JobEvaluation> findAll(int start, int end,
		OrderByComparator<JobEvaluation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link JobEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job evaluations
	 * @param end the upper bound of the range of job evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of job evaluations
	 */
	@Override
	public List<JobEvaluation> findAll(int start, int end,
		OrderByComparator<JobEvaluation> orderByComparator,
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

		List<JobEvaluation> list = null;

		if (retrieveFromCache) {
			list = (List<JobEvaluation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JOBEVALUATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBEVALUATION;

				if (pagination) {
					sql = sql.concat(JobEvaluationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobEvaluation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<JobEvaluation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job evaluations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobEvaluation jobEvaluation : findAll()) {
			remove(jobEvaluation);
		}
	}

	/**
	 * Returns the number of job evaluations.
	 *
	 * @return the number of job evaluations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOBEVALUATION);

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
		return JobEvaluationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job evaluation persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(JobEvaluationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_JOBEVALUATION = "SELECT jobEvaluation FROM JobEvaluation jobEvaluation";
	private static final String _SQL_SELECT_JOBEVALUATION_WHERE_PKS_IN = "SELECT jobEvaluation FROM JobEvaluation jobEvaluation WHERE postEvaluationId IN (";
	private static final String _SQL_SELECT_JOBEVALUATION_WHERE = "SELECT jobEvaluation FROM JobEvaluation jobEvaluation WHERE ";
	private static final String _SQL_COUNT_JOBEVALUATION = "SELECT COUNT(jobEvaluation) FROM JobEvaluation jobEvaluation";
	private static final String _SQL_COUNT_JOBEVALUATION_WHERE = "SELECT COUNT(jobEvaluation) FROM JobEvaluation jobEvaluation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobEvaluation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobEvaluation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobEvaluation exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(JobEvaluationPersistenceImpl.class);
}