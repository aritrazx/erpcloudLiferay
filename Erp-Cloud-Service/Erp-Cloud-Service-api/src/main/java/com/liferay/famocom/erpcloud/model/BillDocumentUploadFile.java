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
 * The extended model interface for the BillDocumentUploadFile service. Represents a row in the &quot;billDocumentUploadFile&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samaresh
 * @see BillDocumentUploadFileModel
 * @see com.liferay.famocom.erpcloud.model.impl.BillDocumentUploadFileImpl
 * @see com.liferay.famocom.erpcloud.model.impl.BillDocumentUploadFileModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.famocom.erpcloud.model.impl.BillDocumentUploadFileImpl")
@ProviderType
public interface BillDocumentUploadFile extends BillDocumentUploadFileModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.famocom.erpcloud.model.impl.BillDocumentUploadFileImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BillDocumentUploadFile, Long> DOCUMENT_ID_ACCESSOR =
		new Accessor<BillDocumentUploadFile, Long>() {
			@Override
			public Long get(BillDocumentUploadFile billDocumentUploadFile) {
				return billDocumentUploadFile.getDocumentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BillDocumentUploadFile> getTypeClass() {
				return BillDocumentUploadFile.class;
			}
		};
}