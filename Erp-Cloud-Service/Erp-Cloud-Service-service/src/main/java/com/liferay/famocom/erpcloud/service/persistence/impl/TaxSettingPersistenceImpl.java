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

import com.liferay.famocom.erpcloud.exception.NoSuchTaxSettingException;
import com.liferay.famocom.erpcloud.model.TaxSetting;
import com.liferay.famocom.erpcloud.model.impl.TaxSettingImpl;
import com.liferay.famocom.erpcloud.model.impl.TaxSettingModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.TaxSettingPersistence;

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
 * The persistence implementation for the tax setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see TaxSettingPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.TaxSettingUtil
 * @generated
 */
@ProviderType
public class TaxSettingPersistenceImpl extends BasePersistenceImpl<TaxSetting>
	implements TaxSettingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxSettingUtil} to access the tax setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxSettingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingModelImpl.FINDER_CACHE_ENABLED, TaxSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingModelImpl.FINDER_CACHE_ENABLED, TaxSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTID =
		new FinderPath(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingModelImpl.FINDER_CACHE_ENABLED, TaxSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycomponentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTID =
		new FinderPath(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingModelImpl.FINDER_CACHE_ENABLED, TaxSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycomponentId",
			new String[] { Long.class.getName() },
			TaxSettingModelImpl.COMPONENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPONENTID = new FinderPath(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycomponentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tax settings where componentId = &#63;.
	 *
	 * @param componentId the component ID
	 * @return the matching tax settings
	 */
	@Override
	public List<TaxSetting> findBycomponentId(long componentId) {
		return findBycomponentId(componentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax settings where componentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentId the component ID
	 * @param start the lower bound of the range of tax settings
	 * @param end the upper bound of the range of tax settings (not inclusive)
	 * @return the range of matching tax settings
	 */
	@Override
	public List<TaxSetting> findBycomponentId(long componentId, int start,
		int end) {
		return findBycomponentId(componentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tax settings where componentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentId the component ID
	 * @param start the lower bound of the range of tax settings
	 * @param end the upper bound of the range of tax settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tax settings
	 */
	@Override
	public List<TaxSetting> findBycomponentId(long componentId, int start,
		int end, OrderByComparator<TaxSetting> orderByComparator) {
		return findBycomponentId(componentId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the tax settings where componentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param componentId the component ID
	 * @param start the lower bound of the range of tax settings
	 * @param end the upper bound of the range of tax settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tax settings
	 */
	@Override
	public List<TaxSetting> findBycomponentId(long componentId, int start,
		int end, OrderByComparator<TaxSetting> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTID;
			finderArgs = new Object[] { componentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPONENTID;
			finderArgs = new Object[] { componentId, start, end, orderByComparator };
		}

		List<TaxSetting> list = null;

		if (retrieveFromCache) {
			list = (List<TaxSetting>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaxSetting taxSetting : list) {
					if ((componentId != taxSetting.getComponentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAXSETTING_WHERE);

			query.append(_FINDER_COLUMN_COMPONENTID_COMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TaxSettingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(componentId);

				if (!pagination) {
					list = (List<TaxSetting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxSetting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tax setting in the ordered set where componentId = &#63;.
	 *
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tax setting
	 * @throws NoSuchTaxSettingException if a matching tax setting could not be found
	 */
	@Override
	public TaxSetting findBycomponentId_First(long componentId,
		OrderByComparator<TaxSetting> orderByComparator)
		throws NoSuchTaxSettingException {
		TaxSetting taxSetting = fetchBycomponentId_First(componentId,
				orderByComparator);

		if (taxSetting != null) {
			return taxSetting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchTaxSettingException(msg.toString());
	}

	/**
	 * Returns the first tax setting in the ordered set where componentId = &#63;.
	 *
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tax setting, or <code>null</code> if a matching tax setting could not be found
	 */
	@Override
	public TaxSetting fetchBycomponentId_First(long componentId,
		OrderByComparator<TaxSetting> orderByComparator) {
		List<TaxSetting> list = findBycomponentId(componentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tax setting in the ordered set where componentId = &#63;.
	 *
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tax setting
	 * @throws NoSuchTaxSettingException if a matching tax setting could not be found
	 */
	@Override
	public TaxSetting findBycomponentId_Last(long componentId,
		OrderByComparator<TaxSetting> orderByComparator)
		throws NoSuchTaxSettingException {
		TaxSetting taxSetting = fetchBycomponentId_Last(componentId,
				orderByComparator);

		if (taxSetting != null) {
			return taxSetting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchTaxSettingException(msg.toString());
	}

	/**
	 * Returns the last tax setting in the ordered set where componentId = &#63;.
	 *
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tax setting, or <code>null</code> if a matching tax setting could not be found
	 */
	@Override
	public TaxSetting fetchBycomponentId_Last(long componentId,
		OrderByComparator<TaxSetting> orderByComparator) {
		int count = countBycomponentId(componentId);

		if (count == 0) {
			return null;
		}

		List<TaxSetting> list = findBycomponentId(componentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tax settings before and after the current tax setting in the ordered set where componentId = &#63;.
	 *
	 * @param taxSettingId the primary key of the current tax setting
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tax setting
	 * @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting[] findBycomponentId_PrevAndNext(long taxSettingId,
		long componentId, OrderByComparator<TaxSetting> orderByComparator)
		throws NoSuchTaxSettingException {
		TaxSetting taxSetting = findByPrimaryKey(taxSettingId);

		Session session = null;

		try {
			session = openSession();

			TaxSetting[] array = new TaxSettingImpl[3];

			array[0] = getBycomponentId_PrevAndNext(session, taxSetting,
					componentId, orderByComparator, true);

			array[1] = taxSetting;

			array[2] = getBycomponentId_PrevAndNext(session, taxSetting,
					componentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaxSetting getBycomponentId_PrevAndNext(Session session,
		TaxSetting taxSetting, long componentId,
		OrderByComparator<TaxSetting> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAXSETTING_WHERE);

		query.append(_FINDER_COLUMN_COMPONENTID_COMPONENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TaxSettingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(componentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taxSetting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaxSetting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tax settings where componentId = &#63; from the database.
	 *
	 * @param componentId the component ID
	 */
	@Override
	public void removeBycomponentId(long componentId) {
		for (TaxSetting taxSetting : findBycomponentId(componentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(taxSetting);
		}
	}

	/**
	 * Returns the number of tax settings where componentId = &#63;.
	 *
	 * @param componentId the component ID
	 * @return the number of matching tax settings
	 */
	@Override
	public int countBycomponentId(long componentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPONENTID;

		Object[] finderArgs = new Object[] { componentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAXSETTING_WHERE);

			query.append(_FINDER_COLUMN_COMPONENTID_COMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(componentId);

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

	private static final String _FINDER_COLUMN_COMPONENTID_COMPONENTID_2 = "taxSetting.componentId = ?";

	public TaxSettingPersistenceImpl() {
		setModelClass(TaxSetting.class);
	}

	/**
	 * Caches the tax setting in the entity cache if it is enabled.
	 *
	 * @param taxSetting the tax setting
	 */
	@Override
	public void cacheResult(TaxSetting taxSetting) {
		entityCache.putResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingImpl.class, taxSetting.getPrimaryKey(), taxSetting);

		taxSetting.resetOriginalValues();
	}

	/**
	 * Caches the tax settings in the entity cache if it is enabled.
	 *
	 * @param taxSettings the tax settings
	 */
	@Override
	public void cacheResult(List<TaxSetting> taxSettings) {
		for (TaxSetting taxSetting : taxSettings) {
			if (entityCache.getResult(
						TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
						TaxSettingImpl.class, taxSetting.getPrimaryKey()) == null) {
				cacheResult(taxSetting);
			}
			else {
				taxSetting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tax settings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaxSettingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tax setting.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxSetting taxSetting) {
		entityCache.removeResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingImpl.class, taxSetting.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaxSetting> taxSettings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxSetting taxSetting : taxSettings) {
			entityCache.removeResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
				TaxSettingImpl.class, taxSetting.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tax setting with the primary key. Does not add the tax setting to the database.
	 *
	 * @param taxSettingId the primary key for the new tax setting
	 * @return the new tax setting
	 */
	@Override
	public TaxSetting create(long taxSettingId) {
		TaxSetting taxSetting = new TaxSettingImpl();

		taxSetting.setNew(true);
		taxSetting.setPrimaryKey(taxSettingId);

		return taxSetting;
	}

	/**
	 * Removes the tax setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taxSettingId the primary key of the tax setting
	 * @return the tax setting that was removed
	 * @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting remove(long taxSettingId)
		throws NoSuchTaxSettingException {
		return remove((Serializable)taxSettingId);
	}

	/**
	 * Removes the tax setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tax setting
	 * @return the tax setting that was removed
	 * @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting remove(Serializable primaryKey)
		throws NoSuchTaxSettingException {
		Session session = null;

		try {
			session = openSession();

			TaxSetting taxSetting = (TaxSetting)session.get(TaxSettingImpl.class,
					primaryKey);

			if (taxSetting == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxSetting);
		}
		catch (NoSuchTaxSettingException nsee) {
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
	protected TaxSetting removeImpl(TaxSetting taxSetting) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxSetting)) {
				taxSetting = (TaxSetting)session.get(TaxSettingImpl.class,
						taxSetting.getPrimaryKeyObj());
			}

			if (taxSetting != null) {
				session.delete(taxSetting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxSetting != null) {
			clearCache(taxSetting);
		}

		return taxSetting;
	}

	@Override
	public TaxSetting updateImpl(TaxSetting taxSetting) {
		boolean isNew = taxSetting.isNew();

		if (!(taxSetting instanceof TaxSettingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taxSetting.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(taxSetting);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taxSetting proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaxSetting implementation " +
				taxSetting.getClass());
		}

		TaxSettingModelImpl taxSettingModelImpl = (TaxSettingModelImpl)taxSetting;

		Session session = null;

		try {
			session = openSession();

			if (taxSetting.isNew()) {
				session.save(taxSetting);

				taxSetting.setNew(false);
			}
			else {
				taxSetting = (TaxSetting)session.merge(taxSetting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TaxSettingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { taxSettingModelImpl.getComponentId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPONENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((taxSettingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taxSettingModelImpl.getOriginalComponentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPONENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTID,
					args);

				args = new Object[] { taxSettingModelImpl.getComponentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPONENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPONENTID,
					args);
			}
		}

		entityCache.putResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
			TaxSettingImpl.class, taxSetting.getPrimaryKey(), taxSetting, false);

		taxSetting.resetOriginalValues();

		return taxSetting;
	}

	/**
	 * Returns the tax setting with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax setting
	 * @return the tax setting
	 * @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxSettingException {
		TaxSetting taxSetting = fetchByPrimaryKey(primaryKey);

		if (taxSetting == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxSetting;
	}

	/**
	 * Returns the tax setting with the primary key or throws a {@link NoSuchTaxSettingException} if it could not be found.
	 *
	 * @param taxSettingId the primary key of the tax setting
	 * @return the tax setting
	 * @throws NoSuchTaxSettingException if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting findByPrimaryKey(long taxSettingId)
		throws NoSuchTaxSettingException {
		return findByPrimaryKey((Serializable)taxSettingId);
	}

	/**
	 * Returns the tax setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tax setting
	 * @return the tax setting, or <code>null</code> if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
				TaxSettingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaxSetting taxSetting = (TaxSetting)serializable;

		if (taxSetting == null) {
			Session session = null;

			try {
				session = openSession();

				taxSetting = (TaxSetting)session.get(TaxSettingImpl.class,
						primaryKey);

				if (taxSetting != null) {
					cacheResult(taxSetting);
				}
				else {
					entityCache.putResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
						TaxSettingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
					TaxSettingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxSetting;
	}

	/**
	 * Returns the tax setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taxSettingId the primary key of the tax setting
	 * @return the tax setting, or <code>null</code> if a tax setting with the primary key could not be found
	 */
	@Override
	public TaxSetting fetchByPrimaryKey(long taxSettingId) {
		return fetchByPrimaryKey((Serializable)taxSettingId);
	}

	@Override
	public Map<Serializable, TaxSetting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaxSetting> map = new HashMap<Serializable, TaxSetting>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaxSetting taxSetting = fetchByPrimaryKey(primaryKey);

			if (taxSetting != null) {
				map.put(primaryKey, taxSetting);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
					TaxSettingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaxSetting)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TAXSETTING_WHERE_PKS_IN);

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

			for (TaxSetting taxSetting : (List<TaxSetting>)q.list()) {
				map.put(taxSetting.getPrimaryKeyObj(), taxSetting);

				cacheResult(taxSetting);

				uncachedPrimaryKeys.remove(taxSetting.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaxSettingModelImpl.ENTITY_CACHE_ENABLED,
					TaxSettingImpl.class, primaryKey, nullModel);
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
	 * Returns all the tax settings.
	 *
	 * @return the tax settings
	 */
	@Override
	public List<TaxSetting> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tax settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax settings
	 * @param end the upper bound of the range of tax settings (not inclusive)
	 * @return the range of tax settings
	 */
	@Override
	public List<TaxSetting> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tax settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax settings
	 * @param end the upper bound of the range of tax settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tax settings
	 */
	@Override
	public List<TaxSetting> findAll(int start, int end,
		OrderByComparator<TaxSetting> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tax settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaxSettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tax settings
	 * @param end the upper bound of the range of tax settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tax settings
	 */
	@Override
	public List<TaxSetting> findAll(int start, int end,
		OrderByComparator<TaxSetting> orderByComparator,
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

		List<TaxSetting> list = null;

		if (retrieveFromCache) {
			list = (List<TaxSetting>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAXSETTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXSETTING;

				if (pagination) {
					sql = sql.concat(TaxSettingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxSetting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaxSetting>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tax settings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaxSetting taxSetting : findAll()) {
			remove(taxSetting);
		}
	}

	/**
	 * Returns the number of tax settings.
	 *
	 * @return the number of tax settings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAXSETTING);

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
		return TaxSettingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tax setting persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaxSettingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TAXSETTING = "SELECT taxSetting FROM TaxSetting taxSetting";
	private static final String _SQL_SELECT_TAXSETTING_WHERE_PKS_IN = "SELECT taxSetting FROM TaxSetting taxSetting WHERE taxSettingId IN (";
	private static final String _SQL_SELECT_TAXSETTING_WHERE = "SELECT taxSetting FROM TaxSetting taxSetting WHERE ";
	private static final String _SQL_COUNT_TAXSETTING = "SELECT COUNT(taxSetting) FROM TaxSetting taxSetting";
	private static final String _SQL_COUNT_TAXSETTING_WHERE = "SELECT COUNT(taxSetting) FROM TaxSetting taxSetting WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxSetting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxSetting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaxSetting exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TaxSettingPersistenceImpl.class);
}