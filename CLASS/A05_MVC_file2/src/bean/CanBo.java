package bean;

public class CanBo extends Nguoi {
	private String macb;
	private String tendv;
	
	public CanBo(String macb, String hoten, int tuoi, String tendv) {
		super(hoten, tuoi);
		this.macb = macb;
		this.tendv = tendv;
	}

	public String getMacb() {
		return macb;
	}

	public void setMacb(String macb) {
		this.macb = macb;
	}

	public String getTendv() {
		return tendv;
	}

	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public static void hienthi() {
		System.out.println("Ten CB: " + hoten);
	}
}
