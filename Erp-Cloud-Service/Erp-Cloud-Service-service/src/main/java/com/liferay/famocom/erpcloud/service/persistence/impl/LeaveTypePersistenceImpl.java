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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveTypeException;
import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.model.impl.LeaveTypeImpl;
import com.liferay.famocom.erpcloud.model.impl.LeaveTypeModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.LeaveTypePersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the leave type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveTypePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.LeaveTypeUtil
 * @generated
 */
@ProviderType
public class LeaveTypePersistenceImpl extends BasePersistenceImpl<LeaveType>
	implements LeaveTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveTypeUtil} to access the leave type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVENAME = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, LeaveTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByleaveName",
			new String[] { String.class.getName() },
			LeaveTypeModelImpl.LEAVENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVENAME = new FinderPath(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByleaveName",
			new String[] { String.class.getName() });

	/**
	 * Returns the leave type where leaveName = &#63; or throws a {@link NoSuchLeaveTypeException} if it could not be found.
	 *
	 * @param leaveName the leave name
	 * @return the matching leave type
	 * @throws NoSuchLeaveTypeException if a matching leave type could not be found
	 */
	@Override
	public LeaveType findByleaveName(String leaveName)
		throws NoSuchLeaveTypeException {
		LeaveType leaveType = fetchByleaveName(leaveName);

		if (leaveType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("leaveName=");
			msg.append(leaveName);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLeaveTypeException(msg.toString());
		}

		return leaveType;
	}

	/**
	 * Returns the leave type where leaveName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveName the leave name
	 * @return the matching leave type, or <code>null</code> if a matching leave type could not be found
	 */
	@Override
	public LeaveType fetchByleaveName(String leaveName) {
		return fetchByleaveName(leaveName, true);
	}

	/**
	 * Returns the leave type where leaveName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveName the leave name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching leave type, or <code>null</code> if a matching leave type could not be found
	 */
	@Override
	public LeaveType fetchByleaveName(String leaveName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { leaveName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_LEAVENAME,
					finderArgs, this);
		}

		if (result instanceof LeaveType) {
			LeaveType leaveType = (LeaveType)result;

			if (!Objects.equals(leaveName, leaveType.getLeaveName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEAVETYPE_WHERE);

			boolean bindLeaveName = false;

			if (leaveName == null) {
				query.append(_FINDER_COLUMN_LEAVENAME_LEAVENAME_1);
			}
			else if (leaveName.equals("")) {
				query.append(_FINDER_COLUMN_LEAVENAME_LEAVENAME_3);
			}
			else {
				bindLeaveName = true;

				query.append(_FINDER_COLUMN_LEAVENAME_LEAVENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveName) {
					qPos.add(leaveName);
				}

				List<LeaveType> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_LEAVENAME,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LeaveTypePersistenceImpl.fetchByleaveName(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveType leaveType = list.get(0);

					result = leaveType;

					cacheResult(leaveType);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_LEAVENAME,
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
			return (LeaveType)result;
		}
	}

	/**
	 * Removes the leave type where leaveName = &#63; from the database.
	 *
	 * @param leaveName the leave name
	 * @return the leave type that was removed
	 */
	@Override
	public LeaveType removeByleaveName(String leaveName)
		throws NoSuchLeaveTypeException {
		LeaveType leaveType = findByleaveName(leaveName);

		return remove(leaveType);
	}

	/**
	 * Returns the number of leave types where leaveName = &#63;.
	 *
	 * @param leaveName the leave name
	 * @return the number of matching leave types
	 */
	@Override
	public int countByleaveName(String leaveName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVENAME;

		Object[] finderArgs = new Object[] { leaveName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVETYPE_WHERE);

			boolean bindLeaveName = false;

			if (leaveName == null) {
				query.append(_FINDER_COLUMN_LEAVENAME_LEAVENAME_1);
			}
			else if (leaveName.equals("")) {
				query.append(_FINDER_COLUMN_LEAVENAME_LEAVENAME_3);
			}
			else {
				bindLeaveName = true;

				query.append(_FINDER_COLUMN_LEAVENAME_LEAVENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLeaveName) {
					qPos.add(leaveName);
				}

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

	private static final String _FINDER_COLUMN_LEAVENAME_LEAVENAME_1 = "leaveType.leaveName IS NULL";
	private static final String _FINDER_COLUMN_LEAVENAME_LEAVENAME_2 = "leaveType.leaveName = ?";
	private static final String _FINDER_COLUMN_LEAVENAME_LEAVENAME_3 = "(leaveType.leaveName IS NULL OR leaveType.leaveName = '')";

	public LeaveTypePersistenceImpl() {
		setModelClass(LeaveType.class);
	}

	/**
	 * Caches the leave type in the entity cache if it is enabled.
	 *
	 * @param leaveType the leave type
	 */
	@Override
	public void cacheResult(LeaveType leaveType) {
		entityCache.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeImpl.class, leaveType.getPrimaryKey(), leaveType);

		finderCache.putResult(FINDER_PATH_FETCH_BY_LEAVENAME,
			new Object[] { leaveType.getLeaveName() }, leaveType);

		leaveType.resetOriginalValues();
	}

	/**
	 * Caches the leave types in the entity cache if it is enabled.
	 *
	 * @param leaveTypes the leave types
	 */
	@Override
	public void cacheResult(List<LeaveType> leaveTypes) {
		for (LeaveType leaveType : leaveTypes) {
			if (entityCache.getResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeImpl.class, leaveType.getPrimaryKey()) == null) {
				cacheResult(leaveType);
			}
			else {
				leaveType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave types.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave type.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveType leaveType) {
		entityCache.removeResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeImpl.class, leaveType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LeaveTypeModelImpl)leaveType, true);
	}

	@Override
	public void clearCache(List<LeaveType> leaveTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveType leaveType : leaveTypes) {
			entityCache.removeResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeImpl.class, leaveType.getPrimaryKey());

			clearUniqueFindersCache((LeaveTypeModelImpl)leaveType, true);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveTypeModelImpl leaveTypeModelImpl) {
		Object[] args = new Object[] { leaveTypeModelImpl.getLeaveName() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_LEAVENAME, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_LEAVENAME, args,
			leaveTypeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LeaveTypeModelImpl leaveTypeModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { leaveTypeModelImpl.getLeaveName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVENAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LEAVENAME, args);
		}

		if ((leaveTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVENAME.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					leaveTypeModelImpl.getOriginalLeaveName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVENAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LEAVENAME, args);
		}
	}

	/**
	 * Creates a new leave type with the primary key. Does not add the leave type to the database.
	 *
	 * @param leaveTypeId the primary key for the new leave type
	 * @return the new leave type
	 */
	@Override
	public LeaveType create(long leaveTypeId) {
		LeaveType leaveType = new LeaveTypeImpl();

		leaveType.setNew(true);
		leaveType.setPrimaryKey(leaveTypeId);

		leaveType.setCompanyId(companyProvider.getCompanyId());

		return leaveType;
	}

	/**
	 * Removes the leave type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveTypeId the primary key of the leave type
	 * @return the leave type that was removed
	 * @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 */
	@Override
	public LeaveType remove(long leaveTypeId) throws NoSuchLeaveTypeException {
		return remove((Serializable)leaveTypeId);
	}

	/**
	 * Removes the leave type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave type
	 * @return the leave type that was removed
	 * @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 */
	@Override
	public LeaveType remove(Serializable primaryKey)
		throws NoSuchLeaveTypeException {
		Session session = null;

		try {
			session = openSession();

			LeaveType leaveType = (LeaveType)session.get(LeaveTypeImpl.class,
					primaryKey);

			if (leaveType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveType);
		}
		catch (NoSuchLeaveTypeException nsee) {
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
	protected LeaveType removeImpl(LeaveType leaveType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveType)) {
				leaveType = (LeaveType)session.get(LeaveTypeImpl.class,
						leaveType.getPrimaryKeyObj());
			}

			if (leaveType != null) {
				session.delete(leaveType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveType != null) {
			clearCache(leaveType);
		}

		return leaveType;
	}

	@Override
	public LeaveType updateImpl(LeaveType leaveType) {
		boolean isNew = leaveType.isNew();

		if (!(leaveType instanceof LeaveTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leaveType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveType proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveType implementation " +
				leaveType.getClass());
		}

		LeaveTypeModelImpl leaveTypeModelImpl = (LeaveTypeModelImpl)leaveType;

		Session session = null;

		try {
			session = openSession();

			if (leaveType.isNew()) {
				session.save(leaveType);

				leaveType.setNew(false);
			}
			else {
				leaveType = (LeaveType)session.merge(leaveType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LeaveTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
			LeaveTypeImpl.class, leaveType.getPrimaryKey(), leaveType, false);

		clearUniqueFindersCache(leaveTypeModelImpl, false);
		cacheUniqueFindersCache(leaveTypeModelImpl);

		leaveType.resetOriginalValues();

		return leaveType;
	}

	/**
	 * Returns the leave type with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type
	 * @return the leave type
	 * @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 */
	@Override
	public LeaveType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveTypeException {
		LeaveType leaveType = fetchByPrimaryKey(primaryKey);

		if (leaveType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveType;
	}

	/**
	 * Returns the leave type with the primary key or throws a {@link NoSuchLeaveTypeException} if it could not be found.
	 *
	 * @param leaveTypeId the primary key of the leave type
	 * @return the leave type
	 * @throws NoSuchLeaveTypeException if a leave type with the primary key could not be found
	 */
	@Override
	public LeaveType findByPrimaryKey(long leaveTypeId)
		throws NoSuchLeaveTypeException {
		return findByPrimaryKey((Serializable)leaveTypeId);
	}

	/**
	 * Returns the leave type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave type
	 * @return the leave type, or <code>null</code> if a leave type with the primary key could not be found
	 */
	@Override
	public LeaveType fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
				LeaveTypeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveType leaveType = (LeaveType)serializable;

		if (leaveType == null) {
			Session session = null;

			try {
				session = openSession();

				leaveType = (LeaveType)session.get(LeaveTypeImpl.class,
						primaryKey);

				if (leaveType != null) {
					cacheResult(leaveType);
				}
				else {
					entityCache.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
						LeaveTypeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
					LeaveTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveType;
	}

	/**
	 * Returns the leave type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveTypeId the primary key of the leave type
	 * @return the leave type, or <code>null</code> if a leave type with the primary key could not be found
	 */
	@Override
	public LeaveType fetchByPrimaryKey(long leaveTypeId) {
		return fetchByPrimaryKey((Serializable)leaveTypeId);
	}

	@Override
	public Map<Serializable, LeaveType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveType> map = new HashMap<Serializable, LeaveType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveType leaveType = fetchByPrimaryKey(primaryKey);

			if (leaveType != null) {
				map.put(primaryKey, leaveType);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
					LeaveTypeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveType)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVETYPE_WHERE_PKS_IN);

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

			for (LeaveType leaveType : (List<LeaveType>)q.list()) {
				map.put(leaveType.getPrimaryKeyObj(), leaveType);

				cacheResult(leaveType);

				uncachedPrimaryKeys.remove(leaveType.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveTypeModelImpl.ENTITY_CACHE_ENABLED,
					LeaveTypeImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave types.
	 *
	 * @return the leave types
	 */
	@Override
	public List<LeaveType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @return the range of leave types
	 */
	@Override
	public List<LeaveType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave types
	 */
	@Override
	public List<LeaveType> findAll(int start, int end,
		OrderByComparator<LeaveType> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave types
	 * @param end the upper bound of the range of leave types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave types
	 */
	@Override
	public List<LeaveType> findAll(int start, int end,
		OrderByComparator<LeaveType> orderByComparator,
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

		List<LeaveType> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveType>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVETYPE;

				if (pagination) {
					sql = sql.concat(LeaveTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveType leaveType : findAll()) {
			remove(leaveType);
		}
	}

	/**
	 * Returns the number of leave types.
	 *
	 * @return the number of leave types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVETYPE);

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
		return LeaveTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave type persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveTypeImpl.class.getName());
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
	private static final String _SQL_SELECT_LEAVETYPE = "SELECT leaveType FROM LeaveType leaveType";
	private static final String _SQL_SELECT_LEAVETYPE_WHERE_PKS_IN = "SELECT leaveType FROM LeaveType leaveType WHERE leaveTypeId IN (";
	private static final String _SQL_SELECT_LEAVETYPE_WHERE = "SELECT leaveType FROM LeaveType leaveType WHERE ";
	private static final String _SQL_COUNT_LEAVETYPE = "SELECT COUNT(leaveType) FROM LeaveType leaveType";
	private static final String _SQL_COUNT_LEAVETYPE_WHERE = "SELECT COUNT(leaveType) FROM LeaveType leaveType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveType exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LeaveTypePersistenceImpl.class);
}