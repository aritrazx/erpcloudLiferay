<%@page import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>

<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.ThemeDisplayModel"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<LeaveApply> leaveListTemp = new ArrayList<>();
	leaveListTemp = LeaveApplyLocalServiceUtil.getLeaveApplies(-1, -1);

	List<LeaveType> Leaveobj = new ArrayList<>();
	Leaveobj = LeaveTypeLocalServiceUtil.getLeaveTypes(-1, -1);

	List<Employee> EmployeeList = new ArrayList<>();
	EmployeeList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	String status = StringPool.BLANK;
	PortletURL  getViewUrl = renderResponse.createRenderURL();
	getViewUrl.setParameter("jspPage", "/imageView.jsp");

	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/META-INF/resources/displayAllLeave.jsp");

	DynamicQuery dynamicQuery1 = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	List<LeaveApply> leaveList = new ArrayList<>();
%>
<aui:row>

	<aui:form cssClass="basic-search input-group"
		name="searchBetweentwoDateName" action="<%=searchURL.toString()%>">
		<aui:col span="4">
			<aui:input type="text" name="fromDate" id="fromDate" value=""
				placeholder="From Date" label="">
			</aui:input>
		</aui:col>
		<aui:col span="4">
			<aui:input type="text" name="toDate" id="toDate" value=""
				placeholder="To Date" label="">
			</aui:input>
		</aui:col>
		<aui:col span="4">
			<aui:button name="saveButton" type="submit" value="Search"
				cssClass="btn btn-success" />
		</aui:col>
	</aui:form>
</aui:row>
<aui:row>
	<liferay-ui:search-container delta="5"
		emptyResultsMessage="No record found." orderByCol="" orderByType="">
		<liferay-ui:search-container-results>
			<%
				results = leaveListTemp;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.famocom.erpcloud.model.LeaveApply"
			modelVar="var">
			<%
				Employee empObj = null;
							try {
								empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
							} catch (Exception e) {
								e.printStackTrace();
							}
			%>
			<liferay-ui:search-container-column-text name="Employee Id">
				<b><%=empObj.getEmployeeId()%></b>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Name">
				<b><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b>
			</liferay-ui:search-container-column-text>
			<%
				LeaveType leaveobj = null;
							try {
								leaveobj = LeaveTypeLocalServiceUtil.getLeaveType(var.getLeaveTypeId());
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							if(Validator.isNotNull(var.getStatus_())){
								if(var.getStatus_()==0){
						    		status = "PENDING" ;
						    	}else if(var.getStatus_()==1){
						    		status = "APPROVED";
						    	}else if(var.getStatus_()==2){
						    		status = "REJECTED";
						    	}
						    	
						    }
								
			%>
			<liferay-ui:search-container-column-text name="Leave Name">
				<%=leaveobj.getLeaveName()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="From Date">
				<%=var.getFromDate()%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="To Date">
				<%=var.getToDate()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Reason"
				orderable="true" orderableProperty="reason">
				<%=var.getReason()%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Leave Days"
				orderable="true" orderableProperty="leave_days">
				<%=var.getLeaveDays()%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Attached_File"
				orderable="true" orderableProperty="attached_file">
				<%=var.getAttachedFile()%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Status"
				orderable="true" orderableProperty="isapprove">
				<%=status%>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="" cssClass="actionCol">
		<liferay-ui:icon-menu markupView="lexicon" >
							<%  getViewUrl.setParameter("leaveApplyId",String.valueOf(var.getLeaveApplyId())); %>
							<liferay-ui:icon url="<%=getViewUrl.toString() %>"  label="view" message="view" image="view"  />
						</liferay-ui:icon-menu> 
						</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
	</liferay-ui:search-container>
</aui:row>
<%-- <aui:script>
	AUI().use('aui-datepicker', function(A) {
		new A.DatePicker({
			trigger : '#<portlet:namespace/>fromDate',
			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1000
			}
		});
	});

	AUI().use('aui-datepicker', function(A) {
		new A.DatePicker({
			trigger : '#<portlet:namespace/>toDate',

			mask : '%d/%m/%Y',
			popover : {
				zIndex : 1000
			}
		});
	});
</aui:script> --%>
<aui:script>
AUI().use(
    'aui-datepicker', 
    'datatype-date', 
    'datatype-date-math', 
    'datatype-date-parse',
    function(A) {
        var toDatePicker;
        var fromDatePicker = new A.DatePicker({
            trigger: '#<portlet:namespace />fromDate',
            mask: '%d/%m/%Y',
            popover: {
                zIndex: 1000
            },
            on: {
                selectionChange: function(event) {
                    if (event.newSelection[0]) {
                        var oldToValue = A.Date.parse("%d/%m/%Y", 
                            document.getElementById(
                                "<portlet:namespace />toDate").value);
                        toDatePicker.getCalendar().set('minimumDate', 
                            event.newSelection[0]);
                        if (A.Date.isGreater(event.newSelection[0], 
                                oldToValue)) {
                            document.getElementById(
                                "<portlet:namespace />toDate").value = 
                                A.Date.format(event.newSelection[0], 
                                    {format: "%d/%m/%Y"});
                        }
                    }
                }
            },
            calendar: {
               // minimumDate: new Date()
            }
        });

        toDatePicker = new A.DatePicker({
            trigger: '#<portlet:namespace />toDate',
            mask: '%d/%m/%Y',
            popover: {
                zIndex: 1000
            },
            calendar: {
             //   minimumDate: new Date()
            }
        });
    }
);

</aui:script>
