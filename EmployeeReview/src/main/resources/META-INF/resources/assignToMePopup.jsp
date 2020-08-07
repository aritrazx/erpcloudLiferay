<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.taglib.portlet.ActionURLTag"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
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

long userId = themeDisplay.getUserId();
List<Role> roles = new ArrayList<Role>();
roles = RoleLocalServiceUtil.getUserRoles(userId);

long empId=ParamUtil.getLong(request, "empId");

//List<Employee> userWithMyRole = (List<Employee>) WorkflowTaskManagerUtil.


%>

<portlet:actionURL name="actionAssignToMe" var="ActionURL" />

<aui:form action="<%=ActionURL.toString() %>" method="post" name="name">


<aui:input label="Comment" name="comment"></aui:input>

<aui:input name="empId" type="hidden" value="<%=empId %>"></aui:input>


<aui:button class="btn-toolbar-button close close-content yui3-widget aui-button yui3-aui-button yui3-aui-button-content yui3-aui-button-focused"  name="btnSave" type="button"  value="Cancel"></aui:button>

<aui:button  name="btnSave" type="submit" onclick="hidePopup();" value="Save"></aui:button>




</aui:form>

