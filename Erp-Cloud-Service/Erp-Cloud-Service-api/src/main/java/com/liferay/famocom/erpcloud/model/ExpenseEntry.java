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
 * The extended model interface for the ExpenseEntry service. Represents a row in the &quot;expenseEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see ExpenseEntryModel
 * @see com.liferay.famocom.erpcloud.model.impl.ExpenseEntryImpl
 * @see com.liferay.famocom.erpcloud.model.impl.ExpenseEntryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.ExpenseEntryImpl")
@ProviderType
public interface ExpenseEntry extends ExpenseEntryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.ExpenseEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ExpenseEntry, Long> EXPENSE_ID_ACCESSOR = new Accessor<ExpenseEntry, Long>() {
			@Override
			public Long get(ExpenseEntry expenseEntry) {
				return expenseEntry.getExpenseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ExpenseEntry> getTypeClass() {
				return ExpenseEntry.class;
			}
		};
}