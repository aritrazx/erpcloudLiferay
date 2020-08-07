package com.liferay.famocom.erpcloud.interviewevaluation.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.interviewevaluation.constants.InterviewEvaluationPortletKeys;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.InterviewEvaluation;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=InterviewEvaluation Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + InterviewEvaluationPortletKeys.InterviewEvaluation,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InterviewEvaluationPortlet extends MVCPortlet {
	public void evaluationAdd(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long projectRole = ParamUtil.getLong(actionRequest, "projectRole");
		System.out.println("templateName" + projectRole);
		String evaluationName = ParamUtil.getString(actionRequest, "evaluation",StringPool.BLANK);
		System.out.println("emailFor" + evaluationName);
		try{
		long id = CounterLocalServiceUtil.increment(InterviewEvaluation.class.getName());
		InterviewEvaluation interviewEvaluation = InterviewEvaluationLocalServiceUtil.createInterviewEvaluation(id);
		interviewEvaluation.setRoleId(projectRole);
		interviewEvaluation.setEvaluationName(evaluationName);
		InterviewEvaluationLocalServiceUtil.addInterviewEvaluation(interviewEvaluation);
		actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
		}catch (Exception e) {
			
		}
		
	}
	
	public void evaluationEdit(ActionRequest actionRequest, ActionResponse actionResponse) {
		long evaluationId = ParamUtil.getLong(actionRequest,"evaluationId");
		System.out.println("evaluationId"+evaluationId);
		Long projectRole = ParamUtil.getLong(actionRequest, "projectRole");
		System.out.println("projectRole" + projectRole);
		String evaluationName = ParamUtil.getString(actionRequest, "evaluation",StringPool.BLANK);
		System.out.println("evaluationName" + evaluationName);
		try{
		InterviewEvaluation interviewEvaluation = InterviewEvaluationLocalServiceUtil.getInterviewEvaluation(evaluationId);
		interviewEvaluation.setRoleId(projectRole);
		interviewEvaluation.setEvaluationName(evaluationName);
		InterviewEvaluationLocalServiceUtil.updateInterviewEvaluation(interviewEvaluation);
		actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
		}catch (Exception e) {
			
		}
	}
	
	public void evaluationDelete(ActionRequest actionRequest, ActionResponse actionResponse) {
		long evaluationId = ParamUtil.getLong(actionRequest,"evaluationId");
		InterviewEvaluation interviewEvaluation = InterviewEvaluationLocalServiceUtil.createInterviewEvaluation(evaluationId);
		if (evaluationId != 0) {
			try {
				//emailDelete = EmailTemplateLocalServiceUtil.getEmailTemplate(id);
				InterviewEvaluationLocalServiceUtil.deleteInterviewEvaluation(interviewEvaluation);

			} catch (Exception e) {
			}
		}
	}
}