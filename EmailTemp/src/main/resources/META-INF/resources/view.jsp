<%@page import="com.liferay.famocom.erpcloud.emailtemp.util.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmailTemplateLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmailTemplate"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="checkTemplateName"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/META-INF/resources/checkTemplateName.jsp" />
</portlet:renderURL>

<script type="text/javascript">

function checkTemplateName(t){
	//alert("call");
	var url = '<%=checkTemplateName.toString()%>';
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
<%
	boolean editURL = false;
	List<EmailTemplate> emailTemp = new ArrayList<EmailTemplate>();
	emailTemp = EmailTemplateLocalServiceUtil.getEmailTemplates(-1, -1);
	long id = ParamUtil.getLong(request, "id");
	EmailTemplate template = null;
	if (id != 0) {
		editURL = true;
		try {
			template = EmailTemplateLocalServiceUtil.getEmailTemplate(id);
			System.out.println("template:" + template);
		} catch (Exception e) {

		}
	}

	String templateName = ParamUtil.get(renderRequest, "templateName", StringPool.BLANK);
	String emailFor = ParamUtil.get(renderRequest, "emailFor", StringPool.BLANK);
	String templateBody = ParamUtil.get(renderRequest, "templateBody", StringPool.BLANK);
	String Action = ParamUtil.get(renderRequest, "action", StringPool.BLANK);
%>
<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL emailTempURL = renderResponse.createRenderURL();
	emailTempURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL emailTempRestoreURL = renderResponse.createActionURL();
	emailTempRestoreURL.setParameter("javax.portlet.action", "emailTempRestore");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	iteratorUrl.setParameter("templateName", templateName);
	iteratorUrl.setParameter("emailFor", emailFor);
	iteratorUrl.setParameter("templateBody", templateBody);
	emailTemp = EmailTemplateLocalServiceUtil.getEmailTemplates(-1, -1);
%>

<%-- <%
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");
	
	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("asc")) {
	orderByType = "asc";
	} else {
	orderByType = "desc";
	}
	
	if (Validator.isNull(orderByType)) {
	orderByType = "asc";
	} 
	/* if (Validator.isNull(orderByCol)) {
	orderByCol = "goal_name";
	} */
%> --%>

<portlet:actionURL name="emailTempAdd" var="emailTempAddURL" />
<portlet:actionURL name="emailTempEdit" var="emailTempEditURL" />
<aui:form name="email"
	action="<%=editURL != true ? emailTempAddURL.toString() : emailTempEditURL.toString()%>"
	method="post">
	<aui:input name="id" type="hidden" value="<%=id%>" />

	<aui:input name="templateName" type="text"
		onChange="javascript:checkTemplateName(this.value);"
		value="<%=template != null ? template.getTemplateName() : ""%>"
		label="Template Name" placeholder="Template Name">
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
	                   $("#<portlet:namespace />leaveName").val(val);
	                return result;
	                  }
	       </aui:validator>
	</aui:input>


	<aui:input name="emailFor" type="text"
		value="<%=template != null ? template.getEmailFor() : ""%>"
		label="Email For" toolbarSet="slimmed" placeholder="Email For" disabled="<%=template != null ? true : false%>">
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
	                   $("#<portlet:namespace />leaveName").val(val);
	                return result;
	                  }
	       </aui:validator>
	</aui:input>


	<liferay-ui:input-editor name="templateBody"
		initMethod="getquestionText"></liferay-ui:input-editor>
	<input name="<portlet:namespace />htmlCodeFromEditorPlacedHere"
		type="hidden" value="" />

	<aui:button name="save" type="submit" value="save"></aui:button>
</aui:form>
<%
//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("asc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	 if (Validator.isNull(orderByType)) {
		orderByType = "asc";
	} 
	 /* if (Validator.isNull(orderByCol)) {
		 orderByCol = "goal_name";
		} */
	 System.out.println("orderByCol..." + orderByCol);
	 System.out.println("orderByType..." + orderByType);
	 List<EmailTemplate> tsSortList = new ArrayList<>();
	 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
	 tsSortList = ListUtil.copy(emailTemp);
	 
	 ListUtil.sort(tsSortList, orderByComparator);
%>
<liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = tsSortList;
			total = tsSortList.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
					results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
			portletSession.setAttribute("empType", results); 
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.EmailTemplate"
		modelVar="type">


		<liferay-ui:search-container-column-text name="Template Name"
			orderable="true" orderableProperty="templateName">
			<%=type.getTemplateName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Email For"
			orderable="true" orderableProperty="emailFor">
			<%=type.getEmailFor()%>

		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="status">
			<%=type.getStatus() == true ? "Active" : "Inactive"%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Action"
			cssClass="">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					emailTempURL.setParameter("id", String.valueOf(type.getId()));

					emailTempRestoreURL.setParameter("id", String.valueOf(type.getId()));
				%>

				<liferay-ui:icon url="<%=emailTempURL.toString()%>" message="edit"
					image="edit" />
				<liferay-ui:icon-delete url="<%=emailTempRestoreURL.toString()%>" confirmation="Are you sure want to restore?"
					message="Restore" image="undo"  />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator ></liferay-ui:search-iterator>
</liferay-ui:search-container>

<script>
<%if (Validator.isNotNull(template)) {%>
function <portlet:namespace />getquestionText() {
return "<%=UnicodeFormatter.toString(template.getTemplateBody())%>";
	}
<%}%>
	
</script>
<style>
	.actionCol{
		width: "10px";
	}
</style>