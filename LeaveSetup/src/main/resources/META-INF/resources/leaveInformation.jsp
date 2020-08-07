<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />
<aui:row>
	<aui:col span="6"></aui:col>
	<aui:col span="6">
		<h3>Encashment</h3>
	</aui:col>
</aui:row>
<aui:row>

	<aui:col span="6">

		<aui:input name="leaveName" type="text" label="Leave Name"
			value="<%=leave!=null ? leave.getLeaveName() :"" %>"
			placeholder="Name">
			<aui:validator name="required" />
			<aui:validator name="custom"
				errorMessage="You can only write Alphabets">
                                    function (val, fieldNode, ruleValue)
                                       {
                                           var result = true;
                                           var pattern=/[^a-z|^A-Z|^\s]/;
                                          var check = val.match(pattern);
                                          if(check!=null)
                                         {
                                            result=false;
                                          }
                                          val=$.trim(val);
                                         $("#<portlet:namespace />leaveName").val(val);
                                      return result;
                                        }
                            </aui:validator>
		</aui:input>

		<aui:input label="Abbreviation" name="abb " type="text"
			value="<%=leave!=null?leave.getAbb() :"" %>" 
			placeholder="Abbreviation">
			<aui:validator name="required" />
			<aui:validator name="custom"
				errorMessage="You can only write Alphabets">
                                    function (val, fieldNode, ruleValue)
                                       {
                                           var result = true;
                                           var pattern=/[^a-z|^A-Z|^\s]/;
                                          var check = val.match(pattern);
                                          if(check!=null)
                                         {
                                            result=false;
                                          }
                                          val=$.trim(val);
                                         $("#<portlet:namespace />abb").val(val);
                                      return result;
                                        }
                            </aui:validator>
		</aui:input>

	</aui:col>
	<aui:col span="6">
		<aui:input name="forwardDay" type="text"
			value="<%=leave!=null?leave.getForwardDay() :"" %>"
			onchange="myFunction(this.value)"
			label="Max Carry forward at year end" placeholder="Days">
			<aui:validator name="required" />
			<aui:validator name="digits"></aui:validator>
		</aui:input>
		<aui:input name="encashmentDay" type="text"
			value="<%=leave!=null?leave.getEncashmentDay() :"" %>"
			onchange="myFunction(this.value)" label="Max Days Encashable"
			placeholder="Days">
			<aui:validator name="required" />
			<aui:validator name="digits"></aui:validator>
		</aui:input>
		<aui:input name="encashmentDayPer" type="text"
			value="<%=leave!=null?leave.getEncashmentPer() :"" %>"
			label="Encashable Formula(% of basic)" placeholder="% of basic">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="required" />
			<aui:validator name="max" errorMessage="Range Upto 100">100</aui:validator>
		</aui:input>
	</aui:col>
</aui:row>