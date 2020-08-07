<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayrollSlabsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayrollSlabs"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalSetup"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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

<%
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	String strFromDateCycle = StringPool.BLANK;
	Date fromDatePCycle = null;
	String strToDatePCycle = StringPool.BLANK;
	Date toDatePCycle = null;
	String strFromDateSPeriod = StringPool.BLANK;
	Date fromDateSPeriod = null;
	String strToDateSPeriod = StringPool.BLANK;
	Date toDateSPeriod = null;
	long appraisalPeriod = 0;
	String employeeType = StringPool.BLANK;

	AppraisalSetup appraisalSetup = null;
	long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");
	if (Validator.isNotNull(appraisalSettingId)) {
		appraisalSetup = AppraisalSetupLocalServiceUtil.getAppraisalSetup(appraisalSettingId);
	}
	System.out.println("inside appraisalSetup if condition");
	if (appraisalSetup != null) {
		System.out.println("inside appraisalSetup if condition");
		fromDatePCycle = appraisalSetup.getFromDateCycle();
		toDatePCycle = appraisalSetup.getToDateCycle();
		fromDateSPeriod = appraisalSetup.getFromDateSubmission();
		toDateSPeriod = appraisalSetup.getToDateSubmission();
		appraisalPeriod = appraisalSetup.getAppraisalPeriod();
		employeeType = appraisalSetup.getEmployeeType();
	}
	if (Validator.isNotNull(fromDatePCycle)) {
		strFromDateCycle = formatter.format(fromDatePCycle);
	}
	if (Validator.isNotNull(toDatePCycle)) {
		strToDatePCycle = formatter.format(toDatePCycle);
	}
	if (Validator.isNotNull(fromDateSPeriod)) {
		strFromDateSPeriod = formatter.format(fromDateSPeriod);
	}
	if (Validator.isNotNull(toDateSPeriod)) {
		strToDateSPeriod = formatter.format(toDateSPeriod);
	}
%>
<portlet:renderURL var="viewURL"
	windowState="<%=LiferayWindowState.NORMAL.toString()%>">
	<portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>

<liferay-ui:error key="add-error" message="Date range is already exist"></liferay-ui:error>

<liferay-ui:header title="Add/Edit Appraisal Setup" backLabel="Back"
	backURL="<%=viewURL.toString()%>"></liferay-ui:header>

<portlet:actionURL name="addAppraisalSetup" var="addAppraisalSetupURL" />

