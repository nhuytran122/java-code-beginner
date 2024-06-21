package bean;

public class Nguoi {
	static protected String hoten;
	protected int tuoi;
	public Nguoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nguoi(String hoten, int tuoi) {
		super();
		this.hoten = hoten;
		this.tuoi = tuoi;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public static void hienthi() {
		System.out.println("Ten nguoi: " + hoten);
	}
	
}
