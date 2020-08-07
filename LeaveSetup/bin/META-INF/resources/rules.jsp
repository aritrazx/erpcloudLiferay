<%@page import="com.liferay.famocom.erpcloud.model.LeaveManagement"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	List<EmployeeType> employeeTypelist = new ArrayList<>();
	employeeTypelist = EmployeeTypeLocalServiceUtil.getEmployeeTypes(-1, -1);
%>

<aui:row>
	<aui:col span="6">
		<aui:input name="minServiceDay" type="text"
			value="<%=leave != null ? leave.getMinServiceDay() : ""%>"
			label="Min. service period before leave can be applied (days)"
			placeholder="Days">
			<aui:validator name="required" />
			<aui:validator name="digits"></aui:validator>
		</aui:input>


		<aui:select name="employeetypeId" label="Applicability">
			<%
				for (EmployeeType employeeType : employeeTypelist) {
								if (leave != null) {
			%>
			<aui:option value="<%=employeeType.getEmployeetypeId()%>"
				selected="<%=employeeType.getEmployeetypeId() == leave.getEmployeetypeId()%>"><%=employeeType.getTypeName()%></aui:option>
			<%
				} else {
			%>
			<aui:option value="<%=employeeType.getEmployeetypeId()%>"><%=employeeType.getTypeName()%></aui:option>
			<%
				}
							}
			%>
		</aui:select>
		<aui:select name="gender">
		
			<%
				if (leave != null) {
			%>
			<option value="All"<%=(leave.getGender().equalsIgnoreCase("All")) ? "selected" : ""%>>All</option>
			<option value="Male"<%=(leave.getGender().equalsIgnoreCase("Male")) ? "selected" : ""%>>Male</option>
			<option value="Female"<%=(leave.getGender().equalsIgnoreCase("Female")) ? "selected" : ""%>>Female</option>
			<%
				} else {
			%>
			<option value="All">All</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<%
				}
			%>
		</aui:select>
		
		<%
			boolean ckeckBox = false;
			if(leave!=null && leave.getImpectOnSalary()==1){
				ckeckBox = true;
			}
		%>
		<aui:input name="impectOnSalary" label=" Impact on salary"
			type="checkbox" checked="<%=ckeckBox %>"
			value="<%=leave != null ? leave.getImpectOnSalary() : "1"%>">
		</aui:input>
	</aui:col>

	<aui:col span="6">
		<aui:input name="noticeDay" type="text"
			value="<%=leave != null ? leave.getNoticeDay() : ""%>"
			label="Notice for leave request (days)" placeholder="Days">
			<aui:validator name="required" />
			<aui:validator name="digits"></aui:validator>
		</aui:input>

		<aui:input name="maxCreditDay" type="text"
			value="<%=leave != null ? leave.getMaxCreditDay() : ""%>"
			label="No. of Max Day to Credit" placeholder="No. of Max Day">
			<aui:validator name="required" />
			<aui:validator name="max" errorMessage="Range Upto 365">365</aui:validator>

		</aui:input>

		<aui:select name="maritalStatus" label="Marital Status">
			<%
				if (leave != null) {
			%>
			<option value="All"
				<%=(leave.getMaritalStatus().equalsIgnoreCase("All")) ? "selected" : ""%>>All</option>
			<option value="Single"
				<%=(leave.getMaritalStatus().equalsIgnoreCase("Single")) ? "selected" : ""%>>Single</option>
			<option value="Married"
				<%=(leave.getMaritalStatus().equalsIgnoreCase("Married")) ? "selected" : ""%>>Married</option>
			<%
				} else {
			%>
			<option value="All">All</option>
			<option value="Single">Single</option>
			<option value="Married">Married</option>
			<%
				}
			%>
			<aui:validator name="required" />
		</aui:select>
	</aui:col>
</aui:row>
