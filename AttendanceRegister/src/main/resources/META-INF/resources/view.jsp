<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.SchedulesMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.WorksSchedulesLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.WorksSchedules"%>
<%@page import="com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.SchedulesDetails"%>
<%@page import="com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.HolidayCalenderManagement"%>
<%@page import="com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApplyDtl"%>
<%@page import="com.liferay.famocom.erpcloud.model.Attendance"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%

	String selectEmployee = ParamUtil.getString(renderRequest, "selectEmployee",StringPool.BLANK);
	String month = ParamUtil.getString(renderRequest, "month",StringPool.BLANK);
	String year =ParamUtil.getString(renderRequest, "year",StringPool.BLANK);
	/* List<String> dateList = ParamUtil.getString(renderRequest, "dateList",StringPool.BLANK); */
	String attendenceStatus="Absent";
	
	 List<String> allDt = new ArrayList<>();
		if(Validator.isNotNull(month)&& Validator.isNotNull(year)){
			Calendar cal = new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month)-1, 1);
			do {
			    int day = cal.get(Calendar.DAY_OF_WEEK);
			    if (day == Calendar.MONDAY || day == Calendar.TUESDAY || day==Calendar.WEDNESDAY || day==Calendar.THURSDAY || day==Calendar.FRIDAY) {
			    	String allDate=String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+"/"+month+"/"+year ;
			    	allDt.add(allDate);
			    }
			    cal.add(Calendar.DAY_OF_YEAR, 1);
			}  while (cal.get(Calendar.MONTH) == Integer.parseInt(month)-1);
			/*actionRequest.setAttribute("dateList",allDateList);*/
		}
%>
<%
	List<User> userList = new ArrayList<>();
	DynamicQuery allUser = UserLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("status",0);
	allUser.add(criterion);
	userList = UserLocalServiceUtil.dynamicQuery(allUser);

	List<Employee> emp = EmployeeLocalServiceUtil.getEmployees(-1,-1);
	List<Employee> activeEmployee= new ArrayList<>();
	for(int i=0;i<userList.size();i++){
		DynamicQuery employee = EmployeeLocalServiceUtil.dynamicQuery();
		Criterion criterion1 = null;
		criterion1 = RestrictionsFactoryUtil.eq("userId",userList.get(i).getUserId());
		employee.add(criterion1);
		emp= EmployeeLocalServiceUtil.dynamicQuery(employee);
		activeEmployee.addAll(emp);
	}
	//Employee empActiveList = EmployeeLocalServiceUtil.findByemployees(activeEmployee.)
	
	
	//FOR MONTH AND YEAR
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	System.out.print("currentYear:-"+currentYear);
	int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
	List<Integer> yearList = new ArrayList<Integer>();
	
	for(int i=5;i>0;i--){
	yearList.add(currentYear-i);
	}
	yearList.add(currentYear);
%>
<portlet:resourceURL id="exportAction" var="exportURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportXLS" />
	<portlet:param name="selectEmployee" value="<%=selectEmployee %>" />
	<portlet:param name="month" value="<%=month %>" />
	<portlet:param name="year" value="<%=year %>" />
