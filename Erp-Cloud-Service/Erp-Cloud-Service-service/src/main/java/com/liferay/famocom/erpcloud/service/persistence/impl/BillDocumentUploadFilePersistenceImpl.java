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

import com.liferay.famocom.erpcloud.exception.NoSuchBillDocumentUploadFileException;
import com.liferay.famocom.erpcloud.model.BillDocumentUploadFile;
import com.liferay.famocom.erpcloud.model.impl.BillDocumentUploadFileImpl;
import com.liferay.famocom.erpcloud.model.impl.BillDocumentUploadFileModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.BillDocumentUploadFilePersistence;

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
 * The persistence implementation for the bill document upload file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see BillDocumentUploadFilePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.BillDocumentUploadFileUtil
 * @generated
 */
@ProviderType
public class BillDocumentUploadFilePersistenceImpl extends BasePersistenceImpl<BillDocumentUploadFile>
	implements BillDocumentUploadFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BillDocumentUploadFileUtil} to access the bill document upload file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BillDocumentUploadFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			BillDocumentUploadFileModelImpl.FINDER_CACHE_ENABLED,
			BillDocumentUploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			BillDocumentUploadFileModelImpl.FINDER_CACHE_ENABLED,
			BillDocumentUploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			BillDocumentUploadFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BillDocumentUploadFilePersistenceImpl() {
		setModelClass(BillDocumentUploadFile.class);
	}

	/**
	 * Caches the bill document upload file in the entity cache if it is enabled.
	 *
	 * @param billDocumentUploadFile the bill document upload file
	 */
	@Override
	public void cacheResult(BillDocumentUploadFile billDocumentUploadFile) {
		entityCache.putResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			BillDocumentUploadFileImpl.class,
			billDocumentUploadFile.getPrimaryKey(), billDocumentUploadFile);

		billDocumentUploadFile.resetOriginalValues();
	}

	/**
	 * Caches the bill document upload files in the entity cache if it is enabled.
	 *
	 * @param billDocumentUploadFiles the bill document upload files
	 */
	@Override
	public void cacheResult(
		List<BillDocumentUploadFile> billDocumentUploadFiles) {
		for (BillDocumentUploadFile billDocumentUploadFile : billDocumentUploadFiles) {
			if (entityCache.getResult(
						BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
						BillDocumentUploadFileImpl.class,
						billDocumentUploadFile.getPrimaryKey()) == null) {
				cacheResult(billDocumentUploadFile);
			}
			else {
				billDocumentUploadFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bill document upload files.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BillDocumentUploadFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bill document upload file.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BillDocumentUploadFile billDocumentUploadFile) {
		entityCache.removeResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			BillDocumentUploadFileImpl.class,
			billDocumentUploadFile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BillDocumentUploadFile> billDocumentUploadFiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BillDocumentUploadFile billDocumentUploadFile : billDocumentUploadFiles) {
			entityCache.removeResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
				BillDocumentUploadFileImpl.class,
				billDocumentUploadFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bill document upload file with the primary key. Does not add the bill document upload file to the database.
	 *
	 * @param documentId the primary key for the new bill document upload file
	 * @return the new bill document upload file
	 */
	@Override
	public BillDocumentUploadFile create(long documentId) {
		BillDocumentUploadFile billDocumentUploadFile = new BillDocumentUploadFileImpl();

		billDocumentUploadFile.setNew(true);
		billDocumentUploadFile.setPrimaryKey(documentId);

		billDocumentUploadFile.setCompanyId(companyProvider.getCompanyId());

		return billDocumentUploadFile;
	}

	/**
	 * Removes the bill document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the bill document upload file
	 * @return the bill document upload file that was removed
	 * @throws NoSuchBillDocumentUploadFileException if a bill document upload file with the primary key could not be found
	 */
	@Override
	public BillDocumentUploadFile remove(long documentId)
		throws NoSuchBillDocumentUploadFileException {
		return remove((Serializable)documentId);
	}

	/**
	 * Removes the bill document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bill document upload file
	 * @return the bill document upload file that was removed
	 * @throws NoSuchBillDocumentUploadFileException if a bill document upload file with the primary key could not be found
	 */
	@Override
	public BillDocumentUploadFile remove(Serializable primaryKey)
		throws NoSuchBillDocumentUploadFileException {
		Session session = null;

		try {
			session = openSession();

			BillDocumentUploadFile billDocumentUploadFile = (BillDocumentUploadFile)session.get(BillDocumentUploadFileImpl.class,
					primaryKey);

			if (billDocumentUploadFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBillDocumentUploadFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(billDocumentUploadFile);
		}
		catch (NoSuchBillDocumentUploadFileException nsee) {
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
	protected BillDocumentUploadFile removeImpl(
		BillDocumentUploadFile billDocumentUploadFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billDocumentUploadFile)) {
				billDocumentUploadFile = (BillDocumentUploadFile)session.get(BillDocumentUploadFileImpl.class,
						billDocumentUploadFile.getPrimaryKeyObj());
			}

			if (billDocumentUploadFile != null) {
				session.delete(billDocumentUploadFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (billDocumentUploadFile != null) {
			clearCache(billDocumentUploadFile);
		}

		return billDocumentUploadFile;
	}

	@Override
	public BillDocumentUploadFile updateImpl(
		BillDocumentUploadFile billDocumentUploadFile) {
		boolean isNew = billDocumentUploadFile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (billDocumentUploadFile.isNew()) {
				session.save(billDocumentUploadFile);

				billDocumentUploadFile.setNew(false);
			}
			else {
				billDocumentUploadFile = (BillDocumentUploadFile)session.merge(billDocumentUploadFile);
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

		entityCache.putResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			BillDocumentUploadFileImpl.class,
			billDocumentUploadFile.getPrimaryKey(), billDocumentUploadFile,
			false);

		billDocumentUploadFile.resetOriginalValues();

		return billDocumentUploadFile;
	}

	/**
	 * Returns the bill document upload file with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bill document upload file
	 * @return the bill document upload file
	 * @throws NoSuchBillDocumentUploadFileException if a bill document upload file with the primary key could not be found
	 */
	@Override
	public BillDocumentUploadFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBillDocumentUploadFileException {
		BillDocumentUploadFile billDocumentUploadFile = fetchByPrimaryKey(primaryKey);

		if (billDocumentUploadFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBillDocumentUploadFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return billDocumentUploadFile;
	}

	/**
	 * Returns the bill document upload file with the primary key or throws a {@link NoSuchBillDocumentUploadFileException} if it could not be found.
	 *
	 * @param documentId the primary key of the bill document upload file
	 * @return the bill document upload file
	 * @throws NoSuchBillDocumentUploadFileException if a bill document upload file with the primary key could not be found
	 */
	@Override
	public BillDocumentUploadFile findByPrimaryKey(long documentId)
		throws NoSuchBillDocumentUploadFileException {
		return findByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns the bill document upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bill document upload file
	 * @return the bill document upload file, or <code>null</code> if a bill document upload file with the primary key could not be found
	 */
	@Override
	public BillDocumentUploadFile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
				BillDocumentUploadFileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BillDocumentUploadFile billDocumentUploadFile = (BillDocumentUploadFile)serializable;

		if (billDocumentUploadFile == null) {
			Session session = null;

			try {
				session = openSession();

				billDocumentUploadFile = (BillDocumentUploadFile)session.get(BillDocumentUploadFileImpl.class,
						primaryKey);

				if (billDocumentUploadFile != null) {
					cacheResult(billDocumentUploadFile);
				}
				else {
					entityCache.putResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
						BillDocumentUploadFileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
					BillDocumentUploadFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return billDocumentUploadFile;
	}

	/**
	 * Returns the bill document upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the bill document upload file
	 * @return the bill document upload file, or <code>null</code> if a bill document upload file with the primary key could not be found
	 */
	@Override
	public BillDocumentUploadFile fetchByPrimaryKey(long documentId) {
		return fetchByPrimaryKey((Serializable)documentId);
	}

	@Override
	public Map<Serializable, BillDocumentUploadFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BillDocumentUploadFile> map = new HashMap<Serializable, BillDocumentUploadFile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BillDocumentUploadFile billDocumentUploadFile = fetchByPrimaryKey(primaryKey);

			if (billDocumentUploadFile != null) {
				map.put(primaryKey, billDocumentUploadFile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
					BillDocumentUploadFileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BillDocumentUploadFile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BILLDOCUMENTUPLOADFILE_WHERE_PKS_IN);

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

			for (BillDocumentUploadFile billDocumentUploadFile : (List<BillDocumentUploadFile>)q.list()) {
				map.put(billDocumentUploadFile.getPrimaryKeyObj(),
					billDocumentUploadFile);

				cacheResult(billDocumentUploadFile);

				uncachedPrimaryKeys.remove(billDocumentUploadFile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BillDocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
					BillDocumentUploadFileImpl.class, primaryKey, nullModel);
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
	 * Returns all the bill document upload files.
	 *
	 * @return the bill document upload files
	 */
	@Override
	public List<BillDocumentUploadFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bill document upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillDocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bill document upload files
	 * @param end the upper bound of the range of bill document upload files (not inclusive)
	 * @return the range of bill document upload files
	 */
	@Override
	public List<BillDocumentUploadFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bill document upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillDocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bill document upload files
	 * @param end the upper bound of the range of bill document upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bill document upload files
	 */
	@Override
	public List<BillDocumentUploadFile> findAll(int start, int end,
		OrderByComparator<BillDocumentUploadFile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bill document upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillDocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bill document upload files
	 * @param end the upper bound of the range of bill document upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bill document upload files
	 */
	@Override
	public List<BillDocumentUploadFile> findAll(int start, int end,
		OrderByComparator<BillDocumentUploadFile> orderByComparator,
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

		List<BillDocumentUploadFile> list = null;

		if (retrieveFromCache) {
			list = (List<BillDocumentUploadFile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BILLDOCUMENTUPLOADFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BILLDOCUMENTUPLOADFILE;

				if (pagination) {
					sql = sql.concat(BillDocumentUploadFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BillDocumentUploadFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BillDocumentUploadFile>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the bill document upload files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BillDocumentUploadFile billDocumentUploadFile : findAll()) {
			remove(billDocumentUploadFile);
		}
	}

	/**
	 * Returns the number of bill document upload files.
	 *
	 * @return the number of bill document upload files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BILLDOCUMENTUPLOADFILE);

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
		return BillDocumentUploadFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bill document upload file persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BillDocumentUploadFileImpl.class.getName());
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
	private static final String _SQL_SELECT_BILLDOCUMENTUPLOADFILE = "SELECT billDocumentUploadFile FROM BillDocumentUploadFile billDocumentUploadFile";
	private static final String _SQL_SELECT_BILLDOCUMENTUPLOADFILE_WHERE_PKS_IN = "SELECT billDocumentUploadFile FROM BillDocumentUploadFile billDocumentUploadFile WHERE documentId IN (";
	private static final String _SQL_COUNT_BILLDOCUMENTUPLOADFILE = "SELECT COUNT(billDocumentUploadFile) FROM BillDocumentUploadFile billDocumentUploadFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "billDocumentUploadFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BillDocumentUploadFile exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BillDocumentUploadFilePersistenceImpl.class);
}