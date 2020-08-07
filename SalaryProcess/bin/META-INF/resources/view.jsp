<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.famocom.erpcloud.service.StopPayLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.StopPay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.MonthlyAdjustment"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ include file="init.jsp"%>
<title>Multistep Registration Form</title>
<!--including css file here--->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
<!--including Javascript file here--->
<script type ="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>


<%
if(themeDisplay.isSignedIn()){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<Integer> yearList = new ArrayList<Integer>();
		
		for(int j=0;j<=5;j++){
			yearList.add(year+j);
		}
   PortletURL popUpPage = renderResponse.createRenderURL();
   popUpPage.setParameter("jspPage", "/META-INF/resources/monthlyAdjustmentPopUp.jsp");
   popUpPage.setWindowState(LiferayWindowState.POP_UP);
  

%>
<portlet:resourceURL id="getMonthlyAndStopPaySalaryProcessCount" var="getMonthlyAndStopPaySalaryProcessCountURL">
	<portlet:param name="<%=Constants.CMD %>" value="getMonthlyAndStopPaySalaryProcessCount" />
</portlet:resourceURL>
<portlet:resourceURL id="salaryProcess" var="salaryProcessURL">
	<portlet:param name="<%=Constants.CMD %>" value="salaryProcess" />
</portlet:resourceURL>

<div class="content">
<!-- multistep form -->
<div class="main">
<form class="regform" action="" method ="get">
 <!-- progressbar -->
 <ul id="progressbar">
 <li id="active1">Select year and month</li>
 <li id="active2">Salary Adjustment Details</li>
 <li id="active3">Salary Process</li>
 </ul>
 <!-- fieldsets -->
 <fieldset id="first">
 <h2 class="title">Select year and month</h2>
 <p class="subtitle">Step 1</p>
 <label >Month<span class="mandatory" >* </span></label>
 <aui:select name="month" label="" id="month" >
		<aui:option value="">select</aui:option>
		<aui:option value="1">Jan</aui:option>
		<aui:option value="2">Feb</aui:option>
		<aui:option value="3">March</aui:option>
		<aui:option value="4">April</aui:option>
		<aui:option value="5">May</aui:option>
		<aui:option value="6">June</aui:option>
		<aui:option value="7">July</aui:option>
		<aui:option value="8">August</aui:option>
		<aui:option value="9">Sept</aui:option>
		<aui:option value="10">Oct</aui:option>
		<aui:option value="11">Nov</aui:option>
		<aui:option value="12">Dec</aui:option>
	</aui:select>
	<div id="errMonth" class="control-group error err" > 
	   			<div class="help-inline">
	   			<font color="red"> 	Please select Month! </font>
	   			</div>
	   		</div>
 <label >Year<span class="mandatory" >* </span></label>
	<aui:select name="year"  label="" >
		<aui:option value="">select</aui:option>
		<%  	 Iterator it= yearList.iterator();
				 while(it.hasNext()){
				 Object yr = it.next();
		%>
		<aui:option value="<%=yr.toString() %>"><%=yr.toString() %></aui:option>
		<%	 
		 } 
		 %>
	</aui:select>
	<div id="errYear" class="control-group error err" > 
	   			<div class="help-inline">
	   			<font color="red"> 	Please select Year!</font>
	   			</div>
	   		</div>
	   		<br/>
 <input type="button" id="next_btn1" value="Next" onclick="next_step1()" />
 </fieldset>
 <fieldset id="second">
 <h2 class="title">Salary Adjustment Details</h2>
 <p class="subtitle">Step 2</p>
 <%  
  
 %>
  <div id="salDetails" ></div>  
 
 
 <br/>
 <input type="button" id="pre_btn1" value="Previous" onclick="prev_step1()"/>
 <input type="button" name="next" id="next_btn2" value="Next" onclick="next_step2()" />
 </fieldset>
 <fieldset id="third">
 <h2 class="title">Salary Process</h2>
 <p class="subtitle">Step 3</p>
 <div id ="finalDetails"> 
 </div>
 <div id="myProgress">
  <div id="myBar" ></div>
</div>
 
 <br/>
  <aui:input type="checkbox" name="finalProcess" label="Final Process" id="finalProcess"/> 
 <input type="button" id="pre_btn2" value="Previous" onclick="prev_step2()"/>
 <input type="button"  value="Process" onclick="createProcessbar()" />
 </fieldset>
</form>
</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	/* $('#errMonth').hide();
	$('#errYear').hide(); */
	 document.getElementById("myBar").style.display="none";
});


