package com.liferay.famocom.erpcloud.allrecruit.portlet;

import com.liferay.famocom.erpcloud.allrecruit.constants.AllRecruitPortletKeys;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AllRecruit Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AllRecruitPortletKeys.AllRecruit,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllRecruitPortlet extends MVCPortlet {
	public void interviewAdd(ActionRequest actionRequest, ActionResponse actionResponse) {
		long recruitProcessId = ParamUtil.getLong(actionRequest, "recruitProcessId");
		System.out.println("recruitProcessId"+recruitProcessId);
		String adminRemark = ParamUtil.get(actionRequest, "adminRemark",StringPool.BLANK);
		System.out.println("adminRemark"+adminRemark);
		boolean isSelect = ParamUtil.getBoolean(actionRequest, "isSelect");
		System.out.println("isSelect"+isSelect);
		try{
		RecruitProcess processAdd= RecruitProcessLocalServiceUtil.getRecruitProcess(recruitProcessId);
		processAdd.setHrRemarks(adminRemark);
		processAdd.setIsSelected(isSelect);
		RecruitProcessLocalServiceUtil.updateRecruitProcess(processAdd);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}