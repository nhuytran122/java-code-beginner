import java.util.Random;

public class A0_So_nut_BSX {
	public static void main(String[] args) {
		System.out.println("hallo");
		Random r = new Random();
		int sx = r.nextInt(100000);
		System.out.println(sx);
		int s = 0;
		while(sx>0){
			s = s + (sx%10); 
			sx = sx/10;
		}
		System.out.println(s%10);
	}
}
