/**;
 * 
 */
package com.liferay.famocom.erpcloud.leaveapplication.model;

/**
 * @author Gouranga
 *
 */
public class LeaveTypeDetails {
	private long leaveTypeId;
	private String leaveName;
	private String abbreviation;
	private double openingBal;
	private double creditedBal;
	private double takenApplied;
	private double closingBal;
	private double maxCreditDay;
	private boolean eligible;
	
	public long getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getLeaveName() {
		return leaveName;
	}
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}
	public double getOpeningBal() {
		return openingBal;
	}
	public void setOpeningBal(double openingBal) {
		this.openingBal = openingBal;
	}
	public double getCreditedBal() {
		return creditedBal;
	}
	public void setCreditedBal(double creditedBal) {
		this.creditedBal = creditedBal;
	}
	public double getTakenApplied() {
		return takenApplied;
	}
	public void setTakenApplied(double takenApplied) {
		this.takenApplied = takenApplied;
	}
	public double getClosingBal() {
		return closingBal;
	}
	public void setClosingBal(double closingBal) {
		this.closingBal = closingBal;
	}
	public double getMaxCreditDay() {
		return maxCreditDay;
	}
	public void setMaxCreditDay(double maxCreditDay) {
		this.maxCreditDay = maxCreditDay;
	}
	public boolean isEligible() {
		return eligible;
	}
	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	@Override
	public String toString() {
		return "LeaveTypeDetails [leaveTypeId=" + leaveTypeId + ", leaveName=" + leaveName + ", abbreviation="
				+ abbreviation + ", openingBal=" + openingBal + ", creditedBal=" + creditedBal + ", takenApplied="
				+ takenApplied + ", closingBal=" + closingBal + ", maxCreditDay=" + maxCreditDay + ", eligible="
				+ eligible + "]";
	}
	
	
}
