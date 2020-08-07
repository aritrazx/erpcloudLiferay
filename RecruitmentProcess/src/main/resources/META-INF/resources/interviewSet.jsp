<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitmentProcess"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.JobPostLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobPost"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	long interviewerId = ParamUtil.getLong(request, "interviewerId");
	String interViewerName = StringPool.BLANK;

	long applyCandidateId = ParamUtil.getLong(request, "applyCandidateId");
	long recruitmentProcessId = ParamUtil.getLong(request, "recruitmentProcessId");
	//String yearEx = ParamUtil.getString(request, "yearEx", StringPool.BLANK);
	//String url = ParamUtil.getString(request, "url", StringPool.BLANK);
	CandidateApply applyObj = null;
	JobOpening openingObj = null;
	Employee findEmployee = null;
	FileEntry dlfile = null;
	String url = StringPool.BLANK;
	String yearEx = StringPool.BLANK;
	RecruitmentProcess process = null;
	Employee employee = null;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String interviewDate = StringPool.BLANK;
		if (Validator.isNotNull(recruitmentProcessId)) {
			process = RecruitmentProcessLocalServiceUtil.getRecruitmentProcess(recruitmentProcessId);
			 interviewDate = dateFormat.format(process.getInterviewDate());
		}

		if (Validator.isNotNull(interviewerId)) {
			employee = EmployeeLocalServiceUtil.getEmployee(interviewerId);
			interViewerName = employee.getFirstName() + " " + employee.getLastName();
		}

		if (Validator.isNotNull(applyCandidateId)) {
			applyObj = CandidateApplyLocalServiceUtil.getCandidateApply(applyCandidateId);
			System.out.println("applyObj "+applyObj);
			if (Validator.isNotNull(applyObj.getJobOpeningId())) {
				openingObj = JobOpeningLocalServiceUtil.getJobOpening(applyObj.getJobOpeningId());
				System.out.println("openingObj "+openingObj);
			}
			if (Validator.isNotNull(applyObj.getReferenceEmployeeId())) {

				findEmployee = EmployeeLocalServiceUtil.getEmployee(applyObj.getReferenceEmployeeId());
			}
		}
			System.out.println("11111" + applyObj.getCvFileId());
			
		//for cv url	
		try {
		if (applyObj != null && Validator.isNotNull(applyObj.getCvFileId())) {
			System.out.println("1");
			dlfile = DLAppServiceUtil.getFileEntry(applyObj.getCvFileId());
			Date date2 = new Date();
			Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60)
					+ date2.getSeconds()) * 1000);
			url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
					+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/"
					+ dlfile.getFileName() + "/" + dlfile.getUuid() + "?t=" + time2;

			System.out.println("2");
		}
		} catch (Exception e) {
		}
		
		//caculate experience
		if (applyObj.getYearOfExp() != 0) {
			yearEx = applyObj.getYearOfExp() + "." + applyObj.getMonthOfExp() + "year";
		} else if (applyObj.getMonthOfExp() != 0) {
			yearEx = applyObj.getMonthOfExp() + "months";
		}

	PortletURL setInterviewerURL = renderResponse.createRenderURL();
	setInterviewerURL.setWindowState(LiferayWindowState.POP_UP);
	setInterviewerURL.setParameter("jspPage", "/META-INF/resources/findInterviewer.jsp");

	List<JobPost> jobPost = JobPostLocalServiceUtil.getJobPosts(-1, -1);
%>

<%
	PortletURL applyListURL = renderResponse.createRenderURL();
	applyListURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<portlet:actionURL name="addEditInterview" var="addEditInterviewURL" />
