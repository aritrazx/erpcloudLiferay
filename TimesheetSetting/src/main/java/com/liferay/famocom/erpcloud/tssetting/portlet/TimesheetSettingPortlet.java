package com.liferay.famocom.erpcloud.tssetting.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.CompanyPolicy;
import com.liferay.famocom.erpcloud.service.CompanyPolicyLocalServiceUtil;
import com.liferay.famocom.erpcloud.tssetting.constants.TimesheetSettingPortletKeys;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author hussh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TimesheetSetting Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TimesheetSettingPortletKeys.TimesheetSetting,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TimesheetSettingPortlet extends MVCPortlet {
	
	@ProcessAction(name = "companyPolicy")
	public void companyPolicy(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay td =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
		long userId = td.getUserId();
		String lockingEvent = ParamUtil.getString(actionRequest, "lockingEvent", StringPool.BLANK);
		String checkStatus = ParamUtil.getString(actionRequest, "checkStatus", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		List<CompanyPolicy> cpList = CompanyPolicyLocalServiceUtil.getCompanyPolicies(-1, -1);
		DynamicQuery dynamicQuery = CompanyPolicyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
		dynamicQuery.add(criterion3);
		cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery);
		try {
			long companyPolicyId = CounterLocalServiceUtil.increment(CompanyPolicy.class.getName());
			CompanyPolicy cp = CompanyPolicyLocalServiceUtil.createCompanyPolicy(companyPolicyId);
			cp.setDaysLocking(Integer.parseInt(lockingEvent));
			cp.setCheckStatus(Integer.parseInt(checkStatus));
			cp.setAddedDate(date);
			if(cpList.size()==0){
			CompanyPolicyLocalServiceUtil.addCompanyPolicy(cp);
			} else {
				SessionErrors.add(actionRequest, "error");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@ProcessAction(name = "updateCompanyPolicy")
	public void updateCompanyPolicy(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay td =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
		long userId = td.getUserId();
		long companyPolicyId = ParamUtil.getLong(actionRequest, "companyPolicyId");
		System.out.println("companyPolicyId in edit...."+companyPolicyId);
		String lockingEvent = ParamUtil.getString(actionRequest, "lockingEvent", StringPool.BLANK);
		String checkStatus = ParamUtil.getString(actionRequest, "checkStatus", StringPool.BLANK);
		Date date = new Date(); // Local Date fetch
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		List<CompanyPolicy> cpList = CompanyPolicyLocalServiceUtil.getCompanyPolicies(-1, -1);
		DynamicQuery dynamicQuery = CompanyPolicyLocalServiceUtil.dynamicQuery();
		Criterion criterion3 = null;
		criterion3 = RestrictionsFactoryUtil.eq("companyId", td.getCompanyId());
		dynamicQuery.add(criterion3);
		cpList = CompanyPolicyLocalServiceUtil.dynamicQuery(dynamicQuery);
		try {
			CompanyPolicy cp = CompanyPolicyLocalServiceUtil.getCompanyPolicy(companyPolicyId);
			cp.setDaysLocking(Integer.parseInt(lockingEvent));
			cp.setCompanyId(td.getCompanyId());
			cp.setCheckStatus(Integer.parseInt(checkStatus));
			cp.setModifiedDate(date);
			CompanyPolicyLocalServiceUtil.updateCompanyPolicy(cp);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}