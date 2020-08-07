package com.liferay.famocom.erpcloud.projectreport.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.ProjectReport;
import com.liferay.famocom.erpcloud.projectreport.constants.ProjectReportPortletKeys;
import com.liferay.famocom.erpcloud.service.ProjectReportLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
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
		"javax.portlet.display-name=ProjectReport Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProjectReportPortletKeys.ProjectReport,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectReportPortlet extends MVCPortlet {

	public void projectReport(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long selectTeamMember = ParamUtil.getLong(actionRequest, "selectTeamMember");
		long selectTask = ParamUtil.getLong(actionRequest, "selectTask");
		String fromDate = ParamUtil.getString(actionRequest, "fromDate", StringPool.BLANK);
		String toDate = ParamUtil.getString(actionRequest, "toDate", StringPool.BLANK);
		List<String> error = new ArrayList<String>();
		Date tempFromDate = new Date();
		Date tempToDate = new Date();

		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		try {
			tempFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			tempToDate = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DynamicQuery dynamicQuery = ProjectReportLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("project_id").eq(selectProject));
		dynamicQuery.add(PropertyFactoryUtil.forName("employee_id").eq(selectTeamMember));
		dynamicQuery.add(PropertyFactoryUtil.forName("project_task_id").eq(selectTask));
		dynamicQuery.add(PropertyFactoryUtil.forName("from_date").eq(tempFromDate));
		dynamicQuery.add(PropertyFactoryUtil.forName("to_date").eq(tempToDate));
		List<ProjectReport> list = ProjectReportLocalServiceUtil.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Project Name already exist");
		}
		if (error.size() == 0) {
			ProjectReport obj = null;

			try {
				long report_template_id = CounterLocalServiceUtil.increment(ProjectReport.class.getName());
				ProjectReport projectReport = ProjectReportLocalServiceUtil.createProjectReport(report_template_id);
				projectReport.setAddedDate(date);
				projectReport.setProjectId(selectProject);
				projectReport.setEmployeeId(selectTeamMember);
				projectReport.setProjectTaskId(selectTask);
				projectReport.setFromDate(tempFromDate);
				projectReport.setToDate(tempToDate);

				obj = ProjectReportLocalServiceUtil.addProjectReport(projectReport);

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
}