<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
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
<script
	src="/documents/20143/32425/jquery.min+%282%29.js/944309f5-712e-fdfa-4c5e-fc4ad142d71e"></script>
<%
	PortletURL tsEntryURL = renderResponse.createRenderURL();
	tsEntryURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	List<String> noOfHours = new ArrayList<>();
	Map<Date, String> map = new HashMap<Date, String>();
	tsEntryURL.setParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
	/* String from_date="01/03/2018";
	String to_date="31/03/2018";
	Date newfrom_date = new Date();
	Date newto_date = new Date();
	newfrom_date = new SimpleDateFormat("dd/MM/yyyy").parse(from_date);
	newto_date = new SimpleDateFormat("dd/MM/yyyy").parse(to_date); */
	ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
	long userId = td.getUserId();
	Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
	long employeeId = emp.getEmployeeId();
	double tempNoOfHrs = 0.0;
	String from_date1 = "01/01/2018";
	Date fromDate = new Date();
	fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from_date1);
	String val = "";
	Calendar cal1 = new GregorianCalendar();
	cal1.set(Calendar.HOUR_OF_DAY, 0);
	cal1.set(Calendar.MINUTE, 0);
	cal1.set(Calendar.SECOND, 0);
	cal1.set(Calendar.MILLISECOND, 0);
    cal1.set(Calendar.DAY_OF_YEAR, 1);
    Date startDate=cal1.getTime();
    System.out.println("first day of year"+startDate);
	Calendar c = Calendar.getInstance();
	c.set(Calendar.HOUR_OF_DAY, 0);
	c.set(Calendar.MINUTE, 0);
	c.set(Calendar.SECOND, 0);
	c.set(Calendar.MILLISECOND, 0);
	// this takes current date
	c.set(Calendar.DAY_OF_MONTH, 1);
	// Date fromDate=c.getTime();
	System.out.println("dt1" + fromDate);
	/* c.set(Calendar.DAY_OF_YEAR, 1);
	Date yearDate=c.getTime();
	System.out.println("yearDate.....:" + yearDate); */
	c.add(Calendar.MONTH, 1);
	c.set(Calendar.DAY_OF_MONTH, 1);
	c.add(Calendar.DATE, -1);
	Date toDate = c.getTime();
	System.out.println("dt2" + toDate);
	
	Calendar cal2 = new GregorianCalendar();
	cal2.set(Calendar.HOUR_OF_DAY, 0);
	cal2.set(Calendar.MINUTE, 0);
	cal2.set(Calendar.SECOND, 0);
	cal2.set(Calendar.MILLISECOND, 0);
	cal2.add(Calendar.WEEK_OF_YEAR, -1);
	cal2.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+1);
	Date firstDayPrevWeek = cal2.getTime();
	System.out.println("firstDayPrevWeek" + firstDayPrevWeek);
	
	
	Calendar cal3 = new GregorianCalendar();
	cal3.set(Calendar.HOUR_OF_DAY, 0);
	cal3.set(Calendar.MINUTE, 0);
	cal3.set(Calendar.SECOND, 0);
	cal3.set(Calendar.MILLISECOND, 0);
	cal3.add(Calendar.WEEK_OF_YEAR, -1);
	cal3.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+1);
	cal3.add(Calendar.DAY_OF_MONTH, -1);
	Date lastDayPrevWeek = cal3.getTime();
	System.out.println("lastDayPrevWeek" + lastDayPrevWeek);
	
	int i = 1;
	while (startDate.before(toDate) || startDate.equals(toDate)) {
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
				//.setProjection(ProjectionFactoryUtil.projectionList())
				.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
				.add(RestrictionsFactoryUtil.eq("entryDate", startDate))
				//.setProjection(ProjectionFactoryUtil.property("hours"));
				//.add(ProjectionFactoryUtil.groupProperty("primaryKey.colorCode"), "colorCode")
				//.setProjection(ProjectionFactoryUtil.property("entry_date"))
				.setProjection(ProjectionFactoryUtil.sum("hours"));

		List<TimeSheetEntry> list = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println("listtse......" + list);
		/* for(TimeSheetEntry tse: list){
			System.out.println("listtse......" + tse.getEntry_date()+tse.getHours());
		}  */

		//System.out.println("list......" + list);
		String noOfHrs = String.valueOf(list.get(0));
		noOfHours.add(noOfHrs);
		//System.out.println("noOfHours......" + noOfHours);
		//noOfHours.get(0)

		if (Validator.isNotNull(noOfHrs)) {
			tempNoOfHrs = Double.valueOf(noOfHrs.trim());
			//System.out.println("tempNoOfHrs%%%%......" + tempNoOfHrs);
		} else {
			tempNoOfHrs = 0.0;
		}
		
		
		if (Validator.isNotNull(noOfHrs)) {
			noOfHrs = "Hours: " + noOfHrs;
		} else {
			noOfHrs = "";
		}
		map.put(startDate, noOfHrs);
		//System.out.println("noOfHrs......" + noOfHrs);
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, 1);
		startDate = cal.getTime();
		i++;
		//System.out.println("fromDate"+fromDate); 
	}
	for (Map.Entry m : map.entrySet()) {
		//System.out.println("map......" + m.getKey() + "###" + m.getValue());
	}
