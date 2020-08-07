<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<aui:row>
	<aui:col span="6">
		<aui:row>
			<aui:col span="8">
				<aui:input name="totalPay" type="text" value="<%=emp!=null? emp.getTotalPay():"" %>" label="Total Pay" />
			</aui:col>
			<aui:col span="4">
				<aui:button name="calculate" type="button" value="Calculate" />
			</aui:col>
		</aui:row>
	</aui:col>
	<aui:col span="6">
		<aui:select name="employeeType" label="Employee Type" class="form-control">
			<aui:option value="contractual">Contractual</aui:option>
			<aui:option value="fullTime">Full-Time</aui:option>
			<aui:option value="partTime">Part-Time</aui:option>
			<aui:option value="permanent">Permanent</aui:option>
			</br>
			<!--check box for fund deduction from salary  -->
		</aui:select>
		<aui:input name="check" label="Provident Fund Deduction from Salary"
				type="checkbox" value="<%=emp!=null?emp.getIspfdeduct():""%>"></aui:input>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col span="6">
		<label><h3>Allowance Info</h3></label><br/>
		<hr>
		<aui:row>
			<aui:col span="6">
				<aui:input name="basicPay" type="text" value="<%=emp!=null?emp.getBasicPay():"" %>" label="Basic Pay" />
				<aui:input name=" houseRentAllowance" type="text" value="<%=emp!=null? emp.getHra():"" %>"
					label=" House Rent Allowance" />
				<aui:input name="travelAllowance" type="text" value="<%=emp!=null? emp.getTa():"" %>"
					label="Travel Allowance" />
				<aui:input name="internetAllowance" type="text" value="<%=emp!=null? emp.getInternet():"" %>"
					label="Internet Allowance" />
				<aui:input name="areas" type="text" value="<%=emp!=null? emp.getAreas():"" %>" label="Areas" />
				<aui:input name="mobileAllowance" type="text" value="<%=emp!=null? emp.getMobile():"" %>"
					label="Mobile Allowance" />
			</aui:col>
			<aui:col span="6">
				<aui:input name="dearnessAllowance" type="text" value="<%=emp!=null? emp.getDa():"" %>"
					label="Dearness Allowance" />
				<aui:input name="medicalAllowance" type="text" value="<%=emp!=null? emp.getMedical():"" %>"
					label="Medical Allowance" />
				<aui:input name="conveyanceAllowance" type="text" value="<%=emp!=null? emp.getConveyance():"" %>"
					label="Conveyance Allowance" />
				<aui:input name="fare" type="text" value="<%=emp!=null? emp.getFare():"" %>" label="Fare" />
				<aui:input name="yearlyBonus" type="text" value="<%=emp!=null? emp.getBouns():"" %>"
					label="Yearly Bonus" />
				<aui:input name="otherAllowance" type="text" value="<%=emp!=null? emp.getOtherAllowance():"" %>"
					label="Other Allowance" />
			</aui:col>
		</aui:row>
	</aui:col>
	<aui:col span="6">
	<label><h3>Deductions Info</h3></label><br/>
	<hr>
		<aui:row>
			<aui:col span="6">
				<aui:input name="providentFund" type="text" value="<%=emp!=null? emp.getProvidentFund():"" %>" label="Provident Fund" />
				<aui:input name="incomeTax" type="text" value="<%=emp!=null? emp.getIncomeTax():"" %>" label="Income Tax" />
				<aui:input name="otherDeduction" type="text" value="<%=emp!=null? emp.getOtherDeduction():"" %>" label="Other Deduction" />
			</aui:col>
			<aui:col span="6">
				<aui:input name="professionTax" type="text" value="<%=emp!=null? emp.getProfessionTax():"" %>" label="Profession Tax" />
				<aui:input name="advancePayment" type="text" value="" label="Advance Payment" />
			</aui:col>
		</aui:row>
	</aui:col>
</aui:row>