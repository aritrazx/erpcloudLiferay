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

import com.liferay.famocom.erpcloud.exception.NoSuchAttendanceCheckListException;
import com.liferay.famocom.erpcloud.model.AttendanceCheckList;
import com.liferay.famocom.erpcloud.model.impl.AttendanceCheckListImpl;
import com.liferay.famocom.erpcloud.model.impl.AttendanceCheckListModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AttendanceCheckListPersistence;

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
 * The persistence implementation for the attendance check list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AttendanceCheckListPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AttendanceCheckListUtil
 * @generated
 */
@ProviderType
public class AttendanceCheckListPersistenceImpl extends BasePersistenceImpl<AttendanceCheckList>
	implements AttendanceCheckListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AttendanceCheckListUtil} to access the attendance check list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AttendanceCheckListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceCheckListModelImpl.FINDER_CACHE_ENABLED,
			AttendanceCheckListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceCheckListModelImpl.FINDER_CACHE_ENABLED,
			AttendanceCheckListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceCheckListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AttendanceCheckListPersistenceImpl() {
		setModelClass(AttendanceCheckList.class);
	}

	/**
	 * Caches the attendance check list in the entity cache if it is enabled.
	 *
	 * @param attendanceCheckList the attendance check list
	 */
	@Override
	public void cacheResult(AttendanceCheckList attendanceCheckList) {
		entityCache.putResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceCheckListImpl.class, attendanceCheckList.getPrimaryKey(),
			attendanceCheckList);

		attendanceCheckList.resetOriginalValues();
	}

	/**
	 * Caches the attendance check lists in the entity cache if it is enabled.
	 *
	 * @param attendanceCheckLists the attendance check lists
	 */
	@Override
	public void cacheResult(List<AttendanceCheckList> attendanceCheckLists) {
		for (AttendanceCheckList attendanceCheckList : attendanceCheckLists) {
			if (entityCache.getResult(
						AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
						AttendanceCheckListImpl.class,
						attendanceCheckList.getPrimaryKey()) == null) {
				cacheResult(attendanceCheckList);
			}
			else {
				attendanceCheckList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all attendance check lists.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AttendanceCheckListImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the attendance check list.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AttendanceCheckList attendanceCheckList) {
		entityCache.removeResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceCheckListImpl.class, attendanceCheckList.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AttendanceCheckList> attendanceCheckLists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AttendanceCheckList attendanceCheckList : attendanceCheckLists) {
			entityCache.removeResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
				AttendanceCheckListImpl.class,
				attendanceCheckList.getPrimaryKey());
		}
	}

	/**
	 * Creates a new attendance check list with the primary key. Does not add the attendance check list to the database.
	 *
	 * @param attendanceCheckListId the primary key for the new attendance check list
	 * @return the new attendance check list
	 */
	@Override
	public AttendanceCheckList create(long attendanceCheckListId) {
		AttendanceCheckList attendanceCheckList = new AttendanceCheckListImpl();

		attendanceCheckList.setNew(true);
		attendanceCheckList.setPrimaryKey(attendanceCheckListId);

		return attendanceCheckList;
	}

	/**
	 * Removes the attendance check list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendanceCheckListId the primary key of the attendance check list
	 * @return the attendance check list that was removed
	 * @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	 */
	@Override
	public AttendanceCheckList remove(long attendanceCheckListId)
		throws NoSuchAttendanceCheckListException {
		return remove((Serializable)attendanceCheckListId);
	}

	/**
	 * Removes the attendance check list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the attendance check list
	 * @return the attendance check list that was removed
	 * @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	 */
	@Override
	public AttendanceCheckList remove(Serializable primaryKey)
		throws NoSuchAttendanceCheckListException {
		Session session = null;

		try {
			session = openSession();

			AttendanceCheckList attendanceCheckList = (AttendanceCheckList)session.get(AttendanceCheckListImpl.class,
					primaryKey);

			if (attendanceCheckList == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAttendanceCheckListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(attendanceCheckList);
		}
		catch (NoSuchAttendanceCheckListException nsee) {
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
	protected AttendanceCheckList removeImpl(
		AttendanceCheckList attendanceCheckList) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(attendanceCheckList)) {
				attendanceCheckList = (AttendanceCheckList)session.get(AttendanceCheckListImpl.class,
						attendanceCheckList.getPrimaryKeyObj());
			}

			if (attendanceCheckList != null) {
				session.delete(attendanceCheckList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (attendanceCheckList != null) {
			clearCache(attendanceCheckList);
		}

		return attendanceCheckList;
	}

	@Override
	public AttendanceCheckList updateImpl(
		AttendanceCheckList attendanceCheckList) {
		boolean isNew = attendanceCheckList.isNew();

		Session session = null;

		try {
			session = openSession();

			if (attendanceCheckList.isNew()) {
				session.save(attendanceCheckList);

				attendanceCheckList.setNew(false);
			}
			else {
				attendanceCheckList = (AttendanceCheckList)session.merge(attendanceCheckList);
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

		entityCache.putResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
			AttendanceCheckListImpl.class, attendanceCheckList.getPrimaryKey(),
			attendanceCheckList, false);

		attendanceCheckList.resetOriginalValues();

		return attendanceCheckList;
	}

	/**
	 * Returns the attendance check list with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendance check list
	 * @return the attendance check list
	 * @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	 */
	@Override
	public AttendanceCheckList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAttendanceCheckListException {
		AttendanceCheckList attendanceCheckList = fetchByPrimaryKey(primaryKey);

		if (attendanceCheckList == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAttendanceCheckListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return attendanceCheckList;
	}

	/**
	 * Returns the attendance check list with the primary key or throws a {@link NoSuchAttendanceCheckListException} if it could not be found.
	 *
	 * @param attendanceCheckListId the primary key of the attendance check list
	 * @return the attendance check list
	 * @throws NoSuchAttendanceCheckListException if a attendance check list with the primary key could not be found
	 */
	@Override
	public AttendanceCheckList findByPrimaryKey(long attendanceCheckListId)
		throws NoSuchAttendanceCheckListException {
		return findByPrimaryKey((Serializable)attendanceCheckListId);
	}

	/**
	 * Returns the attendance check list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the attendance check list
	 * @return the attendance check list, or <code>null</code> if a attendance check list with the primary key could not be found
	 */
	@Override
	public AttendanceCheckList fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
				AttendanceCheckListImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AttendanceCheckList attendanceCheckList = (AttendanceCheckList)serializable;

		if (attendanceCheckList == null) {
			Session session = null;

			try {
				session = openSession();

				attendanceCheckList = (AttendanceCheckList)session.get(AttendanceCheckListImpl.class,
						primaryKey);

				if (attendanceCheckList != null) {
					cacheResult(attendanceCheckList);
				}
				else {
					entityCache.putResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
						AttendanceCheckListImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceCheckListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return attendanceCheckList;
	}

	/**
	 * Returns the attendance check list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attendanceCheckListId the primary key of the attendance check list
	 * @return the attendance check list, or <code>null</code> if a attendance check list with the primary key could not be found
	 */
	@Override
	public AttendanceCheckList fetchByPrimaryKey(long attendanceCheckListId) {
		return fetchByPrimaryKey((Serializable)attendanceCheckListId);
	}

	@Override
	public Map<Serializable, AttendanceCheckList> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AttendanceCheckList> map = new HashMap<Serializable, AttendanceCheckList>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AttendanceCheckList attendanceCheckList = fetchByPrimaryKey(primaryKey);

			if (attendanceCheckList != null) {
				map.put(primaryKey, attendanceCheckList);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceCheckListImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AttendanceCheckList)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ATTENDANCECHECKLIST_WHERE_PKS_IN);

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

			for (AttendanceCheckList attendanceCheckList : (List<AttendanceCheckList>)q.list()) {
				map.put(attendanceCheckList.getPrimaryKeyObj(),
					attendanceCheckList);

				cacheResult(attendanceCheckList);

				uncachedPrimaryKeys.remove(attendanceCheckList.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AttendanceCheckListModelImpl.ENTITY_CACHE_ENABLED,
					AttendanceCheckListImpl.class, primaryKey, nullModel);
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
	 * Returns all the attendance check lists.
	 *
	 * @return the attendance check lists
	 */
	@Override
	public List<AttendanceCheckList> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the attendance check lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendance check lists
	 * @param end the upper bound of the range of attendance check lists (not inclusive)
	 * @return the range of attendance check lists
	 */
	@Override
	public List<AttendanceCheckList> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the attendance check lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendance check lists
	 * @param end the upper bound of the range of attendance check lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of attendance check lists
	 */
	@Override
	public List<AttendanceCheckList> findAll(int start, int end,
		OrderByComparator<AttendanceCheckList> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the attendance check lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AttendanceCheckListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendance check lists
	 * @param end the upper bound of the range of attendance check lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of attendance check lists
	 */
	@Override
	public List<AttendanceCheckList> findAll(int start, int end,
		OrderByComparator<AttendanceCheckList> orderByComparator,
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

		List<AttendanceCheckList> list = null;

		if (retrieveFromCache) {
			list = (List<AttendanceCheckList>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ATTENDANCECHECKLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ATTENDANCECHECKLIST;

				if (pagination) {
					sql = sql.concat(AttendanceCheckListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AttendanceCheckList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AttendanceCheckList>)QueryUtil.list(q,
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
	 * Removes all the attendance check lists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AttendanceCheckList attendanceCheckList : findAll()) {
			remove(attendanceCheckList);
		}
	}

	/**
	 * Returns the number of attendance check lists.
	 *
	 * @return the number of attendance check lists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ATTENDANCECHECKLIST);

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
		return AttendanceCheckListModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the attendance check list persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AttendanceCheckListImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ATTENDANCECHECKLIST = "SELECT attendanceCheckList FROM AttendanceCheckList attendanceCheckList";
	private static final String _SQL_SELECT_ATTENDANCECHECKLIST_WHERE_PKS_IN = "SELECT attendanceCheckList FROM AttendanceCheckList attendanceCheckList WHERE attendanceCheckListId IN (";
	private static final String _SQL_COUNT_ATTENDANCECHECKLIST = "SELECT COUNT(attendanceCheckList) FROM AttendanceCheckList attendanceCheckList";
	private static final String _ORDER_BY_ENTITY_ALIAS = "attendanceCheckList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AttendanceCheckList exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AttendanceCheckListPersistenceImpl.class);
}