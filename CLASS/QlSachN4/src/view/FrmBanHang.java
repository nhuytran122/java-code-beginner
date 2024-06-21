package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.loaibean; 
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmBanHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtten;
	private JTextField txttacgia;
	private JTextField txtgia;
	private JTextField txtsl;
	private JTextField txtthanhtien;
	private JTable table;
	private JTextField txtnhapsl;
	JList lstloai = new JList();
	JComboBox cmbMasach = new JComboBox();
	
	loaibo lbo = new loaibo();
	sachbo sbo = new sachbo();
	ArrayList<sachbean> dssach;
	/**
	 * Launch the application.
	 */
	public boolean ktSl() {
		for(sachbean sach:dssach){
			if(sach.getMasach().equals(cmbMasach.getSelectedItem().toString())) {
				if(Long.parseLong(txtnhapsl.getText()) > sach.getSoluong()) {
					return false;
				}	
				//else sbo.Ban(cmbMasach.getSelectedItem().toString(), Long.parseLong(txtnhapsl.getText()));
				else {
					Long ttien = Long.parseLong(txtgia.getText()) * Long.parseLong(txtnhapsl.getText());
					txtthanhtien.setText(ttien.toString());
					return true;
				}
			}
		}
		return false;
			
	}
	
	
	void NapBang(ArrayList<sachbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã sách");
		mh.addColumn("Tên sách");
		mh.addColumn("Số lượng");
		mh.addColumn("Giá");
		mh.addColumn("Mã loại");
		mh.addColumn("Số tập");
		mh.addColumn("Ngày nhập");
		mh.addColumn("Tác giả");
		for(sachbean sb:ds) {
			Object[] t = new Object[10];
			t[0] = sb.getMasach();
			t[1] = sb.getTensach();
			t[2] = sb.getSoluong();
			t[3] = sb.getGia();
			t[4] = sb.getMaloai();
			t[5] = sb.getSotap();
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			t[6] = d.format(sb.getNgayNhap());
			t[7] = sb.getTacgia();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBanHang frame = new FrmBanHang();
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
	public FrmBanHang() {
		this.setTitle("Xin chao: " + FrmLogin.un);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					//nap vao jlist
					DefaultListModel<loaibean> mh = new DefaultListModel<loaibean>();
					for(loaibean l: lbo.getLoai())
						mh.addElement(l);
					lstloai.setModel(mh);
				}catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn loại");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(11, 11, 98, 24);
		contentPane.add(lblNewLabel);
		lstloai.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				loaibean loai = (loaibean)lstloai.getSelectedValue();
				//System.out.println(loai.getMaloai());
				try {
					//Xóa toàn bộ dữ liệu trên combobox để tránh ghi đè data khi click chọn nhiều maloai
					cmbMasach.removeAllItems(); 
					
					//get Sach co Maloai duoc chon tu List
					dssach = sbo.getSach(loai.getMaloai());
					
					NapBang(dssach); //Hiển thi all các sách có mã loại chọn ở JList
					
					for(sachbean sbe : dssach) {
						//dua Masach co Maloai ben tren vao cmb
						cmbMasach.addItem(sbe.getMasach());
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		
		
		lstloai.setBounds(11, 46, 163, 302);
		contentPane.add(lstloai);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(206, 52, 98, 17);
		contentPane.add(lblNewLabel_1);		
		
		cmbMasach.setBounds(308, 41, 252, 37);
		contentPane.add(cmbMasach);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sách");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBackground(SystemColor.menu);
		lblNewLabel_1_1.setBounds(206, 102, 98, 17);
		contentPane.add(lblNewLabel_1_1);
		
		txtten = new JTextField();
		txtten.setBounds(308, 94, 252, 37);
		contentPane.add(txtten);
		txtten.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tác giả");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBackground(SystemColor.menu);
		lblNewLabel_1_2.setBounds(206, 151, 98, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBackground(SystemColor.menu);
		lblNewLabel_1_3.setBounds(206, 200, 98, 17);
		contentPane.add(lblNewLabel_1_3);
		
		txttacgia = new JTextField();
		txttacgia.setColumns(10);
		txttacgia.setBounds(308, 143, 252, 37);
		contentPane.add(txttacgia);
		
		txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(308, 192, 252, 37);
		contentPane.add(txtgia);
		
		txtsl = new JTextField();
		txtsl.setColumns(10);
		txtsl.setBounds(308, 240, 252, 37);
		contentPane.add(txtsl);
		
		txtthanhtien = new JTextField();
		txtthanhtien.setEditable(false);
		txtthanhtien.setColumns(10);
		txtthanhtien.setBounds(308, 336, 252, 37);
		contentPane.add(txtthanhtien);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Số lượng");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBackground(SystemColor.menu);
		lblNewLabel_1_3_1.setBounds(206, 248, 98, 17);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Thành tiền");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_2.setBackground(SystemColor.menu);
		lblNewLabel_1_3_2.setBounds(206, 344, 98, 17);
		contentPane.add(lblNewLabel_1_3_2);
		
		JButton btnBan = new JButton("Bán");
		btnBan.setBackground(new Color(0, 255, 64));
		btnBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(ktSl()) {
						sbo.Ban(cmbMasach.getSelectedItem().toString(), Long.parseLong(txtnhapsl.getText()));
						NapBang(dssach);
						for(sachbean sbe: dssach) {
							if(sbe.getMasach().equals(cmbMasach.getSelectedItem().toString()))
								txtsl.setText(sbe.getSoluong().toString());
						}
						JOptionPane.showMessageDialog(null, "Đã bán sách " + cmbMasach.getSelectedItem().toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "Số lượng mua vượt quá số lượng trong kho!");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBan.setBounds(584, 38, 158, 45);
		contentPane.add(btnBan);
		
		JButton btnTim = new JButton("Tìm theo mã sách");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Nhập mã sách cần tìm: ");
				try	{
					if(sbo.Tim(input).size() == 0)	{
						JOptionPane.showMessageDialog(null, "Không có sách cần tìm!");
					}
					else{
						ArrayList<sachbean> dstmp = new ArrayList<sachbean>();
						
						sachbean tmp = sbo.Tim2(input);
						dstmp.add(tmp);
						cmbMasach.removeAllItems();
						cmbMasach.addItem(tmp.getMasach());
						txtten.setText(tmp.getTensach());
						txttacgia.setText(tmp.getTacgia());
						txtgia.setText(tmp.getGia().toString());
						txtsl.setText(tmp.getSoluong().toString());
						NapBang(dstmp);
						
					}
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTim.setBounds(584, 94, 158, 45);
		contentPane.add(btnTim);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(11, 372, 753, 201);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Sách", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//lay dong vua chon
				int d = table.getSelectedRow();
				String ma = table.getValueAt(d, 0).toString();
				String ten = table.getValueAt(d, 1).toString();
				String tg = table.getValueAt(d, 7).toString();
				Long gia = Long.parseLong(table.getValueAt(d, 3).toString());
				Long sl = Long.parseLong(table.getValueAt(d, 2).toString());
				
				cmbMasach.removeAllItems(); //tránh nạp đè data khi thao tác
				
				cmbMasach.addItem(ma);
				txtten.setText(ten);
				txttacgia.setText(tg);
				txtgia.setText(gia.toString());
				txtsl.setText(sl.toString());
			}
		});
		scrollPane.setViewportView(table);
		
		txtnhapsl = new JTextField();
		txtnhapsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.getKeyCode() == 10) {
						if(!ktSl()) {
							JOptionPane.showMessageDialog(null, "Số lượng mua vượt quá số lượng trong kho!");
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		txtnhapsl.setColumns(10);
		txtnhapsl.setBounds(308, 288, 252, 37);
		contentPane.add(txtnhapsl);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập số lượng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(206, 291, 100, 26);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSuasach = new JButton("Sửa thông tin sách");
		btnSuasach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sbo.Sua(cmbMasach.getSelectedItem().toString(), txtten.getText(), Long.parseLong(txtsl.getText()), Long.parseLong(txtgia.getText()), txttacgia.getText());
					NapBang(dssach); //sau khi sửa xong phải nạp lại bảng để Update 
					JOptionPane.showMessageDialog(null, "Sửa thông tin của sách có mã " + cmbMasach.getSelectedItem().toString() + " thành công!");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnSuasach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuasach.setBounds(584, 150, 158, 45);
		contentPane.add(btnSuasach);
	}
	
}
