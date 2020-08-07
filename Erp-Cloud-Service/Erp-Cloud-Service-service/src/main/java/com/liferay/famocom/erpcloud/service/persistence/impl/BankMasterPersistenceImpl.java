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

import com.liferay.famocom.erpcloud.exception.NoSuchBankMasterException;
import com.liferay.famocom.erpcloud.model.BankMaster;
import com.liferay.famocom.erpcloud.model.impl.BankMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.BankMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.BankMasterPersistence;

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
 * The persistence implementation for the bank master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BankMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.BankMasterUtil
 * @generated
 */
@ProviderType
public class BankMasterPersistenceImpl extends BasePersistenceImpl<BankMaster>
	implements BankMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BankMasterUtil} to access the bank master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BankMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
			BankMasterModelImpl.FINDER_CACHE_ENABLED, BankMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
			BankMasterModelImpl.FINDER_CACHE_ENABLED, BankMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
			BankMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BankMasterPersistenceImpl() {
		setModelClass(BankMaster.class);
	}

	/**
	 * Caches the bank master in the entity cache if it is enabled.
	 *
	 * @param bankMaster the bank master
	 */
	@Override
	public void cacheResult(BankMaster bankMaster) {
		entityCache.putResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
			BankMasterImpl.class, bankMaster.getPrimaryKey(), bankMaster);

		bankMaster.resetOriginalValues();
	}

	/**
	 * Caches the bank masters in the entity cache if it is enabled.
	 *
	 * @param bankMasters the bank masters
	 */
	@Override
	public void cacheResult(List<BankMaster> bankMasters) {
		for (BankMaster bankMaster : bankMasters) {
			if (entityCache.getResult(
						BankMasterModelImpl.ENTITY_CACHE_ENABLED,
						BankMasterImpl.class, bankMaster.getPrimaryKey()) == null) {
				cacheResult(bankMaster);
			}
			else {
				bankMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bank masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BankMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bank master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BankMaster bankMaster) {
		entityCache.removeResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
			BankMasterImpl.class, bankMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BankMaster> bankMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BankMaster bankMaster : bankMasters) {
			entityCache.removeResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
				BankMasterImpl.class, bankMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bank master with the primary key. Does not add the bank master to the database.
	 *
	 * @param bankId the primary key for the new bank master
	 * @return the new bank master
	 */
	@Override
	public BankMaster create(long bankId) {
		BankMaster bankMaster = new BankMasterImpl();

		bankMaster.setNew(true);
		bankMaster.setPrimaryKey(bankId);

		return bankMaster;
	}

	/**
	 * Removes the bank master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankId the primary key of the bank master
	 * @return the bank master that was removed
	 * @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	 */
	@Override
	public BankMaster remove(long bankId) throws NoSuchBankMasterException {
		return remove((Serializable)bankId);
	}

	/**
	 * Removes the bank master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bank master
	 * @return the bank master that was removed
	 * @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	 */
	@Override
	public BankMaster remove(Serializable primaryKey)
		throws NoSuchBankMasterException {
		Session session = null;

		try {
			session = openSession();

			BankMaster bankMaster = (BankMaster)session.get(BankMasterImpl.class,
					primaryKey);

			if (bankMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBankMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bankMaster);
		}
		catch (NoSuchBankMasterException nsee) {
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
	protected BankMaster removeImpl(BankMaster bankMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bankMaster)) {
				bankMaster = (BankMaster)session.get(BankMasterImpl.class,
						bankMaster.getPrimaryKeyObj());
			}

			if (bankMaster != null) {
				session.delete(bankMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bankMaster != null) {
			clearCache(bankMaster);
		}

		return bankMaster;
	}

	@Override
	public BankMaster updateImpl(BankMaster bankMaster) {
		boolean isNew = bankMaster.isNew();

		if (!(bankMaster instanceof BankMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bankMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bankMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bankMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BankMaster implementation " +
				bankMaster.getClass());
		}

		BankMasterModelImpl bankMasterModelImpl = (BankMasterModelImpl)bankMaster;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (bankMaster.getCreateDate() == null)) {
			if (serviceContext == null) {
				bankMaster.setCreateDate(now);
			}
			else {
				bankMaster.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!bankMasterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bankMaster.setModifiedDate(now);
			}
			else {
				bankMaster.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (bankMaster.isNew()) {
				session.save(bankMaster);

				bankMaster.setNew(false);
			}
			else {
				bankMaster = (BankMaster)session.merge(bankMaster);
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

		entityCache.putResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
			BankMasterImpl.class, bankMaster.getPrimaryKey(), bankMaster, false);

		bankMaster.resetOriginalValues();

		return bankMaster;
	}

	/**
	 * Returns the bank master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bank master
	 * @return the bank master
	 * @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	 */
	@Override
	public BankMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBankMasterException {
		BankMaster bankMaster = fetchByPrimaryKey(primaryKey);

		if (bankMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBankMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bankMaster;
	}

	/**
	 * Returns the bank master with the primary key or throws a {@link NoSuchBankMasterException} if it could not be found.
	 *
	 * @param bankId the primary key of the bank master
	 * @return the bank master
	 * @throws NoSuchBankMasterException if a bank master with the primary key could not be found
	 */
	@Override
	public BankMaster findByPrimaryKey(long bankId)
		throws NoSuchBankMasterException {
		return findByPrimaryKey((Serializable)bankId);
	}

	/**
	 * Returns the bank master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bank master
	 * @return the bank master, or <code>null</code> if a bank master with the primary key could not be found
	 */
	@Override
	public BankMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
				BankMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BankMaster bankMaster = (BankMaster)serializable;

		if (bankMaster == null) {
			Session session = null;

			try {
				session = openSession();

				bankMaster = (BankMaster)session.get(BankMasterImpl.class,
						primaryKey);

				if (bankMaster != null) {
					cacheResult(bankMaster);
				}
				else {
					entityCache.putResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
						BankMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
					BankMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bankMaster;
	}

	/**
	 * Returns the bank master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankId the primary key of the bank master
	 * @return the bank master, or <code>null</code> if a bank master with the primary key could not be found
	 */
	@Override
	public BankMaster fetchByPrimaryKey(long bankId) {
		return fetchByPrimaryKey((Serializable)bankId);
	}

	@Override
	public Map<Serializable, BankMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BankMaster> map = new HashMap<Serializable, BankMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BankMaster bankMaster = fetchByPrimaryKey(primaryKey);

			if (bankMaster != null) {
				map.put(primaryKey, bankMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
					BankMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BankMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BANKMASTER_WHERE_PKS_IN);

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

			for (BankMaster bankMaster : (List<BankMaster>)q.list()) {
				map.put(bankMaster.getPrimaryKeyObj(), bankMaster);

				cacheResult(bankMaster);

				uncachedPrimaryKeys.remove(bankMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BankMasterModelImpl.ENTITY_CACHE_ENABLED,
					BankMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the bank masters.
	 *
	 * @return the bank masters
	 */
	@Override
	public List<BankMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bank masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank masters
	 * @param end the upper bound of the range of bank masters (not inclusive)
	 * @return the range of bank masters
	 */
	@Override
	public List<BankMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bank masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank masters
	 * @param end the upper bound of the range of bank masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bank masters
	 */
	@Override
	public List<BankMaster> findAll(int start, int end,
		OrderByComparator<BankMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bank masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BankMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bank masters
	 * @param end the upper bound of the range of bank masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bank masters
	 */
	@Override
	public List<BankMaster> findAll(int start, int end,
		OrderByComparator<BankMaster> orderByComparator,
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

		List<BankMaster> list = null;

		if (retrieveFromCache) {
			list = (List<BankMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BANKMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BANKMASTER;

				if (pagination) {
					sql = sql.concat(BankMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BankMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BankMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bank masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BankMaster bankMaster : findAll()) {
			remove(bankMaster);
		}
	}

	/**
	 * Returns the number of bank masters.
	 *
	 * @return the number of bank masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BANKMASTER);

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
		return BankMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bank master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BankMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BANKMASTER = "SELECT bankMaster FROM BankMaster bankMaster";
	private static final String _SQL_SELECT_BANKMASTER_WHERE_PKS_IN = "SELECT bankMaster FROM BankMaster bankMaster WHERE bankId IN (";
	private static final String _SQL_COUNT_BANKMASTER = "SELECT COUNT(bankMaster) FROM BankMaster bankMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bankMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BankMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BankMasterPersistenceImpl.class);
}