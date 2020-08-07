<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMasterMapping"%>
<%@page import="com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TaskMaster"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectStatus"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	boolean editURL = false;
	String projectName = ParamUtil.getString(renderRequest, "projectName", StringPool.BLANK);
	String projectClient = ParamUtil.getString(renderRequest, "clientName", StringPool.BLANK);
	String projectStatus = ParamUtil.getString(renderRequest, "selectStatus", StringPool.BLANK);
	String selectTask = ParamUtil.getString(renderRequest, "selectTask", StringPool.BLANK);
	System.out.println("selectTask....." + selectTask);
	String val = ParamUtil.getString(request, "search", StringPool.BLANK);
	System.out.println("val....." + val);
	List<ProjectMaster> projMastList = new ArrayList<ProjectMaster>();
	projMastList = ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
	//System.out.println("list....."+projMastList);
	List<ProjectMaster> pmList = new ArrayList<ProjectMaster>();
	List<ProjectMaster> projList = new ArrayList<ProjectMaster>();
	long projectId = ParamUtil.getLong(request, "projectId");
	//System.out.println("primary key###....."+project_status_id);
	String alreadyChecked = "";
	ProjectMaster pm = null;
	if (projectId != 0) {
		editURL = true;
		try {
			pm = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	List<TaskMaster> taskList = TaskMasterLocalServiceUtil.getTaskMasters(-1, -1);
	DynamicQuery dynamicQuery = TaskMasterLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("status", 1);
	dynamicQuery.add(criterion);
	taskList = TaskMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
	List<TaskMaster> taskList1 = new ArrayList<>();
	List<TaskMasterMapping> taskMapList = new ArrayList<>();
	List<TaskMasterMapping> taskMapList1 = new ArrayList<>();
	TaskMasterMapping tmm1 = null;
	if(projectId!=0){
		DynamicQuery dynamicQuery1 = TaskMasterMappingLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
		dynamicQuery1.add(criterion3);
		taskMapList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery1);
		taskMapList1.addAll(taskMapList);
		}
	for(int i=0;i<taskMapList1.size();i++){
		tmm1 = TaskMasterMappingLocalServiceUtil.getTaskMasterMapping(taskMapList1.get(i).getTaskMappingId());
	}
	/* if(projectId!=0){
	DynamicQuery dynamicQuery1 = TaskMasterMappingLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
	criterion3 = RestrictionsFactoryUtil.and(criterion3,
	RestrictionsFactoryUtil.eq("taskId", taskId));
	dynamicQuery1.add(criterion3);
	taskMapList = TaskMasterLocalServiceUtil.dynamicQuery(dynamicQuery1);
	taskMapList1.addAll(taskMapList);
	}
	for(int i=0;i<taskMapList1.size();i++){
		DynamicQuery dynamicQuery1 = TaskMasterLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("taskId", taskMapList1.get(i).getTaskId());
		 criterion3 = RestrictionsFactoryUtil.and(criterion3,
		RestrictionsFactoryUtil.eq("taskId", taskId));
		dynamicQuery1.add(criterion3);
		taskList = TaskMasterLocalServiceUtil.dynamicQuery(dynamicQuery1);
		taskList1.addAll(taskList);
	} */
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setWindowState(LiferayWindowState.NORMAL);
	viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<%
	Date defaultDate = new Date();
	Date startDate, endDate;
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
	startDate = defaultDate;

	endDate = defaultDate;
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Create Project" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>

<portlet:actionURL name="projectMaster" var="projectMasterURL" />
<portlet:actionURL name="updateProjectMaster"
	var="updateProjectMasterURL" />

<aui:form name="projectMaster"
	action="<%=editURL != true ? projectMasterURL.toString() : updateProjectMasterURL.toString()%>"
	method="post">
	<aui:input name="projectId" type="hidden" value="<%=projectId%>"></aui:input>
	<aui:row>
	<aui:col span="6">
	<aui:input name="projectName" type="text" label="Project Name"
		placeholder="Project Name"
		value="<%=pm != null ? pm.getProjectName() : ""%>">
		<aui:validator name="required"></aui:validator>
		<%-- <aui:validator name="alphanum"></aui:validator> --%>
		<aui:validator name="custom"            
                                 errorMessage="Only Alphanumeric allowed">
                                   function (val, fieldNode, ruleValue)
                                      {
                                          var result = true;
                                          var pattern=/[^a-z|^A-Z|^0-9|\s]/;
                                         var check = val.match(pattern);
                                         if(check!=null)
                                        {
                                           result=false;
                                         }
                                         val=$.trim(val);
                                        $("#<portlet:namespace />projectName").val(val);
                                     return result;
                                       }
                           </aui:validator>
	</aui:input>
	</aui:col>
	<aui:col span="6">
	<aui:select name="clientName" label="Client Name" required="true">
		<aui:option value="">Select Client</aui:option>
		<%
			try {
						List<ClientMaster> cmList = ClientMasterLocalServiceUtil.getClientMasters(-1, -1);
						for (ClientMaster obj : cmList) {
							if (pm != null) {
								if (obj.getClientId() == pm.getClientId()) {
		%>
		<option value="<%=obj.getClientId()%>" selected><%=obj.getClientName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getClientId()%>"><%=obj.getClientName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getClientId()%>"><%=obj.getClientName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>


	</aui:select>
	</aui:col>
	</aui:row>
	<aui:row>
	
	<aui:col span="6">
	<aui:input name="projectDescription" type="textarea"
		label="Project Description" placeholder="Project Description"
		value="<%=pm != null ? pm.getProjectDesc() : ""%>" />
	</aui:col>
	<aui:col span="6">
	<aui:select name="selectStatus" label="Select Status" required="true">
		<aui:option value="">Select Status</aui:option>
		<%
			try {
						List<ProjectStatus> statList = ProjectStatusLocalServiceUtil.getProjectStatuses(-1, -1);
						for (ProjectStatus obj : statList) {
							if (pm != null) {
								if (obj.getProjectStatusId() == pm.getProjectStatusId()) {
		%>
		<option value="<%=obj.getProjectStatusId()%>" selected><%=obj.getStatusName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getProjectStatusId()%>"><%=obj.getStatusName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getProjectStatusId()%>"><%=obj.getStatusName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>


	</aui:select>
	</aui:col>
	<%-- <aui:col span="4">
	
	
	<aui:select name="selectTask" label="Select Task" required="true" multiple="true" >
		<aui:option value="">Select Task</aui:option>
		<%
			try {
						List<TaskMaster> statList = TaskMasterLocalServiceUtil.getTaskMasters(-1, -1);
						for (TaskMaster obj : statList) {
							if (pm != null) {
								if (obj.getTaskId() == pm.getTaskId()) {
		%>
		<option value="<%=obj.getTaskId()%>" selected><%=obj.getTaskName()%></option>

		<%
			} else {
		%>
		<option value="<%=obj.getTaskId()%>"><%=obj.getTaskName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=obj.getTaskId()%>"><%=obj.getTaskName()%></option>
		<%
			}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>


	</aui:select>
	
	<%if(taskList.size()!=0){ 
		for(int i=0;i<taskList.size();i++){
	%>
	<aui:input name="selectTask" label="" value="" type="checkbox"><%=taskList.get(i).getTaskName() %></aui:input>
	<%}
		}%>
	
	</aui:col> --%>
	</aui:row>
	<aui:row>
	<aui:col span="4">
	
<%
String tempStartDate = null;
if(pm!=null){
Date addDate = pm.getStartDate();
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
tempStartDate = formatter.format(addDate);
}
%>
	
	<aui:input id="txtFromDate_id" name="startDate" type="text"
	label="Start Date" placeholder="Start Date" readonly="readonly" value="<%=pm!=null?tempStartDate : formatter1.format(startDate)%>">
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</aui:col>
	
	<aui:col span="4" id="endDateShown">
<%
String tempEndDate = null;
if(pm!=null){
Date eDate = pm.getEndDate();
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
tempEndDate = formatter.format(eDate);
}
%>
	<aui:input id="txtToDate_id" name="endDate" type="text"
	label="End Date" placeholder="End Date" readonly="readonly" value="<%=pm!=null? tempEndDate : formatter1.format(endDate)%>">
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</aui:col>
	
	<%-- <aui:col span="4">
	<aui:input name="totalAmount" type="text" label="Total Amount" placeholder="Total Amount" value="<%=pm != null ? pm.getTotalAmount() : ""%>">
	<aui:validator name="required"></aui:validator>
	<aui:validator name="number"></aui:validator>
	<aui:validator name="min">1</aui:validator>
	</aui:input>
	</aui:col> --%>
	</aui:row>
	<aui:row>
	<aui:col span="4"></aui:col>
	<aui:col span="4">
	<label>Choose Task:</label>
	</aui:col>
	<aui:col span="4"></aui:col>
	</aui:row>
	<br>
	<br>
	<aui:row>
	<%
	String tasks = StringPool.BLANK;
	if(taskList.size()!=0){ 
			for(TaskMaster obj : taskList){
				boolean isChecked = false;
				//tasks = obj.getTaskId()+","+ tasks;
				for(int i=0;i<taskMapList1.size();i++){
					if(obj.getTaskId()==taskMapList1.get(i).getTaskId()){
						isChecked = true;
					}
				}
	%>
	<aui:col span="1">
	<div class="col-md-1"> 
	<aui:input name="selectTask" id="selectTask" cssClass="selectTask" label="" checked="<%=isChecked %>" value="<%=obj!=null ? obj.getTaskId():"" %>" type="checkbox">
	<aui:validator name="required"></aui:validator>
	</aui:input>
	</div>
	<div class="col-md-1"> 
	<label><font size="4"><%=obj.getTaskName() %></label>
	</div>
	</aui:col>
	<aui:col span="1">
	</aui:col>
	<%
					
			}
		}%>
		<%
		if(taskMapList1.size()!=0){
			for(TaskMasterMapping tmm: taskMapList1){
				alreadyChecked = tmm.getTaskId()+","+alreadyChecked;
			}
		} 
		%>
		<input name="<portlet:namespace/>taskList" id="taskList" type="hidden" label="" value="<%=tmm1!=null?alreadyChecked:""%>"></input>
		<div id="customClass"></div>
	
	</aui:row>
	<aui:button  name="button" type="submit" value="submit"></aui:button>
	
	</br>
	</br>
</aui:form>

<script type="text/javascript">


$(".selectTask").each(function() { 

	
	
	$(this).click(function() {
		
    	//str1 =  str +","+ str1;
    	//$("#taskList").val(str1);
			var str= $("#taskList").val();
			var str1 = $(this).val();
			str1 =  str1 +","+ str;
		
		
		if($(this).is(':checked')) {
       		 
			//var checkboxVal= $(this).val();
			$("#taskList").val(str1);
			console.log('str--'+str);
			console.log('str1--'+str1);
       		 //console.log(checkboxVal);
       		 console.log('checked');
       	 }
       	        
       	    else {
       	    	str= $("#taskList").val();
       	    	str1 = $(this).val();
       	    	console.log('str--'+str);
    			console.log('str1--'+str1);
       	    	console.log('unchecked');
       	    	//var success = str.split(',')[1]
       	    	var success = str.replace(str1+",", '');
       	    	//str1 = "";
       	    	//str1.val("");
       	    	//$(this).val("");
       	    	//$("#str1").val("");
       	    	$("#taskList").val(success);
       	    	//$("#taskList").val("");
       	    }
		
		
	});
	
	    		
});


    // This function allows me to turn the end date on and off    // based on whether the user clicks the checkbox
    function toggleEndDate() {
        if (document.getElementById('endDateToggle').checked) {
            document.getElementById('endDateShown').style.display = 'none';
            document.getElementById('<portlet:namespace/>txtToDate_id').disabled = 
                "true";
        } else {
            document.getElementById('endDateShown').style.display = 'block';
            // for some reason you shouldn't set disabled to false, 
            // but to an empty string instead...
            document.getElementById('<portlet:namespace/>txtToDate_id').disabled = "";
        }
    }
    
   <%--  jQuery(function($){
        var str="";
        <%
        for(int i=0;i<taskList.size();i++){
        	
        	%>
        	str+="<label><font size='4'><%=taskList.get(i).getTaskName() %>:</label>"+" ";
        	str+=" "+"<input name='selectTask' id='selectTask' class='selectTask' label=''  onClick='checkTask(<%=taskList.get(i).getTaskId()%>)' value='<%=taskList.get(i).getTaskId() %>' type='checkbox'>"
          //  str+="<a href='#' onclick='test('"+elem[i].url+"')'>dd</a><br><br>"
            console.log(str);

    	<% } %>
        $('#customClass').html(str);

    });
     --%>
    
    
    
    function checkTask(str){
    	  	
    	
    	
        var str1 = $("#taskList").val();
    	str1 =  str +","+ str1;
    	$("#taskList").val(str1);
    	//alert("call");
    	//var selectTask = $('selectTask').val();
    	//alert(str);
    }
    
    /* function checkTask(str){
    	if ($('#selectTask').prop('checked')==true){ 
           alert('checked');
           var str1 = $("#taskList").val();
      		str1 =  str +","+ str1;
      	 	//alert("str1 "+str1);
      	 	$("#taskList").val(str1);
        }else{
        	 alert('unchecked');
        }
    	//alert("call");
    	//var selectTask = $('selectTask').val();
    	//alert(str);
    }  */
   /*  function checkTask(){
    // $('#selectTask').click(function(){
   	alert("call all");
    if(this.checked){
                $('#selectTask').each(function(){ 
               	alert("checked");
                   this.checked = true;
               });
           }else{
           	$('#selectTask').each(function(){
                   this.checked = false;
               });
           }

    } */
</script>

<!-- <script>
AUI().use('aui-datepicker', function(A) {
	var dfg = new A.DatePicker({
		trigger : '#<portlet:namespace />txtFromDate_id',
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
			trigger : '#<portlet:namespace />txtToDate_id',
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
    AUI().use(
        'aui-datepicker', 
        'datatype-date', 
        'datatype-date-math', 
        'datatype-date-parse',
        function(A) {
            var toDatePicker;
            var fromDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace />txtFromDate_id',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                },
                on: {
                    selectionChange: function(event) {
                        if (event.newSelection[0]) {
                            var oldToValue = A.Date.parse("%d-%m-%Y", 
                                document.getElementById(
                                    "<portlet:namespace />txtToDate_id").value);
                            toDatePicker.getCalendar().set('minimumDate', 
                                event.newSelection[0]);
                            if (A.Date.isGreater(event.newSelection[0], 
                                    oldToValue)) {
                                document.getElementById(
                                    "<portlet:namespace />txtToDate_id").value = 
                                    A.Date.format(event.newSelection[0], 
                                        {format: "%d-%m-%Y"});
                            }
                        }
                    }
                },
                calendar: {
                    minimumDate: new Date()
                }
            });

            toDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace />txtToDate_id',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                },
                calendar: {
                    minimumDate: new Date()
                }
            });
        }
    );
    
  </aui:script>
  