<%@page
	import="com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetMaster"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.model.CompanyPolicy"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.theme.PortletDisplay"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectTask"%>
<%@page import="com.liferay.famocom.erpcloud.model.TimeSheetEntry"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.AddTeamMember"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
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
<liferay-ui:error key="error"
	message="You have already worked 8 hrs in the day!"></liferay-ui:error>
<%
    SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatter4 = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
    //SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy/MM/dd");
	String portletId = portletDisplay.getId();
	Date date = new Date();
	String submitVal = ParamUtil.getString(request, "submitVal", StringPool.BLANK);
	String listValue = ParamUtil.getString(request, "list", StringPool.BLANK);
	System.out.println("listValue...." + listValue);
	String startRange = listValue.split("-")[0];
	System.out.println("startRange...." + startRange);
	String endRange = listValue.split("-")[1];
	System.out.println("endRange...." + endRange);
	Date startDate = new SimpleDateFormat("dd MMMM,yyyy").parse(startRange);
	System.out.println("startDate...." + startDate);
	Date endDate = new SimpleDateFormat("dd MMMM,yyyy").parse(endRange);
	System.out.println("endDate...." + endDate);
	boolean editURL = false;
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = td.getUserId();
	Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
	long employeeId = emp.getEmployeeId();
	long timesheetId = ParamUtil.getLong(request, "timesheetId");
	String val = ParamUtil.getString(request, "selectProject", StringPool.BLANK);
	System.out.println("val...." + val);
	TimeSheetEntry timeSheetEntry = null;
	try {
		if (timesheetId != 0) {
			//System.out.println("inside if....");
			editURL = true;
			try {
				timeSheetEntry = TimeSheetEntryLocalServiceUtil.getTimeSheetEntry(timesheetId);
				System.out.println("timeSheetEntry...." + timeSheetEntry);
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	List<Date> datesInRange = new ArrayList<>();

	Calendar cal = new GregorianCalendar();
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	cal.set(Calendar.DAY_OF_MONTH, 1);
	Date firstDayCurrMon = cal.getTime();
	System.out.println("firstDayCurrMon" + firstDayCurrMon);
	cal.set(Calendar.DAY_OF_MONTH, 15);
	Date fiftntDayCurrMon = cal.getTime();
	System.out.println("fiftntDayCurrMon" + fiftntDayCurrMon);
	cal.set(Calendar.DAY_OF_MONTH, 16);
	Date sixtntDayCurrMon = cal.getTime();
	System.out.println("sixtntDayCurrMon" + sixtntDayCurrMon);
	cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
	Date lastDayCurrMon = cal.getTime();
	System.out.println("lastDayCurrMon" + lastDayCurrMon);

	Calendar prevDaycal = Calendar.getInstance();
	prevDaycal.setTime(date);
	prevDaycal.set(Calendar.HOUR_OF_DAY, 0);
	prevDaycal.set(Calendar.MINUTE, 0);
	prevDaycal.set(Calendar.SECOND, 0);
	prevDaycal.set(Calendar.MILLISECOND, 0);
	prevDaycal.add(Calendar.DAY_OF_MONTH, -1);

	Date prevDay = prevDaycal.getTime();

	Calendar currCal = Calendar.getInstance();
	currCal.setTime(new Date());
	currCal.set(Calendar.HOUR_OF_DAY, 0);
	currCal.set(Calendar.MINUTE, 0);
	currCal.set(Calendar.SECOND, 0);
	currCal.set(Calendar.MILLISECOND, 0);

	Date currDate = currCal.getTime();
	System.out.println("currDate----" + currDate);

	Calendar aCalendar = Calendar.getInstance();
	aCalendar.set(Calendar.HOUR_OF_DAY, 0);
	aCalendar.set(Calendar.MINUTE, 0);
	aCalendar.set(Calendar.SECOND, 0);
	aCalendar.set(Calendar.MILLISECOND, 0);
	// add -1 month to current month
	aCalendar.add(Calendar.MONTH, -1);
	// set DATE to 1, so first date of previous month
	aCalendar.set(Calendar.DATE, 1);

	Date firstDateOfPreviousMonth = aCalendar.getTime();
	System.out.println("firstDateOfPreviousMonth" + firstDateOfPreviousMonth);
	aCalendar.set(Calendar.DATE, 16);
	Date sixthntDateOfPreviousMonth = aCalendar.getTime();
	System.out.println("sixthntDateOfPreviousMonth" + sixthntDateOfPreviousMonth);
	// set actual maximum date of previous month
	aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	//read it
	Date lastDateOfPreviousMonth = aCalendar.getTime();
	System.out.println("lastDateOfPreviousMonth" + lastDateOfPreviousMonth);

	Calendar cal2 = new GregorianCalendar();
	cal2.set(Calendar.HOUR_OF_DAY, 0);
	cal2.set(Calendar.MINUTE, 0);
	cal2.set(Calendar.SECOND, 0);
	cal2.set(Calendar.MILLISECOND, 0);
	cal2.add(Calendar.WEEK_OF_YEAR, -1);
	cal2.set(Calendar.DAY_OF_WEEK, cal2.getFirstDayOfWeek() + 1);
	Date firstDayPrevWeek = cal2.getTime();
	System.out.println("firstDayPrevWeek" + firstDayPrevWeek);

	Calendar cal3 = new GregorianCalendar();
	cal3.set(Calendar.HOUR_OF_DAY, 0);
	cal3.set(Calendar.MINUTE, 0);
	cal3.set(Calendar.SECOND, 0);
	cal3.set(Calendar.MILLISECOND, 0);
	cal3.set(Calendar.DAY_OF_WEEK, cal3.getFirstDayOfWeek() + 1);
	cal3.add(Calendar.DAY_OF_MONTH, -1);
	Date lastDayPrevWeek = cal3.getTime();
	System.out.println("lastDayPrevWeek" + lastDayPrevWeek);

	List<CompanyPolicy> cpList = new ArrayList<>();
	/*List<TimeSheetEntry> tsList = new ArrayList<>();
	List<TimeSheetEntry> tsList1 = new ArrayList<>();*/
	List<Date> datesInRangeToLock = new ArrayList<>();
	List<Date> datesToLock = new ArrayList<>();
	List<Date> datesToLockDaily = new ArrayList<>();
	DynamicQuery dynamicQuery2 = CompanyPolicyLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
	dynamicQuery2.add(criterion3);
	cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery2);
	CompanyPolicy cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(cpList.get(0).getCompanyPolicyId());
	int daysLocking = cp.getDaysLocking();
	String startDateOfLockingRange = null;
	String endDateOfLockingRange = null;
	String startDateForLocking = null;
	String endDateForLocking = null;
	if (cp != null) {

		if (cp.getCheckStatus() == 1) {
			Calendar calendar = new GregorianCalendar();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.setTime(firstDateOfPreviousMonth);
			
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.set(Calendar.HOUR_OF_DAY, 0);
			endCalendar.set(Calendar.MINUTE, 0);
			endCalendar.set(Calendar.SECOND, 0);
			endCalendar.set(Calendar.MILLISECOND, 0);
			endCalendar.setTime(lastDateOfPreviousMonth);
			startDateOfLockingRange =  formatter3.format(calendar.getTime());
			endDateOfLockingRange = formatter3.format(endCalendar.getTime());
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRangeToLock.add(result);
				calendar.add(Calendar.DATE, 1);
			}

			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);// this takes current date
			c.set(Calendar.DAY_OF_MONTH, 1);
			Date firstDayCurrMonth = c.getTime();
			c.set(Calendar.DAY_OF_MONTH, daysLocking);
			Date lockingDay = c.getTime();
			calendar.setTime(firstDayCurrMonth);
			endCalendar.setTime(lockingDay);
			startDateForLocking = formatter3.format(calendar.getTime());
			endDateForLocking = formatter3.format(endCalendar.getTime());
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesToLock.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		} else if (cp.getCheckStatus() == 2) {
			Calendar calendar = new GregorianCalendar();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.setTime(firstDayPrevWeek);
			if (daysLocking > 7) {
				calendar.add(Calendar.DATE, -(daysLocking - 7));
				System.out.println("---------" + calendar.getTime());
			}
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.set(Calendar.HOUR_OF_DAY, 0);
			endCalendar.set(Calendar.MINUTE, 0);
			endCalendar.set(Calendar.SECOND, 0);
			endCalendar.set(Calendar.MILLISECOND, 0);
			endCalendar.setTime(lastDayPrevWeek);
			
			startDateOfLockingRange =  formatter3.format(calendar.getTime());
			endDateOfLockingRange = formatter3.format(endCalendar.getTime());
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRangeToLock.add(result);
				calendar.add(Calendar.DATE, 1);
			}

			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);
			Date firstDayCurrWeek = c.getTime();
			//c.set(Calendar.DAY_OF_WEEK, daysLocking+1);
			c.add(Calendar.DATE, daysLocking-1);
			Date lockingDay = c.getTime();
			calendar.setTime(firstDayCurrWeek);
			endCalendar.setTime(lockingDay);
			
			startDateForLocking = formatter3.format(calendar.getTime());
			endDateForLocking = formatter3.format(endCalendar.getTime());

			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesToLock.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		} else if (cp.getCheckStatus() == 3) {
			if (currDate.equals(firstDayCurrMon) || currDate.after(firstDayCurrMon) && currDate.before(fiftntDayCurrMon) || currDate.equals(fiftntDayCurrMon)) {
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				calendar.setTime(sixthntDateOfPreviousMonth);
				if (daysLocking > 15) {
					calendar.add(Calendar.DATE, -(daysLocking - 15));
					System.out.println("---------" + calendar.getTime());
				}

				Calendar endCalendar = new GregorianCalendar();
				endCalendar.set(Calendar.HOUR_OF_DAY, 0);
				endCalendar.set(Calendar.MINUTE, 0);
				endCalendar.set(Calendar.SECOND, 0);
				endCalendar.set(Calendar.MILLISECOND, 0);
				endCalendar.setTime(lastDateOfPreviousMonth);
				
				startDateOfLockingRange =  formatter3.format(calendar.getTime());
				endDateOfLockingRange = formatter3.format(endCalendar.getTime());
				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesInRangeToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.setTime(firstDayCurrMon);
				Date firstDay = c.getTime();
				c.add(Calendar.DATE, daysLocking-1);
				Date lockingDay = c.getTime();
				calendar.setTime(firstDay);
				endCalendar.setTime(lockingDay);
				
				startDateForLocking = formatter3.format(calendar.getTime());
				endDateForLocking = formatter3.format(endCalendar.getTime());

				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
			} else {
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				calendar.setTime(firstDayCurrMon);
				if (daysLocking > 15) {
					calendar.add(Calendar.DATE, -(daysLocking - 15));
					System.out.println("---------" + calendar.getTime());
				}

				Calendar endCalendar = new GregorianCalendar();
				endCalendar.set(Calendar.HOUR_OF_DAY, 0);
				endCalendar.set(Calendar.MINUTE, 0);
				endCalendar.set(Calendar.SECOND, 0);
				endCalendar.set(Calendar.MILLISECOND, 0);
				endCalendar.setTime(fiftntDayCurrMon);
				
				startDateOfLockingRange =  formatter3.format(calendar.getTime());
				endDateOfLockingRange = formatter3.format(endCalendar.getTime());
				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesInRangeToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.setTime(sixtntDayCurrMon);
				Date sixthntDay = c.getTime();
				c.add(Calendar.DATE, daysLocking-1);
				Date lockingDay = c.getTime();
				calendar.setTime(sixthntDay);
				endCalendar.setTime(lockingDay);
				
				startDateForLocking = formatter3.format(calendar.getTime());
				endDateForLocking = formatter3.format(endCalendar.getTime());

				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
			}

		} else {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(prevDay);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(prevDay);
			if (daysLocking > 1) {
				calendar.add(Calendar.DATE, -(daysLocking - 1));
				System.out.println("---------" + calendar.getTime());
			}
			endCalendar.set(Calendar.HOUR_OF_DAY, 0);
			endCalendar.set(Calendar.MINUTE, 0);
			endCalendar.set(Calendar.SECOND, 0);
			endCalendar.set(Calendar.MILLISECOND, 0);
			
			startDateOfLockingRange =  formatter3.format(calendar.getTime());
			endDateOfLockingRange = formatter3.format(endCalendar.getTime());
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesInRangeToLock.add(result);
				calendar.add(Calendar.DATE, 1);
			}

			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			Date currDateIncre1 = c.getTime();
			c.add(Calendar.DATE, daysLocking - 1);
			calendar.setTime(currDateIncre1);
			Date lockingDay = c.getTime();
			endCalendar.setTime(lockingDay);
			
			startDateForLocking = formatter3.format(calendar.getTime());
			endDateForLocking = formatter3.format(endCalendar.getTime());
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				Date result = calendar.getTime();
				datesToLock.add(result);
				calendar.add(Calendar.DATE, 1);
			}
		}
	}
	/* Calendar c = Calendar.getInstance();
	
	// Set the calendar to monday of the current week
	c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	
	   System.out.println();
	// Print dates of the current week starting on Monday
	  DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
	  System.out.println(df.format(c.getTime()));
	   for (int i = 0; i <6; i++) {
	    c.add(Calendar.DATE, 1);
	      }
	   System.out.println(df.format(c.getTime()));
		System.out.println(); */

	/* Calendar cal = new GregorianCalendar();
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	cal.set(Calendar.MILLISECOND, 0);
	cal.set(Calendar.WEEK_OF_MONTH, 1);
	cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek());
	Date firstDayFirstWeek = cal.getTime();
	cal.add(Calendar.WEEK_OF_YEAR, 1);
	cal.add(Calendar.DATE, -1);
	Date lastDayFirstWeek = cal.getTime();
	System.out.println("firstDayFirstWeek" + firstDayFirstWeek);
	System.out.println("lastDayFirstWeek" + lastDayFirstWeek);
	
	cal.set(Calendar.WEEK_OF_MONTH, 2);
	cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek());
	Date firstDaySecondWeek = cal.getTime();
	cal.add(Calendar.WEEK_OF_YEAR, 1);
	cal.add(Calendar.DATE, -1);
	Date lastDaySecondWeek = cal.getTime();
	System.out.println("firstDaySecondWeek" + firstDaySecondWeek);
	System.out.println("lastDaySecondWeek" + lastDaySecondWeek);
	
	cal.set(Calendar.WEEK_OF_MONTH, 3);
	cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek());
	Date firstDayThirdWeek = cal.getTime();
	cal.add(Calendar.WEEK_OF_YEAR, 1);
	cal.add(Calendar.DATE, -1);
	Date lastDayThirdWeek = cal.getTime();
	System.out.println("firstDayThirdWeek" + firstDayThirdWeek);
	System.out.println("lastDayThirdWeek" + lastDayThirdWeek);
	
	cal.set(Calendar.WEEK_OF_MONTH, 4);
	cal.set(Calendar.DAY_OF_WEEK,cal.getFirstDayOfWeek());
	Date firstDayLastWeek = cal.getTime();
	cal.add(Calendar.WEEK_OF_YEAR, 1);
	cal.add(Calendar.DATE, -1);
	
	Date lastDayLastWeek = cal.getTime();
	System.out.println("firstDayLastWeek" + firstDayLastWeek);
	System.out.println("lastDayLastWeek" + lastDayLastWeek);
	
	Calendar cal2 = new GregorianCalendar();
	cal2.set(Calendar.HOUR_OF_DAY, 0);
	cal2.set(Calendar.MINUTE, 0);
	cal2.set(Calendar.SECOND, 0);
	cal2.set(Calendar.MILLISECOND, 0);
	//cal2.add(Calendar.WEEK_OF_YEAR, 1);
	cal2.set(Calendar.DAY_OF_WEEK, cal2.getFirstDayOfWeek());
	Date firstDayCurrWeek = cal2.getTime();
	cal2.add(Calendar.WEEK_OF_YEAR, 1);
	cal2.add(Calendar.DATE, -1);
	Date lastDayCurrWeek = cal2.getTime();
	System.out.println("firstDayCurrWeek" + firstDayCurrWeek);
	System.out.println("lastDayCurrWeek" + lastDayCurrWeek); */
	List<TimeSheetEntry> tsEntryList = new ArrayList<>();
	List<AddTeamMember> atmList = new ArrayList<>();
	try {
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
		atmList = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("atmList: " + atmList.size());
	} catch (Exception e) {
	}

	List<ProjectMaster> pmList = new ArrayList<>();
	List<ProjectMaster> pmList1 = new ArrayList<>();
	try {
		for (int i = 0; i < atmList.size(); i++) {
			DynamicQuery dynamicQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(atmList.get(i).getProjectId()));
			pmList = ProjectMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
			//System.out.println("atmList: " + atmList.size());
			pmList1.addAll(pmList);
		}
	} catch (Exception e) {
	}

	List<ProjectTask> findTask = new ArrayList<ProjectTask>();

	try {
		if (timesheetId != 0) {
			DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(timeSheetEntry.getProjectId()));
			findTask = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("taskList in timesheet entry: " + findTask.size());
		}
	} catch (Exception e) {
	}

	Calendar calendar = new GregorianCalendar();
	calendar.set(Calendar.HOUR_OF_DAY, 0);
	calendar.set(Calendar.MINUTE, 0);
	calendar.set(Calendar.SECOND, 0);
	calendar.set(Calendar.MILLISECOND, 0);
	calendar.setTime(startDate);

	Calendar endCalendar = new GregorianCalendar();
	endCalendar.set(Calendar.HOUR_OF_DAY, 0);
	endCalendar.set(Calendar.MINUTE, 0);
	endCalendar.set(Calendar.SECOND, 0);
	endCalendar.set(Calendar.MILLISECOND, 0);
	endCalendar.setTime(endDate);

	while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
		Date result = calendar.getTime();
		datesInRange.add(result);
		calendar.add(Calendar.DATE, 1);
	}
	System.out.println("datesInRange......" + datesInRange);
	System.out.println("datesInRangeToLock..." + datesInRangeToLock);
	System.out.println("datesToLock..." + datesToLock);
	PortletURL projtaskURL = renderResponse.createRenderURL();
	projtaskURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	projtaskURL.setParameter("jspPage", "/META-INF/resources/fetchTaskList.jsp");

	PortletURL samePageURL = renderResponse.createRenderURL();
	samePageURL.setWindowState(LiferayWindowState.POP_UP);
	samePageURL.setParameter("listValue", listValue);
	samePageURL.setParameter("jspPage", "/META-INF/resources/addTimesheetPage.jsp");

	PortletURL assignURL = renderResponse.createRenderURL();
	assignURL.setWindowState(LiferayWindowState.POP_UP);
	//assignURL.setParameter("projectId",String.valueOf(projectId));
	assignURL.setParameter("jspPage", "/META-INF/resources/fillTimesheet.jsp");
	/* assignURL.setParameter("documentId", String.valueOf(documentId));
	assignURL.setParameter("notifyId", String.valueOf(curRow.getNotifyIdSendId()) );  */
	//String popup ="javascript:popup('"+ assignURL.toString()+"','hours1_04');";
	SimpleDateFormat formatter = new SimpleDateFormat("dd EEE");
	SimpleDateFormat formatter1 = new SimpleDateFormat("MMMM dd,yyyy");
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd");
	String disabledUrl = "javascript:popup(";
	String popup = "";
	for (int i = 0; i < datesInRange.size(); i++) {
		Date weekDate = datesInRange.get(i);
		String weekDateinString = formatter2.format(weekDate);
		assignURL.setParameter("id", "hours1_"+weekDateinString);
		System.out.println("assignURL---"+assignURL);
		popup ="javascript:popup('"+ assignURL.toString()+"');";
	}

	String projectOption = StringPool.BLANK;
	for (ProjectMaster projectMaster : pmList1) {
		String selected = StringPool.BLANK;
		/* if(projectMaster.getProjectId()==timeSheetEntry.getProjectId()){
			selected="selected";
			//System.out.println("====ratingMaster.getRatingId()==="+ratingMaster.getRatingId()+"====getGoalMasterEmpRating==="+getGoalMasterEmpRating);
		} */
		projectOption = projectOption + "<option value='" + projectMaster.getProjectId() + "' " + selected
				+ " >" + "" + projectMaster.getProjectName() + "</option>";
		System.out.println("projectOption====>>>> : " + projectOption);
	}
	String submitStatus = "0";
	List<TimeSheetMaster> tsMasterList = new ArrayList<>();
	DynamicQuery dynamicQuery = TimeSheetMasterLocalServiceUtil.dynamicQuery();
	Criterion criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
	criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("fromDate", startDate));
	criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("toDate", endDate));
	dynamicQuery.add(criterion);
	tsMasterList = TimeSheetMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("tsMasterList====>>>> : " + tsMasterList);
	if(Validator.isNotNull(tsMasterList) || tsMasterList.size()!=0 || !tsMasterList.isEmpty()){
		for(int i=0;i<tsMasterList.size();i++){
			submitStatus = String.valueOf(tsMasterList.get(i).getSubmitStatus());
		}
	}
	String totRows = "";
	List<Object[]> distinctTimesheetList = TimeSheetEntryLocalServiceUtil
			.getDistinctTimesheetListByEmployeeIdAndDateRange(emp.getEmployeeId(), startDate, endDate);
	if(distinctTimesheetList.size()!=0 || Validator.isNotNull(distinctTimesheetList) || !distinctTimesheetList.isEmpty()){
		for(int j=1;j<=distinctTimesheetList.size();j++){
			totRows =  j + "," + totRows;
		}
	}
	System.out.println("totRows====>>>> : " + totRows);
	
	String tsStr = StringPool.BLANK;
	String dateListInAnotherFormat = "";
	String totalDates = "";
	if(datesInRange.size()!=0 || Validator.isNotNull(datesInRange) || !datesInRange.isEmpty()){
		for(int j=0;j<datesInRange.size();j++){
			totalDates = String.valueOf(formatter4.format(datesInRange.get(j)))+ "," + totalDates;
		}
	}
	System.out.println("totalDates====>>>> : " + totalDates);
	
	int a = 0;
	dynamicQuery = null;
	dynamicQuery = TimeSheetMasterLocalServiceUtil.dynamicQuery();
	criterion = null;
	criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
	criterion = RestrictionsFactoryUtil.and(criterion,
			RestrictionsFactoryUtil.eq("fromDate", startDate));
	criterion = RestrictionsFactoryUtil.and(criterion,
			RestrictionsFactoryUtil.eq("toDate", endDate));
	criterion = RestrictionsFactoryUtil.and(criterion,
			RestrictionsFactoryUtil.eq("submitStatus", 3));
	dynamicQuery.add(criterion);
	List<TimeSheetMaster> approveRejectCheckList = TimeSheetMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println("approveRejectCheckList====>>>> : " + approveRejectCheckList);
