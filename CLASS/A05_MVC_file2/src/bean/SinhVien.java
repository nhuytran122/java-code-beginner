package bean;

public class SinhVien extends Nguoi {
	private String MaSv;
	private Double dtb;
	public SinhVien(String MaSv, String hoten, int tuoi, Double dtb) {
		super(hoten, tuoi); //Truyen hoten, tuoi len lop cha (Nguoi)
		this.MaSv = MaSv;
		this.dtb = dtb;
	}
	public String getMaSv() {
		return MaSv;
	}
	public void setMaSv(String maSv) {
		MaSv = maSv;
	}
	public Double getDtb() {
		return dtb;
	}
	public void setDtb(Double dtb) {
		this.dtb = dtb;
	}
	public static void hienthi() {
		System.out.println("Ten SV: " + hoten);
	}
}

