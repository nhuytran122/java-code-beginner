package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bo.ketnoibo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmKetNoi extends JFrame {

	private JPanel contentPane;
	private JTextField txtservername;
	private JTextField txtdatabase;
	private JTextField txtuser;
	private JPasswordField txtpass;
	
	static FrmKetNoi frame;
	public static FrmLogin f;

	/**
	 * Launch the application.
	 */
	public void Login() {
		try {
			ketnoibo kn = new ketnoibo();
			String pass = new String(txtpass.getPassword());
			kn.ketnoi(txtservername.getText(), txtdatabase.getText(), txtuser.getText(), pass);
//			JOptionPane.showMessageDialog(null, "Connected");
			f = new FrmLogin();
			f.setVisible(true);
			frame.setVisible(false);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FrmKetNoi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmKetNoi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 49, 117, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatabase.setBounds(77, 104, 117, 25);
		contentPane.add(lblDatabase);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(77, 160, 117, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(77, 216, 117, 25);
		contentPane.add(lblPassword);
		
		txtservername = new JTextField();
		txtservername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtservername.setText("PC-HFA1062\\SQLEXPRESS01");
		txtservername.setBounds(230, 41, 374, 45);
		contentPane.add(txtservername);
		txtservername.setColumns(10);
		
		txtdatabase = new JTextField();
		txtdatabase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdatabase.setText("QlSach");
		txtdatabase.setColumns(10);
		txtdatabase.setBounds(230, 96, 374, 45);
		contentPane.add(txtdatabase);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtuser.setText("sa");
		txtuser.setColumns(10);
		txtuser.setBounds(230, 152, 374, 45);
		contentPane.add(txtuser);
		
		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String pass = new String(txtpass.getPassword());
				if(e.getKeyCode() == 10) {
					if(!pass.equals("trannhuy"))
						JOptionPane.showMessageDialog(null, "Sai mật khẩu");
					else
						Login();
				}
			}
		});
		txtpass.setBounds(230, 208, 374, 45);
		contentPane.add(txtpass);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(txtpass.getPassword());
				if(!pass.equals("trannhuy"))
					JOptionPane.showMessageDialog(null, "Sai mật khẩu");
				else
					Login();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(350, 264, 123, 45);
		contentPane.add(btnNewButton);
	}
}
