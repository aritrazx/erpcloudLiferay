
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.famocom.erpcloud.salaryregister.dao.SalaryRegisterDAO"%>
<%@page import="com.liferay.famocom.erpcloud.salaryregister.dto.SalaryRegisterDTO"%>
<%@page import="com.liferay.famocom.erpcloud.salaryregister.constants.SalaryRegisterPortletKeys"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.SalDetails"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>





<%		
		//long companyId = themeDisplay.get;
if(themeDisplay.isSignedIn()){
	boolean isViewPermission = false;
	try {
		isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(),
				"SalaryRegister", "SALARY_REGISTER_VIEW");
		System.out.print("isViewPermission " + isViewPermission);
	} catch (Exception exception) {
		exception.printStackTrace();
	}
	if (isViewPermission) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		List<Integer> yearList = new ArrayList<Integer>();
		for(int i=5;i>0;i--){
			yearList.add(currentYear-i);
		}
		for(int j=0;j<=5;j++){
			yearList.add(currentYear+j);
		}
    DecimalFormat  df2 = new DecimalFormat("0.00");
	String month = ParamUtil.getString(renderRequest ,"month",StringPool.BLANK); 
	String year = ParamUtil.getString(renderRequest,"year",StringPool.BLANK);
	System.out.println("month.... "+month);
	System.out.println("yearStr.... "+year);
	if(Validator.isNull(month)){
		month = String.valueOf(currentMonth);
	}if(Validator.isNull(year)){
		year= String.valueOf(currentYear);
	}
	List<String> earningList = new ArrayList<String>();
	earningList.add(SalaryRegisterPortletKeys.Earning);
	earningList.add(SalaryRegisterPortletKeys.Overtime);
	earningList.add(SalaryRegisterPortletKeys.Reimbursement);
	earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
	String monthYear = month + year;
	boolean isSalaryProcessed = false;
	System.out.println("..........^^^^^^  "+themeDisplay.getCompanyLogo());
	/* List<SalDetails> detailsList = new ArrayList<>();
	detailsList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYear(Long.valueOf(monthYear)); */
	List<SalaryRegisterDTO> dtos = SalaryRegisterDAO.getSalaryRegister(month,year);
	PortletURL  viewSalaryRegister = renderResponse.createRenderURL();
	viewSalaryRegister.setParameter("jspPage", "/paySlip.jsp");
	PortletURL  viewTdsUrl = renderResponse.createRenderURL();
	viewTdsUrl.setParameter("jspPage", "/tdsView.jsp");
	

PortletURL viewSalaryRegisterURL = renderResponse.createRenderURL();
viewSalaryRegisterURL.setParameter("jspPage", "/view.jsp");
PortletURL iterateUrl = renderResponse.createRenderURL();
iterateUrl.setParameter("month", month);
iterateUrl.setParameter("year", year);
iterateUrl.setParameter("jspPage", "/view.jsp");
ResourceURL exportToExcelURL  = renderResponse.createResourceURL();
exportToExcelURL.setParameter(Constants.CMD, "exportToExcel");
exportToExcelURL.setParameter("month", month);
exportToExcelURL.setParameter("yearStr", year);
//list of bank in pop-up
/* PortletURL popUpUrl = renderResponse.createRenderURL();
popUpUrl.setParameter("jspPage", "/bankList.jsp");
popUpUrl.setWindowState(LiferayWindowState.POP_UP);
popUpUrl.setParameter("month", month);
popUpUrl.setParameter("year", year);
String popupview = "javascript:popupview('"+ popUpUrl.toString()+"');"; */

ResourceURL exportTobankExcelURL  = renderResponse.createResourceURL();
exportTobankExcelURL.setParameter(Constants.CMD, "exportToBankExcel");
exportTobankExcelURL.setParameter("month", month);
exportTobankExcelURL.setParameter("yearStr", year);
%>


<aui:form  action="<%=viewSalaryRegisterURL.toString() %>" >
<aui:row>
     <aui:col span="6">
