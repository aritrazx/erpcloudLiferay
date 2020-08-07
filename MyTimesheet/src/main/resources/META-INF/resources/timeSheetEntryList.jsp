<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
String val = ParamUtil.getString(request, "search", StringPool.BLANK);
System.out.println("val....." + val);
/* String listValue = ParamUtil.getString(request, "list");
String val = ParamUtil.getString(request, "search", StringPool.BLANK);
System.out.println("val....." + val);
System.out.println("listValue" + listValue);
System.out.println("before date.....");
Date date = new Date();
System.out.println("after date.....");
String monthCon = null;
String str = null;
try{
	if (listValue != null) {
		date = new SimpleDateFormat("MMM").parse(listValue);
	}
	System.out.println("after simple date.....");
	Calendar cal2 = Calendar.getInstance();
	cal2.setTime(date);
	int month = cal2.get(Calendar.MONTH) + 1;
	if (month < 10) {
		monthCon = '0' + String.valueOf(month);
	} else {
		monthCon = String.valueOf(month);
	}
	

	str = new String(listValue);
} catch(Exception e){
	
}
	String year[] = str.split(",");
	System.out.println("year[]" + year[1]);
	

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); */

%>
<%
List<TimeSheetEntry> tsEntryList = new ArrayList<>();
List<TimeSheetEntry> tsEntryTempList = new ArrayList<>();
List<TimeSheetEntry> tsList = new ArrayList<>();
List<TimeSheetEntry> tsMonthWiseList = new ArrayList<>();
List<TimeSheetEntry> pnList = new ArrayList<>();
List<TimeSheetEntry> ptlist = new ArrayList<>();


PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setWindowState(LiferayWindowState.NORMAL);
searchURL.setParameter("jspPage", "/META-INF/resources/timeSheetEntryList.jsp");

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setWindowState(LiferayWindowState.NORMAL);
iteratorURL.setParameter("jspPage", "/META-INF/resources/timeSheetEntryList.jsp");


ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
long userId = td.getUserId();
Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
long employeeId = emp.getEmployeeId();

Calendar cal1 = new GregorianCalendar();
cal1.set(Calendar.HOUR_OF_DAY, 0);
cal1.set(Calendar.MINUTE, 0);
cal1.set(Calendar.SECOND, 0);
cal1.set(Calendar.MILLISECOND, 0);
cal1.set(Calendar.DAY_OF_MONTH, 1);

System.out.println("1st day of month...."+cal1.getTime());

Calendar cal = new GregorianCalendar();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
cal.set(Calendar.DAY_OF_MONTH, 30);

System.out.println("last day of month...."+cal.getTime());

DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
		RestrictionsFactoryUtil.between("entry_date", cal1.getTime(), cal.getTime())); */
dynamicQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
dynamicQuery.add(criterion3);
tsEntryList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);

	if (null == val || val.isEmpty()) {
		tsEntryTempList = tsEntryList;
	} else {
		for (TimeSheetEntry ts : tsEntryList) {
	//System.out.println("for.....");
	ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(ts.getProjectId());
	if (val.equals(pm.getProjectName())) {
		DynamicQuery projQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("projectId")
						.in(ProjectMasterLocalServiceUtil.dynamicQuery()
								.add(PropertyFactoryUtil.forName("projectName").eq(val)).setProjection(
										ProjectionFactoryUtil.property("projectId"))))
				.add(RestrictionsFactoryUtil.eq("employeeId", employeeId));
		projQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
		tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(projQuery);
		//System.out.println("tsEntryTempList..."+tsEntryTempList);
		//System.out.println("pm....." +pm);
	} else {
		DynamicQuery joinQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("projectId")
						.in(ProjectMasterLocalServiceUtil.dynamicQuery()
								.add(RestrictionsFactoryUtil.like("projectName",
										new StringBuilder("%").append(val).append("%").toString()))
								.setProjection(ProjectionFactoryUtil.property("projectId"))))
				.add(RestrictionsFactoryUtil.eq("employeeId", employeeId));
		joinQuery.addOrder(OrderFactoryUtil.desc("entryDate"));
		tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(joinQuery);
		//System.out.println("tsEntryTempList..."+tsEntryTempList);

	}
		}
	}
	
	String listValue = ParamUtil.getString(request, "list");
	String monthValue = request.getParameter("list");
	request.getSession().setAttribute("monthValue", monthValue);
	String page1Value = (String)request.getSession().getAttribute("monthValue");
	/* String val = ParamUtil.getString(request, "search", StringPool.BLANK);
	System.out.println("val....." + val); */
	System.out.println("listValue..." + listValue);
	System.out.println("monthValue..." + monthValue);
	System.out.println("page1Value..." + page1Value);
	System.out.println("before date.....");
	try {
		if (Validator.isNotNull(listValue)) {
			Date date = new Date();
			System.out.println("after date.....");
			String monthCon = null;
			String str = null;

			date = new SimpleDateFormat("MMM").parse(listValue); 

			System.out.println("after simple date.....");
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date);
			int month = cal2.get(Calendar.MONTH) + 1;
			if (month < 10) {
				monthCon = '0' + String.valueOf(month);
			} else {
				monthCon = String.valueOf(month);
			}

			str = new String(listValue);

			String year[] = str.split(",");
			System.out.println("year[]" + year[1]);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			int j = 0;

			for (TimeSheetEntry tsht : tsEntryTempList) {
				employeeId = tsEntryTempList.get(j).getEmployeeId();

				System.out.println("Date:" + tsEntryTempList.get(j).getEntryDate());
				String attDate = sdf.format(tsEntryTempList.get(j).getEntryDate());
				String[] date1 = attDate.split("-");
				String attMonth = date1[1];
				String attYear = date1[0];

				//String attMonth=splitMonth[2];
				System.out.println("attMonth:---" + attMonth + "and attYear:" + attYear);

				if (attYear.equalsIgnoreCase(year[1]) && attMonth.equalsIgnoreCase(monthCon)
						&& employeeId == emp.getEmployeeId()) {
					//System.out.println("attendances:--" + attendances.size()+ "attendances value" + attendances);
					tsList.add(tsEntryTempList.get(j));
				}
				j++;
			}

		} else {
			DynamicQuery sortQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("employeeId", employeeId);
			/* criterion = RestrictionsFactoryUtil.and(criterion3,
					RestrictionsFactoryUtil.between("entry_date", cal1.getTime(), cal.getTime())); */
			//sortQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
			sortQuery.add(criterion);
			tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(sortQuery);
		}
	} catch (Exception e) {
		e.printStackTrace();

	}

	/* if (null == val || val.isEmpty()) {
		tsMonthWiseList = tsList;
	} else {
		for (TimeSheetEntry ts : tsList) {
			//System.out.println("for.....");
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(ts.getProject_id());
			if (val.equals(pm.getProjectname())) {
				DynamicQuery projQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("project_id")
								.in(ProjectMasterLocalServiceUtil.dynamicQuery()
										.add(PropertyFactoryUtil.forName("projectname").eq(val)).setProjection(
												ProjectionFactoryUtil.property("project_id"))));
				projQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
				tsMonthWiseList = TimeSheetEntryLocalServiceUtil.dynamicQuery(projQuery);
				//System.out.println("pm....." +pm);
			} else {
				DynamicQuery joinQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("project_id")
								.in(ProjectMasterLocalServiceUtil.dynamicQuery()
										.add(RestrictionsFactoryUtil.like("projectname",
												new StringBuilder("%").append(val).append("%").toString()))
										.setProjection(ProjectionFactoryUtil.property("project_id"))));
				joinQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
				tsMonthWiseList = TimeSheetEntryLocalServiceUtil.dynamicQuery(joinQuery);
	
			}
		}
	} */

	System.out.println("tsList..." + tsList);
	System.out.println("tsEntryTempList..." + tsEntryTempList);
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
	 /* if (Validator.isNull(orderByCol)) {
		 orderByCol = "goal_name";
		} */
	 System.out.println("orderByCol..." + orderByCol);
	 System.out.println("orderByType..." + orderByType); 
	 List<TimeSheetEntry> tsSortList = new ArrayList<>();
	 //OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
	if (null == val || val.isEmpty()) {
		tsSortList = ListUtil.copy(tsList);
	} else {
		tsSortList = ListUtil.copy(tsEntryTempList);
	}
	//ListUtil.sort(tsSortList, orderByComparator);
