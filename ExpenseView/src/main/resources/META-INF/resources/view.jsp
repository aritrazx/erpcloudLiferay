<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.famocom.erpcloud.service.ExpenseLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Expense"%>
<%@page import="com.liferay.famocom.erpcloud.service.ExpenseEntryLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	long expenseId=101;
	Expense expense = ExpenseLocalServiceUtil.getExpense(expenseId);
	SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy");
	//String strDate = formatter.format(addDate);
	
%>

<portlet:actionURL name="interviewAdd" var="interviewAddURL" />
<aui:form name="interview" action="" method="post">
	<aui:row>
		<aui:col span="6">
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Project Name :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;">Project Name</b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Apply Date :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=formatter.format(expense.getCreateDate()) %></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Expence Date :</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"> <%=formatter.format(expense.getExpDate())%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Amount:</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"><%=expense.getAmount()%></b>
				</aui:col>
			</aui:row>
			
			</br><aui:row>
				<aui:col span="6">
					<label ><font size="4">Status:</label>
				</aui:col>
				<aui:col span="6">
					<b style=" color: #f48120;"><%=expense.getStatus()%></b>
				</aui:col>
			</aui:row>
			
			<aui:input name="remark" type="textarea" label="Remark" value=""></aui:input>
			<aui:input name="approved" type="radio"  label="Approved"  />
			<aui:input name="approved" type="radio"  label="Reject"  />

		</aui:col>
		<aui:col span="6">
			<%-- <%
			 getRecruit.
			%> --%>
		</aui:col>

	</aui:row>
<aui:button name="save" type="submit"></aui:button>
</aui:form>