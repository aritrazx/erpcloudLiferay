<%@page import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.employeedetails.constants.EmployeeDetailsPortletKeys"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
	String recruitmentProcessId = ParamUtil.getString(request,"recruitmentProcessId",StringPool.BLANK);
	System.out.println("recruitmentProcessId:---"+recruitmentProcessId);
	
	/*get candidate name from recruitmentProcessId  */
	RecruitmentProcess recruitmentProcess = null ;
	CandidateApply apply = null;
	try {
		if (Validator.isNotNull(recruitmentProcessId)) {
			recruitmentProcess = RecruitmentProcessLocalServiceUtil
					.getRecruitmentProcess(Long.parseLong(recruitmentProcessId));
			if (Validator.isNotNull(recruitmentProcess.getApplyCandidateId())) {
				apply= CandidateApplyLocalServiceUtil.getCandidateApply(recruitmentProcess.getApplyCandidateId());
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	int n = 0;
	int m = 0;
	long totalEarn = 0;
	long totalDed = 0;
	String componenetIdList = StringPool.BLANK;
	String empPayStructureIdList = StringPool.BLANK;
	List<String> earningList = new ArrayList<String>();
	earningList.add(EmployeeDetailsPortletKeys.Earning);
	earningList.add(EmployeeDetailsPortletKeys.Overtime);
	earningList.add(EmployeeDetailsPortletKeys.Reimbursement);
	earningList.add(EmployeeDetailsPortletKeys.StatutoryComponent);
	List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
%>


<portlet:resourceURL id="calculatePayComponent" var="calculatePayComponent">
	<portlet:param name="<%=Constants.CMD %>" value="calculatePaycomponent" />
</portlet:resourceURL>

<p align="center"><label  style="font-size: 20px;">Pay Structure for <b style="color: #f48120;"><%=apply!=null?apply.getFirstName()+" "+apply.getLastName():"" %></b></label></p>

<portlet:actionURL name="addSelectedCandidatePayStructure" var="addSelectedCandidatePayStructureURL" />
<div id="candidatePayStructure">
	<aui:form name="addSelectedCandidatePayStructure"
		action="<%=addSelectedCandidatePayStructureURL%>" method="post">
		
		<aui:input name="recruitmentProcessId" value="<%=recruitmentProcessId %>" type="hidden"></aui:input>
		<aui:row>
			<aui:col span="6">
			
				<aui:input type="text" name="dateOfJoining" id="textDOJ"
					value="" label="Date Of Joining"
					readonly="readonly">
					<aui:validator name="required"></aui:validator>	
				</aui:input>
			</aui:col>
			<p align="center"><label style="font-size: 20px;">Company Bond</label></p>
			<aui:col span="3">
				<aui:input name="yearBond" type="text" value="" label=" "  placeholder="years">
					<aui:validator name="digits"></aui:validator>
				</aui:input>
				
			</aui:col>
			<aui:col span="3">
				<aui:input name="monthBond" type="text" value="" label=" " placeholder="months">
				<aui:validator name="digits"></aui:validator>
				<aui:validator name="max">11</aui:validator>
				</aui:input>
				
			</aui:col>
		
		</aui:row>
		<aui:row>
			<aui:col span="6">
				<aui:input name="amount" type="text" id="amount" value="" label="Amount(Per month)">
					<aui:validator name="digits" errorMessage="Please enter digits"></aui:validator>
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</aui:col>
			<aui:col span="6">
				<aui:input name="bonus" type="text" id="bonus" value=""
					label="Bonus">
					<aui:validator name="digits" errorMessage="Please enter digits"></aui:validator>
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>

		<button type="button" name="total" class="active btn btn-primary"
			onclick="calCulatePayComponent()">Calculate</button></br>

		<aui:row>
			<aui:col span="6">
				<label>Earning</label>
				<%
					if (componentList.size() > 0) {
									for (PayComponent payCompo : componentList) {
										if (earningList.contains(payCompo.getPayType())) {
											componenetIdList += payCompo.getComponentId() + ",";
				%>

				<label><%=payCompo.getName()%></label>
				<input class="field form-control" type="text"
					name='<portlet:namespace/>compo_<%=payCompo.getComponentId()%>'
					onchange="addTotalEarn()" id='earn_<%=n%>'></input>

				<%
					n++;
										}
									}
								}
				%>
				<aui:input type="text" name="totalEarn" readonly="true"
					label="Total Earning" id="totalEarn" value="<%=totalEarn%>"></aui:input>
			</aui:col>
			<aui:col span="6">
				<label>Deduction</label>
				<%
					if (componentList.size() > 0) {
									for (PayComponent payCompo : componentList) {
										if (payCompo.getPayType().equalsIgnoreCase(EmployeeDetailsPortletKeys.Deduction)) {
											componenetIdList += payCompo.getComponentId() + ",";
				%>
				<label><%=payCompo.getName()%></label>
				<input class="field form-control" type="text"
					name='<portlet:namespace/>compo_<%=payCompo.getComponentId()%>'
					onchange="addTotalDed()" id='ded_<%=m%>'></input>

				<%
					m++;
										}
									}
								}
				%>
				<aui:input type="text" name="totalDeduction" readonly="true"
					label="Total Deduction" id="totalDed" value="<%=totalDed%>"></aui:input>
			</aui:col>
		</aui:row>
		<aui:input name="netPay" type="text" readonly="true" id="netPay"
			label="Net Pay" value="<%=totalEarn - totalDed%>"></aui:input>
		<aui:input name="componenetIdList" type="hidden"
			value="<%=componenetIdList%>"></aui:input>
		<aui:button type="submit" value="View Offer Letter">
		</aui:button>
	</aui:form>
</div>

<script>
	function addTotalEarn() {
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
		var amount =  $('#<portlet:namespace/>amount').val();
		var employeeId = $('#<portlet:namespace/>employeeId').val();
		var n = '<%=n%>' ;
		var i = 0;
	var totalEarning = 0;
	var totalDeduction = 0;
	var netPay = 0;
	var name;
 $.ajax({
		type:'post',
		url: '<%=calculatePayComponent.toString() %>',				
		data: {'<portlet:namespace/>amount':amount},
		async: false,
		success: function(result) {
			var empDetails = JSON.parse(result);			
			$.each( empDetails, function( key, item ) {				
					if(item.payType=='<%=EmployeeDetailsPortletKeys.Earning %>'){
						 $('#earn_'+i).val((item.earning).toFixed(2));
						 i++;
						 totalEarning = totalEarning+item.earning;
					}
			});	
			i=0;
			$.each( empDetails, function( key, item ) {				
				if(item.payType=='<%=EmployeeDetailsPortletKeys.Deduction%>'){
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
		
		}
	});
 
}	 


//for date of joining
AUI().use('aui-datepicker', function(A) {
	var datepic=new A.DatePicker({
	trigger : '#<portlet:namespace/>textDOJ',
	mask : '%d/%m/%Y',

	popover : {
	toolbars: {
	header: [[
	             {
	               icon:'icon-trash',
	               label: 'Clear',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	                 }
	               }
	             },
	             {
	               icon:'icon-globe',
	               label: 'Today',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	               	 datepic.selectDates(new Date());
	                 }
	               }
	             }
	           ]]
	         },
	zIndex : 1000
	},

	nullableDay: true,
	nullableMonth: true,
	nullableYear: true,


	calendar: {
	     minimumDate:new Date()
	  }
	});
	});
	</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js"></script>