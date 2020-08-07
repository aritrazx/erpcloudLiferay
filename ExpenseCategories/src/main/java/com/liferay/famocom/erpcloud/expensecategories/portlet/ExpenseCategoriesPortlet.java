package com.liferay.famocom.erpcloud.expensecategories.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.expensecategories.constants.ExpenseCategoriesPortletKeys;
import com.liferay.famocom.erpcloud.model.ExpCategory;
import com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ExpenseCategories Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ExpenseCategoriesPortletKeys.ExpenseCategories,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ExpenseCategoriesPortlet extends MVCPortlet {
	


	public void expCategoryAdd(ActionRequest request, ActionResponse response) throws IOException {

		
		String categoryName = ParamUtil.get(request, "Category_name", "");
		String frequency = ParamUtil.get(request, "Frequency", "");
		String affectedSalaryHead = ParamUtil.get(request, "Affected_salary_head", "");
		boolean attachmentRequired = ParamUtil.getBoolean(request, "attachmentRequired");

		long catId = CounterLocalServiceUtil.increment(ExpCategory.class.getName());

		ExpCategory expCategory = ExpCategoryLocalServiceUtil.createExpCategory(catId);
		expCategory.setCategoryName(categoryName);
		expCategory.setFrequency(frequency);
		expCategory.setSalaryHead(Long.valueOf(affectedSalaryHead));
		expCategory.setAttachment(attachmentRequired);
		try {
			expCategory = ExpCategoryLocalServiceUtil.addExpCategory(expCategory);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		response.sendRedirect("jspPage", "/META-INF/resources/view.jsp");

	}

	public void expCategoryDelete(ActionRequest request, ActionResponse response) {
		String catId = ParamUtil.get(request, "catId", "");

		try {

			ExpCategory expCategory = ExpCategoryLocalServiceUtil.deleteExpCategory(Long.valueOf(catId));
			response.sendRedirect("jspPage", "/META-INF/resources/view.jsp");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void expCategoryEdit(ActionRequest request, ActionResponse response) {
		String catId = ParamUtil.get(request, "expCategory", StringPool.BLANK);
		System.out.println("catId$$$$" + catId);
		if (catId != null || !catId.isEmpty()) {
			String categoryName = ParamUtil.get(request, "Category_name", "");
			String frequency = ParamUtil.get(request, "Frequency", "");
			String affectedSalaryHead = ParamUtil.get(request, "Affected_salary_head", "");
			boolean attachmentRequired = ParamUtil.getBoolean(request, "attachmentRequired");
			try {

				ExpCategory expCategory = ExpCategoryLocalServiceUtil.getExpCategory(Long.valueOf(catId));
				expCategory.setCategoryName(categoryName);
				expCategory.setFrequency(frequency);
				expCategory.setSalaryHead(Long.valueOf(affectedSalaryHead));
				expCategory.setAttachment(attachmentRequired);
				ExpCategoryLocalServiceUtil.updateExpCategory(expCategory);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}


}