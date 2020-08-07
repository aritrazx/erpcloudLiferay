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
 * The extended model interface for the GoalMaster service. Represents a row in the &quot;goalMaster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see GoalMasterModel
 * @see com.liferay.famocom.erpcloud.model.impl.GoalMasterImpl
 * @see com.liferay.famocom.erpcloud.model.impl.GoalMasterModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.GoalMasterImpl")
@ProviderType
public interface GoalMaster extends GoalMasterModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.GoalMasterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GoalMaster, Long> GOAL_ID_ACCESSOR = new Accessor<GoalMaster, Long>() {
			@Override
			public Long get(GoalMaster goalMaster) {
				return goalMaster.getGoalId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GoalMaster> getTypeClass() {
				return GoalMaster.class;
			}
		};
}