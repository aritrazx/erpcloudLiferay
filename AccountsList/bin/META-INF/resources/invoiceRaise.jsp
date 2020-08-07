<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="checkBillNumber"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/checkBillNumber.jsp" />
</portlet:renderURL>

<%
	String milestoneId = ParamUtil.getString(renderRequest,"milestoneId",StringPool.BLANK);
	//out.println(" milestoneId"+milestoneId);
	/* String milestoneId1 = request.getParameter("milestoneId");
	out.println(" milestoneId1  "+milestoneId1); */
%>
<portlet:actionURL name="addBilling" var="addBillingURL" />
<aui:form name="addBilling" id="addEmployeeType" action="<%=addBillingURL%>"
	method="post">
	<aui:input name="milestoneId" type="hidden" value="<%=milestoneId%>"></aui:input>
	<aui:row>
		<aui:col span="5">
			<aui:input name="billNumber" type="text" onChange="javascript:checkBillNumber(this.value);" value=""
				label="  Bill Number">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="number"></aui:validator>
			</aui:input>
			<div id="msgCode" class="inut-special-mention validator-error"
					style="display: none;">
					<input type="hidden" name="<portlet:namespace/>msgtxt1"
						id="<portlet:namespace/>msgtxt1" value="F">
			</div>
		</aui:col></br>
		<aui:col span="5">
			<aui:input type="text" name="billingDate" id="txtToDate" value=""
				label="  Billing Date" readonly="readonly">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col></br>
		<aui:col span="2">
			<aui:button name="save" type="submit" value="save" onClick="javascript:yes();"></aui:button>
		</aui:col>
	</aui:row>
</aui:form>

<script>
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {
				maximumDate : new Date()
			}
		});
	});
	
	function checkBillNumber(t){
		//alert("call");
		var url = '<%=checkBillNumber.toString()%>';
		var val=t;
			//alert(val);
		jQuery.ajax({
		url: url,
		data:{
		'<portlet:namespace/>textvalue': val

		},
		success: function(result) {
			//alert("success");
		jQuery('#msgCode').html(result);
		jQuery('#msgCode').show();
		},
		error: function() { 
		jQuery('#msgCode').html('No Result Found'); 
		},
		type: 'POST'
		});
		}
</script>
