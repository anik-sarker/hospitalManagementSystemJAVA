import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import mysql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class addpatient extends methodClass {

	JFrame frame;
	private JTextField pname;
	private JTextField pdis;
	private JTextField pblood;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addpatient window = new addpatient();
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
	public addpatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(40, 31, 77, 23);
		frame.getContentPane().add(lblName);
		
		JLabel lblAdress = new JLabel("Adress :");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setForeground(Color.BLACK);
		lblAdress.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblAdress.setBounds(40, 92, 77, 23);
		frame.getContentPane().add(lblAdress);
		
		JLabel lblD = new JLabel("Disease :");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setForeground(Color.BLACK);
		lblD.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblD.setBounds(40, 141, 77, 23);
		frame.getContentPane().add(lblD);
		
		JLabel lblBlod = new JLabel("Blood :");
		lblBlod.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlod.setForeground(Color.BLACK);
		lblBlod.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblBlod.setBounds(40, 187, 77, 23);
		frame.getContentPane().add(lblBlod);
		
		pname = new JTextField();
		pname.setHorizontalAlignment(SwingConstants.LEFT);
		pname.setFont(new Font("Tahoma", Font.BOLD, 13));
		pname.setBounds(137, 31, 225, 28);
		frame.getContentPane().add(pname);
		pname.setColumns(10);
		
		pdis = new JTextField();
		pdis.setHorizontalAlignment(SwingConstants.LEFT);
		pdis.setFont(new Font("Tahoma", Font.BOLD, 13));
		pdis.setColumns(10);
		pdis.setBounds(137, 144, 225, 28);
		frame.getContentPane().add(pdis);
		
		pblood = new JTextField();
		pblood.setHorizontalAlignment(SwingConstants.LEFT);
		pblood.setFont(new Font("Tahoma", Font.BOLD, 13));
		pblood.setColumns(10);
		pblood.setBounds(137, 190, 95, 28);
		frame.getContentPane().add(pblood);
		
		JTextArea padd = new JTextArea();
		padd.setBounds(137, 78, 275, 48);
		frame.getContentPane().add(padd);
		
		JButton psave = new JButton("SAVE");
		psave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cname = pname.getText().toString();
				String cadd = padd.getText().toString();
				String cdis = pdis.getText().toString();
				String cblood = pblood.getText().toString();
				
				try{
					
					connector connect = new connector();
					
					Statement statement = connect.connector();
					
					String query = "insert into patient_info (pname,paddress,pdis,pblood) values('"+cname+"','"+cadd+"','"+cdis+"','"+cblood+"');";
					
					boolean allResult = statement.execute(query);
					
					if(allResult){
						msgbox("Network Error! Try Again");
					}else{
						msgbox("Patient Data Saved....");
					}
					
					
				}catch(Exception e){
					msgbox("Network Error! Try Again");
				}
			}
		});
		
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        /*if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }*/
		    
		    	
		    }
		});
		
		psave.setForeground(new Color(0, 128, 0));
		psave.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		psave.setBounds(303, 197, 89, 37);
		frame.getContentPane().add(psave);
	}
}
