<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
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
boolean editURL = false;
long taskId = ParamUtil.getLong(request, "taskId");
TaskMaster tm = null;
if (taskId != 0) {
	editURL = true;
	try {
		tm = TaskMasterLocalServiceUtil.getTaskMaster(taskId);
	} catch (Exception ex) {
		ex.getMessage();
	}
}

int isStatus = 1;
if(Validator.isNotNull(tm)){
	if(tm.getStatus()==0){
		isStatus = 0;
	} else {
		isStatus = 1;
	}
}

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<aui:row>
	<aui:col span="12">
	<%if(tm==null){ %>
		<liferay-ui:header title="Add Task" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	<%} else { %>
		<liferay-ui:header title="Edit Task" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	<%} %>
	</aui:col>
</aui:row>

<portlet:actionURL name="taskMaster" var="taskMasterURL" />
<portlet:actionURL name="updateTaskMaster" var="updateTaskMasterURL" />

<aui:form name="taskMaster"
	action="<%=editURL!=true?taskMasterURL:updateTaskMasterURL %>"
	method="post">
	
	<aui:input name="taskId" type="hidden"
		value="<%=taskId%>"></aui:input>
		
	<aui:row>
	<aui:col span="6">
	
	<aui:input name="taskName" type="text" label="Task Name"
		placeholder="Task Name"
		value="<%=tm != null ? tm.getTaskName() : ""%>">
	<aui:validator name="required"></aui:validator>	
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
                                        $("#<portlet:namespace />taskName").val(val);
                                     return result;
                                       }
                           </aui:validator>
		
		</aui:input>
	
	</aui:col>
	
	<aui:col span="6">
	
	<aui:input name="taskDesc" type="textarea" label="Task Description"
		placeholder="Task Description"
		value="<%=tm != null ? tm.getTaskDesc() : ""%>">
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
                                        $("#<portlet:namespace />taskDesc").val(val);
                                     return result;
                                       }
                           </aui:validator>
		</aui:input>
	
	</aui:col>
	
	</aui:row>
	<aui:row>
	<aui:col span="1">
	<div class="col-md-1 " style="padding-top: 7px;"> 
	<label>Status:</label> 
	</div>
	</aui:col>
	<aui:col span="1">
		<aui:input type="radio" name="status"
		checked="<%=isStatus == 1%>" label="Active" value="1"></aui:input>
		</aui:col>
		<aui:col span="1">
		<aui:input type="radio" name="status" label="InActive"
		checked="<%=isStatus == 0%>" value="0"></aui:input>
	</aui:col>
	</aui:row>
	<aui:button name="button" type="submit" value="submit"></aui:button>
</aui:form>