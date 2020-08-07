<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMasterMapping"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
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
	message="Task is successfully assigned to the project!"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Task is updated successfully!"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="Task is successfully deleted!"></liferay-ui:success>
<liferay-ui:error key="error" message="Task Name already exist!"></liferay-ui:error>
<%
	boolean editURL = false;
	long projectTaskId = ParamUtil.getLong(request, "projectTaskId");
	long projectId = ParamUtil.getLong(request, "projectId");
	ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
	String selectEmployee = ParamUtil.getString(renderRequest, "selectEmployee", StringPool.BLANK);
	String startDate = ParamUtil.getString(renderRequest, "startDate", StringPool.BLANK);
	String endDate = ParamUtil.getString(renderRequest, "endDate", StringPool.BLANK);
	String hours = ParamUtil.getString(renderRequest, "hours", StringPool.BLANK);
	String taskName = ParamUtil.getString(renderRequest, "taskName", StringPool.BLANK);
	String val = ParamUtil.getString(request, "selectProject", StringPool.BLANK);
	List<ProjectTask> projTaskList = new ArrayList<ProjectTask>();
	projTaskList = ProjectTaskLocalServiceUtil.getProjectTasks(-1, -1);
	ProjectTask pt = null;
	if (projectTaskId != 0) {
		editURL = true;
		try {
			pt = ProjectTaskLocalServiceUtil.getProjectTask(projectTaskId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
%>

<%
List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1,-1);
List<Employee> empList1 = new ArrayList<>();
List<Employee> empList2 = new ArrayList<>();
List<Employee> empList3 = new ArrayList<>();
List<Employee> empList4 = new ArrayList<>();

List<AddTeamMember> atmList1 = new ArrayList<>();
List<AddTeamMember> atmList2 = new ArrayList<>();

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
RestrictionsFactoryUtil.eq("projectId", projectId)); */
dynamicQuery.add(criterion3);
empList1 = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
empList2.addAll(empList1);
}

for(int i=0;i<empList2.size();i++){
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
	criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("employeeId", empList2.get(i).getEmployeeId()));
	dynamicQuery.add(criterion3);
	atmList1 = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	atmList2.addAll(atmList1);
}

for(int i=0;i<atmList2.size();i++){
	DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("employeeId", atmList2.get(i).getEmployeeId());
	/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("projectId", projectId)); */
	dynamicQuery.add(criterion3);
	empList3 = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
	empList4.addAll(empList3);
}

List<TaskMasterMapping> findTask = new ArrayList<>();

try {
	if(projectId != 0){
	DynamicQuery dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
	findTask = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("taskList in timesheet entry: " + findTask.size());
	}
} catch (Exception e) {
}

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("projectId", String.valueOf(projectId));
viewURL.setParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
%>

