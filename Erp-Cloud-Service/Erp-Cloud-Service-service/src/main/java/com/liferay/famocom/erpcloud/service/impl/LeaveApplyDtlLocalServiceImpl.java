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

import com.liferay.famocom.erpcloud.exception.NoSuchLeaveApplyDtlException;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;
import com.liferay.famocom.erpcloud.service.base.LeaveApplyDtlLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the leave apply dtl local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see LeaveApplyDtlLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil
 */
public class LeaveApplyDtlLocalServiceImpl
	extends LeaveApplyDtlLocalServiceBaseImpl {
	public LeaveApplyDtl findByempIdAndAttDate(long employeeId, Date leaveDate, int isApprove) throws SystemException {
		LeaveApplyDtl leaveObj = null;
		try {
		leaveObj = getLeaveApplyDtlPersistence().findByempIdAndAttDate(employeeId, leaveDate, isApprove);
		} catch (NoSuchLeaveApplyDtlException e) {
		e.printStackTrace();
		}
		return leaveObj;
		}

		public boolean hasOverlappedLeaves(Date fromDate, Date toDate, long employeeId) {

		DynamicQuery leaveListQuery = dynamicQuery();
		leaveListQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId))
		.add(PropertyFactoryUtil.forName("leaveDate").ge(fromDate))
		.add(PropertyFactoryUtil.forName("leaveDate").le(toDate))
		/*.add(PropertyFactoryUtil.forName("isApprove").eq(1))*/;

		List<LeaveApplyDtl> leaveList = dynamicQuery(leaveListQuery);

		return !leaveList.isEmpty();

		}
}