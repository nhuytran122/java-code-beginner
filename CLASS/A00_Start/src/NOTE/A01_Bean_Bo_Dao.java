package NOTE;

public class A01_Bean_Bo_Dao {
//	BEAN: là những class java thường được xây dựng mô phỏng lại 1 cấu trúc bản 
//	dữ liệu trong csdl gồm các cấu trúc getter và setter.
//	Java bean không cần biết sự tồn tại của bất kỳ lớp nào khác,
//	nó chỉ đơn thuần là 1 class thuần java. (chứa hang)
//  Ngược lại, Bo, Dao đều biết đến sự tồn tại của Bean
	
//	DAO(data access object): làm việc trực tiếp với CSDL (Thêm, sửa, xóa), Nó chỉ biết sự tồn tại của java bean.
//  DAO làm việc với BEAN; dùng để get/SAVE List đối tượng từ BEAN thông qua duyệt file/sql
// 	Trả về dsbean (ArrayList<...bean>) khi get...
//  Trả về int khi (Thêm, sửa, xóa):
//	int kq = cmd.executeUpdate();
//	kn.cn.close();
//	return kq;
	
//	BO (business object): là phần xử lý logic của chương trình, là trung gian giữa Controller 
//	và DAO, các lớp khác muốn giao tiếp với csdl phải thông qua trung gian BO.
//	Nó chỉ biết sự tồn tại của DAO và java bean. (chứa arraylist)
//  Xử lí data
//  BO làm việc (get) với BEAN qua DAO
//  Khai báo toàn cục biến __dao, dsbean;
//	hàm get: muốn get gì từ BEAN thì dùng biến __dao để dùng hàm get từ DAO
//  hàm thêm/xóa/sửa: dùng dsbean để add/remove/
	//TÌM

//  View dùng BO, BEAN(ds)
}

