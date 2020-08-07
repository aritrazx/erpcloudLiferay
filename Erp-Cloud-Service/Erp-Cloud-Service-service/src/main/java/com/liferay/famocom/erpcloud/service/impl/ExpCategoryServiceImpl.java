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

import com.liferay.famocom.erpcloud.model.ExpCategory;
import com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.base.ExpCategoryServiceBaseImpl;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

/**
 * The implementation of the exp category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.ExpCategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Samaresh
 * @see ExpCategoryServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.ExpCategoryServiceUtil
 */
public class ExpCategoryServiceImpl extends ExpCategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.ExpCategoryServiceUtil} to access the exp category remote service.
	 */
	@AccessControlled(guestAccessEnabled=true)
	public List<ExpCategory> getAllCategories(){
		List<ExpCategory> categoriesList = ExpCategoryLocalServiceUtil.getExpCategories(-1,-1);
		return categoriesList;
	}
}