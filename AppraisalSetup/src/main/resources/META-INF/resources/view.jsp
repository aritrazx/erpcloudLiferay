<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");

	PortletURL addAppraisalSetupURL = renderResponse.createRenderURL();
	addAppraisalSetupURL.setParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");

	List<AppraisalSetup> appSetupList = new ArrayList<AppraisalSetup>();
	appSetupList = AppraisalSetupLocalServiceUtil.getAppraisalSetups(-1, -1);

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL appraisalSetupEditURL = renderResponse.createRenderURL();

	PortletURL activeAppraisalURL = renderResponse.createActionURL();
	activeAppraisalURL.setParameter("javax.portlet.action", "activeAppraisalSetting");

	PortletURL inActiveAppraisalURL = renderResponse.createActionURL();
	inActiveAppraisalURL.setParameter("javax.portlet.action", "inActiveAppraisalSetting");

	PortletURL appraisalSetupDeleteURL = renderResponse.createActionURL();
	appraisalSetupDeleteURL.setParameter("javax.portlet.action", "deleteAppraisalSetup");
%>



<liferay-ui:search-container delta="6"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = appSetupList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.AppraisalSetup"
		modelVar="var">
		<liferay-ui:search-container-column-text name="Financial Year"
			orderable="true">
			<%=var.getFinancialYear()%>
		</liferay-ui:search-container-column-text>

		<%
			String strFromDateCycle = StringPool.BLANK;
					String strToDateCycle = StringPool.BLANK;
					Date fromDateCycle = var.getFromDateCycle();
					if (Validator.isNotNull(fromDateCycle)) {
						strFromDateCycle = formatter.format(fromDateCycle);
					}
					Date toDateCycle = var.getToDateCycle();
					if (Validator.isNotNull(toDateCycle)) {
						strToDateCycle = formatter.format(toDateCycle);
					}
		%>
		<liferay-ui:search-container-column-text name="Performance Cycle"
			orderable="true">
			<%=strFromDateCycle%> to <%=strToDateCycle%>
		</liferay-ui:search-container-column-text>
		<%
			String strFromDateSubmission = StringPool.BLANK;
					String strToDateSubmission = StringPool.BLANK;
					Date fromDateSubmission = var.getFromDateSubmission();
					if (Validator.isNotNull(fromDateSubmission)) {
						strFromDateSubmission = formatter.format(fromDateSubmission);
					}
					Date toDateSubmission = var.getToDateSubmission();
					if (Validator.isNotNull(toDateSubmission)) {
						strToDateSubmission = formatter.format(toDateSubmission);
					}
		%>
		<liferay-ui:search-container-column-text name="Submission Period"
			orderable="true">
			<%=strFromDateSubmission%> to <%=strToDateSubmission%>
		</liferay-ui:search-container-column-text>
		<%
			String status = StringPool.BLANK;
			if (var.getIsActive() == 1) {
				status = "Open";
		%>
		<%
			} else {
				status = "Closed";
		%>
		<%
			}
		%>
		<liferay-ui:search-container-column-text name="Status"
			cssClass="statusColor" orderable="true">
			<%=status%>
		</liferay-ui:search-container-column-text>
		<%
			String strAddedDate = StringPool.BLANK;
					Date addedDate = var.getAddedDate();
					if (Validator.isNotNull(addedDate)) {
						strAddedDate = formatter.format(addedDate);
					}
		%>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true">
			<%=strAddedDate%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					appraisalSetupEditURL.setParameter("appraisalSettingId",
											String.valueOf(var.getAppraisalSettingId()));
									appraisalSetupEditURL.setParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");

									activeAppraisalURL.setParameter("appraisalSettingId",
											String.valueOf(var.getAppraisalSettingId()));
									//activeAppraisal.setParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");

									inActiveAppraisalURL.setParameter("appraisalSettingId",
											String.valueOf(var.getAppraisalSettingId()));
									//inActiveAppraisal.setParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");

									appraisalSetupDeleteURL.setParameter("appraisalSettingId",
											String.valueOf(var.getAppraisalSettingId()));
				%>

				<liferay-ui:icon url="<%=appraisalSetupEditURL.toString()%>"
					message="Edit" image="edit" />
				<%-- <%
					if (var.getIsActive() == 1) {
				%>
				<liferay-ui:icon url="<%=inActiveAppraisalURL.toString()%>"
					message="Inactive" image="activate" /> --%>
				<%
					/* } else  */if (var.getIsActive() == 0) {
				%>
				<liferay-ui:icon url="<%=activeAppraisalURL.toString()%>"
					message="Active" image="activate" />
				<liferay-ui:icon url="<%=appraisalSetupDeleteURL.toString()%>"
					message="Delete" image="delete" />
				<%
					}
				%>

			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Appraisal Setting")%>'
		url="<%=addAppraisalSetupURL.toString()%>" />
</liferay-frontend:add-menu>

