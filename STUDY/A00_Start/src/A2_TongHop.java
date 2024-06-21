import java.util.Scanner;

public class A2_TongHop {
	public static void main(String[] args) {
		/*		String[] ht = {"Hung", "Lan", "Hoa"};
				for(int i=0; i<ht.length; i++) {
					System.out.println(ht[i]);
				}
				
				//for each
				for(String h : ht) {
					System.out.println(h);
				}

		*/
				// Nhap - xuat
				/*Scanner sc = new Scanner(System.in);
				String tmp = sc.nextLine();
				long n = Long.parseLong(tmp);
				System.out.println(n * n);*/
				try {
					Scanner sc = new Scanner(System.in);
					String tmp = sc.nextLine();
					long n = Long.parseLong(tmp);
					System.out.println(n * n);
				} catch (Exception e) {
					e.printStackTrace();
				}


				// Try catch
				/*try {
					int a = 6, b = 0;
					System.out.println("Tong: ");
					int s = a/b;
					System.out.println(s);
				} catch(Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				System.out.println("Alo");*/
			}
}
