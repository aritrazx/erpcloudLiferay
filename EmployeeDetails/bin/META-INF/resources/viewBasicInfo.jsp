<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.BranchLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Branch"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	FileEntry dlfile = null;
	String url=null; 
	try{
		if (emp != null &&  Validator.isNotNull(emp.getPhotoId())) {		
			dlfile = DLAppServiceUtil.getFileEntry(emp.getPhotoId());
			 Date date2 = new Date(); 
			Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes())* 60 ) + date2.getSeconds()) * 1000);
			/* System.out.println("time2.."+time2); */
			url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
				dlfile.getFolderId() +  "/" +dlfile.getFileName() +  "/" +dlfile.getUuid()+"?t="+time2 ;
		}
	}catch(Exception e){
		
	}
	%>
	
	<%
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String joiningDate="";
	 String birthDay="";
	 /*String anniversary=""; */
	if(emp!=null){
		 System.out.println("EMP:-yyyyyyyy");
		 joiningDate = sdf.format(emp.getDateOfJoing());
		  birthDay = sdf.format(emp.getDateOfBirth());
		 /* if(maritalStatus.equalsIgnoreCase("Married")){
		 	anniversary = sdf.format( emp.getAnniversary());
		 }  */
	}
%>

<aui:row>
 <aui:col span="6">
	<label><h3>General Information</h3></label>
	<hr>
	<%-- <p>
		User Name :
		<b style=" color: #f48120;"><%=%></b>
	</p> --%>
	<p>
		Employee Code : <b style="color: #f48120;"><%=emp.getEmployeeCode()%></b>
	</p></br>
	<p>
		Date of joining : <b style="color: #f48120;"><%=emp!=null?joiningDate :"" %></b>
	</p></br>
	<p>
		First Name : <b style="color: #f48120;"><%=emp.getFirstName()%></b>
	</p></br>
	<p>
		Last Name : <b style="color: #f48120;"><%=emp.getLastName()%></b>
	</p></br>
	<p>
		Designation : <b style="color: #f48120;"><%= emp.getDesignation()%></b>
	</p></br>
	<p>
		Date Of Birth : <b style="color: #f48120;"><%=emp!=null? birthDay:"" %></b>
	</p></br>
	<%
		EmployeeType empType = EmployeeTypeLocalServiceUtil.getEmployeeType(emp.getEmployeetypeId());
		Branch branchName = null;
		if(Validator.isNotNull(emp.getBranchId())){
			branchName = BranchLocalServiceUtil.getBranch(emp.getBranchId());
		}
	%>
	
	<p>
		Employee Type : <b style="color: #f48120;"><%=empType.getTypeName() %></b>
	</p></br>
	<p>
		Branch Name : <b style="color: #f48120;"><%=branchName!=null? branchName.getBranchName() : ""%></b>
	</p></br>
	<p>
		Gender : <b style="color: #f48120;"><%=emp.getGender()%></b>
	</p></br>
	<p>
		MaritalStatus : <b style="color: #f48120;"><%=emp!=null? emp.getMaritalStatus():""%></b>
	</p></br>

</aui:col> 
<aui:col span="6">
	<label><h3>Contact Information</h3></label>
	<hr>
	<p>
		Address: <b style="color: #f48120;"><%=emp.getAddress()%></b>
	</p></br>
	<p>
		State: <b style="color: #f48120;"><%= emp.getState()%></b>
	</p></br>
	<p>
		Post Code: <b style="color: #f48120;"><%= emp.getPostCode()%></b>
	</p></br>
	<p>
		Home Phone: <b style="color: #f48120;"><%= emp.getHomePhone()%></b>
	</p></br>
	<p>
		Mobile Number: <b style="color: #f48120;"><%=emp.getMobileNumber()%></b>
	</p></br>
	<p>
		Email: <b style="color: #f48120;"><%=emp.getEmaiAddress()%></b>
	</p></br>
	<p>
		Note: <b style="color: #f48120;"><%=emp.getNote()%></b>
	</p></br>
	<p>
		<%if (dlfile != null) { %>
				<p>
					<b> <img width="90px" id="image" alt="pro_pic" src="<%=url%>">
					</b>
				</p>
			<%}else{ %>
				<p>
					<b>
				<img witdh="90px" height="90px" id="image"  src="<%=renderRequest.getContextPath()%>/default.jpg"/>
					</b>
				</p>
		<%}%>
	</p>
</aui:col> 
</aui:row>