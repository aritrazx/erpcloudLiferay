<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.famocom.erpcloud.service.EvaluationLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Evaluation"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.security.KeyStore.Entry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<script	src="/documents/20143/0/jquery.min.js/e7a8ce76-ceff-6fa0-9a18-a9b1468929f7"></script>
<liferay-ui:error key="error" message="Please give some rating!"></liferay-ui:error>
<!-- <link rel="stylesheet" href="/documents/20143/136001/bootstrap.min.css/ab5e9a1d-998e-08ac-85ef-def8cae75d46">
    <link rel="stylesheet" href="/documents/20143/136001/bootstrap-select.css/7fdd4974-15e0-66ed-b6d3-f86650063fce" />
    <script src="/documents/20143/136001/jquery.min.js/0fe33851-393a-86bb-b7d6-3170a9e2b439"></script>
    <script src="/documents/20143/136001/bootstrap.min.js/36244191-92af-aee1-834f-e6cf8b046758"></script>
    <script src="/documents/20143/136001/bootstrap-select.js/254ff4e2-95c0-e9de-2a19-f496f04a38af"></script>
     <script src="/documents/20143/136001/aui-min.js/a7065455-fbda-c2a9-6ffb-7968eaf5dbda"></script>
     <link rel="stylesheet" href="/documents/20143/136001/bootstrap.min.css/ab5e9a1d-998e-08ac-85ef-def8cae75d46"> -->
