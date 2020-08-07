<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.service.PortletLocalServiceUtil"%>
<%@page import="javax.portlet.PortletConfig"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.model.EmailAddress"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
	
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	//System.out.println("employeeType");
	List<Employee> employeeTemp = new ArrayList<Employee>();

	List<Employee> empType = new ArrayList<Employee>();
	//System.out.println("employeeType"+ExpCategoryLocalServiceUtil.getExpCategory(1));
	List<Employee> empTypetemp = new ArrayList<Employee>();
	empType = EmployeeLocalServiceUtil.getEmployees(-1,-1);

	//System.out.println("list:-" + empType);

	//System.out.println("employeeType"+empType);

	//System.out.println("employeeType"+ExpCategoryType.size());

	/* long employeeId = ParamUtil.getLong(request, "employeeId");
	Employee emp =EmployeeLocalServiceUtil.getEmployee(employeeId); */
	String employeeCode = ParamUtil.get(renderRequest, String.valueOf("employeeCode"), StringPool.BLANK);
	String dateOfJoing = ParamUtil.get(renderRequest, "dateOfJoing", StringPool.BLANK);
	String firstName = ParamUtil.get(renderRequest, "firstName", StringPool.BLANK);
	String lastName = ParamUtil.get(renderRequest, "lastName", StringPool.BLANK);
	String designation = ParamUtil.get(renderRequest, "designation", StringPool.BLANK);
	String employeePhoto = ParamUtil.get(renderRequest, "employeePhoto", StringPool.BLANK);
	String status = ParamUtil.get(renderRequest, String.valueOf("employeeStatus"), StringPool.BLANK);
	String email= ParamUtil.get(renderRequest,"email",StringPool.BLANK);

	PortletURL deactivateURL = renderResponse.createActionURL();
	deactivateURL.setParameter("javax.portlet.action", "deactivate");
	/*---  ----*/
	PortletURL activateURL = renderResponse.createActionURL();
	activateURL.setParameter("javax.portlet.action", "activate");

	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL editEmployeeURL = renderResponse.createRenderURL();
	editEmployeeURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

	PortletURL addEmployeeURL = renderResponse.createRenderURL();
	addEmployeeURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

	PortletURL viewEmployeeURL = renderResponse.createRenderURL();
	viewEmployeeURL.setParameter("jspPage", "/META-INF/resources/viewEmployee.jsp");

	PortletURL searchEmployeeDetailsURL = renderResponse.createRenderURL();
	searchEmployeeDetailsURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

	String val = ParamUtil.getString(renderRequest, "search", StringPool.BLANK);
	System.out.println("val..." + val);

	if (null == val || val.isEmpty()) {
		empTypetemp = empType;

	} else {
		System.out.println("val1..." + val);
		System.out.println("val1..." + val);
		for (Employee emp : empType) {

			System.out.println("val2..." + val);
			if (val.equals(String.valueOf(emp.getEmployeeCode()))) {
				System.out.println("Code.........");
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("employeeCode").eq(Long.parseLong(val)));
				empTypetemp = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);

			} else if (val.contentEquals(emp.getFirstName())) {
				System.out.println("fname.........");
				DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
				dynamicQuery.add(PropertyFactoryUtil.forName("firstName").eq(val));
				empTypetemp = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("find emp........." + empTypetemp);

			} else {
				System.out.println("fname ELSE........." + val);
				DynamicQuery employeeLikeOperatorQuery = EmployeeLocalServiceUtil.dynamicQuery();
				System.out.println("fname ELSE111.........");
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.like("firstName",
						new StringBuilder("%").append(val).append("%").toString());
				criterion3 = RestrictionsFactoryUtil.or(criterion3, RestrictionsFactoryUtil.like("lastName",
						new StringBuilder("%").append(val).append("%").toString()));
				System.out.println("fname ELSE2222........." + criterion3);
				employeeLikeOperatorQuery.add(criterion3);
				empTypetemp = EmployeeLocalServiceUtil.dynamicQuery(employeeLikeOperatorQuery);
			}
		}
	}

	/* PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/META-INF/resources/view.jsp"); */

	//employeetypeEditURL.setParameter("jspPage", "/META-INF/resources/editEmployeeType.jsp");
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	//iteratorUrl.setParameter("", projectName);
	iteratorUrl.setParameter("employeeCode", employeeCode);
	iteratorUrl.setParameter("employeePhoto", employeePhoto);
	iteratorUrl.setParameter("dateOfJoing", dateOfJoing);
	iteratorUrl.setParameter("firstName", firstName);
	iteratorUrl.setParameter("lastName", lastName);
	iteratorUrl.setParameter("designation", designation);
	iteratorUrl.setParameter("status", status);
	iteratorUrl.setParameter("email", email);
	//iteratorUrl.setParameter("Action", );
	//iteratorUrl.setParameter("backURL", backURL) ;
	//empType = EmployeeLocalServiceUtil.getEmployees(-1, -1);
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
   <portlet:param name="orderByCol" value="<%= orderByCol %>" />
   <portlet:param name="orderByType" value="<%= orderByType %>" />
   <portlet:param name="navigation" value="<%=navigation %>"/>
