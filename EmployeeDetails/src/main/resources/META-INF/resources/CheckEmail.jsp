<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%
String value=ParamUtil.getString(request, "textvalue");
value = value.trim();

boolean error = false;
ThemeDisplay themeDisplay  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

if(Validator.isNull(value)){
%>
	<p style="color: red;font-size: 14px;">Email address can not blank!</p>
<%	
}else if(!Validator.isEmailAddress(value)){
%>
	<p style="color: red;font-size: 14px;">Invalid Email Address!</p>
<%		
} else {

	User auditUser = null;
	try {
		auditUser = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), value);
	} catch (Exception e) {
	}
	if (auditUser != null) {
		error = true;
	}
	if(error){ %>
	<p style="color: red;font-size: 14px;">This email id is already registered. Please enter different email address!</p>
<%
	}
}
%>