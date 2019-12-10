import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import mysql.connector;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class patient extends methodClass{

	public JFrame frame;
	private JTextField searchid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient window = new patient();
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
	public patient() {
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
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addpatient window3 = new addpatient();
				window3.frame.setVisible(true);
			}
		});
		btnAddPatient.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnAddPatient.setForeground(new Color(106, 90, 205));
		btnAddPatient.setBounds(231, 215, 176, 35);
		frame.getContentPane().add(btnAddPatient);
		
		JButton search = new JButton("");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String csearchID = searchid.getText().toString();
				int csearchIDINT = Integer.parseInt(csearchID);
				boolean found = false;
				
				String pname = null,padd= null,pdis= null,pblood= null;
				
				try{
					
					connector connect = new connector();
					
					Statement statement = connect.connector();
					
					String query = "select * from patient_info where pid='"+csearchIDINT+"';";
					
					ResultSet allResult = statement.executeQuery(query);
					
					while(allResult.next()){
						
						pname = allResult.getString("pname");
						padd = allResult.getString("paddress");
						pdis = allResult.getString("pdis");
						pblood = allResult.getString("pblood");
						
						found = true;
						
					}
					
					if(found){
						msgbox("Patient Name: "+pname+"\n"+
								"Patient Adress: "+padd+"\n"+
								"Patient Disease: "+pdis+"\n"+
								"Patient Blood: "+pblood+"\n");
					}else{
						
						msgbox("Patient not found");
					}
					
				
					
					
				}catch(Exception e1){
					msgbox("Network Error! Try Again");
				}
				
				
			}
		});
		search.setIcon(new ImageIcon("C:\\Users\\ISTIYAK\\Desktop\\document_search.png"));
		search.setForeground(new Color(106, 90, 205));
		search.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		search.setBounds(330, 33, 39, 36);
		frame.getContentPane().add(search);
		
		searchid = new JTextField();
		searchid.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		searchid.setHorizontalAlignment(SwingConstants.CENTER);
		searchid.setBounds(33, 33, 287, 36);
		frame.getContentPane().add(searchid);
		searchid.setColumns(10);
	}

}
