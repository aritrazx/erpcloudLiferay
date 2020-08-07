package com.liferay.famocom.erpcloud.leave.permission;

import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.service.LeaveTypeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionCheckerUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

public class LeaveTypePermission extends BaseModelPermissionCheckerUtil {


	   public static void check(
		        PermissionChecker permissionChecker, long appraisalSetupId, String actionId)
		        throws PortalException, SystemException {

		        if (!contains(permissionChecker, appraisalSetupId, actionId)) {
		            throw new PrincipalException();
		        }
		    }

		    public static void check(
		        PermissionChecker permissionChecker, long groupId, long leaveTypeId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, LeaveType.class.getName(), leaveTypeId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long leaveTypeId, String actionId) 
		            throws PortalException {
		    	
		       
		    	LeaveType leaveType = _leaveTypeLocalService.getLeaveType(leaveTypeId);

		        return LeaveTypeModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long leaveTypeId, String actionId)
		        throws PortalException, SystemException {

		    	LeaveType leaveType = _leaveTypeLocalService.getLeaveType(leaveTypeId);
		        return contains(permissionChecker, leaveType, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, LeaveType leaveType, String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		leaveType.getLeaveTypeId(), LeaveType.class.getName(), leaveType.getLeaveTypeId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setLeaveTypeLocalService(LeaveTypeLocalService leaveTypeLocalService ) {
		    	_leaveTypeLocalService = leaveTypeLocalService;
		    }

		    private static LeaveTypeLocalService _leaveTypeLocalService;

}
