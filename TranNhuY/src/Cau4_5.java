import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;


public class Cau4_5 {

	public void ThemDT(ArrayList<DienThoai> ds) throws Exception{
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sqlcd = "insert into tbl_DTCoDinh(maDt, tenDt, hangSx, gia) values (?, ?, ?, ?)";
			String sqldd = "insert into tbl_DTDiDong(maDt, tenDt, hangSx, gia, timeBaohanh) values (?, ?, ?, ?, ?)";
			PreparedStatement cmdcd = kn.cn.prepareStatement(sqlcd);
			PreparedStatement cmddd = kn.cn.prepareStatement(sqldd);
			for(DienThoai dt : ds) {
				if(dt instanceof DienThoaiCoDinh) {
					cmdcd.setString(1, dt.getMaDt());
					cmdcd.setString(2, dt.getTenDt());
					cmdcd.setString(3, dt.getHangSx());
					cmdcd.setFloat(4, dt.getGia());
					cmdcd.executeUpdate();
				}
				else {
					DienThoaiDD dd = (DienThoaiDD) dt;
					cmddd.setString(1, dd.getMaDt());
					cmddd.setString(2, dd.getTenDt());
					cmddd.setString(3, dd.getHangSx());
					cmddd.setFloat(4, dd.getGia());
					cmddd.setString(5, dd.getTimeBaohanh());
					cmddd.executeUpdate();
				}
			}
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DienThoaiDD> get_TimDTDD(String ten) throws Exception{
		try {
			ArrayList<DienThoaiDD> ds = new ArrayList<DienThoaiDD>();
			//B1: Ket noi vao CSDL
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "select * from tbl_DTDiDong where tbl_DTDiDong.tenDt like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + ten + "%");
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maDt = rs.getString("maDt");
				String tenDt = rs.getString("tenDt");
				String hangSx = rs.getString("hangSx");
				long gia = rs.getLong("gia");
				String timeBaohanh = rs.getString("timeBaohanh");
				ds.add(new DienThoaiDD(maDt, tenDt, hangSx, gia, timeBaohanh));
			} 
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		try {
			KetNoi kn = new KetNoi();
			TestCau3 t3 = new TestCau3();
			Cau4_5 t4 = new Cau4_5();
			kn.ketnoi();
			ArrayList<DienThoai> ds = t3.Napds();
			t4.ThemDT(ds);
			System.out.println("Đã lưu trữ dữ liệu vào database");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhập 1 tên điện thoại di động muốn tìm: ");
			String key = sc.nextLine();
			for(DienThoaiDD dd : t4.get_TimDTDD(key))
				System.out.println(dd);
			if(t4.get_TimDTDD(key).size() == 0)
				System.out.println("Không có điện thoại di động tên " + key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