<aui:form name="addAppraisalSetup"
	action="<%=addAppraisalSetupURL.toString()%>" method="post">
	<aui:input name="appraisalSettingId" value="<%=appraisalSettingId%>"
		type="hidden"></aui:input>
	<aui:row>
		<aui:col span="6">
			<label><h3>Performance Cycle</h3></label>
			<hr>
			<aui:row>
				<aui:col span="6">
					<aui:input name="fromDatePCycle" id="fromDatePCycle" type="text"
						readonly="readonly" required="true" value="<%=strFromDateCycle%>"
						label="From Date" />
				</aui:col>
				<aui:col span="6">
					<aui:input name="toDatePCycle" id="toDatePCycle" type="text"
						readonly="readonly" required="true" value="<%=strToDatePCycle%>"
						label="To Date" />
				</aui:col>
			</aui:row>
		</aui:col>
		<aui:col span="6">
			<label><h3>Appraisal submission period for employees</h3></label>
			<hr>
			<aui:row>
				<aui:col span="6">
					<aui:input name="fromDateSPeriod" id="fromDateSPeriod" type="text"
						readonly="readonly" required="true"
						value="<%=strFromDateSPeriod%>" label="From Date" />
				</aui:col>
				<aui:col span="6">
					<aui:input name="toDateSPeriod" id="toDateSPeriod" type="text"
						readonly="readonly" required="true" value="<%=strToDateSPeriod%>"
						label="To Date" />
				</aui:col>
			</aui:row>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<label><h3>Appraisal Setup</h3></label>
			<hr>

			<aui:select label="Minimum appraisal period (Month)"
				id="appraisalPeriod" name="appraisalPeriod">
				<aui:option value="0" selected="<%=0 == appraisalPeriod%>">0-month</aui:option>
				<aui:option value="1" selected="<%=1 == appraisalPeriod%>">1-month</aui:option>
				<aui:option value="2" selected="<%=2 == appraisalPeriod%>">2-month</aui:option>
				<aui:option value="3" selected="<%=3 == appraisalPeriod%>">3-month</aui:option>
				<aui:option value="4" selected="<%=4 == appraisalPeriod%>">4-month</aui:option>
				<aui:option value="5" selected="<%=5 == appraisalPeriod%>">5-month</aui:option>
				<aui:option value="6" selected="<%=6 == appraisalPeriod%>">6-month</aui:option>
				<aui:option value="7" selected="<%=7 == appraisalPeriod%>">7-month</aui:option>
				<aui:option value="8" selected="<%=8 == appraisalPeriod%>">8-month</aui:option>
				<aui:option value="9" selected="<%=9 == appraisalPeriod%>">9-month</aui:option>
				<aui:option value="10" selected="<%=10 == appraisalPeriod%>">10-month</aui:option>
				<aui:option value="11" selected="<%=11 == appraisalPeriod%>">11-month</aui:option>
				<aui:option value="12" selected="<%=12 == appraisalPeriod%>">12-month</aui:option>
			</aui:select>
		</aui:col>
		<%
			List<EmployeeType> empTypeList = EmployeeTypeLocalServiceUtil.getEmployeeTypes(-1, -1);
		%>
		<aui:col span="6">
			<label><h3>Select Employee Type</h3></label>
			<hr>
			<aui:select label="Employee Type" multiple="true" id="employeeType"
				style="height: 65px;" name="employeeType">
				<%
					for (EmployeeType empType : empTypeList) {
						String selected = StringPool.BLANK;
						if (Validator.isNotNull(employeeType)) {
							List<String> lists = Arrays.asList(employeeType.split("\\|"));
							System.out.println("lists : "+lists);
							System.out.println("getEmployeetypeId : "+empType.getEmployeetypeId());
							if(lists.contains(String.valueOf(empType.getEmployeetypeId()))){
								System.out.println("lists : "+lists.size());
								selected = "selected";
							}
						}
						
				%>
				<option value="<%=empType.getEmployeetypeId()%>" <%=selected%>><%=empType.getTypeName()%></option>
				<%
					}
				%>
			</aui:select>
		</aui:col>
	</aui:row>

	<%
		long plidDashboard = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "RatingMaster");
			LiferayPortletURL addRatingURL = PortletURLFactoryUtil.create(request, "RatingMaster", plidDashboard,
					"0");
			addRatingURL.setWindowState(LiferayWindowState.NORMAL);
			addRatingURL.setParameter("jspPage", "/view.jsp");
	%>

	<aui:a href="<%=addRatingURL.toString()%>" style="float: right;"
		cssClass="btn custom-button btn-primary btn-default"
		label="Add New Rating"></aui:a>

	<aui:row>
		<aui:col span="6">
			<label><h3>Salary Increment Percentage</h3></label>
			<hr>
		</aui:col>
		<aui:col span="6"></aui:col>
	</aui:row>

	<%
		List<RatingMaster> ratingMasters = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);
	%>

	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<table class="table no-margin table-hover table-bordered">
				<thead>
					<tr class="label-info labelinfo1">
						<th class="text-center" style="font-weight: bold;">Rating
							Number.</th>
						<th class="text-center" style="font-weight: bold;">Rating Key</th>
						<th class="text-center" style="font-weight: bold;">Salary
							Increment (%)</th>
						<th class="text-center" style="font-weight: bold;">Bonus (%)</th>
					</tr>
				</thead>
				<tbody id="custom-table">
					<%
						String ratingList = StringPool.BLANK;
							if (Validator.isNotNull(ratingMasters) && !ratingMasters.isEmpty()) {
								for (RatingMaster ratingMaster : ratingMasters) {
									ratingList = ratingList + ratingMaster.getRatingId() + ",";
									PayrollSlabs payrollSlabs = null;
									try {
										if (Validator.isNotNull(appraisalSetup)) {
											payrollSlabs = PayrollSlabsLocalServiceUtil.findByAppraisalSettingIdRatingId(
													appraisalSetup.getAppraisalSettingId(), ratingMaster.getRatingId());
											System.out.println("appPerformObj...>>> " + payrollSlabs);
										}
									} catch (Exception e) {
									}
					%>
					<tr>
						<td class="text-center"><%=ratingMaster.getRatingNum()%></td>
						<td class="text-center" style="font-size: 16px;"><%=ratingMaster.getRatingKey()%><liferay-ui:icon-help
								message="<%=ratingMaster.getRatingDescription()%>" /></td>
						<td class="text-left" style="text-align: center;"><input
							onkeypress="return isDecimal(event);" maxlength="5" type="text"
							class="fs_input" id="salarypercentage[145]"
							name="<portlet:namespace/>salarypercentage_<%=ratingMaster.getRatingId()%>"
							value="<%=Validator.isNotNull(payrollSlabs) ? payrollSlabs.getPayrollPercentage() : ""%>"
							placeholder=" Salary Percentage"></td>
						<td class="text-left" style="text-align: center;"><input
							onkeypress="return isDecimal(event);" maxlength="5" type="text"
							class="fs_input" id="bonuspercentage[145]"
							name="<portlet:namespace/>bonuspercentage_<%=ratingMaster.getRatingId()%>"
							value="<%=Validator.isNotNull(payrollSlabs) ? payrollSlabs.getBonusPercentage() : ""%>"
							placeholder=" Bonus Percentage"></td>
					</tr>
					<%
						}
							}
					%>
					<input name="<portlet:namespace/>ratingList" type="hidden"
						value="<%=ratingList%>" />
				</tbody>
			</table>
		</div>
	</div>
	<aui:button-row>
		<aui:button type="submit" cssClass="custom-button" name="Submit"
			label="" value="submit"></aui:button>
	</aui:button-row>
