import java.awt.EventQueue;

import javax.swing.JFrame;
import mysql.*;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class MainWindow {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton patient = new JButton("Patient");
		patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				patient window2 = new patient();
				window2.frame.setVisible(true);
			}
		});
		patient.setBackground(new Color(95, 158, 160));
		patient.setForeground(new Color(0, 128, 0));
		patient.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		patient.setBounds(161, 104, 124, 38);
		frame.getContentPane().add(patient);
		
		JButton settings = new JButton("Settings");
		settings.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(settings);
		
		Button button = new Button("logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		button.setBounds(354, 227, 70, 22);
		frame.getContentPane().add(button);
	}
}
