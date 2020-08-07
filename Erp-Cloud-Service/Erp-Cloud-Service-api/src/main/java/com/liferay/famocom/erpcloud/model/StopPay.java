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
 * The extended model interface for the StopPay service. Represents a row in the &quot;StopPay&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see StopPayModel
 * @see com.liferay.famocom.erpcloud.model.impl.StopPayImpl
 * @see com.liferay.famocom.erpcloud.model.impl.StopPayModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.StopPayImpl")
@ProviderType
public interface StopPay extends StopPayModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.StopPayImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StopPay, Long> STOP_PAY_ID_ACCESSOR = new Accessor<StopPay, Long>() {
			@Override
			public Long get(StopPay stopPay) {
				return stopPay.getStopPayId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StopPay> getTypeClass() {
				return StopPay.class;
			}
		};
}