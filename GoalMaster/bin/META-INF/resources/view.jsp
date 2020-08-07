<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.GoalMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.GoalMasterLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/init.jsp"%>
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
	boolean editURL = false;
	long goal_id = ParamUtil.getLong(request, "goal_id");
	String goal = ParamUtil.getString(renderRequest, "goal", StringPool.BLANK);
	String goalDesc = ParamUtil.getString(renderRequest, "goalDesc", StringPool.BLANK);
	String addeddate = ParamUtil.getString(renderRequest, "addeddate", StringPool.BLANK);
	List<GoalMaster> goalMastList = new ArrayList<GoalMaster>();
	goalMastList = GoalMasterLocalServiceUtil.getGoalMasters(-1, -1);
	GoalMaster gm = null;
	if (goal_id != 0) {
		editURL = true;
		try {
			gm = GoalMasterLocalServiceUtil.getGoalMaster(goal_id);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL AddGoalMasterURL = renderResponse.createRenderURL();
	AddGoalMasterURL.setParameter("jspPage", "/META-INF/resources/addGoalMaster.jsp");

	PortletURL goalMasterEditURL = renderResponse.createRenderURL();
	goalMasterEditURL.setParameter("jspPage", "/META-INF/resources/addGoalMaster.jsp");

	PortletURL goalMasterDeleteURL = renderResponse.createActionURL();
	goalMasterDeleteURL.setParameter("javax.portlet.action", "deleteGoalMaster");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	iteratorUrl.setParameter("goal", goal);
	iteratorUrl.setParameter("goalDesc", goalDesc);
	iteratorUrl.setParameter("addeddate", addeddate);
%>
<liferay-ui:error key="delete-error"
	message="Sorry, This Goal Already in Use Somewhere, Please Check " />
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Goal Master")%>'
		url="<%=AddGoalMasterURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = goalMastList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("goalMastList", goalMastList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.GoalMaster"
		modelVar="goalMast">


		<liferay-ui:search-container-column-text name="Goal" orderable="true"
			orderableProperty="goalName">
			<%=goalMast.getGoalName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Goal Description"
			orderable="true" orderableProperty="goalDescription">
			<%=goalMast.getGoalDescription()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addedDate">
			<%=dateFormat.format(goalMast.getAddedDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				goalMasterEditURL.setParameter("goalId", String.valueOf(goalMast.getGoalId()));
				goalMasterEditURL.setParameter("editURL", String.valueOf(editURL));
				goalMasterDeleteURL.setParameter("goalId", String.valueOf(goalMast.getGoalId()));
							//System.out.println("primary key in jsp...."+rating_id);
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=goalMasterEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=goalMasterDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>