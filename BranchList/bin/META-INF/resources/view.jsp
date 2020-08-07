<%@page import="com.liferay.famocom.erpcloud.service.BranchLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Branch"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="/init.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	List<Branch> branchList = new ArrayList<>();
	branchList = BranchLocalServiceUtil.getBranchs(-1, -1);
	
	PortletURL getEditUrl = renderResponse.createRenderURL();
	getEditUrl.setParameter("jspPage", "/branchAdd.jsp");
	
	PortletURL branchAddURL = renderResponse.createRenderURL();
	branchAddURL.setParameter("jspPage", "/branchAdd.jsp");
%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-frontend:add-menu>
   <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "Add Branch") %>' url="<%=branchAddURL.toString()%>" />
</liferay-frontend:add-menu>
	<liferay-ui:search-container delta="5"
		emptyResultsMessage="No record found." orderByCol="" orderByType="">
		<liferay-ui:search-container-results>
			<%
				results = branchList;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.famocom.erpcloud.model.Branch"
			modelVar="var">
			<liferay-ui:search-container-column-text name="Name">
				<%=var.getBranchName() %>
			</liferay-ui:search-container-column-text>
	
			<liferay-ui:search-container-column-text name="Address">
				<%=var.getBranchAddress()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Create Date">
				<%=var.getCreateDate()%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="" cssClass="actionCol">
		<liferay-ui:icon-menu markupView="lexicon" >
							<% 
								getEditUrl.setParameter("branchId",String.valueOf(var.getBranchId()));
							%>
							<liferay-ui:icon url="<%=getEditUrl.toString() %>"  label="Edit" message="Edit" image="edit"  />
						</liferay-ui:icon-menu> 
						</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
	</liferay-ui:search-container>