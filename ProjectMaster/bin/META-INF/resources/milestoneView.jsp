<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
<%@page import="com.liferay.famocom.erpcloud.service.BillingTableLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.BillingTable"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
boolean editURL = false;
long billingId = ParamUtil.getLong(request, "billingId");
long projectId = ParamUtil.getLong(request, "projectId");
long clientId = ParamUtil.getLong(request, "clientId");
Milestone bt = null;
if(billingId!=0){
	editURL = true;
	try{
		bt = MilestoneLocalServiceUtil.getMilestone(billingId);
	}catch(Exception e){
		e.printStackTrace();
	}
	
}

ProjectMaster pm = null;
if(projectId!=0){
	try{
		pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
	}catch(Exception e){
		e.printStackTrace();
	}
}

	DynamicQuery dynamicQuery = MilestoneLocalServiceUtil.dynamicQuery()
	.add(RestrictionsFactoryUtil.eq("projectId", projectId))
	.add(RestrictionsFactoryUtil.eq("clientId", clientId))
	//.setProjection(ProjectionFactoryUtil.property("hours"));
	.setProjection(ProjectionFactoryUtil.sum("amount"));
	List<Milestone> milList = MilestoneLocalServiceUtil.dynamicQuery(dynamicQuery);

double maxAmt = 0.0;
if(pm!=null){
	maxAmt = pm.getTotalAmount();
}

String maxVal = String.valueOf(milList.get(0));
double maxAmt1 = maxAmt;
if(Validator.isNotNull(maxVal)){
maxAmt1 = maxAmt - Double.parseDouble(maxVal);
}
System.out.println("maxAmt1......"+maxAmt1);
/* String status="";
if(bt.getCheckGST()==0){
	status="Pending";
}else if(bt.getCheckGST()==1){
	status="Accepted";
}else{
	status="Rejected";
} */
	boolean isStatus = true;
	if (bt != null) {
		if (bt.getCheckGST() == 0) {
			isStatus = false;
		}
	}
%>

<%
PortletURL milestoneListURL = renderResponse.createRenderURL();
milestoneListURL.setWindowState(LiferayWindowState.NORMAL);
milestoneListURL.setParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");

PortletURL viewURL = renderResponse.createRenderURL();
viewURL.setWindowState(LiferayWindowState.NORMAL);
viewURL.setParameter("clientId", String.valueOf(clientId));
viewURL.setParameter("projectId", String.valueOf(projectId));
viewURL.setParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");
%>

<%
	Date defaultDate = new Date();
	Date startDate, endDate;
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
	startDate = defaultDate;

	endDate = defaultDate;
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Create Milestone" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<h4>Project Name:<%=" "+pm.getProjectName() %></h4>
</br>
</br>
<portlet:actionURL name="updateMilestone" var="updateMilestoneURL" />
<portlet:actionURL name="milestone" var="milestoneURL" />
<aui:form name="milestone" action="<%=editURL != true ? milestoneURL.toString() : updateMilestoneURL.toString() %>" method="post">
<aui:input name="billingId" type="hidden" value="<%=billingId %>"></aui:input>
<aui:input name="projectId" type="hidden" value="<%=projectId %>"></aui:input>
<aui:input name="clientId" type="hidden" value="<%=clientId %>"></aui:input>
<aui:row>
<aui:col span="6">
<aui:input name="milestoneName" id="milestoneName" type="text" label="Milestone Name"
		placeholder="Milestone Name" value="<%=bt != null ? bt.getMilestoneName() : ""%>">
		<aui:validator name="required"></aui:validator>
		<%-- <aui:validator name="alphanum"></aui:validator> --%>
		<aui:validator name="custom"            
                                 errorMessage="Only Alphanumeric allowed">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^a-z|^A-Z|^0-9|\s]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />milestoneName").val(val);
                                     return result;
                                       }
                           </aui:validator>
</aui:input>
</aui:col>
<%
String strDate = "";
if(bt!=null){
Date addDate = bt.getDueDate();
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
strDate = formatter.format(addDate);
}
%>
<aui:col span="6">
<aui:input id="txtFromDate_id" name="dueDate" type="text"
	label="Billing Due Date" placeholder="Due Date" readonly="readonly" value="<%=bt!=null? strDate : formatter1.format(startDate)%>">
	<aui:validator name="required"></aui:validator>
</aui:input>
</aui:col>
</aui:row>
<aui:row>
		<aui:col span="3">
		<aui:input name="amount" id="amount" type="text" label="Amount"
		placeholder="Amount" value="<%=bt != null ? bt.getAmount() : ""%>">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="number"></aui:validator>
		<aui:validator name="min">1</aui:validator>
		<%if(bt==null){ %>
		<aui:validator name="max"><%=maxAmt1%></aui:validator>
		<%} else { %>
		<aui:validator name="max"><%=maxAmt1 + bt.getAmount()%></aui:validator>
		<%} %>
		</aui:input>
		</aui:col>
		<aui:col span="3">
			<aui:input type="radio" name="checkGST" id="incGST"
				checked="<%=isStatus == true%>" label="Include GST" value="1"></aui:input>
		</aui:col>
		<aui:col span="3">
			<aui:input type="radio" name="checkGST" id="excGST" label="Exclude GST"
				checked="<%=isStatus == false%>" value="0"></aui:input>
		</aui:col>
</aui:row>
	<!-- <button name="button" type="button" class="btn btn-success" onClick="writeToPage()">Save</button> -->
	<aui:button name="button" type="submit" value="submit"></aui:button>
	<!-- <a class="btn btn-primary btn-default" name="button" id="button"
			type="submit" onclick="writeToPage()">Save</a> -->
</aui:form>




<script>
AUI().use('aui-datepicker', function(A) {
	var dfg = new A.DatePicker({
		trigger : '#<portlet:namespace />txtFromDate_id',
		mask : '%d/%m/%Y',

		popover : {
			zIndex : 1000
		},
		calendar : {
			minimumDate: new Date()
		}
	});
});
</script>
