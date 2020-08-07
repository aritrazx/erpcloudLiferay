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
public class GoalMastersModel {
	
	private long goalId;
	private String goalName;
	private String goalDescription;
	private List<CustomGoalDetailsModel> goalMasterModel = new ArrayList<CustomGoalDetailsModel>();
	
	public long getGoalId() {
		return goalId;
	}
	public void setGoalId(long goalId) {
		this.goalId = goalId;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalDescription() {
		return goalDescription;
	}
	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}
	public List<CustomGoalDetailsModel> getGoalMasterModel() {
		return goalMasterModel;
	}
	public void setGoalMasterModel(List<CustomGoalDetailsModel> goalMasterModel) {
		this.goalMasterModel = goalMasterModel;
	}
	
	
}
