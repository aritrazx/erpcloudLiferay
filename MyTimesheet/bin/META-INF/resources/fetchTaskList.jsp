<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMasterMapping"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
<%@page import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	boolean editURL = false;
	long timesheetId = ParamUtil.getLong(request, "timesheetId");
	TimeSheetEntry timeSheetEntry = null;
	System.out.println("timesheet_id...."+timesheetId);
	try {
		if (timesheetId != 0) {
			//System.out.println("inside if....");
			editURL = true;
			try {
				timeSheetEntry = TimeSheetEntryLocalServiceUtil.getTimeSheetEntry(timesheetId);
				System.out.println("timeSheetEntry...."+timeSheetEntry);
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	long val = ParamUtil.getLong(request, "val");
	System.out.println("val in java...." + val);

	List<TaskMasterMapping> taskList = new ArrayList<>();

	try {
		if(val!=0){
		DynamicQuery dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(val));
		taskList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("taskList: " + taskList.size());
		}
		} catch (Exception e) {
	}
%>
<aui:input name="timesheet_id" type="hidden" value="<%=timesheetId%>"></aui:input>
<%-- <%if(taskList.size()==0){ %>
<option value="">No Task Found</option>
<%} else { %> --%>
<option value="">Select Task</option>
<%-- <%} %> --%>
<%
	try {
		for (TaskMasterMapping obj : taskList) {
			TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(obj.getTaskId());
%>

<option value="<%=tm.getTaskId()%>"><%=tm.getTaskName()%></option>


<%
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>