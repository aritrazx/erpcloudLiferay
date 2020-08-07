
<%@page import="java.sql.Array"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.PayComponentLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.PayComponent"%>
<%@page import="Payroll.constants.PayrollPortletKeys"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<%


 // Organization org = OrganizationLocalServiceUtil.getOrganization(u.getOrganizationIds(includeAdministrative));


	PortletURL payComponentURL = renderResponse.createActionURL();
	payComponentURL.setParameter("javax.portlet.action", "addPayComponent");	
	String payComponentId = ParamUtil.getString(request, "payComponentId"); 
	PayComponent payComponent =null;
	String name = StringPool.BLANK;
	String abbreviation = StringPool.BLANK;
	String effectiveDate = StringPool.BLANK;
	String partOfCTC  = StringPool.BLANK;
	String payType = StringPool.BLANK;
	long paySlipOrder = 0;
	boolean taxStatus = false;
	List<PayComponent> componentList = PayComponentLocalServiceUtil.getPayComponents(-1, -1); 
	//int[] payOrder = componentList.size();
	long payOrder[]=new long[componentList.size()];	
	int iscomponentType = 0;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	boolean isEdited = false;
	boolean isAutoAddComponent = false;
	String formula = StringPool.BLANK;
	String payAmount = StringPool.BLANK;
	if(Validator.isNotNull(payComponentId)){
			payComponent = PayComponentLocalServiceUtil.getPayComponent(Long.valueOf(payComponentId));
			if(Validator.isNotNull(payComponent)){
				isEdited = true;
				payAmount = String.valueOf(payComponent.getAmount());
				name = payComponent.getName();
				abbreviation = payComponent.getAbbreviation();
				effectiveDate = sdf.format(payComponent.getEffectiveDate());
				paySlipOrder = payComponent.getPayComponentOrder();
				//partOfCTC = payComponent.getPartOfCtc();
				  if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Deduction)){
					  payType = PayrollPortletKeys.Deduction;
				  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Earning)){
					  payType = PayrollPortletKeys.Earning;
				  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Overtime)){
					  payType = PayrollPortletKeys.Overtime;
				  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.Reimbursement)){
					  payType = PayrollPortletKeys.Reimbursement;
				  }else if(payComponent.getPayType().equalsIgnoreCase(PayrollPortletKeys.StatutoryComponent)){
					  payType = PayrollPortletKeys.StatutoryComponent;
				  }
				if( payComponent.getTaxStatus()==1){
					taxStatus = true;
				}
				if(payComponent.getComponentType()==1){
					iscomponentType = 1;
					formula = payComponent.getComponentValueFormula();
					
					int i=0;
					if(componentList.size()>0){
						for(PayComponent pc:componentList){
							if(formula.contains(pc.getComponentId()+"_")){
								formula = formula.replaceAll(pc.getComponentId()+"_", pc.getName());
							}
							payOrder[i]= pc.getPayComponentOrder();
						}
						
					}
					System.out.println("payOrder lengh  "+payOrder.length);
				}
				if(payComponent.getAutoAddPayStructure()==1){
					isAutoAddComponent = true;
				}
				
			}
			
		//payType = payComponent.getPayType();
		
	}
	
	Map<String,String> payTypeList = new HashMap<String,String>();
	
	
	payTypeList.put(PayrollPortletKeys.Deduction, PayrollPortletKeys.DEDUCTION);
	payTypeList.put(PayrollPortletKeys.Earning, PayrollPortletKeys.EARNING);
	payTypeList.put(PayrollPortletKeys.Overtime, PayrollPortletKeys.OVERTIME);
	payTypeList.put(PayrollPortletKeys.Reimbursement, PayrollPortletKeys.REIMBURSEMENT);
	payTypeList.put(PayrollPortletKeys.StatutoryComponent, PayrollPortletKeys.STATUTORYCOMPONENT);
	
	PortletURL monthlyAdjustment = renderResponse.createRenderURL();
	monthlyAdjustment.setParameter("jspPage", "/monthlyAdjustment.jsp");
	
	PortletURL stopPayUrl = renderResponse.createRenderURL();
	stopPayUrl.setParameter("jspPage", "/StopPayList.jsp");
	PortletURL viewURL = renderResponse.createRenderURL();	
	viewURL.setWindowState(LiferayWindowState.POP_UP);
	viewURL.setParameter("jspPage", "/createFormula.jsp");
	String popupview = "javascript:popupview('"+ viewURL.toString()+"');";

	 PortletURL taxSettingURL = renderResponse.createRenderURL();
	 taxSettingURL.setParameter("jspPage", "/taxSetting.jsp");
	  PortletURL backURL = renderResponse.createRenderURL();
	    backURL.setParameter("jspPage","/view.jsp"); 
	    PortletURL viewTaxSlabListURL = renderResponse.createRenderURL();
	    viewTaxSlabListURL.setParameter("jspPage", "/taxSlabList.jsp");
	    List<String> erList = new ArrayList<String>();
	   if(null!=request.getAttribute("errorList")){
		   erList = (List<String>) request.getAttribute("errorList");
	   }
