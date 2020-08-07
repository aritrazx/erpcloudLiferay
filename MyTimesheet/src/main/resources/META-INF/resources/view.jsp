<%@page import="com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CompanyPolicy"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
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
<h1>My Timesheet</h1>
<%-- <%
List<TimeSheetEntry> tsEntryList = new ArrayList<>();
List<TimeSheetEntry> tsEntryTempList = new ArrayList<>();
String val = ParamUtil.getString(request, "search", StringPool.BLANK);
System.out.println("val....." + val);
PortletURL calendarShowURL = renderResponse.createRenderURL();
calendarShowURL.setWindowState(LiferayWindowState.NORMAL);
calendarShowURL.setParameter("jspPage", "/META-INF/resources/calendarShow.jsp");

PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

PortletURL timesheetListURL = renderResponse.createRenderURL();
timesheetListURL.setWindowState(LiferayWindowState.EXCLUSIVE);
timesheetListURL.setParameter("jspPage", "/META-INF/resources/timeSheetEntryList.jsp");

ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
long userId = td.getUserId();
Employee emp = EmployeeLocalServiceUtil.findByUserId(userId);
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
criterion3 = RestrictionsFactoryUtil.eq("employee_id", employeeId);
criterion3 = RestrictionsFactoryUtil.and(criterion3,
		RestrictionsFactoryUtil.between("entry_date", cal1.getTime(), cal.getTime()));
dynamicQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
dynamicQuery.add(criterion3);
tsEntryList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);

	if (null == val || val.isEmpty()) {
		tsEntryTempList = tsEntryList;
	} else {
		for (TimeSheetEntry ts : tsEntryList) {
			//System.out.println("for.....");
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(ts.getProject_id());
			if (val.equals(pm.getProjectname())) {
				DynamicQuery projQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("project_id")
								.in(ProjectMasterLocalServiceUtil.dynamicQuery()
										.add(PropertyFactoryUtil.forName("projectname").eq(val)).setProjection(
												ProjectionFactoryUtil.property("project_id"))));
				projQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
				tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(projQuery);
				//System.out.println("pm....." +pm);
			} else {
				DynamicQuery joinQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
						.add(PropertyFactoryUtil.forName("project_id")
								.in(ProjectMasterLocalServiceUtil.dynamicQuery()
										.add(RestrictionsFactoryUtil.like("projectname",
												new StringBuilder("%").append(val).append("%").toString()))
										.setProjection(ProjectionFactoryUtil.property("project_id"))));
				joinQuery.addOrder(OrderFactoryUtil.desc("entry_date"));
				tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(joinQuery);

			}
		}
	}
%> --%>

<%
PortletURL timesheetListURL = renderResponse.createRenderURL();
timesheetListURL.setWindowState(LiferayWindowState.EXCLUSIVE);
timesheetListURL.setParameter("jspPage", "/META-INF/resources/timeSheetEntryList.jsp");

PortletURL calendarShowURL = renderResponse.createRenderURL();
calendarShowURL.setWindowState(LiferayWindowState.NORMAL);
calendarShowURL.setParameter("jspPage", "/META-INF/resources/calendarShow.jsp");

PortletURL policyURL = renderResponse.createRenderURL();
policyURL.setWindowState(LiferayWindowState.NORMAL);
policyURL.setParameter("jspPage", "/META-INF/resources/companyPolicy.jsp");

PortletURL dateRangeURL = renderResponse.createRenderURL();
dateRangeURL.setWindowState(LiferayWindowState.NORMAL);
dateRangeURL.setParameter("jspPage", "/META-INF/resources/dateRangePage.jsp");

PortletURL addTimesheetURL = renderResponse.createRenderURL();
addTimesheetURL.setWindowState(LiferayWindowState.NORMAL);
addTimesheetURL.setParameter("jspPage", "/META-INF/resources/addTimesheetPage.jsp");

List<String> monthsList = new ArrayList<String>();
String[] allMonth = new DateFormatSymbols().getMonths();
int year = Calendar.getInstance().get(Calendar.YEAR);
System.out.println("allMonth" + allMonth.length + "year" + year);
String list = ParamUtil.getString(request, "MonthYear", StringPool.BLANK);
System.out.println("list:---" + list);

String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December" };

    Calendar calendar = Calendar.getInstance();
    String currentMonth = monthName[calendar.get(Calendar.MONTH)];
String currentMonthYear=(currentMonth+","+year);


ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
long userId = td.getUserId();
Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
long employeeId = emp.getEmployeeId();

List<CompanyPolicy> cpList = new ArrayList<>();
DynamicQuery dynamicQuery = CompanyPolicyLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
dynamicQuery.add(criterion3);
cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery);


%>

