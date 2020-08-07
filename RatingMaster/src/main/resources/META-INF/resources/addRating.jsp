
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	boolean editURL = false;
	String ratingNumber = ParamUtil.getString(renderRequest, "ratingNumber", StringPool.BLANK);
	String ratingKey = ParamUtil.getString(renderRequest, "ratingKey", StringPool.BLANK);
	String ratingDesc = ParamUtil.getString(renderRequest, "ratingDesc", StringPool.BLANK);
	String addedDate = ParamUtil.getString(renderRequest, "addedDate", StringPool.BLANK);
	List<RatingMaster> ratMastList = new ArrayList<RatingMaster>();
	ratMastList = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);
	long ratingId = ParamUtil.getLong(request, "ratingId");
	RatingMaster rm = null;
	if (Validator.isNotNull(ratingId)) {
		editURL = true;
		try {
			rm = RatingMasterLocalServiceUtil.getRatingMaster(ratingId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

%>
<liferay-ui:error key="add-error"
	message="Sorry, Duplicate Rating Number" />
<aui:row>
	<liferay-ui:header title="Add Rating" backLabel="Back"
		backURL="<%=backURL.toString()%>"></liferay-ui:header>
</aui:row>

<portlet:actionURL name="ratingMaster" var="ratingMasterURL" />
<portlet:actionURL name="updateRatingMaster" var="updateRatingMasterURL" />
<aui:form name="ratingMaster"
	action="<%=editURL != true ? ratingMasterURL.toString() : updateRatingMasterURL.toString()%>"
	method="post">
	<aui:input name="ratingId" type="hidden" value="<%=ratingId%>">
	
	</aui:input>
	<aui:input name="ratingNumber" type="text" label="Rating Number"
		placeholder="Rating Number"
		value="<%=rm != null ? rm.getRatingNum() : ""%>">
		<aui:validator name="required"></aui:validator>
		 <aui:validator name="digits"></aui:validator>
	</aui:input>
	<aui:input name="ratingKey" type="text" label="Rating Key"
		placeholder="Rating Key" value="<%=rm != null ? rm.getRatingKey() : ""%>">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="ratingDesc" type="textarea" label="Rating Description"
		placeholder="Rating Description"
		value="<%=rm != null ? rm.getRatingDescription() : ""%>">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:button name="button" type="submit" value="submit"></aui:button>
	</br>
	</br>

</aui:form>
