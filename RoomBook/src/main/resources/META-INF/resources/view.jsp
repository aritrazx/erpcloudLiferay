<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.ConferenceRoomLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.model.ConferenceRoom"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<script
src="/documents/20143/0/jquery.min.js/e7a8ce76-ceff-6fa0-9a18-a9b1468929f7"></script>
<link
	href="/documents/20143/52830/bootstrap-fullcalendar.css/d3bc9ef3-806c-9372-42f4-9ce3c40190a6"
	rel="stylesheet" type="text/css" />
	
<script
	src="/documents/20143/52830/fullcalendar-1.min.js/1b24d0e8-e13b-480b-116a-6ed275849f06"></script>
	

<% 
	
	long roomId = ParamUtil.getLong(request,"roomId");
	PortletURL assignURL = renderResponse.createRenderURL();
	assignURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	assignURL.setParameter("jspPage", "/META-INF/resources/roomDetails.jsp");
	System.out.println("roomId.."+roomId);
	String popup ="javascript:popup('"+ assignURL.toString()+"');";
	assignURL.setParameter("roomId",String.valueOf(2));
	 /*assignURL.setParameter("notifyId", String.valueOf(curRow.getNotifyIdSendId()) ); , */
	
%>	

	<%-- <portlet:renderURL var="popupUrl" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
 		<portlet:param name="mvcPath" value="/roomDetails.jsp"/>
	</portlet:renderURL> --%>

	
<%
	List<ConferenceRoom> conRoomList = ConferenceRoomLocalServiceUtil.getConferenceRooms(-1,-1);	
%>
<%-- <portlet:actionURL name="calendar" var="popup" /> --%>
<aui:form name="calendar" action="<%=popup.toString() %>"
	method="post">
	<%-- <aui:input name="roomId" type="hidden" value="<%=roomId%>"></aui:input> --%>
	<aui:row>
		<aui:col span="6">
		<aui:select name="roomId"
				label="Room Number">
			<%
				for (ConferenceRoom roomList:conRoomList) {
					
					
					
				
				//if(evaluationTemp!=null){	
				%>
			<aui:option value="<%=roomList.getRoomId()%>"><%=roomList.getRoomNo()%></aui:option>
			<%}
				
				%>
		</aui:select>
		</aui:col>
		<aui:col span="4">
			<aui:button name="button" type="submit" value="Info"></aui:button>
		</aui:col>
	</aui:row>
	<div id="calendar"></div>

</aui:form>

<script>
<%-- function addTimeSheet(date){
	var url="<%=tsEntryURL.toString()%>"
		alert('Want to add timesheet? ' + date);
		$.ajax({
			type : "POST",
			url : url,
			data : {
				"<portlet:namespace/>date" : date
			},
			//dataType: 'json',
			success : function(data) {
				//alert(data);
				$("#calendar").html(data);

				$('#calendar').show();
			},
		});
	}
	 --%>


	$(document).ready(
			function() {

				var curDate = new Date();
				$('#calendar').fullCalendar(
						{
							selectable: true,
							selectHelper: true,
							firstDay : 0,
							//theme:true,
							dayNamesShort : [ 'Su', 'Mo', 'Tu', 'We', 'Th',
									'Fr', 'Sa' ],
							defaultDate : curDate,
							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'today prev,next',
								prev : 'left-single-arrow',
								next : 'right-single-arrow',
							},

							dayRender : function(date, cell) {
								
								var formDate = date.getDate() + "/"	+ (date.getMonth() + 1) + "/"+ date.getFullYear();
								
								//cell.prepend('<span class="selector">'
									//	+ formDate + '</span>');
								
								//var customeVal="Hello world";
								
								  <%-- <%for(Map.Entry m:map.entrySet()){%> 
								    if(formDate.getDate()==<%=m.getKey()%>){
								    	<%if(Validator.isNotNull(m.getValue())){ %>
								     
									 cell.prepend('<span class="selector">'
											 	 +<%=m.getValue()%>+' hours'+ '</span>');
								        <%}%>
								       }  
								 <% }  %> --%> 
								 
							},

							dayClick : function(date, cell) {
								var formDate = date.getDate() + "/"	+ (date.getMonth() + 1) + "/" + date.getFullYear();
								//formDate = $("#formDate").val();
								//alert('formDate ' + formDate);
								var clickDate =date.getDate();
								var clickMonth =date.getMonth() + 1;
								var clickYear = date.getFullYear();
								var selDate = new Date();
								//selDate = $("#newSelDate").val();
								//alert('selDate ' + selDate);
								var curr_date = selDate.getDate();
								var curr_month = selDate.getMonth()+1;
								var curr_year = selDate.getFullYear();
								//alert('Want to add timesheet? ' + formDate);
								out:
								//$(this).css('background-color', 'grey');
								if(clickDate<=curr_date && clickMonth<=curr_month && clickYear<=curr_year){ 
								addTimeSheet(formDate);
								} else {
									if(clickMonth<curr_month && clickDate>curr_date && clickYear<=curr_year){
										addTimeSheet(formDate);
										break out;
									} else {
										if(clickMonth>curr_month && clickDate>curr_date && clickYear<curr_year){
											addTimeSheet(formDate);
											break out;
										} else {
											if(clickMonth>curr_month && clickDate<curr_date && clickYear<curr_year){
												addTimeSheet(formDate);
												break out;
											} else {}
										}
										}
									
								
									extendedDate(formDate);
								}

							},
							select: function(start, end) {
								var selDate = new Date(start);
								var curr_date = selDate.getDate();
								var curr_month = selDate.getMonth()+1;
								var curr_year = selDate.getFullYear();




 

								//var title = prompt('Event Title:'+selDate);

								var eventData;
								if (title) {

								/*eventData = {
								title: title,
								start: start,
								end: end
								};*/
								$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
								}
								$('#calendar').fullCalendar('unselect');
								},
								editable: true,
								eventLimit: true, 
								<%-- events: [
									 <%for (Map.Entry m : map.entrySet()) {%>
									{
										<%if(Validator.isNotNull(m.getValue())){ %>
									    
										title: '<%=m.getValue()%>',
									      <%}%> 
										 
									start: '<%=m.getKey()%>'
									},

									<%}%>


									] --%>

						});
				//getMonth();
				//$('#calendar').fullCalendar('gotoDate', curDate);
			});
			/* function getMonth(){
			  var date = $("#calendar").fullCalendar('getDate');
			  var month_int = date.getMonth();
			  alert(month_int+1 );
			 // $("#<portlet:namespace/>test").val()=month_int;
			  //you now have the visible month as an integer from 0-11
			} */
	       function showHours(date){
	    	   var dt=date;
	    	  // jQuery("#<portlet:namespace/>forDat").val()=1;
	    	  // alert(date);
	    	   
	       }
</script>
<aui:script>
	function popup(url) {
	Liferay.Util.openWindow({
	dialog : {
	//cssClass: 'aui-popup-example',
	destroyOnHide : true,
	height : 700,
	width : 650
	},
	dialogIframe : {
	//bodyCssClass: 'custom-css-class'
	},
	title : 'Room Details',
	uri : url
	
	});
	} 
</aui:script>

