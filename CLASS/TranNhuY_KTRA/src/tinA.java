
public class tinA extends hocvien {
	private Double Win;
	private Double Word;
	
	public tinA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tinA(String msv, String hoten, Double diemWin, Double diemWord) {
		super(msv, hoten);
		this.Win = diemWin;
		this.Word = diemWord;
		// TODO Auto-generated constructor stub
	}
	public Double getDiemWin() {
		return Win;
	}
	public void setDiemWin(Double diemWin) {
		this.Win = diemWin;
	}
	public Double getDiemWord() {
		return Word;
	}
	public void setDiemWord(Double diemWord) {
		this.Word = diemWord;
	}
	@Override
	public String toString() {
		return "TinA [" + "ten SV: " + ten + "; diemWin: " + Win +  "; diemWord=" + Word + "]";
	}
	public Double DTB() {
		return (Win + Word)/2;
	}
	

}
