<%@page import="com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.IncomeTaxSlab"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%@ taglib uri="http://liferay.com/tld/frontend"
prefix="liferay-frontend"%>

<%
PortletURL addTaxSlabURL = renderResponse.createRenderURL();
addTaxSlabURL.setParameter("jspPage", "/addTaxSlab.jsp");
List<IncomeTaxSlab> incomeTaxSlabs = IncomeTaxSlabLocalServiceUtil.getIncomeTaxSlabs(-1, -1);

PortletURL iterateUrl = renderResponse.createRenderURL();
iterateUrl.setParameter("jspPage", "/taxSlabList.jsp");
PortletURL editTaxSlabURL = renderResponse.createRenderURL();
editTaxSlabURL.setParameter("jspPage", "/addTaxSlab.jsp");
PortletURL deleteTaxSlabURL = renderResponse.createActionURL();
deleteTaxSlabURL.setParameter("javax.portlet.action", "deleteTaxSlab");
%>



<liferay-ui:search-container delta="10" emptyResultsMessage="There is no Income Tax Slab" iteratorURL="<%=iterateUrl %>" >

<liferay-ui:search-container-results>
    <%
      results = incomeTaxSlabs;
      total = results.size();
      searchContainer.setTotal(total);
      pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
      pageContext.setAttribute("total",results.size());
      pageContext.setAttribute("delta", results.size());
    
    %>
</liferay-ui:search-container-results>
<liferay-ui:search-container-row className="com.liferay.famocom.erpcloud.model.IncomeTaxSlab" modelVar="taxSlab">
	
<liferay-ui:search-container-column-text name="Financial Year" > <%=taxSlab.getFinancialYear() %></liferay-ui:search-container-column-text>

<liferay-ui:search-container-column-text name="Income From" > <%=taxSlab.getIncomeFrom() %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Income To" > <%=taxSlab.getIncomeTo() %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Tax Rate" > <%=taxSlab.getTaxRate() %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="" cssClass="actionCol">
			<%
			 editTaxSlabURL.setParameter("incomeTaxSlabId", String.valueOf(taxSlab.getIncomeTaxSlabId()));
			deleteTaxSlabURL.setParameter("incomeTaxSlabId", String.valueOf(taxSlab.getIncomeTaxSlabId())); 
			%>
			<liferay-ui:icon-menu markupView="lexicon"> 
				<liferay-ui:icon url="<%=editTaxSlabURL.toString()%>" 
					message="Edit" image="edit" />
				 <liferay-ui:icon url="<%=deleteTaxSlabURL.toString()%>"
					message="Delete" image="Delete" /> 
				
			 </liferay-ui:icon-menu> 
		</liferay-ui:search-container-column-text>
</liferay-ui:search-container-row>

	<liferay-ui:search-iterator/>


</liferay-ui:search-container>

<liferay-frontend:add-menu>
<liferay-frontend:add-menu-item
title='Add Tax Slab'
url="<%=addTaxSlabURL.toString()%>" />
</liferay-frontend:add-menu>
