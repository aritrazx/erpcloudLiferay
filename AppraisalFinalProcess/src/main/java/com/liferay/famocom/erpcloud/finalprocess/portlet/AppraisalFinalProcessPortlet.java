package com.liferay.famocom.erpcloud.finalprocess.portlet;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.finalprocess.constants.AppraisalFinalProcessPortletKeys;
import com.liferay.famocom.erpcloud.model.AppraisalMaster;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
import com.liferay.famocom.erpcloud.model.EmailTemplate;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.PayrollIncrement;
import com.liferay.famocom.erpcloud.model.PayrollSlabs;
import com.liferay.famocom.erpcloud.model.RatingMaster;
import com.liferay.famocom.erpcloud.service.AppraisalMasterLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayrollIncrementLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayrollSlabsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author Samaresh Barui
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=AppraisalFinalProcess Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AppraisalFinalProcessPortletKeys.AppraisalFinalProcess,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AppraisalFinalProcessPortlet extends MVCPortlet {

	public void appraisalDraftProcess(ActionRequest request, ActionResponse response) {

		long isActive = 1;
		long submitStep = 3;
		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);

		List<AppraisalMaster> appraisalMastersList = new ArrayList<AppraisalMaster>();
		List<EmpPayStructure> empPayStructureList = new ArrayList<EmpPayStructure>();

		appraisalMastersList = AppraisalMasterLocalServiceUtil
				.findBySettingIdAndsubmitStep(setup.getAppraisalSettingId(), submitStep);
		System.out.println("appraisalMastersList : " + appraisalMastersList.size());
		for (AppraisalMaster appraisalMasterObj : appraisalMastersList) {

			empPayStructureList = EmpPayStructureLocalServiceUtil
					.findEmpPayStructureByEmployeeId(appraisalMasterObj.getEmployeeId());
			PayrollIncrement payrollIncrement = null;
			System.out.println("empPayStructureList : " + empPayStructureList);
			double preCtc = 0;
			double incrementValue = 0;
			long bonusVal = 0;
			long postCtc = 0;
			PayrollSlabs payrollSlabs = null;
			double payRollPercentage = 0;
			double bonusPercentage = 0;

			payrollSlabs = PayrollSlabsLocalServiceUtil.findByAppraisalSettingIdRatingId(setup.getAppraisalSettingId(),
					appraisalMasterObj.getOverallRatingMan());
			System.out.println("payrollSlabs : " + payrollSlabs);
			payRollPercentage = payrollSlabs.getPayrollPercentage();
			bonusPercentage = payrollSlabs.getBonusPercentage();
			for (EmpPayStructure empPayStructureObj : empPayStructureList) {
				System.out.println("empPayStructureObj: " + empPayStructureObj);
				preCtc = preCtc + empPayStructureObj.getComponentValue();
			}
			System.out.println("preCtc : " + preCtc);
			incrementValue = (preCtc * payRollPercentage) / 100;
			postCtc = (long) (preCtc + incrementValue);
			bonusVal = (long) ((postCtc * bonusPercentage) / 100);
			System.out.println("postCtc : " + postCtc);

			/*----------------------------------------------------------------------------------*/
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			// String employeeId = ParamUtil.getString(request, "employeeId",
			// StringPool.BLANK);
			List<PayComponent> componentsList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
			HashMap<String, String> componentIdAndformula = new HashMap<>();
			HashMap<String, Double> componentAndAmount = new HashMap<>();
			HashMap<Long, Long> payCompo = new HashMap<>();

/*			for (PayComponent payComponent : componentsList) {
				componentIdAndformula.put(payComponent.getComponentId() + "_", payComponent.getComponentValueFormula());
			}*/
			for (PayComponent payComponent : componentsList) {
				if (payComponent.getComponentType() == 0) {
					componentIdAndformula.put(payComponent.getComponentId() + "_",
							String.valueOf(payComponent.getAmount()));
				} else {
					componentIdAndformula.put(payComponent.getComponentId() + "_",
							payComponent.getComponentValueFormula());
				}

			}
			// replace TotalPay
			for (Map.Entry<String, String> entry : componentIdAndformula.entrySet()) {
				String formula = entry.getValue();

				String equation = formula.replaceAll("TotalPay", String.valueOf(postCtc));
				componentIdAndformula.put(entry.getKey(), equation);
			}
			// replace underscore if amount exist with respect of paycomponent

			/*
			 componentAndAmount = getAmountListByComponentId(componentIdAndformula, componentAndAmount);
			if (componentAndAmount.size() != componentIdAndformula.size()) {
				componentAndAmount = getAmountListByComponentId(componentIdAndformula, componentAndAmount);
				System.out.println("componentAndAmount.......... " + componentAndAmount);
			}
			 */

			boolean isConditionTrue = true;
			for (boolean i = true; i == isConditionTrue;) {
				if (componentAndAmount.size() != componentIdAndformula.size()) {
					componentAndAmount = getAmountListByComponentId(componentIdAndformula, componentAndAmount);
					System.out.println("componentAndAmount.......... " + componentAndAmount);
					isConditionTrue = true;
				} else {
					isConditionTrue = false;
				}
			}

			for (PayComponent payComponent : componentsList) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				if (payComponent.getPayType().equalsIgnoreCase(AppraisalFinalProcessPortletKeys.Earning)) {
					for (Map.Entry<String, Double> entry : componentAndAmount.entrySet()) {
						long id = Long.valueOf(entry.getKey().replaceAll("_", ""));
						System.out.println("id..........earning... " + id);
						if (payComponent.getComponentId() == id) {
							System.out.println("amount........." + entry.getValue());
							jsonObject.put("payType", payComponent.getPayType());
							jsonObject.put("earning", entry.getValue());
							jsonArray.put(jsonObject);
							payCompo.put(payComponent.getComponentId(), Math.round(entry.getValue()));
						}
					}
				}
				if (payComponent.getPayType().equalsIgnoreCase(AppraisalFinalProcessPortletKeys.Deduction)) {
					for (Map.Entry<String, Double> entry : componentAndAmount.entrySet()) {
						long id = Long.valueOf(entry.getKey().replaceAll("_", ""));
						System.out.println("id.........dedcation. " + id);
						if (payComponent.getComponentId() == id) {
							System.out.println("amount........." + entry.getValue());
							jsonObject.put("payType", payComponent.getPayType());
							jsonObject.put("deduction", entry.getValue());
							jsonArray.put(jsonObject);
							payCompo.put(payComponent.getComponentId(), Math.round(entry.getValue()));
						}
					}
				}
			}

			/*-----------------------------------------------------------------------------------*/
			HashMap<Long, Object> payRollMap = new HashMap<>();

			for (EmpPayStructure empPayStructureObj : empPayStructureList) {

				long payComponentId = empPayStructureObj.getPayComponentId();
				double payComponentValue = empPayStructureObj.getComponentValue();
				payRollPercentage = payrollSlabs.getPayrollPercentage();

				long payRollIncId = CounterLocalServiceUtil.increment(PayrollIncrement.class.getName());
				PayrollIncrement increment = PayrollIncrementLocalServiceUtil.createPayrollIncrement(payRollIncId);
				increment.setAppraisalSettingId(setup.getAppraisalSettingId());
				increment.setEmployeeId(appraisalMasterObj.getEmployeeId());
				// increment.setEmployeeCode();
				increment.setOverallRatingMan(appraisalMasterObj.getOverallRatingMan());
				increment.setPreCtc((long) preCtc);
				increment.setPostCtc(postCtc);
				increment.setComponentId(payComponentId);
				increment.setPreHeadComponentVal((long) empPayStructureObj.getComponentValue());
				increment.setBonusVal(bonusVal);
				increment.setFinancialYear(setup.getFinancialYear());
				payrollIncrement = PayrollIncrementLocalServiceUtil.addPayrollIncrement(increment);
				if (payrollIncrement != null) {
					payRollMap.put(payrollIncrement.getPayrollIncrementId(), payrollIncrement);
				}
			}

			for (Map.Entry<Long, Long> entry : payCompo.entrySet()) {

				for (Map.Entry<Long, Object> var : payRollMap.entrySet()) {
					PayrollIncrement payrollIncrementObj = (PayrollIncrement) var.getValue();
					if (payrollIncrementObj.getComponentId() == entry.getKey()) {
						payrollIncrementObj.setPostHeadComponentVal(entry.getValue());
						PayrollIncrementLocalServiceUtil.updatePayrollIncrement(payrollIncrementObj);
					}
					//

				}
			}

			/*
			 * if(payrollIncrement!=null){
			 * 
			 * PayrollIncrementLocalServiceUtil.updatePayrollIncrement(
			 * payrollIncrement); }
			 */

		}

	}

	private boolean checkUnderscoreAndTotalPay(String equation) {
		// TODO Auto-generated method stub
		boolean isUnderscroreAndTotalPay = true;
		if (!equation.contains("TotalPay")) {
			System.out.println("inside TotalPay...!");
			if (!equation.contains("_")) {
				System.out.println("inside underscore...!");
				isUnderscroreAndTotalPay = false;
				System.out.println("exiting underscore...!");
			}
		}
		System.out.println("outside underscore...!");
		return isUnderscroreAndTotalPay;
	}

	static double computeAnother(String equation) {
		double result = 0.00;
		if (equation.contains("(")) {
			Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(equation);
			while (m.find()) {
				double value = 0;
				value = compute(m.group(1));
				result += value;
				equation = equation.replace("(" + m.group(1) + ")", String.valueOf(value));
			}
			result = compute(equation);
		} else {
			result = compute(equation);
		}
		System.out.println("..result.."+result);
		return result;
	}

	static double compute(String equation) {
		double result = 0.0;
		String noMinus = equation.replace("-", "+-");
		String[] byPluses = noMinus.split("\\+");

		for (String multipl : byPluses) {
			String[] byMultipl = multipl.split("\\*");
			double multiplResult = 1.0;
			for (String operand : byMultipl) {
				if (operand.contains("/")) {
					String[] division = operand.split("\\/");
					double divident = Double.parseDouble(division[0]);
					for (int i = 1; i < division.length; i++) {
						divident /= Double.parseDouble(division[i]);
					}
					multiplResult *= divident;
				} else {
					multiplResult *= Double.parseDouble(operand);
				}
			}
			result += multiplResult;
		}
		return result;
	}

	private HashMap<String, Double> getAmountListByComponentId(HashMap<String, String> componentIdAndformula,
			HashMap<String, Double> componentAndAmount) {
		// TODO Auto-generated method stub
		System.out.println("componentIdAndformula : " + componentIdAndformula);
		System.out.println("componentAndAmount : " + componentAndAmount);
		for (Map.Entry<String, String> entry : componentIdAndformula.entrySet()) {
			boolean isAmountAdded = false;
			String formula = entry.getValue();
			boolean isUnderscroreAndTotalPay = checkUnderscoreAndTotalPay(formula);
			if (isUnderscroreAndTotalPay == false) {
				double amount = computeAnother(formula);
				System.out.println("isUnderscroreAndTotalPay false....amount........." + amount);
				componentAndAmount.put(entry.getKey(), amount);
			} else {
				for (Map.Entry<String, Double> ent : componentAndAmount.entrySet()) {
					if (Validator.isNotNull(ent.getValue())) {
						if (formula.contains(ent.getKey())) {
							formula = formula.replaceAll(ent.getKey(), String.valueOf(ent.getValue()));
							isUnderscroreAndTotalPay = checkUnderscoreAndTotalPay(formula);
							System.out.println("isUnderscroreAndTotalPay : "+isUnderscroreAndTotalPay);
							if (isUnderscroreAndTotalPay == false) {
								System.out.println("inside if isUnderscroreAndTotalPay");
								double amount = computeAnother(formula);
								System.out.println("isUnderscroreAndTotalPay...true........." + amount);
								componentAndAmount.put(entry.getKey(), amount);
								isAmountAdded = true;
							}
						}
					}
					if (isAmountAdded == true) {
						break;
					}
				}
			}
			System.out.println("componentAndAmount.......... " + componentAndAmount);
		}
		return componentAndAmount;
	}

	/*
	 * public static void main(String[] args) { date = (Date)
	 * dateFormat.parse(appraisalSetup.getToDateCycle().toString()); calendar =
	 * Calendar.getInstance(); calendar.setTime(date);
	 * calendar.add(calendar.DATE, +1); String toDateCycle =
	 * dateFormat.format(calendar.getTime()); }
	 */

	public void appraisalFinalProcess(ActionRequest request, ActionResponse response) {

		long isLocked = 1;
		long isActive = 1;
		long submitStep = 3;
		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);

		List<AppraisalMaster> appraisalMastersList = new ArrayList<AppraisalMaster>();
		List<EmpPayStructure> empPayStructureList = new ArrayList<EmpPayStructure>();
		List<PayrollIncrement> payrollIncrementList = new ArrayList<PayrollIncrement>();
		EmpPayStructure payStructure = null;
		double postHeadComponentVal = 0;

		appraisalMastersList = AppraisalMasterLocalServiceUtil
				.findBySettingIdAndsubmitStep(setup.getAppraisalSettingId(), submitStep);

		if (appraisalMastersList.size() > 0) {
			for (AppraisalMaster appraisalMasterObj : appraisalMastersList) {
				payrollIncrementList = PayrollIncrementLocalServiceUtil.findByemployeeIdAppraisalSettingIdFinancialYear(
						appraisalMasterObj.getEmployeeId(), setup.getAppraisalSettingId(), setup.getFinancialYear());
				System.out.println("payrollIncrementList..>> " + payrollIncrementList.size());
				EmpPayStructure empPayStructure = null;
				if (payrollIncrementList.size() > 0) {
					for (PayrollIncrement increment : payrollIncrementList) {
						postHeadComponentVal = increment.getPostHeadComponentVal();
						payStructure = EmpPayStructureLocalServiceUtil.findByemployeeIdPayComponentId(
								appraisalMasterObj.getEmployeeId(), increment.getComponentId());
						if (payStructure != null) {
							payStructure.setComponentValue(increment.getPostHeadComponentVal());
							empPayStructure = EmpPayStructureLocalServiceUtil.updateEmpPayStructure(payStructure);
						}
					}
				}
				if (empPayStructure != null) {
					setup.setIsLocked(isLocked);
					AppraisalSetupLocalServiceUtil.updateAppraisalSetup(setup);
				}
			}
		}

	}

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
					System.out.print(
							"payrollIncrement.getPostHeadComponentVal() : " + payrollIncrement.getPostHeadComponentVal()
									+ "..component.getName().." + component.getName());

					totalPay = totalPay + payrollIncrement.getPostHeadComponentVal();
					bonusVal = payrollIncrement.getBonusVal();

					payComponent.setName(component.getName());
					payComponent.setAmount(payrollIncrement.getPostHeadComponentVal());
					components.add(payComponent);
					System.out.println("components list size.." + components.size());
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

	public void sendMailAppraisal(ActionRequest request, ActionResponse response)
			throws AddressException, PortalException {
		long isActive = 1;
		long submitStep = 3;
		String emailFor = "appraisalletter";
		String messageBody = "";
		String toAddress = "";
		String fromName = "";
		String fromAddress = "";
		Company company = null;
		try {
			company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		long companyId = company.getCompanyId();
		fromName = PrefsPropsUtil.getString(companyId, "admin.email.from.name");
		fromAddress = PrefsPropsUtil.getString(companyId, "admin.email.from.address");
		System.out.println("fromName : " + fromName + "..fromAddress.." + fromAddress);

		AppraisalSetup setup = AppraisalSetupLocalServiceUtil.findByIsActive(isActive);

		List<AppraisalMaster> appraisalMastersList = new ArrayList<AppraisalMaster>();

		appraisalMastersList = AppraisalMasterLocalServiceUtil
				.findBySettingIdAndsubmitStep(setup.getAppraisalSettingId(), submitStep);
		if (appraisalMastersList.size() > 0) {
			for (AppraisalMaster appraisalMasterObj : appraisalMastersList) {

				Employee employee = EmployeeLocalServiceUtil.getEmployee(appraisalMasterObj.getEmployeeId());
				toAddress = employee.getEmaiAddress();
				System.out.println("toAddress : " + toAddress);
				EmailTemplate emailTemplate = EmailTemplateLocalServiceUtil.findByemailFor(emailFor);
				messageBody = emailTemplate.getTemplateBody();

				InternetAddress[] to = { new InternetAddress(toAddress) };
				InternetAddress from = new InternetAddress(fromAddress);
				System.out.println("to : " + to + "..from.." + from);

				MailMessage mailMessage = new MailMessage();
				mailMessage.setTo(to);
				mailMessage.setFrom(from);
				mailMessage.setSubject("Performance Appraisal");
				mailMessage.setBody(messageBody);
				mailMessage.setHTMLFormat(true);
				MailServiceUtil.sendEmail(mailMessage);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(AppraisalFinalProcessPortlet.class);

}