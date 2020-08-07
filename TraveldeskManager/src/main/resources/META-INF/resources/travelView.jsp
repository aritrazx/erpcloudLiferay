<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.TravelDeskDetails"%>
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
	PortletURL listViewURL = renderResponse.createRenderURL();
	listViewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL statusURL = renderResponse.createActionURL();
	statusURL.setParameter("javax.portlet.action", "updateStatus");
	
	PortletURL rejectURL = renderResponse.createActionURL();
	rejectURL.setParameter("javax.portlet.action", "reject");
	
	long travelId = ParamUtil.getLong(request, "travelId");
	long employeeId = ParamUtil.getLong(request, "employeeId");
	TravelDeskDetails travelDeskDetails=null;
	Employee emp=null;
	ProjectMaster projectMaster =null;
	if(Validator.isNotNull(travelId)){
		try{
			travelDeskDetails = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
			System.out.println("travelId"+travelId);
			emp = EmployeeLocalServiceUtil.getEmployee(travelDeskDetails.getEmployeeId());
			projectMaster = ProjectMasterLocalServiceUtil.getProjectMaster(travelDeskDetails.getProjectId());
		}catch(Exception e){
			
		}
	}
	
	String status="";
	if(travelDeskDetails.getStatus()==0){
		status="Pending";
	}else if(travelDeskDetails.getStatus()==1){
		status="Accepted";
	}else{
		status="Rejected";
	}
	boolean isStatus=false;
	if(travelDeskDetails.getStatus()==1){
		isStatus=true;
	}
	/* statusURL.setParameter("travelId", String.valueOf( travelDeskDetails.getTravelDetailsId()));
	rejectURL.setParameter("travelId", String.valueOf( travelDeskDetails.getTravelDetailsId())); */
	
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setWindowState(LiferayWindowState.NORMAL);
	viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Travel Details" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
	
	
	<aui:row>
	<aui:col span="6">
	<p>
		Employee Name : <b style="color: #f48120;"><%=emp.getFirstName()+" "+emp.getLastName()%></b>
	</p></br>
	<p>
		Project Name : <b style="color: #f48120;"><%=projectMaster.getProjectName()%></b>
	</p></br>
	<p>
		Ticket Type : <b style="color: #f48120;"><%=travelDeskDetails.getTicketType()%></b>
	</p></br>
	<p>
		Status : <b style="color: #f48120;"><%=status%></b>
	</p></br>
	</aui:col>
	<%			
	String strDate = "";
	String strDate1 = "";
				if(Validator.isNotNull(travelDeskDetails)){
					Date addDate = travelDeskDetails.getFromDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					strDate = formatter.format(addDate);
					
					Date eDate = travelDeskDetails.getToDate();
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM,yyyy");
					strDate1 = formatter1.format(eDate);
	}
	%>
	<aui:col span="6">
	<p>
		From Date and Time : <b style="color: #f48120;"><%=strDate+" at "+travelDeskDetails.getFromTime()%></b>
	</p></br>
	<p>
		To Date and Time : <b style="color: #f48120;"><%=strDate1+" at "+travelDeskDetails.getToTime()%></b>
	</p></br>
	<p>
		Location : <b style="color: #f48120;"><%=travelDeskDetails.getLocation()%></b>
	</p></br>
	
	
</aui:col>  </aui:row>
<portlet:actionURL name="travelDeskManager" var="travelDeskManagerURL" />
<aui:form name="travelDeskManager" action="<%=travelDeskManagerURL.toString() %>" method="post">
<aui:input name="travelId" type="hidden" value="<%=travelId %>"></aui:input>
<aui:input name="employeeId" type="hidden" value="<%=employeeId %>"></aui:input>
<aui:input name="comment" type="textarea"
		label="Comment" placeholder="Comment"
		value="<%=travelDeskDetails != null ? travelDeskDetails.getManagerComment() : ""%>" >
		
<aui:validator name="custom"            
                                 errorMessage="Only Alphabets allowed">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^a-z|^A-Z|^\s]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />comment").val(val);
                                     return result;
                                       }
                           </aui:validator>		
		
</aui:input>

<%-- <aui:input name="checkForAccept" label="Accept"
		type="checkbox"
		value="<%=travelDeskDetails != null ? travelDeskDetails.getStatus() : ""%>">
</aui:input> --%>
	<aui:row>
		<aui:col span="3">
			<aui:input type="radio" name="status"
				checked="<%=isStatus == false%>" label="Reject" value="2"></aui:input>
		</aui:col>
		<aui:col span="3">
			<aui:input type="radio" name="status" label="Approve"
				checked="<%=isStatus == true%>" value="1"></aui:input>
		</aui:col>
	</aui:row>
	<aui:button name="button" type="submit" value="submit"></aui:button>
</aui:form>