<%-- <aui:row>
	<aui:col span="9">
	</aui:col>
	<aui:col span="3">
		<a class="btn btn-primary btn-default" name="timesheetList"
			type="submit" href="<%=dateRangeURL.toString()%>">Add Timesheet</a>
	</aui:col>
</aui:row> --%>

<aui:row>
		<aui:col span="1">
			<label>Show</label>
		</aui:col>

		<aui:col span="2">
			<aui:select onChange="timesheetList(this.value)" name="MonthYear"
				label="" id="MonthYear" value="">
				<%
					for (int i = 0; i < allMonth.length - 1; i++) {
										String month = allMonth[i];
										System.out.println("month = " + month);
										monthsList.add(allMonth[i]);

										String monthYear = (monthsList.get(i) + "," + year);
										System.out.println("monthYear:--" + monthYear);
										System.out.println("currentMonthYear:--" + currentMonthYear);
										String isSelect = "";

										if (currentMonthYear.equalsIgnoreCase(monthYear)) {
											System.out.println("currentMonthYearLoop::--" + currentMonthYear);
											System.out.println("monthsList.get(i)yearLoop::--" + monthYear);
											isSelect = "selected";
										}

										System.out.println("isSelect" + isSelect);
				%>
				<option value="<%=monthsList.get(i) + "," + year%>" <%=isSelect%>><%=monthsList.get(i) + "," + year%></option>

				<%	
					
					}
				%>
			</aui:select>
		</aui:col>
		<aui:col span="9">
			<label></label>
		</aui:col>
	</aui:row>
	<aui:input type="hidden" name="list" id="list"></aui:input>
<div id="projList">
</div>

<%-- <nav class="collapse-basic-search navbar navbar-default"
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

</nav> --%>
<%
CompanyPolicy cp = null;
if(cpList.size()!=0){ 
	cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(cpList.get(0).getCompanyPolicyId());
}
%>

<liferay-frontend:add-menu>
  <liferay-frontend:add-menu-item title='<%=LanguageUtil.get(request, "Add TimeSheet") %>' url="<%=dateRangeURL.toString()%>" />
</liferay-frontend:add-menu>

<%-- <%if(cp.getCheckStatus()==4){ %>
<liferay-frontend:add-menu>
  <liferay-frontend:add-menu-item title='<%=LanguageUtil.get(request, "Add TimeSheet") %>' url="<%=calendarShowURL.toString()%>" />
</liferay-frontend:add-menu>
<%} else {%>
<liferay-frontend:add-menu>
  <liferay-frontend:add-menu-item title='<%=LanguageUtil.get(request, "Add TimeSheet") %>' url="<%=dateRangeURL.toString()%>" />
</liferay-frontend:add-menu>
<%} %> --%>
<%-- <liferay-ui:search-container delta="20"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = tsEntryTempList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("tsEntryTempList", tsEntryTempList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.employee.empservice.model.TimeSheetEntry"
		modelVar="tsEntry">
		<%
			Date addDate = tsEntry.getEntry_date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
			String strDate = formatter.format(addDate);
		%>

		<liferay-ui:search-container-column-text name="Date" orderable="true"
			orderableProperty="entry_date">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectMaster projMast = ProjectMasterLocalServiceUtil.getProjectMaster(tsEntry.getProject_id());
		%>
		<liferay-ui:search-container-column-text name="Project Name"
			orderable="true" orderableProperty="project_id">
			<%=projMast.getProjectname()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectTask projTask = ProjectTaskLocalServiceUtil.getProjectTask(tsEntry.getProject_task_id());
		%>
		<liferay-ui:search-container-column-text name="Task Name"
			orderable="true" orderableProperty="project_task_id">
			<%=projTask.getTaskname()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Description"
			orderable="true" orderableProperty="work_description">
			<%=tsEntry.getWork_description()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Hours" orderable="true"
			orderableProperty="hours">
			<%=tsEntry.getHours()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

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

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container> --%>

<script type="text/javascript">
	$(document).ready(function() {
	var months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    var date = new Date();
   	var thisMonth = months[date.getMonth()];
    var output = document.getElementById('output');
    console.log(thisMonth);
    var year=date.getFullYear();
    var monthYear=thisMonth+","+year;
     //output.textContent = thisMonth;
     //var select=output.textContent;
    /* document.getElementById('date').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear(); /////document.getElementById('date').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear()*/
	//alert("select "+monthYear);
	timesheetList(monthYear);
	//attendanceList(select);
});
function timesheetList(list){
	//alert(list);
   url="<%=timesheetListURL.toString()%>";
		$.ajax({
			type : "post",
			url : url,
			data : {
				"<portlet:namespace/>list" : list	
			},
			success : function(data) {
				$("#projList").html(data);
			}
		});
	}
</script>