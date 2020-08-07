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

import java.util.Date;
import java.util.List;

import com.liferay.famocom.erpcloud.model.RecruitmentProcess;
import com.liferay.famocom.erpcloud.service.base.RecruitmentProcessLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * The implementation of the recruitment process local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see RecruitmentProcessLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil
 */
public class RecruitmentProcessLocalServiceImpl
	extends RecruitmentProcessLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil} to access the recruitment process local service.
	 */
	
	/*for workflow--Start*/
	public List<RecruitmentProcess> getRecruitmentProcessesBystatus(long groupId, int status){
		return recruitmentProcessPersistence.findBystatus(groupId, status);
	}
	public List<RecruitmentProcess> getRecruitmentProcessesByStatus(long groupId, int status, int start, int end){
		return recruitmentProcessPersistence.findBystatus(groupId, status, start, end);
	}
	
	
	public RecruitmentProcess updateStatus(long userId,long recruitmentProcessId,int status,ServiceContext serviceContext){
		System.out.println("call updateStatus"); 
		RecruitmentProcess recruitmentProcess = recruitmentProcessPersistence.fetchByPrimaryKey(recruitmentProcessId);
		recruitmentProcess.setStatus(status);
		recruitmentProcess.setStatusByUserId(userId);
		recruitmentProcess.setStatusDate(new Date());
		 User user = null;
		 try {
		      user = userLocalService.getUser(userId);
		      recruitmentProcess.setStatusByUserName(user.getFullName());
		      recruitmentProcess.setStatusByUserUuid(user.getUserUuid());
		 } catch (PortalException e) {
		     e.printStackTrace();
		 }
		 recruitmentProcess = recruitmentProcessPersistence.update(recruitmentProcess);
		 try {
		 if (status == WorkflowConstants.STATUS_APPROVED) {  
		     // update the asset status to visibile
		    assetEntryLocalService.updateEntry(RecruitmentProcess.class.getName(), recruitmentProcessId, new Date(),null, true, true);
		 } else {
		     // set leave entity status to false
		     assetEntryLocalService.updateVisible(RecruitmentProcess.class.getName(), recruitmentProcessId, false);  
		 }
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
		 return recruitmentProcess;
		 }
	/*for workflow--End*/
}