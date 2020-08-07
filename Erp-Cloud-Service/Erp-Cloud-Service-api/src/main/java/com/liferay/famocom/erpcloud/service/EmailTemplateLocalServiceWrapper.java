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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmailTemplateLocalService}.
 *
 * @author Samaresh
 * @see EmailTemplateLocalService
 * @generated
 */
@ProviderType
public class EmailTemplateLocalServiceWrapper
	implements EmailTemplateLocalService,
		ServiceWrapper<EmailTemplateLocalService> {
	public EmailTemplateLocalServiceWrapper(
		EmailTemplateLocalService emailTemplateLocalService) {
		_emailTemplateLocalService = emailTemplateLocalService;
	}

	/**
	* Adds the email template to the database. Also notifies the appropriate model listeners.
	*
	* @param emailTemplate the email template
	* @return the email template that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate addEmailTemplate(
		com.liferay.famocom.erpcloud.model.EmailTemplate emailTemplate) {
		return _emailTemplateLocalService.addEmailTemplate(emailTemplate);
	}

	/**
	* Creates a new email template with the primary key. Does not add the email template to the database.
	*
	* @param id the primary key for the new email template
	* @return the new email template
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate createEmailTemplate(
		long id) {
		return _emailTemplateLocalService.createEmailTemplate(id);
	}

	/**
	* Deletes the email template from the database. Also notifies the appropriate model listeners.
	*
	* @param emailTemplate the email template
	* @return the email template that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate deleteEmailTemplate(
		com.liferay.famocom.erpcloud.model.EmailTemplate emailTemplate) {
		return _emailTemplateLocalService.deleteEmailTemplate(emailTemplate);
	}

	/**
	* Deletes the email template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the email template
	* @return the email template that was removed
	* @throws PortalException if a email template with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate deleteEmailTemplate(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _emailTemplateLocalService.deleteEmailTemplate(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailTemplateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailTemplateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _emailTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _emailTemplateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _emailTemplateLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _emailTemplateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _emailTemplateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate fetchEmailTemplate(
		long id) {
		return _emailTemplateLocalService.fetchEmailTemplate(id);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate findByemailFor(
		String emailFor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateLocalService.findByemailFor(emailFor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _emailTemplateLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the email template with the primary key.
	*
	* @param id the primary key of the email template
	* @return the email template
	* @throws PortalException if a email template with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate getEmailTemplate(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _emailTemplateLocalService.getEmailTemplate(id);
	}

	/**
	* Returns a range of all the email templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EmailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of email templates
	* @param end the upper bound of the range of email templates (not inclusive)
	* @return the range of email templates
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.EmailTemplate> getEmailTemplates(
		int start, int end) {
		return _emailTemplateLocalService.getEmailTemplates(start, end);
	}

	/**
	* Returns the number of email templates.
	*
	* @return the number of email templates
	*/
	@Override
	public int getEmailTemplatesCount() {
		return _emailTemplateLocalService.getEmailTemplatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _emailTemplateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailTemplateLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _emailTemplateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the email template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailTemplate the email template
	* @return the email template that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.EmailTemplate updateEmailTemplate(
		com.liferay.famocom.erpcloud.model.EmailTemplate emailTemplate) {
		return _emailTemplateLocalService.updateEmailTemplate(emailTemplate);
	}

	@Override
	public EmailTemplateLocalService getWrappedService() {
		return _emailTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		EmailTemplateLocalService emailTemplateLocalService) {
		_emailTemplateLocalService = emailTemplateLocalService;
	}

	private EmailTemplateLocalService _emailTemplateLocalService;
}