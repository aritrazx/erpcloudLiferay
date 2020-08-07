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

import com.liferay.famocom.erpcloud.exception.NoSuchSkillSetException;
import com.liferay.famocom.erpcloud.model.SkillSet;
import com.liferay.famocom.erpcloud.model.impl.SkillSetImpl;
import com.liferay.famocom.erpcloud.model.impl.SkillSetModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.SkillSetPersistence;

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
 * The persistence implementation for the skill set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see SkillSetPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.SkillSetUtil
 * @generated
 */
@ProviderType
public class SkillSetPersistenceImpl extends BasePersistenceImpl<SkillSet>
	implements SkillSetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkillSetUtil} to access the skill set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkillSetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
			SkillSetModelImpl.FINDER_CACHE_ENABLED, SkillSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
			SkillSetModelImpl.FINDER_CACHE_ENABLED, SkillSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
			SkillSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SkillSetPersistenceImpl() {
		setModelClass(SkillSet.class);
	}

	/**
	 * Caches the skill set in the entity cache if it is enabled.
	 *
	 * @param skillSet the skill set
	 */
	@Override
	public void cacheResult(SkillSet skillSet) {
		entityCache.putResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
			SkillSetImpl.class, skillSet.getPrimaryKey(), skillSet);

		skillSet.resetOriginalValues();
	}

	/**
	 * Caches the skill sets in the entity cache if it is enabled.
	 *
	 * @param skillSets the skill sets
	 */
	@Override
	public void cacheResult(List<SkillSet> skillSets) {
		for (SkillSet skillSet : skillSets) {
			if (entityCache.getResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
						SkillSetImpl.class, skillSet.getPrimaryKey()) == null) {
				cacheResult(skillSet);
			}
			else {
				skillSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skill sets.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SkillSetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skill set.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkillSet skillSet) {
		entityCache.removeResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
			SkillSetImpl.class, skillSet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SkillSet> skillSets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SkillSet skillSet : skillSets) {
			entityCache.removeResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
				SkillSetImpl.class, skillSet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new skill set with the primary key. Does not add the skill set to the database.
	 *
	 * @param SkillId the primary key for the new skill set
	 * @return the new skill set
	 */
	@Override
	public SkillSet create(long SkillId) {
		SkillSet skillSet = new SkillSetImpl();

		skillSet.setNew(true);
		skillSet.setPrimaryKey(SkillId);

		return skillSet;
	}

	/**
	 * Removes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SkillId the primary key of the skill set
	 * @return the skill set that was removed
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet remove(long SkillId) throws NoSuchSkillSetException {
		return remove((Serializable)SkillId);
	}

	/**
	 * Removes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skill set
	 * @return the skill set that was removed
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet remove(Serializable primaryKey)
		throws NoSuchSkillSetException {
		Session session = null;

		try {
			session = openSession();

			SkillSet skillSet = (SkillSet)session.get(SkillSetImpl.class,
					primaryKey);

			if (skillSet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkillSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skillSet);
		}
		catch (NoSuchSkillSetException nsee) {
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
	protected SkillSet removeImpl(SkillSet skillSet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skillSet)) {
				skillSet = (SkillSet)session.get(SkillSetImpl.class,
						skillSet.getPrimaryKeyObj());
			}

			if (skillSet != null) {
				session.delete(skillSet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skillSet != null) {
			clearCache(skillSet);
		}

		return skillSet;
	}

	@Override
	public SkillSet updateImpl(SkillSet skillSet) {
		boolean isNew = skillSet.isNew();

		Session session = null;

		try {
			session = openSession();

			if (skillSet.isNew()) {
				session.save(skillSet);

				skillSet.setNew(false);
			}
			else {
				skillSet = (SkillSet)session.merge(skillSet);
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

		entityCache.putResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
			SkillSetImpl.class, skillSet.getPrimaryKey(), skillSet, false);

		skillSet.resetOriginalValues();

		return skillSet;
	}

	/**
	 * Returns the skill set with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill set
	 * @return the skill set
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkillSetException {
		SkillSet skillSet = fetchByPrimaryKey(primaryKey);

		if (skillSet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkillSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skillSet;
	}

	/**
	 * Returns the skill set with the primary key or throws a {@link NoSuchSkillSetException} if it could not be found.
	 *
	 * @param SkillId the primary key of the skill set
	 * @return the skill set
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet findByPrimaryKey(long SkillId)
		throws NoSuchSkillSetException {
		return findByPrimaryKey((Serializable)SkillId);
	}

	/**
	 * Returns the skill set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill set
	 * @return the skill set, or <code>null</code> if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
				SkillSetImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SkillSet skillSet = (SkillSet)serializable;

		if (skillSet == null) {
			Session session = null;

			try {
				session = openSession();

				skillSet = (SkillSet)session.get(SkillSetImpl.class, primaryKey);

				if (skillSet != null) {
					cacheResult(skillSet);
				}
				else {
					entityCache.putResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
						SkillSetImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
					SkillSetImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skillSet;
	}

	/**
	 * Returns the skill set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SkillId the primary key of the skill set
	 * @return the skill set, or <code>null</code> if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet fetchByPrimaryKey(long SkillId) {
		return fetchByPrimaryKey((Serializable)SkillId);
	}

	@Override
	public Map<Serializable, SkillSet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SkillSet> map = new HashMap<Serializable, SkillSet>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SkillSet skillSet = fetchByPrimaryKey(primaryKey);

			if (skillSet != null) {
				map.put(primaryKey, skillSet);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
					SkillSetImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SkillSet)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SKILLSET_WHERE_PKS_IN);

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

			for (SkillSet skillSet : (List<SkillSet>)q.list()) {
				map.put(skillSet.getPrimaryKeyObj(), skillSet);

				cacheResult(skillSet);

				uncachedPrimaryKeys.remove(skillSet.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SkillSetModelImpl.ENTITY_CACHE_ENABLED,
					SkillSetImpl.class, primaryKey, nullModel);
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
	 * Returns all the skill sets.
	 *
	 * @return the skill sets
	 */
	@Override
	public List<SkillSet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skill sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @return the range of skill sets
	 */
	@Override
	public List<SkillSet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skill sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skill sets
	 */
	@Override
	public List<SkillSet> findAll(int start, int end,
		OrderByComparator<SkillSet> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the skill sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkillSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of skill sets
	 */
	@Override
	public List<SkillSet> findAll(int start, int end,
		OrderByComparator<SkillSet> orderByComparator, boolean retrieveFromCache) {
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

		List<SkillSet> list = null;

		if (retrieveFromCache) {
			list = (List<SkillSet>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SKILLSET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKILLSET;

				if (pagination) {
					sql = sql.concat(SkillSetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SkillSet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SkillSet>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the skill sets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SkillSet skillSet : findAll()) {
			remove(skillSet);
		}
	}

	/**
	 * Returns the number of skill sets.
	 *
	 * @return the number of skill sets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKILLSET);

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
		return SkillSetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the skill set persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SkillSetImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SKILLSET = "SELECT skillSet FROM SkillSet skillSet";
	private static final String _SQL_SELECT_SKILLSET_WHERE_PKS_IN = "SELECT skillSet FROM SkillSet skillSet WHERE SkillId IN (";
	private static final String _SQL_COUNT_SKILLSET = "SELECT COUNT(skillSet) FROM SkillSet skillSet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skillSet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SkillSet exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SkillSetPersistenceImpl.class);
}