package com.liferay.famocom.erpcloud.salaryregister.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.salaryregister.constants.SalaryRegisterPortletKeys;
import com.liferay.famocom.erpcloud.salaryregister.dto.SalaryRegisterDTO;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class SalaryRegisterDAO {
	
	
	public static List<SalaryRegisterDTO> getSalaryRegister(String month,String year) throws PortalException{
		
		List<SalaryRegisterDTO> dtos = new ArrayList<>();
		List<SalDetails>  detailsList = new ArrayList<>();
		List<SalDetails>  detailsEmployeeList = new ArrayList<>();
		List<PayComponent> componentList = new ArrayList<>();
		List<Employee>  employees = new ArrayList<>();
		String monthYear = month + year;
		System.out.println("monthYear.... "+monthYear);
		 String[] months = {"January", "February", "March","April", "May", "June", "July", "August","September", "October", "November", "December"};
		 String monthYr=months[Integer.valueOf(month)-1]+" "+year;
		 
		if(Validator.isNotNull(monthYear)){
			componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
			List<StopPay>  stopPaylist = new ArrayList<StopPay>();
			stopPaylist = StopPayLocalServiceUtil.findStopPayByMonthYear(Long.valueOf(monthYear));	
			long[] empIds = new long[stopPaylist.size()];
			String emplds = StringPool.BLANK;
			int i=0;
			for(StopPay pay:stopPaylist){
				//empIds[i] = pay.getEmployeeId();
				if(i<stopPaylist.size()-1){
					emplds =  pay.getEmployeeId()+",";
				}else{
					emplds =  String.valueOf(pay.getEmployeeId());
				}
				i++;
			}
			System.out.println("emplds "+emplds);
			//	long[] empIds = {1,101};
			//employees = EmployeeLocalServiceUtil.findEmployeeByStatusAndEmployeeIdNotIn(0, empIds);
			 List<String[]>  strings = EmployeeLocalServiceUtil.getEmployeeByEmployeeStatusAndNotStopPayAndBankName(0, emplds);
			 for(String[] strArray:strings){
				 Object[] arrayobject = (Object[])strArray;
				 	SalaryRegisterDTO  dto = new SalaryRegisterDTO();
					  dto.setEmployeeId(GetterUtil.getLong(arrayobject[0]));
					  dto.setEmployeeCode(GetterUtil.getLong(arrayobject[1]));
					  dto.setEmployeeName(GetterUtil.getString(arrayobject[2])+" "+GetterUtil.getString(arrayobject[3]));
					  dto.setAccountNumber(GetterUtil.getString(arrayobject[4]));
					  dto.setBankName(GetterUtil.getString(arrayobject[5]));
					  dto.setMonthYear(monthYr);
					  System.out.println("arrayobject  "+arrayobject[0]);
					  dtos.add(dto);
					  System.out.println("dto  "+dto.getEmployeeId());
				}
				
			 
			/*if(employees.size()>0){
				for(Employee emp:employees){
					
					SalaryRegisterDTO  dto = new SalaryRegisterDTO();					
					detailsEmployeeList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), emp.getEmployeeId());
					HashMap<Long, String> hashMap = new HashMap<>();
					for(SalDetails details:detailsEmployeeList){						
						hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
						//dto.setPayComponentId();
						//dto.setPayComponentName(payComponentName);
						//dto.setPayComponentValue();
					}
					
					dto.setEmployeeName(emp.getFirstName()+" "+emp.getLastName());
					dto.setEmployeeCode(emp.getEmployeeCode());
					dto.setAccountNumber(emp.getAccountNo());
					dto.setEmployeeId(emp.getEmployeeId());
					dto.setMonthYear(monthYr);	
					dto.setBankName("");
					dtos.add(dto);
				}
				
			}*/
		}
		
		return dtos;
		
	}

public static HashMap<Long, String> getEmployeeEarningComponent(String monthYear,long empId) throws PortalException{
		
		List<SalDetails>  detailsEmployeeList = new ArrayList<>();
		HashMap<Long, String> hashMap = new HashMap<>();
		List<String> earningList = new ArrayList<String>();
		earningList.add(SalaryRegisterPortletKeys.Earning);
		earningList.add(SalaryRegisterPortletKeys.Overtime);
		earningList.add(SalaryRegisterPortletKeys.Reimbursement);
		earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
		//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		if(Validator.isNotNull(monthYear)){					
			detailsEmployeeList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), empId);
			System.out.println("detailsEmployeeList...."+detailsEmployeeList.size());
			hashMap = new HashMap<>();
			for(SalDetails details:detailsEmployeeList){	
				PayComponent componentt;
				try {
					componentt = PayComponentLocalServiceUtil.getPayComponent(details.getComponentId());
				if (earningList.contains(componentt.getPayType())) {
					hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}	
		}
		return hashMap;		
	}
