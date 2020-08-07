package com.liferay.famocom.erpcloud.mytimesheet.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.CompanyPolicy;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.model.TaskMaster;
import com.liferay.famocom.erpcloud.model.TaskMasterMapping;
import com.liferay.famocom.erpcloud.model.TimeSheetEntry;
import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.mytimesheet.constants.MyTimesheetPortletKeys;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=MyTimesheet Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyTimesheetPortletKeys.MyTimesheet, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MyTimesheetPortlet extends MVCPortlet {

	private static final SimpleDateFormat formatter2 = new SimpleDateFormat("dd");

	@ProcessAction(name = "timeSheetEntry")
	public void timeSheetEntry(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, ParseException {
		String calDate = ParamUtil.getString(actionRequest, "calDate", StringPool.BLANK);
		List<String> error = new ArrayList<String>();
		List<String> errorHours = new ArrayList<String>();
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = td.getUser();
		long userId = td.getUserId();
		Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
		long employeeId = emp.getEmployeeId();
		Date tempCaldate = new Date();
		double tempNoOfHrs = 0.0;
		System.out.println("caldate in java....." + calDate);
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long selectTask = ParamUtil.getLong(actionRequest, "selectTask");
		Double hours = ParamUtil.getDouble(actionRequest, "hours");
		String workDescription = ParamUtil.getString(actionRequest, "workDescription");
		Date date = new Date(); // Local Date fetch
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// ProjectMaster pm =
		// ProjectMasterLocalServiceUtil.getProjectMaster(selectProject);

		try {
			tempCaldate = new SimpleDateFormat("dd/MM/yyyy").parse(calDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

		// set actual maximum date of previous month
		aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		// read it
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
		/*
		 * List<TimeSheetEntry> tsList = new ArrayList<>(); List<TimeSheetEntry>
		 * tsList1 = new ArrayList<>();
		 */
		List<Date> datesInRange = new ArrayList<>();
		List<Date> datesToLock = new ArrayList<>();
		List<Date> datesToLockDaily = new ArrayList<>();
		DynamicQuery dynamicQuery2 = CompanyPolicyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
		dynamicQuery2.add(criterion3);
		cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery2);
		CompanyPolicy cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(cpList.get(0).getCompanyPolicyId());
		int daysLocking = cp.getDaysLocking();
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

				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesInRange.add(result);
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

				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}

				/*
				 * for(int i=0;i<datesInRange.size();i++){ DynamicQuery tsQuery
				 * = TimeSheetEntryLocalServiceUtil.dynamicQuery(); Criterion
				 * criterion = null; criterion =
				 * RestrictionsFactoryUtil.eq("entryDate",
				 * datesInRange.get(i).getTime()); tsQuery.add(criterion);
				 * tsList =
				 * TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
				 * tsList1.addAll(tsList); }
				 */
				/*
				 * if(cp.getDaysLocking()==1){ Calendar c =
				 * Calendar.getInstance(); c.set(Calendar.HOUR_OF_DAY, 0);
				 * c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
				 * c.set(Calendar.MILLISECOND, 0);// this takes current date
				 * c.set(Calendar.DAY_OF_MONTH, 1); Date firstDayCurrMonth =
				 * c.getTime(); calendar.setTime(firstDayCurrMonth);
				 * endCalendar.setTime(firstDayCurrMonth);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); } } else
				 * if(cp.getDaysLocking()==2){ Calendar c =
				 * Calendar.getInstance(); c.set(Calendar.HOUR_OF_DAY, 0);
				 * c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
				 * c.set(Calendar.MILLISECOND, 0);// this takes current date
				 * c.set(Calendar.DAY_OF_MONTH, 1); Date firstDayCurrMonth =
				 * c.getTime();
				 * System.out.println("firstDayCurrMonth..."+firstDayCurrMonth);
				 * c.set(Calendar.DAY_OF_MONTH, 2); Date secondDayCurrMonth =
				 * c.getTime();
				 * System.out.println("secondDayCurrMonth..."+secondDayCurrMonth
				 * ); calendar.setTime(firstDayCurrMonth);
				 * endCalendar.setTime(secondDayCurrMonth);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); System.out.println("result..."+result);
				 * datesToLock.add(result); calendar.add(Calendar.DATE, 1);
				 * System.out.println("datesToLock inside loop..."+datesToLock);
				 * } } else { Calendar c = Calendar.getInstance();
				 * c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0);
				 * c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0);//
				 * this takes current date c.set(Calendar.DAY_OF_MONTH, 1); Date
				 * firstDayCurrMonth = c.getTime(); c.set(Calendar.DAY_OF_MONTH,
				 * 3); Date thirdDayCurrMonth = c.getTime();
				 * calendar.setTime(firstDayCurrMonth);
				 * endCalendar.setTime(thirdDayCurrMonth);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); } }
				 */
			} else if (cp.getCheckStatus() == 2) {
				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				calendar.setTime(firstDayPrevWeek);

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

				Calendar c = Calendar.getInstance();
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);
				Date firstDayCurrWeek = c.getTime();
				c.set(Calendar.DAY_OF_WEEK, daysLocking);
				Date lockingDay = c.getTime();
				calendar.setTime(firstDayCurrWeek);
				endCalendar.setTime(lockingDay);

				while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
					Date result = calendar.getTime();
					datesToLock.add(result);
					calendar.add(Calendar.DATE, 1);
				}
				/*
				 * for(int i=0;i<datesInRange.size();i++){ DynamicQuery tsQuery
				 * = TimeSheetEntryLocalServiceUtil.dynamicQuery(); Criterion
				 * criterion = null; criterion =
				 * RestrictionsFactoryUtil.eq("entryDate",
				 * datesInRange.get(i).getTime()); tsQuery.add(criterion);
				 * tsList =
				 * TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
				 * tsList1.addAll(tsList); }
				 */
				/*
				 * if(cp.getDaysLocking()==1){ Calendar c =
				 * Calendar.getInstance(); c.set(Calendar.HOUR_OF_DAY, 0);
				 * c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
				 * c.set(Calendar.MILLISECOND, 0); c.set(Calendar.DAY_OF_WEEK,
				 * c.getFirstDayOfWeek()+1); Date firstDayCurrWeek =
				 * c.getTime(); calendar.setTime(firstDayCurrWeek);
				 * endCalendar.setTime(firstDayCurrWeek);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); }
				 * 
				 * 
				 * } else if(cp.getDaysLocking()==2){ Calendar c =
				 * Calendar.getInstance(); c.set(Calendar.HOUR_OF_DAY, 0);
				 * c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
				 * c.set(Calendar.MILLISECOND, 0); c.set(Calendar.DAY_OF_WEEK,
				 * c.getFirstDayOfWeek()+1); Date firstDayCurrWeek =
				 * c.getTime(); c.set(Calendar.DAY_OF_WEEK,
				 * c.getFirstDayOfWeek()+2); Date secondDayCurrWeek =
				 * c.getTime(); calendar.setTime(firstDayCurrWeek);
				 * endCalendar.setTime(secondDayCurrWeek);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); } } else { Calendar c =
				 * Calendar.getInstance(); c.set(Calendar.HOUR_OF_DAY, 0);
				 * c.set(Calendar.MINUTE, 0); c.set(Calendar.SECOND, 0);
				 * c.set(Calendar.MILLISECOND, 0); c.set(Calendar.DAY_OF_WEEK,
				 * c.getFirstDayOfWeek()+1); Date firstDayCurrWeek =
				 * c.getTime(); c.set(Calendar.DAY_OF_WEEK,
				 * c.getFirstDayOfWeek()+3); Date thirdDayCurrWeek =
				 * c.getTime(); calendar.setTime(firstDayCurrWeek);
				 * endCalendar.setTime(thirdDayCurrWeek);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); } }
				 */
			} else if (cp.getCheckStatus() == 3) {
				if (currDate.before(fiftntDayCurrMon) || currDate.equals(fiftntDayCurrMon)) {
					Calendar calendar = new GregorianCalendar();
					calendar.set(Calendar.HOUR_OF_DAY, 0);
					calendar.set(Calendar.MINUTE, 0);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					calendar.setTime(firstDayCurrMon);

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
				} else {
					Calendar calendar = new GregorianCalendar();
					calendar.set(Calendar.HOUR_OF_DAY, 0);
					calendar.set(Calendar.MINUTE, 0);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					calendar.setTime(sixtntDayCurrMon);

					Calendar endCalendar = new GregorianCalendar();
					endCalendar.set(Calendar.HOUR_OF_DAY, 0);
					endCalendar.set(Calendar.MINUTE, 0);
					endCalendar.set(Calendar.SECOND, 0);
					endCalendar.set(Calendar.MILLISECOND, 0);
					endCalendar.setTime(lastDayCurrMon);

					while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
						Date result = calendar.getTime();
						datesInRange.add(result);
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
				/*
				 * DynamicQuery tsQuery =
				 * TimeSheetEntryLocalServiceUtil.dynamicQuery(); Criterion
				 * criterion = null; criterion =
				 * RestrictionsFactoryUtil.eq("entryDate", date);
				 * tsQuery.add(criterion); tsList =
				 * TimeSheetEntryLocalServiceUtil.dynamicQuery(tsQuery);
				 * tsList1.addAll(tsList);
				 */
				/*
				 * if(cp.getDaysLocking()==1){ Calendar c =
				 * Calendar.getInstance(); c.setTime(new Date());
				 * c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0);
				 * c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0);
				 * Date currDateIncre1 = c.getTime();
				 * calendar.setTime(currDateIncre1);
				 * 
				 * endCalendar.setTime(currDateIncre1);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); } } else
				 * if(cp.getDaysLocking()==2){ Calendar c =
				 * Calendar.getInstance(); c.setTime(new Date());
				 * c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0);
				 * c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0);
				 * Date currDateIncre1 = c.getTime(); c.add(Calendar.DATE, 1);
				 * Date currDateIncre2 = c.getTime();
				 * calendar.setTime(currDateIncre1);
				 * 
				 * endCalendar.setTime(currDateIncre2);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1);
				 * System.out.println("datesToLock inside while......"
				 * +datesToLock); } } else { Calendar c =
				 * Calendar.getInstance(); c.setTime(new Date());
				 * c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0);
				 * c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0);
				 * Date currDateIncre1 = c.getTime(); c.add(Calendar.DATE, 2);
				 * Date currDateIncre3 = c.getTime();
				 * calendar.setTime(currDateIncre1);
				 * endCalendar.setTime(currDateIncre3);
				 * 
				 * while (calendar.before(endCalendar) ||
				 * calendar.equals(endCalendar)) { Date result =
				 * calendar.getTime(); datesToLock.add(result);
				 * calendar.add(Calendar.DATE, 1); } }
				 */
			}
		}

		/* if(cp.getDaysLocking()==1){ */

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
		System.out.println("tempCaldate..." + tempCaldate);
		Calendar c = Calendar.getInstance();
		c.setTime(tempCaldate);
		System.out.println("c.getTime()..." + c.getTime());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.add(Calendar.DATE, daysLocking - 1);
		Date prevDayIncr1 = c.getTime();
		System.out.println("prevDayIncr1..." + prevDayIncr1);
		calendar.setTime(prevDayIncr1);
		endCalendar.setTime(prevDayIncr1);

		while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
			Date result = calendar.getTime();
			datesToLockDaily.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		/*
		 * } else if(cp.getDaysLocking()==2){
		 * 
		 * Calendar calendar = new GregorianCalendar();
		 * calendar.set(Calendar.HOUR_OF_DAY, 0); calendar.set(Calendar.MINUTE,
		 * 0); calendar.set(Calendar.SECOND, 0);
		 * calendar.set(Calendar.MILLISECOND, 0); Calendar endCalendar = new
		 * GregorianCalendar(); endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		 * endCalendar.set(Calendar.MINUTE, 0); endCalendar.set(Calendar.SECOND,
		 * 0); endCalendar.set(Calendar.MILLISECOND, 0);
		 * 
		 * Calendar c = Calendar.getInstance(); c.setTime(tempCaldate);
		 * c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0);
		 * c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0);
		 * c.add(Calendar.DATE, 1); Date prevDayIncr1 = c.getTime();
		 * c.add(Calendar.DATE, 1); Date prevDayIncr2 = c.getTime();
		 * calendar.setTime(prevDayIncr1); endCalendar.setTime(prevDayIncr2);
		 * 
		 * while (calendar.before(endCalendar) || calendar.equals(endCalendar))
		 * { Date result = calendar.getTime(); datesToLockDaily.add(result);
		 * calendar.add(Calendar.DATE, 1); } } else {
		 * 
		 * Calendar calendar = new GregorianCalendar();
		 * calendar.set(Calendar.HOUR_OF_DAY, 0); calendar.set(Calendar.MINUTE,
		 * 0); calendar.set(Calendar.SECOND, 0);
		 * calendar.set(Calendar.MILLISECOND, 0); Calendar endCalendar = new
		 * GregorianCalendar(); endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		 * endCalendar.set(Calendar.MINUTE, 0); endCalendar.set(Calendar.SECOND,
		 * 0); endCalendar.set(Calendar.MILLISECOND, 0);
		 * 
		 * Calendar c = Calendar.getInstance(); c.setTime(tempCaldate);
		 * c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0);
		 * c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0);
		 * c.add(Calendar.DATE, 1); Date prevDayIncr1 = c.getTime();
		 * c.add(Calendar.DATE, 2); Date prevDayIncr3 = c.getTime();
		 * calendar.setTime(prevDayIncr1); endCalendar.setTime(prevDayIncr3);
		 * 
		 * while (calendar.before(endCalendar) || calendar.equals(endCalendar))
		 * { Date result = calendar.getTime(); datesToLockDaily.add(result);
		 * calendar.add(Calendar.DATE, 1); }
		 * 
		 * }
		 */

		System.out.println("datesInRange..." + datesInRange);
		System.out.println("datesToLockDaily..." + datesToLockDaily);
		System.out.println("datesToLock..." + datesToLock);
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("entryDate", tempCaldate))
				.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
				// .setProjection(ProjectionFactoryUtil.property("hours"));
				.setProjection(ProjectionFactoryUtil.sum("hours"));

		List<TimeSheetEntry> list = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("list......" + list);

		String noOfHrs = String.valueOf(list.get(0));
		System.out.println("list......" + noOfHrs);
		if (Validator.isNotNull(noOfHrs)) {
			tempNoOfHrs = Double.valueOf(noOfHrs.trim()) + hours;
			System.out.println("tempNoOfHrs%%%%......" + tempNoOfHrs);
		} else {
			tempNoOfHrs = 0.0;
		}
		DynamicQuery projQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		projQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
		projQuery.add(PropertyFactoryUtil.forName("entryDate").eq(tempCaldate));
		projQuery.add(PropertyFactoryUtil.forName("projectId").eq(selectProject));
		List<TimeSheetEntry> projlist = TimeSheetEntryLocalServiceUtil.dynamicQuery(projQuery);
		/*
		 * try{ actionResponse.setWindowState(WindowState.NORMAL);
		 * actionResponse.setRenderParameter("jspPage",
		 * "/META-INF/resources/timeSheetEntry.jsp"); }catch(Exception e){
		 */

		System.out.println("projlist....." + projlist);
		if (Validator.isNotNull(projlist) && !projlist.isEmpty()) {
			error.add("Given Project Name already exist");
		}
		/*
		 * if (Integer.parseInt(noOfHrs) > 8) {
		 * error.add("you canot exceed 8 hours"); }
		 */
		List<AddTeamMember> projMembrList = new ArrayList<>();
		List<Employee> empList = new ArrayList<>();
		List<Employee> empTempList = new ArrayList<>();
		DynamicQuery projQuery1 = AddTeamMemberLocalServiceUtil.dynamicQuery();
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("projectId", selectProject);
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isProjectManager", true));
		projQuery1.add(criterion);
		projMembrList = AddTeamMemberLocalServiceUtil.dynamicQuery(projQuery1);
		for (int k = 0; k < projMembrList.size(); k++) {
			DynamicQuery dynamicQuery1 = EmployeeLocalServiceUtil.dynamicQuery();
			Criterion criterion1 = null;
			criterion1 = RestrictionsFactoryUtil.eq("employeeId", projMembrList.get(k).getEmployeeId());
			dynamicQuery1.add(criterion1);
			empList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery1);
			empTempList.addAll(empList);
		}
		System.out.println("error....." + error);
		if (error.size() == 0) {
			System.out.println("error###....." + error + "noOfHrs$$" + noOfHrs);
			TimeSheetEntry obj = null;
			if (tempNoOfHrs <= 8.0) {
				// if (noOfHrs.trim()==null) {
				System.out.println("inside if.....");

				try {
					System.out.println("inside try.....");
					// Date date1 = new
					// SimpleDateFormat("dd/MM/yyyy").parse(calDate);
					long timesheetId = CounterLocalServiceUtil.increment(TimeSheetEntry.class.getName());
					TimeSheetEntry tsEntry = TimeSheetEntryLocalServiceUtil.createTimeSheetEntry(timesheetId);
					System.out.println("after tsentry.....");

					/*if (datesInRange.size() == 1) {
						System.out.println("inside if...datesInRange.size()" + datesInRange.size());
						System.out.println("tempCaldate...." + tempCaldate);
						System.out.println("currDate...." + currDate);
						if (tempCaldate.equals(prevDay)) {
							System.out.println("inside if....");
							if (currDate.after(datesToLock.get(datesToLock.size() - 1))) {
								System.out.println("after for-if-for-if.....");
								SessionErrors.add(actionRequest, "errorDate");
								SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
										+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
								actionResponse.setRenderParameter("date", calDate);
								actionResponse.setWindowState(WindowState.NORMAL);
								actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
							} else {
								tsEntry.setAddedDate(date);
								tsEntry.setProjectId(selectProject);
								tsEntry.setProjectTaskId(selectTask);
								tsEntry.setWorkDescription(workDescription);
								tsEntry.setEmployeeId(employeeId);
								tsEntry.setEntryDate(tempCaldate);
								tsEntry.setHours(hours);

								obj = TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry);

								
								 * String fromAddress = ""; String fromName =
								 * ""; String toAddress = ""; String emailFor
								 * ="TimesheetRequest"; String body = ""; String
								 * info = ""; long infoId = 0; String
								 * messageBody =""; for(int
								 * j=0;j<empTempList.size();j++){
								 * toAddress=empTempList.get(j).getEmaiAddress()
								 * ; } //String
								 * userId=newUser.getEmailAddress(); String
								 * empFullName = ""; for(int
								 * j=0;j<empTempList.size();j++){ empFullName =
								 * empTempList.get(j).getFirstName()+" "
								 * +empTempList.get(j).getLastName(); }
								 * DateFormat dateFormat = new
								 * SimpleDateFormat("dd MMMM,yyyy"); String
								 * projDate =
								 * dateFormat.format(tsEntry.getEntryDate());
								 * //Company company =
								 * CompanyLocalServiceUtil.getCompanyByMx(
								 * PropsUtil.get(PropsKeys.
								 * COMPANY_DEFAULT_WEB_ID)); //compId =
								 * company.getCompanyId(); String authId =
								 * PrefsPropsUtil.getString(td.getCompanyId(),
								 * "mail.session.mail.smtp.user"); String
								 * authPass =
								 * PrefsPropsUtil.getString(td.getCompanyId(),
								 * "mail.session.mail.smtp.password"); fromName
								 * = PrefsPropsUtil.getString(td.getCompanyId(),
								 * "admin.email.from.name"); fromAddress =
								 * PrefsPropsUtil.getString(td.getCompanyId(),
								 * "admin.email.from.address");
								 * System.out.println("fromName :"
								 * +fromName+" fromAddress :"
								 * +fromAddress+" toAdress :"+toAddress);
								 * 
								 * EmailTemplate eTemplate =
								 * EmailTemplateLocalServiceUtil.findByemailFor(
								 * emailFor); body=eTemplate.getTemplateBody();
								 * messageBody=body.replace("$NAME",
								 * empFullName);
								 * messageBody=messageBody.replace("$FNAME",emp.
								 * getFirstName());
								 * messageBody=messageBody.replace("$LNAME",emp.
								 * getLastName());
								 * messageBody=messageBody.replace("$PROJECT",pm
								 * .getProjectName());
								 * messageBody=messageBody.replace("$DATE",
								 * projDate); System.out.println(messageBody);
								 * 
								 * EmailTemplate eTemplate =
								 * EmailTemplateLocalServiceUtil.findByemailFor(
								 * emailFor); body =
								 * eTemplate.getTemplateBody(); messageBody =
								 * body.replace("$NAME", empFullName);
								 * 
								 * InternetAddress[] to = { new
								 * InternetAddress(toAddress) }; InternetAddress
								 * from = new InternetAddress(fromAddress);
								 * 
								 * 
								 * MailMessage mailMessage = new MailMessage();
								 * mailMessage.setTo(to);
								 * mailMessage.setFrom(from); mailMessage.
								 * setSubject("Famocom Portal Login Information"
								 * ); mailMessage.setBody(messageBody);
								 * mailMessage.setHTMLFormat(true);
								 * MailServiceUtil.sendEmail(mailMessage);
								 

								SessionMessages.add(actionRequest, "add-success");
								actionResponse.setRenderParameter("date", calDate);
								actionResponse.setWindowState(WindowState.NORMAL);
								actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
							}
						} else {
							System.out.println("inside if-else....");
							if (tempCaldate.after(prevDay)) {
								System.out.println("inside if-else-if....");
								System.out.println("inside if-else-if-if-else....");
								tsEntry.setAddedDate(date);
								tsEntry.setProjectId(selectProject);
								tsEntry.setProjectTaskId(selectTask);
								tsEntry.setWorkDescription(workDescription);
								tsEntry.setEmployeeId(employeeId);
								tsEntry.setEntryDate(tempCaldate);
								tsEntry.setHours(hours);

								obj = TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry);

								
								 * String fromAddress = ""; String fromName =
								 * ""; String toAddress = ""; String emailFor
								 * ="TimesheetRequest"; String body = ""; String
								 * info = ""; long infoId = 0; String
								 * messageBody =""; for(int
								 * j=0;j<empTempList.size();j++){
								 * toAddress=empTempList.get(j).getEmaiAddress()
								 * ; } //String
								 * userId=newUser.getEmailAddress(); String
								 * empFullName = ""; for(int
								 * j=0;j<empTempList.size();j++){ empFullName =
								 * empTempList.get(j).getFirstName()+" "
								 * +empTempList.get(j).getLastName(); }
								 * DateFormat dateFormat = new
								 * SimpleDateFormat("dd MMMM,yyyy"); String
								 * projDate =
								 * dateFormat.format(tsEntry.getEntryDate());
								 * //Company company =
								 * CompanyLocalServiceUtil.getCompanyByMx(
								 * PropsUtil.get(PropsKeys.
								 * COMPANY_DEFAULT_WEB_ID)); //compId =
								 * company.getCompanyId(); String authId =
								 * PrefsPropsUtil.getString(td.getCompanyId(),
								 * "mail.session.mail.smtp.user"); String
								 * authPass =
								 * PrefsPropsUtil.getString(td.getCompanyId(),
								 * "mail.session.mail.smtp.password"); fromName
								 * = PrefsPropsUtil.getString(td.getCompanyId(),
								 * "admin.email.from.name"); fromAddress =
								 * PrefsPropsUtil.getString(td.getCompanyId(),
								 * "admin.email.from.address");
								 * System.out.println("fromName :"
								 * +fromName+" fromAddress :"
								 * +fromAddress+" toAdress :"+toAddress);
								 * 
								 * EmailTemplate eTemplate =
								 * EmailTemplateLocalServiceUtil.findByemailFor(
								 * emailFor); body=eTemplate.getTemplateBody();
								 * messageBody=body.replace("$NAME",
								 * empFullName);
								 * messageBody=messageBody.replace("$FNAME",emp.
								 * getFirstName());
								 * messageBody=messageBody.replace("$LNAME",emp.
								 * getLastName());
								 * messageBody=messageBody.replace("$PROJECT",pm
								 * .getProjectName());
								 * messageBody=messageBody.replace("$DATE",
								 * projDate); System.out.println(messageBody);
								 * 
								 * EmailTemplate eTemplate =
								 * EmailTemplateLocalServiceUtil.findByemailFor(
								 * emailFor); body =
								 * eTemplate.getTemplateBody(); messageBody =
								 * body.replace("$NAME", empFullName);
								 * 
								 * InternetAddress[] to = { new
								 * InternetAddress(toAddress) }; InternetAddress
								 * from = new InternetAddress(fromAddress);
								 * 
								 * 
								 * MailMessage mailMessage = new MailMessage();
								 * mailMessage.setTo(to);
								 * mailMessage.setFrom(from); mailMessage.
								 * setSubject("Famocom Portal Login Information"
								 * ); mailMessage.setBody(messageBody);
								 * mailMessage.setHTMLFormat(true);
								 * MailServiceUtil.sendEmail(mailMessage);
								 

								SessionMessages.add(actionRequest, "add-success");
								actionResponse.setRenderParameter("date", calDate);
								actionResponse.setWindowState(WindowState.NORMAL);
								actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");

							} else if (tempCaldate.before(prevDay)) {
								if (currDate.after(datesToLockDaily.get(datesToLockDaily.size() - 1))) {
									System.out.println("after for-if-for-if.....");
									SessionErrors.add(actionRequest, "errorDate");
									SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
											+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
									actionResponse.setRenderParameter("date", calDate);
									actionResponse.setWindowState(WindowState.NORMAL);
									actionResponse.setRenderParameter("jspPage",
											"/META-INF/resources/timeSheetEntry.jsp");
								} else {
									tsEntry.setAddedDate(date);
									tsEntry.setProjectId(selectProject);
									tsEntry.setProjectTaskId(selectTask);
									tsEntry.setWorkDescription(workDescription);
									tsEntry.setEmployeeId(employeeId);
									tsEntry.setEntryDate(tempCaldate);
									tsEntry.setHours(hours);

									obj = TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry);

									
									 * String fromAddress = ""; String fromName
									 * = ""; String toAddress = ""; String
									 * emailFor ="TimesheetRequest"; String body
									 * = ""; String info = ""; long infoId = 0;
									 * String messageBody =""; for(int
									 * j=0;j<empTempList.size();j++){
									 * toAddress=empTempList.get(j).
									 * getEmaiAddress(); } //String
									 * userId=newUser.getEmailAddress(); String
									 * empFullName = ""; for(int
									 * j=0;j<empTempList.size();j++){
									 * empFullName =
									 * empTempList.get(j).getFirstName()+" "
									 * +empTempList.get(j).getLastName(); }
									 * DateFormat dateFormat = new
									 * SimpleDateFormat("dd MMMM,yyyy"); String
									 * projDate =
									 * dateFormat.format(tsEntry.getEntryDate())
									 * ; //Company company =
									 * CompanyLocalServiceUtil.getCompanyByMx(
									 * PropsUtil.get(PropsKeys.
									 * COMPANY_DEFAULT_WEB_ID)); //compId =
									 * company.getCompanyId(); String authId =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "mail.session.mail.smtp.user"); String
									 * authPass =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "mail.session.mail.smtp.password");
									 * fromName =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "admin.email.from.name"); fromAddress
									 * =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "admin.email.from.address");
									 * System.out.println("fromName :"
									 * +fromName+" fromAddress :"
									 * +fromAddress+" toAdress :"+toAddress);
									 * 
									 * EmailTemplate eTemplate =
									 * EmailTemplateLocalServiceUtil.
									 * findByemailFor(emailFor);
									 * body=eTemplate.getTemplateBody();
									 * messageBody=body.replace("$NAME",
									 * empFullName);
									 * messageBody=messageBody.replace("$FNAME",
									 * emp.getFirstName());
									 * messageBody=messageBody.replace("$LNAME",
									 * emp.getLastName());
									 * messageBody=messageBody.replace(
									 * "$PROJECT",pm.getProjectName());
									 * messageBody=messageBody.replace("$DATE",
									 * projDate);
									 * System.out.println(messageBody);
									 * 
									 * EmailTemplate eTemplate =
									 * EmailTemplateLocalServiceUtil.
									 * findByemailFor(emailFor); body =
									 * eTemplate.getTemplateBody(); messageBody
									 * = body.replace("$NAME", empFullName);
									 * 
									 * InternetAddress[] to = { new
									 * InternetAddress(toAddress) };
									 * InternetAddress from = new
									 * InternetAddress(fromAddress);
									 * 
									 * 
									 * MailMessage mailMessage = new
									 * MailMessage(); mailMessage.setTo(to);
									 * mailMessage.setFrom(from); mailMessage.
									 * setSubject("Famocom Portal Login Information"
									 * ); mailMessage.setBody(messageBody);
									 * mailMessage.setHTMLFormat(true);
									 * MailServiceUtil.sendEmail(mailMessage);
									 

									SessionMessages.add(actionRequest, "add-success");
									actionResponse.setRenderParameter("date", calDate);
									actionResponse.setWindowState(WindowState.NORMAL);
									actionResponse.setRenderParameter("jspPage",
											"/META-INF/resources/timeSheetEntry.jsp");
								}
							}
						}

					} else {*/

						for (int i = 0; i < datesInRange.size(); i++) {
							System.out.println("after for.....");
							Date rangeDate1 = datesInRange.get(0);
							Date rangeDate2 = datesInRange.get(datesInRange.size() - 1);
							System.out.println("tempCaldate..." + tempCaldate);
							// Date rDate = new
							// SimpleDateFormat("dd/MM/yyyy").parse(rangeDate);
							if (tempCaldate.equals(rangeDate1)
									|| tempCaldate.after(rangeDate1) && tempCaldate.before(rangeDate2)
									|| tempCaldate.equals(rangeDate2)) {
								System.out.println("after for-if.....");
								for (int j = 0; j < datesToLock.size(); j++) {
									System.out.println("after for-if-for.....");
									Date lockingDate = datesToLock.get(datesToLock.size() - 1);
									// Date lDate = new
									// SimpleDateFormat("dd/MM/yyyy").parse(lockingDate);
									if (currDate.after(lockingDate)) {
										System.out.println("after for-if-for-if.....");
										SessionErrors.add(actionRequest, "errorDate");
										SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
												+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
										actionResponse.setRenderParameter("date", calDate);
										actionResponse.setWindowState(WindowState.NORMAL);
										actionResponse.setRenderParameter("jspPage",
												"/META-INF/resources/timeSheetEntry.jsp");

									} else {
										System.out.println("after for-if-for-if-else.....");
										tsEntry.setAddedDate(date);
										tsEntry.setProjectId(selectProject);
										tsEntry.setProjectTaskId(selectTask);
										tsEntry.setWorkDescription(workDescription);
										tsEntry.setEmployeeId(employeeId);
										tsEntry.setEntryDate(tempCaldate);
										tsEntry.setHours(hours);
										// fields for workflow integration
										tsEntry.setGroupId(td.getScopeGroupId());
										tsEntry.setStatus(WorkflowConstants.STATUS_DRAFT);
										tsEntry.setStatusByUserId(td.getUserId());
										tsEntry.setStatusDate(new Date());
										tsEntry.setStatusByUserName(user.getFullName());
										tsEntry.setStatusByUserUuid(user.getUserUuid());
										obj = TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry);

										/*
										 * String fromAddress = ""; String
										 * fromName = ""; String toAddress = "";
										 * String emailFor ="TimesheetRequest";
										 * String body = ""; String info = "";
										 * long infoId = 0; String messageBody
										 * =""; for(int
										 * k=0;k<empTempList.size();k++){
										 * toAddress=empTempList.get(k).
										 * getEmaiAddress(); } //String
										 * userId=newUser.getEmailAddress();
										 * String empFullName = ""; for(int
										 * k=0;k<empTempList.size();k++){
										 * empFullName =
										 * empTempList.get(k).getFirstName()+" "
										 * +empTempList.get(k).getLastName(); }
										 * DateFormat dateFormat = new
										 * SimpleDateFormat("dd MMMM,yyyy");
										 * String projDate =
										 * dateFormat.format(tsEntry.
										 * getEntryDate()); //Company company =
										 * CompanyLocalServiceUtil.
										 * getCompanyByMx(PropsUtil.get(
										 * PropsKeys.COMPANY_DEFAULT_WEB_ID));
										 * //compId = company.getCompanyId();
										 * String authId =
										 * PrefsPropsUtil.getString(td.
										 * getCompanyId(),
										 * "mail.session.mail.smtp.user");
										 * String authPass =
										 * PrefsPropsUtil.getString(td.
										 * getCompanyId(),
										 * "mail.session.mail.smtp.password");
										 * fromName =
										 * PrefsPropsUtil.getString(td.
										 * getCompanyId(),
										 * "admin.email.from.name"); fromAddress
										 * = PrefsPropsUtil.getString(td.
										 * getCompanyId(),
										 * "admin.email.from.address");
										 * System.out.println("fromName :"
										 * +fromName+" fromAddress :"
										 * +fromAddress+" toAdress :"+toAddress)
										 * ;
										 * 
										 * EmailTemplate eTemplate =
										 * EmailTemplateLocalServiceUtil.
										 * findByemailFor(emailFor);
										 * body=eTemplate.getTemplateBody();
										 * messageBody=body.replace("$NAME",
										 * empFullName);
										 * messageBody=messageBody.replace(
										 * "$FNAME",emp.getFirstName());
										 * messageBody=messageBody.replace(
										 * "$LNAME",emp.getLastName());
										 * messageBody=messageBody.replace(
										 * "$PROJECT",pm.getProjectName());
										 * messageBody=messageBody.replace(
										 * "$DATE",projDate);
										 * System.out.println(messageBody);
										 * 
										 * EmailTemplate eTemplate =
										 * EmailTemplateLocalServiceUtil.
										 * findByemailFor(emailFor); body =
										 * eTemplate.getTemplateBody();
										 * messageBody = body.replace("$NAME",
										 * empFullName);
										 * 
										 * InternetAddress[] to = { new
										 * InternetAddress(toAddress) };
										 * InternetAddress from = new
										 * InternetAddress(fromAddress);
										 * 
										 * 
										 * MailMessage mailMessage = new
										 * MailMessage(); mailMessage.setTo(to);
										 * mailMessage.setFrom(from);
										 * mailMessage.
										 * setSubject("Famocom Portal Login Information"
										 * ); mailMessage.setBody(messageBody);
										 * mailMessage.setHTMLFormat(true);
										 * MailServiceUtil.sendEmail(mailMessage
										 * );
										 */

										SessionMessages.add(actionRequest, "add-success");
										actionResponse.setRenderParameter("date", calDate);
										actionResponse.setWindowState(WindowState.NORMAL);
										actionResponse.setRenderParameter("jspPage",
												"/META-INF/resources/timeSheetEntry.jsp");
									}
								}

							} else {
								if (tempCaldate.before(rangeDate1)) {
									SessionErrors.add(actionRequest, "errorDate");
									SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
											+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
									actionResponse.setRenderParameter("date", calDate);
									actionResponse.setWindowState(WindowState.NORMAL);
									actionResponse.setRenderParameter("jspPage",
											"/META-INF/resources/timeSheetEntry.jsp");

								} else if (tempCaldate.after(rangeDate2)) {
									System.out.println("if-else.....");
									tsEntry.setAddedDate(date);
									tsEntry.setProjectId(selectProject);
									tsEntry.setProjectTaskId(selectTask);
									tsEntry.setWorkDescription(workDescription);
									tsEntry.setEmployeeId(employeeId);
									tsEntry.setEntryDate(tempCaldate);
									tsEntry.setHours(hours);
									// fields for workflow integration
									tsEntry.setGroupId(td.getScopeGroupId());
									tsEntry.setStatus(WorkflowConstants.STATUS_DRAFT);
									tsEntry.setStatusByUserId(td.getUserId());
									tsEntry.setStatusDate(new Date());
									tsEntry.setStatusByUserName(user.getFullName());
									tsEntry.setStatusByUserUuid(user.getUserUuid());
									obj = TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry);

									/*
									 * String fromAddress = ""; String fromName
									 * = ""; String toAddress = ""; String
									 * emailFor ="TimesheetRequest"; String body
									 * = ""; String info = ""; long infoId = 0;
									 * String messageBody =""; for(int
									 * j=0;j<empTempList.size();j++){
									 * toAddress=empTempList.get(j).
									 * getEmaiAddress(); } //String
									 * userId=newUser.getEmailAddress(); String
									 * empFullName = ""; for(int
									 * j=0;j<empTempList.size();j++){
									 * empFullName =
									 * empTempList.get(j).getFirstName()+" "
									 * +empTempList.get(j).getLastName(); }
									 * DateFormat dateFormat = new
									 * SimpleDateFormat("dd MMMM,yyyy"); String
									 * projDate =
									 * dateFormat.format(tsEntry.getEntryDate())
									 * ; //Company company =
									 * CompanyLocalServiceUtil.getCompanyByMx(
									 * PropsUtil.get(PropsKeys.
									 * COMPANY_DEFAULT_WEB_ID)); //compId =
									 * company.getCompanyId(); String authId =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "mail.session.mail.smtp.user"); String
									 * authPass =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "mail.session.mail.smtp.password");
									 * fromName =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "admin.email.from.name"); fromAddress
									 * =
									 * PrefsPropsUtil.getString(td.getCompanyId(
									 * ), "admin.email.from.address");
									 * System.out.println("fromName :"
									 * +fromName+" fromAddress :"
									 * +fromAddress+" toAdress :"+toAddress);
									 * 
									 * EmailTemplate eTemplate =
									 * EmailTemplateLocalServiceUtil.
									 * findByemailFor(emailFor);
									 * body=eTemplate.getTemplateBody();
									 * messageBody=body.replace("$NAME",
									 * empFullName);
									 * messageBody=messageBody.replace("$FNAME",
									 * emp.getFirstName());
									 * messageBody=messageBody.replace("$LNAME",
									 * emp.getLastName());
									 * messageBody=messageBody.replace(
									 * "$PROJECT",pm.getProjectName());
									 * messageBody=messageBody.replace("$DATE",
									 * projDate);
									 * System.out.println(messageBody);
									 * 
									 * EmailTemplate eTemplate =
									 * EmailTemplateLocalServiceUtil.
									 * findByemailFor(emailFor); body =
									 * eTemplate.getTemplateBody(); messageBody
									 * = body.replace("$NAME", empFullName);
									 * 
									 * InternetAddress[] to = { new
									 * InternetAddress(toAddress) };
									 * InternetAddress from = new
									 * InternetAddress(fromAddress);
									 * 
									 * 
									 * MailMessage mailMessage = new
									 * MailMessage(); mailMessage.setTo(to);
									 * mailMessage.setFrom(from); mailMessage.
									 * setSubject("Famocom Portal Login Information"
									 * ); mailMessage.setBody(messageBody);
									 * mailMessage.setHTMLFormat(true);
									 * MailServiceUtil.sendEmail(mailMessage);
									 */

									SessionMessages.add(actionRequest, "add-success");
									actionResponse.setRenderParameter("date", calDate);
									actionResponse.setWindowState(WindowState.NORMAL);
									actionResponse.setRenderParameter("jspPage",
											"/META-INF/resources/timeSheetEntry.jsp");
								}
							}

						}
				/*	}*/

					/*
					 * for(int i=0;i<datesInRange.size();i++){
					 * if(tempCaldate.after(datesInRange.get(i))){
					 * tsEntry.setAddedDate(date);
					 * tsEntry.setProjectId(selectProject);
					 * tsEntry.setProjectTaskId(selectTask);
					 * tsEntry.setWorkDescription(workDescription);
					 * tsEntry.setEmployeeId(employeeId);
					 * tsEntry.setEntryDate(tempCaldate);
					 * tsEntry.setHours(hours);
					 * 
					 * obj =
					 * TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry)
					 * ; SessionMessages.add(actionRequest, "add-success");
					 * actionResponse.setRenderParameter("date", calDate);
					 * actionResponse.setWindowState(WindowState.NORMAL);
					 * actionResponse.setRenderParameter("jspPage",
					 * "/META-INF/resources/timeSheetEntry.jsp"); } }
					 */

					HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
					httpRequest.setAttribute("date", calDate);

					if (obj != null) {
						System.out.println("inside try-if.....");
						SessionMessages.add(actionRequest, "add-success");
						actionResponse.setRenderParameter("date", calDate);
						actionResponse.setWindowState(WindowState.NORMAL);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
					} else {
						System.out.println("inside try-if-else.....");
						SessionErrors.add(actionRequest, "add-error");
						// String sql = CustomSQLUtil.get(queryId);
						// SQLQuery query = session.createSQLQuery(sql);

					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else {
				System.out.println("inside else(no of hrs).....");
				SessionErrors.add(actionRequest, "errorHours");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
				httpRequest.setAttribute("errorHours", errorHours);
				actionResponse.setRenderParameter("date", calDate);
				try {
					actionResponse.setWindowState(WindowState.NORMAL);
				} catch (WindowStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
			}
		} else {
			try {
				System.out.println("inside else.....");
				SessionErrors.add(actionRequest, "error");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
				// System.out.println("ELSE>>>"+error);
				httpRequest.setAttribute("error", error);
				actionResponse.setRenderParameter("date", calDate);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
			} catch (WindowStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@ProcessAction(name = "updateTimeSheetEntry")
	public void updateTimeSheetEntry(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, PortalException {
		long timesheetId = ParamUtil.getLong(actionRequest, "timesheetId");
		List<String> error = new ArrayList<String>();
		List<String> errorHours = new ArrayList<String>();
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = td.getUser();
		long userId = td.getUserId();
		Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
		long employeeId = emp.getEmployeeId();
		Date tempCaldate = new Date();
		double tempNoOfHrs = 0.0;
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		String calDate = ParamUtil.getString(actionRequest, "calDate", StringPool.BLANK);
		System.out.println("caldate inside update....." + calDate);
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long selectTask = ParamUtil.getLong(actionRequest, "selectTask");
		Double hours = ParamUtil.getDouble(actionRequest, "hours");
		String workDescription = ParamUtil.getString(actionRequest, "workDescription");
		Date date = new Date(); // Local Date fetch
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// String strDate = formatter.format(date);
		// String strDate = formatter.format(date);
		try {
			tempCaldate = new SimpleDateFormat("dd/MM/yyyy").parse(calDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("entryDate", tempCaldate))
				.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
				// .setProjection(ProjectionFactoryUtil.property("hours"));
				.setProjection(ProjectionFactoryUtil.sum("hours"));

		List<TimeSheetEntry> list = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("list......" + list);

		DynamicQuery hrCountQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("entryDate", tempCaldate))
				.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
				// .setProjection(ProjectionFactoryUtil.property("hours"));
				.setProjection(ProjectionFactoryUtil.property("hours"));

		List<TimeSheetEntry> countHr = TimeSheetEntryLocalServiceUtil.dynamicQuery(hrCountQuery);
		System.out.println("countHr list......" + countHr);
		TimeSheetEntry timeSheetEntry = null;
		if (timesheetId != 0) {
			timeSheetEntry = TimeSheetEntryLocalServiceUtil.getTimeSheetEntry(timesheetId);
		}
		String totalNoOfHrs = null;
		double totalTempNoOfHrs = 0.0;
		String noOfHrs = String.valueOf(list.get(0));
		System.out.println("list......" + noOfHrs);
		if (Validator.isNotNull(noOfHrs)) {
			tempNoOfHrs = Double.valueOf(noOfHrs.trim());
			System.out.println("tempNoOfHrs%%%%......" + tempNoOfHrs);
		} else {
			tempNoOfHrs = 0.0;
		}

		for (int i = 0; i < countHr.size(); i++) {
			totalNoOfHrs = String.valueOf(countHr.get(i));
			System.out.println("totalNoOfHrs......" + totalNoOfHrs);
			if (countHr.size() > 1) {
				totalTempNoOfHrs = tempNoOfHrs + hours - timeSheetEntry.getHours();
				System.out.println("totalTempNoOfHrs......" + totalTempNoOfHrs);
			} else {
				totalTempNoOfHrs = Double.valueOf(totalNoOfHrs.trim());
			}
		}

		DynamicQuery projQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
		projQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
		projQuery.add(PropertyFactoryUtil.forName("entryDate").eq(tempCaldate));
		projQuery.add(PropertyFactoryUtil.forName("projectId").eq(selectProject));
		List<TimeSheetEntry> projlist = TimeSheetEntryLocalServiceUtil.dynamicQuery(projQuery);
		boolean bFlg = false;
		if (Validator.isNotNull(projlist) && !projlist.isEmpty()) {
			for (TimeSheetEntry oh : projlist) {
				if (oh.getTimesheetId() != timesheetId) {
					bFlg = true;
				}
			}
		}
		if (bFlg) {
			error.add("Given Status Name already exist");
		}
		if (error.size() == 0) {
			TimeSheetEntry obj = null;
			if (totalTempNoOfHrs <= 8.0) {
				try {
					Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(calDate);
					TimeSheetEntry tsEntry = TimeSheetEntryLocalServiceUtil.getTimeSheetEntry(timesheetId);
					tsEntry.setAddedDate(date);
					tsEntry.setProjectId(selectProject);
					tsEntry.setProjectTaskId(selectTask);
					tsEntry.setWorkDescription(workDescription);
					tsEntry.setEntryDate(date1);
					tsEntry.setHours(hours);
					tsEntry.setEmployeeId(employeeId);
					// fields for workflow integration
					tsEntry.setGroupId(td.getScopeGroupId());
					tsEntry.setStatus(WorkflowConstants.STATUS_DRAFT);
					tsEntry.setStatusByUserId(td.getUserId());
					tsEntry.setStatusDate(new Date());
					tsEntry.setStatusByUserName(user.getFullName());
					tsEntry.setStatusByUserUuid(user.getUserUuid());
					obj = TimeSheetEntryLocalServiceUtil.updateTimeSheetEntry(tsEntry);

					// HttpServletRequest httpRequest =
					// PortalUtil.getHttpServletRequest(actionRequest);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if (obj != null) {
					SessionMessages.add(actionRequest, "update-success");

					actionResponse.setRenderParameter("date", calDate);
					actionResponse.setWindowState(WindowState.NORMAL);
					actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
				} else {
					SessionErrors.add(actionRequest, "update-error");
				}
			} else {
				SessionErrors.add(actionRequest, "errorHours");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
				httpRequest.setAttribute("errorHours", errorHours);
				actionResponse.setRenderParameter("date", calDate);
				try {
					actionResponse.setWindowState(WindowState.NORMAL);
				} catch (WindowStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
			}
		} else {
			SessionErrors.add(actionRequest, "error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			httpRequest.setAttribute("errorList", error);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("date", calDate);
			actionResponse.setRenderParameter("backUrl", backUrl);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
		}
	}

	@ProcessAction(name = "deleteTimeSheetEntry")
	public void deleteTimeSheetEntry(ActionRequest actionRequest, ActionResponse actionResponse) {
		long timesheetId = ParamUtil.getLong(actionRequest, "timesheetId1");
		String calDate = ParamUtil.getString(actionRequest, "calDate", StringPool.BLANK);
		try {
			TimeSheetEntry tsEntry = TimeSheetEntryLocalServiceUtil.getTimeSheetEntry(timesheetId);
			TimeSheetEntryLocalServiceUtil.deleteTimeSheetEntry(tsEntry);
			actionResponse.setRenderParameter("date", calDate);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/timeSheetEntry.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ProcessAction(name = "addTimesheet")
	public void addTimesheet(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, ParseException, PortalException {
		// int i=1;
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
		long employeeId = emp.getEmployeeId();
		User user = UserLocalServiceUtil.getUser(userId);
		Date date = new Date();
		List<TimeSheetEntry> tsEntryList = new ArrayList<>();
		List<TimeSheetEntry> tsEntryTempList = new ArrayList<>();
		int counter = ParamUtil.getInteger(actionRequest, "counter");
		int submitVal = ParamUtil.getInteger(actionRequest, "submitVal");
		System.out.println("submitVal--" + submitVal);
		System.out.println("counter--" + counter);
		List<Date> datesInRange = new ArrayList<>();
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String listValue = ParamUtil.getString(actionRequest, "listValue", StringPool.BLANK);
		System.out.println("listValue...." + listValue);

		String startRange = listValue.split("-")[0];
		System.out.println("startRange...." + startRange);
		String endRange = listValue.split("-")[1];
		System.out.println("endRange...." + endRange);
		Date startDate = new SimpleDateFormat("dd MMMM,yyyy").parse(startRange);
		System.out.println("startDate...." + startDate);
		Date endDate = new SimpleDateFormat("dd MMMM,yyyy").parse(endRange);
		System.out.println("endDate...." + endDate);

		List<Object[]> distinctTimesheetList = TimeSheetEntryLocalServiceUtil
				.getDistinctTimesheetListByEmployeeIdAndDateRange(emp.getEmployeeId(), startDate, endDate);
		System.out.println("distinctTimesheetList--" + distinctTimesheetList.size());

		String[] rowArr = ParamUtil.getParameterValues(actionRequest, "rowId");
		String rowLists = ParamUtil.getString(actionRequest, "rowId", StringPool.BLANK);
		String rowListsArr[] = rowLists.split(",");

		String[] allRowArr = ParamUtil.getParameterValues(actionRequest, "allRowIds");
		String allRowLists = ParamUtil.getString(actionRequest, "allRowIds", StringPool.BLANK);

		String[] projArr = ParamUtil.getParameterValues(actionRequest, "projId");
		String projLists = ParamUtil.getString(actionRequest, "projId", StringPool.BLANK);
		String projListsArr[] = projLists.split(",");

		String[] taskArr = ParamUtil.getParameterValues(actionRequest, "taskId");
		String taskLists = ParamUtil.getString(actionRequest, "taskId", StringPool.BLANK);
		String taskListsArr[] = taskLists.split(",");
		try {
			if (projArr.length != 0 && taskArr.length != 0) {
				for (int s = 0; s <= projArr.length - 1; s++) {
					long projectId = Long.parseLong(projListsArr[s]);
					long taskId = Long.parseLong(taskListsArr[s]);

					DynamicQuery deleteQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
					Criterion criterion = null;
					criterion = RestrictionsFactoryUtil.eq("employeeId", employeeId);
					criterion = RestrictionsFactoryUtil.and(criterion,
							RestrictionsFactoryUtil.eq("projectId", projectId));
					criterion = RestrictionsFactoryUtil.and(criterion,
							RestrictionsFactoryUtil.eq("projectTaskId", taskId));
					criterion = RestrictionsFactoryUtil.and(criterion,
							RestrictionsFactoryUtil.between("entryDate", startDate, endDate));
					deleteQuery.add(criterion);
					List<TimeSheetEntry> tsEntryDeleteList = TimeSheetEntryLocalServiceUtil.dynamicQuery(deleteQuery);
					if (tsEntryDeleteList != null) {
						for (TimeSheetEntry tsEntryDelete : tsEntryDeleteList) {
							System.out.println("inside delete for delete operation!");
							TimeSheetEntry tsEntry = TimeSheetEntryLocalServiceUtil
									.getTimeSheetEntry(tsEntryDelete.getTimesheetId());
							TimeSheetEntryLocalServiceUtil.deleteTimeSheetEntry(tsEntry);
						}
					}
				}
				if (distinctTimesheetList.size() != 0) {
					if (counter == 1) {
						counter = distinctTimesheetList.size() - projArr.length;
					}
				}
				counter = counter - projArr.length;
			} else {
				if (distinctTimesheetList.size() != 0) {
					if (counter == 1) {
						counter = distinctTimesheetList.size();
					}
				}
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

			if (rowArr.length != 0 && allRowArr.length != 0) {
				for (int s = 0; s <= rowArr.length - 1; s++) {

					allRowLists = allRowLists.replace(rowListsArr[s] + ",", "");
				}
				counter = allRowArr.length - 1;
			}
			String allRowListsArr[] = allRowLists.split(",");
			System.out.println("allRowArr--" + allRowArr.length);
			System.out.println("allRowLists--" + allRowLists);
			System.out.println("counter value----" + counter);

			double tempNoOfHrs = 0.0;
			TimeSheetMaster timesheetMaster = null;
			for (int i = 1; i <= counter; i++) {
				int rowId = 0;
				if (allRowArr.length != 0) {
					rowId = Integer.parseInt(allRowListsArr[i - 1]);
				} else {
					rowId = i;
				}
				String selectProject = ParamUtil.getString(actionRequest, "selectProject" + rowId, StringPool.BLANK);
				System.out.println("selectProject...." + selectProject);
				String selectTask = ParamUtil.getString(actionRequest, "selectTask" + rowId, StringPool.BLANK);
				System.out.println("selectTask...." + selectTask);
				for (int j = 0; j < datesInRange.size(); j++) {
					Date weekDate = datesInRange.get(j);
					String weekDateinString = formatter2.format(weekDate);
					String hours = ParamUtil.getString(actionRequest, "hours" + rowId + "_" + weekDateinString,
							StringPool.BLANK);
					String workDescription = ParamUtil.getString(actionRequest,
							"workDescription" + rowId + "_" + weekDateinString, StringPool.BLANK);
					System.out.println("hours..." + hours);
					System.out.println("workDescription..." + workDescription);

					if (Validator.isNotNull(hours) && Double.valueOf(hours) != 0) {
						System.out.println("selectProject for hrs...." + selectProject);
						System.out.println("selectTask for hrs...." + selectTask);
						System.out.println("date for hrs...." + formatter.format(weekDate));
						System.out.println("hours not null--" + hours);
						System.out.println("workDescription for hrs...." + workDescription);

						DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery()
								.add(RestrictionsFactoryUtil.eq("employeeId", employeeId))
								// .add(RestrictionsFactoryUtil.eq("projectId",
								// Long.parseLong(selectProject)))
								// .add(RestrictionsFactoryUtil.eq("projectTaskId",
								// Long.parseLong(selectTask)))
								.add(RestrictionsFactoryUtil.eq("entryDate", weekDate))
								// .setProjection(ProjectionFactoryUtil.property("hours"));
								.setProjection(ProjectionFactoryUtil.sum("hours"));
						tsEntryList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);

						DynamicQuery dynamicQuery1 = TimeSheetEntryLocalServiceUtil.dynamicQuery();
						Criterion criterion3 = null;
						criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
						criterion3 = RestrictionsFactoryUtil.and(criterion3,
								RestrictionsFactoryUtil.eq("projectId", Long.parseLong(selectProject)));
						criterion3 = RestrictionsFactoryUtil.and(criterion3,
								RestrictionsFactoryUtil.eq("projectTaskId", Long.parseLong(selectTask)));
						criterion3 = RestrictionsFactoryUtil.and(criterion3,
								RestrictionsFactoryUtil.eq("entryDate", weekDate));
						dynamicQuery1.add(criterion3);
						tsEntryTempList = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery1);
						System.out.println("tsEntryTempList---" + tsEntryTempList);
						if (tsEntryTempList != null) {
							for (int k = 0; k < tsEntryTempList.size(); k++) {
								System.out.println("inside delete");
								TimeSheetEntry tsEntry = TimeSheetEntryLocalServiceUtil
										.getTimeSheetEntry(tsEntryTempList.get(k).getTimesheetId());
								TimeSheetEntryLocalServiceUtil.deleteTimeSheetEntry(tsEntry);
							}
						}

						String noOfHrs = String.valueOf(tsEntryList.get(0));
						System.out.println("noOfHrs......" + noOfHrs);
						if (Validator.isNotNull(noOfHrs)) {
							tempNoOfHrs = Double.valueOf(noOfHrs.trim());
							System.out.println("tempNoOfHrs%%%%......" + tempNoOfHrs);
						} else {
							tempNoOfHrs = 0.0;
						}
						if (tempNoOfHrs < 8) {

							long timesheetParentId = 0;
							List<TimeSheetMaster> timesheetMasterList = new ArrayList<>();
							dynamicQuery = null;
							dynamicQuery = TimeSheetMasterLocalServiceUtil.dynamicQuery();
							criterion3 = null;
							criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
							criterion3 = RestrictionsFactoryUtil.and(criterion3,
									RestrictionsFactoryUtil.eq("fromDate", startDate));
							criterion3 = RestrictionsFactoryUtil.and(criterion3,
									RestrictionsFactoryUtil.eq("toDate", endDate));
							dynamicQuery.add(criterion3);
							timesheetMasterList = TimeSheetMasterLocalServiceUtil.dynamicQuery(dynamicQuery);

							if (timesheetMasterList.size() != 0) {
								for (TimeSheetMaster tsm : timesheetMasterList) {
									timesheetParentId = tsm.getTimesheetParentId();
									timesheetMaster = TimeSheetMasterLocalServiceUtil
											.getTimeSheetMaster(timesheetParentId);
									timesheetMaster.setSubmitStatus(submitVal);
									TimeSheetMasterLocalServiceUtil.updateTimeSheetMaster(timesheetMaster);

								}
							} else {
								timesheetParentId = CounterLocalServiceUtil.increment(TimeSheetMaster.class.getName());
								timesheetMaster = TimeSheetMasterLocalServiceUtil
										.createTimeSheetMaster(timesheetParentId);
								timesheetMaster.setAddedDate(date);
								timesheetMaster.setEmployeeId(employeeId);
								timesheetMaster.setFromDate(startDate);
								timesheetMaster.setToDate(endDate);
								timesheetMaster.setSubmitStatus(submitVal);
								// fields for workflow integration
								timesheetMaster.setGroupId(td.getScopeGroupId());
								timesheetMaster.setStatus(WorkflowConstants.STATUS_DRAFT);
								timesheetMaster.setStatusByUserId(td.getUserId());
								timesheetMaster.setStatusDate(new Date());
								timesheetMaster.setStatusByUserName(user.getFullName());
								timesheetMaster.setStatusByUserUuid(user.getUserUuid());
								TimeSheetMasterLocalServiceUtil.addTimeSheetMaster(timesheetMaster);

							}

							long timesheetId = CounterLocalServiceUtil.increment(TimeSheetEntry.class.getName());
							TimeSheetEntry tsEntry = TimeSheetEntryLocalServiceUtil.createTimeSheetEntry(timesheetId);
							tsEntry.setEntryDate(weekDate);
							tsEntry.setProjectId(Long.parseLong(selectProject));
							tsEntry.setProjectTaskId(Long.parseLong(selectTask));
							tsEntry.setHours(Double.valueOf(hours));
							tsEntry.setAddedDate(date);
							tsEntry.setEmployeeId(employeeId);
							tsEntry.setWorkDescription(workDescription);
							tsEntry.setTimesheetParentId(timesheetParentId);
							// fields for workflow integration
							tsEntry.setGroupId(td.getScopeGroupId());
							tsEntry.setStatus(WorkflowConstants.STATUS_DRAFT);
							tsEntry.setStatusByUserId(td.getUserId());
							tsEntry.setStatusDate(new Date());
							tsEntry.setStatusByUserName(user.getFullName());
							tsEntry.setStatusByUserUuid(user.getUserUuid());
							TimeSheetEntryLocalServiceUtil.addTimeSheetEntry(tsEntry);
							System.out.println("inside add");

						} /*
							 * else { System.out.println("inside error");
							 * SessionErrors.add(actionRequest, "error");
							 * SessionMessages.add(actionRequest,
							 * PortalUtil.getPortletId(actionRequest) +
							 * SessionMessages.
							 * KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE );
							 * actionResponse.setWindowState(WindowState.NORMAL)
							 * ; actionResponse.setRenderParameter("jspPage",
							 * "/META-INF/resources/addTimesheetPage.jsp"); }
							 */

					}
				}
				System.out.println("i value---" + i);
			}
			// Workflow
			// Integration===========================================================================

			if (submitVal == 1) {
				// setRole(td.getCompanyId(),user.getUserId());
				long groupId = td.getScopeGroupId();
				// User user =
				// UserLocalServiceUtil.getUser(themeDisplay.getUserId());

				ServiceContext serviceContext1 = ServiceContextFactory.getInstance(MyTimesheetPortlet.class.getName(),
						actionRequest);
				serviceContext1.setAddGroupPermissions(true);
				serviceContext1.setAddGuestPermissions(true);
				serviceContext1.setCompanyId(td.getCompanyId());
				serviceContext1.setScopeGroupId(groupId);
				serviceContext1.setUserId(user.getUserId());

				String postName = user.getFullName();

				updateAssetEntry(user, groupId, timesheetMaster, postName);

				Indexer<TimeSheetMaster> indexer = IndexerRegistryUtil.nullSafeGetIndexer(TimeSheetMaster.class);
				indexer.reindex(timesheetMaster);
				System.out.println("before workflow start--");
				WorkflowHandlerRegistryUtil.startWorkflowInstance(td.getCompanyId(), timesheetMaster.getGroupId(),
						td.getUserId(), TimeSheetMaster.class.getName(), timesheetMaster.getPrimaryKey(),
						timesheetMaster, serviceContext1);
				System.out.println("after workflow start--");
				// ===============================================================================================
			}
			/*
			 * String listValue = ParamUtil.getString(actionRequest,
			 * "listValue",StringPool.BLANK); System.out.println("listValue...."
			 * + listValue); String selectProject =
			 * ParamUtil.getString(actionRequest, "selectProject"+i,
			 * StringPool.BLANK); System.out.println("selectProject...." +
			 * selectProject); String selectTask =
			 * ParamUtil.getString(actionRequest, "selectTask"+i,
			 * StringPool.BLANK); System.out.println("selectTask...." +
			 * selectTask);
			 */
			// String hours = ParamUtil.getString(actionRequest, "hours",
			// StringPool.BLANK);
			// i++;
			actionResponse.setRenderParameter("list", listValue);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		String txtHtml = StringPool.BLANK;
		String popup = ParamUtil.getString(request, "popup", StringPool.BLANK);
		String submitStatus = ParamUtil.getString(request, "submitStatus", StringPool.BLANK);
		System.out.println("submitStatus---" + submitStatus);
		String popupUrl = popup.replace("'", "\"");
		String startDateOfLockingRange = ParamUtil.getString(request, "startDateOfLockingRange", StringPool.BLANK);
		String endDateOfLockingRange = ParamUtil.getString(request, "endDateOfLockingRange", StringPool.BLANK);
		String startDateForLocking = ParamUtil.getString(request, "startDateForLocking", StringPool.BLANK);
		String endDateForLocking = ParamUtil.getString(request, "endDateForLocking", StringPool.BLANK);
		System.out.println("popup---" + popup);
		System.out.println("startDateOfLockingRange---" + startDateOfLockingRange);
		System.out.println("endDateOfLockingRange---" + endDateOfLockingRange);
		System.out.println("startDateForLocking---" + startDateForLocking);
		System.out.println("endDateForLocking---" + endDateForLocking);
		System.out.println("serve resource function----");

		if (cmd.equals("exportURL")) {
			try {
				// exportToXls(request, response);
				ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				Employee emp = EmployeeLocalServiceUtil.findByemployees(td.getUserId());
				String listValue = ParamUtil.getString(request, "listValue", StringPool.BLANK);

				if (listValue != null && listValue.split("-").length == 2) {
					Date startDate = new Date();
					Date endDate = new Date();
					Date startDateLockingRange = new Date();
					Date endDateLockingRange = new Date();
					Date startDateLocking = new Date();
					Date endDateLocking = new Date();

					Calendar currCal = Calendar.getInstance();
					currCal.setTime(new Date());
					currCal.set(Calendar.HOUR_OF_DAY, 0);
					currCal.set(Calendar.MINUTE, 0);
					currCal.set(Calendar.SECOND, 0);
					currCal.set(Calendar.MILLISECOND, 0);

					Date currDate = currCal.getTime();

					if (startDateOfLockingRange != null)
						startDateLockingRange = new SimpleDateFormat("dd/MM/yyyy").parse(startDateOfLockingRange);
					if (endDateOfLockingRange != null)
						endDateLockingRange = new SimpleDateFormat("dd/MM/yyyy").parse(endDateOfLockingRange);
					if (startDateForLocking != null)
						startDateLocking = new SimpleDateFormat("dd/MM/yyyy").parse(startDateForLocking);
					if (endDateForLocking != null)
						endDateLocking = new SimpleDateFormat("dd/MM/yyyy").parse(endDateForLocking);

					if (listValue.split("-")[0] != null)
						startDate = new SimpleDateFormat("dd MMMM,yyyy").parse(listValue.split("-")[0]);
					if (listValue.split("-")[1] != null)
						endDate = new SimpleDateFormat("dd MMMM,yyyy").parse(listValue.split("-")[1]);
					
					List<Date> datesInRange = new MyTimesheetPortlet().getDateRange(startDate, endDate);

					PortletDisplay portletDisplay = td.getPortletDisplay();
					String portletId = portletDisplay.getId();

					// List<TimeSheetEntry> tsList = new ArrayList<>();
					// List<TimeSheetEntry> tsList1 = new ArrayList<>();
					// List<Date> datesInRangeToLock = new ArrayList<>();
					// List<Date> datesToLock = new ArrayList<>();
					// List<Date> datesToLockDaily = new ArrayList<>();
					DynamicQuery dynamicQuery4 = CompanyPolicyLocalServiceUtil.dynamicQuery();
					Criterion criterion4 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
					dynamicQuery4.add(criterion4);
					CompanyPolicy companyPolicy = null;

					List<CompanyPolicy> companyPolicies = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery4);
					if (companyPolicies != null && companyPolicies.size() > 0 && companyPolicies.get(0) != null)
						companyPolicy = CompanyPolicyLocalServiceUtil
								.getCompanyPolicy(companyPolicies.get(0).getCompanyPolicyId());
					
					
					
					// int daysLocking = companyPolicy.getDaysLocking();

					// 1 - monthly

					// 2 - weekly

					// 3 - bi-weekly

					// 4 - daily

					List<TimeSheetEntry> timeSheetEntries = new ArrayList<>();
					// List<TimeSheetEntry> tsDatabaseList1 = new ArrayList<>();
					// List<TaskMasterMapping> allTaskList = new ArrayList<>();
					List<AddTeamMember> allProjects = new ArrayList<>();
					// List<AddTeamMember> empAllProjList1 = new ArrayList<>();
					DynamicQuery dynamicQuery = TimeSheetEntryLocalServiceUtil.dynamicQuery();
					Criterion criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
					criterion = RestrictionsFactoryUtil.and(criterion,
							RestrictionsFactoryUtil.between("entryDate", startDate, endDate));
					dynamicQuery.add(criterion);

					timeSheetEntries = TimeSheetEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
					List<Object[]> distinctTimesheetList = TimeSheetEntryLocalServiceUtil
							.getDistinctTimesheetListByEmployeeIdAndDateRange(emp.getEmployeeId(), startDate, endDate);
					System.out.println("distinctTimesheetList--" + distinctTimesheetList.size());

					// get project list
					dynamicQuery = null;
					dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
					criterion = null;
					criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
					dynamicQuery.add(criterion);
					allProjects = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
					
					
					//checking approve and reject
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
					System.out.println("approveRejectCheckList in java====>>>> : " + approveRejectCheckList);
					
					// empAllProjList1.addAll(empAllProjList);
					// String selected = "";
					String projectOption = StringPool.BLANK;
					String taskOption = StringPool.BLANK;

					Map<Long, String> projectMap = new HashMap<Long, String>();
					for (AddTeamMember project : allProjects) {
						ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(project.getProjectId());
						projectMap.put(project.getProjectId(), pm.getProjectName());

					}

					String timeSheetEntry = "";
					// int rowCount = 0;
					int count = 1;
					for (AddTeamMember project : allProjects) {
						Map<Long, String> taskMap = new HashMap<Long, String>();

						List<TaskMasterMapping> allTaskList = new ArrayList<>();
						dynamicQuery = null;
						dynamicQuery = TaskMasterMappingLocalServiceUtil.dynamicQuery();
						criterion = null;
						criterion = RestrictionsFactoryUtil.eq("projectId", project.getProjectId());
						dynamicQuery.add(criterion);
						allTaskList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery);
						for (TaskMasterMapping task : allTaskList) {
							TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(task.getTaskId());
							taskMap.put(task.getTaskId(), tm.getTaskName());
						}

						for (TaskMasterMapping task : allTaskList) {
							String tsStr = "";
							boolean foundTask = false;
							/*
							 * for(int
							 * count=1;count<=distinctTimesheetList.size();count
							 * ++){
							 */

							for (Date day : datesInRange) {
								String weekDateinString = formatter2.format(day);
								String lastDay = formatter2.format(datesInRange.get(datesInRange.size() - 1));
								String url = popupUrl.replace("1_" + lastDay, count + "_" + weekDateinString);
								String disabled = "";
								if (day.equals(startDateLockingRange)
										|| day.after(startDateLockingRange) && day.before(endDateLockingRange)
										|| day.equals(endDateLockingRange)) {
									if (currDate.after(endDateLocking)) {
										url = popup;
										disabled = "disabled";
									}
								}

								if (day.before(startDateLockingRange)) {
									url = popup;
									disabled = "disabled";
								}

								if (day.after(currDate)) {
									url = popup;
									disabled = "disabled";
								}
								
								if (Integer.parseInt(submitStatus)==1) {
									url = popup;
									disabled = "disabled";
								}
								if(approveRejectCheckList.size()!=0 && Validator.isNotNull(approveRejectCheckList)){
									if(approveRejectCheckList.get(0).getStatus()==1){
										url = popupUrl.replace("1_" + lastDay, count + "_" + weekDateinString);;
										disabled = "";
									} else {
										url = popup;
										disabled = "disabled";
									}
								}

								boolean foundEntry = false;

								for (TimeSheetEntry tse : timeSheetEntries) {
									if (tse.getProjectId() == project.getProjectId()
											&& tse.getProjectTaskId() == task.getTaskId()
											&& tse.getEntryDate().getTime() == day.getTime()) {
										tsStr = tsStr
												+ "<td>&nbsp&nbsp <div class='ElementWrap'><label>Hours:</label><input name='_"
												+ portletId + "_hours" + count + "_" + weekDateinString
												+ "' type='text' id='hours" + count + "_" + weekDateinString
												+ "' onchange='addTotalHours()' size='10' maxlength='8' min='1' value='"
												+ tse.getHours() + "' readonly='readonly'></input>" + "<input name='_"
												+ portletId + "_workDescription" + count + "_" + weekDateinString
												+ "' type='hidden' id='workDescription" + count + "_" + weekDateinString
												+ "' value='" + tse.getWorkDescription()
												+ "' readonly='readonly'></input>"
												+ "<a class='btn btn-primary btn-sm marginTop10p' name='fillHrs' type='submit' href='"
												+ url + "' " + disabled + ">Fill Hours</a></div>&nbsp&nbsp</td>";
										foundEntry = true;
										foundTask = true;
										break;
									}
								}

								if (!foundEntry) {
									tsStr = tsStr
											+ "<td>&nbsp&nbsp <div class='ElementWrap'><label>Hours:</label><input name='_"
											+ portletId + "_hours" + count + "_" + weekDateinString
											+ "' type='text' id='hours" + count + "_" + weekDateinString
											+ "' onchange='addTotalHours()' size='10' maxlength='8' min='1' value='" + 0
											+ "' readonly='readonly'></input>" + "<input name='_" + portletId
											+ "_workDescription" + count + "_" + weekDateinString
											+ "' type='hidden' id='workDescription" + count + "_" + weekDateinString
											+ "' value='' readonly='readonly'></input>"
											+ "<a class='btn btn-primary btn-sm marginTop10p' name='fillHrs' type='submit' href='"
											+ url + "' " + disabled + ">Fill Hours</a></div>&nbsp&nbsp</td>";
								}

							}

							if (foundTask) {
								projectOption = "";
								for (Entry<Long, String> entry : projectMap.entrySet()) {
									if (entry.getKey() == project.getProjectId()) {
										projectOption = projectOption + "<option value='" + entry.getKey()
												+ "' selected >" + "" + entry.getValue() + "</option>";
									} else {
										projectOption = projectOption + "<option value='" + entry.getKey() + "' >" + ""
												+ entry.getValue() + "</option>";
									}

								}
								taskOption = "";
								for (Entry<Long, String> entry : taskMap.entrySet()) {
									if (entry.getKey() == task.getTaskId()) {
										taskOption = taskOption + "<option value='" + entry.getKey() + "' selected >"
												+ "" + entry.getValue() + "</option>";
									} else {
										taskOption = taskOption + "<option value='" + entry.getKey() + "' >" + ""
												+ entry.getValue() + "</option>";
									}

								}
								String disableStatus = "";
								if(Integer.parseInt(submitStatus)==1){
									disableStatus = "disabled";
								}
								if(approveRejectCheckList.size()!=0 && Validator.isNotNull(approveRejectCheckList)){
									if(approveRejectCheckList.get(0).getStatus()==1){
										disableStatus = "";
									} else {
										disableStatus = "disabled";
									}
								}
								timeSheetEntry = timeSheetEntry + "<tr id='row" + count
										+ "' class='tableRow'><td style='padding-left: 10px;'>&nbsp&nbsp"
										+ "<div class='ElementWrap'><label>Select Project:</label>" + "<select name='_"
										+ portletId + "_selectProject" + count
										+ "' label='Select Project' id='selectProject" + count
										+ "' onChange='changeProj(this.value,this.id);' required='true'"+disableStatus+"><option value=''>Select Project</option>"
										+ projectOption + "</select></td>"
										+ "<td style='padding-left: 10px;'>&nbsp&nbsp<div class='ElementWrap'><label>Select Task:</label>"
										+ "<select name='_" + portletId + "_selectTask" + count
										+ "'	label='Select Task' id='selectTask" + count
										+ "' onchange='checkDuplicate(this.id);'' required='true'"+disableStatus+"><option value=''>Select Task</option>"
										+ taskOption + "</select></td>" + tsStr
										+ "<td><button class='btn btn-primary btn-sm DeleteBtn' type='button' id='DeleteBtn" + count
										+ "' onclick='DeleteRow(this.id)'"+disableStatus+">Delete</button></td></tr>";
								count = count + 1;

							}

							// System.out.println("rowCount--"+rowCount);
							/* if(rowCount<distinctTimesheetList.size()){ */
							// rowCount = rowCount + 1;
							/*
							 * }else{ rowCount = distinctTimesheetList.size();
							 * break; }
							 */
							/* } */
						}
					}

					txtHtml = txtHtml + timeSheetEntry;

				}
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("entries", txtHtml);
				PrintWriter printWriter = response.getWriter();
				printWriter.print(jsonObject);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void updateAssetEntry(User user, long groupId, TimeSheetMaster timesheetMaster, String postName) throws PortalException {
		System.out.println("class pk--" + timesheetMaster.getTimesheetParentId());
		System.out.println("class name id--" + TimeSheetMaster.class.getName());
		AssetEntry assetEntry = AssetEntryLocalServiceUtil
				.createAssetEntry(CounterLocalServiceUtil.increment(AssetEntry.class.getName()));
		assetEntry.setUserId(user.getUserId());
		assetEntry.setGroupId(groupId);
		assetEntry.setCreateDate(new Date());
		assetEntry.setModifiedDate(new Date());
		assetEntry.setClassName(TimeSheetMaster.class.getName());
		assetEntry.setClassPK(timesheetMaster.getTimesheetParentId());
		assetEntry.setClassUuid(null);
		assetEntry.setClassTypeId(0L);
		assetEntry.setListable(Boolean.TRUE);
		assetEntry.setVisible(Boolean.TRUE);
		assetEntry.setStartDate(null);
		assetEntry.setEndDate(null);
		assetEntry.setExpirationDate(null);
		assetEntry.setMimeType(ContentTypes.TEXT_HTML);
		assetEntry.setTitle(postName);
		assetEntry.setDescription(StringPool.BLANK);
		assetEntry.setUrl(null);
		assetEntry.setLayoutUuid(null);
		System.out.println("assetEntry--" + assetEntry);
		try {
			AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry);
			System.out.println("assetEntry inside update--" + assetEntry);
		} catch (Exception e) {
			System.out.println("Error While updating AssetEntry.............................");
			e.printStackTrace();

		}

	}

	/*
	 * public static void setRole(long companyId, long userId) throws
	 * PortalException{ User user = UserLocalServiceUtil.getUser(userId); Role
	 * liferayRole = RoleLocalServiceUtil.fetchRole(companyId,
	 * "Project Manager"); RoleLocalServiceUtil.addUserRole(user.getUserId(),
	 * liferayRole.getRoleId()); //UserLocalServiceUtil.updateUser(user); }
	 */

	public List<Date> getDateRange(Date startDate, Date endDate) {
		List<Date> dates = new ArrayList<Date>();
		long interval = 1000 * 60 * 60 * 24;
		long endtime = endDate.getTime();
		long curTime = startDate.getTime();
		while (curTime <= endtime) {
			dates.add(new Date(curTime));
			curTime += interval;
		}

		return dates;
	}

	/*
	 * public static void main(String args[]) throws ParseException{ Date
	 * testdate= formatter.parse("22/07/2018"); Date testdate1=
	 * formatter.parse("16/07/2018"); for(Date d:new
	 * MyTimesheetPortlet().getDateRange(testdate1, testdate)){
	 * System.out.println(d); } }
	 */

}