<%
	boolean editURL = false;
	String selectEmployee = ParamUtil.getString(renderRequest, "selectEmployee", StringPool.BLANK);
	long evaluationId = ParamUtil.getLong(request, "evaluationId");
	int rating = ParamUtil.getInteger(request, "rating", 0);
	String val = ParamUtil.getString(request, "search", StringPool.BLANK);
	System.out.println("val....." + val);
	ThemeDisplay td =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
	long userId = td.getUserId();
	Employee emp = EmployeeLocalServiceUtil.findByemployees(userId);
	long employeeId = emp.getEmployeeId();
	List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
	Criterion criterion3 = null;
	criterion3 = RestrictionsFactoryUtil.ne("employeeId", employeeId);
	dynamicQuery.add(criterion3);
	empList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
	/* long entryId = ParamUtil.getLong(renderRequest, "entryId");
	Entry entry = EntryLocalServiceUtil.getEntry(entryId); */
	Evaluation eval = null;
	if (evaluationId != 0) {
		editURL = true;
		try {
			eval = EvaluationLocalServiceUtil.getEvaluation(evaluationId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	/* PortletURL evaluationListURL = renderResponse.createRenderURL();
	evaluationListURL.setWindowState(LiferayWindowState.NORMAL);
	evaluationListURL.setParameter("jspPage", "/META-INF/resources/view.jsp"); */
%>
<%-- <aui:row>
	<aui:col span="9">
	</aui:col>
	<aui:col span="3">
		<aui:button name="button" type="button" value="Evaluation List"
			cssClass="btn btn-success" href="<%=evaluationListURL.toString()%>"></aui:button>
	</aui:col>
</aui:row> --%>

<portlet:actionURL name="evaluation" var="evaluationURL" />
<portlet:actionURL name="updateEvaluation"
	var="updateEvaluationURL" />
<aui:form name="evaluation"
	action="<%=editURL!=true?evaluationURL.toString():updateEvaluationURL.toString()%>"
	method="post">
	<aui:input name="evaluationId" type="hidden" value="<%=evaluationId%>"></aui:input>
	<aui:row>
	<aui:col span="6">
	<aui:select cssClass="selectpicker" name="selectEmployee" label="Select Employee" required="true" data-live-search="true">
		<option value="">Select Employee</option>
		<%-- <option value="<%=val%>"></option> --%>
		<%
			try {
						for (Employee obj : empList) {
							String isSelect = null;
							if(!selectEmployee.isEmpty()){
							if(obj.getEmployeeId()==Long.parseLong(selectEmployee)){
							isSelect="selected";
							}
							}
		%>
		<option value="<%=obj.getEmployeeId()%>" <%=isSelect %>><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
			<%=obj.getLastName()%></option>


		<%
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		%>

		<%-- <option value="<%=pm != null ? pm.getEmployee_id() : ""%>"></option> --%>
	</aui:select> 
	</aui:col>
	<!-- <select data-live-search="true" class="selectpicker">
    <option value="4444">4444</option>
    <option value="Fedex">Fedex</option>
    <option value="Elite">Elite</option>
    <option value="Interp">Interp</option>
    <option value="Test">Test</option>
</select> -->
<%-- <div class="dropdown">
<button onclick="myFunction()" class="dropbtn">Employee List</button>
  <div id="myDropdown" class="dropdown-content">
    <input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">
    	<%
					for (int i = 0; i < empList.size(); i++) {
										

							//System.out.println("isSelect" + isSelect);
				%>
				
				<a href="#<%=empList.get(i).getEmployeeId()%>"><%=empList.get(i).getFirstName()+" "+empList.get(i).getLastName()%></a>

				<%	
					
					}
				%>
    <!-- <a href="#about">About</a>
    <a href="#base">Base</a>
    <a href="#blog">Blog</a>
    <a href="#contact">Contact</a>
    <a href="#custom">Custom</a>
    <a href="#support">Support</a>
    <a href="#tools">Tools</a> -->
  </div>
</div> --%>
	<aui:col span="6">
	<aui:input name="evalMessage" type="textarea"
		label="Evaluation Message" placeholder="Evaluation Message"
		value="<%=eval != null ? eval.getEvalMessage(): ""%>" >
		<aui:validator name="required"></aui:validator>
		<aui:validator name="alphanum"></aui:validator>
		</aui:input>
	</aui:col>
	</aui:row>
	<%
		String strDate = null;
			if (eval != null) {
				Date addDate = eval.getEvalDate();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				strDate = formatter.format(addDate);
			} else {
				strDate = "";
			}
	%>
	<aui:row>
	<aui:col span="6">
	<aui:input id="txtToDate_id" name="evalDate" type="text"
		label="Evaluation Date" placeholder="Evaluation Date" readonly="readonly" 
		value="<%=strDate%>" >
		<aui:validator name="required"></aui:validator>
		</aui:input>
		</aui:col>
	<aui:col span="6">
	<div class="txt_label" style="padding-top: 8px;">Give Your Rating<span class="required"></span>:</div>
			<div class="taglib-ratings-wrapper field">
				<div class="taglib-ratings stars">
					<div
						class="liferay-rating-vote yui3-widget component rating rating-focused">
						<div class="rating-content">
							<div class="rating-label">Your Rating</div>
							<a class="rating-element icon-star-empty" id="1" data-value="1" href="javascript:;"></a>
							<a class="rating-element icon-star-empty" id="2" data-value="2" href="javascript:;"></a>
							<a class="rating-element icon-star-empty" id="3" data-value="3" href="javascript:;"></a>
							<a class="rating-element icon-star-empty" id="4" data-value="4" href="javascript:;"></a>
							<a class="rating-element icon-star-empty" id="5" data-value="5" href="javascript:;"></a>
						</div>
				<input type="hidden" id="selectRating"
					name="<portlet:namespace/>rating" title=""
					value="<%=eval != null ? eval.getEvalRating() : "0"%>"/>
			</div>
				</div>
			</div>
			</aui:col>
		</aui:row>
			</br>

	<aui:button name="button" type="submit" value="submit"></aui:button>
</aui:form>
<script>
	AUI().use('aui-datepicker', function(A) {
		var dfg = new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate_id',
			mask : '%d/%m/%Y',

			popover : {
				zIndex : 1000
			},
			calendar : {
				maximumDate : new Date()
			}
		});
	});
</script>
<style>
.field .form-group {width : 100% !important;}
.taglib-ratings.stars .liferay-rating-score{display:none !important;}
.rating-label{display:none !important;}
.rating-element{font-size: 20px !important;}
/* a.rating-element:hover, a.rating-element:focus{color: #337ab7 !important;} */
.liferay-rating-vote{float: right !important;}
</style>

<script>
$( document ).ready(function() {
	//$("a.rating-element").removeClass("icon-star");
	//$("a.rating-element").addClass("icon-star-empty");
	
	/* $("a.rating-element").each(function(){
		
		var rating = $(this).attr('id');
		alert(rating);
		if(rating==1) {
			
			$(this).addClass("icon-star-sankha");
		}
		
	}); */
	 <%
	if(eval!=null){
	%>
		var val = <%=eval.getEvalRating()%>
			$("a.rating-element").each(function(){
				for(i=0;i<=val;i++){
					//$(this).removeClass("icon-star-empty");
					$('#'+(i)).removeClass("icon-star-empty");
					$('#'+(i)).addClass("icon-star");
					
			}
		});
	<%
	}
	%> 
	/* $("a.rating-element").click(function(){
		$("a.rating-element").removeClass("selected");
		$( this ).addClass("selected");
		$( this ).prevAll().addClass("selected");
	});  */
	$("a.rating-element").click(function(){
		//alert("call");
		$("a.rating-element").removeClass("icon-star");
		$("a.rating-element").removeClass("icon-star-empty");
		$(this).addClass("icon-star");
		$(this).prevAll().addClass("icon-star");
		$(this).nextAll().addClass("icon-star-empty");
		var thisProp = $(this).data('value');
		$('#selectRating').val(thisProp);
		//alert(thisProp);
		//$("rating-label").removeClass("icon-star");
		//$("rating-input-container").removeClass("icon-star");
		//$(this).prevAll().removeClass("icon-star-empty");
		
	}); 
	
	
		
	
	
});

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}

</script> 
<style>
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
    background-color: #3e8e41;
}

#myInput {
    border-box: box-sizing;
    background-image: url('searchicon.png');
    background-position: 14px 12px;
    background-repeat: no-repeat;
    font-size: 16px;
    padding: 14px 20px 12px 45px;
    border: none;
    border-bottom: 1px solid #ddd;
}

#myInput:focus {outline: 3px solid #ddd;}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f6f6f6;
    min-width: 230px;
    overflow: auto;
    border: 1px solid #ddd;
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {background-color: #ddd}

.show {display:block;}
.rating-content{
padding-right: 300px;
}

</style>