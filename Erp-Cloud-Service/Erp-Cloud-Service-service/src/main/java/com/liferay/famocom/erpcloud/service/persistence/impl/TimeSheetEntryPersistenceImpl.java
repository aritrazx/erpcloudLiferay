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

import com.liferay.famocom.erpcloud.exception.NoSuchTimeSheetEntryException;
import com.liferay.famocom.erpcloud.model.TimeSheetEntry;
import com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryImpl;
import com.liferay.famocom.erpcloud.model.impl.TimeSheetEntryModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TimeSheetEntryPersistence;

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
 * The persistence implementation for the time sheet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetEntryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TimeSheetEntryUtil
 * @generated
 */
@ProviderType
public class TimeSheetEntryPersistenceImpl extends BasePersistenceImpl<TimeSheetEntry>
	implements TimeSheetEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimeSheetEntryUtil} to access the time sheet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimeSheetEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryModelImpl.FINDER_CACHE_ENABLED,
			TimeSheetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TimeSheetEntryModelImpl.GROUPID_COLUMN_BITMASK |
			TimeSheetEntryModelImpl.STATUS_COLUMN_BITMASK |
			TimeSheetEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the time sheet entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findBystatus(long groupId, int status) {
		return findBystatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time sheet entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of time sheet entries
	 * @param end the upper bound of the range of time sheet entries (not inclusive)
	 * @return the range of matching time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findBystatus(long groupId, int status,
		int start, int end) {
		return findBystatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time sheet entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of time sheet entries
	 * @param end the upper bound of the range of time sheet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findBystatus(long groupId, int status,
		int start, int end, OrderByComparator<TimeSheetEntry> orderByComparator) {
		return findBystatus(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time sheet entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of time sheet entries
	 * @param end the upper bound of the range of time sheet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findBystatus(long groupId, int status,
		int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator,
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

		List<TimeSheetEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TimeSheetEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeSheetEntry timeSheetEntry : list) {
					if ((groupId != timeSheetEntry.getGroupId()) ||
							(status != timeSheetEntry.getStatus())) {
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

			query.append(_SQL_SELECT_TIMESHEETENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimeSheetEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<TimeSheetEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeSheetEntry>)QueryUtil.list(q,
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
	 * Returns the first time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time sheet entry
	 * @throws NoSuchTimeSheetEntryException if a matching time sheet entry could not be found
	 */
	@Override
	public TimeSheetEntry findBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator)
		throws NoSuchTimeSheetEntryException {
		TimeSheetEntry timeSheetEntry = fetchBystatus_First(groupId, status,
				orderByComparator);

		if (timeSheetEntry != null) {
			return timeSheetEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTimeSheetEntryException(msg.toString());
	}

	/**
	 * Returns the first time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time sheet entry, or <code>null</code> if a matching time sheet entry could not be found
	 */
	@Override
	public TimeSheetEntry fetchBystatus_First(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		List<TimeSheetEntry> list = findBystatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time sheet entry
	 * @throws NoSuchTimeSheetEntryException if a matching time sheet entry could not be found
	 */
	@Override
	public TimeSheetEntry findBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator)
		throws NoSuchTimeSheetEntryException {
		TimeSheetEntry timeSheetEntry = fetchBystatus_Last(groupId, status,
				orderByComparator);

		if (timeSheetEntry != null) {
			return timeSheetEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTimeSheetEntryException(msg.toString());
	}

	/**
	 * Returns the last time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time sheet entry, or <code>null</code> if a matching time sheet entry could not be found
	 */
	@Override
	public TimeSheetEntry fetchBystatus_Last(long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		int count = countBystatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<TimeSheetEntry> list = findBystatus(groupId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time sheet entries before and after the current time sheet entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param timesheetId the primary key of the current time sheet entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time sheet entry
	 * @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry[] findBystatus_PrevAndNext(long timesheetId,
		long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator)
		throws NoSuchTimeSheetEntryException {
		TimeSheetEntry timeSheetEntry = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			TimeSheetEntry[] array = new TimeSheetEntryImpl[3];

			array[0] = getBystatus_PrevAndNext(session, timeSheetEntry,
					groupId, status, orderByComparator, true);

			array[1] = timeSheetEntry;

			array[2] = getBystatus_PrevAndNext(session, timeSheetEntry,
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

	protected TimeSheetEntry getBystatus_PrevAndNext(Session session,
		TimeSheetEntry timeSheetEntry, long groupId, int status,
		OrderByComparator<TimeSheetEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TIMESHEETENTRY_WHERE);

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
			query.append(TimeSheetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timeSheetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimeSheetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time sheet entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeBystatus(long groupId, int status) {
		for (TimeSheetEntry timeSheetEntry : findBystatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timeSheetEntry);
		}
	}

	/**
	 * Returns the number of time sheet entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching time sheet entries
	 */
	@Override
	public int countBystatus(long groupId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMESHEETENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 = "timeSheetEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "timeSheetEntry.status = ?";

	public TimeSheetEntryPersistenceImpl() {
		setModelClass(TimeSheetEntry.class);
	}

	/**
	 * Caches the time sheet entry in the entity cache if it is enabled.
	 *
	 * @param timeSheetEntry the time sheet entry
	 */
	@Override
	public void cacheResult(TimeSheetEntry timeSheetEntry) {
		entityCache.putResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryImpl.class, timeSheetEntry.getPrimaryKey(),
			timeSheetEntry);

		timeSheetEntry.resetOriginalValues();
	}

	/**
	 * Caches the time sheet entries in the entity cache if it is enabled.
	 *
	 * @param timeSheetEntries the time sheet entries
	 */
	@Override
	public void cacheResult(List<TimeSheetEntry> timeSheetEntries) {
		for (TimeSheetEntry timeSheetEntry : timeSheetEntries) {
			if (entityCache.getResult(
						TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
						TimeSheetEntryImpl.class, timeSheetEntry.getPrimaryKey()) == null) {
				cacheResult(timeSheetEntry);
			}
			else {
				timeSheetEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all time sheet entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimeSheetEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the time sheet entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimeSheetEntry timeSheetEntry) {
		entityCache.removeResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryImpl.class, timeSheetEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TimeSheetEntry> timeSheetEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimeSheetEntry timeSheetEntry : timeSheetEntries) {
			entityCache.removeResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
				TimeSheetEntryImpl.class, timeSheetEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new time sheet entry with the primary key. Does not add the time sheet entry to the database.
	 *
	 * @param timesheetId the primary key for the new time sheet entry
	 * @return the new time sheet entry
	 */
	@Override
	public TimeSheetEntry create(long timesheetId) {
		TimeSheetEntry timeSheetEntry = new TimeSheetEntryImpl();

		timeSheetEntry.setNew(true);
		timeSheetEntry.setPrimaryKey(timesheetId);

		return timeSheetEntry;
	}

	/**
	 * Removes the time sheet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetId the primary key of the time sheet entry
	 * @return the time sheet entry that was removed
	 * @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry remove(long timesheetId)
		throws NoSuchTimeSheetEntryException {
		return remove((Serializable)timesheetId);
	}

	/**
	 * Removes the time sheet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the time sheet entry
	 * @return the time sheet entry that was removed
	 * @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry remove(Serializable primaryKey)
		throws NoSuchTimeSheetEntryException {
		Session session = null;

		try {
			session = openSession();

			TimeSheetEntry timeSheetEntry = (TimeSheetEntry)session.get(TimeSheetEntryImpl.class,
					primaryKey);

			if (timeSheetEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimeSheetEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timeSheetEntry);
		}
		catch (NoSuchTimeSheetEntryException nsee) {
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
	protected TimeSheetEntry removeImpl(TimeSheetEntry timeSheetEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timeSheetEntry)) {
				timeSheetEntry = (TimeSheetEntry)session.get(TimeSheetEntryImpl.class,
						timeSheetEntry.getPrimaryKeyObj());
			}

			if (timeSheetEntry != null) {
				session.delete(timeSheetEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (timeSheetEntry != null) {
			clearCache(timeSheetEntry);
		}

		return timeSheetEntry;
	}

	@Override
	public TimeSheetEntry updateImpl(TimeSheetEntry timeSheetEntry) {
		boolean isNew = timeSheetEntry.isNew();

		if (!(timeSheetEntry instanceof TimeSheetEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(timeSheetEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(timeSheetEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in timeSheetEntry proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TimeSheetEntry implementation " +
				timeSheetEntry.getClass());
		}

		TimeSheetEntryModelImpl timeSheetEntryModelImpl = (TimeSheetEntryModelImpl)timeSheetEntry;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (timeSheetEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				timeSheetEntry.setCreateDate(now);
			}
			else {
				timeSheetEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!timeSheetEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				timeSheetEntry.setModifiedDate(now);
			}
			else {
				timeSheetEntry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (timeSheetEntry.isNew()) {
				session.save(timeSheetEntry);

				timeSheetEntry.setNew(false);
			}
			else {
				timeSheetEntry = (TimeSheetEntry)session.merge(timeSheetEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TimeSheetEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					timeSheetEntryModelImpl.getGroupId(),
					timeSheetEntryModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((timeSheetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeSheetEntryModelImpl.getOriginalGroupId(),
						timeSheetEntryModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						timeSheetEntryModelImpl.getGroupId(),
						timeSheetEntryModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeSheetEntryImpl.class, timeSheetEntry.getPrimaryKey(),
			timeSheetEntry, false);

		timeSheetEntry.resetOriginalValues();

		return timeSheetEntry;
	}

	/**
	 * Returns the time sheet entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the time sheet entry
	 * @return the time sheet entry
	 * @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimeSheetEntryException {
		TimeSheetEntry timeSheetEntry = fetchByPrimaryKey(primaryKey);

		if (timeSheetEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimeSheetEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timeSheetEntry;
	}

	/**
	 * Returns the time sheet entry with the primary key or throws a {@link NoSuchTimeSheetEntryException} if it could not be found.
	 *
	 * @param timesheetId the primary key of the time sheet entry
	 * @return the time sheet entry
	 * @throws NoSuchTimeSheetEntryException if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry findByPrimaryKey(long timesheetId)
		throws NoSuchTimeSheetEntryException {
		return findByPrimaryKey((Serializable)timesheetId);
	}

	/**
	 * Returns the time sheet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the time sheet entry
	 * @return the time sheet entry, or <code>null</code> if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
				TimeSheetEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TimeSheetEntry timeSheetEntry = (TimeSheetEntry)serializable;

		if (timeSheetEntry == null) {
			Session session = null;

			try {
				session = openSession();

				timeSheetEntry = (TimeSheetEntry)session.get(TimeSheetEntryImpl.class,
						primaryKey);

				if (timeSheetEntry != null) {
					cacheResult(timeSheetEntry);
				}
				else {
					entityCache.putResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
						TimeSheetEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
					TimeSheetEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return timeSheetEntry;
	}

	/**
	 * Returns the time sheet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timesheetId the primary key of the time sheet entry
	 * @return the time sheet entry, or <code>null</code> if a time sheet entry with the primary key could not be found
	 */
	@Override
	public TimeSheetEntry fetchByPrimaryKey(long timesheetId) {
		return fetchByPrimaryKey((Serializable)timesheetId);
	}

	@Override
	public Map<Serializable, TimeSheetEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TimeSheetEntry> map = new HashMap<Serializable, TimeSheetEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TimeSheetEntry timeSheetEntry = fetchByPrimaryKey(primaryKey);

			if (timeSheetEntry != null) {
				map.put(primaryKey, timeSheetEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
					TimeSheetEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TimeSheetEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIMESHEETENTRY_WHERE_PKS_IN);

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

			for (TimeSheetEntry timeSheetEntry : (List<TimeSheetEntry>)q.list()) {
				map.put(timeSheetEntry.getPrimaryKeyObj(), timeSheetEntry);

				cacheResult(timeSheetEntry);

				uncachedPrimaryKeys.remove(timeSheetEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TimeSheetEntryModelImpl.ENTITY_CACHE_ENABLED,
					TimeSheetEntryImpl.class, primaryKey, nullModel);
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
	 * Returns all the time sheet entries.
	 *
	 * @return the time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time sheet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time sheet entries
	 * @param end the upper bound of the range of time sheet entries (not inclusive)
	 * @return the range of time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the time sheet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time sheet entries
	 * @param end the upper bound of the range of time sheet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findAll(int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time sheet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeSheetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time sheet entries
	 * @param end the upper bound of the range of time sheet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of time sheet entries
	 */
	@Override
	public List<TimeSheetEntry> findAll(int start, int end,
		OrderByComparator<TimeSheetEntry> orderByComparator,
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

		List<TimeSheetEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TimeSheetEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIMESHEETENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMESHEETENTRY;

				if (pagination) {
					sql = sql.concat(TimeSheetEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TimeSheetEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeSheetEntry>)QueryUtil.list(q,
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
	 * Removes all the time sheet entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TimeSheetEntry timeSheetEntry : findAll()) {
			remove(timeSheetEntry);
		}
	}

	/**
	 * Returns the number of time sheet entries.
	 *
	 * @return the number of time sheet entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMESHEETENTRY);

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
		return TimeSheetEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the time sheet entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TimeSheetEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIMESHEETENTRY = "SELECT timeSheetEntry FROM TimeSheetEntry timeSheetEntry";
	private static final String _SQL_SELECT_TIMESHEETENTRY_WHERE_PKS_IN = "SELECT timeSheetEntry FROM TimeSheetEntry timeSheetEntry WHERE timesheetId IN (";
	private static final String _SQL_SELECT_TIMESHEETENTRY_WHERE = "SELECT timeSheetEntry FROM TimeSheetEntry timeSheetEntry WHERE ";
	private static final String _SQL_COUNT_TIMESHEETENTRY = "SELECT COUNT(timeSheetEntry) FROM TimeSheetEntry timeSheetEntry";
	private static final String _SQL_COUNT_TIMESHEETENTRY_WHERE = "SELECT COUNT(timeSheetEntry) FROM TimeSheetEntry timeSheetEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timeSheetEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimeSheetEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimeSheetEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TimeSheetEntryPersistenceImpl.class);
}