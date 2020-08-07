<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.famocom.erpcloud.service.RecruitProcessLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RecruitProcess"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>

<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />