<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="init.jsp" %>
<%
String email = ParamUtil.getString(request, "textval");


System.out.println("value......"+email);
List<RecruitProcess> candList = new ArrayList<>();
RecruitProcess recruitProcess = null;



if(Validator.isNull(email)){
	System.out.println("value1......"+email);
	%>
<p style="color: red;font-size: 14px;">email can not be blank!</p>
<%
}else{
			DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
 				dynamicQuery.add(PropertyFactoryUtil.forName("email").like("%"+email+"%"));
 				 candList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
 				if(candList.size()>0){
 					%>
 					<p style="color: red;font-size: 14px;">This  email is already registered.
 						Please enter different  email!</p>
 					<%
 				}
			   System.out.println("expCatList......"+candList);
				
				
	}



%>
