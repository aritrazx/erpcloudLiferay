<%@include file="init.jsp"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<aui:row>
		<aui:col span="6">
			<aui:input type="text" name="clientName" id="clientName"
				value="<%=clientMaster != null ? clientMaster.getClientName() : ""%>"
				placeholder="Name" label="Name" required="required">
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
                                        $("#<portlet:namespace />clientName").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
			<aui:input name="officeAddress" type="textarea"
				value="<%=clientMaster != null ? clientMaster.getOfficeAddress() : ""%>"
				placeholder="Office Address" label="Address(office)">
				
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
                                        $("#<portlet:namespace />officeAddress").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
			<aui:input type="text" name="gstNo" label="GST No" placeholder="123456789 RT 0001"
				value="<%=clientMaster != null ? clientMaster.getGstNo() : ""%>"></aui:input>
			<aui:input name="emailId" type="text"
				value="<%=clientMaster != null ? clientMaster.getEmailId() : ""%>"
				required="required" label="Email Id">
				<aui:validator name="email" />
			</aui:input>
			
		</aui:col>
		<aui:col span="6">
			<aui:input name="billingAddress" type="textarea"
				value="<%=clientMaster != null ? clientMaster.getBillingAddress() : ""%>"
				placeholder="Billing Address" label="Address(Billing)">
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
                                        $("#<portlet:namespace />billingAddress").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
			<aui:input type="text" name="contactNumber"
				value="<%=clientMaster != null ?clientMaster.getContactNumber():""%>">
				<aui:validator name="maxLength">10</aui:validator>
			</aui:input>
			<aui:input type="text" name="contactPerson"
				value="<%=clientMaster != null ?clientMaster.getContactPerson():""%>">
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
                                        $("#<portlet:namespace />contactPerson").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
		<aui:input name="skypeId" type="text"
				value="<%=clientMaster != null ? clientMaster.getSkypeId() : ""%>"
				required="required" label="Skype Id">
			</aui:input>
		</aui:col>
	</aui:row>