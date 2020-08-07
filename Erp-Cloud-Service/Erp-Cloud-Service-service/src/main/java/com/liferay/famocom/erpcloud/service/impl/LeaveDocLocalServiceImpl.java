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

import com.liferay.famocom.erpcloud.model.LeaveDoc;
import com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.base.LeaveDocLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

/**
 * The implementation of the leave doc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.LeaveDocLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see LeaveDocLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil
 */
public class LeaveDocLocalServiceImpl extends LeaveDocLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil} to access the leave doc local service.
	 */
	

	public List<LeaveDoc>  getDocsByLeaveApplyId(long leaveApplyId){
	List<LeaveDoc> docList = null;
	DynamicQuery dynamicQuery = LeaveDocLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("leaveApplyId", Long.valueOf(leaveApplyId));
	dynamicQuery.add(criterion3);
	docList = LeaveDocLocalServiceUtil.dynamicQuery(dynamicQuery);
	return docList;
	}
}