
<%@ include file="init.jsp" %>
<%
	Long userId=themeDisplay.getUserId();
	Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
	long empId=employee.getEmployeeId(); 
	
	
	List<Employee> employeeList=EmployeeLocalServiceUtil.getEmployees(-1, -1);
	List<String> errorList=new ArrayList<>();
	FileEntry fileEntry=null;
	String fileName="";
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	PortletURL cadidateAddURL = renderResponse.createActionURL();
	cadidateAddURL.setParameter("javax.portlet.action", "candidateAdd");
	
	PortletURL cadidateEditURL = renderResponse.createActionURL();
	cadidateEditURL.setParameter("javax.portlet.action", "cadidateEdit");
	
	RecruitProcess recruitProcess=null;
	boolean EditURL=false;
    
    long recruitProcessId=ParamUtil.getLong(request, "recruitProcessId");
    
    System.out.println("recruitProcessId ...."+recruitProcessId);
	if(recruitProcessId!=0){
		EditURL=true;
		try{
			recruitProcess=RecruitProcessLocalServiceUtil.getRecruitProcess(recruitProcessId);
			fileEntry=DLAppLocalServiceUtil.getFileEntry(recruitProcess.getFileEntryId());
			fileName=fileEntry.getFileName();
			/* if (recruitProcess != null) {
		    	System.out.println("EMP:-yyyyyyyy"+recruitProcess.getDOB());
		    	DOB = sdf.format(recruitProcess.getDOB());
		    } */
			System.out.println("recruitProcess...."+recruitProcess);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	 String DOB = "";
   // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    if (recruitProcess != null) {
    	System.out.println("EMP:-yyyyyyyy");
    	DOB = sdf.format(recruitProcess.getDOB());
    } 
	   
	    
    
	
	
	
	
%>
<portlet:renderURL var="checkDuplicate" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/checkDuplicate.jsp" />
</portlet:renderURL>
  <portlet:resourceURL var="getSkillSet">
            <portlet:param name="<%=Constants.CMD%>" value="getSkillSets" />
</portlet:resourceURL>  
<portlet:renderURL var="checkDuplicateEmailId" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/checkDuplicateEmail.jsp" />
</portlet:renderURL>
<div>
      <div id="errDiv" <%if (errorList != null) {%>>
    <table>
        <%
            for (int i = 0; i < errorList.size(); i++) {
        %>
        <tr>
            <td><h4 style="color: red;"><%=errorList.get(i)%></h4></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    </div> 
    
	<aui:form name="candidateAddEdit" action="<%=(EditURL)? cadidateEditURL.toString() : cadidateAddURL.toString() %>" enctype="multipart/form-data" method="post">
	    <aui:input name="userId" type="hidden" value="<%=userId%>" />
	    <aui:input name="recruitProcessId" type="hidden" value="<%=recruitProcessId%>" />
	     <aui:input name="empId" type="hidden" value="<%=empId%>" />
	       <aui:input name="status" type="hidden" value="" />
	       
		<aui:row>
			<aui:row>
				<aui:col span="4">
					<aui:input type="text" name="firstName" id="firstNameId" placeholder="first Name" value="<%=(recruitProcess!=null)? recruitProcess.getFirstName():"" %>"
					               label="First name" >
					               
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
				<%-- <aui:col span="4">
					<aui:input type="text" name="middleName" id="exp_cat_name" placeholder="Title" value=""
					               label="Middle Name" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col> --%>
				<aui:col span="4">
				<aui:input type="text" name="lastName" id="lastNameId" placeholder="last Name" value="<%=(recruitProcess!=null)? recruitProcess.getLastName():"" %>"
					               label="Last Name"  >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>	
				<div id="msgCode" style="display: none;"></div>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<aui:input type="text" name="DOB" id="textDOB" placeholder="Date of Birth" value="<%=(recruitProcess!=null)? DOB:"" %>"
					               label="Date of Birth" onChange="javascript:checkDuplicate(this.value);" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
				<aui:col span="6">
				 <aui:input type="text" name="email" id="E-mailid" placeholder="Email" value="<%=(recruitProcess!=null)? recruitProcess.getEmail():"" %>"
					               label="E-mail" onChange="javascript:checkDuplicateEmail(this.value);" >
					 <aui:validator name="required"></aui:validator> 
					 
					</aui:input>
					<div id="msgCode1" style="display: none;"></div>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
				    
					<aui:input type="text" name="phoneno" id="phonenoid" placeholder="Phone number" value="<%=(recruitProcess!=null)? recruitProcess.getPhoneNumber():"" %>"
					               label="Phone No." >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" name="skillset" id="skillset" placeholder="Skill Set" value="<%=(recruitProcess!=null)? recruitProcess.getSkillset():"" %>"
					               label="Skill Set" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
				    
					<aui:input type="text" name="experience" id="experience_id" placeholder="experience" value="<%=(recruitProcess!=null)? recruitProcess.getExperience():"" %>"
					               label="Experience" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" name="currentctc" id="currentCTCid" placeholder="Current CTC" value="<%=(recruitProcess!=null)? recruitProcess.getCurrentCTC():"" %>"
					               label="Current CTC" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
				    
					<aui:input type="text" name="noticePeriod" id="" placeholder="Notice Period" value="<%=(recruitProcess!=null)? recruitProcess.getNoticePeriod():"" %>"
					               label="Notice period" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" name="expectedctc" id="" placeholder="Expected CTC" value="<%=(recruitProcess!=null)? recruitProcess.getExpextedCTC():"" %>"
					               label="Expected CTC" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
			</aui:row>
		 		<aui:col span="6">
		 		    <aui:select name="reference" label="Reference" id="reference">
		 		    	 <option value="" selected>None</option>
						<%
						for(Employee emp: employeeList){
							if(recruitProcess!=null){
								
							
						%>
						<aui:option value="<%=emp.getEmployeeId() %>" selected="<%=emp.getEmployeeId()==recruitProcess.getReference() %>"><%=emp.getFirstName()+" "+emp.getLastName() %></aui:option>
						<%
							}else{
						%>
						<aui:option value="<%=emp.getEmployeeId()%>"><%=emp.getFirstName()+" "+emp.getLastName() %></aui:option>
						
						<%
							}
						}
						%>
		 		    </aui:select>
		 		</aui:col> 
		    <aui:row> 
				<aui:col span="8"> 
				  
				    <liferay-ui:panel-container extended="true" id="outerPanelContainer">
				        <liferay-ui:panel collapsible="true" defaultState="collapsed"  title="Upload resume" >
				       
				           <div class="row">
                                  <div class="col-md-4">
				                      <input type="file" name="uploadedFile" value="<%=(recruitProcess!=null)? fileName:"" %>"/>
				                   </div>
				                   <div class="col-md-4">
				                <aui:input type="text" name="proofName" id="exp_cat_name" placeholder="Document name" value=""
					               label="Document name" />
					               </div>
					              <!--  <div class="col-md-2">
					               		<button class="plus-icon-custom " id="add-row-file" title= "Add another file" type="button" />
					               </div>
					               <div class="col-md-2">
					               		<button class="minus-icon-custom " id="delete-row-file" title="Delete"  type="button" style="display:none;"></button>
					               </div> -->
					       </div>
				       
				    </liferay-ui:panel>
				</liferay-ui:panel-container> 
				
				 </aui:col>
				<aui:col span="4">
					<aui:button type="submit" id="save" name="save"></aui:button>
					<button class="btn btn-danger" type="button" name="reset">Cancel</button>
				</aui:col>
			 </aui:row> 
		</aui:row>
			
	</aui:form>
</div>
 <script>
	AUI().use('aui-datepicker', function(A) {
		var dfg=new A.DatePicker({
			trigger : '#<portlet:namespace/>textDOB',
			mask : '%d/%m/%Y',
			
			popover : {
				
			zIndex : 1000
			},
			
			nullableDay: true,
			nullableMonth: true,
			nullableYear: true,

			
			calendar: {
		      
		   }
		});
	});
</script> 

  <aui:script>
	AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
		var testData;
		
		new A.AutoCompleteList({
			
			allowBrowserAutocomplete: 'true',
			activateFirstItem: 'true',
			inputNode: '#<portlet:namespace />skillset',
			resultTextLocator:'skillname',
			render: 'true',
			resultHighlighter: 'phraseMatch',
			resultFilters:['phraseMatch'],
			queryDelimiter : ',',
	        typeAhead: true,
			source:function(){
			var inputValue=A.one("#<portlet:namespace />skillset").get('value');
			var myAjaxRequest=A.io.request('<%=getSkillSet.toString()%>',{
			dataType: 'json',
			method:'GET',
			data:{
			<portlet:namespace />skillset:inputValue,
			},
			autoLoad:false,
			sync:false,
			on: {
			success:function(responseData){
			var data=this.get('responseData');
			testData=data;
			//alert('testData'+data);
			}}
			});
			myAjaxRequest.start();
			return testData;},
		});
	});
</aui:script> 
 
 <script>
function getFirstName(){
	
	var fName=$('#<portlet:namespace/>firstNameId').val();
	alert('fName'+fName);
	return fName;
}

function getLastName(){
	
	var lName=$('#<portlet:namespace/>lastNameId').val();
	alert('fName'+lName);
	return lName;
}
function checkDuplicate(t){
	alert("call");
	var url = '<%=checkDuplicate.toString()%>';
			var val = t;
			alert("call" + t);
			var fName = getFirstName();
			var fName = getLastName();
			alert('fName' + fName);
			//alert(val);
			jQuery.ajax({
				url : url,
				data : {
					'<portlet:namespace/>textvalue' : val,
					'<portlet:namespace/>textvalue1' : fName,
					'<portlet:namespace/>textvalue2' : lName
				},
				success : function(result) {
					//alert("success");
					jQuery('#msgCode').html(result);
					jQuery('#msgCode').show();
				},
				error : function() {
					jQuery('#msgCode').html('No Result Found');
				},
				type : 'POST'
			});
		}
	</script>
<script>
function checkDuplicateEmail(t){
	alert("call");
	var url = '<%=checkDuplicateEmailId.toString()%>';
		var val = t;
		alert("call" + t);
		//alert(val);
		jQuery.ajax({
			url : url,
			data : {
				'<portlet:namespace/>textval' : val,

			},
			success : function(result) {
				//alert("success");
				jQuery('#msgCode1').html(result);
				jQuery('#msgCode1').show();
			},
			error : function() {
				jQuery('#msgCode1').html('No Result Found');
			},
			type : 'POST'
		});
	}
</script> 
