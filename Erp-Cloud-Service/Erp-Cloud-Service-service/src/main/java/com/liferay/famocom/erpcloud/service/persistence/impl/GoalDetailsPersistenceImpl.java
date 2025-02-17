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

import com.liferay.famocom.erpcloud.exception.NoSuchGoalDetailsException;
import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.model.impl.GoalDetailsImpl;
import com.liferay.famocom.erpcloud.model.impl.GoalDetailsModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.GoalDetailsPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
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
 * The persistence implementation for the goal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see GoalDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.GoalDetailsUtil
 * @generated
 */
@ProviderType
public class GoalDetailsPersistenceImpl extends BasePersistenceImpl<GoalDetails>
	implements GoalDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GoalDetailsUtil} to access the goal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GoalDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsModelImpl.FINDER_CACHE_ENABLED, GoalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsModelImpl.FINDER_CACHE_ENABLED, GoalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GOALID = new FinderPath(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsModelImpl.FINDER_CACHE_ENABLED, GoalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGoalId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GOALID =
		new FinderPath(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsModelImpl.FINDER_CACHE_ENABLED, GoalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGoalId",
			new String[] { Long.class.getName() },
			GoalDetailsModelImpl.GOALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GOALID = new FinderPath(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGoalId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the goal detailses where goalId = &#63;.
	 *
	 * @param goalId the goal ID
	 * @return the matching goal detailses
	 */
	@Override
	public List<GoalDetails> findByGoalId(long goalId) {
		return findByGoalId(goalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the goal detailses where goalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param goalId the goal ID
	 * @param start the lower bound of the range of goal detailses
	 * @param end the upper bound of the range of goal detailses (not inclusive)
	 * @return the range of matching goal detailses
	 */
	@Override
	public List<GoalDetails> findByGoalId(long goalId, int start, int end) {
		return findByGoalId(goalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the goal detailses where goalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param goalId the goal ID
	 * @param start the lower bound of the range of goal detailses
	 * @param end the upper bound of the range of goal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching goal detailses
	 */
	@Override
	public List<GoalDetails> findByGoalId(long goalId, int start, int end,
		OrderByComparator<GoalDetails> orderByComparator) {
		return findByGoalId(goalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the goal detailses where goalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param goalId the goal ID
	 * @param start the lower bound of the range of goal detailses
	 * @param end the upper bound of the range of goal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching goal detailses
	 */
	@Override
	public List<GoalDetails> findByGoalId(long goalId, int start, int end,
		OrderByComparator<GoalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GOALID;
			finderArgs = new Object[] { goalId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GOALID;
			finderArgs = new Object[] { goalId, start, end, orderByComparator };
		}

		List<GoalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<GoalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GoalDetails goalDetails : list) {
					if ((goalId != goalDetails.getGoalId())) {
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

			query.append(_SQL_SELECT_GOALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_GOALID_GOALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GoalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(goalId);

				if (!pagination) {
					list = (List<GoalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GoalDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first goal details in the ordered set where goalId = &#63;.
	 *
	 * @param goalId the goal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching goal details
	 * @throws NoSuchGoalDetailsException if a matching goal details could not be found
	 */
	@Override
	public GoalDetails findByGoalId_First(long goalId,
		OrderByComparator<GoalDetails> orderByComparator)
		throws NoSuchGoalDetailsException {
		GoalDetails goalDetails = fetchByGoalId_First(goalId, orderByComparator);

		if (goalDetails != null) {
			return goalDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("goalId=");
		msg.append(goalId);

		msg.append("}");

		throw new NoSuchGoalDetailsException(msg.toString());
	}

	/**
	 * Returns the first goal details in the ordered set where goalId = &#63;.
	 *
	 * @param goalId the goal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching goal details, or <code>null</code> if a matching goal details could not be found
	 */
	@Override
	public GoalDetails fetchByGoalId_First(long goalId,
		OrderByComparator<GoalDetails> orderByComparator) {
		List<GoalDetails> list = findByGoalId(goalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last goal details in the ordered set where goalId = &#63;.
	 *
	 * @param goalId the goal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching goal details
	 * @throws NoSuchGoalDetailsException if a matching goal details could not be found
	 */
	@Override
	public GoalDetails findByGoalId_Last(long goalId,
		OrderByComparator<GoalDetails> orderByComparator)
		throws NoSuchGoalDetailsException {
		GoalDetails goalDetails = fetchByGoalId_Last(goalId, orderByComparator);

		if (goalDetails != null) {
			return goalDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("goalId=");
		msg.append(goalId);

		msg.append("}");

		throw new NoSuchGoalDetailsException(msg.toString());
	}

	/**
	 * Returns the last goal details in the ordered set where goalId = &#63;.
	 *
	 * @param goalId the goal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching goal details, or <code>null</code> if a matching goal details could not be found
	 */
	@Override
	public GoalDetails fetchByGoalId_Last(long goalId,
		OrderByComparator<GoalDetails> orderByComparator) {
		int count = countByGoalId(goalId);

		if (count == 0) {
			return null;
		}

		List<GoalDetails> list = findByGoalId(goalId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the goal detailses before and after the current goal details in the ordered set where goalId = &#63;.
	 *
	 * @param goaldetailId the primary key of the current goal details
	 * @param goalId the goal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next goal details
	 * @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails[] findByGoalId_PrevAndNext(long goaldetailId,
		long goalId, OrderByComparator<GoalDetails> orderByComparator)
		throws NoSuchGoalDetailsException {
		GoalDetails goalDetails = findByPrimaryKey(goaldetailId);

		Session session = null;

		try {
			session = openSession();

			GoalDetails[] array = new GoalDetailsImpl[3];

			array[0] = getByGoalId_PrevAndNext(session, goalDetails, goalId,
					orderByComparator, true);

			array[1] = goalDetails;

			array[2] = getByGoalId_PrevAndNext(session, goalDetails, goalId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GoalDetails getByGoalId_PrevAndNext(Session session,
		GoalDetails goalDetails, long goalId,
		OrderByComparator<GoalDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GOALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_GOALID_GOALID_2);

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
			query.append(GoalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(goalId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(goalDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GoalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the goal detailses where goalId = &#63; from the database.
	 *
	 * @param goalId the goal ID
	 */
	@Override
	public void removeByGoalId(long goalId) {
		for (GoalDetails goalDetails : findByGoalId(goalId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(goalDetails);
		}
	}

	/**
	 * Returns the number of goal detailses where goalId = &#63;.
	 *
	 * @param goalId the goal ID
	 * @return the number of matching goal detailses
	 */
	@Override
	public int countByGoalId(long goalId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GOALID;

		Object[] finderArgs = new Object[] { goalId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GOALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_GOALID_GOALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(goalId);

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

	private static final String _FINDER_COLUMN_GOALID_GOALID_2 = "goalDetails.goalId = ?";

	public GoalDetailsPersistenceImpl() {
		setModelClass(GoalDetails.class);
	}

	/**
	 * Caches the goal details in the entity cache if it is enabled.
	 *
	 * @param goalDetails the goal details
	 */
	@Override
	public void cacheResult(GoalDetails goalDetails) {
		entityCache.putResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsImpl.class, goalDetails.getPrimaryKey(), goalDetails);

		goalDetails.resetOriginalValues();
	}

	/**
	 * Caches the goal detailses in the entity cache if it is enabled.
	 *
	 * @param goalDetailses the goal detailses
	 */
	@Override
	public void cacheResult(List<GoalDetails> goalDetailses) {
		for (GoalDetails goalDetails : goalDetailses) {
			if (entityCache.getResult(
						GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						GoalDetailsImpl.class, goalDetails.getPrimaryKey()) == null) {
				cacheResult(goalDetails);
			}
			else {
				goalDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all goal detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GoalDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the goal details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GoalDetails goalDetails) {
		entityCache.removeResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsImpl.class, goalDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GoalDetails> goalDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GoalDetails goalDetails : goalDetailses) {
			entityCache.removeResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				GoalDetailsImpl.class, goalDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new goal details with the primary key. Does not add the goal details to the database.
	 *
	 * @param goaldetailId the primary key for the new goal details
	 * @return the new goal details
	 */
	@Override
	public GoalDetails create(long goaldetailId) {
		GoalDetails goalDetails = new GoalDetailsImpl();

		goalDetails.setNew(true);
		goalDetails.setPrimaryKey(goaldetailId);

		goalDetails.setCompanyId(companyProvider.getCompanyId());

		return goalDetails;
	}

	/**
	 * Removes the goal details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param goaldetailId the primary key of the goal details
	 * @return the goal details that was removed
	 * @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails remove(long goaldetailId)
		throws NoSuchGoalDetailsException {
		return remove((Serializable)goaldetailId);
	}

	/**
	 * Removes the goal details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the goal details
	 * @return the goal details that was removed
	 * @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails remove(Serializable primaryKey)
		throws NoSuchGoalDetailsException {
		Session session = null;

		try {
			session = openSession();

			GoalDetails goalDetails = (GoalDetails)session.get(GoalDetailsImpl.class,
					primaryKey);

			if (goalDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGoalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(goalDetails);
		}
		catch (NoSuchGoalDetailsException nsee) {
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
	protected GoalDetails removeImpl(GoalDetails goalDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(goalDetails)) {
				goalDetails = (GoalDetails)session.get(GoalDetailsImpl.class,
						goalDetails.getPrimaryKeyObj());
			}

			if (goalDetails != null) {
				session.delete(goalDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (goalDetails != null) {
			clearCache(goalDetails);
		}

		return goalDetails;
	}

	@Override
	public GoalDetails updateImpl(GoalDetails goalDetails) {
		boolean isNew = goalDetails.isNew();

		if (!(goalDetails instanceof GoalDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(goalDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(goalDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in goalDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GoalDetails implementation " +
				goalDetails.getClass());
		}

		GoalDetailsModelImpl goalDetailsModelImpl = (GoalDetailsModelImpl)goalDetails;

		Session session = null;

		try {
			session = openSession();

			if (goalDetails.isNew()) {
				session.save(goalDetails);

				goalDetails.setNew(false);
			}
			else {
				goalDetails = (GoalDetails)session.merge(goalDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!GoalDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { goalDetailsModelImpl.getGoalId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GOALID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GOALID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((goalDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GOALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						goalDetailsModelImpl.getOriginalGoalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GOALID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GOALID,
					args);

				args = new Object[] { goalDetailsModelImpl.getGoalId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GOALID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GOALID,
					args);
			}
		}

		entityCache.putResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			GoalDetailsImpl.class, goalDetails.getPrimaryKey(), goalDetails,
			false);

		goalDetails.resetOriginalValues();

		return goalDetails;
	}

	/**
	 * Returns the goal details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the goal details
	 * @return the goal details
	 * @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGoalDetailsException {
		GoalDetails goalDetails = fetchByPrimaryKey(primaryKey);

		if (goalDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGoalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return goalDetails;
	}

	/**
	 * Returns the goal details with the primary key or throws a {@link NoSuchGoalDetailsException} if it could not be found.
	 *
	 * @param goaldetailId the primary key of the goal details
	 * @return the goal details
	 * @throws NoSuchGoalDetailsException if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails findByPrimaryKey(long goaldetailId)
		throws NoSuchGoalDetailsException {
		return findByPrimaryKey((Serializable)goaldetailId);
	}

	/**
	 * Returns the goal details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the goal details
	 * @return the goal details, or <code>null</code> if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				GoalDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		GoalDetails goalDetails = (GoalDetails)serializable;

		if (goalDetails == null) {
			Session session = null;

			try {
				session = openSession();

				goalDetails = (GoalDetails)session.get(GoalDetailsImpl.class,
						primaryKey);

				if (goalDetails != null) {
					cacheResult(goalDetails);
				}
				else {
					entityCache.putResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						GoalDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					GoalDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return goalDetails;
	}

	/**
	 * Returns the goal details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param goaldetailId the primary key of the goal details
	 * @return the goal details, or <code>null</code> if a goal details with the primary key could not be found
	 */
	@Override
	public GoalDetails fetchByPrimaryKey(long goaldetailId) {
		return fetchByPrimaryKey((Serializable)goaldetailId);
	}

	@Override
	public Map<Serializable, GoalDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GoalDetails> map = new HashMap<Serializable, GoalDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GoalDetails goalDetails = fetchByPrimaryKey(primaryKey);

			if (goalDetails != null) {
				map.put(primaryKey, goalDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					GoalDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (GoalDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GOALDETAILS_WHERE_PKS_IN);

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

			for (GoalDetails goalDetails : (List<GoalDetails>)q.list()) {
				map.put(goalDetails.getPrimaryKeyObj(), goalDetails);

				cacheResult(goalDetails);

				uncachedPrimaryKeys.remove(goalDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					GoalDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the goal detailses.
	 *
	 * @return the goal detailses
	 */
	@Override
	public List<GoalDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the goal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of goal detailses
	 * @param end the upper bound of the range of goal detailses (not inclusive)
	 * @return the range of goal detailses
	 */
	@Override
	public List<GoalDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the goal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of goal detailses
	 * @param end the upper bound of the range of goal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of goal detailses
	 */
	@Override
	public List<GoalDetails> findAll(int start, int end,
		OrderByComparator<GoalDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the goal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of goal detailses
	 * @param end the upper bound of the range of goal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of goal detailses
	 */
	@Override
	public List<GoalDetails> findAll(int start, int end,
		OrderByComparator<GoalDetails> orderByComparator,
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

		List<GoalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<GoalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GOALDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GOALDETAILS;

				if (pagination) {
					sql = sql.concat(GoalDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GoalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GoalDetails>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the goal detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GoalDetails goalDetails : findAll()) {
			remove(goalDetails);
		}
	}

	/**
	 * Returns the number of goal detailses.
	 *
	 * @return the number of goal detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GOALDETAILS);

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
		return GoalDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the goal details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GoalDetailsImpl.class.getName());
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
	private static final String _SQL_SELECT_GOALDETAILS = "SELECT goalDetails FROM GoalDetails goalDetails";
	private static final String _SQL_SELECT_GOALDETAILS_WHERE_PKS_IN = "SELECT goalDetails FROM GoalDetails goalDetails WHERE goaldetailId IN (";
	private static final String _SQL_SELECT_GOALDETAILS_WHERE = "SELECT goalDetails FROM GoalDetails goalDetails WHERE ";
	private static final String _SQL_COUNT_GOALDETAILS = "SELECT COUNT(goalDetails) FROM GoalDetails goalDetails";
	private static final String _SQL_COUNT_GOALDETAILS_WHERE = "SELECT COUNT(goalDetails) FROM GoalDetails goalDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "goalDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GoalDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GoalDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GoalDetailsPersistenceImpl.class);
}