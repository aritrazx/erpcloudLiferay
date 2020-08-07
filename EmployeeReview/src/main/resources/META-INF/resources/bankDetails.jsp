<%@ include file="init.jsp" %>

<aui:row>
<aui:col span="12">
<aui:row>
	<aui:col span="6">
		<aui:input label="Bank Name" readonly="true"  name="bankName" value="${empDetails.bankName}"></aui:input>
	</aui:col>
	<aui:col span="6">
		<aui:input label="PAN" readonly="true" name="pan" value="${empDetails.panNo}">
		
		</aui:input>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
		<aui:input label="Account Number" readonly="true" name="accountNumber" value="${empDetails.accountNo}"></aui:input>
	</aui:col>
	<aui:col span="6">
		<aui:input label="PF Number" readonly="true" name="pfNumber" value="${empDetails.pfNo}"></aui:input>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
	<aui:input label="Aadhaar No" readonly="true" name="aadhaarNo" value="${empDetails.aadhaarNo}"></aui:input>
	</aui:col>
	<aui:col span="6">
	
	</aui:col>
</aui:row>
</aui:col>

</aui:row>