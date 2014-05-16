package mijiang.test;

public class FunTest {
	
	static interface Fruit{
		public String favor();
	}
	
	static class Apple implements Fruit{
		public String favor() {
			return "sweet apple";
		}
	}
	
	static class Banana implements Fruit{
		public String favor(){
			return "sweet banana";
		}
	}
	
	static class Human{
		public <F extends Fruit> void eat(F f){
			System.out.println(f.favor());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Human a = new Human();
		a.eat(new Apple());
		a.eat(new Banana());
	}

}
