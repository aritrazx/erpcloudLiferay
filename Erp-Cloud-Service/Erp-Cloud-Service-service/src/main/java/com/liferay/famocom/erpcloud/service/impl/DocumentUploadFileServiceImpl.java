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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.base.DocumentUploadFileServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

/**
 * The implementation of the document upload file remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.DocumentUploadFileService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Samaresh
 * @see DocumentUploadFileServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.DocumentUploadFileServiceUtil
 */
public class DocumentUploadFileServiceImpl
	extends DocumentUploadFileServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.DocumentUploadFileServiceUtil} to access the document upload file remote service.
	 */
	@AccessControlled(guestAccessEnabled=true)
	public ArrayList<HashMap<String, String>> getFilesFromFolderName(String folderName) throws PortalException{
		
		//folderName = "SONY_BANNER";
		//List<String> fileList = new ArrayList<String>();
		ArrayList<HashMap<String, String>> fileList = new ArrayList<HashMap<String, String>>();
		Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
		Group defaultGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), "Guest");
		long groupId = defaultGroup.getGroupId();
		System.out.println("groupId... : "+groupId);
		DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, 0, folderName);		
		List<DLFileEntry> dlFileEntryList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, dlFolder.getFolderId());
		System.out.println("dlFileEntry : "+dlFileEntryList.size());
		String filePath = "";
		StringBundler sb = new StringBundler(17);
		for(DLFileEntry fileEntry : dlFileEntryList){
			HashMap<String, String> hashmap = new HashMap<>();
			sb.append(PortalUtil.getPathContext());
			sb.append("/documents/");
			sb.append(fileEntry.getRepositoryId());
			sb.append(StringPool.SLASH);
			sb.append(fileEntry.getFolderId());
			sb.append(StringPool.SLASH);
			String fileTitle = fileEntry.getTitle();
			sb.append(HttpUtil.encodeURL(HtmlUtil.unescape(fileTitle)));
			sb.append(StringPool.SLASH);
			sb.append(fileEntry.getUuid());
			filePath = sb.toString();
			System.out.println("filePath : "+filePath);
			hashmap.put("folderId", String.valueOf(fileEntry.getFolderId()));
			hashmap.put("fileEntryId", String.valueOf(fileEntry.getFileEntryId()));
			hashmap.put("fileTitle",fileEntry.getTitle());
			hashmap.put("filePath", filePath);
			fileList.add(hashmap);
		}
		System.out.println("dlFileEntry... : "+dlFileEntryList.size());
		System.out.println("dlFileEntry.....>> : "+dlFileEntryList);
		return fileList;
		
	}

	
}