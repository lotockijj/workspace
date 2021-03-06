package factory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Destroyer;
import model.Droid;
import model.Fighter;
import model.Portal;
import model.Radar;
import model.Repairer;
import state.Aim;

public class DefaltSettings {
	List<Droid> firstTeam;
	List<Droid> secondTeam;
	
	public DefaltSettings(){
		firstTeam = new LinkedList<>();
		secondTeam = new LinkedList<>();
		initializeTeams();
	}
	
	private void initializeTeams(){
		initializeFirstTeam();
		initializeSecondTeam();
		setFlags();
	}

	private void initializeFirstTeam() {
		for (int i = 1; i < 20; i++) {
			String n = Integer.toString(i);
			firstTeam.add(new Fighter(n, 4, 10, 2, 1));
		}
		firstTeam.add(new Destroyer("Destroyer first team" , 4, 10, 2, 1));
		Droid radar = new Radar("Radar first team", 4, 10, 2, 5);
		radar.setDroids(firstTeam);
		firstTeam.add(radar);
		Droid portal = new Portal("Portal first team", 10, 10, 10, 10);
		portal.setDroids(firstTeam);
		firstTeam.add(portal);
		Droid repairer = new Repairer("Repairer", 10, 10, 10, 10);
		repairer.setDroids(firstTeam);
		firstTeam.add(repairer);
		Aim aim = new Aim();
		for (int i = 0; i < firstTeam.size(); i++) {
			firstTeam.get(i).setAim(aim);
		}
	}
	
	private void initializeSecondTeam(){
		for (int i = 21; i < 40; i++) {
			String n = Integer.toString(i);
			secondTeam.add(new Fighter(n, 4, 10, 2, 1));
		}
		secondTeam.add(new Destroyer("Destroyer second team" , 4, 10, 2, 1));
		Radar radar = new Radar("Radar second team", 4, 10, 2, 5);
		radar.setDroids(secondTeam);
		secondTeam.add(radar);
		Portal portal = new Portal("Portal first team", 10, 10, 10, 10);
		portal.setDroids(secondTeam);
		secondTeam.add(portal);
		Repairer repairer = new Repairer("Repairer", 10, 10, 10, 10);
		repairer.setDroids(secondTeam);
		secondTeam.add(repairer);
		Aim aim = new Aim();
		for (int i = 0; i < secondTeam.size(); i++) {
			secondTeam.get(i).setAim(aim);
		}
	}

	private void setFlags() {
		Random r = new Random();
		int position = r.nextInt(firstTeam.size());
		firstTeam.get(position).setFlag(true);
		position = r.nextInt(secondTeam.size());
		secondTeam.get(position).setFlag(true);
	}
	
	public List<Droid> getFirstTeam() {
		return firstTeam;
	}
	
	public List<Droid> getSecondTeam() {
		return secondTeam;
	}
	
}
