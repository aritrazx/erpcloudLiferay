<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="init.jsp" %>
<%
String firstName=ParamUtil.getString(request, "textvalue1");
String DOB=ParamUtil.getString(request, "textvalue");
String lastName=ParamUtil.getString(request, "textvalue2");
boolean error = false;
System.out.println("value......"+firstName);
List<RecruitProcess> candList = new ArrayList<>();
RecruitProcess recruitProcess = null;



if(Validator.isNull(firstName)||Validator.isNull(lastName)||Validator.isNull(DOB)){
	System.out.println("value1......"+lastName);
	%>
<p style="color: red;font-size: 14px;">First name and Last name can not blank!</p>
<%
}else{
	//for(char c:value.toCharArray()){
	
			//System.out.println("value.2....."+value);
			DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("firstName").eq(firstName));
			dynamicQuery.add(PropertyFactoryUtil.forName("lastName").eq(lastName));
			dynamicQuery.add(PropertyFactoryUtil.forName("DOB").eq(DOB));
			candList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("expCatList......"+candList);
				if(candList.size() >0){
				%>
				<p style="color: red;font-size: 14px;">This  name is already registered.
					Please enter different  name!</p>
				<%
				}
				
	}



%>
