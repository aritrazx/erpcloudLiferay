package com.liferay.famocom.erpcloud.myattendence.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.myattendence.constants.MyAttendencePortletKeys;
import com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Rajdip-Famocom
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyAttendencePortletKeys.MyAttendence,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyAttendencePortlet extends MVCPortlet {


	public void myAttendance(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException, IOException {
		String inTimeHour = ParamUtil.getString(actionRequest, "inTimeHour");
		String inTimeMinute = ParamUtil.getString(actionRequest, "inTimeMinute");
		String outTimeHour = ParamUtil.getString(actionRequest, "outTimeHour");
		String outTimeMinute = ParamUtil.getString(actionRequest, "outTimeMinute");
		String inTime = inTimeHour + ":" + inTimeMinute;
		String outTime = outTimeHour + ":" + outTimeMinute;
		
		// String total=null;

		DateFormat formatter = new SimpleDateFormat("HH:mm");
		java.sql.Time StartTime = null;
		java.sql.Time EndTime = null;
		/*System.out.println("inTimeHour" + inTimeHour + "inTimeMinute" + inTimeMinute + "outTimeHour" + outTimeHour
				+ "outTimeMinute" + outTimeMinute);*/
		DateFormat df = new SimpleDateFormat("yyyyy-mm-dd");
		Calendar calobj = Calendar.getInstance();
		calobj.set(Calendar.HOUR_OF_DAY, 0);
		calobj.set(Calendar.MINUTE, 0);
		calobj.set(Calendar.SECOND, 0);
		calobj.set(Calendar.MILLISECOND, 0);

		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		Employee employee=null;
		Attendance attend=null;
		if(Validator.isNotNull(userId)){
		 employee = EmployeeLocalServiceUtil.findByemployees(userId);
		 attend = AttendanceLocalServiceUtil.findByempIdAndAttDate(employee.getEmployeeId(),
				calobj.getTime());
		}

		
		Attendance attendance = null;
		
		if (attend == null) {

			try {
				long attendanceId = CounterLocalServiceUtil.increment(Attendance.class.getName());
				attendance = AttendanceLocalServiceUtil.createAttendance(attendanceId);
				attendance.setCompanyId(td.getCompanyId());
				attendance.setEmployeeCode(employee.getEmployeeCode());
				attendance.setEmployeeId(employee.getEmployeeId());
				attendance.setAttDate(calobj.getTime());
				attendance.setInTimeHour(inTimeHour);
				attendance.setInTimeMin(inTimeMinute);
				attendance.setInTime(inTime);
				attendance.setInDatePc(calobj.getTime());
				attendance.setStatus("Present");
				//System.out.println("attendance.getInTimeHour()" + attendance.getInTimeHour());
				AttendanceLocalServiceUtil.addAttendance(attendance);
				actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");

			} catch (Exception e) {
			}
		} else {
			try {
				attendance = AttendanceLocalServiceUtil.getAttendance(attend.getAttendanceId());
				attendance.setOutTimeHour(outTimeHour);
				attendance.setOutTimeMin(outTimeMinute);
				//boolean check = false;
				attendance.setOutTime(outTime);
				attendance.setOutDatePc(calobj.getTime());

				String d2 = attendance.getInTime();
				String d1 = outTime;
				StartTime = new java.sql.Time(formatter.parse(d2).getTime());
				EndTime = new java.sql.Time(formatter.parse(d1).getTime());
				long diff = EndTime.getTime() - StartTime.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;

				String total = String.valueOf(diffHours) + ":" + String.valueOf(diffMinutes);
				
				
				int inTimeMin=Integer.valueOf( attendance.getInTimeMin());
				int outTimeMin=Integer.valueOf(outTimeMinute);
				int inTimeHr=Integer.parseInt(attendance.getInTimeHour());
				int outTimeHr=Integer.parseInt(outTimeHour);
				attendance.setTotal(total);
				System.out.println("attendance.getInTimeHour()"+attendance.getInTimeHour());
				System.out.println("outTimeHour"+outTimeHour);
				System.out.println("inTimeMin"+inTimeMin);
				System.out.println("outTimeMin"+outTimeMin);
				if(inTimeHr==outTimeHr){
					System.out.println("iff!11111");
					if(inTimeMin<=outTimeMin){
						System.out.println("if2222");
						AttendanceLocalServiceUtil.updateAttendance(attendance);
						actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
					}else{
						System.out.println("else22222");
						SessionErrors.add(actionRequest, "inTimeMinError");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
						// System.out.println("ELSE>>>"+error);
						// httpRequest.setAttribute("error", error);

						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addAttendance.jsp");
					}
				}else{
					System.out.println("else1111");
					AttendanceLocalServiceUtil.updateAttendance(attendance);
					actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
				}
				

				
			} catch (Exception e) {

			}
		}

	}
	
}