package com.liferay.famocom.erpcloud.employeedetails.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.famocom.erpcloud.employeedetails.constants.EmployeeDetailsPortletKeys;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

public class PayStructureUtil {
	
	public static JSONArray getPayComponentAmountByTotalPay(String totalPay) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		double totalEarning = 0.00;
		double ptax = 0.00;
		List<PayComponent> componentsList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
		HashMap<String, String> componentIdAndformula = new HashMap<>();
		HashMap<String, Double> componentAndAmount = new HashMap<>();

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

			String equation = formula.replaceAll("TotalPay", totalPay);
			componentIdAndformula.put(entry.getKey(), equation);
		}
		boolean isConditionTrue = true;
		for (boolean i = true; i == isConditionTrue;) {
			if (componentAndAmount.size() != componentIdAndformula.size()) {
				componentAndAmount = getAmountListByComponentId(componentIdAndformula, componentAndAmount);
				isConditionTrue = true;
			} else {
				isConditionTrue = false;
			}
		}

		// calculate professional tax
		for (PayComponent payComponent : componentsList) {
			if (payComponent.getPayType().equalsIgnoreCase(EmployeeDetailsPortletKeys.Earning)) {
				for (Map.Entry<String, Double> entry : componentAndAmount.entrySet()) {
					long id = Long.valueOf(entry.getKey().replaceAll("_", ""));
					if (payComponent.getComponentId() == id) {
						totalEarning += entry.getValue();
					}
				}
			}
		}
		ptax = getProfessionsTaxByTotalEarning(totalEarning);
		List<String> earningList = new ArrayList<String>();
		earningList.add(EmployeeDetailsPortletKeys.Earning);
		earningList.add(EmployeeDetailsPortletKeys.Overtime);
		earningList.add(EmployeeDetailsPortletKeys.Reimbursement);
		earningList.add(EmployeeDetailsPortletKeys.StatutoryComponent);
		for (PayComponent payComponent : componentsList) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			 if(earningList.contains(payComponent.getPayType())){
				for (Map.Entry<String, Double> entry : componentAndAmount.entrySet()) {
					long id = Long.valueOf(entry.getKey().replaceAll("_", ""));
					if (payComponent.getComponentId() == id) {
						totalEarning += entry.getValue();
						jsonObject.put("payType", payComponent.getPayType());
						jsonObject.put("earning", entry.getValue());
						jsonArray.put(jsonObject);
					}
				}
			}
			if (payComponent.getPayType().equalsIgnoreCase(EmployeeDetailsPortletKeys.Deduction)) {
				for (Map.Entry<String, Double> entry : componentAndAmount.entrySet()) {
					long id = Long.valueOf(entry.getKey().replaceAll("_", ""));
					if (payComponent.getComponentId() == id) {
						double amount = entry.getValue();
						if (payComponent.getAbbreviation().equalsIgnoreCase("PT")) {
							amount = ptax;
						}
						jsonObject.put("payType", payComponent.getPayType());
						jsonObject.put("deduction", amount);
						jsonArray.put(jsonObject);
					}
				}
			}
		}
		return jsonArray;
	}
	
	public static HashMap<String, Double> getAmountListByComponentId(HashMap<String, String> componentIdAndformula,
			HashMap<String, Double> componentAndAmount) {

		for (Map.Entry<String, String> entry : componentIdAndformula.entrySet()) {
			boolean isAmountAdded = false;
			String formula = entry.getValue();
			boolean isUnderscroreAndTotalPay = checkUnderscoreAndTotalPay(formula);
			if (isUnderscroreAndTotalPay == false) {
				double amount = computeAnother(formula);
				componentAndAmount.put(entry.getKey(), amount);
			} else {
				for (Map.Entry<String, Double> ent : componentAndAmount.entrySet()) {
					if (Validator.isNotNull(ent.getValue())) {
						if (formula.contains(ent.getKey())) {
							formula = formula.replaceAll(ent.getKey(), String.valueOf(ent.getValue()));
							isUnderscroreAndTotalPay = checkUnderscoreAndTotalPay(formula);
							if (isUnderscroreAndTotalPay == false) {
								double amount = computeAnother(formula);
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
		}
		return componentAndAmount;
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
		return result;
	}
	
	static double compute(String equation) {
		double result = 0.00;
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
	
	public static boolean checkUnderscoreAndTotalPay(String equation) {
		boolean isUnderscroreAndTotalPay = true;
		if (!equation.contains("TotalPay")) {
			if (!equation.contains("_")) {
				isUnderscroreAndTotalPay = false;
			}
		}
		return isUnderscroreAndTotalPay;
	}
	
	public static double getProfessionsTaxByTotalEarning(double totalEarning) {
		double professionTax = 0;
		if (totalEarning > 8500 && totalEarning <= 10000) {
			professionTax = 90;

		} else if (totalEarning > 10000 && totalEarning <= 15000) {
			professionTax = 110;

		} else if (totalEarning > 15000 && totalEarning <= 25000) {
			professionTax = 130;
		} else if (totalEarning > 25000 && totalEarning <= 40000) {
			professionTax = 150;
		} else if (totalEarning > 40000) {
			professionTax = 200;
		}
		return professionTax;
	}

}