<aui:form name="addEditInterview"
	action="<%=addEditInterviewURL.toString()%>" method="post">
	
	<aui:input name="interviewerId" type="hidden" id="interviewerId"
		value="<%=interviewerId%>"></aui:input>
	<aui:input name="recruitmentProcessId" type="hidden"
		value="<%=recruitmentProcessId%>"></aui:input>
	<aui:input name="applyCandidateId" type="hidden"
		value="<%=applyCandidateId%>"></aui:input>
		
	<aui:row>
		<aui:col span="12">
			<a href="<%=applyListURL.toString()%>"><span
				class="icon-monospaced"><svg
						class="lexicon-icon lexicon-icon-angle-left" focusable="false"
						role="img" title="Back" backLabel="Back" viewBox="0 0 512 512">
    					<path class="lexicon-icon-outline"
							d="M114.106 254.607c0.22 6.936 2.972 13.811 8.272 19.11l227.222 227.221c11.026 11.058 28.94 11.058 39.999 0 11.058-11.026 11.058-28.94 0-39.999l-206.333-206.333c0 0 206.333-206.333 206.333-206.333 11.058-11.059 11.058-28.973 0-39.999-11.058-11.059-28.973-11.059-39.999 0l-227.221 227.221c-5.3 5.3-8.052 12.174-8.273 19.111z"></path>
			</svg></span>Back</a>
			<h3 align="center">Candidate Information</h3>
			</br>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<p>
				Full Name : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getFirstName() + " " + applyObj.getLastName() : ""%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Email Address : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getEmailAddress() : " "%></b>
			</p>
		</aui:col>
	</aui:row>
	</br>
	<aui:row>
		<aui:col span="6">
			<p>
				Mobile Number : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getPhoneNumber() : " "%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Experience : <b style="color: #f48120;"><%=yearEx%></b>
			</p>
		</aui:col>
	</aui:row>
	</br>

	<aui:row>
		<aui:col span="6">
			<p>
				Apply For : <b style="color: #f48120;"><%=openingObj != null ? openingObj.getOpeningFor() : " "%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Skills : <b style="color: #f48120;"><%=applyObj != null ? applyObj.getSkillset() : " "%></b>
			</p>
		</aui:col>
	</aui:row>
	</br>
	<aui:row>
		<aui:col span="12">
			<%
				if (url != null) {
			%>
			<p>
				View Cv :<a href="<%=url.toString()%>" target="_blank"><b
					style="color: #ADD8E6; text-decoration: underline;" >&nbsp&nbspView
						Cv</b></a>
			</p>
			<%
				} else {
			%>
			<p>
				View Cv :<b style="color: #f48120;">&nbsp&nbspCv Not Found</b>
			</p>
			<%
				}
			%>
		</aui:col>
	</aui:row>
	<hr>
	<%
		if (Validator.isNotNull(findEmployee)) {
	%>

	<aui:row>
		<h3 align="center">Any Reference</h3>
		</br>
		<aui:col span="6">
			<p>
				Employee Name: <b style="color: #f48120;"><%=findEmployee != null
									? findEmployee.getFirstName() + " " + findEmployee.getLastName()
									: ""%></b>
			</p>
		</aui:col>
		<aui:col span="6">
			<p>
				Employee Code: <b style="color: #f48120;"><%=findEmployee != null ? findEmployee.getEmployeeCode() : ""%></b>
			</p>
			<%-- <aui:validator name="digits"></aui:validator> --%>
		</aui:col>

	</aui:row>
	<hr>
	<%
		}
	%>
	<aui:row>
		<aui:col span="6">
			<aui:input class="form-control" id="txtToTime" name="interviewTime"
				label="interview Time" type="text" placeholder="hh:mm"
				value="<%=process != null ? process.getInterviewTime() : ""%>"></aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input type="text" name="interviewDate" id="txtToDate"
				value="<%=process != null ?interviewDate: ""%>"
				label="Interview Date" readonly="readonly">
			</aui:input>
		</aui:col>

	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input class="btn btn-primary btn-default" name="setInterviewer"
				id="employeeName" type="text" onClick="popup()"
				label="Set Interviewer" readonly="readonly"
				value="<%=employee != null ? interViewerName : ""%>"></aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:select name="jobPostId" label="Job Post">
				<option value="">Select Post</option>
				<%
					try {
						for (JobPost post : jobPost) {
							if(Validator.isNotNull(process)){
				%>
				<aui:option value="<%=post.getJobPostId()%>"
					selected="<%=process.getJobPostId() == post.getJobPostId()%>"><%=post.getPostName()%>
				</aui:option>

				<%
					}else{ 
					
					%>
						<aui:option value="<%=post.getJobPostId()%>"><%=post.getPostName()%>
				</aui:option>
					<%}
							}
						} catch (Exception e) {
						}
				%>
			</aui:select>
		</aui:col>
	</aui:row>

	<aui:row>
		<aui:col span="6">
			<aui:button type="submit" name="save" value="Save" id="save"></aui:button>&nbsp&nbsp
		<aui:button type="reset" id="resetBtn" cssClass="btn btn-danger"
				name="button" value="Reset" onClick="resetBtn()"></aui:button>
		</aui:col>
	</aui:row>
</aui:form>




<aui:script>
	function popup() {
		var url = '<%=setInterviewerURL.toString() %>';
		Liferay.Util.openWindow({
			dialog : {
				destroyOnHide : false,
				height : 500,
				width : 350,
				modal : false,
				close : true
			},
			dialogIframe : {},
			title : 'Interviewer',
			uri : url
			
		});
	}

	$(document).ready(function() {
		selectEmployee = function(interviewerId, employeeName) {

			$('#<portlet:namespace />interviewerId').val(interviewerId);
			$('#<portlet:namespace />employeeName').val(employeeName);
		};
	});
</aui:script>
	




<script>
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {
				minimumDate : new Date()
			}
		});
	});

	YUI().use('aui-timepicker', function(Y) {
		new Y.TimePicker({
			trigger : '#<portlet:namespace />txtToTime',
			popover : {
				zIndex : 1

			},
			on : {
				selectionChange : function(event) {
					console.log(event.newSelection)
				}
			}
		});
	});
</script>