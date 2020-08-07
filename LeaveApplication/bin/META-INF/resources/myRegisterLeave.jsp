<%@page import="org.apache.taglibs.standard.tag.common.core.CatchTag"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.repository.model.FileEntryWrapper"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveDocLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveDoc"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveType"%>
<%@page
	import="com.liferay.famocom.erpcloud.leaveapplication.util.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.LeaveApplyLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.LeaveApply"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.portlet.ThemeDisplayModel"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long userId = td.getUserId();
	//System.out.println("UserId..............."+userId);
	Employee empObj = EmployeeLocalServiceUtil.findByemployees(userId);

	PortletURL backUrl = renderResponse.createRenderURL();
	backUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	String status = StringPool.BLANK;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	List<LeaveApply> leaveListTemp = new ArrayList<>();
    leaveListTemp = LeaveApplyLocalServiceUtil.getLeaveApplies(-1, -1);

	List<LeaveType> Leaveobj = new ArrayList<LeaveType>();
	Leaveobj = LeaveTypeLocalServiceUtil.getLeaveTypes(-1, -1);
	
	List<Employee> EmployeeList = new ArrayList<>();
	EmployeeList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	PortletURL  getViewUrl = renderResponse.createRenderURL();
	getViewUrl.setParameter("jspPage", "/imageView.jsp");
	
	PortletURL  iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/myRegisterLeave.jsp");
	
	PortletURL leaveDeleteURL = renderResponse.createActionURL();
	leaveDeleteURL.setParameter("javax.portlet.action", "deleteLeave");
	
	PortletURL leaveResubmitURL = renderResponse.createRenderURL();
    
	
	PortletURL leaveEditURL = renderResponse.createRenderURL();
	leaveEditURL.setParameter("jspPage", "/LeaveApply.jsp");
	
	PortletURL leaveViewURL = renderResponse.createRenderURL();
	leaveViewURL.setParameter("jspPage", "/META-INF/resources/LeaveView.jsp");
	

try{
	DynamicQuery leaveListQuery = LeaveApplyLocalServiceUtil.dynamicQuery();
	Criterion criterion3=null;
	criterion3 = RestrictionsFactoryUtil.eq("employeeId",empObj.getEmployeeId());
	leaveListQuery.add(criterion3);
	leaveListTemp = LeaveApplyLocalServiceUtil.dynamicQuery(leaveListQuery);
	//System.out.println("Temp.....................:-"+leaveListTemp);
	
}catch(Exception e){
	
}
%>
<aui:row>
	<liferay-ui:header title="My Applied Leave" backLabel="Back"
		backURL="<%=backUrl.toString()%>"></liferay-ui:header>
</aui:row>
<aui:row>
	<aui:col span="10">
	 Name : <%=empObj.getFirstName()%>
		<%=empObj.getLastName()%></b>
	</aui:col>
	<aui:col span="2">
		<%-- <a align="right" class="btn btn-primary btn-default"
			name="myRegisterleave" type="submit" href="<%=backUrl.toString()%>">Back</a> --%>
	</aui:col>
</aui:row>
<%
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("asc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	 if (Validator.isNull(orderByType)) {
		orderByType = "asc";
	} 
	 /* if (Validator.isNull(orderByCol)) {
		 orderByCol = "goal_name";
		} */
	 System.out.println("orderByCol..." + orderByCol);
	 System.out.println("orderByType..." + orderByType);
	 List<LeaveApply> tsSortList = new ArrayList<>();
	 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);

	 	tsSortList = ListUtil.copy(leaveListTemp);

	 ListUtil.sort(tsSortList, orderByComparator);
