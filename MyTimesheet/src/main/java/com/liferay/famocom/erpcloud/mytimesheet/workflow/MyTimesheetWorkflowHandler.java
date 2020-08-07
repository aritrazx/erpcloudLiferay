package com.liferay.famocom.erpcloud.mytimesheet.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

@Component(
		 property = {"model.class.name=com.liferay.famocom.erpcloud.model.TimeSheetEntry"},
		 service = WorkflowHandler.class
		)

public class MyTimesheetWorkflowHandler extends BaseWorkflowHandler<TimeSheetMaster> {
	private TimeSheetMasterLocalService timesheetService;
	   @Reference(unbind = "-")
	   protected void setTimeSheetMasterService(TimeSheetMasterLocalService timesheetService) {
	         this.timesheetService = timesheetService;
	    }

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return TimeSheetMaster.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		// TODO Auto-generated method stub
		return "MyTimesheet";
	}

	@Override
	public TimeSheetMaster updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		// TODO Auto-generated method stub
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	    long timesheetParentId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
	    ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
	    
	    System.out.println("status=>"+status);
	    TimeSheetMaster timeSheetMaster = timesheetService.updateStatus(userId, timesheetParentId, status, serviceContext);
	    System.out.println("timeSheetEntry in workflow handler---"+timeSheetMaster);
	    return timeSheetMaster;
	}

}
