/*package com.liferay.famocom.erpcloud.scedulerentry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

public class BirthdayScedulerEntry {
	
	

}
@Component(immediate = true, property = {
		"cron.expression=0 0/1 * 1/1 * ? *" }, service = BirthdaySchedulerEntryMessageListener.class)
public class BirthdaySchedulerEntryMessageListener extends BaseSchedulerEntryMessageListener {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		String cronExpression = GetterUtil.getString(properties.get("cron.expression"), _DEFAULT_CRON_EXPRESSION);
		Trigger jobTrigger = TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),
				cronExpression);

		schedulerEntryImpl.setTrigger(jobTrigger);

		_schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	}

	private final Log _log = LogFactoryUtil.getLog(BirthdaySchedulerEntryMessageListener.class);
 
	@Reference(unbind = "-")
	private volatile SchedulerEngineHelper _schedulerEngineHelper;

	private static final String _DEFAULT_CRON_EXPRESSION = "0 0/1 * 1/1 * ? *";

	@Override
	protected void doReceive(Message message) throws Exception {

		System.out.println("Sceduler Executed");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Sceduler Executed dtf.format(now) " + dtf.format(now));
		String date = dtf.format(now);
		String[] arrOfStr = date.split("-");
		String currentDay = arrOfStr[0];
		String currentMonth = arrOfStr[1];
		System.out.println("arrOfStr1 : " + arrOfStr[0] + "..arrOfStr2 : " + arrOfStr[1]);

		List<Employee> empList =EmployeeLocalServiceUtil.getEmployees(-1,-1);
		for (Employee emp : empList) {
			System.out.println("inside for loop : " + emp.getDateOfBirth());
			String dob = df.format(emp.getDateOfBirth());
			String[] arrOfDob = dob.split("-");
			String birthDay = arrOfDob[0];
			String birthMonth = arrOfDob[1];
			String empFullName = "";
			System.out.println("before happy bday");
			if(birthDay.equalsIgnoreCase(currentDay) && birthMonth.equalsIgnoreCase(currentMonth)){
				empFullName = emp.getFirstName()+" "+emp.getLastName();
				System.out.println("inside loop...Happy birthday");
				Company company = null;
				String fromAddress = "";
				String fromName = "";
				String toAddress = "";
				//String ccAddress = "santanu.manna@famocom.com";
				String emailFor ="birthday";
				String body = "";
				String messageBody = "";
				toAddress = emp.getEmaiAddress();
				try {
					company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
				} catch (PortalException e1) {
					e1.printStackTrace();
				}
				long companyId = company.getCompanyId();
				
				EmailTemplate eTemplate = EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
				body = eTemplate.getTemplateBody();
				messageBody = body.replace("$NAME", empFullName);
				System.out.println("inside loop...body --- "+messageBody);
				
				//String authId = PrefsPropsUtil.getString(companyId, "mail.session.mail.smtp.user");
				//String authPass = PrefsPropsUtil.getString(companyId, "mail.session.mail.smtp.password");
				fromName = PrefsPropsUtil.getString(companyId, "admin.email.from.name");
				fromAddress = PrefsPropsUtil.getString(companyId, "admin.email.from.address");
				System.out.println("fromName :"+fromName+" fromAddress :"+fromAddress);
				
				InternetAddress[] to = { new InternetAddress(toAddress) };
				//InternetAddress[] cc = { new InternetAddress(ccAddress) };
				InternetAddress from = new InternetAddress(fromAddress);
				
				MailMessage mailMessage = new MailMessage();
				mailMessage.setFrom(from);
				mailMessage.setTo(to);
	    		mailMessage.setSubject("Wishing Happy Birthday to "+empFullName);
	    		mailMessage.setBody(messageBody);
	    		mailMessage.setHTMLFormat(true);
	    		//mailMessage.setCC(cc);
	    		MailServiceUtil.sendEmail(mailMessage);
			}
		}
		
		
	}

}
*/