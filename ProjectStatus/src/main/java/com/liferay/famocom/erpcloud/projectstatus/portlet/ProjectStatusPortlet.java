package com.liferay.famocom.erpcloud.projectstatus.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.ProjectStatus;
import com.liferay.famocom.erpcloud.projectstatus.constants.ProjectStatusPortletKeys;
import com.liferay.famocom.erpcloud.service.ProjectStatusLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProjectStatus Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProjectStatusPortletKeys.ProjectStatus,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectStatusPortlet extends MVCPortlet {
	@ProcessAction(name = "projectStatus")
	public void projectStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<String> error = new ArrayList<String>();
		String statusName = ParamUtil.getString(actionRequest, "statusName", StringPool.BLANK);
		String statusColour = ParamUtil.getString(actionRequest, "statusColour", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = ProjectStatusLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("statusName").eq(statusName));
		List<ProjectStatus> list = ProjectStatusLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("list" + list);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Status Name already exist");
		}
		if (error.size() == 0) {
			ProjectStatus obj = null;

			try {
				long projectId = CounterLocalServiceUtil.increment(ProjectStatus.class.getName());
				// System.out.println("primary key....."+projectId);
				ProjectStatus projStat = ProjectStatusLocalServiceUtil.createProjectStatus(projectId);
				projStat.setStatusName(statusName);
				projStat.setCompanyId(20116);
				projStat.setAddedDate(date);
				projStat.setStatusColor(statusColour);

				obj = ProjectStatusLocalServiceUtil.addProjectStatus(projStat);
				if (obj != null) {
					SessionMessages.add(actionRequest, "add-success");
					//actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
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
	/*
	 * try { SessionErrors.add(actionRequest, "error");
	 * SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest)+
	 * SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	 * 
	 * HttpServletRequest httpRequest =
	 * PortalUtil.getHttpServletRequest(actionRequest);
	 * 
	 * httpRequest.setAttribute("error", error);
	 * actionResponse.setWindowState(WindowState.NORMAL);
	 * actionResponse.setRenderParameter("jspPage",
	 * "/META-INF/resources/view.jsp");
	 * 
	 * } catch (WindowStateException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 */

	@ProcessAction(name = "updateProjectStatus")
	public void updateProjectStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		List<String> error = new ArrayList<String>();
		String statusName = ParamUtil.getString(actionRequest, "statusName", StringPool.BLANK);
		String statusColour = ParamUtil.getString(actionRequest, "statusColour", StringPool.BLANK);
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		long projectStatusId = ParamUtil.getLong(actionRequest, "projectStatusId");
		System.out.println("primary key in edit....." + projectStatusId);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = ProjectStatusLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("statusName").eq(statusName));
		List<ProjectStatus> list = ProjectStatusLocalServiceUtil.dynamicQuery(dynamicQuery);
		boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			for (ProjectStatus oh : list) {
				if (oh.getProjectStatusId() != projectStatusId) {
					bFlg = true;
				}
			}
		}
		if (bFlg) {
			error.add("Given Status Name already exist");
		}
		if (error.size() == 0) {
			ProjectStatus obj = null;

			try {
				ProjectStatus projStat = ProjectStatusLocalServiceUtil.getProjectStatus(projectStatusId);
				projStat.setStatusName(statusName);
				projStat.setAddedDate(date);
				projStat.setStatusColor(statusColour);
				obj = ProjectStatusLocalServiceUtil.updateProjectStatus(projStat);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (obj != null) {
				SessionMessages.add(actionRequest, "update-success");
				//actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
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

	@ProcessAction(name = "deleteProjectStatus")
	public void deleteProjectStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		long projectStatusId = ParamUtil.getLong(actionRequest, "projectStatusId1");

		System.out.println("primary key in delete....." + projectStatusId);
		try {
			System.out.println("primary key in delete1....." + projectStatusId);
			ProjectStatus projStat = ProjectStatusLocalServiceUtil.getProjectStatus(projectStatusId);
			ProjectStatusLocalServiceUtil.deleteProjectStatus(projStat);
			SessionMessages.add(actionRequest, "delete-success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}