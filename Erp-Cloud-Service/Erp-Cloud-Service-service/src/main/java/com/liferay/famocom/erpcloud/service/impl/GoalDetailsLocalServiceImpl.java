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

import com.liferay.famocom.erpcloud.model.GoalDetails;
import com.liferay.famocom.erpcloud.service.base.GoalDetailsLocalServiceBaseImpl;

/**
 * The implementation of the goal details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.GoalDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see GoalDetailsLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil
 */
public class GoalDetailsLocalServiceImpl extends GoalDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil} to access the goal details local service.
	 */
	public List<GoalDetails> findByGoalId(long goalId) {
		List<GoalDetails> goalDetails = new ArrayList<GoalDetails>();
		if (goalId > 0) {
			try {
				goalDetails = goalDetailsPersistence.findByGoalId(goalId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goalDetails;
	}
}