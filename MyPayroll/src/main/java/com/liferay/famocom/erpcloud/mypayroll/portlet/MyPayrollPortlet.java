package com.liferay.famocom.erpcloud.mypayroll.portlet;

import com.liferay.famocom.erpcloud.model.Employee;


import com.liferay.famocom.erpcloud.mypayroll.constants.MyPayrollPortletKeys;
import com.liferay.famocom.erpcloud.mypayroll.util.HtmlToPdf;
import com.liferay.famocom.erpcloud.mypayroll.util.MyPayrollUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author FAMOCOM-AJEET
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MyPayroll Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyPayrollPortletKeys.MyPayroll,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyPayrollPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);		
		if (cmd.equals("generatePdfPaySlip")) {
			long employeeId = ParamUtil.getLong(resourceRequest, "employeeId");
			int monthYear = ParamUtil.getInteger(resourceRequest, "monthYear");
			String month = ParamUtil.getString(resourceRequest, "month");
			String year = ParamUtil.getString(resourceRequest, "year");
			Map<String, String> paySlipFormValue = new HashMap<String, String>();
			String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
			Employee employee = null;
			ThemeDisplay themeDisplay  = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			String fileName = StringPool.BLANK;
			try {
				paySlipFormValue = MyPayrollUtil.getMappingValueOfPaySlipForPDF(themeDisplay,employeeId, monthYear,month);
			} catch (PortalException e) {
				e.printStackTrace();
			}			
			if(Validator.isNotNull(employee)){ 
				
				fileName = employee.getFirstName()+" "+employee.getLastName()+"-"+months[Integer.valueOf(month)-1]+" "+year;
			}
			String filePath = "/"+fileName+".pdf";
			 fileName  = fileName+".pdf";
			HtmlToPdf  htmlToPdf = new HtmlToPdf();
			htmlToPdf.createPDFfromHTML(paySlipFormValue, "pdf-salary.html", filePath,resourceResponse,employee.getPanNo(),fileName);
			
			
		}
		
		if (cmd.equals("exportPdfTDS")) {
			long employeeId = ParamUtil.getLong(resourceRequest, "employeeId");
			String monthYear = ParamUtil.getString(resourceRequest, "monthYear");
			String month = ParamUtil.getString(resourceRequest, "month");
			String year = ParamUtil.getString(resourceRequest, "year");
			Employee employee = null;
			Map<String, String> tdsFormValue = new HashMap<String, String>();
			try {
				employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			String fileName = StringPool.BLANK;
			ThemeDisplay themeDisplay  = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String[] months = {"JANUARY", "FEBRUARY", "MARCH","APRIL", "MAY", "JUNE", "JULY", "AUGUST","SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
			String panNo = StringPool.BLANK;
			if(Validator.isNotNull(employee)){				
				panNo = employee.getPanNo();					
				fileName  = employee.getFirstName()+" "+employee.getLastName()+"-"+months[Integer.valueOf(month)-1]+" "+year;
				
			}
			try {
				tdsFormValue = MyPayrollUtil.getMappingValueOfTaxDeclarationForPDF(employeeId,themeDisplay, monthYear,month);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
			String filePath = "/TDS.pdf";
			fileName  = fileName+".pdf";
			HtmlToPdf  htmlToPdf = new HtmlToPdf();
			htmlToPdf.createPDFfromHTML(tdsFormValue, "TDS.html", filePath,resourceResponse,employee.getPanNo(),fileName);
		}
		
	}
	
}