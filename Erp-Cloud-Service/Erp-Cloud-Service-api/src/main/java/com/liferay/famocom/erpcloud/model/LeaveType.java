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
 * The extended model interface for the LeaveType service. Represents a row in the &quot;leaveType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see LeaveTypeModel
 * @see com.liferay.famocom.erpcloud.model.impl.LeaveTypeImpl
 * @see com.liferay.famocom.erpcloud.model.impl.LeaveTypeModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.LeaveTypeImpl")
@ProviderType
public interface LeaveType extends LeaveTypeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.LeaveTypeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LeaveType, Long> LEAVE_TYPE_ID_ACCESSOR = new Accessor<LeaveType, Long>() {
			@Override
			public Long get(LeaveType leaveType) {
				return leaveType.getLeaveTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LeaveType> getTypeClass() {
				return LeaveType.class;
			}
		};
}