%>

<aui:row>
	<aui:col span="4"></aui:col>
	<aui:col span="4">
		<%
			Date weekDaysinDateFormat = datesInRange.get(0);
					Date weekDaysinDateFormat1 = datesInRange.get(datesInRange.size() - 1);
					String weekDays = formatter1.format(weekDaysinDateFormat);
					String weekDays1 = formatter1.format(weekDaysinDateFormat1);
					if (!weekDaysinDateFormat.equals(weekDaysinDateFormat1)) {
		%>

		<h4><%=weekDays + " to " + weekDays1%></h4>
		<%
			} else {
		%>
		<h4><%=weekDays%></h4>
		<%
			}
		%>

	</aui:col>

</aui:row>
<aui:row>
	<aui:col span="11"></aui:col>
	<aui:col span="1" cssClass="paddingBottom15p">
		<%
		String disabled = "";
			if (Integer.parseInt(submitStatus) == 1) {
				disabled = "disabled";		
			}
			if(approveRejectCheckList.size()!=0 && Validator.isNotNull(approveRejectCheckList)){
			if (approveRejectCheckList.get(a).getStatus() == 1) {
				disabled = "";
			} else {
				disabled = "disabled";
			}
			}
		%>
		<button class="btn btn-warning btn-sm addBtn" id="addBtn" <%=disabled %>>Add</button>
	</aui:col>
