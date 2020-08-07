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

import com.liferay.famocom.erpcloud.exception.NoSuchBillingTableException;
import com.liferay.famocom.erpcloud.model.BillingTable;
import com.liferay.famocom.erpcloud.model.impl.BillingTableImpl;
import com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.BillingTablePersistence;

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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the billing table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BillingTablePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.BillingTableUtil
 * @generated
 */
@ProviderType
public class BillingTablePersistenceImpl extends BasePersistenceImpl<BillingTable>
	implements BillingTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BillingTableUtil} to access the billing table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BillingTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
			BillingTableModelImpl.FINDER_CACHE_ENABLED, BillingTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
			BillingTableModelImpl.FINDER_CACHE_ENABLED, BillingTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
			BillingTableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BillingTablePersistenceImpl() {
		setModelClass(BillingTable.class);
	}

	/**
	 * Caches the billing table in the entity cache if it is enabled.
	 *
	 * @param billingTable the billing table
	 */
	@Override
	public void cacheResult(BillingTable billingTable) {
		entityCache.putResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
			BillingTableImpl.class, billingTable.getPrimaryKey(), billingTable);

		billingTable.resetOriginalValues();
	}

	/**
	 * Caches the billing tables in the entity cache if it is enabled.
	 *
	 * @param billingTables the billing tables
	 */
	@Override
	public void cacheResult(List<BillingTable> billingTables) {
		for (BillingTable billingTable : billingTables) {
			if (entityCache.getResult(
						BillingTableModelImpl.ENTITY_CACHE_ENABLED,
						BillingTableImpl.class, billingTable.getPrimaryKey()) == null) {
				cacheResult(billingTable);
			}
			else {
				billingTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all billing tables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BillingTableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the billing table.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BillingTable billingTable) {
		entityCache.removeResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
			BillingTableImpl.class, billingTable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BillingTable> billingTables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BillingTable billingTable : billingTables) {
			entityCache.removeResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
				BillingTableImpl.class, billingTable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new billing table with the primary key. Does not add the billing table to the database.
	 *
	 * @param billingId the primary key for the new billing table
	 * @return the new billing table
	 */
	@Override
	public BillingTable create(long billingId) {
		BillingTable billingTable = new BillingTableImpl();

		billingTable.setNew(true);
		billingTable.setPrimaryKey(billingId);

		return billingTable;
	}

	/**
	 * Removes the billing table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billingId the primary key of the billing table
	 * @return the billing table that was removed
	 * @throws NoSuchBillingTableException if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable remove(long billingId)
		throws NoSuchBillingTableException {
		return remove((Serializable)billingId);
	}

	/**
	 * Removes the billing table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the billing table
	 * @return the billing table that was removed
	 * @throws NoSuchBillingTableException if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable remove(Serializable primaryKey)
		throws NoSuchBillingTableException {
		Session session = null;

		try {
			session = openSession();

			BillingTable billingTable = (BillingTable)session.get(BillingTableImpl.class,
					primaryKey);

			if (billingTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBillingTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(billingTable);
		}
		catch (NoSuchBillingTableException nsee) {
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
	protected BillingTable removeImpl(BillingTable billingTable) {
		billingTable = toUnwrappedModel(billingTable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billingTable)) {
				billingTable = (BillingTable)session.get(BillingTableImpl.class,
						billingTable.getPrimaryKeyObj());
			}

			if (billingTable != null) {
				session.delete(billingTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (billingTable != null) {
			clearCache(billingTable);
		}

		return billingTable;
	}

	@Override
	public BillingTable updateImpl(BillingTable billingTable) {
		billingTable = toUnwrappedModel(billingTable);

		boolean isNew = billingTable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (billingTable.isNew()) {
				session.save(billingTable);

				billingTable.setNew(false);
			}
			else {
				billingTable = (BillingTable)session.merge(billingTable);
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

		entityCache.putResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
			BillingTableImpl.class, billingTable.getPrimaryKey(), billingTable,
			false);

		billingTable.resetOriginalValues();

		return billingTable;
	}

	protected BillingTable toUnwrappedModel(BillingTable billingTable) {
		if (billingTable instanceof BillingTableImpl) {
			return billingTable;
		}

		BillingTableImpl billingTableImpl = new BillingTableImpl();

		billingTableImpl.setNew(billingTable.isNew());
		billingTableImpl.setPrimaryKey(billingTable.getPrimaryKey());

		billingTableImpl.setBillingId(billingTable.getBillingId());
		billingTableImpl.setProjectId(billingTable.getProjectId());
		billingTableImpl.setClientId(billingTable.getClientId());
		billingTableImpl.setMilestoneName(billingTable.getMilestoneName());
		billingTableImpl.setDueDate(billingTable.getDueDate());
		billingTableImpl.setCheckGST(billingTable.getCheckGST());
		billingTableImpl.setAmount(billingTable.getAmount());
		billingTableImpl.setFileId(billingTable.getFileId());
		billingTableImpl.setFileName(billingTable.getFileName());
		billingTableImpl.setStatus(billingTable.getStatus());

		return billingTableImpl;
	}

	/**
	 * Returns the billing table with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing table
	 * @return the billing table
	 * @throws NoSuchBillingTableException if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBillingTableException {
		BillingTable billingTable = fetchByPrimaryKey(primaryKey);

		if (billingTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBillingTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return billingTable;
	}

	/**
	 * Returns the billing table with the primary key or throws a {@link NoSuchBillingTableException} if it could not be found.
	 *
	 * @param billingId the primary key of the billing table
	 * @return the billing table
	 * @throws NoSuchBillingTableException if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable findByPrimaryKey(long billingId)
		throws NoSuchBillingTableException {
		return findByPrimaryKey((Serializable)billingId);
	}

	/**
	 * Returns the billing table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing table
	 * @return the billing table, or <code>null</code> if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
				BillingTableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BillingTable billingTable = (BillingTable)serializable;

		if (billingTable == null) {
			Session session = null;

			try {
				session = openSession();

				billingTable = (BillingTable)session.get(BillingTableImpl.class,
						primaryKey);

				if (billingTable != null) {
					cacheResult(billingTable);
				}
				else {
					entityCache.putResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
						BillingTableImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
					BillingTableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return billingTable;
	}

	/**
	 * Returns the billing table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param billingId the primary key of the billing table
	 * @return the billing table, or <code>null</code> if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable fetchByPrimaryKey(long billingId) {
		return fetchByPrimaryKey((Serializable)billingId);
	}

	@Override
	public Map<Serializable, BillingTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BillingTable> map = new HashMap<Serializable, BillingTable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BillingTable billingTable = fetchByPrimaryKey(primaryKey);

			if (billingTable != null) {
				map.put(primaryKey, billingTable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
					BillingTableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BillingTable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BILLINGTABLE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (BillingTable billingTable : (List<BillingTable>)q.list()) {
				map.put(billingTable.getPrimaryKeyObj(), billingTable);

				cacheResult(billingTable);

				uncachedPrimaryKeys.remove(billingTable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BillingTableModelImpl.ENTITY_CACHE_ENABLED,
					BillingTableImpl.class, primaryKey, nullModel);
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
	 * Returns all the billing tables.
	 *
	 * @return the billing tables
	 */
	@Override
	public List<BillingTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billing tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing tables
	 * @param end the upper bound of the range of billing tables (not inclusive)
	 * @return the range of billing tables
	 */
	@Override
	public List<BillingTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the billing tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing tables
	 * @param end the upper bound of the range of billing tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billing tables
	 */
	@Override
	public List<BillingTable> findAll(int start, int end,
		OrderByComparator<BillingTable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billing tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing tables
	 * @param end the upper bound of the range of billing tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of billing tables
	 */
	@Override
	public List<BillingTable> findAll(int start, int end,
		OrderByComparator<BillingTable> orderByComparator,
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

		List<BillingTable> list = null;

		if (retrieveFromCache) {
			list = (List<BillingTable>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BILLINGTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BILLINGTABLE;

				if (pagination) {
					sql = sql.concat(BillingTableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BillingTable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BillingTable>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the billing tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BillingTable billingTable : findAll()) {
			remove(billingTable);
		}
	}

	/**
	 * Returns the number of billing tables.
	 *
	 * @return the number of billing tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BILLINGTABLE);

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
		return BillingTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the billing table persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BillingTableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BILLINGTABLE = "SELECT billingTable FROM BillingTable billingTable";
	private static final String _SQL_SELECT_BILLINGTABLE_WHERE_PKS_IN = "SELECT billingTable FROM BillingTable billingTable WHERE billingId IN (";
	private static final String _SQL_COUNT_BILLINGTABLE = "SELECT COUNT(billingTable) FROM BillingTable billingTable";
	private static final String _ORDER_BY_ENTITY_ALIAS = "billingTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BillingTable exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BillingTablePersistenceImpl.class);
}