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

import com.liferay.famocom.erpcloud.exception.NoSuchExpCategoryException;
import com.liferay.famocom.erpcloud.model.ExpCategory;
import com.liferay.famocom.erpcloud.model.impl.ExpCategoryImpl;
import com.liferay.famocom.erpcloud.model.impl.ExpCategoryModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ExpCategoryPersistence;

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
 * The persistence implementation for the exp category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ExpCategoryPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ExpCategoryUtil
 * @generated
 */
@ProviderType
public class ExpCategoryPersistenceImpl extends BasePersistenceImpl<ExpCategory>
	implements ExpCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpCategoryUtil} to access the exp category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpCategoryModelImpl.FINDER_CACHE_ENABLED, ExpCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpCategoryModelImpl.FINDER_CACHE_ENABLED, ExpCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ExpCategoryPersistenceImpl() {
		setModelClass(ExpCategory.class);
	}

	/**
	 * Caches the exp category in the entity cache if it is enabled.
	 *
	 * @param expCategory the exp category
	 */
	@Override
	public void cacheResult(ExpCategory expCategory) {
		entityCache.putResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpCategoryImpl.class, expCategory.getPrimaryKey(), expCategory);

		expCategory.resetOriginalValues();
	}

	/**
	 * Caches the exp categories in the entity cache if it is enabled.
	 *
	 * @param expCategories the exp categories
	 */
	@Override
	public void cacheResult(List<ExpCategory> expCategories) {
		for (ExpCategory expCategory : expCategories) {
			if (entityCache.getResult(
						ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ExpCategoryImpl.class, expCategory.getPrimaryKey()) == null) {
				cacheResult(expCategory);
			}
			else {
				expCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all exp categories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the exp category.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpCategory expCategory) {
		entityCache.removeResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpCategoryImpl.class, expCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExpCategory> expCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExpCategory expCategory : expCategories) {
			entityCache.removeResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ExpCategoryImpl.class, expCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new exp category with the primary key. Does not add the exp category to the database.
	 *
	 * @param catId the primary key for the new exp category
	 * @return the new exp category
	 */
	@Override
	public ExpCategory create(long catId) {
		ExpCategory expCategory = new ExpCategoryImpl();

		expCategory.setNew(true);
		expCategory.setPrimaryKey(catId);

		expCategory.setCompanyId(companyProvider.getCompanyId());

		return expCategory;
	}

	/**
	 * Removes the exp category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param catId the primary key of the exp category
	 * @return the exp category that was removed
	 * @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	 */
	@Override
	public ExpCategory remove(long catId) throws NoSuchExpCategoryException {
		return remove((Serializable)catId);
	}

	/**
	 * Removes the exp category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exp category
	 * @return the exp category that was removed
	 * @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	 */
	@Override
	public ExpCategory remove(Serializable primaryKey)
		throws NoSuchExpCategoryException {
		Session session = null;

		try {
			session = openSession();

			ExpCategory expCategory = (ExpCategory)session.get(ExpCategoryImpl.class,
					primaryKey);

			if (expCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expCategory);
		}
		catch (NoSuchExpCategoryException nsee) {
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
	protected ExpCategory removeImpl(ExpCategory expCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expCategory)) {
				expCategory = (ExpCategory)session.get(ExpCategoryImpl.class,
						expCategory.getPrimaryKeyObj());
			}

			if (expCategory != null) {
				session.delete(expCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expCategory != null) {
			clearCache(expCategory);
		}

		return expCategory;
	}

	@Override
	public ExpCategory updateImpl(ExpCategory expCategory) {
		boolean isNew = expCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (expCategory.isNew()) {
				session.save(expCategory);

				expCategory.setNew(false);
			}
			else {
				expCategory = (ExpCategory)session.merge(expCategory);
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

		entityCache.putResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ExpCategoryImpl.class, expCategory.getPrimaryKey(), expCategory,
			false);

		expCategory.resetOriginalValues();

		return expCategory;
	}

	/**
	 * Returns the exp category with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the exp category
	 * @return the exp category
	 * @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	 */
	@Override
	public ExpCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpCategoryException {
		ExpCategory expCategory = fetchByPrimaryKey(primaryKey);

		if (expCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expCategory;
	}

	/**
	 * Returns the exp category with the primary key or throws a {@link NoSuchExpCategoryException} if it could not be found.
	 *
	 * @param catId the primary key of the exp category
	 * @return the exp category
	 * @throws NoSuchExpCategoryException if a exp category with the primary key could not be found
	 */
	@Override
	public ExpCategory findByPrimaryKey(long catId)
		throws NoSuchExpCategoryException {
		return findByPrimaryKey((Serializable)catId);
	}

	/**
	 * Returns the exp category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exp category
	 * @return the exp category, or <code>null</code> if a exp category with the primary key could not be found
	 */
	@Override
	public ExpCategory fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ExpCategoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExpCategory expCategory = (ExpCategory)serializable;

		if (expCategory == null) {
			Session session = null;

			try {
				session = openSession();

				expCategory = (ExpCategory)session.get(ExpCategoryImpl.class,
						primaryKey);

				if (expCategory != null) {
					cacheResult(expCategory);
				}
				else {
					entityCache.putResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ExpCategoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ExpCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expCategory;
	}

	/**
	 * Returns the exp category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param catId the primary key of the exp category
	 * @return the exp category, or <code>null</code> if a exp category with the primary key could not be found
	 */
	@Override
	public ExpCategory fetchByPrimaryKey(long catId) {
		return fetchByPrimaryKey((Serializable)catId);
	}

	@Override
	public Map<Serializable, ExpCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExpCategory> map = new HashMap<Serializable, ExpCategory>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExpCategory expCategory = fetchByPrimaryKey(primaryKey);

			if (expCategory != null) {
				map.put(primaryKey, expCategory);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ExpCategoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExpCategory)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXPCATEGORY_WHERE_PKS_IN);

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

			for (ExpCategory expCategory : (List<ExpCategory>)q.list()) {
				map.put(expCategory.getPrimaryKeyObj(), expCategory);

				cacheResult(expCategory);

				uncachedPrimaryKeys.remove(expCategory.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExpCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ExpCategoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the exp categories.
	 *
	 * @return the exp categories
	 */
	@Override
	public List<ExpCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the exp categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exp categories
	 * @param end the upper bound of the range of exp categories (not inclusive)
	 * @return the range of exp categories
	 */
	@Override
	public List<ExpCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the exp categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exp categories
	 * @param end the upper bound of the range of exp categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exp categories
	 */
	@Override
	public List<ExpCategory> findAll(int start, int end,
		OrderByComparator<ExpCategory> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the exp categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of exp categories
	 * @param end the upper bound of the range of exp categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of exp categories
	 */
	@Override
	public List<ExpCategory> findAll(int start, int end,
		OrderByComparator<ExpCategory> orderByComparator,
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

		List<ExpCategory> list = null;

		if (retrieveFromCache) {
			list = (List<ExpCategory>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPCATEGORY;

				if (pagination) {
					sql = sql.concat(ExpCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExpCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExpCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the exp categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExpCategory expCategory : findAll()) {
			remove(expCategory);
		}
	}

	/**
	 * Returns the number of exp categories.
	 *
	 * @return the number of exp categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPCATEGORY);

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
		return ExpCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the exp category persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExpCategoryImpl.class.getName());
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
	private static final String _SQL_SELECT_EXPCATEGORY = "SELECT expCategory FROM ExpCategory expCategory";
	private static final String _SQL_SELECT_EXPCATEGORY_WHERE_PKS_IN = "SELECT expCategory FROM ExpCategory expCategory WHERE catId IN (";
	private static final String _SQL_COUNT_EXPCATEGORY = "SELECT COUNT(expCategory) FROM ExpCategory expCategory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExpCategory exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ExpCategoryPersistenceImpl.class);
}