</aui:row>
<portlet:resourceURL id="exportAction" var="exportURL">
	<portlet:param name="<%=Constants.CMD%>" value="exportURL" />
	<portlet:param name="listValue" value="<%=listValue%>" />
	<portlet:param name="popup" value="<%=popup%>" />
	<portlet:param name="startDateOfLockingRange"
		value="<%=startDateOfLockingRange%>" />
	<portlet:param name="endDateOfLockingRange"
		value="<%=endDateOfLockingRange%>" />
	<portlet:param name="startDateForLocking"
		value="<%=startDateForLocking%>" />
	<portlet:param name="endDateForLocking" value="<%=endDateForLocking%>" />
	<portlet:param name="submitStatus" value="<%=submitStatus%>" />
</portlet:resourceURL>
<portlet:actionURL name="addTimesheet" var="addTimesheetURL" />
<aui:form name="addTimesheet" action="<%=addTimesheetURL.toString()%>"
	method="post" entype="multipart/form-data">
	<%-- <aui:input name="travelId" type="hidden" value="<%=travelId %>"></aui:input>
<aui:input name="employeeId" type="hidden" value="<%=employeeId %>"></aui:input> --%>
	<aui:input label="U" name="fileIdValue" value="1" type="hidden" />
	<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
	<aui:input name="projectId" type="hidden" value=""></aui:input>
	<aui:input name="actualId" id="actualId" type="hidden" value=""></aui:input>
	<input name="<portlet:namespace/>projIdList" id="projIdList"
		type="hidden" label="" value=""></input>
	<input name="<portlet:namespace/>counter" id="counter" type="hidden"
		label="" value="1"></input>
	<aui:input name="listValue" id="listValue" type="hidden"
		value="<%=listValue%>"></aui:input>
	<aui:input name="popup" id="popup" type="hidden" value="<%=popup%>"></aui:input>
	<aui:input name="startDateOfLockingRange" id="startDateOfLockingRange"
		type="hidden" value="<%=startDateOfLockingRange%>"></aui:input>
	<aui:input name="endDateOfLockingRange" id="endDateOfLockingRange"
		type="hidden" value="<%=endDateOfLockingRange%>"></aui:input>
	<aui:input name="startDateForLocking" id="startDateForLocking"
		type="hidden" value="<%=startDateForLocking%>"></aui:input>
	<aui:input name="endDateForLocking" id="endDateForLocking"
		type="hidden" value="<%=endDateForLocking%>"></aui:input>
	<input name="<portlet:namespace/>projId" id="projId" type="hidden"
		label="" value=""></input>
	<input name="<portlet:namespace/>taskId" id="taskId" type="hidden"
		label="" value=""></input>
	<input name="<portlet:namespace/>rowId" id="rowId" type="hidden"
		label="" value=""></input>
	<input name="<portlet:namespace/>allRowIds" id="allRowIds"
		type="hidden" label="" value=""></input>
	<input name="<portlet:namespace/>totalRows" id="totalRows"
		type="hidden" label=""
		value="<%=distinctTimesheetList!=null?totRows:""%>"></input>
	<aui:input id="submitVal" name="submitVal" type="hidden"
		value="<%=submitVal %>"></aui:input>
	<aui:input id="submitStatus" name="submitStatus" type="hidden"
		value="<%=submitStatus %>"></aui:input>
	<aui:row>
		<%-- <aui:col span="6"></aui:col>
