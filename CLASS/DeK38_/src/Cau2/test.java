package Cau2;

import java.math.BigInteger;
import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		Cau2_3 u = new Cau2_3();
		ArrayList<Integer> kq = new ArrayList<Integer>();
		ArrayList<String> dsve = new ArrayList<String>();
		u.Tachdong_tufile(kq, dsve);
		
		//2.3a
		System.out.println("\nKiểm tra file input1.txt có chứa 6 số hợp lệ hay không: ");
		boolean ch = u.ktDaySo(kq);
		if(ch == false)
			System.out.println("Dãy số không hợp lệ!\n");
		else System.out.println("Dãy số hợp lệ!\n");
		
		for(int i=0; i < dsve.size(); i++) {
			String[] t = dsve.get(i).split("[,]");
			ch = u.KtThongtinVe(t);
			if(ch == false)
				System.out.println("Vé dự thưởng ở dòng số " + (i+1) + " không hợp lệ!");
		}

		int svdb = 0, nhat = 0, nhi = 0, ba = 0; 
		ArrayList<BigInteger> tienthuong = new ArrayList<BigInteger>();
		ArrayList<String> giaithuong = new ArrayList<String>();
		
		for(int i=0; i < dsve.size(); i++) {
			String[] t = dsve.get(i).split("[,]");
			int tmp = u.Soluongsotrung(t, kq);
			int slv = Integer.parseInt(t[3].trim());
			if(tmp == 6) svdb += slv;
			else if(tmp == 5) nhat += slv;
			else if(tmp == 4) nhi += slv;
			else if(tmp == 3) ba += slv;
		}
		
		u.XuatThongTinGt(dsve, kq, svdb, giaithuong, tienthuong);
		
		System.out.println("\n2.5 Tổng số lượng vé đã trúng thưởng tương ứng với mỗi giải thưởng:");
		System.out.println("Giai dac biet: co " + svdb + " ve trung thuong");
		System.out.println("Giai nhat: co " + nhat + " ve trung thuong");
		System.out.println("Giai nhi: co " + nhi + " ve trung thuong");
		System.out.println("Giai ba: co " + ba + " ve trung thuong");
		
		u.Napdata(dsve, tienthuong, giaithuong);
		
	}
}
