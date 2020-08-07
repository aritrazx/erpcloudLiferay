<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.BranchLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="checkPage1"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/checkAvailability.jsp" />
</portlet:renderURL>

<portlet:renderURL var="checkEmpCode"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/checkEmpCode.jsp" />
</portlet:renderURL>

<portlet:renderURL var="checkPageemail"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/CheckEmail.jsp" />
</portlet:renderURL>

<script>
function checkAvailability(t){
	//alert("call");
	var url = '<%=checkPage1.toString()%>';
	var val=t;
		//alert(val);
	
	jQuery.ajax({
			url : url,
			data : {
				'<portlet:namespace/>textvalue' : val
			},
			success : function(result) {
				//alert("success");
				jQuery('#msgText').html(result);
				jQuery('#msgText').show();
			},
			error : function() {
				jQuery('#msgText').html('No Result Found');
			},
			type : 'POST'
		});
	}

	function checkEmpCode(t) {
		//alert("call");
		var url = '
<%=checkEmpCode.toString()%>';
	var val=t;
		//alert(val);
	jQuery.ajax({
	url: url,
	data:{
	'<portlet:namespace/>textvalue': val

	},
	success: function(result) {
		//alert("success");
	jQuery('#msgCode').html(result);
	jQuery('#msgCode').show();
	},
	error: function() { 
	jQuery('#msgCode').html('No Result Found'); 
	},
	type: 'POST'
	});
	}


function checkAvailabilityEmail(t){
	var url = '<%=checkPageemail.toString()%>';
		var val = t;
		jQuery.ajax({
			url : url,
			data : {
				'<portlet:namespace/>textvalue' : val
			},
			success : function(result) {
				jQuery('#msgEmail').html(result);
				jQuery('#msgEmail').show();
			},
			error : function() {
				jQuery('#msgEmail').html('No Result Found');
			},
			type : 'POST'
		});

	}

</script>

<%
	System.out.println("110");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String joiningDate = "";
	String birthDay = "";
	String anniversary = "";
	try{
	if (emp != null) {
		System.out.println("EMP:-yyyyyyyy");
		joiningDate = sdf.format(emp.getDateOfJoing());
		birthDay = sdf.format(emp.getDateOfBirth());
		if (maritalStatus.equalsIgnoreCase("Married")) {
			anniversary = sdf.format(emp.getAnniversary());
		}
	}
	}catch(Exception e){
		
	}
	
	
	FileEntry dlfile = null;
	String url = null;
	
	System.out.println("111");
	
	try{
		if (emp != null &&  Validator.isNotNull(emp.getPhotoId())) {
			dlfile = DLAppServiceUtil.getFileEntry(emp.getPhotoId());
			Date date2 = new Date();
			Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds())
					* 1000);
			url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
					+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/" + dlfile.getFileName() + "/"
					+ dlfile.getUuid() + "?t=" + time2;
			
			System.out.println("112");
		}
	}catch(Exception e){
		
	}

	
	List<EmployeeType> empType = EmployeeTypeLocalServiceUtil.getEmployeeTypes(-1,-1);
	
	List<Branch> branchName = BranchLocalServiceUtil.getBranchs(-1,-1);
	User user2=null;
	if(Validator.isNotNull(emp)){
	user2 = UserLocalServiceUtil.getUser(emp.getUserId());
	}
%>

