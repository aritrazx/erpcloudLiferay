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

import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.model.TravelDeskDetails;
import com.liferay.famocom.erpcloud.service.base.TravelDeskDetailsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the travel desk details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see TravelDeskDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil
 */
public class TravelDeskDetailsLocalServiceImpl
	extends TravelDeskDetailsLocalServiceBaseImpl {
	
	public List<TravelDeskDetails> findBytravel(long employeeId) throws SystemException, NoSuchRecruitProcessException{
		List<TravelDeskDetails> travelDeskDetails=null;
		travelDeskDetails = getTravelDeskDetailsPersistence().findBytravel(employeeId);
		return travelDeskDetails;
		}
	public List<TravelDeskDetails> findByprojectMember(long projectId) throws SystemException, NoSuchRecruitProcessException{
		List<TravelDeskDetails> travelDeskDetails=new ArrayList<TravelDeskDetails>();
		travelDeskDetails = getTravelDeskDetailsPersistence().findByprojectMemberList(projectId);
		return travelDeskDetails;
		}
}