
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.StopPay"%>
<%@ include file="init.jsp" %>




<%@ taglib uri="http://liferay.com/tld/frontend"
prefix="liferay-frontend"%>
<%
	if(themeDisplay.isSignedIn()){
		boolean isViewPermission = false;
		try {
			isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
					"Payroll", "STOP_PAY_VIEW");
			System.out.print("isViewPermission " + isViewPermission);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		if (isViewPermission) {
	List<StopPay>  stopPaysList = new ArrayList<StopPay>();
	stopPaysList = StopPayLocalServiceUtil.getStopPaies(-1, -1);
	PortletURL iterateUrl = renderResponse.createRenderURL();
	iterateUrl.setParameter("jspPage", "/StopPayList.jsp");
	PortletURL addStopPayURL = renderResponse.createRenderURL();
	addStopPayURL.setParameter("jspPage", "/addStopPay.jsp");
	String employeeName = StringPool.BLANK;
	String month=StringPool.BLANK;
	String year = StringPool.BLANK;
	String monthString = StringPool.BLANK;
	String status = StringPool.BLANK;
	PortletURL changeStopPayStatusUrl = renderResponse.createActionURL();
	changeStopPayStatusUrl.setParameter("javax.portlet.action", "changeStopPayStatus");
%>


<liferay-ui:search-container delta="10" emptyResultsMessage="There is no Stop Pay" iteratorURL="<%=iterateUrl %>" >

<liferay-ui:search-container-results>
    <%
      results = stopPaysList;
      total = results.size();
      searchContainer.setTotal(total);
      pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
      pageContext.setAttribute("total",results.size());
      pageContext.setAttribute("delta", results.size());
    
    %>
</liferay-ui:search-container-results>
<liferay-ui:search-container-row className="com.liferay.famocom.erpcloud.model.StopPay" modelVar="pay">

<%   Employee employee = null;
   try{
	    employee = EmployeeLocalServiceUtil.getEmployee(pay.getEmployeeId());
   }catch(Exception e){
	   System.out.print("employee not found!!");
   }
	
	if(Validator.isNotNull(employee)){
		employeeName = employee.getFirstName()+ " "+ employee.getLastName();
	}
	String monthYear = String.valueOf(pay.getMonthYear()); 	
	if(monthYear.length()==6){
	    month = monthYear.substring(0,2);
	}else{
	    month = monthYear.substring(0,1);
	}
	year = monthYear.substring(monthYear.length()-4);
	System.out.println("Year... "+month);
	monthString = new DateFormatSymbols().getMonths()[Integer.valueOf(month)-1];
	System.out.println("Year... "+monthString);
	long statusId = pay.getStatus();
	if(statusId==0){
		status = "Stop";
	}else if(statusId==1)
	{
		status = "Regular";
	}
%>
	
<liferay-ui:search-container-column-text name="Employee Name" > <%= employeeName %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="month" > <%=monthString%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Year" > <%=year%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Reason" > <%=pay.getReason()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Status" > <%=status%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name=""   cssClass="actionCol" > 
<liferay-ui:icon-menu markupView="lexicon">
<%  changeStopPayStatusUrl.setParameter("stopPayId", String.valueOf(pay.getStopPayId()));
if(statusId==0){
%>

<liferay-ui:icon url="<%=changeStopPayStatusUrl.toString()%>" 
					message="Change To Regular" image="view" />
					<%} %>
</liferay-ui:icon-menu>

</liferay-ui:search-container-column-text>
</liferay-ui:search-container-row>
<liferay-ui:search-iterator/>
</liferay-ui:search-container>


<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='<%=LanguageUtil.get(request, "Add Stop Pay")%>'
url="<%=addStopPayURL.toString()%>" />
</liferay-frontend:add-menu>
<%}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"  > <font color="red" > You don't have permission to view the Pay Component </font></label>
	  </div>
<%}}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>
