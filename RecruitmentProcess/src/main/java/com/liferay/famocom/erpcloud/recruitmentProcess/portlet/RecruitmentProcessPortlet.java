package com.liferay.famocom.erpcloud.recruitmentProcess.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.famocom.erpcloud.model.CandidateApply;
import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.RecruitmentProcess;
import com.liferay.famocom.erpcloud.model.SkillSet;
import com.liferay.famocom.erpcloud.recruitmentProcess.constants.RecruitmentProcessPortletKeys;
import com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil;
import com.liferay.famocom.erpcloud.service.SkillSetLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

/**
 * @author FAMOCOM-KAMESH
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=RecruitmentProcess Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RecruitmentProcessPortletKeys.RecruitmentProcess,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RecruitmentProcessPortlet extends MVCPortlet {
	// private static Logger _log =
	// Logger.getLogger(RecruitmentProcessPortlet.class);

	public void addEditInterview(ActionRequest actionRequest, ActionResponse actionResponse) {
		long interviewerId = ParamUtil.getLong(actionRequest, "interviewerId");
		long applyCandidateId = ParamUtil.getLong(actionRequest, "applyCandidateId");
		String interviewTime = ParamUtil.getString(actionRequest, "interviewTime");
		String interviewDate = ParamUtil.getString(actionRequest, "interviewDate", StringPool.BLANK);
		long jobPostId = ParamUtil.getLong(actionRequest, "jobPostId");
		long recruitmentId = ParamUtil.getLong(actionRequest, "recruitmentProcessId");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		RecruitmentProcess recruitmentProcess = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (Validator.isNotNull(recruitmentId)) {

				recruitmentProcess = RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentId);
				recruitmentProcess.setModifiedDate(new Date());
			} else {
				long recruitmentProcessId = CounterLocalServiceUtil.increment(RecruitmentProcess.class.getName());
				recruitmentProcess = RecruitmentProcessLocalServiceUtil.createRecruitmentProcess(recruitmentProcessId);
				recruitmentProcess.setCreateDate(new Date());
			}
			recruitmentProcess.setApplyCandidateId(applyCandidateId);
			recruitmentProcess.setInterviewDate((Date) dateFormat.parse(interviewDate));
			recruitmentProcess.setInterviewTime(interviewTime);
			recruitmentProcess.setInterviewerId(interviewerId);
			recruitmentProcess.setUserId(themeDisplay.getUserId());
			
			
			
			recruitmentProcess.setStatus(WorkflowConstants.STATUS_DRAFT);
			if (Validator.isNotNull(themeDisplay.getUserId())) {
				long userId = themeDisplay.getUserId();
				Employee emolyee = null;

				try {
					// System.out.println("111111");
					emolyee = EmployeeLocalServiceUtil.findByemployees(userId);
					// System.out.println("33333");
					if (Validator.isNotNull(emolyee)) {
						// System.out.println("222222");
						recruitmentProcess.setCreatedBy(emolyee.getEmployeeId());
					}
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}

			recruitmentProcess.setGroupId(themeDisplay.getScopeGroupId());
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			recruitmentProcess.setStatus(WorkflowConstants.STATUS_DRAFT);
			recruitmentProcess.setStatusByUserId(themeDisplay.getUserId());
			recruitmentProcess.setStatusDate(new Date());
			recruitmentProcess.setStatusByUserName(user.getFullName());
	        recruitmentProcess.setStatusByUserUuid(user.getUserUuid());
			recruitmentProcess.setJobPostId(jobPostId);
			if (Validator.isNotNull(recruitmentId)) {
				RecruitmentProcessLocalServiceUtil.updateRecruitmentProcess(recruitmentProcess);

			} else {
				RecruitmentProcessLocalServiceUtil.addRecruitmentProcess(recruitmentProcess);

			}
			String candidateName = StringPool.BLANK;
			if (Validator.isNotNull(applyCandidateId)) {
				CandidateApply apply = CandidateApplyLocalServiceUtil.getCandidateApply(applyCandidateId);
				candidateName = apply.getFirstName() + " " + apply.getLastName();
			}
			// Workflow
			// Integration===========================================================================

			long groupId = themeDisplay.getScopeGroupId();
			// User user =
			// UserLocalServiceUtil.getUser(themeDisplay.getUserId());

			ServiceContext serviceContext1 = ServiceContextFactory
					.getInstance(RecruitmentProcessPortlet.class.getName(), actionRequest);
			serviceContext1.setAddGroupPermissions(true);
			serviceContext1.setAddGuestPermissions(true);
			serviceContext1.setCompanyId(themeDisplay.getCompanyId());
			serviceContext1.setScopeGroupId(groupId);
			serviceContext1.setUserId(themeDisplay.getUserId());

			String postName = candidateName;

			updateAssetEntry(user, groupId, recruitmentProcess, postName);

			Indexer<RecruitmentProcess> indexer = IndexerRegistryUtil.nullSafeGetIndexer(RecruitmentProcess.class);
			indexer.reindex(recruitmentProcess);
			WorkflowHandlerRegistryUtil.startWorkflowInstance(themeDisplay.getCompanyId(),
					recruitmentProcess.getGroupId(), themeDisplay.getUserId(), RecruitmentProcess.class.getName(),
					recruitmentProcess.getPrimaryKey(), recruitmentProcess, serviceContext1);
			actionResponse.setWindowState(WindowState.NORMAL);
			actionResponse.setRenderParameter("jspPage", "/META-INF/resources/interviewList.jsp");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateAssetEntry(User user, long groupId, RecruitmentProcess recruitmentProcess, String postName) {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil
				.createAssetEntry(CounterLocalServiceUtil.increment(AssetEntry.class.getName()));
		assetEntry.setUserId(user.getUserId());
		assetEntry.setGroupId(groupId);
		assetEntry.setCreateDate(new Date());
		assetEntry.setModifiedDate(new Date());
		assetEntry.setClassName(RecruitmentProcess.class.getName());
		assetEntry.setClassPK(recruitmentProcess.getRecruitmentProcessId());
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

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		// System.out.println("Constants.CMD: " + cmd);

		if (cmd.equals("getSkillSets")) {
			String skillName = ParamUtil.getString(resourceRequest, "skillName");
			JSONArray skillArray = JSONFactoryUtil.createJSONArray();
			JSONObject skillObject;

			try {
				DynamicQuery dynamicQuery = SkillSetLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("SkillName").like("%" + skillName + "%"));
				List<SkillSet> skillList = SkillSetLocalServiceUtil.dynamicQuery(dynamicQuery);
				for (SkillSet skills : skillList) {
					// System.out.println("skillList: " + skillList);
					skillObject = JSONFactoryUtil.createJSONObject();
					skillObject.put("skillId", skills.getSkillId());
					skillObject.put("skillname", skills.getSkillName());
					skillArray.put(skillObject);
				}

			} catch (SystemException e) {
				e.printStackTrace();
			}
			// resourceResponse.getWriter().println();
			// super.serveResource(resourceRequest, resourceResponse);
			PrintWriter out = resourceResponse.getWriter();
			out.println(skillArray.toString());
		}
	}

	

}