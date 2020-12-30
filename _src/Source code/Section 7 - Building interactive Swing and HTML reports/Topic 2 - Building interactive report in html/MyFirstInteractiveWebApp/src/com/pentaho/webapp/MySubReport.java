package com.pentaho.webapp;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.pentaho.reporting.engine.classic.core.modules.output.table.html.HtmlReportUtil;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;

public class MySubReport extends HttpServlet 
{
	private static final long serialVersionUID = 7132989867106106400L;

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ClassicEngineBoot.getInstance().start();

		ResourceManager manager = new ResourceManager();
		manager.registerDefaults();
		String reportPath = "/home/pentaho/workspace/MyFirstInteractiveWebApp/resources/subreport.prpt";
		Resource res = null;
		MasterReport report = null;
		try {
			res = manager.createDirectly(new File(reportPath),MasterReport.class);
			report = (MasterReport) res.getResource();
			report.getParameterValues().put("PRODUCTLINE", request.getParameterValues("productline"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		try 
		{
			response.setContentType("text/html");
			HtmlReportUtil.createStreamHTML(report, response.getOutputStream());
		} 
		catch (ReportProcessingException e) 
		{
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}