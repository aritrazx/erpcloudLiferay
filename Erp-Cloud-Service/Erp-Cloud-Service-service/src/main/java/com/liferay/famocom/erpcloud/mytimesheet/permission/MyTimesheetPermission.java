package com.liferay.famocom.erpcloud.mytimesheet.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.TimeSheetEntry;
import com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.liferay.famocom.erpcloud.model.TimeSheetEntry"}
	)

public class MyTimesheetPermission implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		// TODO Auto-generated method stub
		
	}

		
	   public static void check(
		        PermissionChecker permissionChecker, long timesheetId, String actionId)
		        throws PortalException, SystemException {

		        if (!contains(permissionChecker, timesheetId, actionId)) {
		            throw new PrincipalException();
		        }
		    }

		    public static void check(
		        PermissionChecker permissionChecker, long groupId, long timesheetId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, TimeSheetEntry.class.getName(), timesheetId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long timesheetId, String actionId) 
		            throws PortalException {
		    	
		       
		    	TimeSheetEntry timeSheetEntry = _timeSheetEntryLocalService.getTimeSheetEntry(timesheetId);

		        return MyTimesheetModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long timesheetId, String actionId)
		        throws PortalException, SystemException {

		    	TimeSheetEntry timeSheetEntry = _timeSheetEntryLocalService.getTimeSheetEntry(timesheetId);
		        return contains(permissionChecker, timeSheetEntry, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, TimeSheetEntry timeSheetEntry, String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		timeSheetEntry.getTimesheetId(), TimeSheetEntry.class.getName(), timeSheetEntry.getTimesheetId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setTimeSheetEntryLocalService(TimeSheetEntryLocalService timeSheetEntryLocalService) {
		    	_timeSheetEntryLocalService = timeSheetEntryLocalService;
		    }

		    private static TimeSheetEntryLocalService _timeSheetEntryLocalService;
		    

}
