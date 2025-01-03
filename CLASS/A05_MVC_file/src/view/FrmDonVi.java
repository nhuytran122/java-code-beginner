package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import bean.DonViBean;
import bo.DonViBo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class FrmDonVi extends JFrame {

	private JPanel contentPane;
	private JTextField txtma;
	private JTextField txtten;
	private JTable table;

	/**
	 * Launch the application.
	 */
	DonViBo dvbo = new DonViBo();
	ArrayList<DonViBean> ds;
	void NapBang(ArrayList<DonViBean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã đơn vị");
		mh.addColumn("Tên đơn vị");
		for(DonViBean dv:ds) {
			Object[] t = new Object[2];
			t[0] = dv.getMadv();
			t[1] = dv.getTendv();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDonVi frame = new FrmDonVi();
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
	public FrmDonVi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					ds = dvbo.getDV();
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã đơn vị");
		lblNewLabel.setBounds(40, 40, 87, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đơn vị");
		lblNewLabel_1.setBounds(40, 122, 87, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		txtma = new JTextField();
		txtma.setBounds(152, 28, 562, 48);
		contentPane.add(txtma);
		txtma.setColumns(10);
		
		txtten = new JTextField();
		txtten.setBounds(152, 114, 562, 48);
		txtten.setColumns(10);
		contentPane.add(txtten);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 281, 755, 250);
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
				txtma.setText(ma);
				txtten.setText(ten);	
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(0, 255, 128));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//	C1				for(DonViBean dvb:ds) 
//						if(dvb.getMadv().toLowerCase().trim().equals((txtma.getText()).toLowerCase().trim()))
//							JOptionPane.showMessageDialog(null, "Mã Đơn vị này đã tồn tại");
//						else{
//							dvbo.ThemDV(txtma.getText(), txtten.getText());
//							NapBang(ds);
//						}
					
//C2:
					ds = dvbo.ThemDV(txtma.getText(), txtten.getText());
					if(ds == null)
						JOptionPane.showMessageDialog(null, "Mã Đơn vị này đã tồn tại");
					else NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getMessage();
				}
			}
		});
		btnAdd.setBounds(152, 208, 113, 41);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 128, 128));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//nhap ma trong input r xóa 
//					String ma = JOptionPane.showInputDialog("Nhập mã đơn vị cần xóa");
//					for(DonViBean dv: ds) {
//						if(dv.getMadv().equals(ma)) {
//							ds.remove(dv);
//							break;
//						}
//					}
//					NapBang(ds);
					int t = JOptionPane.showConfirmDialog(null, "Xóa hay không?");
					if(t==0) {
						dvbo.XoaDV(txtma.getText());
						NapBang(ds);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getMessage();
				}
			}
		});
		btnDelete.setBounds(302, 208, 113, 41);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dvbo.CapNhatDV(txtma.getText(), txtten.getText());
					NapBang(ds);
					JOptionPane.showMessageDialog(null, "Update thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(456, 208, 113, 41);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(new Color(0, 255, 255));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dvbo.Luu(ds);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(601, 208, 113, 41);
		contentPane.add(btnSave);
	}
}
