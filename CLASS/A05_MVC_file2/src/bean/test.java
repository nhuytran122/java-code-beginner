package bean;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<Nguoi> ds = new ArrayList<Nguoi>();
		// TODO Auto-generated method stub
		Nguoi n1 = new Nguoi("Hung", 19);
		n1.hienthi();
		ds.add(n1);
		
		SinhVien sv1 = new SinhVien("SV1", "Minh", 20, 6.5);
		sv1.hienthi();
		ds.add(sv1);
		
		// new ra lớp nào, dùng hàm làm lớp đó, NẾU ĐÓ LÀ HÀM GHI ĐÈ
		//NẾU LÀ HÀM ẢO (THÊM STATIC VÀO BIẾN CẦN TRUYỀN VÀO HÀM ẢO VÀ HÀM ĐÓ): chỉ quan tâm ob đó thuộc lớp nào thì dùng hàm lớp đó
		SinhVien sv2 = new SinhVien("SV2", "Tuan", 21, 5.5);
		sv2.hienthi();
		ds.add(sv2);
		
		CanBo cb1 = new CanBo("CB1", "Long", 20, "CNTT");
		cb1.hienthi();
		ds.add(cb1);
		for (Nguoi n:ds)
//			if(n instanceof SinhVien) {
//				SinhVien sv = (SinhVien) n;
//				System.out.println(sv.getHoten() + " " + sv.getDtb());
//			}
			if(n instanceof CanBo) {
				CanBo cb = (CanBo) n;
				System.out.println(cb.getHoten() + " " + cb.getTendv());
			}
	}

}
