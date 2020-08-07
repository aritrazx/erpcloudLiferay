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

import com.liferay.famocom.erpcloud.exception.NoSuchSalDetailsException;
import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.impl.SalDetailsImpl;
import com.liferay.famocom.erpcloud.model.impl.SalDetailsModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.SalDetailsPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
 * The persistence implementation for the sal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SalDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.SalDetailsUtil
 * @generated
 */
@ProviderType
public class SalDetailsPersistenceImpl extends BasePersistenceImpl<SalDetails>
	implements SalDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SalDetailsUtil} to access the sal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SalDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sal detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeId(long employeeId) {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeId(long employeeId, int start, int end) {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeId_First(long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeId_First(long employeeId,
		OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeId_Last(long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeId_Last(long employeeId,
		OrderByComparator<SalDetails> orderByComparator) {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findByemployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findByemployeeId_PrevAndNext(long SalDetailsId,
		long employeeId, OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, salDetails,
					employeeId, orderByComparator, true);

			array[1] = salDetails;

			array[2] = getByemployeeId_PrevAndNext(session, salDetails,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalDetails getByemployeeId_PrevAndNext(Session session,
		SalDetails salDetails, long employeeId,
		OrderByComparator<SalDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sal detailses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByemployeeId(long employeeId) {
		for (SalDetails salDetails : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "salDetails.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymonthYear",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymonthYear",
			new String[] { Long.class.getName() },
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEAR = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymonthYear",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sal detailses where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYear(long monthYear) {
		return findBymonthYear(monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the sal detailses where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYear(long monthYear, int start, int end) {
		return findBymonthYear(monthYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYear(long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findBymonthYear(monthYear, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYear(long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR;
			finderArgs = new Object[] { monthYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEAR;
			finderArgs = new Object[] { monthYear, start, end, orderByComparator };
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((monthYear != salDetails.getMonthYear())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findBymonthYear_First(long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchBymonthYear_First(monthYear,
				orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchBymonthYear_First(long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findBymonthYear(monthYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findBymonthYear_Last(long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchBymonthYear_Last(monthYear,
				orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchBymonthYear_Last(long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		int count = countBymonthYear(monthYear);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findBymonthYear(monthYear, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where monthYear = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findBymonthYear_PrevAndNext(long SalDetailsId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getBymonthYear_PrevAndNext(session, salDetails,
					monthYear, orderByComparator, true);

			array[1] = salDetails;

			array[2] = getBymonthYear_PrevAndNext(session, salDetails,
					monthYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalDetails getBymonthYear_PrevAndNext(Session session,
		SalDetails salDetails, long monthYear,
		OrderByComparator<SalDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sal detailses where monthYear = &#63; from the database.
	 *
	 * @param monthYear the month year
	 */
	@Override
	public void removeBymonthYear(long monthYear) {
		for (SalDetails salDetails : findBymonthYear(monthYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countBymonthYear(long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEAR;

		Object[] finderArgs = new Object[] { monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2 = "salDetails.monthYear = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymonthYearAndemployeeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymonthYearAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK |
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymonthYearAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYearAndemployeeId(long monthYear,
		long employeeId) {
		return findBymonthYearAndemployeeId(monthYear, employeeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYearAndemployeeId(long monthYear,
		long employeeId, int start, int end) {
		return findBymonthYearAndemployeeId(monthYear, employeeId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYearAndemployeeId(long monthYear,
		long employeeId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findBymonthYearAndemployeeId(monthYear, employeeId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where monthYear = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findBymonthYearAndemployeeId(long monthYear,
		long employeeId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID;
			finderArgs = new Object[] { monthYear, employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID;
			finderArgs = new Object[] {
					monthYear, employeeId,
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((monthYear != salDetails.getMonthYear()) ||
							(employeeId != salDetails.getEmployeeId())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findBymonthYearAndemployeeId_First(long monthYear,
		long employeeId, OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchBymonthYearAndemployeeId_First(monthYear,
				employeeId, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchBymonthYearAndemployeeId_First(long monthYear,
		long employeeId, OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findBymonthYearAndemployeeId(monthYear,
				employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId, OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchBymonthYearAndemployeeId_Last(monthYear,
				employeeId, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("monthYear=");
		msg.append(monthYear);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchBymonthYearAndemployeeId_Last(long monthYear,
		long employeeId, OrderByComparator<SalDetails> orderByComparator) {
		int count = countBymonthYearAndemployeeId(monthYear, employeeId);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findBymonthYearAndemployeeId(monthYear,
				employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findBymonthYearAndemployeeId_PrevAndNext(
		long SalDetailsId, long monthYear, long employeeId,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getBymonthYearAndemployeeId_PrevAndNext(session,
					salDetails, monthYear, employeeId, orderByComparator, true);

			array[1] = salDetails;

			array[2] = getBymonthYearAndemployeeId_PrevAndNext(session,
					salDetails, monthYear, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalDetails getBymonthYearAndemployeeId_PrevAndNext(
		Session session, SalDetails salDetails, long monthYear,
		long employeeId, OrderByComparator<SalDetails> orderByComparator,
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

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_MONTHYEAR_2);

		query.append(_FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(monthYear);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sal detailses where monthYear = &#63; and employeeId = &#63; from the database.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeBymonthYearAndemployeeId(long monthYear, long employeeId) {
		for (SalDetails salDetails : findBymonthYearAndemployeeId(monthYear,
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where monthYear = &#63; and employeeId = &#63;.
	 *
	 * @param monthYear the month year
	 * @param employeeId the employee ID
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countBymonthYearAndemployeeId(long monthYear, long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { monthYear, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

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
		"salDetails.monthYear = ? AND ";
	private static final String _FINDER_COLUMN_MONTHYEARANDEMPLOYEEID_EMPLOYEEID_2 =
		"salDetails.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeIdAndMonthYear",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() },
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR = new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByemployeeIdAndMonthYear",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long monthYear) {
		return findByemployeeIdAndMonthYear(employeeId, monthYear,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long monthYear, int start, int end) {
		return findByemployeeIdAndMonthYear(employeeId, monthYear, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndMonthYear(employeeId, monthYear, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
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

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							(monthYear != salDetails.getMonthYear())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndMonthYear_First(long employeeId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndMonthYear_First(employeeId,
				monthYear, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndMonthYear_First(long employeeId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findByemployeeIdAndMonthYear(employeeId,
				monthYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndMonthYear_Last(long employeeId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndMonthYear_Last(employeeId,
				monthYear, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndMonthYear_Last(long employeeId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator) {
		int count = countByemployeeIdAndMonthYear(employeeId, monthYear);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findByemployeeIdAndMonthYear(employeeId,
				monthYear, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findByemployeeIdAndMonthYear_PrevAndNext(
		long SalDetailsId, long employeeId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getByemployeeIdAndMonthYear_PrevAndNext(session,
					salDetails, employeeId, monthYear, orderByComparator, true);

			array[1] = salDetails;

			array[2] = getByemployeeIdAndMonthYear_PrevAndNext(session,
					salDetails, employeeId, monthYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalDetails getByemployeeIdAndMonthYear_PrevAndNext(
		Session session, SalDetails salDetails, long employeeId,
		long monthYear, OrderByComparator<SalDetails> orderByComparator,
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

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sal detailses where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long[] monthYears) {
		return findByemployeeIdAndMonthYear(employeeId, monthYears,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long[] monthYears, int start, int end) {
		return findByemployeeIdAndMonthYear(employeeId, monthYears, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long[] monthYears, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndMonthYear(employeeId, monthYears, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYear(long employeeId,
		long[] monthYears, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
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

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							!ArrayUtil.contains(monthYears,
								salDetails.getMonthYear())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

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
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the sal detailses where employeeId = &#63; and monthYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 */
	@Override
	public void removeByemployeeIdAndMonthYear(long employeeId, long monthYear) {
		for (SalDetails salDetails : findByemployeeIdAndMonthYear(employeeId,
				monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndMonthYear(long employeeId, long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR;

		Object[] finderArgs = new Object[] { employeeId, monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

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
	 * Returns the number of sal detailses where employeeId = &#63; and monthYear = any &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYears the month years
	 * @return the number of matching sal detailses
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

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

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
		"salDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_2 =
		"salDetails.monthYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEAR_MONTHYEAR_7 =
		"salDetails.monthYear IN (";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeIdAndComponentIdmonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeIdAndComponentIdmonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SalDetailsModelImpl.COMPONENTID_COLUMN_BITMASK |
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndComponentIdmonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByemployeeIdAndComponentIdmonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear) {
		return findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end) {
		return findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentId, monthYear, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS;
			finderArgs = new Object[] { employeeId, componentId, monthYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS;
			finderArgs = new Object[] {
					employeeId, componentId, monthYear,
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							(componentId != salDetails.getComponentId()) ||
							(monthYear != salDetails.getMonthYear())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

				qPos.add(monthYear);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndComponentIdmonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndComponentIdmonthYears_First(employeeId,
				componentId, monthYear, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndComponentIdmonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findByemployeeIdAndComponentIdmonthYears(employeeId,
				componentId, monthYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndComponentIdmonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndComponentIdmonthYears_Last(employeeId,
				componentId, monthYear, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndComponentIdmonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		int count = countByemployeeIdAndComponentIdmonthYears(employeeId,
				componentId, monthYear);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findByemployeeIdAndComponentIdmonthYears(employeeId,
				componentId, monthYear, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findByemployeeIdAndComponentIdmonthYears_PrevAndNext(
		long SalDetailsId, long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getByemployeeIdAndComponentIdmonthYears_PrevAndNext(session,
					salDetails, employeeId, componentId, monthYear,
					orderByComparator, true);

			array[1] = salDetails;

			array[2] = getByemployeeIdAndComponentIdmonthYears_PrevAndNext(session,
					salDetails, employeeId, componentId, monthYear,
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

	protected SalDetails getByemployeeIdAndComponentIdmonthYears_PrevAndNext(
		Session session, SalDetails salDetails, long employeeId,
		long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_2);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(componentId);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentIds the component IDs
	 * @param monthYears the month years
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears) {
		return findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentIds the component IDs
	 * @param monthYears the month years
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end) {
		return findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentIds the component IDs
	 * @param monthYears the month years
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndComponentIdmonthYears(employeeId,
			componentIds, monthYears, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdmonthYears(
		long employeeId, long[] componentIds, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		if (componentIds == null) {
			componentIds = new long[0];
		}
		else if (componentIds.length > 1) {
			componentIds = ArrayUtil.unique(componentIds);

			Arrays.sort(componentIds);
		}

		if (monthYears == null) {
			monthYears = new long[0];
		}
		else if (monthYears.length > 1) {
			monthYears = ArrayUtil.unique(monthYears);

			Arrays.sort(monthYears);
		}

		if ((componentIds.length == 1) && (monthYears.length == 1)) {
			return findByemployeeIdAndComponentIdmonthYears(employeeId,
				componentIds[0], monthYears[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					employeeId, StringUtil.merge(componentIds),
					StringUtil.merge(monthYears)
				};
		}
		else {
			finderArgs = new Object[] {
					employeeId, StringUtil.merge(componentIds),
					StringUtil.merge(monthYears),
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							!ArrayUtil.contains(componentIds,
								salDetails.getComponentId()) ||
							!ArrayUtil.contains(monthYears,
								salDetails.getMonthYear())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_EMPLOYEEID_2);

			if (componentIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_7);

				query.append(StringUtil.merge(componentIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			if (monthYears.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_7);

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
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
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
	 * Removes all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 */
	@Override
	public void removeByemployeeIdAndComponentIdmonthYears(long employeeId,
		long componentId, long monthYear) {
		for (SalDetails salDetails : findByemployeeIdAndComponentIdmonthYears(
				employeeId, componentId, monthYear, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndComponentIdmonthYears(long employeeId,
		long componentId, long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS;

		Object[] finderArgs = new Object[] { employeeId, componentId, monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

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
	 * Returns the number of sal detailses where employeeId = &#63; and componentId = any &#63; and monthYear = any &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentIds the component IDs
	 * @param monthYears the month years
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndComponentIdmonthYears(long employeeId,
		long[] componentIds, long[] monthYears) {
		if (componentIds == null) {
			componentIds = new long[0];
		}
		else if (componentIds.length > 1) {
			componentIds = ArrayUtil.unique(componentIds);

			Arrays.sort(componentIds);
		}

		if (monthYears == null) {
			monthYears = new long[0];
		}
		else if (monthYears.length > 1) {
			monthYears = ArrayUtil.unique(monthYears);

			Arrays.sort(monthYears);
		}

		Object[] finderArgs = new Object[] {
				employeeId, StringUtil.merge(componentIds),
				StringUtil.merge(monthYears)
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_EMPLOYEEID_2);

			if (componentIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_7);

				query.append(StringUtil.merge(componentIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			if (monthYears.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_7);

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

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_EMPLOYEEID_2 =
		"salDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_2 =
		"salDetails.componentId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_COMPONENTID_7 =
		"salDetails.componentId IN (";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_2 =
		"salDetails.monthYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS_MONTHYEAR_7 =
		"salDetails.monthYear IN (";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeIdAndMonthYearAndComponentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeIdAndMonthYearAndComponentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK |
			SalDetailsModelImpl.COMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndMonthYearAndComponentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByemployeeIdAndMonthYearAndComponentId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId) {
		return findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end) {
		return findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long componentId, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID;
			finderArgs = new Object[] { employeeId, monthYear, componentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID;
			finderArgs = new Object[] {
					employeeId, monthYear, componentId,
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							(monthYear != salDetails.getMonthYear()) ||
							(componentId != salDetails.getComponentId())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(monthYear);

				qPos.add(componentId);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndMonthYearAndComponentId_First(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndMonthYearAndComponentId_First(employeeId,
				monthYear, componentId, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndMonthYearAndComponentId_First(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findByemployeeIdAndMonthYearAndComponentId(employeeId,
				monthYear, componentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndMonthYearAndComponentId_Last(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndMonthYearAndComponentId_Last(employeeId,
				monthYear, componentId, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndMonthYearAndComponentId_Last(
		long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator) {
		int count = countByemployeeIdAndMonthYearAndComponentId(employeeId,
				monthYear, componentId);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findByemployeeIdAndMonthYearAndComponentId(employeeId,
				monthYear, componentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findByemployeeIdAndMonthYearAndComponentId_PrevAndNext(
		long SalDetailsId, long employeeId, long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getByemployeeIdAndMonthYearAndComponentId_PrevAndNext(session,
					salDetails, employeeId, monthYear, componentId,
					orderByComparator, true);

			array[1] = salDetails;

			array[2] = getByemployeeIdAndMonthYearAndComponentId_PrevAndNext(session,
					salDetails, employeeId, monthYear, componentId,
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

	protected SalDetails getByemployeeIdAndMonthYearAndComponentId_PrevAndNext(
		Session session, SalDetails salDetails, long employeeId,
		long monthYear, long componentId,
		OrderByComparator<SalDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_MONTHYEAR_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_2);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(monthYear);

		qPos.add(componentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentIds the component IDs
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds) {
		return findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentIds the component IDs
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start, int end) {
		return findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentIds the component IDs
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndMonthYearAndComponentId(employeeId,
			monthYear, componentIds, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndMonthYearAndComponentId(
		long employeeId, long monthYear, long[] componentIds, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		if (componentIds == null) {
			componentIds = new long[0];
		}
		else if (componentIds.length > 1) {
			componentIds = ArrayUtil.unique(componentIds);

			Arrays.sort(componentIds);
		}

		if (componentIds.length == 1) {
			return findByemployeeIdAndMonthYearAndComponentId(employeeId,
				monthYear, componentIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					employeeId, monthYear, StringUtil.merge(componentIds)
				};
		}
		else {
			finderArgs = new Object[] {
					employeeId, monthYear, StringUtil.merge(componentIds),
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							(monthYear != salDetails.getMonthYear()) ||
							!ArrayUtil.contains(componentIds,
								salDetails.getComponentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_MONTHYEAR_2);

			if (componentIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_7);

				query.append(StringUtil.merge(componentIds));

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
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
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
	 * Removes all the sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 */
	@Override
	public void removeByemployeeIdAndMonthYearAndComponentId(long employeeId,
		long monthYear, long componentId) {
		for (SalDetails salDetails : findByemployeeIdAndMonthYearAndComponentId(
				employeeId, monthYear, componentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentId the component ID
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndMonthYearAndComponentId(long employeeId,
		long monthYear, long componentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID;

		Object[] finderArgs = new Object[] { employeeId, monthYear, componentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_MONTHYEAR_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(monthYear);

				qPos.add(componentId);

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
	 * Returns the number of sal detailses where employeeId = &#63; and monthYear = &#63; and componentId = any &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param monthYear the month year
	 * @param componentIds the component IDs
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndMonthYearAndComponentId(long employeeId,
		long monthYear, long[] componentIds) {
		if (componentIds == null) {
			componentIds = new long[0];
		}
		else if (componentIds.length > 1) {
			componentIds = ArrayUtil.unique(componentIds);

			Arrays.sort(componentIds);
		}

		Object[] finderArgs = new Object[] {
				employeeId, monthYear, StringUtil.merge(componentIds)
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_MONTHYEAR_2);

			if (componentIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_7);

				query.append(StringUtil.merge(componentIds));

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

				qPos.add(monthYear);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_EMPLOYEEID_2 =
		"salDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_MONTHYEAR_2 =
		"salDetails.monthYear = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_2 =
		"salDetails.componentId = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID_COMPONENTID_7 =
		"salDetails.componentId IN (";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByemployeeIdAndComponentIdAndMonthYear",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SalDetailsModelImpl.COMPONENTID_COLUMN_BITMASK |
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndComponentIdAndMonthYear",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or throws a {@link NoSuchSalDetailsException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndComponentIdAndMonthYear(employeeId,
				componentId, monthYear);

		if (salDetails == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", componentId=");
			msg.append(componentId);

			msg.append(", monthYear=");
			msg.append(monthYear);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSalDetailsException(msg.toString());
		}

		return salDetails;
	}

	/**
	 * Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear) {
		return fetchByemployeeIdAndComponentIdAndMonthYear(employeeId,
			componentId, monthYear, true);
	}

	/**
	 * Returns the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, componentId, monthYear };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
					finderArgs, this);
		}

		if (result instanceof SalDetails) {
			SalDetails salDetails = (SalDetails)result;

			if ((employeeId != salDetails.getEmployeeId()) ||
					(componentId != salDetails.getComponentId()) ||
					(monthYear != salDetails.getMonthYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_COMPONENTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

				qPos.add(monthYear);

				List<SalDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"SalDetailsPersistenceImpl.fetchByemployeeIdAndComponentIdAndMonthYear(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SalDetails salDetails = list.get(0);

					result = salDetails;

					cacheResult(salDetails);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
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
			return (SalDetails)result;
		}
	}

	/**
	 * Removes the sal details where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the sal details that was removed
	 */
	@Override
	public SalDetails removeByemployeeIdAndComponentIdAndMonthYear(
		long employeeId, long componentId, long monthYear)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByemployeeIdAndComponentIdAndMonthYear(employeeId,
				componentId, monthYear);

		return remove(salDetails);
	}

	/**
	 * Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndComponentIdAndMonthYear(long employeeId,
		long componentId, long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR;

		Object[] finderArgs = new Object[] { employeeId, componentId, monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_COMPONENTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_EMPLOYEEID_2 =
		"salDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_COMPONENTID_2 =
		"salDetails.componentId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR_MONTHYEAR_2 =
		"salDetails.monthYear = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeIdAndComponentIdAndMonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, SalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemployeeIdAndComponentIdAndMonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			SalDetailsModelImpl.COMPONENTID_COLUMN_BITMASK |
			SalDetailsModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndComponentIdAndMonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS =
		new FinderPath(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByemployeeIdAndComponentIdAndMonthYears",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear) {
		return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end) {
		return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYear, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long monthYear, int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS;
			finderArgs = new Object[] { employeeId, componentId, monthYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS;
			finderArgs = new Object[] {
					employeeId, componentId, monthYear,
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							(componentId != salDetails.getComponentId()) ||
							(monthYear != salDetails.getMonthYear())) {
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

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_COMPONENTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

				qPos.add(monthYear);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndComponentIdAndMonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndComponentIdAndMonthYears_First(employeeId,
				componentId, monthYear, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the first sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYears_First(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		List<SalDetails> list = findByemployeeIdAndComponentIdAndMonthYears(employeeId,
				componentId, monthYear, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details
	 * @throws NoSuchSalDetailsException if a matching sal details could not be found
	 */
	@Override
	public SalDetails findByemployeeIdAndComponentIdAndMonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByemployeeIdAndComponentIdAndMonthYears_Last(employeeId,
				componentId, monthYear, orderByComparator);

		if (salDetails != null) {
			return salDetails;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append(", monthYear=");
		msg.append(monthYear);

		msg.append("}");

		throw new NoSuchSalDetailsException(msg.toString());
	}

	/**
	 * Returns the last sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sal details, or <code>null</code> if a matching sal details could not be found
	 */
	@Override
	public SalDetails fetchByemployeeIdAndComponentIdAndMonthYears_Last(
		long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator) {
		int count = countByemployeeIdAndComponentIdAndMonthYears(employeeId,
				componentId, monthYear);

		if (count == 0) {
			return null;
		}

		List<SalDetails> list = findByemployeeIdAndComponentIdAndMonthYears(employeeId,
				componentId, monthYear, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sal detailses before and after the current sal details in the ordered set where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param SalDetailsId the primary key of the current sal details
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails[] findByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(
		long SalDetailsId, long employeeId, long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = findByPrimaryKey(SalDetailsId);

		Session session = null;

		try {
			session = openSession();

			SalDetails[] array = new SalDetailsImpl[3];

			array[0] = getByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(session,
					salDetails, employeeId, componentId, monthYear,
					orderByComparator, true);

			array[1] = salDetails;

			array[2] = getByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(session,
					salDetails, employeeId, componentId, monthYear,
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

	protected SalDetails getByemployeeIdAndComponentIdAndMonthYears_PrevAndNext(
		Session session, SalDetails salDetails, long employeeId,
		long componentId, long monthYear,
		OrderByComparator<SalDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SALDETAILS_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_COMPONENTID_2);

		query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_2);

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
			query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(componentId);

		qPos.add(monthYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYears the month years
	 * @return the matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears) {
		return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYears the month years
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start, int end) {
		return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYears the month years
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator) {
		return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
			componentId, monthYears, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sal detailses
	 */
	@Override
	public List<SalDetails> findByemployeeIdAndComponentIdAndMonthYears(
		long employeeId, long componentId, long[] monthYears, int start,
		int end, OrderByComparator<SalDetails> orderByComparator,
		boolean retrieveFromCache) {
		if (monthYears == null) {
			monthYears = new long[0];
		}
		else if (monthYears.length > 1) {
			monthYears = ArrayUtil.unique(monthYears);

			Arrays.sort(monthYears);
		}

		if (monthYears.length == 1) {
			return findByemployeeIdAndComponentIdAndMonthYears(employeeId,
				componentId, monthYears[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					employeeId, componentId, StringUtil.merge(monthYears)
				};
		}
		else {
			finderArgs = new Object[] {
					employeeId, componentId, StringUtil.merge(monthYears),
					
					start, end, orderByComparator
				};
		}

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalDetails salDetails : list) {
					if ((employeeId != salDetails.getEmployeeId()) ||
							(componentId != salDetails.getComponentId()) ||
							!ArrayUtil.contains(monthYears,
								salDetails.getMonthYear())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_COMPONENTID_2);

			if (monthYears.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_7);

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
				query.append(SalDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
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
	 * Removes all the sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 */
	@Override
	public void removeByemployeeIdAndComponentIdAndMonthYears(long employeeId,
		long componentId, long monthYear) {
		for (SalDetails salDetails : findByemployeeIdAndComponentIdAndMonthYears(
				employeeId, componentId, monthYear, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYear the month year
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndComponentIdAndMonthYears(long employeeId,
		long componentId, long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS;

		Object[] finderArgs = new Object[] { employeeId, componentId, monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_COMPONENTID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(componentId);

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
	 * Returns the number of sal detailses where employeeId = &#63; and componentId = &#63; and monthYear = any &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param componentId the component ID
	 * @param monthYears the month years
	 * @return the number of matching sal detailses
	 */
	@Override
	public int countByemployeeIdAndComponentIdAndMonthYears(long employeeId,
		long componentId, long[] monthYears) {
		if (monthYears == null) {
			monthYears = new long[0];
		}
		else if (monthYears.length > 1) {
			monthYears = ArrayUtil.unique(monthYears);

			Arrays.sort(monthYears);
		}

		Object[] finderArgs = new Object[] {
				employeeId, componentId, StringUtil.merge(monthYears)
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_COMPONENTID_2);

			if (monthYears.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_7);

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

				qPos.add(componentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_EMPLOYEEID_2 =
		"salDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_COMPONENTID_2 =
		"salDetails.componentId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_2 =
		"salDetails.monthYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS_MONTHYEAR_7 =
		"salDetails.monthYear IN (";

	public SalDetailsPersistenceImpl() {
		setModelClass(SalDetails.class);
	}

	/**
	 * Caches the sal details in the entity cache if it is enabled.
	 *
	 * @param salDetails the sal details
	 */
	@Override
	public void cacheResult(SalDetails salDetails) {
		entityCache.putResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsImpl.class, salDetails.getPrimaryKey(), salDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
			new Object[] {
				salDetails.getEmployeeId(), salDetails.getComponentId(),
				salDetails.getMonthYear()
			}, salDetails);

		salDetails.resetOriginalValues();
	}

	/**
	 * Caches the sal detailses in the entity cache if it is enabled.
	 *
	 * @param salDetailses the sal detailses
	 */
	@Override
	public void cacheResult(List<SalDetails> salDetailses) {
		for (SalDetails salDetails : salDetailses) {
			if (entityCache.getResult(
						SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						SalDetailsImpl.class, salDetails.getPrimaryKey()) == null) {
				cacheResult(salDetails);
			}
			else {
				salDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sal detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sal details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalDetails salDetails) {
		entityCache.removeResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsImpl.class, salDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SalDetailsModelImpl)salDetails, true);
	}

	@Override
	public void clearCache(List<SalDetails> salDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SalDetails salDetails : salDetailses) {
			entityCache.removeResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				SalDetailsImpl.class, salDetails.getPrimaryKey());

			clearUniqueFindersCache((SalDetailsModelImpl)salDetails, true);
		}
	}

	protected void cacheUniqueFindersCache(
		SalDetailsModelImpl salDetailsModelImpl) {
		Object[] args = new Object[] {
				salDetailsModelImpl.getEmployeeId(),
				salDetailsModelImpl.getComponentId(),
				salDetailsModelImpl.getMonthYear()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
			args, salDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SalDetailsModelImpl salDetailsModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					salDetailsModelImpl.getEmployeeId(),
					salDetailsModelImpl.getComponentId(),
					salDetailsModelImpl.getMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
				args);
		}

		if ((salDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					salDetailsModelImpl.getOriginalEmployeeId(),
					salDetailsModelImpl.getOriginalComponentId(),
					salDetailsModelImpl.getOriginalMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEAR,
				args);
		}
	}

	/**
	 * Creates a new sal details with the primary key. Does not add the sal details to the database.
	 *
	 * @param SalDetailsId the primary key for the new sal details
	 * @return the new sal details
	 */
	@Override
	public SalDetails create(long SalDetailsId) {
		SalDetails salDetails = new SalDetailsImpl();

		salDetails.setNew(true);
		salDetails.setPrimaryKey(SalDetailsId);

		return salDetails;
	}

	/**
	 * Removes the sal details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SalDetailsId the primary key of the sal details
	 * @return the sal details that was removed
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails remove(long SalDetailsId)
		throws NoSuchSalDetailsException {
		return remove((Serializable)SalDetailsId);
	}

	/**
	 * Removes the sal details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sal details
	 * @return the sal details that was removed
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails remove(Serializable primaryKey)
		throws NoSuchSalDetailsException {
		Session session = null;

		try {
			session = openSession();

			SalDetails salDetails = (SalDetails)session.get(SalDetailsImpl.class,
					primaryKey);

			if (salDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(salDetails);
		}
		catch (NoSuchSalDetailsException nsee) {
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
	protected SalDetails removeImpl(SalDetails salDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salDetails)) {
				salDetails = (SalDetails)session.get(SalDetailsImpl.class,
						salDetails.getPrimaryKeyObj());
			}

			if (salDetails != null) {
				session.delete(salDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (salDetails != null) {
			clearCache(salDetails);
		}

		return salDetails;
	}

	@Override
	public SalDetails updateImpl(SalDetails salDetails) {
		boolean isNew = salDetails.isNew();

		if (!(salDetails instanceof SalDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(salDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(salDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in salDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SalDetails implementation " +
				salDetails.getClass());
		}

		SalDetailsModelImpl salDetailsModelImpl = (SalDetailsModelImpl)salDetails;

		Session session = null;

		try {
			session = openSession();

			if (salDetails.isNew()) {
				session.save(salDetails);

				salDetails.setNew(false);
			}
			else {
				salDetails = (SalDetails)session.merge(salDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SalDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { salDetailsModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
				args);

			args = new Object[] { salDetailsModelImpl.getMonthYear() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
				args);

			args = new Object[] {
					salDetailsModelImpl.getMonthYear(),
					salDetailsModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID,
				args);

			args = new Object[] {
					salDetailsModelImpl.getEmployeeId(),
					salDetailsModelImpl.getMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
				args);

			args = new Object[] {
					salDetailsModelImpl.getEmployeeId(),
					salDetailsModelImpl.getComponentId(),
					salDetailsModelImpl.getMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
				args);

			args = new Object[] {
					salDetailsModelImpl.getEmployeeId(),
					salDetailsModelImpl.getMonthYear(),
					salDetailsModelImpl.getComponentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
				args);

			args = new Object[] {
					salDetailsModelImpl.getEmployeeId(),
					salDetailsModelImpl.getComponentId(),
					salDetailsModelImpl.getMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { salDetailsModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
					args);

				args = new Object[] { salDetailsModelImpl.getMonthYear() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEAR,
					args);
			}

			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalMonthYear(),
						salDetailsModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID,
					args);

				args = new Object[] {
						salDetailsModelImpl.getMonthYear(),
						salDetailsModelImpl.getEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEARANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHYEARANDEMPLOYEEID,
					args);
			}

			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalEmployeeId(),
						salDetailsModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					args);

				args = new Object[] {
						salDetailsModelImpl.getEmployeeId(),
						salDetailsModelImpl.getMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEAR,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEAR,
					args);
			}

			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalEmployeeId(),
						salDetailsModelImpl.getOriginalComponentId(),
						salDetailsModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					args);

				args = new Object[] {
						salDetailsModelImpl.getEmployeeId(),
						salDetailsModelImpl.getComponentId(),
						salDetailsModelImpl.getMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDMONTHYEARS,
					args);
			}

			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalEmployeeId(),
						salDetailsModelImpl.getOriginalMonthYear(),
						salDetailsModelImpl.getOriginalComponentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					args);

				args = new Object[] {
						salDetailsModelImpl.getEmployeeId(),
						salDetailsModelImpl.getMonthYear(),
						salDetailsModelImpl.getComponentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDMONTHYEARANDCOMPONENTID,
					args);
			}

			if ((salDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salDetailsModelImpl.getOriginalEmployeeId(),
						salDetailsModelImpl.getOriginalComponentId(),
						salDetailsModelImpl.getOriginalMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					args);

				args = new Object[] {
						salDetailsModelImpl.getEmployeeId(),
						salDetailsModelImpl.getComponentId(),
						salDetailsModelImpl.getMonthYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEIDANDCOMPONENTIDANDMONTHYEARS,
					args);
			}
		}

		entityCache.putResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			SalDetailsImpl.class, salDetails.getPrimaryKey(), salDetails, false);

		clearUniqueFindersCache(salDetailsModelImpl, false);
		cacheUniqueFindersCache(salDetailsModelImpl);

		salDetails.resetOriginalValues();

		return salDetails;
	}

	/**
	 * Returns the sal details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sal details
	 * @return the sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalDetailsException {
		SalDetails salDetails = fetchByPrimaryKey(primaryKey);

		if (salDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return salDetails;
	}

	/**
	 * Returns the sal details with the primary key or throws a {@link NoSuchSalDetailsException} if it could not be found.
	 *
	 * @param SalDetailsId the primary key of the sal details
	 * @return the sal details
	 * @throws NoSuchSalDetailsException if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails findByPrimaryKey(long SalDetailsId)
		throws NoSuchSalDetailsException {
		return findByPrimaryKey((Serializable)SalDetailsId);
	}

	/**
	 * Returns the sal details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sal details
	 * @return the sal details, or <code>null</code> if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				SalDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SalDetails salDetails = (SalDetails)serializable;

		if (salDetails == null) {
			Session session = null;

			try {
				session = openSession();

				salDetails = (SalDetails)session.get(SalDetailsImpl.class,
						primaryKey);

				if (salDetails != null) {
					cacheResult(salDetails);
				}
				else {
					entityCache.putResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						SalDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					SalDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return salDetails;
	}

	/**
	 * Returns the sal details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SalDetailsId the primary key of the sal details
	 * @return the sal details, or <code>null</code> if a sal details with the primary key could not be found
	 */
	@Override
	public SalDetails fetchByPrimaryKey(long SalDetailsId) {
		return fetchByPrimaryKey((Serializable)SalDetailsId);
	}

	@Override
	public Map<Serializable, SalDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SalDetails> map = new HashMap<Serializable, SalDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SalDetails salDetails = fetchByPrimaryKey(primaryKey);

			if (salDetails != null) {
				map.put(primaryKey, salDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					SalDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SalDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SALDETAILS_WHERE_PKS_IN);

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

			for (SalDetails salDetails : (List<SalDetails>)q.list()) {
				map.put(salDetails.getPrimaryKeyObj(), salDetails);

				cacheResult(salDetails);

				uncachedPrimaryKeys.remove(salDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					SalDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the sal detailses.
	 *
	 * @return the sal detailses
	 */
	@Override
	public List<SalDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @return the range of sal detailses
	 */
	@Override
	public List<SalDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sal detailses
	 */
	@Override
	public List<SalDetails> findAll(int start, int end,
		OrderByComparator<SalDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sal detailses
	 * @param end the upper bound of the range of sal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sal detailses
	 */
	@Override
	public List<SalDetails> findAll(int start, int end,
		OrderByComparator<SalDetails> orderByComparator,
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

		List<SalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<SalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SALDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SALDETAILS;

				if (pagination) {
					sql = sql.concat(SalDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the sal detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalDetails salDetails : findAll()) {
			remove(salDetails);
		}
	}

	/**
	 * Returns the number of sal detailses.
	 *
	 * @return the number of sal detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SALDETAILS);

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
		return SalDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sal details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SalDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SALDETAILS = "SELECT salDetails FROM SalDetails salDetails";
	private static final String _SQL_SELECT_SALDETAILS_WHERE_PKS_IN = "SELECT salDetails FROM SalDetails salDetails WHERE SalDetailsId IN (";
	private static final String _SQL_SELECT_SALDETAILS_WHERE = "SELECT salDetails FROM SalDetails salDetails WHERE ";
	private static final String _SQL_COUNT_SALDETAILS = "SELECT COUNT(salDetails) FROM SalDetails salDetails";
	private static final String _SQL_COUNT_SALDETAILS_WHERE = "SELECT COUNT(salDetails) FROM SalDetails salDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "salDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SalDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SalDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SalDetailsPersistenceImpl.class);
}