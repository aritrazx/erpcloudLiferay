package com.liferay.famocom.erpcloud.accountslist.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.accountslist.constants.AccountsListPortletKeys;
import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.model.Billing;
import com.liferay.famocom.erpcloud.model.BillingTable;
import com.liferay.famocom.erpcloud.model.Milestone;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.BillingLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.BillingTableLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AccountsList Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AccountsListPortletKeys.AccountsList,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AccountsListPortlet extends MVCPortlet {
/*	@Override
	public void render(RenderRequest rendRequest, RenderResponse rendResponse) throws IOException, PortletException{
		String redirestjspPage = ParamUtil.getString(rendRequest, "jspPage");
		System.out.println("render respon18===>"+redirestjspPage);
		List<BillingTable>  bt = BillingTableLocalServiceUtil.getBillingTables(-1,-1);
		rendRequest.setAttribute("billing", bt);
		super.render(rendRequest, rendResponse);
	}*/
	
	public void addBilling(ActionRequest actionRequest, ActionResponse actionResponse) {
		String milestoneId = ParamUtil.getString(actionRequest, "milestoneId",StringPool.BLANK);
		System.out.println("milestoneId:----"+milestoneId);
		String billNumber = ParamUtil.getString(actionRequest, "billNumber",StringPool.BLANK);
		String billingDate = ParamUtil.getString(actionRequest,"billingDate",StringPool.BLANK);
		try{
			Milestone milestoneObj = MilestoneLocalServiceUtil.getMilestone(Long.parseLong(milestoneId));
			long billingId = CounterLocalServiceUtil.increment(Billing.class.getName());
			Billing billingObj = BillingLocalServiceUtil.createBilling(billingId);
			billingObj.setMilestoneId(Long.parseLong(milestoneId));
			billingObj.setBillingDate(billingDate);
			billingObj.setBillingNumber(billNumber);
			milestoneObj.setStatus(1);
			BillingLocalServiceUtil.addBilling(billingObj);
			Milestone milestone =MilestoneLocalServiceUtil.updateMilestone(milestoneObj);
			if(milestone!=null){
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/thankYou.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}