%>

<liferay-ui:error key="name-error"  message="Pay Component All ready exist with this Name!" ></liferay-ui:error>
<liferay-ui:error key="abbreviation-error"  message="Abbreviation All ready exist with this Name!" ></liferay-ui:error>
 
<%--  
  <aui:row>
<aui:col span="8">
<label><h2></h2></label>
</aui:col>
<aui:col span="2">
<a class="btn btn-primary btn-default" href="<%= stopPayUrl.toString()%>"  >Stop Pay</a>
</aui:col>

<aui:col span="2">
<a class="btn btn-primary btn-default" href="<%= monthlyAdjustment.toString()%>"  >Monthly Adjustment</a>
</aui:col>  
</aui:row>  --%>


<div id="erDiv" tabindex="0" class="message_error divLft"
	<%if (!erList.isEmpty() && erList.size() > 0) {%>
	style="display: inline; width: 100%;" <%} else {%>
	style="display: none;" <%}%>>
	<table>
		<%
			if (!erList.isEmpty() && erList.size() > 0) {
				/* erList = erList.substring(1, erList.length() - 1);
				String erArray[] = erList.split(","); */
				for (String str:erList) {
		%>
		<tr>
			<td><font color="red" ><%=str%></font> </td>
		</tr>
		<%
			}
			}
		%>
	</table>
</div>
<liferay-ui:header title="Back" backLabel="Back" backURL="<%=backURL.toString()%>" />
<aui:form action="<%=payComponentURL.toString()%>" name="payComponent" >
		<label >Name<span class="mandatory" >* </span></label>
       <aui:input name="name"  label="" value="<%=name %>"  >
       <aui:validator name="required" errorMessage="Please enter a Component Name!" ></aui:validator>
            <aui:validator name="custom"
							errorMessage="Please enter only Alphabet!">
                             function (val, fieldNode, ruleValue){
                                var result = true;
                                var pattern=/[^a-z|^A-Z|^\s]/;
                                var check = val.match(pattern);
                                if(check!=null||check==''){
                                     result=false;
                                }
                                val=$.trim(val);
                                $("#<portlet:namespace />name").val(val);
                                return result;
                             }
                       </aui:validator>
       </aui:input>
       <label >Abbreviation<span class="mandatory" >* </span></label>
      
       <aui:input name="abbreviation"  required="true"  disabled="<%=isEdited==true %>" label=""  value="<%=abbreviation %>">
              <aui:validator name="required" errorMessage="Please enter a Abbreviation!" />
              <aui:validator name="alpha" />
       </aui:input>
       
       <aui:input type="text" name="effectiveDate" id="txtToDate_id" value="<%=effectiveDate %>" label="Effective Date" readonly="readonly">
       </aui:input>
       <label>Pay Type<span class="mandatory" >* </span></label>
       <aui:select name="payType" label="" >
       	    <aui:option value="">Select</aui:option>
       	    <% for(Map.Entry<String,String> entry : payTypeList.entrySet()){       	    	
       	 if(isEdited){
             %>
       	    	 <aui:option value="<%=entry.getKey() %>" selected="<%=payType.equalsIgnoreCase(entry.getKey()) %>" ><%=entry.getValue() %></aui:option>
       	    	<%}else {%> 
       	    	<aui:option value="<%=entry.getKey() %>"  ><%=entry.getValue() %></aui:option>
       	   <%} }%>
		 
	   </aui:select>	
			
		<aui:field-wrapper name="Tax Status">
			<aui:input inlineLabel="right" name="taxStatus" type="radio" value="1" checked="<%=taxStatus==true %>" label="Taxable" />
			<aui:input checked="<%= taxStatus==false %>" inlineLabel="right" name="taxStatus" type="radio" value="0" label="NonTaxable"  />
		</aui:field-wrapper>
	
		<aui:field-wrapper name="Type Of Component">
			<aui:input inlineLabel="right" name="typeOfComponent" type="radio" checked="<%=iscomponentType==1 %>" onClick="getComponent(this.value)" value="1" label="Variable Component" />
			<aui:input checked="<%=iscomponentType==0 %>" inlineLabel="right" name="typeOfComponent" type="radio" onClick="getComponent(this.value)" value="0" label="Fixed Component"  />
		</aui:field-wrapper>
			
			<div id="variableComponent" >
			<%-- 
			<liferay-ui:icon  url="<%=popupview%>" label="true" message="Create Formula" image="view"/>
		<button class="btn btn-primary chooseBtn" onclick="showCreateClient('<%= clientsView.toString() %>')" type="button"></button> --%>
		<aui:button name="button" type="button" value="Create Formula" onclick="<%= popupview.toString() %>" />
		<aui:input type="hidden" name="formulla" id="formulla" label="Formula" readOnly="true" value="" > </aui:input>
		<aui:input type="text" name="formullaText" id="formullaText" label="Formulla" readOnly="true"  value="<%= formula%>" > </aui:input>
			</div>
			
	      <div id="fixedComponent" >
	       <label>Value </label>
			<aui:input type="text" name="payAmmount"  id="payAmmount" value="<%=payAmount %>" label="" >
			  <aui:validator name="number" /> </aui:input>
			</div>
			
		  <aui:select name="paySlipOrder" label="Pay Slip Order" id="paySlipOrder" > 
		  <% long j = 0;
		  for(long i=1;i<=payOrder.length;i++) {%>
		   <aui:option value="<%=i %>"selected="<%=i==paySlipOrder %>"  ><%=i %></aui:option>
		   <% j=i;}j=j+1; %>
		   <aui:option value="<%=j %>" ><%=j %></aui:option>
		  
		  </aui:select>
			
		<%-- <aui:input type="text" name="paySlipOrder" id="paySlipOrder" value="<%=paySlipOrder %>" label="Pay Slip Order" > 
		<aui:validator name="digits"></aui:validator>disabled="true"
		</aui:input> --%>
		<aui:input type="hidden" name="payComponentId" id="payComponentId" value="<%=payComponentId %>" > </aui:input>
				
		<%-- <aui:input type="checkbox" checked="<%=isPartOfCTC==true %>" name="partOfCTC" value="1"   label="Part Of CTC" ></aui:input> --%>
		<aui:input type="checkbox" checked="<%=isAutoAddComponent==true %>" disabled="<%=isAutoAddComponent==true %>"  name="autoAddComponent" value="1"   label="Auto add on existing Pay Structure" ></aui:input>
		
		<%if(Validator.isNull(payComponentId)) {%>
		<aui:button type="submit" value="Add"  > </aui:button>
		<%}else{ %>
		<aui:button type="submit" value="Update"  > </aui:button>
		<%} %>
		
