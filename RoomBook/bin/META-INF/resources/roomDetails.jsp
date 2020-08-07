<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.ConferenceRoomLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ConferenceRoom"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	String roomId= request.getParameter(roomId);
	System.out.println("roomId1111111111111"+roomId);
	ConferenceRoom cm = ConferenceRoomLocalServiceUtil.getConferenceRoom(Long.parseLong(roomId));
%>
<aui:row>
	<aui:col>
		<p>
		Room Number: <b style="color: #f48120;"><%=cm.getRoomNo()%></b>
	</p></br>
	</aui:col>
	
</aui:row>