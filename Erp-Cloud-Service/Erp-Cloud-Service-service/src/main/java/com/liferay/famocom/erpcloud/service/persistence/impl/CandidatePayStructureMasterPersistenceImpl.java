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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidatePayStructureMasterException;
import com.liferay.famocom.erpcloud.model.CandidatePayStructureMaster;
import com.liferay.famocom.erpcloud.model.impl.CandidatePayStructureMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.CandidatePayStructureMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.CandidatePayStructureMasterPersistence;

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
 * The persistence implementation for the candidate pay structure master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidatePayStructureMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.CandidatePayStructureMasterUtil
 * @generated
 */
@ProviderType
public class CandidatePayStructureMasterPersistenceImpl
	extends BasePersistenceImpl<CandidatePayStructureMaster>
	implements CandidatePayStructureMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidatePayStructureMasterUtil} to access the candidate pay structure master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidatePayStructureMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS =
		new FinderPath(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrecruitmentProcessIdAndPayMasterStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS =
		new FinderPath(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrecruitmentProcessIdAndPayMasterStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CandidatePayStructureMasterModelImpl.RECRUITMENTPROCESSID_COLUMN_BITMASK |
			CandidatePayStructureMasterModelImpl.PAYMASTERSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS =
		new FinderPath(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrecruitmentProcessIdAndPayMasterStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @return the matching candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param start the lower bound of the range of candidate pay structure masters
	 * @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	 * @return the range of matching candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end) {
		return findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param start the lower bound of the range of candidate pay structure masters
	 * @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param start the lower bound of the range of candidate pay structure masters
	 * @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS;
			finderArgs = new Object[] { recruitmentProcessId, payMasterStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS;
			finderArgs = new Object[] {
					recruitmentProcessId, payMasterStatus,
					
					start, end, orderByComparator
				};
		}

		List<CandidatePayStructureMaster> list = null;

		if (retrieveFromCache) {
			list = (List<CandidatePayStructureMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidatePayStructureMaster candidatePayStructureMaster : list) {
					if ((recruitmentProcessId != candidatePayStructureMaster.getRecruitmentProcessId()) ||
							(payMasterStatus != candidatePayStructureMaster.getPayMasterStatus())) {
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

			query.append(_SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER_WHERE);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_RECRUITMENTPROCESSID_2);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_PAYMASTERSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidatePayStructureMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recruitmentProcessId);

				qPos.add(payMasterStatus);

				if (!pagination) {
					list = (List<CandidatePayStructureMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidatePayStructureMaster>)QueryUtil.list(q,
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
	 * Returns the first candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate pay structure master
	 * @throws NoSuchCandidatePayStructureMasterException if a matching candidate pay structure master could not be found
	 */
	@Override
	public CandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws NoSuchCandidatePayStructureMasterException {
		CandidatePayStructureMaster candidatePayStructureMaster = fetchByrecruitmentProcessIdAndPayMasterStatus_First(recruitmentProcessId,
				payMasterStatus, orderByComparator);

		if (candidatePayStructureMaster != null) {
			return candidatePayStructureMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitmentProcessId=");
		msg.append(recruitmentProcessId);

		msg.append(", payMasterStatus=");
		msg.append(payMasterStatus);

		msg.append("}");

		throw new NoSuchCandidatePayStructureMasterException(msg.toString());
	}

	/**
	 * Returns the first candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate pay structure master, or <code>null</code> if a matching candidate pay structure master could not be found
	 */
	@Override
	public CandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		List<CandidatePayStructureMaster> list = findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
				payMasterStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate pay structure master
	 * @throws NoSuchCandidatePayStructureMasterException if a matching candidate pay structure master could not be found
	 */
	@Override
	public CandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws NoSuchCandidatePayStructureMasterException {
		CandidatePayStructureMaster candidatePayStructureMaster = fetchByrecruitmentProcessIdAndPayMasterStatus_Last(recruitmentProcessId,
				payMasterStatus, orderByComparator);

		if (candidatePayStructureMaster != null) {
			return candidatePayStructureMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitmentProcessId=");
		msg.append(recruitmentProcessId);

		msg.append(", payMasterStatus=");
		msg.append(payMasterStatus);

		msg.append("}");

		throw new NoSuchCandidatePayStructureMasterException(msg.toString());
	}

	/**
	 * Returns the last candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate pay structure master, or <code>null</code> if a matching candidate pay structure master could not be found
	 */
	@Override
	public CandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		int count = countByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
				payMasterStatus);

		if (count == 0) {
			return null;
		}

		List<CandidatePayStructureMaster> list = findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
				payMasterStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate pay structure masters before and after the current candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param candidatePayStructureMasterId the primary key of the current candidate pay structure master
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate pay structure master
	 * @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster[] findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		long candidatePayStructureMasterId, long recruitmentProcessId,
		int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator)
		throws NoSuchCandidatePayStructureMasterException {
		CandidatePayStructureMaster candidatePayStructureMaster = findByPrimaryKey(candidatePayStructureMasterId);

		Session session = null;

		try {
			session = openSession();

			CandidatePayStructureMaster[] array = new CandidatePayStructureMasterImpl[3];

			array[0] = getByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(session,
					candidatePayStructureMaster, recruitmentProcessId,
					payMasterStatus, orderByComparator, true);

			array[1] = candidatePayStructureMaster;

			array[2] = getByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(session,
					candidatePayStructureMaster, recruitmentProcessId,
					payMasterStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidatePayStructureMaster getByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		Session session,
		CandidatePayStructureMaster candidatePayStructureMaster,
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER_WHERE);

		query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_RECRUITMENTPROCESSID_2);

		query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_PAYMASTERSTATUS_2);

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
			query.append(CandidatePayStructureMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recruitmentProcessId);

		qPos.add(payMasterStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidatePayStructureMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidatePayStructureMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63; from the database.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 */
	@Override
	public void removeByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		for (CandidatePayStructureMaster candidatePayStructureMaster : findByrecruitmentProcessIdAndPayMasterStatus(
				recruitmentProcessId, payMasterStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(candidatePayStructureMaster);
		}
	}

	/**
	 * Returns the number of candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @return the number of matching candidate pay structure masters
	 */
	@Override
	public int countByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS;

		Object[] finderArgs = new Object[] { recruitmentProcessId, payMasterStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEPAYSTRUCTUREMASTER_WHERE);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_RECRUITMENTPROCESSID_2);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_PAYMASTERSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(recruitmentProcessId);

				qPos.add(payMasterStatus);

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

	private static final String _FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_RECRUITMENTPROCESSID_2 =
		"candidatePayStructureMaster.recruitmentProcessId = ? AND ";
	private static final String _FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_PAYMASTERSTATUS_2 =
		"candidatePayStructureMaster.payMasterStatus = ?";

	public CandidatePayStructureMasterPersistenceImpl() {
		setModelClass(CandidatePayStructureMaster.class);
	}

	/**
	 * Caches the candidate pay structure master in the entity cache if it is enabled.
	 *
	 * @param candidatePayStructureMaster the candidate pay structure master
	 */
	@Override
	public void cacheResult(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		entityCache.putResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			candidatePayStructureMaster.getPrimaryKey(),
			candidatePayStructureMaster);

		candidatePayStructureMaster.resetOriginalValues();
	}

	/**
	 * Caches the candidate pay structure masters in the entity cache if it is enabled.
	 *
	 * @param candidatePayStructureMasters the candidate pay structure masters
	 */
	@Override
	public void cacheResult(
		List<CandidatePayStructureMaster> candidatePayStructureMasters) {
		for (CandidatePayStructureMaster candidatePayStructureMaster : candidatePayStructureMasters) {
			if (entityCache.getResult(
						CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
						CandidatePayStructureMasterImpl.class,
						candidatePayStructureMaster.getPrimaryKey()) == null) {
				cacheResult(candidatePayStructureMaster);
			}
			else {
				candidatePayStructureMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate pay structure masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidatePayStructureMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate pay structure master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		entityCache.removeResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			candidatePayStructureMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CandidatePayStructureMaster> candidatePayStructureMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidatePayStructureMaster candidatePayStructureMaster : candidatePayStructureMasters) {
			entityCache.removeResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
				CandidatePayStructureMasterImpl.class,
				candidatePayStructureMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate pay structure master with the primary key. Does not add the candidate pay structure master to the database.
	 *
	 * @param candidatePayStructureMasterId the primary key for the new candidate pay structure master
	 * @return the new candidate pay structure master
	 */
	@Override
	public CandidatePayStructureMaster create(
		long candidatePayStructureMasterId) {
		CandidatePayStructureMaster candidatePayStructureMaster = new CandidatePayStructureMasterImpl();

		candidatePayStructureMaster.setNew(true);
		candidatePayStructureMaster.setPrimaryKey(candidatePayStructureMasterId);

		return candidatePayStructureMaster;
	}

	/**
	 * Removes the candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	 * @return the candidate pay structure master that was removed
	 * @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster remove(
		long candidatePayStructureMasterId)
		throws NoSuchCandidatePayStructureMasterException {
		return remove((Serializable)candidatePayStructureMasterId);
	}

	/**
	 * Removes the candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate pay structure master
	 * @return the candidate pay structure master that was removed
	 * @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster remove(Serializable primaryKey)
		throws NoSuchCandidatePayStructureMasterException {
		Session session = null;

		try {
			session = openSession();

			CandidatePayStructureMaster candidatePayStructureMaster = (CandidatePayStructureMaster)session.get(CandidatePayStructureMasterImpl.class,
					primaryKey);

			if (candidatePayStructureMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidatePayStructureMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidatePayStructureMaster);
		}
		catch (NoSuchCandidatePayStructureMasterException nsee) {
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
	protected CandidatePayStructureMaster removeImpl(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidatePayStructureMaster)) {
				candidatePayStructureMaster = (CandidatePayStructureMaster)session.get(CandidatePayStructureMasterImpl.class,
						candidatePayStructureMaster.getPrimaryKeyObj());
			}

			if (candidatePayStructureMaster != null) {
				session.delete(candidatePayStructureMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidatePayStructureMaster != null) {
			clearCache(candidatePayStructureMaster);
		}

		return candidatePayStructureMaster;
	}

	@Override
	public CandidatePayStructureMaster updateImpl(
		CandidatePayStructureMaster candidatePayStructureMaster) {
		boolean isNew = candidatePayStructureMaster.isNew();

		if (!(candidatePayStructureMaster instanceof CandidatePayStructureMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(candidatePayStructureMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(candidatePayStructureMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in candidatePayStructureMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CandidatePayStructureMaster implementation " +
				candidatePayStructureMaster.getClass());
		}

		CandidatePayStructureMasterModelImpl candidatePayStructureMasterModelImpl =
			(CandidatePayStructureMasterModelImpl)candidatePayStructureMaster;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (candidatePayStructureMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				candidatePayStructureMaster.setCreateDate(now);
			}
			else {
				candidatePayStructureMaster.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!candidatePayStructureMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				candidatePayStructureMaster.setModifiedDate(now);
			}
			else {
				candidatePayStructureMaster.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (candidatePayStructureMaster.isNew()) {
				session.save(candidatePayStructureMaster);

				candidatePayStructureMaster.setNew(false);
			}
			else {
				candidatePayStructureMaster = (CandidatePayStructureMaster)session.merge(candidatePayStructureMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CandidatePayStructureMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					candidatePayStructureMasterModelImpl.getRecruitmentProcessId(),
					candidatePayStructureMasterModelImpl.getPayMasterStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((candidatePayStructureMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidatePayStructureMasterModelImpl.getOriginalRecruitmentProcessId(),
						candidatePayStructureMasterModelImpl.getOriginalPayMasterStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);

				args = new Object[] {
						candidatePayStructureMasterModelImpl.getRecruitmentProcessId(),
						candidatePayStructureMasterModelImpl.getPayMasterStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);
			}
		}

		entityCache.putResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			CandidatePayStructureMasterImpl.class,
			candidatePayStructureMaster.getPrimaryKey(),
			candidatePayStructureMaster, false);

		candidatePayStructureMaster.resetOriginalValues();

		return candidatePayStructureMaster;
	}

	/**
	 * Returns the candidate pay structure master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate pay structure master
	 * @return the candidate pay structure master
	 * @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidatePayStructureMasterException {
		CandidatePayStructureMaster candidatePayStructureMaster = fetchByPrimaryKey(primaryKey);

		if (candidatePayStructureMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidatePayStructureMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidatePayStructureMaster;
	}

	/**
	 * Returns the candidate pay structure master with the primary key or throws a {@link NoSuchCandidatePayStructureMasterException} if it could not be found.
	 *
	 * @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	 * @return the candidate pay structure master
	 * @throws NoSuchCandidatePayStructureMasterException if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster findByPrimaryKey(
		long candidatePayStructureMasterId)
		throws NoSuchCandidatePayStructureMasterException {
		return findByPrimaryKey((Serializable)candidatePayStructureMasterId);
	}

	/**
	 * Returns the candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate pay structure master
	 * @return the candidate pay structure master, or <code>null</code> if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
				CandidatePayStructureMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CandidatePayStructureMaster candidatePayStructureMaster = (CandidatePayStructureMaster)serializable;

		if (candidatePayStructureMaster == null) {
			Session session = null;

			try {
				session = openSession();

				candidatePayStructureMaster = (CandidatePayStructureMaster)session.get(CandidatePayStructureMasterImpl.class,
						primaryKey);

				if (candidatePayStructureMaster != null) {
					cacheResult(candidatePayStructureMaster);
				}
				else {
					entityCache.putResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
						CandidatePayStructureMasterImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
					CandidatePayStructureMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidatePayStructureMaster;
	}

	/**
	 * Returns the candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidatePayStructureMasterId the primary key of the candidate pay structure master
	 * @return the candidate pay structure master, or <code>null</code> if a candidate pay structure master with the primary key could not be found
	 */
	@Override
	public CandidatePayStructureMaster fetchByPrimaryKey(
		long candidatePayStructureMasterId) {
		return fetchByPrimaryKey((Serializable)candidatePayStructureMasterId);
	}

	@Override
	public Map<Serializable, CandidatePayStructureMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CandidatePayStructureMaster> map = new HashMap<Serializable, CandidatePayStructureMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CandidatePayStructureMaster candidatePayStructureMaster = fetchByPrimaryKey(primaryKey);

			if (candidatePayStructureMaster != null) {
				map.put(primaryKey, candidatePayStructureMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
					CandidatePayStructureMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(CandidatePayStructureMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER_WHERE_PKS_IN);

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

			for (CandidatePayStructureMaster candidatePayStructureMaster : (List<CandidatePayStructureMaster>)q.list()) {
				map.put(candidatePayStructureMaster.getPrimaryKeyObj(),
					candidatePayStructureMaster);

				cacheResult(candidatePayStructureMaster);

				uncachedPrimaryKeys.remove(candidatePayStructureMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
					CandidatePayStructureMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the candidate pay structure masters.
	 *
	 * @return the candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate pay structure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate pay structure masters
	 * @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	 * @return the range of candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate pay structure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate pay structure masters
	 * @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findAll(int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate pay structure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate pay structure masters
	 * @param end the upper bound of the range of candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of candidate pay structure masters
	 */
	@Override
	public List<CandidatePayStructureMaster> findAll(int start, int end,
		OrderByComparator<CandidatePayStructureMaster> orderByComparator,
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

		List<CandidatePayStructureMaster> list = null;

		if (retrieveFromCache) {
			list = (List<CandidatePayStructureMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER;

				if (pagination) {
					sql = sql.concat(CandidatePayStructureMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidatePayStructureMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidatePayStructureMaster>)QueryUtil.list(q,
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
	 * Removes all the candidate pay structure masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidatePayStructureMaster candidatePayStructureMaster : findAll()) {
			remove(candidatePayStructureMaster);
		}
	}

	/**
	 * Returns the number of candidate pay structure masters.
	 *
	 * @return the number of candidate pay structure masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEPAYSTRUCTUREMASTER);

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
		return CandidatePayStructureMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate pay structure master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CandidatePayStructureMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER = "SELECT candidatePayStructureMaster FROM CandidatePayStructureMaster candidatePayStructureMaster";
	private static final String _SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER_WHERE_PKS_IN =
		"SELECT candidatePayStructureMaster FROM CandidatePayStructureMaster candidatePayStructureMaster WHERE candidatePayStructureMasterId IN (";
	private static final String _SQL_SELECT_CANDIDATEPAYSTRUCTUREMASTER_WHERE = "SELECT candidatePayStructureMaster FROM CandidatePayStructureMaster candidatePayStructureMaster WHERE ";
	private static final String _SQL_COUNT_CANDIDATEPAYSTRUCTUREMASTER = "SELECT COUNT(candidatePayStructureMaster) FROM CandidatePayStructureMaster candidatePayStructureMaster";
	private static final String _SQL_COUNT_CANDIDATEPAYSTRUCTUREMASTER_WHERE = "SELECT COUNT(candidatePayStructureMaster) FROM CandidatePayStructureMaster candidatePayStructureMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidatePayStructureMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidatePayStructureMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CandidatePayStructureMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CandidatePayStructureMasterPersistenceImpl.class);
}