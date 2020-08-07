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

import com.liferay.famocom.erpcloud.exception.NoSuchEvaluationException;
import com.liferay.famocom.erpcloud.model.Evaluation;
import com.liferay.famocom.erpcloud.model.impl.EvaluationImpl;
import com.liferay.famocom.erpcloud.model.impl.EvaluationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.EvaluationPersistence;

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
 * The persistence implementation for the evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.EvaluationUtil
 * @generated
 */
@ProviderType
public class EvaluationPersistenceImpl extends BasePersistenceImpl<Evaluation>
	implements EvaluationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EvaluationUtil} to access the evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EvaluationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationModelImpl.FINDER_CACHE_ENABLED, EvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationModelImpl.FINDER_CACHE_ENABLED, EvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EvaluationPersistenceImpl() {
		setModelClass(Evaluation.class);
	}

	/**
	 * Caches the evaluation in the entity cache if it is enabled.
	 *
	 * @param evaluation the evaluation
	 */
	@Override
	public void cacheResult(Evaluation evaluation) {
		entityCache.putResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationImpl.class, evaluation.getPrimaryKey(), evaluation);

		evaluation.resetOriginalValues();
	}

	/**
	 * Caches the evaluations in the entity cache if it is enabled.
	 *
	 * @param evaluations the evaluations
	 */
	@Override
	public void cacheResult(List<Evaluation> evaluations) {
		for (Evaluation evaluation : evaluations) {
			if (entityCache.getResult(
						EvaluationModelImpl.ENTITY_CACHE_ENABLED,
						EvaluationImpl.class, evaluation.getPrimaryKey()) == null) {
				cacheResult(evaluation);
			}
			else {
				evaluation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all evaluations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EvaluationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evaluation.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Evaluation evaluation) {
		entityCache.removeResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationImpl.class, evaluation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Evaluation> evaluations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Evaluation evaluation : evaluations) {
			entityCache.removeResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
				EvaluationImpl.class, evaluation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	 *
	 * @param evaluationId the primary key for the new evaluation
	 * @return the new evaluation
	 */
	@Override
	public Evaluation create(long evaluationId) {
		Evaluation evaluation = new EvaluationImpl();

		evaluation.setNew(true);
		evaluation.setPrimaryKey(evaluationId);

		return evaluation;
	}

	/**
	 * Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param evaluationId the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation remove(long evaluationId)
		throws NoSuchEvaluationException {
		return remove((Serializable)evaluationId);
	}

	/**
	 * Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation remove(Serializable primaryKey)
		throws NoSuchEvaluationException {
		Session session = null;

		try {
			session = openSession();

			Evaluation evaluation = (Evaluation)session.get(EvaluationImpl.class,
					primaryKey);

			if (evaluation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(evaluation);
		}
		catch (NoSuchEvaluationException nsee) {
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
	protected Evaluation removeImpl(Evaluation evaluation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(evaluation)) {
				evaluation = (Evaluation)session.get(EvaluationImpl.class,
						evaluation.getPrimaryKeyObj());
			}

			if (evaluation != null) {
				session.delete(evaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (evaluation != null) {
			clearCache(evaluation);
		}

		return evaluation;
	}

	@Override
	public Evaluation updateImpl(Evaluation evaluation) {
		boolean isNew = evaluation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (evaluation.isNew()) {
				session.save(evaluation);

				evaluation.setNew(false);
			}
			else {
				evaluation = (Evaluation)session.merge(evaluation);
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

		entityCache.putResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationImpl.class, evaluation.getPrimaryKey(), evaluation, false);

		evaluation.resetOriginalValues();

		return evaluation;
	}

	/**
	 * Returns the evaluation with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation
	 * @return the evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEvaluationException {
		Evaluation evaluation = fetchByPrimaryKey(primaryKey);

		if (evaluation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return evaluation;
	}

	/**
	 * Returns the evaluation with the primary key or throws a {@link NoSuchEvaluationException} if it could not be found.
	 *
	 * @param evaluationId the primary key of the evaluation
	 * @return the evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation findByPrimaryKey(long evaluationId)
		throws NoSuchEvaluationException {
		return findByPrimaryKey((Serializable)evaluationId);
	}

	/**
	 * Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation
	 * @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
				EvaluationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Evaluation evaluation = (Evaluation)serializable;

		if (evaluation == null) {
			Session session = null;

			try {
				session = openSession();

				evaluation = (Evaluation)session.get(EvaluationImpl.class,
						primaryKey);

				if (evaluation != null) {
					cacheResult(evaluation);
				}
				else {
					entityCache.putResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
						EvaluationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
					EvaluationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return evaluation;
	}

	/**
	 * Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param evaluationId the primary key of the evaluation
	 * @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation fetchByPrimaryKey(long evaluationId) {
		return fetchByPrimaryKey((Serializable)evaluationId);
	}

	@Override
	public Map<Serializable, Evaluation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Evaluation> map = new HashMap<Serializable, Evaluation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Evaluation evaluation = fetchByPrimaryKey(primaryKey);

			if (evaluation != null) {
				map.put(primaryKey, evaluation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
					EvaluationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Evaluation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EVALUATION_WHERE_PKS_IN);

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

			for (Evaluation evaluation : (List<Evaluation>)q.list()) {
				map.put(evaluation.getPrimaryKeyObj(), evaluation);

				cacheResult(evaluation);

				uncachedPrimaryKeys.remove(evaluation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EvaluationModelImpl.ENTITY_CACHE_ENABLED,
					EvaluationImpl.class, primaryKey, nullModel);
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
	 * Returns all the evaluations.
	 *
	 * @return the evaluations
	 */
	@Override
	public List<Evaluation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @return the range of evaluations
	 */
	@Override
	public List<Evaluation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evaluations
	 */
	@Override
	public List<Evaluation> findAll(int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of evaluations
	 */
	@Override
	public List<Evaluation> findAll(int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
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

		List<Evaluation> list = null;

		if (retrieveFromCache) {
			list = (List<Evaluation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EVALUATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVALUATION;

				if (pagination) {
					sql = sql.concat(EvaluationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Evaluation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Evaluation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the evaluations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Evaluation evaluation : findAll()) {
			remove(evaluation);
		}
	}

	/**
	 * Returns the number of evaluations.
	 *
	 * @return the number of evaluations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVALUATION);

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
		return EvaluationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the evaluation persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EvaluationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EVALUATION = "SELECT evaluation FROM Evaluation evaluation";
	private static final String _SQL_SELECT_EVALUATION_WHERE_PKS_IN = "SELECT evaluation FROM Evaluation evaluation WHERE evaluationId IN (";
	private static final String _SQL_COUNT_EVALUATION = "SELECT COUNT(evaluation) FROM Evaluation evaluation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "evaluation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Evaluation exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(EvaluationPersistenceImpl.class);
}