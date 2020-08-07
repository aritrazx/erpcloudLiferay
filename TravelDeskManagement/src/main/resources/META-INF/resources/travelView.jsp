<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeDocumentUpload"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.DocumentUploadFile"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.famocom.erpcloud.model.TravelDeskDetails"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<script
	src="/documents/20143/0/jquery.min.js/127201bc-1b18-fed4-0b92-d37c7bba629e"></script>

<%
	PortletURL listViewURL = renderResponse.createRenderURL();
	listViewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL statusURL = renderResponse.createActionURL();
	statusURL.setParameter("javax.portlet.action", "updateStatus");
	
	PortletURL rejectURL = renderResponse.createActionURL();
	rejectURL.setParameter("javax.portlet.action", "reject");
	
	List<DocumentUploadFile> docList = new ArrayList<>();
	List<EmployeeDocumentUpload> empDocList = new ArrayList<>();
	long travelId = ParamUtil.getLong(request, "travelId");
	long employeeId = ParamUtil.getLong(request, "employeeId");
	TravelDeskDetails travelDeskDetails=null;
	Employee emp=null;
	ProjectMaster projectMaster =null;
	if(Validator.isNotNull(travelId)){
		try{
			travelDeskDetails = TravelDeskDetailsLocalServiceUtil.getTravelDeskDetails(travelId);
			System.out.println("travelId"+travelId);
			emp = EmployeeLocalServiceUtil.getEmployee(travelDeskDetails.getEmployeeId());
			projectMaster = ProjectMasterLocalServiceUtil.getProjectMaster(travelDeskDetails.getProjectId());
		}catch(Exception e){
			
		}
	}
	
	String status="";
	if(travelDeskDetails.getStatus()==0){
		status="Pending";
	}else if(travelDeskDetails.getStatus()==1){
		status="Accepted";
	}else{
		status="Rejected";
	}
	boolean isStatus=false;
	if(travelDeskDetails.getStatus()==1){
		isStatus=true;
	}
	statusURL.setParameter("travelId", String.valueOf( travelDeskDetails.getTravelDetailsId()));
	rejectURL.setParameter("travelId", String.valueOf( travelDeskDetails.getTravelDetailsId()));
	
	DynamicQuery dynamicQuery = DocumentUploadFileLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.eq("employeeId", employeeId);
	criterion3 = RestrictionsFactoryUtil.and(criterion3,
			RestrictionsFactoryUtil.eq("travelDetailsId", travelId));
	dynamicQuery.add(criterion3);
	docList = DocumentUploadFileLocalServiceUtil.dynamicQuery(dynamicQuery);
	
	DynamicQuery dynamicQuery1 = EmployeeDocumentUploadLocalServiceUtil.dynamicQuery();
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("employeeId", employeeId);
	/* criterion = RestrictionsFactoryUtil.and(criterion,
			RestrictionsFactoryUtil.eq("travelDeskDetailsId", travelId)); */
	dynamicQuery1.add(criterion);
	empDocList = EmployeeDocumentUploadLocalServiceUtil.dynamicQuery(dynamicQuery1);
	
	PortletURL viewURL = renderResponse.createRenderURL();
	viewURL.setWindowState(LiferayWindowState.NORMAL);
	viewURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
%>

<aui:row>
	<aui:col span="12">
		<liferay-ui:header title="Travel Details" backLabel="Back" backURL="<%=viewURL.toString()%>" />
	</aui:col>
