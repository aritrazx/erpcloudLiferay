<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
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

<%
	List<AddTeamMember> atmList = new ArrayList<>();
	long val = ParamUtil.getLong(request, "val");
	System.out.println("val in fetch project...." + val);
	try {
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(val));
		atmList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("atmList: " + atmList.size());
	} catch (Exception e) {
	}
%>
<%
	if (atmList.size() != 0) {
%>
<option value="">All Project</option>
<%
	} else {
		if (val == 0) {
%>
<option value="">All Project</option>
<%
	} else {
%>
<option value="">No Project Found</option>
<%
	}

	}
%>
<%
	try {
		if(val!=0){
		for (AddTeamMember obj : atmList) {
			ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(obj.getProjectId());
			System.out.println("pm: " + pm.getProjectId() + "---" + pm.getProjectName());
%>
<option value="<%=pm.getProjectId()%>"><%=pm.getProjectName()%></option>
<%
	}
		} else {
			List<ProjectMaster> pmList = ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
			for(ProjectMaster pm : pmList){
			%>
			<option value="<%=pm.getProjectId()%>"><%=pm.getProjectName()%></option>
			<%
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>