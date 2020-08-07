package com.liferay.famocom.erpcloud.candidateReview.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.candidateReview.constants.CandidateReviewPortletKeys;
import com.liferay.famocom.erpcloud.model.CandidateReview;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.service.CandidateReviewLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.apache.log4j.Logger;
import org.osgi.service.component.annotations.Component;

/**
 * @author FAMOCOM-AJEET
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CandidateReview Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CandidateReviewPortletKeys.CandidateReview,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CandidateReviewPortlet extends MVCPortlet {
	private static Logger _log = Logger.getLogger(CandidateReviewPortlet.class);
	
	@ProcessAction(name="addCandidateReview")
	public void addCandidateReview(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		_log.info("################# add candidate review ############# ");
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 String remarks = ParamUtil.getString(actionRequest, "remark",StringPool.BLANK);
		 String evaluationIds=ParamUtil.getString(actionRequest, "evaluationIds");
		 //long evaluationId = ParamUtil.getLong(actionRequest, "evaluationId");
		 long recruitProcessId = ParamUtil.getLong(actionRequest, "recruitProcessId");
		 _log.info("#################" +evaluationIds+ "############ "+recruitProcessId+" ###### "+remarks+" ######## ");
		 
		String[] evaluationIdss= evaluationIds.split(",");
		List<String> list = Arrays.asList(evaluationIdss);
		
		 for(String str:list){
			 System.out.println("str....."+str);
			 String name="name_"+str;
			 String scroing = ParamUtil.getString(actionRequest, name);
			 System.out.println("scroing....."+scroing);
			 long id =Long.valueOf(str);
			 long candidateReviewid = CounterLocalServiceUtil.increment(CandidateReview.class.getName());
			 CandidateReview  candidateReview = CandidateReviewLocalServiceUtil.createCandidateReview(candidateReviewid);
			 candidateReview.setScroring(scroing);
		     candidateReview.setEvaluationId(id);
			 candidateReview.setRecruitProcessId(recruitProcessId);
			 CandidateReviewLocalServiceUtil.addCandidateReview(candidateReview);
		 }
		
		 if(Validator.isNotNull(recruitProcessId)){
			 RecruitProcess process = RecruitProcessLocalServiceUtil.getRecruitProcess(recruitProcessId);
			 process.setInterviewerRemarks(remarks);
			 process.setStatus(3);
			 RecruitProcessLocalServiceUtil.updateRecruitProcess(process);
		 }
		 
		 
		 actionResponse.setRenderParameter("jspPage","/view.jsp"); 
	}
	
}