<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />


<%-- <%
	
	User searchTerms = UserLocalServiceUtil.getUser(userId);
	boolean showDeleteButton = (searchTerms.getStatus() != WorkflowConstants.STATUS_ANY) && (searchTerms.isActive() || (!searchTerms.isActive() && PropsValues.USERS_DELETE));
	boolean showRestoreButton = (searchTerms.getStatus() != WorkflowConstants.STATUS_ANY) && !searchTerms.isActive();

%> --%>

<liferay-frontend:management-bar includeCheckBox="<%=true%>" searchContainerId="users">
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%=new String[] { "active", "inactive" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>" />

		<liferay-frontend:management-bar-sort orderByCol="<%=orderByCol%>"
			orderByType="<%=orderByType%>"
			orderColumns='<%=new String[] { "name", "email" }%>'
			portletURL="<%=viewPageURL%>" />
	</liferay-frontend:management-bar-filters>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%=new String[] { "list" }%>'
			portletURL="<%=renderResponse.createRenderURL()%>"
			selectedDisplayStyle="" />
	</liferay-frontend:management-bar-buttons>
	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button
			href='<%="javascript:" + renderResponse.getNamespace() + "delete();"%>'
			icon="trash" id="deleteOrganizations" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
	</liferay-frontend:management-bar>
