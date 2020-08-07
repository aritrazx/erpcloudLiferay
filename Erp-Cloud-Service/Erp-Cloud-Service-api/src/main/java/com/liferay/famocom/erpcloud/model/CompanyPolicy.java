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
 * The extended model interface for the CompanyPolicy service. Represents a row in the &quot;companyPolicy&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see CompanyPolicyModel
 * @see com.liferay.famocom.erpcloud.model.impl.CompanyPolicyImpl
 * @see com.liferay.famocom.erpcloud.model.impl.CompanyPolicyModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.CompanyPolicyImpl")
@ProviderType
public interface CompanyPolicy extends CompanyPolicyModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.CompanyPolicyImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CompanyPolicy, Long> COMPANY_POLICY_ID_ACCESSOR =
		new Accessor<CompanyPolicy, Long>() {
			@Override
			public Long get(CompanyPolicy companyPolicy) {
				return companyPolicy.getCompanyPolicyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CompanyPolicy> getTypeClass() {
				return CompanyPolicy.class;
			}
		};
}