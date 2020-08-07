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

import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.service.base.TimeSheetMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * The implementation of the time sheet master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see TimeSheetMasterLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalServiceUtil
 */
public class TimeSheetMasterLocalServiceImpl
	extends TimeSheetMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalServiceUtil} to access the time sheet master local service.
	 */
	
	/*for workflow--Start*/
	public List<TimeSheetMaster> getTimeSheetMasterBystatus(long groupId, int status){
		return timeSheetMasterPersistence.findBystatus(groupId, status);
	}
	public List<TimeSheetMaster> getTimeSheetMasterByStatus(long groupId, int status, int start, int end){
		return timeSheetMasterPersistence.findBystatus(groupId, status, start, end);
	}
	
	
	public TimeSheetMaster updateStatus(long userId,long timesheetParentId,int status,ServiceContext serviceContext){
		System.out.println("call updateStatus"); 
		TimeSheetMaster timeSheetEntry = timeSheetMasterPersistence.fetchByPrimaryKey(timesheetParentId);
		timeSheetEntry.setStatus(status);
		timeSheetEntry.setStatusByUserId(userId);
		timeSheetEntry.setStatusDate(new Date());
		 User user = null;
		 try {
		      user = userLocalService.getUser(userId);
		      timeSheetEntry.setStatusByUserName(user.getFullName());
		      timeSheetEntry.setStatusByUserUuid(user.getUserUuid());
		 } catch (PortalException e) {
		     e.printStackTrace();
		 }
		 timeSheetEntry = timeSheetMasterPersistence.update(timeSheetEntry);
		 System.out.println("timeSheetEntry-----"+timeSheetEntry);
		 try {
		 if (status == WorkflowConstants.STATUS_APPROVED) {  
		     // update the asset status to visibile
		    assetEntryLocalService.updateEntry(TimeSheetMaster.class.getName(), timesheetParentId, new Date(),null, true, true);
		    System.out.println("inside if-----");
		 } else {
		     // set leave entity status to false
		     assetEntryLocalService.updateVisible(TimeSheetMaster.class.getName(), timesheetParentId, false);
		     System.out.println("inside else-----");
		 }
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
		 return timeSheetEntry;
		 }
	/*for workflow--End*/
}