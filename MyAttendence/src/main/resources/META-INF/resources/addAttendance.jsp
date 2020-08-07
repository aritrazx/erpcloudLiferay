<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Attendance"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.Format"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Conjunction"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-ui:error key="inTimeMinError" message="Sorry,Outtime minute must be greater than or equal to intime minute"/>
<%
	ThemeDisplay td = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	String x="";
	//DateFormat df = new SimpleDateFormat("yyy/MM/dd hh:mm:ss");
	Calendar calobj = Calendar.getInstance();
	calobj.set(Calendar.HOUR_OF_DAY, 0);
	calobj.set(Calendar.MINUTE, 0);
	calobj.set(Calendar.SECOND, 0);
	calobj.set(Calendar.MILLISECOND, 0);
	//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(df); 
	DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
	Date date = new Date();
	 
	//S date1=formatter1.parse(sDate1);  
	dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
	
	//System.out.println(dateFormat.format(date));
	boolean test = false;
	
    List<Attendance> attendanceTemp = new ArrayList<Attendance>();
	
	long userId = td.getUserId();
	Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
	//System.out.println("userId:-"+userId);
	//System.out.println("EmployeeId:-"+employee.getEmployeeId());
	Attendance attend=null;
	try{
		if(Validator.isNotNull(employee.getEmployeeId())){
		 attend=AttendanceLocalServiceUtil.findByempIdAndAttDate(employee.getEmployeeId(),calobj.getTime());
		}
	
	/* DynamicQuery attendanceQuery = AttendanceLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	Criterion criterion4 = null;
	criterion3 = RestrictionsFactoryUtil.eq("employeeId", employee.getEmployeeId());
	criterion3 = RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("attDate",calobj.getTime()));
	attendanceQuery.add(criterion3);
	attendanceTemp=AttendanceLocalServiceUtil.dynamicQuery(attendanceQuery);
	System.out.println("attendanceTemp:-"+attendanceTemp); */
	if(attend==null){
		x = "";
		//System.out.println("x:-"+x);
	}else{
		if(!attend.getInTimeHour().equalsIgnoreCase(StringPool.BLANK) && !attend.getInTimeMin().equalsIgnoreCase(StringPool.BLANK)){
			x = "1";
		}if(!attend.getOutTimeHour().equalsIgnoreCase(StringPool.BLANK) && !attend.getInTimeMin().equalsIgnoreCase(StringPool.BLANK)){
			x = "2";
		}
		//System.out.println("x:-"+x);
	}
	}catch(Exception e){
	}
	

%>
<%
	PortletURL attendanceListURL = renderResponse.createRenderURL();
	attendanceListURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<aui:row>
	<aui:col span="10">
		<a href="<%=attendanceListURL.toString()%>"><span
			class="icon-monospaced"><svg
					class="lexicon-icon lexicon-icon-angle-left" focusable="false"
					role="img" title="Back" backLabel="Back" viewBox="0 0 512 512">
     <path class="lexicon-icon-outline"
						d="M114.106 254.607c0.22 6.936 2.972 13.811 8.272 19.11l227.222 227.221c11.026 11.058 28.94 11.058 39.999 0 11.058-11.026 11.058-28.94 0-39.999l-206.333-206.333c0 0 206.333-206.333 206.333-206.333 11.058-11.059 11.058-28.973 0-39.999-11.058-11.059-28.973-11.059-39.999 0l-227.221 227.221c-5.3 5.3-8.052 12.174-8.273 19.111z"></path>
		</svg></span></a>
		<label><h2>&nbsp My Attendance</h2></label>
	</aui:col>
	<aui:col span="2">
			<%-- <aui:button name="myAttendanceRegister" type="submit" href="<%=attendanceListURL.toString() %>" value="My Attendance Register"
				></aui:button> --%>
		</aui:col>
	</aui:row>

