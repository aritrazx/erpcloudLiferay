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

import com.liferay.famocom.erpcloud.exception.NoSuchNotificationSendManageException;
import com.liferay.famocom.erpcloud.model.NotificationSendManage;
import com.liferay.famocom.erpcloud.service.base.NotificationSendManageLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the notification send manage local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see NotificationSendManageLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.NotificationSendManageLocalServiceUtil
 */
public class NotificationSendManageLocalServiceImpl
	extends NotificationSendManageLocalServiceBaseImpl {
	public List<NotificationSendManage> findByBranchId(long branchId) throws SystemException {

		List<NotificationSendManage> sendList = new ArrayList<NotificationSendManage>();
		sendList = getNotificationSendManagePersistence().findByBranchId(branchId);
		return sendList;
	}
	
	public NotificationSendManage findByNotificationId(long notificationId) throws Exception{
		NotificationSendManage sendMsg = null;
		try {
			sendMsg = getNotificationSendManagePersistence().findByNotificationId(notificationId);
		} catch (NoSuchNotificationSendManageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendMsg;
	}
	
	
	public NotificationSendManage findByBranchAndNotificationId(long notificationId, long branchId) throws Exception{
		NotificationSendManage sendMsg = null;
		try {
			sendMsg = getNotificationSendManagePersistence().findByBranchAndNotificationId(notificationId, branchId);
		} catch (NoSuchNotificationSendManageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendMsg;
	}
}