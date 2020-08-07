<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.portal.kernel.service.PortletLocalServiceUtil"%>
<%@page import="javax.portlet.PortletConfig"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.model.EmailAddress"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page
	import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="javax.swing.plaf.synth.SynthOptionPaneUI"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.taglib.aui.AUIUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	String val = ParamUtil.getString(renderRequest, "search", StringPool.BLANK);
	String employeeCode = ParamUtil.get(renderRequest, String.valueOf("employeeCode"), StringPool.BLANK);
	String dateOfJoing = ParamUtil.get(renderRequest, "dateOfJoing", StringPool.BLANK);
	String firstName = ParamUtil.get(renderRequest, "firstName", StringPool.BLANK);
	String lastName = ParamUtil.get(renderRequest, "lastName", StringPool.BLANK);
	String designation = ParamUtil.get(renderRequest, "designation", StringPool.BLANK);
	String employeePhoto = ParamUtil.get(renderRequest, "employeePhoto", StringPool.BLANK);
	String status = ParamUtil.get(renderRequest, String.valueOf("employeeStatus"), StringPool.BLANK);
	String email = ParamUtil.get(renderRequest, "email", StringPool.BLANK);
	List<Employee> employeeTemp = new ArrayList<Employee>();

	List<Employee> empType = new ArrayList<Employee>();
	empType = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	List<Employee> empTypeTemp = new ArrayList<Employee>();
	List<Employee> empListSearch = new ArrayList<Employee>();


	PortletURL deactivateURL = renderResponse.createActionURL();
	deactivateURL.setParameter("javax.portlet.action", "deactivate");
	/*---  ----*/
	PortletURL activateURL = renderResponse.createActionURL();
	activateURL.setParameter("javax.portlet.action", "activate");

	PortletURL multiDeactivateURL = renderResponse.createActionURL();
	multiDeactivateURL.setParameter("javax.portlet.action", "multiDeactivate");

	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL editEmployeeURL = renderResponse.createRenderURL();
	editEmployeeURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

	PortletURL addEmployeeURL = renderResponse.createRenderURL();
	addEmployeeURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

	PortletURL viewEmployeeURL = renderResponse.createRenderURL();
	viewEmployeeURL.setParameter("jspPage", "/META-INF/resources/viewEmployee.jsp");
	
	PortletURL myProfileURL = renderResponse.createRenderURL();
	myProfileURL.setParameter("jspPage", "/META-INF/resources/viewEmployee.jsp");

	PortletURL searchEmployeeDetailsURL = renderResponse.createRenderURL();
	searchEmployeeDetailsURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL payStructure = renderResponse.createRenderURL();
	payStructure.setParameter("jspPage", "/addPayStructure.jsp");

	if (null == val || val.isEmpty()) {
		empTypeTemp = empType;

	} else {
		for (Employee emp : empType) {
			if (val.equals(String.valueOf(emp.getEmployeeCode()))) {
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("employeeCode").eq(Long.parseLong(val)));
				empTypeTemp = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);

			} else if (val.equals(emp.getFirstName())) {
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("firstName").eq(val));
				empTypeTemp = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);

			} else {
				DynamicQuery employeeLikeOperatorQuery = EmployeeLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.like("firstName",
						new StringBuilder("%").append(val).append("%").toString());
				criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("lastName",
						new StringBuilder("%").append(val).append("%").toString()));
				employeeLikeOperatorQuery.add(criterion3);
				empTypeTemp = EmployeeLocalServiceUtil.dynamicQuery(employeeLikeOperatorQuery);
			}
		}
	}

	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	iteratorUrl.setParameter("employeeCode", employeeCode);
	iteratorUrl.setParameter("employeePhoto", employeePhoto);
	iteratorUrl.setParameter("dateOfJoing", dateOfJoing);
	iteratorUrl.setParameter("firstName", firstName);
	iteratorUrl.setParameter("lastName", lastName);
	iteratorUrl.setParameter("designation", designation);
	iteratorUrl.setParameter("status", status);
	iteratorUrl.setParameter("email", email);
