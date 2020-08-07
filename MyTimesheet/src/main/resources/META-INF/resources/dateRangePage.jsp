<%@page import="com.liferay.famocom.erpcloud.model.CompanyPolicy"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long userId = td.getUserId();
Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
long employeeId = emp.getEmployeeId();
List<CompanyPolicy> cpList = new ArrayList<>();
DynamicQuery dynamicQuery2 = CompanyPolicyLocalServiceUtil.dynamicQuery();
Criterion criterion3 = null;
criterion3 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
dynamicQuery2.add(criterion3);
cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery2);
CompanyPolicy cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(cpList.get(0).getCompanyPolicyId());
int daysLocking = cp.getDaysLocking();


Calendar currCal = Calendar.getInstance();
currCal.setTime(new Date());
currCal.set(Calendar.HOUR_OF_DAY, 0);
currCal.set(Calendar.MINUTE, 0);
currCal.set(Calendar.SECOND, 0);
currCal.set(Calendar.MILLISECOND, 0);

Date currDate = currCal.getTime();
currCal.add(Calendar.DATE, -30);
Date givenPrevDate =  currCal.getTime();

List<Date> datesInRange = new ArrayList<>();
String list = ParamUtil.getString(request, "dateRange", StringPool.BLANK);
Calendar cal = new GregorianCalendar();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
cal.set(Calendar.WEEK_OF_MONTH, 1);
cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()+1);
Date firstDayFirstWeek = cal.getTime();
cal.add(Calendar.WEEK_OF_YEAR, 1);
cal.add(Calendar.DATE, -1);
Date lastDayFirstWeek = cal.getTime();
System.out.println("firstDayFirstWeek" + firstDayFirstWeek);
System.out.println("lastDayFirstWeek" + lastDayFirstWeek);

cal.set(Calendar.WEEK_OF_MONTH, 2);
cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()+1);
Date firstDaySecondWeek = cal.getTime();
cal.add(Calendar.WEEK_OF_YEAR, 1);
cal.add(Calendar.DATE, -1);
Date lastDaySecondWeek = cal.getTime();
System.out.println("firstDaySecondWeek" + firstDaySecondWeek);
System.out.println("lastDaySecondWeek" + lastDaySecondWeek);

cal.set(Calendar.WEEK_OF_MONTH, 3);
cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()+1);
Date firstDayThirdWeek = cal.getTime();
cal.add(Calendar.WEEK_OF_YEAR, 1);
cal.add(Calendar.DATE, -1);
Date lastDayThirdWeek = cal.getTime();
System.out.println("firstDayThirdWeek" + firstDayThirdWeek);
System.out.println("lastDayThirdWeek" + lastDayThirdWeek);

cal.set(Calendar.WEEK_OF_MONTH, 4);
cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()+1);
Date firstDayLastWeek = cal.getTime();
cal.add(Calendar.WEEK_OF_YEAR, 1);
cal.add(Calendar.DATE, -1);

Date lastDayLastWeek = cal.getTime();
System.out.println("firstDayLastWeek" + firstDayLastWeek);
System.out.println("lastDayLastWeek" + lastDayLastWeek);
cal.set(Calendar.WEEK_OF_MONTH, 5);
cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()+1);
Date firstDayNextWeek = cal.getTime();
cal.add(Calendar.WEEK_OF_YEAR, 1);
cal.add(Calendar.DATE, -1);

Date lastDayNextWeek = cal.getTime();
System.out.println("firstDayNextWeek" + firstDayNextWeek);
System.out.println("lastDayNextWeek" + lastDayNextWeek);

Calendar c = new GregorianCalendar();
c.set(Calendar.HOUR_OF_DAY, 0);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 0);
c.set(Calendar.MILLISECOND, 0);
//c.add(Calendar.WEEK_OF_YEAR, 1);
c.add(Calendar.MONTH, -1);
c.set(Calendar.WEEK_OF_MONTH, 5);
c.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek()+1);
Date firstDayLastWeekPrevMonth = c.getTime();
c.add(Calendar.WEEK_OF_YEAR, 1);
c.add(Calendar.DATE, -1);
Date lastDayLastWeekPrevMonth = c.getTime();
System.out.println("firstDayLastWeekPrevMonth" + firstDayLastWeekPrevMonth);
System.out.println("lastDayLastWeekPrevMonth" + lastDayLastWeekPrevMonth);

