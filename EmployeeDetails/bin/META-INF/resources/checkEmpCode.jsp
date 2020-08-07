<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
String value=ParamUtil.getString(request, "textvalue",StringPool.BLANK);
boolean error = false;
System.out.println("value......"+value);
List<Employee> empCode = new ArrayList<>();


Employee employee = null;



if(Validator.isNull(value)){
	System.out.println("value1......"+value);
	%>
<p style="color: red;font-size: 14px;">Employee Code can not blank!</p>
<%
}else{
	//for(char c:value.toCharArray()){
		if(!isNumeric(value)){
			%>
			<p style="color: red;font-size: 14px;">Employee Code should be numeric!</p>
			<%
			
		}else{
			System.out.println("value.2....."+value);
			DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("employeeCode").eq(Long.parseLong(value)));
			empCode = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
				if(empCode.size() >0){
				%>
				<p style="color: red;font-size: 14px;">This Employee Code is already registered.
					Please enter different Employee Code!</p>
				<%
				}
			}	
	}



%>
<%!
public boolean isNumeric(String str) {
	try {
		double d = Double.parseDouble(str);
	} catch (NumberFormatException nfe) {
		return false;
	}
	return true;
}
%>