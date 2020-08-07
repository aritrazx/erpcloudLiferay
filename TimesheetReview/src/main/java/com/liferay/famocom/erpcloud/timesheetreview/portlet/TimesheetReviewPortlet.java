package com.liferay.famocom.erpcloud.timesheetreview.portlet;

import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.TimeSheetEntry;
import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.timesheetreview.constants.TimesheetReviewPortletKeys;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author hussh
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=TimesheetReview Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TimesheetReviewPortletKeys.TimesheetReview,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TimesheetReviewPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		System.out.println("render in java page-----");
		String redirectJsp = ParamUtil.getString(renderRequest, "jspPage");
		System.out.println("redirectJsp-----" + redirectJsp);
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = TimeSheetMaster.class.getName();
		System.out.println("classNm-----" + classNm);
		if (Validator.isNull(redirectJsp)) {
			System.out.println("inside if-----");
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Employee emp = EmployeeLocalServiceUtil.findByemployees(themeDisplay.getUserId());
			List<WorkflowTask> workflowTasks = null;
			try {
				System.out.println("inside if-try-----");
				// User user =
				// UserLocalServiceUtil.getUser(themeDisplay.getUserId());

				workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(themeDisplay.getCompanyId(),
						themeDisplay.getUserId(), false, -1, -1, null);

				List<TimeSheetMaster> tsList = new ArrayList<TimeSheetMaster>();
				for (WorkflowTask workflowTask : workflowTasks) {
					System.out.println("inside if-try-for-----");
					workflowContext = getWorkflowContext(themeDisplay, workflowTask);
					String requestType = (String) workflowContext.get("entryClassName");
					String timesheetParentId = (String) workflowContext.get("entryClassPK");
					if (classNm.equalsIgnoreCase(requestType)) {
						System.out.println("inside if-try-for-if-----");
						long tsId = Long.parseLong(timesheetParentId);
						System.out.println("timesheetParentId-----" + timesheetParentId);
						System.out.println("tsId-----" + tsId);
						try {
							TimeSheetMaster timesheetObj = TimeSheetMasterLocalServiceUtil.getTimeSheetMaster(tsId);
							System.out.println("timesheetObj-----" + timesheetObj);
							
							
							tsList.add(timesheetObj);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("tsList-----" + tsList);
						System.out.println("inside if-try-for-if-end-----");
					}
					System.out.println("inside if-try-for-end-----");
				}

				System.out.println("timesheet List=>" + tsList.size());
				renderRequest.setAttribute("tsList", tsList);

				List<WorkflowTask> workflowTasksForMe = null;

				workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
						themeDisplay.getUserId(), false, -1, -1, null);
				List<TimeSheetMaster> tsListMe = new ArrayList<TimeSheetMaster>();
				for (WorkflowTask workflowTask : workflowTasksForMe) {
					workflowContext = getWorkflowContext(themeDisplay, workflowTask);
					String requestType = (String) workflowContext.get("entryClassName");
					String timesheetParentId = (String) workflowContext.get("entryClassPK");
					if (classNm.equalsIgnoreCase(requestType)) {
						long tsId = Long.parseLong(timesheetParentId);
						TimeSheetMaster timesheetObj = null;
						try {
							if(tsId!=0){
							timesheetObj = TimeSheetMasterLocalServiceUtil.getTimeSheetMaster(tsId);
							}
							tsListMe.add(timesheetObj);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("requestType..............." + requestType);
				}
				renderRequest.setAttribute("tsListMe", tsListMe);
				System.out.println("timesheet List ME=>" + tsListMe.size());

			} catch (Exception e) {

				// TODO: handle exception
			}

		} else if (Validator.isNotNull(redirectJsp) && redirectJsp.trim().equalsIgnoreCase("/viewTimesheet.jsp")) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<WorkflowTask> workflowTasksForMe = null;
			long tsId = 0;

			try {
				workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
						themeDisplay.getUserId(), false, -1, -1, null);
			} catch (WorkflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<TimeSheetMaster> tsListMe = new ArrayList<TimeSheetMaster>();
			for (WorkflowTask workflowTask : workflowTasksForMe) {
				try {
					workflowContext = getWorkflowContext(themeDisplay, workflowTask);
				} catch (WorkflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String requestType = (String) workflowContext.get("entryClassName");
				String timesheetParentId = (String) workflowContext.get("entryClassPK");
				if (classNm.equalsIgnoreCase(requestType)) {
					tsId = Long.parseLong(timesheetParentId);
					TimeSheetMaster timesheetObj;
					try {
						timesheetObj = TimeSheetMasterLocalServiceUtil.getTimeSheetMaster(tsId);
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("requestType..............." + requestType);
			}
			renderRequest.setAttribute("timesheetParentId", tsId);
			System.out.println("timesheet List ME=>" + tsListMe.size());

		}

		super.render(renderRequest, renderResponse);

	}

	private static Map<String, Serializable> getWorkflowContext(ThemeDisplay themeDisplay, WorkflowTask workflowTask)
			throws WorkflowException {
		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(),
				workflowTask.getWorkflowInstanceId());
		Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
		return workflowContext;
	}

	public void actionAssignToMe(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<WorkflowTask> workflowTasks = null;
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = TimeSheetMaster.class.getName();
		String comment = ParamUtil.getString(actionRequest, "comment", StringPool.BLANK);
		long timesheetParentId = ParamUtil.getLong(actionRequest, "timesheetParentId");

		System.out.println("actionAssignToMe timesheetId..............." + timesheetParentId);

		long workflowTaskIdStr = 0;
		List<WorkflowTask> workflowTasksForMe = null;
		workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(themeDisplay.getCompanyId(),
				themeDisplay.getUserId(), false, -1, -1, null);
		System.out.println("workflowTasksForMe..............." + workflowTasksForMe.size());

		List<TimeSheetMaster> tsListMe = new ArrayList<TimeSheetMaster>();
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			String requestType = (String) workflowContext.get("entryClassName");
			String timesheetId_ = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long tsId = Long.parseLong(timesheetId_);
				TimeSheetMaster timesheetObj = TimeSheetMasterLocalServiceUtil.getTimeSheetMaster(tsId);

				if (tsId == timesheetParentId) {
					workflowTaskIdStr = workflowTask.getWorkflowTaskId();
				}

				// empListMe.add(employeeObj);
			}
			System.out.println("timesheetId_..............." + timesheetId_);
		}

		assignTo(comment, workflowTaskIdStr, themeDisplay.getUserId(), themeDisplay);

		System.out.println("workflowTaskIdStr..............." + workflowTaskIdStr);
		// System.out.println("actionAssignToMe====================>"+employeeId);

	}

	private void assignTo(String comment, long workflowTaskId, long assignUserId, ThemeDisplay themeDisplay) {
		WorkflowTask workflowTask;
		try {
			Date dueDate = new Date();
			// long workflowTaskId = Long.parseLong(workflowTaskIdStr);
			// long assignUserId = Long.parseLong(assignUserid);
			workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), workflowTaskId);
			Map<String, Serializable> workflowContext;
			workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			workflowTask = WorkflowTaskManagerUtil.assignWorkflowTaskToUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), workflowTaskId, assignUserId, comment, dueDate, workflowContext);
			System.out.println("final workflowTask " + workflowTask);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem");
		}
	}

	public void approveTimesheet(ActionRequest actionRequest, ActionResponse actionResponse) {
		Long timesheetParentId = ParamUtil.getLong(actionRequest, "timesheetParentId", 0);
		String comments = ParamUtil.getString(actionRequest, "comment");
		String actionVal = ParamUtil.getString(actionRequest, "approve");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = TimeSheetMaster.class.getName();
		long WorkflowTaskId = 0;

		/// ======================================For
		/// TaskID===================================================
		List<WorkflowTask> workflowTasksForMe = null;

		try {
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
		} catch (WorkflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<TimeSheetMaster> tsListMe = new ArrayList<TimeSheetMaster>();
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			try {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			} catch (WorkflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId,
			// workflowTaskId);
			String requestType = (String) workflowContext.get("entryClassName");
			String timesheetId_ = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long tsIdreview = Long.parseLong(timesheetId_);
				if (tsIdreview == timesheetParentId) {
					WorkflowTaskId = workflowTask.getWorkflowTaskId();
					System.out.println("WorkflowTaskId..............." + WorkflowTaskId);

				}

			}

		}

		// ==========================================================================================================

		try {
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					WorkflowTaskId, "approve", comments, workflowContext);
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void rejectTimesheet(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("inside reject----");
		Long timesheetParentId = ParamUtil.getLong(actionRequest, "timesheetParentId", 0);
		String comments = ParamUtil.getString(actionRequest, "comment");
		String actionVal = ParamUtil.getString(actionRequest, "approve");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = TimeSheetMaster.class.getName();
		long WorkflowTaskId = 0;

		/// ======================================For
		/// TaskID===================================================
		List<WorkflowTask> workflowTasksForMe = null;

		try {
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
		} catch (WorkflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<TimeSheetMaster> tsListMe = new ArrayList<TimeSheetMaster>();
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			try {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			} catch (WorkflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId,
			// workflowTaskId);
			String requestType = (String) workflowContext.get("entryClassName");
			String timesheetId_ = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long tsIdreview = Long.parseLong(timesheetId_);
				if (tsIdreview == timesheetParentId) {
					WorkflowTaskId = workflowTask.getWorkflowTaskId();
					System.out.println("WorkflowTaskId..............." + WorkflowTaskId);
				}

			}

		}

		// ==========================================================================================================

		try {
			System.out.println("----timesheet parent id---"+timesheetParentId);
			TimeSheetMaster tsm = TimeSheetMasterLocalServiceUtil.getTimeSheetMaster(timesheetParentId);
			tsm.setSubmitStatus(3);
			System.out.println("----inside update---");
			TimeSheetMasterLocalServiceUtil.updateTimeSheetMaster(tsm);
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					WorkflowTaskId, "reject", comments, workflowContext);
			System.out.println("workflow completed---");
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}