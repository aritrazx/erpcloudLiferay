package com.liferay.famocom.erpcloud.myexpenses.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.ExpCategory;
import com.liferay.famocom.erpcloud.model.ExpProofFiles;
import com.liferay.famocom.erpcloud.model.ExpenseEntry;
import com.liferay.famocom.erpcloud.model.ExpenseEntryHistory;
import com.liferay.famocom.erpcloud.myexpenses.constants.MyExpensesPortletKeys;
import com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpProofFilesLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Suprakash
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MyExpenses Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyExpensesPortletKeys.MyExpenses,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyExpensesPortlet extends MVCPortlet {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	   List<String> errList=new ArrayList<>();
	   Map<String,String> map=new HashMap<>();
		public void myExpAdd(ActionRequest request, ActionResponse response) throws IOException, PortalException{

			ExpCategory expCategory =null;
			InputStream inputStream =null;
			List <String> errorList=new ArrayList<>();
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long projectId = ParamUtil.getLong(request, "projectName");
			long expenseCategoryId = ParamUtil.getLong(request, "expenseCategory");
			boolean required=false;
			expCategory=ExpCategoryLocalServiceUtil.getExpCategory(expenseCategoryId);
			if(expCategory.getAttachment()){
				required=true;
			}else{
				required=false;
			}
			String title = ParamUtil.get(request, "title", "");
			String description = ParamUtil.get(request, "description", "");
			String entryDate = ParamUtil.get(request, "entryDate", "");
			String empId = ParamUtil.get(request, "empId", "");
			Long tempempId=Long.valueOf(empId);
			Double amount = ParamUtil.getDouble(request, "amount");
			String proofName=ParamUtil.get(request, "proofName", "");
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			String fileName = uploadPortletRequest.getFileName("uploadedFile");
			//System.out.println("fileName  %%%" + tempfileName);
			File file = uploadPortletRequest.getFile("uploadedFile");
			
			String mimeType = uploadPortletRequest.getContentType("uploadedFile");
			long fileSize = uploadPortletRequest.getSize("uploadedFile");
			System.out.println("required @@@ " + required);
			if(required){
				if(fileSize==0){
					errorList.add("Document needs to be uploaded");
					System.out.println("errorList @@@ " + errorList);
				}else{
					inputStream = new FileInputStream(file);
				}
			}
			String fileUrl=StringPool.BLANK;
			FileEntry fileEntry = null;
			String donaminName=themeDisplay.getPortalURL();
			String fileTitle = fileName;
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setAddGuestPermissions(true);
	         
			Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			Group defaultGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), "Guest");
			System.out.println("defaultGroup.getGroupId() " + defaultGroup.getGroupId());
			serviceContext.setScopeGroupId(defaultGroup.getGroupId());
			//DLFolder documentFolder = getReimbursementFolder(serviceContext,tempempId);
			//System.out.println("documentFolder " + documentFolder);
			String contentType = MimeTypesUtil.getContentType(file);
			System.out.println("contentType " + contentType);
			
			System.out.println("inputStream...1 " + inputStream);
			// boolean attachmentRequired=ParamUtil.getBoolean(request,
			// "attachmentRequired");
			long userId=themeDisplay.getUserId();
		   
				try {
					 if(!errorList.isEmpty()){
						   HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
				           httpRequest.setAttribute("errorList", errorList);
				           SessionMessages.add(request, PortalUtil.getPortletId(request)+ SessionMessages. KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
						   response.setRenderParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
						   
					   }else{
					// ExpenseEntryLocalServiceUtil.addExpEntry(userId, projectId, expenseCategoryId, fileTitle, description, entryDate, amount);
							long expenseId = CounterLocalServiceUtil.increment(ExpenseEntry.class.getName());
			
							ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.createExpenseEntry(expenseId);
							expEntry.setProjectId(Long.valueOf(projectId));
							expEntry.setCatId(Long.valueOf(expenseCategoryId));
							expEntry.setTitle(title);
							expEntry.setEmployeeId(Long.valueOf(empId));
							expEntry.setUserId(themeDisplay.getUserId());
							expEntry.setDescription(description);
							Date entDate = (Date) formatter.parse(entryDate);
							expEntry.setExpDate(entDate);
							expEntry.setAmount(Double.valueOf(amount));
							expEntry.setStatus(0);
			
							/*if (file != null) {
								uploadDocument(request, response);
							}*/
							expEntry = ExpenseEntryLocalServiceUtil.addExpenseEntry(expEntry);
			
							long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
							ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
									.createExpenseEntryHistory(expenseHistoryId);
							expenseEntryHistory.setCompanyId(themeDisplay.getCompanyId());
							expenseEntryHistory.setExpenseId(expEntry.getExpenseId());
							expenseEntryHistory.setStatus(0);
							expenseEntryHistory.setAddeddate(new Date());
			
							expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);
							System.out.println("insertion of expense entry histry...");
							///expense proof files entry
							if (fileSize!=0) {
								Map<String, String> filemap =ExpenseEntryLocalServiceUtil.getReimbursementFileUpload(fileName,file, themeDisplay.getUserId(), donaminName);
								
								String fn1="";
								String fu1="";
								for (Map.Entry<String,String> entry : filemap.entrySet()){
									System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
									 fn1=entry.getKey();
									fu1=entry.getValue();
								}
								long fileId=CounterLocalServiceUtil.increment(ExpProofFiles.class.getName());
								ExpProofFiles expProofFiles=ExpProofFilesLocalServiceUtil.createExpProofFiles(fileId);
								expProofFiles.setCompanyId(themeDisplay.getCompanyId());
								expProofFiles.setEmployeeId(Long.valueOf(empId));
								expProofFiles.setFileName(fn1);
								//expProofFiles.setFileOrigName()
								expProofFiles.setFilePath(fu1);
								expProofFiles.setProofName(proofName);
								expProofFiles.setExpenseId(expenseId);
								expProofFiles.setUploadDate(new Date());
								expProofFiles = ExpProofFilesLocalServiceUtil.addExpProofFiles(expProofFiles);
								System.out.println("insertion of expense entry proof..");
							}	
					   }	
	
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		   		

		}
		
		public void myExpDelete(ActionRequest request, ActionResponse response) {
			String expenseId = ParamUtil.get(request, "expenseId", "");

			try {

				if (null != expenseId || !expenseId.isEmpty()) {
					ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.deleteExpenseEntry(Long.valueOf(expenseId));
					ExpProofFiles expProofFiles1=ExpProofFilesLocalServiceUtil.findByExpenceId(Long.valueOf(expenseId));
					ExpProofFiles expProofFiles=ExpProofFilesLocalServiceUtil.deleteExpProofFiles(expProofFiles1.getFileId());
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

		public void myExpEdit(ActionRequest request, ActionResponse response) {
			final String OLD_FORMAT = "yyyy-MM-dd"; // wants t convert date in this
													// format
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
			String expenseId = ParamUtil.get(request, "expenseId", "");
			int status = ParamUtil.getInteger(request, "status", 0);
			if (expenseId != null || !expenseId.isEmpty()) {
				System.out.println("expenseId{{{{{{" + expenseId);
				String projectId = ParamUtil.get(request, "projectName", StringPool.BLANK);
				String catId = ParamUtil.get(request, "expenseCategory", StringPool.BLANK);
				String title = ParamUtil.get(request, "title", StringPool.BLANK);
				String description = ParamUtil.get(request, "description", StringPool.BLANK);
				String amount = ParamUtil.get(request, "amount", StringPool.BLANK);
				String proofName=ParamUtil.get(request, "proofName", "");
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
				String fileName = uploadPortletRequest.getFileName("uploadedFile");	
				File file = uploadPortletRequest.getFile("uploadedFile");
				String contentType = MimeTypesUtil.getContentType(file);
				String empId = ParamUtil.get(request, "empId", StringPool.BLANK);
				String donaminName=themeDisplay.getPortalURL();

				String tempEntryDate = ParamUtil.get(request, "entryDate", "");
				System.out.println("date d?????" + tempEntryDate);

				try {

					ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.getExpenseEntry(Long.valueOf(expenseId));
					expEntry.setProjectId(Long.valueOf(projectId));
					expEntry.setCatId(Long.valueOf(catId));
					expEntry.setTitle(title);
					expEntry.setDescription(description);
					expEntry.setAmount(Double.valueOf(amount));
					if (status == 2 || status == 6) {
						expEntry.setStatus(3);
					} else if (status == 0) {
						expEntry.setStatus(0);
					}

					Date entDate = (Date) formatter.parse(tempEntryDate);
					expEntry.setExpDate(entDate);

					expEntry = ExpenseEntryLocalServiceUtil.updateExpenseEntry(expEntry);

					long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
					ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
							.createExpenseEntryHistory(expenseHistoryId);
					expenseEntryHistory.setCompanyId(themeDisplay.getCompanyId());
					expenseEntryHistory.setExpenseId(expEntry.getExpenseId());
					if (status == 2 || status == 6) {
						expenseEntryHistory.setStatus(3);
					} else if (status == 0) {
						expenseEntryHistory.setStatus(0);
					}
					expenseEntryHistory.setAddeddate(new Date());

					expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);
					if (file != null) {
						Map<String, String> filemap =ExpenseEntryLocalServiceUtil.getReimbursementFileUpload(fileName,file, themeDisplay.getUserId(), donaminName);
						
						String fn1="";
						String fu1="";
						for (Map.Entry<String,String> entry : filemap.entrySet()){
							System.out.println("inputStream...1111 " + entry.getKey()+"entry.getValue()"+entry.getValue());
							 fn1=entry.getKey();
							fu1=entry.getValue();
						}
						ExpProofFiles expProofFiles1=ExpProofFilesLocalServiceUtil.findByExpenceId(Long.valueOf(expenseId));
						ExpProofFiles expProofFiles=ExpProofFilesLocalServiceUtil.getExpProofFiles(expProofFiles1.getFileId());
						
						
						expProofFiles.setCompanyId(themeDisplay.getCompanyId());
						expProofFiles.setEmployeeId(Long.valueOf(empId));
						expProofFiles.setFileName(fn1);
						//expProofFiles.setFileOrigName()
						expProofFiles.setFilePath(fu1);
						expProofFiles.setProofName(proofName);
						
						expProofFiles.setUploadDate(new Date());
						expProofFiles = ExpProofFilesLocalServiceUtil.updateExpProofFiles(expProofFiles);
					}
					response.sendRedirect("jspPage", "/META-INF/resources/expenseEntry.jsp");

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		// Manager
		public void myExpUpdate(ActionRequest request, ActionResponse response) {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String expenseId = ParamUtil.get(request, "expenseId", "");
			if (expenseId != null || !expenseId.isEmpty()) {
				System.out.println("expenseId{{{{{{" + expenseId);
				String remark = ParamUtil.get(request, "remark", "");
				String approved = ParamUtil.get(request, "approved", "");

				try {

					ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.getExpenseEntry(Long.valueOf(expenseId));
					expEntry.setManCommnets(remark);
					expEntry.setStatus(Integer.valueOf(approved));

					expEntry = ExpenseEntryLocalServiceUtil.updateExpenseEntry(expEntry);

					long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
					ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
							.createExpenseEntryHistory(expenseHistoryId);
					expenseEntryHistory.setCompanyId(themeDisplay.getCompanyId());
					expenseEntryHistory.setExpenseId(expEntry.getExpenseId());
					expenseEntryHistory.setStatus(Integer.valueOf(approved));
					expenseEntryHistory.setAddeddate(new Date());

					expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);
					response.sendRedirect("jspPage", "/META-INF/resources/viewForApproval.jsp");

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}

		// accountant
		public void myExpAccUpdate(ActionRequest request, ActionResponse response) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			String expenseId = ParamUtil.get(request, "expenseId", "");
			if (expenseId != null || !expenseId.isEmpty()) {
				System.out.println("expenseId{{{{{{" + expenseId);
				String remark = ParamUtil.get(request, "remark", "");
				String approved = ParamUtil.get(request, "approved", "");

				try {

					ExpenseEntry expEntry = ExpenseEntryLocalServiceUtil.getExpenseEntry(Long.valueOf(expenseId));
					expEntry.setManCommnets(remark);
					expEntry.setStatus(Integer.valueOf(approved));

					expEntry = ExpenseEntryLocalServiceUtil.updateExpenseEntry(expEntry);

					long expenseHistoryId = CounterLocalServiceUtil.increment(ExpenseEntryHistory.class.getName());
					ExpenseEntryHistory expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil
							.createExpenseEntryHistory(expenseHistoryId);
					expenseEntryHistory.setCompanyId(themeDisplay.getCompanyId());
					expenseEntryHistory.setExpenseId(expEntry.getExpenseId());
					expenseEntryHistory.setStatus(Integer.valueOf(approved));
					expenseEntryHistory.setAddeddate(new Date());

					expenseEntryHistory = ExpenseEntryHistoryLocalServiceUtil.addExpenseEntryHistory(expenseEntryHistory);

					response.sendRedirect("jspPage", "/META-INF/resources/viewForApproval.jsp");

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}

		@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String jspPage = ParamUtil.getString(renderRequest, "jspPage", StringPool.BLANK);
			System.out.println("=================== jspPage =================" + jspPage);
			List<ExpenseEntryHistory> expenseHistoryList1 = new ArrayList<ExpenseEntryHistory>() ;
			List<ExpenseEntryHistory> expenseHistoryList = null;
			long userId = themeDisplay.getUserId();
			long expenseId = 0;
			if (Validator.isNotNull(jspPage)) {
				if (("/META-INF/resources/expenseEntry.jsp".trim().equalsIgnoreCase(jspPage))) {
					List<ExpenseEntry> expenseEntryList = ExpenseEntryLocalServiceUtil.findByUserId(userId);
					if (Validator.isNotNull(expenseEntryList) && !expenseEntryList.isEmpty()) {
						for (ExpenseEntry expenseEntry : expenseEntryList) {
							if (expenseEntry.getExpenseId() > 0) {
								expenseHistoryList = ExpenseEntryHistoryLocalServiceUtil
										.findByExpenceId(expenseEntry.getExpenseId());
								
							}
							expenseHistoryList1.addAll(expenseHistoryList);
							
						}
						
						if (Validator.isNotNull(expenseHistoryList1) && !expenseHistoryList1.isEmpty()) {
							renderRequest.setAttribute("expenseHistoryList", expenseHistoryList1);
						}
						
					}
					
				}	
					else if (("/META-INF/resources/viewForApproval.jsp".trim().equalsIgnoreCase(jspPage)) || ("/META-INF/resources/viewForAccApproval.jsp".trim().equalsIgnoreCase(jspPage))){
						List<ExpenseEntryHistory> expenseEntryListAll = ExpenseEntryHistoryLocalServiceUtil.getExpenseEntryHistories(-1, -1);
						if (Validator.isNotNull(expenseEntryListAll) && !expenseEntryListAll.isEmpty()) {
						renderRequest.setAttribute("expenseHistoryList", expenseEntryListAll);
						}
					}

					
					
				

			} else {
				if (userId > 0) {
					// ExpenseEntryLocalServiceUtil.
				}
			}

			super.render(renderRequest, renderResponse);
		}
}