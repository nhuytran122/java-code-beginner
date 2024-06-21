package LTGiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class A02_FrmDangKy_CanBo extends JFrame {

	private JPanel contentPane;
	private JTextField txtma;
	private JTextField txtTen;
	private JTextField txtBirth;
	private JTextField txtEmail;
	private JTextField txtSdt;
	private JTextField txtHsl;
	private JPasswordField pw1;
	private JTextField txtTendn;
	private JPasswordField pw2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A02_FrmDangKy_CanBo frame = new A02_FrmDangKy_CanBo();
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
	public A02_FrmDangKy_CanBo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Cán bộ");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 40, 95, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 90, 85, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày sinh");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 140, 95, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(30, 190, 141, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_4.setBounds(30, 237, 141, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hệ số lương");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_5.setBounds(30, 284, 141, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tên đăng nhập");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_6.setBounds(30, 334, 141, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mật khẩu");
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_7.setBounds(30, 386, 141, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_8.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_8.setBounds(30, 436, 160, 30);
		contentPane.add(lblNewLabel_8);
		
		txtma = new JTextField();
		//Bắt từng lỗi
		txtma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(!KtMa(txtma.getText()))
						JOptionPane.showMessageDialog(null, "Sai Mã CB");
					else txtTen.requestFocus();
				}
			}
		});
		txtma.setBounds(216, 32, 541, 39);
		contentPane.add(txtma);
		txtma.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) 
					txtBirth.requestFocus();
			}
		});
		txtTen.setColumns(10);
		txtTen.setBounds(216, 82, 541, 39);
		contentPane.add(txtTen);
		
		txtBirth = new JTextField();
		txtBirth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(!KtBirth(txtBirth.getText()))
						JOptionPane.showMessageDialog(null, "Sai ngày sinh");
					else txtEmail.requestFocus();
				}
			}
		});
		txtBirth.setColumns(10);
		txtBirth.setBounds(216, 132, 541, 39);
		contentPane.add(txtBirth);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(!KtEmail(txtEmail.getText()))
						JOptionPane.showMessageDialog(null, "Sai email");
					
					else txtSdt.requestFocus();
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(216, 182, 541, 39);
		contentPane.add(txtEmail);
		
		txtSdt = new JTextField();
		txtSdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(!KtSdt(txtSdt.getText()))
						JOptionPane.showMessageDialog(null, "Sai số điện thoại");
					else txtHsl.requestFocus();
				}
			}
		});
		txtSdt.setColumns(10);
		txtSdt.setBounds(216, 232, 541, 39);
		contentPane.add(txtSdt);
		
		txtHsl = new JTextField();
		txtHsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(!KtHsLuong(txtHsl.getText()))
						JOptionPane.showMessageDialog(null, "Sai hệ số lương");
					else txtTendn.requestFocus();
				}
			}
		});
		txtHsl.setColumns(10);
		txtHsl.setBounds(216, 282, 541, 39);
		contentPane.add(txtHsl);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					Luu();
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Luu();				
			}
		});
		btnSave.setBackground(new Color(0, 128, 192));
		btnSave.setBounds(437, 496, 141, 39);
		contentPane.add(btnSave);
		
		pw1 = new JPasswordField();
		pw1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) 
					pw2.requestFocus();
				
			}
		});
		pw1.setBounds(216, 383, 541, 40);
		contentPane.add(pw1);
		
		txtTendn = new JTextField();
		txtTendn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(!KtTenDn(txtTendn.getText()))
						JOptionPane.showMessageDialog(null, "Sai tên đăng nhập");
					else pw1.requestFocus();
				}
			}
		});
		txtTendn.setColumns(10);
		txtTendn.setBounds(216, 332, 541, 39);
		contentPane.add(txtTendn);
		
		pw2 = new JPasswordField();
		pw2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					// getPassword(): trả về kiểu char
					// So sánh 2 mảng char
					boolean retval = Arrays.equals(pw1.getPassword(), pw2.getPassword());
					if(retval == false)
						JOptionPane.showMessageDialog(null, "Không trùng khớp với mật khẩu đã nhập");
					else btnSave.requestFocus();
				}
			}
		});
		pw2.setBounds(216, 436, 541, 40);
		contentPane.add(pw2);
	}
	
	public boolean KtMa(String ma) {
		String mauMacb = "[A-Za-z][\\w]+";
		return Pattern.matches(mauMacb, ma);
	}
	
	public boolean KtBirth(String ns) {
		//d: viet tat cua [0-9]
		//w: viet tat cua [0-9A-Za-z]
		try {
			SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
			dd.setLenient(false);
			dd.parse(ns);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean KtEmail(String email) {
		String mau = "[\\w]+@[\\w]+\\.[\\w]+(\\.[\\w]+){0,}";
		return Pattern.matches(mau, email);
	}
	
	public boolean KtSdt(String sdt) {
		String mau = "[0][\\d]{9,10}";
	    return Pattern.matches(mau, sdt);
	}
	
	public boolean KtHsLuong(String hsluong) {
		try {
			Float checkHsluong = Float.parseFloat(hsluong);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean KtTenDn(String tendn) {
		String mauTendn = "[A-Za-z][\\w]+";
		return Pattern.matches(mauTendn, tendn);
	}
	
	public void Luu(){
		boolean ch = KtMa(txtma.getText()) & KtEmail(txtEmail.getText()) & KtSdt(txtSdt.getText()) 
				& KtBirth(txtBirth.getText()) & KtHsLuong(txtHsl.getText()) & KtTenDn(txtTendn.getText());
		if(ch == true) {
			try {
				FileWriter w = new FileWriter("cb.txt");
				PrintWriter ghi = new PrintWriter(w);
				ghi.print(txtma.getText() + "; " + txtTen.getText() + "; " + txtBirth.getText() + "; " + txtEmail.getText() + "; " + txtSdt.getText() + "; " + txtHsl.getText() + "; " + txtTendn.getText() + "; " + pw1.getText());
				ghi.close();
				JOptionPane.showMessageDialog(null, "Nhập thành công");
			} catch (Exception e2) {
				System.out.println("Lỗi ghi file");
			}
		}
		// Trong trường hợp chưa bắt lỗi cho từng lỗi sai thì phải dùng đoạn code dưới
		else {
			int i = 0;
			String loi = "";
			if(!KtMa(txtma.getText()))
				loi += "Sai Mã CB";
				i++;
				
			if(!KtEmail(txtEmail.getText())) {
				if(i!=0)
					loi += "; sai Email";
				else loi += "Sai Email";
				i++;
			}
				
			if(!KtSdt(txtSdt.getText())) {
				if(i!=0)
					loi += "; sai SĐT";
				else loi += "Sai SĐT";
				i++;
			}
				
			if(!KtBirth(txtBirth.getText())) {
				if(i!=0) 
					loi += "; sai ngày sinh";
				else loi += "Sai ngày sinh";
				i++;
			}
			if(!KtHsLuong(txtHsl.getText())) {
				if(i!=0) 
					loi += "; sai hệ số lương";
				else loi += "Sai hệ số lương";
				i++;
			}
			if(!KtTenDn(txtTendn.getText())) {
				if(i!=0) 
					loi += "; sai tên đăng nhập";
				else loi += "Sai tên đăng nhập";
				i++;
			}
			//String pass = new String(txtpass.getPassword());
			String pass1 = new String(pw1.getPassword());
			String pass2 = new String(pw2.getPassword());
			
			if(!pass1.equals(pass2)) 
				loi += "; mật khẩu không trùng khớp";
			else loi += "Mật khẩu không trùng khớp";
				i++;
			
			JOptionPane.showMessageDialog(null, loi);
		}
	}
}
	
