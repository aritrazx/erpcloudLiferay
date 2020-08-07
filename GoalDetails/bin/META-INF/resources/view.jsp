<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.GoalDetailsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/init.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"prefix="liferay-frontend"%>

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
	
	PortletURL AddGoalDetailsURL = renderResponse.createRenderURL();
	AddGoalDetailsURL.setParameter("jspPage", "/META-INF/resources/addGoalDetails.jsp");
	
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL goalDetailsEditURL = renderResponse.createRenderURL();
	goalDetailsEditURL.setParameter("jspPage", "/META-INF/resources/addGoalDetails.jsp");
	
	PortletURL goalDetailsDeleteURL = renderResponse.createActionURL();
	goalDetailsDeleteURL.setParameter("javax.portlet.action", "deleteGoalDetails");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	iteratorUrl.setParameter("goalId", selectGoal);
	iteratorUrl.setParameter("parameter", parameter);
	iteratorUrl.setParameter("scale", scaleDesc);
	iteratorUrl.setParameter("addeddate", addeddate);
%>
<liferay-ui:error key="delete-error"
	message="Sorry, This Goal Deails Already in use Somewhere" />
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Goal Details")%>'
		url="<%=AddGoalDetailsURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = golDetList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("golDetList", golDetList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.GoalDetails"
		modelVar="goalDet">

		<%
			GoalMaster gm = GoalMasterLocalServiceUtil.getGoalMaster(goalDet.getGoalId());
		%>
		<liferay-ui:search-container-column-text name="Goal" orderable="true"
			orderableProperty="goalId">
			<%=gm.getGoalName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Parameter"
			orderable="true" orderableProperty="parameter">
			<%=goalDet.getParameter()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Scale" orderable="true"
			orderableProperty="scale">
			<%=goalDet.getScale()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addeddate">
			<%=dateFormat.format(goalDet.getAddedDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				goalDetailsEditURL.setParameter("goaldetailId", String.valueOf(goalDet.getGoaldetailId()));
							goalDetailsEditURL.setParameter("editURL", String.valueOf(editURL));
							//System.out.println("primary key in jsp...."+ratingId);
				goalDetailsDeleteURL.setParameter("goaldetailId", String.valueOf(goalDet.getGoaldetailId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=goalDetailsEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=goalDetailsDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>