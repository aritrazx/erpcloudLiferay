<%@page import="com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpenseEntry"%>
<%@page import="com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpCategory"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
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
<%@ include file="/init.jsp" %>



<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM,yyyy");
    

    List<ExpCategory> expCatList= new ArrayList<>();
    DynamicQuery expQuery = ExpenseEntryLocalServiceUtil.dynamicQuery();
    expQuery.add(PropertyFactoryUtil.forName("status").eq(1));
    expCatList = ExpenseEntryLocalServiceUtil.dynamicQuery(expQuery);
    //expCatList=ExpCategoryLocalServiceUtil.getExpCategories(-1,-1);
    
	PortletURL expenseEntryUrl = renderResponse.createRenderURL();
    expenseEntryUrl.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");

    List<ExpenseEntry> ExpEntryList = new ArrayList<>();
    ExpEntryList = ExpenseEntryLocalServiceUtil.getExpenseEntries(-1, -1);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/viewAccList.jsp");
	
	PortletURL myExpEditURL = renderResponse.createRenderURL();
	myExpEditURL.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
	
	PortletURL accountantApprovalURL = renderResponse.createRenderURL();
	accountantApprovalURL.setParameter("jspPage", "/META-INF/resources/viewForAccApproval.jsp");
	
	PortletURL myExpViewURL = renderResponse.createRenderURL();
	myExpViewURL.setParameter("jspPage", "/META-INF/resources/expenseEntry.jsp");
	myExpViewURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	
	
    PortletURL myExpDeleteURL = renderResponse.createActionURL();
    myExpDeleteURL.setParameter("javax.portlet.action", "myExpDelete");
    List<Role> userRoles = themeDisplay.getUser().getRoles();
    String roleName="";
    String roleName1="";
    for(Role r:userRoles){
    	roleName=r.getName();
    	System.out.println("userRoles"+r.getName());
  //  }
    /* for(int i=0;i<userRoles.size();i++){
    	//System.out.println("userRoles%%%%"+"name"+r.getName()+"roleid"+r.getRoleId());
    	
    		 roleName=userRoles.get(0).getName();
    		 System.out.println("roleName"+roleName);
    		 roleName1=userRoles.get(1).getName();
    		 System.out.println("roleName1"+roleName1);
    } */
     if(roleName.equalsIgnoreCase("HR")){
    
%>


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
						orderable="true" orderableProperty="Project">
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
						orderable="true" orderableProperty="workSchedules">
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
									rejected by HR
									<%
									}
						         %>
						         
						
					</liferay-ui:search-container-column-text> 
					 <liferay-ui:search-container-column-text name="Action" cssClass="actionCol">
						<liferay-ui:icon-menu markupView="lexicon">
							<%
							accountantApprovalURL.setParameter("expenseId",String.valueOf(entry.getExpenseId()));
							//myExpEditURL.setParameter("expenseId",String.valueOf(entry.getExpenseId()));
							//myExpDeleteURL.setParameter("expenseId",String.valueOf(entry.getExpenseId()));
				             %>
				             <liferay-ui:icon url="<%=accountantApprovalURL.toString() %>"
								message="view" image="view" /> 
                             			
							
							</liferay-ui:icon-menu>	
					</liferay-ui:search-container-column-text> 

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
			</liferay-ui:search-container>
			
			<%
               }
           }
			%>