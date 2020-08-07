<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.famocom.erpcloud.service.ProjectMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ProjectMaster"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.BillingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Billing"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	PortletURL billingViewURL = renderResponse.createRenderURL();
	billingViewURL.setParameter("jspPage", "/META-INF/resources/billingView.jsp");
	PortletURL uploadBillURL = renderResponse.createRenderURL();
	uploadBillURL.setParameter("jspPage", "/META-INF/resources/uploadBill.jsp");
	

	List<Billing > billingObj = BillingLocalServiceUtil.getBillings(-1,-1);
%>

<liferay-ui:search-container delta="3"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = billingObj;
			total = results.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
			results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
			portletSession.setAttribute("wrkSchedules", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Billing"
		modelVar="billing">

		<%
			String projectName=StringPool.BLANK;
			Milestone milestone=null;
			if(Validator.isNotNull(billing.getMilestoneId())){
				try{
					milestone = MilestoneLocalServiceUtil.getMilestone(billing.getMilestoneId());
					ProjectMaster pm = ProjectMasterLocalServiceUtil.getProjectMaster(milestone.getProjectId());
					projectName = pm.getProjectName();
					
				}catch(Exception e){
					
				}
			}
		%>
		<liferay-ui:search-container-column-text name="Project Name"
			orderable="true" orderableProperty="projectName">
			<%=projectName%>
		</liferay-ui:search-container-column-text>
		
		<%
			String clientName=null;
			if(Validator.isNotNull(milestone.getClientId())){
				try{
					ClientMaster cm = ClientMasterLocalServiceUtil.getClientMaster(milestone.getClientId());
					clientName=cm.getClientName();
				}catch(Exception e){
					
				}
			}
		%>
		
		<liferay-ui:search-container-column-text
			name="Client Name" orderable="true"
			orderableProperty="clientName">
			<%=clientName%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Milestone Name"   orderable="true" orderableProperty="milestoneName">
				<%=milestone.getMilestoneName()%>
		</liferay-ui:search-container-column-text>
		
		<%
					Date date = milestone.getDueDate();
					SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
					String dueDate = formatter.format(date);
		%>

		<liferay-ui:search-container-column-text name="Due Date"
			orderable="true" orderableProperty="dueDate">
			<%=dueDate%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Amount"
			orderable="true" orderableProperty="amount">
			<%=milestone.getAmount()%>
		</liferay-ui:search-container-column-text>
		<%
			String status=null;
			if(milestone.getStatus()==0){
				//System.out.println("AAAA");
				status="Pending";
			}else if(milestone.getStatus()==1){
				status="Bill Raise";
			}else if(milestone.getStatus()==2){
				status="Bill Uploaded";
			}
		%>
		<liferay-ui:search-container-column-text name="Status"   orderable="true" orderableProperty="status">
				<%=status%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu>
				<%
					
					billingViewURL.setParameter("billingId",
					String.valueOf(billing.getBillingId()));
					billingViewURL.setParameter("milestoneId",
					String.valueOf(milestone.getMilestoneId()));
					billingViewURL.setParameter("projectName",
							projectName);
					billingViewURL.setParameter("clientName",
							clientName);
					billingViewURL.setParameter("dueDate",
							dueDate);
					billingViewURL.setParameter("amount",
							String.valueOf(milestone.getAmount()));
					billingViewURL.setParameter("status",
							status);
					billingViewURL.setParameter("clientId",
							String.valueOf(milestone.getClientId()));
					uploadBillURL.setParameter("billingId", String.valueOf(billing.getBillingId()));
					uploadBillURL.setParameter("milestoneId",String.valueOf(milestone.getMilestoneId()));
					
					/* assignURL.setParameter("milestoneId", String.valueOf(milestone.getMilestoneId()));
				    //String	assignUrl = assignURL + "?milestoneId="+milestone.getMilestoneId();
				    
					String popup = "javascript:popup('" + assignURL + "');"; */
					/* billingViewURL.setParameter("billingId",
						String.valueOf(billing.getBillingId()));
					billingViewURL.setParameter("billingId",
						String.valueOf(billing.getBillingId())); */
							/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
									/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
				%>

				<liferay-ui:icon url="<%=billingViewURL.toString()%>"
					message="Show Bill" image="view" />
				<liferay-ui:icon url="<%=uploadBillURL.toString()%>"
					message="Upload Bill" image="add_drive"/>
				<%-- <%
					if(milestone.getStatus()==0){	
				%>	
				<liferay-ui:icon url="<%=popup.toString()%>"
					message="Raise Invoice" image="invoice" />
				<%} %> --%>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>