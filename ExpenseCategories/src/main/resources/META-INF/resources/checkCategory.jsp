<%@page import="com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpCategory"%>
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
String value=ParamUtil.getString(request, "textvalue");
boolean error = false;
System.out.println("value......"+value);
List<ExpCategory> expCatList = new ArrayList<>();
ExpCategory expCategory = null;



if(Validator.isNull(value)){
	System.out.println("value1......"+value);
	%>
<p style="color: red;font-size: 14px;">category name can not blank!</p>
<%
}else{
	//for(char c:value.toCharArray()){
	
			System.out.println("value.2....."+value);
			DynamicQuery dynamicQuery = ExpCategoryLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("categoryName").eq(value));
			expCatList = ExpCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("expCatList......"+expCatList);
				if(expCatList.size() >0){
				%>
				<p style="color: red;font-size: 14px;">This category name is already registered.
					Please enter different category name!</p>
				<%
				}
				
	}



%>