</liferay-portlet:renderURL>

<%
	
	List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
	System.out.println("empList... " + empList.size());

	System.out.println("navigation... " + navigation);
	System.out.println("orderByCol... " + orderByCol);
	System.out.println("orderByType... " + orderByType);

	DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
	if (navigation.equals("active")) {
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(activeStatus));
	}
	if (navigation.equals("inactive")) {
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(inActiveStatus));
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
			dynamicQuery.addOrder(OrderFactoryUtil.asc("emailAddress"));
		} else if (orderByType.equals("desc")) {
			dynamicQuery.addOrder(OrderFactoryUtil.desc("emailAddress"));
		}
	}
	List<User> userList = UserLocalServiceUtil.dynamicQuery(dynamicQuery);

	System.out.println("active user... " + userList.size());
	System.out.println("inactive user... " + userList.size());
%>


<%-- <portlet:actionURL name="searchEmployee" var="searchEmployeeDetailsURL" /> --%>
<nav class="collapse-basic-search navbar navbar-default"
	data-toggle="collapsible-search">
	<div class="navbar-header navbar-header-right">
		<aui:form cssClass="basic-search input-group" name="searchEmployee"
			action="<%=searchEmployeeDetailsURL.toString()%>">
			<div class="input-group-input">
				<div class="basic-search-slider">
					<button class="basic-search-close btn btn-default" type="button">
						<span aria-hidden="true" class="icon-remove"></span>
					</button>
					<input name="<portlet:namespace/>search" class="form-control"
						value="<%=val%>" placeholder=" Search" type="text" />
				</div>
			</div>
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
					<span aria-hidden="true" class="icon-search"></span>
				</button>
			</div>
		</aui:form>
	</div>
</nav>


<liferay-frontend:management-bar includeCheckBox="<%=true%>"
	searchContainerId="users">
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%=new String[]{"active", "inactive"}%>'
			portletURL="<%=viewPageURL%>" />

		<liferay-frontend:management-bar-sort orderByCol="<%=orderByCol%>"
			orderByType="<%=orderByType%>"
			orderColumns='<%=new String[]{"name", "email"}%>'
			portletURL="<%=renderResponse.createRenderURL()%>" />
	</liferay-frontend:management-bar-filters>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%=new String[]{"list"}%>'
			portletURL="<%=renderResponse.createRenderURL()%>"
			selectedDisplayStyle="" />
	</liferay-frontend:management-bar-buttons>
	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button
			href='<%="javascript:" + renderResponse.getNamespace() + "delete();"%>'
			icon="trash" id="deleteOrganizations" label="delete" />
	</liferay-frontend:management-bar-action-buttons>

</liferay-frontend:management-bar>


<liferay-ui:search-container delta="6"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = userList;
					total = userList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					//portletSession.setAttribute("empType", empTypetemp);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.User" modelVar="type">
<%
	Employee empObj = EmployeeLocalServiceUtil.findByemployees(type.getUserId());
