package Payroll.portlet;

import Payroll.constants.PayrollPortletKeys;

import Payroll.util.PayrollUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException;
import com.liferay.famocom.erpcloud.exception.NoSuchStopPayException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.IncomeTaxSlab;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.model.TaxSetting;
import com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.TaxSettingLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.osgi.service.component.annotations.Component;

/**
 * @author FAMOCOM-KAMESH
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Payroll Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PayrollPortletKeys.Payroll, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PayrollPortlet extends MVCPortlet {
	private static Logger _log = Logger.getLogger(PayrollPortlet.class);

	@ProcessAction(name = "addPayComponent")
	public void addPaycomponent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {
		_log.info("############ add Pay Component ########");
		String name = ParamUtil.getString(actionRequest, "name", StringPool.BLANK);
		String abbreviation = ParamUtil.getString(actionRequest, "abbreviation", StringPool.BLANK);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date effectiveDate = ParamUtil.getDate(actionRequest, "effectiveDate", simpleDateFormat);
		String payType = ParamUtil.getString(actionRequest, "payType", StringPool.BLANK);
		int taxStatus = ParamUtil.getInteger(actionRequest, "taxStatus");
		int typeOfComponent = ParamUtil.getInteger(actionRequest, "typeOfComponent");
		int partOfCTC = ParamUtil.getInteger(actionRequest, "partOfCTC");
		long payAmmount = ParamUtil.getLong(actionRequest, "payAmmount");
		long payComponentId = ParamUtil.getLong(actionRequest, "payComponentId");
		String formulla = ParamUtil.getString(actionRequest, "formulla",StringPool.BLANK);
		String paySlipOrder = ParamUtil.getString(actionRequest, "paySlipOrder",StringPool.BLANK);
		int autoAddComponent = ParamUtil.getInteger(actionRequest, "autoAddComponent");
		
		_log.info("############ " + name + " ######## " + abbreviation + " ############ " + effectiveDate + " ######## "
				+ payType + " ############ " + taxStatus + " ########" + typeOfComponent + " ############ " + payAmmount
				+ " ######## " + partOfCTC + " formulla "+formulla);

		
		PayComponent payComponent = null;
		List<String> errorList = new ArrayList<String>();
		boolean ispayComponent = false;
		boolean isError = false;
		if (payComponentId != 0) {
			payComponent = PayComponentLocalServiceUtil.getPayComponent(payComponentId);
			ispayComponent = true;
		} else {			
			payComponentId = CounterLocalServiceUtil.increment(PayComponent.class.getName());
			payComponent = PayComponentLocalServiceUtil.createPayComponent(payComponentId);
			payComponent.setAbbreviation(abbreviation);
		}

		
		payComponent.setComponentType(typeOfComponent);
		payComponent.setCreateDate(new Date());
		payComponent.setEffectiveDate(effectiveDate);
		payComponent.setPayType(payType);
		payComponent.setTaxStatus(taxStatus);
		payComponent.setPartOfCtc(partOfCTC);
		payComponent.setName(name);
		payComponent.setAutoAddPayStructure(autoAddComponent);
		if(typeOfComponent==1){
			if(Validator.isNotNull(formulla)){
				payComponent.setComponentValueFormula(formulla);
			}else{
				errorList.add("Please Add formula!");
			}			
			payComponent.setAmount(0);		
			
		}else{
			if(Validator.isNotNull(payAmmount)){
				payComponent.setAmount(payAmmount);
			}else{
				errorList.add("Please Add Amount Value!");
			}			
			payComponent.setComponentValueFormula(StringPool.BLANK);
		}
		
		
		if(Validator.isNotNull(paySlipOrder)){
			payComponent.setPayComponentOrder(Long.valueOf(paySlipOrder));
		}
		if (ispayComponent) {
			List<PayComponent>  nameCcomponents = PayComponentLocalServiceUtil.findPayComponentByNameAndComponentId(name, payComponentId);
			List<PayComponent> abbreviationComponents = PayComponentLocalServiceUtil.findPayComponentByAbbreviationAndComponentId(payComponent.getAbbreviation(), payComponentId);
			if(nameCcomponents.size()==0){
				if(abbreviationComponents.size()==0){
					PayComponentLocalServiceUtil.updatePayComponent(payComponent);
				}
					
			}else{
				if(nameCcomponents.size()>0){
					SessionErrors.add(actionRequest, "name-error");
				} if(abbreviationComponents.size()>0){
					SessionErrors.add(actionRequest, "abbreviation-error");
				}
				isError = true;
			}
			
		} else {
			List<PayComponent> nameCcomponents = PayComponentLocalServiceUtil.findPayComponentByNameAndComponentId(name,
					0);
			List<PayComponent> abbreviationComponents = PayComponentLocalServiceUtil
					.findPayComponentByAbbreviationAndComponentId(abbreviation, 0);
			
			if (nameCcomponents.size()> 0) {
				errorList.add("Pay Component All ready exist with this Name!");
			}
			if (abbreviationComponents.size() >0) {
				errorList.add("Abbreviation All ready exist with this Name!");
			}
			System.out.println("nameCcomponents....." + nameCcomponents.size());
			
					if (errorList.size() > 0) {
						isError = true;
					}else{
						PayComponent component = PayComponentLocalServiceUtil.addPayComponent(payComponent);
						System.out.println("component... " + component);

						// auto add paycomponent on existing Pay structure of
						// employee
						if (autoAddComponent == 1) {
							List<Long> list = EmpPayStructureLocalServiceUtil.getEmployeeIdFromEmpPayStructure();
							Iterator<Long> empStructureIterator = list.iterator();
							System.out.println("list... " + list);
							while (empStructureIterator.hasNext()) {
								long employeeId = GetterUtil.getLong(empStructureIterator.next());
								// long empId = long
								long empPayStructureId = CounterLocalServiceUtil
										.increment(EmpPayStructure.class.getName());
								EmpPayStructure payStructure = EmpPayStructureLocalServiceUtil
										.createEmpPayStructure(empPayStructureId);

								payStructure.setEmployeeId(employeeId);
								payStructure.setPayComponentId(component.getComponentId());
								HashMap<String, String> componentIdAndformula = new HashMap<>();

								double amount = 0;
								if (typeOfComponent == 1) {
									componentIdAndformula.put(component.getComponentId() + "_",
											component.getComponentValueFormula());
									amount = PayrollUtil.getComponentAmountByFormula(employeeId, componentIdAndformula,
											component.getComponentId());
								} else {
									amount = payAmmount;
								}
								payStructure.setComponentValue(amount);
								EmpPayStructureLocalServiceUtil.addEmpPayStructure(payStructure);
								// }

							}

						}
					}

		}
		if(isError){
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
			httpRequest.setAttribute("errorList", errorList);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/addPayComponent.jsp");
		}
	
		//actionResponse.sendRedirect("/META-INF/resources/addPayComponent.jsp");
	}
	@ProcessAction(name="addTaxSetting")
	public void addTaxSetting(ActionRequest actionRequest,ActionResponse actionResponse){
		_log.info("################ add tax setting formulla ##########");
		long componentId  = ParamUtil.getLong(actionRequest, "componentId");
		String formulla = ParamUtil.getString(actionRequest, "formullaValue");
		_log.info("################ add tax setting formulla ########## "+formulla);
		ThemeDisplay themeDisplay  = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long taxSettingId = CounterLocalServiceUtil.increment(TaxSetting.class.getName());
		TaxSetting taxSetting = TaxSettingLocalServiceUtil.createTaxSetting(taxSettingId);
		taxSetting.setComponentId(componentId);
		taxSetting.setCreatedBy(themeDisplay.getUserId());
		taxSetting.setCreatedDate(new Date());
		taxSetting.setTaxFormulla(formulla);
		TaxSettingLocalServiceUtil.addTaxSetting(taxSetting);
		
	}

	@ProcessAction(name = "deletePayComponent")
	public void deletePayComponent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		_log.info("######## delete pay component ###################");

		long payComponentId = ParamUtil.getLong(actionRequest, "payComponentId");

		if (payComponentId != 0) {
			List<EmpPayStructure> empPayStructureList = new ArrayList<>();
			try{
				 empPayStructureList = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentId(payComponentId);
			}catch (Exception e) {
				// TODO: handle exception
			}
			if(empPayStructureList.size()<0){
			    PayComponent paycomponent = PayComponentLocalServiceUtil.getPayComponent(payComponentId);
				if (Validator.isNotNull(paycomponent)) {
					if (paycomponent.getIslock() == 0) {
						PayComponentLocalServiceUtil.deletePayComponent(payComponentId);
					}
				}
			}{
				System.out.println("Pay component Id all ready Add in pay structure...!");
			}
		}
		actionResponse.setRenderParameter("jspPage", "/view.jsp");
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String redirectJsp = ParamUtil.getString(renderRequest, "jspPage");
		// EmployeeView employeeView =
		if (Validator.isNotNull(redirectJsp) && redirectJsp.equalsIgnoreCase("/monthlyAdjustment.jsp")) {
			List<PayComponent> payComponent = new ArrayList<PayComponent>();
			payComponent = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
			List<String> earningList = new ArrayList<String>();
			earningList.add(PayrollPortletKeys.Earning);
			earningList.add(PayrollPortletKeys.Overtime);
			earningList.add(PayrollPortletKeys.Reimbursement);
			earningList.add(PayrollPortletKeys.StatutoryComponent);

			HashMap<String, List<PayComponent>> hashMap = new HashMap<>();
			List<PayComponent> payComponentEarningList = new ArrayList<PayComponent>();
			List<PayComponent> payComponentDeductionList = new ArrayList<PayComponent>();
			if (Validator.isNotNull(payComponent) && payComponent.size() > 0) {
				for (PayComponent component : payComponent) {
					if (Validator.isNotNull(component.getPayType())) {
						if (earningList.contains(component.getPayType())) {
							payComponentEarningList.add(component);
						}
						if (component.getPayType().equalsIgnoreCase(PayrollPortletKeys.Deduction)) {
							payComponentDeductionList.add(component);
						}
					}
				}
				hashMap.put(PayrollPortletKeys.Earning, payComponentEarningList);
				hashMap.put(PayrollPortletKeys.Deduction, payComponentDeductionList);
			}
			renderRequest.setAttribute("payComponentEarningList", payComponentEarningList);
			renderRequest.setAttribute("payComponentDeductionList", payComponentDeductionList);
			renderRequest.setAttribute("earningList", earningList);
		}
		super.render(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		if (cmd.trim().equalsIgnoreCase("getPayComponent")) {
			String employeeId = ParamUtil.getString(request, "employeeId", StringPool.BLANK);
			String month = ParamUtil.getString(request, "month", StringPool.BLANK);
			String year = ParamUtil.getString(request, "year", StringPool.BLANK);
			System.out.println("employeeId....." + employeeId);
			String monthYear = month+year;
			//List<EmpPayStructure> empPayStructureList = new ArrayList<EmpPayStructure>();
			List<String> earningList = new ArrayList<String>();
			earningList.add(PayrollPortletKeys.Earning);
			earningList.add(PayrollPortletKeys.Overtime);
			earningList.add(PayrollPortletKeys.Reimbursement);
			earningList.add(PayrollPortletKeys.StatutoryComponent);
			JSONArray jsonArray = null;
			List<PayComponent> payComponentList = new ArrayList<>();
			if (Validator.isNotNull(employeeId)) {
				List<PayComponent> payCompoList = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
				 for (PayComponent payComponent : payCompoList) {
					 EmpPayStructure empPayStructure=null;
					try {
						empPayStructure = EmpPayStructureLocalServiceUtil.findEmpPayStructureByPayComponentIdAndEmployeeId(payComponent.getComponentId(),Long.valueOf(employeeId));
					} catch (NoSuchEmpPayStructureException | SystemException | NumberFormatException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					 boolean isMonthlyAdjustment = false;
					 if (Validator.isNotNull(empPayStructure)) {
						 List<MonthlyAdjustment> adjustmentList = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByEmployeeId(Long.valueOf(employeeId));
						if(adjustmentList.size()>0){
						 for(MonthlyAdjustment adjustment:adjustmentList){
								if(adjustment.getPayComponentId()==empPayStructure.getPayComponentId()){
									if(Validator.isNotNull(monthYear)){
										long monTYear = Long.valueOf(monthYear);
										if(monTYear==adjustment.getMonthYear()){
											double adjustmentMount = adjustment.getAmount();
											payComponent.setComponentValueFormula(String.valueOf(adjustmentMount));
											payComponent.setAmount(empPayStructure.getComponentValue());
											isMonthlyAdjustment = true;
										}										
									}									
								}
							}
						}
							if(isMonthlyAdjustment==false){
								payComponent.setAmount(empPayStructure.getComponentValue());
								payComponent.setComponentValueFormula(StringPool.BLANK);
							}							
				 
					 	}
					 payComponentList.add(payComponent);
				 }
			}
				else {
					List<PayComponent> payCompoListTemp = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
					
					List<MonthlyAdjustment> adjustmentList = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByEmployeeId(Long.valueOf(employeeId));
					for(PayComponent component:payCompoListTemp){
						for(MonthlyAdjustment adjustment:adjustmentList){
							if(adjustment.getPayComponentId()==component.getComponentId()){
								if(Validator.isNotNull(monthYear)){
									long monTYear = Long.valueOf(monthYear);
									if(monTYear==adjustment.getMonthYear()){
										component.setAmount(adjustment.getAmount());
										//isMonthlyAdjustment = true;
									}										
								}								
							}
						}	
						payComponentList.add(component);
					}
				}
				if(Validator.isNotNull(payComponentList)){
					jsonArray = JSONFactoryUtil.createJSONArray();
					for (PayComponent component : payComponentList) { 	
						    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
							jsonObject.put("payType", component.getPayType());
							jsonObject.put("payComponentId", component.getComponentId());
							jsonObject.put("name", component.getName());
							jsonObject.put("amount", component.getAmount());
							jsonObject.put("adjustmentAmount", component.getComponentValueFormula());
							System.out.println("component..."+component);
							jsonArray.put(jsonObject);
							System.out.println("jsonArray..."+jsonArray);
					}
				}
			
			PrintWriter writer = response.getWriter();			
			writer.print(jsonArray);
		}
	}
	
	@ProcessAction(name="addMonthlyAdjustment")
	public void addMonthlyAdjustment(ActionRequest request,ActionResponse response){
		_log.info("########### inside monthly adjustment ############");
		String employeeId = ParamUtil.getString(request, "employeeId",StringPool.BLANK);
		String month  = ParamUtil.getString(request, "month",StringPool.BLANK);
		String year  = ParamUtil.getString(request, "year",StringPool.BLANK);
		String componentIdList = ParamUtil.getString(request, "componenetIdList",StringPool.BLANK);
		String monthyear = month+year;
		try{
			String[] componenetIds= componentIdList.split(",");
			List<String> list = Arrays.asList(componenetIds);
			for(String str:list){
				String component  = "compo_"+str;
				String amount = ParamUtil.getString(request, component);
				long componentId = Long.valueOf(str);
				System.out.println("amount...."+amount);
				if(Validator.isNotNull(amount)){
					boolean  isMonthlyAdjustment = false;
					List<MonthlyAdjustment> monthlyAdjustmentList = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByEmployeeId(Long.valueOf(employeeId));
					if(monthlyAdjustmentList.size()>0){
						for(MonthlyAdjustment adjustment:monthlyAdjustmentList){
							if(componentId==adjustment.getPayComponentId()){
								long monTYear = Long.valueOf(monthyear);
								if(monTYear==adjustment.getMonthYear()){
									isMonthlyAdjustment = true;
									MonthlyAdjustment   monthlyAdjustment = MonthlyAdjustmentLocalServiceUtil.getMonthlyAdjustment(adjustment.getMonthlyAdjustmentId());
									monthlyAdjustment.setAmount(Double.valueOf( amount));
									MonthlyAdjustmentLocalServiceUtil.updateMonthlyAdjustment(monthlyAdjustment);
								}
							}
						}
					}	
					if(isMonthlyAdjustment==false){
						long monthlyAdjustmentId = CounterLocalServiceUtil.increment(MonthlyAdjustment.class.getName());
						MonthlyAdjustment adjustment = MonthlyAdjustmentLocalServiceUtil.createMonthlyAdjustment(monthlyAdjustmentId);
						adjustment.setAmount(Double.valueOf(amount));
						adjustment.setMonthYear(Long.valueOf(monthyear));
						adjustment.setEmployeeId(Long.valueOf(employeeId));
						adjustment.setPayComponentId(Long.valueOf(str));
						MonthlyAdjustmentLocalServiceUtil.addMonthlyAdjustment(adjustment);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@ProcessAction(name="addStopPay")
	public void addStopPay(ActionRequest request,ActionResponse response){
		_log.info("########### inside stop pay for employee ############");
		Long employeeId = ParamUtil.getLong(request, "employeeId");
		String month  = ParamUtil.getString(request, "month",StringPool.BLANK);
		String year  = ParamUtil.getString(request, "year",StringPool.BLANK);
		String reason  = ParamUtil.getString(request, "reason",StringPool.BLANK);		
		ThemeDisplay themeDisplay  = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String monthyear = month+year;
		StopPay sPay = null;
		try {
			sPay = StopPayLocalServiceUtil.findStopPayByEmployeeIdAndMonthYear(employeeId, Long.valueOf(monthyear));
		} catch (NoSuchStopPayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Validator.isNull(sPay)){		
			long stopPayId = CounterLocalServiceUtil.increment(StopPay.class.getName());
			StopPay pay = StopPayLocalServiceUtil.createStopPay(stopPayId);
			pay.setEmployeeId(employeeId);
			pay.setCreatedDate(new Date());
			pay.setIsLock(0);
			pay.setStatus(0);
			if(Validator.isNotNull(monthyear)){
				pay.setMonthYear(Long.valueOf(monthyear));
			}		
			pay.setReason(reason);
			pay.setCreatedBy(themeDisplay.getUserId());
			StopPayLocalServiceUtil.addStopPay(pay);
			response.setRenderParameter("jspPage", "/META-INF/resources/StopPayList.jsp");
		}else{
			SessionErrors.add(request, "EmpMonth-error");
			SessionMessages.add(request, PortalUtil.getPortletId(request)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionMessages.add(request, PortalUtil.getPortletId(request)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			response.setRenderParameter("jspPage", "/META-INF/resources/addStopPay.jsp");
		}
		
	}
	@ProcessAction(name="changeStopPayStatus")
	public void changeStopPayStatus(ActionRequest request,ActionResponse response) throws PortalException{
		_log.info("########### update stop pay for employee ############");
		long stopPayId = ParamUtil.getLong(request, "stopPayId");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		StopPay stopPay = StopPayLocalServiceUtil.getStopPay(stopPayId);
		if(Validator.isNotNull(stopPay)){
			stopPay.setStatus(1);
			stopPay.setModifiedBy(themeDisplay.getUserId());
			stopPay.setModifiedDate(new Date());
			StopPayLocalServiceUtil.updateStopPay(stopPay);
		}
	}
	@ProcessAction(name="addTaxSlab")
	public void addTaxSlab(ActionRequest actionRequest,ActionResponse actionResponse){
		_log.info("########### add / update Tax Slab ############");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String incomeFrom = ParamUtil.getString(actionRequest, "incomeFrom",StringPool.BLANK );
		String incomeTo = ParamUtil.getString(actionRequest, "incomeTo",StringPool.BLANK );
		String taxRate = ParamUtil.getString(actionRequest, "taxRate",StringPool.BLANK );
		String financialYear = ParamUtil.getString(actionRequest, "financialYear",StringPool.BLANK );
		long incomeTaxSlabId = ParamUtil.getLong(actionRequest, "incomeTaxSlabId");
		IncomeTaxSlab incomeTaxSlab = null;
		boolean isUpdate = false;
		System.out.println("incomeTaxSlabId.... "+incomeTaxSlabId);
		if(incomeTaxSlabId!=0){
			 try {
					incomeTaxSlab = IncomeTaxSlabLocalServiceUtil.getIncomeTaxSlab(incomeTaxSlabId);
					if(Validator.isNotNull(incomeTaxSlab)){
						isUpdate = true;
					}
				} catch (PortalException e) {
					
				}
		}else{
			incomeTaxSlabId = CounterLocalServiceUtil.increment(IncomeTaxSlab.class.getName());
		    incomeTaxSlab = IncomeTaxSlabLocalServiceUtil.createIncomeTaxSlab(incomeTaxSlabId);
		}
		
		incomeTaxSlab.setIncomeFrom(Integer.valueOf(incomeFrom));
		incomeTaxSlab.setIncomeTo(Integer.valueOf(incomeTo));
		incomeTaxSlab.setFinancialYear(financialYear);
		incomeTaxSlab.setTaxRate(Double.valueOf(taxRate));
		incomeTaxSlab.setCompanyId(themeDisplay.getCompanyId());
		if(isUpdate){
			IncomeTaxSlabLocalServiceUtil.updateIncomeTaxSlab(incomeTaxSlab);
		}else{															
			IncomeTaxSlabLocalServiceUtil.addIncomeTaxSlab(incomeTaxSlab);
		}
		
	}
	@ProcessAction(name="deleteTaxSlab")
	public void deleteTaxSlab(ActionRequest actionRequest,ActionResponse actionResponse){
		_log.info("######## delete Income TaxSlab #######");
		long incomeTaxSlabId = ParamUtil.getLong(actionRequest, "incomeTaxSlabId");
		IncomeTaxSlab incomeTaxSlab = null;
		if(incomeTaxSlabId!=0){
			 try {
				incomeTaxSlab = IncomeTaxSlabLocalServiceUtil.getIncomeTaxSlab(incomeTaxSlabId);
			} catch (PortalException e) {
				// TODO: handle exception
			}
			 if(Validator.isNotNull(incomeTaxSlab)){
				 try {
					IncomeTaxSlabLocalServiceUtil.deleteIncomeTaxSlab(incomeTaxSlabId);
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }else{
				 
			 }
		}
		
		
	}
}