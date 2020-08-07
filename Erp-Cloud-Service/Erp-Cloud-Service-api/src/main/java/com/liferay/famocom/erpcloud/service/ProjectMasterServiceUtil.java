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

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ProjectMaster. This utility wraps
 * {@link com.liferay.famocom.erpcloud.service.impl.ProjectMasterServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Samaresh
 * @see ProjectMasterService
 * @see com.liferay.famocom.erpcloud.service.base.ProjectMasterServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.impl.ProjectMasterServiceImpl
 * @generated
 */
@ProviderType
public class ProjectMasterServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.famocom.erpcloud.service.impl.ProjectMasterServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.liferay.famocom.erpcloud.model.ProjectMaster> getAllProject() {
		return getService().getAllProject();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ProjectMasterService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectMasterService, ProjectMasterService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectMasterService.class);

		ServiceTracker<ProjectMasterService, ProjectMasterService> serviceTracker =
			new ServiceTracker<ProjectMasterService, ProjectMasterService>(bundle.getBundleContext(),
				ProjectMasterService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}