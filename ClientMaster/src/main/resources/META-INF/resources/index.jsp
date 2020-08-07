<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
PortletURL clientListUrl = renderResponse.createRenderURL();
clientListUrl.setParameter("jspPage", "/view.jsp");

boolean editURL = ParamUtil.getBoolean(request, "editURL", false);

long clientId = ParamUtil.getLong(request, "clientId");
System.out.println("clientId  ............." + clientId);
ClientMaster clientMaster = null;
if (clientId != 0) {
editURL = true;
try {
	clientMaster = ClientMasterLocalServiceUtil.getClientMaster(clientId);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>
<aui:row>
<aui:col span="10">
<p>Add Client</p>
</aui:col>
<aui:col span="2">
<a class="btn btn-primary btn-default"
	name="myRegisterleave" type="submit"
	href="<%=clientListUrl.toString()%>">Client List</a>
</aui:col>

</aui:row>
<portlet:actionURL name="addClientMaster" var="addClientMasterURL" />
<portlet:actionURL name="editClientMaster" var="editClientMasterURL" />
<aui:form name="addClientMaster"
	action="<%=editURL != true ? addClientMasterURL.toString() : editClientMasterURL.toString()%>"
	method="post">
<liferay-ui:tabs names="Client Information,Financail Details" refresh="false">
		<!-- tab for basic information -->
		<liferay-ui:section>
			<%@ include file="addClientInfo.jsp"%>
		</liferay-ui:section>
		<liferay-ui:section>
			<%@ include file="financialDetails.jsp"%>
		</liferay-ui:section>
	</liferay-ui:tabs>
	<aui:button name="save" type="submit" value="save" />
	<aui:button name="cancel" type="cancel" value="cancel" />
	</aui:form>