<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.ExpCategoryLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.ExpCategory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%-- <p>
	<b><liferay-ui:message key="ExpenseCategory.caption"/></b>
</p> --%>
<%
	List<ExpCategory> expCategoryList = new ArrayList<>();
	expCategoryList = ExpCategoryLocalServiceUtil.getExpCategories(-1, -1);

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL expCatEditURL = renderResponse.createRenderURL();
	expCatEditURL.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL expCategoryEditURL = renderResponse.createActionURL();
	expCategoryEditURL.setParameter("javax.portlet.action", "expCategoryEdit");
	
	PortletURL expCategoryDeleteURL = renderResponse.createActionURL();
	expCategoryDeleteURL.setParameter("javax.portlet.action", "expCategoryDelete");
	
	PayComponent payComponent=null;
	
	ExpCategory expCategory=null;
	boolean EditURL=false;
	long catId=0;
	catId=ParamUtil.getLong(request, "catId");
	System.out.println("catId###"+catId);
	if(catId!=0){
		EditURL=true;
		try{
		expCategory=ExpCategoryLocalServiceUtil.fetchExpCategory(catId);
		System.out.println("expCategory###"+expCategory);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//catId=0;
	
	      DynamicQuery PayCompQuery = PayComponentLocalServiceUtil.dynamicQuery()
	    	.add(RestrictionsFactoryUtil.eq("payType", "R"));
	      List<PayComponent> complist = PayComponentLocalServiceUtil.dynamicQuery(PayCompQuery);
	        System.out.println("complist###"+complist);


%>
<portlet:renderURL var="checkCategory"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage"
		value="/META-INF/resources/checkCategory.jsp" />
</portlet:renderURL>
<portlet:actionURL name="expCategoryAdd" var="expCategoryAddURL" />
<%-- <portlet:actionURL name="expCategoryEdit" var="expCategoryEditURL" />
<portlet:actionURL name="expCategoryDelete" var="expCategoryDeleteURL" /> --%>
<aui:form name="expCategory"
	action="<%=(EditURL)? expCategoryEditURL.toString() : expCategoryAddURL.toString() %>"
	method="post">
	<aui:input name="expCategory" type="hidden" value="<%=catId %>" />
		<aui:row span="12">
			<aui:col span="6">
				<aui:input type="text" name="Category_name" id="exp_cat_name"
					placeholder="Category name"
					value="<%=(expCategory!=null)?expCategory.getCategoryName():"" %>"
					label="Category name"
					onChange="javascript:checkCategory(this.value);">
					<aui:validator name="required"></aui:validator>
				</aui:input>
				<div id="msgCode" style="display: none;"></div>
			</aui:col>
			<aui:col span="6">
				<aui:select name="Frequency" label="Frequency" id="frequency">

					<%
					    			     
						  		if(expCategory!=null){
						  			
						  %>

					<option value="Daily"
						<%=(expCategory.getFrequency().equalsIgnoreCase("Daily"))?"selected":"" %>>Daily</option>
					<option value="Weekly"
						<%=(expCategory.getFrequency().equalsIgnoreCase("Weekly"))?"selected":""  %>>Weekly</option>

					<option value="Monthly"
						<%=(expCategory.getFrequency().equalsIgnoreCase("Monthly"))?"selected":"" %>>Monthly</option>
					<option value="yearly"
						<%=(expCategory.getFrequency().equalsIgnoreCase("Mobile"))?"selected":"" %>>yearly</option>
					<%
						  				}else{
					  					     
						%>
					<option value="Daily">Daily</option>
					<option value="Weekly">Weekly</option>

					<option value="Monthly">Monthly</option>
					<option value="yearly">yearly</option>

					<%
						  				}
						%>

				</aui:select>
			</aui:col>
		</aui:row>
		</br>
		<aui:row span="12">

			<aui:col span="6">

				<aui:select name="Affected_salary_head" label="Affected salary head"
					id="salhead">
					<option value="" selected>None</option>
					<%
						     for(PayComponent pcl:complist){
					     		if(expCategory!=null){
					     			
					     			System.out.println("complist###"+pcl.getComponentId()+"%%%%"+expCategory.getSalaryHead());			  				
					     %>
					<option value="<%=pcl.getComponentId() %>"
						selected="<%=pcl.getComponentId()==expCategory.getSalaryHead() %>"><%=pcl.getName() %></option>

					<%
					  		}else{
					    
						%>
					<option value="<%=pcl.getComponentId() %>"><%=pcl.getName() %></option>

					<%
					  		     }
						     }		
						%>

				</aui:select>
			</aui:col>
			<aui:col span="6">

			</aui:col>



		</aui:row>
		<aui:row span="12">
			<aui:col span="6">
				<aui:input name="attachmentRequired" label="Attachment Required"
					type="checkbox"
					value="<%=(expCategory!=null)?expCategory.getAttachment():"" %>" />
			</aui:col>
			<aui:col span="6">
				<aui:button type="submit" id="save" name="save"></aui:button>
				<button class="btn btn-danger" type="button" name="reset">Cancel</button>
			</aui:col>
		</aui:row>
	
</aui:form>
<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
					results = expCategoryList;
					total = expCategoryList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("wrkSchedules", expCategoryList);
			
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.ExpCategory"
		modelVar="type">

		<liferay-ui:search-container-column-text name="Expense Name"
			orderable="true" orderableProperty="employeeCode">
			<%=type.getCategoryName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Frequency"
			orderable="true" orderableProperty="employeeName">
			<%=type.getFrequency()%>
		</liferay-ui:search-container-column-text>
		<%
							payComponent=PayComponentLocalServiceUtil.getPayComponent(type.getSalaryHead());
						%>
		<liferay-ui:search-container-column-text name="Salary Head"
			orderable="true" orderableProperty="fromDate"
			value="<%=String.valueOf(payComponent.getName())%>">


		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Attachment"
			orderable="true" orderableProperty="toDate">
			<%=((type.getAttachment()==true)?"Required":"Not Required")%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text name="Final Approval"
						orderable="true" orderableProperty="workSchedules">
						<%=schedulerName.getSchedulesName()%>
					</liferay-ui:search-container-column-text> --%>

		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
							expCatEditURL.setParameter("catId",String.valueOf(type.getCatId()));
							expCategoryDeleteURL.setParameter("catId",String.valueOf(type.getCatId()));
				             %>

				<liferay-ui:icon url="<%=expCatEditURL.toString() %>" message="edit"
					image="edit" />

				<liferay-ui:icon url="<%=expCategoryDeleteURL.toString() %>"
					message="delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>
<script>
	function checkCategory(t){
		//alert("call");
		var url = '<%=checkCategory.toString()%>';
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
	
	
	</script>