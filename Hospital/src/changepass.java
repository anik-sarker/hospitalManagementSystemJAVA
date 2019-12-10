import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mysql.connector;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class changepass extends methodClass {

	private JFrame frame;
	private JPasswordField newpass;
	private JPasswordField conpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changepass window = new changepass();
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
	public changepass() {
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
		
		newpass = new JPasswordField();
		newpass.setHorizontalAlignment(SwingConstants.CENTER);
		newpass.setBounds(138, 71, 193, 32);
		frame.getContentPane().add(newpass);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tekton Pro", Font.BOLD, 15));
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setBounds(158, 39, 138, 21);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tekton Pro", Font.BOLD, 15));
		lblConfirmPassword.setBounds(158, 123, 151, 21);
		frame.getContentPane().add(lblConfirmPassword);
		
		conpass = new JPasswordField();
		conpass.setHorizontalAlignment(SwingConstants.CENTER);
		conpass.setBounds(138, 155, 193, 32);
		frame.getContentPane().add(conpass);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String npass = newpass.getText().toString();
				String cpass = conpass.getText().toString();
				
				if(npass.equals(cpass)){
					try{
						
						connector connect = new connector();
						
						Statement statement = connect.connector();
						
						String query = "UPDATE user_info SET password='"+cpass+"'"+ "WHERE username='admin';";
						
						boolean allResult = statement.execute(query);
						
						if(allResult){
							msgbox("Network Error! Try Again");
						}else{
							msgbox("Password Updated....");
						}
						
						
					}catch(Exception ew){
						msgbox("Network Error! Try Again");
					}
				}else{
					msgbox("Password does not match");
				}
				
				
			}
		});
		btnSave.setFont(new Font("Tekton Pro Cond", Font.BOLD, 15));
		btnSave.setBounds(196, 206, 89, 32);
		frame.getContentPane().add(btnSave);
	}

}
