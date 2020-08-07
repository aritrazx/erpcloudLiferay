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

import com.liferay.famocom.erpcloud.exception.NoSuchPayrollSlabsException;
import com.liferay.famocom.erpcloud.model.PayrollSlabs;
import com.liferay.famocom.erpcloud.model.impl.PayrollSlabsImpl;
import com.liferay.famocom.erpcloud.model.impl.PayrollSlabsModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.PayrollSlabsPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
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
 * The persistence implementation for the payroll slabs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PayrollSlabsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.PayrollSlabsUtil
 * @generated
 */
@ProviderType
public class PayrollSlabsPersistenceImpl extends BasePersistenceImpl<PayrollSlabs>
	implements PayrollSlabsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayrollSlabsUtil} to access the payroll slabs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayrollSlabsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsModelImpl.FINDER_CACHE_ENABLED, PayrollSlabsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsModelImpl.FINDER_CACHE_ENABLED, PayrollSlabsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID =
		new FinderPath(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsModelImpl.FINDER_CACHE_ENABLED, PayrollSlabsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAppraisalSettingIdRatingId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PayrollSlabsModelImpl.APPRAISALSETTINGID_COLUMN_BITMASK |
			PayrollSlabsModelImpl.RATINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDRATINGID =
		new FinderPath(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppraisalSettingIdRatingId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or throws a {@link NoSuchPayrollSlabsException} if it could not be found.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param ratingId the rating ID
	 * @return the matching payroll slabs
	 * @throws NoSuchPayrollSlabsException if a matching payroll slabs could not be found
	 */
	@Override
	public PayrollSlabs findByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws NoSuchPayrollSlabsException {
		PayrollSlabs payrollSlabs = fetchByAppraisalSettingIdRatingId(appraisalSettingId,
				ratingId);

		if (payrollSlabs == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalSettingId=");
			msg.append(appraisalSettingId);

			msg.append(", ratingId=");
			msg.append(ratingId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPayrollSlabsException(msg.toString());
		}

		return payrollSlabs;
	}

	/**
	 * Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param ratingId the rating ID
	 * @return the matching payroll slabs, or <code>null</code> if a matching payroll slabs could not be found
	 */
	@Override
	public PayrollSlabs fetchByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId) {
		return fetchByAppraisalSettingIdRatingId(appraisalSettingId, ratingId,
			true);
	}

	/**
	 * Returns the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param ratingId the rating ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching payroll slabs, or <code>null</code> if a matching payroll slabs could not be found
	 */
	@Override
	public PayrollSlabs fetchByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { appraisalSettingId, ratingId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
					finderArgs, this);
		}

		if (result instanceof PayrollSlabs) {
			PayrollSlabs payrollSlabs = (PayrollSlabs)result;

			if ((appraisalSettingId != payrollSlabs.getAppraisalSettingId()) ||
					(ratingId != payrollSlabs.getRatingId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PAYROLLSLABS_WHERE);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDRATINGID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDRATINGID_RATINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(ratingId);

				List<PayrollSlabs> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PayrollSlabsPersistenceImpl.fetchByAppraisalSettingIdRatingId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PayrollSlabs payrollSlabs = list.get(0);

					result = payrollSlabs;

					cacheResult(payrollSlabs);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
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
			return (PayrollSlabs)result;
		}
	}

	/**
	 * Removes the payroll slabs where appraisalSettingId = &#63; and ratingId = &#63; from the database.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param ratingId the rating ID
	 * @return the payroll slabs that was removed
	 */
	@Override
	public PayrollSlabs removeByAppraisalSettingIdRatingId(
		long appraisalSettingId, long ratingId)
		throws NoSuchPayrollSlabsException {
		PayrollSlabs payrollSlabs = findByAppraisalSettingIdRatingId(appraisalSettingId,
				ratingId);

		return remove(payrollSlabs);
	}

	/**
	 * Returns the number of payroll slabses where appraisalSettingId = &#63; and ratingId = &#63;.
	 *
	 * @param appraisalSettingId the appraisal setting ID
	 * @param ratingId the rating ID
	 * @return the number of matching payroll slabses
	 */
	@Override
	public int countByAppraisalSettingIdRatingId(long appraisalSettingId,
		long ratingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDRATINGID;

		Object[] finderArgs = new Object[] { appraisalSettingId, ratingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYROLLSLABS_WHERE);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDRATINGID_APPRAISALSETTINGID_2);

			query.append(_FINDER_COLUMN_APPRAISALSETTINGIDRATINGID_RATINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalSettingId);

				qPos.add(ratingId);

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

	private static final String _FINDER_COLUMN_APPRAISALSETTINGIDRATINGID_APPRAISALSETTINGID_2 =
		"payrollSlabs.appraisalSettingId = ? AND ";
	private static final String _FINDER_COLUMN_APPRAISALSETTINGIDRATINGID_RATINGID_2 =
		"payrollSlabs.ratingId = ?";

	public PayrollSlabsPersistenceImpl() {
		setModelClass(PayrollSlabs.class);
	}

	/**
	 * Caches the payroll slabs in the entity cache if it is enabled.
	 *
	 * @param payrollSlabs the payroll slabs
	 */
	@Override
	public void cacheResult(PayrollSlabs payrollSlabs) {
		entityCache.putResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsImpl.class, payrollSlabs.getPrimaryKey(), payrollSlabs);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
			new Object[] {
				payrollSlabs.getAppraisalSettingId(), payrollSlabs.getRatingId()
			}, payrollSlabs);

		payrollSlabs.resetOriginalValues();
	}

	/**
	 * Caches the payroll slabses in the entity cache if it is enabled.
	 *
	 * @param payrollSlabses the payroll slabses
	 */
	@Override
	public void cacheResult(List<PayrollSlabs> payrollSlabses) {
		for (PayrollSlabs payrollSlabs : payrollSlabses) {
			if (entityCache.getResult(
						PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
						PayrollSlabsImpl.class, payrollSlabs.getPrimaryKey()) == null) {
				cacheResult(payrollSlabs);
			}
			else {
				payrollSlabs.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all payroll slabses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayrollSlabsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payroll slabs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayrollSlabs payrollSlabs) {
		entityCache.removeResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsImpl.class, payrollSlabs.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PayrollSlabsModelImpl)payrollSlabs, true);
	}

	@Override
	public void clearCache(List<PayrollSlabs> payrollSlabses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayrollSlabs payrollSlabs : payrollSlabses) {
			entityCache.removeResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
				PayrollSlabsImpl.class, payrollSlabs.getPrimaryKey());

			clearUniqueFindersCache((PayrollSlabsModelImpl)payrollSlabs, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PayrollSlabsModelImpl payrollSlabsModelImpl) {
		Object[] args = new Object[] {
				payrollSlabsModelImpl.getAppraisalSettingId(),
				payrollSlabsModelImpl.getRatingId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDRATINGID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
			args, payrollSlabsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PayrollSlabsModelImpl payrollSlabsModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					payrollSlabsModelImpl.getAppraisalSettingId(),
					payrollSlabsModelImpl.getRatingId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDRATINGID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
				args);
		}

		if ((payrollSlabsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					payrollSlabsModelImpl.getOriginalAppraisalSettingId(),
					payrollSlabsModelImpl.getOriginalRatingId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRAISALSETTINGIDRATINGID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRAISALSETTINGIDRATINGID,
				args);
		}
	}

	/**
	 * Creates a new payroll slabs with the primary key. Does not add the payroll slabs to the database.
	 *
	 * @param payrollSlabsId the primary key for the new payroll slabs
	 * @return the new payroll slabs
	 */
	@Override
	public PayrollSlabs create(long payrollSlabsId) {
		PayrollSlabs payrollSlabs = new PayrollSlabsImpl();

		payrollSlabs.setNew(true);
		payrollSlabs.setPrimaryKey(payrollSlabsId);

		payrollSlabs.setCompanyId(companyProvider.getCompanyId());

		return payrollSlabs;
	}

	/**
	 * Removes the payroll slabs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payrollSlabsId the primary key of the payroll slabs
	 * @return the payroll slabs that was removed
	 * @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	 */
	@Override
	public PayrollSlabs remove(long payrollSlabsId)
		throws NoSuchPayrollSlabsException {
		return remove((Serializable)payrollSlabsId);
	}

	/**
	 * Removes the payroll slabs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payroll slabs
	 * @return the payroll slabs that was removed
	 * @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	 */
	@Override
	public PayrollSlabs remove(Serializable primaryKey)
		throws NoSuchPayrollSlabsException {
		Session session = null;

		try {
			session = openSession();

			PayrollSlabs payrollSlabs = (PayrollSlabs)session.get(PayrollSlabsImpl.class,
					primaryKey);

			if (payrollSlabs == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayrollSlabsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payrollSlabs);
		}
		catch (NoSuchPayrollSlabsException nsee) {
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
	protected PayrollSlabs removeImpl(PayrollSlabs payrollSlabs) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payrollSlabs)) {
				payrollSlabs = (PayrollSlabs)session.get(PayrollSlabsImpl.class,
						payrollSlabs.getPrimaryKeyObj());
			}

			if (payrollSlabs != null) {
				session.delete(payrollSlabs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payrollSlabs != null) {
			clearCache(payrollSlabs);
		}

		return payrollSlabs;
	}

	@Override
	public PayrollSlabs updateImpl(PayrollSlabs payrollSlabs) {
		boolean isNew = payrollSlabs.isNew();

		if (!(payrollSlabs instanceof PayrollSlabsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payrollSlabs.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payrollSlabs);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payrollSlabs proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayrollSlabs implementation " +
				payrollSlabs.getClass());
		}

		PayrollSlabsModelImpl payrollSlabsModelImpl = (PayrollSlabsModelImpl)payrollSlabs;

		Session session = null;

		try {
			session = openSession();

			if (payrollSlabs.isNew()) {
				session.save(payrollSlabs);

				payrollSlabs.setNew(false);
			}
			else {
				payrollSlabs = (PayrollSlabs)session.merge(payrollSlabs);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PayrollSlabsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
			PayrollSlabsImpl.class, payrollSlabs.getPrimaryKey(), payrollSlabs,
			false);

		clearUniqueFindersCache(payrollSlabsModelImpl, false);
		cacheUniqueFindersCache(payrollSlabsModelImpl);

		payrollSlabs.resetOriginalValues();

		return payrollSlabs;
	}

	/**
	 * Returns the payroll slabs with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the payroll slabs
	 * @return the payroll slabs
	 * @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	 */
	@Override
	public PayrollSlabs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayrollSlabsException {
		PayrollSlabs payrollSlabs = fetchByPrimaryKey(primaryKey);

		if (payrollSlabs == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayrollSlabsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payrollSlabs;
	}

	/**
	 * Returns the payroll slabs with the primary key or throws a {@link NoSuchPayrollSlabsException} if it could not be found.
	 *
	 * @param payrollSlabsId the primary key of the payroll slabs
	 * @return the payroll slabs
	 * @throws NoSuchPayrollSlabsException if a payroll slabs with the primary key could not be found
	 */
	@Override
	public PayrollSlabs findByPrimaryKey(long payrollSlabsId)
		throws NoSuchPayrollSlabsException {
		return findByPrimaryKey((Serializable)payrollSlabsId);
	}

	/**
	 * Returns the payroll slabs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payroll slabs
	 * @return the payroll slabs, or <code>null</code> if a payroll slabs with the primary key could not be found
	 */
	@Override
	public PayrollSlabs fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
				PayrollSlabsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PayrollSlabs payrollSlabs = (PayrollSlabs)serializable;

		if (payrollSlabs == null) {
			Session session = null;

			try {
				session = openSession();

				payrollSlabs = (PayrollSlabs)session.get(PayrollSlabsImpl.class,
						primaryKey);

				if (payrollSlabs != null) {
					cacheResult(payrollSlabs);
				}
				else {
					entityCache.putResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
						PayrollSlabsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
					PayrollSlabsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payrollSlabs;
	}

	/**
	 * Returns the payroll slabs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payrollSlabsId the primary key of the payroll slabs
	 * @return the payroll slabs, or <code>null</code> if a payroll slabs with the primary key could not be found
	 */
	@Override
	public PayrollSlabs fetchByPrimaryKey(long payrollSlabsId) {
		return fetchByPrimaryKey((Serializable)payrollSlabsId);
	}

	@Override
	public Map<Serializable, PayrollSlabs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PayrollSlabs> map = new HashMap<Serializable, PayrollSlabs>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PayrollSlabs payrollSlabs = fetchByPrimaryKey(primaryKey);

			if (payrollSlabs != null) {
				map.put(primaryKey, payrollSlabs);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
					PayrollSlabsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PayrollSlabs)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAYROLLSLABS_WHERE_PKS_IN);

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

			for (PayrollSlabs payrollSlabs : (List<PayrollSlabs>)q.list()) {
				map.put(payrollSlabs.getPrimaryKeyObj(), payrollSlabs);

				cacheResult(payrollSlabs);

				uncachedPrimaryKeys.remove(payrollSlabs.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PayrollSlabsModelImpl.ENTITY_CACHE_ENABLED,
					PayrollSlabsImpl.class, primaryKey, nullModel);
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
	 * Returns all the payroll slabses.
	 *
	 * @return the payroll slabses
	 */
	@Override
	public List<PayrollSlabs> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payroll slabses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payroll slabses
	 * @param end the upper bound of the range of payroll slabses (not inclusive)
	 * @return the range of payroll slabses
	 */
	@Override
	public List<PayrollSlabs> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payroll slabses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payroll slabses
	 * @param end the upper bound of the range of payroll slabses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payroll slabses
	 */
	@Override
	public List<PayrollSlabs> findAll(int start, int end,
		OrderByComparator<PayrollSlabs> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payroll slabses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayrollSlabsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payroll slabses
	 * @param end the upper bound of the range of payroll slabses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of payroll slabses
	 */
	@Override
	public List<PayrollSlabs> findAll(int start, int end,
		OrderByComparator<PayrollSlabs> orderByComparator,
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

		List<PayrollSlabs> list = null;

		if (retrieveFromCache) {
			list = (List<PayrollSlabs>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAYROLLSLABS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYROLLSLABS;

				if (pagination) {
					sql = sql.concat(PayrollSlabsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayrollSlabs>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayrollSlabs>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the payroll slabses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayrollSlabs payrollSlabs : findAll()) {
			remove(payrollSlabs);
		}
	}

	/**
	 * Returns the number of payroll slabses.
	 *
	 * @return the number of payroll slabses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYROLLSLABS);

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
		return PayrollSlabsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payroll slabs persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PayrollSlabsImpl.class.getName());
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
	private static final String _SQL_SELECT_PAYROLLSLABS = "SELECT payrollSlabs FROM PayrollSlabs payrollSlabs";
	private static final String _SQL_SELECT_PAYROLLSLABS_WHERE_PKS_IN = "SELECT payrollSlabs FROM PayrollSlabs payrollSlabs WHERE payrollSlabsId IN (";
	private static final String _SQL_SELECT_PAYROLLSLABS_WHERE = "SELECT payrollSlabs FROM PayrollSlabs payrollSlabs WHERE ";
	private static final String _SQL_COUNT_PAYROLLSLABS = "SELECT COUNT(payrollSlabs) FROM PayrollSlabs payrollSlabs";
	private static final String _SQL_COUNT_PAYROLLSLABS_WHERE = "SELECT COUNT(payrollSlabs) FROM PayrollSlabs payrollSlabs WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payrollSlabs.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayrollSlabs exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PayrollSlabs exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PayrollSlabsPersistenceImpl.class);
}