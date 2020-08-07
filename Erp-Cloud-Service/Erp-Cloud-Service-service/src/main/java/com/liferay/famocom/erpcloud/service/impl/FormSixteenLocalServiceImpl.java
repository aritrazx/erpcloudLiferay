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

import com.liferay.famocom.erpcloud.model.FormSixteen;
import com.liferay.famocom.erpcloud.service.base.FormSixteenLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the form sixteen local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.FormSixteenLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see FormSixteenLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.FormSixteenLocalServiceUtil
 */
public class FormSixteenLocalServiceImpl extends FormSixteenLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.FormSixteenLocalServiceUtil} to access the form sixteen local service.
	 */
	public List<FormSixteen> findBygetForm(long employeeId,String financialYear) throws SystemException {
		List<FormSixteen> formSixteens = new ArrayList<FormSixteen>();
		formSixteens = getFormSixteenPersistence().findBygetForm(employeeId, financialYear);
		return formSixteens;
		}	
}