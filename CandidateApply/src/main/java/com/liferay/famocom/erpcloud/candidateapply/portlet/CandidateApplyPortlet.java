package com.liferay.famocom.erpcloud.candidateapply.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.famocom.erpcloud.candidateapply.constants.CandidateApplyPortletKeys;
import com.liferay.famocom.erpcloud.model.CandidateApply;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.SkillSet;
import com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SkillSetLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CandidateApply Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CandidateApplyPortletKeys.CandidateApply,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CandidateApplyPortlet extends MVCPortlet {
	
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	/**
	 * apply candidate add with all details and attached cv
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void addApplyCandidate(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		String firstName = ParamUtil.getString(actionRequest, "firstName",StringPool.BLANK);
		String lastName =ParamUtil.getString(actionRequest, "lastName",StringPool.BLANK);
		String email = ParamUtil.getString(actionRequest,"email",StringPool.BLANK);
		String phoneNo = ParamUtil.get(actionRequest,"phoneNo",StringPool.BLANK);
		int years = ParamUtil.getInteger(actionRequest,"years");
		int months = ParamUtil.getInteger(actionRequest,"months");
		int currentctc = ParamUtil.getInteger(actionRequest, "currentctc");
		int expectedctc = ParamUtil.getInteger(actionRequest, "expectedctc");
		String currentCompany = ParamUtil.getString(actionRequest, "currentCompany",StringPool.BLANK);
		int noticePeriod = ParamUtil.getInteger(actionRequest, "noticePeriod");
		long employeeCode = ParamUtil.getLong(actionRequest, "employeeCode");
		String  skillSet=ParamUtil.get(actionRequest, "skillSet", StringPool.BLANK);
		long jobOpeningId = ParamUtil.getLong(actionRequest, "jobOpeningId");
		//String uploadCv = ParamUtil.getString(actionRequest, "uploadCv",StringPool.BLANK);
		
		System.out.println("skillset"+skillSet);
		
		long applyCandidateId = CounterLocalServiceUtil.increment(CandidateApply.class.getName());
		CandidateApply candidate = CandidateApplyLocalServiceUtil.createCandidateApply(applyCandidateId);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("uploadCv");
		File file = uploadPortletRequest.getFile("uploadCv");
		String mimeType = uploadPortletRequest.getContentType("uploadCv");
		long fileSize = uploadPortletRequest.getSize("uploadCv");
		Date date2 = new Date();
		Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds()) * 1000);
		String title = firstName + "_" + lastName + "_" + time2;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>" + title);
		System.out.println("file.getTotalSpace()=>" + file.getTotalSpace());
		System.out.println("Title=>" + title);
		FileEntry dlfile = null;
		DLFolder resumeFolder = null;
		InputStream inputStream = null;
		UploadPortletRequest uploadPortReq =  PortalUtil.getUploadPortletRequest(actionRequest);
		File resumeFile = uploadPortReq.getFile("resume");
		//ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		candidate.setFirstName(firstName);
		//System.out.println();
		candidate.setLastName(lastName);
		candidate.setEmailAddress(email);
		candidate.setPhoneNumber(phoneNo);
		candidate.setYearOfExp(years);
		candidate.setMonthOfExp(months);
		candidate.setCurrentCTC(currentctc);
		candidate.setExpectedCTC(expectedctc);
		candidate.setCurrentCompany(currentCompany);
		candidate.setNoticePeriod(noticePeriod);
		
		//get userId for any Reference
		if(Validator.isNotNull(themeDisplay.getUserId())){
			long userId = themeDisplay.getUserId();
			Employee emolyee = null;
			
			try {
				//System.out.println("111111");
				emolyee = EmployeeLocalServiceUtil.findByemployees(userId);
				//System.out.println("33333");
				if(Validator.isNotNull(emolyee)){
					//System.out.println("222222");
					candidate.setReferenceEmployeeId(emolyee.getEmployeeId());
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		System.out.println("44444");
		candidate.setSkillset(skillSet);
		candidate.setJobOpeningId(jobOpeningId);
		if (fileSize > 0) {
			try {
				createFolder(actionRequest, themeDisplay);
				Folder folder = getFolder(themeDisplay);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						actionRequest);
				InputStream is = new FileInputStream(file);
				dlfile =DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),repositoryId, folder.getFolderId(), fileName, mimeType, title,
						description, "", is, fileSize, serviceContext);
				/*DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title,
						description, "", is, fileSize, serviceContext);*/
				System.out.println("fileSize...." + fileSize);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		if(dlfile!=null){
			candidate.setCvFileId(dlfile.getFileEntryId());
		}
		
		CandidateApplyLocalServiceUtil.addCandidateApply(candidate);
		actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
	}
	
	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		boolean folderExist = isFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						actionRequest);
				folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId, PARENT_FOLDER_ID, "Cv_Upload", "This folder is create for Upload Cv", serviceContext);
						
						/*DLAppServiceUtil.addFolder(repositoryId, parentFolderId, name, description, serviceContext)(repositoryId, PARENT_FOLDER_ID, "Image_Upload",
						"This folder is create for Upload Images", serviceContext);*/
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
			DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "Cv_Upload");
			folderExist = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	public Folder getFolder(ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "Cv_Upload");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	
	
	
	 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
	      String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
	    
	     System.out.println("Constants.CMD: " + cmd);

	     if (cmd.equals("getSkillSets")) {
	    	 String skillName = ParamUtil.getString(resourceRequest, "skillName");
	 		 JSONArray skillArray = JSONFactoryUtil.createJSONArray();
	 		 JSONObject skillObject;
	 	   
	 		try {
	 				DynamicQuery dynamicQuery = SkillSetLocalServiceUtil.dynamicQuery();
	 				dynamicQuery.add(PropertyFactoryUtil.forName("SkillName").like("%"+skillName+"%"));
	 				List<SkillSet> skillList = SkillSetLocalServiceUtil.dynamicQuery(dynamicQuery);
	 				for (SkillSet skills : skillList) {
	 					System.out.println("skillList: " + skillList);
	 					skillObject = JSONFactoryUtil.createJSONObject(); 
	 					skillObject.put("skillId", skills.getSkillId()); 
	 					skillObject.put("skillname", skills.getSkillName());
	 					skillArray.put(skillObject);
	 			       }
	 				
	 		    } catch (SystemException e) {
	 			e.printStackTrace();
	 		   }
	 		  // resourceResponse.getWriter().println();
	 		  // super.serveResource(resourceRequest, resourceResponse);
	 		   PrintWriter out = resourceResponse.getWriter();
	 		   out.println(skillArray.toString());
	 	    }
	     
	    /* if (cmd.equals("checkDuplicateEmail")) {
	    	 String email = ParamUtil.getString(resourceRequest, "textvalue");
	 		 
	 	   
	 		try {
	 				DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
	 				dynamicQuery.add(PropertyFactoryUtil.forName("email").like("%"+email+"%"));
	 				List<RecruitProcess> recruitProcessList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
	 				if(recruitProcessList.size()>0){
	 					
	 				}
	 				
	 		    } catch (SystemException e) {
	 			e.printStackTrace();
	 		   }
	 		  // resourceResponse.getWriter().println();
	 		  // super.serveResource(resourceRequest, resourceResponse);
	 		   PrintWriter out = resourceResponse.getWriter();
	 		   out.println(skillArray.toString());
	 	    }*/
	       
	    
	   }
	
}