%>
<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." orderByCol=""
	iteratorURL="<%=iteratorUrl %>" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = tsSortList;
			total = results.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.LeaveApply"
		modelVar="var">

		<liferay-ui:search-container-column-text name="From Date"
			orderable="true" orderableProperty="fromDate">
			<%=dateFormat.format(var.getFromDate())%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="To Date"
			orderable="true" orderableProperty="toDate">
			<%= dateFormat.format(var.getToDate())%>
		</liferay-ui:search-container-column-text>
		<%
			//long leaeTypeId=0;
					LeaveType leaveobj = null;
					try {
						leaveobj = LeaveTypeLocalServiceUtil.getLeaveType(var.getLeaveTypeId());
					} catch (Exception e) {
						e.printStackTrace();
					}
			  if(Validator.isNotNull(var.getStatus())){
					if(var.getStatus()==0){
			    		status = "PENDING" ;
			    	}else if(var.getStatus()==1){
			    		status = "APPROVED";
			    	}/* else if(var.getStatus()==2){
			    		status = "RESUBMITTED";
			    	} */else if(var.getStatus()==2){
			    		status = "REJECTED";
			    	}
			    	
			    }
					
		%>

		<liferay-portlet:renderURL varImpl="goalURL">
			<portlet:param name="leaveTypeId"
				value="<%=String.valueOf(var.getLeaveTypeId())%>" />
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-row-parameter name="goalURL"
			value="<%=goalURL.toString()%>" />
		<liferay-ui:search-container-column-text name="Leave Type"
			orderable="true" orderableProperty="leaveTypeId" href="<%= goalURL%>">
			<%=leaveobj.getLeaveName() %>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Reason"
			orderable="true" orderableProperty="reason">
			<%=var.getReason()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Leave Days"
			orderable="true" orderableProperty="leaveDays">
			<%=var.getLeaveDays()%>
		</liferay-ui:search-container-column-text>
		<%
			LeaveApply leaveApply=null;
		try{
			leaveApply = LeaveApplyLocalServiceUtil.getLeaveApply(var.getLeaveApplyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
		<liferay-ui:search-container-column-text name="Attached File">
			<%
			try{
			List<LeaveDoc> leaveDocs = LeaveDocLocalServiceUtil.getDocsByLeaveApplyId(var.getLeaveApplyId());
			 if(leaveDocs!=null && !leaveDocs.isEmpty()){
				 //System.out.println(":::::: If StatisFy :::::::");
				 for(LeaveDoc doc : leaveDocs){
					 //System.out.println("FileEntry Iddd-"+doc.getFileEntryId());
					 if(doc.getFileEntryId()>0){
						 
						 FileEntry fileEntry = DLAppServiceUtil.getFileEntry(doc.getFileEntryId());
						 String filePath = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "");
						 //System.out.println("FilePath .....................:-"+filePath);
						 System.out.println("FileEntry Iddd-"+ fileEntry.getMimeType());
						 %>
			<liferay-ui:icon
				label="<%= true %>" url='<%= filePath %>' icon="pdf"  message="<%=fileEntry.getTitle() %>" target="_blank"/><br>
			<%
					 }
				 }
			 }
			}catch (Exception e) {
				e.printStackTrace();
			}
			%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="isApprove">
			<%=status%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%  
							 leaveResubmitURL.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId()));
						     leaveResubmitURL.setParameter("leaveTypeId", String.valueOf(leaveobj.getLeaveTypeId()));
						     leaveResubmitURL.setParameter("isEdit", "true");
						     leaveResubmitURL.setParameter("jspPage", "/META-INF/resources/LeaveApply.jsp");
						     
						     leaveEditURL.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId()));
						     leaveEditURL.setParameter("leaveTypeId", String.valueOf(var.getLeaveTypeId()));
						     leaveEditURL.setParameter("isEdit", "true");

							 leaveDeleteURL.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId())); 
							 
							 leaveViewURL.setParameter("leaveApplyId", String.valueOf(var.getLeaveApplyId())); 
						%>

			<liferay-ui:icon-menu markupView="lexicon">
				<%
								if (var.getStatus()==2) {
								%>
				<liferay-ui:icon-delete url="<%=leaveDeleteURL.toString()%>"
					image="delete" message="Delete" />
				<liferay-ui:icon url="<%=leaveResubmitURL.toString() %>"
					label="Resubmit" message="Resubmit" image="edit" />
				<%
								}else if (var.getStatus()==0) {
								%>
				<liferay-ui:icon url="<%=leaveEditURL.toString() %>" label="Edit"
					message="Edit" image="edit" />
				<liferay-ui:icon-delete url="<%=leaveDeleteURL.toString()%>"
					image="delete" message="Delete" />
				<%}else if (var.getStatus()==1) {								
								%>
				<liferay-ui:icon url="<%=leaveViewURL.toString()%>" label="View"
					message="View" image="view" />
				<%}%>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>
