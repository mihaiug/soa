package ro.ucv.inf.soa.ws;

public class HelloClient {

	public static void main(String[] args) {
		HelloWorldService service = new HelloWorldService();
		HelloWorld port = service.getHelloWorldPort();
		
		String guestname = "Mihai";
		System.out.println(port.sayHello(guestname));
	}
}
