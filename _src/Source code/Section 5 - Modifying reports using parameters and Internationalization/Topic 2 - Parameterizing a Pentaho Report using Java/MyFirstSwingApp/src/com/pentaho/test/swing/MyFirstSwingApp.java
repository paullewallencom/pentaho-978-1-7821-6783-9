package com.pentaho.test.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.PreviewDialog;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;

public class MyFirstSwingApp 
{
	public static void main(String args[]) 
	{
		ClassicEngineBoot.getInstance().start();

		JFrame frame = new JFrame("MyFirstSwingApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("Press me!");

		MouseListener mouseListener = new MouseAdapter() 
		{
			public void mousePressed(MouseEvent mouseEvent) 
			{
				int modifiers = mouseEvent.getModifiers();
				if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) 
				{
					System.out.println("Left button pressed.");

					ResourceManager manager = new ResourceManager();
					manager.registerDefaults();
					Resource res = null;
					MasterReport report = null;
					try 
					{
						String reportPath = "/home/pentaho/workspace/MyFirstSwingApp/resources/my first report with parameter.prpt";
						res = manager.createDirectly(new File(reportPath), MasterReport.class);
						report = (MasterReport) res.getResource();
						report.getParameterValues().put("ProductVendorParameter", "Min Lin Diecast");
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}

					final PreviewDialog preview = new PreviewDialog(report);
					preview.addWindowListener(new WindowAdapter() 
					{
						public void windowClosing(final WindowEvent event) 
						{
							preview.setVisible(false);
						}
					});
					preview.pack();
					preview.setVisible(true);
				}
			}
		};

		button.addMouseListener(mouseListener);

		Container contentPane = frame.getContentPane();
		contentPane.add(button, BorderLayout.SOUTH);
		frame.setSize(300, 50);

		frame.setVisible(true);
	}
}