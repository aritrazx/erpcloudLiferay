<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.JobOpeningLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.JobOpening"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.CandidateApplyLocalService"%>
<%@page import="com.liferay.famocom.erpcloud.model.CandidateApply"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="init.jsp" %>



<%
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	List<CandidateApply> candidateApply = new ArrayList<>();
	String searchList=ParamUtil.get(renderRequest,"searchList",StringPool.BLANK);
	if (!searchList.isEmpty() ){
		candidateApply=(List<CandidateApply>)request.getAttribute("searchList");
	}else{
		candidateApply=CandidateApplyLocalServiceUtil.getCandidateApplies(-1,-1);
	}
	PortletURL viewDetailsURL = renderResponse.createRenderURL();
	viewDetailsURL.setParameter("jspPage", "/META-INF/resources/detailsView.jsp");
	
	PortletURL interviewSetURL = renderResponse.createRenderURL();
	interviewSetURL.setParameter("jspPage", "/META-INF/resources/interviewSet.jsp");
	
	PortletURL interviewListURL = renderResponse.createRenderURL();
	interviewListURL.setParameter("jspPage", "/META-INF/resources/interviewList.jsp");
	
	PortletURL candidateSearchUrl=renderResponse.createRenderURL();
	candidateSearchUrl.setWindowState(LiferayWindowState.EXCLUSIVE);
	candidateSearchUrl.setParameter("jspPage", "/META-INF/resources/candidateSearch.jsp");
	
%>

<portlet:resourceURL var="getSkillSet">
	<portlet:param name="<%=Constants.CMD%>" value="getSkillSets" />
</portlet:resourceURL>


<script type="text/javascript">
	function searchCandidate(){
		var name = $("#<portlet:namespace/>name").val();
		var skillset = $("#<portlet:namespace/>skillset").val();
		var email = $("#<portlet:namespace/>email").val();
		var yearExp = $("#<portlet:namespace/>yearExp").val();
		var monthExp = $("#<portlet:namespace/>monthExp").val();
		/* alert(name);
		alert(skillset);
		alert(email);
		alert(yearExp);
		alert(monthExp); */
		var url ='<%=candidateSearchUrl.toString()%>';
		//alert(url);
		jQuery.ajax({
			url : url,
			data : {
				'<portlet:namespace/>name' : name,
				'<portlet:namespace/>skillset' : skillset,
				'<portlet:namespace/>email' : email,
				'<portlet:namespace/>yearExp' : yearExp,
				'<portlet:namespace/>monthExp' : monthExp
			},
			success : function(result) {
				console.log(result);
				jQuery('#searchContainerResult').html(result);
			},
			error : function() {
				jQuery('#searchContainerResult').html('No Result Found');
			},
			type : 'POST'
		});
		
		
	}
</script>

<aui:form name="candidateSearch"
	action="<%=candidateSearchUrl.toString() %>" method="post">
	<aui:row>
		<aui:col span="12">
			<div class="row">
				<div class="col-md-3">
					<aui:input type="text" name="name" id="name" placeholder="Name"
						value="" label="Name">
						<aui:validator name="custom"
							errorMessage="Only Alphabets are allowed">
                        function (val, fieldNode, ruleValue)
                           {
                               var result = true;
                               var pattern=/[^a-z|^A-Z|^\s]/;
                              var check = val.match(pattern);
                              if(check!=null)
                             {
                                result=false;
                              }
                              val=$.trim(val);
                             $("#<portlet:namespace />name").val(val);
                          return result;
                            }
                </aui:validator>
					</aui:input>
				</div>
				<div class="col-md-3">
					<aui:input type="text" name="Skillset" id="skillset"
						placeholder="skillset" value="" label="Skill Set">
						
					</aui:input>
				</div>
				<div class="col-md-2">
					<aui:input type="text" name="Email" id="email" placeholder="Email"
						value="" label="Email">
						<aui:validator name="email"></aui:validator>
					</aui:input>
				</div>
				<div class="col-md-2">
					<aui:input type="text" name="yearExp" id="yearExp" value=""
						label="Year of Experience" placeholder="Year of Experience">
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</div>
				<div class="col-md-2">
					<aui:input type="text" name="monthExp" id="monthExp" value=""
						label="Month Of Experience" placeholder="Month Of Experience">
						<aui:validator name="max">11</aui:validator>
					</aui:input>
				</div>
			</div>
			<aui:button type="button" onClick="javascript:searchCandidate();"
				id="save" name="Search" value="Search"></aui:button>
		</aui:col>
	</aui:row>