Calendar cal2 = new GregorianCalendar();
cal2.set(Calendar.HOUR_OF_DAY, 0);
cal2.set(Calendar.MINUTE, 0);
cal2.set(Calendar.SECOND, 0);
cal2.set(Calendar.MILLISECOND, 0);
//cal2.add(Calendar.WEEK_OF_YEAR, 1);
cal2.set(Calendar.DAY_OF_WEEK, cal2.getFirstDayOfWeek()+1);
Date firstDayCurrWeek = cal2.getTime();
cal2.add(Calendar.WEEK_OF_YEAR, 1);
cal2.add(Calendar.DATE, -1);
Date lastDayCurrWeek = cal2.getTime();
System.out.println("firstDayCurrWeek" + firstDayCurrWeek);
System.out.println("lastDayCurrWeek" + lastDayCurrWeek);

Calendar cal4 = new GregorianCalendar();
cal4.set(Calendar.HOUR_OF_DAY, 0);
cal4.set(Calendar.MINUTE, 0);
cal4.set(Calendar.SECOND, 0);
cal4.set(Calendar.MILLISECOND, 0);
//cal2.add(Calendar.WEEK_OF_YEAR, 1);
cal4.set(Calendar.DAY_OF_WEEK, cal2.getFirstDayOfWeek()+1);
cal4.add(Calendar.DATE, -35);
Date startDateOfWeek = cal4.getTime();
System.out.println("startDateOfWeek" + startDateOfWeek);

Calendar cal3 = new GregorianCalendar();
cal3.set(Calendar.HOUR_OF_DAY, 0);
cal3.set(Calendar.MINUTE, 0);
cal3.set(Calendar.SECOND, 0);
cal3.set(Calendar.MILLISECOND, 0);
cal3.set(Calendar.DAY_OF_MONTH, 1);
//cal3.add(Calendar.DATE, 1);

Date firstDateOfCurrentMonth = cal3.getTime();
System.out.println("firstDateOfCurrentMonth" + firstDateOfCurrentMonth);
cal3.set(Calendar.DATE, 15);
Date fifthnthDateOfCurrentMonth = cal3.getTime();
System.out.println("fifthnthDateOfCurrentMonth" + fifthnthDateOfCurrentMonth);
cal3.set(Calendar.DATE, 16);
Date sixthntDateOfCurrentMonth = cal3.getTime();
System.out.println("sixthntDateOfCurrentMonth" + sixthntDateOfCurrentMonth);
cal3.set(Calendar.DATE, cal3.getActualMaximum(Calendar.DATE));
Date lastDayCurrMon = cal3.getTime();
System.out.println("lastDayCurrMon" + lastDayCurrMon);

Calendar aCalendar = Calendar.getInstance();
aCalendar.set(Calendar.HOUR_OF_DAY, 0);
aCalendar.set(Calendar.MINUTE, 0);
aCalendar.set(Calendar.SECOND, 0);
aCalendar.set(Calendar.MILLISECOND, 0);
// add -1 month to current month
aCalendar.add(Calendar.MONTH, -2);
// set DATE to 1, so first date of previous month
aCalendar.set(Calendar.DATE, 1);

Date firstDateOfGivenMonth = aCalendar.getTime();
System.out.println("firstDateOfGivenMonth" + firstDateOfGivenMonth);

aCalendar.set(Calendar.DATE, 15);
Date fifthnthDateOfGivenMonth = aCalendar.getTime();
System.out.println("fifthnthDateOfGivenMonth" + fifthnthDateOfGivenMonth);
aCalendar.set(Calendar.DATE, 16);
Date sixthntDateOfGivenMonth = aCalendar.getTime();
System.out.println("sixthntDateOfGivenMonth" + sixthntDateOfGivenMonth);
aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DATE));
Date lastDayGivenMon = aCalendar.getTime();
System.out.println("lastDayGivenMon" + lastDayGivenMon);

aCalendar.add(Calendar.MONTH, 1);
//set DATE to 1, so first date of previous month
aCalendar.set(Calendar.DATE, 1);

Date firstDateOfPrevMonth = aCalendar.getTime();
System.out.println("firstDateOfPrevMonth" + firstDateOfPrevMonth);

