<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMasterMapping"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
boolean isViewPermission = false;
try {
	isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
			"TimeSheetReport", "TIMESHEET_REPORT_VIEW");
	System.out.print("isViewPermission " + isViewPermission);
} catch (Exception exception) {
	exception.printStackTrace();
}
if (isViewPermission) {

%>
<script
	src="/documents/20143/0/jquery.min.js/127201bc-1b18-fed4-0b92-d37c7bba629e"></script>

<%
	String selectEmployee = ParamUtil.getString(renderRequest, "selectEmployee", StringPool.BLANK);
	String selectProject = ParamUtil.getString(renderRequest, "selectProject", StringPool.BLANK);
	String selectTask = ParamUtil.getString(renderRequest, "selectTask", StringPool.BLANK);
	String fromDate = ParamUtil.getString(renderRequest, "fromDate", StringPool.BLANK);
	String toDate = ParamUtil.getString(renderRequest, "toDate", StringPool.BLANK);
	long timesheetId = ParamUtil.getLong(request, "timesheetId");
	TimeSheetEntry timeSheetEntry = null;
	//System.out.println("before if....");
	try {
		if (timesheetId != 0) {
	//System.out.println("inside if....");
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
	Date tempFromDate = new Date();
	if (Validator.isNotNull(fromDate)) {
		tempFromDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
	}
	Date tempToDate = new Date();
	if (Validator.isNotNull(toDate)) {
		tempToDate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
	}
	System.out.println("selectEmployee..." + selectEmployee);
	System.out.println("selectProject..." + selectProject);
	System.out.println("selectTask..." + selectTask);
	System.out.println("fromDate..." + fromDate);
	System.out.println("toDate..." + toDate);

	List<TimeSheetEntry> empTimesheet = new ArrayList<>();
	List<TimeSheetEntry> allTimesheet = new ArrayList<>();
	PortletURL iteratorURL = renderResponse.createRenderURL();
	//allTimesheet = null;
	/* allTimesheet = TimeSheetEntryLocalServiceUtil.getTimeSheetEntries(-1, -1);
	DynamicQuery allListQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
	allListQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
	allTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(allListQuery); */
	/* if (Validator.isNotNull(selectEmployee) && Validator.isNull(selectProject)) {
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("employee_id", Long.parseLong(selectEmployee));
		criterion3 = RestrictionsFactoryUtil.and(criterion3,
				RestrictionsFactoryUtil.between("entry_date", tempFromDate, tempToDate));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
		dynamicQuery.add(criterion3);
		empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
	} else if (Validator.isNotNull(selectEmployee) && Validator.isNull(fromDate) || Validator.isNull(toDate)) {
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("employee_id", Long.parseLong(selectEmployee));
		criterion3 = RestrictionsFactoryUtil.and(criterion3,
				RestrictionsFactoryUtil.eq("project_id", Long.parseLong(selectProject)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
		dynamicQuery.add(criterion3);
		empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
	} else {
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("employee_id", Long.parseLong(selectEmployee));
		criterion3 = RestrictionsFactoryUtil.and(criterion3,
				RestrictionsFactoryUtil.eq("project_id", Long.parseLong(selectProject)));
		criterion3 = RestrictionsFactoryUtil.and(criterion3,
				RestrictionsFactoryUtil.between("entry_date", tempFromDate, tempToDate));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
		dynamicQuery.add(criterion3);
		empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
	
	}
	
	if (Validator.isNotNull(selectEmployee) && Validator.isNull(selectProject) && Validator.isNull(fromDate)
			&& Validator.isNull(toDate)) {
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("employee_id", Long.parseLong(selectEmployee));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
		dynamicQuery.add(criterion3);
		empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
	} */

	if (Validator.isNull(selectEmployee)) {
		if (Validator.isNull(selectProject)) {
			DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.between("entryDate", tempFromDate, tempToDate);
			dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
			dynamicQuery.add(criterion3);
			empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
			iteratorURL.setParameter("fromDate", fromDate);
			iteratorURL.setParameter("toDate", toDate);
		} else {
			if (Validator.isNull(selectTask)) {
				DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("projectId", Long.parseLong(selectProject));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.between("entryDate", tempFromDate, tempToDate));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
				dynamicQuery.add(criterion3);
				empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
				iteratorURL.setParameter("selectProject", selectProject);
				iteratorURL.setParameter("fromDate", fromDate);
				iteratorURL.setParameter("toDate", toDate);
			} else {
				DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("projectId", Long.parseLong(selectProject));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("projectTaskId", Long.parseLong(selectTask)));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.between("entryDate", tempFromDate, tempToDate));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
				dynamicQuery.add(criterion3);
				empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
				iteratorURL.setParameter("selectProject", selectProject);
				iteratorURL.setParameter("selectTask", selectTask);
				iteratorURL.setParameter("fromDate", fromDate);
				iteratorURL.setParameter("toDate", toDate);
			}
		}
	} else {
		if (Validator.isNull(selectProject)) {
			DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("employeeId", Long.parseLong(selectEmployee));
			criterion3 = RestrictionsFactoryUtil.and(criterion3,
					RestrictionsFactoryUtil.between("entryDate", tempFromDate, tempToDate));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
			dynamicQuery.add(criterion3);
			empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
			iteratorURL.setParameter("selectEmployee", selectEmployee);
			iteratorURL.setParameter("fromDate", fromDate);
			iteratorURL.setParameter("toDate", toDate);
		} else {
			if (Validator.isNull(selectTask)) {
				DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("employeeId", Long.parseLong(selectEmployee));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("projectId", Long.parseLong(selectProject)));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.between("entryDate", tempFromDate, tempToDate));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
				dynamicQuery.add(criterion3);
				empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
				iteratorURL.setParameter("selectProject", selectProject);
				iteratorURL.setParameter("selectEmployee", selectEmployee);
				iteratorURL.setParameter("fromDate", fromDate);
				iteratorURL.setParameter("toDate", toDate);
			} else {
				DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("employeeId", Long.parseLong(selectEmployee));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("projectId", Long.parseLong(selectProject)));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("projectTaskId", Long.parseLong(selectTask)));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.between("entryDate", tempFromDate, tempToDate));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
				dynamicQuery.add(criterion3);
				empTimesheet = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
				iteratorURL.setParameter("selectProject", selectProject);
				iteratorURL.setParameter("selectEmployee", selectEmployee);
				iteratorURL.setParameter("selectTask", selectTask);
				iteratorURL.setParameter("fromDate", fromDate);
				iteratorURL.setParameter("toDate", toDate);
			}
		}
	}
