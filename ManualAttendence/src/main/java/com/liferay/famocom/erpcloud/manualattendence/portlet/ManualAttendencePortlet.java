package com.liferay.famocom.erpcloud.manualattendence.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.digitornot.DigitOrNot;
import com.liferay.famocom.erpcloud.manualattendence.constants.ManualAttendencePortletKeys;
import com.liferay.famocom.erpcloud.model.Attendance;
import com.liferay.famocom.erpcloud.model.AttendanceBio;
import com.liferay.famocom.erpcloud.model.AttendanceCheckList;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.EmployeeType;
import com.liferay.famocom.erpcloud.service.AttendanceBioLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AttendanceLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=ManualAttendence Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ManualAttendencePortletKeys.ManualAttendence,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ManualAttendencePortlet extends MVCPortlet {

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		if (cmd.equals("exportXLS")) {
			try {
				exportToXls(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("exportXLSToCheck")) {
			try {
				exportXLSToCheck(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void exportXLSToCheck(ResourceRequest request, ResourceResponse response) {
		String listType = "Manual-Attendance-Sheet-Check.xlsx";
		int rownum = 0;
		int cellnum = 0;
		try {
			List<AttendanceCheckList> attCheckList = AttendanceCheckListLocalServiceUtil.getAttendanceCheckLists(-1,
					-1);

			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
			httpResponse.setContentType("application/vnd.ms-excel");
			httpResponse.setHeader("Content-Disposition", "attachment; filename=" + listType);
			ServletOutputStream out = httpResponse.getOutputStream();

			/*
			 * Workbook workbook = new XSSFWorkbook(); Sheet sheet =
			 * workbook.createSheet("Color Test"); Row row = sheet.createRow(0);
			 * CellStyle style = workbook.createCellStyle();
			 * style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			 * style.setFillPattern(style.SOLID_FOREGROUND); Font font =
			 * workbook.createFont();
			 * font.setColor(IndexedColors.RED.getIndex()); style.setFont(font);
			 * Cell cell1 = row.createCell(0); cell1.setCellValue("ID");
			 * cell1.setCellStyle(style); Cell cell2 = row.createCell(1);
			 * cell2.setCellValue("NAME"); cell2.setCellStyle(style);
			 * FileOutputStream fos = new FileOutputStream(new
			 * File("D:/xlsx/cp.xlsx")); workbook.write(fos); fos.close();
			 * System.out.println("Done");
			 */

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("sheet2");
			XSSFFont font = workbook.createFont();

			// font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			// XSSFCellStyle style = workbook.createCellStyle();
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			// style.setFillPattern(style);
			style.setFont(font);

			/*XSSFCellStyle styleColor = workbook.createCellStyle();
			styleColor.setFillForegroundColor(IndexedColors.RED.getIndex());
			styleColor.setFillPattern(FillPatternType.SOLID_FOREGROUND);*/

			XSSFCellStyle styleForCost = workbook.createCellStyle();
			// styleForCost.setAlignment(CellStyle.ALIGN_RIGHT);
			Row row = sheet.createRow(rownum++);
			// createCell(sheet, cellnum++, "Employee Id", 22 * 500, row,
			// style);
			createCell(sheet, cellnum++, "Employee Code", 22 * 500, row, style);
			createCell(sheet, cellnum++, "Employee Name", 10 * 500, row, style);
			createCell(sheet, cellnum++, "In Time Hour(hh)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "In Time Minute(mm)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Out Time Hour(hh)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Out Time Minute(mm)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Status", 10 * 500, row, style);
			if (Validator.isNotNull(attCheckList)) {

				for (AttendanceCheckList attObj : attCheckList) {
					cellnum = 0;
					row = sheet.createRow(rownum++);

					createCell(sheet, cellnum++, attObj.getEmployeeCode(), row);
					createCell(sheet, cellnum++, attObj.getFullName(), row);
					createCell(sheet, cellnum++, attObj.getInTimeHour(), row);
					createCell(sheet, cellnum++, attObj.getInTimeMin(), row);
					createCell(sheet, cellnum++, attObj.getOutTimeHour(), row);
					createCell(sheet, cellnum++, attObj.getOutTimeMin(), row);
					createCell(sheet, cellnum++, attObj.getMsg(), row);
				}
			}
			workbook.write(out);
			out.flush();
			out.close();
			workbook.close();
			try {
				httpResponse.flushBuffer();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void exportToXls(ResourceRequest request, ResourceResponse response) {
		String listType = "Manual-Attendance-Sheet.xlsx";
		// DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		int rownum = 0;
		int cellnum = 0;
		List<Employee> employee = EmployeeLocalServiceUtil.getEmployees(-1, -1);
		// Map<Long,String> empCodeName = new HashMap<>();
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
			// createCell(sheet, cellnum++, "Employee Id", 22 * 500, row,
			// style);
			createCell(sheet, cellnum++, "Employee Code", 22 * 500, row, style);
			createCell(sheet, cellnum++, "Employee Name", 10 * 500, row, style);
			createCell(sheet, cellnum++, "In Time Hour(hh)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "In Time Minute(mm)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Out Time Hour(hh)", 10 * 500, row, style);
			createCell(sheet, cellnum++, "Out Time Minute(mm)", 10 * 500, row, style);
			
			List<User> userList = new ArrayList<>();
			DynamicQuery allUser = UserLocalServiceUtil.dynamicQuery();
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("status",0);
			allUser.add(criterion);
			userList = UserLocalServiceUtil.dynamicQuery(allUser);
			List<Employee> emp = EmployeeLocalServiceUtil.getEmployees(-1,-1);
			List<Employee> activeEmployee= new ArrayList<>();
			
			for(int i=0;i<userList.size();i++){
				DynamicQuery employeeObj = EmployeeLocalServiceUtil.dynamicQuery();
				Criterion criterion1 = null;
				criterion1 = RestrictionsFactoryUtil.eq("userId",userList.get(i).getUserId());
				employeeObj.add(criterion1);
				emp= EmployeeLocalServiceUtil.dynamicQuery(employeeObj);
				activeEmployee.addAll(emp);
			}
			
			for (Employee empObj : activeEmployee) {
				cellnum = 0;
				String Fullname = "";
				Fullname = empObj.getFirstName() + " " + empObj.getLastName();
				row = sheet.createRow(rownum++);
				// createCell(sheet, cellnum++, empObj.getEmployeeId(), row);
				createCell(sheet, cellnum++, empObj.getEmployeeCode(), row);
				createCell(sheet, cellnum++, Fullname, row);
				createCell(sheet, cellnum++, 0, row);
				createCell(sheet, cellnum++, 0, row);
				createCell(sheet, cellnum++, 0, row);
				createCell(sheet, cellnum++, 0, row);
				

			}
			workbook.write(out);
			out.flush();
			out.close();
			workbook.close();
			try {
				httpResponse.flushBuffer();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public static void manualAttendance(ActionRequest request, ActionResponse response) throws Exception {
		int manualExcel = ParamUtil.getInteger(request, "manualExcel");
		int indexNumber = 1;
		// System.out.println("manualExcel" + manualExcel);
		if (manualExcel == 1) {
			// System.out.println("AAAAAAYYYYYY");
			String date = ParamUtil.get(request, "date", StringPool.BLANK);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat dateFormster = new SimpleDateFormat("HH:mm");
			Date attDate = df.parse(date);
			java.sql.Time StartTime = null;
			java.sql.Time EndTime = null;
			Date pcDate = new Date();
			// List<String> error = new ArrayList<>();

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			File uploadDocFile = uploadPortletRequest.getFile("uploadDoc");
			InputStream ExcelFileToRead = new FileInputStream(uploadDocFile);
			// File xlsxFile=new
			// File(ClassLoader.getResource("Countries.xlsx").getFile());

			try {
				List<AttendanceCheckList> attList = AttendanceCheckListLocalServiceUtil.getAttendanceCheckLists(-1, -1);
				if (Validator.isNotNull(attList)) {
					for (int i = 0; i < attList.size(); i++) {
						AttendanceCheckListLocalServiceUtil
								.deleteAttendanceCheckList(attList.get(i).getAttendanceCheckListId());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

			XSSFWorkbook test = new XSSFWorkbook();

			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFRow header_row = sheet.getRow(0);
			XSSFCell cell;

			Iterator rows = sheet.rowIterator();

			/*
			 * for (int i = 0; i < 4; i++) { XSSFCell header_cell =
			 * header_row.getCell(i); String header =
			 * header_cell.getStringCellValue();
			 * System.out.println("header : "+header); }
			 */

			while (rows.hasNext()) {
				row = (XSSFRow) rows.next();
				// System.out.println("index ** : " + row.getRowNum());
				if (row.getRowNum() != 0) {
					// System.out.println("aaaaa");
					DataFormatter formatter = new DataFormatter(Locale.US);
					Attendance atten = null;
					/*
					 * System.out.println("index 1 : " + row.getCell(0));
					 * System.out.println("index 2 : " + row.getCell(1));
					 * System.out.println("index 3 : " + row.getCell(2));
					 * System.out.println("index 4 : " + row.getCell(3));
					 * System.out.println("index 4 : " + row.getCell(4));
					 * System.out.println("index 4 : " + row.getCell(5));
					 * System.out.println("index 4 : " + row.getCell(6));
					 */
					// String empId=String.valueOf(row.getCell(0));
					long attendanceId = CounterLocalServiceUtil.increment(Attendance.class.getName());
					Attendance attendance = AttendanceLocalServiceUtil.createAttendance(attendanceId);

					long attendanceCheckListId = CounterLocalServiceUtil.increment(AttendanceCheckList.class.getName());
					AttendanceCheckList attendanceCheckList = AttendanceCheckListLocalServiceUtil
							.createAttendanceCheckList(attendanceCheckListId);
					// double value =row.getCell(0);
					// String value=cell.getStringCellValue();

					Employee emp = null;
					Employee employee = null;
					String employeeCode = null;
					List<String> checkTime = new ArrayList<>();

					if (Validator.isNotNull(String.valueOf(formatter.formatCellValue(row.getCell(0))))) {

						// System.out.println("employeeId" + employeeId);
						employeeCode = formatter.formatCellValue(row.getCell(0));
						employee = EmployeeLocalServiceUtil.findByemployeeCode(Long.parseLong(employeeCode));
						try {

							attendanceCheckList.setEmployeeCode(Long.parseLong(employeeCode));
							attendanceCheckList.setFullName(String.valueOf(formatter.formatCellValue(row.getCell(1))));
							attendanceCheckList
									.setInTimeHour(String.valueOf(formatter.formatCellValue(row.getCell(2))));
							attendanceCheckList.setInTimeMin(String.valueOf(formatter.formatCellValue(row.getCell(3))));
							attendanceCheckList
									.setOutTimeHour(String.valueOf(formatter.formatCellValue(row.getCell(4))));
							attendanceCheckList
									.setOutTimeMin(String.valueOf(formatter.formatCellValue(row.getCell(5))));
							attendanceCheckList.setAttDate(attDate);
							attendanceCheckList.setPcDateAndTime(pcDate);

							String inTimeHr = formatter.formatCellValue(row.getCell(2));
							boolean checkInTimeHr = DigitOrNot.getSpecialCharacterCount(inTimeHr);// check
																									// intime
																									// hour
																									// digit
																									// or
																									// not
							System.out.println("checkInTimeHr" + checkInTimeHr);
							System.out.println("inTimeHourrr     :-----" + inTimeHr);

							// System.out.println("inTimeHour_Integer"
							// +inTimeHrCheck);

							// for in time min
							String inTimeMin = formatter.formatCellValue(row.getCell(3));
							System.out.println("inTimeMin" + inTimeMin);
							boolean checkInTimeMin = DigitOrNot.getSpecialCharacterCount(inTimeMin);// check
																									// intime
																									// min
																									// digit
																									// or
																									// not
							System.out.println("checkInTimeMin" + checkInTimeMin);

							// for out time hour
							String outTimeHr = formatter.formatCellValue(row.getCell(4));
							System.out.println("outTimeHr" + outTimeHr);
							boolean checkOutTimeHr = DigitOrNot.getSpecialCharacterCount(outTimeHr);// check
																									// outtime
																									// hour
																									// digit
																									// or
																									// not
							System.out.println("checkOutTimeHr" + checkOutTimeHr);

							// for in time hour
							String outTimeMin = formatter.formatCellValue(row.getCell(5));
							System.out.println("outTimeMin" + outTimeMin);
							boolean checkOutTimeMin = DigitOrNot.getSpecialCharacterCount(outTimeMin);// check
																										// outtime
							// int inTimeHrCheck = 0; // min
							// digit
							// or
							// not
							System.out.println("checkOutTimeMin" + checkOutTimeMin);

							// boolean checkIntime=false;
							int error = 0;
							String msg = "No Error";

							if (!Validator.isNotNull(employee)) {
								error = 1;
								msg = "Employee Not exist";
							}
							if (checkInTimeHr == true && error != 1) {
								System.out.println("Ifff----------checkInTimeHr----");
								error = 1;
								msg = "Error in Intime hour";
							} else {
								try {
									int inTimeHrCheck = Integer.parseInt(inTimeHr);
									if (inTimeHrCheck > 24 && error != 1) {
										error = 1;
										msg = "Intime hour must be 0 to 24";
									}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							if (checkInTimeMin == true && error != 1) {
								System.out.println("ifffff----------checkInTimeMin---------");
								error = 1;
								msg = "Error in Intime Minute";
							} else {
								try {
									int inTimeMinCheck = Integer.parseInt(inTimeMin);
									if (inTimeMinCheck > 60 && error != 1) {
										error = 1;
										msg = "Intime Minute must be 0 to 60 min";
									}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}

							if (checkOutTimeHr == true && error != 1) {
								System.out.println("iffff---------checkOutTimeHr-0--------");
								error = 1;
								msg = "Error in Outtime Hour";
							} else {
								try {
									int outTimehrCheck = Integer.parseInt(outTimeHr);
									if (outTimehrCheck > 24 && error != 1) {
										error = 1;
										msg = "Outtime hour must be 0 to 24";
									}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							if (checkOutTimeMin == true && error != 1) {
								System.out.println("ifff---------checkOutTimeMin--------");
								error = 1;
								msg = "Error in Outtime Minute";
							} else {
								try {
									int outTimeMinCheck = Integer.parseInt(outTimeMin);
									if (outTimeMinCheck > 60 && error != 1) {
										error = 1;
										msg = "outTime Minute must be 0 to 60 min";
									}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}

							try {
								int inTimeHrCheck = Integer.parseInt(inTimeHr);
								int outTimehrCheck = Integer.parseInt(outTimeHr);

								if (inTimeHrCheck > outTimehrCheck) {
									error = 1;
									msg = "Intime hour always smaller then the Outtime hour";
								}

							} catch (Exception e) {
								// TODO: handle exception
							}

							if (error == 1) {
								attendanceCheckList.setStatus("Error");
								attendanceCheckList.setMsg(msg);
								SessionErrors.add(request, "Error");
								SessionMessages.add(request, PortalUtil.getPortletId(request)
										+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
								HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
								// System.out.println("ELSE>>>"+error);
								// httpRequest.setAttribute("error", error);
								response.setRenderParameter("error", "1");
								response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
							} else {
								attendanceCheckList.setStatus("Success");
								attendanceCheckList.setMsg(msg);
							}
							attendanceCheckList.setIndexNumber(indexNumber);
							indexNumber++;

							System.out.println("eMPLOYEE CODE : " + employeeCode);

							AttendanceCheckListLocalServiceUtil.addAttendanceCheckList(attendanceCheckList);

							if (error != 1) {
								try {
									List<AttendanceCheckList> attObj = AttendanceCheckListLocalServiceUtil
											.getAttendanceCheckLists(-1, -1);
									if (Validator.isNotNull(attObj))
										for (AttendanceCheckList attListObj : attObj) {
											Employee empObj = EmployeeLocalServiceUtil
													.findByemployeeCode(attListObj.getEmployeeCode());
											// SimpleDateFormat date =
											// SimpleDateFormat
											Attendance attendanceObj = AttendanceLocalServiceUtil
													.findByempIdAndAttDate(empObj.getEmployeeId(), attDate);
											Attendance attendanceObj1 = null;
											if (Validator.isNotNull(attendanceObj)) {
												attendanceObj1 = AttendanceLocalServiceUtil
														.getAttendance(attendanceObj.getAttendanceId());
											} else {

												long attendaceId = CounterLocalServiceUtil
														.increment(Attendance.class.getName());
												attendanceObj1 = AttendanceLocalServiceUtil
														.createAttendance(attendaceId);
											}
											attendanceObj1.setCompanyId(empObj.getCompanyId());
											attendanceObj1.setEmployeeCode(attListObj.getEmployeeCode());
											attendanceObj1.setEmployeeId(empObj.getEmployeeId());
											attendanceObj1.setAttDate(attDate);
											attendanceObj1.setInTimeHour(attListObj.getInTimeHour());
											attendanceObj1.setInTimeMin(attListObj.getInTimeMin());
											attendanceObj1.setOutTimeHour(attListObj.getOutTimeHour());
											attendanceObj1.setOutTimeMin(attListObj.getOutTimeMin());
											String inTime = attListObj.getInTimeHour() + ":"
													+ attListObj.getInTimeMin();
											String outTime = attListObj.getOutTimeHour() + ":"
													+ attListObj.getOutTimeMin();
											attendanceObj1.setInTime(inTime);
											attendanceObj1.setOutTime(outTime);

											StartTime = new java.sql.Time(dateFormster.parse(inTime).getTime());
											EndTime = new java.sql.Time(dateFormster.parse(outTime).getTime());
											long diff = EndTime.getTime() - StartTime.getTime();
											long diffMinutes = diff / (60 * 1000) % 60;
											long diffHours = diff / (60 * 60 * 1000) % 24;
											Date datePc = new Date();

											String total = String.valueOf(diffHours) + ":"
													+ String.valueOf(diffMinutes);

											try {
												int inTimeCheck = Integer.parseInt(attListObj.getInTimeHour());
												attendanceObj1.setTotal(total);
												if (inTimeCheck != 0) {
													attendanceObj1.setStatus("Present");
												} else {
													attendanceObj1.setStatus("Absent");
												}
											} catch (Exception e) {
												// TODO: handle exception
											}

											// attendanceObj1.setInDatePc(inDatePc);

											if (Validator.isNotNull(attendanceObj)) {

												AttendanceLocalServiceUtil.updateAttendance(attendanceObj1);
											} else {
												AttendanceLocalServiceUtil.addAttendance(attendanceObj1);
											}
										}
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							// error=0;
							/* Employee emp = EmployeeLocalServiceUtil.fi */
							/*
							 * if(checkInTimeHr==false && checkInTimeMin==false
							 * && checkOutTimeHr==false &&
							 * checkOutTimeMin==false ){ int inTimeHrCheck =
							 * Integer.parseInt(inTimeHr); int
							 * inTimeMinCheck=Integer.parseInt(inTimeMin); int
							 * outTimehrCheck=Integer.parseInt(outTimeHr); int
							 * outTimeMinCheck=Integer.parseInt(outTimeMin);
							 * if((inTimeHrCheck>0 &&
							 * inTimeHrCheck<=24)&&(inTimeMinCheck>=0 &&
							 * inTimeMinCheck<=60) &&(outTimehrCheck>0 &&
							 * outTimehrCheck<=24)&&(outTimeMinCheck>=0 &&
							 * outTimeMinCheck<=60)){ checkIntime=true; }
							 * 
							 * }else{ SessionErrors.add(request,
							 * "inTimeHrError"); SessionMessages.add(request,
							 * PortalUtil.getPortletId(request) +
							 * SessionMessages.
							 * KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
							 * HttpServletRequest httpRequest =
							 * PortalUtil.getHttpServletRequest(request); //
							 * System.out.println("ELSE>>>"+error); //
							 * httpRequest.setAttribute("error", error);
							 * 
							 * response.setRenderParameter("jspPage",
							 * "/META-INF/resources/view.jsp"); }
							 */

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("emp===================>>" + emp);
						}

						// emp =
						// EmployeeLocalServiceUtil.getEmployee(employee.getEmployeeId());

					}
					/*
					 * if (employee != null) { try { atten =
					 * AttendanceLocalServiceUtil.findByempIdAndAttDate(employee
					 * .getEmployeeId(), attDate); //
					 * System.out.println("employeeId" + employeeId); } catch
					 * (Exception e) { // TODO: handle exception } try { if
					 * (atten == null) {
					 * 
					 * System.out.println("AAAA"); //for in time hour String
					 * inTimeHr = formatter.formatCellValue(row.getCell(3));
					 * List<Integer> checkInTimeHr=
					 * DigitOrNot.getSpecialCharacterCount(inTimeHr);//check
					 * intime hour digit or not
					 * System.out.println("checkInTimeHr"+checkInTimeHr);
					 * System.out.println("inTimeHourrr" + inTimeHr);
					 * 
					 * //System.out.println("inTimeHour_Integer"
					 * +inTimeHrCheck);
					 * 
					 * //for in time min String inTimeMin =
					 * formatter.formatCellValue(row.getCell(4));
					 * System.out.println("inTimeMin" + inTimeMin);
					 * List<Integer> checkInTimeMin=
					 * DigitOrNot.getSpecialCharacterCount(inTimeMin);//check
					 * intime min digit or not
					 * 
					 * //System.out.println("inTimeMinCheck"+inTimeHrCheck);
					 * 
					 * //for out time hour String outTimeHr =
					 * formatter.formatCellValue(row.getCell(5));
					 * System.out.println("outTimeHr" + outTimeHr);
					 * List<Integer> checkOutTimeHr=
					 * DigitOrNot.getSpecialCharacterCount(outTimeHr);//check
					 * outtime hour digit or not
					 * 
					 * //System.out.println("outTimehrCheck"+inTimeHrCheck);
					 * 
					 * //for in time hour String outTimeMin =
					 * formatter.formatCellValue(row.getCell(6));
					 * System.out.println("outTimeMin" + outTimeMin);
					 * List<Integer> checkOutTimeMin=
					 * DigitOrNot.getSpecialCharacterCount(outTimeMin);//check
					 * outtime min digit or not
					 * 
					 * //System.out.println("outTimeMinCheck"+inTimeHrCheck);
					 * 
					 * boolean checkIntime=false; if(checkInTimeHr.isEmpty() &&
					 * checkInTimeMin.isEmpty() && checkOutTimeHr.isEmpty() &&
					 * checkOutTimeMin.isEmpty()){ int inTimeHrCheck =
					 * Integer.parseInt(inTimeHr); int
					 * inTimeMinCheck=Integer.parseInt(inTimeMin); int
					 * outTimehrCheck=Integer.parseInt(outTimeHr); int
					 * outTimeMinCheck=Integer.parseInt(outTimeMin);
					 * if((inTimeHrCheck>0 &&
					 * inTimeHrCheck<=24)&&(inTimeMinCheck>=0 &&
					 * inTimeMinCheck<=60) &&(outTimehrCheck>0 &&
					 * outTimehrCheck<=24)&&(outTimeMinCheck>=0 &&
					 * outTimeMinCheck<=60)){ checkIntime=true; }
					 * 
					 * }else{ SessionErrors.add(request, "inTimeHrError");
					 * SessionMessages.add(request,
					 * PortalUtil.getPortletId(request) +
					 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					 * HttpServletRequest httpRequest =
					 * PortalUtil.getHttpServletRequest(request); //
					 * System.out.println("ELSE>>>"+error); //
					 * httpRequest.setAttribute("error", error);
					 * 
					 * response.setRenderParameter("jspPage",
					 * "/META-INF/resources/view.jsp"); }
					 * 
					 * if(checkIntime!=false){ System.out.println("checkTime" +
					 * checkTime.size()); if (!checkTime.isEmpty()) { String
					 * inTime = formatter.formatCellValue(row.getCell(3)) + ":"
					 * + (formatter.formatCellValue(row.getCell(4))); String
					 * outTime = formatter.formatCellValue(row.getCell(5)) + ":"
					 * + (formatter.formatCellValue(row.getCell(6)));
					 * 
					 * StartTime = new
					 * java.sql.Time(dateFormster.parse(inTime).getTime());
					 * EndTime = new
					 * java.sql.Time(dateFormster.parse(outTime).getTime());
					 * long diff = EndTime.getTime() - StartTime.getTime(); long
					 * diffMinutes = diff / (60 * 1000) % 60; long diffHours =
					 * diff / (60 * 60 * 1000) % 24; SimpleDateFormat sd = new
					 * SimpleDateFormat( "yyyy.MM.dd G 'at' HH:mm:ss z");
					 * sd.setTimeZone(TimeZone.getTimeZone("IST")); Date datePc
					 * = new Date();
					 * 
					 * String total = String.valueOf(diffHours) + ":" +
					 * String.valueOf(diffMinutes);
					 * //attendance.setEmployeeId(Long.parseLong(employeeId));
					 * attendance.setEmployeeCode(Long.parseLong(employeeCode));
					 * attendance.setCompanyId(emp.getCompanyId());
					 * attendance.setAttDate(attDate);
					 * attendance.setInTimeHour(String.valueOf(formatter.
					 * formatCellValue(row.getCell(3))));
					 * attendance.setInTimeMin(String.valueOf(formatter.
					 * formatCellValue(row.getCell(4)))); attendance
					 * .setOutTimeHour(String.valueOf(formatter.formatCellValue(
					 * row.getCell(5))));
					 * attendance.setOutTimeMin(String.valueOf(formatter.
					 * formatCellValue(row.getCell(6))));
					 * attendance.setInTime(inTime);
					 * attendance.setOutTime(outTime);
					 * attendance.setInDatePc(datePc);
					 * attendance.setOutDatePc(datePc);
					 * attendance.setStatus("Present");
					 * attendance.setTotal(total);
					 * attendance.setStatus("Present");
					 * AttendanceLocalServiceUtil.addAttendance(attendance); }
					 * 
					 * }else{ SessionErrors.add(request, "inTimeOutTimeError");
					 * SessionMessages.add(request,
					 * PortalUtil.getPortletId(request) +
					 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					 * HttpServletRequest httpRequest =
					 * PortalUtil.getHttpServletRequest(request); //
					 * System.out.println("ELSE>>>"+error); //
					 * httpRequest.setAttribute("error", error);
					 * 
					 * response.setRenderParameter("jspPage",
					 * "/META-INF/resources/view.jsp"); } } else {
					 * SessionErrors.add(request, "error");
					 * SessionMessages.add(request,
					 * PortalUtil.getPortletId(request) +
					 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					 * HttpServletRequest httpRequest =
					 * PortalUtil.getHttpServletRequest(request); //
					 * System.out.println("ELSE>>>"+error); //
					 * httpRequest.setAttribute("error", error);
					 * 
					 * response.setRenderParameter("jspPage",
					 * "/META-INF/resources/view.jsp"); } } catch (Exception e)
					 * { } } else { SessionMessages.add(request, "error2");
					 * SessionMessages.add(request,
					 * PortalUtil.getPortletId(request) +
					 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					 * HttpServletRequest httpRequest =
					 * PortalUtil.getHttpServletRequest(request); //
					 * System.out.println("ELSE>>>"+error); //
					 * httpRequest.setAttribute("error", error);
					 * 
					 * response.setRenderParameter("jspPage",
					 * "/META-INF/resources/view.jsp"); //
					 * super.manualAttendance(request, response); }
					 */
				} else {

				}
			}
		}

		/* for biomatrix */
		if (manualExcel == 2) {
			// System.out.println("BioMetrix");
			String date = ParamUtil.get(request, "date", StringPool.BLANK);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat dateFormster = new SimpleDateFormat("HH:mm");
			Date attDate = df.parse(date);
			/*
			 * java.sql.Time StartTime = null; java.sql.Time EndTime = null;
			 */
			// List<String> error = new ArrayList<>();

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			File uploadDocFile = uploadPortletRequest.getFile("uploadDoc");
			FileReader fileReader = new FileReader(uploadDocFile);
			BufferedReader in = new BufferedReader(fileReader);
			File uploadDocFile1 = uploadPortletRequest.getFile("uploadDoc");
			FileReader fileReader1 = new FileReader(uploadDocFile1);
			BufferedReader in1 = new BufferedReader(fileReader1);
			String line = null;
			// BufferedReader in = new BufferedReader(fileReader);
			String str;
			String str1;

			List<String> list = new ArrayList<String>();
			while ((str = in.readLine()) != null) {
				// list.add(str);
				// System.out.println("stringArrayyyyyyyyy:-"+str.replaceAll(" |
				// ",","));
				// String[] stringArr =str.replaceAll(" | ",",");
				String fullStr = str.replaceAll("	| ", ",");
				String[] words = fullStr.split(",");
				// System.out.println(words[2]);

				/*
				 * System.out.println(words[1]); System.out.println("/n");
				 */
				try {

					Employee emp = EmployeeLocalServiceUtil.findByemployeeCode(Long.parseLong(words[0]));
					if (Validator.isNotNull(emp)) {

						try {

							String dateParse = words[1];
							Date attDateBio = new SimpleDateFormat("yyyy-dd-MM").parse(dateParse);
							List<AttendanceBio> attBio = AttendanceBioLocalServiceUtil
									.findbyempIdAndAttDateComId(emp.getEmployeeId(), emp.getCompanyId(), attDateBio);
							// System.out.println("attBio:-"+attBio.size());
							if (attBio.size() == 0) {
								long attendanceBioId = CounterLocalServiceUtil.increment(AttendanceBio.class.getName());
								AttendanceBio attendanceBio = AttendanceBioLocalServiceUtil
										.createAttendanceBio(attendanceBioId);

								attendanceBio.setEmployeeId(emp.getEmployeeId());
								attendanceBio.setCompanyId(emp.getCompanyId());
								attendanceBio.setAttDate(attDateBio);
								attendanceBio.setAttTime(words[2]);
								attendanceBio.setUploadDate(attDate);
								attendanceBio.setStatus(Integer.parseInt(words[5]));
								AttendanceBioLocalServiceUtil.addAttendanceBio(attendanceBio);
							} else {
								SessionErrors.add(request, "error1");
								SessionMessages.add(request, PortalUtil.getPortletId(request)
										+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
								HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);

								// HttpServletRequest httpRequest =
								// PortalUtil.getHttpServletRequest(actionRequest);
								// System.out.println("ELSE>>>"+error);
								// httpRequest.setAttribute("error", error);

								response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
							}
						} catch (Exception e) {

						}

					} else {
						SessionErrors.add(request, "error2");
						SessionMessages.add(request, PortalUtil.getPortletId(request)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);

						// HttpServletRequest httpRequest =
						// PortalUtil.getHttpServletRequest(actionRequest);
						// System.out.println("ELSE>>>"+error);
						// httpRequest.setAttribute("error", error);

						response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
					}

				} catch (Exception e) {

				}

				// System.out.println(words);

			}
			// System.out.println("AAAAAAA");
			str1 = in1.readLine();
			// System.out.println("str1"+str1);

			while ((str1 = in1.readLine()) != null) {
				// System.out.println("BBBBB");
				String fullStr = str1.replaceAll("	| ", ",");// split for tab
																// and space
				String[] words = fullStr.split(",");
				try {
					List<AttendanceBio> attBioListEntry = new ArrayList<>();
					List<AttendanceBio> attBioListExit = new ArrayList<>();
					List<Attendance> attAdd = new ArrayList<>();
					Employee emp = EmployeeLocalServiceUtil.findByemployeeCode(Long.parseLong(words[0]));
					if (Validator.isNotNull(emp)) {
						// System.out.println("CCCCCC");
						String dateParse = words[1];
						Date attDateBio = new SimpleDateFormat("yyyy-dd-MM").parse(dateParse);
						// System.out.println("DDDDD");
						// for Entry
						DynamicQuery membrQueryEntry = AttendanceBioLocalServiceUtil.dynamicQuery();
						Criterion criterion = null;
						criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
						criterion = RestrictionsFactoryUtil.and(criterion,
								RestrictionsFactoryUtil.eq("companyId", emp.getCompanyId()));
						criterion = RestrictionsFactoryUtil.and(criterion,
								RestrictionsFactoryUtil.eq("attDate", attDateBio));
						criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("status", 104));
						membrQueryEntry.add(criterion);
						membrQueryEntry.addOrder(OrderFactoryUtil.asc("attTime"));
						attBioListEntry = AttendanceBioLocalServiceUtil.dynamicQuery(membrQueryEntry);

						// for Exit
						DynamicQuery membrQueryExit = AttendanceBioLocalServiceUtil.dynamicQuery();
						Criterion criterion2 = null;
						criterion2 = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
						criterion2 = RestrictionsFactoryUtil.and(criterion2,
								RestrictionsFactoryUtil.eq("companyId", emp.getCompanyId()));
						criterion2 = RestrictionsFactoryUtil.and(criterion2,
								RestrictionsFactoryUtil.eq("attDate", attDateBio));
						criterion2 = RestrictionsFactoryUtil.and(criterion2, RestrictionsFactoryUtil.eq("status", 4));
						membrQueryExit.add(criterion2);
						membrQueryExit.addOrder(OrderFactoryUtil.desc("attTime"));
						attBioListExit = AttendanceBioLocalServiceUtil.dynamicQuery(membrQueryExit);
						/*
						 * System.out.println("attBioListEntry:-"+
						 * attBioListEntry);
						 * System.out.println("attBioListEntrySize:-"+
						 * attBioListEntry.size());
						 * System.out.println("1st Item:-"+attBioListEntry.get(0
						 * ));
						 * System.out.println("1st Item:-"+attBioListEntry.get(
						 * attBioListEntry.size()-1));
						 * System.out.println("1st attBioListEntryExit:-"
						 * +attBioListExit.get(0));
						 * System.out.println("1st attBioListExit:-"
						 * +attBioListExit.get(attBioListExit.size()-1));
						 */

						// String dateParse1 =
						// attBioListEntry.get(0).getAttDate();
						/*
						 * Date checkDateBio = new
						 * SimpleDateFormat("yyyy-dd-MM"); Date dateCheck =
						 * checkDateBio.parse(attBioListEntry.get(0).getAttDate(
						 * ))
						 */
						DynamicQuery attAddObj = AttendanceLocalServiceUtil.dynamicQuery();
						// DynamicQuery attAddObj =
						// AttendanceBioLocalServiceUtil.dynamicQuery();
						Criterion criterion3 = null;
						criterion3 = RestrictionsFactoryUtil.eq("employeeId", attBioListEntry.get(0).getEmployeeId());
						// System.out.println("EEEEE");
						criterion3 = RestrictionsFactoryUtil.and(criterion3,
								RestrictionsFactoryUtil.eq("companyId", attBioListEntry.get(0).getCompanyId()));
						// System.out.println("FFFFFF"+attBioListEntry.get(0).getAttDate());
						criterion3 = RestrictionsFactoryUtil.and(criterion3,
								RestrictionsFactoryUtil.eq("attDate", attBioListEntry.get(0).getAttDate()));
						// criterion2 =
						// RestrictionsFactoryUtil.and(criterion,RestrictionsFactoryUtil.eq("status",104));
						attAddObj.add(criterion3);
						// attAddObj.addOrder(OrderFactoryUtil.desc("attTime"));
						attAdd = AttendanceLocalServiceUtil.dynamicQuery(attAddObj);
						// System.out.println("getEmployeeId():-"+attBioListEntry.get(0).getEmployeeId()+"getCompanyId():--"+attBioListEntry.get(0).getCompanyId()+"getAttDate():--"+attBioListEntry.get(0).getAttDate());
						List<Attendance> attendancesCheck = AttendanceLocalServiceUtil.findbyempIdAndAttDateComId(
								attBioListEntry.get(0).getEmployeeId(), attBioListEntry.get(0).getCompanyId(),
								attBioListEntry.get(0).getAttDate());
						// System.out.println("GGGGG"+attendancesCheck.size()+"attAdd:-"+attAdd.size());
						if (attendancesCheck.size() == 0) {
							// System.out.println("HHHHHH");
							long attId = CounterLocalServiceUtil.increment(Attendance.class.getName());
							Attendance attendance = AttendanceLocalServiceUtil.createAttendance(attId);
							DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
							// System.out.println("IIIII");
							/*
							 * java.sql.Time StartTime = null; java.sql.Time
							 * EndTime = null;
							 */
							/*
							 * String inTime =
							 * Formatter.formatCellValue(row.getCell(3)) + ":" +
							 * (formatter.formatCellValue(row.getCell(4)));
							 * String outTime =
							 * formatter.formatCellValue(row.getCell(5)) + ":" +
							 * (formatter.formatCellValue(row.getCell(6)));
							 */
							java.sql.Time StartTime = new java.sql.Time(
									sdf.parse(attBioListEntry.get(0).getAttTime()).getTime());
							java.sql.Time EndTime = new java.sql.Time(
									sdf.parse(attBioListExit.get(0).getAttTime()).getTime());
							// System.out.println("JJJJ");
							// EndTime = new
							// java.sql.Time(dateFormster.parse(outTime).getTime());
							long diff = EndTime.getTime() - StartTime.getTime();
							long diffMinutes = diff / (60 * 1000) % 60;
							long diffHours = diff / (60 * 60 * 1000) % 24;
							// System.out.println("KKKKK");
							String total = String.valueOf(diffHours) + ":" + String.valueOf(diffMinutes);
							Employee empObj = null;
							if (Validator.isNotNull(attBioListEntry.get(0).getEmployeeId())) {
								empObj = EmployeeLocalServiceUtil.getEmployee(attBioListEntry.get(0).getEmployeeId());
								// System.out.println("LLLLL");
							}
							attendance.setCompanyId(attBioListEntry.get(0).getCompanyId());
							attendance.setEmployeeCode(empObj.getEmployeeCode());
							attendance.setEmployeeId(attBioListEntry.get(0).getEmployeeId());
							// System.out.println("MMMMMMM");
							attendance.setAttDate(attBioListEntry.get(0).getAttDate());
							attendance.setInTime(attBioListEntry.get(0).getAttTime());
							attendance.setOutTime(attBioListExit.get(0).getAttTime());
							attendance.setInDatePc(new Date());
							attendance.setOutDatePc(new Date());
							attendance.setTotal(total);
							attendance.setStatus("Present");
							AttendanceLocalServiceUtil.addAttendance(attendance);
						} /*
							 * else{ SessionErrors.add(request, "error1");
							 * HttpServletRequest httpRequest =
							 * PortalUtil.getHttpServletRequest(request); //
							 * System.out.println("ELSE>>>"+error); //
							 * httpRequest.setAttribute("error", error);
							 * 
							 * response.setRenderParameter("jspPage",
							 * "/META-INF/resources/view.jsp"); }
							 */

					}
				} catch (Exception e) {

				}
			}

		}
	}
}