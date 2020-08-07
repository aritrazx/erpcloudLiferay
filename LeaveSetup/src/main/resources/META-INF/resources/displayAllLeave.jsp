<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveDoc"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApplyDtl"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.ThemeDisplayModel"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<LeaveApply> leaveListTemp = new ArrayList<>();
	leaveListTemp = LeaveApplyLocalServiceUtil.getLeaveApplies(-1, -1);

	List<LeaveType> leaveTypeList = new ArrayList<>();
	leaveTypeList = LeaveTypeLocalServiceUtil.getLeaveTypes(-1, -1);

	List<Employee> EmployeeList = new ArrayList<>();
	EmployeeList = EmployeeLocalServiceUtil.getEmployees(-1, -1);

	String status = StringPool.BLANK;

	PortletURL getViewUrl = renderResponse.createRenderURL();
	getViewUrl.setParameter("jspPage", "/imageView.jsp");

	PortletURL getApprovedViewURL = renderResponse.createRenderURL();
	getApprovedViewURL.setParameter("jspPage", "/leaveView.jsp");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	PortletURL iteratorIfUrl = renderResponse.createRenderURL();
	iteratorIfUrl.setParameter("jspPage", "/displayAllLeave.jsp");

	/* 	PortletURL  iteratorElseUrl = renderResponse.createRenderURL();
		iteratorElseUrl.setParameter("jspPage", "/displayAllLeave.jsp");
		iteratorElseUrl.setParameter(, value) */

	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	List<LeaveApply> leaveList = new ArrayList<>();
	List<LeaveApplyDtl> empleaveList = new ArrayList<>();

	String val = ParamUtil.getString(request, "selectEmployee", StringPool.BLANK);
	System.out.println("val..." + val);

	String selectEmployee = ParamUtil.getString(renderRequest, "selectEmployee", StringPool.BLANK);
	String fromDate = ParamUtil.getString(renderRequest, "fromDate", StringPool.BLANK);
	String toDate = ParamUtil.getString(renderRequest, "toDate", StringPool.BLANK);
	Date tempFromDate = new Date();
	if (Validator.isNotNull(fromDate)) {
		tempFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
	}
	Date tempToDate = new Date();
	if (Validator.isNotNull(toDate)) {
		tempToDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
	}
	System.out.println("selectEmployee..." + selectEmployee);
	System.out.println("fromDate..." + fromDate);
	System.out.println("toDate..." + toDate);
	try {
		if (Validator.isNull(selectEmployee)) {
			DynamicQuery dynamicQuery = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.between("leaveDate", tempFromDate, tempToDate);
			dynamicQuery.addOrder(OrderFactoryUtil.desc("leaveDate"));
			dynamicQuery.add(criterion3);
			empleaveList = LeaveApplyDtlLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("empleaveList from Date" + empleaveList);
		} else {
			DynamicQuery dynamicQuery = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("employeeId", Long.parseLong(selectEmployee));
			criterion3 = RestrictionsFactoryUtil.and(criterion3,
					RestrictionsFactoryUtil.between("leaveDate", tempFromDate, tempToDate));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("leaveDate"));
			dynamicQuery.add(criterion3);
			empleaveList = LeaveApplyDtlLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("empleaveList from Date and Id " + empleaveList.size());
		}
	} catch (Exception e) {

	}

	PortletURL iteratorElseUrl = renderResponse.createRenderURL();
	iteratorElseUrl.setParameter("jspPage", "/displayAllLeave.jsp");
	iteratorElseUrl.setParameter("fromDate", fromDate);
	iteratorElseUrl.setParameter("toDate", toDate);
	iteratorElseUrl.setParameter("selectEmployee", selectEmployee);
%>
<liferay-ui:header title="Total Applied List" backLabel="Back"
	backURL="<%=backURL.toString()%>">

</liferay-ui:header>

