
public class TinA extends HocVien {
	private Double diemWin;
	private Double diemWord;
	
	public TinA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TinA(String msv, String hoten, Double diemWin, Double diemWord) {
		super(msv, hoten);
		this.diemWin = diemWin;
		this.diemWord = diemWord;
		// TODO Auto-generated constructor stub
	}
	public Double getDiemWin() {
		return diemWin;
	}
	public void setDiemWin(Double diemWin) {
		this.diemWin = diemWin;
	}
	public Double getDiemWord() {
		return diemWord;
	}
	public void setDiemWord(Double diemWord) {
		this.diemWord = diemWord;
	}
	@Override
	public String toString() {
		return "TinA [" + "ten SV: " + hoten + ", diemWin, " + "diemWord=" + diemWord + "]";
	}
	public Double DTB() {
		return (diemWin + diemWord)/2;
	}
	

}