</portlet:resourceURL>
<portlet:actionURL name="attendenceRegister" var="attendenceRegisterURL" />
<aui:form name="attendenceRegister"
	action="<%=attendenceRegisterURL.toString()%>" method="post">
	<aui:row>
		<aui:col span="7">
		</aui:col>
		<aui:col span="2">
		</aui:col>
		<%
		if(Validator.isNotNull(month) && Validator.isNotNull(year))
		{
		%>
		<aui:col span="3">
			<a class="btn btn-primary btn-default" name="generateTemplate"
				type="submit" href="<%=exportURL.toString()%>">Download Attendance Excel</a>
		</aui:col>
		</br>
		</br>
		<%
		}
		%>
	</aui:row>
	<aui:row>
		<aui:col span="4">
			<aui:select name="selectEmployee" id="selectEmployee" label="Select Employee">
				<option value="">All Employee</option>
				<%
					try {
										//List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
						for (Employee obj : activeEmployee) 
							{
								String isSelect = null;
								if(!selectEmployee.isEmpty()){
								if(obj.getEmployeeId()==Long.parseLong(selectEmployee)){
									isSelect="selected";
								}
							}
				%>
										<option value="<%=obj.getEmployeeId()%>" <%=isSelect %>><%=obj.getEmployeeCode() + "-" + obj.getFirstName() + " " + obj.getLastName()%>
										</option>

				<%					 
							}
						} catch (Exception e) 
							{
								//e.printStackTrace();
							}
				%>
			</aui:select>
		</aui:col>
		<aui:col span="3">
			<aui:select name="month" label="Month" id="month">
				<aui:option value="1" selected="<%=1==currentMonth %>">January</aui:option>
				<aui:option value="2" selected="<%=2==currentMonth %>">February</aui:option>
				<aui:option value="3" selected="<%=3==currentMonth %>">March</aui:option>
				<aui:option value="4" selected="<%=4==currentMonth %>">April</aui:option>
				<aui:option value="5" selected="<%=5==currentMonth %>">May</aui:option>
				<aui:option value="6" selected="<%=6==currentMonth %>">June</aui:option>
				<aui:option value="7" selected="<%=7==currentMonth %>">July</aui:option>
				<aui:option value="8" selected="<%=8==currentMonth %>">August</aui:option>
				<aui:option value="9" selected="<%=9==currentMonth %>">September</aui:option>
				<aui:option value="10" selected="<%=10==currentMonth %>">October</aui:option>
				<aui:option value="11" selected="<%=11==currentMonth %>">November</aui:option>
				<aui:option value="12" selected="<%=12==currentMonth %>">December</aui:option>
			</aui:select>
		</aui:col>
		<aui:col span="4">
			<aui:select name="year" label="Year">
				<%  	
		Iterator it= yearList.iterator();
		while(it.hasNext()){
		Object yr = it.next();
		%>
				<aui:option value="<%=yr.toString() %>"
					selected="<%=currentYear==Integer.valueOf(yr.toString()) %>"><%=yr.toString() %></aui:option>
				<%	 
		} 
		%>
			</aui:select>
		</aui:col>
		<aui:col span="1">
			<span> <br/>  </span>
			<aui:button name="button" type="submit" value="View" ></aui:button>
		</aui:col>
	</aui:row>