aCalendar.set(Calendar.DATE, 15);
Date fifthnthDateOfPrevMonth = aCalendar.getTime();
System.out.println("fifthnthDateOfPrevMonth" + fifthnthDateOfPrevMonth);
aCalendar.set(Calendar.DATE, 16);
Date sixthntDateOfPrevMonth = aCalendar.getTime();
System.out.println("sixthntDateOfPrevMonth" + sixthntDateOfPrevMonth);
aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DATE));
Date lastDayPrevMon = aCalendar.getTime();
System.out.println("lastDayPrevMon" + lastDayPrevMon);

Calendar calendar = new GregorianCalendar();
calendar.set(Calendar.HOUR_OF_DAY, 0);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
calendar.set(Calendar.MILLISECOND, 0);


Calendar endCalendar = new GregorianCalendar();
endCalendar.set(Calendar.HOUR_OF_DAY, 0);
endCalendar.set(Calendar.MINUTE, 0);
endCalendar.set(Calendar.SECOND, 0);
endCalendar.set(Calendar.MILLISECOND, 0);
	if (cp != null) {
		if (cp.getCheckStatus() == 2) {
			calendar.setTime(startDateOfWeek);
			endCalendar.setTime(lastDayCurrWeek);
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRange.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		} else if(cp.getCheckStatus()==1){
			calendar.setTime(firstDateOfGivenMonth);
			endCalendar.setTime(lastDayCurrMon);
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRange.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		} else if(cp.getCheckStatus()==3){
			calendar.setTime(firstDateOfGivenMonth);
			endCalendar.setTime(lastDayCurrMon);
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRange.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		} else {
			calendar.setTime(givenPrevDate);
			endCalendar.setTime(currDate);
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRange.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		}
	}

	// first day
	Calendar cal1 = new GregorianCalendar();
	cal1.set(Calendar.HOUR_OF_DAY, 0);
	cal1.set(Calendar.MINUTE, 0);
	cal1.set(Calendar.SECOND, 0);
	cal1.set(Calendar.MILLISECOND, 0);
	cal1.add(Calendar.WEEK_OF_YEAR, -1);
	cal1.set(Calendar.DAY_OF_WEEK, cal1.getFirstDayOfWeek() + 1);
	Date firstDayPrevWeek = cal1.getTime();
	// last day of previous week
	cal1.set(Calendar.DAY_OF_WEEK, cal1.getFirstDayOfWeek() + 1);
	cal1.add(Calendar.DAY_OF_MONTH, -1);
	Date lastDayPrevWeek = cal1.getTime();
	System.out.println("firstDayPrevWeek" + firstDayPrevWeek);
	System.out.println("lastDayPrevWeek" + lastDayPrevWeek);

	SimpleDateFormat formatter = new SimpleDateFormat("EEE");
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMMM,yyyy");

	PortletURL timesheetListURL = renderResponse.createRenderURL();
	timesheetListURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	timesheetListURL.setParameter("jspPage", "/META-INF/resources/addTimesheetPage.jsp");

	PortletURL projtaskURL = renderResponse.createRenderURL();
	projtaskURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	projtaskURL.setParameter("jspPage", "/META-INF/resources/fetchTaskList.jsp");

	String biWeeklyView = formatter1.format(firstDateOfGivenMonth) +"-"+formatter1.format(fifthnthDateOfGivenMonth)
											+"_"+formatter1.format(sixthntDateOfGivenMonth) +"-"+formatter1.format(lastDayGivenMon)+"_"
											+formatter1.format(firstDateOfPrevMonth)+"-"+formatter1.format(fifthnthDateOfPrevMonth)+"_"
											+formatter1.format(sixthntDateOfPrevMonth)+"-"+formatter1.format(lastDayPrevMon)+"_"
											+formatter1.format(firstDateOfCurrentMonth)+"-"+formatter1.format(fifthnthDateOfCurrentMonth)+"_"
											+formatter1.format(sixthntDateOfCurrentMonth)+"-"+formatter1.format(lastDayCurrMon);

	System.out.println("biWeeklyView----" + biWeeklyView);
	String monthlyView = formatter1.format(firstDateOfGivenMonth) +"-"+formatter1.format(lastDayGivenMon)+"_"
										 +formatter1.format(firstDateOfPrevMonth)+"-"+formatter1.format(lastDayPrevMon)+"_"
										 +formatter1.format(firstDateOfCurrentMonth)+"-"+formatter1.format(lastDayCurrMon);
	System.out.println("monthlyView----" + monthlyView);
