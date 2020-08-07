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

package com.liferay.famocom.erpcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.service.base.EmpPayStructureLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the emp pay structure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see EmpPayStructureLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil
 */
public class EmpPayStructureLocalServiceImpl
	extends EmpPayStructureLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil} to access the emp pay structure local service.
	 */
	
	public List<EmpPayStructure> findEmpPayStructureByEmployeeId(long employeeId) throws SystemException{
		List<EmpPayStructure> empPayStructures = new ArrayList<EmpPayStructure>();
		empPayStructures = getEmpPayStructurePersistence().findByemployeeId(employeeId);
		return empPayStructures;
		}

		public List<EmpPayStructure> findEmpPayStructureByPayComponentIdsAndEmployeeId(long[] paycomponentIds, long employeeId) throws SystemException{
		List<EmpPayStructure> empPayStructures = new ArrayList<EmpPayStructure>();
		empPayStructures = getEmpPayStructurePersistence().findBypayComponentIdsAndemployeeId(paycomponentIds, employeeId);
		return empPayStructures;
		}

		public EmpPayStructure findEmpPayStructureByPayComponentIdAndEmployeeId(long paycomponentId, long employeeId) throws SystemException, NoSuchEmpPayStructureException{
		EmpPayStructure empPayStructures = getEmpPayStructurePersistence().findBypayComponentIdAndemployeeId(paycomponentId, employeeId);
		return empPayStructures;
		}

		public List<EmpPayStructure> findEmpPayStructureByPayComponentId(long paycomponentId) throws SystemException{
		List<EmpPayStructure> empPayStructures = new ArrayList<EmpPayStructure>();
		empPayStructures = getEmpPayStructurePersistence().findBypayComponentId(paycomponentId);
		return empPayStructures;
		}
		public List<Long> getEmployeeIdFromEmpPayStructure(){
		return empPayStructureFinder.getEmployeeIdFormEmpPayStructure();
		}
		/*samaresh*/
		public EmpPayStructure findByemployeeIdPayComponentId(long employeeId, long payComponentId) throws SystemException {
			EmpPayStructure empPayStructures = null;
			try {
			empPayStructures = getEmpPayStructurePersistence().findByemployeeIdPayComponentId(employeeId,
			payComponentId);
			} catch (NoSuchEmpPayStructureException e) {
			// TODO Auto-generated catch block
			}
			return empPayStructures;
			}
		/*samaresh*/
}