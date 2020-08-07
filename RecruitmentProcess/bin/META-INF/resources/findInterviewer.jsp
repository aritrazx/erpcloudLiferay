<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	String val = ParamUtil.getString(request, "search", StringPool.BLANK);
	List<User> userList = new ArrayList<>();
	DynamicQuery allUser = UserLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("status",0);
	allUser.add(criterion);
	userList = UserLocalServiceUtil.dynamicQuery(allUser);
	
	List<Employee> emp = EmployeeLocalServiceUtil.getEmployees(-1,-1);
	List<Employee> activeEmployee= new ArrayList<>();
	List<Employee> empSearchObj = new ArrayList<>();
	for(int i=0;i<userList.size();i++){
		DynamicQuery employee = EmployeeLocalServiceUtil.dynamicQuery();
		Criterion criterion1 = null;
		criterion1 = RestrictionsFactoryUtil.eq("userId",userList.get(i).getUserId());
		employee.add(criterion1);
		emp= EmployeeLocalServiceUtil.dynamicQuery(employee);
		activeEmployee.addAll(emp);
	}

	PortletURL addEmpURL = renderResponse.createRenderURL();
	addEmpURL.setWindowState(LiferayWindowState.NORMAL);
	addEmpURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/META-INF/resources/findInterviewer.jsp"); 
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/findInterviewer.jsp"); 

	if (null == val || val.isEmpty()) {
		empSearchObj = activeEmployee;
	} else {
		for (Employee activeEmployeeObj : activeEmployee) {
			//System.out.println("for.....");
			if (val.equals(activeEmployeeObj.getFirstName())) {
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("firstName").eq(val));
				empSearchObj = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
				//System.out.println("pm....." +pm);
			} else if (val.equals(activeEmployeeObj.getLastName())) {
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("lastName").eq(val));
				empSearchObj = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			} else if (val.equals(String.valueOf(activeEmployeeObj.getEmployeeCode()))) {
				System.out.println("empl.getEmployeeCode()...." + activeEmployeeObj.getEmployeeCode());
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("employeeCode").eq(Long.parseLong(val)));
				empSearchObj = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("empSearchList...." + empSearchObj);
				System.out.println("inside else if....");
			} else {
				System.out.println("inside else....");
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.like("firstName",
						new StringBuilder("%").append(val).append("%").toString());
				criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("lastName",
						new StringBuilder("%").append(val).append("%").toString()));
				/* criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("employeeCode",
						new StringBuilder("%").append(Long.parseLong(val)).append("%").toString())); */
				//System.out.println("fname ELSE2222........."+criterion3);
				dynamicQuery.add(criterion3);
				empSearchObj = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			}
		}
	}
%>

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

<%-- <input name="<portlet:namespace />employeeId" id="employeeId" type="hidden" label=""
		value="<%=empSearchObj!=null?emp.getEmployeeId():""%>"></input>
 --%>

<liferay-ui:search-container delta="10" cssClass="customForm"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>" orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = empSearchObj;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("projList", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Employee"
		modelVar="employee">
		
		<%
		addEmpURL.setParameter("employeeId", String.valueOf(employee.getEmployeeId()));
		//System.out.println("addEmpURL...." + projMast.getEmployeeId());
			%>
		<liferay-ui:search-container-column-text name="Employee Code"
			 orderableProperty="employeeCode">
			<%=employee.getEmployeeCode()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Employee Name"
			 orderableProperty="clientId">
			<%=employee.getFirstName()+" "+employee.getLastName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">
<input type="button" name="choose" id="choose" class="btn btn-primary btn-default" value="Add" onClick="closePopUp('<%= String.valueOf(employee.getEmployeeId()) %>+`<%= String.valueOf(employee.getFirstName()) %>`+`<%= String.valueOf(employee.getLastName()) %>`+')"  />
<%-- <aui:button type="button" value="Choose" name="Choose" onClick="closePopUp(<%= String.valueOf(projMast.getEmployeeId()) %>)"  >Chhose</aui:button> --%>
			<%-- <liferay-ui:icon-menu markupView="lexicon">
				onClick="closePopUp('<%= String.valueOf(employee.getEmployeeId()) %>+`<%= String.valueOf(employee.getFirstName()) %>`+`<%= String.valueOf(employee.getLastName()) %>`+')"
				<liferay-ui:icon url="<%=addEmpURL.toString()%>" 
					label="Add" message="Add" image="" icon="plus"  onClick="closePopUp(value)"/>
			</liferay-ui:icon-menu> --%>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%-- <aui:script > 
AUI().ready('aui-dialog', function(A) {
A.get('#hideAll').on('click', function() {
A.DialogManager.hideAll();
});
});
</aui:script>  --%>

<%-- <aui:script>

function closePopUp(){
	
	var empId = $('#employeeId').val();
	var projId = $('#<portlet:namespace />projectId').val();
	console.log("empId--"+empId);
	console.log("projId--"+projId);
	Liferay.Util.getOpener().selectEmployee(empId, projId);
	
}

</aui:script> --%>

<script type="text/javascript">

function closePopUp(empId){
	//alert(empId);
	var interviewerId = empId.split("+`")[0];
	var firstName = empId.replace(interviewerId+"+`",'');
	var firstName1 = firstName.replace("`+`"," ");
	var empName = firstName1.replace("`+",'');
	//var lastName = empId.split("`+`")[2];
	//var empId = $('#employeeId').val();
	console.log("employeeId--"+interviewerId);
	console.log("empName--"+empName);
	//console.log("lastName--"+lastName);
	console.log("empId--"+empId);
	Liferay.Util.getOpener().selectEmployee(interviewerId, empName);
	
}

/* $(".addEmp").each(function() { 

	
	
	$(this).click(function() {
		
    	//str1 =  str +","+ str1;
    	//$("#taskList").val(str1);
			var str= $("#employeeId").val();
			var str1 = $(this).val();
			str1 =  str +","+ str1;
			$("#employeeId").val(str1);
			console.log("str---"+str);
			console.log("str1---"+str1);
	});
	
	
}); */


</script>


<style>

.customForm{

    padding-left: 10px;
    padding-right: 10px;

}

</style>