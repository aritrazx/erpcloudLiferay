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
	long billingId = ParamUtil.getLong(request,"billingId");
	long milestoneId = ParamUtil.getLong(request,"milestoneId");
	System.out.println("milestoneId:-"+milestoneId);
%>
<portlet:actionURL name="uploadBilling" var="uploadBillingURL" />
<aui:form name="uploadBilling" id="uploadBilling" action="<%=uploadBillingURL%>"
	method="post">
	<aui:input name="billingId" type="hidden" value="<%=billingId %>"></aui:input>
	<aui:input name="milestoneId" type="hidden" value="<%=milestoneId %>"></aui:input>
	<div id="auto-fields-container">
	<div class="lfr-form-row lfr-form-row-inline">
	<aui:input label="U" name="fileIdValue" value="1" type="hidden"  />
	<aui:col span="3">
	<aui:input label="Upload File" name="billing1" type="file"/>
	</aui:col>
	<aui:col span="3">
	<aui:input label="Document Name" name="billTitle1" type="text" required="true"/>
	</aui:col>
	<aui:col span="2">
	</aui:col>
	</div>
	</div>
	<aui:button name="save" type="submit" value="save"></aui:button>
</aui:form>

<aui:script use="liferay-auto-fields">
	new Liferay.AutoFields({
	contentBox: '#auto-fields-container',
	fieldIndexes: '<portlet:namespace />rowIndexes',
	on: {
	'clone': function(event) {
	console.log('clone');
	console.log(event);
	var no = $('#<portlet:namespace />fileIdValue').val();
	//alert("no " + no);
	no++;
	var latestfileId = 'billing'+no; 
	//alert("no1 "+latestfileId);
	//alert("no1 "+'#<portlet:namespace />'+latestfileId);
	 $('#<portlet:namespace />'+latestfileId).val(''); 
	},
	'delete': function(event) {
	console.log('delete');
	console.log(event);
	
	}
	},
	sortable: true,
	sortableHandle: '.lfr-form-row'
	}).render();
</aui:script>