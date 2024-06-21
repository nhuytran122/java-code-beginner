
public class A01_1_Tinh {
	public static Double Thuong(double a, double b) throws Exception{
		return a/b;
	}
	
	public double DTB(double...ds) {
		int n = ds.length;
		double s = 0;
		for(int i=0; i<n; i++) {
			s += ds[i];
		}
		return s/n;
	}
	
	public void Xuat(Object...t) {
		for(Object gt:t) {
			System.out.println(gt.toString());
		}
	}
}
