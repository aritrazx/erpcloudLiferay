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

import com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException;
import com.liferay.famocom.erpcloud.model.FinSalary;
import com.liferay.famocom.erpcloud.model.impl.FinSalaryImpl;
import com.liferay.famocom.erpcloud.model.impl.FinSalaryModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.FinSalaryPersistence;

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
 * The persistence implementation for the fin salary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see FinSalaryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.FinSalaryUtil
 * @generated
 */
@ProviderType
public class FinSalaryPersistenceImpl extends BasePersistenceImpl<FinSalary>
	implements FinSalaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FinSalaryUtil} to access the fin salary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FinSalaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryModelImpl.FINDER_CACHE_ENABLED, FinSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryModelImpl.FINDER_CACHE_ENABLED, FinSalaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_MONTHYEAR = new FinderPath(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryModelImpl.FINDER_CACHE_ENABLED, FinSalaryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBymonthYear",
			new String[] { Long.class.getName() },
			FinSalaryModelImpl.MONTHYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHYEAR = new FinderPath(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymonthYear",
			new String[] { Long.class.getName() });

	/**
	 * Returns the fin salary where monthYear = &#63; or throws a {@link NoSuchFinSalaryException} if it could not be found.
	 *
	 * @param monthYear the month year
	 * @return the matching fin salary
	 * @throws NoSuchFinSalaryException if a matching fin salary could not be found
	 */
	@Override
	public FinSalary findBymonthYear(long monthYear)
		throws NoSuchFinSalaryException {
		FinSalary finSalary = fetchBymonthYear(monthYear);

		if (finSalary == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("monthYear=");
			msg.append(monthYear);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFinSalaryException(msg.toString());
		}

		return finSalary;
	}

	/**
	 * Returns the fin salary where monthYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param monthYear the month year
	 * @return the matching fin salary, or <code>null</code> if a matching fin salary could not be found
	 */
	@Override
	public FinSalary fetchBymonthYear(long monthYear) {
		return fetchBymonthYear(monthYear, true);
	}

	/**
	 * Returns the fin salary where monthYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param monthYear the month year
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching fin salary, or <code>null</code> if a matching fin salary could not be found
	 */
	@Override
	public FinSalary fetchBymonthYear(long monthYear, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { monthYear };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MONTHYEAR,
					finderArgs, this);
		}

		if (result instanceof FinSalary) {
			FinSalary finSalary = (FinSalary)result;

			if ((monthYear != finSalary.getMonthYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FINSALARY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

				List<FinSalary> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEAR,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"FinSalaryPersistenceImpl.fetchBymonthYear(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FinSalary finSalary = list.get(0);

					result = finSalary;

					cacheResult(finSalary);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEAR,
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
			return (FinSalary)result;
		}
	}

	/**
	 * Removes the fin salary where monthYear = &#63; from the database.
	 *
	 * @param monthYear the month year
	 * @return the fin salary that was removed
	 */
	@Override
	public FinSalary removeBymonthYear(long monthYear)
		throws NoSuchFinSalaryException {
		FinSalary finSalary = findBymonthYear(monthYear);

		return remove(finSalary);
	}

	/**
	 * Returns the number of fin salaries where monthYear = &#63;.
	 *
	 * @param monthYear the month year
	 * @return the number of matching fin salaries
	 */
	@Override
	public int countBymonthYear(long monthYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHYEAR;

		Object[] finderArgs = new Object[] { monthYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FINSALARY_WHERE);

			query.append(_FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(monthYear);

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

	private static final String _FINDER_COLUMN_MONTHYEAR_MONTHYEAR_2 = "finSalary.monthYear = ?";

	public FinSalaryPersistenceImpl() {
		setModelClass(FinSalary.class);
	}

	/**
	 * Caches the fin salary in the entity cache if it is enabled.
	 *
	 * @param finSalary the fin salary
	 */
	@Override
	public void cacheResult(FinSalary finSalary) {
		entityCache.putResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryImpl.class, finSalary.getPrimaryKey(), finSalary);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEAR,
			new Object[] { finSalary.getMonthYear() }, finSalary);

		finSalary.resetOriginalValues();
	}

	/**
	 * Caches the fin salaries in the entity cache if it is enabled.
	 *
	 * @param finSalaries the fin salaries
	 */
	@Override
	public void cacheResult(List<FinSalary> finSalaries) {
		for (FinSalary finSalary : finSalaries) {
			if (entityCache.getResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
						FinSalaryImpl.class, finSalary.getPrimaryKey()) == null) {
				cacheResult(finSalary);
			}
			else {
				finSalary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fin salaries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FinSalaryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fin salary.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FinSalary finSalary) {
		entityCache.removeResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryImpl.class, finSalary.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FinSalaryModelImpl)finSalary, true);
	}

	@Override
	public void clearCache(List<FinSalary> finSalaries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FinSalary finSalary : finSalaries) {
			entityCache.removeResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
				FinSalaryImpl.class, finSalary.getPrimaryKey());

			clearUniqueFindersCache((FinSalaryModelImpl)finSalary, true);
		}
	}

	protected void cacheUniqueFindersCache(
		FinSalaryModelImpl finSalaryModelImpl) {
		Object[] args = new Object[] { finSalaryModelImpl.getMonthYear() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MONTHYEAR, args,
			finSalaryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FinSalaryModelImpl finSalaryModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { finSalaryModelImpl.getMonthYear() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEAR, args);
		}

		if ((finSalaryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MONTHYEAR.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					finSalaryModelImpl.getOriginalMonthYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MONTHYEAR, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MONTHYEAR, args);
		}
	}

	/**
	 * Creates a new fin salary with the primary key. Does not add the fin salary to the database.
	 *
	 * @param finSalaryId the primary key for the new fin salary
	 * @return the new fin salary
	 */
	@Override
	public FinSalary create(long finSalaryId) {
		FinSalary finSalary = new FinSalaryImpl();

		finSalary.setNew(true);
		finSalary.setPrimaryKey(finSalaryId);

		return finSalary;
	}

	/**
	 * Removes the fin salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param finSalaryId the primary key of the fin salary
	 * @return the fin salary that was removed
	 * @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	 */
	@Override
	public FinSalary remove(long finSalaryId) throws NoSuchFinSalaryException {
		return remove((Serializable)finSalaryId);
	}

	/**
	 * Removes the fin salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fin salary
	 * @return the fin salary that was removed
	 * @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	 */
	@Override
	public FinSalary remove(Serializable primaryKey)
		throws NoSuchFinSalaryException {
		Session session = null;

		try {
			session = openSession();

			FinSalary finSalary = (FinSalary)session.get(FinSalaryImpl.class,
					primaryKey);

			if (finSalary == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFinSalaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(finSalary);
		}
		catch (NoSuchFinSalaryException nsee) {
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
	protected FinSalary removeImpl(FinSalary finSalary) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(finSalary)) {
				finSalary = (FinSalary)session.get(FinSalaryImpl.class,
						finSalary.getPrimaryKeyObj());
			}

			if (finSalary != null) {
				session.delete(finSalary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (finSalary != null) {
			clearCache(finSalary);
		}

		return finSalary;
	}

	@Override
	public FinSalary updateImpl(FinSalary finSalary) {
		boolean isNew = finSalary.isNew();

		if (!(finSalary instanceof FinSalaryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(finSalary.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(finSalary);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in finSalary proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FinSalary implementation " +
				finSalary.getClass());
		}

		FinSalaryModelImpl finSalaryModelImpl = (FinSalaryModelImpl)finSalary;

		Session session = null;

		try {
			session = openSession();

			if (finSalary.isNew()) {
				session.save(finSalary);

				finSalary.setNew(false);
			}
			else {
				finSalary = (FinSalary)session.merge(finSalary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FinSalaryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
			FinSalaryImpl.class, finSalary.getPrimaryKey(), finSalary, false);

		clearUniqueFindersCache(finSalaryModelImpl, false);
		cacheUniqueFindersCache(finSalaryModelImpl);

		finSalary.resetOriginalValues();

		return finSalary;
	}

	/**
	 * Returns the fin salary with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fin salary
	 * @return the fin salary
	 * @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	 */
	@Override
	public FinSalary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFinSalaryException {
		FinSalary finSalary = fetchByPrimaryKey(primaryKey);

		if (finSalary == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFinSalaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return finSalary;
	}

	/**
	 * Returns the fin salary with the primary key or throws a {@link NoSuchFinSalaryException} if it could not be found.
	 *
	 * @param finSalaryId the primary key of the fin salary
	 * @return the fin salary
	 * @throws NoSuchFinSalaryException if a fin salary with the primary key could not be found
	 */
	@Override
	public FinSalary findByPrimaryKey(long finSalaryId)
		throws NoSuchFinSalaryException {
		return findByPrimaryKey((Serializable)finSalaryId);
	}

	/**
	 * Returns the fin salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fin salary
	 * @return the fin salary, or <code>null</code> if a fin salary with the primary key could not be found
	 */
	@Override
	public FinSalary fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
				FinSalaryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FinSalary finSalary = (FinSalary)serializable;

		if (finSalary == null) {
			Session session = null;

			try {
				session = openSession();

				finSalary = (FinSalary)session.get(FinSalaryImpl.class,
						primaryKey);

				if (finSalary != null) {
					cacheResult(finSalary);
				}
				else {
					entityCache.putResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
						FinSalaryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
					FinSalaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return finSalary;
	}

	/**
	 * Returns the fin salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param finSalaryId the primary key of the fin salary
	 * @return the fin salary, or <code>null</code> if a fin salary with the primary key could not be found
	 */
	@Override
	public FinSalary fetchByPrimaryKey(long finSalaryId) {
		return fetchByPrimaryKey((Serializable)finSalaryId);
	}

	@Override
	public Map<Serializable, FinSalary> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FinSalary> map = new HashMap<Serializable, FinSalary>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FinSalary finSalary = fetchByPrimaryKey(primaryKey);

			if (finSalary != null) {
				map.put(primaryKey, finSalary);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
					FinSalaryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FinSalary)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FINSALARY_WHERE_PKS_IN);

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

			for (FinSalary finSalary : (List<FinSalary>)q.list()) {
				map.put(finSalary.getPrimaryKeyObj(), finSalary);

				cacheResult(finSalary);

				uncachedPrimaryKeys.remove(finSalary.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FinSalaryModelImpl.ENTITY_CACHE_ENABLED,
					FinSalaryImpl.class, primaryKey, nullModel);
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
	 * Returns all the fin salaries.
	 *
	 * @return the fin salaries
	 */
	@Override
	public List<FinSalary> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fin salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fin salaries
	 * @param end the upper bound of the range of fin salaries (not inclusive)
	 * @return the range of fin salaries
	 */
	@Override
	public List<FinSalary> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fin salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fin salaries
	 * @param end the upper bound of the range of fin salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fin salaries
	 */
	@Override
	public List<FinSalary> findAll(int start, int end,
		OrderByComparator<FinSalary> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fin salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FinSalaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fin salaries
	 * @param end the upper bound of the range of fin salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fin salaries
	 */
	@Override
	public List<FinSalary> findAll(int start, int end,
		OrderByComparator<FinSalary> orderByComparator,
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

		List<FinSalary> list = null;

		if (retrieveFromCache) {
			list = (List<FinSalary>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FINSALARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FINSALARY;

				if (pagination) {
					sql = sql.concat(FinSalaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FinSalary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FinSalary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fin salaries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FinSalary finSalary : findAll()) {
			remove(finSalary);
		}
	}

	/**
	 * Returns the number of fin salaries.
	 *
	 * @return the number of fin salaries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FINSALARY);

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
		return FinSalaryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fin salary persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FinSalaryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FINSALARY = "SELECT finSalary FROM FinSalary finSalary";
	private static final String _SQL_SELECT_FINSALARY_WHERE_PKS_IN = "SELECT finSalary FROM FinSalary finSalary WHERE finSalaryId IN (";
	private static final String _SQL_SELECT_FINSALARY_WHERE = "SELECT finSalary FROM FinSalary finSalary WHERE ";
	private static final String _SQL_COUNT_FINSALARY = "SELECT COUNT(finSalary) FROM FinSalary finSalary";
	private static final String _SQL_COUNT_FINSALARY_WHERE = "SELECT COUNT(finSalary) FROM FinSalary finSalary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "finSalary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FinSalary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FinSalary exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FinSalaryPersistenceImpl.class);
}