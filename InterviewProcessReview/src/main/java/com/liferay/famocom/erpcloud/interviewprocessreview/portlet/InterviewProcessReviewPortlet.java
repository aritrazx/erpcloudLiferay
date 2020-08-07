package com.liferay.famocom.erpcloud.interviewprocessreview.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.osgi.service.component.annotations.Component;

import com.itextpdf.text.log.SysoCounter;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.employeedetails.constants.EmployeeDetailsPortletKeys;
import com.liferay.famocom.erpcloud.employeedetails.util.PayStructureUtil;
import com.liferay.famocom.erpcloud.interviewprocessreview.constants.InterviewProcessReviewPortletKeys;
import com.liferay.famocom.erpcloud.interviewprocessreview.util.HtmlToPdf;
import com.liferay.famocom.erpcloud.model.CandidateEvaluation;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.RecruitmentProcess;
import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructure;
import com.liferay.famocom.erpcloud.model.SelectedCandidatePayStructureMaster;
import com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureMasterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=InterviewProcessReview Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + InterviewProcessReviewPortletKeys.InterviewProcessReview,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InterviewProcessReviewPortlet extends MVCPortlet {
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("redirectJspppppp:---");
		String redirectJsp = ParamUtil.getString(renderRequest, "jspPage");
		System.out.println("redirectJsp:---"+redirectJsp);
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = RecruitmentProcess.class.getName();
		
		if (Validator.isNull(redirectJsp)) {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			List<WorkflowTask> workflowTasks = null;
			
			try {
				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				
				workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(themeDisplay.getCompanyId(), themeDisplay.getUserId(), false, -1, -1, null);
				
				List<RecruitmentProcess> processesList = new ArrayList<RecruitmentProcess>();
				for(WorkflowTask workflowTask: workflowTasks){
					workflowContext = getWorkflowContext(themeDisplay, workflowTask);
					String requestType = (String) workflowContext.get("entryClassName");
					String processId = (String) workflowContext.get("entryClassPK");
					if (classNm.equalsIgnoreCase(requestType)) {
						long recruitmentProcessId = Long.parseLong(processId);
						RecruitmentProcess recruitmentProcess = RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentProcessId);
						processesList.add(recruitmentProcess);
					}
					
				}
				
				System.out.println("Interview List=>"+processesList.size());
				renderRequest.setAttribute("processesList", processesList);		
				
				List<WorkflowTask> workflowTasksForMe = null;
				
				workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
						themeDisplay.getUserId(), false, -1, -1, null);
				List<RecruitmentProcess> processesToMeList = new ArrayList<RecruitmentProcess>();
				
				for (WorkflowTask workflowTask : workflowTasksForMe) {
					workflowContext = getWorkflowContext(themeDisplay, workflowTask);
					String requestType = (String) workflowContext.get("entryClassName");
					String processId = (String) workflowContext.get("entryClassPK");
					if (classNm.equalsIgnoreCase(requestType)) {
						long recruitmentProcessId = Long.parseLong(processId);
						RecruitmentProcess recruitmentProcess = RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentProcessId);
						processesToMeList.add(recruitmentProcess);
					}
					System.out.println("requestType..............." + requestType);
				}
				renderRequest.setAttribute("processesToMeList", processesToMeList);
				System.out.println("Interview List ME=>"+processesToMeList.size());
			} catch (Exception e) {
				
			}
			}
		super.render(renderRequest, renderResponse);
	}
	
	private static Map<String, Serializable> getWorkflowContext(ThemeDisplay themeDisplay, WorkflowTask workflowTask)
			throws WorkflowException {
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(),
				workflowTask.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		return workflowContext;
	}
	
	public void actionAssignToMe(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<WorkflowTask> workflowTasks = null;
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = RecruitmentProcess.class.getName();
		String comment = ParamUtil.getString(actionRequest, "comment",StringPool.BLANK);
		long recruitmentProcessId = ParamUtil.getLong(actionRequest, "recruitmentProcessId");
		
		System.out.println("actionAssignToMe recruitmentProcessId..............." + recruitmentProcessId);
		
		long workflowTaskIdStr=0;
		List<WorkflowTask> workflowTasksForMe = null;
		workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(themeDisplay.getCompanyId(),
				themeDisplay.getUserId(), false, -1, -1, null);
		System.out.println("workflowTasksForMe..............." + workflowTasksForMe.size());
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			String requestType = (String) workflowContext.get("entryClassName");
			String processId = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long recruitmentId = Long.parseLong(processId);
				if(recruitmentId==recruitmentProcessId){
					workflowTaskIdStr = workflowTask.getWorkflowTaskId();
				}
				
				//empListMe.add(employeeObj);
			}
			System.out.println("recruitmentId..............." + processId);
		}
		
		
		
		assignTo(comment,workflowTaskIdStr,themeDisplay.getUserId(),themeDisplay);
		
		
	}
	
	private void assignTo(String comment, long workflowTaskId, long assignUserId,
			ThemeDisplay themeDisplay) {
		WorkflowTask workflowTask;
		try {
			Date dueDate = new Date();
			//long workflowTaskId = Long.parseLong(workflowTaskIdStr);
			//long assignUserId = Long.parseLong(assignUserid);
			workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), workflowTaskId);
			Map<String, Serializable> workflowContext;
			workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			workflowTask = WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), workflowTaskId, assignUserId, comment, dueDate, workflowContext);
			System.out.println("final workflowTask " + workflowTask);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem");
		}
	}
	
	
	/**
	 * get candidate interview result from the interviewer
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void interviewResult(ActionRequest actionRequest, ActionResponse actionResponse) {
		long jobPostId = ParamUtil.getLong(actionRequest, "jobPostId");
		long applyCandidateId = ParamUtil.getLong(actionRequest, "applyCandidateId");
		long interviewerId = ParamUtil.getLong(actionRequest, "interviewerId");
		long recruitmentProcessId = ParamUtil.getLong(actionRequest,"recruitmentProcessId");
		int sumbitVal =ParamUtil.getInteger(actionRequest,"sumbitVal");
		System.out.println("approve---"+sumbitVal);
		
		
		//String interviewerRemark = ParamUtil.getString(actionRequest,"interviewerRemark",StringPool.BLANK);
		//long postEvaluationId = ParamUtil.getLong(actionRequest, "postEvaluationId");
		int rating = ParamUtil.getInteger(actionRequest,"rating");
		String interviewerRemark = ParamUtil.getString(actionRequest,"interviewerRemark",StringPool.BLANK);
		System.out.println("jobPostId---"+jobPostId+"  applyCandidateId----"+applyCandidateId+"  interviewerId----"+interviewerId);
		System.out.println("rating----"+rating+"  interviewerRemark-----"+interviewerRemark);
		String[] postEvaluationIdArr = ParamUtil.getParameterValues(actionRequest, "postEvaluationId");
		String postEvaluationIdLists = ParamUtil.getString(actionRequest, "postEvaluationId", StringPool.BLANK);
		String postEvaluationIdListsArr[] = postEvaluationIdLists.split(",");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		for (int i = 0; i <= postEvaluationIdArr.length - 1; i++) {
			
			String postEvaluationId =  postEvaluationIdListsArr[i];
			String namePostEvaluationId = "rating_" + postEvaluationIdListsArr[i];
			System.out.println("namePerformanceCom : "+postEvaluationId);
			int interviewerRating = ParamUtil.getInteger(actionRequest, namePostEvaluationId);
			System.out.println("ratinIdEmp : "+interviewerRating);
			
			long candidateEvaluationId = CounterLocalServiceUtil.increment(CandidateEvaluation.class.getName());
			CandidateEvaluation candidateEvaluation = CandidateEvaluationLocalServiceUtil.createCandidateEvaluation(candidateEvaluationId);
			
			candidateEvaluation.setJobPostId(jobPostId);
			candidateEvaluation.setApplyCandidateId(applyCandidateId);
			candidateEvaluation.setInterviewerId(interviewerId);
			candidateEvaluation.setPostEvaluationId(Long.parseLong(postEvaluationId));
			candidateEvaluation.setInterviewerRating(interviewerRating);
			candidateEvaluation.setInterviewerRemarks(interviewerRemark);
			candidateEvaluation.setRecruitmentProcessId(recruitmentProcessId);
			
			CandidateEvaluationLocalServiceUtil.addCandidateEvaluation(candidateEvaluation);
			
		}
		if(sumbitVal==0){
			
			approveInterview(recruitmentProcessId,interviewerRemark,themeDisplay);
		
		}else if(sumbitVal==1){
			if(Validator.isNotNull(recruitmentProcessId)){
				try {
					RecruitmentProcess process =RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentProcessId);
					if(process!=null){
						//process.setIsSelected(2);
					}
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			rejectInterview(recruitmentProcessId,interviewerRemark,themeDisplay);
			
		}
	}
	
	/**
	 * for approve the interview 
	 * 
	 * @param recruitmentProcessId
	 * @param interviewerRemark
	 * @param themeDisplay
	 */
	public void approveInterview(long recruitmentProcessId, String interviewerRemark, ThemeDisplay themeDisplay) {
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = RecruitmentProcess.class.getName();
		long WorkflowTaskId = 0;
		System.out.println("recruitmentProcessId:---"+recruitmentProcessId);

		/// ======================================For
		/// TaskID===================================================
		List<WorkflowTask> workflowTasksForMe = null;

		try {
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
		} catch (WorkflowException e1) {
			e1.printStackTrace();
		}
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			try {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
				
			} catch (WorkflowException e) {
				e.printStackTrace();
			}
			// WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId,
			// workflowTaskId);
			String requestType = (String) workflowContext.get("entryClassName");
			String getRecruitmentProcessId = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long recruitmentProcessIdreview = Long.parseLong(getRecruitmentProcessId);
				if (recruitmentProcessIdreview == recruitmentProcessId) {
					WorkflowTaskId = workflowTask.getWorkflowTaskId();

				}

			}

		}
		try {
			
			if(Validator.isNotNull(recruitmentProcessId)){
				try {
					RecruitmentProcess process =RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentProcessId);
					System.out.println("  process----"+process);
					if(process!=null){
						System.out.println("------IF------");
						process.setStatus(WorkflowConstants.STATUS_APPROVED);
					}
					RecruitmentProcessLocalServiceUtil.updateRecruitmentProcess(process);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("InterviewProcess");
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					WorkflowTaskId, "approve", interviewerRemark, workflowContext);
			
			System.out.println("InterviewProcess111111"+recruitmentProcessId);
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * for reject the interview
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void rejectInterview(long recruitmentProcessId, String interviewerRemark, ThemeDisplay themeDisplay){
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = RecruitmentProcess.class.getName();
		long WorkflowTaskId =0;
		
		///======================================For TaskID===================================================
		List<WorkflowTask> workflowTasksForMe = null;
		
		try {
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
		} catch (WorkflowException e1) {
			e1.printStackTrace();
		}
		//int i=1;
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			try {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
				
				
			} catch (WorkflowException e) {
				e.printStackTrace();
			}
			//WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, workflowTaskId);
			String requestType = (String) workflowContext.get("entryClassName");
			String getRecruitmentProcessId = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long recruitmentProcessIdreview = Long.parseLong(getRecruitmentProcessId);
				if(recruitmentProcessIdreview==recruitmentProcessId){
					WorkflowTaskId = workflowTask.getWorkflowTaskId();
					System.out.println("WorkflowTaskId..............." + WorkflowTaskId);
					System.out.println("reject");
				}
			}
		}
	//==========================================================================================================	
		try {
			
			if(Validator.isNotNull(recruitmentProcessId)){
				try {
					RecruitmentProcess process =RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentProcessId);
					if(process!=null){
						process.setStatus(WorkflowConstants.STATUS_DENIED);
					}
					RecruitmentProcessLocalServiceUtil.updateRecruitmentProcess(process);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					WorkflowTaskId, "reject",interviewerRemark, workflowContext);
		
		} catch (WorkflowException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/*
	 * for PayStructure calculation
	 * 
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		if (cmd.trim().equalsIgnoreCase("calculatePaycomponent")) {
			String amount = ParamUtil.getString(request,"amount",StringPool.BLANK);
			JSONArray jsonArray =PayStructureUtil.getPayComponentAmountByTotalPay(amount);
			PrintWriter writer = response.getWriter();
			writer.print(jsonArray);
			//System.out.println("jsonArray:---"+jsonArray+"writer"+writer);
		}
		
		if (cmd.equals("generateOfferLetter")) {
			String recruitmentProcessId = ParamUtil.getString(request,"recruitmentProcessId",StringPool.BLANK);
			String date = ParamUtil.getString(request,"date",StringPool.BLANK);
			String candidateFullName = ParamUtil.getString(request,"candidateFullName",StringPool.BLANK);
			String title = ParamUtil.getString(request,"title",StringPool.BLANK);
			String description = ParamUtil.getString(request,"description",StringPool.BLANK);
			System.out.println(" recruitmentProcessId:-- "+recruitmentProcessId+ "  date:--- "+date+"  candidateFullName  "+candidateFullName+" title  "+title);
			Map<String, String> offerLetterValue = new HashMap<String, String>();
			offerLetterValue.put("date", date);
			offerLetterValue.put("fullName", candidateFullName);
			offerLetterValue.put("candidateName", candidateFullName);
			offerLetterValue.put("title", title);
			offerLetterValue.put("description",description);
			
			String filename = candidateFullName+"-"+new Date().getTime();
			
			String templateFor ="offerLetter";
			String templateBody =StringPool.BLANK;
			try{
				EmailTemplate emailTemplate =EmailTemplateLocalServiceUtil.findByemailFor(templateFor);
				templateBody = emailTemplate.getTemplateBody();
			}catch (Exception e) {
			}
			
			String filePath = "/"+filename+".pdf";
			HtmlToPdf  htmlToPdf = new HtmlToPdf();
			htmlToPdf.createPDFfromHTML(offerLetterValue, templateBody, filePath,response);
			
		}
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException 
	 * @throws NumberFormatException 
	 * @throws WindowStateException 
	 */
	@ProcessAction(name = "addSelectedCandidatePayStructure")
	public void addSelectedCandidatePayStructure(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException, WindowStateException {
		String componenetIdList = ParamUtil.getString(actionRequest, "componenetIdList", StringPool.BLANK);
		String recruitmentProcessId = ParamUtil.getString(actionRequest, "recruitmentProcessId",StringPool.BLANK);
		String amount = ParamUtil.getString(actionRequest,"amount",StringPool.BLANK);
		String bonus = ParamUtil.getString(actionRequest,"bonus",StringPool.BLANK);
		String dateOfJoining = ParamUtil.getString(actionRequest, "dateOfJoining",StringPool.BLANK);
		int yearBond = ParamUtil.getInteger(actionRequest, "yearBond",0);
		int monthBond = ParamUtil.getInteger(actionRequest, "monthBond",0);
		
		String[] componenetIds= componenetIdList.split(",");
		List<String> list = Arrays.asList(componenetIds); 
		
		System.out.println("componenetIdList:---"+componenetIdList+"recruitmentProcessId:---"+recruitmentProcessId);
		
		double payPerMonth = 0;
	
		
		/*
		 * change the status for existing selected candidate
		 */
		try{
			 if(Validator.isNotNull(recruitmentProcessId)){
			 List<SelectedCandidatePayStructure> candidatePayStructures = SelectedCandidatePayStructureLocalServiceUtil.findByrecruitmentProcessIdAndPayStatus(Long.parseLong(recruitmentProcessId), WorkflowConstants.STATUS_APPROVED);
			 System.out.println("candidatePayStructures:---"+candidatePayStructures);
			 	if(candidatePayStructures!=null && candidatePayStructures.size()>0){
			 		for(SelectedCandidatePayStructure payStructure :candidatePayStructures){
			 			payStructure.setPayStatus(WorkflowConstants.STATUS_INACTIVE);
			 			SelectedCandidatePayStructureLocalServiceUtil.updateSelectedCandidatePayStructure(payStructure);
			 		}
			 	}
			 }
		 }catch (Exception e) {
			 
		}
		
		/*
		 * store total amount for selected candidate and change the status
		 */
		
		try{
			
			
			 Date joiningDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfJoining);
			 String companyBond =yearBond+"."+monthBond;
			 long candidatePayStructureMasterId = CounterLocalServiceUtil.increment(SelectedCandidatePayStructureMaster.class.getName());
			 SelectedCandidatePayStructureMaster candidatePayStructureMaster = SelectedCandidatePayStructureMasterLocalServiceUtil.createSelectedCandidatePayStructureMaster(candidatePayStructureMasterId);
			 candidatePayStructureMaster.setTotalAmount(Double.parseDouble(amount));
			 candidatePayStructureMaster.setTotalBonus(Double.parseDouble(bonus));
			 candidatePayStructureMaster.setPayMasterStatus(WorkflowConstants.STATUS_APPROVED);
			 candidatePayStructureMaster.setJoiningDate(joiningDate);
			 candidatePayStructureMaster.setCandidateBond(companyBond);
			
			 
			 if(Validator.isNotNull(recruitmentProcessId)){
				 List<SelectedCandidatePayStructureMaster> candidatePayStructureMasters = SelectedCandidatePayStructureMasterLocalServiceUtil.findByrecruitmentProcessIdAndPayMasterStatus(Long.valueOf(recruitmentProcessId), WorkflowConstants.STATUS_APPROVED);
				 for(SelectedCandidatePayStructureMaster master : candidatePayStructureMasters){
					 master.setPayMasterStatus(WorkflowConstants.STATUS_INACTIVE);
					 SelectedCandidatePayStructureMasterLocalServiceUtil.updateSelectedCandidatePayStructureMaster(master);
				 }
				 candidatePayStructureMaster.setRecruitmentProcessId(Long.parseLong(recruitmentProcessId));
			 }
			 SelectedCandidatePayStructureMasterLocalServiceUtil.addSelectedCandidatePayStructureMaster(candidatePayStructureMaster);
			
		}catch(Exception e){
			
		}
		
		SelectedCandidatePayStructure selectedCandidate = null;
		for(String str:list){
			 String component="compo_"+str;
			 String payAmount = ParamUtil.getString(actionRequest, component);
			 PayComponent pCom = null; 
			 if(Validator.isNotNull(str)){
				 pCom = PayComponentLocalServiceUtil.getPayComponent(Long.valueOf(str));	 
			 }
			 if(Validator.isNotNull(pCom)){		
				 if(EmployeeDetailsPortletKeys.Earning.equalsIgnoreCase(pCom.getPayType())){
					 payPerMonth += Double.valueOf(payAmount);
				 }				
			 }
			 
			 long candidatePayStructureId = CounterLocalServiceUtil.increment(SelectedCandidatePayStructure.class.getName());
			
			 SelectedCandidatePayStructure candidatePayStructure = SelectedCandidatePayStructureLocalServiceUtil.createSelectedCandidatePayStructure(candidatePayStructureId);
			 
			 if(Validator.isNotNull(payAmount)){
				 candidatePayStructure.setComponentValue(Double.valueOf(payAmount));
			 }
			 if(Validator.isNotNull(str)){
				 candidatePayStructure.setPayComponentId(Long.valueOf(str));
			 }
			 if(Validator.isNotNull(recruitmentProcessId)){
				 candidatePayStructure.setRecruitmentProcessId(Long.valueOf(recruitmentProcessId));
			 }
			 
			 candidatePayStructure.setPayStatus(WorkflowConstants.STATUS_APPROVED); 
			
			 
			 selectedCandidate = SelectedCandidatePayStructureLocalServiceUtil.addSelectedCandidatePayStructure(candidatePayStructure);
		}
		/*if (Validator.isNotNull(employeeId)) {

			Employee employee = EmployeeLocalServiceUtil.getEmployee(Long.valueOf(employeeId));
			if(Validator.isNotNull(totalPay)){
				employee.setPayPerMonth(Double.valueOf(totalPay));
			}
			EmployeeLocalServiceUtil.updateEmployee(employee);
		}*/
		actionRequest.setAttribute("recruitmentProcessId", String.valueOf(selectedCandidate.getRecruitmentProcessId()));
		actionResponse.setWindowState(WindowState.NORMAL);
		actionResponse.setRenderParameter("jspPage", "/viewOfferLetter.jsp");
	}
	
	
}