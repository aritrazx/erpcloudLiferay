


<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.famocom.erpcloud.employeedetails.constants.EmployeeDetailsPortletKeys"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmpPayStructure"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="init.jsp" %>


<%

String employeeId = ParamUtil.getString(renderRequest, "employeeId");
List<EmpPayStructure> empPayStructure = new ArrayList<EmpPayStructure>();
if(Validator.isNotNull(employeeId)){
	empPayStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByEmployeeId(Long.valueOf(employeeId));
}
List<String> earningList = (List<String>) request.getAttribute("earningList");
 PortletURL addPayStructure = renderResponse.createActionURL();
 addPayStructure.setParameter("javax.portlet.action", "addPayStructure");
 DecimalFormat twoDForm = new DecimalFormat("#.00");

 PortletURL editPayStructure = renderResponse.createActionURL();
 editPayStructure.setParameter("javax.portlet.action", "editPayStructure");
 List<PayComponent> payComDedList = (List<PayComponent>)  request.getAttribute("payComponentDeductionList");
 List<PayComponent> payComEarnList = (List<PayComponent>)  request.getAttribute("payComponentEarningList");
 System.out.print(" empPayStructure...."+empPayStructure.size());
 int n=0;
 int m=0;
 long totalEarn = 0;
 long totalDed = 0;
 String componenetIdList = StringPool.BLANK;
 String empPayStructureIdList = StringPool.BLANK;
 String totalPay = StringPool.BLANK;
 List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
if(Validator.isNotNull(empPayStructure)){
	Employee emp = EmployeeLocalServiceUtil.getEmployee(Long.valueOf(employeeId));
	totalPay = String.valueOf(emp.getPayPerMonth());
}
%>
<portlet:resourceURL id="calculatePayComponent" var="calculatePayComponent">
	<portlet:param name="<%=Constants.CMD %>" value="calculatePaycomponent" />
</portlet:resourceURL>







<aui:form action="<%= empPayStructure.size()>0 ?   editPayStructure.toString() :addPayStructure.toString()  %>"  name="ePayStructure">

 <aui:row>
     <aui:col span="6">
     <label  style="font-size: 28px;" >TotalPay(Monthly) </label>
<aui:input type="text"  name="totalPay" id="totalPay" label="" value="<%=totalPay %>"  />
</aui:col>
 <aui:col span="6">
 </aui:col>
