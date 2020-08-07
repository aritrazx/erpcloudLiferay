<%@page import="com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpenseEntry"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%
System.out.println("================================== history ===============================");

SimpleDateFormat formatter11 = new SimpleDateFormat("dd-MMM,yyyy");

%>
<liferay-ui:search-container delta="4"
				emptyResultsMessage="No record found."
				iteratorURL="${iteratorUrl}" orderByCol="" orderByType="">
				<liferay-ui:search-container-results>
					<%
					results = expenseHistoryList;
					total = expenseHistoryList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("wrkSchedules", expenseHistoryList);
			
		%>
				</liferay-ui:search-container-results>

				<liferay-ui:search-container-row
					className="com.liferay.famocom.erpcloud.model.ExpenseEntryHistory"
					modelVar="entryHistory">
					
					<%
					
					String expenseTitle = StringPool.BLANK;
					String userName = StringPool.BLANK;
					String userFirstName = StringPool.BLANK;
					String userLastName = StringPool.BLANK;
					String userMiddleName = StringPool.BLANK;
					double ammount = 0;
					
					ExpenseEntry exp = ExpenseEntryLocalServiceUtil.getExpenseEntry(entryHistory.getExpenseId());
					if(Validator.isNotNull(exp)){
						expenseTitle = Validator.isNotNull(exp.getTitle())?exp.getTitle(): StringPool.BLANK;
						User users = UserLocalServiceUtil.fetchUser(exp.getUserId());
						if(Validator.isNotNull(users)){
							userFirstName =Validator.isNotNull(users.getFirstName())?users.getFirstName(): StringPool.BLANK;
							userMiddleName =Validator.isNotNull(users.getMiddleName())?users.getMiddleName(): StringPool.BLANK;
							userLastName =Validator.isNotNull(users.getLastName())?users.getLastName(): StringPool.BLANK;
							
							userName = userFirstName +StringPool.SPACE+userMiddleName +StringPool.SPACE+userLastName;
						}
						
						ammount = exp.getAmount();
					}
					
					
					%>
					   
					<liferay-ui:search-container-column-text name="Date"
						orderable="true" orderableProperty="employeeCode">
						<%
						Date tempEntyDate = entryHistory.getAddeddate();
						//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM,yyyy");
						String entryDate = formatter11.format(tempEntyDate);
						
						%>
						<%=entryDate%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Expense Title"
						orderable="true" orderableProperty="employeeName">
						<%= expenseTitle%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Employee Name"
						orderable="true" orderableProperty="employeeName">
						<%=userName%>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="Amount"
						orderable="true" orderableProperty="ammount">
						<%=ammount%>
					</liferay-ui:search-container-column-text> 
					<liferay-ui:search-container-column-text name="Status"
						orderable="true" orderableProperty="Status">
						<%
								if(entryHistory.getStatus()==0){
								%>
								Pending for Approval
								<%
								}else if(entryHistory.getStatus()==1){
								%>
								Approved by manager
								<%
								}else if(entryHistory.getStatus()==2){
								%>
								Reject by manager
								<%}else if(entryHistory.getStatus()==3){
									%>
									resubmit
									<%
								}else if(entryHistory.getStatus()==4){
									%>
									pending for final approval
									<%
								}else if(entryHistory.getStatus()==5){
									%>
									final approved
									<%
								}else if(entryHistory.getStatus()==6){
									%>
									Reject by HR
									<%
								}
						         %>
						<%-- <%=entry.getStatus()%> --%>
					</liferay-ui:search-container-column-text> 
					

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
			</liferay-ui:search-container>