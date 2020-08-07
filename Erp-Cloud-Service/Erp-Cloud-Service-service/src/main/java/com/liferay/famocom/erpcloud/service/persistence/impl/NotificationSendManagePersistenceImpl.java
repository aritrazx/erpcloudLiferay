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

import com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException;
import com.liferay.famocom.erpcloud.model.NotificationSendManage;
import com.liferay.famocom.erpcloud.model.impl.NotificationSendManageImpl;
import com.liferay.famocom.erpcloud.model.impl.NotificationSendManageModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.NotificationSendManagePersistence;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the notification send manage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see NotificationSendManagePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.NotificationSendManageUtil
 * @generated
 */
@ProviderType
public class NotificationSendManagePersistenceImpl extends BasePersistenceImpl<NotificationSendManage>
	implements NotificationSendManagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationSendManageUtil} to access the notification send manage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationSendManageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRANCHID = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBranchId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHID =
		new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBranchId",
			new String[] { Long.class.getName() },
			NotificationSendManageModelImpl.BRANCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRANCHID = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBranchId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notification send manages where branchId = &#63;.
	 *
	 * @param branchId the branch ID
	 * @return the matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchId(long branchId) {
		return findByBranchId(branchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the notification send manages where branchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param branchId the branch ID
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @return the range of matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchId(long branchId,
		int start, int end) {
		return findByBranchId(branchId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification send manages where branchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param branchId the branch ID
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchId(long branchId,
		int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return findByBranchId(branchId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification send manages where branchId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param branchId the branch ID
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchId(long branchId,
		int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHID;
			finderArgs = new Object[] { branchId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRANCHID;
			finderArgs = new Object[] { branchId, start, end, orderByComparator };
		}

		List<NotificationSendManage> list = null;

		if (retrieveFromCache) {
			list = (List<NotificationSendManage>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationSendManage notificationSendManage : list) {
					if ((branchId != notificationSendManage.getBranchId())) {
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

			query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_BRANCHID_BRANCHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificationSendManageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(branchId);

				if (!pagination) {
					list = (List<NotificationSendManage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NotificationSendManage>)QueryUtil.list(q,
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
	 * Returns the first notification send manage in the ordered set where branchId = &#63;.
	 *
	 * @param branchId the branch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification send manage
	 * @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage findByBranchId_First(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByBranchId_First(branchId,
				orderByComparator);

		if (notificationSendManage != null) {
			return notificationSendManage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("branchId=");
		msg.append(branchId);

		msg.append("}");

		throw new NoSuchNotificationSendManageException(msg.toString());
	}

	/**
	 * Returns the first notification send manage in the ordered set where branchId = &#63;.
	 *
	 * @param branchId the branch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByBranchId_First(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		List<NotificationSendManage> list = findByBranchId(branchId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification send manage in the ordered set where branchId = &#63;.
	 *
	 * @param branchId the branch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification send manage
	 * @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage findByBranchId_Last(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByBranchId_Last(branchId,
				orderByComparator);

		if (notificationSendManage != null) {
			return notificationSendManage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("branchId=");
		msg.append(branchId);

		msg.append("}");

		throw new NoSuchNotificationSendManageException(msg.toString());
	}

	/**
	 * Returns the last notification send manage in the ordered set where branchId = &#63;.
	 *
	 * @param branchId the branch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByBranchId_Last(long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		int count = countByBranchId(branchId);

		if (count == 0) {
			return null;
		}

		List<NotificationSendManage> list = findByBranchId(branchId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification send manages before and after the current notification send manage in the ordered set where branchId = &#63;.
	 *
	 * @param notifyIdSendId the primary key of the current notification send manage
	 * @param branchId the branch ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification send manage
	 * @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage[] findByBranchId_PrevAndNext(
		long notifyIdSendId, long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = findByPrimaryKey(notifyIdSendId);

		Session session = null;

		try {
			session = openSession();

			NotificationSendManage[] array = new NotificationSendManageImpl[3];

			array[0] = getByBranchId_PrevAndNext(session,
					notificationSendManage, branchId, orderByComparator, true);

			array[1] = notificationSendManage;

			array[2] = getByBranchId_PrevAndNext(session,
					notificationSendManage, branchId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificationSendManage getByBranchId_PrevAndNext(
		Session session, NotificationSendManage notificationSendManage,
		long branchId,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE);

		query.append(_FINDER_COLUMN_BRANCHID_BRANCHID_2);

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
			query.append(NotificationSendManageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(branchId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificationSendManage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificationSendManage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification send manages where branchId = &#63; from the database.
	 *
	 * @param branchId the branch ID
	 */
	@Override
	public void removeByBranchId(long branchId) {
		for (NotificationSendManage notificationSendManage : findByBranchId(
				branchId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificationSendManage);
		}
	}

	/**
	 * Returns the number of notification send manages where branchId = &#63;.
	 *
	 * @param branchId the branch ID
	 * @return the number of matching notification send manages
	 */
	@Override
	public int countByBranchId(long branchId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRANCHID;

		Object[] finderArgs = new Object[] { branchId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_BRANCHID_BRANCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(branchId);

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

	private static final String _FINDER_COLUMN_BRANCHID_BRANCHID_2 = "notificationSendManage.branchId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NOTIFICATIONID = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNotificationId", new String[] { Long.class.getName() },
			NotificationSendManageModelImpl.NOTIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTIFICATIONID = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNotificationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the notification send manage where notificationId = &#63; or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	 *
	 * @param notificationId the notification ID
	 * @return the matching notification send manage
	 * @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage findByNotificationId(long notificationId)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByNotificationId(notificationId);

		if (notificationSendManage == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("notificationId=");
			msg.append(notificationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchNotificationSendManageException(msg.toString());
		}

		return notificationSendManage;
	}

	/**
	 * Returns the notification send manage where notificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param notificationId the notification ID
	 * @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByNotificationId(long notificationId) {
		return fetchByNotificationId(notificationId, true);
	}

	/**
	 * Returns the notification send manage where notificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param notificationId the notification ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByNotificationId(long notificationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { notificationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID,
					finderArgs, this);
		}

		if (result instanceof NotificationSendManage) {
			NotificationSendManage notificationSendManage = (NotificationSendManage)result;

			if ((notificationId != notificationSendManage.getNotificationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_NOTIFICATIONID_NOTIFICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificationId);

				List<NotificationSendManage> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"NotificationSendManagePersistenceImpl.fetchByNotificationId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					NotificationSendManage notificationSendManage = list.get(0);

					result = notificationSendManage;

					cacheResult(notificationSendManage);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID,
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
			return (NotificationSendManage)result;
		}
	}

	/**
	 * Removes the notification send manage where notificationId = &#63; from the database.
	 *
	 * @param notificationId the notification ID
	 * @return the notification send manage that was removed
	 */
	@Override
	public NotificationSendManage removeByNotificationId(long notificationId)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = findByNotificationId(notificationId);

		return remove(notificationSendManage);
	}

	/**
	 * Returns the number of notification send manages where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @return the number of matching notification send manages
	 */
	@Override
	public int countByNotificationId(long notificationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTIFICATIONID;

		Object[] finderArgs = new Object[] { notificationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_NOTIFICATIONID_NOTIFICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificationId);

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

	private static final String _FINDER_COLUMN_NOTIFICATIONID_NOTIFICATIONID_2 = "notificationSendManage.notificationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID =
		new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBranchFromNotificationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID =
		new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBranchFromNotificationId",
			new String[] { Long.class.getName() },
			NotificationSendManageModelImpl.NOTIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRANCHFROMNOTIFICATIONID =
		new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBranchFromNotificationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notification send manages where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @return the matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId) {
		return findByBranchFromNotificationId(notificationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification send manages where notificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificationId the notification ID
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @return the range of matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end) {
		return findByBranchFromNotificationId(notificationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification send manages where notificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificationId the notification ID
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return findByBranchFromNotificationId(notificationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification send manages where notificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param notificationId the notification ID
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching notification send manages
	 */
	@Override
	public List<NotificationSendManage> findByBranchFromNotificationId(
		long notificationId, int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID;
			finderArgs = new Object[] { notificationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID;
			finderArgs = new Object[] {
					notificationId,
					
					start, end, orderByComparator
				};
		}

		List<NotificationSendManage> list = null;

		if (retrieveFromCache) {
			list = (List<NotificationSendManage>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NotificationSendManage notificationSendManage : list) {
					if ((notificationId != notificationSendManage.getNotificationId())) {
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

			query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_BRANCHFROMNOTIFICATIONID_NOTIFICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificationSendManageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificationId);

				if (!pagination) {
					list = (List<NotificationSendManage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NotificationSendManage>)QueryUtil.list(q,
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
	 * Returns the first notification send manage in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification send manage
	 * @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage findByBranchFromNotificationId_First(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByBranchFromNotificationId_First(notificationId,
				orderByComparator);

		if (notificationSendManage != null) {
			return notificationSendManage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificationId=");
		msg.append(notificationId);

		msg.append("}");

		throw new NoSuchNotificationSendManageException(msg.toString());
	}

	/**
	 * Returns the first notification send manage in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByBranchFromNotificationId_First(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		List<NotificationSendManage> list = findByBranchFromNotificationId(notificationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification send manage in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification send manage
	 * @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage findByBranchFromNotificationId_Last(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByBranchFromNotificationId_Last(notificationId,
				orderByComparator);

		if (notificationSendManage != null) {
			return notificationSendManage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("notificationId=");
		msg.append(notificationId);

		msg.append("}");

		throw new NoSuchNotificationSendManageException(msg.toString());
	}

	/**
	 * Returns the last notification send manage in the ordered set where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByBranchFromNotificationId_Last(
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		int count = countByBranchFromNotificationId(notificationId);

		if (count == 0) {
			return null;
		}

		List<NotificationSendManage> list = findByBranchFromNotificationId(notificationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notification send manages before and after the current notification send manage in the ordered set where notificationId = &#63;.
	 *
	 * @param notifyIdSendId the primary key of the current notification send manage
	 * @param notificationId the notification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification send manage
	 * @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage[] findByBranchFromNotificationId_PrevAndNext(
		long notifyIdSendId, long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = findByPrimaryKey(notifyIdSendId);

		Session session = null;

		try {
			session = openSession();

			NotificationSendManage[] array = new NotificationSendManageImpl[3];

			array[0] = getByBranchFromNotificationId_PrevAndNext(session,
					notificationSendManage, notificationId, orderByComparator,
					true);

			array[1] = notificationSendManage;

			array[2] = getByBranchFromNotificationId_PrevAndNext(session,
					notificationSendManage, notificationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificationSendManage getByBranchFromNotificationId_PrevAndNext(
		Session session, NotificationSendManage notificationSendManage,
		long notificationId,
		OrderByComparator<NotificationSendManage> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE);

		query.append(_FINDER_COLUMN_BRANCHFROMNOTIFICATIONID_NOTIFICATIONID_2);

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
			query.append(NotificationSendManageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(notificationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificationSendManage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificationSendManage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification send manages where notificationId = &#63; from the database.
	 *
	 * @param notificationId the notification ID
	 */
	@Override
	public void removeByBranchFromNotificationId(long notificationId) {
		for (NotificationSendManage notificationSendManage : findByBranchFromNotificationId(
				notificationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificationSendManage);
		}
	}

	/**
	 * Returns the number of notification send manages where notificationId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @return the number of matching notification send manages
	 */
	@Override
	public int countByBranchFromNotificationId(long notificationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRANCHFROMNOTIFICATIONID;

		Object[] finderArgs = new Object[] { notificationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_BRANCHFROMNOTIFICATIONID_NOTIFICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificationId);

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

	private static final String _FINDER_COLUMN_BRANCHFROMNOTIFICATIONID_NOTIFICATIONID_2 =
		"notificationSendManage.notificationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationSendManageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByBranchAndNotificationId",
			new String[] { Long.class.getName(), Long.class.getName() },
			NotificationSendManageModelImpl.NOTIFICATIONID_COLUMN_BITMASK |
			NotificationSendManageModelImpl.BRANCHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRANCHANDNOTIFICATIONID = new FinderPath(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBranchAndNotificationId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the notification send manage where notificationId = &#63; and branchId = &#63; or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	 *
	 * @param notificationId the notification ID
	 * @param branchId the branch ID
	 * @return the matching notification send manage
	 * @throws NoSuchNotificationSendManageException if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage findByBranchAndNotificationId(
		long notificationId, long branchId)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByBranchAndNotificationId(notificationId,
				branchId);

		if (notificationSendManage == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("notificationId=");
			msg.append(notificationId);

			msg.append(", branchId=");
			msg.append(branchId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchNotificationSendManageException(msg.toString());
		}

		return notificationSendManage;
	}

	/**
	 * Returns the notification send manage where notificationId = &#63; and branchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param notificationId the notification ID
	 * @param branchId the branch ID
	 * @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByBranchAndNotificationId(
		long notificationId, long branchId) {
		return fetchByBranchAndNotificationId(notificationId, branchId, true);
	}

	/**
	 * Returns the notification send manage where notificationId = &#63; and branchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param notificationId the notification ID
	 * @param branchId the branch ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching notification send manage, or <code>null</code> if a matching notification send manage could not be found
	 */
	@Override
	public NotificationSendManage fetchByBranchAndNotificationId(
		long notificationId, long branchId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { notificationId, branchId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
					finderArgs, this);
		}

		if (result instanceof NotificationSendManage) {
			NotificationSendManage notificationSendManage = (NotificationSendManage)result;

			if ((notificationId != notificationSendManage.getNotificationId()) ||
					(branchId != notificationSendManage.getBranchId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_BRANCHANDNOTIFICATIONID_NOTIFICATIONID_2);

			query.append(_FINDER_COLUMN_BRANCHANDNOTIFICATIONID_BRANCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificationId);

				qPos.add(branchId);

				List<NotificationSendManage> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"NotificationSendManagePersistenceImpl.fetchByBranchAndNotificationId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					NotificationSendManage notificationSendManage = list.get(0);

					result = notificationSendManage;

					cacheResult(notificationSendManage);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
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
			return (NotificationSendManage)result;
		}
	}

	/**
	 * Removes the notification send manage where notificationId = &#63; and branchId = &#63; from the database.
	 *
	 * @param notificationId the notification ID
	 * @param branchId the branch ID
	 * @return the notification send manage that was removed
	 */
	@Override
	public NotificationSendManage removeByBranchAndNotificationId(
		long notificationId, long branchId)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = findByBranchAndNotificationId(notificationId,
				branchId);

		return remove(notificationSendManage);
	}

	/**
	 * Returns the number of notification send manages where notificationId = &#63; and branchId = &#63;.
	 *
	 * @param notificationId the notification ID
	 * @param branchId the branch ID
	 * @return the number of matching notification send manages
	 */
	@Override
	public int countByBranchAndNotificationId(long notificationId, long branchId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRANCHANDNOTIFICATIONID;

		Object[] finderArgs = new Object[] { notificationId, branchId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NOTIFICATIONSENDMANAGE_WHERE);

			query.append(_FINDER_COLUMN_BRANCHANDNOTIFICATIONID_NOTIFICATIONID_2);

			query.append(_FINDER_COLUMN_BRANCHANDNOTIFICATIONID_BRANCHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(notificationId);

				qPos.add(branchId);

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

	private static final String _FINDER_COLUMN_BRANCHANDNOTIFICATIONID_NOTIFICATIONID_2 =
		"notificationSendManage.notificationId = ? AND ";
	private static final String _FINDER_COLUMN_BRANCHANDNOTIFICATIONID_BRANCHID_2 =
		"notificationSendManage.branchId = ?";

	public NotificationSendManagePersistenceImpl() {
		setModelClass(NotificationSendManage.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("comment", "comment_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the notification send manage in the entity cache if it is enabled.
	 *
	 * @param notificationSendManage the notification send manage
	 */
	@Override
	public void cacheResult(NotificationSendManage notificationSendManage) {
		entityCache.putResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			notificationSendManage.getPrimaryKey(), notificationSendManage);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID,
			new Object[] { notificationSendManage.getNotificationId() },
			notificationSendManage);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
			new Object[] {
				notificationSendManage.getNotificationId(),
				notificationSendManage.getBranchId()
			}, notificationSendManage);

		notificationSendManage.resetOriginalValues();
	}

	/**
	 * Caches the notification send manages in the entity cache if it is enabled.
	 *
	 * @param notificationSendManages the notification send manages
	 */
	@Override
	public void cacheResult(
		List<NotificationSendManage> notificationSendManages) {
		for (NotificationSendManage notificationSendManage : notificationSendManages) {
			if (entityCache.getResult(
						NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
						NotificationSendManageImpl.class,
						notificationSendManage.getPrimaryKey()) == null) {
				cacheResult(notificationSendManage);
			}
			else {
				notificationSendManage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notification send manages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotificationSendManageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification send manage.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationSendManage notificationSendManage) {
		entityCache.removeResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			notificationSendManage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((NotificationSendManageModelImpl)notificationSendManage,
			true);
	}

	@Override
	public void clearCache(List<NotificationSendManage> notificationSendManages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificationSendManage notificationSendManage : notificationSendManages) {
			entityCache.removeResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
				NotificationSendManageImpl.class,
				notificationSendManage.getPrimaryKey());

			clearUniqueFindersCache((NotificationSendManageModelImpl)notificationSendManage,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		NotificationSendManageModelImpl notificationSendManageModelImpl) {
		Object[] args = new Object[] {
				notificationSendManageModelImpl.getNotificationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_NOTIFICATIONID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID, args,
			notificationSendManageModelImpl, false);

		args = new Object[] {
				notificationSendManageModelImpl.getNotificationId(),
				notificationSendManageModelImpl.getBranchId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_BRANCHANDNOTIFICATIONID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
			args, notificationSendManageModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		NotificationSendManageModelImpl notificationSendManageModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					notificationSendManageModelImpl.getNotificationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATIONID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID, args);
		}

		if ((notificationSendManageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NOTIFICATIONID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					notificationSendManageModelImpl.getOriginalNotificationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATIONID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NOTIFICATIONID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					notificationSendManageModelImpl.getNotificationId(),
					notificationSendManageModelImpl.getBranchId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHANDNOTIFICATIONID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
				args);
		}

		if ((notificationSendManageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					notificationSendManageModelImpl.getOriginalNotificationId(),
					notificationSendManageModelImpl.getOriginalBranchId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHANDNOTIFICATIONID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BRANCHANDNOTIFICATIONID,
				args);
		}
	}

	/**
	 * Creates a new notification send manage with the primary key. Does not add the notification send manage to the database.
	 *
	 * @param notifyIdSendId the primary key for the new notification send manage
	 * @return the new notification send manage
	 */
	@Override
	public NotificationSendManage create(long notifyIdSendId) {
		NotificationSendManage notificationSendManage = new NotificationSendManageImpl();

		notificationSendManage.setNew(true);
		notificationSendManage.setPrimaryKey(notifyIdSendId);

		return notificationSendManage;
	}

	/**
	 * Removes the notification send manage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notifyIdSendId the primary key of the notification send manage
	 * @return the notification send manage that was removed
	 * @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage remove(long notifyIdSendId)
		throws NoSuchNotificationSendManageException {
		return remove((Serializable)notifyIdSendId);
	}

	/**
	 * Removes the notification send manage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification send manage
	 * @return the notification send manage that was removed
	 * @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage remove(Serializable primaryKey)
		throws NoSuchNotificationSendManageException {
		Session session = null;

		try {
			session = openSession();

			NotificationSendManage notificationSendManage = (NotificationSendManage)session.get(NotificationSendManageImpl.class,
					primaryKey);

			if (notificationSendManage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationSendManageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificationSendManage);
		}
		catch (NoSuchNotificationSendManageException nsee) {
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
	protected NotificationSendManage removeImpl(
		NotificationSendManage notificationSendManage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificationSendManage)) {
				notificationSendManage = (NotificationSendManage)session.get(NotificationSendManageImpl.class,
						notificationSendManage.getPrimaryKeyObj());
			}

			if (notificationSendManage != null) {
				session.delete(notificationSendManage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificationSendManage != null) {
			clearCache(notificationSendManage);
		}

		return notificationSendManage;
	}

	@Override
	public NotificationSendManage updateImpl(
		NotificationSendManage notificationSendManage) {
		boolean isNew = notificationSendManage.isNew();

		if (!(notificationSendManage instanceof NotificationSendManageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(notificationSendManage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(notificationSendManage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in notificationSendManage proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NotificationSendManage implementation " +
				notificationSendManage.getClass());
		}

		NotificationSendManageModelImpl notificationSendManageModelImpl = (NotificationSendManageModelImpl)notificationSendManage;

		Session session = null;

		try {
			session = openSession();

			if (notificationSendManage.isNew()) {
				session.save(notificationSendManage);

				notificationSendManage.setNew(false);
			}
			else {
				notificationSendManage = (NotificationSendManage)session.merge(notificationSendManage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!NotificationSendManageModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					notificationSendManageModelImpl.getBranchId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHID,
				args);

			args = new Object[] {
					notificationSendManageModelImpl.getNotificationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHFROMNOTIFICATIONID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((notificationSendManageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificationSendManageModelImpl.getOriginalBranchId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHID,
					args);

				args = new Object[] {
						notificationSendManageModelImpl.getBranchId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHID,
					args);
			}

			if ((notificationSendManageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificationSendManageModelImpl.getOriginalNotificationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHFROMNOTIFICATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID,
					args);

				args = new Object[] {
						notificationSendManageModelImpl.getNotificationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BRANCHFROMNOTIFICATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BRANCHFROMNOTIFICATIONID,
					args);
			}
		}

		entityCache.putResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationSendManageImpl.class,
			notificationSendManage.getPrimaryKey(), notificationSendManage,
			false);

		clearUniqueFindersCache(notificationSendManageModelImpl, false);
		cacheUniqueFindersCache(notificationSendManageModelImpl);

		notificationSendManage.resetOriginalValues();

		return notificationSendManage;
	}

	/**
	 * Returns the notification send manage with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification send manage
	 * @return the notification send manage
	 * @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationSendManageException {
		NotificationSendManage notificationSendManage = fetchByPrimaryKey(primaryKey);

		if (notificationSendManage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationSendManageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificationSendManage;
	}

	/**
	 * Returns the notification send manage with the primary key or throws a {@link NoSuchNotificationSendManageException} if it could not be found.
	 *
	 * @param notifyIdSendId the primary key of the notification send manage
	 * @return the notification send manage
	 * @throws NoSuchNotificationSendManageException if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage findByPrimaryKey(long notifyIdSendId)
		throws NoSuchNotificationSendManageException {
		return findByPrimaryKey((Serializable)notifyIdSendId);
	}

	/**
	 * Returns the notification send manage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification send manage
	 * @return the notification send manage, or <code>null</code> if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
				NotificationSendManageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		NotificationSendManage notificationSendManage = (NotificationSendManage)serializable;

		if (notificationSendManage == null) {
			Session session = null;

			try {
				session = openSession();

				notificationSendManage = (NotificationSendManage)session.get(NotificationSendManageImpl.class,
						primaryKey);

				if (notificationSendManage != null) {
					cacheResult(notificationSendManage);
				}
				else {
					entityCache.putResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
						NotificationSendManageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
					NotificationSendManageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificationSendManage;
	}

	/**
	 * Returns the notification send manage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notifyIdSendId the primary key of the notification send manage
	 * @return the notification send manage, or <code>null</code> if a notification send manage with the primary key could not be found
	 */
	@Override
	public NotificationSendManage fetchByPrimaryKey(long notifyIdSendId) {
		return fetchByPrimaryKey((Serializable)notifyIdSendId);
	}

	@Override
	public Map<Serializable, NotificationSendManage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, NotificationSendManage> map = new HashMap<Serializable, NotificationSendManage>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			NotificationSendManage notificationSendManage = fetchByPrimaryKey(primaryKey);

			if (notificationSendManage != null) {
				map.put(primaryKey, notificationSendManage);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
					NotificationSendManageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (NotificationSendManage)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE_PKS_IN);

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

			for (NotificationSendManage notificationSendManage : (List<NotificationSendManage>)q.list()) {
				map.put(notificationSendManage.getPrimaryKeyObj(),
					notificationSendManage);

				cacheResult(notificationSendManage);

				uncachedPrimaryKeys.remove(notificationSendManage.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(NotificationSendManageModelImpl.ENTITY_CACHE_ENABLED,
					NotificationSendManageImpl.class, primaryKey, nullModel);
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
	 * Returns all the notification send manages.
	 *
	 * @return the notification send manages
	 */
	@Override
	public List<NotificationSendManage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification send manages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @return the range of notification send manages
	 */
	@Override
	public List<NotificationSendManage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification send manages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notification send manages
	 */
	@Override
	public List<NotificationSendManage> findAll(int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification send manages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationSendManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification send manages
	 * @param end the upper bound of the range of notification send manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of notification send manages
	 */
	@Override
	public List<NotificationSendManage> findAll(int start, int end,
		OrderByComparator<NotificationSendManage> orderByComparator,
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

		List<NotificationSendManage> list = null;

		if (retrieveFromCache) {
			list = (List<NotificationSendManage>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NOTIFICATIONSENDMANAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONSENDMANAGE;

				if (pagination) {
					sql = sql.concat(NotificationSendManageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificationSendManage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NotificationSendManage>)QueryUtil.list(q,
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
	 * Removes all the notification send manages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NotificationSendManage notificationSendManage : findAll()) {
			remove(notificationSendManage);
		}
	}

	/**
	 * Returns the number of notification send manages.
	 *
	 * @return the number of notification send manages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATIONSENDMANAGE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NotificationSendManageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notification send manage persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NotificationSendManageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_NOTIFICATIONSENDMANAGE = "SELECT notificationSendManage FROM NotificationSendManage notificationSendManage";
	private static final String _SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE_PKS_IN = "SELECT notificationSendManage FROM NotificationSendManage notificationSendManage WHERE notifyIdSendId IN (";
	private static final String _SQL_SELECT_NOTIFICATIONSENDMANAGE_WHERE = "SELECT notificationSendManage FROM NotificationSendManage notificationSendManage WHERE ";
	private static final String _SQL_COUNT_NOTIFICATIONSENDMANAGE = "SELECT COUNT(notificationSendManage) FROM NotificationSendManage notificationSendManage";
	private static final String _SQL_COUNT_NOTIFICATIONSENDMANAGE_WHERE = "SELECT COUNT(notificationSendManage) FROM NotificationSendManage notificationSendManage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationSendManage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificationSendManage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NotificationSendManage exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(NotificationSendManagePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
}