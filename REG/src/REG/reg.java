package REG;
import java.awt.Component;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class reg {

	
	private JFrame frame;
	private JTextField s;
	private JTextField n;
	private JTextField em;
	private JTextField m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg window = new reg();
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
	public reg() {
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
		
		JLabel lblNewLabel = new JLabel("Sno");
		lblNewLabel.setBounds(31, 65, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(31, 105, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(31, 158, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("MARKS");
		lblMarks.setBounds(31, 205, 46, 14);
		frame.getContentPane().add(lblMarks);
		
		s = new JTextField();
		s.setBounds(110, 62, 163, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
		
		n = new JTextField();
		n.setColumns(10);
		n.setBounds(110, 105, 163, 20);
		frame.getContentPane().add(n);
		
		em = new JTextField();
		em.setColumns(10);
		em.setBounds(110, 155, 163, 20);
		frame.getContentPane().add(em);
		
		m = new JTextField();
		m.setColumns(10);
		m.setBounds(110, 202, 163, 20);
		frame.getContentPane().add(m);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=s.getText();
				String name=n.getText();
				String email=em.getText();
				String marks=m.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retrive","root","mrec");
					String q="Insert into data values('"+sno+"','"+name+"','"+email+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					Component btrNewButton = null;
					JOptionPane.showMessageDialog(btrNewButton,"Done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(311, 104, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