%>

<link
	href="/documents/20143/32425/bootstrap-fullcalendar+%281%29.css/f02ef750-7307-df1b-af51-9ca8a96d6112"
	rel="stylesheet" type="text/css" />


<script
	src="https://momentjs.com/downloads/moment.min.js"></script>

<script
	src="/documents/20143/32425/fullcalendar-1.min+%282%29.js/7abef3e3-b54a-2d3f-3343-afe04d7c9514"></script>



<script>
function addTimeSheet(date){
	var url="<%=tsEntryURL.toString()%>"
	alert('Want to add timesheet? ' + date);
		$.ajax({
			type : "POST",
			url : url,
			data : {
				"<portlet:namespace/>date" : date
			},
			//dataType: 'json',
			success : function(data) {
				//alert(data);
				$("#calendar").html(data);

				$('#calendar').show();
			},
		});
	}
	


	$(document).ready(
			function() {

				var curDate = new Date();
				$('#calendar').fullCalendar(
						{
							selectable: true,
							selectHelper: true,
							firstDay : 0,
							//theme:true,
							dayNamesShort : [ 'Su', 'Mo', 'Tu', 'We', 'Th',
									'Fr', 'Sa' ],
							defaultDate : curDate,
							defaultView : 'month',
							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'month agendaWeek agendaDay',
								prev : 'left-single-arrow',
								next : 'right-single-arrow',
							},
							    /* selectAllow: function(selectInfo) {
								      return moment().diff(selectInfo.end) <= 0;
								    }, */
							 views: {
								    month: { // name of view
								      titleFormat: 'YYYY, MM, DD'
								      // other view-specific options here
								    }
								  },

								  /* dayRender: function(date, cell){
									  if (date < curDate){
								            $(cell).addClass('disabled');
								        }
								    },
								   
								    viewRender: function (view) {                                        

								        var minDate = $.fullCalendar.moment('2018-06-01');               
								        // view.end seems to be +1 day than the displayed, hence the "<="
								        if (view.end <= minDate) {                                       
								            $('#calendar').fullCalendar('gotoDate', minDate);            
								        }                                                                

								        var maxDate = $.fullCalendar.moment('2018-06-13');               
								        if (view.start > maxDate) {                                      
								            $('#calendar').fullCalendar('gotoDate', maxDate);            
								        }                                                                
								    },   */ 

							dayClick : function(date, cell) {
								var clickableDate = date.getDate() + "/"	+ (date.getMonth() + 1) + "/" + date.getFullYear();
								console.log(clickableDate);
								var clickDate =date.getDate();
								var clickMonth =date.getMonth() + 1;
								var clickYear = date.getFullYear();
								var selDate = new Date();
								var curr_date = selDate.getDate();
								var curr_month = selDate.getMonth()+1;
								var curr_year = selDate.getFullYear();
								out:
								if(clickDate<=curr_date && clickMonth<=curr_month && clickYear<=curr_year){ 
								addTimeSheet(clickableDate);
								} else {
									if(clickMonth<curr_month && clickDate>curr_date && clickYear<=curr_year){
										addTimeSheet(clickableDate);
										break out;
									} else {
										if(clickMonth>curr_month && clickDate>curr_date && clickYear<curr_year){
											addTimeSheet(clickableDate);
											break out;
										} else {
											if(clickMonth>curr_month && clickDate<curr_date && clickYear<curr_year){
												addTimeSheet(clickableDate);
												break out;
											} else {}
										}
										}
									
								
									extendedDate(clickableDate);
								}

							},
							select: function(startDate, endDate) {
								/* var selDate = new Date(startDate);
								var curr_date = selDate.getDate();
								var curr_month = selDate.getMonth()+1;
								var curr_year = selDate.getFullYear(); */

							/*  selectConstraint: {
							    	start: $.fullCalendar.moment().subtract(1, 'days'),
							    	end: $.fullCalendar.moment().startOf('year').add(100, 'year')
							    	}, */

								var startDate1 = startDate.getDate() + "/"	+ (startDate.getMonth() + 1) + "/" + startDate.getFullYear();
						    	var endDate1 = endDate.getDate() + "/"	+ (endDate.getMonth() + 1) + "/" + endDate.getFullYear();
						    	if(startDate.getDate()<endDate.getDate() && startDate.getMonth()==endDate.getMonth() && startDate.getFullYear()==endDate.getFullYear()){
							    	alert('selected ' + startDate1 + ' to ' + endDate1);
								} else {}

								//var title = prompt('Event Title:'+selDate);

								/* var eventData;
								if (title) { */

								/*eventData = {
								title: title,
								start: start,
								end: end
								};*/
								/* $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
								}
								$('#calendar').fullCalendar('unselect'); */
								},
								editable: true,
								eventLimit: true, 
								events: [
									 <%for (Map.Entry m : map.entrySet()) {%>
									{
										<%if(Validator.isNotNull(m.getValue())){ %>
									    
										title: '<%=m.getValue()%>',
										start: '<%=m.getKey()%>'
									      <%}%> 
										 
									
									},

									<%}%>
									
									]

						});
				
			});
			
			
	//getMonth();
	//$('#calendar').fullCalendar('gotoDate', curDate);
			/* function getMonth(){
			  var date = $("#calendar").fullCalendar('getDate');
			  var month_int = date.getMonth();
			  alert(month_int+1 );
			 // $("#<portlet:namespace/>test").val()=month_int;
			  //you now have the visible month as an integer from 0-11
			} */
	       /* function showHours(date){
	    	   var dt=date;
	    	  // jQuery("#<portlet:namespace/>forDat").val()=1;
	    	  // alert(date);
	    	   
	       } */
			
			/* $(".fc-widget-content").addClass("disabled");

			.disabled .fc-day-content {
			    background-color: #123959;
			    color: #FFFFFF;
			    cursor: default;
			} */
