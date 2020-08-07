<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%
List<PayComponent> components = new ArrayList<>();
components = PayComponentLocalServiceUtil.getPayComponents(-1, -1);

PortletURL addTaxSettingURL = renderResponse.createActionURL();
addTaxSettingURL.setParameter("javax.portlet.action", "addTaxSetting");

%>

<aui:form action="<%=addTaxSettingURL.toString() %>" >

<aui:select name="componentId" id="componentName" label="Component Name" >
	<aui:option value="">Select</aui:option>
	<%if(components.size()>0) {
	  for(PayComponent component:components){
	%>
	<aui:option value="<%=component.getComponentId() %>"><%=component.getName() %></aui:option>
	<%} }%>
	
</aui:select>

<aui:select name="operator" id="operator" label="Operator" >
	<aui:option value="">Select</aui:option>
	<aui:option value="(">(</aui:option>
	<aui:option value="*">*</aui:option>
	<aui:option value=")">)</aui:option>
	<aui:option value="+">+</aui:option>
	<aui:option value="-">-</aui:option>
	<aui:option value="/">/</aui:option>
</aui:select>
<aui:select name="component" id="component" label="Component" >
	<aui:option value="">Select</aui:option>
	<aui:option value="TotalPay">Total Pay</aui:option>
	<%if(components.size()>0) {
	  for(PayComponent component:components){
	%>
	<aui:option value="<%=component.getComponentId()+"_" %>"><%=component.getName() %></aui:option>
	<%} }%>
	
</aui:select>
<aui:select name="isMetro" id="isMetro" label="Metro" >
	<aui:option value="">Select</aui:option>
	<aui:option value="yes">Yes</aui:option>
	<aui:option value="no">No</aui:option>
	</aui:select>
<aui:input name="valueBox" id="valueBox" label="Value Box" onChange="" ></aui:input>

<aui:button name="button" type="button" value="Add" onClick="javascript:generateFormulla()" />

<aui:button name="button" type="button" value="Remove" onClick="javascript:removeFormulla()" />

<span id="formulaSubmit">


</span>
<div class="formulaHead" >
<aui:input type="text" name="formullaValue" id="formullaValue" label="Formula" readOnly="true"  > </aui:input>
<%-- 
	<aui:input cssClass="salary"  name="formulla" label="Formula" ></aui:input> --%>
	<span>Formula:</span>
	<label id="formulla"></label> 
	<label id="formullaText"></label> 
</div>
<aui:button name="button" type="submit" value="Save" />
</aui:form>
<%-- <aui:button onClick="AUI().DialogManager.closeByChild(this);" type="button" value="cancel" />
<aui:button cssClass="close-panel" type="cancel" value="close" /> --%>
<aui:script>

$(document).ready(function(){
	$('#formulla').hide();
})
function generateFormulla(){
	
	//var cmponent= $( "#<portlet:namespace/>component" ).val();
	var componentText;
	var cmponent   = $('#<portlet:namespace/>component').find("option:selected").val();
	if(cmponent!=""){
		componentText  = $('#<portlet:namespace/>component').find("option:selected").text();
	}
	var oprtor = $( "#<portlet:namespace/>operator" ).val();
	var valueBox = $( "#<portlet:namespace/>valueBox" ).val();	
	if(cmponent=="" && oprtor=="" && valueBox==""){
		alert("Please put the value and then click on Add");
		return false;
	}
	if(cmponent!="" && oprtor!="" && valueBox!=""){
		alert("Maximum on input only you can fill");
		return false;
	}
	if(cmponent!="" && oprtor!="" || oprtor!="" && valueBox!="" || cmponent!="" && valueBox!=""){
		alert("Maximum on input only you can fill");
		return false;
	}
	var formlla = $("#formulla" ).text();
	var formullaText = $("#formullaText" ).text();
	if(cmponent!=""){
		$( "#formulla" ).html(formlla).append(cmponent);
		var formula = $( "#formulla" ).html();
		$( "#formullaText" ).html(formullaText).append(componentText);
		var formullaText = $( "#formullaText" ).html();
		$("#<portlet:namespace/>formullaValue").val(formula);
		$( "#<portlet:namespace/>component" ).val("");
	}else if(oprtor!=""){
		$( "#formulla" ).html(formlla).append(oprtor);
		var formula = $( "#formulla" ).html();
		$( "#formullaText" ).html(formullaText).append(oprtor);
		var formullaText = $( "#formullaText" ).html();
		$("#<portlet:namespace/>formullaValue").val(formula);
		$( "#<portlet:namespace/>operator" ).val("");
	}else if(valueBox!=""){
		$( "#formulla" ).html(formlla).append(valueBox);
		var formula = $( "#formulla" ).html();
		$( "#formullaText" ).html(formullaText).append(valueBox);
		var formullaText = $( "#formullaText" ).html();
		$("#<portlet:namespace/>formullaValue").val(formula);
		$( "#<portlet:namespace/>valueBox" ).val("");
	}
}

function removeFormulla(){
	$( "#formulla" ).text('');
	$( "#<portlet:namespace/>formullaValue" ).val('');
	$( "#formullaText" ).text('');
}


</aui:script>
<style>
.portal-popup .columns-max > .portlet-layout.row > .portlet-column{
	padding: 25px;
}

.formulaHead{
	padding-bottom: 10px;
    padding-top: 10px;
    }
</style>