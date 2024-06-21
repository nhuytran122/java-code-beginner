package Cau2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Cau2_3 {
	public void Cau21_22(ArrayList<Integer> kq, ArrayList<String> tt2){
		//2.1 - 2.2: tách từng dòng đưa vào arraylist)
		try {
			FileReader f1 = new FileReader("input1.txt");
			BufferedReader b1 = new BufferedReader(f1);
					
			FileReader f2 = new FileReader("input2.txt");
			BufferedReader b2 = new BufferedReader(f2);
			while(true) {
				String st1 = b1.readLine();
				if(st1 == null || st1 == "") break;
				kq.add(Integer.parseInt(st1));
			}
			b1.close();
			
			while(true) {
				String st2 = b2.readLine();
				if(st2 == null || st2 == "") break;
				tt2.add(st2);
			}
			b2.close();
					
			System.out.println("Kết quả trúng thưởng: " + kq);
					
			System.out.println("\nThông tin người tham gia:");
			for(String tmp:tt2)
				System.out.println(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//KT không trùng nhau và nằm trong khoảng từ 1 đến 45?
	boolean ktDaySo(ArrayList<Integer> a){
		boolean ch1 = true, ch2 = true;
		int n = a.size();
		for(int t : a)
			if(t < 1 || t > 45) 
				ch1 = false;
		
		for(int i=0; i < n-1; i++){
			for(int j = i+1; j<n; j++){
				if(a.get(i).equals(a.get(j))){
					ch2 = false;
					break;
				}
			}
		}
		return ch1 && ch2;
	}
	
	//có chứa thông tin hợp lệ? có thứ tự thông tin đúng như format? không được trùng nhau, nằm trong khoảng từ 1 đến 45 và phải được sắp xếp theo thứ tự tăng dần. 
	public boolean KtThongtinVe(String[] t){
		Cau2_3 u = new Cau2_3();
		if(!(u.KtSdt(t[2].trim())))
			return false;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int j = 4; j <= 9; j++) {
			int so1 = Integer.parseInt(t[j-1].trim());
			int so2 = Integer.parseInt(t[j].trim());
			tmp.add(so2);
			if(j-1 == 3)
				continue;
//			if(so2 < 1 || so2 > 45) 
//				return false;	
			if (so1 > so2)
		        return false;
		}
		if(!ktDaySo(tmp)) return false;
	    return true;
	}
	
	public int Soluongsotrung (String[] t, ArrayList<Integer> kq) {
		int cnt = 0;
			for(int j = 4; j <= 9; j++) {
				int so = Integer.parseInt(t[j].trim());
				if(kq.contains(so)) {
					cnt++;
				}
			}
			return cnt;
		}
	//c2
//		for(int k = 0; k < kq.size(); k++) {
//			for(int j = 4; j <= 9; j++) {
//				int so = Integer.parseInt(t[j].trim());
//				if(kq.get(k) == so) {
////					System.out.println("\nkq.get(i): " + kq.get(k));
////					System.out.println("so: " + so);
//					cnt++;
//				}
//			}
//		}
		
//	}
	
	public void Cau2_4(ArrayList<String> tt2, ArrayList<Integer> kq, int svdb, ArrayList<String> giaithuong, ArrayList<BigInteger> tienthuong) {
		try {
			BigInteger tdb = new BigInteger ("12000000000");
			FileWriter w = new FileWriter("output.txt");
			PrintWriter ghi = new PrintWriter(w);
			Cau2_3 u = new Cau2_3();
			for(int i=0; i < tt2.size(); i++) {
				String[] t = tt2.get(i).split("[,]");
				
				int slv = Integer.parseInt(t[3].trim());
				int slst = u.Soluongsotrung(t, kq);
				long gt = 0;
				
				String giai = "";
				boolean ch = true;
				BigInteger gdb = new BigInteger("0");
				if(slst == 6) {
					BigInteger slv2 = BigInteger.valueOf(slv);
					BigInteger svdb2 = BigInteger.valueOf(svdb);
					giai = "Dac biet";
					gdb = (tdb.divide(svdb2)).multiply(slv2);
					
				}
				else if(slst == 5) {
					giai = "Nhat";
					gt = 10000000 * slv;
				}
				else if(slst == 4) {
					giai = "Nhi";
					gt = 300000 * slv;
				}
				else if(slst == 3) {
					giai = "Ba";
					gt = 30000 * slv;
				}
				else {
					ch = false;
					giai = "Khong co";
					gt = 0;
				}
				
				giaithuong.add(giai);
				if(!giai.equals("Dac biet"))
					tienthuong.add(BigInteger.valueOf(gt));
				else 
					tienthuong.add(gdb);
	
				if(ch == true)
					if(slst == 6)
					ghi.print(t[0] + "," + t[1] + "," + t[2] + "," + t[3] + "," 
							+ t[4] + "," + t[5] + "," + t[6] + "," + t[7] + "," + t[8] + "," + t[9] + ", " 
							+ giai + ", " + gdb + "\n");
					else
						ghi.print(t[0] + "," + t[1] + "," + t[2] + "," + t[3] + "," 
								+ t[4] + "," + t[5] + "," + t[6] + "," + t[7] + "," + t[8] + "," + t[9] + ", " 
								+ giai + ", " + gt + "\n");
			}
			ghi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static Connection cn;
	public void ketnoi() throws Exception{
		//B1: Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("\nDa xac dinh HQTCSDL");
		//B2: Ket Noi
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433; databaseName=QLTrungThuong; user=sa; password=trannhuy; encrypt=true; trustServerCertificate=true";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	
	public boolean KtSdt(String sdt) {
		String mau = "[0][\\d]{9,10}";
	    return Pattern.matches(mau, sdt);
	}
	
	public static void main(String[] args) {
		Cau2_3 u = new Cau2_3();
		ArrayList<Integer> kq = new ArrayList<Integer>();
		ArrayList<String> tt2 = new ArrayList<String>();
		u.Cau21_22(kq, tt2);
		
		//2.3a
		System.out.println("\nKiểm tra file input1.txt có chứa 6 số hợp lệ hay không: ");
		boolean ch = u.ktDaySo(kq);
		if(ch == false)
			System.out.println("Dãy số không hợp lệ!\n");
		else System.out.println("Dãy số hợp lệ!\n");
		
		for(int i=0; i < tt2.size(); i++) {
			String[] t = tt2.get(i).split("[,]");
			ch = u.KtThongtinVe(t);
			if(ch == false)
				System.out.println("Vé dự thưởng ở dòng số " + (i+1) + " không hợp lệ!");
		}

		int svdb = 0, nhat = 0, nhi = 0, ba = 0; 
		ArrayList<BigInteger> tienthuong = new ArrayList<BigInteger>();
		ArrayList<String> giaithuong = new ArrayList<String>();
		
		for(int i=0; i < tt2.size(); i++) {
			String[] t = tt2.get(i).split("[,]");
			int tmp = u.Soluongsotrung(t, kq);
			int slv = Integer.parseInt(t[3].trim());
			if(tmp == 6) svdb += slv;
			else if(tmp == 5) nhat += slv;
			else if(tmp == 4) nhi += slv;
			else if(tmp == 3) ba += slv;
		}
		
		u.Cau2_4(tt2, kq, svdb, giaithuong, tienthuong);
		for(BigInteger tmp:tienthuong)
			System.out.println(tmp);
		for(String tmp: giaithuong)
			System.out.println(tmp);
		
		System.out.println("\n2.5 Tổng số lượng vé đã trúng thưởng tương ứng với mỗi giải thưởng:");
		System.out.println("Giai dac biet: co " + svdb + " ve trung thuong");
		System.out.println("Giai nhat: co " + nhat + " ve trung thuong");
		System.out.println("Giai nhi: co " + nhi + " ve trung thuong");
		System.out.println("Giai ba: co " + ba + " ve trung thuong");
		
		//2.6
		try {
			u.ketnoi();
			String sql = "insert into tbl_NguoiMua(Hoten, Diachi, SDT) values (?, ?, ?)";
			String sql2 = "insert into tbl_VeGiaiThuong(SDT, Soluongvemua, So1, So2, So3, So4, So5, So6, Tengiaitrung, Sotienthuong) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement cmd = cn.prepareStatement(sql);
			PreparedStatement cmd2 = cn.prepareStatement(sql2);
			
			for(int i=0; i < tt2.size(); i++) {
				String[] t = tt2.get(i).split("[,]");
				if(u.KtThongtinVe(t)) {
					cmd.setString(1, t[0].trim());
					cmd.setString(2, t[1].trim());
					cmd.setString(3, t[2].trim());
					cmd.executeUpdate();
					
					cmd2.setString(1, t[2].trim());
					cmd2.setInt(2, Integer.parseInt(t[3].trim()));
					cmd2.setInt(3, Integer.parseInt(t[4].trim()));
					cmd2.setInt(4, Integer.parseInt(t[5].trim()));
					cmd2.setInt(5, Integer.parseInt(t[6].trim()));
					cmd2.setInt(6, Integer.parseInt(t[7].trim()));
					cmd2.setInt(7, Integer.parseInt(t[8].trim()));
					cmd2.setInt(8, Integer.parseInt(t[9].trim()));
					cmd2.setString(9, giaithuong.get(i));
					cmd2.setString(10, tienthuong.get(i).toString());
					cmd2.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

