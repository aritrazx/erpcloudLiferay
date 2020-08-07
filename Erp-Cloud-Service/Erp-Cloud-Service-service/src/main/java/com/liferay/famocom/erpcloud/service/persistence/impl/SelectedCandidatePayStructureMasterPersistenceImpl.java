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

import com.liferay.famocom.erpcloud.exception.NoSuchSelectedCandidatePayStructureMasterException;
import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster;
import com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.SelectedCandidatePayStructureMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.SelectedCandidatePayStructureMasterPersistence;

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
 * The persistence implementation for the selected candidate pay structure master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.SelectedCandidatePayStructureMasterUtil
 * @generated
 */
@ProviderType
public class SelectedCandidatePayStructureMasterPersistenceImpl
	extends BasePersistenceImpl<SelectedCandidatePayStructureMaster>
	implements SelectedCandidatePayStructureMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SelectedCandidatePayStructureMasterUtil} to access the selected candidate pay structure master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SelectedCandidatePayStructureMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS =
		new FinderPath(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrecruitmentProcessIdAndPayMasterStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS =
		new FinderPath(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrecruitmentProcessIdAndPayMasterStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SelectedCandidatePayStructureMasterModelImpl.RECRUITMENTPROCESSID_COLUMN_BITMASK |
			SelectedCandidatePayStructureMasterModelImpl.PAYMASTERSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS =
		new FinderPath(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrecruitmentProcessIdAndPayMasterStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @return the matching selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		return findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param start the lower bound of the range of selected candidate pay structure masters
	 * @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	 * @return the range of matching selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end) {
		return findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param start the lower bound of the range of selected candidate pay structure masters
	 * @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
			payMasterStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param start the lower bound of the range of selected candidate pay structure masters
	 * @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus, int start, int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator,
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

		List<SelectedCandidatePayStructureMaster> list = null;

		if (retrieveFromCache) {
			list = (List<SelectedCandidatePayStructureMaster>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster : list) {
					if ((recruitmentProcessId != selectedCandidatePayStructureMaster.getRecruitmentProcessId()) ||
							(payMasterStatus != selectedCandidatePayStructureMaster.getPayMasterStatus())) {
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

			query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_RECRUITMENTPROCESSID_2);

			query.append(_FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_PAYMASTERSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SelectedCandidatePayStructureMasterModelImpl.ORDER_BY_JPQL);
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
					list = (List<SelectedCandidatePayStructureMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SelectedCandidatePayStructureMaster>)QueryUtil.list(q,
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
	 * Returns the first selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching selected candidate pay structure master
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a matching selected candidate pay structure master could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster = fetchByrecruitmentProcessIdAndPayMasterStatus_First(recruitmentProcessId,
				payMasterStatus, orderByComparator);

		if (selectedCandidatePayStructureMaster != null) {
			return selectedCandidatePayStructureMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitmentProcessId=");
		msg.append(recruitmentProcessId);

		msg.append(", payMasterStatus=");
		msg.append(payMasterStatus);

		msg.append("}");

		throw new NoSuchSelectedCandidatePayStructureMasterException(msg.toString());
	}

	/**
	 * Returns the first selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching selected candidate pay structure master, or <code>null</code> if a matching selected candidate pay structure master could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_First(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		List<SelectedCandidatePayStructureMaster> list = findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
				payMasterStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching selected candidate pay structure master
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a matching selected candidate pay structure master could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster findByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster = fetchByrecruitmentProcessIdAndPayMasterStatus_Last(recruitmentProcessId,
				payMasterStatus, orderByComparator);

		if (selectedCandidatePayStructureMaster != null) {
			return selectedCandidatePayStructureMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("recruitmentProcessId=");
		msg.append(recruitmentProcessId);

		msg.append(", payMasterStatus=");
		msg.append(payMasterStatus);

		msg.append("}");

		throw new NoSuchSelectedCandidatePayStructureMasterException(msg.toString());
	}

	/**
	 * Returns the last selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching selected candidate pay structure master, or <code>null</code> if a matching selected candidate pay structure master could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster fetchByrecruitmentProcessIdAndPayMasterStatus_Last(
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		int count = countByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
				payMasterStatus);

		if (count == 0) {
			return null;
		}

		List<SelectedCandidatePayStructureMaster> list = findByrecruitmentProcessIdAndPayMasterStatus(recruitmentProcessId,
				payMasterStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the selected candidate pay structure masters before and after the current selected candidate pay structure master in the ordered set where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param candidatePayStructureMasterId the primary key of the current selected candidate pay structure master
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next selected candidate pay structure master
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster[] findByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		long candidatePayStructureMasterId, long recruitmentProcessId,
		int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster = findByPrimaryKey(candidatePayStructureMasterId);

		Session session = null;

		try {
			session = openSession();

			SelectedCandidatePayStructureMaster[] array = new SelectedCandidatePayStructureMasterImpl[3];

			array[0] = getByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(session,
					selectedCandidatePayStructureMaster, recruitmentProcessId,
					payMasterStatus, orderByComparator, true);

			array[1] = selectedCandidatePayStructureMaster;

			array[2] = getByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(session,
					selectedCandidatePayStructureMaster, recruitmentProcessId,
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

	protected SelectedCandidatePayStructureMaster getByrecruitmentProcessIdAndPayMasterStatus_PrevAndNext(
		Session session,
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster,
		long recruitmentProcessId, int payMasterStatus,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator,
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

		query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE);

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
			query.append(SelectedCandidatePayStructureMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(recruitmentProcessId);

		qPos.add(payMasterStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(selectedCandidatePayStructureMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SelectedCandidatePayStructureMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63; from the database.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 */
	@Override
	public void removeByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		for (SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster : findByrecruitmentProcessIdAndPayMasterStatus(
				recruitmentProcessId, payMasterStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(selectedCandidatePayStructureMaster);
		}
	}

	/**
	 * Returns the number of selected candidate pay structure masters where recruitmentProcessId = &#63; and payMasterStatus = &#63;.
	 *
	 * @param recruitmentProcessId the recruitment process ID
	 * @param payMasterStatus the pay master status
	 * @return the number of matching selected candidate pay structure masters
	 */
	@Override
	public int countByrecruitmentProcessIdAndPayMasterStatus(
		long recruitmentProcessId, int payMasterStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS;

		Object[] finderArgs = new Object[] { recruitmentProcessId, payMasterStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE);

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
		"selectedCandidatePayStructureMaster.recruitmentProcessId = ? AND ";
	private static final String _FINDER_COLUMN_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS_PAYMASTERSTATUS_2 =
		"selectedCandidatePayStructureMaster.payMasterStatus = ?";

	public SelectedCandidatePayStructureMasterPersistenceImpl() {
		setModelClass(SelectedCandidatePayStructureMaster.class);
	}

	/**
	 * Caches the selected candidate pay structure master in the entity cache if it is enabled.
	 *
	 * @param selectedCandidatePayStructureMaster the selected candidate pay structure master
	 */
	@Override
	public void cacheResult(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		entityCache.putResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			selectedCandidatePayStructureMaster.getPrimaryKey(),
			selectedCandidatePayStructureMaster);

		selectedCandidatePayStructureMaster.resetOriginalValues();
	}

	/**
	 * Caches the selected candidate pay structure masters in the entity cache if it is enabled.
	 *
	 * @param selectedCandidatePayStructureMasters the selected candidate pay structure masters
	 */
	@Override
	public void cacheResult(
		List<SelectedCandidatePayStructureMaster> selectedCandidatePayStructureMasters) {
		for (SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster : selectedCandidatePayStructureMasters) {
			if (entityCache.getResult(
						SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
						SelectedCandidatePayStructureMasterImpl.class,
						selectedCandidatePayStructureMaster.getPrimaryKey()) == null) {
				cacheResult(selectedCandidatePayStructureMaster);
			}
			else {
				selectedCandidatePayStructureMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all selected candidate pay structure masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SelectedCandidatePayStructureMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the selected candidate pay structure master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		entityCache.removeResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			selectedCandidatePayStructureMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SelectedCandidatePayStructureMaster> selectedCandidatePayStructureMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster : selectedCandidatePayStructureMasters) {
			entityCache.removeResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
				SelectedCandidatePayStructureMasterImpl.class,
				selectedCandidatePayStructureMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new selected candidate pay structure master with the primary key. Does not add the selected candidate pay structure master to the database.
	 *
	 * @param candidatePayStructureMasterId the primary key for the new selected candidate pay structure master
	 * @return the new selected candidate pay structure master
	 */
	@Override
	public SelectedCandidatePayStructureMaster create(
		long candidatePayStructureMasterId) {
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster = new SelectedCandidatePayStructureMasterImpl();

		selectedCandidatePayStructureMaster.setNew(true);
		selectedCandidatePayStructureMaster.setPrimaryKey(candidatePayStructureMasterId);

		return selectedCandidatePayStructureMaster;
	}

	/**
	 * Removes the selected candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	 * @return the selected candidate pay structure master that was removed
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster remove(
		long candidatePayStructureMasterId)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		return remove((Serializable)candidatePayStructureMasterId);
	}

	/**
	 * Removes the selected candidate pay structure master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the selected candidate pay structure master
	 * @return the selected candidate pay structure master that was removed
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster remove(Serializable primaryKey)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		Session session = null;

		try {
			session = openSession();

			SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster =
				(SelectedCandidatePayStructureMaster)session.get(SelectedCandidatePayStructureMasterImpl.class,
					primaryKey);

			if (selectedCandidatePayStructureMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSelectedCandidatePayStructureMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(selectedCandidatePayStructureMaster);
		}
		catch (NoSuchSelectedCandidatePayStructureMasterException nsee) {
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
	protected SelectedCandidatePayStructureMaster removeImpl(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(selectedCandidatePayStructureMaster)) {
				selectedCandidatePayStructureMaster = (SelectedCandidatePayStructureMaster)session.get(SelectedCandidatePayStructureMasterImpl.class,
						selectedCandidatePayStructureMaster.getPrimaryKeyObj());
			}

			if (selectedCandidatePayStructureMaster != null) {
				session.delete(selectedCandidatePayStructureMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (selectedCandidatePayStructureMaster != null) {
			clearCache(selectedCandidatePayStructureMaster);
		}

		return selectedCandidatePayStructureMaster;
	}

	@Override
	public SelectedCandidatePayStructureMaster updateImpl(
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster) {
		boolean isNew = selectedCandidatePayStructureMaster.isNew();

		if (!(selectedCandidatePayStructureMaster instanceof SelectedCandidatePayStructureMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
						selectedCandidatePayStructureMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(selectedCandidatePayStructureMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in selectedCandidatePayStructureMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SelectedCandidatePayStructureMaster implementation " +
				selectedCandidatePayStructureMaster.getClass());
		}

		SelectedCandidatePayStructureMasterModelImpl selectedCandidatePayStructureMasterModelImpl =
			(SelectedCandidatePayStructureMasterModelImpl)selectedCandidatePayStructureMaster;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew &&
				(selectedCandidatePayStructureMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				selectedCandidatePayStructureMaster.setCreateDate(now);
			}
			else {
				selectedCandidatePayStructureMaster.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!selectedCandidatePayStructureMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				selectedCandidatePayStructureMaster.setModifiedDate(now);
			}
			else {
				selectedCandidatePayStructureMaster.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (selectedCandidatePayStructureMaster.isNew()) {
				session.save(selectedCandidatePayStructureMaster);

				selectedCandidatePayStructureMaster.setNew(false);
			}
			else {
				selectedCandidatePayStructureMaster = (SelectedCandidatePayStructureMaster)session.merge(selectedCandidatePayStructureMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SelectedCandidatePayStructureMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					selectedCandidatePayStructureMasterModelImpl.getRecruitmentProcessId(),
					selectedCandidatePayStructureMasterModelImpl.getPayMasterStatus()
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
			if ((selectedCandidatePayStructureMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						selectedCandidatePayStructureMasterModelImpl.getOriginalRecruitmentProcessId(),
						selectedCandidatePayStructureMasterModelImpl.getOriginalPayMasterStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);

				args = new Object[] {
						selectedCandidatePayStructureMasterModelImpl.getRecruitmentProcessId(),
						selectedCandidatePayStructureMasterModelImpl.getPayMasterStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECRUITMENTPROCESSIDANDPAYMASTERSTATUS,
					args);
			}
		}

		entityCache.putResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
			SelectedCandidatePayStructureMasterImpl.class,
			selectedCandidatePayStructureMaster.getPrimaryKey(),
			selectedCandidatePayStructureMaster, false);

		selectedCandidatePayStructureMaster.resetOriginalValues();

		return selectedCandidatePayStructureMaster;
	}

	/**
	 * Returns the selected candidate pay structure master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the selected candidate pay structure master
	 * @return the selected candidate pay structure master
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster = fetchByPrimaryKey(primaryKey);

		if (selectedCandidatePayStructureMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSelectedCandidatePayStructureMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return selectedCandidatePayStructureMaster;
	}

	/**
	 * Returns the selected candidate pay structure master with the primary key or throws a {@link NoSuchSelectedCandidatePayStructureMasterException} if it could not be found.
	 *
	 * @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	 * @return the selected candidate pay structure master
	 * @throws NoSuchSelectedCandidatePayStructureMasterException if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster findByPrimaryKey(
		long candidatePayStructureMasterId)
		throws NoSuchSelectedCandidatePayStructureMasterException {
		return findByPrimaryKey((Serializable)candidatePayStructureMasterId);
	}

	/**
	 * Returns the selected candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the selected candidate pay structure master
	 * @return the selected candidate pay structure master, or <code>null</code> if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
				SelectedCandidatePayStructureMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster = (SelectedCandidatePayStructureMaster)serializable;

		if (selectedCandidatePayStructureMaster == null) {
			Session session = null;

			try {
				session = openSession();

				selectedCandidatePayStructureMaster = (SelectedCandidatePayStructureMaster)session.get(SelectedCandidatePayStructureMasterImpl.class,
						primaryKey);

				if (selectedCandidatePayStructureMaster != null) {
					cacheResult(selectedCandidatePayStructureMaster);
				}
				else {
					entityCache.putResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
						SelectedCandidatePayStructureMasterImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
					SelectedCandidatePayStructureMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return selectedCandidatePayStructureMaster;
	}

	/**
	 * Returns the selected candidate pay structure master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidatePayStructureMasterId the primary key of the selected candidate pay structure master
	 * @return the selected candidate pay structure master, or <code>null</code> if a selected candidate pay structure master with the primary key could not be found
	 */
	@Override
	public SelectedCandidatePayStructureMaster fetchByPrimaryKey(
		long candidatePayStructureMasterId) {
		return fetchByPrimaryKey((Serializable)candidatePayStructureMasterId);
	}

	@Override
	public Map<Serializable, SelectedCandidatePayStructureMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SelectedCandidatePayStructureMaster> map = new HashMap<Serializable, SelectedCandidatePayStructureMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster =
				fetchByPrimaryKey(primaryKey);

			if (selectedCandidatePayStructureMaster != null) {
				map.put(primaryKey, selectedCandidatePayStructureMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
					SelectedCandidatePayStructureMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(SelectedCandidatePayStructureMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE_PKS_IN);

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

			for (SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster : (List<SelectedCandidatePayStructureMaster>)q.list()) {
				map.put(selectedCandidatePayStructureMaster.getPrimaryKeyObj(),
					selectedCandidatePayStructureMaster);

				cacheResult(selectedCandidatePayStructureMaster);

				uncachedPrimaryKeys.remove(selectedCandidatePayStructureMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SelectedCandidatePayStructureMasterModelImpl.ENTITY_CACHE_ENABLED,
					SelectedCandidatePayStructureMasterImpl.class, primaryKey,
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
	 * Returns all the selected candidate pay structure masters.
	 *
	 * @return the selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the selected candidate pay structure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of selected candidate pay structure masters
	 * @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	 * @return the range of selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of selected candidate pay structure masters
	 * @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findAll(int start,
		int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the selected candidate pay structure masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SelectedCandidatePayStructureMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of selected candidate pay structure masters
	 * @param end the upper bound of the range of selected candidate pay structure masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of selected candidate pay structure masters
	 */
	@Override
	public List<SelectedCandidatePayStructureMaster> findAll(int start,
		int end,
		OrderByComparator<SelectedCandidatePayStructureMaster> orderByComparator,
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

		List<SelectedCandidatePayStructureMaster> list = null;

		if (retrieveFromCache) {
			list = (List<SelectedCandidatePayStructureMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER;

				if (pagination) {
					sql = sql.concat(SelectedCandidatePayStructureMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SelectedCandidatePayStructureMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SelectedCandidatePayStructureMaster>)QueryUtil.list(q,
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
	 * Removes all the selected candidate pay structure masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster : findAll()) {
			remove(selectedCandidatePayStructureMaster);
		}
	}

	/**
	 * Returns the number of selected candidate pay structure masters.
	 *
	 * @return the number of selected candidate pay structure masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER);

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
		return SelectedCandidatePayStructureMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the selected candidate pay structure master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SelectedCandidatePayStructureMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER = "SELECT selectedCandidatePayStructureMaster FROM SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster";
	private static final String _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE_PKS_IN =
		"SELECT selectedCandidatePayStructureMaster FROM SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster WHERE candidatePayStructureMasterId IN (";
	private static final String _SQL_SELECT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE =
		"SELECT selectedCandidatePayStructureMaster FROM SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster WHERE ";
	private static final String _SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER = "SELECT COUNT(selectedCandidatePayStructureMaster) FROM SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster";
	private static final String _SQL_COUNT_SELECTEDCANDIDATEPAYSTRUCTUREMASTER_WHERE =
		"SELECT COUNT(selectedCandidatePayStructureMaster) FROM SelectedCandidatePayStructureMaster selectedCandidatePayStructureMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "selectedCandidatePayStructureMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SelectedCandidatePayStructureMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SelectedCandidatePayStructureMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SelectedCandidatePayStructureMasterPersistenceImpl.class);
}