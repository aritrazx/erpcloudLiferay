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

import com.liferay.famocom.erpcloud.exception.NoSuchInterviewEvaluationException;
import com.liferay.famocom.erpcloud.model.InterviewEvaluation;
import com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationImpl;
import com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.InterviewEvaluationPersistence;

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
 * The persistence implementation for the interview evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see InterviewEvaluationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.InterviewEvaluationUtil
 * @generated
 */
@ProviderType
public class InterviewEvaluationPersistenceImpl extends BasePersistenceImpl<InterviewEvaluation>
	implements InterviewEvaluationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InterviewEvaluationUtil} to access the interview evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InterviewEvaluationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			InterviewEvaluationModelImpl.FINDER_CACHE_ENABLED,
			InterviewEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			InterviewEvaluationModelImpl.FINDER_CACHE_ENABLED,
			InterviewEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			InterviewEvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public InterviewEvaluationPersistenceImpl() {
		setModelClass(InterviewEvaluation.class);
	}

	/**
	 * Caches the interview evaluation in the entity cache if it is enabled.
	 *
	 * @param interviewEvaluation the interview evaluation
	 */
	@Override
	public void cacheResult(InterviewEvaluation interviewEvaluation) {
		entityCache.putResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			InterviewEvaluationImpl.class, interviewEvaluation.getPrimaryKey(),
			interviewEvaluation);

		interviewEvaluation.resetOriginalValues();
	}

	/**
	 * Caches the interview evaluations in the entity cache if it is enabled.
	 *
	 * @param interviewEvaluations the interview evaluations
	 */
	@Override
	public void cacheResult(List<InterviewEvaluation> interviewEvaluations) {
		for (InterviewEvaluation interviewEvaluation : interviewEvaluations) {
			if (entityCache.getResult(
						InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						InterviewEvaluationImpl.class,
						interviewEvaluation.getPrimaryKey()) == null) {
				cacheResult(interviewEvaluation);
			}
			else {
				interviewEvaluation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interview evaluations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InterviewEvaluationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interview evaluation.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InterviewEvaluation interviewEvaluation) {
		entityCache.removeResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			InterviewEvaluationImpl.class, interviewEvaluation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InterviewEvaluation> interviewEvaluations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InterviewEvaluation interviewEvaluation : interviewEvaluations) {
			entityCache.removeResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				InterviewEvaluationImpl.class,
				interviewEvaluation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new interview evaluation with the primary key. Does not add the interview evaluation to the database.
	 *
	 * @param evaluationId the primary key for the new interview evaluation
	 * @return the new interview evaluation
	 */
	@Override
	public InterviewEvaluation create(long evaluationId) {
		InterviewEvaluation interviewEvaluation = new InterviewEvaluationImpl();

		interviewEvaluation.setNew(true);
		interviewEvaluation.setPrimaryKey(evaluationId);

		return interviewEvaluation;
	}

	/**
	 * Removes the interview evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param evaluationId the primary key of the interview evaluation
	 * @return the interview evaluation that was removed
	 * @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	 */
	@Override
	public InterviewEvaluation remove(long evaluationId)
		throws NoSuchInterviewEvaluationException {
		return remove((Serializable)evaluationId);
	}

	/**
	 * Removes the interview evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview evaluation
	 * @return the interview evaluation that was removed
	 * @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	 */
	@Override
	public InterviewEvaluation remove(Serializable primaryKey)
		throws NoSuchInterviewEvaluationException {
		Session session = null;

		try {
			session = openSession();

			InterviewEvaluation interviewEvaluation = (InterviewEvaluation)session.get(InterviewEvaluationImpl.class,
					primaryKey);

			if (interviewEvaluation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterviewEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interviewEvaluation);
		}
		catch (NoSuchInterviewEvaluationException nsee) {
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
	protected InterviewEvaluation removeImpl(
		InterviewEvaluation interviewEvaluation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(interviewEvaluation)) {
				interviewEvaluation = (InterviewEvaluation)session.get(InterviewEvaluationImpl.class,
						interviewEvaluation.getPrimaryKeyObj());
			}

			if (interviewEvaluation != null) {
				session.delete(interviewEvaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (interviewEvaluation != null) {
			clearCache(interviewEvaluation);
		}

		return interviewEvaluation;
	}

	@Override
	public InterviewEvaluation updateImpl(
		InterviewEvaluation interviewEvaluation) {
		boolean isNew = interviewEvaluation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (interviewEvaluation.isNew()) {
				session.save(interviewEvaluation);

				interviewEvaluation.setNew(false);
			}
			else {
				interviewEvaluation = (InterviewEvaluation)session.merge(interviewEvaluation);
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

		entityCache.putResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			InterviewEvaluationImpl.class, interviewEvaluation.getPrimaryKey(),
			interviewEvaluation, false);

		interviewEvaluation.resetOriginalValues();

		return interviewEvaluation;
	}

	/**
	 * Returns the interview evaluation with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview evaluation
	 * @return the interview evaluation
	 * @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	 */
	@Override
	public InterviewEvaluation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInterviewEvaluationException {
		InterviewEvaluation interviewEvaluation = fetchByPrimaryKey(primaryKey);

		if (interviewEvaluation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInterviewEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return interviewEvaluation;
	}

	/**
	 * Returns the interview evaluation with the primary key or throws a {@link NoSuchInterviewEvaluationException} if it could not be found.
	 *
	 * @param evaluationId the primary key of the interview evaluation
	 * @return the interview evaluation
	 * @throws NoSuchInterviewEvaluationException if a interview evaluation with the primary key could not be found
	 */
	@Override
	public InterviewEvaluation findByPrimaryKey(long evaluationId)
		throws NoSuchInterviewEvaluationException {
		return findByPrimaryKey((Serializable)evaluationId);
	}

	/**
	 * Returns the interview evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview evaluation
	 * @return the interview evaluation, or <code>null</code> if a interview evaluation with the primary key could not be found
	 */
	@Override
	public InterviewEvaluation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				InterviewEvaluationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		InterviewEvaluation interviewEvaluation = (InterviewEvaluation)serializable;

		if (interviewEvaluation == null) {
			Session session = null;

			try {
				session = openSession();

				interviewEvaluation = (InterviewEvaluation)session.get(InterviewEvaluationImpl.class,
						primaryKey);

				if (interviewEvaluation != null) {
					cacheResult(interviewEvaluation);
				}
				else {
					entityCache.putResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						InterviewEvaluationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					InterviewEvaluationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return interviewEvaluation;
	}

	/**
	 * Returns the interview evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param evaluationId the primary key of the interview evaluation
	 * @return the interview evaluation, or <code>null</code> if a interview evaluation with the primary key could not be found
	 */
	@Override
	public InterviewEvaluation fetchByPrimaryKey(long evaluationId) {
		return fetchByPrimaryKey((Serializable)evaluationId);
	}

	@Override
	public Map<Serializable, InterviewEvaluation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, InterviewEvaluation> map = new HashMap<Serializable, InterviewEvaluation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			InterviewEvaluation interviewEvaluation = fetchByPrimaryKey(primaryKey);

			if (interviewEvaluation != null) {
				map.put(primaryKey, interviewEvaluation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					InterviewEvaluationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (InterviewEvaluation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_INTERVIEWEVALUATION_WHERE_PKS_IN);

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

			for (InterviewEvaluation interviewEvaluation : (List<InterviewEvaluation>)q.list()) {
				map.put(interviewEvaluation.getPrimaryKeyObj(),
					interviewEvaluation);

				cacheResult(interviewEvaluation);

				uncachedPrimaryKeys.remove(interviewEvaluation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(InterviewEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					InterviewEvaluationImpl.class, primaryKey, nullModel);
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
	 * Returns all the interview evaluations.
	 *
	 * @return the interview evaluations
	 */
	@Override
	public List<InterviewEvaluation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interview evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview evaluations
	 * @param end the upper bound of the range of interview evaluations (not inclusive)
	 * @return the range of interview evaluations
	 */
	@Override
	public List<InterviewEvaluation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview evaluations
	 * @param end the upper bound of the range of interview evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interview evaluations
	 */
	@Override
	public List<InterviewEvaluation> findAll(int start, int end,
		OrderByComparator<InterviewEvaluation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview evaluations
	 * @param end the upper bound of the range of interview evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of interview evaluations
	 */
	@Override
	public List<InterviewEvaluation> findAll(int start, int end,
		OrderByComparator<InterviewEvaluation> orderByComparator,
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

		List<InterviewEvaluation> list = null;

		if (retrieveFromCache) {
			list = (List<InterviewEvaluation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_INTERVIEWEVALUATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEWEVALUATION;

				if (pagination) {
					sql = sql.concat(InterviewEvaluationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InterviewEvaluation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<InterviewEvaluation>)QueryUtil.list(q,
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
	 * Removes all the interview evaluations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InterviewEvaluation interviewEvaluation : findAll()) {
			remove(interviewEvaluation);
		}
	}

	/**
	 * Returns the number of interview evaluations.
	 *
	 * @return the number of interview evaluations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INTERVIEWEVALUATION);

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
		return InterviewEvaluationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the interview evaluation persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(InterviewEvaluationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_INTERVIEWEVALUATION = "SELECT interviewEvaluation FROM InterviewEvaluation interviewEvaluation";
	private static final String _SQL_SELECT_INTERVIEWEVALUATION_WHERE_PKS_IN = "SELECT interviewEvaluation FROM InterviewEvaluation interviewEvaluation WHERE evaluationId IN (";
	private static final String _SQL_COUNT_INTERVIEWEVALUATION = "SELECT COUNT(interviewEvaluation) FROM InterviewEvaluation interviewEvaluation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interviewEvaluation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InterviewEvaluation exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(InterviewEvaluationPersistenceImpl.class);
}