<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AttendanceCheckList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringParser"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:error key="Error"
	message="Sorry,Something wrong in attendance sheet!" />
<%-- <liferay-ui:error key="error1" message="Sorry,Attendance Already Exist!"/>
<liferay-ui:error key="error2" message="Sorry,Employee not exist in the list!"/>
<liferay-ui:error key="inTimeHrError" message="Wrong Input!Value cannot be Alphabetic or Special Character"/>
<liferay-ui:error key="inTimeOutTimeError" message="Hour value must be within 24 and minute value must be within 60 "></liferay-ui:error> --%>

<%
	//String error= StringPool.BLANK;
	String errorValue = ParamUtil.getString(request, "error", StringPool.BLANK);
	System.out.println("-----------------error-----------------" + errorValue);
	List<String> check = new ArrayList<>();
	List<AttendanceCheckList> attCheckList = AttendanceCheckListLocalServiceUtil.getAttendanceCheckLists(-1,-1);
	if(Validator.isNotNull(attCheckList)){
		for(AttendanceCheckList attListObj : attCheckList){
			System.out.println("attListObj.getStatus():--"+attListObj.getStatus());
			if(attListObj.getStatus()=="Error"){
				check.add("A");
			}
			System.out.println("check:--"+check.size());
		}
	}
%>

<portlet:resourceURL id="exportAction" var="exportURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLS" />
</portlet:resourceURL>
<portlet:resourceURL id="exportAction" var="checkUrl">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLSToCheck" />
</portlet:resourceURL>
<portlet:actionURL name="manualAttendance" var="manualAttendanceURL" />
<aui:form name="manualAttendance" action="<%=manualAttendanceURL%>"
	method="post">
	<aui:row>
		<aui:col span="8">
			<label><h2>Attendance Import</h2></label>
		</aui:col>
		<%
			//System.out.println("-----------------errorfrom-----------------"+error);
			if (check.size()!=0) {
						//System.out.println("-----------------erroriffff-----------------"+error);
		%>
		<aui:col span="2">
			<a class="active btn btn-warning" name="checkSheet" type="button"
				href="<%=checkUrl.toString()%>">Check Sheet</a>
		</aui:col>
		<%
			}else{
		%>
		<aui:col span="2">
		
		
		</aui:col>
		<%} %>
		<aui:col span="2">
			<%-- <aui:button name="generateTemplate" type="button"
			href="<%=exportURL.toString()%>"  class="btn_export_to_xls" value="Generate Template"></aui:button> --%>
			<a class="btn btn-primary btn-default" name="generateTemplate"
				type="submit" href="<%=exportURL.toString()%>">Generate
				Template</a>
		</aui:col>
	</aui:row>
	</br>
	</br>

	<aui:row>
		<aui:col span="3">
			<aui:input type="text" name="date" id="txtToDate_id" value=""
				label="Date" readonly="readonly">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
		<aui:col span="3">
			<label>Upload Type</label>
			<aui:input type="radio" name="manualExcel" cssClass="uploadType"
				label="Manual excel" value="1" id="exlradio" checked="true"></aui:input>
			<aui:input type="radio" name="manualExcel" cssClass="uploadType"
				label="Biomatrix" value="2" id="datradio"></aui:input>
		</aui:col>
		<aui:col span="4">
			<aui:input id="files" type="file" name="uploadDoc" value=""
				label="Upload attendance file(.xls/.dat)" />
		</aui:col>
		<aui:col span="2">
		<span><br/></span>
			<aui:button name="import" type="submit" value="Import" id="import"></aui:button>
		</aui:col>
	</aui:row>
</aui:form>


<script>
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate_id',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {
				maximumDate : new Date()
			}
		});
	});
</script>

<script>
	$("#<portlet:namespace />import")
			.click(
					function(e) {
						var inpFielVal = $("#<portlet:namespace />files").val();
						var exlRadioVal = $("#<portlet:namespace />exlradio")
								.val();
						//alert('exlRadioVal:-'+exlRadioVal);
						var datRadioVal = $("#<portlet:namespace />datradio")
								.val();
						var radioVal = $(
								"input[name='<portlet:namespace />manualExcel']:checked")
								.val();

						console.log("radio value is" + radioVal);

						var finalFileName = inpFielVal.replace(/^.*\\/, "");
						console.log("after replacing	-------------> "
								+ finalFileName);
						var fileSplit = new Array();
						var fileSplit = finalFileName.split(".");
						console.log("after Spliting	-------------> "
								+ fileSplit[1]);
						if(fileSplit[1]!=null){
						if (exlRadioVal == radioVal) {
							switch (fileSplit[1]) {
							case 'xls':
							case 'xlsx':
							
								//console.log("Excel file submitted Succesfully");
								break;
							default:
								alert('Your file extension is wrong.');
								return false;
							}
						}
						if (datRadioVal == radioVal) {
							switch (fileSplit[1]) {
							case 'dat':
								console.log("Excel file submitted Succesfully");
								break;
							default:
								alert('Your file extension is wrong.');
								return false;
							}

						}
						}else{
							alert('Please select a file !');
							return false;
						}
						//if(exlRadioVal==null && )
					});
</script>
