package Payroll.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.famocom.erpcloud.exception.NoSuchEmpPayStructureException;
import com.liferay.famocom.erpcloud.model.EmpPayStructure;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.MonthlyAdjustment;
import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.service.EmpPayStructureLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import Payroll.constants.PayrollPortletKeys;

public class PayrollUtil {
	
	public static ArrayList<HashMap<String, String>>  getPayComponent(String employeeId,String month,String year){		
		System.out.println("employeeId....." + employeeId);
		String monthYear = month+year;
		ArrayList<HashMap<String, String>> componentList = new ArrayList<HashMap<String, String>>();
		//List<EmpPayStructure> empPayStructureList = new ArrayList<EmpPayStructure>();
		List<String> earningList = new ArrayList<String>();
		earningList.add(PayrollPortletKeys.Earning);
		earningList.add(PayrollPortletKeys.Overtime);
		earningList.add(PayrollPortletKeys.Reimbursement);
		earningList.add(PayrollPortletKeys.StatutoryComponent);
		List<PayComponent> payComponentList = new ArrayList<PayComponent>();
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
										double adjustmentAmount = adjustment.getAmount();
										String adjustmentAmountStr = StringPool.BLANK;
										if(adjustmentAmount>0){
											adjustmentAmountStr = "+"+String.valueOf(adjustmentAmount);
										}else{
											adjustmentAmountStr = String.valueOf(adjustmentAmount);
										}
										payComponent.setComponentValueFormula(adjustmentAmountStr);
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
					
					 payComponentList.add(payComponent);
			 
				 	}
				 
			 }
		}
			/*else {
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
			}*/
			if(Validator.isNotNull(payComponentList)){
				for (PayComponent component : payComponentList) { 	
					    HashMap<String,String> hashMap = new HashMap<>();
					    hashMap.put("payType", component.getPayType());
					    hashMap.put("payComponentId", String.valueOf(component.getComponentId()));
					    hashMap.put("name", component.getName());
					    hashMap.put("amount", String.valueOf(component.getAmount()));
					    hashMap.put("adjustmentAmount", component.getComponentValueFormula());
						//System.out.println("component..."+component);
						componentList.add(hashMap);
						//System.out.println("componentList..."+componentList);
				}
			}
		
		return componentList;
	}
	// checking userscrore and totalPay from formula
	public static boolean checkUnderscoreAndTotalPay(String equation) {
		// TODO Auto-generated method stub
		boolean isUnderscroreAndTotalPay = true;
		if(!equation.contains("TotalPay")){
			System.out.println("inside TotalPay...!");
			if(!equation.contains("_")){
				System.out.println("inside underscore...!");
				isUnderscroreAndTotalPay = false;
			}
		}
		return isUnderscroreAndTotalPay;
	}
	public  static double computeAnother(String equation) {
	    	double result = 0.00;
	    	if(equation.contains("(")){
		    	 Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(equation);
		    	 while(m.find()) {
		    		   double value=0;
		    		   value = compute(m.group(1));
		    	       result +=value;
		    	       equation = equation.replace("("+m.group(1)+")",String.valueOf(value));
		    	 }
		    	 result = compute(equation);
	    	}else{	        
	    		result = compute(equation);
	    	}
	        return result;
	    }
	 public  static double compute(String equation) {
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
		        System.out.println("............."+result);
	        return result;
	    }
	 //get new Added component value from formula
     public  static double getComponentAmountByFormula(long employeeId,HashMap<String, String> componentIdAndformula,long payComponentId){
    	 List<EmpPayStructure>  empPayStructures = new ArrayList<EmpPayStructure>();
    	 double totalPay = 0;
    	 double  currentPayComponentId=0;
    	 try{
    	  empPayStructures = EmpPayStructureLocalServiceUtil.findEmpPayStructureByEmployeeId(employeeId);
    	 }catch (Exception e) {
			// TODO: handle exception
		}
    	 if(empPayStructures.size()>0){
    		  HashMap<String, Double> componentAndAmount = new HashMap<>();
    		  Employee employee = null;
    		  try{
    			  employee = EmployeeLocalServiceUtil.getEmployee(employeeId); 
    		  }catch (Exception e) {
				// TODO: handle exception
			}
    		  if(Validator.isNotNull(employee)){
    			 totalPay = employee.getPayPerMonth();  
    			 componentAndAmount.put("TotalPay", totalPay);
    		  }
    		 for (EmpPayStructure empPayStructure : empPayStructures) {
    			 componentAndAmount.put(empPayStructure.getPayComponentId()+"_", empPayStructure.getComponentValue());
			   }
    		
 					componentAndAmount =  getAmountListByComponentId(componentIdAndformula,componentAndAmount);
 					System.out.println("componentAndAmount.......... "+componentAndAmount);
 					currentPayComponentId = componentAndAmount.get(payComponentId+"_");
 			
    	 }
    	 return currentPayComponentId;
     }
     
     public static HashMap<String, Double> getAmountListByComponentId(HashMap<String, String> componentIdAndformula ,HashMap<String, Double> componentAndAmount) {
 		// TODO Auto-generated method stub
 		
 		for(Map.Entry<String, String> entry : componentIdAndformula.entrySet() ){
 			boolean isAmountAdded = false;
 			String formula = entry.getValue();
 			boolean isUnderscroreAndTotalPay = checkUnderscoreAndTotalPay(formula);
 			if(isUnderscroreAndTotalPay==false){
 				double amount =  computeAnother(formula);					
 				System.out.println("isUnderscroreAndTotalPay false....amount........."+amount);
 				componentAndAmount.put(entry.getKey(), amount);
 			}else{
 				for(Map.Entry<String, Double> ent : componentAndAmount.entrySet() ){
 					if(Validator.isNotNull(ent.getValue())){
 						if(formula.contains(ent.getKey())){
 						    formula = formula.replaceAll(ent.getKey(), String.valueOf(ent.getValue()));
 							isUnderscroreAndTotalPay = checkUnderscoreAndTotalPay(formula);
 							if(isUnderscroreAndTotalPay==false){							
 								double amount = computeAnother(formula);					
 								System.out.println("isUnderscroreAndTotalPay...true........."+amount);
 								componentAndAmount.put(entry.getKey(), amount);
 								isAmountAdded = true;
 							}
 						}
 					}
 					if(isAmountAdded==true){
 						break ;
 					}
 				}
 			}
 			System.out.println("componentAndAmount.......... "+componentAndAmount);
 		}
 		return componentAndAmount;
 	}
}
