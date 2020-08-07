

<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="init.jsp" %>
<%
	int count=0;
	String Name="";
	String Skillset="";
	String Email="";
	String searchList=null;
	List<RecruitProcess> candidateList=new ArrayList<RecruitProcess>();
	List<RecruitProcess> tempCandidateList=new ArrayList<RecruitProcess>();
	searchList=ParamUtil.get(renderRequest,"searchList",StringPool.BLANK);
	System.out.println("searchList"+searchList);
	
	PortletURL addcandidateUrl = renderResponse.createRenderURL();
    addcandidateUrl.setParameter("jspPage", "/META-INF/resources/addCandidate.jsp");
    
    PortletURL iteratorURL=renderResponse.createRenderURL();
    iteratorURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
    
    PortletURL candidateViewURL=renderResponse.createRenderURL();
    candidateViewURL.setParameter("jspPage", "/META-INF/resources/candidateView.jsp");
    
    PortletURL candidateEditUrl=renderResponse.createRenderURL();
    candidateEditUrl.setParameter("jspPage", "/META-INF/resources/addCandidate.jsp");
    
    PortletURL candidateDeleteUrl=renderResponse.createActionURL();
    candidateDeleteUrl.setParameter("javax.portlet.action", "candidateDelete");
    
    PortletURL candidateSearchUrl=renderResponse.createActionURL();
    candidateSearchUrl.setParameter("javax.portlet.action", "candidateSearch");
  
    tempCandidateList=(List<RecruitProcess>)request.getAttribute("searchList");
   System.out.println("tempCandidateList size"+tempCandidateList);
   
%>
<portlet:resourceURL var="getSkillSet">
   <portlet:param name="<%=Constants.CMD%>" value="getSkillSets" />
</portlet:resourceURL>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item title='<%=LanguageUtil.get(request, "Add Candidate")%>'
url="<%=addcandidateUrl.toString()%>" />
</liferay-frontend:add-menu>
<div>
<div>
      <aui:form name="candidateSearch" action="<%=candidateSearchUrl.toString() %>"  method="post">
         <liferay-ui:panel-container extended="true" id="outerPanelContainerId" >
			<liferay-ui:panel collapsible="true" defaultState="open"  title="Candidate Search" >
	        <aui:row>
	            <aui:col span="2">
	             	<dl class="dropdown"> 
  
						    <dt>
						    <a href="#">
						      <span class="hida">Select</span>    
						      <p class="multiSel"></p>  
						    </a>
						    </dt>
						  
						    <dd>
						        <div class="mutliSelect">
						            <ul>
						                <li>
						                    <input type="checkbox" value="Name" />Name</li>
						                <li>
						                    <input type="checkbox" value="Skill Set" />Skill set</li>
						                <li>
						                    <input type="checkbox" value="Phone number" />HTC</li>
						                <li>
						                    <input type="checkbox" value="Sony Ericson" />Sony Ericson</li>
						                <li>
						                    <input type="checkbox" value="Motorola" />Motorola</li>
						                <li>
						                    <input type="checkbox" value="Nokia" />Nokia</li>
						            </ul>
						        </div>
						    </dd>
						  <button>Filter</button>
						</dl>  	
	            </aui:col>
	             <aui:col span="10">
	                 <liferay-ui:panel-container extended="true" id="outerPanelContainerId" >
					        <liferay-ui:panel collapsible="true" defaultState="collapsed"  title="Search Criteria" >
					           <div class="row">
                                  <div class="col-md-3">
					        	   <aui:input type="text" name="Name" id="NameId" placeholder="Name" value=""
					                  label="Name" >
					               </aui:input>
					               </div>
					               <div class="col-md-3">
					        	   <aui:input type="text" name="Skillset" id="skillset" placeholder="skillset" value=""
					                  label="Skill Set" >
					               </aui:input>
					               </div>
					                <div class="col-md-3">
					               <aui:input type="text" name="Email" id="Email" placeholder="Email" value=""
					                  label="Email" >
					               </aui:input>
					               </div>
					                <div class="col-md-3">
					               <aui:input type="text" name="experience" id="experience" placeholder="Experience" value=""
					                  label="Experience" >
					               </aui:input>
					               </div>
					             </div>  
					           <aui:button type="submit" id="save" name="Search" value="Search"></aui:button>
					        </liferay-ui:panel>
					 </liferay-ui:panel-container>       
	            </aui:col>
	        </aui:row>
           </liferay-ui:panel>
		</liferay-ui:panel-container>  
      </aui:form>
    <aui:row>
    </aui:row>
    </div>
    <div style="overflow-x: scroll;">
    <%
	    if( Validator.isNull(searchList.toString())){
		   
		    candidateList=RecruitProcessLocalServiceUtil.getRecruitProcesses(-1, -1);
	    }else{
	    	candidateList=tempCandidateList;
	    	
	    }
    
    
    %>
