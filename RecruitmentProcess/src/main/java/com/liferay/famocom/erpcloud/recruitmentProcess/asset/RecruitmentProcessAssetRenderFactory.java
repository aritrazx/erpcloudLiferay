package com.liferay.famocom.erpcloud.recruitmentProcess.asset;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.famocom.erpcloud.model.RecruitmentProcess;
import com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ResourceBundleLoader;


@Component(
		 immediate = true,
		 property = {"javax.portlet.name=RecruitmentProcess"},
		 service = AssetRendererFactory.class
		 )
public class RecruitmentProcessAssetRenderFactory extends BaseAssetRendererFactory<RecruitmentProcess> {
	
	private RecruitmentProcessLocalService recruitmentProcessService;
	 private ResourceBundleLoader resourceBundleLoader;
	 private ServletContext servletContext;
	 
	 @Reference(unbind = "-")
	 protected void setLeaveService(RecruitmentProcessLocalService recruitmentProcessService) {
	      this.recruitmentProcessService = recruitmentProcessService;
	 }


	 @Reference(unbind = "-")
	 public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
	     this.resourceBundleLoader = resourceBundleLoader;
	 }

	 @Reference(unbind = "-")
	 public void setServletContext(ServletContext servletContext) {
	     this.servletContext = servletContext;
	 }
	
	 public RecruitmentProcessAssetRenderFactory() {
	        setClassName( RecruitmentProcess.class.getName());
	        setCategorizable(true);
	        setLinkable(true);
	        setPortletId("RecruitmentProcess");
	        setSearchable(true);
	         setSelectable(true);
	 }

	 
	@Override
	public AssetRenderer<RecruitmentProcess> getAssetRenderer(long classPK, int type) throws PortalException {
		// TODO Auto-generated method stub
		RecruitmentProcess recruitmentProcess = recruitmentProcessService.getRecruitmentProcess(classPK);
		RecruitmentProcessAssetRenderer assetRenders = new RecruitmentProcessAssetRenderer(recruitmentProcess, resourceBundleLoader);
	      assetRenders.setAssetRendererType(type);
	      assetRenders.setServletContext(servletContext);
	     return assetRenders;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "RecruitmentProcess";
	}
	 @Override
	 public String getClassName() {
	     return RecruitmentProcess.class.getName();
	 }

}
