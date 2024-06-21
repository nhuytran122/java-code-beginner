
public class TinB extends HocVien {
	private Double diemExcel;
	private Double diemPp;
	private Double diemWeb;
	
	public TinB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TinB(String msv, String hoten, Double diemExcel, Double diemPp, Double diemWeb) {
		super(msv, hoten);
		this.diemExcel = diemExcel;
		this.diemPp = diemPp;
		this.diemWeb = diemWeb;
		// TODO Auto-generated constructor stub
	}
	public Double getDiemExcel() {
		return diemExcel;
	}
	public void setDiemExcel(Double diemExcel) {
		this.diemExcel = diemExcel;
	}
	public Double getDiemPp() {
		return diemPp;
	}
	public void setDiemPp(Double diemPp) {
		this.diemPp = diemPp;
	}
	public Double getDiemWeb() {
		return diemWeb;
	}
	public void setDiemWeb(Double diemWeb) {
		this.diemWeb = diemWeb;
	}
	@Override
	public String toString() {
		//"TinA [" + "ten SV: " + hoten + ", diemWin, " + "diemWord=" + diemWord + "]";
		return "TinB [" + "ten SV: " + hoten + ", diemExcel: " + diemExcel + ", diemPp: " + diemPp +  ", diemWeb=" + diemWeb + "]";
	}
	public Double DTB() {
		return (diemExcel + diemPp + diemWeb)/3;
	}
	

}
