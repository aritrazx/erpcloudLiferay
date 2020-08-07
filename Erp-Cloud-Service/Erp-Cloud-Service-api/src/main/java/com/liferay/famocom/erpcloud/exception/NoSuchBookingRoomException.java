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
package com.liferay.famocom.erpcloud.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Samaresh
 */
@ProviderType
public class NoSuchBookingRoomException extends NoSuchModelException {

	public NoSuchBookingRoomException() {
	}

	public NoSuchBookingRoomException(String msg) {
		super(msg);
	}

	public NoSuchBookingRoomException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBookingRoomException(Throwable cause) {
		super(cause);
	}

}