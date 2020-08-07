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

import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.service.persistence.RatingMasterPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Samaresh
 * @generated
 */
public class RatingMasterFinderBaseImpl extends BasePersistenceImpl<RatingMaster> {
	public RatingMasterFinderBaseImpl() {
		setModelClass(RatingMaster.class);
	}

	/**
	 * Returns the rating master persistence.
	 *
	 * @return the rating master persistence
	 */
	public RatingMasterPersistence getRatingMasterPersistence() {
		return ratingMasterPersistence;
	}

	/**
	 * Sets the rating master persistence.
	 *
	 * @param ratingMasterPersistence the rating master persistence
	 */
	public void setRatingMasterPersistence(
		RatingMasterPersistence ratingMasterPersistence) {
		this.ratingMasterPersistence = ratingMasterPersistence;
	}

	@BeanReference(type = RatingMasterPersistence.class)
	protected RatingMasterPersistence ratingMasterPersistence;
}