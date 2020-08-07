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

import com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureException;
import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure;
import com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureImpl;
import com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.SelectedCandidatePayStructurePersistence;

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
 * The persistence implementation for the selected candidate pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructurePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.SelectedCandidatePayStructureUtil
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructurePersistenceImpl
	extends BasePersistenceImpl<SelectedCandidatePayStructure>
	implements SelectedCandidatePayStructurePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SelectedCandidatePayStructureUtil} to access the selected candidate pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SelectedCandidatePayStructureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS =
		new FinderPath(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrecruitmentProcessIdAndPayStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS =
		new FinderPath(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrecruitmentProcessIdAndPayStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SelectedCandidatePayStructureModelImpl.RECRUITMENTPROCESSID_COLUMN_BITMASK |
			SelectedCandidatePayStructureModelImpl.PAYSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYSTATUS =
		new FinderPath(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrecruitmentProcessIdAndPayStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @return the matching selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		return findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param start the lower bound of the range of selected candidate pay structures
	 * @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	 * @return the range of matching selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end) {
		return findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param start the lower bound of the range of selected candidate pay structures
	 * @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
			payStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param start the lower bound of the range of selected candidate pay structures
	 * @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS;
			finderArgs = new Object[] { recruitmentProcessId, payStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS;
			finderArgs = new Object[] {
					recruitmentProcessId, payStatus,
					
					start, end, orderByComparator
				};
		}

		List<SelectedCandidatePayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<SelectedCandidatePayStructure>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SelectedCandidatePayStructure selectedCandidatePayStructure : list) {
					if ((recruitmentProcessId != selectedCandidatePayStructure.getRecruitmentProcessId()) ||
							(payStatus != selectedCandidatePayStructure.getPayStatus())) {
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

			query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_RECRUITMENTPROCESSID_2);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_PAYSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SelectedCandidatePayStructureModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recruitmentProcessId);

				qPos.add(payStatus);

				if (!pagination) {
					list = (List<SelectedCandidatePayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SelectedCandidatePayStructure>)QueryUtil.list(q,
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
	 * Returns the first selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching selected candidate pay structure
	 * @throws NoSuchSelectedCandidatePayStructureException if a matching selected candidate pay structure could not be found
	 */
	@Override
	public SelectedCandidatePayStructure findByrecruitmentProcessIdAndPayStatus_First(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureException {
		SelectedCandidatePayStructure selectedCandidatePayStructure = fetchByrecruitmentProcessIdAndPayStatus_First(recruitmentProcessId,
				payStatus, orderByComparator);

		if (selectedCandidatePayStructure != null) {
			return selectedCandidatePayStructure;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitmentProcessId=");
		msg.append(recruitmentProcessId);

		msg.append(", payStatus=");
		msg.append(payStatus);

		msg.append("}");

		throw new NoSuchSelectedCandidatePayStructureException(msg.toString());
	}

	/**
	 * Returns the first selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching selected candidate pay structure, or <code>null</code> if a matching selected candidate pay structure could not be found
	 */
	@Override
	public SelectedCandidatePayStructure fetchByrecruitmentProcessIdAndPayStatus_First(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		List<SelectedCandidatePayStructure> list = findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
				payStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching selected candidate pay structure
	 * @throws NoSuchSelectedCandidatePayStructureException if a matching selected candidate pay structure could not be found
	 */
	@Override
	public SelectedCandidatePayStructure findByrecruitmentProcessIdAndPayStatus_Last(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureException {
		SelectedCandidatePayStructure selectedCandidatePayStructure = fetchByrecruitmentProcessIdAndPayStatus_Last(recruitmentProcessId,
				payStatus, orderByComparator);

		if (selectedCandidatePayStructure != null) {
			return selectedCandidatePayStructure;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitmentProcessId=");
		msg.append(recruitmentProcessId);

		msg.append(", payStatus=");
		msg.append(payStatus);

		msg.append("}");

		throw new NoSuchSelectedCandidatePayStructureException(msg.toString());
	}

	/**
	 * Returns the last selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching selected candidate pay structure, or <code>null</code> if a matching selected candidate pay structure could not be found
	 */
	@Override
	public SelectedCandidatePayStructure fetchByrecruitmentProcessIdAndPayStatus_Last(
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		int count = countByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
				payStatus);

		if (count == 0) {
			return null;
		}

		List<SelectedCandidatePayStructure> list = findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId,
				payStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the selected candidate pay structures before and after the current selected candidate pay structure in the ordered set where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param candidatePayStructureId the primary key of the current selected candidate pay structure
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next selected candidate pay structure
	 * @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure[] findByrecruitmentProcessIdAndPayStatus_PrevAndNext(
		long candidatePayStructureId, long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureException {
		SelectedCandidatePayStructure selectedCandidatePayStructure = findByPrimaryKey(candidatePayStructureId);

		Session session = null;

		try {
			session = openSession();

			SelectedCandidatePayStructure[] array = new SelectedCandidatePayStructureImpl[3];

			array[0] = getByrecruitmentProcessIdAndPayStatus_PrevAndNext(session,
					selectedCandidatePayStructure, recruitmentProcessId,
					payStatus, orderByComparator, true);

			array[1] = selectedCandidatePayStructure;

			array[2] = getByrecruitmentProcessIdAndPayStatus_PrevAndNext(session,
					selectedCandidatePayStructure, recruitmentProcessId,
					payStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SelectedCandidatePayStructure getByrecruitmentProcessIdAndPayStatus_PrevAndNext(
		Session session,
		SelectedCandidatePayStructure selectedCandidatePayStructure,
		long recruitmentProcessId, int payStatus,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
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

		query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE);

		query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_RECRUITMENTPROCESSID_2);

		query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_PAYSTATUS_2);

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
			query.append(SelectedCandidatePayStructureModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recruitmentProcessId);

		qPos.add(payStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(selectedCandidatePayStructure);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SelectedCandidatePayStructure> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63; from the database.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 */
	@Override
	public void removeByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		for (SelectedCandidatePayStructure selectedCandidatePayStructure : findByrecruitmentProcessIdAndPayStatus(
				recruitmentProcessId, payStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(selectedCandidatePayStructure);
		}
	}

	/**
	 * Returns the number of selected candidate pay structures where recruitmentProcessId = &#63; and payStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payStatus the pay status
	 * @return the number of matching selected candidate pay structures
	 */
	@Override
	public int countByrecruitmentProcessIdAndPayStatus(
		long recruitmentProcessId, int payStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYSTATUS;

		Object[] finderArgs = new Object[] { recruitmentProcessId, payStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_RECRUITMENTPROCESSID_2);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_PAYSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recruitmentProcessId);

				qPos.add(payStatus);

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

	private static final String _FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_RECRUITMENTPROCESSID_2 =
		"selectedCandidatePayStructure.recruitmentProcessId = ? AND ";
	private static final String _FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYSTATUS_PAYSTATUS_2 =
		"selectedCandidatePayStructure.payStatus = ?";

	public SelectedCandidatePayStructurePersistenceImpl() {
		setModelClass(SelectedCandidatePayStructure.class);
	}

	/**
	 * Caches the selected candidate pay structure in the entity cache if it is enabled.
	 *
	 * @param selectedCandidatePayStructure the selected candidate pay structure
	 */
	@Override
	public void cacheResult(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		entityCache.putResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			selectedCandidatePayStructure.getPrimaryKey(),
			selectedCandidatePayStructure);

		selectedCandidatePayStructure.resetOriginalValues();
	}

	/**
	 * Caches the selected candidate pay structures in the entity cache if it is enabled.
	 *
	 * @param selectedCandidatePayStructures the selected candidate pay structures
	 */
	@Override
	public void cacheResult(
		List<SelectedCandidatePayStructure> selectedCandidatePayStructures) {
		for (SelectedCandidatePayStructure selectedCandidatePayStructure : selectedCandidatePayStructures) {
			if (entityCache.getResult(
						SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
						SelectedCandidatePayStructureImpl.class,
						selectedCandidatePayStructure.getPrimaryKey()) == null) {
				cacheResult(selectedCandidatePayStructure);
			}
			else {
				selectedCandidatePayStructure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all selected candidate pay structures.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SelectedCandidatePayStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the selected candidate pay structure.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		entityCache.removeResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			selectedCandidatePayStructure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SelectedCandidatePayStructure> selectedCandidatePayStructures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SelectedCandidatePayStructure selectedCandidatePayStructure : selectedCandidatePayStructures) {
			entityCache.removeResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
				SelectedCandidatePayStructureImpl.class,
				selectedCandidatePayStructure.getPrimaryKey());
		}
	}

	/**
	 * Creates a new selected candidate pay structure with the primary key. Does not add the selected candidate pay structure to the database.
	 *
	 * @param candidatePayStructureId the primary key for the new selected candidate pay structure
	 * @return the new selected candidate pay structure
	 */
	@Override
	public SelectedCandidatePayStructure create(long candidatePayStructureId) {
		SelectedCandidatePayStructure selectedCandidatePayStructure = new SelectedCandidatePayStructureImpl();

		selectedCandidatePayStructure.setNew(true);
		selectedCandidatePayStructure.setPrimaryKey(candidatePayStructureId);

		return selectedCandidatePayStructure;
	}

	/**
	 * Removes the selected candidate pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidatePayStructureId the primary key of the selected candidate pay structure
	 * @return the selected candidate pay structure that was removed
	 * @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure remove(long candidatePayStructureId)
		throws NoSuchSelectedCandidatePayStructureException {
		return remove((Serializable)candidatePayStructureId);
	}

	/**
	 * Removes the selected candidate pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the selected candidate pay structure
	 * @return the selected candidate pay structure that was removed
	 * @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure remove(Serializable primaryKey)
		throws NoSuchSelectedCandidatePayStructureException {
		Session session = null;

		try {
			session = openSession();

			SelectedCandidatePayStructure selectedCandidatePayStructure = (SelectedCandidatePayStructure)session.get(SelectedCandidatePayStructureImpl.class,
					primaryKey);

			if (selectedCandidatePayStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSelectedCandidatePayStructureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(selectedCandidatePayStructure);
		}
		catch (NoSuchSelectedCandidatePayStructureException nsee) {
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
	protected SelectedCandidatePayStructure removeImpl(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(selectedCandidatePayStructure)) {
				selectedCandidatePayStructure = (SelectedCandidatePayStructure)session.get(SelectedCandidatePayStructureImpl.class,
						selectedCandidatePayStructure.getPrimaryKeyObj());
			}

			if (selectedCandidatePayStructure != null) {
				session.delete(selectedCandidatePayStructure);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (selectedCandidatePayStructure != null) {
			clearCache(selectedCandidatePayStructure);
		}

		return selectedCandidatePayStructure;
	}

	@Override
	public SelectedCandidatePayStructure updateImpl(
		SelectedCandidatePayStructure selectedCandidatePayStructure) {
		boolean isNew = selectedCandidatePayStructure.isNew();

		if (!(selectedCandidatePayStructure instanceof SelectedCandidatePayStructureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(selectedCandidatePayStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(selectedCandidatePayStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in selectedCandidatePayStructure proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SelectedCandidatePayStructure implementation " +
				selectedCandidatePayStructure.getClass());
		}

		SelectedCandidatePayStructureModelImpl selectedCandidatePayStructureModelImpl =
			(SelectedCandidatePayStructureModelImpl)selectedCandidatePayStructure;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (selectedCandidatePayStructure.getCreateDate() == null)) {
			if (serviceContext == null) {
				selectedCandidatePayStructure.setCreateDate(now);
			}
			else {
				selectedCandidatePayStructure.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!selectedCandidatePayStructureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				selectedCandidatePayStructure.setModifiedDate(now);
			}
			else {
				selectedCandidatePayStructure.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (selectedCandidatePayStructure.isNew()) {
				session.save(selectedCandidatePayStructure);

				selectedCandidatePayStructure.setNew(false);
			}
			else {
				selectedCandidatePayStructure = (SelectedCandidatePayStructure)session.merge(selectedCandidatePayStructure);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SelectedCandidatePayStructureModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					selectedCandidatePayStructureModelImpl.getRecruitmentProcessId(),
					selectedCandidatePayStructureModelImpl.getPayStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYSTATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((selectedCandidatePayStructureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						selectedCandidatePayStructureModelImpl.getOriginalRecruitmentProcessId(),
						selectedCandidatePayStructureModelImpl.getOriginalPayStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS,
					args);

				args = new Object[] {
						selectedCandidatePayStructureModelImpl.getRecruitmentProcessId(),
						selectedCandidatePayStructureModelImpl.getPayStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYSTATUS,
					args);
			}
		}

		entityCache.putResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureImpl.class,
			selectedCandidatePayStructure.getPrimaryKey(),
			selectedCandidatePayStructure, false);

		selectedCandidatePayStructure.resetOriginalValues();

		return selectedCandidatePayStructure;
	}

	/**
	 * Returns the selected candidate pay structure with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the selected candidate pay structure
	 * @return the selected candidate pay structure
	 * @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchSelectedCandidatePayStructureException {
		SelectedCandidatePayStructure selectedCandidatePayStructure = fetchByPrimaryKey(primaryKey);

		if (selectedCandidatePayStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSelectedCandidatePayStructureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return selectedCandidatePayStructure;
	}

	/**
	 * Returns the selected candidate pay structure with the primary key or throws a {@link NoSuchSelectedCandidatePayStructureException} if it could not be found.
	 *
	 * @param candidatePayStructureId the primary key of the selected candidate pay structure
	 * @return the selected candidate pay structure
	 * @throws NoSuchSelectedCandidatePayStructureException if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure findByPrimaryKey(
		long candidatePayStructureId)
		throws NoSuchSelectedCandidatePayStructureException {
		return findByPrimaryKey((Serializable)candidatePayStructureId);
	}

	/**
	 * Returns the selected candidate pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the selected candidate pay structure
	 * @return the selected candidate pay structure, or <code>null</code> if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
				SelectedCandidatePayStructureImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SelectedCandidatePayStructure selectedCandidatePayStructure = (SelectedCandidatePayStructure)serializable;

		if (selectedCandidatePayStructure == null) {
			Session session = null;

			try {
				session = openSession();

				selectedCandidatePayStructure = (SelectedCandidatePayStructure)session.get(SelectedCandidatePayStructureImpl.class,
						primaryKey);

				if (selectedCandidatePayStructure != null) {
					cacheResult(selectedCandidatePayStructure);
				}
				else {
					entityCache.putResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
						SelectedCandidatePayStructureImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
					SelectedCandidatePayStructureImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return selectedCandidatePayStructure;
	}

	/**
	 * Returns the selected candidate pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidatePayStructureId the primary key of the selected candidate pay structure
	 * @return the selected candidate pay structure, or <code>null</code> if a selected candidate pay structure with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructure fetchByPrimaryKey(
		long candidatePayStructureId) {
		return fetchByPrimaryKey((Serializable)candidatePayStructureId);
	}

	@Override
	public Map<Serializable, SelectedCandidatePayStructure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SelectedCandidatePayStructure> map = new HashMap<Serializable, SelectedCandidatePayStructure>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SelectedCandidatePayStructure selectedCandidatePayStructure = fetchByPrimaryKey(primaryKey);

			if (selectedCandidatePayStructure != null) {
				map.put(primaryKey, selectedCandidatePayStructure);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
					SelectedCandidatePayStructureImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(SelectedCandidatePayStructure)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE_PKS_IN);

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

			for (SelectedCandidatePayStructure selectedCandidatePayStructure : (List<SelectedCandidatePayStructure>)q.list()) {
				map.put(selectedCandidatePayStructure.getPrimaryKeyObj(),
					selectedCandidatePayStructure);

				cacheResult(selectedCandidatePayStructure);

				uncachedPrimaryKeys.remove(selectedCandidatePayStructure.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SelectedCandidatePayStructureModelImpl.ENTITY_CACHE_ENABLED,
					SelectedCandidatePayStructureImpl.class, primaryKey,
					nullModel);
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
	 * Returns all the selected candidate pay structures.
	 *
	 * @return the selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the selected candidate pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of selected candidate pay structures
	 * @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	 * @return the range of selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of selected candidate pay structures
	 * @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findAll(int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of selected candidate pay structures
	 * @param end the upper bound of the range of selected candidate pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of selected candidate pay structures
	 */
	@Override
	public List<SelectedCandidatePayStructure> findAll(int start, int end,
		OrderByComparator<SelectedCandidatePayStructure> orderByComparator,
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

		List<SelectedCandidatePayStructure> list = null;

		if (retrieveFromCache) {
			list = (List<SelectedCandidatePayStructure>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE;

				if (pagination) {
					sql = sql.concat(SelectedCandidatePayStructureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SelectedCandidatePayStructure>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SelectedCandidatePayStructure>)QueryUtil.list(q,
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
	 * Removes all the selected candidate pay structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SelectedCandidatePayStructure selectedCandidatePayStructure : findAll()) {
			remove(selectedCandidatePayStructure);
		}
	}

	/**
	 * Returns the number of selected candidate pay structures.
	 *
	 * @return the number of selected candidate pay structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTURE);

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
		return SelectedCandidatePayStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the selected candidate pay structure persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SelectedCandidatePayStructureImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE = "SELECT selectedCandidatePayStructure FROM SelectedCandidatePayStructure selectedCandidatePayStructure";
	private static final String _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE_PKS_IN =
		"SELECT selectedCandidatePayStructure FROM SelectedCandidatePayStructure selectedCandidatePayStructure WHERE candidatePayStructureId IN (";
	private static final String _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE = "SELECT selectedCandidatePayStructure FROM SelectedCandidatePayStructure selectedCandidatePayStructure WHERE ";
	private static final String _SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTURE = "SELECT COUNT(selectedCandidatePayStructure) FROM SelectedCandidatePayStructure selectedCandidatePayStructure";
	private static final String _SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTURE_WHERE = "SELECT COUNT(selectedCandidatePayStructure) FROM SelectedCandidatePayStructure selectedCandidatePayStructure WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "selectedCandidatePayStructure.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SelectedCandidatePayStructure exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SelectedCandidatePayStructure exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SelectedCandidatePayStructurePersistenceImpl.class);
}