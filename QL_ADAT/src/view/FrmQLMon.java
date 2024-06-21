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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.monbean;
import bo.monbo;

public class FrmQLMon extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	monbo mbo = new monbo();
	monbean mbe = new monbean();
	ArrayList<monbean> ds = new ArrayList<monbean>();
	private JTextField txtTenmon;
	private JTextField txtMamon;
	private JTextField txtGia;
	private JTextField txtLoaimon;
	private JTextField txtSearch;
	public void NapBang(ArrayList<monbean> list){
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLMon frame = new FrmQLMon();
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
	public FrmQLMon() {
		this.setTitle("Quản lý món");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					NapBang(mbo.getMon());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 366, 733, 238);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("List món", null, scrollPane_1, null);
		
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
					e2.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table);
		
		JButton btnAdd = new JButton("THÊM");
		btnAdd.setBackground(new Color(0, 255, 128));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (txtMamon.getText().equals("") || txtTenmon.getText().equals("") || txtGia.getText().equals("") || txtLoaimon.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
					}
					else{
						if(mbo.ThemMon(txtMamon.getText(), txtTenmon.getText(), Double.parseDouble(txtGia.getText()) ,txtLoaimon.getText()) == null){
							JOptionPane.showMessageDialog(null, "Món này đã có trong Menu!");
						}
						else{
							NapBang(mbo.getMon());
							JOptionPane.showMessageDialog(null, "Thêm món thành công!");
						}
					}
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(268, 309, 87, 46);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("SỬA");
		btnUpdate.setBackground(new Color(255, 128, 64));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtMamon.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Chưa chọn món!","Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
							int i = table.getSelectedRow();
							table.setValueAt(txtMamon.getText(), i, 0);
							table.setValueAt(txtTenmon.getText(), i, 1);
							table.setValueAt(txtGia.getText(), i, 2);
							table.setValueAt(txtLoaimon.getText(), i, 3);	
							mbo.SuaMon(txtMamon.getText(), txtTenmon.getText(), Double.parseDouble(txtGia.getText()), txtLoaimon.getText());
							JOptionPane.showMessageDialog(null, "Đã lưu thay đổi!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);	
					}
				}catch (Exception t) {
					t.getStackTrace();
				}
			}
		});
		btnUpdate.setBounds(385, 309, 89, 47);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("XÓA");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = table.getValueAt(row, 0).toString();
					String TenMon = table.getValueAt(row, 1).toString();
					mbe.setMamon(value);
					if(row >= 0){
						int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa: " + TenMon + " ?", "Xóa " + TenMon, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (check == JOptionPane.YES_OPTION){
							mbo.XoaMon(txtMamon.getText());
							NapBang(mbo.getMon());
							JOptionPane.showMessageDialog(null, "Đã xóa " + TenMon);
						} 
					}
				}catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Vui lòng chọn món muốn xóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setBackground(new Color(255, 128, 128));
		btnDelete.setBounds(501, 309, 87, 46);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Mã món");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(71, 88, 87, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnMn = new JLabel("Tên món");
		lblTnMn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnMn.setBounds(71, 147, 87, 27);
		contentPane.add(lblTnMn);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGi.setBounds(71, 262, 87, 27);
		contentPane.add(lblGi);
		
		JLabel lblLoiMn = new JLabel("Loại món");
		lblLoiMn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoiMn.setBounds(71, 204, 87, 27);
		contentPane.add(lblLoiMn);
		
		txtTenmon = new JTextField();
		txtTenmon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					txtLoaimon.requestFocus();
			}
		});
		txtTenmon.setBounds(268, 139, 434, 47);
		contentPane.add(txtTenmon);
		txtTenmon.setColumns(10);
		
		txtMamon = new JTextField();
		txtMamon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					txtTenmon.requestFocus();
			}
		});
		txtMamon.setColumns(10);
		txtMamon.setBounds(268, 80, 434, 47);
		contentPane.add(txtMamon);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(268, 254, 434, 47);
		contentPane.add(txtGia);
		
		txtLoaimon = new JTextField();
		txtLoaimon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10)
					txtGia.requestFocus();
			}
		});
		txtLoaimon.setColumns(10);
		txtLoaimon.setBounds(268, 196, 434, 47);
		contentPane.add(txtLoaimon);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					String key = txtSearch.getText();
					if(e.getKeyCode() == 10) {
						if(mbo.TimMon(key).size() == 0)	{
							JOptionPane.showMessageDialog(null, "Không có món cần tìm!");
						}
						else{
							NapBang(mbo.TimMon(key));
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		txtSearch.setBackground(new Color(222, 222, 222));
		txtSearch.setColumns(10);
		txtSearch.setBounds(418, 24, 284, 39);
		contentPane.add(txtSearch);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon("icon_search.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(mbo.TimMon(txtSearch.getText()).size() == 0)	{
						JOptionPane.showMessageDialog(null, "Không có món cần tìm!");
					}
					else{
						NapBang(mbo.TimMon(txtSearch.getText()));
					}
				} catch (Exception e2) {
				}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSearch.setBounds(712, 24, 44, 39);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtMamon.setText("");
					txtTenmon.setText("");
					txtGia.setText("");
					txtLoaimon.setText("");
					txtSearch.setText("");
					NapBang(mbo.getMon());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnReset.setBounds(615, 309, 87, 46);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ MÓN");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(71, 15, 185, 46);
		contentPane.add(lblNewLabel_1);
	}
}
