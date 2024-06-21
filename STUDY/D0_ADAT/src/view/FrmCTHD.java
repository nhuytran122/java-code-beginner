package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.cthdbean;
import bean.hoadonbean;
import bo.cthdbo;
import dao.connectDB;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.function.ToDoubleFunction;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCTHD extends JFrame {

	public static String mahoadon;
	private JPanel contentPane;
	public static int tongsoluong1;
	private JTable tblBang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCTHD frame = new FrmCTHD(mahoadon);
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
	cthdbo ct1 = new cthdbo();
	cthdbean ct2 = new cthdbean();
	connectDB cn = new connectDB();
	ArrayList<cthdbean> hd3 = new ArrayList<cthdbean>();
	private JTextField txtMaHoaDon;
	private JTextField txtCTHD;
	private JTextField txtMaMon;
	private JTextField txtSoLuong;
	private JTextField txtTamTinh;
	private JTextField txtGia;
	private JTextField txtThoiGianVao;
	private JTextField txtThoiGianRa;
	private JTextField txtKhuyenMai;
	public void ImportTable(ArrayList<cthdbean> list){
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã CTHD");
		mh.addColumn("Mã Hóa Đơn");
		mh.addColumn("Mã Món");
		mh.addColumn("Số Lượng");
		mh.addColumn("Giá");
		mh.addColumn("Thời Gian Vào");
		mh.addColumn("Thời Gian Ra");
		mh.addColumn("Khuyến Mãi");
		mh.addColumn("Tạm Tính");
		for(cthdbean ct3 : list){	
			Object[] t = new Object[9];
			t[0] = ct3.getMacthd();
			t[1] = ct3.getMahoadon();
			t[2] = ct3.getMamon();
			t[3] = ct3.getSoluong();
			t[4] = ct3.getGia();
			t[5] = ct3.getThoigianvao();
			t[6] = ct3.getThoigianra();
			t[7] = ct3.getKhuyenmai();
			t[8] = ct3.getTamtinh();
			mh.addRow(t);
		}
		tblBang.setModel(mh);
	}
	public Double thanhtien(ArrayList<cthdbean> list,String macthd){
		double thanhtien = 0;
		for(cthdbean ct : list){
			if(ct.getMacthd().equals(macthd)){
				thanhtien  = ct.getSoluong() * Double.parseDouble(ct.getGia()) * ct.getKhuyenmai();
			}
		}
		return thanhtien;
	}
	public FrmCTHD(String mahoadon) {
		setTitle("Chi Tiết Hóa Đơn");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try	{
					connectDB.KetNoi();
					ImportTable(ct1.Find(txtMaHoaDon.getText()));
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 301, 744, 89);
		contentPane.add(scrollPane);
		
		tblBang = new JTable();
		tblBang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try	{
					int k = tblBang.getSelectedRow();
					String macthd = tblBang.getValueAt(k, 0).toString();
					txtCTHD.setText(macthd);
					String mahoadon = tblBang.getValueAt(k, 1).toString();
					txtMaHoaDon.setText(mahoadon);
					String mamon = tblBang.getValueAt(k, 2).toString();
					txtMaMon.setText(mamon);
					String soluong = tblBang.getValueAt(k, 3).toString();
					txtSoLuong.setText(soluong);
					String gia = tblBang.getValueAt(k, 4).toString();
					txtGia.setText(gia);
					String thoigianvao = tblBang.getValueAt(k, 5).toString();
					txtThoiGianVao.setText(thoigianvao);
					String thoigianra = tblBang.getValueAt(k, 6).toString();
					txtThoiGianRa.setText(thoigianra);
					String khuyenmai = tblBang.getValueAt(k, 7).toString();
					txtKhuyenMai.setText(khuyenmai);
					String tamtinh = tblBang.getValueAt(k, 8).toString();
					txtTamTinh.setText(tamtinh);
					ct2.setMacthd(macthd);
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tblBang);
		JButton btnNewButton = new JButton("Hủy");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(50, 441, 145, 44);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("S\u1EEDa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ct2.setMacthd(txtCTHD.getText());
					ct2.setMahoadon(txtMaHoaDon.getText());
					ct2.setMamon(txtMaMon.getText());
					ct2.setSoluong(Integer.parseInt(txtSoLuong.getText()));
					ct2.setGia(txtGia.getText());
					ct2.setThoigianvao(new SimpleDateFormat("yyyy-MM-dd").parse(txtThoiGianVao.getText()));
					ct2.setThoigianra(new SimpleDateFormat("yyyy-MM-dd").parse(txtThoiGianRa.getText()));
					ct2.setKhuyenmai(Double.parseDouble(txtKhuyenMai.getText()));
					double tamtinh = thanhtien(ct1.Find(txtMaHoaDon.getName()), txtCTHD.getText());
					ct1.suaCTHD(ct2);
					ct1.capnhatTamtinh(ct2);
					ct2.setTamtinh(String.valueOf(tamtinh));
					JOptionPane.showMessageDialog(null, "Sửa thành công!");
					if(ct2.getSoluong() == 0){
						ct1.xoaMonTrongCTHD(ct2);
					}
					ImportTable(ct1.Find(txtMaHoaDon.getText()));
					double tong = 0;
					for(cthdbean ct:ct1.getCTHD()) {
						tong += Double.parseDouble(ct.getTamtinh());
					}
					hoadonbean hd = new hoadonbean();
					String tien = Double.toString(tong);
					hd.setTongtien(tien);
					FrmHoaDon fram2 = new FrmHoaDon(hd.getTongtien(),txtMaHoaDon.getText());
					fram2.setVisible(true);
				}catch(Exception tt) {
					tt.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnUpdate.setBounds(222, 444, 134, 39);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("X\u00F3a");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cthdbean ct3 = new cthdbean();
				ct3.setMacthd(ct2.getMacthd());
				int check = JOptionPane.showConfirmDialog(null,"Ban Co Muon Xoa Mon Nay Khong ?","Xac Nhan Thong Tin!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				try	{
					connectDB.KetNoi();
					if(check == JOptionPane.YES_OPTION)	{
						ct1.xoaMonTrongCTHD(ct3);
						txtCTHD.setText("");
						txtMaMon.setText("");
						txtSoLuong.setText("");
						txtGia.setText("");
						txtThoiGianVao.setText("");
						txtThoiGianRa.setText("");
						txtKhuyenMai.setText("");
						txtTamTinh.setText("");
						ImportTable(ct1.Find(txtMaHoaDon.getText()));
						
					}
					else if(check == JOptionPane.NO_OPTION)	{
						JOptionPane.showMessageDialog(null, "Xóa không thành công!");
					}
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnDelete.setBounds(383, 444, 125, 39);
		contentPane.add(btnDelete);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(186, 36, 170, 31);
		contentPane.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã Hóa Đơn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(50, 35, 117, 32);
		contentPane.add(lblNewLabel);
		this.mahoadon = mahoadon;
		this.txtMaHoaDon.setText(mahoadon);
		
		JLabel lblNewLabel_1 = new JLabel("Mã CTHD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(50, 110, 117, 24);
		contentPane.add(lblNewLabel_1);
		
		txtCTHD = new JTextField();
		txtCTHD.setBounds(186, 109, 170, 31);
		contentPane.add(txtCTHD);
		txtCTHD.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Món");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(50, 180, 117, 24);
		contentPane.add(lblNewLabel_2);
		
		txtMaMon = new JTextField();
		txtMaMon.setBounds(186, 179, 170, 31);
		contentPane.add(txtMaMon);
		txtMaMon.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số Lượng");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(50, 254, 117, 24);
		contentPane.add(lblNewLabel_3);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(186, 253, 170, 32);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tạm Tính");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(518, 449, 109, 31);
		contentPane.add(lblNewLabel_4);
		
		txtTamTinh = new JTextField();
		txtTamTinh.setBounds(618, 451, 170, 31);
		contentPane.add(txtTamTinh);
		txtTamTinh.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Giá");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(505, 34, 103, 31);
		contentPane.add(lblNewLabel_5);
		
		txtGia = new JTextField();
		txtGia.setBounds(618, 36, 176, 31);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Thời gian vào");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setBounds(491, 109, 117, 31);
		contentPane.add(lblNewLabel_6);
		
		txtThoiGianVao = new JTextField();
		txtThoiGianVao.setBounds(618, 115, 176, 31);
		contentPane.add(txtThoiGianVao);
		txtThoiGianVao.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Thời gian ra");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_7.setBounds(486, 179, 134, 31);
		contentPane.add(lblNewLabel_7);
		
		txtThoiGianRa = new JTextField();
		txtThoiGianRa.setBounds(618, 179, 176, 31);
		contentPane.add(txtThoiGianRa);
		txtThoiGianRa.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Khuyến Mãi");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_8.setBounds(491, 252, 134, 29);
		contentPane.add(lblNewLabel_8);
		
		txtKhuyenMai = new JTextField();
		txtKhuyenMai.setBounds(618, 253, 176, 32);
		contentPane.add(txtKhuyenMai);
		txtKhuyenMai.setColumns(10);
	}
}