<%
	Date defaultDate = new Date();
	Date startDate1, endDate1;
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
	startDate1 = defaultDate;

	endDate1 = defaultDate;
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Add Task" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>
</br>
</br>
<portlet:actionURL name="projectTask" var="projectTaskURL" />
<portlet:actionURL name="updateProjectTask" var="updateProjectTaskURL" />
<aui:form name="projectTask"
	action="<%=editURL != true ? projectTaskURL.toString() : updateProjectTaskURL.toString()%>"
	method="post">
	<aui:input name="projectTaskId" type="hidden"
		value="<%=projectTaskId%>"></aui:input>
	<aui:input name="projectId" type="hidden"
		value="<%=projectId%>"></aui:input>
	<aui:row>
	<aui:col span="6">
	<aui:select name="selectEmployee" label="Select Employee" required="true">
		<aui:option value="">Select Employee</aui:option>
		<%
			try {

					for (Employee obj : empList4) {
						if (pt != null) {
							if (obj.getEmployeeId() == pt.getEmployeeId()) {
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

	</aui:select>
	</aui:col>
	<aui:col span="6">
	<%-- <aui:input name="taskName" type="text" label="Task Name"
		placeholder="Task Name"
		value="<%=pt != null ? pt.getTaskName() : ""%>">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="alphanum"></aui:validator>
		<aui:validator name="custom"            
                                 errorMessage="Only Alphanumeric allowed">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^a-z|^A-Z|^0-9|\s]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />projectName").val(val);
                                     return result;
                                       }
                           </aui:validator>
	</aui:input> --%>
	
	<aui:select name="selectTask" label="Select Task" id="taskList" required="true">
		<option value="">Select Task</option>
		<%
			try {
						for (TaskMasterMapping obj : findTask) {
							TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(obj.getTaskId());
							if (pt != null) {
								if (obj.getTaskId()== pt.getTaskId()) {
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
	<aui:col span="4">

			<%
				String tempStartDate = "";
							try {
								if (pt != null) {
									Date addDate = pt.getStartDate();
									SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
									tempStartDate = formatter.format(addDate);
								} else {
									tempStartDate = "";
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
			%>

	<aui:input id="txtFromDate_id" name="startDate" type="text"
	label="Select Start Date" placeholder="Start Date" readonly="readonly" value="<%=pt!=null? tempStartDate : formatter1.format(startDate1)%>">
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</aui:col>
	
	<aui:col span="4" id="endDateShown">
			<%
				String tempEndDate = "";
							try {
								if (pt != null) {
									Date eDate = pt.getEndDate();
									SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
									tempEndDate = formatter.format(eDate);
								} else {
									tempEndDate = "";
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
			%>
	<aui:input id="txtToDate_id" name="endDate" type="text"
	label="Select To Date" placeholder="End Date" value="<%=pt!=null? tempEndDate : formatter1.format(endDate1)%>" readonly="readonly" >
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</aui:col>
	
	<aui:col span="4">
	<aui:input name="hours" type="text" label="Hours" placeholder="Hours" value="<%=pt != null ? pt.getHours() : ""%>">
	<aui:validator name="required"></aui:validator>
	<aui:validator name="number"></aui:validator>
	<aui:validator name="min">1</aui:validator>
	<aui:validator name="max">8</aui:validator>
	</aui:input>
	</aui:col>
	</aui:row>
	
	<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
	<aui:button name="button" type="submit" value="submit"></aui:button>
	<aui:button id="btnAddTask" cssClass="btn btn-danger" name="button"
		type="reset" value="reset" onClick="resetBtn()"></aui:button>
	</br>
	</br>
</aui:form>

<script type="text/javascript">
function resetBtn()
{

	document.getElementById('projectTaskId').value = '';
    document.getElementById('selectProject').value = 0;
    document.getElementById('taskName').value = '';
    $("#btnAddTask").html('Save');
    $('button').removeClass('disabled');
}
</script>

<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	/* PortletURL projectTaskEditURL = renderResponse.createRenderURL();
	projectTaskEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL projectTaskDeleteURL = renderResponse.createActionURL();
	projectTaskDeleteURL.setParameter("javax.portlet.action", "deleteProjectTask"); */

	PortletURL taskURL = renderResponse.createRenderURL();
	taskURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	taskURL.setParameter("jspPage", "/META-INF/resources/fetchTask.jsp");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	/* iteratorUrl.setParameter("projectId", projectName);
	iteratorUrl.setParameter("taskName", taskName); */
%>
<%-- <liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = projTaskList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("projTaskList", projTaskList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.employee.empservice.model.ProjectTask"
		modelVar="projTask">


		<liferay-ui:search-container-column-text name="Task Name"
			orderable="true" orderableProperty="taskname">
			<%=projTask.getTaskname()%>
		</liferay-ui:search-container-column-text>
		<%
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(projTask.getProject_id());
		%>
		<liferay-ui:search-container-column-text name="Project"
			orderable="true" orderableProperty="project_id">
			<%=pm.getProjectname()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
			projectTaskEditURL.setParameter("project_task_id", String.valueOf(projTask.getProject_task_id()));
			projectTaskEditURL.setParameter("editURL", String.valueOf(editURL));
			projectTaskDeleteURL.setParameter("project_task_id", String.valueOf(projTask.getProject_task_id()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=projectTaskEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=projectTaskDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container> --%>
<%-- <div id="taskList"></div>

<script type="text/javascript">
	
	function changeTask(val){
		var url = "<%=taskURL.toString()%>"
	
		$.ajax({
			url : url,
			data : {
				"<portlet:namespace/>val" : val
			},//person id to sent
			type : 'POST',
			success : function(data) {
				$("#taskList").html(data);
			},
		});
	}
</script> --%>

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

<!-- <script>
AUI().use('aui-datepicker', function(A) {
	var dfg = new A.DatePicker({
		trigger : '#<portlet:namespace />txtFromDate_id',
		mask : '%d/%m/%Y',

		popover : {
			zIndex : 1000
		},
		calendar : {
			
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
				
			}
		});
	});
</script> -->

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
                    minimumDate: new Date()
                }
            });

            toDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace />txtToDate_id',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                },
                calendar: {
                    minimumDate: new Date()
                }
            });
        }
    );
  </aui:script>