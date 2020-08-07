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

import com.liferay.famocom.erpcloud.exception.NoSuchFormSixteenException;
import com.liferay.famocom.erpcloud.model.FormSixteen;
import com.liferay.famocom.erpcloud.model.impl.FormSixteenImpl;
import com.liferay.famocom.erpcloud.model.impl.FormSixteenModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.FormSixteenPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
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
 * The persistence implementation for the form sixteen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see FormSixteenPersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.FormSixteenUtil
 * @generated
 */
@ProviderType
public class FormSixteenPersistenceImpl extends BasePersistenceImpl<FormSixteen>
	implements FormSixteenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FormSixteenUtil} to access the form sixteen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FormSixteenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenModelImpl.FINDER_CACHE_ENABLED, FormSixteenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenModelImpl.FINDER_CACHE_ENABLED, FormSixteenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETFORM = new FinderPath(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenModelImpl.FINDER_CACHE_ENABLED, FormSixteenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetForm",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETFORM =
		new FinderPath(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenModelImpl.FINDER_CACHE_ENABLED, FormSixteenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygetForm",
			new String[] { Long.class.getName(), String.class.getName() },
			FormSixteenModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			FormSixteenModelImpl.FINANCIALYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETFORM = new FinderPath(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetForm",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @return the matching form sixteens
	 */
	@Override
	public List<FormSixteen> findBygetForm(long employeeId, String financialYear) {
		return findBygetForm(employeeId, financialYear, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param start the lower bound of the range of form sixteens
	 * @param end the upper bound of the range of form sixteens (not inclusive)
	 * @return the range of matching form sixteens
	 */
	@Override
	public List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end) {
		return findBygetForm(employeeId, financialYear, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param start the lower bound of the range of form sixteens
	 * @param end the upper bound of the range of form sixteens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form sixteens
	 */
	@Override
	public List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end,
		OrderByComparator<FormSixteen> orderByComparator) {
		return findBygetForm(employeeId, financialYear, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form sixteens where employeeId = &#63; and financialYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param start the lower bound of the range of form sixteens
	 * @param end the upper bound of the range of form sixteens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching form sixteens
	 */
	@Override
	public List<FormSixteen> findBygetForm(long employeeId,
		String financialYear, int start, int end,
		OrderByComparator<FormSixteen> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETFORM;
			finderArgs = new Object[] { employeeId, financialYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETFORM;
			finderArgs = new Object[] {
					employeeId, financialYear,
					
					start, end, orderByComparator
				};
		}

		List<FormSixteen> list = null;

		if (retrieveFromCache) {
			list = (List<FormSixteen>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormSixteen formSixteen : list) {
					if ((employeeId != formSixteen.getEmployeeId()) ||
							!Objects.equals(financialYear,
								formSixteen.getFinancialYear())) {
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

			query.append(_SQL_SELECT_FORMSIXTEEN_WHERE);

			query.append(_FINDER_COLUMN_GETFORM_EMPLOYEEID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FormSixteenModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<FormSixteen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FormSixteen>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form sixteen
	 * @throws NoSuchFormSixteenException if a matching form sixteen could not be found
	 */
	@Override
	public FormSixteen findBygetForm_First(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator)
		throws NoSuchFormSixteenException {
		FormSixteen formSixteen = fetchBygetForm_First(employeeId,
				financialYear, orderByComparator);

		if (formSixteen != null) {
			return formSixteen;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", financialYear=");
		msg.append(financialYear);

		msg.append("}");

		throw new NoSuchFormSixteenException(msg.toString());
	}

	/**
	 * Returns the first form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form sixteen, or <code>null</code> if a matching form sixteen could not be found
	 */
	@Override
	public FormSixteen fetchBygetForm_First(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator) {
		List<FormSixteen> list = findBygetForm(employeeId, financialYear, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form sixteen
	 * @throws NoSuchFormSixteenException if a matching form sixteen could not be found
	 */
	@Override
	public FormSixteen findBygetForm_Last(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator)
		throws NoSuchFormSixteenException {
		FormSixteen formSixteen = fetchBygetForm_Last(employeeId,
				financialYear, orderByComparator);

		if (formSixteen != null) {
			return formSixteen;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(", financialYear=");
		msg.append(financialYear);

		msg.append("}");

		throw new NoSuchFormSixteenException(msg.toString());
	}

	/**
	 * Returns the last form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form sixteen, or <code>null</code> if a matching form sixteen could not be found
	 */
	@Override
	public FormSixteen fetchBygetForm_Last(long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator) {
		int count = countBygetForm(employeeId, financialYear);

		if (count == 0) {
			return null;
		}

		List<FormSixteen> list = findBygetForm(employeeId, financialYear,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form sixteens before and after the current form sixteen in the ordered set where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param id the primary key of the current form sixteen
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form sixteen
	 * @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen[] findBygetForm_PrevAndNext(long id, long employeeId,
		String financialYear, OrderByComparator<FormSixteen> orderByComparator)
		throws NoSuchFormSixteenException {
		FormSixteen formSixteen = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FormSixteen[] array = new FormSixteenImpl[3];

			array[0] = getBygetForm_PrevAndNext(session, formSixteen,
					employeeId, financialYear, orderByComparator, true);

			array[1] = formSixteen;

			array[2] = getBygetForm_PrevAndNext(session, formSixteen,
					employeeId, financialYear, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FormSixteen getBygetForm_PrevAndNext(Session session,
		FormSixteen formSixteen, long employeeId, String financialYear,
		OrderByComparator<FormSixteen> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FORMSIXTEEN_WHERE);

		query.append(_FINDER_COLUMN_GETFORM_EMPLOYEEID_2);

		boolean bindFinancialYear = false;

		if (financialYear == null) {
			query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_1);
		}
		else if (financialYear.equals("")) {
			query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_3);
		}
		else {
			bindFinancialYear = true;

			query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_2);
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
			query.append(FormSixteenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (bindFinancialYear) {
			qPos.add(financialYear);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(formSixteen);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FormSixteen> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form sixteens where employeeId = &#63; and financialYear = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 */
	@Override
	public void removeBygetForm(long employeeId, String financialYear) {
		for (FormSixteen formSixteen : findBygetForm(employeeId, financialYear,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(formSixteen);
		}
	}

	/**
	 * Returns the number of form sixteens where employeeId = &#63; and financialYear = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param financialYear the financial year
	 * @return the number of matching form sixteens
	 */
	@Override
	public int countBygetForm(long employeeId, String financialYear) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETFORM;

		Object[] finderArgs = new Object[] { employeeId, financialYear };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FORMSIXTEEN_WHERE);

			query.append(_FINDER_COLUMN_GETFORM_EMPLOYEEID_2);

			boolean bindFinancialYear = false;

			if (financialYear == null) {
				query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_1);
			}
			else if (financialYear.equals("")) {
				query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_3);
			}
			else {
				bindFinancialYear = true;

				query.append(_FINDER_COLUMN_GETFORM_FINANCIALYEAR_2);
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

	private static final String _FINDER_COLUMN_GETFORM_EMPLOYEEID_2 = "formSixteen.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_GETFORM_FINANCIALYEAR_1 = "formSixteen.financialYear IS NULL";
	private static final String _FINDER_COLUMN_GETFORM_FINANCIALYEAR_2 = "formSixteen.financialYear = ?";
	private static final String _FINDER_COLUMN_GETFORM_FINANCIALYEAR_3 = "(formSixteen.financialYear IS NULL OR formSixteen.financialYear = '')";

	public FormSixteenPersistenceImpl() {
		setModelClass(FormSixteen.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the form sixteen in the entity cache if it is enabled.
	 *
	 * @param formSixteen the form sixteen
	 */
	@Override
	public void cacheResult(FormSixteen formSixteen) {
		entityCache.putResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenImpl.class, formSixteen.getPrimaryKey(), formSixteen);

		formSixteen.resetOriginalValues();
	}

	/**
	 * Caches the form sixteens in the entity cache if it is enabled.
	 *
	 * @param formSixteens the form sixteens
	 */
	@Override
	public void cacheResult(List<FormSixteen> formSixteens) {
		for (FormSixteen formSixteen : formSixteens) {
			if (entityCache.getResult(
						FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
						FormSixteenImpl.class, formSixteen.getPrimaryKey()) == null) {
				cacheResult(formSixteen);
			}
			else {
				formSixteen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all form sixteens.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FormSixteenImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form sixteen.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormSixteen formSixteen) {
		entityCache.removeResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenImpl.class, formSixteen.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FormSixteen> formSixteens) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FormSixteen formSixteen : formSixteens) {
			entityCache.removeResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
				FormSixteenImpl.class, formSixteen.getPrimaryKey());
		}
	}

	/**
	 * Creates a new form sixteen with the primary key. Does not add the form sixteen to the database.
	 *
	 * @param id the primary key for the new form sixteen
	 * @return the new form sixteen
	 */
	@Override
	public FormSixteen create(long id) {
		FormSixteen formSixteen = new FormSixteenImpl();

		formSixteen.setNew(true);
		formSixteen.setPrimaryKey(id);

		return formSixteen;
	}

	/**
	 * Removes the form sixteen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the form sixteen
	 * @return the form sixteen that was removed
	 * @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen remove(long id) throws NoSuchFormSixteenException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the form sixteen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form sixteen
	 * @return the form sixteen that was removed
	 * @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen remove(Serializable primaryKey)
		throws NoSuchFormSixteenException {
		Session session = null;

		try {
			session = openSession();

			FormSixteen formSixteen = (FormSixteen)session.get(FormSixteenImpl.class,
					primaryKey);

			if (formSixteen == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormSixteenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(formSixteen);
		}
		catch (NoSuchFormSixteenException nsee) {
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
	protected FormSixteen removeImpl(FormSixteen formSixteen) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formSixteen)) {
				formSixteen = (FormSixteen)session.get(FormSixteenImpl.class,
						formSixteen.getPrimaryKeyObj());
			}

			if (formSixteen != null) {
				session.delete(formSixteen);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (formSixteen != null) {
			clearCache(formSixteen);
		}

		return formSixteen;
	}

	@Override
	public FormSixteen updateImpl(FormSixteen formSixteen) {
		boolean isNew = formSixteen.isNew();

		if (!(formSixteen instanceof FormSixteenModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(formSixteen.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(formSixteen);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in formSixteen proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FormSixteen implementation " +
				formSixteen.getClass());
		}

		FormSixteenModelImpl formSixteenModelImpl = (FormSixteenModelImpl)formSixteen;

		Session session = null;

		try {
			session = openSession();

			if (formSixteen.isNew()) {
				session.save(formSixteen);

				formSixteen.setNew(false);
			}
			else {
				formSixteen = (FormSixteen)session.merge(formSixteen);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FormSixteenModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					formSixteenModelImpl.getEmployeeId(),
					formSixteenModelImpl.getFinancialYear()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETFORM, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETFORM,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((formSixteenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETFORM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						formSixteenModelImpl.getOriginalEmployeeId(),
						formSixteenModelImpl.getOriginalFinancialYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETFORM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETFORM,
					args);

				args = new Object[] {
						formSixteenModelImpl.getEmployeeId(),
						formSixteenModelImpl.getFinancialYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETFORM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETFORM,
					args);
			}
		}

		entityCache.putResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
			FormSixteenImpl.class, formSixteen.getPrimaryKey(), formSixteen,
			false);

		formSixteen.resetOriginalValues();

		return formSixteen;
	}

	/**
	 * Returns the form sixteen with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form sixteen
	 * @return the form sixteen
	 * @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormSixteenException {
		FormSixteen formSixteen = fetchByPrimaryKey(primaryKey);

		if (formSixteen == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormSixteenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return formSixteen;
	}

	/**
	 * Returns the form sixteen with the primary key or throws a {@link NoSuchFormSixteenException} if it could not be found.
	 *
	 * @param id the primary key of the form sixteen
	 * @return the form sixteen
	 * @throws NoSuchFormSixteenException if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen findByPrimaryKey(long id)
		throws NoSuchFormSixteenException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the form sixteen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form sixteen
	 * @return the form sixteen, or <code>null</code> if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
				FormSixteenImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FormSixteen formSixteen = (FormSixteen)serializable;

		if (formSixteen == null) {
			Session session = null;

			try {
				session = openSession();

				formSixteen = (FormSixteen)session.get(FormSixteenImpl.class,
						primaryKey);

				if (formSixteen != null) {
					cacheResult(formSixteen);
				}
				else {
					entityCache.putResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
						FormSixteenImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
					FormSixteenImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return formSixteen;
	}

	/**
	 * Returns the form sixteen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the form sixteen
	 * @return the form sixteen, or <code>null</code> if a form sixteen with the primary key could not be found
	 */
	@Override
	public FormSixteen fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, FormSixteen> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FormSixteen> map = new HashMap<Serializable, FormSixteen>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FormSixteen formSixteen = fetchByPrimaryKey(primaryKey);

			if (formSixteen != null) {
				map.put(primaryKey, formSixteen);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
					FormSixteenImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FormSixteen)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FORMSIXTEEN_WHERE_PKS_IN);

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

			for (FormSixteen formSixteen : (List<FormSixteen>)q.list()) {
				map.put(formSixteen.getPrimaryKeyObj(), formSixteen);

				cacheResult(formSixteen);

				uncachedPrimaryKeys.remove(formSixteen.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FormSixteenModelImpl.ENTITY_CACHE_ENABLED,
					FormSixteenImpl.class, primaryKey, nullModel);
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
	 * Returns all the form sixteens.
	 *
	 * @return the form sixteens
	 */
	@Override
	public List<FormSixteen> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form sixteens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form sixteens
	 * @param end the upper bound of the range of form sixteens (not inclusive)
	 * @return the range of form sixteens
	 */
	@Override
	public List<FormSixteen> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form sixteens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form sixteens
	 * @param end the upper bound of the range of form sixteens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form sixteens
	 */
	@Override
	public List<FormSixteen> findAll(int start, int end,
		OrderByComparator<FormSixteen> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form sixteens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FormSixteenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form sixteens
	 * @param end the upper bound of the range of form sixteens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of form sixteens
	 */
	@Override
	public List<FormSixteen> findAll(int start, int end,
		OrderByComparator<FormSixteen> orderByComparator,
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

		List<FormSixteen> list = null;

		if (retrieveFromCache) {
			list = (List<FormSixteen>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FORMSIXTEEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORMSIXTEEN;

				if (pagination) {
					sql = sql.concat(FormSixteenModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FormSixteen>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FormSixteen>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the form sixteens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FormSixteen formSixteen : findAll()) {
			remove(formSixteen);
		}
	}

	/**
	 * Returns the number of form sixteens.
	 *
	 * @return the number of form sixteens
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORMSIXTEEN);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FormSixteenModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the form sixteen persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FormSixteenImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FORMSIXTEEN = "SELECT formSixteen FROM FormSixteen formSixteen";
	private static final String _SQL_SELECT_FORMSIXTEEN_WHERE_PKS_IN = "SELECT formSixteen FROM FormSixteen formSixteen WHERE id_ IN (";
	private static final String _SQL_SELECT_FORMSIXTEEN_WHERE = "SELECT formSixteen FROM FormSixteen formSixteen WHERE ";
	private static final String _SQL_COUNT_FORMSIXTEEN = "SELECT COUNT(formSixteen) FROM FormSixteen formSixteen";
	private static final String _SQL_COUNT_FORMSIXTEEN_WHERE = "SELECT COUNT(formSixteen) FROM FormSixteen formSixteen WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "formSixteen.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FormSixteen exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FormSixteen exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FormSixteenPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}