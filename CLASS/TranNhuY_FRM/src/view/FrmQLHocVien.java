package view;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.HocVienbean;
import bean.TinAbean;
import bean.TinBbean;
import bo.HocVienbo;
import bo.TinAbo;
import bo.TinBbo;
import dao.HocViendao;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmQLHocVien extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	TinAbo tAbo = new TinAbo();
	TinBbo tBbo = new TinBbo();
	HocViendao hvd;
	HocVienbo hvbo = new HocVienbo();
	ArrayList<HocVienbean> ds;
	ArrayList<TinAbean> dsA;
	ArrayList<TinBbean> dsB;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	private JTable table_2;
	void NapBang1(ArrayList<TinAbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã SV");
		mh.addColumn("Tên SV");
		mh.addColumn("Điểm Win");
		mh.addColumn("Điểm Word");
		mh.addColumn("Điểm TB");
		for(TinAbean sv:ds) {
			Object[] t = new Object[6];
			t[0] = sv.getMsv();
			t[1] = sv.getHoten();
			t[2] = sv.getDiemWin();
			t[3] = sv.getDiemWord();
			t[4] = sv.DTB();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	
	void NapBang2(ArrayList<TinBbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã SV");
		mh.addColumn("Tên SV");
		mh.addColumn("Điểm Excel");
		mh.addColumn("Điểm Powerpoint");
		mh.addColumn("Điểm Web");
		mh.addColumn("Điểm TB");
		for(TinBbean sv:ds) {
			Object[] t = new Object[7];
			t[0] = sv.getMsv();
			t[1] = sv.getHoten();
			t[2] = sv.getDiemExcel();
			t[3] = sv.getDiemPp();
			t[4] = sv.getDiemWeb();
			t[5] = sv.DTB();
			mh.addRow(t);
		}
		table_1.setModel(mh);
	}
	void NapBang(ArrayList<HocVienbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã SV");
		mh.addColumn("Tên SV");
		mh.addColumn("Điểm Win");
		mh.addColumn("Điểm Word");
		mh.addColumn("Điểm Excel");
		mh.addColumn("Điểm Powerpoint");
		mh.addColumn("Điểm Web");
		mh.addColumn("Điểm TB");
		for(HocVienbean sv:ds) {
			Object[] t = new Object[9];
			t[0] = sv.getMsv();
			t[1] = sv.getHoten();
			if(sv instanceof TinAbean) {
				TinAbean tA = (TinAbean) sv;
				t[2] = tA.getDiemWin();
				t[3] = tA.getDiemWord();
				t[4] = t[5] = t[6] = "NULL";
				t[7] = tA.DTB();
			}
			else {
				TinBbean tB = (TinBbean) sv;
				t[2] = t[3] = "NULL";
				t[4] = tB.getDiemExcel();
				t[5] = tB.getDiemPp();
				t[6] = tB.getDiemWeb();
				t[7] = tB.DTB();
			}
			
			mh.addRow(t);
		}
		table_2.setModel(mh);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLHocVien frame = new FrmQLHocVien();
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
	public FrmQLHocVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					dsA = tAbo.getTinA();
					NapBang1(dsA);
					dsB = tBbo.getTinB();
					NapBang2(dsB);
					ds = hvbo.getSV();
					NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 25, 710, 370);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Tin A", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Tin B", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Full List", null, scrollPane_2, null);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Nhập tên SV cần tìm: ");
				ArrayList<HocVienbean> tmp = new ArrayList<HocVienbean>();
				try	{
					for(HocVienbean sv:ds){
						if(sv.getHoten().toLowerCase().contains(input.toLowerCase()) || sv.getHoten().contains(input))
							tmp.add(sv);
					}
					if(tmp.size() == 0)	{
						JOptionPane.showMessageDialog(null, "Không có SV cần tìm!");
					}
					else{
						NapBang(tmp);
					}
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnTim.setBounds(326, 406, 110, 29);
		contentPane.add(btnTim);
	}
}
