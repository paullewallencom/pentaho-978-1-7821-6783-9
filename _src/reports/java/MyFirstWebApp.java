import java.net.URL;
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfReportUtil;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;




	ClassicEngineBoot.getInstance().start();
	  
	ResourceManager manager = new ResourceManager();
	manager.registerDefaults();
	String reportPath = "file:///home/pentaho/Desktop/reports/my%20first%20report%202.prpt";
	Resource res = null;
	MasterReport report = null;
	try 
	{
		res = manager.createDirectly(new URL(reportPath), MasterReport.class);
		report = (MasterReport) res.getResource();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
      
	response.setContentType("application/pdf");
	PdfReportUtil.createPDF(report, response.getOutputStream());

