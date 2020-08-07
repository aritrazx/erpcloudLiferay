package com.liferay.famocom.erpcloud.projectmaster.portlet;

import java.io.IOException;
import java.text.ParseException;
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
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.BillingTable;
import com.liferay.famocom.erpcloud.model.Milestone;
import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.model.ProjectTask;
import com.liferay.famocom.erpcloud.model.TaskMasterMapping;
import com.liferay.famocom.erpcloud.projectmaster.constants.ProjectMasterPortletKeys;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.BillingTableLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ProjectTaskLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
		"javax.portlet.display-name=ProjectMaster Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProjectMasterPortletKeys.ProjectMaster,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProjectMasterPortlet extends MVCPortlet {
	@ProcessAction(name = "projectMaster")
	public void projectMaster(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {
		List<String> error = new ArrayList<String>();
		String projectName = ParamUtil.getString(actionRequest, "projectName", StringPool.BLANK);
		long selectManager = ParamUtil.getLong(actionRequest, "selectManager");
		String projectDescription = ParamUtil.getString(actionRequest, "projectDescription", StringPool.BLANK);
		long clientName = ParamUtil.getLong(actionRequest, "clientName");
		long selectStatus = ParamUtil.getLong(actionRequest, "selectStatus");
		String startDate = ParamUtil.getString(actionRequest, "startDate", StringPool.BLANK);
		String endDate = ParamUtil.getString(actionRequest, "endDate", StringPool.BLANK);
		//String totalAmount = ParamUtil.getString(actionRequest, "totalAmount", StringPool.BLANK);
		String selectTask = ParamUtil.getString(actionRequest, "selectTask", StringPool.BLANK);
		String[] taskArr = ParamUtil.getParameterValues(actionRequest, "taskList");
		String taskList = ParamUtil.getString(actionRequest, "taskList", StringPool.BLANK);
		String taskListArr[] = taskList.split(",");
		System.out.println("selectTask in java....." + selectTask);
		System.out.println("taskArr in java....." + taskArr);
		System.out.println("taskList in java....." + taskList);
		System.out.println("taskListArr in java....." + taskListArr);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		Date tempStartDate=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
		Date tempEndDate=new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
		//Using dynamic query for validation
		DynamicQuery dynamicQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectName").eq(projectName));
		List<ProjectMaster> list = ProjectMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("list...."+list);
		//Checking validator not null and list not empty condition
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Project Name already exist");
		}
				if (error.size() == 0) {
					ProjectMaster obj = null;
				
		try {
			long projectId = CounterLocalServiceUtil.increment(ProjectMaster.class.getName());
			ProjectMaster projMast = ProjectMasterLocalServiceUtil.createProjectMaster(projectId);
			//setting values in each field
			projMast.setProjectName(projectName); 
			//projMast.setEmployeeId(selectManager);
			projMast.setProjectDesc(projectDescription);
			projMast.setProjectStatusId(selectStatus);
			projMast.setCompanyId(20116);
			projMast.setAddedDate(date);
			projMast.setStartDate(tempStartDate);
			projMast.setEndDate(tempEndDate);
		//	projMast.setTotalAmount(Double.valueOf(totalAmount));
			projMast.setClientId(clientName);
			projMast.setProjectStatus(1);
			obj=ProjectMasterLocalServiceUtil.addProjectMaster(projMast); //getting the values
			for(int i=0;i<taskArr.length;i++){
			long taskId = Long.parseLong(taskListArr[i]);
			long taskMappingId = CounterLocalServiceUtil.increment(TaskMasterMapping.class.getName());
			TaskMasterMapping tmm = TaskMasterMappingLocalServiceUtil.createTaskMasterMapping(taskMappingId);
			tmm.setTaskId(taskId);
			tmm.setProjectId(projMast.getProjectId());
			tmm.setCreateDate(date);
			TaskMasterMappingLocalServiceUtil.addTaskMasterMapping(tmm);
			}
			if (obj != null) {
				SessionMessages.add(actionRequest, "add-success");
			} else {
				SessionErrors.add(actionRequest, "add-error");
				 /*SessionMessages.add(actionRequest,
				 PortalUtil.getPortletId(actionRequest)+ SessionMessages.
				 KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);*/
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				}
				else{
					try {
					    SessionErrors.add(actionRequest, "error");
					    SessionMessages.add(actionRequest,PortalUtil.getPortletId(actionRequest)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
						//System.out.println("ELSE>>>"+error);
						httpRequest.setAttribute("error", error);
						actionResponse.setWindowState(WindowState.NORMAL);
						actionResponse.setRenderParameter("jspPage","/META-INF/resources/view.jsp");
						} catch (WindowStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
						
				
			}
		
	}
	@ProcessAction(name = "updateProjectMaster")
	public void updateProjectMaster(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, ParseException {
		List<String> error = new ArrayList<String>();
		long projectId = ParamUtil.getLong(actionRequest, "projectId");
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		String projectName = ParamUtil.getString(actionRequest, "projectName", StringPool.BLANK);
		long selectManager = ParamUtil.getLong(actionRequest, "selectManager");
		String projectDescription = ParamUtil.getString(actionRequest, "projectDescription", StringPool.BLANK);
		long selectStatus = ParamUtil.getLong(actionRequest, "selectStatus");
		String clientName = ParamUtil.getString(actionRequest, "clientName", StringPool.BLANK);
		String startDate = ParamUtil.getString(actionRequest, "startDate", StringPool.BLANK);
		String endDate = ParamUtil.getString(actionRequest, "endDate", StringPool.BLANK);
		String totalAmount = ParamUtil.getString(actionRequest, "totalAmount", StringPool.BLANK);
		String[] taskArr = ParamUtil.getParameterValues(actionRequest, "taskList");
		String taskList = ParamUtil.getString(actionRequest, "taskList", StringPool.BLANK);
		String taskListArr[] = taskList.split(",");
		System.out.println("taskArr in java....." + taskArr);
		System.out.println("taskList in java....." + taskList);
		System.out.println("taskListArr in java....." + taskListArr);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		Date tempStartDate=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
		Date tempEndDate=new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
		DynamicQuery dynamicQuery = ProjectMasterLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectName").eq(projectName));
		List<ProjectMaster> list = ProjectMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
		boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			for (ProjectMaster oh : list) {
				if (oh.getProjectId() != projectId) {
					bFlg = true;
				}
			}
		}
		if (bFlg) {
			error.add("Given Status Name already exist");
		}
		if (error.size() == 0) {
			ProjectMaster obj = null;
		try {
			ProjectMaster projMast = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
			projMast.setProjectName(projectName);
			//projMast.setEmployeeId(selectManager);
			projMast.setProjectDesc(projectDescription);
			projMast.setProjectStatusId(selectStatus);
			projMast.setAddedDate(date);
			projMast.setStartDate(tempStartDate);
			projMast.setEndDate(tempEndDate);
			projMast.setTotalAmount(Double.valueOf(totalAmount));
			projMast.setClientId(Long.parseLong(clientName));
			
			obj=ProjectMasterLocalServiceUtil.updateProjectMaster(projMast);
			List<TaskMasterMapping> tmmList = new ArrayList<>();
			for(int i=0;i<taskArr.length;i++){
				//long taskId = Long.parseLong(taskListArr[i]);
				//System.out.println("taskId..."+taskId);
				DynamicQuery dynamicQuery1 = TaskMasterMappingLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("projectId", projectId);
				 /*criterion3 = RestrictionsFactoryUtil.and(criterion3,
				RestrictionsFactoryUtil.eq("taskId", taskId)); */
				dynamicQuery1.add(criterion3);
				tmmList = TaskMasterMappingLocalServiceUtil.dynamicQuery(dynamicQuery1);
				if(tmmList.size()!=0){
					for(int j=0;j<tmmList.size();j++){
						TaskMasterMapping tmm = TaskMasterMappingLocalServiceUtil.getTaskMasterMapping(tmmList.get(j).getTaskMappingId());
						TaskMasterMappingLocalServiceUtil.deleteTaskMasterMapping(tmm);
					}
				}
				for(i=0;i<taskArr.length;i++){
				long taskId = Long.parseLong(taskListArr[i]);
				System.out.println("taskId..."+taskId);
				long taskMappingId = CounterLocalServiceUtil.increment(TaskMasterMapping.class.getName());
				TaskMasterMapping tmm1 = TaskMasterMappingLocalServiceUtil.createTaskMasterMapping(taskMappingId);
				tmm1.setTaskId(taskId);
				tmm1.setProjectId(projectId);
				tmm1.setCreateDate(date);
				TaskMasterMappingLocalServiceUtil.addTaskMasterMapping(tmm1);
				}
				
				//empList.addAll(empTempList);
				//long taskMappingId = CounterLocalServiceUtil.increment(TaskMasterMapping.class.getName());
				/*if(tmmList.size()!=0){
				if(taskArr.length == tmmList.size()){
					if(taskId == tmmList.get(i).getTaskId()){
				TaskMasterMapping tmm = TaskMasterMappingLocalServiceUtil.getTaskMasterMapping(tmmList.get(i).getTaskMappingId());
				tmm.setTaskId(taskId);
				tmm.setProjectId(projectId);
				tmm.setCreateDate(date);
				TaskMasterMappingLocalServiceUtil.updateTaskMasterMapping(tmm);
					} else {
						long taskMappingId = CounterLocalServiceUtil.increment(TaskMasterMapping.class.getName());
						TaskMasterMapping tmm = TaskMasterMappingLocalServiceUtil.createTaskMasterMapping(taskMappingId);
						tmm.setTaskId(taskId);
						tmm.setProjectId(projectId);
						tmm.setCreateDate(date);
						TaskMasterMappingLocalServiceUtil.addTaskMasterMapping(tmm);
					}
				}
				}*/
				}
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
	
	public void deactivate(ActionRequest actionRequest, ActionResponse actionResponse){
		long projectId=ParamUtil.getLong(actionRequest, "projectId");
		int status=0;
		try{
		ProjectMaster obj = null;
		if(projectId>0){
			obj = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
			obj.setProjectStatus(status);
			ProjectMasterLocalServiceUtil.updateProjectMaster(obj);
			actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void activate(ActionRequest actionRequest, ActionResponse actionResponse){
		long projectId=ParamUtil.getLong(actionRequest, "projectId");
		int status=1;
		try{
		ProjectMaster obj = null;
		if(projectId>0){
			obj = ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
			obj.setProjectStatus(status);
			ProjectMasterLocalServiceUtil.updateProjectMaster(obj);
			actionResponse.sendRedirect("/resources/META-INF/resources/view.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@ProcessAction(name = "milestone")
	public void milestone(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException{
		String milestoneName = ParamUtil.getString(actionRequest, "milestoneName", StringPool.BLANK);
		String dueDate = ParamUtil.getString(actionRequest, "dueDate", StringPool.BLANK);
		String amount = ParamUtil.getString(actionRequest, "amount", StringPool.BLANK);
		String checkGST = ParamUtil.getString(actionRequest, "checkGST", StringPool.BLANK);
		String projectId = ParamUtil.getString(actionRequest, "projectId", StringPool.BLANK);
		String clientId = ParamUtil.getString(actionRequest, "clientId", StringPool.BLANK);
		Date tempDueDate=new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
		
		try {
			long billingId = CounterLocalServiceUtil.increment(Milestone.class.getName());
			
			Milestone bt = MilestoneLocalServiceUtil.createMilestone(billingId);
			
			bt.setAmount(Double.valueOf(amount));
			bt.setCheckGST(Integer.parseInt(checkGST));
			bt.setDueDate(tempDueDate);
			bt.setMilestoneName(milestoneName);
			bt.setProjectId(Long.parseLong(projectId));
			bt.setClientId(Long.parseLong(clientId));
			MilestoneLocalServiceUtil.addMilestone(bt);
			SessionMessages.add(actionRequest, "add-success");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateMilestone(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException{
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		String milestoneName = ParamUtil.getString(actionRequest, "milestoneName", StringPool.BLANK);
		String dueDate = ParamUtil.getString(actionRequest, "dueDate", StringPool.BLANK);
		String amount = ParamUtil.getString(actionRequest, "amount", StringPool.BLANK);
		String checkGST = ParamUtil.getString(actionRequest, "checkGST", StringPool.BLANK);
		String projectId = ParamUtil.getString(actionRequest, "projectId", StringPool.BLANK);
		String clientId = ParamUtil.getString(actionRequest, "clientId", StringPool.BLANK);
		Date tempDueDate=new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
		
		try {
			
			Milestone bt = MilestoneLocalServiceUtil.getMilestone(billingId);
			
			bt.setAmount(Double.valueOf(amount));
			bt.setCheckGST(Integer.parseInt(checkGST));
			bt.setDueDate(tempDueDate);
			bt.setMilestoneName(milestoneName);
			bt.setProjectId(Long.parseLong(projectId));
			bt.setClientId(Long.parseLong(clientId));
			MilestoneLocalServiceUtil.updateMilestone(bt);
			SessionMessages.add(actionRequest, "update-success");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteMilestone(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException{
		long billingId = ParamUtil.getLong(actionRequest, "billingId1");
		String projectId = ParamUtil.getString(actionRequest, "projectId", StringPool.BLANK);
		String clientId = ParamUtil.getString(actionRequest, "clientId", StringPool.BLANK);
		System.out.println("milestone delete...."+billingId);
		try {
			Milestone bt = MilestoneLocalServiceUtil.getMilestone(billingId);
			bt.setProjectId(Long.parseLong(projectId));
			bt.setClientId(Long.parseLong(clientId));
			MilestoneLocalServiceUtil.deleteMilestone(bt);
			SessionMessages.add(actionRequest, "delete-success");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/showMilestoneList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void addTeamMember(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<String> error = new ArrayList<String>();
		long selectEmployee = ParamUtil.getLong(actionRequest, "selectEmployee");
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		System.out.println("employeeId----"+employeeId);
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long projectId = ParamUtil.getLong(actionRequest, "projectId");
		System.out.println("projectId in member java page--"+projectId);
		long selectRole = ParamUtil.getLong(actionRequest, "selectRole");
		boolean checkForManager = ParamUtil.getBoolean(actionRequest, "checkForManager");
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
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
				atm.setEmployeeId(employeeId);
				atm.setProjectId(projectId);
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
					actionResponse.setWindowState(WindowState.NORMAL);
					actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
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
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
			} catch (WindowStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateTeamMember(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException {
		List<String> error = new ArrayList<String>();
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		long selectEmployee = ParamUtil.getLong(actionRequest, "selectEmployee");
		long projectTeamsId = ParamUtil.getLong(actionRequest, "projectTeamsId");
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		long selectProject = ParamUtil.getLong(actionRequest, "selectProject");
		long projectId = ParamUtil.getLong(actionRequest, "projectId");
		long selectRole = ParamUtil.getLong(actionRequest, "selectRole");
		boolean checkForManager = ParamUtil.getBoolean(actionRequest, "checkForManager");
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = AddTeamMemberLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeId").eq(employeeId));
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
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
				atm.setProjectId(projectId);
				atm.setEmployeeId(employeeId);
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
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
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
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
		}
	}

	public void deleteTeamMember(ActionRequest actionRequest, ActionResponse actionResponse) {
		long projectTeamsId = ParamUtil.getLong(actionRequest, "projectTeamsId1");
		long projectId = ParamUtil.getLong(actionRequest, "projectId");
		try {
			AddTeamMember atm = AddTeamMemberLocalServiceUtil.getAddTeamMember(projectTeamsId);
			atm.setProjectId(projectId);
			AddTeamMemberLocalServiceUtil.deleteAddTeamMember(atm);
			SessionMessages.add(actionRequest, "delete-success");
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchProjectList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void projectTask(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {
		long selectProject =ParamUtil.getLong(actionRequest, "selectProject");
		long selectEmployee =ParamUtil.getLong(actionRequest, "selectEmployee");
		long projectId =ParamUtil.getLong(actionRequest, "projectId");
		String selectTask = ParamUtil.getString(actionRequest, "selectTask", StringPool.BLANK);
		String startDate = ParamUtil.getString(actionRequest, "startDate", StringPool.BLANK);
		String endDate = ParamUtil.getString(actionRequest, "endDate", StringPool.BLANK);
		String hours = ParamUtil.getString(actionRequest, "hours", StringPool.BLANK);
		Date tempStartDate=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
		Date tempEndDate=new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
		List<String> error = new ArrayList<String>();
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
		dynamicQuery.add(PropertyFactoryUtil.forName("taskId").eq(Long.parseLong(selectTask)));
		List<ProjectTask> list = ProjectTaskLocalServiceUtil.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Task Name already exist");
		}
		if (error.size() == 0) {
			ProjectTask obj = null;
		try {
			long projectTaskId=CounterLocalServiceUtil.increment(ProjectTask.class.getName());
			ProjectTask projTask=ProjectTaskLocalServiceUtil.createProjectTask(projectTaskId);
			projTask.setProjectId(projectId);
			projTask.setEmployeeId(selectEmployee);
			projTask.setStartDate(tempStartDate);
			projTask.setEndDate(tempEndDate);
			projTask.setHours(Double.valueOf(hours));
			projTask.setTaskId(Long.parseLong(selectTask));
			projTask.setAddedDate(date);
			
			obj = ProjectTaskLocalServiceUtil.addProjectTask(projTask);
			
			if (obj != null) {
				SessionMessages.add(actionRequest, "add-success");
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
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
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
			} catch (WindowStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void updateProjectTask(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException, ParseException {
		long selectProject =ParamUtil.getLong(actionRequest, "selectProject");
		long projectId =ParamUtil.getLong(actionRequest, "projectId");
		long selectEmployee =ParamUtil.getLong(actionRequest, "selectEmployee");
		String selectTask = ParamUtil.getString(actionRequest, "selectTask", StringPool.BLANK);
		String startDate = ParamUtil.getString(actionRequest, "startDate", StringPool.BLANK);
		String endDate = ParamUtil.getString(actionRequest, "endDate", StringPool.BLANK);
		String hours = ParamUtil.getString(actionRequest, "hours", StringPool.BLANK);
		Date tempStartDate=new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
		Date tempEndDate=new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
		List<String> error = new ArrayList<String>();
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		long projectTaskId = ParamUtil.getLong(actionRequest, "projectTaskId");
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		DynamicQuery dynamicQuery = ProjectTaskLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(projectId));
		dynamicQuery.add(PropertyFactoryUtil.forName("taskId").eq(Long.parseLong(selectTask)));
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
			projTask.setProjectId(projectId);
			projTask.setEmployeeId(selectEmployee);
			projTask.setStartDate(tempStartDate);
			projTask.setEndDate(tempEndDate);
			projTask.setHours(Double.valueOf(hours));
			projTask.setTaskId(Long.parseLong(selectTask));
			projTask.setAddedDate(date);
			
			obj=ProjectTaskLocalServiceUtil.updateProjectTask(projTask);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (obj != null) {
			SessionMessages.add(actionRequest, "update-success");
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
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
		actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
	}
	}
	public void deleteProjectTask(ActionRequest actionRequest, ActionResponse actionResponse) {
		long selectProject =ParamUtil.getLong(actionRequest, "selectProject");
		long projectId =ParamUtil.getLong(actionRequest, "projectId");
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		long projectTaskId = ParamUtil.getLong(actionRequest, "projectTaskId1");
		try {
			ProjectTask projTask=ProjectTaskLocalServiceUtil.getProjectTask(projectTaskId);
			projTask.setProjectId(projectId);
			ProjectTaskLocalServiceUtil.deleteProjectTask(projTask);
			SessionMessages.add(actionRequest, "delete-success");
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/fetchTask.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}