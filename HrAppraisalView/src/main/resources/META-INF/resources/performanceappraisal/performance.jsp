<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.AppraisalPerformance"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page
	import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PerformanceLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Performance"%>
<%@page import="java.util.List"%>

<%
	List<Performance> performanceList = PerformanceLocalServiceUtil.getPerformances(-1, -1);
	List<RatingMaster> ratingMasterList = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);
	System.out.println("performanceList : " + performanceList.size());
%>

<table class="table table-bordered table-hover">
	<thead>
		<tr class="label-info">
			<th class="text-center col-md-4">Competency Area</th>
			<th class="text-center col-md-4">Notes/Comments on Competency
				Areas and Suggestions for Improvement</th>
			<th class="text-center col-md-2">Employee's Rating</th>
			<th class="text-center col-md-2">HR's Rating</th>
		</tr>
	</thead>

	<tbody id="custom-table">
		<%
			int i = 1;
			String performance = StringPool.BLANK;
			for (Performance pObj : performanceList) {
				performance = performance + pObj.getPerformanceId() + ",";
				AppraisalPerformance appPerformObj = null;
				try {
					if (Validator.isNotNull(getMasterObj) && Validator.isNotNull(setup)) {
						appPerformObj = AppraisalPerformanceLocalServiceUtil
								.findByApprIdSettingIdAndEmployeeIdPerformId(getMasterObj.getAppraisalId(),
										setup.getAppraisalSettingId(), employeeId,
										pObj.getPerformanceId());
						System.out.println("appPerformObj...>>> " + appPerformObj);
						System.out.println(
								"appPerformObj.getPerformanceComm()...>>> " + appPerformObj.getPerformanceComm()
										+ "  appPerformObj.getRatingIdEmp()..>>>  " + appPerformObj.getRatingIdEmp());
					}
				} catch (Exception e) {
				}
		%>
		<tr>
			<td class="text-left col-md-4"><strong><%=pObj.getPerformanceHeading()%>
					: </strong><%=pObj.getPerformanceDescription()%></td>
			<td class="text-left col-md-4"><textarea label=""
					name="<portlet:namespace/>performance_<%=pObj.getPerformanceId()%>"
					value="" disabled="disabled" placeholder="Notes/Comments"><%=Validator.isNotNull(appPerformObj) ? appPerformObj.getPerformanceComm() : ""%></textarea></td>
			<td class="text-left col-md-2"><select label=""
				disabled="disabled"
				name="<portlet:namespace/>performanceEmpRat_<%=pObj.getPerformanceId()%>">
					<%--<aui:option value=""><c:out value="Select Rating" /></aui:option>
			 <c:forEach items="${manageAppraisalModel.ratingMasterModel}" var="rating">
				<aui:option value="${rating.ratingId}" selected="${rating.ratingId==empDetails.employeetypeId ? true : false }">
					<c:out value="${rating.ratingKey} - ${rating.ratingNum}" />
				</aui:option>
			</c:forEach> --%>
					<aui:option value="">Select Rating</aui:option>
					<%
						for (RatingMaster rObj : ratingMasterList) {
								System.out.println("rObj.getRatingId()...>>> " + rObj.getRatingId());
								String selected = StringPool.BLANK;
								if (Validator.isNotNull(appPerformObj)) {
									if (rObj.getRatingId() == appPerformObj.getRatingIdEmp()) {
										System.out.println("rObj.getRatingId()<<<<...>>> " + rObj.getRatingId()
												+ "...>>appPerformObj.getRatingIdEmp()<<<..." + appPerformObj.getRatingIdEmp());
										selected = "selected";
									} else {
										selected = "";
									}
								}
					%>
					<option value="<%=rObj.getRatingId()%>" <%=selected%>><%=rObj.getRatingNum()%>
						-
						<%=rObj.getRatingKey()%></option>
					<%
						}
					%>
			</select></td>
			
			<%
			String disable = StringPool.BLANK;
			if(getMasterObj.getSubmitStep()==3){
				disable = "disabled";
			}
			
			%>
			
			<td class="text-left col-md-2"><select label="" <%=disable %>
				name="<portlet:namespace/>performanceManRat_<%=pObj.getPerformanceId()%>">
					<%-- <option value=""><c:out value="Select Rating"/></option>
			<c:forEach items="${manageAppraisalModel.ratingMasterModel}" var="rating">
			<option value="${rating.ratingId}" selected="${rating.ratingId==empDetails.employeetypeId ? true : false }">
				<c:out value="${rating.ratingKey} - ${rating.ratingNum}"/></option>
			</c:forEach> --%>
					<aui:option value="">Select Rating</aui:option>
					<%
						for (RatingMaster rObj : ratingMasterList) {
							System.out.println("rObj.getRatingId()...>>> " + rObj.getRatingId());
							String selected = StringPool.BLANK;
							if (Validator.isNotNull(appPerformObj)) {
								if (rObj.getRatingId() == appPerformObj.getRatingIdMan()) {
									System.out.println("rObj.getRatingId()<<<<...>>> " + rObj.getRatingId()
											+ "...>>appPerformObj.getRatingIdEmp()<<<..." + appPerformObj.getRatingIdMan());
									selected = "selected";
								} else {
									selected = "";
								}
							}
					%>
					<option value="<%=rObj.getRatingId()%>" <%=selected%>><%=rObj.getRatingNum()%>
						-
						<%=rObj.getRatingKey()%></option>
					<%
						}
					%>
			</select></td>
		</tr>
		<%
			i++;
		%>
		<%
			}
		%>
		<input name="<portlet:namespace/>performanceList" type="hidden"
			value="<%=performance%>" />
	</tbody>
</table>
