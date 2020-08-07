<%@page import="com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Attendance"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.Month"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>
<%
	String listValue = ParamUtil.getString(request, "list");
	System.out.println("listValue" + listValue);
	Date date=null;
	if(listValue!=null){
		date = new SimpleDateFormat("MMM").parse(listValue);
	}
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	int month = cal.get(Calendar.MONTH)+1;
	 String monthCon=null;
	if (month<10){
         monthCon = '0'+String.valueOf(month);
    }else{
    	 monthCon = String.valueOf(month);
    }
	
	
	//System.out.println("monthCon::____" +monthCon);
	Employee employee=null;
	try{
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		employee = EmployeeLocalServiceUtil.findByemployees(userId);
		//System.out.println("employee:" + employee.getEmployeeId());
	}catch(Exception e){
		
	}
	List<Attendance> attendanceTemp = new ArrayList<Attendance>();
	//String aa = "2018-03";
	String str = new String(listValue);
	String year[] = str.split(",");
	//System.out.println("year[]" + year[1]);

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	List<Attendance> attendances = AttendanceLocalServiceUtil.getAttendances(-1, -1);
	int j = 0;
	for (Attendance att : attendances) {
		String employeeId =String.valueOf(attendances.get(j).getEmployeeId());
		
		//System.out.println("Date:" + attendances.get(j).getAttDate());
		String attDate = sdf.format(attendances.get(j).getAttDate());
		String[] date1 = attDate.split("-");
		String attMonth = date1[1];
		String attYear = date1[0];
		
		//String attMonth=splitMonth[2];
		//System.out.println("attMonth:---" + attMonth + "and attYear:" + attYear);
		
		 if (attYear.equalsIgnoreCase(year[1]) && attMonth.equalsIgnoreCase(monthCon) && employeeId.equalsIgnoreCase(String.valueOf(employee.getEmployeeId()))){
			//System.out.println("attendances:--" + attendances.size()+ "attendances value" + attendances);
			attendanceTemp.add(attendances.get(j));
		}
		j++;
	}
	

	//System.out.println("list" +attendanceTemp);
%>

<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = attendanceTemp;
					total = attendanceTemp.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("attendance", attendanceTemp);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Attendance"
		modelVar="type">

		<%
			SimpleDateFormat formater = new SimpleDateFormat("MMMM dd,yyyy");
			String attDate =formater.format(type.getAttDate());
		%>
		<liferay-ui:search-container-column-text name="Date" orderable="true"
			orderableProperty="date">
			<%=attDate%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="In-Time"
			orderable="true" orderableProperty="inTime">
			<%=type.getInTime()%>

		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Out-Time"
			orderable="true" orderableProperty="outTime">
			<%=type.getOutTime()%>

		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Total" orderable="true"
			orderableProperty="totalTime">
			<%=type.getTotal()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="status">
			<%=type.getStatus()%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>