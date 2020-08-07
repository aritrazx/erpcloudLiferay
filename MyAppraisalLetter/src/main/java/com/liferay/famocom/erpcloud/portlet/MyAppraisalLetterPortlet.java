package com.liferay.famocom.erpcloud.portlet;

import com.liferay.famocom.erpcloud.constants.MyAppraisalLetterPortletKeys;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.PayrollIncrement;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayrollIncrementLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Samaresh Barui
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MyAppraisalLetter Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyAppraisalLetterPortletKeys.MyAppraisalLetter,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyAppraisalLetterPortlet extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		long employeeId = ParamUtil.getLong(resourceRequest, "employeeId");
		long appraisalSettingId = ParamUtil.getLong(resourceRequest, "appraisalSettingId");
		if (cmd.equals("exportToPdf")) {
			try {
				exportToPdf(resourceRequest, resourceResponse, employeeId, appraisalSettingId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void exportToPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse, long employeeId,
			long appraisalSettingId) throws ServletException, IOException, SystemException, ParseException,
			SystemException, PortletException, PortalException {

		DateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
		Date date = null;
		Calendar calendar = null;

		Employee employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		long employeeCode = employee.getEmployeeCode();
		Date joiningDate = employee.getDateOfJoing();

		AppraisalSetup appraisalSetup = AppraisalSetupLocalServiceUtil.getAppraisalSetup(appraisalSettingId);
		String financialYear = appraisalSetup.getFinancialYear();

		AppraisalMaster appraisalMaster = AppraisalMasterLocalServiceUtil
				.findBySettingIdAndEmployeeId(appraisalSettingId, employeeId);

		RatingMaster ratingMaster = RatingMasterLocalServiceUtil.getRatingMaster(appraisalMaster.getOverallRatingMan());
		String ratingKey = ratingMaster.getRatingKey();

		Calendar startCalendar = new GregorianCalendar();
		Calendar endCalendar = new GregorianCalendar();
		int diffMonth = 0;
		int diffYear = 0;
		List<PayComponent> payComponentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);

		double totalPay = 0;
		double annualCTC = 0;
		double bonusVal = 0;
		Date fromDateCycle = null;
		Date toDateCycle = null;
		Date fromDate = null;
		String strFromDateCycle = "";
		String strToDateCycle = "";
		long noOfMonths = 0;

		OutputStream outputStream = null;

		try {
			outputStream = resourceResponse.getPortletOutputStream();

			URL jasperURL = Thread.currentThread().getContextClassLoader().getResource("letter.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperURL);

			Map<String, String> fields = new HashMap<String, String>();

		//	JRMapArrayDataSource dataSource = new JRMapArrayDataSource(new Object[] { fields });
			List<PayComponent> components = new ArrayList<PayComponent>();

			Map<String, Object> parameters = new HashMap<>();
			
			if (Validator.isNotNull(employee)) {
				parameters.put("EMPCODE", employee.getEmployeeCode());
				parameters.put("EMPNAME", employee.getFirstName() + " " + employee.getLastName());
			}

			fromDateCycle = appraisalSetup.getFromDateCycle();
			toDateCycle = appraisalSetup.getToDateCycle();
			if (joiningDate.before(fromDateCycle)) {
				fromDate = fromDateCycle;
				strFromDateCycle = dateFormat.format(fromDate);
				strToDateCycle = dateFormat.format(toDateCycle);
				startCalendar.setTime(fromDate);
				endCalendar.setTime(toDateCycle);
				diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
				diffMonth = (diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH)) + 1;
				System.out.println("diffMonth if: " + diffMonth + "diffYear else: " + diffYear);
			} else if (joiningDate.after(fromDateCycle)) {
				fromDate = joiningDate;
				strFromDateCycle = dateFormat.format(fromDate);
				strToDateCycle = dateFormat.format(toDateCycle);
				startCalendar.setTime(fromDate);
				endCalendar.setTime(toDateCycle);
				System.out.println("diffMonth else: " + diffMonth + "diffYear else: " + diffYear);
				diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
				diffMonth = (diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH)) + 1;
				System.out.println("diffMonth else: " + diffMonth + "diffYear else: " + diffYear);
			}

			
			for (PayComponent component : payComponentList) {
				PayComponent payComponent = PayComponentLocalServiceUtil.getPayComponent(component.getComponentId());
				PayrollIncrement payrollIncrement = PayrollIncrementLocalServiceUtil
						.findByEmployeeIdComponentIdFinancialYear(employeeId, component.getComponentId(),
								financialYear);
				if (payrollIncrement != null) {
					System.out.print("payrollIncrement.getPostHeadComponentVal() : "
							+ payrollIncrement.getPostHeadComponentVal()+"..component.getName().."+component.getName());

					totalPay = totalPay + payrollIncrement.getPostHeadComponentVal();
					bonusVal = payrollIncrement.getBonusVal();
					
					payComponent.setName(component.getName());
					payComponent.setAmount(payrollIncrement.getPostHeadComponentVal());
					components.add(payComponent);
					System.out.println("components list size.."+components.size());
					 // component.getName()
					// payrollIncrement.getPostHeadComponentVal()

				}
			}
			
			annualCTC = totalPay * 12; 
			
			parameters.put("NOOFMONTHS", diffMonth);
			parameters.put("FROMDATECYCLE", strFromDateCycle);
			parameters.put("TODATECYCLE", strToDateCycle);
			parameters.put("RATINGKEY", ratingKey);
			parameters.put("GROSSSALARY", totalPay);
			parameters.put("BONUS", bonusVal);
			parameters.put("CTCANNUAL", annualCTC);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(components);

			resourceResponse.setContentType("application/pdf");
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=AppraisalLetter.pdf");

			JasperPrint printer = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			JasperExportManager.exportReportToPdfStream(printer, outputStream);
		} catch (Exception exception) {
			_log.error("Error found writing PDF, ", exception);
			throw new PortletException(exception);
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException exception) {

			}
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(MyAppraisalLetterPortlet.class);
	
}