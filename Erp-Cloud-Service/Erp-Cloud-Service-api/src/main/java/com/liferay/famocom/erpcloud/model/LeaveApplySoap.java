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
 * This class is used by SOAP remote services, specifically {@link com.liferay.famocom.erpcloud.service.http.LeaveApplyServiceSoap}.
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.http.LeaveApplyServiceSoap
 * @generated
 */
@ProviderType
public class LeaveApplySoap implements Serializable {
	public static LeaveApplySoap toSoapModel(LeaveApply model) {
		LeaveApplySoap soapModel = new LeaveApplySoap();

		soapModel.setLeaveApplyId(model.getLeaveApplyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setLeaveTypeId(model.getLeaveTypeId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setFromDateSession(model.getFromDateSession());
		soapModel.setToDate(model.getToDate());
		soapModel.setToDateSession(model.getToDateSession());
		soapModel.setLeaveDays(model.getLeaveDays());
		soapModel.setReason(model.getReason());
		soapModel.setAttachedFile(model.getAttachedFile());
		soapModel.setCancelReason(model.getCancelReason());
		soapModel.setHrComments(model.getHrComments());
		soapModel.setIsApprove(model.getIsApprove());
		soapModel.setAddedDate(model.getAddedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LeaveApplySoap[] toSoapModels(LeaveApply[] models) {
		LeaveApplySoap[] soapModels = new LeaveApplySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaveApplySoap[][] toSoapModels(LeaveApply[][] models) {
		LeaveApplySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaveApplySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaveApplySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaveApplySoap[] toSoapModels(List<LeaveApply> models) {
		List<LeaveApplySoap> soapModels = new ArrayList<LeaveApplySoap>(models.size());

		for (LeaveApply model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaveApplySoap[soapModels.size()]);
	}

	public LeaveApplySoap() {
	}

	public long getPrimaryKey() {
		return _leaveApplyId;
	}

	public void setPrimaryKey(long pk) {
		setLeaveApplyId(pk);
	}

	public long getLeaveApplyId() {
		return _leaveApplyId;
	}

	public void setLeaveApplyId(long leaveApplyId) {
		_leaveApplyId = leaveApplyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getLeaveTypeId() {
		return _leaveTypeId;
	}

	public void setLeaveTypeId(long leaveTypeId) {
		_leaveTypeId = leaveTypeId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public String getFromDateSession() {
		return _fromDateSession;
	}

	public void setFromDateSession(String fromDateSession) {
		_fromDateSession = fromDateSession;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public String getToDateSession() {
		return _toDateSession;
	}

	public void setToDateSession(String toDateSession) {
		_toDateSession = toDateSession;
	}

	public double getLeaveDays() {
		return _leaveDays;
	}

	public void setLeaveDays(double leaveDays) {
		_leaveDays = leaveDays;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getAttachedFile() {
		return _attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		_attachedFile = attachedFile;
	}

	public String getCancelReason() {
		return _cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		_cancelReason = cancelReason;
	}

	public String getHrComments() {
		return _hrComments;
	}

	public void setHrComments(String hrComments) {
		_hrComments = hrComments;
	}

	public int getIsApprove() {
		return _isApprove;
	}

	public void setIsApprove(int isApprove) {
		_isApprove = isApprove;
	}

	public Date getAddedDate() {
		return _addedDate;
	}

	public void setAddedDate(Date addedDate) {
		_addedDate = addedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _leaveApplyId;
	private long _companyId;
	private long _employeeId;
	private long _leaveTypeId;
	private Date _fromDate;
	private String _fromDateSession;
	private Date _toDate;
	private String _toDateSession;
	private double _leaveDays;
	private String _reason;
	private String _attachedFile;
	private String _cancelReason;
	private String _hrComments;
	private int _isApprove;
	private Date _addedDate;
	private long _userId;
	private long _fileEntryId;
	private long _groupId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
}