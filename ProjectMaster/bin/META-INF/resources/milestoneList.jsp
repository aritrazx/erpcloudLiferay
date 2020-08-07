<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
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
long clientId = ParamUtil.getLong(request, "clientId");

List<Milestone> milList = new ArrayList<>();
DynamicQuery dynamicQuery = MilestoneLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
criterion3 = RestrictionsFactoryUtil.and(criterion3,
RestrictionsFactoryUtil.eq("clientId", clientId));
dynamicQuery.add(criterion3);
milList = MilestoneLocalServiceUtil.dynamicQuery(dynamicQuery);

%>


<aui:row>
	<aui:col span="6">
	<label><h3>Milestone</h3></label>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="6">
		<%if(milList.size()!=0){ %>
		Milestone Name : 
		</br>
		<%
			if (milList.size() <= 3) {
						for (int i = 0; i < milList.size(); i++) {
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=milList.get(i).getMilestoneName()%></b>
		</br>
		<%
			}
					} else {
						for (int i = 0; i < 3; i++) {
		%>
		<b style="color: #f48120;"><%=(i + 1) + ". "%><%=milList.get(i).getMilestoneName()%></b>
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