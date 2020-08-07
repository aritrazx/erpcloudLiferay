package com.liferay.famocom.erpcloud.service.salaryprocess.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.SalDetails;
import com.liferay.famocom.erpcloud.service.PayComponentLocalService;
import com.liferay.famocom.erpcloud.service.SalDetailsLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.liferay.famocom.erpcloud.model.SalDetails"}
	)
public class SalaryProcessPermission  implements BaseModelPermissionChecker{
	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		// TODO Auto-generated method stub
		
	}

		
	   public static void check(
		        PermissionChecker permissionChecker, long payComponentId, String actionId)
		        throws PortalException, SystemException {

		        if (!contains(permissionChecker, payComponentId, actionId)) {
		            throw new PrincipalException();
		        }
		    }

	   public static void check(
		        PermissionChecker permissionChecker, long groupId, long salDetailsId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, SalDetails.class.getName(), salDetailsId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long salDetailsId, String actionId) 
		            throws PortalException {
		    	
		       
		    	SalDetails details = _detailsLocalService.getSalDetails(salDetailsId);

		        return SalDetailsModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
			        PermissionChecker permissionChecker, long SalDetailsId, String actionId)
			        throws PortalException, SystemException {

			    	SalDetails salDetails = _detailsLocalService.getSalDetails(SalDetailsId);
			        return contains(permissionChecker, salDetails, actionId);
			    }


		    public static boolean contains(
		        PermissionChecker permissionChecker, SalDetails salDetails, String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		salDetails.getComponentId(), SalDetails.class.getName(), salDetails.getComponentId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setAppraisalSetupLocalService(PayComponentLocalService componentLocalService) {
		    	_detailsLocalService = _detailsLocalService;
		    }

		    private static SalDetailsLocalService _detailsLocalService ;  
		    
	
}