</script>
<div id="calendar"></div>
<%-- <portlet:actionURL name="calendar" var="calendarURL" />
<aui:form name="calendar" action="<%=calendarURL.toString()%>"
	method="post">

	<aui:row>
	<aui:col span="2">
	<aui:select name="lockingEvent" label="Choose Days for Locking">
	<aui:option value="1">1 Day</aui:option>
	<aui:option value="2">2 Days</aui:option>
	<aui:option value="3">3 Days</aui:option>
	</aui:select>
	</aui:col>
	<aui:col span="1">
	<aui:button name="button" type="submit" value="submit"></aui:button>
	</aui:col>
	</aui:row>
	

</aui:form> --%>

<%-- <aui:input type="text" name="test" value="" id="test"/> --%>
<script>

function extendedDate(date){
	<%-- var url="<%=calendarURL.toString()%>" --%>
	alert("Future Date is not allowed!");
	/* alert("Future Date is not allowed!");
		$.ajax({
			type : "POST",
			url : url,
			data : {
				"<portlet:namespace/>date" : date
			},
			//dataType: 'json',
			success : function(data) {
				//alert(data);
				$("#calendar").html(data);

				$('#calendar').show();
			},
		}); */
	}
</script>

<!-- <style>
html, body {
  margin: 0;
  padding: 0;
  font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
  font-size: 14px;
}

#calendar {
  max-width: 900px;
  margin: 40px auto;
}
</style> -->


