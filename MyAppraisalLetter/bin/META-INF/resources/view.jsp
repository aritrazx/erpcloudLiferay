<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayrollIncrementLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayrollIncrement"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="java.util.List"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page contentType="text/html; charset=utf-8" language="java"%>

<%
	DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
	Employee employee = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
	long isActive = 1;
	AppraisalSetup appraisalSetup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);
	System.out.println("setup object : " + appraisalSetup);
	AppraisalMaster appraisalMaster = null;
	RatingMaster ratingMaster = null;
	String firstName = StringPool.BLANK;
	String lastName = StringPool.BLANK;
	long employeeCode = 0;
	Date joiningDate = null;
	String ratingKey = StringPool.BLANK;
	String financialYear = StringPool.BLANK;

	double totalPay = 0;
	double annualCTC = 0;
	double bonusVal = 0;
	Date fromDateCycle = null;
	Date toDateCycle = null;
	Date fromDate = null;
	String strFromDateCycle = "";
	String strToDateCycle = "";
	long noOfMonths = 0;

	if (appraisalSetup != null) {
		financialYear = appraisalSetup.getFinancialYear();

		if (employee != null) {
			firstName = employee.getFirstName();
			lastName = employee.getLastName();
			employeeCode = employee.getEmployeeCode();
			joiningDate = employee.getDateOfJoing();
			appraisalMaster = AppraisalMasterLocalServiceUtil.findBySettingIdAndEmployeeId(
					appraisalSetup.getAppraisalSettingId(), employee.getEmployeeId());
		}

	}

	if (appraisalMaster != null) {
		if (appraisalMaster.getSubmitStep() == 3) {

			if (appraisalMaster != null) {
				ratingMaster = RatingMasterLocalServiceUtil
						.getRatingMaster(appraisalMaster.getOverallRatingMan());
			}
			if (ratingMaster != null) {
				ratingKey = ratingMaster.getRatingKey();
			}

			Calendar startCalendar = new GregorianCalendar();
			Calendar endCalendar = new GregorianCalendar();
			int diffMonth = 0;
			int diffYear = 0;
			List<PayComponent> payComponentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
%>

<%
	if (appraisalMaster != null) {
				if (appraisalSetup.getIsLocked() == 1) {
%>
<div
	style="display: block; width: 760px; padding: 0 10px; margin: 0 auto;">
	<div style="display: block; width: 100%; vertical-align: top;">
		<div style="display: block; width: 100%; vertical-align: top;">
			<table width="100%" align="center">

				<tr>
					<td valign="top" width="60%">
						<div
							style="display: inline-block; width: 100%; vertical-align: top;">
							<img height="45" width="180"
								src="<%=renderRequest.getContextPath()%>/icon_famocom.png"
								title="famocom" alt="famocom" />
						</div>
					</td>
					<td valign="top" width="40%"></td>
				</tr>
			</table>

			<div style="float: left; width: 100%; margin-top: 30px;">
				<div style="width: 100%;"></div>
				<div style="width: 100%; font-style: italic;">Private &
					Confidential</div>
				<div style="width: 100%; font-weight: bold; margin-top: 5px;"><%=firstName%>
					<%=lastName%></div>
				<div style="width: 100%;">
					Employee Code:
					<%=employeeCode%></div>

				<div style="width: 100%; margin-top: 10px;">
					Dear <strong><%=firstName%> <%=lastName%></strong>
				</div>

				<%
					fromDateCycle = appraisalSetup.getFromDateCycle();
									toDateCycle = appraisalSetup.getToDateCycle();
									if (joiningDate.before(fromDateCycle)) {
										fromDate = fromDateCycle;
										strFromDateCycle = dateFormat.format(fromDate);
										strToDateCycle = dateFormat.format(toDateCycle);
										startCalendar.setTime(fromDate);
										endCalendar.setTime(toDateCycle);
										diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
										diffMonth = (diffYear * 12 + endCalendar.get(Calendar.MONTH)
												- startCalendar.get(Calendar.MONTH)) + 1;
										System.out.println("diffMonth if: " + diffMonth + "diffYear else: " + diffYear);
									} else if (joiningDate.after(fromDateCycle)) {
										fromDate = joiningDate;
										strFromDateCycle = dateFormat.format(fromDate);
										strToDateCycle = dateFormat.format(toDateCycle);
										startCalendar.setTime(fromDate);
										endCalendar.setTime(toDateCycle);
										System.out.println("diffMonth else: " + diffMonth + "diffYear else: " + diffYear);
										diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
										diffMonth = (diffYear * 12 + endCalendar.get(Calendar.MONTH)
												- startCalendar.get(Calendar.MONTH)) + 1;
										System.out.println("diffMonth else: " + diffMonth + "diffYear else: " + diffYear);
									}
				%>

				<div style="width: 100%; margin-top: 10px;">
					Based on the overall evaluation of your performance during the last
					<%=diffMonth%>
					months (<%=strFromDateCycle%><span> – </span><%=strToDateCycle%>)
					with Famocom Technology Systems Private Limited, we are pleased to
					inform you that your performance is rated as <strong><%=ratingKey%></strong>.
				</div>
				<div style="width: 100%; margin-top: 10px; margin-bottom: 20px;">
					Effective
					<%=strToDateCycle%>
					your annual compensation has been revised as given below:.
				</div>


			</div>

		</div>



		<table width="100%" align="center" style="border-collapse: collapse;">
			<tr style="width: 100%; margin-top: 10px; border: 1px solid black;">
				<td colspan="2" width="100%" align="center"
					style="border: 1px solid black;">REVISED SALARY STRUCTURE</td>
			</tr>
			<tr style="border: 1px solid black;">
				<td style="font-weight: bold;">NAME</td>
				<td style="font-weight: bold;"><%=firstName%> <%=lastName%></td>
			</tr>
			<tr style="border: 1px solid black;">
				<td style="border: 1px solid black;" align="left">Particulars</td>
				<td style="border: 1px solid black;" align="right">Amount(Rs.)</td>
			</tr>

			<%
				for (PayComponent component : payComponentList) {
									PayrollIncrement payrollIncrement = PayrollIncrementLocalServiceUtil
											.findByEmployeeIdComponentIdFinancialYear(employee.getEmployeeId(),
													component.getComponentId(), financialYear);
									if (payrollIncrement != null) {
										System.out.print("payrollIncrement.getPostHeadComponentVal() : "
												+ payrollIncrement.getPostHeadComponentVal());

										totalPay = totalPay + payrollIncrement.getPostHeadComponentVal();
										bonusVal = payrollIncrement.getBonusVal();
			%>
			<tr>
				<td style="border: 1px solid black; font-style: italic;"
					align="left"><%=component.getName()%></td>
				<td style="border: 1px solid black; text-align: right;"><%=payrollIncrement.getPostHeadComponentVal()%></td>
			</tr>

			<%
				}
								}
			%>

			<tr>
				<td style="border: 1px solid black; font-style: italic;"
					align="left">Monthly Gross Salary</td>
				<td style="border: 1px solid black; text-align: right;"><%=totalPay%></td>
			</tr>
			<tr>
				<td style="border: 1px solid black; font-style: italic;"
					align="left">Performance Bonus(Annual)
					<p style="font-size: 10px;">Performance bonus will be
						calculated during next appraisal based on your performance
						throughout the year.</p>
				</td>
				<td valign="top" style="border: 1px solid black; text-align: right;"><%=bonusVal%>
				</td>
			</tr>
			<%
				annualCTC = totalPay * 12;
			%>
			<tr>
				<td style="border: 1px solid black; font-style: italic;"
					align="left">CTC (Annual)</td>
				<td style="border: 1px solid black; text-align: right;"><%=annualCTC%></td>
			</tr>
		</table>

		<div style="width: 100%; margin-top: 5px; margin-bottom: 5px;">Please
			note that your compensation is personal to you and hence, you are
			requested to maintain its confidentiality always.</div>
		<div style="width: 100%; margin-top: 5px; margin-bottom: 5px;">We
			thank you for your synergic contribution to the company. We strongly
			believe that your perpetuated commitment and increased efforts would
			ensure towards our company growth and reputation.</div>
		<div style="width: 100%; margin-top: 5px; margin-bottom: 5px;">We
			take this opportunity to wish you the very best in the year ahead.</div>
		<div style="width: 100%; margin-top: 30px; margin-bottom: 40px;">Yours
			sincerely,</div>
		<div style="width: 100%; margin-top: 10px; margin-bottom: 5px;">Human
			Resource Manager</div>
		<div style="width: 100%; margin-top: 5px; margin-bottom: 5px;">Famocom
			Technology Systems Private Limited.</div>

	</div>
</div>

<portlet:resourceURL id="exportAction" var="exportURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportToPdf" />
	<portlet:param name="employeeId"
		value="<%=String.valueOf(employee.getEmployeeId())%>" />
	<portlet:param name="appraisalSettingId"
		value="<%=String.valueOf(appraisalSetup.getAppraisalSettingId())%>" />
</portlet:resourceURL>

<aui:a target="_blank" href="<%=exportURL.toString()%>">
	<liferay-ui:message key="Print Appraisal Letter"></liferay-ui:message>
</aui:a>

<%
	} else {
%>
<div>No Appraisal Letter Found!</div>
<%
	}
			} else {
%>
<div>No Appraisal Letter Found!</div>
<%
	}
		} else {
%>
<div>No Appraisal Letter Found!</div>
<%
	}
	} else {
%>
<div>No Appraisal Letter Found!</div>
<%
	}
%>
