package com.pentaho.test.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFirstSwingApp1 
{
	public static void main(String args[]) 
	{
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