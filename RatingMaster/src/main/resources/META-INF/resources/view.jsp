<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.RatingMasterLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.RatingMaster"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/init.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend"prefix="liferay-frontend"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
	System.out.println("Call View JSp");
	boolean editURL = false;
	String ratingNumber = ParamUtil.getString(renderRequest, "ratingNumber", StringPool.BLANK);
	String ratingKey = ParamUtil.getString(renderRequest, "ratingKey", StringPool.BLANK);
	String ratingDesc = ParamUtil.getString(renderRequest, "ratingDesc", StringPool.BLANK);
	String addedDate = ParamUtil.getString(renderRequest, "addedDate", StringPool.BLANK);
	List<RatingMaster> ratMastList = new ArrayList<RatingMaster>();
	ratMastList = RatingMasterLocalServiceUtil.getRatingMasters(-1, -1);
	System.out.println("Call View JSp   111111111   1 1111");
	
	long ratingId = ParamUtil.getLong(request, "ratingId");
	RatingMaster rm = null;
	if (Validator.isNotNull(ratingId)) {
		editURL = true;
		try {
			rm = RatingMasterLocalServiceUtil.getRatingMaster(ratingId);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	System.out.println("Call View JSp   222222 22222222 22222");
	PortletURL filter = renderResponse.createRenderURL();
	filter.setParameter("jspPage", "/META-INF/resources/view.jsp");

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	PortletURL addRatingURL = renderResponse.createRenderURL();
	addRatingURL.setParameter("jspPage", "/META-INF/resources/addRating.jsp");

	PortletURL ratingMasterEditURL = renderResponse.createRenderURL();
	ratingMasterEditURL.setParameter("jspPage", "/META-INF/resources/addRating.jsp");
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");

	PortletURL ratingMasterDeleteURL = renderResponse.createActionURL();
	ratingMasterDeleteURL.setParameter("javax.portlet.action", "deleteRatingMaster");
	
	iteratorUrl.setParameter("ratingnum", ratingNumber);
	iteratorUrl.setParameter("ratingkey", ratingKey);
	iteratorUrl.setParameter("ratingdescription", ratingDesc);
	iteratorUrl.setParameter("addeddate", addedDate);
	
	//long count = RatingMasterLocalServiceUtil.getUsageCount(1001);
%>
<liferay-ui:error key="delete-error"
	message="Sorry, This Rating Already in Use Somewhere, Please Check" />
<liferay-frontend:add-menu>
	<liferay-frontend:add-menu-item
		title='<%=LanguageUtil.get(request, "Add Performance Master")%>'
		url="<%=addRatingURL.toString()%>" />
</liferay-frontend:add-menu>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="No record found." orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = ratMastList;
					total = results.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("ratMastList", ratMastList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.RatingMaster"
		modelVar="ratMast">


		<liferay-ui:search-container-column-text name="Rating Number"
			orderable="true" orderableProperty="ratingNum">
			<%=ratMast.getRatingNum()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Rating Key"
			orderable="true" orderableProperty="ratingKey">
			<%=ratMast.getRatingKey()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Rating Description"
			orderable="true" orderableProperty="ratingDescription">
			<%=ratMast.getRatingDescription()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Added Date"
			orderable="true" orderableProperty="addedDate">
			<%=dateFormat.format(ratMast.getAddedDate())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="" cssClass="actionCol">

			<%
				ratingMasterEditURL.setParameter("ratingId", String.valueOf(ratMast.getRatingId()));
				ratingMasterEditURL.setParameter("editURL", String.valueOf(editURL));
				ratingMasterDeleteURL.setParameter("ratingId",String.valueOf(ratMast.getRatingId()));
			%>

			<liferay-ui:icon-menu markupView="lexicon">

				<liferay-ui:icon url="<%=ratingMasterEditURL.toString()%>"
					label="Edit" message="Edit" image="edit" />
				<liferay-ui:icon url="<%=ratingMasterDeleteURL.toString()%>"
					label="Delete" message="delete" image="delete" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container>