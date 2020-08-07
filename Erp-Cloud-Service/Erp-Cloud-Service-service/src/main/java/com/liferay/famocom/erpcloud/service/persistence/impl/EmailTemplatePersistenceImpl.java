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

import com.liferay.famocom.erpcloud.exception.NoSuchEmailTemplateException;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.impl.EmailTemplateImpl;
import com.liferay.famocom.erpcloud.model.impl.EmailTemplateModelImpl;
import com.liferay.famocom.erpcloud.service.persistence.EmailTemplatePersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the email template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmailTemplatePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.EmailTemplateUtil
 * @generated
 */
@ProviderType
public class EmailTemplatePersistenceImpl extends BasePersistenceImpl<EmailTemplate>
	implements EmailTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmailTemplateUtil} to access the email template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmailTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateModelImpl.FINDER_CACHE_ENABLED,
			EmailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateModelImpl.FINDER_CACHE_ENABLED,
			EmailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILFOR = new FinderPath(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateModelImpl.FINDER_CACHE_ENABLED,
			EmailTemplateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemailFor", new String[] { String.class.getName() },
			EmailTemplateModelImpl.EMAILFOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILFOR = new FinderPath(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailFor",
			new String[] { String.class.getName() });

	/**
	 * Returns the email template where emailFor = &#63; or throws a {@link NoSuchEmailTemplateException} if it could not be found.
	 *
	 * @param emailFor the email for
	 * @return the matching email template
	 * @throws NoSuchEmailTemplateException if a matching email template could not be found
	 */
	@Override
	public EmailTemplate findByemailFor(String emailFor)
		throws NoSuchEmailTemplateException {
		EmailTemplate emailTemplate = fetchByemailFor(emailFor);

		if (emailTemplate == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailFor=");
			msg.append(emailFor);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmailTemplateException(msg.toString());
		}

		return emailTemplate;
	}

	/**
	 * Returns the email template where emailFor = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailFor the email for
	 * @return the matching email template, or <code>null</code> if a matching email template could not be found
	 */
	@Override
	public EmailTemplate fetchByemailFor(String emailFor) {
		return fetchByemailFor(emailFor, true);
	}

	/**
	 * Returns the email template where emailFor = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailFor the email for
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching email template, or <code>null</code> if a matching email template could not be found
	 */
	@Override
	public EmailTemplate fetchByemailFor(String emailFor,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { emailFor };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMAILFOR,
					finderArgs, this);
		}

		if (result instanceof EmailTemplate) {
			EmailTemplate emailTemplate = (EmailTemplate)result;

			if (!Objects.equals(emailFor, emailTemplate.getEmailFor())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMAILTEMPLATE_WHERE);

			boolean bindEmailFor = false;

			if (emailFor == null) {
				query.append(_FINDER_COLUMN_EMAILFOR_EMAILFOR_1);
			}
			else if (emailFor.equals("")) {
				query.append(_FINDER_COLUMN_EMAILFOR_EMAILFOR_3);
			}
			else {
				bindEmailFor = true;

				query.append(_FINDER_COLUMN_EMAILFOR_EMAILFOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailFor) {
					qPos.add(emailFor);
				}

				List<EmailTemplate> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMAILFOR,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"EmailTemplatePersistenceImpl.fetchByemailFor(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmailTemplate emailTemplate = list.get(0);

					result = emailTemplate;

					cacheResult(emailTemplate);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAILFOR,
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
			return (EmailTemplate)result;
		}
	}

	/**
	 * Removes the email template where emailFor = &#63; from the database.
	 *
	 * @param emailFor the email for
	 * @return the email template that was removed
	 */
	@Override
	public EmailTemplate removeByemailFor(String emailFor)
		throws NoSuchEmailTemplateException {
		EmailTemplate emailTemplate = findByemailFor(emailFor);

		return remove(emailTemplate);
	}

	/**
	 * Returns the number of email templates where emailFor = &#63;.
	 *
	 * @param emailFor the email for
	 * @return the number of matching email templates
	 */
	@Override
	public int countByemailFor(String emailFor) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILFOR;

		Object[] finderArgs = new Object[] { emailFor };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMAILTEMPLATE_WHERE);

			boolean bindEmailFor = false;

			if (emailFor == null) {
				query.append(_FINDER_COLUMN_EMAILFOR_EMAILFOR_1);
			}
			else if (emailFor.equals("")) {
				query.append(_FINDER_COLUMN_EMAILFOR_EMAILFOR_3);
			}
			else {
				bindEmailFor = true;

				query.append(_FINDER_COLUMN_EMAILFOR_EMAILFOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailFor) {
					qPos.add(emailFor);
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

	private static final String _FINDER_COLUMN_EMAILFOR_EMAILFOR_1 = "emailTemplate.emailFor IS NULL";
	private static final String _FINDER_COLUMN_EMAILFOR_EMAILFOR_2 = "emailTemplate.emailFor = ?";
	private static final String _FINDER_COLUMN_EMAILFOR_EMAILFOR_3 = "(emailTemplate.emailFor IS NULL OR emailTemplate.emailFor = '')";

	public EmailTemplatePersistenceImpl() {
		setModelClass(EmailTemplate.class);

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
	 * Caches the email template in the entity cache if it is enabled.
	 *
	 * @param emailTemplate the email template
	 */
	@Override
	public void cacheResult(EmailTemplate emailTemplate) {
		entityCache.putResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateImpl.class, emailTemplate.getPrimaryKey(),
			emailTemplate);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAILFOR,
			new Object[] { emailTemplate.getEmailFor() }, emailTemplate);

		emailTemplate.resetOriginalValues();
	}

	/**
	 * Caches the email templates in the entity cache if it is enabled.
	 *
	 * @param emailTemplates the email templates
	 */
	@Override
	public void cacheResult(List<EmailTemplate> emailTemplates) {
		for (EmailTemplate emailTemplate : emailTemplates) {
			if (entityCache.getResult(
						EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
						EmailTemplateImpl.class, emailTemplate.getPrimaryKey()) == null) {
				cacheResult(emailTemplate);
			}
			else {
				emailTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all email templates.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmailTemplateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email template.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailTemplate emailTemplate) {
		entityCache.removeResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateImpl.class, emailTemplate.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EmailTemplateModelImpl)emailTemplate, true);
	}

	@Override
	public void clearCache(List<EmailTemplate> emailTemplates) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmailTemplate emailTemplate : emailTemplates) {
			entityCache.removeResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
				EmailTemplateImpl.class, emailTemplate.getPrimaryKey());

			clearUniqueFindersCache((EmailTemplateModelImpl)emailTemplate, true);
		}
	}

	protected void cacheUniqueFindersCache(
		EmailTemplateModelImpl emailTemplateModelImpl) {
		Object[] args = new Object[] { emailTemplateModelImpl.getEmailFor() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMAILFOR, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAILFOR, args,
			emailTemplateModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EmailTemplateModelImpl emailTemplateModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { emailTemplateModelImpl.getEmailFor() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILFOR, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAILFOR, args);
		}

		if ((emailTemplateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILFOR.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					emailTemplateModelImpl.getOriginalEmailFor()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILFOR, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAILFOR, args);
		}
	}

	/**
	 * Creates a new email template with the primary key. Does not add the email template to the database.
	 *
	 * @param id the primary key for the new email template
	 * @return the new email template
	 */
	@Override
	public EmailTemplate create(long id) {
		EmailTemplate emailTemplate = new EmailTemplateImpl();

		emailTemplate.setNew(true);
		emailTemplate.setPrimaryKey(id);

		return emailTemplate;
	}

	/**
	 * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the email template
	 * @return the email template that was removed
	 * @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public EmailTemplate remove(long id) throws NoSuchEmailTemplateException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email template
	 * @return the email template that was removed
	 * @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public EmailTemplate remove(Serializable primaryKey)
		throws NoSuchEmailTemplateException {
		Session session = null;

		try {
			session = openSession();

			EmailTemplate emailTemplate = (EmailTemplate)session.get(EmailTemplateImpl.class,
					primaryKey);

			if (emailTemplate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emailTemplate);
		}
		catch (NoSuchEmailTemplateException nsee) {
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
	protected EmailTemplate removeImpl(EmailTemplate emailTemplate) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emailTemplate)) {
				emailTemplate = (EmailTemplate)session.get(EmailTemplateImpl.class,
						emailTemplate.getPrimaryKeyObj());
			}

			if (emailTemplate != null) {
				session.delete(emailTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emailTemplate != null) {
			clearCache(emailTemplate);
		}

		return emailTemplate;
	}

	@Override
	public EmailTemplate updateImpl(EmailTemplate emailTemplate) {
		boolean isNew = emailTemplate.isNew();

		if (!(emailTemplate instanceof EmailTemplateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emailTemplate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(emailTemplate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emailTemplate proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmailTemplate implementation " +
				emailTemplate.getClass());
		}

		EmailTemplateModelImpl emailTemplateModelImpl = (EmailTemplateModelImpl)emailTemplate;

		Session session = null;

		try {
			session = openSession();

			if (emailTemplate.isNew()) {
				session.save(emailTemplate);

				emailTemplate.setNew(false);
			}
			else {
				emailTemplate = (EmailTemplate)session.merge(emailTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EmailTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateImpl.class, emailTemplate.getPrimaryKey(),
			emailTemplate, false);

		clearUniqueFindersCache(emailTemplateModelImpl, false);
		cacheUniqueFindersCache(emailTemplateModelImpl);

		emailTemplate.resetOriginalValues();

		return emailTemplate;
	}

	/**
	 * Returns the email template with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email template
	 * @return the email template
	 * @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public EmailTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmailTemplateException {
		EmailTemplate emailTemplate = fetchByPrimaryKey(primaryKey);

		if (emailTemplate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmailTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emailTemplate;
	}

	/**
	 * Returns the email template with the primary key or throws a {@link NoSuchEmailTemplateException} if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template
	 * @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	 */
	@Override
	public EmailTemplate findByPrimaryKey(long id)
		throws NoSuchEmailTemplateException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email template
	 * @return the email template, or <code>null</code> if a email template with the primary key could not be found
	 */
	@Override
	public EmailTemplate fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
				EmailTemplateImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmailTemplate emailTemplate = (EmailTemplate)serializable;

		if (emailTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				emailTemplate = (EmailTemplate)session.get(EmailTemplateImpl.class,
						primaryKey);

				if (emailTemplate != null) {
					cacheResult(emailTemplate);
				}
				else {
					entityCache.putResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
						EmailTemplateImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
					EmailTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emailTemplate;
	}

	/**
	 * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the email template
	 * @return the email template, or <code>null</code> if a email template with the primary key could not be found
	 */
	@Override
	public EmailTemplate fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, EmailTemplate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmailTemplate> map = new HashMap<Serializable, EmailTemplate>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmailTemplate emailTemplate = fetchByPrimaryKey(primaryKey);

			if (emailTemplate != null) {
				map.put(primaryKey, emailTemplate);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
					EmailTemplateImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmailTemplate)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMAILTEMPLATE_WHERE_PKS_IN);

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

			for (EmailTemplate emailTemplate : (List<EmailTemplate>)q.list()) {
				map.put(emailTemplate.getPrimaryKeyObj(), emailTemplate);

				cacheResult(emailTemplate);

				uncachedPrimaryKeys.remove(emailTemplate.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmailTemplateModelImpl.ENTITY_CACHE_ENABLED,
					EmailTemplateImpl.class, primaryKey, nullModel);
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
	 * Returns all the email templates.
	 *
	 * @return the email templates
	 */
	@Override
	public List<EmailTemplate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @return the range of email templates
	 */
	@Override
	public List<EmailTemplate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of email templates
	 */
	@Override
	public List<EmailTemplate> findAll(int start, int end,
		OrderByComparator<EmailTemplate> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the email templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of email templates
	 * @param end the upper bound of the range of email templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of email templates
	 */
	@Override
	public List<EmailTemplate> findAll(int start, int end,
		OrderByComparator<EmailTemplate> orderByComparator,
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

		List<EmailTemplate> list = null;

		if (retrieveFromCache) {
			list = (List<EmailTemplate>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMAILTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILTEMPLATE;

				if (pagination) {
					sql = sql.concat(EmailTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmailTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmailTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the email templates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmailTemplate emailTemplate : findAll()) {
			remove(emailTemplate);
		}
	}

	/**
	 * Returns the number of email templates.
	 *
	 * @return the number of email templates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAILTEMPLATE);

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
		return EmailTemplateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the email template persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmailTemplateImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMAILTEMPLATE = "SELECT emailTemplate FROM EmailTemplate emailTemplate";
	private static final String _SQL_SELECT_EMAILTEMPLATE_WHERE_PKS_IN = "SELECT emailTemplate FROM EmailTemplate emailTemplate WHERE id_ IN (";
	private static final String _SQL_SELECT_EMAILTEMPLATE_WHERE = "SELECT emailTemplate FROM EmailTemplate emailTemplate WHERE ";
	private static final String _SQL_COUNT_EMAILTEMPLATE = "SELECT COUNT(emailTemplate) FROM EmailTemplate emailTemplate";
	private static final String _SQL_COUNT_EMAILTEMPLATE_WHERE = "SELECT COUNT(emailTemplate) FROM EmailTemplate emailTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emailTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmailTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmailTemplate exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmailTemplatePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}