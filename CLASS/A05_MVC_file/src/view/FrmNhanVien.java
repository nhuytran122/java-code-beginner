package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.DonViBean;
import bean.NhanVienBean;
import bo.DonViBo;
import bo.NhanVienBo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class FrmNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtma;
	private JTextField txtns;
	private JTextField txthsl;
	private JTextField txtten;
	JComboBox cmbMadv = new JComboBox();
	/**
	 * Launch the application.
	 */
	NhanVienBo nvbo = new NhanVienBo();
	ArrayList<NhanVienBean> ds;
	DonViBo dvbo = new DonViBo();
	ArrayList<DonViBean> dsdv;
	private JTable table;
	
	void NapBang(ArrayList<NhanVienBean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã nhân viên");
		mh.addColumn("Tên nhân viên");
		mh.addColumn("Ngày sinh");
		mh.addColumn("Hệ số lương");
		mh.addColumn("Mã đơn vị");
		for(NhanVienBean nv:ds) {
			Object[] t = new Object[5];
			t[0] = nv.getMaNV();
			t[1] = nv.getTenNV();
			
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			t[2] = d.format(nv.getNgaysinh());
			
			//t[2] = nv.getNgaysinh();
			t[3] = nv.getHsluong();
			t[4] = nv.getMadv();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanVien frame = new FrmNhanVien();
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
	public FrmNhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {	
					ds = nvbo.getNV();
					NapBang(ds);
					
					dsdv = dvbo.getDV();
					for(DonViBean dv: dvbo.getDV())
						cmbMadv.addItem(dv.getMadv());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getMessage();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 40, 122, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(23, 88, 131, 24);
		contentPane.add(lblNewLabel_1);
		
		txtma = new JTextField();
		txtma.setBounds(166, 30, 507, 41);
		contentPane.add(txtma);
		txtma.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(23, 140, 131, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hệ số lương");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(23, 192, 131, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã đơn vị");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(23, 246, 131, 24);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					C1 for(DonViBean dvb:ds) 
//							if(dvb.getMadv().toLowerCase().trim().equals((txtma.getText()).toLowerCase().trim()))
//								JOptionPane.showMessageDialog(null, "Mã Đơn vị này đã tồn tại");
//							else{
//								dvbo.ThemDV(txtma.getText(), txtten.getText());
//								NapBang(ds);
//							}
									
				//C2:
					SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
					Date ngaysinh = dd.parse(txtns.getText());	
					Double hsl = Double.parseDouble(txthsl.getText());
					ds = nvbo.ThemNV(txtma.getText(), txtten.getText(), ngaysinh, hsl, cmbMadv.getSelectedItem().toString());
					if(ds == null)
						JOptionPane.showMessageDialog(null, "Mã Nhân viên này đã tồn tại");
					else NapBang(ds);
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		});
		btnAdd.setBackground(new Color(0, 255, 128));
		btnAdd.setBounds(166, 292, 113, 41);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//nhap ma trong input r xóa 
//				String ma = JOptionPane.showInputDialog("Nhập mã đơn vị cần xóa");
//				for(NhanvienBean nv: ds) {
//					if(dv.getManv().equals(ma)) {
//						ds.remove(nv);
//						break;
//					}
//				}
//				NapBang(ds);
				int t = JOptionPane.showConfirmDialog(null, "Xóa hay không?");
				if(t==0) {
					nvbo.XoaNV(txtma.getText());
					NapBang(ds);
				}
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		});
		btnDelete.setBackground(new Color(255, 128, 128));
		btnDelete.setBounds(300, 292, 113, 41);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
					Date ngaysinh = dd.parse(txtns.getText());	
					Double hsl = Double.parseDouble(txthsl.getText());
					nvbo.CapNhatNV(txtma.getText(), txtten.getText(), ngaysinh, hsl, cmbMadv.getSelectedItem().toString());
					NapBang(ds);
					JOptionPane.showMessageDialog(null, "Update thành công");
				} catch (Exception e2) {
					e2.getStackTrace();
				}
			}
		});
		btnUpdate.setBounds(430, 292, 113, 41);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nvbo.Luu(ds);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(560, 292, 113, 41);
		contentPane.add(btnSave);
		
		txtns = new JTextField();
		txtns.setColumns(10);
		txtns.setBounds(166, 134, 507, 41);
		contentPane.add(txtns);
		
		txthsl = new JTextField();
		txthsl.setColumns(10);
		txthsl.setBounds(166, 186, 507, 41);
		contentPane.add(txthsl);
		
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(164, 82, 507, 41);
		contentPane.add(txtten);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 344, 748, 212);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//lay dong vua chon
				int d = table.getSelectedRow();
				String ma = table.getValueAt(d, 0).toString();
				String ten = table.getValueAt(d, 1).toString();
				String ns = table.getValueAt(d, 2).toString();
				String hsl = table.getValueAt(d, 3).toString();
				String madv = table.getValueAt(d, 4).toString();
				
				txtma.setText(ma);
				txtten.setText(ten);
				txtns.setText(ns);
				txthsl.setText(hsl);
				cmbMadv.setSelectedItem(madv);
			}
		});
		scrollPane.setViewportView(table);
		
		
		cmbMadv.setBounds(166, 238, 507, 41);
		contentPane.add(cmbMadv);
	}
}
