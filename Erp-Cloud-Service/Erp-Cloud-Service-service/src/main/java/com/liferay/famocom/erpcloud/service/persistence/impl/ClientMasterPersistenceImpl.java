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

import com.liferay.famocom.erpcloud.exception.NoSuchClientMasterException;
import com.liferay.famocom.erpcloud.model.ClientMaster;
import com.liferay.famocom.erpcloud.model.impl.ClientMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.ClientMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.ClientMasterPersistence;

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
 * The persistence implementation for the client master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see ClientMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.ClientMasterUtil
 * @generated
 */
@ProviderType
public class ClientMasterPersistenceImpl extends BasePersistenceImpl<ClientMaster>
	implements ClientMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClientMasterUtil} to access the client master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClientMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClientMasterModelImpl.FINDER_CACHE_ENABLED, ClientMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClientMasterModelImpl.FINDER_CACHE_ENABLED, ClientMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClientMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ClientMasterPersistenceImpl() {
		setModelClass(ClientMaster.class);
	}

	/**
	 * Caches the client master in the entity cache if it is enabled.
	 *
	 * @param clientMaster the client master
	 */
	@Override
	public void cacheResult(ClientMaster clientMaster) {
		entityCache.putResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClientMasterImpl.class, clientMaster.getPrimaryKey(), clientMaster);

		clientMaster.resetOriginalValues();
	}

	/**
	 * Caches the client masters in the entity cache if it is enabled.
	 *
	 * @param clientMasters the client masters
	 */
	@Override
	public void cacheResult(List<ClientMaster> clientMasters) {
		for (ClientMaster clientMaster : clientMasters) {
			if (entityCache.getResult(
						ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
						ClientMasterImpl.class, clientMaster.getPrimaryKey()) == null) {
				cacheResult(clientMaster);
			}
			else {
				clientMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all client masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClientMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the client master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClientMaster clientMaster) {
		entityCache.removeResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClientMasterImpl.class, clientMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ClientMaster> clientMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClientMaster clientMaster : clientMasters) {
			entityCache.removeResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
				ClientMasterImpl.class, clientMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new client master with the primary key. Does not add the client master to the database.
	 *
	 * @param clientId the primary key for the new client master
	 * @return the new client master
	 */
	@Override
	public ClientMaster create(long clientId) {
		ClientMaster clientMaster = new ClientMasterImpl();

		clientMaster.setNew(true);
		clientMaster.setPrimaryKey(clientId);

		return clientMaster;
	}

	/**
	 * Removes the client master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the client master
	 * @return the client master that was removed
	 * @throws NoSuchClientMasterException if a client master with the primary key could not be found
	 */
	@Override
	public ClientMaster remove(long clientId)
		throws NoSuchClientMasterException {
		return remove((Serializable)clientId);
	}

	/**
	 * Removes the client master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the client master
	 * @return the client master that was removed
	 * @throws NoSuchClientMasterException if a client master with the primary key could not be found
	 */
	@Override
	public ClientMaster remove(Serializable primaryKey)
		throws NoSuchClientMasterException {
		Session session = null;

		try {
			session = openSession();

			ClientMaster clientMaster = (ClientMaster)session.get(ClientMasterImpl.class,
					primaryKey);

			if (clientMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClientMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(clientMaster);
		}
		catch (NoSuchClientMasterException nsee) {
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
	protected ClientMaster removeImpl(ClientMaster clientMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clientMaster)) {
				clientMaster = (ClientMaster)session.get(ClientMasterImpl.class,
						clientMaster.getPrimaryKeyObj());
			}

			if (clientMaster != null) {
				session.delete(clientMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (clientMaster != null) {
			clearCache(clientMaster);
		}

		return clientMaster;
	}

	@Override
	public ClientMaster updateImpl(ClientMaster clientMaster) {
		boolean isNew = clientMaster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (clientMaster.isNew()) {
				session.save(clientMaster);

				clientMaster.setNew(false);
			}
			else {
				clientMaster = (ClientMaster)session.merge(clientMaster);
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

		entityCache.putResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClientMasterImpl.class, clientMaster.getPrimaryKey(), clientMaster,
			false);

		clientMaster.resetOriginalValues();

		return clientMaster;
	}

	/**
	 * Returns the client master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the client master
	 * @return the client master
	 * @throws NoSuchClientMasterException if a client master with the primary key could not be found
	 */
	@Override
	public ClientMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClientMasterException {
		ClientMaster clientMaster = fetchByPrimaryKey(primaryKey);

		if (clientMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClientMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return clientMaster;
	}

	/**
	 * Returns the client master with the primary key or throws a {@link NoSuchClientMasterException} if it could not be found.
	 *
	 * @param clientId the primary key of the client master
	 * @return the client master
	 * @throws NoSuchClientMasterException if a client master with the primary key could not be found
	 */
	@Override
	public ClientMaster findByPrimaryKey(long clientId)
		throws NoSuchClientMasterException {
		return findByPrimaryKey((Serializable)clientId);
	}

	/**
	 * Returns the client master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the client master
	 * @return the client master, or <code>null</code> if a client master with the primary key could not be found
	 */
	@Override
	public ClientMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
				ClientMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ClientMaster clientMaster = (ClientMaster)serializable;

		if (clientMaster == null) {
			Session session = null;

			try {
				session = openSession();

				clientMaster = (ClientMaster)session.get(ClientMasterImpl.class,
						primaryKey);

				if (clientMaster != null) {
					cacheResult(clientMaster);
				}
				else {
					entityCache.putResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
						ClientMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
					ClientMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return clientMaster;
	}

	/**
	 * Returns the client master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the client master
	 * @return the client master, or <code>null</code> if a client master with the primary key could not be found
	 */
	@Override
	public ClientMaster fetchByPrimaryKey(long clientId) {
		return fetchByPrimaryKey((Serializable)clientId);
	}

	@Override
	public Map<Serializable, ClientMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ClientMaster> map = new HashMap<Serializable, ClientMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ClientMaster clientMaster = fetchByPrimaryKey(primaryKey);

			if (clientMaster != null) {
				map.put(primaryKey, clientMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
					ClientMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ClientMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CLIENTMASTER_WHERE_PKS_IN);

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

			for (ClientMaster clientMaster : (List<ClientMaster>)q.list()) {
				map.put(clientMaster.getPrimaryKeyObj(), clientMaster);

				cacheResult(clientMaster);

				uncachedPrimaryKeys.remove(clientMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ClientMasterModelImpl.ENTITY_CACHE_ENABLED,
					ClientMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the client masters.
	 *
	 * @return the client masters
	 */
	@Override
	public List<ClientMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the client masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of client masters
	 * @param end the upper bound of the range of client masters (not inclusive)
	 * @return the range of client masters
	 */
	@Override
	public List<ClientMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the client masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of client masters
	 * @param end the upper bound of the range of client masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of client masters
	 */
	@Override
	public List<ClientMaster> findAll(int start, int end,
		OrderByComparator<ClientMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the client masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of client masters
	 * @param end the upper bound of the range of client masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of client masters
	 */
	@Override
	public List<ClientMaster> findAll(int start, int end,
		OrderByComparator<ClientMaster> orderByComparator,
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

		List<ClientMaster> list = null;

		if (retrieveFromCache) {
			list = (List<ClientMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CLIENTMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLIENTMASTER;

				if (pagination) {
					sql = sql.concat(ClientMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClientMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ClientMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the client masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClientMaster clientMaster : findAll()) {
			remove(clientMaster);
		}
	}

	/**
	 * Returns the number of client masters.
	 *
	 * @return the number of client masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLIENTMASTER);

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
		return ClientMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the client master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ClientMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CLIENTMASTER = "SELECT clientMaster FROM ClientMaster clientMaster";
	private static final String _SQL_SELECT_CLIENTMASTER_WHERE_PKS_IN = "SELECT clientMaster FROM ClientMaster clientMaster WHERE clientId IN (";
	private static final String _SQL_COUNT_CLIENTMASTER = "SELECT COUNT(clientMaster) FROM ClientMaster clientMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "clientMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ClientMaster exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ClientMasterPersistenceImpl.class);
}