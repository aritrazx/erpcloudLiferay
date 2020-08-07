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

import com.liferay.famocom.erpcloud.exception.NoSuchIncomeTaxSlabException;
import com.liferay.famocom.erpcloud.model.IncomeTaxSlab;
import com.liferay.famocom.erpcloud.model.impl.IncomeTaxSlabImpl;
import com.liferay.famocom.erpcloud.model.impl.IncomeTaxSlabModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.IncomeTaxSlabPersistence;

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
 * The persistence implementation for the income tax slab service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see IncomeTaxSlabPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.IncomeTaxSlabUtil
 * @generated
 */
@ProviderType
public class IncomeTaxSlabPersistenceImpl extends BasePersistenceImpl<IncomeTaxSlab>
	implements IncomeTaxSlabPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IncomeTaxSlabUtil} to access the income tax slab persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IncomeTaxSlabImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
			IncomeTaxSlabModelImpl.FINDER_CACHE_ENABLED,
			IncomeTaxSlabImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
			IncomeTaxSlabModelImpl.FINDER_CACHE_ENABLED,
			IncomeTaxSlabImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
			IncomeTaxSlabModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public IncomeTaxSlabPersistenceImpl() {
		setModelClass(IncomeTaxSlab.class);
	}

	/**
	 * Caches the income tax slab in the entity cache if it is enabled.
	 *
	 * @param incomeTaxSlab the income tax slab
	 */
	@Override
	public void cacheResult(IncomeTaxSlab incomeTaxSlab) {
		entityCache.putResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
			IncomeTaxSlabImpl.class, incomeTaxSlab.getPrimaryKey(),
			incomeTaxSlab);

		incomeTaxSlab.resetOriginalValues();
	}

	/**
	 * Caches the income tax slabs in the entity cache if it is enabled.
	 *
	 * @param incomeTaxSlabs the income tax slabs
	 */
	@Override
	public void cacheResult(List<IncomeTaxSlab> incomeTaxSlabs) {
		for (IncomeTaxSlab incomeTaxSlab : incomeTaxSlabs) {
			if (entityCache.getResult(
						IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
						IncomeTaxSlabImpl.class, incomeTaxSlab.getPrimaryKey()) == null) {
				cacheResult(incomeTaxSlab);
			}
			else {
				incomeTaxSlab.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all income tax slabs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IncomeTaxSlabImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the income tax slab.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IncomeTaxSlab incomeTaxSlab) {
		entityCache.removeResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
			IncomeTaxSlabImpl.class, incomeTaxSlab.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<IncomeTaxSlab> incomeTaxSlabs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IncomeTaxSlab incomeTaxSlab : incomeTaxSlabs) {
			entityCache.removeResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
				IncomeTaxSlabImpl.class, incomeTaxSlab.getPrimaryKey());
		}
	}

	/**
	 * Creates a new income tax slab with the primary key. Does not add the income tax slab to the database.
	 *
	 * @param incomeTaxSlabId the primary key for the new income tax slab
	 * @return the new income tax slab
	 */
	@Override
	public IncomeTaxSlab create(long incomeTaxSlabId) {
		IncomeTaxSlab incomeTaxSlab = new IncomeTaxSlabImpl();

		incomeTaxSlab.setNew(true);
		incomeTaxSlab.setPrimaryKey(incomeTaxSlabId);

		incomeTaxSlab.setCompanyId(companyProvider.getCompanyId());

		return incomeTaxSlab;
	}

	/**
	 * Removes the income tax slab with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param incomeTaxSlabId the primary key of the income tax slab
	 * @return the income tax slab that was removed
	 * @throws NoSuchIncomeTaxSlabException if a income tax slab with the primary key could not be found
	 */
	@Override
	public IncomeTaxSlab remove(long incomeTaxSlabId)
		throws NoSuchIncomeTaxSlabException {
		return remove((Serializable)incomeTaxSlabId);
	}

	/**
	 * Removes the income tax slab with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the income tax slab
	 * @return the income tax slab that was removed
	 * @throws NoSuchIncomeTaxSlabException if a income tax slab with the primary key could not be found
	 */
	@Override
	public IncomeTaxSlab remove(Serializable primaryKey)
		throws NoSuchIncomeTaxSlabException {
		Session session = null;

		try {
			session = openSession();

			IncomeTaxSlab incomeTaxSlab = (IncomeTaxSlab)session.get(IncomeTaxSlabImpl.class,
					primaryKey);

			if (incomeTaxSlab == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIncomeTaxSlabException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(incomeTaxSlab);
		}
		catch (NoSuchIncomeTaxSlabException nsee) {
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
	protected IncomeTaxSlab removeImpl(IncomeTaxSlab incomeTaxSlab) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(incomeTaxSlab)) {
				incomeTaxSlab = (IncomeTaxSlab)session.get(IncomeTaxSlabImpl.class,
						incomeTaxSlab.getPrimaryKeyObj());
			}

			if (incomeTaxSlab != null) {
				session.delete(incomeTaxSlab);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (incomeTaxSlab != null) {
			clearCache(incomeTaxSlab);
		}

		return incomeTaxSlab;
	}

	@Override
	public IncomeTaxSlab updateImpl(IncomeTaxSlab incomeTaxSlab) {
		boolean isNew = incomeTaxSlab.isNew();

		Session session = null;

		try {
			session = openSession();

			if (incomeTaxSlab.isNew()) {
				session.save(incomeTaxSlab);

				incomeTaxSlab.setNew(false);
			}
			else {
				incomeTaxSlab = (IncomeTaxSlab)session.merge(incomeTaxSlab);
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

		entityCache.putResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
			IncomeTaxSlabImpl.class, incomeTaxSlab.getPrimaryKey(),
			incomeTaxSlab, false);

		incomeTaxSlab.resetOriginalValues();

		return incomeTaxSlab;
	}

	/**
	 * Returns the income tax slab with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the income tax slab
	 * @return the income tax slab
	 * @throws NoSuchIncomeTaxSlabException if a income tax slab with the primary key could not be found
	 */
	@Override
	public IncomeTaxSlab findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIncomeTaxSlabException {
		IncomeTaxSlab incomeTaxSlab = fetchByPrimaryKey(primaryKey);

		if (incomeTaxSlab == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIncomeTaxSlabException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return incomeTaxSlab;
	}

	/**
	 * Returns the income tax slab with the primary key or throws a {@link NoSuchIncomeTaxSlabException} if it could not be found.
	 *
	 * @param incomeTaxSlabId the primary key of the income tax slab
	 * @return the income tax slab
	 * @throws NoSuchIncomeTaxSlabException if a income tax slab with the primary key could not be found
	 */
	@Override
	public IncomeTaxSlab findByPrimaryKey(long incomeTaxSlabId)
		throws NoSuchIncomeTaxSlabException {
		return findByPrimaryKey((Serializable)incomeTaxSlabId);
	}

	/**
	 * Returns the income tax slab with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the income tax slab
	 * @return the income tax slab, or <code>null</code> if a income tax slab with the primary key could not be found
	 */
	@Override
	public IncomeTaxSlab fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
				IncomeTaxSlabImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		IncomeTaxSlab incomeTaxSlab = (IncomeTaxSlab)serializable;

		if (incomeTaxSlab == null) {
			Session session = null;

			try {
				session = openSession();

				incomeTaxSlab = (IncomeTaxSlab)session.get(IncomeTaxSlabImpl.class,
						primaryKey);

				if (incomeTaxSlab != null) {
					cacheResult(incomeTaxSlab);
				}
				else {
					entityCache.putResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
						IncomeTaxSlabImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
					IncomeTaxSlabImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return incomeTaxSlab;
	}

	/**
	 * Returns the income tax slab with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param incomeTaxSlabId the primary key of the income tax slab
	 * @return the income tax slab, or <code>null</code> if a income tax slab with the primary key could not be found
	 */
	@Override
	public IncomeTaxSlab fetchByPrimaryKey(long incomeTaxSlabId) {
		return fetchByPrimaryKey((Serializable)incomeTaxSlabId);
	}

	@Override
	public Map<Serializable, IncomeTaxSlab> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, IncomeTaxSlab> map = new HashMap<Serializable, IncomeTaxSlab>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			IncomeTaxSlab incomeTaxSlab = fetchByPrimaryKey(primaryKey);

			if (incomeTaxSlab != null) {
				map.put(primaryKey, incomeTaxSlab);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
					IncomeTaxSlabImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (IncomeTaxSlab)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_INCOMETAXSLAB_WHERE_PKS_IN);

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

			for (IncomeTaxSlab incomeTaxSlab : (List<IncomeTaxSlab>)q.list()) {
				map.put(incomeTaxSlab.getPrimaryKeyObj(), incomeTaxSlab);

				cacheResult(incomeTaxSlab);

				uncachedPrimaryKeys.remove(incomeTaxSlab.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(IncomeTaxSlabModelImpl.ENTITY_CACHE_ENABLED,
					IncomeTaxSlabImpl.class, primaryKey, nullModel);
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
	 * Returns all the income tax slabs.
	 *
	 * @return the income tax slabs
	 */
	@Override
	public List<IncomeTaxSlab> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the income tax slabs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of income tax slabs
	 * @param end the upper bound of the range of income tax slabs (not inclusive)
	 * @return the range of income tax slabs
	 */
	@Override
	public List<IncomeTaxSlab> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the income tax slabs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of income tax slabs
	 * @param end the upper bound of the range of income tax slabs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of income tax slabs
	 */
	@Override
	public List<IncomeTaxSlab> findAll(int start, int end,
		OrderByComparator<IncomeTaxSlab> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the income tax slabs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IncomeTaxSlabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of income tax slabs
	 * @param end the upper bound of the range of income tax slabs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of income tax slabs
	 */
	@Override
	public List<IncomeTaxSlab> findAll(int start, int end,
		OrderByComparator<IncomeTaxSlab> orderByComparator,
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

		List<IncomeTaxSlab> list = null;

		if (retrieveFromCache) {
			list = (List<IncomeTaxSlab>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_INCOMETAXSLAB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INCOMETAXSLAB;

				if (pagination) {
					sql = sql.concat(IncomeTaxSlabModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IncomeTaxSlab>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IncomeTaxSlab>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the income tax slabs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IncomeTaxSlab incomeTaxSlab : findAll()) {
			remove(incomeTaxSlab);
		}
	}

	/**
	 * Returns the number of income tax slabs.
	 *
	 * @return the number of income tax slabs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INCOMETAXSLAB);

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
		return IncomeTaxSlabModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the income tax slab persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(IncomeTaxSlabImpl.class.getName());
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
	private static final String _SQL_SELECT_INCOMETAXSLAB = "SELECT incomeTaxSlab FROM IncomeTaxSlab incomeTaxSlab";
	private static final String _SQL_SELECT_INCOMETAXSLAB_WHERE_PKS_IN = "SELECT incomeTaxSlab FROM IncomeTaxSlab incomeTaxSlab WHERE incomeTaxSlabId IN (";
	private static final String _SQL_COUNT_INCOMETAXSLAB = "SELECT COUNT(incomeTaxSlab) FROM IncomeTaxSlab incomeTaxSlab";
	private static final String _ORDER_BY_ENTITY_ALIAS = "incomeTaxSlab.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IncomeTaxSlab exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(IncomeTaxSlabPersistenceImpl.class);
}