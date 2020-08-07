<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.service.permission.PortletPermission"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.mypayroll.dao.PayrollDAO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.SalDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp" %>

<%
	if(themeDisplay.isSignedIn()){
	
			String year = ParamUtil.getString(request, "year");
			List<String[]> details = new ArrayList<String[]>();
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			if (Validator.isNotNull(year)) {
				currentYear = Integer.valueOf(year);
			}
			long employeeId = 0;
			System.out.println("currentYear  " + currentYear);
			List<Integer> yearList = new ArrayList<Integer>();
			for (int j = 0; j <= 5; j++) {
				int curYear = Calendar.getInstance().get(Calendar.YEAR);
				yearList.add(curYear - j);
			}

			long userId = themeDisplay.getUserId();
			Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
			if (Validator.isNotNull(employee)) {
				employeeId = employee.getEmployeeId();
				details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndYear(employeeId, currentYear);
			}

			String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST",
					"SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" };

			PortletURL iterateUrl = renderResponse.createRenderURL();
			iterateUrl.setParameter("jspPage", "/view.jsp");
			PortletURL viewSalarySlip = renderResponse.createRenderURL();
			viewSalarySlip.setParameter("jspPage", "/paySlip.jsp");
			PortletURL viewTdsUrl = renderResponse.createRenderURL();
			viewTdsUrl.setParameter("jspPage", "/tdsView.jsp");

			ResourceURL printPdf = renderResponse.createResourceURL();
			printPdf.setParameter(Constants.CMD, "generatePdfPaySlip");

			ResourceURL printTDSPdf = renderResponse.createResourceURL();
			printTDSPdf.setParameter(Constants.CMD, "exportPdfTDS");

			PortletURL salaryViewURL = renderResponse.createRenderURL();
			salaryViewURL.setParameter("jspPage", "/view.jsp");
%>

<aui:form action="<%=salaryViewURL.toString() %>" >

	<aui:select name="year"  label="Year" >
		<aui:option value="">select</aui:option>
		<%  	 Iterator it= yearList.iterator();
				 while(it.hasNext()){
				 Object yr = it.next();
		%>
		<aui:option value="<%=yr.toString() %>" selected="<%=currentYear==Integer.valueOf(yr.toString()) %>" ><%=yr.toString() %></aui:option>
		<%	 
		 } 
		 %>
	</aui:select>

<aui:button type="submit" name="submit" value="Show"  ></aui:button>


</aui:form>
<%if(details.size()>0){ %>
<table class="table table-bordered table-hover table-striped" style="margin-top: 10px;" >

<thead class="table-columns">
<tr>
<th class="table-first-header"> Month  </th>
<th > View   </th>
<th > Download Slip   </th>
 </tr>
 </thead>
 <% 
 
 for(String[] strArray:details){
	 Object[] arrayobject = (Object[])strArray;
		   String monthYear = String.valueOf(arrayobject[0]);
			String month = StringPool.BLANK;
			if(monthYear.length()/2==0){
				month = String.valueOf(monthYear.charAt(0)+monthYear.charAt(1));
			}else{
				month = String.valueOf(monthYear.charAt(0));
			}
			viewSalarySlip.setParameter("month", month);
			viewSalarySlip.setParameter("monthYear", monthYear);
			viewSalarySlip.setParameter("employeeId", String.valueOf(employeeId));
			
			viewTdsUrl.setParameter("month", month);
			viewTdsUrl.setParameter("monthYear", monthYear);
			viewTdsUrl.setParameter("employeeId", String.valueOf(employeeId));
			
			printPdf.setParameter("employeeId", String.valueOf(employeeId));
			printPdf.setParameter("monthYear", monthYear);
			printPdf.setParameter("month", month);
			printPdf.setParameter("year", String.valueOf(currentYear));
			printTDSPdf.setParameter("employeeId", String.valueOf(employeeId));
			printTDSPdf.setParameter("monthYear", monthYear);
			printTDSPdf.setParameter("month", month);
	 %>
 <tbody class="table-data">
 <tr>
<td class="table-cell first"><%=months[Integer.valueOf(month)-1] %>&nbsp;  <%=currentYear %>	</td>
<td class="table-cell"><a href="<%=viewSalarySlip.toString()%>"> <input type="button" class="btn btn-primary" name="button" value="PaySlip" ></input></a> &nbsp;&nbsp;<a href="<%=viewTdsUrl.toString()%>"> <input type="button" class="btn btn-primary" name="button" value="TDS" ></input></a></td>
<td class="table-cell last" >    <a  href="<%=printPdf.toString()  %>" > Payslip</a> &nbsp;&nbsp;  <a  href="<%=printTDSPdf.toString()  %>" >TDS</a></td>
</tr>
</tbody>
<% 
  }%>
</table>
<%}else{ %>
 <div class="control-group no-margin">
	  <label class="control-label">PaySlip not Available for this <%=currentYear %>    </label>
	  </div>
<%}}else{ %>

<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>