</aui:row>
 <input type="button" value="Calculate" class="btn btn-primary btn-default" onclick="calCulatePayComponent()" />
     <% if(empPayStructure.size()>0){%>
     <aui:row>
     <aui:col span="6">
    
     <aui:input name="employeeId" id="employeeId" type="hidden" value="<%=employeeId %>" ></aui:input>
     <label style="font-size: 28px;" >Earning</label></br>
     <%
     if(componentList.size()>0){
     for(PayComponent payCompo:componentList){
    	
           if(earningList.contains(payCompo.getPayType())){
        	   EmpPayStructure payStructure = null;
	    		 try{
	        	    payStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentIdAndEmployeeId(payCompo.getComponentId(), Long.valueOf(employeeId));
	    		 }catch(Exception e){
	    			 
	    		 }
            if(Validator.isNotNull(payStructure)){
	     		totalEarn += payStructure.getComponentValue();
	     		  componenetIdList += payCompo.getComponentId() +",";
	     		empPayStructureIdList += payStructure.getEmpPayStructureId()+",";
     %>
     <label><%=payCompo.getName() %></label>
       <input  class="field form-control"  type="text" name='<portlet:namespace/>compo_<%=payCompo.getComponentId() %>' onchange="addTotalEarn()"  id='earn_<%=n %>'   value="<%=payStructure.getComponentValue() %>"  ></input> 
  
       <% n++;}/* else{
    	   componenetIdList += payCompo.getComponentId() +","; */
    	   %>
       
      <%--   <label><%=payCompo.getAbbreviation() %></label>
       <input  class="field form-control"  type="text" name='<portlet:namespace/>compo_<%=payCompo.getComponentId() %>' onchange="addTotalEarn()"  id='earn_<%=n %>'    ></input> 
   --%>
       <%    
           
         /*  n++;  } */ 
           } } }%>
     
     <aui:input  type="text" name="totalEarn" readonly="true" label="Total Earning" id="totalEarn" value="<%=totalEarn %>"   ></aui:input>
     </aui:col>
     <aui:col span="6">	
      <label  style="font-size: 28px;" >Deduction</label></br>
      <%
      if(componentList.size()>0){
    	     for(PayComponent payCompo:componentList){
    	    	
    	    	 if(payCompo.getPayType().equalsIgnoreCase(EmployeeDetailsPortletKeys.Deduction)){
    	    		 EmpPayStructure payStructure = null;
    	    		 try{
    	        	    payStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentIdAndEmployeeId(payCompo.getComponentId(), Long.valueOf(employeeId));
    	    		 }catch(Exception e){
    	    			 
    	    		 }
    	        	System.out.println("payStructure....."+payStructure);
    	            if(Validator.isNotNull(payStructure)){
         
        	    totalDed += payStructure.getComponentValue();
	     		componenetIdList += payCompo.getComponentId() +",";
	     		empPayStructureIdList += payStructure.getEmpPayStructureId()+",";
     %>
     <label><%=payCompo.getName() %></label>
      <input  class="field form-control"  type="text" name='<portlet:namespace/>compo_<%=payCompo.getComponentId() %>' onchange="addTotalDed()" id='ded_<%=m %>'   value="<%=payStructure.getComponentValue()%>"  ></input>
   
     
   
       <% m++;}/* else{
    	   componenetIdList += payCompo.getComponentId() +","; */
    	   %>
     	<%-- <label><%=payCompo.getAbbreviation() %></label>
      <input  class="field form-control"  type="text" name='<portlet:namespace/>compo_<%=payCompo.getComponentId() %>' onchange="addTotalDed()" id='ded_<%=m %>'   ></input>
    --%>
     
     	
     	 <%    
          /*  m++;
            }  */
           } } }%>	
      <aui:input  type="text" name="totalDeduction" readonly="true" label="Total Deduction"  id="totalDed" value="<%=totalDed %>"  ></aui:input>
      <aui:input name="componenetIdList" type="hidden" value="<%=componenetIdList %>" ></aui:input>
      <aui:input name="empPayStructureIdList" type="hidden" value="<%=empPayStructureIdList %>" ></aui:input>
     </aui:col>
     </aui:row>
      <aui:input name="netPay" type="text" readonly="true" id="netPay" label="Net Pay" value="<%=totalEarn - totalDed %>"  ></aui:input>
      <aui:button type="submit" value="Update"  > </aui:button>
<%}else{ %>

     <aui:row>
     <aui:col span="6">
     
     <aui:input name="employeeId" type="hidden" value="<%=employeeId %>" ></aui:input>
     <label  style="font-size: 28px;" >Earning</label></br>
     <%
     if(Validator.isNotNull(payComEarnList) && payComEarnList.size()>0){   	
       	for(PayComponent payComp:payComEarnList) {
       		String amount = StringPool.BLANK;
     		totalEarn += payComp.getAmount();
     		componenetIdList += payComp.getComponentId() +",";
     		if(Validator.isNotNull(payComp.getAmount())){
     			amount = String.valueOf(payComp.getAmount());
     		}
     %>
        <label><%=payComp.getName()%></label>
      <input  class="field form-control"  type="text" name='<portlet:namespace/>compo_<%=payComp.getComponentId() %>' onchange="addTotalEarn()"  id='earn_<%=n %>'   value=""  ></input>
      
     <%  n++;
         }} %>
     
     <aui:input  type="text" name="totalEarn" readonly="true" label="Total Earning" id="totalEarn" value=""   ></aui:input>
     </aui:col>
     <aui:col span="6">	
      <label style="font-size: 28px;" >Deduction</label></br>
      <%
     if(Validator.isNotNull(payComDedList) && payComDedList.size()>0){
    	 String amount = StringPool.BLANK;
     	for(PayComponent payComp:payComDedList) {
     		totalDed += payComp.getAmount();
     		componenetIdList += payComp.getComponentId() +",";
     		if(Validator.isNotNull(payComp.getAmount())){
     			amount = String.valueOf(payComp.getAmount());
     		}
     %>
     <label><%=payComp.getName()%></label>
      <input  class="field form-control"  type="text" name='<portlet:namespace/>compo_<%=payComp.getComponentId() %>' onchange="addTotalDed()" id='ded_<%=m %>'   value=""  ></input>
     <%
     m++;
     	}} %>	
      <aui:input  type="text" name="totalDeduction" readonly="true" label="Total Deduction"  id="totalDed" value=""  ></aui:input>
      <aui:input name="componenetIdList" type="hidden" value="<%=componenetIdList %>" ></aui:input>
     </aui:col>
     </aui:row>
     <aui:input name="netPay" type="text" readonly="true" id="netPay" label="Net Pay" value=""  ></aui:input>
      <aui:button type="submit" value="Add"  > </aui:button>
      <%} %>
