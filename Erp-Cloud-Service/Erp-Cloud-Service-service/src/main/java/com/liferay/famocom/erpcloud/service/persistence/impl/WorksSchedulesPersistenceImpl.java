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

import com.liferay.famocom.erpcloud.exception.NoSuchWorksSchedulesException;
import com.liferay.famocom.erpcloud.model.WorksSchedules;
import com.liferay.famocom.erpcloud.model.impl.WorksSchedulesImpl;
import com.liferay.famocom.erpcloud.model.impl.WorksSchedulesModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.WorksSchedulesPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the works schedules service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see WorksSchedulesPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.WorksSchedulesUtil
 * @generated
 */
@ProviderType
public class WorksSchedulesPersistenceImpl extends BasePersistenceImpl<WorksSchedules>
	implements WorksSchedulesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorksSchedulesUtil} to access the works schedules persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorksSchedulesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDULESID =
		new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByschedulesId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULESID =
		new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByschedulesId",
			new String[] { Long.class.getName() },
			WorksSchedulesModelImpl.SCHEDULESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCHEDULESID = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByschedulesId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the works scheduleses where schedulesId = &#63;.
	 *
	 * @param schedulesId the schedules ID
	 * @return the matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByschedulesId(long schedulesId) {
		return findByschedulesId(schedulesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the works scheduleses where schedulesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param schedulesId the schedules ID
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @return the range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByschedulesId(long schedulesId, int start,
		int end) {
		return findByschedulesId(schedulesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the works scheduleses where schedulesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param schedulesId the schedules ID
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByschedulesId(long schedulesId, int start,
		int end, OrderByComparator<WorksSchedules> orderByComparator) {
		return findByschedulesId(schedulesId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the works scheduleses where schedulesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param schedulesId the schedules ID
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByschedulesId(long schedulesId, int start,
		int end, OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULESID;
			finderArgs = new Object[] { schedulesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDULESID;
			finderArgs = new Object[] { schedulesId, start, end, orderByComparator };
		}

		List<WorksSchedules> list = null;

		if (retrieveFromCache) {
			list = (List<WorksSchedules>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorksSchedules worksSchedules : list) {
					if ((schedulesId != worksSchedules.getSchedulesId())) {
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

			query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE);

			query.append(_FINDER_COLUMN_SCHEDULESID_SCHEDULESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorksSchedulesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(schedulesId);

				if (!pagination) {
					list = (List<WorksSchedules>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorksSchedules>)QueryUtil.list(q,
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
	 * Returns the first works schedules in the ordered set where schedulesId = &#63;.
	 *
	 * @param schedulesId the schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching works schedules
	 * @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules findByschedulesId_First(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchByschedulesId_First(schedulesId,
				orderByComparator);

		if (worksSchedules != null) {
			return worksSchedules;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("schedulesId=");
		msg.append(schedulesId);

		msg.append("}");

		throw new NoSuchWorksSchedulesException(msg.toString());
	}

	/**
	 * Returns the first works schedules in the ordered set where schedulesId = &#63;.
	 *
	 * @param schedulesId the schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules fetchByschedulesId_First(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator) {
		List<WorksSchedules> list = findByschedulesId(schedulesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last works schedules in the ordered set where schedulesId = &#63;.
	 *
	 * @param schedulesId the schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching works schedules
	 * @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules findByschedulesId_Last(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchByschedulesId_Last(schedulesId,
				orderByComparator);

		if (worksSchedules != null) {
			return worksSchedules;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("schedulesId=");
		msg.append(schedulesId);

		msg.append("}");

		throw new NoSuchWorksSchedulesException(msg.toString());
	}

	/**
	 * Returns the last works schedules in the ordered set where schedulesId = &#63;.
	 *
	 * @param schedulesId the schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules fetchByschedulesId_Last(long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator) {
		int count = countByschedulesId(schedulesId);

		if (count == 0) {
			return null;
		}

		List<WorksSchedules> list = findByschedulesId(schedulesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the works scheduleses before and after the current works schedules in the ordered set where schedulesId = &#63;.
	 *
	 * @param worksSchedulesId the primary key of the current works schedules
	 * @param schedulesId the schedules ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next works schedules
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules[] findByschedulesId_PrevAndNext(
		long worksSchedulesId, long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = findByPrimaryKey(worksSchedulesId);

		Session session = null;

		try {
			session = openSession();

			WorksSchedules[] array = new WorksSchedulesImpl[3];

			array[0] = getByschedulesId_PrevAndNext(session, worksSchedules,
					schedulesId, orderByComparator, true);

			array[1] = worksSchedules;

			array[2] = getByschedulesId_PrevAndNext(session, worksSchedules,
					schedulesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorksSchedules getByschedulesId_PrevAndNext(Session session,
		WorksSchedules worksSchedules, long schedulesId,
		OrderByComparator<WorksSchedules> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE);

		query.append(_FINDER_COLUMN_SCHEDULESID_SCHEDULESID_2);

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
			query.append(WorksSchedulesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(schedulesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(worksSchedules);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorksSchedules> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the works scheduleses where schedulesId = &#63; from the database.
	 *
	 * @param schedulesId the schedules ID
	 */
	@Override
	public void removeByschedulesId(long schedulesId) {
		for (WorksSchedules worksSchedules : findByschedulesId(schedulesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(worksSchedules);
		}
	}

	/**
	 * Returns the number of works scheduleses where schedulesId = &#63;.
	 *
	 * @param schedulesId the schedules ID
	 * @return the number of matching works scheduleses
	 */
	@Override
	public int countByschedulesId(long schedulesId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCHEDULESID;

		Object[] finderArgs = new Object[] { schedulesId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKSSCHEDULES_WHERE);

			query.append(_FINDER_COLUMN_SCHEDULESID_SCHEDULESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(schedulesId);

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

	private static final String _FINDER_COLUMN_SCHEDULESID_SCHEDULESID_2 = "worksSchedules.schedulesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FROMTODATE =
		new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByfromToDate",
			new String[] {
				Date.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMTODATE =
		new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfromToDate",
			new String[] { Date.class.getName(), Date.class.getName() },
			WorksSchedulesModelImpl.FROMDATE_COLUMN_BITMASK |
			WorksSchedulesModelImpl.TODATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FROMTODATE = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfromToDate",
			new String[] { Date.class.getName(), Date.class.getName() });

	/**
	 * Returns all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByfromToDate(Date fromDate, Date toDate) {
		return findByfromToDate(fromDate, toDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @return the range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByfromToDate(Date fromDate, Date toDate,
		int start, int end) {
		return findByfromToDate(fromDate, toDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByfromToDate(Date fromDate, Date toDate,
		int start, int end, OrderByComparator<WorksSchedules> orderByComparator) {
		return findByfromToDate(fromDate, toDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the works scheduleses where fromDate = &#63; and toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findByfromToDate(Date fromDate, Date toDate,
		int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMTODATE;
			finderArgs = new Object[] { _getTime(fromDate), _getTime(toDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FROMTODATE;
			finderArgs = new Object[] {
					_getTime(fromDate), _getTime(toDate),
					
					start, end, orderByComparator
				};
		}

		List<WorksSchedules> list = null;

		if (retrieveFromCache) {
			list = (List<WorksSchedules>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorksSchedules worksSchedules : list) {
					if (!Objects.equals(fromDate, worksSchedules.getFromDate()) ||
							!Objects.equals(toDate, worksSchedules.getToDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE);

			boolean bindFromDate = false;

			if (fromDate == null) {
				query.append(_FINDER_COLUMN_FROMTODATE_FROMDATE_1);
			}
			else {
				bindFromDate = true;

				query.append(_FINDER_COLUMN_FROMTODATE_FROMDATE_2);
			}

			boolean bindToDate = false;

			if (toDate == null) {
				query.append(_FINDER_COLUMN_FROMTODATE_TODATE_1);
			}
			else {
				bindToDate = true;

				query.append(_FINDER_COLUMN_FROMTODATE_TODATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorksSchedulesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFromDate) {
					qPos.add(new Timestamp(fromDate.getTime()));
				}

				if (bindToDate) {
					qPos.add(new Timestamp(toDate.getTime()));
				}

				if (!pagination) {
					list = (List<WorksSchedules>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorksSchedules>)QueryUtil.list(q,
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
	 * Returns the first works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching works schedules
	 * @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules findByfromToDate_First(Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchByfromToDate_First(fromDate,
				toDate, orderByComparator);

		if (worksSchedules != null) {
			return worksSchedules;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fromDate=");
		msg.append(fromDate);

		msg.append(", toDate=");
		msg.append(toDate);

		msg.append("}");

		throw new NoSuchWorksSchedulesException(msg.toString());
	}

	/**
	 * Returns the first works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules fetchByfromToDate_First(Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator) {
		List<WorksSchedules> list = findByfromToDate(fromDate, toDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching works schedules
	 * @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules findByfromToDate_Last(Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchByfromToDate_Last(fromDate,
				toDate, orderByComparator);

		if (worksSchedules != null) {
			return worksSchedules;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fromDate=");
		msg.append(fromDate);

		msg.append(", toDate=");
		msg.append(toDate);

		msg.append("}");

		throw new NoSuchWorksSchedulesException(msg.toString());
	}

	/**
	 * Returns the last works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules fetchByfromToDate_Last(Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator) {
		int count = countByfromToDate(fromDate, toDate);

		if (count == 0) {
			return null;
		}

		List<WorksSchedules> list = findByfromToDate(fromDate, toDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the works scheduleses before and after the current works schedules in the ordered set where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param worksSchedulesId the primary key of the current works schedules
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next works schedules
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules[] findByfromToDate_PrevAndNext(
		long worksSchedulesId, Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = findByPrimaryKey(worksSchedulesId);

		Session session = null;

		try {
			session = openSession();

			WorksSchedules[] array = new WorksSchedulesImpl[3];

			array[0] = getByfromToDate_PrevAndNext(session, worksSchedules,
					fromDate, toDate, orderByComparator, true);

			array[1] = worksSchedules;

			array[2] = getByfromToDate_PrevAndNext(session, worksSchedules,
					fromDate, toDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorksSchedules getByfromToDate_PrevAndNext(Session session,
		WorksSchedules worksSchedules, Date fromDate, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE);

		boolean bindFromDate = false;

		if (fromDate == null) {
			query.append(_FINDER_COLUMN_FROMTODATE_FROMDATE_1);
		}
		else {
			bindFromDate = true;

			query.append(_FINDER_COLUMN_FROMTODATE_FROMDATE_2);
		}

		boolean bindToDate = false;

		if (toDate == null) {
			query.append(_FINDER_COLUMN_FROMTODATE_TODATE_1);
		}
		else {
			bindToDate = true;

			query.append(_FINDER_COLUMN_FROMTODATE_TODATE_2);
		}

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
			query.append(WorksSchedulesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFromDate) {
			qPos.add(new Timestamp(fromDate.getTime()));
		}

		if (bindToDate) {
			qPos.add(new Timestamp(toDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(worksSchedules);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorksSchedules> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the works scheduleses where fromDate = &#63; and toDate = &#63; from the database.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 */
	@Override
	public void removeByfromToDate(Date fromDate, Date toDate) {
		for (WorksSchedules worksSchedules : findByfromToDate(fromDate, toDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(worksSchedules);
		}
	}

	/**
	 * Returns the number of works scheduleses where fromDate = &#63; and toDate = &#63;.
	 *
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the number of matching works scheduleses
	 */
	@Override
	public int countByfromToDate(Date fromDate, Date toDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FROMTODATE;

		Object[] finderArgs = new Object[] { _getTime(fromDate), _getTime(toDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WORKSSCHEDULES_WHERE);

			boolean bindFromDate = false;

			if (fromDate == null) {
				query.append(_FINDER_COLUMN_FROMTODATE_FROMDATE_1);
			}
			else {
				bindFromDate = true;

				query.append(_FINDER_COLUMN_FROMTODATE_FROMDATE_2);
			}

			boolean bindToDate = false;

			if (toDate == null) {
				query.append(_FINDER_COLUMN_FROMTODATE_TODATE_1);
			}
			else {
				bindToDate = true;

				query.append(_FINDER_COLUMN_FROMTODATE_TODATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFromDate) {
					qPos.add(new Timestamp(fromDate.getTime()));
				}

				if (bindToDate) {
					qPos.add(new Timestamp(toDate.getTime()));
				}

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

	private static final String _FINDER_COLUMN_FROMTODATE_FROMDATE_1 = "worksSchedules.fromDate IS NULL AND ";
	private static final String _FINDER_COLUMN_FROMTODATE_FROMDATE_2 = "worksSchedules.fromDate = ? AND ";
	private static final String _FINDER_COLUMN_FROMTODATE_TODATE_1 = "worksSchedules.toDate IS NULL";
	private static final String _FINDER_COLUMN_FROMTODATE_TODATE_2 = "worksSchedules.toDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TODATE = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytoDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TODATE =
		new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED,
			WorksSchedulesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytoDate",
			new String[] { Date.class.getName() },
			WorksSchedulesModelImpl.TODATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TODATE = new FinderPath(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytoDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the works scheduleses where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findBytoDate(Date toDate) {
		return findBytoDate(toDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the works scheduleses where toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param toDate the to date
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @return the range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findBytoDate(Date toDate, int start, int end) {
		return findBytoDate(toDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the works scheduleses where toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param toDate the to date
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findBytoDate(Date toDate, int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return findBytoDate(toDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the works scheduleses where toDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param toDate the to date
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching works scheduleses
	 */
	@Override
	public List<WorksSchedules> findBytoDate(Date toDate, int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TODATE;
			finderArgs = new Object[] { _getTime(toDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TODATE;
			finderArgs = new Object[] {
					_getTime(toDate),
					
					start, end, orderByComparator
				};
		}

		List<WorksSchedules> list = null;

		if (retrieveFromCache) {
			list = (List<WorksSchedules>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorksSchedules worksSchedules : list) {
					if (!Objects.equals(toDate, worksSchedules.getToDate())) {
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

			query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE);

			boolean bindToDate = false;

			if (toDate == null) {
				query.append(_FINDER_COLUMN_TODATE_TODATE_1);
			}
			else {
				bindToDate = true;

				query.append(_FINDER_COLUMN_TODATE_TODATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorksSchedulesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToDate) {
					qPos.add(new Timestamp(toDate.getTime()));
				}

				if (!pagination) {
					list = (List<WorksSchedules>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorksSchedules>)QueryUtil.list(q,
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
	 * Returns the first works schedules in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching works schedules
	 * @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules findBytoDate_First(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchBytoDate_First(toDate,
				orderByComparator);

		if (worksSchedules != null) {
			return worksSchedules;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("toDate=");
		msg.append(toDate);

		msg.append("}");

		throw new NoSuchWorksSchedulesException(msg.toString());
	}

	/**
	 * Returns the first works schedules in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching works schedules, or <code>null</code> if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules fetchBytoDate_First(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator) {
		List<WorksSchedules> list = findBytoDate(toDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last works schedules in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching works schedules
	 * @throws NoSuchWorksSchedulesException if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules findBytoDate_Last(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchBytoDate_Last(toDate,
				orderByComparator);

		if (worksSchedules != null) {
			return worksSchedules;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("toDate=");
		msg.append(toDate);

		msg.append("}");

		throw new NoSuchWorksSchedulesException(msg.toString());
	}

	/**
	 * Returns the last works schedules in the ordered set where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching works schedules, or <code>null</code> if a matching works schedules could not be found
	 */
	@Override
	public WorksSchedules fetchBytoDate_Last(Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator) {
		int count = countBytoDate(toDate);

		if (count == 0) {
			return null;
		}

		List<WorksSchedules> list = findBytoDate(toDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the works scheduleses before and after the current works schedules in the ordered set where toDate = &#63;.
	 *
	 * @param worksSchedulesId the primary key of the current works schedules
	 * @param toDate the to date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next works schedules
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules[] findBytoDate_PrevAndNext(long worksSchedulesId,
		Date toDate, OrderByComparator<WorksSchedules> orderByComparator)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = findByPrimaryKey(worksSchedulesId);

		Session session = null;

		try {
			session = openSession();

			WorksSchedules[] array = new WorksSchedulesImpl[3];

			array[0] = getBytoDate_PrevAndNext(session, worksSchedules, toDate,
					orderByComparator, true);

			array[1] = worksSchedules;

			array[2] = getBytoDate_PrevAndNext(session, worksSchedules, toDate,
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

	protected WorksSchedules getBytoDate_PrevAndNext(Session session,
		WorksSchedules worksSchedules, Date toDate,
		OrderByComparator<WorksSchedules> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE);

		boolean bindToDate = false;

		if (toDate == null) {
			query.append(_FINDER_COLUMN_TODATE_TODATE_1);
		}
		else {
			bindToDate = true;

			query.append(_FINDER_COLUMN_TODATE_TODATE_2);
		}

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
			query.append(WorksSchedulesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindToDate) {
			qPos.add(new Timestamp(toDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(worksSchedules);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorksSchedules> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the works scheduleses where toDate = &#63; from the database.
	 *
	 * @param toDate the to date
	 */
	@Override
	public void removeBytoDate(Date toDate) {
		for (WorksSchedules worksSchedules : findBytoDate(toDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(worksSchedules);
		}
	}

	/**
	 * Returns the number of works scheduleses where toDate = &#63;.
	 *
	 * @param toDate the to date
	 * @return the number of matching works scheduleses
	 */
	@Override
	public int countBytoDate(Date toDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TODATE;

		Object[] finderArgs = new Object[] { _getTime(toDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKSSCHEDULES_WHERE);

			boolean bindToDate = false;

			if (toDate == null) {
				query.append(_FINDER_COLUMN_TODATE_TODATE_1);
			}
			else {
				bindToDate = true;

				query.append(_FINDER_COLUMN_TODATE_TODATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToDate) {
					qPos.add(new Timestamp(toDate.getTime()));
				}

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

	private static final String _FINDER_COLUMN_TODATE_TODATE_1 = "worksSchedules.toDate IS NULL";
	private static final String _FINDER_COLUMN_TODATE_TODATE_2 = "worksSchedules.toDate = ?";

	public WorksSchedulesPersistenceImpl() {
		setModelClass(WorksSchedules.class);
	}

	/**
	 * Caches the works schedules in the entity cache if it is enabled.
	 *
	 * @param worksSchedules the works schedules
	 */
	@Override
	public void cacheResult(WorksSchedules worksSchedules) {
		entityCache.putResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesImpl.class, worksSchedules.getPrimaryKey(),
			worksSchedules);

		worksSchedules.resetOriginalValues();
	}

	/**
	 * Caches the works scheduleses in the entity cache if it is enabled.
	 *
	 * @param worksScheduleses the works scheduleses
	 */
	@Override
	public void cacheResult(List<WorksSchedules> worksScheduleses) {
		for (WorksSchedules worksSchedules : worksScheduleses) {
			if (entityCache.getResult(
						WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
						WorksSchedulesImpl.class, worksSchedules.getPrimaryKey()) == null) {
				cacheResult(worksSchedules);
			}
			else {
				worksSchedules.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all works scheduleses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorksSchedulesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the works schedules.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorksSchedules worksSchedules) {
		entityCache.removeResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesImpl.class, worksSchedules.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorksSchedules> worksScheduleses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorksSchedules worksSchedules : worksScheduleses) {
			entityCache.removeResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
				WorksSchedulesImpl.class, worksSchedules.getPrimaryKey());
		}
	}

	/**
	 * Creates a new works schedules with the primary key. Does not add the works schedules to the database.
	 *
	 * @param worksSchedulesId the primary key for the new works schedules
	 * @return the new works schedules
	 */
	@Override
	public WorksSchedules create(long worksSchedulesId) {
		WorksSchedules worksSchedules = new WorksSchedulesImpl();

		worksSchedules.setNew(true);
		worksSchedules.setPrimaryKey(worksSchedulesId);

		worksSchedules.setCompanyId(companyProvider.getCompanyId());

		return worksSchedules;
	}

	/**
	 * Removes the works schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param worksSchedulesId the primary key of the works schedules
	 * @return the works schedules that was removed
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules remove(long worksSchedulesId)
		throws NoSuchWorksSchedulesException {
		return remove((Serializable)worksSchedulesId);
	}

	/**
	 * Removes the works schedules with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the works schedules
	 * @return the works schedules that was removed
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules remove(Serializable primaryKey)
		throws NoSuchWorksSchedulesException {
		Session session = null;

		try {
			session = openSession();

			WorksSchedules worksSchedules = (WorksSchedules)session.get(WorksSchedulesImpl.class,
					primaryKey);

			if (worksSchedules == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorksSchedulesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(worksSchedules);
		}
		catch (NoSuchWorksSchedulesException nsee) {
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
	protected WorksSchedules removeImpl(WorksSchedules worksSchedules) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(worksSchedules)) {
				worksSchedules = (WorksSchedules)session.get(WorksSchedulesImpl.class,
						worksSchedules.getPrimaryKeyObj());
			}

			if (worksSchedules != null) {
				session.delete(worksSchedules);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (worksSchedules != null) {
			clearCache(worksSchedules);
		}

		return worksSchedules;
	}

	@Override
	public WorksSchedules updateImpl(WorksSchedules worksSchedules) {
		boolean isNew = worksSchedules.isNew();

		if (!(worksSchedules instanceof WorksSchedulesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(worksSchedules.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(worksSchedules);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in worksSchedules proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorksSchedules implementation " +
				worksSchedules.getClass());
		}

		WorksSchedulesModelImpl worksSchedulesModelImpl = (WorksSchedulesModelImpl)worksSchedules;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (worksSchedules.getCreateDate() == null)) {
			if (serviceContext == null) {
				worksSchedules.setCreateDate(now);
			}
			else {
				worksSchedules.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!worksSchedulesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				worksSchedules.setModifiedDate(now);
			}
			else {
				worksSchedules.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (worksSchedules.isNew()) {
				session.save(worksSchedules);

				worksSchedules.setNew(false);
			}
			else {
				worksSchedules = (WorksSchedules)session.merge(worksSchedules);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WorksSchedulesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					worksSchedulesModelImpl.getSchedulesId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHEDULESID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULESID,
				args);

			args = new Object[] {
					worksSchedulesModelImpl.getFromDate(),
					worksSchedulesModelImpl.getToDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FROMTODATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMTODATE,
				args);

			args = new Object[] { worksSchedulesModelImpl.getToDate() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TODATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TODATE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((worksSchedulesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						worksSchedulesModelImpl.getOriginalSchedulesId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHEDULESID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULESID,
					args);

				args = new Object[] { worksSchedulesModelImpl.getSchedulesId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHEDULESID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULESID,
					args);
			}

			if ((worksSchedulesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMTODATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						worksSchedulesModelImpl.getOriginalFromDate(),
						worksSchedulesModelImpl.getOriginalToDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FROMTODATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMTODATE,
					args);

				args = new Object[] {
						worksSchedulesModelImpl.getFromDate(),
						worksSchedulesModelImpl.getToDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FROMTODATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FROMTODATE,
					args);
			}

			if ((worksSchedulesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TODATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						worksSchedulesModelImpl.getOriginalToDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TODATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TODATE,
					args);

				args = new Object[] { worksSchedulesModelImpl.getToDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TODATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TODATE,
					args);
			}
		}

		entityCache.putResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
			WorksSchedulesImpl.class, worksSchedules.getPrimaryKey(),
			worksSchedules, false);

		worksSchedules.resetOriginalValues();

		return worksSchedules;
	}

	/**
	 * Returns the works schedules with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the works schedules
	 * @return the works schedules
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorksSchedulesException {
		WorksSchedules worksSchedules = fetchByPrimaryKey(primaryKey);

		if (worksSchedules == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorksSchedulesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return worksSchedules;
	}

	/**
	 * Returns the works schedules with the primary key or throws a {@link NoSuchWorksSchedulesException} if it could not be found.
	 *
	 * @param worksSchedulesId the primary key of the works schedules
	 * @return the works schedules
	 * @throws NoSuchWorksSchedulesException if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules findByPrimaryKey(long worksSchedulesId)
		throws NoSuchWorksSchedulesException {
		return findByPrimaryKey((Serializable)worksSchedulesId);
	}

	/**
	 * Returns the works schedules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the works schedules
	 * @return the works schedules, or <code>null</code> if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
				WorksSchedulesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WorksSchedules worksSchedules = (WorksSchedules)serializable;

		if (worksSchedules == null) {
			Session session = null;

			try {
				session = openSession();

				worksSchedules = (WorksSchedules)session.get(WorksSchedulesImpl.class,
						primaryKey);

				if (worksSchedules != null) {
					cacheResult(worksSchedules);
				}
				else {
					entityCache.putResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
						WorksSchedulesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
					WorksSchedulesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return worksSchedules;
	}

	/**
	 * Returns the works schedules with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param worksSchedulesId the primary key of the works schedules
	 * @return the works schedules, or <code>null</code> if a works schedules with the primary key could not be found
	 */
	@Override
	public WorksSchedules fetchByPrimaryKey(long worksSchedulesId) {
		return fetchByPrimaryKey((Serializable)worksSchedulesId);
	}

	@Override
	public Map<Serializable, WorksSchedules> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WorksSchedules> map = new HashMap<Serializable, WorksSchedules>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WorksSchedules worksSchedules = fetchByPrimaryKey(primaryKey);

			if (worksSchedules != null) {
				map.put(primaryKey, worksSchedules);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
					WorksSchedulesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WorksSchedules)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORKSSCHEDULES_WHERE_PKS_IN);

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

			for (WorksSchedules worksSchedules : (List<WorksSchedules>)q.list()) {
				map.put(worksSchedules.getPrimaryKeyObj(), worksSchedules);

				cacheResult(worksSchedules);

				uncachedPrimaryKeys.remove(worksSchedules.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WorksSchedulesModelImpl.ENTITY_CACHE_ENABLED,
					WorksSchedulesImpl.class, primaryKey, nullModel);
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
	 * Returns all the works scheduleses.
	 *
	 * @return the works scheduleses
	 */
	@Override
	public List<WorksSchedules> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the works scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @return the range of works scheduleses
	 */
	@Override
	public List<WorksSchedules> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the works scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of works scheduleses
	 */
	@Override
	public List<WorksSchedules> findAll(int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the works scheduleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorksSchedulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of works scheduleses
	 * @param end the upper bound of the range of works scheduleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of works scheduleses
	 */
	@Override
	public List<WorksSchedules> findAll(int start, int end,
		OrderByComparator<WorksSchedules> orderByComparator,
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

		List<WorksSchedules> list = null;

		if (retrieveFromCache) {
			list = (List<WorksSchedules>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORKSSCHEDULES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKSSCHEDULES;

				if (pagination) {
					sql = sql.concat(WorksSchedulesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorksSchedules>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorksSchedules>)QueryUtil.list(q,
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
	 * Removes all the works scheduleses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorksSchedules worksSchedules : findAll()) {
			remove(worksSchedules);
		}
	}

	/**
	 * Returns the number of works scheduleses.
	 *
	 * @return the number of works scheduleses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKSSCHEDULES);

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
		return WorksSchedulesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the works schedules persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WorksSchedulesImpl.class.getName());
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_WORKSSCHEDULES = "SELECT worksSchedules FROM WorksSchedules worksSchedules";
	private static final String _SQL_SELECT_WORKSSCHEDULES_WHERE_PKS_IN = "SELECT worksSchedules FROM WorksSchedules worksSchedules WHERE worksSchedulesId IN (";
	private static final String _SQL_SELECT_WORKSSCHEDULES_WHERE = "SELECT worksSchedules FROM WorksSchedules worksSchedules WHERE ";
	private static final String _SQL_COUNT_WORKSSCHEDULES = "SELECT COUNT(worksSchedules) FROM WorksSchedules worksSchedules";
	private static final String _SQL_COUNT_WORKSSCHEDULES_WHERE = "SELECT COUNT(worksSchedules) FROM WorksSchedules worksSchedules WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "worksSchedules.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorksSchedules exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorksSchedules exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WorksSchedulesPersistenceImpl.class);
}