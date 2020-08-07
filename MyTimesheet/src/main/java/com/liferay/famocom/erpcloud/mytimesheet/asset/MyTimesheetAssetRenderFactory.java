package com.liferay.famocom.erpcloud.mytimesheet.asset;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.famocom.erpcloud.model.TimeSheetMaster;
import com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
@Component(
		 immediate = true,
		 property = {"javax.portlet.name=MyTimesheet"},
		 service = AssetRendererFactory.class
		 )
public class MyTimesheetAssetRenderFactory extends BaseAssetRendererFactory<TimeSheetMaster> {
	 private TimeSheetMasterLocalService timesheetService;
	 private ResourceBundleLoader resourceBundleLoader;
	 private ServletContext servletContext;

	 @Reference(unbind = "-")
	 protected void setTimeSheetMasterService(TimeSheetMasterLocalService timesheetService) {
	      this.timesheetService = timesheetService;
	 }


	 @Reference(unbind = "-")
	 public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
	     this.resourceBundleLoader = resourceBundleLoader;
	 }

	 @Reference(unbind = "-")
	 public void setServletContext(ServletContext servletContext) {
	     this.servletContext = servletContext;
	 }
	 
	 public MyTimesheetAssetRenderFactory() {
	        setClassName( TimeSheetMaster.class.getName());
	        setCategorizable(true);
	        setLinkable(true);
	        setPortletId("MyTimesheet");
	        setSearchable(true);
	         setSelectable(true);
	 }
	@Override
	public AssetRenderer<TimeSheetMaster> getAssetRenderer(long classPK, int type) throws PortalException {
		// TODO Auto-generated method stub
		TimeSheetMaster timeSheetMaster = timesheetService.getTimeSheetMaster(classPK);
	      MyTimesheetAssetRenderer assetRenders = new MyTimesheetAssetRenderer(timeSheetMaster, resourceBundleLoader);
	      assetRenders.setAssetRendererType(type);
	      assetRenders.setServletContext(servletContext);
	     return assetRenders;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "MyTimesheet";
	}
	 @Override
	 public String getClassName() {
	     return TimeSheetMaster.class.getName();
	 }

}
