
package bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
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
		//them vao csdl
		nvd.ThemNV(maNV, tenNV, ngaysinh, hsluong, madv);
		return dsbean;	
	}
	
	public ArrayList<NhanVienBean> XoaNV(String MaNV) throws Exception{
		for(NhanVienBean nvb:dsbean) 
			if(nvb.getMaNV().equals(MaNV)) {
				dsbean.remove(nvb);
				nvd.Xoa(MaNV);
				break;
			}
		return dsbean;
	}
	
	public ArrayList<NhanVienBean> CapNhatNV(String manv, String tennv, Date ngaysinh, Double hsl, String madv) throws Exception{
		int n=dsbean.size();
		for(int i=0;i<n;i++)
			if(dsbean.get(i).getMaNV().equals(manv)) {
				NhanVienBean nv = dsbean.get(i);
				nv.setTenNV(tennv);
				nv.setNgaysinh(ngaysinh);
				nv.setHsluong(hsl);
				nv.setMadv(madv);
				dsbean.set(i, nv);//Sua trong bo nho
				nvd.Sua(manv, tennv, ngaysinh, hsl, madv); //Sua trong csdl
				break;
		  }
		  return dsbean;
	}
	
	public void NapFile() throws Exception{
		FileReader f = new FileReader("nhanvien.txt");
		BufferedReader b = new BufferedReader(f);
		while(true) {
			String st=b.readLine();
			if(st==null||st=="") break;
			String[] t=st.split("[;]");
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			Date ns = d.parse(t[2]);
			Double hsluong = Double.parseDouble(t[3]);
			ThemNV(t[0], t[1], ns, hsluong, t[4]);//Them vao csdl
		}
		b.close();
		dsbean = nvd.getNV();
	}
	
	public ArrayList<NhanVienBean> TimMa(String key) throws Exception{
		ArrayList<NhanVienBean> tmp = new ArrayList<NhanVienBean>();
		for(NhanVienBean nv:dsbean) {
			if(nv.getMaNV().toLowerCase().contains(key.toLowerCase()) || nv.getTenNV().toLowerCase().contains(key.toLowerCase()))
					tmp.add(nv);
		}
		return tmp;
	}
//	public void Luu(ArrayList<NhanVienBean> ds) throws Exception{
//		nvd.Luu(ds);
//	}
	
}
