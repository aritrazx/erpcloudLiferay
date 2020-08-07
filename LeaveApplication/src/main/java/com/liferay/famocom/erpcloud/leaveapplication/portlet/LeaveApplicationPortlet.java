package com.liferay.famocom.erpcloud.leaveapplication.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.famocom.erpcloud.exception.NoSuchHolidayCalenderManagementException;
import com.liferay.famocom.erpcloud.leaveapplication.constants.LeaveApplicationPortletKeys;
import com.liferay.famocom.erpcloud.leaveapplication.helper.LeaveApplicationHelper;
import com.liferay.famocom.erpcloud.leaveapplication.model.LeaveTypeDetails;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.HolidayCalenderManagement;
import com.liferay.famocom.erpcloud.model.LeaveApply;
import com.liferay.famocom.erpcloud.model.LeaveApplyDtl;
import com.liferay.famocom.erpcloud.model.LeaveDoc;
import com.liferay.famocom.erpcloud.model.LeaveOb;
import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveObLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

/**
 * @author SAMARESHFAMOCOM
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=LeaveApplication Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LeaveApplicationPortletKeys.LeaveApplication,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class LeaveApplicationPortlet extends MVCPortlet {

	public static String FOLDER_NAME = "Leave_File_upload";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Employee employee = EmployeeLocalServiceUtil.findByemployees(td.getUserId());
		Long leaveTypeId = ParamUtil.getLong(renderRequest, "leaveTypeId");
		Long leaveApplicationId = ParamUtil.getLong(renderRequest, "leaveApplyId");

		if (leaveTypeId != null && leaveTypeId > 0) {
			LeaveTypeDetails leaveType = LeaveApplicationHelper.getInstance().getLeaveTypeDetails(employee,
					LeaveTypeLocalServiceUtil.fetchLeaveType(leaveTypeId));
			renderRequest.setAttribute("leaveType", leaveType);
			// For Edit of the application
			if (leaveApplicationId != null && leaveApplicationId > 0) {
				try {
					LeaveApply leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplicationId);
					if (leaveApply != null) {
						renderRequest.setAttribute("leaveApplication", leaveApply);
						renderRequest.setAttribute("isEdit", "true");
					}
				} catch (Exception e) {
				}
			}

		} else {// View Summary only
			DynamicQuery dynamicQuery = LeaveTypeLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("leaveStatus").eq(new Boolean(true)));
			List<LeaveType> leaveList = LeaveTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
			List<LeaveTypeDetails> leaveTypeDetails = new ArrayList<LeaveTypeDetails>();
			for (LeaveType lt : leaveList) {
				LeaveTypeDetails ltd = LeaveApplicationHelper.getInstance().getLeaveTypeDetails(employee, lt);
				if (ltd != null) {
					leaveTypeDetails.add(ltd);
				}
			}
			renderRequest.setAttribute("leaveTypes", leaveTypeDetails);
		}
		super.render(renderRequest, renderResponse);
	}

	/**
	 * Add leaves - from form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws WindowStateException
	 * @throws ParseException
	 */
	@ProcessAction(name = "newLeaveApplication")
	public void newLeaveApplication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws WindowStateException, ParseException {
		System.out.println("calll newLeaveApplication");
		List<String> errorList = new ArrayList<>();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		String fromDate = ParamUtil.getString(actionRequest, "fromDate", StringPool.BLANK);
		String fromDateSession = ParamUtil.getString(actionRequest, "fromDateSession", StringPool.BLANK);
		String toDate = ParamUtil.getString(actionRequest, "toDate", StringPool.BLANK);
		String toDateSession = ParamUtil.getString(actionRequest, "toDateSession", StringPool.BLANK);
		String reason = ParamUtil.getString(actionRequest, "reason", StringPool.BLANK);
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		Date toDate1 = new Date();
		Date fromDate1 = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // To date input
															// from jsp
		try {
			fromDate1 = (Date) df.parse(fromDate);
			toDate1 = (Date) df.parse(toDate);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		double totalDays = 0;
		List<Date> leaveDays = new ArrayList<Date>(); // Total days list
		leaveDays = getLeaveDays(fromDate1, toDate1);
		System.out.println("leaveDays" + leaveDays);

		// Start Date should be less than end date or Equals
		// Check...............
		if (toDate1.equals(fromDate1) || toDate1.after(fromDate1)) {
			// Leave Checking
			// Sat or Sun or Holi Day Can't be accept
			if (leaveDays.size() > 0) {
				double leaveTakenCount = findLeaveTakenCount(employee.getEmployeeId(), leaveTypeId, actionRequest);
				System.out.println("Before Date");
				try {
					LeaveType leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
					LeaveOb leaveOb = LeaveObLocalServiceUtil.openingBalance(employee.getEmployeeId(), leaveTypeId);
					double maxCreditDay = 0.0;
					if (leaveOb != null) {
						maxCreditDay = leaveType.getMaxCreditDay() + Double.valueOf(leaveOb.getObVal());
						System.out.println("if part maxCreditDay " + maxCreditDay);
					} else {
						maxCreditDay = Double.valueOf(leaveType.getMaxCreditDay());
						System.out.println("else part maxCreditDay " + maxCreditDay);
					}
					if ((leaveTakenCount + leaveDays.size()) <= maxCreditDay) {
						boolean hasLeaveOverLapped = LeaveApplyDtlLocalServiceUtil.hasOverlappedLeaves(fromDate1,
								toDate1, employee.getEmployeeId());
						if (hasLeaveOverLapped) {
							errorList.add("You have Already Applied leave on this day !");
							SessionErrors.add(actionRequest, "duplicateDay");
							SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
							actionResponse.setWindowState(WindowState.NORMAL);
							actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
						}

						long noticeDay = noticeDayCheck(fromDate);

						if (Long.valueOf(leaveType.getNoticeDay()) > noticeDay) {
							errorList.add("you must apply " + leaveType.getNoticeDay() + "days before leave date");
							SessionErrors.add(actionRequest, "noticeDaysError");
							SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
							actionResponse.setWindowState(WindowState.NORMAL);
							actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
						}

						if (errorList.isEmpty()) {
							// SET ALL VALUE OF LEAVE_APPLY..............
							try {
								long leaveApplyId = CounterLocalServiceUtil.increment(LeaveApply.class.getName());
								LeaveApply leaveobj = LeaveApplyLocalServiceUtil.createLeaveApply(leaveApplyId);

								leaveobj.setCompanyId(employee.getCompanyId());
								leaveobj.setEmployeeId(employee.getEmployeeId());
								leaveobj.setLeaveTypeId(leaveTypeId);
								leaveobj.setFromDate(fromDate1);
								leaveobj.setFromDateSession(fromDateSession);
								leaveobj.setToDate(toDate1);
								leaveobj.setToDateSession(toDateSession);
								leaveobj.setReason(reason);
								leaveobj.setIsApprove(Integer.valueOf(0));
								Date date = new Date();
								leaveobj.setAddedDate(new Date());

								// Random rand = new Random();
								// int randamNum = rand.nextInt();
								UploadPortletRequest uploadPortletRequest = PortalUtil
										.getUploadPortletRequest(actionRequest);
								Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
								Folder folder = null;
								InputStream is;
								// File file;
								String title, description, mimeType;
								long repositoryId;
								FileEntry dlfile;
								File file = uploadPortletRequest.getFile("uploadedFiles");
								String firstName = employee.getFirstName();
								String lastName = employee.getLastName();
								for (Entry<String, FileItem[]> file2 : files.entrySet()) {
									FileItem item[] = file2.getValue();
									try {
										for (FileItem fileItem : item) {
											Date date2 = new Date();
											Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60)
													+ date2.getSeconds()) * 1000);
											long fileSize = 0;
											title = firstName + lastName + time2 + "_" + fileItem.getFileName();
											description = title + " is added via programatically";
											repositoryId = themeDisplay.getScopeGroupId();
											mimeType = fileItem.getContentType();
											file = fileItem.getStoreLocation();
											is = fileItem.getInputStream();
											fileSize = fileItem.getSize();
											if (fileSize > 0) {
												System.out.println(":::::::::::: call dlfile ::::::::::::::::::::");
												try {
													folder = getFolder(actionRequest, themeDisplay);
													ServiceContext serviceContext = ServiceContextFactory
															.getInstance(DLFileEntry.class.getName(), actionRequest);
													dlfile = DLAppServiceUtil.addFileEntry(repositoryId,
															folder.getFolderId(), title, mimeType, title, description,
															"", is, fileSize, serviceContext);
													long leaveDocId = CounterLocalServiceUtil
															.increment(LeaveDoc.class.getName());
													LeaveDoc leaveDoc = LeaveDocLocalServiceUtil
															.createLeaveDoc(leaveDocId);
													leaveDoc.setEmployeeId(employee.getEmployeeId());
													leaveDoc.setCompanyId(employee.getCompanyId());
													leaveDoc.setLeaveApplyId(leaveApplyId);
													if (dlfile != null) {
														leaveDoc.setFileEntryId(dlfile.getFileEntryId());
													}
													leaveDoc.setAddedDate(date);
													LeaveDocLocalServiceUtil.addLeaveDoc(leaveDoc);
													System.out.println("Files are inserted .....");
												} catch (PortalException e) {
													e.printStackTrace();
												} catch (SystemException e) {
													e.printStackTrace();
												}
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								LeaveApplyLocalServiceUtil.addLeaveApply(leaveobj);
								for (Date leaveDate : leaveDays) {
									// SET ALL VALUE OF
									// LEAVE_APPLY_DETAILS.............
									try {
										long leaveApplyDtlId = CounterLocalServiceUtil
												.increment(LeaveApplyDtl.class.getName());
										LeaveApplyDtl leaveAppobj = LeaveApplyDtlLocalServiceUtil
												.createLeaveApplyDtl(leaveApplyDtlId);
										leaveAppobj.setLeaveApplyId(leaveApplyId);
										leaveAppobj.setCompanyId(employee.getCompanyId());
										leaveAppobj.setEmployeeId(employee.getEmployeeId());
										leaveAppobj.setLeaveTypeId(leaveTypeId);
										leaveAppobj.setLeaveDate(leaveDate);

										String[] sessionDayValues = getSessionAndDayCount(fromDate1, toDate1,
												fromDateSession, toDateSession, leaveDate);
										totalDays += Double.valueOf(sessionDayValues[1]);
										leaveAppobj.setLeaveDays(Double.valueOf(sessionDayValues[1]));
										leaveAppobj.setSessionData(sessionDayValues[0]);
										leaveAppobj.setIsApprove(Integer.valueOf(0));
										LeaveApplyDtlLocalServiceUtil.addLeaveApplyDtl(leaveAppobj);
										try {
											LeaveApply leavedayobj = LeaveApplyLocalServiceUtil
													.getLeaveApply(leaveobj.getLeaveApplyId());
											leavedayobj.setLeaveDays(totalDays);
											LeaveApplyLocalServiceUtil.updateLeaveApply(leavedayobj);
											// Workflow Integration===========================================================================
											/*User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());

											long groupId = themeDisplay.getScopeGroupId();
											ServiceContext serviceContext1 = ServiceContextFactory.getInstance(
													LeaveApplicationPortlet.class.getName(), actionRequest);
											serviceContext1.setAddGroupPermissions(true);
											serviceContext1.setAddGuestPermissions(true);
											serviceContext1.setCompanyId(leaveobj.getCompanyId());
											serviceContext1.setScopeGroupId(groupId);
											serviceContext1.setUserId(user.getUserId());

											String postName = firstName;

											updateAssetEntry(user, groupId, leaveobj, postName);

											Indexer<LeaveApply> indexer = IndexerRegistryUtil
													.nullSafeGetIndexer(LeaveApply.class);
											indexer.reindex(leaveobj);
											WorkflowHandlerRegistryUtil.startWorkflowInstance(leaveobj.getCompanyId(),
													leaveobj.getGroupId(), themeDisplay.getUserId(),
													LeaveApply.class.getName(), leaveobj.getPrimaryKey(), leaveobj,
													serviceContext1);*/

											// ===============================================================================================
											// Load Summary View 

											HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
											
											DynamicQuery dynamicQuery = LeaveTypeLocalServiceUtil.dynamicQuery();
											dynamicQuery.add(PropertyFactoryUtil.forName("leaveStatus").eq(new Boolean(true)));
											List<LeaveType> leaveList = LeaveTypeLocalServiceUtil.dynamicQuery(dynamicQuery);
											List<LeaveTypeDetails> leaveTypeDetails = new ArrayList<LeaveTypeDetails>();
											for (LeaveType lt : leaveList) {
												LeaveTypeDetails ltd = LeaveApplicationHelper.getInstance().getLeaveTypeDetails(employee, lt);
												if (ltd != null) {
													leaveTypeDetails.add(ltd);
												}
											}
											httpRequest.setAttribute("leaveTypes",leaveTypeDetails);
											actionResponse.setRenderParameter("jspPage", "/view.jsp");
											
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println(":::::::::::::WorkFlow Worked:::::::");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}						
						
					} else {
						System.out.println("Your Request doesn't accept Because you were requesting more than !");
						SessionErrors.add(actionRequest, "error2");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						actionResponse.setWindowState(WindowState.NORMAL);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
					}
				} catch (PortalException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("It may Be Sat or sun Day or Holi Day ");
				SessionErrors.add(actionRequest, "error1");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
			}
		} else {
			System.out.println("Start Date should be less than End Date!");
			SessionErrors.add(actionRequest, "error");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
		}
	}

	/**
	 * Role Set for workflow
	 * 
	 * @param companyId
	 * @param userId
	 * @throws PortalException
	 */
	public static void setRole(long companyId, long userId) throws PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		Role liferayRole = RoleLocalServiceUtil.fetchRole(companyId, "Employee");
		RoleLocalServiceUtil.addUserRole(user.getUserId(), liferayRole.getRoleId());
		// UserLocalServiceUtil.updateUser(user);
	}

	/**
	 * For WorkFlow
	 * 
	 * @param user
	 * @param groupId
	 * @param employee
	 * @param postName
	 */
	public void updateAssetEntry(User user, long groupId, LeaveApply leaveApply, String postName) {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil
				.createAssetEntry(CounterLocalServiceUtil.increment(AssetEntry.class.getName()));
		assetEntry.setUserId(user.getUserId());
		assetEntry.setGroupId(groupId);
		assetEntry.setCreateDate(new Date());
		assetEntry.setModifiedDate(new Date());
		assetEntry.setClassName(LeaveApply.class.getName());
		assetEntry.setClassPK(leaveApply.getLeaveApplyId());
		assetEntry.setClassUuid(null);
		assetEntry.setClassTypeId(0L);
		assetEntry.setListable(Boolean.TRUE);
		assetEntry.setVisible(Boolean.TRUE);
		assetEntry.setStartDate(null);
		assetEntry.setEndDate(null);
		assetEntry.setExpirationDate(null);
		assetEntry.setMimeType(ContentTypes.TEXT_HTML);
		assetEntry.setTitle(postName);
		assetEntry.setDescription(StringPool.BLANK);
		assetEntry.setUrl(null);
		assetEntry.setLayoutUuid(null);
		try {
			AssetEntryLocalServiceUtil.updateAssetEntry(assetEntry);
		} catch (Exception e) {
			System.out.println("Error While updating AssetEntry.............................");

		}

	}

	/**
	 * Create the folder
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return Folder
	 */
	public Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId,
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, FOLDER_NAME,
					"This folder is create for Leave documents upload", serviceContext);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		return folder;
	}

	/**
	 * Get the folder, create & return if not exists
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return Folder
	 */
	public Folder getFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, FOLDER_NAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Create folder if not exists
		if (folder == null) {
			folder = createFolder(actionRequest, themeDisplay);
		}
		return folder;
	}

	/**
	 * Get the leave days excluding the weekly off & holidays
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return List<Date>
	 * @throws ParseException
	 */
	public List<Date> getLeaveDays(Date fromDate, Date toDate) throws ParseException {
		// System.out.println("fromDate......>>>>>>>>>>>>>>>>>>>" + fromDate);
		List<Date> dateList = new ArrayList<Date>();
		List<HolidayCalenderManagement> holidayList = new ArrayList<HolidayCalenderManagement>();
		try {
			holidayList = HolidayCalenderManagementLocalServiceUtil.getHolidays(fromDate, toDate);
		} catch (NoSuchHolidayCalenderManagementException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		while (fromDate.before(toDate) || fromDate.equals(toDate)) {
			// System.out.println("fromDate:" + fromDate);
			Calendar c = Calendar.getInstance();
			c.setTime(fromDate);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			// TODO - checking weekly off days - should be dynamic
			if (!(dayOfWeek == 1 || dayOfWeek == 7)) {

				boolean isHoliday = false;
				for (HolidayCalenderManagement hoCalenderManagement : holidayList) {
					if (fromDate.equals(hoCalenderManagement.getHolidayDate())) {
						isHoliday = true;
						break;
					}
				}
				System.out.println("isHoliday:" + isHoliday);
				if (!isHoliday) {
					dateList.add(fromDate);
				}
			}
			c.add(Calendar.DATE, 1); // number of days to add
			Date newdate = c.getTime();
			fromDate = newdate;
		}
		// System.out.println("::::::::::::::::::::::::dateList
		// ::::::::::::::::::" +dateList);
		return dateList;
	}

	/**
	 * Check Noitce Day Calculate
	 * 
	 * @param fromDate
	 * @return
	 * @throws ParseException
	 */
	public long noticeDayCheck(String fromDate) throws ParseException {
		// System.out.println(":::::::::::::::::::::::::::::::::::Calllllll::::::::::::::::::::::::::::::::::::::::::");
		Date localDate = new Date();
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
		//Calendar startCalendar = new GregorianCalendar();
		Calendar endCalendar = new GregorianCalendar();
		// long diffYear = 0;
		// long diffMonth = 0;
		long differance = 0;
		long diffDay = 0;
		endCalendar.setTime(localDate);
		// diffYear = endCalendar.get(Calendar.YEAR) -
		// startCalendar.get(Calendar.YEAR);
		// diffMonth = (diffYear * 12 + endCalendar.get(Calendar.MONTH) -
		// startCalendar.get(Calendar.MONTH)) + 1;
		differance = (date1.getTime() - localDate.getTime());
		diffDay = differance / (24 * 60 * 60 * 1000);
		if (diffDay > 0) {
			return diffDay;
		} else {
			return 0;
		}

	}

	/**
	 * Leave Date Session calculate
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param fromDateSession
	 * @param toDateSession
	 * @param leaveDate
	 * @return
	 * @throws ParseException
	 */
	public String[] getSessionAndDayCount(Date fromDate, Date toDate, String fromDateSession, String toDateSession,
			Date leaveDate) throws ParseException {
		// System.out.println("Date List ::" + leaveDate);
		System.out.println("fromDateSession::" + fromDateSession);
		System.out.println("toDateSession::" + toDateSession);

		String session = "0";
		double dayCount = 1;
		if (leaveDate.equals(fromDate)) {

			session = fromDateSession;
			dayCount = getDayCountFromSession(fromDateSession);

		} else if (leaveDate.equals(toDate)) {
			session = toDateSession;
			dayCount = getDayCountFromSession(toDateSession);

		}
		String[] values = { session, String.valueOf(dayCount) };
		return values;
	}

	private double getDayCountFromSession(String session) {
		double dayCount = 1;

		if (!session.equalsIgnoreCase("0")) {
			dayCount = 0.5;
		}

		return dayCount;
	}

	/**
	 * Get the count of leave taken for a particular leave type for an employee
	 * 
	 * @param employeeId
	 * @param leaveId
	 * @param actionRequest
	 * @return
	 */
	public double findLeaveTakenCount(long employeeId, long leaveTypeId, ActionRequest actionRequest) {
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		DynamicQuery dynamicQuery = LeaveApplyLocalServiceUtil.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("employeeId", employee.getEmployeeId()))
				.add(RestrictionsFactoryUtil.eq("leaveTypeId", leaveTypeId))
				.add(RestrictionsFactoryUtil.eq("isApprove", 1))
				.setProjection(ProjectionFactoryUtil.sum("leaveDays"));
		List<LeaveApply> list = LeaveApplyLocalServiceUtil.dynamicQuery(dynamicQuery);
		return GetterUtil.getDouble(list.get(0));
	}

	/**
	 * Edit leaves - from form submit
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws WindowStateException
	 * @throws ParseException
	 */
	@ProcessAction(name = "editLeaveApplication")
	public void editLeaveApplication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws ParseException, WindowStateException {
		System.out.println("::Call Edit::");
		List<String> errorList = new ArrayList<>();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		long leaveApplyId = ParamUtil.getLong(actionRequest, "leaveApplyId");
		String fromDate = ParamUtil.getString(actionRequest, "fromDate", StringPool.BLANK);
		// System.out.println("FromDate" + fromDate);
		String fromDateSession = ParamUtil.getString(actionRequest, "fromDateSession", StringPool.BLANK);
		String toDate = ParamUtil.getString(actionRequest, "toDate", StringPool.BLANK);
		// System.out.println("toDate" + toDate);
		String toDateSession = ParamUtil.getString(actionRequest, "toDateSession", StringPool.BLANK);
		String reason = ParamUtil.getString(actionRequest, "reason", StringPool.BLANK);
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		Employee employee = EmployeeLocalServiceUtil.findByemployees(userId);
		Date toDate1 = new Date();
		Date fromDate1 = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // To date input
															// from jsp
		try {
			fromDate1 = (Date) df.parse(fromDate);
			toDate1 = (Date) df.parse(toDate);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		double totalDays = 0;
		List<Date> leaveDays = new ArrayList<Date>(); // Total days list
		leaveDays = getLeaveDays(fromDate1, toDate1);
		System.out.println("leaveDays" + leaveDays);
		// Leave Checking
		// Sat or Sun or Holi Day Can't be accept
		if (leaveDays.size() > 0) {
			// Start Date should be less than end date or Equals
			// Check...............
			if (toDate1.equals(fromDate1) || toDate1.after(fromDate1)) {
				// List<Date> leaveDays = new ArrayList<Date>(); // Total days
				// list
				// leaveDays = getLeaveDays(fromDate1, toDate1);
				double leaveTakenCount = findLeaveTakenCount(employee.getEmployeeId(), leaveTypeId, actionRequest);

				LeaveType leaveType = null;
				try {
					leaveType = LeaveTypeLocalServiceUtil.getLeaveType(leaveTypeId);
					LeaveOb leaveOb = LeaveObLocalServiceUtil.openingBalance(employee.getEmployeeId(), leaveTypeId);
					double maxCreditDay = 0.0;
					if (leaveOb != null) {
						maxCreditDay = leaveType.getMaxCreditDay() + Double.valueOf(leaveOb.getObVal());
						System.out.println("if part maxCreditDay " + maxCreditDay);
					} else {
						maxCreditDay = Double.valueOf(leaveType.getMaxCreditDay());
						System.out.println("else part maxCreditDay " + maxCreditDay);
					}
					// maxCreditDay = leaveType.getMaxCreditDay();
					try {
						DynamicQuery dynamicQuery = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
						dynamicQuery.add(PropertyFactoryUtil.forName("leaveApplyId").eq(new Long(leaveApplyId)));
						List<LeaveApplyDtl> leaveList = LeaveApplyDtlLocalServiceUtil.dynamicQuery(dynamicQuery);
						if (leaveList.size() != 0) {
							for (LeaveApplyDtl applyDtlObj : leaveList) {
								System.out.println("Value : : : : : : : : : : : : : :  : : : : " + leaveList.size());
								LeaveApplyDtl applyDtl = LeaveApplyDtlLocalServiceUtil
										.getLeaveApplyDtl(applyDtlObj.getLeaveApplyDtlId());
								LeaveApplyDtlLocalServiceUtil.deleteLeaveApplyDtl(applyDtl);
								// System.out.println(" Value Deleted ");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					if ((leaveTakenCount + leaveDays.size()) <= maxCreditDay) {

						boolean hasLeaveOverLapped = LeaveApplyDtlLocalServiceUtil.hasOverlappedLeaves(fromDate1,
								toDate1, employee.getEmployeeId());
						if (hasLeaveOverLapped) {
							errorList.add("You have Already Applied leave on this day !");
							System.out.println("You have Already Applied leave on this day !");
							SessionErrors.add(actionRequest, "duplicateDay");
							SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
							actionResponse.setWindowState(WindowState.NORMAL);
							actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
						}

						long noticeDay = noticeDayCheck(fromDate);
						// System.out.println(":::noticeDayCheck::::" +
						// noticeDay);
						// System.out.println("leaveType.getNoticeDay():::::" +
						// leaveType.getNoticeDay());
						if (Long.valueOf(leaveType.getNoticeDay()) > noticeDay) {
							errorList.add("you must apply " + leaveType.getNoticeDay() + "days before leave date");
							// System.out.println("you must apply " +
							// leaveType.getNoticeDay() + "days before leave
							// date");
							SessionErrors.add(actionRequest, "noticeDaysError");
							SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
							actionResponse.setWindowState(WindowState.NORMAL);
							actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
						}
						if (errorList.isEmpty()) {
							// SET ALL VALUE OF LEAVE_APPLY..............
							try {
								LeaveApply leaveobj = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplyId);

								leaveobj.setCompanyId(employee.getCompanyId());
								leaveobj.setEmployeeId(employee.getEmployeeId());
								leaveobj.setLeaveTypeId(leaveTypeId);
								leaveobj.setFromDate(fromDate1);
								leaveobj.setFromDateSession(fromDateSession);
								leaveobj.setToDate(toDate1);
								leaveobj.setToDateSession(toDateSession);
								leaveobj.setReason(reason);
								leaveobj.setIsApprove(Integer.valueOf(0));
								leaveobj.setAddedDate(new Date());
								leaveobj.setStatus(0);

								/*if (Validator.isNotNull(leaveApplyId)) {
									DynamicQuery dynamicQuery = LeaveDocLocalServiceUtil.dynamicQuery();
									dynamicQuery.add(
											PropertyFactoryUtil.forName("leaveApplyId").eq(new Long(leaveApplyId)));
									List<LeaveDoc> docList = LeaveDocLocalServiceUtil.dynamicQuery(dynamicQuery);
									if (docList.size() > 0 && !docList.isEmpty()) {
										for (LeaveDoc doc : docList) {
											DLAppLocalServiceUtil.deleteFileEntry(doc.getFileEntryId());
											System.out.println(":::::Delete file from actioin method :::::");
										}
									}
								}*/
								UploadPortletRequest uploadPortletRequest = PortalUtil
										.getUploadPortletRequest(actionRequest);
								Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();
								Folder folder = null;
								InputStream is;
								// File file;
								String title, description, mimeType;
								long repositoryId;
								FileEntry dlfile;
								File file = uploadPortletRequest.getFile("uploadedFiles");
								String firstName = employee.getFirstName();
								String lastName = employee.getLastName();
								long fileSize = 0;
								for (Entry<String, FileItem[]> file2 : files.entrySet()) {
									FileItem item[] = file2.getValue();
									try {
										for (FileItem fileItem : item) {
											Date date2 = new Date();
											Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60)
													+ date2.getSeconds()) * 1000);
											title = firstName + lastName + time2 + "_" + fileItem.getFileName();
											description = title + " is added via programatically";
											repositoryId = themeDisplay.getScopeGroupId();
											mimeType = fileItem.getContentType();
											file = fileItem.getStoreLocation();
											is = fileItem.getInputStream();
											fileSize = fileItem.getSize();
											if (fileSize > 0) {
												System.out.println(":::::::::::: call dlfile ::::::::::::::::::::");
												try {
													folder = getFolder(actionRequest, themeDisplay);
													ServiceContext serviceContext = ServiceContextFactory
															.getInstance(DLFileEntry.class.getName(), actionRequest);
													dlfile = DLAppServiceUtil.addFileEntry(repositoryId,
															folder.getFolderId(), title, mimeType, title, description,
															"", is, fileSize, serviceContext);
													System.out.println("File ID ::::::::::" + dlfile.getFileEntryId());
													long leaveDocId = CounterLocalServiceUtil
															.increment(LeaveDoc.class.getName());
													LeaveDoc leaveDoc = LeaveDocLocalServiceUtil
															.createLeaveDoc(leaveDocId);
													// System.out.println("LeaveDocId"
													// +
													// leaveDocId);
													leaveDoc.setEmployeeId(employee.getEmployeeId());
													leaveDoc.setCompanyId(employee.getCompanyId());
													leaveDoc.setLeaveApplyId(leaveApplyId);
													if (dlfile != null) {
														leaveDoc.setFileEntryId(dlfile.getFileEntryId());
													}
													leaveDoc.setAddedDate(new Date());
													LeaveDocLocalServiceUtil.addLeaveDoc(leaveDoc);
												System.out.println("new Files are inserted .....");
												} catch (PortalException e) {
													e.printStackTrace();
												} catch (SystemException e) {
													e.printStackTrace();
												}
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								LeaveApplyLocalServiceUtil.updateLeaveApply(leaveobj);

								// Leave details add day by day
								// double totalDays = 0;
								// String detSeesionData = "1";
								for (Date leaveDate : leaveDays) {
									// SET ALL VALUE OF
									// LEAVE_APPLY_DETAILS.............
									try {
										long leaveApplyDtlId = CounterLocalServiceUtil
												.increment(LeaveApplyDtl.class.getName());
										LeaveApplyDtl leaveAppobj = LeaveApplyDtlLocalServiceUtil
												.createLeaveApplyDtl(leaveApplyDtlId);
										leaveAppobj.setLeaveApplyId(leaveApplyId);
										leaveAppobj.setCompanyId(employee.getCompanyId());
										leaveAppobj.setEmployeeId(employee.getEmployeeId());
										leaveAppobj.setLeaveTypeId(leaveTypeId);
										leaveAppobj.setLeaveDate(leaveDate);

										String[] sessionDayValues = getSessionAndDayCount(fromDate1, toDate1,
												fromDateSession, toDateSession, leaveDate);
										totalDays += Double.valueOf(sessionDayValues[1]);
										leaveAppobj.setLeaveDays(Double.valueOf(sessionDayValues[1]));
										leaveAppobj.setSessionData(sessionDayValues[0]);
										leaveAppobj.setIsApprove(Integer.valueOf(0));
										LeaveApplyDtlLocalServiceUtil.addLeaveApplyDtl(leaveAppobj);
										try {
											LeaveApply leavedayobj = LeaveApplyLocalServiceUtil
													.getLeaveApply(leaveobj.getLeaveApplyId());
											leavedayobj.setLeaveDays(totalDays);
											LeaveApplyLocalServiceUtil.updateLeaveApply(leavedayobj);
										} catch (Exception e) {
											e.printStackTrace();
										}
										// System.out.println("Value
										// inserted...");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} /*
							 * else { System.out.println("Before date else");
							 * SessionErrors.add(actionRequest, "error1");
							 * SessionMessages.add(actionRequest,
							 * PortalUtil.getPortletId(actionRequest) +
							 * SessionMessages.
							 * KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE );
							 * actionResponse.setWindowState(WindowState.NORMAL)
							 * ; actionResponse.setRenderParameter("jspPage",
							 * "/META-INF/resources/LeaveApply.jsp"); }
							 */
					} else {
						System.out.println("Your Request doesn't accept Because you were requesting more than !");
						SessionErrors.add(actionRequest, "error2");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
								+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						actionResponse.setWindowState(WindowState.NORMAL);
						actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				System.out.println("Start Date should be less than End Date!");
				SessionErrors.add(actionRequest, "error");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setWindowState(WindowState.NORMAL);
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
			}

		} else {
			System.out.println("It may Be Sat or sun Day or Holi Day ");
			SessionErrors.add(actionRequest, "error1");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
		}
	}

	// DELETE METHOD.....
	@ProcessAction(name = "deleteLeave")
	public void deleteLeave(ActionRequest actionRequest, ActionResponse actionResponse) {
		long leaveApplyId = ParamUtil.getLong(actionRequest, "leaveApplyId");
		try {
			LeaveApply applyObj = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplyId);
			LeaveApplyLocalServiceUtil.deleteLeaveApply(applyObj);
			
			DynamicQuery dynamicQuery1 = LeaveDocLocalServiceUtil.dynamicQuery();
			dynamicQuery1.add(PropertyFactoryUtil.forName("leaveApplyId").eq(new Long(leaveApplyId)));
			List<LeaveDoc> docList = LeaveDocLocalServiceUtil.dynamicQuery(dynamicQuery1);
			if(docList.size()>0){
				for (LeaveDoc leaveDocObj : docList) {
					// System.out.println("Value : : : : : : : : : :: : : : :::: " +
					// applyDtlObj.toString());
					LeaveDoc leaveDoc = LeaveDocLocalServiceUtil.getLeaveDoc(leaveDocObj.getLeaveDocId());
					DLAppLocalServiceUtil.deleteFileEntry(leaveDocObj.getFileEntryId());
					 LeaveDocLocalServiceUtil.deleteLeaveDoc(leaveDoc);
					// System.out.println("Value Deleted ");
				}
			}
			
			DynamicQuery dynamicQuery = LeaveApplyDtlLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("leaveApplyId").eq(new Long(leaveApplyId)));
			List<LeaveApplyDtl> leaveList = LeaveApplyDtlLocalServiceUtil.dynamicQuery(dynamicQuery);
			for (LeaveApplyDtl applyDtlObj : leaveList) {
				// System.out.println("Value : : : : : : : : : :: : : : :::: " +
				// applyDtlObj.toString());
				LeaveApplyDtl applyDtl = LeaveApplyDtlLocalServiceUtil
						.getLeaveApplyDtl(applyDtlObj.getLeaveApplyDtlId());
				LeaveApplyDtlLocalServiceUtil.deleteLeaveApplyDtl(applyDtl);
				// System.out.println("Value Deleted ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @ProcessAction(name = "updateStatus") public void
	 * updateStatus(ActionRequest actionRequest, ActionResponse actionResponse)
	 * throws NumberFormatException, PortalException, IOException {
	 * 
	 * long leaveApplyId = ParamUtil.getLong(actionRequest, "leaveApplyId", 0);
	 * String comments = ParamUtil.getString(actionRequest, "comment",
	 * StringPool.BLANK); String status = ParamUtil.getString(actionRequest,
	 * "status", StringPool.BLANK);
	 * 
	 * LeaveApply leaveApply = null; if (Validator.isNotNull(leaveApplyId)) {
	 * leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(leaveApplyId);
	 * leaveApply.setStatus_(Integer.valueOf(status));
	 * leaveApply.setHrComments(comments);
	 * LeaveApplyLocalServiceUtil.updateLeaveApply(leaveApply); }
	 * actionResponse.sendRedirect("jspPage", "/displayAllLeave.jsp"); }
	 */

	@ProcessAction(name = "leaveDocDelete")
	public void leaveDocDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws WindowStateException {
		long leaveDocId = ParamUtil.getLong(actionRequest, "leaveDocId");
		long leaveApplyId = ParamUtil.getLong(actionRequest, "leaveApplyId");
		long leaveTypeId = ParamUtil.getLong(actionRequest, "leaveTypeId");
		// System.out.println("leaveDocId " + leaveDocId);
		if (Validator.isNotNull(leaveDocId)) {
			try {
				LeaveDoc leaveDoc = LeaveDocLocalServiceUtil.getLeaveDoc(leaveDocId);
				DLAppLocalServiceUtil.deleteFileEntry(leaveDoc.getFileEntryId());
				System.out.println(" Value Delted From Document Media ");
				LeaveDoc leaveDocObj = LeaveDocLocalServiceUtil.deleteLeaveDoc(leaveDoc);
				System.out.println("Value Delete From LeaveDoc");
				if (leaveDocObj != null) {
					SessionMessages.add(actionRequest, "delete-success");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					actionResponse.setWindowState(WindowState.NORMAL);
					actionResponse.setRenderParameter("leaveApplyId", String.valueOf(leaveApplyId));
					actionResponse.setRenderParameter("leaveTypeId", String.valueOf(leaveTypeId));
					actionResponse.setRenderParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}