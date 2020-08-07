/**
 * 
 */
package com.liferay.famocom.erpcloud.appraisal.model;

/**
 * @author Priyajit
 *
 */
public class RatingMastersModel {

	private long ratingId;
	private String ratingNum;
	private String ratingKey;
	private String ratingDescription;
	private long salaryPercentage;

	public long getRatingId() {
		return ratingId;
	}

	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingNum() {
		return ratingNum;
	}

	public void setRatingNum(String ratingNum) {
		this.ratingNum = ratingNum;
	}

	public String getRatingKey() {
		return ratingKey;
	}

	public void setRatingKey(String ratingKey) {
		this.ratingKey = ratingKey;
	}

	public String getRatingDescription() {
		return ratingDescription;
	}

	public void setRatingDescription(String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

	public long getSalaryPercentage() {
		return salaryPercentage;
	}

	public void setSalaryPercentage(long salaryPercentage) {
		this.salaryPercentage = salaryPercentage;
	}

}
