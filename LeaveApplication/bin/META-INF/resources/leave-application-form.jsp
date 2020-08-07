<%

LeaveApply leaveApplication = (LeaveApply) renderRequest.getAttribute("leaveApplication");
boolean isEdit=false;
System.out.println("*********************************************"+isEdit);
try{
	if(renderRequest.getAttribute("isEdit")!=null && Boolean.parseBoolean(renderRequest.getAttribute("isEdit").toString())){
		isEdit=true;
	}
}catch(Exception e){
}
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
System.out.println("*********************************************"+isEdit);
%>
<portlet:actionURL name="newLeaveApplication" var="newLeaveApplicationURL" />
<portlet:actionURL name="editLeaveApplication" var="editLeaveApplicationURL" />
<liferay-ui:error key="error" message="Start Date should be less than End Date! " />

<liferay-ui:error key="error1"
	message="It may be Sat or Sun Day or HoliDay !" />
<liferay-ui:error key="error2"
	message="Your Request doesn't accept Because you were requesting more than !" />
<liferay-ui:error key="noticeDaysError" message="Error" />
<liferay-ui:error key="duplicateDay"
	message="You have Already Applied leave on this day!" />
<%

System.out.println("*********************************************"+isEdit);
%>
<liferay-ui:panel title="<%=leaveType.getLeaveName()%> Application Form" collapsible="false">
<aui:form name="leaveApplication" action="<%=isEdit ? newLeaveApplicationURL.toString() : editLeaveApplicationURL.toString()%>"	method="post">
	<aui:row>
		<aui:col span="3">
			<aui:input type="text" name="fromDate" id="fromDate" readonly="true" value="<%=leaveApplication != null ? dateFormat.format(leaveApplication.getFromDate()) : ""%>"
				placeholder="Start Date" label="Start Date">
				<aui:validator name="required" />
			</aui:input>

			<aui:input type="hidden" name="leaveTypeId" value="<%=leaveType.getLeaveTypeId()%>" />
			<aui:input type="hidden" name="leaveApplyId" value="<%=leaveApplication != null ? leaveApplication.getLeaveApplyId() : ""%>" />
		</aui:col>
		<aui:col span="2">
			<aui:select id="fromDateSession" name="fromDateSession" label="From Date Session">
				<option value="0" <%=(isEdit &&  leaveApplication.getFromDateSession().equalsIgnoreCase("0")) ? "selected" : ""%>>Full Day</option>
				<option value="1" <%=(isEdit && leaveApplication.getFromDateSession().equalsIgnoreCase("1")) ? "selected" : ""%>>First Session</option>
				<option value="2" <%=(isEdit && leaveApplication.getFromDateSession().equalsIgnoreCase("2")) ? "selected" : ""%>>Second Session</option>
			</aui:select>
		</aui:col>
		<aui:col span="3">
			<aui:input type="text" name="toDate" id="toDate" readonly="true" required="required"
				value="<%=leaveApplication != null ? dateFormat.format(leaveApplication.getToDate()) : ""%>" placeholder="End Date" label="End Date">
				<aui:validator name="required" />
			</aui:input>
		</aui:col>
		<aui:col span="2">
			<aui:select id="toDateSession" name="toDateSession" label="To Date Session">
				<option value="0" <%=(isEdit &&  leaveApplication.getToDateSession().equalsIgnoreCase("0")) ? "selected" : ""%>>Full Day</option>
				<option value="1" <%=(isEdit &&  leaveApplication.getToDateSession().equalsIgnoreCase("1")) ? "selected" : ""%>>First Session</option>
			</aui:select>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="4">
			<aui:input name="reason" type="textarea" value="<%=isEdit? leaveApplication.getReason() : ""%>" placeholder="Reason" label="" />
		</aui:col>
	</aui:row>

	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="save"
			cssClass="btn btn-success" />
	</aui:button-row>
</aui:form>
</liferay-ui:panel>