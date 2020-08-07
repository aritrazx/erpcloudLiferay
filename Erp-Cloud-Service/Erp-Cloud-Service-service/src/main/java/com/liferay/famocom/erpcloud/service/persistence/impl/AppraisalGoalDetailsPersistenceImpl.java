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

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalGoalDetailsException;
import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsImpl;
import com.liferay.famocom.erpcloud.model.impl.AppraisalGoalDetailsModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalDetailsPersistence;

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
 * The persistence implementation for the appraisal goal details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalDetailsPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalDetailsUtil
 * @generated
 */
@ProviderType
public class AppraisalGoalDetailsPersistenceImpl extends BasePersistenceImpl<AppraisalGoalDetails>
	implements AppraisalGoalDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppraisalGoalDetailsUtil} to access the appraisal goal details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppraisalGoalDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsModelImpl.FINDER_CACHE_ENABLED,
			AppraisalGoalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsModelImpl.FINDER_CACHE_ENABLED,
			AppraisalGoalDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID =
		new FinderPath(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsModelImpl.FINDER_CACHE_ENABLED,
			AppraisalGoalDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByApprIdEmpIdProjIdEvalIdGoalDetId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			AppraisalGoalDetailsModelImpl.APPRAISALID_COLUMN_BITMASK |
			AppraisalGoalDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			AppraisalGoalDetailsModelImpl.PROJECTID_COLUMN_BITMASK |
			AppraisalGoalDetailsModelImpl.EVALUATIONID_COLUMN_BITMASK |
			AppraisalGoalDetailsModelImpl.GOALDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID =
		new FinderPath(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApprIdEmpIdProjIdEvalIdGoalDetId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; or throws a {@link NoSuchAppraisalGoalDetailsException} if it could not be found.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @param goaldetailId the goaldetail ID
	 * @return the matching appraisal goal details
	 * @throws NoSuchAppraisalGoalDetailsException if a matching appraisal goal details could not be found
	 */
	@Override
	public AppraisalGoalDetails findByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId) throws NoSuchAppraisalGoalDetailsException {
		AppraisalGoalDetails appraisalGoalDetails = fetchByApprIdEmpIdProjIdEvalIdGoalDetId(appraisalId,
				employeeId, projectId, evaluationId, goaldetailId);

		if (appraisalGoalDetails == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("appraisalId=");
			msg.append(appraisalId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", projectId=");
			msg.append(projectId);

			msg.append(", evaluationId=");
			msg.append(evaluationId);

			msg.append(", goaldetailId=");
			msg.append(goaldetailId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAppraisalGoalDetailsException(msg.toString());
		}

		return appraisalGoalDetails;
	}

	/**
	 * Returns the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @param goaldetailId the goaldetail ID
	 * @return the matching appraisal goal details, or <code>null</code> if a matching appraisal goal details could not be found
	 */
	@Override
	public AppraisalGoalDetails fetchByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId) {
		return fetchByApprIdEmpIdProjIdEvalIdGoalDetId(appraisalId, employeeId,
			projectId, evaluationId, goaldetailId, true);
	}

	/**
	 * Returns the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @param goaldetailId the goaldetail ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching appraisal goal details, or <code>null</code> if a matching appraisal goal details could not be found
	 */
	@Override
	public AppraisalGoalDetails fetchByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				appraisalId, employeeId, projectId, evaluationId, goaldetailId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
					finderArgs, this);
		}

		if (result instanceof AppraisalGoalDetails) {
			AppraisalGoalDetails appraisalGoalDetails = (AppraisalGoalDetails)result;

			if ((appraisalId != appraisalGoalDetails.getAppraisalId()) ||
					(employeeId != appraisalGoalDetails.getEmployeeId()) ||
					(projectId != appraisalGoalDetails.getProjectId()) ||
					(evaluationId != appraisalGoalDetails.getEvaluationId()) ||
					(goaldetailId != appraisalGoalDetails.getGoaldetailId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_APPRAISALGOALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_PROJECTID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_EVALUATIONID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_GOALDETAILID_2);

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

				qPos.add(goaldetailId);

				List<AppraisalGoalDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AppraisalGoalDetailsPersistenceImpl.fetchByApprIdEmpIdProjIdEvalIdGoalDetId(long, long, long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AppraisalGoalDetails appraisalGoalDetails = list.get(0);

					result = appraisalGoalDetails;

					cacheResult(appraisalGoalDetails);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
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
			return (AppraisalGoalDetails)result;
		}
	}

	/**
	 * Removes the appraisal goal details where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63; from the database.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @param goaldetailId the goaldetail ID
	 * @return the appraisal goal details that was removed
	 */
	@Override
	public AppraisalGoalDetails removeByApprIdEmpIdProjIdEvalIdGoalDetId(
		long appraisalId, long employeeId, long projectId, long evaluationId,
		long goaldetailId) throws NoSuchAppraisalGoalDetailsException {
		AppraisalGoalDetails appraisalGoalDetails = findByApprIdEmpIdProjIdEvalIdGoalDetId(appraisalId,
				employeeId, projectId, evaluationId, goaldetailId);

		return remove(appraisalGoalDetails);
	}

	/**
	 * Returns the number of appraisal goal detailses where appraisalId = &#63; and employeeId = &#63; and projectId = &#63; and evaluationId = &#63; and goaldetailId = &#63;.
	 *
	 * @param appraisalId the appraisal ID
	 * @param employeeId the employee ID
	 * @param projectId the project ID
	 * @param evaluationId the evaluation ID
	 * @param goaldetailId the goaldetail ID
	 * @return the number of matching appraisal goal detailses
	 */
	@Override
	public int countByApprIdEmpIdProjIdEvalIdGoalDetId(long appraisalId,
		long employeeId, long projectId, long evaluationId, long goaldetailId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID;

		Object[] finderArgs = new Object[] {
				appraisalId, employeeId, projectId, evaluationId, goaldetailId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_APPRAISALGOALDETAILS_WHERE);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_APPRAISALID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_PROJECTID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_EVALUATIONID_2);

			query.append(_FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_GOALDETAILID_2);

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

				qPos.add(goaldetailId);

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

	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_APPRAISALID_2 =
		"appraisalGoalDetails.appraisalId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_EMPLOYEEID_2 =
		"appraisalGoalDetails.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_PROJECTID_2 =
		"appraisalGoalDetails.projectId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_EVALUATIONID_2 =
		"appraisalGoalDetails.evaluationId = ? AND ";
	private static final String _FINDER_COLUMN_APPRIDEMPIDPROJIDEVALIDGOALDETID_GOALDETAILID_2 =
		"appraisalGoalDetails.goaldetailId = ?";

	public AppraisalGoalDetailsPersistenceImpl() {
		setModelClass(AppraisalGoalDetails.class);
	}

	/**
	 * Caches the appraisal goal details in the entity cache if it is enabled.
	 *
	 * @param appraisalGoalDetails the appraisal goal details
	 */
	@Override
	public void cacheResult(AppraisalGoalDetails appraisalGoalDetails) {
		entityCache.putResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsImpl.class,
			appraisalGoalDetails.getPrimaryKey(), appraisalGoalDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
			new Object[] {
				appraisalGoalDetails.getAppraisalId(),
				appraisalGoalDetails.getEmployeeId(),
				appraisalGoalDetails.getProjectId(),
				appraisalGoalDetails.getEvaluationId(),
				appraisalGoalDetails.getGoaldetailId()
			}, appraisalGoalDetails);

		appraisalGoalDetails.resetOriginalValues();
	}

	/**
	 * Caches the appraisal goal detailses in the entity cache if it is enabled.
	 *
	 * @param appraisalGoalDetailses the appraisal goal detailses
	 */
	@Override
	public void cacheResult(List<AppraisalGoalDetails> appraisalGoalDetailses) {
		for (AppraisalGoalDetails appraisalGoalDetails : appraisalGoalDetailses) {
			if (entityCache.getResult(
						AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalGoalDetailsImpl.class,
						appraisalGoalDetails.getPrimaryKey()) == null) {
				cacheResult(appraisalGoalDetails);
			}
			else {
				appraisalGoalDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all appraisal goal detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppraisalGoalDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the appraisal goal details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AppraisalGoalDetails appraisalGoalDetails) {
		entityCache.removeResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsImpl.class, appraisalGoalDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AppraisalGoalDetailsModelImpl)appraisalGoalDetails,
			true);
	}

	@Override
	public void clearCache(List<AppraisalGoalDetails> appraisalGoalDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AppraisalGoalDetails appraisalGoalDetails : appraisalGoalDetailses) {
			entityCache.removeResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalGoalDetailsImpl.class,
				appraisalGoalDetails.getPrimaryKey());

			clearUniqueFindersCache((AppraisalGoalDetailsModelImpl)appraisalGoalDetails,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		AppraisalGoalDetailsModelImpl appraisalGoalDetailsModelImpl) {
		Object[] args = new Object[] {
				appraisalGoalDetailsModelImpl.getAppraisalId(),
				appraisalGoalDetailsModelImpl.getEmployeeId(),
				appraisalGoalDetailsModelImpl.getProjectId(),
				appraisalGoalDetailsModelImpl.getEvaluationId(),
				appraisalGoalDetailsModelImpl.getGoaldetailId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
			args, appraisalGoalDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AppraisalGoalDetailsModelImpl appraisalGoalDetailsModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					appraisalGoalDetailsModelImpl.getAppraisalId(),
					appraisalGoalDetailsModelImpl.getEmployeeId(),
					appraisalGoalDetailsModelImpl.getProjectId(),
					appraisalGoalDetailsModelImpl.getEvaluationId(),
					appraisalGoalDetailsModelImpl.getGoaldetailId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
				args);
		}

		if ((appraisalGoalDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					appraisalGoalDetailsModelImpl.getOriginalAppraisalId(),
					appraisalGoalDetailsModelImpl.getOriginalEmployeeId(),
					appraisalGoalDetailsModelImpl.getOriginalProjectId(),
					appraisalGoalDetailsModelImpl.getOriginalEvaluationId(),
					appraisalGoalDetailsModelImpl.getOriginalGoaldetailId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPRIDEMPIDPROJIDEVALIDGOALDETID,
				args);
		}
	}

	/**
	 * Creates a new appraisal goal details with the primary key. Does not add the appraisal goal details to the database.
	 *
	 * @param appraisalGoalDetailsId the primary key for the new appraisal goal details
	 * @return the new appraisal goal details
	 */
	@Override
	public AppraisalGoalDetails create(long appraisalGoalDetailsId) {
		AppraisalGoalDetails appraisalGoalDetails = new AppraisalGoalDetailsImpl();

		appraisalGoalDetails.setNew(true);
		appraisalGoalDetails.setPrimaryKey(appraisalGoalDetailsId);

		appraisalGoalDetails.setCompanyId(companyProvider.getCompanyId());

		return appraisalGoalDetails;
	}

	/**
	 * Removes the appraisal goal details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalGoalDetailsId the primary key of the appraisal goal details
	 * @return the appraisal goal details that was removed
	 * @throws NoSuchAppraisalGoalDetailsException if a appraisal goal details with the primary key could not be found
	 */
	@Override
	public AppraisalGoalDetails remove(long appraisalGoalDetailsId)
		throws NoSuchAppraisalGoalDetailsException {
		return remove((Serializable)appraisalGoalDetailsId);
	}

	/**
	 * Removes the appraisal goal details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the appraisal goal details
	 * @return the appraisal goal details that was removed
	 * @throws NoSuchAppraisalGoalDetailsException if a appraisal goal details with the primary key could not be found
	 */
	@Override
	public AppraisalGoalDetails remove(Serializable primaryKey)
		throws NoSuchAppraisalGoalDetailsException {
		Session session = null;

		try {
			session = openSession();

			AppraisalGoalDetails appraisalGoalDetails = (AppraisalGoalDetails)session.get(AppraisalGoalDetailsImpl.class,
					primaryKey);

			if (appraisalGoalDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppraisalGoalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(appraisalGoalDetails);
		}
		catch (NoSuchAppraisalGoalDetailsException nsee) {
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
	protected AppraisalGoalDetails removeImpl(
		AppraisalGoalDetails appraisalGoalDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(appraisalGoalDetails)) {
				appraisalGoalDetails = (AppraisalGoalDetails)session.get(AppraisalGoalDetailsImpl.class,
						appraisalGoalDetails.getPrimaryKeyObj());
			}

			if (appraisalGoalDetails != null) {
				session.delete(appraisalGoalDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (appraisalGoalDetails != null) {
			clearCache(appraisalGoalDetails);
		}

		return appraisalGoalDetails;
	}

	@Override
	public AppraisalGoalDetails updateImpl(
		AppraisalGoalDetails appraisalGoalDetails) {
		boolean isNew = appraisalGoalDetails.isNew();

		if (!(appraisalGoalDetails instanceof AppraisalGoalDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(appraisalGoalDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(appraisalGoalDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in appraisalGoalDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AppraisalGoalDetails implementation " +
				appraisalGoalDetails.getClass());
		}

		AppraisalGoalDetailsModelImpl appraisalGoalDetailsModelImpl = (AppraisalGoalDetailsModelImpl)appraisalGoalDetails;

		Session session = null;

		try {
			session = openSession();

			if (appraisalGoalDetails.isNew()) {
				session.save(appraisalGoalDetails);

				appraisalGoalDetails.setNew(false);
			}
			else {
				appraisalGoalDetails = (AppraisalGoalDetails)session.merge(appraisalGoalDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AppraisalGoalDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
			AppraisalGoalDetailsImpl.class,
			appraisalGoalDetails.getPrimaryKey(), appraisalGoalDetails, false);

		clearUniqueFindersCache(appraisalGoalDetailsModelImpl, false);
		cacheUniqueFindersCache(appraisalGoalDetailsModelImpl);

		appraisalGoalDetails.resetOriginalValues();

		return appraisalGoalDetails;
	}

	/**
	 * Returns the appraisal goal details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal goal details
	 * @return the appraisal goal details
	 * @throws NoSuchAppraisalGoalDetailsException if a appraisal goal details with the primary key could not be found
	 */
	@Override
	public AppraisalGoalDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppraisalGoalDetailsException {
		AppraisalGoalDetails appraisalGoalDetails = fetchByPrimaryKey(primaryKey);

		if (appraisalGoalDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppraisalGoalDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return appraisalGoalDetails;
	}

	/**
	 * Returns the appraisal goal details with the primary key or throws a {@link NoSuchAppraisalGoalDetailsException} if it could not be found.
	 *
	 * @param appraisalGoalDetailsId the primary key of the appraisal goal details
	 * @return the appraisal goal details
	 * @throws NoSuchAppraisalGoalDetailsException if a appraisal goal details with the primary key could not be found
	 */
	@Override
	public AppraisalGoalDetails findByPrimaryKey(long appraisalGoalDetailsId)
		throws NoSuchAppraisalGoalDetailsException {
		return findByPrimaryKey((Serializable)appraisalGoalDetailsId);
	}

	/**
	 * Returns the appraisal goal details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the appraisal goal details
	 * @return the appraisal goal details, or <code>null</code> if a appraisal goal details with the primary key could not be found
	 */
	@Override
	public AppraisalGoalDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
				AppraisalGoalDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AppraisalGoalDetails appraisalGoalDetails = (AppraisalGoalDetails)serializable;

		if (appraisalGoalDetails == null) {
			Session session = null;

			try {
				session = openSession();

				appraisalGoalDetails = (AppraisalGoalDetails)session.get(AppraisalGoalDetailsImpl.class,
						primaryKey);

				if (appraisalGoalDetails != null) {
					cacheResult(appraisalGoalDetails);
				}
				else {
					entityCache.putResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
						AppraisalGoalDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalGoalDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return appraisalGoalDetails;
	}

	/**
	 * Returns the appraisal goal details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appraisalGoalDetailsId the primary key of the appraisal goal details
	 * @return the appraisal goal details, or <code>null</code> if a appraisal goal details with the primary key could not be found
	 */
	@Override
	public AppraisalGoalDetails fetchByPrimaryKey(long appraisalGoalDetailsId) {
		return fetchByPrimaryKey((Serializable)appraisalGoalDetailsId);
	}

	@Override
	public Map<Serializable, AppraisalGoalDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AppraisalGoalDetails> map = new HashMap<Serializable, AppraisalGoalDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AppraisalGoalDetails appraisalGoalDetails = fetchByPrimaryKey(primaryKey);

			if (appraisalGoalDetails != null) {
				map.put(primaryKey, appraisalGoalDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalGoalDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AppraisalGoalDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPRAISALGOALDETAILS_WHERE_PKS_IN);

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

			for (AppraisalGoalDetails appraisalGoalDetails : (List<AppraisalGoalDetails>)q.list()) {
				map.put(appraisalGoalDetails.getPrimaryKeyObj(),
					appraisalGoalDetails);

				cacheResult(appraisalGoalDetails);

				uncachedPrimaryKeys.remove(appraisalGoalDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppraisalGoalDetailsModelImpl.ENTITY_CACHE_ENABLED,
					AppraisalGoalDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the appraisal goal detailses.
	 *
	 * @return the appraisal goal detailses
	 */
	@Override
	public List<AppraisalGoalDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the appraisal goal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal goal detailses
	 * @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	 * @return the range of appraisal goal detailses
	 */
	@Override
	public List<AppraisalGoalDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the appraisal goal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal goal detailses
	 * @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appraisal goal detailses
	 */
	@Override
	public List<AppraisalGoalDetails> findAll(int start, int end,
		OrderByComparator<AppraisalGoalDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the appraisal goal detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppraisalGoalDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal goal detailses
	 * @param end the upper bound of the range of appraisal goal detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of appraisal goal detailses
	 */
	@Override
	public List<AppraisalGoalDetails> findAll(int start, int end,
		OrderByComparator<AppraisalGoalDetails> orderByComparator,
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

		List<AppraisalGoalDetails> list = null;

		if (retrieveFromCache) {
			list = (List<AppraisalGoalDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPRAISALGOALDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPRAISALGOALDETAILS;

				if (pagination) {
					sql = sql.concat(AppraisalGoalDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AppraisalGoalDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AppraisalGoalDetails>)QueryUtil.list(q,
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
	 * Removes all the appraisal goal detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AppraisalGoalDetails appraisalGoalDetails : findAll()) {
			remove(appraisalGoalDetails);
		}
	}

	/**
	 * Returns the number of appraisal goal detailses.
	 *
	 * @return the number of appraisal goal detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPRAISALGOALDETAILS);

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
		return AppraisalGoalDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the appraisal goal details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppraisalGoalDetailsImpl.class.getName());
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
	private static final String _SQL_SELECT_APPRAISALGOALDETAILS = "SELECT appraisalGoalDetails FROM AppraisalGoalDetails appraisalGoalDetails";
	private static final String _SQL_SELECT_APPRAISALGOALDETAILS_WHERE_PKS_IN = "SELECT appraisalGoalDetails FROM AppraisalGoalDetails appraisalGoalDetails WHERE appraisalGoalDetailsId IN (";
	private static final String _SQL_SELECT_APPRAISALGOALDETAILS_WHERE = "SELECT appraisalGoalDetails FROM AppraisalGoalDetails appraisalGoalDetails WHERE ";
	private static final String _SQL_COUNT_APPRAISALGOALDETAILS = "SELECT COUNT(appraisalGoalDetails) FROM AppraisalGoalDetails appraisalGoalDetails";
	private static final String _SQL_COUNT_APPRAISALGOALDETAILS_WHERE = "SELECT COUNT(appraisalGoalDetails) FROM AppraisalGoalDetails appraisalGoalDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "appraisalGoalDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppraisalGoalDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppraisalGoalDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppraisalGoalDetailsPersistenceImpl.class);
}