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

package com.liferay.famocom.erpcloud.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TravelDeskDetails service. Represents a row in the &quot;TravelDesk&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see TravelDeskDetailsModel
 * @see com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsImpl
 * @see com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsImpl")
@ProviderType
public interface TravelDeskDetails extends TravelDeskDetailsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.TravelDeskDetailsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TravelDeskDetails, Long> TRAVEL_DETAILS_ID_ACCESSOR =
		new Accessor<TravelDeskDetails, Long>() {
			@Override
			public Long get(TravelDeskDetails travelDeskDetails) {
				return travelDeskDetails.getTravelDetailsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TravelDeskDetails> getTypeClass() {
				return TravelDeskDetails.class;
			}
		};
}