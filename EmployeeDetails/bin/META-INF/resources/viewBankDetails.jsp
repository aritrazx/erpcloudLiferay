<%@page import="com.liferay.famocom.erpcloud.service.BankMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.BankMasterLocalService"%>
<%@page import="com.liferay.famocom.erpcloud.model.BankMaster"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	BankMaster bankMaster = null;
	try{
		if(Validator.isNotNull(emp.getBankId())){
			bankMaster =  BankMasterLocalServiceUtil.getBankMaster(emp.getBankId());
		}
		
	}catch(Exception e){
		
	}
	
%>
<aui:row>
	<aui:col span="6">
		<p>
			Bank Name: <b style="color: #f48120;"><%=bankMaster!=null?bankMaster.getBankName():""%></b>
		</p></br>
		<p>
			Account Number: <b style="color: #f48120;"><%=emp.getAccountNo()%></b>
		</p></br>
		<p>
			Aadhaar No: <b style="color: #f48120;"><%=emp.getAadhaarNo()%></b>
		</p></br>
	</aui:col>
	<aui:col span="6">
		<p>
			Pan Number: <b style="color: #f48120;"><%=emp.getPanNo() %></b>
		</p></br>
		<p>
			PF Number: <b style="color: #f48120;"><%=emp.getPfNo()%></b>
		</p></br>
	</aui:col>
</aui:row>