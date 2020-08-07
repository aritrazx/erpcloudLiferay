package com.liferay.famocom.erpcloud.schedulerreminder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.CompanyPolicy;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.TimeSheetEntry;
import com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;

public class TimesheetSchedulerReminder extends BaseSchedulerEntryMessageListener {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		String cronExpression = GetterUtil.getString(properties.get("cron.expression"), _DEFAULT_CRON_EXPRESSION);
		Trigger jobTrigger = TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),
				cronExpression);

		schedulerEntryImpl.setTrigger(jobTrigger);

		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	}

	private final Log _log = LogFactoryUtil.getLog(TimesheetSchedulerReminder.class);

	@Reference(unbind = "-")
	private volatile SchedulerEngineHelper _schedulerEngineHelper;

	private static final String _DEFAULT_CRON_EXPRESSION = "0 0/1 * 1/1 * ? *";

	
	protected void doReceive(Message message) throws Exception {

		System.out.println("Sceduler Executed");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Sceduler Executed dtf.format(now) " + dtf.format(now));
		Date date = new Date();
		int currDate = date.getDate();
		int currMonth = date.getMonth() + 1;
		int currYear = date.getYear();
		//System.out.println("day/month/year....." + currDate +"/" +currMonth +"/" +currYear);
		String date1 = dtf.format(now);
		String[] arrOfStr = date1.split("-");
		String currentDay = arrOfStr[0];
		String currentMonth = arrOfStr[1];
		System.out.println("arrOfStr1 : " + arrOfStr[0] + "..arrOfStr2 : " + arrOfStr[1]);
		List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
		List<Employee> empList1 = new ArrayList<>();
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
		System.out.println("firstDateOfPreviousMonth"+firstDateOfPreviousMonth);
		aCalendar.set(Calendar.DATE, 16);
		Date sixthntDateOfPreviousMonth = aCalendar.getTime();
		// set actual maximum date of previous month
		aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		//read it
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		System.out.println("lastDateOfPreviousMonth"+lastDateOfPreviousMonth);
		//System.out.println("list....."+empList);
		Company company = null;
		try {
			company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		
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

		Date currentDate = currCal.getTime();
		System.out.println("currDate----" + currentDate);
		
		Calendar cal2 = new GregorianCalendar();
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		cal2.add(Calendar.WEEK_OF_YEAR, -1);
		cal2.set(Calendar.DAY_OF_WEEK, cal2.getFirstDayOfWeek()+1);
		Date firstDayPrevWeek = cal2.getTime();
		System.out.println("firstDayPrevWeek" + firstDayPrevWeek);
		
		
		Calendar cal3 = new GregorianCalendar();
		cal3.set(Calendar.HOUR_OF_DAY, 0);
		cal3.set(Calendar.MINUTE, 0);
		cal3.set(Calendar.SECOND, 0);
		cal3.set(Calendar.MILLISECOND, 0);
		cal3.add(Calendar.WEEK_OF_YEAR, -1);
		cal3.set(Calendar.DAY_OF_WEEK, cal3.getFirstDayOfWeek()+1);
		cal3.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDayPrevWeek = cal3.getTime();
		System.out.println("lastDayPrevWeek" + lastDayPrevWeek);
		
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
		
		List<CompanyPolicy> cpList = new ArrayList<>();
		List<TimeSheetEntry> tsList = new ArrayList<>();
		List<TimeSheetEntry> tsList1 = new ArrayList<>();
		List<Date> datesInRange = new ArrayList<>();
		List<Date> datesToLock = new ArrayList<>();
		
		DynamicQuery dynamicQuery = CompanyPolicyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("companyId", company.getCompanyId());
		dynamicQuery.add(criterion3);
		cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		CompanyPolicy cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(cpList.get(0).getCompanyPolicyId());
		/*if(cp!=null){
		if(cp.getCheckStatus()==1){
			Calendar calendar = new GregorianCalendar();
		    calendar.setTime(firstDateOfPreviousMonth);
		     
		    Calendar endCalendar = new GregorianCalendar();
		    endCalendar.setTime(lastDateOfPreviousMonth);
		 
		    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
		        Date result = calendar.getTime();
		        datesInRange.add(result);
		        calendar.add(Calendar.DATE, 1);
		    }
		    for(int i=0;i<datesInRange.size();i++){
		    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
			tsQuery.add(criterion);
			tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
			tsList1.addAll(tsList);
		    }
		    if(cp.getDaysLocking()==1){
		    	Calendar c = Calendar.getInstance();
		    	c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);// this takes current date
		        c.set(Calendar.DAY_OF_MONTH, 1);
		        Date firstDayCurrMonth = c.getTime();
			    calendar.setTime(firstDayCurrMonth);
			    endCalendar.setTime(firstDayCurrMonth);
			 
			    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
			        Date result = calendar.getTime();
			        datesToLock.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
		    } else if(cp.getDaysLocking()==2){
		    	Calendar c = Calendar.getInstance();
		    	c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);// this takes current date
		        c.set(Calendar.DAY_OF_MONTH, 1);
		        Date firstDayCurrMonth = c.getTime();
		        c.set(Calendar.DAY_OF_MONTH, 2);
		        Date secondDayCurrMonth = c.getTime();
			    calendar.setTime(firstDayCurrMonth);
			    endCalendar.setTime(secondDayCurrMonth);
			 
			    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
			        Date result = calendar.getTime();
			        datesToLock.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
		    } else {
		    	Calendar c = Calendar.getInstance();
		    	c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);// this takes current date
		        c.set(Calendar.DAY_OF_MONTH, 1);
		        Date firstDayCurrMonth = c.getTime();
		        c.set(Calendar.DAY_OF_MONTH, 3);
		        Date thirdDayCurrMonth = c.getTime();
			    calendar.setTime(firstDayCurrMonth);
			    endCalendar.setTime(thirdDayCurrMonth);
			 
			    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
			        Date result = calendar.getTime();
			        datesToLock.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
		    }
		} else if(cp.getCheckStatus()==2){
			Calendar calendar = new GregorianCalendar();
		    calendar.setTime(firstDayPrevWeek);
		     
		    Calendar endCalendar = new GregorianCalendar();
		    endCalendar.setTime(lastDayPrevWeek);
		 
		    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
		        Date result = calendar.getTime();
		        datesInRange.add(result);
		        calendar.add(Calendar.DATE, 1);
		    }
		    for(int i=0;i<datesInRange.size();i++){
			    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
				tsQuery.add(criterion);
				tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
				tsList1.addAll(tsList);
			    }
		    if(cp.getDaysLocking()==1){
		    	Calendar c = Calendar.getInstance();
		    	c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+1);
				Date firstDayCurrWeek = c.getTime();
				calendar.setTime(firstDayCurrWeek);
				endCalendar.setTime(firstDayCurrWeek);
				 
				    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				        Date result = calendar.getTime();
				        datesToLock.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
				    
				
		    }
		    else if(cp.getDaysLocking()==2){
		    	Calendar c = Calendar.getInstance();
		    	c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+1);
				Date firstDayCurrWeek = c.getTime();
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+2);
				Date secondDayCurrWeek = c.getTime();
				calendar.setTime(firstDayCurrWeek);
				endCalendar.setTime(secondDayCurrWeek);
				 
				    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				        Date result = calendar.getTime();
				        datesToLock.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
		    } else {
		    	Calendar c = Calendar.getInstance();
		    	c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+1);
				Date firstDayCurrWeek = c.getTime();
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()+3);
				Date thirdDayCurrWeek = c.getTime();
				calendar.setTime(firstDayCurrWeek);
				endCalendar.setTime(thirdDayCurrWeek);
				 
				    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				        Date result = calendar.getTime();
				        datesToLock.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
		    }
		} else {
			DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("entryDate", date);
			tsQuery.add(criterion);
			tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
			tsList1.addAll(tsList);
			
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(prevDay);
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(prevDay);
			while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
		        Date result = calendar.getTime();
		        datesInRange.add(result);
		        calendar.add(Calendar.DATE, 1);
		    }
			
			if(cp.getDaysLocking()==1){
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.setTime(new Date());
				Date currDateIncre1 = c.getTime();
			    calendar.setTime(currDateIncre1);
			     
			    endCalendar.setTime(currDateIncre1);
				 
				    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				        Date result = calendar.getTime();
				        datesToLock.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
			} else if(cp.getDaysLocking()==2){
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.setTime(new Date());
				Date currDateIncre1 = c.getTime();
				c.add(Calendar.DATE, 1);
				Date currDateIncre2 = c.getTime();
			    calendar.setTime(currDateIncre1);
			     
			    endCalendar.setTime(currDateIncre2);
				 
				    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				        Date result = calendar.getTime();
				        datesToLock.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
			} else {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.setTime(new Date());
				Date currDateIncre1 = c.getTime();
				c.add(Calendar.DATE, 2);
				Date currDateIncre3 = c.getTime();
			    calendar.setTime(currDateIncre1);
			     
			    endCalendar.setTime(currDateIncre3);
				 
				    while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
				        Date result = calendar.getTime();
				        datesToLock.add(result);
				        calendar.add(Calendar.DATE, 1);
				    }
			}
		}
		}*/
		
		if (cp != null) {
			int daysLocking = cp.getDaysLocking();
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
				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesInRange.add(result);
					calendar.add(Calendar.DATE, 1);
				}
				 for(int i=0;i<datesInRange.size();i++){
				    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
					tsQuery.add(criterion);
					tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
					tsList1.addAll(tsList);
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
				
				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesInRange.add(result);
					calendar.add(Calendar.DATE, 1);
				}
				for(int i=0;i<datesInRange.size();i++){
			    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
				tsQuery.add(criterion);
				tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
				tsList1.addAll(tsList);
			    }
				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);
				Date firstDayCurrWeek = c.getTime();
				//c.set(Calendar.DAY_OF_WEEK, daysLocking+1);
				c.add(Calendar.DATE, daysLocking + 1);
				Date lockingDay = c.getTime();
				calendar.setTime(firstDayCurrWeek);
				endCalendar.setTime(lockingDay);
				

				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
			} else if (cp.getCheckStatus() == 3) {
				if (currentDate.equals(firstDayCurrMon) || currentDate.after(firstDayCurrMon) && currentDate.before(fiftntDayCurrMon) || currentDate.equals(fiftntDayCurrMon)) {
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
					
					while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
						Date result = calendar.getTime();
						datesInRange.add(result);
						calendar.add(Calendar.DATE, 1);
					}
					for(int i=0;i<datesInRange.size();i++){
					    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
						Criterion criterion = null;
						criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
						tsQuery.add(criterion);
						tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
						tsList1.addAll(tsList);
					    }
					Calendar c = Calendar.getInstance();
					c.set(Calendar.HOUR_OF_DAY, 0);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					c.set(Calendar.MILLISECOND, 0);
					c.setTime(firstDayCurrMon);
					Date firstDay = c.getTime();
					c.set(Calendar.DATE, daysLocking);
					Date lockingDay = c.getTime();
					calendar.setTime(firstDay);
					endCalendar.setTime(lockingDay);
					

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
					
					while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
						Date result = calendar.getTime();
						datesInRange.add(result);
						calendar.add(Calendar.DATE, 1);
					}
					for(int i=0;i<datesInRange.size();i++){
					    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
						Criterion criterion = null;
						criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
						tsQuery.add(criterion);
						tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
						tsList1.addAll(tsList);
					    }
					Calendar c = Calendar.getInstance();
					c.set(Calendar.HOUR_OF_DAY, 0);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
					c.set(Calendar.MILLISECOND, 0);
					c.setTime(sixtntDayCurrMon);
					Date sixthntDay = c.getTime();
					c.set(Calendar.DATE, daysLocking);
					Date lockingDay = c.getTime();
					calendar.setTime(sixthntDay);
					endCalendar.setTime(lockingDay);

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
				
				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesInRange.add(result);
					calendar.add(Calendar.DATE, 1);
				}
				for(int i=0;i<datesInRange.size();i++){
				    DynamicQuery tsQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("entryDate", datesInRange.get(i).getTime());
					tsQuery.add(criterion);
					tsList = TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
					tsList1.addAll(tsList);
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
				
				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
			}
		}
		
		
		
		for(int i=0;i<tsList1.size();i++){
		    DynamicQuery empQuery = EmployeeLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.ne("employeeId", tsList1.get(i).getEmployeeId());
			empQuery.add(criterion);
			empList = EmployeeLocalServiceUtil.dynamicQuery(empQuery);
			empList1.addAll(empList);
		    }
		
		
		for (Employee emp : empList1) {
			
			for(int i=0;i<datesToLock.size();i++){
				if(date.equals(datesToLock.get(i))){
			String fromAddress = "";
			String fromName = "";
			String toAddress = "";
			String emailFor ="TimesheetRequest";
			String body = "";
			String info = "";
			long infoId = 0;
			String messageBody ="";
			toAddress=emp.getEmaiAddress();
			//String userId=newUser.getEmailAddress();
			String empFullName = "";
				empFullName = emp.getFirstName()+" "+emp.getLastName();
			DateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy");
			//String projDate = dateFormat.format(tsEntry.getEntryDate());
			//Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			//compId = company.getCompanyId();
			String authId = PrefsPropsUtil.getString(emp.getCompanyId(), "mail.session.mail.smtp.user");
			String authPass = PrefsPropsUtil.getString(emp.getCompanyId(), "mail.session.mail.smtp.password");
			fromName = PrefsPropsUtil.getString(emp.getCompanyId(), "admin.email.from.name");
			fromAddress = PrefsPropsUtil.getString(emp.getCompanyId(), "admin.email.from.address");
			System.out.println("fromName :"+fromName+" fromAddress :"+fromAddress+" toAdress :"+toAddress);
			
			EmailTemplate eTemplate = EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
			body=eTemplate.getTemplateBody();
			messageBody=body.replace("$NAME", empFullName);
			/*messageBody=messageBody.replace("$FNAME",emp.getFirstName());
			messageBody=messageBody.replace("$LNAME",emp.getLastName());
			messageBody=messageBody.replace("$PROJECT",pm.getProjectName());
			messageBody=messageBody.replace("$DATE",projDate);*/
			System.out.println(messageBody);
			
			/*EmailTemplate eTemplate = EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
			body = eTemplate.getTemplateBody();
			messageBody = body.replace("$NAME", empFullName);*/
			
			InternetAddress[] to = { new InternetAddress(toAddress) };
			InternetAddress from = new InternetAddress(fromAddress);
			
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(to);
    		mailMessage.setFrom(from);
    		mailMessage.setSubject("Famocom Portal Login Information");
    		mailMessage.setBody(messageBody);
    		mailMessage.setHTMLFormat(true);
    		MailServiceUtil.sendEmail(mailMessage);
				}
			}
			
		}

	}
	
	/*public static void main(String args[]) throws AddressException{
		Company company = null;
		try {
			company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		long companyId = company.getCompanyId();
		String fromAddress = "";
		String toAddress = "rajdip.mondal@famocom.com";
		fromAddress = PrefsPropsUtil.getString(companyId, "admin.email.from.address");
		
		InternetAddress[] to = { new InternetAddress(toAddress) };
		InternetAddress from = new InternetAddress(fromAddress);
		
		
		MailMessage mailMessage = new MailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject("Update your timesheet");
		mailMessage.setBody("check the mail....");
		mailMessage.setHTMLFormat(true);
		MailServiceUtil.sendEmail(mailMessage);
		System.out.println("Send mail with HTML Format");
		
	}*/
}
