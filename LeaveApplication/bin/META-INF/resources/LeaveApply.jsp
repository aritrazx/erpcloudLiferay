<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveDoc"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.famocom.erpcloud.leaveapplication.model.LeaveTypeDetails"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/view.jsp");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");

	PortletURL leaveDocDeleteURL = renderResponse.createActionURL();
	leaveDocDeleteURL.setParameter("javax.portlet.action", "leaveDocDelete");

	LeaveTypeDetails leaveType = (LeaveTypeDetails) renderRequest.getAttribute("leaveType");
	long leaveTypeId = ParamUtil.getLong(request, "leaveTypeId");
	long leaveApplyId = ParamUtil.getLong(request, "leaveApplyId");
	LeaveType leaveTypes = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
	String msg = "you must apply " + leaveTypes.getNoticeDay() + " days before leave date";
	LeaveApply leaveApply = null;
	if (leaveApplyId != 0) {
		//editURL = true;
		try {
			leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplyId);
		} catch (Exception e) {

		}
	}
%>
<liferay-ui:header title="Apply Leave" backLabel="Back"
	backURL="<%=backURL.toString()%>"></liferay-ui:header>
<liferay-ui:error key="error"
	message="Start Date should be less than End Date! " />

<liferay-ui:error key="error1"
	message="It may be Sat or Sun Day or HoliDay !" />
<liferay-ui:error key="error2"
	message="Your Request doesn't accept Because you were requesting more than !" />
<liferay-ui:error key="noticeDaysError" message='<%=msg%>' />
<liferay-ui:error key="duplicateDay"
	message="You have Already Applied leave on this day!" />
<liferay-ui:panel title="Balance Summary" collapsible="false">
	<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12 summary-item">
			<label> Opening Balance :<%=leaveType.getOpeningBal()%></label>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12 summary-item">
			<label> Credited/Entitled Balance : <%=leaveType.getMaxCreditDay()%></label>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12 summary-item">
			<label>Taken/Applied : <%=leaveType.getTakenApplied()%></label>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12 summary-item">
			<label> Closing Balance: <%=leaveType.getClosingBal()%></label>
		</div>
	</div>
</liferay-ui:panel>
<%
	LeaveApply leaveApplication = (LeaveApply) renderRequest.getAttribute("leaveApplication");
	boolean isEdit = false;
	try {
		if (renderRequest.getAttribute("isEdit").toString().equals("true")) {
			isEdit = true;
		}
	} catch (Exception e) {

	}
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println(":::isEdit::" + isEdit);
%>
<portlet:actionURL name="newLeaveApplication"
	var="newLeaveApplicationURL" />
<portlet:actionURL name="editLeaveApplication"
	var="editLeaveApplicationURL" />
