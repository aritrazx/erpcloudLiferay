<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.EvaluationLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Evaluation"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
/* boolean editURL = false; */
long evaluationId = ParamUtil.getLong(request, "evaluationId");
/* Evaluation ev = null;
if (evaluationId != 0) {
	editURL = true;
	try {
		ev = EvaluationLocalServiceUtil.getEvaluation(evaluationId);
	} catch (Exception ex) {
		ex.getMessage();
	}
}
 */
/* String selectEmployee = ParamUtil.getString(renderRequest, "selectEmployee", StringPool.BLANK);
String evalMessage = ParamUtil.getString(renderRequest, "evalMessage", StringPool.BLANK);
String evalDate = ParamUtil.getString(renderRequest, "evalDate", StringPool.BLANK);
String myRating = ParamUtil.getString(renderRequest, "myRating", StringPool.BLANK); */

List<Evaluation> evalList = new ArrayList<>();
evalList = EvaluationLocalServiceUtil.getEvaluations(-1, -1);

/* PortletURL evaluationShowURL = renderResponse.createRenderURL();
evaluationShowURL.setWindowState(LiferayWindowState.NORMAL);
evaluationShowURL.setParameter("jspPage", "/META-INF/resources/evaluationForm.jsp"); */

/* PortletURL evaluationEditURL = renderResponse.createRenderURL();
evaluationEditURL.setWindowState(LiferayWindowState.NORMAL);
evaluationEditURL.setParameter("jspPage", "/META-INF/resources/evaluationForm.jsp"); */

PortletURL evaluationDeleteURL = renderResponse.createActionURL();
evaluationDeleteURL.setWindowState(LiferayWindowState.NORMAL);
evaluationDeleteURL.setParameter("javax.portlet.action", "deleteEvaluation");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

/* iteratorUrl.setParameter("employeeId", selectEmployee);
iteratorUrl.setParameter("evalMessage", evalMessage);
iteratorUrl.setParameter("evalDate", evalDate);
iteratorUrl.setParameter("evalRating", myRating); */

%>

<%-- <aui:form name="evaluationShow" action="<%=evaluationShowURL%>"
	method="post">
	<aui:input name="evaluationId" type="hidden" value="<%=evaluationId%>"></aui:input>
	<aui:row>
		<aui:col span="9">
		</aui:col>
		<aui:col span="3">
			<aui:button name="button" type="submit" value="Add Evaluation"></aui:button>
		</aui:col>
	</aui:row>
</aui:form> --%>
<%-- <liferay-frontend:add-menu>
  <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "Add Evaluation") %>' url="<%=evaluationShowURL.toString()%>" />
</liferay-frontend:add-menu> --%>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = evalList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("evalList", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Evaluation"
		modelVar="eval">

<%
			Employee emp = EmployeeLocalServiceUtil.getEmployee(eval.getEmployeeId());
%>
		<liferay-ui:search-container-column-text name="Employee Name"
			 orderableProperty="employeeId">
			<%=emp.getFirstName()%>
			<%=emp.getLastName()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Evaluation Message"
			 orderableProperty="evalMessage">
			<%=eval.getEvalMessage()%>
		</liferay-ui:search-container-column-text>
		<%
		Date addDate = eval.getEvalDate();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
		String strDate = formatter.format(addDate);
		%>
		<liferay-ui:search-container-column-text name="Evaluation Date"
			 orderableProperty="evalDate">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%
		User userDetail = UserLocalServiceUtil.getUser(eval.getEvaluatedBy());
		%>
		<liferay-ui:search-container-column-text name="Evaluated By">
			<%=userDetail.getFirstName()%>
			<%=userDetail.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%
		int evalRate = eval.getEvalRating();
		String star = null;
		if(evalRate==1){
			star = "*";
		}
		if(evalRate==2){
			star = "**";
		}
		if(evalRate==3){
			star = "***";
		}
		if(evalRate==4){
			star = "****";
		}
		if(evalRate==5){
			star = "*****";
		}
		
		%>
		<%-- <liferay-ui:search-container-column-text name="Evaluation Rating"
			orderable="true" orderableProperty="evalRating">
			<%=star%>
		</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Action" cssClass="actionCol">

			<%
			/* evaluationEditURL.setParameter("evaluationId", String.valueOf(eval.getEvaluationId()));
			evaluationEditURL.setParameter("editURL", String.valueOf(editURL)); */
			evaluationDeleteURL.setParameter("evaluationId", String.valueOf(eval.getEvaluationId()));
							/* activeURL.setParameter("project_id", String.valueOf(projMast.getProject_id()));
							inActiveURL.setParameter("project_id", String.valueOf(projMast.getProject_id())); */
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<%-- <liferay-ui:icon url="<%=evaluationEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" /> --%>
				<liferay-ui:icon-delete url="<%=evaluationDeleteURL.toString()%>"
					label="Delete" message="Delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>