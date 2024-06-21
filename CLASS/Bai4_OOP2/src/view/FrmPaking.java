package view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Xebean;
import bo.XeBo;
import java.awt.Font;

public class FrmPaking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPaking frame = new FrmPaking();
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
	ArrayList<Xebean> dsv;
	ArrayList<Xebean> dsr;
	XeBo xebo = new XeBo();
	ArrayList<Xebean> ds;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	void NapBang(ArrayList<Xebean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Loại xe");
		mh.addColumn("Biển số xe");
		mh.addColumn("Số vé xe");
		mh.addColumn("Thời gian vào");
		mh.addColumn("Thời gian ra");
		mh.addColumn("Tiền thuê bãi");
		for(Xebean xe:ds) {
			Object[] t = new Object[7];
			t[0] = xe.getLoaiXe();
			t[1] = xe.getBienSoXe();
			t[2] = xe.getSoVeXe();
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy"); 
			t[3] = d.format(xe.getTimeVao());
			t[4] = d.format(xe.getTimeRa());
			t[5] = xe.tinhTien();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	
	void NapBang2(ArrayList<Xebean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Loại xe");
		mh.addColumn("Biển số xe");
		mh.addColumn("Số vé xe");
		mh.addColumn("Thời gian vào");
		mh.addColumn("Tình trạng vào");
		for(Xebean xe:ds) {
			Object[] t = new Object[7];
			t[0] = xe.getLoaiXe();
			t[1] = xe.getBienSoXe();
			t[2] = xe.getSoVeXe();
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy"); 
			t[3] = d.format(xe.getTimeVao());
			t[4] = xe.getTinhTrangVaoBai();
			mh.addRow(t);
		}
		table_1.setModel(mh);
	}
	
	void NapBang3(ArrayList<Xebean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Loại xe");
		mh.addColumn("Biển số xe");
		mh.addColumn("Số vé xe");
		mh.addColumn("Thời gian ra");
		mh.addColumn("Tình trạng ra");
		for(Xebean xe:ds) {
			Object[] t = new Object[7];
			t[0] = xe.getLoaiXe();
			t[1] = xe.getBienSoXe();
			t[2] = xe.getSoVeXe();
			SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy"); 
			t[3] = d.format(xe.getTimeRa());
			t[4] = xe.getTinhTrangRaBai();
			mh.addRow(t);
		}
		table_2.setModel(mh);
	}
	
	public FrmPaking() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					dsv = xebo.getXeVao();
					dsr = xebo.getXeRa();
					ds = xebo.getFullInf(dsv, dsr);
					NapBang(ds);
					NapBang2(dsv);
					NapBang3(dsr);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 755, 451);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Tiền thuê", null, scrollPane, null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Xe vào", null, scrollPane_1, null);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1.setViewportView(table_1);
		
		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Xe ra", null, scrollPane_2, null);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(table_2);
	}
}
