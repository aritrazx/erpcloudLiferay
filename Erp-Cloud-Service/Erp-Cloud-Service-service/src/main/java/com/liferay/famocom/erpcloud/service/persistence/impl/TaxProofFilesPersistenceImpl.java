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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxProofFilesException;
import com.liferay.famocom.erpcloud.model.TaxProofFiles;
import com.liferay.famocom.erpcloud.model.impl.TaxProofFilesImpl;
import com.liferay.famocom.erpcloud.model.impl.TaxProofFilesModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TaxProofFilesPersistence;

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
 * The persistence implementation for the tax proof files service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxProofFilesPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TaxProofFilesUtil
 * @generated
 */
@ProviderType
public class TaxProofFilesPersistenceImpl extends BasePersistenceImpl<TaxProofFiles>
	implements TaxProofFilesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxProofFilesUtil} to access the tax proof files persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxProofFilesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			TaxProofFilesModelImpl.FINDER_CACHE_ENABLED,
			TaxProofFilesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			TaxProofFilesModelImpl.FINDER_CACHE_ENABLED,
			TaxProofFilesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			TaxProofFilesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaxProofFilesPersistenceImpl() {
		setModelClass(TaxProofFiles.class);
	}

	/**
	 * Caches the tax proof files in the entity cache if it is enabled.
	 *
	 * @param taxProofFiles the tax proof files
	 */
	@Override
	public void cacheResult(TaxProofFiles taxProofFiles) {
		entityCache.putResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			TaxProofFilesImpl.class, taxProofFiles.getPrimaryKey(),
			taxProofFiles);

		taxProofFiles.resetOriginalValues();
	}

	/**
	 * Caches the tax proof fileses in the entity cache if it is enabled.
	 *
	 * @param taxProofFileses the tax proof fileses
	 */
	@Override
	public void cacheResult(List<TaxProofFiles> taxProofFileses) {
		for (TaxProofFiles taxProofFiles : taxProofFileses) {
			if (entityCache.getResult(
						TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
						TaxProofFilesImpl.class, taxProofFiles.getPrimaryKey()) == null) {
				cacheResult(taxProofFiles);
			}
			else {
				taxProofFiles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tax proof fileses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaxProofFilesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tax proof files.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxProofFiles taxProofFiles) {
		entityCache.removeResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			TaxProofFilesImpl.class, taxProofFiles.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaxProofFiles> taxProofFileses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxProofFiles taxProofFiles : taxProofFileses) {
			entityCache.removeResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
				TaxProofFilesImpl.class, taxProofFiles.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tax proof files with the primary key. Does not add the tax proof files to the database.
	 *
	 * @param fileId the primary key for the new tax proof files
	 * @return the new tax proof files
	 */
	@Override
	public TaxProofFiles create(long fileId) {
		TaxProofFiles taxProofFiles = new TaxProofFilesImpl();

		taxProofFiles.setNew(true);
		taxProofFiles.setPrimaryKey(fileId);

		taxProofFiles.setCompanyId(companyProvider.getCompanyId());

		return taxProofFiles;
	}

	/**
	 * Removes the tax proof files with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileId the primary key of the tax proof files
	 * @return the tax proof files that was removed
	 * @throws NoSuchTaxProofFilesException if a tax proof files with the primary key could not be found
	 */
	@Override
	public TaxProofFiles remove(long fileId)
		throws NoSuchTaxProofFilesException {
		return remove((Serializable)fileId);
	}

	/**
	 * Removes the tax proof files with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tax proof files
	 * @return the tax proof files that was removed
	 * @throws NoSuchTaxProofFilesException if a tax proof files with the primary key could not be found
	 */
	@Override
	public TaxProofFiles remove(Serializable primaryKey)
		throws NoSuchTaxProofFilesException {
		Session session = null;

		try {
			session = openSession();

			TaxProofFiles taxProofFiles = (TaxProofFiles)session.get(TaxProofFilesImpl.class,
					primaryKey);

			if (taxProofFiles == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxProofFilesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxProofFiles);
		}
		catch (NoSuchTaxProofFilesException nsee) {
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
	protected TaxProofFiles removeImpl(TaxProofFiles taxProofFiles) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxProofFiles)) {
				taxProofFiles = (TaxProofFiles)session.get(TaxProofFilesImpl.class,
						taxProofFiles.getPrimaryKeyObj());
			}

			if (taxProofFiles != null) {
				session.delete(taxProofFiles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxProofFiles != null) {
			clearCache(taxProofFiles);
		}

		return taxProofFiles;
	}

	@Override
	public TaxProofFiles updateImpl(TaxProofFiles taxProofFiles) {
		boolean isNew = taxProofFiles.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taxProofFiles.isNew()) {
				session.save(taxProofFiles);

				taxProofFiles.setNew(false);
			}
			else {
				taxProofFiles = (TaxProofFiles)session.merge(taxProofFiles);
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

		entityCache.putResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
			TaxProofFilesImpl.class, taxProofFiles.getPrimaryKey(),
			taxProofFiles, false);

		taxProofFiles.resetOriginalValues();

		return taxProofFiles;
	}

	/**
	 * Returns the tax proof files with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax proof files
	 * @return the tax proof files
	 * @throws NoSuchTaxProofFilesException if a tax proof files with the primary key could not be found
	 */
	@Override
	public TaxProofFiles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxProofFilesException {
		TaxProofFiles taxProofFiles = fetchByPrimaryKey(primaryKey);

		if (taxProofFiles == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxProofFilesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxProofFiles;
	}

	/**
	 * Returns the tax proof files with the primary key or throws a {@link NoSuchTaxProofFilesException} if it could not be found.
	 *
	 * @param fileId the primary key of the tax proof files
	 * @return the tax proof files
	 * @throws NoSuchTaxProofFilesException if a tax proof files with the primary key could not be found
	 */
	@Override
	public TaxProofFiles findByPrimaryKey(long fileId)
		throws NoSuchTaxProofFilesException {
		return findByPrimaryKey((Serializable)fileId);
	}

	/**
	 * Returns the tax proof files with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax proof files
	 * @return the tax proof files, or <code>null</code> if a tax proof files with the primary key could not be found
	 */
	@Override
	public TaxProofFiles fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
				TaxProofFilesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaxProofFiles taxProofFiles = (TaxProofFiles)serializable;

		if (taxProofFiles == null) {
			Session session = null;

			try {
				session = openSession();

				taxProofFiles = (TaxProofFiles)session.get(TaxProofFilesImpl.class,
						primaryKey);

				if (taxProofFiles != null) {
					cacheResult(taxProofFiles);
				}
				else {
					entityCache.putResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
						TaxProofFilesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
					TaxProofFilesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxProofFiles;
	}

	/**
	 * Returns the tax proof files with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileId the primary key of the tax proof files
	 * @return the tax proof files, or <code>null</code> if a tax proof files with the primary key could not be found
	 */
	@Override
	public TaxProofFiles fetchByPrimaryKey(long fileId) {
		return fetchByPrimaryKey((Serializable)fileId);
	}

	@Override
	public Map<Serializable, TaxProofFiles> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaxProofFiles> map = new HashMap<Serializable, TaxProofFiles>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaxProofFiles taxProofFiles = fetchByPrimaryKey(primaryKey);

			if (taxProofFiles != null) {
				map.put(primaryKey, taxProofFiles);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
					TaxProofFilesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaxProofFiles)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TAXPROOFFILES_WHERE_PKS_IN);

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

			for (TaxProofFiles taxProofFiles : (List<TaxProofFiles>)q.list()) {
				map.put(taxProofFiles.getPrimaryKeyObj(), taxProofFiles);

				cacheResult(taxProofFiles);

				uncachedPrimaryKeys.remove(taxProofFiles.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaxProofFilesModelImpl.ENTITY_CACHE_ENABLED,
					TaxProofFilesImpl.class, primaryKey, nullModel);
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
	 * Returns all the tax proof fileses.
	 *
	 * @return the tax proof fileses
	 */
	@Override
	public List<TaxProofFiles> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax proof fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax proof fileses
	 * @param end the upper bound of the range of tax proof fileses (not inclusive)
	 * @return the range of tax proof fileses
	 */
	@Override
	public List<TaxProofFiles> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tax proof fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax proof fileses
	 * @param end the upper bound of the range of tax proof fileses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tax proof fileses
	 */
	@Override
	public List<TaxProofFiles> findAll(int start, int end,
		OrderByComparator<TaxProofFiles> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tax proof fileses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxProofFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax proof fileses
	 * @param end the upper bound of the range of tax proof fileses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tax proof fileses
	 */
	@Override
	public List<TaxProofFiles> findAll(int start, int end,
		OrderByComparator<TaxProofFiles> orderByComparator,
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

		List<TaxProofFiles> list = null;

		if (retrieveFromCache) {
			list = (List<TaxProofFiles>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAXPROOFFILES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXPROOFFILES;

				if (pagination) {
					sql = sql.concat(TaxProofFilesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxProofFiles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxProofFiles>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tax proof fileses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaxProofFiles taxProofFiles : findAll()) {
			remove(taxProofFiles);
		}
	}

	/**
	 * Returns the number of tax proof fileses.
	 *
	 * @return the number of tax proof fileses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAXPROOFFILES);

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
		return TaxProofFilesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tax proof files persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaxProofFilesImpl.class.getName());
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
	private static final String _SQL_SELECT_TAXPROOFFILES = "SELECT taxProofFiles FROM TaxProofFiles taxProofFiles";
	private static final String _SQL_SELECT_TAXPROOFFILES_WHERE_PKS_IN = "SELECT taxProofFiles FROM TaxProofFiles taxProofFiles WHERE fileId IN (";
	private static final String _SQL_COUNT_TAXPROOFFILES = "SELECT COUNT(taxProofFiles) FROM TaxProofFiles taxProofFiles";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxProofFiles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxProofFiles exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(TaxProofFilesPersistenceImpl.class);
}