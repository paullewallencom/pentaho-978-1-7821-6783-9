package com.pentaho.test.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JOptionPane;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.PreviewDialog;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.event.ReportActionEvent;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.event.ReportActionListener;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.event.ReportHyperlinkEvent;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.event.ReportHyperlinkListener;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.event.ReportMouseEvent;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.event.ReportMouseListener;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;

public class MyFirstInteractiveSwingApp1 
{
	final static String projectBasePath = "/home/pentaho/workspace/MyFirstInteractiveSwingApp";

	/**
	 * Create a new report.
	 * 
	 * @return
	 */
	public static MasterReport createReport(String path) 
	{
		ResourceManager manager = new ResourceManager();
		manager.registerDefaults();

		Resource res;
		MasterReport report = null;
		try 
		{
			res = manager.createDirectly(new File(path), MasterReport.class);
			report = (MasterReport) res.getResource();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return report;
	}

	/**
	 * Main method.
	 * 
	 * @return
	 */
	public static void main(String args[]) 
	{
		ClassicEngineBoot.getInstance().start();

		String reportPath = projectBasePath + "/resources/my first interactive report.prpt";
		final PreviewDialog dashboard = new PreviewDialog(createReport(reportPath));

		dashboard.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(final WindowEvent event) 
			{
				dashboard.dispose();
			}
		});

		/*
		 * Listener invoked by pressing the Action label on the report.
		 */
		dashboard.getPreviewPane().getReportPreviewArea().addReportActionListener(
			new ReportActionListener() 
			{
				@Override
				public void reportActionPerformed(ReportActionEvent event) 
				{
					JOptionPane.showMessageDialog(null,"Action: " + event.getActionParameter());
				}
			}
		);

		/*
		 * Listener invoked by pressing the Link image on the report.
		 */
		dashboard.getPreviewPane().addReportHyperlinkListener(
			new ReportHyperlinkListener() 
			{
				@Override
				public void hyperlinkActivated(ReportHyperlinkEvent event) 
				{
					JOptionPane.showMessageDialog(null,"Url: " + event.getTarget());
				}
			}
		);

		/*
		 * Listener invoked by clicking the Button label on the report.
		 */
		dashboard.getPreviewPane().getReportPreviewArea().addReportMouseListener(
			new ReportMouseListener() 
			{
				@Override
				public void reportMouseReleased(ReportMouseEvent arg0) 
				{
					// TODO Auto-generated method stub
				}

				@Override
				public void reportMousePressed(ReportMouseEvent event) 
				{
					if (event.getSourceNode().getName() != null && event.getSourceNode().getName().equals("button1")) 
					{
						JOptionPane.showMessageDialog(null, "Pressed: " + event.getSourceNode().getName());
					}
				}

				@Override
				public void reportMouseMoved(ReportMouseEvent arg0) 
				{
					// TODO Auto-generated method stub
				}

				@Override
				public void reportMouseDragged(ReportMouseEvent arg0) 
				{
					// TODO Auto-generated method stub
				}

				@Override
				public void reportMouseClicked(ReportMouseEvent arg0) 
				{
					// TODO Auto-generated method stub
				}
			}
		);

		dashboard.pack();
		dashboard.setVisible(true);
	}
}