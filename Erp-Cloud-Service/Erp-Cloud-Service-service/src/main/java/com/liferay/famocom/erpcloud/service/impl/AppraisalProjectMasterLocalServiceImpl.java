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

package com.liferay.famocom.erpcloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.service.base.AppraisalProjectMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the appraisal project master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalProjectMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalServiceUtil
 */
public class AppraisalProjectMasterLocalServiceImpl
	extends AppraisalProjectMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalServiceUtil} to access the appraisal project master local service.
	 */
	public AppraisalProjectMaster findBySettingIdAndEmployeeIdProjectInfo(long appraisalSettingId, long employeeId,
			long projectId) throws SystemException {
		AppraisalProjectMaster apm = null;
		try {
			apm = appraisalProjectMasterPersistence.findBySettingIdAndEmployeeIdProjectInfo(appraisalSettingId,
					employeeId, projectId);
		} catch (Exception e) {
		}
		return apm;
	}
	
	public List<AppraisalProjectMaster> findBySettingIdAndEmployeeIdApprasialIdList(long appraisalSettingId,
			long employeeId, long appraisalId) throws SystemException {

		List<AppraisalProjectMaster> apMasterList = new ArrayList<AppraisalProjectMaster>();
		try {
			apMasterList = appraisalProjectMasterPersistence.findBySettingIdAndEmployeeIdAppraisalIdList(appraisalSettingId, employeeId, appraisalId);					
		} catch (SystemException e) {
			// TODO Auto-generated catch block
		}
		return apMasterList;
	}
	
	public List<AppraisalProjectMaster> findByEmployeeListFromManager(long appraisalSettingId,
			long projectId,long submitStep) throws SystemException {

		List<AppraisalProjectMaster> apMasterList = new ArrayList<AppraisalProjectMaster>();
		try {
			apMasterList = appraisalProjectMasterPersistence.findByemployeeListFromManager(appraisalSettingId, projectId, submitStep);					
		} catch (SystemException e) {
			// TODO Auto-generated catch block
		}
		return apMasterList;
	}
	
	public List<AppraisalProjectMaster> findByAppraisalSettingIdAndEmployeeId(long appraisalSettingId,
			long employeeId) throws SystemException {

			List<AppraisalProjectMaster> apMasterList = new ArrayList<AppraisalProjectMaster>();
			try {
			apMasterList = appraisalProjectMasterPersistence.findByappraisalSettingIdAndEmployeeId(appraisalSettingId, employeeId);	
			} catch (SystemException e) {
			// TODO Auto-generated catch block
			}
			return apMasterList;
			}
	
}