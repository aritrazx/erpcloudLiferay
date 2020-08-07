package com.liferay.famocom.erpcloud.form.portlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.famocom.erpcloud.form.constants.Form16PortletKeys;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.FormSixteen;
import com.liferay.famocom.erpcloud.model.FormSixteenErrorFile;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.FormSixteenLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author aritrazx
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Form16 Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Form16PortletKeys.Form16, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class Form16Portlet extends MVCPortlet {
	public static String FOLDER_NAME = "form16_File_upload";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<FormSixteen> formSixteens = new ArrayList<>();
		formSixteens = FormSixteenLocalServiceUtil.getFormSixteens(-1, -1);
		renderRequest.setAttribute("formSixteens", formSixteens);
		super.render(renderRequest, renderResponse);
	}

	/**
	 * Add Form16 - from form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws WindowStateException
	 */
	@ProcessAction(name = "addFormSixteen")
	public void addFormSixteen(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, WindowStateException {
		System.out.println("Call Adddddd");
		String financialYear = ParamUtil.getString(actionRequest, "financialYear", StringPool.BLANK);
		System.out.println(":::::::financialyear:::::" + financialYear);
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		System.out.println("Java employeeId " + employeeId);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// long userId = themeDisplay.getUserId();
		if (Validator.isNotNull(employeeId)) {
			// Employee employee =
			// EmployeeLocalServiceUtil.getEmployee(employeeId);
			System.out.println("Validator.isNotNull(employeeId)");
			try {
				List<FormSixteen> formSixteens = new ArrayList<>();
				DynamicQuery dynamicQuery = FormSixteenLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("financialYear", financialYear));
				dynamicQuery.add(criterion3);
				formSixteens = FormSixteenLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("formSixteens SiZE :::" + formSixteens.size());

				if (formSixteens.size() == 0) {

					long id = CounterLocalServiceUtil.increment(FormSixteen.class.getName());
					FormSixteen formSixteen = FormSixteenLocalServiceUtil.createFormSixteen(id);
					System.out.println(":::::id:::::::" + id);
					formSixteen.setFinancialYear(financialYear);
					formSixteen.setEmployeeId(employeeId);
					UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
					Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
					Folder folder = null;
					InputStream is;
					// File file;
					String title, description, mimeType;
					long repositoryId;
					FileEntry dlfile;
					File file = uploadPortletRequest.getFile("uploadedFiles");
					System.out.println("file" + file);
					long fileSize = 0;
					for (Entry<String, FileItem[]> file2 : files.entrySet()) {
						FileItem item[] = file2.getValue();
						try {
							for (FileItem fileItem : item) {
								System.out.println(":::::fileItem::::::" + fileItem);

								String[] panCardNo = fileItem.getFileName().split("\\.", 0);
								System.out.println(":::Split value:::" + panCardNo[0]);
								mimeType = fileItem.getContentType();
								System.out.println(":::minetype::::" + mimeType);
								title = panCardNo[0] + "_" + financialYear + ".pdf";
								description = title + " is added via programatically";
								repositoryId = themeDisplay.getScopeGroupId();
								file = fileItem.getStoreLocation();
								is = fileItem.getInputStream();
								fileSize = fileItem.getSize();
								if (fileSize > 0) {
									System.out.println(":::::::::::: call dlfile ::::::::::::::::::::");
									try {
										folder = getFolder(actionRequest, themeDisplay);
										ServiceContext serviceContext = ServiceContextFactory
												.getInstance(DLFileEntry.class.getName(), actionRequest);
										dlfile = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(),
												title, mimeType, title, description, "", is, fileSize, serviceContext);
										if (dlfile != null) {
											formSixteen.setFileEnteryId(dlfile.getFileEntryId());
										}
										formSixteen.setAddedDate(new Date());
										FormSixteenLocalServiceUtil.addFormSixteen(formSixteen);
										System.out.println("Files are inserted .....");
									} catch (PortalException e) {
										e.printStackTrace();
									} catch (SystemException e) {
										e.printStackTrace();
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					System.out.println("Your have already uploaded your form for this Financial Year!");
					SessionErrors.add(actionRequest, "error");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					actionResponse.setWindowState(WindowState.NORMAL);
					actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addForm16.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("Please Choose a Employee !");
			SessionErrors.add(actionRequest, "error1");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addForm16.jsp");
		}
	}

	/**
	 * Add Bulk Upload - from form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws WindowStateException
	 */
	@ProcessAction(name = "addZipFile")
	public void addZipFile(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, WindowStateException {
		System.out.println("Call Adddddd");
		List<String> totalNoOfFileInput = new ArrayList<String>();
		List<String> totalNoOfFileFail = new ArrayList<>();
		List<FormSixteenErrorFile> errorFiles = FormSixteenErrorFileLocalServiceUtil.getFormSixteenErrorFiles(-1, -1);
		if (errorFiles.size() > 0 && !errorFiles.isEmpty()) {
			for (FormSixteenErrorFile errorFile : errorFiles) {
				FormSixteenErrorFile errorFile2 = FormSixteenErrorFileLocalServiceUtil
						.getFormSixteenErrorFile(errorFile.getErrorId());
				FormSixteenErrorFileLocalServiceUtil.deleteFormSixteenErrorFile(errorFile2);
			}
		}
		String matchingPDFFileName = ParamUtil.getString(actionRequest, "matchingPDFFileName", StringPool.BLANK);
		System.out.println("matchingPDFFileName.. " + matchingPDFFileName.trim());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String financialYear = ParamUtil.getString(actionRequest, "financialYear", StringPool.BLANK);
		FileInputStream fis = null;
		ZipInputStream zipIs = null;
		Folder folder = null;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("uploadedFiles");
		String filePath = file.getAbsolutePath();
		ZipFile zf = null;
		try {
			zf = new ZipFile(file);
		} catch (ZipException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("::::filePath::::::" + filePath);
		ZipEntry zEntry = null;
		FileEntry dlfile;
		try {

			fis = new FileInputStream(filePath);
			zipIs = new ZipInputStream(new BufferedInputStream(fis));

			while ((zEntry = zipIs.getNextEntry()) != null) {
				try {
					byte[] tmp = new byte[4 * 1024];
					FileOutputStream fos = null;
					String opFilePath = zEntry.getName();
					totalNoOfFileInput.add(opFilePath);
					folder = getFolder(actionRequest, themeDisplay);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
							actionRequest);
					InputStream is = zf.getInputStream(zEntry);
					System.out.println("Input Stream " + is);
					long id = CounterLocalServiceUtil.increment(FormSixteen.class.getName());
					String[] panCardNo = zEntry.getName().split("\\.", 0);
					System.out.println(":::Split value:::" + panCardNo[0]);
					String panNo = panCardNo[0];
					String mimeType = "." + panCardNo[1];
					String title = panCardNo[0] + "_" + financialYear + mimeType;
					System.out.println("mimeType" + mimeType);
					String description = title + " is added via programatically";
					List<Employee> employees = new ArrayList<Employee>();

					// From pdf to find EmployeeId
					DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
					Criterion criterion3 = null;
					criterion3 = RestrictionsFactoryUtil.eq(matchingPDFFileName, panNo.trim());
					dynamicQuery.add(criterion3);
					employees = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
					System.out.println("employees :::" + employees);

					if (employees.size() != 0) {
						FormSixteen formSixteen = FormSixteenLocalServiceUtil.createFormSixteen(id);
						for (Employee emp : employees) {
							List<FormSixteen> formSixteens = new ArrayList<>();
							// Dublicate Entry Check
							DynamicQuery query = FormSixteenLocalServiceUtil.dynamicQuery();
							Criterion criterion = null;
							criterion = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
							criterion = RestrictionsFactoryUtil.and(criterion,
									RestrictionsFactoryUtil.eq("financialYear", financialYear));
							query.add(criterion);
							formSixteens = FormSixteenLocalServiceUtil.dynamicQuery(query);
							System.out.println(":::::::::formSixteens:::::::" + formSixteens);
							if (formSixteens.size() == 0 && formSixteens.isEmpty()) {
								dlfile = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
										themeDisplay.getScopeGroupId(), folder.getFolderId(), title, mimeType, title,
										description, "changeLog", is, zEntry.getSize(), serviceContext);

								System.out.println(":::::id:::::::" + id);
								if (dlfile != null) {
									formSixteen.setFileEnteryId(dlfile.getFileEntryId());
								}
								formSixteen.setFinancialYear(financialYear);
								formSixteen.setEmployeeId(emp.getEmployeeId());
								formSixteen.setAddedDate(new Date());
								FormSixteenLocalServiceUtil.addFormSixteen(formSixteen);
							} else {
								long errorId = CounterLocalServiceUtil.increment(FormSixteenErrorFile.class.getName());
								FormSixteenErrorFile formSixteenErrorFile = FormSixteenErrorFileLocalServiceUtil
										.createFormSixteenErrorFile(errorId);
								String msg = zEntry.getName()
										+ " is Already Uploaded this Form for this FInancial Year!";
								formSixteenErrorFile.setErrorMsg(msg);
								formSixteenErrorFile.setFileName(zEntry.getName());
								FormSixteenErrorFileLocalServiceUtil.addFormSixteenErrorFile(formSixteenErrorFile);
							}
						}
					} else {
						long errorId = CounterLocalServiceUtil.increment(FormSixteenErrorFile.class.getName());
						FormSixteenErrorFile formSixteenErrorFile = FormSixteenErrorFileLocalServiceUtil
								.createFormSixteenErrorFile(errorId);
						formSixteenErrorFile.setFileName(zEntry.getName());
						String msg = zEntry.getName() + " is not Uploaded Because these files name are not Identified!";
						formSixteenErrorFile.setErrorMsg(msg);
						FormSixteenErrorFileLocalServiceUtil.addFormSixteenErrorFile(formSixteenErrorFile);
					}
					fos = new FileOutputStream(opFilePath);
					int size = 0;
					while ((size = zipIs.read(tmp)) != -1) {
						fos.write(tmp, 0, size);
					}
					fos.flush();
					fos.close();

				} catch (Exception ex) {

				}
			}
			System.out.println("Total No of File Input: " + totalNoOfFileInput);
			System.out.println("No of Entry ::" + totalNoOfFileFail);
			zipIs.close();

			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			httpRequest.setAttribute("fileNotUpload", totalNoOfFileFail.toString());
			// actionResponse.setWindowState(LiferayWindowState.EXCLUSIVE);
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setRenderParameter("jspPage", "/bulkUpload.jsp");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		if (cmd.equals("exportXLSToCheck")) {
			try {
				exportXLSToCheck(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void exportXLSToCheck(ResourceRequest request, ResourceResponse response) {
		String listType = "From16-File-List-Check.xlsx";
		int rownum = 0;
		int cellnum = 0;
		try {
			List<FormSixteenErrorFile> errorFiles = FormSixteenErrorFileLocalServiceUtil.getFormSixteenErrorFiles(-1,-1);

			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
			httpResponse.setContentType("application/vnd.ms-excel");
			httpResponse.setHeader("Content-Disposition", "attachment; filename=" + listType);
			ServletOutputStream out = httpResponse.getOutputStream();

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("sheet2");
			XSSFFont font = workbook.createFont();

			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			style.setFont(font);

			XSSFCellStyle styleForCost = workbook.createCellStyle();
			Row row = sheet.createRow(rownum++);
			createCell(sheet, cellnum++, " PDF Name", 22 * 500, row, style);
			createCell(sheet, cellnum++, "Status", 10 * 500, row, style);
			if (Validator.isNotNull(errorFiles)) {

				for (FormSixteenErrorFile errorFile : errorFiles) {
					cellnum = 0;
					row = sheet.createRow(rownum++);

					createCell(sheet, cellnum++, errorFile.getFileName(), row);
					createCell(sheet, cellnum++, errorFile.getErrorMsg(), row);
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

	/**
	 * Create the folder
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return Folder
	 */
	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId,
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, FOLDER_NAME,
					"This folder is create for Form16 documents upload", serviceContext);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		return folder;
	}

	/**
	 * Get the folder, create & return if not exists
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return Folder
	 */
	public Folder getFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, FOLDER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Create folder if not exists
		if (folder == null) {
			folder = createFolder(actionRequest, themeDisplay);
		}
		return folder;
	}

	/**
	 * Delete record - From form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "deleteAddForm")
	public void deleteAddForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest, "id");
		System.out.println("id FOr Dlete" + id);
		if (Validator.isNotNull(id)) {
			try {
				FormSixteen formSixteen = FormSixteenLocalServiceUtil.getFormSixteen(id);
				System.out.println(":::formSixteen:::" + formSixteen);
				if (formSixteen != null) {
					FormSixteenLocalServiceUtil.deleteFormSixteen(formSixteen);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	/**
	 * Search for Employee View on the financial Year
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	@ProcessAction(name = "employeeForm16List")
	public void employeeForm16List(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Call employeeForm16List");
		String employeeId = ParamUtil.getString(actionRequest, "employeeId", StringPool.BLANK);
		System.out.println("selectEmployee java classsss" + employeeId);
		String financialyear = ParamUtil.getString(actionRequest, "financialYear", StringPool.BLANK);
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		actionResponse.setRenderParameter("employeeId", String.valueOf(employeeId));
		actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");

	}

	/**
	 * Mail Send which employees are uploaded
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws AddressException 
	 * @throws WindowStateException 
	 */
	@ProcessAction(name = "emailSend")
	public void emailSend(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, AddressException, WindowStateException {
		System.out.println("Call  emailSend");
		String employeeTypeName = StringPool.BLANK;
			String financialYear = ParamUtil.getString(actionRequest, "financialYear", StringPool.BLANK);
			List<FormSixteen> empFormSixteens = new ArrayList<>();
			DynamicQuery dynamicQuery = FormSixteenLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("financialYear", financialYear);
			dynamicQuery.add(criterion3);
			empFormSixteens = FormSixteenLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("empleaveList financialYear" + empFormSixteens);
			for (FormSixteen formSixteen : empFormSixteens) {
				Employee employee = EmployeeLocalServiceUtil.getEmployee(formSixteen.getEmployeeId());
				System.out.println("formSixteen.getEmployeeId()"+formSixteen.getEmployeeId());
				System.out.println("employee.getEmaiAddress()    "+ employee.getEmaiAddress());
				
					String fromAddress = "";
					String fromName = "";
					String toAddress = "";
					String emailFor = "formSixteenUpload";
					String body = "";
					String info = "";
					long infoId = 0;
					String messageBody = "";
					toAddress = employee.getEmaiAddress();
					String empFullName = employee.getFirstName() + " " + employee.getLastName();
					String authId = PrefsPropsUtil.getString(employee.getCompanyId(), "mail.session.mail.smtp.user");
					String authPass = PrefsPropsUtil.getString(employee.getCompanyId(),
							"mail.session.mail.smtp.password");
					fromName = PrefsPropsUtil.getString(employee.getCompanyId(), "admin.email.from.name");
					fromAddress = PrefsPropsUtil.getString(employee.getCompanyId(), "admin.email.from.address");
					System.out.println("fromName :" + fromName + " fromAddress :" + fromAddress);
					System.out.println(" toAddress :" + toAddress);

					EmailTemplate eTemplate = EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
					body = eTemplate.getTemplateBody();
					messageBody = body.replace("$NAME", empFullName);

					InternetAddress[] to = { new InternetAddress(toAddress) };
					InternetAddress from = new InternetAddress(fromAddress);

					MailMessage mailMessage = new MailMessage();
					mailMessage.setTo(to);
					mailMessage.setFrom(from);
					mailMessage.setSubject("Famocom Portal Form16 download");
					mailMessage.setBody(messageBody);
					mailMessage.setHTMLFormat(true);
					MailServiceUtil.sendEmail(mailMessage);
					System.out.println("Mail Has been sent Successfully !!!");
				
			}
	}
}