</aui:form>

<div id="searchContainerResult">
	<liferay-ui:search-container delta="7"
		emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
		orderByCol="" orderByType="">
		<liferay-ui:search-container-results>
			<%
			results = candidateApply;
			total = results.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
			results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
			portletSession.setAttribute("wrkSchedules", results);
		%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.famocom.erpcloud.model.CandidateApply"
			modelVar="candidate">


			<liferay-ui:search-container-column-text name="Full Name"
				orderable="true" orderableProperty="fullName">
				<%=candidate.getFirstName()+" "+candidate.getLastName()%>
			</liferay-ui:search-container-column-text>
			<%
			JobOpening jobOpeningObj = null;
			String jobFor=StringPool.BLANK;
			if(Validator.isNotNull(candidate.getJobOpeningId())){
				jobOpeningObj = JobOpeningLocalServiceUtil.getJobOpening(candidate.getJobOpeningId());
				jobFor=jobOpeningObj.getOpeningFor();
			}
		%>
			<liferay-ui:search-container-column-text name="Appling For"
				orderable="true" orderableProperty="applingFor">

				<%=jobFor%>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Skills"
				orderable="true" orderableProperty="skills">
				<%=candidate.getSkillset()%>
			</liferay-ui:search-container-column-text>
			<%
			String yearEx=StringPool.BLANK;
			if(candidate.getYearOfExp()!=0){
				yearEx= candidate.getYearOfExp()+"."+candidate.getMonthOfExp()+"year";
			}else if(candidate.getMonthOfExp()!=0){
				yearEx=candidate.getMonthOfExp()+"months";
			}
		%>
			<liferay-ui:search-container-column-text name="Experience"
				orderable="true" orderableProperty="experience">
				<%=yearEx%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Email Address"
				orderable="true" orderableProperty="emailAddress">
				<%=candidate.getEmailAddress()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Phone Number"
				orderable="true" orderableProperty="phNumber">
				<%=candidate.getPhoneNumber()%>
			</liferay-ui:search-container-column-text>
			<%
		FileEntry dlfile = null;
		String url = null;
		try{
			if (candidate != null &&  Validator.isNotNull(candidate.getCvFileId())) {
				dlfile = DLAppServiceUtil.getFileEntry(candidate.getCvFileId());
				Date date2 = new Date();
				Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds())
						* 1000);
				url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/" + dlfile.getFileName() + "/"
						+ dlfile.getUuid() + "?t=" + time2;
				
			}
		}catch(Exception e){
			
		}		
			if(url!=null){
		%>
			<liferay-ui:search-container-column-text name="View CV"
				orderable="true" orderableProperty="viewCv">
				<a href="<%=url.toString()%>" target="_blank"><b
					style="color: #ADD8E6; text-decoration: underline;">View Cv</b></a>
			</liferay-ui:search-container-column-text>
			<%
			}else{
		%>
			<liferay-ui:search-container-column-text name="View CV"
				orderable="true" orderableProperty="viewCv">
				<h3>Cv not found</h3>
			</liferay-ui:search-container-column-text>
			<%
			}
		%>
			<liferay-ui:search-container-column-text name="Action"
				cssClass="actionCol">

				<liferay-ui:icon-menu>
					<%
				viewDetailsURL.setParameter("applyCandidateId",
											String.valueOf(candidate.getApplyCandidateId()));
				viewDetailsURL.setParameter("yearEx",yearEx);
				viewDetailsURL.setParameter("url",url);
				
				interviewSetURL.setParameter("applyCandidateId",
						String.valueOf(candidate.getApplyCandidateId()));
				%>

					<liferay-ui:icon url="<%=viewDetailsURL.toString() %>"
						message="View Details" image="view" />
					<liferay-ui:icon url="<%=interviewSetURL.toString() %>"
						message="Set Interview" image="" icon="plus" />
					<liferay-ui:icon url="<%=interviewListURL.toString() %>"
						message="Interview List" image="view">
					</liferay-ui:icon>

				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator></liferay-ui:search-iterator>
	</liferay-ui:search-container>
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
			}}
			});
			myAjaxRequest.start();
			return testData;},
		});
	});
</aui:script>