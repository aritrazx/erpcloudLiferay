
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.famocom.erpcloud.service.BankMasterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.BankMaster"%>
<%@ include file="init.jsp" %>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
<%
List<BankMaster> bankMasters = new ArrayList<BankMaster>();
bankMasters = BankMasterLocalServiceUtil.getBankMasters(-1, -1);
String month = ParamUtil.getString(request, "month");
String year = ParamUtil.getString(request, "year");
System.out.println("month.."+month);
System.out.println("year.."+year);
ResourceURL exportToExcelURL  = renderResponse.createResourceURL();
exportToExcelURL.setParameter(Constants.CMD, "exportToBankExcel");
exportToExcelURL.setParameter("month", month);
exportToExcelURL.setParameter("yearStr", year);
 %>
 
 <aui:form>
 <aui:select name="bankName" label="Bank Name" >
 <aui:option value="">Select</aui:option>
 <% if(bankMasters.size()>0){
	 for(BankMaster bankMaster:bankMasters){
	 %>
  <aui:option value="<%=bankMaster.getBankId() %>"><%=bankMaster.getBankName() %></aui:option> 
 <%} }%>
 </aui:select>
 <a href="<%=exportToExcelURL %>" style="float: right" ><input type="button" class="btn btn-primary"  onclick="generateBankXLS()" name="button" value="Excel for Bank" ></input></a>
 
 
 </aui:form>
 
 <style>
.portal-popup .columns-max > .portlet-layout.row > .portlet-column{
	padding: 25px;
}
 </style>
 <script>
 function generateBankXLS(){
	 alert();
	var geneateUrl = '<%=exportToExcelURL.toString()%>';
	var bankId = $('#<portlet:namespace/>bankName').find("option:selected").val();
	if(bankId!=""){
		
	}else{
		alert("Please select Bank Name first to generate excel!")
	}
 }
 
 
 
 </script>