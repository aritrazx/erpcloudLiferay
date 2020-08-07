<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.Attendance"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>

<%
	PortletURL myAttendanceApplyURL = renderResponse.createRenderURL();
	myAttendanceApplyURL.setParameter("jspPage", "/META-INF/resources/addAttendance.jsp");

	PortletURL attendanceListURL = renderResponse.createRenderURL();
	attendanceListURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	attendanceListURL.setParameter("jspPage", "/META-INF/resources/attendanceList.jsp");

	List<Attendance> attendanceTemp = new ArrayList<Attendance>();
	attendanceTemp = AttendanceLocalServiceUtil.getAttendances(-1, -1);
	
	List<String> monthsList = new ArrayList<String>();
	String[] allMonth = new DateFormatSymbols().getMonths();
	int year = Calendar.getInstance().get(Calendar.YEAR);
	//System.out.println("allMonth" + allMonth.length + "year" + year);
	String list = ParamUtil.getString(request, "MonthYear", StringPool.BLANK);
	//System.out.println("list:---" + list);
	
	String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
	        "August", "September", "October", "November", "December" };

	    Calendar cal = Calendar.getInstance();
	    String currentMonth = monthName[cal.get(Calendar.MONTH)];
	String currentMonthYear=(currentMonth+","+year);
%>


<aui:form name="addAttendance" action="" method="post">
	<aui:row>
		<aui:col span="1">
			<label>Show</label>
		</aui:col>

		<aui:col span="2">
			<aui:select onChange="attendanceList(this.value)" name="MonthYear"
				label="" id="MonthYear" value="">
				<%
					for (int i = 0; i < allMonth.length - 1; i++) {
						String month = allMonth[i];
						//System.out.println("month = " + month);
						monthsList.add(allMonth[i]);

						String monthYear = (monthsList.get(i) + "," + year);
						//System.out.println("monthYear:--" + monthYear);
						//System.out.println("currentMonthYear:--" + currentMonthYear);
						String isSelect = "";

						if (currentMonthYear.equalsIgnoreCase(monthYear)) {
							//System.out.println("currentMonthYearLoop::--" + currentMonthYear);
							//System.out.println("monthsList.get(i)yearLoop::--" + monthYear);
							isSelect = "selected";
						}

						//System.out.println("isSelect" + isSelect);
				%>
				<option value="<%=monthsList.get(i) + "," + year%>" <%=isSelect%>><%=monthsList.get(i) + "," + year%></option>

				<%	
					
					}
				%>
			</aui:select>
		</aui:col>
		<aui:col span="9">
			<label></label>
		</aui:col>
	</aui:row>
	<aui:input type="hidden" name="list" id="list"></aui:input>
	<%-- <aui:input type="text" name="currentMonth" id="currentMonth"></aui:input> --%>
</aui:form>

<%-- <%@ include file="attendanceList.jsp"%> --%>
<div id="projList">
</div>



<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "My Attendance")%>'
		url="<%=myAttendanceApplyURL.toString()%>" />
</liferay-frontend:add-menu>

<script type="text/javascript">
	$(document).ready(function() {
	var months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    var date = new Date();
   	var thisMonth = months[date.getMonth()];
    var output = document.getElementById('output');
    console.log(thisMonth);
    var year=date.getFullYear();
    var monthYear=thisMonth+","+year;
     //output.textContent = thisMonth;
     //var select=output.textContent;
    /* document.getElementById('date').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear(); /////document.getElementById('date').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear()*/
	//alert("select "+monthYear);
	attendanceList(monthYear);
	//attendanceList(select);
});
function attendanceList(list){
	//alert(list);
   url="<%=attendanceListURL.toString()%>";
		$.ajax({
			type : "post",
			url : url,
			data : {
				"<portlet:namespace/>list" : list
			},
			success : function(data) {
				$("#projList").html(data);
			}
		});
	}
</script>