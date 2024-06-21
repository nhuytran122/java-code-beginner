package bean;

public class moninbanbean {
	private String TenMon;
	private int SoLuongMon;
	public moninbanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public moninbanbean(String tenMon, int soLuongMon) {
		super();
		TenMon = tenMon;
		SoLuongMon = soLuongMon;
	}
	public String getTenMon() {
		return TenMon;
	}
	public void setTenMon(String tenMon) {
		TenMon = tenMon;
	}
	public int getSoLuongMon() {
		return SoLuongMon;
	}
	public void setSoLong(int soLuongMon) {
		SoLuongMon = soLuongMon;
	}
	
}
