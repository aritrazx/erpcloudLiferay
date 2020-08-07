package com.liferay.famocom.erpcloud.tdmanage.portlet;

import java.io.File;
import java.io.FileInputStream;
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
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.famocom.erpcloud.model.DocumentUploadFile;
import com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalServiceUtil;
import com.liferay.famocom.erpcloud.tdmanage.constants.TravelDeskManagementPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
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

/**
 * @author hussh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TravelDeskManagement Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TravelDeskManagementPortletKeys.TravelDeskManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TravelDeskManagementPortlet extends MVCPortlet {
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	@ProcessAction(name="travelDeskManager")
	public void travelDeskManager(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		System.out.println("calllll");
		String title = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String location = ParamUtil.getString(actionRequest, "location", StringPool.BLANK);
		String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		String comment = ParamUtil.getString(actionRequest, "comment", StringPool.BLANK);
		String documentName = ParamUtil.getString(actionRequest, "docName", StringPool.BLANK);
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		long travelId = ParamUtil.getLong(actionRequest, "travelId");
		List<String> docList = new ArrayList<>();
		System.out.println("before row index");
		int[] rowIndexes = ParamUtil.getIntegerValues(actionRequest, "rowIndexes", new int[0]);
		System.out.println("after row index....."+rowIndexes.length);
		/*for (int i : rowIndexes) {
			
			String docName = ParamUtil.getString(actionRequest, "docName" + i);
			System.out.println(StringPool.SPACE + docName);
			System.out.println("I value:" + i);
			docList.add(docName);
			System.out.println("docList..."+docList);
			//title = ParamUtil.getString(actionRequest, "docName"+i, StringPool.BLANK);
		}*/
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
			//long fileSize = 0;
			int j=1;
			System.out.println("before outer loop title...."+title);
			for (Entry<String, FileItem[]> file2 : files.entrySet()) {
				title = ParamUtil.getString(actionRequest, "docName"+j, StringPool.BLANK);
				FileItem item[] =file2.getValue();

				try {
					System.out.println("before inner loop title...."+title);
					
						System.out.println("after doclist for loop title...."+title);
					for (FileItem fileItem : item) {
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
				    		System.out.println("inside try title...."+title);
				    		createFolder(actionRequest, themeDisplay);
				    		folder = getFolder(themeDisplay);
				    		/*ServiceContext serviceContext = ServiceContextFactory
									.getInstance(DLFileEntry.class.getName(), actionRequest);*/
				    		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
							serviceContext.setAddGroupPermissions(true);
							serviceContext.setAddGuestPermissions(true);
							dlfile = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),repositoryId, folder.getFolderId(), fileName,
									mimeType, title, description, "", is,fileSize , serviceContext);
							System.out.println("inside try after dlfile title...."+title);
							long documentId = CounterLocalServiceUtil.increment(DocumentUploadFile.class.getName());
							DocumentUploadFile dof = DocumentUploadFileLocalServiceUtil.createDocumentUploadFile(documentId);
							String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
									+ themeDisplay.getScopeGroupId() + "/" + folder.getFolderId() + "/"
									+ HttpUtil.encodeURL(HtmlUtil.unescape(dlfile.getTitle()));
							//tdd.setManagerComment(comment);
							//tdd.setStatus(Integer.valueOf(status));
							Date date = new Date(); // Local Date fetch........
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							dof.setDocumentName(title);
							dof.setDocumentPath(fileUrl);
							dof.setEmployeeId(employeeId);
							dof.setTravelDetailsId(travelId);
							dof.setUploadDate(date);
							if(dlfile!=null){
								dof.setFileEntryId(dlfile.getFileEntryId());
							}
							DocumentUploadFileLocalServiceUtil.addDocumentUploadFile(dof);
							System.out.println("inside try after document add title...."+title);
						} catch (PortalException e) {
							e.printStackTrace();
						} catch (SystemException e) {
							e.printStackTrace();
						}
						}
						//title = docName;
					}
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				j++;
			
	}
			System.out.println("outside outer loop title...."+title);
			//title = docList.get(1);
			
		
	}
	
	/*public void uploadDocument(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		createFolder(actionRequest, themeDisplay);
		fileUpload(themeDisplay, actionRequest);

	}
	*/
	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		boolean folderExist = isFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						actionRequest);
				folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId, PARENT_FOLDER_ID, "Image_Upload",
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
	
	/*public void fileUpload(ThemeDisplay themeDisplay, ActionRequest actionRequest) {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
		System.out.println("calllll");
		String fileName = uploadPortletRequest.getFileName("employeeDoc");
		File file = uploadPortletRequest.getFile("employeeDoc");
		String mimeType = uploadPortletRequest.getContentType("employeeDoc");
		String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		for (Entry<String, FileItem[]> file2 : files.entrySet()) {
			
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

	}*/
}