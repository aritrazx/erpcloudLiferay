<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TravelDeskDetails"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<AddTeamMember> atmList = new ArrayList<>();
	//List<AddTeamMember> pm=null;
	try{
	ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	User userDetails = td.getUser();
	Employee emp=EmployeeLocalServiceUtil.findByemployees(userDetails.getUserId());
	//pm = AddTeamMemberLocalServiceUtil.findBygetProjectId(emp.getEmployeeId(),userDetails.getCompanyId());
	DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
	dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(emp.getEmployeeId()));
	atmList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("atmList: " + atmList.size());
	}catch(Exception e){
		
	}
	
	long travelDetailsId = ParamUtil.getLong(request, "travelDetailsId");
	System.out.println("travelDetailsId:-"+travelDetailsId);
	
	boolean editURL = false;
	TravelDeskDetails travelList=null;
	if(Validator.isNotNull(travelDetailsId)){
		editURL = true;
		try{
			travelList=TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelDetailsId);
		}catch(Exception e){
		}
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
		<liferay-ui:header title="Travel Entry" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
<portlet:actionURL name="travelDeskAdd" var="travelDeskAddURL" />
<portlet:actionURL name="travelDeskEdit" var="travelDeskEditURL" />
	<aui:form name="travelDeskAdd" action="<%=editURL != true ?travelDeskAddURL.toString() : travelDeskEditURL.toString()%>"
		method="post">
		<%-- <aui:input name="worksSchedulesId" type="hidden" value="<%=worksSchedulesId%>" /> --%>
	<%-- <aui:row>
		<aui:row>
				<aui:col span="10">
				</aui:col>
				<aui:col span="2">
					<aui:button name="addWorksSchedule" type="button" href="<%=addWorksScheduleURL.toString() %>" value="Add New Schedule">
					
					</aui:button>
				</aui:col>
		</aui:row>
	</br> --%>
