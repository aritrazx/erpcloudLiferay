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
import com.liferay.famocom.erpcloud.model.CandidateReview;
import com.liferay.famocom.erpcloud.service.base.CandidateReviewLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the candidate review local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.CandidateReviewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see CandidateReviewLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.CandidateReviewLocalServiceUtil
 */
public class CandidateReviewLocalServiceImpl
	extends CandidateReviewLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.CandidateReviewLocalServiceUtil} to access the candidate review local service.
	 */
	
	public List<CandidateReview> findCandidateReviewByRecruitProcessId(long recruitProcessId) throws SystemException, NoSuchRecruitProcessException{
		List<CandidateReview> recruitCol=new ArrayList<CandidateReview>();
		recruitCol = getCandidateReviewPersistence().findBycandidateReview(recruitProcessId);
		return recruitCol;
		}
}