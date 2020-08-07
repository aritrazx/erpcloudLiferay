package com.liferay.famocom.erpcloud.mytimesheet.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

public class MyTimesheetAssetRenderer extends BaseJSPAssetRenderer<TimeSheetMaster> {
	private final TimeSheetMaster timeSheetMaster;
	private final ResourceBundleLoader resourceBundleLoader;

	public MyTimesheetAssetRenderer(TimeSheetMaster timeSheetMaster, ResourceBundleLoader resourceBundleLoader) {
	      this.timeSheetMaster = timeSheetMaster;
	      this.resourceBundleLoader = resourceBundleLoader;
	 }
	@Override
	public TimeSheetMaster getAssetObject() {
		// TODO Auto-generated method stub
		return timeSheetMaster;
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return timeSheetMaster.getGroupId();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return timeSheetMaster.getStatusByUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return timeSheetMaster.getStatusByUserName();
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return timeSheetMaster.getStatusByUserUuid();
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return TimeSheetMaster.class.getName();
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return timeSheetMaster.getTimesheetParentId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		return timeSheetMaster.getStatusByUserName()+",added Timesheet from:"+timeSheetMaster.getFromDate()+" to:"+timeSheetMaster.getToDate();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return timeSheetMaster.getStatusByUserName();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		// TODO Auto-generated method stub
		return "/view.jsp";
	}

}
