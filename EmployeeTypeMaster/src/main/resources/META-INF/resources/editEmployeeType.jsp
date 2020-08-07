

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletURL cancelURL = renderResponse.createRenderURL();
cancelURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<liferay-ui:success key="add-success"
message="Employee Type added successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
message="Employee Type updated successfully"></liferay-ui:success>
<liferay-ui:error key="error" message="Employee Type already exist"></liferay-ui:error>
<%
	boolean editURL = false;
	long employeetypeId = ParamUtil.getLong(request, "employeetypeId");
	System.out.println("employeetypeId"+employeetypeId);
	EmployeeType emp=null;
	if(employeetypeId!=0){
		editURL=true;
	 emp =EmployeeTypeLocalServiceUtil.getEmployeeType(employeetypeId);
	}
	String typeName = ParamUtil.get(renderRequest, "typeName" , StringPool.BLANK);
	String pfDeduct = ParamUtil.get(renderRequest, "pfDeduct",StringPool.BLANK);
	String status = ParamUtil.get(renderRequest, "status",StringPool.BLANK);
	String company_id = ParamUtil.get(renderRequest, "company_id",StringPool.BLANK);
	String date = ParamUtil.get(renderRequest,"final_approval_role_id", StringPool.BLANK);
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage","/view.jsp"); 
%>

<%-- <liferay-ui:header title="" backLabel="Back" backURL="<%=backURL.toString()%>" /> --%>

<portlet:actionURL name="updateEmployeeType" var="updateEmployeeTypeURL" />
<portlet:actionURL name="addEmployeeType" var="addEmployeeTypeURL" />
<aui:form name="updateEmployeeType" action="<%=employeetypeId!=0?updateEmployeeTypeURL.toString():addEmployeeTypeURL.toString()%>" method="post" >
<aui:row>
		<aui:col span="12">
		<%if(employeetypeId!=0)
		{
		%>
		<liferay-ui:header title="Edit Employee Type" backLabel="Back" backURL="<%=backURL.toString()%>"></liferay-ui:header>
		<%-- <p>
		<h3>Edit Employee Type(<%=emp.getTypeName()%>)</h3></b>
		</p> --%>
		<%}else{ %>
		<liferay-ui:header title="Add Employee Type" backLabel="Back" backURL="<%=backURL.toString()%>" />
		<!-- <p>
		<h3>Add Employee Type</h3></b>
		</p> -->
		<%} %>
	</aui:col>

</aui:row>
<aui:row>
	<aui:input name="employeetypeId" type="hidden" value="<%=employeetypeId %>" />
	<aui:col span="4">
		<aui:input name="typeName" type="text" value="<%=employeetypeId!=0?emp.getTypeName():""%>" label="Type Name">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom"            
                      errorMessage="Only Alphabets are allowed">
                        function (val, fieldNode, ruleValue)
                           {
                               var result = true;
                               var pattern=/[^a-z|^A-Z|^\s]/;
                              var check = val.match(pattern);
                              if(check!=null)
                             {
                                result=false;
                              }
                              val=$.trim(val);
                             $("#<portlet:namespace />typeName").val(val);
                          return result;
                            }
                </aui:validator>
		</aui:input>
	</aui:col>
	<aui:col span="5">
		<aui:input name="description" type="textarea" value="<%=employeetypeId!=0?emp.getDescription():"" %>"></aui:input>
	</aui:col>
	<aui:col span="3">
		<%
			int isStatus = 1;
			if(Validator.isNotNull(emp)){
				if(emp.getStatus()==2){
					isStatus=2;
				}
			}
		%>
		<aui:input type="radio" name="status" label="Active"
			checked="<%=isStatus==1 %>" value="1"></aui:input>
		<aui:input type="radio" name="status"
				checked="<%=isStatus==2 %>" label="Inactive" value="2"></aui:input>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="2">
		<%-- <% 
		if(employeetypeId==0){
		%> --%>
			<aui:button name="save" type="submit" value="Update" ></aui:button>
		<%-- <%
		}
		else{	
		%>
		<aui:button name="save" type="submit" value="Save" ></aui:button>
		<%
		}
		%> --%>
		
	</aui:col>
</aui:row>
</aui:form>
