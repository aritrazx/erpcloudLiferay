<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.famocom.erpcloud.model.FormSixteenErrorFile"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="/init.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/addForm16.jsp");
	
	String errorValue = ParamUtil.getString(request, "error", StringPool.BLANK);
	System.out.println("-----------------error-----------------" + errorValue);
	List<String> check = new ArrayList<>();
	List<FormSixteenErrorFile> errorFiles = FormSixteenErrorFileLocalServiceUtil.getFormSixteenErrorFiles(-1,
			-1);
	if (Validator.isNotNull(errorFiles)) {
		for (FormSixteenErrorFile errorFile : errorFiles) {
			System.out.println("attListObj.getStatus():--" + errorFile.getErrorMsg());
			if (!errorFile.getErrorMsg().isEmpty()) {
				check.add("A");
			}
			System.out.println("check:--" + check.size());
		}
	}
%>
<liferay-ui:header title="Bulk Upload" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<portlet:resourceURL id="exportAction" var="exportURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLS" />
</portlet:resourceURL>
<portlet:resourceURL id="exportAction" var="checkUrl">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLSToCheck" />
</portlet:resourceURL>
<portlet:actionURL name="addZipFile" var="addZipFileURL" />
<aui:form name="addZipFile" enctype="multipart/form-data"
	action="<%=addZipFileURL.toString()%>" method="post">
		<aui:row>
		<aui:col span="8">
			<label><h2>PDF Upload</h2></label>
		</aui:col>
		<%
			//System.out.println("-----------------errorfrom-----------------"+error);
					if (check.size() != 0) {
						//System.out.println("-----------------erroriffff-----------------"+error);
		%>
		<aui:col span="2">
			<a class="active btn btn-warning" name="checkSheet" type="button"
				href="<%=checkUrl.toString()%>">Check Sheet</a>
		</aui:col>
		<%
			} else {
		%>
		<aui:col span="2">


		</aui:col>
		<%
			}
		%>
	</aui:row>
	<aui:row>
		<aui:col span="4">
			<aui:select id="financialYear" name="financialYear"
				label="Financial Year">
				<aui:option selected="true" value="2018-2019">2018-2019</aui:option>
				<aui:option value="2017-2018">2017-2018</aui:option>
				<aui:option value="2016-2017">2016-2017</aui:option>
				<aui:option value="2015-2016">2015-2016</aui:option>
				<aui:option value="2014-2015">2014-2015</aui:option>
			</aui:select>
		</aui:col>
		<aui:col span="4">
			<label><h3>Upload supporting documents if needed (Zip
					Only)</h3></label>
			<aui:input label="" type="file" name="uploadedFiles" value="">
				<aui:validator name="acceptFiles">'zip'</aui:validator>
				<aui:validator name="required"/>
			</aui:input>
		</aui:col>
		<aui:col span="4">
			<aui:select id="matchingPDFFileName" name="matchingPDFFileName"
				label="Matching PDF File Name :">
				<aui:option selected="true" value="panNo">PAN Number</aui:option>
				<aui:option value="aadharNo">Aadhar Number</aui:option>
				<aui:option value="employeeCode">Employee Code</aui:option>
			</aui:select>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" name="saveButton" value="save"
			cssClass="btn btn-success" />
		<aui:button name="cancelButton" type="cancel" value="cancel"
			cssClass="btn btn-danger" />
	</aui:button-row>
</aui:form>