<liferay-ui:panel title="Application Form" collapsible="false">
	<aui:form name="leaveApplication"
		action="<%=isEdit != true ? newLeaveApplicationURL.toString() : editLeaveApplicationURL.toString()%>"
		method="post" enctype="multipart/form-data">
		<div class="col-sm-12">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<aui:input type="text" name="fromDate" id="fromDate" readonly="true"
					value="<%=leaveApply != null ? dateFormat.format(leaveApply.getFromDate()) : ""%>"
					placeholder="Start Date" label="Start Date">
					<aui:validator name="required" />
				</aui:input>

				<aui:input type="hidden" name="leaveTypeId"
					value="<%=leaveType.getLeaveTypeId()%>" />
				<%
					if (leaveApplication != null && leaveApplication.getLeaveApplyId() > 0) {
				%>
				<aui:input type="hidden" name="leaveApplyId"
					value="<%=leaveApplication.getLeaveApplyId()%>" />
				<%
					}
				%>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<aui:select id="fromDateSession" name="fromDateSession"
					label="From Date Session">
					<%
						if (leaveApply != null) {
					%>
					<option value="0"
						<%=leaveApply.getFromDateSession().equalsIgnoreCase("0") ? "selected" : ""%>>Full
						Day</option>
					<option value="1"
						<%=leaveApply.getFromDateSession().equalsIgnoreCase("1") ? "selected" : ""%>>First
						Session</option>
					<option value="2"
						<%=leaveApply.getFromDateSession().equalsIgnoreCase("2") ? "selected" : ""%>>Second
						Session</option>
					<%
						} else {
					%>
					<option value="0">Full Day</option>
					<option value="1">First Session</option>
					<option value="2">Second Session</option>

					<%
						}
					%>
				</aui:select>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<aui:input type="text" name="toDate" id="toDate" readonly="true"
					required="required"
					value="<%=leaveApply != null ? dateFormat.format(leaveApply.getToDate()) : ""%>"
					placeholder="End Date" label="End Date">
					<aui:validator name="required" />
				</aui:input>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<aui:select id="toDateSession" name="toDateSession"
					label="To Date Session">
					<%
						if (leaveApply != null) {
					%>
					<option value="0"
						<%=leaveApply.getToDateSession().equalsIgnoreCase("0") ? "selected" : ""%>>Full
						Day</option>
					<option value="1"
						<%=leaveApply.getToDateSession().equalsIgnoreCase("1") ? "selected" : ""%>>First
						Session</option>

					<%
						} else {
					%>
					<option value="0">Full Day</option>
					<option value="1">First Session</option>

					<%
						}
					%>
				</aui:select>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<aui:input name="reason" type="textarea"
					value="<%=leaveApply != null ? leaveApply.getReason() : ""%>"
					row="5" placeholder="Reason" label="Reason" />
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12" id="auto-fields-container">
				<div class="lfr-form-row lfr-form-row-inline">
					<aui:input type="file" cssClass="uploadFile" label="" value=""
						name="uploadedFiles1" onClick="javascript:validate(value);" />
				</div>
			</div>
		</div>
		<%-- <div class="lfr-dynamic-uploader">
			<div class="lfr-upload-container"
				id="<portlet:namespace />fileUpload"></div>
		</div> --%>
		<%
			if (leaveApply != null) {
		%>
		<aui:col span="4">
			<%
				if (leaveApply.getStatus() == 2) {
			%>
			<p>
				HR Comments: <b style="color: #f48120;"><%=leaveApply.getHrComments()%></b>
			</p>
			<%
				}
			%>
		</aui:col>
		<%
			}
		%>
		<aui:row>
			<aui:col span="4">
			</aui:col>
			<aui:col span="8">
				<%
					List<LeaveDoc> leaveDocs = LeaveDocLocalServiceUtil.getDocsByLeaveApplyId(leaveApplyId);
									if (leaveDocs.size() > 0) {
										//System.out.println(":::::: If StatisFy :::::::");
				%>

				<liferay-ui:search-container delta="5"
					emptyResultsMessage="No record found." orderByCol=""
					iteratorURL="<%=iteratorUrl%>" orderByType="">
					<liferay-ui:search-container-results>
						<%
							results = leaveDocs;
														total = results.size();
														searchContainer.setTotal(results.size());
														pageContext.setAttribute("results", results.subList(searchContainer.getStart(),
																searchContainer.getResultEnd()));
														pageContext.setAttribute("total", results.size());
														pageContext.setAttribute("delta", results.size());
						%>
					</liferay-ui:search-container-results>

					<liferay-ui:search-container-row
						className="com.liferay.famocom.erpcloud.model.LeaveDoc"
						modelVar="var">
						<liferay-ui:search-container-column-text name="File">
							<%
								FileEntry fileEntry = DLAppServiceUtil.getFileEntry(var.getFileEntryId());
																String filePath = DLUtil.getPreviewURL(fileEntry,
																		fileEntry.getFileVersion(), themeDisplay, "");
							%>
							<liferay-ui:icon
								iconCssClass="<%=DLUtil.getFileIconCssClass(fileEntry.getExtension())%>"
								label="<%=true%>" url='<%=filePath%>' icon="pdf"
								message="<%=fileEntry.getTitle()%>" target="_blank" />
							<br>
						</liferay-ui:search-container-column-text>
						<%
							leaveDocDeleteURL.setParameter("leaveDocId",
																String.valueOf(var.getLeaveDocId()));
														leaveDocDeleteURL.setParameter("leaveApplyId", String.valueOf(leaveApplyId));
														leaveDocDeleteURL.setParameter("leaveTypeId", String.valueOf(leaveTypeId));
						%>
						<liferay-ui:search-container-column-text name="" orderable="true"
							orderableProperty="leaveDocId">
							<a href="<%=leaveDocDeleteURL.toString()%>">Delete</a>
						</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator></liferay-ui:search-iterator>
				</liferay-ui:search-container>

				<%
					}
				%>
			</aui:col>
		</aui:row>
		<div class="col-sm-12">
			<div class="col-sm-12">
				<aui:button name="saveButton" type="submit" value="save"
					cssClass="btn btn-success" />
				<aui:button name="cancelButton" type="cancel" value="cancel"
					cssClass="btn btn-danger" />
			</div>
		</div>
	</aui:form>
</liferay-ui:panel>
<script>
	AUI().use('aui-datepicker', function(A) {
		var datepic = new A.DatePicker({
			trigger : '#<portlet:namespace/>textEDR',
			mask : '%d/%m/%Y',

			popover : {
				toolbars : {
					header : [ [ {
						icon : 'icon-trash',
						label : 'Clear',
						on : {
							click : function() {
								datepic.clearSelection();
							}
						}
					}, {
						icon : 'icon-globe',
						label : 'Today',
						on : {
							click : function() {
								datepic.clearSelection();
								datepic.selectDates(new Date());
							}
						}
					} ] ]
				},
				zIndex : 1000
			},

			nullableDay : true,
			nullableMonth : true,
			nullableYear : false,

			calendar : {
				maximumDate : new Date()
			}
		});
	});
</script>
<aui:script use="liferay-auto-fields">
	new Liferay.AutoFields({
		contentBox : '#auto-fields-container',
		fieldIndexes : '<portlet:namespace />rowIndexes',
		on : {
			'clone' : function(event) {
				console.log('clone');
				console.log(event);
				var no = $('#<portlet:namespace />fileIdValue').val();
				var previousFileId = 'uploadedFiles' + no;
				no++;
				var latestfileId = 'uploadedFiles' + no;
				$('#<portlet:namespace />' + latestfileId).val('');
				//alert($('#<portlet:namespace />' + latestfileId).val(''));
				$('#<portlet:namespace />fileIdValue').val(no++);
			},
			'delete' : function(event) {
				console.log('delete');
				console.log(event);
			}
		},
		sortable : true,
		sortableHandle : '.lfr-form-row'
	}).render();
</aui:script>
	







<script>
	document.getElementById("<portlet:namespace/>files").onchange = function() {
		var reader = new FileReader();

		reader.onload = function(e) {

			document.getElementById("document").src = e.target.result;
		};

		reader.readAsDataURL(this.files[0]);
	};
</script>
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