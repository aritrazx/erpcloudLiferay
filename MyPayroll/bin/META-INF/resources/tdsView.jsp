
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly"%>
<%@ include file="init.jsp" %>


<%
	if(themeDisplay.isSignedIn()){
	long userId = themeDisplay.getUserId();
	Employee employee = null;
	try{
		employee =  EmployeeLocalServiceUtil.findByemployees(userId);
	}catch(Exception e){
		System.out.println("employee not exist with this User ");
	}
			 
	//String empIdStr = ParamUtil.getString(renderRequest, "employeeId");
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/view.jsp");
	DecimalFormat df2 = new DecimalFormat("0.00");
	String monthYear = ParamUtil.getString(renderRequest, "monthYear");
	TaxDeclarationMonthly declarationMonthly = null;
	SimpleDateFormat  dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	String month = ParamUtil.getString(renderRequest, "month");
	System.out.println("month...."+month);
	String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	String year = ParamUtil.getString(renderRequest, "year");
	ResourceURL printPdf = renderResponse.createResourceURL();
	printPdf.setParameter(Constants.CMD, "exportPdfTDS");	
	printPdf.setParameter("monthYear", monthYear);
	printPdf.setParameter("month", month);
	System.out.println("month......"+months[Integer.valueOf(month)]);
	//String per_month = StringPool.BLANK;
	 //to view TDS Per month (Apr 18 to Mar 19)
	 String per_month="TDS Per month("+months[Integer.valueOf(month)]+" 18 to "+months[Integer.valueOf(2)]+" 19)";
	long monthToNo = 3;
	long currentMonth = Long.valueOf(month);
	//per_month = months[month]' To '.$todate;
	if(monthToNo-currentMonth==0){
		per_month="-";
	}else if(monthToNo-currentMonth==1){
		per_month =months[Integer.valueOf(2)]+" 19";
	}
	if(Validator.isNotNull(employee)){
		printPdf.setParameter("employeeId", String.valueOf(employee.getEmployeeId()));
		if(Validator.isNotNull(monthYear)){
			try{
				employee = EmployeeLocalServiceUtil.getEmployee(employee.getEmployeeId());
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(employee.getEmployeeId(), Long.valueOf(monthYear));
			}catch(Exception exception){
				exception.printStackTrace();
			}
				
		}
		
	}

%>
            <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title></title>
            </head>
            <body  style="font-family: serif; font-size: 10pt;">
              <table  width="100%" align="center">
              <% String fromdate = months[Integer.valueOf(month)-1]; %>
              <tr><td colspan="2" align="center"><h4>Tax Computation as on <%=fromdate %> 18<!-- '.$fromdate.' --> For the Financial Year 2018-2019<!--  '.FINANCIALYEAR.'  --></h4></td></tr>
              <tr><td colspan="2" align="center"></td></tr>
              <tr>
              <td colspan="2">
              <table width="100%" align="center" style="border: 1px solid black;">
                <tr>
                <td width="30%" style="padding:5px;" >Employee ID :</td>
                <td align="left" style="font-weight:bold;"><%=employee.getEmployeeCode() %></td>
                </tr>
                <tr>
                <td width="30%" style="padding:5px;" >Employee Name :</td>
                <td align="left" style="font-weight:bold;"><%=employee.getFirstName() + " "+ employee.getLastName() %></td>
                </tr>
                <tr>
                <td width="30%" style="padding:5px;" >PAN No :</td>
                <td align="left" style="font-weight:bold;"><%=employee.getPanNo()==null? "":employee.getPanNo()%></td>
                </tr>
                <tr>
                <td width="30%" style="padding:5px;">Date of Joining :</td>
                <td align="left" style="font-weight:bold;">
                <% 
               	Date joiningDate = new Date();
                if(Validator.isNotNull(employee.getDateOfJoing())){
                %>
                  <%=dateFormat.format(employee.getDateOfJoing()) %>
                <%
                }
                %>
              </td>
                </tr>
                <tr>
                <td width="30%" style="padding:5px;" >Gender :</td>
                <td align="left" style="font-weight:bold;"><%=employee.getGender()==null?"0.00": employee.getGender()%></td>
                </tr>
                </table>
              </td>
              </tr>
              
              <tr>
              <td colspan="2">
              <table cellspacing="0" border="1" width="100%" align="center" >
              <tr>
              <td bgcolor="#808080" align="center"><h5>House Rent Allowance</h5> </td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>AMOUNT</h5></td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>EXEMPT</h5></td>
              </tr>
              <tr bgcolor="#D3D3D3">
              <td style="padding:5px;" align="right"><strong>Rent Paid per month</strong></td>
              <td style="padding:5px;" align="right" ><strong><%=declarationMonthly.getHraRent()==0 ?"0.00":declarationMonthly.getHraRent() %></strong></td> 
              <td style="padding:5px;" align="right" ><strong><%=declarationMonthly.getHraExempt()==0?"0.00": declarationMonthly.getHraExempt()%> </strong></td>
              </tr>
              </table>
              </td>
              </tr>  

              <tr>
              <td colspan="2">
              <table cellspacing="0" border="1" width="100%" align="center" >
              <tr>
              <td bgcolor="#808080" align="center"><h5>Section B - Chapter VI A - Deductions from Total Income</h5> </td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>AMOUNT</h5></td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>EXEMPT</h5></td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Insurance Premium (U/s 80D) - Individual, Spouse & Children (Max Limit INR 25,000 p.a)</td>
              <td style="padding:5px;" align="right" ><%=declarationMonthly.getMedicalIndividual()==0 ?"0.00":declarationMonthly.getMedicalIndividual() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Insurance Premium (U/s 80D) - Parents not being Senior Citizens (Max Limit INR 25,000 p.a)</td>
              <td style="padding:5px;" align="right" > <%=declarationMonthly.getMedicalParents()==0 ?"0.00":declarationMonthly.getMedicalParents() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Insurance Premium (U/s 80D) - Parents being Senior Citizens (Max Limit INR 30,000 p.a)</td>
              <td style="padding:5px;" align="right" >  <%=declarationMonthly.getMedicalParentsSenior()==0 ?"0.00":declarationMonthly.getMedicalParentsSenior()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Treatment/Handicapped Dependent (U/s 80DD) <80%</td>
              <td style="padding:5px;" align="right" ><%=declarationMonthly.getMedicalHandiLess80()==0 ?"0.00": declarationMonthly.getMedicalHandiLess80()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Treatment/Handicapped Dependent (U/s 80DD) >80%</td>
              <td style="padding:5px;" align="right" ><%=declarationMonthly.getMedicalHandiGater80()==0 ?"0.00":declarationMonthly.getMedicalHandiGater80() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Treatment in case any Disease/ Ailment-Self/Dependent (U/s 80DDB) Senior citizens (> 60 years and < 80 years)</td>
              <td style="padding:5px;" align="right" > <%=declarationMonthly.getMedicalGater60Less80()==0 ?"0.00":declarationMonthly.getMedicalGater60Less80() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Medical Treatment in case any Disease/ Ailment-Self/Dependent (U/s 80DDB) Super Senior citizens (> 80 years )</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getMedicalGater80()==0 ?"0.00":declarationMonthly.getMedicalGater80() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Interest on Educational Loan (U/s 80E)</td>
              <td style="padding:5px;" align="right" ><%=declarationMonthly.getEducationLoan()==0 ?"0.00":declarationMonthly.getEducationLoan() %></td>
              </tr>
              <tr >
              <td style="padding:5px;">Permanent Physical Disability (80U) < 80%</td>
              <td style="padding:5px;" align="right" ><%=declarationMonthly.getPhysicalDisability()==0 ?"0.00": declarationMonthly.getPhysicalDisability()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Permanent Physical Disability Severe Disability (80U) > 80%</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getPhysicalDisabilitySevere()==0 ?"0.00": declarationMonthly.getPhysicalDisabilitySevere()%></td>
              </tr>
              <tr >
              <td style="padding:5px;">Rajeev Gandhi Equity Savings Scheme (80CCG)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getEquitySavings()==0 ?"0.00": declarationMonthly.getEquitySavings()%></td>
              </tr>
              <tr >
              <td style="padding:5px;">Interest on Deposit in Savings Account deduction upto Rs.10000 (80TTA)</td>
              <td style="padding:5px;" align="right" ><%=declarationMonthly.getInterestOnDeposit()==0 ?"0.00":declarationMonthly.getInterestOnDeposit() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">National Pension Scheme(80CCD)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getNationalPension()==0 ?"0.00":declarationMonthly.getNationalPension()%> </td>
              </tr>
              <tr bgcolor="#D3D3D3">
              <td style="padding:5px;" align="right"><strong>Total</strong></td>
              
              <% double sectionBTotal = declarationMonthly.getMedicalIndividual() + declarationMonthly.getMedicalParents() + declarationMonthly.getMedicalParentsSenior() + declarationMonthly.getMedicalHandiLess80();
                     
              sectionBTotal += declarationMonthly.getMedicalHandiGater80() + declarationMonthly.getMedicalGater60Less80() + declarationMonthly.getMedicalGater80() + declarationMonthly.getEducationLoan() ;
              sectionBTotal += declarationMonthly.getPhysicalDisability() +  declarationMonthly.getPhysicalDisabilitySevere() + declarationMonthly.getEquitySavings() + declarationMonthly.getInterestOnDeposit() + declarationMonthly.getNationalPension();
               %>
              <td style="padding:5px;" align="right"><strong> <%=df2.format(sectionBTotal) %></strong></td>
              <td style="padding:5px;" align="right"><strong><%=df2.format(declarationMonthly.getSectionBExempt()) %></strong></td>
              </tr>
              </table>
              </td>
              </tr>

              <tr>
              <td colspan="2">
              <table cellspacing="0" border="1" width="100%" align="center" >
              <tr>
              <td bgcolor="#808080" align="center"><h5>Section C - Chapter VIA Sec 80C</h5> </td>
              <td align="center" width="20%" bgcolor="#808080"><h5>AMOUNT</h5></td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>EXEMPT</h5></td>
              </tr>
              <tr >
              <td style="padding:5px;">Life Insurance Premium </td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getLic()==0 ?"0.00":declarationMonthly.getLic()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Public Provident Fund (PPF)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getPpf() ==0 ?"0.00":declarationMonthly.getPpf()%></td>
              </tr>
              <tr >
              <td style="padding:5px;">National Savings Certificate (NSC)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getNsc()==0 ?"0.00": declarationMonthly.getNsc()%></td>
              </tr>
              <tr >
              <td style="padding:5px;">Infrastructure Bonds</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getInfraBonds() ==0 ?"0.00":declarationMonthly.getInfraBonds()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Children Education Tuition Fees</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getTuitionFees()==0 ?"0.00":declarationMonthly.getTuitionFees() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Mutual Funds / Equity Linked Saving Scheme (ELSS)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getMutualFunds()==0 ?"0.00":declarationMonthly.getMutualFunds() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Sukanya Samriddhi Scheme </td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getSukanya()==0 ?"0.00": declarationMonthly.getSukanya()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">ULIP</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getUlip() ==0 ?"0.00":declarationMonthly.getUlip()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">5 Year Time Deposit in Post Office</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getTimeDeposit() ==0 ?"0.00":declarationMonthly.getTimeDeposit()%> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Housing Loan - Principal Amount paid, Registration Fees, Stamp duty</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getHousingLoan() ==0 ?"0.00":declarationMonthly.getHousingLoan() %></td>
              </tr>
              <tr >
              <td style="padding:5px;">Fixed Deposit Scheme (Block Period of 5 yrs)</td>
              <td style="padding:5px;" align="right"> <%=declarationMonthly.getFixedDeposit()==0 ?"0.00":declarationMonthly.getFixedDeposit()  %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Provident Fund (PF)</td>
              <td style="padding:5px;" align="right"> <%=declarationMonthly.getTotalProvidentFund()==0 ?"0.00":declarationMonthly.getTotalProvidentFund() %> <!-- '.$declaration_data['total_provident_fund'].' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">NSC Interest (Will be considered as Other Income)</td>
              <td style="padding:5px;" align="right"> <%=declarationMonthly.getNscInterest()==0 ?"0.00":declarationMonthly.getNscInterest() %> </td>
              </tr>
              <tr bgcolor="#D3D3D3">
              <td style="padding:5px;" align="right"><strong>Total</strong></td>
              <%
              double sectionCTotal = declarationMonthly.getLic() + declarationMonthly.getPpf()  + declarationMonthly.getNsc() + declarationMonthly.getInfraBonds() + declarationMonthly.getTuitionFees();
              sectionCTotal += declarationMonthly.getMutualFunds() + declarationMonthly.getSukanya() + declarationMonthly.getUlip() + declarationMonthly.getTimeDeposit() + declarationMonthly.getHousingLoan() ;
              sectionCTotal +=  declarationMonthly.getFixedDeposit() + declarationMonthly.getTotalProvidentFund() + declarationMonthly.getNscInterest();
              %>
              <td style="padding:5px;" align="right"><strong><%=df2.format(sectionCTotal) %></strong></td>
              <td style="padding:5px;" align="right"><strong><%=df2.format(declarationMonthly.getSectionCExempt()) %></strong></td>
              </tr>
              </table>
              </td>
              </tr>


               <tr>
              <td colspan="2">
              <table cellspacing="0" border="1" width="100%" align="center" >
              <tr>
              <td bgcolor="#808080" align="center"><h5>Section D - Loss from House Property - SELF OCCUPIED</h5> </td>
              <td align="center" width="20%" bgcolor="#808080"><h5>AMOUNT</h5></td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>EXEMPT</h5></td>
              </tr>
              <tr >
              <td style="padding:5px;">Total interest paid by me (post construction/possession/ amortized pre-emi) during the financial year </td>
              <td style="padding:5px;" align="right"> <%=declarationMonthly.getHousingLoanInterest() %> </td>
              </tr>
              <tr >
              <td  style="padding:5px;" colspan="2">Address of the Property against which Loan taken :</td>
              </tr>
              <tr >
              <td colspan="2"><%=declarationMonthly.getHousingAddress() %> </td>
              <td style="padding:5px;" align="right"><strong><%=declarationMonthly.getSectionDExempt() %></strong></td>
              </tr>
              </table>
              </td>
              </tr>

              <tr>
              <td colspan="2">
              <table cellspacing="0" border="1" width="100%" align="center" >
              <tr>
              <td bgcolor="#808080" align="center"><h5>Section E - Previous Employment</h5> </td>
              <td align="center" width="20%" bgcolor="#808080"><h5>AMOUNT</h5></td>
              <td align="center" align="center" width="20%" bgcolor="#808080"><h5>EXEMPT</h5></td>
              </tr>
              <tr >
              <td style="padding:5px;">Income after Section 10 exemption </td>
              <td style="padding:5px;" align="right"> <%=declarationMonthly.getPreviousIncome() %></td>
              </tr>
              <tr >
              <td style="padding:5px;">Provident Fund (PF)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getPreviousPf() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Professional Tax (PT)</td>
              <td style="padding:5px;" align="right"><%=declarationMonthly.getPreviousPt() %> </td>
              </tr>
              <tr >
              <td style="padding:5px;">Tax deducted at source (TDS)</td>
              <td style="padding:5px;" align="right"><%=df2.format(declarationMonthly.getPreviousTds()) %></td>
              </tr>
              <tr bgcolor="#D3D3D3">
              <td style="padding:5px;" align="right"><strong>Total</strong></td>
              <% double sectionETotal = declarationMonthly.getPreviousIncome() + declarationMonthly.getPreviousPf() +  declarationMonthly.getPreviousPt() + declarationMonthly.getPreviousTds(); %>
              <td style="padding:5px;" align="right" ><strong><%= df2.format(sectionETotal) %></strong></td>
              <td><strong><!-- '.$tds_deducted.' --></strong></td>
              </tr>
              </table>
              </td>
              </tr>


              <tr>
              <td colspan="2">
              <table cellspacing="0" border="1" width="100%" align="center" >
              <tr>
              <td bgcolor="#808080" align="center"><h5>Particular</h5> </td>
              <td align="center" width="20%" bgcolor="#808080"><h5>AMOUNT</h5></td>
              
              </tr>
              <tr >
              <td style="padding:5px;">Annual Income (Basic+HRA+Medical+Travel+Conveyance) </td>
              <td style="padding:5px;" align="right"><%=df2.format(declarationMonthly.getSalaryBeforeExempt()) %>   <!-- '.$salary_before_exempt.' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">Less Profession Tax</td>
              <td style="padding:5px;" align="right" > <%= df2.format(declarationMonthly.getTotalPtax()) %> <!-- '.$total_ptax.' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">Less exempt (HRA+B+C+D+E)</td>
              <td style="padding:5px;" align="right" ><%=df2.format(declarationMonthly.getHraExempt() +declarationMonthly.getSectionBExempt()  + declarationMonthly.getSectionCExempt() + declarationMonthly.getSectionDExempt() + declarationMonthly.getPreviousTds()) %></td>
              </tr>
              <tr >
              <td style="padding:5px;">Gross Taxable Income </td>
              <td style="padding:5px;" align="right"><%=df2.format(declarationMonthly.getSalaryAfterExempt()) %> <!-- '.$salary_after_exempt.' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">Income Tax</td>
              <td style="padding:5px;" align="right"><%= df2.format(declarationMonthly.getGrossTds()) %></td>
              </tr>
              <tr >
              <td style="padding:5px;">Education Cess @ 3% of Income Tax</td>
              <td style="padding:5px;" align="right" > <%=df2.format(declarationMonthly.getEducationCess()) %> <!-- '.number_format($educationcess,2).' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">Net Tax Payable</td>
              <td style="padding:5px;" align="right"> <%=df2.format(declarationMonthly.getTotalTds()) %> <!-- '.number_format($total_tds,2).' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">Advance Tax Paid</td>
              <td style="padding:5px;" align="right"><%= df2.format(declarationMonthly.getTdsDeducted()) %> <!-- '.number_format($tds_deducted,2).' --></td>
              </tr>
              <tr >
              <td style="padding:5px;">Tax Due</td>
              <td style="padding:5px;" align="right" > <%= df2.format(declarationMonthly.getTotalTds()- declarationMonthly.getTdsDeducted()) %> <!-- '.number_format($total_tds-$tds_deducted,2).' --></td>
              </tr>
              <tr bgcolor="#D3D3D3">
              <td style="padding:5px;"  align="right"><strong><%=per_month %></strong></td>
              <td  style="padding:5px;" align="right"><strong> <%=df2.format(declarationMonthly.getTdsDuePerMonth()) %> <!-- '.$tds_due_per_month.' --></strong></td>
              
              </tr>
              </table>
              </td>
              </tr>
              </table>

              
<%-- <aui:button icon="download" value="Download TDS" href="<%=printPdf.toString() %>">
	</aui:button> --%>
	<a  href="<%=printPdf.toString() %>" >TDS</a>
            </body>
  <%}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>          
            
            