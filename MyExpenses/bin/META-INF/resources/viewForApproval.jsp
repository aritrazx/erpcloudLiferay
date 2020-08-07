<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpenseEntryHistory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
List<ExpenseEntryHistory> expenseHistoryList = (List<ExpenseEntryHistory>)renderRequest.getAttribute("expenseHistoryList");
if(Validator.isNotNull(expenseHistoryList)){
	   System.out.println("======== expenseHistoryList :-"+expenseHistoryList.toString());
}
	String expenseId = ParamUtil.get(request, "expenseId","");	
    ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.getExpenseEntry(Long.valueOf(expenseId));
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy");
	
	PortletURL myExpUpdateURL = renderResponse.createActionURL();
	myExpUpdateURL.setParameter("javax.portlet.action", "myExpUpdate");
	myExpUpdateURL.setParameter("expenseId", expenseId);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/viewForApproval.jsp");
	renderRequest.setAttribute("iteratorUrl", iteratorUrl);
	
	//String strDate = formatter.format(addDate);
	
%>

<portlet:actionURL name="interviewAdd" var="interviewAddURL" />
<aui:form name="interview" action="<%=myExpUpdateURL.toString() %>" method="post">
	<aui:row>
		<aui:col span="6">
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Project Name :</label>
				</aui:col>
				<aui:col span="6">
				    <%
						ProjectMaster projectMaster=ProjectMasterLocalServiceUtil.getProjectMaster(expEntry.getProjectId());
						String proj=projectMaster.getProjectName();
						%>
					<b style=" color: #f48120;"><%=proj%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Apply Date :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=formatter.format(expEntry.getCreateDate()) %></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Expence Date :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=formatter.format(expEntry.getExpDate())%></b>
				</aui:col>
			</aui:row>
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Title :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=expEntry.getTitle()%></b>
				</aui:col>
			</aui:row>
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Description :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=expEntry.getDescription()%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Amount:</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"><%=expEntry.getAmount()%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Status:</label>
				</aui:col>
				<aui:col span="6">
				<b style=" color: #f48120;">
				    <%
								 if(expEntry.getStatus()==1){
								%>
								Approved by manager
								<%
								}
								%>
					</b>
				</aui:col>
			</aui:row>
			
			<aui:input name="remark" type="textarea" label="Remark" value=""></aui:input>
			<aui:input name="approved" type="radio"  label="Approved" value="1"  />
			<aui:input name="approved" type="radio"  label="Reject" value="2"  />

		</aui:col>
		<aui:col span="6">
			<%-- <%
			 getRecruit.
			%> --%>
		</aui:col>

	</aui:row>
<aui:button name="save" type="submit"></aui:button>
</aui:form>

<%  if(Validator.isNotNull(expenseHistoryList)){%>
<div><%@ include file="history-list.jsp" %> </div>
<%} %>