%>

<aui:row>
<aui:col span="2">
<label>Date Range</label>
</aui:col>
<aui:col span="4">
<%if(cp.getCheckStatus()==2){ %>
<aui:select onChange="timesheetList(this.value)" name="dateRange" required="true"
				label="" id="dateRange" value="">
			<%
				Date startRangeinDateFormat = null;
							Date endRangeinDateFormat = null;
							String startRange = "";
							String endRange = "";
							for (int i = 0; i < datesInRange.size(); i=i+7) {
								/* for (int j = 6; j < datesInRange.size(); j++) { */

									/* if(i==0){ */
									startRangeinDateFormat = datesInRange.get(i);
									endRangeinDateFormat = datesInRange.get(i+6);
									/* } *//*  else if(i>6){
											startRangeinDateFormat = datesInRange.get(i+1);
											endRangeinDateFormat = datesInRange.get(i+7);
											} */
									startRange = formatter1.format(startRangeinDateFormat);
									endRange = formatter1.format(endRangeinDateFormat);
									System.out.println("date range: " + startRange + "-" + endRange);
									String isSelect = "";
									if(startRangeinDateFormat.equals(firstDayCurrWeek) && endRangeinDateFormat.equals(lastDayCurrWeek)){
										isSelect = "selected";
									}
										
									System.out.println("isSelect: " + isSelect);
			%>
			<option value="<%=startRange+"-"+endRange%>" <%=isSelect%>><%=startRange+"-"+endRange%></option>
			<%
				/* } */
							}
			%>
		</aui:select>
<%} else if(cp.getCheckStatus()==3){%>
		<aui:select onChange="timesheetList(this.value)" name="dateRange" required="true"
				label="" id="dateRange" value="">
				<%
				Date startRangeinDateFormat = null;
				Date endRangeinDateFormat = null;
				String startRange = "";
				String endRange = "";
				String isSelect = "";
				for(int i=0;i<6;i++){
				String biWeekly = biWeeklyView.split("_")[i];
				String dateRange1 = biWeekly.split("-")[0];
				String dateRange2 = biWeekly.split("-")[1];
				startRange = dateRange1;
				endRange = dateRange2;
				startRangeinDateFormat = formatter1.parse(startRange);
				endRangeinDateFormat = formatter1.parse(endRange);
				
				if(currDate.before(fifthnthDateOfCurrentMonth)){
					if(startRangeinDateFormat.equals(firstDateOfCurrentMonth) && endRangeinDateFormat.equals(fifthnthDateOfCurrentMonth)){
						isSelect = "selected";
						System.out.println("inside if: " );
					} else {
						isSelect = "";
					}
				}else if(currDate.after(fifthnthDateOfCurrentMonth)){
					if(startRangeinDateFormat.equals(sixthntDateOfCurrentMonth) && endRangeinDateFormat.equals(lastDayCurrMon)){
						isSelect = "selected";
						System.out.println("inside else: " );
					} else {
						isSelect = "";
					}
				}
				
				System.out.println("isSelect: " + isSelect);
				%>
				<option value="<%=startRange+"-"+endRange%>" <%=isSelect%>><%=startRange+"-"+endRange%></option>
				<%} %>
		</aui:select>
<%} else if(cp.getCheckStatus()==1){%>
		
		<aui:select onChange="timesheetList(this.value)" name="dateRange" required="true"
				label="" id="dateRange" value="">
				<%
				Date startRangeinDateFormat = null;
				Date endRangeinDateFormat = null;
				String startRange = "";
				String endRange = "";
				String isSelect = "";
				for(int i=0;i<3;i++){
				String monthly = monthlyView.split("_")[i];
				String dateRange1 = monthly.split("-")[0];
				String dateRange2 = monthly.split("-")[1];
				startRange = dateRange1;
				endRange = dateRange2;
				startRangeinDateFormat = formatter1.parse(startRange);
				endRangeinDateFormat = formatter1.parse(endRange);
				
					if(startRangeinDateFormat.equals(firstDateOfCurrentMonth) && endRangeinDateFormat.equals(lastDayCurrMon)){
						isSelect = "selected";
					} else {
						isSelect = "";
					}
				
				System.out.println("isSelect: " + isSelect);
				%>
				<option value="<%=startRange+"-"+endRange%>" <%=isSelect%>><%=startRange+"-"+endRange%></option>
				<%} %>
		</aui:select>
		
		
<%} else {%>

	<aui:select onChange="timesheetList(this.value)" name="dateRange" required="true"
				label="" id="dateRange" value="">
			<%
				            Date startRangeinDateFormat = null;
							Date endRangeinDateFormat = null;
							String startRange = "";
							String endRange = "";
							for (int i = 0; i < datesInRange.size(); i++) {
								/* for (int j = 6; j < datesInRange.size(); j++) { */

									/* if(i==0){ */
									startRangeinDateFormat = datesInRange.get(i);
									endRangeinDateFormat = datesInRange.get(i);
									/* } *//*  else if(i>6){
											startRangeinDateFormat = datesInRange.get(i+1);
											endRangeinDateFormat = datesInRange.get(i+7);
											} */
									startRange = formatter1.format(startRangeinDateFormat);
									endRange = formatter1.format(endRangeinDateFormat);
									System.out.println("date range: " + startRange + "-" + endRange);
									String isSelect = "";
									if(startRangeinDateFormat.equals(currDate) && endRangeinDateFormat.equals(currDate)){
										isSelect = "selected";
									}
										
									System.out.println("isSelect: " + isSelect);
			%>
			<option value="<%=startRange+"-"+endRange%>" <%=isSelect%>><%=startRange%></option>
			<%
				/* } */
							}
			%>
		</aui:select>


<%} %>
</aui:col>


