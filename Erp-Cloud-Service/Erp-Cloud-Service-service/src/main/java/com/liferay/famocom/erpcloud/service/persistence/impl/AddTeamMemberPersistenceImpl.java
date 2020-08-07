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

import com.liferay.famocom.erpcloud.exception.NoSuchAddTeamMemberException;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.impl.AddTeamMemberImpl;
import com.liferay.famocom.erpcloud.model.impl.AddTeamMemberModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AddTeamMemberPersistence;

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
 * The persistence implementation for the add team member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AddTeamMemberPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AddTeamMemberUtil
 * @generated
 */
@ProviderType
public class AddTeamMemberPersistenceImpl extends BasePersistenceImpl<AddTeamMember>
	implements AddTeamMemberPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AddTeamMemberUtil} to access the add team member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AddTeamMemberImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETPROJECTID =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBygetProjectId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTID =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBygetProjectId",
			new String[] { Long.class.getName(), Long.class.getName() },
			AddTeamMemberModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AddTeamMemberModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETPROJECTID = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetProjectId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the add team members where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @return the matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId) {
		return findBygetProjectId(employeeId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the add team members where employeeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @return the range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end) {
		return findBygetProjectId(employeeId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the add team members where employeeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return findBygetProjectId(employeeId, companyId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the add team members where employeeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectId(long employeeId,
		long companyId, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTID;
			finderArgs = new Object[] { employeeId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETPROJECTID;
			finderArgs = new Object[] {
					employeeId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<AddTeamMember> list = null;

		if (retrieveFromCache) {
			list = (List<AddTeamMember>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AddTeamMember addTeamMember : list) {
					if ((employeeId != addTeamMember.getEmployeeId()) ||
							(companyId != addTeamMember.getCompanyId())) {
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

			query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findBygetProjectId_First(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchBygetProjectId_First(employeeId,
				companyId, orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the first add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectId_First(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator) {
		List<AddTeamMember> list = findBygetProjectId(employeeId, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findBygetProjectId_Last(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchBygetProjectId_Last(employeeId,
				companyId, orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the last add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectId_Last(long employeeId,
		long companyId, OrderByComparator<AddTeamMember> orderByComparator) {
		int count = countBygetProjectId(employeeId, companyId);

		if (count == 0) {
			return null;
		}

		List<AddTeamMember> list = findBygetProjectId(employeeId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the add team members before and after the current add team member in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param projectTeamsId the primary key of the current add team member
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next add team member
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember[] findBygetProjectId_PrevAndNext(long projectTeamsId,
		long employeeId, long companyId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = findByPrimaryKey(projectTeamsId);

		Session session = null;

		try {
			session = openSession();

			AddTeamMember[] array = new AddTeamMemberImpl[3];

			array[0] = getBygetProjectId_PrevAndNext(session, addTeamMember,
					employeeId, companyId, orderByComparator, true);

			array[1] = addTeamMember;

			array[2] = getBygetProjectId_PrevAndNext(session, addTeamMember,
					employeeId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddTeamMember getBygetProjectId_PrevAndNext(Session session,
		AddTeamMember addTeamMember, long employeeId, long companyId,
		OrderByComparator<AddTeamMember> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

		query.append(_FINDER_COLUMN_GETPROJECTID_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_GETPROJECTID_COMPANYID_2);

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
			query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addTeamMember);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddTeamMember> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the add team members where employeeId = &#63; and companyId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeBygetProjectId(long employeeId, long companyId) {
		for (AddTeamMember addTeamMember : findBygetProjectId(employeeId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addTeamMember);
		}
	}

	/**
	 * Returns the number of add team members where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @return the number of matching add team members
	 */
	@Override
	public int countBygetProjectId(long employeeId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETPROJECTID;

		Object[] finderArgs = new Object[] { employeeId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_GETPROJECTID_EMPLOYEEID_2 = "addTeamMember.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_GETPROJECTID_COMPANYID_2 = "addTeamMember.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTMANAGER =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByprojectManager",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMANAGER =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByprojectManager", new String[] { Boolean.class.getName() },
			AddTeamMemberModelImpl.ISPROJECTMANAGER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTMANAGER = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprojectManager",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the add team members where isProjectManager = &#63;.
	 *
	 * @param isProjectManager the is project manager
	 * @return the matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectManager(boolean isProjectManager) {
		return findByprojectManager(isProjectManager, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the add team members where isProjectManager = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isProjectManager the is project manager
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @return the range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectManager(boolean isProjectManager,
		int start, int end) {
		return findByprojectManager(isProjectManager, start, end, null);
	}

	/**
	 * Returns an ordered range of all the add team members where isProjectManager = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isProjectManager the is project manager
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectManager(boolean isProjectManager,
		int start, int end, OrderByComparator<AddTeamMember> orderByComparator) {
		return findByprojectManager(isProjectManager, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the add team members where isProjectManager = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isProjectManager the is project manager
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectManager(boolean isProjectManager,
		int start, int end, OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMANAGER;
			finderArgs = new Object[] { isProjectManager };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTMANAGER;
			finderArgs = new Object[] {
					isProjectManager,
					
					start, end, orderByComparator
				};
		}

		List<AddTeamMember> list = null;

		if (retrieveFromCache) {
			list = (List<AddTeamMember>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AddTeamMember addTeamMember : list) {
					if ((isProjectManager != addTeamMember.isIsProjectManager())) {
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

			query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTMANAGER_ISPROJECTMANAGER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProjectManager);

				if (!pagination) {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first add team member in the ordered set where isProjectManager = &#63;.
	 *
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findByprojectManager_First(boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchByprojectManager_First(isProjectManager,
				orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isProjectManager=");
		msg.append(isProjectManager);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the first add team member in the ordered set where isProjectManager = &#63;.
	 *
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchByprojectManager_First(boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		List<AddTeamMember> list = findByprojectManager(isProjectManager, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last add team member in the ordered set where isProjectManager = &#63;.
	 *
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findByprojectManager_Last(boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchByprojectManager_Last(isProjectManager,
				orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isProjectManager=");
		msg.append(isProjectManager);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the last add team member in the ordered set where isProjectManager = &#63;.
	 *
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchByprojectManager_Last(boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		int count = countByprojectManager(isProjectManager);

		if (count == 0) {
			return null;
		}

		List<AddTeamMember> list = findByprojectManager(isProjectManager,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the add team members before and after the current add team member in the ordered set where isProjectManager = &#63;.
	 *
	 * @param projectTeamsId the primary key of the current add team member
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next add team member
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember[] findByprojectManager_PrevAndNext(
		long projectTeamsId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = findByPrimaryKey(projectTeamsId);

		Session session = null;

		try {
			session = openSession();

			AddTeamMember[] array = new AddTeamMemberImpl[3];

			array[0] = getByprojectManager_PrevAndNext(session, addTeamMember,
					isProjectManager, orderByComparator, true);

			array[1] = addTeamMember;

			array[2] = getByprojectManager_PrevAndNext(session, addTeamMember,
					isProjectManager, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddTeamMember getByprojectManager_PrevAndNext(Session session,
		AddTeamMember addTeamMember, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

		query.append(_FINDER_COLUMN_PROJECTMANAGER_ISPROJECTMANAGER_2);

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
			query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isProjectManager);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addTeamMember);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddTeamMember> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the add team members where isProjectManager = &#63; from the database.
	 *
	 * @param isProjectManager the is project manager
	 */
	@Override
	public void removeByprojectManager(boolean isProjectManager) {
		for (AddTeamMember addTeamMember : findByprojectManager(
				isProjectManager, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addTeamMember);
		}
	}

	/**
	 * Returns the number of add team members where isProjectManager = &#63;.
	 *
	 * @param isProjectManager the is project manager
	 * @return the number of matching add team members
	 */
	@Override
	public int countByprojectManager(boolean isProjectManager) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTMANAGER;

		Object[] finderArgs = new Object[] { isProjectManager };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTMANAGER_ISPROJECTMANAGER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isProjectManager);

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

	private static final String _FINDER_COLUMN_PROJECTMANAGER_ISPROJECTMANAGER_2 =
		"addTeamMember.isProjectManager = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTMEMBER =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByprojectMember",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBER =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByprojectMember", new String[] { Long.class.getName() },
			AddTeamMemberModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTMEMBER = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprojectMember",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the add team members where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectMember(long projectId) {
		return findByprojectMember(projectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the add team members where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @return the range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectMember(long projectId, int start,
		int end) {
		return findByprojectMember(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the add team members where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectMember(long projectId, int start,
		int end, OrderByComparator<AddTeamMember> orderByComparator) {
		return findByprojectMember(projectId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the add team members where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findByprojectMember(long projectId, int start,
		int end, OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBER;
			finderArgs = new Object[] { projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTMEMBER;
			finderArgs = new Object[] { projectId, start, end, orderByComparator };
		}

		List<AddTeamMember> list = null;

		if (retrieveFromCache) {
			list = (List<AddTeamMember>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AddTeamMember addTeamMember : list) {
					if ((projectId != addTeamMember.getProjectId())) {
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

			query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTMEMBER_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first add team member in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findByprojectMember_First(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchByprojectMember_First(projectId,
				orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the first add team member in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchByprojectMember_First(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator) {
		List<AddTeamMember> list = findByprojectMember(projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last add team member in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findByprojectMember_Last(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchByprojectMember_Last(projectId,
				orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the last add team member in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchByprojectMember_Last(long projectId,
		OrderByComparator<AddTeamMember> orderByComparator) {
		int count = countByprojectMember(projectId);

		if (count == 0) {
			return null;
		}

		List<AddTeamMember> list = findByprojectMember(projectId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the add team members before and after the current add team member in the ordered set where projectId = &#63;.
	 *
	 * @param projectTeamsId the primary key of the current add team member
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next add team member
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember[] findByprojectMember_PrevAndNext(
		long projectTeamsId, long projectId,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = findByPrimaryKey(projectTeamsId);

		Session session = null;

		try {
			session = openSession();

			AddTeamMember[] array = new AddTeamMemberImpl[3];

			array[0] = getByprojectMember_PrevAndNext(session, addTeamMember,
					projectId, orderByComparator, true);

			array[1] = addTeamMember;

			array[2] = getByprojectMember_PrevAndNext(session, addTeamMember,
					projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AddTeamMember getByprojectMember_PrevAndNext(Session session,
		AddTeamMember addTeamMember, long projectId,
		OrderByComparator<AddTeamMember> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

		query.append(_FINDER_COLUMN_PROJECTMEMBER_PROJECTID_2);

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
			query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addTeamMember);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddTeamMember> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the add team members where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByprojectMember(long projectId) {
		for (AddTeamMember addTeamMember : findByprojectMember(projectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(addTeamMember);
		}
	}

	/**
	 * Returns the number of add team members where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching add team members
	 */
	@Override
	public int countByprojectMember(long projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTMEMBER;

		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTMEMBER_PROJECTID_2);

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

	private static final String _FINDER_COLUMN_PROJECTMEMBER_PROJECTID_2 = "addTeamMember.projectId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GETPROJECTMANAGER = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBygetProjectManager",
			new String[] { Long.class.getName(), Long.class.getName() },
			AddTeamMemberModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AddTeamMemberModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETPROJECTMANAGER = new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetProjectManager",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the add team member where employeeId = &#63; and projectId = &#63; or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findBygetProjectManager(long employeeId, long projectId)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchBygetProjectManager(employeeId,
				projectId);

		if (addTeamMember == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", projectId=");
			msg.append(projectId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAddTeamMemberException(msg.toString());
		}

		return addTeamMember;
	}

	/**
	 * Returns the add team member where employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectManager(long employeeId,
		long projectId) {
		return fetchBygetProjectManager(employeeId, projectId, true);
	}

	/**
	 * Returns the add team member where employeeId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectManager(long employeeId,
		long projectId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, projectId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER,
					finderArgs, this);
		}

		if (result instanceof AddTeamMember) {
			AddTeamMember addTeamMember = (AddTeamMember)result;

			if ((employeeId != addTeamMember.getEmployeeId()) ||
					(projectId != addTeamMember.getProjectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGER_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGER_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(projectId);

				List<AddTeamMember> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AddTeamMemberPersistenceImpl.fetchBygetProjectManager(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AddTeamMember addTeamMember = list.get(0);

					result = addTeamMember;

					cacheResult(addTeamMember);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER,
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
			return (AddTeamMember)result;
		}
	}

	/**
	 * Removes the add team member where employeeId = &#63; and projectId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the add team member that was removed
	 */
	@Override
	public AddTeamMember removeBygetProjectManager(long employeeId,
		long projectId) throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = findBygetProjectManager(employeeId,
				projectId);

		return remove(addTeamMember);
	}

	/**
	 * Returns the number of add team members where employeeId = &#63; and projectId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @return the number of matching add team members
	 */
	@Override
	public int countBygetProjectManager(long employeeId, long projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETPROJECTMANAGER;

		Object[] finderArgs = new Object[] { employeeId, projectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGER_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGER_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GETPROJECTMANAGER_EMPLOYEEID_2 = "addTeamMember.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_GETPROJECTMANAGER_PROJECTID_2 = "addTeamMember.projectId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBygetProjectManagerProjectList",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBygetProjectManagerProjectList",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			AddTeamMemberModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AddTeamMemberModelImpl.ISPROJECTMANAGER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECTLIST =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetProjectManagerProjectList",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @return the matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager) {
		return findBygetProjectManagerProjectList(employeeId, isProjectManager,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @return the range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end) {
		return findBygetProjectManagerProjectList(employeeId, isProjectManager,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return findBygetProjectManagerProjectList(employeeId, isProjectManager,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the add team members where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching add team members
	 */
	@Override
	public List<AddTeamMember> findBygetProjectManagerProjectList(
		long employeeId, boolean isProjectManager, int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST;
			finderArgs = new Object[] { employeeId, isProjectManager };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST;
			finderArgs = new Object[] {
					employeeId, isProjectManager,
					
					start, end, orderByComparator
				};
		}

		List<AddTeamMember> list = null;

		if (retrieveFromCache) {
			list = (List<AddTeamMember>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AddTeamMember addTeamMember : list) {
					if ((employeeId != addTeamMember.getEmployeeId()) ||
							(isProjectManager != addTeamMember.isIsProjectManager())) {
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

			query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_ISPROJECTMANAGER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(isProjectManager);

				if (!pagination) {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findBygetProjectManagerProjectList_First(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchBygetProjectManagerProjectList_First(employeeId,
				isProjectManager, orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", isProjectManager=");
		msg.append(isProjectManager);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the first add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectManagerProjectList_First(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		List<AddTeamMember> list = findBygetProjectManagerProjectList(employeeId,
				isProjectManager, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findBygetProjectManagerProjectList_Last(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchBygetProjectManagerProjectList_Last(employeeId,
				isProjectManager, orderByComparator);

		if (addTeamMember != null) {
			return addTeamMember;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", isProjectManager=");
		msg.append(isProjectManager);

		msg.append("}");

		throw new NoSuchAddTeamMemberException(msg.toString());
	}

	/**
	 * Returns the last add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectManagerProjectList_Last(
		long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator) {
		int count = countBygetProjectManagerProjectList(employeeId,
				isProjectManager);

		if (count == 0) {
			return null;
		}

		List<AddTeamMember> list = findBygetProjectManagerProjectList(employeeId,
				isProjectManager, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the add team members before and after the current add team member in the ordered set where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param projectTeamsId the primary key of the current add team member
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next add team member
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember[] findBygetProjectManagerProjectList_PrevAndNext(
		long projectTeamsId, long employeeId, boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = findByPrimaryKey(projectTeamsId);

		Session session = null;

		try {
			session = openSession();

			AddTeamMember[] array = new AddTeamMemberImpl[3];

			array[0] = getBygetProjectManagerProjectList_PrevAndNext(session,
					addTeamMember, employeeId, isProjectManager,
					orderByComparator, true);

			array[1] = addTeamMember;

			array[2] = getBygetProjectManagerProjectList_PrevAndNext(session,
					addTeamMember, employeeId, isProjectManager,
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

	protected AddTeamMember getBygetProjectManagerProjectList_PrevAndNext(
		Session session, AddTeamMember addTeamMember, long employeeId,
		boolean isProjectManager,
		OrderByComparator<AddTeamMember> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

		query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_ISPROJECTMANAGER_2);

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
			query.append(AddTeamMemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(isProjectManager);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(addTeamMember);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AddTeamMember> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the add team members where employeeId = &#63; and isProjectManager = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 */
	@Override
	public void removeBygetProjectManagerProjectList(long employeeId,
		boolean isProjectManager) {
		for (AddTeamMember addTeamMember : findBygetProjectManagerProjectList(
				employeeId, isProjectManager, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(addTeamMember);
		}
	}

	/**
	 * Returns the number of add team members where employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @return the number of matching add team members
	 */
	@Override
	public int countBygetProjectManagerProjectList(long employeeId,
		boolean isProjectManager) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECTLIST;

		Object[] finderArgs = new Object[] { employeeId, isProjectManager };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_ISPROJECTMANAGER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(isProjectManager);

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

	private static final String _FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_EMPLOYEEID_2 =
		"addTeamMember.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_GETPROJECTMANAGERPROJECTLIST_ISPROJECTMANAGER_2 =
		"addTeamMember.isProjectManager = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED,
			AddTeamMemberImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBygetProjectManagerProject",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			AddTeamMemberModelImpl.PROJECTID_COLUMN_BITMASK |
			AddTeamMemberModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AddTeamMemberModelImpl.ISPROJECTMANAGER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECT =
		new FinderPath(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetProjectManagerProject",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @return the matching add team member
	 * @throws NoSuchAddTeamMemberException if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember findBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchBygetProjectManagerProject(projectId,
				employeeId, isProjectManager);

		if (addTeamMember == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("projectId=");
			msg.append(projectId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", isProjectManager=");
			msg.append(isProjectManager);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAddTeamMemberException(msg.toString());
		}

		return addTeamMember;
	}

	/**
	 * Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager) {
		return fetchBygetProjectManagerProject(projectId, employeeId,
			isProjectManager, true);
	}

	/**
	 * Returns the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching add team member, or <code>null</code> if a matching add team member could not be found
	 */
	@Override
	public AddTeamMember fetchBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				projectId, employeeId, isProjectManager
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
					finderArgs, this);
		}

		if (result instanceof AddTeamMember) {
			AddTeamMember addTeamMember = (AddTeamMember)result;

			if ((projectId != addTeamMember.getProjectId()) ||
					(employeeId != addTeamMember.getEmployeeId()) ||
					(isProjectManager != addTeamMember.isIsProjectManager())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECT_PROJECTID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECT_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECT_ISPROJECTMANAGER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(employeeId);

				qPos.add(isProjectManager);

				List<AddTeamMember> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AddTeamMemberPersistenceImpl.fetchBygetProjectManagerProject(long, long, boolean, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AddTeamMember addTeamMember = list.get(0);

					result = addTeamMember;

					cacheResult(addTeamMember);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
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
			return (AddTeamMember)result;
		}
	}

	/**
	 * Removes the add team member where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @return the add team member that was removed
	 */
	@Override
	public AddTeamMember removeBygetProjectManagerProject(long projectId,
		long employeeId, boolean isProjectManager)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = findBygetProjectManagerProject(projectId,
				employeeId, isProjectManager);

		return remove(addTeamMember);
	}

	/**
	 * Returns the number of add team members where projectId = &#63; and employeeId = &#63; and isProjectManager = &#63;.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param isProjectManager the is project manager
	 * @return the number of matching add team members
	 */
	@Override
	public int countBygetProjectManagerProject(long projectId, long employeeId,
		boolean isProjectManager) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECT;

		Object[] finderArgs = new Object[] {
				projectId, employeeId, isProjectManager
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ADDTEAMMEMBER_WHERE);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECT_PROJECTID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECT_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_GETPROJECTMANAGERPROJECT_ISPROJECTMANAGER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(employeeId);

				qPos.add(isProjectManager);

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

	private static final String _FINDER_COLUMN_GETPROJECTMANAGERPROJECT_PROJECTID_2 =
		"addTeamMember.projectId = ? AND ";
	private static final String _FINDER_COLUMN_GETPROJECTMANAGERPROJECT_EMPLOYEEID_2 =
		"addTeamMember.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_GETPROJECTMANAGERPROJECT_ISPROJECTMANAGER_2 =
		"addTeamMember.isProjectManager = ?";

	public AddTeamMemberPersistenceImpl() {
		setModelClass(AddTeamMember.class);
	}

	/**
	 * Caches the add team member in the entity cache if it is enabled.
	 *
	 * @param addTeamMember the add team member
	 */
	@Override
	public void cacheResult(AddTeamMember addTeamMember) {
		entityCache.putResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberImpl.class, addTeamMember.getPrimaryKey(),
			addTeamMember);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER,
			new Object[] {
				addTeamMember.getEmployeeId(), addTeamMember.getProjectId()
			}, addTeamMember);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
			new Object[] {
				addTeamMember.getProjectId(), addTeamMember.getEmployeeId(),
				addTeamMember.isIsProjectManager()
			}, addTeamMember);

		addTeamMember.resetOriginalValues();
	}

	/**
	 * Caches the add team members in the entity cache if it is enabled.
	 *
	 * @param addTeamMembers the add team members
	 */
	@Override
	public void cacheResult(List<AddTeamMember> addTeamMembers) {
		for (AddTeamMember addTeamMember : addTeamMembers) {
			if (entityCache.getResult(
						AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
						AddTeamMemberImpl.class, addTeamMember.getPrimaryKey()) == null) {
				cacheResult(addTeamMember);
			}
			else {
				addTeamMember.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all add team members.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AddTeamMemberImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the add team member.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AddTeamMember addTeamMember) {
		entityCache.removeResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberImpl.class, addTeamMember.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AddTeamMemberModelImpl)addTeamMember, true);
	}

	@Override
	public void clearCache(List<AddTeamMember> addTeamMembers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AddTeamMember addTeamMember : addTeamMembers) {
			entityCache.removeResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
				AddTeamMemberImpl.class, addTeamMember.getPrimaryKey());

			clearUniqueFindersCache((AddTeamMemberModelImpl)addTeamMember, true);
		}
	}

	protected void cacheUniqueFindersCache(
		AddTeamMemberModelImpl addTeamMemberModelImpl) {
		Object[] args = new Object[] {
				addTeamMemberModelImpl.getEmployeeId(),
				addTeamMemberModelImpl.getProjectId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGER, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER, args,
			addTeamMemberModelImpl, false);

		args = new Object[] {
				addTeamMemberModelImpl.getProjectId(),
				addTeamMemberModelImpl.getEmployeeId(),
				addTeamMemberModelImpl.isIsProjectManager()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECT,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
			args, addTeamMemberModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AddTeamMemberModelImpl addTeamMemberModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					addTeamMemberModelImpl.getEmployeeId(),
					addTeamMemberModelImpl.getProjectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGER,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER,
				args);
		}

		if ((addTeamMemberModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GETPROJECTMANAGER.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					addTeamMemberModelImpl.getOriginalEmployeeId(),
					addTeamMemberModelImpl.getOriginalProjectId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGER,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGER,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					addTeamMemberModelImpl.getProjectId(),
					addTeamMemberModelImpl.getEmployeeId(),
					addTeamMemberModelImpl.isIsProjectManager()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECT,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
				args);
		}

		if ((addTeamMemberModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					addTeamMemberModelImpl.getOriginalProjectId(),
					addTeamMemberModelImpl.getOriginalEmployeeId(),
					addTeamMemberModelImpl.getOriginalIsProjectManager()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECT,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETPROJECTMANAGERPROJECT,
				args);
		}
	}

	/**
	 * Creates a new add team member with the primary key. Does not add the add team member to the database.
	 *
	 * @param projectTeamsId the primary key for the new add team member
	 * @return the new add team member
	 */
	@Override
	public AddTeamMember create(long projectTeamsId) {
		AddTeamMember addTeamMember = new AddTeamMemberImpl();

		addTeamMember.setNew(true);
		addTeamMember.setPrimaryKey(projectTeamsId);

		addTeamMember.setCompanyId(companyProvider.getCompanyId());

		return addTeamMember;
	}

	/**
	 * Removes the add team member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTeamsId the primary key of the add team member
	 * @return the add team member that was removed
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember remove(long projectTeamsId)
		throws NoSuchAddTeamMemberException {
		return remove((Serializable)projectTeamsId);
	}

	/**
	 * Removes the add team member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the add team member
	 * @return the add team member that was removed
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember remove(Serializable primaryKey)
		throws NoSuchAddTeamMemberException {
		Session session = null;

		try {
			session = openSession();

			AddTeamMember addTeamMember = (AddTeamMember)session.get(AddTeamMemberImpl.class,
					primaryKey);

			if (addTeamMember == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddTeamMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(addTeamMember);
		}
		catch (NoSuchAddTeamMemberException nsee) {
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
	protected AddTeamMember removeImpl(AddTeamMember addTeamMember) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addTeamMember)) {
				addTeamMember = (AddTeamMember)session.get(AddTeamMemberImpl.class,
						addTeamMember.getPrimaryKeyObj());
			}

			if (addTeamMember != null) {
				session.delete(addTeamMember);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (addTeamMember != null) {
			clearCache(addTeamMember);
		}

		return addTeamMember;
	}

	@Override
	public AddTeamMember updateImpl(AddTeamMember addTeamMember) {
		boolean isNew = addTeamMember.isNew();

		if (!(addTeamMember instanceof AddTeamMemberModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(addTeamMember.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(addTeamMember);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in addTeamMember proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AddTeamMember implementation " +
				addTeamMember.getClass());
		}

		AddTeamMemberModelImpl addTeamMemberModelImpl = (AddTeamMemberModelImpl)addTeamMember;

		Session session = null;

		try {
			session = openSession();

			if (addTeamMember.isNew()) {
				session.save(addTeamMember);

				addTeamMember.setNew(false);
			}
			else {
				addTeamMember = (AddTeamMember)session.merge(addTeamMember);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AddTeamMemberModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					addTeamMemberModelImpl.getEmployeeId(),
					addTeamMemberModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTID,
				args);

			args = new Object[] { addTeamMemberModelImpl.isIsProjectManager() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMANAGER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMANAGER,
				args);

			args = new Object[] { addTeamMemberModelImpl.getProjectId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMEMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBER,
				args);

			args = new Object[] {
					addTeamMemberModelImpl.getEmployeeId(),
					addTeamMemberModelImpl.isIsProjectManager()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECTLIST,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((addTeamMemberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addTeamMemberModelImpl.getOriginalEmployeeId(),
						addTeamMemberModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTID,
					args);

				args = new Object[] {
						addTeamMemberModelImpl.getEmployeeId(),
						addTeamMemberModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTID,
					args);
			}

			if ((addTeamMemberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMANAGER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addTeamMemberModelImpl.getOriginalIsProjectManager()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMANAGER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMANAGER,
					args);

				args = new Object[] { addTeamMemberModelImpl.isIsProjectManager() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMANAGER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMANAGER,
					args);
			}

			if ((addTeamMemberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addTeamMemberModelImpl.getOriginalProjectId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMEMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBER,
					args);

				args = new Object[] { addTeamMemberModelImpl.getProjectId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTMEMBER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTMEMBER,
					args);
			}

			if ((addTeamMemberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						addTeamMemberModelImpl.getOriginalEmployeeId(),
						addTeamMemberModelImpl.getOriginalIsProjectManager()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECTLIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST,
					args);

				args = new Object[] {
						addTeamMemberModelImpl.getEmployeeId(),
						addTeamMemberModelImpl.isIsProjectManager()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETPROJECTMANAGERPROJECTLIST,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETPROJECTMANAGERPROJECTLIST,
					args);
			}
		}

		entityCache.putResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
			AddTeamMemberImpl.class, addTeamMember.getPrimaryKey(),
			addTeamMember, false);

		clearUniqueFindersCache(addTeamMemberModelImpl, false);
		cacheUniqueFindersCache(addTeamMemberModelImpl);

		addTeamMember.resetOriginalValues();

		return addTeamMember;
	}

	/**
	 * Returns the add team member with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the add team member
	 * @return the add team member
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddTeamMemberException {
		AddTeamMember addTeamMember = fetchByPrimaryKey(primaryKey);

		if (addTeamMember == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddTeamMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return addTeamMember;
	}

	/**
	 * Returns the add team member with the primary key or throws a {@link NoSuchAddTeamMemberException} if it could not be found.
	 *
	 * @param projectTeamsId the primary key of the add team member
	 * @return the add team member
	 * @throws NoSuchAddTeamMemberException if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember findByPrimaryKey(long projectTeamsId)
		throws NoSuchAddTeamMemberException {
		return findByPrimaryKey((Serializable)projectTeamsId);
	}

	/**
	 * Returns the add team member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the add team member
	 * @return the add team member, or <code>null</code> if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
				AddTeamMemberImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AddTeamMember addTeamMember = (AddTeamMember)serializable;

		if (addTeamMember == null) {
			Session session = null;

			try {
				session = openSession();

				addTeamMember = (AddTeamMember)session.get(AddTeamMemberImpl.class,
						primaryKey);

				if (addTeamMember != null) {
					cacheResult(addTeamMember);
				}
				else {
					entityCache.putResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
						AddTeamMemberImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
					AddTeamMemberImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return addTeamMember;
	}

	/**
	 * Returns the add team member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTeamsId the primary key of the add team member
	 * @return the add team member, or <code>null</code> if a add team member with the primary key could not be found
	 */
	@Override
	public AddTeamMember fetchByPrimaryKey(long projectTeamsId) {
		return fetchByPrimaryKey((Serializable)projectTeamsId);
	}

	@Override
	public Map<Serializable, AddTeamMember> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AddTeamMember> map = new HashMap<Serializable, AddTeamMember>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AddTeamMember addTeamMember = fetchByPrimaryKey(primaryKey);

			if (addTeamMember != null) {
				map.put(primaryKey, addTeamMember);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
					AddTeamMemberImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AddTeamMember)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ADDTEAMMEMBER_WHERE_PKS_IN);

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

			for (AddTeamMember addTeamMember : (List<AddTeamMember>)q.list()) {
				map.put(addTeamMember.getPrimaryKeyObj(), addTeamMember);

				cacheResult(addTeamMember);

				uncachedPrimaryKeys.remove(addTeamMember.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AddTeamMemberModelImpl.ENTITY_CACHE_ENABLED,
					AddTeamMemberImpl.class, primaryKey, nullModel);
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
	 * Returns all the add team members.
	 *
	 * @return the add team members
	 */
	@Override
	public List<AddTeamMember> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the add team members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @return the range of add team members
	 */
	@Override
	public List<AddTeamMember> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the add team members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of add team members
	 */
	@Override
	public List<AddTeamMember> findAll(int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the add team members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddTeamMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of add team members
	 * @param end the upper bound of the range of add team members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of add team members
	 */
	@Override
	public List<AddTeamMember> findAll(int start, int end,
		OrderByComparator<AddTeamMember> orderByComparator,
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

		List<AddTeamMember> list = null;

		if (retrieveFromCache) {
			list = (List<AddTeamMember>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ADDTEAMMEMBER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADDTEAMMEMBER;

				if (pagination) {
					sql = sql.concat(AddTeamMemberModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AddTeamMember>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the add team members from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AddTeamMember addTeamMember : findAll()) {
			remove(addTeamMember);
		}
	}

	/**
	 * Returns the number of add team members.
	 *
	 * @return the number of add team members
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADDTEAMMEMBER);

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
		return AddTeamMemberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the add team member persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AddTeamMemberImpl.class.getName());
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
	private static final String _SQL_SELECT_ADDTEAMMEMBER = "SELECT addTeamMember FROM AddTeamMember addTeamMember";
	private static final String _SQL_SELECT_ADDTEAMMEMBER_WHERE_PKS_IN = "SELECT addTeamMember FROM AddTeamMember addTeamMember WHERE projectTeamsId IN (";
	private static final String _SQL_SELECT_ADDTEAMMEMBER_WHERE = "SELECT addTeamMember FROM AddTeamMember addTeamMember WHERE ";
	private static final String _SQL_COUNT_ADDTEAMMEMBER = "SELECT COUNT(addTeamMember) FROM AddTeamMember addTeamMember";
	private static final String _SQL_COUNT_ADDTEAMMEMBER_WHERE = "SELECT COUNT(addTeamMember) FROM AddTeamMember addTeamMember WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "addTeamMember.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AddTeamMember exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AddTeamMember exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AddTeamMemberPersistenceImpl.class);
}