%>

 
 <%-- <%
	//String navigation = ParamUtil.getString(request, "navigation", "active");
	String orderByCol = ParamUtil.getString(request, "orderByCol", "projectname");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
%>

<liferay-portlet:renderURL varImpl="viewPageURL">
	<portlet:param name="mvcPath" value="/timeSheetEntryList.jsp" />
	<portlet:param name="displayStyle" value="<%= displayStyle %>" />
	<portlet:param name="orderByCol" value="<%=orderByCol%>" />
	<portlet:param name="orderByType" value="<%=orderByType%>" />
</liferay-portlet:renderURL>

<%
	//System.out.println("navigation... " + navigation);
	System.out.println("orderByCol... " + orderByCol);
	System.out.println("orderByType... " + orderByType);
	if (Validator.isNotNull(listValue)) {
		tsMonthWiseList = tsList;
	} else {
		for (TimeSheetEntry ts : tsList) {
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(ts.getProject_id());
			if (orderByCol.equals("projectname")) {
				DynamicQuery pmQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				if (orderByType.equals("asc")) {
					pmQuery.addOrder(OrderFactoryUtil.asc(pm.getProjectname()));
				} else if (orderByType.equals("desc")) {
					pmQuery.addOrder(OrderFactoryUtil.desc(pm.getProjectname()));
				}

				tsMonthWiseList = TimeSheetEntryLocalServiceUtil.dynamicQuery(pmQuery);
			}
		}
	}
%> --%>


<nav class="collapse-basic-search navbar navbar-default"
	data-toggle="collapsible-search">
	<div class="navbar-header navbar-header-right">
		<aui:form cssClass="basic-search input-group" name="searchProjectName"
			action="<%=searchURL.toString()%>">
			<div class="input-group-input">
				<div class="basic-search-slider">
					<button class="basic-search-close btn btn-default" type="button">
						<span aria-hidden="true" class="icon-remove"></span>
					</button>
					<input name="<portlet:namespace/>search" class="form-control"
						value="<%=val%>" placeholder=" Search" type="text" />
				</div>
			</div>
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<span aria-hidden="true" class="icon-search"></span>
				</button>
			</div>
		</aui:form>
	</div>

</nav>

<%-- <liferay-frontend:management-bar searchContainerId="pmContainer">
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-sort orderByCol="<%=orderByCol%>"
			orderByType="<%=orderByType%>"
			orderColumns='<%=new String[] { "projectname" }%>'
			portletURL="<%=viewPageURL%>" />
	</liferay-frontend:management-bar-filters>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%=new String[] { "list" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>"
			selectedDisplayStyle="" />
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href=""
			iconCssClass="icon-undo" id="restoreUsers" label="restore" />
		<liferay-frontend:management-bar-button href="" icon="trash"
			id="deleteUsers" label="" />

	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar> --%>

<liferay-ui:search-container delta="75"
	emptyResultsMessage="No record found."
	orderByType="<%=orderByType%>" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
		if (null == val || val.isEmpty()) {
			results = tsSortList;
		} else {
			results = tsEntryTempList;
		}
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("results", results);
					
					/* List<TimeSheetEntry> usersPerPage = null;
					if (null == val || val.isEmpty()){
						usersPerPage = ListUtil.subList(tsList, searchContainer.getStart(),searchContainer.getEnd());
					} else {
						usersPerPage = ListUtil.subList(tsEntryTempList, searchContainer.getStart(),searchContainer.getEnd());
					}
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
			<portlet:param name="mvcPath"
				value="/resources/META-INF/resources/timeSheetEntryList.jsp" />
			<portlet:param name="project_id"
				value="<%=String.valueOf(projMast.getProjectname())%>" />
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-row-parameter name="projectURL"
			value="<%=projectURL.toString()%>" /> --%>

		<liferay-ui:search-container-column-text
			name="Project Name" orderableProperty="project_id">
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

		<liferay-ui:search-container-column-text
			name="Task Name" orderableProperty="project_task_id">
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