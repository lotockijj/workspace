package eleks.sportclub.helpful;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import dao.DaoAbonTrack;
import dao.DaoBalance;
import dao.DaoClientMySql;
import dao.DaoServTrackMySql;
import eleks.sportclub.Client;
import eleks.sportclub.Gender;

public class Gym {
	private Connection myConn;
	
	public Gym() throws FileNotFoundException, IOException, SQLException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		myConn = DriverManager.getConnection(dburl, user, password);
	}
	
	public static void main(String[] args) throws ParseException, FileNotFoundException, SQLException, IOException{
//		Gym gym = new Gym();
//		Client client1 = new Client("Lotockiy", "Roman", 35, SqlDate.createSqlDate("10-11-1981"),
//				"Lviv", Gender.MAN, false, SqlDate.createSqlDate("02-09-2006"));
//		Client client2 = new Client("Shtoyko", "Vitaliy", 22, 
//				SqlDate.createSqlDate("05-08-1991"),
//				"Boorshtyn", Gender.MAN, false, 
//				SqlDate.createSqlDate("02-08-2017"));
//		Client client3 = new Client("Trenbach", "Kolya", 36, 
//				SqlDate.createSqlDate("31-08-1981"),
//				"Boorshtyn", Gender.MAN, false, 
//				SqlDate.createSqlDate("02-08-2005"));
//		DaoClientMySql daoClient = new DaoClientMySql(gym.myConn);
//		daoClient.addClient(client1);
//		daoClient.addClient(client2);
//		daoClient.addClient(client3);
//		System.out.println("Added.");
		
		/*Client client = new Client("Lotockiy", "Roman", 35, SqlDate.createSqlDate("10-11-1981"),
				"Lviv", Gender.MAN, false, SqlDate.createSqlDate("02-09-2006"));
		Price price = new AbonnementsTo16and12Times();
		client.setPrice(price);
		price = new Sauna(price);
		price = new GeneralMassage(price);
		System.out.println(client.getLastName() + " " + client.getFirstName() + "\n" + 
				"Price: " + client.getPrice().getPrice() +
				"\nDescription: " + price.getDescription() + 
				"\nThe whole price: " + price.getPrice());*/
		/*
		try {
			
			DaoClientMySql client = new DaoClientMySql();
			List<Client> list = client.getAllGoods();
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
			
			
			Client newClient = new Client("Shtoyko", "Vitaliy", 22, 
					SqlDate.createSqlDate("05-08-1991"),
					"Lviv", Gender.MAN, true, 
					SqlDate.createSqlDate("02-09-2006"));
			client.addClient(newClient);
			Client newClient2 = new Client("Shtoyko", "Vitaliy", 22, 
					SqlDate.createSqlDate("05-08-1991"),
					"Boorshtyn", Gender.MAN, false, 
					SqlDate.createSqlDate("02-08-2017"));
			client.updateClient(newClient2, 2);
			client.deleteClient(3);
			System.out.println("Client records successfully deleted.");
			
			DaoAbonTrack abonClient = new DaoAbonTrack();
			AbonnementsTrack track = new AbonnementsTrack();
			track.setBase(true);
			track.setBaseAllDay(true);
			track.setPersonalCoach(true);
			abonClient.updateAbonnementsTrack(track, 2);
			
			DaoServTrack servTrack = new DaoServTrack();
			ServicesTrack track2 = new ServicesTrack();
			track2.setTakeGeneralMassage(true);
			track2.setTakeSolyariy(true);
			track2.setTakeKrosfit(true);
			track2.setTakeYoga(true);
			track2.setNumberVisitsMonthly(12);
			servTrack.updateServicesTrack(track2, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		Gym gym = new Gym();
		DaoClientMySql dao = new DaoClientMySql(gym.myConn);
		List<Client> list = dao.getAllClients();
		printList("List of all clients: ", list);
		
		DaoServTrackMySql track = new DaoServTrackMySql(gym.myConn);
		//System.out.println(track.getServicesTrack(1));
		printList("List of service tracks", track.getAllServicesTracks());
		
		DaoAbonTrack daoAbonTr = new DaoAbonTrack(gym.myConn);
		//System.out.println(daoAbonTr.getAbonnementsTrack(1));
		printList("List of abonnement tracks", daoAbonTr.getAllAbonnementsTracks());
		
		DaoBalance daoBalance = new DaoBalance(gym.myConn);
		//System.out.println("Balance with id = 7: " + daoBalance.getBalance(7));
		printList("Balances", daoBalance.getListBalances());
		
		
	}
	
	private static <T> void printList(String description, List<T> list){
		System.out.println("*** " + description + " ***");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
