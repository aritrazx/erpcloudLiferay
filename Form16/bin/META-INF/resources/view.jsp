<%@page
	import="com.liferay.portal.kernel.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.FormSixteenLocalServiceUtil"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@page
	import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.FormSixteen"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>

<%@include file="/init.jsp"%>
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
	boolean isViewPermission = false;
	try {
		isViewPermission = PortletPermissionUtil.contains(permissionChecker, themeDisplay.getPlid(), "Form16",
				"FORM_UPLOAD");
		System.out.print("isViewPermission " + isViewPermission);
	} catch (Exception exception) {
		exception.printStackTrace();
	}
	if (isViewPermission) {

		PortletURL addFormURL = renderResponse.createRenderURL();
		addFormURL.setParameter("jspPage", "/META-INF/resources/addForm16.jsp");

		PortletURL formDeleteURL = renderResponse.createActionURL();
		formDeleteURL.setParameter("javax.portlet.action", "deleteAddForm");

		PortletURL myViewURL = renderResponse.createRenderURL();
		myViewURL.setParameter("jspPage", "/META-INF/resources/MyView.jsp");

		PortletURL backURL = renderResponse.createRenderURL();
		backURL.setParameter("jspPage", "/META-INF/resources/view.jsp");

		List<FormSixteen> formSixteens = FormSixteenLocalServiceUtil.getFormSixteens(-1, -1);
		List<FormSixteen> empFormSixteens = new ArrayList<FormSixteen>();
		String val = ParamUtil.getString(request, "employeeId", StringPool.BLANK);
		System.out.println("val..." + val);
		String employeeId = ParamUtil.getString(renderRequest, "employeeId", StringPool.BLANK);
		System.out.println("::::selectEmployee----------->>>>>>>>" + employeeId);
		String financialYear = ParamUtil.getString(renderRequest, "financialYear", StringPool.BLANK);
		System.out.println("::::financialYear----------->>>>>>>>" + financialYear);

		PortletURL emailSendURL = renderResponse.createActionURL();
		emailSendURL.setParameter("javax.portlet.action", "emailSend");
		emailSendURL.setParameter("financialYear", financialYear);

		String employeeName = ParamUtil.getString(request, "employeeName", StringPool.BLANK);
		//String employeeId = ParamUtil.getString(request, "employeeId",StringPool.BLANK);
		Employee employee = null;
		if (Validator.isNotNull(employeeId)) {
			try {
				employee = EmployeeLocalServiceUtil.getEmployee(Long.valueOf(employeeId));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		PortletURL assignURL = renderResponse.createRenderURL();
		assignURL.setWindowState(LiferayWindowState.POP_UP);
		assignURL.setParameter("jspPage", "/META-INF/resources/addEmployee.jsp");

		try {
			if (Validator.isNull(employeeId)) {
				DynamicQuery dynamicQuery = FormSixteenLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("financialYear", financialYear);
				dynamicQuery.addOrder(OrderFactoryUtil.desc("financialYear"));
				dynamicQuery.add(criterion3);
				empFormSixteens = FormSixteenLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("empleaveList financialYear" + empFormSixteens);
			} else {
				DynamicQuery dynamicQuery = FormSixteenLocalServiceUtil.dynamicQuery();
				Criterion criterion3 = null;
				criterion3 = RestrictionsFactoryUtil.eq("employeeId", Long.parseLong(employeeId));
				criterion3 = RestrictionsFactoryUtil.and(criterion3,
						RestrictionsFactoryUtil.eq("financialYear", financialYear));
				dynamicQuery.addOrder(OrderFactoryUtil.desc("financialYear"));
				dynamicQuery.add(criterion3);
				empFormSixteens = FormSixteenLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("empleaveList financialYear and Id " + empFormSixteens.size());
			}
		} catch (Exception e) {

		}
%>
<liferay-ui:error key="error"
	message="Sorry, Please LogIn to send a mail !" />
<%-- <a class="btn btn-primary btn-default" name="myFormSixteen"
	type="submit" href="<%=myViewURL.toString()%>">My Form16</a> --%>
<portlet:actionURL name="employeeForm16List" var="employeeForm16ListURL" />
<aui:form name="employeeForm16List"
	action="<%=employeeForm16ListURL.toString()%>" method="post">
	<aui:input name="val" type="hidden" value="<%=val%>"></aui:input>
	<aui:row>
		<aui:col span="4">
			<aui:input name="employeeName" id="employeeName"
				label="Click here to add Employee" type="text" readonly="readonly"
				value="<%=employee != null
										? (employee.getFirstName() + " " + employee.getLastName())
										: employeeName%>"
				onClick="popup()">
			</aui:input>
			<input name="<portlet:namespace />employeeId" id="employeeId"
				type="hidden" label="" value="<%=employeeId%>"></input>
			<%-- <aui:select name="selectEmployee" label="Select Employee"
				onChange="changeEmp(this.value);">
				<option value="">All Employee</option>
				<%
					try {
										List<Employee> empList = EmployeeLocalServiceUtil.getEmployees(-1, -1);
										for (Employee obj : empList) {
				%>
				<option value="<%=obj.getEmployeeId()%>"><%=obj.getEmployeeCode()%>-<%=obj.getFirstName()%>
					<%=obj.getLastName()%></option>
				<%
					}
									} catch (Exception e) {
										e.printStackTrace();
									}
				%>
			</aui:select> --%>
		</aui:col>
		<aui:col span="4">
			<aui:select id="financialYear" name="financialYear"
				label="Financial Year">
				<aui:option selected="true" value="2018-2019">2018-2019</aui:option>
				<aui:option value="2017-2018">2017-2018</aui:option>
				<aui:option value="2016-2017">2016-2017</aui:option>
				<aui:option value="2015-2016">2015-2016</aui:option>
				<aui:option value="2014-2015">2014-2015</aui:option>
			</aui:select>
		</aui:col>
		<aui:col span="4">
			<span> <br />
			</span>
			<aui:button name="submit" type="submit" value="submit" />
		</aui:col>
	</aui:row>
</aui:form>
<liferay-ui:error key="error"
	message="Your have already uploaded your form for this Financial Year!" />
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Form16")%>'
		url="<%=addFormURL.toString()%>" />
</liferay-frontend:add-menu>
<%
	if (Validator.isNull(employeeId) && Validator.isNull(financialYear)) {
%>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = formSixteens;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
							//portletSession.setAttribute("formSixteens", formSixteens);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.FormSixteen"
		modelVar="var">
		<%
			Employee empObj = null;
							try {
								empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
							} catch (Exception e) {
								e.printStackTrace();
							}
		%>
		<liferay-ui:search-container-column-text name="Employee Code">
			<b><%=empObj.getEmployeeCode()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Name">
			<b><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Financial Year">
			<b><%=var.getFinancialYear()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Attached File">
			<%
				try {
										if (var.getFileEnteryId() > 0) {

											FileEntry fileEntry = DLAppServiceUtil.getFileEntry(var.getFileEnteryId());
											String filePath = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
													themeDisplay, "");
											//System.out.println("FilePath .....................:-" + filePath);
			%>
			<liferay-ui:icon
				iconCssClass="<%=DLUtil.getFileIconCssClass(fileEntry.getExtension())%>"
				label="<%=true%>" url='<%=filePath%>' icon="pdf"
				message="<%=fileEntry.getTitle()%>" target="_blank" />
			<br>
			<%
				}
									} catch (Exception e) {
										e.printStackTrace();
									}
			%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				formDeleteURL.setParameter("id", String.valueOf(var.getId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">
				<liferay-ui:icon-delete url="<%=formDeleteURL.toString()%>"
					label="Delete" message="delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%
	} else {
%>
<liferay-ui:header title="Search Result" backLabel="Back"
	backURL="<%=backURL.toString()%>">
</liferay-ui:header>
<aui:row>
	<aui:col span="10">
	</aui:col>
	<aui:col span="2">
		<a class="btn btn-primary btn-default" name="emailSend" type="submit"
			href="<%=emailSendURL.toString()%>">Email Send</a>
	</aui:col>
</aui:row>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = empFormSixteens;
							total = results.size();
							searchContainer.setTotal(results.size());
							pageContext.setAttribute("results",
									results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
							pageContext.setAttribute("total", results.size());
							pageContext.setAttribute("delta", results.size());
							//portletSession.setAttribute("formSixteens", formSixteens);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.FormSixteen"
		modelVar="var">
		<%
			Employee empObj = null;
							try {
								empObj = EmployeeLocalServiceUtil.getEmployee(var.getEmployeeId());
							} catch (Exception e) {
								e.printStackTrace();
							}
		%>
		<liferay-ui:search-container-column-text name="Employee Id">
			<b><%=empObj.getEmployeeCode()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Name">
			<b><%=empObj.getFirstName()%> <%=empObj.getLastName()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Financial Year">
			<b><%=var.getFinancialYear()%></b>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Attached File">
			<%
				try {
										if (var.getFileEnteryId() > 0) {

											FileEntry fileEntry = DLAppServiceUtil.getFileEntry(var.getFileEnteryId());
											String filePath = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
													themeDisplay, "");
											//System.out.println("FilePath .....................:-" + filePath);
			%>
			<liferay-ui:icon
				iconCssClass="<%=DLUtil.getFileIconCssClass(fileEntry.getExtension())%>"
				label="<%=true%>" url='<%=filePath%>' icon="pdf"
				message="<%=fileEntry.getTitle()%>" target="_blank" />
			<br>
			<%
				}
									} catch (Exception e) {
										e.printStackTrace();
									}
			%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				formDeleteURL.setParameter("id", String.valueOf(var.getId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">
				<liferay-ui:icon-delete url="<%=formDeleteURL.toString()%>"
					label="Delete" message="delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%
	}
%>
<script type="text/javascript">
	$(document).ready(function() {
		employeeId = function(employeeId, employeeName) {

			$('#employeeId').val(employeeId);
			$('#<portlet:namespace />employeeName').val(employeeName);
		};
	});
</script>
<aui:script>
	function popup() {
		var url = '<%=assignURL.toString()%>';
		console.log("url--" + url);
		var employeeId = $("#<portlet:namespace/>employeeId").val();
		console.log("employeeId--" + employeeId);
		//alert("employeeId "+employeeId);
		//$("#<portlet:namespace/>employeeId").val();
		Liferay.Util.openWindow({
			dialog : {
				//cssClass: 'aui-popup-example',
				destroyOnHide : true,
				height : 600,
				width : 550,
				close : true
			},
			dialogIframe : {
			//bodyCssClass: 'custom-css-class'
			},
			title : 'Add Employee',
			uri : url

		});
		/* if(employeeId!=0){
			popWindow.destroy();
		} */
	}
</aui:script>






<%
	} else {
%>
<div class="control-group no-margin">
	<label class="control-label">You don't have permission to view
		the Form16</label>
</div>
<%
	}
%>