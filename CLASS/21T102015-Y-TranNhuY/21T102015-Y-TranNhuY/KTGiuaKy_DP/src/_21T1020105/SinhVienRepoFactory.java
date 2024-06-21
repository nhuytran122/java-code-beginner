package _21T1020105;

public class SinhVienRepoFactory {
	public SinhVienRepo createSinhVienRepo(CauHinh cfg) {
        if (cfg.getLoaiNguon().equals("TEXT_FILE")) {
            return new SinhVienRepoTEXT();
        } else if (cfg.getLoaiNguon().equals("MS_SQLSERVER")) {
            return new SinhVienRepoSQL();
        }
        return null;
    }
}
