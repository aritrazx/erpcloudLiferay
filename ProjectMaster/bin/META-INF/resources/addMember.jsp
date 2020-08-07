<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

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
	src="/documents/20143/41753/jquery.min.js/e5d8f813-4c85-db44-86a3-12df7220b145"></script>
<liferay-ui:success key="add-success"
	message="This Project is successfully assigned to the Employee"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="This assigned project is successfully updated"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="This assigned project is successfully deleted"></liferay-ui:success>
<liferay-ui:error key="error"
	message="This Project is already assigned to the Employee"></liferay-ui:error>

<%
	boolean editURL = false;
	long projectTeamsId = ParamUtil.getLong(request, "projectTeamsId");
	long projectId = ParamUtil.getLong(request, "projectId");
	long employeeId = ParamUtil.getLong(request, "employeeId");
	String employeeName = ParamUtil.getString(request, "employeeName", StringPool.BLANK);
	//String lastName = ParamUtil.getString(request, "lastName", StringPool.BLANK);
	System.out.println("employeeId...." + employeeId);
	ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
	String projectName = ParamUtil.getString(renderRequest, "selectProject", StringPool.BLANK);
	//String projectStatus = ParamUtil.getString(renderRequest, "projectStatus", StringPool.BLANK);
	String projectRole = ParamUtil.getString(renderRequest, "selectRole", StringPool.BLANK);
	String employee = ParamUtil.getString(renderRequest, "selectEmployee", StringPool.BLANK);
	String val = ParamUtil.getString(request, "selectEmployee", StringPool.BLANK);
	String cmd = ParamUtil.getString(request, Constants.CMD);
	System.out.println("val...." + val);
	AddTeamMember atm1 = null;
	Employee employee1 = null;
	System.out.println("projectTeamsId...." + projectTeamsId);
	if (projectTeamsId != 0) {
		editURL = true;
		try {
			atm1 = AddTeamMemberLocalServiceUtil.getAddTeamMember(projectTeamsId);
			employee1 = EmployeeLocalServiceUtil.getEmployee(atm1.getEmployeeId());
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
%>

<%
	PortletURL teamMemberURL = renderResponse.createRenderURL();
	teamMemberURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	teamMemberURL.setParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");

	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");


	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("projectId", String.valueOf(projectId));
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/addMember.jsp");

	iteratorUrl.setParameter("projectId", projectName);
	iteratorUrl.setParameter("roleId", projectRole);
	iteratorUrl.setParameter("employeeId", employee);
	
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setWindowState(LiferayWindowState.NORMAL);
	viewURL.setParameter("projectId", String.valueOf(projectId));
	viewURL.setParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
	
%>

<%
List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1,-1);
List<Employee> empList1 = new ArrayList<>();
List<Employee> empList2 = new ArrayList<>();
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
if(employeeId!=0){
emp = EmployeeLocalServiceUtil.getEmployee(employeeId);
System.out.println("employee name...." + emp.getFirstName()+" "+emp.getLastName());
}

%>

<% 
PortletURL assignURL = renderResponse.createRenderURL();
assignURL.setWindowState(LiferayWindowState.POP_UP);
assignURL.setParameter("projectId",String.valueOf(projectId));
assignURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");
/* assignURL.setParameter("documentId", String.valueOf(documentId));
assignURL.setParameter("notifyId", String.valueOf(curRow.getNotifyIdSendId()) );  */
//String popup ="javascript:popup('"+ assignURL.toString()+"');";

PortletURL assignURL1 = renderResponse.createRenderURL();
assignURL1.setWindowState(LiferayWindowState.POP_UP);
assignURL1.setParameter("projectId", String.valueOf(projectId));
assignURL1.setParameter("jspPage", "/META-INF/resources/addTaskEmployee.jsp");
/* assignURL.setParameter("documentId", String.valueOf(documentId));
assignURL.setParameter("notifyId", String.valueOf(curRow.getNotifyIdSendId()) );  */
String popup1 ="javascript:popup('"+ assignURL1.toString()+"');";
%>
<%
	
	List<Role> roleList = RoleLocalServiceUtil.getRoles(-1, -1);
	/* for(int i=0;i<roleList.size();i++){
		String status =roleList.get(i).getExpandoBridge().getAttribute("ISPROJECT").toString();
		//System.out.println("-------expendo bridge------"+status);
		if(status=="true"){
			System.out.println("-------roleList------"+roleList.get(i).getName());
		}
		
	} */
	%>


<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Add Member" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>
</br>
</br>
<portlet:actionURL name="addTeamMember" var="addTeamMemberURL" />
<portlet:actionURL name="updateTeamMember" var="updateTeamMemberURL" />

<aui:form name="addTeamMember"
	action="<%=editURL != true ? addTeamMemberURL.toString() : updateTeamMemberURL.toString()%>"
	method="post">
	<aui:input name="projectTeamsId" type="hidden"
		value="<%=projectTeamsId%>"></aui:input>
	<aui:input name="projectId" type="hidden"
		value="<%=projectId%>"></aui:input>
	<aui:input name="employeeId" id="employeeId" type="hidden"
		value="<%=employeeId%>"></aui:input>
	<%-- <aui:input name="lastName" id="lastName" type="text"
		value="<%=lastName%>"></aui:input> --%>
	<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
	<aui:row>
	<aui:col span="5">
	<aui:input name="employeeName" id="employeeName" label="Click here to add Employee" type="text" readonly="readonly"
		value="<%=employee1!=null?(employee1.getFirstName()+" "+employee1.getLastName()): employeeName%>" onClick="popup()">
	<aui:validator name="required"></aui:validator>	
	</aui:input>
	
	</aui:col>
	
	<%-- <aui:select name="selectEmployee" label="Select Employee" required="true">
		<aui:option value="">Select Employee</aui:option>
		<%
			try {

				
					for (Employee obj : empList2) {
						if (atm1 != null) {
							if (obj.getEmployeeId() == atm1.getEmployeeId()) {
		%>
		<option value="<%=obj.getEmployeeId()%>" selected><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
			<%=obj.getLastName()%></option>
		<%
			} else {
		%>
		<option value="<%=obj.getEmployeeId()%>"><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
			<%=obj.getLastName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getEmployeeId()%>"><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
			<%=obj.getLastName()%></option>
		<%
			}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
		<aui:option value="<%=atm1 != null ? atm1.getEmployee_id() : ""%>"></aui:option>

	</aui:select> --%>
	
	
	<aui:col span="2">
	<%-- <div class="col-md-2 " style="padding-top: 25px;padding-left: 0px;">
	<a class="btn btn-primary btn-default" name="calendarShow"
			type="submit" href="<%=popup.toString()%>">Add Employee</a>
	</div> --%>
	</aui:col>
	<aui:col span="5">
	
	<aui:select name="selectRole" label="Select Role" required="true">
		<aui:option value="">Select Role</aui:option>
		<%
			try {
						for (Role obj : roleList) {
						//System.out.println("roleList...." + roleList);
						boolean status = (boolean)obj.getExpandoBridge().getAttribute("ISPROJECT").equals(true);
						System.out.println("status...." + status);
						if(status){
							if (atm1 != null) {
								if (obj.getRoleId() == atm1.getRoleId()) {
		%>
		<option value="<%=obj.getRoleId()%>" selected><%=obj.getName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getRoleId()%>"><%=obj.getName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getRoleId()%>"><%=obj.getName()%></option>
		<%
			}
						}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>

	</aui:select>
	
	</aui:col>
	
	<%-- <aui:select name="selectProject" label="Select Project">
		<aui:option value="">Select Project</aui:option>
		<%
			try {

						List<ProjectMaster> projList = ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
						for (ProjectMaster obj : projList) {
							if (atm1 != null) {
								if (obj.getProjectId() == atm1.getProjectId()) {
		%>
		<option value="<%=obj.getProjectId()%>" selected><%=obj.getProjectName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getProjectId()%>"><%=obj.getProjectName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getProjectId()%>"><%=obj.getProjectName()%></option>
		<%
			}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
		<aui:option value="<%=atm1 != null ? atm1.getProject_id() : ""%>"></aui:option>

	</aui:select> --%>
	<%-- <aui:col span="2">
	<aui:select name="selectRole" label="Select Role" required="true">
		<aui:option value="">Select Role</aui:option>
		<%
			try {
						List<ProjectRole> roleList = ProjectRoleLocalServiceUtil.getProjectRoles(-1, -1);
						for (ProjectRole obj : roleList) {
							if (atm1 != null) {
								if (obj.getRoleId() == atm1.getRoleId()) {
		%>
		<option value="<%=obj.getRoleId()%>" selected><%=obj.getRoleName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getRoleId()%>"><%=obj.getRoleName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getRoleId()%>"><%=obj.getRoleName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
		<aui:option value="<%=atm1 != null ? atm1.getRole_id() : ""%>"></aui:option>

	</aui:select>
	<a class="btn btn-primary btn-default" name="calendarShow"
			type="submit" href="<%=popup1.toString()%>">Add Task</a>
	</aui:col> --%>
	</aui:row>
	<%-- <aui:row>
	<aui:col span="6">
	<aui:input name="checkForManager" label="Is Project Manager"
		type="checkbox"
		value="<%=atm1 != null ? atm1.getIsProjectManager() : ""%>">
	</aui:input>
	</aui:col>
	<aui:col span="2"></aui:col>
	<aui:col span="1">
	<aui:button name="button" type="submit" value="submit"></aui:button>
	</aui:col>
	<aui:col span="3">
	<aui:button id="btnAddTask" cssClass="btn btn-danger" name="button"
		type="reset" value="reset" onClick="resetBtn()"></aui:button>
	</aui:col>
	</aui:row> --%>
	<aui:button name="button" onClick="javascript:setProjId();" type="submit" value="submit"></aui:button>
	<aui:button id="btnAddTask" cssClass="btn btn-danger" name="button"
		type="reset" value="reset" onClick="resetBtn()"></aui:button>
</aui:form>
<%-- <%
if (null == val || val.isEmpty()) {
	atmTempList = atmList;
} else {
	for (AddTeamMember addTeam : atmList) {
		//System.out.println("for.....");
		if (val.equals(addTeam.getEmployee_id())) {
			DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("employee_id").eq(Long.parseLong(val)));
			atmTempList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
			//System.out.println("pm....." +pm);
		} else {
			/* DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.like("employee_id",
					new StringBuilder("%").append(val).append("%").toString());
			//System.out.println("fname ELSE2222........."+criterion3);
			dynamicQuery.add(criterion3);
			atmTempList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery); */
		}
	}
}

%> --%>
<%-- <portlet:resourceURL id="teamMember" var="teamMemberURL">
<portlet:param name="<%=Constants.CMD %>" value="teamMember" />
</portlet:resourceURL> --%>


<%-- <div id="projList"></div>


<script type="text/javascript">
	
	function changeEmp(val){
		var url = "<%=teamMemberURL.toString()%>"
		$.ajax({
			url : url,
			data : {
				"<portlet:namespace/>val" : val
			},//person id to sent
			type : 'POST',
			success : function(data) {
				$("#projList").html(data);
			},
		});
	}
</script> --%>

<script type="text/javascript">
	function resetBtn() {

		document.getElementById('projectTeamsId').value = '';
		document.getElementById('selectEmployee').value = 0;
		document.getElementById('selectProject').value = 0;
		document.getElementById('selectRole').value = 0;
		$("#btnAddTask").html('Save');
		$('button').removeClass('disabled');
	}
	
	$(document).ready(function() {
		selectEmployee = function(employeeId, employeeName, projectId) {

		$('#<portlet:namespace />employeeId').val(employeeId);
		$('#<portlet:namespace />employeeName').val(employeeName);
		$('#<portlet:namespace />projectId').val(projectId);
		};
		});
</script>

<aui:script>
	function popup() {
		var url = '<%=assignURL.toString()%>';
		console.log("url--"+url);
		var employeeId = $("#<portlet:namespace/>employeeId").val();
		console.log("employeeId--"+employeeId);
		Liferay.Util.openWindow({
			dialog : {
				//cssClass: 'aui-popup-example',
				destroyOnHide : true,
				height : 600,
				width : 550,
				close: true
			},
			dialogIframe : {
			//bodyCssClass: 'custom-css-class'
			},
			title : 'Add Employee',
			uri : url

		});
		/* if(employeeId!=0){
			popWindow.destroy();
		} */
	}
	
</aui:script>

<script>

function setProjId(){
	var projectId = <%=projectId%>;
	$('#<portlet:namespace />projectId').val(projectId);
}



</script>