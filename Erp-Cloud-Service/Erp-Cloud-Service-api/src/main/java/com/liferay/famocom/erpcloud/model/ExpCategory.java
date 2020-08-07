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
 * The extended model interface for the ExpCategory service. Represents a row in the &quot;expCategory&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see ExpCategoryModel
 * @see com.liferay.famocom.erpcloud.model.impl.ExpCategoryImpl
 * @see com.liferay.famocom.erpcloud.model.impl.ExpCategoryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.ExpCategoryImpl")
@ProviderType
public interface ExpCategory extends ExpCategoryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.ExpCategoryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ExpCategory, Long> CAT_ID_ACCESSOR = new Accessor<ExpCategory, Long>() {
			@Override
			public Long get(ExpCategory expCategory) {
				return expCategory.getCatId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ExpCategory> getTypeClass() {
				return ExpCategory.class;
			}
		};
}