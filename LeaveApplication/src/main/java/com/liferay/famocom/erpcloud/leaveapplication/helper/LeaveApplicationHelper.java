/**
 * 
 */
package com.liferay.famocom.erpcloud.leaveapplication.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.famocom.erpcloud.leaveapplication.model.LeaveTypeDetails;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;
import com.liferay.famocom.erpcloud.model.LeaveOb;
import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveObLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Gouranga
 *
 */
public class LeaveApplicationHelper {

	public LeaveTypeDetails getLeaveTypeDetails(Employee employee, LeaveType leaveType) {
		LeaveTypeDetails leaveTypeDetails = new LeaveTypeDetails();

		if (Validator.isNotNull(employee.getEmployeeId()) && Validator.isNotNull(leaveType)) {
			// Get Opening Balance
			leaveTypeDetails.setLeaveTypeId(leaveType.getLeaveTypeId());
			leaveTypeDetails.setLeaveName(leaveType.getLeaveName());
			leaveTypeDetails.setAbbreviation(leaveType.getAbb());
			try {
				LeaveOb leaveOb = LeaveObLocalServiceUtil.openingBalance(employee.getEmployeeId(),
						leaveType.getLeaveTypeId());
				if (leaveOb != null)
					leaveTypeDetails.setOpeningBal(leaveOb.getObVal());
				else
					leaveTypeDetails.setOpeningBal(0);
			} catch (Exception e) {
				leaveTypeDetails.setOpeningBal(0);
				e.printStackTrace();
			}
			// Get other balances
			List<LeaveApplyDtl> leaveApplyDtls = new ArrayList<>();
			DynamicQuery leaveApplyDtlsQuery = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("employeeId", employee.getEmployeeId());
			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.eq("leaveTypeId", leaveType.getLeaveTypeId()));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isApprove", 1));
			leaveApplyDtlsQuery.add(criterion);
			leaveApplyDtls = LeaveApplyDtlLocalServiceUtil.dynamicQuery(leaveApplyDtlsQuery);
			leaveTypeDetails.setTakenApplied(0);
			for (LeaveApplyDtl obj : leaveApplyDtls) {
				leaveTypeDetails.setTakenApplied(leaveTypeDetails.getTakenApplied() + obj.getLeaveDays());
			}

			leaveTypeDetails.setEligible(isEligible(employee, leaveType, leaveTypeDetails.getTakenApplied()));

			leaveTypeDetails.setMaxCreditDay(leaveType.getMaxCreditDay());
			leaveTypeDetails.setClosingBal((leaveType.getMaxCreditDay() + leaveTypeDetails.getOpeningBal())
					- leaveTypeDetails.getTakenApplied());
		}

		return leaveTypeDetails;
	}

	public boolean isEligible(Employee employee, LeaveType leaveType, double leaveTaken) {
		boolean elligible = true;
		long daysOfService = (new Date().getTime() - employee.getDateOfJoing().getTime())/(1000 * 60 * 60 * 24);
		//System.out.println("::::daysOfService-----------------------------------------------------> "+daysOfService);
		if (leaveType.getEmployeetypeId() != 0) {
			if (employee.getEmployeetypeId() != leaveType.getEmployeetypeId()) {				
					elligible = false;
					//System.out.println("+++++++++++++++++++++++++++++++++++++ TYPE MISSMATCH +++++++++++++++++++++++++++++++++++"+leaveType.getLeaveName());
			}
		}

		if (leaveType.getMinServiceDay() != 0) {

			if (daysOfService < leaveType.getMinServiceDay()) {
				elligible = false;
				
				//System.out.println("+++++++++++++++++++++++++++++++++++++ MINIMUM SERVICE DAY NOT MATCH +++++++++++++++++++++++++++++++++++"+leaveType.getLeaveName());
			}
		}
		
		
		if (!leaveType.getGender().equalsIgnoreCase("All")) {
			if (!employee.getGender().equalsIgnoreCase(leaveType.getGender())) {
				//System.out.println("+++++++++++++++++++++++++++++++++++++ GENDER MISSMATCH +++++++++++++++++++++++++++++++++++"+leaveType.getLeaveName());
				elligible = false;
			} else {

				if (employee.getMaritalStatus().equalsIgnoreCase(leaveType.getMaritalStatus())) {

					if (employee.getNoOfChild() > 2) {
						//System.out.println("+++++++++++++++++++++++++++++++++++++ MAX NUMBER OF CHILD+++++++++++++++++++++++++++++++++++"+leaveType.getLeaveName());
						elligible = false;
					}
				}
			}
		}

		return elligible;
	}
	/*public int totalNoOfLeaveTake(Employee employee,LeaveType leaveType  ){
		
		LocalDate today = LocalDate.now();
		System.out.println("Current Date="+today);
		
		//long dateDiff = today - employee.getDateOfJoing();
		int tempMaxCreditDay =(leaveType.getMaxCreditDay()/12)*;
		return 0;
	}*/
	private static final LeaveApplicationHelper instance = new LeaveApplicationHelper();

	public static LeaveApplicationHelper getInstance() {
		return instance;
	}

}
