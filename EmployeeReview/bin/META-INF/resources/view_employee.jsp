<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@ include file="init.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<portlet:actionURL name="approveEmployee" var="approveEmployee"></portlet:actionURL>
<portlet:actionURL name="rejectEmployee" var="rejectEmployee"></portlet:actionURL>
<liferay-ui:error key="duplicate-email-name" message="duplicate-email-name"></liferay-ui:error>
<liferay-ui:error key="duplicate-emp-code" message="duplicate-emp-codess"></liferay-ui:error>




<liferay-ui:tabs names="Basic Information,Bank details" refresh="false" tabsValues="Basic Information,Bank details">
	<liferay-ui:section>
		<%@ include file="basicInfo.jsp" %>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<%@ include file="bankDetails.jsp" %>
	</liferay-ui:section>
	
</liferay-ui:tabs>



<aui:row>
<aui:col span="6">
<aui:input label="Comment"  name="comment" type="textarea"></aui:input>
</aui:col>
<aui:col span="3">
<aui:form name="editEmployee" action="<%=approveEmployee.toString() %>" method="post" enctype="multipart/form-data">
<aui:input name="empId" type="hidden" value="${empDetails.employeeId}" />

<aui:button name="approve" type="submit" value="Approve"></aui:button>
</aui:form>

</aui:col>
<aui:col span="3">
<aui:form name="editEmployee" action="<%=rejectEmployee.toString() %>" method="post" enctype="multipart/form-data">
<aui:input name="empId" type="hidden" value="${empDetails.employeeId}" />

<aui:button name="reject" type="submit" value="Reject"></aui:button>
</aui:form>
</aui:col>
</aui:row>



