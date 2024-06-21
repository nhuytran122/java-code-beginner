
public class A2_vdString2 {

	public static void main(String[] args) {
		String tt = "Le Nam|K45|CNTT|DHKH|4.5|5.5";
		// In ra ho ten va ten, ten khoa va dtb;
		String[] tt2 = tt.split("[|]");
		System.out.println("Ho va ten: " + tt2[0]);
		System.out.println("Ten khoa: " + tt2[2]);
		float dtb = (Float.parseFloat(tt2[4]) + Float.parseFloat(tt2[5]))/2;
		System.out.println("DTB: " + dtb);
		// Sử dụng lớp Pattern và Matcher trong Java
		// BT: Nhập vào 1 địa chỉ email, sđt và ngày sinh của 1 SV. Sau đó kiểm tra xem 3 thông tin nhập hay không
	}

}
