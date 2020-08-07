<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL var="getSkillSet">
   <portlet:param name="<%=Constants.CMD%>" value="getSkillSets" />
</portlet:resourceURL>

<%
	List<JobOpening> jobOpening = new ArrayList<>();
	DynamicQuery membrQuery = JobOpeningLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("status", 1);
	membrQuery.add(criterion);
	jobOpening = JobOpeningLocalServiceUtil.dynamicQuery(membrQuery);
%>

<portlet:actionURL name="addApplyCandidate" var="addApplyCandidateURL" />

<aui:form name="addApplyCandidate" action="<%=addApplyCandidateURL.toString() %>"  method="post">
	<aui:row>
		<aui:col span="6">
			<aui:input type="text" name="firstName" placeholder="" value="" label="First Name">
					               
					 <aui:validator name="required"></aui:validator> 
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
                             $("#<portlet:namespace />firstName").val(val);
                          return result;
                            }
                </aui:validator>
					</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input type="text" name="lastName" placeholder="" value=""
					               label="Last Name"  >
					 <aui:validator name="required"></aui:validator> 
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
                             $("#<portlet:namespace />lastName").val(val);
                          return result;
                            }
                </aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input type="text" name="email"  placeholder="" value=""
					               label="Email Address" >
					 <aui:validator name="email"></aui:validator> 
					 
			</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input type="text" name="phoneNo"  placeholder="" value=""
					               label="Phone Number" >
					  
					 <aui:validator name="required"></aui:validator> 
					 <aui:validator name="maxLength">10</aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	<hr>
	<aui:row>
		<aui:col span="6">
			<aui:select name="jobOpeningId" label="Appling For" value="" >
				<%
					for(JobOpening jobOpeningObj:jobOpening){
				%>
					<aui:option value="<%=jobOpeningObj.getJobOpeningId()%>" ><%=jobOpeningObj.getOpeningFor()%></aui:option>
				<%
					}
				%>
			</aui:select>
		</aui:col>
		
		<aui:col span="6">
			<aui:input type="text" name="skillSet" id="skillset" placeholder="skillset" value=""
					             label="Skill Set" ></aui:input>
		</aui:col>
	
	</aui:row>
	<hr>
	<aui:row>
		<aui:col span="3">
			<h5 align="left">Relevant experience:</h5>
		</aui:col>
		<aui:col span="3" >
			<aui:input type="text" name="years"  placeholder="" value=""
					               label="Years" >
					 <aui:validator name="digits"></aui:validator> 
					 
			</aui:input>
		
		</aui:col>
		<aui:col span="3">
			<aui:input type="text" name="months"  placeholder="" value=""
					               label="Months" >
					 <aui:validator name="digits"></aui:validator> 
					 <aui:validator name="max">11</aui:validator>
					 
			</aui:input>
		</aui:col>
	</aui:row>
	<hr>
	<aui:row>
		<aui:col span="6">
			<aui:input type="text" name="currentctc"  placeholder="" value="" label="Current CTC">
			<aui:validator name="digits"></aui:validator>
		</aui:input>
		</aui:col>
		<aui:col span="6">
		<aui:input type="text" name="expectedctc" placeholder="" value="" label="Expected CTC">
			<aui:validator name="digits"></aui:validator>
		</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input type="text" name="currentCompany" placeholder="" value="" label="Current Company">
			</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input type="text" name="noticePeriod" placeholder="" value="" label="Notice period">
			<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	<hr >
	<%-- <aui:row>
		<h3 align="center" >Any Reference</h3>
		<aui:col span="6">
			<aui:input name="employeeName" type="text" placeholder="" value="" label="Employee Name">
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
                             $("#<portlet:namespace />employeeName").val(val);
                          return result;
                            }
                </aui:validator>
			</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input name="employeeCode" type="text" placeholder="" value="" label="Employee Code">
				<aui:validator name="digits"></aui:validator> 
			</aui:input>
			<aui:validator name="digits"></aui:validator>
		</aui:col>
		
	</aui:row> --%>
	<aui:row>
	<aui:col span="4">
	<aui:input id="file" type="file" name="uploadCv"
			value="" label="Upload Your CV" >
	</aui:input>
	<label>only .doc, .pdf files are accepted</label>
	</aui:col>
	</aui:row></br><hr>
	<aui:row>
	<aui:col span="6">
		<aui:button type="submit" name="save" value="Apply" id="save"></aui:button>&nbsp&nbsp
		<aui:button type="reset" id="resetBtn" cssClass="btn btn-danger" name="button" value="Reset" onClick="resetBtn()"></aui:button>
	</aui:col>
	</aui:row>
</aui:form>

<script>
$("#<portlet:namespace />save")
.click(
		function(e) {
			var inpFielVal = $("#<portlet:namespace />file").val();
			var finalFileName = inpFielVal.replace(/^.*\\/, "");
			console.log("after replacing	-------------> "
					+ finalFileName);
			var fileSplit = new Array();
			var fileSplit = finalFileName.split(".");
			console.log("after Spliting	-------------> "
					+ fileSplit[1]);
			if(fileSplit[1]!=null){
			switch (fileSplit[1]) {
			case 'pdf':
			case 'doc':
				//console.log("Excel file submitted Succesfully");
				break;
			default:
				alert('Please upload file having extensions .pdf / .doc');
				return false;
			}
			}else{
				alert('Please select a file ! ');
				return false;
			}
			
		});
		
		
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


</script>
<script type="text/javascript">
function resetBtn() {
	$("#resetBtn").html('Save');
	$('button').removeClass('disabled');
	}
</script>