<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%

%>

<div>
	
		<aui:row>
			<aui:row>
				<aui:col span="5">
					<aui:select name="projectName" label="Project Name" id="frequency" required="true">
					
					 <option value="" selected>None</option>
						
						<aui:option value=""></aui:option>
						
						
					</aui:select>
				</aui:col>
				<aui:col span="5">
					<aui:select name="expenseCategory" label="Expense Category" id="frequency" required="true">
					 <option value="" selected>None</option>
						
						<aui:option value="1">Daily</aui:option>
						<aui:option value="2">Weakly</aui:option>
						<aui:option value="3">Monthly</aui:option>
						<aui:option value="4">Yearly</aui:option>
						
					</aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="5">
					<aui:input type="text" name="title" id="exp_cat_name" placeholder="Title" value=""
					               label="Title" >
					 
					</aui:input>
				</aui:col>
				<aui:col span="5">
				 
         
					<aui:input type="textarea" name="description" id="exp_cat_name" placeholder="Description" value=""
					               label="Description" >
					 
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="5">
					<aui:input type="text" name="entryDate" id="txtDate_id" placeholder="Date" value=""
					               label="Date" >
					
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input type="text" name="amount" id="exp_cat_name" placeholder="Amount" value=""
					               label="Amount" >
					 
					</aui:input>
				</aui:col>
			</aui:row>
		 
		    <aui:row> 
				<aui:col span="8"> 
				    <%-- <liferay-ui:panel-container extended="true" id="outerPanelContainer">
				    <liferay-ui:panel collapsible="true" defaultState="collapsed"  title="Upload supported documents" >
				       <p class="content toggler-content-collapsed">
				        outer content </p>
				        <liferay-ui:panel-container extended="false" id="innerPanelContainer">
				            <liferay-ui:panel collapsible="true" defaultState="collapsed" extended="false" title="January"> --%>
				           
				                <input type="file" name="uploadedFile">
				      <aui:input type="text" name="Document_name" id="exp_cat_name" placeholder="Document name" value=""
					               label="Document name" >
					 
					</aui:input>
				            <%-- </liferay-ui:panel>
				       </liferay-ui:panel-container>
				    </liferay-ui:panel>
				</liferay-ui:panel-container> --%>
					
				 </aui:col>
				<aui:col span="4">
					<aui:button type="submit" id="save" name="save"></aui:button>
					<button class="btn btn-danger" type="button" name="reset">Cancel</button>
				</aui:col>
			 </aui:row> 
		</aui:row>
			
	

</div>