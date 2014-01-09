package kernel.sandbox;

public class SimpleSingleton {
	private static SimpleSingleton singleInstance = null;
	
	//Marking default constructor private 
	//to avoid direct instantiation.
	private SimpleSingleton() {
	}

	//Get instance for class SimpleSingleton
	public static SimpleSingleton getInstance() {
	
		if(null == singleInstance) {
			singleInstance = new SimpleSingleton();
		}
	
		return singleInstance;
	}
	
	public void sayHello(){
		System.out.println("Hola!");
	}
}