
public class HocVien {
	protected String msv;
	protected String hoten;
	
	public HocVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HocVien(String msv, String hoten) {
		super();
		this.msv = msv;
		this.hoten = hoten;
	}
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	@Override
	public String toString() {
		return "HocVien [msv=" + msv + ", hoten=" + hoten + "]";
	}
	
}
