package com.liferay.famocom.erpcloud.conferenceroom.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.conferenceroom.constants.ConferenceRoomPortletKeys;
import com.liferay.famocom.erpcloud.model.ConferenceRoom;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.service.ConferenceRoomLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ConferenceRoom Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ConferenceRoomPortletKeys.ConferenceRoom,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ConferenceRoomPortlet extends MVCPortlet {
	public void conferenceRoomAdd(ActionRequest actionRequest, ActionResponse actionResponse) {
		String buliding= ParamUtil.get(actionRequest,"buliding",StringPool.BLANK);
		long roomNumber = ParamUtil.getLong(actionRequest, "roomNumber");
		long floorNumber = ParamUtil.getLong(actionRequest, "floorNumber");
		long capacity = ParamUtil.getLong(actionRequest, "capacity");
		String openTime = ParamUtil.getString(actionRequest, "openTime");
		String closeTime = ParamUtil.getString(actionRequest, "closeTime");
		
		try{
		long conferenceRoomId = CounterLocalServiceUtil.increment(ConferenceRoom.class.getName());
		ConferenceRoom cm= ConferenceRoomLocalServiceUtil.createConferenceRoom(conferenceRoomId);
		cm.setRoomNo(roomNumber);
		cm.setBuilding(buliding);
		cm.setFloorNo(floorNumber);
		cm.setCapacity(capacity);
		cm.setOpenTime(openTime);
		cm.setCloseTime(closeTime);
		ConferenceRoomLocalServiceUtil.addConferenceRoom(cm);
		actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void conferenceRoomEdit(ActionRequest actionRequest, ActionResponse actionResponse) {
		long conferenceRoomId =ParamUtil.getLong(actionRequest, "conferenceRoomId");
		String buliding= ParamUtil.get(actionRequest,"buliding",StringPool.BLANK);
		long roomNumber = ParamUtil.getLong(actionRequest, "roomNumber");
		long floorNumber = ParamUtil.getLong(actionRequest, "floorNumber");
		long capacity = ParamUtil.getLong(actionRequest, "capacity");
		String openTime = ParamUtil.getString(actionRequest, "openTime");
		String closeTime = ParamUtil.getString(actionRequest, "closeTime");
		
		try{
			ConferenceRoom roomEdit = ConferenceRoomLocalServiceUtil.getConferenceRoom(conferenceRoomId);
			roomEdit.setRoomNo(roomNumber);
			roomEdit.setBuilding(buliding);
			roomEdit.setFloorNo(floorNumber);
			roomEdit.setCapacity(capacity);
			roomEdit.setOpenTime(openTime);
			roomEdit.setCloseTime(closeTime);
			ConferenceRoomLocalServiceUtil.updateConferenceRoom(roomEdit);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void roomDelete(ActionRequest actionRequest, ActionResponse actionResponse) {
		long conferenceRoomId =ParamUtil.getLong(actionRequest, "conferenceRoomId");
		ConferenceRoom roomDelete = null;
		if (conferenceRoomId != 0) {
			try {
				roomDelete=ConferenceRoomLocalServiceUtil.getConferenceRoom(conferenceRoomId);
				ConferenceRoomLocalServiceUtil.deleteConferenceRoom(roomDelete);
			} catch (Exception e) {
			}
		}
	}
}