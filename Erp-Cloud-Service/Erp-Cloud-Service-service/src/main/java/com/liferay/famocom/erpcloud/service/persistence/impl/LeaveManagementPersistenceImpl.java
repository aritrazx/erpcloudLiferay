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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveManagementException;
import com.liferay.famocom.erpcloud.model.LeaveManagement;
import com.liferay.famocom.erpcloud.model.impl.LeaveManagementImpl;
import com.liferay.famocom.erpcloud.model.impl.LeaveManagementModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.LeaveManagementPersistence;

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
 * The persistence implementation for the leave management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveManagementPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.LeaveManagementUtil
 * @generated
 */
@ProviderType
public class LeaveManagementPersistenceImpl extends BasePersistenceImpl<LeaveManagement>
	implements LeaveManagementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveManagementUtil} to access the leave management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveManagementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementModelImpl.FINDER_CACHE_ENABLED,
			LeaveManagementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementModelImpl.FINDER_CACHE_ENABLED,
			LeaveManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LEAVENAME = new FinderPath(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementModelImpl.FINDER_CACHE_ENABLED,
			LeaveManagementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByleaveName", new String[] { String.class.getName() },
			LeaveManagementModelImpl.LEAVENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEAVENAME = new FinderPath(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByleaveName",
			new String[] { String.class.getName() });

	/**
	 * Returns the leave management where leaveName = &#63; or throws a {@link NoSuchLeaveManagementException} if it could not be found.
	 *
	 * @param leaveName the leave name
	 * @return the matching leave management
	 * @throws NoSuchLeaveManagementException if a matching leave management could not be found
	 */
	@Override
	public LeaveManagement findByleaveName(String leaveName)
		throws NoSuchLeaveManagementException {
		LeaveManagement leaveManagement = fetchByleaveName(leaveName);

		if (leaveManagement == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("leaveName=");
			msg.append(leaveName);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLeaveManagementException(msg.toString());
		}

		return leaveManagement;
	}

	/**
	 * Returns the leave management where leaveName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param leaveName the leave name
	 * @return the matching leave management, or <code>null</code> if a matching leave management could not be found
	 */
	@Override
	public LeaveManagement fetchByleaveName(String leaveName) {
		return fetchByleaveName(leaveName, true);
	}

	/**
	 * Returns the leave management where leaveName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param leaveName the leave name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching leave management, or <code>null</code> if a matching leave management could not be found
	 */
	@Override
	public LeaveManagement fetchByleaveName(String leaveName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { leaveName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_LEAVENAME,
					finderArgs, this);
		}

		if (result instanceof LeaveManagement) {
			LeaveManagement leaveManagement = (LeaveManagement)result;

			if (!Objects.equals(leaveName, leaveManagement.getLeaveName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEAVEMANAGEMENT_WHERE);

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

				List<LeaveManagement> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_LEAVENAME,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LeaveManagementPersistenceImpl.fetchByleaveName(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveManagement leaveManagement = list.get(0);

					result = leaveManagement;

					cacheResult(leaveManagement);
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
			return (LeaveManagement)result;
		}
	}

	/**
	 * Removes the leave management where leaveName = &#63; from the database.
	 *
	 * @param leaveName the leave name
	 * @return the leave management that was removed
	 */
	@Override
	public LeaveManagement removeByleaveName(String leaveName)
		throws NoSuchLeaveManagementException {
		LeaveManagement leaveManagement = findByleaveName(leaveName);

		return remove(leaveManagement);
	}

	/**
	 * Returns the number of leave managements where leaveName = &#63;.
	 *
	 * @param leaveName the leave name
	 * @return the number of matching leave managements
	 */
	@Override
	public int countByleaveName(String leaveName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEAVENAME;

		Object[] finderArgs = new Object[] { leaveName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEAVEMANAGEMENT_WHERE);

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

	private static final String _FINDER_COLUMN_LEAVENAME_LEAVENAME_1 = "leaveManagement.leaveName IS NULL";
	private static final String _FINDER_COLUMN_LEAVENAME_LEAVENAME_2 = "leaveManagement.leaveName = ?";
	private static final String _FINDER_COLUMN_LEAVENAME_LEAVENAME_3 = "(leaveManagement.leaveName IS NULL OR leaveManagement.leaveName = '')";

	public LeaveManagementPersistenceImpl() {
		setModelClass(LeaveManagement.class);
	}

	/**
	 * Caches the leave management in the entity cache if it is enabled.
	 *
	 * @param leaveManagement the leave management
	 */
	@Override
	public void cacheResult(LeaveManagement leaveManagement) {
		entityCache.putResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementImpl.class, leaveManagement.getPrimaryKey(),
			leaveManagement);

		finderCache.putResult(FINDER_PATH_FETCH_BY_LEAVENAME,
			new Object[] { leaveManagement.getLeaveName() }, leaveManagement);

		leaveManagement.resetOriginalValues();
	}

	/**
	 * Caches the leave managements in the entity cache if it is enabled.
	 *
	 * @param leaveManagements the leave managements
	 */
	@Override
	public void cacheResult(List<LeaveManagement> leaveManagements) {
		for (LeaveManagement leaveManagement : leaveManagements) {
			if (entityCache.getResult(
						LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
						LeaveManagementImpl.class,
						leaveManagement.getPrimaryKey()) == null) {
				cacheResult(leaveManagement);
			}
			else {
				leaveManagement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave managements.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveManagementImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave management.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveManagement leaveManagement) {
		entityCache.removeResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementImpl.class, leaveManagement.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LeaveManagementModelImpl)leaveManagement, true);
	}

	@Override
	public void clearCache(List<LeaveManagement> leaveManagements) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveManagement leaveManagement : leaveManagements) {
			entityCache.removeResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
				LeaveManagementImpl.class, leaveManagement.getPrimaryKey());

			clearUniqueFindersCache((LeaveManagementModelImpl)leaveManagement,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		LeaveManagementModelImpl leaveManagementModelImpl) {
		Object[] args = new Object[] { leaveManagementModelImpl.getLeaveName() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_LEAVENAME, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_LEAVENAME, args,
			leaveManagementModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LeaveManagementModelImpl leaveManagementModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { leaveManagementModelImpl.getLeaveName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVENAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LEAVENAME, args);
		}

		if ((leaveManagementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LEAVENAME.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					leaveManagementModelImpl.getOriginalLeaveName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LEAVENAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LEAVENAME, args);
		}
	}

	/**
	 * Creates a new leave management with the primary key. Does not add the leave management to the database.
	 *
	 * @param leaveId the primary key for the new leave management
	 * @return the new leave management
	 */
	@Override
	public LeaveManagement create(long leaveId) {
		LeaveManagement leaveManagement = new LeaveManagementImpl();

		leaveManagement.setNew(true);
		leaveManagement.setPrimaryKey(leaveId);

		leaveManagement.setCompanyId(companyProvider.getCompanyId());

		return leaveManagement;
	}

	/**
	 * Removes the leave management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveId the primary key of the leave management
	 * @return the leave management that was removed
	 * @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	 */
	@Override
	public LeaveManagement remove(long leaveId)
		throws NoSuchLeaveManagementException {
		return remove((Serializable)leaveId);
	}

	/**
	 * Removes the leave management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave management
	 * @return the leave management that was removed
	 * @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	 */
	@Override
	public LeaveManagement remove(Serializable primaryKey)
		throws NoSuchLeaveManagementException {
		Session session = null;

		try {
			session = openSession();

			LeaveManagement leaveManagement = (LeaveManagement)session.get(LeaveManagementImpl.class,
					primaryKey);

			if (leaveManagement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveManagement);
		}
		catch (NoSuchLeaveManagementException nsee) {
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
	protected LeaveManagement removeImpl(LeaveManagement leaveManagement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveManagement)) {
				leaveManagement = (LeaveManagement)session.get(LeaveManagementImpl.class,
						leaveManagement.getPrimaryKeyObj());
			}

			if (leaveManagement != null) {
				session.delete(leaveManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveManagement != null) {
			clearCache(leaveManagement);
		}

		return leaveManagement;
	}

	@Override
	public LeaveManagement updateImpl(LeaveManagement leaveManagement) {
		boolean isNew = leaveManagement.isNew();

		if (!(leaveManagement instanceof LeaveManagementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveManagement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leaveManagement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveManagement proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveManagement implementation " +
				leaveManagement.getClass());
		}

		LeaveManagementModelImpl leaveManagementModelImpl = (LeaveManagementModelImpl)leaveManagement;

		Session session = null;

		try {
			session = openSession();

			if (leaveManagement.isNew()) {
				session.save(leaveManagement);

				leaveManagement.setNew(false);
			}
			else {
				leaveManagement = (LeaveManagement)session.merge(leaveManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LeaveManagementModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
			LeaveManagementImpl.class, leaveManagement.getPrimaryKey(),
			leaveManagement, false);

		clearUniqueFindersCache(leaveManagementModelImpl, false);
		cacheUniqueFindersCache(leaveManagementModelImpl);

		leaveManagement.resetOriginalValues();

		return leaveManagement;
	}

	/**
	 * Returns the leave management with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave management
	 * @return the leave management
	 * @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	 */
	@Override
	public LeaveManagement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveManagementException {
		LeaveManagement leaveManagement = fetchByPrimaryKey(primaryKey);

		if (leaveManagement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveManagement;
	}

	/**
	 * Returns the leave management with the primary key or throws a {@link NoSuchLeaveManagementException} if it could not be found.
	 *
	 * @param leaveId the primary key of the leave management
	 * @return the leave management
	 * @throws NoSuchLeaveManagementException if a leave management with the primary key could not be found
	 */
	@Override
	public LeaveManagement findByPrimaryKey(long leaveId)
		throws NoSuchLeaveManagementException {
		return findByPrimaryKey((Serializable)leaveId);
	}

	/**
	 * Returns the leave management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave management
	 * @return the leave management, or <code>null</code> if a leave management with the primary key could not be found
	 */
	@Override
	public LeaveManagement fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
				LeaveManagementImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveManagement leaveManagement = (LeaveManagement)serializable;

		if (leaveManagement == null) {
			Session session = null;

			try {
				session = openSession();

				leaveManagement = (LeaveManagement)session.get(LeaveManagementImpl.class,
						primaryKey);

				if (leaveManagement != null) {
					cacheResult(leaveManagement);
				}
				else {
					entityCache.putResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
						LeaveManagementImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
					LeaveManagementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveManagement;
	}

	/**
	 * Returns the leave management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveId the primary key of the leave management
	 * @return the leave management, or <code>null</code> if a leave management with the primary key could not be found
	 */
	@Override
	public LeaveManagement fetchByPrimaryKey(long leaveId) {
		return fetchByPrimaryKey((Serializable)leaveId);
	}

	@Override
	public Map<Serializable, LeaveManagement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveManagement> map = new HashMap<Serializable, LeaveManagement>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveManagement leaveManagement = fetchByPrimaryKey(primaryKey);

			if (leaveManagement != null) {
				map.put(primaryKey, leaveManagement);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
					LeaveManagementImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveManagement)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVEMANAGEMENT_WHERE_PKS_IN);

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

			for (LeaveManagement leaveManagement : (List<LeaveManagement>)q.list()) {
				map.put(leaveManagement.getPrimaryKeyObj(), leaveManagement);

				cacheResult(leaveManagement);

				uncachedPrimaryKeys.remove(leaveManagement.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveManagementModelImpl.ENTITY_CACHE_ENABLED,
					LeaveManagementImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave managements.
	 *
	 * @return the leave managements
	 */
	@Override
	public List<LeaveManagement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave managements
	 * @param end the upper bound of the range of leave managements (not inclusive)
	 * @return the range of leave managements
	 */
	@Override
	public List<LeaveManagement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave managements
	 * @param end the upper bound of the range of leave managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave managements
	 */
	@Override
	public List<LeaveManagement> findAll(int start, int end,
		OrderByComparator<LeaveManagement> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave managements
	 * @param end the upper bound of the range of leave managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave managements
	 */
	@Override
	public List<LeaveManagement> findAll(int start, int end,
		OrderByComparator<LeaveManagement> orderByComparator,
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

		List<LeaveManagement> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveManagement>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVEMANAGEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEMANAGEMENT;

				if (pagination) {
					sql = sql.concat(LeaveManagementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveManagement>)QueryUtil.list(q,
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
	 * Removes all the leave managements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveManagement leaveManagement : findAll()) {
			remove(leaveManagement);
		}
	}

	/**
	 * Returns the number of leave managements.
	 *
	 * @return the number of leave managements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVEMANAGEMENT);

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
		return LeaveManagementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave management persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveManagementImpl.class.getName());
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
	private static final String _SQL_SELECT_LEAVEMANAGEMENT = "SELECT leaveManagement FROM LeaveManagement leaveManagement";
	private static final String _SQL_SELECT_LEAVEMANAGEMENT_WHERE_PKS_IN = "SELECT leaveManagement FROM LeaveManagement leaveManagement WHERE leaveId IN (";
	private static final String _SQL_SELECT_LEAVEMANAGEMENT_WHERE = "SELECT leaveManagement FROM LeaveManagement leaveManagement WHERE ";
	private static final String _SQL_COUNT_LEAVEMANAGEMENT = "SELECT COUNT(leaveManagement) FROM LeaveManagement leaveManagement";
	private static final String _SQL_COUNT_LEAVEMANAGEMENT_WHERE = "SELECT COUNT(leaveManagement) FROM LeaveManagement leaveManagement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveManagement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveManagement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveManagement exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LeaveManagementPersistenceImpl.class);
}