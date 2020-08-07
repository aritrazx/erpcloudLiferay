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

import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure;
import com.liferay.famocom.erpcloud.service.base.SelectedCandidatePayStructureLocalServiceBaseImpl;

/**
 * The implementation of the selected candidate pay structure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see SelectedCandidatePayStructureLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalServiceUtil
 */
public class SelectedCandidatePayStructureLocalServiceImpl
	extends SelectedCandidatePayStructureLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalServiceUtil} to access the selected candidate pay structure local service.
	 */
	/**
	* find by recruitmentProcessId and payStatus
	* @param recruitmentProcessId
	* @param payStatus
	* @return
	*/
	public List<SelectedCandidatePayStructure> findByrecruitmentProcessIdAndPayStatus(long recruitmentProcessId,int payStatus){
	List<SelectedCandidatePayStructure> selectedCandidatePayStructure = new ArrayList<>();
	try {
	selectedCandidatePayStructure = getSelectedCandidatePayStructurePersistence().findByrecruitmentProcessIdAndPayStatus(recruitmentProcessId, payStatus);
	} catch (Exception e) {
	e.printStackTrace();
	}
	return selectedCandidatePayStructure;

	}
}