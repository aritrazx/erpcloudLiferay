package com.liferay.famocom.erpcloud.client.master.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.client.master.constants.ClientMasterPortletKeys;
import com.liferay.famocom.erpcloud.model.ClientMaster;
import com.liferay.famocom.erpcloud.model.LeaveApply;
import com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author aritrazx
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=ClientMaster Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ClientMasterPortletKeys.ClientMaster, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ClientMasterPortlet extends MVCPortlet {

	@ProcessAction(name = "addClientMaster")
	public void addClientMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("callll adddd");
		String clientName = ParamUtil.getString(actionRequest, "clientName", StringPool.BLANK);
		System.out.println("clientName"+clientName);
		String officeAddress = ParamUtil.getString(actionRequest, "officeAddress", StringPool.BLANK);
		String billingAddress = ParamUtil.getString(actionRequest, "billingAddress", StringPool.BLANK);
		int contactNumber = ParamUtil.getInteger(actionRequest, "contactNumber");
		String emailId = ParamUtil.getString(actionRequest, "emailId", StringPool.BLANK);
		String contactPerson = ParamUtil.getString(actionRequest, "contactPerson", StringPool.BLANK);
		String skypeId = ParamUtil.getString(actionRequest, "skypeId", StringPool.BLANK);
		long gstNo = ParamUtil.getLong(actionRequest, "gstNo");
		System.out.println("gstNo"+gstNo);
		String panNo = ParamUtil.getString(actionRequest, "panNo",StringPool.BLANK);
		String bankName = ParamUtil.getString(actionRequest, "bankName",StringPool.BLANK);
		String branchName = ParamUtil.getString(actionRequest, "branchName",StringPool.BLANK);
		long bankAccountNumber = ParamUtil.getLong(actionRequest, "bankAccountNumber");
		String bankAccountType = ParamUtil.getString(actionRequest, "bankAccountType",StringPool.BLANK);
		String ifscCode = ParamUtil.getString(actionRequest, "ifscCode",StringPool.BLANK);
		
			try{
			long clientId = CounterLocalServiceUtil.increment(ClientMaster.class.getName());
			ClientMaster clientMaster = ClientMasterLocalServiceUtil.createClientMaster(clientId);
			System.out.println("clientId :::::::"+clientId);

			clientMaster.setClientName(clientName);
			clientMaster.setOfficeAddress(officeAddress);
			System.out.println("clientId111");
			clientMaster.setBillingAddress(billingAddress);
			System.out.println("clientId222"+billingAddress);
			clientMaster.setContactNumber(contactNumber);
			System.out.println("clientId222");
			clientMaster.setEmailId(emailId);
			clientMaster.setContactPerson(contactPerson);
			System.out.println("clientId333");
			clientMaster.setGstNo(gstNo);
			if(Validator.isNotNull(skypeId)){
				clientMaster.setSkypeId(skypeId);
			}
			System.out.println("clientId444");
			clientMaster.setPanNo(panNo);
			clientMaster.setBankName(bankName);
			clientMaster.setBranchName(branchName);
			clientMaster.setBankAccountNumber(bankAccountNumber);
			clientMaster.setBankAccountType(bankAccountType);
			clientMaster.setIfscCode(ifscCode);
			
			Date date = new Date(); // Local Date fetch
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = formatter.format(date);
			clientMaster.setAddedDate(date);

			ClientMasterLocalServiceUtil.addClientMaster(clientMaster);
			System.out.println("value Inserted Sucessfully");
			//actionResponse.sendRedirect("/index.jsp");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			// TODO: handle exception
		
	}
	@ProcessAction(name = "editClientMaster")
	public void editClientMaster(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("callll Edit");
		String clientId = ParamUtil.getString(actionRequest, "clientId",StringPool.BLANK);
		String clientName = ParamUtil.getString(actionRequest, "clientName", StringPool.BLANK);
		System.out.println("clientName "+clientName);
		String officeAddress = ParamUtil.getString(actionRequest, "officeAddress", StringPool.BLANK);
		String billingAddress = ParamUtil.getString(actionRequest, "billingAddress", StringPool.BLANK);
		String contactNumber = ParamUtil.getString(actionRequest, "contactNumber", StringPool.BLANK);
		String emailId = ParamUtil.getString(actionRequest, "emailId", StringPool.BLANK);
		String contactPerson = ParamUtil.getString(actionRequest, "contactPerson", StringPool.BLANK);
		String skypeId = ParamUtil.getString(actionRequest, "skypeId", StringPool.BLANK);
		String gstNo = ParamUtil.getString(actionRequest, "gstNo", StringPool.BLANK);
		String panNo = ParamUtil.getString(actionRequest, "panNo",StringPool.BLANK);
		String bankName = ParamUtil.getString(actionRequest, "bankName",StringPool.BLANK);
		String branchName = ParamUtil.getString(actionRequest, "branchName",StringPool.BLANK);
		String bankAccountNumber = ParamUtil.getString(actionRequest, "bankAccountNumber",StringPool.BLANK);
		String bankAccountType = ParamUtil.getString(actionRequest, "bankAccountType",StringPool.BLANK);
		String ifscCode = ParamUtil.getString(actionRequest, "ifscCode",StringPool.BLANK);
		try{
			ClientMaster clientMaster = ClientMasterLocalServiceUtil.getClientMaster(Long.valueOf(clientId));
			
			clientMaster.setClientName(clientName);
			clientMaster.setOfficeAddress(officeAddress);
			clientMaster.setBillingAddress(billingAddress);
			clientMaster.setContactNumber(Integer.valueOf(contactNumber));
			clientMaster.setEmailId(emailId);
			clientMaster.setContactPerson(contactPerson);
			clientMaster.setGstNo(Long.valueOf(gstNo));
			clientMaster.setPanNo(panNo);
			clientMaster.setBankName(bankName);
			clientMaster.setBranchName(branchName);
			clientMaster.setBankAccountNumber(Long.valueOf(bankAccountNumber));
			clientMaster.setBankAccountType(bankAccountType);
			clientMaster.setIfscCode(ifscCode);
			
			Date date = new Date(); // Local Date fetch
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = formatter.format(date);
			clientMaster.setAddedDate(date);
			
			ClientMasterLocalServiceUtil.updateClientMaster(clientMaster);
			actionResponse.sendRedirect("/index.jsp");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}