package controller;

import factory.DefaltSettings;

public class Game {
	
	public static void main(String[] args) throws InterruptedException {
		DefaltSettings teams = new DefaltSettings();
		BattleArena arena = new BattleArena(teams.getFirstTeam(), teams.getSecondTeam());
		arena.play();
		
		
		
		
		
		
		
//		TeamBuilder teamBuilder = new TeamBuilder.new Builder().addDestroyer().addFighter()
//				.addPortal().addRadar().addRepairer().build();
//		
//		List<Droid> droidsFirstTeam = teamBuilder.getDroids();
//		
//		TeamBuilder teamBuilder2 = new TeamBuilder.Builder().addFighter()
//				.addDestroyer().addPortal().addRadar().addRepairer().build();
//		
//		List<Droid> droidsSecondTeam = teamBuilder2.getDroids();
//		
//		BattleArena arena = new BattleArena(droidsFirstTeam, droidsSecondTeam);
//		arena.play();
		
	}


}
