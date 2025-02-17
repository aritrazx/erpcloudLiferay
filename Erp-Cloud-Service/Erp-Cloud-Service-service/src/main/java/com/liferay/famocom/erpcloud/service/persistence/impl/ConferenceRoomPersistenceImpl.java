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

import com.liferay.famocom.erpcloud.exception.NoSuchConferenceRoomException;
import com.liferay.famocom.erpcloud.model.ConferenceRoom;
import com.liferay.famocom.erpcloud.model.impl.ConferenceRoomImpl;
import com.liferay.famocom.erpcloud.model.impl.ConferenceRoomModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ConferenceRoomPersistence;

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
 * The persistence implementation for the conference room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ConferenceRoomPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ConferenceRoomUtil
 * @generated
 */
@ProviderType
public class ConferenceRoomPersistenceImpl extends BasePersistenceImpl<ConferenceRoom>
	implements ConferenceRoomPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConferenceRoomUtil} to access the conference room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConferenceRoomImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
			ConferenceRoomModelImpl.FINDER_CACHE_ENABLED,
			ConferenceRoomImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
			ConferenceRoomModelImpl.FINDER_CACHE_ENABLED,
			ConferenceRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
			ConferenceRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ConferenceRoomPersistenceImpl() {
		setModelClass(ConferenceRoom.class);
	}

	/**
	 * Caches the conference room in the entity cache if it is enabled.
	 *
	 * @param conferenceRoom the conference room
	 */
	@Override
	public void cacheResult(ConferenceRoom conferenceRoom) {
		entityCache.putResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
			ConferenceRoomImpl.class, conferenceRoom.getPrimaryKey(),
			conferenceRoom);

		conferenceRoom.resetOriginalValues();
	}

	/**
	 * Caches the conference rooms in the entity cache if it is enabled.
	 *
	 * @param conferenceRooms the conference rooms
	 */
	@Override
	public void cacheResult(List<ConferenceRoom> conferenceRooms) {
		for (ConferenceRoom conferenceRoom : conferenceRooms) {
			if (entityCache.getResult(
						ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
						ConferenceRoomImpl.class, conferenceRoom.getPrimaryKey()) == null) {
				cacheResult(conferenceRoom);
			}
			else {
				conferenceRoom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all conference rooms.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConferenceRoomImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the conference room.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConferenceRoom conferenceRoom) {
		entityCache.removeResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
			ConferenceRoomImpl.class, conferenceRoom.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ConferenceRoom> conferenceRooms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConferenceRoom conferenceRoom : conferenceRooms) {
			entityCache.removeResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
				ConferenceRoomImpl.class, conferenceRoom.getPrimaryKey());
		}
	}

	/**
	 * Creates a new conference room with the primary key. Does not add the conference room to the database.
	 *
	 * @param roomId the primary key for the new conference room
	 * @return the new conference room
	 */
	@Override
	public ConferenceRoom create(long roomId) {
		ConferenceRoom conferenceRoom = new ConferenceRoomImpl();

		conferenceRoom.setNew(true);
		conferenceRoom.setPrimaryKey(roomId);

		return conferenceRoom;
	}

	/**
	 * Removes the conference room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the conference room
	 * @return the conference room that was removed
	 * @throws NoSuchConferenceRoomException if a conference room with the primary key could not be found
	 */
	@Override
	public ConferenceRoom remove(long roomId)
		throws NoSuchConferenceRoomException {
		return remove((Serializable)roomId);
	}

	/**
	 * Removes the conference room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the conference room
	 * @return the conference room that was removed
	 * @throws NoSuchConferenceRoomException if a conference room with the primary key could not be found
	 */
	@Override
	public ConferenceRoom remove(Serializable primaryKey)
		throws NoSuchConferenceRoomException {
		Session session = null;

		try {
			session = openSession();

			ConferenceRoom conferenceRoom = (ConferenceRoom)session.get(ConferenceRoomImpl.class,
					primaryKey);

			if (conferenceRoom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConferenceRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(conferenceRoom);
		}
		catch (NoSuchConferenceRoomException nsee) {
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
	protected ConferenceRoom removeImpl(ConferenceRoom conferenceRoom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(conferenceRoom)) {
				conferenceRoom = (ConferenceRoom)session.get(ConferenceRoomImpl.class,
						conferenceRoom.getPrimaryKeyObj());
			}

			if (conferenceRoom != null) {
				session.delete(conferenceRoom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (conferenceRoom != null) {
			clearCache(conferenceRoom);
		}

		return conferenceRoom;
	}

	@Override
	public ConferenceRoom updateImpl(ConferenceRoom conferenceRoom) {
		boolean isNew = conferenceRoom.isNew();

		Session session = null;

		try {
			session = openSession();

			if (conferenceRoom.isNew()) {
				session.save(conferenceRoom);

				conferenceRoom.setNew(false);
			}
			else {
				conferenceRoom = (ConferenceRoom)session.merge(conferenceRoom);
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

		entityCache.putResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
			ConferenceRoomImpl.class, conferenceRoom.getPrimaryKey(),
			conferenceRoom, false);

		conferenceRoom.resetOriginalValues();

		return conferenceRoom;
	}

	/**
	 * Returns the conference room with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the conference room
	 * @return the conference room
	 * @throws NoSuchConferenceRoomException if a conference room with the primary key could not be found
	 */
	@Override
	public ConferenceRoom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConferenceRoomException {
		ConferenceRoom conferenceRoom = fetchByPrimaryKey(primaryKey);

		if (conferenceRoom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConferenceRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return conferenceRoom;
	}

	/**
	 * Returns the conference room with the primary key or throws a {@link NoSuchConferenceRoomException} if it could not be found.
	 *
	 * @param roomId the primary key of the conference room
	 * @return the conference room
	 * @throws NoSuchConferenceRoomException if a conference room with the primary key could not be found
	 */
	@Override
	public ConferenceRoom findByPrimaryKey(long roomId)
		throws NoSuchConferenceRoomException {
		return findByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns the conference room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the conference room
	 * @return the conference room, or <code>null</code> if a conference room with the primary key could not be found
	 */
	@Override
	public ConferenceRoom fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
				ConferenceRoomImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ConferenceRoom conferenceRoom = (ConferenceRoom)serializable;

		if (conferenceRoom == null) {
			Session session = null;

			try {
				session = openSession();

				conferenceRoom = (ConferenceRoom)session.get(ConferenceRoomImpl.class,
						primaryKey);

				if (conferenceRoom != null) {
					cacheResult(conferenceRoom);
				}
				else {
					entityCache.putResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
						ConferenceRoomImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
					ConferenceRoomImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return conferenceRoom;
	}

	/**
	 * Returns the conference room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the conference room
	 * @return the conference room, or <code>null</code> if a conference room with the primary key could not be found
	 */
	@Override
	public ConferenceRoom fetchByPrimaryKey(long roomId) {
		return fetchByPrimaryKey((Serializable)roomId);
	}

	@Override
	public Map<Serializable, ConferenceRoom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ConferenceRoom> map = new HashMap<Serializable, ConferenceRoom>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ConferenceRoom conferenceRoom = fetchByPrimaryKey(primaryKey);

			if (conferenceRoom != null) {
				map.put(primaryKey, conferenceRoom);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
					ConferenceRoomImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ConferenceRoom)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CONFERENCEROOM_WHERE_PKS_IN);

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

			for (ConferenceRoom conferenceRoom : (List<ConferenceRoom>)q.list()) {
				map.put(conferenceRoom.getPrimaryKeyObj(), conferenceRoom);

				cacheResult(conferenceRoom);

				uncachedPrimaryKeys.remove(conferenceRoom.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ConferenceRoomModelImpl.ENTITY_CACHE_ENABLED,
					ConferenceRoomImpl.class, primaryKey, nullModel);
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
	 * Returns all the conference rooms.
	 *
	 * @return the conference rooms
	 */
	@Override
	public List<ConferenceRoom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the conference rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of conference rooms
	 * @param end the upper bound of the range of conference rooms (not inclusive)
	 * @return the range of conference rooms
	 */
	@Override
	public List<ConferenceRoom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the conference rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of conference rooms
	 * @param end the upper bound of the range of conference rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of conference rooms
	 */
	@Override
	public List<ConferenceRoom> findAll(int start, int end,
		OrderByComparator<ConferenceRoom> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the conference rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ConferenceRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of conference rooms
	 * @param end the upper bound of the range of conference rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of conference rooms
	 */
	@Override
	public List<ConferenceRoom> findAll(int start, int end,
		OrderByComparator<ConferenceRoom> orderByComparator,
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

		List<ConferenceRoom> list = null;

		if (retrieveFromCache) {
			list = (List<ConferenceRoom>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CONFERENCEROOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONFERENCEROOM;

				if (pagination) {
					sql = sql.concat(ConferenceRoomModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConferenceRoom>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ConferenceRoom>)QueryUtil.list(q,
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
	 * Removes all the conference rooms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConferenceRoom conferenceRoom : findAll()) {
			remove(conferenceRoom);
		}
	}

	/**
	 * Returns the number of conference rooms.
	 *
	 * @return the number of conference rooms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONFERENCEROOM);

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
		return ConferenceRoomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the conference room persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ConferenceRoomImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CONFERENCEROOM = "SELECT conferenceRoom FROM ConferenceRoom conferenceRoom";
	private static final String _SQL_SELECT_CONFERENCEROOM_WHERE_PKS_IN = "SELECT conferenceRoom FROM ConferenceRoom conferenceRoom WHERE roomId IN (";
	private static final String _SQL_COUNT_CONFERENCEROOM = "SELECT COUNT(conferenceRoom) FROM ConferenceRoom conferenceRoom";
	private static final String _ORDER_BY_ENTITY_ALIAS = "conferenceRoom.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConferenceRoom exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ConferenceRoomPersistenceImpl.class);
}