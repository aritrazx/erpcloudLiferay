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
	backURL.setParameter("jspPage", "/view.jsp");
	
	String fileNotUploadList = (String) request.getAttribute("fileNotUpload");
	System.out.println(":::::::fileNotUpload:::::" + fileNotUploadList);
	String msg = fileNotUploadList + " are not Uploaded!";
	System.out.println(":::::msg:::::::" + msg);
	if(Validator.isNotNull(fileNotUploadList)){
%>
<liferay-ui:header title="Bulk Upload" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<div id="erDiv" tabindex="0" class="message_error divLft"
	<%if (!msg.isEmpty() && msg.length() > 0) {%>
	style="display: inline; width: 100%;" <%} else {%>
	style="display: none;" <%}%>>
	<table>
		<%
			if (!msg.isEmpty() && msg.length() > 0) {
				msg = msg.substring(1, msg.length() - 1);
				String erArray[] = msg.split(",");
				for (int i = 0; i < erArray.length; i++) {
		%>
		<tr>
			<td style="color:red"><%=erArray[i]%>,</td>
		</tr>
		<%
			}
			}
		%>
	</table>
</div>
<%} %>
<portlet:actionURL name="addZipFile" var="addZipFileURL" />
<aui:form name="addZipFile" enctype="multipart/form-data"
	action="<%=addZipFileURL.toString()%>" method="post">
	<aui:row>
		<aui:col span="6">
			<aui:select id="financialYear" name="financialYear"
				label="Financial Year">
				<aui:option selected="true" value="2017-2018">2017-2018</aui:option>
				<aui:option value="2016-2017">2016-2017</aui:option>
				<aui:option value="2015-2016">2015-2016</aui:option>
				<aui:option value="2014-2015">2014-2015</aui:option>
			</aui:select>
		</aui:col>
		<aui:col span="6">
			<label><h3>Upload supporting documents if needed (Zip
					Only)</h3></label>
			<aui:input label="" type="file" name="uploadedFiles" value="">
			</aui:input>
		</aui:col>
		
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" name="saveButton" value="save"
			cssClass="btn btn-success" />
		<aui:button name="cancelButton" type="cancel" value="cancel"
			cssClass="btn btn-danger" />
	</aui:button-row>
</aui:form>