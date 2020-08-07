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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidateApplyException;
import com.liferay.famocom.erpcloud.model.CandidateApply;
import com.liferay.famocom.erpcloud.model.impl.CandidateApplyImpl;
import com.liferay.famocom.erpcloud.model.impl.CandidateApplyModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.CandidateApplyPersistence;

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
 * The persistence implementation for the candidate apply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidateApplyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.CandidateApplyUtil
 * @generated
 */
@ProviderType
public class CandidateApplyPersistenceImpl extends BasePersistenceImpl<CandidateApply>
	implements CandidateApplyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateApplyUtil} to access the candidate apply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateApplyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
			CandidateApplyModelImpl.FINDER_CACHE_ENABLED,
			CandidateApplyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
			CandidateApplyModelImpl.FINDER_CACHE_ENABLED,
			CandidateApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
			CandidateApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CandidateApplyPersistenceImpl() {
		setModelClass(CandidateApply.class);
	}

	/**
	 * Caches the candidate apply in the entity cache if it is enabled.
	 *
	 * @param candidateApply the candidate apply
	 */
	@Override
	public void cacheResult(CandidateApply candidateApply) {
		entityCache.putResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
			CandidateApplyImpl.class, candidateApply.getPrimaryKey(),
			candidateApply);

		candidateApply.resetOriginalValues();
	}

	/**
	 * Caches the candidate applies in the entity cache if it is enabled.
	 *
	 * @param candidateApplies the candidate applies
	 */
	@Override
	public void cacheResult(List<CandidateApply> candidateApplies) {
		for (CandidateApply candidateApply : candidateApplies) {
			if (entityCache.getResult(
						CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
						CandidateApplyImpl.class, candidateApply.getPrimaryKey()) == null) {
				cacheResult(candidateApply);
			}
			else {
				candidateApply.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate applies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateApplyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate apply.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateApply candidateApply) {
		entityCache.removeResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
			CandidateApplyImpl.class, candidateApply.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CandidateApply> candidateApplies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateApply candidateApply : candidateApplies) {
			entityCache.removeResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
				CandidateApplyImpl.class, candidateApply.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate apply with the primary key. Does not add the candidate apply to the database.
	 *
	 * @param applyCandidateId the primary key for the new candidate apply
	 * @return the new candidate apply
	 */
	@Override
	public CandidateApply create(long applyCandidateId) {
		CandidateApply candidateApply = new CandidateApplyImpl();

		candidateApply.setNew(true);
		candidateApply.setPrimaryKey(applyCandidateId);

		return candidateApply;
	}

	/**
	 * Removes the candidate apply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applyCandidateId the primary key of the candidate apply
	 * @return the candidate apply that was removed
	 * @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	 */
	@Override
	public CandidateApply remove(long applyCandidateId)
		throws NoSuchCandidateApplyException {
		return remove((Serializable)applyCandidateId);
	}

	/**
	 * Removes the candidate apply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate apply
	 * @return the candidate apply that was removed
	 * @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	 */
	@Override
	public CandidateApply remove(Serializable primaryKey)
		throws NoSuchCandidateApplyException {
		Session session = null;

		try {
			session = openSession();

			CandidateApply candidateApply = (CandidateApply)session.get(CandidateApplyImpl.class,
					primaryKey);

			if (candidateApply == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateApplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateApply);
		}
		catch (NoSuchCandidateApplyException nsee) {
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
	protected CandidateApply removeImpl(CandidateApply candidateApply) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateApply)) {
				candidateApply = (CandidateApply)session.get(CandidateApplyImpl.class,
						candidateApply.getPrimaryKeyObj());
			}

			if (candidateApply != null) {
				session.delete(candidateApply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateApply != null) {
			clearCache(candidateApply);
		}

		return candidateApply;
	}

	@Override
	public CandidateApply updateImpl(CandidateApply candidateApply) {
		boolean isNew = candidateApply.isNew();

		Session session = null;

		try {
			session = openSession();

			if (candidateApply.isNew()) {
				session.save(candidateApply);

				candidateApply.setNew(false);
			}
			else {
				candidateApply = (CandidateApply)session.merge(candidateApply);
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

		entityCache.putResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
			CandidateApplyImpl.class, candidateApply.getPrimaryKey(),
			candidateApply, false);

		candidateApply.resetOriginalValues();

		return candidateApply;
	}

	/**
	 * Returns the candidate apply with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate apply
	 * @return the candidate apply
	 * @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	 */
	@Override
	public CandidateApply findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateApplyException {
		CandidateApply candidateApply = fetchByPrimaryKey(primaryKey);

		if (candidateApply == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateApplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateApply;
	}

	/**
	 * Returns the candidate apply with the primary key or throws a {@link NoSuchCandidateApplyException} if it could not be found.
	 *
	 * @param applyCandidateId the primary key of the candidate apply
	 * @return the candidate apply
	 * @throws NoSuchCandidateApplyException if a candidate apply with the primary key could not be found
	 */
	@Override
	public CandidateApply findByPrimaryKey(long applyCandidateId)
		throws NoSuchCandidateApplyException {
		return findByPrimaryKey((Serializable)applyCandidateId);
	}

	/**
	 * Returns the candidate apply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate apply
	 * @return the candidate apply, or <code>null</code> if a candidate apply with the primary key could not be found
	 */
	@Override
	public CandidateApply fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
				CandidateApplyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CandidateApply candidateApply = (CandidateApply)serializable;

		if (candidateApply == null) {
			Session session = null;

			try {
				session = openSession();

				candidateApply = (CandidateApply)session.get(CandidateApplyImpl.class,
						primaryKey);

				if (candidateApply != null) {
					cacheResult(candidateApply);
				}
				else {
					entityCache.putResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
						CandidateApplyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
					CandidateApplyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateApply;
	}

	/**
	 * Returns the candidate apply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applyCandidateId the primary key of the candidate apply
	 * @return the candidate apply, or <code>null</code> if a candidate apply with the primary key could not be found
	 */
	@Override
	public CandidateApply fetchByPrimaryKey(long applyCandidateId) {
		return fetchByPrimaryKey((Serializable)applyCandidateId);
	}

	@Override
	public Map<Serializable, CandidateApply> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CandidateApply> map = new HashMap<Serializable, CandidateApply>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CandidateApply candidateApply = fetchByPrimaryKey(primaryKey);

			if (candidateApply != null) {
				map.put(primaryKey, candidateApply);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
					CandidateApplyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CandidateApply)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANDIDATEAPPLY_WHERE_PKS_IN);

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

			for (CandidateApply candidateApply : (List<CandidateApply>)q.list()) {
				map.put(candidateApply.getPrimaryKeyObj(), candidateApply);

				cacheResult(candidateApply);

				uncachedPrimaryKeys.remove(candidateApply.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CandidateApplyModelImpl.ENTITY_CACHE_ENABLED,
					CandidateApplyImpl.class, primaryKey, nullModel);
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
	 * Returns all the candidate applies.
	 *
	 * @return the candidate applies
	 */
	@Override
	public List<CandidateApply> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate applies
	 * @param end the upper bound of the range of candidate applies (not inclusive)
	 * @return the range of candidate applies
	 */
	@Override
	public List<CandidateApply> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate applies
	 * @param end the upper bound of the range of candidate applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate applies
	 */
	@Override
	public List<CandidateApply> findAll(int start, int end,
		OrderByComparator<CandidateApply> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate applies
	 * @param end the upper bound of the range of candidate applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of candidate applies
	 */
	@Override
	public List<CandidateApply> findAll(int start, int end,
		OrderByComparator<CandidateApply> orderByComparator,
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

		List<CandidateApply> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateApply>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANDIDATEAPPLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEAPPLY;

				if (pagination) {
					sql = sql.concat(CandidateApplyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateApply>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateApply>)QueryUtil.list(q,
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
	 * Removes all the candidate applies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateApply candidateApply : findAll()) {
			remove(candidateApply);
		}
	}

	/**
	 * Returns the number of candidate applies.
	 *
	 * @return the number of candidate applies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEAPPLY);

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
		return CandidateApplyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate apply persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CandidateApplyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANDIDATEAPPLY = "SELECT candidateApply FROM CandidateApply candidateApply";
	private static final String _SQL_SELECT_CANDIDATEAPPLY_WHERE_PKS_IN = "SELECT candidateApply FROM CandidateApply candidateApply WHERE applyCandidateId IN (";
	private static final String _SQL_COUNT_CANDIDATEAPPLY = "SELECT COUNT(candidateApply) FROM CandidateApply candidateApply";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateApply.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateApply exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CandidateApplyPersistenceImpl.class);
}