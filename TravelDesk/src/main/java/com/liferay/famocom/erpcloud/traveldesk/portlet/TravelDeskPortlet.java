package com.liferay.famocom.erpcloud.traveldesk.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload;
import com.liferay.famocom.erpcloud.model.TravelDeskDetails;
import com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.traveldesk.constants.TravelDeskPortletKeys;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

/**
 * @author raj
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=TravelDesk Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TravelDeskPortletKeys.TravelDesk, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TravelDeskPortlet extends MVCPortlet {
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	public void travelDeskAdd(ActionRequest actionRequest, ActionResponse actionResponse) {
		long projectId = ParamUtil.getLong(actionRequest, "projectTeamId");
		String ticketFor = ParamUtil.get(actionRequest, "ticketFor", StringPool.BLANK);
		boolean checkForHotel = ParamUtil.getBoolean(actionRequest, "checkForHotel");
		String fromDate = ParamUtil.get(actionRequest, "fromDate", StringPool.BLANK);
		String fromTime = ParamUtil.get(actionRequest, "fromTime", StringPool.BLANK);
		String toDate = ParamUtil.get(actionRequest, "toDate", StringPool.BLANK);
		String toTime = ParamUtil.get(actionRequest, "toTime", StringPool.BLANK);
		String location = ParamUtil.get(actionRequest, "location", StringPool.BLANK);
		String purpose = ParamUtil.get(actionRequest, "purpose", StringPool.BLANK);
		String specialInstraction = ParamUtil.get(actionRequest, "specialInstraction", StringPool.BLANK);
		/*
		 * Date fDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate); Date
		 * tDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDate); //int
		 * dateCheck = compareDate(fDate,tDate);
		 */
		try {
			/*
			 * System.out.println("projectTeamId-" + projectTeamId +
			 * "ticketFor-" + ticketFor + "checkForHotel-" + checkForHotel +
			 * "fromDate-" + fromDate + "fromTime-" + fromTime + "toDate-" +
			 * toDate + "toTime-" + toTime + "location-" +
			 * location+"purpose-"+purpose+"specialInstraction-"+
			 * specialInstraction);
			 */
			
			ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			// User userDetails = td.getUser();
			System.out.println("td--" + td);
			User user = UserLocalServiceUtil.getUser(td.getUserId());
			Employee emp = EmployeeLocalServiceUtil.findByemployees(td.getUserId());
			System.out.println("emp--" + emp);
			long travelDetailsId = CounterLocalServiceUtil.increment(TravelDeskDetails.class.getName());
			// System.out.println("category...."+cat_id);
			TravelDeskDetails travelDetailsAdd = TravelDeskDetailsLocalServiceUtil
					.createTravelDeskDetails(travelDetailsId);
			Date fromDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
			Date toDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
			List<TravelDeskDetails> tddList = new ArrayList<>();
			DynamicQuery dynamicQuery1 = TravelDeskDetailsLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("employeeId", emp.getEmployeeId());
			criterion3 = RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("projectId", projectId));
			criterion3 = RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("fromDate", fromDate1));
			criterion3 = RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.eq("toDate", toDate1));
			criterion3 = RestrictionsFactoryUtil.and(criterion3, RestrictionsFactoryUtil.between("status", 0, 1));
			dynamicQuery1.add(criterion3);
			tddList = TravelDeskDetailsLocalServiceUtil.dynamicQuery(dynamicQuery1);
			// travelDetailsAdd.setProjectTeamsId(projectTeamId);
			travelDetailsAdd.setProjectId(projectId);
			travelDetailsAdd.setEmployeeId(emp.getEmployeeId());
			travelDetailsAdd.setCompanyId(td.getCompanyId());
			travelDetailsAdd.setUserId(td.getUserId());
			travelDetailsAdd.setTicketType(ticketFor);
			travelDetailsAdd.setHotel(checkForHotel);
			travelDetailsAdd.setFromDate(fromDate1);
			travelDetailsAdd.setFromTime(fromTime);
			travelDetailsAdd.setToDate(toDate1);
			travelDetailsAdd.setToTime(toTime);
			travelDetailsAdd.setLocation(location);
			travelDetailsAdd.setPurpose(purpose);
			travelDetailsAdd.setSpecialInstraction(specialInstraction);
			travelDetailsAdd.setStatus(0);
			travelDetailsAdd.setCreateDate(new Date());
			// fields for workflow integration
			/*travelDetailsAdd.setGroupId(td.getScopeGroupId());
			travelDetailsAdd.setStatus(WorkflowConstants.STATUS_DRAFT);
			travelDetailsAdd.setStatusByUserId(td.getUserId());
			travelDetailsAdd.setStatusDate(new Date());
			travelDetailsAdd.setStatusByUserName(user.getFullName());
			travelDetailsAdd.setStatusByUserUuid(user.getUserUuid()); */
			if (tddList.size() == 0) {
				TravelDeskDetailsLocalServiceUtil.addTravelDeskDetails(travelDetailsAdd);
				/*
				 * List<AddTeamMember> projMembrList = new ArrayList<>();
				 * List<Employee> empList = new ArrayList<>(); List<Employee>
				 * empTempList = new ArrayList<>(); DynamicQuery projQuery =
				 * AddTeamMemberLocalServiceUtil.dynamicQuery(); Criterion
				 * criterion = null; criterion =
				 * RestrictionsFactoryUtil.eq("projectId",addTeamMember.
				 * getProjectId()); criterion =
				 * RestrictionsFactoryUtil.and(criterion,
				 * RestrictionsFactoryUtil.eq("isProjectManager", true));
				 * projQuery.add(criterion); projMembrList =
				 * AddTeamMemberLocalServiceUtil.dynamicQuery(projQuery);
				 * for(int i=0;i<projMembrList.size();i++){ DynamicQuery
				 * dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				 * Criterion criterion1 = null; criterion1 =
				 * RestrictionsFactoryUtil.eq("employeeId",projMembrList.get(i).
				 * getEmployeeId()); dynamicQuery.add(criterion1); empList =
				 * EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
				 * empTempList.addAll(empList); } String fromAddress = "";
				 * String fromName = ""; String toAddress = ""; String emailFor
				 * ="TravelDeskRequest"; String body = ""; String info = "";
				 * long infoId = 0; String messageBody =""; for(int
				 * i=0;i<empTempList.size();i++){
				 * toAddress=empTempList.get(i).getEmaiAddress(); } //String
				 * userId=newUser.getEmailAddress(); String empFullName =
				 * emp.getFirstName()+" "+emp.getLastName(); //Company company =
				 * CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(
				 * PropsKeys.COMPANY_DEFAULT_WEB_ID)); //compId =
				 * company.getCompanyId(); String authId =
				 * PrefsPropsUtil.getString(userDetails.getCompanyId(),
				 * "mail.session.mail.smtp.user"); String authPass =
				 * PrefsPropsUtil.getString(userDetails.getCompanyId(),
				 * "mail.session.mail.smtp.password"); fromName =
				 * PrefsPropsUtil.getString(userDetails.getCompanyId(),
				 * "admin.email.from.name"); fromAddress =
				 * PrefsPropsUtil.getString(userDetails.getCompanyId(),
				 * "admin.email.from.address");
				 * System.out.println("fromName :"+fromName+" fromAddress :"
				 * +fromAddress+" toAdress :"+toAddress);
				 * 
				 * EmailTemplate eTemplate =
				 * EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
				 * body=eTemplate.getTemplateBody();
				 * messageBody=body.replace("$NAME", empFullName);
				 * messageBody=messageBody.replace("$LOCATION",location) ;
				 * //messageBody=messageBody.replace("$PASSWORD",password);
				 * System.out.println(messageBody);
				 * 
				 * EmailTemplate eTemplate =
				 * EmailTemplateLocalServiceUtil.findByemailFor(emailFor); body
				 * = eTemplate.getTemplateBody(); messageBody =
				 * body.replace("$NAME", empFullName);
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
				 * MailServiceUtil.sendEmail(mailMessage);
				 */
				
				// Workflow
				// Integration===========================================================================

				// setRole(td.getCompanyId(),user.getUserId());
				/*long groupId = td.getScopeGroupId();
				// User user =
				// UserLocalServiceUtil.getUser(themeDisplay.getUserId());

				ServiceContext serviceContext1 = ServiceContextFactory.getInstance(TravelDeskPortlet.class.getName(),
						actionRequest);
				serviceContext1.setAddGroupPermissions(true);
				serviceContext1.setAddGuestPermissions(true);
				serviceContext1.setCompanyId(td.getCompanyId());
				serviceContext1.setScopeGroupId(groupId);
				serviceContext1.setUserId(user.getUserId());

				String postName = user.getFullName();

				updateAssetEntry(user, groupId, travelDetailsAdd, postName);

				Indexer<TravelDeskDetails> indexer = IndexerRegistryUtil.nullSafeGetIndexer(TravelDeskDetails.class);
				indexer.reindex(travelDetailsAdd);
				System.out.println("before workflow start--");
				WorkflowHandlerRegistryUtil.startWorkflowInstance(td.getCompanyId(), travelDetailsAdd.getGroupId(),
						td.getUserId(), TravelDeskDetails.class.getName(), travelDetailsAdd.getPrimaryKey(),
						travelDetailsAdd, serviceContext1);
				System.out.println("after workflow start--");
				// ===============================================================================================
				 */
			} else {
				SessionErrors.add(actionRequest, "error");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void travelDeskEdit(ActionRequest actionRequest, ActionResponse actionResponse) {
		long travelDetailsId = ParamUtil.getLong(actionRequest, "travelDetailsId");
		long projectId = ParamUtil.getLong(actionRequest, "projectTeamId");
		String ticketFor = ParamUtil.get(actionRequest, "ticketFor", StringPool.BLANK);
		boolean checkForHotel = ParamUtil.getBoolean(actionRequest, "checkForHotel");
		String fromDate = ParamUtil.get(actionRequest, "fromDate", StringPool.BLANK);
		String fromTime = ParamUtil.get(actionRequest, "fromTime", StringPool.BLANK);
		String toDate = ParamUtil.get(actionRequest, "toDate", StringPool.BLANK);
		String toTime = ParamUtil.get(actionRequest, "toTime", StringPool.BLANK);
		String location = ParamUtil.get(actionRequest, "location", StringPool.BLANK);
		String purpose = ParamUtil.get(actionRequest, "purpose", StringPool.BLANK);
		String specialInstraction = ParamUtil.get(actionRequest, "specialInstraction", StringPool.BLANK);
		try {
			/*
			 * ThemeDisplay td
			 * =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 * User userDetails = td.getUser(); Employee
			 * emp=EmployeeLocalServiceUtil.findByemployees(userDetails.
			 * getUserId());
			 */
			// System.out.println("category...."+cat_id);
			TravelDeskDetails travelDetailsAdd = TravelDeskDetailsLocalServiceUtil
					.getTravelDeskDetails(travelDetailsId);
			Date fromDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
			Date toDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
			// travelDetailsAdd.setProjectTeamsId(projectTeamId);
			travelDetailsAdd.setProjectId(projectId);
			// travelDetailsAdd.setEmployeeId(emp.getEmployeeId());
			// travelDetailsAdd.setCompanyId(userDetails.getCompanyId());
			// travelDetailsAdd.setUserId(userDetails.getUserId());
			travelDetailsAdd.setTicketType(ticketFor);
			travelDetailsAdd.setHotel(checkForHotel);
			travelDetailsAdd.setFromDate(fromDate1);
			travelDetailsAdd.setFromTime(fromTime);
			travelDetailsAdd.setToDate(toDate1);
			travelDetailsAdd.setToTime(toTime);
			travelDetailsAdd.setLocation(location);
			travelDetailsAdd.setPurpose(purpose);
			travelDetailsAdd.setSpecialInstraction(specialInstraction);
			if (travelDetailsAdd.getStatus() == 2) {
				travelDetailsAdd.setStatus(3);
			} else {
				travelDetailsAdd.setStatus(0);
			}
			travelDetailsAdd.setModifiedDate(new Date());
			TravelDeskDetailsLocalServiceUtil.updateTravelDeskDetails(travelDetailsAdd);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void travelDelete(ActionRequest actionRequest, ActionResponse actionResponse) {
		long travelId = ParamUtil.getLong(actionRequest, "id");
		TravelDeskDetails deskDelete = null;
		if (Validator.isNotNull(travelId)) {
			try {
				deskDelete = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
				TravelDeskDetailsLocalServiceUtil.deleteTravelDeskDetails(deskDelete);
			} catch (Exception e) {
			}
		}
	}

	@ProcessAction(name = "uploadDocument")
	public void uploadDocument(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		System.out.println("calllll");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String title = null;
		Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
		/*String location = ParamUtil.getString(actionRequest, "location", StringPool.BLANK);
		String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		String comment = ParamUtil.getString(actionRequest, "comment", StringPool.BLANK);
		String documentName = ParamUtil.getString(actionRequest, "docName", StringPool.BLANK);
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		long travelId = ParamUtil.getLong(actionRequest, "travelId");

		int[] rowIndexes = ParamUtil.getIntegerValues(actionRequest, "rowIndexes", new int[0]);*/

		/*
		 * for (int i : rowIndexes) {
		 * 
		 * String docName = ParamUtil.getString(actionRequest, "docName" + i);
		 * System.out.println(StringPool.SPACE + docName);
		 * System.out.println("I value:" + i); docList.add(docName);
		 * System.out.println("docList..."+docList); //title =
		 * ParamUtil.getString(actionRequest, "docName"+i, StringPool.BLANK); }
		 */
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
		Folder folder = getFolder(themeDisplay);
		InputStream is;
		// File file;
		String description, mimeType;
		long repositoryId;
		FileEntry dlfile;
		String fileName;
		File file;
		long fileSize;
		// String mimeType =
		// uploadPortletRequest.getContentType("uploadedFiles");
		// long fileSize = 0;
		int j = 1;
		System.out.println("before outer loop title...." + title);
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			title = ParamUtil.getString(actionRequest, "docName" + j, StringPool.BLANK);
			FileItem item[] = file2.getValue();

			try {
				System.out.println("before inner loop title...." + title);

				System.out.println("after doclist for loop title...." + title);
				for (FileItem fileItem : item) {
					description = title + " is added via programatically";
					repositoryId = themeDisplay.getScopeGroupId();
					mimeType = fileItem.getContentType();
					file = fileItem.getStoreLocation();
					is = fileItem.getInputStream();
					fileName = fileItem.getFileName();
					fileSize = fileItem.getSize();
					System.out.println("file2...." + file2.toString());
					System.out.println("fileItem...." + fileItem);
					System.out.println("file size...." + fileSize);
					System.out.println("file...." + file);
					System.out.println("title...." + title);
					if (fileSize > 0) {
						try {
							System.out.println("inside try title...." + title);
							createFolder(actionRequest, themeDisplay);
							folder = getFolder(themeDisplay);
							/*
							 * ServiceContext serviceContext =
							 * ServiceContextFactory
							 * .getInstance(DLFileEntry.class.getName(),
							 * actionRequest);
							 */
							ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
							serviceContext.setAddGroupPermissions(true);
							serviceContext.setAddGuestPermissions(true);
							dlfile = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), repositoryId,
									folder.getFolderId(), fileName, mimeType, title, description, "", is, fileSize,
									serviceContext);
							System.out.println("inside try after dlfile title...." + title);
							long documentId = CounterLocalServiceUtil.increment(EmployeeDocumentUpload.class.getName());
							EmployeeDocumentUpload dof = EmployeeDocumentUploadLocalServiceUtil
									.createEmployeeDocumentUpload(documentId);
							String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
									+ themeDisplay.getScopeGroupId() + "/" + folder.getFolderId() + "/"
									+ HttpUtil.encodeURL(HtmlUtil.unescape(dlfile.getTitle()));
							// tdd.setManagerComment(comment);
							// tdd.setStatus(Integer.valueOf(status));
							Date date = new Date(); // Local Date fetch........
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							dof.setDocumentName(title);
							dof.setDocumentPath(fileUrl);
							dof.setEmployeeId(emp.getEmployeeId());
							// dof.setTravelDetailsId(travelId);
							dof.setUploadDate(date);
							if (dlfile != null) {
								dof.setFileEntryId(dlfile.getFileEntryId());
							}
							EmployeeDocumentUploadLocalServiceUtil.addEmployeeDocumentUpload(dof);
							System.out.println("inside try after document add title...." + title);
						} catch (PortalException e) {
							e.printStackTrace();
						} catch (SystemException e) {
							e.printStackTrace();
						}
					}
					// title = docName;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			j++;

		}
		System.out.println("outside outer loop title...." + title);
		// title = docList.get(1);

	}

	/*
	 * public void uploadDocument(ActionRequest actionRequest, ActionResponse
	 * actionResponse) throws IOException, PortletException, PortalException,
	 * SystemException { ThemeDisplay themeDisplay = (ThemeDisplay)
	 * actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 * createFolder(actionRequest, themeDisplay); fileUpload(themeDisplay,
	 * actionRequest);
	 * 
	 * }
	 */
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

	/*
	 * public void fileUpload(ThemeDisplay themeDisplay, ActionRequest
	 * actionRequest) { UploadPortletRequest uploadPortletRequest =
	 * PortalUtil.getUploadPortletRequest(actionRequest); Map<String,
	 * FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
	 * System.out.println("calllll"); String fileName =
	 * uploadPortletRequest.getFileName("employeeDoc"); File file =
	 * uploadPortletRequest.getFile("employeeDoc"); String mimeType =
	 * uploadPortletRequest.getContentType("employeeDoc"); String title =
	 * fileName; String description = "This file is added via programatically";
	 * long repositoryId = themeDisplay.getScopeGroupId(); for (Entry<String,
	 * FileItem[]> file2 : files.entrySet()) {
	 * 
	 * FileItem item[] =file2.getValue(); try { for (FileItem fileItem : item) {
	 * Folder folder = getFolder(themeDisplay); ServiceContext serviceContext =
	 * ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
	 * actionRequest); InputStream is = new FileInputStream(file);
	 * DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(),
	 * fileName, mimeType, title, description, "", is, file.getTotalSpace(),
	 * serviceContext);
	 * 
	 * } } catch (Exception e) { System.out.println(e.getMessage());
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */
	public void updateAssetEntry(User user, long groupId, TravelDeskDetails travelDeskDetails, String postName) throws PortalException {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil
				.createAssetEntry(CounterLocalServiceUtil.increment(AssetEntry.class.getName()));
		assetEntry.setUserId(user.getUserId());
		assetEntry.setGroupId(groupId);
		assetEntry.setCreateDate(new Date());
		assetEntry.setModifiedDate(new Date());
		assetEntry.setClassName(TravelDeskDetails.class.getName());
		assetEntry.setClassPK(travelDeskDetails.getTravelDetailsId());
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
}