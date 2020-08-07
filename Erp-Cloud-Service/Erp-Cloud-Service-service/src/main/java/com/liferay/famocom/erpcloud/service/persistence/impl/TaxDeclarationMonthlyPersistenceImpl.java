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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationMonthlyException;
import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;
import com.liferay.famocom.erpcloud.model.impl.TaxDeclarationMonthlyImpl;
import com.liferay.famocom.erpcloud.model.impl.TaxDeclarationMonthlyModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TaxDeclarationMonthlyPersistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tax declaration monthly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationMonthlyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TaxDeclarationMonthlyUtil
 * @generated
 */
@ProviderType
public class TaxDeclarationMonthlyPersistenceImpl extends BasePersistenceImpl<TaxDeclarationMonthly>
	implements TaxDeclarationMonthlyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxDeclarationMonthlyUtil} to access the tax declaration monthly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxDeclarationMonthlyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID = new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBymonthYearAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TaxDeclarationMonthlyModelImpl.MONTHYEAR_COLUMN_BITMASK |
			TaxDeclarationMonthlyModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID = new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymonthYearAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or throws a {@link NoSuchTaxDeclarationMonthlyException} if it could not be found.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the matching tax declaration monthly
	 * @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly findBymonthYearAndemployeeId(long monthYear,
		long employeeId) throws NoSuchTaxDeclarationMonthlyException {
		TaxDeclarationMonthly taxDeclarationMonthly = fetchBymonthYearAndemployeeId(monthYear,
				employeeId);

		if (taxDeclarationMonthly == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("monthYear=");
			msg.append(monthYear);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTaxDeclarationMonthlyException(msg.toString());
		}

		return taxDeclarationMonthly;
	}

	/**
	 * Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly fetchBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		return fetchBymonthYearAndemployeeId(monthYear, employeeId, true);
	}

	/**
	 * Returns the tax declaration monthly where monthYear = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly fetchBymonthYearAndemployeeId(long monthYear,
		long employeeId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { monthYear, employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof TaxDeclarationMonthly) {
			TaxDeclarationMonthly taxDeclarationMonthly = (TaxDeclarationMonthly)result;

			if ((monthYear != taxDeclarationMonthly.getMonthYear()) ||
					(employeeId != taxDeclarationMonthly.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(employeeId);

				List<TaxDeclarationMonthly> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TaxDeclarationMonthlyPersistenceImpl.fetchBymonthYearAndemployeeId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TaxDeclarationMonthly taxDeclarationMonthly = list.get(0);

					result = taxDeclarationMonthly;

					cacheResult(taxDeclarationMonthly);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
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
			return (TaxDeclarationMonthly)result;
		}
	}

	/**
	 * Removes the tax declaration monthly where monthYear = &#63; and employeeId = &#63; from the database.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the tax declaration monthly that was removed
	 */
	@Override
	public TaxDeclarationMonthly removeBymonthYearAndemployeeId(
		long monthYear, long employeeId)
		throws NoSuchTaxDeclarationMonthlyException {
		TaxDeclarationMonthly taxDeclarationMonthly = findBymonthYearAndemployeeId(monthYear,
				employeeId);

		return remove(taxDeclarationMonthly);
	}

	/**
	 * Returns the number of tax declaration monthlies where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the number of matching tax declaration monthlies
	 */
	@Override
	public int countBymonthYearAndemployeeId(long monthYear, long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { monthYear, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAXDECLARATIONMONTHLY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2 =
		"taxDeclarationMonthly.monthYear = ? AND ";
	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2 =
		"taxDeclarationMonthly.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR =
		new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeIdAndMonthYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR =
		new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() },
			TaxDeclarationMonthlyModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			TaxDeclarationMonthlyModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR = new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEAR =
		new FinderPath(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear) {
		return findByemployeeIdAndMonthYear(employeeId, monthYear,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @return the range of matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end) {
		return findByemployeeIdAndMonthYear(employeeId, monthYear, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return findByemployeeIdAndMonthYear(employeeId, monthYear, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long monthYear, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR;
			finderArgs = new Object[] { employeeId, monthYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR;
			finderArgs = new Object[] {
					employeeId, monthYear,
					
					start, end, orderByComparator
				};
		}

		List<TaxDeclarationMonthly> list = null;

		if (retrieveFromCache) {
			list = (List<TaxDeclarationMonthly>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaxDeclarationMonthly taxDeclarationMonthly : list) {
					if ((employeeId != taxDeclarationMonthly.getEmployeeId()) ||
							(monthYear != taxDeclarationMonthly.getMonthYear())) {
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

			query.append(_SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TaxDeclarationMonthlyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(monthYear);

				if (!pagination) {
					list = (List<TaxDeclarationMonthly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxDeclarationMonthly>)QueryUtil.list(q,
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
	 * Returns the first tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tax declaration monthly
	 * @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly findByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws NoSuchTaxDeclarationMonthlyException {
		TaxDeclarationMonthly taxDeclarationMonthly = fetchByemployeeIdAndMonthYear_First(employeeId,
				monthYear, orderByComparator);

		if (taxDeclarationMonthly != null) {
			return taxDeclarationMonthly;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchTaxDeclarationMonthlyException(msg.toString());
	}

	/**
	 * Returns the first tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly fetchByemployeeIdAndMonthYear_First(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		List<TaxDeclarationMonthly> list = findByemployeeIdAndMonthYear(employeeId,
				monthYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tax declaration monthly
	 * @throws NoSuchTaxDeclarationMonthlyException if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly findByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws NoSuchTaxDeclarationMonthlyException {
		TaxDeclarationMonthly taxDeclarationMonthly = fetchByemployeeIdAndMonthYear_Last(employeeId,
				monthYear, orderByComparator);

		if (taxDeclarationMonthly != null) {
			return taxDeclarationMonthly;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchTaxDeclarationMonthlyException(msg.toString());
	}

	/**
	 * Returns the last tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tax declaration monthly, or <code>null</code> if a matching tax declaration monthly could not be found
	 */
	@Override
	public TaxDeclarationMonthly fetchByemployeeIdAndMonthYear_Last(
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		int count = countByemployeeIdAndMonthYear(employeeId, monthYear);

		if (count == 0) {
			return null;
		}

		List<TaxDeclarationMonthly> list = findByemployeeIdAndMonthYear(employeeId,
				monthYear, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tax declaration monthlies before and after the current tax declaration monthly in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param taxDeclarationMonthlyId the primary key of the current tax declaration monthly
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tax declaration monthly
	 * @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly[] findByemployeeIdAndMonthYear_PrevAndNext(
		long taxDeclarationMonthlyId, long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator)
		throws NoSuchTaxDeclarationMonthlyException {
		TaxDeclarationMonthly taxDeclarationMonthly = findByPrimaryKey(taxDeclarationMonthlyId);

		Session session = null;

		try {
			session = openSession();

			TaxDeclarationMonthly[] array = new TaxDeclarationMonthlyImpl[3];

			array[0] = getByemployeeIdAndMonthYear_PrevAndNext(session,
					taxDeclarationMonthly, employeeId, monthYear,
					orderByComparator, true);

			array[1] = taxDeclarationMonthly;

			array[2] = getByemployeeIdAndMonthYear_PrevAndNext(session,
					taxDeclarationMonthly, employeeId, monthYear,
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

	protected TaxDeclarationMonthly getByemployeeIdAndMonthYear_PrevAndNext(
		Session session, TaxDeclarationMonthly taxDeclarationMonthly,
		long employeeId, long monthYear,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2);

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
			query.append(TaxDeclarationMonthlyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taxDeclarationMonthly);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaxDeclarationMonthly> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @return the matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears) {
		return findByemployeeIdAndMonthYear(employeeId, monthYears,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @return the range of matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end) {
		return findByemployeeIdAndMonthYear(employeeId, monthYears, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return findByemployeeIdAndMonthYear(employeeId, monthYears, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findByemployeeIdAndMonthYear(
		long employeeId, long[] monthYears, int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
		boolean retrieveFromCache) {
		if (monthYears == null) {
			monthYears = new long[0];
		}
		else if (monthYears.length > 1) {
			monthYears = ArrayUtil.unique(monthYears);

			Arrays.sort(monthYears);
		}

		if (monthYears.length == 1) {
			return findByemployeeIdAndMonthYear(employeeId, monthYears[0],
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { employeeId, StringUtil.merge(monthYears) };
		}
		else {
			finderArgs = new Object[] {
					employeeId, StringUtil.merge(monthYears),
					
					start, end, orderByComparator
				};
		}

		List<TaxDeclarationMonthly> list = null;

		if (retrieveFromCache) {
			list = (List<TaxDeclarationMonthly>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaxDeclarationMonthly taxDeclarationMonthly : list) {
					if ((employeeId != taxDeclarationMonthly.getEmployeeId()) ||
							!ArrayUtil.contains(monthYears,
								taxDeclarationMonthly.getMonthYear())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			if (monthYears.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_7);

				query.append(StringUtil.merge(monthYears));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TaxDeclarationMonthlyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<TaxDeclarationMonthly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxDeclarationMonthly>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tax declaration monthlies where employeeId = &#63; and monthYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 */
	@Override
	public void removeByemployeeIdAndMonthYear(long employeeId, long monthYear) {
		for (TaxDeclarationMonthly taxDeclarationMonthly : findByemployeeIdAndMonthYear(
				employeeId, monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(taxDeclarationMonthly);
		}
	}

	/**
	 * Returns the number of tax declaration monthlies where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the number of matching tax declaration monthlies
	 */
	@Override
	public int countByemployeeIdAndMonthYear(long employeeId, long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR;

		Object[] finderArgs = new Object[] { employeeId, monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAXDECLARATIONMONTHLY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(monthYear);

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

	/**
	 * Returns the number of tax declaration monthlies where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @return the number of matching tax declaration monthlies
	 */
	@Override
	public int countByemployeeIdAndMonthYear(long employeeId, long[] monthYears) {
		if (monthYears == null) {
			monthYears = new long[0];
		}
		else if (monthYears.length > 1) {
			monthYears = ArrayUtil.unique(monthYears);

			Arrays.sort(monthYears);
		}

		Object[] finderArgs = new Object[] {
				employeeId, StringUtil.merge(monthYears)
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TAXDECLARATIONMONTHLY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			if (monthYears.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_7);

				query.append(StringUtil.merge(monthYears));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2 =
		"taxDeclarationMonthly.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2 =
		"taxDeclarationMonthly.monthYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_7 =
		"taxDeclarationMonthly.monthYear IN (";

	public TaxDeclarationMonthlyPersistenceImpl() {
		setModelClass(TaxDeclarationMonthly.class);
	}

	/**
	 * Caches the tax declaration monthly in the entity cache if it is enabled.
	 *
	 * @param taxDeclarationMonthly the tax declaration monthly
	 */
	@Override
	public void cacheResult(TaxDeclarationMonthly taxDeclarationMonthly) {
		entityCache.putResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			taxDeclarationMonthly.getPrimaryKey(), taxDeclarationMonthly);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
			new Object[] {
				taxDeclarationMonthly.getMonthYear(),
				taxDeclarationMonthly.getEmployeeId()
			}, taxDeclarationMonthly);

		taxDeclarationMonthly.resetOriginalValues();
	}

	/**
	 * Caches the tax declaration monthlies in the entity cache if it is enabled.
	 *
	 * @param taxDeclarationMonthlies the tax declaration monthlies
	 */
	@Override
	public void cacheResult(List<TaxDeclarationMonthly> taxDeclarationMonthlies) {
		for (TaxDeclarationMonthly taxDeclarationMonthly : taxDeclarationMonthlies) {
			if (entityCache.getResult(
						TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
						TaxDeclarationMonthlyImpl.class,
						taxDeclarationMonthly.getPrimaryKey()) == null) {
				cacheResult(taxDeclarationMonthly);
			}
			else {
				taxDeclarationMonthly.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tax declaration monthlies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaxDeclarationMonthlyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tax declaration monthly.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxDeclarationMonthly taxDeclarationMonthly) {
		entityCache.removeResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			taxDeclarationMonthly.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TaxDeclarationMonthlyModelImpl)taxDeclarationMonthly,
			true);
	}

	@Override
	public void clearCache(List<TaxDeclarationMonthly> taxDeclarationMonthlies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxDeclarationMonthly taxDeclarationMonthly : taxDeclarationMonthlies) {
			entityCache.removeResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
				TaxDeclarationMonthlyImpl.class,
				taxDeclarationMonthly.getPrimaryKey());

			clearUniqueFindersCache((TaxDeclarationMonthlyModelImpl)taxDeclarationMonthly,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TaxDeclarationMonthlyModelImpl taxDeclarationMonthlyModelImpl) {
		Object[] args = new Object[] {
				taxDeclarationMonthlyModelImpl.getMonthYear(),
				taxDeclarationMonthlyModelImpl.getEmployeeId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
			args, taxDeclarationMonthlyModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TaxDeclarationMonthlyModelImpl taxDeclarationMonthlyModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					taxDeclarationMonthlyModelImpl.getMonthYear(),
					taxDeclarationMonthlyModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
				args);
		}

		if ((taxDeclarationMonthlyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					taxDeclarationMonthlyModelImpl.getOriginalMonthYear(),
					taxDeclarationMonthlyModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEARANDEMPLOYEEID,
				args);
		}
	}

	/**
	 * Creates a new tax declaration monthly with the primary key. Does not add the tax declaration monthly to the database.
	 *
	 * @param taxDeclarationMonthlyId the primary key for the new tax declaration monthly
	 * @return the new tax declaration monthly
	 */
	@Override
	public TaxDeclarationMonthly create(long taxDeclarationMonthlyId) {
		TaxDeclarationMonthly taxDeclarationMonthly = new TaxDeclarationMonthlyImpl();

		taxDeclarationMonthly.setNew(true);
		taxDeclarationMonthly.setPrimaryKey(taxDeclarationMonthlyId);

		taxDeclarationMonthly.setCompanyId(companyProvider.getCompanyId());

		return taxDeclarationMonthly;
	}

	/**
	 * Removes the tax declaration monthly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	 * @return the tax declaration monthly that was removed
	 * @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly remove(long taxDeclarationMonthlyId)
		throws NoSuchTaxDeclarationMonthlyException {
		return remove((Serializable)taxDeclarationMonthlyId);
	}

	/**
	 * Removes the tax declaration monthly with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tax declaration monthly
	 * @return the tax declaration monthly that was removed
	 * @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly remove(Serializable primaryKey)
		throws NoSuchTaxDeclarationMonthlyException {
		Session session = null;

		try {
			session = openSession();

			TaxDeclarationMonthly taxDeclarationMonthly = (TaxDeclarationMonthly)session.get(TaxDeclarationMonthlyImpl.class,
					primaryKey);

			if (taxDeclarationMonthly == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxDeclarationMonthlyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxDeclarationMonthly);
		}
		catch (NoSuchTaxDeclarationMonthlyException nsee) {
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
	protected TaxDeclarationMonthly removeImpl(
		TaxDeclarationMonthly taxDeclarationMonthly) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxDeclarationMonthly)) {
				taxDeclarationMonthly = (TaxDeclarationMonthly)session.get(TaxDeclarationMonthlyImpl.class,
						taxDeclarationMonthly.getPrimaryKeyObj());
			}

			if (taxDeclarationMonthly != null) {
				session.delete(taxDeclarationMonthly);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxDeclarationMonthly != null) {
			clearCache(taxDeclarationMonthly);
		}

		return taxDeclarationMonthly;
	}

	@Override
	public TaxDeclarationMonthly updateImpl(
		TaxDeclarationMonthly taxDeclarationMonthly) {
		boolean isNew = taxDeclarationMonthly.isNew();

		if (!(taxDeclarationMonthly instanceof TaxDeclarationMonthlyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taxDeclarationMonthly.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(taxDeclarationMonthly);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taxDeclarationMonthly proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaxDeclarationMonthly implementation " +
				taxDeclarationMonthly.getClass());
		}

		TaxDeclarationMonthlyModelImpl taxDeclarationMonthlyModelImpl = (TaxDeclarationMonthlyModelImpl)taxDeclarationMonthly;

		Session session = null;

		try {
			session = openSession();

			if (taxDeclarationMonthly.isNew()) {
				session.save(taxDeclarationMonthly);

				taxDeclarationMonthly.setNew(false);
			}
			else {
				taxDeclarationMonthly = (TaxDeclarationMonthly)session.merge(taxDeclarationMonthly);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TaxDeclarationMonthlyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					taxDeclarationMonthlyModelImpl.getEmployeeId(),
					taxDeclarationMonthlyModelImpl.getMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((taxDeclarationMonthlyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taxDeclarationMonthlyModelImpl.getOriginalEmployeeId(),
						taxDeclarationMonthlyModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					args);

				args = new Object[] {
						taxDeclarationMonthlyModelImpl.getEmployeeId(),
						taxDeclarationMonthlyModelImpl.getMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					args);
			}
		}

		entityCache.putResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationMonthlyImpl.class,
			taxDeclarationMonthly.getPrimaryKey(), taxDeclarationMonthly, false);

		clearUniqueFindersCache(taxDeclarationMonthlyModelImpl, false);
		cacheUniqueFindersCache(taxDeclarationMonthlyModelImpl);

		taxDeclarationMonthly.resetOriginalValues();

		return taxDeclarationMonthly;
	}

	/**
	 * Returns the tax declaration monthly with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax declaration monthly
	 * @return the tax declaration monthly
	 * @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxDeclarationMonthlyException {
		TaxDeclarationMonthly taxDeclarationMonthly = fetchByPrimaryKey(primaryKey);

		if (taxDeclarationMonthly == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxDeclarationMonthlyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxDeclarationMonthly;
	}

	/**
	 * Returns the tax declaration monthly with the primary key or throws a {@link NoSuchTaxDeclarationMonthlyException} if it could not be found.
	 *
	 * @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	 * @return the tax declaration monthly
	 * @throws NoSuchTaxDeclarationMonthlyException if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly findByPrimaryKey(long taxDeclarationMonthlyId)
		throws NoSuchTaxDeclarationMonthlyException {
		return findByPrimaryKey((Serializable)taxDeclarationMonthlyId);
	}

	/**
	 * Returns the tax declaration monthly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax declaration monthly
	 * @return the tax declaration monthly, or <code>null</code> if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
				TaxDeclarationMonthlyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaxDeclarationMonthly taxDeclarationMonthly = (TaxDeclarationMonthly)serializable;

		if (taxDeclarationMonthly == null) {
			Session session = null;

			try {
				session = openSession();

				taxDeclarationMonthly = (TaxDeclarationMonthly)session.get(TaxDeclarationMonthlyImpl.class,
						primaryKey);

				if (taxDeclarationMonthly != null) {
					cacheResult(taxDeclarationMonthly);
				}
				else {
					entityCache.putResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
						TaxDeclarationMonthlyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
					TaxDeclarationMonthlyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxDeclarationMonthly;
	}

	/**
	 * Returns the tax declaration monthly with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taxDeclarationMonthlyId the primary key of the tax declaration monthly
	 * @return the tax declaration monthly, or <code>null</code> if a tax declaration monthly with the primary key could not be found
	 */
	@Override
	public TaxDeclarationMonthly fetchByPrimaryKey(long taxDeclarationMonthlyId) {
		return fetchByPrimaryKey((Serializable)taxDeclarationMonthlyId);
	}

	@Override
	public Map<Serializable, TaxDeclarationMonthly> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaxDeclarationMonthly> map = new HashMap<Serializable, TaxDeclarationMonthly>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaxDeclarationMonthly taxDeclarationMonthly = fetchByPrimaryKey(primaryKey);

			if (taxDeclarationMonthly != null) {
				map.put(primaryKey, taxDeclarationMonthly);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
					TaxDeclarationMonthlyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaxDeclarationMonthly)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE_PKS_IN);

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

			for (TaxDeclarationMonthly taxDeclarationMonthly : (List<TaxDeclarationMonthly>)q.list()) {
				map.put(taxDeclarationMonthly.getPrimaryKeyObj(),
					taxDeclarationMonthly);

				cacheResult(taxDeclarationMonthly);

				uncachedPrimaryKeys.remove(taxDeclarationMonthly.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaxDeclarationMonthlyModelImpl.ENTITY_CACHE_ENABLED,
					TaxDeclarationMonthlyImpl.class, primaryKey, nullModel);
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
	 * Returns all the tax declaration monthlies.
	 *
	 * @return the tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax declaration monthlies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @return the range of tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tax declaration monthlies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findAll(int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tax declaration monthlies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationMonthlyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax declaration monthlies
	 * @param end the upper bound of the range of tax declaration monthlies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tax declaration monthlies
	 */
	@Override
	public List<TaxDeclarationMonthly> findAll(int start, int end,
		OrderByComparator<TaxDeclarationMonthly> orderByComparator,
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

		List<TaxDeclarationMonthly> list = null;

		if (retrieveFromCache) {
			list = (List<TaxDeclarationMonthly>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAXDECLARATIONMONTHLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXDECLARATIONMONTHLY;

				if (pagination) {
					sql = sql.concat(TaxDeclarationMonthlyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxDeclarationMonthly>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxDeclarationMonthly>)QueryUtil.list(q,
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
	 * Removes all the tax declaration monthlies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaxDeclarationMonthly taxDeclarationMonthly : findAll()) {
			remove(taxDeclarationMonthly);
		}
	}

	/**
	 * Returns the number of tax declaration monthlies.
	 *
	 * @return the number of tax declaration monthlies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAXDECLARATIONMONTHLY);

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
		return TaxDeclarationMonthlyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tax declaration monthly persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaxDeclarationMonthlyImpl.class.getName());
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
	private static final String _SQL_SELECT_TAXDECLARATIONMONTHLY = "SELECT taxDeclarationMonthly FROM TaxDeclarationMonthly taxDeclarationMonthly";
	private static final String _SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE_PKS_IN = "SELECT taxDeclarationMonthly FROM TaxDeclarationMonthly taxDeclarationMonthly WHERE taxDeclarationMonthlyId IN (";
	private static final String _SQL_SELECT_TAXDECLARATIONMONTHLY_WHERE = "SELECT taxDeclarationMonthly FROM TaxDeclarationMonthly taxDeclarationMonthly WHERE ";
	private static final String _SQL_COUNT_TAXDECLARATIONMONTHLY = "SELECT COUNT(taxDeclarationMonthly) FROM TaxDeclarationMonthly taxDeclarationMonthly";
	private static final String _SQL_COUNT_TAXDECLARATIONMONTHLY_WHERE = "SELECT COUNT(taxDeclarationMonthly) FROM TaxDeclarationMonthly taxDeclarationMonthly WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxDeclarationMonthly.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxDeclarationMonthly exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaxDeclarationMonthly exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TaxDeclarationMonthlyPersistenceImpl.class);
}