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

import com.liferay.famocom.erpcloud.exception.NoSuchEmployeeTypeException;
import com.liferay.famocom.erpcloud.model.EmployeeType;
import com.liferay.famocom.erpcloud.model.impl.EmployeeTypeImpl;
import com.liferay.famocom.erpcloud.model.impl.EmployeeTypeModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeTypePersistence;

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
 * The persistence implementation for the employee type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmployeeTypePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.EmployeeTypeUtil
 * @generated
 */
@ProviderType
public class EmployeeTypePersistenceImpl extends BasePersistenceImpl<EmployeeType>
	implements EmployeeTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeTypeUtil} to access the employee type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeModelImpl.FINDER_CACHE_ENABLED, EmployeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeModelImpl.FINDER_CACHE_ENABLED, EmployeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmployeeTypePersistenceImpl() {
		setModelClass(EmployeeType.class);
	}

	/**
	 * Caches the employee type in the entity cache if it is enabled.
	 *
	 * @param employeeType the employee type
	 */
	@Override
	public void cacheResult(EmployeeType employeeType) {
		entityCache.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeImpl.class, employeeType.getPrimaryKey(), employeeType);

		employeeType.resetOriginalValues();
	}

	/**
	 * Caches the employee types in the entity cache if it is enabled.
	 *
	 * @param employeeTypes the employee types
	 */
	@Override
	public void cacheResult(List<EmployeeType> employeeTypes) {
		for (EmployeeType employeeType : employeeTypes) {
			if (entityCache.getResult(
						EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeTypeImpl.class, employeeType.getPrimaryKey()) == null) {
				cacheResult(employeeType);
			}
			else {
				employeeType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee types.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee type.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeType employeeType) {
		entityCache.removeResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeImpl.class, employeeType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmployeeType> employeeTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeType employeeType : employeeTypes) {
			entityCache.removeResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeTypeImpl.class, employeeType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee type with the primary key. Does not add the employee type to the database.
	 *
	 * @param employeetypeId the primary key for the new employee type
	 * @return the new employee type
	 */
	@Override
	public EmployeeType create(long employeetypeId) {
		EmployeeType employeeType = new EmployeeTypeImpl();

		employeeType.setNew(true);
		employeeType.setPrimaryKey(employeetypeId);

		employeeType.setCompanyId(companyProvider.getCompanyId());

		return employeeType;
	}

	/**
	 * Removes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeetypeId the primary key of the employee type
	 * @return the employee type that was removed
	 * @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 */
	@Override
	public EmployeeType remove(long employeetypeId)
		throws NoSuchEmployeeTypeException {
		return remove((Serializable)employeetypeId);
	}

	/**
	 * Removes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee type
	 * @return the employee type that was removed
	 * @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 */
	@Override
	public EmployeeType remove(Serializable primaryKey)
		throws NoSuchEmployeeTypeException {
		Session session = null;

		try {
			session = openSession();

			EmployeeType employeeType = (EmployeeType)session.get(EmployeeTypeImpl.class,
					primaryKey);

			if (employeeType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeType);
		}
		catch (NoSuchEmployeeTypeException nsee) {
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
	protected EmployeeType removeImpl(EmployeeType employeeType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeType)) {
				employeeType = (EmployeeType)session.get(EmployeeTypeImpl.class,
						employeeType.getPrimaryKeyObj());
			}

			if (employeeType != null) {
				session.delete(employeeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeType != null) {
			clearCache(employeeType);
		}

		return employeeType;
	}

	@Override
	public EmployeeType updateImpl(EmployeeType employeeType) {
		boolean isNew = employeeType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (employeeType.isNew()) {
				session.save(employeeType);

				employeeType.setNew(false);
			}
			else {
				employeeType = (EmployeeType)session.merge(employeeType);
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

		entityCache.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeImpl.class, employeeType.getPrimaryKey(), employeeType,
			false);

		employeeType.resetOriginalValues();

		return employeeType;
	}

	/**
	 * Returns the employee type with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee type
	 * @return the employee type
	 * @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 */
	@Override
	public EmployeeType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeTypeException {
		EmployeeType employeeType = fetchByPrimaryKey(primaryKey);

		if (employeeType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeType;
	}

	/**
	 * Returns the employee type with the primary key or throws a {@link NoSuchEmployeeTypeException} if it could not be found.
	 *
	 * @param employeetypeId the primary key of the employee type
	 * @return the employee type
	 * @throws NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 */
	@Override
	public EmployeeType findByPrimaryKey(long employeetypeId)
		throws NoSuchEmployeeTypeException {
		return findByPrimaryKey((Serializable)employeetypeId);
	}

	/**
	 * Returns the employee type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee type
	 * @return the employee type, or <code>null</code> if a employee type with the primary key could not be found
	 */
	@Override
	public EmployeeType fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeTypeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmployeeType employeeType = (EmployeeType)serializable;

		if (employeeType == null) {
			Session session = null;

			try {
				session = openSession();

				employeeType = (EmployeeType)session.get(EmployeeTypeImpl.class,
						primaryKey);

				if (employeeType != null) {
					cacheResult(employeeType);
				}
				else {
					entityCache.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeTypeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeType;
	}

	/**
	 * Returns the employee type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeetypeId the primary key of the employee type
	 * @return the employee type, or <code>null</code> if a employee type with the primary key could not be found
	 */
	@Override
	public EmployeeType fetchByPrimaryKey(long employeetypeId) {
		return fetchByPrimaryKey((Serializable)employeetypeId);
	}

	@Override
	public Map<Serializable, EmployeeType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmployeeType> map = new HashMap<Serializable, EmployeeType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmployeeType employeeType = fetchByPrimaryKey(primaryKey);

			if (employeeType != null) {
				map.put(primaryKey, employeeType);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeTypeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmployeeType)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMPLOYEETYPE_WHERE_PKS_IN);

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

			for (EmployeeType employeeType : (List<EmployeeType>)q.list()) {
				map.put(employeeType.getPrimaryKeyObj(), employeeType);

				cacheResult(employeeType);

				uncachedPrimaryKeys.remove(employeeType.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeTypeImpl.class, primaryKey, nullModel);
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
	 * Returns all the employee types.
	 *
	 * @return the employee types
	 */
	@Override
	public List<EmployeeType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee types
	 * @param end the upper bound of the range of employee types (not inclusive)
	 * @return the range of employee types
	 */
	@Override
	public List<EmployeeType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee types
	 * @param end the upper bound of the range of employee types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee types
	 */
	@Override
	public List<EmployeeType> findAll(int start, int end,
		OrderByComparator<EmployeeType> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee types
	 * @param end the upper bound of the range of employee types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of employee types
	 */
	@Override
	public List<EmployeeType> findAll(int start, int end,
		OrderByComparator<EmployeeType> orderByComparator,
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

		List<EmployeeType> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeType>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMPLOYEETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEETYPE;

				if (pagination) {
					sql = sql.concat(EmployeeTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the employee types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeType employeeType : findAll()) {
			remove(employeeType);
		}
	}

	/**
	 * Returns the number of employee types.
	 *
	 * @return the number of employee types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEETYPE);

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
		return EmployeeTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee type persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmployeeTypeImpl.class.getName());
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
	private static final String _SQL_SELECT_EMPLOYEETYPE = "SELECT employeeType FROM EmployeeType employeeType";
	private static final String _SQL_SELECT_EMPLOYEETYPE_WHERE_PKS_IN = "SELECT employeeType FROM EmployeeType employeeType WHERE employeetypeId IN (";
	private static final String _SQL_COUNT_EMPLOYEETYPE = "SELECT COUNT(employeeType) FROM EmployeeType employeeType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeType exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(EmployeeTypePersistenceImpl.class);
}