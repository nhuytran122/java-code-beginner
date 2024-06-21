package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.monbean;
import bo.monbo;
import dao.connectDB;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmTimMon extends JFrame {

	private JPanel contentPane;
	private JTextField txtMamon;
	private JTextField txtTenmon;
	private JTextField txtGia;
	private JTextField txtLoaimon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTimMon frame = new FrmTimMon();
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
	monbo mbo = new monbo();
	monbean mbe = new monbean();
	ArrayList<monbean> ds = new ArrayList<monbean>();
	private JTable table;
	public void ImportTable(ArrayList<monbean> list){
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Mã Món");
		mh.addColumn("Tên Món");
		mh.addColumn("Giá");
		mh.addColumn("Loại Món");
		for(monbean mb3 : list){	
			Object[] t=new Object[4];
			t[0]=mb3.getMamon();
			t[1]=mb3.getTenmon();
			t[2]=mb3.getGia();
			t[3]=mb3.getLoaimon();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public FrmTimMon() {
		setTitle("Món");
		setForeground(SystemColor.inactiveCaption);
		setBackground(SystemColor.inactiveCaption);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					connectDB.KetNoi();
					ImportTable(mbo.getmon());		
				}catch(Exception m){
					m.printStackTrace();
				}
					
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Cancel");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAdd.setBounds(551, 90, 111, 34);
		contentPane.add(btnAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBackground(Color.LIGHT_GRAY);
		btnFind.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=JOptionPane.showInputDialog("Nhap ten mon can tim: ");
				try	{
					if(mbo.Find(input).size() == 0)	{
						JOptionPane.showMessageDialog(null, "Khong co mon can tim!");
					}
					else{
						ImportTable(mbo.Find(input));
					}
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnFind.setBounds(551, 193, 111, 34);
		contentPane.add(btnFind);
		
		txtMamon = new JTextField();
		txtMamon.setBounds(314, 32, 212, 34);
		contentPane.add(txtMamon);
		txtMamon.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FoodID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(229, 29, 75, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FoodName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(229, 93, 96, 28);
		contentPane.add(lblNewLabel_1);
		
		txtTenmon = new JTextField();
		txtTenmon.setBounds(314, 93, 212, 34);
		contentPane.add(txtTenmon);
		txtTenmon.setColumns(10);
		
		txtGia = new JTextField();
		txtGia.setBounds(314, 167, 212, 34);
		contentPane.add(txtGia);
		txtGia.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_3.setBounds(229, 169, 43, 24);
		contentPane.add(lblNewLabel_3);
		
		txtLoaimon = new JTextField();
		txtLoaimon.setBounds(314, 238, 212, 34);
		contentPane.add(txtLoaimon);
		txtLoaimon.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_4.setBounds(229, 238, 43, 28);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 314, 639, 166);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Image");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_5.setBounds(88, 258, 54, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\Screenshot 2022-05-11 090002.png"));
		lblNewLabel_6.setBounds(23, 69, 171, 179);
		contentPane.add(lblNewLabel_6);
	}
}
