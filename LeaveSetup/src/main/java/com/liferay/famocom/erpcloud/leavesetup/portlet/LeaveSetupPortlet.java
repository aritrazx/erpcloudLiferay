package com.liferay.famocom.erpcloud.leavesetup.portlet;

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
import com.liferay.famocom.erpcloud.leavesetup.constants.LeaveSetupPortletKeys;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.LeaveApply;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;
import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LeaveSetup Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LeaveSetupPortletKeys.LeaveSetup,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LeaveSetupPortlet extends MVCPortlet {

	// Create Method....
	@ProcessAction(name = "addLeave")
	public void addLeave(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException {
		System.out.println("Callllll ADDDDD >>>>>>>>>>>>>>>>>>>>>>>>>");
		List<String> error = new ArrayList<String>();
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		String leaveName = ParamUtil.getString(actionRequest, "leaveName", StringPool.BLANK);
		String abb = ParamUtil.getString(actionRequest, "abb", StringPool.BLANK);
		int encashmentDay = ParamUtil.getInteger(actionRequest, "encashmentDay");
		int forwardDay = ParamUtil.getInteger(actionRequest, "forwardDay");
		boolean leaveStatus = ParamUtil.getBoolean(actionRequest, "leaveStatus");
		int encashmentPer = ParamUtil.getInteger(actionRequest, "encashmentPer");
		int minServiceDay = ParamUtil.getInteger(actionRequest, "minServiceDay");
		int noticeDay = ParamUtil.getInteger(actionRequest, "noticeDay");
		int employeeTypeId = ParamUtil.getInteger(actionRequest, "employeeTypeId");
		int maxCreditDay = ParamUtil.getInteger(actionRequest, "maxCreditDay");
		String gender = ParamUtil.getString(actionRequest, "gender", StringPool.BLANK);
		String maritalStatus = ParamUtil.getString(actionRequest, "maritalStatus", StringPool.BLANK);
		int impectOnSalary = ParamUtil.getInteger(actionRequest,"impectOnSalary");
		//long companyId = ParamUtil.getLong(actionRequest, "companyId");
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		
		if (Validator.isNull(leaveName)) {
            //System.out.println("l name"+leaveName);
			error.add("Please Enter a Name");
			}
		if (Validator.isNull(abb)) {
			//System.out.println("l Abb"+leaveAbbreviation);
			error.add("Leave Abbreviation name is required");
			}
		if (Validator.isNull(String.valueOf(encashmentDay))) {
			System.out.println("Encashment"+encashmentDay);
			error.add("Max Days Encashment is required");
			}
		if (Validator.isNull(encashmentPer)) {

			error.add("Encashment Formula(% of basic) is required");
			}
		if (Validator.isNull(minServiceDay)) {

			error.add("Min Service is required");
			}
		
		if(Validator.isNull(noticeDay)){
			error.add("Notice_day is required");
		}
		if(Validator.isNull(maxCreditDay)){
			error.add("Max Credit Day is required");
		}
		DynamicQuery dynamicQuery = LeaveTypeLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("leaveName").eq(leaveName));
		List<LeaveType> list = LeaveTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
		//boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			SessionErrors.add(actionRequest, "Add-error");
			SessionMessages.add(actionRequest,
			PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/index.jsp");
		}
		if (error.size() == 0) {
			//LeaveType obj = null;
			try {
				long leaveTypeId = CounterLocalServiceUtil.increment(LeaveType.class.getName());
				LeaveType leaveType = LeaveTypeLocalServiceUtil.createLeaveType(leaveTypeId);

				leaveType.setLeaveName(leaveName);
				leaveType.setAbb(abb);
				leaveType.setEncashmentDay(encashmentDay);
				leaveType.setForwardDay(forwardDay);
				leaveType.setLeaveStatus(leaveStatus);
				leaveType.setEncashmentPer(encashmentPer);
				leaveType.setMinServiceDay(minServiceDay);
				leaveType.setNoticeDay(noticeDay);
				leaveType.setEmployeetypeId(employeeTypeId);
				leaveType.setMaxCreditDay(maxCreditDay);
				leaveType.setGender(gender);
				leaveType.setMaritalStatus(maritalStatus);
				leaveType.setImpectOnSalary(impectOnSalary);
				leaveType.setCompanyId(employee.getCompanyId());

				Date date = new Date(); // Local Date fetch
				leaveType.setAddedDate(date);

				LeaveTypeLocalServiceUtil.addLeaveType(leaveType);

			} catch (Exception e) {
				e.printStackTrace();
			}
			/*if (obj != null) {
				SessionErrors.add(actionRequest, "add-error");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			} else {
				SessionMessages.add(actionRequest, "add-success");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
				
				}*/
		}
		else{
			try {
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			System.out.println("ELSE>>>"+error);
			httpRequest.setAttribute("error", error);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage","/META-INF/resources/view.jsp");
			} catch (WindowStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@ProcessAction(name = "deactivate")
	public void deactivate(ActionRequest actionRequest, ActionResponse actionResponse) {
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		List<LeaveApply> leaveList = new ArrayList<>();
		leaveList = LeaveApplyLocalServiceUtil.getLeaveApplies(-1, -1);
		for (LeaveApply leaveTypeIdList : leaveList) {
			leaveTypeIdList.getLeaveApplyId();

			if (leaveTypeId != leaveTypeIdList.getLeaveApplyId()) {
				try {
					LeaveType obj = null;
					if (leaveTypeId > 0) {
						obj = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
						obj.setLeaveStatus(false);
						LeaveTypeLocalServiceUtil.updateLeaveType(obj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@ProcessAction(name = "activate")
	public void activate(ActionRequest actionRequest, ActionResponse actionResponse) {
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		try {
			LeaveType obj = null;
			if (leaveTypeId > 0) {
				obj = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
				obj.setLeaveStatus(true);
				LeaveTypeLocalServiceUtil.updateLeaveType(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//UPDATE METHOD......
	@ProcessAction(name = "editLeave")
	public void editLeave(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Call Update>>>>>>>>>>>>>>");
		List<String> errorlist = new ArrayList<String>();
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		String leaveName = ParamUtil.getString(actionRequest, "leaveName", StringPool.BLANK);
		String abb = ParamUtil.getString(actionRequest, "abb", StringPool.BLANK);
		int encashmentDay = ParamUtil.getInteger(actionRequest, "encashmentDay");
		int forwardDay = ParamUtil.getInteger(actionRequest, "forwardDay");
		int encashmentPer = ParamUtil.getInteger(actionRequest, "encashmentPer");
		int minServiceDay = ParamUtil.getInteger(actionRequest, "minServiceDay");
		int noticeDay = ParamUtil.getInteger(actionRequest, "noticeDay");
		int employeeTypeId = ParamUtil.getInteger(actionRequest, "employeeTypeId");
		int maxCreditDay = ParamUtil.getInteger(actionRequest, "maxCreditDay");
		String gender = ParamUtil.getString(actionRequest, "gender", StringPool.BLANK);
		System.out.println("Gender"+gender);
		String maritalStatus = ParamUtil.getString(actionRequest, "maritalStatus", StringPool.BLANK);
		System.out.println("maritalStatus......"+maritalStatus);
		int impectOnSalary = ParamUtil.getInteger(actionRequest, "impectOnSalary");
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);

		if (Validator.isNull(leaveName)) {
			errorlist.add("Please Enter a Name");
		}
		if (Validator.isNull(abb)) {
			errorlist.add("Leave Abbreviation name is required");
		}
		if (Validator.isNull(String.valueOf(encashmentDay))) {

			errorlist.add("Max Days Encashment is required");
		}
		if (Validator.isNull(encashmentPer)) {

			errorlist.add("Encashment Formula(% of basic) is required");
		}
		if (Validator.isNull(minServiceDay)) {

			errorlist.add("Min Service is required");
		}

		if (Validator.isNull(noticeDay)) {
			errorlist.add("Notice_day is required");
		}
		if (Validator.isNull(maxCreditDay)) {
			errorlist.add("Max Credit Day is required");
		}
		DynamicQuery dynamicQuery = LeaveTypeLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("leaveName").eq(leaveName));

		List<LeaveType> list = LeaveTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
		boolean bFlg = false;
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			for (LeaveType leaveType : list) {
				if (leaveType.getLeaveTypeId() != leaveTypeId) {
					bFlg = true;
				}
			}
		}
		if (bFlg) {
			errorlist.add("Given Leave Name already exist");
		}
		if (errorlist.size() == 0) {
			//LeaveType obj = null;
			try {
				LeaveType leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);

				leaveType.setLeaveName(leaveName);
				leaveType.setAbb(abb);
				leaveType.setEncashmentDay(encashmentDay);
				leaveType.setForwardDay(forwardDay);
				leaveType.setEncashmentPer(encashmentPer);
				leaveType.setMinServiceDay(minServiceDay);
				leaveType.setNoticeDay(noticeDay);
				leaveType.setEmployeetypeId(employeeTypeId);
				leaveType.setMaxCreditDay(maxCreditDay);
				leaveType.setGender(gender);
				leaveType.setMaritalStatus(maritalStatus);
				leaveType.setImpectOnSalary(impectOnSalary);
				leaveType.setCompanyId(employee.getCompanyId());

				Date date = new Date(); // Local Date fetch
				//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				//String strDate = formatter.format(date);
				leaveType.setAddedDate(date);

				LeaveTypeLocalServiceUtil.updateLeaveType(leaveType);

			} catch (Exception e) {
				e.printStackTrace();
			}
			/*if (obj != null) {
				SessionErrors.add(actionRequest, "error");
				
			} else {
				SessionMessages.add(actionRequest, "success");
				 SessionMessages.add(actionRequest,
				 PortalUtil.getPortletId(actionRequest)+ SessionMessages.
				 KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}*/
		} else {
			try {
				HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
				httpRequest.setAttribute("errorList", errorlist);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			} catch (WindowStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	//DELETE METHOD.........................................
	@ProcessAction(name = "deleteLeave")
	public void deleteLeave(ActionRequest actionRequest, ActionResponse actionResponse) {
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		System.out.println("leave Id>>>" + leaveTypeId);
		String leaveName = "";
		List<LeaveApply> leaveApp = new ArrayList<LeaveApply>();
		leaveApp = LeaveApplyLocalServiceUtil.getLeaveApplies(-1, -1);
		
		DynamicQuery leaveListQuery = LeaveApplyLocalServiceUtil.dynamicQuery();
		leaveListQuery.add(PropertyFactoryUtil.forName("leaveTypeId").eq(new Long(leaveTypeId)));
		List<LeaveApply> leaveApplylist = LeaveApplyLocalServiceUtil.dynamicQuery(leaveListQuery);
		System.out.println("List "+leaveApplylist);
		
		// Iterator<LeaveApply> it = leaveApp.iterator();
		String leave_idtmp = String.valueOf(leaveTypeId);
		if(leaveTypeId!=0){
		for (LeaveApply la : leaveApp) {
			//System.out.println("ELSE111>>>" + la.getleaveTypeId());
			// la.getLeave_id();
			if (leave_idtmp.equals(String.valueOf(la.getLeaveApplyId()))) {

				try {
					HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
					//System.out.println("ELSE>>>" + leave_idtmp);
					leaveName = getLeaveName(leaveTypeId);
					httpRequest.setAttribute("error", leaveName + " can not be deleted");
					actionResponse.setWindowState(WindowState.NORMAL);
					SessionErrors.add(actionRequest, "delete-error");
				} catch (WindowStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					LeaveType leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
					if(leaveType!=null){
						LeaveTypeLocalServiceUtil.deleteLeaveType(leaveType);
					// SessionMessages.add(actionRequest, "delete-success");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try{
				actionResponse.sendRedirect("/view.jsp");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		}
	}
	public String getLeaveName(long leaveTypeId) {
		String leaveName = "";
		try {
			LeaveType leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
			leaveName = leaveType.getLeaveName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveName;
	}
	
	@ProcessAction(name="updateStatus")
	public void updateStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException, WindowStateException{
		
		List<LeaveApplyDtl> leaveList = new ArrayList<>();
		String leaveApplyId = ParamUtil.getString(actionRequest, "leaveApplyId",StringPool.BLANK );
		String comments = ParamUtil.getString(actionRequest, "comment",StringPool.BLANK);
		String status = ParamUtil.getString(actionRequest, "status",StringPool.BLANK);
		try{
			DynamicQuery employeeListQuery = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
			Criterion criterion3 = null;
			criterion3 = RestrictionsFactoryUtil.eq("leaveApplyId",Long.valueOf(leaveApplyId));
			employeeListQuery.add(criterion3);
			leaveList = LeaveApplyDtlLocalServiceUtil.dynamicQuery(employeeListQuery);
			System.out.println("::leaveList::"+leaveList);
			LeaveApplyDtl applyDtl =null;
			for(LeaveApplyDtl obj : leaveList){
				System.out.println("obj.getLeaveApplyDtlId()::"+obj.getLeaveApplyDtlId());
					applyDtl = LeaveApplyDtlLocalServiceUtil.getLeaveApplyDtl(obj.getLeaveApplyDtlId());	
					applyDtl.setIsApprove(Integer.valueOf(status));
					LeaveApplyDtlLocalServiceUtil.updateLeaveApplyDtl(applyDtl);
				}
			
		}catch(Exception e){
			
		}
		
		LeaveApply leaveApply =null;
		if(Validator.isNotNull(leaveApplyId)){
			leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(Long.valueOf(leaveApplyId));
			leaveApply.setStatus(Integer.valueOf(status));
			leaveApply.setIsApprove(Integer.valueOf(status));
			leaveApply.setHrComments(comments);
			LeaveApplyLocalServiceUtil.updateLeaveApply(leaveApply);
			
		}
		actionResponse.setWindowState(WindowState.NORMAL);
		actionResponse.setRenderParameter("jspPage", "/META-INF/resources/displayAllLeave.jsp");
	}
	@ProcessAction(name="employeeLeaveList")
	public void employeeLeaveList(ActionRequest actionRequest,ActionResponse actionResponse){
		String selectEmployee = ParamUtil.getString(actionRequest, "selectEmployee", StringPool.BLANK);
		String fromDate = ParamUtil.getString(actionRequest, "fromDate", StringPool.BLANK);
		String toDate = ParamUtil.getString(actionRequest, "toDate", StringPool.BLANK);
		actionResponse.setRenderParameter("jspPage", "/displayAllLeave.jsp");
		SessionMessages.add(actionRequest,
		PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
}