<portlet:actionURL name="employeeLeaveList" var="employeeLeaveListURL" />
<aui:form name="employeeLeaveList"
	action="<%=employeeLeaveListURL.toString()%>" method="post">
	<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
	<aui:row>
		<aui:col span="3">
			<aui:select name="selectEmployee" label="Select Employee"
				onChange="changeEmp(this.value);">
				<option value="">All Employee</option>
				<%
					try {
										List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
										for (Employee obj : empList) {
											String isSelect = null;
											if (!selectEmployee.isEmpty()) {
												if (obj.getEmployeeId() == Long.parseLong(selectEmployee)) {
													isSelect = "selected";
												}
											}
				%>
				<option value="<%=obj.getEmployeeId()%>" <%=isSelect%>><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
					<%=obj.getLastName()%></option>

				<%
					}
									} catch (Exception e) {
										e.printStackTrace();
									}
				%>
			</aui:select>
		</aui:col>
		<aui:col span="3">
			<aui:input id="fromDate" name="fromDate" type="text"
				label="From Date" placeholder="From Date" readonly="readonly">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
		<aui:col span="3">
			<aui:input id="toDate" name="toDate" type="text" label="To Date"
				placeholder="To Date" readonly="readonly">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
		<aui:col span="3">
			<span> <br />
			</span>
			<aui:button name="submit" type="submit" value="submit" />
		</aui:col>
	</aui:row>
</aui:form>

