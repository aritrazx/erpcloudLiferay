/**
 * 
 */
package com.liferay.famocom.erpcloud.appraisal.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyajit
 *
 */
public class ManageAppraisalModel {

	private String firstName;
	private String middleName;
	private String lastName;
	private String fullName;
	private String designation;
	private String emailId;
	private String dateOfJoining;
	private String fromDate;
	private String toDate;
	private long userId;
	private long employeeId;
	private String  perfomanceHeader;
	private String  performanceBody;
	private List<RatingMastersModel> ratingMasterModel = new ArrayList<RatingMastersModel>();
	private List<ProjectMastersModel> projectMasterModel = new ArrayList<ProjectMastersModel>();
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getPerfomanceHeader() {
		return perfomanceHeader;
	}
	public void setPerfomanceHeader(String perfomanceHeader) {
		this.perfomanceHeader = perfomanceHeader;
	}
	public String getPerformanceBody() {
		return performanceBody;
	}
	public void setPerformanceBody(String performanceBody) {
		this.performanceBody = performanceBody;
	}
	public List<RatingMastersModel> getRatingMasterModel() {
		return ratingMasterModel;
	}
	public void setRatingMasterModel(List<RatingMastersModel> ratingMasterModel) {
		this.ratingMasterModel = ratingMasterModel;
	}
	public List<ProjectMastersModel> getProjectMasterModel() {
		return projectMasterModel;
	}
	public void setProjectMasterModel(List<ProjectMastersModel> projectMasterModel) {
		this.projectMasterModel = projectMasterModel;
	}
	
	
}
