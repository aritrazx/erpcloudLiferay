package com.liferay.famocom.erpcloud.service.teammember.permission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.famocom.erpcloud.model.AddTeamMember;
import com.liferay.famocom.erpcloud.service.AddTeamMemberLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {"model.class.name=com.liferay.famocom.erpcloud.model.AddTeamMember"}
	)

public class TeamMemberPermission implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		// TODO Auto-generated method stub
		
	}

		
	   public static void check(
		        PermissionChecker permissionChecker, long projectTeamsId, String actionId)
		        throws PortalException, SystemException {

		        if (!contains(permissionChecker, projectTeamsId, actionId)) {
		            throw new PrincipalException();
		        }
		    }

		    public static void check(
		        PermissionChecker permissionChecker, long groupId, long projectTeamsId,
		        String actionId)
		        throws PortalException {

		        if (!contains(permissionChecker, groupId, actionId)) {
		            throw new PrincipalException.MustHavePermission(
		                permissionChecker, AddTeamMember.class.getName(), projectTeamsId,
		                actionId);
		        }
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long groupId, long projectTeamsId, String actionId) 
		            throws PortalException {
		    	
		       
		    	AddTeamMember addTeamMember = _addTeamMemberLocalService.getAddTeamMember(projectTeamsId);

		        return TeamMemberModelPermission.contains(permissionChecker, groupId, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, long projectTeamsId, String actionId)
		        throws PortalException, SystemException {

		    	AddTeamMember addTeamMember =  _addTeamMemberLocalService.getAddTeamMember(projectTeamsId);
		        return contains(permissionChecker, addTeamMember, actionId);
		    }

		    public static boolean contains(
		        PermissionChecker permissionChecker, AddTeamMember addTeamMember , String actionId) 
		            throws PortalException, SystemException {

		        return permissionChecker.hasPermission(
		        		addTeamMember.getProjectTeamsId(), AddTeamMember.class.getName(), addTeamMember.getProjectTeamsId(), actionId);

		    }

		    @Reference(unbind = "-")
		    protected void setAddTeamMemberLocalService(AddTeamMemberLocalService addTeamMemberLocalService) {
		    	_addTeamMemberLocalService = addTeamMemberLocalService;
		    }

		    private static AddTeamMemberLocalService _addTeamMemberLocalService;
		    

}
