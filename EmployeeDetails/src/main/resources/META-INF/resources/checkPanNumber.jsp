<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
	String value = ParamUtil.getString(request, "textvalue", StringPool.BLANK);
	boolean error = false;
	System.out.println("value......" + value);
	List<Employee> panNumber = new ArrayList<>();

	Employee employee = null;

	if (Validator.isNull(value)) {
		System.out.println("value1......" + value);
%>
<!-- <p style="color: red;font-size: 14px;">Employee Code can not blank!</p> -->
<%
	} else {
		if (!isValidPan(value)) {
%>
<p style="color: red; font-size: 14px;">Pan No should be in Valid
	Format!</p>
<%
	} else {
			System.out.println("value.2....." + value);
			DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("panNo").eq(value));
			panNumber = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("value.3....." + panNumber.size());
			if (panNumber.size() > 0) {
				System.out.println("value.4....." + panNumber.size());
%>
<p style="color: red; font-size: 14px;">This Pan Number is already
	registered. Please enter different pan Number!</p>
<%
	}
		}

	}
%>

<%!public boolean isValidPan(String str) {
		// String s = "ABCDE1234F"; // get your editext value here
		boolean isPan = false;
		Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		Matcher matcher = pattern.matcher(str);
		// Check if pattern matches 
		if (matcher.matches()) {
			System.out.println("yes");
			isPan = true;
		} else {
			System.out.println("no");
			isPan = false;
		}
		return isPan;
	}%>
<%-- <%!
public boolean isNumeric(String str) {
	try {
		double d = Double.parseDouble(str);
	} catch (NumberFormatException nfe) {
		return false;
	}
	return true;
}
%> --%>