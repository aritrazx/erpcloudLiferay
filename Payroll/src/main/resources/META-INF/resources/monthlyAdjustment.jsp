

<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="Payroll.constants.PayrollPortletKeys"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="Payroll.util.PayrollUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
if(themeDisplay.isSignedIn()){
	boolean isViewPermission = false;
	try {
		isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
				"Payroll", "MONTHLY_ADJUSTMENT_VIEW");
		System.out.print("isViewPermission " + isViewPermission);
	} catch (Exception exception) {
		exception.printStackTrace();
	}
	if (isViewPermission) {
		int n=0;
		int m=0;
		long totalEarn = 0;
		long totalDed = 0;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		List<Integer> yearList = new ArrayList<Integer>();
		for(int i=5;i>0;i--){
			yearList.add(currentYear-i);
		}
		for(int j=0;j<=5;j++){
			yearList.add(currentYear+j);
		}
		String componenetIdList = StringPool.BLANK;
		ArrayList<HashMap<String,String>> hashMaps  = new ArrayList<HashMap<String,String>>();
		List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(-1, -1);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		String employeeId = ParamUtil.getString(request, "employeeId");
		String monthStr = ParamUtil.getString(request, "month");
		String yearStr = ParamUtil.getString(request, "year");
		boolean isMonthlyAdjustmentAdd = true;
	/* 	for(int i=5;i>0;i--){
			yearList.add(year-i);
		}
		for(int j=0;j<=5;j++){
			yearList.add(year+j);
		} */
		List<String> earningList = new ArrayList<String>();
		earningList.add(PayrollPortletKeys.Earning);
		earningList.add(PayrollPortletKeys.Overtime);
		earningList.add(PayrollPortletKeys.Reimbursement);
		earningList.add(PayrollPortletKeys.StatutoryComponent);
		PortletURL addMonthlyAdjustmentURL = renderResponse.createActionURL();
		addMonthlyAdjustmentURL.setParameter("javax.portlet.action", "addMonthlyAdjustment");
		PortletURL getMonthlyAdjustmentURL = renderResponse.createRenderURL();
		getMonthlyAdjustmentURL.setParameter("jspPage", "/monthlyAdjustment.jsp");
		if(Validator.isNotNull(employeeId)){
			isMonthlyAdjustmentAdd = false;			
			
		}
%>

<aui:form action="<%= isMonthlyAdjustmentAdd==true? getMonthlyAdjustmentURL.toString():addMonthlyAdjustmentURL.toString() %>" name="addMonthlyAdjustment" >	

<p style="float: right" ><font color="green" > Note:</font>If we have to add or deduct any amount from any of the Earning and Deduction head put +(plus)  or -(minus) before the figure</p>
   <aui:row>
     <aui:col span="6">

<aui:select name="month" label="Month" id="month" >
		<aui:option value="">select</aui:option>
		<aui:option value="1"  selected="<%=1==currentMonth %>" >Jan</aui:option>
		<aui:option value="2" selected="<%=2==currentMonth %>" >Feb</aui:option>
		<aui:option value="3" selected="<%=3==currentMonth %>" >March</aui:option>
		<aui:option value="4" selected="<%=4==currentMonth %>" >April</aui:option>
		<aui:option value="5" selected="<%=5==currentMonth %>" >May</aui:option>
		<aui:option value="6" selected="<%=6==currentMonth %>" >June</aui:option>
		<aui:option value="7" selected="<%=7==currentMonth %>" >July</aui:option>
		<aui:option value="8" selected="<%=8==currentMonth %>" >August</aui:option>
		<aui:option value="9" selected="<%=9==currentMonth %>" >Sept</aui:option>
		<aui:option value="10" selected="<%=10==currentMonth %>" >Oct</aui:option>
		<aui:option value="11" selected="<%=11==currentMonth %>" >Nov</aui:option>
		<aui:option value="12" selected="<%=12==currentMonth %>" >Dec</aui:option>
	</aui:select>
	
	<aui:select name="year"  label="Year" >
		<aui:option value="">select</aui:option>
		<%  	 Iterator it= yearList.iterator();
				 while(it.hasNext()){
				 Object yr = it.next();
		%>
		<aui:option value="<%=yr.toString() %>" selected="<%=currentYear==Integer.valueOf(yr.toString()) %>" ><%=yr.toString() %></aui:option>
		<%	 
		 } 
		 %>
	</aui:select>
	<!-- <div id="errYear" class="control-group error custom-style1" > 
	   			<div class="help-inline">
	   			<font color="red"> 	Please select Year!</font>
	   			</div>
	   		</div> -->
	
	<aui:select name="employeeId"  onChange="getPayComponent(this.value)" label="Employee Name" >
		<aui:option name="">Select</aui:option>
		<% if(Validator.isNotNull(employees)){ 
	       for(Employee employee:employees){
		%>
		<aui:option value="<%=employee.getEmployeeId() %>"><%=employee.getFirstName() +" "+ employee.getLastName() %></aui:option>
		<%} }%>
	</aui:select>
	</aui:col>
	 <aui:col span="6">
	 </aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			
			
			<div  id="list" >			
			
			</div>
		</aui:col>
		<aui:col span="6">
			
		</aui:col>
	</aui:row>
	<%if(isMonthlyAdjustmentAdd){ %>
		<aui:button type="submit" value="Show"  > </aui:button>
		
	<%}if(isMonthlyAdjustmentAdd==false){ %>
	
	<aui:row>
		  <aui:col span="6">
		 <label  style="font-size: 28px;" >Earning</label></br>	
	<% 
		
		hashMaps   = PayrollUtil.getPayComponent(employeeId, monthStr, yearStr);
		for(HashMap<String,String> map:hashMaps){
		
	
			    componenetIdList += map.get("payComponentId")+",";
		%>
		
		 
	<%if(earningList.contains(map.get("payType"))){ %>
	
   
    
     <label> <%=map.get("name") %><font color="green">(<%= map.get("amount")%>)</font></label>
	 <input class="field form-control" type="text"	name="<portlet:namespace/>compo_<%=map.get("payComponentId")%>" onchange="addTotalEarn()"  value=<%=map.get("adjustmentAmount") %> ></input>
 
    
     <%} }%>
     
      </aui:col>
      <aui:col span="6">	
	 <label  style="font-size: 28px;" >Deduction</label></br>
     <% 
		
		hashMaps   = PayrollUtil.getPayComponent(employeeId, monthStr, yearStr);
		for(HashMap<String,String> map:hashMaps){
		
	
			    componenetIdList += map.get("payComponentId")+",";
		%>
     
     
	<%if(map.get("payType").equalsIgnoreCase(PayrollPortletKeys.Deduction)){ %>
	
	 <label> <%=map.get("name") %><font color="green">(<%= map.get("amount")%>)</font></label>
	<input class="field form-control" type="text"	name="<portlet:namespace/>compo_<%=map.get("payComponentId")%>" onchange="addTotalEarn()"  value=<%=map.get("adjustmentAmount") %> ></input>
 
	
	 
	<%} }%>
	 
	 </aui:col>
	</aui:row>
	
 
			
			<aui:button type="submit" style="margin-top: 10px;" value="Save"  > </aui:button>
				<aui:input name="componenetIdList" id="componenetIdList" type="hidden" value="<%=componenetIdList %>" ></aui:input>
				<%} %>
</aui:form>


<script type="text/javascript">
$(document).ready(function(){
	$('#errMonth').hide();
	$('#errYear').hide();  
});

AUI().ready('alloy-node', 'aui-form-validator', function(A) {
	   var formValidator = new A.FormValidator({
	       boundingBox: document.<portlet:namespace />addMonthlyAdjustment,
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
	               required: 'Please select employee Name!'
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

<%-- function getPayComponent(employeeId){	
	var month = $('#<portlet:namespace/>month').find("option:selected").val();
	var year = $('#<portlet:namespace/>year').find("option:selected").val();
	if(month!=""){
		$('#errMonth').hide();
	    if(year!=""){
		$('#errYear').hide();
		var list="";
		var componenetIdList="";
		 $.ajax({
				type:'post',
				url: '<%=getPayComponentURL.toString()%>',				
				data: {'<portlet:namespace/>employeeId':employeeId,'<portlet:namespace/>month':month,'<portlet:namespace/>year':year},
				async: false,
				success: function(result) {
					var d = JSON.parse(result);	
					$.each(d, function( key, item ) {
						componenetIdList = componenetIdList+(item.payComponentId)+",";
						list = list+'<label>'+item.name+'<font color="green">('+item.amount+')</font></label>'
							+'<input class="field form-control" type="text"	name="<portlet:namespace/>compo_'+item.payComponentId+'" onchange="addTotalEarn()"  value="'+item.adjustmentAmount+'"></input>';
					});					
					$("#list").html(list);
					$("#typeSubmit").show();
					$("#<portlet:namespace/>componenetIdList").val(componenetIdList);
				},
				error: function() {
			    $("#typeSubmit").hide();
				$("#<portlet:namespace/>list").html(list);
				
				}
			});
	  }else{
		  $('#errYear').show();
	  }
	}else{
		$('#errMonth').show();
	}
}
 --%>
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
	<%}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"  > <font color="red" > You don't have permission to view the Monthly Adjustment </font></label>
	  </div>
<%}}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>