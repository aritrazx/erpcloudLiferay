package com.liferay.famocom.erpcloud.employeetype.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.employeetype.constants.EmployeeTypePortletKeys;
import com.liferay.famocom.erpcloud.model.EmployeeType;
import com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=EmployeeTypeMaster Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeTypePortletKeys.EmployeeType, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeTypePortlet extends MVCPortlet {

	public void addEmployeeType(ActionRequest actionRequest, ActionResponse actionResponse) {
		String typeName = ParamUtil.getString(actionRequest, "typeName", StringPool.BLANK);
		System.out.println("TypeName:" + typeName);
		long check = ParamUtil.getLong(actionRequest, "check");
		System.out.println("CHECK:" + check);
		// Current Date
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		System.out.println("ADD1");
		
		String description = ParamUtil.getString(actionRequest, "description",StringPool.BLANK);
		System.out.println("description"+description);
		
		String status = ParamUtil.getString(actionRequest, "status",StringPool.BLANK);

		List<String> error = new ArrayList<>();
		DynamicQuery dynamicQuery = EmployeeTypeLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("typeName").eq(typeName));
		List<EmployeeType> list = EmployeeTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
		// System.out.println("list... "+list);
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			error.add("Given Employee Type already exist");
		}
		if (error.size() == 0) {
			EmployeeType obj = null;
			try {
				long employeetypeId = CounterLocalServiceUtil.increment(EmployeeType.class.getName());
				// System.out.println("category...."+cat_id);
				EmployeeType empType = EmployeeTypeLocalServiceUtil.createEmployeeType(employeetypeId);
				ThemeDisplay td  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				User user = td.getUser();
				System.out.println("ADD3");
				empType.setTypeName(typeName);
				System.out.println("ADD4");
				empType.setPfDeduct(check);
				empType.setCompanyId(user.getCompanyId());
				empType.setAddeddate(date);
				empType.setDescription(description);
				empType.setStatus(Integer.parseInt(status));
				obj = EmployeeTypeLocalServiceUtil.addEmployeeType(empType);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			if (obj != null) {
				SessionMessages.add(actionRequest, "add-success");
			} else {
				SessionErrors.add(actionRequest, "add-error");
				// SessionMessages.add(actionRequest,
				// PortalUtil.getPortletId(actionRequest)+ SessionMessages.
				// KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		} else {
			SessionErrors.add(actionRequest, "error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			httpRequest.setAttribute("errorList", error);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/view.jsp");
		}

	}

	public void updateEmployeeType(ActionRequest actionRequest, ActionResponse actionResponse) {

		long employeeTypeId = ParamUtil.getLong(actionRequest, "employeetypeId");
		//System.out.println("");
		String typeName = ParamUtil.getString(actionRequest, "typeName", StringPool.BLANK);
		System.out.println("TypeName:" + typeName);
		long check = ParamUtil.getLong(actionRequest, "check");
		System.out.println("CHECK:" + check);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		
		String description = ParamUtil.getString(actionRequest, "description",StringPool.BLANK);
		System.out.println("description"+description);
		
		String status = ParamUtil.getString(actionRequest, "status",StringPool.BLANK);
		
		DynamicQuery dynamicQuery = EmployeeTypeLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("typeName").eq(typeName));
		List<EmployeeType> list = EmployeeTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("list... " + list);
		boolean bFlg = false;
		List<String> error = new ArrayList<>();
		
		if (Validator.isNotNull(list) && !list.isEmpty()) {
			System.out.println("if....");
			for (EmployeeType oh : list) {
				System.out.println("for....");
				if (oh.getEmployeetypeId() != employeeTypeId) {
					System.out.println("if1...");
					bFlg = true;
				}
			}
		}
		System.out.println("if2...");
		if (bFlg) {
			System.out.println("if3...");
			error.add("Given expense category already exist");
		}

		if (error.size() == 0) {
			System.out.println("if4...");
			EmployeeType obj = null;
			try {
				System.out.println("try...");
				EmployeeType empObj = EmployeeTypeLocalServiceUtil.getEmployeeType(employeeTypeId);
				System.out.println("try2...");
				// System.out.println("category...."+cat_id);
				// catObj.getCompany_id(company_id);
				empObj.setTypeName(typeName);
				empObj.setPfDeduct(check);

				obj = EmployeeTypeLocalServiceUtil.updateEmployeeType(empObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (obj != null) {
				SessionMessages.add(actionRequest, "update-success");
			} else {
				SessionErrors.add(actionRequest, "update-error");
				// SessionMessages.add(actionRequest,
				// PortalUtil.getPortletId(actionRequest)+ SessionMessages.
				// KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		} else {
			System.out.println("else...");
			SessionErrors.add(actionRequest, "error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			httpRequest.setAttribute("errorList", error);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			// actionResponse.setRenderParameter("backUrl", backUrl);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/editEmployeeType.jsp");
			System.out.println("else2...");
			System.out.println("EmployeeTYpeIIDDD:--"+employeeTypeId);
		}

		try {
			System.out.println("tryelse...");
			EmployeeType empObj = EmployeeTypeLocalServiceUtil.getEmployeeType(employeeTypeId);
			System.out.println("tryelse1...");
			// System.out.println("category...."+cat_id);
			// catObj.getCompany_id(company_id);

			empObj.setTypeName(typeName);

			empObj.setPfDeduct(check);
			empObj.setAddeddate(date);
			empObj.setDescription(description);
			empObj.setStatus(Integer.parseInt(status));
			System.out.println("tryelse2...");
			EmployeeType obj = EmployeeTypeLocalServiceUtil.updateEmployeeType(empObj);
			System.out.println("tryelse3...");
			if(obj!=null){
				System.out.println("tryelse4...");
				
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("typeName", "");
				actionResponse.setRenderParameter("jspPage", "/view.jsp");
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
}