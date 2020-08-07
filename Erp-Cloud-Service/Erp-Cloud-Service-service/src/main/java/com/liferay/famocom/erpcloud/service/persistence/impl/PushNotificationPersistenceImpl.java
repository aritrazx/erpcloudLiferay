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

import com.liferay.famocom.erpcloud.exception.NoSuchPushNotificationException;
import com.liferay.famocom.erpcloud.model.PushNotification;
import com.liferay.famocom.erpcloud.model.impl.PushNotificationImpl;
import com.liferay.famocom.erpcloud.model.impl.PushNotificationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.PushNotificationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the push notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PushNotificationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.PushNotificationUtil
 * @generated
 */
@ProviderType
public class PushNotificationPersistenceImpl extends BasePersistenceImpl<PushNotification>
	implements PushNotificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PushNotificationUtil} to access the push notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PushNotificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
			PushNotificationModelImpl.FINDER_CACHE_ENABLED,
			PushNotificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
			PushNotificationModelImpl.FINDER_CACHE_ENABLED,
			PushNotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
			PushNotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PushNotificationPersistenceImpl() {
		setModelClass(PushNotification.class);
	}

	/**
	 * Caches the push notification in the entity cache if it is enabled.
	 *
	 * @param pushNotification the push notification
	 */
	@Override
	public void cacheResult(PushNotification pushNotification) {
		entityCache.putResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
			PushNotificationImpl.class, pushNotification.getPrimaryKey(),
			pushNotification);

		pushNotification.resetOriginalValues();
	}

	/**
	 * Caches the push notifications in the entity cache if it is enabled.
	 *
	 * @param pushNotifications the push notifications
	 */
	@Override
	public void cacheResult(List<PushNotification> pushNotifications) {
		for (PushNotification pushNotification : pushNotifications) {
			if (entityCache.getResult(
						PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
						PushNotificationImpl.class,
						pushNotification.getPrimaryKey()) == null) {
				cacheResult(pushNotification);
			}
			else {
				pushNotification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all push notifications.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PushNotificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the push notification.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PushNotification pushNotification) {
		entityCache.removeResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
			PushNotificationImpl.class, pushNotification.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PushNotification> pushNotifications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PushNotification pushNotification : pushNotifications) {
			entityCache.removeResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
				PushNotificationImpl.class, pushNotification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new push notification with the primary key. Does not add the push notification to the database.
	 *
	 * @param pushNotificationId the primary key for the new push notification
	 * @return the new push notification
	 */
	@Override
	public PushNotification create(long pushNotificationId) {
		PushNotification pushNotification = new PushNotificationImpl();

		pushNotification.setNew(true);
		pushNotification.setPrimaryKey(pushNotificationId);

		return pushNotification;
	}

	/**
	 * Removes the push notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pushNotificationId the primary key of the push notification
	 * @return the push notification that was removed
	 * @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	 */
	@Override
	public PushNotification remove(long pushNotificationId)
		throws NoSuchPushNotificationException {
		return remove((Serializable)pushNotificationId);
	}

	/**
	 * Removes the push notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the push notification
	 * @return the push notification that was removed
	 * @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	 */
	@Override
	public PushNotification remove(Serializable primaryKey)
		throws NoSuchPushNotificationException {
		Session session = null;

		try {
			session = openSession();

			PushNotification pushNotification = (PushNotification)session.get(PushNotificationImpl.class,
					primaryKey);

			if (pushNotification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPushNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pushNotification);
		}
		catch (NoSuchPushNotificationException nsee) {
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
	protected PushNotification removeImpl(PushNotification pushNotification) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pushNotification)) {
				pushNotification = (PushNotification)session.get(PushNotificationImpl.class,
						pushNotification.getPrimaryKeyObj());
			}

			if (pushNotification != null) {
				session.delete(pushNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pushNotification != null) {
			clearCache(pushNotification);
		}

		return pushNotification;
	}

	@Override
	public PushNotification updateImpl(PushNotification pushNotification) {
		boolean isNew = pushNotification.isNew();

		if (!(pushNotification instanceof PushNotificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pushNotification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pushNotification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pushNotification proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PushNotification implementation " +
				pushNotification.getClass());
		}

		PushNotificationModelImpl pushNotificationModelImpl = (PushNotificationModelImpl)pushNotification;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (pushNotification.getCreateDate() == null)) {
			if (serviceContext == null) {
				pushNotification.setCreateDate(now);
			}
			else {
				pushNotification.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!pushNotificationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pushNotification.setModifiedDate(now);
			}
			else {
				pushNotification.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (pushNotification.isNew()) {
				session.save(pushNotification);

				pushNotification.setNew(false);
			}
			else {
				pushNotification = (PushNotification)session.merge(pushNotification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
			PushNotificationImpl.class, pushNotification.getPrimaryKey(),
			pushNotification, false);

		pushNotification.resetOriginalValues();

		return pushNotification;
	}

	/**
	 * Returns the push notification with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the push notification
	 * @return the push notification
	 * @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	 */
	@Override
	public PushNotification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPushNotificationException {
		PushNotification pushNotification = fetchByPrimaryKey(primaryKey);

		if (pushNotification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPushNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pushNotification;
	}

	/**
	 * Returns the push notification with the primary key or throws a {@link NoSuchPushNotificationException} if it could not be found.
	 *
	 * @param pushNotificationId the primary key of the push notification
	 * @return the push notification
	 * @throws NoSuchPushNotificationException if a push notification with the primary key could not be found
	 */
	@Override
	public PushNotification findByPrimaryKey(long pushNotificationId)
		throws NoSuchPushNotificationException {
		return findByPrimaryKey((Serializable)pushNotificationId);
	}

	/**
	 * Returns the push notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the push notification
	 * @return the push notification, or <code>null</code> if a push notification with the primary key could not be found
	 */
	@Override
	public PushNotification fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
				PushNotificationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PushNotification pushNotification = (PushNotification)serializable;

		if (pushNotification == null) {
			Session session = null;

			try {
				session = openSession();

				pushNotification = (PushNotification)session.get(PushNotificationImpl.class,
						primaryKey);

				if (pushNotification != null) {
					cacheResult(pushNotification);
				}
				else {
					entityCache.putResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
						PushNotificationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
					PushNotificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pushNotification;
	}

	/**
	 * Returns the push notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pushNotificationId the primary key of the push notification
	 * @return the push notification, or <code>null</code> if a push notification with the primary key could not be found
	 */
	@Override
	public PushNotification fetchByPrimaryKey(long pushNotificationId) {
		return fetchByPrimaryKey((Serializable)pushNotificationId);
	}

	@Override
	public Map<Serializable, PushNotification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PushNotification> map = new HashMap<Serializable, PushNotification>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PushNotification pushNotification = fetchByPrimaryKey(primaryKey);

			if (pushNotification != null) {
				map.put(primaryKey, pushNotification);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
					PushNotificationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PushNotification)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PUSHNOTIFICATION_WHERE_PKS_IN);

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

			for (PushNotification pushNotification : (List<PushNotification>)q.list()) {
				map.put(pushNotification.getPrimaryKeyObj(), pushNotification);

				cacheResult(pushNotification);

				uncachedPrimaryKeys.remove(pushNotification.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PushNotificationModelImpl.ENTITY_CACHE_ENABLED,
					PushNotificationImpl.class, primaryKey, nullModel);
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
	 * Returns all the push notifications.
	 *
	 * @return the push notifications
	 */
	@Override
	public List<PushNotification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the push notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of push notifications
	 * @param end the upper bound of the range of push notifications (not inclusive)
	 * @return the range of push notifications
	 */
	@Override
	public List<PushNotification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the push notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of push notifications
	 * @param end the upper bound of the range of push notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of push notifications
	 */
	@Override
	public List<PushNotification> findAll(int start, int end,
		OrderByComparator<PushNotification> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the push notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of push notifications
	 * @param end the upper bound of the range of push notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of push notifications
	 */
	@Override
	public List<PushNotification> findAll(int start, int end,
		OrderByComparator<PushNotification> orderByComparator,
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

		List<PushNotification> list = null;

		if (retrieveFromCache) {
			list = (List<PushNotification>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PUSHNOTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUSHNOTIFICATION;

				if (pagination) {
					sql = sql.concat(PushNotificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PushNotification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PushNotification>)QueryUtil.list(q,
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
	 * Removes all the push notifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PushNotification pushNotification : findAll()) {
			remove(pushNotification);
		}
	}

	/**
	 * Returns the number of push notifications.
	 *
	 * @return the number of push notifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PUSHNOTIFICATION);

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
		return PushNotificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the push notification persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PushNotificationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PUSHNOTIFICATION = "SELECT pushNotification FROM PushNotification pushNotification";
	private static final String _SQL_SELECT_PUSHNOTIFICATION_WHERE_PKS_IN = "SELECT pushNotification FROM PushNotification pushNotification WHERE pushNotificationId IN (";
	private static final String _SQL_COUNT_PUSHNOTIFICATION = "SELECT COUNT(pushNotification) FROM PushNotification pushNotification";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pushNotification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PushNotification exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PushNotificationPersistenceImpl.class);
}