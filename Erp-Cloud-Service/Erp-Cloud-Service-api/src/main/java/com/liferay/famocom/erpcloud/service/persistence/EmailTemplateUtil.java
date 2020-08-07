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

package com.liferay.famocom.erpcloud.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.EmailTemplate;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the email template service. This utility wraps {@link com.liferay.famocom.erpcloud.service.persistence.impl.EmailTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see EmailTemplatePersistence
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmailTemplatePersistenceImpl
 * @generated
 */
@ProviderType
public class EmailTemplateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmailTemplate emailTemplate) {
		getPersistence().clearCache(emailTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmailTemplate> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmailTemplate update(EmailTemplate emailTemplate) {
		return getPersistence().update(emailTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmailTemplate update(EmailTemplate emailTemplate,
		ServiceContext serviceContext) {
		return getPersistence().update(emailTemplate, serviceContext);
	}

	/**
	* Returns the email template where emailFor = &#63; or throws a {@link NoSuchEmailTemplateException} if it could not be found.
	*
	* @param emailFor the email for
	* @return the matching email template
	* @throws NoSuchEmailTemplateException if a matching email template could not be found
	*/
	public static EmailTemplate findByemailFor(String emailFor)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmailTemplateException {
		return getPersistence().findByemailFor(emailFor);
	}

	/**
	* Returns the email template where emailFor = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailFor the email for
	* @return the matching email template, or <code>null</code> if a matching email template could not be found
	*/
	public static EmailTemplate fetchByemailFor(String emailFor) {
		return getPersistence().fetchByemailFor(emailFor);
	}

	/**
	* Returns the email template where emailFor = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailFor the email for
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching email template, or <code>null</code> if a matching email template could not be found
	*/
	public static EmailTemplate fetchByemailFor(String emailFor,
		boolean retrieveFromCache) {
		return getPersistence().fetchByemailFor(emailFor, retrieveFromCache);
	}

	/**
	* Removes the email template where emailFor = &#63; from the database.
	*
	* @param emailFor the email for
	* @return the email template that was removed
	*/
	public static EmailTemplate removeByemailFor(String emailFor)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmailTemplateException {
		return getPersistence().removeByemailFor(emailFor);
	}

	/**
	* Returns the number of email templates where emailFor = &#63;.
	*
	* @param emailFor the email for
	* @return the number of matching email templates
	*/
	public static int countByemailFor(String emailFor) {
		return getPersistence().countByemailFor(emailFor);
	}

	/**
	* Caches the email template in the entity cache if it is enabled.
	*
	* @param emailTemplate the email template
	*/
	public static void cacheResult(EmailTemplate emailTemplate) {
		getPersistence().cacheResult(emailTemplate);
	}

	/**
	* Caches the email templates in the entity cache if it is enabled.
	*
	* @param emailTemplates the email templates
	*/
	public static void cacheResult(List<EmailTemplate> emailTemplates) {
		getPersistence().cacheResult(emailTemplates);
	}

	/**
	* Creates a new email template with the primary key. Does not add the email template to the database.
	*
	* @param id the primary key for the new email template
	* @return the new email template
	*/
	public static EmailTemplate create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email template
	* @return the email template that was removed
	* @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	*/
	public static EmailTemplate remove(long id)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmailTemplateException {
		return getPersistence().remove(id);
	}

	public static EmailTemplate updateImpl(EmailTemplate emailTemplate) {
		return getPersistence().updateImpl(emailTemplate);
	}

	/**
	* Returns the email template with the primary key or throws a {@link NoSuchEmailTemplateException} if it could not be found.
	*
	* @param id the primary key of the email template
	* @return the email template
	* @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	*/
	public static EmailTemplate findByPrimaryKey(long id)
		throws com.liferay.famocom.erpcloud.exception.NoSuchEmailTemplateException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email template
	* @return the email template, or <code>null</code> if a email template with the primary key could not be found
	*/
	public static EmailTemplate fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, EmailTemplate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the email templates.
	*
	* @return the email templates
	*/
	public static List<EmailTemplate> findAll() {
		return getPersistence().findAll();
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
	public static List<EmailTemplate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<EmailTemplate> findAll(int start, int end,
		OrderByComparator<EmailTemplate> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<EmailTemplate> findAll(int start, int end,
		OrderByComparator<EmailTemplate> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the email templates from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of email templates.
	*
	* @return the number of email templates
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmailTemplatePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmailTemplatePersistence, EmailTemplatePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmailTemplatePersistence.class);

		ServiceTracker<EmailTemplatePersistence, EmailTemplatePersistence> serviceTracker =
			new ServiceTracker<EmailTemplatePersistence, EmailTemplatePersistence>(bundle.getBundleContext(),
				EmailTemplatePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}