%>


<%
	String navigation = ParamUtil.getString(request, "navigation", "active");
	String orderByCol = ParamUtil.getString(request, "orderByCol", "name");
	String orderByType = ParamUtil.getString(request, "orderByType", "asc");
	int activeStatus = 0;
	int inActiveStatus = 5;
%>

<liferay-portlet:renderURL varImpl="viewPageURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
	<%-- <portlet:param name="displayStyle" value="<%= displayStyle %>" /> --%>
	<portlet:param name="orderByCol" value="<%=orderByCol%>" />
	<portlet:param name="orderByType" value="<%=orderByType%>" />
	<portlet:param name="navigation" value="<%=navigation%>" />
</liferay-portlet:renderURL>

<%
	List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
	if (navigation.equals("active")) {
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeStatus").eq(activeStatus));
	}
	if (navigation.equals("inactive")) {
		dynamicQuery.add(PropertyFactoryUtil.forName("employeeStatus").eq(inActiveStatus));
	}
	if (orderByCol.equals("name")) {
		if (orderByType.equals("asc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.asc("firstName"));
		} else if (orderByType.equals("desc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.desc("firstName"));
		}
	}
	if (orderByCol.equals("email")) {
		if (orderByType.equals("asc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.asc("emaiAddress"));
		} else if (orderByType.equals("desc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.desc("emaiAddress"));
		}
	}
	List<Employee> empList1 = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
%>

<aui:a label="myProfile" cssClass="hide" href="<%=myProfileURL.toString() %>"></aui:a>

<aui:row>
	<aui:col span="11">

	</aui:col>
	<aui:col span="1">
		<liferay-frontend:management-bar>
			<liferay-frontend:management-bar-button href="" icon="trash"
				id="xxxx" label="Deactivate"></liferay-frontend:management-bar-button>
		</liferay-frontend:management-bar>
	</aui:col>
</aui:row>


<%@ include file="search.jsp"%>

<%@ include file="managementBar.jsp"%>


<liferay-ui:search-container delta="5"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			if (null == val || val.isEmpty()) {
						empListSearch = empList1;
						results = empListSearch;
					} else {
						empListSearch = empTypeTemp;
						results = empListSearch;
					}
					total = empListSearch.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("empType", empListSearch);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Employee"
		modelVar="type">

		<%-- <%
	Employee empObj = EmployeeLocalServiceUtil.findByemployees(type.getUserId());
System.out.print("empObj.getUserId().."+empObj.getEmployeeCode());
%> --%>
		<liferay-ui:search-container-column-text name=" ">
			<input type="checkbox" value="<%=type.getUserId()%>" class="check"
				name="ch[]">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Employee Code"
			orderable="true" orderableProperty="employeeCode">
			<%=type.getEmployeeCode()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Name" orderable="true">
			<%=type.getFirstName()%>
			<%=type.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%
			FileEntry dlfile = null;
					String url = "";
					if (Validator.isNotNull(type.getPhotoId())) {
						dlfile = DLAppServiceUtil.getFileEntry(type.getPhotoId());
					}
					Date date2 = new Date();
					Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds())
							* 1000);
					if (dlfile != null) {
						url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
								+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/"
								+ dlfile.getFileName() + "/" + dlfile.getUuid() + "?t=" + time2;
					}

		%>
		<liferay-ui:search-container-column-text name="Photo" orderable="true"
			orderableProperty="employeePhoto">
			<%
				if (dlfile != null) {
			%>
			<img witdh="70px" height="70px" src="<%=url%>" />
			<%
				} else {
			%>
			<img witdh="70px" height="70px"
				src="<%=renderRequest.getContextPath()%>/default.jpg" />
			<%
				}
			%>
		</liferay-ui:search-container-column-text>
		<%
					SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");
					String joiningDate = sdf.format(type.getDateOfJoing());
		%>
		<liferay-ui:search-container-column-text name="Date of joining"
			orderable="true" orderableProperty="dateOfJoing">
			<%=joiningDate%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Designation"
			orderable="true" orderableProperty="designation">
			<%=type.getDesignation()%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Email" orderable="true"
			orderableProperty="email">
			<%=type.getEmaiAddress()%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="" cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					boolean editURL = true;
									editEmployeeURL.setParameter("employeeId", String.valueOf(type.getEmployeeId()));
									editEmployeeURL.setParameter("editURL", String.valueOf(editURL));
									editEmployeeURL.setParameter("maritalStatus", type.getMaritalStatus());

									viewEmployeeURL.setParameter("employeeId", String.valueOf(type.getEmployeeId()));

									deactivateURL.setParameter("userId", String.valueOf(type.getUserId()));
									deactivateURL.setParameter("employeeId", String.valueOf(type.getEmployeeId()));

									activateURL.setParameter("userId", String.valueOf(type.getUserId()));
									activateURL.setParameter("employeeId", String.valueOf(type.getEmployeeId()));

									payStructure.setParameter("employeeId", String.valueOf(type.getEmployeeId()));
									/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
									/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
				%>


				<liferay-ui:icon markupView="lexicon"
					url="<%=editEmployeeURL.toString()%>" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=viewEmployeeURL.toString()%>"
					message="View" image="view" />
				<%
					if (type.getEmployeeStatus() == 5) {
				%>
				<liferay-ui:icon-delete url="<%=activateURL.toString()%>"
					message="activate" image="activate"
					confirmation="Are you sure want to activate?" />
				<%
					} else {
				%>
				<liferay-ui:icon-delete url="<%=deactivateURL.toString()%>"
					message="Deactivate" image="deactivate"
					confirmation="Are you sure want to deactivate?" />

				<%
					}
				%>

				<liferay-ui:icon url="<%=payStructure.toString()%>"
					message="Pay Structure" image="view" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>

<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Employee")%>'
		url="<%=addEmployeeURL.toString()%>" />
</liferay-frontend:add-menu>



<style>
.svg-icon {
	width: 1em;
	height: 1em;
}

.svg-icon path, .svg-icon polygon, .svg-icon rect {
	fill: #4691f6;
}

.svg-icon circle {
	stroke: #4691f6;
	stroke-width: 1;
}
</style>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$('#<portlet:namespace/>xxxx').click(function(){
		var idVal = '';
        $('.check:checkbox:checked').each(function(i){
        	if(idVal==''){
        		idVal=$(this).val();
        	}else{
        		idVal = idVal+','+ $(this).val();
        	}
         
        }); 
		console.log(idVal);
		
		if(idVal==''){
			alert('Please select a checkbox');
		}else{
			var url = '<%=multiDeactivateURL.toString()%>
	';
			jQuery.ajax({
				url : url,
				data : {
					'<portlet:namespace/>val' : idVal
				},
				success : function(result) {

					console.log(result);
					location.reload();
				},
				error : function() {
				},
				type : 'POST'
			});
		}

	});

	$(document).ready(function() {

		$('#<portlet:namespace/>allRowIds').click(function() {
			//	alert("call all");
			if (this.checked) {
				$('.check').each(function() {
					//	 alert("checked");
					this.checked = true;
				})
			} else {
				$('.check').each(function() {
					this.checked = false;
				})
			}

		});
	});

	$(".check")
			.each(
					function() {
						$(this)
								.click(
										function() {
											var checkboxLen = $(".check").length;
											var checkedLen = $("[class='check']:checked").length;
											console
													.log("total check box length is"
															+ checkboxLen);
											console.log(checkedLen);

											if (checkboxLen != checkedLen) {

												$(
														"#<portlet:namespace/>allRowIds")
														.prop('indeterminate',
																true);
											} else {
												$(
														"#<portlet:namespace/>allRowIds")
														.prop('indeterminate',
																false);
											}
										});
					});
</script>