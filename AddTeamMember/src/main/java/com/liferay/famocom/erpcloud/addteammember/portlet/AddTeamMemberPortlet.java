package com.liferay.famocom.erpcloud.addteammember.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.addteammember.constants.AddTeamMemberPortletKeys;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil;
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
		"javax.portlet.display-name=AddTeamMember Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AddTeamMemberPortletKeys.AddTeamMember,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AddTeamMemberPortlet extends MVCPortlet {

	public void addTeamMember(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<String> error = new ArrayList<String>();
		long selectEmployee = ParamUtil.getLong(actionRequest, "selectEmployee");
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long selectRole = ParamUtil.getLong(actionRequest, "selectRole");
		boolean checkForManager = ParamUtil.getBoolean(actionRequest, "checkForManager");
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(selectEmployee));
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(selectProject));
		List<AddTeamMember> list = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Project Name already exist");
		}
		if (error.size() == 0) {
			AddTeamMember obj = null;

			try {
				long projectTeamsId = CounterLocalServiceUtil.increment(AddTeamMember.class.getName());
				AddTeamMember atm = AddTeamMemberLocalServiceUtil.createAddTeamMember(projectTeamsId);
				atm.setAddedDate(date);
				atm.setEmployeeId(selectEmployee);
				atm.setProjectId(selectProject);
				atm.setRoleId(selectRole);
				atm.setIsProjectManager(checkForManager);

				obj = AddTeamMemberLocalServiceUtil.addAddTeamMember(atm);
				/*
				 * HttpServletRequest httpRequest =
				 * PortalUtil.getHttpServletRequest(actionRequest);
				 * httpRequest.setAttribute("project_teams_id",
				 * String.valueOf(project_teams_id));
				 * actionResponse.setRenderParameter("jspPage",
				 * "/META-INF/resources/view.jsp");
				 */
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

	public void updateTeamMember(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<String> error = new ArrayList<String>();
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		long selectEmployee = ParamUtil.getLong(actionRequest, "selectEmployee");
		long projectTeamsId = ParamUtil.getLong(actionRequest, "projectTeamsId");
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long selectRole = ParamUtil.getLong(actionRequest, "selectRole");
		boolean checkForManager = ParamUtil.getBoolean(actionRequest, "checkForManager");
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(selectEmployee));
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(selectProject));
		List<AddTeamMember> list = AddTeamMemberLocalServiceUtil.dynamicQuery(dynamicQuery);
		boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			for (AddTeamMember oh : list) {
				if (oh.getProjectTeamsId() != projectTeamsId) {
					bFlg = true;
				}
			}
		}
		if (bFlg) {
			error.add("Given Status Name already exist");
		}
		if (error.size() == 0) {
			AddTeamMember obj = null;
			try {
				AddTeamMember atm = AddTeamMemberLocalServiceUtil.getAddTeamMember(projectTeamsId);
				atm.setAddedDate(date);
				// atm.setEmployee_id(selectEmployee);
				atm.setProjectId(selectProject);
				atm.setRoleId(selectRole);
				atm.setIsProjectManager(checkForManager);
				obj = AddTeamMemberLocalServiceUtil.updateAddTeamMember(atm);
				/*
				 * HttpServletRequest httpRequest =
				 * PortalUtil.getHttpServletRequest(actionRequest);
				 * httpRequest.setAttribute("project_teams_id",
				 * String.valueOf(project_teams_id));
				 * actionResponse.setRenderParameter("jspPage",
				 * "/META-INF/resources/view.jsp");
				 */
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

	public void deleteTeamMember(ActionRequest actionRequest, ActionResponse actionResponse) {
		long projectTeamsId = ParamUtil.getLong(actionRequest, "projectTeamsId1");
		try {
			AddTeamMember atm = AddTeamMemberLocalServiceUtil.getAddTeamMember(projectTeamsId);
			AddTeamMemberLocalServiceUtil.deleteAddTeamMember(atm);
			SessionMessages.add(actionRequest, "delete-success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}