public class Hello {
	public class World {
		public void m() {
			System.out.println("Hello");
		}
	
	}
public static void main(String[] args) {
		Hello h = new Hello();
		System.out.println("Hello");
		Hello.World w = h.new World();
		w.m();
	}
}
