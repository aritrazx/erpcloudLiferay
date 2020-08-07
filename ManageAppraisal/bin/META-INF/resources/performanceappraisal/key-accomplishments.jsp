<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<div id="menu4" class="tab-pane fade active in">
	<div class="box-body" id="">
		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading ">Key Accomplishments</div>
				<div class="panel-body ">
					<div class="col-xs-12 col-md-12 ">

						<div class="col-md-12 col-sm-6 col-xs-12 margintop10 paddingleft0">
							<div class="form-group">
								<%
									String accomplishmentsEmp = StringPool.BLANK;
									String accomplishmentsMan = StringPool.BLANK;
									String strengthsEmp = StringPool.BLANK;
									String strengthsMan = StringPool.BLANK;
									String developmentEmp = StringPool.BLANK;
									String developmentMan = StringPool.BLANK;
									String careerEmp = StringPool.BLANK;
									String careerMan = StringPool.BLANK;
									String companyValue = StringPool.BLANK;
									String developmentPlan = StringPool.BLANK;
									if (getMasterObj != null) {
										accomplishmentsEmp = getMasterObj.getAccomplishmentsEmp();
										accomplishmentsMan = getMasterObj.getAccomplishmentsMan();
										strengthsEmp = getMasterObj.getStrengthsEmp();
										strengthsMan = getMasterObj.getStrengthsMan();
										developmentEmp = getMasterObj.getDevelopmentEmp();
										developmentMan = getMasterObj.getDevelopmentMan();
										careerEmp = getMasterObj.getCareerEmp();
										careerMan = getMasterObj.getCareerMan();
										companyValue = getMasterObj.getCompanyValue();
										developmentPlan = getMasterObj.getDevelopmentPlan();
									} else {
										accomplishmentsEmp = "";
										accomplishmentsMan = "";
										strengthsEmp = "";
										strengthsMan = "";
										developmentEmp = "";
										developmentMan = "";
										careerEmp = "";
										careerMan = "";
										companyValue = "";
										developmentPlan = "";
									}
								%>
								
								<aui:input label="Employee's Comments:"
									name="accomplishmentsEmp" type="textarea"
									value="<%=accomplishmentsEmp%>"
									placeholder="Employee's Comments"></aui:input>
							</div>
						</div>
						<%-- <div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
							<div class="form-group"> 
								<aui:input label="HR's Comments:" name="accomplishmentsMan"	disabled="true" value="<%=accomplishmentsMan %>"
									type="textarea" placeholder="HR's Comments"></aui:input>
							</div>
						</div> --%>
					</div>
				</div>
			</div>
		</div>

		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading ">Strengths / Development Areas</div>
				<div class="panel-body ">
					<div class="col-xs-12 col-md-12 ">

						<div class="col-md-12 col-sm-6 col-xs-12 margintop10 paddingleft0">
							<div class="form-group">
								<aui:input label="Employee's Comments on Strengths:"
									name="strengthsEmp" type="textarea" value="<%=strengthsEmp %>"
									placeholder="Employee's Comments"></aui:input>
							</div>
						</div>
						<%-- <div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
							<div class="form-group">
								<aui:input label="HR's Comments on Strengths:" disabled="true" value="<%=strengthsMan %>"
									name="strengthsMan" type="textarea" placeholder="HR's Comments"></aui:input>
							</div>
						</div> --%>

					</div>
					<div class="col-xs-12 col-md-12 ">

						<div class="col-md-12 col-sm-6 col-xs-12 margintop10 paddingleft0">
							<div class="form-group">
								<aui:input label="Employee's Comments on Development Areas:"
									name="developmentEmp" type="textarea" value="<%=developmentEmp %>"
									placeholder="Employee's Comments"></aui:input>

							</div>
						</div>
						<%-- <div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
							<div class="form-group">
								<aui:input label="HR's Comments on Development Areas:"
									name="developmentMan" type="textarea" disabled="true" value="<%=developmentMan %>"
									placeholder="HR's Comments"></aui:input>
							</div>
						</div> --%>

					</div>
				</div>
			</div>
		</div>

		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading ">Career Plan</div>
				<div class="panel-body ">
					<div class="col-xs-12 col-md-12 ">

						<div class="col-md-12 col-sm-6 col-xs-12 margintop10 paddingleft0">
							<div class="form-group">
								<aui:input label="Employee's Comments:" name="careerEmp" value="<%=careerEmp %>"
									type="textarea" placeholder="Employee's Comments"></aui:input>
							</div>
						</div>
						<%-- <div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
							<div class="form-group">
								<aui:input label="HR's Comments:" disabled="true" name="careerMan" value="<%=careerMan %>"
									type="textarea" placeholder="HR's Comments"></aui:input>
							</div>
						</div> --%>

					</div>
				</div>
			</div>
		</div>

		<%-- <div class="col-xs-12 col-md-12 ">
			<div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingleft0">
				<div class="form-group">
					<aui:input label="Famocom Values :" name="companyValue" disabled="true" value="<%=companyValue %>"
						type="textarea" placeholder="HR's Comments"></aui:input>
				</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12 margintop10 paddingright0">
				<div class="form-group">
					<aui:input label="Development Plan :" name="developmentPlan" disabled="true" value="<%=developmentPlan %>"
						type="textarea" placeholder="HR's Comments"></aui:input>
				</div>
			</div>

		</div> --%>

	</div>
</div>