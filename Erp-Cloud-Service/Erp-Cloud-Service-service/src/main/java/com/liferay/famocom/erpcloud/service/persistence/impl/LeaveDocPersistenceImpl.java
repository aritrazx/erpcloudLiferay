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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveDocException;
import com.liferay.famocom.erpcloud.model.LeaveDoc;
import com.liferay.famocom.erpcloud.model.impl.LeaveDocImpl;
import com.liferay.famocom.erpcloud.model.impl.LeaveDocModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.LeaveDocPersistence;

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
 * The persistence implementation for the leave doc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see LeaveDocPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.LeaveDocUtil
 * @generated
 */
@ProviderType
public class LeaveDocPersistenceImpl extends BasePersistenceImpl<LeaveDoc>
	implements LeaveDocPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaveDocUtil} to access the leave doc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaveDocImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
			LeaveDocModelImpl.FINDER_CACHE_ENABLED, LeaveDocImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
			LeaveDocModelImpl.FINDER_CACHE_ENABLED, LeaveDocImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
			LeaveDocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LeaveDocPersistenceImpl() {
		setModelClass(LeaveDoc.class);
	}

	/**
	 * Caches the leave doc in the entity cache if it is enabled.
	 *
	 * @param leaveDoc the leave doc
	 */
	@Override
	public void cacheResult(LeaveDoc leaveDoc) {
		entityCache.putResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
			LeaveDocImpl.class, leaveDoc.getPrimaryKey(), leaveDoc);

		leaveDoc.resetOriginalValues();
	}

	/**
	 * Caches the leave docs in the entity cache if it is enabled.
	 *
	 * @param leaveDocs the leave docs
	 */
	@Override
	public void cacheResult(List<LeaveDoc> leaveDocs) {
		for (LeaveDoc leaveDoc : leaveDocs) {
			if (entityCache.getResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
						LeaveDocImpl.class, leaveDoc.getPrimaryKey()) == null) {
				cacheResult(leaveDoc);
			}
			else {
				leaveDoc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leave docs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeaveDocImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leave doc.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaveDoc leaveDoc) {
		entityCache.removeResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
			LeaveDocImpl.class, leaveDoc.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaveDoc> leaveDocs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaveDoc leaveDoc : leaveDocs) {
			entityCache.removeResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
				LeaveDocImpl.class, leaveDoc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leave doc with the primary key. Does not add the leave doc to the database.
	 *
	 * @param leaveDocId the primary key for the new leave doc
	 * @return the new leave doc
	 */
	@Override
	public LeaveDoc create(long leaveDocId) {
		LeaveDoc leaveDoc = new LeaveDocImpl();

		leaveDoc.setNew(true);
		leaveDoc.setPrimaryKey(leaveDocId);

		leaveDoc.setCompanyId(companyProvider.getCompanyId());

		return leaveDoc;
	}

	/**
	 * Removes the leave doc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaveDocId the primary key of the leave doc
	 * @return the leave doc that was removed
	 * @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	 */
	@Override
	public LeaveDoc remove(long leaveDocId) throws NoSuchLeaveDocException {
		return remove((Serializable)leaveDocId);
	}

	/**
	 * Removes the leave doc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leave doc
	 * @return the leave doc that was removed
	 * @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	 */
	@Override
	public LeaveDoc remove(Serializable primaryKey)
		throws NoSuchLeaveDocException {
		Session session = null;

		try {
			session = openSession();

			LeaveDoc leaveDoc = (LeaveDoc)session.get(LeaveDocImpl.class,
					primaryKey);

			if (leaveDoc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaveDocException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaveDoc);
		}
		catch (NoSuchLeaveDocException nsee) {
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
	protected LeaveDoc removeImpl(LeaveDoc leaveDoc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaveDoc)) {
				leaveDoc = (LeaveDoc)session.get(LeaveDocImpl.class,
						leaveDoc.getPrimaryKeyObj());
			}

			if (leaveDoc != null) {
				session.delete(leaveDoc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaveDoc != null) {
			clearCache(leaveDoc);
		}

		return leaveDoc;
	}

	@Override
	public LeaveDoc updateImpl(LeaveDoc leaveDoc) {
		boolean isNew = leaveDoc.isNew();

		Session session = null;

		try {
			session = openSession();

			if (leaveDoc.isNew()) {
				session.save(leaveDoc);

				leaveDoc.setNew(false);
			}
			else {
				leaveDoc = (LeaveDoc)session.merge(leaveDoc);
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

		entityCache.putResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
			LeaveDocImpl.class, leaveDoc.getPrimaryKey(), leaveDoc, false);

		leaveDoc.resetOriginalValues();

		return leaveDoc;
	}

	/**
	 * Returns the leave doc with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave doc
	 * @return the leave doc
	 * @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	 */
	@Override
	public LeaveDoc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaveDocException {
		LeaveDoc leaveDoc = fetchByPrimaryKey(primaryKey);

		if (leaveDoc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaveDocException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaveDoc;
	}

	/**
	 * Returns the leave doc with the primary key or throws a {@link NoSuchLeaveDocException} if it could not be found.
	 *
	 * @param leaveDocId the primary key of the leave doc
	 * @return the leave doc
	 * @throws NoSuchLeaveDocException if a leave doc with the primary key could not be found
	 */
	@Override
	public LeaveDoc findByPrimaryKey(long leaveDocId)
		throws NoSuchLeaveDocException {
		return findByPrimaryKey((Serializable)leaveDocId);
	}

	/**
	 * Returns the leave doc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leave doc
	 * @return the leave doc, or <code>null</code> if a leave doc with the primary key could not be found
	 */
	@Override
	public LeaveDoc fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
				LeaveDocImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LeaveDoc leaveDoc = (LeaveDoc)serializable;

		if (leaveDoc == null) {
			Session session = null;

			try {
				session = openSession();

				leaveDoc = (LeaveDoc)session.get(LeaveDocImpl.class, primaryKey);

				if (leaveDoc != null) {
					cacheResult(leaveDoc);
				}
				else {
					entityCache.putResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
						LeaveDocImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
					LeaveDocImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaveDoc;
	}

	/**
	 * Returns the leave doc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaveDocId the primary key of the leave doc
	 * @return the leave doc, or <code>null</code> if a leave doc with the primary key could not be found
	 */
	@Override
	public LeaveDoc fetchByPrimaryKey(long leaveDocId) {
		return fetchByPrimaryKey((Serializable)leaveDocId);
	}

	@Override
	public Map<Serializable, LeaveDoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LeaveDoc> map = new HashMap<Serializable, LeaveDoc>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LeaveDoc leaveDoc = fetchByPrimaryKey(primaryKey);

			if (leaveDoc != null) {
				map.put(primaryKey, leaveDoc);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
					LeaveDocImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LeaveDoc)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEAVEDOC_WHERE_PKS_IN);

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

			for (LeaveDoc leaveDoc : (List<LeaveDoc>)q.list()) {
				map.put(leaveDoc.getPrimaryKeyObj(), leaveDoc);

				cacheResult(leaveDoc);

				uncachedPrimaryKeys.remove(leaveDoc.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LeaveDocModelImpl.ENTITY_CACHE_ENABLED,
					LeaveDocImpl.class, primaryKey, nullModel);
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
	 * Returns all the leave docs.
	 *
	 * @return the leave docs
	 */
	@Override
	public List<LeaveDoc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leave docs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave docs
	 * @param end the upper bound of the range of leave docs (not inclusive)
	 * @return the range of leave docs
	 */
	@Override
	public List<LeaveDoc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leave docs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave docs
	 * @param end the upper bound of the range of leave docs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leave docs
	 */
	@Override
	public List<LeaveDoc> findAll(int start, int end,
		OrderByComparator<LeaveDoc> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leave docs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LeaveDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leave docs
	 * @param end the upper bound of the range of leave docs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of leave docs
	 */
	@Override
	public List<LeaveDoc> findAll(int start, int end,
		OrderByComparator<LeaveDoc> orderByComparator, boolean retrieveFromCache) {
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

		List<LeaveDoc> list = null;

		if (retrieveFromCache) {
			list = (List<LeaveDoc>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEAVEDOC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEAVEDOC;

				if (pagination) {
					sql = sql.concat(LeaveDocModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaveDoc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LeaveDoc>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leave docs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LeaveDoc leaveDoc : findAll()) {
			remove(leaveDoc);
		}
	}

	/**
	 * Returns the number of leave docs.
	 *
	 * @return the number of leave docs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEAVEDOC);

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
		return LeaveDocModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leave doc persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LeaveDocImpl.class.getName());
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
	private static final String _SQL_SELECT_LEAVEDOC = "SELECT leaveDoc FROM LeaveDoc leaveDoc";
	private static final String _SQL_SELECT_LEAVEDOC_WHERE_PKS_IN = "SELECT leaveDoc FROM LeaveDoc leaveDoc WHERE leaveDocId IN (";
	private static final String _SQL_COUNT_LEAVEDOC = "SELECT COUNT(leaveDoc) FROM LeaveDoc leaveDoc";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaveDoc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaveDoc exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(LeaveDocPersistenceImpl.class);
}