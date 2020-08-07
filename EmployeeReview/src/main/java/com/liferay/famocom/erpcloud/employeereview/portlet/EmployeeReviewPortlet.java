package com.liferay.famocom.erpcloud.employeereview.portlet;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.famocom.erpcloud.employeereview.constants.EmployeeReviewPortletKeys;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.EmployeeType;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeReview Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeReviewPortletKeys.EmployeeReview,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeeReviewPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		
		String redirectJsp = ParamUtil.getString(renderRequest, "jspPage");
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = Employee.class.getName();
		if (Validator.isNull(redirectJsp)) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<WorkflowTask> workflowTasks = null;
		
		try {
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			
			workflowTasks = WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(themeDisplay.getCompanyId(), themeDisplay.getUserId(), false, -1, -1, null);
			
			List<Employee> empList = new ArrayList<Employee>();
			for(WorkflowTask workflowTask: workflowTasks){
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
				String requestType = (String) workflowContext.get("entryClassName");
				String employeeId = (String) workflowContext.get("entryClassPK");
				if (classNm.equalsIgnoreCase(requestType)) {
					long empId = Long.parseLong(employeeId);
					Employee employeeObj = EmployeeLocalServiceUtil.getEmployee(empId);
					empList.add(employeeObj);
				}
				
			}
			
			System.out.println("Employee List=>"+empList.size());
			renderRequest.setAttribute("empList", empList);		
			
			List<WorkflowTask> workflowTasksForMe = null;
			
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
			List<Employee> empListMe = new ArrayList<Employee>();
			for (WorkflowTask workflowTask : workflowTasksForMe) {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
				String requestType = (String) workflowContext.get("entryClassName");
				String employeeId = (String) workflowContext.get("entryClassPK");
				if (classNm.equalsIgnoreCase(requestType)) {
					long empId = Long.parseLong(employeeId);
					Employee employeeObj = EmployeeLocalServiceUtil.getEmployee(empId);
					empListMe.add(employeeObj);
				}
				System.out.println("requestType..............." + requestType);
			}
			renderRequest.setAttribute("empListMe", empListMe);
			System.out.println("Employee List ME=>"+empListMe.size());
					
					
					
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		
		
		} else if (Validator.isNotNull(redirectJsp) && redirectJsp.trim().equalsIgnoreCase("/view_employee.jsp")) {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Employee employeeDetails = null;
			
			List<EmployeeType> empType = new ArrayList<EmployeeType>();
			empType = EmployeeTypeLocalServiceUtil.getEmployeeTypes(-1, -1);
			long empId = ParamUtil.getLong(renderRequest, "empId", 0);
			
			
			
			
			
			System.out.println("view_employee==>"+empId);
			
			renderRequest.setAttribute("empType",empType);
			if (Validator.isNotNull(empId) && empId > 0) {
				try {
					employeeDetails = EmployeeLocalServiceUtil.getEmployee(empId);
					FileEntry dlfile = null;
					String imgURL = "";
					
					Date date2 = new Date();
					Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds())
							* 1000);
					if(Validator.isNotNull(employeeDetails.getPhotoId())){
						
							System.out.println("iside if" +employeeDetails.getEmployeePhoto());
							dlfile = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(employeeDetails.getPhotoId()));
						
					}
					if (dlfile != null) {
						imgURL = themeDisplay.getPortalURL() + "/documents/" + themeDisplay.getScopeGroupId() + "/"
								+ dlfile.getFolderId() + "/" + dlfile.getFileName() + "/" + dlfile.getUuid() + "?t="
								+ time2;
					} else {

						imgURL =renderRequest.getContextPath()+"/default.jpg";
					}
					System.out.println("imgURL:-"+imgURL);
					if (Validator.isNotNull(employeeDetails)) {

						renderRequest.setAttribute("empDetails", employeeDetails);
						renderRequest.setAttribute("imgURL", imgURL);
					}
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
	
	
	public void actionAssignToMe(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<WorkflowTask> workflowTasks = null;
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = Employee.class.getName();
		String comment = ParamUtil.getString(actionRequest, "comment",StringPool.BLANK);
		long employeeId = ParamUtil.getLong(actionRequest, "empId");
		
		System.out.println("actionAssignToMe employeeId..............." + employeeId);
		
		long workflowTaskIdStr=0;
		List<WorkflowTask> workflowTasksForMe = null;
		workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUserRoles(themeDisplay.getCompanyId(),
				themeDisplay.getUserId(), false, -1, -1, null);
		System.out.println("workflowTasksForMe..............." + workflowTasksForMe.size());
		
		List<Employee> empListMe = new ArrayList<Employee>();
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			String requestType = (String) workflowContext.get("entryClassName");
			String employeeId_ = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long empId = Long.parseLong(employeeId_);
				Employee employeeObj = EmployeeLocalServiceUtil.getEmployee(empId);
				
				if(empId==employeeId){
					workflowTaskIdStr = workflowTask.getWorkflowTaskId();
				}
				
				//empListMe.add(employeeObj);
			}
			System.out.println("employeeId_..............." + employeeId_);
		}
		
		
		
		assignTo(comment,workflowTaskIdStr,themeDisplay.getUserId(),themeDisplay);
		
		System.out.println("workflowTaskIdStr..............." + workflowTaskIdStr);
		//System.out.println("actionAssignToMe====================>"+employeeId);
		
		
	}
	
	private void assignTo(String comment, long workflowTaskId, long assignUserId,
			ThemeDisplay themeDisplay) {
		WorkflowTask workflowTask;
		try {
			Date dueDate = new Date();
			//long workflowTaskId = Long.parseLong(workflowTaskIdStr);
			//long assignUserId = Long.parseLong(assignUserid);
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
	
	public void approveEmployee(ActionRequest actionRequest, ActionResponse actionResponse){
		Long empId = ParamUtil.getLong(actionRequest, "empId", 0);
		String comments = ParamUtil.getString(actionRequest, "comment");
		String actionVal = ParamUtil.getString(actionRequest, "approve");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = Employee.class.getName();
		long WorkflowTaskId =0;
		
		///======================================For TaskID===================================================
		List<WorkflowTask> workflowTasksForMe = null;
		
		try {
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
		} catch (WorkflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Employee> empListMe = new ArrayList<Employee>();
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			try {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			} catch (WorkflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, workflowTaskId);
			String requestType = (String) workflowContext.get("entryClassName");
			String employeeId = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long empIdreview = Long.parseLong(employeeId);
				if(empIdreview==empId){
					WorkflowTaskId = workflowTask.getWorkflowTaskId();
					System.out.println("WorkflowTaskId..............." + WorkflowTaskId);
					
				}
				
			}
			
		}
		
	//==========================================================================================================	
		
		try {
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					WorkflowTaskId, "approve",comments, workflowContext);
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void rejectEmployee(ActionRequest actionRequest, ActionResponse actionResponse){
		Long empId = ParamUtil.getLong(actionRequest, "empId", 0);
		String comments = ParamUtil.getString(actionRequest, "comment");
		String actionVal = ParamUtil.getString(actionRequest, "approve");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, Serializable> workflowContext = new HashMap<>();
		String classNm = Employee.class.getName();
		long WorkflowTaskId =0;
		
		///======================================For TaskID===================================================
		List<WorkflowTask> workflowTasksForMe = null;
		
		try {
			workflowTasksForMe = WorkflowTaskManagerUtil.getWorkflowTasksByUser(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), false, -1, -1, null);
		} catch (WorkflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Employee> empListMe = new ArrayList<Employee>();
		for (WorkflowTask workflowTask : workflowTasksForMe) {
			try {
				workflowContext = getWorkflowContext(themeDisplay, workflowTask);
			} catch (WorkflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//WorkflowTaskManagerUtil.getNextTransitionNames(companyId, userId, workflowTaskId);
			String requestType = (String) workflowContext.get("entryClassName");
			String employeeId = (String) workflowContext.get("entryClassPK");
			if (classNm.equalsIgnoreCase(requestType)) {
				long empIdreview = Long.parseLong(employeeId);
				if(empIdreview==empId){
					WorkflowTaskId = workflowTask.getWorkflowTaskId();
					System.out.println("WorkflowTaskId..............." + WorkflowTaskId);
				}
				
			}
			
		}
		
	//==========================================================================================================	
		
		try {
			WorkflowTaskManagerUtil.completeWorkflowTask(themeDisplay.getCompanyId(), themeDisplay.getUserId(),
					WorkflowTaskId, "reject",comments, workflowContext);
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}