<portlet:actionURL name="myAttendance"  var="myAttendanceURL" />
<aui:form name="myAttendance" action="<%=myAttendanceURL%>"
	method="post">
	<%-- <aui:input name="employeeId" type="hidden" value="" /> --%>

	<aui:row>
		</br>
		<aui:row>
			<aui:col span="4">

			</aui:col>
			<aui:col span="6">
				<label>
					<h4>
						<b>Attendance Date/Time : <%=dateFormat.format(date)%></b>
					</h4>
				</label>
			</aui:col>
		</aui:row>
		<!--In Time  -->
		<aui:row>
			<aui:col span="4">

			</aui:col>

			<aui:col span="2">
				<label>In Time</label>
				<aui:select name="inTimeHour" label="" id="inTimeHour">
					<option value="" selected><%=attend!=null?attend.getInTimeHour():"select"%></option>
					<%
						for (int i = 1; i <= 24; i++) {
							
						int Field = i;
						//String disable="disabled";
					%>
					<option value="<%=Field%>" ><%=Field %></option>
					<%
						}
					%>
				</aui:select>
				<%--  <aui:input class="form-control" id="inTimeHour" name="inTimeHour" label="In Hour" type="text" placeholder="hh" value=""></aui:input> --%>
			</aui:col>
			<aui:col span="2">
				<label></label>
				<aui:select name="inTimeMinute" label="" id="inTimeMinute">
					<option value="" selected><%=attend!=null?attend.getInTimeMin():"select"%></option>
					<%
						for (int i = 0; i <= 60; i++) {
						int Field = i;
					%>
					<aui:option value="<%=Field%>"><%=Field%></aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>
		</aui:row>
		<!--Out Time -->
		<aui:row>
			<aui:col span="4">

			</aui:col>

			<aui:col span="2">
				<label>Out Time</label>
				<aui:select disabled="disabled" id="outTimeHour" name="outTimeHour"
					label="">
					<option value="" selected><%=attend!=null?attend.getOutTimeHour():"select"%></option>
					<%
						int valueInHour=0;
						if(Validator.isNotNull(attend)){
							valueInHour =Integer.parseInt(attend.getInTimeHour());
							valueInHour=valueInHour-1;
						}
						for (int i = 1; i <= 24; i++) {
							int Field = i;
							if(valueInHour!=0){
							
								valueInHour--;
					%>
					<option value="<%= Field%>" disabled="disabled"><%=Field%></option>
					<%
						
							}else{
							%>
							<option value="<%= Field%>" ><%=Field%></option>
							<% 
							}
							}
					%>
				</aui:select>

			</aui:col>
			<aui:col span="2">
				<label></label>
				<aui:select id="outTimeMinute" name="outTimeMinute" label="">
					<option value="" selected><%=attend!=null?attend.getOutTimeMin():"select"%></option>
					<%
						for (int i = 0; i <= 60; i++) {
												int Field = i;
					%>
					<aui:option value="<%=Field%>"><%=Field%></aui:option>
					<%
						}
					%>
				</aui:select>
			</aui:col>
		</aui:row>

		<aui:row>
			<aui:col span="4">
			</aui:col>

			<aui:col span="6">
				<aui:button type="submit" id="save" name="save"></aui:button>
			</aui:col>
		</aui:row>
	</aui:row>
	<aui:input type="hidden" name="" value="<%=x %>" id="timeVal"></aui:input>
</aui:form>


<script type="text/javascript">
	$(document).ready(
			function() {
				
				console.log("ready!");
				//alert(jQuery("#<portlet:namespace/>timeVal").val());
				<%-- var val = new set();
				val=<%=attendanceTemp%>;
				alert("v"); --%>
				if (jQuery("#<portlet:namespace/>timeVal").val() == "") {
					jQuery("#<portlet:namespace/>outTimeHour").attr('disabled',
							'disabled');
					jQuery("#<portlet:namespace/>outTimeMinute").attr(
							'disabled', 'disabled');
					jQuery("#<portlet:namespace/>inTimeHour").attr('enabled',
							'enabled');
					jQuery("#<portlet:namespace/>inTimeMinute").attr('enabled',
							'enabled');
				} else if (jQuery("#<portlet:namespace/>timeVal").val() == "1"){
					jQuery("#<portlet:namespace/>outTimeHour").attr('enabled',
							'enabled');
					jQuery("#<portlet:namespace/>outTimeMinute").attr(
							'enabled', 'enabled');
					jQuery("#<portlet:namespace/>inTimeHour").attr('disabled',
							'disabled');
					jQuery("#<portlet:namespace/>inTimeMinute").attr(
							'disabled', 'disabled');
				}else if (jQuery("#<portlet:namespace/>timeVal").val() == "2"){
					jQuery("#<portlet:namespace/>outTimeHour").attr('disabled',
					'disabled');
					jQuery("#<portlet:namespace/>outTimeMinute").attr(
					'disabled', 'disabled');
					jQuery("#<portlet:namespace/>inTimeHour").attr('disabled',
					'disabled');
					jQuery("#<portlet:namespace/>inTimeMinute").attr(
					'disabled', 'disabled');
					jQuery("#<portlet:namespace/>save").attr(
							'disabled', 'disabled');
		}

		});
	
	
</script>