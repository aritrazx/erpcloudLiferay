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

package com.liferay.famocom.erpcloud.service.persistence.impl;

import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.service.persistence.SalDetailsPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Samaresh
 * @generated
 */
public class SalDetailsFinderBaseImpl extends BasePersistenceImpl<SalDetails> {
	public SalDetailsFinderBaseImpl() {
		setModelClass(SalDetails.class);
	}

	/**
	 * Returns the sal details persistence.
	 *
	 * @return the sal details persistence
	 */
	public SalDetailsPersistence getSalDetailsPersistence() {
		return salDetailsPersistence;
	}

	/**
	 * Sets the sal details persistence.
	 *
	 * @param salDetailsPersistence the sal details persistence
	 */
	public void setSalDetailsPersistence(
		SalDetailsPersistence salDetailsPersistence) {
		this.salDetailsPersistence = salDetailsPersistence;
	}

	@BeanReference(type = SalDetailsPersistence.class)
	protected SalDetailsPersistence salDetailsPersistence;
}