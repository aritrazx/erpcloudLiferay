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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.EmailTemplateServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.EmailTemplateServiceSoap
 * @generated
 */
@ProviderType
public class EmailTemplateSoap implements Serializable {
	public static EmailTemplateSoap toSoapModel(EmailTemplate model) {
		EmailTemplateSoap soapModel = new EmailTemplateSoap();

		soapModel.setId(model.getId());
		soapModel.setTemplateName(model.getTemplateName());
		soapModel.setEmailFor(model.getEmailFor());
		soapModel.setTemplateBody(model.getTemplateBody());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setStatus(model.isStatus());
		soapModel.setRestoreTemplateBody(model.getRestoreTemplateBody());

		return soapModel;
	}

	public static EmailTemplateSoap[] toSoapModels(EmailTemplate[] models) {
		EmailTemplateSoap[] soapModels = new EmailTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailTemplateSoap[][] toSoapModels(EmailTemplate[][] models) {
		EmailTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailTemplateSoap[] toSoapModels(List<EmailTemplate> models) {
		List<EmailTemplateSoap> soapModels = new ArrayList<EmailTemplateSoap>(models.size());

		for (EmailTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailTemplateSoap[soapModels.size()]);
	}

	public EmailTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTemplateName() {
		return _templateName;
	}

	public void setTemplateName(String templateName) {
		_templateName = templateName;
	}

	public String getEmailFor() {
		return _emailFor;
	}

	public void setEmailFor(String emailFor) {
		_emailFor = emailFor;
	}

	public String getTemplateBody() {
		return _templateBody;
	}

	public void setTemplateBody(String templateBody) {
		_templateBody = templateBody;
	}

	public Date getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		_createdBy = createdBy;
	}

	public Date getModifiedBy() {
		return _ModifiedBy;
	}

	public void setModifiedBy(Date ModifiedBy) {
		_ModifiedBy = ModifiedBy;
	}

	public boolean getStatus() {
		return _Status;
	}

	public boolean isStatus() {
		return _Status;
	}

	public void setStatus(boolean Status) {
		_Status = Status;
	}

	public String getRestoreTemplateBody() {
		return _restoreTemplateBody;
	}

	public void setRestoreTemplateBody(String restoreTemplateBody) {
		_restoreTemplateBody = restoreTemplateBody;
	}

	private long _id;
	private String _templateName;
	private String _emailFor;
	private String _templateBody;
	private Date _createdBy;
	private Date _ModifiedBy;
	private boolean _Status;
	private String _restoreTemplateBody;
}