<%@page import="com.liferay.famocom.erpcloud.workschedule.util.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.service.WorksSchedulesLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.SchedulesMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.WorksSchedules"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.dynamic.data.mapping.kernel.Value"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:error key="error" message="Sorry date allready Schedule"></liferay-ui:error>
<liferay-ui:error key="errorTemp" message="Sorry!Schedule already exist"></liferay-ui:error>
<liferay-ui:error key="errorTest" message="Yoooo"></liferay-ui:error>
<%	
	List<Employee> employee=null;
	List<WorksSchedules> wrkSchedules=null;
	List<SchedulesMaster> master=null;
	try{
		employee= EmployeeLocalServiceUtil.getEmployees(-1,-1);
				
		wrkSchedules = WorksSchedulesLocalServiceUtil.getWorksScheduleses(-1, -1);
		master = SchedulesMasterLocalServiceUtil.getSchedulesMasters(-1,-1); 
	 }catch(Exception e){
		
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	boolean editURL = false;
	long worksSchedulesId = ParamUtil.getLong(request, "worksSchedulesId");
	WorksSchedules schedule=null;
	SchedulesMaster scheduleMaster=null;
	if (Validator.isNotNull(worksSchedulesId)) {
		editURL = true;
		try {
			schedule = WorksSchedulesLocalServiceUtil.getWorksSchedules(worksSchedulesId);
			//scheduleMaster=SchedulesMasterLocalServiceUtil.getSchedulesMaster(worksSchedulesId);
		} catch (Exception e) {

		}
	}
	
	PortletURL SchedulesEditUrl = renderResponse.createRenderURL();
	SchedulesEditUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	PortletURL addWorksScheduleURL = renderResponse.createRenderURL();
	addWorksScheduleURL.setParameter("jspPage", "/META-INF/resources/addNewWorkSchedules.jsp");
	PortletURL deleteSchedulesURL = renderResponse.createActionURL();
	deleteSchedulesURL.setParameter("javax.portlet.action", "deleteWorkSchedules");
	
%>

<%-- <%
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
%>
 --%>


	<portlet:actionURL name="worksSchedules" var="worksSchedulesURL" />
	<portlet:actionURL name="worksSchedulesEdit" var="worksSchedulesEditURL" />
	<aui:form name="worksSchedules" action="<%=editURL != true ?worksSchedulesURL.toString():worksSchedulesEditURL.toString()%>"
		method="post">
		<aui:input name="worksSchedulesId" type="hidden" value="<%=worksSchedulesId%>" />
	<aui:row>
		<aui:row>
				<aui:col span="10">
				</aui:col>
				<aui:col span="2">
					<aui:button name="addWorksSchedule" type="button" href="<%=addWorksScheduleURL.toString() %>" value="Add New Schedule">
					
					</aui:button>
				</aui:col>
		</aui:row>
	</br>
	<aui:row>
		
		<aui:col span="3">
			<aui:select name="workSchedules" label="Work Schedules" id="workSchedules">
						<%
							for (SchedulesMaster sm:master) {
								if(schedule!=null){		
						%>
						<aui:option value="<%=sm.getSchedulesId()%>" selected="<%=sm.getSchedulesId()==schedule.getSchedulesId() %>"><%=sm.getSchedulesName()%></aui:option>
						<%
								}else{
						%>
						<aui:option value="<%=sm.getSchedulesId()%>"><%=sm.getSchedulesName()%></aui:option>
						
						<%
									
								}
							}
						%>
			</aui:select>
		</aui:col>
		<aui:col span="2">
			<aui:input type="text" name="fromDate" id="txtFromDate" value="<%=schedule==null?"":sdf.format(schedule.getFromDate()) %>"
						label="From Date" readonly="readonly">
						<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
		<aui:col span="2">
			<aui:input type="text" name="toDate" id="txtToDate" value="<%=schedule==null?"":sdf.format(schedule.getToDate()) %>"
						label="To Date" readonly="readonly">
				<aui:validator name="required"></aui:validator>
				
			</aui:input>
		</aui:col>
		
		<aui:col span="3">
			<aui:input type="text" name="description" value="<%=schedule==null?"":schedule.getDescription()%>"
						label="Description">
						<aui:validator name="required"></aui:validator>
						<aui:validator name="alpha"></aui:validator>
			</aui:input>
		</aui:col>
		
		<aui:col span="2">
			<aui:button type="submit" id="save" name="save"></aui:button>
			<button class="btn btn-danger" type="button" name="reset">Reset</button>
		</aui:col>
	</aui:row>
		</aui:row>
	</aui:form>
	</br>
	
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
		 List<WorksSchedules> workScheduleSortList = new ArrayList<>();
		 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
		 
		 workScheduleSortList = ListUtil.copy(wrkSchedules);
		 
		 ListUtil.sort(workScheduleSortList, orderByComparator);
	%>
	
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found."
	iteratorURL="<%=iteratorUrl%>" orderByCol="<%=orderByCol %>" orderByType="<%=orderByType %>">
	<liferay-ui:search-container-results>
		<%
			results = workScheduleSortList;
			total = results.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
					results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
			portletSession.setAttribute("wrkSchedules", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.WorksSchedules"
		modelVar="type">
		<%
		SchedulesMaster schedulerName=null;
		try{
			schedulerName= SchedulesMasterLocalServiceUtil.getSchedulesMaster(type.getSchedulesId());
		}catch(Exception e){
			e.printStackTrace();
		}
		%>
		<liferay-ui:search-container-column-text name="Work Schedules"
			orderable="true" orderableProperty="schedulesId">
			<%=schedulerName.getSchedulesName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="From Date"
			orderable="true" orderableProperty="fromDate">
			<%=sdf.format(type.getFromDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="To Date"
			orderable="true" orderableProperty="toDate">
			<%=sdf.format(type.getToDate())%>
		</liferay-ui:search-container-column-text>
		

		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					SchedulesEditUrl.setParameter("worksSchedulesId", String.valueOf(type.getWorksSchedulesId()));
					deleteSchedulesURL.setParameter("id", String.valueOf(type.getWorksSchedulesId()));
				%>

				<liferay-ui:icon url="<%=SchedulesEditUrl.toString()%>"
					message="edit" image="edit" />
				<liferay-ui:icon-delete url="<%=deleteSchedulesURL.toString()%>"
					message="delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>


<script>
	AUI().use('aui-datepicker', function(A) {
	var fromDate=new A.DatePicker({
	trigger : '#<portlet:namespace />txtFromDate',
	mask : '%d/%m/%Y',
	
	popover : {
	zIndex : 1000
	},calendar: {
	   }
	});
	});
	AUI().use('aui-datepicker', function(A) {
	var toDate=new A.DatePicker({
		trigger : '#<portlet:namespace />txtToDate',
		mask : '%d/%m/%Y',
		
		popover : {
		zIndex : 1000
		},
		calendar: {
		   }
		});
	});

</script>