<aui:select name="month" label="Month" id="month" >
		<aui:option value="">select</aui:option>
		<aui:option value="1"  selected="<%=1==currentMonth %>" >Jan</aui:option>
		<aui:option value="2" selected="<%=2==currentMonth %>" >Feb</aui:option>
		<aui:option value="3" selected="<%=3==currentMonth %>" >March</aui:option>
		<aui:option value="4" selected="<%=4==currentMonth %>" >April</aui:option>
		<aui:option value="5" selected="<%=5==currentMonth %>" >May</aui:option>
		<aui:option value="6" selected="<%=6==currentMonth %>" >June</aui:option>
		<aui:option value="7" selected="<%=7==currentMonth %>" >July</aui:option>
		<aui:option value="8" selected="<%=8==currentMonth %>" >August</aui:option>
		<aui:option value="9" selected="<%=9==currentMonth %>" >Sept</aui:option>
		<aui:option value="10" selected="<%=10==currentMonth %>" >Oct</aui:option>
		<aui:option value="11" selected="<%=11==currentMonth %>" >Nov</aui:option>
		<aui:option value="12" selected="<%=12==currentMonth %>" >Dec</aui:option>
	</aui:select>
	
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
	<aui:button name="Submit" type="Submit" value="Submit" ></aui:button>
	
	</aui:col>
	<aui:col span="6">
 </aui:col>
	</aui:row>
</aui:form>
<%if(dtos.size()>0) {%>
<div class="row">
<div class="col-md-8" >
</div>
<div class="col-md-2" >
<a class="icon-download" href="<%=exportTobankExcelURL.toString() %>" style="float:right" >Export for Bank</a>
</div>
<div class="col-md-2" >
 <a class="icon-download" href="<%=exportToExcelURL.toString() %>" style="float: right" >Export to Excel </a>
</div>
</div>
<%} %>

<liferay-ui:search-container delta="3"	emptyResultsMessage="There is no existing  data" iteratorURL="<%=iterateUrl %>" >

 <liferay-ui:search-container-results>

<%
		results =dtos;	
		total = dtos.size();
		searchContainer.setTotal(total);
		pageContext.setAttribute("results",results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
		pageContext.setAttribute("total", results.size());
		pageContext.setAttribute("delta", results.size());
		
			%>


</liferay-ui:search-container-results> 

<liferay-ui:search-container-row  	className="com.liferay.famocom.erpcloud.salaryregister.dto.SalaryRegisterDTO" modelVar="salRegister">
<liferay-ui:search-container-column-text name="Employee Code"   > <%=salRegister.getEmployeeCode()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Employee Name"   > <%=salRegister.getEmployeeName()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Month"   > <%=salRegister.getMonthYear()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Account No."   > <%=salRegister.getAccountNumber()%></liferay-ui:search-container-column-text>

	<%
	viewSalaryRegister.setParameter("employeeId", String.valueOf(salRegister.getEmployeeId()));
	viewSalaryRegister.setParameter("monthYear", monthYear);
	viewSalaryRegister.setParameter("month", month);
	viewSalaryRegister.setParameter("year", year);
	viewTdsUrl.setParameter("employeeId", String.valueOf(salRegister.getEmployeeId()));
	viewTdsUrl.setParameter("monthYear", monthYear);
	viewTdsUrl.setParameter("month", month);
	viewTdsUrl.setParameter("year", year);
	double totalEarning = 0.00;
	double totalDedction = 0.00;
	double netPay = 0.00;
	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PayComponent.class);
	dynamicQuery.addOrder(OrderFactoryUtil.asc("payComponentOrder"));
	List<PayComponent> componentList = PayComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(componentList.size()>0){
		for(PayComponent component:componentList){
	 		if (earningList.contains(component.getPayType())) {
			  	boolean isComponent = false;
			  	HashMap<Long,String> hashmap = SalaryRegisterDAO.getEmployeeEarningComponentbyMonthYearAndEmployeeId(monthYear, salRegister.getEmployeeId());
			  	if(hashmap.size()>0){
			  		isSalaryProcessed = true;
			 		for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
				    	if(component.getComponentId()==entry.getKey()){
					 		isComponent = true;
					  		PayComponent componentt;
							try {
								componentt = PayComponentLocalServiceUtil.getPayComponent(entry.getKey());					 
								totalEarning += Double.valueOf(entry.getValue());
								String amount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
					
	%>
	<liferay-ui:search-container-column-text name="<%=componentt.getName() %>"   > <%=amount%></liferay-ui:search-container-column-text>
	<%		
							} catch (PortalException e) {
								e.printStackTrace();
							}				
				 	 	}
			 	  	}
		 	 	}	 
		 
		  		if(isComponent==false){
		  		%>
					<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%="0.00"%></liferay-ui:search-container-column-text>		  
		  		<%		  
	 			}
		 	}
	 	}
		String totalEarningStr = df2.format(totalEarning);
