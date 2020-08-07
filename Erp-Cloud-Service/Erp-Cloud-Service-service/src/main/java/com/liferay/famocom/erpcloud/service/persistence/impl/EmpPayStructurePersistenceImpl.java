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

import com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.impl.EmpPayStructureImpl;
import com.liferay.famocom.erpcloud.model.impl.EmpPayStructureModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.EmpPayStructurePersistence;

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
 * The persistence implementation for the emp pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmpPayStructurePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.EmpPayStructureUtil
 * @generated
 */
@ProviderType
public class EmpPayStructurePersistenceImpl extends BasePersistenceImpl<EmpPayStructure>
	implements EmpPayStructurePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpPayStructureUtil} to access the emp pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpPayStructureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmpPayStructureModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findByemployeeId(long employeeId) {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @return the range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findByemployeeId(long employeeId, int start,
		int end) {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<EmpPayStructure> orderByComparator) {
		return findByemployeeId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator<EmpPayStructure> orderByComparator,
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

		List<EmpPayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<EmpPayStructure>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmpPayStructure empPayStructure : list) {
					if ((employeeId != empPayStructure.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
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
	 * Returns the first emp pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findByemployeeId_First(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (empPayStructure != null) {
			return empPayStructure;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchEmpPayStructureException(msg.toString());
	}

	/**
	 * Returns the first emp pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchByemployeeId_First(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		List<EmpPayStructure> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findByemployeeId_Last(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (empPayStructure != null) {
			return empPayStructure;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchEmpPayStructureException(msg.toString());
	}

	/**
	 * Returns the last emp pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchByemployeeId_Last(long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpPayStructure> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp pay structures before and after the current emp pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param empPayStructureId the primary key of the current emp pay structure
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp pay structure
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure[] findByemployeeId_PrevAndNext(
		long empPayStructureId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = findByPrimaryKey(empPayStructureId);

		Session session = null;

		try {
			session = openSession();

			EmpPayStructure[] array = new EmpPayStructureImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, empPayStructure,
					employeeId, orderByComparator, true);

			array[1] = empPayStructure;

			array[2] = getByemployeeId_PrevAndNext(session, empPayStructure,
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

	protected EmpPayStructure getByemployeeId_PrevAndNext(Session session,
		EmpPayStructure empPayStructure, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

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
			query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empPayStructure);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpPayStructure> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp pay structures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByemployeeId(long employeeId) {
		for (EmpPayStructure empPayStructure : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empPayStructure);
		}
	}

	/**
	 * Returns the number of emp pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching emp pay structures
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPPAYSTRUCTURE_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "empPayStructure.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypayComponentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypayComponentId",
			new String[] { Long.class.getName() },
			EmpPayStructureModelImpl.PAYCOMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAYCOMPONENTID = new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypayComponentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp pay structures where payComponentId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @return the matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentId(long payComponentId) {
		return findBypayComponentId(payComponentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp pay structures where payComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @return the range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentId(long payComponentId,
		int start, int end) {
		return findBypayComponentId(payComponentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where payComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentId(long payComponentId,
		int start, int end, OrderByComparator<EmpPayStructure> orderByComparator) {
		return findBypayComponentId(payComponentId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where payComponentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentId(long payComponentId,
		int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTID;
			finderArgs = new Object[] { payComponentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTID;
			finderArgs = new Object[] {
					payComponentId,
					
					start, end, orderByComparator
				};
		}

		List<EmpPayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<EmpPayStructure>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmpPayStructure empPayStructure : list) {
					if ((payComponentId != empPayStructure.getPayComponentId())) {
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

			query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTID_PAYCOMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentId);

				if (!pagination) {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
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
	 * Returns the first emp pay structure in the ordered set where payComponentId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findBypayComponentId_First(long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchBypayComponentId_First(payComponentId,
				orderByComparator);

		if (empPayStructure != null) {
			return empPayStructure;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payComponentId=");
		msg.append(payComponentId);

		msg.append("}");

		throw new NoSuchEmpPayStructureException(msg.toString());
	}

	/**
	 * Returns the first emp pay structure in the ordered set where payComponentId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchBypayComponentId_First(long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		List<EmpPayStructure> list = findBypayComponentId(payComponentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp pay structure in the ordered set where payComponentId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findBypayComponentId_Last(long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchBypayComponentId_Last(payComponentId,
				orderByComparator);

		if (empPayStructure != null) {
			return empPayStructure;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payComponentId=");
		msg.append(payComponentId);

		msg.append("}");

		throw new NoSuchEmpPayStructureException(msg.toString());
	}

	/**
	 * Returns the last emp pay structure in the ordered set where payComponentId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchBypayComponentId_Last(long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		int count = countBypayComponentId(payComponentId);

		if (count == 0) {
			return null;
		}

		List<EmpPayStructure> list = findBypayComponentId(payComponentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp pay structures before and after the current emp pay structure in the ordered set where payComponentId = &#63;.
	 *
	 * @param empPayStructureId the primary key of the current emp pay structure
	 * @param payComponentId the pay component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp pay structure
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure[] findBypayComponentId_PrevAndNext(
		long empPayStructureId, long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = findByPrimaryKey(empPayStructureId);

		Session session = null;

		try {
			session = openSession();

			EmpPayStructure[] array = new EmpPayStructureImpl[3];

			array[0] = getBypayComponentId_PrevAndNext(session,
					empPayStructure, payComponentId, orderByComparator, true);

			array[1] = empPayStructure;

			array[2] = getBypayComponentId_PrevAndNext(session,
					empPayStructure, payComponentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpPayStructure getBypayComponentId_PrevAndNext(Session session,
		EmpPayStructure empPayStructure, long payComponentId,
		OrderByComparator<EmpPayStructure> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

		query.append(_FINDER_COLUMN_PAYCOMPONENTID_PAYCOMPONENTID_2);

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
			query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(payComponentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empPayStructure);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpPayStructure> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp pay structures where payComponentId = &#63; from the database.
	 *
	 * @param payComponentId the pay component ID
	 */
	@Override
	public void removeBypayComponentId(long payComponentId) {
		for (EmpPayStructure empPayStructure : findBypayComponentId(
				payComponentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empPayStructure);
		}
	}

	/**
	 * Returns the number of emp pay structures where payComponentId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @return the number of matching emp pay structures
	 */
	@Override
	public int countBypayComponentId(long payComponentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYCOMPONENTID;

		Object[] finderArgs = new Object[] { payComponentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTID_PAYCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentId);

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

	private static final String _FINDER_COLUMN_PAYCOMPONENTID_PAYCOMPONENTID_2 = "empPayStructure.payComponentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypayComponentIdsAndemployeeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypayComponentIdsAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmpPayStructureModelImpl.PAYCOMPONENTID_COLUMN_BITMASK |
			EmpPayStructureModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypayComponentIdsAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBypayComponentIdsAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @return the matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId) {
		return findBypayComponentIdsAndemployeeId(payComponentId, employeeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @return the range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end) {
		return findBypayComponentIdsAndemployeeId(payComponentId, employeeId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return findBypayComponentIdsAndemployeeId(payComponentId, employeeId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long payComponentId, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID;
			finderArgs = new Object[] { payComponentId, employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID;
			finderArgs = new Object[] {
					payComponentId, employeeId,
					
					start, end, orderByComparator
				};
		}

		List<EmpPayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<EmpPayStructure>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmpPayStructure empPayStructure : list) {
					if ((payComponentId != empPayStructure.getPayComponentId()) ||
							(employeeId != empPayStructure.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_2);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentId);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
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
	 * Returns the first emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findBypayComponentIdsAndemployeeId_First(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchBypayComponentIdsAndemployeeId_First(payComponentId,
				employeeId, orderByComparator);

		if (empPayStructure != null) {
			return empPayStructure;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payComponentId=");
		msg.append(payComponentId);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchEmpPayStructureException(msg.toString());
	}

	/**
	 * Returns the first emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchBypayComponentIdsAndemployeeId_First(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		List<EmpPayStructure> list = findBypayComponentIdsAndemployeeId(payComponentId,
				employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findBypayComponentIdsAndemployeeId_Last(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchBypayComponentIdsAndemployeeId_Last(payComponentId,
				employeeId, orderByComparator);

		if (empPayStructure != null) {
			return empPayStructure;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payComponentId=");
		msg.append(payComponentId);

		msg.append(", employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchEmpPayStructureException(msg.toString());
	}

	/**
	 * Returns the last emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchBypayComponentIdsAndemployeeId_Last(
		long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		int count = countBypayComponentIdsAndemployeeId(payComponentId,
				employeeId);

		if (count == 0) {
			return null;
		}

		List<EmpPayStructure> list = findBypayComponentIdsAndemployeeId(payComponentId,
				employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp pay structures before and after the current emp pay structure in the ordered set where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param empPayStructureId the primary key of the current emp pay structure
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp pay structure
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure[] findBypayComponentIdsAndemployeeId_PrevAndNext(
		long empPayStructureId, long payComponentId, long employeeId,
		OrderByComparator<EmpPayStructure> orderByComparator)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = findByPrimaryKey(empPayStructureId);

		Session session = null;

		try {
			session = openSession();

			EmpPayStructure[] array = new EmpPayStructureImpl[3];

			array[0] = getBypayComponentIdsAndemployeeId_PrevAndNext(session,
					empPayStructure, payComponentId, employeeId,
					orderByComparator, true);

			array[1] = empPayStructure;

			array[2] = getBypayComponentIdsAndemployeeId_PrevAndNext(session,
					empPayStructure, payComponentId, employeeId,
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

	protected EmpPayStructure getBypayComponentIdsAndemployeeId_PrevAndNext(
		Session session, EmpPayStructure empPayStructure, long payComponentId,
		long employeeId, OrderByComparator<EmpPayStructure> orderByComparator,
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

		query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

		query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_2);

		query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_EMPLOYEEID_2);

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
			query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(payComponentId);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empPayStructure);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpPayStructure> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentIds the pay component IDs
	 * @param employeeId the employee ID
	 * @return the matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId) {
		return findBypayComponentIdsAndemployeeId(payComponentIds, employeeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentIds the pay component IDs
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @return the range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end) {
		return findBypayComponentIdsAndemployeeId(payComponentIds, employeeId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentIds the pay component IDs
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return findBypayComponentIdsAndemployeeId(payComponentIds, employeeId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emp pay structures where payComponentId = &#63; and employeeId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findBypayComponentIdsAndemployeeId(
		long[] payComponentIds, long employeeId, int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
		boolean retrieveFromCache) {
		if (payComponentIds == null) {
			payComponentIds = new long[0];
		}
		else if (payComponentIds.length > 1) {
			payComponentIds = ArrayUtil.unique(payComponentIds);

			Arrays.sort(payComponentIds);
		}

		if (payComponentIds.length == 1) {
			return findBypayComponentIdsAndemployeeId(payComponentIds[0],
				employeeId, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(payComponentIds), employeeId
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(payComponentIds), employeeId,
					
					start, end, orderByComparator
				};
		}

		List<EmpPayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<EmpPayStructure>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmpPayStructure empPayStructure : list) {
					if (!ArrayUtil.contains(payComponentIds,
								empPayStructure.getPayComponentId()) ||
							(employeeId != empPayStructure.getEmployeeId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

			if (payComponentIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_7);

				query.append(StringUtil.merge(payComponentIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_EMPLOYEEID_2);

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpPayStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
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
	 * Removes all the emp pay structures where payComponentId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeBypayComponentIdsAndemployeeId(long payComponentId,
		long employeeId) {
		for (EmpPayStructure empPayStructure : findBypayComponentIdsAndemployeeId(
				payComponentId, employeeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(empPayStructure);
		}
	}

	/**
	 * Returns the number of emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @return the number of matching emp pay structures
	 */
	@Override
	public int countBypayComponentIdsAndemployeeId(long payComponentId,
		long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { payComponentId, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_2);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentId);

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

	/**
	 * Returns the number of emp pay structures where payComponentId = any &#63; and employeeId = &#63;.
	 *
	 * @param payComponentIds the pay component IDs
	 * @param employeeId the employee ID
	 * @return the number of matching emp pay structures
	 */
	@Override
	public int countBypayComponentIdsAndemployeeId(long[] payComponentIds,
		long employeeId) {
		if (payComponentIds == null) {
			payComponentIds = new long[0];
		}
		else if (payComponentIds.length > 1) {
			payComponentIds = ArrayUtil.unique(payComponentIds);

			Arrays.sort(payComponentIds);
		}

		Object[] finderArgs = new Object[] {
				StringUtil.merge(payComponentIds), employeeId
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_EMPPAYSTRUCTURE_WHERE);

			if (payComponentIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_7);

				query.append(StringUtil.merge(payComponentIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_EMPLOYEEID_2);

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

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_2 =
		"empPayStructure.payComponentId = ? AND ";
	private static final String _FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_PAYCOMPONENTID_7 =
		"empPayStructure.payComponentId IN (";
	private static final String _FINDER_COLUMN_PAYCOMPONENTIDSANDEMPLOYEEID_EMPLOYEEID_2 =
		"empPayStructure.employeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypayComponentIdAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmpPayStructureModelImpl.PAYCOMPONENTID_COLUMN_BITMASK |
			EmpPayStructureModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAYCOMPONENTIDANDEMPLOYEEID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypayComponentIdAndemployeeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @return the matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchBypayComponentIdAndemployeeId(payComponentId,
				employeeId);

		if (empPayStructure == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("payComponentId=");
			msg.append(payComponentId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmpPayStructureException(msg.toString());
		}

		return empPayStructure;
	}

	/**
	 * Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId) {
		return fetchBypayComponentIdAndemployeeId(payComponentId, employeeId,
			true);
	}

	/**
	 * Returns the emp pay structure where payComponentId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { payComponentId, employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof EmpPayStructure) {
			EmpPayStructure empPayStructure = (EmpPayStructure)result;

			if ((payComponentId != empPayStructure.getPayComponentId()) ||
					(employeeId != empPayStructure.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDANDEMPLOYEEID_PAYCOMPONENTID_2);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentId);

				qPos.add(employeeId);

				List<EmpPayStructure> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"EmpPayStructurePersistenceImpl.fetchBypayComponentIdAndemployeeId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmpPayStructure empPayStructure = list.get(0);

					result = empPayStructure;

					cacheResult(empPayStructure);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
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
			return (EmpPayStructure)result;
		}
	}

	/**
	 * Removes the emp pay structure where payComponentId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @return the emp pay structure that was removed
	 */
	@Override
	public EmpPayStructure removeBypayComponentIdAndemployeeId(
		long payComponentId, long employeeId)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = findBypayComponentIdAndemployeeId(payComponentId,
				employeeId);

		return remove(empPayStructure);
	}

	/**
	 * Returns the number of emp pay structures where payComponentId = &#63; and employeeId = &#63;.
	 *
	 * @param payComponentId the pay component ID
	 * @param employeeId the employee ID
	 * @return the number of matching emp pay structures
	 */
	@Override
	public int countBypayComponentIdAndemployeeId(long payComponentId,
		long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYCOMPONENTIDANDEMPLOYEEID;

		Object[] finderArgs = new Object[] { payComponentId, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDANDEMPLOYEEID_PAYCOMPONENTID_2);

			query.append(_FINDER_COLUMN_PAYCOMPONENTIDANDEMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentId);

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

	private static final String _FINDER_COLUMN_PAYCOMPONENTIDANDEMPLOYEEID_PAYCOMPONENTID_2 =
		"empPayStructure.payComponentId = ? AND ";
	private static final String _FINDER_COLUMN_PAYCOMPONENTIDANDEMPLOYEEID_EMPLOYEEID_2 =
		"empPayStructure.employeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED,
			EmpPayStructureImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemployeeIdPayComponentId",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmpPayStructureModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			EmpPayStructureModelImpl.PAYCOMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDPAYCOMPONENTID =
		new FinderPath(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdPayComponentId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the matching emp pay structure
	 * @throws NoSuchEmpPayStructureException if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure findByemployeeIdPayComponentId(long employeeId,
		long payComponentId) throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchByemployeeIdPayComponentId(employeeId,
				payComponentId);

		if (empPayStructure == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", payComponentId=");
			msg.append(payComponentId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmpPayStructureException(msg.toString());
		}

		return empPayStructure;
	}

	/**
	 * Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchByemployeeIdPayComponentId(long employeeId,
		long payComponentId) {
		return fetchByemployeeIdPayComponentId(employeeId, payComponentId, true);
	}

	/**
	 * Returns the emp pay structure where employeeId = &#63; and payComponentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching emp pay structure, or <code>null</code> if a matching emp pay structure could not be found
	 */
	@Override
	public EmpPayStructure fetchByemployeeIdPayComponentId(long employeeId,
		long payComponentId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, payComponentId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
					finderArgs, this);
		}

		if (result instanceof EmpPayStructure) {
			EmpPayStructure empPayStructure = (EmpPayStructure)result;

			if ((employeeId != empPayStructure.getEmployeeId()) ||
					(payComponentId != empPayStructure.getPayComponentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDPAYCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDPAYCOMPONENTID_PAYCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(payComponentId);

				List<EmpPayStructure> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"EmpPayStructurePersistenceImpl.fetchByemployeeIdPayComponentId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmpPayStructure empPayStructure = list.get(0);

					result = empPayStructure;

					cacheResult(empPayStructure);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
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
			return (EmpPayStructure)result;
		}
	}

	/**
	 * Removes the emp pay structure where employeeId = &#63; and payComponentId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the emp pay structure that was removed
	 */
	@Override
	public EmpPayStructure removeByemployeeIdPayComponentId(long employeeId,
		long payComponentId) throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = findByemployeeIdPayComponentId(employeeId,
				payComponentId);

		return remove(empPayStructure);
	}

	/**
	 * Returns the number of emp pay structures where employeeId = &#63; and payComponentId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param payComponentId the pay component ID
	 * @return the number of matching emp pay structures
	 */
	@Override
	public int countByemployeeIdPayComponentId(long employeeId,
		long payComponentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDPAYCOMPONENTID;

		Object[] finderArgs = new Object[] { employeeId, payComponentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDPAYCOMPONENTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_EMPLOYEEIDPAYCOMPONENTID_PAYCOMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(payComponentId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEIDPAYCOMPONENTID_EMPLOYEEID_2 =
		"empPayStructure.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDPAYCOMPONENTID_PAYCOMPONENTID_2 =
		"empPayStructure.payComponentId = ?";

	public EmpPayStructurePersistenceImpl() {
		setModelClass(EmpPayStructure.class);
	}

	/**
	 * Caches the emp pay structure in the entity cache if it is enabled.
	 *
	 * @param empPayStructure the emp pay structure
	 */
	@Override
	public void cacheResult(EmpPayStructure empPayStructure) {
		entityCache.putResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureImpl.class, empPayStructure.getPrimaryKey(),
			empPayStructure);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
			new Object[] {
				empPayStructure.getPayComponentId(),
				empPayStructure.getEmployeeId()
			}, empPayStructure);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
			new Object[] {
				empPayStructure.getEmployeeId(),
				empPayStructure.getPayComponentId()
			}, empPayStructure);

		empPayStructure.resetOriginalValues();
	}

	/**
	 * Caches the emp pay structures in the entity cache if it is enabled.
	 *
	 * @param empPayStructures the emp pay structures
	 */
	@Override
	public void cacheResult(List<EmpPayStructure> empPayStructures) {
		for (EmpPayStructure empPayStructure : empPayStructures) {
			if (entityCache.getResult(
						EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
						EmpPayStructureImpl.class,
						empPayStructure.getPrimaryKey()) == null) {
				cacheResult(empPayStructure);
			}
			else {
				empPayStructure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp pay structures.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmpPayStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp pay structure.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpPayStructure empPayStructure) {
		entityCache.removeResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureImpl.class, empPayStructure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EmpPayStructureModelImpl)empPayStructure, true);
	}

	@Override
	public void clearCache(List<EmpPayStructure> empPayStructures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpPayStructure empPayStructure : empPayStructures) {
			entityCache.removeResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
				EmpPayStructureImpl.class, empPayStructure.getPrimaryKey());

			clearUniqueFindersCache((EmpPayStructureModelImpl)empPayStructure,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		EmpPayStructureModelImpl empPayStructureModelImpl) {
		Object[] args = new Object[] {
				empPayStructureModelImpl.getPayComponentId(),
				empPayStructureModelImpl.getEmployeeId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTIDANDEMPLOYEEID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
			args, empPayStructureModelImpl, false);

		args = new Object[] {
				empPayStructureModelImpl.getEmployeeId(),
				empPayStructureModelImpl.getPayComponentId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDPAYCOMPONENTID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
			args, empPayStructureModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EmpPayStructureModelImpl empPayStructureModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					empPayStructureModelImpl.getPayComponentId(),
					empPayStructureModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTIDANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
				args);
		}

		if ((empPayStructureModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					empPayStructureModelImpl.getOriginalPayComponentId(),
					empPayStructureModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTIDANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PAYCOMPONENTIDANDEMPLOYEEID,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					empPayStructureModelImpl.getEmployeeId(),
					empPayStructureModelImpl.getPayComponentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDPAYCOMPONENTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
				args);
		}

		if ((empPayStructureModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					empPayStructureModelImpl.getOriginalEmployeeId(),
					empPayStructureModelImpl.getOriginalPayComponentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDPAYCOMPONENTID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDPAYCOMPONENTID,
				args);
		}
	}

	/**
	 * Creates a new emp pay structure with the primary key. Does not add the emp pay structure to the database.
	 *
	 * @param empPayStructureId the primary key for the new emp pay structure
	 * @return the new emp pay structure
	 */
	@Override
	public EmpPayStructure create(long empPayStructureId) {
		EmpPayStructure empPayStructure = new EmpPayStructureImpl();

		empPayStructure.setNew(true);
		empPayStructure.setPrimaryKey(empPayStructureId);

		return empPayStructure;
	}

	/**
	 * Removes the emp pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empPayStructureId the primary key of the emp pay structure
	 * @return the emp pay structure that was removed
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure remove(long empPayStructureId)
		throws NoSuchEmpPayStructureException {
		return remove((Serializable)empPayStructureId);
	}

	/**
	 * Removes the emp pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp pay structure
	 * @return the emp pay structure that was removed
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure remove(Serializable primaryKey)
		throws NoSuchEmpPayStructureException {
		Session session = null;

		try {
			session = openSession();

			EmpPayStructure empPayStructure = (EmpPayStructure)session.get(EmpPayStructureImpl.class,
					primaryKey);

			if (empPayStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpPayStructureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empPayStructure);
		}
		catch (NoSuchEmpPayStructureException nsee) {
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
	protected EmpPayStructure removeImpl(EmpPayStructure empPayStructure) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empPayStructure)) {
				empPayStructure = (EmpPayStructure)session.get(EmpPayStructureImpl.class,
						empPayStructure.getPrimaryKeyObj());
			}

			if (empPayStructure != null) {
				session.delete(empPayStructure);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empPayStructure != null) {
			clearCache(empPayStructure);
		}

		return empPayStructure;
	}

	@Override
	public EmpPayStructure updateImpl(EmpPayStructure empPayStructure) {
		boolean isNew = empPayStructure.isNew();

		if (!(empPayStructure instanceof EmpPayStructureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(empPayStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(empPayStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in empPayStructure proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmpPayStructure implementation " +
				empPayStructure.getClass());
		}

		EmpPayStructureModelImpl empPayStructureModelImpl = (EmpPayStructureModelImpl)empPayStructure;

		Session session = null;

		try {
			session = openSession();

			if (empPayStructure.isNew()) {
				session.save(empPayStructure);

				empPayStructure.setNew(false);
			}
			else {
				empPayStructure = (EmpPayStructure)session.merge(empPayStructure);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EmpPayStructureModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					empPayStructureModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
				args);

			args = new Object[] { empPayStructureModelImpl.getPayComponentId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTID,
				args);

			args = new Object[] {
					empPayStructureModelImpl.getPayComponentId(),
					empPayStructureModelImpl.getEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((empPayStructureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empPayStructureModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { empPayStructureModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((empPayStructureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empPayStructureModelImpl.getOriginalPayComponentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTID,
					args);

				args = new Object[] { empPayStructureModelImpl.getPayComponentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTID,
					args);
			}

			if ((empPayStructureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empPayStructureModelImpl.getOriginalPayComponentId(),
						empPayStructureModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					args);

				args = new Object[] {
						empPayStructureModelImpl.getPayComponentId(),
						empPayStructureModelImpl.getEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTIDSANDEMPLOYEEID,
					args);
			}
		}

		entityCache.putResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
			EmpPayStructureImpl.class, empPayStructure.getPrimaryKey(),
			empPayStructure, false);

		clearUniqueFindersCache(empPayStructureModelImpl, false);
		cacheUniqueFindersCache(empPayStructureModelImpl);

		empPayStructure.resetOriginalValues();

		return empPayStructure;
	}

	/**
	 * Returns the emp pay structure with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp pay structure
	 * @return the emp pay structure
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpPayStructureException {
		EmpPayStructure empPayStructure = fetchByPrimaryKey(primaryKey);

		if (empPayStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpPayStructureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empPayStructure;
	}

	/**
	 * Returns the emp pay structure with the primary key or throws a {@link NoSuchEmpPayStructureException} if it could not be found.
	 *
	 * @param empPayStructureId the primary key of the emp pay structure
	 * @return the emp pay structure
	 * @throws NoSuchEmpPayStructureException if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure findByPrimaryKey(long empPayStructureId)
		throws NoSuchEmpPayStructureException {
		return findByPrimaryKey((Serializable)empPayStructureId);
	}

	/**
	 * Returns the emp pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp pay structure
	 * @return the emp pay structure, or <code>null</code> if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
				EmpPayStructureImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmpPayStructure empPayStructure = (EmpPayStructure)serializable;

		if (empPayStructure == null) {
			Session session = null;

			try {
				session = openSession();

				empPayStructure = (EmpPayStructure)session.get(EmpPayStructureImpl.class,
						primaryKey);

				if (empPayStructure != null) {
					cacheResult(empPayStructure);
				}
				else {
					entityCache.putResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
						EmpPayStructureImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
					EmpPayStructureImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empPayStructure;
	}

	/**
	 * Returns the emp pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empPayStructureId the primary key of the emp pay structure
	 * @return the emp pay structure, or <code>null</code> if a emp pay structure with the primary key could not be found
	 */
	@Override
	public EmpPayStructure fetchByPrimaryKey(long empPayStructureId) {
		return fetchByPrimaryKey((Serializable)empPayStructureId);
	}

	@Override
	public Map<Serializable, EmpPayStructure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmpPayStructure> map = new HashMap<Serializable, EmpPayStructure>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmpPayStructure empPayStructure = fetchByPrimaryKey(primaryKey);

			if (empPayStructure != null) {
				map.put(primaryKey, empPayStructure);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
					EmpPayStructureImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmpPayStructure)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMPPAYSTRUCTURE_WHERE_PKS_IN);

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

			for (EmpPayStructure empPayStructure : (List<EmpPayStructure>)q.list()) {
				map.put(empPayStructure.getPrimaryKeyObj(), empPayStructure);

				cacheResult(empPayStructure);

				uncachedPrimaryKeys.remove(empPayStructure.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmpPayStructureModelImpl.ENTITY_CACHE_ENABLED,
					EmpPayStructureImpl.class, primaryKey, nullModel);
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
	 * Returns all the emp pay structures.
	 *
	 * @return the emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @return the range of emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findAll(int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the emp pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmpPayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp pay structures
	 * @param end the upper bound of the range of emp pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of emp pay structures
	 */
	@Override
	public List<EmpPayStructure> findAll(int start, int end,
		OrderByComparator<EmpPayStructure> orderByComparator,
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

		List<EmpPayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<EmpPayStructure>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMPPAYSTRUCTURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPPAYSTRUCTURE;

				if (pagination) {
					sql = sql.concat(EmpPayStructureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmpPayStructure>)QueryUtil.list(q,
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
	 * Removes all the emp pay structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmpPayStructure empPayStructure : findAll()) {
			remove(empPayStructure);
		}
	}

	/**
	 * Returns the number of emp pay structures.
	 *
	 * @return the number of emp pay structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPPAYSTRUCTURE);

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
		return EmpPayStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the emp pay structure persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmpPayStructureImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMPPAYSTRUCTURE = "SELECT empPayStructure FROM EmpPayStructure empPayStructure";
	private static final String _SQL_SELECT_EMPPAYSTRUCTURE_WHERE_PKS_IN = "SELECT empPayStructure FROM EmpPayStructure empPayStructure WHERE empPayStructureId IN (";
	private static final String _SQL_SELECT_EMPPAYSTRUCTURE_WHERE = "SELECT empPayStructure FROM EmpPayStructure empPayStructure WHERE ";
	private static final String _SQL_COUNT_EMPPAYSTRUCTURE = "SELECT COUNT(empPayStructure) FROM EmpPayStructure empPayStructure";
	private static final String _SQL_COUNT_EMPPAYSTRUCTURE_WHERE = "SELECT COUNT(empPayStructure) FROM EmpPayStructure empPayStructure WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empPayStructure.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpPayStructure exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpPayStructure exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmpPayStructurePersistenceImpl.class);
}