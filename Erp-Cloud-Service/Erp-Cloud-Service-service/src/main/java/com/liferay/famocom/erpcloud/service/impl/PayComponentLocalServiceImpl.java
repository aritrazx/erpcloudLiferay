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
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.service.base.PayComponentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the pay component local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.famocom.erpcloud.service.PayComponentLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see PayComponentLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil
 */
public class PayComponentLocalServiceImpl
	extends PayComponentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil} to
	 * access the pay component local service.
	 */
	public List<PayComponent> findPayComponentByTaxStatusAndPayType(int taxStatus,String payType) throws SystemException{
		List<PayComponent> payComponentsList = new ArrayList<PayComponent>();
		payComponentsList = getPayComponentPersistence().findBytaxStatusAndpayType(taxStatus, payType);
		return payComponentsList;
		}
		public List<PayComponent> findPayComponentByNameAndComponentId (String name,long payComponentId) throws SystemException{
		List<PayComponent> payComponentsList = new ArrayList<PayComponent>();
		payComponentsList = getPayComponentPersistence().findBynameAndcomponentId(name, payComponentId);
		return payComponentsList;
		}
		public List<PayComponent> findPayComponentByAbbreviationAndComponentId(String abbreviation,long payComponentId) throws SystemException{
		List<PayComponent> payComponentsList = new ArrayList<PayComponent>();
		payComponentsList = getPayComponentPersistence().findByabbreviationAndcomponentId( abbreviation, payComponentId);
		return payComponentsList;
		}
		/*samaresh*/
		public List<PayComponent> findByPayType(String payType) throws SystemException {
			List<PayComponent> payComponentsList = new ArrayList<PayComponent>();
			payComponentsList = getPayComponentPersistence().findBypayType(payType);
			return payComponentsList;
			}
		/*samaresh*/
}