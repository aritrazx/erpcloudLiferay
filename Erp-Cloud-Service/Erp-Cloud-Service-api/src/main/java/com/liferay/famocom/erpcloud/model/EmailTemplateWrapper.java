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

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EmailTemplate}.
 * </p>
 *
 * @author Samaresh
 * @see EmailTemplate
 * @generated
 */
@ProviderType
public class EmailTemplateWrapper implements EmailTemplate,
	ModelWrapper<EmailTemplate> {
	public EmailTemplateWrapper(EmailTemplate emailTemplate) {
		_emailTemplate = emailTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return EmailTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return EmailTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("templateName", getTemplateName());
		attributes.put("emailFor", getEmailFor());
		attributes.put("templateBody", getTemplateBody());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("ModifiedBy", getModifiedBy());
		attributes.put("Status", isStatus());
		attributes.put("restoreTemplateBody", getRestoreTemplateBody());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		String emailFor = (String)attributes.get("emailFor");

		if (emailFor != null) {
			setEmailFor(emailFor);
		}

		String templateBody = (String)attributes.get("templateBody");

		if (templateBody != null) {
			setTemplateBody(templateBody);
		}

		Date createdBy = (Date)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date ModifiedBy = (Date)attributes.get("ModifiedBy");

		if (ModifiedBy != null) {
			setModifiedBy(ModifiedBy);
		}

		Boolean Status = (Boolean)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		String restoreTemplateBody = (String)attributes.get(
				"restoreTemplateBody");

		if (restoreTemplateBody != null) {
			setRestoreTemplateBody(restoreTemplateBody);
		}
	}

	@Override
	public Object clone() {
		return new EmailTemplateWrapper((EmailTemplate)_emailTemplate.clone());
	}

	@Override
	public int compareTo(EmailTemplate emailTemplate) {
		return _emailTemplate.compareTo(emailTemplate);
	}

	/**
	* Returns the created by of this email template.
	*
	* @return the created by of this email template
	*/
	@Override
	public Date getCreatedBy() {
		return _emailTemplate.getCreatedBy();
	}

	/**
	* Returns the email for of this email template.
	*
	* @return the email for of this email template
	*/
	@Override
	public String getEmailFor() {
		return _emailTemplate.getEmailFor();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _emailTemplate.getExpandoBridge();
	}

	/**
	* Returns the ID of this email template.
	*
	* @return the ID of this email template
	*/
	@Override
	public long getId() {
		return _emailTemplate.getId();
	}

	/**
	* Returns the modified by of this email template.
	*
	* @return the modified by of this email template
	*/
	@Override
	public Date getModifiedBy() {
		return _emailTemplate.getModifiedBy();
	}

	/**
	* Returns the primary key of this email template.
	*
	* @return the primary key of this email template
	*/
	@Override
	public long getPrimaryKey() {
		return _emailTemplate.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _emailTemplate.getPrimaryKeyObj();
	}

	/**
	* Returns the restore template body of this email template.
	*
	* @return the restore template body of this email template
	*/
	@Override
	public String getRestoreTemplateBody() {
		return _emailTemplate.getRestoreTemplateBody();
	}

	/**
	* Returns the status of this email template.
	*
	* @return the status of this email template
	*/
	@Override
	public boolean getStatus() {
		return _emailTemplate.getStatus();
	}

	/**
	* Returns the template body of this email template.
	*
	* @return the template body of this email template
	*/
	@Override
	public String getTemplateBody() {
		return _emailTemplate.getTemplateBody();
	}

	/**
	* Returns the template name of this email template.
	*
	* @return the template name of this email template
	*/
	@Override
	public String getTemplateName() {
		return _emailTemplate.getTemplateName();
	}

	@Override
	public int hashCode() {
		return _emailTemplate.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _emailTemplate.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _emailTemplate.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _emailTemplate.isNew();
	}

	/**
	* Returns <code>true</code> if this email template is status.
	*
	* @return <code>true</code> if this email template is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _emailTemplate.isStatus();
	}

	@Override
	public void persist() {
		_emailTemplate.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emailTemplate.setCachedModel(cachedModel);
	}

	/**
	* Sets the created by of this email template.
	*
	* @param createdBy the created by of this email template
	*/
	@Override
	public void setCreatedBy(Date createdBy) {
		_emailTemplate.setCreatedBy(createdBy);
	}

	/**
	* Sets the email for of this email template.
	*
	* @param emailFor the email for of this email template
	*/
	@Override
	public void setEmailFor(String emailFor) {
		_emailTemplate.setEmailFor(emailFor);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_emailTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_emailTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_emailTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this email template.
	*
	* @param id the ID of this email template
	*/
	@Override
	public void setId(long id) {
		_emailTemplate.setId(id);
	}

	/**
	* Sets the modified by of this email template.
	*
	* @param ModifiedBy the modified by of this email template
	*/
	@Override
	public void setModifiedBy(Date ModifiedBy) {
		_emailTemplate.setModifiedBy(ModifiedBy);
	}

	@Override
	public void setNew(boolean n) {
		_emailTemplate.setNew(n);
	}

	/**
	* Sets the primary key of this email template.
	*
	* @param primaryKey the primary key of this email template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emailTemplate.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_emailTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the restore template body of this email template.
	*
	* @param restoreTemplateBody the restore template body of this email template
	*/
	@Override
	public void setRestoreTemplateBody(String restoreTemplateBody) {
		_emailTemplate.setRestoreTemplateBody(restoreTemplateBody);
	}

	/**
	* Sets whether this email template is status.
	*
	* @param Status the status of this email template
	*/
	@Override
	public void setStatus(boolean Status) {
		_emailTemplate.setStatus(Status);
	}

	/**
	* Sets the template body of this email template.
	*
	* @param templateBody the template body of this email template
	*/
	@Override
	public void setTemplateBody(String templateBody) {
		_emailTemplate.setTemplateBody(templateBody);
	}

	/**
	* Sets the template name of this email template.
	*
	* @param templateName the template name of this email template
	*/
	@Override
	public void setTemplateName(String templateName) {
		_emailTemplate.setTemplateName(templateName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EmailTemplate> toCacheModel() {
		return _emailTemplate.toCacheModel();
	}

	@Override
	public EmailTemplate toEscapedModel() {
		return new EmailTemplateWrapper(_emailTemplate.toEscapedModel());
	}

	@Override
	public String toString() {
		return _emailTemplate.toString();
	}

	@Override
	public EmailTemplate toUnescapedModel() {
		return new EmailTemplateWrapper(_emailTemplate.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _emailTemplate.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailTemplateWrapper)) {
			return false;
		}

		EmailTemplateWrapper emailTemplateWrapper = (EmailTemplateWrapper)obj;

		if (Objects.equals(_emailTemplate, emailTemplateWrapper._emailTemplate)) {
			return true;
		}

		return false;
	}

	@Override
	public EmailTemplate getWrappedModel() {
		return _emailTemplate;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _emailTemplate.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _emailTemplate.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_emailTemplate.resetOriginalValues();
	}

	private final EmailTemplate _emailTemplate;
}