<liferay-ui:search-container delta="4"
				emptyResultsMessage="No record found."
				iteratorURL="<%=iteratorURL%>" orderByCol="" orderByType="">
				<liferay-ui:search-container-results>
					<%
					
					results = candidateList;			    
					total = candidateList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
				    pageContext.setAttribute("total", results.size());
				    pageContext.setAttribute("delta", results.size());
				    portletSession.setAttribute("projectListTemp", candidateList);
			
		%>
				</liferay-ui:search-container-results>

				<liferay-ui:search-container-row
					className="com.liferay.famocom.erpcloud.model.RecruitProcess"
					modelVar="candList">
					   
					<liferay-ui:search-container-column-text name="Sl No."
						orderable="" orderableProperty="">
						<%=
						++count
						
						%>
						
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Name"
						orderable="" orderableProperty="Project">
						
						<%=candList.getFirstName()+" "+ candList.getLastName()%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="skill Set"
						orderable="" orderableProperty="skillset">
						<%=candList.getSkillset()%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="E-mail"
						orderable="" orderableProperty="E-mail">
						<%=candList.getEmail()%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Phone No."
						orderable="" orderableProperty="Amount">
						<%=candList.getPhoneNumber()%>
					</liferay-ui:search-container-column-text> 
					<liferay-ui:search-container-column-text name="Experience"
						orderable="" orderableProperty="Experience">
						<%=candList.getExperience()%>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Notice Period"
						orderable="" orderableProperty="noticePeriod">
						<%=candList.getNoticePeriod() %>
					</liferay-ui:search-container-column-text>  
					 <liferay-ui:search-container-column-text name="Action" cssClass="actionCol">
						<liferay-ui:icon-menu>
							<%
							candidateViewURL.setParameter("recruitProcessId",String.valueOf(candList.getRecruitProcessId()));
							candidateEditUrl.setParameter("recruitProcessId",String.valueOf(candList.getRecruitProcessId()));
							candidateDeleteUrl.setParameter("recruitProcessId",String.valueOf(candList.getRecruitProcessId()));
				             %>
				           	<liferay-ui:icon url="<%=candidateViewURL.toString() %>"
								message="view" image="view" />
				           
							<liferay-ui:icon url="<%=candidateEditUrl.toString() %>"
								message="edit" image="edit" />
							 
							<liferay-ui:icon url="<%=candidateDeleteUrl.toString() %>"
								message="delete" image="delete" />
							
							
							</liferay-ui:icon-menu>	
					</liferay-ui:search-container-column-text> 

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator markupView="lexicon" ></liferay-ui:search-iterator>
			</liferay-ui:search-container>
