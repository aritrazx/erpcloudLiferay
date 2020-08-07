package com.liferay.famocom.erpcloud.projecttask.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.ProjectTask;
import com.liferay.famocom.erpcloud.projecttask.constants.ProjectTaskPortletKeys;
import com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProjectTask Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProjectTaskPortletKeys.ProjectTask,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectTaskPortlet extends MVCPortlet {

	public void projectTask(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectProject =ParamUtil.getLong(actionRequest, "selectProject");
		List<String> error = new ArrayList<String>();
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(selectProject));
		dynamicQuery.add(PropertyFactoryUtil.forName("taskName").eq(taskName));
		List<ProjectTask> list = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Task Name already exist");
		}
		if (error.size() == 0) {
			ProjectTask obj = null;
		try {
			long projectTaskId=CounterLocalServiceUtil.increment(ProjectTask.class.getName());
			ProjectTask projTask=ProjectTaskLocalServiceUtil.createProjectTask(projectTaskId);
			projTask.setProjectId(selectProject);
			projTask.setTaskName(taskName);
			projTask.setAddedDate(date);
			
			obj = ProjectTaskLocalServiceUtil.addProjectTask(projTask);
			
			if (obj != null) {
				SessionMessages.add(actionRequest, "add-success");
			} else {
				SessionErrors.add(actionRequest, "add-error");
				/*
				 * SessionMessages.add(actionRequest,
				 * PortalUtil.getPortletId(actionRequest)+ SessionMessages.
				 * KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				 */
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		} else {
			try {
				SessionErrors.add(actionRequest, "error");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
				// System.out.println("ELSE>>>"+error);
				httpRequest.setAttribute("error", error);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			} catch (WindowStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void updateProjectTask(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectProject =ParamUtil.getLong(actionRequest, "selectProject");
		List<String> error = new ArrayList<String>();
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		long projectTaskId = ParamUtil.getLong(actionRequest, "projectTaskId");
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(selectProject));
		dynamicQuery.add(PropertyFactoryUtil.forName("taskName").eq(taskName));
		List<ProjectTask> list = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
		boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			for (ProjectTask oh : list) {
				if (oh.getProjectTaskId() != projectTaskId) {
					bFlg = true;
				}
			}
		}
		if (bFlg) {
			error.add("Given Task Name already exist");
		}
		if (error.size() == 0) {
			ProjectTask obj = null;
		try {
			ProjectTask projTask=ProjectTaskLocalServiceUtil.getProjectTask(projectTaskId);
			projTask.setAddedDate(date);
			projTask.setProjectId(selectProject);
			projTask.setTaskName(taskName);
			projTask.setAddedDate(date);
			
			obj=ProjectTaskLocalServiceUtil.updateProjectTask(projTask);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (obj != null) {
			SessionMessages.add(actionRequest, "update-success");
		} else {
			SessionErrors.add(actionRequest, "update-error");
			// SessionMessages.add(actionRequest,
			// PortalUtil.getPortletId(actionRequest)+ SessionMessages.
			// KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
	} else {
		SessionErrors.add(actionRequest, "error");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
		httpRequest.setAttribute("errorList", error);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		actionResponse.setRenderParameter("backUrl", backUrl);
		actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
	}
	}
	public void deleteProjectTask(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectProject =ParamUtil.getLong(actionRequest, "selectProject");
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		long projectTaskId = ParamUtil.getLong(actionRequest, "projectTaskId1");
		try {
			ProjectTask projTask=ProjectTaskLocalServiceUtil.getProjectTask(projectTaskId);
			ProjectTaskLocalServiceUtil.deleteProjectTask(projTask);
			SessionMessages.add(actionRequest, "delete-success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}