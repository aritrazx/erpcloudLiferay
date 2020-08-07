package com.liferay.famocom.erpcloud.employeedetails.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.famocom.erpcloud.employeedetails.constants.EmployeeDetailsPortletKeys;
import com.liferay.famocom.erpcloud.employeedetails.helper.EmployeeDetailsHelper;
import com.liferay.famocom.erpcloud.employeedetails.model.EmployeeParams;
import com.liferay.famocom.erpcloud.employeedetails.util.PayStructureUtil;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=EmployeeDetails Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeDetailsPortletKeys.EmployeeDetails,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeDetailsPortlet extends MVCPortlet {

	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * For add employee with all information
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void addEmployeeDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// set Employee Params
		EmployeeParams employeeParams = EmployeeDetailsHelper.getInstance().setEmployeeParams(actionRequest);

		// validate Params -- server side validation
		List<String> errorList = EmployeeDetailsHelper.getInstance().validateParams(employeeParams);

		// Upload profile photo
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long dlfileId= uploadFile(uploadPortletRequest, employeeParams, actionRequest, themeDisplay);
		
		
		long creatorUserId = 0;
		Company company = null;
		try {
			company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		long companyId = company.getCompanyId();
		String screenName = employeeParams.getUserName();
		ServiceContext serviceContext = null;
		Locale locale = Locale.US;
		try {
			if (errorList.isEmpty()) {
				//user create
				String password = "";
				String infoarr[] = employeeParams.getDateOfBirth().split("/");
				password = employeeParams.getFirstName() + infoarr[0] + infoarr[1] + infoarr[2];
				User newUser = UserLocalServiceUtil.addUser(creatorUserId, themeDisplay.getCompanyId(), false, password,
						password, false, screenName, employeeParams.getEmail(), 0, "", locale,
						employeeParams.getFirstName(), "", employeeParams.getLastName(), 0, 0, true, 7, 7, 1999, null,
						(new long[] {}), (new long[] {}), (new long[] {}), (new long[] {}), false, serviceContext);
				UserLocalServiceUtil.updateStatus(newUser.getUserId(), WorkflowConstants.STATUS_INACTIVE);
				
				
				long employeeId = CounterLocalServiceUtil.increment(Employee.class.getName());
				Employee employee = EmployeeLocalServiceUtil.createEmployee(employeeId);
				
				//Set employee details
				employee = EmployeeDetailsHelper.getInstance().setEmployeePersistanceData(employee, employeeParams);

				if (dlfileId != 0) {
					employee.setPhotoId(dlfileId);
				}
				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());

				employee.setGroupId(themeDisplay.getScopeGroupId());
				employee.setStatus(WorkflowConstants.STATUS_DRAFT);
				employee.setStatusByUserId(themeDisplay.getUserId());
				employee.setStatusDate(new Date());
				employee.setStatusByUserName(user.getFullName());
				employee.setStatusByUserUuid(user.getUserUuid());
				employee.setAddedDate(new Date());
				employee.setUserId(newUser.getUserId());
				EmployeeLocalServiceUtil.addEmployee(employee);
				setRole(themeDisplay.getCompanyId(), newUser.getUserId());

				// Workflow
				// Integration===========================================================================

				long groupId = themeDisplay.getScopeGroupId();

				ServiceContext serviceContext1 = ServiceContextFactory
						.getInstance(EmployeeDetailsPortlet.class.getName(), actionRequest);
				serviceContext1.setAddGroupPermissions(true);
				serviceContext1.setAddGuestPermissions(true);
				serviceContext1.setCompanyId(companyId);
				serviceContext1.setScopeGroupId(groupId);
				serviceContext1.setUserId(user.getUserId());

				String postName = employeeParams.getFirstName();

				updateAssetEntry(user, groupId, employee, postName);

				Indexer<Employee> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Employee.class);
				indexer.reindex(employee);
				WorkflowHandlerRegistryUtil.startWorkflowInstance(employee.getCompanyId(), employee.getGroupId(),
						themeDisplay.getUserId(), Employee.class.getName(), employee.getPrimaryKey(), employee,
						serviceContext1);

				// ===============================================================================================

				/*-----Mail Send------*/

				
				String fromAddress = "";
				String fromName = "";
				String toAddress = "";
				String emailFor = "newEmployee";
				String body = "";
				String info = "";
				long infoId = 0;
				String messageBody = "";
				toAddress = newUser.getEmailAddress();
				String userId = newUser.getEmailAddress();
				String empFullName = employee.getFirstName() + " " + employee.getLastName(); // Company
				company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID)); // compId
																													// =
				company.getCompanyId();
				String authId = PrefsPropsUtil.getString(companyId, "mail.session.mail.smtp.user");
				String authPass = PrefsPropsUtil.getString(companyId, "mail.session.mail.smtp.password");
				fromName = PrefsPropsUtil.getString(companyId, "admin.email.from.name");
				fromAddress = PrefsPropsUtil.getString(companyId, "admin.email.from.address");
				System.out.println("fromName :" + fromName + " fromAddress :" + fromAddress);

				EmailTemplate eTemplate = EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
				body = eTemplate.getTemplateBody();
				messageBody = body.replace("$NAME", empFullName);
				messageBody = messageBody.replace("$USERID", userId);
				messageBody = messageBody.replace("$PASSWORD", password);

				InternetAddress[] to = { new InternetAddress(toAddress) };
				InternetAddress from = new InternetAddress(fromAddress);

				MailMessage mailMessage = new MailMessage();
				mailMessage.setTo(to);
				mailMessage.setFrom(from);
				mailMessage.setSubject("Famocom Portal Login Information");
				mailMessage.setBody(messageBody);
				mailMessage.setHTMLFormat(true);
				MailServiceUtil.sendEmail(mailMessage);

			} else {
				HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
				httpRequest.setAttribute("errorList", errorList);
				actionResponse.setWindowState(WindowState.NORMAL);
				SessionMessages.add(actionRequest, "error");
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addEmployee.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setRole(long companyId, long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		Role liferayRole = RoleLocalServiceUtil.fetchRole(companyId, "Employee");
		RoleLocalServiceUtil.addUserRole(user.getUserId(), liferayRole.getRoleId());
		// UserLocalServiceUtil.updateUser(user);
	}

	public void updateAssetEntry(User user, long groupId, Employee employee, String postName) {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil
				.createAssetEntry(CounterLocalServiceUtil.increment(AssetEntry.class.getName()));
		assetEntry.setUserId(user.getUserId());
		assetEntry.setGroupId(groupId);
		assetEntry.setCreateDate(new Date());
		assetEntry.setModifiedDate(new Date());
		assetEntry.setClassName(Employee.class.getName());
		assetEntry.setClassPK(employee.getEmployeeId());
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
		try {
			AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry);
		} catch (Exception e) {
			System.out.println("Error While updating AssetEntry.............................");

		}

	}

	// Image Upload....

	public void uploadDocument(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		createFolder(actionRequest, themeDisplay);
		fileUpload(themeDisplay, actionRequest);

	}

	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		boolean folderExist = isFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						actionRequest);
				folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId, PARENT_FOLDER_ID,
						"Image_Upload", "This folder is create for Upload Images", serviceContext);

				/*
				 * DLAppServiceUtil.addFolder(repositoryId, parentFolderId,
				 * name, description, serviceContext)(repositoryId,
				 * PARENT_FOLDER_ID, "Image_Upload",
				 * "This folder is create for Upload Images", serviceContext);
				 */
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		}
		return folder;
	}

	public boolean isFolderExist(ThemeDisplay themeDisplay) {
		boolean folderExist = false;
		try {
			DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "Image_Upload");
			folderExist = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}

	public Folder getFolder(ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "Image_Upload");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}

	public void fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("uploadedFile");
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");
		String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			Folder folder = getFolder(themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			InputStream is = new FileInputStream(file);
			DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), repositoryId, folder.getFolderId(), fileName,
					mimeType, title, description, "", is, file.getTotalSpace(), serviceContext);
			/*
			 * DLAppLocalServiceUtil.addFileEntry(repositoryId,
			 * folder.getFolderId(), fileName, mimeType, title, description, "",
			 * is, file.getTotalSpace(), serviceContext);
			 */
			// DLFileEntryLocalServiceUtil.

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void editEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//set employee params
		EmployeeParams employeeParams= EmployeeDetailsHelper.getInstance().setEmployeeParams(actionRequest);
		employeeParams.setEmployeeId(ParamUtil.getLong(actionRequest, "employeeId"));
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("employeePhoto");
		File file = uploadPortletRequest.getFile("employeePhoto");
		String mimeType = uploadPortletRequest.getContentType("employeePhoto");
		long fileSize = uploadPortletRequest.getSize("employeePhoto");
		String title = employeeParams.getFirstName() + "_" + employeeParams.getLastName();
		String description = "This file is added via programatically";
		FileEntry dlfile = null;
		Employee empObj = null;
		User user = null;
		try {
			empObj = EmployeeLocalServiceUtil.getEmployee(employeeParams.getEmployeeId());
			user = UserLocalServiceUtil.getUser(empObj.getUserId());
			if (empObj.getPhotoId() != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						actionRequest);
				dlfile = DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(), empObj.getPhotoId(), fileName,
						mimeType, title, description, "", false, file, serviceContext);
			} else {
				String fileName1 = uploadPortletRequest.getFileName("employeePhoto");
				String mimeType1 = uploadPortletRequest.getContentType("employeePhoto");
				long fileSize1 = uploadPortletRequest.getSize("employeePhoto");
				String title1 = employeeParams.getFirstName() + "_" + employeeParams.getLastName() + "_" + (new Date().getTime());
				String description1 = "This file is added via programatically";
				long repositoryId1 = themeDisplay.getScopeGroupId();
				System.out.println("Title=>" + title1);
				System.out.println("file.getTotalSpace()=>" + file.getTotalSpace());
				System.out.println("Title=>" + title1);

				if (fileSize1 > 0) {
					try {
						createFolder(actionRequest, themeDisplay);
						Folder folder = getFolder(themeDisplay);
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
								actionRequest);
						InputStream is = new FileInputStream(file);
						dlfile = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), repositoryId1,
								folder.getFolderId(), fileName1, mimeType1, title1, description1, "", is, fileSize1,
								serviceContext);
						System.out.println("fileSize...." + fileSize);

					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			//Set employee details
			empObj = EmployeeDetailsHelper.getInstance().setEmployeePersistanceData(empObj, employeeParams);
			if (dlfile != null) {
				empObj.setPhotoId(dlfile.getFileEntryId());
			}
			user.setEmailAddress(employeeParams.getEmail());
			user.setFirstName(employeeParams.getFirstName());
			user.setLastName(employeeParams.getLastName());
			empObj.setAddedDate(new Date());
			EmployeeLocalServiceUtil.updateEmployee(empObj);
			UserLocalServiceUtil.updateUser(user);

			/*
			 * //Workflow
			 * Integration======================================================
			 * =====================
			 * 
			 * 
			 * 
			 * /*------Mail send-------
			 */

			/*
			 * if(!oldEmail.equalsIgnoreCase(user.getEmailAddress())){
			 * 
			 * Company company = null; try { company =
			 * CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.
			 * COMPANY_DEFAULT_WEB_ID)); } catch (PortalException e1) {
			 * e1.printStackTrace(); } long companyId = company.getCompanyId();
			 * //String screenName = userName; boolean gen = false;
			 * ServiceContext serviceContext = null;
			 * 
			 * String fromAddress = ""; String fromName = ""; String toAddress =
			 * ""; String emailFor ="updateEmployee"; String body = ""; String
			 * info = ""; long infoId = 0; String messageBody ="";
			 * toAddress=user.getEmailAddress(); String
			 * userId=user.getEmailAddress(); String empFullName =
			 * empObj.getFirstName()+" "+empObj.getLastName(); //Company company
			 * = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.
			 * COMPANY_DEFAULT_WEB_ID)); //compId = company.getCompanyId();
			 * String authId = PrefsPropsUtil.getString(companyId,
			 * "mail.session.mail.smtp.user"); String authPass =
			 * PrefsPropsUtil.getString(companyId,
			 * "mail.session.mail.smtp.password"); fromName =
			 * PrefsPropsUtil.getString(companyId, "admin.email.from.name");
			 * fromAddress = PrefsPropsUtil.getString(companyId,
			 * "admin.email.from.address");
			 * System.out.println("fromName :"+fromName+" fromAddress :"
			 * +fromAddress);
			 * 
			 * EmailTemplate eTemplate =
			 * EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
			 * body=eTemplate.getTemplateBody();
			 * messageBody=body.replace("$NAME", empFullName);
			 * messageBody=messageBody.replace("$USERID",userId) ;
			 * //messageBody=messageBody.replace("$PASSWORD",password);
			 * 
			 * 
			 * EmailTemplate eTemplate =
			 * EmailTemplateLocalServiceUtil.findByemailFor(emailFor); body =
			 * eTemplate.getTemplateBody(); messageBody = body.replace("$NAME",
			 * empFullName);
			 * 
			 * InternetAddress[] to = { new InternetAddress(toAddress) };
			 * InternetAddress from = new InternetAddress(fromAddress);
			 * 
			 * 
			 * MailMessage mailMessage = new MailMessage();
			 * mailMessage.setTo(to); mailMessage.setFrom(from);
			 * mailMessage.setSubject("Famocom Portal Login Information");
			 * mailMessage.setBody(messageBody);
			 * mailMessage.setHTMLFormat(true);
			 * MailServiceUtil.sendEmail(mailMessage); }
			 */

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deactivate(ActionRequest actionRequest, ActionResponse actionResponse) {

		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");

		long userId = ParamUtil.getLong(actionRequest, "userId");
		if (userId > 0 && employeeId > 0) {
			try {
				User user = UserLocalServiceUtil.getUser(userId);
				User user1 = UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE);

				Employee empObj = EmployeeLocalServiceUtil.getEmployee(employeeId);
				empObj.setEmployeeStatus(user1.getStatus());

				EmployeeLocalServiceUtil.updateEmployee(empObj);

			} catch (PortalException e) {
				e.printStackTrace();
			}
		}

	}

	public void activate(ActionRequest actionRequest, ActionResponse actionResponse) {

		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		long userId = ParamUtil.getLong(actionRequest, "userId");

		if (userId > 0 && employeeId > 0) {
			try {

				User user = UserLocalServiceUtil.getUser(userId);
				User user1 = UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED);
				Employee empObj = EmployeeLocalServiceUtil.getEmployee(employeeId);
				empObj.setEmployeeStatus(user1.getStatus());

				EmployeeLocalServiceUtil.updateEmployee(empObj);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}

	public void multiDeactivate(ActionRequest actionRequest, ActionResponse actionResponse) {
		String value = ParamUtil.getString(actionRequest, "val");
		String infoarr[] = value.split(",");
		for (int i = 0; i < infoarr.length; i++) {
			try {
				long userId = Long.valueOf(infoarr[i]);
				// User user = UserLocalServiceUtil.getUser(userId);
				User user1 = UserLocalServiceUtil.updateStatus(userId, WorkflowConstants.STATUS_INACTIVE);
				System.out.println("executed--");
				// System.out.println("Status:-----" + user.getStatus());
				Employee empObj = EmployeeLocalServiceUtil.findByemployees(userId);
				empObj.setEmployeeStatus(user1.getStatus());
				System.out.println("empObj.setEmployeeStatus(status):-" + empObj);
				Employee emp = EmployeeLocalServiceUtil.updateEmployee(empObj);
				if (emp != null) {
					HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(actionResponse);
					httpResponse.flushBuffer();
					httpResponse.setContentType("html/text");
					ServletOutputStream out = httpResponse.getOutputStream();
					out.print("SUCCESS");
					out.flush();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String redirectJsp = ParamUtil.getString(renderRequest, "jspPage");
		if (Validator.isNotNull(redirectJsp)
				&& redirectJsp.trim().equalsIgnoreCase("/META-INF/resources/addEmployee.jsp")) {
			long empId = Long.parseLong(ParamUtil.getString(renderRequest, "employeeId", "0"));
			System.out.println(",,,,,,,,,,,,,,,,,,,,,empId... "+empId);
		}
		if (Validator.isNotNull(redirectJsp) && redirectJsp.equalsIgnoreCase("/addPayStructure.jsp")) {
			List<PayComponent> payComponent = new ArrayList<PayComponent>();
			payComponent = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
			List<String> earningList = new ArrayList<String>();
			earningList.add(EmployeeDetailsPortletKeys.Earning);
			earningList.add(EmployeeDetailsPortletKeys.Overtime);
			earningList.add(EmployeeDetailsPortletKeys.Reimbursement);
			earningList.add(EmployeeDetailsPortletKeys.StatutoryComponent);

			HashMap<String, List<PayComponent>> hashMap = new HashMap<>();
			List<PayComponent> payComponentEarningList = new ArrayList<PayComponent>();
			List<PayComponent> payComponentDeductionList = new ArrayList<PayComponent>();
			if (Validator.isNotNull(payComponent) && payComponent.size() > 0) {
				for (PayComponent component : payComponent) {
					if (Validator.isNotNull(component.getPayType())) {
						if (earningList.contains(component.getPayType())) {
							payComponentEarningList.add(component);
						}
						if (component.getPayType().equalsIgnoreCase(EmployeeDetailsPortletKeys.Deduction)) {
							payComponentDeductionList.add(component);
						}
					}
				}
				hashMap.put(EmployeeDetailsPortletKeys.Earning, payComponentEarningList);
				hashMap.put(EmployeeDetailsPortletKeys.Deduction, payComponentDeductionList);
			}
			renderRequest.setAttribute("payComponentEarningList", payComponentEarningList);
			renderRequest.setAttribute("payComponentDeductionList", payComponentDeductionList);
			renderRequest.setAttribute("earningList", earningList);
		}
		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "addPayStructure")
	public void addPayStructure(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, PortalException {
		String componenetIdList = ParamUtil.getString(actionRequest, "componenetIdList", StringPool.BLANK);
		String employeeId = ParamUtil.getString(actionRequest, "employeeId");
		String totalPay = ParamUtil.getString(actionRequest, "totalPay");
		String[] componenetIds= componenetIdList.split(",");
		List<String> list = Arrays.asList(componenetIds); 
		double payPerMonth = 0;
		for(String str:list){
			 System.out.println("str....."+str);
			 String component="compo_"+str;
			 String amount = ParamUtil.getString(actionRequest, component);
			 System.out.println("amount....."+amount);
			 PayComponent pCom = null; 
			 if(Validator.isNotNull(str)){
				 pCom = PayComponentLocalServiceUtil.getPayComponent(Long.valueOf(str));	 
			 }
			 if(Validator.isNotNull(pCom)){		
				 if(EmployeeDetailsPortletKeys.Earning.equalsIgnoreCase(pCom.getPayType())){
					 payPerMonth += Double.valueOf(amount);
				 }				
			 }
			 
			 long empPayStructureId = CounterLocalServiceUtil.increment(EmpPayStructure.class.getName());
			
			 EmpPayStructure empPayStructure = EmpPayStructureLocalServiceUtil.createEmpPayStructure(empPayStructureId);
			 if(Validator.isNotNull(employeeId)){
				 empPayStructure.setEmployeeId(Long.valueOf(employeeId));
			 }
			 if(Validator.isNotNull(amount)){
				 empPayStructure.setComponentValue(Double.valueOf(amount));
			 }
			 if(Validator.isNotNull(str)){
			 empPayStructure.setPayComponentId(Long.valueOf(str));
			 }
			EmpPayStructureLocalServiceUtil.addEmpPayStructure(empPayStructure);
		}
		if (Validator.isNotNull(employeeId)) {

			Employee employee = EmployeeLocalServiceUtil.getEmployee(Long.valueOf(employeeId));
			if(Validator.isNotNull(totalPay)){
				employee.setPayPerMonth(Double.valueOf(totalPay));
			}
			EmployeeLocalServiceUtil.updateEmployee(employee);
		}
		actionResponse.setRenderParameter("jspPage", "/view.jsp");
	}
	@ProcessAction(name="editPayStructure")
	public void editPayStructure(ActionRequest actionRequest,ActionResponse actionResponse) throws NumberFormatException, PortalException{
		System.out.println("inside editPayStructure............");
		String componenetIdList = ParamUtil.getString(actionRequest, "componenetIdList",StringPool.BLANK);
		String empPayStructureIdList = ParamUtil.getString(actionRequest, "empPayStructureIdList",StringPool.BLANK);
		String employeeId = ParamUtil.getString(actionRequest, "employeeId");
		String[] componenetIds= componenetIdList.split(",");
		List<String> list = Arrays.asList(componenetIds); 
		String totalPay = ParamUtil.getString(actionRequest, "totalPay");
		String[] empPayStructureIds= empPayStructureIdList.split(",");
		List<String> empPayStructureIdsList = Arrays.asList(empPayStructureIds); 
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("employeeId", employeeId, PortletSession.APPLICATION_SCOPE);
		double payPerMonth = 0;
		for(String str:list){		
			 System.out.println("str....."+str);
			 String component="compo_"+str;
			 String amount = ParamUtil.getString(actionRequest, component);
			 System.out.println("amount....."+amount);
			 
			 PayComponent pCom = null; 
			 if(Validator.isNotNull(str)){
				 pCom = PayComponentLocalServiceUtil.getPayComponent(Long.valueOf(str));	 
			 }
			 if(Validator.isNotNull(pCom)){		
				 if(EmployeeDetailsPortletKeys.Earning.equalsIgnoreCase(pCom.getPayType())){
					 payPerMonth += Double.valueOf(amount);
				 }				
			 }
			 EmpPayStructure payStructure = null;
			 try{
			 payStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentIdAndEmployeeId(Long.valueOf(str), Long.valueOf(employeeId));
			 }catch (Exception e) {
			}
			 if(Validator.isNotNull(payStructure)){
				 if(payStructure.getPayComponentId()==Long.valueOf(str)){						  
					  if(Validator.isNotNull(amount)){
						  payStructure.setComponentValue(Double.valueOf(amount));
						  EmpPayStructureLocalServiceUtil.updateEmpPayStructure(payStructure);
					   }
				  }
			 }else{
				 long empPayStructureId = CounterLocalServiceUtil.increment(EmpPayStructure.class.getName());					
				 EmpPayStructure empPayStructure = EmpPayStructureLocalServiceUtil.createEmpPayStructure(empPayStructureId);
				 if(Validator.isNotNull(employeeId)){
					 empPayStructure.setEmployeeId(Long.valueOf(employeeId));
				 }
				 if(Validator.isNotNull(amount)){
					 empPayStructure.setComponentValue(Double.valueOf(amount));
				 }
				 if(Validator.isNotNull(str)){
				 empPayStructure.setPayComponentId(Long.valueOf(str));
				 }
				 EmpPayStructureLocalServiceUtil.addEmpPayStructure(empPayStructure);
			 }			
		}
		if(Validator.isNotNull(employeeId)){
			Employee employee = EmployeeLocalServiceUtil.getEmployee(Long.valueOf(employeeId));
			if(Validator.isNotNull(totalPay)){
				employee.setPayPerMonth(Double.valueOf(totalPay));
			}
			EmployeeLocalServiceUtil.updateEmployee(employee);
		}
		actionResponse.setRenderParameter("jspPage", "/view.jsp");
	}
	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		ThemeDisplay themeDisplay  = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (cmd.trim().equalsIgnoreCase("calculatePaycomponent")) {			
			String totalPay = ParamUtil.getString(request, "totalPay", StringPool.BLANK);
			JSONArray jsonArray =PayStructureUtil.getPayComponentAmountByTotalPay(totalPay);
			PrintWriter writer = response.getWriter();
			writer.print(jsonArray);
		}
	}


	
	/*static double computeAnother(String equation) {
		double result = 0.00;
		if (equation.contains("(")) {
			Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(equation);
			while (m.find()) {
				double value = 0;
				value = compute(m.group(1));
				result += value;
				equation = equation.replace("(" + m.group(1) + ")", String.valueOf(value));
			}
			result = compute(equation);
		} else {
			result = compute(equation);
		}
		return result;
	}
*/

	/**
	 * For File Upload 
	 * @param uploadPortletRequest
	 * @param employeeParams
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	public long uploadFile(UploadPortletRequest uploadPortletRequest, EmployeeParams employeeParams,
			ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		File file = uploadPortletRequest.getFile("employeePhoto");
		long fileSize = uploadPortletRequest.getSize("employeePhoto");
		FileEntry dlfile = null;
		if (file != null && fileSize > 0) {
			String fileName = uploadPortletRequest.getFileName("employeePhoto");
			String mimeType = uploadPortletRequest.getContentType("employeePhoto");
			String title = employeeParams.getFirstName() + "_" + employeeParams.getLastName() + "_"
					+ (new Date().getTime());
			String description = "This file is added via programatically";
			long repositoryId = themeDisplay.getScopeGroupId();

			try {
				createFolder(actionRequest, themeDisplay);
				Folder folder = getFolder(themeDisplay);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						actionRequest);
				InputStream is = new FileInputStream(file);
				dlfile = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), repositoryId,
						folder.getFolderId(), fileName, mimeType, title, description, "", is, fileSize, serviceContext);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		if (dlfile != null)
			return dlfile.getFileEntryId();
		else
			return 0;
	}
	
	

}