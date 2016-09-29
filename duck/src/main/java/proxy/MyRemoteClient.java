package proxy;

import java.rmi.*;

public class MyRemoteClient {

	public static void main(String[] args) {
		
		new MyRemoteClient().go();
	}
	
	public void go() {
		try {
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
//Naming.lookup(“rmi://127.0.0.1/RemoteHello”);The host name or IP address where the service is running.
//This must be the name that the service was registered under - /RemoteHello		
				String s = service.sayHello();
			System.out.println(s);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}