package LTGiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class A04_FrmHang2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<B01_Hang> dshang = new ArrayList<B01_Hang>();
	private JTextField txtgia;
	private JTextField txthang;

	void NapBang(ArrayList<B01_Hang> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		// tao cot
		mh.addColumn("Tên hàng");
		mh.addColumn("Giá");
		//them dong
		for(B01_Hang h:ds) {
			Object[] t = new Object[2];
			t[0] = h.getTenhang(); 
			t[1] = h.getGia();
			mh.addRow(t);
		}
		//dua mo hinh vao bang
		table.setModel(mh);		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A04_FrmHang2 frame = new A04_FrmHang2();
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
	public A04_FrmHang2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f = new FileReader("hang.txt");
					BufferedReader b = new BufferedReader(f);
					while(true) {
						String tt = b.readLine();
						if(tt == null || tt == "") break;
						String[] t = tt.split("[;]");
						long gia = Long.parseLong(t[1]);
						B01_Hang h2 = new B01_Hang(t[0], gia);
						dshang.add(h2);
					}
					b.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				NapBang(dshang);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 843, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(135, 285, 633, 210);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//lay dong vua chon
				int d = table.getSelectedRow();
				String th = table.getValueAt(d, 0).toString();
				String gia = table.getValueAt(d, 1).toString();
				txthang.setText(th);
				txtgia.setText(gia);	
			}
		});
		scrollPane.setViewportView(table);
		
		txtgia = new JTextField();
		txtgia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgia.setBounds(190, 129, 543, 48);
		contentPane.add(txtgia);
		txtgia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên hàng");
		lblNewLabel.setBounds(54, 51, 98, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Giá");
		lblNewLabel_1.setBounds(54, 136, 67, 31);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		txthang = new JTextField();
		txthang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txthang.setBounds(187, 39, 543, 48);
		contentPane.add(txthang);
		txthang.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(157, 219, 112, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				B01_Hang h2 = new B01_Hang(txthang.getText(), Long.parseLong(txtgia.getText()));
				dshang.add(h2);
				NapBang(dshang);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = JOptionPane.showInputDialog("Nhập tên hàng cần xóa");
				for(B01_Hang h:dshang) {
					if(h.getTenhang().equals(th)) {
						dshang.remove(h);
						break;
					}
				}
				NapBang(dshang);
			}
		});
		btnNewButton_1.setBounds(279, 219, 112, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = txthang.getText();
				for(B01_Hang h:dshang) {
					if(h.getTenhang().equals(th)) {
						h.setGia(Long.parseLong(txtgia.getText()));
					}
				}
				NapBang(dshang);
			}
		});
		btnNewButton_2.setBounds(402, 219, 112, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("FIND");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Nhập tên hàng cần tìm: ");
				ArrayList<B01_Hang> tmp = new ArrayList<B01_Hang>();
				try	{
					for(B01_Hang hang:dshang){
						if(hang.getTenhang().toLowerCase().contains(input.toLowerCase()) || hang.getTenhang().contains(input))
							tmp.add(hang);
					}
					if(tmp.size() == 0)	{
						JOptionPane.showMessageDialog(null, "Không có hàng cần tìm!");
					}
					else{
						NapBang(tmp);
					}
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(524, 219, 112, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SAVE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f = new FileWriter("hang.txt");
					PrintWriter ghi = new PrintWriter(f);
					for(B01_Hang h:dshang)
						ghi.println(h.getTenhang() + ";" + h.getGia());
					ghi.close();
					JOptionPane.showMessageDialog(null, "Đã lưu");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(646, 219, 112, 40);
		contentPane.add(btnNewButton_4);
	}
}
