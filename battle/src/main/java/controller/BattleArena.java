package controller;

import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.Droid;

public class BattleArena {
	ObservableList<Droid> groupOne;
	ObservableList<Droid> groupTwo;
	private boolean stopGame;

	public BattleArena(List<Droid> firstTeam, List<Droid> secondTeam){
		initializeFirstTeamAsObservable(firstTeam);
		initializeSecondTeamAsObservable(secondTeam);
	}
	
	private void initializeFirstTeamAsObservable(List<Droid> firstTeam) {
		groupOne = FXCollections.observableList(firstTeam);
		groupOne.addListener((ListChangeListener<Droid>) change -> {
			if(!checkGroupForFlag(groupOne)){
				System.err.println("First team lost: " + groupOne.toString() + 
						"\n" + "Second team won" +  groupTwo.toString());
				stopGame = true;
			}
		});
	}
	
	private void initializeSecondTeamAsObservable(List<Droid> secondTeam) {
		groupTwo = FXCollections.observableList(secondTeam);
		groupTwo.addListener((ListChangeListener<Droid>) change -> {
			if(!checkGroupForFlag(groupTwo)){
				System.err.println("Second team lost: " + groupTwo.toString() + 
						"\n" + "First team won: " + groupOne.toString());
				stopGame = true;
			}
		});
	}

	private boolean checkGroupForFlag(List<Droid> list) {
		boolean hasFlag = false;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getFlag() == true){
				hasFlag = true;
				break;
			} 
		}
		return hasFlag;
	}
	
	public void play() throws InterruptedException{
		Random r = new Random();
		int countRound = 0;
		while(!stopGame){
			countRound++;
			Thread.sleep(350);
			System.out.println("***** ROUND " + countRound + " *****");
			Thread.sleep(350);
			groupTwo.get(r.nextInt(groupTwo.size())).performance(groupOne);
			Thread.sleep(350);
			groupOne.get(r.nextInt(groupOne.size())).performance(groupTwo);
		}
	}
	
}
