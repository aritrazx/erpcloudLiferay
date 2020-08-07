<%@include file="init.jsp"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<aui:row>
	<aui:col span="6">
		<aui:input type="text" name="panNo" label="PAN No"
			value="<%=clientMaster != null ? clientMaster.getPanNo() : ""%>">
			<aui:validator name="custom"
				errorMessage="Please Enter a valid input">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^0-9|^A-Z|]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />panNo").val(val);
                                     return result;
                                       }
                           </aui:validator>
		</aui:input>

		<aui:input type="text" name="branchName" label="Branch Name"
			value="<%=clientMaster != null ? clientMaster.getBranchName() : ""%>">
			<aui:validator name="custom"
				errorMessage="Only Alphabets are allowed">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^a-z|^A-Z|^\s]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />branchName").val(val);
                                     return result;
                                       }
                           </aui:validator>
		</aui:input>
		<aui:select name="bankAccountType" label="Bank Account type">
			<aui:option
				value="<%=clientMaster != null ? clientMaster.getBankAccountType() : "Saving"%>">Saving</aui:option>
			<aui:option
				value="<%=clientMaster != null ? clientMaster.getBankAccountType() : "Current"%>">Current</aui:option>
		</aui:select>
	</aui:col>
	<aui:col span="6">
		<aui:input type="text" name="bankName" label="Bank Name"
			value="<%=clientMaster != null ? clientMaster.getBankName() : ""%>">
			<aui:validator name="custom"
				errorMessage="Only Alphabets are allowed">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^a-z|^A-Z|^\s]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />bankName").val(val);
                                     return result;
                                       }
                           </aui:validator>
		</aui:input>
		<aui:input type="text" name="bankAccountNumber"
			label="Bank Account No."
			value="<%=clientMaster != null ? clientMaster.getBankAccountNumber() : ""%>">
			<aui:validator name="digits"></aui:validator>
		</aui:input>
		<aui:input type="text" name="ifscCode" label="IFSC Code"
			value="<%=clientMaster != null ? clientMaster.getIfscCode() : ""%>">
			<aui:validator name="custom"
				errorMessage="Please Enter a valid input">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^0-9|^A-Z|]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />ifscCode").val(val);
                                     return result;
                                       }
                           </aui:validator>
		</aui:input>
	</aui:col>
</aui:row>