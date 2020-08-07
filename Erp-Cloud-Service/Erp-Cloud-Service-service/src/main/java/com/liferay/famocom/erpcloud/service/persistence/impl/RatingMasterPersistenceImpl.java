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

import com.liferay.famocom.erpcloud.exception.NoSuchRatingMasterException;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.model.impl.RatingMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.RatingMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.RatingMasterPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
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
 * The persistence implementation for the rating master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see RatingMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.RatingMasterUtil
 * @generated
 */
@ProviderType
public class RatingMasterPersistenceImpl extends BasePersistenceImpl<RatingMaster>
	implements RatingMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RatingMasterUtil} to access the rating master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RatingMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
			RatingMasterModelImpl.FINDER_CACHE_ENABLED, RatingMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
			RatingMasterModelImpl.FINDER_CACHE_ENABLED, RatingMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
			RatingMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RatingMasterPersistenceImpl() {
		setModelClass(RatingMaster.class);
	}

	/**
	 * Caches the rating master in the entity cache if it is enabled.
	 *
	 * @param ratingMaster the rating master
	 */
	@Override
	public void cacheResult(RatingMaster ratingMaster) {
		entityCache.putResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
			RatingMasterImpl.class, ratingMaster.getPrimaryKey(), ratingMaster);

		ratingMaster.resetOriginalValues();
	}

	/**
	 * Caches the rating masters in the entity cache if it is enabled.
	 *
	 * @param ratingMasters the rating masters
	 */
	@Override
	public void cacheResult(List<RatingMaster> ratingMasters) {
		for (RatingMaster ratingMaster : ratingMasters) {
			if (entityCache.getResult(
						RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
						RatingMasterImpl.class, ratingMaster.getPrimaryKey()) == null) {
				cacheResult(ratingMaster);
			}
			else {
				ratingMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rating masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RatingMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rating master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RatingMaster ratingMaster) {
		entityCache.removeResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
			RatingMasterImpl.class, ratingMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RatingMaster> ratingMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RatingMaster ratingMaster : ratingMasters) {
			entityCache.removeResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
				RatingMasterImpl.class, ratingMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rating master with the primary key. Does not add the rating master to the database.
	 *
	 * @param ratingId the primary key for the new rating master
	 * @return the new rating master
	 */
	@Override
	public RatingMaster create(long ratingId) {
		RatingMaster ratingMaster = new RatingMasterImpl();

		ratingMaster.setNew(true);
		ratingMaster.setPrimaryKey(ratingId);

		ratingMaster.setCompanyId(companyProvider.getCompanyId());

		return ratingMaster;
	}

	/**
	 * Removes the rating master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ratingId the primary key of the rating master
	 * @return the rating master that was removed
	 * @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	 */
	@Override
	public RatingMaster remove(long ratingId)
		throws NoSuchRatingMasterException {
		return remove((Serializable)ratingId);
	}

	/**
	 * Removes the rating master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rating master
	 * @return the rating master that was removed
	 * @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	 */
	@Override
	public RatingMaster remove(Serializable primaryKey)
		throws NoSuchRatingMasterException {
		Session session = null;

		try {
			session = openSession();

			RatingMaster ratingMaster = (RatingMaster)session.get(RatingMasterImpl.class,
					primaryKey);

			if (ratingMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRatingMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ratingMaster);
		}
		catch (NoSuchRatingMasterException nsee) {
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
	protected RatingMaster removeImpl(RatingMaster ratingMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ratingMaster)) {
				ratingMaster = (RatingMaster)session.get(RatingMasterImpl.class,
						ratingMaster.getPrimaryKeyObj());
			}

			if (ratingMaster != null) {
				session.delete(ratingMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ratingMaster != null) {
			clearCache(ratingMaster);
		}

		return ratingMaster;
	}

	@Override
	public RatingMaster updateImpl(RatingMaster ratingMaster) {
		boolean isNew = ratingMaster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ratingMaster.isNew()) {
				session.save(ratingMaster);

				ratingMaster.setNew(false);
			}
			else {
				ratingMaster = (RatingMaster)session.merge(ratingMaster);
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

		entityCache.putResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
			RatingMasterImpl.class, ratingMaster.getPrimaryKey(), ratingMaster,
			false);

		ratingMaster.resetOriginalValues();

		return ratingMaster;
	}

	/**
	 * Returns the rating master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating master
	 * @return the rating master
	 * @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	 */
	@Override
	public RatingMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRatingMasterException {
		RatingMaster ratingMaster = fetchByPrimaryKey(primaryKey);

		if (ratingMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRatingMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ratingMaster;
	}

	/**
	 * Returns the rating master with the primary key or throws a {@link NoSuchRatingMasterException} if it could not be found.
	 *
	 * @param ratingId the primary key of the rating master
	 * @return the rating master
	 * @throws NoSuchRatingMasterException if a rating master with the primary key could not be found
	 */
	@Override
	public RatingMaster findByPrimaryKey(long ratingId)
		throws NoSuchRatingMasterException {
		return findByPrimaryKey((Serializable)ratingId);
	}

	/**
	 * Returns the rating master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating master
	 * @return the rating master, or <code>null</code> if a rating master with the primary key could not be found
	 */
	@Override
	public RatingMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
				RatingMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RatingMaster ratingMaster = (RatingMaster)serializable;

		if (ratingMaster == null) {
			Session session = null;

			try {
				session = openSession();

				ratingMaster = (RatingMaster)session.get(RatingMasterImpl.class,
						primaryKey);

				if (ratingMaster != null) {
					cacheResult(ratingMaster);
				}
				else {
					entityCache.putResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
						RatingMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
					RatingMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ratingMaster;
	}

	/**
	 * Returns the rating master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ratingId the primary key of the rating master
	 * @return the rating master, or <code>null</code> if a rating master with the primary key could not be found
	 */
	@Override
	public RatingMaster fetchByPrimaryKey(long ratingId) {
		return fetchByPrimaryKey((Serializable)ratingId);
	}

	@Override
	public Map<Serializable, RatingMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RatingMaster> map = new HashMap<Serializable, RatingMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RatingMaster ratingMaster = fetchByPrimaryKey(primaryKey);

			if (ratingMaster != null) {
				map.put(primaryKey, ratingMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
					RatingMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RatingMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RATINGMASTER_WHERE_PKS_IN);

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

			for (RatingMaster ratingMaster : (List<RatingMaster>)q.list()) {
				map.put(ratingMaster.getPrimaryKeyObj(), ratingMaster);

				cacheResult(ratingMaster);

				uncachedPrimaryKeys.remove(ratingMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RatingMasterModelImpl.ENTITY_CACHE_ENABLED,
					RatingMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the rating masters.
	 *
	 * @return the rating masters
	 */
	@Override
	public List<RatingMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating masters
	 * @param end the upper bound of the range of rating masters (not inclusive)
	 * @return the range of rating masters
	 */
	@Override
	public List<RatingMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating masters
	 * @param end the upper bound of the range of rating masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rating masters
	 */
	@Override
	public List<RatingMaster> findAll(int start, int end,
		OrderByComparator<RatingMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rating masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RatingMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating masters
	 * @param end the upper bound of the range of rating masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of rating masters
	 */
	@Override
	public List<RatingMaster> findAll(int start, int end,
		OrderByComparator<RatingMaster> orderByComparator,
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

		List<RatingMaster> list = null;

		if (retrieveFromCache) {
			list = (List<RatingMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RATINGMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RATINGMASTER;

				if (pagination) {
					sql = sql.concat(RatingMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RatingMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RatingMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rating masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RatingMaster ratingMaster : findAll()) {
			remove(ratingMaster);
		}
	}

	/**
	 * Returns the number of rating masters.
	 *
	 * @return the number of rating masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RATINGMASTER);

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
		return RatingMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rating master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RatingMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_RATINGMASTER = "SELECT ratingMaster FROM RatingMaster ratingMaster";
	private static final String _SQL_SELECT_RATINGMASTER_WHERE_PKS_IN = "SELECT ratingMaster FROM RatingMaster ratingMaster WHERE ratingId IN (";
	private static final String _SQL_COUNT_RATINGMASTER = "SELECT COUNT(ratingMaster) FROM RatingMaster ratingMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ratingMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RatingMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(RatingMasterPersistenceImpl.class);
}