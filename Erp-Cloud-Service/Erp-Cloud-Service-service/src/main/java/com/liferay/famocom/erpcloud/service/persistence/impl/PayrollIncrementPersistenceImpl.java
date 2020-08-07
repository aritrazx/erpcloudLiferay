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

import com.liferay.famocom.erpcloud.exception.NoSuchPayrollIncrementException;
import com.liferay.famocom.erpcloud.model.PayrollIncrement;
import com.liferay.famocom.erpcloud.model.impl.PayrollIncrementImpl;
import com.liferay.famocom.erpcloud.model.impl.PayrollIncrementModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.PayrollIncrementPersistence;

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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the payroll increment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PayrollIncrementPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.PayrollIncrementUtil
 * @generated
 */
@ProviderType
public class PayrollIncrementPersistenceImpl extends BasePersistenceImpl<PayrollIncrement>
	implements PayrollIncrementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayrollIncrementUtil} to access the payroll increment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayrollIncrementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED,
			PayrollIncrementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED,
			PayrollIncrementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR =
		new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED,
			PayrollIncrementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemployeeIdComponentIdFinancialYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			PayrollIncrementModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			PayrollIncrementModelImpl.COMPONENTID_COLUMN_BITMASK |
			PayrollIncrementModelImpl.FINANCIALYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR =
		new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdComponentIdFinancialYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or throws a {@link NoSuchPayrollIncrementException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param financialYear the financial year
	 * @return the matching payroll increment
	 * @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement findByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws NoSuchPayrollIncrementException {
		PayrollIncrement payrollIncrement = fetchByemployeeIdComponentIdFinancialYear(employeeId,
				componentId, financialYear);

		if (payrollIncrement == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", componentId=");
			msg.append(componentId);

			msg.append(", financialYear=");
			msg.append(financialYear);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPayrollIncrementException(msg.toString());
		}

		return payrollIncrement;
	}

	/**
	 * Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param financialYear the financial year
	 * @return the matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement fetchByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear) {
		return fetchByemployeeIdComponentIdFinancialYear(employeeId,
			componentId, financialYear, true);
	}

	/**
	 * Returns the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param financialYear the financial year
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement fetchByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				employeeId, componentId, financialYear
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
					finderArgs, this);
		}

		if (result instanceof PayrollIncrement) {
			PayrollIncrement payrollIncrement = (PayrollIncrement)result;

			if ((employeeId != payrollIncrement.getEmployeeId()) ||
					(componentId != payrollIncrement.getComponentId()) ||
					!Objects.equals(financialYear,
						payrollIncrement.getFinancialYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PAYROLLINCREMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_COMPONENTID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

				if (bindFinancialYear) {
					qPos.add(financialYear);
				}

				List<PayrollIncrement> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PayrollIncrementPersistenceImpl.fetchByemployeeIdComponentIdFinancialYear(long, long, String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PayrollIncrement payrollIncrement = list.get(0);

					result = payrollIncrement;

					cacheResult(payrollIncrement);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
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
			return (PayrollIncrement)result;
		}
	}

	/**
	 * Removes the payroll increment where employeeId = &#63; and componentId = &#63; and financialYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param financialYear the financial year
	 * @return the payroll increment that was removed
	 */
	@Override
	public PayrollIncrement removeByemployeeIdComponentIdFinancialYear(
		long employeeId, long componentId, String financialYear)
		throws NoSuchPayrollIncrementException {
		PayrollIncrement payrollIncrement = findByemployeeIdComponentIdFinancialYear(employeeId,
				componentId, financialYear);

		return remove(payrollIncrement);
	}

	/**
	 * Returns the number of payroll increments where employeeId = &#63; and componentId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param financialYear the financial year
	 * @return the number of matching payroll increments
	 */
	@Override
	public int countByemployeeIdComponentIdFinancialYear(long employeeId,
		long componentId, String financialYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR;

		Object[] finderArgs = new Object[] {
				employeeId, componentId, financialYear
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PAYROLLINCREMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_COMPONENTID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

				if (bindFinancialYear) {
					qPos.add(financialYear);
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

	private static final String _FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_EMPLOYEEID_2 =
		"payrollIncrement.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_COMPONENTID_2 =
		"payrollIncrement.componentId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_1 =
		"payrollIncrement.financialYear IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_2 =
		"payrollIncrement.financialYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR_FINANCIALYEAR_3 =
		"(payrollIncrement.financialYear IS NULL OR payrollIncrement.financialYear = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR =
		new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED,
			PayrollIncrementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeIdAppraisalSettingIdFinancialYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR =
		new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED,
			PayrollIncrementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeIdAppraisalSettingIdFinancialYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			PayrollIncrementModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			PayrollIncrementModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			PayrollIncrementModelImpl.FINANCIALYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR =
		new FinderPath(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAppraisalSettingIdFinancialYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @return the matching payroll increments
	 */
	@Override
	public List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear) {
		return findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param start the lower bound of the range of payroll increments
	 * @param end the upper bound of the range of payroll increments (not inclusive)
	 * @return the range of matching payroll increments
	 */
	@Override
	public List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end) {
		return findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param start the lower bound of the range of payroll increments
	 * @param end the upper bound of the range of payroll increments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payroll increments
	 */
	@Override
	public List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
			appraisalSettingId, financialYear, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param start the lower bound of the range of payroll increments
	 * @param end the upper bound of the range of payroll increments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching payroll increments
	 */
	@Override
	public List<PayrollIncrement> findByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear,
		int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR;
			finderArgs = new Object[] {
					employeeId, appraisalSettingId, financialYear
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR;
			finderArgs = new Object[] {
					employeeId, appraisalSettingId, financialYear,
					
					start, end, orderByComparator
				};
		}

		List<PayrollIncrement> list = null;

		if (retrieveFromCache) {
			list = (List<PayrollIncrement>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayrollIncrement payrollIncrement : list) {
					if ((employeeId != payrollIncrement.getEmployeeId()) ||
							(appraisalSettingId != payrollIncrement.getAppraisalSettingId()) ||
							!Objects.equals(financialYear,
								payrollIncrement.getFinancialYear())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_PAYROLLINCREMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_APPRAISALSETTINGID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayrollIncrementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(appraisalSettingId);

				if (bindFinancialYear) {
					qPos.add(financialYear);
				}

				if (!pagination) {
					list = (List<PayrollIncrement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayrollIncrement>)QueryUtil.list(q,
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
	 * Returns the first payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payroll increment
	 * @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement findByemployeeIdAppraisalSettingIdFinancialYear_First(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator)
		throws NoSuchPayrollIncrementException {
		PayrollIncrement payrollIncrement = fetchByemployeeIdAppraisalSettingIdFinancialYear_First(employeeId,
				appraisalSettingId, financialYear, orderByComparator);

		if (payrollIncrement != null) {
			return payrollIncrement;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", financialYear=");
		msg.append(financialYear);

		msg.append("}");

		throw new NoSuchPayrollIncrementException(msg.toString());
	}

	/**
	 * Returns the first payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement fetchByemployeeIdAppraisalSettingIdFinancialYear_First(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		List<PayrollIncrement> list = findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
				appraisalSettingId, financialYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payroll increment
	 * @throws NoSuchPayrollIncrementException if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement findByemployeeIdAppraisalSettingIdFinancialYear_Last(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator)
		throws NoSuchPayrollIncrementException {
		PayrollIncrement payrollIncrement = fetchByemployeeIdAppraisalSettingIdFinancialYear_Last(employeeId,
				appraisalSettingId, financialYear, orderByComparator);

		if (payrollIncrement != null) {
			return payrollIncrement;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", financialYear=");
		msg.append(financialYear);

		msg.append("}");

		throw new NoSuchPayrollIncrementException(msg.toString());
	}

	/**
	 * Returns the last payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payroll increment, or <code>null</code> if a matching payroll increment could not be found
	 */
	@Override
	public PayrollIncrement fetchByemployeeIdAppraisalSettingIdFinancialYear_Last(
		long employeeId, long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		int count = countByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
				appraisalSettingId, financialYear);

		if (count == 0) {
			return null;
		}

		List<PayrollIncrement> list = findByemployeeIdAppraisalSettingIdFinancialYear(employeeId,
				appraisalSettingId, financialYear, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payroll increments before and after the current payroll increment in the ordered set where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param payrollIncrementId the primary key of the current payroll increment
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payroll increment
	 * @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement[] findByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(
		long payrollIncrementId, long employeeId, long appraisalSettingId,
		String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator)
		throws NoSuchPayrollIncrementException {
		PayrollIncrement payrollIncrement = findByPrimaryKey(payrollIncrementId);

		Session session = null;

		try {
			session = openSession();

			PayrollIncrement[] array = new PayrollIncrementImpl[3];

			array[0] = getByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(session,
					payrollIncrement, employeeId, appraisalSettingId,
					financialYear, orderByComparator, true);

			array[1] = payrollIncrement;

			array[2] = getByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(session,
					payrollIncrement, employeeId, appraisalSettingId,
					financialYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PayrollIncrement getByemployeeIdAppraisalSettingIdFinancialYear_PrevAndNext(
		Session session, PayrollIncrement payrollIncrement, long employeeId,
		long appraisalSettingId, String financialYear,
		OrderByComparator<PayrollIncrement> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_PAYROLLINCREMENT_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_APPRAISALSETTINGID_2);

		boolean bindFinancialYear = false;

		if (financialYear == null) {
			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_1);
		}
		else if (financialYear.equals("")) {
			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_3);
		}
		else {
			bindFinancialYear = true;

			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_2);
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
			query.append(PayrollIncrementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(appraisalSettingId);

		if (bindFinancialYear) {
			qPos.add(financialYear);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payrollIncrement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayrollIncrement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 */
	@Override
	public void removeByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear) {
		for (PayrollIncrement payrollIncrement : findByemployeeIdAppraisalSettingIdFinancialYear(
				employeeId, appraisalSettingId, financialYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payrollIncrement);
		}
	}

	/**
	 * Returns the number of payroll increments where employeeId = &#63; and appraisalSettingId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param financialYear the financial year
	 * @return the number of matching payroll increments
	 */
	@Override
	public int countByemployeeIdAppraisalSettingIdFinancialYear(
		long employeeId, long appraisalSettingId, String financialYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR;

		Object[] finderArgs = new Object[] {
				employeeId, appraisalSettingId, financialYear
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PAYROLLINCREMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_APPRAISALSETTINGID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(appraisalSettingId);

				if (bindFinancialYear) {
					qPos.add(financialYear);
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

	private static final String _FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_EMPLOYEEID_2 =
		"payrollIncrement.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_APPRAISALSETTINGID_2 =
		"payrollIncrement.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_1 =
		"payrollIncrement.financialYear IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_2 =
		"payrollIncrement.financialYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR_FINANCIALYEAR_3 =
		"(payrollIncrement.financialYear IS NULL OR payrollIncrement.financialYear = '')";

	public PayrollIncrementPersistenceImpl() {
		setModelClass(PayrollIncrement.class);
	}

	/**
	 * Caches the payroll increment in the entity cache if it is enabled.
	 *
	 * @param payrollIncrement the payroll increment
	 */
	@Override
	public void cacheResult(PayrollIncrement payrollIncrement) {
		entityCache.putResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementImpl.class, payrollIncrement.getPrimaryKey(),
			payrollIncrement);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
			new Object[] {
				payrollIncrement.getEmployeeId(),
				payrollIncrement.getComponentId(),
				payrollIncrement.getFinancialYear()
			}, payrollIncrement);

		payrollIncrement.resetOriginalValues();
	}

	/**
	 * Caches the payroll increments in the entity cache if it is enabled.
	 *
	 * @param payrollIncrements the payroll increments
	 */
	@Override
	public void cacheResult(List<PayrollIncrement> payrollIncrements) {
		for (PayrollIncrement payrollIncrement : payrollIncrements) {
			if (entityCache.getResult(
						PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
						PayrollIncrementImpl.class,
						payrollIncrement.getPrimaryKey()) == null) {
				cacheResult(payrollIncrement);
			}
			else {
				payrollIncrement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all payroll increments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayrollIncrementImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payroll increment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayrollIncrement payrollIncrement) {
		entityCache.removeResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementImpl.class, payrollIncrement.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PayrollIncrementModelImpl)payrollIncrement,
			true);
	}

	@Override
	public void clearCache(List<PayrollIncrement> payrollIncrements) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayrollIncrement payrollIncrement : payrollIncrements) {
			entityCache.removeResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
				PayrollIncrementImpl.class, payrollIncrement.getPrimaryKey());

			clearUniqueFindersCache((PayrollIncrementModelImpl)payrollIncrement,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		PayrollIncrementModelImpl payrollIncrementModelImpl) {
		Object[] args = new Object[] {
				payrollIncrementModelImpl.getEmployeeId(),
				payrollIncrementModelImpl.getComponentId(),
				payrollIncrementModelImpl.getFinancialYear()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
			args, payrollIncrementModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PayrollIncrementModelImpl payrollIncrementModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					payrollIncrementModelImpl.getEmployeeId(),
					payrollIncrementModelImpl.getComponentId(),
					payrollIncrementModelImpl.getFinancialYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
				args);
		}

		if ((payrollIncrementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					payrollIncrementModelImpl.getOriginalEmployeeId(),
					payrollIncrementModelImpl.getOriginalComponentId(),
					payrollIncrementModelImpl.getOriginalFinancialYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDCOMPONENTIDFINANCIALYEAR,
				args);
		}
	}

	/**
	 * Creates a new payroll increment with the primary key. Does not add the payroll increment to the database.
	 *
	 * @param payrollIncrementId the primary key for the new payroll increment
	 * @return the new payroll increment
	 */
	@Override
	public PayrollIncrement create(long payrollIncrementId) {
		PayrollIncrement payrollIncrement = new PayrollIncrementImpl();

		payrollIncrement.setNew(true);
		payrollIncrement.setPrimaryKey(payrollIncrementId);

		payrollIncrement.setCompanyId(companyProvider.getCompanyId());

		return payrollIncrement;
	}

	/**
	 * Removes the payroll increment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payrollIncrementId the primary key of the payroll increment
	 * @return the payroll increment that was removed
	 * @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement remove(long payrollIncrementId)
		throws NoSuchPayrollIncrementException {
		return remove((Serializable)payrollIncrementId);
	}

	/**
	 * Removes the payroll increment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payroll increment
	 * @return the payroll increment that was removed
	 * @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement remove(Serializable primaryKey)
		throws NoSuchPayrollIncrementException {
		Session session = null;

		try {
			session = openSession();

			PayrollIncrement payrollIncrement = (PayrollIncrement)session.get(PayrollIncrementImpl.class,
					primaryKey);

			if (payrollIncrement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayrollIncrementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payrollIncrement);
		}
		catch (NoSuchPayrollIncrementException nsee) {
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
	protected PayrollIncrement removeImpl(PayrollIncrement payrollIncrement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payrollIncrement)) {
				payrollIncrement = (PayrollIncrement)session.get(PayrollIncrementImpl.class,
						payrollIncrement.getPrimaryKeyObj());
			}

			if (payrollIncrement != null) {
				session.delete(payrollIncrement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payrollIncrement != null) {
			clearCache(payrollIncrement);
		}

		return payrollIncrement;
	}

	@Override
	public PayrollIncrement updateImpl(PayrollIncrement payrollIncrement) {
		boolean isNew = payrollIncrement.isNew();

		if (!(payrollIncrement instanceof PayrollIncrementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payrollIncrement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payrollIncrement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payrollIncrement proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayrollIncrement implementation " +
				payrollIncrement.getClass());
		}

		PayrollIncrementModelImpl payrollIncrementModelImpl = (PayrollIncrementModelImpl)payrollIncrement;

		Session session = null;

		try {
			session = openSession();

			if (payrollIncrement.isNew()) {
				session.save(payrollIncrement);

				payrollIncrement.setNew(false);
			}
			else {
				payrollIncrement = (PayrollIncrement)session.merge(payrollIncrement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PayrollIncrementModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					payrollIncrementModelImpl.getEmployeeId(),
					payrollIncrementModelImpl.getAppraisalSettingId(),
					payrollIncrementModelImpl.getFinancialYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((payrollIncrementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payrollIncrementModelImpl.getOriginalEmployeeId(),
						payrollIncrementModelImpl.getOriginalAppraisalSettingId(),
						payrollIncrementModelImpl.getOriginalFinancialYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR,
					args);

				args = new Object[] {
						payrollIncrementModelImpl.getEmployeeId(),
						payrollIncrementModelImpl.getAppraisalSettingId(),
						payrollIncrementModelImpl.getFinancialYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDAPPRAISALSETTINGIDFINANCIALYEAR,
					args);
			}
		}

		entityCache.putResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
			PayrollIncrementImpl.class, payrollIncrement.getPrimaryKey(),
			payrollIncrement, false);

		clearUniqueFindersCache(payrollIncrementModelImpl, false);
		cacheUniqueFindersCache(payrollIncrementModelImpl);

		payrollIncrement.resetOriginalValues();

		return payrollIncrement;
	}

	/**
	 * Returns the payroll increment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the payroll increment
	 * @return the payroll increment
	 * @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayrollIncrementException {
		PayrollIncrement payrollIncrement = fetchByPrimaryKey(primaryKey);

		if (payrollIncrement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayrollIncrementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payrollIncrement;
	}

	/**
	 * Returns the payroll increment with the primary key or throws a {@link NoSuchPayrollIncrementException} if it could not be found.
	 *
	 * @param payrollIncrementId the primary key of the payroll increment
	 * @return the payroll increment
	 * @throws NoSuchPayrollIncrementException if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement findByPrimaryKey(long payrollIncrementId)
		throws NoSuchPayrollIncrementException {
		return findByPrimaryKey((Serializable)payrollIncrementId);
	}

	/**
	 * Returns the payroll increment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payroll increment
	 * @return the payroll increment, or <code>null</code> if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
				PayrollIncrementImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PayrollIncrement payrollIncrement = (PayrollIncrement)serializable;

		if (payrollIncrement == null) {
			Session session = null;

			try {
				session = openSession();

				payrollIncrement = (PayrollIncrement)session.get(PayrollIncrementImpl.class,
						primaryKey);

				if (payrollIncrement != null) {
					cacheResult(payrollIncrement);
				}
				else {
					entityCache.putResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
						PayrollIncrementImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
					PayrollIncrementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payrollIncrement;
	}

	/**
	 * Returns the payroll increment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payrollIncrementId the primary key of the payroll increment
	 * @return the payroll increment, or <code>null</code> if a payroll increment with the primary key could not be found
	 */
	@Override
	public PayrollIncrement fetchByPrimaryKey(long payrollIncrementId) {
		return fetchByPrimaryKey((Serializable)payrollIncrementId);
	}

	@Override
	public Map<Serializable, PayrollIncrement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PayrollIncrement> map = new HashMap<Serializable, PayrollIncrement>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PayrollIncrement payrollIncrement = fetchByPrimaryKey(primaryKey);

			if (payrollIncrement != null) {
				map.put(primaryKey, payrollIncrement);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
					PayrollIncrementImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PayrollIncrement)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAYROLLINCREMENT_WHERE_PKS_IN);

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

			for (PayrollIncrement payrollIncrement : (List<PayrollIncrement>)q.list()) {
				map.put(payrollIncrement.getPrimaryKeyObj(), payrollIncrement);

				cacheResult(payrollIncrement);

				uncachedPrimaryKeys.remove(payrollIncrement.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PayrollIncrementModelImpl.ENTITY_CACHE_ENABLED,
					PayrollIncrementImpl.class, primaryKey, nullModel);
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
	 * Returns all the payroll increments.
	 *
	 * @return the payroll increments
	 */
	@Override
	public List<PayrollIncrement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payroll increments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payroll increments
	 * @param end the upper bound of the range of payroll increments (not inclusive)
	 * @return the range of payroll increments
	 */
	@Override
	public List<PayrollIncrement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payroll increments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payroll increments
	 * @param end the upper bound of the range of payroll increments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payroll increments
	 */
	@Override
	public List<PayrollIncrement> findAll(int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payroll increments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollIncrementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payroll increments
	 * @param end the upper bound of the range of payroll increments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of payroll increments
	 */
	@Override
	public List<PayrollIncrement> findAll(int start, int end,
		OrderByComparator<PayrollIncrement> orderByComparator,
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

		List<PayrollIncrement> list = null;

		if (retrieveFromCache) {
			list = (List<PayrollIncrement>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAYROLLINCREMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYROLLINCREMENT;

				if (pagination) {
					sql = sql.concat(PayrollIncrementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayrollIncrement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayrollIncrement>)QueryUtil.list(q,
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
	 * Removes all the payroll increments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayrollIncrement payrollIncrement : findAll()) {
			remove(payrollIncrement);
		}
	}

	/**
	 * Returns the number of payroll increments.
	 *
	 * @return the number of payroll increments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYROLLINCREMENT);

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
		return PayrollIncrementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payroll increment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PayrollIncrementImpl.class.getName());
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
	private static final String _SQL_SELECT_PAYROLLINCREMENT = "SELECT payrollIncrement FROM PayrollIncrement payrollIncrement";
	private static final String _SQL_SELECT_PAYROLLINCREMENT_WHERE_PKS_IN = "SELECT payrollIncrement FROM PayrollIncrement payrollIncrement WHERE payrollIncrementId IN (";
	private static final String _SQL_SELECT_PAYROLLINCREMENT_WHERE = "SELECT payrollIncrement FROM PayrollIncrement payrollIncrement WHERE ";
	private static final String _SQL_COUNT_PAYROLLINCREMENT = "SELECT COUNT(payrollIncrement) FROM PayrollIncrement payrollIncrement";
	private static final String _SQL_COUNT_PAYROLLINCREMENT_WHERE = "SELECT COUNT(payrollIncrement) FROM PayrollIncrement payrollIncrement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payrollIncrement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayrollIncrement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PayrollIncrement exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PayrollIncrementPersistenceImpl.class);
}