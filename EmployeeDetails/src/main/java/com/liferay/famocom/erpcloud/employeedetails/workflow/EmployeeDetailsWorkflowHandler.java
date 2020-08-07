package com.liferay.famocom.erpcloud.employeedetails.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.service.EmployeeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

@Component(
		 property = {"model.class.name=com.liferay.famocom.erpcloud.model.Employee"},
		 service = WorkflowHandler.class
		)

public class EmployeeDetailsWorkflowHandler extends BaseWorkflowHandler<Employee>{

	private EmployeeLocalService employeeService;
	   @Reference(unbind = "-")
	   protected void setEmployeeService(EmployeeLocalService employeeService) {
	         this.employeeService = employeeService;
	    }
	   
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Employee.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		// TODO Auto-generated method stub
		return "EmployeeDetails";
	}

	@Override
	public Employee updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		// TODO Auto-generated method stub
		long userId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
	    long employeeId = GetterUtil.getLong((String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
	    ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
	    
	    System.out.println("status=>"+status);
	    Employee employee = employeeService.updateStatus(userId, employeeId, status, serviceContext);
	    return employee;
	}
}
