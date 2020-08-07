<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CompanyPolicy"%>
<%@page import="java.util.List"%>
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
<%
boolean isViewPermission = false;
try {
	isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
			"TimesheetSetting", "TIMESHEET_SETTING_VIEW");
	System.out.print("isViewPermission " + isViewPermission);
} catch (Exception exception) {
	exception.printStackTrace();
}
if (isViewPermission) {

%>
<h1>Timesheet Setting Policy</h1>
<liferay-ui:error key="error"
	message="Timesheet Policy already created you can only edit!"></liferay-ui:error>
<%
	boolean editURL = false;
	long companyPolicyId = ParamUtil.getLong(request, "companyPolicyId");
	List<CompanyPolicy> cpList = CompanyPolicyLocalServiceUtil.getCompanyPolicies(-1, -1);
	CompanyPolicy cp = null;
	try {
		if (companyPolicyId != 0) {
			//System.out.println("inside if....");
			editURL = true;
			try {
				cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(companyPolicyId);
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	PortletURL cpEditURL = renderResponse.createRenderURL();
	cpEditURL.setWindowState(LiferayWindowState.NORMAL);
	cpEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	String isStatus = "monthly";
	if (cp != null) {
		if (cp.getCheckStatus() == 1) {
			isStatus = "monthly";
		} else if (cp.getCheckStatus() == 2) {
			isStatus = "weekly";
		} else if (cp.getCheckStatus() == 3) {
			isStatus = "biweekly";
		} else {
			isStatus = "daily";
		}
	}
%>
<portlet:actionURL name="companyPolicy" var="companyPolicyURL" />
<portlet:actionURL name="updateCompanyPolicy"
	var="updateCompanyPolicyURL" />
<aui:form name="companyPolicy"
	action="<%=editURL != true ? companyPolicyURL.toString() : updateCompanyPolicyURL.toString()%>"
	method="post">
	<aui:input name="companyPolicyId" type="hidden"
		value="<%=companyPolicyId%>"></aui:input>
	<aui:row>
		<aui:col span="2">
			<div class="col-md-10" style="padding-top: 10px;">
				<label>Type of Policy:</label>
			</div>
		</aui:col>
		<aui:col span="2">
			<aui:input name="checkStatus" type="radio" label="Monthly"
				checked="<%=isStatus == "monthly"%>" value="1"></aui:input>
		</aui:col>
		<aui:col span="2">
			<aui:input name="checkStatus" type="radio" label="Weekly"
				checked="<%=isStatus == "weekly"%>" value="2"></aui:input>
		</aui:col>
		<aui:col span="2">
			<aui:input name="checkStatus" type="radio" label="BiWeekly"
				checked="<%=isStatus == "biweekly"%>" value="3"></aui:input>
		</aui:col>
		<aui:col span="2">
			<aui:input name="checkStatus" type="radio" label="Daily"
				checked="<%=isStatus == "daily"%>" value="4"></aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="4">
			<div class="col-md-10" style="padding-top: 10px;">
				<%-- <aui:select name="lockingEvent" label="Days for Locking">
	<%
 		if(cp!=null){
 			//System.out.println("cp.getCheckStatus()...."+cp.getCheckStatus());
	%>	
	<option value="1" <%=(cp.getDaysLocking()==1)?"selected":"" %>>1 Day</option>
	<option value="2" <%=(cp.getDaysLocking()==2)?"selected":""  %>>2 Days</option>
	<option value="3" <%=(cp.getDaysLocking()==3)?"selected":"" %>>3 Days</option>
<%
 	}else{
 	    
%>
<option value="1" >1 Day</option>
<option value="2" >2 Days</option>
<option value="3" >3 Days</option>


<%
 	}
%>
	</aui:select> --%>
				<aui:input name="lockingEvent" label="Days for Locking" type="text"
					value="<%=cp != null ? cp.getDaysLocking() : ""%>">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="digits"></aui:validator>
				</aui:input>
			</div>
		</aui:col>
		<%-- <aui:col span="2">
	<aui:input name="checkStatus" type="radio" label="Monthly" checked="<%=isStatus == "monthly"%>" value="1"></aui:input>
	</aui:col>
	<aui:col span="2">
	<aui:input name="checkStatus" type="radio" label="Weekly" checked="<%=isStatus == "weekly"%>" value="2"></aui:input>
	</aui:col>
	<aui:col span="2">
	<aui:input name="checkStatus" type="radio" label="Daily" checked="<%=isStatus == "daily"%>" value="3"></aui:input>
	</aui:col> --%>
		<aui:col span="2">
			<div class="col-md-2" style="padding-top: 30px;">
				<aui:button name="button" type="submit" value="submit"></aui:button>
			</div>
		</aui:col>
	</aui:row>
</aui:form>

<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = cpList;
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
		className="com.liferay.famocom.erpcloud.model.CompanyPolicy"
		modelVar="tsEntry">
		<%
			String strDate = "";
					if (tsEntry != null) {
						Date addDate = tsEntry.getAddedDate();
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
						strDate = formatter.format(addDate);
					}
		%>

		<liferay-ui:search-container-column-text name="Added Date"
			orderableProperty="entry_date">
			<%=strDate%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Number of Days To lock"
			orderableProperty="project_id">
			<%=tsEntry.getDaysLocking()%>
		</liferay-ui:search-container-column-text>
		<%
			String status = "";
					if (tsEntry.getCheckStatus() == 1) {
						status = "Monthly";
					} else if (tsEntry.getCheckStatus() == 2) {
						status = "Weekly";
					} else if (tsEntry.getCheckStatus() == 3) {
						status = "BiWeekly";
					} else {
						status = "Daily";
					}
		%>
		<liferay-ui:search-container-column-text name="Status type"
			orderableProperty="project_task_id">
			<%=status%>
		</liferay-ui:search-container-column-text>
		<%
			String modifiedDate = "not modified yet";
					if (Validator.isNotNull(tsEntry.getModifiedDate())) {
						Date modDate = tsEntry.getModifiedDate();
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM,yyyy");
						modifiedDate = formatter1.format(modDate);
					}
		%>
		<liferay-ui:search-container-column-text name="Modified Date"
			orderableProperty="work_description">
			<%=modifiedDate%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<%
				cpEditURL.setParameter("companyPolicyId", String.valueOf(tsEntry.getCompanyPolicyId()));
							//tsEntryDeleteURL.setParameter("editURL", "false");
			%>

			<liferay-ui:icon-menu markupView="lexicon">
				<liferay-ui:icon url="<%=cpEditURL.toString()%>" label="Edit"
					message="Edit" image="edit" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%
 }else{
%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Timesheet Setting</label>
</div>
<%    
}
%>