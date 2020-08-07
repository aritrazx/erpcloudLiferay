

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="Payroll.constants.PayrollPortletKeys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>






<%
	List<PayComponent> payComponents = new ArrayList<PayComponent>();
    payComponents = PayComponentLocalServiceUtil.getPayComponents(-1, -1);
    
    PortletURL ediPayComponent = renderResponse.createRenderURL();
    ediPayComponent.setParameter("jspPage", "/view.jsp");

    PortletURL iterateUrl = renderResponse.createRenderURL();
    iterateUrl.setParameter("jspPage", "/payComponentList.jsp");
    PortletURL backURL = renderResponse.createRenderURL();
    backURL.setParameter("jspPage","/view.jsp"); 
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    PortletURL deleteUrl = renderResponse.createActionURL();
    deleteUrl.setParameter("javax.portlet.action", "deletePayComponent");
%>



<liferay-ui:header title="Back" backLabel="Back" backURL="<%=backURL.toString()%>" />
<liferay-ui:search-container delta="10" emptyResultsMessage="There is no pay component" iteratorURL="<%=iterateUrl %>" >

<liferay-ui:search-container-results>
    <%
      results = payComponents;
      total = results.size();
      searchContainer.setTotal(total);
      pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
      pageContext.setAttribute("total",results.size());
      pageContext.setAttribute("delta", results.size());
    
    %>
</liferay-ui:search-container-results>
<liferay-ui:search-container-row className="com.liferay.famocom.erpcloud.model.PayComponent" modelVar="payComponent">
	<%
	  String payType = StringPool.BLANK;
	  String componentType = StringPool.BLANK;
	  if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Deduction)){
		  payType = PayrollPortletKeys.DEDUCTION;
	  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Earning)){
		  payType = PayrollPortletKeys.EARNING;
	  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Overtime)){
		  payType = PayrollPortletKeys.OVERTIME;
	  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Reimbursement)){
		  payType = PayrollPortletKeys.REIMBURSEMENT;
	  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.StatutoryComponent)){
		  payType = PayrollPortletKeys.STATUTORYCOMPONENT;
	  }
	  if(payComponent.getTaxStatus()==0){
		  componentType = PayrollPortletKeys.nonTaxable;
	  }else if(payComponent.getTaxStatus()==1){
		  componentType = PayrollPortletKeys.Taxable;
	  }
	%>
<liferay-ui:search-container-column-text name="Name" > <%=payComponent.getName() %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Abbreviation" > <%=payComponent.getAbbreviation() %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Pay Type" > <%=payType%></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Component Type" > <%=componentType %></liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="Effective Date" > <%=sdf.format(payComponent.getEffectiveDate()) %></liferay-ui:search-container-column-text>

<liferay-ui:search-container-column-text name="" cssClass="actionCol">
			<%
			ediPayComponent.setParameter("payComponentId", String.valueOf(payComponent.getComponentId()));
			deleteUrl.setParameter("payComponentId", String.valueOf(payComponent.getComponentId()));
			%>
			<liferay-ui:icon-menu markupView="lexicon"> 
				<liferay-ui:icon url="<%=ediPayComponent.toString()%>" 
					message="Edit" image="edit" />
					<%if(payComponent.getIslock()==0){ %>
				 <liferay-ui:icon url="<%=deleteUrl.toString()%>"
					message="Delete" image="Delete" /> 
					<%} %>
			 </liferay-ui:icon-menu> 
		</liferay-ui:search-container-column-text>


</liferay-ui:search-container-row>

	<liferay-ui:search-iterator/>


</liferay-ui:search-container>