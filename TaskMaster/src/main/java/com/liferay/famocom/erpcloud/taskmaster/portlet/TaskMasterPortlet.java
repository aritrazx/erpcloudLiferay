package com.liferay.famocom.erpcloud.taskmaster.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.BankMaster;
import com.liferay.famocom.erpcloud.model.TaskMaster;
import com.liferay.famocom.erpcloud.service.BankMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaskMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.taskmaster.constants.TaskMasterPortletKeys;
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
 * @author hussh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TaskMaster Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TaskMasterPortletKeys.TaskMaster,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TaskMasterPortlet extends MVCPortlet {
	public void taskMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<String> error = new ArrayList<String>();
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		String taskDesc=ParamUtil.getString(actionRequest, "taskDesc", StringPool.BLANK);
		String status=ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		
		DynamicQuery dynamicQuery = TaskMasterLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("taskName").eq(taskName));
		List<TaskMaster> list = TaskMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Project Name already exist");
		}
				if (error.size() == 0) {
					TaskMaster obj = null;
					try {
						
						long taskId = CounterLocalServiceUtil.increment(TaskMaster.class.getName());
						TaskMaster tm = TaskMasterLocalServiceUtil.createTaskMaster(taskId);
						tm.setTaskName(taskName);
						tm.setTaskDesc(taskDesc);
						tm.setStatus(Integer.parseInt(status));
						tm.setCreateDate(date);
						obj = TaskMasterLocalServiceUtil.addTaskMaster(tm);
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
	
	public void updateTaskMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		String taskName=ParamUtil.getString(actionRequest, "taskName", StringPool.BLANK);
		String taskDesc=ParamUtil.getString(actionRequest, "taskDesc", StringPool.BLANK);
		String status=ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		long taskId = ParamUtil.getLong(actionRequest, "taskId");
		List<String> error = new ArrayList<String>();
		String backUrl = ParamUtil.getString(actionRequest, "backUrl", StringPool.BLANK);
		System.out.println("taskId......"+taskId);
		DynamicQuery dynamicQuery = TaskMasterLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("taskName").eq(taskName));
		List<TaskMaster> list = TaskMasterLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("list....."+list);
		boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			for (TaskMaster oh : list) {
				if (oh.getTaskId() != taskId) {
					bFlg = true;
				}
			}
		}
		System.out.println("bFlg....."+bFlg);
		if (bFlg) {
			error.add("Given Status Name already exist");
		}
		System.out.println("error....."+error.size());
		if (error.size() == 0) {
			TaskMaster obj = null;
			System.out.println("inside if....");
			try {
				System.out.println("inside try....");
				TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(taskId);
				tm.setTaskName(taskName);
				tm.setTaskDesc(taskDesc);
				tm.setStatus(Integer.parseInt(status));
				obj = TaskMasterLocalServiceUtil.updateTaskMaster(tm);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (obj != null) {
				System.out.println("inside if(obj)....");
				SessionMessages.add(actionRequest, "update-success");
			} else {
				System.out.println("inside else(obj)....");
				SessionErrors.add(actionRequest, "update-error");
				// SessionMessages.add(actionRequest,
				// PortalUtil.getPortletId(actionRequest)+ SessionMessages.
				// KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		} else {
			System.out.println("inside else....");
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
	
	public void deleteTask(ActionRequest actionRequest, ActionResponse actionResponse) {
		long taskId = ParamUtil.getLong(actionRequest, "taskId1");
		try {
			TaskMaster tm = TaskMasterLocalServiceUtil.getTaskMaster(taskId);
			TaskMasterLocalServiceUtil.deleteTaskMaster(tm);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}