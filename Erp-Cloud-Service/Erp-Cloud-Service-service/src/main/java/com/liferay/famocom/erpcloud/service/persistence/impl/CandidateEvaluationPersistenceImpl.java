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

import com.liferay.famocom.erpcloud.exception.NoSuchCandidateEvaluationException;
import com.liferay.famocom.erpcloud.model.CandidateEvaluation;
import com.liferay.famocom.erpcloud.model.impl.CandidateEvaluationImpl;
import com.liferay.famocom.erpcloud.model.impl.CandidateEvaluationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.CandidateEvaluationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the candidate evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CandidateEvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.CandidateEvaluationUtil
 * @generated
 */
@ProviderType
public class CandidateEvaluationPersistenceImpl extends BasePersistenceImpl<CandidateEvaluation>
	implements CandidateEvaluationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateEvaluationUtil} to access the candidate evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateEvaluationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED,
			CandidateEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED,
			CandidateEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CandidateEvaluationPersistenceImpl() {
		setModelClass(CandidateEvaluation.class);
	}

	/**
	 * Caches the candidate evaluation in the entity cache if it is enabled.
	 *
	 * @param candidateEvaluation the candidate evaluation
	 */
	@Override
	public void cacheResult(CandidateEvaluation candidateEvaluation) {
		entityCache.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationImpl.class, candidateEvaluation.getPrimaryKey(),
			candidateEvaluation);

		candidateEvaluation.resetOriginalValues();
	}

	/**
	 * Caches the candidate evaluations in the entity cache if it is enabled.
	 *
	 * @param candidateEvaluations the candidate evaluations
	 */
	@Override
	public void cacheResult(List<CandidateEvaluation> candidateEvaluations) {
		for (CandidateEvaluation candidateEvaluation : candidateEvaluations) {
			if (entityCache.getResult(
						CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						CandidateEvaluationImpl.class,
						candidateEvaluation.getPrimaryKey()) == null) {
				cacheResult(candidateEvaluation);
			}
			else {
				candidateEvaluation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate evaluations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateEvaluationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate evaluation.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateEvaluation candidateEvaluation) {
		entityCache.removeResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationImpl.class, candidateEvaluation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CandidateEvaluation> candidateEvaluations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateEvaluation candidateEvaluation : candidateEvaluations) {
			entityCache.removeResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				CandidateEvaluationImpl.class,
				candidateEvaluation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	 *
	 * @param candidateEvaluationId the primary key for the new candidate evaluation
	 * @return the new candidate evaluation
	 */
	@Override
	public CandidateEvaluation create(long candidateEvaluationId) {
		CandidateEvaluation candidateEvaluation = new CandidateEvaluationImpl();

		candidateEvaluation.setNew(true);
		candidateEvaluation.setPrimaryKey(candidateEvaluationId);

		return candidateEvaluation;
	}

	/**
	 * Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateEvaluationId the primary key of the candidate evaluation
	 * @return the candidate evaluation that was removed
	 * @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 */
	@Override
	public CandidateEvaluation remove(long candidateEvaluationId)
		throws NoSuchCandidateEvaluationException {
		return remove((Serializable)candidateEvaluationId);
	}

	/**
	 * Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate evaluation
	 * @return the candidate evaluation that was removed
	 * @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 */
	@Override
	public CandidateEvaluation remove(Serializable primaryKey)
		throws NoSuchCandidateEvaluationException {
		Session session = null;

		try {
			session = openSession();

			CandidateEvaluation candidateEvaluation = (CandidateEvaluation)session.get(CandidateEvaluationImpl.class,
					primaryKey);

			if (candidateEvaluation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateEvaluation);
		}
		catch (NoSuchCandidateEvaluationException nsee) {
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
	protected CandidateEvaluation removeImpl(
		CandidateEvaluation candidateEvaluation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateEvaluation)) {
				candidateEvaluation = (CandidateEvaluation)session.get(CandidateEvaluationImpl.class,
						candidateEvaluation.getPrimaryKeyObj());
			}

			if (candidateEvaluation != null) {
				session.delete(candidateEvaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateEvaluation != null) {
			clearCache(candidateEvaluation);
		}

		return candidateEvaluation;
	}

	@Override
	public CandidateEvaluation updateImpl(
		CandidateEvaluation candidateEvaluation) {
		boolean isNew = candidateEvaluation.isNew();

		if (!(candidateEvaluation instanceof CandidateEvaluationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(candidateEvaluation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(candidateEvaluation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in candidateEvaluation proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CandidateEvaluation implementation " +
				candidateEvaluation.getClass());
		}

		CandidateEvaluationModelImpl candidateEvaluationModelImpl = (CandidateEvaluationModelImpl)candidateEvaluation;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (candidateEvaluation.getCreateDate() == null)) {
			if (serviceContext == null) {
				candidateEvaluation.setCreateDate(now);
			}
			else {
				candidateEvaluation.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!candidateEvaluationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				candidateEvaluation.setModifiedDate(now);
			}
			else {
				candidateEvaluation.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (candidateEvaluation.isNew()) {
				session.save(candidateEvaluation);

				candidateEvaluation.setNew(false);
			}
			else {
				candidateEvaluation = (CandidateEvaluation)session.merge(candidateEvaluation);
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

		entityCache.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationImpl.class, candidateEvaluation.getPrimaryKey(),
			candidateEvaluation, false);

		candidateEvaluation.resetOriginalValues();

		return candidateEvaluation;
	}

	/**
	 * Returns the candidate evaluation with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate evaluation
	 * @return the candidate evaluation
	 * @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 */
	@Override
	public CandidateEvaluation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateEvaluationException {
		CandidateEvaluation candidateEvaluation = fetchByPrimaryKey(primaryKey);

		if (candidateEvaluation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateEvaluation;
	}

	/**
	 * Returns the candidate evaluation with the primary key or throws a {@link NoSuchCandidateEvaluationException} if it could not be found.
	 *
	 * @param candidateEvaluationId the primary key of the candidate evaluation
	 * @return the candidate evaluation
	 * @throws NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 */
	@Override
	public CandidateEvaluation findByPrimaryKey(long candidateEvaluationId)
		throws NoSuchCandidateEvaluationException {
		return findByPrimaryKey((Serializable)candidateEvaluationId);
	}

	/**
	 * Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate evaluation
	 * @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	 */
	@Override
	public CandidateEvaluation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				CandidateEvaluationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CandidateEvaluation candidateEvaluation = (CandidateEvaluation)serializable;

		if (candidateEvaluation == null) {
			Session session = null;

			try {
				session = openSession();

				candidateEvaluation = (CandidateEvaluation)session.get(CandidateEvaluationImpl.class,
						primaryKey);

				if (candidateEvaluation != null) {
					cacheResult(candidateEvaluation);
				}
				else {
					entityCache.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						CandidateEvaluationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEvaluationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateEvaluation;
	}

	/**
	 * Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateEvaluationId the primary key of the candidate evaluation
	 * @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	 */
	@Override
	public CandidateEvaluation fetchByPrimaryKey(long candidateEvaluationId) {
		return fetchByPrimaryKey((Serializable)candidateEvaluationId);
	}

	@Override
	public Map<Serializable, CandidateEvaluation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CandidateEvaluation> map = new HashMap<Serializable, CandidateEvaluation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CandidateEvaluation candidateEvaluation = fetchByPrimaryKey(primaryKey);

			if (candidateEvaluation != null) {
				map.put(primaryKey, candidateEvaluation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEvaluationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CandidateEvaluation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANDIDATEEVALUATION_WHERE_PKS_IN);

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

			for (CandidateEvaluation candidateEvaluation : (List<CandidateEvaluation>)q.list()) {
				map.put(candidateEvaluation.getPrimaryKeyObj(),
					candidateEvaluation);

				cacheResult(candidateEvaluation);

				uncachedPrimaryKeys.remove(candidateEvaluation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEvaluationImpl.class, primaryKey, nullModel);
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
	 * Returns all the candidate evaluations.
	 *
	 * @return the candidate evaluations
	 */
	@Override
	public List<CandidateEvaluation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @return the range of candidate evaluations
	 */
	@Override
	public List<CandidateEvaluation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate evaluations
	 */
	@Override
	public List<CandidateEvaluation> findAll(int start, int end,
		OrderByComparator<CandidateEvaluation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of candidate evaluations
	 */
	@Override
	public List<CandidateEvaluation> findAll(int start, int end,
		OrderByComparator<CandidateEvaluation> orderByComparator,
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

		List<CandidateEvaluation> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEvaluation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANDIDATEEVALUATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEEVALUATION;

				if (pagination) {
					sql = sql.concat(CandidateEvaluationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateEvaluation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEvaluation>)QueryUtil.list(q,
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
	 * Removes all the candidate evaluations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateEvaluation candidateEvaluation : findAll()) {
			remove(candidateEvaluation);
		}
	}

	/**
	 * Returns the number of candidate evaluations.
	 *
	 * @return the number of candidate evaluations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEEVALUATION);

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
		return CandidateEvaluationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate evaluation persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CandidateEvaluationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANDIDATEEVALUATION = "SELECT candidateEvaluation FROM CandidateEvaluation candidateEvaluation";
	private static final String _SQL_SELECT_CANDIDATEEVALUATION_WHERE_PKS_IN = "SELECT candidateEvaluation FROM CandidateEvaluation candidateEvaluation WHERE candidateEvaluationId IN (";
	private static final String _SQL_COUNT_CANDIDATEEVALUATION = "SELECT COUNT(candidateEvaluation) FROM CandidateEvaluation candidateEvaluation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateEvaluation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateEvaluation exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CandidateEvaluationPersistenceImpl.class);
}