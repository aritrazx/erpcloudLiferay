package com.liferay.famocom.erpcloud.traveldeskmanager.portlet;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.TravelDeskDetails;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.traveldeskmanager.constants.TraveldeskManagerPortletKeys;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TraveldeskManager Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TraveldeskManagerPortletKeys.TraveldeskManager,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TraveldeskManagerPortlet extends MVCPortlet {
	@ProcessAction(name="travelDeskManager")
	public void travelDeskManager(ActionRequest actionRequest, ActionResponse actionResponse) throws AddressException, PortalException {
		long travelId = ParamUtil.getLong(actionRequest, "travelId");
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
		String location = ParamUtil.getString(actionRequest, "location", StringPool.BLANK);
		System.out.println("travelId in java..."+travelId);
		String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		String comment = ParamUtil.getString(actionRequest, "comment", StringPool.BLANK);
		try {
			TravelDeskDetails tdd = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
					tdd.setManagerComment(comment);
					tdd.setStatus(Integer.parseInt(status));
					TravelDeskDetailsLocalServiceUtil.updateTravelDeskDetails(tdd);
		} catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/*public void approve(ActionRequest actionRequest, ActionResponse actionResponse) {
		long travelId = ParamUtil.getLong(actionRequest, "travelId");
		String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
		try {
			TravelDeskDetails tdd = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
			tdd.setStatus(Integer.valueOf(status));
			TravelDeskDetailsLocalServiceUtil.updateTravelDeskDetails(tdd);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void reject(ActionRequest actionRequest, ActionResponse actionResponse) {
			long travelId = ParamUtil.getLong(actionRequest, "travelId");
			String status = ParamUtil.getString(actionRequest, "status", StringPool.BLANK);
			try {
				TravelDeskDetails tdd = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
				tdd.setStatus(Integer.valueOf(status));
				TravelDeskDetailsLocalServiceUtil.updateTravelDeskDetails(tdd);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
	
	/*public void approve(long travelId, String status, String comment){
		try {
			TravelDeskDetails tdd = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
			tdd.setStatus(Integer.valueOf(status));
			tdd.setManagerComment(comment);
			TravelDeskDetailsLocalServiceUtil.updateTravelDeskDetails(tdd);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reject(long travelId, String status, String comment){
		try {
			TravelDeskDetails tdd = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
			tdd.setStatus(Integer.valueOf(status));
			tdd.setManagerComment(comment);
			TravelDeskDetailsLocalServiceUtil.updateTravelDeskDetails(tdd);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}