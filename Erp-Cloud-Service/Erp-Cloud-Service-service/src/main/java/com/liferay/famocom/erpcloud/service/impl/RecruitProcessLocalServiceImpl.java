/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.famocom.erpcloud.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.famocom.erpcloud.exception.NoSuchRecruitProcessException;
import com.liferay.famocom.erpcloud.model.RecruitProcess;
import com.liferay.famocom.erpcloud.service.base.RecruitProcessLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the recruit process local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.RecruitProcessLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see RecruitProcessLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil
 */
public class RecruitProcessLocalServiceImpl
	extends RecruitProcessLocalServiceBaseImpl {
	public RecruitProcess findByrecruitProcess(long employeeId) throws SystemException{
		RecruitProcess recruit=null;
		try {
			recruit = getRecruitProcessPersistence().findByrecruitProcess(employeeId);
		} catch (NoSuchRecruitProcessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recruit;
		}
	
	public List<RecruitProcess> findByrecruitProcessCol(long employeeId) throws SystemException, NoSuchRecruitProcessException{
		List<RecruitProcess> recruitCol=null;
		recruitCol = getRecruitProcessPersistence().findByrecruitProcessCol(employeeId);
		return recruitCol;
		}
	
	public Map<Long, String> getResumeFileUpload(String name, File file, long userId, String donaminName)
			throws IOException, PortalException {
			Map<Long, String> map = new HashMap<>();
			// System.out.println("strImage : "+strImage);
			// i'm trying to save the image in document and librery
			try {
			Random rand = new Random();
			double rand_dub = rand.nextDouble() * 10000;
			String prefix = String.valueOf(Math.round(rand_dub));
			String fileName = prefix + name;
			String fileUrl = StringPool.BLANK;
			// File reimbursementFile = new File(name);
			// System.out.println("image : " + reimbursementFile);
			String fileTitle = "resume_" + fileName;
			FileEntry fileEntry = null;

			String contentType = MimeTypesUtil.getContentType(file);
			InputStream inputStream = new FileInputStream(file);
			System.out.println("inputStream : " + inputStream);
			ServiceContext serviceContext = new ServiceContext();
			// Add Guest Permission for Documents
			System.out.println("resumeFolder : ");
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setAddGuestPermissions(true);

			Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			Group defaultGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), "Guest");
			System.out.println("defaultGroup.getGroupId() " + defaultGroup.getGroupId());
			serviceContext.setScopeGroupId(defaultGroup.getGroupId());
			DLFolder resumeFolder = getResumeFolder(serviceContext, userId);

			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, resumeFolder.getRepositoryId(),
			resumeFolder.getFolderId(), file.getName(), contentType, fileTitle, fileTitle, "changeLog",
			inputStream, file.length(), serviceContext);

			if (Validator.isNotNull(fileEntry)) {
			fileUrl = donaminName + "/documents/" + serviceContext.getScopeGroupId() + "/"
			+ resumeFolder.getFolderId() + "/"
			+ HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()));
			map.put(fileEntry.getFileEntryId(), fileUrl);

			}
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
			return map;
			}
			private DLFolder getResumeFolder(ServiceContext serviceContext, long userId) throws PortalException {
			System.out.println("serviceContext " + serviceContext + "userId" + userId);
			DLFolder resumeFolder = null;
			;
			try {
			System.out.println("##### before try ######");

			resumeFolder = DLFolderLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(),
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Resume");
			System.out.println("resumeFolder"+resumeFolder);
			if (resumeFolder == null) {
			resumeFolder = DLFolderLocalServiceUtil.addFolder(userId, serviceContext.getScopeGroupId(),
			serviceContext.getScopeGroupId(), Boolean.FALSE, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
			"Resume", StringPool.BLANK, Boolean.FALSE, serviceContext);
			System.out.println("##### Created resume folder successfully ######");
			}else{
			System.out.println("##### all ready exist ######" + resumeFolder);
			}
			} catch (Exception e) {
			e.printStackTrace();

			/*
			* reimbursementFolder = DLFolderLocalServiceUtil.addFolder(userId,
			* serviceContext.getScopeGroupId(),
			* serviceContext.getScopeGroupId(), Boolean.FALSE,
			* DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Reimbursement",
			* StringPool.BLANK, Boolean.FALSE, serviceContext); System.out.
			* println("##### Created resume folder successfully ######");
			*/
			}
			return resumeFolder;
			}
}