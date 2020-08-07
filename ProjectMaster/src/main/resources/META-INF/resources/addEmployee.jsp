<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
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
long projectId = ParamUtil.getLong(request, "projectId");
long employeeId = ParamUtil.getLong(request, "employeeId");
String val = ParamUtil.getString(request, "search", StringPool.BLANK);
System.out.println("val...." + val);
System.out.println("employeeId...." + employeeId);
String selectedEmp = "";
List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1,-1);
List<Employee> empList1 = new ArrayList<>();
List<Employee> empList2 = new ArrayList<>();
List<Employee> empSearchList = new ArrayList<>();
List<User> userList = new ArrayList<>();
List<User> userList1 = new ArrayList<>();
for(int i=0;i<empList.size();i++){
DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("userId", empList.get(i).getUserId());
criterion3 = RestrictionsFactoryUtil.and(criterion3,
RestrictionsFactoryUtil.eq("status", 0));
dynamicQuery.add(criterion3);
userList = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
userList1.addAll(userList);
}

for(int i=0;i<userList1.size();i++){
DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("userId", userList1.get(i).getUserId());
/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
RestrictionsFactoryUtil.eq("isProjectManager", true)); */
dynamicQuery.add(criterion3);
empList1 = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
empList2.addAll(empList1);
}
Employee emp = null;
Employee emp1 = null;
if(employeeId!=0){
	emp = EmployeeLocalServiceUtil.getEmployee(employeeId);
}

for(int i=0;i<empList2.size();i++){
	emp1 = EmployeeLocalServiceUtil.getEmployee(empList2.get(i).getEmployeeId());
}

PortletURL addEmpURL = renderResponse.createRenderURL();
addEmpURL.setWindowState(LiferayWindowState.NORMAL);
addEmpURL.setParameter("projectId", String.valueOf(projectId));
addEmpURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

/* iteratorUrl.setParameter("projectName", projectName);
iteratorUrl.setParameter("clientId", projectClient);
iteratorUrl.setParameter("projectStatusId", projectStatus); */

if (null == val || val.isEmpty()) {
	empSearchList = empList2;
} else {
	for (Employee empl : empList2) {
		//System.out.println("for.....");
			/* if(val.equals(empl.getFirstName()) || val.equals(empl.getLastName())){	 */
			DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.like("firstName",
					new StringBuilder("%").append(val).append("%").toString());
			criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("lastName",
					new StringBuilder("%").append(val).append("%").toString()));
			//criterion3 = RestrictionsFactoryUtil.or(criterion3, PropertyFactoryUtil.forName("employeeCode").eq(Long.parseLong(val)));
			//System.out.println("fname ELSE2222........."+criterion3);
			dynamicQuery.add(criterion3);
			empSearchList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
		
			/*}  else {
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("employeeCode", Long.parseLong(val));
				dynamicQuery.add(criterion3);
				empSearchList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			} */
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

<input name="<portlet:namespace />employeeId" id="employeeId" type="hidden" label=""
		value="<%=emp!=null?emp.getEmployeeId():""%>"></input>
<aui:input name="projectId" id="projectId" type="hidden"
		value="<%=projectId%>"></aui:input>

<liferay-ui:search-container delta="10" cssClass="customForm"
	emptyResultsMessage="No record found." orderByCol="" orderByType="" iteratorURL="<%=iteratorUrl %>">
	<liferay-ui:search-container-results>
		<%
			results = empSearchList;
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
		<%-- <liferay-ui:search-container-column-text name="Employee Code"
			 orderableProperty="clientId">
			<%=employee.getEmployeeCode()%>
		</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Employee Name"
			 orderableProperty="clientId">
			<%=employee.getFirstName()+" "+employee.getLastName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">
<input type="button" name="choose" class="btn btn-primary btn-default" value="Add"  onClick="closePopUp('<%= String.valueOf(employee.getEmployeeId()) %>+`<%= String.valueOf(employee.getFirstName()) %>`+`<%= String.valueOf(employee.getLastName()) %>`+')" />
<%-- <aui:button type="button" value="Choose" name="Choose" onClick="closePopUp(<%= String.valueOf(projMast.getEmployeeId()) %>)"  >Chhose</aui:button> --%>
		<%-- 	<liferay-ui:icon-menu markupView="lexicon">

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
	var employeeId = empId.split("+`")[0];
	var firstName = empId.replace(employeeId+"+`",'');
	var firstName1 = firstName.replace("`+`"," ");
	var empName = firstName1.replace("`+",'');
	//var lastName = empId.split("`+`")[2];
	//var empId = $('#employeeId').val();
	console.log("employeeId--"+employeeId);
	console.log("empName--"+empName);
	//console.log("lastName--"+lastName);
	var projId = $('#<portlet:namespace />projectId').val();
	console.log("empId--"+empId);
	console.log("projId--"+projId);
	Liferay.Util.getOpener().selectEmployee(employeeId, empName, projId);
	
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