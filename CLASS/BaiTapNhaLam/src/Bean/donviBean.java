package Bean;

public class donviBean {
	private String madv;
	private String tendv;
	public donviBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public donviBean(String madv, String tendv) {
		super();
		this.madv = madv;
		this.tendv = tendv;
	}
	public String getMadv() {
		return madv;
	}
	public void setMadv(String madv) {
		this.madv = madv;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	@Override
	public String toString() {
		return "donviBean [madv=" + madv + ", tendv=" + tendv + "]";
	}
	
}