</aui:row>

<aui:input type="hidden" name="list" id="list"></aui:input>

<div id="tsList">
</div>


<script type="text/javascript">


$(document).ready(function() {
	<%String startDate = "";
			String endDate = "";
			if (cp.getCheckStatus() == 2) {
				startDate = formatter1.format(firstDayCurrWeek);
				endDate = formatter1.format(lastDayCurrWeek);
			} else if (cp.getCheckStatus() == 3) {
				if (currDate.before(fifthnthDateOfCurrentMonth)) {
					startDate = formatter1.format(firstDateOfCurrentMonth);
					endDate = formatter1.format(fifthnthDateOfCurrentMonth);
				} else if (currDate.after(fifthnthDateOfCurrentMonth)) {
					startDate = formatter1.format(sixthntDateOfCurrentMonth);
					endDate = formatter1.format(lastDayCurrMon);
				}

			} else if (cp.getCheckStatus() == 1) {
				startDate = formatter1.format(firstDateOfCurrentMonth);
				endDate = formatter1.format(lastDayCurrMon);

			} else {
				startDate = formatter1.format(currDate);
				endDate = formatter1.format(currDate);
			}%>
    var currentRange = "<%=startDate+"-"+endDate%>";
     //output.textContent = thisMonth;
     //var select=output.textContent;
    /* document.getElementById('date').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear(); /////document.getElementById('date').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear()*/
	//alert("select "+monthYear);
	timesheetList(currentRange);
	//attendanceList(select);
});

function timesheetList(list){
	//alert(list);
   url="<%=timesheetListURL.toString()%>";
		$.ajax({
			type : "post",
			url : url,
			data : {
				"<portlet:namespace/>list" : list	
			},
			success : function(data) {
				$("#tsList").html(data);
			}
		});
	}


function changeProj(val,id){
	var url="<%=projtaskURL.toString()%>"
	//var i = 1;
	var rowId = id.replace("_MyTimesheet_INSTANCE_nXEojswcmjM0_selectProject",'');
	//console.log("i before ajax---"+i);
	console.log("val---"+val);
	console.log("id---"+id);
	console.log("rowId---"+rowId);
	var projectId = $("_MyTimesheet_INSTANCE_nXEojswcmjM0_selectProject"+rowId).val();
	console.log("rowId---"+rowId);

	$.ajax({
		url : url,
		data : {
			"<portlet:namespace/>val" : val
		},//person id to sent
		type : 'POST',
		success : function(data) {
			$("#selectTask"+rowId).html(data);
			//console.log("data---"+data);
			//console.log("i---"+i);
		},
	});
}

function totalHours(id){
	console.log("hrs id--"+id);
	var hrId = id;
	
}

</script>
