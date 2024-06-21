package LTGiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class A03_FrmBanHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtgia;
	private JTextField txtsl;
	private JTextField txttt;
	JComboBox cmbhang = new JComboBox();
	ArrayList<String> ds = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A03_FrmBanHang frame = new A03_FrmBanHang();
					//form mở ra
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
	public A03_FrmBanHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f = new FileReader("hang.txt");
					BufferedReader b = new BufferedReader(f);
					while(true) {
						String st = b.readLine();
						if(st == null || st == "") break;
						//dua vao combhang
						String[] t = st.split("[;]");
						cmbhang.addItem(t[0]);
						//Luu vao mang
						ds.add(st);
					}
					b.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel a = new JLabel("Chọn hàng");
		a.setBounds(31, 36, 76, 14);
		contentPane.add(a);
		
		JLabel lblNewLabel = new JLabel("Giá");
		lblNewLabel.setBounds(31, 90, 49, 14);
		contentPane.add(lblNewLabel);
		
		txtgia = new JTextField();
		txtgia.setEditable(false);
		txtgia.setBounds(215, 81, 277, 32);
		contentPane.add(txtgia);
		txtgia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập số lượng");
		lblNewLabel_1.setBounds(31, 150, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		txtsl = new JTextField();
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //enter
					double g = Double.parseDouble(txtgia.getText());
					double sl = Double.parseDouble(txtsl.getText());
					Double tt = g*sl;
					txttt.setText(tt.toString());
				}
			}
		});
		txtsl.setColumns(10);
		txtsl.setBounds(215, 141, 277, 32);
		contentPane.add(txtsl);
		
		txttt = new JTextField();
		txttt.setColumns(10);
		txttt.setBounds(215, 206, 277, 32);
		contentPane.add(txttt);
		
		JLabel lblNewLabel_2 = new JLabel("Thành tiền");
		lblNewLabel_2.setBounds(31, 215, 76, 14);
		contentPane.add(lblNewLabel_2);
		cmbhang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Lấy tên hàng vừa chọn
				String tenhang = cmbhang.getSelectedItem().toString();
				//Duyệt mảng ds chứa các hàng
				for(String h:ds) {
					//Chẻ hàng ra thành 2 thông tin
					String[] t = h.split("[;]");
					//t[0]: chứa tên hàng
					//t[1]: chứa giá
					if(t[0].equals(tenhang))
						txtgia.setText(t[1]);
				}
			}
		});
		
		cmbhang.setBounds(215, 27, 277, 32);
		contentPane.add(cmbhang);

	}
}