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

import com.liferay.famocom.erpcloud.exception.NoSuchDocumentUploadFileException;
import com.liferay.famocom.erpcloud.model.DocumentUploadFile;
import com.liferay.famocom.erpcloud.model.impl.DocumentUploadFileImpl;
import com.liferay.famocom.erpcloud.model.impl.DocumentUploadFileModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.DocumentUploadFilePersistence;

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
 * The persistence implementation for the document upload file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see DocumentUploadFilePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.DocumentUploadFileUtil
 * @generated
 */
@ProviderType
public class DocumentUploadFilePersistenceImpl extends BasePersistenceImpl<DocumentUploadFile>
	implements DocumentUploadFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentUploadFileUtil} to access the document upload file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentUploadFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentUploadFileModelImpl.FINDER_CACHE_ENABLED,
			DocumentUploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentUploadFileModelImpl.FINDER_CACHE_ENABLED,
			DocumentUploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentUploadFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DocumentUploadFilePersistenceImpl() {
		setModelClass(DocumentUploadFile.class);
	}

	/**
	 * Caches the document upload file in the entity cache if it is enabled.
	 *
	 * @param documentUploadFile the document upload file
	 */
	@Override
	public void cacheResult(DocumentUploadFile documentUploadFile) {
		entityCache.putResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentUploadFileImpl.class, documentUploadFile.getPrimaryKey(),
			documentUploadFile);

		documentUploadFile.resetOriginalValues();
	}

	/**
	 * Caches the document upload files in the entity cache if it is enabled.
	 *
	 * @param documentUploadFiles the document upload files
	 */
	@Override
	public void cacheResult(List<DocumentUploadFile> documentUploadFiles) {
		for (DocumentUploadFile documentUploadFile : documentUploadFiles) {
			if (entityCache.getResult(
						DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
						DocumentUploadFileImpl.class,
						documentUploadFile.getPrimaryKey()) == null) {
				cacheResult(documentUploadFile);
			}
			else {
				documentUploadFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all document upload files.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentUploadFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document upload file.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentUploadFile documentUploadFile) {
		entityCache.removeResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentUploadFileImpl.class, documentUploadFile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DocumentUploadFile> documentUploadFiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentUploadFile documentUploadFile : documentUploadFiles) {
			entityCache.removeResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
				DocumentUploadFileImpl.class, documentUploadFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new document upload file with the primary key. Does not add the document upload file to the database.
	 *
	 * @param documentId the primary key for the new document upload file
	 * @return the new document upload file
	 */
	@Override
	public DocumentUploadFile create(long documentId) {
		DocumentUploadFile documentUploadFile = new DocumentUploadFileImpl();

		documentUploadFile.setNew(true);
		documentUploadFile.setPrimaryKey(documentId);

		documentUploadFile.setCompanyId(companyProvider.getCompanyId());

		return documentUploadFile;
	}

	/**
	 * Removes the document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the document upload file
	 * @return the document upload file that was removed
	 * @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	 */
	@Override
	public DocumentUploadFile remove(long documentId)
		throws NoSuchDocumentUploadFileException {
		return remove((Serializable)documentId);
	}

	/**
	 * Removes the document upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document upload file
	 * @return the document upload file that was removed
	 * @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	 */
	@Override
	public DocumentUploadFile remove(Serializable primaryKey)
		throws NoSuchDocumentUploadFileException {
		Session session = null;

		try {
			session = openSession();

			DocumentUploadFile documentUploadFile = (DocumentUploadFile)session.get(DocumentUploadFileImpl.class,
					primaryKey);

			if (documentUploadFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentUploadFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(documentUploadFile);
		}
		catch (NoSuchDocumentUploadFileException nsee) {
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
	protected DocumentUploadFile removeImpl(
		DocumentUploadFile documentUploadFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentUploadFile)) {
				documentUploadFile = (DocumentUploadFile)session.get(DocumentUploadFileImpl.class,
						documentUploadFile.getPrimaryKeyObj());
			}

			if (documentUploadFile != null) {
				session.delete(documentUploadFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documentUploadFile != null) {
			clearCache(documentUploadFile);
		}

		return documentUploadFile;
	}

	@Override
	public DocumentUploadFile updateImpl(DocumentUploadFile documentUploadFile) {
		boolean isNew = documentUploadFile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (documentUploadFile.isNew()) {
				session.save(documentUploadFile);

				documentUploadFile.setNew(false);
			}
			else {
				documentUploadFile = (DocumentUploadFile)session.merge(documentUploadFile);
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

		entityCache.putResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentUploadFileImpl.class, documentUploadFile.getPrimaryKey(),
			documentUploadFile, false);

		documentUploadFile.resetOriginalValues();

		return documentUploadFile;
	}

	/**
	 * Returns the document upload file with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the document upload file
	 * @return the document upload file
	 * @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	 */
	@Override
	public DocumentUploadFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentUploadFileException {
		DocumentUploadFile documentUploadFile = fetchByPrimaryKey(primaryKey);

		if (documentUploadFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentUploadFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return documentUploadFile;
	}

	/**
	 * Returns the document upload file with the primary key or throws a {@link NoSuchDocumentUploadFileException} if it could not be found.
	 *
	 * @param documentId the primary key of the document upload file
	 * @return the document upload file
	 * @throws NoSuchDocumentUploadFileException if a document upload file with the primary key could not be found
	 */
	@Override
	public DocumentUploadFile findByPrimaryKey(long documentId)
		throws NoSuchDocumentUploadFileException {
		return findByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns the document upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document upload file
	 * @return the document upload file, or <code>null</code> if a document upload file with the primary key could not be found
	 */
	@Override
	public DocumentUploadFile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
				DocumentUploadFileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DocumentUploadFile documentUploadFile = (DocumentUploadFile)serializable;

		if (documentUploadFile == null) {
			Session session = null;

			try {
				session = openSession();

				documentUploadFile = (DocumentUploadFile)session.get(DocumentUploadFileImpl.class,
						primaryKey);

				if (documentUploadFile != null) {
					cacheResult(documentUploadFile);
				}
				else {
					entityCache.putResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
						DocumentUploadFileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
					DocumentUploadFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documentUploadFile;
	}

	/**
	 * Returns the document upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the document upload file
	 * @return the document upload file, or <code>null</code> if a document upload file with the primary key could not be found
	 */
	@Override
	public DocumentUploadFile fetchByPrimaryKey(long documentId) {
		return fetchByPrimaryKey((Serializable)documentId);
	}

	@Override
	public Map<Serializable, DocumentUploadFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DocumentUploadFile> map = new HashMap<Serializable, DocumentUploadFile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DocumentUploadFile documentUploadFile = fetchByPrimaryKey(primaryKey);

			if (documentUploadFile != null) {
				map.put(primaryKey, documentUploadFile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
					DocumentUploadFileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DocumentUploadFile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DOCUMENTUPLOADFILE_WHERE_PKS_IN);

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

			for (DocumentUploadFile documentUploadFile : (List<DocumentUploadFile>)q.list()) {
				map.put(documentUploadFile.getPrimaryKeyObj(),
					documentUploadFile);

				cacheResult(documentUploadFile);

				uncachedPrimaryKeys.remove(documentUploadFile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DocumentUploadFileModelImpl.ENTITY_CACHE_ENABLED,
					DocumentUploadFileImpl.class, primaryKey, nullModel);
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
	 * Returns all the document upload files.
	 *
	 * @return the document upload files
	 */
	@Override
	public List<DocumentUploadFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document upload files
	 * @param end the upper bound of the range of document upload files (not inclusive)
	 * @return the range of document upload files
	 */
	@Override
	public List<DocumentUploadFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document upload files
	 * @param end the upper bound of the range of document upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document upload files
	 */
	@Override
	public List<DocumentUploadFile> findAll(int start, int end,
		OrderByComparator<DocumentUploadFile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentUploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document upload files
	 * @param end the upper bound of the range of document upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of document upload files
	 */
	@Override
	public List<DocumentUploadFile> findAll(int start, int end,
		OrderByComparator<DocumentUploadFile> orderByComparator,
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

		List<DocumentUploadFile> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentUploadFile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCUMENTUPLOADFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTUPLOADFILE;

				if (pagination) {
					sql = sql.concat(DocumentUploadFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocumentUploadFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentUploadFile>)QueryUtil.list(q,
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
	 * Removes all the document upload files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentUploadFile documentUploadFile : findAll()) {
			remove(documentUploadFile);
		}
	}

	/**
	 * Returns the number of document upload files.
	 *
	 * @return the number of document upload files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTUPLOADFILE);

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
		return DocumentUploadFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document upload file persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DocumentUploadFileImpl.class.getName());
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
	private static final String _SQL_SELECT_DOCUMENTUPLOADFILE = "SELECT documentUploadFile FROM DocumentUploadFile documentUploadFile";
	private static final String _SQL_SELECT_DOCUMENTUPLOADFILE_WHERE_PKS_IN = "SELECT documentUploadFile FROM DocumentUploadFile documentUploadFile WHERE documentId IN (";
	private static final String _SQL_COUNT_DOCUMENTUPLOADFILE = "SELECT COUNT(documentUploadFile) FROM DocumentUploadFile documentUploadFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "documentUploadFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DocumentUploadFile exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(DocumentUploadFilePersistenceImpl.class);
}