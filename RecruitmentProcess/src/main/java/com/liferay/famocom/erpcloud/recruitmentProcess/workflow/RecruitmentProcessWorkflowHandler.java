package com.liferay.famocom.erpcloud.recruitmentProcess.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.RecruitmentProcess;
import com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;


@Component(
property = {"model.class.name=com.liferay.famocom.erpcloud.model.RecruitmentProcess" },
service = WorkflowHandler.class
)

public class RecruitmentProcessWorkflowHandler extends BaseWorkflowHandler<RecruitmentProcess> {

	private RecruitmentProcessLocalService recruitmentProcessService;

	@Reference(unbind = "-")
	protected void setRecruitmentProcess(RecruitmentProcessLocalService recruitmentProcessService) {
		this.recruitmentProcessService = recruitmentProcessService;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return RecruitmentProcess.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		// TODO Auto-generated method stub
		return "RecruitmentProcess";
	}

	@Override
	public RecruitmentProcess updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException {
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long recruitmentProcessId = GetterUtil
				.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
		RecruitmentProcess recruitmentProcess = recruitmentProcessService.updateStatus(userId, recruitmentProcessId,
				status, serviceContext);

		return recruitmentProcess;
	}

}
