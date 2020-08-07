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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.EmailTemplate;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmailTemplate in entity cache.
 *
 * @author Samaresh
 * @see EmailTemplate
 * @generated
 */
@ProviderType
public class EmailTemplateCacheModel implements CacheModel<EmailTemplate>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailTemplateCacheModel)) {
			return false;
		}

		EmailTemplateCacheModel emailTemplateCacheModel = (EmailTemplateCacheModel)obj;

		if (id == emailTemplateCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", emailFor=");
		sb.append(emailFor);
		sb.append(", templateBody=");
		sb.append(templateBody);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", ModifiedBy=");
		sb.append(ModifiedBy);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", restoreTemplateBody=");
		sb.append(restoreTemplateBody);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmailTemplate toEntityModel() {
		EmailTemplateImpl emailTemplateImpl = new EmailTemplateImpl();

		emailTemplateImpl.setId(id);

		if (templateName == null) {
			emailTemplateImpl.setTemplateName("");
		}
		else {
			emailTemplateImpl.setTemplateName(templateName);
		}

		if (emailFor == null) {
			emailTemplateImpl.setEmailFor("");
		}
		else {
			emailTemplateImpl.setEmailFor(emailFor);
		}

		if (templateBody == null) {
			emailTemplateImpl.setTemplateBody("");
		}
		else {
			emailTemplateImpl.setTemplateBody(templateBody);
		}

		if (createdBy == Long.MIN_VALUE) {
			emailTemplateImpl.setCreatedBy(null);
		}
		else {
			emailTemplateImpl.setCreatedBy(new Date(createdBy));
		}

		if (ModifiedBy == Long.MIN_VALUE) {
			emailTemplateImpl.setModifiedBy(null);
		}
		else {
			emailTemplateImpl.setModifiedBy(new Date(ModifiedBy));
		}

		emailTemplateImpl.setStatus(Status);

		if (restoreTemplateBody == null) {
			emailTemplateImpl.setRestoreTemplateBody("");
		}
		else {
			emailTemplateImpl.setRestoreTemplateBody(restoreTemplateBody);
		}

		emailTemplateImpl.resetOriginalValues();

		return emailTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		templateName = objectInput.readUTF();
		emailFor = objectInput.readUTF();
		templateBody = objectInput.readUTF();
		createdBy = objectInput.readLong();
		ModifiedBy = objectInput.readLong();

		Status = objectInput.readBoolean();
		restoreTemplateBody = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (templateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		if (emailFor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailFor);
		}

		if (templateBody == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(templateBody);
		}

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(ModifiedBy);

		objectOutput.writeBoolean(Status);

		if (restoreTemplateBody == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(restoreTemplateBody);
		}
	}

	public long id;
	public String templateName;
	public String emailFor;
	public String templateBody;
	public long createdBy;
	public long ModifiedBy;
	public boolean Status;
	public String restoreTemplateBody;
}