<aui:row>
	<aui:col span="6">
		<label><h3>General Information</h3></label>
		<hr>

		<!-- for employee_code and date_of_joining -->
		<%
			if (!editURL) {
				
		%>
		<aui:row>
			<aui:col span="6">
				<aui:input id="UserName_id" name="userName" type="text" value="<%=emp != null ?user2.getScreenName(): ""%>"
					onChange="javascript:checkAvailability(this.value);"
					label="User Name">
					<aui:validator name="required"></aui:validator>
				</aui:input>
				<div id="msgText" class="inut-special-mention validator-error"
					style="display: none;">
					<input type="hidden" name="<portlet:namespace/>msgtxt1"
						id="<portlet:namespace/>msgtxt1" value="F">
				</div>
			</aui:col>
		</aui:row>
		<%
			}
		%>

		<aui:row>
			<aui:col span="6">
				<aui:input name="employeeCode"
					onChange="javascript:checkEmpCode(this.value);" type="text"
					value='<%=emp != null ? emp.getEmployeeCode() : ""%>'
					label="Employee Code">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="number"></aui:validator>
				</aui:input>
				<div id="msgCode" class="inut-special-mention validator-error"
					style="display: none;">
					<input type="hidden" name="<portlet:namespace/>msgtxt1"
						id="<portlet:namespace/>msgtxt1" value="F">
				</div>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" name="dateOfJoining" id="textDOJ"
					value="<%=emp != null ? joiningDate : ""%>" label="Date Of Joining"
					readonly="readonly">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>

		<!-- for first name -->
		<aui:input name="firstName" type="text"
			value="<%=emp != null ? emp.getFirstName() : ""%>"
			 label="First Name">
			 <aui:validator name="alpha"/>
			<aui:validator name="required"/>
		</aui:input>

		<!-- for last name -->
		<aui:input name="lastName" type="text"
			value="<%=emp != null ? emp.getLastName() : ""%>" required="required"
			label="Last Name">
			<aui:validator name="required"/>
			<aui:validator name="alpha"/>
		</aui:input>


		<%
			if (emp != null) {
		%>
		<aui:input id="files" type="file" name="employeePhoto"
			value="<%=emp.getEmployeePhoto()%>" label="Employee Photo" >
			</aui:input>
		<label>Recommended size 450 * 450</label>
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
				<%}
			} else { %>
		
		<p>
			<b> <aui:input id="files" type="file" name="employeePhoto"
					value="" label="Employee Photo" /> <label>Recommended size
					450 * 450</label><br /> <!-- <input type="file" id="files"/> --> <img
				id="image" width="90px" src="<%=renderRequest.getContextPath()%>/default.jpg" />
			</b>
		</p>
		<%
			}
		%>

		<br />



		<!-- for Designation and date_of_birth -->
		<aui:row>
			<aui:col span="6">
				<aui:input name="designation" type="text"
					value='<%=emp != null ? emp.getDesignation() : ""%>'
					required="required" label=" Designation">
					<aui:validator name="required"/>
					<aui:validator name="alpha"></aui:validator>
				</aui:input>
			</aui:col>

			<aui:col span="6">
				<aui:input type="text" name="dateOfBirth" id="textDOB"
					value="<%=emp != null ? birthDay : ""%>" label="Date Of Birth"
					readonly="readonly">
					<aui:validator name="required"/>
				</aui:input>
			</aui:col>
		</aui:row>
		
		<!--Employee Type and Branch  -->
		
		<aui:row>
			<aui:col span="6">
				<aui:select name="employeeType"
				label="Employee Type" id="employeeType" value="">
				<%
					for (EmployeeType empTypeList:empType) {
							if(emp!=null){			
				 %>
				<aui:option value="<%=empTypeList.getEmployeetypeId()%>" selected="<%=empTypeList.getEmployeetypeId()==emp.getEmployeetypeId() %>"><%=empTypeList.getTypeName()%></aui:option>
				<%}else{
				%> 
						<aui:option value="<%=empTypeList.getEmployeetypeId()%>"><%=empTypeList.getTypeName()%></aui:option>
						
						<%
						}
					}
				%>
				
			</aui:select>
			</aui:col>

			<aui:col span="6">
				<aui:select name="branchId"
				label="Branch Name" id="branchId" value="">
				<%
					for (Branch branchList:branchName) {
							if(emp!=null){			
				 %>
				<aui:option value="<%=branchList.getBranchId()%>" selected="<%=branchList.getBranchId()==emp.getBranchId()%>"><%=branchList.getBranchName()%></aui:option>
				<%}else{
				%> 
						<aui:option value="<%=branchList.getBranchId()%>"><%=branchList.getBranchName()%></aui:option>
						
						<%
						}
					}
				%>
				
			</aui:select>
			</aui:col>
		</aui:row>


		<!-- for Gender-->
		<aui:select name="gender"
			value="<%=emp != null ? emp.getGender() : ""%>">
			<aui:option value="Male">Male</aui:option>
			<aui:option value="Female">Female</aui:option>
			<aui:option value="Others">Others</aui:option>
		</aui:select>

		<!-- for Marital Status-->
		<aui:select name="maritalStatus" label="Marital Status"
			value="<%=emp != null ? emp.getMaritalStatus() : ""%>">
			<aui:option value="Single">Single</aui:option>
			<aui:option value="Married">Married</aui:option>
		</aui:select>

		<!-- Date of Anniversary  -->
		<div id="myDiv" class="aui-helper-hidden hide">
			<aui:input type="text" name="dateOfAnniversary" id="textDOA"
				value="<%=emp != null ? anniversary : ""%>"
				label="Date Of Anniversary" readonly="readonly">
			</aui:input>
			<!-- No of Child -->
			<aui:input name="noOfChild" type="text"
				value="<%=emp != null ? emp.getNoOfChild() : ""%>"
				label="No of Child"></aui:input>
		</div>

	</aui:col>

	<aui:col span="6">
		<label><h3>Contact Information</h3></label>
		<hr>
		<!-- for Address-->
		<aui:input name="address" type="textarea"
			value="<%=emp != null ? emp.getAddress() : ""%>" label="Address" />

		<!-- for State-->
		<aui:input name="state" type="text"
			value="<%=emp != null ? emp.getState() : ""%>" label="State" />

		<!-- for Post Code-->
		<aui:input name="postCode" type="text"
			value="<%=emp != null ? emp.getPostCode() : ""%>" label="Post Code">
			<aui:validator name="digits"></aui:validator>
		</aui:input>

		<!-- for Home Phone-->
		<aui:input name="homePhone" type="text"
			value="<%=emp != null ? emp.getHomePhone() : ""%>" label="Home Phone">
			<aui:validator name="digits"></aui:validator>
		</aui:input>

		<!-- for Mobile Number-->
		<aui:input name="mobileNumber" type="text"
			value="<%=emp != null ? emp.getMobileNumber() : ""%>" label="Mobile Number">
			<aui:validator name="digits"></aui:validator>
		</aui:input>

		<!-- for Email-->
		<aui:input name="email"
			onChange="javascript:checkAvailabilityEmail(this.value);" type="text"
			value="<%=emp != null ? emp.getEmaiAddress() : ""%>"
			required="required" label="Email(Company/Primary)">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<div id="msgEmail" class="inut-special-mention validator-error"
			style="display: none;">
			<input type="hidden" name="<portlet:namespace/>msgtxt1"
				id="<portlet:namespace/>msgtxt1" value="F">
		</div>
		<aui:input name="personalEmail"
			 type="text"
			value="<%=emp != null ? emp.getPesonalEmaiAddress() : ""%>"
			required="required" label="Email(Personal)">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="email"></aui:validator>
		</aui:input>
		<!-- for Note-->
		<aui:input name="note" type="textarea"
			value="<%=emp != null ? emp.getNote() : ""%>" label="Note" />
			
		

	</aui:col>
