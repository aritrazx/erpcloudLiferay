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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalPerformanceException;
import com.liferay.famocom.erpcloud.model.AppraisalPerformance;
import com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceImpl;
import com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalPerformancePersistence;

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
import java.util.Set;

/**
 * The persistence implementation for the appraisal performance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalPerformancePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AppraisalPerformanceUtil
 * @generated
 */
@ProviderType
public class AppraisalPerformancePersistenceImpl extends BasePersistenceImpl<AppraisalPerformance>
	implements AppraisalPerformancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppraisalPerformanceUtil} to access the appraisal performance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppraisalPerformanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED,
			AppraisalPerformanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED,
			AppraisalPerformanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE =
		new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED,
			AppraisalPerformanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByApprIdSettingIdAndEmployeeIdPerformance",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			AppraisalPerformanceModelImpl.APPRAISALID_COLUMN_BITMASK |
			AppraisalPerformanceModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalPerformanceModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE =
		new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApprIdSettingIdAndEmployeeIdPerformance",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the matching appraisal performance
	 * @throws NoSuchAppraisalPerformanceException if a matching appraisal performance could not be found
	 */
	@Override
	public AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalPerformanceException {
		AppraisalPerformance appraisalPerformance = fetchByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
				appraisalSettingId, employeeId);

		if (appraisalPerformance == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalId=");
			msg.append(appraisalId);

			msg.append(", appraisalSettingId=");
			msg.append(appraisalSettingId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalPerformanceException(msg.toString());
		}

		return appraisalPerformance;
	}

	/**
	 * Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	 */
	@Override
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId) {
		return fetchByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
			appraisalSettingId, employeeId, true);
	}

	/**
	 * Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	 */
	@Override
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				appraisalId, appraisalSettingId, employeeId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
					finderArgs, this);
		}

		if (result instanceof AppraisalPerformance) {
			AppraisalPerformance appraisalPerformance = (AppraisalPerformance)result;

			if ((appraisalId != appraisalPerformance.getAppraisalId()) ||
					(appraisalSettingId != appraisalPerformance.getAppraisalSettingId()) ||
					(employeeId != appraisalPerformance.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_APPRAISALPERFORMANCE_WHERE);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalId);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				List<AppraisalPerformance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalPerformancePersistenceImpl.fetchByApprIdSettingIdAndEmployeeIdPerformance(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalPerformance appraisalPerformance = list.get(0);

					result = appraisalPerformance;

					cacheResult(appraisalPerformance);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
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
			return (AppraisalPerformance)result;
		}
	}

	/**
	 * Removes the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the appraisal performance that was removed
	 */
	@Override
	public AppraisalPerformance removeByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalPerformanceException {
		AppraisalPerformance appraisalPerformance = findByApprIdSettingIdAndEmployeeIdPerformance(appraisalId,
				appraisalSettingId, employeeId);

		return remove(appraisalPerformance);
	}

	/**
	 * Returns the number of appraisal performances where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the number of matching appraisal performances
	 */
	@Override
	public int countByApprIdSettingIdAndEmployeeIdPerformance(
		long appraisalId, long appraisalSettingId, long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE;

		Object[] finderArgs = new Object[] {
				appraisalId, appraisalSettingId, employeeId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_APPRAISALPERFORMANCE_WHERE);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalId);

				qPos.add(appraisalSettingId);

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

	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_APPRAISALID_2 =
		"appraisalPerformance.appraisalId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_APPRAISALSETTINGID_2 =
		"appraisalPerformance.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE_EMPLOYEEID_2 =
		"appraisalPerformance.employeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID =
		new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED,
			AppraisalPerformanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByApprIdSettingIdAndEmployeeIdPerformId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			AppraisalPerformanceModelImpl.APPRAISALID_COLUMN_BITMASK |
			AppraisalPerformanceModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalPerformanceModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AppraisalPerformanceModelImpl.PERFORMANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID =
		new FinderPath(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApprIdSettingIdAndEmployeeIdPerformId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param performanceId the performance ID
	 * @return the matching appraisal performance
	 * @throws NoSuchAppraisalPerformanceException if a matching appraisal performance could not be found
	 */
	@Override
	public AppraisalPerformance findByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) throws NoSuchAppraisalPerformanceException {
		AppraisalPerformance appraisalPerformance = fetchByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
				appraisalSettingId, employeeId, performanceId);

		if (appraisalPerformance == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalId=");
			msg.append(appraisalId);

			msg.append(", appraisalSettingId=");
			msg.append(appraisalSettingId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", performanceId=");
			msg.append(performanceId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalPerformanceException(msg.toString());
		}

		return appraisalPerformance;
	}

	/**
	 * Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param performanceId the performance ID
	 * @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	 */
	@Override
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) {
		return fetchByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
			appraisalSettingId, employeeId, performanceId, true);
	}

	/**
	 * Returns the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param performanceId the performance ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal performance, or <code>null</code> if a matching appraisal performance could not be found
	 */
	@Override
	public AppraisalPerformance fetchByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				appraisalId, appraisalSettingId, employeeId, performanceId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
					finderArgs, this);
		}

		if (result instanceof AppraisalPerformance) {
			AppraisalPerformance appraisalPerformance = (AppraisalPerformance)result;

			if ((appraisalId != appraisalPerformance.getAppraisalId()) ||
					(appraisalSettingId != appraisalPerformance.getAppraisalSettingId()) ||
					(employeeId != appraisalPerformance.getEmployeeId()) ||
					(performanceId != appraisalPerformance.getPerformanceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_APPRAISALPERFORMANCE_WHERE);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_PERFORMANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalId);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				qPos.add(performanceId);

				List<AppraisalPerformance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalPerformancePersistenceImpl.fetchByApprIdSettingIdAndEmployeeIdPerformId(long, long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalPerformance appraisalPerformance = list.get(0);

					result = appraisalPerformance;

					cacheResult(appraisalPerformance);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
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
			return (AppraisalPerformance)result;
		}
	}

	/**
	 * Removes the appraisal performance where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63; from the database.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param performanceId the performance ID
	 * @return the appraisal performance that was removed
	 */
	@Override
	public AppraisalPerformance removeByApprIdSettingIdAndEmployeeIdPerformId(
		long appraisalId, long appraisalSettingId, long employeeId,
		long performanceId) throws NoSuchAppraisalPerformanceException {
		AppraisalPerformance appraisalPerformance = findByApprIdSettingIdAndEmployeeIdPerformId(appraisalId,
				appraisalSettingId, employeeId, performanceId);

		return remove(appraisalPerformance);
	}

	/**
	 * Returns the number of appraisal performances where appraisalId = &#63; and appraisalSettingId = &#63; and employeeId = &#63; and performanceId = &#63;.
	 *
	 * @param appraisalId the appraisal ID
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param performanceId the performance ID
	 * @return the number of matching appraisal performances
	 */
	@Override
	public int countByApprIdSettingIdAndEmployeeIdPerformId(long appraisalId,
		long appraisalSettingId, long employeeId, long performanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID;

		Object[] finderArgs = new Object[] {
				appraisalId, appraisalSettingId, employeeId, performanceId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_APPRAISALPERFORMANCE_WHERE);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_PERFORMANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalId);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				qPos.add(performanceId);

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

	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_APPRAISALID_2 =
		"appraisalPerformance.appraisalId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_APPRAISALSETTINGID_2 =
		"appraisalPerformance.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_EMPLOYEEID_2 =
		"appraisalPerformance.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID_PERFORMANCEID_2 =
		"appraisalPerformance.performanceId = ?";

	public AppraisalPerformancePersistenceImpl() {
		setModelClass(AppraisalPerformance.class);
	}

	/**
	 * Caches the appraisal performance in the entity cache if it is enabled.
	 *
	 * @param appraisalPerformance the appraisal performance
	 */
	@Override
	public void cacheResult(AppraisalPerformance appraisalPerformance) {
		entityCache.putResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceImpl.class,
			appraisalPerformance.getPrimaryKey(), appraisalPerformance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
			new Object[] {
				appraisalPerformance.getAppraisalId(),
				appraisalPerformance.getAppraisalSettingId(),
				appraisalPerformance.getEmployeeId()
			}, appraisalPerformance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
			new Object[] {
				appraisalPerformance.getAppraisalId(),
				appraisalPerformance.getAppraisalSettingId(),
				appraisalPerformance.getEmployeeId(),
				appraisalPerformance.getPerformanceId()
			}, appraisalPerformance);

		appraisalPerformance.resetOriginalValues();
	}

	/**
	 * Caches the appraisal performances in the entity cache if it is enabled.
	 *
	 * @param appraisalPerformances the appraisal performances
	 */
	@Override
	public void cacheResult(List<AppraisalPerformance> appraisalPerformances) {
		for (AppraisalPerformance appraisalPerformance : appraisalPerformances) {
			if (entityCache.getResult(
						AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalPerformanceImpl.class,
						appraisalPerformance.getPrimaryKey()) == null) {
				cacheResult(appraisalPerformance);
			}
			else {
				appraisalPerformance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appraisal performances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalPerformanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appraisal performance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalPerformance appraisalPerformance) {
		entityCache.removeResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceImpl.class, appraisalPerformance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AppraisalPerformanceModelImpl)appraisalPerformance,
			true);
	}

	@Override
	public void clearCache(List<AppraisalPerformance> appraisalPerformances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppraisalPerformance appraisalPerformance : appraisalPerformances) {
			entityCache.removeResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalPerformanceImpl.class,
				appraisalPerformance.getPrimaryKey());

			clearUniqueFindersCache((AppraisalPerformanceModelImpl)appraisalPerformance,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalPerformanceModelImpl appraisalPerformanceModelImpl) {
		Object[] args = new Object[] {
				appraisalPerformanceModelImpl.getAppraisalId(),
				appraisalPerformanceModelImpl.getAppraisalSettingId(),
				appraisalPerformanceModelImpl.getEmployeeId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
			args, appraisalPerformanceModelImpl, false);

		args = new Object[] {
				appraisalPerformanceModelImpl.getAppraisalId(),
				appraisalPerformanceModelImpl.getAppraisalSettingId(),
				appraisalPerformanceModelImpl.getEmployeeId(),
				appraisalPerformanceModelImpl.getPerformanceId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
			args, appraisalPerformanceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AppraisalPerformanceModelImpl appraisalPerformanceModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalPerformanceModelImpl.getAppraisalId(),
					appraisalPerformanceModelImpl.getAppraisalSettingId(),
					appraisalPerformanceModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
				args);
		}

		if ((appraisalPerformanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalPerformanceModelImpl.getOriginalAppraisalId(),
					appraisalPerformanceModelImpl.getOriginalAppraisalSettingId(),
					appraisalPerformanceModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMANCE,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalPerformanceModelImpl.getAppraisalId(),
					appraisalPerformanceModelImpl.getAppraisalSettingId(),
					appraisalPerformanceModelImpl.getEmployeeId(),
					appraisalPerformanceModelImpl.getPerformanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
				args);
		}

		if ((appraisalPerformanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalPerformanceModelImpl.getOriginalAppraisalId(),
					appraisalPerformanceModelImpl.getOriginalAppraisalSettingId(),
					appraisalPerformanceModelImpl.getOriginalEmployeeId(),
					appraisalPerformanceModelImpl.getOriginalPerformanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDSETTINGIDANDEMPLOYEEIDPERFORMID,
				args);
		}
	}

	/**
	 * Creates a new appraisal performance with the primary key. Does not add the appraisal performance to the database.
	 *
	 * @param appraisalPerformanceId the primary key for the new appraisal performance
	 * @return the new appraisal performance
	 */
	@Override
	public AppraisalPerformance create(long appraisalPerformanceId) {
		AppraisalPerformance appraisalPerformance = new AppraisalPerformanceImpl();

		appraisalPerformance.setNew(true);
		appraisalPerformance.setPrimaryKey(appraisalPerformanceId);

		appraisalPerformance.setCompanyId(companyProvider.getCompanyId());

		return appraisalPerformance;
	}

	/**
	 * Removes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalPerformanceId the primary key of the appraisal performance
	 * @return the appraisal performance that was removed
	 * @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance remove(long appraisalPerformanceId)
		throws NoSuchAppraisalPerformanceException {
		return remove((Serializable)appraisalPerformanceId);
	}

	/**
	 * Removes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal performance
	 * @return the appraisal performance that was removed
	 * @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance remove(Serializable primaryKey)
		throws NoSuchAppraisalPerformanceException {
		Session session = null;

		try {
			session = openSession();

			AppraisalPerformance appraisalPerformance = (AppraisalPerformance)session.get(AppraisalPerformanceImpl.class,
					primaryKey);

			if (appraisalPerformance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalPerformanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appraisalPerformance);
		}
		catch (NoSuchAppraisalPerformanceException nsee) {
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
	protected AppraisalPerformance removeImpl(
		AppraisalPerformance appraisalPerformance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalPerformance)) {
				appraisalPerformance = (AppraisalPerformance)session.get(AppraisalPerformanceImpl.class,
						appraisalPerformance.getPrimaryKeyObj());
			}

			if (appraisalPerformance != null) {
				session.delete(appraisalPerformance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appraisalPerformance != null) {
			clearCache(appraisalPerformance);
		}

		return appraisalPerformance;
	}

	@Override
	public AppraisalPerformance updateImpl(
		AppraisalPerformance appraisalPerformance) {
		boolean isNew = appraisalPerformance.isNew();

		if (!(appraisalPerformance instanceof AppraisalPerformanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalPerformance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appraisalPerformance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalPerformance proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalPerformance implementation " +
				appraisalPerformance.getClass());
		}

		AppraisalPerformanceModelImpl appraisalPerformanceModelImpl = (AppraisalPerformanceModelImpl)appraisalPerformance;

		Session session = null;

		try {
			session = openSession();

			if (appraisalPerformance.isNew()) {
				session.save(appraisalPerformance);

				appraisalPerformance.setNew(false);
			}
			else {
				appraisalPerformance = (AppraisalPerformance)session.merge(appraisalPerformance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AppraisalPerformanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalPerformanceImpl.class,
			appraisalPerformance.getPrimaryKey(), appraisalPerformance, false);

		clearUniqueFindersCache(appraisalPerformanceModelImpl, false);
		cacheUniqueFindersCache(appraisalPerformanceModelImpl);

		appraisalPerformance.resetOriginalValues();

		return appraisalPerformance;
	}

	/**
	 * Returns the appraisal performance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal performance
	 * @return the appraisal performance
	 * @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalPerformanceException {
		AppraisalPerformance appraisalPerformance = fetchByPrimaryKey(primaryKey);

		if (appraisalPerformance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalPerformanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appraisalPerformance;
	}

	/**
	 * Returns the appraisal performance with the primary key or throws a {@link NoSuchAppraisalPerformanceException} if it could not be found.
	 *
	 * @param appraisalPerformanceId the primary key of the appraisal performance
	 * @return the appraisal performance
	 * @throws NoSuchAppraisalPerformanceException if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance findByPrimaryKey(long appraisalPerformanceId)
		throws NoSuchAppraisalPerformanceException {
		return findByPrimaryKey((Serializable)appraisalPerformanceId);
	}

	/**
	 * Returns the appraisal performance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal performance
	 * @return the appraisal performance, or <code>null</code> if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalPerformanceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppraisalPerformance appraisalPerformance = (AppraisalPerformance)serializable;

		if (appraisalPerformance == null) {
			Session session = null;

			try {
				session = openSession();

				appraisalPerformance = (AppraisalPerformance)session.get(AppraisalPerformanceImpl.class,
						primaryKey);

				if (appraisalPerformance != null) {
					cacheResult(appraisalPerformance);
				}
				else {
					entityCache.putResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalPerformanceImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalPerformanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appraisalPerformance;
	}

	/**
	 * Returns the appraisal performance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalPerformanceId the primary key of the appraisal performance
	 * @return the appraisal performance, or <code>null</code> if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance fetchByPrimaryKey(long appraisalPerformanceId) {
		return fetchByPrimaryKey((Serializable)appraisalPerformanceId);
	}

	@Override
	public Map<Serializable, AppraisalPerformance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppraisalPerformance> map = new HashMap<Serializable, AppraisalPerformance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppraisalPerformance appraisalPerformance = fetchByPrimaryKey(primaryKey);

			if (appraisalPerformance != null) {
				map.put(primaryKey, appraisalPerformance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalPerformanceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppraisalPerformance)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPRAISALPERFORMANCE_WHERE_PKS_IN);

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

			for (AppraisalPerformance appraisalPerformance : (List<AppraisalPerformance>)q.list()) {
				map.put(appraisalPerformance.getPrimaryKeyObj(),
					appraisalPerformance);

				cacheResult(appraisalPerformance);

				uncachedPrimaryKeys.remove(appraisalPerformance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppraisalPerformanceModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalPerformanceImpl.class, primaryKey, nullModel);
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
	 * Returns all the appraisal performances.
	 *
	 * @return the appraisal performances
	 */
	@Override
	public List<AppraisalPerformance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal performances
	 * @param end the upper bound of the range of appraisal performances (not inclusive)
	 * @return the range of appraisal performances
	 */
	@Override
	public List<AppraisalPerformance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal performances
	 * @param end the upper bound of the range of appraisal performances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal performances
	 */
	@Override
	public List<AppraisalPerformance> findAll(int start, int end,
		OrderByComparator<AppraisalPerformance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal performances
	 * @param end the upper bound of the range of appraisal performances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of appraisal performances
	 */
	@Override
	public List<AppraisalPerformance> findAll(int start, int end,
		OrderByComparator<AppraisalPerformance> orderByComparator,
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

		List<AppraisalPerformance> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalPerformance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPRAISALPERFORMANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALPERFORMANCE;

				if (pagination) {
					sql = sql.concat(AppraisalPerformanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppraisalPerformance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalPerformance>)QueryUtil.list(q,
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
	 * Removes all the appraisal performances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalPerformance appraisalPerformance : findAll()) {
			remove(appraisalPerformance);
		}
	}

	/**
	 * Returns the number of appraisal performances.
	 *
	 * @return the number of appraisal performances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPRAISALPERFORMANCE);

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
		return AppraisalPerformanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal performance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppraisalPerformanceImpl.class.getName());
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
	private static final String _SQL_SELECT_APPRAISALPERFORMANCE = "SELECT appraisalPerformance FROM AppraisalPerformance appraisalPerformance";
	private static final String _SQL_SELECT_APPRAISALPERFORMANCE_WHERE_PKS_IN = "SELECT appraisalPerformance FROM AppraisalPerformance appraisalPerformance WHERE appraisalPerformanceId IN (";
	private static final String _SQL_SELECT_APPRAISALPERFORMANCE_WHERE = "SELECT appraisalPerformance FROM AppraisalPerformance appraisalPerformance WHERE ";
	private static final String _SQL_COUNT_APPRAISALPERFORMANCE = "SELECT COUNT(appraisalPerformance) FROM AppraisalPerformance appraisalPerformance";
	private static final String _SQL_COUNT_APPRAISALPERFORMANCE_WHERE = "SELECT COUNT(appraisalPerformance) FROM AppraisalPerformance appraisalPerformance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalPerformance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppraisalPerformance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppraisalPerformance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppraisalPerformancePersistenceImpl.class);
}