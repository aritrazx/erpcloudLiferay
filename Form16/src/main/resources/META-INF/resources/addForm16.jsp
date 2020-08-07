<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletURL cancelURL = renderResponse.createRenderURL();
	cancelURL.setParameter("jspPage", "/view.jsp");
	long employeeId = ParamUtil.getLong(request, "employeeId");
	
	PortletURL bulkUploadURL = renderResponse.createRenderURL();
	bulkUploadURL.setParameter("jspPage", "/bulkUpload.jsp");
	
	String employeeName = ParamUtil.getString(request, "employeeName", StringPool.BLANK);
	Employee employee = null;
	if(Validator.isNotNull(employeeId)){
		try{
			employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/view.jsp");
	
	PortletURL assignURL = renderResponse.createRenderURL();
	assignURL.setWindowState(LiferayWindowState.POP_UP);
	assignURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

	
%>
<liferay-ui:header title="Add Form16" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<aui:row>
<aui:col span="10">
</aui:col>
<aui:col span="2">
<a class="btn btn-primary btn-default" name="bulkUpload"
			type="submit" href="<%=bulkUploadURL.toString()%>">Bulk Upload</a>
			</aui:col>
</aui:row>
<liferay-ui:error key="error"
	message="Your have already uploaded your form for this Financial Year!" />
<liferay-ui:error key="error1"
	message="Please Choose a Employee !" />
<portlet:actionURL name="addFormSixteen" var="addFormSixteenURL" />
<aui:form name="addFormSixteen" action="<%=addFormSixteenURL.toString() %>" method="post">
	<input name="<portlet:namespace />employeeId" id="employeeId"
		type="hidden" label="" value="<%=employeeId%>"></input>
	<aui:row>
		<aui:col span="6">
			<aui:select id="financialYear" name="financialYear"
				label="Financial Year">
				<aui:option selected="true" value="2018-2019">2018-2019</aui:option>
				<aui:option value="2017-2018">2017-2018</aui:option>
				<aui:option value="2016-2017">2016-2017</aui:option>
				<aui:option value="2015-2016">2015-2016</aui:option>
				<aui:option value="2014-2015">2014-2015</aui:option>
			</aui:select>
		</aui:col>
		<aui:col span="6">
			<aui:input name="employeeName" id="employeeName"
				label="Click here to add Employee" type="text" readonly="readonly"
				value="<%=employee != null
									? (employee.getFirstName() + " " + employee.getLastName())
									: employeeName%>"
				onClick="popup()">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<label><h3>Upload supporting documents if needed (pdf
					Only)</h3></label>
			<aui:input label="" type="file" name="uploadedFiles1" value="" >
				<aui:validator name="acceptFiles">'pdf'</aui:validator>
				<aui:validator name="required"/>
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button  type="submit" name="saveButton" value="save"
			cssClass="btn btn-success" />
		<aui:button name="cancelButton" type="cancel" value="cancel"
			onClick="<%=cancelURL.toString()%>" cssClass="btn btn-danger" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
	
	$(document).ready(function() {
		selectEmployee = function(employeeId, employeeName) {

		$('#employeeId').val(employeeId);
		$('#<portlet:namespace />employeeName').val(employeeName);
		};
		});
	
	
	</script>
<aui:script>
	function popup() {
		var url = '<%=assignURL.toString()%>';
		console.log("url--"+url);
		var employeeId = $("#<portlet:namespace/>employeeId").val();
		console.log("employeeId--"+employeeId);
		//alert("employeeId "+employeeId);
		//$("#<portlet:namespace/>employeeId").val();
		Liferay.Util.openWindow({
			dialog : {
				//cssClass: 'aui-popup-example',
				destroyOnHide : true,
				height : 600,
				width : 550,
				close: true
			},
			dialogIframe : {
			//bodyCssClass: 'custom-css-class'
			},
			title : 'Add Employee',
			uri : url

		});
		/* if(employeeId!=0){
			popWindow.destroy();
		} */
	}
	
</aui:script>