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

import com.liferay.famocom.erpcloud.exception.NoSuchYearSettingException;
import com.liferay.famocom.erpcloud.model.YearSetting;
import com.liferay.famocom.erpcloud.model.impl.YearSettingImpl;
import com.liferay.famocom.erpcloud.model.impl.YearSettingModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.YearSettingPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the year setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see YearSettingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.YearSettingUtil
 * @generated
 */
@ProviderType
public class YearSettingPersistenceImpl extends BasePersistenceImpl<YearSetting>
	implements YearSettingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YearSettingUtil} to access the year setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YearSettingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingModelImpl.FINDER_CACHE_ENABLED, YearSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingModelImpl.FINDER_CACHE_ENABLED, YearSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ISACTIVE = new FinderPath(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingModelImpl.FINDER_CACHE_ENABLED, YearSettingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByisActive",
			new String[] { Integer.class.getName() },
			YearSettingModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISACTIVE = new FinderPath(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisActive",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the year setting where isActive = &#63; or throws a {@link NoSuchYearSettingException} if it could not be found.
	 *
	 * @param isActive the is active
	 * @return the matching year setting
	 * @throws NoSuchYearSettingException if a matching year setting could not be found
	 */
	@Override
	public YearSetting findByisActive(int isActive)
		throws NoSuchYearSettingException {
		YearSetting yearSetting = fetchByisActive(isActive);

		if (yearSetting == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("isActive=");
			msg.append(isActive);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchYearSettingException(msg.toString());
		}

		return yearSetting;
	}

	/**
	 * Returns the year setting where isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param isActive the is active
	 * @return the matching year setting, or <code>null</code> if a matching year setting could not be found
	 */
	@Override
	public YearSetting fetchByisActive(int isActive) {
		return fetchByisActive(isActive, true);
	}

	/**
	 * Returns the year setting where isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param isActive the is active
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching year setting, or <code>null</code> if a matching year setting could not be found
	 */
	@Override
	public YearSetting fetchByisActive(int isActive, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { isActive };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ISACTIVE,
					finderArgs, this);
		}

		if (result instanceof YearSetting) {
			YearSetting yearSetting = (YearSetting)result;

			if ((isActive != yearSetting.getIsActive())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_YEARSETTING_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive);

				List<YearSetting> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ISACTIVE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"YearSettingPersistenceImpl.fetchByisActive(int, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					YearSetting yearSetting = list.get(0);

					result = yearSetting;

					cacheResult(yearSetting);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ISACTIVE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (YearSetting)result;
		}
	}

	/**
	 * Removes the year setting where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @return the year setting that was removed
	 */
	@Override
	public YearSetting removeByisActive(int isActive)
		throws NoSuchYearSettingException {
		YearSetting yearSetting = findByisActive(isActive);

		return remove(yearSetting);
	}

	/**
	 * Returns the number of year settings where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching year settings
	 */
	@Override
	public int countByisActive(int isActive) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISACTIVE;

		Object[] finderArgs = new Object[] { isActive };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_YEARSETTING_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISACTIVE_ISACTIVE_2 = "yearSetting.isActive = ?";

	public YearSettingPersistenceImpl() {
		setModelClass(YearSetting.class);
	}

	/**
	 * Caches the year setting in the entity cache if it is enabled.
	 *
	 * @param yearSetting the year setting
	 */
	@Override
	public void cacheResult(YearSetting yearSetting) {
		entityCache.putResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingImpl.class, yearSetting.getPrimaryKey(), yearSetting);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ISACTIVE,
			new Object[] { yearSetting.getIsActive() }, yearSetting);

		yearSetting.resetOriginalValues();
	}

	/**
	 * Caches the year settings in the entity cache if it is enabled.
	 *
	 * @param yearSettings the year settings
	 */
	@Override
	public void cacheResult(List<YearSetting> yearSettings) {
		for (YearSetting yearSetting : yearSettings) {
			if (entityCache.getResult(
						YearSettingModelImpl.ENTITY_CACHE_ENABLED,
						YearSettingImpl.class, yearSetting.getPrimaryKey()) == null) {
				cacheResult(yearSetting);
			}
			else {
				yearSetting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all year settings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(YearSettingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the year setting.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YearSetting yearSetting) {
		entityCache.removeResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingImpl.class, yearSetting.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((YearSettingModelImpl)yearSetting, true);
	}

	@Override
	public void clearCache(List<YearSetting> yearSettings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YearSetting yearSetting : yearSettings) {
			entityCache.removeResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
				YearSettingImpl.class, yearSetting.getPrimaryKey());

			clearUniqueFindersCache((YearSettingModelImpl)yearSetting, true);
		}
	}

	protected void cacheUniqueFindersCache(
		YearSettingModelImpl yearSettingModelImpl) {
		Object[] args = new Object[] { yearSettingModelImpl.getIsActive() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_ISACTIVE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ISACTIVE, args,
			yearSettingModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		YearSettingModelImpl yearSettingModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { yearSettingModelImpl.getIsActive() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISACTIVE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ISACTIVE, args);
		}

		if ((yearSettingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ISACTIVE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					yearSettingModelImpl.getOriginalIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISACTIVE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ISACTIVE, args);
		}
	}

	/**
	 * Creates a new year setting with the primary key. Does not add the year setting to the database.
	 *
	 * @param yearSettingId the primary key for the new year setting
	 * @return the new year setting
	 */
	@Override
	public YearSetting create(long yearSettingId) {
		YearSetting yearSetting = new YearSettingImpl();

		yearSetting.setNew(true);
		yearSetting.setPrimaryKey(yearSettingId);

		return yearSetting;
	}

	/**
	 * Removes the year setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param yearSettingId the primary key of the year setting
	 * @return the year setting that was removed
	 * @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	 */
	@Override
	public YearSetting remove(long yearSettingId)
		throws NoSuchYearSettingException {
		return remove((Serializable)yearSettingId);
	}

	/**
	 * Removes the year setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the year setting
	 * @return the year setting that was removed
	 * @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	 */
	@Override
	public YearSetting remove(Serializable primaryKey)
		throws NoSuchYearSettingException {
		Session session = null;

		try {
			session = openSession();

			YearSetting yearSetting = (YearSetting)session.get(YearSettingImpl.class,
					primaryKey);

			if (yearSetting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYearSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yearSetting);
		}
		catch (NoSuchYearSettingException nsee) {
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
	protected YearSetting removeImpl(YearSetting yearSetting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(yearSetting)) {
				yearSetting = (YearSetting)session.get(YearSettingImpl.class,
						yearSetting.getPrimaryKeyObj());
			}

			if (yearSetting != null) {
				session.delete(yearSetting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (yearSetting != null) {
			clearCache(yearSetting);
		}

		return yearSetting;
	}

	@Override
	public YearSetting updateImpl(YearSetting yearSetting) {
		boolean isNew = yearSetting.isNew();

		if (!(yearSetting instanceof YearSettingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(yearSetting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(yearSetting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in yearSetting proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom YearSetting implementation " +
				yearSetting.getClass());
		}

		YearSettingModelImpl yearSettingModelImpl = (YearSettingModelImpl)yearSetting;

		Session session = null;

		try {
			session = openSession();

			if (yearSetting.isNew()) {
				session.save(yearSetting);

				yearSetting.setNew(false);
			}
			else {
				yearSetting = (YearSetting)session.merge(yearSetting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!YearSettingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
			YearSettingImpl.class, yearSetting.getPrimaryKey(), yearSetting,
			false);

		clearUniqueFindersCache(yearSettingModelImpl, false);
		cacheUniqueFindersCache(yearSettingModelImpl);

		yearSetting.resetOriginalValues();

		return yearSetting;
	}

	/**
	 * Returns the year setting with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the year setting
	 * @return the year setting
	 * @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	 */
	@Override
	public YearSetting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchYearSettingException {
		YearSetting yearSetting = fetchByPrimaryKey(primaryKey);

		if (yearSetting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchYearSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return yearSetting;
	}

	/**
	 * Returns the year setting with the primary key or throws a {@link NoSuchYearSettingException} if it could not be found.
	 *
	 * @param yearSettingId the primary key of the year setting
	 * @return the year setting
	 * @throws NoSuchYearSettingException if a year setting with the primary key could not be found
	 */
	@Override
	public YearSetting findByPrimaryKey(long yearSettingId)
		throws NoSuchYearSettingException {
		return findByPrimaryKey((Serializable)yearSettingId);
	}

	/**
	 * Returns the year setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the year setting
	 * @return the year setting, or <code>null</code> if a year setting with the primary key could not be found
	 */
	@Override
	public YearSetting fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
				YearSettingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		YearSetting yearSetting = (YearSetting)serializable;

		if (yearSetting == null) {
			Session session = null;

			try {
				session = openSession();

				yearSetting = (YearSetting)session.get(YearSettingImpl.class,
						primaryKey);

				if (yearSetting != null) {
					cacheResult(yearSetting);
				}
				else {
					entityCache.putResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
						YearSettingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
					YearSettingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return yearSetting;
	}

	/**
	 * Returns the year setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param yearSettingId the primary key of the year setting
	 * @return the year setting, or <code>null</code> if a year setting with the primary key could not be found
	 */
	@Override
	public YearSetting fetchByPrimaryKey(long yearSettingId) {
		return fetchByPrimaryKey((Serializable)yearSettingId);
	}

	@Override
	public Map<Serializable, YearSetting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, YearSetting> map = new HashMap<Serializable, YearSetting>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			YearSetting yearSetting = fetchByPrimaryKey(primaryKey);

			if (yearSetting != null) {
				map.put(primaryKey, yearSetting);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
					YearSettingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (YearSetting)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_YEARSETTING_WHERE_PKS_IN);

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

			for (YearSetting yearSetting : (List<YearSetting>)q.list()) {
				map.put(yearSetting.getPrimaryKeyObj(), yearSetting);

				cacheResult(yearSetting);

				uncachedPrimaryKeys.remove(yearSetting.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(YearSettingModelImpl.ENTITY_CACHE_ENABLED,
					YearSettingImpl.class, primaryKey, nullModel);
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
	 * Returns all the year settings.
	 *
	 * @return the year settings
	 */
	@Override
	public List<YearSetting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the year settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of year settings
	 * @param end the upper bound of the range of year settings (not inclusive)
	 * @return the range of year settings
	 */
	@Override
	public List<YearSetting> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the year settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of year settings
	 * @param end the upper bound of the range of year settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of year settings
	 */
	@Override
	public List<YearSetting> findAll(int start, int end,
		OrderByComparator<YearSetting> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the year settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link YearSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of year settings
	 * @param end the upper bound of the range of year settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of year settings
	 */
	@Override
	public List<YearSetting> findAll(int start, int end,
		OrderByComparator<YearSetting> orderByComparator,
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

		List<YearSetting> list = null;

		if (retrieveFromCache) {
			list = (List<YearSetting>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_YEARSETTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YEARSETTING;

				if (pagination) {
					sql = sql.concat(YearSettingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<YearSetting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<YearSetting>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the year settings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (YearSetting yearSetting : findAll()) {
			remove(yearSetting);
		}
	}

	/**
	 * Returns the number of year settings.
	 *
	 * @return the number of year settings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_YEARSETTING);

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
		return YearSettingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the year setting persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(YearSettingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_YEARSETTING = "SELECT yearSetting FROM YearSetting yearSetting";
	private static final String _SQL_SELECT_YEARSETTING_WHERE_PKS_IN = "SELECT yearSetting FROM YearSetting yearSetting WHERE yearSettingId IN (";
	private static final String _SQL_SELECT_YEARSETTING_WHERE = "SELECT yearSetting FROM YearSetting yearSetting WHERE ";
	private static final String _SQL_COUNT_YEARSETTING = "SELECT COUNT(yearSetting) FROM YearSetting yearSetting";
	private static final String _SQL_COUNT_YEARSETTING_WHERE = "SELECT COUNT(yearSetting) FROM YearSetting yearSetting WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yearSetting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YearSetting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No YearSetting exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(YearSettingPersistenceImpl.class);
}