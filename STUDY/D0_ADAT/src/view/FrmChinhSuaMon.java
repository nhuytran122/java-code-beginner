package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.monbean;
import bo.monbo;
import dao.connectDB;
import dao.mondao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FrmChinhSuaMon extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoaimon;
	private JTextField txtTenmon;
	private JTextField txtGia;
	JLabel lblLoaiMon = new JLabel("Loại Món:");
	JLabel lblChinhSua = new JLabel("Chỉnh sửa món");
	JLabel lblTenMon = new JLabel("Tên Món:");
	JLabel lblNewLabel_3 = new JLabel("Giá");
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChinhSuaMon frame = new FrmChinhSuaMon();
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
	monbo mbo = new monbo();
	monbean mbean = new monbean();
	mondao mdao = new mondao();
	private JTable table;
	DefaultTableModel mh = new DefaultTableModel();
	private JTextField txtMamon;
	public void ImportTable(ArrayList<monbean> list){
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã Món");
		mh.addColumn("Tên Món");
		mh.addColumn("Giá");
		mh.addColumn("Loại Món");
		for(monbean mb3 : list){	
			Object[] t=new Object[5];
			t[0] = mb3.getMamon();
			t[1] = mb3.getTenmon();
			t[2] = mb3.getGia();
			t[3] = mb3.getLoaimon();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public FrmChinhSuaMon() throws IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					connectDB.KetNoi();
					ImportTable(mbo.getmon());		
				}catch(Exception m){
					m.printStackTrace();
				}
					
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblLoaiMon.setForeground(new Color(0, 153, 255));
		
		
		lblLoaiMon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoaiMon.setBounds(240, 135, 105, 28);
		contentPane.add(lblLoaiMon);
		lblChinhSua.setForeground(new Color(255, 51, 51));
		
		
		lblChinhSua.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblChinhSua.setBounds(335, 10, 188, 41);
		contentPane.add(lblChinhSua);
		lblTenMon.setForeground(new Color(0, 153, 255));
		
		
		lblTenMon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenMon.setBounds(240, 187, 105, 28);
		contentPane.add(lblTenMon);
		
		JLabel lblGia = new JLabel("Giá:");
		lblGia.setForeground(new Color(0, 153, 255));
		lblGia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGia.setBounds(240, 237, 105, 28);
		contentPane.add(lblGia);
		
		txtLoaimon = new JTextField();
		txtLoaimon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtLoaimon.setBounds(391, 135, 217, 28);
		contentPane.add(txtLoaimon);
		txtLoaimon.setColumns(10);
		
		txtTenmon = new JTextField();
		txtTenmon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenmon.setBounds(391, 188, 217, 27);
		contentPane.add(txtTenmon);
		txtTenmon.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGia.setBounds(391, 237, 217, 28);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		JButton btnHUY = new JButton("HỦY");
		btnHUY.setForeground(new Color(255, 255, 255));
		btnHUY.setBackground(new Color(255, 51, 51));
		btnHUY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}	
		});
		btnHUY.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHUY.setBounds(364, 284, 123, 33);	
		contentPane.add(btnHUY);
		
		JButton btnLUU = new JButton("LƯU");
		btnLUU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//connectDB.KetNoi();
					if (txtMamon.getText().equals("") == true){
						JOptionPane.showMessageDialog(null, "Chưa chọn món!","Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
							int i = table.getSelectedRow();
							table.setValueAt(txtMamon.getText(), i, 0);
							table.setValueAt(txtTenmon.getText(), i, 1);
							table.setValueAt(txtGia.getText(), i, 2);
							table.setValueAt(txtLoaimon.getText(), i, 3);	
							mdao.Sua(txtMamon.getText(),txtTenmon.getText(),txtGia.getText(),txtLoaimon.getText());
							JOptionPane.showMessageDialog(null, "Đã lưu thay đổi!","Thông báo", JOptionPane.INFORMATION_MESSAGE);	
					}
				}catch (Exception t) {
					t.getStackTrace();
				}
			}
		});
		btnLUU.setBackground(new Color(51, 204, 102));
		btnLUU.setForeground(Color.WHITE);
		btnLUU.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLUU.setBounds(522, 284, 114, 33);
		contentPane.add(btnLUU);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 345, 614, 225);	
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//lay dong vua chon
					int d = table.getSelectedRow();		
					txtMamon.setText(table.getValueAt(d, 0).toString());
					txtTenmon.setText(table.getValueAt(d, 1).toString());
					txtGia.setText(table.getValueAt(d, 2).toString());
					txtLoaimon.setText(table.getValueAt(d, 3).toString());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getMessage();
				}
			}
			
		});
		scrollPane.setViewportView(table);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBackground(new Color(51, 204, 102));
		lblImage.setIcon(new ImageIcon("C:\\Users\\Xuan Tai\\eclipse-workspace\\Mo\\Image\\cf.png"));
		
		lblImage.setBounds(30, 105, 168, 184);
		contentPane.add(lblImage); 
		
		JLabel lblMaMon = new JLabel("Mã Món:");
		lblMaMon.setForeground(new Color(0, 153, 255));
		lblMaMon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaMon.setBounds(240, 86, 105, 26);
		contentPane.add(lblMaMon);
		
		txtMamon = new JTextField();
		txtMamon.setEditable(false);
		txtMamon.setBackground(new Color(255, 255, 255));
		txtMamon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMamon.setBounds(391, 86, 216, 29);
		contentPane.add(txtMamon);
		txtMamon.setColumns(10);
	}
}
