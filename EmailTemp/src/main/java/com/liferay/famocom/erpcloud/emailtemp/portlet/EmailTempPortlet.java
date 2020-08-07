package com.liferay.famocom.erpcloud.emailtemp.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.emailtemp.constants.EmailTempPortletKeys;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;
import javax.xml.bind.ValidationEvent;

import org.osgi.service.component.annotations.Component;

/**
 * @author raj
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmailTemp Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmailTempPortletKeys.EmailTemp,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmailTempPortlet extends MVCPortlet {
	public void emailTempAdd(ActionRequest actionRequest, ActionResponse actionResponse) {
		String templateName = ParamUtil.getString(actionRequest, "templateName");
		System.out.println("templateName" + templateName);
		String emailFor = ParamUtil.getString(actionRequest, "emailFor");
		System.out.println("emailFor" + emailFor);
		String templateBody = ParamUtil.getString(actionRequest, "templateBody");
		System.out.println("templateBody" + templateBody);
		//String editor = actionRequest.getParameter("htmlCodeFromEditorPlacedHere");

		long id = CounterLocalServiceUtil.increment(EmailTemplate.class.getName());
		EmailTemplate emailTemplate = EmailTemplateLocalServiceUtil.createEmailTemplate(id);
		emailTemplate.setTemplateName(templateName);
		emailTemplate.setEmailFor(emailFor);
		emailTemplate.setTemplateBody(templateBody);
		//emailTemplate.setTemplateBody(editor);
		// current date...
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		emailTemplate.setCreatedBy(date);
		emailTemplate.setStatus(true);
		EmailTemplateLocalServiceUtil.addEmailTemplate(emailTemplate);

	}
	//@ProcessAction(name = "email")
	public void emailTempEdit(ActionRequest actionRequest, ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest, "id");
		String templateName = ParamUtil.getString(actionRequest, "templateName");
		//System.out.println("templateName" + templateName);
		//String emailFor = ParamUtil.getString(actionRequest, "emailFor");
		//System.out.println("emailFor" + emailFor);
		//String editor = actionRequest.getParameter("htmlCodeFromEditorPlacedHere");
		String templateBody = ParamUtil.getString(actionRequest, "templateBody");
		//System.out.println("templateBody" + templateBody);
		
	
		    
		try{
			EmailTemplate emailTemplateEdit = EmailTemplateLocalServiceUtil.getEmailTemplate(id);
			emailTemplateEdit.setTemplateName(templateName);
			//emailTemplateEdit.setEmailFor(emailFor);
			emailTemplateEdit.setTemplateBody(templateBody);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate = formatter.format(date);
			emailTemplateEdit.setModifiedBy(date);
			//emailTemplateEdit.setTemplateBody(editor);
			EmailTemplateLocalServiceUtil.updateEmailTemplate(emailTemplateEdit);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@ProcessAction(name = "emailTempRestore")
	public void emailTempRestore(ActionRequest actionRequest, ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest,"id");
		String restoreTemplateBody=null;
		//EmailTemplate emailRestore
		try{
			if(Validator.isNotNull(id)){
			EmailTemplate emailRestore = EmailTemplateLocalServiceUtil.getEmailTemplate(id);
			restoreTemplateBody=emailRestore.getRestoreTemplateBody();
			if(!restoreTemplateBody.isEmpty()){
				emailRestore.setTemplateBody(restoreTemplateBody);
				//emailDelete = EmailTemplateLocalServiceUtil.getEmailTemplate(id);
				EmailTemplateLocalServiceUtil.updateEmailTemplate(emailRestore);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
			} 
}