
public class tinB extends hocvien {
	private Double Excel;
	private Double Pp;
	private Double Web;
	
	public tinB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tinB(String msv, String hoten, Double diemExcel, Double diemPp, Double diemWeb) {
		super(msv, hoten);
		this.Excel = diemExcel;
		this.Pp = diemPp;
		this.Web = diemWeb;
		// TODO Auto-generated constructor stub
	}
	public Double getDiemExcel() {
		return Excel;
	}
	public void setDiemExcel(Double diemExcel) {
		this.Excel = diemExcel;
	}
	public Double getDiemPp() {
		return Pp;
	}
	public void setDiemPp(Double diemPp) {
		this.Pp = diemPp;
	}
	public Double getDiemWeb() {
		return Web;
	}
	public void setDiemWeb(Double diemWeb) {
		this.Web = diemWeb;
	}
	@Override
	public String toString() {
		//"TinA [" + "ten SV: " + hoten + ", diemWin, " + "diemWord=" + diemWord + "]";
		return "TinB [" + "ten SV: " + ten + "; diemExcel: " + Excel + "; diemPp: " + Pp +  "; diemWeb=" + Web + "]";
	}
	public Double DTB() {
		return (Excel + Pp + Web)/3;
	}
	

}
