


<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.famocom.erpcloud.service.BillingLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.Billing"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
String value=ParamUtil.getString(request, "textvalue");
boolean error = false;
System.out.println("value......"+value);
List<Billing> billNumber = new ArrayList<>();


Billing billing = null;



if(Validator.isNull(value)){
	System.out.println("value1......"+value);
	%>
<p style="color: red;font-size: 14px;">Bill Number can not blank!</p>
<%
}else{
		System.out.println("value.2....."+value);
		DynamicQuery dynamicQuery = BillingLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("billingNumber").eq(value));
		billNumber = BillingLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("billNumber.size()......"+billNumber.size());
			if(billNumber.size() >0){
			%>
			<p style="color: red;font-size: 14px;">This Bill Number is already registered.
				Please enter different Bill Number!</p>
			<%
	}}
%>
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