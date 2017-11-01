package ekkel._17_10_2017;

public class ConnectionManager {
	private static ConnectionManager manager;
	private Connection[] connections;
	private int count = 0;
	
	private ConnectionManager(int numberOfConnection) {
		connections = new Connection[numberOfConnection];
		for (int i = 0; i < numberOfConnection; i++) {
			connections[i] = new Connection(i);
		}
	}
	
	public static ConnectionManager getInstance(int numberOfConnection){
		if(manager == null){
			manager = new ConnectionManager(numberOfConnection);
		}
		return manager;
	}
	
	public Connection getConnection(){
		if(count >= 3){
			return null;
		}
		return connections[count++];
	}
	
	class Connection{
		int id;

		public Connection(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


	}


	public Connection[] getConnections() {
		return connections;
	}


}