</aui:form> 
<%
	if(Validator.isNotNull(month) && Validator.isNotNull(year)){
%>


<table class="table table-bordered table-hover table-striped">
<thead>
	<tr>
		<th >Date</th>
		<th>Employee Code</th>
		<th>Employee Name</th>
		<th>In Time</th>
		<th>Out Time</th>
		<th>Total Time</th>
		<th>Status</th>
	</tr>
	</thead>
<tbody>
	<%
  	if(Validator.isNotNull(allDt) && Validator.isNotNull(selectEmployee)){
   
  	for(int i=0;i<allDt.size();i++){
  		Date listDate=new SimpleDateFormat("dd/MM/yyyy").parse(allDt.get(i)); 
  		
  		//Date format
  		
  		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		String strDate = formatter.format(listDate);
					
					
  		Attendance att =null;
  		long employee =Long.parseLong(selectEmployee);
  		if(Validator.isNotNull(employee)){
  			att=AttendanceLocalServiceUtil.findByempIdAndAttDate(employee, listDate);
  		}
  		LeaveApplyDtl leave=null;
  		HolidayCalenderManagement holiday=null;
  		SchedulesDetails sDetails = null;
  		SchedulesMaster sMasterObj=null;
  		WorksSchedules ws=null;
  		//holiday=HolidayCalenderManagementLocalServiceUtil.findByempIdAndAttDate(listDate);
  		if(att==null){
  			leave = LeaveApplyDtlLocalServiceUtil.findByempIdAndAttDate(Long.parseLong(selectEmployee), listDate, 1);
  		}
  		if(att==null && leave==null ){
  			holiday=HolidayCalenderManagementLocalServiceUtil.findByempIdAndAttDate(listDate);
  		}
  		if(att==null && leave==null && holiday==null ){
  			sDetails = SchedulesDetailsLocalServiceUtil.findByempIdAndAttDate(Long.parseLong(selectEmployee), listDate);
  		}
  		Employee empList = EmployeeLocalServiceUtil.getEmployee(Long.parseLong(selectEmployee));
  		if(att!=null){ 
  			String attendanceStatus="";
	  			if(att.getStatus().equalsIgnoreCase("Present")){
	  				attendanceStatus= "attendance-present";
	  			}else{
	  				attendanceStatus="attendance-absent";
	  			}
  		%>

	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"><%=  att.getInTime() %></td>
		<td width="13%" align="center"><%=  att.getOutTime() %></td>
		<td width="13%" align="center"><%=  att.getTotal() %></td>
		<td width="13%" align="center" class="<%=attendanceStatus %>" ><%=att.getStatus() %></td>
	</tr>
	<%}
  			
		  else if(leave!=null){
			  
		  %>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center">Leave</td>
	</tr>
	<%}else if(holiday!=null)
	  			{ %>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center">Holiday</td>
	</tr>
	<%}else if(sDetails!=null)
	  			{ 
	  				 ws = WorksSchedulesLocalServiceUtil.getWorksSchedules(sDetails.getWorksSchedulesId());
	  				 sMasterObj = SchedulesMasterLocalServiceUtil.getSchedulesMaster(ws.getSchedulesId());
	  				
	  			%>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"><%=sMasterObj.getSchedulesName()%></td>
	</tr>
	<%}else{%>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center" class="attendance-absent">Absent</td>
	</tr>
	<%}
  	} 
  	}%></tbody>
  	<tbody>
  	<% if((!Validator.isNotNull(selectEmployee)) && Validator.isNotNull(allDt)){
  		for(int i=0;i<allDt.size();i++){
  			
  			for(int j=0;j<activeEmployee.size();j++){
  		
  	  		Date listDate=new SimpleDateFormat("dd/MM/yyyy").parse(allDt.get(i)); 
  	  		
  	  		//Date format
  	  		
  	  		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
  			String strDate = formatter.format(listDate);
  			Attendance att = null;
  			if(Validator.isNotNull(activeEmployee.get(j).getEmployeeId())){
  				att=AttendanceLocalServiceUtil.findByempIdAndAttDate(activeEmployee.get(j).getEmployeeId(), listDate);
  			}
  	  		LeaveApplyDtl leave=null;
  	  		HolidayCalenderManagement holiday=null;
  	  		SchedulesDetails sDetails = null;
  	  		SchedulesMaster sMasterObj=null;
  	  		WorksSchedules ws=null;
  	  		//holiday=HolidayCalenderManagementLocalServiceUtil.findByempIdAndAttDate(listDate);
  	  		 if(att==null){
  	  			leave = LeaveApplyDtlLocalServiceUtil.findByempIdAndAttDate(activeEmployee.get(j).getEmployeeId(), listDate, 1);
  	  		}
  	  		if(att==null && leave==null ){
  	  			holiday=HolidayCalenderManagementLocalServiceUtil.findByempIdAndAttDate(listDate);
  	  		}
  	  		if(att==null && leave==null && holiday==null ){
  	  			sDetails = SchedulesDetailsLocalServiceUtil.findByempIdAndAttDate(activeEmployee.get(j).getEmployeeId(), listDate);
  	  		}
  	  		Employee empList = EmployeeLocalServiceUtil.getEmployee(activeEmployee.get(j).getEmployeeId());
  	  		if(att!=null){ 
  	  			String attendanceStatus="";
  	  			if(att.getStatus().equalsIgnoreCase("Present")){
  	  				attendanceStatus= "attendance-present";
  	  			}else{
  	  				attendanceStatus="attendance-absent";
  	  			}
  %>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"><%=  att.getInTime() %></td>
		<td width="13%" align="center"><%=  att.getOutTime() %></td>
		<td width="13%" align="center"><%=  att.getTotal() %></td>
		<td width="13%" align="center" class="<%=attendanceStatus %>" ><%=att.getStatus() %></td>
	</tr>
	<%}
  			
		  else if(leave!=null){
			  
		  %>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center">Leave</td>
	</tr>
	<%}else if(holiday!=null)
	  			{ %>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center">Holiday</td>
	</tr>
	<%}else if(sDetails!=null)
	  			{ 
	  				 ws = WorksSchedulesLocalServiceUtil.getWorksSchedules(sDetails.getWorksSchedulesId());
	  				 sMasterObj = SchedulesMasterLocalServiceUtil.getSchedulesMaster(ws.getSchedulesId());
	  				
	  			%>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"><%=sMasterObj.getSchedulesName()%></td>
	</tr>
	<%}else{%>
	<tr>
		<td width="13%" align="center"><%=strDate%></td>
		<td width="13%" align="center"><%=empList.getEmployeeCode() %></td>
		<td width="13%" align="center"><%=empList.getFirstName()+" "+empList.getLastName() %></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center"></td>
		<td width="13%" align="center" class="attendance-absent">Absent</td>
	</tr>

	<%}}}}%>
</tbody>
</table>
<%} %>

