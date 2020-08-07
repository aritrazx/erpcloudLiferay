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
 * The extended model interface for the FormSixteen service. Represents a row in the &quot;FormSixteen&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see FormSixteenModel
 * @see com.liferay.famocom.erpcloud.model.impl.FormSixteenImpl
 * @see com.liferay.famocom.erpcloud.model.impl.FormSixteenModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.FormSixteenImpl")
@ProviderType
public interface FormSixteen extends FormSixteenModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.FormSixteenImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FormSixteen, Long> ID_ACCESSOR = new Accessor<FormSixteen, Long>() {
			@Override
			public Long get(FormSixteen formSixteen) {
				return formSixteen.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FormSixteen> getTypeClass() {
				return FormSixteen.class;
			}
		};
}