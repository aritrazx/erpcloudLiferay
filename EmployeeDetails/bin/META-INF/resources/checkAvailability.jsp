<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
	String value = ParamUtil.getString(request, "textvalue");

	System.out.println("value......" + value);

	User auditUser = null;
	int flag = 0;
	String s = "T";

	if (value.split("\\s+").length > 1) {
		flag = 2;
		s = "F";

	} else if (value.indexOf("@") > 0 || value.indexOf("%") > 0 || value.indexOf("#") > 0
			|| value.indexOf("!") > 0 || value.indexOf("$") > 0 || value.indexOf("&") > 0
			|| value.indexOf("*") > 0 || value.indexOf("^") > 0) {
		flag = 3;
		s = "F";
	} else if (Validator.isNumber(value)) {
		flag = 4;
		s = "F";
	} else {
		System.out.println("value>>>>>......" + value);
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			System.out.println("themeDisplay.getCompanyId()......" + themeDisplay.getCompanyId());
			auditUser = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), value);
			System.out.println("auditUser......" + auditUser);
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		if (auditUser != null) {
			flag = 1;
			s = "F";
		}
	}
	if (value.isEmpty() || value.equals("")) {
		System.out.println("inside value......");
		flag = 1;
		s = "F";
	}

	if (flag == 0) {
%>

<p style="color: green;font-size: 14px;">User Name is available !!</p>
<input type="hidden" name="<portlet:namespace/>msgtxt"
	id="<portlet:namespace/>msgtxt" value="T">
<%
	} else if (flag == 2) {
%>

<p>Space is not allowed in User Name !!</p>
<input type="hidden" name="<portlet:namespace/>msgtxt"
	id="<portlet:namespace/>msgtxt" value="T">
<%
	} else if (flag == 3) {
%>

<p>Special character is not allowed in User Name !!</p>
<input type="hidden" name="<portlet:namespace/>msgtxt"
	id="<portlet:namespace/>msgtxt" value="T">
<%
	} else if (flag == 4) {
%>

<p>User name can not be numeric !!</p>
<input type="hidden" name="<portlet:namespace/>msgtxt"
	id="<portlet:namespace/>msgtxt" value="T">
<%
	} else {
%>
<p style="color: red;font-size: 14px;">User Name is not available !!</p>

<input type="hidden" name="<portlet:namespace/>msgtxt"
	id="<portlet:namespace/>msgtxt" value="F">
<%}

%>