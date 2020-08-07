	package com.liferay.famocom.erpcloud.salaryprocess.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.exception.NoSuchFinSalaryException;
import com.liferay.famocom.erpcloud.exception.NoSuchTaxDeclarationException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.FinSalary;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.model.StopPay;
import com.liferay.famocom.erpcloud.salaryprocess.Util.SalaryProcessUtil;
import com.liferay.famocom.erpcloud.salaryprocess.constants.SalaryProcessPortletKeys;
import com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.FinSalaryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SalDetailsLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
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
		"javax.portlet.display-name=SalaryProcess Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SalaryProcessPortletKeys.SalaryProcess,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SalaryProcessPortlet extends MVCPortlet {
	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		ThemeDisplay themeDisplay  = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (cmd.trim().equalsIgnoreCase("getMonthlyAndStopPaySalaryProcessCount")) {			
			String month = ParamUtil.getString(request, "month", StringPool.BLANK);
			String year = ParamUtil.getString(request, "year", StringPool.BLANK);
			List<MonthlyAdjustment> adjustments = new ArrayList<MonthlyAdjustment>();
			String monthYear = month+year;
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			try{
				List<StopPay>  stopPaylist = new ArrayList<StopPay>();
				List<Employee> employees = new ArrayList<Employee>();
				employees = EmployeeLocalServiceUtil.findEmoployeeByStatus(0);
				if(Validator.isNotNull(monthYear)){
				    	//adjustments = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByMonthYear(Long.valueOf(monthYear));			    	
				    	 DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MonthlyAdjustment.class,PortalClassLoaderUtil.getClassLoader());
				    	 dynamicQuery.add(PropertyFactoryUtil.forName("monthYear").eq(Long.valueOf(monthYear)));
				    	 Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("employeeId"));
				    	 dynamicQuery.setProjection(projection);
				    	 try{
				    		 adjustments = MonthlyAdjustmentLocalServiceUtil.dynamicQuery(dynamicQuery);
				    	 }catch (Exception e) {
				    		 System.out.println("There is no data in monthly adjustment...!");
						}
				    	  
				    	try{
				    		stopPaylist = StopPayLocalServiceUtil.findStopPayByMonthYearAndStatus(Long.valueOf(monthYear), 0);
				    	}catch (Exception e) {
				    		 System.out.println("There is no data in Stop Pay...!");
						}
				    	System.out.println("stopPaylist "+stopPaylist.size()+" adjustments..."+adjustments.size());	
				    	int finalSalaryProcess = employees.size()-stopPaylist.size();
				    	jsonObject.put("stopPaylist", stopPaylist.size());
				    	jsonObject.put("adjustments", adjustments.size());
				    	jsonObject.put("salaryProcessCount",finalSalaryProcess);
				    }
				PrintWriter writer = response.getWriter();			
			    writer.print(jsonObject);		
			}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		}
		if(cmd.trim().equalsIgnoreCase("salaryProcess")){
			List<Employee>  employees = new ArrayList<>();
			String month = ParamUtil.getString(request, "month", StringPool.BLANK);
			String year = ParamUtil.getString(request, "year", StringPool.BLANK);
			boolean finalProcess  = ParamUtil.getBoolean(request, "finalProcess");
			
			List<String> earningList = new ArrayList<String>();
			earningList.add(SalaryProcessPortletKeys.Earning);
			earningList.add(SalaryProcessPortletKeys.Overtime);
			earningList.add(SalaryProcessPortletKeys.Reimbursement);
			earningList.add(SalaryProcessPortletKeys.StatutoryComponent);
			List<MonthlyAdjustment> adjustments = new ArrayList<>();
			List<StopPay>  stopPaylist = new ArrayList<>();
			try{
				adjustments = new ArrayList<MonthlyAdjustment>();
			}catch (Exception e) {
	    		 System.out.println("There is no data in monthly adjustment...!");
			}
			String monthYear = month+year;
			
			long providentfundCurrentMonth = 0;
			System.out.println("finalProcess..."+finalProcess);
			//ArrayList<Long> empIds=new ArrayList<>();
			try{
				stopPaylist = StopPayLocalServiceUtil.findStopPayByMonthYearAndStatus(Long.valueOf(monthYear), 0);
			}catch (Exception e) {
	    		 System.out.println("There is no data in Stop Pay...!");
			}
			long[] empIds = new long[stopPaylist.size()];
			int i=0;
			for(StopPay pay:stopPaylist){
				empIds[i] = pay.getEmployeeId();
				i++;
			}
			//	long[] empIds = {1,101};
			employees = EmployeeLocalServiceUtil.findEmployeeByStatusAndEmployeeIdNotIn(0, empIds);
			//employees = EmployeeLocalServiceUtil.findEmoployeeByStatus(0);
			System.out.println("employeeList..."+employees.size());
			List<EmpPayStructure> empPayStructureList = new ArrayList<>();
			List<MonthlyAdjustment> adjustmentList  = new ArrayList<>();
			long finSalaryId = CounterLocalServiceUtil.increment(FinSalary.class.getName());
			FinSalary finSalary = FinSalaryLocalServiceUtil.createFinSalary(finSalaryId);
			long totalEnaring = 0;
			long totalDedction = 0;
			long totalPay = 0;
			FinSalary finalSalary = null;
			try {
				finalSalary = FinSalaryLocalServiceUtil.findFinSalaryByMonthYear(Integer.valueOf(monthYear));
			} catch (NoSuchFinSalaryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(employees.size()>0){
				for(Employee emp:employees){
					
					try{
						empPayStructureList = EmpPayStructureLocalServiceUtil.findEmpPayStructureByEmployeeId(emp.getEmployeeId());
					}catch (Exception e) {
						// TODO: handle exception
					}
					if(empPayStructureList.size()>0){
						for(EmpPayStructure empPayStructure:empPayStructureList){
							//SalDetails salDetails = null;
							SalDetails details = null;
							boolean isSalDetails = false;
							try{
								details = SalDetailsLocalServiceUtil.findSalDetailsByEmployeeIdAndcomponentIdAndMonthYear(emp.getEmployeeId(), empPayStructure.getPayComponentId(),Long.valueOf(monthYear));						
							}catch (Exception e) {
								// TODO: handle exception
								//e.printStackTrace();
							}
							if(Validator.isNull(details)){	
							long salDetailsId = CounterLocalServiceUtil.increment(SalDetails.class.getName());	
							details = SalDetailsLocalServiceUtil.createSalDetails(salDetailsId);
							isSalDetails = true;
							}
							boolean isMonthlyAdjustment = false;
							details.setMonthYear(Long.valueOf(monthYear));
							details.setEmployeeId(emp.getEmployeeId());
							details.setComponentId(empPayStructure.getPayComponentId());
							try{
								adjustmentList = MonthlyAdjustmentLocalServiceUtil.findMonthlyAdjustmentByMonthYearAndEmployeeId(Long.valueOf(monthYear), emp.getEmployeeId());
							}catch (Exception e) {
					    		 System.out.println("There is no data in monthly adjustment...!");
							}
					    	  
							if(adjustmentList.size()>0){
								for(MonthlyAdjustment adjustment:adjustmentList){
									if(empPayStructure.getPayComponentId()==adjustment.getPayComponentId()){
										details.setValue(empPayStructure.getComponentValue()+adjustment.getAmount());
										isMonthlyAdjustment = true;
									}
								}								
							}
							if(isMonthlyAdjustment==false){
								details.setValue(empPayStructure.getComponentValue());	
							}
							//get total earning
						
							PayComponent component;
							try {
								component = PayComponentLocalServiceUtil.getPayComponent(details.getComponentId());
								if (earningList.contains(component.getPayType())) {
									totalEnaring += details.getValue();
								}else if (component.getPayType().equalsIgnoreCase(SalaryProcessPortletKeys.Deduction)) {
									totalDedction += details.getValue();
								}
							} catch (PortalException e) {
								e.printStackTrace();
							}
							
							//total dedction
							
							
							totalPay  = (totalEnaring - totalDedction);
							if(Validator.isNull(finalSalary)){
								//if(finalProcess){								
									if(isSalDetails){							
										SalDetailsLocalServiceUtil.addSalDetails(details);
									}else{
										SalDetailsLocalServiceUtil.updateSalDetails(details);
									}
								/*}else{
									if(isSalDetails){							
										SalDetailsLocalServiceUtil.addSalDetails(details);
									}else{
										SalDetailsLocalServiceUtil.updateSalDetails(details);
									}
								}*/
							}	
						}
					}
					
					try {
						SalaryProcessUtil.incomeTaxCalcualtion(emp.getEmployeeId(),providentfundCurrentMonth,month,year,finalProcess,earningList);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchTaxDeclarationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(finalProcess==true){
					FinSalary fnSalary = null;
					try {
						fnSalary = FinSalaryLocalServiceUtil.findFinSalaryByMonthYear(Integer.valueOf(monthYear));
					} catch (NoSuchFinSalaryException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finSalary.setMonthYear(Long.valueOf(monthYear));
					finSalary.setIsLock(0);
					finSalary.setCreatedBy(themeDisplay.getUserId());
					finSalary.setCreatedDate(new Date());
					finSalary.setTotalAmount(totalPay);
					finSalary.setTotalDeduction(totalDedction);
					finSalary.setTotalEarning(totalEnaring);
					if(Validator.isNull(fnSalary)){
						FinSalaryLocalServiceUtil.addFinSalary(finSalary);
					}
				}
				
				
			}			
		}	
		
		
    }
	
	
}