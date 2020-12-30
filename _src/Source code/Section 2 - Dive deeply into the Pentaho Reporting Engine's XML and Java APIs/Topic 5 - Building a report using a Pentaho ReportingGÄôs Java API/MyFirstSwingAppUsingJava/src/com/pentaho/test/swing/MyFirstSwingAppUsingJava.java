package com.pentaho.test.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.ItemBand;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ReportFooter;
import org.pentaho.reporting.engine.classic.core.ReportHeader;
import org.pentaho.reporting.engine.classic.core.TableDataFactory;
import org.pentaho.reporting.engine.classic.core.elementfactory.LabelElementFactory;
import org.pentaho.reporting.engine.classic.core.elementfactory.NumberFieldElementFactory;
import org.pentaho.reporting.engine.classic.core.elementfactory.TextFieldElementFactory;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.PreviewDialog;

public class MyFirstSwingAppUsingJava
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
					// Starting the Pentaho Report engine's instance.
					ClassicEngineBoot.getInstance().start();

					// Creating an empty report.
					MasterReport report = new MasterReport();

					// Report header and footer.
					ReportHeader reportHeader = new ReportHeader();
					ReportFooter reportFooter = new ReportFooter();
					report.setReportHeader(reportHeader);
					report.setReportFooter(reportFooter);

					// Label for the header with the title.
					LabelElementFactory labelFactory = new LabelElementFactory();
					labelFactory.setText("MyFirstReport with Java API");
					labelFactory.setX(10f);
					labelFactory.setY(1f);
					labelFactory.setMinimumWidth(300f);
					labelFactory.setMinimumHeight(20f);
					labelFactory.setBold(true);
					reportHeader.addElement(labelFactory.createElement());
					reportFooter.addElement(labelFactory.createElement());

					// Table data.
					DefaultTableModel tableModel = new DefaultTableModel(
						new Object[][] {
								{"Product One",    92},
								{"Product Two",   116},
								{"Product Three", 132},
								{"Product Four",   45},
								{"Product Five",   11}
						},
						new String[] {"Name", "Quantity"}
					);
					final TableDataFactory dataFactory = new TableDataFactory();
					dataFactory.addTable("default", tableModel);
					report.setDataFactory(dataFactory);

					// Item band.
					ItemBand itemBand = new ItemBand();
					report.setItemBand(itemBand);

					// Name field.
					TextFieldElementFactory textFactory = new TextFieldElementFactory();
					textFactory.setFieldname("Name");
					textFactory.setX(1f);
					textFactory.setY(1f);
					textFactory.setMinimumWidth(100f);
					textFactory.setMinimumHeight(20f);
					itemBand.addElement(textFactory.createElement());

					// Quantity field.
					NumberFieldElementFactory numberFactory = new NumberFieldElementFactory();
					numberFactory.setFieldname("Quantity");
					numberFactory.setX(101f);
					numberFactory.setY(1f);
					numberFactory.setMinimumWidth(100f);
					numberFactory.setMinimumHeight(20f);
					itemBand.addElement(numberFactory.createElement());

					// Generating the report and preview it.
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