<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.famocom.erpcloud.inword.NumberToWordsConverter"%>
<%@page import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/view.jsp");
	
	long milestoneId = ParamUtil.getLong(request,"milestoneId");
	String projectName = ParamUtil.getString(request,"projectName",StringPool.BLANK);
	String clientName = ParamUtil.getString(request,"clientName",StringPool.BLANK);
	String dueDate = ParamUtil.getString(request,"dueDate",StringPool.BLANK);
	double amount = ParamUtil.getDouble(request,"amount");
	String status = ParamUtil.getString(request,"status",StringPool.BLANK);
	long clientId = ParamUtil.getLong(request, "clientId");
	ClientMaster clientDetails =null;
	Milestone milestoneDetails=null;
	if(Validator.isNotNull(clientId)){
		try{
			clientDetails=ClientMasterLocalServiceUtil.getClientMaster(clientId);
		}catch(Exception e){
			
		}
	}
	
	if(Validator.isNotNull(milestoneId)){
		try{
			milestoneDetails=MilestoneLocalServiceUtil.getMilestone(milestoneId);
		}catch(Exception e){
			
		}
	}
	
	int gst=18;
	int cgst = gst/2;
	int sgst=gst/2;
	int cgstTotal =0;
	int amountTotal=(int)amount;
	//Double totalAmaoun=new Double(amount);
	/* out.println("cgstTotal:-"+amountTotal);
	out.println("amountTotal:-"++"cgst"+cgst); */
	cgstTotal = (amountTotal*cgst/100);
	int sgstTotal = (amountTotal*sgst/100);
	//out.println("cgstTotal:-"+cgstTotal+"sgstTotal:-"+sgstTotal);
	int gstAmount=0;
	int dueAmount=0;
	if(milestoneDetails.getCheckGST()==1){
		gstAmount=amountTotal-(cgstTotal+sgstTotal);
		dueAmount=amountTotal;
	}else{
		gstAmount=amountTotal;
		dueAmount=amountTotal+(cgstTotal+sgstTotal);
	}
	
%>







<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PDF Codes</title>

    <style>
	
	body{font-family:'Helvetica Neue','Helvetica',Helvetica,Arial,sans-serif;text-align:center;color:#777;}
	
	p,span { padding:0px; margin:0px;}
	
	body h1{font-weight:300;margin-bottom:0px;padding-bottom:0px;color:#000;}
	
	body h3{font-weight:300;margin-top:10px;margin-bottom:20px;font-style:italic;color:#555;}
	
	body a{color:#06F;}
	
	.invoice-box{ padding:30px; border:1px solid #eee;box-shadow:0 0 10px rgba(0,0,0,.15); 
	font-size:16px;line-height:24px;font-family:'Helvetica Neue','Helvetica',Helvetica,Arial,sans-serif;color:#555;}
	
	.invoice-box table{width:100%;line-height:inherit;}
		
	
	.invoice-box table tr td{padding:15px 0px; vertical-align:middle; text-align:left;}
	
	
	
	.invoice-box table tr.top table td{padding-bottom:20px;}
	
	.invoice-box table tr.top .title{font-size:40px;line-height:45px;color:#808080; vertical-align:middle; font-weight:800;}
	

	.invoice-box table tr.information .invoice-no { font-weight:800; font-size:12px;}

	
	.invoice-box table.detailsTable tr td { text-align:center; padding:10px 0px;} 
	
	.invoice-box table.detailsTable tr.rowheader { background:#333333;}  
	
	.invoice-box table.detailsTable tr.rowheader td { color:#fff;}
	
	
	
		
	</style>
</head>

<body>
<div class="col-md-12 col-sm-12 col-xs-12 pull-center ">
<h3 id="header">Billing <a href="<%=backURL.toString() %>" class="btn btn-danger btn-circle pull-right  mcmin8">Back</a></h3>
</div>
<div class="invoice-box">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr class="top">
            <td align="left" class="" ><strong><span style="font-size:24px; font-weight:800;">Famocom Technology Systems Private Limited</span></strong><br>
            <span>The Complete IT Solution...</span></td>
            
            <td align="right" class="title">Invoice</td>
        </tr>
        
        
         <tr class="information">
            <td align="left">
                 2/15 CHINAR PARK, NEW TOWN<br>
                 Kolkata, West Bengal 700157<br>
                Phone [+91 033-123456780], Fax [+91 033-123456780]
            </td>
            
            <td align="right" class="invoice-no">
                <p>INVOICE NO *****</p>
                <p>DATE: ***** </p>
            </td>
    	</tr>
        
        
        
        <tr class="BillingShippingAddress">
            <td align="left">
            	<strong>Billing Address</strong><br>
                <%=clientDetails.getClientName() %><br>
                <%=clientDetails.getBillingAddress()%><br>
               <%=clientDetails.getContactNumber()%>
            </td>
    	</tr>
        
        
        <tr class="detailsTableRow">
            <td align="left" colspan="2">
            
            	<table width="100%" class="detailsTable"  border="1" bordercolor="#333333" style="border-collapse:collapse;" cellspacing="0" cellpadding="0">
                      <tr class="rowheader">
                        <td>Project Name</td>
                        <td>Milestone Name</td>
                        <td>Client</td>
                        <td>AMOUNT</td>
                      </tr>
                      
                      <tr>
                        <td><%=projectName %></td>
                        <td><%=milestoneDetails.getMilestoneName() %></td>
                        <td><%=clientDetails.getClientName() %></td>
                        <td><%=gstAmount%></td>
                      </tr>
                    
                      
                       <tr>
                        <td colspan="3" style="text-align:right; padding-right:10px;">CGST(<%=cgst %>%) </td>
                        <td><%=cgstTotal %></td>
                      </tr>
                      <tr>
                        <td colspan="3" style="text-align:right; padding-right:10px;">SGST(<%=sgst %>%) </td>
                        <td><%=sgstTotal %></td>
                      </tr>
                      <tr>
                        <td colspan="3" style="text-align:right; padding-right:10px;">IGST </td>
                        <td></td>
                      </tr>
                      
                      
                      <tr>
                        <td colspan="3" style="text-align:right; padding-right:10px;">Total Due</td>
                        <td><%=dueAmount %></br>(<%=NumberToWordsConverter.convert(dueAmount) %>)</td>
                      </tr>
                      
				</table>

            
            </td>	
    	</tr>
        
       
       <tr class="">
            
            <td align="left" colspan="2">
                Make All cheques payable to <strong>Famocom Technology Systems Private Limited</strong><br>
                <!-- if you have any questions concerning this invoice, contact [Name], [Phpne Number], [Email] -->
            
            </td>
            
    	</tr>
        
        
       <tr class="">
            
            <td align="left" style="text-align:center;" colspan="2">THANK YOUR FOR YOUR BUSINESS</td>
            
    	</tr>
        
        
    </table>

</div>

</body>
</html>
