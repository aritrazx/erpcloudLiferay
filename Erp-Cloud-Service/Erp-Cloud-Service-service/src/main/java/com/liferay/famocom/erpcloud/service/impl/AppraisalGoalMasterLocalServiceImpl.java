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

import com.liferay.famocom.erpcloud.model.AppraisalGoalMaster;
import com.liferay.famocom.erpcloud.service.base.AppraisalGoalMasterLocalServiceBaseImpl;

/**
 * The implementation of the appraisal goal master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalServiceUtil
 */
public class AppraisalGoalMasterLocalServiceImpl
	extends AppraisalGoalMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalServiceUtil} to access the appraisal goal master local service.
	 */
	public AppraisalGoalMaster findByApprIdEmpIdProjIdEvalId(long appraisalId, long employeeId, long projectId, long evaluationId) {
		AppraisalGoalMaster appraisalGoalMasterObj = null;
		if (appraisalId > 0 && employeeId > 0 && projectId > 0 && evaluationId > 0) {
			try {
				appraisalGoalMasterObj = appraisalGoalMasterPersistence.findByApprIdEmpIdProjIdEvalId(appraisalId, employeeId, projectId, evaluationId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return appraisalGoalMasterObj;
	}
}