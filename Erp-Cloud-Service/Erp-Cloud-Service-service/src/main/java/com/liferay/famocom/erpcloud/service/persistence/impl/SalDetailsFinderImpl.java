package com.liferay.famocom.erpcloud.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.impl.SalDetailsImpl;
import com.liferay.famocom.erpcloud.service.persistence.SalDetailsFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

public class SalDetailsFinderImpl extends SalDetailsFinderBaseImpl implements SalDetailsFinder  {
	
	/**
	 * @param employeeId
	 * @param year
	 * @return
	 */
	public List<String[]> getEmployeeSalaryDetailsByEmployeeIdAndYear(long employeeId, int year){
		Session session = null;
		List<String[]> details	 = new ArrayList<String[]>();
		try{
			session = openSession();
			String sql = CustomSQLUtil.get(getClass(), GET_EMPLOYEE_SALARYDETAILS_BY_EMPLOYEEID_AND_YEAR);
			/*SQLQuery q = session.createSQLQuery("SELECT paydetails.*  FROM paydetails  WHERE  RIGHT( monthYear, 4 )=? AND employeeId=?");*/
			
			SQLQuery q = session.createSQLQuery("SELECT a.monthYear, a.employeeId , SUM(a.paytype_sum_d) AS totalDeduction , SUM(a.paytype_sum_e) AS totalEarning "
			 +" FROM"
			 +" (SELECT   paydet.monthYear,paydet.employeeId,"
			 +" (CASE WHEN paycomp.paytype='D' THEN SUM(paydet.value) END) AS paytype_sum_d ,"
			 +" (CASE WHEN paycomp.paytype='E' THEN SUM(paydet.value) END) AS paytype_sum_e "		
			 +" FROM `paydetails` AS paydet "
			 +" INNER JOIN paycomponent AS paycomp ON paydet.componentId =paycomp.componentId AND RIGHT( paydet.monthYear, 4 )=? AND employeeId=?"
			 +" GROUP BY paydet.employeeId,paydet.monthYear,paycomp.paytype) a"
			 +" GROUP BY a.employeeId,a.monthYear");
			q.setCacheable(false);
			//q.addEntity("paydetails", SalDetailsImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);			
	        qPos.add(year);
	        qPos.add(employeeId);
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
 public static final String GET_EMPLOYEE_SALARYDETAILS_BY_EMPLOYEEID_AND_YEAR = SalDetailsFinder.class.getName()+".getEmployeeSalaryDetailsByEmployeeIdAndYear";
}
