package eleks.sportclub.helpful;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import abonnements.AbonnementsTo16and12Times;
import dao.DaoAbonTrack;
import dao.DaoClientMySql;
import dao.DaoServTrack;
import dao.DaoServicesTrack;
import decorator.Price;
import eleks.sportclub.Client;
import eleks.sportclub.Gender;
import services.AttendingGym;
import services.Fresh;
import services.GeneralMassage;
import services.Krosfit;
import services.OneTimeSlippers;
import services.Sauna;
import services.Solarium;
import services.Towel;
import services.Yoga;
import tracks.AbonnementsTrack;
import tracks.ServicesTrack;

public class Gym {

	public static void main(String[] args) throws ParseException{
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
		Client client = new Client("Lotockiy", "Roman", 35, SqlDate.createSqlDate("10-11-1981"),
				"Lviv", Gender.MAN, false, SqlDate.createSqlDate("02-09-2006"));
		Price price = new AbonnementsTo16and12Times();
		client.setPrice(price);
		price = new Sauna(price);
		price = new GeneralMassage(price);
		price = new Solarium(price);
		price = new Krosfit(price);
		price = new Yoga(price);
		price = new AttendingGym(price);
		price = new Towel(price);
		price = new OneTimeSlippers(price);
		price = new Fresh(price);
		System.out.println(client.getLastName() + " " + client.getFirstName() + "\n" + 
				"Price: " + client.getPrice().getPrice() +
				"\nDescription: " + price.getDescription() + 
				"\nThe whole price: " + price.getPrice());
	}

}
