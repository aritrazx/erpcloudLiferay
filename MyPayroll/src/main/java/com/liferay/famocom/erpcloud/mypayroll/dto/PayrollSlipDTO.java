package com.liferay.famocom.erpcloud.mypayroll.dto;

public class PayrollSlipDTO {
	
	private String earn;
	private String earningAmount;
	private String ded;
	private String dedAmount;
	
	
	
	
	public PayrollSlipDTO(String earn, String earningAmount, String ded, String dedAmount) {
		super();
		this.earn = earn;
		this.earningAmount = earningAmount;
		this.ded = ded;
		this.dedAmount = dedAmount;
	}
	public String getEarn() {
		return earn;
	}
	public void setEarn(String earn) {
		this.earn = earn;
	}
	public String getEarningAmount() {
		return earningAmount;
	}
	public void setEarningAmount(String earningAmount) {
		this.earningAmount = earningAmount;
	}
	public String getDed() {
		return ded;
	}
	public void setDed(String ded) {
		this.ded = ded;
	}
	public String getDedAmount() {
		return dedAmount;
	}
	public void setDedAmount(String dedAmount) {
		this.dedAmount = dedAmount;
	}
	
	
	
	

}
