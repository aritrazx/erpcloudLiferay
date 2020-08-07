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

import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.JobEvaluation;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.service.base.JobEvaluationLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the job evaluation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.JobEvaluationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see JobEvaluationLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.JobEvaluationLocalServiceUtil
 */
public class JobEvaluationLocalServiceImpl
	extends JobEvaluationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.JobEvaluationLocalServiceUtil} to access the job evaluation local service.
	 */
	
	public List<JobEvaluation> findByjobEvaluation(long jobPostId) throws SystemException, NoSuchRecruitProcessException{
		List<JobEvaluation> jobEvaluations=null;
		jobEvaluations = getJobEvaluationPersistence().findByjobEvaluation(jobPostId);
		return jobEvaluations;
		}
}