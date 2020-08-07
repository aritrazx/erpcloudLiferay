<%@page
	import="com.liferay.famocom.erpcloud.projectstatus.util.CustomComparatorUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectStatus"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
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
<liferay-ui:success key="add-success"
	message="Status added successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Status updated successfully"></liferay-ui:success>
<liferay-ui:success key="delete-success"
	message="Status deleted successfully"></liferay-ui:success>
<liferay-ui:error key="error" message="Status already exist"></liferay-ui:error>
<%
	//List<String> errorList = (List) renderRequest.getAttribute("error");
	boolean editURL = false;
	String statusName = ParamUtil.getString(renderRequest, "statusName", StringPool.BLANK);
	String addedDate = ParamUtil.getString(renderRequest, "addedDate", StringPool.BLANK);
	List<ProjectStatus> projStatList = new ArrayList<>();
	projStatList = ProjectStatusLocalServiceUtil.getProjectStatuses(-1, -1);
	long projectStatusId = ParamUtil.getLong(request, "projectStatusId");
	//System.out.println("primary key###....."+project_status_id);
	ProjectStatus ps = null;
	if (projectStatusId != 0) {
		editURL = true;
		try {
			ps = ProjectStatusLocalServiceUtil.getProjectStatus(projectStatusId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	//System.out.println("primary key....."+project_status_id);
%>

<%-- <div id="errDiv" class="errDiv">
	<%
	if (errorList != null) {
	%>
	<table>
	<%
	for (int i = 0; i < errorList.size(); i++) {
	%>
	<tr>
	<td><%=errorList.get(i)%></td>
	</tr>
	<%
	}
	%>
	</table>
	<%
	}
	%>
</div> --%>
<portlet:actionURL name="projectStatus" var="projectStatusURL" />
<portlet:actionURL name="updateProjectStatus"
	var="updateProjectStatusURL" />

<aui:form name="projectStatus"
	action="<%=editURL != true ? projectStatusURL.toString() : updateProjectStatusURL.toString()%>"
	method="post">
	<aui:input name="projectStatusId" type="hidden"
		value="<%=projectStatusId%>"></aui:input>
	<aui:input name="statusName" type="text" label="Status Name"
		placeholder="Status Name" value="<%=ps != null ? ps.getStatusName() : ""%>">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input label="Status Colour" name="statusColour"
		placeholder="Status Colour" type="color"
		value="<%=ps != null ? ps.getStatusColor() : ""%>" />
	<aui:button name="button" type="submit" value="submit"></aui:button>
	</br>
	</br>
</aui:form>

<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL projectStatusEditURL = renderResponse.createRenderURL();
	projectStatusEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL projectStatusDeleteURL = renderResponse.createActionURL();
	projectStatusDeleteURL.setParameter("javax.portlet.action", "deleteProjectStatus");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	iteratorUrl.setParameter("statusName", statusName);
	iteratorUrl.setParameter("addedDate", addedDate);
%>

<%
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("asc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	if (Validator.isNull(orderByType)) {
		orderByType = "asc";
	}

	OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol,
			orderByType);
	List<ProjectStatus> psSortList = ListUtil.copy(projStatList);
	ListUtil.sort(psSortList, orderByComparator);
	/* if (Validator.isNull(orderByCol)) {
	 orderByCol = "goal_name";
	} */
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="<%=orderByCol%>"
	orderByType="<%=orderByType%>" iteratorURL="<%=iteratorUrl%>">
	<liferay-ui:search-container-results>
		<%
			results = psSortList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("results", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ProjectStatus"
		modelVar="projStat">


		<liferay-ui:search-container-column-text name="Status Name"
			orderable="true" orderableProperty="statusName">
			<%=projStat.getStatusName()%>
		</liferay-ui:search-container-column-text>
		<%
			Date addDate = projStat.getAddedDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					String strDate = formatter.format(addDate);
		%>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addedDate">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<%
				projectStatusEditURL.setParameter("projectStatusId", String.valueOf(projStat.getProjectStatusId()));
				projectStatusEditURL.setParameter("editURL", String.valueOf(editURL));
				projectStatusDeleteURL.setParameter("projectStatusId1", String.valueOf(projStat.getProjectStatusId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=projectStatusEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon-delete
					url="<%=projectStatusDeleteURL.toString()%>" message="Delete"
					label="Delete" image="delete"></liferay-ui:icon-delete>
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>
