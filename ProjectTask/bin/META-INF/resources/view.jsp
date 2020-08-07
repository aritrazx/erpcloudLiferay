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
	String projectName = ParamUtil.getString(renderRequest, "selectProject", StringPool.BLANK);
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

<portlet:actionURL name="projectTask" var="projectTaskURL" />
<portlet:actionURL name="updateProjectTask" var="updateProjectTaskURL" />
<aui:form name="projectTask"
	action="<%=editURL != true ? projectTaskURL.toString() : updateProjectTaskURL.toString()%>"
	method="post">
	<aui:input name="projectTaskId" type="hidden"
		value="<%=projectTaskId%>"></aui:input>
	<aui:select name="selectProject" label="Select Project"
		onChange="changeTask(this.value);">
		<aui:option value="">Select Project</aui:option>
		<%
			try {
						List<ProjectMaster> projList = ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
						for (ProjectMaster obj : projList) {
							if (pt != null) {
								if (obj.getProjectId() == pt.getProjectId()) {
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
		<%-- <aui:option value="<%=pt != null ? pt.getProject_id() : ""%>"></aui:option> --%>

	</aui:select>

	<aui:input name="taskName" type="text" label="Task Name"
		placeholder="Task Name"
		value="<%=pt != null ? pt.getTaskName() : ""%>"></aui:input>
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

	iteratorUrl.setParameter("projectId", projectName);
	iteratorUrl.setParameter("taskName", taskName);
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
<div id="taskList"></div>

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
</script>