<aui:col span="6">
<%for(int i=0;i<datesInRange.size();i++){ 
Date weekDaysinDateFormat = datesInRange.get(i);
String weekDays = formatter.format(weekDaysinDateFormat);
%>
	<label><h4><%= weekDays%></h4></label>
<%} %>

</aui:col> --%>
		<aui:col span="12">
			<table class="table table-bordered table-striped" id="expUrl">
				<thead>
					<tr>
						<th>&nbsp&nbspProject&nbsp&nbsp</th>
						<th>&nbsp&nbspTask&nbsp&nbsp</th>
						<%
							for (int i = 0; i < datesInRange.size(); i++) {
											Date weekDaysinDateFormat = datesInRange.get(i);
											String weekDays = formatter.format(weekDaysinDateFormat);
						%>
						<th>&nbsp&nbsp<%=weekDays%>&nbsp&nbsp</th>
						
						<%
							}
						%>
						<th>Action</th>
					</tr>
					
				</thead>
				<tfoot>
					<tr>
						<td></td>
						<td style="padding-bottom: 20px;">
						&nbsp&nbspTotal Hours:&nbsp&nbsp</td>
						<%
							for (int i = 0; i < datesInRange.size(); i++) {
								Date weekDaysinDateFormat = datesInRange.get(i);
								String weekDays = formatter2.format(weekDaysinDateFormat);
								dateListInAnotherFormat = weekDays + "," + dateListInAnotherFormat;
								dynamicQuery = null;
								dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
										.add(RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId()))
										.add(RestrictionsFactoryUtil.eq("entryDate", weekDaysinDateFormat))
										// .setProjection(ProjectionFactoryUtil.property("hours"));
										.setProjection(ProjectionFactoryUtil.sum("hours"));

								List<TimeSheetEntry> list = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
								int s = 0;
						%>
						<td>&nbsp&nbsp<input
							name="<portlet:namespace />totalHours_<%=weekDays %>"
							id="totalHours_<%=weekDays %>" type="text"
							value="<%=Validator.isNotNull(list)? list.get(s) : " "%>"
							readonly="readonly" size="10" maxlength="8">&nbsp&nbsp
						</td>
						<%
							}
						%>
						<td></td>
					</tr>
				</tfoot>
				<tbody></tbody>
			</table>
		</aui:col>
	</aui:row>
	<%-- <aui:row>
		<aui:col span="3">
			<aui:input type="radio" name="status"
				checked="<%=isStatus == false%>" label="Reject" value="2"></aui:input>
		</aui:col>
		<aui:col span="3">
			<aui:input type="radio" name="status" label="Approve"
				checked="<%=isStatus == true%>" value="1"></aui:input>
		</aui:col>
	</aui:row> --%>

	<aui:button-row>
		<aui:button name="save" type="submit" onClick="javascript:setVal(0)"
			value="Save as Draft"></aui:button>
		<%
		boolean disabled = false;
			if (Integer.parseInt(submitStatus) == 1) {
				disabled = true;	
			}
			if(approveRejectCheckList.size()!=0 && Validator.isNotNull(approveRejectCheckList)){
			if (approveRejectCheckList.get(a).getStatus() == 1) {
				disabled = false;
			} else {
				disabled = true;
			}
			}
		%>
		<aui:button name="finalSubmit" type="submit"
			onClick="javascript:setVal(1)" value="Final Submit" disabled="<%=disabled %>"></aui:button>
	</aui:button-row>
