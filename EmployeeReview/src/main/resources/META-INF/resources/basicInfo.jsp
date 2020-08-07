<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />



<aui:row>
<aui:col span="6">


	<aui:row>
	<aui:col span="6">
		<label><h3>General Information</h3></label>
		<hr>
		
	</aui:col>
	</aui:row>		


	<aui:row>
	<aui:col span="6">
		<aui:input label="Employee Code" disabled="true" name="employeeCode" type="text" value="${empDetails.employeeCode}" >
		</aui:input>
	</aui:col>
	<%-- <fmt:formatDate value="${empDetails.dateOfJoing}"  
           type="date" 
           pattern="dd/MM/yyyy"
           var="fmtdateOfjoing" /> --%>
	<aui:col span="6">
		Date Of Joining:</br> <fmt:formatDate type = "date" 
         value = "${empDetails.dateOfJoing}" />
        <%--  <aui:input label="Date Of Joininge" disabled="true" name="dateOfJoining" id="datepicker" type="text" value="${joiningDate}"  > --%>
	</aui:col>
	</aui:row>
	
	<aui:input label="First Name" disabled="true" name="firstName" type="text" value="${empDetails.firstName}">
	<aui:validator name="required"></aui:validator>
	<aui:validator name="alpha"></aui:validator>
	</aui:input>	
	<aui:input label="Last Name" disabled="true" name="lastName" type="text" value="${empDetails.lastName}">
	<aui:validator name="required"></aui:validator>
	<aui:validator name="alpha"></aui:validator>
	</aui:input>	
	
	<aui:row>
		
	
	<label>Recommended size 450 * 450</label>
		<p>
			<b> <img width="90px" id="image" alt="pro_pic" src="${imgURL}">
			</b>
		</p>
	</aui:row>
	
	<aui:row>
	<aui:col span="6">
		<aui:input label="Designation" disabled="true" name="designation" type="text" value="${empDetails.designation}" >
		<aui:validator name="required"></aui:validator>
		</aui:input>
	</aui:col>
	<%-- <fmt:formatDate value="${empDetails.dateOfBirth}"  
                type="date" 
                pattern="dd/MM/yyyy"
                var="fmtDateOfbirth" /> --%>
	<aui:col span="6">
		Date Of Birth:</br> <fmt:formatDate type = "date" 
         value = "${empDetails.dateOfBirth}" />
	</aui:col>
	</aui:row>	
	
	<aui:select name="gender" disabled="true">
		<aui:option value="Male">Male</aui:option>
		<aui:option value="Female">Female</aui:option>
	</aui:select>
	
	<aui:select name="maritalStatus" disabled="true">
		<aui:option value="Single">Single</aui:option>
		<aui:option value="Married">Married</aui:option>
	</aui:select>
	
	<aui:select label="Employee Type" disabled="true" name="employeetype">
		<c:forEach items="${empType}" var="empType">
			<aui:option value="${empType.employeetypeId}" selected="${empType.employeetypeId==empDetails.employeetypeId ? true : false }"><c:out value="${empType.typeName}"/></aui:option>
		</c:forEach>
		</aui:select>
</aui:col>
<aui:col span="6">
		<label><h3>Contact Information</h3></label>
		<hr>
		<aui:input label="Address" disabled="true" name="address" type="textarea" value="${empDetails.address}"></aui:input>
		<aui:input label="Post Code" disabled="true" name="postCode" type="text" value="${empDetails.postCode}"></aui:input>
		<aui:input label="Home Phone" disabled="true" name="homePhone" type="text" value="${empDetails.homePhone}"></aui:input>
		<aui:input label="Mobile Number" disabled="true" name="mobileNumber" type="text" value="${empDetails.mobileNumber}"></aui:input>
		<aui:input label="email" disabled="true" name="email" type="text" value="${empDetails.emaiAddress}">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="email"></aui:validator>
		</aui:input>
		<aui:input label="note" disabled="true" name="note" type="textarea" value="${empDetails.note}"></aui:input>
</aui:col>
</aui:row>

<script>
AUI().use('aui-datepicker', function(A) {
	var dfg=new A.DatePicker({
		trigger : '#<portlet:namespace />datepicker',
		mask : '%d/%m/%Y',

	popover : {
		zIndex : 1000
	}, calendar: {
      
   		}
	});
});


document.getElementById("<portlet:namespace/>employeePhoto").onchange = function () {
    var reader = new FileReader();

    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("image").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};

</script>
