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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.ExpProofFiles;
import com.liferay.famocom.erpcloud.model.ExpenseEntry;
import com.liferay.famocom.erpcloud.model.ExpenseEntryHistory;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpProofFilesLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.base.ExpenseEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the expense entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Samaresh
 * @see ExpenseEntryLocalServiceBaseImpl
 * @see com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil
 */
public class ExpenseEntryLocalServiceImpl
	extends ExpenseEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil} to access the expense entry local service.
	 */
	
	public List<ExpenseEntry> findByUserId(long userId) {
		List<ExpenseEntry> expList = new ArrayList<ExpenseEntry>();
		if (userId > 0) {
			try {
				expList = expenseEntryPersistence.findByuserId(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return expList;
	}
	

	public static List<String> addExpenseEntrySave(long userId, long projectId, long catId, String title, String description,
			String expDate, Double amount,String name,String strImage, String donaminName) {
		List<String> errorList = new ArrayList<>();

		// Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		String proofName="proof";
		Map<String, String> filemap = new HashMap<>();
		Employee empObj = EmployeeLocalServiceUtil.findByemployees(userId);
		long employeeId = empObj.getEmployeeId();
		long expenseId = CounterLocalServiceUtil.increment(ExpenseEntry.class.getName());
		ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.createExpenseEntry(expenseId);
		if (String.valueOf(userId) == null && String.valueOf(projectId) == null && String.valueOf(catId) == null
				&& title == null && description == null && expDate == null && amount == null) {

			errorList.add("Please Enter the correct Input !!");
		}
		if (errorList.size() == 0) {
			try {
				expEntry.setEmployeeId(employeeId);
				// expEntry.setCompanyId(employee.getCompanyId());
				expEntry.setProjectId(projectId);
				expEntry.setCatId(catId);
				// expEntry.setGroupId(groupId);
				expEntry.setUserId(userId);
				Date date = new Date(); // Local Date fetch........
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String strDate = formatter.format(date);
				expEntry.setCreateDate(date);
				expEntry.setModifiedDate(date);
				expEntry.setTitle(title);
				expEntry.setDescription(description);
				Date expDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(expDate);
				expEntry.setExpDate(expDate1);
				expEntry.setAmount(Double.valueOf(amount));
				/*
				 * if(file!=null){ uploadDocument( request, response ); }
				 */

				ExpenseEntryLocalServiceUtil.addExpenseEntry(expEntry);
				Company company = CompanyLocalServiceUtil
						.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
				Group defaultGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), "Guest");
				expEntry = ExpenseEntryLocalServiceUtil.addExpenseEntry(expEntry);

				long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
				ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
						.createExpenseEntryHistory(expenseHistoryId);
				expenseEntryHistory.setCompanyId(company.getCompanyId());
				expenseEntryHistory.setExpenseId(expEntry.getExpenseId());
				expenseEntryHistory.setStatus(0);
				expenseEntryHistory.setAddeddate(new Date());

				expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);
				System.out.println("insertion of expense entry histry...");
				
				if (strImage != null) {
					filemap =getReimbursementFileUploadForService(name,strImage, userId, donaminName);
					
					String fn1="";
					String fu1="";
					for (Map.Entry<String,String> entry : filemap.entrySet()){
						System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
						 fn1=entry.getKey();
						fu1=entry.getValue();
					}
					long fileId=CounterLocalServiceUtil.increment(ExpProofFiles.class.getName());
					ExpProofFiles expProofFiles=ExpProofFilesLocalServiceUtil.createExpProofFiles(fileId);
					expProofFiles.setCompanyId(company.getCompanyId());
					expProofFiles.setEmployeeId(Long.valueOf(employeeId));
					expProofFiles.setFileName(fn1);
					//expProofFiles.setFileOrigName()
					expProofFiles.setFilePath(fu1);
					expProofFiles.setProofName(proofName);
					expProofFiles.setExpenseId(expenseId);
					expProofFiles.setUploadDate(new Date());
					expProofFiles = ExpProofFilesLocalServiceUtil.addExpProofFiles(expProofFiles);
					System.out.println("insertion of expense entry proof..");
				}	
				 
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return errorList;
		
	}
	
	
	public static Map<String, String> getReimbursementFileUploadForService(String name,String strImage, long userId, String donaminName)
			throws IOException, PortalException {
		Map<String, String> map = new HashMap<>();
		// System.out.println("strImage : "+strImage);
		// i'm trying to save the image in document and librery
		try {
			Random rand = new Random();
			double rand_dub = rand.nextDouble() * 10000;
			String prefix = String.valueOf(Math.round(rand_dub));
			String fileName = prefix + name;
			String fileUrl = StringPool.BLANK;
			 File reimbursementFile = new File(name);
			// System.out.println("image : " + reimbursementFile);
			String fileTitle = "image_" + fileName;
			FileEntry fileEntry = null;
			 FileOutputStream fileOutputStream = new  FileOutputStream(reimbursementFile);
			 fileOutputStream.write(Base64.decode(strImage));
			 System.out.println("fileOutputStream : " + fileOutputStream);
			String contentType = MimeTypesUtil.getContentType(reimbursementFile);
			InputStream inputStream = new FileInputStream(reimbursementFile);
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
			DLFolder resumeFolder = getReimbursementFolder(serviceContext, userId);

			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, resumeFolder.getRepositoryId(),
					resumeFolder.getFolderId(), reimbursementFile.getName(), contentType, fileTitle, fileTitle, "changeLog",
					inputStream, reimbursementFile.length(), serviceContext);
			if (Validator.isNotNull(fileEntry)) {
				fileUrl = donaminName + "documents/" + serviceContext.getScopeGroupId() + "/"
						+ resumeFolder.getFolderId() + "/"

						+ HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()));
				map.put(fileName, fileUrl);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	public Map<String, String> getReimbursementFileUpload(String name, File file, long userId, String donaminName)
			throws IOException, PortalException {
		Map<String, String> map = new HashMap<>();
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
			String fileTitle = "image_" + fileName;
			FileEntry fileEntry = null;
			// FileOutputStream fileOutputStream = new
			// FileOutputStream(resumeFile);
			// fileOutputStream.write(Base64.decode(strImage));
			// System.out.println("fileOutputStream : " + fileOutputStream);
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
			DLFolder resumeFolder = getReimbursementFolder(serviceContext, userId);

			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, resumeFolder.getRepositoryId(),
					resumeFolder.getFolderId(), file.getName(), contentType, fileTitle, fileTitle, "changeLog",
					inputStream, file.length(), serviceContext);
			if (Validator.isNotNull(fileEntry)) {
				fileUrl = donaminName + "/documents/" + serviceContext.getScopeGroupId() + "/"
						+ resumeFolder.getFolderId() + "/"
						+ HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()));
				map.put(fileName, fileUrl);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	
	private static DLFolder getReimbursementFolder(ServiceContext serviceContext, long userId) throws PortalException {
		System.out.println("serviceContext " + serviceContext + "userId" + userId);
		DLFolder reimbursementFolder = null;
		;
		try {
			System.out.println("##### before try ######");

			reimbursementFolder = DLFolderLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Reimbursement");
			if (reimbursementFolder == null) {
				reimbursementFolder = DLFolderLocalServiceUtil.addFolder(userId, serviceContext.getScopeGroupId(),
						serviceContext.getScopeGroupId(), Boolean.FALSE, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						"Reimbursement", StringPool.BLANK, Boolean.FALSE, serviceContext);
				System.out.println("##### Created resume folder successfully ######");
			}
			System.out.println("##### all ready exist ######" + reimbursementFolder);
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
		return reimbursementFolder;
	}
	
	
	public  List<String> updateExpenseEntry(long expenseId,long userId, long projectId, long catId, String title,
			String description, String expDate, Double amount,String name,String strImage, int status, String donaminName){

		List<String> successList = new ArrayList<>();
		String proofName="proof";
		Map<String, String> filemap = new HashMap<>();
		/*if (String.valueOf(userId) == null && String.valueOf(projectId) == null && String.valueOf(catId) == null
		&& title == null && description == null && expDate == null && amount == null) {

		errorList.add("Please Enter the correct Input !!");
		}*/
		/*if (errorList.size() != 0) */
		System.out.println("expenseId : "+expenseId);
		try{
			Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			Group defaultGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), "Guest");
		ExpenseEntry expenseEntry = ExpenseEntryLocalServiceUtil.getExpenseEntry(expenseId);
		System.out.println("expenseEntry: "+expenseEntry);
		expenseEntry.setProjectId(projectId);
		expenseEntry.setCatId(catId);
		// expEntry.setGroupId(groupId);
		Date date = new Date(); // Local Date fetch........
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		expenseEntry.setCreateDate(date);
		expenseEntry.setModifiedDate(date);
		expenseEntry.setTitle(title);
		expenseEntry.setDescription(description);
		Date expDate1=new SimpleDateFormat("dd/MM/yyyy").parse(expDate);
		expenseEntry.setExpDate(expDate1);
		expenseEntry.setAmount(Double.valueOf(amount));
		if (status == 2 || status == 6) {
			expenseEntry.setStatus(3);
		} else if (status == 0) {
			expenseEntry.setStatus(0);
		}
		System.out.println("expenseEntry "+expenseEntry);
		ExpenseEntry expenseEntryObj = ExpenseEntryLocalServiceUtil.updateExpenseEntry(expenseEntry);
		long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
		ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
				.createExpenseEntryHistory(expenseHistoryId);
		expenseEntryHistory.setCompanyId(company.getCompanyId());
		expenseEntryHistory.setExpenseId(expenseId);
		if (status == 2 || status == 6) {
			expenseEntryHistory.setStatus(3);
		} else if (status == 0) {
			expenseEntryHistory.setStatus(0);
		}
		expenseEntryHistory.setAddeddate(new Date());

		expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);
		if (strImage != null) {
			 filemap =getReimbursementFileUploadForService(name,strImage, userId, donaminName);
			
			String fn1="";
			String fu1="";
			for (Map.Entry<String,String> entry : filemap.entrySet()){
				System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
				 fn1=entry.getKey();
				fu1=entry.getValue();
			}
			ExpProofFiles expProofFiles1=ExpProofFilesLocalServiceUtil.findByExpenceId(Long.valueOf(expenseId));
			System.out.println("ExpProofFiles in impl " + expProofFiles1);
			ExpProofFiles expProofFiles=ExpProofFilesLocalServiceUtil.getExpProofFiles(expProofFiles1.getFileId());
			System.out.println("ExpProofFiles in impl " + expProofFiles);
			expProofFiles.setCompanyId(company.getCompanyId());
			expProofFiles.setEmployeeId(Long.valueOf(userId));
			expProofFiles.setFileName(fn1);
			//expProofFiles.setFileOrigName()
			expProofFiles.setFilePath(fu1);
			expProofFiles.setProofName(proofName);
			
			expProofFiles.setUploadDate(new Date());
			expProofFiles = ExpProofFilesLocalServiceUtil.updateExpProofFiles(expProofFiles);
			//expProofFiles.setEmployeeId(employeeId);
			
		}
		if(expenseEntryObj!=null){
		successList.add("successfully updated");
		}else{
		successList.add("not updated");
		}
		}catch (Exception e) {
		// TODO: handle exception
		}
		return successList;	}
	
	
	public List<String> removeExpenseEntry(long expenseId) {

		List<String> errorList = new ArrayList<>();
		if (String.valueOf(expenseId) == null) {
			errorList.add("Pleasae Select a Valid Option");
		}
		if (errorList.size() == 0) {
			try {
				ExpenseEntry expenseEntry = ExpenseEntryLocalServiceUtil.getExpenseEntry(expenseId);
				ExpenseEntryLocalServiceUtil.deleteExpenseEntry(expenseEntry);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return errorList;
	}

	}