</aui:form>


<%-- <aui:script use="liferay-auto-fields">
	new Liferay.AutoFields({
		contentBox : '#auto-fields-container',
		fieldIndexes : '<portlet:namespace />rowIndexes',
		on : {
			'clone' : function(event) {
				console.log('clone');
				console.log(event);
				var no = $('#<portlet:namespace />fileIdValue').val();
				//alert("no " + no);
				no++;
				var latestfileId = 'selectProject' + no;
				var latestfileId1 = 'selectTask' + no;
				console.log("latestfileId----"+latestfileId);
				console.log("latestfileId1----"+latestfileId1);
				//no++;
				//alert("no1 "+latestfileId);
				//alert("no1 "+'#<portlet:namespace />'+latestfileId);
				$('#<portlet:namespace />' + latestfileId).val('');
				$('#<portlet:namespace />' + latestfileId1).val('');
			},
			'delete' : function(event) {
				console.log('delete');
				console.log(event);

			}
		},
		sortable : true,
		sortableHandle : '.lfr-form-row'
	}).render();

</aui:script> --%>



<%-- <aui:script use="liferay-auto-fields">

	new Liferay.AutoFields({
		contentBox : '#auto-fields-container',
		fieldIndexes : '<portlet:namespace />rowIndexes',
		on : {
			'clone' : function(event) {
				console.log('clone');
				console.log(event);
				var no = $('#<portlet:namespace />fileIdValue').val();
				//var firstAttId = $('#<portlet:namespace />dropdownTaskId').val();
				//console.log('firstAttId'+firstAttId);
				//	alert("no " + no);
				var previousFileId = 'selectTask' + no;
				//  alert($('#<portlet:namespace />' + latestfileId).val());
				no++;
				var latestfileId = 'selectTask' + no;
				console.log('previousFileId'+previousFileId);
				console.log('latestfileId'+latestfileId);
				//	alert("no1 "+latestfileId);
				//	alert("no1 "+'#<portlet:namespace />'+latestfileId);
				$('#<portlet:namespace />' + latestfileId).val('');
				$('#<portlet:namespace />fileIdValue').val(no++);
			},
			'delete' : function(event) {
				console.log('delete');
				console.log(event);
			}
		},
		sortable : true,
		sortableHandle : '.lfr-form-row'
	}).render();
	</aui:script> --%>


