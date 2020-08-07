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

import com.liferay.famocom.erpcloud.model.RecruitProcess;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RecruitProcess in entity cache.
 *
 * @author Samaresh
 * @see RecruitProcess
 * @generated
 */
@ProviderType
public class RecruitProcessCacheModel implements CacheModel<RecruitProcess>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecruitProcessCacheModel)) {
			return false;
		}

		RecruitProcessCacheModel recruitProcessCacheModel = (RecruitProcessCacheModel)obj;

		if (recruitProcessId == recruitProcessCacheModel.recruitProcessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, recruitProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{recruitProcessId=");
		sb.append(recruitProcessId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", interviewDate=");
		sb.append(interviewDate);
		sb.append(", interviewTime=");
		sb.append(interviewTime);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileUrl=");
		sb.append(fileUrl);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", interviewerRemarks=");
		sb.append(interviewerRemarks);
		sb.append(", hrRemarks=");
		sb.append(hrRemarks);
		sb.append(", isSelected=");
		sb.append(isSelected);
		sb.append(", status=");
		sb.append(status);
		sb.append(", DOB=");
		sb.append(DOB);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", skillset=");
		sb.append(skillset);
		sb.append(", experience=");
		sb.append(experience);
		sb.append(", noticePeriod=");
		sb.append(noticePeriod);
		sb.append(", currentCTC=");
		sb.append(currentCTC);
		sb.append(", expextedCTC=");
		sb.append(expextedCTC);
		sb.append(", projectRoleId=");
		sb.append(projectRoleId);
		sb.append(", reference=");
		sb.append(reference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RecruitProcess toEntityModel() {
		RecruitProcessImpl recruitProcessImpl = new RecruitProcessImpl();

		recruitProcessImpl.setRecruitProcessId(recruitProcessId);

		if (firstName == null) {
			recruitProcessImpl.setFirstName("");
		}
		else {
			recruitProcessImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			recruitProcessImpl.setLastName("");
		}
		else {
			recruitProcessImpl.setLastName(lastName);
		}

		recruitProcessImpl.setEmployeeId(employeeId);

		if (interviewDate == Long.MIN_VALUE) {
			recruitProcessImpl.setInterviewDate(null);
		}
		else {
			recruitProcessImpl.setInterviewDate(new Date(interviewDate));
		}

		if (interviewTime == null) {
			recruitProcessImpl.setInterviewTime("");
		}
		else {
			recruitProcessImpl.setInterviewTime(interviewTime);
		}

		recruitProcessImpl.setFileEntryId(fileEntryId);

		if (fileUrl == null) {
			recruitProcessImpl.setFileUrl("");
		}
		else {
			recruitProcessImpl.setFileUrl(fileUrl);
		}

		if (createDate == Long.MIN_VALUE) {
			recruitProcessImpl.setCreateDate(null);
		}
		else {
			recruitProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			recruitProcessImpl.setModifiedDate(null);
		}
		else {
			recruitProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (interviewerRemarks == null) {
			recruitProcessImpl.setInterviewerRemarks("");
		}
		else {
			recruitProcessImpl.setInterviewerRemarks(interviewerRemarks);
		}

		if (hrRemarks == null) {
			recruitProcessImpl.setHrRemarks("");
		}
		else {
			recruitProcessImpl.setHrRemarks(hrRemarks);
		}

		recruitProcessImpl.setIsSelected(isSelected);
		recruitProcessImpl.setStatus(status);

		if (DOB == Long.MIN_VALUE) {
			recruitProcessImpl.setDOB(null);
		}
		else {
			recruitProcessImpl.setDOB(new Date(DOB));
		}

		if (email == null) {
			recruitProcessImpl.setEmail("");
		}
		else {
			recruitProcessImpl.setEmail(email);
		}

		recruitProcessImpl.setPhoneNumber(phoneNumber);

		if (skillset == null) {
			recruitProcessImpl.setSkillset("");
		}
		else {
			recruitProcessImpl.setSkillset(skillset);
		}

		recruitProcessImpl.setExperience(experience);
		recruitProcessImpl.setNoticePeriod(noticePeriod);
		recruitProcessImpl.setCurrentCTC(currentCTC);
		recruitProcessImpl.setExpextedCTC(expextedCTC);
		recruitProcessImpl.setProjectRoleId(projectRoleId);
		recruitProcessImpl.setReference(reference);

		recruitProcessImpl.resetOriginalValues();

		return recruitProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recruitProcessId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();

		employeeId = objectInput.readLong();
		interviewDate = objectInput.readLong();
		interviewTime = objectInput.readUTF();

		fileEntryId = objectInput.readLong();
		fileUrl = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		interviewerRemarks = objectInput.readUTF();
		hrRemarks = objectInput.readUTF();

		isSelected = objectInput.readInt();

		status = objectInput.readLong();
		DOB = objectInput.readLong();
		email = objectInput.readUTF();

		phoneNumber = objectInput.readLong();
		skillset = objectInput.readUTF();

		experience = objectInput.readDouble();

		noticePeriod = objectInput.readInt();

		currentCTC = objectInput.readDouble();

		expextedCTC = objectInput.readDouble();

		projectRoleId = objectInput.readLong();

		reference = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recruitProcessId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(interviewDate);

		if (interviewTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewTime);
		}

		objectOutput.writeLong(fileEntryId);

		if (fileUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileUrl);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (interviewerRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewerRemarks);
		}

		if (hrRemarks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hrRemarks);
		}

		objectOutput.writeInt(isSelected);

		objectOutput.writeLong(status);
		objectOutput.writeLong(DOB);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(phoneNumber);

		if (skillset == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skillset);
		}

		objectOutput.writeDouble(experience);

		objectOutput.writeInt(noticePeriod);

		objectOutput.writeDouble(currentCTC);

		objectOutput.writeDouble(expextedCTC);

		objectOutput.writeLong(projectRoleId);

		objectOutput.writeLong(reference);
	}

	public long recruitProcessId;
	public String firstName;
	public String lastName;
	public long employeeId;
	public long interviewDate;
	public String interviewTime;
	public long fileEntryId;
	public String fileUrl;
	public long createDate;
	public long modifiedDate;
	public String interviewerRemarks;
	public String hrRemarks;
	public int isSelected;
	public long status;
	public long DOB;
	public String email;
	public long phoneNumber;
	public String skillset;
	public double experience;
	public int noticePeriod;
	public double currentCTC;
	public double expextedCTC;
	public long projectRoleId;
	public long reference;
}