<aui:row>
	<%
		if (Validator.isNull(selectEmployee) && Validator.isNull(fromDate) && Validator.isNull(toDate)) {
	%>
	<liferay-ui:search-container delta="10"
		emptyResultsMessage="No record found." orderByCol=""
		iteratorURL="<%=iteratorIfUrl%>" orderByType="">
		<liferay-ui:search-container-results>
			<%
				results = leaveListTemp;
								total = results.size();
								searchContainer.setTotal(results.size());
								pageContext.setAttribute("results",
										results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
								pageContext.setAttribute("total", results.size());
								pageContext.setAttribute("delta", results.size());
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.famocom.erpcloud.model.LeaveApply"
			modelVar="var">
			<%
				Employee empObj = null;
								try {
									empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
								} catch (Exception e) {
									e.printStackTrace();
								}
			%>
			<liferay-ui:search-container-column-text name="Employee Id">
				<b><%=empObj.getEmployeeId()%></b>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Name">
				<b><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b>
			</liferay-ui:search-container-column-text>
			<%
				LeaveType leaveType = null;
								try {
									leaveType = LeaveTypeLocalServiceUtil.getLeaveType(var.getLeaveTypeId());
								} catch (Exception e) {
									e.printStackTrace();
								}
								if (Validator.isNotNull(var.getStatus())) {
									if (var.getStatus() == 0) {
										status = "PENDING";
									} else if (var.getStatus() == 1) {
										status = "APPROVED";
									} else if (var.getStatus() == 2) {
										status = "REJECTED";
									}

								}
			%>
			<liferay-ui:search-container-column-text name="Leave Type">
				<%=leaveType.getLeaveName()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="From Date">
				<%=dateFormat.format(var.getFromDate())%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="To Date">
				<%=dateFormat.format(var.getToDate())%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Leave Days"
				orderable="true" orderableProperty="leaveDays">
				<%=var.getLeaveDays()%>
			</liferay-ui:search-container-column-text>
			<%
				LeaveApply leaveApply = null;
								try {
									leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(var.getLeaveApplyId());
								} catch (Exception e) {
									e.printStackTrace();
								}
			%>
			<liferay-ui:search-container-column-text name="Attached File">
				<%
					try {
											List<LeaveDoc> leaveDocs = LeaveDocLocalServiceUtil
													.getDocsByLeaveApplyId(var.getLeaveApplyId());
											if (leaveDocs != null && !leaveDocs.isEmpty()) {
												System.out.println(":::::: If StatisFy :::::::");
												for (LeaveDoc doc : leaveDocs) {
													System.out.println("FileEntry Iddd-" + doc.getFileEntryId());
													if (doc.getFileEntryId() > 0) {

														FileEntry fileEntry = DLAppServiceUtil
																.getFileEntry(doc.getFileEntryId());
														String filePath = DLUtil.getPreviewURL(fileEntry,
																fileEntry.getFileVersion(), themeDisplay, "");
														System.out.println("FilePath .....................:-" + filePath);
				%>
				<liferay-ui:icon
					iconCssClass="<%=DLUtil.getFileIconCssClass(fileEntry.getExtension())%>"
					label="<%=true%>" url='<%=filePath%>' icon="pdf"
					message="<%=fileEntry.getTitle()%>" target="_blank" />
				<br>
				<%
					}
												}
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
				%>
			</liferay-ui:search-container-column-text>
			<%-- <liferay-ui:search-container-column-text name="Attached File" 
			orderable="true" orderableProperty="attachedFile">
			<liferay-ui:icon icon="pdf" label="<%= true %>"
			url="<%=var.getAttachedFile()!=null ?  var.getAttachedFile() :"No Files"%>" target="_blank"/>	
		</liferay-ui:search-container-column-text>  --%>

			<liferay-ui:search-container-column-text name="Status"
				orderable="true" orderableProperty="isapprove">
				<%=status%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="" cssClass="actionCol">
				<liferay-ui:icon-menu markupView="lexicon">
					<%
						getViewUrl.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId()));
						getApprovedViewURL.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId()));
						getApprovedViewURL.setParameter("leaveTypeId", String.valueOf(var.getLeaveTypeId()));
					%>
						<%if(var.getStatus()==1){ %>
					<liferay-ui:icon url="<%=getApprovedViewURL.toString()%>" label="view"
						message="view" image="view" />
						<%}else{%>
					<liferay-ui:icon url="<%=getViewUrl.toString()%>" label="view"
						message="view" image="view" />
						<%} %>
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator></liferay-ui:search-iterator>
		<%-- <liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator> --%>
	</liferay-ui:search-container>

	<%
		} else {
	%>
	<liferay-ui:search-container delta="10"
		emptyResultsMessage="No record found." orderByCol=""
		iteratorURL="<%=iteratorElseUrl%>" orderByType="">
		<liferay-ui:search-container-results>
			<%
				results = empleaveList;
								total = results.size();
								searchContainer.setTotal(results.size());
								pageContext.setAttribute("results",
										results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
								pageContext.setAttribute("total", results.size());
								pageContext.setAttribute("delta", results.size());
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.famocom.erpcloud.model.LeaveApplyDtl"
			modelVar="var">
			<%
				Employee empObj = null;
								try {
									empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
								} catch (Exception e) {
									e.printStackTrace();
								}
			%>
			<liferay-ui:search-container-column-text name="Employee Id">
				<b><%=empObj.getEmployeeId()%></b>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Name">
				<b><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b>
			</liferay-ui:search-container-column-text>
			<%
				LeaveType leaveTypeList1 = null;
								try {
									leaveTypeList1 = LeaveTypeLocalServiceUtil.getLeaveType(var.getLeaveTypeId());
								} catch (Exception e) {
									e.printStackTrace();
								}
								if (Validator.isNotNull(var.getIsApprove())) {
									if (var.getIsApprove() == 0) {
										status = "PENDING";
									} else if (var.getIsApprove() == 1) {
										status = "APPROVED";
									} else if (var.getIsApprove() == 2) {
										status = "REJECTED";
									}
								}
			%>
			<liferay-ui:search-container-column-text name="Leave Type">
				<%=leaveTypeList1.getLeaveName()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Date">
				<%=dateFormat.format(var.getLeaveDate())%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Leave Days"
				orderable="true" orderableProperty="leaveDays">
				<%=var.getLeaveDays()%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Status"
				orderable="true" orderableProperty="isapprove">
				<%=status%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="" cssClass="actionCol">
				<liferay-ui:icon-menu markupView="lexicon">
					<%
						getViewUrl.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId()));
						getViewUrl.setParameter("leaveTypeId", String.valueOf(var.getLeaveTypeId()));
						getApprovedViewURL.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId()));
						getApprovedViewURL.setParameter("leaveTypeId", String.valueOf(var.getLeaveTypeId()));
						getApprovedViewURL.setParameter("employeeId", String.valueOf(var.getEmployeeId()));
												
					
					%>
					<%if(var.getIsApprove()==1){ %>
					<liferay-ui:icon url="<%=getApprovedViewURL.toString()%>" label="view"
						message="view" image="view" />
						<%}%>
					<liferay-ui:icon url="<%=getViewUrl.toString()%>" label="view"
						message="view" image="view" />
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<%-- <liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator> --%>
		<liferay-ui:search-iterator></liferay-ui:search-iterator>
	</liferay-ui:search-container>
	<%
		}
	%>
</aui:row>
<!-- <script> 
	AUI().use('aui-datepicker', function(A) {
		new A.DatePicker({
			trigger : '#<portlet:namespace/>fromDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1000
			}
		});
	});
	AUI().use('aui-datepicker', function(A) {
		new A.DatePicker({
			trigger : '#<portlet:namespace/>toDate',

			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1000
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
									trigger : '#<portlet:namespace />fromDate',
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
																		.getElementById("<portlet:namespace />toDate").value);
												toDatePicker.getCalendar().set(
														'minimumDate',
														event.newSelection[0]);
												if (A.Date.isGreater(
														event.newSelection[0],
														oldToValue)) {
													document
															.getElementById("<portlet:namespace />toDate").value = A.Date
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
							trigger : '#<portlet:namespace />toDate',
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