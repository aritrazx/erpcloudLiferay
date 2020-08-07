<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.employeetype.util.CustomComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeTypeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.EmployeeType"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:success key="add-success"
	message="Employee Type added successfully"></liferay-ui:success>
<liferay-ui:success key="update-success"
	message="Employee Type updated successfully"></liferay-ui:success>
<liferay-ui:error key="error" message="Employee Type already exist"></liferay-ui:error>

<%
	//System.out.println("employeeType");
	List<EmployeeType> employeetypeTemp = new ArrayList<EmployeeType>();

	List<EmployeeType> empType = new ArrayList<EmployeeType>();
	//System.out.println("employeeType"+ExpCategoryLocalServiceUtil.getExpCategory(1));
	empType = EmployeeTypeLocalServiceUtil.getEmployeeTypes(-1, -1);
	//System.out.println("employeeType"+empType);

	//System.out.println("employeeType"+ExpCategoryType.size());

	String typeName = ParamUtil.get(renderRequest, "typeName", StringPool.BLANK);
	System.out.println("typeName" + typeName);
	String pfDeduct = ParamUtil.get(renderRequest, "pfDeduct", StringPool.BLANK);
	String status = ParamUtil.get(renderRequest, "status", StringPool.BLANK);
	String company_id = ParamUtil.get(renderRequest, "company_id", StringPool.BLANK);
	String date = ParamUtil.get(renderRequest, "final_approval_role_id", StringPool.BLANK);
	String Action = ParamUtil.get(renderRequest, "action", StringPool.BLANK);
%>
<%
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL employeetypeEditURL = renderResponse.createRenderURL();
	employeetypeEditURL.setParameter("jspPage", "/META-INF/resources/editEmployeeType.jsp");

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	PortletURL addEmployeeTypeURL = renderResponse.createRenderURL();
	addEmployeeTypeURL.setParameter("jspPage", "/META-INF/resources/editEmployeeType.jsp");
	
	
	//iteratorUrl.setParameter("", projectName);
	iteratorUrl.setParameter("typeName", typeName);

	iteratorUrl.setParameter("pfDeduct", pfDeduct);
	iteratorUrl.setParameter("status", status);
	iteratorUrl.setParameter("company_id", company_id);
	iteratorUrl.setParameter("date", date);
	//iteratorUrl.setParameter("Action", );
	//iteratorUrl.setParameter("backURL", backURL) ;
	empType = EmployeeTypeLocalServiceUtil.getEmployeeTypes(-1, -1);
%>

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
	 List<EmployeeType> empTypeSortList = new ArrayList<>();
	 OrderByComparator orderByComparator = CustomComparatorUtil.getListOrderByComparator(orderByCol, orderByType);
	 empTypeSortList = ListUtil.copy(empType);
	 
	 ListUtil.sort(empTypeSortList, orderByComparator);
%>
<%-- <portlet:actionURL name="addEmployeeType" var="addEmployeeTypeURL" />
<aui:form name="addEmployeeType" id="addEmployeeType" action="<%=addEmployeeTypeURL%>"
	method="post">
	<aui:row>
		<aui:col span="5">
			<aui:input name="typeName" type="text" value="<%=typeName%>"
				label="Type Name">
				<aui:validator name="required"></aui:validator>
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
                             $("#<portlet:namespace />typeName").val(val);
                          return result;
                            }
                </aui:validator>
			</aui:input>
		</aui:col>

		<aui:col span="5">
			<aui:input name="check" label="Provident Fund Deduction from Salary"
				type="checkbox" value="1"></aui:input>
		</aui:col>

		<aui:col span="2">
			<aui:button name="save" type="submit" value="save"></aui:button>
			<aui:button name="save" type="button" value="Cancel"
				cssClass="btn btn-danger">
			</aui:button>
		</aui:col>
	</aui:row>
</aui:form> --%>

<!--Add Employee Type  -->
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Employee Type")%>'
		url="<%=addEmployeeTypeURL.toString()%>" />
</liferay-frontend:add-menu>




<liferay-ui:search-container delta="3"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = empTypeSortList;
			total = empTypeSortList.size();
			searchContainer.setTotal(results.size());
			pageContext.setAttribute("results",
			results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
			pageContext.setAttribute("total", results.size());
			pageContext.setAttribute("delta", results.size());
			portletSession.setAttribute("wrkSchedules", results);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.EmployeeType"
		modelVar="type">


		<liferay-ui:search-container-column-text name="Type Name"
			orderable="true" orderableProperty="typeName">
			<%=type.getTypeName()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="Description"
			orderable="true" orderableProperty="Description">
			<%=type.getDescription()%>
		</liferay-ui:search-container-column-text>
		<%
			String statusIs = "";
			if(type.getStatus()==1)
			{
				statusIs="Active";
			}
			if(type.getStatus()==2){
				statusIs="Inactive";
			}
		%>
		<liferay-ui:search-container-column-text name="Status"
			orderable="true" orderableProperty="status">
			<%=statusIs%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text
			name="Provident Fund Deduction" orderable="true"
			orderableProperty="pfDeduct">
			<%=type.getPfDeduct() == 1 ? "Yes" : "No"%>
		</liferay-ui:search-container-column-text> --%>
		<%
			Date addDate = type.getAddeddate();
					SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
					String strDate = formatter.format(addDate);
		%>

		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addeddate">
			<%=strDate%>
		</liferay-ui:search-container-column-text>
		<%-- <liferay-ui:search-container-column-text name="Status"   orderable="true" orderableProperty="status">
				<%=type.getStatus()%>
				</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">

			<liferay-ui:icon-menu>
				<%
					employeetypeEditURL.setParameter("employeetypeId",
											String.valueOf(type.getEmployeetypeId()));
									/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
									/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
				%>

				<liferay-ui:icon url="<%=employeetypeEditURL.toString()%>"
					message="edit" image="edit" />

			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>


<!-- <script>
jQuery( document ).ready(function() {
		//alert("call");
		//jQuery('#<portlet:namespace/>addEmployeeType').reset();
		//document.getElementById("_EmployeeType_INSTANCE_yhU3zUtS4rEE_addEmployeeType").reset();
		$('#<portlet:namespace/>addEmployeeType').trigger("reset");
	});
</script> -->