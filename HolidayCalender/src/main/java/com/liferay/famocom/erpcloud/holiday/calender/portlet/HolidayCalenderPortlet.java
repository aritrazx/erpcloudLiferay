package com.liferay.famocom.erpcloud.holiday.calender.portlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.holiday.calender.constants.HolidayCalenderPortletKeys;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;
import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author aritrazx
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=HolidayCalender Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HolidayCalenderPortletKeys.HolidayCalender,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class HolidayCalenderPortlet extends MVCPortlet {

	/**
	 * HoliDay save from form Submit
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ProcessAction(name = "holidayCalenderSave")
	public void holidayCalenderSave(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("callll Addddddd ");
		String holidayDate = ParamUtil.getString(actionRequest, "holidayDate", StringPool.BLANK);
		Date holidayDate1 = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // To date input
		try {
			holidayDate1 = (Date) df.parse(holidayDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// System.out.println("Holidaydate is-->"+holidayDate);
		String holidayName = ParamUtil.getString(actionRequest, "holidayName", StringPool.BLANK);
		// System.out.println("Holiday is -->"+holidayName);

		DynamicQuery dynamicQuery = HolidayCalenderManagementLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("holidayDate").eq(holidayDate1));
		List<HolidayCalenderManagement> list = HolidayCalenderManagementLocalServiceUtil.dynamicQuery(dynamicQuery);
		// boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			SessionErrors.add(actionRequest, "Add-date-error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addHoliday.jsp");
		}

		DynamicQuery dynamicQuery1 = HolidayCalenderManagementLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("holidayName").eq(holidayName));
		List<HolidayCalenderManagement> namelist = HolidayCalenderManagementLocalServiceUtil.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(namelist) && !namelist.isEmpty()) {
			SessionErrors.add(actionRequest, "Add-name-error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addHoliday.jsp");
		}
		if (list.size() == 0 && namelist.size() == 0) {
			try {
				long holidayId = CounterLocalServiceUtil.increment(HolidayCalenderManagement.class.getName());
				HolidayCalenderManagement holidayCalenderManagement = HolidayCalenderManagementLocalServiceUtil
						.createHolidayCalenderManagement(holidayId);
				holidayCalenderManagement.setHolidayDate(holidayDate1);
				holidayCalenderManagement.setHolidayName(holidayName);
				holidayCalenderManagement.setHolidayStartDate(holidayDate1);
				holidayCalenderManagement.setHolidayEndDate(holidayDate1);
				HolidayCalenderManagementLocalServiceUtil.addHolidayCalenderManagement(holidayCalenderManagement);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * HoliDay edit from searchContainer Action button
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ProcessAction(name = "holidayCalenderEdit")
	public void holidayCalenderEdit(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("Calll Edit ");
		List<String> errorlist = new ArrayList<String>();
		long holidayId = ParamUtil.getLong(actionRequest, "holidayId");
		System.out.println("holidayID "+holidayId);
		String holidayDate = ParamUtil.getString(actionRequest, "holidayDate", StringPool.BLANK);
		Date holidayDate1 = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // To date input
		try {
			holidayDate1 = (Date) df.parse(holidayDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String holidayName = ParamUtil.getString(actionRequest, "holidayName", StringPool.BLANK);
		List<HolidayCalenderManagement>  dateCalenderManagement = HolidayCalenderManagementLocalServiceUtil.findByDateAndHoliDayId(holidayDate1, holidayId);
		List<HolidayCalenderManagement> nameCalenderManagement = HolidayCalenderManagementLocalServiceUtil.findByNameAndHoliDayId(holidayName, holidayId);
		System.out.println("dateCalenderManagement "+dateCalenderManagement.size());
		System.out.println("nameCalenderManagement.size"+nameCalenderManagement.size());
		if(dateCalenderManagement.size()==0 ){
				if(nameCalenderManagement.size()==0){
			try {
				HolidayCalenderManagement holidayCalenderManagement = HolidayCalenderManagementLocalServiceUtil.getHolidayCalenderManagement(holidayId);
				holidayCalenderManagement.setHolidayDate(holidayDate1);
				holidayCalenderManagement.setHolidayName(holidayName);
				holidayCalenderManagement.setHolidayStartDate(holidayDate1);
				holidayCalenderManagement.setHolidayEndDate(holidayDate1);
				HolidayCalenderManagementLocalServiceUtil.updateHolidayCalenderManagement(holidayCalenderManagement);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}else{
			SessionErrors.add(actionRequest, "Add-name-error");
			SessionMessages.add(actionRequest,
			PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addHoliday.jsp");
		}
		}else{
			SessionErrors.add(actionRequest, "Add-date-error");
			SessionMessages.add(actionRequest,
			PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addHoliday.jsp");
		}
	}
	/**
	 * HoliDay delete from searchContainer Action button
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ProcessAction(name = "holidayCalenderDelete")
	public void holidayCalenderDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long holidayId = ParamUtil.getLong(actionRequest, "holidayId");
		if(Validator.isNotNull(holidayId)){
			try{
				HolidayCalenderManagement holidayCalenderManagement = HolidayCalenderManagementLocalServiceUtil.getHolidayCalenderManagement(holidayId);
				HolidayCalenderManagementLocalServiceUtil.deleteHolidayCalenderManagement(holidayCalenderManagement);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	/*
	 * public void serveResource(ResourceRequest request, ResourceResponse
	 * response) throws IOException, PortletException { String cmd =
	 * ParamUtil.getString(request, Constants.CMD);
	 * System.out.println("cmd----------"+cmd); if (cmd.equals("exportXLS")) {
	 * try { exportToXls(request, response);
	 * System.out.println("iffffff satisfiedddddddd --------"); } catch
	 * (Exception e) { e.printStackTrace(); } } else if
	 * (cmd.equals("exportXLSToCheck")) { try { exportXLSToCheck(request,
	 * response); } catch (Exception e) { e.printStackTrace(); } } } public void
	 * exportToXls(ResourceRequest request, ResourceResponse response) {
	 * System.out.println("::::::::::::::::::Generate xlsx:::::::::::::::::::::"
	 * ); String listType = "Holiday-Calender.xlsx"; int rownum = 0; int cellnum
	 * = 0; try { HttpServletResponse httpResponse =
	 * PortalUtil.getHttpServletResponse(response);
	 * httpResponse.setContentType("application/vnd.ms-excel");
	 * httpResponse.setHeader("Content-Disposition", "attachment; filename=" +
	 * listType); ServletOutputStream out = httpResponse.getOutputStream();
	 * 
	 * XSSFWorkbook workbook = new XSSFWorkbook(); XSSFSheet sheet =
	 * workbook.createSheet("sheet1"); XSSFFont font = workbook.createFont();
	 * 
	 * XSSFCellStyle style = workbook.createCellStyle();
	 * style.setFillForegroundColor(IndexedColors.RED.getIndex());
	 * style.setFont(font);
	 * 
	 * XSSFCellStyle styleForCost = workbook.createCellStyle(); Row row =
	 * sheet.createRow(rownum++);
	 * 
	 * createCell(sheet, cellnum++, "Date(dd/MM/yyyy)", 30 * 500, row, style);
	 * createCell(sheet, cellnum++, "Holiday Name", 50 * 500, row, style); row =
	 * sheet.createRow(rownum++); workbook.write(out); out.flush(); out.close();
	 * workbook.close(); try { httpResponse.flushBuffer(); } catch (Exception
	 * ex) { ex.printStackTrace(); } } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * public static Cell createCell(XSSFSheet sheet, int cellnum, String
	 * cellName, int columnWidth, Row row, XSSFCellStyle style) { if
	 * (columnWidth > 0) { sheet.setColumnWidth(cellnum, columnWidth); } Cell
	 * cell = row.createCell(cellnum++);
	 * 
	 * cell.setCellValue(cellName); if (style != null) {
	 * cell.setCellStyle(style); } return cell; }
	 * 
	 * public static Cell createCell(XSSFSheet sheet, int cellnum, String
	 * cellName, Row row) { Cell cell = row.createCell(cellnum++);
	 * cell.setCellValue(cellName); return cell; }
	 * 
	 * public static Cell createCell(XSSFSheet sheet, int cellnum, long
	 * cellName, Row row) { Cell cell = row.createCell(cellnum++);
	 * cell.setCellValue(cellName); return cell; }
	 * 
	 * public static Cell createCell(XSSFSheet sheet, int cellnum, Date
	 * cellName, Row row) { Cell cell = row.createCell(cellnum++);
	 * cell.setCellValue(cellName); return cell; } private void
	 * exportXLSToCheck(ResourceRequest request, ResourceResponse response) {
	 * String listType = "HolidAY-Attendance-Sheet-Check.xlsx"; int rownum = 0;
	 * int cellnum = 0; try {
	 * 
	 * HttpServletResponse httpResponse =
	 * PortalUtil.getHttpServletResponse(response);
	 * httpResponse.setContentType("application/vnd.ms-excel");
	 * httpResponse.setHeader("Content-Disposition", "attachment; filename=" +
	 * listType); ServletOutputStream out = httpResponse.getOutputStream();
	 * 
	 * XSSFWorkbook workbook = new XSSFWorkbook(); XSSFSheet sheet =
	 * workbook.createSheet("sheet2"); XSSFFont font = workbook.createFont();
	 * 
	 * XSSFCellStyle style = workbook.createCellStyle();
	 * style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	 * style.setFont(font);
	 * 
	 * XSSFCellStyle styleForCost = workbook.createCellStyle(); Row row =
	 * sheet.createRow(rownum++); createCell(sheet, cellnum++, "Employee Code",
	 * 22 * 500, row, style); createCell(sheet, cellnum++, "Employee Name", 10 *
	 * 500, row, style); createCell(sheet, cellnum++, "In Time Hour(hh)", 10 *
	 * 500, row, style); createCell(sheet, cellnum++, "In Time Minute(mm)", 10 *
	 * 500, row, style); createCell(sheet, cellnum++, "Out Time Hour(hh)", 10 *
	 * 500, row, style); createCell(sheet, cellnum++, "Out Time Minute(mm)", 10
	 * * 500, row, style); createCell(sheet, cellnum++, "Status", 10 * 500, row,
	 * style); if (Validator.isNotNull(attCheckList)) {
	 * 
	 * for (AttendanceCheckList attObj : attCheckList) { cellnum = 0; row =
	 * sheet.createRow(rownum++);
	 * 
	 * createCell(sheet, cellnum++, attObj.getEmployeeCode(), row);
	 * createCell(sheet, cellnum++, attObj.getFullName(), row);
	 * createCell(sheet, cellnum++, attObj.getInTimeHour(), row);
	 * createCell(sheet, cellnum++, attObj.getInTimeMin(), row);
	 * createCell(sheet, cellnum++, attObj.getOutTimeHour(), row);
	 * createCell(sheet, cellnum++, attObj.getOutTimeMin(), row);
	 * createCell(sheet, cellnum++, attObj.getMsg(), row); } }
	 * workbook.write(out); out.flush(); out.close(); workbook.close(); try {
	 * httpResponse.flushBuffer(); } catch (Exception ex) {
	 * ex.printStackTrace(); } } catch (Exception e) { // TODO: handle exception
	 * }
	 * 
	 * }
	 */


}