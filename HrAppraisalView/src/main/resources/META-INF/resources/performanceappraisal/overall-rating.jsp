<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />



<aui:row>
	<aui:col span="6">
		<aui:input label="Employee's Comments:" id="overallCommentEmp" value="${getMasterObj.overallCommentEmp}"
			name="overallCommentEmp" type="textarea" disabled="true"
			placeholder="Employee's Comments"></aui:input>

	</aui:col>
	<aui:col span="6">
	<%
		String hrCommentLabel = "";
		hrCommentLabel = "HR's Comments <span style='color:red'>*</span>:";
		System.out.print("hrCommentLabel : "+hrCommentLabel);
	%>
	<%-- 	<aui:input label="HR's Comments:" id="overallCommentMan" value="${getMasterObj.overallCommentMan}"
			name="overallCommentMan" type="textarea" placeholder="HR's Comments" disabled="<%=disabled %>"></aui:input> --%>
		<aui:input label="<%=hrCommentLabel %>" id="overallCommentMan" value="${getMasterObj.overallCommentMan}"
			name="overallCommentMan" type="textarea" placeholder="HR's Comments" disabled="<%=disabled %>" ></aui:input>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="6">
		<aui:select label="Employee's Rating:" name="overallRatEmp" disabled="true" 
			id="overallRatEmp">
			<aui:option value="">
				<c:out value="Select Rating" />
			</aui:option>
			<c:forEach items="${manageAppraisalModel.ratingMasterModel}" var="rating">
				<aui:option value="${rating.ratingId}"
					selected="${rating.ratingId==getMasterObj.overallRatingEmp ? true : false }">
					<c:out value="${rating.ratingKey}-${rating.ratingNum}" />
				</aui:option>
			</c:forEach>
		</aui:select>
	</aui:col>
	<aui:col span="6">
	<%
		String hrRatingLabel = "";
		hrRatingLabel = "HR's Rating <span style='color:red'>*</span>:";
		System.out.print("hrRatingLabel : "+hrRatingLabel);
	%>
		<aui:select label="<%=hrRatingLabel %>"  name="overallRatMan" disabled="<%=disabled %>"
			id="overallRatMan" >
			<aui:option value="">
				<c:out value="Select Rating" />
			</aui:option>
			<c:forEach items="${manageAppraisalModel.ratingMasterModel}"
				var="rating">
				<aui:option value="${rating.ratingId}"
					selected="${rating.ratingId==getMasterObj.overallRatingMan ? true : false }">
					<c:out value="${rating.ratingKey}-${rating.ratingNum}" />
				</aui:option>
				<%-- <aui:option value="${empType.employeetype_id}"
					selected="${empType.employeetype_id==empDetails.employeetypeId ? true : false }">
					<c:out value="${empType.type_name}" />
				</aui:option> --%>
			</c:forEach>
		</aui:select>
	</aui:col>
</aui:row>

