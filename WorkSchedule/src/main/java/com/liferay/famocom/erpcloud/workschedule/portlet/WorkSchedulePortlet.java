package com.liferay.famocom.erpcloud.workschedule.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.SchedulesDetails;
import com.liferay.famocom.erpcloud.model.SchedulesMaster;
import com.liferay.famocom.erpcloud.model.WorksSchedules;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.WorksSchedulesLocalServiceUtil;
import com.liferay.famocom.erpcloud.workschedule.constants.WorkSchedulePortletKeys;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WorkSchedule Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WorkSchedulePortletKeys.WorkSchedule,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WorkSchedulePortlet extends MVCPortlet {

	public void worksSchedules(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// long selectEmployee = ParamUtil.getLong(actionRequest,
		// "selectEmployee");
		String fromDate = ParamUtil.get(actionRequest, "fromDate", StringPool.BLANK);
		System.out.println("fromDate"+fromDate);
		String toDate = ParamUtil.get(actionRequest, "toDate", StringPool.BLANK);
		System.out.println("toDate"+toDate);
		String description = ParamUtil.get(actionRequest, "description", StringPool.BLANK);
		long workSchedules = ParamUtil.getLong(actionRequest, "workSchedules");

		try {
			Date fDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
			Date tDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);

			List<Date> dateListTemp = new ArrayList<Date>(); // Total days list
			dateListTemp = getDateListFromRange(fDate, tDate);
			
			/*int dateBeforeCheck=compareDate(fDate,tDate);
			System.out.println("dateBeforeCheck"+dateBeforeCheck);*/
			
			System.out.println("dateList-----" + dateListTemp);

			long worksSchedulesId = CounterLocalServiceUtil.increment(WorksSchedules.class.getName());
			WorksSchedules worksSchedules = WorksSchedulesLocalServiceUtil.createWorksSchedules(worksSchedulesId);

			ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User userTemp = td.getUser();
			Employee empIdName = EmployeeLocalServiceUtil.findByemployees(userTemp.getUserId());
			List<SchedulesDetails> detailsCheck = null;
			List<String> errorList = null;
			for (Date dateList : dateListTemp) {
				try {
					long scheduleDetailsId = CounterLocalServiceUtil.increment(SchedulesDetails.class.getName());
					SchedulesDetails details = SchedulesDetailsLocalServiceUtil
							.createSchedulesDetails(scheduleDetailsId);
					
					detailsCheck = SchedulesDetailsLocalServiceUtil.findBycheckDate(empIdName.getEmployeeId(),
							empIdName.getCompanyId(), dateList);
					//List<WorksSchedules> schedulesCheck=WorksSchedulesLocalServiceUtil.findbyfromToDate(fDate, tDate);
					List<WorksSchedules> schedulesCheck=WorksSchedulesLocalServiceUtil.findbytoDate(tDate);
					System.out.println("detailsCheck:--" + detailsCheck.size());
					errorList = new ArrayList<>();
					if (!(detailsCheck.isEmpty() && schedulesCheck.isEmpty())) {
						errorList.add("sorry???");
					}
					if (errorList.isEmpty()) {
						System.out.println("AAAAAAA");
						details.setSchedulesDate(dateList);
						details.setEmployeeId(empIdName.getEmployeeId());
						details.setCompanyId(empIdName.getCompanyId());
						details.setWorksSchedulesId(worksSchedulesId);
						SchedulesDetailsLocalServiceUtil.addSchedulesDetails(details);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
					} else{
						SessionErrors.add(actionRequest, "error");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
						break;
					}
					/*if(dateBeforeCheck!=0){
						SessionErrors.add(actionRequest, "errorTest");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
					}*/
					
					// System.out.println("dateList2222--"+dateList);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("errorList:--" + errorList);

			if (errorList.isEmpty()) {
				worksSchedules.setEmployeeId(empIdName.getEmployeeId());
				worksSchedules.setCompanyId(userTemp.getCompanyId());
				worksSchedules.setFromDate(fDate);
				worksSchedules.setToDate(tDate);
				worksSchedules.setSchedulesId(workSchedules);
				worksSchedules.setDescription(description);
				WorksSchedulesLocalServiceUtil.addWorksSchedules(worksSchedules);
			}

		} catch (Exception e) {
		}
	}

	/* For all dates */
	public List<Date> getDateListFromRange(Date fromDate, Date toDate) {
		System.out.println("BBBB");
		List<Date> dateList = new ArrayList<Date>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);

		while (calendar.getTime().before(toDate)) {
			Date result = calendar.getTime();
			dateList.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		while (calendar.getTime().equals(toDate)) {
			Date result = calendar.getTime();
			dateList.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		return dateList;
	}
/*	public int compareDate(Date fromDate, Date toDate) {
		int check=0;
		if(toDate.before(fromDate)){
           check ++;
        }
		return check;
	}*/
	
	/*Edit WorksSchedule */
	public void worksSchedulesEdit(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long worksSchedulesId = ParamUtil.getLong(actionRequest, "worksSchedulesId");
		// long selectEmployee = ParamUtil.getLong(actionRequest,
		// "selectEmployee");
		String fromDate = ParamUtil.get(actionRequest, "fromDate", StringPool.BLANK);
		String toDate = ParamUtil.get(actionRequest, "toDate", StringPool.BLANK);
		String description = ParamUtil.get(actionRequest, "description", StringPool.BLANK);
		long workSchedules = ParamUtil.getLong(actionRequest, "workSchedules");
		
		try {
			WorksSchedules scheduleEdit = WorksSchedulesLocalServiceUtil.getWorksSchedules(worksSchedulesId);

			ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User userTemp = td.getUser();
			Employee empIdName = EmployeeLocalServiceUtil.findByemployees(userTemp.getUserId());
			// Employee emp =
			// EmployeeLocalServiceUtil.getEmployee(selectEmployee);
			Date fDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
			Date tDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
			
           List<SchedulesDetails> detailsTemp =SchedulesDetailsLocalServiceUtil.findBydetailsEdit(worksSchedulesId);
           for(SchedulesDetails scheduleDelete:detailsTemp){
        	  SchedulesDetails sd= SchedulesDetailsLocalServiceUtil.getSchedulesDetails(scheduleDelete.getSchedulesDetailsId());
        	  SchedulesDetailsLocalServiceUtil.deleteSchedulesDetails(sd);
        	  System.out.println("SchedulesDetails Delete");
           }
           List<Date> dateListTemp = new ArrayList<Date>(); // Total days list
           dateListTemp = getDateListFromRange(fDate, tDate);
           List<SchedulesDetails> detailsCheck = null;
			List<String> errorList = null;
			for (Date dateList : dateListTemp) {
				try {
					long scheduleDetailsId = CounterLocalServiceUtil.increment(SchedulesDetails.class.getName());
					SchedulesDetails details = SchedulesDetailsLocalServiceUtil
							.createSchedulesDetails(scheduleDetailsId);

					detailsCheck = SchedulesDetailsLocalServiceUtil.findBycheckDate(empIdName.getEmployeeId(),
							empIdName.getCompanyId(), dateList);
					System.out.println("detailsCheck:--" + detailsCheck.size());
					errorList = new ArrayList<>();
					if (!(detailsCheck.isEmpty())){
						errorList.add("sorry???");
					}
					if (errorList.isEmpty()) {
						details.setSchedulesDate(dateList);
						details.setEmployeeId(empIdName.getEmployeeId());
						details.setCompanyId(empIdName.getCompanyId());
						details.setWorksSchedulesId(worksSchedulesId);
						SchedulesDetailsLocalServiceUtil.addSchedulesDetails(details);
					} else {
						SessionErrors.add(actionRequest, "error");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");

					}
					// System.out.println("dateList2222--"+dateList);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
           System.out.println("detailsTemp:---"+detailsTemp.size());
           if (errorList.isEmpty()) {
           	scheduleEdit.setEmployeeId(empIdName.getEmployeeId());
			scheduleEdit.setCompanyId(userTemp.getCompanyId());
			scheduleEdit.setFromDate(fDate);
			scheduleEdit.setToDate(tDate);
			scheduleEdit.setSchedulesId(workSchedules);
			scheduleEdit.setDescription(description);
			WorksSchedulesLocalServiceUtil.updateWorksSchedules(scheduleEdit);
           }

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/*delete WorkSchedule*/
	public void deleteWorkSchedules(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, IOException {
		long id = ParamUtil.getLong(actionRequest, "id");
		List<String> errorList = null;
		 List<SchedulesDetails> detailsTemp =null;
		 try{
			 errorList=new ArrayList<>();
			 detailsTemp=SchedulesDetailsLocalServiceUtil.findBydetailsEdit(id);
			 WorksSchedules worksSchedulesDelete=WorksSchedulesLocalServiceUtil.getWorksSchedules(id);
			 if (worksSchedulesDelete.getIslock()!=0) {
					errorList.add("sorry???");
				}
			 if(errorList.isEmpty()){
	         WorksSchedulesLocalServiceUtil.deleteWorksSchedules(worksSchedulesDelete);
		 
	         for(SchedulesDetails scheduleDelete:detailsTemp){
	      	  SchedulesDetails sd= SchedulesDetailsLocalServiceUtil.getSchedulesDetails(scheduleDelete.getSchedulesDetailsId());
	      	  SchedulesDetailsLocalServiceUtil.deleteSchedulesDetails(sd);
	         }
			 }else{
				 SessionErrors.add(actionRequest, "errorTemp");
				 SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				 actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
	         }
	         
		 }catch (Exception e) {
				// TODO: handle exception
			}

	}
	
	
	

	// Schedule Master Add
	public void addSchedules(ActionRequest actionRequest, ActionResponse actionResponse) {
		String scheduleName = ParamUtil.get(actionRequest, "scheduleName", StringPool.BLANK);
		String scheduleDescription = ParamUtil.get(actionRequest, "scheduleDescription", StringPool.BLANK);
		try {
			long schedulesId = CounterLocalServiceUtil.increment(WorksSchedules.class.getName());
			SchedulesMaster schedulesMaster = SchedulesMasterLocalServiceUtil.createSchedulesMaster(schedulesId);

			DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
			Date date = new Date();
			/*
			 * TimeZone gmtTime = TimeZone.getTimeZone("GMT"); TimeZone istTime
			 * = TimeZone.getTimeZone("IST"); formatter.setTimeZone(istTime);
			 */
			formatter.setTimeZone(TimeZone.getTimeZone("IST"));
			System.out.println("formatter.format(date)" + formatter.format(date));
			Date createDate = formatter.parse(formatter.format(date));

			schedulesMaster.setSchedulesName(scheduleName);
			schedulesMaster.setSchedulesDescription(scheduleDescription);
			schedulesMaster.setCreateDate(createDate);
			// schedulesMaster.setModifiedDate(m);
			SchedulesMasterLocalServiceUtil.addSchedulesMaster(schedulesMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Schedule Master Edit
	public void editSchedules(ActionRequest actionRequest, ActionResponse actionResponse) {
		long schedulesId = ParamUtil.getLong(actionRequest, "schedulesId");
		String scheduleName = ParamUtil.get(actionRequest, "scheduleName", StringPool.BLANK);
		String scheduleDescription = ParamUtil.get(actionRequest, "scheduleDescription", StringPool.BLANK);

		try {
			SchedulesMaster schedulesUpdate = SchedulesMasterLocalServiceUtil.getSchedulesMaster(schedulesId);

			// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd
			// HH:mm:ss");
			Date date = new Date();

			schedulesUpdate.setSchedulesName(scheduleName);
			schedulesUpdate.setSchedulesDescription(scheduleDescription);
			schedulesUpdate.setModifiedDate(date);

			SchedulesMasterLocalServiceUtil.updateSchedulesMaster(schedulesUpdate);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Schedule Master delete
	public void deleteSchedule(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, IOException {
		long id = ParamUtil.getLong(actionRequest, "id");
		System.out.println("schedulesId:--" + id);
		List<WorksSchedules> worksSchedules = WorksSchedulesLocalServiceUtil.findbyschedulesId(id);
		System.out.println("worksSchedules:--" + worksSchedules.size() + " worksSchedulessss " + worksSchedules);
		List<String> errorList = new ArrayList<>();
		if (!worksSchedules.isEmpty()) {
			errorList.add("sorry???");
		}
		System.out.println("errolist >> " + errorList);
		if (errorList.isEmpty()) {
			try {
				SchedulesMaster schedulesDelete = SchedulesMasterLocalServiceUtil.getSchedulesMaster(id);
				/* if (worksSchedules.size() == 0) { */

				// emailDelete =
				// EmailTemplateLocalServiceUtil.getEmailTemplate(id);
				SchedulesMasterLocalServiceUtil.deleteSchedulesMaster(schedulesDelete);

			} catch (Exception e) {
			}
		} else {
			SessionErrors.add(actionRequest, "error");
			SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addNewWorkSchedules.jsp");

		}

	}
}