%>

<%
	PortletURL listShowURL = renderResponse.createRenderURL();
	listShowURL.setWindowState(LiferayWindowState.NORMAL);
	listShowURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL projListURL = renderResponse.createRenderURL();
	projListURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	projListURL.setParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");

	PortletURL taskListURL = renderResponse.createRenderURL();
	taskListURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	if (!selectTask.isEmpty()) {
		taskListURL.setParameter("projectTaskId", selectTask);
	}
	taskListURL.setParameter("jspPage", "/META-INF/resources/fetchTaskList.jsp");

	String val = ParamUtil.getString(request, "selectEmployee", StringPool.BLANK);
	System.out.println("val..." + val);

	String valProj = ParamUtil.getString(request, "selectProject", StringPool.BLANK);
	System.out.println("valProj..." + valProj);

	iteratorURL.setWindowState(LiferayWindowState.NORMAL);
	iteratorURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("asc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	if (Validator.isNull(orderByType)) {
		orderByType = "asc";
	}
	/* if (Validator.isNull(orderByCol)) {
	 orderByCol = "goal_name";
	} */
	System.out.println("orderByCol..." + orderByCol);
	System.out.println("orderByType..." + orderByType);

	List<AddTeamMember> atmList = new ArrayList<>();
	try {
		if (Validator.isNotNull(val)) {
			DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(Long.parseLong(val)));
			atmList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("atmList: " + atmList.size());
		}
	} catch (Exception e) {
	}

	List<TaskMasterMapping> projTaskList = new ArrayList<>();

	try {
		if (atmList.size() != 0) {
			for (int i = 0; i < atmList.size(); i++) {
				DynamicQuery dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(atmList.get(i).getProjectId()));
				projTaskList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("projTaskList: " + projTaskList.size());
			}
		}
	} catch (Exception e) {
	}
%>

<%
	Date defaultDate = new Date();
	Date startDate, endDate;
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
	startDate = defaultDate;

	endDate = defaultDate;
%>

<portlet:actionURL name="employeeTimesheet" var="employeeTimesheetURL" />
<aui:form name="employeeTimesheet" action="<%=employeeTimesheetURL.toString()%>"
	method="post">
