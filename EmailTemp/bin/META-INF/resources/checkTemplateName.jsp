<%@page import="com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmailTemplate"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
String value=ParamUtil.getString(request, "textvalue");
boolean error = false;
System.out.println("value......"+value);
List<EmailTemplate> eTemp = new ArrayList<>();
EmailTemplate emailTemplate = null;



if(Validator.isNull(value)){
	System.out.println("value1......"+value);
	%>
<p style="color: red;font-size: 14px;">Template Name can not blank!</p>
<%
}else{
			System.out.println("value.2....."+value);
			DynamicQuery dynamicQuery = EmailTemplateLocalServiceUtil.dynamicQuery();
			System.out.println("value.3....."+value);
			dynamicQuery.add(PropertyFactoryUtil.forName("templateName").eq(value));
			System.out.println("value.4....."+value);
			eTemp = EmailTemplateLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("value.5....."+eTemp.size());
				if(eTemp.size()>0){
					System.out.println("value.66....."+eTemp.size());
				%>	
				<p style="color: red;font-size: 14px;">This Template Name is already registered.</p>
				<%
				}
			}
%>