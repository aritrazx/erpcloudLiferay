package com.liferay.famocom.erpcloud.service.projectmaster.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.ProjectMaster;
import com.liferay.famocom.erpcloud.service.ProjectMasterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.liferay.famocom.erpcloud.model.ProjectMaster"}
	)

public class ProjectMasterPermission implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		// TODO Auto-generated method stub
		
	}

		
	   public static void check(
		        PermissionChecker permissionChecker, long projectId, String actionId)
		        throws PortalException, SystemException {

		        if (!contains(permissionChecker, projectId, actionId)) {
		            throw new PrincipalException();
		        }
		    }

		    public static void check(
		        PermissionChecker permissionChecker, long groupId, long projectId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, ProjectMaster.class.getName(), projectId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long projectId, String actionId) 
		            throws PortalException {
		    	
		       
		    	ProjectMaster projectMaster = _projectMasterLocalService.getProjectMaster(projectId);

		        return ProjectMasterModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long projectId, String actionId)
		        throws PortalException, SystemException {

		    	ProjectMaster projectMaster =  _projectMasterLocalService.getProjectMaster(projectId);
		        return contains(permissionChecker, projectMaster, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, ProjectMaster projectMaster, String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		projectMaster.getProjectId(), ProjectMaster.class.getName(), projectMaster.getProjectId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setProjectMasterLocalService(ProjectMasterLocalService projectMasterLocalService) {
		    	_projectMasterLocalService = projectMasterLocalService;
		    }

		    private static ProjectMasterLocalService _projectMasterLocalService;
		    

}