</div>	
</div>		
<aui:script>
	AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
		var testData;
		
		new A.AutoCompleteList({
			
			allowBrowserAutocomplete: 'true',
			activateFirstItem: 'true',
			inputNode: '#<portlet:namespace />skillset',
			resultTextLocator:'skillname',
			render: 'true',
			resultHighlighter: 'phraseMatch',
			resultFilters:['phraseMatch'],
			queryDelimiter : ',',
	        typeAhead: true,
			source:function(){
			var inputValue=A.one("#<portlet:namespace />skillset").get('value');
			var myAjaxRequest=A.io.request('<%=getSkillSet.toString()%>',{
			dataType: 'json',
			method:'GET',
			data:{
			<portlet:namespace />skillset:inputValue,
			},
			autoLoad:false,
			sync:false,
			on: {
			success:function(responseData){
			var data=this.get('responseData');
			testData=data;
			//alert('testData'+data);
			}}
			});
			myAjaxRequest.start();
			return testData;},
		});
	});
</aui:script>
<script type="text/javascript">

var checkList = document.getElementById('list1');
checkList.getElementsByClassName('anchor')[0].onclick = function (evt) {
    if (checkList.classList.contains('visible'))
        checkList.classList.remove('visible');
    else
        checkList.classList.add('visible');
}

checkList.onblur = function(evt) {
    checkList.classList.remove('visible');
}
</script>
<script>
/*
Dropdown with Multiple checkbox select with jQuery - May 27, 2013
(c) 2013 @ElmahdiMahmoud
license: https://www.opensource.org/licenses/mit-license.php
*/

$(".dropdown dt a").on('click', function() {
$(".dropdown dd ul").slideToggle('fast');
});

$(".dropdown dd ul li a").on('click', function() {
$(".dropdown dd ul").hide();
});

function getSelectedValue(id) {
return $("#" + id).find("dt a span.value").html();
}

$(document).bind('click', function(e) {
var $clicked = $(e.target);
if (!$clicked.parents().hasClass("dropdown")) $(".dropdown dd ul").hide();
});

$('.mutliSelect input[type="checkbox"]').on('click', function() {

var title = $(this).closest('.mutliSelect').find('input[type="checkbox"]').val(),
title = $(this).val() + ",";

if ($(this).is(':checked')) {
var html = '<span title="' + title + '">' + title + '</span>';
$('.multiSel').append(html);
$(".hida").hide();
} else {
$('span[title="' + title + '"]').remove();
var ret = $(".hida");
$('.dropdown dt a').append(ret);

}
});
</script>
<style>
/* 	body {
  color: #fff;
  padding: 50px;
  width: 300px;
  margin: 0 auto;
  background-color: #374954;
} */

.dropdown {
  position: absolute;
  top:50%;
  transform: translateY(-50%);
}

a {
  color: #fff;
}

.dropdown dd,
.dropdown dt {
  margin: 0px;
  padding: 0px;
}

.dropdown ul {
  margin: -1px 0 0 0;
}

.dropdown dd {
  position: relative;
}

.dropdown a,
.dropdown a:visited {
  color: #fff;
  text-decoration: none;
  outline: none;
  font-size: 16px;
}

.dropdown dt a {
   background-color: #4F6877; 
  display: block;
  padding: 8px 20px 5px 10px;
  min-height: 25px;
  line-height: 24px;
  overflow: hidden;
  border: 0;
  width: 200px;
}

.dropdown dt a span,
.multiSel span {
  cursor: pointer;
  display: inline-block;
  padding: 0 3px 2px 0;
}

.dropdown dd ul {
   background-color: #4F6877; 
  border: 0;
  color: #fff;
  display: none;
  left: 0px;
  padding: 2px 15px 2px 5px;
  position: absolute;
  top: 2px;
  width: 280px;
  list-style: none;
  height: 100px;
  overflow: auto;
}

.dropdown span.value {
  display: none;
}

.dropdown dd ul li a {
  padding: 5px;
  display: block;
}

.dropdown dd ul li a:hover {
  background-color: #fff;
}

/* button {
  background-color: #6BBE92;
  width: 302px;
  border: 0;
  padding: 10px 0;
  margin: 5px 0;
  text-align: center;
  color: #fff;
  font-weight: bold;
} */
</style>