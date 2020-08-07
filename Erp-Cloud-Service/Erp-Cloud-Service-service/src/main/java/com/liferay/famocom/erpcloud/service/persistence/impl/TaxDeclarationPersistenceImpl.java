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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException;
import com.liferay.famocom.erpcloud.model.TaxDeclaration;
import com.liferay.famocom.erpcloud.model.impl.TaxDeclarationImpl;
import com.liferay.famocom.erpcloud.model.impl.TaxDeclarationModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TaxDeclarationPersistence;

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
 * The persistence implementation for the tax declaration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxDeclarationPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TaxDeclarationUtil
 * @generated
 */
@ProviderType
public class TaxDeclarationPersistenceImpl extends BasePersistenceImpl<TaxDeclaration>
	implements TaxDeclarationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxDeclarationUtil} to access the tax declaration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxDeclarationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemployeeId", new String[] { Long.class.getName() },
			TaxDeclarationModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the tax declaration where employeeId = &#63; or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching tax declaration
	 * @throws NoSuchTaxDeclarationException if a matching tax declaration could not be found
	 */
	@Override
	public TaxDeclaration findByemployeeId(long employeeId)
		throws NoSuchTaxDeclarationException {
		TaxDeclaration taxDeclaration = fetchByemployeeId(employeeId);

		if (taxDeclaration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTaxDeclarationException(msg.toString());
		}

		return taxDeclaration;
	}

	/**
	 * Returns the tax declaration where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	 */
	@Override
	public TaxDeclaration fetchByemployeeId(long employeeId) {
		return fetchByemployeeId(employeeId, true);
	}

	/**
	 * Returns the tax declaration where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	 */
	@Override
	public TaxDeclaration fetchByemployeeId(long employeeId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof TaxDeclaration) {
			TaxDeclaration taxDeclaration = (TaxDeclaration)result;

			if ((employeeId != taxDeclaration.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAXDECLARATION_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				List<TaxDeclaration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TaxDeclarationPersistenceImpl.fetchByemployeeId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TaxDeclaration taxDeclaration = list.get(0);

					result = taxDeclaration;

					cacheResult(taxDeclaration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
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
			return (TaxDeclaration)result;
		}
	}

	/**
	 * Removes the tax declaration where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the tax declaration that was removed
	 */
	@Override
	public TaxDeclaration removeByemployeeId(long employeeId)
		throws NoSuchTaxDeclarationException {
		TaxDeclaration taxDeclaration = findByemployeeId(employeeId);

		return remove(taxDeclaration);
	}

	/**
	 * Returns the number of tax declarations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching tax declarations
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAXDECLARATION_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "taxDeclaration.employeeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR =
		new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED,
			TaxDeclarationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemployeeIdAndFinancialYear",
			new String[] { Long.class.getName(), String.class.getName() },
			TaxDeclarationModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			TaxDeclarationModelImpl.FINANCIALYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEIDANDFINANCIALYEAR =
		new FinderPath(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemployeeIdAndFinancialYear",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @return the matching tax declaration
	 * @throws NoSuchTaxDeclarationException if a matching tax declaration could not be found
	 */
	@Override
	public TaxDeclaration findByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) throws NoSuchTaxDeclarationException {
		TaxDeclaration taxDeclaration = fetchByemployeeIdAndFinancialYear(employeeId,
				financialYear);

		if (taxDeclaration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(", financialYear=");
			msg.append(financialYear);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTaxDeclarationException(msg.toString());
		}

		return taxDeclaration;
	}

	/**
	 * Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	 */
	@Override
	public TaxDeclaration fetchByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) {
		return fetchByemployeeIdAndFinancialYear(employeeId, financialYear, true);
	}

	/**
	 * Returns the tax declaration where employeeId = &#63; and financialYear = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tax declaration, or <code>null</code> if a matching tax declaration could not be found
	 */
	@Override
	public TaxDeclaration fetchByemployeeIdAndFinancialYear(long employeeId,
		String financialYear, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { employeeId, financialYear };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
					finderArgs, this);
		}

		if (result instanceof TaxDeclaration) {
			TaxDeclaration taxDeclaration = (TaxDeclaration)result;

			if ((employeeId != taxDeclaration.getEmployeeId()) ||
					!Objects.equals(financialYear,
						taxDeclaration.getFinancialYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TAXDECLARATION_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_EMPLOYEEID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindFinancialYear) {
					qPos.add(financialYear);
				}

				List<TaxDeclaration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TaxDeclarationPersistenceImpl.fetchByemployeeIdAndFinancialYear(long, String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TaxDeclaration taxDeclaration = list.get(0);

					result = taxDeclaration;

					cacheResult(taxDeclaration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
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
			return (TaxDeclaration)result;
		}
	}

	/**
	 * Removes the tax declaration where employeeId = &#63; and financialYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @return the tax declaration that was removed
	 */
	@Override
	public TaxDeclaration removeByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) throws NoSuchTaxDeclarationException {
		TaxDeclaration taxDeclaration = findByemployeeIdAndFinancialYear(employeeId,
				financialYear);

		return remove(taxDeclaration);
	}

	/**
	 * Returns the number of tax declarations where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @return the number of matching tax declarations
	 */
	@Override
	public int countByemployeeIdAndFinancialYear(long employeeId,
		String financialYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEIDANDFINANCIALYEAR;

		Object[] finderArgs = new Object[] { employeeId, financialYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAXDECLARATION_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_EMPLOYEEID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (bindFinancialYear) {
					qPos.add(financialYear);
				}

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

	private static final String _FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_EMPLOYEEID_2 =
		"taxDeclaration.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_1 =
		"taxDeclaration.financialYear IS NULL";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_2 =
		"taxDeclaration.financialYear = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEIDANDFINANCIALYEAR_FINANCIALYEAR_3 =
		"(taxDeclaration.financialYear IS NULL OR taxDeclaration.financialYear = '')";

	public TaxDeclarationPersistenceImpl() {
		setModelClass(TaxDeclaration.class);
	}

	/**
	 * Caches the tax declaration in the entity cache if it is enabled.
	 *
	 * @param taxDeclaration the tax declaration
	 */
	@Override
	public void cacheResult(TaxDeclaration taxDeclaration) {
		entityCache.putResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationImpl.class, taxDeclaration.getPrimaryKey(),
			taxDeclaration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] { taxDeclaration.getEmployeeId() }, taxDeclaration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
			new Object[] {
				taxDeclaration.getEmployeeId(),
				taxDeclaration.getFinancialYear()
			}, taxDeclaration);

		taxDeclaration.resetOriginalValues();
	}

	/**
	 * Caches the tax declarations in the entity cache if it is enabled.
	 *
	 * @param taxDeclarations the tax declarations
	 */
	@Override
	public void cacheResult(List<TaxDeclaration> taxDeclarations) {
		for (TaxDeclaration taxDeclaration : taxDeclarations) {
			if (entityCache.getResult(
						TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
						TaxDeclarationImpl.class, taxDeclaration.getPrimaryKey()) == null) {
				cacheResult(taxDeclaration);
			}
			else {
				taxDeclaration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tax declarations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaxDeclarationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tax declaration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxDeclaration taxDeclaration) {
		entityCache.removeResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationImpl.class, taxDeclaration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TaxDeclarationModelImpl)taxDeclaration, true);
	}

	@Override
	public void clearCache(List<TaxDeclaration> taxDeclarations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxDeclaration taxDeclaration : taxDeclarations) {
			entityCache.removeResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
				TaxDeclarationImpl.class, taxDeclaration.getPrimaryKey());

			clearUniqueFindersCache((TaxDeclarationModelImpl)taxDeclaration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TaxDeclarationModelImpl taxDeclarationModelImpl) {
		Object[] args = new Object[] { taxDeclarationModelImpl.getEmployeeId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
			taxDeclarationModelImpl, false);

		args = new Object[] {
				taxDeclarationModelImpl.getEmployeeId(),
				taxDeclarationModelImpl.getFinancialYear()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDFINANCIALYEAR,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
			args, taxDeclarationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TaxDeclarationModelImpl taxDeclarationModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { taxDeclarationModelImpl.getEmployeeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}

		if ((taxDeclarationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					taxDeclarationModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					taxDeclarationModelImpl.getEmployeeId(),
					taxDeclarationModelImpl.getFinancialYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDFINANCIALYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
				args);
		}

		if ((taxDeclarationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					taxDeclarationModelImpl.getOriginalEmployeeId(),
					taxDeclarationModelImpl.getOriginalFinancialYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEIDANDFINANCIALYEAR,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEIDANDFINANCIALYEAR,
				args);
		}
	}

	/**
	 * Creates a new tax declaration with the primary key. Does not add the tax declaration to the database.
	 *
	 * @param taxDeclarationId the primary key for the new tax declaration
	 * @return the new tax declaration
	 */
	@Override
	public TaxDeclaration create(long taxDeclarationId) {
		TaxDeclaration taxDeclaration = new TaxDeclarationImpl();

		taxDeclaration.setNew(true);
		taxDeclaration.setPrimaryKey(taxDeclarationId);

		taxDeclaration.setCompanyId(companyProvider.getCompanyId());

		return taxDeclaration;
	}

	/**
	 * Removes the tax declaration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taxDeclarationId the primary key of the tax declaration
	 * @return the tax declaration that was removed
	 * @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	 */
	@Override
	public TaxDeclaration remove(long taxDeclarationId)
		throws NoSuchTaxDeclarationException {
		return remove((Serializable)taxDeclarationId);
	}

	/**
	 * Removes the tax declaration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tax declaration
	 * @return the tax declaration that was removed
	 * @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	 */
	@Override
	public TaxDeclaration remove(Serializable primaryKey)
		throws NoSuchTaxDeclarationException {
		Session session = null;

		try {
			session = openSession();

			TaxDeclaration taxDeclaration = (TaxDeclaration)session.get(TaxDeclarationImpl.class,
					primaryKey);

			if (taxDeclaration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxDeclarationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxDeclaration);
		}
		catch (NoSuchTaxDeclarationException nsee) {
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
	protected TaxDeclaration removeImpl(TaxDeclaration taxDeclaration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxDeclaration)) {
				taxDeclaration = (TaxDeclaration)session.get(TaxDeclarationImpl.class,
						taxDeclaration.getPrimaryKeyObj());
			}

			if (taxDeclaration != null) {
				session.delete(taxDeclaration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxDeclaration != null) {
			clearCache(taxDeclaration);
		}

		return taxDeclaration;
	}

	@Override
	public TaxDeclaration updateImpl(TaxDeclaration taxDeclaration) {
		boolean isNew = taxDeclaration.isNew();

		if (!(taxDeclaration instanceof TaxDeclarationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taxDeclaration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(taxDeclaration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taxDeclaration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaxDeclaration implementation " +
				taxDeclaration.getClass());
		}

		TaxDeclarationModelImpl taxDeclarationModelImpl = (TaxDeclarationModelImpl)taxDeclaration;

		Session session = null;

		try {
			session = openSession();

			if (taxDeclaration.isNew()) {
				session.save(taxDeclaration);

				taxDeclaration.setNew(false);
			}
			else {
				taxDeclaration = (TaxDeclaration)session.merge(taxDeclaration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TaxDeclarationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
			TaxDeclarationImpl.class, taxDeclaration.getPrimaryKey(),
			taxDeclaration, false);

		clearUniqueFindersCache(taxDeclarationModelImpl, false);
		cacheUniqueFindersCache(taxDeclarationModelImpl);

		taxDeclaration.resetOriginalValues();

		return taxDeclaration;
	}

	/**
	 * Returns the tax declaration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax declaration
	 * @return the tax declaration
	 * @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	 */
	@Override
	public TaxDeclaration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxDeclarationException {
		TaxDeclaration taxDeclaration = fetchByPrimaryKey(primaryKey);

		if (taxDeclaration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxDeclarationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxDeclaration;
	}

	/**
	 * Returns the tax declaration with the primary key or throws a {@link NoSuchTaxDeclarationException} if it could not be found.
	 *
	 * @param taxDeclarationId the primary key of the tax declaration
	 * @return the tax declaration
	 * @throws NoSuchTaxDeclarationException if a tax declaration with the primary key could not be found
	 */
	@Override
	public TaxDeclaration findByPrimaryKey(long taxDeclarationId)
		throws NoSuchTaxDeclarationException {
		return findByPrimaryKey((Serializable)taxDeclarationId);
	}

	/**
	 * Returns the tax declaration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax declaration
	 * @return the tax declaration, or <code>null</code> if a tax declaration with the primary key could not be found
	 */
	@Override
	public TaxDeclaration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
				TaxDeclarationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaxDeclaration taxDeclaration = (TaxDeclaration)serializable;

		if (taxDeclaration == null) {
			Session session = null;

			try {
				session = openSession();

				taxDeclaration = (TaxDeclaration)session.get(TaxDeclarationImpl.class,
						primaryKey);

				if (taxDeclaration != null) {
					cacheResult(taxDeclaration);
				}
				else {
					entityCache.putResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
						TaxDeclarationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
					TaxDeclarationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxDeclaration;
	}

	/**
	 * Returns the tax declaration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taxDeclarationId the primary key of the tax declaration
	 * @return the tax declaration, or <code>null</code> if a tax declaration with the primary key could not be found
	 */
	@Override
	public TaxDeclaration fetchByPrimaryKey(long taxDeclarationId) {
		return fetchByPrimaryKey((Serializable)taxDeclarationId);
	}

	@Override
	public Map<Serializable, TaxDeclaration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaxDeclaration> map = new HashMap<Serializable, TaxDeclaration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaxDeclaration taxDeclaration = fetchByPrimaryKey(primaryKey);

			if (taxDeclaration != null) {
				map.put(primaryKey, taxDeclaration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
					TaxDeclarationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaxDeclaration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TAXDECLARATION_WHERE_PKS_IN);

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

			for (TaxDeclaration taxDeclaration : (List<TaxDeclaration>)q.list()) {
				map.put(taxDeclaration.getPrimaryKeyObj(), taxDeclaration);

				cacheResult(taxDeclaration);

				uncachedPrimaryKeys.remove(taxDeclaration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaxDeclarationModelImpl.ENTITY_CACHE_ENABLED,
					TaxDeclarationImpl.class, primaryKey, nullModel);
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
	 * Returns all the tax declarations.
	 *
	 * @return the tax declarations
	 */
	@Override
	public List<TaxDeclaration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax declarations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax declarations
	 * @param end the upper bound of the range of tax declarations (not inclusive)
	 * @return the range of tax declarations
	 */
	@Override
	public List<TaxDeclaration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tax declarations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax declarations
	 * @param end the upper bound of the range of tax declarations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tax declarations
	 */
	@Override
	public List<TaxDeclaration> findAll(int start, int end,
		OrderByComparator<TaxDeclaration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tax declarations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxDeclarationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax declarations
	 * @param end the upper bound of the range of tax declarations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tax declarations
	 */
	@Override
	public List<TaxDeclaration> findAll(int start, int end,
		OrderByComparator<TaxDeclaration> orderByComparator,
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

		List<TaxDeclaration> list = null;

		if (retrieveFromCache) {
			list = (List<TaxDeclaration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAXDECLARATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXDECLARATION;

				if (pagination) {
					sql = sql.concat(TaxDeclarationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxDeclaration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxDeclaration>)QueryUtil.list(q,
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
	 * Removes all the tax declarations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaxDeclaration taxDeclaration : findAll()) {
			remove(taxDeclaration);
		}
	}

	/**
	 * Returns the number of tax declarations.
	 *
	 * @return the number of tax declarations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAXDECLARATION);

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
		return TaxDeclarationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tax declaration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaxDeclarationImpl.class.getName());
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
	private static final String _SQL_SELECT_TAXDECLARATION = "SELECT taxDeclaration FROM TaxDeclaration taxDeclaration";
	private static final String _SQL_SELECT_TAXDECLARATION_WHERE_PKS_IN = "SELECT taxDeclaration FROM TaxDeclaration taxDeclaration WHERE taxDeclarationId IN (";
	private static final String _SQL_SELECT_TAXDECLARATION_WHERE = "SELECT taxDeclaration FROM TaxDeclaration taxDeclaration WHERE ";
	private static final String _SQL_COUNT_TAXDECLARATION = "SELECT COUNT(taxDeclaration) FROM TaxDeclaration taxDeclaration";
	private static final String _SQL_COUNT_TAXDECLARATION_WHERE = "SELECT COUNT(taxDeclaration) FROM TaxDeclaration taxDeclaration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxDeclaration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxDeclaration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaxDeclaration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TaxDeclarationPersistenceImpl.class);
}