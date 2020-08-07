








<%@page import="com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.MonthlyAdjustment"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmpPayStructure"%>
<%@page import="com.liferay.famocom.erpcloud.salaryprocess.Util.SalaryProcessUtil"%>
<%@page import="com.liferay.famocom.erpcloud.salaryprocess.dto.SalaryProcessDTO"%>
<%@page import="com.liferay.famocom.erpcloud.salaryprocess.constants.SalaryProcessPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly"%>
<%@page import="java.text.DecimalFormat"%>
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





<%	String month = ParamUtil.getString(renderRequest ,"month",StringPool.BLANK); 
	String year = ParamUtil.getString(renderRequest,"year",StringPool.BLANK);
	System.out.println("month.... "+month);
	System.out.println("yearStr.... "+year);
    DecimalFormat  df2 = new DecimalFormat("0.00");	
	List<String> earningList = new ArrayList<String>();
	earningList.add(SalaryProcessPortletKeys.Earning);
	earningList.add(SalaryProcessPortletKeys.Overtime);
	earningList.add(SalaryProcessPortletKeys.Reimbursement);
	earningList.add(SalaryProcessPortletKeys.StatutoryComponent);
	String monthYear = month + year;
	boolean isSalaryProcessed = false;
	System.out.println("monthYear.... "+monthYear);
	List<SalaryProcessDTO> dtos = SalaryProcessUtil.getSalaryRegister(month,year);
	PortletURL iterateUrl = renderResponse.createRenderURL();
	iterateUrl.setParameter("month", month);
	iterateUrl.setParameter("year", year);
	iterateUrl.setParameter("jspPage", "/monthlyAdjustmentPopUp.jsp");

%>


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

<liferay-ui:search-container-row  	className="com.liferay.famocom.erpcloud.salaryprocess.dto.SalaryProcessDTO" modelVar="salRegister">
<liferay-ui:search-container-column-text name="Employee Code"   > <%=salRegister.getEmployeeCode()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Employee Name"   > <%=salRegister.getEmployeeName()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Month"   > <%=salRegister.getMonthYear()%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Account No."   > <%=salRegister.getAccountNumber()%></liferay-ui:search-container-column-text>

	<%
	
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
			  	 EmpPayStructure  empPayStructure = null;
			  	 MonthlyAdjustment monthlyAdjustment  = null;
				 try{
					 empPayStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentIdAndEmployeeId(component.getComponentId(), salRegister.getEmployeeId());
				 }catch (Exception e) {
					// TODO: handle exception
				}	
				try{
					monthlyAdjustment = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByMonthYearAndEmployeeIdAndPayComponentId(Long.valueOf(monthYear), salRegister.getEmployeeId(), component.getComponentId());
				}catch (Exception e) {
			    		 System.out.println("There is no data in monthly adjustment...!");
				}
				if(Validator.isNotNull(empPayStructure)){
						boolean isMonthlyAdjustment = false;
							if(Validator.isNotNull(monthlyAdjustment)){
								totalEarning += monthlyAdjustment.getAmount();
								String monthlyAdjustmentAmount = StringPool.BLANK;
								if(monthlyAdjustment.getAmount()>0){
									monthlyAdjustmentAmount = "(+"+monthlyAdjustment.getAmount()+")";
								}else{
									monthlyAdjustmentAmount = "("+monthlyAdjustment.getAmount()+")";
								}
										%>
								<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%=empPayStructure.getComponentValue()%>   <font color="green"> <%=monthlyAdjustmentAmount%> </font> </liferay-ui:search-container-column-text>
										<%	
									}else{
								%>
								<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%=empPayStructure.getComponentValue()%></liferay-ui:search-container-column-text>		  
					  			<%			
						         
								}
							totalEarning += empPayStructure.getComponentValue(); 		
		 	  }else{
		 		  String amount = "0.00";
		 		 %>
					<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%=amount %> </liferay-ui:search-container-column-text>		  
		  			<%		  
		 	  }
	 	}
	}
		String totalEarningStr = df2.format(totalEarning);
%>

	<liferay-ui:search-container-column-text name="Gross Earning"   > <%=totalEarningStr%></liferay-ui:search-container-column-text>
<%	 
	 
	 for(PayComponent component:componentList){
		 if(component.getPayType().equalsIgnoreCase(SalaryProcessPortletKeys.Deduction)) {
			 EmpPayStructure  empPayStructure = null;
			 MonthlyAdjustment monthlyAdjustment  = null;
			 try{
				 empPayStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentIdAndEmployeeId(component.getComponentId(), salRegister.getEmployeeId());
			 }catch (Exception e) {
				// TODO: handle exception
			}	
			try{
				monthlyAdjustment = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByMonthYearAndEmployeeIdAndPayComponentId(Long.valueOf(monthYear), salRegister.getEmployeeId(), component.getComponentId());
			}catch (Exception e) {
		    		 System.out.println("There is no data in monthly adjustment...!"+monthlyAdjustment);
			}
			if(Validator.isNotNull(empPayStructure)){
					boolean isMonthlyAdjustment = false;
						if(Validator.isNotNull(monthlyAdjustment)){
							totalDedction += monthlyAdjustment.getAmount();
							String monthlyAdjustmentAmount = StringPool.BLANK;
							if(monthlyAdjustment.getAmount()>0){
								monthlyAdjustmentAmount = "(+"+monthlyAdjustment.getAmount()+")";
							}else{
								monthlyAdjustmentAmount = "("+monthlyAdjustment.getAmount()+")";
							}
									%>
									<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%=empPayStructure.getComponentValue()%> <font color="green"> <%=monthlyAdjustmentAmount%> </font> </liferay-ui:search-container-column-text>
									<%	
								}else{
							%>
							<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%=empPayStructure.getComponentValue()%></liferay-ui:search-container-column-text>		  
				  			<%			
					}
						totalDedction += empPayStructure.getComponentValue();
	 	  }	else{
		 		  String amount = "0.00";
		 		 %>
					<liferay-ui:search-container-column-text name="<%=component.getName() %>"   > <%=amount %> </liferay-ui:search-container-column-text>		  
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
	
</liferay-ui:search-container-row>
			<liferay-ui:search-iterator/>

</liferay-ui:search-container>

