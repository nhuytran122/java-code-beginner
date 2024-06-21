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

import bean.dangnhapbean;
import bo.dangnhapbo;
import bo.ketnoibo;
import dao.KetNoi;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtTendn;

	dangnhapbo dnb = new dangnhapbo();
	static FrmLogin frame;
	public static String un = "";
	private JPasswordField txtPass;
	/**
	 * Launch the application.
	 */
	
	public void Login() {
		try {
			String pass = new String(txtPass.getPassword());
			dangnhapbean kt = dnb.ktDn(txtTendn.getText(), pass);
			if(kt != null) {
				un = kt.getTenDangNhap();
				new FrmBanHang().setVisible(true);
				FrmKetNoi.f.setVisible(false);
			}
			else JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnDn = new JLabel("Tên đăng nhập");
		lblTnDn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnDn.setBounds(40, 51, 136, 43);
		contentPane.add(lblTnDn);
		
		JLabel lblpass = new JLabel("Mật khẩu");
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpass.setBounds(40, 120, 136, 43);
		contentPane.add(lblpass);
		
		txtTendn = new JTextField();
		txtTendn.setBounds(219, 53, 299, 43);
		contentPane.add(txtTendn);
		txtTendn.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		btnLogin.setBounds(302, 196, 142, 43);
		contentPane.add(btnLogin);
		
		txtPass = new JPasswordField();
		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					Login();
			}
		});
		txtPass.setBounds(219, 115, 299, 43);
		contentPane.add(txtPass);
	}
}
