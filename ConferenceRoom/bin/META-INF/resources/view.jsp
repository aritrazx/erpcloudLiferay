<%@page import="com.liferay.famocom.erpcloud.service.ConferenceRoomLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.ConferenceRoom"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	boolean editURL = false;
	long conferenceRoomId = ParamUtil.getLong(request, "conferenceRoomId");
	List<ConferenceRoom> allRoom = ConferenceRoomLocalServiceUtil.getConferenceRooms(-1,-1);
	ConferenceRoom conRoom=null;
	if(conferenceRoomId!=0){
		editURL = true;
		try {
			conRoom = ConferenceRoomLocalServiceUtil.getConferenceRoom(conferenceRoomId);
			//System.out.println("template:" + template);
		} catch (Exception e) {

		}
	}

	/* String roomNumber = ParamUtil.getString(actionRequest, "roomNumber",StringPool.BLANK);
	String floorNumber = ParamUtil.getString(actionRequest, "floorNumber",StringPool.BLANK);
	String capacity = ParamUtil.getString(actionRequest, "capacity",StringPool.BLANK);
	String openTime = ParamUtil.getString(actionRequest, "openTime",StringPool.BLANK);
	String closeTime = ParamUtil.getString(actionRequest, "closeTime",StringPool.BLANK); */
	
	
	PortletURL roomEditURL = renderResponse.createRenderURL();
	roomEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL roomDeleteURL = renderResponse.createActionURL();
	roomDeleteURL.setParameter("javax.portlet.action", "roomDelete");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	/* iteratorUrl.setParameter("roomNumber", roomNumber);
	iteratorUrl.setParameter("floorNumber", floorNumber);
	iteratorUrl.setParameter("capacity", capacity);
	iteratorUrl.setParameter("openTime", openTime);
	iteratorUrl.setParameter("closeTime", closeTime);
 */
%>


<portlet:actionURL name="conferenceRoomAdd" var="conferenceRoomURL" />
<portlet:actionURL name="conferenceRoomEdit" var="conferenceRoomEditURL" />
<aui:form name="conferenceRoom"
	action="<%=editURL !=true?conferenceRoomURL.toString():conferenceRoomEditURL.toString()%>" method="post">
	<aui:input name="conferenceRoomId" type="hidden" value="<%=conferenceRoomId%>" />
	<aui:row>
		<aui:col span="6">
			<aui:input name="buliding" type="text" label="Block/Building Number" value="<%=conRoom != null?conRoom.getBuilding():""%>"></aui:input>
		</aui:col>
		
		<aui:col span="6">
			<aui:input name="roomNumber" type="text" label="Room Number" value="<%=conRoom != null?conRoom.getRoomNo():""%>">
				<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input name="floorNumber" type="text" label="Floor Number" value="<%=conRoom != null?conRoom.getFloorNo():""%>">
				<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input name="capacity" type="text" label="Capacity" value="<%=conRoom != null?conRoom.getCapacity():""%>">
				<aui:validator name="digits"></aui:validator>
			</aui:input>
		</aui:col>
	</aui:row>
	
		<aui:row>
		<aui:col span="6">
			<aui:input  class="form-control" name="openTime" id="txtToTime" type="text" label="Opening Time" placeholder="hh:mm" value="<%=conRoom != null?conRoom.getOpenTime():""%>"></aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input  class="form-control" name="closeTime" id="txtToTime" type="text" label="Closing Time" placeholder="hh:mm" value="<%=conRoom != null?conRoom.getCloseTime():""%>"></aui:input>
		</aui:col>
	</aui:row>
	<aui:button name="save" type="submit" value="save"></aui:button>
</aui:form>

<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = allRoom;
					total = allRoom.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("empType", allRoom);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ConferenceRoom"
		modelVar="cRooms">
		
		<liferay-ui:search-container-column-text name="Block/Building Number"
			orderable="true" orderableProperty="roomNumber">
			<%=cRooms.getBuilding()%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Room Number"
			orderable="true" orderableProperty="roomNumber">
			<%=cRooms.getRoomNo()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Floor Number"
			orderable="true" orderableProperty="floorNumber">
			<%=cRooms.getFloorNo()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Capacity"
			orderable="true" orderableProperty="capacity">
			<%=cRooms.getCapacity()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Open/Close Time"
			orderable="true" orderableProperty="timing">
			<%=cRooms.getOpenTime()+" to "+cRooms.getCloseTime()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					roomEditURL.setParameter("conferenceRoomId", String.valueOf(cRooms.getRoomId()));

					roomDeleteURL.setParameter("conferenceRoomId", String.valueOf(cRooms.getRoomId()));
				%>

				<liferay-ui:icon url="<%=roomEditURL.toString()%>" message="edit"
					image="edit" />
				<liferay-ui:icon-delete url="<%=roomDeleteURL.toString()%>"
					message="delete" image="delete" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator ></liferay-ui:search-iterator>
</liferay-ui:search-container>


<script>

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