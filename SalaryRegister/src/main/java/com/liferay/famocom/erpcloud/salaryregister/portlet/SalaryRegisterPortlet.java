package com.liferay.famocom.erpcloud.salaryregister.portlet;



import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
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

import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.TaxDeclarationMonthly;
import com.liferay.famocom.erpcloud.salaryregister.constants.SalaryRegisterPortletKeys;
import com.liferay.famocom.erpcloud.salaryregister.dao.SalaryRegisterDAO;
import com.liferay.famocom.erpcloud.salaryregister.dto.SalaryRegisterDTO;
import com.liferay.famocom.erpcloud.salaryregister.util.HtmlToPdf;
import com.liferay.famocom.erpcloud.salaryregister.util.SalaryRegisterUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author FAMOCOM-AJEET
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SalaryRegister Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SalaryRegisterPortletKeys.SalaryRegister,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SalaryRegisterPortlet extends MVCPortlet {
     private DecimalFormat df2 = new DecimalFormat("0.00");
	@ProcessAction(name="viewSalaryRegister")
	public void viewSalaryRegister(ActionRequest request,ActionResponse response) throws IOException{
		
		String month = ParamUtil.getString(request, "month", StringPool.BLANK);
		String year = ParamUtil.getString(request, "year", StringPool.BLANK);
		String monthYear = month+year;
		List<SalDetails>  detailsList = new ArrayList<>();
		detailsList = SalDetailsLocalServiceUtil.findSalDetailsByMonthYear(Long.valueOf(monthYear));		
		response.sendRedirect("jspPage", "/view.jsp");
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);		
		if (cmd.equals("generatePdfPaySlip")) {
			long employeeId = ParamUtil.getLong(resourceRequest, "employeeId");
			int monthYear = ParamUtil.getInteger(resourceRequest, "monthYear");
			String month = ParamUtil.getString(resourceRequest, "month");
			String year = ParamUtil.getString(resourceRequest, "year");
			Map<String, String> paySlipFormValue = new HashMap<String, String>();
			String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
			Employee employee = null;
			ThemeDisplay themeDisplay  = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			String filename = StringPool.BLANK;
			try {
				
				paySlipFormValue = SalaryRegisterUtil.getMappingValueOfPaySlipForPDF(PortalUtil.getPathContext(), themeDisplay,employeeId, monthYear,month);
			} catch (PortalException e) {
				e.printStackTrace();
			}		
			String panNo = StringPool.BLANK;
			if(Validator.isNotNull(employee)){
				
				filename = employee.getFirstName()+" "+employee.getLastName()+"-"+months[Integer.valueOf(month)-1]+" "+year;
				panNo = employee.getPanNo();
			}
			String filePath = "/"+filename+".pdf";
			String fileName  = filename+".pdf";
			HtmlToPdf  htmlToPdf = new HtmlToPdf();
			htmlToPdf.createPDFfromHTML(paySlipFormValue, "pdf-salary.html", filePath,resourceResponse,panNo,fileName);
			
			
		}
		if(cmd.equals("exportToExcel")) {
			String yearStr = ParamUtil.getString(resourceRequest, "yearStr");
			String month = ParamUtil.getString(resourceRequest, "month");
			exportToXls(resourceRequest,resourceResponse,yearStr,month);
			
		}
		if(cmd.equals("exportToBankExcel")) {
			String yearStr = ParamUtil.getString(resourceRequest, "yearStr");
			String month = ParamUtil.getString(resourceRequest, "month");
			exportToBankXls(resourceRequest,resourceResponse,yearStr,month);
			
		}
		
		if (cmd.equals("exportPdfTDS")) {
			long employeeId = ParamUtil.getLong(resourceRequest, "employeeId");
			String monthYear = ParamUtil.getString(resourceRequest, "monthYear");
			String month = ParamUtil.getString(resourceRequest, "month");
			String year = ParamUtil.getString(resourceRequest, "year");
			Employee employee = null;
			String fileName = StringPool.BLANK;
			String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
			ThemeDisplay themeDisplay  = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			String panNo = StringPool.BLANK;
			if(Validator.isNotNull(employee)){				
				panNo = employee.getPanNo();					
				fileName  = employee.getFirstName()+" "+employee.getLastName()+"-"+months[Integer.valueOf(month)-1]+" "+year;
				
			}
			Map<String, String> tdsFormValue = new HashMap<String, String>();
			try {
				tdsFormValue = SalaryRegisterUtil.getMappingValueOfTaxDeclarationForPDF(employeeId,themeDisplay, monthYear,month,year);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			String filePath = "/TDS.pdf";
			 fileName  = fileName+".pdf";
			HtmlToPdf  htmlToPdf = new HtmlToPdf();			
			htmlToPdf.createPDFfromHTML(tdsFormValue, "TDS.html", filePath,resourceResponse,panNo,fileName);
		}
		
	}
	
	
	
	private void exportToBankXls(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String yearStr,
			String month) {
		  int rownum = 0;
		  int cellnum = 0;
		  DecimalFormat  df2 = new DecimalFormat("0.00");
		  double totalEarning = 0.00;
		  double totalDeducation = 0.00;
		  String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		  String monthYear = month.concat(yearStr);
		  String monthName = months[Integer.valueOf(month)-1]+" "+yearStr;
		  String listType = "Salary_Register_Bank_"+monthName+".xlsx";
		  
	
		try{
			   HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
			   httpResponse.setContentType("application/vnd.ms-excel");
			   httpResponse.setHeader("Content-Disposition",
			     "attachment; filename=" + listType);
			   ServletOutputStream out = httpResponse.getOutputStream();

			   XSSFWorkbook workbook = new XSSFWorkbook();
			   XSSFSheet sheet = workbook.createSheet("sheet1");
			   XSSFFont font = workbook.createFont();
			   font.setBold(true);
			   //font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			   XSSFCellStyle style = workbook.createCellStyle();
			   style.setFillForegroundColor(IndexedColors.RED.getIndex());
			   style.setFont(font);
			   
			   XSSFCellStyle styleForCost = workbook.createCellStyle();
			   //styleForCost.setAlignment(CellStyle.ALIGN_RIGHT);
			   Date date = new Date();
			   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			   Row row = sheet.createRow(rownum++);
			   createCell(sheet, cellnum++, "Date:" , 11 * 500, row,style);
			   createCell(sheet, cellnum++, dateFormat.format(date) , 22 * 500, row,style);
			   
			   cellnum = 0;
			   rownum++;
			   row = sheet.createRow(rownum++);
			   createCell(sheet, cellnum++, "Employee Code" , 11 * 500, row,style);
			   createCell(sheet, cellnum++, "Name" , 20 * 500, row,style);
			   createCell(sheet, cellnum++, "Month" , 11 * 500, row,style);
			   createCell(sheet, cellnum++, "Bank Name" , 18 * 500, row,style);
			   createCell(sheet, cellnum++, "Account No." , 15 * 500, row,style);
			   createCell(sheet, cellnum++, "Net Pay" , 18 * 500, row,style);
			  			  
			   List<SalaryRegisterDTO> dtos = SalaryRegisterDAO.getSalaryRegister(month,yearStr);
			   for (SalaryRegisterDTO salRegister : dtos) {
				    cellnum = 0;
				    row = sheet.createRow(rownum++);
					totalEarning = 0.00;
					totalDeducation = 0.00;
					createCell(sheet, cellnum++,String.valueOf(salRegister.getEmployeeCode()) ,
							  row);
					createCell(sheet, cellnum++,String.valueOf(salRegister.getEmployeeName()) ,
							  row);
					createCell(sheet, cellnum++,String.valueOf(monthName) ,
							  row);
					createCell(sheet, cellnum++,String.valueOf(salRegister.getBankName()) ,
							  row);
					createCell(sheet, cellnum++,String.valueOf(salRegister.getAccountNumber()) ,
							  row);
					totalEarning = SalaryRegisterDAO.getTotalEarningByMonthYearAndEmployeeId(monthYear, salRegister.getEmployeeId());
					totalDeducation = SalaryRegisterDAO.getTotalDeductionByMonthYearAndEmployeeId(monthYear, salRegister.getEmployeeId());
					TaxDeclarationMonthly declarationMonthly = null;
					double monthlyTax = 0.0 ;
					try{
						declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(salRegister.getEmployeeId(), Long.valueOf(monthYear));
						if(Validator.isNotNull(declarationMonthly)){
							String taxStr = df2.format(declarationMonthly.getTdsDuePerMonth());
							monthlyTax = Double.valueOf(taxStr);
						}
					}catch(Exception e){
						
					}
					String netPayStr = df2.format(totalEarning-totalDeducation-monthlyTax);
					createCell(sheet, cellnum++,netPayStr,
							  row);
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
			  }catch (Exception e) {
			   e.printStackTrace();
			  }
			  
		}
	public void exportToXls(ResourceRequest request, ResourceResponse response ,String yearStr,String month) {
		 
		  //DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		  int rownum = 0;
		  int cellnum = 0;
		  DecimalFormat  df2 = new DecimalFormat("0.00");
		  double totalEarning = 0.00;
		  double totalDedction = 0.00;
		  double netPay = 0.00;
		  boolean isSalaryProcessed = false;
		  String monthYear = month.concat(yearStr);
		  List<String> earningList = new ArrayList<String>();
		  earningList.add(SalaryRegisterPortletKeys.Earning);
		  earningList.add(SalaryRegisterPortletKeys.Overtime);
		  earningList.add(SalaryRegisterPortletKeys.Reimbursement);
		  earningList.add(SalaryRegisterPortletKeys.StatutoryComponent);
		  List<Employee> employee = EmployeeLocalServiceUtil.getEmployees(-1,-1);
		  String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
		  String monthName = months[Integer.valueOf(month)-1]+" "+yearStr;
		  String listType = "Salary_Register_"+monthName+".xlsx";
		  //Map<Long,String> empCodeName = new HashMap<>();
		  try{
		   HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		   httpResponse.setContentType("application/vnd.ms-excel");
		   httpResponse.setHeader("Content-Disposition",
		     "attachment; filename=" + listType);
		   ServletOutputStream out = httpResponse.getOutputStream();

		   XSSFWorkbook workbook = new XSSFWorkbook();
		   XSSFSheet sheet = workbook.createSheet("sheet1");
		   XSSFFont font = workbook.createFont();

		   //font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		   XSSFCellStyle style = workbook.createCellStyle();
		   style.setFillForegroundColor(IndexedColors.RED.getIndex());
		   style.setFont(font);

		   XSSFCellStyle styleForCost = workbook.createCellStyle();
		   //styleForCost.setAlignment(CellStyle.ALIGN_RIGHT);
		   Row row = sheet.createRow(rownum++);
		   createCell(sheet, cellnum++, "Employee Code" , 11 * 500, row,style);
		   createCell(sheet, cellnum++, "Name" , 20 * 500, row,style);
		   createCell(sheet, cellnum++, "Month" , 11 * 500, row,style);
		   
		   List<PayComponent> payComponents = new ArrayList<PayComponent>();
		   payComponents = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		   for (PayComponent payComponent : payComponents) {
			   if (earningList.contains(payComponent.getPayType())) {
				   createCell(sheet, cellnum++, payComponent.getName() , 22 * 500, row,style);
			   }
		   }
		   createCell(sheet, cellnum++, "Gross Earning" , 22 * 500, row,style);
		   for (PayComponent payComponent : payComponents) {
			   if(payComponent.getPayType().equalsIgnoreCase(SalaryRegisterPortletKeys.Deduction)) {
				   createCell(sheet, cellnum++, payComponent.getName() , 22 * 500, row,style);
			   }
		   }
		   createCell(sheet, cellnum++, "Gross Deducation" , 22 * 500, row,style);
		   createCell(sheet, cellnum++, "Tax" , 22 * 500, row,style);
		   createCell(sheet, cellnum++, "Net Pay" , 22 * 500, row,style);
		   DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PayComponent.class);
		   dynamicQuery.addOrder(OrderFactoryUtil.asc("payComponentOrder"));
		   List<PayComponent> componentList = PayComponentLocalServiceUtil.dynamicQuery(dynamicQuery);
		   List<SalaryRegisterDTO> dtos = SalaryRegisterDAO.getSalaryRegister(month,yearStr);
			//List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		   for (SalaryRegisterDTO salRegister : dtos) {			  
			if(componentList.size()>0){
				cellnum = 0;
			    row = sheet.createRow(rownum++);
				 createCell(sheet, cellnum++,salRegister.getEmployeeCode() ,
						  row);
			   createCell(sheet, cellnum++,salRegister.getEmployeeName() ,
						  row);
			   createCell(sheet, cellnum++,monthName ,
						  row);
				totalEarning = 0.00;
				
				for(PayComponent component:componentList){
			 		if (earningList.contains(component.getPayType())) {
					  	boolean isComponent = false;
					  	HashMap<Long,String> hashmap = SalaryRegisterDAO.getEmployeeEarningComponentbyMonthYearAndEmployeeId(monthYear, salRegister.getEmployeeId());
					  	if(hashmap.size()>0){
					  		isSalaryProcessed = true;
					 		for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
						    	if(component.getComponentId()==entry.getKey()){
							 		isComponent = true;
							  		PayComponent componentt;
									try {
										componentt = PayComponentLocalServiceUtil.getPayComponent(entry.getKey());					 
										totalEarning += Double.valueOf(entry.getValue());
										String amount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
										System.out.println(" amount  "+amount);
										System.out.println(" entry.getValue()  "+entry.getValue());
										//tring amount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
										  createCell(sheet, cellnum++,amount ,
												  row);
								
									} catch (PortalException e) {
										e.printStackTrace();
									}				
						 	 	}
					 	  	}
				 	 	}	 
					 		if(isComponent==false){
					 			  createCell(sheet, cellnum++,"0.00" ,
										  row);
					 		}
			 		}
					 
			 	}
				String totalEarningStr = df2.format(totalEarning);
				 createCell(sheet, cellnum++,totalEarningStr ,
						  row);
				totalDedction = 0.00;
				 for(PayComponent component:componentList){
					 if(component.getPayType().equalsIgnoreCase(SalaryRegisterPortletKeys.Deduction)) {
					 	boolean isComponent = false;
					  	HashMap<Long,String> hashmap = SalaryRegisterDAO.getEmployeeDeductionComponent(monthYear, salRegister.getEmployeeId());
					  	if(hashmap.size()>0){
					  		isSalaryProcessed = true;
						  	for(Map.Entry<Long,String> entry:hashmap.entrySet()){		 
								if(component.getComponentId()==entry.getKey()){
								  	isComponent = true;
								  	PayComponent componentt;
									try {
										componentt = PayComponentLocalServiceUtil.getPayComponent(entry.getKey());
										String amount = entry.getValue()==null?"0.00": df2.format(Double.valueOf(entry.getValue()));
										totalDedction += Double.valueOf(entry.getValue());
										//cellnum = 0;
										 //row = sheet.createRow(rownum);
										  createCell(sheet, cellnum++,amount ,
												  row);
									} catch (PortalException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}				
						  		}
					  		}
					  	}
						  	if(isComponent==false){
					 			  createCell(sheet, cellnum++,"0.00" ,
										  row);
					 		}
					  	}
					 }
			  		 String totalDedctionStr = df2.format(totalDedction);
			  		 createCell(sheet, cellnum++,totalDedctionStr ,
							  row);
				}
			  	TaxDeclarationMonthly declarationMonthly = null;
				double monthlyTax = 0.0 ;
				try{
					declarationMonthly = TaxDeclarationMonthlyLocalServiceUtil.findTaxDeclarationMonthlyByMonthYearAndEmployeeId(salRegister.getEmployeeId(), Long.valueOf(monthYear));
					if(Validator.isNotNull(declarationMonthly)){
						String taxStr = df2.format(declarationMonthly.getTdsDuePerMonth());
						monthlyTax = Double.valueOf(taxStr);
					}
				}catch(Exception e){
					
				}
				
				String netPayStr = df2.format(totalEarning-totalDedction-monthlyTax);
				createCell(sheet, cellnum++,String.valueOf(monthlyTax) ,
						  row);
				createCell(sheet, cellnum++,netPayStr,
						  row);
				
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
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  
		 }
	public static Cell createCell(XSSFSheet sheet, int cellnum,
			   String cellName, int columnWidth, Row row, XSSFCellStyle style) {
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

			 public static Cell createCell(XSSFSheet sheet, int cellnum,
			   String cellName, Row row) {
			  Cell cell = row.createCell(cellnum++);
			  cell.setCellValue(cellName);
			  return cell;
			 }

			 public static Cell createCell(XSSFSheet sheet, int cellnum, long cellName,
			   Row row) {
			  Cell cell = row.createCell(cellnum++);
			  cell.setCellValue(cellName);
			  return cell;
			 }

			 public static Cell createCell(XSSFSheet sheet, int cellnum, Date cellName,
			   Row row) {
			  Cell cell = row.createCell(cellnum++);
			  cell.setCellValue(cellName);
			  return cell;
			 }
			 
			 
		
}