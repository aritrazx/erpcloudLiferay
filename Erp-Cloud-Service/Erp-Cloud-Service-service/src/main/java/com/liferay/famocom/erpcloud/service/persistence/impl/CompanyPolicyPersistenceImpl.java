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

import com.liferay.famocom.erpcloud.exception.NoSuchCompanyPolicyException;
import com.liferay.famocom.erpcloud.model.CompanyPolicy;
import com.liferay.famocom.erpcloud.model.impl.CompanyPolicyImpl;
import com.liferay.famocom.erpcloud.model.impl.CompanyPolicyModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.CompanyPolicyPersistence;

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
 * The persistence implementation for the company policy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see CompanyPolicyPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.CompanyPolicyUtil
 * @generated
 */
@ProviderType
public class CompanyPolicyPersistenceImpl extends BasePersistenceImpl<CompanyPolicy>
	implements CompanyPolicyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompanyPolicyUtil} to access the company policy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompanyPolicyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyPolicyModelImpl.FINDER_CACHE_ENABLED,
			CompanyPolicyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyPolicyModelImpl.FINDER_CACHE_ENABLED,
			CompanyPolicyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyPolicyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CompanyPolicyPersistenceImpl() {
		setModelClass(CompanyPolicy.class);
	}

	/**
	 * Caches the company policy in the entity cache if it is enabled.
	 *
	 * @param companyPolicy the company policy
	 */
	@Override
	public void cacheResult(CompanyPolicy companyPolicy) {
		entityCache.putResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyPolicyImpl.class, companyPolicy.getPrimaryKey(),
			companyPolicy);

		companyPolicy.resetOriginalValues();
	}

	/**
	 * Caches the company policies in the entity cache if it is enabled.
	 *
	 * @param companyPolicies the company policies
	 */
	@Override
	public void cacheResult(List<CompanyPolicy> companyPolicies) {
		for (CompanyPolicy companyPolicy : companyPolicies) {
			if (entityCache.getResult(
						CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
						CompanyPolicyImpl.class, companyPolicy.getPrimaryKey()) == null) {
				cacheResult(companyPolicy);
			}
			else {
				companyPolicy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all company policies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CompanyPolicyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the company policy.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompanyPolicy companyPolicy) {
		entityCache.removeResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyPolicyImpl.class, companyPolicy.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CompanyPolicy> companyPolicies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CompanyPolicy companyPolicy : companyPolicies) {
			entityCache.removeResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
				CompanyPolicyImpl.class, companyPolicy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new company policy with the primary key. Does not add the company policy to the database.
	 *
	 * @param companyPolicyId the primary key for the new company policy
	 * @return the new company policy
	 */
	@Override
	public CompanyPolicy create(long companyPolicyId) {
		CompanyPolicy companyPolicy = new CompanyPolicyImpl();

		companyPolicy.setNew(true);
		companyPolicy.setPrimaryKey(companyPolicyId);

		companyPolicy.setCompanyId(companyProvider.getCompanyId());

		return companyPolicy;
	}

	/**
	 * Removes the company policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyPolicyId the primary key of the company policy
	 * @return the company policy that was removed
	 * @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	 */
	@Override
	public CompanyPolicy remove(long companyPolicyId)
		throws NoSuchCompanyPolicyException {
		return remove((Serializable)companyPolicyId);
	}

	/**
	 * Removes the company policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the company policy
	 * @return the company policy that was removed
	 * @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	 */
	@Override
	public CompanyPolicy remove(Serializable primaryKey)
		throws NoSuchCompanyPolicyException {
		Session session = null;

		try {
			session = openSession();

			CompanyPolicy companyPolicy = (CompanyPolicy)session.get(CompanyPolicyImpl.class,
					primaryKey);

			if (companyPolicy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompanyPolicyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(companyPolicy);
		}
		catch (NoSuchCompanyPolicyException nsee) {
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
	protected CompanyPolicy removeImpl(CompanyPolicy companyPolicy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(companyPolicy)) {
				companyPolicy = (CompanyPolicy)session.get(CompanyPolicyImpl.class,
						companyPolicy.getPrimaryKeyObj());
			}

			if (companyPolicy != null) {
				session.delete(companyPolicy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (companyPolicy != null) {
			clearCache(companyPolicy);
		}

		return companyPolicy;
	}

	@Override
	public CompanyPolicy updateImpl(CompanyPolicy companyPolicy) {
		boolean isNew = companyPolicy.isNew();

		Session session = null;

		try {
			session = openSession();

			if (companyPolicy.isNew()) {
				session.save(companyPolicy);

				companyPolicy.setNew(false);
			}
			else {
				companyPolicy = (CompanyPolicy)session.merge(companyPolicy);
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

		entityCache.putResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyPolicyImpl.class, companyPolicy.getPrimaryKey(),
			companyPolicy, false);

		companyPolicy.resetOriginalValues();

		return companyPolicy;
	}

	/**
	 * Returns the company policy with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the company policy
	 * @return the company policy
	 * @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	 */
	@Override
	public CompanyPolicy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompanyPolicyException {
		CompanyPolicy companyPolicy = fetchByPrimaryKey(primaryKey);

		if (companyPolicy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompanyPolicyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return companyPolicy;
	}

	/**
	 * Returns the company policy with the primary key or throws a {@link NoSuchCompanyPolicyException} if it could not be found.
	 *
	 * @param companyPolicyId the primary key of the company policy
	 * @return the company policy
	 * @throws NoSuchCompanyPolicyException if a company policy with the primary key could not be found
	 */
	@Override
	public CompanyPolicy findByPrimaryKey(long companyPolicyId)
		throws NoSuchCompanyPolicyException {
		return findByPrimaryKey((Serializable)companyPolicyId);
	}

	/**
	 * Returns the company policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the company policy
	 * @return the company policy, or <code>null</code> if a company policy with the primary key could not be found
	 */
	@Override
	public CompanyPolicy fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
				CompanyPolicyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CompanyPolicy companyPolicy = (CompanyPolicy)serializable;

		if (companyPolicy == null) {
			Session session = null;

			try {
				session = openSession();

				companyPolicy = (CompanyPolicy)session.get(CompanyPolicyImpl.class,
						primaryKey);

				if (companyPolicy != null) {
					cacheResult(companyPolicy);
				}
				else {
					entityCache.putResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
						CompanyPolicyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
					CompanyPolicyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return companyPolicy;
	}

	/**
	 * Returns the company policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyPolicyId the primary key of the company policy
	 * @return the company policy, or <code>null</code> if a company policy with the primary key could not be found
	 */
	@Override
	public CompanyPolicy fetchByPrimaryKey(long companyPolicyId) {
		return fetchByPrimaryKey((Serializable)companyPolicyId);
	}

	@Override
	public Map<Serializable, CompanyPolicy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CompanyPolicy> map = new HashMap<Serializable, CompanyPolicy>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CompanyPolicy companyPolicy = fetchByPrimaryKey(primaryKey);

			if (companyPolicy != null) {
				map.put(primaryKey, companyPolicy);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
					CompanyPolicyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CompanyPolicy)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COMPANYPOLICY_WHERE_PKS_IN);

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

			for (CompanyPolicy companyPolicy : (List<CompanyPolicy>)q.list()) {
				map.put(companyPolicy.getPrimaryKeyObj(), companyPolicy);

				cacheResult(companyPolicy);

				uncachedPrimaryKeys.remove(companyPolicy.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CompanyPolicyModelImpl.ENTITY_CACHE_ENABLED,
					CompanyPolicyImpl.class, primaryKey, nullModel);
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
	 * Returns all the company policies.
	 *
	 * @return the company policies
	 */
	@Override
	public List<CompanyPolicy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of company policies
	 * @param end the upper bound of the range of company policies (not inclusive)
	 * @return the range of company policies
	 */
	@Override
	public List<CompanyPolicy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the company policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of company policies
	 * @param end the upper bound of the range of company policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of company policies
	 */
	@Override
	public List<CompanyPolicy> findAll(int start, int end,
		OrderByComparator<CompanyPolicy> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the company policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CompanyPolicyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of company policies
	 * @param end the upper bound of the range of company policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of company policies
	 */
	@Override
	public List<CompanyPolicy> findAll(int start, int end,
		OrderByComparator<CompanyPolicy> orderByComparator,
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

		List<CompanyPolicy> list = null;

		if (retrieveFromCache) {
			list = (List<CompanyPolicy>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMPANYPOLICY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPANYPOLICY;

				if (pagination) {
					sql = sql.concat(CompanyPolicyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CompanyPolicy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CompanyPolicy>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the company policies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CompanyPolicy companyPolicy : findAll()) {
			remove(companyPolicy);
		}
	}

	/**
	 * Returns the number of company policies.
	 *
	 * @return the number of company policies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMPANYPOLICY);

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
		return CompanyPolicyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the company policy persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CompanyPolicyImpl.class.getName());
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
	private static final String _SQL_SELECT_COMPANYPOLICY = "SELECT companyPolicy FROM CompanyPolicy companyPolicy";
	private static final String _SQL_SELECT_COMPANYPOLICY_WHERE_PKS_IN = "SELECT companyPolicy FROM CompanyPolicy companyPolicy WHERE companyPolicyId IN (";
	private static final String _SQL_COUNT_COMPANYPOLICY = "SELECT COUNT(companyPolicy) FROM CompanyPolicy companyPolicy";
	private static final String _ORDER_BY_ENTITY_ALIAS = "companyPolicy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CompanyPolicy exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CompanyPolicyPersistenceImpl.class);
}