</aui:row>
	
	
	<aui:row>
	<aui:col span="6">
	<p>
		Employee Name : <b style="color: #f48120;"><%=emp.getFirstName()+" "+emp.getLastName()%></b>
	</p></br>
	<p>
		Project Name : <b style="color: #f48120;"><%=projectMaster.getProjectName()%></b>
	</p></br>
	<p>
		Ticket Type : <b style="color: #f48120;"><%=travelDeskDetails.getTicketType()%></b>
	</p></br>
	<p>
		Status : <b style="color: #f48120;"><%=status%></b>
	</p></br>
	</aui:col>
		<%			
	String strDate = "";
	String strDate1 = "";
				if(Validator.isNotNull(travelDeskDetails)){
					Date addDate = travelDeskDetails.getFromDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM,yyyy");
					strDate = formatter.format(addDate);
					
					Date eDate = travelDeskDetails.getToDate();
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMMM,yyyy");
					strDate1 = formatter1.format(eDate);
	}
	%>
	
	<aui:col span="6">
	<p>
		From Date and Time : <b style="color: #f48120;"><%=strDate+" at "+travelDeskDetails.getFromTime()%></b>
	</p></br>
	<p>
		To Date and Time : <b style="color: #f48120;"><%=strDate1+" at "+travelDeskDetails.getToTime()%></b>
	</p></br>
	<p>
		Location : <b style="color: #f48120;"><%=travelDeskDetails.getLocation()%></b>
	</p></br>
	<p>
		Manager Comment : <b style="color: #f48120;"><%=travelDeskDetails.getManagerComment()%></b>
	</p></br>
	Uploaded Document : <%if(docList.size()==0){ %><b style="color: #f48120;">No Document Uploaded</b><%} %>
	<%for(int i=0;i<docList.size();i++){ %>
	</br>
		<a href="<%=docList.get(i).getDocumentPath()%>" target="_blank" ><b style="color: #f48120; text-decoration: underline;"><%=(i+1) +". " %><%=docList.get(i).getDocumentName() %></b></a>
	</br>
	<%} %>
	</br></br>
	Document Uploaded by <%=emp.getFirstName()+" "+emp.getLastName() %>: <%if(empDocList.size()==0){ %><b style="color: #f48120;">No Document Uploaded by <%=emp.getFirstName()+" "+emp.getLastName() %></b><%} %>
	<%for(int i=0;i<empDocList.size();i++){ %>
	</br>
		<a href="<%=empDocList.get(i).getDocumentPath()%>" target="_blank" ><b style="color: #f48120; text-decoration: underline;"><%=(i+1) +". " %><%=empDocList.get(i).getDocumentName() %></b></a>
	</br>
	<%} %>
	
</aui:col>  </aui:row>
<portlet:actionURL name="travelDeskManager" var="travelDeskManagerURL" />
<aui:form name="travelDeskManager" action="<%=travelDeskManagerURL.toString() %>" method="post" entype="multipart/form-data">
<aui:input name="travelId" type="hidden" value="<%=travelId %>"></aui:input>
<aui:input name="employeeId" type="hidden" value="<%=employeeId %>"></aui:input>
<aui:input label="U" name="fileIdValue" value="1" type="hidden"  />
<aui:row>

<div id="auto-fields-container">
		<div class="lfr-form-row lfr-form-row-inline">
		<aui:col span="3">
			<aui:input label="Upload File" name="employeeDoc1" type="file" required="true"/>
		</aui:col>
		<aui:col span="3">
			<aui:input label="Document Name" name="docName1" type="text" required="true"/>
		</aui:col>
		</div>
	</div>

</aui:row>
	<%-- <aui:row>
		<aui:col span="3">
			<aui:input type="radio" name="status"
				checked="<%=isStatus == false%>" label="Reject" value="2"></aui:input>
		</aui:col>
		<aui:col span="3">
			<aui:input type="radio" name="status" label="Approve"
				checked="<%=isStatus == true%>" value="1"></aui:input>
		</aui:col>
	</aui:row> --%>
	<aui:button-row>
	<aui:button name="button" type="submit" value="submit"></aui:button>
	</aui:button-row>
</aui:form>
<%-- <aui:script use="liferay-auto-fields">
new Liferay.AutoFields({
	contentBox: '#auto-fields-container',
	fieldIndexes: '<portlet:namespace />rowIndexes',
	on: {
		'clone': function(event) {
			console.log('clone');
			console.log(event);
		},
		'delete': function(event) {
			console.log('delete');
			console.log(event);
		}
	},
	sortable: true,
	sortableHandle: '.lfr-form-row'
}).render();
</aui:script> --%>

<aui:script use="liferay-auto-fields">
	new Liferay.AutoFields({
		contentBox : '#auto-fields-container',
		fieldIndexes : '<portlet:namespace />rowIndexes',
		on : {
			'clone' : function(event) {
				console.log('clone');
				console.log(event);
				var no = $('#<portlet:namespace />fileIdValue').val();
				//alert("no " + no);
				no++;
				var latestfileId = 'employeeDoc' + no;
				//alert("no1 "+latestfileId);
				//alert("no1 "+'#<portlet:namespace />'+latestfileId);
				$('#<portlet:namespace />' + latestfileId).val('');
			},
			'delete' : function(event) {
				console.log('delete');
				console.log(event);

			}
		},
		sortable : true,
		sortableHandle : '.lfr-form-row'
	}).render();

	
</aui:script>

