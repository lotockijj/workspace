package model;

import java.util.List;

import state.Aim;
import state.Position;

public abstract class Droid{
	private String name;
	private int health;
	private int energy;
	private int power;
	private int price;
	private boolean flag;
	private Aim aim;
	private Position position;
	
	public Droid(String name, int health, int energy, int power, int price) {
		this.name = name;
		this.health = health;
		this.energy = energy;
		this.power = power;
		this.price = price;
	}
	
	public abstract void performance(List<Droid> droids);
	
	public void getShot(int power) {
		setHealth(getHealth() - power); 
	}

	public void deleteDroidWithHealthBelowZero(List<Droid> droids, int position){
		if(droids.get(position).getHealth() <= 0){
			droids.remove(droids.get(position));
		}
	}
	
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getEnergy() {
		return energy;
	}

	public int getPower() {
		return power;
	}

	public int getPrice() {
		return price;
	}
	
	public boolean getFlag(){
		return flag;
	}
	
	public Aim getAim(){
		return aim;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	
	public void setAim(Aim aim){
		this.aim = aim;
	}
	
	public void setPosition(Position position){
		this.position = position;
	}

	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		strB.append(name);
		if(flag){
			strB.append("(").append(flag).append(")");
		}
		return strB.toString();
	}

	public void setDroids(List<Droid> firstTeam) {
	}
	
}
