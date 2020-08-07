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

import com.liferay.famocom.erpcloud.model.CandidateApply;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CandidateApply in entity cache.
 *
 * @author Samaresh
 * @see CandidateApply
 * @generated
 */
@ProviderType
public class CandidateApplyCacheModel implements CacheModel<CandidateApply>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateApplyCacheModel)) {
			return false;
		}

		CandidateApplyCacheModel candidateApplyCacheModel = (CandidateApplyCacheModel)obj;

		if (applyCandidateId == candidateApplyCacheModel.applyCandidateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applyCandidateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{applyCandidateId=");
		sb.append(applyCandidateId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", yearOfExp=");
		sb.append(yearOfExp);
		sb.append(", monthOfExp=");
		sb.append(monthOfExp);
		sb.append(", currentCTC=");
		sb.append(currentCTC);
		sb.append(", expectedCTC=");
		sb.append(expectedCTC);
		sb.append(", currentCompany=");
		sb.append(currentCompany);
		sb.append(", noticePeriod=");
		sb.append(noticePeriod);
		sb.append(", referenceEmployeeId=");
		sb.append(referenceEmployeeId);
		sb.append(", cvFileId=");
		sb.append(cvFileId);
		sb.append(", jobOpeningId=");
		sb.append(jobOpeningId);
		sb.append(", skillset=");
		sb.append(skillset);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateApply toEntityModel() {
		CandidateApplyImpl candidateApplyImpl = new CandidateApplyImpl();

		candidateApplyImpl.setApplyCandidateId(applyCandidateId);

		if (firstName == null) {
			candidateApplyImpl.setFirstName("");
		}
		else {
			candidateApplyImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			candidateApplyImpl.setLastName("");
		}
		else {
			candidateApplyImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			candidateApplyImpl.setEmailAddress("");
		}
		else {
			candidateApplyImpl.setEmailAddress(emailAddress);
		}

		if (phoneNumber == null) {
			candidateApplyImpl.setPhoneNumber("");
		}
		else {
			candidateApplyImpl.setPhoneNumber(phoneNumber);
		}

		candidateApplyImpl.setYearOfExp(yearOfExp);
		candidateApplyImpl.setMonthOfExp(monthOfExp);
		candidateApplyImpl.setCurrentCTC(currentCTC);
		candidateApplyImpl.setExpectedCTC(expectedCTC);

		if (currentCompany == null) {
			candidateApplyImpl.setCurrentCompany("");
		}
		else {
			candidateApplyImpl.setCurrentCompany(currentCompany);
		}

		candidateApplyImpl.setNoticePeriod(noticePeriod);
		candidateApplyImpl.setReferenceEmployeeId(referenceEmployeeId);
		candidateApplyImpl.setCvFileId(cvFileId);
		candidateApplyImpl.setJobOpeningId(jobOpeningId);

		if (skillset == null) {
			candidateApplyImpl.setSkillset("");
		}
		else {
			candidateApplyImpl.setSkillset(skillset);
		}

		candidateApplyImpl.setStatus(status);

		candidateApplyImpl.resetOriginalValues();

		return candidateApplyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applyCandidateId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();

		yearOfExp = objectInput.readInt();

		monthOfExp = objectInput.readInt();

		currentCTC = objectInput.readInt();

		expectedCTC = objectInput.readInt();
		currentCompany = objectInput.readUTF();

		noticePeriod = objectInput.readInt();

		referenceEmployeeId = objectInput.readLong();

		cvFileId = objectInput.readLong();

		jobOpeningId = objectInput.readLong();
		skillset = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applyCandidateId);

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

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		objectOutput.writeInt(yearOfExp);

		objectOutput.writeInt(monthOfExp);

		objectOutput.writeInt(currentCTC);

		objectOutput.writeInt(expectedCTC);

		if (currentCompany == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentCompany);
		}

		objectOutput.writeInt(noticePeriod);

		objectOutput.writeLong(referenceEmployeeId);

		objectOutput.writeLong(cvFileId);

		objectOutput.writeLong(jobOpeningId);

		if (skillset == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skillset);
		}

		objectOutput.writeInt(status);
	}

	public long applyCandidateId;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String phoneNumber;
	public int yearOfExp;
	public int monthOfExp;
	public int currentCTC;
	public int expectedCTC;
	public String currentCompany;
	public int noticePeriod;
	public long referenceEmployeeId;
	public long cvFileId;
	public long jobOpeningId;
	public String skillset;
	public int status;
}