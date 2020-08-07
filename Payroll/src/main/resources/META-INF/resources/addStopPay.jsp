<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@ include file="init.jsp"%>


<%
		String componenetIdList = StringPool.BLANK;
		List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(-1, -1);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<Integer> yearList = new ArrayList<Integer>();
		for(int i=5;i>0;i--){
			yearList.add(year-i);
		}
		for(int j=0;j<=5;j++){
			yearList.add(year+j);
		}
		PortletURL addStopPayURL = renderResponse.createActionURL();
		addStopPayURL.setParameter("javax.portlet.action", "addStopPay");
		
		PortletURL backURL = renderResponse.createRenderURL();
		backURL.setParameter("jspPage", "/addStopPay.jsp");
		

%>
<portlet:resourceURL id="getPayComponent" var="getPayComponentURL">
	<portlet:param name="<%=Constants.CMD %>" value="getPayComponent" />
</portlet:resourceURL>

<%-- <aui:row>
<aui:col span="8" >

</aui:col>
<aui:col span="2" >
<a href="<%=StopPayList.toString() %>"  class="btn btn-primary btn-default" >Stop Pay List </a>
</aui:col>
</aui:row> --%>
<liferay-ui:error key="EmpMonth-error"  message="Employee has been stopped for this Month!" ></liferay-ui:error>
<liferay-ui:header title="Back" backLabel="Back" backURL="<%=backURL.toString()%>" />
<aui:form action="<%=addStopPayURL.toString()%>" name="addStopPayForm" >	

	<aui:row>
		<aui:col span="6">
		
		<label>Month<span class="mandatory" >* </span></label>
	<aui:select name="month" label="" id="month" >
		<aui:option value="">select</aui:option>
		<aui:option value="01">Jan</aui:option>
		<aui:option value="02">Feb</aui:option>
		<aui:option value="03">March</aui:option>
		<aui:option value="04">April</aui:option>
		<aui:option value="05">May</aui:option>
		<aui:option value="06">June</aui:option>
		<aui:option value="07">July</aui:option>
		<aui:option value="08">August</aui:option>
		<aui:option value="09">Sept</aui:option>
		<aui:option value="10">Oct</aui:option>
		<aui:option value="11">Nov</aui:option>
		<aui:option value="12">Dec</aui:option>
	</aui:select>
	<!-- <div id="errMonth" class="control-group error custom-style1" > 
	   			<div class="help-inline">
	   			<font color="red"> 	Please select Month! </font>
	   			</div>
	   		</div> -->
<label>Year<span class="mandatory" >* </span></label>
	<aui:select name="year"  label="" >
		<aui:option value="">select</aui:option>
		<%  	 Iterator it= yearList.iterator();
				 while(it.hasNext()){
				 Object yr = it.next();
		%>
		<aui:option value="<%=yr.toString() %>"><%=yr.toString() %></aui:option>
		<%	 
		 } 
		 %>
	</aui:select>
	<!-- <div id="errYear" class="control-group error custom-style1" > 
	   			<div class="help-inline">
	   			<font color="red"> 	Please select Year!</font>
	   			</div>
	   		</div> -->
	
	</aui:col>
		<aui:col span="6">
			<label>Employee Name<span class="mandatory" >* </span></label>
	<aui:select name="employeeId" id="employeeId" onChange="getPayComponent(this.value)" label="" >
		<aui:option name="">Select</aui:option>
		<% if(Validator.isNotNull(employees)){ 
	       for(Employee employee:employees){
		%>
		<aui:option value="<%=employee.getEmployeeId() %>"><%=employee.getFirstName() +" "+ employee.getLastName() %></aui:option>
		<%} }%>
	</aui:select>
	<label>Reason<span class="mandatory" >* </span></label>
	<aui:input name="reason" id="reason" label="" type="textarea" >
	<aui:validator name="required" errorMessage="Please write reason!" />
	</aui:input>
		</aui:col>
	</aui:row>
	
<aui:button type="submit" value="Save"  > </aui:button>
</aui:form>

<script type="text/javascript">
$(document).ready(function(){
	$('#errMonth').hide();
	$('#errYear').hide();
});

AUI().ready('alloy-node', 'aui-form-validator', function(A) {
	   var formValidator = new A.FormValidator({
	       boundingBox: document.<portlet:namespace />addStopPayForm,
	       rules: {
	    	   <portlet:namespace />month: {
	               required: true
	           },
	    	   <portlet:namespace />year: {
	               required: true
	           },
	    	   <portlet:namespace />employeeId: {
	               required: true
	           }
	           
	       },
	       fieldStrings: {
	    	   <portlet:namespace />month: {
	               required: 'Please select Month!'
	           },
	    	   <portlet:namespace />year: {
	               required: 'Please select Year!'
	           },
	    	   <portlet:namespace />employeeId: {
	               required: 'Please select Employee Name!'
	           }
	          
	       },
	       on: {
	           validateField: function(event) {},
	           validField: function(event) {},
	           errorField: function(event) {},
	           submitError: function(event) {
	               var errors = event.validator.errors;
	               event.preventDefault();
	           },
	           submit: function(event) {
	               return false;
	           }
	       }
	   });
	}); 


</script>

<style>
.mandatory{
	color: red;
	font-size: 22px;
}
</style>

