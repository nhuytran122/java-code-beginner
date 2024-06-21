
public class hocvien {
	protected String msv;
	protected String ten;
	
	public hocvien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hocvien(String msv, String hoten) {
		super();
		this.msv = msv;
		this.ten = hoten;
	}
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getHoten() {
		return ten;
	}
	public void setHoten(String hoten) {
		this.ten = hoten;
	}
	@Override
	public String toString() {
		return "HocVien [msv=" + msv + ", hoten=" + ten + "]";
	}
	
}