System.out.print("empObj.getUserId().."+empObj.getEmployeeCode());
%>
		<liferay-ui:search-container-column-text name=" ">
			<input class="rowIdsUser" onclick="selectIds()" type="checkbox" id="checkbox"
				value="<%=type.getUserId()%>">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Employee Code"
			orderable="true" orderableProperty="employeeCode">
			<%=empObj.getEmployeeCode()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Name" orderable="true">
			<%=empObj.getFirstName()%>
			<%=empObj.getLastName()%>
		</liferay-ui:search-container-column-text>
		<%			
					
					FileEntry dlfile = null;
					String url ="";
					if(Validator.isNotNull(empObj.getPhotoId())){
					System.out.println("timeweeeeeeeeeeeeerwr2..");
						dlfile = DLAppServiceUtil.getFileEntry(empObj.getPhotoId());
					}
					System.out.println("timewrwr2..");
					Date date2 = new Date();
					Long time2 = (long) (((((date2.getHours() * 60) + date2.getMinutes()) * 60) + date2.getSeconds())
							* 1000);
					System.out.println("time2.." + time2);
					if(dlfile!=null){
						url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
							+ themeDisplay.getScopeGroupId() + "/" + dlfile.getFolderId() + "/" + dlfile.getFileName()
							+ "/" + dlfile.getUuid() + "?t=" + time2;
					}
						
					//ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					//Map<String, String> urlMap = new HashMap<String, String>();//key = file name ,value = url
					/* long repositoryId = themeDisplay.getScopeGroupId();
					try {
						Folder folder =getFolder(themeDisplay);
						List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
						for (FileEntry file : fileEntries) {
						String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
					 file.getFolderId() +  "/" +file.getTitle() ;
						urlMap.put(file.getTitle().split("\\.")[0], url);// remove jpg or pdf
						  
						}
						} catch (Exception e) {
						e.printStackTrace();
						}
						return urlMap;
					
						} */
		%>
		<liferay-ui:search-container-column-text name="Photo" orderable="true"
			orderableProperty="employeePhoto">
			<img witdh="70px" height="70px" src="<%=url%>" >
		</liferay-ui:search-container-column-text>
		<%
			/* DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
									Date joiningDate=(Date) df.parse(String.valueOf(type.getDateOfJoing())); */
					//empObj.setDateOfJoing(joiningDate);
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String joiningDate = sdf.format(empObj.getDateOfJoing());
		%>
		<liferay-ui:search-container-column-text name="Date of joining"
			orderable="true" orderableProperty="dateOfJoing">
			<%=joiningDate%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Designation"
			orderable="true" orderableProperty="designation">
			<%=empObj.getDesignation()%>
		</liferay-ui:search-container-column-text> 
		<liferay-ui:search-container-column-text name="Email"
			orderable="true" orderableProperty="email">
			<%=type.getEmailAddress()%>
		</liferay-ui:search-container-column-text>
		
		<%-- <liferay-ui:search-container-column-text name="Status"	orderable="true" orderableProperty="status">
				<div class="form-group">
				    <label>
				        <!-- <input class="toggle-switch" type="checkbox"> -->
				        <span class="toggle-switch-label"></span>
				
				        <span aria-hidden="true" class="toggle-switch-bar">
				            <span class="toggle-switch-handle" data-label-on="Active" data-label-off="Inactive">
				            </span>
				        </span>
				    </label>
				</div>
			<%=type.getEmployeeStatus()%>
		</liferay-ui:search-container-column-text> --%>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					boolean editURL = true;
									editEmployeeURL.setParameter("employeeId", String.valueOf(empObj.getEmployeeId()));
									editEmployeeURL.setParameter("editURL", String.valueOf(editURL));
									editEmployeeURL.setParameter("maritalStatus", empObj.getMaritalStatus());

									viewEmployeeURL.setParameter("employeeId", String.valueOf(empObj.getEmployeeId()));

									deactivateURL.setParameter("userId", String.valueOf(type.getUserId()));

									activateURL.setParameter("userId", String.valueOf(type.getUserId()));

									/* expenseCategoryDeletetURL.setParameter("cat_id", String.valueOf(expenseType.getCat_id())); */
									/*  System.out.println("participantId"+Long.toString(expenseType.getCat_id())); */
				%>


				<liferay-ui:icon markupView="lexicon"
					url="<%=editEmployeeURL.toString()%>" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=viewEmployeeURL.toString()%>"
					message="View" image="view" />
				<%
					if (type.getStatus() == 5) {
				%>
				<liferay-ui:icon url="<%=activateURL.toString()%>"
					message="activate" image="activate" />
				<%
					} else {
				%>
				<liferay-ui:icon url="<%=deactivateURL.toString()%>"
					message="Deactivate" image="deactivate" />

				<%
					}
				%>


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
 <script>
	/* document.getElementById("demo").onclick = function() {myFunction()}; */
	function selectIds() {
		alert("call.,.,.,");
		$("#checkbox").each(function() {
			alert($(this).val());
			
			//selectedIds.push();
		});
	}
</script>