<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
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
List<AddTeamMember> teamMemList = new ArrayList<AddTeamMember>();
List<Employee> empList = new ArrayList<>();
List<Employee> empTempList = new ArrayList<>();
try {
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
	/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("isProjectManager", true)); */
	dynamicQuery.add(criterion3);
	teamMemList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("atmTempList: " + teamMemList.size());
} catch (Exception e) {
}
for(int i=0;i<teamMemList.size();i++){
	DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("employeeId", teamMemList.get(i).getEmployeeId());
	/* criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("isProjectManager", true)); */
	dynamicQuery.add(criterion3);
	empTempList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
	empList.addAll(empTempList);
}
%>

<aui:row>
	<aui:col span="6">
	<label><h3>Team Members</h3></label>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="6">
		<%if(empList.size()!=0){ %>
		Member Name : 
		</br>
		<%
			if (empList.size() <= 3) {
						for (int i = 0; i < empList.size(); i++) {
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=empList.get(i).getFirstName() + " " + empList.get(i).getLastName()%></b>
		</br>
		<%
			}
					} else {
						for (int i = 0; i < 3; i++) {
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=empList.get(i).getFirstName() + " " + empList.get(i).getLastName()%></b>
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