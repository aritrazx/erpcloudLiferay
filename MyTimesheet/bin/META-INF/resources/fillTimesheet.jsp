<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
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
String id = ParamUtil.getString(request, "id");
String id1 = id.split("-")[0];
String actualId = id1.replace("hours", "");
System.out.println("actualId......"+actualId);
System.out.println("id......"+id);
String conditionCheck = "hours"+actualId+"--";
String conditionCheck1 = "hours"+actualId+"-0-";
String hours = "";
String workDesc = "";
if(!id.equals(conditionCheck) && !id.equals(conditionCheck1)){
hours = id.split("-")[1];
workDesc = id.split("-")[2];
}
System.out.println("hours......"+hours);
System.out.println("workDesc......"+workDesc); 
PortletURL calHrURL = renderResponse.createRenderURL();
calHrURL.setWindowState(LiferayWindowState.EXCLUSIVE);
//assignURL.setParameter("projectId",String.valueOf(projectId));
calHrURL.setParameter("jspPage", "/META-INF/resources/fillTimesheet.jsp");
%>
<aui:form cssClass="customForm">
<aui:input name="actualId" id="actualId" type="hidden" value="<%=actualId %>"></aui:input>
<aui:row>
<aui:col span="4">
<aui:input name="hours" type="text" label="Hours" id="hours"
		value="<%=hours %>">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="number"></aui:validator>
		<aui:validator name="min">1</aui:validator>
		<aui:validator name="max">8</aui:validator>
</aui:input>
</aui:col>
<aui:col span="4">
<aui:input name="workDescription" type="textarea" id="workDescription"
		label="Work Description" placeholder="Work Description"
		value="<%=workDesc %>" >
		<aui:validator name="required"></aui:validator>
		</aui:input>
</aui:col>
</aui:row>

<input type="button" name="choose" class="btn btn-primary btn-default" value="Save"  onClick="closePopUp()" />
</aui:form>

<div id="showHr"></div>
<script type="text/javascript">

function closePopUp(){
	var hrs = document.getElementById('<portlet:namespace/>hours').value;
	var workDesc = document.getElementById('<portlet:namespace/>workDescription').value;
	var id = $('#<portlet:namespace />actualId').val();
	console.log("hours---"+hrs);
	Liferay.Util.getOpener().fillHours(hrs,id,workDesc);
	
	
}


<%-- function calculateHours(hours){
	//alert(list);
   url="<%=calHrURL.toString()%>";
		$.ajax({
			type : "post",
			url : url,
			data : {
				"<portlet:namespace/>hours" : hours	
			},
			success : function(data) {
				$("#showHr").html(data);
			}
		});
	} --%>
</script>


<style>

.customForm{

    padding-left: 10px;
    padding-right: 10px;

}

</style>