<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
<aui:input name="valProj" type="hidden" value="<%=valProj%>"></aui:input>
<aui:input name="timesheetId" type="hidden" value="<%=timesheetId%>"></aui:input>
<aui:row>
<aui:col span="3">
<aui:select name="selectEmployee" label="Select Employee" onChange="changeEmp(this.value);">
	<option value="">All Employee</option>
	<%
		try {
				List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
				for (Employee obj : empList) {
					String isSelect = null;
					if(!selectEmployee.isEmpty()){
					if(obj.getEmployeeId()==Long.parseLong(selectEmployee)){
					isSelect="selected";
					}
					}
	%>
	<option value="<%=obj.getEmployeeId()%>" <%=isSelect %>><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
		<%=obj.getLastName()%></option>

	<%
		}
			} catch (Exception e) {
				e.printStackTrace();
			}
	%>
</aui:select>
</aui:col>
<aui:col span="2">
<aui:select id="projectList" name="selectProject" label="Select Project" onChange="changeProj(this.value);">
	<option value="0">All Project</option>
	<%
		try {
			List<ProjectMaster> pmList = ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
				for (ProjectMaster obj : pmList) {
					String isSelect = null;
					if(!selectProject.isEmpty()){
					if(obj.getProjectId()==Long.parseLong(selectProject)){
					isSelect="selected";
					}
					}
					
	%>
	<option value="<%=obj.getProjectId()%>" <%=isSelect %>><%=obj.getProjectName()%></option>
	<%
					
		}
			} catch (Exception e) {
				e.printStackTrace();
			}
	%>
</aui:select>
</aui:col>
<aui:col span="2">
<aui:select id="taskList" name="selectTask" label="Select Task">
	<option value="">Select Task</option>
	<%
	if(!selectTask.isEmpty()){
		List<TaskMasterMapping> taskList = TaskMasterMappingLocalServiceUtil.getTaskMasterMappings(-1, -1);
		DynamicQuery dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(Long.parseLong(selectProject)));
		taskList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
	try {
		for (TaskMasterMapping obj : taskList) {
			String isSelect = null;
			TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(obj.getTaskId());
			if(obj.getTaskId()==Long.parseLong(selectTask)){
			isSelect="selected";
			}
%>

<option value="<%=tm.getTaskId()%>" <%=isSelect %>><%=tm.getTaskName()%></option>


<%
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
%>
</aui:select>
		</aui:col>
<aui:col span="2">
<aui:input id="txtFromDate_id" name="fromDate" type="text"
	label="From Date" placeholder="From Date" readonly="readonly" value="<%=formatter1.format(startDate) %>">
	<aui:validator name="required"></aui:validator>
</aui:input>
		</aui:col>
<aui:col span="2" id="endDateShown">
<aui:input id="txtToDate_id" name="toDate" type="text"
		label="To Date" placeholder="To Date" readonly="readonly" value="<%=formatter1.format(endDate) %>">
<aui:validator name="required"></aui:validator>
</aui:input>
</aui:col>
<aui:col span="1">
<div class="col-md-2 " style="padding-top: 20px;">
<aui:button name="button" type="submit" value="View"></aui:button>
</div>
</aui:col>
</aui:row>
</aui:form>

<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found."
	orderByType="<%=orderByType%>" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
		if (Validator.isNull(selectEmployee) && Validator.isNull(selectProject) && Validator.isNull(selectTask)
				&& Validator.isNull(fromDate) && Validator.isNull(toDate)) {
			results = allTimesheet;
		} else {
			results = empTimesheet;
		}
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("results", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.TimeSheetEntry"
		modelVar="tsEntry">
		<%
			Date addDate = tsEntry.getEntryDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate = formatter.format(addDate);
		%>

		<liferay-ui:search-container-column-text name="Date"
			orderableProperty="entry_date">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(tsEntry.getEmployeeId());
		%>
		<liferay-ui:search-container-column-text name="Employee Name"
			 orderableProperty="employee_id">
			<%=emp.getFirstName()%>
			<%=emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectMaster projMast = ProjectMasterLocalServiceUtil.getProjectMaster(tsEntry.getProjectId());
		%>
		<%-- <liferay-portlet:renderURL varImpl="projectURL">
			<portlet:param name="mvcPath"
				value="/resources/META-INF/resources/timeSheetEntryList.jsp" />
			<portlet:param name="project_id"
				value="<%=String.valueOf(projMast.getProjectname())%>" />
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-row-parameter name="projectURL"
			value="<%=projectURL.toString()%>" /> --%>

		<liferay-ui:search-container-column-text name="Project Name"
			 orderableProperty="project_id">
			<%=projMast.getProjectName()%>
		</liferay-ui:search-container-column-text>
		<%
			TaskMaster projTask = TaskMasterLocalServiceUtil.getTaskMaster(tsEntry.getProjectTaskId());
		%>
		<%-- <liferay-portlet:renderURL varImpl="projectTaskURL">
			<portlet:param name="mvcPath"
				value="/resources/META-INF/resources/timeSheetEntryList.jsp" />
			<portlet:param name="project_task_id"
				value="<%=String.valueOf(projTask.getTaskname())%>" />
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-row-parameter name="projectTaskURL"
			value="<%=projectTaskURL.toString()%>" /> --%>

		<liferay-ui:search-container-column-text name="Task Name"
			 orderableProperty="project_task_id">
			<%=projTask.getTaskName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Description"
			 orderableProperty="work_description">
			<%=tsEntry.getWorkDescription()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Hours"
			orderableProperty="hours">
			<%=tsEntry.getHours()%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				tsEntryEditURL.setParameter("timesheet_id", String.valueOf(tsEntry.getTimesheet_id()));
							tsEntryEditURL.setParameter("editURL", String.valueOf(editURL));
							tsEntryEditURL.setParameter("date", calDate);
							tsEntryDeleteURL.setParameter("timesheet_id", String.valueOf(tsEntry.getTimesheet_id()));
							tsEntryDeleteURL.setParameter("date", calDate);
							//System.out.println("timesheet_id...."+timesheet_id);
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=tsEntryEditURL.toString()%>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=tsEntryDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text> --%>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>

<!-- <script>
AUI().use('aui-datepicker', function(A) {
	var dfg = new A.DatePicker({
		trigger : '#<portlet:namespace />txtFromDate_id',
		mask : '%d/%m/%Y',

		popover : {
			zIndex : 1000
		},
		calendar : {
			maximumDate : new Date()
		}
	});
});
	
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate_id',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {
				maximumDate : new Date()
			}
		});
	});
