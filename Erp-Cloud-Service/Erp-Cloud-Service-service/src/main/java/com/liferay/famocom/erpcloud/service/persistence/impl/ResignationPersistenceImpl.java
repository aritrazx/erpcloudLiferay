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

import com.liferay.famocom.erpcloud.exception.NoSuchResignationException;
import com.liferay.famocom.erpcloud.model.Resignation;
import com.liferay.famocom.erpcloud.model.impl.ResignationImpl;
import com.liferay.famocom.erpcloud.model.impl.ResignationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ResignationPersistence;

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
 * The persistence implementation for the resignation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ResignationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ResignationUtil
 * @generated
 */
@ProviderType
public class ResignationPersistenceImpl extends BasePersistenceImpl<Resignation>
	implements ResignationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResignationUtil} to access the resignation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResignationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResignationModelImpl.ENTITY_CACHE_ENABLED,
			ResignationModelImpl.FINDER_CACHE_ENABLED, ResignationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResignationModelImpl.ENTITY_CACHE_ENABLED,
			ResignationModelImpl.FINDER_CACHE_ENABLED, ResignationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResignationModelImpl.ENTITY_CACHE_ENABLED,
			ResignationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ResignationPersistenceImpl() {
		setModelClass(Resignation.class);
	}

	/**
	 * Caches the resignation in the entity cache if it is enabled.
	 *
	 * @param resignation the resignation
	 */
	@Override
	public void cacheResult(Resignation resignation) {
		entityCache.putResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
			ResignationImpl.class, resignation.getPrimaryKey(), resignation);

		resignation.resetOriginalValues();
	}

	/**
	 * Caches the resignations in the entity cache if it is enabled.
	 *
	 * @param resignations the resignations
	 */
	@Override
	public void cacheResult(List<Resignation> resignations) {
		for (Resignation resignation : resignations) {
			if (entityCache.getResult(
						ResignationModelImpl.ENTITY_CACHE_ENABLED,
						ResignationImpl.class, resignation.getPrimaryKey()) == null) {
				cacheResult(resignation);
			}
			else {
				resignation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all resignations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ResignationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resignation.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Resignation resignation) {
		entityCache.removeResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
			ResignationImpl.class, resignation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Resignation> resignations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Resignation resignation : resignations) {
			entityCache.removeResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
				ResignationImpl.class, resignation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new resignation with the primary key. Does not add the resignation to the database.
	 *
	 * @param ResignationId the primary key for the new resignation
	 * @return the new resignation
	 */
	@Override
	public Resignation create(long ResignationId) {
		Resignation resignation = new ResignationImpl();

		resignation.setNew(true);
		resignation.setPrimaryKey(ResignationId);

		return resignation;
	}

	/**
	 * Removes the resignation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ResignationId the primary key of the resignation
	 * @return the resignation that was removed
	 * @throws NoSuchResignationException if a resignation with the primary key could not be found
	 */
	@Override
	public Resignation remove(long ResignationId)
		throws NoSuchResignationException {
		return remove((Serializable)ResignationId);
	}

	/**
	 * Removes the resignation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resignation
	 * @return the resignation that was removed
	 * @throws NoSuchResignationException if a resignation with the primary key could not be found
	 */
	@Override
	public Resignation remove(Serializable primaryKey)
		throws NoSuchResignationException {
		Session session = null;

		try {
			session = openSession();

			Resignation resignation = (Resignation)session.get(ResignationImpl.class,
					primaryKey);

			if (resignation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResignationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(resignation);
		}
		catch (NoSuchResignationException nsee) {
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
	protected Resignation removeImpl(Resignation resignation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resignation)) {
				resignation = (Resignation)session.get(ResignationImpl.class,
						resignation.getPrimaryKeyObj());
			}

			if (resignation != null) {
				session.delete(resignation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (resignation != null) {
			clearCache(resignation);
		}

		return resignation;
	}

	@Override
	public Resignation updateImpl(Resignation resignation) {
		boolean isNew = resignation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (resignation.isNew()) {
				session.save(resignation);

				resignation.setNew(false);
			}
			else {
				resignation = (Resignation)session.merge(resignation);
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

		entityCache.putResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
			ResignationImpl.class, resignation.getPrimaryKey(), resignation,
			false);

		resignation.resetOriginalValues();

		return resignation;
	}

	/**
	 * Returns the resignation with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resignation
	 * @return the resignation
	 * @throws NoSuchResignationException if a resignation with the primary key could not be found
	 */
	@Override
	public Resignation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResignationException {
		Resignation resignation = fetchByPrimaryKey(primaryKey);

		if (resignation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResignationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return resignation;
	}

	/**
	 * Returns the resignation with the primary key or throws a {@link NoSuchResignationException} if it could not be found.
	 *
	 * @param ResignationId the primary key of the resignation
	 * @return the resignation
	 * @throws NoSuchResignationException if a resignation with the primary key could not be found
	 */
	@Override
	public Resignation findByPrimaryKey(long ResignationId)
		throws NoSuchResignationException {
		return findByPrimaryKey((Serializable)ResignationId);
	}

	/**
	 * Returns the resignation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resignation
	 * @return the resignation, or <code>null</code> if a resignation with the primary key could not be found
	 */
	@Override
	public Resignation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
				ResignationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Resignation resignation = (Resignation)serializable;

		if (resignation == null) {
			Session session = null;

			try {
				session = openSession();

				resignation = (Resignation)session.get(ResignationImpl.class,
						primaryKey);

				if (resignation != null) {
					cacheResult(resignation);
				}
				else {
					entityCache.putResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
						ResignationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
					ResignationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return resignation;
	}

	/**
	 * Returns the resignation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ResignationId the primary key of the resignation
	 * @return the resignation, or <code>null</code> if a resignation with the primary key could not be found
	 */
	@Override
	public Resignation fetchByPrimaryKey(long ResignationId) {
		return fetchByPrimaryKey((Serializable)ResignationId);
	}

	@Override
	public Map<Serializable, Resignation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Resignation> map = new HashMap<Serializable, Resignation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Resignation resignation = fetchByPrimaryKey(primaryKey);

			if (resignation != null) {
				map.put(primaryKey, resignation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
					ResignationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Resignation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RESIGNATION_WHERE_PKS_IN);

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

			for (Resignation resignation : (List<Resignation>)q.list()) {
				map.put(resignation.getPrimaryKeyObj(), resignation);

				cacheResult(resignation);

				uncachedPrimaryKeys.remove(resignation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ResignationModelImpl.ENTITY_CACHE_ENABLED,
					ResignationImpl.class, primaryKey, nullModel);
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
	 * Returns all the resignations.
	 *
	 * @return the resignations
	 */
	@Override
	public List<Resignation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resignations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of resignations
	 * @param end the upper bound of the range of resignations (not inclusive)
	 * @return the range of resignations
	 */
	@Override
	public List<Resignation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the resignations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of resignations
	 * @param end the upper bound of the range of resignations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resignations
	 */
	@Override
	public List<Resignation> findAll(int start, int end,
		OrderByComparator<Resignation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the resignations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ResignationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of resignations
	 * @param end the upper bound of the range of resignations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of resignations
	 */
	@Override
	public List<Resignation> findAll(int start, int end,
		OrderByComparator<Resignation> orderByComparator,
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

		List<Resignation> list = null;

		if (retrieveFromCache) {
			list = (List<Resignation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RESIGNATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESIGNATION;

				if (pagination) {
					sql = sql.concat(ResignationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Resignation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Resignation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the resignations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Resignation resignation : findAll()) {
			remove(resignation);
		}
	}

	/**
	 * Returns the number of resignations.
	 *
	 * @return the number of resignations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESIGNATION);

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
		return ResignationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the resignation persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ResignationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RESIGNATION = "SELECT resignation FROM Resignation resignation";
	private static final String _SQL_SELECT_RESIGNATION_WHERE_PKS_IN = "SELECT resignation FROM Resignation resignation WHERE ResignationId IN (";
	private static final String _SQL_COUNT_RESIGNATION = "SELECT COUNT(resignation) FROM Resignation resignation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resignation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Resignation exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ResignationPersistenceImpl.class);
}