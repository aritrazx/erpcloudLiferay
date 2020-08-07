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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalProjectMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;
import com.liferay.famocom.erpcloud.model.impl.AppraisalProjectMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.AppraisalProjectMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalProjectMasterPersistence;

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
 * The persistence implementation for the appraisal project master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalProjectMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AppraisalProjectMasterUtil
 * @generated
 */
@ProviderType
public class AppraisalProjectMasterPersistenceImpl extends BasePersistenceImpl<AppraisalProjectMaster>
	implements AppraisalProjectMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppraisalProjectMasterUtil} to access the appraisal project master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppraisalProjectMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySettingIdAndEmployeeIdProjectInfo",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			AppraisalProjectMasterModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySettingIdAndEmployeeIdProjectInfo",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or throws a {@link NoSuchAppraisalProjectMasterException} if it could not be found.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
				employeeId, projectId);

		if (appraisalProjectMaster == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalSettingId=");
			msg.append(appraisalSettingId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", projectId=");
			msg.append(projectId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalProjectMasterException(msg.toString());
		}

		return appraisalProjectMaster;
	}

	/**
	 * Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId) {
		return fetchBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
			employeeId, projectId, true);
	}

	/**
	 * Returns the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				appraisalSettingId, employeeId, projectId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
					finderArgs, this);
		}

		if (result instanceof AppraisalProjectMaster) {
			AppraisalProjectMaster appraisalProjectMaster = (AppraisalProjectMaster)result;

			if ((appraisalSettingId != appraisalProjectMaster.getAppraisalSettingId()) ||
					(employeeId != appraisalProjectMaster.getEmployeeId()) ||
					(projectId != appraisalProjectMaster.getProjectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				qPos.add(projectId);

				List<AppraisalProjectMaster> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalProjectMasterPersistenceImpl.fetchBySettingIdAndEmployeeIdProjectInfo(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalProjectMaster appraisalProjectMaster = list.get(0);

					result = appraisalProjectMaster;

					cacheResult(appraisalProjectMaster);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
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
			return (AppraisalProjectMaster)result;
		}
	}

	/**
	 * Removes the appraisal project master where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the appraisal project master that was removed
	 */
	@Override
	public AppraisalProjectMaster removeBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
				employeeId, projectId);

		return remove(appraisalProjectMaster);
	}

	/**
	 * Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and projectId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the number of matching appraisal project masters
	 */
	@Override
	public int countBySettingIdAndEmployeeIdProjectInfo(
		long appraisalSettingId, long employeeId, long projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO;

		Object[] finderArgs = new Object[] {
				appraisalSettingId, employeeId, projectId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				qPos.add(projectId);

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

	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_APPRAISALSETTINGID_2 =
		"appraisalProjectMaster.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_EMPLOYEEID_2 =
		"appraisalProjectMaster.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDPROJECTINFO_PROJECTID_2 =
		"appraisalProjectMaster.projectId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySettingIdAndEmployeeIdAppraisalIdList",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySettingIdAndEmployeeIdAppraisalIdList",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			AppraisalProjectMasterModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.APPRAISALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySettingIdAndEmployeeIdAppraisalIdList",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @return the matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId) {
		return findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @return the range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end) {
		return findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
			employeeId, appraisalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST;
			finderArgs = new Object[] {
					appraisalSettingId, employeeId, appraisalId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST;
			finderArgs = new Object[] {
					appraisalSettingId, employeeId, appraisalId,
					
					start, end, orderByComparator
				};
		}

		List<AppraisalProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalProjectMaster appraisalProjectMaster : list) {
					if ((appraisalSettingId != appraisalProjectMaster.getAppraisalSettingId()) ||
							(employeeId != appraisalProjectMaster.getEmployeeId()) ||
							(appraisalId != appraisalProjectMaster.getAppraisalId())) {
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

			query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				qPos.add(appraisalId);

				if (!pagination) {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
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
	 * Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdAppraisalIdList_First(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchBySettingIdAndEmployeeIdAppraisalIdList_First(appraisalSettingId,
				employeeId, appraisalId, orderByComparator);

		if (appraisalProjectMaster != null) {
			return appraisalProjectMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append(", appraisalId=");
		msg.append(appraisalId);

		msg.append("}");

		throw new NoSuchAppraisalProjectMasterException(msg.toString());
	}

	/**
	 * Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdAppraisalIdList_First(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		List<AppraisalProjectMaster> list = findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
				employeeId, appraisalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdAppraisalIdList_Last(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchBySettingIdAndEmployeeIdAppraisalIdList_Last(appraisalSettingId,
				employeeId, appraisalId, orderByComparator);

		if (appraisalProjectMaster != null) {
			return appraisalProjectMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append(", appraisalId=");
		msg.append(appraisalId);

		msg.append("}");

		throw new NoSuchAppraisalProjectMasterException(msg.toString());
	}

	/**
	 * Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchBySettingIdAndEmployeeIdAppraisalIdList_Last(
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		int count = countBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
				employeeId, appraisalId);

		if (count == 0) {
			return null;
		}

		List<AppraisalProjectMaster> list = findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId,
				employeeId, appraisalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal project masters before and after the current appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalProjectId the primary key of the current appraisal project master
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster[] findBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long employeeId,
		long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = findByPrimaryKey(appraisalProjectId);

		Session session = null;

		try {
			session = openSession();

			AppraisalProjectMaster[] array = new AppraisalProjectMasterImpl[3];

			array[0] = getBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(session,
					appraisalProjectMaster, appraisalSettingId, employeeId,
					appraisalId, orderByComparator, true);

			array[1] = appraisalProjectMaster;

			array[2] = getBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(session,
					appraisalProjectMaster, appraisalSettingId, employeeId,
					appraisalId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppraisalProjectMaster getBySettingIdAndEmployeeIdAppraisalIdList_PrevAndNext(
		Session session, AppraisalProjectMaster appraisalProjectMaster,
		long appraisalSettingId, long employeeId, long appraisalId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

		query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALSETTINGID_2);

		query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALID_2);

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
			query.append(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appraisalSettingId);

		qPos.add(employeeId);

		qPos.add(appraisalId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appraisalProjectMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppraisalProjectMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 */
	@Override
	public void removeBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId) {
		for (AppraisalProjectMaster appraisalProjectMaster : findBySettingIdAndEmployeeIdAppraisalIdList(
				appraisalSettingId, employeeId, appraisalId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appraisalProjectMaster);
		}
	}

	/**
	 * Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; and appraisalId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param appraisalId the appraisal ID
	 * @return the number of matching appraisal project masters
	 */
	@Override
	public int countBySettingIdAndEmployeeIdAppraisalIdList(
		long appraisalSettingId, long employeeId, long appraisalId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST;

		Object[] finderArgs = new Object[] {
				appraisalSettingId, employeeId, appraisalId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				qPos.add(appraisalId);

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

	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALSETTINGID_2 =
		"appraisalProjectMaster.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_EMPLOYEEID_2 =
		"appraisalProjectMaster.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST_APPRAISALID_2 =
		"appraisalProjectMaster.appraisalId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeListFromManager",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeListFromManager",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			AppraisalProjectMasterModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.PROJECTID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.SUBMITSTEP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEELISTFROMMANAGER = new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeListFromManager",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @return the matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep) {
		return findByemployeeListFromManager(appraisalSettingId, projectId,
			submitStep, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @return the range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end) {
		return findByemployeeListFromManager(appraisalSettingId, projectId,
			submitStep, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return findByemployeeListFromManager(appraisalSettingId, projectId,
			submitStep, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByemployeeListFromManager(
		long appraisalSettingId, long projectId, long submitStep, int start,
		int end, OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER;
			finderArgs = new Object[] { appraisalSettingId, projectId, submitStep };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER;
			finderArgs = new Object[] {
					appraisalSettingId, projectId, submitStep,
					
					start, end, orderByComparator
				};
		}

		List<AppraisalProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalProjectMaster appraisalProjectMaster : list) {
					if ((appraisalSettingId != appraisalProjectMaster.getAppraisalSettingId()) ||
							(projectId != appraisalProjectMaster.getProjectId()) ||
							(submitStep != appraisalProjectMaster.getSubmitStep())) {
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

			query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_PROJECTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_SUBMITSTEP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(projectId);

				qPos.add(submitStep);

				if (!pagination) {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
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
	 * Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findByemployeeListFromManager_First(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchByemployeeListFromManager_First(appraisalSettingId,
				projectId, submitStep, orderByComparator);

		if (appraisalProjectMaster != null) {
			return appraisalProjectMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", submitStep=");
		msg.append(submitStep);

		msg.append("}");

		throw new NoSuchAppraisalProjectMasterException(msg.toString());
	}

	/**
	 * Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchByemployeeListFromManager_First(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		List<AppraisalProjectMaster> list = findByemployeeListFromManager(appraisalSettingId,
				projectId, submitStep, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findByemployeeListFromManager_Last(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchByemployeeListFromManager_Last(appraisalSettingId,
				projectId, submitStep, orderByComparator);

		if (appraisalProjectMaster != null) {
			return appraisalProjectMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", submitStep=");
		msg.append(submitStep);

		msg.append("}");

		throw new NoSuchAppraisalProjectMasterException(msg.toString());
	}

	/**
	 * Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchByemployeeListFromManager_Last(
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		int count = countByemployeeListFromManager(appraisalSettingId,
				projectId, submitStep);

		if (count == 0) {
			return null;
		}

		List<AppraisalProjectMaster> list = findByemployeeListFromManager(appraisalSettingId,
				projectId, submitStep, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal project masters before and after the current appraisal project master in the ordered set where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalProjectId the primary key of the current appraisal project master
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster[] findByemployeeListFromManager_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long projectId,
		long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = findByPrimaryKey(appraisalProjectId);

		Session session = null;

		try {
			session = openSession();

			AppraisalProjectMaster[] array = new AppraisalProjectMasterImpl[3];

			array[0] = getByemployeeListFromManager_PrevAndNext(session,
					appraisalProjectMaster, appraisalSettingId, projectId,
					submitStep, orderByComparator, true);

			array[1] = appraisalProjectMaster;

			array[2] = getByemployeeListFromManager_PrevAndNext(session,
					appraisalProjectMaster, appraisalSettingId, projectId,
					submitStep, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AppraisalProjectMaster getByemployeeListFromManager_PrevAndNext(
		Session session, AppraisalProjectMaster appraisalProjectMaster,
		long appraisalSettingId, long projectId, long submitStep,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_APPRAISALSETTINGID_2);

		query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_PROJECTID_2);

		query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_SUBMITSTEP_2);

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
			query.append(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appraisalSettingId);

		qPos.add(projectId);

		qPos.add(submitStep);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appraisalProjectMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppraisalProjectMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 */
	@Override
	public void removeByemployeeListFromManager(long appraisalSettingId,
		long projectId, long submitStep) {
		for (AppraisalProjectMaster appraisalProjectMaster : findByemployeeListFromManager(
				appraisalSettingId, projectId, submitStep, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appraisalProjectMaster);
		}
	}

	/**
	 * Returns the number of appraisal project masters where appraisalSettingId = &#63; and projectId = &#63; and submitStep = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param projectId the project ID
	 * @param submitStep the submit step
	 * @return the number of matching appraisal project masters
	 */
	@Override
	public int countByemployeeListFromManager(long appraisalSettingId,
		long projectId, long submitStep) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEELISTFROMMANAGER;

		Object[] finderArgs = new Object[] {
				appraisalSettingId, projectId, submitStep
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_PROJECTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_SUBMITSTEP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(projectId);

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

	private static final String _FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_APPRAISALSETTINGID_2 =
		"appraisalProjectMaster.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_PROJECTID_2 =
		"appraisalProjectMaster.projectId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEELISTFROMMANAGER_SUBMITSTEP_2 =
		"appraisalProjectMaster.submitStep = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByappraisalSettingIdAndEmployeeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByappraisalSettingIdAndEmployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			AppraisalProjectMasterModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			AppraisalProjectMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDANDEMPLOYEEID =
		new FinderPath(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByappraisalSettingIdAndEmployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		return findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @return the range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end) {
		return findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId, int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID;
			finderArgs = new Object[] { appraisalSettingId, employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID;
			finderArgs = new Object[] {
					appraisalSettingId, employeeId,
					
					start, end, orderByComparator
				};
		}

		List<AppraisalProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AppraisalProjectMaster appraisalProjectMaster : list) {
					if ((appraisalSettingId != appraisalProjectMaster.getAppraisalSettingId()) ||
							(employeeId != appraisalProjectMaster.getEmployeeId())) {
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

			query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
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
	 * Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findByappraisalSettingIdAndEmployeeId_First(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchByappraisalSettingIdAndEmployeeId_First(appraisalSettingId,
				employeeId, orderByComparator);

		if (appraisalProjectMaster != null) {
			return appraisalProjectMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchAppraisalProjectMasterException(msg.toString());
	}

	/**
	 * Returns the first appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchByappraisalSettingIdAndEmployeeId_First(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		List<AppraisalProjectMaster> list = findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
				employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster findByappraisalSettingIdAndEmployeeId_Last(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchByappraisalSettingIdAndEmployeeId_Last(appraisalSettingId,
				employeeId, orderByComparator);

		if (appraisalProjectMaster != null) {
			return appraisalProjectMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appraisalSettingId=");
		msg.append(appraisalSettingId);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchAppraisalProjectMasterException(msg.toString());
	}

	/**
	 * Returns the last appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching appraisal project master, or <code>null</code> if a matching appraisal project master could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchByappraisalSettingIdAndEmployeeId_Last(
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		int count = countByappraisalSettingIdAndEmployeeId(appraisalSettingId,
				employeeId);

		if (count == 0) {
			return null;
		}

		List<AppraisalProjectMaster> list = findByappraisalSettingIdAndEmployeeId(appraisalSettingId,
				employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the appraisal project masters before and after the current appraisal project master in the ordered set where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalProjectId the primary key of the current appraisal project master
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster[] findByappraisalSettingIdAndEmployeeId_PrevAndNext(
		long appraisalProjectId, long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = findByPrimaryKey(appraisalProjectId);

		Session session = null;

		try {
			session = openSession();

			AppraisalProjectMaster[] array = new AppraisalProjectMasterImpl[3];

			array[0] = getByappraisalSettingIdAndEmployeeId_PrevAndNext(session,
					appraisalProjectMaster, appraisalSettingId, employeeId,
					orderByComparator, true);

			array[1] = appraisalProjectMaster;

			array[2] = getByappraisalSettingIdAndEmployeeId_PrevAndNext(session,
					appraisalProjectMaster, appraisalSettingId, employeeId,
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

	protected AppraisalProjectMaster getByappraisalSettingIdAndEmployeeId_PrevAndNext(
		Session session, AppraisalProjectMaster appraisalProjectMaster,
		long appraisalSettingId, long employeeId,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
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

		query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE);

		query.append(_FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2);

		query.append(_FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_EMPLOYEEID_2);

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
			query.append(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appraisalSettingId);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(appraisalProjectMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AppraisalProjectMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByappraisalSettingIdAndEmployeeId(
		long appraisalSettingId, long employeeId) {
		for (AppraisalProjectMaster appraisalProjectMaster : findByappraisalSettingIdAndEmployeeId(
				appraisalSettingId, employeeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(appraisalProjectMaster);
		}
	}

	/**
	 * Returns the number of appraisal project masters where appraisalSettingId = &#63; and employeeId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param employeeId the employee ID
	 * @return the number of matching appraisal project masters
	 */
	@Override
	public int countByappraisalSettingIdAndEmployeeId(long appraisalSettingId,
		long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { appraisalSettingId, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPRAISALPROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_EMPLOYEEID_2);

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

	private static final String _FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_APPRAISALSETTINGID_2 =
		"appraisalProjectMaster.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_APPRAISALSETTINGIDANDEMPLOYEEID_EMPLOYEEID_2 =
		"appraisalProjectMaster.employeeId = ?";

	public AppraisalProjectMasterPersistenceImpl() {
		setModelClass(AppraisalProjectMaster.class);
	}

	/**
	 * Caches the appraisal project master in the entity cache if it is enabled.
	 *
	 * @param appraisalProjectMaster the appraisal project master
	 */
	@Override
	public void cacheResult(AppraisalProjectMaster appraisalProjectMaster) {
		entityCache.putResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			appraisalProjectMaster.getPrimaryKey(), appraisalProjectMaster);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
			new Object[] {
				appraisalProjectMaster.getAppraisalSettingId(),
				appraisalProjectMaster.getEmployeeId(),
				appraisalProjectMaster.getProjectId()
			}, appraisalProjectMaster);

		appraisalProjectMaster.resetOriginalValues();
	}

	/**
	 * Caches the appraisal project masters in the entity cache if it is enabled.
	 *
	 * @param appraisalProjectMasters the appraisal project masters
	 */
	@Override
	public void cacheResult(
		List<AppraisalProjectMaster> appraisalProjectMasters) {
		for (AppraisalProjectMaster appraisalProjectMaster : appraisalProjectMasters) {
			if (entityCache.getResult(
						AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalProjectMasterImpl.class,
						appraisalProjectMaster.getPrimaryKey()) == null) {
				cacheResult(appraisalProjectMaster);
			}
			else {
				appraisalProjectMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appraisal project masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalProjectMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appraisal project master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalProjectMaster appraisalProjectMaster) {
		entityCache.removeResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			appraisalProjectMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AppraisalProjectMasterModelImpl)appraisalProjectMaster,
			true);
	}

	@Override
	public void clearCache(List<AppraisalProjectMaster> appraisalProjectMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppraisalProjectMaster appraisalProjectMaster : appraisalProjectMasters) {
			entityCache.removeResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalProjectMasterImpl.class,
				appraisalProjectMaster.getPrimaryKey());

			clearUniqueFindersCache((AppraisalProjectMasterModelImpl)appraisalProjectMaster,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalProjectMasterModelImpl appraisalProjectMasterModelImpl) {
		Object[] args = new Object[] {
				appraisalProjectMasterModelImpl.getAppraisalSettingId(),
				appraisalProjectMasterModelImpl.getEmployeeId(),
				appraisalProjectMasterModelImpl.getProjectId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
			args, appraisalProjectMasterModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AppraisalProjectMasterModelImpl appraisalProjectMasterModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalProjectMasterModelImpl.getAppraisalSettingId(),
					appraisalProjectMasterModelImpl.getEmployeeId(),
					appraisalProjectMasterModelImpl.getProjectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
				args);
		}

		if ((appraisalProjectMasterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalProjectMasterModelImpl.getOriginalAppraisalSettingId(),
					appraisalProjectMasterModelImpl.getOriginalEmployeeId(),
					appraisalProjectMasterModelImpl.getOriginalProjectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SETTINGIDANDEMPLOYEEIDPROJECTINFO,
				args);
		}
	}

	/**
	 * Creates a new appraisal project master with the primary key. Does not add the appraisal project master to the database.
	 *
	 * @param appraisalProjectId the primary key for the new appraisal project master
	 * @return the new appraisal project master
	 */
	@Override
	public AppraisalProjectMaster create(long appraisalProjectId) {
		AppraisalProjectMaster appraisalProjectMaster = new AppraisalProjectMasterImpl();

		appraisalProjectMaster.setNew(true);
		appraisalProjectMaster.setPrimaryKey(appraisalProjectId);

		appraisalProjectMaster.setCompanyId(companyProvider.getCompanyId());

		return appraisalProjectMaster;
	}

	/**
	 * Removes the appraisal project master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalProjectId the primary key of the appraisal project master
	 * @return the appraisal project master that was removed
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster remove(long appraisalProjectId)
		throws NoSuchAppraisalProjectMasterException {
		return remove((Serializable)appraisalProjectId);
	}

	/**
	 * Removes the appraisal project master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal project master
	 * @return the appraisal project master that was removed
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster remove(Serializable primaryKey)
		throws NoSuchAppraisalProjectMasterException {
		Session session = null;

		try {
			session = openSession();

			AppraisalProjectMaster appraisalProjectMaster = (AppraisalProjectMaster)session.get(AppraisalProjectMasterImpl.class,
					primaryKey);

			if (appraisalProjectMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalProjectMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appraisalProjectMaster);
		}
		catch (NoSuchAppraisalProjectMasterException nsee) {
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
	protected AppraisalProjectMaster removeImpl(
		AppraisalProjectMaster appraisalProjectMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalProjectMaster)) {
				appraisalProjectMaster = (AppraisalProjectMaster)session.get(AppraisalProjectMasterImpl.class,
						appraisalProjectMaster.getPrimaryKeyObj());
			}

			if (appraisalProjectMaster != null) {
				session.delete(appraisalProjectMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appraisalProjectMaster != null) {
			clearCache(appraisalProjectMaster);
		}

		return appraisalProjectMaster;
	}

	@Override
	public AppraisalProjectMaster updateImpl(
		AppraisalProjectMaster appraisalProjectMaster) {
		boolean isNew = appraisalProjectMaster.isNew();

		if (!(appraisalProjectMaster instanceof AppraisalProjectMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalProjectMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appraisalProjectMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalProjectMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalProjectMaster implementation " +
				appraisalProjectMaster.getClass());
		}

		AppraisalProjectMasterModelImpl appraisalProjectMasterModelImpl = (AppraisalProjectMasterModelImpl)appraisalProjectMaster;

		Session session = null;

		try {
			session = openSession();

			if (appraisalProjectMaster.isNew()) {
				session.save(appraisalProjectMaster);

				appraisalProjectMaster.setNew(false);
			}
			else {
				appraisalProjectMaster = (AppraisalProjectMaster)session.merge(appraisalProjectMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AppraisalProjectMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					appraisalProjectMasterModelImpl.getAppraisalSettingId(),
					appraisalProjectMasterModelImpl.getEmployeeId(),
					appraisalProjectMasterModelImpl.getAppraisalId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST,
				args);

			args = new Object[] {
					appraisalProjectMasterModelImpl.getAppraisalSettingId(),
					appraisalProjectMasterModelImpl.getProjectId(),
					appraisalProjectMasterModelImpl.getSubmitStep()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEELISTFROMMANAGER,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER,
				args);

			args = new Object[] {
					appraisalProjectMasterModelImpl.getAppraisalSettingId(),
					appraisalProjectMasterModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((appraisalProjectMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appraisalProjectMasterModelImpl.getOriginalAppraisalSettingId(),
						appraisalProjectMasterModelImpl.getOriginalEmployeeId(),
						appraisalProjectMasterModelImpl.getOriginalAppraisalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST,
					args);

				args = new Object[] {
						appraisalProjectMasterModelImpl.getAppraisalSettingId(),
						appraisalProjectMasterModelImpl.getEmployeeId(),
						appraisalProjectMasterModelImpl.getAppraisalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SETTINGIDANDEMPLOYEEIDAPPRAISALIDLIST,
					args);
			}

			if ((appraisalProjectMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appraisalProjectMasterModelImpl.getOriginalAppraisalSettingId(),
						appraisalProjectMasterModelImpl.getOriginalProjectId(),
						appraisalProjectMasterModelImpl.getOriginalSubmitStep()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEELISTFROMMANAGER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER,
					args);

				args = new Object[] {
						appraisalProjectMasterModelImpl.getAppraisalSettingId(),
						appraisalProjectMasterModelImpl.getProjectId(),
						appraisalProjectMasterModelImpl.getSubmitStep()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEELISTFROMMANAGER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEELISTFROMMANAGER,
					args);
			}

			if ((appraisalProjectMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appraisalProjectMasterModelImpl.getOriginalAppraisalSettingId(),
						appraisalProjectMasterModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID,
					args);

				args = new Object[] {
						appraisalProjectMasterModelImpl.getAppraisalSettingId(),
						appraisalProjectMasterModelImpl.getEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRAISALSETTINGIDANDEMPLOYEEID,
					args);
			}
		}

		entityCache.putResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalProjectMasterImpl.class,
			appraisalProjectMaster.getPrimaryKey(), appraisalProjectMaster,
			false);

		clearUniqueFindersCache(appraisalProjectMasterModelImpl, false);
		cacheUniqueFindersCache(appraisalProjectMasterModelImpl);

		appraisalProjectMaster.resetOriginalValues();

		return appraisalProjectMaster;
	}

	/**
	 * Returns the appraisal project master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal project master
	 * @return the appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalProjectMasterException {
		AppraisalProjectMaster appraisalProjectMaster = fetchByPrimaryKey(primaryKey);

		if (appraisalProjectMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalProjectMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appraisalProjectMaster;
	}

	/**
	 * Returns the appraisal project master with the primary key or throws a {@link NoSuchAppraisalProjectMasterException} if it could not be found.
	 *
	 * @param appraisalProjectId the primary key of the appraisal project master
	 * @return the appraisal project master
	 * @throws NoSuchAppraisalProjectMasterException if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster findByPrimaryKey(long appraisalProjectId)
		throws NoSuchAppraisalProjectMasterException {
		return findByPrimaryKey((Serializable)appraisalProjectId);
	}

	/**
	 * Returns the appraisal project master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal project master
	 * @return the appraisal project master, or <code>null</code> if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalProjectMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppraisalProjectMaster appraisalProjectMaster = (AppraisalProjectMaster)serializable;

		if (appraisalProjectMaster == null) {
			Session session = null;

			try {
				session = openSession();

				appraisalProjectMaster = (AppraisalProjectMaster)session.get(AppraisalProjectMasterImpl.class,
						primaryKey);

				if (appraisalProjectMaster != null) {
					cacheResult(appraisalProjectMaster);
				}
				else {
					entityCache.putResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalProjectMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalProjectMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appraisalProjectMaster;
	}

	/**
	 * Returns the appraisal project master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalProjectId the primary key of the appraisal project master
	 * @return the appraisal project master, or <code>null</code> if a appraisal project master with the primary key could not be found
	 */
	@Override
	public AppraisalProjectMaster fetchByPrimaryKey(long appraisalProjectId) {
		return fetchByPrimaryKey((Serializable)appraisalProjectId);
	}

	@Override
	public Map<Serializable, AppraisalProjectMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppraisalProjectMaster> map = new HashMap<Serializable, AppraisalProjectMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppraisalProjectMaster appraisalProjectMaster = fetchByPrimaryKey(primaryKey);

			if (appraisalProjectMaster != null) {
				map.put(primaryKey, appraisalProjectMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalProjectMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppraisalProjectMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPRAISALPROJECTMASTER_WHERE_PKS_IN);

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

			for (AppraisalProjectMaster appraisalProjectMaster : (List<AppraisalProjectMaster>)q.list()) {
				map.put(appraisalProjectMaster.getPrimaryKeyObj(),
					appraisalProjectMaster);

				cacheResult(appraisalProjectMaster);

				uncachedPrimaryKeys.remove(appraisalProjectMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppraisalProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalProjectMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the appraisal project masters.
	 *
	 * @return the appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal project masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @return the range of appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findAll(int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal project masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal project masters
	 * @param end the upper bound of the range of appraisal project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of appraisal project masters
	 */
	@Override
	public List<AppraisalProjectMaster> findAll(int start, int end,
		OrderByComparator<AppraisalProjectMaster> orderByComparator,
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

		List<AppraisalProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPRAISALPROJECTMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALPROJECTMASTER;

				if (pagination) {
					sql = sql.concat(AppraisalProjectMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalProjectMaster>)QueryUtil.list(q,
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
	 * Removes all the appraisal project masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalProjectMaster appraisalProjectMaster : findAll()) {
			remove(appraisalProjectMaster);
		}
	}

	/**
	 * Returns the number of appraisal project masters.
	 *
	 * @return the number of appraisal project masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPRAISALPROJECTMASTER);

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
		return AppraisalProjectMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal project master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppraisalProjectMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_APPRAISALPROJECTMASTER = "SELECT appraisalProjectMaster FROM AppraisalProjectMaster appraisalProjectMaster";
	private static final String _SQL_SELECT_APPRAISALPROJECTMASTER_WHERE_PKS_IN = "SELECT appraisalProjectMaster FROM AppraisalProjectMaster appraisalProjectMaster WHERE appraisalProjectId IN (";
	private static final String _SQL_SELECT_APPRAISALPROJECTMASTER_WHERE = "SELECT appraisalProjectMaster FROM AppraisalProjectMaster appraisalProjectMaster WHERE ";
	private static final String _SQL_COUNT_APPRAISALPROJECTMASTER = "SELECT COUNT(appraisalProjectMaster) FROM AppraisalProjectMaster appraisalProjectMaster";
	private static final String _SQL_COUNT_APPRAISALPROJECTMASTER_WHERE = "SELECT COUNT(appraisalProjectMaster) FROM AppraisalProjectMaster appraisalProjectMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalProjectMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppraisalProjectMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppraisalProjectMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppraisalProjectMasterPersistenceImpl.class);
}