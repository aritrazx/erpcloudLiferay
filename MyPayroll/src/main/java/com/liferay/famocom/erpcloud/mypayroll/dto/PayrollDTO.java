package com.liferay.famocom.erpcloud.mypayroll.dto;

import java.util.List;

public class PayrollDTO {

	private long employeeCode;
	private long employeeId;
	private String employeeName;
	private String monthYear;
	private String accountNumber;
	private long payComponentId;
	private String payComponentName;
	private long payComponentValue;
	
	
	
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	public long getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getPayComponentId() {
		return payComponentId;
	}
	public void setPayComponentId(long payComponentId) {
		this.payComponentId = payComponentId;
	}
	public String getPayComponentName() {
		return payComponentName;
	}
	public void setPayComponentName(String payComponentName) {
		this.payComponentName = payComponentName;
	}
	public long getPayComponentValue() {
		return payComponentValue;
	}
	public void setPayComponentValue(long payComponentValue) {
		this.payComponentValue = payComponentValue;
	}
	
	
}
