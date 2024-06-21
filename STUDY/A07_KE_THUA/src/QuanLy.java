public class QuanLy {
	public static void main(String[] args) {
		System.out.println("Kiểm tra");
//		Nguoi cn = new Nguoi("TITV" , 2021);
//		cn.an();
//		cn.uong();
//		cn.ngu();
		
		HocSinh hs = new HocSinh("TITV", 2021, "Lớp 1", "Trường 1");
		hs.an();
		hs.uong();
		hs.ngu();
		hs.lamBaiTap();
	}
}