package com.liferay.famocom.erpcloud.eval.portlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.eval.constants.EvaluationPortletKeys;
import com.liferay.famocom.erpcloud.model.Evaluation;
import com.liferay.famocom.erpcloud.service.EvaluationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
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
		"javax.portlet.display-name=Evaluation Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EvaluationPortletKeys.Evaluation,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EvaluationPortlet extends MVCPortlet {
	@ProcessAction(name = "evaluation")
	public void evaluation(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectEmployee = ParamUtil.getLong(actionRequest, "selectEmployee");
		String evalMessage = ParamUtil.getString(actionRequest, "evalMessage", StringPool.BLANK);
		String evalDate = ParamUtil.getString(actionRequest, "evalDate", StringPool.BLANK);
		int rating = ParamUtil.getInteger(actionRequest, "rating");
		System.out.println("rating..."+rating);
		Date tempEvalDate = new Date();
		ThemeDisplay td =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
		long userId = td.getUserId();
		try {
			tempEvalDate = new SimpleDateFormat("dd/MM/yyyy").parse(evalDate);
			long evaluationId = CounterLocalServiceUtil.increment(Evaluation.class.getName());
			Evaluation evaluation = EvaluationLocalServiceUtil.createEvaluation(evaluationId);
			if(rating==0){
				SessionErrors.add(actionRequest, "error");
			    SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			    actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage","/META-INF/resources/view.jsp");
			} else {
			evaluation.setEvalRating(rating);
			evaluation.setEmployeeId(selectEmployee);
			evaluation.setEvalMessage(evalMessage);
			evaluation.setEvalDate(tempEvalDate);
			evaluation.setEvaluatedBy(userId);
			EvaluationLocalServiceUtil.addEvaluation(evaluation);
			}
			//System.out.println("ELSE>>>"+error);
			//httpRequest.setAttribute("error", error);
			/*actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage","/META-INF/resources/evaluationForm.jsp");*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@ProcessAction(name = "updateEvaluation")
	public void updateEvaluation(ActionRequest actionRequest, ActionResponse actionResponse) {
		long evaluationId = ParamUtil.getLong(actionRequest, "evaluationId");
		long selectEmployee = ParamUtil.getLong(actionRequest, "selectEmployee");
		String evalMessage = ParamUtil.getString(actionRequest, "evalMessage", StringPool.BLANK);
		String evalDate = ParamUtil.getString(actionRequest, "evalDate", StringPool.BLANK);
		int rating = ParamUtil.getInteger(actionRequest, "rating");
		System.out.println("rating..."+rating);
		Date tempEvalDate = new Date();
		ThemeDisplay td =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
		long userId = td.getUserId();
		try {
			tempEvalDate = new SimpleDateFormat("dd/MM/yyyy").parse(evalDate);
			Evaluation evaluation = EvaluationLocalServiceUtil.getEvaluation(evaluationId);
			evaluation.setEmployeeId(selectEmployee);
			evaluation.setEvalMessage(evalMessage);
			evaluation.setEvalDate(tempEvalDate);
			evaluation.setEvalRating(rating);
			evaluation.setEvaluatedBy(userId);
			EvaluationLocalServiceUtil.updateEvaluation(evaluation);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			//System.out.println("ELSE>>>"+error);
			//httpRequest.setAttribute("error", error);
			/*actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage","/META-INF/resources/evaluationForm.jsp");*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@ProcessAction(name = "deleteEvaluation")
	public void deleteEvaluation(ActionRequest actionRequest, ActionResponse actionResponse) {
		long evaluationId = ParamUtil.getLong(actionRequest, "evaluationId");
		try {
			Evaluation evaluation = EvaluationLocalServiceUtil.getEvaluation(evaluationId);
			EvaluationLocalServiceUtil.deleteEvaluation(evaluation);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			//System.out.println("ELSE>>>"+error);
			//httpRequest.setAttribute("error", error);
			/*actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage","/META-INF/resources/evaluationForm.jsp");*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}