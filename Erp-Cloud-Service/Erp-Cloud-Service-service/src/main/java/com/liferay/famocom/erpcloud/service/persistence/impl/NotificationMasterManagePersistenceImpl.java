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

import com.liferay.famocom.erpcloud.exception.NoSuchNotificationMasterManageException;
import com.liferay.famocom.erpcloud.model.NotificationMasterManage;
import com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageImpl;
import com.liferay.famocom.erpcloud.model.impl.NotificationMasterManageModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.NotificationMasterManagePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the notification master manage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see NotificationMasterManagePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.NotificationMasterManageUtil
 * @generated
 */
@ProviderType
public class NotificationMasterManagePersistenceImpl extends BasePersistenceImpl<NotificationMasterManage>
	implements NotificationMasterManagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationMasterManageUtil} to access the notification master manage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationMasterManageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationMasterManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationMasterManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationMasterManageModelImpl.FINDER_CACHE_ENABLED,
			NotificationMasterManageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationMasterManageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NotificationMasterManagePersistenceImpl() {
		setModelClass(NotificationMasterManage.class);
	}

	/**
	 * Caches the notification master manage in the entity cache if it is enabled.
	 *
	 * @param notificationMasterManage the notification master manage
	 */
	@Override
	public void cacheResult(NotificationMasterManage notificationMasterManage) {
		entityCache.putResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationMasterManageImpl.class,
			notificationMasterManage.getPrimaryKey(), notificationMasterManage);

		notificationMasterManage.resetOriginalValues();
	}

	/**
	 * Caches the notification master manages in the entity cache if it is enabled.
	 *
	 * @param notificationMasterManages the notification master manages
	 */
	@Override
	public void cacheResult(
		List<NotificationMasterManage> notificationMasterManages) {
		for (NotificationMasterManage notificationMasterManage : notificationMasterManages) {
			if (entityCache.getResult(
						NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
						NotificationMasterManageImpl.class,
						notificationMasterManage.getPrimaryKey()) == null) {
				cacheResult(notificationMasterManage);
			}
			else {
				notificationMasterManage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notification master manages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotificationMasterManageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification master manage.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationMasterManage notificationMasterManage) {
		entityCache.removeResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationMasterManageImpl.class,
			notificationMasterManage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<NotificationMasterManage> notificationMasterManages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificationMasterManage notificationMasterManage : notificationMasterManages) {
			entityCache.removeResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
				NotificationMasterManageImpl.class,
				notificationMasterManage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notification master manage with the primary key. Does not add the notification master manage to the database.
	 *
	 * @param notifyId the primary key for the new notification master manage
	 * @return the new notification master manage
	 */
	@Override
	public NotificationMasterManage create(long notifyId) {
		NotificationMasterManage notificationMasterManage = new NotificationMasterManageImpl();

		notificationMasterManage.setNew(true);
		notificationMasterManage.setPrimaryKey(notifyId);

		return notificationMasterManage;
	}

	/**
	 * Removes the notification master manage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notifyId the primary key of the notification master manage
	 * @return the notification master manage that was removed
	 * @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	 */
	@Override
	public NotificationMasterManage remove(long notifyId)
		throws NoSuchNotificationMasterManageException {
		return remove((Serializable)notifyId);
	}

	/**
	 * Removes the notification master manage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification master manage
	 * @return the notification master manage that was removed
	 * @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	 */
	@Override
	public NotificationMasterManage remove(Serializable primaryKey)
		throws NoSuchNotificationMasterManageException {
		Session session = null;

		try {
			session = openSession();

			NotificationMasterManage notificationMasterManage = (NotificationMasterManage)session.get(NotificationMasterManageImpl.class,
					primaryKey);

			if (notificationMasterManage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationMasterManageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificationMasterManage);
		}
		catch (NoSuchNotificationMasterManageException nsee) {
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
	protected NotificationMasterManage removeImpl(
		NotificationMasterManage notificationMasterManage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificationMasterManage)) {
				notificationMasterManage = (NotificationMasterManage)session.get(NotificationMasterManageImpl.class,
						notificationMasterManage.getPrimaryKeyObj());
			}

			if (notificationMasterManage != null) {
				session.delete(notificationMasterManage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificationMasterManage != null) {
			clearCache(notificationMasterManage);
		}

		return notificationMasterManage;
	}

	@Override
	public NotificationMasterManage updateImpl(
		NotificationMasterManage notificationMasterManage) {
		boolean isNew = notificationMasterManage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (notificationMasterManage.isNew()) {
				session.save(notificationMasterManage);

				notificationMasterManage.setNew(false);
			}
			else {
				notificationMasterManage = (NotificationMasterManage)session.merge(notificationMasterManage);
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

		entityCache.putResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
			NotificationMasterManageImpl.class,
			notificationMasterManage.getPrimaryKey(), notificationMasterManage,
			false);

		notificationMasterManage.resetOriginalValues();

		return notificationMasterManage;
	}

	/**
	 * Returns the notification master manage with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification master manage
	 * @return the notification master manage
	 * @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	 */
	@Override
	public NotificationMasterManage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationMasterManageException {
		NotificationMasterManage notificationMasterManage = fetchByPrimaryKey(primaryKey);

		if (notificationMasterManage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationMasterManageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificationMasterManage;
	}

	/**
	 * Returns the notification master manage with the primary key or throws a {@link NoSuchNotificationMasterManageException} if it could not be found.
	 *
	 * @param notifyId the primary key of the notification master manage
	 * @return the notification master manage
	 * @throws NoSuchNotificationMasterManageException if a notification master manage with the primary key could not be found
	 */
	@Override
	public NotificationMasterManage findByPrimaryKey(long notifyId)
		throws NoSuchNotificationMasterManageException {
		return findByPrimaryKey((Serializable)notifyId);
	}

	/**
	 * Returns the notification master manage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification master manage
	 * @return the notification master manage, or <code>null</code> if a notification master manage with the primary key could not be found
	 */
	@Override
	public NotificationMasterManage fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
				NotificationMasterManageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		NotificationMasterManage notificationMasterManage = (NotificationMasterManage)serializable;

		if (notificationMasterManage == null) {
			Session session = null;

			try {
				session = openSession();

				notificationMasterManage = (NotificationMasterManage)session.get(NotificationMasterManageImpl.class,
						primaryKey);

				if (notificationMasterManage != null) {
					cacheResult(notificationMasterManage);
				}
				else {
					entityCache.putResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
						NotificationMasterManageImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
					NotificationMasterManageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificationMasterManage;
	}

	/**
	 * Returns the notification master manage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notifyId the primary key of the notification master manage
	 * @return the notification master manage, or <code>null</code> if a notification master manage with the primary key could not be found
	 */
	@Override
	public NotificationMasterManage fetchByPrimaryKey(long notifyId) {
		return fetchByPrimaryKey((Serializable)notifyId);
	}

	@Override
	public Map<Serializable, NotificationMasterManage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, NotificationMasterManage> map = new HashMap<Serializable, NotificationMasterManage>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			NotificationMasterManage notificationMasterManage = fetchByPrimaryKey(primaryKey);

			if (notificationMasterManage != null) {
				map.put(primaryKey, notificationMasterManage);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
					NotificationMasterManageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (NotificationMasterManage)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_NOTIFICATIONMASTERMANAGE_WHERE_PKS_IN);

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

			for (NotificationMasterManage notificationMasterManage : (List<NotificationMasterManage>)q.list()) {
				map.put(notificationMasterManage.getPrimaryKeyObj(),
					notificationMasterManage);

				cacheResult(notificationMasterManage);

				uncachedPrimaryKeys.remove(notificationMasterManage.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(NotificationMasterManageModelImpl.ENTITY_CACHE_ENABLED,
					NotificationMasterManageImpl.class, primaryKey, nullModel);
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
	 * Returns all the notification master manages.
	 *
	 * @return the notification master manages
	 */
	@Override
	public List<NotificationMasterManage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification master manages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification master manages
	 * @param end the upper bound of the range of notification master manages (not inclusive)
	 * @return the range of notification master manages
	 */
	@Override
	public List<NotificationMasterManage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification master manages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification master manages
	 * @param end the upper bound of the range of notification master manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notification master manages
	 */
	@Override
	public List<NotificationMasterManage> findAll(int start, int end,
		OrderByComparator<NotificationMasterManage> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notification master manages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationMasterManageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification master manages
	 * @param end the upper bound of the range of notification master manages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of notification master manages
	 */
	@Override
	public List<NotificationMasterManage> findAll(int start, int end,
		OrderByComparator<NotificationMasterManage> orderByComparator,
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

		List<NotificationMasterManage> list = null;

		if (retrieveFromCache) {
			list = (List<NotificationMasterManage>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NOTIFICATIONMASTERMANAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONMASTERMANAGE;

				if (pagination) {
					sql = sql.concat(NotificationMasterManageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificationMasterManage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NotificationMasterManage>)QueryUtil.list(q,
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
	 * Removes all the notification master manages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NotificationMasterManage notificationMasterManage : findAll()) {
			remove(notificationMasterManage);
		}
	}

	/**
	 * Returns the number of notification master manages.
	 *
	 * @return the number of notification master manages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATIONMASTERMANAGE);

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
		return NotificationMasterManageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notification master manage persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NotificationMasterManageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_NOTIFICATIONMASTERMANAGE = "SELECT notificationMasterManage FROM NotificationMasterManage notificationMasterManage";
	private static final String _SQL_SELECT_NOTIFICATIONMASTERMANAGE_WHERE_PKS_IN =
		"SELECT notificationMasterManage FROM NotificationMasterManage notificationMasterManage WHERE notifyId IN (";
	private static final String _SQL_COUNT_NOTIFICATIONMASTERMANAGE = "SELECT COUNT(notificationMasterManage) FROM NotificationMasterManage notificationMasterManage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationMasterManage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificationMasterManage exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(NotificationMasterManagePersistenceImpl.class);
}