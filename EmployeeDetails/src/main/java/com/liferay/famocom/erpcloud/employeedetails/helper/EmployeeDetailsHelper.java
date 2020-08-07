/**
 * 
 */
package com.liferay.famocom.erpcloud.employeedetails.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.famocom.erpcloud.employeedetails.model.EmployeeParams;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;



/**
 * @author raj
 *
 */
public class EmployeeDetailsHelper {

	private static final EmployeeDetailsHelper instance = new EmployeeDetailsHelper();
	static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param actionRequest
	 * @return
	 */
	public EmployeeParams setEmployeeParams(ActionRequest actionRequest) {
		EmployeeParams employeeParams = new EmployeeParams();
		employeeParams.setUserName(ParamUtil.getString(actionRequest, "userName"));
		employeeParams.setEmployeeCode(ParamUtil.getLong(actionRequest, "employeeCode"));
		employeeParams.setDateOfJoining(ParamUtil.getString(actionRequest, "dateOfJoining", StringPool.BLANK));
		employeeParams.setFirstName(ParamUtil.getString(actionRequest, "firstName", StringPool.BLANK));
		employeeParams.setLastName(ParamUtil.getString(actionRequest, "lastName", StringPool.BLANK));
		employeeParams.setDesignation(ParamUtil.getString(actionRequest, "designation", StringPool.BLANK));
		employeeParams.setDateOfBirth(ParamUtil.getString(actionRequest, "dateOfBirth", StringPool.BLANK));
		employeeParams.setGender(ParamUtil.getString(actionRequest, "gender", StringPool.BLANK));
		employeeParams.setMaritalStatus(ParamUtil.getString(actionRequest, "maritalStatus", StringPool.BLANK));
		employeeParams.setDateOfAnniversary(ParamUtil.getString(actionRequest, "dateOfAnniversary", StringPool.BLANK));
		employeeParams.setNoOfChild(ParamUtil.getInteger(actionRequest, "noOfChild"));
		employeeParams.setAddress(ParamUtil.getString(actionRequest, "address", StringPool.BLANK));
		employeeParams.setState(ParamUtil.getString(actionRequest, "state", StringPool.BLANK));
		employeeParams.setPostCode(ParamUtil.getString(actionRequest, "postCode", StringPool.BLANK));
		employeeParams.setHomePhone(ParamUtil.getInteger(actionRequest, "homePhone"));
		employeeParams.setMobileNumber(ParamUtil.getInteger(actionRequest, "mobileNumber"));
		employeeParams.setEmail(ParamUtil.getString(actionRequest, "email", StringPool.BLANK));
		employeeParams.setNote(ParamUtil.getString(actionRequest, "note", StringPool.BLANK));
		employeeParams.setTotalPay(ParamUtil.getDouble(actionRequest, "totalPay"));
		employeeParams.setCheck(ParamUtil.getInteger(actionRequest, "check"));
		employeeParams.setBasicPay(ParamUtil.getDouble(actionRequest, "basicPay"));
		employeeParams.setHouseRentAllowance(ParamUtil.getDouble(actionRequest, "houseRentAllowance"));
		employeeParams.setTravelAllowance(ParamUtil.getDouble(actionRequest, "travelAllowance"));
		employeeParams.setInternetAllowance(ParamUtil.getDouble(actionRequest, "internetAllowance"));
		employeeParams.setAreas(ParamUtil.getDouble(actionRequest, "areas"));
		employeeParams.setMobileAllowance(ParamUtil.getDouble(actionRequest, "mobileAllowance"));
		employeeParams.setDearnessAllowance(ParamUtil.getDouble(actionRequest, "dearnessAllowance"));
		employeeParams.setMedicalAllowance(ParamUtil.getDouble(actionRequest, "medicalAllowance"));
		employeeParams.setConveyanceAllowance(ParamUtil.getDouble(actionRequest, "conveyanceAllowance"));
		employeeParams.setFare(ParamUtil.getDouble(actionRequest, "fare"));
		employeeParams.setYearlyBonus(ParamUtil.getDouble(actionRequest, "yearlyBonus"));
		employeeParams.setOtherAllowance(ParamUtil.getDouble(actionRequest, "otherAllowance"));
		employeeParams.setProvidentFund(ParamUtil.getDouble(actionRequest, "providentFund"));
		employeeParams.setIncomeTax(ParamUtil.getDouble(actionRequest, "incomeTax"));
		employeeParams.setOtherDeduction(ParamUtil.getDouble(actionRequest, "otherDeduction"));
		employeeParams.setProfessionTax(ParamUtil.getDouble(actionRequest, "professionTax"));
		employeeParams.setBankId(ParamUtil.getLong(actionRequest, "bankId"));
		employeeParams.setAccountNumber(ParamUtil.getString(actionRequest, "accountNumber", StringPool.BLANK));
		employeeParams.setAadhaarNo(ParamUtil.getString(actionRequest, "aadhaarNo", StringPool.BLANK));
		employeeParams.setPanNo(ParamUtil.getString(actionRequest, "pan", StringPool.BLANK));
		employeeParams.setPfNumber(ParamUtil.getString(actionRequest, "pfNumber", StringPool.BLANK));
		employeeParams.setEmployeeTypeId(ParamUtil.get(actionRequest, "employeeType", StringPool.BLANK));
		employeeParams.setBranchId(ParamUtil.getLong(actionRequest, "branchId"));
		employeeParams.setPersonalEmail(ParamUtil.getString(actionRequest, "personalEmail", StringPool.BLANK));

		return employeeParams;
	}

