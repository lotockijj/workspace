import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class EightQueens {

	public class Field implements Comparable<Field>{

		public String colon;
		public int row;
		public int numberField;

		public Field(String colon, int row, int numberField){
			this.colon = colon;
			this.row = row;
			this.numberField = numberField;
		}

		public String toString(){
			return this.colon + this.row + " " + this.numberField;
		}

		@Override
		public int compareTo(Field o) {
			DeskOfFields deskOfFields = new DeskOfFields();
			return Arrays.asList(deskOfFields.colon).indexOf(this.colon) 
					- Arrays.asList(deskOfFields.colon).indexOf(o.colon);
		}
		
		

	}

	public class DeskOfFields{

		String[] colon = {"a", "b", "c", "d", "e", "f", "g", "h"};
		int[] row = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] numberField = new int[64];
		LinkedList<Field> chessDesk = new LinkedList<>();
		int count = 0;

		public void setNumberField(){
			for(int i = 0; i < numberField.length; i++){
				numberField[i] = i;
			}
		}

		public  LinkedList<Field> setChessDesk(){
			setNumberField();
			for(int j = 0; j < row.length; j++){
				for(int i = 0; i < colon.length; i++){
					Field f = new Field(colon[i], row[j], numberField[count++]);
					chessDesk.add(f);
				}
			}
			return chessDesk; 
		}
	}

	public class Queens{

		EightQueens gueenPlase = new EightQueens();
		DeskOfFields deskFilds = new DeskOfFields();
		LinkedList<Field> desk = new LinkedList<>();
		Random randomGenerator = new Random();

		public void setEightQueens(){
			desk = deskFilds.setChessDesk();
			Field[] placesQueen = new Field[8];
			Field placeQueen; 
			int count = 0; 

			while(true){
				int randomInt = randomGenerator.nextInt(desk.size());
				placeQueen = desk.get(randomInt);
				System.out.println("Queen - " + placeQueen);
				placesQueen[count] = placeQueen;

				for(int j = 0; j < desk.size()-1; j++){//remove
					if(desk.get(j).compareTo(desk.get(randomInt)) == 0){
						System.out.println("REMOVE - " + desk.get(j));
						desk.remove(j);
						j = 0;
					}
				}
				count++;
				if(count == 8){
					for(int j1 = 0; j1 < placesQueen.length; j1++){
						System.out.println(placesQueen[j1]);
					}
					break;
				} else{
					continue;
				}
			}

		}
	}
	public static void main(String[] args){
		EightQueens e = new EightQueens();
		Queens queens = e.new Queens();
		queens.setEightQueens();
	}

}
