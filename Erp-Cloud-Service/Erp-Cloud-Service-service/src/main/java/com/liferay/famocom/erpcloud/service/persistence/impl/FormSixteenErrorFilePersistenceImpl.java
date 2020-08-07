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

import com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenErrorFileException;
import com.liferay.famocom.erpcloud.model.FormSixteenErrorFile;
import com.liferay.famocom.erpcloud.model.impl.FormSixteenErrorFileImpl;
import com.liferay.famocom.erpcloud.model.impl.FormSixteenErrorFileModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.FormSixteenErrorFilePersistence;

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
 * The persistence implementation for the form sixteen error file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see FormSixteenErrorFilePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.FormSixteenErrorFileUtil
 * @generated
 */
@ProviderType
public class FormSixteenErrorFilePersistenceImpl extends BasePersistenceImpl<FormSixteenErrorFile>
	implements FormSixteenErrorFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FormSixteenErrorFileUtil} to access the form sixteen error file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FormSixteenErrorFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenErrorFileModelImpl.FINDER_CACHE_ENABLED,
			FormSixteenErrorFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenErrorFileModelImpl.FINDER_CACHE_ENABLED,
			FormSixteenErrorFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenErrorFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FormSixteenErrorFilePersistenceImpl() {
		setModelClass(FormSixteenErrorFile.class);
	}

	/**
	 * Caches the form sixteen error file in the entity cache if it is enabled.
	 *
	 * @param formSixteenErrorFile the form sixteen error file
	 */
	@Override
	public void cacheResult(FormSixteenErrorFile formSixteenErrorFile) {
		entityCache.putResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenErrorFileImpl.class,
			formSixteenErrorFile.getPrimaryKey(), formSixteenErrorFile);

		formSixteenErrorFile.resetOriginalValues();
	}

	/**
	 * Caches the form sixteen error files in the entity cache if it is enabled.
	 *
	 * @param formSixteenErrorFiles the form sixteen error files
	 */
	@Override
	public void cacheResult(List<FormSixteenErrorFile> formSixteenErrorFiles) {
		for (FormSixteenErrorFile formSixteenErrorFile : formSixteenErrorFiles) {
			if (entityCache.getResult(
						FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
						FormSixteenErrorFileImpl.class,
						formSixteenErrorFile.getPrimaryKey()) == null) {
				cacheResult(formSixteenErrorFile);
			}
			else {
				formSixteenErrorFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all form sixteen error files.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FormSixteenErrorFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form sixteen error file.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormSixteenErrorFile formSixteenErrorFile) {
		entityCache.removeResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenErrorFileImpl.class, formSixteenErrorFile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FormSixteenErrorFile> formSixteenErrorFiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FormSixteenErrorFile formSixteenErrorFile : formSixteenErrorFiles) {
			entityCache.removeResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
				FormSixteenErrorFileImpl.class,
				formSixteenErrorFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new form sixteen error file with the primary key. Does not add the form sixteen error file to the database.
	 *
	 * @param errorId the primary key for the new form sixteen error file
	 * @return the new form sixteen error file
	 */
	@Override
	public FormSixteenErrorFile create(long errorId) {
		FormSixteenErrorFile formSixteenErrorFile = new FormSixteenErrorFileImpl();

		formSixteenErrorFile.setNew(true);
		formSixteenErrorFile.setPrimaryKey(errorId);

		return formSixteenErrorFile;
	}

	/**
	 * Removes the form sixteen error file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param errorId the primary key of the form sixteen error file
	 * @return the form sixteen error file that was removed
	 * @throws NoSuchFormSixteenErrorFileException if a form sixteen error file with the primary key could not be found
	 */
	@Override
	public FormSixteenErrorFile remove(long errorId)
		throws NoSuchFormSixteenErrorFileException {
		return remove((Serializable)errorId);
	}

	/**
	 * Removes the form sixteen error file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form sixteen error file
	 * @return the form sixteen error file that was removed
	 * @throws NoSuchFormSixteenErrorFileException if a form sixteen error file with the primary key could not be found
	 */
	@Override
	public FormSixteenErrorFile remove(Serializable primaryKey)
		throws NoSuchFormSixteenErrorFileException {
		Session session = null;

		try {
			session = openSession();

			FormSixteenErrorFile formSixteenErrorFile = (FormSixteenErrorFile)session.get(FormSixteenErrorFileImpl.class,
					primaryKey);

			if (formSixteenErrorFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormSixteenErrorFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(formSixteenErrorFile);
		}
		catch (NoSuchFormSixteenErrorFileException nsee) {
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
	protected FormSixteenErrorFile removeImpl(
		FormSixteenErrorFile formSixteenErrorFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formSixteenErrorFile)) {
				formSixteenErrorFile = (FormSixteenErrorFile)session.get(FormSixteenErrorFileImpl.class,
						formSixteenErrorFile.getPrimaryKeyObj());
			}

			if (formSixteenErrorFile != null) {
				session.delete(formSixteenErrorFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (formSixteenErrorFile != null) {
			clearCache(formSixteenErrorFile);
		}

		return formSixteenErrorFile;
	}

	@Override
	public FormSixteenErrorFile updateImpl(
		FormSixteenErrorFile formSixteenErrorFile) {
		boolean isNew = formSixteenErrorFile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (formSixteenErrorFile.isNew()) {
				session.save(formSixteenErrorFile);

				formSixteenErrorFile.setNew(false);
			}
			else {
				formSixteenErrorFile = (FormSixteenErrorFile)session.merge(formSixteenErrorFile);
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

		entityCache.putResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenErrorFileImpl.class,
			formSixteenErrorFile.getPrimaryKey(), formSixteenErrorFile, false);

		formSixteenErrorFile.resetOriginalValues();

		return formSixteenErrorFile;
	}

	/**
	 * Returns the form sixteen error file with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form sixteen error file
	 * @return the form sixteen error file
	 * @throws NoSuchFormSixteenErrorFileException if a form sixteen error file with the primary key could not be found
	 */
	@Override
	public FormSixteenErrorFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormSixteenErrorFileException {
		FormSixteenErrorFile formSixteenErrorFile = fetchByPrimaryKey(primaryKey);

		if (formSixteenErrorFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormSixteenErrorFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return formSixteenErrorFile;
	}

	/**
	 * Returns the form sixteen error file with the primary key or throws a {@link NoSuchFormSixteenErrorFileException} if it could not be found.
	 *
	 * @param errorId the primary key of the form sixteen error file
	 * @return the form sixteen error file
	 * @throws NoSuchFormSixteenErrorFileException if a form sixteen error file with the primary key could not be found
	 */
	@Override
	public FormSixteenErrorFile findByPrimaryKey(long errorId)
		throws NoSuchFormSixteenErrorFileException {
		return findByPrimaryKey((Serializable)errorId);
	}

	/**
	 * Returns the form sixteen error file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form sixteen error file
	 * @return the form sixteen error file, or <code>null</code> if a form sixteen error file with the primary key could not be found
	 */
	@Override
	public FormSixteenErrorFile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
				FormSixteenErrorFileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FormSixteenErrorFile formSixteenErrorFile = (FormSixteenErrorFile)serializable;

		if (formSixteenErrorFile == null) {
			Session session = null;

			try {
				session = openSession();

				formSixteenErrorFile = (FormSixteenErrorFile)session.get(FormSixteenErrorFileImpl.class,
						primaryKey);

				if (formSixteenErrorFile != null) {
					cacheResult(formSixteenErrorFile);
				}
				else {
					entityCache.putResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
						FormSixteenErrorFileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
					FormSixteenErrorFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return formSixteenErrorFile;
	}

	/**
	 * Returns the form sixteen error file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param errorId the primary key of the form sixteen error file
	 * @return the form sixteen error file, or <code>null</code> if a form sixteen error file with the primary key could not be found
	 */
	@Override
	public FormSixteenErrorFile fetchByPrimaryKey(long errorId) {
		return fetchByPrimaryKey((Serializable)errorId);
	}

	@Override
	public Map<Serializable, FormSixteenErrorFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FormSixteenErrorFile> map = new HashMap<Serializable, FormSixteenErrorFile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FormSixteenErrorFile formSixteenErrorFile = fetchByPrimaryKey(primaryKey);

			if (formSixteenErrorFile != null) {
				map.put(primaryKey, formSixteenErrorFile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
					FormSixteenErrorFileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FormSixteenErrorFile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FORMSIXTEENERRORFILE_WHERE_PKS_IN);

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

			for (FormSixteenErrorFile formSixteenErrorFile : (List<FormSixteenErrorFile>)q.list()) {
				map.put(formSixteenErrorFile.getPrimaryKeyObj(),
					formSixteenErrorFile);

				cacheResult(formSixteenErrorFile);

				uncachedPrimaryKeys.remove(formSixteenErrorFile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FormSixteenErrorFileModelImpl.ENTITY_CACHE_ENABLED,
					FormSixteenErrorFileImpl.class, primaryKey, nullModel);
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
	 * Returns all the form sixteen error files.
	 *
	 * @return the form sixteen error files
	 */
	@Override
	public List<FormSixteenErrorFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form sixteen error files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form sixteen error files
	 * @param end the upper bound of the range of form sixteen error files (not inclusive)
	 * @return the range of form sixteen error files
	 */
	@Override
	public List<FormSixteenErrorFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form sixteen error files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form sixteen error files
	 * @param end the upper bound of the range of form sixteen error files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form sixteen error files
	 */
	@Override
	public List<FormSixteenErrorFile> findAll(int start, int end,
		OrderByComparator<FormSixteenErrorFile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form sixteen error files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenErrorFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form sixteen error files
	 * @param end the upper bound of the range of form sixteen error files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of form sixteen error files
	 */
	@Override
	public List<FormSixteenErrorFile> findAll(int start, int end,
		OrderByComparator<FormSixteenErrorFile> orderByComparator,
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

		List<FormSixteenErrorFile> list = null;

		if (retrieveFromCache) {
			list = (List<FormSixteenErrorFile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FORMSIXTEENERRORFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORMSIXTEENERRORFILE;

				if (pagination) {
					sql = sql.concat(FormSixteenErrorFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FormSixteenErrorFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FormSixteenErrorFile>)QueryUtil.list(q,
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
	 * Removes all the form sixteen error files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FormSixteenErrorFile formSixteenErrorFile : findAll()) {
			remove(formSixteenErrorFile);
		}
	}

	/**
	 * Returns the number of form sixteen error files.
	 *
	 * @return the number of form sixteen error files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORMSIXTEENERRORFILE);

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
		return FormSixteenErrorFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the form sixteen error file persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FormSixteenErrorFileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FORMSIXTEENERRORFILE = "SELECT formSixteenErrorFile FROM FormSixteenErrorFile formSixteenErrorFile";
	private static final String _SQL_SELECT_FORMSIXTEENERRORFILE_WHERE_PKS_IN = "SELECT formSixteenErrorFile FROM FormSixteenErrorFile formSixteenErrorFile WHERE errorId IN (";
	private static final String _SQL_COUNT_FORMSIXTEENERRORFILE = "SELECT COUNT(formSixteenErrorFile) FROM FormSixteenErrorFile formSixteenErrorFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "formSixteenErrorFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FormSixteenErrorFile exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(FormSixteenErrorFilePersistenceImpl.class);
}