<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMasterMapping"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
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
<script
	src="/documents/20143/32425/jquery.min+%282%29.js/944309f5-712e-fdfa-4c5e-fc4ad142d71e"></script>
<liferay-ui:success key="add-success"
	message="Timesheet added successfully!"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Timesheet updated successfully!"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="Timesheet deleted successfully!"></liferay-ui:success>
<liferay-ui:error key="error" message="Duplicate project!"></liferay-ui:error>
<liferay-ui:error key="errorHours"
	message="Only 8 hours allowed per day!"></liferay-ui:error>
<liferay-ui:error key="errorDate"
	message="This Date is locked!"></liferay-ui:error>
<%
	boolean editURL = false;
	long timesheetId = ParamUtil.getLong(request, "timesheetId");
	System.out.println("timesheet_id in timesheet entry...."+timesheetId);
	String val = ParamUtil.getString(request, "selectProject", StringPool.BLANK);
	System.out.println("val...." + val);
	String calDate = ParamUtil.getString(request, "date", StringPool.BLANK);
	Date date1 = new Date();
	String actualDate = null;
	System.out.println("caldate in jsp....." + calDate);
	if(calDate != null){
	date1 = new SimpleDateFormat("dd/MM/yyyy").parse(calDate);
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMMM,yyyy");
	actualDate = formatter1.format(date1);  
	}
	System.out.println("caldate in date....." + date1);
	ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
	long userId = td.getUserId();
	Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
	long employeeId = emp.getEmployeeId();
	String projectName = ParamUtil.getString(renderRequest, "selectProject", StringPool.BLANK);
	String taskName = ParamUtil.getString(renderRequest, "selectTask", StringPool.BLANK);
	String hours = ParamUtil.getString(renderRequest, "hours", StringPool.BLANK);
	String workDescription = ParamUtil.getString(renderRequest, "workDescription", StringPool.BLANK);
	String entryDate = ParamUtil.getString(renderRequest, "entryDate", StringPool.BLANK);
	List<TimeSheetEntry> tsEntryList = new ArrayList<TimeSheetEntry>();
	tsEntryList = TimeSheetEntryLocalServiceUtil.getTimeSheetEntries(-1, -1);
	List<TimeSheetEntry> tsEntryTempList = new ArrayList<TimeSheetEntry>();
	TimeSheetEntry timeSheetEntry = null;
	//System.out.println("before if....");
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
	System.out.println("editURL...."+editURL);
	List<TaskMasterMapping> findTask = new ArrayList<>();

	try {
		if(timesheetId != 0){
		DynamicQuery dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(timeSheetEntry.getProjectId()));
		findTask = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("taskList in timesheet entry: " + findTask.size());
		}
	} catch (Exception e) {
	}
	List<AddTeamMember> atmList = new ArrayList<>();
	try {
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
		atmList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("atmList: " + atmList.size());
	} catch (Exception e) {
	}
	//System.out.println("outside try....");
	PortletURL calendarShowURL = renderResponse.createRenderURL();
	calendarShowURL.setWindowState(LiferayWindowState.NORMAL);
	calendarShowURL.setParameter("jspPage", "/META-INF/resources/calendarShow.jsp");

	PortletURL tsShowURL = renderResponse.createRenderURL();
	tsShowURL.setWindowState(LiferayWindowState.NORMAL);
	tsShowURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	DynamicQuery sumQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
			.add(RestrictionsFactoryUtil.eq("entryDate", date1))
			.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
			//.setProjection(ProjectionFactoryUtil.property("hours"));
			.setProjection(ProjectionFactoryUtil.sum("hours"));

	List<TimeSheetEntry> list = TimeSheetEntryLocalServiceUtil.dynamicQuery(sumQuery);

	/* DynamicQuery hrCountQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
			.add(RestrictionsFactoryUtil.eq("entryDate", date1))
			.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
			//.setProjection(ProjectionFactoryUtil.property("hours"));
			.setProjection(ProjectionFactoryUtil.property("hours"));

	List<TimeSheetEntry> countHr = TimeSheetEntryLocalServiceUtil.dynamicQuery(hrCountQuery); */

	double tempNoOfHrs = 0.0;
	double totalTempNoOfHrs = 0.0;
	String totalNoOfHrs = null;
	String noOfHrs = String.valueOf(list.get(0));
	if (Validator.isNotNull(noOfHrs)) {
		tempNoOfHrs = Double.valueOf(noOfHrs.trim());
	} else {
		tempNoOfHrs = 0.0;
	}
	double leftHr = 8.0 - tempNoOfHrs;

	/* for (int i = 0; i < countHr.size(); i++) {
		//totalNoOfHrs = String.valueOf(countHr.get(i));
		//System.out.println("totalNoOfHrs......" + totalNoOfHrs);
		if (countHr.size() > 1) {
			totalTempNoOfHrs = tempNoOfHrs + Double.valueOf(hours) - timeSheetEntry.getHours();
			System.out.println("totalTempNoOfHrs......" + totalTempNoOfHrs);
		} else {
			totalTempNoOfHrs = leftHr;
		}
	}
	double editLeftHr = 8.0 - totalTempNoOfHrs; */
