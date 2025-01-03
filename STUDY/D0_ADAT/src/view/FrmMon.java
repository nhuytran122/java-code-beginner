package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.monbean;
import bo.monbo;
import dao.connectDB;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmMon extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenmon;
	private JTextField txtMamon;
	private JTextField txtGia;
	private JTable tblBang;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMon frame1 = new FrmMon();
					frame1.setVisible(true);
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
	private JTextField txtLoaimon;
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
		tblBang.setModel(mh);
	}
	
	public FrmMon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try{
					connectDB.KetNoi();
					ImportTable(mbo.getmon());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		setBackground(Color.LIGHT_GRAY);
		setTitle("ADD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTenmon = new JTextField();
		txtTenmon.setBounds(273, 57, 273, 30);
		contentPane.add(txtTenmon);
		txtTenmon.setColumns(10);
		
		txtMamon = new JTextField();
		txtMamon.setColumns(10);
		txtMamon.setBounds(273, 8, 273, 30);
		contentPane.add(txtMamon);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(273, 155, 273, 30);
		contentPane.add(txtGia);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				monbean mb = new monbean(txtMamon.getText(), txtTenmon.getText(), txtGia.getText(),txtLoaimon.getText());
//				mbe.setMamon(txtMamon.getText());
//				mbe.setTenmon(txtTenmon.getText());
//				mbe.setGia(txtGia.getText());
//				mbe.setLoaimon(txtLoaimon.getText());
				try{
					if (mb.getMamon().equals("")|| mb.getTenmon().equals("") || mb.getGia().equals("") || mb.getLoaimon().equals("")){
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
					}
					else{
						if(mbo.themmon(mb) == 0){
							JOptionPane.showMessageDialog(null, "Mon nay da co trong menu!");
						}
						else{
								ImportTable(mbo.getmon());
								JOptionPane.showMessageDialog(null, "Thêm món thành công");
						}
					}
					
				}catch(Exception tt){
					tt.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(386, 211, 99, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("DrinksID");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 14));
		lblNewLabel.setBounds(192, 10, 92, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnMn = new JLabel("DrinksName");
		lblTnMn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 14));
		lblTnMn.setBounds(192, 59, 108, 23);
		contentPane.add(lblTnMn);
		
		JLabel lblGi = new JLabel("Price");
		lblGi.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 14));
		lblGi.setBounds(192, 157, 53, 23);
		contentPane.add(lblGi);
		
		JLabel lblNewLabel_3_1 = new JLabel("Type");
		lblNewLabel_3_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 14));
		lblNewLabel_3_1.setBounds(192, 106, 53, 23);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnCancle = new JButton("CANCEL");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 15));
		btnCancle.setBounds(273, 211, 99, 30);
		contentPane.add(btnCancle);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 14));
		lblImage.setBounds(69, 193, 53, 23);
		contentPane.add(lblImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 263, 623, 105);
		contentPane.add(scrollPane);
		
		tblBang = new JTable();
		scrollPane.setViewportView(tblBang);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("tra_dao.jpg"));
		lblNewLabel_1.setBounds(22, 44, 151, 149);
		contentPane.add(lblNewLabel_1);
		
		txtLoaimon = new JTextField();
		txtLoaimon.setColumns(10);
		txtLoaimon.setBounds(273, 104, 273, 30);
		contentPane.add(txtLoaimon);
		
	}
}
