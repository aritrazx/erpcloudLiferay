package com.liferay.famocom.erpcloud.candidatepool.portlet;

import com.liferay.famocom.erpcloud.candidatepool.constants.CandiadatePoolPortletKeys;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.model.SkillSet;
import com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SkillSetLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
/**
 * @author Suprakash
 */
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CandiadatePool Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CandiadatePoolPortletKeys.CandiadatePool,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CandiadatePoolPortlet extends MVCPortlet {
	
	@Override
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

	public void candidateAdd(ActionRequest request, ActionResponse response) throws IOException, PortalException{
		List <String> errorList=new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String firstName = ParamUtil.get(request, "firstName", StringPool.BLANK);
		String lastName = ParamUtil.get(request, "lastName", StringPool.BLANK);
		String DOB = ParamUtil.get(request, "DOB", StringPool.BLANK);
		String email = ParamUtil.get(request, "email", StringPool.BLANK);
		Long phoneNumber=ParamUtil.getLong(request, "phoneno");
		String  skillset=ParamUtil.get(request, "skillset", StringPool.BLANK);
		Double 	experience=ParamUtil.getDouble(request, "experience");
		int noticePeriod=ParamUtil.getInteger(request, "noticePeriod");
		Double currentCTC=ParamUtil.getDouble(request, "currentctc");
		Double expextedCTC=ParamUtil.getDouble(request, "expectedctc");
		//Long projectRoleId=ParamUtil.getLong(request, param)
		Long empId=ParamUtil.getLong(request, "empId");
		Long userId=ParamUtil.getLong(request, "userId");
		Long fileEntryId=null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String donaminName=themeDisplay.getPortalURL();
		String fileUrl=null;
		InputStream inputStream =null;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		String fileName = uploadPortletRequest.getFileName("uploadedFile");
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");
		long fileSize = uploadPortletRequest.getSize("uploadedFile");
			if(fileSize==0){
				errorList.add("Resume needs to be uploaded");
				System.out.println("errorList @@@ " + errorList);
			}else{
				inputStream = new FileInputStream(file);
			}
			try {
				 if(!errorList.isEmpty()){
					   HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			           httpRequest.setAttribute("errorList", errorList);
			           SessionMessages.add(request, PortalUtil.getPortletId(request)+ SessionMessages. KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					   response.setRenderParameter("jspPage", "/META-INF/resources/addCandidate.jsp");
					   
				   }else{
					 //  Map<Long, String> filemap =RecruitProcessLocalServiceUtil.getResumeFileUpload(fileName,file, userId, donaminName);
						
						Long tempFilid=0L;
						String tempFilePath=StringPool.BLANK;
						/*for (Map.Entry<Long,String> entry : filemap.entrySet()){
							System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
							tempFilid=entry.getKey();
							tempFilePath=entry.getValue();
						}*/
					   
					   long recruitProcessId = CounterLocalServiceUtil.increment(RecruitProcess.class.getName());
						RecruitProcess recruitProcess = RecruitProcessLocalServiceUtil.createRecruitProcess(recruitProcessId);
						recruitProcess.setFirstName(firstName);
						recruitProcess.setLastName(lastName);
						Date tempDOB = (Date) formatter.parse(DOB);
						recruitProcess.setDOB(tempDOB);
						recruitProcess.setEmail(email);
						recruitProcess.setPhoneNumber(phoneNumber);
						recruitProcess.setEmployeeId(empId);
						recruitProcess.setExperience(experience);
						recruitProcess.setExpextedCTC(expextedCTC);
						recruitProcess.setSkillset(skillset);
						recruitProcess.setFileEntryId(tempFilid);
						recruitProcess.setFileUrl(tempFilePath);
						recruitProcess.setNoticePeriod(noticePeriod);
						recruitProcess.setCreateDate(new Date());
						RecruitProcessLocalServiceUtil.addRecruitProcess(recruitProcess);
						
					   
				   }
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		
	}
	
	public void cadidateEdit(ActionRequest request, ActionResponse response) throws IOException, PortalException{
		
		
		List <String> errorList=new ArrayList<>();
		final String OLD_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String recruitProcessId = ParamUtil.get(request, "recruitProcessId", StringPool.BLANK);
		if (recruitProcessId != null || !recruitProcessId.isEmpty()) {
			String firstName = ParamUtil.get(request, "firstName", StringPool.BLANK);
			String lastName = ParamUtil.get(request, "lastName", StringPool.BLANK);
			String DOB = ParamUtil.get(request, "DOB", StringPool.BLANK);
			String email = ParamUtil.get(request, "email", StringPool.BLANK);
			Long phoneNumber=ParamUtil.getLong(request, "phoneno");
			String  skillset=ParamUtil.get(request, "skillset", StringPool.BLANK);
			Double 	experience=ParamUtil.getDouble(request, "experience");
			int noticePeriod=ParamUtil.getInteger(request, "noticePeriod");
			Double currentCTC=ParamUtil.getDouble(request, "currentctc");
			Double expextedCTC=ParamUtil.getDouble(request, "expectedctc");
			//Long projectRoleId=ParamUtil.getLong(request, param)
			Long empId=ParamUtil.getLong(request, "empId");
			Long userId=ParamUtil.getLong(request, "userId");
			Long fileEntryId=null;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String donaminName=themeDisplay.getPortalURL();
			String fileUrl=null;
			InputStream inputStream =null;
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			String fileName = uploadPortletRequest.getFileName("uploadedFile");
			File file = uploadPortletRequest.getFile("uploadedFile");
			String mimeType = uploadPortletRequest.getContentType("uploadedFile");
			long fileSize = uploadPortletRequest.getSize("uploadedFile");
		
		
		     try {
		    	 Map<Long, String> filemap =RecruitProcessLocalServiceUtil.getResumeFileUpload(fileName,file, userId, donaminName);
					
					Long tempFilid=0L;
					String tempFilePath=StringPool.BLANK;
					for (Map.Entry<Long,String> entry : filemap.entrySet()){
						System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
						tempFilid=entry.getKey();
						tempFilePath=entry.getValue();
					}
			    RecruitProcess recruitProcess = RecruitProcessLocalServiceUtil.getRecruitProcess(Long.valueOf(recruitProcessId));
				recruitProcess.setFirstName(firstName);
				recruitProcess.setLastName(lastName);
				Date tempDOB = (Date) formatter.parse(DOB);
				recruitProcess.setDOB(tempDOB);
				recruitProcess.setEmail(email);
				recruitProcess.setPhoneNumber(phoneNumber);
				recruitProcess.setEmployeeId(empId);
				recruitProcess.setExperience(experience);
				recruitProcess.setExpextedCTC(expextedCTC);
				recruitProcess.setSkillset(skillset);
				recruitProcess.setFileEntryId(tempFilid);
				recruitProcess.setFileUrl(tempFilePath);
				recruitProcess.setNoticePeriod(noticePeriod);
				recruitProcess.setCreateDate(new Date());
				RecruitProcessLocalServiceUtil.updateRecruitProcess(recruitProcess);
		     }catch(Exception ex){
		    	 ex.printStackTrace();
		     }
		
		
		response.sendRedirect("jspPage", "/META-INF/resources/expenseEntry.jsp");
		
		}
		
	}
	
	public void candidateDelete(ActionRequest request, ActionResponse response) throws IOException, PortalException{
		String recruitProcessId = ParamUtil.get(request, "recruitProcessId", "");

		try {

			if (null != recruitProcessId || !recruitProcessId.isEmpty()) {
				RecruitProcess recruitProcess = RecruitProcessLocalServiceUtil.deleteRecruitProcess(Long.valueOf(recruitProcessId));
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
		
		//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		boolean required=false;
		
		
		
		
		
		
		
		
		// boolean attachmentRequired=ParamUtil.getBoolean(request,
		// "attachmentRequired");
	//	long userId=themeDisplay.getUserId();
	   
			/*try {
				 if(!errorList.isEmpty()){
					   HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			           httpRequest.setAttribute("errorList", errorList);
			           SessionMessages.add(request, PortalUtil.getPortletId(request)+ SessionMessages. KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					   response.setRenderParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
					   
				   }else{
				// ExpenseEntryLocalServiceUtil.addExpEntry(userId, projectId, expenseCategoryId, fileTitle, description, entryDate, amount);
						long expenseId = CounterLocalServiceUtil.increment(ExpenseEntry.class.getName());
						
						User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
						
		
						if (file != null) {
							uploadDocument(request, response);
						}
						expEntry = ExpenseEntryLocalServiceUtil.addExpenseEntry(expEntry);
		
						long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
						ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
								.createExpenseEntryHistory(expenseHistoryId);
						expenseEntryHistory.setCompanyId(themeDisplay.getCompanyId());
						expenseEntryHistory.setExpenseId(expEntry.getExpenseId());
						expenseEntryHistory.setStatus(0);
						expenseEntryHistory.setAddeddate(new Date());
		
						expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);
						System.out.println("insertion of expense entry histry...");
						///expense proof files entry
						if (fileSize!=0) {
							Map<String, String> filemap =ExpenseEntryLocalServiceUtil.getResumeFileUpload(fileName,file, themeDisplay.getUserId(), donaminName);
							
							String tempFilenm="";
							String tempFilePath="";
							for (Map.Entry<String,String> entry : filemap.entrySet()){
								System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
								tempFilenm=entry.getKey();
								tempFilePath=entry.getValue();
							}
							long fileId=CounterLocalServiceUtil.increment(ExpProofFiles.class.getName());
							ExpProofFiles expProofFiles=ExpProofFilesLocalServiceUtil.createExpProofFiles(fileId);
							expProofFiles.setCompanyId(themeDisplay.getCompanyId());
							expProofFiles.setEmployeeId(Long.valueOf(empId));
							expProofFiles.setFileName(tempFilenm);
							//expProofFiles.setFileOrigName()
							expProofFiles.setFilePath(tempFilePath);
							expProofFiles.setProofName(proofName);
							expProofFiles.setExpenseId(expenseId);
							expProofFiles.setUploadDate(new Date());
							expProofFiles = ExpProofFilesLocalServiceUtil.addExpProofFiles(expProofFiles);
							System.out.println("insertion of expense entry proof..");
						}
						
						
						
					    
				   }	

			} catch (Exception ex) {
				ex.printStackTrace();
			}*/
		
		
	//}
		public void candidateSearch(ActionRequest request, ActionResponse response) throws IOException, PortalException{
			String name = ParamUtil.get(request, "Name", StringPool.BLANK);
			//String[] names = Name.split(" ");
			String skillSet = ParamUtil.get(request, "Skillset", StringPool.BLANK);
			String email = ParamUtil.get(request, "Email", StringPool.BLANK);
			double experience = ParamUtil.getDouble(request, "experience");
			List<RecruitProcess> tempCandidateList=new ArrayList<RecruitProcess>();
			if(name!=null && !name.isEmpty()){
				
				for(String str:name.split(" ")){
					System.out.println("str"+str);
					/*DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
	 				dynamicQuery.add(PropertyFactoryUtil.forName("firstName").like("%"+str+"%"));
	 				dynamicQuery.add(PropertyFactoryUtil.forName("lastName").like("%"+str+"%"));
	 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);*/
	 				
	 				/*DynamicQuery searchQuery = RecruitProcessLocalServiceUtil.dynamicQuery();

	 				Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
	 				disjunctionQuery.add(RestrictionsFactoryUtil.like("firstName", "%str%"));
	 				disjunctionQuery.add(RestrictionsFactoryUtil.like("lastName", "%str%"));
	 				searchQuery.add(disjunctionQuery);
	 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(searchQuery);*/
					
	 				DynamicQuery searchQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
	 				Criterion criterion = null;
	 				criterion = RestrictionsFactoryUtil.like("firstName",new StringBuilder("%").append(str).append("%").toString());
					criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.like("lastName",new StringBuilder("%").append(str).append("%").toString()));
					searchQuery.add(criterion);
					tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(searchQuery);
	 				/*DynamicQuery studentORCriteriaQuery = DynamicQueryFactoryUtil.forClass(
	 						Student.class, PortletClassLoaderUtil.getClassLoader());
	 						Criterion criterion8 = null;
	 						criterion8 = RestrictionsFactoryUtil.eq("firstName",new String("meera"));
	 						criterion8=RestrictionsFactoryUtil.or(criterion8,
	 						RestrictionsFactoryUtil.eq("studentGender",new Integer("1")));
	 						studentORCriteriaQuery.add(criterion8);
	 						List<Student> studentList9=StudentLocalServiceUtil.dynamicQuery(studentORCriteriaQuery);*/
				}
				
				/*if(names[0].toString()!=""){
				DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
 				dynamicQuery.add(PropertyFactoryUtil.forName("firstName").like("%"+names[0].toString()+"%"));
 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
				}
				if(names[1].toString()!=""){
					DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
	 				dynamicQuery.add(PropertyFactoryUtil.forName("lastName").like("%"+names[1].toString()+"%"));
	 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
				}
				if((names[0].toString()!="")&&(names[1].toString()!="")){
					DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
	 				dynamicQuery.add(PropertyFactoryUtil.forName("firstName").like("%"+names[0].toString()+"%"));
	 				dynamicQuery.add(PropertyFactoryUtil.forName("lastName").like("%"+names[1].toString()+"%"));
	 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
				}*/
				
			}
			if(email!=null && !email.isEmpty()){
				DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
 				dynamicQuery.add(PropertyFactoryUtil.forName("email").like("%"+email+"%"));
 				
 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
				
			}
			if(skillSet!=null && !skillSet.isEmpty()){
				//String[] skills = skillSet.split(" ");
				for(String str:skillSet.split(",")){
					DynamicQuery searchQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
	 				Criterion criterion = null;
	 				criterion = RestrictionsFactoryUtil.like("skillset",new StringBuilder("%").append(str).append("%").toString());
					//criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.like("lastName",new StringBuilder("%").append(str).append("%").toString()));
					searchQuery.add(criterion);
					tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(searchQuery);
					
				}
				
				
			}
			
			if(name!=null && !name.isEmpty() && email!=null && !email.isEmpty()){
				for(String str:name.split(" ")){
				DynamicQuery searchQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
 				Criterion criterion = null;
 				criterion = RestrictionsFactoryUtil.like("firstName",new StringBuilder("%").append(str).append("%").toString());
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.like("lastName",new StringBuilder("%").append(str).append("%").toString()));
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.like("email",new StringBuilder("%").append(email).append("%").toString()));
				searchQuery.add(criterion);
				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(searchQuery);
				}
				
			}
			
			if(name!=null && !name.isEmpty() && skillSet!=null && !skillSet.isEmpty()){
				for(String str:name.split(" ")){
				DynamicQuery searchQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
 				Criterion criterion = null;
 				criterion = RestrictionsFactoryUtil.like("firstName",new StringBuilder("%").append(str).append("%").toString());
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.like("lastName",new StringBuilder("%").append(str).append("%").toString()));
				criterion=RestrictionsFactoryUtil.or(criterion,RestrictionsFactoryUtil.like("skillset",new StringBuilder("%").append(skillSet).append("%").toString()));
				searchQuery.add(criterion);
				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(searchQuery);
				}
				
			}
			if(experience>0){
				DynamicQuery dynamicQuery = RecruitProcessLocalServiceUtil.dynamicQuery();
 				dynamicQuery.add(PropertyFactoryUtil.forName("experience").ge(experience));
 				
 				tempCandidateList = RecruitProcessLocalServiceUtil.dynamicQuery(dynamicQuery);
				
			}
			
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
	        httpRequest.setAttribute("searchList", tempCandidateList);
	        
	       // response.setRenderParameter("searchList", tempCandidateList.toString());
	        response.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
		}
}