<%@page import="com.liferay.famocom.erpcloud.inword.NumberToWordsConverter"%>
<%@page import="com.liferay.famocom.erpcloud.service.MilestoneLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.BillingLocalServiceUtil"%>
<%@page import="com.liferay.famocom.erpcloud.service.ClientMasterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.famocom.erpcloud.model.Billing"%>
<%@page import="com.liferay.famocom.erpcloud.model.Milestone"%>
<%@page import="com.liferay.famocom.erpcloud.model.ClientMaster"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	System.out.println("aaaaaaaaa");
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("jspPage", "/view.jsp");
	
	long billingId = ParamUtil.getLong(request, "billingId");
	long milestoneId = ParamUtil.getLong(request,"milestoneId");
	String projectName = ParamUtil.getString(request,"projectName",StringPool.BLANK);
	String clientName = ParamUtil.getString(request,"clientName",StringPool.BLANK);
	String dueDate = ParamUtil.getString(request,"dueDate",StringPool.BLANK);
	double amount = ParamUtil.getDouble(request,"amount");
	String status = ParamUtil.getString(request,"status",StringPool.BLANK);
	long clientId = ParamUtil.getLong(request, "clientId");
	ClientMaster clientDetails =null;
	Milestone milestoneDetails=null;
	Billing billing = null;;
	if(Validator.isNotNull(clientId)){
		try{
			clientDetails=ClientMasterLocalServiceUtil.getClientMaster(clientId);
			billing=BillingLocalServiceUtil.getBilling(billingId);
		}catch(Exception e){
			
		}
	}
	
	if(Validator.isNotNull(milestoneId)){
		try{
			milestoneDetails=MilestoneLocalServiceUtil.getMilestone(milestoneId);
		}catch(Exception e){
			
		}
	}
	//int total 
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





<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>

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
<center>
<div class="container fade-in" id="raiseBill">
<div class="main">
<div class="col-md-12 col-sm-12 col-xs-12 pull-center ">
    <h3 id="header">Billing <a href="<%=backURL.toString() %>" class="btn btn-danger btn-circle pull-right  mcmin8">Back</a></h3>
    <div class="modal-body newmd">
        
        <div class="table-responsive">
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
                <p>INVOICE NO: <%=billing.getBillingNumber() %></p>
                <p>DATE: <%=billing.getBillingDate() %> </p>
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
                      
                      
                     <%--  <tr>
                        <td colspan="3" style="text-align:right; padding-right:10px;">Sub Total</td>
                        <td><%=milestoneDetails.getAmount() %></td>
                      </tr> --%>
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
                if you have any questions concerning this invoice, contact [Name], [Phpne Number], [Email]
            
            </td>
            
    	</tr>
        
        
       <tr class="">
            
            <td align="left" style="text-align:center;" colspan="2">THANK YOUR FOR YOUR BUSINESS</td>
            
    	</tr>
    </table>
 <div  class="driver-list-detail-button clearfix">
        <a href="javascript:void(0);"id="downloadPdf" title=<%=projectName %>"RaiseBill" ><i class="fa fa-print"></i> Print</a>
 </div>
</div>
</div>
</div>
</div>
</div>
</div>
</center>

<script>
$(document).ready(function() {
    $('#downloadPdf').on('click', function() {
       $('#downloadPdf').hide();
       $('#header').hide();
        $('input').css('border-bottom','1px dotted #000');
        var pdf = new jsPDF('p', 'pt', 'a4');
        console.log(pdf.getFontList());
        pdf.addHTML($('#raiseBill')[0], function() {
            pdf.save($('#downloadPdf').attr('title')+'.pdf');
            $('#downloadPdf').show();
            $('#header').show();
            $('input').css('border-bottom','1px dotted #000');
        });
    });
   
});
</script>

<style>

body {
    margin: 0px;
    padding: 0px;
    font-family: Arial, Helvetica, sans-serif;
    margin-bottom: 5px;
    color:#000000;
/*     font-size: 0px; !important */
}
.main {
    width: 1000px;
    margin: 0px auto;
    padding: 20px;
    background: #fff;
}
#raiseBill {
    width: 100%;
    background-color: #fff;
    /* width: 800px; */
    margin: 0 auto;

    text-align: left;
}
</style>
</body>
</html>