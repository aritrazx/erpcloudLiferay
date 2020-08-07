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

import com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;
import com.liferay.famocom.erpcloud.model.impl.HolidayCalenderManagementImpl;
import com.liferay.famocom.erpcloud.model.impl.HolidayCalenderManagementModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.HolidayCalenderManagementPersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the holiday calender management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see HolidayCalenderManagementPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.HolidayCalenderManagementUtil
 * @generated
 */
@ProviderType
public class HolidayCalenderManagementPersistenceImpl
	extends BasePersistenceImpl<HolidayCalenderManagement>
	implements HolidayCalenderManagementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HolidayCalenderManagementUtil} to access the holiday calender management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HolidayCalenderManagementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPIDANDATTDATE = new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByempIdAndAttDate", new String[] { Date.class.getName() },
			HolidayCalenderManagementModelImpl.HOLIDAYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPIDANDATTDATE = new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByempIdAndAttDate", new String[] { Date.class.getName() });

	/**
	 * Returns the holiday calender management where holidayDate = &#63; or throws a {@link NoSuchHolidayCalenderManagementException} if it could not be found.
	 *
	 * @param holidayDate the holiday date
	 * @return the matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findByempIdAndAttDate(Date holidayDate)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchByempIdAndAttDate(holidayDate);

		if (holidayCalenderManagement == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("holidayDate=");
			msg.append(holidayDate);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchHolidayCalenderManagementException(msg.toString());
		}

		return holidayCalenderManagement;
	}

	/**
	 * Returns the holiday calender management where holidayDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param holidayDate the holiday date
	 * @return the matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchByempIdAndAttDate(Date holidayDate) {
		return fetchByempIdAndAttDate(holidayDate, true);
	}

	/**
	 * Returns the holiday calender management where holidayDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param holidayDate the holiday date
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchByempIdAndAttDate(Date holidayDate,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { _getTime(holidayDate) };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs, this);
		}

		if (result instanceof HolidayCalenderManagement) {
			HolidayCalenderManagement holidayCalenderManagement = (HolidayCalenderManagement)result;

			if (!Objects.equals(holidayDate,
						holidayCalenderManagement.getHolidayDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayDate = false;

			if (holidayDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_HOLIDAYDATE_1);
			}
			else {
				bindHolidayDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_HOLIDAYDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayDate) {
					qPos.add(new Timestamp(holidayDate.getTime()));
				}

				List<HolidayCalenderManagement> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"HolidayCalenderManagementPersistenceImpl.fetchByempIdAndAttDate(Date, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					HolidayCalenderManagement holidayCalenderManagement = list.get(0);

					result = holidayCalenderManagement;

					cacheResult(holidayCalenderManagement);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (HolidayCalenderManagement)result;
		}
	}

	/**
	 * Removes the holiday calender management where holidayDate = &#63; from the database.
	 *
	 * @param holidayDate the holiday date
	 * @return the holiday calender management that was removed
	 */
	@Override
	public HolidayCalenderManagement removeByempIdAndAttDate(Date holidayDate)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = findByempIdAndAttDate(holidayDate);

		return remove(holidayCalenderManagement);
	}

	/**
	 * Returns the number of holiday calender managements where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @return the number of matching holiday calender managements
	 */
	@Override
	public int countByempIdAndAttDate(Date holidayDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPIDANDATTDATE;

		Object[] finderArgs = new Object[] { _getTime(holidayDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayDate = false;

			if (holidayDate == null) {
				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_HOLIDAYDATE_1);
			}
			else {
				bindHolidayDate = true;

				query.append(_FINDER_COLUMN_EMPIDANDATTDATE_HOLIDAYDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayDate) {
					qPos.add(new Timestamp(holidayDate.getTime()));
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

	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_HOLIDAYDATE_1 = "holidayCalenderManagement.holidayDate IS NULL";
	private static final String _FINDER_COLUMN_EMPIDANDATTDATE_HOLIDAYDATE_2 = "holidayCalenderManagement.holidayDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HOLIDAYCHECK =
		new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByholiDayCheck",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYCHECK =
		new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByholiDayCheck",
			new String[] { Date.class.getName() },
			HolidayCalenderManagementModelImpl.HOLIDAYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HOLIDAYCHECK = new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByholiDayCheck", new String[] { Date.class.getName() });

	/**
	 * Returns all the holiday calender managements where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @return the matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findByholiDayCheck(Date holidayDate) {
		return findByholiDayCheck(holidayDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the holiday calender managements where holidayDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayDate the holiday date
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @return the range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end) {
		return findByholiDayCheck(holidayDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements where holidayDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayDate the holiday date
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return findByholiDayCheck(holidayDate, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements where holidayDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayDate the holiday date
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findByholiDayCheck(
		Date holidayDate, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYCHECK;
			finderArgs = new Object[] { _getTime(holidayDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HOLIDAYCHECK;
			finderArgs = new Object[] {
					_getTime(holidayDate),
					
					start, end, orderByComparator
				};
		}

		List<HolidayCalenderManagement> list = null;

		if (retrieveFromCache) {
			list = (List<HolidayCalenderManagement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HolidayCalenderManagement holidayCalenderManagement : list) {
					if (!Objects.equals(holidayDate,
								holidayCalenderManagement.getHolidayDate())) {
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

			query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayDate = false;

			if (holidayDate == null) {
				query.append(_FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_1);
			}
			else {
				bindHolidayDate = true;

				query.append(_FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HolidayCalenderManagementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayDate) {
					qPos.add(new Timestamp(holidayDate.getTime()));
				}

				if (!pagination) {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
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
	 * Returns the first holiday calender management in the ordered set where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findByholiDayCheck_First(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchByholiDayCheck_First(holidayDate,
				orderByComparator);

		if (holidayCalenderManagement != null) {
			return holidayCalenderManagement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holidayDate=");
		msg.append(holidayDate);

		msg.append("}");

		throw new NoSuchHolidayCalenderManagementException(msg.toString());
	}

	/**
	 * Returns the first holiday calender management in the ordered set where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchByholiDayCheck_First(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		List<HolidayCalenderManagement> list = findByholiDayCheck(holidayDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last holiday calender management in the ordered set where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findByholiDayCheck_Last(Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchByholiDayCheck_Last(holidayDate,
				orderByComparator);

		if (holidayCalenderManagement != null) {
			return holidayCalenderManagement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holidayDate=");
		msg.append(holidayDate);

		msg.append("}");

		throw new NoSuchHolidayCalenderManagementException(msg.toString());
	}

	/**
	 * Returns the last holiday calender management in the ordered set where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchByholiDayCheck_Last(
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		int count = countByholiDayCheck(holidayDate);

		if (count == 0) {
			return null;
		}

		List<HolidayCalenderManagement> list = findByholiDayCheck(holidayDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the holiday calender managements before and after the current holiday calender management in the ordered set where holidayDate = &#63;.
	 *
	 * @param holidayId the primary key of the current holiday calender management
	 * @param holidayDate the holiday date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement[] findByholiDayCheck_PrevAndNext(
		long holidayId, Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = findByPrimaryKey(holidayId);

		Session session = null;

		try {
			session = openSession();

			HolidayCalenderManagement[] array = new HolidayCalenderManagementImpl[3];

			array[0] = getByholiDayCheck_PrevAndNext(session,
					holidayCalenderManagement, holidayDate, orderByComparator,
					true);

			array[1] = holidayCalenderManagement;

			array[2] = getByholiDayCheck_PrevAndNext(session,
					holidayCalenderManagement, holidayDate, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HolidayCalenderManagement getByholiDayCheck_PrevAndNext(
		Session session, HolidayCalenderManagement holidayCalenderManagement,
		Date holidayDate,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE);

		boolean bindHolidayDate = false;

		if (holidayDate == null) {
			query.append(_FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_1);
		}
		else {
			bindHolidayDate = true;

			query.append(_FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_2);
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
			query.append(HolidayCalenderManagementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindHolidayDate) {
			qPos.add(new Timestamp(holidayDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(holidayCalenderManagement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HolidayCalenderManagement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the holiday calender managements where holidayDate = &#63; from the database.
	 *
	 * @param holidayDate the holiday date
	 */
	@Override
	public void removeByholiDayCheck(Date holidayDate) {
		for (HolidayCalenderManagement holidayCalenderManagement : findByholiDayCheck(
				holidayDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(holidayCalenderManagement);
		}
	}

	/**
	 * Returns the number of holiday calender managements where holidayDate = &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @return the number of matching holiday calender managements
	 */
	@Override
	public int countByholiDayCheck(Date holidayDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HOLIDAYCHECK;

		Object[] finderArgs = new Object[] { _getTime(holidayDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayDate = false;

			if (holidayDate == null) {
				query.append(_FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_1);
			}
			else {
				bindHolidayDate = true;

				query.append(_FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayDate) {
					qPos.add(new Timestamp(holidayDate.getTime()));
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

	private static final String _FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_1 = "holidayCalenderManagement.holidayDate IS NULL";
	private static final String _FINDER_COLUMN_HOLIDAYCHECK_HOLIDAYDATE_2 = "holidayCalenderManagement.holidayDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDHOLIDAYID =
		new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynameAndHoliDayId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMEANDHOLIDAYID =
		new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBynameAndHoliDayId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @return the matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId) {
		return findBynameAndHoliDayId(holidayName, holidayId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @return the range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end) {
		return findBynameAndHoliDayId(holidayName, holidayId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return findBynameAndHoliDayId(holidayName, holidayId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBynameAndHoliDayId(
		String holidayName, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDHOLIDAYID;
		finderArgs = new Object[] {
				holidayName, holidayId,
				
				start, end, orderByComparator
			};

		List<HolidayCalenderManagement> list = null;

		if (retrieveFromCache) {
			list = (List<HolidayCalenderManagement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HolidayCalenderManagement holidayCalenderManagement : list) {
					if (!Objects.equals(holidayName,
								holidayCalenderManagement.getHolidayName()) ||
							(holidayId == holidayCalenderManagement.getHolidayId())) {
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

			query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayName = false;

			if (holidayName == null) {
				query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_1);
			}
			else if (holidayName.equals("")) {
				query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_3);
			}
			else {
				bindHolidayName = true;

				query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HolidayCalenderManagementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayName) {
					qPos.add(holidayName);
				}

				qPos.add(holidayId);

				if (!pagination) {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
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
	 * Returns the first holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findBynameAndHoliDayId_First(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchBynameAndHoliDayId_First(holidayName,
				holidayId, orderByComparator);

		if (holidayCalenderManagement != null) {
			return holidayCalenderManagement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holidayName=");
		msg.append(holidayName);

		msg.append(", holidayId=");
		msg.append(holidayId);

		msg.append("}");

		throw new NoSuchHolidayCalenderManagementException(msg.toString());
	}

	/**
	 * Returns the first holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchBynameAndHoliDayId_First(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		List<HolidayCalenderManagement> list = findBynameAndHoliDayId(holidayName,
				holidayId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findBynameAndHoliDayId_Last(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchBynameAndHoliDayId_Last(holidayName,
				holidayId, orderByComparator);

		if (holidayCalenderManagement != null) {
			return holidayCalenderManagement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holidayName=");
		msg.append(holidayName);

		msg.append(", holidayId=");
		msg.append(holidayId);

		msg.append("}");

		throw new NoSuchHolidayCalenderManagementException(msg.toString());
	}

	/**
	 * Returns the last holiday calender management in the ordered set where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchBynameAndHoliDayId_Last(
		String holidayName, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		int count = countBynameAndHoliDayId(holidayName, holidayId);

		if (count == 0) {
			return null;
		}

		List<HolidayCalenderManagement> list = findBynameAndHoliDayId(holidayName,
				holidayId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the holiday calender managements where holidayName = &#63; and holidayId &ne; &#63; from the database.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 */
	@Override
	public void removeBynameAndHoliDayId(String holidayName, long holidayId) {
		for (HolidayCalenderManagement holidayCalenderManagement : findBynameAndHoliDayId(
				holidayName, holidayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(holidayCalenderManagement);
		}
	}

	/**
	 * Returns the number of holiday calender managements where holidayName = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayName the holiday name
	 * @param holidayId the holiday ID
	 * @return the number of matching holiday calender managements
	 */
	@Override
	public int countBynameAndHoliDayId(String holidayName, long holidayId) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMEANDHOLIDAYID;

		Object[] finderArgs = new Object[] { holidayName, holidayId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayName = false;

			if (holidayName == null) {
				query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_1);
			}
			else if (holidayName.equals("")) {
				query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_3);
			}
			else {
				bindHolidayName = true;

				query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayName) {
					qPos.add(holidayName);
				}

				qPos.add(holidayId);

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

	private static final String _FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_1 = "holidayCalenderManagement.holidayName IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_2 = "holidayCalenderManagement.holidayName = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYNAME_3 = "(holidayCalenderManagement.holidayName IS NULL OR holidayCalenderManagement.holidayName = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDHOLIDAYID_HOLIDAYID_2 = "holidayCalenderManagement.holidayId != ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEANDHOLIDAYID =
		new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydateAndHoliDayId",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATEANDHOLIDAYID =
		new FinderPath(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBydateAndHoliDayId",
			new String[] { Date.class.getName(), Long.class.getName() });

	/**
	 * Returns all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @return the matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId) {
		return findBydateAndHoliDayId(holidayDate, holidayId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @return the range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end) {
		return findBydateAndHoliDayId(holidayDate, holidayId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return findBydateAndHoliDayId(holidayDate, holidayId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findBydateAndHoliDayId(
		Date holidayDate, long holidayId, int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEANDHOLIDAYID;
		finderArgs = new Object[] {
				_getTime(holidayDate), holidayId,
				
				start, end, orderByComparator
			};

		List<HolidayCalenderManagement> list = null;

		if (retrieveFromCache) {
			list = (List<HolidayCalenderManagement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HolidayCalenderManagement holidayCalenderManagement : list) {
					if (!Objects.equals(holidayDate,
								holidayCalenderManagement.getHolidayDate()) ||
							(holidayId == holidayCalenderManagement.getHolidayId())) {
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

			query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayDate = false;

			if (holidayDate == null) {
				query.append(_FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYDATE_1);
			}
			else {
				bindHolidayDate = true;

				query.append(_FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYDATE_2);
			}

			query.append(_FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HolidayCalenderManagementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayDate) {
					qPos.add(new Timestamp(holidayDate.getTime()));
				}

				qPos.add(holidayId);

				if (!pagination) {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
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
	 * Returns the first holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findBydateAndHoliDayId_First(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchBydateAndHoliDayId_First(holidayDate,
				holidayId, orderByComparator);

		if (holidayCalenderManagement != null) {
			return holidayCalenderManagement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holidayDate=");
		msg.append(holidayDate);

		msg.append(", holidayId=");
		msg.append(holidayId);

		msg.append("}");

		throw new NoSuchHolidayCalenderManagementException(msg.toString());
	}

	/**
	 * Returns the first holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchBydateAndHoliDayId_First(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		List<HolidayCalenderManagement> list = findBydateAndHoliDayId(holidayDate,
				holidayId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement findBydateAndHoliDayId_Last(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchBydateAndHoliDayId_Last(holidayDate,
				holidayId, orderByComparator);

		if (holidayCalenderManagement != null) {
			return holidayCalenderManagement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("holidayDate=");
		msg.append(holidayDate);

		msg.append(", holidayId=");
		msg.append(holidayId);

		msg.append("}");

		throw new NoSuchHolidayCalenderManagementException(msg.toString());
	}

	/**
	 * Returns the last holiday calender management in the ordered set where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching holiday calender management, or <code>null</code> if a matching holiday calender management could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchBydateAndHoliDayId_Last(
		Date holidayDate, long holidayId,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		int count = countBydateAndHoliDayId(holidayDate, holidayId);

		if (count == 0) {
			return null;
		}

		List<HolidayCalenderManagement> list = findBydateAndHoliDayId(holidayDate,
				holidayId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63; from the database.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 */
	@Override
	public void removeBydateAndHoliDayId(Date holidayDate, long holidayId) {
		for (HolidayCalenderManagement holidayCalenderManagement : findBydateAndHoliDayId(
				holidayDate, holidayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(holidayCalenderManagement);
		}
	}

	/**
	 * Returns the number of holiday calender managements where holidayDate = &#63; and holidayId &ne; &#63;.
	 *
	 * @param holidayDate the holiday date
	 * @param holidayId the holiday ID
	 * @return the number of matching holiday calender managements
	 */
	@Override
	public int countBydateAndHoliDayId(Date holidayDate, long holidayId) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DATEANDHOLIDAYID;

		Object[] finderArgs = new Object[] { _getTime(holidayDate), holidayId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOLIDAYCALENDERMANAGEMENT_WHERE);

			boolean bindHolidayDate = false;

			if (holidayDate == null) {
				query.append(_FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYDATE_1);
			}
			else {
				bindHolidayDate = true;

				query.append(_FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYDATE_2);
			}

			query.append(_FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHolidayDate) {
					qPos.add(new Timestamp(holidayDate.getTime()));
				}

				qPos.add(holidayId);

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

	private static final String _FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYDATE_1 = "holidayCalenderManagement.holidayDate IS NULL AND ";
	private static final String _FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYDATE_2 = "holidayCalenderManagement.holidayDate = ? AND ";
	private static final String _FINDER_COLUMN_DATEANDHOLIDAYID_HOLIDAYID_2 = "holidayCalenderManagement.holidayId != ?";

	public HolidayCalenderManagementPersistenceImpl() {
		setModelClass(HolidayCalenderManagement.class);
	}

	/**
	 * Caches the holiday calender management in the entity cache if it is enabled.
	 *
	 * @param holidayCalenderManagement the holiday calender management
	 */
	@Override
	public void cacheResult(HolidayCalenderManagement holidayCalenderManagement) {
		entityCache.putResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			holidayCalenderManagement.getPrimaryKey(), holidayCalenderManagement);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE,
			new Object[] { holidayCalenderManagement.getHolidayDate() },
			holidayCalenderManagement);

		holidayCalenderManagement.resetOriginalValues();
	}

	/**
	 * Caches the holiday calender managements in the entity cache if it is enabled.
	 *
	 * @param holidayCalenderManagements the holiday calender managements
	 */
	@Override
	public void cacheResult(
		List<HolidayCalenderManagement> holidayCalenderManagements) {
		for (HolidayCalenderManagement holidayCalenderManagement : holidayCalenderManagements) {
			if (entityCache.getResult(
						HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
						HolidayCalenderManagementImpl.class,
						holidayCalenderManagement.getPrimaryKey()) == null) {
				cacheResult(holidayCalenderManagement);
			}
			else {
				holidayCalenderManagement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all holiday calender managements.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HolidayCalenderManagementImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the holiday calender management.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HolidayCalenderManagement holidayCalenderManagement) {
		entityCache.removeResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			holidayCalenderManagement.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((HolidayCalenderManagementModelImpl)holidayCalenderManagement,
			true);
	}

	@Override
	public void clearCache(
		List<HolidayCalenderManagement> holidayCalenderManagements) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HolidayCalenderManagement holidayCalenderManagement : holidayCalenderManagements) {
			entityCache.removeResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
				HolidayCalenderManagementImpl.class,
				holidayCalenderManagement.getPrimaryKey());

			clearUniqueFindersCache((HolidayCalenderManagementModelImpl)holidayCalenderManagement,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		HolidayCalenderManagementModelImpl holidayCalenderManagementModelImpl) {
		Object[] args = new Object[] {
				_getTime(holidayCalenderManagementModelImpl.getHolidayDate())
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args,
			holidayCalenderManagementModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		HolidayCalenderManagementModelImpl holidayCalenderManagementModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					_getTime(holidayCalenderManagementModelImpl.getHolidayDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}

		if ((holidayCalenderManagementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPIDANDATTDATE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					_getTime(holidayCalenderManagementModelImpl.getOriginalHolidayDate())
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPIDANDATTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPIDANDATTDATE, args);
		}
	}

	/**
	 * Creates a new holiday calender management with the primary key. Does not add the holiday calender management to the database.
	 *
	 * @param holidayId the primary key for the new holiday calender management
	 * @return the new holiday calender management
	 */
	@Override
	public HolidayCalenderManagement create(long holidayId) {
		HolidayCalenderManagement holidayCalenderManagement = new HolidayCalenderManagementImpl();

		holidayCalenderManagement.setNew(true);
		holidayCalenderManagement.setPrimaryKey(holidayId);

		holidayCalenderManagement.setCompanyId(companyProvider.getCompanyId());

		return holidayCalenderManagement;
	}

	/**
	 * Removes the holiday calender management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayId the primary key of the holiday calender management
	 * @return the holiday calender management that was removed
	 * @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement remove(long holidayId)
		throws NoSuchHolidayCalenderManagementException {
		return remove((Serializable)holidayId);
	}

	/**
	 * Removes the holiday calender management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the holiday calender management
	 * @return the holiday calender management that was removed
	 * @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement remove(Serializable primaryKey)
		throws NoSuchHolidayCalenderManagementException {
		Session session = null;

		try {
			session = openSession();

			HolidayCalenderManagement holidayCalenderManagement = (HolidayCalenderManagement)session.get(HolidayCalenderManagementImpl.class,
					primaryKey);

			if (holidayCalenderManagement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHolidayCalenderManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(holidayCalenderManagement);
		}
		catch (NoSuchHolidayCalenderManagementException nsee) {
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
	protected HolidayCalenderManagement removeImpl(
		HolidayCalenderManagement holidayCalenderManagement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(holidayCalenderManagement)) {
				holidayCalenderManagement = (HolidayCalenderManagement)session.get(HolidayCalenderManagementImpl.class,
						holidayCalenderManagement.getPrimaryKeyObj());
			}

			if (holidayCalenderManagement != null) {
				session.delete(holidayCalenderManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (holidayCalenderManagement != null) {
			clearCache(holidayCalenderManagement);
		}

		return holidayCalenderManagement;
	}

	@Override
	public HolidayCalenderManagement updateImpl(
		HolidayCalenderManagement holidayCalenderManagement) {
		boolean isNew = holidayCalenderManagement.isNew();

		if (!(holidayCalenderManagement instanceof HolidayCalenderManagementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(holidayCalenderManagement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(holidayCalenderManagement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in holidayCalenderManagement proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HolidayCalenderManagement implementation " +
				holidayCalenderManagement.getClass());
		}

		HolidayCalenderManagementModelImpl holidayCalenderManagementModelImpl = (HolidayCalenderManagementModelImpl)holidayCalenderManagement;

		Session session = null;

		try {
			session = openSession();

			if (holidayCalenderManagement.isNew()) {
				session.save(holidayCalenderManagement);

				holidayCalenderManagement.setNew(false);
			}
			else {
				holidayCalenderManagement = (HolidayCalenderManagement)session.merge(holidayCalenderManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HolidayCalenderManagementModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					holidayCalenderManagementModelImpl.getHolidayDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_HOLIDAYCHECK, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYCHECK,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((holidayCalenderManagementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYCHECK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						holidayCalenderManagementModelImpl.getOriginalHolidayDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_HOLIDAYCHECK, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYCHECK,
					args);

				args = new Object[] {
						holidayCalenderManagementModelImpl.getHolidayDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_HOLIDAYCHECK, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HOLIDAYCHECK,
					args);
			}
		}

		entityCache.putResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
			HolidayCalenderManagementImpl.class,
			holidayCalenderManagement.getPrimaryKey(),
			holidayCalenderManagement, false);

		clearUniqueFindersCache(holidayCalenderManagementModelImpl, false);
		cacheUniqueFindersCache(holidayCalenderManagementModelImpl);

		holidayCalenderManagement.resetOriginalValues();

		return holidayCalenderManagement;
	}

	/**
	 * Returns the holiday calender management with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the holiday calender management
	 * @return the holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHolidayCalenderManagementException {
		HolidayCalenderManagement holidayCalenderManagement = fetchByPrimaryKey(primaryKey);

		if (holidayCalenderManagement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHolidayCalenderManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return holidayCalenderManagement;
	}

	/**
	 * Returns the holiday calender management with the primary key or throws a {@link NoSuchHolidayCalenderManagementException} if it could not be found.
	 *
	 * @param holidayId the primary key of the holiday calender management
	 * @return the holiday calender management
	 * @throws NoSuchHolidayCalenderManagementException if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement findByPrimaryKey(long holidayId)
		throws NoSuchHolidayCalenderManagementException {
		return findByPrimaryKey((Serializable)holidayId);
	}

	/**
	 * Returns the holiday calender management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the holiday calender management
	 * @return the holiday calender management, or <code>null</code> if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
				HolidayCalenderManagementImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		HolidayCalenderManagement holidayCalenderManagement = (HolidayCalenderManagement)serializable;

		if (holidayCalenderManagement == null) {
			Session session = null;

			try {
				session = openSession();

				holidayCalenderManagement = (HolidayCalenderManagement)session.get(HolidayCalenderManagementImpl.class,
						primaryKey);

				if (holidayCalenderManagement != null) {
					cacheResult(holidayCalenderManagement);
				}
				else {
					entityCache.putResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
						HolidayCalenderManagementImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
					HolidayCalenderManagementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return holidayCalenderManagement;
	}

	/**
	 * Returns the holiday calender management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param holidayId the primary key of the holiday calender management
	 * @return the holiday calender management, or <code>null</code> if a holiday calender management with the primary key could not be found
	 */
	@Override
	public HolidayCalenderManagement fetchByPrimaryKey(long holidayId) {
		return fetchByPrimaryKey((Serializable)holidayId);
	}

	@Override
	public Map<Serializable, HolidayCalenderManagement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, HolidayCalenderManagement> map = new HashMap<Serializable, HolidayCalenderManagement>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			HolidayCalenderManagement holidayCalenderManagement = fetchByPrimaryKey(primaryKey);

			if (holidayCalenderManagement != null) {
				map.put(primaryKey, holidayCalenderManagement);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
					HolidayCalenderManagementImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (HolidayCalenderManagement)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE_PKS_IN);

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

			for (HolidayCalenderManagement holidayCalenderManagement : (List<HolidayCalenderManagement>)q.list()) {
				map.put(holidayCalenderManagement.getPrimaryKeyObj(),
					holidayCalenderManagement);

				cacheResult(holidayCalenderManagement);

				uncachedPrimaryKeys.remove(holidayCalenderManagement.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(HolidayCalenderManagementModelImpl.ENTITY_CACHE_ENABLED,
					HolidayCalenderManagementImpl.class, primaryKey, nullModel);
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
	 * Returns all the holiday calender managements.
	 *
	 * @return the holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the holiday calender managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @return the range of holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findAll(int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the holiday calender managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HolidayCalenderManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of holiday calender managements
	 * @param end the upper bound of the range of holiday calender managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of holiday calender managements
	 */
	@Override
	public List<HolidayCalenderManagement> findAll(int start, int end,
		OrderByComparator<HolidayCalenderManagement> orderByComparator,
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

		List<HolidayCalenderManagement> list = null;

		if (retrieveFromCache) {
			list = (List<HolidayCalenderManagement>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HOLIDAYCALENDERMANAGEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOLIDAYCALENDERMANAGEMENT;

				if (pagination) {
					sql = sql.concat(HolidayCalenderManagementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HolidayCalenderManagement>)QueryUtil.list(q,
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
	 * Removes all the holiday calender managements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HolidayCalenderManagement holidayCalenderManagement : findAll()) {
			remove(holidayCalenderManagement);
		}
	}

	/**
	 * Returns the number of holiday calender managements.
	 *
	 * @return the number of holiday calender managements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HOLIDAYCALENDERMANAGEMENT);

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
		return HolidayCalenderManagementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the holiday calender management persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(HolidayCalenderManagementImpl.class.getName());
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

	private static final String _SQL_SELECT_HOLIDAYCALENDERMANAGEMENT = "SELECT holidayCalenderManagement FROM HolidayCalenderManagement holidayCalenderManagement";
	private static final String _SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE_PKS_IN =
		"SELECT holidayCalenderManagement FROM HolidayCalenderManagement holidayCalenderManagement WHERE holidayId IN (";
	private static final String _SQL_SELECT_HOLIDAYCALENDERMANAGEMENT_WHERE = "SELECT holidayCalenderManagement FROM HolidayCalenderManagement holidayCalenderManagement WHERE ";
	private static final String _SQL_COUNT_HOLIDAYCALENDERMANAGEMENT = "SELECT COUNT(holidayCalenderManagement) FROM HolidayCalenderManagement holidayCalenderManagement";
	private static final String _SQL_COUNT_HOLIDAYCALENDERMANAGEMENT_WHERE = "SELECT COUNT(holidayCalenderManagement) FROM HolidayCalenderManagement holidayCalenderManagement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "holidayCalenderManagement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HolidayCalenderManagement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HolidayCalenderManagement exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(HolidayCalenderManagementPersistenceImpl.class);
}