package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.monbean;
import bo.monbo;
import dao.connectDB;
import dao.mondao;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FrmXoaMon extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXoaMon frame = new FrmXoaMon();
					frame.setVisible(true);
					frame.setTitle("Quản lí món");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	monbo mbo = new monbo();
	monbean mbean = new monbean();
	mondao mdao = new mondao();
	
	private JScrollPane scrollPane;
	private JTable table;
	private JButton bt;
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
	public FrmXoaMon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					connectDB.KetNoi();
					ImportTable(mbo.getmon());		
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 538, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final JFrame parent = new JFrame();
		JButton button = new JButton();

        //button.setText("Click me to show dialog!");
        parent.getContentPane().add(button);
//        parent.pack();
//        parent.setVisible(true);
		
		bt = new JButton("Xóa");
		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table.getSelectedRow();
					String value = table.getModel().getValueAt(row, 0).toString();
					String TenMon = table.getModel().getValueAt(row, 1).toString();
					mbean.setMamon(value);
					if(row>=0){
						int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa: " + TenMon + " ?", "Xóa " + TenMon, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (check == JOptionPane.YES_OPTION){
							try {
								mbo.Xoa(mbean);
								ImportTable(mbo.getmon());
							} catch (Exception e) {
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
				} catch (Exception e) {
					e.getMessage();
				}
				
			}
		});
		bt.setBounds(228, 267, 89, 23);
		contentPane.add(bt);
		
	}
	
	
}