<aui:row>
	<aui:input name="travelDetailsId" type="hidden" value="<%=travelDetailsId %>"></aui:input>
	<aui:col span="4">
		<%-- <aui:select name="projectTeamId" label="Project Name">
					<%
						for (AddTeamMember member:pm) {
							ProjectMaster projectName=ProjectMasterLocalServiceUtil.getProjectMaster(member.getProjectId());
							System.out.println("member.getProjectId()..."+member.getProjectId());
							System.out.println("projectName.getProjectId()..."+projectName.getProjectId());
							if(Validator.isNotNull(travelList) && travelDetailsId!=0){
					 %>
					<aui:option value="<%=member.getProjectTeamsId()%>" selected="<%=travelList.getProjectId()==member.getProjectId()%>"><%=projectName.getProjectName()%></aui:option>
					<%
							}else{
					%> 
					<aui:option value="<%=member.getProjectTeamsId()%>"><%=projectName.getProjectName()%></aui:option>
					
					<%
							}
						}
					%>
		</aui:select> --%>
		<aui:select name="projectTeamId" label="Project Name">
		<%
			try {
						for (AddTeamMember obj : atmList) {
							ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(obj.getProjectId());
							if (travelList != null) {
								if (obj.getProjectId() == travelList.getProjectId()) {
		%>
		<option value="<%=pm.getProjectId()%>" selected><%=pm.getProjectName()%></option>

		<%
			} else {
		%>
		<option value="<%=pm.getProjectId()%>"><%=pm.getProjectName()%></option>
		<%
			}
							} else {
		%>
		<option value="<%=pm.getProjectId()%>"><%=pm.getProjectName()%></option>
		<%
			}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>
		</aui:select>
	</aui:col>
	<aui:col span="1">
		
		</aui:col>
	<aui:col span="4">
		<aui:select name="ticketFor" label="Ticket For">
		<%
			if(Validator.isNotNull(travelList))
			{
		%>
		<option value="Flight" <%=(travelList.getTicketType().equalsIgnoreCase("Flight"))?"selected":"" %>> Flight Ticket</option>
		<option value="Train" <%=(travelList.getTicketType().equalsIgnoreCase("Train"))?"selected":""%>>Train Ticket</option>
		<%
			}else{
		%>
		<option value="Flight"> Flight Ticket</option>
		<option value="Train">Train Ticket</option>
		<%
			}
		%>
		</aui:select>
	</aui:col>
	
	</aui:row>
	
	<aui:row>
		<aui:col span="7">
			</b><aui:input name="checkForHotel" label="Hotel required or not"
				type="checkbox" value="<%=travelList!=null?travelList.getHotel():"" %>">
				</aui:input>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col span="4">
			<aui:input type="text" name="fromDate" id="txtFromDate" value="<%=travelList!=null?sdf.format(travelList.getFromDate()):formatter1.format(startDate) %>"
						label="From Date" readonly="readonly">
						<aui:validator name="required"></aui:validator>
		</aui:input>
		</aui:col>
		<aui:col span="1">
		
		</aui:col>
		<aui:col span="4">
			<aui:input  class="form-control" name="fromTime" id="txtToTime" type="text" label="From Time" placeholder="hh:mm" value="<%=travelList!=null ? travelList.getFromTime():"" %>">
			<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col span="4" id="endDateShown">
			<aui:input type="text" name="toDate" id="txtToDate" value="<%=travelList!=null?sdf.format(travelList.getToDate()):formatter1.format(endDate) %>"
						label="To Date" readonly="readonly">
						<aui:validator name="required"></aui:validator>
		</aui:input>
		</aui:col>
		<aui:col span="1">
		
		</aui:col>
		<aui:col span="4">
			<aui:input  class="form-control" name="toTime" id="txtToTime" type="text" label="To Time" placeholder="hh:mm" value="<%=travelList!=null?travelList.getToTime():"" %>">
			<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col span="4">
			<aui:input name="location" type="text"
			value="<%=travelList!=null?travelList.getLocation():"" %>" label="Location">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom"            
                                 errorMessage="Only Alphabets allowed">
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
                                        $("#<portlet:namespace />location").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
		</aui:col>
		
		<aui:col span="1">
		</aui:col>
		
		<aui:col span="4">
			<aui:input name="purpose" type="text"
			value="<%=travelList!=null?travelList.getPurpose():"" %>" label="Purpose">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="custom"            
                                 errorMessage="Only Alphabets allowed">
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
                                        $("#<portlet:namespace />purpose").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col span="6">
			<aui:input name="specialInstraction" type="textarea"
			value="<%=travelList!=null?travelList.getSpecialInstraction():"" %>" label="Any Special Instraction">
			<aui:validator name="required"></aui:validator>
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
                                        $("#<portlet:namespace />specialInstraction").val(val);
                                     return result;
                                       }
                           </aui:validator>
			</aui:input>
		</aui:col>
		
	</aui:row>
	<aui:button name="save" type="submit" value="save"></aui:button>
	</aui:form>
	
	
	
<script>
	/* AUI().use('aui-datepicker', function(A) {
		var dfg=new A.DatePicker({
		trigger : '#<portlet:namespace />txtToDate',
		mask : '%d/%m/%Y',
		
		popover : {
		zIndex : 1000
		}, calendar: {
		      
		   }
		});
	}); */
	
	YUI().use('aui-timepicker', function(Y) {
		new Y.TimePicker({
		trigger : '#<portlet:namespace />txtToTime',
		popover : {
		zIndex : 1
		},
		on : {
		selectionChange : function(event) {
		console.log(event.newSelection)
		}
		}
		});
	});

</script>

<script type="text/javascript">
    // This function allows me to turn the end date on and off 
    // based on whether the user clicks the checkbox
    function toggleEndDate() {
        if (document.getElementById('endDateToggle').checked) {
            document.getElementById('endDateShown').style.display = 'none';
            document.getElementById('<portlet:namespace/>txtToDate').disabled = 
                "true";
        } else {
            document.getElementById('endDateShown').style.display = 'block';
            // for some reason you shouldn't set disabled to false, 
            // but to an empty string instead...
            document.getElementById('<portlet:namespace/>txtToDate').disabled = "";
        }
    }
</script>

<aui:script>
    AUI().use(
        'aui-datepicker', 
        'datatype-date', 
        'datatype-date-math', 
        'datatype-date-parse',
        function(A) {
            var toDatePicker;
            var fromDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace />txtFromDate',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                },
                on: {
                    selectionChange: function(event) {
                        if (event.newSelection[0]) {
                            var oldToValue = A.Date.parse("%d-%m-%Y", 
                                document.getElementById(
                                    "<portlet:namespace />txtToDate").value);
                            toDatePicker.getCalendar().set('minimumDate', 
                                event.newSelection[0]);
                            if (A.Date.isGreater(event.newSelection[0], 
                                    oldToValue)) {
                                document.getElementById(
                                    "<portlet:namespace />txtToDate").value = 
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
                trigger: '#<portlet:namespace />txtToDate',
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