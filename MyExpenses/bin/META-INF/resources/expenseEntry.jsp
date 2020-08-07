<%@page import="com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpenseEntry"%>
<%@page import="com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpCategory"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpenseEntryHistory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/init.jsp" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
   //*  Long userId=themeDisplay.getUserId();
   // Employee employee = EmployeeManagementLocalServiceUtil.findByemployees(userId);
   // employee.getEmployeeId(); */
   
   List<ExpenseEntryHistory> expenseHistoryList = (List<ExpenseEntryHistory>)renderRequest.getAttribute("expenseHistoryList");
   if(Validator.isNotNull(expenseHistoryList)){
	   System.out.println("======== expenseHistoryList :-"+expenseHistoryList.toString());
   }
  	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
	renderRequest.setAttribute("iteratorUrl", iteratorUrl);
	
    long empId=1;
    List<AddTeamMember> empProjList=new ArrayList<>();
    List<ProjectMaster> projList=new ArrayList<>();
    List<ProjectMaster> tmpprojList=new ArrayList<>();
    List<String> projName=new ArrayList<>();
    List<ExpCategory> expCatList= new ArrayList<>();
    List<String> errorList = (List<String>) renderRequest.getAttribute("errorList");
    /* //AddTeamMemberLocalServiceUtil
	DynamicQuery empProjQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
    empProjQuery.add(PropertyFactoryUtil.forName("employeeId").eq(empId));
    empProjList = AddTeamMemberLocalServiceUtil.dynamicQuery(empProjQuery);
    System.out.println("empProjList"+empProjList);
    for(AddTeamMember atm:empProjList){
    	List<ProjectMaster> master =null;
    	System.out.println("projList"+atm.getProjectId());
	    DynamicQuery projQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
    	projQuery.add(PropertyFactoryUtil.forName("projectId").eq(atm.getProjectId()));
    	tmpprojList = ProjectMasterLocalServiceUtil.dynamicQuery(projQuery);
    	projList.addAll(tmpprojList);
    	
    } */
    projList=ProjectMasterLocalServiceUtil.getProjectMasters(-1, -1);
    System.out.println("projList"+projList);
    for(ProjectMaster pm: projList){
    	
    	projName.add(pm.getProjectName());
    }

    PortletURL myExpAddURL = renderResponse.createActionURL();
    myExpAddURL.setParameter("javax.portlet.action", "myExpAdd");
    
    PortletURL myExpEditURL = renderResponse.createActionURL();
    myExpEditURL.setParameter("javax.portlet.action", "myExpEdit");
    
   
    
    ExpenseEntry expenseEntry=null;
	boolean EditURL=false;
    
    long expenseId=ParamUtil.getLong(request, "expenseId");
    
   System.out.println("expenseId ...."+expenseId);
	if(expenseId!=0){
		EditURL=true;
		try{
			expenseEntry=ExpenseEntryLocalServiceUtil.getExpenseEntry(expenseId);
			System.out.println("expenseEntry...."+expenseEntry);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	 String joiningDate = "";
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    if (expenseEntry != null) {
	    	System.out.println("EMP:-yyyyyyyy");
	    	joiningDate = sdf.format(expenseEntry.getExpDate());
	    }

	expCatList=ExpCategoryLocalServiceUtil.getExpCategories(-1,-1);

%>

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
	<aui:form name="myExp" action="<%=(EditURL)? myExpEditURL.toString() : myExpAddURL.toString() %>" enctype="multipart/form-data" method="post">
	    <aui:input name="expenseId" type="hidden" value="<%=expenseId %>" />
	     <aui:input name="empId" type="hidden" value="<%=empId %>" />
	       <aui:input name="status" type="hidden" value="<%= (expenseEntry!=null)? (expenseEntry.getStatus()>0?expenseEntry.getStatus():0):0 %>" />
		<aui:row>
			<aui:row>
				<aui:col span="5">
					<aui:select name="projectName" label="Project Name" id="frequency" required="true">
					 <option value="" selected>None</option>
						<%
						for(ProjectMaster pm: projList){
							if(expenseEntry!=null){
								
							
						%>
						<aui:option value="<%=pm.getProjectId() %>" selected="<%=pm.getProjectId()==expenseEntry.getProjectId() %>"><%=pm.getProjectName() %></aui:option>
						<%
							}else{
						%>
						<aui:option value="<%=pm.getProjectId() %>"><%=pm.getProjectName() %></aui:option>
						
						<%
							}
						}
						%>
					</aui:select>
				</aui:col>
				<aui:col span="5">
					<aui:select name="expenseCategory" label="Expense Category" id="expenseCategory" required="true" >
					   <option value="" selected>None</option>
					  <%
					  	for(ExpCategory expCat: expCatList){
					  		if(expenseEntry!=null){
					  %>
					  <option value="<%=expCat.getCatId() %>" selected="<%=expCat.getCatId()==expenseEntry.getCatId() %>" ><%=expCat.getCategoryName() %></option>
					  <%
					  		}else{
					  %>
					 <option value="<%=expCat.getCatId() %>" ><%=expCat.getCategoryName() %></option>
						
						<%
					  		}
					  	}
						%>
						
					</aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="5">
					<aui:input type="text" name="title" id="exp_cat_name" placeholder="Title" value="<%=(expenseEntry!=null)?expenseEntry.getTitle():"" %>"
					               label="Title" >
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
                             $("#<portlet:namespace />exp_cat_name").val(val);
                          return result;
                            }
                </aui:validator>
					</aui:input>
				</aui:col>
				<aui:col span="5">
				 
         
					<aui:input type="textarea" name="description" id="description" placeholder="Description" value="<%=(expenseEntry!=null)? expenseEntry.getDescription():"" %>"
					               label="Description" required="true" >
					 
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="5">
				    
					<aui:input type="text" name="entryDate" id="txtDate_id" placeholder="Date" value="<%=(expenseEntry!=null)? joiningDate:""%>"
					               label="Date" >
					 <aui:validator name="required"></aui:validator> 
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" name="amount" id="amount" placeholder="Amount" value="<%=(expenseEntry!=null)? expenseEntry.getAmount():"" %>"
					               label="Amount" >
					 <aui:validator name="required"></aui:validator> 
					 <aui:validator name=""></aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>
		 
		    <aui:row> 
				<aui:col span="8"> 
				  <div class="attachment ">
				    <liferay-ui:panel-container extended="true" id="outerPanelContainer">
				        <liferay-ui:panel collapsible="true" defaultState="collapsed"  title="Upload supported documents" >
				       
				           <div class="row">
                                  <div class="col-md-4">
				                      <input type="file" name="uploadedFile"/>
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
			</div>		
				 </aui:col>
				<aui:col span="4">
					<aui:button type="submit" id="save" name="save"></aui:button>
					<button class="btn btn-danger" type="button" name="reset">Cancel</button>
				</aui:col>
			 </aui:row> 
		</aui:row>
			
	</aui:form>
</div>

<%  if(Validator.isNotNull(expenseHistoryList)){%>
<div><%@ include file="history-list.jsp" %> </div>
<%} %>
<script>
	
	
		
		AUI().use('aui-datepicker', function(A) {
			var datepic=new A.DatePicker({
			trigger : '#<portlet:namespace/>txtDate_id',
			mask : '%d/%m/%Y',

			popover : {
			toolbars: {
			header: [[
			             {
			               icon:'icon-trash',
			               label: 'Clear',
			               on: {
			                 click: function() {
			               	 datepic.clearSelection();
			                 }
			               }
			             },
			             {
			               icon:'icon-globe',
			               label: 'Today',
			               on: {
			                 click: function() {
			               	 datepic.clearSelection();
			               	 datepic.selectDates(new Date());
			                 }
			               }
			             }
			           ]]
			         },
			zIndex : 1000
			},

			nullableDay: true,
			nullableMonth: true,
			nullableYear: true,


			calendar: {
			     maximumDate:new Date()
			  }
			});
			});
		
		

</script>