	/**
	 * 
	 * @param employee
	 * @param params
	 * @return
	 */
	public Employee setEmployeePersistanceData(Employee employee, EmployeeParams params) {
		employee.setEmployeeCode(params.getEmployeeCode());

		try {
			employee.setDateOfJoing((Date) df.parse(params.getDateOfJoining()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		employee.setFirstName(params.getFirstName());
		employee.setLastName(params.getLastName());
		employee.setDesignation(params.getDesignation());
		try {
			employee.setDateOfBirth((Date) df.parse(params.getDateOfBirth()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setGender(params.getGender());
		employee.setMaritalStatus(params.getMaritalStatus());
		if (params.getMaritalStatus().equalsIgnoreCase("Married")) {
			try {
				employee.setAnniversary((Date) df.parse(params.getDateOfAnniversary()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			employee.setNoOfChild(params.getNoOfChild());
		}
		
		
		employee.setAddress(params.getAddress());
		employee.setState(params.getState());
		employee.setPostCode(params.getPostCode());
		employee.setHomePhone(params.getHomePhone());
		employee.setMobileNumber(params.getMobileNumber());
		employee.setEmaiAddress(params.getEmail());
		employee.setPesonalEmaiAddress(params.getPersonalEmail());
		employee.setNote(params.getNote());
		employee.setTotalPay(params.getTotalPay());
		employee.setIspfdeduct(params.getCheck());
		employee.setBasicPay(params.getBasicPay());
		employee.setHra(params.getHouseRentAllowance());
		employee.setTa(params.getTravelAllowance());
		employee.setInternet(params.getInternetAllowance());
		employee.setAreas(params.getAreas());
		employee.setMobile(params.getMobileAllowance());
		employee.setDa(params.getDearnessAllowance());
		employee.setMedical(params.getMedicalAllowance());
		employee.setConveyance(params.getConveyanceAllowance());
		employee.setFare(params.getFare());
		employee.setBouns(params.getYearlyBonus());
		employee.setOtherAllowance(params.getOtherAllowance());
		employee.setProvidentFund(params.getProvidentFund());
		employee.setIncomeTax(params.getIncomeTax());
		employee.setOtherDeduction(params.getOtherDeduction());
		employee.setProfessionTax(params.getProfessionTax());
		employee.setBankId(params.getBankId());
		employee.setAccountNo(params.getAccountNumber());
		employee.setAadhaarNo(params.getAadhaarNo());
		employee.setPanNo(params.getPanNo());
		employee.setPfNo(params.getPfNumber());
		employee.setEmployeetypeId(Integer.parseInt(params.getEmployeeTypeId()));
		employee.setBranchId(params.getBranchId());

		return employee;
	}

	
	public List<String> validateParams(EmployeeParams employeeParams){
		List<String> errorList = new ArrayList<String>();
		if (Validator.isNull(employeeParams.getFirstName())) {
			errorList.add("First name is required");
		}
		if (Validator.isNull(employeeParams.getLastName())) {
			errorList.add("Last Name is required");
		}
		if (Validator.isNull(employeeParams.getDateOfJoining())) {
			errorList.add("JoiningDate is required");
		}
		if (Validator.isNull(employeeParams.getDateOfBirth())) {
			errorList.add("BirthDay is required");
		}
		if (Validator.isNull(employeeParams.getDesignation())) {
			errorList.add("designation is required");
		}
		return errorList;
	} 
	
	
	
	public static EmployeeDetailsHelper getInstance() {
		return instance;
	}

}
