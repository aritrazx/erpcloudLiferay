package com.liferay.famocom.erpcloud.attendanceregister.portlet;

import com.liferay.famocom.erpcloud.attendanceregister.constants.AttendanceRegisterPortletKeys;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;
import com.liferay.famocom.erpcloud.model.SchedulesDetails;
import com.liferay.famocom.erpcloud.model.SchedulesMaster;
import com.liferay.famocom.erpcloud.model.WorksSchedules;
import com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.WorksSchedulesLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=AttendanceRegister Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AttendanceRegisterPortletKeys.AttendanceRegister,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AttendanceRegisterPortlet extends MVCPortlet {
	public static void attendenceRegister(ActionRequest actionRequest, ActionResponse actionResponse) {
		String selectEmployee = ParamUtil.getString(actionRequest, "selectEmployee", StringPool.BLANK);
		String month = ParamUtil.getString(actionRequest, "month", StringPool.BLANK);
		String year = ParamUtil.getString(actionRequest, "year", StringPool.BLANK);
		/*
		 * actionRequest.setAttribute("selectEmployee",selectEmployee);
		 * actionRequest.setAttribute("month",month);
		 * actionRequest.setAttribute("year",year);
		 */
		List<String> allDateList = new ArrayList<String>();
		// String attendenceStatus="Absent";
		System.out.println("selectEmployee:-" + selectEmployee + "month:-" + month + "year:-" + year);

		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

	}

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		String selectEmployee = ParamUtil.getString(request, "selectEmployee", StringPool.BLANK);
		String month = ParamUtil.getString(request, "month", StringPool.BLANK);
		String year = ParamUtil.getString(request, "year", StringPool.BLANK);
		//System.out.println("AAAAAAAAAAAAA");
		System.out.println("selectEmployee" + selectEmployee + "month" + month + "year" + year);
		if (cmd.equals("exportXLS")) {
			try {
				exportToXls(request, response, selectEmployee, month, year);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}

	public void exportToXls(ResourceRequest request, ResourceResponse response, String selectEmployee, String month,
			String year) {
		String listType = "Attendance-Sheet.xlsx";
		// DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		int rownum = 0;
		int cellnum = 0;
		// for active employee
		List<User> userList = new ArrayList<>();
		DynamicQuery allUser = UserLocalServiceUtil.dynamicQuery();
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.eq("status", 0);
		allUser.add(criterion);
		userList = UserLocalServiceUtil.dynamicQuery(allUser);

		List<Employee> emp = EmployeeLocalServiceUtil.getEmployees(-1, -1);
		List<Employee> activeEmployee = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			DynamicQuery employee = EmployeeLocalServiceUtil.dynamicQuery();
			Criterion criterion1 = null;
			criterion1 = RestrictionsFactoryUtil.eq("userId", userList.get(i).getUserId());
			employee.add(criterion1);
			emp = EmployeeLocalServiceUtil.dynamicQuery(employee);
			activeEmployee.addAll(emp);
		}

		try {
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
			httpResponse.setContentType("application/vnd.ms-excel");
			httpResponse.setHeader("Content-Disposition", "attachment; filename=" + listType);
			ServletOutputStream out = httpResponse.getOutputStream();

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("sheet1");
			XSSFFont font = workbook.createFont();

			// font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFont(font);

			XSSFCellStyle styleForCost = workbook.createCellStyle();
			// styleForCost.setAlignment(CellStyle.ALIGN_RIGHT);
			Row row = sheet.createRow(rownum++);
			createCell(sheet, cellnum++, "Date", 22 * 500, row, style);
			createCell(sheet, cellnum++, "Employee Code", 22 * 500, row, style);
			createCell(sheet, cellnum++, "Employee Name", 10 * 500, row, style);
			createCell(sheet, cellnum++, "In Time", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Out Time", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Total Time", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Status", 10 * 500, row, style);

			List<String> allDt = new ArrayList<>();
			if (Validator.isNotNull(month) && Validator.isNotNull(year)) {
				Calendar cal = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
				do {
					int day = cal.get(Calendar.DAY_OF_WEEK);
					if (day == Calendar.MONDAY || day == Calendar.TUESDAY || day == Calendar.WEDNESDAY
							|| day == Calendar.THURSDAY || day == Calendar.FRIDAY) {
						/*
						 * System.out.println(cal.get(Calendar.DAY_OF_MONTH));
						 */
						String allDate = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/" + month + "/" + year;
						System.out.println("allDate:--" + allDate);
						allDt.add(allDate);
					}
					cal.add(Calendar.DAY_OF_YEAR, 1);
				} while (cal.get(Calendar.MONTH) == Integer.parseInt(month) - 1);
				/* actionRequest.setAttribute("dateList",allDateList); */
			}

			if (Validator.isNotNull(allDt) && Validator.isNotNull(selectEmployee)) {

				for (int i = 0; i < allDt.size(); i++) {
					Date listDate = new SimpleDateFormat("dd/MM/yyyy").parse(allDt.get(i));

					// Date format

					SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
					String strDate = formatter.format(listDate);

					Attendance att = AttendanceLocalServiceUtil.findByempIdAndAttDate(Long.parseLong(selectEmployee),
							listDate);
					LeaveApplyDtl leave = null;
					HolidayCalenderManagement holiday = null;
					SchedulesDetails sDetails = null;
					SchedulesMaster sMasterObj = null;
					WorksSchedules ws = null;
					// holiday=HolidayCalenderManagementLocalServiceUtil.findByempIdAndAttDate(listDate);
					if (att == null) {
						leave = LeaveApplyDtlLocalServiceUtil.findByempIdAndAttDate(Long.parseLong(selectEmployee),
								listDate, 1);
					}
					if (att == null && leave == null) {
						holiday = HolidayCalenderManagementLocalServiceUtil.findByempIdAndAttDate(listDate);
					}
					if (att == null && leave == null && holiday == null) {
						sDetails = SchedulesDetailsLocalServiceUtil
								.findByempIdAndAttDate(Long.parseLong(selectEmployee), listDate);
					}
					Employee empList = EmployeeLocalServiceUtil.getEmployee(Long.parseLong(selectEmployee));
					cellnum = 0;
					String Fullname = "";
					Fullname = empList.getFirstName() + " " + empList.getLastName();
					if (att != null) {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, Fullname, row);
						createCell(sheet, cellnum++, att.getInTime(), row);
						createCell(sheet, cellnum++, att.getOutTime(), row);
						createCell(sheet, cellnum++, att.getTotal(), row);
						createCell(sheet, cellnum++, att.getStatus(), row);
					} else if (leave != null) {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, Fullname, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, "Leave", row);
					} else if (holiday != null) {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, Fullname, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, "Holiday", row);
					} else if (sDetails != null) {
						ws = WorksSchedulesLocalServiceUtil.getWorksSchedules(sDetails.getWorksSchedulesId());
						sMasterObj = SchedulesMasterLocalServiceUtil.getSchedulesMaster(ws.getSchedulesId());
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, Fullname, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, sMasterObj.getSchedulesName(), row);
					} else {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, Fullname, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, "Absent", row);
					}
				}
			}
			if((!Validator.isNotNull(selectEmployee)) && Validator.isNotNull(allDt)){
		  		for(int i=0;i<allDt.size();i++){
		  			
		  			for(int j=0;j<activeEmployee.size();j++){
		  		
		  	  		Date listDate=new SimpleDateFormat("dd/MM/yyyy").parse(allDt.get(i)); 
		  	  		
		  	  		//Date format
		  	  		
		  	  		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		  			String strDate = formatter.format(listDate);
		  			
		  			Attendance att = AttendanceLocalServiceUtil.findByempIdAndAttDate(activeEmployee.get(j).getEmployeeId(), listDate);
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
		  	  		String FullName = empList.getFirstName()+" "+empList.getLastName();
		  	  		cellnum=0;
		  	  		if(att!=null){ 
			  	  		row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, FullName, row);
						createCell(sheet, cellnum++, att.getInTime(), row);
						createCell(sheet, cellnum++, att.getOutTime(), row);
						createCell(sheet, cellnum++, att.getTotal(), row);
						createCell(sheet, cellnum++, att.getStatus(), row);
		  	  		}
		  	  		else if (leave != null) {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, FullName, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, "Leave", row);
					} else if (holiday != null) {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, FullName, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, "Holiday", row);
					} else if (sDetails != null) {
						ws = WorksSchedulesLocalServiceUtil.getWorksSchedules(sDetails.getWorksSchedulesId());
						sMasterObj = SchedulesMasterLocalServiceUtil.getSchedulesMaster(ws.getSchedulesId());
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, FullName, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, sMasterObj.getSchedulesName(), row);
					} else {
						row = sheet.createRow(rownum++);
						createCell(sheet, cellnum++, strDate, row);
						createCell(sheet, cellnum++, empList.getEmployeeCode(), row);
						createCell(sheet, cellnum++, FullName, row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, " ", row);
						createCell(sheet, cellnum++, "Absent", row);
					}
		  			}
		  		}
			}
			

			
			workbook.write(out);
			out.flush();
			out.close();
			workbook.close();
			try {
				httpResponse.flushBuffer();
			} catch (Exception ex) {
				//ex.printStackTrace();
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}

	}

	public static Cell createCell(XSSFSheet sheet, int cellnum, String cellName, int columnWidth, Row row,
			XSSFCellStyle style) {
		if (columnWidth > 0) {
			sheet.setColumnWidth(cellnum, columnWidth);
		}
		Cell cell = row.createCell(cellnum++);

		cell.setCellValue(cellName);
		if (style != null) {
			cell.setCellStyle(style);
		}
		return cell;
	}

	public static Cell createCell(XSSFSheet sheet, int cellnum, String cellName, Row row) {
		Cell cell = row.createCell(cellnum++);
		cell.setCellValue(cellName);
		return cell;
	}

	public static Cell createCell(XSSFSheet sheet, int cellnum, long cellName, Row row) {
		Cell cell = row.createCell(cellnum++);
		cell.setCellValue(cellName);
		return cell;
	}

	public static Cell createCell(XSSFSheet sheet, int cellnum, Date cellName, Row row) {
		Cell cell = row.createCell(cellnum++);
		cell.setCellValue(cellName);
		return cell;
	}
}