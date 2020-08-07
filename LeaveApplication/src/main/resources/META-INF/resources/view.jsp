<%@page
	import="com.liferay.famocom.erpcloud.leaveapplication.model.LeaveTypeDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL myRegisterLeaveURL = renderResponse.createRenderURL();
	myRegisterLeaveURL.setParameter("jspPage", "/META-INF/resources/myRegisterLeave.jsp");
%>
<aui:row>
	<aui:col span="10">
		<h1>Apply for leave: Choose leave type</h1>
	</aui:col>
	<aui:col span="2">
		<a class="btn btn-primary btn-default" name="myRegisterleave"
			type="submit" href="<%=myRegisterLeaveURL.toString()%>">My
			Applied Leave</a>
	</aui:col>
</aui:row>
<%@ include file="/init.jsp"%>
<style>
 .management-bar-header-right{
  display:none;
}
.card{
  padding-top: 5px;
}
.table-list > tbody > tr {
   height: auto;
   padding:0px;
}
.style-name {
   font-size: 1.4em;
   font-weight: bold;
   padding-left: 10%;
   padding-top: 10px;
}
.card-footer-left{
    float: left;
    padding-left: 10%; 
    min-height:100px;
    padding-bottom:10px;
}
.name-span{
    background: transparent !important;
}

.aspect-ratio-bg-center{
    display:none;
}

.card-action-buttons{
    font-weight: bold;
    font-size: 1.2em;
}

.full-label{
    border-bottom: 1px solid;
    padding-left: 0px;
}

.full-label label{
    font-size:1.1em;
    font-weight: bold;
}
</style>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL leaveApplyURL = renderResponse.createRenderURL();
	int count = 0;
	List<LeaveTypeDetails> leaveTypes = (List<LeaveTypeDetails>) renderRequest.getAttribute("leaveTypes");

	if (leaveTypes != null) {
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
</liferay-portlet:renderURL>
<liferay-ui:search-container
	emptyResultsMessage="no-channels-were-found" id="leaveSummary">
	<liferay-ui:search-container-results results="<%=leaveTypes%>" />
	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.leaveapplication.model.LeaveTypeDetails"
		modelVar="ltype">
		<%
			row.setCssClass("col-md-3 col-sm-6 col-xs-12");
						int cclass = count % 5;
		%>
		<liferay-ui:search-container-column-text>
		<%
		leaveApplyURL.setParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
		leaveApplyURL.setParameter("leaveTypeId", String.valueOf(ltype.getLeaveTypeId()));
		
		%>
			<liferay-frontend:vertical-card cssClass="entry-display-style"
				resultRow="<%=row%>">
				<liferay-frontend:vertical-card-header>
					<div class="style-name">
						<%
							if (cclass == 0) {
						%>
						<span class="name-span list-group-item-success"> <%
 	} else if (cclass == 1) {
 %> <span class="name-span list-group-item-warning"> <%
 	} else if (cclass == 2) {
 %> <span class="name-span list-group-item-info"> <%
 	} else if (cclass == 3) {
 %> <span class="name-span list-group-item-default"> <%
 	} else if (cclass == 4) {
 %> <span class="name-span list-group-item-danger"> <%
 	}
 %><%=ltype.getLeaveName()%>(<%=ltype.getAbbreviation()%>)
									</span>
					</div>
					<%
						count++;
					%>
				</liferay-frontend:vertical-card-header>

				<liferay-frontend:vertical-card-footer>
					<div class="card-footer-left">
						<div class="style-lang">
							Available :
							<%=ltype.getClosingBal()%></div>
						<div class="style-lang">
							Taken :
							<%=ltype.getTakenApplied()%></div>
						<div class="style-type">
							Entitled :
							<%=ltype.getMaxCreditDay()%></div>
						<%
							if (ltype.isEligible()) {
						%>
						<div class="card-action-buttons">
							<a href="<%=leaveApplyURL.toString()%>" data-trigger="focus"
								class="text-success">Apply Now</a>
						</div>
						<%
							} else if (ltype.getClosingBal() > 0) {
						%>
						<div>
							<label class="text-warning">Not Eligible</label>
						</div>
						<%
							}
						%>
					</div>
				</liferay-frontend:vertical-card-footer>
			</liferay-frontend:vertical-card>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>



	<liferay-ui:search-iterator markupView="lexicon" paginate="<%=false%>" />


</liferay-ui:search-container>
<%
	}
%>