package bean;

public class banbean {
	private String MaBan;
	private String TenBan;
	private Boolean TrangThai;
	private String ViTriBan;
	public banbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaBan() {
		return MaBan;
	}
	public void setMaBan(String maBan) {
		MaBan = maBan;
	}
	public String getTenBan() {
		return TenBan;
	}
	public void setTenBan(String tenBan) {
		TenBan = tenBan;
	}
	public Boolean getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}
	public String getViTriBan() {
		return ViTriBan;
	}
	public void setViTriBan(String viTriBan) {
		ViTriBan = viTriBan;
	}
	public banbean(String maBan, String tenBan, Boolean trangThai, String viTriBan) {
		super();
		MaBan = maBan;
		TenBan = tenBan;
		TrangThai = trangThai;
		ViTriBan = viTriBan;
	}
	
	
	
	
	
}
