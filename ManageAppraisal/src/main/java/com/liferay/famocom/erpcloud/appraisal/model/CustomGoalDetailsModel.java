/**
 * 
 */
package com.liferay.famocom.erpcloud.appraisal.model;

/**
 * @author Priyajit
 *
 */
public class CustomGoalDetailsModel {
	private long goalDetailId;
	private long evalutionId;
	private String scale;
	private String parameter;

	public long getGoalDetailId() {
		return goalDetailId;
	}

	public void setGoalDetailId(long goalDetailId) {
		this.goalDetailId = goalDetailId;
	}

	public long getEvalutionId() {
		return evalutionId;
	}

	public void setEvalutionId(long evalutionId) {
		this.evalutionId = evalutionId;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
