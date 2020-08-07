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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;
import com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterImpl;
import com.liferay.famocom.erpcloud.model.impl.AppraisalGoalMasterModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalMasterPersistence;

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
 * The persistence implementation for the appraisal goal master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalMasterPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalMasterUtil
 * @generated
 */
@ProviderType
public class AppraisalGoalMasterPersistenceImpl extends BasePersistenceImpl<AppraisalGoalMaster>
	implements AppraisalGoalMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppraisalGoalMasterUtil} to access the appraisal goal master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppraisalGoalMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalGoalMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalGoalMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID = new FinderPath(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterModelImpl.FINDER_CACHE_ENABLED,
			AppraisalGoalMasterImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByApprIdEmpIdProjIdEvalId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			AppraisalGoalMasterModelImpl.APPRAISALID_COLUMN_BITMASK |
			AppraisalGoalMasterModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AppraisalGoalMasterModelImpl.PROJECTID_COLUMN_BITMASK |
			AppraisalGoalMasterModelImpl.EVALUATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALID = new FinderPath(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApprIdEmpIdProjIdEvalId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or throws a {@link NoSuchAppraisalGoalMasterException} if it could not be found.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @return the matching appraisal goal master
	 * @throws NoSuchAppraisalGoalMasterException if a matching appraisal goal master could not be found
	 */
	@Override
	public AppraisalGoalMaster findByApprIdEmpIdProjIdEvalId(long appraisalId,
		long employeeId, long projectId, long evaluationId)
		throws NoSuchAppraisalGoalMasterException {
		AppraisalGoalMaster appraisalGoalMaster = fetchByApprIdEmpIdProjIdEvalId(appraisalId,
				employeeId, projectId, evaluationId);

		if (appraisalGoalMaster == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalId=");
			msg.append(appraisalId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", projectId=");
			msg.append(projectId);

			msg.append(", evaluationId=");
			msg.append(evaluationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalGoalMasterException(msg.toString());
		}

		return appraisalGoalMaster;
	}

	/**
	 * Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @return the matching appraisal goal master, or <code>null</code> if a matching appraisal goal master could not be found
	 */
	@Override
	public AppraisalGoalMaster fetchByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId) {
		return fetchByApprIdEmpIdProjIdEvalId(appraisalId, employeeId,
			projectId, evaluationId, true);
	}

	/**
	 * Returns the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal goal master, or <code>null</code> if a matching appraisal goal master could not be found
	 */
	@Override
	public AppraisalGoalMaster fetchByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				appraisalId, employeeId, projectId, evaluationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
					finderArgs, this);
		}

		if (result instanceof AppraisalGoalMaster) {
			AppraisalGoalMaster appraisalGoalMaster = (AppraisalGoalMaster)result;

			if ((appraisalId != appraisalGoalMaster.getAppraisalId()) ||
					(employeeId != appraisalGoalMaster.getEmployeeId()) ||
					(projectId != appraisalGoalMaster.getProjectId()) ||
					(evaluationId != appraisalGoalMaster.getEvaluationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_APPRAISALGOALMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_PROJECTID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_EVALUATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalId);

				qPos.add(employeeId);

				qPos.add(projectId);

				qPos.add(evaluationId);

				List<AppraisalGoalMaster> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalGoalMasterPersistenceImpl.fetchByApprIdEmpIdProjIdEvalId(long, long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalGoalMaster appraisalGoalMaster = list.get(0);

					result = appraisalGoalMaster;

					cacheResult(appraisalGoalMaster);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
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
			return (AppraisalGoalMaster)result;
		}
	}

	/**
	 * Removes the appraisal goal master where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; from the database.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @return the appraisal goal master that was removed
	 */
	@Override
	public AppraisalGoalMaster removeByApprIdEmpIdProjIdEvalId(
		long appraisalId, long employeeId, long projectId, long evaluationId)
		throws NoSuchAppraisalGoalMasterException {
		AppraisalGoalMaster appraisalGoalMaster = findByApprIdEmpIdProjIdEvalId(appraisalId,
				employeeId, projectId, evaluationId);

		return remove(appraisalGoalMaster);
	}

	/**
	 * Returns the number of appraisal goal masters where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63;.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @return the number of matching appraisal goal masters
	 */
	@Override
	public int countByApprIdEmpIdProjIdEvalId(long appraisalId,
		long employeeId, long projectId, long evaluationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALID;

		Object[] finderArgs = new Object[] {
				appraisalId, employeeId, projectId, evaluationId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_APPRAISALGOALMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_PROJECTID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_EVALUATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appraisalId);

				qPos.add(employeeId);

				qPos.add(projectId);

				qPos.add(evaluationId);

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

	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_APPRAISALID_2 =
		"appraisalGoalMaster.appraisalId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_EMPLOYEEID_2 =
		"appraisalGoalMaster.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_PROJECTID_2 =
		"appraisalGoalMaster.projectId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALID_EVALUATIONID_2 =
		"appraisalGoalMaster.evaluationId = ?";

	public AppraisalGoalMasterPersistenceImpl() {
		setModelClass(AppraisalGoalMaster.class);
	}

	/**
	 * Caches the appraisal goal master in the entity cache if it is enabled.
	 *
	 * @param appraisalGoalMaster the appraisal goal master
	 */
	@Override
	public void cacheResult(AppraisalGoalMaster appraisalGoalMaster) {
		entityCache.putResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterImpl.class, appraisalGoalMaster.getPrimaryKey(),
			appraisalGoalMaster);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
			new Object[] {
				appraisalGoalMaster.getAppraisalId(),
				appraisalGoalMaster.getEmployeeId(),
				appraisalGoalMaster.getProjectId(),
				appraisalGoalMaster.getEvaluationId()
			}, appraisalGoalMaster);

		appraisalGoalMaster.resetOriginalValues();
	}

	/**
	 * Caches the appraisal goal masters in the entity cache if it is enabled.
	 *
	 * @param appraisalGoalMasters the appraisal goal masters
	 */
	@Override
	public void cacheResult(List<AppraisalGoalMaster> appraisalGoalMasters) {
		for (AppraisalGoalMaster appraisalGoalMaster : appraisalGoalMasters) {
			if (entityCache.getResult(
						AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalGoalMasterImpl.class,
						appraisalGoalMaster.getPrimaryKey()) == null) {
				cacheResult(appraisalGoalMaster);
			}
			else {
				appraisalGoalMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appraisal goal masters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalGoalMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appraisal goal master.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalGoalMaster appraisalGoalMaster) {
		entityCache.removeResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterImpl.class, appraisalGoalMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AppraisalGoalMasterModelImpl)appraisalGoalMaster,
			true);
	}

	@Override
	public void clearCache(List<AppraisalGoalMaster> appraisalGoalMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppraisalGoalMaster appraisalGoalMaster : appraisalGoalMasters) {
			entityCache.removeResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalGoalMasterImpl.class,
				appraisalGoalMaster.getPrimaryKey());

			clearUniqueFindersCache((AppraisalGoalMasterModelImpl)appraisalGoalMaster,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalGoalMasterModelImpl appraisalGoalMasterModelImpl) {
		Object[] args = new Object[] {
				appraisalGoalMasterModelImpl.getAppraisalId(),
				appraisalGoalMasterModelImpl.getEmployeeId(),
				appraisalGoalMasterModelImpl.getProjectId(),
				appraisalGoalMasterModelImpl.getEvaluationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
			args, appraisalGoalMasterModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AppraisalGoalMasterModelImpl appraisalGoalMasterModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalGoalMasterModelImpl.getAppraisalId(),
					appraisalGoalMasterModelImpl.getEmployeeId(),
					appraisalGoalMasterModelImpl.getProjectId(),
					appraisalGoalMasterModelImpl.getEvaluationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
				args);
		}

		if ((appraisalGoalMasterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalGoalMasterModelImpl.getOriginalAppraisalId(),
					appraisalGoalMasterModelImpl.getOriginalEmployeeId(),
					appraisalGoalMasterModelImpl.getOriginalProjectId(),
					appraisalGoalMasterModelImpl.getOriginalEvaluationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALID,
				args);
		}
	}

	/**
	 * Creates a new appraisal goal master with the primary key. Does not add the appraisal goal master to the database.
	 *
	 * @param appraisalGoalMasterId the primary key for the new appraisal goal master
	 * @return the new appraisal goal master
	 */
	@Override
	public AppraisalGoalMaster create(long appraisalGoalMasterId) {
		AppraisalGoalMaster appraisalGoalMaster = new AppraisalGoalMasterImpl();

		appraisalGoalMaster.setNew(true);
		appraisalGoalMaster.setPrimaryKey(appraisalGoalMasterId);

		appraisalGoalMaster.setCompanyId(companyProvider.getCompanyId());

		return appraisalGoalMaster;
	}

	/**
	 * Removes the appraisal goal master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalGoalMasterId the primary key of the appraisal goal master
	 * @return the appraisal goal master that was removed
	 * @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	 */
	@Override
	public AppraisalGoalMaster remove(long appraisalGoalMasterId)
		throws NoSuchAppraisalGoalMasterException {
		return remove((Serializable)appraisalGoalMasterId);
	}

	/**
	 * Removes the appraisal goal master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal goal master
	 * @return the appraisal goal master that was removed
	 * @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	 */
	@Override
	public AppraisalGoalMaster remove(Serializable primaryKey)
		throws NoSuchAppraisalGoalMasterException {
		Session session = null;

		try {
			session = openSession();

			AppraisalGoalMaster appraisalGoalMaster = (AppraisalGoalMaster)session.get(AppraisalGoalMasterImpl.class,
					primaryKey);

			if (appraisalGoalMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalGoalMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appraisalGoalMaster);
		}
		catch (NoSuchAppraisalGoalMasterException nsee) {
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
	protected AppraisalGoalMaster removeImpl(
		AppraisalGoalMaster appraisalGoalMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalGoalMaster)) {
				appraisalGoalMaster = (AppraisalGoalMaster)session.get(AppraisalGoalMasterImpl.class,
						appraisalGoalMaster.getPrimaryKeyObj());
			}

			if (appraisalGoalMaster != null) {
				session.delete(appraisalGoalMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appraisalGoalMaster != null) {
			clearCache(appraisalGoalMaster);
		}

		return appraisalGoalMaster;
	}

	@Override
	public AppraisalGoalMaster updateImpl(
		AppraisalGoalMaster appraisalGoalMaster) {
		boolean isNew = appraisalGoalMaster.isNew();

		if (!(appraisalGoalMaster instanceof AppraisalGoalMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalGoalMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appraisalGoalMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalGoalMaster proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalGoalMaster implementation " +
				appraisalGoalMaster.getClass());
		}

		AppraisalGoalMasterModelImpl appraisalGoalMasterModelImpl = (AppraisalGoalMasterModelImpl)appraisalGoalMaster;

		Session session = null;

		try {
			session = openSession();

			if (appraisalGoalMaster.isNew()) {
				session.save(appraisalGoalMaster);

				appraisalGoalMaster.setNew(false);
			}
			else {
				appraisalGoalMaster = (AppraisalGoalMaster)session.merge(appraisalGoalMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AppraisalGoalMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalMasterImpl.class, appraisalGoalMaster.getPrimaryKey(),
			appraisalGoalMaster, false);

		clearUniqueFindersCache(appraisalGoalMasterModelImpl, false);
		cacheUniqueFindersCache(appraisalGoalMasterModelImpl);

		appraisalGoalMaster.resetOriginalValues();

		return appraisalGoalMaster;
	}

	/**
	 * Returns the appraisal goal master with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal goal master
	 * @return the appraisal goal master
	 * @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	 */
	@Override
	public AppraisalGoalMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalGoalMasterException {
		AppraisalGoalMaster appraisalGoalMaster = fetchByPrimaryKey(primaryKey);

		if (appraisalGoalMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalGoalMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appraisalGoalMaster;
	}

	/**
	 * Returns the appraisal goal master with the primary key or throws a {@link NoSuchAppraisalGoalMasterException} if it could not be found.
	 *
	 * @param appraisalGoalMasterId the primary key of the appraisal goal master
	 * @return the appraisal goal master
	 * @throws NoSuchAppraisalGoalMasterException if a appraisal goal master with the primary key could not be found
	 */
	@Override
	public AppraisalGoalMaster findByPrimaryKey(long appraisalGoalMasterId)
		throws NoSuchAppraisalGoalMasterException {
		return findByPrimaryKey((Serializable)appraisalGoalMasterId);
	}

	/**
	 * Returns the appraisal goal master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal goal master
	 * @return the appraisal goal master, or <code>null</code> if a appraisal goal master with the primary key could not be found
	 */
	@Override
	public AppraisalGoalMaster fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalGoalMasterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppraisalGoalMaster appraisalGoalMaster = (AppraisalGoalMaster)serializable;

		if (appraisalGoalMaster == null) {
			Session session = null;

			try {
				session = openSession();

				appraisalGoalMaster = (AppraisalGoalMaster)session.get(AppraisalGoalMasterImpl.class,
						primaryKey);

				if (appraisalGoalMaster != null) {
					cacheResult(appraisalGoalMaster);
				}
				else {
					entityCache.putResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalGoalMasterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalGoalMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appraisalGoalMaster;
	}

	/**
	 * Returns the appraisal goal master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalGoalMasterId the primary key of the appraisal goal master
	 * @return the appraisal goal master, or <code>null</code> if a appraisal goal master with the primary key could not be found
	 */
	@Override
	public AppraisalGoalMaster fetchByPrimaryKey(long appraisalGoalMasterId) {
		return fetchByPrimaryKey((Serializable)appraisalGoalMasterId);
	}

	@Override
	public Map<Serializable, AppraisalGoalMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppraisalGoalMaster> map = new HashMap<Serializable, AppraisalGoalMaster>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppraisalGoalMaster appraisalGoalMaster = fetchByPrimaryKey(primaryKey);

			if (appraisalGoalMaster != null) {
				map.put(primaryKey, appraisalGoalMaster);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalGoalMasterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppraisalGoalMaster)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPRAISALGOALMASTER_WHERE_PKS_IN);

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

			for (AppraisalGoalMaster appraisalGoalMaster : (List<AppraisalGoalMaster>)q.list()) {
				map.put(appraisalGoalMaster.getPrimaryKeyObj(),
					appraisalGoalMaster);

				cacheResult(appraisalGoalMaster);

				uncachedPrimaryKeys.remove(appraisalGoalMaster.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppraisalGoalMasterModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalGoalMasterImpl.class, primaryKey, nullModel);
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
	 * Returns all the appraisal goal masters.
	 *
	 * @return the appraisal goal masters
	 */
	@Override
	public List<AppraisalGoalMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal goal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal goal masters
	 * @param end the upper bound of the range of appraisal goal masters (not inclusive)
	 * @return the range of appraisal goal masters
	 */
	@Override
	public List<AppraisalGoalMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal goal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal goal masters
	 * @param end the upper bound of the range of appraisal goal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal goal masters
	 */
	@Override
	public List<AppraisalGoalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalGoalMaster> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal goal masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal goal masters
	 * @param end the upper bound of the range of appraisal goal masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of appraisal goal masters
	 */
	@Override
	public List<AppraisalGoalMaster> findAll(int start, int end,
		OrderByComparator<AppraisalGoalMaster> orderByComparator,
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

		List<AppraisalGoalMaster> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalGoalMaster>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPRAISALGOALMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALGOALMASTER;

				if (pagination) {
					sql = sql.concat(AppraisalGoalMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppraisalGoalMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalGoalMaster>)QueryUtil.list(q,
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
	 * Removes all the appraisal goal masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalGoalMaster appraisalGoalMaster : findAll()) {
			remove(appraisalGoalMaster);
		}
	}

	/**
	 * Returns the number of appraisal goal masters.
	 *
	 * @return the number of appraisal goal masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPRAISALGOALMASTER);

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
		return AppraisalGoalMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal goal master persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppraisalGoalMasterImpl.class.getName());
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
	private static final String _SQL_SELECT_APPRAISALGOALMASTER = "SELECT appraisalGoalMaster FROM AppraisalGoalMaster appraisalGoalMaster";
	private static final String _SQL_SELECT_APPRAISALGOALMASTER_WHERE_PKS_IN = "SELECT appraisalGoalMaster FROM AppraisalGoalMaster appraisalGoalMaster WHERE appraisalGoalMasterId IN (";
	private static final String _SQL_SELECT_APPRAISALGOALMASTER_WHERE = "SELECT appraisalGoalMaster FROM AppraisalGoalMaster appraisalGoalMaster WHERE ";
	private static final String _SQL_COUNT_APPRAISALGOALMASTER = "SELECT COUNT(appraisalGoalMaster) FROM AppraisalGoalMaster appraisalGoalMaster";
	private static final String _SQL_COUNT_APPRAISALGOALMASTER_WHERE = "SELECT COUNT(appraisalGoalMaster) FROM AppraisalGoalMaster appraisalGoalMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalGoalMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppraisalGoalMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppraisalGoalMaster exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppraisalGoalMasterPersistenceImpl.class);
}