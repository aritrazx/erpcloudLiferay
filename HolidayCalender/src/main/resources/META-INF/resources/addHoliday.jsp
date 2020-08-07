<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
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
<%

	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setParameter("jspPage", "/view.jsp");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	long holidayId = ParamUtil.getLong(request, "holidayId");
	System.out.println("holidayId-->"+holidayId);
	boolean editURL = false;
	HolidayCalenderManagement calenderManagement = null;
	if (holidayId != 0) {
		editURL = true;
		try {
			calenderManagement = HolidayCalenderManagementLocalServiceUtil.getHolidayCalenderManagement(holidayId);
		} catch (Exception e) {

		}
	}
%>
<%-- <portlet:resourceURL id="exportAction" var="exportURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLS" />
</portlet:resourceURL>
<portlet:resourceURL id="exportAction" var="checkURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLSToCheck" />
</portlet:resourceURL> --%>
<liferay-ui:error key="Add-name-error"
	message="Sorry, Holiday Name Already Exist" />
<liferay-ui:error key="Add-date-error"
	message="Sorry, Holiday Date Already Exist" />
<aui:row>
	<aui:col span="10">
	</aui:col>

	<aui:col span="2">
		<%-- <a class="btn btn-primary btn-default" name="generateTemplate"
				href="<%=exportURL.toString()%>">Generate
				Template</a> --%>
	</aui:col>
</aui:row>
<portlet:actionURL name="holidayCalenderSave"
	var="holidayCalenderSaveURL" />
<portlet:actionURL name="holidayCalenderEdit"
	var="holidayCalenderEditURL" />
<aui:form name="holidayCalenderSave"
	action="<%=editURL != true ? holidayCalenderSaveURL.toString() : holidayCalenderEditURL.toString()%>"
	method="post">
	<aui:row>
	<aui:input type="hidden" name="holidayId"
					value="<%=calenderManagement != null ? calenderManagement.getHolidayId() : ""%>" />
		<aui:col span="5">
			<aui:input name="holidayDate" type="text"
				value="<%=calenderManagement != null
									? dateFormat.format(calenderManagement.getHolidayDate())
									: ""%>"
				label="Holiday Date">
				<aui:validator name="required" />
			</aui:input>
		</aui:col>
		<aui:col span="5">
			<aui:input name="holidayName" type="test"
				value="<%=calenderManagement != null ? calenderManagement.getHolidayName() : ""%>"
				label="Holiday Name">
				<aui:validator name="required" />
			</aui:input>
		</aui:col>

		<aui:col span="2">
			<aui:button name="save" type="submit" value="save"></aui:button>
			<aui:button name="cancelButton" type="cancel" value="cancel"
			onClick="<%=viewURL.toString()%>" cssClass="btn btn-danger" />
		</aui:col>
	</aui:row>
</aui:form>
<aui:script>
	AUI().use('aui-datepicker', function(A) {
		new A.DatePicker({
			trigger : '#<portlet:namespace/>holidayDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1000
			}
		});
	});
</aui:script>
<%-- <script type="text/javascript">
var url = '<%= csvUploadForUnclaimedDepositor.toString()%>';
function ajaxFileUpload()
{
   jQuery(".loading-animation").ajaxStart(function(){
        jQuery(this).show();
    }).ajaxComplete(function(){
        jQuery(this).hide();
    }); 
   jQuery.ajaxFileUpload
    (
        {
            url:url, 
            secureuri:false,
            fileElementId:'fileupload',
            dataType: 'html',
			beforeSend:function()
			{
				$(".loading-animation").show();
				$(".success").hide();
			},
			complete:function()
			{
				$(".loading-animation").hide();
				$(".success").show();
			},				
			success: function (data, status)
			{
			},
			error: function (data, status, e)
			{
			}
        }
    );
    
    return false;
}
function ajaxFunction()
{
	var file = jQuery('#fileupload').val();

		if (file.match(/\.csv$/)) {
			ajaxFileUpload();
		} else {
			alert("Please Select Any CSV File!");
			return false;
		}	
}
</script> --%>