package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.NhanVienBean;
import dao.NhanVienDao;

public class NhanVienBo {
	NhanVienDao nvd = new NhanVienDao();
	ArrayList<NhanVienBean> dsbean;
	public ArrayList<NhanVienBean> getNV() throws Exception{
		dsbean = nvd.getNV();
		return dsbean;
	}
	
	public ArrayList<NhanVienBean> ThemNV(String maNV, String tenNV, Date ngaysinh, Double hsluong, String madv) throws Exception{
		for(NhanVienBean nvb:dsbean) 
			if(nvb.getMaNV().toLowerCase().trim().equals((maNV).toLowerCase().trim()))
				return null;
		dsbean.add(new NhanVienBean(maNV, tenNV, ngaysinh, hsluong, madv));
		return dsbean;	
	}
	
	public ArrayList<NhanVienBean> XoaNV(String MaNV) throws Exception{
		for(NhanVienBean nvb:dsbean) 
			if(nvb.getMaNV().equals(MaNV)) {
				dsbean.remove(nvb);
				break;
			}
		return dsbean;
	}
	
	public ArrayList<NhanVienBean> CapNhatNV(String maNV, String tenNV, Date ngaysinh, Double hsluong, String madv) throws Exception{
		for(NhanVienBean nvb:dsbean) {
			if(nvb.getMaNV().equals(maNV)) {
				nvb.setTenNV(tenNV);
				nvb.setNgaysinh(ngaysinh);
				nvb.setHsluong(hsluong);
				nvb.setMadv(madv);
			}
		}
		return dsbean;
	}
	public void Luu(ArrayList<NhanVienBean> ds) throws Exception{
		nvd.Luu(ds);
	}
	
}
