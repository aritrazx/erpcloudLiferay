package com.liferay.famocom.erpcloud.salaryregister.util;

import java.io.FileNotFoundException;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.liferay.portal.kernel.util.PortalUtil;
public  class HtmlToPdf {
	//private final static HtmlToPdf instance = new HtmlToPdf();

	public boolean createPDFfromHTML(Map<String, String> keyValues, String templateFile, String outputFile,ResourceResponse resourceResponse,String panNo,String fileName) {
		final String USER_PASS = panNo;
		final String OWNER_PASS = "Owner123";
		Path pathToFile = Paths.get(outputFile);
		try {
			Files.createDirectories(pathToFile.getParent());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean success = false;

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			String pdfContent = IOUtils.toString(classLoader.getResourceAsStream(templateFile));

			for (Map.Entry<String, String> entry : keyValues.entrySet()) {
				if (entry.getKey() != null) {
					if (entry.getValue() != null) {
						pdfContent = pdfContent.replace("[" + entry.getKey() + "]", entry.getValue());
					} else {
						pdfContent = pdfContent.replace("[" + entry.getKey() + "]", "");
					}
				}
			}

			InputStream in = IOUtils.toInputStream(pdfContent, "UTF-8");
			Document document = new Document();
			/*PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
			writer.setInitialLeading(12.5f);
			document.open();
			
		*/
			/*resourceResponse.setContentType("application/pdf");
			PdfWriter writer = PdfWriter.getInstance(document, resourceResponse.getPortletOutputStream());
			writer.setInitialLeading(12.5f);
			writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
					PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
			document.open();*/
			
			
			   HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
			   httpResponse.setContentType("application/pdf");
			   httpResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			   ServletOutputStream out = httpResponse.getOutputStream();
			   PdfWriter writer = PdfWriter.getInstance(document,out);			 
			   writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
						PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
			   document.open();
			final TagProcessorFactory tagProcessorFactory = Tags.getHtmlTagProcessorFactory();
			tagProcessorFactory.removeProcessor(HTML.Tag.IMG);
			tagProcessorFactory.addProcessor(new ImageTagProcessor(), HTML.Tag.IMG);
			final CssFilesImpl cssFiles = new CssFilesImpl();
			cssFiles.add(XMLWorkerHelper.getInstance().getDefaultCSS());
			final StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver(cssFiles);
			final HtmlPipelineContext hpc = new HtmlPipelineContext(new CssAppliersImpl(new XMLWorkerFontProvider()));
			hpc.setAcceptUnknown(true).autoBookmark(true).setTagFactory(tagProcessorFactory);
			final HtmlPipeline htmlPipeline = new HtmlPipeline(hpc, new PdfWriterPipeline(document, writer));
			final Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
			final XMLWorker worker = new XMLWorker(pipeline, true);
			final Charset charset = Charset.forName("UTF-8");
			final XMLParser xmlParser = new XMLParser(true, worker, charset);
			xmlParser.parse(in, charset);
			
//			XMLWorkerHelper.getInstance().parseXHtml(writer, document, in);

			document.close();
			/* out.flush();
			   out.close();*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return success;
	}

}
