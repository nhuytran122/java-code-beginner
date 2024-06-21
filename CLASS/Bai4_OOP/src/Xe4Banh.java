import java.util.Date;

public class Xe4Banh extends Xe {
	private String BSX;
	private String ttVao;
	private String ttRa;
	public Xe4Banh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Xe4Banh(String cmnd, String hoten, String gioitinh, String mscanho, String mauson, Date timeVao,
			Date timeRa, String bSX, String ttVao, String ttRa) {
		super(cmnd, hoten, gioitinh, mscanho, mauson, timeVao, timeRa);
		// TODO Auto-generated constructor stub
		BSX = bSX;
		this.ttVao = ttVao;
		this.ttRa = ttRa;
	}
	
	@Override
    public int tinhTien() {
        // Các xử lý tính tiền đỗ xe cho xe ở đây
        return 0;
    }

//	public String getBSX() {
//		return BSX;
//	}
	
	@Override
	public String getBienSoXe() {
		return BSX;
	}
	public void setBSX(String bSX) {
		BSX = bSX;
	}
//	public String getTtVao() {
//		return ttVao;
//	}
	
	@Override
	public String getTinhTrangVaoBai() {
		// TODO Auto-generated method stub
		return ttVao;
	}
	public void setTtVao(String ttVao) {
		this.ttVao = ttVao;
	}
//	public String getTtRa() {
//		return ttRa;
//	}
	
	@Override
	public String getTinhTrangRaBai() {
		// TODO Auto-generated method stub
		return ttRa;
	}
	
	public void setTtRa(String ttRa) {
		this.ttRa = ttRa;
	}
	@Override
	public String toString() {
		return "Xe4Banh [BSX=" + BSX + ", ttVao=" + ttVao + ", ttRa=" + ttRa + "]";
	}
	
	@Override
	public String getSoVeXe() {
		// TODO Auto-generated method stub
		return "Not Available";
	}
	
	@Override
	public String getLoaiXe() {
		// TODO Auto-generated method stub
		return "4";
	}
}
