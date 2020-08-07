<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/META-INF/resources/view.jsp");
	
	List<Employee> birthdayList= EmployeeLocalServiceUtil.getEmployees(-1,-1);
	
	DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
	dynamicQuery.addOrder(OrderFactoryUtil.asc("dateOfBirth"));
	birthdayList=EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	//SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM");
    Date date = new Date();  
    String currentDate = formatter.format(date);
    String currentDayMonth[]= currentDate.split("/");
    System.out.println(formatter.format(date)); 
    System.out.println(currentDayMonth[0]);//current date
    System.out.println(currentDayMonth[1]);//current month
    //System.out.println(currentDate);
    String cformat=currentDayMonth[0]+"/"+currentDayMonth[1];
    
    
    Calendar c=new GregorianCalendar();
    c.add(Calendar.DATE, 32);
    Date d=c.getTime();
    String addDate = formatter.format(d);
    String nextDayMonth[]= addDate.split("/");
    System.out.println("nextDayMonth[0]"+nextDayMonth[0]); //current date+30 days
    System.out.println("nextDayMonth[1]"+nextDayMonth[1]);//month(current date+30 days)
    
    %>
     <table style="width:100%">
 		 <tr>
   			 <th>Employee Name</th>
   			 <th>BirthDay</th>
  		</tr>
    <%
    for(Employee emp:birthdayList){
    	String dob=formatter.format(emp.getDateOfBirth());
		 String array3[]= dob.split("/");
		 System.out.println(array3[0]); 
		 System.out.println(array3[1]);
		 String dobFormat =array3[0]+""+array3[1];
		/*  if((Integer.parseInt(currentDayMonth[0])<=Integer.parseInt(array3[0])|| 
				 Integer.parseInt(currentDayMonth[1])<=Integer.parseInt(array3[1]))&&
				 ((Integer.parseInt(nextDayMonth[1])>=Integer.parseInt(array3[1])) && 
						 Integer.parseInt(nextDayMonth[0])>=Integer.parseInt(array3[0] )))
		 { */
			if(Integer.parseInt(array3[0])>=Integer.parseInt(currentDayMonth[0]) && Integer.parseInt(array3[1])==Integer.parseInt(currentDayMonth[1]) || Integer.parseInt(array3[0])<=Integer.parseInt(nextDayMonth[0]) && Integer.parseInt(array3[1])==Integer.parseInt(nextDayMonth[1])){
			 SimpleDateFormat sdf = new SimpleDateFormat("dd, MMMM");
				String dateOfBirth = sdf.format(emp.getDateOfBirth());
			
		 %>	 
  		<tr>
   			 <td><%=emp.getFirstName()+" "+emp.getLastName() %></td>
   			 <td><%=dateOfBirth %></td>
  		</tr>
  		
		
			
	<%  }
    	}
    %>
	</table>

<%-- <liferay-ui:search-container delta="4"
	emptyResultsMessage="No record found." iteratorURL="<%=iteratorUrl%>"
	orderByCol="" orderByType="">
	<liferay-ui:search-container-results>
		<%
			results = birthdayList;
					total = birthdayList.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results",
							results.subList(searchContainer.getStart(), searchContainer.getResultEnd()));
					pageContext.setAttribute("total", results.size());
					pageContext.setAttribute("delta", results.size());
					portletSession.setAttribute("empType", birthdayList);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.famocom.erpcloud.model.Employee"
		modelVar="type">
			<%
				//SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy"); 
				String dob=formatter.format(type.getDateOfBirth());
				 String array3[]= dob.split("/");
				 System.out.println(array3[0]); 
				 System.out.println(array3[1]);
				 String dobFormat =array3[0]+""+array3[1];
				  
				  if(((Integer.parseInt(currentDayMonth[0])<=Integer.parseInt(array3[0]) || Integer.parseInt(nextDayMonth[0])>=Integer.parseInt(array3[0])) && (Integer.parseInt(currentDayMonth[1])<=Integer.parseInt(array3[1]) || Integer.parseInt(nextDayMonth[0])>=Integer.parseInt( array3[1]))))
				  {
					  
				 
			%>

		<liferay-ui:search-container-column-text name="Template Name"
			orderable="true" orderableProperty="templateName">
			<%=type.getFirstName() + " " +type.getLastName()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Email For"
			orderable="true" orderableProperty="emailFor">
			<%=type.getDateOfBirth()%>

		</liferay-ui:search-container-column-text>
		<%
				  }	
		%>
		
		<liferay-ui:search-container-column-text name="Action"
			cssClass="actionCol">
			<liferay-ui:icon-menu markupView="lexicon">
				<%
					emailTempURL.setParameter("id", String.valueOf(type.getId()));

					emailTempDeleteURL.setParameter("id", String.valueOf(type.getId()));
				%>

				<liferay-ui:icon url="<%=emailTempURL.toString()%>" message="edit"
					image="" />
				<liferay-ui:icon-delete url="<%=emailTempDeleteURL.toString()%>"
					message="delete" image="delete" />

			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon"></liferay-ui:search-iterator>
</liferay-ui:search-container> --%>