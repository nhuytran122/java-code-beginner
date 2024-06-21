import java.util.Objects;

public class Ngay {
	private int ngay, thang, nam;

	public Ngay(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		this.ngay = ngay;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(nam, ngay, thang);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ngay other = (Ngay) obj;
		if (nam != other.nam)
			return false;
		if (ngay != other.ngay)
			return false;
		if (thang != other.thang)
			return false;
		return true;
	}
	
	
}