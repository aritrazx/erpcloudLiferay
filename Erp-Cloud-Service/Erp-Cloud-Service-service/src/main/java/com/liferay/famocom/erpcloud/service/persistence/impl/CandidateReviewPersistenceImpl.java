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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidateReviewException;
import com.liferay.famocom.erpcloud.model.CandidateReview;
import com.liferay.famocom.erpcloud.model.impl.CandidateReviewImpl;
import com.liferay.famocom.erpcloud.model.impl.CandidateReviewModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.CandidateReviewPersistence;

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
 * The persistence implementation for the candidate review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidateReviewPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.CandidateReviewUtil
 * @generated
 */
@ProviderType
public class CandidateReviewPersistenceImpl extends BasePersistenceImpl<CandidateReview>
	implements CandidateReviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateReviewUtil} to access the candidate review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateReviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewModelImpl.FINDER_CACHE_ENABLED,
			CandidateReviewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewModelImpl.FINDER_CACHE_ENABLED,
			CandidateReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEREVIEW =
		new FinderPath(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewModelImpl.FINDER_CACHE_ENABLED,
			CandidateReviewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycandidateReview",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEREVIEW =
		new FinderPath(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewModelImpl.FINDER_CACHE_ENABLED,
			CandidateReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycandidateReview",
			new String[] { Long.class.getName() },
			CandidateReviewModelImpl.RECRUITPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATEREVIEW = new FinderPath(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycandidateReview", new String[] { Long.class.getName() });

	/**
	 * Returns all the candidate reviews where recruitProcessId = &#63;.
	 *
	 * @param recruitProcessId the recruit process ID
	 * @return the matching candidate reviews
	 */
	@Override
	public List<CandidateReview> findBycandidateReview(long recruitProcessId) {
		return findBycandidateReview(recruitProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate reviews where recruitProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param start the lower bound of the range of candidate reviews
	 * @param end the upper bound of the range of candidate reviews (not inclusive)
	 * @return the range of matching candidate reviews
	 */
	@Override
	public List<CandidateReview> findBycandidateReview(long recruitProcessId,
		int start, int end) {
		return findBycandidateReview(recruitProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate reviews where recruitProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param start the lower bound of the range of candidate reviews
	 * @param end the upper bound of the range of candidate reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate reviews
	 */
	@Override
	public List<CandidateReview> findBycandidateReview(long recruitProcessId,
		int start, int end, OrderByComparator<CandidateReview> orderByComparator) {
		return findBycandidateReview(recruitProcessId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate reviews where recruitProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param start the lower bound of the range of candidate reviews
	 * @param end the upper bound of the range of candidate reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching candidate reviews
	 */
	@Override
	public List<CandidateReview> findBycandidateReview(long recruitProcessId,
		int start, int end,
		OrderByComparator<CandidateReview> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEREVIEW;
			finderArgs = new Object[] { recruitProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEREVIEW;
			finderArgs = new Object[] {
					recruitProcessId,
					
					start, end, orderByComparator
				};
		}

		List<CandidateReview> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateReview>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateReview candidateReview : list) {
					if ((recruitProcessId != candidateReview.getRecruitProcessId())) {
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

			query.append(_SQL_SELECT_CANDIDATEREVIEW_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEREVIEW_RECRUITPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateReviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recruitProcessId);

				if (!pagination) {
					list = (List<CandidateReview>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateReview>)QueryUtil.list(q,
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
	 * Returns the first candidate review in the ordered set where recruitProcessId = &#63;.
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate review
	 * @throws NoSuchCandidateReviewException if a matching candidate review could not be found
	 */
	@Override
	public CandidateReview findBycandidateReview_First(long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator)
		throws NoSuchCandidateReviewException {
		CandidateReview candidateReview = fetchBycandidateReview_First(recruitProcessId,
				orderByComparator);

		if (candidateReview != null) {
			return candidateReview;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitProcessId=");
		msg.append(recruitProcessId);

		msg.append("}");

		throw new NoSuchCandidateReviewException(msg.toString());
	}

	/**
	 * Returns the first candidate review in the ordered set where recruitProcessId = &#63;.
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate review, or <code>null</code> if a matching candidate review could not be found
	 */
	@Override
	public CandidateReview fetchBycandidateReview_First(long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator) {
		List<CandidateReview> list = findBycandidateReview(recruitProcessId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate review in the ordered set where recruitProcessId = &#63;.
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate review
	 * @throws NoSuchCandidateReviewException if a matching candidate review could not be found
	 */
	@Override
	public CandidateReview findBycandidateReview_Last(long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator)
		throws NoSuchCandidateReviewException {
		CandidateReview candidateReview = fetchBycandidateReview_Last(recruitProcessId,
				orderByComparator);

		if (candidateReview != null) {
			return candidateReview;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitProcessId=");
		msg.append(recruitProcessId);

		msg.append("}");

		throw new NoSuchCandidateReviewException(msg.toString());
	}

	/**
	 * Returns the last candidate review in the ordered set where recruitProcessId = &#63;.
	 *
	 * @param recruitProcessId the recruit process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate review, or <code>null</code> if a matching candidate review could not be found
	 */
	@Override
	public CandidateReview fetchBycandidateReview_Last(long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator) {
		int count = countBycandidateReview(recruitProcessId);

		if (count == 0) {
			return null;
		}

		List<CandidateReview> list = findBycandidateReview(recruitProcessId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate reviews before and after the current candidate review in the ordered set where recruitProcessId = &#63;.
	 *
	 * @param candidateReviewId the primary key of the current candidate review
	 * @param recruitProcessId the recruit process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate review
	 * @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview[] findBycandidateReview_PrevAndNext(
		long candidateReviewId, long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator)
		throws NoSuchCandidateReviewException {
		CandidateReview candidateReview = findByPrimaryKey(candidateReviewId);

		Session session = null;

		try {
			session = openSession();

			CandidateReview[] array = new CandidateReviewImpl[3];

			array[0] = getBycandidateReview_PrevAndNext(session,
					candidateReview, recruitProcessId, orderByComparator, true);

			array[1] = candidateReview;

			array[2] = getBycandidateReview_PrevAndNext(session,
					candidateReview, recruitProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateReview getBycandidateReview_PrevAndNext(
		Session session, CandidateReview candidateReview,
		long recruitProcessId,
		OrderByComparator<CandidateReview> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEREVIEW_WHERE);

		query.append(_FINDER_COLUMN_CANDIDATEREVIEW_RECRUITPROCESSID_2);

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
			query.append(CandidateReviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recruitProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateReview);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateReview> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate reviews where recruitProcessId = &#63; from the database.
	 *
	 * @param recruitProcessId the recruit process ID
	 */
	@Override
	public void removeBycandidateReview(long recruitProcessId) {
		for (CandidateReview candidateReview : findBycandidateReview(
				recruitProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateReview);
		}
	}

	/**
	 * Returns the number of candidate reviews where recruitProcessId = &#63;.
	 *
	 * @param recruitProcessId the recruit process ID
	 * @return the number of matching candidate reviews
	 */
	@Override
	public int countBycandidateReview(long recruitProcessId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATEREVIEW;

		Object[] finderArgs = new Object[] { recruitProcessId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEREVIEW_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEREVIEW_RECRUITPROCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recruitProcessId);

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

	private static final String _FINDER_COLUMN_CANDIDATEREVIEW_RECRUITPROCESSID_2 =
		"candidateReview.recruitProcessId = ?";

	public CandidateReviewPersistenceImpl() {
		setModelClass(CandidateReview.class);
	}

	/**
	 * Caches the candidate review in the entity cache if it is enabled.
	 *
	 * @param candidateReview the candidate review
	 */
	@Override
	public void cacheResult(CandidateReview candidateReview) {
		entityCache.putResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewImpl.class, candidateReview.getPrimaryKey(),
			candidateReview);

		candidateReview.resetOriginalValues();
	}

	/**
	 * Caches the candidate reviews in the entity cache if it is enabled.
	 *
	 * @param candidateReviews the candidate reviews
	 */
	@Override
	public void cacheResult(List<CandidateReview> candidateReviews) {
		for (CandidateReview candidateReview : candidateReviews) {
			if (entityCache.getResult(
						CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
						CandidateReviewImpl.class,
						candidateReview.getPrimaryKey()) == null) {
				cacheResult(candidateReview);
			}
			else {
				candidateReview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate reviews.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateReviewImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate review.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateReview candidateReview) {
		entityCache.removeResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewImpl.class, candidateReview.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CandidateReview> candidateReviews) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateReview candidateReview : candidateReviews) {
			entityCache.removeResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
				CandidateReviewImpl.class, candidateReview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate review with the primary key. Does not add the candidate review to the database.
	 *
	 * @param candidateReviewId the primary key for the new candidate review
	 * @return the new candidate review
	 */
	@Override
	public CandidateReview create(long candidateReviewId) {
		CandidateReview candidateReview = new CandidateReviewImpl();

		candidateReview.setNew(true);
		candidateReview.setPrimaryKey(candidateReviewId);

		return candidateReview;
	}

	/**
	 * Removes the candidate review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateReviewId the primary key of the candidate review
	 * @return the candidate review that was removed
	 * @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview remove(long candidateReviewId)
		throws NoSuchCandidateReviewException {
		return remove((Serializable)candidateReviewId);
	}

	/**
	 * Removes the candidate review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate review
	 * @return the candidate review that was removed
	 * @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview remove(Serializable primaryKey)
		throws NoSuchCandidateReviewException {
		Session session = null;

		try {
			session = openSession();

			CandidateReview candidateReview = (CandidateReview)session.get(CandidateReviewImpl.class,
					primaryKey);

			if (candidateReview == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateReview);
		}
		catch (NoSuchCandidateReviewException nsee) {
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
	protected CandidateReview removeImpl(CandidateReview candidateReview) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateReview)) {
				candidateReview = (CandidateReview)session.get(CandidateReviewImpl.class,
						candidateReview.getPrimaryKeyObj());
			}

			if (candidateReview != null) {
				session.delete(candidateReview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateReview != null) {
			clearCache(candidateReview);
		}

		return candidateReview;
	}

	@Override
	public CandidateReview updateImpl(CandidateReview candidateReview) {
		boolean isNew = candidateReview.isNew();

		if (!(candidateReview instanceof CandidateReviewModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(candidateReview.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(candidateReview);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in candidateReview proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CandidateReview implementation " +
				candidateReview.getClass());
		}

		CandidateReviewModelImpl candidateReviewModelImpl = (CandidateReviewModelImpl)candidateReview;

		Session session = null;

		try {
			session = openSession();

			if (candidateReview.isNew()) {
				session.save(candidateReview);

				candidateReview.setNew(false);
			}
			else {
				candidateReview = (CandidateReview)session.merge(candidateReview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CandidateReviewModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					candidateReviewModelImpl.getRecruitProcessId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEREVIEW, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEREVIEW,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((candidateReviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEREVIEW.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateReviewModelImpl.getOriginalRecruitProcessId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEREVIEW,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEREVIEW,
					args);

				args = new Object[] {
						candidateReviewModelImpl.getRecruitProcessId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEREVIEW,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEREVIEW,
					args);
			}
		}

		entityCache.putResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
			CandidateReviewImpl.class, candidateReview.getPrimaryKey(),
			candidateReview, false);

		candidateReview.resetOriginalValues();

		return candidateReview;
	}

	/**
	 * Returns the candidate review with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate review
	 * @return the candidate review
	 * @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateReviewException {
		CandidateReview candidateReview = fetchByPrimaryKey(primaryKey);

		if (candidateReview == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateReview;
	}

	/**
	 * Returns the candidate review with the primary key or throws a {@link NoSuchCandidateReviewException} if it could not be found.
	 *
	 * @param candidateReviewId the primary key of the candidate review
	 * @return the candidate review
	 * @throws NoSuchCandidateReviewException if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview findByPrimaryKey(long candidateReviewId)
		throws NoSuchCandidateReviewException {
		return findByPrimaryKey((Serializable)candidateReviewId);
	}

	/**
	 * Returns the candidate review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate review
	 * @return the candidate review, or <code>null</code> if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
				CandidateReviewImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CandidateReview candidateReview = (CandidateReview)serializable;

		if (candidateReview == null) {
			Session session = null;

			try {
				session = openSession();

				candidateReview = (CandidateReview)session.get(CandidateReviewImpl.class,
						primaryKey);

				if (candidateReview != null) {
					cacheResult(candidateReview);
				}
				else {
					entityCache.putResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
						CandidateReviewImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
					CandidateReviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateReview;
	}

	/**
	 * Returns the candidate review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateReviewId the primary key of the candidate review
	 * @return the candidate review, or <code>null</code> if a candidate review with the primary key could not be found
	 */
	@Override
	public CandidateReview fetchByPrimaryKey(long candidateReviewId) {
		return fetchByPrimaryKey((Serializable)candidateReviewId);
	}

	@Override
	public Map<Serializable, CandidateReview> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CandidateReview> map = new HashMap<Serializable, CandidateReview>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CandidateReview candidateReview = fetchByPrimaryKey(primaryKey);

			if (candidateReview != null) {
				map.put(primaryKey, candidateReview);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
					CandidateReviewImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CandidateReview)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANDIDATEREVIEW_WHERE_PKS_IN);

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

			for (CandidateReview candidateReview : (List<CandidateReview>)q.list()) {
				map.put(candidateReview.getPrimaryKeyObj(), candidateReview);

				cacheResult(candidateReview);

				uncachedPrimaryKeys.remove(candidateReview.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CandidateReviewModelImpl.ENTITY_CACHE_ENABLED,
					CandidateReviewImpl.class, primaryKey, nullModel);
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
	 * Returns all the candidate reviews.
	 *
	 * @return the candidate reviews
	 */
	@Override
	public List<CandidateReview> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate reviews
	 * @param end the upper bound of the range of candidate reviews (not inclusive)
	 * @return the range of candidate reviews
	 */
	@Override
	public List<CandidateReview> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate reviews
	 * @param end the upper bound of the range of candidate reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate reviews
	 */
	@Override
	public List<CandidateReview> findAll(int start, int end,
		OrderByComparator<CandidateReview> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate reviews
	 * @param end the upper bound of the range of candidate reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of candidate reviews
	 */
	@Override
	public List<CandidateReview> findAll(int start, int end,
		OrderByComparator<CandidateReview> orderByComparator,
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

		List<CandidateReview> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateReview>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANDIDATEREVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEREVIEW;

				if (pagination) {
					sql = sql.concat(CandidateReviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateReview>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateReview>)QueryUtil.list(q,
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
	 * Removes all the candidate reviews from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateReview candidateReview : findAll()) {
			remove(candidateReview);
		}
	}

	/**
	 * Returns the number of candidate reviews.
	 *
	 * @return the number of candidate reviews
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEREVIEW);

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
		return CandidateReviewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate review persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CandidateReviewImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANDIDATEREVIEW = "SELECT candidateReview FROM CandidateReview candidateReview";
	private static final String _SQL_SELECT_CANDIDATEREVIEW_WHERE_PKS_IN = "SELECT candidateReview FROM CandidateReview candidateReview WHERE candidateReviewId IN (";
	private static final String _SQL_SELECT_CANDIDATEREVIEW_WHERE = "SELECT candidateReview FROM CandidateReview candidateReview WHERE ";
	private static final String _SQL_COUNT_CANDIDATEREVIEW = "SELECT COUNT(candidateReview) FROM CandidateReview candidateReview";
	private static final String _SQL_COUNT_CANDIDATEREVIEW_WHERE = "SELECT COUNT(candidateReview) FROM CandidateReview candidateReview WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateReview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateReview exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CandidateReview exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CandidateReviewPersistenceImpl.class);
}