package com.liferay.famocom.erpcloud.appraisal.model;

import java.util.ArrayList;
import java.util.List;

public class PerformanceMasterModel {
	
	private long performanceId;
	private String performanceHeading;
	private String performanceDescription;
	
	private List<PerformanceMasterModel> performanceMasterModel = new ArrayList<PerformanceMasterModel>();
	
	public long getPerformanceId() {
		return performanceId;
	}
	public void setPerformanceId(long performanceId) {
		this.performanceId = performanceId;
	}
	public String getPerformanceHeading() {
		return performanceHeading;
	}
	public void setPerformanceHeading(String performanceHeading) {
		this.performanceHeading = performanceHeading;
	}
	public String getPerformanceDescription() {
		return performanceDescription;
	}
	public void setPerformanceDescription(String performanceDescription) {
		this.performanceDescription = performanceDescription;
	}
	public List<PerformanceMasterModel> getPerformanceMasterModel() {
		return performanceMasterModel;
	}
	public void setPerformanceMasterModel(List<PerformanceMasterModel> performanceMasterModel) {
		this.performanceMasterModel = performanceMasterModel;
	}
	

}
