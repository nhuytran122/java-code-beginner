package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.monbean;
import bo.monbo;
import dao.connectDB;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					connectDB.KetNoi();
					ImportTable(mbo.getmon());
				} catch (Exception e2) {
					// TODO: handle exception
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
					// TODO: handle exception
					e2.getMessage();
				}
			}
		});
		scrollPane_1.setViewportView(table);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBackground(new Color(0, 255, 128));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monbean mb = new monbean(txtTenmon.getText(), txtMamon.getText(), txtGia.getText(),txtLoaimon.getText());
				try{
					if (mb.getMamon().equals("")|| mb.getTenmon().equals("") || mb.getGia().equals("") || mb.getLoaimon().equals("")){
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
					}
					else{
						if(mbo.themmon(mb) == 0){
							JOptionPane.showMessageDialog(null, "Mon nay da co trong menu!");
						}
						else{
								ImportTable(mbo.getmon());
								JOptionPane.showMessageDialog(null, "Thêm món thành công");
						}
					}
					
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(329, 312, 118, 46);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
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
							mbo.Sua(txtMamon.getText(),txtTenmon.getText(),txtGia.getText(),txtLoaimon.getText());
							JOptionPane.showMessageDialog(null, "Đã lưu thay đổi!","Thông báo", JOptionPane.INFORMATION_MESSAGE);	
					}
				}catch (Exception t) {
					t.getStackTrace();
				}
			}
		});
		btnUpdate.setBounds(486, 312, 118, 46);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = table.getValueAt(row, 0).toString();
					String TenMon = table.getValueAt(row, 1).toString();
					mbe.setMamon(value);
					if(row>=0){
						int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa: " + TenMon + " ?", "Xóa " + TenMon, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (check == JOptionPane.YES_OPTION){
								mbo.Xoa(mbe);
								ImportTable(mbo.getmon());
								JOptionPane.showMessageDialog(null, "Đã xóa " + TenMon);
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
					}catch (Exception e2) {
						e2.printStackTrace();
				}
			}
		});
		btnDelete.setBackground(new Color(255, 128, 128));
		btnDelete.setBounds(637, 312, 118, 46);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Mã món");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(239, 91, 87, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnMn = new JLabel("Tên món");
		lblTnMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnMn.setBounds(240, 148, 87, 27);
		contentPane.add(lblTnMn);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGi.setBounds(239, 262, 87, 27);
		contentPane.add(lblGi);
		
		JLabel lblLoiMn = new JLabel("Loại món");
		lblLoiMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMn.setBounds(240, 204, 87, 27);
		contentPane.add(lblLoiMn);
		
		txtTenmon = new JTextField();
		txtTenmon.setBounds(327, 139, 434, 47);
		contentPane.add(txtTenmon);
		txtTenmon.setColumns(10);
		
		txtMamon = new JTextField();
		txtMamon.setColumns(10);
		txtMamon.setBounds(326, 80, 434, 47);
		contentPane.add(txtMamon);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(325, 252, 434, 47);
		contentPane.add(txtGia);
		
		txtLoaimon = new JTextField();
		txtLoaimon.setColumns(10);
		txtLoaimon.setBounds(326, 196, 434, 47);
		contentPane.add(txtLoaimon);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					String input = txtSearch.getText();
					if(e.getKeyCode() == 10) {
						if(mbo.Find(input).size() == 0)	{
							JOptionPane.showMessageDialog(null, "Không có món cần tìm!");
						}
						else{
							ImportTable(mbo.Find(input));
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
			
			
		});
		txtSearch.setBackground(new Color(222, 222, 222));
		txtSearch.setColumns(10);
		txtSearch.setBounds(508, 11, 253, 37);
		contentPane.add(txtSearch);
	}
}
