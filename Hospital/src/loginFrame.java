import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import mysql.*;

public class loginFrame extends methodClass{

	JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JLabel lblPassword;
	private JLabel lblUsername;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame window = new loginFrame();
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
	public loginFrame() {
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
		
		JLabel lblLoginHere = new JLabel("Login Here");
		lblLoginHere.setForeground(new Color(0, 100, 0));
		lblLoginHere.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblLoginHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginHere.setBounds(163, 35, 117, 29);
		frame.getContentPane().add(lblLoginHere);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(163, 89, 117, 38);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(163, 156, 117, 38);
		frame.getContentPane().add(password);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(197, 199, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(197, 75, 60, 14);
		frame.getContentPane().add(lblUsername);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cUsername = username.getText().toString();
				String cPassword = password.getText().toString();
				int logincheck = 0;
				
				try{
					
					connector connect = new connector();
					
					Statement st = connect.connector();
					
					String query = "SELECT username,password from user_info where username='"+cUsername+"'and password='"+cPassword+"';";
					
					ResultSet allResult = st.executeQuery(query);
					
					while(allResult.next()){
						logincheck++;
					}
					
					if(logincheck == 1){
						
						MainWindow window2 = new MainWindow();
						window2.frame.setVisible(true);
						frame.setVisible(false);
		                frame.dispose();
		                
					}else{
						msgbox("Username Password Doesn't Match");
					}
					
				}catch(Exception e){
					msgbox("Network Error! Try Again");
				}
				
				
				
				
				
			}
		});
		loginbtn.setForeground(new Color(65, 105, 225));
		loginbtn.setFont(new Font("Stencil", Font.PLAIN, 18));
		loginbtn.setBounds(324, 210, 89, 29);
		frame.getContentPane().add(loginbtn);
		
		
	}
}
