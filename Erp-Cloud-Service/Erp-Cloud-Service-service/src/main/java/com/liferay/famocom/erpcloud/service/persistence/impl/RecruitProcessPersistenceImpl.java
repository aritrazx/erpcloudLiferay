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

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.model.impl.RecruitProcessImpl;
import com.liferay.famocom.erpcloud.model.impl.RecruitProcessModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.RecruitProcessPersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the recruit process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see RecruitProcessPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.RecruitProcessUtil
 * @generated
 */
@ProviderType
public class RecruitProcessPersistenceImpl extends BasePersistenceImpl<RecruitProcess>
	implements RecruitProcessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecruitProcessUtil} to access the recruit process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecruitProcessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED,
			RecruitProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED,
			RecruitProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_RECRUITPROCESS = new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED,
			RecruitProcessImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByrecruitProcess", new String[] { Long.class.getName() },
			RecruitProcessModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECRUITPROCESS = new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrecruitProcess",
			new String[] { Long.class.getName() });

	/**
	 * Returns the recruit process where employeeId = &#63; or throws a {@link NoSuchRecruitProcessException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching recruit process
	 * @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess findByrecruitProcess(long employeeId)
		throws NoSuchRecruitProcessException {
		RecruitProcess recruitProcess = fetchByrecruitProcess(employeeId);

		if (recruitProcess == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRecruitProcessException(msg.toString());
		}

		return recruitProcess;
	}

	/**
	 * Returns the recruit process where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching recruit process, or <code>null</code> if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess fetchByrecruitProcess(long employeeId) {
		return fetchByrecruitProcess(employeeId, true);
	}

	/**
	 * Returns the recruit process where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching recruit process, or <code>null</code> if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess fetchByrecruitProcess(long employeeId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS,
					finderArgs, this);
		}

		if (result instanceof RecruitProcess) {
			RecruitProcess recruitProcess = (RecruitProcess)result;

			if ((employeeId != recruitProcess.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RECRUITPROCESS_WHERE);

			query.append(_FINDER_COLUMN_RECRUITPROCESS_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				List<RecruitProcess> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RecruitProcessPersistenceImpl.fetchByrecruitProcess(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RecruitProcess recruitProcess = list.get(0);

					result = recruitProcess;

					cacheResult(recruitProcess);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS,
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
			return (RecruitProcess)result;
		}
	}

	/**
	 * Removes the recruit process where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the recruit process that was removed
	 */
	@Override
	public RecruitProcess removeByrecruitProcess(long employeeId)
		throws NoSuchRecruitProcessException {
		RecruitProcess recruitProcess = findByrecruitProcess(employeeId);

		return remove(recruitProcess);
	}

	/**
	 * Returns the number of recruit processes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching recruit processes
	 */
	@Override
	public int countByrecruitProcess(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECRUITPROCESS;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RECRUITPROCESS_WHERE);

			query.append(_FINDER_COLUMN_RECRUITPROCESS_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_RECRUITPROCESS_EMPLOYEEID_2 = "recruitProcess.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITPROCESSCOL =
		new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED,
			RecruitProcessImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrecruitProcessCol",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITPROCESSCOL =
		new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED,
			RecruitProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrecruitProcessCol", new String[] { Long.class.getName() },
			RecruitProcessModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECRUITPROCESSCOL = new FinderPath(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrecruitProcessCol", new String[] { Long.class.getName() });

	/**
	 * Returns all the recruit processes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching recruit processes
	 */
	@Override
	public List<RecruitProcess> findByrecruitProcessCol(long employeeId) {
		return findByrecruitProcessCol(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruit processes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of recruit processes
	 * @param end the upper bound of the range of recruit processes (not inclusive)
	 * @return the range of matching recruit processes
	 */
	@Override
	public List<RecruitProcess> findByrecruitProcessCol(long employeeId,
		int start, int end) {
		return findByrecruitProcessCol(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruit processes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of recruit processes
	 * @param end the upper bound of the range of recruit processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching recruit processes
	 */
	@Override
	public List<RecruitProcess> findByrecruitProcessCol(long employeeId,
		int start, int end, OrderByComparator<RecruitProcess> orderByComparator) {
		return findByrecruitProcessCol(employeeId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the recruit processes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of recruit processes
	 * @param end the upper bound of the range of recruit processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching recruit processes
	 */
	@Override
	public List<RecruitProcess> findByrecruitProcessCol(long employeeId,
		int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITPROCESSCOL;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITPROCESSCOL;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<RecruitProcess> list = null;

		if (retrieveFromCache) {
			list = (List<RecruitProcess>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RecruitProcess recruitProcess : list) {
					if ((employeeId != recruitProcess.getEmployeeId())) {
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

			query.append(_SQL_SELECT_RECRUITPROCESS_WHERE);

			query.append(_FINDER_COLUMN_RECRUITPROCESSCOL_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RecruitProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<RecruitProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RecruitProcess>)QueryUtil.list(q,
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
	 * Returns the first recruit process in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recruit process
	 * @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess findByrecruitProcessCol_First(long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator)
		throws NoSuchRecruitProcessException {
		RecruitProcess recruitProcess = fetchByrecruitProcessCol_First(employeeId,
				orderByComparator);

		if (recruitProcess != null) {
			return recruitProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchRecruitProcessException(msg.toString());
	}

	/**
	 * Returns the first recruit process in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recruit process, or <code>null</code> if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess fetchByrecruitProcessCol_First(long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator) {
		List<RecruitProcess> list = findByrecruitProcessCol(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last recruit process in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recruit process
	 * @throws NoSuchRecruitProcessException if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess findByrecruitProcessCol_Last(long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator)
		throws NoSuchRecruitProcessException {
		RecruitProcess recruitProcess = fetchByrecruitProcessCol_Last(employeeId,
				orderByComparator);

		if (recruitProcess != null) {
			return recruitProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchRecruitProcessException(msg.toString());
	}

	/**
	 * Returns the last recruit process in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recruit process, or <code>null</code> if a matching recruit process could not be found
	 */
	@Override
	public RecruitProcess fetchByrecruitProcessCol_Last(long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator) {
		int count = countByrecruitProcessCol(employeeId);

		if (count == 0) {
			return null;
		}

		List<RecruitProcess> list = findByrecruitProcessCol(employeeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the recruit processes before and after the current recruit process in the ordered set where employeeId = &#63;.
	 *
	 * @param recruitProcessId the primary key of the current recruit process
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recruit process
	 * @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess[] findByrecruitProcessCol_PrevAndNext(
		long recruitProcessId, long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator)
		throws NoSuchRecruitProcessException {
		RecruitProcess recruitProcess = findByPrimaryKey(recruitProcessId);

		Session session = null;

		try {
			session = openSession();

			RecruitProcess[] array = new RecruitProcessImpl[3];

			array[0] = getByrecruitProcessCol_PrevAndNext(session,
					recruitProcess, employeeId, orderByComparator, true);

			array[1] = recruitProcess;

			array[2] = getByrecruitProcessCol_PrevAndNext(session,
					recruitProcess, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RecruitProcess getByrecruitProcessCol_PrevAndNext(
		Session session, RecruitProcess recruitProcess, long employeeId,
		OrderByComparator<RecruitProcess> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RECRUITPROCESS_WHERE);

		query.append(_FINDER_COLUMN_RECRUITPROCESSCOL_EMPLOYEEID_2);

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
			query.append(RecruitProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(recruitProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RecruitProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recruit processes where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByrecruitProcessCol(long employeeId) {
		for (RecruitProcess recruitProcess : findByrecruitProcessCol(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(recruitProcess);
		}
	}

	/**
	 * Returns the number of recruit processes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching recruit processes
	 */
	@Override
	public int countByrecruitProcessCol(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECRUITPROCESSCOL;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RECRUITPROCESS_WHERE);

			query.append(_FINDER_COLUMN_RECRUITPROCESSCOL_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_RECRUITPROCESSCOL_EMPLOYEEID_2 = "recruitProcess.employeeId = ?";

	public RecruitProcessPersistenceImpl() {
		setModelClass(RecruitProcess.class);
	}

	/**
	 * Caches the recruit process in the entity cache if it is enabled.
	 *
	 * @param recruitProcess the recruit process
	 */
	@Override
	public void cacheResult(RecruitProcess recruitProcess) {
		entityCache.putResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessImpl.class, recruitProcess.getPrimaryKey(),
			recruitProcess);

		finderCache.putResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS,
			new Object[] { recruitProcess.getEmployeeId() }, recruitProcess);

		recruitProcess.resetOriginalValues();
	}

	/**
	 * Caches the recruit processes in the entity cache if it is enabled.
	 *
	 * @param recruitProcesses the recruit processes
	 */
	@Override
	public void cacheResult(List<RecruitProcess> recruitProcesses) {
		for (RecruitProcess recruitProcess : recruitProcesses) {
			if (entityCache.getResult(
						RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
						RecruitProcessImpl.class, recruitProcess.getPrimaryKey()) == null) {
				cacheResult(recruitProcess);
			}
			else {
				recruitProcess.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recruit processes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RecruitProcessImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recruit process.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RecruitProcess recruitProcess) {
		entityCache.removeResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessImpl.class, recruitProcess.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((RecruitProcessModelImpl)recruitProcess, true);
	}

	@Override
	public void clearCache(List<RecruitProcess> recruitProcesses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RecruitProcess recruitProcess : recruitProcesses) {
			entityCache.removeResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
				RecruitProcessImpl.class, recruitProcess.getPrimaryKey());

			clearUniqueFindersCache((RecruitProcessModelImpl)recruitProcess,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		RecruitProcessModelImpl recruitProcessModelImpl) {
		Object[] args = new Object[] { recruitProcessModelImpl.getEmployeeId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_RECRUITPROCESS, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS, args,
			recruitProcessModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		RecruitProcessModelImpl recruitProcessModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { recruitProcessModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITPROCESS, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS, args);
		}

		if ((recruitProcessModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RECRUITPROCESS.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					recruitProcessModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITPROCESS, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_RECRUITPROCESS, args);
		}
	}

	/**
	 * Creates a new recruit process with the primary key. Does not add the recruit process to the database.
	 *
	 * @param recruitProcessId the primary key for the new recruit process
	 * @return the new recruit process
	 */
	@Override
	public RecruitProcess create(long recruitProcessId) {
		RecruitProcess recruitProcess = new RecruitProcessImpl();

		recruitProcess.setNew(true);
		recruitProcess.setPrimaryKey(recruitProcessId);

		return recruitProcess;
	}

	/**
	 * Removes the recruit process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitProcessId the primary key of the recruit process
	 * @return the recruit process that was removed
	 * @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess remove(long recruitProcessId)
		throws NoSuchRecruitProcessException {
		return remove((Serializable)recruitProcessId);
	}

	/**
	 * Removes the recruit process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recruit process
	 * @return the recruit process that was removed
	 * @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess remove(Serializable primaryKey)
		throws NoSuchRecruitProcessException {
		Session session = null;

		try {
			session = openSession();

			RecruitProcess recruitProcess = (RecruitProcess)session.get(RecruitProcessImpl.class,
					primaryKey);

			if (recruitProcess == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecruitProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recruitProcess);
		}
		catch (NoSuchRecruitProcessException nsee) {
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
	protected RecruitProcess removeImpl(RecruitProcess recruitProcess) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(recruitProcess)) {
				recruitProcess = (RecruitProcess)session.get(RecruitProcessImpl.class,
						recruitProcess.getPrimaryKeyObj());
			}

			if (recruitProcess != null) {
				session.delete(recruitProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (recruitProcess != null) {
			clearCache(recruitProcess);
		}

		return recruitProcess;
	}

	@Override
	public RecruitProcess updateImpl(RecruitProcess recruitProcess) {
		boolean isNew = recruitProcess.isNew();

		if (!(recruitProcess instanceof RecruitProcessModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(recruitProcess.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(recruitProcess);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in recruitProcess proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RecruitProcess implementation " +
				recruitProcess.getClass());
		}

		RecruitProcessModelImpl recruitProcessModelImpl = (RecruitProcessModelImpl)recruitProcess;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (recruitProcess.getCreateDate() == null)) {
			if (serviceContext == null) {
				recruitProcess.setCreateDate(now);
			}
			else {
				recruitProcess.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!recruitProcessModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				recruitProcess.setModifiedDate(now);
			}
			else {
				recruitProcess.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (recruitProcess.isNew()) {
				session.save(recruitProcess);

				recruitProcess.setNew(false);
			}
			else {
				recruitProcess = (RecruitProcess)session.merge(recruitProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RecruitProcessModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { recruitProcessModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITPROCESSCOL,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITPROCESSCOL,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((recruitProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITPROCESSCOL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						recruitProcessModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITPROCESSCOL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITPROCESSCOL,
					args);

				args = new Object[] { recruitProcessModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITPROCESSCOL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITPROCESSCOL,
					args);
			}
		}

		entityCache.putResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
			RecruitProcessImpl.class, recruitProcess.getPrimaryKey(),
			recruitProcess, false);

		clearUniqueFindersCache(recruitProcessModelImpl, false);
		cacheUniqueFindersCache(recruitProcessModelImpl);

		recruitProcess.resetOriginalValues();

		return recruitProcess;
	}

	/**
	 * Returns the recruit process with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruit process
	 * @return the recruit process
	 * @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRecruitProcessException {
		RecruitProcess recruitProcess = fetchByPrimaryKey(primaryKey);

		if (recruitProcess == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRecruitProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return recruitProcess;
	}

	/**
	 * Returns the recruit process with the primary key or throws a {@link NoSuchRecruitProcessException} if it could not be found.
	 *
	 * @param recruitProcessId the primary key of the recruit process
	 * @return the recruit process
	 * @throws NoSuchRecruitProcessException if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess findByPrimaryKey(long recruitProcessId)
		throws NoSuchRecruitProcessException {
		return findByPrimaryKey((Serializable)recruitProcessId);
	}

	/**
	 * Returns the recruit process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruit process
	 * @return the recruit process, or <code>null</code> if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
				RecruitProcessImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RecruitProcess recruitProcess = (RecruitProcess)serializable;

		if (recruitProcess == null) {
			Session session = null;

			try {
				session = openSession();

				recruitProcess = (RecruitProcess)session.get(RecruitProcessImpl.class,
						primaryKey);

				if (recruitProcess != null) {
					cacheResult(recruitProcess);
				}
				else {
					entityCache.putResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
						RecruitProcessImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
					RecruitProcessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return recruitProcess;
	}

	/**
	 * Returns the recruit process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recruitProcessId the primary key of the recruit process
	 * @return the recruit process, or <code>null</code> if a recruit process with the primary key could not be found
	 */
	@Override
	public RecruitProcess fetchByPrimaryKey(long recruitProcessId) {
		return fetchByPrimaryKey((Serializable)recruitProcessId);
	}

	@Override
	public Map<Serializable, RecruitProcess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RecruitProcess> map = new HashMap<Serializable, RecruitProcess>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RecruitProcess recruitProcess = fetchByPrimaryKey(primaryKey);

			if (recruitProcess != null) {
				map.put(primaryKey, recruitProcess);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
					RecruitProcessImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RecruitProcess)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RECRUITPROCESS_WHERE_PKS_IN);

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

			for (RecruitProcess recruitProcess : (List<RecruitProcess>)q.list()) {
				map.put(recruitProcess.getPrimaryKeyObj(), recruitProcess);

				cacheResult(recruitProcess);

				uncachedPrimaryKeys.remove(recruitProcess.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RecruitProcessModelImpl.ENTITY_CACHE_ENABLED,
					RecruitProcessImpl.class, primaryKey, nullModel);
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
	 * Returns all the recruit processes.
	 *
	 * @return the recruit processes
	 */
	@Override
	public List<RecruitProcess> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruit processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruit processes
	 * @param end the upper bound of the range of recruit processes (not inclusive)
	 * @return the range of recruit processes
	 */
	@Override
	public List<RecruitProcess> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruit processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruit processes
	 * @param end the upper bound of the range of recruit processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recruit processes
	 */
	@Override
	public List<RecruitProcess> findAll(int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the recruit processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RecruitProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruit processes
	 * @param end the upper bound of the range of recruit processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of recruit processes
	 */
	@Override
	public List<RecruitProcess> findAll(int start, int end,
		OrderByComparator<RecruitProcess> orderByComparator,
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

		List<RecruitProcess> list = null;

		if (retrieveFromCache) {
			list = (List<RecruitProcess>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RECRUITPROCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECRUITPROCESS;

				if (pagination) {
					sql = sql.concat(RecruitProcessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RecruitProcess>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RecruitProcess>)QueryUtil.list(q,
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
	 * Removes all the recruit processes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RecruitProcess recruitProcess : findAll()) {
			remove(recruitProcess);
		}
	}

	/**
	 * Returns the number of recruit processes.
	 *
	 * @return the number of recruit processes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECRUITPROCESS);

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
		return RecruitProcessModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the recruit process persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RecruitProcessImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RECRUITPROCESS = "SELECT recruitProcess FROM RecruitProcess recruitProcess";
	private static final String _SQL_SELECT_RECRUITPROCESS_WHERE_PKS_IN = "SELECT recruitProcess FROM RecruitProcess recruitProcess WHERE recruitProcessId IN (";
	private static final String _SQL_SELECT_RECRUITPROCESS_WHERE = "SELECT recruitProcess FROM RecruitProcess recruitProcess WHERE ";
	private static final String _SQL_COUNT_RECRUITPROCESS = "SELECT COUNT(recruitProcess) FROM RecruitProcess recruitProcess";
	private static final String _SQL_COUNT_RECRUITPROCESS_WHERE = "SELECT COUNT(recruitProcess) FROM RecruitProcess recruitProcess WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recruitProcess.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RecruitProcess exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RecruitProcess exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RecruitProcessPersistenceImpl.class);
}