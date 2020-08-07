<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.BankMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.BankMaster"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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

<portlet:renderURL var="accountNumber"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/META-INF/resources/checkAccountNumber.jsp" />
</portlet:renderURL>
<portlet:renderURL var="aadhaarNumber"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/META-INF/resources/checkAadhaarNumber.jsp" />
</portlet:renderURL>
<portlet:renderURL var="panNumber"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
<portlet:param name="jspPage"
		value="/META-INF/resources/checkPanNumber.jsp" />
</portlet:renderURL>

<portlet:renderURL var="pfNumber"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
<portlet:param name="jspPage"
		value="/META-INF/resources/checkPfNumber.jsp" />
</portlet:renderURL>
<script>
function checkAccountNumber(t){
	//alert("call");
	var url = '<%=accountNumber.toString()%>';
	var val=t;
		//alert(val);
	jQuery.ajax({
	url: url,
	data:{
	'<portlet:namespace/>textvalue': val },
	success: function(result) {
	//alert("success");
	//console.log(result);
	jQuery('#msgTextAcnt').html(result);
	jQuery('#msgTextAcnt').show();
	},
	error: function() { 
	jQuery('#msgTextAcnt').html('No Result Found'); 
	},
	type: 'POST'
	});
	}
	
function checkAadhaarNumber(t){
	//alert("call");
	var url = '<%=aadhaarNumber.toString()%>';
	var val=t;
		//alert(val);
	jQuery.ajax({
	url: url,
	data:{
	'<portlet:namespace/>textvalue': val },
	success: function(result) {
	//alert("success");
	//console.log(result);
	jQuery('#msgTextAdhaar').html(result);
	jQuery('#msgTextAdhaar').show();
	},
	error: function() { 
	jQuery('#msgTextAdhaar').html('No Result Found'); 
	},
	type: 'POST'
	});
	}
	
function checkPanNumber(t){
	//alert("call");
	var url = '<%=panNumber.toString()%>';
	var val=t;
		//alert(val);
	jQuery.ajax({
	url: url,
	data:{
	'<portlet:namespace/>textvalue': val },
	success: function(result) {
	//alert("success");
	//console.log(result);
	jQuery('#msgTextPan').html(result);
	jQuery('#msgTextPan').show();
	},
	error: function() { 
	jQuery('#msgTextPan').html('No Result Found'); 
	},
	type: 'POST'
	});
	}
	
function checkPfNumber(t){
	//alert("call");
	var url = '<%=pfNumber.toString()%>';
	var val=t;
		//alert(val);
	jQuery.ajax({
	url: url,
	data:{
	'<portlet:namespace/>textvalue': val },
	success: function(result) {
	//alert("success");
	//console.log(result);
	jQuery('#msgTextPfNumber').html(result);
	jQuery('#msgTextPfNumber').show();
	},
	error: function() { 
	jQuery('#msgTextPfNumber').html('No Result Found'); 
	},
	type: 'POST'
	});
	}

</script>
<%
	//List<BankMaster> bankMaster = BankMasterLocalServiceUtil.getBankMasters(-1,-1);
	
	List<BankMaster> bankMaster = new ArrayList<>();
	DynamicQuery membrQuery = BankMasterLocalServiceUtil.dynamicQuery();
	membrQuery.addOrder(OrderFactoryUtil.asc("bankType"));
	bankMaster = BankMasterLocalServiceUtil.dynamicQuery(membrQuery);
	int tag1 = 0 ;
	int tag2 = 0 ;
		
%>
<aui:row>
	<aui:col span="6">

		<aui:select name="bankId" label="Bank Name" value="">
			<%
				for (BankMaster bm : bankMaster) {
			%>
				<%
				
				if(bm.getBankType() == 1 && tag1==0) {
					tag1=1;
				%>
				<optgroup label="Salary Account"></optgroup>
				
				<%
				}
				%>
				
				
				<%
				
				
				if(bm.getBankType() == 2 && tag2==0){
					tag2=1;
				%>
				<optgroup label="Other Account"></optgroup>
				<%}if(emp!=null){
					String isSelect = "";

					if (bm.getBankId()==emp.getBankId()) {
						System.out.println("-----------IF-------------");
						isSelect = "selected";
					}
				%>
				<option value="<%=bm.getBankId()%>"
					<%=isSelect%>><%=bm.getBankName()%></option>
				<%
					}else {
				%>	
				<option value="<%=bm.getBankId()%>" ><%=bm.getBankName()%></option>
			<%
					}
				
				}
			%>
			
		</aui:select>

		<!-- for Account Number -->
		<aui:input name="accountNumber"
			onChange="javascript:checkAccountNumber(this.value);" type="text"
			value="<%=emp!=null? emp.getAccountNo():"" %>" label="Account Number">
			<aui:validator name="digits"></aui:validator>
			
		</aui:input>
		<div id="msgTextAcnt" class="inut-special-mention validator-error"
			style="display: none;"></div>
		<!-- for Aadhaar No -->
		<aui:input name="aadhaarNo"
			onChange="javascript:checkAadhaarNumber(this.value);" type="text"
			value="<%=emp!=null? emp.getAadhaarNo():"" %>" label="Aadhaar No">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="maxLength">12</aui:validator>
		</aui:input>
		<div id="msgTextAdhaar" class="inut-special-mention validator-error"
			style="display: none;">
			</div>
	</aui:col>

	<aui:col span="6">
		<!-- for PAN-->
		<aui:input name="pan" onChange="javascript:checkPanNumber(this.value);" type="text"
			value="<%=emp!=null? emp.getPanNo():"" %>"
			label="PAN" placeholder="Ex: ABCDE1234A">
			<%-- <aui:validator name="custom"
				errorMessage="Please Enter a valid input">
                         function (val, fieldNode, ruleValue)
                            {
                                var result = true;
                                var pattern=/[A-Z|{5}|0-9|{4}|A-Z|{1}/;
                               var check = val.match(pattern);
                               if(check!=null)
                              {
                                 result=false;
                               }
                               val=$.trim(val);
                              $("#<portlet:namespace />pan").val(val);
                           return result;
                             }
            </aui:validator> --%>
		</aui:input>
		<div id="msgTextPan" class="inut-special-mention validator-error"
			style="display: none;">
		</div>
		<!-- for PF Number-->
		<aui:input name="pfNumber" type="text" onChange="javascript:checkPfNumber(this.value);"
			value="<%=emp!=null?emp.getPfNo():"" %>" label="PF Number" />
		<div id="msgTextPfNumber" class="inut-special-mention validator-error"
			style="display: none;">
		</div>
	</aui:col>
</aui:row>