</aui:form>	

<script>
 
$(document).ready(function() {
	
	var comp  = '<%=iscomponentType%>';
	//alert(comp);
	var compValue;
	if(comp==1){		
		compValue =1;
		//alert("if "+compValue);
	}else{
		compValue =0
		$('#variableComponent').hide();
		//alert("else.."+compValue);		
	}
	//alert(compValue);
	getComponent(compValue);
	selectFormula = function(formulla,formullaText) {

		$('#<portlet:namespace />formulla').val(formulla);
		$('#<portlet:namespace />formullaText').val(formullaText);
	};
});
	AUI().use('aui-datepicker', function(A) {
		var dfg=new A.DatePicker({
			trigger : '#<portlet:namespace />txtToDate_id',
			mask : '%d/%m/%Y',
			
			popover : {
			zIndex : 1000
			}, calendar: {
			     
			  }
		});
	});

	AUI().ready('alloy-node', 'aui-form-validator', function(A) {
		   var formValidator = new A.FormValidator({
		       boundingBox: document.<portlet:namespace />payComponent,
		       rules: {
		           <portlet:namespace />payType: {
		               required: true
		           }
		       },
		       fieldStrings: {
		           <portlet:namespace />payType: {
		               required: 'Please select pay Type!'
		           }
		       },
		       on: {
		           validateField: function(event) {},
		           validField: function(event) {},
		           errorField: function(event) {},
		           submitError: function(event) {
		               var errors = event.validator.errors;
		               event.preventDefault();
		           },
		           submit: function(event) {
		               return false;
		           }
		       }
		   });
		}); 
	
	function popupview(url) {
		Liferay.Util.openWindow(

		{

			dialog : {

				//cssClass: 'aui-popup-example',

				destroyOnHide : true,

				height : 500,

				width : 700

			},

			dialogIframe : {

			//bodyCssClass: 'custom-css-class'

			},

			title : 'Create Formula',

			uri : url

		}

		);

	}
	
	function getComponent(comp){
		//alert(comp);
		if(comp==1){
			$('#variableComponent').show();	
			
			$('#fixedComponent').hide();
		}else{
			$('#variableComponent').hide();	
			
		
			$('#fixedComponent').show();
		}
	}
</script>



	
<style>
.mandatory{
	color: red;
	font-size: 22px;
}
</style>