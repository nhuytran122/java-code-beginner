package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.khachhangbean;
import bo.khachhangbo;
import dao.connectDB;
import dao.khachhangdao;

import javax.swing.JToolBar;
import javax.swing.Scrollable;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class FrmQLTV extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDc;
	private JTextField txtSdt;
	private JTextField txtMa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLTV frame = new FrmQLTV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	khachhangbo khbo = new khachhangbo();
	khachhangbean khbe = new khachhangbean();
	khachhangdao khdao = new khachhangdao();
	ArrayList<khachhangbean> mb3 = new ArrayList<khachhangbean>();
	private JTable tblBang;
	private JTextField txtNs;
	private JTextField txtFind;
	
	public void NapBang(ArrayList<khachhangbean> list){
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã KH");
		mh.addColumn("Tên KH");
		mh.addColumn("Ngày sinh");
		mh.addColumn("Địa chỉ");
		mh.addColumn("SĐT");
//		String[] cols = new String[] {"Mã KH", "Tên KH", "Ngày sinh", "Địa chỉ", "SĐT"};
//		mh.setColumnIdentifiers(cols);
		for(khachhangbean mb3 : list){	
			Object[] t = new Object[5];
			t[0] = mb3.getMaKH();
			t[1] = mb3.getTenKH();
			t[2] = mb3.getNgaysinh();
			t[3] = mb3.getDiachi();
			t[4] = mb3.getSdt();
			mh.addRow(t);
		}
		tblBang.setModel(mh);
	}

	/**
	 * Create the frame.
	 */
	public FrmQLTV() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					connectDB.KetNoi();
					NapBang(khbo.getKH());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-4, 60, 836, 22);
		separator.setForeground(new Color(192, 192, 192));
		contentPane.add(separator);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 72, 812, 479);
		tabbedPane.setBackground(new Color(192, 192, 192));
		contentPane.add(tabbedPane);
		
		JPanel pnladd = new JPanel();
		tabbedPane.addTab("Add User", null, pnladd, null);
		pnladd.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 37, 67, 26);
		pnladd.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(45, 197, 93, 26);
		pnladd.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(45, 275, 93, 26);
		pnladd.add(lblNewLabel_3);
		
		txtTen = new JTextField();
		txtTen.setBounds(239, 30, 490, 45);
		pnladd.add(txtTen);
		txtTen.setColumns(10);
		
		txtDc = new JTextField();
		txtDc.setColumns(10);
		txtDc.setBounds(239, 190, 490, 45);
		pnladd.add(txtDc);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(239, 268, 490, 45);
		pnladd.add(txtSdt);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(239, 343, 490, 45);
		pnladd.add(txtMa);
		
		JLabel lblNewLabel_4 = new JLabel("Mã Khách hàng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(45, 348, 123, 30);
		pnladd.add(lblNewLabel_4);
		
		txtNs = new JTextField();
		txtNs.setColumns(10);
		txtNs.setBounds(239, 109, 490, 45);
		pnladd.add(txtNs);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày sinh");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(45, 114, 88, 30);
		pnladd.add(lblNewLabel_5);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(239, 407, 107, 35);
		pnladd.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					khbe.setMaKH(txtMa.getText());
					khbe.setTenKH(txtTen.getText());
					khbe.setNgaysinh(new SimpleDateFormat("yyyy-MM-dd").parse(txtNs.getText()));
					khbe.setDiachi(txtDc.getText());
					khbe.setSdt(txtSdt.getText());
				
					try{
						if (khbe.getTenKH().equals("") || khbe.getMaKH().equals("")|| khbe.getTenKH().equals("") || khbe.getNgaysinh().equals("") || khbe.getDiachi().equals("") || khbe.getSdt().equals("")){
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
						}
						else{
							if(khbo.ThemKH(khbe) == -1){
								JOptionPane.showMessageDialog(null, "Mã Khách hàng này đã có trong list");
							}
							else if(khbo.ThemKH(khbe) == 0)
								JOptionPane.showMessageDialog(null, "Khách hàng đã đăng ký tài khoản!");
							else{
									NapBang(khbo.getKH());
									JOptionPane.showMessageDialog(null, "Thêm tài khoản khách hàng thành công");
							}
						}
						
					}catch(Exception tt){
						tt.printStackTrace();
					}
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAdd.setBackground(new Color(0, 255, 64));
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(622, 407, 107, 35);
		pnladd.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMa.setText("");
				txtTen.setText("");
				txtNs.setText("");
				txtDc.setText("");
				txtSdt.setText("");
			}
		});
		btnReset.setBackground(new Color(255, 255, 255));
		
		JPanel pnllist = new JPanel();
		tabbedPane.addTab("List User", null, pnllist, null);
		pnllist.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 807, 491);
		pnllist.add(scrollPane);
		
		tblBang = new JTable();
		tblBang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tblBang);
		
		txtFind = new JTextField();
		txtFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFind.setBounds(610, 23, 212, 35);
		contentPane.add(txtFind);
		txtFind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THẺ THÀNH VIÊN");
		lblNewLabel.setBounds(274, 11, 275, 50);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(371, 556, 107, 35);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Switch_screen(layeredPane);
				
				try {
					int d = tblBang.getSelectedRow();
					if(d != 0){
						JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 món!");
					}
					else {
						pnladd.setVisible(true);	
						txtMa.setText(tblBang.getValueAt(d, 0).toString());
						txtTen.setText(tblBang.getValueAt(d, 1).toString());
						txtNs.setText(tblBang.getValueAt(d, 2).toString());
						txtDc.setText(tblBang.getValueAt(d, 3).toString());
						txtSdt.setText(tblBang.getValueAt(d, 4).toString());
						}
					
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		});
		btnUpdate.setBackground(new Color(192, 192, 192));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(488, 556, 107, 35);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = tblBang.getSelectedRow();
					String value = tblBang.getModel().getValueAt(row, 0).toString();
					String TenKH = tblBang.getModel().getValueAt(row, 1).toString();
					khbe.setMaKH(value);
					if(row>=0){
						int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa: " + TenKH + " ?", "Xóa " + TenKH, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (check == JOptionPane.YES_OPTION){
							try {
								khbo.Xoa(khbe);
								NapBang(khbo.getKH());
							} catch (Exception e2) {
								// TODO: handle exception
							}
							//System.exit(1);
						}
//						if (check == JOptionPane.NO_OPTION) {
//							try {
//								ImportTable(mbo.getmon());
//							} catch (Exception e) {
//								// TODO: handle exception
//							}
//						}
					}
				} catch (Exception e3) {
					e3.getMessage();
				}
			}
		});
		btnDelete.setBackground(new Color(255, 111, 111));
		
	}
}