<%-- <aui:script use="liferay-auto-fields">
new Liferay.AutoFields({
	contentBox: '#auto-fields-container',
	fieldIndexes: '<portlet:namespace />rowIndexes',
	on: {
		'clone': function(event) {
			console.log('clone');
			console.log(event);
		},
		'delete': function(event) {
			console.log('delete');
			console.log(event);
		}
	},
	sortable: true,
	sortableHandle: '.lfr-form-row'
}).render();
</aui:script> --%>


<div></div>
<script type="text/javascript">

	function changeProj(val,id){
		var url="<%=projtaskURL.toString()%>"
		//var i = 1;
		var rowId = id.replace("selectProject",'');
		//console.log("i before ajax---"+i);
		console.log("val---"+val);
		console.log("id---"+id);
		console.log("rowId---"+rowId);
		
		var str= $("#selectProject"+rowId).val();
		var str1 = $("#projIdList").val();
		str1 =  str +","+ str1;
		$("#projIdList").val(str1);
		//var projectId = $("_MyTimesheet_INSTANCE_nXEojswcmjM0_selectProject"+rowId).val();
		//console.log("rowId---"+rowId);

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
	
	
	function checkDuplicate(id){
		var counter = $('#counter').val();
		console.log("counter--"+counter);
		if(counter==1){
			counter=$("#expUrl tr").length-2;
			console.log("counter--"+counter);
		}
		var rowId = id.replace("selectTask",'');
		if(counter>1){
		for(i=1;i<=counter;i++){
			console.log("task ids---"+$('#selectTask'+i).val());
			console.log("task id current row---"+$('#selectTask'+rowId).val());
			console.log("project ids---"+$('#selectProject'+i).val());
			console.log("project id current row---"+$('#selectProject'+rowId).val());
			console.log("i value---"+i);
			console.log("rowId----"+rowId);
			if(i!=rowId || i>rowId || i<rowId){
			if($('#selectTask'+i).val()==$('#selectTask'+rowId).val()){
				console.log("same task!");
				if($('#selectProject'+i).val()==$('#selectProject'+rowId).val()){
					console.log("same task and project!");
				alert("Duplicate Task or Project!");
				$('#selectTask'+rowId).val('');
				//$('#selectProject'+rowId).val('');
				}
			}
			}
		}
		}
		
	}
		

	/* $('#<portlet:namespace/>selectProject').click(function(){
	    var clickedID = this.id;
	}); */
	
	
	$(document).ready(function() {
		var url = "<%=exportURL.toString()%>";
		var listValue = "<%=listValue%>";
		var popupUrl = "<%=popup.toString()%>";
		var startDateOfLockingRange = "<%=startDateOfLockingRange%>";
		var endDateOfLockingRange = "<%=endDateOfLockingRange%>";
		var startDateForLocking = "<%=startDateForLocking%>";
		var endDateForLocking = "<%=endDateForLocking%>";
		var submitStatus = "<%=submitStatus%>";
		//alert("url---"+url);
		$.ajax({
			url : url,
			data : {
				"<portlet:namespace/>listValue" : listValue,
				"<portlet:namespace/>popup" : popupUrl,
				"<portlet:namespace/>startDateOfLockingRange" : startDateOfLockingRange,
				"<portlet:namespace/>endDateOfLockingRange" : endDateOfLockingRange,
				"<portlet:namespace/>startDateForLocking" : startDateForLocking,
				"<portlet:namespace/>endDateForLocking" : endDateForLocking,
				"<portlet:namespace/>submitStatus" : submitStatus
			},//person id to sent
			type : 'POST',
			success : function(data) {
				var json = JSON.parse(data);
				
				//alert(json["entries"]);
				$("#expUrl tbody").append(json["entries"]);
				//console.log("data---"+data);
				//console.log("i---"+i);
				console.log("entries--"+json["entries"]);
				if(json["entries"]==null || json["entries"]==undefined || json["entries"]==""){
					AddRow();
				}
			},
		});
		
		
		fillHours = function(hours,actualId,workDescription) {
			console.log("actualId--"+actualId);
			var totalHrsId = actualId.split("_")[1];
			var counter = $('#counter').val();
			if(counter==1){
				counter=$("#expUrl tr").length-2;
			}
			/* var totalRowsList = $("#projIdList").val();
			var totalRowsString = totalRowsList.replace(",","");
			var totalRowsString1 = totalRowsString.replace(",","");
			var totalRows = totalRowsString1.length;
			console.log("totalRowsList--"+totalRowsList);
			console.log("totalRowsString--"+totalRowsString);
			console.log("totalRows--"+totalRows); */
			//var no = $('#<portlet:namespace />fileIdValue').val();
			//var rowId = "";
			//totalHours();
			//console.log("rowId--"+rowId);
			//var previousFileId = 'hours' + no;
			//var colmId = $('#colmId');
			//console.log('colmId'+colmId);
			//var tdElem = $("#colmId").html();
			//console.log('tdElem'+tdElem);
			/* var rowId = document.getElementsByClassName("<portlet:namespace />hours").innerHTML;
			console.log('rowId'+rowId);
			*/
			//console.log('no'+no); 
			//var latestfileId = 'hours' + no;
			//console.log('previousFileId'+previousFileId);
			//console.log('latestfileId'+latestfileId);
			/* var addBtnId = document.getElementById('addBtn').value;
			var deleteBtnId = $('#DeleteBtn').val();
			console.log('addBtnId---'+addBtnId);
			console.log('deleteBtnId---'+deleteBtnId); */
			console.log('counter---'+counter);
			
			if(hours>=1 && workDescription!=null && workDescription!=""){
			$('#hours'+actualId).val(hours);
			$('#workDescription'+actualId).val(workDescription);
			}
			
			
			var str = $('#hours'+actualId).val();
			var str1 = $('#totalHrs_'+totalHrsId).val();
			str1 =  str +","+ str1;
			$("#totalHrs_"+totalHrsId).val(str1);
			
			var totalHours =0;
			<%-- <%for (int i = 0; i < datesInRange.size(); i++) {
				Date weekDate = datesInRange.get(i);
				String weekDateinString = formatter2.format(weekDate);
				DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
						.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
						//.add(RestrictionsFactoryUtil.eq("projectId", Long.parseLong(selectProject)))
						//.add(RestrictionsFactoryUtil.eq("projectTaskId", Long.parseLong(selectTask)))
						.add(RestrictionsFactoryUtil.eq("entryDate", weekDate))
						//.setProjection(ProjectionFactoryUtil.property("hours"));
						.setProjection(ProjectionFactoryUtil.sum("hours"));
				tsEntryList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
				double tempNoOfHrs = 0.0;
				String noOfHrs = String.valueOf(tsEntryList.get(0));
				System.out.println("noOfHrs......" + noOfHrs);
				if (Validator.isNotNull(noOfHrs)) {
					tempNoOfHrs = Double.valueOf(noOfHrs.trim());
					System.out.println("tempNoOfHrs%%%%......" + tempNoOfHrs);
				} else {
					tempNoOfHrs = 0.0;
				}%>
			var weekDate = "<%=weekDateinString%>";
			if(totalHrsId==parseFloat(weekDate)){
				totalHours = <%=tempNoOfHrs%>;
			}
			console.log("totalHours--"+totalHours);
			<%}%> --%>
			var totalRows = $('#totalRows').val();
			var deletedRow = $('#rowId').val();
			console.log("totalRows----"+totalRows);
			console.log("deletedRow----"+deletedRow);
			if(deletedRow!=""){
				for(j=0;j<(deletedRow.length/2);j++){
					var deletedRowSplit = deletedRow.split(",")[j];
					totalRows = totalRows.replace(deletedRowSplit+",","");
				}
				counter = counter - (deletedRow.length/2);
				console.log("counter----"+counter);
			}
			console.log("totalRows----"+totalRows);
			for (i = 1; i <= counter; i++) {
				var rowId = 0;
				if(deletedRow!=""){
					rowId = totalRows.split(",")[i-1];
				} else {
					rowId = i;
				}
				if($('#hours'+rowId+"_"+totalHrsId).val()==""){
					totalHours = totalHours + 0;
				} else {
				
				totalHours = totalHours + parseFloat($('#hours'+rowId+"_"+totalHrsId).val());
				console.log("hours--"+parseFloat($('#hours'+rowId+"_"+totalHrsId).val()));
				console.log("totalHours--"+totalHours);
				}
				
			}
			
			
			if(totalHours>8){
				alert("Only 8 hours allowed!");
				totalHours =totalHours - parseFloat($('#hours'+actualId).val());
				$('#hours'+actualId).val(0);
				$('#totalHours_'+totalHrsId).val(totalHours);
			} else {
				$('#totalHours_'+totalHrsId).val(totalHours);
			}
			//no++;
			//$('#<portlet:namespace />fileIdValue').val(no++);
		};
		var submitStatus = <%=Integer.parseInt(submitStatus)%>;
		var counter = 1;
		var rowId = $("#counter").val();
		console.log("rowId---"+rowId);
		$(".addBtn").click(AddRow);
		$("#DeleteBtn"+rowId).click(DeleteRow);
		<%-- <%for(int i=0;i<atmList.size();i++){
		ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(atmList.get(i).getProjectId());
		%> --%>
		<%-- <%}%> --%>
		var dateInRangeSize = <%=datesInRange.size()%>;
		var dates = "<%=dateListInAnotherFormat%>";
		for(var i=dateInRangeSize-1;i>=0;i--){
			var datesString = dates.split(",")[i];
			console.log("totalHours----"+$('#totalHours_'+datesString).val());
				if($('#totalHours_'+datesString).val()=="null" || $('#totalHours_'+datesString).val()==""){
					console.log("inside if----");
					$('#totalHours_'+datesString).val(0);
			}
		}
		
		
		
		});
	
	var dateInRangeSize = <%=datesInRange.size()%>;
	var counter = 1;
	var projectOption = "<%=projectOption%>";
	var totalNumberOfRows = $("#expUrl tr").length-1;
	//$("#totalNumberOfRows").val(totalNumberOfRows);
	console.log("totalNumberOfRows--"+totalNumberOfRows);
	/* if(submitStatus!=1){ */
	var rowId = $("#counter").val();
	var hrsRowWise = 0;
		var dates = "<%=dateListInAnotherFormat%>";
		for(var i=dateInRangeSize-1;i>=0;i--){
			var datesString = dates.split(",")[i];
			if($('#hours'+rowId+'_'+datesString).val()==""){
				hrsRowWise = 0;
			} else {
				hrsRowWise = parseFloat($('#hours'+rowId+'_'+datesString).val()) + parseFloat(hrsRowWise);
			}
		}
		console.log("hrsRowWise---"+hrsRowWise);
	function AddRow() { 
		console.log("callll");
		if(counter==1){
			counter=$("#expUrl tr").length-1;
		}else{
			counter=counter+1;
		}
			 
			 var totalDatesList = "<%=totalDates%>";
			 var dates = "<%=dateListInAnotherFormat%>";
			 var disabledUrl = "<%=disabledUrl%>";
			 console.log("dates---"+dates);
			 var url = "<%=popup.toString()%>";
			 var portletId1 = "<%=portletId%>";
			 console.log("url--"+url);
			 console.log("dateInRangeSize--"+dateInRangeSize);
			 //console.log("url1--"+url1);
		var tsStr ="";
		var popUpUrl = "";
		var currentDate = '<%=String.valueOf(formatter4.format(currDate))%>';
		var rangeDate1 = '<%=String.valueOf(formatter4.format(datesInRangeToLock.get(0)))%>';
		var rangeDate2 = '<%=String.valueOf(formatter4.format(datesInRangeToLock.get(datesInRangeToLock.size() - 1)))%>';
		var lockDate = '<%=String.valueOf(formatter4.format(datesToLock.get(datesToLock.size() - 1)))%>';
		for(var i=dateInRangeSize-1;i>=0;i--){
			var datesString = dates.split(",")[i];
			var datesToCompare = totalDatesList.split(",")[i];
			var allDates = new Date(datesToCompare);
			var rangeDateToCompare1 = new Date(rangeDate1);
			var rangeDateToCompare2 = new Date(rangeDate2);
			var currDate = new Date(currentDate);
			var lockingDate = new Date(lockDate);
			var lastDay = "<%=formatter2.format(datesInRange.get(datesInRange.size() - 1))%>";
			popUpUrl = url.replace("1_"+lastDay,counter+'_'+datesString);
			var href = popUpUrl;
			var disabled = "";
			console.log("allDates----"+allDates);
			console.log("rangeDateToCompare1----"+rangeDateToCompare1);
			console.log("rangeDateToCompare2----"+rangeDateToCompare2);
			if (+allDates===+rangeDateToCompare1 || allDates>rangeDateToCompare1 && allDates<rangeDateToCompare2 || +allDates===+rangeDateToCompare2) {
				if (currDate>lockingDate) {
					href = disabledUrl;
					disabled = "disabled";
					console.log("inside 1st if---");
				}
			} 
			
			if (allDates<rangeDateToCompare1) {
				href = disabledUrl;
				disabled = "disabled";
				console.log("inside 2nd if---");
			} 
			
			if (allDates>currDate) {
					href = disabledUrl;
					disabled = "disabled";
					console.log("inside 3rd if---");
				} 
			
			
			
			
			tsStr= tsStr +'<td>&nbsp&nbsp <div class="ElementWrap"><label>Hours:</label><input name="_'+portletId1+'_hours'+counter+'_'+datesString+'" type="text" id="hours'+counter+'_'+datesString+'" onchange="addTotalHours()"  size="10" maxlength="8" min="1" value="" readonly="readonly"></input>'
			+'<input name="_'+portletId1+'_workDescription'+counter+'_'+datesString+'" type="hidden" id="workDescription'+counter+'_'+datesString+'" value="" readonly="readonly"></input>'
			+'<a class="btn btn-primary btn-sm marginTop10p" name="fillHrs" type="submit" href="'+href+'" '+disabled+'>Fill Hours</a></div>&nbsp&nbsp</td>'
		}
		var txtHtml='<tr id="row'+counter+'"class="tableRow">'
		+'<td style="padding-left: 10px;">&nbsp&nbsp'
		+'<div class="ElementWrap"><label>Select Project:</label>'
		+'<select name="_'+portletId1+'_selectProject'+counter+'" label="Select Project" id="selectProject'+counter+'" onChange="changeProj(this.value,this.id);" required="true"><option value="">Select Project</option>'+projectOption+'</select></td>'
		+'<td style="padding-left: 10px;">&nbsp&nbsp<div class="ElementWrap"><label>Select Task:</label>'
		+'<select name="_'+portletId1+'_selectTask'+counter+'"	label="Select Task" id="selectTask'+counter+'" onchange="checkDuplicate(this.id);" required="true"><option value="">Select Task</option></select></td>'
		+tsStr+'<td><button class="btn btn-primary btn-sm DeleteBtn" type="button" id="DeleteBtn'+counter+'" onclick="DeleteRow(this.id)">Delete</button></td></tr>';
		
		console.log("counter--"+counter);
		$("#expUrl tbody").append(txtHtml);
		var totalRows = $('#totalRows').val();
		totalRows = counter + "," +totalRows;
		$('#totalRows').val(totalRows);
		$("#counter").val(counter);
	//console.log("Add Row");

	}
	/* } */


	function DeleteRow(id) { 
		console.log("id--"+id);
		$('#allRowIds').val('');
		var rowId =id.replace("DeleteBtn","");
		if(counter==1){
			counter=$("#expUrl tr").length-2;
		}
		for(i=1;i<=counter;i++){
			var totalRowIds = i;
			var totalRowIdsList = $('#allRowIds').val();
			totalRowIdsList = totalRowIds + "," + totalRowIdsList;
			$('#allRowIds').val(totalRowIdsList);
		}
		
			console.log(counter);
			var str = $('#rowId').val();
			str = rowId + "," + str;
			$('#rowId').val(str);
			if($('#selectProject'+rowId).val()!=""){
				var projectId = $('#selectProject'+rowId).val();
				var projStr = $('#projId').val();
				projStr = projectId +"," + projStr;
				$('#projId').val(projStr);
			}
			if($('#selectTask'+rowId).val()!=""){
				var taskId = $('#selectTask'+rowId).val();
				var taskStr = $('#taskId').val();
				taskStr = taskId + "," +taskStr;
				$('#taskId').val(taskStr);
			}
			
			var dateInRangeSize = <%=datesInRange.size()%>;
			var dates = "<%=dateListInAnotherFormat%>";
			for(var i=dateInRangeSize-1;i>=0;i--){
				var datesString = dates.split(",")[i];
				console.log("hours----"+$('#hours'+rowId+'_'+datesString).val());
				if($('#hours'+rowId+'_'+datesString).val()!="" && parseFloat($('#hours'+rowId+'_'+datesString).val())!=0){
					if($('#totalHours_'+datesString).val()!=null && $('#totalHours_'+datesString).val()!=""){
						var totalHrs = parseFloat($('#totalHours_'+datesString).val()) - parseFloat($('#hours'+rowId+'_'+datesString).val());
						$('#totalHours_'+datesString).val(totalHrs);
					} else {
						$('#totalHours_'+datesString).val(0);
					}
				}
			}
			
			console.log(rowId);
			console.log("projectId--"+projectId);
			console.log("taskId--"+taskId);
			/* var txt;
		    if (confirm("Do you want to delete this row!")) {
		        txt = "ok";
		    } else {
		        txt = "cancel";
		    } */
			alert("Do you want to delete this row!");
			/* if(txt=="ok"){ */
			$("#row"+rowId).remove();
			/* } */
		/* if(counter<=1){
			counter=1;
		} else {
			counter=counter-1;
		} */
		//var totalRow = $("#counter").val();
		//console.log(totalRow);
		/* if(counter==1){
			counter=$("#expUrl tr").length-1;
			console.log("counter after tr lenght"+counter);
			$("#row"+counter).remove();
		}else{
			counter=counter+1;
			$("#row"+counter).remove();
			console.log(counter);
		} */
		/* if(counter<=1){
			counter=1;
		} else {
			counter=counter-1;
		} */
	//console.log("Delete Row");
		$("#counter").val(counter);
	}

</script>
<aui:script>
function popup(url) {
	console.log("url--"+url);
	var hrsId = url.split("hours")[1];
	//var actualId = hrsId.replace("hours","");
	console.log("hrsId--"+hrsId);
	var hours = $('#hours'+hrsId).val();
	var workDesc = $('#workDescription'+hrsId).val();
	console.log("hours----"+hours);
	console.log("workDesc----"+workDesc);
	var totalUrl = url;
	if(hours!="" && workDesc!="" || hours!=undefined && workDesc!=undefined){
	totalUrl = url +"-"+ hours +"-"+ workDesc;
	}
	console.log("totalUrl--"+totalUrl);
	Liferay.Util.openWindow({
		dialog : {
			//cssClass: 'aui-popup-example',
			destroyOnHide : true,
			height : 350,
			width : 300,
			close: true
		},
		dialogIframe : {
		//bodyCssClass: 'custom-css-class'
		},
		title : 'Fill Details',
		uri : totalUrl

	});
	
}

/* function popup(hrs,desc) {
	var url = "<%=assignURL.toString()%>";
	console.log("url--"+url);
	Liferay.Util.openWindow({
		dialog : {
			//cssClass: 'aui-popup-example',
			destroyOnHide : true,
			height : 350,
			width : 300,
			close: true
		},
		dialogIframe : {
		//bodyCssClass: 'custom-css-class'
		},
		title : 'Fill Details',
		uri : url

	});
} */


</aui:script>



<script>
function setVal(strVal){
	//alert(strVal);
	$('#<portlet:namespace/>submitVal').val(strVal);
	
}

</script>


<style>
table, th, td {
	border: 1px solid black;
}
</style>