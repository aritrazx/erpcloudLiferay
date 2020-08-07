package com.liferay.famocom.erpcloud.service.payroll.permission;

import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.PayComponent;
import com.liferay.famocom.erpcloud.service.PayComponentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.liferay.famocom.erpcloud.model.PayComponent"}
	)
public class PayrollPermission  implements BaseModelPermissionChecker{
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
		        PermissionChecker permissionChecker, long groupId, long payComponentId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, PayComponent.class.getName(), payComponentId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long payComponentId, String actionId) 
		            throws PortalException {
		    	
		       
		    	PayComponent payComponent = _payComponentLocalService.getPayComponent(payComponentId);

		        return PayComponentModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long payComponentId, String actionId)
		        throws PortalException, SystemException {

		    	PayComponent payComponent = _payComponentLocalService.getPayComponent(payComponentId);
		        return contains(permissionChecker, payComponent, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, PayComponent payComponent, String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		payComponent.getComponentId(), PayComponent.class.getName(), payComponent.getComponentId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setAppraisalSetupLocalService(PayComponentLocalService componentLocalService) {
		    	_payComponentLocalService = componentLocalService;
		    }
		    
		    private static PayComponentLocalService _payComponentLocalService;  
		    
	
}
