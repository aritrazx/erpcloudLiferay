<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMasterMapping"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
long valProj = ParamUtil.getLong(request, "valProj");
long projectTaskId = ParamUtil.getLong(request, "projectTaskId");
System.out.println("projectTaskId...:"+projectTaskId);
System.out.println("val in fetch task...." + valProj);

List<TaskMasterMapping> taskList = new ArrayList<>();

try {
	if(valProj!=0){
	DynamicQuery dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(valProj));
	taskList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("taskList: " + taskList.size());
	}
	} catch (Exception e) {
}

%>
<%-- <%if(taskList.size()==0){ %>
<option value="">No Task Found</option>
<%} %> --%>
<option value="">Select Task</option>
<%
	try {
		for (TaskMasterMapping obj : taskList) {
			TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(obj.getTaskId());
%>

<option value="<%=tm.getTaskId()%>" ><%=tm.getTaskName()%></option>


<%
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>