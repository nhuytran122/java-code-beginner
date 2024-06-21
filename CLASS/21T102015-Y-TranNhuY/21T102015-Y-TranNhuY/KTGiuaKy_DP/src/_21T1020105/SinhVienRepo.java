package _21T1020105;

import java.util.ArrayList;

public interface SinhVienRepo {
	ArrayList<SinhVien> selectAll();
    void insertStudent(SinhVien x);
    void deleteStudent(String maSV);
}
