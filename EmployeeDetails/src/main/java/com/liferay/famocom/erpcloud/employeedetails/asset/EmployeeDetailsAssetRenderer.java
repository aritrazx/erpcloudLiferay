package com.liferay.famocom.erpcloud.employeedetails.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

public class EmployeeDetailsAssetRenderer extends BaseJSPAssetRenderer<Employee> {
	
	private final Employee employee;
	private final ResourceBundleLoader resourceBundleLoader;
	
	public EmployeeDetailsAssetRenderer(Employee employee, ResourceBundleLoader resourceBundleLoader) {
	      this.employee = employee;
	      this.resourceBundleLoader = resourceBundleLoader;
	 }

	@Override
	public Employee getAssetObject() {
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return employee.getGroupId();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		 return employee.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		 return employee.getFirstName();
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return employee.getUserUuid();
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		 return Employee.class.getName();
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return employee.getEmployeeId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		 return employee.getFirstName()+ " "+employee.getLastName()+",New Employee from:"+employee.getDateOfJoing();
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return employee.getFirstName()+ " "+employee.getLastName();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		// TODO Auto-generated method stub
		 return null;
	}
}
