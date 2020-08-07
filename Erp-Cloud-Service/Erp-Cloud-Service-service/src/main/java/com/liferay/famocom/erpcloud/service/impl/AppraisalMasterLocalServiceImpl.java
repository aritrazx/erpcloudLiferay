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
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchAppraisalMasterException;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalProjectMaster;
import com.liferay.famocom.erpcloud.service.base.AppraisalMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the appraisal master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil
 */
public class AppraisalMasterLocalServiceImpl
	extends AppraisalMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil} to access the appraisal master local service.
	 */
	public AppraisalMaster findBySettingIdAndEmployeeId(long appraisalSettingId, long employeeId)
			throws SystemException {
		AppraisalMaster am = null;
		try {
			am = getAppraisalMasterPersistence().findBySettingIdAndEmployeeId(appraisalSettingId, employeeId);
		} catch (Exception e) {
		}
		return am;
	}
	
	public AppraisalMaster findBySettingIdAndEmployeeIds(long appraisalSettingId, long employeeId)
			throws SystemException {
		AppraisalMaster am = null;
		try {
			am = appraisalMasterPersistence.findBySettingIdAndEmployeeId(appraisalSettingId, employeeId);
		} catch (Exception e) {
		}
		return am;
	}
	
	public List<AppraisalMaster> findBySettingIdAndsubmitStep(long appraisalSettingId,
			long submitStep) throws SystemException {

		List<AppraisalMaster> masterList = new ArrayList<AppraisalMaster>();
		try {
			masterList = appraisalMasterPersistence.findBySettingIdAndsubmitStep(appraisalSettingId, submitStep);					
		} catch (SystemException e) {
			// TODO Auto-generated catch block
		}
		return masterList;
	}
	
}