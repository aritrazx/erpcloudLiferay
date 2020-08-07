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

import com.liferay.famocom.erpcloud.exception.NoSuchMilestoneException;
import com.liferay.famocom.erpcloud.model.Milestone;
import com.liferay.famocom.erpcloud.model.impl.MilestoneImpl;
import com.liferay.famocom.erpcloud.model.impl.MilestoneModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.MilestonePersistence;

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
 * The persistence implementation for the milestone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see MilestonePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.MilestoneUtil
 * @generated
 */
@ProviderType
public class MilestonePersistenceImpl extends BasePersistenceImpl<Milestone>
	implements MilestonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MilestoneUtil} to access the milestone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MilestoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
			MilestoneModelImpl.FINDER_CACHE_ENABLED, MilestoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
			MilestoneModelImpl.FINDER_CACHE_ENABLED, MilestoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
			MilestoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MilestonePersistenceImpl() {
		setModelClass(Milestone.class);
	}

	/**
	 * Caches the milestone in the entity cache if it is enabled.
	 *
	 * @param milestone the milestone
	 */
	@Override
	public void cacheResult(Milestone milestone) {
		entityCache.putResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
			MilestoneImpl.class, milestone.getPrimaryKey(), milestone);

		milestone.resetOriginalValues();
	}

	/**
	 * Caches the milestones in the entity cache if it is enabled.
	 *
	 * @param milestones the milestones
	 */
	@Override
	public void cacheResult(List<Milestone> milestones) {
		for (Milestone milestone : milestones) {
			if (entityCache.getResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
						MilestoneImpl.class, milestone.getPrimaryKey()) == null) {
				cacheResult(milestone);
			}
			else {
				milestone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all milestones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MilestoneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the milestone.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Milestone milestone) {
		entityCache.removeResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
			MilestoneImpl.class, milestone.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Milestone> milestones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Milestone milestone : milestones) {
			entityCache.removeResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
				MilestoneImpl.class, milestone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new milestone with the primary key. Does not add the milestone to the database.
	 *
	 * @param milestoneId the primary key for the new milestone
	 * @return the new milestone
	 */
	@Override
	public Milestone create(long milestoneId) {
		Milestone milestone = new MilestoneImpl();

		milestone.setNew(true);
		milestone.setPrimaryKey(milestoneId);

		return milestone;
	}

	/**
	 * Removes the milestone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param milestoneId the primary key of the milestone
	 * @return the milestone that was removed
	 * @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	 */
	@Override
	public Milestone remove(long milestoneId) throws NoSuchMilestoneException {
		return remove((Serializable)milestoneId);
	}

	/**
	 * Removes the milestone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the milestone
	 * @return the milestone that was removed
	 * @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	 */
	@Override
	public Milestone remove(Serializable primaryKey)
		throws NoSuchMilestoneException {
		Session session = null;

		try {
			session = openSession();

			Milestone milestone = (Milestone)session.get(MilestoneImpl.class,
					primaryKey);

			if (milestone == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMilestoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(milestone);
		}
		catch (NoSuchMilestoneException nsee) {
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
	protected Milestone removeImpl(Milestone milestone) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(milestone)) {
				milestone = (Milestone)session.get(MilestoneImpl.class,
						milestone.getPrimaryKeyObj());
			}

			if (milestone != null) {
				session.delete(milestone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (milestone != null) {
			clearCache(milestone);
		}

		return milestone;
	}

	@Override
	public Milestone updateImpl(Milestone milestone) {
		boolean isNew = milestone.isNew();

		Session session = null;

		try {
			session = openSession();

			if (milestone.isNew()) {
				session.save(milestone);

				milestone.setNew(false);
			}
			else {
				milestone = (Milestone)session.merge(milestone);
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

		entityCache.putResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
			MilestoneImpl.class, milestone.getPrimaryKey(), milestone, false);

		milestone.resetOriginalValues();

		return milestone;
	}

	/**
	 * Returns the milestone with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the milestone
	 * @return the milestone
	 * @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	 */
	@Override
	public Milestone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMilestoneException {
		Milestone milestone = fetchByPrimaryKey(primaryKey);

		if (milestone == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMilestoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return milestone;
	}

	/**
	 * Returns the milestone with the primary key or throws a {@link NoSuchMilestoneException} if it could not be found.
	 *
	 * @param milestoneId the primary key of the milestone
	 * @return the milestone
	 * @throws NoSuchMilestoneException if a milestone with the primary key could not be found
	 */
	@Override
	public Milestone findByPrimaryKey(long milestoneId)
		throws NoSuchMilestoneException {
		return findByPrimaryKey((Serializable)milestoneId);
	}

	/**
	 * Returns the milestone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the milestone
	 * @return the milestone, or <code>null</code> if a milestone with the primary key could not be found
	 */
	@Override
	public Milestone fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
				MilestoneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Milestone milestone = (Milestone)serializable;

		if (milestone == null) {
			Session session = null;

			try {
				session = openSession();

				milestone = (Milestone)session.get(MilestoneImpl.class,
						primaryKey);

				if (milestone != null) {
					cacheResult(milestone);
				}
				else {
					entityCache.putResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
						MilestoneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
					MilestoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return milestone;
	}

	/**
	 * Returns the milestone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param milestoneId the primary key of the milestone
	 * @return the milestone, or <code>null</code> if a milestone with the primary key could not be found
	 */
	@Override
	public Milestone fetchByPrimaryKey(long milestoneId) {
		return fetchByPrimaryKey((Serializable)milestoneId);
	}

	@Override
	public Map<Serializable, Milestone> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Milestone> map = new HashMap<Serializable, Milestone>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Milestone milestone = fetchByPrimaryKey(primaryKey);

			if (milestone != null) {
				map.put(primaryKey, milestone);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
					MilestoneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Milestone)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MILESTONE_WHERE_PKS_IN);

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

			for (Milestone milestone : (List<Milestone>)q.list()) {
				map.put(milestone.getPrimaryKeyObj(), milestone);

				cacheResult(milestone);

				uncachedPrimaryKeys.remove(milestone.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MilestoneModelImpl.ENTITY_CACHE_ENABLED,
					MilestoneImpl.class, primaryKey, nullModel);
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
	 * Returns all the milestones.
	 *
	 * @return the milestones
	 */
	@Override
	public List<Milestone> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the milestones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MilestoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of milestones
	 * @param end the upper bound of the range of milestones (not inclusive)
	 * @return the range of milestones
	 */
	@Override
	public List<Milestone> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the milestones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MilestoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of milestones
	 * @param end the upper bound of the range of milestones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of milestones
	 */
	@Override
	public List<Milestone> findAll(int start, int end,
		OrderByComparator<Milestone> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the milestones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MilestoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of milestones
	 * @param end the upper bound of the range of milestones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of milestones
	 */
	@Override
	public List<Milestone> findAll(int start, int end,
		OrderByComparator<Milestone> orderByComparator,
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

		List<Milestone> list = null;

		if (retrieveFromCache) {
			list = (List<Milestone>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MILESTONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MILESTONE;

				if (pagination) {
					sql = sql.concat(MilestoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Milestone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Milestone>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the milestones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Milestone milestone : findAll()) {
			remove(milestone);
		}
	}

	/**
	 * Returns the number of milestones.
	 *
	 * @return the number of milestones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MILESTONE);

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
		return MilestoneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the milestone persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MilestoneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MILESTONE = "SELECT milestone FROM Milestone milestone";
	private static final String _SQL_SELECT_MILESTONE_WHERE_PKS_IN = "SELECT milestone FROM Milestone milestone WHERE milestoneId IN (";
	private static final String _SQL_COUNT_MILESTONE = "SELECT COUNT(milestone) FROM Milestone milestone";
	private static final String _ORDER_BY_ENTITY_ALIAS = "milestone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Milestone exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(MilestonePersistenceImpl.class);
}