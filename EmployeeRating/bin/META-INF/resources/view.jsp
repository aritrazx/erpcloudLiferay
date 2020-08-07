<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1,-1);
%>

<%-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script src="/js/Bootstrap/Select/bootstrap-select.js"></script>

<script type="text/javascript">
    $('.selectpicker').selectpicker({
      });
</script>

	<aui:select listType="true" class="selectpicker" data-live-search="true" name="" >
				<%
					for (int i = 0; i < empList.size(); i++) {
										

							//System.out.println("isSelect" + isSelect);
				%>
				<option value="<%=empList.get(i).getEmployeeId()%>"><%=empList.get(i).getFirstName()+" "+empList.get(i).getLastName()%></option>

				<%	
					
					}
				%>
	</aui:select> --%>
	
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.js"></script>
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css" rel="stylesheet" />
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" /> -->
	
	<script type="text/javascript">
	    $('.selectpicker').selectpicker({
	      });
	</script>

<select data-live-search="true" class="selectpicker">
    <option value="4444">4444</option>
    <option value="Fedex">Fedex</option>
    <option value="Elite">Elite</option>
    <option value="Interp">Interp</option>
    <option value="Test">Test</option>
    
</select>
	
	
	
	
<%-- <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</style>
</head>
<body>

<!-- <h2>Search/Filter Dropdown</h2>
<p>Click on the button to open the dropdown menu, and use the input field to search for a specific dropdown link.</p> -->

<div class="dropdown">
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
</div>

<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
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

</body>
</html>
 --%>