</script> -->

<script type="text/javascript">
    // This function allows me to turn the end date on and off 
    // based on whether the user clicks the checkbox
    function toggleEndDate() {
        if (document.getElementById('endDateToggle').checked) {
            document.getElementById('endDateShown').style.display = 'none';
            document.getElementById('<portlet:namespace/>txtToDate_id').disabled = 
                "true";
        } else {
            document.getElementById('endDateShown').style.display = 'block';
            // for some reason you shouldn't set disabled to false, 
            // but to an empty string instead...
            document.getElementById('<portlet:namespace/>txtToDate_id').disabled = "";
        }
    }
</script>

<aui:script>
    AUI().use(
        'aui-datepicker', 
        'datatype-date', 
        'datatype-date-math', 
        'datatype-date-parse',
        function(A) {
            var toDatePicker;
            var fromDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace />txtFromDate_id',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                },
                on: {
                    selectionChange: function(event) {
                        if (event.newSelection[0]) {
                            var oldToValue = A.Date.parse("%d-%m-%Y", 
                                document.getElementById(
                                    "<portlet:namespace />txtToDate_id").value);
                            toDatePicker.getCalendar().set('minimumDate', 
                                event.newSelection[0]);
                            if (A.Date.isGreater(event.newSelection[0], 
                                    oldToValue)) {
                                document.getElementById(
                                    "<portlet:namespace />txtToDate_id").value = 
                                    A.Date.format(event.newSelection[0], 
                                        {format: "%d-%m-%Y"});
                            }
                        }
                    }
                },
                calendar: {
                    maximumDate: new Date()
                }
            });

            toDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace />txtToDate_id',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                },
                calendar: {
                	maximumDate: new Date()
                }
            });
        }
    );
  </aui:script>


<script type="text/javascript">
/* $(document).ready(function() {
	
	var projId =parseInt($("#<portlet:namespace/>projectList").val());
	console.log("projId---"+projId);
	changeProj(projId);
}); */
	
	function changeEmp(val){
		var url="<%=projListURL.toString()%>"
		//console.log(val);
		$.ajax({
			url : url,
			data : {
				"<portlet:namespace/>val" : val
			},
			type : 'POST',
			success : function(data) {
				//console.log("data.."+data);
				$("#<portlet:namespace/>projectList").html(data);
			},
		});
	}
	
	function changeProj(valProj){
		var url="<%=taskListURL.toString()%>"
		$.ajax({
			url : url,
			data : {
				"<portlet:namespace/>valProj" : valProj
			},//person id to sent
			type : 'POST',
			success : function(data) {
				$("#<portlet:namespace/>taskList").html(data);
			},
		});
	}
</script>

<%
 }else{
%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Timesheet Report</label>
</div>
<%    
}
%>