</aui:row>

<aui:script use="aui-base">
    var maritalStatus= A.one("#<portlet:namespace/>maritalStatus");
    maritalStatus.on(
        "change",
        function(event) {
        	maritalStatus.all("option:selected").each(
            function(node) {
                    var selected = node.val();

                    var myDiv = A.one('#myDiv');

                    if (selected == "Married") {
                        myDiv.show();
                    }
                    else {
                        myDiv.hide();
                    }
                }
           );
        }
   );
</aui:script>


<script>
//for date of joining
AUI().use('aui-datepicker', function(A) {
	var datepic=new A.DatePicker({
	trigger : '#<portlet:namespace/>textDOJ',
	mask : '%d/%m/%Y',

	popover : {
	toolbars: {
	header: [[
	             {
	               icon:'icon-trash',
	               label: 'Clear',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	                 }
	               }
	             },
	             {
	               icon:'icon-globe',
	               label: 'Today',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	               	 datepic.selectDates(new Date());
	                 }
	               }
	             }
	           ]]
	         },
	zIndex : 1000
	},

	nullableDay: true,
	nullableMonth: true,
	nullableYear: true,


	calendar: {
	     maximumDate:new Date()
	  }
	});
	});
	
	
	
	//for date of birth
	AUI().use('aui-datepicker', function(A) {
	var datepic=new A.DatePicker({
	trigger : '#<portlet:namespace/>textDOB',
	mask : '%d/%m/%Y',

	popover : {
	toolbars: {
	header: [[
	             {
	               icon:'icon-trash',
	               label: 'Clear',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	                 }
	               }
	             },
	             {
	               icon:'icon-globe',
	               label: 'Today',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	               	 datepic.selectDates(new Date());
	                 }
	               }
	             }
	           ]]
	         },
	zIndex : 1000
	},

	nullableDay: true,
	nullableMonth: true,
	nullableYear: true,


	calendar: {
	     maximumDate:new Date()
	  }
	});
	});
	
	
	//for date of Aniversary
	AUI().use('aui-datepicker', function(A) {
	var datepic=new A.DatePicker({
	trigger : '#<portlet:namespace/>textDOA',
	mask : '%d/%m/%Y',

	popover : {
	toolbars: {
	header: [[
	             {
	               icon:'icon-trash',
	               label: 'Clear',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	                 }
	               }
	             },
	             {
	               icon:'icon-globe',
	               label: 'Today',
	               on: {
	                 click: function() {
	               	 datepic.clearSelection();
	               	 datepic.selectDates(new Date());
	                 }
	               }
	             }
	           ]]
	         },
	zIndex : 1000
	},

	nullableDay: true,
	nullableMonth: true,
	nullableYear: true,


	calendar: {
	     maximumDate:new Date()
	  }
	});
	});
	

</script>


<script type="text/javascript">
document.getElementById("<portlet:namespace/>files").onchange = function () {
    var reader = new FileReader();

    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("image").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};
</script>
