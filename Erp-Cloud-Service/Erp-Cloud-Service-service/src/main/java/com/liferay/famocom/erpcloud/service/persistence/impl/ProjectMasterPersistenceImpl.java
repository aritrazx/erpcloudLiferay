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

import com.liferay.famocom.erpcloud.exception.NoSuchProjectMasterException;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.model.impl.ProjectMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.ProjectMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ProjectMasterPersistence;

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
 * The persistence implementation for the project master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ProjectMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ProjectMasterUtil
 * @generated
 */
@ProviderType
public class ProjectMasterPersistenceImpl extends BasePersistenceImpl<ProjectMaster>
	implements ProjectMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectMasterUtil} to access the project master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			ProjectMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			ProjectMasterImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			ProjectMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByprojectId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			ProjectMasterImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByprojectId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProjectMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			ProjectMasterModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprojectId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the project masters where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @return the matching project masters
	 */
	@Override
	public List<ProjectMaster> findByprojectId(long employeeId, long companyId) {
		return findByprojectId(employeeId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project masters where employeeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @return the range of matching project masters
	 */
	@Override
	public List<ProjectMaster> findByprojectId(long employeeId, long companyId,
		int start, int end) {
		return findByprojectId(employeeId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project masters where employeeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project masters
	 */
	@Override
	public List<ProjectMaster> findByprojectId(long employeeId, long companyId,
		int start, int end, OrderByComparator<ProjectMaster> orderByComparator) {
		return findByprojectId(employeeId, companyId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project masters where employeeId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project masters
	 */
	@Override
	public List<ProjectMaster> findByprojectId(long employeeId, long companyId,
		int start, int end, OrderByComparator<ProjectMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { employeeId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] {
					employeeId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectMaster projectMaster : list) {
					if ((employeeId != projectMaster.getEmployeeId()) ||
							(companyId != projectMaster.getCompanyId())) {
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

			query.append(_SQL_SELECT_PROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_PROJECTID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectMasterModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectMaster>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project master
	 * @throws NoSuchProjectMasterException if a matching project master could not be found
	 */
	@Override
	public ProjectMaster findByprojectId_First(long employeeId, long companyId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = fetchByprojectId_First(employeeId,
				companyId, orderByComparator);

		if (projectMaster != null) {
			return projectMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchProjectMasterException(msg.toString());
	}

	/**
	 * Returns the first project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project master, or <code>null</code> if a matching project master could not be found
	 */
	@Override
	public ProjectMaster fetchByprojectId_First(long employeeId,
		long companyId, OrderByComparator<ProjectMaster> orderByComparator) {
		List<ProjectMaster> list = findByprojectId(employeeId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project master
	 * @throws NoSuchProjectMasterException if a matching project master could not be found
	 */
	@Override
	public ProjectMaster findByprojectId_Last(long employeeId, long companyId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = fetchByprojectId_Last(employeeId,
				companyId, orderByComparator);

		if (projectMaster != null) {
			return projectMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchProjectMasterException(msg.toString());
	}

	/**
	 * Returns the last project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project master, or <code>null</code> if a matching project master could not be found
	 */
	@Override
	public ProjectMaster fetchByprojectId_Last(long employeeId, long companyId,
		OrderByComparator<ProjectMaster> orderByComparator) {
		int count = countByprojectId(employeeId, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectMaster> list = findByprojectId(employeeId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project masters before and after the current project master in the ordered set where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current project master
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project master
	 * @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster[] findByprojectId_PrevAndNext(long projectId,
		long employeeId, long companyId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			ProjectMaster[] array = new ProjectMasterImpl[3];

			array[0] = getByprojectId_PrevAndNext(session, projectMaster,
					employeeId, companyId, orderByComparator, true);

			array[1] = projectMaster;

			array[2] = getByprojectId_PrevAndNext(session, projectMaster,
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

	protected ProjectMaster getByprojectId_PrevAndNext(Session session,
		ProjectMaster projectMaster, long employeeId, long companyId,
		OrderByComparator<ProjectMaster> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECTMASTER_WHERE);

		query.append(_FINDER_COLUMN_PROJECTID_EMPLOYEEID_2);

		query.append(_FINDER_COLUMN_PROJECTID_COMPANYID_2);

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
			query.append(ProjectMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project masters where employeeId = &#63; and companyId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByprojectId(long employeeId, long companyId) {
		for (ProjectMaster projectMaster : findByprojectId(employeeId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectMaster);
		}
	}

	/**
	 * Returns the number of project masters where employeeId = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param companyId the company ID
	 * @return the number of matching project masters
	 */
	@Override
	public int countByprojectId(long employeeId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTID;

		Object[] finderArgs = new Object[] { employeeId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_PROJECTID_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_PROJECTID_EMPLOYEEID_2 = "projectMaster.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECTID_COMPANYID_2 = "projectMaster.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			ProjectMasterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED,
			ProjectMasterImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmployeeId", new String[] { Long.class.getName() },
			ProjectMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project masters where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching project masters
	 */
	@Override
	public List<ProjectMaster> findByEmployeeId(long employeeId) {
		return findByEmployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project masters where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @return the range of matching project masters
	 */
	@Override
	public List<ProjectMaster> findByEmployeeId(long employeeId, int start,
		int end) {
		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project masters where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project masters
	 */
	@Override
	public List<ProjectMaster> findByEmployeeId(long employeeId, int start,
		int end, OrderByComparator<ProjectMaster> orderByComparator) {
		return findByEmployeeId(employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project masters where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project masters
	 */
	@Override
	public List<ProjectMaster> findByEmployeeId(long employeeId, int start,
		int end, OrderByComparator<ProjectMaster> orderByComparator,
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

		List<ProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectMaster projectMaster : list) {
					if ((employeeId != projectMaster.getEmployeeId())) {
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

			query.append(_SQL_SELECT_PROJECTMASTER_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<ProjectMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectMaster>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project master in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project master
	 * @throws NoSuchProjectMasterException if a matching project master could not be found
	 */
	@Override
	public ProjectMaster findByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = fetchByEmployeeId_First(employeeId,
				orderByComparator);

		if (projectMaster != null) {
			return projectMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchProjectMasterException(msg.toString());
	}

	/**
	 * Returns the first project master in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project master, or <code>null</code> if a matching project master could not be found
	 */
	@Override
	public ProjectMaster fetchByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator) {
		List<ProjectMaster> list = findByEmployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project master in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project master
	 * @throws NoSuchProjectMasterException if a matching project master could not be found
	 */
	@Override
	public ProjectMaster findByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = fetchByEmployeeId_Last(employeeId,
				orderByComparator);

		if (projectMaster != null) {
			return projectMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append("}");

		throw new NoSuchProjectMasterException(msg.toString());
	}

	/**
	 * Returns the last project master in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project master, or <code>null</code> if a matching project master could not be found
	 */
	@Override
	public ProjectMaster fetchByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator) {
		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ProjectMaster> list = findByEmployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project masters before and after the current project master in the ordered set where employeeId = &#63;.
	 *
	 * @param projectId the primary key of the current project master
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project master
	 * @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster[] findByEmployeeId_PrevAndNext(long projectId,
		long employeeId, OrderByComparator<ProjectMaster> orderByComparator)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			ProjectMaster[] array = new ProjectMasterImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(session, projectMaster,
					employeeId, orderByComparator, true);

			array[1] = projectMaster;

			array[2] = getByEmployeeId_PrevAndNext(session, projectMaster,
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

	protected ProjectMaster getByEmployeeId_PrevAndNext(Session session,
		ProjectMaster projectMaster, long employeeId,
		OrderByComparator<ProjectMaster> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTMASTER_WHERE);

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
			query.append(ProjectMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project masters where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (ProjectMaster projectMaster : findByEmployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectMaster);
		}
	}

	/**
	 * Returns the number of project masters where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching project masters
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTMASTER_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "projectMaster.employeeId = ?";

	public ProjectMasterPersistenceImpl() {
		setModelClass(ProjectMaster.class);
	}

	/**
	 * Caches the project master in the entity cache if it is enabled.
	 *
	 * @param projectMaster the project master
	 */
	@Override
	public void cacheResult(ProjectMaster projectMaster) {
		entityCache.putResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterImpl.class, projectMaster.getPrimaryKey(),
			projectMaster);

		projectMaster.resetOriginalValues();
	}

	/**
	 * Caches the project masters in the entity cache if it is enabled.
	 *
	 * @param projectMasters the project masters
	 */
	@Override
	public void cacheResult(List<ProjectMaster> projectMasters) {
		for (ProjectMaster projectMaster : projectMasters) {
			if (entityCache.getResult(
						ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
						ProjectMasterImpl.class, projectMaster.getPrimaryKey()) == null) {
				cacheResult(projectMaster);
			}
			else {
				projectMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectMaster projectMaster) {
		entityCache.removeResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterImpl.class, projectMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectMaster> projectMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectMaster projectMaster : projectMasters) {
			entityCache.removeResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
				ProjectMasterImpl.class, projectMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project master with the primary key. Does not add the project master to the database.
	 *
	 * @param projectId the primary key for the new project master
	 * @return the new project master
	 */
	@Override
	public ProjectMaster create(long projectId) {
		ProjectMaster projectMaster = new ProjectMasterImpl();

		projectMaster.setNew(true);
		projectMaster.setPrimaryKey(projectId);

		projectMaster.setCompanyId(companyProvider.getCompanyId());

		return projectMaster;
	}

	/**
	 * Removes the project master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project master
	 * @return the project master that was removed
	 * @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster remove(long projectId)
		throws NoSuchProjectMasterException {
		return remove((Serializable)projectId);
	}

	/**
	 * Removes the project master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project master
	 * @return the project master that was removed
	 * @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster remove(Serializable primaryKey)
		throws NoSuchProjectMasterException {
		Session session = null;

		try {
			session = openSession();

			ProjectMaster projectMaster = (ProjectMaster)session.get(ProjectMasterImpl.class,
					primaryKey);

			if (projectMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectMaster);
		}
		catch (NoSuchProjectMasterException nsee) {
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
	protected ProjectMaster removeImpl(ProjectMaster projectMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectMaster)) {
				projectMaster = (ProjectMaster)session.get(ProjectMasterImpl.class,
						projectMaster.getPrimaryKeyObj());
			}

			if (projectMaster != null) {
				session.delete(projectMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectMaster != null) {
			clearCache(projectMaster);
		}

		return projectMaster;
	}

	@Override
	public ProjectMaster updateImpl(ProjectMaster projectMaster) {
		boolean isNew = projectMaster.isNew();

		if (!(projectMaster instanceof ProjectMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectMaster implementation " +
				projectMaster.getClass());
		}

		ProjectMasterModelImpl projectMasterModelImpl = (ProjectMasterModelImpl)projectMaster;

		Session session = null;

		try {
			session = openSession();

			if (projectMaster.isNew()) {
				session.save(projectMaster);

				projectMaster.setNew(false);
			}
			else {
				projectMaster = (ProjectMaster)session.merge(projectMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProjectMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectMasterModelImpl.getEmployeeId(),
					projectMasterModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
				args);

			args = new Object[] { projectMasterModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectMasterModelImpl.getOriginalEmployeeId(),
						projectMasterModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] {
						projectMasterModelImpl.getEmployeeId(),
						projectMasterModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}

			if ((projectMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectMasterModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { projectMasterModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		entityCache.putResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
			ProjectMasterImpl.class, projectMaster.getPrimaryKey(),
			projectMaster, false);

		projectMaster.resetOriginalValues();

		return projectMaster;
	}

	/**
	 * Returns the project master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project master
	 * @return the project master
	 * @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectMasterException {
		ProjectMaster projectMaster = fetchByPrimaryKey(primaryKey);

		if (projectMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectMaster;
	}

	/**
	 * Returns the project master with the primary key or throws a {@link NoSuchProjectMasterException} if it could not be found.
	 *
	 * @param projectId the primary key of the project master
	 * @return the project master
	 * @throws NoSuchProjectMasterException if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster findByPrimaryKey(long projectId)
		throws NoSuchProjectMasterException {
		return findByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns the project master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project master
	 * @return the project master, or <code>null</code> if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
				ProjectMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectMaster projectMaster = (ProjectMaster)serializable;

		if (projectMaster == null) {
			Session session = null;

			try {
				session = openSession();

				projectMaster = (ProjectMaster)session.get(ProjectMasterImpl.class,
						primaryKey);

				if (projectMaster != null) {
					cacheResult(projectMaster);
				}
				else {
					entityCache.putResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
						ProjectMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
					ProjectMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectMaster;
	}

	/**
	 * Returns the project master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project master
	 * @return the project master, or <code>null</code> if a project master with the primary key could not be found
	 */
	@Override
	public ProjectMaster fetchByPrimaryKey(long projectId) {
		return fetchByPrimaryKey((Serializable)projectId);
	}

	@Override
	public Map<Serializable, ProjectMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectMaster> map = new HashMap<Serializable, ProjectMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectMaster projectMaster = fetchByPrimaryKey(primaryKey);

			if (projectMaster != null) {
				map.put(primaryKey, projectMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
					ProjectMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTMASTER_WHERE_PKS_IN);

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

			for (ProjectMaster projectMaster : (List<ProjectMaster>)q.list()) {
				map.put(projectMaster.getPrimaryKeyObj(), projectMaster);

				cacheResult(projectMaster);

				uncachedPrimaryKeys.remove(projectMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectMasterModelImpl.ENTITY_CACHE_ENABLED,
					ProjectMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the project masters.
	 *
	 * @return the project masters
	 */
	@Override
	public List<ProjectMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @return the range of project masters
	 */
	@Override
	public List<ProjectMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project masters
	 */
	@Override
	public List<ProjectMaster> findAll(int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project masters
	 * @param end the upper bound of the range of project masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project masters
	 */
	@Override
	public List<ProjectMaster> findAll(int start, int end,
		OrderByComparator<ProjectMaster> orderByComparator,
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

		List<ProjectMaster> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTMASTER;

				if (pagination) {
					sql = sql.concat(ProjectMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the project masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectMaster projectMaster : findAll()) {
			remove(projectMaster);
		}
	}

	/**
	 * Returns the number of project masters.
	 *
	 * @return the number of project masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTMASTER);

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
		return ProjectMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_PROJECTMASTER = "SELECT projectMaster FROM ProjectMaster projectMaster";
	private static final String _SQL_SELECT_PROJECTMASTER_WHERE_PKS_IN = "SELECT projectMaster FROM ProjectMaster projectMaster WHERE projectId IN (";
	private static final String _SQL_SELECT_PROJECTMASTER_WHERE = "SELECT projectMaster FROM ProjectMaster projectMaster WHERE ";
	private static final String _SQL_COUNT_PROJECTMASTER = "SELECT COUNT(projectMaster) FROM ProjectMaster projectMaster";
	private static final String _SQL_COUNT_PROJECTMASTER_WHERE = "SELECT COUNT(projectMaster) FROM ProjectMaster projectMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectMasterPersistenceImpl.class);
}