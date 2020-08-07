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

import com.liferay.famocom.erpcloud.exception.NoSuchBookingRoomException;
import com.liferay.famocom.erpcloud.model.BookingRoom;
import com.liferay.famocom.erpcloud.model.impl.BookingRoomImpl;
import com.liferay.famocom.erpcloud.model.impl.BookingRoomModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.BookingRoomPersistence;

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
 * The persistence implementation for the booking room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BookingRoomPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.BookingRoomUtil
 * @generated
 */
@ProviderType
public class BookingRoomPersistenceImpl extends BasePersistenceImpl<BookingRoom>
	implements BookingRoomPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookingRoomUtil} to access the booking room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookingRoomImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomModelImpl.FINDER_CACHE_ENABLED, BookingRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomModelImpl.FINDER_CACHE_ENABLED, BookingRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BookingRoomPersistenceImpl() {
		setModelClass(BookingRoom.class);
	}

	/**
	 * Caches the booking room in the entity cache if it is enabled.
	 *
	 * @param bookingRoom the booking room
	 */
	@Override
	public void cacheResult(BookingRoom bookingRoom) {
		entityCache.putResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomImpl.class, bookingRoom.getPrimaryKey(), bookingRoom);

		bookingRoom.resetOriginalValues();
	}

	/**
	 * Caches the booking rooms in the entity cache if it is enabled.
	 *
	 * @param bookingRooms the booking rooms
	 */
	@Override
	public void cacheResult(List<BookingRoom> bookingRooms) {
		for (BookingRoom bookingRoom : bookingRooms) {
			if (entityCache.getResult(
						BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
						BookingRoomImpl.class, bookingRoom.getPrimaryKey()) == null) {
				cacheResult(bookingRoom);
			}
			else {
				bookingRoom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all booking rooms.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookingRoomImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking room.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingRoom bookingRoom) {
		entityCache.removeResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomImpl.class, bookingRoom.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BookingRoom> bookingRooms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BookingRoom bookingRoom : bookingRooms) {
			entityCache.removeResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
				BookingRoomImpl.class, bookingRoom.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking room with the primary key. Does not add the booking room to the database.
	 *
	 * @param bookingId the primary key for the new booking room
	 * @return the new booking room
	 */
	@Override
	public BookingRoom create(long bookingId) {
		BookingRoom bookingRoom = new BookingRoomImpl();

		bookingRoom.setNew(true);
		bookingRoom.setPrimaryKey(bookingId);

		return bookingRoom;
	}

	/**
	 * Removes the booking room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the booking room
	 * @return the booking room that was removed
	 * @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	 */
	@Override
	public BookingRoom remove(long bookingId) throws NoSuchBookingRoomException {
		return remove((Serializable)bookingId);
	}

	/**
	 * Removes the booking room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking room
	 * @return the booking room that was removed
	 * @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	 */
	@Override
	public BookingRoom remove(Serializable primaryKey)
		throws NoSuchBookingRoomException {
		Session session = null;

		try {
			session = openSession();

			BookingRoom bookingRoom = (BookingRoom)session.get(BookingRoomImpl.class,
					primaryKey);

			if (bookingRoom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bookingRoom);
		}
		catch (NoSuchBookingRoomException nsee) {
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
	protected BookingRoom removeImpl(BookingRoom bookingRoom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookingRoom)) {
				bookingRoom = (BookingRoom)session.get(BookingRoomImpl.class,
						bookingRoom.getPrimaryKeyObj());
			}

			if (bookingRoom != null) {
				session.delete(bookingRoom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bookingRoom != null) {
			clearCache(bookingRoom);
		}

		return bookingRoom;
	}

	@Override
	public BookingRoom updateImpl(BookingRoom bookingRoom) {
		boolean isNew = bookingRoom.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bookingRoom.isNew()) {
				session.save(bookingRoom);

				bookingRoom.setNew(false);
			}
			else {
				bookingRoom = (BookingRoom)session.merge(bookingRoom);
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

		entityCache.putResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
			BookingRoomImpl.class, bookingRoom.getPrimaryKey(), bookingRoom,
			false);

		bookingRoom.resetOriginalValues();

		return bookingRoom;
	}

	/**
	 * Returns the booking room with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking room
	 * @return the booking room
	 * @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	 */
	@Override
	public BookingRoom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookingRoomException {
		BookingRoom bookingRoom = fetchByPrimaryKey(primaryKey);

		if (bookingRoom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookingRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bookingRoom;
	}

	/**
	 * Returns the booking room with the primary key or throws a {@link NoSuchBookingRoomException} if it could not be found.
	 *
	 * @param bookingId the primary key of the booking room
	 * @return the booking room
	 * @throws NoSuchBookingRoomException if a booking room with the primary key could not be found
	 */
	@Override
	public BookingRoom findByPrimaryKey(long bookingId)
		throws NoSuchBookingRoomException {
		return findByPrimaryKey((Serializable)bookingId);
	}

	/**
	 * Returns the booking room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking room
	 * @return the booking room, or <code>null</code> if a booking room with the primary key could not be found
	 */
	@Override
	public BookingRoom fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
				BookingRoomImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BookingRoom bookingRoom = (BookingRoom)serializable;

		if (bookingRoom == null) {
			Session session = null;

			try {
				session = openSession();

				bookingRoom = (BookingRoom)session.get(BookingRoomImpl.class,
						primaryKey);

				if (bookingRoom != null) {
					cacheResult(bookingRoom);
				}
				else {
					entityCache.putResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
						BookingRoomImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
					BookingRoomImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bookingRoom;
	}

	/**
	 * Returns the booking room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking room
	 * @return the booking room, or <code>null</code> if a booking room with the primary key could not be found
	 */
	@Override
	public BookingRoom fetchByPrimaryKey(long bookingId) {
		return fetchByPrimaryKey((Serializable)bookingId);
	}

	@Override
	public Map<Serializable, BookingRoom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BookingRoom> map = new HashMap<Serializable, BookingRoom>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BookingRoom bookingRoom = fetchByPrimaryKey(primaryKey);

			if (bookingRoom != null) {
				map.put(primaryKey, bookingRoom);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
					BookingRoomImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BookingRoom)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BOOKINGROOM_WHERE_PKS_IN);

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

			for (BookingRoom bookingRoom : (List<BookingRoom>)q.list()) {
				map.put(bookingRoom.getPrimaryKeyObj(), bookingRoom);

				cacheResult(bookingRoom);

				uncachedPrimaryKeys.remove(bookingRoom.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BookingRoomModelImpl.ENTITY_CACHE_ENABLED,
					BookingRoomImpl.class, primaryKey, nullModel);
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
	 * Returns all the booking rooms.
	 *
	 * @return the booking rooms
	 */
	@Override
	public List<BookingRoom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking rooms
	 * @param end the upper bound of the range of booking rooms (not inclusive)
	 * @return the range of booking rooms
	 */
	@Override
	public List<BookingRoom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking rooms
	 * @param end the upper bound of the range of booking rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking rooms
	 */
	@Override
	public List<BookingRoom> findAll(int start, int end,
		OrderByComparator<BookingRoom> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingRoomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking rooms
	 * @param end the upper bound of the range of booking rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of booking rooms
	 */
	@Override
	public List<BookingRoom> findAll(int start, int end,
		OrderByComparator<BookingRoom> orderByComparator,
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

		List<BookingRoom> list = null;

		if (retrieveFromCache) {
			list = (List<BookingRoom>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOOKINGROOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGROOM;

				if (pagination) {
					sql = sql.concat(BookingRoomModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BookingRoom>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BookingRoom>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the booking rooms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BookingRoom bookingRoom : findAll()) {
			remove(bookingRoom);
		}
	}

	/**
	 * Returns the number of booking rooms.
	 *
	 * @return the number of booking rooms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKINGROOM);

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
		return BookingRoomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the booking room persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BookingRoomImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BOOKINGROOM = "SELECT bookingRoom FROM BookingRoom bookingRoom";
	private static final String _SQL_SELECT_BOOKINGROOM_WHERE_PKS_IN = "SELECT bookingRoom FROM BookingRoom bookingRoom WHERE bookingId IN (";
	private static final String _SQL_COUNT_BOOKINGROOM = "SELECT COUNT(bookingRoom) FROM BookingRoom bookingRoom";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingRoom.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BookingRoom exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BookingRoomPersistenceImpl.class);
}