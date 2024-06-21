
public class A1_Bang_nhan_5 {
	public static void main(String[] args) {
		//for(int j=1; j<=10; j++){
			//System.out.println( "5 x " + j + " = " + 5*j);
		//}
		
		for(int i=1; i < 10; i++){
			for(int j=1; j<=10; j++){
				System.out.println( i + " x " + j + " = " + i*j);
			}
			String text = "";
			text = text.replace("\n", "");	
			System.out.println(text);
			
		}
	}
}
