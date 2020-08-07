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
 * The extended model interface for the SchedulesMaster service. Represents a row in the &quot;SchedulesMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see SchedulesMasterModel
 * @see com.liferay.famocom.erpcloud.model.impl.SchedulesMasterImpl
 * @see com.liferay.famocom.erpcloud.model.impl.SchedulesMasterModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.SchedulesMasterImpl")
@ProviderType
public interface SchedulesMaster extends SchedulesMasterModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.SchedulesMasterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SchedulesMaster, Long> SCHEDULES_ID_ACCESSOR = new Accessor<SchedulesMaster, Long>() {
			@Override
			public Long get(SchedulesMaster schedulesMaster) {
				return schedulesMaster.getSchedulesId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SchedulesMaster> getTypeClass() {
				return SchedulesMaster.class;
			}
		};
}