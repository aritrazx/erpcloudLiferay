<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="java.util.List"%>
<%@include file="init.jsp"%>

<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
 <portlet:defineObjects />

 <liferay-theme:defineObjects />
<%

List<ClientMaster> clientList = new ArrayList<>();
clientList = ClientMasterLocalServiceUtil.getClientMasters(-1, -1);
System.out.println("List..............."+clientList);

PortletURL clientEditURL = renderResponse.createActionURL();
clientEditURL.setParameter("jspPage", "/index.jsp");

PortletURL  iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/view.jsp");

PortletURL clientAddURL = renderResponse.createActionURL();
clientAddURL.setParameter("jspPage", "/index.jsp");

PortletURL clientViewURL = renderResponse.createRenderURL();
clientViewURL.setParameter("jspPage", "/projectList.jsp");
%>
<h1>Client List</h1>
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Client")%>'
		url="<%=clientAddURL.toString()%>"/>
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl %>" orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = clientList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("projectListTemp", clientList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ClientMaster"
		modelVar="client">
		<liferay-ui:search-container-column-text name="Client Name"
			orderable="true" orderableProperty="clientName">
			<%=client.getClientName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Email" orderable="true"
			orderableProperty="emailId">
			<%=client.getEmailId()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="SkypeId"
			orderable="true" orderableProperty="skypeId">
			<%=client.getSkypeId()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Contact Person"
			orderable="true" orderableProperty="contactPerson">
			<%=client.getContactPerson()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Contact Number"
			orderable="true" orderableProperty="contactNumber">
			<%=client.getContactNumber()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				boolean editURL = true;
							clientEditURL.setParameter("clientId", String.valueOf(client.getClientId()));
							clientEditURL.setParameter("editURL", String.valueOf(editURL));

							clientViewURL.setParameter("clientId", String.valueOf(client.getClientId()));
			%>
			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=clientEditURL.toString()%>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon url="<%=clientViewURL.toString()%>" label="view"
					message="View Project" image="view" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>