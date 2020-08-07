package com.liferay.famocom.erpcloud.evallist.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.famocom.erpcloud.evallist.constants.EvaluationListPortletKeys;
import com.liferay.famocom.erpcloud.model.Evaluation;
import com.liferay.famocom.erpcloud.service.EvaluationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author hussh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EvaluationList Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EvaluationListPortletKeys.EvaluationList,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EvaluationListPortlet extends MVCPortlet {
	@ProcessAction(name = "deleteEvaluation")
	public void deleteEvaluation(ActionRequest actionRequest, ActionResponse actionResponse) {
		long evaluationId = ParamUtil.getLong(actionRequest, "evaluationId");
		try {
			Evaluation evaluation = EvaluationLocalServiceUtil.getEvaluation(evaluationId);
			EvaluationLocalServiceUtil.deleteEvaluation(evaluation);
			//HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
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