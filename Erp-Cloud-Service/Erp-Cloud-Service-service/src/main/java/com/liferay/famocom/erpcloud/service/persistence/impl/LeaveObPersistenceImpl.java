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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveObException;
import com.liferay.famocom.erpcloud.model.LeaveOb;
import com.liferay.famocom.erpcloud.model.impl.LeaveObImpl;
import com.liferay.famocom.erpcloud.model.impl.LeaveObModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.LeaveObPersistence;

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
import java.util.Set;

/**
 * The persistence implementation for the leave ob service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveObPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.LeaveObUtil
 * @generated
 */
@ProviderType
public class LeaveObPersistenceImpl extends BasePersistenceImpl<LeaveOb>
	implements LeaveObPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveObUtil} to access the leave ob persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveObImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObModelImpl.FINDER_CACHE_ENABLED, LeaveObImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObModelImpl.FINDER_CACHE_ENABLED, LeaveObImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_OPENINGBALANCE = new FinderPath(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObModelImpl.FINDER_CACHE_ENABLED, LeaveObImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByopeningBalance",
			new String[] { Long.class.getName(), Long.class.getName() },
			LeaveObModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			LeaveObModelImpl.LEAVETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPENINGBALANCE = new FinderPath(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByopeningBalance",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or throws a {@link NoSuchLeaveObException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave ob
	 * @throws NoSuchLeaveObException if a matching leave ob could not be found
	 */
	@Override
	public LeaveOb findByopeningBalance(long employeeId, long leaveTypeId)
		throws NoSuchLeaveObException {
		LeaveOb leaveOb = fetchByopeningBalance(employeeId, leaveTypeId);

		if (leaveOb == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", leaveTypeId=");
			msg.append(leaveTypeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLeaveObException(msg.toString());
		}

		return leaveOb;
	}

	/**
	 * Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeId the leave type ID
	 * @return the matching leave ob, or <code>null</code> if a matching leave ob could not be found
	 */
	@Override
	public LeaveOb fetchByopeningBalance(long employeeId, long leaveTypeId) {
		return fetchByopeningBalance(employeeId, leaveTypeId, true);
	}

	/**
	 * Returns the leave ob where employeeId = &#63; and leaveTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeId the leave type ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching leave ob, or <code>null</code> if a matching leave ob could not be found
	 */
	@Override
	public LeaveOb fetchByopeningBalance(long employeeId, long leaveTypeId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, leaveTypeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE,
					finderArgs, this);
		}

		if (result instanceof LeaveOb) {
			LeaveOb leaveOb = (LeaveOb)result;

			if ((employeeId != leaveOb.getEmployeeId()) ||
					(leaveTypeId != leaveOb.getLeaveTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEAVEOB_WHERE);

			query.append(_FINDER_COLUMN_OPENINGBALANCE_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_OPENINGBALANCE_LEAVETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(leaveTypeId);

				List<LeaveOb> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LeaveObPersistenceImpl.fetchByopeningBalance(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LeaveOb leaveOb = list.get(0);

					result = leaveOb;

					cacheResult(leaveOb);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE,
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
			return (LeaveOb)result;
		}
	}

	/**
	 * Removes the leave ob where employeeId = &#63; and leaveTypeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeId the leave type ID
	 * @return the leave ob that was removed
	 */
	@Override
	public LeaveOb removeByopeningBalance(long employeeId, long leaveTypeId)
		throws NoSuchLeaveObException {
		LeaveOb leaveOb = findByopeningBalance(employeeId, leaveTypeId);

		return remove(leaveOb);
	}

	/**
	 * Returns the number of leave obs where employeeId = &#63; and leaveTypeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param leaveTypeId the leave type ID
	 * @return the number of matching leave obs
	 */
	@Override
	public int countByopeningBalance(long employeeId, long leaveTypeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPENINGBALANCE;

		Object[] finderArgs = new Object[] { employeeId, leaveTypeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEAVEOB_WHERE);

			query.append(_FINDER_COLUMN_OPENINGBALANCE_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_OPENINGBALANCE_LEAVETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				qPos.add(leaveTypeId);

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

	private static final String _FINDER_COLUMN_OPENINGBALANCE_EMPLOYEEID_2 = "leaveOb.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_OPENINGBALANCE_LEAVETYPEID_2 = "leaveOb.leaveTypeId = ?";

	public LeaveObPersistenceImpl() {
		setModelClass(LeaveOb.class);
	}

	/**
	 * Caches the leave ob in the entity cache if it is enabled.
	 *
	 * @param leaveOb the leave ob
	 */
	@Override
	public void cacheResult(LeaveOb leaveOb) {
		entityCache.putResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObImpl.class, leaveOb.getPrimaryKey(), leaveOb);

		finderCache.putResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE,
			new Object[] { leaveOb.getEmployeeId(), leaveOb.getLeaveTypeId() },
			leaveOb);

		leaveOb.resetOriginalValues();
	}

	/**
	 * Caches the leave obs in the entity cache if it is enabled.
	 *
	 * @param leaveObs the leave obs
	 */
	@Override
	public void cacheResult(List<LeaveOb> leaveObs) {
		for (LeaveOb leaveOb : leaveObs) {
			if (entityCache.getResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
						LeaveObImpl.class, leaveOb.getPrimaryKey()) == null) {
				cacheResult(leaveOb);
			}
			else {
				leaveOb.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave obs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveObImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave ob.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveOb leaveOb) {
		entityCache.removeResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObImpl.class, leaveOb.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LeaveObModelImpl)leaveOb, true);
	}

	@Override
	public void clearCache(List<LeaveOb> leaveObs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveOb leaveOb : leaveObs) {
			entityCache.removeResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
				LeaveObImpl.class, leaveOb.getPrimaryKey());

			clearUniqueFindersCache((LeaveObModelImpl)leaveOb, true);
		}
	}

	protected void cacheUniqueFindersCache(LeaveObModelImpl leaveObModelImpl) {
		Object[] args = new Object[] {
				leaveObModelImpl.getEmployeeId(),
				leaveObModelImpl.getLeaveTypeId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_OPENINGBALANCE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE, args,
			leaveObModelImpl, false);
	}

	protected void clearUniqueFindersCache(LeaveObModelImpl leaveObModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					leaveObModelImpl.getEmployeeId(),
					leaveObModelImpl.getLeaveTypeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENINGBALANCE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE, args);
		}

		if ((leaveObModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OPENINGBALANCE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					leaveObModelImpl.getOriginalEmployeeId(),
					leaveObModelImpl.getOriginalLeaveTypeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_OPENINGBALANCE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_OPENINGBALANCE, args);
		}
	}

	/**
	 * Creates a new leave ob with the primary key. Does not add the leave ob to the database.
	 *
	 * @param leaveobId the primary key for the new leave ob
	 * @return the new leave ob
	 */
	@Override
	public LeaveOb create(long leaveobId) {
		LeaveOb leaveOb = new LeaveObImpl();

		leaveOb.setNew(true);
		leaveOb.setPrimaryKey(leaveobId);

		return leaveOb;
	}

	/**
	 * Removes the leave ob with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveobId the primary key of the leave ob
	 * @return the leave ob that was removed
	 * @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	 */
	@Override
	public LeaveOb remove(long leaveobId) throws NoSuchLeaveObException {
		return remove((Serializable)leaveobId);
	}

	/**
	 * Removes the leave ob with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave ob
	 * @return the leave ob that was removed
	 * @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	 */
	@Override
	public LeaveOb remove(Serializable primaryKey)
		throws NoSuchLeaveObException {
		Session session = null;

		try {
			session = openSession();

			LeaveOb leaveOb = (LeaveOb)session.get(LeaveObImpl.class, primaryKey);

			if (leaveOb == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveObException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveOb);
		}
		catch (NoSuchLeaveObException nsee) {
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
	protected LeaveOb removeImpl(LeaveOb leaveOb) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveOb)) {
				leaveOb = (LeaveOb)session.get(LeaveObImpl.class,
						leaveOb.getPrimaryKeyObj());
			}

			if (leaveOb != null) {
				session.delete(leaveOb);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveOb != null) {
			clearCache(leaveOb);
		}

		return leaveOb;
	}

	@Override
	public LeaveOb updateImpl(LeaveOb leaveOb) {
		boolean isNew = leaveOb.isNew();

		if (!(leaveOb instanceof LeaveObModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leaveOb.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leaveOb);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leaveOb proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LeaveOb implementation " +
				leaveOb.getClass());
		}

		LeaveObModelImpl leaveObModelImpl = (LeaveObModelImpl)leaveOb;

		Session session = null;

		try {
			session = openSession();

			if (leaveOb.isNew()) {
				session.save(leaveOb);

				leaveOb.setNew(false);
			}
			else {
				leaveOb = (LeaveOb)session.merge(leaveOb);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LeaveObModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
			LeaveObImpl.class, leaveOb.getPrimaryKey(), leaveOb, false);

		clearUniqueFindersCache(leaveObModelImpl, false);
		cacheUniqueFindersCache(leaveObModelImpl);

		leaveOb.resetOriginalValues();

		return leaveOb;
	}

	/**
	 * Returns the leave ob with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave ob
	 * @return the leave ob
	 * @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	 */
	@Override
	public LeaveOb findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveObException {
		LeaveOb leaveOb = fetchByPrimaryKey(primaryKey);

		if (leaveOb == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveObException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveOb;
	}

	/**
	 * Returns the leave ob with the primary key or throws a {@link NoSuchLeaveObException} if it could not be found.
	 *
	 * @param leaveobId the primary key of the leave ob
	 * @return the leave ob
	 * @throws NoSuchLeaveObException if a leave ob with the primary key could not be found
	 */
	@Override
	public LeaveOb findByPrimaryKey(long leaveobId)
		throws NoSuchLeaveObException {
		return findByPrimaryKey((Serializable)leaveobId);
	}

	/**
	 * Returns the leave ob with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave ob
	 * @return the leave ob, or <code>null</code> if a leave ob with the primary key could not be found
	 */
	@Override
	public LeaveOb fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
				LeaveObImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveOb leaveOb = (LeaveOb)serializable;

		if (leaveOb == null) {
			Session session = null;

			try {
				session = openSession();

				leaveOb = (LeaveOb)session.get(LeaveObImpl.class, primaryKey);

				if (leaveOb != null) {
					cacheResult(leaveOb);
				}
				else {
					entityCache.putResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
						LeaveObImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
					LeaveObImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveOb;
	}

	/**
	 * Returns the leave ob with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveobId the primary key of the leave ob
	 * @return the leave ob, or <code>null</code> if a leave ob with the primary key could not be found
	 */
	@Override
	public LeaveOb fetchByPrimaryKey(long leaveobId) {
		return fetchByPrimaryKey((Serializable)leaveobId);
	}

	@Override
	public Map<Serializable, LeaveOb> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveOb> map = new HashMap<Serializable, LeaveOb>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveOb leaveOb = fetchByPrimaryKey(primaryKey);

			if (leaveOb != null) {
				map.put(primaryKey, leaveOb);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
					LeaveObImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveOb)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVEOB_WHERE_PKS_IN);

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

			for (LeaveOb leaveOb : (List<LeaveOb>)q.list()) {
				map.put(leaveOb.getPrimaryKeyObj(), leaveOb);

				cacheResult(leaveOb);

				uncachedPrimaryKeys.remove(leaveOb.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveObModelImpl.ENTITY_CACHE_ENABLED,
					LeaveObImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave obs.
	 *
	 * @return the leave obs
	 */
	@Override
	public List<LeaveOb> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave obs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave obs
	 * @param end the upper bound of the range of leave obs (not inclusive)
	 * @return the range of leave obs
	 */
	@Override
	public List<LeaveOb> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave obs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave obs
	 * @param end the upper bound of the range of leave obs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave obs
	 */
	@Override
	public List<LeaveOb> findAll(int start, int end,
		OrderByComparator<LeaveOb> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave obs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveObModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave obs
	 * @param end the upper bound of the range of leave obs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave obs
	 */
	@Override
	public List<LeaveOb> findAll(int start, int end,
		OrderByComparator<LeaveOb> orderByComparator, boolean retrieveFromCache) {
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

		List<LeaveOb> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveOb>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVEOB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEOB;

				if (pagination) {
					sql = sql.concat(LeaveObModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveOb>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveOb>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave obs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveOb leaveOb : findAll()) {
			remove(leaveOb);
		}
	}

	/**
	 * Returns the number of leave obs.
	 *
	 * @return the number of leave obs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVEOB);

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
		return LeaveObModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave ob persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveObImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LEAVEOB = "SELECT leaveOb FROM LeaveOb leaveOb";
	private static final String _SQL_SELECT_LEAVEOB_WHERE_PKS_IN = "SELECT leaveOb FROM LeaveOb leaveOb WHERE leaveobId IN (";
	private static final String _SQL_SELECT_LEAVEOB_WHERE = "SELECT leaveOb FROM LeaveOb leaveOb WHERE ";
	private static final String _SQL_COUNT_LEAVEOB = "SELECT COUNT(leaveOb) FROM LeaveOb leaveOb";
	private static final String _SQL_COUNT_LEAVEOB_WHERE = "SELECT COUNT(leaveOb) FROM LeaveOb leaveOb WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveOb.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveOb exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LeaveOb exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LeaveObPersistenceImpl.class);
}