function next_step1(){
 
    var month = $('#<portlet:namespace/>month').find("option:selected").val();
	var year = $('#<portlet:namespace/>year').find("option:selected").val();
	if(month!="" ){
		if(year!=""){
	 	var popUpPage = '<%=popUpPage.toString()%>'; 
	 	popUpPage = popUpPage+"&<portlet:namespace/>month="+month+"&<portlet:namespace/>year="+year;
	 	var popupview = "javascript:popupview('"+ popUpPage.toString()+"');";
	//popupview +="?month="+month+"&year="+year;
 $.ajax({
		type:'post',
		url: '<%=getMonthlyAndStopPaySalaryProcessCountURL.toString()%>',
							data : {
								'<portlet:namespace/>month' : month,
								'<portlet:namespace/>year' : year
							},
							async : false,
							success : function(result) {
								var d = JSON.parse(result);
								var details = "Total no. of Employee salary adjustment is :- "
										+ d.adjustments;
								if (d.adjustments > 0) {
									details += "&nbsp;&nbsp; <a href="
											+ popupview.toString()
											+ " >View </a>";
								}

								details += "</br>Total no. of Employee pay stop is:- "
										+ d.stopPaylist
										+ "<br/>Total no. of employee's salary process :- "
										+ d.salaryProcessCount;

								$("#salDetails").html(details);
							},
							error : function() {
								// $("#typeSubmit").hide();
								//$("#<portlet:namespace/>list").html(list);

							}
						});
				document.getElementById("first").style.display = "none";
				document.getElementById("second").style.display = "block";
				document.getElementById("active2").style.color = "red";
				document.getElementById("errYear").style.display = "none";
				document.getElementById("errMonth").style.display = "none";
			} else {
				document.getElementById("errYear").style.display = "block";
				document.getElementById("errMonth").style.display = "none";
				return false;
			}
		} else if(year != "") {
			document.getElementById("errYear").style.display = "none";
			document.getElementById("errMonth").style.display = "block";
			return false;
		} else {
			document.getElementById("errYear").style.display = "block";
			document.getElementById("errMonth").style.display = "block";
			return false;

		}
	}

	function next_step2() {
		document.getElementById("second").style.display = "none";
		document.getElementById("third").style.display = "block";
		document.getElementById("active3").style.color = "red";
		var month = $('#<portlet:namespace/>month').find("option:selected")
				.val();
		var year = $('#<portlet:namespace/>year').find("option:selected").val();
		var months = new Array('January', 'February', 'March', 'April', 'May',
				'June', 'July', 'August', 'September', 'October', 'November',
				'December');
		details = "Salary process for the month of " + months[month - 1] + " "
				+ year;

		$("#finalDetails").html(details);
	}

	function createProcessbar() {
		document.getElementById("myBar").style.display = "block";
		var elem = document.getElementById("myBar");
		var width = 10;
		var id = setInterval(frame, 10);
		function frame() {
			if (width >= 100) {
				clearInterval(id);
			} else {
				width++;
				elem.style.width = width + '%';
				elem.innerHTML = width * 1 + '%';
			}
		}
		var month = $('#<portlet:namespace/>month').find("option:selected")
				.val();
		var year = $('#<portlet:namespace/>year').find("option:selected").val();
		var finalProcess = $('#<portlet:namespace/>finalProcess')
				.is(":checked");
		//alert(finalProcess);
		$.ajax({
			type : 'post',
			url : '<%=salaryProcessURL.toString()%>',				
		data: {'<portlet:namespace/>month':month,'<portlet:namespace/>year':year,'<portlet:namespace/>finalProcess':finalProcess},
		async: false,
		success: function(result) {
			//var d = JSON.parse(result);	
			
		},
		error: function() {
	   // $("#typeSubmit").hide();
		//$("#<portlet:namespace/>list").html(list);
		
		}
	});
 
}	 


function popupview(url) {
	Liferay.Util.openWindow(

	{

		dialog : {

			//cssClass: 'aui-popup-example',

			destroyOnHide : true,

			height : 500,

			width : 900

		},

		dialogIframe : {

		//bodyCssClass: 'custom-css-class'

		},

		title : 'View Monthly Adjustment',

		uri : url

	}

	);

}
</script>
<style>
.err{
display:none;
}
.mandatory{
	color: red;
	font-size: 22px;
	padding: 3px;
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
	<%}else{ %>
<div class="control-group no-margin">
	  <label class="control-label"> Please Sign In 	  </label>  
 </div>
<%} %>