%>
<%-- <aui:row>
	<aui:col span="9">
		<a class="btn btn-primary btn-default" name="calendarShow"
			type="submit" href="<%=calendarShowURL.toString()%>">Back</a>
	</aui:col>
	<aui:col span="3">
		<a class="btn btn-primary btn-default" name="timesheetList"
			type="submit" href="<%=tsShowURL.toString()%>">Timesheet List</a>
	</aui:col>
</aui:row> --%>
<%-- <portlet:renderURL var="normalState" windowState="<%=LiferayWindowState.EXCLUSIVE%>" /> --%>
<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Timesheet Entry" backLabel="Back" backURL="<%=calendarShowURL.toString()%>" />
	</aui:col>
</aui:row>
<aui:row>
<aui:col span="6">
<h4>Date:<%=" "+actualDate %></h4>

</aui:col>

</aui:row>
<portlet:actionURL name="timeSheetEntry" var="timeSheetEntryURL" />
<portlet:actionURL name="updateTimeSheetEntry"
	var="updateTimeSheetEntryURL" />
<aui:form name="timeSheetEntry"
	action="<%=editURL != true ? timeSheetEntryURL.toString() : updateTimeSheetEntryURL.toString()%>"
	method="post">
	<aui:input name="timesheetId" type="hidden" value="<%=timesheetId%>"></aui:input>
	<aui:row>
	<aui:col span="6">
	<aui:select name="selectProject" label="Select Project"
		onChange="changeProj(this.value);" required="true">
		<%if(atmList.size()==0){ %>
		<aui:validator name="required" errorMessage="No Project is assigned to this Employee"></aui:validator>
		<%} %>
		<option value="">Select Project</option>

		<%
			try {
						for (AddTeamMember obj : atmList) {
							ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(obj.getProjectId());
							if (timeSheetEntry != null) {
								if (obj.getProjectId() == timeSheetEntry.getProjectId()) {
		%>
		<option value="<%=pm.getProjectId()%>" selected><%=pm.getProjectName()%></option>

		<%
			} else {
		%>
		<option value="<%=pm.getProjectId()%>"><%=pm.getProjectName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=pm.getProjectId()%>"><%=pm.getProjectName()%></option>
		<%
			}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
		<%-- <option
			value="<%=timeSheetEntry != null ? timeSheetEntry.getProject_id() : ""%>"></option> --%>
	</aui:select>
	</aui:col>
	<aui:col span="6">
	<aui:select name="selectTask" label="Select Task" id="taskList" required="true">
		<%if(atmList.size()==0){ %>
			<aui:validator name="required" errorMessage="No Task is assigned to this Employee"></aui:validator>
		<%} %>
		<option value="">Select Task</option>
		<%
			try {
						for (TaskMasterMapping obj : findTask) {
							TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(obj.getTaskId());
							if (timeSheetEntry != null) {
								if (obj.getTaskId()== timeSheetEntry.getProjectTaskId()) {
		%>
		<option value="<%=tm.getTaskId()%>" selected><%=tm.getTaskName()%></option>
		<%
			} else {
		%>
		<option value="<%=tm.getTaskId()%>"><%=tm.getTaskName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=tm.getTaskId()%>"><%=tm.getTaskName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
	</aui:select>
	</aui:col>
	</aui:row>
	<aui:row>
	<aui:col span="6">
	<aui:input name="hours" type="text" label="Hours"
		placeholder="Hours"
		value="<%=timeSheetEntry != null ? timeSheetEntry.getHours() : ""%>">
		<aui:validator name="number"></aui:validator>
		<aui:validator name="min">1</aui:validator>
		<%if(editURL==true){ %>
		<aui:validator name="max">8</aui:validator>
		<%} else { %>
		<aui:validator name="max"><%=leftHr %></aui:validator>
		<%} %>
	</aui:input>
	<%-- <%
			if (Validator.isNotNull(timeSheetEntry)) {
		%> --%>
		<p>
			Total Hours left : <b style="color: #f48120;"><%=leftHr%></b>
		</p>
		</br>
		</aui:col>
		<%-- <%} %> --%>
	<aui:col span="6">
	<aui:input name="workDescription" type="textarea"
		label="Work Description" placeholder="Work Description"
		value="<%=timeSheetEntry != null ? timeSheetEntry.getWorkDescription() : ""%>" />
	</aui:col>
	</aui:row>
	<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
	<aui:input name="calDate" type="hidden" value="<%=calDate%>"></aui:input>
	<aui:button name="button" type="submit" value="submit"></aui:button>

</aui:form>
<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL tsEntryEditURL = renderResponse.createRenderURL();
	tsEntryEditURL.setWindowState(LiferayWindowState.NORMAL);
	tsEntryEditURL.setParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");

	PortletURL tsEntryDeleteURL = renderResponse.createActionURL();
	tsEntryDeleteURL.setParameter("javax.portlet.action", "deleteTimeSheetEntry");

	PortletURL projtaskURL = renderResponse.createRenderURL();
	projtaskURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	projtaskURL.setParameter("jspPage", "/META-INF/resources/fetchTaskList.jsp");

	if (date1 == null) {
		//System.out.println("inside if.....");
		tsEntryTempList = tsEntryList;
	} else {
		for (TimeSheetEntry ts : tsEntryList) {
			//System.out.println("inside for.....");
			if (date1.equals(ts.getEntryDate())) {
				try {
				//System.out.println("inside for-if.....");
				DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("entryDate", date1));
				dynamicQuery.add(criterion3);
				tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println("tsEntryTempList1....." + tsEntryTempList);
			} else {
				//System.out.println("inside for-if-else.....");
				/* DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("entry_date", date1);
				//System.out.println("criterion3........."+criterion3);
				dynamicQuery.add(criterion3);
				tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery); */
				//System.out.println("tsEntryTempList2....." + tsEntryTempList);
			}
		}
	}

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setWindowState(LiferayWindowState.NORMAL);
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");

	iteratorUrl.setParameter("projectId", projectName);
	iteratorUrl.setParameter("projectTaskId", taskName);
	iteratorUrl.setParameter("hours", hours);
	iteratorUrl.setParameter("workDescription", workDescription);
	iteratorUrl.setParameter("entryDate", entryDate);
	
%>

<%
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
	 
	 /* List<TimeSheetEntry> tsSortList = new ArrayList<>();
	 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
	 tsSortList = ListUtil.copy(tsEntryTempList);
	 
	 ListUtil.sort(tsSortList, orderByComparator); */
	 /* if (Validator.isNull(orderByCol)) {
		 orderByCol = "goal_name";
		} */
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByType="<%=orderByType %>" iteratorURL="<%=iteratorUrl %>">
	<liferay-ui:search-container-results>
		<%
			 results = tsEntryTempList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("results", results);
					
					/* List<TimeSheetEntry> usersPerPage = ListUtil.subList(tsEntryTempList, searchContainer.getStart(),searchContainer.getEnd());
				    int totalUsers =  TimeSheetEntryLocalServiceUtil.getTimeSheetEntriesCount();
				     
				    //From usersPerPage a new list sortableUsers is created. For sorting we will use this list
				    List<TimeSheetEntry> sortableUsers = new ArrayList<TimeSheetEntry>(usersPerPage);
				    if(Validator.isNotNull(orderByCol)){
				        //Pass the column name to BeanComparator to get comparator object
				        BeanComparator comparator = new BeanComparator(orderByCol);
				        if(sortingOrder.equalsIgnoreCase("asc")){
				             System.out.println("sortingOrder for asc..."+sortingOrder);
				            //It will sort in ascending order
				            Collections.sort(sortableUsers, comparator);
				        }
				        
				        if(sortingOrder.equalsIgnoreCase("desc")){
				        	System.out.println("sortingOrder for desc..."+sortingOrder);
				            //It will sort in descending order
				            Collections.sort(sortableUsers, comparator);
				            Collections.reverse(sortableUsers);
				        }
				 
				    }
				 
				    //sortableUsers list is sorted on the basis of condition. When page load it wont be sorted
				    //It will be sorted only when a header of coulmn is clicked for sorting
				    pageContext.setAttribute("results", sortableUsers);
				    pageContext.setAttribute("total", totalUsers); */
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
			ProjectMaster projMast = ProjectMasterLocalServiceUtil.getProjectMaster(tsEntry.getProjectId());
		%>
		<%-- <liferay-portlet:renderURL varImpl="projectURL">
			<portlet:param name="project_id"
				value="<%=String.valueOf(tsEntry.getProject_id())%>" />
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
			<portlet:param name="project_task_id"
				value="<%=String.valueOf(tsEntry.getProject_task_id())%>" />
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
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%
				tsEntryEditURL.setParameter("timesheetId", String.valueOf(tsEntry.getTimesheetId()));
				tsEntryEditURL.setParameter("date", calDate);
				tsEntryDeleteURL.setParameter("timesheetId1", String.valueOf(tsEntry.getTimesheetId()));
				tsEntryDeleteURL.setParameter("date", calDate);
				//tsEntryDeleteURL.setParameter("editURL", "false");
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=tsEntryEditURL.toString()%>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=tsEntryDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>

<script type="text/javascript">
	
	function changeProj(val){
		var url="<%=projtaskURL.toString()%>"
		$.ajax({
			url : url,
			data : {
				"<portlet:namespace/>val" : val
			},//person id to sent
			type : 'POST',
			success : function(data) {
				$("#<portlet:namespace/>taskList").html(data);
			},
		});
	}
</script>