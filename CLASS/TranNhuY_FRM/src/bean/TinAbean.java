package bean;


public class TinAbean extends HocVienbean {
	private Double diemWin;
	private Double diemWord;
	
	public TinAbean() {
		super();
	}
	public TinAbean(String msv, String hoten, Double diemWin, Double diemWord) {
		super(msv, hoten);
		this.diemWin = diemWin;
		this.diemWord = diemWord;
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
		return "TinA [" + "ten SV: " + hoten + ", diemWin: " + diemWin + ", diemWord=" + diemWord + "]";
	}
	public Double DTB() {
		return (diemWin + diemWord)/2;
	}
	

}

