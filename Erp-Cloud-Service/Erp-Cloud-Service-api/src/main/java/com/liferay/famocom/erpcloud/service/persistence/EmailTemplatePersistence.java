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

import com.liferay.famocom.erpcloud.exception.NoSuchEmailTemplateException;
import com.liferay.famocom.erpcloud.model.EmailTemplate;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the email template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.persistence.impl.EmailTemplatePersistenceImpl
 * @see EmailTemplateUtil
 * @generated
 */
@ProviderType
public interface EmailTemplatePersistence extends BasePersistence<EmailTemplate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailTemplateUtil} to access the email template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the email template where emailFor = &#63; or throws a {@link NoSuchEmailTemplateException} if it could not be found.
	*
	* @param emailFor the email for
	* @return the matching email template
	* @throws NoSuchEmailTemplateException if a matching email template could not be found
	*/
	public EmailTemplate findByemailFor(String emailFor)
		throws NoSuchEmailTemplateException;

	/**
	* Returns the email template where emailFor = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailFor the email for
	* @return the matching email template, or <code>null</code> if a matching email template could not be found
	*/
	public EmailTemplate fetchByemailFor(String emailFor);

	/**
	* Returns the email template where emailFor = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailFor the email for
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching email template, or <code>null</code> if a matching email template could not be found
	*/
	public EmailTemplate fetchByemailFor(String emailFor,
		boolean retrieveFromCache);

	/**
	* Removes the email template where emailFor = &#63; from the database.
	*
	* @param emailFor the email for
	* @return the email template that was removed
	*/
	public EmailTemplate removeByemailFor(String emailFor)
		throws NoSuchEmailTemplateException;

	/**
	* Returns the number of email templates where emailFor = &#63;.
	*
	* @param emailFor the email for
	* @return the number of matching email templates
	*/
	public int countByemailFor(String emailFor);

	/**
	* Caches the email template in the entity cache if it is enabled.
	*
	* @param emailTemplate the email template
	*/
	public void cacheResult(EmailTemplate emailTemplate);

	/**
	* Caches the email templates in the entity cache if it is enabled.
	*
	* @param emailTemplates the email templates
	*/
	public void cacheResult(java.util.List<EmailTemplate> emailTemplates);

	/**
	* Creates a new email template with the primary key. Does not add the email template to the database.
	*
	* @param id the primary key for the new email template
	* @return the new email template
	*/
	public EmailTemplate create(long id);

	/**
	* Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email template
	* @return the email template that was removed
	* @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	*/
	public EmailTemplate remove(long id) throws NoSuchEmailTemplateException;

	public EmailTemplate updateImpl(EmailTemplate emailTemplate);

	/**
	* Returns the email template with the primary key or throws a {@link NoSuchEmailTemplateException} if it could not be found.
	*
	* @param id the primary key of the email template
	* @return the email template
	* @throws NoSuchEmailTemplateException if a email template with the primary key could not be found
	*/
	public EmailTemplate findByPrimaryKey(long id)
		throws NoSuchEmailTemplateException;

	/**
	* Returns the email template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the email template
	* @return the email template, or <code>null</code> if a email template with the primary key could not be found
	*/
	public EmailTemplate fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, EmailTemplate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the email templates.
	*
	* @return the email templates
	*/
	public java.util.List<EmailTemplate> findAll();

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
	public java.util.List<EmailTemplate> findAll(int start, int end);

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
	public java.util.List<EmailTemplate> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailTemplate> orderByComparator);

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
	public java.util.List<EmailTemplate> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmailTemplate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the email templates from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of email templates.
	*
	* @return the number of email templates
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}