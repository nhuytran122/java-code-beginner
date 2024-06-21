package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.banbean;
import bean.moninbanbean;
import bo.banbo;
import bo.moninbanbo;
import dao.DaoGetMon;
import dao.Test1;
import dao.connectDB;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmBanMon extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBanMon frame = new FrmBanMon();
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
	banbo b1 = new banbo();
	moninbanbo mibb = new moninbanbo();
	banbean b2 = new banbean();
	moninbanbean mib = new moninbanbean();
	Test1 t = new Test1();
	DaoGetMon gm = new DaoGetMon();
	ArrayList<banbean> b3 = new ArrayList<banbean>();
	ArrayList<moninbanbean> mib1 = new ArrayList<moninbanbean>();
	private JScrollPane scrollPane_1;
	private JTable tbl2;
	private JScrollPane scrollPane_2;
	private JTable tbl_ban;
	
	public void napbang(ArrayList<banbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã Bàn");
		mh.addColumn("Tên Bàn");
		mh.addColumn("Trang Thái");
		mh.addColumn("Vị Trí Bàn");
		for(banbean b3 : ds){	
			Object[] t=new Object[4];
			t[0]=b3.getMaBan();
			t[1]=b3.getTenBan();
			t[2]=b3.getTrangThai();
			t[3]=b3.getViTriBan();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	
	public void napdsban(ArrayList<banbean> ds)	{
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("MaBan");
		mh.addColumn("Tên Bàn");
		for(banbean b3 : ds){	
			if(b3.getTrangThai()== false) {
			Object[] t=new Object[2];
			t[0]=b3.getMaBan();
			t[1]=b3.getTenBan();
			mh.addRow(t);
			}
		}
		tbl_ban.setModel(mh);
	}
	
	public void napmon(ArrayList<moninbanbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Tên Món");
		mh.addColumn("Số lượng");

		for(moninbanbean mib : ds)	{	
			Object[] t=new Object[2];
			t[0]=mib.getTenMon();
			t[1]=mib.getSoLuongMon();
			mh.addRow(t);
		}
		tbl2.setModel(mh);
	}
	
	public FrmBanMon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try	{
					connectDB.KetNoi();;
					napbang(b1.getban());
//					napmon(mibb.getmon("B1"));
					
				}catch(Exception e)	{
					e.printStackTrace();
				}
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
//		//Click tren Table
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//				try {
//					int row = table.getSelectedRow();
//					String MaBan = table.getModel().getValueAt(row, 0).toString();
//					t.KetNoi();
//					napmon(mibb.getmon(MaBan));
//					
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//				
//			}
//		});
		final JFrame parent = new JFrame();
        JButton button = new JButton();

     
		
		scrollPane.setBounds(10, 11, 113, 95);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 144, 278, 106);
		contentPane.add(scrollPane_1);
		
		tbl2 = new JTable();
		scrollPane_1.setViewportView(tbl2);
		
		JButton bt = new JButton("Chuyển bàn");
		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					napdsban(b1.getban());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//Bang 
	
		bt.setBounds(148, 11, 118, 23);
		contentPane.add(bt);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(294, 11, 130, 95);
		contentPane.add(scrollPane_2);
		
		tbl_ban = new JTable();
		scrollPane_2.setViewportView(tbl_ban);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String MaBan = table.getModel().getValueAt(row, 0).toString();
				try {
					connectDB.KetNoi();
					napmon(mibb.getmon(MaBan));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
//				
				
			}
		});
		tbl_ban.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String MaBan = table.getModel().getValueAt(row, 0).toString();
				int row1 = tbl_ban.getSelectedRow();
				String MaBan1 = tbl_ban.getModel().getValueAt(row, 0).toString();
				try {
					gm.DoiBan(MaBan, MaBan1);
					gm.CapNhatBanDich(MaBan1);
					gm.CapNhatBanNguon(MaBan);
					napbang(b1.getban());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
//				
				
			}
		});
		   
	        

	      
	}
}
