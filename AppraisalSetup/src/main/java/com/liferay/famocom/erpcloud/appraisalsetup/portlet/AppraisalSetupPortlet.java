package com.liferay.famocom.erpcloud.appraisalsetup.portlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.appraisalsetup.constants.AppraisalSetupPortletKeys;
import com.liferay.famocom.erpcloud.model.AppraisalSetup;
import com.liferay.famocom.erpcloud.model.PayrollSlabs;
import com.liferay.famocom.erpcloud.service.AppraisalSetupLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayrollSlabsLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Samaresh Barui
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=AppraisalSetup Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AppraisalSetupPortletKeys.AppraisalSetup,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AppraisalSetupPortlet extends MVCPortlet {

	public void addAppraisalSetup(ActionRequest request, ActionResponse response) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");
		String[] employeeTypeIds = ParamUtil.getParameterValues(request, "employeeType");
		String fromDatePCycle = ParamUtil.getString(request, "fromDatePCycle", StringPool.BLANK);
		String toDatePCycle = ParamUtil.getString(request, "toDatePCycle", StringPool.BLANK);
		String fromDateSPeriod = ParamUtil.getString(request, "fromDateSPeriod", StringPool.BLANK);
		String toDateSPeriod = ParamUtil.getString(request, "toDateSPeriod", StringPool.BLANK);
		long appraisalPeriod = ParamUtil.getLong(request, "appraisalPeriod");
		String employeeTypes = StringPool.BLANK;
		System.out.println("fromDatePCycle....." + fromDatePCycle + "..toDatePCycle.." + toDatePCycle
				+ "..fromDateSPeriod.." + fromDateSPeriod + "..toDateSPeriod.." + toDateSPeriod);

		for (String employeeTypeId : employeeTypeIds) {
			System.out.println("employeeTypeIds : " + employeeTypeId);
			employeeTypes = employeeTypeId + "|" + employeeTypes;
		}
		System.out.println("employeeTypes : : " + employeeTypes);
		String[] ratingArr = ParamUtil.getParameterValues(request, "ratingList");
		String ratingLists = ParamUtil.getString(request, "ratingList", StringPool.BLANK);
		String ratingListsArr[] = ratingLists.split(",");
		System.out.println("ratingArr.." + ratingArr.length + "..ratingLists.." + ratingLists + "..ratingListsArr.."
				+ ratingListsArr);

		String salaryPercentage = StringPool.BLANK;
		String bonusPercentage = StringPool.BLANK;

		AppraisalSetup appraisalSetup = null;
		AppraisalSetup addAppraisalSetupObj = null;
		PayrollSlabs payrollSlabs = null;
		PayrollSlabs addPayrollSlabs = null;

		Date fromDateCycleObj = null;
		Date toDateCycleObj = null;
		Date fromDateSubmissionObj = null;
		Date toDateSubmissionObj = null;

		long isActive = 1;
		long isNotActive = 0;
		int previousYear = 0;
		String financialYear = StringPool.BLANK;
		Date currentDate = new Date();
		System.out.println("currentDate.." + currentDate);
		String strCurrentDate = formatter.format(currentDate);
		String[] date1 = strCurrentDate.split("/");
		String month = date1[1];
		String year = date1[2];
		System.out.println("month.." + month + "..year.." + year);
		if (Integer.parseInt(month) <= 3) {
			previousYear = Integer.parseInt(year) - 1;
			financialYear = financialYear + "-" + year;
		} else if (Integer.parseInt(month) >= 4) {
			previousYear = Integer.parseInt(year) + 1;
			financialYear = year + "-" + previousYear;
		}

		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date parseFromDateDate = f.parse(fromDatePCycle);
		long millisecondsFromDate = parseFromDateDate.getTime();

		Date parseToDateDate = f.parse(toDatePCycle);
		long millisecondsToDate = parseToDateDate.getTime();

		/*
		 * long lngFromDatePCycle = 0; try{ lngFromDatePCycle =
		 * Long.parseLong(fromDatePCycle); }catch (Exception e) { }
		 */
		System.out.println("lngFromDatePCycle : " + millisecondsFromDate);
		List<AppraisalSetup> checkDateList = new ArrayList<>();
		System.out.println("appraisalSettingId...<<<<"+appraisalSettingId);
		checkDateList = checkDateExist(isActive, millisecondsFromDate, appraisalSettingId);
		if (checkDateList.size() == 0 && checkDateList.isEmpty()) {
			checkDateList = checkDateExist(isActive, millisecondsToDate, appraisalSettingId);
		}

		System.out.println("setups : " + checkDateList);
		try {
			if (Validator.isNotNull(appraisalSettingId)) {
				System.out.println("appraisalSettingId : " + appraisalSettingId);
				appraisalSetup = AppraisalSetupLocalServiceUtil.getAppraisalSetup(appraisalSettingId);
				appraisalSetup.setModifiedDate(new Date());
			} else {
				long id = CounterLocalServiceUtil.increment(AppraisalSetup.class.getName());
				appraisalSetup = AppraisalSetupLocalServiceUtil.createAppraisalSetup(id);
				appraisalSetup.setFinancialYear(financialYear);
				appraisalSetup.setAddedDate(new Date());
				appraisalSetup.setIsActive(isActive);

				try {
					AppraisalSetup setUp = AppraisalSetupLocalServiceUtil.findByFinancialYear(financialYear, isActive);
					if (Validator.isNotNull(setUp)) {
						setUp.setIsActive(isNotActive);
						if (checkDateList.size() == 0 && checkDateList.isEmpty()) {
							AppraisalSetup setUpObj = AppraisalSetupLocalServiceUtil.updateAppraisalSetup(setUp);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			if (Validator.isNotNull(fromDatePCycle)) {
				fromDateCycleObj = new SimpleDateFormat("dd/MM/yyyy").parse(fromDatePCycle);
				appraisalSetup.setFromDateCycle(fromDateCycleObj);
			}
			if (Validator.isNotNull(toDatePCycle)) {
				toDateCycleObj = new SimpleDateFormat("dd/MM/yyyy").parse(toDatePCycle);
				appraisalSetup.setToDateCycle(toDateCycleObj);
			}
			if (Validator.isNotNull(fromDateSPeriod)) {
				fromDateSubmissionObj = new SimpleDateFormat("dd/MM/yyyy").parse(fromDateSPeriod);
				appraisalSetup.setFromDateSubmission(fromDateSubmissionObj);
			}
			if (Validator.isNotNull(toDateSPeriod)) {
				toDateSubmissionObj = new SimpleDateFormat("dd/MM/yyyy").parse(toDateSPeriod);
				appraisalSetup.setToDateSubmission(toDateSubmissionObj);
			}

			if (Validator.isNotNull(appraisalPeriod)) {
				appraisalSetup.setAppraisalPeriod(appraisalPeriod);
			}
			System.out.println("employeeTypes:::" + employeeTypes);
			if (Validator.isNotNull(employeeTypes)) {
				System.out.println("employeeTypes::==:" + employeeTypes);
				appraisalSetup.setEmployeeType(employeeTypes);
			}

			if (Validator.isNotNull(appraisalSettingId)) {
				System.out.println("Updating.....");
				if (checkDateList.size() == 0 && checkDateList.isEmpty()) {
					addAppraisalSetupObj = AppraisalSetupLocalServiceUtil.updateAppraisalSetup(appraisalSetup);
					System.out.println("Update SuccessFull Appraisal Setup");
				}
			} else {
				if (checkDateList.size() == 0 && checkDateList.isEmpty()) {
					addAppraisalSetupObj = AppraisalSetupLocalServiceUtil.addAppraisalSetup(appraisalSetup);
					System.out.println("Add SuccessFull Appraisal Setup");
				}
			}
			System.out.println("Start payrol slab savingg.....");
			for (int i = 0; i <= ratingArr.length - 1; i++) {
				String nameSalaryPercentage = "salarypercentage_" + ratingListsArr[i];
				String nameBonusPercentage = "bonuspercentage_" + ratingListsArr[i];
				long ratingId = Long.parseLong(ratingListsArr[i]);
				System.out.println(" nameSalaryPercentage.. : " + nameSalaryPercentage + "..nameBonusPercentage..."	+ nameBonusPercentage);
				salaryPercentage = ParamUtil.getString(request, nameSalaryPercentage, StringPool.BLANK);
				bonusPercentage = ParamUtil.getString(request, nameBonusPercentage, StringPool.BLANK);
				System.out.println("addAppraisalSetupObj.getAppraisalSettingId().."	+ addAppraisalSetupObj.getAppraisalSettingId());
				System.out.println("..ratingId" + ratingId);
				System.out.println("salaryPercentage.." + salaryPercentage + "...bonusPercentage.." + bonusPercentage);

				payrollSlabs = PayrollSlabsLocalServiceUtil
						.findByAppraisalSettingIdRatingId(addAppraisalSetupObj.getAppraisalSettingId(), ratingId);
				System.out.println("payrollSlabs.." + payrollSlabs);

				if (payrollSlabs != null) {
					payrollSlabs.setAppraisalSettingId(addAppraisalSetupObj.getAppraisalSettingId());
					payrollSlabs.setRatingId(ratingId);
					if (Validator.isNotNull(appraisalPeriod)) {
						payrollSlabs.setPayrollPercentage(Double.parseDouble(salaryPercentage));
					}
					if (Validator.isNotNull(appraisalPeriod)) {
						payrollSlabs.setBonusPercentage(Double.parseDouble(bonusPercentage));
					}
					addPayrollSlabs = PayrollSlabsLocalServiceUtil.updatePayrollSlabs(payrollSlabs);
					System.out.println("Update SuccessFull payrollslab Setup");
				} else {
					System.out.println("in side else part");
					long payrollSlabsId = CounterLocalServiceUtil.increment(PayrollSlabs.class.getName());
					payrollSlabs = PayrollSlabsLocalServiceUtil.createPayrollSlabs(payrollSlabsId);
					System.out.println("pay roll slab id created");
					payrollSlabs.setAppraisalSettingId(addAppraisalSetupObj.getAppraisalSettingId());
					payrollSlabs.setRatingId(ratingId);
					if (Validator.isNotNull(salaryPercentage)) {
						payrollSlabs.setPayrollPercentage(Long.parseLong(salaryPercentage));
					}
					if (Validator.isNotNull(bonusPercentage)) {
						payrollSlabs.setBonusPercentage(Long.parseLong(bonusPercentage));
					}
					addPayrollSlabs = PayrollSlabsLocalServiceUtil.addPayrollSlabs(payrollSlabs);
					System.out.println("add SuccessFull payrollslab Setup");
				}

			}
			System.out.println("end payrol slab savingg.....");
			if (checkDateList.size() > 0 && !checkDateList.isEmpty()) {
				SessionErrors.add(request, "add-error");
				SessionMessages.add(request, PortalUtil.getPortletId(request)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				response.setWindowState(WindowState.NORMAL);
				response.setRenderParameter("jspPage", "/META-INF/resources/addAppraisalSetup.jsp");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void activeAppraisalSetting(ActionRequest request, ActionResponse response) {
		long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");
		long isActive = 1;
		long isNotActive = 0;
		AppraisalSetup appraisalSetup = null;
		if (Validator.isNotNull(appraisalSettingId)) {
			try {
				appraisalSetup = AppraisalSetupLocalServiceUtil.getAppraisalSetup(appraisalSettingId);
				try {
					AppraisalSetup setUp = AppraisalSetupLocalServiceUtil
							.findByFinancialYear(appraisalSetup.getFinancialYear(), isActive);
					if (Validator.isNotNull(setUp)) {
						setUp.setIsActive(isNotActive);
						AppraisalSetup setUpObj = AppraisalSetupLocalServiceUtil.updateAppraisalSetup(setUp);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				appraisalSetup.setIsActive(isActive);
				AppraisalSetupLocalServiceUtil.updateAppraisalSetup(appraisalSetup);

			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void inActiveAppraisalSetting(ActionRequest request, ActionResponse response) {
		long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");
		long isNotActive = 0;
		AppraisalSetup appraisalSetup = null;
		if (Validator.isNotNull(appraisalSettingId)) {
			try {
				appraisalSetup = AppraisalSetupLocalServiceUtil.getAppraisalSetup(appraisalSettingId);
				appraisalSetup.setIsActive(isNotActive);
				AppraisalSetupLocalServiceUtil.updateAppraisalSetup(appraisalSetup);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteAppraisalSetup(ActionRequest request, ActionResponse response) {
		System.out.println("METHOD CALL");
		long appraisalSettingId = ParamUtil.getLong(request, "appraisalSettingId");
		System.out.println("appraisalSettingId ." + appraisalSettingId);
		AppraisalSetup appraisalSetup = null;
		List<PayrollSlabs> payrollSlabsList = new ArrayList<PayrollSlabs>();
		if (Validator.isNotNull(appraisalSettingId)) {
			try {
				appraisalSetup = AppraisalSetupLocalServiceUtil.getAppraisalSetup(appraisalSettingId);
				if (Validator.isNotNull(appraisalSetup) && appraisalSetup.getIsActive() == 0) {
					System.out.println("deleting....appraisalsetup");
					AppraisalSetupLocalServiceUtil.deleteAppraisalSetup(appraisalSetup);
				}
				DynamicQuery dynamicQuery = PayrollSlabsLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("appraisalSettingId").eq(appraisalSettingId));
				payrollSlabsList = PayrollSlabsLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("payrollSlabsList.." + payrollSlabsList.size());
				if (payrollSlabsList.size() > 0) {
					for (PayrollSlabs slabs : payrollSlabsList) {
						System.out.println("deleting....payrollslabs");
						PayrollSlabsLocalServiceUtil.deletePayrollSlabs(slabs);
					}
				}

			} catch (PortalException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	public static List<AppraisalSetup> checkDateExist(long isActive, long date, long appraisalSettingId) {

		System.out.println("appraisalSettingId...>>>"+appraisalSettingId);
		System.out.println("date" + date);
		List<AppraisalSetup> appraisalSetups = new ArrayList<>();
		DynamicQuery dynamicQuery = AppraisalSetupLocalServiceUtil.dynamicQuery();
		Criterion criterion = RestrictionsFactoryUtil.eq("isActive", isActive);
		if (Validator.isNotNull(appraisalSettingId) && appraisalSettingId!=0) {
			System.out.println("inside if condition");
			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.ne("appraisalSettingId", appraisalSettingId));
		}
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.le("fromDateCycle", new Date(date)));
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ge("toDateCycle", new Date(date)));
		
		dynamicQuery.add(criterion);
		appraisalSetups = AppraisalSetupLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("appraisalSetups : " + appraisalSetups);
		return appraisalSetups;
	}

	public static void main(String args[]) throws ParseException {
		String currentDate = "01/08/2018";
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date parseDate = f.parse(currentDate);
		long milliseconds = parseDate.getTime();
		System.out.println("milliseconds : " + milliseconds);
	}

}