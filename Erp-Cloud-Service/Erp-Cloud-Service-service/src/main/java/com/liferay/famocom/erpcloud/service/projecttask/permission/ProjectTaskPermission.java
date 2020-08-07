package com.liferay.famocom.erpcloud.service.projecttask.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.ProjectTask;
import com.liferay.famocom.erpcloud.service.ProjectTaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.liferay.famocom.erpcloud.model.ProjectTask"}
	)

public class ProjectTaskPermission implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		// TODO Auto-generated method stub
		
	}

		
	   public static void check(
		        PermissionChecker permissionChecker, long projectTaskId, String actionId)
		        throws PortalException, SystemException {

		        if (!contains(permissionChecker, projectTaskId, actionId)) {
		            throw new PrincipalException();
		        }
		    }

		    public static void check(
		        PermissionChecker permissionChecker, long groupId, long projectTaskId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, ProjectTask.class.getName(), projectTaskId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long projectTaskId, String actionId) 
		            throws PortalException {
		    	
		       
		    	ProjectTask projectTask = _projectTaskLocalService.getProjectTask(projectTaskId);

		        return ProjectTaskModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long projectTaskId, String actionId)
		        throws PortalException, SystemException {

		    	ProjectTask projectTask =  _projectTaskLocalService.getProjectTask(projectTaskId);
		        return contains(permissionChecker, projectTask, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, ProjectTask projectTask, String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		projectTask.getProjectTaskId(), ProjectTask.class.getName(), projectTask.getProjectTaskId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setProjectTaskLocalService(ProjectTaskLocalService projectTaskLocalService) {
		    	_projectTaskLocalService = projectTaskLocalService;
		    }

		    private static ProjectTaskLocalService _projectTaskLocalService;
		    

}
