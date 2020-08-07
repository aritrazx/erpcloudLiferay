


<%@page import="com.liferay.famocom.erpcloud.service.BankMasterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.model.BankMaster"%>
<%@page import="com.liferay.famocom.erpcloud.mypayroll.dao.PayrollDAO"%>
<%@page import="com.liferay.famocom.erpcloud.mypayroll.constants.MyPayrollPortletKeys"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@ include file="init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
<%
//String empIdStr = ParamUtil.getString(renderRequest, "employeeId");
if(themeDisplay.isSignedIn()){
	long userId = themeDisplay.getUserId();
	Employee employee = null;
	try{
		employee =  EmployeeLocalServiceUtil.findByemployees(userId);
	}catch(Exception e){
		System.out.println("employee not exist with this User ");
	}
		
String monthYear = ParamUtil.getString(renderRequest, "monthYear");
String month = ParamUtil.getString(renderRequest, "month");
DecimalFormat df2 = new DecimalFormat("0.00");
String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
String year = ParamUtil.getString(renderRequest, "year");
double totalTdsMonthly = 0.0;
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

List<String> earningList = new ArrayList<String>();
earningList.add(MyPayrollPortletKeys.Earning);
earningList.add(MyPayrollPortletKeys.Overtime);
earningList.add(MyPayrollPortletKeys.Reimbursement);
earningList.add(MyPayrollPortletKeys.StatutoryComponent);

PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/view.jsp");
ResourceURL printPdf = renderResponse.createResourceURL();
printPdf.setParameter(Constants.CMD, "generatePdfPaySlip");
printPdf.setParameter("monthYear", monthYear);
printPdf.setParameter("month", month);
printPdf.setParameter("year", year);

 if(Validator.isNotNull(employee)){
	 printPdf.setParameter("employeeId", String.valueOf(employee.getEmployeeId()));
%>

<body>
<center>
<div class="container fade-in" id="viewSalary">
<div class="main">
<div class="col-md-12 col-sm-12 col-xs-12 pull-center ">
    <h3 id="header">Salary Details <a href="<%=backURL.toString() %>" class="btn btn-danger btn-circle pull-right  mcmin8">Back</a></h3>
    <div class="modal-body newmd">
        
        <div class="table-responsive">
          <table class="table no-margin table-hover" cellspacing="5" width="100%" align="center">
                   
                    <tbody><tr width="100%">
                      <td colspan="2" cellpadding="5">
                      <table width="100%" align="center" cellspacing="5">
                        <tbody><tr>
                          <td>Employee Code: </td>                         
                          <td> <%=employee.getEmployeeCode() %></td>
                          <td>Date of Joining:</td>
                          <td> <%= dateFormat.format(employee.getDateOfJoing()) %></td>
                        </tr>
                        <tr>
                          <td>Employee Name:</td>
                          <td> <%=employee.getFirstName()+" "+employee.getLastName() %></td>
                          <td>PAN:</td>
                           <td> <%=employee.getPanNo() %></td>
                        </tr>
                        <tr>
                          <td>Designation:</td>
                          <td> <%=employee.getDesignation() %></td>
                          <td>PF Number:</td>
                          <td> <%=employee.getPfNo() %></td>
                        </tr>
                      </tbody></table>
                    </td>
                  </tr>

                       <tr width="100%">

                          <td colspan="2" align="center" bgcolor="#AAAAAA">PAYSLIP FOR THE MONTH OF <%=months[ Integer.valueOf(month)-1] %> <%=year %></td>
                       </tr>

                        <tr width="100%">

                          <td style=" width:50%;font-weight:bold;">Earnings &amp; Reimbursement </td>
                          <td style=" width:50%; font-weight:bold;">Deductions &amp; Recoveries</td>
                       </tr>

                       <tr width="100%">

                          <td colspan="2" width="100%" cellpadding="0">
                          <table width="100%" cellspacing="5" class="table no-margin table-hover">
                          <tbody><tr style="width:100%;">

                          <td style=" width:50%;"> 
                          <table width="100%" style="vertical-align:top;" border="0">
                          <tbody>
                          
                          
      <%
	double totalEarning = 0;
	double totalDedction = 0;
	double netPay = 0;
	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PayComponent.class);
	dynamicQuery.addOrder(OrderFactoryUtil.asc("payComponentOrder"));
	List<PayComponent> componentList = PayComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
	//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
	if(componentList.size()>0){
	 for(PayComponent component:componentList){
	 if (earningList.contains(component.getPayType())) {
	  HashMap<Long,String> hashmap = PayrollDAO.getEmployeeEarningComponent(monthYear, employee.getEmployeeId());
	  if(hashmap.size()>0){
		  boolean isComponent = false;
	  for(Map.Entry<Long,String> entry:hashmap.entrySet()){
		  if(component.getComponentId()==entry.getKey()){
			  isComponent = true;
			  PayComponent componentt;
				try {
					componentt = PayComponentLocalServiceUtil.getPayComponent(entry.getKey());					 
					totalEarning += Double.valueOf(entry.getValue());
					String totalEarningStr = df2.format(Double.valueOf(entry.getValue()));
					
	%>
      
 						<tr>
		                    <td><%=component.getName() %></td>
                          <td align="right"><%=totalEarningStr %></td>
                          </tr>                    
        
        <%		
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		  }
	  }
	 
		  if(isComponent==false){  %>
		  
		 <%--  <tr>
                          <td><%=component.getName() %></td>
                          <td align="right">0.00</td>
                          </tr> --%>
		  <%
		  
		  
		  }	
	  }
	 }
	 }
	
%>
		  					                          
                          </tbody></table>

                          </td>
                          <td style="width:50%;vertical-align:top;">
                            <table width="100%" cellspacing="5" border="0">
                          <tbody>
                   <%	 
	 
	 for(PayComponent component:componentList){
		 if(component.getPayType().equalsIgnoreCase(MyPayrollPortletKeys.Deduction)) {
		  HashMap<Long,String> hashmap = PayrollDAO.getEmployeeDeductionComponent(monthYear, employee.getEmployeeId());
		  if(hashmap.size()>0){
			  boolean isComponent = false;
		  for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
			  if(component.getComponentId()==entry.getKey()){
				  isComponent = true;
				  PayComponent componentt;
					try {
						componentt = PayComponentLocalServiceUtil.getPayComponent(entry.getKey());
						
					
						 totalDedction += Double.valueOf(entry.getValue());
						 String totalDedctionStr = df2.format(Double.valueOf(entry.getValue()));
						
		%>
		<tr>
                          <td><%=component.getName() %></td>
                          <td align="right"><%=totalDedctionStr%></td>
                          </tr>
		
		<%		
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
			  }
		  }
			  if(isComponent==false){  %>
			  
			<%--   <tr>
                          <td><%=component.getName() %></td>
                          <td align="right">0.00</td>
                          </tr> --%>
			    <%
			  
			  
			  }	
		  }
		 }
		 }
            TaxDeclarationMonthly declarationMonthly  = null;
            try{
            	declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(employee.getEmployeeId(), Long.valueOf(monthYear));
              }catch(Exception e){
            	  e.printStackTrace();
              }
	  if(Validator.isNotNull(declarationMonthly)){
		
			  totalTdsMonthly = declarationMonthly.getTdsDuePerMonth();
    %>      
                     <tr>
                          <td><%="Income Tax"%></td>
                          
                          <td align="right"><%=df2.format(totalTdsMonthly) %></td>
                          </tr>     
                          
 <%} %>                         
                    <%} %>      
                          </td>
                        </tr>

                          </tbody></table>

                          </td>
                       </tr>

                       <tr width="100%">

                          <td colspan="2" cellpadding="0">
                          <table width="100%" cellspacing="2" class="table no-margin table-hover">
                          <tbody><tr style="width:100%;">
<%
String totalEarningStr = df2.format(totalEarning);
String totalDedctionStr = df2.format(totalDedction+totalTdsMonthly);
String netPayStr = df2.format(totalEarning-totalDedction-totalTdsMonthly);
%>
                          <td bgcolor="#AAAAAA" style=" width:30%;font-weight:bold; ">Total Earnings</td>
                          <td bgcolor="#AAAAAA" style=" width:20%;font-weight:bold;" align="right"><%=totalEarningStr%></td>
                          <td bgcolor="#AAAAAA" style=" width:30%;font-weight:bold; ">Total deduction</td>
                          <td bgcolor="#AAAAAA" style=" width:20%;font-weight:bold;" align="right"><%=totalDedctionStr%></td>
                        </tr>
                          </tbody></table>
                          </td>
                       </tr>

                       <tr width="100%">
                      <td cellpadding="0">
                      <table width="100%" align="center" cellspacing="5">
                        <tbody><tr>
                          <td style="font-weight:bold;">Net Pay: </td>
                          <td style="font-weight:bold;"><%=(netPayStr)%></td>
                          
                        </tr>
                        <tr>
                           <td>Bank: </td>
                          <%
                          String bankName = StringPool.BLANK;
                          BankMaster bankMaster = null;
			try {
				bankMaster = BankMasterLocalServiceUtil.getBankMaster(employee.getBankId());
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(Validator.isNotNull(bankMaster)){
				bankName = bankMaster.getBankName();
			}
			 %>
                         <td><%=bankName %></td>
                        </tr>
                        <tr>
                          <td>Account number: </td>
                         <td><%=employee.getAccountNo() %></td>
                          
                        </tr>

                        <tr>
                          <td colspan="2" style="font-style: italic;"></td>
                        </tr>
                        

                      </tbody></table>
                      </td><td></td>
                    
                  </tr>

                                   
         </tbody></table>
        </div>
      <div  class="driver-list-detail-button clearfix">
       <!--  <a href="javascript:void(0);"id="downloadPdf" title="Payslip" ><i class="fa fa-print"></i> Print</a> -->
        <a  href="<%=printPdf.toString() %>" >Payslip</a>
      </div>
    </div>
  </div>
  <%}%>
 </td>
 </tr>
 </tbody>
 </table>
 </div>
 </div>
 </div>
 </div>
 </div>
 </center>
 
  
  <script>
$(document).ready(function() {
    $('#downloadPdf').on('click', function() {
       $('#downloadPdf').hide();
       $('#header').hide();
        $('input').css('border-bottom','1px dotted #000');
        var pdf = new jsPDF('p', 'pt', 'a4');
        console.log(pdf.getFontList());
        pdf.addHTML($('#viewSalary')[0], function() {
            pdf.save($('#downloadPdf').attr('title')+'.pdf');
            $('#downloadPdf').show();
            $('#header').show();
            $('input').css('border-bottom','1px dotted #000');
        });
    });
   
});

</script>

<style>

body {
    margin: 0px;
    padding: 0px;
    font-family: Arial, Helvetica, sans-serif;
    margin-bottom: 30px;
    color:#000000;
/*     font-size: 0px; !important */
}
.main {
    width: 1000px;
    margin: 0px auto;
    padding: 20px;
    background: #fff;
}
#viewSalary {
    width: 100%;
    background-color: #fff;
    /* width: 800px; */
    margin: 0 auto;

    text-align: left;
}
</style>
</body> 
 <%}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>  