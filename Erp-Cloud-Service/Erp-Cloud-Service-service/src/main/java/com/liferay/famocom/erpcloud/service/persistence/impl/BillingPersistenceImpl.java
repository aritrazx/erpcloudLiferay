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

import com.liferay.famocom.erpcloud.exception.NoSuchBillingException;
import com.liferay.famocom.erpcloud.model.Billing;
import com.liferay.famocom.erpcloud.model.impl.BillingImpl;
import com.liferay.famocom.erpcloud.model.impl.BillingModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.BillingPersistence;

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
 * The persistence implementation for the billing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BillingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.BillingUtil
 * @generated
 */
@ProviderType
public class BillingPersistenceImpl extends BasePersistenceImpl<Billing>
	implements BillingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BillingUtil} to access the billing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BillingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BillingPersistenceImpl() {
		setModelClass(Billing.class);
	}

	/**
	 * Caches the billing in the entity cache if it is enabled.
	 *
	 * @param billing the billing
	 */
	@Override
	public void cacheResult(Billing billing) {
		entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingImpl.class, billing.getPrimaryKey(), billing);

		billing.resetOriginalValues();
	}

	/**
	 * Caches the billings in the entity cache if it is enabled.
	 *
	 * @param billings the billings
	 */
	@Override
	public void cacheResult(List<Billing> billings) {
		for (Billing billing : billings) {
			if (entityCache.getResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
						BillingImpl.class, billing.getPrimaryKey()) == null) {
				cacheResult(billing);
			}
			else {
				billing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all billings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BillingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the billing.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Billing billing) {
		entityCache.removeResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingImpl.class, billing.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Billing> billings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Billing billing : billings) {
			entityCache.removeResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
				BillingImpl.class, billing.getPrimaryKey());
		}
	}

	/**
	 * Creates a new billing with the primary key. Does not add the billing to the database.
	 *
	 * @param billingId the primary key for the new billing
	 * @return the new billing
	 */
	@Override
	public Billing create(long billingId) {
		Billing billing = new BillingImpl();

		billing.setNew(true);
		billing.setPrimaryKey(billingId);

		return billing;
	}

	/**
	 * Removes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billingId the primary key of the billing
	 * @return the billing that was removed
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing remove(long billingId) throws NoSuchBillingException {
		return remove((Serializable)billingId);
	}

	/**
	 * Removes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the billing
	 * @return the billing that was removed
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing remove(Serializable primaryKey)
		throws NoSuchBillingException {
		Session session = null;

		try {
			session = openSession();

			Billing billing = (Billing)session.get(BillingImpl.class, primaryKey);

			if (billing == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBillingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(billing);
		}
		catch (NoSuchBillingException nsee) {
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
	protected Billing removeImpl(Billing billing) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billing)) {
				billing = (Billing)session.get(BillingImpl.class,
						billing.getPrimaryKeyObj());
			}

			if (billing != null) {
				session.delete(billing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (billing != null) {
			clearCache(billing);
		}

		return billing;
	}

	@Override
	public Billing updateImpl(Billing billing) {
		boolean isNew = billing.isNew();

		Session session = null;

		try {
			session = openSession();

			if (billing.isNew()) {
				session.save(billing);

				billing.setNew(false);
			}
			else {
				billing = (Billing)session.merge(billing);
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

		entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingImpl.class, billing.getPrimaryKey(), billing, false);

		billing.resetOriginalValues();

		return billing;
	}

	/**
	 * Returns the billing with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing
	 * @return the billing
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBillingException {
		Billing billing = fetchByPrimaryKey(primaryKey);

		if (billing == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBillingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return billing;
	}

	/**
	 * Returns the billing with the primary key or throws a {@link NoSuchBillingException} if it could not be found.
	 *
	 * @param billingId the primary key of the billing
	 * @return the billing
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing findByPrimaryKey(long billingId)
		throws NoSuchBillingException {
		return findByPrimaryKey((Serializable)billingId);
	}

	/**
	 * Returns the billing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing
	 * @return the billing, or <code>null</code> if a billing with the primary key could not be found
	 */
	@Override
	public Billing fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
				BillingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Billing billing = (Billing)serializable;

		if (billing == null) {
			Session session = null;

			try {
				session = openSession();

				billing = (Billing)session.get(BillingImpl.class, primaryKey);

				if (billing != null) {
					cacheResult(billing);
				}
				else {
					entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
						BillingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
					BillingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return billing;
	}

	/**
	 * Returns the billing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param billingId the primary key of the billing
	 * @return the billing, or <code>null</code> if a billing with the primary key could not be found
	 */
	@Override
	public Billing fetchByPrimaryKey(long billingId) {
		return fetchByPrimaryKey((Serializable)billingId);
	}

	@Override
	public Map<Serializable, Billing> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Billing> map = new HashMap<Serializable, Billing>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Billing billing = fetchByPrimaryKey(primaryKey);

			if (billing != null) {
				map.put(primaryKey, billing);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
					BillingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Billing)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BILLING_WHERE_PKS_IN);

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

			for (Billing billing : (List<Billing>)q.list()) {
				map.put(billing.getPrimaryKeyObj(), billing);

				cacheResult(billing);

				uncachedPrimaryKeys.remove(billing.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
					BillingImpl.class, primaryKey, nullModel);
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
	 * Returns all the billings.
	 *
	 * @return the billings
	 */
	@Override
	public List<Billing> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @return the range of billings
	 */
	@Override
	public List<Billing> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the billings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billings
	 */
	@Override
	public List<Billing> findAll(int start, int end,
		OrderByComparator<Billing> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of billings
	 */
	@Override
	public List<Billing> findAll(int start, int end,
		OrderByComparator<Billing> orderByComparator, boolean retrieveFromCache) {
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

		List<Billing> list = null;

		if (retrieveFromCache) {
			list = (List<Billing>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BILLING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BILLING;

				if (pagination) {
					sql = sql.concat(BillingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Billing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the billings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Billing billing : findAll()) {
			remove(billing);
		}
	}

	/**
	 * Returns the number of billings.
	 *
	 * @return the number of billings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BILLING);

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
		return BillingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the billing persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BillingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BILLING = "SELECT billing FROM Billing billing";
	private static final String _SQL_SELECT_BILLING_WHERE_PKS_IN = "SELECT billing FROM Billing billing WHERE billingId IN (";
	private static final String _SQL_COUNT_BILLING = "SELECT COUNT(billing) FROM Billing billing";
	private static final String _ORDER_BY_ENTITY_ALIAS = "billing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Billing exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BillingPersistenceImpl.class);
}