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

import com.liferay.famocom.erpcloud.exception.NoSuchExpProofFilesException;
import com.liferay.famocom.erpcloud.model.ExpProofFiles;
import com.liferay.famocom.erpcloud.model.impl.ExpProofFilesImpl;
import com.liferay.famocom.erpcloud.model.impl.ExpProofFilesModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ExpProofFilesPersistence;

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
import java.util.Set;

/**
 * The persistence implementation for the exp proof files service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpProofFilesPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ExpProofFilesUtil
 * @generated
 */
@ProviderType
public class ExpProofFilesPersistenceImpl extends BasePersistenceImpl<ExpProofFiles>
	implements ExpProofFilesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpProofFilesUtil} to access the exp proof files persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpProofFilesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesModelImpl.FINDER_CACHE_ENABLED,
			ExpProofFilesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesModelImpl.FINDER_CACHE_ENABLED,
			ExpProofFilesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EXPENCEID = new FinderPath(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesModelImpl.FINDER_CACHE_ENABLED,
			ExpProofFilesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByExpenceId", new String[] { Long.class.getName() },
			ExpProofFilesModelImpl.EXPENSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXPENCEID = new FinderPath(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExpenceId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the exp proof files where expenseId = &#63; or throws a {@link NoSuchExpProofFilesException} if it could not be found.
	 *
	 * @param expenseId the expense ID
	 * @return the matching exp proof files
	 * @throws NoSuchExpProofFilesException if a matching exp proof files could not be found
	 */
	@Override
	public ExpProofFiles findByExpenceId(long expenseId)
		throws NoSuchExpProofFilesException {
		ExpProofFiles expProofFiles = fetchByExpenceId(expenseId);

		if (expProofFiles == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("expenseId=");
			msg.append(expenseId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchExpProofFilesException(msg.toString());
		}

		return expProofFiles;
	}

	/**
	 * Returns the exp proof files where expenseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param expenseId the expense ID
	 * @return the matching exp proof files, or <code>null</code> if a matching exp proof files could not be found
	 */
	@Override
	public ExpProofFiles fetchByExpenceId(long expenseId) {
		return fetchByExpenceId(expenseId, true);
	}

	/**
	 * Returns the exp proof files where expenseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param expenseId the expense ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching exp proof files, or <code>null</code> if a matching exp proof files could not be found
	 */
	@Override
	public ExpProofFiles fetchByExpenceId(long expenseId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { expenseId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EXPENCEID,
					finderArgs, this);
		}

		if (result instanceof ExpProofFiles) {
			ExpProofFiles expProofFiles = (ExpProofFiles)result;

			if ((expenseId != expProofFiles.getExpenseId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EXPPROOFFILES_WHERE);

			query.append(_FINDER_COLUMN_EXPENCEID_EXPENSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(expenseId);

				List<ExpProofFiles> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EXPENCEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ExpProofFilesPersistenceImpl.fetchByExpenceId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ExpProofFiles expProofFiles = list.get(0);

					result = expProofFiles;

					cacheResult(expProofFiles);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EXPENCEID,
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
			return (ExpProofFiles)result;
		}
	}

	/**
	 * Removes the exp proof files where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 * @return the exp proof files that was removed
	 */
	@Override
	public ExpProofFiles removeByExpenceId(long expenseId)
		throws NoSuchExpProofFilesException {
		ExpProofFiles expProofFiles = findByExpenceId(expenseId);

		return remove(expProofFiles);
	}

	/**
	 * Returns the number of exp proof fileses where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching exp proof fileses
	 */
	@Override
	public int countByExpenceId(long expenseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXPENCEID;

		Object[] finderArgs = new Object[] { expenseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPPROOFFILES_WHERE);

			query.append(_FINDER_COLUMN_EXPENCEID_EXPENSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(expenseId);

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

	private static final String _FINDER_COLUMN_EXPENCEID_EXPENSEID_2 = "expProofFiles.expenseId = ?";

	public ExpProofFilesPersistenceImpl() {
		setModelClass(ExpProofFiles.class);
	}

	/**
	 * Caches the exp proof files in the entity cache if it is enabled.
	 *
	 * @param expProofFiles the exp proof files
	 */
	@Override
	public void cacheResult(ExpProofFiles expProofFiles) {
		entityCache.putResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesImpl.class, expProofFiles.getPrimaryKey(),
			expProofFiles);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EXPENCEID,
			new Object[] { expProofFiles.getExpenseId() }, expProofFiles);

		expProofFiles.resetOriginalValues();
	}

	/**
	 * Caches the exp proof fileses in the entity cache if it is enabled.
	 *
	 * @param expProofFileses the exp proof fileses
	 */
	@Override
	public void cacheResult(List<ExpProofFiles> expProofFileses) {
		for (ExpProofFiles expProofFiles : expProofFileses) {
			if (entityCache.getResult(
						ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
						ExpProofFilesImpl.class, expProofFiles.getPrimaryKey()) == null) {
				cacheResult(expProofFiles);
			}
			else {
				expProofFiles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all exp proof fileses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpProofFilesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the exp proof files.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpProofFiles expProofFiles) {
		entityCache.removeResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesImpl.class, expProofFiles.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ExpProofFilesModelImpl)expProofFiles, true);
	}

	@Override
	public void clearCache(List<ExpProofFiles> expProofFileses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExpProofFiles expProofFiles : expProofFileses) {
			entityCache.removeResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
				ExpProofFilesImpl.class, expProofFiles.getPrimaryKey());

			clearUniqueFindersCache((ExpProofFilesModelImpl)expProofFiles, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ExpProofFilesModelImpl expProofFilesModelImpl) {
		Object[] args = new Object[] { expProofFilesModelImpl.getExpenseId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_EXPENCEID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EXPENCEID, args,
			expProofFilesModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ExpProofFilesModelImpl expProofFilesModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { expProofFilesModelImpl.getExpenseId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EXPENCEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EXPENCEID, args);
		}

		if ((expProofFilesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EXPENCEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					expProofFilesModelImpl.getOriginalExpenseId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EXPENCEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EXPENCEID, args);
		}
	}

	/**
	 * Creates a new exp proof files with the primary key. Does not add the exp proof files to the database.
	 *
	 * @param fileId the primary key for the new exp proof files
	 * @return the new exp proof files
	 */
	@Override
	public ExpProofFiles create(long fileId) {
		ExpProofFiles expProofFiles = new ExpProofFilesImpl();

		expProofFiles.setNew(true);
		expProofFiles.setPrimaryKey(fileId);

		expProofFiles.setCompanyId(companyProvider.getCompanyId());

		return expProofFiles;
	}

	/**
	 * Removes the exp proof files with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileId the primary key of the exp proof files
	 * @return the exp proof files that was removed
	 * @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	 */
	@Override
	public ExpProofFiles remove(long fileId)
		throws NoSuchExpProofFilesException {
		return remove((Serializable)fileId);
	}

	/**
	 * Removes the exp proof files with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exp proof files
	 * @return the exp proof files that was removed
	 * @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	 */
	@Override
	public ExpProofFiles remove(Serializable primaryKey)
		throws NoSuchExpProofFilesException {
		Session session = null;

		try {
			session = openSession();

			ExpProofFiles expProofFiles = (ExpProofFiles)session.get(ExpProofFilesImpl.class,
					primaryKey);

			if (expProofFiles == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpProofFilesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expProofFiles);
		}
		catch (NoSuchExpProofFilesException nsee) {
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
	protected ExpProofFiles removeImpl(ExpProofFiles expProofFiles) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expProofFiles)) {
				expProofFiles = (ExpProofFiles)session.get(ExpProofFilesImpl.class,
						expProofFiles.getPrimaryKeyObj());
			}

			if (expProofFiles != null) {
				session.delete(expProofFiles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expProofFiles != null) {
			clearCache(expProofFiles);
		}

		return expProofFiles;
	}

	@Override
	public ExpProofFiles updateImpl(ExpProofFiles expProofFiles) {
		boolean isNew = expProofFiles.isNew();

		if (!(expProofFiles instanceof ExpProofFilesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expProofFiles.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(expProofFiles);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expProofFiles proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExpProofFiles implementation " +
				expProofFiles.getClass());
		}

		ExpProofFilesModelImpl expProofFilesModelImpl = (ExpProofFilesModelImpl)expProofFiles;

		Session session = null;

		try {
			session = openSession();

			if (expProofFiles.isNew()) {
				session.save(expProofFiles);

				expProofFiles.setNew(false);
			}
			else {
				expProofFiles = (ExpProofFiles)session.merge(expProofFiles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ExpProofFilesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			ExpProofFilesImpl.class, expProofFiles.getPrimaryKey(),
			expProofFiles, false);

		clearUniqueFindersCache(expProofFilesModelImpl, false);
		cacheUniqueFindersCache(expProofFilesModelImpl);

		expProofFiles.resetOriginalValues();

		return expProofFiles;
	}

	/**
	 * Returns the exp proof files with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the exp proof files
	 * @return the exp proof files
	 * @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	 */
	@Override
	public ExpProofFiles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpProofFilesException {
		ExpProofFiles expProofFiles = fetchByPrimaryKey(primaryKey);

		if (expProofFiles == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpProofFilesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expProofFiles;
	}

	/**
	 * Returns the exp proof files with the primary key or throws a {@link NoSuchExpProofFilesException} if it could not be found.
	 *
	 * @param fileId the primary key of the exp proof files
	 * @return the exp proof files
	 * @throws NoSuchExpProofFilesException if a exp proof files with the primary key could not be found
	 */
	@Override
	public ExpProofFiles findByPrimaryKey(long fileId)
		throws NoSuchExpProofFilesException {
		return findByPrimaryKey((Serializable)fileId);
	}

	/**
	 * Returns the exp proof files with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exp proof files
	 * @return the exp proof files, or <code>null</code> if a exp proof files with the primary key could not be found
	 */
	@Override
	public ExpProofFiles fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
				ExpProofFilesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExpProofFiles expProofFiles = (ExpProofFiles)serializable;

		if (expProofFiles == null) {
			Session session = null;

			try {
				session = openSession();

				expProofFiles = (ExpProofFiles)session.get(ExpProofFilesImpl.class,
						primaryKey);

				if (expProofFiles != null) {
					cacheResult(expProofFiles);
				}
				else {
					entityCache.putResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
						ExpProofFilesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
					ExpProofFilesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expProofFiles;
	}

	/**
	 * Returns the exp proof files with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileId the primary key of the exp proof files
	 * @return the exp proof files, or <code>null</code> if a exp proof files with the primary key could not be found
	 */
	@Override
	public ExpProofFiles fetchByPrimaryKey(long fileId) {
		return fetchByPrimaryKey((Serializable)fileId);
	}

	@Override
	public Map<Serializable, ExpProofFiles> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExpProofFiles> map = new HashMap<Serializable, ExpProofFiles>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExpProofFiles expProofFiles = fetchByPrimaryKey(primaryKey);

			if (expProofFiles != null) {
				map.put(primaryKey, expProofFiles);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
					ExpProofFilesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExpProofFiles)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXPPROOFFILES_WHERE_PKS_IN);

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

			for (ExpProofFiles expProofFiles : (List<ExpProofFiles>)q.list()) {
				map.put(expProofFiles.getPrimaryKeyObj(), expProofFiles);

				cacheResult(expProofFiles);

				uncachedPrimaryKeys.remove(expProofFiles.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExpProofFilesModelImpl.ENTITY_CACHE_ENABLED,
					ExpProofFilesImpl.class, primaryKey, nullModel);
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
	 * Returns all the exp proof fileses.
	 *
	 * @return the exp proof fileses
	 */
	@Override
	public List<ExpProofFiles> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the exp proof fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exp proof fileses
	 * @param end the upper bound of the range of exp proof fileses (not inclusive)
	 * @return the range of exp proof fileses
	 */
	@Override
	public List<ExpProofFiles> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the exp proof fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exp proof fileses
	 * @param end the upper bound of the range of exp proof fileses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exp proof fileses
	 */
	@Override
	public List<ExpProofFiles> findAll(int start, int end,
		OrderByComparator<ExpProofFiles> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the exp proof fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exp proof fileses
	 * @param end the upper bound of the range of exp proof fileses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of exp proof fileses
	 */
	@Override
	public List<ExpProofFiles> findAll(int start, int end,
		OrderByComparator<ExpProofFiles> orderByComparator,
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

		List<ExpProofFiles> list = null;

		if (retrieveFromCache) {
			list = (List<ExpProofFiles>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPPROOFFILES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPPROOFFILES;

				if (pagination) {
					sql = sql.concat(ExpProofFilesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExpProofFiles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpProofFiles>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the exp proof fileses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExpProofFiles expProofFiles : findAll()) {
			remove(expProofFiles);
		}
	}

	/**
	 * Returns the number of exp proof fileses.
	 *
	 * @return the number of exp proof fileses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPPROOFFILES);

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
		return ExpProofFilesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the exp proof files persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExpProofFilesImpl.class.getName());
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
	private static final String _SQL_SELECT_EXPPROOFFILES = "SELECT expProofFiles FROM ExpProofFiles expProofFiles";
	private static final String _SQL_SELECT_EXPPROOFFILES_WHERE_PKS_IN = "SELECT expProofFiles FROM ExpProofFiles expProofFiles WHERE fileId IN (";
	private static final String _SQL_SELECT_EXPPROOFFILES_WHERE = "SELECT expProofFiles FROM ExpProofFiles expProofFiles WHERE ";
	private static final String _SQL_COUNT_EXPPROOFFILES = "SELECT COUNT(expProofFiles) FROM ExpProofFiles expProofFiles";
	private static final String _SQL_COUNT_EXPPROOFFILES_WHERE = "SELECT COUNT(expProofFiles) FROM ExpProofFiles expProofFiles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expProofFiles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExpProofFiles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExpProofFiles exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExpProofFilesPersistenceImpl.class);
}