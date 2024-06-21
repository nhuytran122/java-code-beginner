package LTGiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmDangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtkq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangKy frame = new FrmDangKy();
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
	public FrmDangKy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("a = ");
		lblNewLabel.setBounds(33, 34, 21, 14);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("b = ");
		lblNewLabel_1.setBounds(33, 91, 21, 14);
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		contentPane.add(lblNewLabel_1);
		
		txta = new JTextField();
		txta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27) { //esc
					txta.setText("");
				}
			}
		});
		txta.setBounds(88, 24, 269, 34);
		contentPane.add(txta);
		txta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kết quả");
		lblNewLabel_2.setBounds(33, 152, 49, 14);
		lblNewLabel_2.setForeground(new Color(0, 128, 255));
		contentPane.add(lblNewLabel_2);
		
		txtb = new JTextField();
		txtb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //enter
					double a = Double.parseDouble(txta.getText());
					double b = Double.parseDouble(txtb.getText());
					Double kq = a+b;
					txtkq.setText(kq.toString());
				}
				if(e.getKeyCode() == 27) { //esc
					txtb.setText("");
				}
			}
		});
		txtb.setBounds(88, 81, 269, 34);
		contentPane.add(txtb);
		txtb.setColumns(10);
		
		txtkq = new JTextField();
		txtkq.setBounds(88, 142, 269, 34);
		txtkq.setColumns(10);
		contentPane.add(txtkq);
		
		JButton btnNewButton = new JButton("Cộng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(txta.getText());
				double b = Double.parseDouble(txtb.getText());
				Double kq = a+b;
				txtkq.setText(kq.toString());
			}
		});
		btnNewButton.setBounds(23, 200, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTr = new JButton("Trừ");
		btnTr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(txta.getText());
				double b = Double.parseDouble(txtb.getText());
				Double kq = a-b;
				txtkq.setText(kq.toString());
			}
		});
		btnTr.setBounds(122, 200, 89, 23);
		contentPane.add(btnTr);
		
		JButton btnNhn = new JButton("Nhân");
		btnNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(txta.getText());
				double b = Double.parseDouble(txtb.getText());
				Double kq = a*b;
				txtkq.setText(kq.toString());
			}
		});
		btnNhn.setBounds(221, 200, 89, 23);
		contentPane.add(btnNhn);
		
		JButton btnChia = new JButton("Chia");
		btnChia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(txta.getText());
				double b = Double.parseDouble(txtb.getText());
				if(b == 0)
					JOptionPane.showMessageDialog(null, "Về lớp 1 mà học");
				else {
					Double kq = a/b;
					txtkq.setText(kq.toString());
				}
				
			}
		});
		btnChia.setBounds(320, 200, 89, 23);
		contentPane.add(btnChia);
	}
}
