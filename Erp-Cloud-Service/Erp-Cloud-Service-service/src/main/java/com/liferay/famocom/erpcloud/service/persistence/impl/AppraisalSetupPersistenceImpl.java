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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalSetupException;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
import com.liferay.famocom.erpcloud.model.impl.AppraisalSetupImpl;
import com.liferay.famocom.erpcloud.model.impl.AppraisalSetupModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalSetupPersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the appraisal setup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalSetupPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AppraisalSetupUtil
 * @generated
 */
@ProviderType
public class AppraisalSetupPersistenceImpl extends BasePersistenceImpl<AppraisalSetup>
	implements AppraisalSetupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppraisalSetupUtil} to access the appraisal setup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppraisalSetupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED,
			AppraisalSetupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED,
			AppraisalSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ISACTIVE = new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED,
			AppraisalSetupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByIsActive", new String[] { Long.class.getName() },
			AppraisalSetupModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISACTIVE = new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsActive",
			new String[] { Long.class.getName() });

	/**
	 * Returns the appraisal setup where isActive = &#63; or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	 *
	 * @param isActive the is active
	 * @return the matching appraisal setup
	 * @throws NoSuchAppraisalSetupException if a matching appraisal setup could not be found
	 */
	@Override
	public AppraisalSetup findByIsActive(long isActive)
		throws NoSuchAppraisalSetupException {
		AppraisalSetup appraisalSetup = fetchByIsActive(isActive);

		if (appraisalSetup == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("isActive=");
			msg.append(isActive);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalSetupException(msg.toString());
		}

		return appraisalSetup;
	}

	/**
	 * Returns the appraisal setup where isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param isActive the is active
	 * @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	 */
	@Override
	public AppraisalSetup fetchByIsActive(long isActive) {
		return fetchByIsActive(isActive, true);
	}

	/**
	 * Returns the appraisal setup where isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param isActive the is active
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	 */
	@Override
	public AppraisalSetup fetchByIsActive(long isActive,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { isActive };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ISACTIVE,
					finderArgs, this);
		}

		if (result instanceof AppraisalSetup) {
			AppraisalSetup appraisalSetup = (AppraisalSetup)result;

			if ((isActive != appraisalSetup.getIsActive())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_APPRAISALSETUP_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive);

				List<AppraisalSetup> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ISACTIVE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalSetupPersistenceImpl.fetchByIsActive(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalSetup appraisalSetup = list.get(0);

					result = appraisalSetup;

					cacheResult(appraisalSetup);
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
			return (AppraisalSetup)result;
		}
	}

	/**
	 * Removes the appraisal setup where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @return the appraisal setup that was removed
	 */
	@Override
	public AppraisalSetup removeByIsActive(long isActive)
		throws NoSuchAppraisalSetupException {
		AppraisalSetup appraisalSetup = findByIsActive(isActive);

		return remove(appraisalSetup);
	}

	/**
	 * Returns the number of appraisal setups where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching appraisal setups
	 */
	@Override
	public int countByIsActive(long isActive) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISACTIVE;

		Object[] finderArgs = new Object[] { isActive };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPRAISALSETUP_WHERE);

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

	private static final String _FINDER_COLUMN_ISACTIVE_ISACTIVE_2 = "appraisalSetup.isActive = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE =
		new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED,
			AppraisalSetupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFinancialYearAndIsActive",
			new String[] { String.class.getName(), Long.class.getName() },
			AppraisalSetupModelImpl.FINANCIALYEAR_COLUMN_BITMASK |
			AppraisalSetupModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINANCIALYEARANDISACTIVE =
		new FinderPath(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFinancialYearAndIsActive",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	 *
	 * @param financialYear the financial year
	 * @param isActive the is active
	 * @return the matching appraisal setup
	 * @throws NoSuchAppraisalSetupException if a matching appraisal setup could not be found
	 */
	@Override
	public AppraisalSetup findByFinancialYearAndIsActive(String financialYear,
		long isActive) throws NoSuchAppraisalSetupException {
		AppraisalSetup appraisalSetup = fetchByFinancialYearAndIsActive(financialYear,
				isActive);

		if (appraisalSetup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("financialYear=");
			msg.append(financialYear);

			msg.append(", isActive=");
			msg.append(isActive);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalSetupException(msg.toString());
		}

		return appraisalSetup;
	}

	/**
	 * Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param financialYear the financial year
	 * @param isActive the is active
	 * @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	 */
	@Override
	public AppraisalSetup fetchByFinancialYearAndIsActive(
		String financialYear, long isActive) {
		return fetchByFinancialYearAndIsActive(financialYear, isActive, true);
	}

	/**
	 * Returns the appraisal setup where financialYear = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param financialYear the financial year
	 * @param isActive the is active
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal setup, or <code>null</code> if a matching appraisal setup could not be found
	 */
	@Override
	public AppraisalSetup fetchByFinancialYearAndIsActive(
		String financialYear, long isActive, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { financialYear, isActive };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
					finderArgs, this);
		}

		if (result instanceof AppraisalSetup) {
			AppraisalSetup appraisalSetup = (AppraisalSetup)result;

			if (!Objects.equals(financialYear, appraisalSetup.getFinancialYear()) ||
					(isActive != appraisalSetup.getIsActive())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_APPRAISALSETUP_WHERE);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_2);
			}

			query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFinancialYear) {
					qPos.add(financialYear);
				}

				qPos.add(isActive);

				List<AppraisalSetup> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalSetupPersistenceImpl.fetchByFinancialYearAndIsActive(String, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalSetup appraisalSetup = list.get(0);

					result = appraisalSetup;

					cacheResult(appraisalSetup);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
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
			return (AppraisalSetup)result;
		}
	}

	/**
	 * Removes the appraisal setup where financialYear = &#63; and isActive = &#63; from the database.
	 *
	 * @param financialYear the financial year
	 * @param isActive the is active
	 * @return the appraisal setup that was removed
	 */
	@Override
	public AppraisalSetup removeByFinancialYearAndIsActive(
		String financialYear, long isActive)
		throws NoSuchAppraisalSetupException {
		AppraisalSetup appraisalSetup = findByFinancialYearAndIsActive(financialYear,
				isActive);

		return remove(appraisalSetup);
	}

	/**
	 * Returns the number of appraisal setups where financialYear = &#63; and isActive = &#63;.
	 *
	 * @param financialYear the financial year
	 * @param isActive the is active
	 * @return the number of matching appraisal setups
	 */
	@Override
	public int countByFinancialYearAndIsActive(String financialYear,
		long isActive) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINANCIALYEARANDISACTIVE;

		Object[] finderArgs = new Object[] { financialYear, isActive };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPRAISALSETUP_WHERE);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_2);
			}

			query.append(_FINDER_COLUMN_FINANCIALYEARANDISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFinancialYear) {
					qPos.add(financialYear);
				}

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

	private static final String _FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_1 =
		"appraisalSetup.financialYear IS NULL AND ";
	private static final String _FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_2 =
		"appraisalSetup.financialYear = ? AND ";
	private static final String _FINDER_COLUMN_FINANCIALYEARANDISACTIVE_FINANCIALYEAR_3 =
		"(appraisalSetup.financialYear IS NULL OR appraisalSetup.financialYear = '') AND ";
	private static final String _FINDER_COLUMN_FINANCIALYEARANDISACTIVE_ISACTIVE_2 =
		"appraisalSetup.isActive = ?";

	public AppraisalSetupPersistenceImpl() {
		setModelClass(AppraisalSetup.class);
	}

	/**
	 * Caches the appraisal setup in the entity cache if it is enabled.
	 *
	 * @param appraisalSetup the appraisal setup
	 */
	@Override
	public void cacheResult(AppraisalSetup appraisalSetup) {
		entityCache.putResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupImpl.class, appraisalSetup.getPrimaryKey(),
			appraisalSetup);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ISACTIVE,
			new Object[] { appraisalSetup.getIsActive() }, appraisalSetup);

		finderCache.putResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
			new Object[] {
				appraisalSetup.getFinancialYear(), appraisalSetup.getIsActive()
			}, appraisalSetup);

		appraisalSetup.resetOriginalValues();
	}

	/**
	 * Caches the appraisal setups in the entity cache if it is enabled.
	 *
	 * @param appraisalSetups the appraisal setups
	 */
	@Override
	public void cacheResult(List<AppraisalSetup> appraisalSetups) {
		for (AppraisalSetup appraisalSetup : appraisalSetups) {
			if (entityCache.getResult(
						AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalSetupImpl.class, appraisalSetup.getPrimaryKey()) == null) {
				cacheResult(appraisalSetup);
			}
			else {
				appraisalSetup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appraisal setups.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalSetupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appraisal setup.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalSetup appraisalSetup) {
		entityCache.removeResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupImpl.class, appraisalSetup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AppraisalSetupModelImpl)appraisalSetup, true);
	}

	@Override
	public void clearCache(List<AppraisalSetup> appraisalSetups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppraisalSetup appraisalSetup : appraisalSetups) {
			entityCache.removeResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalSetupImpl.class, appraisalSetup.getPrimaryKey());

			clearUniqueFindersCache((AppraisalSetupModelImpl)appraisalSetup,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalSetupModelImpl appraisalSetupModelImpl) {
		Object[] args = new Object[] { appraisalSetupModelImpl.getIsActive() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_ISACTIVE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ISACTIVE, args,
			appraisalSetupModelImpl, false);

		args = new Object[] {
				appraisalSetupModelImpl.getFinancialYear(),
				appraisalSetupModelImpl.getIsActive()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_FINANCIALYEARANDISACTIVE,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
			args, appraisalSetupModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AppraisalSetupModelImpl appraisalSetupModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { appraisalSetupModelImpl.getIsActive() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISACTIVE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ISACTIVE, args);
		}

		if ((appraisalSetupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ISACTIVE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalSetupModelImpl.getOriginalIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISACTIVE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ISACTIVE, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalSetupModelImpl.getFinancialYear(),
					appraisalSetupModelImpl.getIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FINANCIALYEARANDISACTIVE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
				args);
		}

		if ((appraisalSetupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalSetupModelImpl.getOriginalFinancialYear(),
					appraisalSetupModelImpl.getOriginalIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FINANCIALYEARANDISACTIVE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FINANCIALYEARANDISACTIVE,
				args);
		}
	}

	/**
	 * Creates a new appraisal setup with the primary key. Does not add the appraisal setup to the database.
	 *
	 * @param appraisalSettingId the primary key for the new appraisal setup
	 * @return the new appraisal setup
	 */
	@Override
	public AppraisalSetup create(long appraisalSettingId) {
		AppraisalSetup appraisalSetup = new AppraisalSetupImpl();

		appraisalSetup.setNew(true);
		appraisalSetup.setPrimaryKey(appraisalSettingId);

		appraisalSetup.setCompanyId(companyProvider.getCompanyId());

		return appraisalSetup;
	}

	/**
	 * Removes the appraisal setup with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalSettingId the primary key of the appraisal setup
	 * @return the appraisal setup that was removed
	 * @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	 */
	@Override
	public AppraisalSetup remove(long appraisalSettingId)
		throws NoSuchAppraisalSetupException {
		return remove((Serializable)appraisalSettingId);
	}

	/**
	 * Removes the appraisal setup with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal setup
	 * @return the appraisal setup that was removed
	 * @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	 */
	@Override
	public AppraisalSetup remove(Serializable primaryKey)
		throws NoSuchAppraisalSetupException {
		Session session = null;

		try {
			session = openSession();

			AppraisalSetup appraisalSetup = (AppraisalSetup)session.get(AppraisalSetupImpl.class,
					primaryKey);

			if (appraisalSetup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalSetupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appraisalSetup);
		}
		catch (NoSuchAppraisalSetupException nsee) {
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
	protected AppraisalSetup removeImpl(AppraisalSetup appraisalSetup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalSetup)) {
				appraisalSetup = (AppraisalSetup)session.get(AppraisalSetupImpl.class,
						appraisalSetup.getPrimaryKeyObj());
			}

			if (appraisalSetup != null) {
				session.delete(appraisalSetup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appraisalSetup != null) {
			clearCache(appraisalSetup);
		}

		return appraisalSetup;
	}

	@Override
	public AppraisalSetup updateImpl(AppraisalSetup appraisalSetup) {
		boolean isNew = appraisalSetup.isNew();

		if (!(appraisalSetup instanceof AppraisalSetupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalSetup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appraisalSetup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalSetup proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalSetup implementation " +
				appraisalSetup.getClass());
		}

		AppraisalSetupModelImpl appraisalSetupModelImpl = (AppraisalSetupModelImpl)appraisalSetup;

		Session session = null;

		try {
			session = openSession();

			if (appraisalSetup.isNew()) {
				session.save(appraisalSetup);

				appraisalSetup.setNew(false);
			}
			else {
				appraisalSetup = (AppraisalSetup)session.merge(appraisalSetup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AppraisalSetupModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalSetupImpl.class, appraisalSetup.getPrimaryKey(),
			appraisalSetup, false);

		clearUniqueFindersCache(appraisalSetupModelImpl, false);
		cacheUniqueFindersCache(appraisalSetupModelImpl);

		appraisalSetup.resetOriginalValues();

		return appraisalSetup;
	}

	/**
	 * Returns the appraisal setup with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal setup
	 * @return the appraisal setup
	 * @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	 */
	@Override
	public AppraisalSetup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalSetupException {
		AppraisalSetup appraisalSetup = fetchByPrimaryKey(primaryKey);

		if (appraisalSetup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalSetupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appraisalSetup;
	}

	/**
	 * Returns the appraisal setup with the primary key or throws a {@link NoSuchAppraisalSetupException} if it could not be found.
	 *
	 * @param appraisalSettingId the primary key of the appraisal setup
	 * @return the appraisal setup
	 * @throws NoSuchAppraisalSetupException if a appraisal setup with the primary key could not be found
	 */
	@Override
	public AppraisalSetup findByPrimaryKey(long appraisalSettingId)
		throws NoSuchAppraisalSetupException {
		return findByPrimaryKey((Serializable)appraisalSettingId);
	}

	/**
	 * Returns the appraisal setup with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal setup
	 * @return the appraisal setup, or <code>null</code> if a appraisal setup with the primary key could not be found
	 */
	@Override
	public AppraisalSetup fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalSetupImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppraisalSetup appraisalSetup = (AppraisalSetup)serializable;

		if (appraisalSetup == null) {
			Session session = null;

			try {
				session = openSession();

				appraisalSetup = (AppraisalSetup)session.get(AppraisalSetupImpl.class,
						primaryKey);

				if (appraisalSetup != null) {
					cacheResult(appraisalSetup);
				}
				else {
					entityCache.putResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalSetupImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalSetupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appraisalSetup;
	}

	/**
	 * Returns the appraisal setup with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalSettingId the primary key of the appraisal setup
	 * @return the appraisal setup, or <code>null</code> if a appraisal setup with the primary key could not be found
	 */
	@Override
	public AppraisalSetup fetchByPrimaryKey(long appraisalSettingId) {
		return fetchByPrimaryKey((Serializable)appraisalSettingId);
	}

	@Override
	public Map<Serializable, AppraisalSetup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppraisalSetup> map = new HashMap<Serializable, AppraisalSetup>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppraisalSetup appraisalSetup = fetchByPrimaryKey(primaryKey);

			if (appraisalSetup != null) {
				map.put(primaryKey, appraisalSetup);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalSetupImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppraisalSetup)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPRAISALSETUP_WHERE_PKS_IN);

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

			for (AppraisalSetup appraisalSetup : (List<AppraisalSetup>)q.list()) {
				map.put(appraisalSetup.getPrimaryKeyObj(), appraisalSetup);

				cacheResult(appraisalSetup);

				uncachedPrimaryKeys.remove(appraisalSetup.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppraisalSetupModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalSetupImpl.class, primaryKey, nullModel);
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
	 * Returns all the appraisal setups.
	 *
	 * @return the appraisal setups
	 */
	@Override
	public List<AppraisalSetup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal setups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal setups
	 * @param end the upper bound of the range of appraisal setups (not inclusive)
	 * @return the range of appraisal setups
	 */
	@Override
	public List<AppraisalSetup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal setups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal setups
	 * @param end the upper bound of the range of appraisal setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal setups
	 */
	@Override
	public List<AppraisalSetup> findAll(int start, int end,
		OrderByComparator<AppraisalSetup> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal setups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal setups
	 * @param end the upper bound of the range of appraisal setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of appraisal setups
	 */
	@Override
	public List<AppraisalSetup> findAll(int start, int end,
		OrderByComparator<AppraisalSetup> orderByComparator,
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

		List<AppraisalSetup> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalSetup>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPRAISALSETUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALSETUP;

				if (pagination) {
					sql = sql.concat(AppraisalSetupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppraisalSetup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalSetup>)QueryUtil.list(q,
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
	 * Removes all the appraisal setups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalSetup appraisalSetup : findAll()) {
			remove(appraisalSetup);
		}
	}

	/**
	 * Returns the number of appraisal setups.
	 *
	 * @return the number of appraisal setups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPRAISALSETUP);

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
		return AppraisalSetupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal setup persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppraisalSetupImpl.class.getName());
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
	private static final String _SQL_SELECT_APPRAISALSETUP = "SELECT appraisalSetup FROM AppraisalSetup appraisalSetup";
	private static final String _SQL_SELECT_APPRAISALSETUP_WHERE_PKS_IN = "SELECT appraisalSetup FROM AppraisalSetup appraisalSetup WHERE appraisalSettingId IN (";
	private static final String _SQL_SELECT_APPRAISALSETUP_WHERE = "SELECT appraisalSetup FROM AppraisalSetup appraisalSetup WHERE ";
	private static final String _SQL_COUNT_APPRAISALSETUP = "SELECT COUNT(appraisalSetup) FROM AppraisalSetup appraisalSetup";
	private static final String _SQL_COUNT_APPRAISALSETUP_WHERE = "SELECT COUNT(appraisalSetup) FROM AppraisalSetup appraisalSetup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalSetup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppraisalSetup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppraisalSetup exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppraisalSetupPersistenceImpl.class);
}