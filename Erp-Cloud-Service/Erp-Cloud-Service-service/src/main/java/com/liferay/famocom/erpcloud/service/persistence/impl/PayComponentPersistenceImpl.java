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

import com.liferay.famocom.erpcloud.exception.NoSuchPayComponentException;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.impl.PayComponentImpl;
import com.liferay.famocom.erpcloud.model.impl.PayComponentModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.PayComponentPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the pay component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see PayComponentPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.PayComponentUtil
 * @generated
 */
@ProviderType
public class PayComponentPersistenceImpl extends BasePersistenceImpl<PayComponent>
	implements PayComponentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayComponentUtil} to access the pay component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayComponentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDCOMPONENTID =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynameAndcomponentId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMEANDCOMPONENTID =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBynameAndcomponentId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the pay components where name = &#63; and componentId &ne; &#63;.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @return the matching pay components
	 */
	@Override
	public List<PayComponent> findBynameAndcomponentId(String name,
		long componentId) {
		return findBynameAndcomponentId(name, componentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components where name = &#63; and componentId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of matching pay components
	 */
	@Override
	public List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end) {
		return findBynameAndcomponentId(name, componentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components where name = &#63; and componentId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return findBynameAndcomponentId(name, componentId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components where name = &#63; and componentId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBynameAndcomponentId(String name,
		long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDCOMPONENTID;
		finderArgs = new Object[] {
				name, componentId,
				
				start, end, orderByComparator
			};

		List<PayComponent> list = null;

		if (retrieveFromCache) {
			list = (List<PayComponent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayComponent payComponent : list) {
					if (!Objects.equals(name, payComponent.getName()) ||
							(componentId == payComponent.getComponentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_1);
			}
			else if (name.equals("")) {
				query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_COMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(componentId);

				if (!pagination) {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBynameAndcomponentId_First(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBynameAndcomponentId_First(name,
				componentId, orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the first pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBynameAndcomponentId_First(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator) {
		List<PayComponent> list = findBynameAndcomponentId(name, componentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBynameAndcomponentId_Last(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBynameAndcomponentId_Last(name,
				componentId, orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the last pay component in the ordered set where name = &#63; and componentId &ne; &#63;.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBynameAndcomponentId_Last(String name,
		long componentId, OrderByComparator<PayComponent> orderByComparator) {
		int count = countBynameAndcomponentId(name, componentId);

		if (count == 0) {
			return null;
		}

		List<PayComponent> list = findBynameAndcomponentId(name, componentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the pay components where name = &#63; and componentId &ne; &#63; from the database.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 */
	@Override
	public void removeBynameAndcomponentId(String name, long componentId) {
		for (PayComponent payComponent : findBynameAndcomponentId(name,
				componentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components where name = &#63; and componentId &ne; &#63;.
	 *
	 * @param name the name
	 * @param componentId the component ID
	 * @return the number of matching pay components
	 */
	@Override
	public int countBynameAndcomponentId(String name, long componentId) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMEANDCOMPONENTID;

		Object[] finderArgs = new Object[] { name, componentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYCOMPONENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_1);
			}
			else if (name.equals("")) {
				query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDCOMPONENTID_COMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_1 = "payComponent.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_2 = "payComponent.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDCOMPONENTID_NAME_3 = "(payComponent.name IS NULL OR payComponent.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDCOMPONENTID_COMPONENTID_2 = "payComponent.componentId != ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ABBREVIATIONANDCOMPONENTID =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByabbreviationAndcomponentId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ABBREVIATIONANDCOMPONENTID =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByabbreviationAndcomponentId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @return the matching pay components
	 */
	@Override
	public List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId) {
		return findByabbreviationAndcomponentId(abbreviation, componentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of matching pay components
	 */
	@Override
	public List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end) {
		return findByabbreviationAndcomponentId(abbreviation, componentId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return findByabbreviationAndcomponentId(abbreviation, componentId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findByabbreviationAndcomponentId(
		String abbreviation, long componentId, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ABBREVIATIONANDCOMPONENTID;
		finderArgs = new Object[] {
				abbreviation, componentId,
				
				start, end, orderByComparator
			};

		List<PayComponent> list = null;

		if (retrieveFromCache) {
			list = (List<PayComponent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayComponent payComponent : list) {
					if (!Objects.equals(abbreviation,
								payComponent.getAbbreviation()) ||
							(componentId == payComponent.getComponentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

			boolean bindAbbreviation = false;

			if (abbreviation == null) {
				query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_1);
			}
			else if (abbreviation.equals("")) {
				query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_3);
			}
			else {
				bindAbbreviation = true;

				query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_2);
			}

			query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_COMPONENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAbbreviation) {
					qPos.add(abbreviation);
				}

				qPos.add(componentId);

				if (!pagination) {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findByabbreviationAndcomponentId_First(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchByabbreviationAndcomponentId_First(abbreviation,
				componentId, orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("abbreviation=");
		msg.append(abbreviation);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the first pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchByabbreviationAndcomponentId_First(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator) {
		List<PayComponent> list = findByabbreviationAndcomponentId(abbreviation,
				componentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findByabbreviationAndcomponentId_Last(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchByabbreviationAndcomponentId_Last(abbreviation,
				componentId, orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("abbreviation=");
		msg.append(abbreviation);

		msg.append(", componentId=");
		msg.append(componentId);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the last pay component in the ordered set where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchByabbreviationAndcomponentId_Last(
		String abbreviation, long componentId,
		OrderByComparator<PayComponent> orderByComparator) {
		int count = countByabbreviationAndcomponentId(abbreviation, componentId);

		if (count == 0) {
			return null;
		}

		List<PayComponent> list = findByabbreviationAndcomponentId(abbreviation,
				componentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the pay components where abbreviation = &#63; and componentId &ne; &#63; from the database.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 */
	@Override
	public void removeByabbreviationAndcomponentId(String abbreviation,
		long componentId) {
		for (PayComponent payComponent : findByabbreviationAndcomponentId(
				abbreviation, componentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components where abbreviation = &#63; and componentId &ne; &#63;.
	 *
	 * @param abbreviation the abbreviation
	 * @param componentId the component ID
	 * @return the number of matching pay components
	 */
	@Override
	public int countByabbreviationAndcomponentId(String abbreviation,
		long componentId) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_ABBREVIATIONANDCOMPONENTID;

		Object[] finderArgs = new Object[] { abbreviation, componentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYCOMPONENT_WHERE);

			boolean bindAbbreviation = false;

			if (abbreviation == null) {
				query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_1);
			}
			else if (abbreviation.equals("")) {
				query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_3);
			}
			else {
				bindAbbreviation = true;

				query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_2);
			}

			query.append(_FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_COMPONENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAbbreviation) {
					qPos.add(abbreviation);
				}

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

	private static final String _FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_1 =
		"payComponent.abbreviation IS NULL AND ";
	private static final String _FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_2 =
		"payComponent.abbreviation = ? AND ";
	private static final String _FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_ABBREVIATION_3 =
		"(payComponent.abbreviation IS NULL OR payComponent.abbreviation = '') AND ";
	private static final String _FINDER_COLUMN_ABBREVIATIONANDCOMPONENTID_COMPONENTID_2 =
		"payComponent.componentId != ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytaxStatusAndpayType",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBytaxStatusAndpayType",
			new String[] { Integer.class.getName(), String.class.getName() },
			PayComponentModelImpl.TAXSTATUS_COLUMN_BITMASK |
			PayComponentModelImpl.PAYTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAXSTATUSANDPAYTYPE = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBytaxStatusAndpayType",
			new String[] { Integer.class.getName(), String.class.getName() });

	/**
	 * Returns all the pay components where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @return the matching pay components
	 */
	@Override
	public List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType) {
		return findBytaxStatusAndpayType(taxStatus, payType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components where taxStatus = &#63; and payType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of matching pay components
	 */
	@Override
	public List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType, int start, int end) {
		return findBytaxStatusAndpayType(taxStatus, payType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components where taxStatus = &#63; and payType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return findBytaxStatusAndpayType(taxStatus, payType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components where taxStatus = &#63; and payType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBytaxStatusAndpayType(int taxStatus,
		String payType, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE;
			finderArgs = new Object[] { taxStatus, payType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE;
			finderArgs = new Object[] {
					taxStatus, payType,
					
					start, end, orderByComparator
				};
		}

		List<PayComponent> list = null;

		if (retrieveFromCache) {
			list = (List<PayComponent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayComponent payComponent : list) {
					if ((taxStatus != payComponent.getTaxStatus()) ||
							!Objects.equals(payType, payComponent.getPayType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_TAXSTATUS_2);

			boolean bindPayType = false;

			if (payType == null) {
				query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_1);
			}
			else if (payType.equals("")) {
				query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_3);
			}
			else {
				bindPayType = true;

				query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxStatus);

				if (bindPayType) {
					qPos.add(payType);
				}

				if (!pagination) {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBytaxStatusAndpayType_First(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBytaxStatusAndpayType_First(taxStatus,
				payType, orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxStatus=");
		msg.append(taxStatus);

		msg.append(", payType=");
		msg.append(payType);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the first pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBytaxStatusAndpayType_First(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator) {
		List<PayComponent> list = findBytaxStatusAndpayType(taxStatus, payType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBytaxStatusAndpayType_Last(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBytaxStatusAndpayType_Last(taxStatus,
				payType, orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxStatus=");
		msg.append(taxStatus);

		msg.append(", payType=");
		msg.append(payType);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the last pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBytaxStatusAndpayType_Last(int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator) {
		int count = countBytaxStatusAndpayType(taxStatus, payType);

		if (count == 0) {
			return null;
		}

		List<PayComponent> list = findBytaxStatusAndpayType(taxStatus, payType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pay components before and after the current pay component in the ordered set where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param componentId the primary key of the current pay component
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent[] findBytaxStatusAndpayType_PrevAndNext(
		long componentId, int taxStatus, String payType,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = findByPrimaryKey(componentId);

		Session session = null;

		try {
			session = openSession();

			PayComponent[] array = new PayComponentImpl[3];

			array[0] = getBytaxStatusAndpayType_PrevAndNext(session,
					payComponent, taxStatus, payType, orderByComparator, true);

			array[1] = payComponent;

			array[2] = getBytaxStatusAndpayType_PrevAndNext(session,
					payComponent, taxStatus, payType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PayComponent getBytaxStatusAndpayType_PrevAndNext(
		Session session, PayComponent payComponent, int taxStatus,
		String payType, OrderByComparator<PayComponent> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

		query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_TAXSTATUS_2);

		boolean bindPayType = false;

		if (payType == null) {
			query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_1);
		}
		else if (payType.equals("")) {
			query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_3);
		}
		else {
			bindPayType = true;

			query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_2);
		}

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
			query.append(PayComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taxStatus);

		if (bindPayType) {
			qPos.add(payType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pay components where taxStatus = &#63; and payType = &#63; from the database.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 */
	@Override
	public void removeBytaxStatusAndpayType(int taxStatus, String payType) {
		for (PayComponent payComponent : findBytaxStatusAndpayType(taxStatus,
				payType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components where taxStatus = &#63; and payType = &#63;.
	 *
	 * @param taxStatus the tax status
	 * @param payType the pay type
	 * @return the number of matching pay components
	 */
	@Override
	public int countBytaxStatusAndpayType(int taxStatus, String payType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAXSTATUSANDPAYTYPE;

		Object[] finderArgs = new Object[] { taxStatus, payType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PAYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_TAXSTATUS_2);

			boolean bindPayType = false;

			if (payType == null) {
				query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_1);
			}
			else if (payType.equals("")) {
				query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_3);
			}
			else {
				bindPayType = true;

				query.append(_FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxStatus);

				if (bindPayType) {
					qPos.add(payType);
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

	private static final String _FINDER_COLUMN_TAXSTATUSANDPAYTYPE_TAXSTATUS_2 = "payComponent.taxStatus = ? AND ";
	private static final String _FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_1 = "payComponent.payType IS NULL";
	private static final String _FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_2 = "payComponent.payType = ?";
	private static final String _FINDER_COLUMN_TAXSTATUSANDPAYTYPE_PAYTYPE_3 = "(payComponent.payType IS NULL OR payComponent.payType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTORDER =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypayComponentOrder",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTORDER =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypayComponentOrder", new String[] { Long.class.getName() },
			PayComponentModelImpl.PAYCOMPONENTORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAYCOMPONENTORDER = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypayComponentOrder", new String[] { Long.class.getName() });

	/**
	 * Returns all the pay components where payComponentOrder = &#63;.
	 *
	 * @param payComponentOrder the pay component order
	 * @return the matching pay components
	 */
	@Override
	public List<PayComponent> findBypayComponentOrder(long payComponentOrder) {
		return findBypayComponentOrder(payComponentOrder, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components where payComponentOrder = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentOrder the pay component order
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of matching pay components
	 */
	@Override
	public List<PayComponent> findBypayComponentOrder(long payComponentOrder,
		int start, int end) {
		return findBypayComponentOrder(payComponentOrder, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components where payComponentOrder = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentOrder the pay component order
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBypayComponentOrder(long payComponentOrder,
		int start, int end, OrderByComparator<PayComponent> orderByComparator) {
		return findBypayComponentOrder(payComponentOrder, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components where payComponentOrder = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payComponentOrder the pay component order
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBypayComponentOrder(long payComponentOrder,
		int start, int end, OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTORDER;
			finderArgs = new Object[] { payComponentOrder };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYCOMPONENTORDER;
			finderArgs = new Object[] {
					payComponentOrder,
					
					start, end, orderByComparator
				};
		}

		List<PayComponent> list = null;

		if (retrieveFromCache) {
			list = (List<PayComponent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayComponent payComponent : list) {
					if ((payComponentOrder != payComponent.getPayComponentOrder())) {
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

			query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTORDER_PAYCOMPONENTORDER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentOrder);

				if (!pagination) {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pay component in the ordered set where payComponentOrder = &#63;.
	 *
	 * @param payComponentOrder the pay component order
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBypayComponentOrder_First(long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBypayComponentOrder_First(payComponentOrder,
				orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payComponentOrder=");
		msg.append(payComponentOrder);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the first pay component in the ordered set where payComponentOrder = &#63;.
	 *
	 * @param payComponentOrder the pay component order
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBypayComponentOrder_First(long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator) {
		List<PayComponent> list = findBypayComponentOrder(payComponentOrder, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay component in the ordered set where payComponentOrder = &#63;.
	 *
	 * @param payComponentOrder the pay component order
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBypayComponentOrder_Last(long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBypayComponentOrder_Last(payComponentOrder,
				orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payComponentOrder=");
		msg.append(payComponentOrder);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the last pay component in the ordered set where payComponentOrder = &#63;.
	 *
	 * @param payComponentOrder the pay component order
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBypayComponentOrder_Last(long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator) {
		int count = countBypayComponentOrder(payComponentOrder);

		if (count == 0) {
			return null;
		}

		List<PayComponent> list = findBypayComponentOrder(payComponentOrder,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pay components before and after the current pay component in the ordered set where payComponentOrder = &#63;.
	 *
	 * @param componentId the primary key of the current pay component
	 * @param payComponentOrder the pay component order
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent[] findBypayComponentOrder_PrevAndNext(
		long componentId, long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = findByPrimaryKey(componentId);

		Session session = null;

		try {
			session = openSession();

			PayComponent[] array = new PayComponentImpl[3];

			array[0] = getBypayComponentOrder_PrevAndNext(session,
					payComponent, payComponentOrder, orderByComparator, true);

			array[1] = payComponent;

			array[2] = getBypayComponentOrder_PrevAndNext(session,
					payComponent, payComponentOrder, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PayComponent getBypayComponentOrder_PrevAndNext(Session session,
		PayComponent payComponent, long payComponentOrder,
		OrderByComparator<PayComponent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

		query.append(_FINDER_COLUMN_PAYCOMPONENTORDER_PAYCOMPONENTORDER_2);

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
			query.append(PayComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(payComponentOrder);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pay components where payComponentOrder = &#63; from the database.
	 *
	 * @param payComponentOrder the pay component order
	 */
	@Override
	public void removeBypayComponentOrder(long payComponentOrder) {
		for (PayComponent payComponent : findBypayComponentOrder(
				payComponentOrder, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components where payComponentOrder = &#63;.
	 *
	 * @param payComponentOrder the pay component order
	 * @return the number of matching pay components
	 */
	@Override
	public int countBypayComponentOrder(long payComponentOrder) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYCOMPONENTORDER;

		Object[] finderArgs = new Object[] { payComponentOrder };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PAYCOMPONENT_WHERE);

			query.append(_FINDER_COLUMN_PAYCOMPONENTORDER_PAYCOMPONENTORDER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(payComponentOrder);

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

	private static final String _FINDER_COLUMN_PAYCOMPONENTORDER_PAYCOMPONENTORDER_2 =
		"payComponent.payComponentOrder = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYTYPE = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypayType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYTYPE =
		new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, PayComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypayType",
			new String[] { String.class.getName() },
			PayComponentModelImpl.PAYTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAYTYPE = new FinderPath(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypayType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the pay components where payType = &#63;.
	 *
	 * @param payType the pay type
	 * @return the matching pay components
	 */
	@Override
	public List<PayComponent> findBypayType(String payType) {
		return findBypayType(payType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components where payType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payType the pay type
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of matching pay components
	 */
	@Override
	public List<PayComponent> findBypayType(String payType, int start, int end) {
		return findBypayType(payType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components where payType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payType the pay type
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBypayType(String payType, int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return findBypayType(payType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components where payType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param payType the pay type
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pay components
	 */
	@Override
	public List<PayComponent> findBypayType(String payType, int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYTYPE;
			finderArgs = new Object[] { payType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYTYPE;
			finderArgs = new Object[] { payType, start, end, orderByComparator };
		}

		List<PayComponent> list = null;

		if (retrieveFromCache) {
			list = (List<PayComponent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PayComponent payComponent : list) {
					if (!Objects.equals(payType, payComponent.getPayType())) {
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

			query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

			boolean bindPayType = false;

			if (payType == null) {
				query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_1);
			}
			else if (payType.equals("")) {
				query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_3);
			}
			else {
				bindPayType = true;

				query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPayType) {
					qPos.add(payType);
				}

				if (!pagination) {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first pay component in the ordered set where payType = &#63;.
	 *
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBypayType_First(String payType,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBypayType_First(payType,
				orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payType=");
		msg.append(payType);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the first pay component in the ordered set where payType = &#63;.
	 *
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBypayType_First(String payType,
		OrderByComparator<PayComponent> orderByComparator) {
		List<PayComponent> list = findBypayType(payType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay component in the ordered set where payType = &#63;.
	 *
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component
	 * @throws NoSuchPayComponentException if a matching pay component could not be found
	 */
	@Override
	public PayComponent findBypayType_Last(String payType,
		OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchBypayType_Last(payType,
				orderByComparator);

		if (payComponent != null) {
			return payComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("payType=");
		msg.append(payType);

		msg.append("}");

		throw new NoSuchPayComponentException(msg.toString());
	}

	/**
	 * Returns the last pay component in the ordered set where payType = &#63;.
	 *
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay component, or <code>null</code> if a matching pay component could not be found
	 */
	@Override
	public PayComponent fetchBypayType_Last(String payType,
		OrderByComparator<PayComponent> orderByComparator) {
		int count = countBypayType(payType);

		if (count == 0) {
			return null;
		}

		List<PayComponent> list = findBypayType(payType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pay components before and after the current pay component in the ordered set where payType = &#63;.
	 *
	 * @param componentId the primary key of the current pay component
	 * @param payType the pay type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent[] findBypayType_PrevAndNext(long componentId,
		String payType, OrderByComparator<PayComponent> orderByComparator)
		throws NoSuchPayComponentException {
		PayComponent payComponent = findByPrimaryKey(componentId);

		Session session = null;

		try {
			session = openSession();

			PayComponent[] array = new PayComponentImpl[3];

			array[0] = getBypayType_PrevAndNext(session, payComponent, payType,
					orderByComparator, true);

			array[1] = payComponent;

			array[2] = getBypayType_PrevAndNext(session, payComponent, payType,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PayComponent getBypayType_PrevAndNext(Session session,
		PayComponent payComponent, String payType,
		OrderByComparator<PayComponent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYCOMPONENT_WHERE);

		boolean bindPayType = false;

		if (payType == null) {
			query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_1);
		}
		else if (payType.equals("")) {
			query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_3);
		}
		else {
			bindPayType = true;

			query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_2);
		}

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
			query.append(PayComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPayType) {
			qPos.add(payType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pay components where payType = &#63; from the database.
	 *
	 * @param payType the pay type
	 */
	@Override
	public void removeBypayType(String payType) {
		for (PayComponent payComponent : findBypayType(payType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components where payType = &#63;.
	 *
	 * @param payType the pay type
	 * @return the number of matching pay components
	 */
	@Override
	public int countBypayType(String payType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYTYPE;

		Object[] finderArgs = new Object[] { payType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PAYCOMPONENT_WHERE);

			boolean bindPayType = false;

			if (payType == null) {
				query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_1);
			}
			else if (payType.equals("")) {
				query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_3);
			}
			else {
				bindPayType = true;

				query.append(_FINDER_COLUMN_PAYTYPE_PAYTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPayType) {
					qPos.add(payType);
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

	private static final String _FINDER_COLUMN_PAYTYPE_PAYTYPE_1 = "payComponent.payType IS NULL";
	private static final String _FINDER_COLUMN_PAYTYPE_PAYTYPE_2 = "payComponent.payType = ?";
	private static final String _FINDER_COLUMN_PAYTYPE_PAYTYPE_3 = "(payComponent.payType IS NULL OR payComponent.payType = '')";

	public PayComponentPersistenceImpl() {
		setModelClass(PayComponent.class);
	}

	/**
	 * Caches the pay component in the entity cache if it is enabled.
	 *
	 * @param payComponent the pay component
	 */
	@Override
	public void cacheResult(PayComponent payComponent) {
		entityCache.putResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentImpl.class, payComponent.getPrimaryKey(), payComponent);

		payComponent.resetOriginalValues();
	}

	/**
	 * Caches the pay components in the entity cache if it is enabled.
	 *
	 * @param payComponents the pay components
	 */
	@Override
	public void cacheResult(List<PayComponent> payComponents) {
		for (PayComponent payComponent : payComponents) {
			if (entityCache.getResult(
						PayComponentModelImpl.ENTITY_CACHE_ENABLED,
						PayComponentImpl.class, payComponent.getPrimaryKey()) == null) {
				cacheResult(payComponent);
			}
			else {
				payComponent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pay components.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PayComponentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay component.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayComponent payComponent) {
		entityCache.removeResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentImpl.class, payComponent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PayComponent> payComponents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayComponent payComponent : payComponents) {
			entityCache.removeResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
				PayComponentImpl.class, payComponent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pay component with the primary key. Does not add the pay component to the database.
	 *
	 * @param componentId the primary key for the new pay component
	 * @return the new pay component
	 */
	@Override
	public PayComponent create(long componentId) {
		PayComponent payComponent = new PayComponentImpl();

		payComponent.setNew(true);
		payComponent.setPrimaryKey(componentId);

		return payComponent;
	}

	/**
	 * Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param componentId the primary key of the pay component
	 * @return the pay component that was removed
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent remove(long componentId)
		throws NoSuchPayComponentException {
		return remove((Serializable)componentId);
	}

	/**
	 * Removes the pay component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay component
	 * @return the pay component that was removed
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent remove(Serializable primaryKey)
		throws NoSuchPayComponentException {
		Session session = null;

		try {
			session = openSession();

			PayComponent payComponent = (PayComponent)session.get(PayComponentImpl.class,
					primaryKey);

			if (payComponent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payComponent);
		}
		catch (NoSuchPayComponentException nsee) {
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
	protected PayComponent removeImpl(PayComponent payComponent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payComponent)) {
				payComponent = (PayComponent)session.get(PayComponentImpl.class,
						payComponent.getPrimaryKeyObj());
			}

			if (payComponent != null) {
				session.delete(payComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payComponent != null) {
			clearCache(payComponent);
		}

		return payComponent;
	}

	@Override
	public PayComponent updateImpl(PayComponent payComponent) {
		boolean isNew = payComponent.isNew();

		if (!(payComponent instanceof PayComponentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payComponent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payComponent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payComponent proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PayComponent implementation " +
				payComponent.getClass());
		}

		PayComponentModelImpl payComponentModelImpl = (PayComponentModelImpl)payComponent;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payComponent.getCreateDate() == null)) {
			if (serviceContext == null) {
				payComponent.setCreateDate(now);
			}
			else {
				payComponent.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!payComponentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payComponent.setModifiedDate(now);
			}
			else {
				payComponent.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (payComponent.isNew()) {
				session.save(payComponent);

				payComponent.setNew(false);
			}
			else {
				payComponent = (PayComponent)session.merge(payComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PayComponentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					payComponentModelImpl.getTaxStatus(),
					payComponentModelImpl.getPayType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TAXSTATUSANDPAYTYPE,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE,
				args);

			args = new Object[] { payComponentModelImpl.getPayComponentOrder() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTORDER,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTORDER,
				args);

			args = new Object[] { payComponentModelImpl.getPayType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYTYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYTYPE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((payComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payComponentModelImpl.getOriginalTaxStatus(),
						payComponentModelImpl.getOriginalPayType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TAXSTATUSANDPAYTYPE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE,
					args);

				args = new Object[] {
						payComponentModelImpl.getTaxStatus(),
						payComponentModelImpl.getPayType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TAXSTATUSANDPAYTYPE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXSTATUSANDPAYTYPE,
					args);
			}

			if ((payComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTORDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payComponentModelImpl.getOriginalPayComponentOrder()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTORDER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTORDER,
					args);

				args = new Object[] { payComponentModelImpl.getPayComponentOrder() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYCOMPONENTORDER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYCOMPONENTORDER,
					args);
			}

			if ((payComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payComponentModelImpl.getOriginalPayType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYTYPE,
					args);

				args = new Object[] { payComponentModelImpl.getPayType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PAYTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYTYPE,
					args);
			}
		}

		entityCache.putResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
			PayComponentImpl.class, payComponent.getPrimaryKey(), payComponent,
			false);

		payComponent.resetOriginalValues();

		return payComponent;
	}

	/**
	 * Returns the pay component with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay component
	 * @return the pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayComponentException {
		PayComponent payComponent = fetchByPrimaryKey(primaryKey);

		if (payComponent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payComponent;
	}

	/**
	 * Returns the pay component with the primary key or throws a {@link NoSuchPayComponentException} if it could not be found.
	 *
	 * @param componentId the primary key of the pay component
	 * @return the pay component
	 * @throws NoSuchPayComponentException if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent findByPrimaryKey(long componentId)
		throws NoSuchPayComponentException {
		return findByPrimaryKey((Serializable)componentId);
	}

	/**
	 * Returns the pay component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay component
	 * @return the pay component, or <code>null</code> if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
				PayComponentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PayComponent payComponent = (PayComponent)serializable;

		if (payComponent == null) {
			Session session = null;

			try {
				session = openSession();

				payComponent = (PayComponent)session.get(PayComponentImpl.class,
						primaryKey);

				if (payComponent != null) {
					cacheResult(payComponent);
				}
				else {
					entityCache.putResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
						PayComponentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
					PayComponentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payComponent;
	}

	/**
	 * Returns the pay component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param componentId the primary key of the pay component
	 * @return the pay component, or <code>null</code> if a pay component with the primary key could not be found
	 */
	@Override
	public PayComponent fetchByPrimaryKey(long componentId) {
		return fetchByPrimaryKey((Serializable)componentId);
	}

	@Override
	public Map<Serializable, PayComponent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PayComponent> map = new HashMap<Serializable, PayComponent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PayComponent payComponent = fetchByPrimaryKey(primaryKey);

			if (payComponent != null) {
				map.put(primaryKey, payComponent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
					PayComponentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PayComponent)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAYCOMPONENT_WHERE_PKS_IN);

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

			for (PayComponent payComponent : (List<PayComponent>)q.list()) {
				map.put(payComponent.getPrimaryKeyObj(), payComponent);

				cacheResult(payComponent);

				uncachedPrimaryKeys.remove(payComponent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PayComponentModelImpl.ENTITY_CACHE_ENABLED,
					PayComponentImpl.class, primaryKey, nullModel);
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
	 * Returns all the pay components.
	 *
	 * @return the pay components
	 */
	@Override
	public List<PayComponent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @return the range of pay components
	 */
	@Override
	public List<PayComponent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay components
	 */
	@Override
	public List<PayComponent> findAll(int start, int end,
		OrderByComparator<PayComponent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pay components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PayComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay components
	 * @param end the upper bound of the range of pay components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pay components
	 */
	@Override
	public List<PayComponent> findAll(int start, int end,
		OrderByComparator<PayComponent> orderByComparator,
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

		List<PayComponent> list = null;

		if (retrieveFromCache) {
			list = (List<PayComponent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAYCOMPONENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYCOMPONENT;

				if (pagination) {
					sql = sql.concat(PayComponentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PayComponent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the pay components from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PayComponent payComponent : findAll()) {
			remove(payComponent);
		}
	}

	/**
	 * Returns the number of pay components.
	 *
	 * @return the number of pay components
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYCOMPONENT);

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
		return PayComponentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pay component persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PayComponentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PAYCOMPONENT = "SELECT payComponent FROM PayComponent payComponent";
	private static final String _SQL_SELECT_PAYCOMPONENT_WHERE_PKS_IN = "SELECT payComponent FROM PayComponent payComponent WHERE componentId IN (";
	private static final String _SQL_SELECT_PAYCOMPONENT_WHERE = "SELECT payComponent FROM PayComponent payComponent WHERE ";
	private static final String _SQL_COUNT_PAYCOMPONENT = "SELECT COUNT(payComponent) FROM PayComponent payComponent";
	private static final String _SQL_COUNT_PAYCOMPONENT_WHERE = "SELECT COUNT(payComponent) FROM PayComponent payComponent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payComponent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayComponent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PayComponent exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PayComponentPersistenceImpl.class);
}