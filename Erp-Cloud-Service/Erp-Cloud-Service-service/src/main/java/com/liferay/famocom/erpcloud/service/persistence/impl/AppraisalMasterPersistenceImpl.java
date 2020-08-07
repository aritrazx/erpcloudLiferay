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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.impl.AppraisalMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.AppraisalMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalMasterPersistence;

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
 * The persistence implementation for the appraisal master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AppraisalMasterUtil
 * @generated
 */
@ProviderType
public class AppraisalMasterPersistenceImpl extends BasePersistenceImpl<AppraisalMaster>
	implements AppraisalMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppraisalMasterUtil} to access the appraisal master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppraisalMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID = new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalMasterImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySettingIdAndEmployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			AppraisalMasterModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEID = new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySettingIdAndEmployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or throws a {@link NoSuchAppraisalMasterException} if it could not be found.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the matching appraisal master
	 * @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster findBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalMasterException {
		AppraisalMaster appraisalMaster = fetchBySettingIdAndEmployeeId(appraisalSettingId,
				employeeId);

		if (appraisalMaster == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalSettingId=");
			msg.append(appraisalSettingId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalMasterException(msg.toString());
		}

		return appraisalMaster;
	}

	/**
	 * Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster fetchBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		return fetchBySettingIdAndEmployeeId(appraisalSettingId, employeeId,
			true);
	}

	/**
	 * Returns the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster fetchBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { appraisalSettingId, employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof AppraisalMaster) {
			AppraisalMaster appraisalMaster = (AppraisalMaster)result;

			if ((appraisalSettingId != appraisalMaster.getAppraisalSettingId()) ||
					(employeeId != appraisalMaster.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_APPRAISALMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				List<AppraisalMaster> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalMasterPersistenceImpl.fetchBySettingIdAndEmployeeId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalMaster appraisalMaster = list.get(0);

					result = appraisalMaster;

					cacheResult(appraisalMaster);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
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
			return (AppraisalMaster)result;
		}
	}

	/**
	 * Removes the appraisal master where appraisalSettingId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the appraisal master that was removed
	 */
	@Override
	public AppraisalMaster removeBySettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId)
		throws NoSuchAppraisalMasterException {
		AppraisalMaster appraisalMaster = findBySettingIdAndEmployeeId(appraisalSettingId,
				employeeId);

		return remove(appraisalMaster);
	}

	/**
	 * Returns the number of appraisal masters where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the number of matching appraisal masters
	 */
	@Override
	public int countBySettingIdAndEmployeeId(long appraisalSettingId,
		long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { appraisalSettingId, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPRAISALMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2 =
		"appraisalMaster.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEID_EMPLOYEEID_2 =
		"appraisalMaster.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP =
		new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySettingIdAndsubmitStep",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP =
		new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySettingIdAndsubmitStep",
			new String[] { Long.class.getName(), Long.class.getName() },
			AppraisalMasterModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalMasterModelImpl.SUBMITSTEP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SETTINGIDANDSUBMITSTEP = new FinderPath(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySettingIdAndsubmitStep",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @return the matching appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep) {
		return findBySettingIdAndsubmitStep(appraisalSettingId, submitStep,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param start the lower bound of the range of appraisal masters
	 * @param end the upper bound of the range of appraisal masters (not inclusive)
	 * @return the range of matching appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end) {
		return findBySettingIdAndsubmitStep(appraisalSettingId, submitStep,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param start the lower bound of the range of appraisal masters
	 * @param end the upper bound of the range of appraisal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return findBySettingIdAndsubmitStep(appraisalSettingId, submitStep,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param start the lower bound of the range of appraisal masters
	 * @param end the upper bound of the range of appraisal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findBySettingIdAndsubmitStep(
		long appraisalSettingId, long submitStep, int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP;
			finderArgs = new Object[] { appraisalSettingId, submitStep };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP;
			finderArgs = new Object[] {
					appraisalSettingId, submitStep,
					
					start, end, orderByComparator
				};
		}

		List<AppraisalMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalMaster appraisalMaster : list) {
					if ((appraisalSettingId != appraisalMaster.getAppraisalSettingId()) ||
							(submitStep != appraisalMaster.getSubmitStep())) {
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

			query.append(_SQL_SELECT_APPRAISALMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_SUBMITSTEP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppraisalMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(submitStep);

				if (!pagination) {
					list = (List<AppraisalMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalMaster>)QueryUtil.list(q,
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
	 * Returns the first appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal master
	 * @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster findBySettingIdAndsubmitStep_First(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator)
		throws NoSuchAppraisalMasterException {
		AppraisalMaster appraisalMaster = fetchBySettingIdAndsubmitStep_First(appraisalSettingId,
				submitStep, orderByComparator);

		if (appraisalMaster != null) {
			return appraisalMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", submitStep=");
		msg.append(submitStep);

		msg.append("}");

		throw new NoSuchAppraisalMasterException(msg.toString());
	}

	/**
	 * Returns the first appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster fetchBySettingIdAndsubmitStep_First(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		List<AppraisalMaster> list = findBySettingIdAndsubmitStep(appraisalSettingId,
				submitStep, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal master
	 * @throws NoSuchAppraisalMasterException if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster findBySettingIdAndsubmitStep_Last(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator)
		throws NoSuchAppraisalMasterException {
		AppraisalMaster appraisalMaster = fetchBySettingIdAndsubmitStep_Last(appraisalSettingId,
				submitStep, orderByComparator);

		if (appraisalMaster != null) {
			return appraisalMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", submitStep=");
		msg.append(submitStep);

		msg.append("}");

		throw new NoSuchAppraisalMasterException(msg.toString());
	}

	/**
	 * Returns the last appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal master, or <code>null</code> if a matching appraisal master could not be found
	 */
	@Override
	public AppraisalMaster fetchBySettingIdAndsubmitStep_Last(
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		int count = countBySettingIdAndsubmitStep(appraisalSettingId, submitStep);

		if (count == 0) {
			return null;
		}

		List<AppraisalMaster> list = findBySettingIdAndsubmitStep(appraisalSettingId,
				submitStep, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal masters before and after the current appraisal master in the ordered set where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalId the primary key of the current appraisal master
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal master
	 * @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster[] findBySettingIdAndsubmitStep_PrevAndNext(
		long appraisalId, long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator)
		throws NoSuchAppraisalMasterException {
		AppraisalMaster appraisalMaster = findByPrimaryKey(appraisalId);

		Session session = null;

		try {
			session = openSession();

			AppraisalMaster[] array = new AppraisalMasterImpl[3];

			array[0] = getBySettingIdAndsubmitStep_PrevAndNext(session,
					appraisalMaster, appraisalSettingId, submitStep,
					orderByComparator, true);

			array[1] = appraisalMaster;

			array[2] = getBySettingIdAndsubmitStep_PrevAndNext(session,
					appraisalMaster, appraisalSettingId, submitStep,
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

	protected AppraisalMaster getBySettingIdAndsubmitStep_PrevAndNext(
		Session session, AppraisalMaster appraisalMaster,
		long appraisalSettingId, long submitStep,
		OrderByComparator<AppraisalMaster> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_APPRAISALMASTER_WHERE);

		query.append(_FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_APPRAISALSETTINGID_2);

		query.append(_FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_SUBMITSTEP_2);

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
			query.append(AppraisalMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appraisalSettingId);

		qPos.add(submitStep);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appraisalMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppraisalMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal masters where appraisalSettingId = &#63; and submitStep = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 */
	@Override
	public void removeBySettingIdAndsubmitStep(long appraisalSettingId,
		long submitStep) {
		for (AppraisalMaster appraisalMaster : findBySettingIdAndsubmitStep(
				appraisalSettingId, submitStep, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appraisalMaster);
		}
	}

	/**
	 * Returns the number of appraisal masters where appraisalSettingId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param submitStep the submit step
	 * @return the number of matching appraisal masters
	 */
	@Override
	public int countBySettingIdAndsubmitStep(long appraisalSettingId,
		long submitStep) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SETTINGIDANDSUBMITSTEP;

		Object[] finderArgs = new Object[] { appraisalSettingId, submitStep };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPRAISALMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_SUBMITSTEP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(submitStep);

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

	private static final String _FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_APPRAISALSETTINGID_2 =
		"appraisalMaster.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_SETTINGIDANDSUBMITSTEP_SUBMITSTEP_2 =
		"appraisalMaster.submitStep = ?";

	public AppraisalMasterPersistenceImpl() {
		setModelClass(AppraisalMaster.class);
	}

	/**
	 * Caches the appraisal master in the entity cache if it is enabled.
	 *
	 * @param appraisalMaster the appraisal master
	 */
	@Override
	public void cacheResult(AppraisalMaster appraisalMaster) {
		entityCache.putResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterImpl.class, appraisalMaster.getPrimaryKey(),
			appraisalMaster);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
			new Object[] {
				appraisalMaster.getAppraisalSettingId(),
				appraisalMaster.getEmployeeId()
			}, appraisalMaster);

		appraisalMaster.resetOriginalValues();
	}

	/**
	 * Caches the appraisal masters in the entity cache if it is enabled.
	 *
	 * @param appraisalMasters the appraisal masters
	 */
	@Override
	public void cacheResult(List<AppraisalMaster> appraisalMasters) {
		for (AppraisalMaster appraisalMaster : appraisalMasters) {
			if (entityCache.getResult(
						AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalMasterImpl.class,
						appraisalMaster.getPrimaryKey()) == null) {
				cacheResult(appraisalMaster);
			}
			else {
				appraisalMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appraisal masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appraisal master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalMaster appraisalMaster) {
		entityCache.removeResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterImpl.class, appraisalMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AppraisalMasterModelImpl)appraisalMaster, true);
	}

	@Override
	public void clearCache(List<AppraisalMaster> appraisalMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppraisalMaster appraisalMaster : appraisalMasters) {
			entityCache.removeResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalMasterImpl.class, appraisalMaster.getPrimaryKey());

			clearUniqueFindersCache((AppraisalMasterModelImpl)appraisalMaster,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalMasterModelImpl appraisalMasterModelImpl) {
		Object[] args = new Object[] {
				appraisalMasterModelImpl.getAppraisalSettingId(),
				appraisalMasterModelImpl.getEmployeeId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
			args, appraisalMasterModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AppraisalMasterModelImpl appraisalMasterModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalMasterModelImpl.getAppraisalSettingId(),
					appraisalMasterModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
				args);
		}

		if ((appraisalMasterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalMasterModelImpl.getOriginalAppraisalSettingId(),
					appraisalMasterModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEID,
				args);
		}
	}

	/**
	 * Creates a new appraisal master with the primary key. Does not add the appraisal master to the database.
	 *
	 * @param appraisalId the primary key for the new appraisal master
	 * @return the new appraisal master
	 */
	@Override
	public AppraisalMaster create(long appraisalId) {
		AppraisalMaster appraisalMaster = new AppraisalMasterImpl();

		appraisalMaster.setNew(true);
		appraisalMaster.setPrimaryKey(appraisalId);

		appraisalMaster.setCompanyId(companyProvider.getCompanyId());

		return appraisalMaster;
	}

	/**
	 * Removes the appraisal master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalId the primary key of the appraisal master
	 * @return the appraisal master that was removed
	 * @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster remove(long appraisalId)
		throws NoSuchAppraisalMasterException {
		return remove((Serializable)appraisalId);
	}

	/**
	 * Removes the appraisal master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal master
	 * @return the appraisal master that was removed
	 * @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster remove(Serializable primaryKey)
		throws NoSuchAppraisalMasterException {
		Session session = null;

		try {
			session = openSession();

			AppraisalMaster appraisalMaster = (AppraisalMaster)session.get(AppraisalMasterImpl.class,
					primaryKey);

			if (appraisalMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appraisalMaster);
		}
		catch (NoSuchAppraisalMasterException nsee) {
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
	protected AppraisalMaster removeImpl(AppraisalMaster appraisalMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalMaster)) {
				appraisalMaster = (AppraisalMaster)session.get(AppraisalMasterImpl.class,
						appraisalMaster.getPrimaryKeyObj());
			}

			if (appraisalMaster != null) {
				session.delete(appraisalMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appraisalMaster != null) {
			clearCache(appraisalMaster);
		}

		return appraisalMaster;
	}

	@Override
	public AppraisalMaster updateImpl(AppraisalMaster appraisalMaster) {
		boolean isNew = appraisalMaster.isNew();

		if (!(appraisalMaster instanceof AppraisalMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appraisalMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalMaster implementation " +
				appraisalMaster.getClass());
		}

		AppraisalMasterModelImpl appraisalMasterModelImpl = (AppraisalMasterModelImpl)appraisalMaster;

		Session session = null;

		try {
			session = openSession();

			if (appraisalMaster.isNew()) {
				session.save(appraisalMaster);

				appraisalMaster.setNew(false);
			}
			else {
				appraisalMaster = (AppraisalMaster)session.merge(appraisalMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AppraisalMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					appraisalMasterModelImpl.getAppraisalSettingId(),
					appraisalMasterModelImpl.getSubmitStep()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDSUBMITSTEP,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((appraisalMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appraisalMasterModelImpl.getOriginalAppraisalSettingId(),
						appraisalMasterModelImpl.getOriginalSubmitStep()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDSUBMITSTEP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP,
					args);

				args = new Object[] {
						appraisalMasterModelImpl.getAppraisalSettingId(),
						appraisalMasterModelImpl.getSubmitStep()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDSUBMITSTEP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDSUBMITSTEP,
					args);
			}
		}

		entityCache.putResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalMasterImpl.class, appraisalMaster.getPrimaryKey(),
			appraisalMaster, false);

		clearUniqueFindersCache(appraisalMasterModelImpl, false);
		cacheUniqueFindersCache(appraisalMasterModelImpl);

		appraisalMaster.resetOriginalValues();

		return appraisalMaster;
	}

	/**
	 * Returns the appraisal master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal master
	 * @return the appraisal master
	 * @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalMasterException {
		AppraisalMaster appraisalMaster = fetchByPrimaryKey(primaryKey);

		if (appraisalMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appraisalMaster;
	}

	/**
	 * Returns the appraisal master with the primary key or throws a {@link NoSuchAppraisalMasterException} if it could not be found.
	 *
	 * @param appraisalId the primary key of the appraisal master
	 * @return the appraisal master
	 * @throws NoSuchAppraisalMasterException if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster findByPrimaryKey(long appraisalId)
		throws NoSuchAppraisalMasterException {
		return findByPrimaryKey((Serializable)appraisalId);
	}

	/**
	 * Returns the appraisal master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal master
	 * @return the appraisal master, or <code>null</code> if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppraisalMaster appraisalMaster = (AppraisalMaster)serializable;

		if (appraisalMaster == null) {
			Session session = null;

			try {
				session = openSession();

				appraisalMaster = (AppraisalMaster)session.get(AppraisalMasterImpl.class,
						primaryKey);

				if (appraisalMaster != null) {
					cacheResult(appraisalMaster);
				}
				else {
					entityCache.putResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appraisalMaster;
	}

	/**
	 * Returns the appraisal master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalId the primary key of the appraisal master
	 * @return the appraisal master, or <code>null</code> if a appraisal master with the primary key could not be found
	 */
	@Override
	public AppraisalMaster fetchByPrimaryKey(long appraisalId) {
		return fetchByPrimaryKey((Serializable)appraisalId);
	}

	@Override
	public Map<Serializable, AppraisalMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppraisalMaster> map = new HashMap<Serializable, AppraisalMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppraisalMaster appraisalMaster = fetchByPrimaryKey(primaryKey);

			if (appraisalMaster != null) {
				map.put(primaryKey, appraisalMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppraisalMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPRAISALMASTER_WHERE_PKS_IN);

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

			for (AppraisalMaster appraisalMaster : (List<AppraisalMaster>)q.list()) {
				map.put(appraisalMaster.getPrimaryKeyObj(), appraisalMaster);

				cacheResult(appraisalMaster);

				uncachedPrimaryKeys.remove(appraisalMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppraisalMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the appraisal masters.
	 *
	 * @return the appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal masters
	 * @param end the upper bound of the range of appraisal masters (not inclusive)
	 * @return the range of appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal masters
	 * @param end the upper bound of the range of appraisal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal masters
	 * @param end the upper bound of the range of appraisal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of appraisal masters
	 */
	@Override
	public List<AppraisalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalMaster> orderByComparator,
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

		List<AppraisalMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPRAISALMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALMASTER;

				if (pagination) {
					sql = sql.concat(AppraisalMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppraisalMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalMaster>)QueryUtil.list(q,
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
	 * Removes all the appraisal masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalMaster appraisalMaster : findAll()) {
			remove(appraisalMaster);
		}
	}

	/**
	 * Returns the number of appraisal masters.
	 *
	 * @return the number of appraisal masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPRAISALMASTER);

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
		return AppraisalMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppraisalMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_APPRAISALMASTER = "SELECT appraisalMaster FROM AppraisalMaster appraisalMaster";
	private static final String _SQL_SELECT_APPRAISALMASTER_WHERE_PKS_IN = "SELECT appraisalMaster FROM AppraisalMaster appraisalMaster WHERE appraisalId IN (";
	private static final String _SQL_SELECT_APPRAISALMASTER_WHERE = "SELECT appraisalMaster FROM AppraisalMaster appraisalMaster WHERE ";
	private static final String _SQL_COUNT_APPRAISALMASTER = "SELECT COUNT(appraisalMaster) FROM AppraisalMaster appraisalMaster";
	private static final String _SQL_COUNT_APPRAISALMASTER_WHERE = "SELECT COUNT(appraisalMaster) FROM AppraisalMaster appraisalMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppraisalMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppraisalMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppraisalMasterPersistenceImpl.class);
}