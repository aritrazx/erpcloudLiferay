package com.liferay.famocom.erpcloud.employeedetails.asset;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.service.EmployeeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ResourceBundleLoader;


@Component(
		 immediate = true,
		 property = {"javax.portlet.name=EmployeeDetails"},
		 service = AssetRendererFactory.class
		 )

public class EmployeeDetailsAssetRenderFactory extends BaseAssetRendererFactory<Employee>{
	
	private EmployeeLocalService employeeService;
	 private ResourceBundleLoader resourceBundleLoader;
	 private ServletContext servletContext;
	 
	 
	 @Reference(unbind = "-")
	 protected void setLeaveService(EmployeeLocalService employeeService) {
	      this.employeeService = employeeService;
	 }


	 @Reference(unbind = "-")
	 public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
	     this.resourceBundleLoader = resourceBundleLoader;
	 }

	 @Reference(unbind = "-")
	 public void setServletContext(ServletContext servletContext) {
	     this.servletContext = servletContext;
	 }
	 
	 public EmployeeDetailsAssetRenderFactory() {
	        setClassName( Employee.class.getName());
	        setCategorizable(true);
	        setLinkable(true);
	        setPortletId("EmployeeDetails");
	        setSearchable(true);
	         setSelectable(true);
	 }

	 @Override
	 public AssetRenderer<Employee> getAssetRenderer(long classPK, int type) throws PortalException {
	      Employee employee = employeeService.getEmployee(classPK);
	      EmployeeDetailsAssetRenderer assetRenders = new EmployeeDetailsAssetRenderer(employee, resourceBundleLoader);
	      assetRenders.setAssetRendererType(type);
	      assetRenders.setServletContext(servletContext);
	     return assetRenders;
	 }

	 @Override
	 public String getType() {
	     return "EmployeeDetails";
	 }

	 @Override
	 public String getClassName() {
	     return Employee.class.getName();
	 }

}