</aui:form>

<!-- <script>
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />fromDatePCycle',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {

			}
		});
	});

	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />toDatePCycle',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {

			}
		});
	});

	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />fromDateSPeriod',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {

			}
		});
	});

	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />toDateSPeriod',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {

			}
		});
	});
</script> -->

<aui:script>
	AUI()
			.use(
					'aui-datepicker',
					'datatype-date',
					'datatype-date-math',
					'datatype-date-parse',
					function(A) {
						var toDatePicker;
						var fromDatePicker = new A.DatePicker(
								{
									trigger : '#<portlet:namespace />fromDatePCycle',
									mask : '%d/%m/%Y',
									popover : {
										zIndex : 1000
									},
									on : {
										selectionChange : function(event) {
											if (event.newSelection[0]) {
												var oldToValue = A.Date
														.parse(
																"%d/%m/%Y",
																document
																		.getElementById("<portlet:namespace />toDatePCycle").value);
												toDatePicker.getCalendar().set(
														'minimumDate',
														event.newSelection[0]);
												if (A.Date.isGreater(
														event.newSelection[0],
														oldToValue)) {
													document
															.getElementById("<portlet:namespace />toDatePCycle").value = A.Date
															.format(
																	event.newSelection[0],
																	{
																		format : "%d/%m/%Y"
																	});
												}
											}
										}
									},
									calendar : {
									// minimumDate: new Date()
									}
								});

						toDatePicker = new A.DatePicker({
							trigger : '#<portlet:namespace />toDatePCycle',
							mask : '%d/%m/%Y',
							popover : {
								zIndex : 1000
							},
							calendar : {
							//   minimumDate: new Date()
							}
						});
					});
</aui:script>







<aui:script>
	AUI()
			.use(
					'aui-datepicker',
					'datatype-date',
					'datatype-date-math',
					'datatype-date-parse',
					function(A) {
						var toDatePicker;
						var fromDatePicker = new A.DatePicker(
								{
									trigger : '#<portlet:namespace />fromDateSPeriod',
									mask : '%d/%m/%Y',
									popover : {
										zIndex : 1000
									},
									on : {
										selectionChange : function(event) {
											if (event.newSelection[0]) {
												var oldToValue = A.Date
														.parse(
																"%d/%m/%Y",
																document
																		.getElementById("<portlet:namespace />toDateSPeriod").value);
												toDatePicker.getCalendar().set(
														'minimumDate',
														event.newSelection[0]);
												if (A.Date.isGreater(
														event.newSelection[0],
														oldToValue)) {
													document
															.getElementById("<portlet:namespace />toDateSPeriod").value = A.Date
															.format(
																	event.newSelection[0],
																	{
																		format : "%d/%m/%Y"
																	});
												}
											}
										}
									},
									calendar : {
										minimumDate : new Date()
									}
								});

						toDatePicker = new A.DatePicker({
							trigger : '#<portlet:namespace />toDateSPeriod',
							mask : '%d/%m/%Y',
							popover : {
								zIndex : 1000
							},
							calendar : {
							//   minimumDate: new Date()
							}
						});
					});
</aui:script>





<style>
.label-info {
	background-color: #d0ddef !important;
}
</style>