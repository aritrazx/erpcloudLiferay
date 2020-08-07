<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />



<nav class="collapse-basic-search navbar navbar-default"
	data-toggle="collapsible-search">
	<div class="navbar-header navbar-header-right">
		<aui:form cssClass="basic-search input-group" name="searchEmployee"
			action="<%= searchEmployeeDetailsURL.toString()%>" >
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