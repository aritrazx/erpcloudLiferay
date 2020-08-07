<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<aui:row>
	<aui:col>
		<p>
		Total Pay: <b style="color: #f48120;"><%=emp.getTotalPay()%></b>
		</p>
	</aui:col>
</aui:row>
<aui:row>
	<aui:col span="6">
		<label><h3>Allowance Info</h3></label><br/>
		<hr>
		<aui:col span="6">
			<p>
				Basic Pay: <b style="color: #f48120;"><%=emp.getBasicPay()%></b>
			</p></br>
			
			<p>
				House Rent Allowance: <b style="color: #f48120;"><%=emp.getHra()%></b>
			</p></br>
			<p>
				Travel Allowance: <b style="color: #f48120;"><%=emp.getTa()%></b>
			</p></br>
			<p>
				Internet Allowance: <b style="color: #f48120;"><%=emp.getInternet()%></b>
			</p></br>
			<p>
				Areas: <b style="color: #f48120;"><%=emp.getAreas()%></b>
			</p></br>
			
			<p>
				Mobile Allowance: <b style="color: #f48120;"><%=emp.getMobile()%></b>
			</p></br>
		</aui:col>
		<aui:col span="6">
			<p>
				Dearness Allowance: <b style="color: #f48120;"><%=emp.getDa()%></b>
			</p></br>
			<p>
				Medical Allowance: <b style="color: #f48120;"><%=emp.getMedical()%></b>
			</p></br>
			<p>
				Conveyance Allowance: <b style="color: #f48120;"><%=emp.getConveyance()%></b>
			</p></br>
			<p>
				Fare: <b style="color: #f48120;"><%= emp.getFare()%></b>
			</p></br>
			<p>
				Yearly Bonus: <b style="color: #f48120;"><%=emp.getBouns()%></b>
			</p></br>
			<p>
				Other Allowance: <b style="color: #f48120;"><%=emp.getOtherAllowance()%></b>
			</p></br>
			
		</aui:col>
		
	</aui:col>
	<aui:col span="6">
		<label><h3>Deductions Info</h3></label><br/>
		<hr>
		<aui:col span="6">
			<p>
				Provident Fund: <b style="color: #f48120;"><%= emp.getProvidentFund()%></b>
			</p></br>
			<p>
				Income Tax: <b style="color: #f48120;"><%=emp.getIncomeTax()%></b>
			</p></br>
			<p>
				Other Deduction: <b style="color: #f48120;"><%=emp.getOtherDeduction()%></b>
			</p></br>
		</aui:col>
		<aui:col span="6">
			<p>
				Profession Tax: <b style="color: #f48120;"><%=emp.getProfessionTax()%></b>
			</p></br>
		
		</aui:col>
		
	</aui:col>
</aui:row>