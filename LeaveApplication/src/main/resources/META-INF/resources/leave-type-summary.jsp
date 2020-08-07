
<%
	LeaveTypeDetails leaveType = (LeaveTypeDetails) renderRequest.getAttribute("leaveType");
%>

<liferay-ui:panel title="<%=leaveType.getLeaveName()%>"
	collapsible="false">
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