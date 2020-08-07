<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.InterviewEvaluation"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectRoleLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectRole"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL evaluationuUpdateURL = renderResponse.createRenderURL();
	evaluationuUpdateURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL evaluationDeleteURL = renderResponse.createActionURL();
	evaluationDeleteURL.setParameter("javax.portlet.action", "evaluationDelete");

	

	List<ProjectRole> role = ProjectRoleLocalServiceUtil.getProjectRoles(-1, -1);
	List<InterviewEvaluation> evaluationList = InterviewEvaluationLocalServiceUtil.getInterviewEvaluations(-1, -1);

	String projectRole = ParamUtil.get(renderRequest, "projectRole", StringPool.BLANK);
	String evaluationName = ParamUtil.get(renderRequest, "evaluation", StringPool.BLANK);
	long evaluationId = ParamUtil.getLong(renderRequest, "evaluationId");
	/* //String evaluationName = ParamUtil.get(renderRequest, "evaluation", StringPool.BLANK); */
	
	String Action = ParamUtil.get(renderRequest, "action", StringPool.BLANK);

	System.out.println("evaluationId get:" + evaluationId);

	boolean editURL = false;
	InterviewEvaluation evaluationTemp = null;
	if (evaluationId != 0) {
		editURL = true;
		try {
			evaluationTemp = InterviewEvaluationLocalServiceUtil.getInterviewEvaluation(evaluationId);
			System.out.println("template:" + evaluationTemp);
			System.out.println("editURL:" + editURL);

		} catch (Exception e) {

		}
	}
	
	iteratorUrl.setParameter("projectRole", projectRole);
	iteratorUrl.setParameter("evaluation", evaluationName);
%>

<portlet:actionURL name="evaluationAdd" var="evaluationAddURL" />
<portlet:actionURL name="evaluationEdit" var="evaluationEditURL" />
<aui:form name="evaluation"
	action="<%=editURL != true ? evaluationAddURL.toString():evaluationEditURL.toString()%>"
	method="post">
	<aui:input name="evaluationId" type="hidden" value="<%=evaluationId%>" />
	<aui:row>
		<aui:col span="4">
			<aui:select name="projectRole"
				label="Possion/Post" id="ProjectRole" value="">
				<%
					for (ProjectRole project:role) {
							if(evaluationTemp!=null){			
				%>
				<aui:option value="<%=project.getRoleId()%>" selected="<%=project.getRoleId()==evaluationTemp.getRoleId() %>"><%=project.getRoleName()%></aui:option>
				<%}else{
				%>
						<aui:option value="<%=project.getRoleId()%>"><%=project.getRoleName()%></aui:option>
						
						<%
						}
					}
				%>
			</aui:select>
		</aui:col>
		<aui:col span="4">
			<aui:input name="evaluation" type="text"
				value="<%= evaluationTemp != null? evaluationTemp.getEvaluationName():"" %>" label="Evaluation" placeholder="Evaluation" />
		</aui:col>
		<aui:col span="4">
		<aui:button name="save" type="submit"></aui:button>
		</aui:col>
	</aui:row>
	
</aui:form>

<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = evaluationList;
					total = evaluationList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("empType", evaluationList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.InterviewEvaluation"
		modelVar="type">

		<%
			ProjectRole pr = ProjectRoleLocalServiceUtil.getProjectRole(type.getRoleId());
		%>
		<liferay-ui:search-container-column-text name="Possion/Post"
			orderable="true" orderableProperty="post">
			<%=pr.getRoleName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Evaluation Name"
			orderable="true" orderableProperty="evaluationName">
			<%=type.getEvaluationName()%>

		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu >
				<%
					System.out.println("type.getEvaluationId():-"+String.valueOf(type.getEvaluationId()));
					evaluationuUpdateURL.setParameter("evaluationId", String.valueOf(type.getEvaluationId()));
					//evaluationuUpdateURL.setParameter("evaluationName",type.getEvaluationName());
					evaluationDeleteURL.setParameter("evaluationId", String.valueOf(type.getEvaluationId()));
				//evaluationEditURL.setParameter("id", String.valueOf(type.getEvaluationId()()));
				%>

				<liferay-ui:icon url="<%=evaluationuUpdateURL.toString()%>" message="edit"
					image="edit" />
				<%-- <%
					System.out.println("type.getEvaluationId():-"+String.valueOf(type.getEvaluationId()));
					evaluationuUpdateURL.setParameter("evaluationId", String.valueOf(type.getEvaluationId()));
					evaluationuUpdateURL.setParameter("evaluationName",type.getEvaluationName());
					evaluationDeleteURL.setParameter("evaluationId", String.valueOf(type.getEvaluationId()));
				//evaluationEditURL.setParameter("id", String.valueOf(type.getEvaluationId()()));
				%> --%>
				<liferay-ui:icon-delete url="<%= evaluationDeleteURL.toString()%>"
					message="delete" image="delete" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator  ></liferay-ui:search-iterator>
</liferay-ui:search-container>