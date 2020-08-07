package com.liferay.famocom.erpcloud.raisebill.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.famocom.erpcloud.model.BillDocumentUploadFile;
import com.liferay.famocom.erpcloud.model.Billing;
import com.liferay.famocom.erpcloud.model.Milestone;
import com.liferay.famocom.erpcloud.raisebill.constants.RaiseBillPortletKeys;
import com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.BillingLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.suggest.SuggesterResult.Entry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RaiseBill Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RaiseBillPortletKeys.RaiseBill,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RaiseBillPortlet extends MVCPortlet {
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	public void uploadBilling(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		long billingId = ParamUtil.getLong(actionRequest,"billingId");
		long milestoneId = ParamUtil.getLong(actionRequest, "milestoneId");
		System.out.println("milestoneId:-"+milestoneId);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String billName = ParamUtil.getString(actionRequest, "billTitle",StringPool.BLANK);
		System.out.println("billingId:-"+billingId);
		int[] rowIndexes = ParamUtil.getIntegerValues(actionRequest, "rowIndexes", new int[0]);
		 
		for (int i : rowIndexes) {
			//String employeeDoc = ParamUtil.getString(actionRequest, "employeeDoc" + i);
			String billTitle = ParamUtil.getString(actionRequest, "billTitle" + i);
	 
			System.out.println(StringPool.SPACE + billTitle);
			
			/*UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String fileName = uploadPortletRequest.getFileName("employeeDoc");
			File file = uploadPortletRequest.getFile("employeeDoc");
			String mimeType = uploadPortletRequest.getContentType("employeeDoc");
			long fileSize = uploadPortletRequest.getSize("employeeDoc");
			Date date2 = new Date();
			Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds()) * 1000);
			String title = ParamUtil.getString(actionRequest, "docName", StringPool.BLANK);
			String description = "This file is added via programatically";
			long repositoryId = themeDisplay.getScopeGroupId();
			System.out.println("Title=>" + title);
			System.out.println("file.getTotalSpace()=>" + file.getTotalSpace());
			System.out.println("Title=>" + title);
			FileEntry dlfile = null;

			if (fileSize > 0) {
				try {
					createFolder(actionRequest, themeDisplay);
					Folder folder = getFolder(themeDisplay);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
							actionRequest);
					InputStream is = new FileInputStream(file);
					dlfile = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title,
							description, "", is, fileSize, serviceContext);
					System.out.println("fileSize...." + fileSize);
					Employee emp = EmployeeLocalServiceUtil.getEmployee(employeeId);
					TravelDeskDetails tdd = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
					//tdd.setManagerComment(comment);
					//tdd.setStatus(Integer.valueOf(status));
					tdd.setDocumentName(documentName);
					if(dlfile!=null){
						tdd.setDocumentId(dlfile.getFileEntryId());
					}
					TravelDeskDetailsLocalServiceUtil.addTravelDeskDetails(tdd);

				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}*/
			System.out.println("I value:" + i);
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
			Folder folder = getFolder(themeDisplay);
			InputStream is;
			// File file;
			String title, description, mimeType;
			long repositoryId;
			FileEntry dlfile;
			String fileName;
			File file;
			long fileSize;
			// String mimeType =
			// uploadPortletRequest.getContentType("uploadedFiles");
			//long fileSize = 0;
			for (java.util.Map.Entry<String, FileItem[]> file2 : files.entrySet()) {
				
				FileItem item[] =file2.getValue();

				try {
					for (FileItem fileItem : item) {
						title = billTitle;
						description = title +" is added via programatically";
						repositoryId = themeDisplay.getScopeGroupId();
						mimeType = fileItem.getContentType();
						file = fileItem.getStoreLocation();
						is = fileItem.getInputStream();
						fileName = fileItem.getFileName();
						fileSize = fileItem.getSize();
						System.out.println("file2...."+file2.toString());
						System.out.println("fileItem...."+fileItem);
						System.out.println("file size...."+fileSize);
						System.out.println("file...."+file);
						System.out.println("title...."+title);
						if (fileSize > 0){
				    	try {
				    		createFolder(actionRequest, themeDisplay);
				    		folder = getFolder(themeDisplay);
				    		ServiceContext serviceContext = ServiceContextFactory
									.getInstance(DLFileEntry.class.getName(), actionRequest);
							dlfile = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title,
									mimeType, title, description, "", is,fileSize , serviceContext);

							long documentId = CounterLocalServiceUtil.increment(BillDocumentUploadFile.class.getName());
							BillDocumentUploadFile dof = BillDocumentUploadFileLocalServiceUtil.createBillDocumentUploadFile(documentId);
							//Billing billing = BillingLocalServiceUtil.getBilling(billingId);
							String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
									+ themeDisplay.getScopeGroupId() + "/" + folder.getFolderId() + "/"
									+ HttpUtil.encodeURL(HtmlUtil.unescape(dlfile.getTitle()));
							//tdd.setManagerComment(comment);
							//tdd.setStatus(Integer.valueOf(status));
							//Date date = new Date(); // Local Date fetch........
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							dof.setDocumentName(billTitle);
							dof.setDocumentPath(fileUrl);
							dof.setBillingId(billingId);
							//billing.setBillTitle(billTitle);
							//dof.setEmployeeId(employeeId);
							//dof.setTravelDetailsId(travelId);
						//	dof.setUploadDate(date);
							if(dlfile!=null){
								dof.setDlFileEntryId(dlfile.getFileEntryId());
							}
							BillDocumentUploadFileLocalServiceUtil.addBillDocumentUploadFile(dof);
							Milestone milestone =MilestoneLocalServiceUtil.getMilestone(milestoneId);
							milestone.setStatus(2);
							MilestoneLocalServiceUtil.updateMilestone(milestone);
							
						} catch (PortalException e) {
							e.printStackTrace();
						} catch (SystemException e) {
							e.printStackTrace();
						}
						}
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			
		}
		//System.out.println("travelId in java..."+travelId);
		
		
		/*UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
		System.out.println("files   "+files.size());
		System.out.println("files   "+files.entrySet());
		for (java.util.Map.Entry<String, FileItem[]> file2 : files.entrySet()) {
			
		}
		//UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("employeeDoc");
		File file = uploadPortletRequest.getFile("employeeDoc");
		String mimeType = uploadPortletRequest.getContentType("employeeDoc");
		long fileSize = uploadPortletRequest.getSize("employeeDoc");
		Date date2 = new Date();
		Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds()) * 1000);
		String title = ParamUtil.getString(actionRequest, "docName", StringPool.BLANK);
		String title = "Uploaded document"+ "_" + time2;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>" + title);
		System.out.println("file.getTotalSpace()=>" + file.getTotalSpace());
		System.out.println("Title=>" + title);
		FileEntry dlfile = null;

		if (fileSize > 0) {
			try {
				createFolder(actionRequest, themeDisplay);
				Folder folder = getFolder(themeDisplay);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						actionRequest);
				InputStream is = new FileInputStream(file);
				dlfile = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title,
						description, "", is, fileSize, serviceContext);
				System.out.println("fileSize...." + fileSize);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}*/
		
	}
	
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
				folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, "Image_Upload",
						"This folder is create for Upload Images", serviceContext);
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
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "Image_Upload");
			folderExist = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	public Folder getFolder(ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "Image_Upload");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	public void fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
		System.out.println("calllll");
		String fileName = uploadPortletRequest.getFileName("billTitle");
		File file = uploadPortletRequest.getFile("billTitle");
		String mimeType = uploadPortletRequest.getContentType("billTitle");
		String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		for (java.util.Map.Entry<String, FileItem[]> file2 : files.entrySet()) {
			
			FileItem item[] =file2.getValue();
		try {
			for (FileItem fileItem : item) {
			Folder folder = getFolder(themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			InputStream is = new FileInputStream(file);
			DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title, description,
					"", is, file.getTotalSpace(), serviceContext);

		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		}
		/*Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
		Folder folder = getFolder(themeDisplay);
		InputStream is;
		File file;
		String title, description,mimeType;
		long repositoryId;
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			
			FileItem item[] =file2.getValue();

			try {
				for (FileItem fileItem : item) {
					title = fileItem.getFileName();
					description = title +" is added via programatically";
					repositoryId = themeDisplay.getScopeGroupId();
					mimeType = fileItem.getContentType();	
					file = fileItem.getStoreLocation();
					is =fileItem.getInputStream();
					System.out.println("file...."+file);
					System.out.println("title...."+title);
					
			    	try {
						ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
						DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, 
								title, description, "", is, file.getTotalSpace(), serviceContext);
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}*/

	}
	
}