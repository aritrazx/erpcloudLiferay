package com.liferay.famocom.erpcloud.branch.list.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.branch.list.constants.BranchListPortletKeys;
import com.liferay.famocom.erpcloud.model.Branch;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.LeaveManagement;
import com.liferay.famocom.erpcloud.service.BranchLocalService;
import com.liferay.famocom.erpcloud.service.BranchLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalService;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveManagementLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

/**
 * @author aritrazx
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=BranchList Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BranchListPortletKeys.BranchList, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class BranchListPortlet extends MVCPortlet {
	@ProcessAction(name = "addBranch")
	public void addBranch(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, ParseException {
		System.out.println("Call ADDDD");
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		String branchName = ParamUtil.getString(actionRequest, "branchName", StringPool.BLANK);
		System.out.println("branchName"+branchName);
		String branchAddress = ParamUtil.getString(actionRequest, "branchAddress", StringPool.BLANK);
		String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		try {
			long branchId = CounterLocalServiceUtil.increment(Branch.class.getName());
			Branch branch = BranchLocalServiceUtil.createBranch(branchId);
			System.out.println("branchId"+branchId);

			branch.setBranchName(branchName);
			branch.setBranchAddress(branchAddress);
			branch.setStatus(Integer.valueOf(status));

			Date date = new Date(); // Local Date fetch
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = formatter.format(date);
			branch.setCreateDate(date);
			branch.setCreatedById(employee.getEmployeeId());
			
			BranchLocalServiceUtil.addBranch(branch);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@ProcessAction(name = "editBranch")
	public void editBranch(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, ParseException {
		System.out.println("Call   Edit ");
		
		String branchName = ParamUtil.getString(actionRequest, "branchName", StringPool.BLANK);
		System.out.println("branchName"+branchName);
		String branchAddress = ParamUtil.getString(actionRequest, "branchAddress", StringPool.BLANK);
		String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		String branchId = ParamUtil.getString(actionRequest, "branchId",StringPool.BLANK);
		System.out.println("branchId :::::::"+branchId);
		try {
			Branch branch = BranchLocalServiceUtil.getBranch(Long.valueOf(branchId));
			
			branch.setBranchName(branchName);
			branch.setBranchAddress(branchAddress);
			branch.setStatus(Integer.valueOf(status));

			Date date = new Date(); // Local Date fetch
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = formatter.format(date);
			branch.setModifiedDate(date);
			
			BranchLocalServiceUtil.updateBranch(branch);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	/*@ProcessAction(name = "activate")
	public void activate(ActionRequest actionRequest, ActionResponse actionResponse) {
		String branchId = ParamUtil.getString(actionRequest,"branchId",StringPool.BLANK);
		try {
			Branch branch = null;
			if (Validator.isNotNull(branchId)) {
				branch = BranchLocalServiceUtil.getBranch(Long.valueOf(branchId));
				branch.setStatus(1);
				BranchLocalServiceUtil.updateBranch(branch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}