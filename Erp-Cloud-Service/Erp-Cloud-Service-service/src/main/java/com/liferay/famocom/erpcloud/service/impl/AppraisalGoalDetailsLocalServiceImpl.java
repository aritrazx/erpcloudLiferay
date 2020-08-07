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

import com.liferay.famocom.erpcloud.model.AppraisalGoalDetails;
import com.liferay.famocom.erpcloud.service.base.AppraisalGoalDetailsLocalServiceBaseImpl;

/**
 * The implementation of the appraisal goal details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see AppraisalGoalDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil
 */
public class AppraisalGoalDetailsLocalServiceImpl
	extends AppraisalGoalDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalServiceUtil} to access the appraisal goal details local service.
	 */
	public AppraisalGoalDetails findByApprIdEmpIdProjIdEvalIdGoalDetId(long appraisalId, long employeeId, long projectId, long evaluationId, long goaldetailId) {
		AppraisalGoalDetails appraisalGoalDetailsObj = null;
		if (appraisalId > 0 && employeeId > 0 && projectId > 0 && evaluationId > 0 && goaldetailId > 0) {
			try {
				appraisalGoalDetailsObj = appraisalGoalDetailsPersistence.findByApprIdEmpIdProjIdEvalIdGoalDetId(appraisalId, employeeId, projectId, evaluationId, goaldetailId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return appraisalGoalDetailsObj;
	}
}