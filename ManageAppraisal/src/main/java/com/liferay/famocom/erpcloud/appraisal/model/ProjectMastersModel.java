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
public class ProjectMastersModel {
   
	private long projectId;
	private String projectName;
	private List<GoalMastersModel> goalMasterModel = new ArrayList<GoalMastersModel>();
	
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<GoalMastersModel> getGoalMasterModel() {
		return goalMasterModel;
	}
	public void setGoalMasterModel(List<GoalMastersModel> goalMasterModel) {
		this.goalMasterModel = goalMasterModel;
	}
	
}
