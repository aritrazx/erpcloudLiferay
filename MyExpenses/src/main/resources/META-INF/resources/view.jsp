<%@page import="com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpenseEntry"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpCategory"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.model.RoleConstants"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroupRole"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="init.jsp" %>



<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM,yyyy");

    List<ExpCategory> expCatList= new ArrayList<>();
    expCatList=ExpCategoryLocalServiceUtil.getExpCategories(-1,-1);
    
	PortletURL expenseEntryUrl = renderResponse.createRenderURL();
    expenseEntryUrl.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");

    List<ExpenseEntry> ExpEntryList = new ArrayList<>();
    ExpEntryList = ExpenseEntryLocalServiceUtil.getExpenseEntries(-1, -1);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL myExpEditURL = renderResponse.createRenderURL();
	myExpEditURL.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
	//-----
	PortletURL manlistURL = renderResponse.createRenderURL();
	manlistURL.setParameter("jspPage", "/META-INF/resources/ManageExpList.jsp");
	//------
	/* PortletURL myExpViewURL = renderResponse.createRenderURL();
	myExpViewURL.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
	myExpViewURL.setWindowState(LiferayWindowState.NORMAL); */
	
	
    PortletURL myExpDeleteURL = renderResponse.createActionURL();
    myExpDeleteURL.setParameter("javax.portlet.action", "myExpDelete");
    
 //   ProjectMaster projectMaster=ProjectMasterLocalServiceUtil.getProjectMaster(projectId);
    /* System.out.println("for testing roles1");
    List<Role> userRoles = themeDisplay.getUser().getRoles();
    for(Role r:userRoles){
    	System.out.println("userRoles%%%%"+"name"+r.getName()+"roleid"+r.getRoleId());
    	
    }
    System.out.println("userRoles%%%%"+userRoles);
    try {
            Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),"Manager");  //Get the Role
            System.out.println("for testing roles2");
    List<UserGroupRole> userGroupList = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId()); //Getting the Roles of the User

    for(UserGroupRole userGroupRole :userGroupList) { //Iterating the loop
         if(role.getRoleId() == userGroupRole.getRoleId()) { //If roles are equal then user has the Organization Admin
                System.out.println("roleId is"+role.getRoleId()+"role Name"+role.getName());
              }
       }

    } catch (PortalException e) {
         e.printStackTrace();
    } catch (SystemException e) {
          e.printStackTrace();
    } */
    List<Role> userRoles = themeDisplay.getUser().getRoles();
    String roleName="";
    for(Role r:userRoles){
    	roleName=r.getName();
    	System.out.println("userRoles"+r.getName());
    	if(roleName.equalsIgnoreCase("User")){
     
%>
<portlet:renderURL var="manager">
	<portlet:param name="jspPage" value="/ManageExpList.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="hr">
	<portlet:param name="jspPage" value="/viewAccList.jsp"/>
</portlet:renderURL>
<a style="display:none" href="<%=manager.toString()%>">manager</a>
<a style="display:none" href="<%=hr%>">hr</a>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item title='<%=LanguageUtil.get(request, "Add Expense")%>'
url="<%=expenseEntryUrl.toString()%>" />
</liferay-frontend:add-menu>
<aui:form>
	<aui:row>
	    <aui:col span="6" >
	        
	    		<%-- <aui:select name="category" label="Category" id="category">
					 <option value="" selected>All Category</option>
						<%
					  	for(ExpCategory expCat: expCatList){
					     %>
						<option value="<%=expCat.getCatId() %>" ><%=expCat.getCategoryName() %></option>
						
						<%
					  	}
						%>
						
						
					</aui:select> --%>
	    </aui:col>
	    <aui:col span="6">
	    			<%-- <aui:select name="Status" label="Status" id="status">
					 <option value="" selected>All Status</option>
						
						<aui:option value="Daily">Daily</aui:option>
						<aui:option value="Weakly">Weakly</aui:option>
						<aui:option value="Monthly">Monthly</aui:option>
						<aui:option value="Yearly">Yearly</aui:option>
						
					</aui:select> --%>
	    </aui:col>
	   
	</aui:row>
</aui:form>
<liferay-ui:search-container delta="4"
				emptyResultsMessage="No record found."
				iteratorURL="<%=iteratorUrl%>" orderByCol="" orderByType="">
				<liferay-ui:search-container-results>
					<%
					results = ExpEntryList;
					total = ExpEntryList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("wrkSchedules", ExpEntryList);
			
		%>
				</liferay-ui:search-container-results>

				<liferay-ui:search-container-row
					className="com.liferay.famocom.erpcloud.model.ExpenseEntry"
					modelVar="entry">
					   
					<liferay-ui:search-container-column-text name="date"
						orderable="true" orderableProperty="employeeCode">
						<%
						Date tempEntyDate = entry.getExpDate();
						//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM,yyyy");
						String entryDate = formatter.format(tempEntyDate);
						
						%>
						<%=entryDate%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Project"
						orderable="true" orderableProperty="employeeName">
						<%
						ProjectMaster projectMaster=ProjectMasterLocalServiceUtil.getProjectMaster(entry.getProjectId());
						String proj=projectMaster.getProjectName();
						%>
						<%=proj%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="category"
						orderable="true" orderableProperty="fromDate">
						<%
						ExpCategory expCat=ExpCategoryLocalServiceUtil.getExpCategory(entry.getCatId());
						%>
						<%=expCat.getCategoryName()%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Title"
						orderable="true" orderableProperty="toDate">
						<%=entry.getTitle()%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Amount"
						orderable="true" orderableProperty="workSchedules">
						<%=entry.getAmount()%>
					</liferay-ui:search-container-column-text> 
					<liferay-ui:search-container-column-text name="Status"
						orderable="true" orderableProperty="Status">
						<%
								if(entry.getStatus()==0){
								%>
								Pending for Approval
								<%
								}else if(entry.getStatus()==1){
								%>
								Approved by manager
								<%
								}else if(entry.getStatus()==2){
								%>
								Reject by manager
								<%}else if(entry.getStatus()==3){
									%>
									resubmit
									<%
								}else if(entry.getStatus()==4){
									%>
									pending for final approval
									<%
								}else if(entry.getStatus()==5){
									%>
									final approved
									<%
								}else if(entry.getStatus()==6){
									%>
									Reject by HR
									<%
								}
						         %>
						
					</liferay-ui:search-container-column-text> 
					 <liferay-ui:search-container-column-text name="Action" cssClass="actionCol">
						<liferay-ui:icon-menu markupView="lexicon">
							<%
							//myExpViewURL.setParameter("expenseId",String.valueOf(entry.getExpenseId()));
							myExpEditURL.setParameter("expenseId",String.valueOf(entry.getExpenseId()));
							myExpDeleteURL.setParameter("expenseId",String.valueOf(entry.getExpenseId()));
				             %>
				             <%-- <liferay-ui:icon url="<%=myExpViewURL.toString() %>"
								message="view" image="view" />  --%>
                             <%
                             	System.out.println("entry.getStatus()=============="+entry.getStatus());
                             	if(entry.getStatus()==0 || entry.getStatus()==6 || entry.getStatus()==2){
                             %>
							<liferay-ui:icon url="<%=myExpEditURL.toString() %>"
								message="edit" image="edit" />
							  <%
                             	}
                             if(entry.getStatus()==0){
							  %>	
							
							<liferay-ui:icon url="<%=myExpDeleteURL.toString() %>"
								message="delete" image="delete" />
							
							<%
                               }
							%>
							</liferay-ui:icon-menu>	
					</liferay-ui:search-container-column-text> 

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
			</liferay-ui:search-container>
			<div></div>
	<%
    	}
    }
	%>		
			