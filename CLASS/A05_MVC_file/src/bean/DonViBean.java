package bean;

public class DonViBean {
	private String madv;
	private String tendv;
	
	public DonViBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonViBean(String madv, String tendv) {
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
		return "DonViBean [madv=" + madv + ", tendv=" + tendv + "]";
	}
	
	

	
}
