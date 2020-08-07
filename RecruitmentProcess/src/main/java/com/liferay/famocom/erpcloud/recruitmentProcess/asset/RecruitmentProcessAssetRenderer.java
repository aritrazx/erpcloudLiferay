package com.liferay.famocom.erpcloud.recruitmentProcess.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.famocom.erpcloud.model.CandidateApply;
import com.liferay.famocom.erpcloud.model.RecruitmentProcess;
import com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.task.web.internal.display.context.WorkflowTaskDisplayContext;


public class RecruitmentProcessAssetRenderer extends BaseJSPAssetRenderer<RecruitmentProcess> {

	private final RecruitmentProcess recruitmentProcess;
	private final ResourceBundleLoader resourceBundleLoader;
	public RecruitmentProcessAssetRenderer(RecruitmentProcess recruitmentProcess,ResourceBundleLoader resourceBundleLoader) {
	      this.recruitmentProcess = recruitmentProcess;
	      this.resourceBundleLoader = resourceBundleLoader;
	 }
	
	@Override
	public RecruitmentProcess getAssetObject() {
		// TODO Auto-generated method stub
		return recruitmentProcess;
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return recruitmentProcess.getGroupId();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return recruitmentProcess.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return recruitmentProcess.getUserUuid();
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return RecruitmentProcess.class.getName();
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return recruitmentProcess.getRecruitmentProcessId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		CandidateApply apply =null;
		String candidateName = StringPool.BLANK;
		try{
			if(Validator.isNotNull(recruitmentProcess.getApplyCandidateId())){
				apply= CandidateApplyLocalServiceUtil.getCandidateApply(recruitmentProcess.getApplyCandidateId());
				candidateName=apply.getFirstName()+" "+apply.getLastName();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "Interview schedule at:"+recruitmentProcess.getInterviewDate()+",time:-"+recruitmentProcess.getInterviewTime()+" candidate name: "+ candidateName;
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		CandidateApply apply =null;
		String candidateName = StringPool.BLANK;
		try{
			if(Validator.isNotNull(recruitmentProcess.getApplyCandidateId())){
				apply= CandidateApplyLocalServiceUtil.getCandidateApply(recruitmentProcess.getApplyCandidateId());
				candidateName=apply.getFirstName()+" "+apply.getLastName();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return candidateName;
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		// TODO Auto-generated method stub
		
		return "/view.jsp";
	}
	
	@Override
	 public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	     LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
	   try {
		   
		   
	     long plid = PortalUtil.getPlidFromPortletId(recruitmentProcess.getGroupId(), "InterviewProcessReview");
	    // long plid1 = PortalUtil.getPlidFromPortletId(recruitmentProcess.getGroupId(), "InterviewProcessReview");
	     
       //  System.out.println("plid1 "+plid1);
         System.out.println("plid "+plid);
	     PortletURL portletURL;
	     if (plid == LayoutConstants.DEFAULT_PLID) {
	       portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	       	"InterviewProcessReview", PortletRequest.RENDER_PHASE);
	     } else {
	       portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	       	"InterviewProcessReview", plid, PortletRequest.RENDER_PHASE);
	     }
	     WorkflowTaskDisplayContext workflowTaskDisplayContext = new WorkflowTaskDisplayContext(liferayPortletRequest, liferayPortletResponse);
	     String state= workflowTaskDisplayContext.getState(workflowTaskDisplayContext.getWorkflowTask());
	     System.out.println("---------------------:workflowTaskDisplayContext:--------------"+workflowTaskDisplayContext);
	     System.out.println("---------------------:state:--------------"+state);
	     if(state.equalsIgnoreCase("interviewer")){
	     portletURL.setParameter("jspPage", "/interview.jsp");
		 portletURL.setParameter("recruitmentProcessId", String.valueOf(recruitmentProcess.getRecruitmentProcessId()));
	     portletURL.setParameter("jobPostId", String.valueOf(recruitmentProcess.getJobPostId()));
	     portletURL.setParameter("applyCandidateId", String.valueOf(recruitmentProcess.getApplyCandidateId()));
	     }
	     if(state.equalsIgnoreCase("1stReviewer")){
	    	 portletURL.setParameter("jspPage", "/selectedCandidateList.jsp");
	     }
	     
	    // portletURL.setParameter("mvcRenderCommandName", "/interview-review/view");
	     portletURL.setParameter("recruitmentProcessId", String.valueOf(recruitmentProcess.getRecruitmentProcessId()));

	     String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

	     portletURL.setParameter("redirect", currentUrl);
	     System.out.println("portletURL  "+portletURL.toString());

	     return portletURL.toString();


	   } catch (PortalException e) {

	   } catch (SystemException e) {
	   }

	   return noSuchEntryRedirect;
	 }
		
}
