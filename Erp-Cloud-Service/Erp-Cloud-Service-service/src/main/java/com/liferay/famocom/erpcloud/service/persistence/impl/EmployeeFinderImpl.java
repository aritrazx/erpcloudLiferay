package com.liferay.famocom.erpcloud.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.Validator;

public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {

	public List<String[]> getEmployeeByEmployeeStatusAndNotStopPayAndBankName(long employeeStatus, String employeeIds){
		Session session = null;
		List<String[]> details	 = new ArrayList<String[]>();
		try{
			 session = openSession();
			//String sql = CustomSQLUtil.get(getClass(), GET_EMPLOYEE_SALARYDETAILS_BY_EMPLOYEEID_AND_YEAR);
			/*SQLQuery q = session.createSQLQuery("SELECT paydetails.*  FROM paydetails  WHERE  RIGHT( monthYear, 4 )=? AND employeeId=?");*/
			String sql = "SELECT emp.employeeId,emp.employeeCode,emp.firstName,emp.lastName,emp.accountNo,bmaster.bankName FROM  `employee` AS emp "
			+ " INNER JOIN `bankmaster` AS bmaster"
			+ " ON emp.bankId = bmaster.bankId WHERE emp.employeeStatus=?";
			if(Validator.isNotNull(employeeIds)){
			sql +=" AND emp.employeeId NOT IN (?)";
			}
			sql += " GROUP BY bmaster.bankName,emp.employeeId";

			SQLQuery q = session.createSQLQuery(sql); 
			q.setCacheable(false);
			//q.addEntity("paydetails", SalDetailsImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);	
		       qPos.add(employeeStatus);
		       if(Validator.isNotNull(employeeIds)){
		       	qPos.add(employeeIds);
		       }
			List<Object> results = (List<Object>) q.list();
			
			for(Object obj : results)
			 {
			 Object[] arrayobject = (Object[])obj;
			 String str[] = new String[arrayobject.length];
			 for(int i=0;i<arrayobject.length; i++){
				 str[i] = arrayobject[i].toString();				
			 }
			 details.add(str);
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeSession(session);
		}
	 return	details;
	}
}
