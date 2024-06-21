//Nap chong phuong thuc Overloading: cac ham trong cung 1 class, co cung ten, 
//khac tham so truyen vao
public class QuanLy {
	public static void main(String[] args) {
		MyMath mm = new MyMath();
		System.out.println("min(5,5) = "+ mm.timMin(5, 5));
		System.out.println("min(5.5, 6.0) = "+ mm.timMin(5.5, 6.0));
		System.out.println("tinhTong(5,6)= "+mm.tinhTong(5.0, 6.0));
		double arr[] = new double[] {1,2,3,4,5};
		System.out.println("tinhTong(arr)= "+mm.tinhTong(arr));
	}
}