public static HashMap<Long, String> getEmployeeEarningComponentbyMonthYearAndEmployeeId(String monthYear,long empId) throws PortalException{
	
	List<SalDetails>  detailsEmployeeList = new ArrayList<>();
	HashMap<Long, String> hashMap = new HashMap<>();
	List<String> earningList = new ArrayList<String>();
	earningList.add(SalaryRegisterPortletKeys.Earning);
	earningList.add(SalaryRegisterPortletKeys.Overtime);
	earningList.add(SalaryRegisterPortletKeys.Reimbursement);
	earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(Validator.isNotNull(monthYear)){	
		List<PayComponent>  components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		hashMap = new HashMap<>();
		for (PayComponent payComponent : components) {
			 SalDetails  details = null;
			 try{
			 details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(empId, payComponent.getComponentId(), Long.valueOf(monthYear));
			 }catch (Exception e) {
				// TODO: handle exception
			}
			 if(Validator.isNotNull(details)){
				 if (earningList.contains(payComponent.getPayType())) {
						hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
				}else{
					 hashMap.put(payComponent.getComponentId(), "0.00");
				 }
			 }
		}
	}		
	return hashMap;		
}
//get Earning Components for paySlip pdf
public static HashMap<Long, String> getEarningComponentbyMonthYearAndEmployeeId(String monthYear,long empId) throws PortalException{
	
	List<SalDetails>  detailsEmployeeList = new ArrayList<>();
	HashMap<Long, String> hashMap = new HashMap<>();
	List<String> earningList = new ArrayList<String>();
	earningList.add(SalaryRegisterPortletKeys.Earning);
	earningList.add(SalaryRegisterPortletKeys.Overtime);
	earningList.add(SalaryRegisterPortletKeys.Reimbursement);
	earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(Validator.isNotNull(monthYear)){	
		List<PayComponent>  components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		hashMap = new HashMap<>();
		for (PayComponent payComponent : components) {
			 SalDetails  details = null;
			 try{
			 details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(empId, payComponent.getComponentId(), Long.valueOf(monthYear));
			 }catch (Exception e) {
				// TODO: handle exception
			}
			 if(Validator.isNotNull(details)){
				 if (earningList.contains(payComponent.getPayType())) {
						hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
				}
			 }
		}
	}		
	return hashMap;		
}
public static HashMap<Long, String> getEmployeeDeductionComponentbyMonthYearAndEmployeeId(String monthYear,long empId) throws PortalException{
	
	List<SalDetails>  detailsEmployeeList = new ArrayList<>();
	HashMap<Long, String> hashMap = new HashMap<>();
	List<String> earningList = new ArrayList<String>();
	earningList.add(SalaryRegisterPortletKeys.Earning);
	earningList.add(SalaryRegisterPortletKeys.Overtime);
	earningList.add(SalaryRegisterPortletKeys.Reimbursement);
	earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(Validator.isNotNull(monthYear)){	
		List<PayComponent>  components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		hashMap = new HashMap<>();
		for (PayComponent payComponent : components) {
			 SalDetails  details = null;
			 try{
			 details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(empId, payComponent.getComponentId(), Long.valueOf(monthYear));
			 }catch (Exception e) {
				// TODO: handle exception
			}
			 //if(Validator.isNotNull(details)){
			 if (payComponent.getPayType().equalsIgnoreCase(SalaryRegisterPortletKeys.Deduction)) {
					 if(Validator.isNotNull(details)){
						hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
					 }else{
						 hashMap.put(payComponent.getComponentId(), "0.00");
					 }
				}
			 //}
		}
	}		
	return hashMap;		
}
public static HashMap<Long, String> getEmployeeDeductionComponent(String monthYear,long empId) throws PortalException{
	
	List<SalDetails>  detailsEmployeeList = new ArrayList<>();
	HashMap<Long, String> hashMap = new HashMap<>();
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(Validator.isNotNull(monthYear)){					
		detailsEmployeeList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), empId);
		hashMap = new HashMap<>();
		if(detailsEmployeeList.size()>0){
		for(SalDetails details:detailsEmployeeList){	
			PayComponent componentt;
			try {
				componentt = PayComponentLocalServiceUtil.getPayComponent(details.getComponentId());
			if (componentt.getPayType().equalsIgnoreCase(SalaryRegisterPortletKeys.Deduction)) {
				hashMap.put(details.getComponentId(), String.valueOf(details.getValue()));
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		}
	}
	return hashMap;		
}


public static double getTotalDeductionByMonthYearAndEmployeeId(String monthYear,long empId) throws PortalException{	
	List<SalDetails>  detailsEmployeeList = new ArrayList<>();
	double totalDeducation =0;
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(Validator.isNotNull(monthYear)){					
		detailsEmployeeList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYearAndEmployeeId(Long.valueOf(monthYear), empId);
		if(Validator.isNotNull(detailsEmployeeList)){
			for(SalDetails details:detailsEmployeeList){	
				PayComponent componentt;
				try {
					componentt = PayComponentLocalServiceUtil.getPayComponent(details.getComponentId());
				if (componentt.getPayType().equalsIgnoreCase(SalaryRegisterPortletKeys.Deduction)) {
					totalDeducation += details.getValue();
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	return totalDeducation;		
}

	public static double getTotalEarningByMonthYearAndEmployeeId(String monthYear, long empId) throws PortalException {
		double totalEarning = 0;
		List<String> earningList = new ArrayList<String>();
		earningList.add(SalaryRegisterPortletKeys.Earning);
		earningList.add(SalaryRegisterPortletKeys.Overtime);
		earningList.add(SalaryRegisterPortletKeys.Reimbursement);
		earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
		if (Validator.isNotNull(monthYear)) {
			List<PayComponent> components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
			for (PayComponent payComponent : components) {
				SalDetails details = null;
				try {
					details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(empId,
							payComponent.getComponentId(), Long.valueOf(monthYear));
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (earningList.contains(payComponent.getPayType())) {
					if (Validator.isNotNull(details)) {
						totalEarning += details.getValue();
					}
				}
			}

		}
		return totalEarning;
	}

}
