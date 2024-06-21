public class QuanLy {	
	public static void main(String[] args) {		
		System.out.println("Kiểm tra");
		//Ke thua nhieu tang
		BabyDog bbd = new BabyDog();		
		bbd.eat();		
		bbd.bark();		
		bbd.weep();	
		
		// Ke thua don
		Dog d = new Dog();		
		d.eat();		
		d.bark();				
		
		Cat c = new Cat();		
		c.eat();		
		c.meow();				
		
		Bird b = new Bird();		
		b.eat();		
		b.fly();	
	}
}  