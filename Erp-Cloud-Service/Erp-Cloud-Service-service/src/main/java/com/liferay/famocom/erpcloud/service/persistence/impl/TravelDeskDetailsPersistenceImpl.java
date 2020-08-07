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

import com.liferay.famocom.erpcloud.exception.NoSuchTravelDeskDetailsException;
import com.liferay.famocom.erpcloud.model.TravelDeskDetails;
import com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsImpl;
import com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TravelDeskDetailsPersistence;

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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
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
 * The persistence implementation for the travel desk details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TravelDeskDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TravelDeskDetailsUtil
 * @generated
 */
@ProviderType
public class TravelDeskDetailsPersistenceImpl extends BasePersistenceImpl<TravelDeskDetails>
	implements TravelDeskDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TravelDeskDetailsUtil} to access the travel desk details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TravelDeskDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED,
			TravelDeskDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED,
			TravelDeskDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRAVEL = new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED,
			TravelDeskDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytravel",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVEL =
		new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED,
			TravelDeskDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytravel",
			new String[] { Long.class.getName() },
			TravelDeskDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRAVEL = new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytravel",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the travel desk detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findBytravel(long employeeId) {
		return findBytravel(employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the travel desk detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @return the range of matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findBytravel(long employeeId, int start,
		int end) {
		return findBytravel(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel desk detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findBytravel(long employeeId, int start,
		int end, OrderByComparator<TravelDeskDetails> orderByComparator) {
		return findBytravel(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel desk detailses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findBytravel(long employeeId, int start,
		int end, OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVEL;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRAVEL;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<TravelDeskDetails> list = null;

		if (retrieveFromCache) {
			list = (List<TravelDeskDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDeskDetails travelDeskDetails : list) {
					if ((employeeId != travelDeskDetails.getEmployeeId())) {
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

			query.append(_SQL_SELECT_TRAVELDESKDETAILS_WHERE);

			query.append(_FINDER_COLUMN_TRAVEL_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TravelDeskDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<TravelDeskDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TravelDeskDetails>)QueryUtil.list(q,
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
	 * Returns the first travel desk details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails findBytravel_First(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = fetchBytravel_First(employeeId,
				orderByComparator);

		if (travelDeskDetails != null) {
			return travelDeskDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchTravelDeskDetailsException(msg.toString());
	}

	/**
	 * Returns the first travel desk details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails fetchBytravel_First(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		List<TravelDeskDetails> list = findBytravel(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel desk details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails findBytravel_Last(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = fetchBytravel_Last(employeeId,
				orderByComparator);

		if (travelDeskDetails != null) {
			return travelDeskDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchTravelDeskDetailsException(msg.toString());
	}

	/**
	 * Returns the last travel desk details in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails fetchBytravel_Last(long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		int count = countBytravel(employeeId);

		if (count == 0) {
			return null;
		}

		List<TravelDeskDetails> list = findBytravel(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel desk detailses before and after the current travel desk details in the ordered set where employeeId = &#63;.
	 *
	 * @param travelDetailsId the primary key of the current travel desk details
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails[] findBytravel_PrevAndNext(long travelDetailsId,
		long employeeId, OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = findByPrimaryKey(travelDetailsId);

		Session session = null;

		try {
			session = openSession();

			TravelDeskDetails[] array = new TravelDeskDetailsImpl[3];

			array[0] = getBytravel_PrevAndNext(session, travelDeskDetails,
					employeeId, orderByComparator, true);

			array[1] = travelDeskDetails;

			array[2] = getBytravel_PrevAndNext(session, travelDeskDetails,
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

	protected TravelDeskDetails getBytravel_PrevAndNext(Session session,
		TravelDeskDetails travelDeskDetails, long employeeId,
		OrderByComparator<TravelDeskDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRAVELDESKDETAILS_WHERE);

		query.append(_FINDER_COLUMN_TRAVEL_EMPLOYEEID_2);

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
			query.append(TravelDeskDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(travelDeskDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TravelDeskDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel desk detailses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeBytravel(long employeeId) {
		for (TravelDeskDetails travelDeskDetails : findBytravel(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(travelDeskDetails);
		}
	}

	/**
	 * Returns the number of travel desk detailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching travel desk detailses
	 */
	@Override
	public int countBytravel(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TRAVEL;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRAVELDESKDETAILS_WHERE);

			query.append(_FINDER_COLUMN_TRAVEL_EMPLOYEEID_2);

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

	private static final String _FINDER_COLUMN_TRAVEL_EMPLOYEEID_2 = "travelDeskDetails.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTMEMBERLIST =
		new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED,
			TravelDeskDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByprojectMemberList",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBERLIST =
		new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED,
			TravelDeskDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByprojectMemberList", new String[] { Long.class.getName() },
			TravelDeskDetailsModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTMEMBERLIST = new FinderPath(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByprojectMemberList", new String[] { Long.class.getName() });

	/**
	 * Returns all the travel desk detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findByprojectMemberList(long projectId) {
		return findByprojectMemberList(projectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel desk detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @return the range of matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findByprojectMemberList(long projectId,
		int start, int end) {
		return findByprojectMemberList(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel desk detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findByprojectMemberList(long projectId,
		int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return findByprojectMemberList(projectId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel desk detailses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findByprojectMemberList(long projectId,
		int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBERLIST;
			finderArgs = new Object[] { projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTMEMBERLIST;
			finderArgs = new Object[] { projectId, start, end, orderByComparator };
		}

		List<TravelDeskDetails> list = null;

		if (retrieveFromCache) {
			list = (List<TravelDeskDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDeskDetails travelDeskDetails : list) {
					if ((projectId != travelDeskDetails.getProjectId())) {
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

			query.append(_SQL_SELECT_TRAVELDESKDETAILS_WHERE);

			query.append(_FINDER_COLUMN_PROJECTMEMBERLIST_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TravelDeskDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<TravelDeskDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TravelDeskDetails>)QueryUtil.list(q,
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
	 * Returns the first travel desk details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails findByprojectMemberList_First(long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = fetchByprojectMemberList_First(projectId,
				orderByComparator);

		if (travelDeskDetails != null) {
			return travelDeskDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchTravelDeskDetailsException(msg.toString());
	}

	/**
	 * Returns the first travel desk details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails fetchByprojectMemberList_First(long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		List<TravelDeskDetails> list = findByprojectMemberList(projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel desk details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails findByprojectMemberList_Last(long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = fetchByprojectMemberList_Last(projectId,
				orderByComparator);

		if (travelDeskDetails != null) {
			return travelDeskDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchTravelDeskDetailsException(msg.toString());
	}

	/**
	 * Returns the last travel desk details in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel desk details, or <code>null</code> if a matching travel desk details could not be found
	 */
	@Override
	public TravelDeskDetails fetchByprojectMemberList_Last(long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		int count = countByprojectMemberList(projectId);

		if (count == 0) {
			return null;
		}

		List<TravelDeskDetails> list = findByprojectMemberList(projectId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel desk detailses before and after the current travel desk details in the ordered set where projectId = &#63;.
	 *
	 * @param travelDetailsId the primary key of the current travel desk details
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails[] findByprojectMemberList_PrevAndNext(
		long travelDetailsId, long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = findByPrimaryKey(travelDetailsId);

		Session session = null;

		try {
			session = openSession();

			TravelDeskDetails[] array = new TravelDeskDetailsImpl[3];

			array[0] = getByprojectMemberList_PrevAndNext(session,
					travelDeskDetails, projectId, orderByComparator, true);

			array[1] = travelDeskDetails;

			array[2] = getByprojectMemberList_PrevAndNext(session,
					travelDeskDetails, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelDeskDetails getByprojectMemberList_PrevAndNext(
		Session session, TravelDeskDetails travelDeskDetails, long projectId,
		OrderByComparator<TravelDeskDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRAVELDESKDETAILS_WHERE);

		query.append(_FINDER_COLUMN_PROJECTMEMBERLIST_PROJECTID_2);

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
			query.append(TravelDeskDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(travelDeskDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TravelDeskDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel desk detailses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByprojectMemberList(long projectId) {
		for (TravelDeskDetails travelDeskDetails : findByprojectMemberList(
				projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(travelDeskDetails);
		}
	}

	/**
	 * Returns the number of travel desk detailses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching travel desk detailses
	 */
	@Override
	public int countByprojectMemberList(long projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTMEMBERLIST;

		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRAVELDESKDETAILS_WHERE);

			query.append(_FINDER_COLUMN_PROJECTMEMBERLIST_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_PROJECTMEMBERLIST_PROJECTID_2 = "travelDeskDetails.projectId = ?";

	public TravelDeskDetailsPersistenceImpl() {
		setModelClass(TravelDeskDetails.class);
	}

	/**
	 * Caches the travel desk details in the entity cache if it is enabled.
	 *
	 * @param travelDeskDetails the travel desk details
	 */
	@Override
	public void cacheResult(TravelDeskDetails travelDeskDetails) {
		entityCache.putResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsImpl.class, travelDeskDetails.getPrimaryKey(),
			travelDeskDetails);

		travelDeskDetails.resetOriginalValues();
	}

	/**
	 * Caches the travel desk detailses in the entity cache if it is enabled.
	 *
	 * @param travelDeskDetailses the travel desk detailses
	 */
	@Override
	public void cacheResult(List<TravelDeskDetails> travelDeskDetailses) {
		for (TravelDeskDetails travelDeskDetails : travelDeskDetailses) {
			if (entityCache.getResult(
						TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
						TravelDeskDetailsImpl.class,
						travelDeskDetails.getPrimaryKey()) == null) {
				cacheResult(travelDeskDetails);
			}
			else {
				travelDeskDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all travel desk detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDeskDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel desk details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelDeskDetails travelDeskDetails) {
		entityCache.removeResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsImpl.class, travelDeskDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TravelDeskDetails> travelDeskDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TravelDeskDetails travelDeskDetails : travelDeskDetailses) {
			entityCache.removeResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
				TravelDeskDetailsImpl.class, travelDeskDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new travel desk details with the primary key. Does not add the travel desk details to the database.
	 *
	 * @param travelDetailsId the primary key for the new travel desk details
	 * @return the new travel desk details
	 */
	@Override
	public TravelDeskDetails create(long travelDetailsId) {
		TravelDeskDetails travelDeskDetails = new TravelDeskDetailsImpl();

		travelDeskDetails.setNew(true);
		travelDeskDetails.setPrimaryKey(travelDetailsId);

		travelDeskDetails.setCompanyId(companyProvider.getCompanyId());

		return travelDeskDetails;
	}

	/**
	 * Removes the travel desk details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDetailsId the primary key of the travel desk details
	 * @return the travel desk details that was removed
	 * @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails remove(long travelDetailsId)
		throws NoSuchTravelDeskDetailsException {
		return remove((Serializable)travelDetailsId);
	}

	/**
	 * Removes the travel desk details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel desk details
	 * @return the travel desk details that was removed
	 * @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails remove(Serializable primaryKey)
		throws NoSuchTravelDeskDetailsException {
		Session session = null;

		try {
			session = openSession();

			TravelDeskDetails travelDeskDetails = (TravelDeskDetails)session.get(TravelDeskDetailsImpl.class,
					primaryKey);

			if (travelDeskDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDeskDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(travelDeskDetails);
		}
		catch (NoSuchTravelDeskDetailsException nsee) {
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
	protected TravelDeskDetails removeImpl(TravelDeskDetails travelDeskDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDeskDetails)) {
				travelDeskDetails = (TravelDeskDetails)session.get(TravelDeskDetailsImpl.class,
						travelDeskDetails.getPrimaryKeyObj());
			}

			if (travelDeskDetails != null) {
				session.delete(travelDeskDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (travelDeskDetails != null) {
			clearCache(travelDeskDetails);
		}

		return travelDeskDetails;
	}

	@Override
	public TravelDeskDetails updateImpl(TravelDeskDetails travelDeskDetails) {
		boolean isNew = travelDeskDetails.isNew();

		if (!(travelDeskDetails instanceof TravelDeskDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDeskDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(travelDeskDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDeskDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDeskDetails implementation " +
				travelDeskDetails.getClass());
		}

		TravelDeskDetailsModelImpl travelDeskDetailsModelImpl = (TravelDeskDetailsModelImpl)travelDeskDetails;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (travelDeskDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDeskDetails.setCreateDate(now);
			}
			else {
				travelDeskDetails.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!travelDeskDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDeskDetails.setModifiedDate(now);
			}
			else {
				travelDeskDetails.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (travelDeskDetails.isNew()) {
				session.save(travelDeskDetails);

				travelDeskDetails.setNew(false);
			}
			else {
				travelDeskDetails = (TravelDeskDetails)session.merge(travelDeskDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TravelDeskDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					travelDeskDetailsModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TRAVEL, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVEL,
				args);

			args = new Object[] { travelDeskDetailsModelImpl.getProjectId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMEMBERLIST,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBERLIST,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((travelDeskDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						travelDeskDetailsModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TRAVEL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVEL,
					args);

				args = new Object[] { travelDeskDetailsModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TRAVEL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRAVEL,
					args);
			}

			if ((travelDeskDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBERLIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						travelDeskDetailsModelImpl.getOriginalProjectId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMEMBERLIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBERLIST,
					args);

				args = new Object[] { travelDeskDetailsModelImpl.getProjectId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMEMBERLIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBERLIST,
					args);
			}
		}

		entityCache.putResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TravelDeskDetailsImpl.class, travelDeskDetails.getPrimaryKey(),
			travelDeskDetails, false);

		travelDeskDetails.resetOriginalValues();

		return travelDeskDetails;
	}

	/**
	 * Returns the travel desk details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel desk details
	 * @return the travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDeskDetailsException {
		TravelDeskDetails travelDeskDetails = fetchByPrimaryKey(primaryKey);

		if (travelDeskDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDeskDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return travelDeskDetails;
	}

	/**
	 * Returns the travel desk details with the primary key or throws a {@link NoSuchTravelDeskDetailsException} if it could not be found.
	 *
	 * @param travelDetailsId the primary key of the travel desk details
	 * @return the travel desk details
	 * @throws NoSuchTravelDeskDetailsException if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails findByPrimaryKey(long travelDetailsId)
		throws NoSuchTravelDeskDetailsException {
		return findByPrimaryKey((Serializable)travelDetailsId);
	}

	/**
	 * Returns the travel desk details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel desk details
	 * @return the travel desk details, or <code>null</code> if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
				TravelDeskDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TravelDeskDetails travelDeskDetails = (TravelDeskDetails)serializable;

		if (travelDeskDetails == null) {
			Session session = null;

			try {
				session = openSession();

				travelDeskDetails = (TravelDeskDetails)session.get(TravelDeskDetailsImpl.class,
						primaryKey);

				if (travelDeskDetails != null) {
					cacheResult(travelDeskDetails);
				}
				else {
					entityCache.putResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
						TravelDeskDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
					TravelDeskDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return travelDeskDetails;
	}

	/**
	 * Returns the travel desk details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDetailsId the primary key of the travel desk details
	 * @return the travel desk details, or <code>null</code> if a travel desk details with the primary key could not be found
	 */
	@Override
	public TravelDeskDetails fetchByPrimaryKey(long travelDetailsId) {
		return fetchByPrimaryKey((Serializable)travelDetailsId);
	}

	@Override
	public Map<Serializable, TravelDeskDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TravelDeskDetails> map = new HashMap<Serializable, TravelDeskDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TravelDeskDetails travelDeskDetails = fetchByPrimaryKey(primaryKey);

			if (travelDeskDetails != null) {
				map.put(primaryKey, travelDeskDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
					TravelDeskDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TravelDeskDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TRAVELDESKDETAILS_WHERE_PKS_IN);

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

			for (TravelDeskDetails travelDeskDetails : (List<TravelDeskDetails>)q.list()) {
				map.put(travelDeskDetails.getPrimaryKeyObj(), travelDeskDetails);

				cacheResult(travelDeskDetails);

				uncachedPrimaryKeys.remove(travelDeskDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TravelDeskDetailsModelImpl.ENTITY_CACHE_ENABLED,
					TravelDeskDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the travel desk detailses.
	 *
	 * @return the travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel desk detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @return the range of travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel desk detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findAll(int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel desk detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TravelDeskDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel desk detailses
	 * @param end the upper bound of the range of travel desk detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of travel desk detailses
	 */
	@Override
	public List<TravelDeskDetails> findAll(int start, int end,
		OrderByComparator<TravelDeskDetails> orderByComparator,
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

		List<TravelDeskDetails> list = null;

		if (retrieveFromCache) {
			list = (List<TravelDeskDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRAVELDESKDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDESKDETAILS;

				if (pagination) {
					sql = sql.concat(TravelDeskDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TravelDeskDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TravelDeskDetails>)QueryUtil.list(q,
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
	 * Removes all the travel desk detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDeskDetails travelDeskDetails : findAll()) {
			remove(travelDeskDetails);
		}
	}

	/**
	 * Returns the number of travel desk detailses.
	 *
	 * @return the number of travel desk detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRAVELDESKDETAILS);

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
		return TravelDeskDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel desk details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TravelDeskDetailsImpl.class.getName());
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
	private static final String _SQL_SELECT_TRAVELDESKDETAILS = "SELECT travelDeskDetails FROM TravelDeskDetails travelDeskDetails";
	private static final String _SQL_SELECT_TRAVELDESKDETAILS_WHERE_PKS_IN = "SELECT travelDeskDetails FROM TravelDeskDetails travelDeskDetails WHERE travelDetailsId IN (";
	private static final String _SQL_SELECT_TRAVELDESKDETAILS_WHERE = "SELECT travelDeskDetails FROM TravelDeskDetails travelDeskDetails WHERE ";
	private static final String _SQL_COUNT_TRAVELDESKDETAILS = "SELECT COUNT(travelDeskDetails) FROM TravelDeskDetails travelDeskDetails";
	private static final String _SQL_COUNT_TRAVELDESKDETAILS_WHERE = "SELECT COUNT(travelDeskDetails) FROM TravelDeskDetails travelDeskDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "travelDeskDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TravelDeskDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TravelDeskDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TravelDeskDetailsPersistenceImpl.class);
}