</aui:form>


<script type="text/javascript" >

function addTotalEarn(){
  var n = '<%=n%>';
  var totalDed = $('#<portlet:namespace/>totalDed').val();
  var amount=0;
  var amt=0;
  for(var i=0 ;i<n;i++) {	
		 amt =  $('#earn_'+i).val();	
		 amount = parseInt(amount) + parseInt(amt) ;
	}
  $('#<portlet:namespace/>totalEarn').val(amount); 
  $('#<portlet:namespace/>netPay').val(amount-totalDed); 
}

function addTotalDed(){
  var m = '<%=m%>';
  var totalEarn = $('#<portlet:namespace/>totalEarn').val();
  var amount=0;
  for(var i=0 ;i<m;i++) {	  
		  amt =$('#ded_'+i).val();
		  amount = parseInt(amount) + parseInt(amt) ;	
	}
  $('#<portlet:namespace/>totalDed').val(amount); 
  $('#<portlet:namespace/>netPay').val(totalEarn-amount); 
}


function calCulatePayComponent(){
	var  earningList = '<%=earningList%>';
	var totalPay =  $('#<portlet:namespace/>totalPay').val();
	var employeeId = $('#<portlet:namespace/>employeeId').val();
	var n = '<%=n%>';
	var i = 0;
	var totalEarning = 0;
	var totalDeduction = 0;
	var netPay = 0;
	var name;
 $.ajax({
		type:'post',
		url: '<%=calculatePayComponent.toString()%>',				
		data: {'<portlet:namespace/>totalPay':totalPay,'<portlet:namespace/>employeeId':employeeId},
		async: false,
		success: function(result) {
			var empDetails = JSON.parse(result);			
			$.each( empDetails, function( key, item ) {	
				  if(earningList.includes(item.payType)){
						 $('#earn_'+i).val((item.earning).toFixed(2));
						 i++;
						 totalEarning = totalEarning+item.earning;
					}
			});	
			i=0;
			$.each( empDetails, function( key, item ) {				
				if(item.payType=='<%=EmployeeDetailsPortletKeys.Deduction %>'){
					 $('#ded_'+i).val((item.deduction).toFixed(2));
					 i++;
					 totalDeduction = totalDeduction+item.deduction;
				}
		});	
		
			netPay = totalEarning-totalDeduction;
			$('#<portlet:namespace/>totalEarn').val(totalEarning.toFixed(2));
			$('#<portlet:namespace/>totalDed').val(totalDeduction.toFixed(2));
			$('#<portlet:namespace/>netPay').val(netPay.toFixed(2));
		},
		error: function() {
	   // $("#typeSubmit").hide();
		//$("#<portlet:namespace/>list").html(list);
		
		}
	});
}	 
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js"></script>