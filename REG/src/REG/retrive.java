package REG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class retrive {

	private JFrame frame;
	private JTextField s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retrive window = new retrive();
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
	public retrive() {
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
		
		JLabel ss = new JLabel("Sno");
		ss.setBounds(62, 66, 46, 14);
		frame.getContentPane().add(ss);
		
		s = new JTextField();
		s.setBounds(178, 63, 86, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
		
		JLabel lb1 = new JLabel("Name");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb1.setBounds(62, 174, 307, 14);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb2.setBounds(68, 213, 222, 14);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=s.getText();
				int sno=Integer.parseInt(s1);
		
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retrive","root","mrec");
					String q="select name,marks from data where sno=? ";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name:"+rs.getString(1));
					lb2.setText("Marks:"+rs.getString(2));
					int count=rs.getInt(1);
					
					if (count==0) {
						JOptionPane.showMessageDialog(btnNewButton,"invalid ");
					}
					else{
						JOptionPane.showMessageDialog(btnNewButton,"login done ");
					}
					
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(218, 103, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}

}
