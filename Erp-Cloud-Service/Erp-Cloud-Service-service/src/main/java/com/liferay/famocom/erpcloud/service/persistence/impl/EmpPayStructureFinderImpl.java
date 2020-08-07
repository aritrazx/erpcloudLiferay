package com.liferay.famocom.erpcloud.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.famocom.erpcloud.service.persistence.EmpPayStructureFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

public class EmpPayStructureFinderImpl extends EmpPayStructureFinderBaseImpl implements EmpPayStructureFinder {

	public List<Long> getEmployeeIdFormEmpPayStructure(){
		Session session = null;
		List<Long> employeeIds = new ArrayList<Long>();
		try {
		session = openSession();
		String sql = CustomSQLUtil.get(getClass(), GET_EMPLOYEEID_FROM_EMPPAYSTRUCTURE);
		SQLQuery q = session.createSQLQuery(sql);
		q.setCacheable(false);
		QueryPos qPos = QueryPos.getInstance(q);		
		employeeIds = (List<Long>) q.list();
		} catch (Exception e) {
		try {
		throw new SystemException(e);
		} catch (SystemException se) {
		se.printStackTrace();
		}
		} finally {
		closeSession(session);
		}
		return employeeIds;
	}
	public static final String GET_EMPLOYEEID_FROM_EMPPAYSTRUCTURE = EmpPayStructureFinder.class.getName() +
			".getEmployeeIdFormEmpPayStructure";

}