%>

	<liferay-ui:search-container-column-text name="Gross Earning"   > <%=totalEarningStr%></liferay-ui:search-container-column-text>
<%	 
	 
	 for(PayComponent component:componentList){
		 if(component.getPayType().equalsIgnoreCase(SalaryRegisterPortletKeys.Deduction)) {
		 	boolean isComponent = false;
		  	HashMap<Long,String> hashmap = SalaryRegisterDAO.getEmployeeDeductionComponent(monthYear, salRegister.getEmployeeId());
		  	if(hashmap.size()>0){
		  		isSalaryProcessed = true;
			  	for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
					if(component.getComponentId()==entry.getKey()){
					  	isComponent = true;
					  	PayComponent componentt;
						try {
							componentt = PayComponentLocalServiceUtil.getPayComponent(entry.getKey());
							String amount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
							totalDedction += Double.valueOf(entry.getValue());
						
		%>
		<liferay-ui:search-container-column-text name="<%=componentt.getName() %>"   > <%=amount%></liferay-ui:search-container-column-text>
		<%		
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
			  		}
		  		}
		  	}
			if(isComponent==false){ 
				  %>
					<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%="0.00"%></liferay-ui:search-container-column-text>	
			 	 <%
		    }
		}
	}
 }
	
	TaxDeclarationMonthly declarationMonthly = null;
	double monthlyTax = 0.0 ;
	try{
		declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(salRegister.getEmployeeId(), Long.valueOf(monthYear));
		if(Validator.isNotNull(declarationMonthly)){
			String taxStr = df2.format(declarationMonthly.getTdsDuePerMonth());
			monthlyTax = Double.valueOf(taxStr);
		}
	}catch(Exception e){
		
	}
	String totalDedctionStr = df2.format(totalDedction);
	String netPayStr = df2.format(totalEarning-totalDedction-monthlyTax);
    %>

	<liferay-ui:search-container-column-text name="Gross Deduction"   > <%=totalDedctionStr%></liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text name="Tax"   > <%=df2.format(monthlyTax)%></liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text name="Net Pay"   > <%=netPayStr%></liferay-ui:search-container-column-text>
	<% if(isSalaryProcessed==true){ %>
	<liferay-ui:search-container-column-text name="View"   ><a  href="<%=viewSalaryRegister.toString() %>" >Payslip</a></liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text name="View"   ><a  href="<%=viewTdsUrl.toString() %>" >TDS</a></liferay-ui:search-container-column-text>
	<%} %>
</liferay-ui:search-container-row>
			<liferay-ui:search-iterator/>

</liferay-ui:search-container>
<%}else{ %>
	<div class="control-group no-margin">
	  <label class="control-label">You don't have permission to view the Salary Register</label>
	  </div>
<%}}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>
<script>

function popupview(url) {
	Liferay.Util.openWindow(

	{

		dialog : {

			//cssClass: 'aui-popup-example',

			destroyOnHide : true,

			height : 500,

			width : 900

		},

		dialogIframe : {

		//bodyCssClass: 'custom-css-class'

		},

		title : 'View Bank Name List',

		uri : url

	}

	);

}
</script>