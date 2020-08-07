
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalDetails"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	boolean editURL = false;
	long goaldetailId = ParamUtil.getLong(request, "goaldetailId");
	String parameter = ParamUtil.getString(renderRequest, "parameter", StringPool.BLANK);
	String scaleDesc = ParamUtil.getString(renderRequest, "scaleDesc", StringPool.BLANK);
	String selectGoal = ParamUtil.getString(renderRequest, "selectGoal", StringPool.BLANK);
	String addeddate = ParamUtil.getString(renderRequest, "addeddate", StringPool.BLANK);
	List<GoalDetails> golDetList = new ArrayList<GoalDetails>();
	golDetList = GoalDetailsLocalServiceUtil.getGoalDetailses(-1, -1);
	GoalDetails gt = null;
	if (goaldetailId != 0) {
		editURL = true;
		try {
			gt = GoalDetailsLocalServiceUtil.getGoalDetails(goaldetailId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>
<aui:row>
	<liferay-ui:header title="Add Goal Details" backLabel="Back"
		backURL="<%=backURL.toString()%>"></liferay-ui:header>
</aui:row>
<portlet:actionURL name="goalDetails" var="goalDetailsURL" />
<portlet:actionURL name="updateGoalDetails" var="updateGoalDetailsURL" />
<aui:form name="goalDetails"
	action="<%=editURL != true ? goalDetailsURL.toString() : updateGoalDetailsURL.toString()%>"
	method="post">
	<aui:input name="goaldetailId" type="hidden"
		value="<%=goaldetailId%>"></aui:input>
	<aui:select name="selectGoal" label="Select Goal">
		<aui:option value="">Select Goal</aui:option>
		<aui:validator name="required"></aui:validator>
		<%
			try {
						List<GoalMaster> gmList = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);
						for (GoalMaster obj : gmList) {
							if (gt != null) {
								if (obj.getGoalId() == gt.getGoalId()) {
		%>
		<option value="<%=obj.getGoalId()%>" selected><%=obj.getGoalName()%></option>


		<%
			} else {
		%>
		<option value="<%=obj.getGoalId()%>"><%=obj.getGoalName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getGoalId()%>"><%=obj.getGoalName()%></option>
		<%
			}

						}
					} catch (Exception e) {
						e.printStackTrace();

					}
		%>
	</aui:select>
	<aui:input name="parameter" type="text" label="Parameter" required="true"
		placeholder="Parameter"
		value="<%=gt != null ? gt.getParameter() : ""%>">
	</aui:input>
	<aui:input name="scaleDesc" type="textarea" label="Scale Description" required="true"
		placeholder="Scale Description"
		value="<%=gt != null ? gt.getScale() : ""%>">
	</aui:input>
	<aui:button name="button" type="submit" value="submit"></aui:button>
</aui:form>