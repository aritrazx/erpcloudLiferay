<%@page import="com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectStatus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:success key="add-success" message="Status Name successfully added"></liferay-ui:success>
<liferay-ui:error key="add-error" message="Status Name not added"></liferay-ui:error>
<liferay-ui:error key="error" message="Status Name already exist"></liferay-ui:error>
<liferay-ui:error key="update-error" message="Status Name cannot be updated"></liferay-ui:error>

<%

//List<String> errorList = (List) renderRequest.getAttribute("error");
boolean editURL = false; 
String statusName = ParamUtil.getString(renderRequest, "statusName", StringPool.BLANK);
String addedDate = ParamUtil.getString(renderRequest, "addedDate", StringPool.BLANK);
List<ProjectStatus> projStatList = new ArrayList<ProjectStatus>();
long projectStatusId = ParamUtil.getLong(request, "projectStatusId",0);
//System.out.println("primary key###....."+project_status_id);
ProjectStatus ps = null;
if(projectStatusId!=0){
	editURL = true;
	try{
	ps = ProjectStatusLocalServiceUtil.getProjectStatus(projectStatusId);
	}catch(Exception ex){
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
<portlet:actionURL name="updateProjectStatus" var="updateProjectStatusURL" />

<aui:form name="projectStatus" action="<%=editURL!=true?projectStatusURL.toString():updateProjectStatusURL.toString() %>" method="post" >
<aui:input name="project_status_id" type="hidden" value="<%=projectStatusId %>"></aui:input>
<aui:input name="statusName" type="text" label="Status Name" placeholder="Status Name" value="<%=ps!=null?ps.getStatusName():"" %>">
<aui:validator name="required"></aui:validator>
</aui:input>
	<!-- <input name="statusColour" label="Status Colour"
		placeholder="Status Colour" id="myHsvPalette"
		 type="text" value="">
<div id="myHsvPalette" style="padding-left: 10px;"></div> -->
	<aui:input label="Status Colour" name="statusColour"
		placeholder="Status Colour" type="color"
		value="<%=ps != null ? ps.getStatusColor() : ""%>" />
	<aui:button name="button" type="submit" value="submit"></aui:button>
</br>
</br>
</aui:form>
<script type="text/javascript">
YUI().use(
		  'aui-color-picker-popover',
		  function(Y) {
		    var colorPicker = new Y.ColorPickerPopover(
		      {
		        trigger: '#myColorPickerPopover',
		        zIndex: 2
		      }
		    ).render();

		    colorPicker.on('select',
		      function(event) {
		        event.trigger.setStyle('backgroundColor', event.color);
		      }
		    );
		  }
		);
</script>
<script src="http://www.cts.test-portal.famocom.com/assets/js/jscolor.js"></script>

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

projStatList = ProjectStatusLocalServiceUtil.getProjectStatuses(-1, -1);
%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%	
				results = projStatList;			    
				total = results.size();
				searchContainer.setTotal(results.size());
				pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
			    pageContext.setAttribute("total", results.size());
			    pageContext.setAttribute("delta", results.size());
			    portletSession.setAttribute("projStatList", projStatList);
			%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ProjectStatus"
		modelVar="projStat">


		<liferay-ui:search-container-column-text name="Status Name"
			orderable="true" orderableProperty="statusName">
			<%= projStat.getStatusName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addedDate">
			<%= projStat.getAddedDate()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%  
			projectStatusEditURL.setParameter("projectStatusId", String.valueOf(projStat.getProjectStatusId()));
			projectStatusEditURL.setParameter("editURL", String.valueOf(editURL));
			projectStatusDeleteURL.setParameter("projectStatusId", String.valueOf(projStat.getProjectStatusId())); 
							 
						%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=projectStatusEditURL.toString() %>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=projectStatusDeleteURL.toString() %>" message="Delete"
				label="Delete" image="delete"></liferay-ui:icon-delete>
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>
