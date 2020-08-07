<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.IncomeTaxSlab"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>

<%
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		 PortletURL addTaxSlabURL = renderResponse.createActionURL();
		addTaxSlabURL.setParameter("javax.portlet.action", "addTaxSlab");
		List<String> yearList = new ArrayList<String>();
		String incomeFrom = StringPool.BLANK;
		String incomeTo = StringPool.BLANK;
		String taxRate  = StringPool.BLANK;
		String financialYear = StringPool.BLANK;
		long incomeTaxSlabId = ParamUtil.getLong(request, "incomeTaxSlabId");
		IncomeTaxSlab incomeTaxSlab = null;
		if(incomeTaxSlabId!=0){
			try{
				incomeTaxSlab = IncomeTaxSlabLocalServiceUtil.getIncomeTaxSlab(incomeTaxSlabId);
				if(Validator.isNotNull(incomeTaxSlab)){
					 incomeFrom = String.valueOf(incomeTaxSlab.getIncomeFrom());
					 incomeTo = String.valueOf(incomeTaxSlab.getIncomeTo());
					 taxRate  = String.valueOf(incomeTaxSlab.getTaxRate());
					 financialYear = incomeTaxSlab.getFinancialYear();
					 
				}
			}catch(Exception e){
				
			}
		}
		
		for(int i=4;i>-1;i--){
			String yearOne = String.valueOf(currentYear-i-1);
			String yearTwo = String.valueOf(currentYear-i);
			yearList.add(yearOne+"-"+yearTwo);
		}
		for(int j=0;j<=5;j++){
			String yearOne = String.valueOf(currentYear+j);
			String yearTwo = String.valueOf(currentYear+j+1);
			yearList.add(yearOne+"-"+yearTwo);
		}
		    PortletURL backURL = renderResponse.createRenderURL();
		    backURL.setParameter("jspPage","/taxSlabList.jsp"); 
%>
 <liferay-ui:header title="Back" backLabel="Back" backURL="<%=backURL.toString()%>" />
<aui:form action="<%=addTaxSlabURL.toString() %>" name="addTaxSlab" >
<aui:row>
     <aui:col span="6">
<aui:input name="incomeFrom" type="text" value="<%=incomeFrom %>"  label="Income From" >
<aui:validator name="required" errorMessage="Please enter a From Amount!" ></aui:validator>
<aui:validator name="number"></aui:validator>
 </aui:input>
 <aui:input name="taxRate" type="text" value="<%=taxRate %>" label="Tax Rate" >
<aui:validator name="required" errorMessage="Please enter a Tax Rate!" ></aui:validator>
 <aui:validator name="number"  ></aui:validator>
</aui:input>

	<%if(incomeTaxSlabId!=0){ %>
<aui:button type="submit" name="submit" value="Update" > </aui:button>
<%}else{ %>
<aui:button type="submit" name="submit" value="Add" > </aui:button>
<%} %>
 </aui:col>
 <aui:col span="6">
 
 <aui:input name="incomeTaxSlabId" type="hidden" value="<%=incomeTaxSlabId %>"   ></aui:input>
 <aui:input name="incomeTo" type="text" value="<%=incomeTo %>"  label="Income To" >
 <aui:validator name="required" errorMessage="Please enter a To Amount!" ></aui:validator>
 <aui:validator name="number"  ></aui:validator>
  </aui:input>
  <label>Financial Year<span class="mandatory" >* </span></label>
  <aui:select name="financialYear"  label="" >
		<aui:option value="">select</aui:option>
		<%  	 Iterator it= yearList.iterator();
				 while(it.hasNext()){
				 Object yr = it.next();
		%>
		<aui:option value="<%=yr.toString() %>"  selected="<%=financialYear.equalsIgnoreCase(yr.toString()) %>" ><%=yr.toString() %></aui:option>
		<%	 
		 } 
		 %>
	</aui:select>
 
 </aui:col>
 </aui:row>
  



</aui:form>

<script>
AUI().ready('alloy-node', 'aui-form-validator', function(A) {
	   var formValidator = new A.FormValidator({
	       boundingBox: document.<portlet:namespace />addTaxSlab,
	       rules: {
	           <portlet:namespace />financialYear: {
	               required: true
	           }
	       },
	       fieldStrings: {
	           <portlet:namespace />financialYear: {
	               required: 'Please select Financial Year!'
	           }
	       },
	       on: {
	           validateField: function(event) {},
	           validField: function(event) {},
	           errorField: function(event) {},
	           submitError: function(event) {
	               var errors = event.validator.errors;
	               event.preventDefault();
	           },
	           submit: function(event) {
	               return false;
	           }
	       }
	   });
	}); 



</script>
<style>
.mandatory{
	color: red;
	font-size: 22px;
}
</style>