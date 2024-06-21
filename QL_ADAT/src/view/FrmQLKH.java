package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.khachhangbean;
import bo.khachhangbo;
import dao.khachhangdao;

public class FrmQLKH extends JFrame {

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
					FrmQLKH frame = new FrmQLKH();
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
	ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
	private JTextField txtNs;
	private JTextField txtSearch;
	private JTable table;
	
	public void NapBang(ArrayList<khachhangbean> list){
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã KH");
		mh.addColumn("Tên KH");
		mh.addColumn("Ngày sinh");
		mh.addColumn("Địa chỉ");
		mh.addColumn("SĐT");
		mh.addColumn("Điểm tích lũy");
		mh.addColumn("Hạng thành viên");
		for(khachhangbean khb : list){	
			Object[] t = new Object[8];
			t[0] = khb.getMaKH();
			t[1] = khb.getTenKH();
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			t[2] = d.format(khb.getNgaySinh());
			t[3] = khb.getDiaChi();
			t[4] = khb.getSDT();
			t[5] = khb.getDiemTichLuy();
			t[6] = khb.getHangThanhVien();
			mh.addRow(t);
		}
		table.setModel(mh);
	}

	/**
	 * Create the frame.
	 */
	public FrmQLKH() {
		this.setTitle("Quản lý khách hàng");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
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
		tabbedPane.addTab("User", null, pnladd, null);
		pnladd.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên");
		lblNewLabel_1.setBounds(45, 11, 67, 26);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnladd.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setBounds(45, 123, 93, 26);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnladd.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setBounds(45, 179, 93, 26);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnladd.add(lblNewLabel_3);
		
		txtTen = new JTextField();
		txtTen.setBounds(176, 4, 412, 45);
		txtTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					txtNs.requestFocus();
			}
		});
		pnladd.add(txtTen);
		txtTen.setColumns(10);
		
		txtDc = new JTextField();
		txtDc.setBounds(176, 116, 412, 45);
		txtDc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					txtSdt.requestFocus();
			}
		});
		txtDc.setColumns(10);
		pnladd.add(txtDc);
		
		txtSdt = new JTextField();
		txtSdt.setBounds(176, 172, 412, 45);
		txtSdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(KtSdt(txtSdt.getText()))
						txtMa.requestFocus();
					else
						JOptionPane.showMessageDialog(null, "SĐT không hợp lệ!");
				}
			}
		});
		txtSdt.setColumns(10);
		pnladd.add(txtSdt);
		
		txtMa = new JTextField();
		txtMa.setBounds(176, 228, 412, 45);
		txtMa.setColumns(10);
		pnladd.add(txtMa);
		
		JLabel lblNewLabel_4 = new JLabel("Mã Khách hàng");
		lblNewLabel_4.setBounds(45, 233, 123, 30);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnladd.add(lblNewLabel_4);
		
		txtNs = new JTextField();
		txtNs.setBounds(176, 60, 412, 45);
		txtNs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					if(KtBirth(txtNs.getText()))
						txtDc.requestFocus();
					else
						JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
				}
			}
		});
		txtNs.setColumns(10);
		pnladd.add(txtNs);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày sinh");
		lblNewLabel_5.setBounds(45, 65, 88, 30);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnladd.add(lblNewLabel_5);
		
		JButton btnAdd = new JButton("THÊM");
		btnAdd.setBounds(653, 21, 107, 35);
		pnladd.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (txtTen.getText().equals("") || txtNs.getText().equals("") || txtDc.getText().equals("") || txtSdt.getText().equals("") || txtMa.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
					}
					else{
						if(!KtBirth(txtNs.getText())) 
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng ngày sinh!");
						
						if(!KtSdt(txtSdt.getText()))
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số điện thoại!");
						
						SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
						Date ngay = dd.parse(txtNs.getText());
						if(khbo.ThemKH(txtMa.getText(), txtTen.getText(), ngay, txtDc.getText(), txtSdt.getText()) == null){
							JOptionPane.showMessageDialog(null, "Khách hàng này đã có trong list");
						}
						else{
							NapBang(khbo.getKH());
							JOptionPane.showMessageDialog(null, "Thêm tài khoản khách hàng thành công");
						}
					}
						
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnAdd.setBackground(new Color(0, 255, 64));
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(653, 217, 107, 35);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMa.setText("");
				txtTen.setText("");
				txtNs.setText("");
				txtDc.setText("");
				txtSdt.setText("");
				try {
					NapBang(khbo.getKH());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				txtSearch.setText("");
			}
		});
		pnladd.add(btnReset);
		
		btnReset.setBackground(new Color(255, 255, 255));
		
		JButton btnDelete = new JButton("XÓA");
		btnDelete.setBounds(653, 150, 107, 35);
		pnladd.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, 0).toString();
					String TenKH = table.getModel().getValueAt(row, 1).toString();
					khbe.setMaKH(value);
					if(row>=0){
						int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa: " + TenKH + " ?", "Xóa " + TenKH, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (check == JOptionPane.YES_OPTION){
							try {
								khbo.Xoa(value);
								NapBang(khbo.getKH());
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					}
				} catch (Exception e3) {
					e3.getMessage();
				}
			}
		});
		btnDelete.setBackground(new Color(255, 111, 111));
		
		JButton btnUpdate = new JButton("SỬA");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMa.getText().equals("") == true){
						JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
							int i = table.getSelectedRow();
							table.setValueAt(txtMa.getText(), i, 0);
							table.setValueAt(txtTen.getText(), i, 1);
							table.setValueAt(txtNs.getText(), i, 2);
							table.setValueAt(txtDc.getText(), i, 3);	
							table.setValueAt(txtSdt.getText(), i, 4);	
							SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
							Date ngay = dd.parse(txtNs.getText());
							khbo.SuaKH(txtMa.getText(), txtTen.getText(), ngay, txtDc.getText(), txtSdt.getText());
							JOptionPane.showMessageDialog(null, "Đã lưu thay đổi!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);	
					}
				}catch (Exception t) {
					t.getStackTrace();
				}
			}
		});
		btnUpdate.setBounds(653, 84, 107, 35);
		btnUpdate.setBackground(new Color(227, 122, 28));
		pnladd.add(btnUpdate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 287, 787, 196);
		pnladd.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				txtMa.setText(table.getValueAt(d, 0).toString());
				txtTen.setText(table.getValueAt(d, 1).toString());
				txtNs.setText(table.getValueAt(d, 2).toString());
				txtDc.setText(table.getValueAt(d, 3).toString());
				txtSdt.setText(table.getValueAt(d, 4).toString());
			}
		});
		scrollPane_1.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					Search();
				}
			}
		});
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSearch.setBounds(600, 14, 171, 35);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THẺ THÀNH VIÊN");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setBounds(251, 3, 275, 50);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("icon_search.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search();
			}
		});
		btnSearch.setBounds(781, 14, 41, 35);
		contentPane.add(btnSearch);
	}
	
	public boolean KtSdt(String sdt) {
		String mau = "[0][\\d]{9,10}";
	    return Pattern.matches(mau, sdt);
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
	
	public void Search() {
		try {
			ArrayList<khachhangbean> tmp = khbo.TimKH(txtSearch.getText());
			if(tmp.size() != 0)
				NapBang(tmp);
			else
				JOptionPane.showMessageDialog(null, "Không có khách hàng bạn cần tìm!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
