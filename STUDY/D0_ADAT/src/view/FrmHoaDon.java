package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.hoadonbean;
import bo.hoadonbo;
import dao.connectDB;
	
public class FrmHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable tblBang;
	public static  String tongtien;
	public static String mahoadon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHoaDon frame = new FrmHoaDon(tongtien,mahoadon);
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
	hoadonbo hd1 = new hoadonbo();
	hoadonbean hd2 = new hoadonbean();
	ArrayList<hoadonbean> hd3 = new ArrayList<hoadonbean>();
	public void ImportTable(ArrayList<hoadonbean> list){
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã Hóa Đơn");
		mh.addColumn("Mã Bàn");
		mh.addColumn("Mã Phiếu");
		mh.addColumn("Mã Nhân Viên");
		mh.addColumn("Tổng Tiền");
		mh.addColumn("Ngày Lập");
		for(hoadonbean hd3 : list){	
			Object[] t = new Object[6];
			t[0] = hd3.getMahoadon();
			t[1] = hd3.getMaban();
			t[2] = hd3.getMaphieu();
			t[3] = hd3.getManhanvien();
			t[4] = hd3.getTongtien();
			t[5] = hd3.getNgaylap();
			mh.addRow(t);
		}
		tblBang.setModel(mh);
	}
	public FrmHoaDon(String tongtien, String mahoadon) throws Exception {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					connectDB.KetNoi();
					ImportTable(hd1.getHoaDon());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 115, 732, 115);
		contentPane.add(scrollPane);
		
		tblBang = new JTable();
		tblBang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int k = tblBang.getSelectedRow();
				String mahoadon = tblBang.getValueAt(k, 0).toString();
				FrmCTHD frmcthd = new FrmCTHD(mahoadon);
				frmcthd.setVisible(true);
			}
		});
		scrollPane.setViewportView(tblBang);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hoadonbean hd = new hoadonbean();
				hd.setMahoadon(hd2.getMahoadon());
				int check = JOptionPane.showConfirmDialog(null,"Ban Co Muon Xoa Hoa Don Nay Khong ?","Xac Nhan Thong Tin!",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				try{
					connectDB.KetNoi();
					if(check == JOptionPane.YES_OPTION){
						hd1.xoaHoaDon(hd);
					}
					else if(check == JOptionPane.NO_OPTION)	{
						JOptionPane.showMessageDialog(null, "Xoa khong thanh cong!");
					}
					ImportTable(hd1.getHoaDon());
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnDelete.setBounds(153, 345, 137, 33);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(281, 35, 327, 31);
		contentPane.add(lblNewLabel);
		this.tongtien = tongtien;
		this.mahoadon = mahoadon;
		//this.hd1.capnhatTongTien(tongtien, mahoadon);
	}
}
