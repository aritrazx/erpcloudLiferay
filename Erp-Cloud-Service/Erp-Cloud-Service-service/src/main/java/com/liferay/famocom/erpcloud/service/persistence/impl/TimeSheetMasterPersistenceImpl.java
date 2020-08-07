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

import com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetMasterException;
import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.model.impl.TimeSheetMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.TimeSheetMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TimeSheetMasterPersistence;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the time sheet master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TimeSheetMasterUtil
 * @generated
 */
@ProviderType
public class TimeSheetMasterPersistenceImpl extends BasePersistenceImpl<TimeSheetMaster>
	implements TimeSheetMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimeSheetMasterUtil} to access the time sheet master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimeSheetMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TimeSheetMasterModelImpl.GROUPID_COLUMN_BITMASK |
			TimeSheetMasterModelImpl.STATUS_COLUMN_BITMASK |
			TimeSheetMasterModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the time sheet masters where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findBystatus(long groupId, int status) {
		return findBystatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time sheet masters where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of time sheet masters
	 * @param end the upper bound of the range of time sheet masters (not inclusive)
	 * @return the range of matching time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findBystatus(long groupId, int status,
		int start, int end) {
		return findBystatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time sheet masters where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of time sheet masters
	 * @param end the upper bound of the range of time sheet masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<TimeSheetMaster> orderByComparator) {
		return findBystatus(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time sheet masters where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of time sheet masters
	 * @param end the upper bound of the range of time sheet masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findBystatus(long groupId, int status,
		int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<TimeSheetMaster> list = null;

		if (retrieveFromCache) {
			list = (List<TimeSheetMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeSheetMaster timeSheetMaster : list) {
					if ((groupId != timeSheetMaster.getGroupId()) ||
							(status != timeSheetMaster.getStatus())) {
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

			query.append(_SQL_SELECT_TIMESHEETMASTER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimeSheetMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<TimeSheetMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeSheetMaster>)QueryUtil.list(q,
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
	 * Returns the first time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time sheet master
	 * @throws NoSuchTimeSheetMasterException if a matching time sheet master could not be found
	 */
	@Override
	public TimeSheetMaster findBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator)
		throws NoSuchTimeSheetMasterException {
		TimeSheetMaster timeSheetMaster = fetchBystatus_First(groupId, status,
				orderByComparator);

		if (timeSheetMaster != null) {
			return timeSheetMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTimeSheetMasterException(msg.toString());
	}

	/**
	 * Returns the first time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time sheet master, or <code>null</code> if a matching time sheet master could not be found
	 */
	@Override
	public TimeSheetMaster fetchBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		List<TimeSheetMaster> list = findBystatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time sheet master
	 * @throws NoSuchTimeSheetMasterException if a matching time sheet master could not be found
	 */
	@Override
	public TimeSheetMaster findBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator)
		throws NoSuchTimeSheetMasterException {
		TimeSheetMaster timeSheetMaster = fetchBystatus_Last(groupId, status,
				orderByComparator);

		if (timeSheetMaster != null) {
			return timeSheetMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTimeSheetMasterException(msg.toString());
	}

	/**
	 * Returns the last time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time sheet master, or <code>null</code> if a matching time sheet master could not be found
	 */
	@Override
	public TimeSheetMaster fetchBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		int count = countBystatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<TimeSheetMaster> list = findBystatus(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time sheet masters before and after the current time sheet master in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param timesheetParentId the primary key of the current time sheet master
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time sheet master
	 * @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster[] findBystatus_PrevAndNext(long timesheetParentId,
		long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator)
		throws NoSuchTimeSheetMasterException {
		TimeSheetMaster timeSheetMaster = findByPrimaryKey(timesheetParentId);

		Session session = null;

		try {
			session = openSession();

			TimeSheetMaster[] array = new TimeSheetMasterImpl[3];

			array[0] = getBystatus_PrevAndNext(session, timeSheetMaster,
					groupId, status, orderByComparator, true);

			array[1] = timeSheetMaster;

			array[2] = getBystatus_PrevAndNext(session, timeSheetMaster,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeSheetMaster getBystatus_PrevAndNext(Session session,
		TimeSheetMaster timeSheetMaster, long groupId, int status,
		OrderByComparator<TimeSheetMaster> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TIMESHEETMASTER_WHERE);

		query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(TimeSheetMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timeSheetMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimeSheetMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time sheet masters where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeBystatus(long groupId, int status) {
		for (TimeSheetMaster timeSheetMaster : findBystatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timeSheetMaster);
		}
	}

	/**
	 * Returns the number of time sheet masters where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching time sheet masters
	 */
	@Override
	public int countBystatus(long groupId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMESHEETMASTER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 = "timeSheetMaster.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "timeSheetMaster.status = ?";

	public TimeSheetMasterPersistenceImpl() {
		setModelClass(TimeSheetMaster.class);
	}

	/**
	 * Caches the time sheet master in the entity cache if it is enabled.
	 *
	 * @param timeSheetMaster the time sheet master
	 */
	@Override
	public void cacheResult(TimeSheetMaster timeSheetMaster) {
		entityCache.putResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterImpl.class, timeSheetMaster.getPrimaryKey(),
			timeSheetMaster);

		timeSheetMaster.resetOriginalValues();
	}

	/**
	 * Caches the time sheet masters in the entity cache if it is enabled.
	 *
	 * @param timeSheetMasters the time sheet masters
	 */
	@Override
	public void cacheResult(List<TimeSheetMaster> timeSheetMasters) {
		for (TimeSheetMaster timeSheetMaster : timeSheetMasters) {
			if (entityCache.getResult(
						TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
						TimeSheetMasterImpl.class,
						timeSheetMaster.getPrimaryKey()) == null) {
				cacheResult(timeSheetMaster);
			}
			else {
				timeSheetMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all time sheet masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimeSheetMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the time sheet master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimeSheetMaster timeSheetMaster) {
		entityCache.removeResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterImpl.class, timeSheetMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TimeSheetMaster> timeSheetMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimeSheetMaster timeSheetMaster : timeSheetMasters) {
			entityCache.removeResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
				TimeSheetMasterImpl.class, timeSheetMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new time sheet master with the primary key. Does not add the time sheet master to the database.
	 *
	 * @param timesheetParentId the primary key for the new time sheet master
	 * @return the new time sheet master
	 */
	@Override
	public TimeSheetMaster create(long timesheetParentId) {
		TimeSheetMaster timeSheetMaster = new TimeSheetMasterImpl();

		timeSheetMaster.setNew(true);
		timeSheetMaster.setPrimaryKey(timesheetParentId);

		return timeSheetMaster;
	}

	/**
	 * Removes the time sheet master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetParentId the primary key of the time sheet master
	 * @return the time sheet master that was removed
	 * @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster remove(long timesheetParentId)
		throws NoSuchTimeSheetMasterException {
		return remove((Serializable)timesheetParentId);
	}

	/**
	 * Removes the time sheet master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the time sheet master
	 * @return the time sheet master that was removed
	 * @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster remove(Serializable primaryKey)
		throws NoSuchTimeSheetMasterException {
		Session session = null;

		try {
			session = openSession();

			TimeSheetMaster timeSheetMaster = (TimeSheetMaster)session.get(TimeSheetMasterImpl.class,
					primaryKey);

			if (timeSheetMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimeSheetMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timeSheetMaster);
		}
		catch (NoSuchTimeSheetMasterException nsee) {
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
	protected TimeSheetMaster removeImpl(TimeSheetMaster timeSheetMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timeSheetMaster)) {
				timeSheetMaster = (TimeSheetMaster)session.get(TimeSheetMasterImpl.class,
						timeSheetMaster.getPrimaryKeyObj());
			}

			if (timeSheetMaster != null) {
				session.delete(timeSheetMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (timeSheetMaster != null) {
			clearCache(timeSheetMaster);
		}

		return timeSheetMaster;
	}

	@Override
	public TimeSheetMaster updateImpl(TimeSheetMaster timeSheetMaster) {
		boolean isNew = timeSheetMaster.isNew();

		if (!(timeSheetMaster instanceof TimeSheetMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(timeSheetMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(timeSheetMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in timeSheetMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TimeSheetMaster implementation " +
				timeSheetMaster.getClass());
		}

		TimeSheetMasterModelImpl timeSheetMasterModelImpl = (TimeSheetMasterModelImpl)timeSheetMaster;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (timeSheetMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				timeSheetMaster.setCreateDate(now);
			}
			else {
				timeSheetMaster.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!timeSheetMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				timeSheetMaster.setModifiedDate(now);
			}
			else {
				timeSheetMaster.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (timeSheetMaster.isNew()) {
				session.save(timeSheetMaster);

				timeSheetMaster.setNew(false);
			}
			else {
				timeSheetMaster = (TimeSheetMaster)session.merge(timeSheetMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TimeSheetMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					timeSheetMasterModelImpl.getGroupId(),
					timeSheetMasterModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((timeSheetMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeSheetMasterModelImpl.getOriginalGroupId(),
						timeSheetMasterModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						timeSheetMasterModelImpl.getGroupId(),
						timeSheetMasterModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetMasterImpl.class, timeSheetMaster.getPrimaryKey(),
			timeSheetMaster, false);

		timeSheetMaster.resetOriginalValues();

		return timeSheetMaster;
	}

	/**
	 * Returns the time sheet master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the time sheet master
	 * @return the time sheet master
	 * @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimeSheetMasterException {
		TimeSheetMaster timeSheetMaster = fetchByPrimaryKey(primaryKey);

		if (timeSheetMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimeSheetMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timeSheetMaster;
	}

	/**
	 * Returns the time sheet master with the primary key or throws a {@link NoSuchTimeSheetMasterException} if it could not be found.
	 *
	 * @param timesheetParentId the primary key of the time sheet master
	 * @return the time sheet master
	 * @throws NoSuchTimeSheetMasterException if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster findByPrimaryKey(long timesheetParentId)
		throws NoSuchTimeSheetMasterException {
		return findByPrimaryKey((Serializable)timesheetParentId);
	}

	/**
	 * Returns the time sheet master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the time sheet master
	 * @return the time sheet master, or <code>null</code> if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
				TimeSheetMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TimeSheetMaster timeSheetMaster = (TimeSheetMaster)serializable;

		if (timeSheetMaster == null) {
			Session session = null;

			try {
				session = openSession();

				timeSheetMaster = (TimeSheetMaster)session.get(TimeSheetMasterImpl.class,
						primaryKey);

				if (timeSheetMaster != null) {
					cacheResult(timeSheetMaster);
				}
				else {
					entityCache.putResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
						TimeSheetMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
					TimeSheetMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return timeSheetMaster;
	}

	/**
	 * Returns the time sheet master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timesheetParentId the primary key of the time sheet master
	 * @return the time sheet master, or <code>null</code> if a time sheet master with the primary key could not be found
	 */
	@Override
	public TimeSheetMaster fetchByPrimaryKey(long timesheetParentId) {
		return fetchByPrimaryKey((Serializable)timesheetParentId);
	}

	@Override
	public Map<Serializable, TimeSheetMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TimeSheetMaster> map = new HashMap<Serializable, TimeSheetMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TimeSheetMaster timeSheetMaster = fetchByPrimaryKey(primaryKey);

			if (timeSheetMaster != null) {
				map.put(primaryKey, timeSheetMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
					TimeSheetMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TimeSheetMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIMESHEETMASTER_WHERE_PKS_IN);

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

			for (TimeSheetMaster timeSheetMaster : (List<TimeSheetMaster>)q.list()) {
				map.put(timeSheetMaster.getPrimaryKeyObj(), timeSheetMaster);

				cacheResult(timeSheetMaster);

				uncachedPrimaryKeys.remove(timeSheetMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TimeSheetMasterModelImpl.ENTITY_CACHE_ENABLED,
					TimeSheetMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the time sheet masters.
	 *
	 * @return the time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time sheet masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time sheet masters
	 * @param end the upper bound of the range of time sheet masters (not inclusive)
	 * @return the range of time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the time sheet masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time sheet masters
	 * @param end the upper bound of the range of time sheet masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findAll(int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time sheet masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time sheet masters
	 * @param end the upper bound of the range of time sheet masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of time sheet masters
	 */
	@Override
	public List<TimeSheetMaster> findAll(int start, int end,
		OrderByComparator<TimeSheetMaster> orderByComparator,
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

		List<TimeSheetMaster> list = null;

		if (retrieveFromCache) {
			list = (List<TimeSheetMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIMESHEETMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMESHEETMASTER;

				if (pagination) {
					sql = sql.concat(TimeSheetMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TimeSheetMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeSheetMaster>)QueryUtil.list(q,
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
	 * Removes all the time sheet masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TimeSheetMaster timeSheetMaster : findAll()) {
			remove(timeSheetMaster);
		}
	}

	/**
	 * Returns the number of time sheet masters.
	 *
	 * @return the number of time sheet masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMESHEETMASTER);

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
		return TimeSheetMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the time sheet master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TimeSheetMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIMESHEETMASTER = "SELECT timeSheetMaster FROM TimeSheetMaster timeSheetMaster";
	private static final String _SQL_SELECT_TIMESHEETMASTER_WHERE_PKS_IN = "SELECT timeSheetMaster FROM TimeSheetMaster timeSheetMaster WHERE timesheetParentId IN (";
	private static final String _SQL_SELECT_TIMESHEETMASTER_WHERE = "SELECT timeSheetMaster FROM TimeSheetMaster timeSheetMaster WHERE ";
	private static final String _SQL_COUNT_TIMESHEETMASTER = "SELECT COUNT(timeSheetMaster) FROM TimeSheetMaster timeSheetMaster";
	private static final String _SQL_COUNT_TIMESHEETMASTER_WHERE = "SELECT COUNT(timeSheetMaster) FROM TimeSheetMaster timeSheetMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timeSheetMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimeSheetMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimeSheetMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TimeSheetMasterPersistenceImpl.class);
}