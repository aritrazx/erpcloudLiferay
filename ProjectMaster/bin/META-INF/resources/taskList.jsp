<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
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
long projectId = ParamUtil.getLong(request, "projectId");
List<ProjectTask> projTaskList = new ArrayList<ProjectTask>();

try {
	DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
	projTaskList = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("atmTempList: " + projTaskList.size());
} catch (Exception e) {
}
%>

<aui:row>
	<aui:col span="6">
	<label><h3>Tasks</h3></label>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="6">
		<%if(projTaskList.size()!=0){ %>
		Task Name : 
		</br>
		<%
			if (projTaskList.size() <= 3) {
						for (int i = 0; i < projTaskList.size(); i++) {
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=projTaskList.get(i).getTaskName()%></b>
		</br>
		<%
			}
					} else {
						for (int i = 0; i < 3; i++) {
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=projTaskList.get(i).getTaskName()%></b>
		</br>
		<%
			}
					}
		%>
		</br>
		<%} else { %>
		<b style="color: #ADD8E6;">No Record Found</b>
		<%} %>
	</aui:col>
</aui:row>